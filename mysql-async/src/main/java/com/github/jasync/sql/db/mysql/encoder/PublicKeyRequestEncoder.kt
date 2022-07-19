package com.github.jasync.sql.db.mysql.encoder

import com.github.jasync.sql.db.mysql.message.client.ClientMessage
import com.github.jasync.sql.db.util.ByteBufferUtils
import io.netty.buffer.ByteBuf

class PublicKeyRequestEncoder : MessageEncoder {

    override fun encode(message: ClientMessage): ByteBuf {
        val buffer = ByteBufferUtils.mysqlBuffer(1)
        buffer.writeByte(message.kind)
        return buffer
    }
}
