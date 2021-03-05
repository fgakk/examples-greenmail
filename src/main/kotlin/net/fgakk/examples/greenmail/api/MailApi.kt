package net.fgakk.examples.greenmail.api

data class MailSendRequest(
    val subject: String,
    val nameToAddress: String,
    val mailTo: String,
    val message: String
)
