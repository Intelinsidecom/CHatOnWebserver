package com.sec.chaton.registration;

import android.content.Context;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.sec.chaton.C0062R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class ActivityRegistPushName extends BaseActivity {

    /* renamed from: a */
    EditText f2879a;

    /* renamed from: b */
    Button f2880b;

    /* renamed from: c */
    Button f2881c;

    /* renamed from: d */
    Context f2882d;

    /* renamed from: f */
    private TextWatcher f2884f = new C0432h(this);

    /* renamed from: e */
    View.OnClickListener f2883e = new ViewOnClickListenerC0431g(this);

    /* renamed from: a */
    private void m3091a() {
        this.f2879a = (EditText) findViewById(C0062R.id.txtName);
        this.f2880b = (Button) findViewById(C0062R.id.btnDone);
        this.f2881c = (Button) findViewById(C0062R.id.btnCancel);
        this.f2880b.setOnClickListener(this.f2883e);
        this.f2881c.setOnClickListener(this.f2883e);
        this.f2879a.addTextChangedListener(this.f2884f);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2882d = this;
        setContentView(C0062R.layout.layout_regist_name);
        m3091a();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ChatONLogWriter.m3511e("onResume", getClass().getSimpleName());
    }
}
