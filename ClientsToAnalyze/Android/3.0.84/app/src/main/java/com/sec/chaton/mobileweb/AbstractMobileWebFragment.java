package com.sec.chaton.mobileweb;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.InterfaceC0459d;
import com.sec.chaton.util.C3250y;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class AbstractMobileWebFragment extends Fragment implements InterfaceC0459d {

    /* renamed from: a */
    protected final String f6160a;

    /* renamed from: b */
    protected C1691r f6161b;

    /* renamed from: c */
    protected WebView f6162c;

    /* renamed from: d */
    protected final List<EnumC1688o> f6163d;

    /* renamed from: e */
    protected final EnumC1689p f6164e;

    /* renamed from: i */
    private int f6168i;

    /* renamed from: j */
    private Activity f6169j;

    /* renamed from: k */
    private boolean f6170k = false;

    /* renamed from: f */
    protected boolean f6165f = false;

    /* renamed from: g */
    Set<EnumC1681h> f6166g = new HashSet();

    /* renamed from: h */
    Set<EnumC1681h> f6167h = new HashSet();

    /* renamed from: a */
    protected abstract WebView mo6951a(View view);

    /* renamed from: b */
    protected abstract Handler mo6954b();

    /* renamed from: c */
    protected abstract void mo6957c();

    /* renamed from: d */
    protected abstract void mo6959d();

    /* renamed from: e */
    protected abstract void mo6960e();

    public AbstractMobileWebFragment(String str, EnumC1689p enumC1689p, int i) {
        this.f6160a = str;
        this.f6164e = enumC1689p;
        this.f6163d = this.f6164e.m6984c();
        this.f6168i = i;
    }

    /* renamed from: f */
    public Activity m6961f() {
        return this.f6169j;
    }

    /* renamed from: g */
    public List<EnumC1688o> m6962g() {
        return this.f6163d;
    }

    /* renamed from: h */
    public EnumC1689p m6963h() {
        return this.f6164e;
    }

    /* renamed from: i */
    public boolean m6964i() {
        return this.f6170k;
    }

    @Override // com.sec.chaton.base.InterfaceC0459d
    /* renamed from: a */
    public boolean mo3094a() {
        if (!m6966k()) {
            return true;
        }
        if (this.f6162c != null && this.f6162c.canGoBack()) {
            this.f6162c.goBack();
            return true;
        }
        return false;
    }

    /* renamed from: a */
    protected void m6952a(EnumC1681h enumC1681h) {
        if (m6966k()) {
            this.f6167h.add(enumC1681h);
            mo6957c();
            if (C3250y.f11734b) {
                C3250y.m11450b(String.format("spbd_progress, showOpenProgress(), add (%s), become (%s)  ", enumC1681h, this.f6167h.toString()), this.f6160a);
            }
        }
    }

    /* renamed from: b */
    protected void m6955b(EnumC1681h enumC1681h) {
        if (m6966k()) {
            if (enumC1681h == null) {
                this.f6167h.clear();
            } else {
                this.f6167h.remove(enumC1681h);
            }
            if (this.f6167h.isEmpty()) {
                mo6959d();
            }
            if (C3250y.f11734b) {
                C3250y.m11450b(String.format("spbd_progress, dismissOpenProgress(), remove (%s), become (%s)  ", enumC1681h, this.f6167h), this.f6160a);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f6169j = activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (C3250y.f11734b) {
            C3250y.m11450b("onCreateView()", this.f6160a);
        }
        BaseActivity.m3081a(this, true);
        View viewInflate = layoutInflater.inflate(this.f6168i, viewGroup, false);
        this.f6162c = mo6951a(viewInflate);
        C1692s.m6989a(this.f6162c);
        this.f6161b = new C1691r(mo6954b(), this.f6163d);
        this.f6162c.addJavascriptInterface(this.f6161b, "ChatONBridge");
        this.f6162c.setWebViewClient(new C1682i(this, this.f6160a));
        this.f6162c.setWebChromeClient(new C1673a(this, this.f6160a));
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (C3250y.f11734b) {
            C3250y.m11450b("onActivityCreated()", this.f6160a);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (C3250y.f11734b) {
            C3250y.m11450b("onStart()", this.f6160a);
        }
        this.f6165f = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (C3250y.f11734b) {
            C3250y.m11450b("onResume()", this.f6160a);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (C3250y.f11734b) {
            C3250y.m11450b("onPause()", this.f6160a);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        if (C3250y.f11734b) {
            C3250y.m11450b("onStop()", this.f6160a);
        }
        this.f6165f = false;
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (C3250y.f11734b) {
            C3250y.m11450b("onDestroy()", this.f6160a);
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (C3250y.f11734b) {
            C3250y.m11450b("onDestroyView()", this.f6160a);
        }
        if (this.f6162c != null) {
            try {
                this.f6162c.stopLoading();
                this.f6162c.destroy();
            } catch (Exception e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, this.f6160a);
                }
            }
            this.f6162c = null;
        }
        if (this.f6161b != null) {
            this.f6161b.release();
        }
        super.onDestroyView();
        BaseActivity.m3081a(this, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        if (C3250y.f11734b) {
            C3250y.m11450b("onDetach()", this.f6160a);
        }
        this.f6169j = null;
        super.onDetach();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m6953a(String str) {
        if (m6966k() && !TextUtils.isEmpty(str)) {
            if (C3250y.f11734b) {
                C3250y.m11450b("loadUrl() : is null webview - " + (this.f6162c == null) + "/ url - " + str.toString(), this.f6160a);
            }
            if (this.f6162c != null) {
                try {
                    this.f6162c.loadUrl(str);
                } catch (RuntimeException e) {
                    if (C3250y.f11737e) {
                        C3250y.m11443a(e, this.f6160a);
                    }
                }
            }
        }
    }

    /* renamed from: j */
    protected void mo6965j() {
    }

    /* renamed from: b */
    protected void mo6956b(String str) {
    }

    /* renamed from: c */
    protected void m6958c(String str) {
        if (TextUtils.isEmpty(str)) {
            C3250y.m11442a("startWebContents(), EMPTY URL !!", this.f6160a);
            return;
        }
        m6952a(EnumC1681h.REQ_STARTING_MOBILE_WEB_CONTENTS);
        m6953a(str);
        this.f6170k = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public boolean m6966k() {
        return (this.f6169j == null || this.f6169j.isFinishing()) ? false : true;
    }
}
