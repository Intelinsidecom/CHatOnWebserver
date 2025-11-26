package com.sec.chaton.mobileweb;

import android.graphics.Bitmap;
import android.os.Message;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.sec.chaton.util.C3250y;

/* compiled from: LoggedWebChromeClient.java */
/* renamed from: com.sec.chaton.mobileweb.m */
/* loaded from: classes.dex */
public class C1686m extends WebChromeClient {

    /* renamed from: b */
    final String f6201b;

    public C1686m(String str) {
        this.f6201b = str;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        C3250y.m11450b("hslee_web, chrome, onProgressChanged() : " + i, this.f6201b);
        super.onProgressChanged(webView, i);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        C3250y.m11450b("hslee_web, chrome, onCreateWindow()", this.f6201b);
        return super.onCreateWindow(webView, z, z2, message);
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        C3250y.m11450b("hslee_web, chrome, onCloseWindow()", this.f6201b);
        super.onCloseWindow(webView);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        C3250y.m11450b(String.format("hslee_web, chrome, onJsPrompt(), url(%s) / message(%s) / defaultValue(%s) / result(%s)", str, str2, str3, jsPromptResult), this.f6201b);
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        C3250y.m11450b(String.format("hslee_web, chrome, onJsBeforeUnload(), url(%s) / message(%s) / result(%s)", str, str2, jsResult), this.f6201b);
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        C3250y.m11450b("hslee_web, chrome, onJsTimeout()", this.f6201b);
        return super.onJsTimeout();
    }

    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        C3250y.m11450b(String.format("hslee_web, chrome, onReachedMaxAppCacheSize(), spaceNeeded(%d), totalUsedQuota(%d)", Long.valueOf(j), Long.valueOf(j2)), this.f6201b);
        super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        C3250y.m11450b(String.format("hslee_web, chrome, onReceivedTitle(), title(%s)", str), this.f6201b);
        super.onReceivedTitle(webView, str);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        C3250y.m11450b("hslee_web, chrome, onReceivedIcon()", this.f6201b);
        super.onReceivedIcon(webView, bitmap);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        C3250y.m11450b(String.format("hslee_web, chrome, onReceivedTouchIconUrl(), url(%s), precomposed(%s)", str, Boolean.valueOf(z)), this.f6201b);
        super.onReceivedTouchIconUrl(webView, str, z);
    }
}
