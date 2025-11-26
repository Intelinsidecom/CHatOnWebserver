package com.sec.chaton.specialbuddy;

import android.app.ProgressDialog;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.sec.chaton.R;
import com.sec.chaton.base.InterfaceC0459d;
import com.sec.chaton.mobileweb.AbstractMobileWebFragment;
import com.sec.chaton.mobileweb.EnumC1689p;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.settings.downloads.C2555av;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.widget.C3641ai;

/* loaded from: classes.dex */
public abstract class AbstractChatONLiveFragment extends AbstractMobileWebFragment implements InterfaceC0459d {

    /* renamed from: i */
    private FrameLayout f10384i;

    /* renamed from: j */
    private FrameLayout f10385j;

    /* renamed from: k */
    private ProgressDialog f10386k;

    public AbstractChatONLiveFragment(String str, EnumC1689p enumC1689p) {
        super(str, enumC1689p, R.layout.layout_special_buddy_chat_fragment);
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    /* renamed from: c */
    protected void mo6957c() {
        m10068n();
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    /* renamed from: d */
    protected void mo6959d() {
        m10069o();
    }

    /* renamed from: n */
    private void m10068n() {
        if (m6966k()) {
            if (this.f10386k == null) {
                this.f10386k = C2555av.m9489a(m6961f());
                this.f10386k.setOnCancelListener(new DialogInterfaceOnCancelListenerC2920a(this));
            }
            if (!this.f10386k.isShowing()) {
                this.f10386k.show();
            }
            this.f10386k.setCanceledOnTouchOutside(false);
        }
    }

    /* renamed from: o */
    private void m10069o() {
        if (m6966k() && this.f10386k != null && this.f10386k.isShowing()) {
            this.f10386k.dismiss();
        }
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    /* renamed from: e */
    protected void mo6960e() {
        m10072m();
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    /* renamed from: a */
    protected WebView mo6951a(View view) {
        this.f10384i = (FrameLayout) view.findViewById(R.id.mainLayout);
        this.f10385j = (FrameLayout) view.findViewById(R.id.networkErrorView);
        this.f6162c = (WebView) view.findViewById(R.id.spbd_webview);
        return this.f6162c;
    }

    /* renamed from: d */
    protected void mo10070d(String str) {
        if (m6966k()) {
            m6961f().setTitle(str);
        }
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    /* renamed from: j */
    protected void mo6965j() {
        C3250y.m11450b("refreshWebContents()", this.f6160a);
        m6953a("javascript:chaton.loadNewer()");
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    /* renamed from: b */
    protected void mo6956b(String str) {
        String str2 = String.format("javascript:chaton.loadNewer(%s)", str);
        C3250y.m11450b("refreshWebContents() : " + str2, this.f6160a);
        m6953a(str2);
    }

    /* renamed from: l */
    void m10071l() {
        if (getActivity() != null) {
            InterfaceC3274d interfaceC3274dMo11505a = AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.toast_error)).mo11509b(getResources().getString(R.string.toast_network_unable)).mo11511b(false).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2921b(this)).mo11505a();
            interfaceC3274dMo11505a.setCanceledOnTouchOutside(false);
            interfaceC3274dMo11505a.setOnKeyListener(new DialogInterfaceOnKeyListenerC2922c(this));
            interfaceC3274dMo11505a.show();
        }
    }

    /* renamed from: m */
    void m10072m() {
        if (this.f10385j != null && this.f10384i != null) {
            this.f10385j.setVisibility(0);
            this.f10384i.setVisibility(8);
            int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
            int i = R.string.toast_network_unable;
            if (-3 == iM6733a || -2 == iM6733a) {
                i = R.string.popup_no_network_connection;
            }
            C3641ai.m13210a(getActivity(), i, 1).show();
        }
    }
}
