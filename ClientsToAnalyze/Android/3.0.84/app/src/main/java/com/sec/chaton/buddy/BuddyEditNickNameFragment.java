package com.sec.chaton.buddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.p028a.C1362f;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p027e.p029b.C1420k;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3248w;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.util.log.collector.C3358h;
import com.sec.widget.C3641ai;

/* loaded from: classes.dex */
public class BuddyEditNickNameFragment extends Fragment {

    /* renamed from: a */
    C1330h f1708a;

    /* renamed from: b */
    Context f1709b;

    /* renamed from: e */
    private EditText f1712e;

    /* renamed from: f */
    private MenuItem f1713f;

    /* renamed from: g */
    private String f1714g;

    /* renamed from: h */
    private String f1715h;

    /* renamed from: i */
    private C1377u f1716i;

    /* renamed from: j */
    private ProgressDialog f1717j;

    /* renamed from: k */
    private String[] f1718k;

    /* renamed from: m */
    private Activity f1720m;

    /* renamed from: l */
    private boolean f1719l = false;

    /* renamed from: n */
    private Handler f1721n = new HandlerC0536au(this);

    /* renamed from: c */
    InterfaceC1413d f1710c = new C0538aw(this);

    /* renamed from: o */
    private TextWatcher f1722o = new C0539ax(this);

    /* renamed from: p */
    private Handler f1723p = new HandlerC0540ay(this);

    /* renamed from: d */
    InterfaceC1378v f1711d = new C0543ba(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f1720m = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f1720m = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1709b = this.f1720m.getApplicationContext();
        this.f1714g = this.f1720m.getIntent().getExtras().getString("PROFILE_ID");
        this.f1715h = this.f1720m.getIntent().getExtras().getString("PROFILE_NAME");
        this.f1719l = this.f1720m.getIntent().getExtras().getBoolean("PROFILE_BUDDY_MODE");
        this.f1718k = this.f1720m.getIntent().getExtras().getStringArray("PROFILE_BUDDY_LIST");
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C3358h.m11842a().m11846a("00040005");
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        m3201a();
        super.onDestroy();
        if (this.f1717j != null) {
            this.f1717j.dismiss();
        }
    }

    /* renamed from: a */
    private void m3201a() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f1720m.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f1712e.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_buddypage_edit_name, viewGroup, false);
        BaseActivity.m3081a(this, true);
        this.f1712e = (EditText) viewInflate.findViewById(R.id.nickname);
        this.f1712e.setText(this.f1715h);
        this.f1712e.setSelection(this.f1712e.length());
        this.f1712e.addTextChangedListener(this.f1722o);
        this.f1712e.setFilters(new InputFilter[]{new C3248w(this.f1709b, 30)});
        this.f1716i = new C1377u(this.f1720m.getContentResolver(), this.f1711d);
        this.f1708a = new C1330h(this.f1723p);
        this.f1717j = (ProgressDialog) new C3263j(this.f1720m).m11487a(R.string.dialog_userprofile_updating);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.edit_profile_menu, menu);
        this.f1713f = menu.findItem(R.id.edit_profile_menu_done);
        this.f1713f.setEnabled(false);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) throws Throwable {
        if (menuItem.getItemId() == R.id.edit_profile_menu_cancel) {
            this.f1720m.finish();
        }
        if (menuItem.getItemId() == R.id.edit_profile_menu_done) {
            if (!this.f1719l) {
                if (m3203b()) {
                    return true;
                }
                boolean zM6074f = C1362f.m6074f(CommonApplication.m11493l().getContentResolver(), this.f1712e.getText().toString());
                if (this.f1715h.equals(this.f1712e.getText().toString()) || zM6074f) {
                    AbstractC3271a.m11494a(this.f1720m).mo11495a(R.string.pop_up_attention).mo11509b(this.f1720m.getResources().getString(R.string.buddy_group_list_addgroup_toast_exist, this.f1712e.getText().toString().trim())).mo11515d(R.string.dialog_ok, null).mo11512b();
                    return true;
                }
                m3205c();
            } else {
                m3207d();
            }
            int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
            if (-3 != iM6733a && -2 != iM6733a && !this.f1720m.isFinishing() && this.f1717j != null && !this.f1717j.isShowing()) {
                this.f1717j.show();
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: b */
    private boolean m3203b() {
        if (!this.f1712e.getText().toString().trim().replace(",", "").toUpperCase().equals("FAVORITES")) {
            return false;
        }
        AbstractC3271a.m11494a(this.f1720m).mo11495a(R.string.pop_up_attention).mo11509b(this.f1720m.getResources().getString(R.string.buddy_group_list_addgroup_toast_exist, this.f1712e.getText().toString().trim())).mo11515d(R.string.dialog_ok, null).mo11512b();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3205c() {
        String strTrim = this.f1712e.getText().toString().trim();
        if (!TextUtils.isEmpty(strTrim)) {
            int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
            if (-3 == iM6733a || -2 == iM6733a) {
                C3641ai.m13210a(this.f1709b, R.string.popup_no_network_connection, 0).show();
                return;
            }
            new C1330h(this.f1721n).m5716a("group", false, this.f1715h, strTrim, this.f1718k, 326);
            if (this.f1717j != null && !this.f1717j.isShowing()) {
                this.f1717j.show();
            }
        }
    }

    /* renamed from: d */
    private void m3207d() {
        String strTrim = this.f1712e.getText().toString().trim();
        if (!TextUtils.isEmpty(strTrim)) {
            int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
            if (-3 == iM6733a || -2 == iM6733a) {
                C3641ai.m13210a(this.f1709b, R.string.popup_no_network_connection, 0).show();
                return;
            }
            this.f1708a.m5715a("update", false, strTrim, "+" + this.f1714g);
            C1379w.m6203a(new C1379w(), 1, new C1420k(this.f1710c, strTrim, this.f1714g, 2));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C3250y.m11456e("onResume", getClass().getSimpleName());
        if (!this.f1719l) {
            this.f1720m.setTitle(getText(R.string.buddy_profile_edit_name));
        } else {
            this.f1720m.setTitle(getText(R.string.mypage_edit_profile_edit_nickname));
        }
        m3208e();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        ((InputMethodManager) this.f1720m.getSystemService("input_method")).hideSoftInputFromWindow(this.f1712e.getWindowToken(), 0);
        super.onPause();
    }

    /* renamed from: e */
    private void m3208e() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = this.f1720m.getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }
}
