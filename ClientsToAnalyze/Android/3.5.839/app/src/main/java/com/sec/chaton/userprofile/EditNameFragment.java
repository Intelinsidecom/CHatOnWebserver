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
import com.sec.chaton.widget.C4923p;

/* loaded from: classes.dex */
public class EditNameFragment extends Fragment {

    /* renamed from: b */
    public static final String f17118b = EditNameFragment.class.getSimpleName();

    /* renamed from: a */
    Context f17119a;

    /* renamed from: c */
    private EditText f17120c;

    /* renamed from: d */
    private C2075ah f17121d;

    /* renamed from: e */
    private ProgressDialog f17122e;

    /* renamed from: f */
    private String f17123f;

    /* renamed from: g */
    private MenuItem f17124g;

    /* renamed from: i */
    private TextView f17126i;

    /* renamed from: j */
    private TextView f17127j;

    /* renamed from: k */
    private int f17128k;

    /* renamed from: h */
    private boolean f17125h = false;

    /* renamed from: l */
    private TextWatcher f17129l = new C4797p(this);

    /* renamed from: m */
    private Handler f17130m = new HandlerC4798q(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17119a = getActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_buddypage_edit_name, viewGroup, false);
        this.f17120c = (EditText) viewInflate.findViewById(R.id.nickname);
        this.f17126i = (TextView) viewInflate.findViewById(R.id.title);
        this.f17127j = (TextView) viewInflate.findViewById(R.id.text_length);
        this.f17127j.setVisibility(0);
        this.f17126i.setText(R.string.mypage_profile_name);
        this.f17123f = C4809aa.m18104a().m18121a("Push Name", "");
        this.f17120c.setText(this.f17123f);
        this.f17120c.setSingleLine();
        this.f17120c.setSelection(this.f17120c.length());
        this.f17120c.setFilters(new InputFilter[]{new C4902w(getActivity(), 30)});
        this.f17120c.addTextChangedListener(this.f17129l);
        this.f17121d = new C2075ah(this.f17130m);
        this.f17122e = (ProgressDialog) new C4923p(getActivity()).m18724a(R.string.dialog_userprofile_updating);
        if (bundle != null) {
            this.f17120c.setText(bundle.getString("TEXT_NAME"));
            this.f17128k = bundle.getInt("TEXT_LENGTH_VALUE");
            this.f17127j.setText(this.f17128k + "/30");
        } else {
            this.f17127j.setText(this.f17123f.length() + "/30");
        }
        BaseActivity.m6160a((Fragment) this, true);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f17122e != null && this.f17122e.isShowing()) {
            this.f17122e.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("TEXT_LENGTH_VALUE", this.f17128k);
        bundle.putString("TEXT_NAME", this.f17120c.getText().toString());
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.activity_edit_profile_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f17124g = null;
        this.f17124g = menu.findItem(R.id.edit_profile_menu_done);
        this.f17124g.setEnabled(false);
        if (this.f17125h) {
            this.f17124g.setEnabled(true);
        } else {
            this.f17124g.setEnabled(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.edit_profile_menu_cancel) {
            getActivity().finish();
        }
        if (menuItem.getItemId() == R.id.edit_profile_menu_done) {
            m17820a();
            C0792p c0792p = new C0792p();
            c0792p.m3156a(this.f17120c.getText().toString().trim());
            this.f17121d.m9304a(c0792p, "");
            this.f17122e.show();
        }
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getActivity().finish();
        return true;
    }

    /* renamed from: a */
    private void m17820a() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f17120c.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }
}
