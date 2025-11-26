package com.sec.chaton.mobileweb;

import android.net.http.SslError;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sec.chaton.util.C3250y;

/* compiled from: LoggedWebViewClient.java */
/* renamed from: com.sec.chaton.mobileweb.n */
/* loaded from: classes.dex */
public class C1687n extends WebViewClient {

    /* renamed from: b */
    final String f6202b;

    public C1687n(String str) {
        this.f6202b = str;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        C3250y.m11450b(String.format("hslee_web, view, onLoadResource(), url(%s)", str), this.f6202b);
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        C3250y.m11450b(String.format("hslee_web, view, onReceivedHttpAuthRequest(), host(%s), realm(%s)", str, str2), this.f6202b);
        super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        C3250y.m11450b(String.format("hslee_web, view, onReceivedSslError(), error(%s)", sslError), this.f6202b);
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        C3250y.m11450b(String.format("hslee_web, view, onUnhandledKeyEvent(), event(%s)", keyEvent), this.f6202b);
        super.onUnhandledKeyEvent(webView, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f, float f2) {
        C3250y.m11450b("hslee_web, view, onScaleChanged() : " + f + "/" + f2, this.f6202b);
        super.onScaleChanged(webView, f, f2);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        C3250y.m11450b(String.format("hslee_web, view, shouldOverrideKeyEvent(), event(%s)", keyEvent), this.f6202b);
        return super.shouldOverrideKeyEvent(webView, keyEvent);
    }
}
