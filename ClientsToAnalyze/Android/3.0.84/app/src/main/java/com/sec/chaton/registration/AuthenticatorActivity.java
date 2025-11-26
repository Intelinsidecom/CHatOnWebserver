package com.sec.chaton.registration;

import android.accounts.AccountAuthenticatorActivity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.NewSPPUpgradeDialog;
import com.sec.chaton.R;
import com.sec.chaton.SelectCountry;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.p025d.C1334l;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.samsungaccount.MainActivity;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;

/* loaded from: classes.dex */
public class AuthenticatorActivity extends AccountAuthenticatorActivity {

    /* renamed from: a */
    public String f8142a;

    /* renamed from: b */
    public String f8143b;

    /* renamed from: c */
    public String f8144c;

    /* renamed from: h */
    private String f8149h;

    /* renamed from: i */
    private String f8150i;

    /* renamed from: j */
    private C1324bj f8151j;

    /* renamed from: k */
    private C1334l f8152k;

    /* renamed from: l */
    private C1324bj f8153l;

    /* renamed from: m */
    private Context f8154m;

    /* renamed from: n */
    private View f8155n;

    /* renamed from: o */
    private boolean f8156o;

    /* renamed from: p */
    private InterfaceC3274d f8157p;

    /* renamed from: w */
    private EditText f8164w;

    /* renamed from: x */
    private View f8165x;

    /* renamed from: y */
    private InterfaceC3274d f8166y;

    /* renamed from: f */
    private boolean f8147f = false;

    /* renamed from: g */
    private boolean f8148g = false;

    /* renamed from: q */
    private ProgressDialog f8158q = null;

    /* renamed from: r */
    private boolean f8159r = false;

    /* renamed from: s */
    private boolean f8160s = false;

    /* renamed from: t */
    private boolean f8161t = false;

    /* renamed from: u */
    private boolean f8162u = false;

    /* renamed from: v */
    private int f8163v = 0;

    /* renamed from: z */
    private boolean f8167z = false;

    /* renamed from: A */
    private String f8138A = AuthenticatorActivity.class.getSimpleName();

    /* renamed from: B */
    private Runnable f8139B = new RunnableC2140ar(this);

    /* renamed from: d */
    AsyncTask<Void, Void, Void> f8145d = new AsyncTaskC2141as(this);

    /* renamed from: e */
    public Handler f8146e = new HandlerC2142at(this);

    /* renamed from: C */
    private BroadcastReceiver f8140C = new C2146ax(this);

    /* renamed from: D */
    private BroadcastReceiver f8141D = new C2147ay(this);

    /* renamed from: e */
    static /* synthetic */ int m8456e(AuthenticatorActivity authenticatorActivity) {
        int i = authenticatorActivity.f8163v;
        authenticatorActivity.f8163v = i + 1;
        return i;
    }

    @Override // android.accounts.AccountAuthenticatorActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws PackageManager.NameNotFoundException {
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        C3250y.m11453c("[LIFE] onCreate Mode :" + getResources().getConfiguration().orientation + ", isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f8138A);
        this.f8154m = this;
        this.f8151j = new C1324bj(this.f8146e);
        this.f8152k = new C1334l(this.f8146e);
        this.f8153l = new C1324bj(this.f8146e);
        m8480a();
        m8483b();
        if (C1493a.m6463a("mum_enable_feature")) {
            m8440a(bundle);
            m8450c();
        } else {
            m8451c(bundle);
        }
    }

