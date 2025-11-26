package com.sec.chaton.userprofile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0647s;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.C1805i;
import twitter4j.internal.http.HttpResponseCode;

/* loaded from: classes.dex */
public class ProfileRegistPushName extends BaseActivity {

    /* renamed from: a */
    Context f5955a;

    /* renamed from: b */
    EditText f5956b;

    /* renamed from: c */
    Button f5957c;

    /* renamed from: d */
    Button f5958d;

    /* renamed from: i */
    private Configuration f5960i;

    /* renamed from: j */
    private C0647s f5961j;

    /* renamed from: k */
    private ProgressDialog f5962k;

    /* renamed from: l */
    private Handler f5963l = new HandlerC1651ba(this);

    /* renamed from: m */
    private TextWatcher f5964m = new C1653bc(this);

    /* renamed from: e */
    View.OnClickListener f5959e = new ViewOnClickListenerC1654bd(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_profile_regist_name);
        this.f5955a = this;
        this.f5960i = getResources().getConfiguration();
        m5687a();
    }

    /* renamed from: a */
    private void m5687a() {
        this.f5956b = (EditText) findViewById(R.id.txtName);
        this.f5961j = new C0647s(this.f5963l);
        this.f5956b.setText(C1789u.m6075a().getString("Push Name", ""));
        this.f5956b.setSelection(this.f5956b.length());
        this.f5957c = (Button) findViewById(R.id.btnDone);
        this.f5958d = (Button) findViewById(R.id.btnCancel);
        this.f5957c.setOnClickListener(this.f5959e);
        this.f5958d.setOnClickListener(this.f5959e);
        this.f5956b.addTextChangedListener(this.f5964m);
        this.f5962k = (ProgressDialog) new C1805i(this.f5955a).m6139a(R.string.dialog_userprofile_updating);
        if (this.f5956b.getText().length() > 0) {
            this.f5957c.setEnabled(true);
        }
        if (GlobalApplication.m3265f()) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(HttpResponseCode.INTERNAL_SERVER_ERROR, -2);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C1786r.m6066e("onResume", getClass().getSimpleName());
    }
}
