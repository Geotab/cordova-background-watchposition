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
   * When activity loses focus, tell the android.webkit.WebView that it is still visible
   */
  @Override
  public void onPause(boolean multiTaskingEnabled) {
    webView.getEngine().getCordovaWebView().getView().dispatchWindowVisibilityChanged(View.VISIBLE);
  }
}