package com.sec.chaton.registration;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Button;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class ActivityDisclaimer extends BaseActivity {

    /* renamed from: a */
    Handler f3149a = new HandlerC0942an(this, Looper.getMainLooper());

    /* renamed from: b */
    private ProgressDialog f3150b;

    /* renamed from: c */
    private String f3151c;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_settings_disclaimer);
        this.f3151c = getIntent().getStringExtra("disclaimerUID");
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        C1341p.m4658b("onStart : showDisclaimer", getClass().getSimpleName());
        Button button = (Button) findViewById(R.id.setting_about_btn1);
        button.setFocusable(true);
        button.requestFocus();
        button.setOnClickListener(new ViewOnClickListenerC0945aq(this));
        ((Button) findViewById(R.id.setting_about_btn2)).setOnClickListener(new ViewOnClickListenerC0944ap(this));
        ((Button) findViewById(R.id.setting_about_btn3)).setOnClickListener(new ViewOnClickListenerC0943ao(this));
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        C1341p.m4658b("Test3", "ChatON");
        finish();
        GlobalApplication.m3102a(this);
        return true;
    }
}
