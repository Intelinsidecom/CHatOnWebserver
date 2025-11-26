package com.sec.chaton.sns.p115ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public abstract class SnsMessageFragment extends Fragment implements TextWatcher {

    /* renamed from: a */
    protected Activity f16037a;

    /* renamed from: b */
    private InterfaceC4450ad f16038b;

    /* renamed from: c */
    private InterfaceC4451ae f16039c;

    /* renamed from: d */
    private View f16040d;

    /* renamed from: e */
    private TextView f16041e;

    /* renamed from: f */
    private EditText f16042f;

    /* renamed from: l */
    private int f16048l;

    /* renamed from: g */
    private ProgressDialog f16043g = null;

    /* renamed from: h */
    private InputFilter[] f16044h = null;

    /* renamed from: i */
    private String f16045i = null;

    /* renamed from: j */
    private String f16046j = null;

    /* renamed from: k */
    private String f16047k = null;

    /* renamed from: m */
    private Toast f16049m = null;

    protected SnsMessageFragment() {
    }

    /* renamed from: a */
    private void m16891a(Bundle bundle) {
        this.f16045i = "";
        this.f16046j = "";
        if (bundle != null) {
            this.f16045i = bundle.getString("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendName");
            this.f16046j = bundle.getString("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendID");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        this.f16040d = layoutInflater.inflate(R.layout.layout_sns_message, viewGroup, false);
        this.f16041e = (TextView) this.f16040d.findViewById(R.id.text_remain);
        this.f16042f = (EditText) this.f16040d.findViewById(R.id.edit_text_input);
        m16893e();
        m16900b(this.f16047k.toString().length());
        setHasOptionsMenu(true);
        return this.f16040d;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        m16891a(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (this.f16045i != null) {
            bundle.putString("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendName", this.f16045i);
        }
        if (this.f16046j != null) {
            bundle.putString("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendID", this.f16046j);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f16037a = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f16037a = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.done_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_done) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.f16038b != null) {
            this.f16038b.mo16936a(m16899b(), m16894a());
        }
        return true;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f16039c != null) {
            this.f16039c.mo16937a(null);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.f16039c != null) {
            this.f16039c.mo16937a(editable);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* renamed from: e */
    private void m16893e() throws Resources.NotFoundException {
        String string = this.f16037a.getResources().getString(R.string.sns_invite_message_full_feature, "www.chaton.com/invite.html");
        if (this.f16045i == null || TextUtils.isEmpty(this.f16045i)) {
            this.f16047k = string;
        } else {
            this.f16047k = "@" + this.f16045i + " " + string;
        }
        this.f16042f.addTextChangedListener(this);
        this.f16042f.setText(this.f16047k);
        this.f16042f.setSelection(this.f16042f.getText().length());
        if (this.f16044h != null) {
            this.f16042f.setFilters(this.f16044h);
        } else {
            this.f16042f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f16048l)});
        }
    }

    /* renamed from: a */
    protected void m16898a(InputFilter[] inputFilterArr) {
        this.f16044h = inputFilterArr;
    }

    /* renamed from: a */
    protected void m16895a(int i) {
        this.f16048l = i;
    }

    /* renamed from: a */
    protected String m16894a() {
        return this.f16042f.getText().toString();
    }

    /* renamed from: b */
    protected String m16899b() {
        return this.f16046j;
    }

    /* renamed from: b */
    protected void m16900b(int i) {
        this.f16041e.setText(String.format("(%d/%d)", Integer.valueOf(i), Integer.valueOf(this.f16048l)));
    }

    /* renamed from: a */
    private void m16892a(boolean z) {
        if (this.f16043g == null) {
            C4904y.m18639b("showProgressDialog() \t- null. create and show", getClass().getSimpleName());
            this.f16043g = ProgressDialog.show(this.f16037a, null, getString(R.string.facebook_post_wait));
            this.f16043g.setCancelable(false);
            this.f16043g.setOnKeyListener(new DialogInterfaceOnKeyListenerC4448ab(this, z));
            return;
        }
        C4904y.m18639b("showProgressDialog() \t- not null. show", getClass().getSimpleName());
        this.f16043g.show();
    }

    /* renamed from: c */
    protected void m16901c() {
        m16892a(true);
    }

    /* renamed from: d */
    protected void m16902d() {
        boolean zIsShowing;
        if (this.f16043g != null && (zIsShowing = this.f16043g.isShowing())) {
            C4904y.m18639b("dismissProgressDialog() \t- mProgressDialog : " + this.f16043g + ". isSowing : " + zIsShowing, getClass().getSimpleName());
            this.f16043g.dismiss();
            this.f16043g = null;
        }
    }

    /* renamed from: a */
    public void m16896a(InterfaceC4450ad interfaceC4450ad) {
        this.f16038b = interfaceC4450ad;
    }

    /* renamed from: a */
    public void m16897a(InterfaceC4451ae interfaceC4451ae) {
        this.f16039c = interfaceC4451ae;
    }
}
