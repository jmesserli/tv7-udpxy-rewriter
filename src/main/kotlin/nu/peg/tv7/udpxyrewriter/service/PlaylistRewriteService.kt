package nu.peg.tv7.udpxyrewriter.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlaylistRewriteService
@Autowired
constructor(
        private val playlistGetService: PlaylistGetService
) {
    companion object {
        private val PLAYLIST_ENTRY = Regex("^udp://@(.*)$", RegexOption.MULTILINE)
    }

    fun rewritePlaylist(https: Boolean, udpxyHost: String, udpxyPort: Int): String {
        val playlist = playlistGetService.getPlaylist()

        return PLAYLIST_ENTRY.replace(playlist, {
            "http${if (https) "s" else ""}://$udpxyHost:$udpxyPort/udp/${it.groups[1]!!.value}"
        });
    }
}