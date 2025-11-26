package com.sec.chaton.registration;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.C0096i;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.AdminMenu;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.AbstractC1899a;
import com.sec.chaton.p055d.C2093az;
import com.sec.chaton.p055d.C2095ba;
import com.sec.chaton.p055d.C2122ca;
import com.sec.chaton.p055d.C2127h;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p055d.C2132m;
import com.sec.chaton.p065io.entry.GetVersionNotice;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4902w;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.HandlerC4826ar;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.util.C5035l;
import com.sec.common.util.log.collector.C5043h;
import com.sec.spp.push.Config;
import com.sec.widget.C5179v;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class FragmentRegist extends Fragment implements View.OnClickListener {

    /* renamed from: a */
    public static String f11705a = "regi_mode";

    /* renamed from: b */
    public static String f11706b = "before_regi";

    /* renamed from: c */
    public static String f11707c = "request_sms";

    /* renamed from: d */
    public static String f11708d = "show_skip_button";

    /* renamed from: e */
    public static String f11709e = "from_messaging_tab";

    /* renamed from: f */
    public static String f11710f = "from_buddy_tab";

    /* renamed from: g */
    public static String f11711g = "from_lite_feature_user";

    /* renamed from: A */
    private Map<CharSequence, CharSequence> f11712A;

    /* renamed from: B */
    private CharSequence[] f11713B;

    /* renamed from: C */
    private CharSequence[] f11714C;

    /* renamed from: D */
    private CharSequence[] f11715D;

    /* renamed from: E */
    private String f11716E;

    /* renamed from: F */
    private String f11717F;

    /* renamed from: G */
    private LinearLayout f11718G;

    /* renamed from: H */
    private EditText f11719H;

    /* renamed from: I */
    private ClearableEditText f11720I;

    /* renamed from: J */
    private TextView f11721J;

    /* renamed from: K */
    private Button f11722K;

    /* renamed from: L */
    private TextView f11723L;

    /* renamed from: M */
    private TextView f11724M;

    /* renamed from: N */
    private RelativeLayout f11725N;

    /* renamed from: O */
    private TextView f11726O;

    /* renamed from: P */
    private View f11727P;

    /* renamed from: Q */
    private String f11728Q;

    /* renamed from: T */
    private Context f11731T;

    /* renamed from: U */
    private View f11732U;

    /* renamed from: W */
    private C2128i f11734W;

    /* renamed from: X */
    private C2095ba f11735X;

    /* renamed from: Y */
    private C2127h f11736Y;

    /* renamed from: Z */
    private C2122ca f11737Z;

    /* renamed from: aA */
    private TextView f11738aA;

    /* renamed from: aC */
    private String f11740aC;

    /* renamed from: aa */
    private AbstractC1899a<?> f11742aa;

    /* renamed from: ac */
    private boolean f11744ac;

    /* renamed from: ad */
    private String f11745ad;

    /* renamed from: af */
    private String f11747af;

    /* renamed from: ah */
    private boolean f11749ah;

    /* renamed from: ai */
    private boolean f11750ai;

    /* renamed from: aj */
    private boolean f11751aj;

    /* renamed from: al */
    private Bundle f11753al;

    /* renamed from: am */
    private boolean f11754am;

    /* renamed from: an */
    private LinearLayout f11755an;

    /* renamed from: ao */
    private LinearLayout f11756ao;

    /* renamed from: ap */
    private String f11757ap;

    /* renamed from: aq */
    private LinearLayout f11758aq;

    /* renamed from: ar */
    private EditText f11759ar;

    /* renamed from: au */
    private InterfaceC4936e f11762au;

    /* renamed from: av */
    private C2132m f11763av;

    /* renamed from: aw */
    private boolean f11764aw;

    /* renamed from: ax */
    private boolean f11765ax;

    /* renamed from: ay */
    private GetVersionNotice f11766ay;

    /* renamed from: az */
    private boolean f11767az;

    /* renamed from: h */
    public String f11768h;

    /* renamed from: i */
    LayoutInflater f11769i;

    /* renamed from: j */
    View f11770j;

    /* renamed from: z */
    private Map<CharSequence, CharSequence> f11786z;

    /* renamed from: r */
    private final int f11778r = 32;

    /* renamed from: s */
    private final int f11779s = 16;

    /* renamed from: t */
    private final int f11780t = 48;

    /* renamed from: u */
    private final int f11781u = 64;

    /* renamed from: v */
    private final int f11782v = 80;

    /* renamed from: w */
    private final String f11783w = "SMS";

    /* renamed from: x */
    private final String f11784x = "ACS";

    /* renamed from: y */
    private final int f11785y = 30;

    /* renamed from: R */
    private ProgressDialog f11729R = null;

    /* renamed from: S */
    private ProgressDialog f11730S = null;

    /* renamed from: V */
    private boolean f11733V = false;

    /* renamed from: ab */
    private InterfaceC4936e f11743ab = null;

    /* renamed from: ae */
    private final String f11746ae = C4809aa.m18104a().m18121a("country_letter", "");

    /* renamed from: ag */
    private boolean f11748ag = false;

    /* renamed from: ak */
    private EnumC3297gd f11752ak = null;

    /* renamed from: as */
    private boolean f11760as = false;

    /* renamed from: at */
    private boolean f11761at = false;

    /* renamed from: k */
    View.OnClickListener f11771k = new ViewOnClickListenerC3240ea(this);

    /* renamed from: aB */
    private TextWatcher f11739aB = new C3241eb(this);

    /* renamed from: l */
    View.OnClickListener f11772l = new ViewOnClickListenerC3242ec(this);

    /* renamed from: m */
    Handler f11773m = new HandlerC3244ee(this);

    /* renamed from: n */
    HandlerC4826ar f11774n = new HandlerC3252em(this);

    /* renamed from: o */
    Handler f11775o = new HandlerC3257er(this, Looper.getMainLooper());

    /* renamed from: p */
    public Handler f11776p = new HandlerC3228dp(this);

    /* renamed from: q */
    Handler f11777q = new HandlerC3233du(this);

    /* renamed from: aD */
    private BroadcastReceiver f11741aD = new C3238dz(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4904y.m18639b("onCreate...", getClass().getSimpleName());
        if (bundle != null) {
            this.f11748ag = true;
        }
        this.f11753al = getActivity().getIntent().getExtras();
        if (this.f11753al != null) {
            this.f11749ah = this.f11753al.getBoolean(f11705a, false);
            this.f11750ai = this.f11753al.getBoolean(f11706b, false);
            this.f11752ak = (EnumC3297gd) this.f11753al.get(f11707c);
            this.f11757ap = this.f11753al.getString("register_sms_token");
            this.f11760as = this.f11753al.getBoolean(RegisterSMSActivity.f11832n);
            this.f11765ax = this.f11753al.getBoolean(f11711g);
            this.f11751aj = this.f11753al.getBoolean(f11708d, false);
            this.f11761at = this.f11753al.getBoolean(f11710f);
        }
        if (C4809aa.m18104a().m18119a("skipRegi", (Boolean) false).booleanValue() && this.f11749ah && !this.f11748ag) {
            if (C4809aa.m18104a().m18119a("isSMS", (Boolean) true).booleanValue()) {
                m12916a(getActivity(), "SMS");
            } else {
                m12916a(getActivity(), "ACS");
            }
        }
        this.f11731T = getActivity();
        if (getActivity() != null) {
            this.f11729R = new ProgressDialogC4926s(getActivity());
        }
        this.f11786z = new HashMap();
        this.f11712A = new HashMap();
        this.f11713B = getResources().getTextArray(R.array.country);
        this.f11714C = getResources().getTextArray(R.array.country_code);
        this.f11715D = getResources().getTextArray(R.array.ISO_country_code_Letter2);
        for (int i = 0; i < this.f11713B.length; i++) {
            this.f11786z.put(this.f11715D[i], this.f11714C[i]);
            this.f11712A.put(this.f11715D[i], this.f11713B[i]);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C4904y.m18639b("onCreateView...", getClass().getSimpleName());
        View viewInflate = layoutInflater.inflate(R.layout.layout_regist, viewGroup, false);
        this.f11734W = new C2128i(this.f11776p);
        this.f11736Y = new C2127h(this.f11773m);
        this.f11737Z = new C2122ca(this.f11773m);
        this.f11742aa = C2093az.m9337a();
        this.f11763av = new C2132m(this.f11773m);
        this.f11718G = (LinearLayout) viewInflate.findViewById(R.id.rootLayout);
        this.f11721J = (TextView) viewInflate.findViewById(R.id.text1);
        this.f11721J.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow, 0);
        this.f11721J.setHint(R.string.regist_select_country_or_region_code);
        this.f11719H = (EditText) viewInflate.findViewById(R.id.editArea);
        this.f11719H.setInputType(2);
        this.f11720I = (ClearableEditText) viewInflate.findViewById(R.id.editPno);
        this.f11720I.setInputType(2);
        this.f11738aA = (TextView) viewInflate.findViewById(R.id.btnSkip);
        this.f11719H.setVisibility(8);
        this.f11719H.setImeOptions(268435461);
        this.f11723L = (TextView) viewInflate.findViewById(R.id.txtRegist_2);
        this.f11723L.setText(getString(R.string.provision_regist_notice, 4));
        this.f11725N = (RelativeLayout) viewInflate.findViewById(R.id.txtStartChatAsLayout);
        this.f11724M = (TextView) viewInflate.findViewById(R.id.txtStartChatAs);
        this.f11726O = (TextView) viewInflate.findViewById(R.id.TextView02);
        this.f11727P = viewInflate.findViewById(R.id.provision_upside);
        this.f11755an = (LinearLayout) viewInflate.findViewById(R.id.sns_layout);
        this.f11756ao = (LinearLayout) viewInflate.findViewById(R.id.sns_didver);
        if (!C4822an.m18218a() && this.f11760as) {
            if (C4809aa.m18104a().m18129b("menuIndex")) {
                C4809aa.m18104a().m18123a("menuIndex");
            }
            this.f11726O.setVisibility(8);
            this.f11744ac = true;
        }
        if (EnumC3297gd.auto_register.equals(this.f11752ak)) {
            this.f11758aq = (LinearLayout) viewInflate.findViewById(R.id.linearInputName);
            this.f11758aq.setVisibility(0);
            this.f11759ar = (EditText) viewInflate.findViewById(R.id.txtName);
            this.f11759ar.setFilters(new InputFilter[]{new C4902w(getActivity(), 30)});
            this.f11759ar.addTextChangedListener(this.f11739aB);
            this.f11759ar.setOnEditorActionListener(new C3225dm(this));
        }
        if (this.f11750ai) {
            if (this.f11749ah) {
                if (EnumC3297gd.register_select_now.equals(this.f11752ak)) {
                    this.f11725N.setVisibility(8);
                    this.f11726O.setVisibility(8);
                    this.f11744ac = true;
                } else {
                    this.f11727P.setVisibility(8);
                }
                if (EnumC3297gd.reigster.equals(this.f11752ak) || EnumC3297gd.auto_register.equals(this.f11752ak)) {
                    this.f11755an.setVisibility(8);
                } else {
                    ImageView imageView = (ImageView) viewInflate.findViewById(R.id.btn_facebook);
                    ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.btn_vkontakte);
                    ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.btn_odnoklassniki);
                    if (!C4859bx.m18408f((String) null)) {
                        imageView.setVisibility(8);
                    }
                    if (!C4859bx.m18411g((String) null)) {
                        imageView2.setVisibility(8);
                    }
                    if (!C4859bx.m18413h(null)) {
                        imageView3.setVisibility(8);
                    }
                    this.f11755an.setOnClickListener(this);
                }
            } else {
                this.f11724M.setText(getString(R.string.provision_start_chat_as, C5035l.m19111a(C4822an.m18254v())));
                this.f11726O.setVisibility(8);
                this.f11744ac = true;
                this.f11755an.setVisibility(8);
                this.f11756ao.setVisibility(8);
                this.f11738aA.setVisibility(0);
                this.f11738aA.setOnClickListener(this);
                this.f11738aA.setText(C5035l.m19111a(getResources().getString(R.string.registration_skip_button)));
            }
        } else {
            this.f11727P.setVisibility(8);
            this.f11755an.setVisibility(8);
            this.f11756ao.setVisibility(8);
        }
        if (viewInflate.findViewById(R.id.btnRegister) != null) {
            this.f11722K = (Button) viewInflate.findViewById(R.id.btnRegister);
            this.f11722K.setOnClickListener(this);
        }
        if (this.f11761at) {
            this.f11722K.setText(R.string.receive_sms);
            this.f11722K.setContentDescription(getActivity().getString(R.string.receive_sms));
        }
        this.f11718G.setOnClickListener(this.f11771k);
        getActivity().getWindow().setSoftInputMode(2);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("upgrade_cancel");
        C0096i.m358a(getActivity().getApplicationContext()).m362a(this.f11741aD, intentFilter);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (C4904y.f17872b) {
            C4904y.m18639b("onDestroyView", getClass().getSimpleName());
        }
        if (this.f11729R != null && this.f11729R.isShowing()) {
            this.f11729R.dismiss();
        }
        if (this.f11730S != null && this.f11730S.isShowing()) {
            this.f11730S.dismiss();
        }
        if (this.f11743ab != null && this.f11743ab.isShowing()) {
            this.f11743ab.dismiss();
        }
        if (this.f11762au != null && this.f11762au.isShowing()) {
            this.f11762au.dismiss();
        }
        C0096i.m358a(getActivity().getApplicationContext()).m361a(this.f11741aD);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        String strM18236g = C4822an.m18236g();
        if (!TextUtils.isEmpty(strM18236g)) {
            strM18236g = strM18236g.toUpperCase();
        }
        if (strM18236g != null && strM18236g.length() > 0) {
            String strM18121a = C4809aa.m18104a().m18121a("country_code", "");
            String strM18121a2 = C4809aa.m18104a().m18121a("country_ISO", (String) null);
            if (strM18121a2 == null) {
                String strValueOf = String.valueOf(this.f11712A.get(strM18236g));
                this.f11716E = String.valueOf(this.f11786z.get(strM18236g));
                if (TextUtils.isEmpty(this.f11716E)) {
                    this.f11716E = "";
                }
                if (strValueOf.length() > 21 && strValueOf.length() <= 28) {
                    this.f11721J.setTextSize(0, getResources().getDimension(R.dimen.registration_country_selector_text_size_medium));
                } else if (strValueOf.length() > 29) {
                    this.f11721J.setTextSize(0, getResources().getDimension(R.dimen.registration_country_selector_text_size_small));
                } else {
                    this.f11721J.setTextSize(0, getResources().getDimension(R.dimen.registration_country_selector_text_size_large));
                }
                this.f11721J.setText(strValueOf + " (+" + this.f11716E + ")");
                this.f11728Q = strM18236g;
                C4904y.m18639b("[First]CallingCode : " + this.f11716E + " ISOLetter : " + this.f11728Q + " CountryName : " + strValueOf, getClass().getSimpleName());
            } else {
                this.f11728Q = strM18121a2;
                String strValueOf2 = String.valueOf(this.f11712A.get(this.f11728Q));
                if (strValueOf2.length() > 21 && strValueOf2.length() <= 28) {
                    this.f11721J.setTextSize(0, getResources().getDimension(R.dimen.registration_country_selector_text_size_medium));
                } else if (strValueOf2.length() > 29) {
                    this.f11721J.setTextSize(0, getResources().getDimension(R.dimen.registration_country_selector_text_size_small));
                } else {
                    this.f11721J.setTextSize(0, getResources().getDimension(R.dimen.registration_country_selector_text_size_large));
                }
                this.f11721J.setText(strValueOf2 + " (+" + strM18121a + ")");
                this.f11716E = strM18121a;
                C4904y.m18639b("[SavedISO]CallingCode : " + this.f11716E + " ISOLetter : " + this.f11728Q + " CountryName : " + strValueOf2, getClass().getSimpleName());
            }
        } else if (!TextUtils.isEmpty(this.f11746ae)) {
            String strValueOf3 = String.valueOf(this.f11786z.get(this.f11746ae));
            String strValueOf4 = String.valueOf(this.f11712A.get(this.f11746ae));
            C4904y.m18639b("[MID]countryName: " + strValueOf4 + " countrycode: " + strValueOf3 + " ISOletter : " + this.f11746ae, getClass().getSimpleName());
            if (strValueOf4.length() > 21 && strValueOf4.length() <= 28) {
                this.f11721J.setTextSize(0, getResources().getDimension(R.dimen.registration_country_selector_text_size_medium));
            } else if (strValueOf4.length() > 29) {
                this.f11721J.setTextSize(0, getResources().getDimension(R.dimen.registration_country_selector_text_size_small));
            } else {
                this.f11721J.setTextSize(0, getResources().getDimension(R.dimen.registration_country_selector_text_size_large));
            }
            this.f11721J.setText(strValueOf4 + " (+" + strValueOf3 + ")");
            this.f11716E = strValueOf3;
            this.f11728Q = this.f11746ae;
        } else {
            m12925c();
        }
        m12957b();
        if (this.f11728Q.equals("AR") || this.f11728Q.equals("MX") || this.f11728Q.equals("BR")) {
            this.f11720I.setFilters(new InputFilter[]{new C4902w(getActivity(), 10)});
        } else {
            this.f11720I.setFilters(new InputFilter[]{new C4902w(getActivity(), 20)});
        }
        this.f11745ad = C4822an.m18234f();
        if (!this.f11728Q.equals("AR") && !this.f11728Q.equals("MX") && !this.f11728Q.equals("BR") && this.f11745ad != null && this.f11716E != null && this.f11745ad.length() > 3) {
            if (this.f11745ad.startsWith("+" + this.f11716E)) {
                if (this.f11716E.equals("82") && this.f11745ad.startsWith("+" + this.f11716E + Spam.ACTIVITY_REPORT)) {
                    this.f11720I.m18660a(Spam.ACTIVITY_CANCEL + this.f11745ad.substring(this.f11716E.length() + 1));
                } else {
                    this.f11720I.m18660a(this.f11745ad.substring(this.f11716E.length() + 1));
                }
            } else if (this.f11745ad.startsWith(this.f11716E)) {
                if (this.f11716E.equals("82") && this.f11745ad.startsWith(this.f11716E + Spam.ACTIVITY_REPORT)) {
                    this.f11720I.m18660a(Spam.ACTIVITY_CANCEL + this.f11745ad.substring(this.f11716E.length()));
                } else if (this.f11716E.equals("91") && this.f11745ad.length() == 10) {
                    this.f11720I.m18660a(this.f11745ad);
                } else {
                    this.f11720I.m18660a(this.f11745ad.substring(this.f11716E.length()));
                }
            } else if (!this.f11745ad.startsWith("0000") && this.f11745ad.length() > 6) {
                C4904y.m18639b("msisdn did NOT start with CC", getClass().getSimpleName());
                this.f11720I.m18660a(this.f11745ad);
            }
        }
        C4904y.m18639b("Auto Read #phone > phoneNum : " + this.f11745ad + "CountryCallingCode :" + this.f11716E, getClass().getSimpleName());
        this.f11719H.addTextChangedListener(this.f11739aB);
        this.f11720I.m18659a(this.f11739aB);
    }

    /* renamed from: c */
    private void m12925c() {
        this.f11721J.setText("");
        this.f11716E = null;
        this.f11728Q = "";
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 16:
                if (i2 == -1) {
                    Bundle extras = intent.getExtras();
                    String string = extras.getString("PARAMS_COUNTRY_NAME");
                    if (string != null) {
                        this.f11717F = this.f11716E;
                        this.f11716E = String.valueOf(this.f11786z.get(string));
                        if (String.valueOf(this.f11712A.get(string)).length() > 21 && String.valueOf(this.f11712A.get(string)).length() <= 28) {
                            this.f11721J.setTextSize(0, getResources().getDimension(R.dimen.registration_country_selector_text_size_medium));
                        } else if (String.valueOf(this.f11712A.get(string)).length() > 29) {
                            this.f11721J.setTextSize(0, getResources().getDimension(R.dimen.registration_country_selector_text_size_small));
                        } else {
                            this.f11721J.setTextSize(0, getResources().getDimension(R.dimen.registration_country_selector_text_size_large));
                        }
                        this.f11721J.setText(String.valueOf(this.f11712A.get(string)) + " (+" + this.f11716E + ")");
                        C4809aa.m18108a("country_name", this.f11716E);
                        C4904y.m18639b("[SelectCountry] NewCallingCode : " + this.f11716E + " PreviusCallingCode : " + this.f11717F, getClass().getSimpleName());
                        if (this.f11717F != null && !this.f11717F.equals(this.f11716E)) {
                            this.f11719H.setText("");
                        }
                        this.f11720I.setText("");
                        this.f11728Q = String.valueOf(string);
                    } else {
                        String string2 = extras.getString("PARAMS_COUNTRY_CODE");
                        this.f11721J.setText(" (+" + string2 + ")");
                        this.f11716E = string2;
                    }
                    m12957b();
                    if (this.f11728Q.equals("AR") || this.f11728Q.equals("MX") || this.f11728Q.equals("BR")) {
                        this.f11720I.setFilters(new InputFilter[]{new C4902w(getActivity(), 10)});
                        break;
                    } else {
                        this.f11720I.setFilters(new InputFilter[]{new C4902w(getActivity(), 20)});
                        break;
                    }
                }
                break;
            case 32:
                if (i2 == -1) {
                    Intent intent2 = new Intent();
                    if (C4809aa.m18104a().m18119a("skipRegi", (Boolean) false).booleanValue()) {
                        C4809aa.m18105a("skipRegi", (Boolean) false);
                    }
                    getActivity().setResult(-1, intent2);
                    getActivity().finish();
                    break;
                } else if (i2 == 0) {
                    getActivity().finish();
                    break;
                } else if (i2 == 2) {
                    C4809aa.m18105a("skipRegi", (Boolean) false);
                    C4809aa.m18104a().m18123a("acstoken");
                    C4809aa.m18104a().m18123a("was_get_version");
                    C4809aa.m18104a().m18123a("country_ISO");
                    C4809aa.m18104a().m18123a("msisdn");
                    C4809aa.m18104a().m18123a("over_sms_request");
                    C4809aa.m18104a().m18123a("over_acs_request");
                    C4809aa.m18104a().m18123a("authnum");
                    break;
                } else if (i2 == 3) {
                    getActivity().setResult(3);
                    getActivity().finish();
                    break;
                }
                break;
            case 48:
                if (i2 == -1) {
                    m12916a(getActivity(), "normal_ACS");
                    break;
                }
                break;
            case 64:
                if (i2 == 3) {
                    this.f11767az = true;
                    this.f11763av.m9552a();
                    if (this.f11729R != null && !this.f11729R.isShowing()) {
                        this.f11729R.show();
                        break;
                    }
                }
                break;
            case 100:
                if (getActivity() != null) {
                    getActivity().setResult(11);
                    getActivity().finish();
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m12927d() {
        String strTrim;
        C2128i c2128i = new C2128i(this.f11777q);
        if (this.f11716E != null) {
            if (this.f11728Q.equals("AR") || this.f11728Q.equals("MX") || this.f11728Q.equals("BR")) {
                strTrim = this.f11716E + this.f11719H.getText().toString().trim() + this.f11720I.m18658a().toString().trim();
            } else {
                strTrim = this.f11716E + this.f11720I.m18658a().toString().trim();
            }
        } else {
            strTrim = this.f11720I.m18658a().toString().trim();
        }
        C4904y.m18639b("addBuddyInternal orgnum=" + strTrim + ", country code=" + this.f11716E, getClass().getSimpleName());
        c2128i.m9494a(strTrim, this.f11716E != null, EnumC2463n.BACKGROUND);
        this.f11740aC = (this.f11716E != null ? "+" : "") + strTrim;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        C4904y.m18639b("onStop...", "ActivityRegist");
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f11720I.getWindowToken(), 0);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C4904y.m18639b("onResume", getClass().getSimpleName());
        if (this.f11728Q.equals("AR") || this.f11728Q.equals("MX") || this.f11728Q.equals("BR") ? !(this.f11719H.getText().length() <= 0 || this.f11720I.m18658a().length() <= 0) : !(this.f11720I.m18658a().length() <= 0 || TextUtils.isEmpty(this.f11728Q))) {
            if (this.f11759ar != null) {
                if (this.f11759ar.length() > 0) {
                    if (this.f11722K != null) {
                        this.f11722K.setEnabled(true);
                        return;
                    }
                    return;
                } else {
                    if (this.f11722K != null) {
                        this.f11722K.setEnabled(false);
                        return;
                    }
                    return;
                }
            }
            if (this.f11722K != null) {
                this.f11722K.setEnabled(true);
                return;
            }
            return;
        }
        if (this.f11722K != null) {
            this.f11722K.setEnabled(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            switch (view.getId()) {
                case R.id.btnRegister /* 2131166168 */:
                    if (this.f11760as && C4809aa.m18104a().m18129b("menuIndex")) {
                        C4809aa.m18104a().m18123a("menuIndex");
                    }
                    if (this.f11728Q.equals("US") || this.f11728Q.equals("JP") || this.f11728Q.equals("CN") || this.f11728Q.equals("IN") || this.f11728Q.equals("EG") || this.f11728Q.equals("TR") || this.f11728Q.equals("UA") || this.f11728Q.equals("CZ") || this.f11728Q.equals("ZA")) {
                        m12956a();
                        break;
                    } else if (this.f11728Q.equals("MM")) {
                        m12918a("ACS");
                        break;
                    } else {
                        m12918a("SMS");
                        break;
                    }
                    break;
                case R.id.btnSkip /* 2131166169 */:
                    getActivity().setResult(3);
                    getActivity().finish();
                    break;
                case R.id.sns_layout /* 2131166171 */:
                    if (this.f11765ax) {
                        this.f11764aw = true;
                        this.f11729R = ProgressDialogC4926s.m18728a(this.f11731T, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
                        this.f11763av.m9552a();
                        break;
                    } else {
                        getActivity().setResult(6, new Intent());
                        getActivity().finish();
                        break;
                    }
            }
        }
    }

    /* renamed from: a */
    public void m12956a() {
        if (getActivity() != null) {
            this.f11769i = (LayoutInflater) getActivity().getSystemService("layout_inflater");
            this.f11770j = this.f11769i.inflate(R.layout.dialog_register, (ViewGroup) null);
            Button button = (Button) this.f11770j.findViewById(R.id.dialog_regist_btnSMS);
            Button button2 = (Button) this.f11770j.findViewById(R.id.dialog_regist_btnVoice);
            Button button3 = (Button) this.f11770j.findViewById(R.id.dialog_regist_btnCancel);
            button.setOnClickListener(this.f11772l);
            button2.setOnClickListener(this.f11772l);
            button3.setOnClickListener(this.f11772l);
            if (this.f11770j.getParent() == null) {
                this.f11743ab = AbstractC4932a.m18733a(getActivity()).mo18748b(this.f11770j).mo18742a(true).mo18740a(getResources().getString(R.string.provision_register)).mo18749b(getResources().getString(R.string.provision_select_type)).mo18745a();
            } else {
                this.f11770j = null;
                this.f11770j = this.f11769i.inflate(R.layout.dialog_register, (ViewGroup) null);
                this.f11743ab = AbstractC4932a.m18733a(getActivity()).mo18748b(this.f11770j).mo18742a(true).mo18740a(getResources().getString(R.string.provision_register)).mo18749b(getResources().getString(R.string.provision_select_type)).mo18745a();
            }
            this.f11743ab.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12918a(String str) {
        if (this.f11749ah) {
            if (getActivity() == null || !C4859bx.m18387a(this.f11728Q, getActivity())) {
                if (C4904y.m18637a(this.f11720I.m18658a().toString())) {
                    if (this.f11728Q.equals("ZW")) {
                        Intent intent = new Intent(this.f11731T, (Class<?>) AdminMenu.class);
                        intent.putExtra("mapping_mode", false);
                        intent.putExtra("general_tab", true);
                        startActivityForResult(intent, 64);
                    }
                    C4904y.m18632a(1);
                    C5179v.m19811a(getActivity(), "Log On", 1).show();
                    return;
                }
                if (C4904y.m18640b(this.f11720I.m18658a().toString())) {
                    if (this.f11728Q.equals("ZW")) {
                        Intent intent2 = new Intent(this.f11731T, (Class<?>) AdminMenu.class);
                        intent2.putExtra("mapping_mode", false);
                        intent2.putExtra("general_tab", true);
                        startActivityForResult(intent2, 64);
                    }
                    C4904y.m18632a(2);
                    C5179v.m19811a(getActivity(), "Log On With Save", 1).show();
                    return;
                }
            } else {
                return;
            }
        }
        this.f11747af = str;
        if (this.f11747af.equals("SMS") && ((this.f11728Q.equals("AR") && this.f11719H.getText().length() + this.f11720I.m18658a().length() != 10) || ((this.f11728Q.equals("MX") && this.f11719H.getText().length() + this.f11720I.m18658a().length() < 10) || (this.f11728Q.equals("BR") && this.f11719H.getText().length() + this.f11720I.m18658a().length() < 10)))) {
            this.f11743ab = AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.pop_up_attention)).mo18749b(getResources().getString(R.string.error_code_common) + " " + getResources().getString(R.string.registration_check_phone_number)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3243ed(this)).mo18745a();
            if (getActivity() != null) {
                this.f11743ab.show();
                return;
            }
            return;
        }
        if (this.f11720I.m18658a().length() <= 0) {
            C5179v.m19810a(getActivity(), R.string.setting_toast_enter_phone_number, 1).show();
            return;
        }
        if (getActivity() != null && this.f11729R != null && this.f11729R.isShowing()) {
            this.f11729R.dismiss();
        }
        if (this.f11728Q.equals("AR") || this.f11728Q.equals("MX") || this.f11728Q.equals("BR")) {
            C4904y.m18639b("mCountryCallingCode=" + this.f11716E + " userAreaCode=" + this.f11719H.getText().toString() + " userPhoneNumber=" + this.f11720I.m18658a().toString(), getClass().getSimpleName());
        } else {
            C4904y.m18639b("mCountryCallingCode=" + this.f11716E + " userPhoneNumber=" + this.f11720I.m18658a().toString(), getClass().getSimpleName());
        }
        this.f11735X = new C2095ba(this.f11773m);
        if (this.f11731T != null) {
            this.f11729R = ProgressDialogC4926s.m18728a(this.f11731T, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        }
        if (this.f11728Q.equals("AR") || this.f11728Q.equals("MX") || this.f11728Q.equals("BR")) {
            this.f11763av.m9554a(this.f11716E, this.f11719H.getText().toString() + this.f11720I.m18658a().toString());
        } else {
            this.f11763av.m9554a(this.f11716E, this.f11720I.m18658a().toString());
        }
        C4809aa.m18108a("country_name", this.f11721J.getText().toString());
        C4809aa.m18108a("country_code", this.f11716E);
        C4809aa.m18108a("temp_country_ISO", this.f11728Q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12922b(String str) {
        if (C4904y.f17872b) {
            C4904y.m18645d("network error, errorCode : " + str, getClass().getSimpleName());
        }
        if (this.f11729R != null && this.f11729R.isShowing()) {
            this.f11729R.dismiss();
        }
        this.f11743ab = C4859bx.m18375a(AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(getResources().getString(R.string.toast_network_unable), getResources().getString(R.string.error_code_common), str)).mo18747b(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3251el(this)), getActivity(), str).mo18745a();
        if (getActivity() != null) {
            this.f11743ab.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m12929e() {
        if (EnumC3297gd.auto_register.equals(this.f11752ak)) {
            if (this.f11729R == null || !this.f11729R.isShowing()) {
                this.f11729R = ProgressDialogC4926s.m18728a(this.f11731T, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            }
            this.f11742aa.mo9077a(this.f11774n);
            this.f11774n.m18262a(30000);
            return;
        }
        if (getActivity() != null && this.f11729R != null && this.f11729R.isShowing()) {
            this.f11729R.dismiss();
        }
        if (this.f11747af.equals("SMS")) {
            m12916a(getActivity(), "SMS");
        } else if (this.f11747af.equals("ACS")) {
            Intent intent = new Intent(getActivity(), (Class<?>) ActivitySelectLanguage.class);
            if (this.f11749ah) {
                intent.putExtra(f11705a, true);
            }
            startActivityForResult(intent, 48);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m12931f() {
        String strM18121a = C4809aa.m18104a().m18121a("temp_country_ISO", "");
        C4809aa.m18108a("msisdn", this.f11768h);
        C4809aa.m18104a().m18123a("phonenumber");
        C4809aa.m18104a().m18123a("msisdn_temp");
        AccountManager accountManager = AccountManager.get(getActivity().getApplicationContext());
        if (C4809aa.m18104a().m18129b("uid")) {
            if (accountManager.getAccountsByType(Config.CHATON_PACKAGE_NAME).length <= 0) {
                C4809aa.m18104a().m18121a("msisdn", "");
                String strM18121a2 = C4809aa.m18104a().m18121a("uid", "");
                Account account = new Account("ChatON", Config.CHATON_PACKAGE_NAME);
                accountManager.addAccountExplicitly(account, strM18121a2, null);
                ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                if (C4822an.m18255w()) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("SA user did contact sync", getClass().getSimpleName());
                    }
                    C5043h.m19179a().m19185a("0001", "2126", false);
                }
            } else {
                String strM18121a3 = C4809aa.m18104a().m18121a("samsung_account_email", "");
                if (!TextUtils.isEmpty(strM18121a3)) {
                    Account account2 = new Account(strM18121a3, Config.CHATON_PACKAGE_NAME);
                    if (ContentResolver.getIsSyncable(account2, "com.android.contacts") <= 0) {
                        ContentResolver.setIsSyncable(account2, "com.android.contacts", 1);
                        ContentResolver.setSyncAutomatically(account2, "com.android.contacts", true);
                    }
                } else {
                    return;
                }
            }
        }
        if (TextUtils.isEmpty(C4809aa.m18104a().m18121a("account_country_code", "")) && !C4822an.m18224b(strM18121a)) {
            if (getActivity() != null) {
                this.f11729R = ProgressDialogC4926s.m18728a(getActivity(), null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            }
            C4809aa.m18108a("country_ISO", strM18121a);
            new C2122ca(this.f11775o).m9471b();
            return;
        }
        C4809aa.m18108a("country_ISO", strM18121a);
        m12933g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m12933g() {
        FragmentActivity activity = getActivity();
        getActivity();
        this.f11732U = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.layout_text_checkbox, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) this.f11732U.findViewById(R.id.linear_packet_chekcbox);
        CheckBox checkBox = (CheckBox) this.f11732U.findViewById(R.id.data_packet_chekcbox);
        if (!C2349a.m10301a("for_wifi_only_device")) {
            checkBox.setOnCheckedChangeListener(new C3226dn(this));
        } else {
            linearLayout.setVisibility(8);
        }
        this.f11743ab = AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.buddy_contact_sync)).mo18751b(false).mo18742a(true).mo18748b(this.f11732U).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3227do(this)).mo18745a();
        if (getActivity() != null) {
            this.f11743ab.show();
        }
    }

    /* renamed from: a */
    private void m12916a(Activity activity, String str) {
        String string;
        Intent intent = new Intent(activity, (Class<?>) ActivityNonSelfSMS.class);
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null && (string = extras.getString("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC")) != null && string.equals("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC")) {
            intent.putExtra("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC", "ACTIVITY_PURPOSE_CALL_CONTACT_SYNC");
        }
        if (str.equals("SMS")) {
            C4809aa.m18105a("isSMS", (Boolean) true);
        } else if (str.equals("ACS")) {
            C4809aa.m18105a("isSMS", (Boolean) false);
        }
        if (str.equals("normal_ACS")) {
            C4809aa.m18105a("isSMS", (Boolean) false);
            intent.putExtra("normal_acs", true);
        }
        if (!C4809aa.m18104a().m18119a("skipRegi", (Boolean) false).booleanValue()) {
            intent.putExtra("from_regist", true);
        }
        intent.putExtra(f11705a, this.f11749ah);
        intent.putExtra(f11706b, this.f11750ai);
        intent.putExtra(f11708d, this.f11751aj);
        startActivityForResult(intent, 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m12934h() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f11720I.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    void m12957b() {
        C4904y.m18639b("[CheckACSMode ] mISOcountryCode : " + this.f11728Q, getClass().getSimpleName());
        if (this.f11728Q != null) {
            if (this.f11728Q.equals("US") || this.f11728Q.equals("JP") || this.f11728Q.equals("CN") || this.f11728Q.equals("IN")) {
                if (this.f11719H != null) {
                    this.f11719H.setVisibility(8);
                }
                if (this.f11744ac) {
                    this.f11726O.setVisibility(8);
                }
                this.f11726O.setText(getString(R.string.provision_regist_notice, 4));
                C4904y.m18639b("sim is america or japan, china, india", getClass().getSimpleName());
            } else if (this.f11728Q.equals("AR") || this.f11728Q.equals("MX") || this.f11728Q.equals("BR")) {
                if (this.f11719H != null) {
                    this.f11719H.setVisibility(0);
                    this.f11719H.requestFocus();
                    this.f11719H.setOnEditorActionListener(new C3235dw(this));
                }
                this.f11726O.setVisibility(0);
                this.f11726O.setText(getString(R.string.enter_your_area_code, 4));
                C4904y.m18639b("sim is argentina", getClass().getSimpleName());
                this.f11720I.setOnEditorActionListener(new C3236dx(this));
            } else {
                if (this.f11719H != null) {
                    this.f11719H.setVisibility(8);
                }
                if (this.f11744ac) {
                    this.f11726O.setVisibility(8);
                }
                this.f11726O.setText(getString(R.string.provision_regist_notice, 4));
                C4904y.m18639b("sim is NOT america or japan, china, india : " + this.f11728Q, getClass().getSimpleName());
                this.f11720I.setOnEditorActionListener(new C3237dy(this));
            }
            if (this.f11761at) {
                this.f11726O.setText(GlobalApplication.m10283b().getString(R.string.you_will_receive_a_verification_code_via_sms, 4));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m12936i() {
        if (this.f11762au == null || !this.f11762au.isShowing()) {
            this.f11762au = C4859bx.m18376a(this.f11762au, getActivity());
            if (this.f11762au != null) {
                this.f11762au.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m12939j() {
        if (getActivity() != null && this.f11762au != null && this.f11762au.isShowing()) {
            this.f11762au.dismiss();
        }
    }
}
