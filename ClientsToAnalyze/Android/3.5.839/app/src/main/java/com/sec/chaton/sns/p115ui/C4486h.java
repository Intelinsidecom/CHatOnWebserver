package com.sec.chaton.sns.p115ui;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sec.chaton.sns.C4363a;
import com.sec.chaton.sns.p113a.C4365b;
import com.sec.chaton.util.C4904y;

/* compiled from: OdnokDialog.java */
/* renamed from: com.sec.chaton.sns.ui.h */
/* loaded from: classes.dex */
class C4486h extends WebViewClient {

    /* renamed from: a */
    String f16180a;

    /* renamed from: b */
    final /* synthetic */ DialogC4446a f16181b;

    private C4486h(DialogC4446a dialogC4446a) {
        this.f16181b = dialogC4446a;
        this.f16180a = "";
    }

    /* synthetic */ C4486h(DialogC4446a dialogC4446a, DialogInterfaceOnCancelListenerC4473b dialogInterfaceOnCancelListenerC4473b) {
        this(dialogC4446a);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        C4904y.m18641c("On Page Finished URL : " + str.toString(), getClass().getSimpleName());
        super.onPageFinished(webView, str);
        if (!this.f16181b.f16079l) {
            this.f16181b.f16075h.dismiss();
        }
        if (m16995a(str)) {
            C4363a.m16557f(this.f16181b.f16072d);
            this.f16181b.m16929c();
        }
        this.f16181b.m16926a(str);
        this.f16181b.f16077j.setBackgroundColor(0);
        this.f16181b.f16076i.setVisibility(0);
        this.f16181b.f16078k.setVisibility(0);
    }

    /* renamed from: a */
    private boolean m16995a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String queryParameter = Uri.parse(str).getQueryParameter("st.cmd");
        if (!TextUtils.isEmpty(queryParameter) && !TextUtils.isEmpty(this.f16180a) && queryParameter.equals(this.f16180a) && queryParameter.equals("OAuth2Permissions")) {
            return true;
        }
        this.f16180a = queryParameter;
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        C4904y.m18641c("onPageStarted URL : " + str.toString(), getClass().getSimpleName());
        super.onPageStarted(webView, str, bitmap);
        if (!this.f16181b.f16079l) {
            this.f16181b.f16075h.show();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (i != DialogC4446a.f16071e.intValue()) {
            this.f16181b.f16074g.mo2272a(new C4365b(str, i, str2));
        }
        C4904y.m18641c("onReceivedError : " + i + "desc:" + str, getClass().getSimpleName());
        this.f16181b.dismiss();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        sslErrorHandler.proceed();
    }
}
