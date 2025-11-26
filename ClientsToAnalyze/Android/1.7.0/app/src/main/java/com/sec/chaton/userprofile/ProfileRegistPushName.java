package com.sec.chaton.userprofile;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p013a.C0226y;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.C1356c;
import com.sec.widget.C1606ac;

/* loaded from: classes.dex */
public class ProfileRegistPushName extends BaseActivity {

    /* renamed from: a */
    Context f4173a;

    /* renamed from: b */
    EditText f4174b;

    /* renamed from: c */
    Button f4175c;

    /* renamed from: d */
    Button f4176d;

    /* renamed from: f */
    private C0226y f4178f;

    /* renamed from: g */
    private ProgressDialog f4179g;

    /* renamed from: i */
    private Handler f4180i = new HandlerC1222as(this);

    /* renamed from: j */
    private TextWatcher f4181j = new C1223at(this);

    /* renamed from: e */
    View.OnClickListener f4177e = new ViewOnClickListenerC1221ar(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_profile_regist_name);
        this.f4173a = this;
        m4342b();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        m4341a();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4341a() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f4174b.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    private void m4342b() {
        this.f4174b = (EditText) findViewById(R.id.txtName);
        C1606ac.m5880a(this.f4174b, new char[]{','}, R.string.buddy_group_profile_rename_not_allowed_character);
        this.f4178f = new C0226y(this.f4180i);
        this.f4174b.setText(C1323bs.m4575a().getString("Push Name", ""));
        this.f4174b.setSelection(this.f4174b.length());
        this.f4175c = (Button) findViewById(R.id.btnDone);
        this.f4176d = (Button) findViewById(R.id.btnCancel);
        this.f4175c.setOnClickListener(this.f4177e);
        this.f4176d.setOnClickListener(this.f4177e);
        this.f4174b.addTextChangedListener(this.f4181j);
        this.f4179g = (ProgressDialog) new C1356c(this.f4173a).m4728a(R.string.dialog_userprofile_updating);
        if (this.f4174b.getText().length() > 0) {
            this.f4175c.setEnabled(true);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C1341p.m4662e("onResume", getClass().getSimpleName());
    }
}
