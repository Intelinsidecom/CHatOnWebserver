package com.sec.chaton;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.sec.chaton.util.C4904y;

/* compiled from: EOSPopupActivity.java */
/* renamed from: com.sec.chaton.z */
/* loaded from: classes.dex */
class C4930z extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ EOSPopupActivity f17991a;

    /* renamed from: b */
    private Context f17992b;

    public C4930z(EOSPopupActivity eOSPopupActivity, Context context) {
        this.f17991a = eOSPopupActivity;
        this.f17992b = context;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.f17991a.f1930s.setVisibility(8);
        super.onPageFinished(webView, str);
        if (C4904y.f17873c) {
            C4904y.m18641c("onPageFinished : " + str, this.f17991a.f1926o);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f17991a.f1930s.setVisibility(0);
        super.onPageStarted(webView, str, bitmap);
        if (C4904y.f17873c) {
            C4904y.m18641c("onPageStarted : " + str, this.f17991a.f1926o);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (C4904y.f17873c) {
            C4904y.m18641c("onReceivedError : " + str + ", " + str2, this.f17991a.f1926o);
        }
        webView.setVisibility(8);
        if (!this.f17991a.f1929r) {
            Toast.makeText(this.f17992b, this.f17991a.getResources().getString(R.string.toast_network_unable), 0).show();
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (C4904y.f17873c) {
            C4904y.m18641c("shouldOverrideUrlLoading : " + str, this.f17991a.f1926o);
        }
        if ((str != null && str.contains("works.chaton.com")) || str.contains("www.knoxmessage.com")) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        this.f17991a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        return true;
    }
}
