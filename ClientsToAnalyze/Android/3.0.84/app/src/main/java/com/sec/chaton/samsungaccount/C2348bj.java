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

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.bj */
/* loaded from: classes.dex */
class C2348bj extends WebChromeClient {

    /* renamed from: a */
    final /* synthetic */ DialogC2339ba f8800a;

    private C2348bj(DialogC2339ba dialogC2339ba) {
        this.f8800a = dialogC2339ba;
    }

    /* synthetic */ C2348bj(DialogC2339ba dialogC2339ba, DialogInterfaceOnCancelListenerC2340bb dialogInterfaceOnCancelListenerC2340bb) {
        this(dialogC2339ba);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        C3250y.m11450b("progress=" + i, getClass().getSimpleName());
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        C3250y.m11450b("onJsAlert", getClass().getSimpleName());
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new ForegroundColorSpan(-16777216), 0, spannableString.length(), 33);
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f8800a.f8787m);
        abstractC3271aM11494a.mo11495a(R.string.app_name);
        abstractC3271aM11494a.mo11509b(spannableString);
        abstractC3271aM11494a.mo11515d(android.R.string.ok, new DialogInterfaceOnClickListenerC2349bk(this, jsResult));
        InterfaceC3274d interfaceC3274dMo11505a = abstractC3271aM11494a.mo11505a();
        interfaceC3274dMo11505a.setOnDismissListener(new DialogInterfaceOnDismissListenerC2350bl(this, jsResult));
        interfaceC3274dMo11505a.show();
        return true;
    }
}
