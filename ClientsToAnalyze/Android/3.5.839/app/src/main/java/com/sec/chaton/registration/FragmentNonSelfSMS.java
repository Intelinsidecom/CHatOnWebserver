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
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p055d.C2095ba;
import com.sec.chaton.p055d.C2097bc;
import com.sec.chaton.p055d.C2104bj;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p065io.entry.GetSMSAuthToken;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.util.C5035l;
import com.sec.spp.push.Config;
import java.util.Locale;

/* loaded from: classes.dex */
public class FragmentNonSelfSMS extends Fragment {

    /* renamed from: A */
    private Button f11664A;

    /* renamed from: B */
    private TextView f11665B;

    /* renamed from: E */
    private C2128i f11668E;

    /* renamed from: F */
    private View f11669F;

    /* renamed from: G */
    private InterfaceC4936e f11670G;

    /* renamed from: J */
    private Button f11673J;

    /* renamed from: K */
    private boolean f11674K;

    /* renamed from: L */
    private Button f11675L;

    /* renamed from: N */
    private InterfaceC4936e f11677N;

    /* renamed from: a */
    protected GetSMSAuthToken f11679a;

    /* renamed from: g */
    private EditText f11685g;

    /* renamed from: h */
    private Button f11686h;

    /* renamed from: i */
    private TextView f11687i;

    /* renamed from: j */
    private C2097bc f11688j;

    /* renamed from: k */
    private String f11689k;

    /* renamed from: l */
    private String f11690l;

    /* renamed from: m */
    private CountDownTimer f11691m;

    /* renamed from: n */
    private ProgressDialog f11692n;

    /* renamed from: o */
    private ImageView f11693o;

    /* renamed from: p */
    private TextView f11694p;

    /* renamed from: q */
    private String f11695q;

    /* renamed from: r */
    private TextView f11696r;

    /* renamed from: s */
    private C2095ba f11697s;

    /* renamed from: t */
    private C2104bj f11698t;

    /* renamed from: u */
    private BroadcastReceiver f11699u;

    /* renamed from: x */
    private String f11702x;

    /* renamed from: y */
    private String f11703y;

    /* renamed from: z */
    private boolean f11704z;

    /* renamed from: b */
    protected String f11680b = "";

    /* renamed from: v */
    private final String f11700v = ": ";

    /* renamed from: w */
    private final String f11701w = "ChatON : ";

    /* renamed from: c */
    final int f11681c = 0;

    /* renamed from: C */
    private final int f11666C = 60000;

    /* renamed from: D */
    private final int f11667D = 4;

    /* renamed from: H */
    private InterfaceC4936e f11671H = null;

    /* renamed from: I */
    private boolean f11672I = true;

    /* renamed from: M */
    private boolean f11676M = true;

    /* renamed from: d */
    public Handler f11682d = new HandlerC3199cn(this);

    /* renamed from: e */
    Handler f11683e = new HandlerC3204cs(this, Looper.getMainLooper());

    /* renamed from: O */
    private TextWatcher f11678O = new C3213da(this);

