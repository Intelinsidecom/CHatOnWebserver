package com.p001a.p002a;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: FbDialog.java */
/* renamed from: com.a.a.j */
/* loaded from: classes.dex */
class C0035j extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ DialogC0031f f28a;

    private C0035j(DialogC0031f dialogC0031f) {
        this.f28a = dialogC0031f;
    }

    /* synthetic */ C0035j(DialogC0031f dialogC0031f, DialogInterfaceOnCancelListenerC0032g dialogInterfaceOnCancelListenerC0032g) {
        this(dialogC0031f);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith("fbconnect://success")) {
            Bundle bundleM43b = C0037l.m43b(str);
            String string = bundleM43b.getString("error");
            if (string == null) {
                string = bundleM43b.getString("error_type");
            }
            if (string == null) {
                this.f28a.f20e.mo20a(bundleM43b);
            } else if ("access_denied".equals(string) || "OAuthAccessDeniedException".equals(string)) {
                this.f28a.f20e.mo19a();
            } else {
                this.f28a.f20e.mo22a(new C0030e(string));
            }
            this.f28a.dismiss();
            return true;
        }
        if (str.startsWith("fbconnect://cancel")) {
            this.f28a.f20e.mo19a();
            this.f28a.dismiss();
            return true;
        }
        if (str.contains("touch")) {
            return false;
        }
        this.f28a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f28a.f20e.mo21a(new C0026a(str, i, str2));
        this.f28a.dismiss();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f28a.f21f.show();
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        String title = this.f28a.f22g.getTitle();
        if (title != null && title.length() > 0) {
            this.f28a.f24i.setText(title);
        }
        if (this.f28a.getContext() != null && this.f28a.f21f != null) {
            this.f28a.f21f.dismiss();
        }
    }
}
