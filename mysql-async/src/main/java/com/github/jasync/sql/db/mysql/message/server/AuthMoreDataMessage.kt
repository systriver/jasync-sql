package com.github.jasync.sql.db.mysql.message.server

data class AuthMoreDataMessage(
    val isAuthDone: Boolean
) : ServerMessage(AuthMoreData)
