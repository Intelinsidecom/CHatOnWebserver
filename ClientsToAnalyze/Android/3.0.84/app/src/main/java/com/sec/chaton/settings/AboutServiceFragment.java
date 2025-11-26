package com.sec.chaton.settings;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.hardware.motion.MotionRecognitionManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.coolots.sso.p006a.C0045a;
import com.coolots.sso.p006a.InterfaceC0048d;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1306as;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.p025d.p026a.C1215cp;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3348j;

/* loaded from: classes.dex */
public class AboutServiceFragment extends Fragment {

    /* renamed from: a */
    String[] f8912a;

    /* renamed from: b */
    String[] f8913b;

    /* renamed from: c */
    protected String f8914c;

    /* renamed from: h */
    private TextView f8917h;

    /* renamed from: i */
    private TextView f8918i;

    /* renamed from: j */
    private TextView f8919j;

    /* renamed from: k */
    private ListView f8920k;

    /* renamed from: m */
    private Context f8922m;

    /* renamed from: n */
    private int f8923n;

    /* renamed from: p */
    private C1215cp f8924p;

    /* renamed from: s */
    private TextView[] f8927s;

    /* renamed from: t */
    private TextView[] f8928t;

    /* renamed from: u */
    private Button[] f8929u;

    /* renamed from: v */
    private boolean f8930v;

    /* renamed from: w */
    private boolean f8931w;

    /* renamed from: o */
    private static final String f8911o = AboutServiceFragment.class.getSimpleName();

    /* renamed from: d */
    public static int f8909d = 1;

    /* renamed from: e */
    public static int f8910e = 2;

    /* renamed from: l */
    private C2703g f8921l = null;

    /* renamed from: q */
    private C0045a f8925q = null;

    /* renamed from: r */
    private boolean f8926r = false;

    /* renamed from: x */
    private ProgressDialog f8932x = null;

    /* renamed from: f */
    public Handler f8915f = new HandlerC2493d(this);

    /* renamed from: g */
    public Handler f8916g = new HandlerC2663e(this);

    /* renamed from: l */
    static /* synthetic */ int m8933l(AboutServiceFragment aboutServiceFragment) {
        int i = aboutServiceFragment.f8923n;
        aboutServiceFragment.f8923n = i + 1;
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Throwable {
        if (C3250y.f11734b) {
            C3250y.m11450b("onCreateView", getClass().getSimpleName());
        }
        View viewInflate = layoutInflater.inflate(R.layout.layout_settings_about, viewGroup, false);
        this.f8920k = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f8920k.setItemsCanFocus(true);
        View viewInflate2 = layoutInflater.inflate(R.layout.layout_about_terms, (ViewGroup) null);
        viewInflate2.setFocusable(true);
        ((ViewGroup) viewInflate2).setDescendantFocusability(MotionRecognitionManager.EVENT_CALL_POSE);
        viewInflate2.setEnabled(true);
        this.f8920k.addFooterView(viewInflate2, null, true);
        this.f8914c = C3159aa.m10962a().m10979a("UpdateUrl", "");
        this.f8921l = new C2703g(this);
        this.f8920k.setAdapter((ListAdapter) this.f8921l);
        this.f8917h = (TextView) viewInflate.findViewById(R.id.terms);
        this.f8918i = (TextView) viewInflate.findViewById(R.id.policy);
        this.f8919j = (TextView) viewInflate.findViewById(R.id.licences);
        this.f8917h.setText(C3348j.m11793a(getResources().getString(R.string.setting_disclaimer_terms)));
        this.f8918i.setText(C3348j.m11793a(getResources().getString(R.string.setting_disclaimer_policy)));
        this.f8919j.setText(C3348j.m11793a(getResources().getString(R.string.settings_license)));
        this.f8917h.setOnClickListener(new ViewOnClickListenerC2412a(this));
        this.f8918i.setOnClickListener(new ViewOnClickListenerC2439b(this));
        this.f8919j.setOnClickListener(new ViewOnClickListenerC2466c(this));
        if (bundle == null) {
            this.f8924p = new C1324bj(this.f8915f).m5694b();
        }
        if (C3214cb.m11265c("com.sec.spp.push") && C3214cb.m11246a("com.sec.spp.push") < 21) {
            new C1306as(this.f8915f).m5613a(this.f8922m);
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f8912a = new String[3];
        this.f8913b = new String[3];
        this.f8927s = new TextView[3];
        this.f8928t = new TextView[3];
        this.f8929u = new Button[3];
        this.f8922m = getActivity();
        m8920b();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C3250y.m11456e("onConfigurationChagne", getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (C3250y.f11734b) {
            C3250y.m11450b("onDestroyView, mGetVersionNoticeTask : " + this.f8924p, getClass().getSimpleName());
        }
        if (this.f8925q != null) {
            this.f8925q.m52a(this.f8922m, (InterfaceC0048d) null);
        }
        f8909d = 1;
        f8910e = 2;
        if (this.f8932x != null && this.f8932x.isShowing()) {
            this.f8932x.dismiss();
        }
    }

    /* renamed from: b */
    private void m8920b() {
        try {
            this.f8912a[0] = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            this.f8912a[0] = "";
        }
        this.f8913b[0] = C3159aa.m10962a().m10979a("UpdateTargetVersion", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8922c() {
        LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(new Intent("com.sec.chaton.ACTION_DISMISS"));
        LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(new Intent("more_tab_badge_update"));
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    public class OpenSourceDialog extends DialogFragment {
        /* JADX WARN: Removed duplicated region for block: B:73:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
        @Override // android.support.v4.app.DialogFragment
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.app.Dialog onCreateDialog(android.os.Bundle r8) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 256
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.settings.AboutServiceFragment.OpenSourceDialog.onCreateDialog(android.os.Bundle):android.app.Dialog");
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8915a(int i) {
        this.f8929u[i].setOnClickListener(new ViewOnClickListenerC2690f(this, i));
    }
}
