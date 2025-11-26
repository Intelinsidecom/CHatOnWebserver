package com.sec.chaton.memo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0638j;
import com.sec.chaton.widget.C1805i;

/* loaded from: classes.dex */
public class WriteMemoActivity extends BaseActivity {

    /* renamed from: l */
    private static String f3064l = "";

    /* renamed from: m */
    private static String f3065m = "";

    /* renamed from: a */
    Context f3066a;

    /* renamed from: b */
    EditText f3067b;

    /* renamed from: c */
    Button f3068c;

    /* renamed from: d */
    Button f3069d;

    /* renamed from: j */
    private C0638j f3072j;

    /* renamed from: k */
    private ProgressDialog f3073k;

    /* renamed from: n */
    private Menu f3074n;

    /* renamed from: e */
    View.OnClickListener f3070e = new ViewOnClickListenerC0841e(this);

    /* renamed from: o */
    private TextWatcher f3075o = new C0842f(this);

    /* renamed from: i */
    public Handler f3071i = new HandlerC0843g(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_write_memo);
        this.f3066a = this;
        f3064l = getIntent().getExtras().getString("buddyid");
        f3065m = "";
        this.f3072j = new C0638j(this.f3071i);
        m3490d();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (GlobalApplication.m3265f()) {
            this.f3067b.requestFocus();
            this.f3067b.invalidate();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        if (GlobalApplication.m3265f()) {
            menuInflater.inflate(R.menu.actionbar_menu_done_cancel, menu);
            menu.removeItem(R.id.actionbar_menu_delete_group);
            menu.findItem(R.id.actionbar_menu_done).setVisible(true).setEnabled(false);
        }
        this.f3074n = menu;
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (GlobalApplication.m3265f()) {
            if (menuItem.getItemId() == R.id.actionbar_menu_done) {
                if (this.f3067b.getText().toString().trim().length() > 0) {
                    this.f3072j.m2896a(new C0839c(f3064l, f3065m, this.f3067b.getText().toString(), String.valueOf(System.currentTimeMillis())));
                    this.f3073k.show();
                    return true;
                }
                return true;
            }
            if (menuItem.getItemId() == R.id.actionbar_menu_cancel) {
                setResult(0);
                finish();
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        m3489c();
        super.onPause();
    }

    /* renamed from: c */
    private void m3489c() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f3067b.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: d */
    private void m3490d() {
        this.f3067b = (EditText) findViewById(R.id.mWriteMemoTextView);
        if (!GlobalApplication.m3265f()) {
            this.f3068c = (Button) findViewById(R.id.btnWriteMemoDone);
            this.f3069d = (Button) findViewById(R.id.btnWriteMemoCancel);
            this.f3068c.setOnClickListener(this.f3070e);
            this.f3069d.setOnClickListener(this.f3070e);
            if (this.f3067b.getText().length() > 0) {
                this.f3068c.setEnabled(true);
            }
        }
        this.f3067b.addTextChangedListener(this.f3075o);
        this.f3073k = (ProgressDialog) new C1805i(this.f3066a).m6139a(R.string.dialog_userprofile_updating);
    }
}
