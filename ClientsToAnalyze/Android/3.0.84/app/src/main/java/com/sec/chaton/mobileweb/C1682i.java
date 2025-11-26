package com.sec.chaton.mobileweb;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.sec.chaton.util.C3250y;

/* compiled from: AbstractMobileWebFragment.java */
/* renamed from: com.sec.chaton.mobileweb.i */
/* loaded from: classes.dex */
class C1682i extends C1687n {

    /* renamed from: a */
    final /* synthetic */ AbstractMobileWebFragment f6190a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1682i(AbstractMobileWebFragment abstractMobileWebFragment, String str) {
        super(str);
        this.f6190a = abstractMobileWebFragment;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.f6190a.m6966k()) {
            C3250y.m11450b(String.format("hslee_web, view, onPageStarted(), url(%s)", str), this.f6202b);
            this.f6190a.m6952a(EnumC1681h.REQ_STARTING_MOBILE_WEB_CONTENTS);
            super.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (this.f6190a.m6966k()) {
            C3250y.m11450b(String.format("hslee_web, view, onPageFinished(), url(%s)", str), this.f6202b);
            this.f6190a.m6955b(EnumC1681h.REQ_STARTING_MOBILE_WEB_CONTENTS);
            super.onPageFinished(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.f6190a.m6966k()) {
            C3250y.m11450b(String.format("hslee_web, view, onReceivedError(), errorCode(%d), description(%s), failingUrl(%s)", Integer.valueOf(i), str, str2), this.f6202b);
            this.f6190a.m6955b(EnumC1681h.REQ_STARTING_MOBILE_WEB_CONTENTS);
            this.f6190a.mo6960e();
            super.onReceivedError(webView, i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.f6190a.m6966k()) {
            return true;
        }
        C3250y.m11450b(String.format("hslee_web, view, shouldOverrideUrlLoading(), url(%s)", str), this.f6202b);
        if (!TextUtils.isEmpty(str) && str.endsWith("[_blank]")) {
            String strReplace = str.replace("[_blank]", "");
            if (C3250y.f11734b) {
                C3250y.m11450b("hslee_web, view, shouldOverrideUrlLoading, changed url for External url : " + strReplace.toString(), this.f6202b);
            }
            this.f6190a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(strReplace)));
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
