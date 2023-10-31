package nu.peg.tv7.udpxyrewriter.infrastructure.config

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.web.client.RestTemplate
import java.nio.charset.StandardCharsets
import java.time.Duration
import java.time.temporal.ChronoUnit

@Configuration
class RestTemplateConfig {
    @Bean
    fun restTemplate(): RestTemplate {
        val converter = StringHttpMessageConverter(StandardCharsets.UTF_8)

        return RestTemplateBuilder()
                .additionalMessageConverters(converter)
                .setConnectTimeout(Duration.of(5, ChronoUnit.SECONDS))
                .setReadTimeout(Duration.of(5, ChronoUnit.SECONDS))
                .build()
    }
}