    /* renamed from: c */
    private void m8450c() {
        this.f8165x = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_eidit_text, (ViewGroup) null);
        this.f8164w = (EditText) this.f8165x.findViewById(R.id.editBox);
        this.f8166y = AbstractC3271a.m11494a(this.f8154m).mo11502a(true).mo11508b(this.f8165x).mo11515d(R.string.done, new DialogInterfaceOnClickListenerC2136an(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2125ac(this)).mo11505a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8440a(Bundle bundle) throws PackageManager.NameNotFoundException {
        boolean z;
        boolean z2;
        TelephonyManager telephonyManager;
        boolean z3 = !getPackageManager().hasSystemFeature("android.hardware.telephony");
        boolean z4 = (z3 || (telephonyManager = (TelephonyManager) getSystemService("phone")) == null || telephonyManager.getSimState() != 1) ? z3 : true;
        int iM6733a = C1594v.m6733a(GlobalApplication.m11493l());
        if (z4) {
            if (-3 != iM6733a && -2 != iM6733a) {
                m8446b(bundle);
                return;
            } else {
                m8481a(8);
                return;
            }
        }
        boolean z5 = C1594v.m6735b(GlobalApplication.m11493l());
        if (!C1594v.m6736c(GlobalApplication.m11493l())) {
            z = false;
            z2 = false;
        } else if (-3 == iM6733a || -2 == iM6733a) {
            z = false;
            z2 = true;
        } else {
            z = true;
            z2 = true;
        }
        boolean z6 = C1594v.m6738e(GlobalApplication.m11493l()) || C1594v.m6739f(GlobalApplication.m11493l());
        boolean z7 = z5 && z2;
        boolean z8 = C1594v.m6737d(GlobalApplication.m11493l());
        boolean z9 = C1594v.m6740g(GlobalApplication.m11493l());
        boolean z10 = C1594v.m6741h(GlobalApplication.m11493l());
        if (z7) {
            if (z) {
                m8446b(bundle);
                return;
            } else {
                m8481a(3);
                return;
            }
        }
        if (!z) {
            if (z5) {
                m8481a(3);
                return;
            }
            if (!z6) {
                m8481a(4);
                return;
            }
            if (z9) {
                if (!z8) {
                    m8481a(5);
                    return;
                } else {
                    m8481a(2);
                    return;
                }
            }
            if (!z10) {
                m8481a(7);
                return;
            } else if (C3159aa.m10962a().m10977a("PacketDataDialg", (Boolean) false).booleanValue()) {
                m8446b(bundle);
                return;
            } else {
                m8481a(1);
                return;
            }
        }
        m8446b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8446b(Bundle bundle) throws PackageManager.NameNotFoundException {
        if (bundle == null) {
            if (C1493a.m6463a("for_wifi_only_device")) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("This is Wifi Only device", this.f8138A);
                }
                this.f8160s = true;
                new Handler().postDelayed(this.f8139B, 600L);
                return;
            }
            m8468k();
            return;
        }
        if (bundle.getBoolean("isDisclaimer", false)) {
            m8460g();
        } else {
            m8483b();
        }
    }

