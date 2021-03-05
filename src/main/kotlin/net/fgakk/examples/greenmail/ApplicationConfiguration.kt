package net.fgakk.examples.greenmail

import org.apache.velocity.app.VelocityEngine
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class ApplicationConfiguration {

    @Bean
    fun velocityEngine(): VelocityEngine {
        val props = Properties()
        props["resource.loader"] = "class"
        props["class.resource.loader.class"] = "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader"
        return VelocityEngine(props)
    }
}