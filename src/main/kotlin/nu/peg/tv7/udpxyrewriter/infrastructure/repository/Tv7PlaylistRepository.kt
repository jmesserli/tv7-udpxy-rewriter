package nu.peg.tv7.udpxyrewriter.infrastructure.repository

import nu.peg.tv7.udpxyrewriter.domain.repository.PlaylistRepository
import nu.peg.tv7.udpxyrewriter.infrastructure.config.Tv7Properties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class Tv7PlaylistRepository
@Autowired
constructor(
        private val restTemplate: RestTemplate,
        private val tv7Properties: Tv7Properties
) : PlaylistRepository {

    @Cacheable("playlist")
    override fun getPlaylist(): String {
        val response = restTemplate.getForEntity(tv7Properties.playlistUrl, String::class.java)
        return response.body!!
    }
}