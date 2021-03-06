# KaratekCore

![Version](https://img.shields.io/github/release-pre/KaratekHD/KaratekCore.svg)
![Spigot](https://img.shields.io/badge/Plugin-Spigot-yellow.svg)

KaratekCore is a Spigot Plugin, designed to run on the GamelMC Minecraft Server.
At the moment, there isn't any way to configure it, but I'm working on it. If you have any issues, please write into the issues tab. If there are bugs, please have a look at [our Bug List](https://github.com/KaratekHD/KaratekCore/projects/2) abd if they aren't listed, please report in the issues tab as well.

## Commands
At the moment, the following commands are working:
* `/chatclear` and `/cc`: allows you to clear the chat
* `/globalmute`: allows you to disable/enable the chat
* `/kopf <player>`: gives you the head of <player>.
* `/kv`: Vanishes you -> Only for development purposes!
* `/test`: prints "Hallo Welt!"
* `/server`: emulates the BungeeCord command /server.
* `/rank <player> <Rank>` : Changes the players rank.
* `/crash <player>` : Crashes the players client (experimental!).

## Listener
The following listener are working at the moment:
* ChatListener (AsyncPlayerChatEvent) : Changes the chat layout and adds a teamchat. It also prevents  players form writing while the chat is disabled via /globalmute.
* KickEvent (PlayerKickEvent), PlayerEventJoin(PlayerJoinEvent) and PlayerQuitEvent (PlayerQuitEvent): changes the login and quit messages and changes the players rank on join.
* SignListener (SignChangeEvent): Allows user to write in color on signs.
* ScoreBoard (PlayerJoinEvent): Displays a ScoreBoard
* FlyListener (PlayerToggleFlightEvent): prevents player from flying without permissions.

## Chat Actions
Chat Actions are simple Listeners, who react if you begin your message with a special key word. Example:
`@team Hello World!`

The following ChatActions are possible:
* `@team`: Message will only be sent to all team members
* `@bc`: Message will be sent without the players name to every player on the server.

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
* karatek.silentjoin -> users with this permission don't have a join message and are automatically vanished.
* karatek.crash -> needed for /crash
* karatek.fly -> needed to fly

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

More informations about ranks are coming soon in the wiki.

## Dependencies
* [PermissionsEX](https://github.com/PEXPlugins/PermissionsEx/) : needed for Ranks
* [sTabliist](https://github.com/DevJul1an/sTablist): needed for Ranks (Example Config is in this [Gist](https://gist.github.com/KaratekHD/65ae1c9e6ed668e3ea4a66ce21a78a09) )
* [EssenitalsX](https://github.com/EssentialsX/Essentials) : needed for autovanish

## Installation Guide
1. Install Spigot 1.8.x
2. Go to your plugins folder
3. drag the .jar into it
4. restart/reload the server
