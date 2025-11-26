package com.sec.chaton.registration;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.content.C0096i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p055d.C2122ca;
import com.sec.chaton.p055d.C2132m;
import com.sec.chaton.p065io.entry.GetVersionNotice;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4864cb;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.p123a.AbstractC4932a;

/* loaded from: classes.dex */
public class FragmentDisclaimerGlobal extends Fragment {

    /* renamed from: q */
    private static final String f11626q = FragmentDisclaimerGlobal.class.getSimpleName();

    /* renamed from: a */
    public Button f11627a;

    /* renamed from: b */
    protected C2132m f11628b;

    /* renamed from: d */
    protected boolean f11630d;

    /* renamed from: f */
    protected boolean f11632f;

    /* renamed from: j */
    private LinearLayout f11636j;

    /* renamed from: k */
    private CheckBox f11637k;

    /* renamed from: l */
    private ImageButton f11638l;

    /* renamed from: m */
    private LinearLayout f11639m;

    /* renamed from: o */
    private C2122ca f11641o;

    /* renamed from: p */
    private GetVersionNotice f11642p;

    /* renamed from: n */
    private ProgressDialog f11640n = null;

    /* renamed from: c */
    protected EnumC3183by f11629c = EnumC3183by.nothing;

    /* renamed from: e */
    protected int f11631e = 0;

    /* renamed from: g */
    public Handler f11633g = new HandlerC3179bu(this);

    /* renamed from: h */
    public BroadcastReceiver f11634h = new C3171bm(this);

    /* renamed from: i */
    AsyncTask<Void, Void, Void> f11635i = new AsyncTaskC3172bn(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.layout_settings_disclaimer, viewGroup, false);
        this.f11627a = (Button) viewInflate.findViewById(R.id.setting_about_btn3);
        this.f11636j = (LinearLayout) viewInflate.findViewById(R.id.linear_disclaimer_chekcbox4);
        this.f11637k = (CheckBox) viewInflate.findViewById(R.id.disclaimer_chekcbox4);
        this.f11638l = (ImageButton) viewInflate.findViewById(R.id.link_button4);
        this.f11639m = (LinearLayout) viewInflate.findViewById(R.id.spp_marketing);
        this.f11632f = C4859bx.m18415j();
        if (!this.f11632f) {
            this.f11639m.setVisibility(8);
        }
        this.f11628b = new C2132m(this.f11633g);
        this.f11641o = new C2122ca(this.f11633g);
        m12845a((TextView) viewInflate.findViewById(R.id.text_comment));
        Button button = (Button) viewInflate.findViewById(R.id.setting_about_btn1);
        button.setFocusable(true);
        button.requestFocus();
        button.setOnClickListener(new ViewOnClickListenerC3170bl(this));
        ((Button) viewInflate.findViewById(R.id.setting_about_btn2)).setOnClickListener(new ViewOnClickListenerC3174bp(this));
        this.f11636j.setOnClickListener(new ViewOnClickListenerC3175bq(this));
        this.f11638l.setOnClickListener(new ViewOnClickListenerC3176br(this));
        this.f11627a.setOnClickListener(new ViewOnClickListenerC3177bs(this));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("upgrade_cancel");
        C0096i.m358a(getActivity().getApplicationContext()).m362a(this.f11634h, intentFilter);
        this.f11636j.setFocusable(true);
        this.f11637k.setClickable(false);
        return viewInflate;
    }

    /* renamed from: a */
    protected void m12845a(TextView textView) {
        if (C2349a.m10301a("sms_feature")) {
            textView.setSoundEffectsEnabled(false);
            textView.setOnClickListener(new ViewOnClickListenerC3178bt(this));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C4904y.f17872b) {
            C4904y.m18639b("onCreate", f11626q);
        }
        if (getActivity().getIntent() != null && getActivity().getIntent().getExtras() != null) {
            this.f11630d = getActivity().getIntent().getExtras().getBoolean("request_sms_mode");
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (C4904y.f17872b) {
            C4904y.m18639b("onResume", f11626q);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (C4904y.f17872b) {
            C4904y.m18639b("onDestroy ", f11626q);
        }
        m12843f();
        C0096i.m358a(getActivity().getApplicationContext()).m361a(this.f11634h);
    }

    /* renamed from: a */
    public void m12844a() {
        if (getActivity() != null) {
            this.f11640n = ProgressDialogC4926s.m18727a(getActivity(), null, getResources().getString(R.string.dialog_provision_ing));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m12843f() {
        if (this.f11640n != null && this.f11640n.isShowing()) {
            this.f11640n.dismiss();
        }
    }

    /* renamed from: b */
    protected void m12846b() {
        if (C4904y.f17872b) {
            C4904y.m18639b("checkRequestedType : " + this.f11629c.toString().toUpperCase(), f11626q);
        }
        if (this.f11629c == EnumC3183by.nothing) {
            this.f11641o.m9471b();
            return;
        }
        Intent intent = new Intent(getActivity(), (Class<?>) ActivityWebView.class);
        intent.putExtra(FragmentWebView.PARAM_MENU, this.f11629c.toString().toUpperCase());
        startActivity(intent);
        m12843f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12837a(EnumC3184bz enumC3184bz, String str) {
        m12843f();
        if (C4904y.f17872b) {
            C4904y.m18639b("network error, type : " + enumC3184bz.toString() + " errorCode : " + str, f11626q);
        }
        if (getActivity() != null) {
            C4859bx.m18375a(AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(getResources().getString(R.string.toast_network_unable), getResources().getString(R.string.error_code_common), str)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3182bx(this, enumC3184bz)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3181bw(this)), getActivity(), str).mo18745a().show();
        }
    }

    /* renamed from: c */
    protected boolean mo12847c() {
        return this.f11637k.isChecked();
    }

    /* renamed from: d */
    protected void m12848d() {
        if (this.f11632f) {
            if (mo12847c()) {
                C4859bx.m18383a(EnumC4864cb.agree, getActivity());
            } else {
                C4809aa.m18104a().m18125b("marketing_disclaimer", (Boolean) false);
            }
        }
    }
}
