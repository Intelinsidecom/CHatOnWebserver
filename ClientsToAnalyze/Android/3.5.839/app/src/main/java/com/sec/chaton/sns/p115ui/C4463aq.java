package com.sec.chaton.sns.p115ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.p031a.C0430f;
import com.sec.chaton.p051c.C1428b;
import com.sec.chaton.sns.p113a.C4365b;
import com.sec.chaton.util.C4904y;

/* compiled from: TwDialog.java */
/* renamed from: com.sec.chaton.sns.ui.aq */
/* loaded from: classes.dex */
class C4463aq extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ DialogC4455ai f16121a;

    private C4463aq(DialogC4455ai dialogC4455ai) {
        this.f16121a = dialogC4455ai;
    }

    /* synthetic */ C4463aq(DialogC4455ai dialogC4455ai, DialogInterfaceOnCancelListenerC4456aj dialogInterfaceOnCancelListenerC4456aj) {
        this(dialogC4455ai);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        C4904y.m18641c("On Page Finished URL : " + str.toString(), getClass().getSimpleName());
        super.onPageFinished(webView, str);
        if (!this.f16121a.f16112o) {
            this.f16121a.f16108k.dismiss();
        }
        this.f16121a.f16110m.setBackgroundColor(0);
        this.f16121a.f16109l.setVisibility(0);
        this.f16121a.f16111n.setVisibility(0);
        if (str.contentEquals(C1428b.f5114t)) {
            if (this.f16121a.f16106i != null) {
                C4904y.m18641c("mUserPinCode : " + this.f16121a.f16106i.toString(), getClass().getSimpleName());
            } else {
                C4904y.m18641c("mUserPinCode null", getClass().getSimpleName());
                webView.loadUrl("javascript:window.PinCode.getPinCode(document.getElementsByTagName('code')[0].innerHTML);");
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        C4904y.m18641c("onPageStarted URL : " + str.toString(), getClass().getSimpleName());
        super.onPageStarted(webView, str, bitmap);
        if (!this.f16121a.f16112o) {
            this.f16121a.f16108k.show();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f16121a.f16107j.mo2272a(new C4365b(str, i, str2));
        this.f16121a.dismiss();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C4904y.m18641c("shouldOverrideUrlLoading URL : " + str.toString(), getClass().getSimpleName());
        if (str.startsWith("http://www.chaton.com/")) {
            if (C0430f.m1553b(str).getString("denied") == null) {
                return true;
            }
            this.f16121a.f16107j.mo2271a();
            this.f16121a.dismiss();
            return true;
        }
        if (str.contains("authorize")) {
            return false;
        }
        this.f16121a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        C4904y.m18641c("onLoadResource URL : " + str.toString(), getClass().getSimpleName());
        if (!str.contains("javascripts") || this.f16121a.f16106i == null) {
        }
        super.onLoadResource(webView, str);
    }
}
