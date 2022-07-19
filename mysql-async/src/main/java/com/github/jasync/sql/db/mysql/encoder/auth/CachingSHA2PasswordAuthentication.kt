package com.github.jasync.sql.db.mysql.encoder.auth

import com.github.jasync.sql.db.util.length
import java.nio.charset.Charset
import java.security.MessageDigest
import kotlin.experimental.xor

object CachingSHA2PasswordAuthentication : AuthenticationMethod {

    private val EmptyArray = ByteArray(0)

    override fun generateAuthentication(charset: Charset, password: String?, seed: ByteArray): ByteArray {

        return if (password != null) {
            scrambleSHA256(charset, password, seed)
        } else {
            EmptyArray
        }
    }

    private fun scrambleSHA256(charset: Charset, password: String, seed: ByteArray): ByteArray {

        val messageDigest = MessageDigest.getInstance("SHA-256")
        val initialDigest = messageDigest.digest(password.toByteArray(charset))

        messageDigest.reset()

        val finalDigest = messageDigest.digest(initialDigest)

        messageDigest.reset()

        messageDigest.update(seed)
        messageDigest.update(finalDigest)

        val result = messageDigest.digest()
        var counter = 0

        while (counter < result.length) {
            result[counter] = (result[counter] xor initialDigest[counter])
            counter += 1
        }

        return result
    }
}
