# KaratekCore
![Version](https://img.shields.io/github/release-pre/KaratekHD/KaratekCore.svg?style=flat-square)
![Spigot](https://img.shields.io/badge/Plugin-Spigot-yellow.svg?style=flat-square)

KaratekCore is a Spigot Plugin, designed to run on the GamelMC Minecraft Server.
At the moment, there aren't any ways to configure it, but I'm working on that.
## Commands
At the moment, the following Commands are working:
* /chatclear and /cc: allows you to clear the Chat
* /globalmute: allows you to disable/enable the chat
* /kopf: gives you the head of the givven player.
* /kv: Vanishes you -> Only for development purposes!
* /test: prints "Hallo Welt!"
* /server: emulates the BungeeCord command /server.

## Listener
The following listener are working at the moment:
* ChatListener (AsyncPlayerChatEvent) : Changes the ChatLayout and adds a TeamChat
* GlobalMuteListener (AsyncPlayerChatEvent) : Prevents Players form writing while the chat is diabled via /globalmute.
* KickEvent (PlayerKickEvent), PlayerEventJoin(PlayerJoinEvent) and PlayerQuitEvent (PlayerQuitEvent): changes the login and quit messages and changes the Players rank on Join.
* SignListener (SignChangeEvent): Allows user to write in colour on signs.
* ScoreBoard (PlayerJoinEvent): Displays a ScoreBoard

## Chat Actions
Chat Actions are simple Listeners, who react if you begin your Message with a special key word. The following ChatActions are possible:
* @team Message will only be sended to team members
* @bc Message will be sended without the Players name to every Player on the server.
## Dependencies
* [PermissionsEX](https://github.com/PEXPlugins/PermissionsEx/) : needed for Ranks
* [sTabliist](https://github.com/DevJul1an/sTablist): needed for Ranks (Example Comfig is in this [Gist](https://gist.github.com/KaratekHD/65ae1c9e6ed668e3ea4a66ce21a78a09) )

## Installation Guide
1. Install Spigot 1.8.x
2. Go to your plugins folder
3. drag the .jar into it
4. restart/reload the server
