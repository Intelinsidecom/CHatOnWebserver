package com.sec.chaton.samsungaccount;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.cc */
/* loaded from: classes.dex */
class C3378cc extends WebChromeClient {

    /* renamed from: a */
    final /* synthetic */ DialogC3368bt f12334a;

    private C3378cc(DialogC3368bt dialogC3368bt) {
        this.f12334a = dialogC3368bt;
    }

    /* synthetic */ C3378cc(DialogC3368bt dialogC3368bt, DialogInterfaceOnCancelListenerC3369bu dialogInterfaceOnCancelListenerC3369bu) {
        this(dialogC3368bt);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        C4904y.m18639b("progress=" + i, getClass().getSimpleName());
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        C4904y.m18639b("onJsAlert", getClass().getSimpleName());
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new ForegroundColorSpan(-16777216), 0, spannableString.length(), 33);
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f12334a.f12319m);
        abstractC4932aM18733a.mo18734a(R.string.app_name);
        abstractC4932aM18733a.mo18749b(spannableString);
        abstractC4932aM18733a.mo18756d(android.R.string.ok, new DialogInterfaceOnClickListenerC3379cd(this, jsResult));
        InterfaceC4936e interfaceC4936eMo18745a = abstractC4932aM18733a.mo18745a();
        interfaceC4936eMo18745a.setOnDismissListener(new DialogInterfaceOnDismissListenerC3380ce(this, jsResult));
        interfaceC4936eMo18745a.show();
        return true;
    }
}
