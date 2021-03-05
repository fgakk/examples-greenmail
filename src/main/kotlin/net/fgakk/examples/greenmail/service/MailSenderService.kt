package net.fgakk.examples.greenmail.service

import org.apache.velocity.VelocityContext
import org.apache.velocity.app.VelocityEngine
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Component
import java.io.StringWriter

@Component
class MailSenderService {

    @Autowired
    lateinit var javaMailSender: JavaMailSender

    @Autowired
    lateinit var velocityEngine: VelocityEngine

    fun sendMail(subject: String, name: String, mailTo: String, message: String) {

        val mimeMessage = javaMailSender.createMimeMessage()
        val mimeMessageHelper = MimeMessageHelper(mimeMessage)

        mimeMessageHelper.setFrom("test@fgakk.net")
        mimeMessageHelper.setSubject(subject)
        mimeMessageHelper.setTo(mailTo)

        val template = velocityEngine.getTemplate("./templates/mail-template.vm")

        val velocityContext = VelocityContext()
        velocityContext.put("name", name)
        velocityContext.put("message", message)
        velocityContext.put("link", "https://github.com/fgakk")

        val stringWriter = StringWriter()

        template.merge(velocityContext, stringWriter)

        mimeMessageHelper.setText(stringWriter.toString(), true)

        javaMailSender.send(mimeMessage)
    }
}