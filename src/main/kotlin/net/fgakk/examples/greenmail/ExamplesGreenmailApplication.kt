package net.fgakk.examples.greenmail

import net.fgakk.examples.greenmail.ExamplesGreenmailApplication.ExamplesGreenmailApplication.log
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExamplesGreenmailApplication {

    companion object ExamplesGreenmailApplication {
        val log: Logger = LoggerFactory.getLogger(net.fgakk.examples.greenmail.ExamplesGreenmailApplication::class.java)
    }
}

fun main(args: Array<String>) {
    log.info("Starting sample mail application")
    runApplication<ExamplesGreenmailApplication>(*args)
    log.info("Sample mail application stopped")
}
