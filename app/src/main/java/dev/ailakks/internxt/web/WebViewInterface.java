package dev.ailakks.internxt.web;

import android.webkit.JavascriptInterface;

import com.google.gson.Gson;

import dev.ailakks.internxt.entity.UserSessionEntity;

public class WebViewInterface {
    private final Gson gson;

    public WebViewInterface(Gson gson) {
        this.gson = gson;
    }

    @JavascriptInterface
    public void login(String data) {
        System.out.println(this.gson.fromJson(data, UserSessionEntity.class));
    }
}
