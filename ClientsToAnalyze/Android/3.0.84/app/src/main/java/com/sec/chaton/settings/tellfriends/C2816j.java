package com.sec.chaton.settings.tellfriends;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.renren.android.C0214g;
import com.renren.android.Renren;
import com.sec.chaton.p020c.C0817b;
import com.sec.chaton.settings.tellfriends.common.C2785a;
import com.sec.chaton.util.C3250y;

/* compiled from: RenrenDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.j */
/* loaded from: classes.dex */
class C2816j extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ DialogC2811e f10341a;

    private C2816j(DialogC2811e dialogC2811e) {
        this.f10341a = dialogC2811e;
    }

    /* synthetic */ C2816j(DialogC2811e dialogC2811e, DialogInterfaceOnCancelListenerC2812f dialogInterfaceOnCancelListenerC2812f) {
        this(dialogC2811e);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        C3250y.m11453c("On Page Finished URL : " + str.toString(), getClass().getSimpleName());
        if (!this.f10341a.f10332i) {
            this.f10341a.f10328e.dismiss();
        }
        this.f10341a.f10330g.setBackgroundColor(0);
        this.f10341a.f10329f.setVisibility(0);
        this.f10341a.f10331h.setVisibility(0);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        C3250y.m11453c("onPageStarted URL : " + str.toString(), getClass().getSimpleName());
        if (!this.f10341a.f10332i) {
            this.f10341a.f10328e.show();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f10341a.f10327d.mo540a(new C2785a(str, i, str2));
        this.f10341a.dismiss();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C3250y.m11453c("shouldOverrideUrlLoading URL : " + str.toString(), getClass().getSimpleName());
        if (str.startsWith(C0817b.f3145q)) {
            Bundle bundleM574b = C0214g.m574b(str);
            String string = bundleM574b.getString("error");
            if (string != null) {
                if ("access_denied".equalsIgnoreCase(string)) {
                    this.f10341a.f10327d.mo539a();
                } else if ("login_denied".equalsIgnoreCase(string)) {
                    this.f10341a.f10327d.mo540a(new C2785a("login_denied", -1007, str));
                } else {
                    this.f10341a.f10327d.mo540a(new C2785a(bundleM574b.getString("error_description"), -1007, bundleM574b.getString("error_uri")));
                }
            }
            this.f10341a.dismiss();
            return true;
        }
        if (str.startsWith(C0817b.f3149u)) {
            Bundle bundleM574b2 = C0214g.m574b(str);
            String string2 = bundleM574b2.getString("error");
            if (string2 != null) {
                if ("access_denied".equalsIgnoreCase(string2)) {
                    this.f10341a.f10327d.mo539a();
                } else {
                    this.f10341a.f10327d.mo540a(new C2785a(bundleM574b2.getString("error_description"), -1007, bundleM574b2.getString("error_uri")));
                }
            } else {
                this.f10341a.dismiss();
                this.f10341a.f10327d.mo541a(bundleM574b2);
                return true;
            }
        } else {
            if (str.startsWith("http://graph.renren.com/login_deny/") || str.contains("display")) {
                return false;
            }
            if (str.startsWith(Renren.CANCEL_URI)) {
                this.f10341a.f10327d.mo539a();
                this.f10341a.dismiss();
                return true;
            }
            if (str.startsWith(Renren.SUCCESS_URI)) {
                Bundle bundleM574b3 = C0214g.m574b(str);
                this.f10341a.dismiss();
                this.f10341a.f10327d.mo541a(bundleM574b3);
                return true;
            }
        }
        this.f10341a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        return true;
    }
}
