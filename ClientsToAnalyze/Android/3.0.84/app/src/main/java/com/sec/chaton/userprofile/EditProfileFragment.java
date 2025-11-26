package com.sec.chaton.userprofile;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
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
import com.sec.chaton.p016a.p017a.C0276m;
import com.sec.chaton.p025d.C1345w;
import com.sec.chaton.p033i.p034a.C1535d;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3248w;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.lang.Thread;

/* loaded from: classes.dex */
public class EditProfileFragment extends Fragment {

    /* renamed from: a */
    Context f11067a;

    /* renamed from: b */
    private EditText f11068b;

    /* renamed from: c */
    private EditText f11069c;

    /* renamed from: d */
    private C1345w f11070d;

    /* renamed from: e */
    private ProgressDialog f11071e;

    /* renamed from: f */
    private MenuItem f11072f;

    /* renamed from: g */
    private boolean f11073g = false;

    /* renamed from: h */
    private TextWatcher f11074h = new C3156y(this);

    /* renamed from: i */
    private TextWatcher f11075i = new C3157z(this);

    /* renamed from: j */
    private Handler f11076j = new HandlerC3075aa(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11067a = getActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_mypage_edit_profile, viewGroup, false);
        this.f11068b = (EditText) viewInflate.findViewById(R.id.name);
        this.f11068b.setText(C3159aa.m10962a().m10979a("Push Name", ""));
        this.f11068b.setSelection(this.f11068b.length());
        this.f11068b.setFilters(new InputFilter[]{new C3248w(getActivity(), 30)});
        this.f11068b.addTextChangedListener(this.f11074h);
        this.f11069c = (EditText) viewInflate.findViewById(R.id.status_message);
        this.f11069c.setText(C3159aa.m10962a().m10979a("status_message", ""));
        this.f11069c.setSelection(this.f11069c.length());
        this.f11069c.setFilters(new InputFilter[]{new C3248w(getActivity(), 40)});
        this.f11069c.addTextChangedListener(this.f11075i);
        this.f11070d = new C1345w(this.f11076j);
        this.f11071e = (ProgressDialog) new C3263j(getActivity()).m11487a(R.string.dialog_userprofile_updating);
        BaseActivity.m3081a(this, true);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f11071e != null && this.f11071e.isShowing()) {
            this.f11071e.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.activity_edit_profile_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f11072f = null;
        this.f11072f = menu.findItem(R.id.edit_profile_menu_done);
        this.f11072f.setEnabled(false);
        if (this.f11073g) {
            this.f11072f.setEnabled(true);
        } else {
            this.f11072f.setEnabled(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.edit_profile_menu_cancel) {
            getActivity().finish();
        }
        if (menuItem.getItemId() == R.id.edit_profile_menu_done) {
            if (C3250y.m11446a(this.f11069c.getText().toString())) {
                this.f11069c.setText("");
                if (C3250y.m11447b() > 0) {
                    if (C3250y.f11733a) {
                        C3250y.m11456e("Chat ON Log : ON > OFF", getClass().getSimpleName());
                    }
                    C3250y.m11448b(0);
                    C3641ai.m13211a(CommonApplication.m11493l(), "Log Off", 1).show();
                    return true;
                }
                C3250y.m11448b(1);
                if (C3250y.f11733a) {
                    C3250y.m11456e("Chat ON Log : OFF > ON", getClass().getSimpleName());
                }
                C3641ai.m13211a(CommonApplication.m11493l(), "Log On", 1).show();
                return true;
            }
            if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector) && this.f11068b.getText().toString().equals("logcollector")) {
                if (C1535d.m6527a()) {
                    C1535d.m6526a(false);
                    C3641ai.m13211a(CommonApplication.m11493l(), "Log Collector Test Off", 1).show();
                    return true;
                }
                C1535d.m6526a(true);
                if (C1535d.m6528b().getState() != Thread.State.RUNNABLE) {
                    C1535d.m6528b().start();
                }
                C3641ai.m13211a(CommonApplication.m11493l(), "Log Collector Test On", 1).show();
                return true;
            }
            m10667a();
            C0276m c0276m = new C0276m();
            c0276m.m1368a(this.f11068b.getText().toString());
            c0276m.m1370b(this.f11069c.getText().toString());
            this.f11070d.m5928a(c0276m, "");
            this.f11071e.show();
        }
        if (menuItem.getItemId() == 16908332) {
            getActivity().finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: a */
    private void m10667a() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f11068b.getWindowToken(), 0);
                inputMethodManager.hideSoftInputFromWindow(this.f11069c.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }
}
