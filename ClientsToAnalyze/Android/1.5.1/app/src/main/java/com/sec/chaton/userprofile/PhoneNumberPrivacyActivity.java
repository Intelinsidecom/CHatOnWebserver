package com.sec.chaton.userprofile;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONPref;

/* loaded from: classes.dex */
public class PhoneNumberPrivacyActivity extends Activity {

    /* renamed from: a */
    private View f3339a;

    /* renamed from: b */
    private TextView f3340b;

    /* renamed from: c */
    private CheckBox f3341c;

    /* renamed from: d */
    private View.OnClickListener f3342d = new ViewOnClickListenerC0576bc(this);

    /* renamed from: e */
    private Handler f3343e = new HandlerC0577bd(this);

    /* renamed from: f */
    private View.OnClickListener f3344f = new ViewOnClickListenerC0578be(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.layout_setting_phone_number_privacy);
        String stringExtra = getIntent().getStringExtra("extra_phone_number");
        this.f3339a = findViewById(C0062R.id.phone_number_layout);
        this.f3339a.setOnClickListener(this.f3342d);
        this.f3340b = (TextView) findViewById(C0062R.id.phone_number_text);
        this.f3340b.setText(stringExtra);
        this.f3341c = (CheckBox) findViewById(C0062R.id.phone_number_checkbox);
        this.f3341c.setChecked(ChatONPref.m3519a().getBoolean("show_phone_number_to_all", false));
        ((Button) findViewById(C0062R.id.btnSave)).setOnClickListener(this.f3344f);
        ((Button) findViewById(C0062R.id.btnCancel)).setOnClickListener(this.f3344f);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setMessage(getString(C0062R.string.dialog_connecting_server));
                progressDialog.setIndeterminate(true);
                return progressDialog;
            default:
                return null;
        }
    }
}
