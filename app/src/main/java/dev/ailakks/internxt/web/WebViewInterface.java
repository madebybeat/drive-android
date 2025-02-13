package dev.ailakks.internxt.web;

import android.webkit.JavascriptInterface;

public class WebViewInterface {
    @JavascriptInterface
    public void login(String data) {
        System.out.println(data);
    }
}
