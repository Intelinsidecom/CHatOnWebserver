package com.sec.chaton.registration;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class FragmentDisclaimer extends Fragment {

    /* renamed from: c */
    private String f8208c;

    /* renamed from: d */
    private Context f8209d;

    /* renamed from: e */
    private FragmentActivity f8210e;

    /* renamed from: f */
    private View f8211f;

    /* renamed from: b */
    private ProgressDialog f8207b = null;

    /* renamed from: a */
    Handler f8206a = new HandlerC2173bx(this, Looper.getMainLooper());

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f8210e = (FragmentActivity) activity;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f8211f = layoutInflater.inflate(R.layout.layout_settings_disclaimer_update, viewGroup, false);
        this.f8209d = this.f8210e;
        this.f8208c = this.f8210e.getIntent().getStringExtra("disclaimerUID");
        return this.f8211f;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f8210e = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C3250y.m11450b("onStart : showDisclaimer", getClass().getSimpleName());
        ((Button) this.f8211f.findViewById(R.id.disclaimer_detial_btn)).setOnClickListener(new ViewOnClickListenerC2171bv(this));
        ((Button) this.f8211f.findViewById(R.id.setting_about_btn3)).setOnClickListener(new ViewOnClickListenerC2172bw(this));
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m8512a();
    }

    /* renamed from: a */
    private void m8512a() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = this.f8210e.getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }
}
