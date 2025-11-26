package com.sec.chaton.registration;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p025d.C1303ap;
import com.sec.chaton.p025d.C1305ar;
import com.sec.chaton.p025d.C1307at;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p035io.entry.GetSMSAuthToken;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.common.util.C3348j;

/* loaded from: classes.dex */
public class FragmentNonSelfSMS extends Fragment {

    /* renamed from: A */
    private TextView f8220A;

    /* renamed from: D */
    private C1330h f8223D;

    /* renamed from: E */
    private View f8224E;

    /* renamed from: F */
    private InterfaceC3274d f8225F;

    /* renamed from: I */
    private Button f8228I;

    /* renamed from: J */
    private boolean f8229J;

    /* renamed from: K */
    private Button f8230K;

    /* renamed from: a */
    protected GetSMSAuthToken f8233a;

    /* renamed from: g */
    private EditText f8239g;

    /* renamed from: h */
    private Button f8240h;

    /* renamed from: i */
    private TextView f8241i;

    /* renamed from: j */
    private C1305ar f8242j;

    /* renamed from: k */
    private String f8243k;

    /* renamed from: l */
    private String f8244l;

    /* renamed from: m */
    private CountDownTimer f8245m;

    /* renamed from: n */
    private ProgressDialog f8246n;

    /* renamed from: o */
    private ImageView f8247o;

    /* renamed from: p */
    private TextView f8248p;

    /* renamed from: q */
    private String f8249q;

    /* renamed from: r */
    private TextView f8250r;

    /* renamed from: s */
    private C1303ap f8251s;

    /* renamed from: t */
    private C1307at f8252t;

    /* renamed from: u */
    private BroadcastReceiver f8253u;

    /* renamed from: w */
    private String f8255w;

    /* renamed from: x */
    private String f8256x;

    /* renamed from: y */
    private boolean f8257y;

    /* renamed from: z */
    private Button f8258z;

    /* renamed from: b */
    protected String f8234b = "";

    /* renamed from: v */
    private final String f8254v = ": ";

    /* renamed from: c */
    final int f8235c = 0;

    /* renamed from: B */
    private final int f8221B = 60000;

    /* renamed from: C */
    private final int f8222C = 4;

    /* renamed from: G */
    private InterfaceC3274d f8226G = null;

    /* renamed from: H */
    private boolean f8227H = true;

    /* renamed from: L */
    private boolean f8231L = true;

    /* renamed from: d */
    public Handler f8236d = new HandlerC2189cm(this);

    /* renamed from: e */
    Handler f8237e = new HandlerC2194cr(this, Looper.getMainLooper());

    /* renamed from: M */
    private TextWatcher f8232M = new C2205db(this);

