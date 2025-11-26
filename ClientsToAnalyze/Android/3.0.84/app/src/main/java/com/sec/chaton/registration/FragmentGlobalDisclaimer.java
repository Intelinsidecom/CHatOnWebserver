package com.sec.chaton.registration;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.p025d.C1334l;
import com.sec.chaton.p035io.entry.GetVersionNotice;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.AbstractC3271a;

/* loaded from: classes.dex */
public class FragmentGlobalDisclaimer extends Fragment {

    /* renamed from: g */
    private static final String f8212g = FragmentGlobalDisclaimer.class.getSimpleName();

    /* renamed from: d */
    private C1334l f8216d;

    /* renamed from: e */
    private C1324bj f8217e;

    /* renamed from: f */
    private GetVersionNotice f8218f;

    /* renamed from: c */
    private ProgressDialog f8215c = null;

    /* renamed from: a */
    public Handler f8213a = new HandlerC2178cb(this);

    /* renamed from: h */
    private BroadcastReceiver f8219h = new C2184ch(this);

    /* renamed from: b */
    AsyncTask<Void, Void, Void> f8214b = new AsyncTaskC2185ci(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.layout_settings_disclaimer, viewGroup, false);
        this.f8216d = new C1334l(this.f8213a);
        this.f8217e = new C1324bj(this.f8213a);
        Button button = (Button) viewInflate.findViewById(R.id.setting_about_btn1);
        button.setFocusable(true);
        button.requestFocus();
        button.setOnClickListener(new ViewOnClickListenerC2174by(this));
        ((Button) viewInflate.findViewById(R.id.setting_about_btn2)).setOnClickListener(new ViewOnClickListenerC2175bz(this));
        ((Button) viewInflate.findViewById(R.id.setting_about_btn3)).setOnClickListener(new ViewOnClickListenerC2177ca(this));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("upgrade_cancel");
        LocalBroadcastManager.getInstance(getActivity().getApplicationContext()).registerReceiver(this.f8219h, intentFilter);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C3250y.f11734b) {
            C3250y.m11450b("onCreate", f8212g);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (C3250y.f11734b) {
            C3250y.m11450b("onResume", f8212g);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (C3250y.f11734b) {
            C3250y.m11450b("onDestroy ", f8212g);
        }
        m8524c();
        LocalBroadcastManager.getInstance(getActivity().getApplicationContext()).unregisterReceiver(this.f8219h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8523b() {
        if (getActivity() != null) {
            this.f8215c = ProgressDialogC3265l.m11489a(getActivity(), null, getResources().getString(R.string.dialog_provision_ing));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8524c() {
        if (this.f8215c != null && this.f8215c.isShowing()) {
            this.f8215c.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8521a(EnumC2187ck enumC2187ck, String str) {
        m8524c();
        if (C3250y.f11734b) {
            C3250y.m11450b("network error, type : " + enumC2187ck.toString() + " errorCode : " + str, f8212g);
        }
        if (getActivity() != null) {
            AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(getResources().getString(R.string.toast_network_unable), getResources().getString(R.string.toast_error), str)).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2183cg(this, enumC2187ck)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2182cf(this)).mo11505a().show();
        }
    }
}
