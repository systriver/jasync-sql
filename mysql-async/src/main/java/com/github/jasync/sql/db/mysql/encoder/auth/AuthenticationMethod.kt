package com.github.jasync.sql.db.mysql.encoder.auth

import java.nio.charset.Charset

interface AuthenticationMethod {

    fun generateAuthentication(charset: Charset, password: String?, seed: ByteArray): ByteArray

    companion object {
        const val CachingSHA2 = "caching_sha2_password"
        const val SHA256 = "sha256_password"
        const val Native = "mysql_native_password"
        const val Old = "mysql_old_password"

        val Availables = mapOf(
            CachingSHA2 to CachingSHA2PasswordAuthentication,
            SHA256 to SHA256PasswordAuthentication,
            Native to MySQLNativePasswordAuthentication,
            Old to OldPasswordAuthentication
        )
    }
}
