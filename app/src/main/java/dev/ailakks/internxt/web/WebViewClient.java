package dev.ailakks.internxt.web;

import android.webkit.WebView;

public class WebViewClient extends android.webkit.WebViewClient {
    @Override
    public void onPageFinished(WebView webView, String url) {
        super.onPageFinished(webView, url);

        webView.evaluateJavascript("Internxt.Auth.client('https://api.internxt.com/drive', { clientName: 'internxt-android', clientVersion: '1.0' }).login({ email: '', password: '', tfaCode: '' }, Internxt.cryptoProvider).then((data) => Android.login(JSON.stringify(data)));", null);
    }
}
