package com.sec.chaton.mobileweb;

import android.graphics.Bitmap;
import android.os.Message;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.sec.chaton.util.C4904y;

/* compiled from: LoggedWebChromeClient.java */
/* renamed from: com.sec.chaton.mobileweb.j */
/* loaded from: classes.dex */
public class C2596j extends WebChromeClient {
    final String TAG;

    public static C2596j buildLoggedWebChromeClient(String str) {
        return new C2596j(str);
    }

    C2596j(String str) {
        this.TAG = str;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        C4904y.m18639b("hslee_web, chrome, onProgressChanged() : " + i, this.TAG);
        super.onProgressChanged(webView, i);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        C4904y.m18639b("hslee_web, chrome, onCreateWindow()", this.TAG);
        return super.onCreateWindow(webView, z, z2, message);
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        C4904y.m18639b("hslee_web, chrome, onCloseWindow()", this.TAG);
        super.onCloseWindow(webView);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        C4904y.m18639b(String.format("hslee_web, chrome, onJsPrompt(), url(%s) / message(%s) / defaultValue(%s) / result(%s)", str, str2, str3, jsPromptResult), this.TAG);
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        C4904y.m18639b(String.format("hslee_web, chrome, onJsBeforeUnload(), url(%s) / message(%s) / result(%s)", str, str2, jsResult), this.TAG);
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        C4904y.m18639b("hslee_web, chrome, onJsTimeout()", this.TAG);
        return super.onJsTimeout();
    }

    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        C4904y.m18639b(String.format("hslee_web, chrome, onReachedMaxAppCacheSize(), spaceNeeded(%d), totalUsedQuota(%d)", Long.valueOf(j), Long.valueOf(j2)), this.TAG);
        super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        C4904y.m18639b(String.format("hslee_web, chrome, onReceivedTitle(), title(%s)", str), this.TAG);
        super.onReceivedTitle(webView, str);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        C4904y.m18639b("hslee_web, chrome, onReceivedIcon()", this.TAG);
        super.onReceivedIcon(webView, bitmap);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        C4904y.m18639b(String.format("hslee_web, chrome, onReceivedTouchIconUrl(), url(%s), precomposed(%s)", str, Boolean.valueOf(z)), this.TAG);
        super.onReceivedTouchIconUrl(webView, str, z);
    }
}
