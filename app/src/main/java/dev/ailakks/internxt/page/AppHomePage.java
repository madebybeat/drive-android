package dev.ailakks.internxt.page;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;

import com.beatstreaming.core.MainActivity;
import com.beatstreaming.core.pages.HomePage;

import dagger.hilt.android.AndroidEntryPoint;
import dev.ailakks.internxt.databinding.HomePageBinding;

@AndroidEntryPoint
public class AppHomePage extends HomePage {
    private HomePageBinding homePageBinding;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.homePageBinding = HomePageBinding.inflate(this.getLayoutInflater());

        WebView webView = new WebView(MainActivity.mainActivity);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowUniversalAccessFromFileURLs(true);

        webView.loadUrl("file:///android_asset/internxt/sdk/public/index.html");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                webView.evaluateJavascript("Internxt.Auth.client('https://api.internxt.com/drive', { clientName: 'internxt-android', clientVersion: '1.0' }).login({ email: '', password: '', tfaCode: '' }, Internxt.cryptoProvider);", System.out::println);
            }
        });

        return this.homePageBinding.getRoot();
    }
}
