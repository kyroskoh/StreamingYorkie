# StreamingYorkie

<p align="center">
  <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/streaming_yorkie-web.png"><br><br>
  A Twitch streamers best friend.
</p>

---

## Table of Contents

+ [Introduction](#introduction)
+ [Guide](#guide)
+ [Updates](#updates)
+ [Release Prerequisites](#release-prerequisites)
+ [Roadmap](#roadmap)
+ [Issues](#issues)
+ [Contact](#contact)

---

## Introduction

Streaming Yorkie is designed to help *Twitch Streamers* to efficiently *Follow & Unfollow* other Streamers as well as offering a better overview of *Followers & Following*.
After your stream any *VOD (Video On Demand)* can be seen & exported to *Youtube* in our VOD Overview.
**Automatically Follow, Unfollow, F4F & export VODs to Youtube** simply by installing and configuring Streaming Yorkie.
Share that you are **AutoFollowing** to our Discord Community & gain even more followers.
Helps build a bigger community, simplifies/automates communication, become an *affiliate* sooner & free up time to stream more.
Watch multiple streams on one screen at once with **Multi View** and cast it to a larger screen
**Lurk** your favourite streamers with minimum possible network data usage (audio only) & increase their view count.
Streaming Yorkie can be found in the [Google Play Store](https://play.google.com/store/apps/details?id=com.lethalmaus.streaming_yorkie).

Currently it is in an **Alpha** state. 
It could be that a *Bug* may appear or the app behaves in an unexpected manner.
Please report any problems, suspicions or confirmations to help improve Streaming Yorkie for everyone.

The code is **Open Source**, contains **no costs & no advertisements** are involved.
It is a gift back to a great community who I will continue to support for **free**.
 
Streaming Yorkie communicates exclusively with the [Twitch API](https://dev.twitch.tv/), [Twitch Website](https://twitch.tv) and [Twitch Multi View](https://github.com/LethalMaus/TwitchMultiView).
A login is required to be able to edit & see your Twitch data.
Passwords are not saved, rather a unique Token given by Twitch is saved.
This ensures that your account is as safe as can be.
VOD exports are done by Twitch, they are not downloaded & uploaded by Streaming Yorkie
This ensures network data usage is kept to a minimum.

Streaming Yorkie is developed with *Android Studio* in *Java*. 
*Lint* & [Sonarcloud](https://sonarcloud.io/dashboard?id=LethalMaus_StreamingYorkie) is used to acquire high quality standardized code with little complexity.
The code is documented with *JavaDocs* & comments to allow for easier collaborations with other developers.
**DRY** *(Don't Repeat Yourself)* & **KISS** *(Keep It Simple Stupid)* principles are enforced as much as possible.
Variable naming conventions are also in place. 

> The variable name must explain what it is or what it does, clearly, for any developer to understand.

Hopefully this can be used as an example for good coding as well as how to develop an Android App in Java.
The code includes examples of:

+ RecyclerView, Adapter
+ Room & SQLite
+ Volley library for HTTP requests
+ Glide library for image rendering
+ Notifications, Window Manager
+ Foreground Service, Background Service
+ Worker, Async Task
+ Network Usage Monitor
+ Threading
+ Programmatic permission, views
+ File read, write & delete operations
+ WebView, TextView, ImageView, ...
+ Activity, Intent, Listener, ...

Any collaborations are welcome, so feel free to fork & ask for merge requests.
See something inefficient? [Let me know](#contact). I'm always trying to improve my coding & learn new things.

---

## Guide

+ [Login & Logout](#-login--logout)
+ [Symbols & Icons](#symbols--icons)
  + [Menu](#menu)
  + [Categories](#categories)
  + [Actions](#actions)
+ [Followers, Following & F4F](#followers-following--f4F)
+ [VODs](#-vods)
+ [MultiView](#-multiview)
+ [Lurk](#-lurk)
+ [User Info](#-user-info)
+ [Info](#-info)
  + [Logs](#logs)
+ [Settings](#-settings)
  + [AutoFollow](#-autofollow)
  + [AutoVODExport](#-autovodexport)

### <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/authorization.png" height="30" width="30"> Login & Logout

Here you will be asked for your *Username & Password* which will be given directly to *Twitch*.
Streaming Yorkie needs to be authorized to be allow you to edit & change you account.
Logging in is required only once & without it, it cannot work.
Once logged in you should see you own Logo. From here press back to get to the menu & you're good to go.

To logout click on the *options* in the *Support Bar* (top right) & then on the *Logout*.

**Once logged out, all your data will be deleted from the device.**

---

### Symbols & Icons

To help towards internationalization (i18n) I decided to use symbols/icons that were inspired by the actions taken on Twitch.

#### Menu
Several menus are available to divide StreamingYorkie into each feature it offers:
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/followers_menu.png" height="20" width="20"> Shows all *Followers* from Twitch including who has unfollowed
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/following_menu.png" height="20" width="20"> Shows all *Following* from Twitch including who you have unfollowed
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/f4f_menu.png" height="20" width="20"> Overview & simplification users who *F4F (Follow for Follow)*
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/vod_menu.png" height="20" width="20"> Overview for VODs (Videos On Demand) & exporting VODs
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/multi_menu.png" height="20" width="20"> Watch multiple streams at once on one screen
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/lurk_menu.png" height="20" width="20"> Lurk streamers and add to their view count
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/userinfo.png" height="20" width="20"> Quick overview about your Twitch account
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/info.png" height="20" width="20"> Shows different platforms for further information such as a *Twitch* & *Contact*
  + <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/guide.png" height="20" width="20"> Github link to ReadMe guide
  + <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/help.png" height="20" width="20"> Offline help guide
  + <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/update.png" height="20" width="20"> Github link to Updates
  + <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/sourcecode.png" height="20" width="20"> Github link to the source code
  + <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/contact.png" height="20" width="20"> Github link to Contact
  + <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/twitch.png" height="20" width="20"> Link to developers stream
  + <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/patreon.png" height="20" width="20"> Membership
  + <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/github.png" height="20" width="20"> Projects
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/settings.png" height="20" width="20"> The settings menu is split up into further features below
  + <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/f4f_menu.png" height="20" width="20"> Settings for activating & configuring the AutoFollow Service
  + <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/vod_menu.png" height="20" width="20"> Settings for activating & configuring the AutoVODExport Service
  + <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/authorization.png" height="20" width="20"> Logs out of StreamingYorkie & Twitch as well as deleting any data relating to your Twitch account

#### Categories
Each Menu is split into 3-4 of the following categories:
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/new_button.png" height="20" width="20"> All new Followers/Following
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/follow.png" height="20" width="20"> All current Followers/Following (including New)
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/unfollow.png" height="20" width="20"> All Followers who Unfollowed you or Following you Unfollowed
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/excluded.png" height="20" width="20"> Users/VODs that are excluded from AutoFollow/AutoExport as well as being excluded from the other menus
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/notfollowing_followers.png" height="20" width="20"> Users who Follow you, but you dont Follow them back
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/follow4follow.png" height="20" width="20"> Followers who also Follow you
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/following_nonfollowers.png" height="20" width="20"> Users you Follow, who dont Follow you back
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/vods.png" height="20" width="20"> VODs (Videos On Demand) that are available on your Twitch account
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/export.png" height="20" width="20"> Exported VODs done by StreamingYorkie will be found here

#### Actions
Each category contains up to 3 of the following actions:
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/follow.png" height="20" width="20"> Follows the chosen User
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/unfollow.png" height="20" width="20"> Unfollows the chosen User
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/notifications.png" height="20" width="20"> Activates notifications received from the User
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/deactivate_notifications.png" height="20" width="20"> Deactivates notifications received from the User
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/excluded.png" height="20" width="20"> Excludes Users/VODs from other categories & from AutoFollow
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/include.png" height="20" width="20"> Includes Users/VODs from other categories & from AutoFollow
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/delete.png" height="20" width="20"> Deletes User/VOD from the Device (not Twitch)
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/export.png" height="20" width="20"> Exports a VOD from Twitch to Youtube
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/multi.png" height="20" width="20"> Start watching multiple streams at once on one screen
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/lurk.png" height="20" width="20"> Initiate lurking given streamer
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/unlurk.png" height="20" width="20"> Stop lurking chosen streamer
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/cancel.png" height="20" width="20"> Cancels the current action being taken
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/update.png" height="20" width="20"> Refreshes the current view (if internet is available, a request for new data is sent to Twitch)
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/authorization.png" height="20" width="20"> Logs out of StreamingYorkie & Twitch as well as deleting any data relating to your Twitch account
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/save.png" height="20" width="20"> Saves the current changes (if any have been made)

---

### <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/followers_menu.png" height="30" width="30">Followers, <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/following_menu.png" height="30" width="30">Following & <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/f4f_menu.png" height="30" width="30">F4F

Here you can see who you follow (a.k.a. *Following*), who follows you (a.k.a. *Followers*), who unfollowed you & an excluded list from the AutoFollow.

To *refresh* the view & send a new request press the refresh button <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/update.png" height="20" width="20">

> Each Menu has its own exclusion list for view customization that do **not** reflect in other lists.
>
> Once excluded from any **single** list, it will be excluded from *AutoFollow*.
>
> **_Example:_** Excluding a user in *Follower* will **not** exclude the user in *F4F*, but **will** exclude it from *AutoFollow*.

> In F4F at the end of <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/notfollowing_followers.png" height="20" width="20"> or <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/following_nonfollowers.png" height="20" width="20"> there is an option to **Follow/Unfollow all users** within the category.

---

### <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/vod_menu.png" height="30" width="30"> VODs 

Here VODs *(Videos On Demand)* that are currently available from your profile on Twitch.
The title, game & creation date will be displayed with a preview image of the VOD as well.

All VODs can be exported once & will not heavily affect network usage.
The exportation of the VOD is done by Twitch to your linked Youtube account. As it is done per the Twitch website.

A dialog will appear to edit any information such as: 
+ **Title:** The title of the VOD once exported
+ **Description:** VOD description as per Youtube standards
+ **Tags:** List of Tags as per Youtube standards
+ **Visibility:** If the VOD should be private (off) or public (on)
+ **Split:** If the VOD should be split into 15 minute segments

Exported VODs will be visible under the *Exported* menu category.
VODs that are unavailable on Twitch & have been exported can be deleted.

To *refresh* the view & send a new request press the refresh button <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/update.png" height="20" width="20">

---

### <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/multi_menu.png" height="30" width="30"> MultiView 

Here you can watch multiple streams at once on one screen.

Enter up to 4 channel names that are currently online and press the MultiView start button <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/multi.png" height="20" width="20">.
The view has been optimized to fit any screen and utilize as much space as it can.

A cast button <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/cast.png" height="20" width="20"> directs to the Mirror Cast settings on any device.

The MultiView uses an external website [TwitchMultiView](https://lethalmaus.github.io/TwitchMultiView?channels=lethalmaus), designed and hosted by the same developer.

The soft keys can be seen either by swiping from the bottom up, or from the top down.

---

### <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/lurk_menu.png" height="30" width="30"> Lurk 

Here you can lurk any live stream and add to their viewer count. Lurking helps other channels get higher on list to increase the chances of more viewers, followers, etc.

Enter the channel name and to start lurking press the lurk button <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/lurk.png" height="20" width="20">.
Channels that are being lurked will be shown in a table below the input bar.
The channel picture will only be displayed if you are also currently following the channel.

To stop lurking a channel press the unlurk button <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/unlurk.png" height="20" width="20">.

Lurking pulls only the audio data to reduce the network load. Once lurking, a separate service will be started.
The service uses an invisible window overlay (which requires permission) to display a WebView.
The WebView contains video players to play the audio only stream at the minimum possible volume.
This then adds to the view count for the channel being lurked.

The service will display a notification saying how many channels are being lurked and the apps **total** network usage.
The network usage includes other requests within the app irrelevant from lurking.
The service can be paused, stopped & started from the notification.
The notification only disappears once the service has ended.

> Using the Twitch App will disable the lurk service. Use MultiView or another device to watch while lurking.

---

### <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/userinfo.png" height="30" width="30"> User Info 

This is an overview of the *User* who is currently logged in, that shows the following:
+ **Logo:** Your profile picture
+ **Username:** Your login name / username
+ **ID:** Your unique Twitch ID
+ **Game:** The current game you are playing
+ **Member Since:** When you joined
+ **Views:** How many views you have
+ **Followers:** How many followers you have
+ **Broadcaster Type:** If you are affiliated or partnered
+ **Status:** Your Go Live status
+ **Description:** Your profile description

To *refresh* the view & send a new request press the refresh button <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/update.png" height="20" width="20">

If you would like anything else to be displayed, or have the info display differently, [let me know](#contact).

---

### <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/info.png" height="30" width="30"> Info

Here you can find external links, offline guides and more in relation to the Streaming Yorkie & its developer:
 
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/guide.png" height="20" width="20"> Github link to ReadMe guide
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/help.png" height="20" width="20"> Offline help guide
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/update.png" height="20" width="20"> Github link to Updates
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/sourcecode.png" height="20" width="20"> Github link to the source code
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/contact.png" height="20" width="20"> Github link to Contact
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/twitch.png" height="20" width="20"> Link to developers stream
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/patreon.png" height="20" width="20"> Membership
+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/github.png" height="20" width="20"> Projects

On the bottom of the screen, the current app version should be shown.

#### Logs

Tapping the *Developer Logo* **8** times will give you access to the app logs & files. An error log is available along with much more for support.

---

### <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/settings.png" height="30" width="30"> Settings

#### <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/f4f_menu.png" height="30" width="30"> Autofollow

Here you can configure the *AutoFollow* to run in the background.

+ **AutoFollow Service:** *Following, Unfollowing or Following & Unfollowing* can be activated.

+ **Interval:** The interval slider ranges from *1-60* with a unit option of *Minutes, Hours or Days*.
Please be wary, due to a high battery consumption & inefficiency from other Apps, the interval has been restricted by Android to a minimum of 15 Minutes. Going below this will default back to 15 Minutes.

+ **Enable Notifications:** You can switch on or off whether the *AutoFollow* activates notifications for each new Follower.

+ **Share F4F Status:** You can share that you are AutoFollowing to our Discord channel for others to know that when they follow you, they get followed back.

+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/save.png" height="20" width="20"> **Save:** Once you are done and changes have been made, it will be saved locally as a file.

> **Warning**
>
> Please make sure you have excluded Followers & Following you wish to be left alone from the AutoFollow Service.

If you run into problems with the AutoFollow Service, deactivate it & [contact](#contact) me.

#### <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/vod_menu.png" height="30" width="30"> AutoVODExport

Here you can configure the *AutoVODExport* to run in the background.

+ **AutoVODExport Service:** Select *Export* to be activate.

+ **Interval:** The interval slider ranges from *1-60* with a unit option of *Hours or Days*.
We recommend you not to do it too often as it will affect unnecessary battery & network consumption. Once a week is plenty.

+ **Visibility:** If the VODs should have private or public visibility on Youtube

+ **Split:** If the VODs should be split into 15 Min segments

+ <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/save.png" height="20" width="20"> **Save:** Once you are done and changes have been made, it will be saved locally as a file.

---

## Updates

+ [2.0.1-a](#201-a)
+ [2.0.0-a](#200-a)
+ [1.3.1-a](#131-a)
+ [1.3.0-a](#130-a)
+ [1.2.1-a](#121-a)
+ [1.2.0-a](#120-a)
+ [1.1.3-a](#113-a)
+ [1.1.2-a](#112-a)
+ [1.1.1-a](#111-a)
+ [1.1.0-a](#110-a)
+ [1.0.4-a](#104-a)
+ [1.0.3-a](#103-a)
+ [1.0.2-a](#102-a)
+ [1.0.1-a](#101-a)
+ [1.0.0-a](#100-a)

### 2.0.1-a

Patch for minor fixes

Issues:
+   UserView crash on displaying chanel name fix
+   RecyclerView crash IndexOutOfBoundsException fix
+   FollowRequestHandler NumberFormatException crash fix

Improvements:
+   Request architecture change for faster more efficient http requests
+   SQLite & Room introduction for efficient data management
+   Explicit threading for smoother UI loading and data handling

Other:
+   Gradle update
+   Sonarcloud introduction
+   SDK update
+   Java update

---

### 2.0.0-a

Major update affecting architecture

Improvements:
+   Request architecture change for faster more efficient http requests
+   SQLite & Room introduction for efficient data management
+   Explicit threading for smoother UI loading and data handling

Other:
+   Gradle update
+   Sonarcloud introduction
+   SDK update
+   Java update

---

### 1.3.1-a

Patch for fixing issues below

Features:
+   MultiView Cast
+   Lurk Service
+   Share F4F to Discord

Issues:
+	Login Crash due to 2FA
+   Twitch APIv3 Shutdown

Other:
+   Release prerequisites
+   Minor refactoring
+   Improved RequestHandler error handling
+   Improved Navigation handling

---

### 1.3.0-a

Third minor release for new features.

Features:
+   MultiView Cast
+   Lurk Service
+   Share F4F to Discord

Other:
+   Release prerequisites
+   Minor refactoring

---

### 1.2.1-a

Patch for fixing issues below

Issues:
+	Empty VOD Crash fix
+   Following toast typo
+   Changed min api to 21 due to WebView restrictions
+   UserView crash fix
+   Autofollow crash fix

Improvements:
+   In-app version display
+   Notification repetition & cancellation 
+   Updated offline icon guide
+   Updated & fixed Github readme
+   Improved play store search
+   VOD preview links
+   Twitch sync message clarification

---

### 1.2.0-a

Second minor release for new features.

Features:
+   MultiView
+   Guides, Help & Links

Issues:
+	Follow Requests fix
+   User view fix
+	VOD exports during stream
+	Autofollow & UserView crashes fix

Other:
+   Dynamic notification button on follow
+   Reimplemented flag files

---

### 1.1.3-a

Patch for fixing issues below

Issues:
+	Removed Auth custom timeout
+   Offline User Logo
+   60 Day token refresh
+   Log view line break fix
+   Follow requests not working fix

Improvements:
+   Glide user logo placeholders
+   Error Handling
+   Toasts across App
+   Increased MinSdk to 19
+   Updated Glide Library
+   App icon resolution fix
+   Dynamic F4F objects

---


### 1.1.2-a

Patch for fixing issues below

Issues:
+	Removed Auth custom timeout
+   Offline User Logo
+   60 Day token refresh
+   Log view line break fix

Improvements:
+   Error Handling
+   Toasts across App
+   Increased MinSdk to 19
+   Updated Glide Library
+   App icon resolution fix
+   Dynamic F4F objects

---

### 1.1.1-a

Patch for fixing issues below

Features:
+   VOD Overview
+   VOD Export
+   VOD Export Automation

Issues:
+	F4F Settings fix
+   WriteFile append with line break
+	VOD Export while streaming fix
+	VOD count and removal when offline / non-existent

---

### 1.1.0-a

First minor release for new features.

Features:
+   VOD Overview
+   VOD Export
+   VOD Export Automation

Issues:
+	Request & file writing synchronization
+   Login/Logout correction fix
+	Encoding issues fix (UTF-8)
+	Action button issue fix

Other:
+   Styling updated
+   Logout option in Settings
+   JUnit tests for package:file
+	DRY Principle enforcements improved
+   New screenshots for Google Play

---

### 1.0.4-a

Patch for fixes listed below.

Issues:
+	Follow/Unfollow all action implementation (was missing after recycler view)
+	Updates for Google Play Policies (code was not pushed)

---

### 1.0.3-a

Patch for fixes listed below.

Issues:
+	F4F Menu Users movement correction
+	Updates for Google Play Listing Policies

---

### 1.0.2-a

Patch for fixes listed below.

Issues:
+	Link to Guide/Manual in Info
+	User list order wrong (due to Collections reverse order mistake)
+	Weak References checked against null
+	Nested weights in info.xml removed (redesigned)
+	F4F Menu Users removed from view when Follow/Unfollow action taken
+	Check in place for Follow/Unfollow/Notification actions when offline
+	Bug/Issue template for Github & replaced in readme
+	Implemented Javadoc Checkstyle restrictions
+	Implemented Lint restrictions (for maintaining high code quality)

---

### 1.0.1-a

Patch for fixes listed below.

Issues:
+	User list order wrong (previous code was not implemented)
+	Activity refreshes on screen rotation fix
+	Exclusion lists inconsistency fix (wrong path & decision to keep)

---

### 1.0.0-a

First Public Major Release.

Features:
+	User Overview
+	Follower, Following & Follow4Follow Overview
+	Developer Overview
+	Settings implemented
+	AutoFollow implemented
+	Login/Logout implemented

Issues:
+	User list view lag
+	User list order wrong
+	Action buttons functionality fix
+	AutoFollow activation fix
+	Multiple request collision fix
+	Skipped frames fix

---

## Roadmap

The following tasks and features are currently on the roadmap & some of which are likely to be within the next release.

+ AutoLurk
+ Stream Info/Event tracker (views, hosts, followers, chats, markers)
+ Sonarcloud improvments
+ Single automated E2E test 
+ Firebase device farm
+ Unit tests until 100% code coverage
+ Extend Settings for general (Wifi only, user pic size, theme choice)
+ Data backup & recovery
+ Stream Scheduler (for past, current & future streams)
+ Quick Tap host
+ Host for Host
+ Clips overview, upload, creation, ... 
+ Status, Game, Tags & Description editing option 
+ Reusable Activities (Go Live text, game, tags)
+ Instant AutoFollow & AutoUnfollow (based on webhooks)
+ Streaming tips (obs settings, camera & green screen, networking, chat interactions)
+ Handle Multiple/Dual accounts (eg. one for following, one for followers)
+ i18n (Internationalization)
+ Follower/Following search

---

## Release Prerequisites

+ Testing
  + Smoke tests on different sdk versions done?
  + JUnit tests defined, changed and executed?
  + Single E2E test changed and executed?
+ Google Play 
  + Listing updated?
  + Screenshots Updated?
+ Github
  + Readme
    + New action? category? menu?
    + Updates extended?
    + New feature documented?
    + Links to Readme sections & pics working?
  + Correct branch?
  + Merged with master?
  + Release with new Tag done?

---

## Issues

Please report any issues you may come across to help improve Streaming Yorkie.
You can either use [Githubs Issue Tab](https://github.com/LethalMaus/StreamingYorkie/issues/new) or contact me on [Discord](https://discord.gg/asZsz2F).
Please try to use the following template to help resolve the issue quicker.

```
**Description:**

**Reproduction:**

**Code Path:**

**StreamingYorkie Version:**

**Android Version:**

**Smartphone Make & Model:**

```

> Description: A description of what the issue is
>
> (Bug/Problem) Reproduction: How to reproduce the error or proof (picture/video) of the error
>
> (Code Inefficiency) Code Path: Where to find the code inefficiency e.g. Link to class & line number
>
> Streaming Yorkie Version: Version of App being used e.g. 1.0.0-a
>
> Android Version: Version of Android being used e.g 4.4.4
>
> Smartphone Make & Model: Where the App is being used e.g Samsung S9

---

## Contact

For any issues, questions or change requests, feel free to ask. I will get back to you as soon as I can

<a href="https://discord.gg/asZsz2F">
  <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/discord.png" height="60"> 
</a><br><br>

I also love to entertain, game & stream as a hobby on Twitch. If you're interested, come & say 'Hi'

<a href="https://www.twitch.tv/lethalmaus">
  <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/twitch.png" height="60">
</a><br><br>

Any support or donations are highly appreciated (but not expected) & go towards improving development & entertainment.

<a href="https://paypal.me/JamesCullimore/2,50">
  <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/paypal.png" height="60">
</a><br><br>

Become a Patreon and decide what my main focus should be.

<a href="https://www.patreon.com/LethalMaus/creators">
  <img src="https://github.com/LethalMaus/StreamingYorkie/blob/master/streaming_yorkie/src/main/res/drawable/patreon.png" height="60">
</a><br>

Email: <DescriptiveAnimals@gmail.com>

I'm on [LinkedIn](https://www.linkedin.com/in/james-cullimore-042ab397/). Here you will find my development preferences & experiences.
