package nu.peg.tv7.udpxyrewriter.infrastructure.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "tv7")
data class Tv7Properties(
        val playlistUrl: String
)
