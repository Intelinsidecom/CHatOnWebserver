package com.sec.chaton.registration;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.p013a.AbstractC0196ai;
import com.sec.chaton.p013a.C0192ae;
import com.sec.chaton.p013a.C0203b;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.widget.C1606ac;
import com.sec.widget.GeneralHeaderView;

/* loaded from: classes.dex */
public class ActivityRegistPushName extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo664a() {
        return new RegistPushNameFragment();
    }

    public class RegistPushNameFragment extends Fragment {

        /* renamed from: a */
        EditText f3232a;

        /* renamed from: b */
        Button f3233b;

        /* renamed from: c */
        Button f3234c;

        /* renamed from: d */
        Activity f3235d;

        /* renamed from: h */
        private String f3239h;

        /* renamed from: i */
        private String f3240i;

        /* renamed from: j */
        private String f3241j;

        /* renamed from: k */
        private AbstractC0196ai f3242k;

        /* renamed from: l */
        private C0203b f3243l;

        /* renamed from: m */
        private ProgressDialog f3244m;

        /* renamed from: n */
        private Menu f3245n;

        /* renamed from: o */
        private GeneralHeaderView f3246o;

        /* renamed from: p */
        private TextWatcher f3247p = new C0934af(this);

        /* renamed from: e */
        View.OnClickListener f3236e = new ViewOnClickListenerC0933ae(this);

        /* renamed from: f */
        Handler f3237f = new HandlerC0937ai(this);

        /* renamed from: g */
        public Handler f3238g = new HandlerC0935ag(this);

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewInflate = layoutInflater.inflate(R.layout.layout_regist_name, viewGroup, false);
            this.f3232a = (EditText) viewInflate.findViewById(R.id.txtName);
            this.f3232a.setInputType(524288);
            this.f3233b = (Button) viewInflate.findViewById(R.id.btnDone);
            this.f3234c = (Button) viewInflate.findViewById(R.id.btnCancel);
            this.f3235d = getActivity();
            this.f3241j = C1323bs.m4575a().getString("msisdn", null);
            this.f3239h = C1323bs.m4575a().getString("token", null);
            if (this.f3239h == null) {
                C1341p.m4658b("PREF_TOKEN is null. check PREF_ACS_TOKEN" + this.f3239h, getClass().getSimpleName());
                this.f3239h = C1323bs.m4575a().getString("acstoken", null);
            }
            this.f3240i = C1323bs.m4575a().getString("authnum", null);
            C1341p.m4658b("mAuthNum" + this.f3240i + "sToken" + this.f3239h, getClass().getSimpleName());
            this.f3242k = C0192ae.m739a();
            this.f3243l = new C0203b(this.f3238g);
            this.f3246o = (GeneralHeaderView) viewInflate.findViewById(R.id.header_view);
            this.f3246o.setButtonEnabled(false);
            this.f3246o.setButtonClickListener(new ViewOnClickListenerC0932ad(this));
            m3712b();
            return viewInflate;
        }

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            BaseActivity.m2043b(this, true);
        }

        @Override // android.support.v4.app.Fragment
        public void onPrepareOptionsMenu(Menu menu) {
            menu.clear();
            getActivity().getMenuInflater().inflate(R.menu.actionbar_title_done_cancel_next, menu);
            menu.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
            menu.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(false);
            menu.removeItem(R.id.actionbar_title_cancel);
            menu.removeItem(R.id.actionbar_title_next);
            this.f3245n = menu;
        }

        @Override // android.support.v4.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.actionbar_title_cancel /* 2131428237 */:
                    getActivity().finish();
                    break;
                case R.id.actionbar_title_done /* 2131428239 */:
                    m3717a();
                    break;
            }
            return true;
        }

        /* renamed from: b */
        private void m3712b() {
            this.f3233b.setOnClickListener(this.f3236e);
            this.f3234c.setOnClickListener(this.f3236e);
            this.f3232a.addTextChangedListener(this.f3247p);
            C1606ac.m5880a(this.f3232a, new char[]{','}, R.string.buddy_group_profile_rename_not_allowed_character);
            this.f3232a.setOnEditorActionListener(new C0931ac(this));
        }

        @Override // android.support.v4.app.Fragment
        public void onDestroy() {
            super.onDestroy();
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f3232a.getWindowToken(), 0);
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onResume() {
            super.onResume();
            C1341p.m4662e("onResume", getClass().getSimpleName());
        }

        /* renamed from: a */
        protected void m3717a() {
            this.f3233b.setEnabled(false);
            this.f3246o.setButtonEnabled(false);
            if (this.f3235d != null) {
                this.f3244m = ProgressDialogC1354a.m4724a(this.f3235d, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            }
            this.f3242k.mo741a(this.f3237f);
        }
    }
}