    /* renamed from: f */
    View.OnClickListener f8238f = new ViewOnClickListenerC2206dc(this);

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_non_self_sms, viewGroup, false);
        this.f8242j = new C1305ar(this.f8237e);
        this.f8251s = new C1303ap(this.f8237e);
        this.f8252t = new C1307at(this.f8237e);
        this.f8223D = new C1330h(this.f8236d);
        this.f8243k = C3159aa.m10962a().m10979a("country_code", (String) null);
        if (TextUtils.isEmpty(this.f8243k)) {
            this.f8243k = "";
        }
        this.f8244l = C3159aa.m10962a().m10979a("phonenumber", (String) null);
        this.f8249q = C3159aa.m10962a().m10979a("msisdn_temp", (String) null);
        this.f8255w = C3159aa.m10962a().m10979a("authnum", (String) null);
        C3250y.m11450b("mCountry=" + this.f8243k + " mPhoneNumber=" + this.f8244l, getClass().getSimpleName());
        this.f8257y = C3159aa.m10962a().m10977a("isSMS", (Boolean) true).booleanValue();
        this.f8256x = C3159aa.m10962a().m10979a("token", (String) null);
        if (this.f8256x == null) {
            this.f8256x = C3159aa.m10962a().m10979a("acstoken", (String) null);
        }
        C3250y.m11450b("isSMS : " + this.f8257y + " vToken : " + this.f8256x, getClass().getSimpleName());
        getActivity().getWindow().setSoftInputMode(2);
        this.f8239g = (EditText) viewInflate.findViewById(R.id.vCode);
        this.f8240h = (Button) viewInflate.findViewById(R.id.reSend);
        this.f8241i = (TextView) viewInflate.findViewById(R.id.btnVOC);
        this.f8241i.setText(C3348j.m11793a(getResources().getString(R.string.contact_us)));
        this.f8247o = (ImageView) viewInflate.findViewById(R.id.changePho);
        this.f8220A = (TextView) viewInflate.findViewById(R.id.regi_countdown);
        this.f8229J = getActivity().getIntent().getBooleanExtra(FragmentRegist.f8259a, false);
        this.f8228I = (Button) viewInflate.findViewById(R.id.Next);
        this.f8248p = (TextView) viewInflate.findViewById(R.id.phoneNo);
        this.f8258z = (Button) viewInflate.findViewById(R.id.btnRegiACS);
        this.f8250r = (TextView) viewInflate.findViewById(R.id.phoneNo2);
        this.f8230K = (Button) viewInflate.findViewById(R.id.btnRegiskip);
        this.f8230K.setVisibility(8);
        if (C3171am.m11080r() && !C3159aa.m10962a().m10977a("enteredtab", (Boolean) false).booleanValue()) {
            this.f8230K.setVisibility(0);
        }
        if (!C3159aa.m10962a().m10977a("skipRegi", (Boolean) false).booleanValue()) {
            this.f8240h.setEnabled(false);
            this.f8258z.setEnabled(false);
            this.f8230K.setEnabled(false);
            if (this.f8257y && getActivity() != null) {
                m8544d();
            }
            C3159aa.m10963a("skipRegi", (Boolean) true);
        }
        int iIndexOf = getString(R.string.provisioning_nonself_sent).indexOf("\n%s");
        if (iIndexOf != -1) {
            this.f8248p.setText(getString(R.string.provisioning_nonself_sent).subSequence(0, iIndexOf));
        }
        C3250y.m11450b("index of end on the string is = " + iIndexOf, getClass().getSimpleName());
        if (!TextUtils.isEmpty(this.f8249q)) {
            this.f8250r.setText("+" + this.f8249q);
        }
        this.f8224E = ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.layout_text_checkbox, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) this.f8224E.findViewById(R.id.linear_packet_chekcbox);
        CheckBox checkBox = (CheckBox) this.f8224E.findViewById(R.id.data_packet_chekcbox);
        if (!C1493a.m6463a("for_wifi_only_device")) {
            checkBox.setOnCheckedChangeListener(new C2188cl(this));
        } else {
            linearLayout.setVisibility(8);
        }
        this.f8240h.setOnClickListener(this.f8238f);
        this.f8241i.setOnClickListener(this.f8238f);
        this.f8230K.setOnClickListener(this.f8238f);
        this.f8228I.setEnabled(false);
        this.f8228I.setOnClickListener(new ViewOnClickListenerC2208de(this));
        this.f8247o.setOnClickListener(this.f8238f);
        this.f8258z.setOnClickListener(this.f8238f);
        this.f8239g.addTextChangedListener(this.f8232M);
        this.f8239g.setOnEditorActionListener(new C2209df(this));
        this.f8239g.setOnClickListener(new ViewOnClickListenerC2210dg(this));
        if (!TextUtils.isEmpty(this.f8255w)) {
            this.f8239g.append(this.f8255w);
        }
        ((TextView) viewInflate.findViewById(R.id.verification_explain_text)).setText(getString(R.string.provision_verify_code_notice));
        Intent intent = getActivity().getIntent();
        if (C3159aa.m10962a().m10987b("SMSSaveCountInterval") && (!intent.getBooleanExtra("from_regist", false) || bundle != null)) {
            m8568a("SMS");
        }
        if (C3159aa.m10962a().m10987b("ACSSaveCountInterval") && (!intent.getBooleanExtra("from_regist", false) || bundle != null)) {
            m8568a("ACS");
        }
        if (intent.getBooleanExtra("normal_acs", false)) {
            m8568a("ACS");
        }
        this.f8225F = AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.buddy_contact_sync)).mo11511b(false).mo11502a(true).mo11508b(this.f8224E).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2211dh(this)).mo11505a();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseActivity.m3083b(this, true);
        m8552h();
        setHasOptionsMenu(true);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        C3159aa.m10966a("authnum", (String) null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8539b() {
        this.f8228I.setEnabled(false);
        this.f8255w = this.f8239g.getText().toString();
        if (!TextUtils.isEmpty(this.f8255w)) {
            if (getActivity() != null) {
                this.f8246n = ProgressDialogC3265l.m11490a(getActivity(), null, getResources().getString(R.string.please_wait), true);
            }
            if (this.f8229J) {
                this.f8251s.m5600a(this.f8249q, this.f8256x != null ? this.f8256x : null, this.f8255w);
            } else {
                this.f8252t.m5620c(this.f8249q, this.f8256x != null ? this.f8256x : null, this.f8255w);
            }
        }
    }

    /* renamed from: a */
    public static void m8533a(Activity activity) throws Resources.NotFoundException {
        if (activity != null) {
            AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(activity);
            abstractC3271aM11494a.mo11495a(R.string.provisioning_verification_failed);
            abstractC3271aM11494a.mo11509b(String.format(activity.getResources().getString(R.string.setting_non_selfsms_retry_in_five_min), Integer.valueOf(C0816a.f3119h))).mo11507b(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2212di());
            abstractC3271aM11494a.mo11505a().show();
        }
    }

    /* renamed from: a */
    public static void m8534a(Activity activity, boolean z) {
        if (activity != null) {
            AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(activity);
            abstractC3271aM11494a.mo11495a(R.string.provisioning_verification_failed);
            abstractC3271aM11494a.mo11506b(R.string.setting_non_selfsms_incorrect_code).mo11507b(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2213dj(z, activity));
            abstractC3271aM11494a.mo11505a().show();
        }
    }

    /* renamed from: b */
    public static void m8540b(Activity activity, boolean z) {
        if (activity != null) {
            AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(activity);
            abstractC3271aM11494a.mo11495a(R.string.provisioning_verification_failed);
            abstractC3271aM11494a.mo11506b(R.string.registration_verification_expired).mo11507b(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2214dk(z, activity));
            abstractC3271aM11494a.mo11505a().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8542c() {
        if (getActivity() != null) {
            String strM10979a = C3159aa.m10962a().m10979a("sms_expire_time", "");
            AbstractC3271a abstractC3271aMo11495a = AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.provisioning_verification_failed);
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(strM10979a == "" ? 24 : Integer.valueOf(strM10979a).intValue());
            this.f8226G = abstractC3271aMo11495a.mo11509b(getString(R.string.registration_sms_24_hour_over, objArr)).mo11507b(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2215dl(this)).mo11505a();
            if (getActivity() != null) {
                this.f8226G.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m8544d() {
        this.f8242j.m5609a(this.f8243k, this.f8244l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m8547e() {
        this.f8240h.setEnabled(true);
        this.f8258z.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m8549f() {
        if (this.f8225F != null && !this.f8225F.isShowing()) {
            this.f8225F.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m8551g() {
        this.f8242j.m5610a(this.f8256x == null ? null : this.f8256x, this.f8243k, this.f8244l);
    }

    /* renamed from: a */
    protected void m8568a(String str) {
        long jM10976a;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!str.equals("SMS") || !C3159aa.m10962a().m10977a("over_sms_request", (Boolean) false).booleanValue()) {
            if (!str.equals("ACS") || !C3159aa.m10962a().m10977a("over_acs_request", (Boolean) false).booleanValue()) {
                this.f8240h.setEnabled(false);
                this.f8258z.setEnabled(false);
                this.f8230K.setEnabled(false);
                if (C3159aa.m10962a().m10987b("SMSSaveCountInterval") && C3159aa.m10962a().m10987b("ACSSaveCountInterval")) {
                    jM10976a = C3159aa.m10962a().m10976a("SMSSaveCountInterval", 0L) > C3159aa.m10962a().m10976a("ACSSaveCountInterval", 0L) ? C3159aa.m10962a().m10976a("SMSSaveCountInterval", 0L) - jElapsedRealtime : C3159aa.m10962a().m10976a("ACSSaveCountInterval", 0L) - jElapsedRealtime;
                } else if (C3159aa.m10962a().m10987b("SMSSaveCountInterval") && str.equals("SMS")) {
                    jM10976a = C3159aa.m10962a().m10976a("SMSSaveCountInterval", 0L) - jElapsedRealtime;
                } else if (!C3159aa.m10962a().m10987b("SMSSaveCountInterval") && str.equals("SMS")) {
                    C3159aa.m10965a("SMSSaveCountInterval", Long.valueOf(jElapsedRealtime + 60000));
                    jM10976a = 60000;
                } else if (C3159aa.m10962a().m10987b("ACSSaveCountInterval") && str.equals("ACS")) {
                    jM10976a = C3159aa.m10962a().m10976a("ACSSaveCountInterval", 0L) - jElapsedRealtime;
                } else if (C3159aa.m10962a().m10987b("ACSSaveCountInterval") || !str.equals("ACS")) {
                    jM10976a = 60000;
                } else {
                    C3159aa.m10965a("ACSSaveCountInterval", Long.valueOf(jElapsedRealtime + 60000));
                    jM10976a = 60000;
                }
                if (jM10976a > 60000 || jM10976a < 0) {
                    jM10976a = 60000;
                }
                C3250y.m11450b("[countdown] realInterTime : " + jM10976a + " flag : " + str, getClass().getSimpleName());
                this.f8245m = new CountDownTimerC2204da(this, jM10976a, 1000L).start();
            }
        }
    }

    /* renamed from: a */
    protected void m8567a() {
        C3250y.m11450b("[countdown] cancelTimer", getClass().getSimpleName());
        C3159aa.m10962a().m10981a("SMSSaveCountInterval");
        C3159aa.m10962a().m10981a("ACSSaveCountInterval");
        this.f8220A.setText("00:00");
        if (this.f8245m != null) {
            this.f8245m.cancel();
        }
        this.f8240h.setEnabled(true);
        this.f8258z.setEnabled(true);
        this.f8230K.setEnabled(true);
    }

    /* renamed from: a */
    protected static String m8531a(long j) {
        return String.format("%02d:%02d", Integer.valueOf((int) (j / 60000)), Integer.valueOf(((int) (j - ((r0 * 60) * 1000))) / 1000));
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 0:
                    C3250y.m11450b("[ACS Result] Saved vToken : " + this.f8256x, getClass().getSimpleName());
                    m8568a("ACS");
                    if (TextUtils.isEmpty(this.f8256x)) {
                        this.f8256x = C3159aa.m10962a().m10979a("acstoken", (String) null);
                        break;
                    }
                    break;
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C3250y.m11450b("onPause...", "ActivityNonSelfSMS");
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        C3250y.m11450b("onStop...", "ActivityNonSelfSMS");
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C3250y.m11450b("onDestory...", "ActivityNonSelfSMS");
        if (this.f8253u != null) {
            getActivity().unregisterReceiver(this.f8253u);
            this.f8253u = null;
        }
        if (this.f8226G != null && this.f8226G.isShowing()) {
            this.f8226G.dismiss();
        }
        if (this.f8225F != null && this.f8225F.isShowing()) {
            this.f8225F.dismiss();
        }
        if (this.f8246n != null && this.f8246n.isShowing()) {
            this.f8246n.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C3250y.m11450b("onResume...", "ActivityNonSelfSMS");
    }

    /* renamed from: h */
    private void m8552h() {
        this.f8253u = new C2207dd(this);
        getActivity().registerReceiver(this.f8253u, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m8554i() {
        AccountManager accountManager = AccountManager.get(CommonApplication.m11493l());
        String strM10979a = C3159aa.m10962a().m10979a("msisdn", "");
        String strM10979a2 = C3159aa.m10962a().m10979a("uid", "");
        if (C3159aa.m10962a().m10987b("uid")) {
            if (accountManager.getAccountsByType("com.sec.chaton").length <= 0) {
                C3171am.m11051a(strM10979a, strM10979a2, true);
                return;
            }
            String strM10979a3 = C3159aa.m10962a().m10979a("samsung_account_email", "");
            if (!TextUtils.isEmpty(strM10979a3)) {
                Account account = new Account(strM10979a3, "com.sec.chaton");
                if (ContentResolver.getIsSyncable(account, "com.android.contacts") <= 0) {
                    ContentResolver.setIsSyncable(account, "com.android.contacts", 1);
                    ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                }
            }
        }
    }
}
