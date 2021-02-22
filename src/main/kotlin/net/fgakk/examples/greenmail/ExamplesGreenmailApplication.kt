package net.fgakk.examples.greenmail

import net.fgakk.examples.greenmail.ExamplesGreenmailApplication.ExamplesGreenmailApplication.log
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication
class ExamplesGreenmailApplication : CommandLineRunner {

    override fun run(vararg args: String?) {
        var running = true
        val scanner = Scanner(System.`in`)
        while (running) {
            println("------Sending a new mail-----")
            println("Enter subject: ")
            val subject = scanner.nextLine()
            println("Subject: $subject")
            println("Enter recipient: (This example supports only a single recipient)")
            val mailTo = scanner.nextLine()
            println("recipient $mailTo")
            println("Enter the message you want to send:")
            val message = scanner.nextLine()
            println(message)
            val isMailTobeSent = sendMailPrompt(scanner, subject, mailTo, message)
            if (isMailTobeSent) {
                sendMail()
            } else {
                println("Mail will not be sent")
            }
            running = exitPrompt(scanner)
        }
    }

    private fun sendMail() {
        TODO("Not yet implemented")
    }

    private fun sendMailPrompt(scanner: Scanner, subject: String, mailTo: String, message: String): Boolean {
        println("----Summary----")
        println("Subject: $subject")
        println("Recipient: $mailTo")
        println("Message $message")
        println("Do you wish to send this a mail y/n")
        val answer = scanner.nextLine()
        return when (answer.toLowerCase()) {
            "n" -> false
            "y" -> true
            else -> {
                println("Wrong input enter either y or n")
                sendMailPrompt(scanner, subject, mailTo, message)
            }
        }
    }

    fun exitPrompt(scanner: Scanner): Boolean {
        println("Do you wish to continue y/n")
        val answer = scanner.nextLine()
        return when (answer.toLowerCase()) {
            "n" -> false
            "y" -> true
            else -> {
                println("Wrong input enter either y or n")
                exitPrompt(scanner)
            }
        }
    }

    companion object ExamplesGreenmailApplication {
        val log: Logger = LoggerFactory.getLogger(net.fgakk.examples.greenmail.ExamplesGreenmailApplication::class.java)
    }
}

fun main(args: Array<String>) {
    log.info("Starting sample mail application")
    runApplication<ExamplesGreenmailApplication>(*args)
    log.info("Sample mail application stopped")
}
