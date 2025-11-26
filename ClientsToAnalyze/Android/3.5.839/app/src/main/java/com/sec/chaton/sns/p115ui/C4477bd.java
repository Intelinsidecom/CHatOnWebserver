package com.sec.chaton.sns.p115ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sec.chaton.sns.p113a.C4365b;

/* compiled from: WeiboDialog.java */
/* renamed from: com.sec.chaton.sns.ui.bd */
/* loaded from: classes.dex */
class C4477bd extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ DialogC4469aw f16162a;

    private C4477bd(DialogC4469aw dialogC4469aw) {
        this.f16162a = dialogC4469aw;
    }

    /* synthetic */ C4477bd(DialogC4469aw dialogC4469aw, DialogInterfaceOnCancelListenerC4470ax dialogInterfaceOnCancelListenerC4470ax) {
        this(dialogC4469aw);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        DialogC4469aw.m16972b("On Page Finished URL : " + str.toString());
        super.onPageFinished(webView, str);
        if (!this.f16162a.f16152p) {
            this.f16162a.f16148l.dismiss();
        }
        this.f16162a.f16150n.setBackgroundColor(0);
        this.f16162a.f16149m.setVisibility(0);
        this.f16162a.f16151o.setVisibility(0);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        DialogC4469aw.m16972b("onPageStarted URL : " + str.toString());
        if (!this.f16162a.f16152p) {
            this.f16162a.f16148l.show();
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        DialogC4469aw.m16972b("shouldOverrideUrlLoading URL : " + str.toString());
        if (str.startsWith("chaton://WeiboSubMenuActivity")) {
            webView.stopLoading();
            if (this.f16162a.f16154r == null) {
                this.f16162a.f16154r = (AsyncTaskC4476bc) new AsyncTaskC4476bc(this.f16162a).execute(str);
            }
        } else {
            this.f16162a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f16162a.f16147k.mo2272a(new C4365b(str, i, str2));
        this.f16162a.dismiss();
    }
}
