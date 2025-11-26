package com.sec.chaton.settings;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.settings.as */
/* loaded from: classes.dex */
class C0470as extends WebChromeClient {

    /* renamed from: a */
    final /* synthetic */ ActivityWebView f3161a;

    C0470as(ActivityWebView activityWebView) {
        this.f3161a = activityWebView;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        this.f3161a.f3078b.setProgress(i * 100);
        ChatONLogWriter.m3506b("progress=" + i, getClass().getSimpleName());
    }
}
