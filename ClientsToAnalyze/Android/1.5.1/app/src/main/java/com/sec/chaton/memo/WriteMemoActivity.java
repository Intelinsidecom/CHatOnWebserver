package com.sec.chaton.memo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.sec.chaton.C0062R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.control.MemoControl;
import com.sec.chaton.widget.SMSProgressBar;

/* loaded from: classes.dex */
public class WriteMemoActivity extends BaseActivity {

    /* renamed from: i */
    private static String f1936i = "";

    /* renamed from: j */
    private static String f1937j = "";

    /* renamed from: a */
    Context f1938a;

    /* renamed from: b */
    EditText f1939b;

    /* renamed from: c */
    Button f1940c;

    /* renamed from: d */
    Button f1941d;

    /* renamed from: g */
    private MemoControl f1944g;

    /* renamed from: h */
    private ProgressDialog f1945h;

    /* renamed from: e */
    View.OnClickListener f1942e = new ViewOnClickListenerC0249d(this);

    /* renamed from: k */
    private TextWatcher f1946k = new C0250e(this);

    /* renamed from: f */
    public Handler f1943f = new HandlerC0248c(this);

    /* renamed from: c */
    private void m2407c() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f1939b.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: d */
    private void m2408d() {
        this.f1939b = (EditText) findViewById(C0062R.id.mWriteMemoTextView);
        this.f1940c = (Button) findViewById(C0062R.id.btnWriteMemoDone);
        this.f1941d = (Button) findViewById(C0062R.id.btnWriteMemoCancel);
        this.f1940c.setOnClickListener(this.f1942e);
        this.f1941d.setOnClickListener(this.f1942e);
        this.f1939b.addTextChangedListener(this.f1946k);
        this.f1945h = (ProgressDialog) new SMSProgressBar(this.f1938a).onCreate(C0062R.string.dialog_userprofile_updating);
        if (this.f1939b.getText().length() > 0) {
            this.f1940c.setEnabled(true);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.layout_write_memo);
        this.f1938a = this;
        f1936i = getIntent().getExtras().getString("buddyid");
        f1937j = "";
        this.f1944g = new MemoControl(this.f1943f);
        m2408d();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        m2407c();
        super.onPause();
    }
}
