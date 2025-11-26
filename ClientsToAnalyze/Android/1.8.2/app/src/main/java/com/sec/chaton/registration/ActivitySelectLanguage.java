package com.sec.chaton.registration;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0622al;
import com.sec.chaton.p028io.entry.GetSMSAuthToken;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ActivitySelectLanguage extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo649a() {
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14) {
            getActionBar();
        }
        return new SelectLanguageFragment();
    }

    public class SelectLanguageFragment extends Fragment {

        /* renamed from: b */
        protected GetSMSAuthToken f4274b;

        /* renamed from: e */
        private Map f4277e;

        /* renamed from: f */
        private Map f4278f;

        /* renamed from: g */
        private CharSequence[] f4279g;

        /* renamed from: h */
        private CharSequence[] f4280h;

        /* renamed from: i */
        private LinearLayout f4281i;

        /* renamed from: j */
        private TextView f4282j;

        /* renamed from: k */
        private TextView f4283k;

        /* renamed from: m */
        private Context f4285m;

        /* renamed from: n */
        private Menu f4286n;

        /* renamed from: p */
        private String f4288p;

        /* renamed from: q */
        private C0622al f4289q;

        /* renamed from: r */
        private String f4290r;

        /* renamed from: s */
        private String f4291s;

        /* renamed from: t */
        private String f4292t;

        /* renamed from: u */
        private TextView f4293u;

        /* renamed from: a */
        final int f4273a = 0;

        /* renamed from: l */
        private ProgressDialog f4284l = null;

        /* renamed from: o */
        private final String f4287o = "English";

        /* renamed from: c */
        View.OnClickListener f4275c = new ViewOnClickListenerC1163aq(this);

        /* renamed from: d */
        Handler f4276d = new HandlerC1164ar(this, Looper.getMainLooper());

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            C1786r.m6061b("onCreate...", getClass().getSimpleName());
            this.f4285m = getActivity();
            BaseActivity.m1829b(this, true);
            this.f4284l = new ProgressDialog(getActivity());
            this.f4277e = new HashMap();
            this.f4278f = new HashMap();
            this.f4279g = getResources().getTextArray(R.array.ACS_Locale_Language);
            this.f4280h = getResources().getTextArray(R.array.ACS_Lcale_Code);
            for (int i = 0; i < this.f4279g.length; i++) {
                this.f4277e.put(this.f4280h[i], this.f4279g[i]);
                this.f4278f.put(this.f4279g[i], this.f4280h[i]);
            }
            this.f4289q = new C0622al(this.f4276d);
            this.f4291s = C1789u.m6075a().getString("country_code", null);
            this.f4292t = C1789u.m6075a().getString("phonenumber", null);
            this.f4290r = C1789u.m6075a().getString("acstoken", null);
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            C1786r.m6061b("onCreateView...", getClass().getSimpleName());
            View viewInflate = layoutInflater.inflate(R.layout.layout_select_language, viewGroup, false);
            this.f4283k = (TextView) viewInflate.findViewById(R.id.txt_title);
            if (GlobalApplication.m3265f()) {
                this.f4283k.setVisibility(8);
            }
            this.f4281i = (LinearLayout) viewInflate.findViewById(R.id.Search);
            this.f4282j = (TextView) viewInflate.findViewById(R.id.editLanguageName);
            this.f4293u = (TextView) viewInflate.findViewById(R.id.noticeACS);
            this.f4293u.setText(getString(R.string.regist_acs_notice, 4, "0000", "0000"));
            this.f4281i.setOnClickListener(this.f4275c);
            if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 11) {
                getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
            }
            return viewInflate;
        }

        @Override // android.support.v4.app.Fragment
        public void onPrepareOptionsMenu(Menu menu) {
            C1786r.m6061b("onPrepareOptionsMenu", getClass().getSimpleName());
            menu.clear();
            getActivity().getMenuInflater().inflate(R.menu.actionbar_title_done_cancel_next, menu);
            if (GlobalApplication.m3265f()) {
                menu.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
                menu.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
                menu.findItem(R.id.actionbar_title_cancel).setVisible(true).setEnabled(true);
            }
            menu.removeItem(R.id.actionbar_title_next);
            this.f4286n = menu;
        }

        @Override // android.support.v4.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            C1786r.m6061b("onOptionsItemSelected...", getClass().getSimpleName());
            switch (menuItem.getItemId()) {
                case android.R.id.home:
                    getActivity().finish();
                    break;
                case R.id.actionbar_title_search /* 2131494127 */:
                case R.id.actionbar_title_done /* 2131494130 */:
                    m4408a();
                    break;
                case R.id.actionbar_title_cancel /* 2131494128 */:
                    if (getActivity() != null) {
                        getActivity().finish();
                        break;
                    }
                    break;
            }
            return true;
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            String language = getResources().getConfiguration().locale.getLanguage();
            C1786r.m6061b("LANG : " + language, getClass().getSimpleName());
            if (!TextUtils.isEmpty(language)) {
                int i = 0;
                while (true) {
                    if (i >= this.f4280h.length) {
                        break;
                    }
                    if (!this.f4280h[i].toString().startsWith(language)) {
                        i++;
                    } else {
                        this.f4288p = this.f4280h[i].toString();
                        this.f4282j.setText(String.valueOf(this.f4277e.get(this.f4288p)));
                        break;
                    }
                }
            }
            if (TextUtils.isEmpty(this.f4282j.getText().toString())) {
                this.f4282j.setText("English");
                this.f4288p = String.valueOf(this.f4277e.get("English"));
            }
            C1786r.m6061b("mLanguageCode : " + this.f4288p, getClass().getSimpleName());
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityResult(int i, int i2, Intent intent) {
            if (i2 == -1) {
                switch (i) {
                    case 0:
                        String string = intent.getExtras().getString("LANGUAGE_NAME");
                        if (string != null) {
                            this.f4288p = String.valueOf(this.f4278f.get(string));
                            this.f4282j.setText(string);
                            C1786r.m6061b("mLanguageCode : " + this.f4288p + " selectedLanguageName : " + string, getClass().getSimpleName());
                            break;
                        }
                        break;
                }
            }
        }

        /* renamed from: a */
        private void m4408a() {
            if (getActivity() != null) {
                this.f4284l.dismiss();
            }
            if (this.f4285m != null) {
                this.f4284l = ProgressDialogC1806j.m6141a(this.f4285m, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            }
            m4410b();
        }

        /* renamed from: b */
        private void m4410b() {
            if (TextUtils.isEmpty(C1789u.m6075a().getString("acstoken", null))) {
                this.f4289q.m2813b(this.f4291s, this.f4292t);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public void m4411c() {
            this.f4289q.m2812a(this.f4290r, this.f4291s, this.f4292t, this.f4288p);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public void m4414d() {
            String string = C1789u.m6075a().getString("acs_expire_time", "");
            AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(getActivity());
            alertDialogBuilderC2120a.setTitle(R.string.provisioning_verification_failed);
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(string == "" ? 24 : Integer.valueOf(string).intValue());
            alertDialogBuilderC2120a.setMessage(getString(R.string.regist_acs_daily_use_over, objArr)).setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1167au(this));
            alertDialogBuilderC2120a.create().show();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
