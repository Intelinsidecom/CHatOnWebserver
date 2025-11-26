package com.sec.chaton.registration;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.constant.ChatONConst;
import com.sec.chaton.control.AbstractPushControl;
import com.sec.chaton.control.PushControlFactory;
import com.sec.chaton.control.RegistrationControl;
import com.sec.chaton.control.SMSGatewayControl;
import com.sec.chaton.p000io.entry.GetSMSAuthToken;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;

/* loaded from: classes.dex */
public class ActivityNonSelfSMS extends BaseActivity {

    /* renamed from: a */
    protected GetSMSAuthToken f2808a;

    /* renamed from: c */
    Context f2810c;

    /* renamed from: d */
    protected String f2811d;

    /* renamed from: i */
    private EditText f2816i;

    /* renamed from: j */
    private Button f2817j;

    /* renamed from: k */
    private Button f2818k;

    /* renamed from: l */
    private SMSGatewayControl f2819l;

    /* renamed from: m */
    private String f2820m;

    /* renamed from: n */
    private String f2821n;

    /* renamed from: o */
    private CountDownTimer f2822o;

    /* renamed from: p */
    private boolean f2823p;

    /* renamed from: q */
    private ProgressDialog f2824q;

    /* renamed from: r */
    private TextView f2825r;

    /* renamed from: s */
    private TextView f2826s;

    /* renamed from: t */
    private String f2827t;

    /* renamed from: u */
    private String f2828u;

    /* renamed from: v */
    private EditText f2829v;

    /* renamed from: w */
    private RegistrationControl f2830w;

    /* renamed from: x */
    private AbstractPushControl f2831x;

    /* renamed from: y */
    private String f2832y;

    /* renamed from: b */
    protected String f2809b = "";

    /* renamed from: e */
    Handler f2812e = new HandlerC0436l(this, Looper.getMainLooper());

    /* renamed from: z */
    private TextWatcher f2833z = new C0435k(this);

    /* renamed from: f */
    View.OnClickListener f2813f = new ViewOnClickListenerC0434j(this);

    /* renamed from: A */
    private TextWatcher f2807A = new C0439o(this);

    /* renamed from: g */
    Handler f2814g = new HandlerC0438n(this);

    /* renamed from: h */
    public Handler f2815h = new HandlerC0416an(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3048b() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f2810c);
        builder.setTitle(C0062R.string.provisioning_verification_failed);
        builder.setMessage(String.format(getResources().getString(C0062R.string.setting_non_selfsms_retry_in_five_min), Integer.valueOf(ChatONConst.f1343g))).setNegativeButton(C0062R.string.dialog_ok, new DialogInterfaceOnClickListenerC0440p(this));
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3049c() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f2810c);
        builder.setTitle(C0062R.string.provisioning_verification_failed);
        builder.setMessage(C0062R.string.setting_non_selfsms_incorrect_code).setNegativeButton(C0062R.string.dialog_ok, new DialogInterfaceOnClickListenerC0437m(this));
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m3051d() {
        this.f2819l.m2077a(this.f2820m, this.f2821n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m3054e() {
        this.f2819l.m2078a(this.f2808a == null ? null : this.f2808a.token, this.f2820m, this.f2821n, this.f2827t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m3056f() {
        this.f2832y = this.f2829v.getText().toString();
        ChatONPref.m3519a().edit().putString("msisdn", this.f2827t).commit();
        ChatONPref.m3519a().edit().putString("Push Name", this.f2832y).commit();
        ChatONLogWriter.m3506b("mMsisdn: " + this.f2827t + "PushName" + this.f2832y, "ChatOn");
        this.f2831x = PushControlFactory.m2072a();
        this.f2830w = new RegistrationControl(this.f2815h);
        this.f2831x.mo1974a(this.f2814g);
    }

    /* renamed from: a */
    public void m3063a() {
        if (this.f2822o != null) {
            ChatONLogWriter.m3506b("Timer Cancel.", getClass().getSimpleName());
            this.f2822o.cancel();
            this.f2823p = false;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2810c = this;
        this.f2819l = new SMSGatewayControl(this.f2812e);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f2820m = extras.getString("COUNTRY_CODE");
            this.f2821n = extras.getString("PHONE_NUMBER");
            this.f2828u = extras.getString("SMS_PHONE_NUMBER");
            this.f2827t = extras.getString("MSISDN");
            ChatONLogWriter.m3506b("mCountry=" + this.f2820m + " mPhoneNumber=" + this.f2821n + " mSelfSmsPn=" + this.f2828u, getClass().getSimpleName());
        }
        getWindow().setSoftInputMode(2);
        this.f2824q = ProgressDialog.show(this.f2810c, null, getResources().getString(C0062R.string.dialog_connecting_server), true);
        m3051d();
        setContentView(C0062R.layout.layout_non_self_sms);
        this.f2816i = (EditText) findViewById(C0062R.id.vCode);
        this.f2817j = (Button) findViewById(C0062R.id.reSend);
        this.f2825r = (TextView) findViewById(C0062R.id.changePho);
        this.f2825r.setText(Html.fromHtml("<u>" + getResources().getString(C0062R.string.ams_optmenu_edit) + "</u>"));
        this.f2818k = (Button) findViewById(C0062R.id.btnDone);
        this.f2826s = (TextView) findViewById(C0062R.id.phoneNo);
        this.f2826s.setText(this.f2828u);
        this.f2817j.setOnClickListener(this.f2813f);
        this.f2818k.setOnClickListener(this.f2813f);
        this.f2825r.setOnClickListener(this.f2813f);
        this.f2816i.addTextChangedListener(this.f2833z);
        this.f2829v = (EditText) findViewById(C0062R.id.txtName);
        this.f2829v.addTextChangedListener(this.f2807A);
        ((TextView) findViewById(C0062R.id.verification_explain_text)).setText(getString(C0062R.string.provisioning_verification_explain, new Object[]{3}));
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ChatONLogWriter.m3506b("onDestory...", "ActivityNonSelfSMS");
        m3063a();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        ChatONLogWriter.m3506b("onPause...", "ActivityNonSelfSMS");
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ChatONLogWriter.m3506b("onResume...", "ActivityNonSelfSMS");
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        ChatONLogWriter.m3506b("onStop...", "ActivityNonSelfSMS");
    }
}
