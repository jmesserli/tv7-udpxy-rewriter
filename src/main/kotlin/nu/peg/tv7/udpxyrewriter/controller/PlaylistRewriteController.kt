package nu.peg.tv7.udpxyrewriter.controller

import nu.peg.tv7.udpxyrewriter.service.PlaylistRewriteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PlaylistRewriteController
@Autowired
constructor(
        private val playlistRewriteService: PlaylistRewriteService
) {
    @GetMapping("/", produces = ["audio/mpegurl"])
    fun rewrite(
            @RequestParam("udpxyHost", required = true) udpxyHost: String,
            @RequestParam("udpxyPort", required = false, defaultValue = "4022") udpxyPort: Int,
            @RequestParam("https", required = false, defaultValue = "false") https: Boolean
    ): String {
        return playlistRewriteService.rewritePlaylist(https, udpxyHost, udpxyPort)
    }
}