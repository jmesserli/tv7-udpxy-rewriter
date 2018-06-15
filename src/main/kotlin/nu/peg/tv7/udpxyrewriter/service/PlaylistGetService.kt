package nu.peg.tv7.udpxyrewriter.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class PlaylistGetService
@Autowired
constructor(
        private val restTemplate: RestTemplate
) {
    companion object {
        private const val PLAYLIST_URL = "https://api.init7.net/tvchannels.m3u"
    }

    @Cacheable("playlist")
    fun getPlaylist(): String {
        val response = restTemplate.getForEntity(PLAYLIST_URL, String::class.java)
        return response.body!!
    }
}