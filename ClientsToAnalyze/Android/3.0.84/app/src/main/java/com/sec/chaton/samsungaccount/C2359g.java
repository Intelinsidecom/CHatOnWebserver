package com.sec.chaton.samsungaccount;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;

/* compiled from: FragmentSamsungAccountLogin.java */
/* renamed from: com.sec.chaton.samsungaccount.g */
/* loaded from: classes.dex */
public class C2359g extends WebChromeClient {

    /* renamed from: a */
    final /* synthetic */ FragmentSamsungAccountLogin f8814a;

    public C2359g(FragmentSamsungAccountLogin fragmentSamsungAccountLogin) {
        this.f8814a = fragmentSamsungAccountLogin;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        this.f8814a.f8647n.setProgress(i * 100);
        C3250y.m11450b("progress=" + i, getClass().getSimpleName());
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        C3250y.m11450b("onJsAlert", getClass().getSimpleName());
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new ForegroundColorSpan(-16777216), 0, spannableString.length(), 33);
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f8814a.f8637d);
        abstractC3271aM11494a.mo11495a(R.string.app_name);
        abstractC3271aM11494a.mo11509b(spannableString);
        abstractC3271aM11494a.mo11515d(android.R.string.ok, new DialogInterfaceOnClickListenerC2360h(this, jsResult));
        InterfaceC3274d interfaceC3274dMo11505a = abstractC3271aM11494a.mo11505a();
        interfaceC3274dMo11505a.setOnDismissListener(new DialogInterfaceOnDismissListenerC2361i(this, jsResult));
        interfaceC3274dMo11505a.show();
        return true;
    }
}
