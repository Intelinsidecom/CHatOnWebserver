package com.sec.chaton.registration;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.AdminMenu;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.event.C1464f;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1303ap;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p025d.C1334l;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3248w;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.common.util.C3348j;
import com.sec.widget.C3641ai;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class FragmentRegist extends Fragment implements View.OnClickListener {

    /* renamed from: a */
    public static String f8259a = "regi_mode";

    /* renamed from: b */
    public static String f8260b = "before_regi";

    /* renamed from: A */
    private ClearableEditText f8261A;

    /* renamed from: B */
    private TextView f8262B;

    /* renamed from: C */
    private Button f8263C;

    /* renamed from: D */
    private TextView f8264D;

    /* renamed from: E */
    private TextView f8265E;

    /* renamed from: F */
    private TextView f8266F;

    /* renamed from: G */
    private View f8267G;

    /* renamed from: H */
    private String f8268H;

    /* renamed from: K */
    private Context f8271K;

    /* renamed from: L */
    private View f8272L;

    /* renamed from: N */
    private C1330h f8274N;

    /* renamed from: O */
    private C1303ap f8275O;

    /* renamed from: Q */
    private String f8277Q;

    /* renamed from: S */
    private String f8279S;

    /* renamed from: T */
    private String f8280T;

    /* renamed from: V */
    private boolean f8282V;

    /* renamed from: W */
    private boolean f8283W;

    /* renamed from: Y */
    private Bundle f8285Y;

    /* renamed from: Z */
    private boolean f8286Z;

    /* renamed from: ab */
    private String f8288ab;

    /* renamed from: c */
    public String f8289c;

    /* renamed from: d */
    LayoutInflater f8290d;

    /* renamed from: e */
    View f8291e;

    /* renamed from: r */
    private Map<CharSequence, CharSequence> f8304r;

    /* renamed from: s */
    private Map<CharSequence, CharSequence> f8305s;

    /* renamed from: t */
    private CharSequence[] f8306t;

    /* renamed from: u */
    private CharSequence[] f8307u;

    /* renamed from: v */
    private CharSequence[] f8308v;

    /* renamed from: w */
    private String f8309w;

    /* renamed from: x */
    private String f8310x;

    /* renamed from: y */
    private LinearLayout f8311y;

    /* renamed from: z */
    private EditText f8312z;

    /* renamed from: l */
    private final int f8298l = 32;

    /* renamed from: m */
    private final int f8299m = 16;

    /* renamed from: n */
    private final int f8300n = 48;

    /* renamed from: o */
    private final int f8301o = 64;

    /* renamed from: p */
    private final String f8302p = "SMS";

    /* renamed from: q */
    private final String f8303q = "ACS";

    /* renamed from: I */
    private ProgressDialog f8269I = null;

    /* renamed from: J */
    private ProgressDialog f8270J = null;

    /* renamed from: M */
    private boolean f8273M = false;

    /* renamed from: P */
    private InterfaceC3274d f8276P = null;

    /* renamed from: R */
    private final String f8278R = C3159aa.m10962a().m10979a("country_letter", "");

    /* renamed from: U */
    private boolean f8281U = false;

    /* renamed from: X */
    private boolean f8284X = false;

    /* renamed from: f */
    View.OnClickListener f8292f = new ViewOnClickListenerC2216dm(this);

    /* renamed from: aa */
    private TextWatcher f8287aa = new C2227dx(this);

    /* renamed from: g */
    View.OnClickListener f8293g = new ViewOnClickListenerC2228dy(this);

    /* renamed from: h */
    Handler f8294h = new HandlerC2231ea(this);

    /* renamed from: i */
    Handler f8295i = new HandlerC2237eg(this, Looper.getMainLooper());

    /* renamed from: j */
    public Handler f8296j = new HandlerC2217dn(this);

    /* renamed from: k */
    Handler f8297k = new HandlerC2222ds(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11450b("onCreate...", getClass().getSimpleName());
        if (bundle != null) {
            this.f8281U = true;
        }
        this.f8285Y = getActivity().getIntent().getExtras();
        if (this.f8285Y != null) {
            this.f8282V = this.f8285Y.getBoolean(f8259a, false);
            this.f8283W = this.f8285Y.getBoolean(f8260b, false);
        }
        if (C3159aa.m10962a().m10977a("skipRegi", (Boolean) false).booleanValue() && this.f8282V && !this.f8281U) {
            if (C3159aa.m10962a().m10977a("isSMS", (Boolean) true).booleanValue()) {
                m8572a(getActivity(), "SMS");
            } else {
                m8572a(getActivity(), "ACS");
            }
        }
        this.f8271K = getActivity();
        BaseActivity.m3083b(this, true);
        if (getActivity() != null) {
            this.f8269I = new ProgressDialogC3265l(getActivity());
        }
        this.f8304r = new HashMap();
        this.f8305s = new HashMap();
        this.f8306t = getResources().getTextArray(R.array.country);
        this.f8307u = getResources().getTextArray(R.array.country_code);
        this.f8308v = getResources().getTextArray(R.array.ISO_country_code_Letter2);
        for (int i = 0; i < this.f8306t.length; i++) {
            this.f8304r.put(this.f8308v[i], this.f8307u[i]);
            this.f8305s.put(this.f8308v[i], this.f8306t[i]);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            this.f8284X = extras.getBoolean(f8260b, false);
        }
        C3250y.m11450b("onCreateView...", getClass().getSimpleName());
        View viewInflate = layoutInflater.inflate(R.layout.layout_regist, viewGroup, false);
        this.f8274N = new C1330h(this.f8296j);
        this.f8311y = (LinearLayout) viewInflate.findViewById(R.id.rootLayout);
        this.f8262B = (TextView) viewInflate.findViewById(R.id.text1);
        if (!GlobalApplication.m6456e()) {
            this.f8262B.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow, 0);
        }
        this.f8262B.setHint(R.string.regist_select_country_or_region_code);
        this.f8312z = (EditText) viewInflate.findViewById(R.id.editArea);
        this.f8312z.setInputType(2);
        this.f8261A = (ClearableEditText) viewInflate.findViewById(R.id.editPno);
        this.f8261A.setInputType(2);
        this.f8312z.setVisibility(8);
        this.f8312z.setImeOptions(268435461);
        this.f8264D = (TextView) viewInflate.findViewById(R.id.txtRegist_2);
        this.f8264D.setText(getString(R.string.provision_regist_notice, 4));
        this.f8265E = (TextView) viewInflate.findViewById(R.id.txtStartChatAs);
        this.f8266F = (TextView) viewInflate.findViewById(R.id.TextView02);
        this.f8267G = viewInflate.findViewById(R.id.provision_upside);
        this.f8265E.setText(getString(R.string.provision_start_chat_as, C3348j.m11793a(C3171am.m11079q())));
        this.f8266F.setVisibility(8);
        if (!C3171am.m11080r() || !this.f8284X) {
            this.f8267G.setVisibility(8);
            this.f8266F.setVisibility(0);
        }
        if (viewInflate.findViewById(R.id.btnRegister) != null) {
            this.f8263C = (Button) viewInflate.findViewById(R.id.btnRegister);
            this.f8263C.setOnClickListener(this);
        }
        this.f8311y.setOnClickListener(this.f8292f);
        getActivity().getWindow().setSoftInputMode(2);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (C3250y.f11734b) {
            C3250y.m11450b("onDestroyView", getClass().getSimpleName());
        }
        if (this.f8269I != null && this.f8269I.isShowing()) {
            this.f8269I.dismiss();
        }
        if (this.f8270J != null && this.f8270J.isShowing()) {
            this.f8270J.dismiss();
        }
        if (this.f8276P != null && this.f8276P.isShowing()) {
            this.f8276P.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        String strM11060d = C3171am.m11060d();
        if (!TextUtils.isEmpty(strM11060d)) {
            strM11060d = strM11060d.toUpperCase();
        }
        if (strM11060d != null && strM11060d.length() > 0) {
            String strM10979a = C3159aa.m10962a().m10979a("country_code", "");
            String strM10979a2 = C3159aa.m10962a().m10979a("country_ISO", (String) null);
            if (strM10979a2 == null) {
                String strValueOf = String.valueOf(this.f8305s.get(strM11060d));
                this.f8309w = String.valueOf(this.f8304r.get(strM11060d));
                if (TextUtils.isEmpty(this.f8309w)) {
                    this.f8309w = "";
                }
                if (strValueOf.length() > 21 && strValueOf.length() <= 28) {
                    this.f8262B.setTextSize(18.0f);
                } else if (strValueOf.length() > 29) {
                    this.f8262B.setTextSize(14.0f);
                } else {
                    this.f8262B.setTextSize(21.0f);
                }
                this.f8262B.setText(strValueOf + " (+" + this.f8309w + ")");
                this.f8268H = strM11060d;
                C3250y.m11450b("[First]CallingCode : " + this.f8309w + " ISOLetter : " + this.f8268H + " CountryName : " + strValueOf, getClass().getSimpleName());
            } else {
                this.f8268H = strM10979a2;
                String strValueOf2 = String.valueOf(this.f8305s.get(this.f8268H));
                if (strValueOf2.length() > 21 && strValueOf2.length() <= 28) {
                    this.f8262B.setTextSize(18.0f);
                } else if (strValueOf2.length() > 29) {
                    this.f8262B.setTextSize(14.0f);
                } else {
                    this.f8262B.setTextSize(21.0f);
                }
                this.f8262B.setText(strValueOf2 + " (+" + strM10979a + ")");
                this.f8309w = strM10979a;
                C3250y.m11450b("[SavedISO]CallingCode : " + this.f8309w + " ISOLetter : " + this.f8268H + " CountryName : " + strValueOf2, getClass().getSimpleName());
            }
        } else if (!TextUtils.isEmpty(this.f8278R)) {
            String strValueOf3 = String.valueOf(this.f8304r.get(this.f8278R));
            String strValueOf4 = String.valueOf(this.f8305s.get(this.f8278R));
            C3250y.m11450b("[MID]countryName: " + strValueOf4 + " countrycode: " + strValueOf3 + " ISOletter : " + this.f8278R, getClass().getSimpleName());
            if (strValueOf4.length() > 21 && strValueOf4.length() <= 28) {
                this.f8262B.setTextSize(18.0f);
            } else if (strValueOf4.length() > 29) {
                this.f8262B.setTextSize(14.0f);
            } else {
                this.f8262B.setTextSize(21.0f);
            }
            this.f8262B.setText(strValueOf4 + " (+" + strValueOf3 + ")");
            this.f8309w = strValueOf3;
            this.f8268H = this.f8278R;
        } else {
            m8582c();
        }
        m8606b();
        if (this.f8268H.equals("AR") || this.f8268H.equals("MX") || this.f8268H.equals("BR")) {
            this.f8261A.setFilters(new InputFilter[]{new C3248w(getActivity(), 10)});
        } else {
            this.f8261A.setFilters(new InputFilter[]{new C3248w(getActivity(), 20)});
        }
        this.f8277Q = C3171am.m11057c();
        if (this.f8279S != null) {
            this.f8261A.m11466a(this.f8279S);
        } else if (!this.f8268H.equals("AR") && !this.f8268H.equals("MX") && !this.f8268H.equals("BR") && this.f8277Q != null && this.f8309w != null && this.f8277Q.length() > 3) {
            if (this.f8277Q.startsWith("+" + this.f8309w)) {
                if (this.f8309w.equals("82") && this.f8277Q.startsWith("+" + this.f8309w + "1")) {
                    this.f8261A.m11466a("0" + this.f8277Q.substring(this.f8309w.length() + 1));
                } else {
                    this.f8261A.m11466a(this.f8277Q.substring(this.f8309w.length() + 1));
                }
            } else if (this.f8277Q.startsWith(this.f8309w)) {
                if (this.f8309w.equals("82") && this.f8277Q.startsWith(this.f8309w + "1")) {
                    this.f8261A.m11466a("0" + this.f8277Q.substring(this.f8309w.length()));
                } else if (this.f8309w.equals("91") && this.f8277Q.length() == 10) {
                    this.f8261A.m11466a(this.f8277Q);
                } else {
                    this.f8261A.m11466a(this.f8277Q.substring(this.f8309w.length()));
                }
            } else if (!this.f8277Q.startsWith("0000") && this.f8277Q.length() > 6) {
                C3250y.m11450b("msisdn did NOT start with CC", getClass().getSimpleName());
                this.f8261A.m11466a(this.f8277Q);
            }
        }
        C3250y.m11450b("Auto Read #phone > phoneNum : " + this.f8277Q + "CountryCallingCode :" + this.f8309w, getClass().getSimpleName());
        this.f8312z.addTextChangedListener(this.f8287aa);
        this.f8261A.m11464a(this.f8287aa);
    }

    /* renamed from: c */
    private void m8582c() {
        this.f8262B.setText("");
        this.f8309w = null;
        this.f8268H = "";
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 16:
                if (i2 == -1) {
                    Bundle extras = intent.getExtras();
                    String string = extras.getString("PARAMS_COUNTRY_NAME");
                    if (string != null) {
                        this.f8310x = this.f8309w;
                        this.f8309w = String.valueOf(this.f8304r.get(string));
                        if (String.valueOf(this.f8305s.get(string)).length() > 21 && String.valueOf(this.f8305s.get(string)).length() <= 28) {
                            this.f8262B.setTextSize(18.0f);
                        } else if (String.valueOf(this.f8305s.get(string)).length() > 29) {
                            this.f8262B.setTextSize(14.0f);
                        } else {
                            this.f8262B.setTextSize(21.0f);
                        }
                        this.f8262B.setText(String.valueOf(this.f8305s.get(string)) + " (+" + this.f8309w + ")");
                        C3159aa.m10966a("country_name", this.f8309w);
                        C3250y.m11450b("[SelectCountry] NewCallingCode : " + this.f8309w + " PreviusCallingCode : " + this.f8310x, getClass().getSimpleName());
                        if (this.f8310x != null && !this.f8310x.equals(this.f8309w)) {
                            this.f8312z.setText("");
                        }
                        this.f8261A.setText("");
                        this.f8268H = String.valueOf(string);
                    } else {
                        String string2 = extras.getString("PARAMS_COUNTRY_CODE");
                        this.f8262B.setText(" (+" + string2 + ")");
                        this.f8309w = string2;
                    }
                    m8606b();
                    if (this.f8268H.equals("AR") || this.f8268H.equals("MX") || this.f8268H.equals("BR")) {
                        this.f8261A.setFilters(new InputFilter[]{new C3248w(getActivity(), 10)});
                        break;
                    } else {
                        this.f8261A.setFilters(new InputFilter[]{new C3248w(getActivity(), 20)});
                        break;
                    }
                }
                break;
            case 32:
                if (i2 == -1) {
                    Intent intent2 = new Intent();
                    if (C3159aa.m10962a().m10977a("skipRegi", (Boolean) false).booleanValue()) {
                        C3159aa.m10963a("skipRegi", (Boolean) false);
                    }
                    getActivity().setResult(-1, intent2);
                    getActivity().finish();
                    break;
                } else if (i2 == 0) {
                    getActivity().finish();
                    break;
                } else if (i2 == 2) {
                    C3159aa.m10963a("skipRegi", (Boolean) false);
                    C3159aa.m10962a().m10981a("acstoken");
                    C3159aa.m10962a().m10981a("was_get_version");
                    C3159aa.m10962a().m10981a("country_ISO");
                    C3159aa.m10962a().m10981a("msisdn");
                    break;
                }
                break;
            case 48:
                if (i2 == -1) {
                    m8572a(getActivity(), "normal_ACS");
                    break;
                }
                break;
            case 64:
                if (i2 == 3) {
                    getActivity().setResult(3, new Intent());
                    getActivity().finish();
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m8584d() throws UnsupportedEncodingException {
        String strTrim;
        C1330h c1330h = new C1330h(this.f8297k);
        if (this.f8309w != null) {
            if (this.f8268H.equals("AR") || this.f8268H.equals("MX") || this.f8268H.equals("BR")) {
                strTrim = this.f8309w + this.f8312z.getText().toString().trim() + this.f8261A.m11463a().toString().trim();
            } else {
                strTrim = this.f8309w + this.f8261A.m11463a().toString().trim();
            }
        } else {
            strTrim = this.f8261A.m11463a().toString().trim();
        }
        C3250y.m11450b("addBuddyInternal orgnum=" + strTrim + ", country code=" + this.f8309w, getClass().getSimpleName());
        c1330h.m5731b(strTrim, this.f8309w != null);
        this.f8288ab = (this.f8309w != null ? "+" : "") + strTrim;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        C3250y.m11450b("onStop...", "ActivityRegist");
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f8261A.getWindowToken(), 0);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C3250y.m11450b("onResume", getClass().getSimpleName());
        if (this.f8268H.equals("AR") || this.f8268H.equals("MX") || this.f8268H.equals("BR") ? !(this.f8312z.getText().length() <= 0 || this.f8261A.m11463a().length() <= 0) : !(this.f8261A.m11463a().length() <= 0 || TextUtils.isEmpty(this.f8268H))) {
            if (this.f8263C != null) {
                this.f8263C.setEnabled(true);
            }
        } else if (this.f8263C != null) {
            this.f8263C.setEnabled(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C3197bl.m11159a()) {
            switch (view.getId()) {
                case R.id.btnRegister /* 2131166201 */:
                    if (this.f8268H.equals("US") || this.f8268H.equals("JP") || this.f8268H.equals("CN") || this.f8268H.equals("IN") || this.f8268H.equals("EG") || this.f8268H.equals("TR") || this.f8268H.equals("UA") || this.f8268H.equals("CZ") || this.f8268H.equals("ZA")) {
                        m8605a();
                        break;
                    } else if (this.f8268H.equals("MM")) {
                        m8574a("ACS");
                        break;
                    } else {
                        m8574a("SMS");
                        break;
                    }
                    break;
            }
        }
    }

    /* renamed from: a */
    public void m8605a() {
        if (getActivity() != null) {
            this.f8290d = (LayoutInflater) getActivity().getSystemService("layout_inflater");
            this.f8291e = this.f8290d.inflate(R.layout.dialog_register, (ViewGroup) null);
            Button button = (Button) this.f8291e.findViewById(R.id.dialog_regist_btnSMS);
            Button button2 = (Button) this.f8291e.findViewById(R.id.dialog_regist_btnVoice);
            Button button3 = (Button) this.f8291e.findViewById(R.id.dialog_regist_btnCancel);
            button.setOnClickListener(this.f8293g);
            button2.setOnClickListener(this.f8293g);
            button3.setOnClickListener(this.f8293g);
            if (this.f8291e.getParent() == null) {
                this.f8276P = AbstractC3271a.m11494a(getActivity()).mo11508b(this.f8291e).mo11502a(true).mo11500a(getResources().getString(R.string.provision_register)).mo11509b(getResources().getString(R.string.provision_select_type)).mo11505a();
            } else {
                this.f8291e = null;
                this.f8291e = this.f8290d.inflate(R.layout.dialog_register, (ViewGroup) null);
                this.f8276P = AbstractC3271a.m11494a(getActivity()).mo11508b(this.f8291e).mo11502a(true).mo11500a(getResources().getString(R.string.provision_register)).mo11509b(getResources().getString(R.string.provision_select_type)).mo11505a();
            }
            this.f8276P.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8574a(String str) {
        if (this.f8282V && C3250y.m11446a(this.f8261A.m11463a().toString())) {
            if (this.f8268H.equals("ZW")) {
                Intent intent = new Intent(this.f8271K, (Class<?>) AdminMenu.class);
                intent.putExtra("mapping_mode", false);
                intent.putExtra("general_tab", true);
                startActivityForResult(intent, 64);
            }
            C3250y.m11439a(1);
            C3641ai.m13211a(getActivity(), "Log On", 1).show();
            return;
        }
        this.f8280T = str;
        if (this.f8280T.equals("SMS") && ((this.f8268H.equals("AR") && this.f8312z.getText().length() + this.f8261A.m11463a().length() != 10) || ((this.f8268H.equals("MX") && this.f8312z.getText().length() + this.f8261A.m11463a().length() < 10) || (this.f8268H.equals("BR") && this.f8312z.getText().length() + this.f8261A.m11463a().length() < 10)))) {
            this.f8276P = AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.pop_up_attention)).mo11509b(getResources().getString(R.string.registration_check_phone_number)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2229dz(this)).mo11505a();
            if (getActivity() != null) {
                this.f8276P.show();
                return;
            }
            return;
        }
        if (this.f8261A.m11463a().length() <= 0) {
            C3641ai.m13210a(getActivity(), R.string.setting_toast_enter_phone_number, 1).show();
            return;
        }
        if (getActivity() != null && this.f8269I != null && this.f8269I.isShowing()) {
            this.f8269I.dismiss();
        }
        if (this.f8268H.equals("AR") || this.f8268H.equals("MX") || this.f8268H.equals("BR")) {
            C3250y.m11450b("mCountryCallingCode=" + this.f8309w + " userAreaCode=" + this.f8312z.getText().toString() + " userPhoneNumber=" + this.f8261A.m11463a().toString(), getClass().getSimpleName());
        } else {
            C3250y.m11450b("mCountryCallingCode=" + this.f8309w + " userPhoneNumber=" + this.f8261A.m11463a().toString(), getClass().getSimpleName());
        }
        C1334l c1334l = new C1334l(this.f8294h);
        this.f8275O = new C1303ap(this.f8294h);
        if (this.f8271K != null) {
            this.f8269I = ProgressDialogC3265l.m11490a(this.f8271K, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        }
        if (this.f8268H.equals("AR") || this.f8268H.equals("MX") || this.f8268H.equals("BR")) {
            c1334l.m5776a(this.f8309w, this.f8312z.getText().toString() + this.f8261A.m11463a().toString());
        } else {
            c1334l.m5776a(this.f8309w, this.f8261A.m11463a().toString());
        }
        C3159aa.m10966a("country_name", this.f8262B.getText().toString());
        C3159aa.m10966a("country_code", this.f8309w);
        C3159aa.m10966a("temp_country_ISO", this.f8268H);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8579b(String str) {
        if (C3250y.f11734b) {
            C3250y.m11455d("network error, errorCode : " + str, getClass().getSimpleName());
        }
        if (this.f8269I != null && this.f8269I.isShowing()) {
            this.f8269I.dismiss();
        }
        this.f8276P = AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(getResources().getString(R.string.toast_network_unable), getResources().getString(R.string.toast_error), str)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2236ef(this)).mo11505a();
        if (getActivity() != null) {
            this.f8276P.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m8586e() {
        if (getActivity() != null && this.f8269I != null && this.f8269I.isShowing()) {
            this.f8269I.dismiss();
        }
        if (this.f8280T.equals("SMS")) {
            m8572a(getActivity(), "SMS");
        } else if (this.f8280T.equals("ACS")) {
            Intent intent = new Intent(getActivity(), (Class<?>) ActivitySelectLanguage.class);
            if (this.f8282V) {
                intent.putExtra(f8259a, true);
            }
            startActivityForResult(intent, 48);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m8588f() {
        String strM10979a = C3159aa.m10962a().m10979a("temp_country_ISO", "");
        C3159aa.m10966a("msisdn", this.f8289c);
        C3159aa.m10962a().m10981a("phonenumber");
        C3159aa.m10962a().m10981a("msisdn_temp");
        AccountManager accountManager = AccountManager.get(getActivity().getApplicationContext());
        if (C3159aa.m10962a().m10987b("uid")) {
            if (accountManager.getAccountsByType("com.sec.chaton").length <= 0) {
                String strM10979a2 = C3159aa.m10962a().m10979a("msisdn", "");
                String strM10979a3 = C3159aa.m10962a().m10979a("uid", "");
                Account account = new Account(strM10979a2, "com.sec.chaton");
                accountManager.addAccountExplicitly(account, strM10979a3, null);
                ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
            } else {
                String strM10979a4 = C3159aa.m10962a().m10979a("samsung_account_email", "");
                if (!TextUtils.isEmpty(strM10979a4)) {
                    Account account2 = new Account(strM10979a4, "com.sec.chaton");
                    if (ContentResolver.getIsSyncable(account2, "com.android.contacts") <= 0) {
                        ContentResolver.setIsSyncable(account2, "com.android.contacts", 1);
                        ContentResolver.setSyncAutomatically(account2, "com.android.contacts", true);
                    }
                } else {
                    return;
                }
            }
        }
        if (TextUtils.isEmpty(C3159aa.m10962a().m10979a("account_country_code", "")) && !C3171am.m11052a(strM10979a)) {
            if (getActivity() != null) {
                this.f8269I = ProgressDialogC3265l.m11490a(getActivity(), null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            }
            C1464f.m6387a();
            C3159aa.m10966a("country_ISO", strM10979a);
            new C1324bj(this.f8295i).m5694b();
            return;
        }
        C3159aa.m10966a("country_ISO", strM10979a);
        m8589g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m8589g() {
        FragmentActivity activity = getActivity();
        getActivity();
        this.f8272L = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.layout_text_checkbox, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) this.f8272L.findViewById(R.id.linear_packet_chekcbox);
        CheckBox checkBox = (CheckBox) this.f8272L.findViewById(R.id.data_packet_chekcbox);
        if (!C1493a.m6463a("for_wifi_only_device")) {
            checkBox.setOnCheckedChangeListener(new C2240ej(this));
        } else {
            linearLayout.setVisibility(8);
        }
        this.f8276P = AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.buddy_contact_sync)).mo11511b(false).mo11502a(true).mo11508b(this.f8272L).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2241ek(this)).mo11505a();
        if (getActivity() != null) {
            this.f8276P.show();
        }
    }

    /* renamed from: a */
    private void m8572a(Activity activity, String str) {
        String string;
        Intent intent = new Intent(activity, (Class<?>) ActivityNonSelfSMS.class);
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null && (string = extras.getString("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC")) != null && string.equals("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC")) {
            intent.putExtra("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC", "ACTIVITY_PURPOSE_CALL_CONTACT_SYNC");
        }
        if (str.equals("SMS")) {
            C3159aa.m10963a("isSMS", (Boolean) true);
        } else if (str.equals("ACS")) {
            C3159aa.m10963a("isSMS", (Boolean) false);
        }
        if (str.equals("normal_ACS")) {
            C3159aa.m10963a("isSMS", (Boolean) false);
            intent.putExtra("normal_acs", true);
        }
        if (!C3159aa.m10962a().m10977a("skipRegi", (Boolean) false).booleanValue()) {
            intent.putExtra("from_regist", true);
        }
        if (this.f8282V) {
            intent.putExtra(f8259a, true);
        }
        if (this.f8283W) {
            intent.putExtra(f8260b, true);
        }
        startActivityForResult(intent, 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m8592h() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f8261A.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    void m8606b() {
        C3250y.m11450b("[CheckACSMode ] mISOcountryCode : " + this.f8268H, getClass().getSimpleName());
        if (this.f8268H != null) {
            if (this.f8268H.equals("US") || this.f8268H.equals("JP") || this.f8268H.equals("CN") || this.f8268H.equals("IN")) {
                if (this.f8312z != null) {
                    this.f8312z.setVisibility(8);
                }
                this.f8264D.setText(getString(R.string.provision_regist_notice, 4));
                C3250y.m11450b("sim is america or japan, china, india", getClass().getSimpleName());
                return;
            }
            if (this.f8268H.equals("AR") || this.f8268H.equals("MX") || this.f8268H.equals("BR")) {
                if (this.f8312z != null) {
                    this.f8312z.setVisibility(0);
                    this.f8312z.requestFocus();
                    this.f8312z.setOnEditorActionListener(new C2224du(this));
                }
                this.f8264D.setText(getString(R.string.enter_your_area_code, 4));
                C3250y.m11450b("sim is argentina", getClass().getSimpleName());
                this.f8261A.setOnEditorActionListener(new C2225dv(this));
                return;
            }
            if (this.f8312z != null) {
                this.f8312z.setVisibility(8);
            }
            this.f8264D.setText(getString(R.string.provision_regist_notice, 4));
            C3250y.m11450b("sim is NOT america or japan, china, india : " + this.f8268H, getClass().getSimpleName());
            this.f8261A.setOnEditorActionListener(new C2226dw(this));
        }
    }
}
