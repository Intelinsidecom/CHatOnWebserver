package com.sec.chaton.settings.tellfriends;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sec.chaton.util.C1786r;
import java.util.Timer;

/* compiled from: OauthSignin.java */
/* renamed from: com.sec.chaton.settings.tellfriends.y */
/* loaded from: classes.dex */
class C1476y extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ OauthSignin f5396a;

    C1476y(OauthSignin oauthSignin) {
        this.f5396a = oauthSignin;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f5396a.m4822c();
        if (this.f5396a.f4979j != null) {
            this.f5396a.f4979j.cancel();
            this.f5396a.f4979j = null;
            this.f5396a.f4979j = new Timer();
        } else {
            this.f5396a.f4979j = new Timer();
        }
        this.f5396a.f4979j.schedule(new C1349ad(this.f5396a, null), 30000L);
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        if (this.f5396a.f4971a == null) {
            webView.loadUrl("javascript:window.PinCode.getPinCode(document.getElementsByTagName('code')[0].innerHTML);");
        }
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (this.f5396a.f4979j != null) {
            this.f5396a.f4979j.cancel();
        }
        this.f5396a.m4825d();
        C1786r.m6063c("On Page Finished URL : " + str.toString(), getClass().getSimpleName());
        if (this.f5396a.f4971a == null) {
            C1786r.m6063c("mUserPinCode null", getClass().getSimpleName());
            webView.loadUrl("javascript:window.PinCode.getPinCode(document.getElementsByTagName('code')[0].innerHTML);");
        } else {
            C1786r.m6063c("mUserPinCode : " + this.f5396a.f4971a.toString(), getClass().getSimpleName());
        }
        super.onPageFinished(webView, str);
    }
}
