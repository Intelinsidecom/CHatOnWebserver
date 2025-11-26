package com.sec.chaton.mobileweb;

import android.webkit.JsResult;
import android.webkit.WebView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;

/* compiled from: AbstractMobileWebFragment.java */
/* renamed from: com.sec.chaton.mobileweb.a */
/* loaded from: classes.dex */
class C1673a extends C1686m {

    /* renamed from: a */
    final /* synthetic */ AbstractMobileWebFragment f6171a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1673a(AbstractMobileWebFragment abstractMobileWebFragment, String str) {
        super(str);
        this.f6171a = abstractMobileWebFragment;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.f6171a.m6966k()) {
            C3250y.m11450b(String.format("hslee_web, chrome, onJsConfirm(), url(%s) / message(%s) / result(%s)", str, str2, jsResult), this.f6201b);
            InterfaceC3274d interfaceC3274dMo11505a = AbstractC3271a.m11494a(this.f6171a.getActivity()).mo11495a(R.string.app_name).mo11509b(str2).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1676c(this, jsResult)).mo11507b(android.R.string.cancel, new DialogInterfaceOnClickListenerC1675b(this, jsResult)).mo11505a();
            interfaceC3274dMo11505a.show();
            interfaceC3274dMo11505a.setOnCancelListener(new DialogInterfaceOnCancelListenerC1677d(this, jsResult));
            interfaceC3274dMo11505a.setCanceledOnTouchOutside(false);
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (!this.f6171a.m6966k()) {
            return true;
        }
        C3250y.m11450b(String.format("hslee_web, chrome, onJsAlert(), url(%s), message(%s), result(%s)", str, str2, jsResult), this.f6201b);
        if (this.f6171a.getActivity() == null) {
            return false;
        }
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f6171a.f6169j);
        abstractC3271aM11494a.mo11495a(R.string.app_name);
        abstractC3271aM11494a.mo11509b(str2);
        abstractC3271aM11494a.mo11515d(android.R.string.ok, new DialogInterfaceOnClickListenerC1678e(this, jsResult));
        InterfaceC3274d interfaceC3274dMo11505a = abstractC3271aM11494a.mo11505a();
        interfaceC3274dMo11505a.setOnDismissListener(new DialogInterfaceOnDismissListenerC1679f(this, jsResult));
        interfaceC3274dMo11505a.show();
        interfaceC3274dMo11505a.setOnCancelListener(new DialogInterfaceOnCancelListenerC1680g(this, jsResult));
        interfaceC3274dMo11505a.setCanceledOnTouchOutside(false);
        return true;
    }
}
