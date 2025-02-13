package dev.ailakks.internxt.page;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;

import com.beatstreaming.core.MainActivity;
import com.beatstreaming.core.pages.HomePage;
import com.google.gson.Gson;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import dev.ailakks.internxt.databinding.HomePageBinding;
import dev.ailakks.internxt.web.WebViewClient;
import dev.ailakks.internxt.web.WebViewInterface;

@AndroidEntryPoint
public class AppHomePage extends HomePage {
    private HomePageBinding homePageBinding;

    @Inject Gson gson;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.homePageBinding = HomePageBinding.inflate(this.getLayoutInflater());

        WebView webView = new WebView(MainActivity.mainActivity);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowUniversalAccessFromFileURLs(true);

        webView.loadUrl("file:///android_asset/internxt/sdk/public/index.html");

        webView.addJavascriptInterface(new WebViewInterface(this.gson), "Android");

        webView.setWebViewClient(new WebViewClient());

        return this.homePageBinding.getRoot();
    }
}
