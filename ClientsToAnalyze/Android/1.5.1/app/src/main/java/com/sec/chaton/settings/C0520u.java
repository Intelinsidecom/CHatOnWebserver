package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: com.sec.chaton.settings.u */
/* loaded from: classes.dex */
class C0520u extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ ActivityWebView f3297a;

    /* renamed from: b */
    private ProgressDialog f3298b;

    public C0520u(ActivityWebView activityWebView, ProgressDialog progressDialog) {
        this.f3297a = activityWebView;
        this.f3298b = progressDialog;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (this.f3298b.isShowing()) {
            this.f3298b.dismiss();
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
