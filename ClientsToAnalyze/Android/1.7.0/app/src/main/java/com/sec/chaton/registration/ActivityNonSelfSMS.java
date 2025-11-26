package com.sec.chaton.registration;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.p013a.C0203b;
import com.sec.chaton.p013a.C0216o;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.p033io.entry.GetSMSAuthToken;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.GeneralHeaderView;

/* loaded from: classes.dex */
public class ActivityNonSelfSMS extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo664a() {
        return new NonSelfSMSFragment();
    }

    public class NonSelfSMSFragment extends Fragment {

        /* renamed from: A */
        private Button f3152A;

        /* renamed from: a */
        protected GetSMSAuthToken f3155a;

        /* renamed from: f */
        private EditText f3160f;

        /* renamed from: g */
        private Button f3161g;

        /* renamed from: h */
        private GeneralHeaderView f3162h;

        /* renamed from: i */
        private Button f3163i;

        /* renamed from: j */
        private Button f3164j;

        /* renamed from: k */
        private C0216o f3165k;

        /* renamed from: l */
        private String f3166l;

        /* renamed from: m */
        private String f3167m;

        /* renamed from: n */
        private ProgressDialog f3168n;

        /* renamed from: o */
        private ImageButton f3169o;

        /* renamed from: p */
        private TextView f3170p;

        /* renamed from: q */
        private String f3171q;

        /* renamed from: r */
        private TextView f3172r;

        /* renamed from: t */
        private Menu f3174t;

        /* renamed from: u */
        private C0203b f3175u;

        /* renamed from: v */
        private BroadcastReceiver f3176v;

        /* renamed from: x */
        private String f3178x;

        /* renamed from: y */
        private String f3179y;

        /* renamed from: z */
        private boolean f3180z;

        /* renamed from: b */
        protected String f3156b = "";

        /* renamed from: s */
        private boolean f3173s = false;

        /* renamed from: w */
        private final String f3177w = "ChatON: ";

        /* renamed from: c */
        final int f3157c = 0;

        /* renamed from: B */
        private boolean f3153B = false;

        /* renamed from: d */
        Handler f3158d = new HandlerC0961bf(this, Looper.getMainLooper());

        /* renamed from: C */
        private TextWatcher f3154C = new C0960be(this);

        /* renamed from: e */
        View.OnClickListener f3159e = new ViewOnClickListenerC0954az(this);

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewInflate = layoutInflater.inflate(R.layout.layout_non_self_sms, viewGroup, false);
            this.f3165k = new C0216o(this.f3158d);
            this.f3175u = new C0203b(this.f3158d);
            this.f3166l = C1323bs.m4575a().getString("country_code", null);
            this.f3167m = C1323bs.m4575a().getString("phonenumber", null);
            this.f3171q = C1323bs.m4575a().getString("msisdn", null);
            this.f3178x = C1323bs.m4575a().getString("authnum", null);
            C1341p.m4658b("mCountry=" + this.f3166l + " mPhoneNumber=" + this.f3167m, getClass().getSimpleName());
            this.f3180z = C1323bs.m4575a().getBoolean("isSMS", true);
            if (this.f3180z) {
                this.f3179y = C1323bs.m4575a().getString("token", null);
            } else {
                this.f3179y = C1323bs.m4575a().getString("acstoken", null);
            }
            C1341p.m4658b("isSMS : " + this.f3180z + " vToken : " + this.f3179y, getClass().getSimpleName());
            getActivity().getWindow().setSoftInputMode(2);
            if (!C1323bs.m4575a().getBoolean("wasSMSregi", false)) {
                if (this.f3180z && getActivity() != null) {
                    this.f3168n = ProgressDialogC1354a.m4724a(getActivity(), null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
                    m3670d();
                }
                C1323bs.m4576a("wasSMSregi", (Boolean) true);
            }
            this.f3160f = (EditText) viewInflate.findViewById(R.id.vCode);
            this.f3161g = (Button) viewInflate.findViewById(R.id.reSend);
            this.f3164j = (Button) viewInflate.findViewById(R.id.btnVOC);
            this.f3169o = (ImageButton) viewInflate.findViewById(R.id.changePho);
            this.f3162h = (GeneralHeaderView) viewInflate.findViewById(R.id.txt_title);
            this.f3163i = (Button) viewInflate.findViewById(R.id.btnDone);
            this.f3170p = (TextView) viewInflate.findViewById(R.id.phoneNo);
            this.f3152A = (Button) viewInflate.findViewById(R.id.btnRegiACS);
            this.f3172r = (TextView) viewInflate.findViewById(R.id.phoneNo2);
            int iIndexOf = getString(R.string.provisioning_nonself_sent).indexOf("\n%s");
            if (iIndexOf != -1) {
                this.f3170p.setText(getString(R.string.provisioning_nonself_sent).subSequence(0, iIndexOf));
            }
            C1341p.m4658b("index of end on the string is = " + iIndexOf, getClass().getSimpleName());
            if (!TextUtils.isEmpty(this.f3171q)) {
                this.f3172r.setText("+" + this.f3171q);
            }
            String string = C1323bs.m4575a().getString("country_ISO", null);
            C1341p.m4658b("iskorea = " + string, getClass().getSimpleName());
            if (string != null && string.equals("KR")) {
                this.f3152A.setVisibility(8);
                this.f3161g.setText(R.string.provisioning_resend);
            }
            this.f3161g.setOnClickListener(this.f3159e);
            this.f3164j.setOnClickListener(this.f3159e);
            this.f3163i.setOnClickListener(this.f3159e);
            this.f3162h.setButtonEnabled(false);
            this.f3162h.setButtonClickListener(new ViewOnClickListenerC0959bd(this));
            this.f3169o.setOnClickListener(this.f3159e);
            this.f3152A.setOnClickListener(this.f3159e);
            this.f3160f.addTextChangedListener(this.f3154C);
            this.f3160f.setOnEditorActionListener(new C0958bc(this));
            this.f3163i.setEnabled(false);
            if (this.f3178x != null) {
                this.f3160f.append(this.f3178x);
            }
            ((TextView) viewInflate.findViewById(R.id.verification_explain_text)).setText(getString(R.string.regist_acs_sms_resend, 3));
            return viewInflate;
        }

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            BaseActivity.m2043b(this, true);
            m3673f();
        }

        @Override // android.support.v4.app.Fragment
        public void onPrepareOptionsMenu(Menu menu) {
            menu.clear();
            getActivity().getMenuInflater().inflate(R.menu.actionbar_title_next, menu);
            menu.findItem(R.id.actionbar_title_next_dim).setVisible(true).setEnabled(false);
            menu.findItem(R.id.actionbar_title_next).setVisible(false).setEnabled(false);
            this.f3174t = menu;
        }

        @Override // android.support.v4.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.actionbar_title_cancel /* 2131428237 */:
                    getActivity().finish();
                    break;
                case R.id.actionbar_title_next /* 2131428241 */:
                    m3659a();
                    break;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m3659a() {
            this.f3162h.setButtonEnabled(false);
            this.f3163i.setEnabled(false);
            this.f3178x = this.f3160f.getText().toString();
            if (!TextUtils.isEmpty(this.f3178x)) {
                if (getActivity() != null) {
                    this.f3168n = ProgressDialogC1354a.m4724a(getActivity(), null, getResources().getString(R.string.please_wait), true);
                }
                this.f3175u.m773a(this.f3171q, this.f3179y != null ? this.f3179y : null, this.f3178x);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m3665b() {
            if (getActivity() != null) {
                AlertDialogBuilderC1625m alertDialogBuilderC1625m = new AlertDialogBuilderC1625m(getActivity());
                alertDialogBuilderC1625m.setTitle(R.string.provisioning_verification_failed);
                alertDialogBuilderC1625m.setMessage(String.format(getResources().getString(R.string.setting_non_selfsms_retry_in_five_min), Integer.valueOf(C0684a.f2337h))).setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0957bb(this));
                alertDialogBuilderC1625m.create().show();
            }
        }

        /* renamed from: a */
        public static void m3660a(Activity activity, boolean z) {
            AlertDialogBuilderC1625m alertDialogBuilderC1625m = new AlertDialogBuilderC1625m(activity);
            alertDialogBuilderC1625m.setTitle(R.string.provisioning_verification_failed);
            alertDialogBuilderC1625m.setMessage(R.string.setting_non_selfsms_incorrect_code).setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0956ba(z, activity));
            alertDialogBuilderC1625m.create().show();
        }

        /* renamed from: b */
        public static void m3666b(Activity activity, boolean z) {
            AlertDialogBuilderC1625m alertDialogBuilderC1625m = new AlertDialogBuilderC1625m(activity);
            alertDialogBuilderC1625m.setTitle(R.string.provisioning_verification_failed);
            alertDialogBuilderC1625m.setMessage(R.string.setting_non_selfsms_resend_verification).setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0963bh(z, activity));
            alertDialogBuilderC1625m.create().show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public void m3667c() {
            if (getActivity() != null) {
                AlertDialogBuilderC1625m alertDialogBuilderC1625m = new AlertDialogBuilderC1625m(getActivity());
                alertDialogBuilderC1625m.setTitle(R.string.provisioning_verification_failed);
                alertDialogBuilderC1625m.setMessage(getString(R.string.setting_non_selfsms_SMS_limit_over, 24)).setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0962bg(this));
                alertDialogBuilderC1625m.create().show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public void m3670d() {
            this.f3165k.m792a(this.f3166l, this.f3167m);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public void m3671e() {
            this.f3165k.m793a(this.f3179y == null ? null : this.f3179y, this.f3166l, this.f3167m);
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityResult(int i, int i2, Intent intent) {
            if (i2 == -1) {
                switch (i) {
                    case 0:
                        if (this.f3179y == null) {
                            this.f3179y = C1323bs.m4575a().getString("acstoken", null);
                            break;
                        }
                        break;
                }
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onPause() {
            super.onPause();
            C1341p.m4658b("onPause...", "ActivityNonSelfSMS");
        }

        @Override // android.support.v4.app.Fragment
        public void onStop() {
            super.onStop();
            C1341p.m4658b("onStop...", "ActivityNonSelfSMS");
        }

        @Override // android.support.v4.app.Fragment
        public void onDestroy() {
            super.onDestroy();
            C1341p.m4658b("onDestory...", "ActivityNonSelfSMS");
            if (this.f3176v != null) {
                getActivity().unregisterReceiver(this.f3176v);
                this.f3176v = null;
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onResume() {
            super.onResume();
            C1341p.m4658b("onResume...", "ActivityNonSelfSMS");
        }

        /* renamed from: f */
        private void m3673f() {
            this.f3176v = new C0977i(this);
            getActivity().registerReceiver(this.f3176v, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
        }
    }
}
