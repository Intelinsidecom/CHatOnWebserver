package com.sec.chaton.samsungaccount;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
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
import com.sec.chaton.p055d.C2104bj;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import java.util.ArrayList;

@Deprecated
/* loaded from: classes.dex */
public class FragmentSamsungAccountLogin extends Fragment {

    /* renamed from: c */
    private WebView f12180c;

    /* renamed from: d */
    private Context f12181d;

    /* renamed from: f */
    private String f12183f;

    /* renamed from: g */
    private C2104bj f12184g;

    /* renamed from: h */
    private String f12185h;

    /* renamed from: i */
    private String f12186i;

    /* renamed from: j */
    private String f12187j;

    /* renamed from: k */
    private String f12188k;

    /* renamed from: m */
    private FragmentActivity f12190m;

    /* renamed from: e */
    private ProgressDialog f12182e = null;

    /* renamed from: a */
    protected ArrayList<String> f12178a = new ArrayList<>();

    /* renamed from: b */
    protected ArrayList<String> f12179b = new ArrayList<>();

    /* renamed from: l */
    private boolean f12189l = false;

    /* renamed from: n */
    private Handler f12191n = new HandlerC3331aj(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f12190m = (FragmentActivity) activity;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.layout_notice_webview, viewGroup, false);
        this.f12181d = this.f12190m;
        this.f12180c = (WebView) viewInflate.findViewById(R.id.webview1);
        this.f12180c.getSettings().setJavaScriptEnabled(true);
        this.f12180c.setWebChromeClient(new C3336ao(this));
        this.f12180c.setHorizontalScrollBarEnabled(false);
        this.f12180c.setVerticalScrollbarOverlay(true);
        this.f12180c.setWebViewClient(new C3339ar(this));
        this.f12187j = C4822an.m18236g();
        this.f12188k = getResources().getConfiguration().locale.getLanguage();
        if (TextUtils.isEmpty(this.f12188k)) {
            this.f12188k = "en";
        }
        this.f12184g = new C2104bj(this.f12191n);
        this.f12182e = ProgressDialogC4926s.m18727a(this.f12181d, null, getResources().getString(R.string.dialog_provision_ing));
        this.f12182e.setCancelable(false);
        this.f12182e.setOnCancelListener(new DialogInterfaceOnCancelListenerC3330ai(this));
        m13154a();
        C4904y.m18639b("GLD skip by request that is mapping", getClass().getSimpleName());
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f12190m = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13154a() {
        if (!TextUtils.isEmpty(this.f12187j)) {
            this.f12183f = "https://account.samsung.com/mobile/account/check.do?serviceID=fs24s8z0hh&actionID=StartOAuth2&countryCode=" + this.f12187j + "&languageCode=" + this.f12188k;
        } else {
            this.f12183f = "https://account.samsung.com/mobile/account/check.do?serviceID=fs24s8z0hh&actionID=StartOAuth2&countryCode=&languageCode=" + this.f12188k;
        }
        this.f12180c.loadUrl(this.f12183f);
        C4904y.m18639b("Load url : " + this.f12183f, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C4904y.m18639b("onPause", getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C4904y.m18639b("onResume", getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        C4904y.m18639b("onStop", getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C4904y.m18639b("onDestroy", getClass().getSimpleName());
        if (this.f12180c != null) {
            this.f12180c.stopLoading();
        }
    }
}
