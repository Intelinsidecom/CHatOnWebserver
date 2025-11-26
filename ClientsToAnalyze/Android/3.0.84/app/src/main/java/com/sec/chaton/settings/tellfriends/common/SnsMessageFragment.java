package com.sec.chaton.settings.tellfriends.common;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputFilter;
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
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public abstract class SnsMessageFragment extends Fragment implements TextWatcher {

    /* renamed from: a */
    protected Activity f10235a;

    /* renamed from: b */
    private InterfaceC2805u f10236b;

    /* renamed from: c */
    private InterfaceC2806v f10237c;

    /* renamed from: d */
    private View f10238d;

    /* renamed from: e */
    private TextView f10239e;

    /* renamed from: f */
    private EditText f10240f;

    /* renamed from: l */
    private int f10246l;

    /* renamed from: g */
    private ProgressDialog f10241g = null;

    /* renamed from: h */
    private InputFilter[] f10242h = null;

    /* renamed from: i */
    private String f10243i = null;

    /* renamed from: j */
    private String f10244j = null;

    /* renamed from: k */
    private String f10245k = null;

    /* renamed from: m */
    private Toast f10247m = null;

    protected SnsMessageFragment() {
    }

    /* renamed from: a */
    private void m9964a(Bundle bundle) {
        if (bundle != null) {
            this.f10243i = bundle.getString("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendName", "");
            this.f10244j = bundle.getString("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendID", "");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        this.f10238d = layoutInflater.inflate(R.layout.layout_sns_message, viewGroup, false);
        this.f10239e = (TextView) this.f10238d.findViewById(R.id.text_remain);
        this.f10240f = (EditText) this.f10238d.findViewById(R.id.edit_text_input);
        m9966e();
        m9973b(this.f10245k.toString().length());
        setHasOptionsMenu(true);
        return this.f10238d;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        m9964a(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (this.f10243i != null) {
            bundle.putString("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendName", this.f10243i);
        }
        if (this.f10244j != null) {
            bundle.putString("com.sec.chaton.settings.tellfriends.common.SnsMessageFragment.FriendID", this.f10244j);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f10235a = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f10235a = null;
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
        if (this.f10236b != null) {
            this.f10236b.mo9713a(m9972b(), m9967a());
        }
        return true;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f10237c != null) {
            this.f10237c.mo9712a(null);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.f10237c != null) {
            this.f10237c.mo9712a(editable);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* renamed from: e */
    private void m9966e() throws Resources.NotFoundException {
        String string = this.f10235a.getResources().getString(R.string.sns_invite_message, "www.ChatON.com/invite.html");
        if (this.f10243i == null || this.f10243i.isEmpty()) {
            this.f10245k = string;
        } else {
            this.f10245k = "@" + this.f10243i + " " + string;
        }
        this.f10240f.addTextChangedListener(this);
        this.f10240f.setText(this.f10245k);
        this.f10240f.setSelection(this.f10240f.getText().length());
        if (this.f10242h != null) {
            this.f10240f.setFilters(this.f10242h);
        } else {
            this.f10240f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f10246l)});
        }
    }

    /* renamed from: a */
    protected void m9971a(InputFilter[] inputFilterArr) {
        this.f10242h = inputFilterArr;
    }

    /* renamed from: a */
    protected void m9968a(int i) {
        this.f10246l = i;
    }

    /* renamed from: a */
    protected String m9967a() {
        return this.f10240f.getText().toString();
    }

    /* renamed from: b */
    protected String m9972b() {
        return this.f10244j;
    }

    /* renamed from: b */
    protected void m9973b(int i) {
        this.f10239e.setText(String.format("(%d/%d)", Integer.valueOf(i), Integer.valueOf(this.f10246l)));
    }

    /* renamed from: a */
    private void m9965a(boolean z) {
        if (this.f10241g == null) {
            C3250y.m11450b("showProgressDialog() \t- null. create and show", getClass().getSimpleName());
            this.f10241g = ProgressDialog.show(this.f10235a, null, getString(R.string.facebook_post_wait));
            this.f10241g.setCancelable(false);
            this.f10241g.setOnKeyListener(new DialogInterfaceOnKeyListenerC2803s(this, z));
            return;
        }
        C3250y.m11450b("showProgressDialog() \t- not null. show", getClass().getSimpleName());
        this.f10241g.show();
    }

    /* renamed from: c */
    protected void m9974c() {
        m9965a(true);
    }

    /* renamed from: d */
    protected void m9975d() {
        boolean zIsShowing;
        if (this.f10241g != null && (zIsShowing = this.f10241g.isShowing())) {
            C3250y.m11450b("dismissProgressDialog() \t- mProgressDialog : " + this.f10241g + ". isSowing : " + zIsShowing, getClass().getSimpleName());
            this.f10241g.dismiss();
            this.f10241g = null;
        }
    }

    /* renamed from: a */
    public void m9969a(InterfaceC2805u interfaceC2805u) {
        this.f10236b = interfaceC2805u;
    }

    /* renamed from: a */
    public void m9970a(InterfaceC2806v interfaceC2806v) {
        this.f10237c = interfaceC2806v;
    }
}
