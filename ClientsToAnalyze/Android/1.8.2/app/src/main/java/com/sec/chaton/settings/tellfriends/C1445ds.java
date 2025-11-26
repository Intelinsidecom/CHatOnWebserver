package com.sec.chaton.settings.tellfriends;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sec.chaton.util.C1786r;
import java.util.Timer;

/* compiled from: WeiboSignIn.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ds */
/* loaded from: classes.dex */
class C1445ds extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ WeiboSignIn f5339a;

    C1445ds(WeiboSignIn weiboSignIn) {
        this.f5339a = weiboSignIn;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C1786r.m6063c("shouldOverrideUrlLoading URL : " + str.toString(), getClass().getSimpleName());
        if (str.startsWith("chaton://WeiboSubMenuActivity")) {
            webView.stopLoading();
            if (this.f5339a.f5124d == null) {
                this.f5339a.f5124d = (AsyncTaskC1446dt) new AsyncTaskC1446dt(this.f5339a).execute(str);
            }
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        C1786r.m6063c("onPageStarted URL : " + str.toString(), getClass().getSimpleName());
        if (!str.startsWith("chaton://WeiboSubMenuActivity")) {
            this.f5339a.m5045c();
            if (this.f5339a.f5129i == null) {
                this.f5339a.f5129i = new Timer();
            } else {
                this.f5339a.f5129i.cancel();
                this.f5339a.f5129i = null;
                this.f5339a.f5129i = new Timer();
            }
            this.f5339a.f5129i.schedule(new C1448dv(this.f5339a, null), 30000L);
            super.onPageStarted(webView, str, bitmap);
            return;
        }
        webView.stopLoading();
        if (this.f5339a.f5124d == null) {
            this.f5339a.f5124d = (AsyncTaskC1446dt) new AsyncTaskC1446dt(this.f5339a).execute(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (this.f5339a.f5129i != null) {
            this.f5339a.f5129i.cancel();
        }
        this.f5339a.m5048d();
        C1786r.m6063c("On Page Finished URL : " + str.toString(), getClass().getSimpleName());
        super.onPageFinished(webView, str);
    }
}
