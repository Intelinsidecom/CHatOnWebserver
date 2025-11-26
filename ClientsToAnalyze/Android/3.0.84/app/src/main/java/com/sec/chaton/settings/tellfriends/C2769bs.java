package com.sec.chaton.settings.tellfriends;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sec.chaton.settings.tellfriends.common.C2785a;

/* compiled from: WeiboDialog.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bs */
/* loaded from: classes.dex */
class C2769bs extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ DialogC2762bl f10193a;

    private C2769bs(DialogC2762bl dialogC2762bl) {
        this.f10193a = dialogC2762bl;
    }

    /* synthetic */ C2769bs(DialogC2762bl dialogC2762bl, DialogInterfaceOnCancelListenerC2763bm dialogInterfaceOnCancelListenerC2763bm) {
        this(dialogC2762bl);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        DialogC2762bl.m9883b("On Page Finished URL : " + str.toString());
        super.onPageFinished(webView, str);
        if (!this.f10193a.f10184p) {
            this.f10193a.f10180l.dismiss();
        }
        this.f10193a.f10182n.setBackgroundColor(0);
        this.f10193a.f10181m.setVisibility(0);
        this.f10193a.f10183o.setVisibility(0);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        DialogC2762bl.m9883b("onPageStarted URL : " + str.toString());
        if (!this.f10193a.f10184p) {
            this.f10193a.f10180l.show();
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        DialogC2762bl.m9883b("shouldOverrideUrlLoading URL : " + str.toString());
        if (str.startsWith("chaton://WeiboSubMenuActivity")) {
            webView.stopLoading();
            if (this.f10193a.f10186r == null) {
                this.f10193a.f10186r = (AsyncTaskC2768br) new AsyncTaskC2768br(this.f10193a).execute(str);
            }
        } else {
            this.f10193a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f10193a.f10179k.mo540a(new C2785a(str, i, str2));
        this.f10193a.dismiss();
    }
}
