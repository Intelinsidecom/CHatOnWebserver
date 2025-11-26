package com.sec.chaton.memo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p013a.C0224w;
import com.sec.chaton.widget.C1356c;
import com.sec.widget.GeneralHeaderView;

/* loaded from: classes.dex */
public class WriteMemoActivity extends BaseActivity {

    /* renamed from: g */
    private static String f2456g = "";

    /* renamed from: i */
    private static String f2457i = "";

    /* renamed from: a */
    Context f2458a;

    /* renamed from: b */
    EditText f2459b;

    /* renamed from: e */
    private C0224w f2462e;

    /* renamed from: f */
    private ProgressDialog f2463f;

    /* renamed from: j */
    private GeneralHeaderView f2464j;

    /* renamed from: c */
    View.OnClickListener f2460c = new ViewOnClickListenerC0732e(this);

    /* renamed from: k */
    private TextWatcher f2465k = new C0733f(this);

    /* renamed from: d */
    public Handler f2461d = new HandlerC0731d(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_write_memo);
        this.f2458a = this;
        f2456g = getIntent().getExtras().getString("buddyid");
        f2457i = "";
        this.f2462e = new C0224w(this.f2461d);
        m3133d();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        m3132c();
        super.onDestroy();
    }

    /* renamed from: c */
    private void m3132c() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f2459b.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: d */
    private void m3133d() {
        this.f2459b = (EditText) findViewById(R.id.mWriteMemoTextView);
        this.f2464j = (GeneralHeaderView) findViewById(R.id.buddies_say_write_header_view);
        this.f2464j.setButtonClickListener(this.f2460c);
        this.f2464j.setButtonEnabled(false);
        this.f2459b.addTextChangedListener(this.f2465k);
        this.f2463f = (ProgressDialog) new C1356c(this.f2458a).m4728a(R.string.dialog_userprofile_updating);
    }
}