    /* renamed from: f */
    View.OnClickListener f11684f = new ViewOnClickListenerC3214db(this);

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_non_self_sms, viewGroup, false);
        this.f11688j = new C2097bc(this.f11683e);
        this.f11697s = new C2095ba(this.f11683e);
        this.f11698t = new C2104bj(this.f11683e);
        this.f11668E = new C2128i(this.f11682d);
        this.f11689k = C4809aa.m18104a().m18121a("country_code", (String) null);
        if (TextUtils.isEmpty(this.f11689k)) {
            this.f11689k = "";
        }
        this.f11690l = C4809aa.m18104a().m18121a("phonenumber", (String) null);
        this.f11695q = C4809aa.m18104a().m18121a("msisdn_temp", (String) null);
        this.f11702x = C4809aa.m18104a().m18121a("authnum", (String) null);
        C4904y.m18639b("mCountry=" + this.f11689k + " mPhoneNumber=" + this.f11690l, getClass().getSimpleName());
        this.f11704z = C4809aa.m18104a().m18119a("isSMS", (Boolean) true).booleanValue();
        this.f11703y = C4809aa.m18104a().m18121a("token", (String) null);
        if (this.f11703y == null) {
            this.f11703y = C4809aa.m18104a().m18121a("acstoken", (String) null);
        }
        C4904y.m18639b("isSMS : " + this.f11704z + " vToken : " + this.f11703y, getClass().getSimpleName());
        getActivity().getWindow().setSoftInputMode(2);
        this.f11685g = (EditText) viewInflate.findViewById(R.id.vCode);
        this.f11686h = (Button) viewInflate.findViewById(R.id.reSend);
        this.f11687i = (TextView) viewInflate.findViewById(R.id.btnVOC);
        this.f11687i.setText(C5035l.m19111a(getResources().getString(R.string.contact_us)));
        this.f11693o = (ImageView) viewInflate.findViewById(R.id.changePho);
        this.f11665B = (TextView) viewInflate.findViewById(R.id.regi_countdown);
        this.f11665B.setText(String.format("%02d:%02d", 0, 0));
        this.f11674K = getActivity().getIntent().getBooleanExtra(FragmentRegist.f11705a, false);
        this.f11673J = (Button) viewInflate.findViewById(R.id.Next);
        this.f11694p = (TextView) viewInflate.findViewById(R.id.phoneNo);
        this.f11664A = (Button) viewInflate.findViewById(R.id.btnRegiACS);
        this.f11696r = (TextView) viewInflate.findViewById(R.id.phoneNo2);
        this.f11675L = (Button) viewInflate.findViewById(R.id.btnRegiskip);
        this.f11675L.setVisibility(8);
        if ((getActivity().getIntent() == null || getActivity().getIntent().getExtras() == null) ? false : getActivity().getIntent().getExtras().getBoolean(FragmentRegist.f11708d)) {
            this.f11675L.setVisibility(0);
        }
        if (!C4809aa.m18104a().m18119a("skipRegi", (Boolean) false).booleanValue()) {
            this.f11686h.setEnabled(false);
            this.f11664A.setEnabled(false);
            this.f11675L.setEnabled(false);
            if (this.f11704z && getActivity() != null) {
                m12877d();
            }
            C4809aa.m18105a("skipRegi", (Boolean) true);
        }
        int iIndexOf = getString(R.string.provisioning_nonself_sent).indexOf("\n%s");
        if (iIndexOf != -1) {
            this.f11694p.setText(getString(R.string.provisioning_nonself_sent).subSequence(0, iIndexOf));
        }
        C4904y.m18639b("index of end on the string is = " + iIndexOf, getClass().getSimpleName());
        if (!TextUtils.isEmpty(this.f11695q)) {
            this.f11696r.setText("+" + this.f11695q);
        }
        this.f11669F = ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.layout_text_checkbox, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) this.f11669F.findViewById(R.id.linear_packet_chekcbox);
        CheckBox checkBox = (CheckBox) this.f11669F.findViewById(R.id.data_packet_chekcbox);
        if (!C2349a.m10301a("for_wifi_only_device")) {
            checkBox.setOnCheckedChangeListener(new C3198cm(this));
        } else {
            linearLayout.setVisibility(8);
        }
        this.f11686h.setOnClickListener(this.f11684f);
        this.f11687i.setOnClickListener(this.f11684f);
        this.f11675L.setOnClickListener(this.f11684f);
        this.f11673J.setEnabled(false);
        this.f11673J.setOnClickListener(new ViewOnClickListenerC3217de(this));
        this.f11693o.setOnClickListener(this.f11684f);
        this.f11664A.setOnClickListener(this.f11684f);
        this.f11685g.addTextChangedListener(this.f11678O);
        this.f11685g.setOnEditorActionListener(new C3218df(this));
        this.f11685g.setOnClickListener(new ViewOnClickListenerC3219dg(this));
        if (!TextUtils.isEmpty(this.f11702x)) {
            this.f11685g.append(this.f11702x);
        }
        ((TextView) viewInflate.findViewById(R.id.verification_explain_text)).setText(getString(R.string.provision_verify_code_notice));
        Intent intent = getActivity().getIntent();
        if (C4809aa.m18104a().m18129b("SMSSaveCountInterval") && (!intent.getBooleanExtra("from_regist", false) || bundle != null)) {
            m12905a("SMS");
        }
        if (C4809aa.m18104a().m18129b("ACSSaveCountInterval") && (!intent.getBooleanExtra("from_regist", false) || bundle != null)) {
            m12905a("ACS");
        }
        if (intent.getBooleanExtra("normal_acs", false)) {
            m12905a("ACS");
        }
        this.f11670G = AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.buddy_contact_sync)).mo18751b(false).mo18742a(true).mo18748b(this.f11669F).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3220dh(this)).mo18745a();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m12885h();
        setHasOptionsMenu(true);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        C4809aa.m18108a("authnum", (String) null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12872b() {
        this.f11673J.setEnabled(false);
        this.f11702x = this.f11685g.getText().toString();
        if (!TextUtils.isEmpty(this.f11702x)) {
            if (getActivity() != null) {
                this.f11692n = ProgressDialogC4926s.m18728a(getActivity(), null, getResources().getString(R.string.please_wait), true);
            }
            if (this.f11674K) {
                this.f11697s.m9353a(this.f11695q, this.f11703y != null ? this.f11703y : null, this.f11702x);
            } else {
                this.f11698t.m9394c(this.f11695q, this.f11703y != null ? this.f11703y : null, this.f11702x);
            }
        }
    }

    /* renamed from: a */
    public static void m12864a(Activity activity) throws Resources.NotFoundException {
        if (activity != null) {
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(activity);
            abstractC4932aM18733a.mo18734a(R.string.pop_up_attention);
            String str = String.format(activity.getResources().getString(R.string.setting_non_selfsms_retry_in_five_min), Integer.valueOf(C1427a.f5075m));
            if (C4822an.m18194D()) {
                str = String.format(Locale.US, activity.getResources().getString(R.string.setting_non_selfsms_retry_in_five_min), Integer.valueOf(C1427a.f5075m));
            }
            abstractC4932aM18733a.mo18749b(str).mo18747b(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3221di());
            abstractC4932aM18733a.mo18745a().show();
        }
    }

    /* renamed from: a */
    public static void m12865a(Activity activity, boolean z) {
        if (activity != null) {
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(activity);
            abstractC4932aM18733a.mo18734a(R.string.pop_up_attention);
            abstractC4932aM18733a.mo18746b(R.string.setting_non_selfsms_incorrect_code).mo18747b(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3222dj(z, activity));
            abstractC4932aM18733a.mo18745a().show();
        }
    }

    /* renamed from: b */
    public static void m12873b(Activity activity, boolean z) {
        if (activity != null) {
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(activity);
            abstractC4932aM18733a.mo18734a(R.string.pop_up_attention);
            abstractC4932aM18733a.mo18746b(R.string.registration_verification_expired).mo18747b(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3223dk(z, activity));
            abstractC4932aM18733a.mo18745a().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m12875c() throws Resources.NotFoundException {
        if (getActivity() != null) {
            String strM18121a = C4809aa.m18104a().m18121a("sms_expire_time", "");
            String string = getActivity().getResources().getString(R.string.registration_sms_24_hour_over);
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(TextUtils.isEmpty(strM18121a) ? 24 : Integer.valueOf(strM18121a).intValue());
            String str = String.format(string, objArr);
            if (C4822an.m18194D()) {
                Locale locale = Locale.US;
                String string2 = getActivity().getResources().getString(R.string.registration_sms_24_hour_over);
                Object[] objArr2 = new Object[1];
                objArr2[0] = Integer.valueOf(TextUtils.isEmpty(strM18121a) ? 24 : Integer.valueOf(strM18121a).intValue());
                str = String.format(locale, string2, objArr2);
            }
            this.f11671H = AbstractC4932a.m18733a(getActivity()).mo18734a(R.string.pop_up_attention).mo18749b(str).mo18747b(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3224dl(this)).mo18745a();
            if (getActivity() != null) {
                this.f11671H.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m12877d() {
        this.f11688j.m9370a(this.f11689k, this.f11690l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m12879e() {
        this.f11686h.setEnabled(true);
        this.f11664A.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m12881f() {
        if (this.f11670G != null && !this.f11670G.isShowing()) {
            this.f11670G.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m12884g() {
        this.f11688j.m9371a(this.f11703y == null ? null : this.f11703y, this.f11689k, this.f11690l);
    }

    /* renamed from: a */
    protected void m12905a(String str) {
        long jM18118a;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!str.equals("SMS") || !C4809aa.m18104a().m18119a("over_sms_request", (Boolean) false).booleanValue()) {
            if (!str.equals("ACS") || !C4809aa.m18104a().m18119a("over_acs_request", (Boolean) false).booleanValue()) {
                this.f11686h.setEnabled(false);
                this.f11664A.setEnabled(false);
                this.f11675L.setEnabled(false);
                if (C4809aa.m18104a().m18129b("SMSSaveCountInterval") && C4809aa.m18104a().m18129b("ACSSaveCountInterval")) {
                    jM18118a = C4809aa.m18104a().m18118a("SMSSaveCountInterval", 0L) > C4809aa.m18104a().m18118a("ACSSaveCountInterval", 0L) ? C4809aa.m18104a().m18118a("SMSSaveCountInterval", 0L) - jElapsedRealtime : C4809aa.m18104a().m18118a("ACSSaveCountInterval", 0L) - jElapsedRealtime;
                } else if (C4809aa.m18104a().m18129b("SMSSaveCountInterval") && str.equals("SMS")) {
                    jM18118a = C4809aa.m18104a().m18118a("SMSSaveCountInterval", 0L) - jElapsedRealtime;
                } else if (!C4809aa.m18104a().m18129b("SMSSaveCountInterval") && str.equals("SMS")) {
                    C4809aa.m18107a("SMSSaveCountInterval", Long.valueOf(jElapsedRealtime + 60000));
                    jM18118a = 60000;
                } else if (C4809aa.m18104a().m18129b("ACSSaveCountInterval") && str.equals("ACS")) {
                    jM18118a = C4809aa.m18104a().m18118a("ACSSaveCountInterval", 0L) - jElapsedRealtime;
                } else if (C4809aa.m18104a().m18129b("ACSSaveCountInterval") || !str.equals("ACS")) {
                    jM18118a = 60000;
                } else {
                    C4809aa.m18107a("ACSSaveCountInterval", Long.valueOf(jElapsedRealtime + 60000));
                    jM18118a = 60000;
                }
                if (jM18118a > 60000 || jM18118a < 0) {
                    jM18118a = 60000;
                }
                C4904y.m18639b("[countdown] realInterTime : " + jM18118a + " flag : " + str, getClass().getSimpleName());
                this.f11691m = new CountDownTimerC3211cz(this, jM18118a, 1000L).start();
            }
        }
    }

    /* renamed from: a */
    protected void m12904a() {
        C4904y.m18639b("[countdown] cancelTimer", getClass().getSimpleName());
        C4809aa.m18104a().m18123a("SMSSaveCountInterval");
        C4809aa.m18104a().m18123a("ACSSaveCountInterval");
        this.f11665B.setText(String.format("%02d:%02d", 0, 0));
        if (this.f11691m != null) {
            this.f11691m.cancel();
        }
        this.f11686h.setEnabled(true);
        this.f11664A.setEnabled(true);
        this.f11675L.setEnabled(true);
    }

    /* renamed from: a */
    protected static String m12862a(long j) {
        return String.format("%02d:%02d", Integer.valueOf((int) (j / 60000)), Integer.valueOf(((int) (j - ((r0 * 60) * 1000))) / 1000));
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 0:
                    C4904y.m18639b("[ACS Result] Saved vToken : " + this.f11703y, getClass().getSimpleName());
                    m12905a("ACS");
                    if (TextUtils.isEmpty(this.f11703y)) {
                        this.f11703y = C4809aa.m18104a().m18121a("acstoken", (String) null);
                        break;
                    }
                    break;
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C4904y.m18639b("onPause...", "ActivityNonSelfSMS");
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        C4904y.m18639b("onStop...", "ActivityNonSelfSMS");
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C4904y.m18639b("onDestory...", "ActivityNonSelfSMS");
        if (this.f11699u != null) {
            getActivity().unregisterReceiver(this.f11699u);
            this.f11699u = null;
        }
        if (this.f11671H != null && this.f11671H.isShowing()) {
            this.f11671H.dismiss();
        }
        if (this.f11670G != null && this.f11670G.isShowing()) {
            this.f11670G.dismiss();
        }
        if (this.f11692n != null && this.f11692n.isShowing()) {
            this.f11692n.dismiss();
        }
        if (this.f11677N != null && this.f11677N.isShowing()) {
            this.f11677N.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C4904y.m18639b("onResume...", "ActivityNonSelfSMS");
    }

    /* renamed from: h */
    private void m12885h() {
        this.f11699u = new C3215dc(this);
        IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        intentFilter.setPriority(Integer.MAX_VALUE);
        getActivity().registerReceiver(this.f11699u, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m12888i() {
        AccountManager accountManager = AccountManager.get(CommonApplication.m18732r());
        String strM18121a = C4809aa.m18104a().m18121a("msisdn", "");
        String strM18121a2 = C4809aa.m18104a().m18121a("uid", "");
        if (C4809aa.m18104a().m18129b("uid")) {
            if (accountManager.getAccountsByType(Config.CHATON_PACKAGE_NAME).length <= 0) {
                C4822an.m18217a(strM18121a, strM18121a2, true);
                return;
            }
            String strM18121a3 = C4809aa.m18104a().m18121a("samsung_account_email", "");
            if (!TextUtils.isEmpty(strM18121a3)) {
                Account account = new Account(strM18121a3, Config.CHATON_PACKAGE_NAME);
                if (ContentResolver.getIsSyncable(account, "com.android.contacts") <= 0) {
                    ContentResolver.setIsSyncable(account, "com.android.contacts", 1);
                    ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m12889j() {
        if (this.f11677N == null || !this.f11677N.isShowing()) {
            this.f11677N = C4859bx.m18376a(this.f11677N, getActivity());
            if (this.f11677N != null) {
                this.f11677N.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m12892k() {
        if (getActivity() != null && this.f11677N != null && this.f11677N.isShowing()) {
            this.f11677N.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12866a(C0778b c0778b) {
        String strM3112g = "";
        if (c0778b != null) {
            strM3112g = c0778b.m3112g();
        }
        this.f11671H = C4859bx.m18375a(AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(getResources().getString(R.string.toast_network_unable), getResources().getString(R.string.error_code_common), strM3112g)).mo18747b(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3216dd(this)), getActivity(), strM3112g).mo18745a();
        this.f11671H.show();
    }
}
