package com.sec.chaton.registration;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class FragmentDisclaimerUpdate extends Fragment {

    /* renamed from: c */
    private String f11660c;

    /* renamed from: d */
    private Context f11661d;

    /* renamed from: e */
    private FragmentActivity f11662e;

    /* renamed from: f */
    private View f11663f;

    /* renamed from: b */
    private ProgressDialog f11659b = null;

    /* renamed from: a */
    Handler f11658a = new HandlerC3197cl(this, Looper.getMainLooper());

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11662e = (FragmentActivity) activity;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f11663f = layoutInflater.inflate(R.layout.layout_settings_disclaimer_update, viewGroup, false);
        this.f11661d = this.f11662e;
        this.f11660c = this.f11662e.getIntent().getStringExtra("disclaimerUID");
        return this.f11663f;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f11662e = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C4904y.m18639b("onStart : showDisclaimer", getClass().getSimpleName());
        ((Button) this.f11663f.findViewById(R.id.disclaimer_detial_btn)).setOnClickListener(new ViewOnClickListenerC3195cj(this));
        ((Button) this.f11663f.findViewById(R.id.setting_about_btn3)).setOnClickListener(new ViewOnClickListenerC3196ck(this));
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
