package net.fgakk.examples.greenmail.api

import net.fgakk.examples.greenmail.service.MailSenderService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MailSenderController(val mailSenderService: MailSenderService) {


    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun sendMail(@RequestBody request: MailSendRequest) {
        mailSenderService.sendMail(
            request.subject,
            request.nameToAddress,
            request.mailTo,
            request.message
        )
    }
}