package com.sec.chaton.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.util.C3225cm;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3248w;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3652at;
import java.util.Timer;

/* loaded from: classes.dex */
public class FragmentPasswordLockHint extends Fragment {

    /* renamed from: e */
    private FragmentActivity f9168e;

    /* renamed from: f */
    private MenuItem f9169f;

    /* renamed from: g */
    private MenuItem f9170g;

    /* renamed from: a */
    private final int f9164a = 0;

    /* renamed from: b */
    private String f9165b = ActivityPasswordLockHint.class.getSimpleName();

    /* renamed from: c */
    private EditText f9166c = null;

    /* renamed from: d */
    private String f9167d = null;

    /* renamed from: h */
    private TextWatcher f9171h = new C2659dw(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9168e = (FragmentActivity) activity;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        BaseActivity.m3081a(this, true);
        View viewInflate = layoutInflater.inflate(R.layout.layout_password_lock_hint, viewGroup, false);
        C3225cm.m11337a(this.f9168e);
        C3250y.m11453c("[LIFE] onCreate, isTaskRoot: " + this.f9168e.isTaskRoot() + ", Task ID: " + this.f9168e.getTaskId() + ", Memory Address:" + this, this.f9165b);
        this.f9166c = (EditText) viewInflate.findViewById(R.id.password_hint);
        this.f9166c.setFilters(new InputFilter[]{new C3248w(getActivity(), 40)});
        m9125c();
        this.f9167d = this.f9168e.getSharedPreferences("PASSWORD_LOCK", 0).getString("PASSWORD_HINT", "");
        C3250y.m11453c("[LIFE] onCreate Hint" + this.f9167d, this.f9165b);
        if ("".equals(this.f9167d)) {
            C3250y.m11450b("Hint null", this.f9165b);
        } else {
            this.f9166c.setText(m9121b(this.f9167d));
            Editable text = this.f9166c.getText();
            if (text != null && text.length() != 0) {
                int iMin = Math.min(text.length(), 100);
                this.f9166c.setSelection(iMin, iMin);
            }
            if (this.f9169f != null) {
                this.f9169f.setEnabled(true);
            }
            if (this.f9170g != null) {
                this.f9170g.setEnabled(true);
            }
        }
        this.f9166c.addTextChangedListener(this.f9171h);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.cancel_done_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f9169f = null;
        this.f9170g = null;
        this.f9169f = menu.findItem(R.id.menu_done);
        this.f9169f.setEnabled(false);
        this.f9170g = menu.findItem(R.id.menu_cancel);
        if (this.f9170g != null) {
            this.f9170g.setEnabled(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_done) {
            m9122b();
            return true;
        }
        if (menuItem.getItemId() == R.id.menu_cancel) {
            this.f9168e.finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f9168e = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m9122b() {
        C3250y.m11453c("editTextpasswordhint : " + this.f9166c, this.f9165b);
        this.f9167d = this.f9166c.getText().toString();
        String strM9120a = m9120a(this.f9167d);
        SharedPreferences.Editor editorEdit = this.f9168e.getSharedPreferences("PASSWORD_LOCK", 0).edit();
        editorEdit.putString("PASSWORD_HINT", strM9120a);
        editorEdit.commit();
        this.f9168e.finish();
    }

    /* renamed from: c */
    private void m9125c() {
        this.f9166c.setOnEditorActionListener(new C2658dv(this));
        C3652at.m13219a(this.f9166c, new char[]{','}, R.string.buddy_group_profile_rename_not_allowed_character);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C3250y.m11453c("[LIFE] onStart, isTaskRoot: " + this.f9168e.isTaskRoot() + ", Task ID: " + this.f9168e.getTaskId() + ", Memory Address:" + this, this.f9165b);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m9128a();
        C3250y.m11453c("[LIFE] onResume, isTaskRoot: " + this.f9168e.isTaskRoot() + ", Task ID: " + this.f9168e.getTaskId() + ", Memory Address:" + this, this.f9165b);
        m9126d();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C3250y.m11453c("[LIFE] onPause, isTaskRoot: " + this.f9168e.isTaskRoot() + ", Task ID: " + this.f9168e.getTaskId() + ", Memory Address:" + this, this.f9165b);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        m9127e();
        C3250y.m11453c("[LIFE] onStop, isTaskRoot: " + this.f9168e.isTaskRoot() + ", Task ID: " + this.f9168e.getTaskId() + ", Memory Address:" + this, this.f9165b);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        m9127e();
        C3250y.m11453c("[LIFE] onDestroy, isTaskRoot: " + this.f9168e.isTaskRoot() + ", Task ID: " + this.f9168e.getTaskId() + ", Memory Address:" + this, this.f9165b);
    }

    /* renamed from: d */
    private void m9126d() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = this.f9168e.getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    /* renamed from: a */
    public void m9128a() {
        new Timer(true).schedule(new C2660dx(this, new Handler(), (InputMethodManager) this.f9168e.getSystemService("input_method")), 100L);
    }

    /* renamed from: e */
    private void m9127e() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f9168e.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f9166c.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private String m9120a(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    /* renamed from: b */
    private String m9121b(String str) {
        return new String(Base64.decode(str, 0));
    }
}
