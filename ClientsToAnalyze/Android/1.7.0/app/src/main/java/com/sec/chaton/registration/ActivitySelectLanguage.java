package com.sec.chaton.registration;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.p013a.C0216o;
import com.sec.chaton.p033io.entry.GetSMSAuthToken;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.widget.GeneralHeaderView;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ActivitySelectLanguage extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo664a() {
        return new SelectLanguageFragment();
    }

    public class SelectLanguageFragment extends Fragment implements View.OnClickListener {

        /* renamed from: b */
        protected GetSMSAuthToken f3249b;

        /* renamed from: e */
        private Map f3252e;

        /* renamed from: f */
        private Map f3253f;

        /* renamed from: g */
        private CharSequence[] f3254g;

        /* renamed from: h */
        private CharSequence[] f3255h;

        /* renamed from: i */
        private LinearLayout f3256i;

        /* renamed from: j */
        private TextView f3257j;

        /* renamed from: k */
        private Button f3258k;

        /* renamed from: m */
        private Context f3260m;

        /* renamed from: o */
        private String f3262o;

        /* renamed from: p */
        private C0216o f3263p;

        /* renamed from: q */
        private String f3264q;

        /* renamed from: r */
        private String f3265r;

        /* renamed from: s */
        private String f3266s;

        /* renamed from: t */
        private TextView f3267t;

        /* renamed from: u */
        private GeneralHeaderView f3268u;

        /* renamed from: a */
        final int f3248a = 0;

        /* renamed from: l */
        private ProgressDialog f3259l = null;

        /* renamed from: n */
        private final String f3261n = "English";

        /* renamed from: c */
        View.OnClickListener f3250c = new ViewOnClickListenerC0948at(this);

        /* renamed from: d */
        Handler f3251d = new HandlerC0949au(this, Looper.getMainLooper());

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            C1341p.m4658b("onCreate...", getClass().getSimpleName());
            this.f3260m = getActivity();
            BaseActivity.m2043b(this, true);
            if (getActivity() != null) {
                this.f3259l = new ProgressDialogC1354a(getActivity());
            }
            this.f3252e = new HashMap();
            this.f3253f = new HashMap();
            this.f3254g = getResources().getTextArray(R.array.ACS_Locale_Language);
            this.f3255h = getResources().getTextArray(R.array.ACS_Lcale_Code);
            for (int i = 0; i < this.f3254g.length; i++) {
                this.f3252e.put(this.f3255h[i], this.f3254g[i]);
                this.f3253f.put(this.f3254g[i], this.f3255h[i]);
            }
            this.f3263p = new C0216o(this.f3251d);
            this.f3265r = C1323bs.m4575a().getString("country_code", null);
            this.f3266s = C1323bs.m4575a().getString("phonenumber", null);
            this.f3264q = C1323bs.m4575a().getString("acstoken", null);
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            C1341p.m4658b("onCreateView...", getClass().getSimpleName());
            View viewInflate = layoutInflater.inflate(R.layout.layout_select_language, viewGroup, false);
            this.f3256i = (LinearLayout) viewInflate.findViewById(R.id.Search);
            this.f3257j = (TextView) viewInflate.findViewById(R.id.editLanguageName);
            this.f3267t = (TextView) viewInflate.findViewById(R.id.noticeACS);
            this.f3267t.setText(getString(R.string.regist_acs_notice, 4, "0000", "0000"));
            this.f3268u = (GeneralHeaderView) viewInflate.findViewById(R.id.header_view);
            this.f3268u.setButtonClickListener(new ViewOnClickListenerC0947as(this));
            if (viewInflate.findViewById(R.id.btnDone) != null) {
                this.f3258k = (Button) viewInflate.findViewById(R.id.btnDone);
                this.f3258k.setOnClickListener(this);
            }
            this.f3256i.setOnClickListener(this.f3250c);
            return viewInflate;
        }

        @Override // android.support.v4.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            C1341p.m4658b("onOptionsItemSelected...", getClass().getSimpleName());
            switch (menuItem.getItemId()) {
                case R.id.actionbar_title_search /* 2131428236 */:
                case R.id.actionbar_title_done /* 2131428239 */:
                    m3719a();
                    break;
                case R.id.actionbar_title_cancel /* 2131428237 */:
                    getActivity().finish();
                    break;
            }
            return true;
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            String language = getResources().getConfiguration().locale.getLanguage();
            C1341p.m4658b("LANG : " + language, getClass().getSimpleName());
            if (!TextUtils.isEmpty(language)) {
                int i = 0;
                while (true) {
                    if (i >= this.f3255h.length) {
                        break;
                    }
                    if (!this.f3255h[i].toString().startsWith(language)) {
                        i++;
                    } else {
                        this.f3262o = this.f3255h[i].toString();
                        this.f3257j.setText(String.valueOf(this.f3252e.get(this.f3262o)));
                        break;
                    }
                }
            }
            if (TextUtils.isEmpty(this.f3257j.getText().toString())) {
                this.f3257j.setText("English");
                this.f3262o = String.valueOf(this.f3252e.get("English"));
            }
            C1341p.m4658b("mLanguageCode : " + this.f3262o, getClass().getSimpleName());
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityResult(int i, int i2, Intent intent) {
            if (i2 == -1) {
                switch (i) {
                    case 0:
                        String string = intent.getExtras().getString("LANGUAGE_NAME");
                        if (string != null) {
                            this.f3262o = String.valueOf(this.f3253f.get(string));
                            this.f3257j.setText(string);
                            C1341p.m4658b("mLanguageCode : " + this.f3262o + " selectedLanguageName : " + string, getClass().getSimpleName());
                            break;
                        }
                        break;
                }
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onResume() {
            super.onResume();
            C1341p.m4658b("onResume", getClass().getSimpleName());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnDone /* 2131427889 */:
                    m3719a();
                    break;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m3719a() {
            if (getActivity() != null) {
                this.f3259l.dismiss();
            }
            String string = C1323bs.m4575a().getString("acstoken", null);
            if (this.f3260m != null) {
                this.f3259l = ProgressDialogC1354a.m4724a(this.f3260m, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            }
            if (string == null) {
                this.f3263p.m795b(this.f3265r, this.f3266s);
            } else {
                m3722b();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m3722b() {
            this.f3263p.m794a(this.f3264q, this.f3265r, this.f3266s, this.f3262o);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public void m3723c() {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(R.string.provisioning_verification_failed);
            builder.setMessage(getString(R.string.regist_acs_daily_use_over, 24)).setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0950av(this));
            builder.create().show();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
