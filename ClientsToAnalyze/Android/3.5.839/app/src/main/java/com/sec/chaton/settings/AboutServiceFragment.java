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
import android.support.v4.content.C0096i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.coolots.sso.p030a.C0416a;
import com.coolots.sso.p030a.InterfaceC0419d;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2103bi;
import com.sec.chaton.p055d.C2122ca;
import com.sec.chaton.p055d.p056a.C1976cv;
import com.sec.chaton.p065io.entry.GetVersionNotice;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5035l;

/* loaded from: classes.dex */
public class AboutServiceFragment extends Fragment {

    /* renamed from: a */
    String[] f12442a;

    /* renamed from: b */
    String[] f12443b;

    /* renamed from: c */
    protected String f12444c;

    /* renamed from: h */
    private TextView f12447h;

    /* renamed from: i */
    private TextView f12448i;

    /* renamed from: j */
    private TextView f12449j;

    /* renamed from: k */
    private ListView f12450k;

    /* renamed from: m */
    private Context f12452m;

    /* renamed from: n */
    private int f12453n;

    /* renamed from: p */
    private C1976cv f12454p;

    /* renamed from: s */
    private TextView[] f12457s;

    /* renamed from: t */
    private TextView[] f12458t;

    /* renamed from: u */
    private Button[] f12459u;

    /* renamed from: v */
    private boolean f12460v;

    /* renamed from: w */
    private boolean f12461w;

    /* renamed from: y */
    private GetVersionNotice f12463y;

    /* renamed from: z */
    private boolean f12464z;

    /* renamed from: o */
    private static final String f12441o = AboutServiceFragment.class.getSimpleName();

    /* renamed from: d */
    public static int f12439d = 1;

    /* renamed from: e */
    public static int f12440e = 2;

    /* renamed from: l */
    private C3644g f12451l = null;

    /* renamed from: q */
    private C0416a f12455q = null;

    /* renamed from: r */
    private boolean f12456r = false;

    /* renamed from: x */
    private ProgressDialog f12462x = null;

    /* renamed from: f */
    public Handler f12445f = new HandlerC3563d(this);

    /* renamed from: g */
    public Handler f12446g = new HandlerC3590e(this);

    /* renamed from: n */
    static /* synthetic */ int m13323n(AboutServiceFragment aboutServiceFragment) {
        int i = aboutServiceFragment.f12453n;
        aboutServiceFragment.f12453n = i + 1;
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Throwable {
        if (C4904y.f17872b) {
            C4904y.m18639b("onCreateView", getClass().getSimpleName());
        }
        View viewInflate = layoutInflater.inflate(R.layout.layout_settings_about, viewGroup, false);
        this.f12450k = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f12450k.setItemsCanFocus(true);
        View viewInflate2 = layoutInflater.inflate(R.layout.layout_about_terms, (ViewGroup) null);
        viewInflate2.setFocusable(true);
        ((ViewGroup) viewInflate2).setDescendantFocusability(MotionRecognitionManager.EVENT_CALL_POSE);
        viewInflate2.setEnabled(true);
        this.f12450k.addFooterView(viewInflate2, null, true);
        this.f12444c = C4809aa.m18104a().m18121a("UpdateUrl", "");
        this.f12451l = new C3644g(this);
        this.f12450k.setAdapter((ListAdapter) this.f12451l);
        this.f12447h = (TextView) viewInflate.findViewById(R.id.terms);
        this.f12448i = (TextView) viewInflate.findViewById(R.id.policy);
        this.f12449j = (TextView) viewInflate.findViewById(R.id.licences);
        this.f12447h.setText(C5035l.m19111a(getResources().getString(R.string.setting_disclaimer_terms)));
        this.f12448i.setText(C5035l.m19111a(getResources().getString(R.string.setting_disclaimer_policy)));
        this.f12449j.setText(C5035l.m19111a(getResources().getString(R.string.settings_license)));
        this.f12447h.setOnClickListener(new ViewOnClickListenerC3432a(this));
        this.f12448i.setOnClickListener(new ViewOnClickListenerC3509b(this));
        this.f12449j.setOnClickListener(new ViewOnClickListenerC3536c(this));
        if (bundle == null) {
            this.f12454p = new C2122ca(this.f12445f).m9471b();
        }
        if (C4859bx.m18397c("com.sec.spp.push") && C4859bx.m18370a("com.sec.spp.push") < 21) {
            new C2103bi(this.f12445f).m9386a(this.f12452m);
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f12442a = new String[3];
        this.f12443b = new String[3];
        this.f12457s = new TextView[3];
        this.f12458t = new TextView[3];
        this.f12459u = new Button[3];
        this.f12452m = getActivity();
        m13307b();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C4904y.m18646e("onConfigurationChagne", getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (C4904y.f17872b) {
            C4904y.m18639b("onDestroyView, mGetVersionNoticeTask : " + this.f12454p, getClass().getSimpleName());
        }
        if (this.f12455q != null) {
            this.f12455q.m1492a(this.f12452m, (InterfaceC0419d) null);
        }
        f12439d = 1;
        f12440e = 2;
        if (this.f12462x != null && this.f12462x.isShowing()) {
            this.f12462x.dismiss();
        }
    }

    /* renamed from: b */
    private void m13307b() {
        try {
            this.f12442a[0] = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            this.f12442a[0] = "";
        }
        this.f12443b[0] = C4809aa.m18104a().m18121a("UpdateTargetVersion", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m13309c() {
        C0096i.m358a(getActivity()).m363a(new Intent("com.sec.chaton.ACTION_DISMISS"));
        C0096i.m358a(getActivity()).m363a(new Intent("more_tab_badge_update"));
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    public class OpenSourceDialog extends DialogFragment {
        /* JADX WARN: Removed duplicated region for block: B:71:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
        @Override // android.support.v4.app.DialogFragment
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.app.Dialog mo33a(android.os.Bundle r8) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 262
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.settings.AboutServiceFragment.OpenSourceDialog.mo33a(android.os.Bundle):android.app.Dialog");
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
    public void m13302a(int i) {
        this.f12459u[i].setOnClickListener(new ViewOnClickListenerC3617f(this, i));
    }
}
