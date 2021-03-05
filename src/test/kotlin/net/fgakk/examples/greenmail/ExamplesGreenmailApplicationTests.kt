package net.fgakk.examples.greenmail

import com.icegreen.greenmail.junit5.GreenMailExtension
import com.icegreen.greenmail.util.ServerSetupTest
import net.fgakk.examples.greenmail.service.MailSenderService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles(profiles = ["test"])
class ExamplesGreenmailApplicationTests {

    companion object ExamplesGreenmailApplicationTests {

        @RegisterExtension
        @JvmField // without this annotation the value is generated  as private and extension cannot be registered
        var greenMail = GreenMailExtension(ServerSetupTest.SMTP)
    }

    @Autowired
    lateinit var mailSenderService: MailSenderService

    @Test
    @DisplayName("Simple mail send test")
    fun testSendEmail() {
        mailSenderService.sendMail("Test Subject", "Bob", "bobb@example.net", "This is a test mail")
        val receivedMessages = greenMail.receivedMessages
        val receivedMessage = receivedMessages[0]
        assertEquals("Test Subject", receivedMessage.subject)
        assertEquals("bobb@example.net", receivedMessage.allRecipients[0].toString())
    }

    @Test
    @DisplayName("Check mail content")
    fun testMailContent() {
        // TODO impement the test with jsoup
    }
}
