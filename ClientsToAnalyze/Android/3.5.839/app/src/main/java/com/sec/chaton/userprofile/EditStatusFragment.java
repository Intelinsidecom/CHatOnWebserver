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
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p046a.p047a.C0792p;
import com.sec.chaton.p055d.C2075ah;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4902w;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class EditStatusFragment extends Fragment {

    /* renamed from: b */
    public static final String f17131b = EditStatusFragment.class.getSimpleName();

    /* renamed from: a */
    Context f17132a;

    /* renamed from: c */
    private EditText f17133c;

    /* renamed from: d */
    private C2075ah f17134d;

    /* renamed from: e */
    private ProgressDialog f17135e;

    /* renamed from: f */
    private String f17136f;

    /* renamed from: g */
    private MenuItem f17137g;

    /* renamed from: i */
    private TextView f17139i;

    /* renamed from: j */
    private TextView f17140j;

    /* renamed from: k */
    private int f17141k;

    /* renamed from: h */
    private boolean f17138h = false;

    /* renamed from: l */
    private TextWatcher f17142l = new C4800s(this);

    /* renamed from: m */
    private Handler f17143m = new HandlerC4801t(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17132a = getActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_buddypage_edit_name, viewGroup, false);
        this.f17139i = (TextView) viewInflate.findViewById(R.id.title);
        this.f17140j = (TextView) viewInflate.findViewById(R.id.text_length);
        this.f17140j.setVisibility(0);
        this.f17133c = (EditText) viewInflate.findViewById(R.id.nickname);
        this.f17139i.setText(R.string.mypage_profile_status);
        this.f17136f = C4809aa.m18104a().m18121a("status_message", "");
        this.f17133c.setText(this.f17136f);
        this.f17133c.setSelection(this.f17133c.length());
        this.f17133c.setFilters(new InputFilter[]{new C4902w(getActivity(), 40)});
        this.f17133c.addTextChangedListener(this.f17142l);
        this.f17133c.setHint(R.string.mypage_enter_status_message);
        this.f17134d = new C2075ah(this.f17143m);
        this.f17135e = (ProgressDialog) new C4923p(getActivity()).m18724a(R.string.dialog_userprofile_updating);
        if (bundle != null) {
            this.f17133c.setText(bundle.getString("TEXT_STATUS"));
            this.f17141k = bundle.getInt("TEXT_LENGTH_VALUE");
            this.f17140j.setText(this.f17141k + "/40");
        } else {
            this.f17140j.setText(this.f17136f.length() + "/40");
        }
        BaseActivity.m6160a((Fragment) this, true);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f17135e != null && this.f17135e.isShowing()) {
            this.f17135e.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("TEXT_LENGTH_VALUE", this.f17141k);
        bundle.putString("TEXT_STATUS", this.f17133c.getText().toString());
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.activity_edit_profile_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f17137g = null;
        this.f17137g = menu.findItem(R.id.edit_profile_menu_done);
        this.f17137g.setEnabled(false);
        if (this.f17138h) {
            this.f17137g.setEnabled(true);
        } else {
            this.f17137g.setEnabled(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.edit_profile_menu_cancel) {
            getActivity().finish();
        }
        if (menuItem.getItemId() == R.id.edit_profile_menu_done) {
            if (C4904y.m18637a(this.f17133c.getText().toString())) {
                this.f17133c.setText("");
                if (C4904y.m18630a() == 1) {
                    if (C4904y.f17871a) {
                        C4904y.m18646e("Chat ON Log : ON > OFF", getClass().getSimpleName());
                    }
                    C4904y.m18632a(0);
                    C5179v.m19811a(CommonApplication.m18732r(), "Log Off", 1).show();
                    return true;
                }
                C4904y.m18632a(1);
                if (C4904y.f17871a) {
                    C4904y.m18646e("Chat ON Log : OFF > ON", getClass().getSimpleName());
                }
                C5179v.m19811a(CommonApplication.m18732r(), "Log On", 1).show();
                return true;
            }
            if (C4904y.m18640b(this.f17133c.getText().toString())) {
                this.f17133c.setText("");
                if (C4904y.m18630a() == 2) {
                    if (C4904y.f17871a) {
                        C4904y.m18646e("Chat ON Log : ON > OFF", getClass().getSimpleName());
                    }
                    C4904y.m18632a(0);
                    C5179v.m19811a(CommonApplication.m18732r(), "Log Off", 1).show();
                    return true;
                }
                C4904y.m18632a(2);
                if (C4904y.f17871a) {
                    C4904y.m18646e("Chat ON Log : OFF > ON With Save", getClass().getSimpleName());
                }
                C5179v.m19811a(CommonApplication.m18732r(), "Log On With Save", 1).show();
                return true;
            }
            m17830a();
            C0792p c0792p = new C0792p();
            c0792p.m3158b(this.f17133c.getText().toString());
            this.f17134d.m9304a(c0792p, "");
            this.f17135e.show();
        }
        if (menuItem.getItemId() == 16908332) {
            getActivity().finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: a */
    private void m17830a() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f17133c.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }
}
