package com.sec.chaton.registration;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.AbstractC0531a;
import com.sec.chaton.p015d.C0620aj;
import com.sec.chaton.p015d.C0621ak;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.ProgressDialogC1806j;

/* loaded from: classes.dex */
public class ActivityRegistPushName extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo649a() {
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14) {
            getActionBar();
        }
        return new RegistPushNameFragment();
    }

    public class RegistPushNameFragment extends Fragment {

        /* renamed from: a */
        EditText f4257a;

        /* renamed from: b */
        LinearLayout f4258b;

        /* renamed from: c */
        Button f4259c;

        /* renamed from: d */
        Button f4260d;

        /* renamed from: e */
        Activity f4261e;

        /* renamed from: i */
        private String f4265i;

        /* renamed from: j */
        private String f4266j;

        /* renamed from: k */
        private String f4267k;

        /* renamed from: l */
        private AbstractC0531a f4268l;

        /* renamed from: m */
        private C0621ak f4269m;

        /* renamed from: n */
        private ProgressDialog f4270n;

        /* renamed from: o */
        private Menu f4271o;

        /* renamed from: p */
        private TextWatcher f4272p = new C1157ak(this);

        /* renamed from: f */
        View.OnClickListener f4262f = new ViewOnClickListenerC1158al(this);

        /* renamed from: g */
        Handler f4263g = new HandlerC1159am(this);

        /* renamed from: h */
        public Handler f4264h = new HandlerC1160an(this);

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            int dimension;
            View viewInflate = layoutInflater.inflate(R.layout.layout_regist_name, viewGroup, false);
            if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 11) {
                getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
            }
            this.f4257a = (EditText) viewInflate.findViewById(R.id.txtName);
            this.f4258b = (LinearLayout) viewInflate.findViewById(R.id.pushName_rootView);
            this.f4257a.setInputType(524288);
            this.f4259c = (Button) viewInflate.findViewById(R.id.btnDone);
            this.f4260d = (Button) viewInflate.findViewById(R.id.btnCancel);
            this.f4261e = getActivity();
            if (getResources().getConfiguration().orientation == 1) {
                dimension = (int) getResources().getDimension(R.dimen.terms_and_condition_padding_port);
            } else {
                dimension = (int) getResources().getDimension(R.dimen.terms_and_condition_padding_land);
            }
            this.f4258b.setPadding(dimension, 0, dimension, 0);
            this.f4267k = C1789u.m6075a().getString("msisdn", null);
            this.f4265i = C1789u.m6075a().getString("token", null);
            if (this.f4265i == null) {
                C1786r.m6061b("PREF_TOKEN is null. check PREF_ACS_TOKEN" + this.f4265i, getClass().getSimpleName());
                this.f4265i = C1789u.m6075a().getString("acstoken", null);
            }
            this.f4266j = C1789u.m6075a().getString("authnum", null);
            C1786r.m6061b("mAuthNum" + this.f4266j + "sToken" + this.f4265i, getClass().getSimpleName());
            this.f4268l = C0620aj.m2804a();
            this.f4269m = new C0621ak(this.f4264h);
            m4399b();
            return viewInflate;
        }

        @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
            int dimensionPixelOffset;
            if (configuration.orientation == 1) {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.terms_and_condition_padding_port);
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.terms_and_condition_padding_land);
            }
            this.f4258b.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
            super.onConfigurationChanged(configuration);
        }

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            BaseActivity.m1829b(this, true);
        }

        @Override // android.support.v4.app.Fragment
        public void onPrepareOptionsMenu(Menu menu) {
            menu.clear();
            getActivity().getMenuInflater().inflate(R.menu.actionbar_title_done_cancel_next, menu);
            menu.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
            menu.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(false);
            menu.removeItem(R.id.actionbar_title_next);
            this.f4271o = menu;
            m4401c();
        }

        @Override // android.support.v4.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case android.R.id.home:
                    getActivity().finish();
                    break;
                case R.id.actionbar_title_cancel /* 2131494128 */:
                    getActivity().finish();
                    break;
                case R.id.actionbar_title_done /* 2131494130 */:
                    m4405a();
                    break;
            }
            return true;
        }

        /* renamed from: b */
        private void m4399b() {
            this.f4259c.setOnClickListener(this.f4262f);
            this.f4260d.setOnClickListener(this.f4262f);
            this.f4257a.addTextChangedListener(this.f4272p);
        }

        @Override // android.support.v4.app.Fragment
        public void onResume() {
            super.onResume();
            C1786r.m6066e("onResume", getClass().getSimpleName());
            m4401c();
        }

        /* renamed from: c */
        private void m4401c() {
            if (GlobalApplication.m3265f() && this.f4271o != null && this.f4257a != null) {
                if (this.f4257a.length() > 0) {
                    int i = 0;
                    while (true) {
                        if (i >= this.f4257a.length()) {
                            break;
                        }
                        if (this.f4257a.getText().charAt(i) != ' ') {
                            this.f4271o.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
                            this.f4271o.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
                            break;
                        } else {
                            this.f4271o.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
                            this.f4271o.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(false);
                            i++;
                        }
                    }
                }
                if (this.f4257a.length() < 1) {
                    this.f4271o.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
                    this.f4271o.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(false);
                }
            }
        }

        /* renamed from: a */
        protected void m4405a() {
            this.f4259c.setEnabled(false);
            this.f4270n = ProgressDialogC1806j.m6141a(this.f4261e, null, getResources().getString(R.string.please_wait), true);
            this.f4268l.mo2702a(this.f4263g);
        }
    }
}
