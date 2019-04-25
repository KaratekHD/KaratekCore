# KaratekCore
![TESTING](https://img.shields.io/badge/TESTING%20VERSION-UNSTABLE-critical.svg?style=flat-square&logo=java)
![Version](https://img.shields.io/github/release-pre/KaratekHD/KaratekCore.svg?style=flat-square)
![Spigot](https://img.shields.io/badge/Plugin-Spigot-yellow.svg?style=flat-square)

WARNING! THIS IS THE INSTABLE PART AND ONLY FOR TESTING PURPOSES!

KaratekCore is a Spigot Plugin, designed to run on the GamelMC Minecraft Server.
At the moment, there aren't any ways to configure it, but I'm working on that.

## Commands
At the moment, the following Commands are working:
* `/chatclear` and `/cc`: allows you to clear the Chat
* `/globalmute`: allows you to disable/enable the chat
* `/kopf`: gives you the head of the givven player.
* `/kv`: Vanishes you -> Only for development purposes!
* `/test`: prints "Hallo Welt!"
* `/server`: emulates the BungeeCord command /server.
* `/rank <Player> <Rank>` : Changes the Player Rank.
* `/crash <Player>` : Crashes the Players client (experimental!).

## Listener
The following listener are working at the moment:
* ChatListener (AsyncPlayerChatEvent) : Changes the ChatLayout and adds a TeamChat
* GlobalMuteListener (AsyncPlayerChatEvent) : Prevents Players form writing while the chat is diabled via /globalmute.
* KickEvent (PlayerKickEvent), PlayerEventJoin(PlayerJoinEvent) and PlayerQuitEvent (PlayerQuitEvent): changes the login and quit messages and changes the Players rank on Join.
* SignListener (SignChangeEvent): Allows user to write in colour on signs.
* ScoreBoard (PlayerJoinEvent): Displays a ScoreBoard

## Chat Actions
Chat Actions are simple Listeners, who react if you begin your Message with a special key word. Example:
`@team Hello World!`

The following ChatActions are possible:
* `@team`: Message will only be sended to team members
* `@bc`: Message will be sended without the Players name to every Player on the server.

## Permissions
* karatek.chatclear -> needed for `/cc` and `/chatclear`
* karatek.globalmute -> needed for `/globalmute`
* karatek.head -> needed for `/head`
* karatek.dev -> needed for experimental feautures and log access
* karatek.server -> needed for `/server`
* karatek.broadcast -> needed for `@bc`
* karatek.adminchat -> needed for writing in green
* karatek.teamsend -> needed for writing into TeamChat
* karatek.teamsee -> getting messages in the TeamChat
* karatek.rank -> needed for `/rank`
* karatek.silentjoin -> users with this Permission don't have a join message and are automatically vanished.
* karatek.crash -> needed for /crash

## Ranks
These Ranks are Integreated:
* Owner
* Admin
* Developer
* Moderator
* Supporter
* Builder
* Player / Spieler
* VIP
* Premium
* Ultra
* YouTuber
* YouTuber+
* TeamFriend
* TeamFriendPlus
* Tester

More informations about rank are coming soon in the wiki.

## Dependencies
* [PermissionsEX](https://github.com/PEXPlugins/PermissionsEx/) : needed for Ranks
* [sTabliist](https://github.com/DevJul1an/sTablist): needed for Ranks (Example Comfig is in this [Gist](https://gist.github.com/KaratekHD/65ae1c9e6ed668e3ea4a66ce21a78a09) )
* [EssenitalsX](https://github.com/EssentialsX/Essentials) : needed for autovanish

## Installation Guide
1. Install Spigot 1.8.x
2. Go to your plugins folder
3. drag the .jar into it
4. restart/reload the server
