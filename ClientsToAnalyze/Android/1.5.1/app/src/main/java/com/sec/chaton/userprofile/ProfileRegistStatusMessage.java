package com.sec.chaton.userprofile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.sec.chaton.C0062R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.control.ProfileControl;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.widget.SMSProgressBar;

/* loaded from: classes.dex */
public class ProfileRegistStatusMessage extends BaseActivity {

    /* renamed from: a */
    Context f3355a;

    /* renamed from: b */
    EditText f3356b;

    /* renamed from: c */
    Button f3357c;

    /* renamed from: d */
    Button f3358d;

    /* renamed from: f */
    private Configuration f3360f;

    /* renamed from: g */
    private ProfileControl f3361g;

    /* renamed from: h */
    private ProgressDialog f3362h;

    /* renamed from: i */
    private Handler f3363i = new HandlerC0592p(this);

    /* renamed from: j */
    private TextWatcher f3364j = new C0591o(this);

    /* renamed from: e */
    View.OnClickListener f3359e = new ViewOnClickListenerC0590n(this);

    /* renamed from: a */
    private void m3329a() {
        this.f3356b = (EditText) findViewById(C0062R.id.mStatusMessageTextView);
        this.f3361g = new ProfileControl(this.f3363i);
        this.f3356b.setText(ChatONPref.m3519a().getString("status_message", ""));
        this.f3356b.setSelection(this.f3356b.length());
        this.f3357c = (Button) findViewById(C0062R.id.btnDone);
        this.f3358d = (Button) findViewById(C0062R.id.btnCancel);
        this.f3357c.setOnClickListener(this.f3359e);
        this.f3358d.setOnClickListener(this.f3359e);
        this.f3356b.addTextChangedListener(this.f3364j);
        this.f3362h = (ProgressDialog) new SMSProgressBar(this.f3355a).onCreate(C0062R.string.dialog_userprofile_updating);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.layout_profile_regist_status_message);
        this.f3355a = this;
        this.f3360f = getResources().getConfiguration();
        m3329a();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ChatONLogWriter.m3511e("onResume", getClass().getSimpleName());
    }
}
