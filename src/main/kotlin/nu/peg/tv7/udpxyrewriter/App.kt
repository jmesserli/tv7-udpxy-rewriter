package nu.peg.tv7.udpxyrewriter

import nu.peg.tv7.udpxyrewriter.infrastructure.config.Tv7Properties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@EnableConfigurationProperties(value = [Tv7Properties::class])
@SpringBootApplication
class App

fun main(args: Array<String>) {
    runApplication<App>(*args)
}
