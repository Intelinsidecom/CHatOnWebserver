package com.sec.chaton.samsungaccount;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1307at;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FragmentSamsungAccountLogin extends Fragment {

    /* renamed from: c */
    private WebView f8636c;

    /* renamed from: d */
    private Context f8637d;

    /* renamed from: f */
    private String f8639f;

    /* renamed from: g */
    private C1307at f8640g;

    /* renamed from: h */
    private String f8641h;

    /* renamed from: i */
    private String f8642i;

    /* renamed from: j */
    private String f8643j;

    /* renamed from: k */
    private String f8644k;

    /* renamed from: m */
    private String f8646m;

    /* renamed from: n */
    private FragmentActivity f8647n;

    /* renamed from: e */
    private ProgressDialog f8638e = null;

    /* renamed from: a */
    protected ArrayList<String> f8634a = new ArrayList<>();

    /* renamed from: b */
    protected ArrayList<String> f8635b = new ArrayList<>();

    /* renamed from: l */
    private boolean f8645l = false;

    /* renamed from: o */
    private Handler f8648o = new HandlerC2338b(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f8647n = (FragmentActivity) activity;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.layout_notice_webview, viewGroup, false);
        this.f8637d = this.f8647n;
        this.f8636c = (WebView) viewInflate.findViewById(R.id.webview1);
        this.f8636c.getSettings().setJavaScriptEnabled(true);
        this.f8636c.setWebChromeClient(new C2359g(this));
        this.f8636c.setHorizontalScrollBarEnabled(false);
        this.f8636c.setVerticalScrollbarOverlay(true);
        this.f8636c.setWebViewClient(new C2362j(this));
        this.f8643j = C3171am.m11060d();
        this.f8644k = getResources().getConfiguration().locale.getLanguage();
        if (TextUtils.isEmpty(this.f8644k)) {
            this.f8644k = "en";
        }
        this.f8640g = new C1307at(this.f8648o);
        this.f8638e = ProgressDialogC3265l.m11489a(this.f8637d, null, getResources().getString(R.string.dialog_provision_ing));
        this.f8638e.setCancelable(false);
        this.f8638e.setOnCancelListener(new DialogInterfaceOnCancelListenerC2311a(this));
        m8690a();
        C3250y.m11450b("GLD skip by request that is mapping", getClass().getSimpleName());
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f8647n = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8690a() {
        if (!TextUtils.isEmpty(this.f8643j)) {
            this.f8639f = "https://account.samsung.com/mobile/account/check.do?serviceID=fs24s8z0hh&actionID=StartOAuth2&countryCode=" + this.f8643j + "&languageCode=" + this.f8644k;
        } else {
            this.f8639f = "https://account.samsung.com/mobile/account/check.do?serviceID=fs24s8z0hh&actionID=StartOAuth2&countryCode=&languageCode=" + this.f8644k;
        }
        this.f8636c.loadUrl(this.f8639f);
        C3250y.m11450b("Load url : " + this.f8639f, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C3250y.m11450b("onPause", getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C3250y.m11450b("onResume", getClass().getSimpleName());
        m8694b();
    }

    /* renamed from: b */
    private void m8694b() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = this.f8647n.getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        C3250y.m11450b("onStop", getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C3250y.m11450b("onDestroy", getClass().getSimpleName());
        if (this.f8636c != null) {
            this.f8636c.stopLoading();
        }
    }
}
