package com.sec.chaton.registration;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.UpgradeDialog;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.p015d.C0621ak;
import com.sec.chaton.p015d.C0622al;
import com.sec.chaton.p015d.C0629as;
import com.sec.chaton.p028io.entry.GetSMSAuthToken;
import com.sec.chaton.p028io.entry.GetVersionNotice;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.widget.AlertDialogBuilderC2120a;

/* loaded from: classes.dex */
public class ActivityNonSelfSMS extends BaseSinglePaneActivity {

    /* renamed from: b */
    private static boolean f4170b;

    /* renamed from: a */
    NonSelfSMSFragment f4171a;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo649a() {
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14) {
            getActionBar();
        }
        String unused = NonSelfSMSFragment.f4172p = null;
        this.f4171a = new NonSelfSMSFragment();
        return this.f4171a;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            f4170b = true;
            this.f4171a = new NonSelfSMSFragment();
            this.f4171a.setArguments(m1828b(getIntent()));
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_controller, this.f4171a, "com.sec.chaton:single_pane_fragment").addToBackStack(null).commit();
        } catch (Exception e) {
            C1786r.m6054a("Failed to reload fragment", getClass().getSimpleName());
        }
    }

    public class NonSelfSMSFragment extends Fragment {

        /* renamed from: p */
        private static String f4172p;

        /* renamed from: A */
        private String f4173A;

        /* renamed from: B */
        private Boolean f4174B;

        /* renamed from: C */
        private Button f4175C;

        /* renamed from: E */
        private TextView f4177E;

        /* renamed from: a */
        protected GetSMSAuthToken f4181a;

        /* renamed from: h */
        private EditText f4188h;

        /* renamed from: i */
        private Button f4189i;

        /* renamed from: j */
        private Button f4190j;

        /* renamed from: k */
        private Button f4191k;

        /* renamed from: l */
        private C0622al f4192l;

        /* renamed from: m */
        private String f4193m;

        /* renamed from: n */
        private String f4194n;

        /* renamed from: o */
        private CountDownTimer f4195o;

        /* renamed from: q */
        private ProgressDialog f4196q;

        /* renamed from: r */
        private LinearLayout f4197r;

        /* renamed from: s */
        private TextView f4198s;

        /* renamed from: t */
        private String f4199t;

        /* renamed from: v */
        private Menu f4201v;

        /* renamed from: w */
        private C0621ak f4202w;

        /* renamed from: x */
        private BroadcastReceiver f4203x;

        /* renamed from: z */
        private String f4205z;

        /* renamed from: b */
        protected String f4182b = "";

        /* renamed from: u */
        private boolean f4200u = false;

        /* renamed from: y */
        private final String f4204y = "ChatON: ";

        /* renamed from: c */
        final int f4183c = 0;

        /* renamed from: D */
        private boolean f4176D = false;

        /* renamed from: F */
        private final int f4178F = 180000;

        /* renamed from: G */
        private final int f4179G = 4;

        /* renamed from: d */
        Handler f4184d = new HandlerC1194g(this, Looper.getMainLooper());

        /* renamed from: e */
        Handler f4185e = new HandlerC1201n(this, Looper.getMainLooper());

        /* renamed from: H */
        private TextWatcher f4180H = new C1207t(this);

        /* renamed from: f */
        View.OnClickListener f4186f = new ViewOnClickListenerC1208u(this);

        /* renamed from: g */
        Handler f4187g = new HandlerC1196i(this, Looper.getMainLooper());

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewInflate = layoutInflater.inflate(R.layout.layout_non_self_sms, viewGroup, false);
            if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 11) {
                getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
            }
            this.f4192l = new C0622al(this.f4185e);
            this.f4202w = new C0621ak(this.f4185e);
            this.f4193m = C1789u.m6075a().getString("country_code", null);
            this.f4194n = C1789u.m6075a().getString("phonenumber", null);
            this.f4199t = C1789u.m6075a().getString("msisdn", null);
            this.f4205z = C1789u.m6075a().getString("authnum", null);
            C1786r.m6061b("mCountry=" + this.f4193m + " mPhoneNumber=" + this.f4194n, getClass().getSimpleName());
            this.f4174B = Boolean.valueOf(C1789u.m6075a().getBoolean("isSMS", true));
            this.f4173A = C1789u.m6075a().getString("token", null);
            if (this.f4173A == null) {
                this.f4173A = C1789u.m6075a().getString("acstoken", null);
            }
            C1786r.m6061b("isSMS : " + this.f4174B + " vToken : " + this.f4173A, getClass().getSimpleName());
            if (!C1789u.m6075a().getBoolean("skipRegi", false)) {
                if (this.f4174B.booleanValue()) {
                    this.f4196q = ProgressDialogC1806j.m6141a(getActivity(), null, getResources().getString(R.string.dialog_connecting_server), true);
                    m4352f();
                }
                C1789u.m6076a("skipRegi", (Boolean) true);
            }
            this.f4188h = (EditText) viewInflate.findViewById(R.id.vCode);
            if (f4172p != null) {
                this.f4188h.setText(f4172p);
                this.f4188h.setSelection(f4172p.length());
            }
            this.f4189i = (Button) viewInflate.findViewById(R.id.reSend);
            this.f4191k = (Button) viewInflate.findViewById(R.id.contact_us);
            this.f4197r = (LinearLayout) viewInflate.findViewById(R.id.llayoutid_01);
            this.f4177E = (TextView) viewInflate.findViewById(R.id.regi_countdown);
            this.f4190j = (Button) viewInflate.findViewById(R.id.btnDone);
            this.f4198s = (TextView) viewInflate.findViewById(R.id.phoneNo);
            this.f4175C = (Button) viewInflate.findViewById(R.id.btnRegiACS);
            if (!TextUtils.isEmpty(this.f4199t)) {
                this.f4198s.setText("+" + this.f4199t);
            }
            String string = C1789u.m6075a().getString("country_ISO", null);
            C1786r.m6061b("iskorea = " + string, getClass().getSimpleName());
            if (string != null && string.equals("KR")) {
                this.f4175C.setVisibility(8);
                this.f4189i.setText(R.string.provisioning_resend);
            }
            this.f4189i.setOnClickListener(this.f4186f);
            this.f4190j.setOnClickListener(this.f4186f);
            this.f4197r.setOnClickListener(this.f4186f);
            this.f4191k.setOnClickListener(this.f4186f);
            this.f4175C.setOnClickListener(this.f4186f);
            this.f4188h.addTextChangedListener(this.f4180H);
            this.f4188h.requestFocus();
            this.f4190j.setEnabled(false);
            if (this.f4205z != null) {
                this.f4188h.append(this.f4205z);
            }
            ((TextView) viewInflate.findViewById(R.id.verification_explain_text)).setText(getString(R.string.regist_acs_sms_resend, 3));
            Intent intent = getActivity().getIntent();
            if (!intent.getBooleanExtra("from_regist", false) && C1789u.m6075a().contains("SMSSaveCountInterval")) {
                m4368a("SMS");
            }
            if (!intent.getBooleanExtra("from_regist", false) && C1789u.m6075a().contains("ACSSaveCountInterval")) {
                m4368a("ACS");
            }
            if (intent.getBooleanExtra("normal_acs", false)) {
                new C0629as(this.f4187g).m2834c();
                C1789u.m6076a("was_get_version", (Boolean) true);
                m4368a("ACS");
            }
            C1786r.m6061b("isconfigChanged :" + ActivityNonSelfSMS.f4170b, getClass().getSimpleName());
            if (ActivityNonSelfSMS.f4170b) {
                if (C1789u.m6075a().contains("SMSSaveCountInterval")) {
                    m4368a("SMS");
                }
                if (C1789u.m6075a().contains("ACSSaveCountInterval")) {
                    m4368a("ACS");
                }
            }
            boolean unused = ActivityNonSelfSMS.f4170b = false;
            return viewInflate;
        }

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            BaseActivity.m1829b(this, true);
            m4358i();
            if (m4346c()) {
                Intent intent = new Intent(getActivity(), (Class<?>) UpgradeDialog.class);
                intent.putExtra("isCritical", true);
                intent.putExtra("isFromHome", false);
                startActivity(intent);
                new C0629as(this.f4184d).m2834c();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m4342b() {
            LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(new Intent("com.sec.chaton.ACTION_DISMISS"));
        }

        /* renamed from: c */
        private boolean m4346c() {
            return C1789u.m6075a().getBoolean("UpdateIsCritical", false);
        }

        @Override // android.support.v4.app.Fragment
        public void onPrepareOptionsMenu(Menu menu) {
            menu.clear();
            getActivity().getMenuInflater().inflate(R.menu.actionbar_title_done_cancel_next, menu);
            menu.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
            menu.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(false);
            menu.removeItem(R.id.actionbar_title_next);
            this.f4201v = menu;
            m4356h();
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
                    m4348d();
                    break;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public void m4348d() {
            this.f4190j.setEnabled(false);
            this.f4205z = this.f4188h.getText().toString();
            if (!TextUtils.isEmpty(this.f4205z) && !C1789u.m6075a().getString("provisioning_selfsms_status", "").equals("DONE")) {
                if (getActivity() != null && this.f4196q != null) {
                    this.f4196q.dismiss();
                }
                this.f4196q = ProgressDialogC1806j.m6141a(getActivity(), null, getResources().getString(R.string.dialog_connecting_server), true);
                this.f4202w.m2808a(this.f4199t, this.f4173A != null ? this.f4173A : null, this.f4205z);
            }
        }

        /* renamed from: a */
        public static void m4334a(Activity activity) {
            if (activity != null) {
                AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(activity);
                alertDialogBuilderC2120a.setTitle(R.string.provisioning_verification_failed);
                alertDialogBuilderC2120a.setMessage(String.format(activity.getResources().getString(R.string.setting_non_selfsms_retry_in_five_min), Integer.valueOf(C0452a.f1732k))).setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1197j());
                alertDialogBuilderC2120a.create().show();
            }
        }

        /* renamed from: a */
        public static void m4335a(Activity activity, boolean z) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle(R.string.provisioning_verification_failed);
            builder.setMessage(R.string.setting_non_selfsms_incorrect_code).setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1198k(z, activity));
            builder.create().show();
        }

        /* renamed from: b */
        public static void m4343b(Activity activity, boolean z) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle(R.string.provisioning_verification_failed);
            builder.setMessage(R.string.setting_non_selfsms_resend_verification).setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1199l(z, activity));
            builder.create().show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public void m4349e() {
            if (getActivity() != null) {
                String string = C1789u.m6075a().getString("sms_expire_time", "");
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.provisioning_verification_failed);
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(string == "" ? 24 : Integer.valueOf(string).intValue());
                builder.setMessage(getString(R.string.regist_acs_daily_use_over, objArr)).setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1200m(this));
                builder.create().show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f */
        public void m4352f() {
            this.f4192l.m2810a(this.f4193m, this.f4194n);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: g */
        public void m4354g() {
            this.f4192l.m2811a(this.f4173A == null ? null : this.f4173A, this.f4193m, this.f4194n);
        }

        /* renamed from: a */
        protected void m4368a(String str) {
            long j;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (!str.equals("SMS") || !C1789u.m6075a().getBoolean("over_sms_request", false)) {
                if (!str.equals("ACS") || !C1789u.m6075a().getBoolean("over_acs_request", false)) {
                    this.f4189i.setEnabled(false);
                    this.f4175C.setEnabled(false);
                    if (C1789u.m6075a().contains("SMSSaveCountInterval") && C1789u.m6075a().contains("ACSSaveCountInterval")) {
                        j = C1789u.m6075a().getLong("SMSSaveCountInterval", 0L) > C1789u.m6075a().getLong("ACSSaveCountInterval", 0L) ? C1789u.m6075a().getLong("SMSSaveCountInterval", 0L) - jElapsedRealtime : C1789u.m6075a().getLong("ACSSaveCountInterval", 0L) - jElapsedRealtime;
                    } else if (C1789u.m6075a().contains("SMSSaveCountInterval") && str.equals("SMS")) {
                        j = C1789u.m6075a().getLong("SMSSaveCountInterval", 0L) - jElapsedRealtime;
                    } else if (!C1789u.m6075a().contains("SMSSaveCountInterval") && str.equals("SMS")) {
                        C1789u.m6078a("SMSSaveCountInterval", Long.valueOf(jElapsedRealtime + 180000));
                        j = 180000;
                    } else if (C1789u.m6075a().contains("ACSSaveCountInterval") && str.equals("ACS")) {
                        j = C1789u.m6075a().getLong("ACSSaveCountInterval", 0L) - jElapsedRealtime;
                    } else if (C1789u.m6075a().contains("ACSSaveCountInterval") || !str.equals("ACS")) {
                        j = 180000;
                    } else {
                        C1789u.m6078a("ACSSaveCountInterval", Long.valueOf(jElapsedRealtime + 180000));
                        j = 180000;
                    }
                    if (j > 180000 || j < 0) {
                        j = 180000;
                    }
                    C1786r.m6061b("[countdown] realInterTime : " + j + " flag : " + str, getClass().getSimpleName());
                    this.f4195o = new CountDownTimerC1206s(this, j, 1000L).start();
                }
            }
        }

        /* renamed from: a */
        protected void m4367a() {
            C1786r.m6061b("[countdown] cancelTimer", getClass().getSimpleName());
            C1789u.m6075a().edit().remove("SMSSaveCountInterval").commit();
            C1789u.m6075a().edit().remove("ACSSaveCountInterval").commit();
            this.f4177E.setText("00:00");
            if (this.f4195o != null) {
                this.f4195o.cancel();
            }
            this.f4189i.setEnabled(true);
            this.f4175C.setEnabled(true);
        }

        /* renamed from: a */
        protected static String m4332a(long j) {
            return String.format("%02d:%02d", Integer.valueOf((int) (j / 60000)), Integer.valueOf(((int) (j - ((r0 * 60) * 1000))) / 1000));
        }

        /* renamed from: h */
        private void m4356h() {
            if (GlobalApplication.m3265f() && this.f4201v != null && this.f4188h != null) {
                if (this.f4188h.length() == 4) {
                    this.f4201v.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
                    this.f4201v.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
                } else {
                    this.f4201v.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
                    this.f4201v.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(false);
                }
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityResult(int i, int i2, Intent intent) {
            if (i2 == -1) {
                switch (i) {
                    case 0:
                        if (this.f4173A == null) {
                            this.f4173A = C1789u.m6075a().getString("acstoken", null);
                            break;
                        }
                        break;
                }
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onPause() {
            super.onPause();
            C1786r.m6061b("onPause...", "ActivityNonSelfSMS");
        }

        @Override // android.support.v4.app.Fragment
        public void onStop() {
            super.onStop();
            C1786r.m6061b("onStop...", "ActivityNonSelfSMS");
        }

        @Override // android.support.v4.app.Fragment
        public void onDestroy() {
            super.onDestroy();
            C1786r.m6061b("onDestory...", "ActivityNonSelfSMS");
            if (getActivity() != null) {
                if (this.f4196q != null && this.f4196q.isShowing()) {
                    this.f4196q.dismiss();
                }
                if (this.f4203x != null) {
                    getActivity().unregisterReceiver(this.f4203x);
                    this.f4203x = null;
                }
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onResume() {
            super.onResume();
            C1786r.m6061b("onResume...", "ActivityNonSelfSMS");
            m4356h();
        }

        /* renamed from: i */
        private void m4358i() {
            this.f4203x = new C1195h(this);
            getActivity().registerReceiver(this.f4203x, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: j */
        public void m4360j() {
            C1789u.m6075a().edit().remove("UpdateIsCritical").commit();
            C1789u.m6075a().edit().remove("UpdateTargetVersion").commit();
            C1789u.m6075a().edit().remove("UpdateUrl").commit();
            C1789u.m6075a().edit().remove("SamsungappsUrl").commit();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m4336a(GetVersionNotice getVersionNotice) {
            C1789u.m6075a().edit().putString("UpdateTargetVersion", getVersionNotice.newversion).commit();
            C1789u.m6075a().edit().putBoolean("UpdateIsCritical", getVersionNotice.critical.booleanValue()).commit();
            C1789u.m6075a().edit().putString("UpdateUrl", getVersionNotice.downloadurl).commit();
            C1789u.m6075a().edit().putString("SamsungappsUrl", getVersionNotice.samsungappsurl).commit();
            Intent intent = new Intent(getActivity(), (Class<?>) UpgradeDialog.class);
            intent.putExtra("isCritical", getVersionNotice.critical);
            intent.putExtra("isFromHome", false);
            startActivity(intent);
        }
    }
}
