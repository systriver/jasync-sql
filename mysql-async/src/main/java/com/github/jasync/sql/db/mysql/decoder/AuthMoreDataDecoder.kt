package com.github.jasync.sql.db.mysql.decoder

import com.github.jasync.sql.db.mysql.message.server.AuthMoreDataMessage
import com.github.jasync.sql.db.mysql.message.server.ServerMessage
import io.netty.buffer.ByteBuf

class AuthMoreDataDecoder : MessageDecoder {

    private val authDone = 0x03.toByte()

    override fun decode(buffer: ByteBuf): ServerMessage {
        val authData = buffer.readByte()
        return AuthMoreDataMessage(authData == authDone)
    }
}
