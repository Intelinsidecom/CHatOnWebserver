package com.sec.chaton.registration;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.p025d.C1334l;
import com.sec.chaton.p035io.entry.GetVersionNotice;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.AbstractC3271a;

/* loaded from: classes.dex */
public class NewDisclaimerFragment extends Fragment {

    /* renamed from: c */
    private Button f8361c;

    /* renamed from: d */
    private CheckBox f8362d;

    /* renamed from: e */
    private CheckBox f8363e;

    /* renamed from: f */
    private LinearLayout f8364f;

    /* renamed from: g */
    private LinearLayout f8365g;

    /* renamed from: h */
    private ImageButton f8366h;

    /* renamed from: i */
    private ImageButton f8367i;

    /* renamed from: j */
    private ImageButton f8368j;

    /* renamed from: l */
    private C1324bj f8370l;

    /* renamed from: m */
    private C1334l f8371m;

    /* renamed from: n */
    private FragmentActivity f8372n;

    /* renamed from: o */
    private GetVersionNotice f8373o;

    /* renamed from: k */
    private ProgressDialog f8369k = null;

    /* renamed from: p */
    private String f8374p = NewDisclaimerView.class.getSimpleName();

    /* renamed from: a */
    public Handler f8359a = new HandlerC2283fz(this);

    /* renamed from: q */
    private BroadcastReceiver f8375q = new C2275fr(this);

    /* renamed from: b */
    AsyncTask<Void, Void, Void> f8360b = new AsyncTaskC2276fs(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f8372n = (FragmentActivity) activity;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.new_disclaimer_view, viewGroup, false);
        this.f8361c = (Button) viewInflate.findViewById(R.id.accept_button);
        this.f8362d = (CheckBox) viewInflate.findViewById(R.id.disclaimer_chekcbox);
        this.f8364f = (LinearLayout) viewInflate.findViewById(R.id.linear_disclaimer_chekcbox);
        this.f8363e = (CheckBox) viewInflate.findViewById(R.id.disclaimer_chekcbox2);
        this.f8365g = (LinearLayout) viewInflate.findViewById(R.id.linear_disclaimer_chekcbox2);
        this.f8366h = (ImageButton) viewInflate.findViewById(R.id.link_button);
        this.f8367i = (ImageButton) viewInflate.findViewById(R.id.link_button2);
        this.f8368j = (ImageButton) viewInflate.findViewById(R.id.link_button3);
        this.f8370l = new C1324bj(this.f8359a);
        this.f8371m = new C1334l(this.f8359a);
        this.f8366h.setOnClickListener(new ViewOnClickListenerC2274fq(this));
        this.f8367i.setOnClickListener(new ViewOnClickListenerC2278fu(this));
        this.f8368j.setOnClickListener(new ViewOnClickListenerC2279fv(this));
        this.f8364f.setOnClickListener(new ViewOnClickListenerC2280fw(this));
        this.f8365g.setOnClickListener(new ViewOnClickListenerC2281fx(this));
        this.f8364f.setFocusable(true);
        this.f8362d.setClickable(false);
        this.f8365g.setFocusable(true);
        this.f8363e.setClickable(false);
        this.f8361c.setOnClickListener(new ViewOnClickListenerC2282fy(this));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("upgrade_cancel");
        LocalBroadcastManager.getInstance(getActivity().getApplicationContext()).registerReceiver(this.f8375q, intentFilter);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f8372n = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8654a() {
        if (this.f8362d.isChecked() && this.f8363e.isChecked()) {
            this.f8361c.setEnabled(true);
        } else {
            this.f8361c.setEnabled(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (C3250y.f11734b) {
            C3250y.m11450b("onResume ", this.f8374p);
        }
        m8654a();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (C3250y.f11734b) {
            C3250y.m11450b("onDestroy ", this.f8374p);
        }
        m8659c();
        LocalBroadcastManager.getInstance(getActivity().getApplicationContext()).unregisterReceiver(this.f8375q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8656a(EnumC2289ge enumC2289ge, String str) {
        m8659c();
        if (C3250y.f11734b) {
            C3250y.m11450b("network error, type : " + enumC2289ge.toString() + " errorCode : " + str, this.f8374p);
        }
        if (getActivity() != null) {
            AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(getResources().getString(R.string.toast_network_unable), getResources().getString(R.string.toast_error), str)).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2288gd(this, enumC2289ge)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2287gc(this)).mo11505a().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8658b() {
        if (getActivity() != null) {
            this.f8369k = ProgressDialogC3265l.m11489a(getActivity(), null, getResources().getString(R.string.dialog_provision_ing));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8659c() {
        if (this.f8369k != null && this.f8369k.isShowing()) {
            this.f8369k.dismiss();
        }
    }
}
