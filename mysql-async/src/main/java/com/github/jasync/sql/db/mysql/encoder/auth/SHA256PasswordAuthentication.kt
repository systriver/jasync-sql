package com.github.jasync.sql.db.mysql.encoder.auth

import java.nio.charset.Charset

object SHA256PasswordAuthentication : AuthenticationMethod {

    private val EmptyArray = ByteArray(0)

    override fun generateAuthentication(charset: Charset, password: String?, seed: ByteArray): ByteArray {

        return if (password != null) {
            encryptRSA(charset, password, seed)
        } else {
            EmptyArray
        }
    }

    private fun encryptRSA(
        charset: Charset,
        password: String,
        seed: ByteArray
    ): ByteArray {
        // TODO: Return the password encrypted with public key
        return ByteArray(0)
    }
}
