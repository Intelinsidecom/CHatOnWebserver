package com.sec.chaton.shop;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.sec.chaton.R;
import com.sec.chaton.base.InterfaceC1061c;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.mobileweb.AbstractMobileWebFragment;
import com.sec.chaton.mobileweb.C2602p;
import com.sec.chaton.mobileweb.EnumC2599m;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.qmlog.C3119a;
import com.sec.chaton.settings.p096a.C3469m;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.util.C5034k;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public abstract class AbstractChatONShopFragment extends AbstractMobileWebFragment implements InterfaceC1061c {

    /* renamed from: a */
    private FrameLayout f13323a;

    /* renamed from: b */
    private FrameLayout f13324b;

    /* renamed from: c */
    private ProgressDialog f13325c;

    /* renamed from: d */
    private InterfaceC4936e f13326d;

    /* renamed from: e */
    private int f13327e;

    public AbstractChatONShopFragment(String str, EnumC2599m enumC2599m) {
        super(str, enumC2599m, R.layout.layout_shop_fragment);
        this.f13327e = -1;
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        C2602p.m11018b(this.mWebView);
        return viewOnCreateView;
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void onShowProgress() {
        if (C2349a.m10301a("chaton_qmlog_sending")) {
            C3119a.m12716a().m12725c(System.currentTimeMillis());
        }
        m13969d();
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void onDismissProgress() {
        m13970e();
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void onProgressTimeOut() {
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
            onReceiveErrorFromWebViewClient(this.mWebView.copyBackForwardList().getCurrentIndex());
        }
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void onShowNetworkAlert() {
        m13971a();
    }

    /* renamed from: d */
    private void m13969d() {
        if (isValidActivity()) {
            if (this.f13325c == null) {
                this.f13325c = C3469m.m13794a(getAttachedActivity());
                this.f13325c.setOnCancelListener(new DialogInterfaceOnCancelListenerC3702a(this));
            }
            if (!this.f13325c.isShowing()) {
                this.f13325c.show();
            }
            this.f13325c.setCanceledOnTouchOutside(false);
        }
    }

    /* renamed from: e */
    private void m13970e() {
        if (isValidActivity() && this.f13325c != null && this.f13325c.isShowing()) {
            this.f13325c.dismiss();
        }
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void onReceiveErrorFromWebViewClient(int i) {
        m13973c();
        this.f13327e = i;
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void onPageFinishedFromWebViewClient(int i) {
        if (this.f13324b != null && this.f13323a != null) {
            if (C2349a.m10301a("chaton_qmlog_sending") && this.mWebView != null) {
                C3119a.m12716a().m12722a("shop", this.mWebView.getUrl(), System.currentTimeMillis());
            }
            if (this.f13327e != i && this.f13327e != -1) {
                this.f13324b.setVisibility(8);
                this.f13323a.setVisibility(0);
                this.f13327e = -1;
            }
        }
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, com.sec.chaton.base.InterfaceC1061c
    public boolean onBackKeyPressed() {
        if (C5034k.m19106k()) {
            return super.onBackKeyPressed();
        }
        getAttachedActivity().finish();
        return true;
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected WebView onCreateWebView(View view) {
        this.f13323a = (FrameLayout) view.findViewById(R.id.mainLayout);
        this.f13324b = (FrameLayout) view.findViewById(R.id.networkErrorView);
        this.mWebView = (WebView) view.findViewById(R.id.spbd_webview);
        setProgressTimer(30);
        return this.mWebView;
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void setTitle(String str) {
        if (isValidActivity()) {
            getAttachedActivity().setTitle(str);
        }
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void refreshWebContents() {
        C4904y.m18639b("refreshWebContents()", this.TAG);
    }

    /* renamed from: a */
    void m13971a() {
        if (getActivity() != null) {
            if (this.f13326d == null) {
                this.f13326d = AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.toast_error)).mo18749b(getResources().getString(R.string.toast_network_unable)).mo18751b(false).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3729b(this)).mo18745a();
                this.f13326d.setCanceledOnTouchOutside(false);
                this.f13326d.setOnKeyListener(new DialogInterfaceOnKeyListenerC3730c(this));
            }
            if (!this.f13326d.isShowing()) {
                this.f13326d.show();
            }
        }
    }

    /* renamed from: b */
    protected boolean m13972b() {
        if (this.f13326d == null || !this.f13326d.isShowing()) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    void m13973c() {
        if (this.f13324b != null && this.f13323a != null) {
            this.f13324b.setVisibility(0);
            this.f13323a.setVisibility(8);
            int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
            int i = R.string.toast_network_unable;
            if (-3 == iM10677a || -2 == iM10677a) {
                i = R.string.popup_no_network_connection;
            }
            C5179v.m19810a(getActivity(), i, 1).show();
        }
    }
}
