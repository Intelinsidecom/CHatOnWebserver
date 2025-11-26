package com.sec.chaton.buddy;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.p017e.p019b.C0683j;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.ProgressDialogC1806j;

/* loaded from: classes.dex */
public class BuddyProfileEditNameActivity extends BaseActivity {

    /* renamed from: a */
    public static final String f1074a = BuddyProfileEditNameActivity.class.getSimpleName();

    /* renamed from: c */
    C0633e f1076c;

    /* renamed from: i */
    private Context f1079i;

    /* renamed from: j */
    private EditText f1080j;

    /* renamed from: k */
    private String f1081k;

    /* renamed from: l */
    private C0666j f1082l;

    /* renamed from: m */
    private String f1083m;

    /* renamed from: n */
    private String f1084n;

    /* renamed from: b */
    String f1075b = C1767bw.m6003b();

    /* renamed from: o */
    private ProgressDialog f1085o = null;

    /* renamed from: p */
    private boolean f1086p = false;

    /* renamed from: d */
    InterfaceC0677d f1077d = new C0328cm(this);

    /* renamed from: q */
    private TextWatcher f1087q = new C0329cn(this);

    /* renamed from: e */
    InterfaceC0667k f1078e = new C0330co(this);

    /* renamed from: r */
    private Handler f1088r = new HandlerC0331cp(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1786r.m6067f("onCreate()", f1074a);
        setContentView(R.layout.buddy_profile_rename);
        this.f1083m = getIntent().getExtras().getString("PROFILE_BUDDY_NO");
        this.f1084n = getIntent().getExtras().getString("PROFILE_BUDDY_NAME");
        this.f1082l = new C0666j(getContentResolver(), this.f1078e);
        this.f1085o = new ProgressDialogC1806j(this, false);
        this.f1085o.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        this.f1076c = new C0633e(this.f1088r);
        getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
        m2106a();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        this.f1080j.removeTextChangedListener(this.f1087q);
        super.onPause();
    }

    /* renamed from: a */
    private void m2106a() {
        this.f1079i = this;
        this.f1086p = false;
        this.f1080j = (EditText) findViewById(R.id.buddy_profile_edit_buddyname);
        this.f1080j.setText(this.f1084n);
        this.f1080j.setSelection(this.f1080j.length());
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f1079i.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.f1080j, 1);
            }
        } catch (Exception e) {
        }
        this.f1080j.addTextChangedListener(this.f1087q);
    }

    /* renamed from: b */
    private void m2110b() {
        this.f1080j.clearFocus();
        m2107a(this.f1080j);
        this.f1081k = this.f1080j.getText().toString().trim();
        if (!TextUtils.isEmpty(this.f1081k)) {
            this.f1076c.m2852a("update", false, this.f1081k, "+" + this.f1083m);
            this.f1085o.show();
            C0668l.m3077a(new C0668l(), 2, new C0683j(this.f1077d, this.f1081k, this.f1083m, 2));
        }
        Bundle bundle = new Bundle();
        Intent intent = new Intent();
        bundle.putString("PROFILE_BUDDY_RENAME", this.f1081k);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    /* renamed from: a */
    private void m2107a(EditText editText) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f1079i.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f1080j.addTextChangedListener(this.f1087q);
        m2112c();
    }

    /* renamed from: c */
    private void m2112c() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f1085o != null && this.f1085o.isShowing()) {
            this.f1085o.dismiss();
            this.f1085o = null;
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setTitle(R.string.buddy_profile_edit_name);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        switch (menuItem.getItemId()) {
            case R.id.actionbar_title_cancel /* 2131494128 */:
                finish();
                return true;
            case R.id.actionbar_title_change /* 2131494129 */:
            default:
                return true;
            case R.id.actionbar_title_done /* 2131494130 */:
                m2110b();
                return true;
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.clear();
        getMenuInflater().inflate(R.menu.actionbar_title_done_cancel_next, menu);
        menu.removeItem(R.id.actionbar_title_next);
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.f1086p) {
            menu.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
            menu.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
        } else {
            menu.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(true);
            menu.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }
}
