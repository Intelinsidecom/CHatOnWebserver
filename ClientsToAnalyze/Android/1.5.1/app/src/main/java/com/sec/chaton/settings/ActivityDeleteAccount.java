package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.control.AbstractPushControl;
import com.sec.chaton.control.PushControlFactory;
import com.sec.chaton.control.RegistrationControl;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.widget.SMSProgressBar;

/* loaded from: classes.dex */
public class ActivityDeleteAccount extends FragmentActivity {

    /* renamed from: a */
    Context f2986a;

    /* renamed from: d */
    private AbstractPushControl f2989d;

    /* renamed from: e */
    private RegistrationControl f2990e;

    /* renamed from: f */
    private String f2991f;

    /* renamed from: g */
    private ProgressDialog f2992g;

    /* renamed from: h */
    private boolean f2993h = false;

    /* renamed from: b */
    public Handler f2987b = new HandlerC0466ao(this);

    /* renamed from: c */
    Handler f2988c = new HandlerC0464am(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2986a = this;
        setContentView(C0062R.layout.layout_delete_account);
        this.f2993h = false;
        this.f2991f = ChatONPref.m3519a().getString("msisdn", "");
        ((TextView) findViewById(C0062R.id.setting_chaton_account)).setText(getString(C0062R.string.setting_delete_account, new Object[]{""}));
        ((TextView) findViewById(C0062R.id.txt_msisdn)).setText("+" + this.f2991f);
        this.f2990e = new RegistrationControl(this.f2987b);
        this.f2989d = PushControlFactory.m2072a();
        this.f2992g = (ProgressDialog) new SMSProgressBar(this).onCreate(C0062R.string.dialog_setting_delete_account);
        ((Button) findViewById(C0062R.id.btn_delete_account)).setOnClickListener(new ViewOnClickListenerC0465an(this));
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f2993h = true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f2993h = false;
    }
}
