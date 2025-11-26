package com.sec.chaton.event;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sec.chaton.TabActivity;
import com.sec.common.util.log.collector.C5043h;

/* compiled from: NewFeatureFragment.java */
/* renamed from: com.sec.chaton.event.c */
/* loaded from: classes.dex */
class C2322c extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ C2321b f8276a;

    C2322c(C2321b c2321b) {
        this.f8276a = c2321b;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str != null && (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("www."))) {
            C5043h.m19179a().m19185a("5000", "2121", false);
            webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        }
        if (str == null || !str.startsWith("chaton://")) {
            return false;
        }
        C5043h.m19179a().m19185a("5000", "2121", false);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.f8276a.f8275b.startActivity(TabActivity.m3016a(this.f8276a.f8275b.f8249f, intent));
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }
}
