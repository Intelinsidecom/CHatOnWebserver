package com.sec.chaton.mobileweb;

import android.net.http.SslError;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sec.chaton.util.C4904y;

/* compiled from: LoggedWebViewClient.java */
/* renamed from: com.sec.chaton.mobileweb.k */
/* loaded from: classes.dex */
public class C2597k extends WebViewClient {
    final String TAG;

    public static C2597k buildLoggedWebViewClient(String str) {
        return new C2597k(str);
    }

    C2597k(String str) {
        this.TAG = str;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        C4904y.m18639b(String.format("hslee_web, view, onLoadResource(), url(%s)", str), this.TAG);
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        C4904y.m18639b(String.format("hslee_web, view, onReceivedHttpAuthRequest(), host(%s), realm(%s)", str, str2), this.TAG);
        super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        C4904y.m18639b(String.format("hslee_web, view, onReceivedSslError(), error(%s)", sslError), this.TAG);
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        C4904y.m18639b(String.format("hslee_web, view, onUnhandledKeyEvent(), event(%s)", keyEvent), this.TAG);
        super.onUnhandledKeyEvent(webView, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f, float f2) {
        C4904y.m18639b("hslee_web, view, onScaleChanged() : " + f + "/" + f2, this.TAG);
        super.onScaleChanged(webView, f, f2);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        C4904y.m18639b(String.format("hslee_web, view, shouldOverrideKeyEvent(), event(%s)", keyEvent), this.TAG);
        return super.shouldOverrideKeyEvent(webView, keyEvent);
    }
}
