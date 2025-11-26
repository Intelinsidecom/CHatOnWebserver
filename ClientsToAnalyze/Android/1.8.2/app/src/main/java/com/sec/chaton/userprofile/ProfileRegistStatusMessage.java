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
public class ProfileRegistStatusMessage extends BaseActivity {

    /* renamed from: a */
    Context f5965a;

    /* renamed from: b */
    EditText f5966b;

    /* renamed from: c */
    Button f5967c;

    /* renamed from: d */
    Button f5968d;

    /* renamed from: i */
    private Configuration f5970i;

    /* renamed from: j */
    private C0647s f5971j;

    /* renamed from: k */
    private ProgressDialog f5972k;

    /* renamed from: l */
    private Handler f5973l = new HandlerC1655be(this);

    /* renamed from: m */
    private TextWatcher f5974m = new C1657bg(this);

    /* renamed from: e */
    View.OnClickListener f5969e = new ViewOnClickListenerC1658bh(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_profile_regist_status_message);
        this.f5965a = this;
        this.f5970i = getResources().getConfiguration();
        m5690a();
    }

    /* renamed from: a */
    private void m5690a() {
        this.f5966b = (EditText) findViewById(R.id.mStatusMessageTextView);
        this.f5971j = new C0647s(this.f5973l);
        this.f5966b.setText(C1789u.m6075a().getString("status_message", ""));
        this.f5966b.setSelection(this.f5966b.length());
        this.f5967c = (Button) findViewById(R.id.btnDone);
        this.f5968d = (Button) findViewById(R.id.btnCancel);
        this.f5967c.setOnClickListener(this.f5969e);
        this.f5968d.setOnClickListener(this.f5969e);
        this.f5966b.addTextChangedListener(this.f5974m);
        this.f5972k = (ProgressDialog) new C1805i(this.f5965a).m6139a(R.string.dialog_userprofile_updating);
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
