package com.geotab;

import android.view.View;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;

public class BackgroundWatchPosition extends CordovaPlugin {
  private CordovaWebView webView;
  @Override
  public void initialize(CordovaInterface cordovaParam, CordovaWebView webViewParam) {
    super.initialize(cordovaParam, webViewParam);
    webView = webViewParam;
  }

  /**
   * When activity loses focus, tell the android.webkit.WebView that it is still visible.
   * Alternative is to override onWindowVisibilityChanged in cordova.engine.SystemWebView,
   * but that requires a Cordova fork, which isn't the best idea.
   */
  @Override
  public void onStop() {
    super.onStop();

    // Wake up sleeping beauty one second after Maleficent (WebView) has put her to sleep
    Thread thread = new Thread(){
      public void run() {
        try {
          Thread.sleep(1000);
          webView.getEngine().getView().dispatchWindowVisibilityChanged(View.VISIBLE);
        } catch (InterruptedException e) {
          // do nothing
        }
      }
    };

    thread.start();
  }
}