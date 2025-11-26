package com.sec.chaton.sns.p115ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.renren.android.C0726g;
import com.renren.android.Renren;
import com.sec.chaton.p051c.C1428b;
import com.sec.chaton.sns.p113a.C4365b;
import com.sec.chaton.util.C4904y;

/* compiled from: RenrenDialog.java */
/* renamed from: com.sec.chaton.sns.ui.n */
/* loaded from: classes.dex */
class C4492n extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ DialogC4487i f16199a;

    private C4492n(DialogC4487i dialogC4487i) {
        this.f16199a = dialogC4487i;
    }

    /* synthetic */ C4492n(DialogC4487i dialogC4487i, DialogInterfaceOnCancelListenerC4488j dialogInterfaceOnCancelListenerC4488j) {
        this(dialogC4487i);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        C4904y.m18641c("On Page Finished URL : " + str.toString(), getClass().getSimpleName());
        if (!this.f16199a.f16190i) {
            this.f16199a.f16186e.dismiss();
        }
        this.f16199a.f16188g.setBackgroundColor(0);
        this.f16199a.f16187f.setVisibility(0);
        this.f16199a.f16189h.setVisibility(0);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        C4904y.m18641c("onPageStarted URL : " + str.toString(), getClass().getSimpleName());
        if (!this.f16199a.f16190i) {
            this.f16199a.f16186e.show();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f16199a.f16185d.mo2272a(new C4365b(str, i, str2));
        this.f16199a.dismiss();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C4904y.m18641c("shouldOverrideUrlLoading URL : " + str.toString(), getClass().getSimpleName());
        if (str.startsWith(C1428b.f5117w)) {
            Bundle bundleM2306b = C0726g.m2306b(str);
            String string = bundleM2306b.getString("error");
            if (string != null) {
                if ("access_denied".equalsIgnoreCase(string)) {
                    this.f16199a.f16185d.mo2271a();
                } else if ("login_denied".equalsIgnoreCase(string)) {
                    this.f16199a.f16185d.mo2272a(new C4365b("login_denied", -1007, str));
                } else {
                    this.f16199a.f16185d.mo2272a(new C4365b(bundleM2306b.getString("error_description"), -1007, bundleM2306b.getString("error_uri")));
                }
            }
            this.f16199a.dismiss();
            return true;
        }
        if (str.startsWith(C1428b.f5085A)) {
            Bundle bundleM2306b2 = C0726g.m2306b(str);
            String string2 = bundleM2306b2.getString("error");
            if (string2 != null) {
                if ("access_denied".equalsIgnoreCase(string2)) {
                    this.f16199a.f16185d.mo2271a();
                } else {
                    this.f16199a.f16185d.mo2272a(new C4365b(bundleM2306b2.getString("error_description"), -1007, bundleM2306b2.getString("error_uri")));
                }
            } else {
                this.f16199a.dismiss();
                this.f16199a.f16185d.mo2273a(bundleM2306b2);
                return true;
            }
        } else {
            if (str.startsWith("http://graph.renren.com/login_deny/") || str.contains("display")) {
                return false;
            }
            if (str.startsWith(Renren.CANCEL_URI)) {
                this.f16199a.f16185d.mo2271a();
                this.f16199a.dismiss();
                return true;
            }
            if (str.startsWith(Renren.SUCCESS_URI)) {
                Bundle bundleM2306b3 = C0726g.m2306b(str);
                this.f16199a.dismiss();
                this.f16199a.f16185d.mo2273a(bundleM2306b3);
                return true;
            }
        }
        this.f16199a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        return true;
    }
}
