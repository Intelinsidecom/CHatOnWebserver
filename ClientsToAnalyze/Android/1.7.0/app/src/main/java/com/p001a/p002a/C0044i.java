package com.p001a.p002a;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: FbDialog.java */
/* renamed from: com.a.a.i */
/* loaded from: classes.dex */
class C0044i extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ DialogC0045j f15a;

    private C0044i(DialogC0045j dialogC0045j) {
        this.f15a = dialogC0045j;
    }

    /* synthetic */ C0044i(DialogC0045j dialogC0045j, DialogInterfaceOnDismissListenerC0038c dialogInterfaceOnDismissListenerC0038c) {
        this(dialogC0045j);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith("fbconnect://success")) {
            Bundle bundleM8b = C0036a.m8b(str);
            String string = bundleM8b.getString("error");
            if (string == null) {
                string = bundleM8b.getString("error_type");
            }
            if (string == null) {
                this.f15a.f20e.mo16a(bundleM8b);
            } else if ("access_denied".equals(string) || "OAuthAccessDeniedException".equals(string)) {
                this.f15a.f20e.mo15a();
            } else {
                this.f15a.f20e.mo18a(new C0047l(string));
            }
            this.f15a.m40c();
            return true;
        }
        if (str.startsWith("fbconnect://cancel")) {
            this.f15a.f20e.mo15a();
            this.f15a.m40c();
            return true;
        }
        if (str.contains("touch")) {
            return false;
        }
        this.f15a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f15a.f20e.mo17a(new C0046k(str, i, str2));
        this.f15a.m40c();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f15a.f21f.show();
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        String title = this.f15a.f22g.getTitle();
        if (title != null && title.length() > 0) {
            this.f15a.f24i.setText(title);
        }
        if (this.f15a.f25j) {
            this.f15a.f21f.dismiss();
        }
    }
}
