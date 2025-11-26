package com.sec.chaton.userprofile;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextWatcher;
import android.widget.EditText;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p013a.C0226y;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.C1356c;
import com.sec.widget.GeneralHeaderView;

/* loaded from: classes.dex */
public class ProfileRegistStatusMessage extends BaseActivity {

    /* renamed from: a */
    Context f4182a;

    /* renamed from: b */
    EditText f4183b;

    /* renamed from: c */
    private C0226y f4184c;

    /* renamed from: d */
    private ProgressDialog f4185d;

    /* renamed from: e */
    private GeneralHeaderView f4186e;

    /* renamed from: f */
    private Handler f4187f = new HandlerC1269s(this);

    /* renamed from: g */
    private TextWatcher f4188g = new C1267q(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_profile_regist_status_message);
        this.f4182a = this;
        m4346a();
    }

    /* renamed from: a */
    private void m4346a() {
        this.f4183b = (EditText) findViewById(R.id.mStatusMessageTextView);
        this.f4184c = new C0226y(this.f4187f);
        this.f4183b.setText(C1323bs.m4575a().getString("status_message", ""));
        this.f4183b.setSelection(this.f4183b.length());
        this.f4186e = (GeneralHeaderView) findViewById(R.id.mypage_profile_headerView);
        this.f4186e.setButtonClickListener(new ViewOnClickListenerC1268r(this));
        this.f4183b.addTextChangedListener(this.f4188g);
        this.f4185d = (ProgressDialog) new C1356c(this.f4182a).m4728a(R.string.dialog_userprofile_updating);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C1341p.m4662e("onResume", getClass().getSimpleName());
    }
}