    /* renamed from: a */
    void m8481a(int i) {
        this.f8155n = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_text_checkbox, (ViewGroup) null);
        TextView textView = (TextView) this.f8155n.findViewById(R.id.commenttextview);
        textView.setSoundEffectsEnabled(false);
        textView.setOnClickListener(new ViewOnClickListenerC2144av(this));
        TextView textView2 = (TextView) this.f8155n.findViewById(R.id.commenttextview);
        CheckBox checkBox = (CheckBox) this.f8155n.findViewById(R.id.data_packet_chekcbox);
        LinearLayout linearLayout = (LinearLayout) this.f8155n.findViewById(R.id.linear_packet_chekcbox);
        if (i == 2) {
            checkBox.setVisibility(8);
            textView2.setText(R.string.provision_using_mobile_data);
        } else if (i == 5) {
            checkBox.setVisibility(8);
            textView2.setText(R.string.provision_data_roaming);
        } else if (i == 4) {
            checkBox.setVisibility(8);
            textView2.setText(R.string.provision_mobile_data_is_disabled);
        } else if (i == 8) {
            linearLayout.setVisibility(8);
            textView2.setText(R.string.provision_wifi_not_available_turn_on);
        } else if (i == 3) {
            checkBox.setVisibility(8);
            textView2.setText(R.string.provision_unable_to_connect);
        } else if (i == 7) {
            checkBox.setVisibility(8);
            textView2.setText(R.string.provision_no_signal);
        } else if (i == 1 && !C3159aa.m10962a().m10977a("PacketDataDialg", (Boolean) false).booleanValue()) {
            if (C3159aa.m10962a().m10977a("PacketDataDialg", (Boolean) false).booleanValue()) {
                checkBox.setVisibility(8);
            }
            checkBox.setChecked(false);
            checkBox.setText(R.string.data_packet_checkbox);
            checkBox.setSoundEffectsEnabled(true);
            checkBox.setOnClickListener(new ViewOnClickListenerC2151bb(this));
            checkBox.setOnCheckedChangeListener(new C2152bc(this));
            textView2.setText(R.string.provision_wifi_network_not_available_atnt);
        }
        m8484b(i);
    }

    /* renamed from: b */
    void m8484b(int i) {
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f8154m);
        if (i == 8) {
            abstractC3271aM11494a.mo11495a(R.string.provision_wifi_not_available).mo11502a(true).mo11508b(this.f8155n).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2153bd(this));
            this.f8157p = abstractC3271aM11494a.mo11505a();
            this.f8157p.setOnCancelListener(new DialogInterfaceOnCancelListenerC2154be(this));
        } else if (i == 4) {
            abstractC3271aM11494a.mo11495a(R.string.popup_no_network_connection).mo11502a(true).mo11508b(this.f8155n).mo11514c(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2155bf(this));
            this.f8157p = abstractC3271aM11494a.mo11505a();
            this.f8157p.setOnCancelListener(new DialogInterfaceOnCancelListenerC2156bg(this));
        } else if (i == 2) {
            abstractC3271aM11494a.mo11495a(R.string.provision_connect_via_roaming_nework).mo11502a(true).mo11508b(this.f8155n).mo11515d(R.string.provision_connect, new DialogInterfaceOnClickListenerC2127ae(this)).mo11507b(R.string.cancel, new DialogInterfaceOnClickListenerC2126ad(this));
            this.f8157p = abstractC3271aM11494a.mo11505a();
            this.f8157p.setOnCancelListener(new DialogInterfaceOnCancelListenerC2128af(this));
        } else if (i == 3) {
            abstractC3271aM11494a.mo11495a(R.string.popup_no_network_connection).mo11502a(true).mo11508b(this.f8155n).mo11514c(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2129ag(this));
            this.f8157p = abstractC3271aM11494a.mo11505a();
            this.f8157p.setOnCancelListener(new DialogInterfaceOnCancelListenerC2130ah(this));
        } else if (i == 5) {
            abstractC3271aM11494a.mo11495a(R.string.popup_no_network_connection).mo11502a(true).mo11508b(this.f8155n).mo11514c(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2131ai(this));
            this.f8157p = abstractC3271aM11494a.mo11505a();
            this.f8157p.setOnCancelListener(new DialogInterfaceOnCancelListenerC2132aj(this));
        } else if (i == 7) {
            abstractC3271aM11494a.mo11495a(R.string.popup_no_network_connection).mo11502a(true).mo11508b(this.f8155n).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2134al(this)).mo11507b(R.string.provision_later, new DialogInterfaceOnClickListenerC2133ak(this));
            this.f8157p = abstractC3271aM11494a.mo11505a();
            this.f8157p.setOnCancelListener(new DialogInterfaceOnCancelListenerC2135am(this));
        } else if (i == 1) {
            abstractC3271aM11494a.mo11495a(R.string.provision_connect_via_mobile_nework).mo11502a(true).mo11508b(this.f8155n).mo11515d(R.string.provision_connect, new DialogInterfaceOnClickListenerC2138ap(this)).mo11507b(R.string.cancel, new DialogInterfaceOnClickListenerC2137ao(this));
            this.f8157p = abstractC3271aM11494a.mo11505a();
            this.f8157p.setOnCancelListener(new DialogInterfaceOnCancelListenerC2139aq(this));
        }
        this.f8157p.show();
    }

    /* renamed from: a */
    void m8480a() {
        if (C3159aa.m10962a().m10987b("provisioning_account_login")) {
            return;
        }
        if (C3159aa.m10962a().m10979a("provisioning_pushname_status", "").equals("DONE") || C3159aa.m10962a().m10979a("provisioning_disclaimer_status", "").equals("DONE")) {
            C3250y.m11450b("Previous version is under multi device", this.f8138A);
            C3159aa.m10962a().m10981a("provisioning_pushname_status");
            C3159aa.m10962a().m10981a("provisioning_disclaimer_status");
            C3159aa.m10962a().m10981a("provisioning_selfsms_status");
        }
    }

    /* renamed from: b */
    void m8483b() {
        setContentView(R.layout.layout_settings_starting);
        m8482a(getResources().getConfiguration());
    }

    /* renamed from: a */
    void m8482a(Configuration configuration) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (C3250y.f11734b) {
            C3250y.m11450b("densityDpi : " + displayMetrics.densityDpi + " Config : " + configuration, this.f8138A);
        }
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        if (configuration.orientation == 2) {
            if (1 == defaultDisplay.getRotation()) {
                setRequestedOrientation(0);
                return;
            } else {
                if (3 == defaultDisplay.getRotation()) {
                    setRequestedOrientation(8);
                    return;
                }
                return;
            }
        }
        if (defaultDisplay.getRotation() == 0) {
            setRequestedOrientation(1);
        } else if (2 == defaultDisplay.getRotation()) {
            setRequestedOrientation(9);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!this.f8148g) {
            super.onBackPressed();
        }
        C3250y.m11450b("[LIFE] onBackPressed, Memory address :" + this + " isSavedInstnace :" + this.f8148g, this.f8138A);
        this.f8147f = true;
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f8148g) {
            this.f8148g = false;
        }
        C3250y.m11450b("[LIFE] onResume, Memory address :" + this + " isSavedInstnace :" + this.f8148g, this.f8138A);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C3250y.m11450b("onConfigurationChanged", this.f8138A);
    }

    /* renamed from: d */
    private void m8454d() {
        Intent intent = new Intent(this, (Class<?>) ActivityProvisioning.class);
        this.f8142a = C3159aa.m10962a().m10979a("Push Name", "");
        this.f8143b = C3159aa.m10962a().m10979a("msisdn", "");
        intent.putExtra("REG_NAME", this.f8142a);
        intent.putExtra("REG_PNO", this.f8143b);
        startActivityForResult(intent, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m8457e() {
        Intent intent = new Intent(this, (Class<?>) ActivityRegistPushName.class);
        this.f8143b = C3159aa.m10962a().m10979a("msisdn", "");
        intent.putExtra("REG_PNO", this.f8143b);
        startActivityForResult(intent, 0);
    }

    /* renamed from: f */
    private void m8459f() {
        Intent intent = new Intent();
        this.f8143b = C3159aa.m10962a().m10979a("msisdn", "");
        this.f8144c = C3159aa.m10962a().m10979a("uid", "");
        C3214cb.m11254a(this.f8143b, this.f8144c, true);
        intent.putExtra("authAccount", this.f8143b);
        intent.putExtra("accountType", "com.sec.chaton");
        intent.putExtra("authtoken", this.f8144c);
        m8439a(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m8460g() {
        String strM11068h = C3171am.m11068h();
        String strM10979a = C3159aa.m10962a().m10979a("country_letter", "GB");
        if (C3250y.f11734b) {
            C3250y.m11450b("[setDisclaimerView] SCC : " + strM10979a + " MCC : " + strM11068h, this.f8138A);
        }
        if (TextUtils.isEmpty(strM11068h)) {
            strM11068h = "234";
        }
        if (TextUtils.isEmpty(strM10979a)) {
            strM10979a = "GB";
        }
        if (strM11068h.equals("450") || strM10979a.equals("KR")) {
            startActivityForResult(new Intent(this, (Class<?>) NewDisclaimerView.class), 7);
        } else {
            startActivityForResult(new Intent(this, (Class<?>) GlobalDisclaimerView.class), 6);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f8157p != null && this.f8157p.isShowing()) {
            this.f8157p.dismiss();
        }
        m8464i();
        if (this.f8159r) {
            unregisterReceiver(this.f8140C);
        }
        if (this.f8166y != null && this.f8166y.isShowing()) {
            this.f8166y.dismiss();
        }
        if (!this.f8167z) {
            LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(this.f8141D);
        }
        this.f8154m = null;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f8148g = true;
        C3250y.m11450b("[LIFE] onSaveInstanceState, Memory address :" + this + " isSavedInstnace :" + this.f8148g, this.f8138A);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        switch (i) {
            case 0:
                if (i2 == -1) {
                    C3159aa.m10962a().m10986b("provisioning_pushname_status", "DONE");
                    C0816a.m4368d();
                    C3250y.m11456e("push name was finished and skip sync ", "runProvisioning");
                    C3159aa.m10962a().m10983b("first_time_after_regi", (Boolean) true);
                    C1757q.m7255e();
                    if (C3159aa.m10962a().m10979a("provisioning_selfsms_status", "").equals("DONE")) {
                        m8459f();
                        break;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("accountManagerResponse", 5);
                        m8439a(intent2);
                        break;
                    }
                } else if (i2 == 6) {
                    C3159aa.m10962a().m10981a("token");
                    C3159aa.m10962a().m10981a("authnum");
                    C3159aa.m10962a().m10981a("provisioning_selfsms_status");
                    C3159aa.m10962a().m10981a("acstoken");
                    Intent intent3 = new Intent(this, (Class<?>) ActivityRegist.class);
                    intent3.putExtra(FragmentRegist.f8259a, true);
                    startActivityForResult(intent3, 1);
                    break;
                } else if (i2 == 0) {
                    finish();
                    break;
                } else if (i2 == 2) {
                    C3159aa.m10962a().m10981a("provisioning_sns_login_state");
                    startActivityForResult(new Intent(this, (Class<?>) ActivityConnectAccounts.class), 10);
                    break;
                }
                break;
            case 1:
                if (i2 == -1) {
                    this.f8143b = intent.getStringExtra("MSISDN");
                    this.f8150i = intent.getStringExtra("AUTH_NUM");
                    this.f8149h = intent.getStringExtra("TOKEN");
                    C3250y.m11450b("mAuthNum" + this.f8150i + "sToken" + this.f8149h + "Auther_SMS_OK", "ChatON");
                    C3159aa.m10963a("prov_phone", (Boolean) true);
                    C3159aa.m10966a("provisioning_selfsms_status", "DONE");
                    m8457e();
                    break;
                } else if (i2 == 0) {
                    C3159aa.m10966a("provisioning_selfsms_status", "CANCEL");
                    finish();
                    break;
                } else if (i2 == 2) {
                    C3159aa.m10962a().m10981a("prov_phone");
                    C3159aa.m10962a().m10981a("provisioning_selfsms_status");
                    C3159aa.m10962a().m10981a("provisioning_select_bridge");
                    m8460g();
                    break;
                } else if (i2 == 3) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[Skip Registration]", this.f8138A);
                    }
                    m8457e();
                    break;
                }
                break;
            case 2:
                if (C3159aa.m10962a().m10987b("skipRegi")) {
                    C3159aa.m10962a().m10981a("skipRegi");
                }
                this.f8144c = C3159aa.m10962a().m10979a("uid", "");
                if (i2 == -1 || !TextUtils.isEmpty(this.f8144c)) {
                    m8459f();
                    break;
                } else {
                    finish();
                    break;
                }
            case 4:
                if (i2 == -1) {
                    if (C3159aa.m10962a().m10979a("provisioning_account_login", "").equals("SKIP")) {
                        if (!C3159aa.m10962a().m10979a("selected_country", "").equals("DONE")) {
                            startActivityForResult(new Intent(this, (Class<?>) SelectCountry.class), 5);
                            break;
                        } else {
                            m8460g();
                            break;
                        }
                    } else {
                        startActivityForResult(new Intent(this, (Class<?>) MainActivity.class), 8);
                        break;
                    }
                } else {
                    finish();
                    break;
                }
            case 5:
                if (i2 == -1) {
                    C3159aa.m10962a().m10986b("selected_country", "DONE");
                    C3159aa.m10966a("first_time_launch", "FIRST_TIME");
                    m8460g();
                    break;
                } else if (i2 == 2) {
                    C3159aa.m10962a().m10981a("selected_country");
                    finish();
                    break;
                } else {
                    finish();
                    break;
                }
            case 6:
            case 7:
                if (i2 == -1) {
                    Intent intent4 = new Intent(this, (Class<?>) ActivityRegist.class);
                    intent4.putExtra(FragmentRegist.f8259a, true);
                    intent4.putExtra(FragmentRegist.f8260b, true);
                    startActivityForResult(intent4, 1);
                    break;
                } else if (i2 == 2) {
                    if (TextUtils.isEmpty(C3159aa.m10962a().m10979a("country_letter", ""))) {
                        finish();
                        break;
                    } else {
                        C3159aa.m10962a().m10981a("selected_country");
                        startActivityForResult(new Intent(this, (Class<?>) SelectCountry.class), 5);
                        break;
                    }
                } else {
                    finish();
                    break;
                }
            case 8:
                if (i2 == -1) {
                    C3250y.m11450b("[SamsungAccount] LogIn", this.f8138A);
                    C3159aa.m10966a("provisioning_account_login", "DONE");
                    m8457e();
                    break;
                } else if (i2 == 0) {
                    finish();
                    break;
                } else if (i2 == 3) {
                    C3159aa.m10963a("skip_sms", (Boolean) true);
                    C3159aa.m10966a("provisioning_account_login", "SKIP");
                    C3250y.m11450b("[Skip SMS]", "ChatON");
                    if (!C3159aa.m10962a().m10979a("selected_country", "").equals("DONE")) {
                        startActivityForResult(new Intent(this, (Class<?>) SelectCountry.class), 5);
                        break;
                    } else {
                        m8460g();
                        break;
                    }
                } else if (i2 == 5) {
                    C3159aa.m10963a("prov_phone", (Boolean) true);
                    C3159aa.m10966a("provisioning_account_login", "PHONE");
                    C3250y.m11450b("[PHONE SMS]", "ChatON");
                    if (C3171am.m11068h() == null && !C3159aa.m10962a().m10979a("selected_country", "").equals("DONE")) {
                        startActivityForResult(new Intent(this, (Class<?>) SelectCountry.class), 5);
                        break;
                    } else {
                        m8460g();
                        break;
                    }
                } else if (i2 == 4) {
                    C1757q.m7255e();
                    C3159aa.m10962a().m10983b("first_time_after_regi", (Boolean) true);
                    if (!C1493a.m6463a("for_wifi_only_device")) {
                        Intent intent5 = new Intent(this.f8154m, (Class<?>) ActivityRegist.class);
                        intent5.putExtra(FragmentRegist.f8260b, true);
                        startActivityForResult(intent5, 11);
                        break;
                    } else {
                        Intent intent6 = new Intent();
                        intent6.putExtra("accountManagerResponse", 5);
                        m8439a(intent6);
                        break;
                    }
                }
                break;
            case 9:
                if (i2 == -1) {
                    this.f8143b = intent.getStringExtra("MSISDN");
                    if (TextUtils.isEmpty(this.f8143b)) {
                        C3159aa.m10966a("msisdn", this.f8143b);
                    }
                    C0816a.m4368d();
                    C3250y.m11456e("CONTACT_SYNC was finished ", "runProvisioning");
                    m8454d();
                    break;
                }
                break;
            case 10:
                if (i2 == -1) {
                    C3159aa.m10962a().m10986b("provisioning_sns_login_state", "DONE");
                    C3250y.m11456e("connect sns accounts finished", "runProvisioning");
                    Intent intent7 = new Intent();
                    intent7.putExtra("accountManagerResponse", 5);
                    m8439a(intent7);
                    break;
                } else if (i2 == 2) {
                    C3159aa.m10962a().m10981a("provisioning_disclaimer_status");
                    m8460g();
                    break;
                } else if (i2 == 3) {
                    C3159aa.m10962a().m10986b("provisioning_sns_login_state", "DONE");
                    m8457e();
                    break;
                } else {
                    C3159aa.m10962a().m10986b("provisioning_sns_login_state", "CANCEL");
                    finish();
                    break;
                }
            case 11:
                if (i2 == -1) {
                    Intent intent8 = new Intent();
                    intent8.putExtra("accountManagerResponse", 5);
                    C3159aa.m10962a().m10983b("first_time_after_regi", (Boolean) true);
                    m8439a(intent8);
                    break;
                } else if (i2 == 0) {
                    finish();
                    break;
                }
                break;
            case 12:
                if (i2 == 5) {
                    C3159aa.m10963a("prov_phone", (Boolean) true);
                    C3159aa.m10966a("provisioning_select_bridge", "DONE");
                    C3159aa.m10966a("provisioning_account_login", "PHONE");
                    C3250y.m11450b("[PHONE SMS]", "ChatON");
                    Intent intent9 = new Intent(this, (Class<?>) ActivityRegist.class);
                    intent9.putExtra(FragmentRegist.f8259a, true);
                    startActivityForResult(intent9, 1);
                    C3159aa.m10966a("provisioning_selfsms_status", "START");
                    break;
                } else {
                    finish();
                    break;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8443a(EnumC2157bh enumC2157bh, String str) {
        m8464i();
        if (C3250y.f11734b) {
            C3250y.m11450b("network error, type : " + enumC2157bh.toString() + " errorCode : " + str, this.f8138A);
        }
        if (GlobalApplication.m11493l() != null && this.f8154m != null) {
            AbstractC3271a.m11494a(this.f8154m).mo11500a(getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(getResources().getString(R.string.toast_network_unable), getResources().getString(R.string.toast_error), str)).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2145aw(this, enumC2157bh)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2143au(this)).mo11505a().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m8462h() {
        this.f8158q = ProgressDialogC3265l.m11489a(this.f8154m, null, getResources().getString(R.string.dialog_provision_ing));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m8464i() {
        if (this.f8158q != null && this.f8158q.isShowing()) {
            this.f8158q.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m8466j() {
        if (!MainActivity.m8746a(this.f8154m)) {
            this.f8151j.m5693a("FIRST");
            return;
        }
        if (!this.f8162u) {
            m8464i();
            this.f8162u = true;
            Intent intent = new Intent(this.f8154m, (Class<?>) NewSPPUpgradeDialog.class);
            intent.putExtra("isCritical", false);
            intent.putExtra("isFromHome", false);
            startActivity(intent);
            return;
        }
        this.f8151j.m5693a("FIRST");
    }

    /* renamed from: k */
    private void m8468k() throws PackageManager.NameNotFoundException {
        int iM11262c = C3214cb.m11262c(this.f8154m);
        String strM11257b = C3214cb.m11257b(this.f8154m);
        if (C3250y.f11734b) {
            C3250y.m11450b("[checkSamsungAccountStatus] verSSO : " + iM11262c + " email : " + strM11257b, this.f8138A);
        }
        if (iM11262c >= 140032) {
            if (!TextUtils.isEmpty(strM11257b)) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("action_sso_check_validation");
                registerReceiver(this.f8140C, intentFilter);
                this.f8159r = true;
                m8470l();
                return;
            }
            new Handler().postDelayed(this.f8139B, 600L);
            return;
        }
        new Handler().postDelayed(this.f8139B, 600L);
    }

    /* renamed from: l */
    private void m8470l() {
        if (C3250y.f11734b) {
            C3250y.m11450b("checkValidation", this.f8138A);
        }
        Intent intent = new Intent("com.msc.action.VALIDATION_CHECK_REQUEST");
        intent.putExtra("client_id", "fs24s8z0hh");
        intent.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
        intent.putExtra("mypackage", this.f8154m.getPackageName());
        intent.putExtra("OSP_VER", "OSP_02");
        intent.putExtra("MODE", "VALIDATION_CHECK");
        sendBroadcast(intent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    /* renamed from: a */
    private void m8439a(Intent intent) {
        setAccountAuthenticatorResult(intent.getExtras());
        setResult(-1, intent);
        finish();
    }

    /* renamed from: c */
    private void m8451c(Bundle bundle) throws PackageManager.NameNotFoundException {
        if (Build.VERSION.SDK_INT >= 17) {
            if (!C3171am.m11071i(GlobalApplication.m11493l())) {
                if (C3250y.f11735c) {
                    C3250y.m11453c("isCurrentUserOwner is false", this.f8138A);
                }
                AbstractC3271a.m11494a(this).mo11500a(getResources().getString(R.string.pop_up_attention)).mo11509b(getResources().getString(R.string.registration_pop_up_warning_mum_temp, getResources().getString(R.string.app_name))).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2148az(this)).mo11511b(false).mo11505a().show();
                return;
            } else {
                if (C3250y.f11734b) {
                    C3250y.m11450b("This is owner", this.f8138A);
                }
                m8440a(bundle);
                m8450c();
                return;
            }
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("android OS is lower than jelly bean MR1", this.f8138A);
        }
        m8440a(bundle);
        m8450c();
    }
}
