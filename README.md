BackgroundWatchPosition Plugin
======

Cordova plugin that forces Android System WebView to think that it's window is still visible when your app is running in the background.

This has been implemented after Chromium decided to disable watchPosition (and getCurrentPosition) when the browser is not in the foreground. Justifiably so, but a lot of Cordova applications did not expect this. 

Copyright: Geotab
Author: Mike Murkovic