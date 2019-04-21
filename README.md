# KaratekCore
KaratekCore is a Spigot Plugin, designed to run on the GamelMC Minecraft Server.
At the moment, there aren't any ways to configure it, but I'm working on that.
## Commands
At the moment, the following Commands are working:
* /chatclear and /cc (Permission: karatek.chatclear) allows you to clear the Chat
* /globalmute (Permission: karatek.globalmute) allows you to disable/enable the chat
* /kopf (Permission: karatek.head) gives you the head of the givven player.
* /kv (Permission: karatek.dev) Vanishes you -> Only for development purposes!
* /test prints "Hallo Welt!"
* /server (Permission karatek.server) emulats the BungeeCord command /server.

## Listener
The following listener are working at the moment:
* ChatListener (AsyncPlayerChatEvent) : Changes the ChatLayout and adds a TeamChat
* GlobalMuteListener (AsyncPlayerChatEvent) : Prevents Players form writing while the chat is diabled via /globalmute.
* KickEvent (PlayerKickEvent), PlayerEventJoin(PlayerJoinEvent) and PlayerQuitEvent (PlayerQuitEvent): changes the login and quit messages and changes the Players rank on Join.
* SignListener (SignChangeEvent): Allows user to write in colour on signs.
* ScoreBoard (PlayerJoinEvent): Displays a ScoreBoard

## Dependencies
* PermissionsEX : needed for Ranks
* sTabliist: needed for Ranks (Example Comfig is in a seperate branche)
