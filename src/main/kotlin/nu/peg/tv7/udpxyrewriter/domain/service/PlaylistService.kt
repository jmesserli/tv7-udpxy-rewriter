package nu.peg.tv7.udpxyrewriter.domain.service

import nu.peg.tv7.udpxyrewriter.domain.repository.PlaylistRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlaylistService
@Autowired
constructor(
        private val playlistRepository: PlaylistRepository
) {
    companion object {
        private val PLAYLIST_ENTRY = Regex("^udp://@(.*)$", RegexOption.MULTILINE)
    }

    fun rewritePlaylist(https: Boolean, udpxyHost: String, udpxyPort: Int): String {
        val playlist = playlistRepository.getPlaylist()

        return PLAYLIST_ENTRY.replace(playlist) {
            "http${if (https) "s" else ""}://$udpxyHost:$udpxyPort/udp/${it.groups[1]!!.value}"
        };
    }
}