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
public class ProfileRegistPushName extends BaseActivity {

    /* renamed from: a */
    Context f3345a;

    /* renamed from: b */
    EditText f3346b;

    /* renamed from: c */
    Button f3347c;

    /* renamed from: d */
    Button f3348d;

    /* renamed from: f */
    private Configuration f3350f;

    /* renamed from: g */
    private ProfileControl f3351g;

    /* renamed from: h */
    private ProgressDialog f3352h;

    /* renamed from: i */
    private Handler f3353i = new HandlerC0560an(this);

    /* renamed from: j */
    private TextWatcher f3354j = new C0561ao(this);

    /* renamed from: e */
    View.OnClickListener f3349e = new ViewOnClickListenerC0559am(this);

    /* renamed from: a */
    private void m3326a() {
        this.f3346b = (EditText) findViewById(C0062R.id.txtName);
        this.f3351g = new ProfileControl(this.f3353i);
        this.f3346b.setText(ChatONPref.m3519a().getString("Push Name", ""));
        this.f3346b.setSelection(this.f3346b.length());
        this.f3347c = (Button) findViewById(C0062R.id.btnDone);
        this.f3348d = (Button) findViewById(C0062R.id.btnCancel);
        this.f3347c.setOnClickListener(this.f3349e);
        this.f3348d.setOnClickListener(this.f3349e);
        this.f3346b.addTextChangedListener(this.f3354j);
        this.f3352h = (ProgressDialog) new SMSProgressBar(this.f3345a).onCreate(C0062R.string.dialog_userprofile_updating);
        if (this.f3346b.getText().length() > 0) {
            this.f3347c.setEnabled(true);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.layout_profile_regist_name);
        this.f3345a = this;
        this.f3350f = getResources().getConfiguration();
        m3326a();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ChatONLogWriter.m3511e("onResume", getClass().getSimpleName());
    }
}
