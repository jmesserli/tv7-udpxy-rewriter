# tv7-udpxy-rewriter

API which rewrites the Fiber7 TV7 playlist for use with udpxy

## How it works

Gets the current TV7 playlist from [https://api.init7.net/tvchannels.m3u](https://api.init7.net/tvchannels.m3u)
and rewrites each playlist entry so that it points to your udpxy instance.

So this:

```
udp://@239.77.0.77:5000
```

Turns into this:

```
http://your-udpxy.host:your-udpxy-port/udp/239.77.0.77:5000
```

## How to use

Point your player (e.g. VLC) to:

```
https://tv7.pegnu.dev?udpxyHost=<host>&udpxyPort=<port>&https=false
```

Replace:

* `<host>` (required): The hostname/ip of your udpxy instance
* `<port>` (optional, default `4022`): The port your udpxy is listening on
* `<https>` (optional, default `false`): Whether your udpxy is listening on https (`true` / `false`)
