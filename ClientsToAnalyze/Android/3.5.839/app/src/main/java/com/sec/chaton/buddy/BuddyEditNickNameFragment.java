package com.sec.chaton.buddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
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
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.p058a.C2191e;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.util.C4902w;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5144ag;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class BuddyEditNickNameFragment extends Fragment {

    /* renamed from: a */
    C2128i f3558a;

    /* renamed from: b */
    Context f3559b;

    /* renamed from: e */
    private EditText f3562e;

    /* renamed from: f */
    private MenuItem f3563f;

    /* renamed from: g */
    private TextView f3564g;

    /* renamed from: h */
    private String f3565h;

    /* renamed from: i */
    private String f3566i;

    /* renamed from: j */
    private C2210x f3567j;

    /* renamed from: k */
    private ProgressDialog f3568k;

    /* renamed from: l */
    private String[] f3569l;

    /* renamed from: n */
    private Activity f3571n;

    /* renamed from: m */
    private boolean f3570m = false;

    /* renamed from: o */
    private boolean f3572o = false;

    /* renamed from: p */
    private Handler f3573p = new HandlerC1126aq(this);

    /* renamed from: c */
    InterfaceC2243d f3560c = new C1128as(this);

    /* renamed from: q */
    private TextWatcher f3574q = new C1129at(this);

    /* renamed from: r */
    private Handler f3575r = new HandlerC1130au(this);

    /* renamed from: d */
    InterfaceC2211y f3561d = new C1132aw(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3571n = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3571n = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3559b = this.f3571n.getApplicationContext();
        this.f3565h = this.f3571n.getIntent().getExtras().getString("PROFILE_ID");
        this.f3566i = this.f3571n.getIntent().getExtras().getString("PROFILE_NAME");
        this.f3570m = this.f3571n.getIntent().getExtras().getBoolean("PROFILE_BUDDY_MODE");
        this.f3569l = this.f3571n.getIntent().getExtras().getStringArray("PROFILE_BUDDY_LIST");
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        m6270a();
        super.onDestroy();
        if (this.f3568k != null) {
            this.f3568k.dismiss();
        }
    }

    /* renamed from: a */
    private void m6270a() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f3571n.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f3562e.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_buddypage_edit_name, viewGroup, false);
        BaseActivity.m6160a((Fragment) this, true);
        this.f3562e = (EditText) viewInflate.findViewById(R.id.nickname);
        this.f3562e.setText(this.f3566i);
        this.f3562e.setSingleLine(true);
        this.f3562e.setSelection(this.f3562e.length());
        this.f3562e.addTextChangedListener(this.f3574q);
        this.f3562e.setFilters(new InputFilter[]{new C4902w(this.f3559b, 30)});
        if (!this.f3570m) {
            C5144ag.m19709a(this.f3562e, new char[]{','}, R.string.buddy_group_profile_rename_not_allowed_character);
        }
        this.f3564g = (TextView) viewInflate.findViewById(R.id.text_length);
        this.f3564g.setText(this.f3562e.length() + "/30");
        this.f3567j = new C2210x(this.f3571n.getContentResolver(), this.f3561d);
        this.f3558a = new C2128i(this.f3575r);
        this.f3568k = (ProgressDialog) new C4923p(this.f3571n).m18724a(R.string.dialog_userprofile_updating);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.edit_profile_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f3563f = menu.findItem(R.id.edit_profile_menu_done);
        this.f3563f.setEnabled(false);
        if (this.f3572o) {
            this.f3563f.setEnabled(true);
        } else {
            this.f3563f.setEnabled(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) throws Throwable {
        if (menuItem.getItemId() == R.id.edit_profile_menu_cancel) {
            this.f3571n.finish();
        }
        if (menuItem.getItemId() == R.id.edit_profile_menu_done) {
            if (!this.f3570m) {
                if (m6273b()) {
                    return true;
                }
                boolean zM9869f = C2191e.m9869f(CommonApplication.m18732r().getContentResolver(), this.f3562e.getText().toString().trim().replace(",", ""));
                if (this.f3566i.equals(this.f3562e.getText().toString()) || zM9869f) {
                    AbstractC4932a.m18733a(this.f3571n).mo18734a(R.string.pop_up_attention).mo18749b(this.f3571n.getResources().getString(R.string.buddy_group_list_addgroup_toast_exist, this.f3562e.getText().toString().trim())).mo18756d(R.string.dialog_ok, null).mo18752b();
                    return true;
                }
                m6275c();
            } else {
                m6277d();
            }
            int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
            if (-3 != iM10677a && -2 != iM10677a && !this.f3571n.isFinishing() && this.f3568k != null && !this.f3568k.isShowing()) {
                this.f3568k.show();
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: b */
    private boolean m6273b() {
        if (!this.f3562e.getText().toString().trim().replace(",", "").toUpperCase().equals("FAVORITES")) {
            return false;
        }
        AbstractC4932a.m18733a(this.f3571n).mo18734a(R.string.pop_up_attention).mo18749b(this.f3571n.getResources().getString(R.string.buddy_group_list_addgroup_toast_exist, this.f3562e.getText().toString().trim())).mo18756d(R.string.dialog_ok, null).mo18752b();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6275c() {
        String strTrim = this.f3562e.getText().toString().trim();
        if (!TextUtils.isEmpty(strTrim)) {
            int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
            if (-3 == iM10677a || -2 == iM10677a) {
                C5179v.m19810a(this.f3559b, R.string.popup_no_network_connection, 0).show();
                return;
            }
            new C2128i(this.f3573p).m9489a("group", false, this.f3566i, strTrim, this.f3569l, 326);
            if (this.f3568k != null && !this.f3568k.isShowing()) {
                this.f3568k.show();
            }
        }
    }

    /* renamed from: d */
    private void m6277d() {
        String strTrim = this.f3562e.getText().toString().trim();
        if (!TextUtils.isEmpty(strTrim)) {
            int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
            if (-3 == iM10677a || -2 == iM10677a) {
                C5179v.m19810a(this.f3559b, R.string.popup_no_network_connection, 0).show();
            } else {
                this.f3558a.m9488a("update", false, strTrim, "+" + this.f3565h);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C4904y.m18646e("onResume", getClass().getSimpleName());
        if (!this.f3570m) {
            this.f3571n.setTitle(getText(R.string.buddy_profile_edit_name));
        } else {
            this.f3571n.setTitle(getText(R.string.mypage_edit_profile_edit_nickname));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        ((InputMethodManager) this.f3571n.getSystemService("input_method")).hideSoftInputFromWindow(this.f3562e.getWindowToken(), 0);
        super.onPause();
    }
}
