package com.sec.chaton.settings.tellfriends;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sec.chaton.util.C1786r;
import java.util.Timer;

/* compiled from: TwitterSignIn.java */
/* renamed from: com.sec.chaton.settings.tellfriends.db */
/* loaded from: classes.dex */
class C1428db extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ TwitterSignIn f5312a;

    C1428db(TwitterSignIn twitterSignIn) {
        this.f5312a = twitterSignIn;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f5312a.m5010c();
        if (this.f5312a.f5098i != null) {
            this.f5312a.f5098i.cancel();
            this.f5312a.f5098i = null;
            this.f5312a.f5098i = new Timer();
        } else {
            this.f5312a.f5098i = new Timer();
        }
        this.f5312a.f5098i.schedule(new C1432df(this.f5312a, null), 30000L);
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        if (this.f5312a.f5090a == null) {
            webView.loadUrl("javascript:window.PinCode.getPinCode(document.getElementsByTagName('code')[0].innerHTML);");
        }
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (this.f5312a.f5098i != null) {
            this.f5312a.f5098i.cancel();
        }
        this.f5312a.m5013d();
        C1786r.m6063c("On Page Finished URL : " + str.toString(), getClass().getSimpleName());
        if (this.f5312a.f5090a == null) {
            C1786r.m6063c("mUserPinCode null", getClass().getSimpleName());
            webView.loadUrl("javascript:window.PinCode.getPinCode(document.getElementsByTagName('code')[0].innerHTML);");
        } else {
            C1786r.m6063c("mUserPinCode : " + this.f5312a.f5090a.toString(), getClass().getSimpleName());
        }
        super.onPageFinished(webView, str);
    }
}
