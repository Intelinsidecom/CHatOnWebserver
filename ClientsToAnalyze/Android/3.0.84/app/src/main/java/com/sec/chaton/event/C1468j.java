package com.sec.chaton.event;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: NewFeatureFragment.java */
/* renamed from: com.sec.chaton.event.j */
/* loaded from: classes.dex */
class C1468j extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ C1467i f5447a;

    C1468j(C1467i c1467i) {
        this.f5447a = c1467i;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str == null || !(str.startsWith("http://") || str.startsWith("https://") || str.startsWith("www."))) {
            return false;
        }
        webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f5447a.f5446b.f5427d.setVisibility(8);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f5447a.f5446b.f5427d.setVisibility(8);
    }
}
