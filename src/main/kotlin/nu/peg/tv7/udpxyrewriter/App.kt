package nu.peg.tv7.udpxyrewriter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class App

fun main(args: Array<String>) {
    runApplication<App>(*args)
}
