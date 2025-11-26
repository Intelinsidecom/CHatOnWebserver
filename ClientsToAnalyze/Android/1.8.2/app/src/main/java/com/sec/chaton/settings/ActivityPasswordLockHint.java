package com.sec.chaton.settings;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.widget.C2126af;
import com.sec.widget.C2153y;

/* loaded from: classes.dex */
public class ActivityPasswordLockHint extends BaseActivity {

    /* renamed from: e */
    private C2153y f4516e;

    /* renamed from: a */
    private final int f4512a = 0;

    /* renamed from: b */
    private String f4513b = ActivityPasswordLockHint.class.getSimpleName();

    /* renamed from: c */
    private EditText f4514c = null;

    /* renamed from: d */
    private String f4515d = null;

    /* renamed from: i */
    private Menu f4517i = null;

    /* renamed from: j */
    private TextWatcher f4518j = new C1227af(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1786r.m6063c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f4513b);
        setContentView(R.layout.layout_password_lock_hint);
        m4523a(getApplicationContext());
        getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4522a() {
        C1786r.m6063c("editTextpasswordhint : " + this.f4514c, this.f4513b);
        this.f4515d = this.f4514c.getText().toString();
        String strM4521a = m4521a(this.f4515d);
        SharedPreferences.Editor editorEdit = getSharedPreferences("password_lock", 0).edit();
        editorEdit.putString("password_hint", strM4521a);
        editorEdit.commit();
        C1786r.m6054a("editTextpasswordhint : " + this.f4514c.getText().toString(), this.f4513b);
        finish();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onUserLeaveHint() {
        C1786r.m6061b("onUserLeaveHint", this.f4513b);
        C1781m.m6022b(getApplicationContext());
    }

    /* renamed from: a */
    private void m4523a(Context context) {
        this.f4514c = (EditText) findViewById(R.id.password_hint);
        this.f4514c.addTextChangedListener(this.f4518j);
        this.f4514c.setText(m4524b(context.getSharedPreferences("password_lock", 0).getString("password_hint", "")));
        this.f4514c.setOnEditorActionListener(new C1226ae(this));
        C2126af.m7480a(this.f4514c, new char[]{','}, R.string.buddy_group_profile_rename_not_allowed_character);
        this.f4516e = (C2153y) C2153y.m7535a(this, R.string.description_for_passlock_hint_enter_error, 0);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        C1786r.m6063c("[LIFE] onStart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f4513b);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C1786r.m6063c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f4513b);
        m4525b();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        C1786r.m6063c("[LIFE] onRestart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f4513b);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        C1786r.m6063c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f4513b);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        C1786r.m6063c("[LIFE] onStop, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f4513b);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C1786r.m6063c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f4513b);
    }

    /* renamed from: b */
    private void m4525b() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    /* renamed from: a */
    private String m4521a(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    /* renamed from: b */
    private String m4524b(String str) {
        return new String(Base64.decode(str.getBytes(), 0));
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_title_done_cancel_next, menu);
        menu.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
        menu.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(false);
        menu.findItem(R.id.actionbar_title_cancel).setVisible(true).setEnabled(true);
        menu.removeItem(R.id.actionbar_title_next);
        this.f4517i = menu;
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                break;
            case R.id.actionbar_title_cancel /* 2131494128 */:
                finish();
                break;
            case R.id.actionbar_title_done /* 2131494130 */:
                m4522a();
                return true;
            default:
                return true;
        }
        finish();
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
}
