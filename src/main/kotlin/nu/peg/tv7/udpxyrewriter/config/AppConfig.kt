package nu.peg.tv7.udpxyrewriter.config

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.web.client.RestTemplate
import java.nio.charset.Charset

@Configuration
class AppConfig {
    @Bean
    fun restTemplate(): RestTemplate {
        val converter = StringHttpMessageConverter(Charset.forName("UTF-8"))

        return RestTemplateBuilder()
                .additionalMessageConverters(converter)
                .setConnectTimeout(5000)
                .setReadTimeout(5000)
                .build()
    }
}