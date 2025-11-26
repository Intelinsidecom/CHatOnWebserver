package com.sec.chaton.settings.tellfriends;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.p007a.C0059f;
import com.sec.chaton.p020c.C0817b;
import com.sec.chaton.settings.tellfriends.common.C2785a;
import com.sec.chaton.util.C3250y;

/* compiled from: TwDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.az */
/* loaded from: classes.dex */
class C2749az extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ DialogC2741ar f10146a;

    private C2749az(DialogC2741ar dialogC2741ar) {
        this.f10146a = dialogC2741ar;
    }

    /* synthetic */ C2749az(DialogC2741ar dialogC2741ar, DialogInterfaceOnCancelListenerC2742as dialogInterfaceOnCancelListenerC2742as) {
        this(dialogC2741ar);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        C3250y.m11453c("On Page Finished URL : " + str.toString(), getClass().getSimpleName());
        super.onPageFinished(webView, str);
        if (!this.f10146a.f10137o) {
            this.f10146a.f10133k.dismiss();
        }
        this.f10146a.f10135m.setBackgroundColor(0);
        this.f10146a.f10134l.setVisibility(0);
        this.f10146a.f10136n.setVisibility(0);
        if (str.contentEquals(C0817b.f3142n)) {
            if (this.f10146a.f10131i != null) {
                C3250y.m11453c("mUserPinCode : " + this.f10146a.f10131i.toString(), getClass().getSimpleName());
            } else {
                C3250y.m11453c("mUserPinCode null", getClass().getSimpleName());
                webView.loadUrl("javascript:window.PinCode.getPinCode(document.getElementsByTagName('code')[0].innerHTML);");
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        C3250y.m11453c("onPageStarted URL : " + str.toString(), getClass().getSimpleName());
        super.onPageStarted(webView, str, bitmap);
        if (!this.f10146a.f10137o) {
            this.f10146a.f10133k.show();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f10146a.f10132j.mo540a(new C2785a(str, i, str2));
        this.f10146a.dismiss();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C3250y.m11453c("shouldOverrideUrlLoading URL : " + str.toString(), getClass().getSimpleName());
        if (str.startsWith("http://www.chaton.com/")) {
            if (C0059f.m110b(str).getString("denied") == null) {
                return true;
            }
            this.f10146a.f10132j.mo539a();
            this.f10146a.dismiss();
            return true;
        }
        if (str.contains("authorize")) {
            return false;
        }
        this.f10146a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        C3250y.m11453c("onLoadResource URL : " + str.toString(), getClass().getSimpleName());
        if (!str.contains("javascripts") || this.f10146a.f10131i == null) {
        }
        super.onLoadResource(webView, str);
    }
}
