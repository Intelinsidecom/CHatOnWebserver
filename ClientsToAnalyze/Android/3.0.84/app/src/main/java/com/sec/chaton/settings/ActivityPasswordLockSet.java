package com.sec.chaton.settings;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.coolots.sso.p006a.C0045a;
import com.coolots.sso.p006a.InterfaceC0047c;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.InterfaceC3226cn;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import java.util.HashMap;
import twitter4j.internal.http.HttpResponseCode;

/* loaded from: classes.dex */
public class ActivityPasswordLockSet extends Activity implements InterfaceC0047c, InterfaceC3226cn {

    /* renamed from: A */
    private int f9021A;

    /* renamed from: B */
    private InterfaceC3274d f9022B;

    /* renamed from: C */
    private boolean f9023C;

    /* renamed from: D */
    private C0045a f9024D;

    /* renamed from: E */
    private Intent f9025E;

    /* renamed from: o */
    private int f9040o;

    /* renamed from: q */
    private String f9042q;

    /* renamed from: s */
    private Button f9044s;

    /* renamed from: t */
    private TextView f9045t;

    /* renamed from: u */
    private Context f9046u;

    /* renamed from: w */
    private int f9048w;

    /* renamed from: x */
    private int f9049x;

    /* renamed from: z */
    private CountDownTimer f9051z;

    /* renamed from: b */
    private final int f9027b = 0;

    /* renamed from: c */
    private final String f9028c = C3159aa.m10962a().m10979a("imei", "");

    /* renamed from: d */
    private String f9029d = ActivityPasswordLockSet.class.getSimpleName();

    /* renamed from: e */
    private ImageView[] f9030e = new ImageView[4];

    /* renamed from: f */
    private int[] f9031f = {R.id.keypad_0, R.id.keypad_1, R.id.keypad_2, R.id.keypad_3, R.id.keypad_4, R.id.keypad_5, R.id.keypad_6, R.id.keypad_7, R.id.keypad_8, R.id.keypad_9, R.id.keypad_back};

    /* renamed from: g */
    private int[] f9032g = {R.id.code_1, R.id.code_2, R.id.code_3, R.id.code_4};

    /* renamed from: h */
    private String f9033h = "";

    /* renamed from: i */
    private String[] f9034i = new String[2];

    /* renamed from: j */
    private String f9035j = "";

    /* renamed from: k */
    private int f9036k = 0;

    /* renamed from: l */
    private int f9037l = 0;

    /* renamed from: m */
    private int f9038m = 0;

    /* renamed from: n */
    private int f9039n = 0;

    /* renamed from: p */
    private int f9041p = 1;

    /* renamed from: r */
    private int f9043r = 0;

    /* renamed from: v */
    private ProgressDialog f9047v = null;

    /* renamed from: y */
    private final int f9050y = 0;

    /* renamed from: a */
    Handler f9026a = new HandlerC2452bm(this, Looper.getMainLooper());

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException, NumberFormatException {
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        C3250y.m11453c("[LIFE] onCreate, SUNFFIX: " + this.f9028c, this.f9029d);
        setContentView(R.layout.layout_password_lock);
        this.f9044s = (Button) findViewById(R.id.keypad_cancel);
        this.f9045t = (TextView) findViewById(R.id.description);
        this.f9046u = this;
        this.f9023C = false;
        try {
            this.f9025E = getIntent();
            this.f9033h = this.f9025E.getExtras().get("MODE").toString();
            C3250y.m11450b("MODE : " + this.f9033h, this.f9029d);
        } catch (Exception e) {
            C3250y.m11450b("error : " + e.toString(), this.f9029d);
        }
        C3241p.m11398a(false);
        m9020a();
        for (int i = 0; i < 4; i++) {
            this.f9030e[i] = (ImageView) findViewById(this.f9032g[i]);
        }
        if (this.f9033h.equals("SET")) {
            C3241p.m11405c(false);
            m9028e(R.string.title_for_passlock_set_activity);
            this.f9044s.setEnabled(true);
            this.f9044s.setText(R.string.layout_chat_fragment_cancel);
        } else if (this.f9033h.equals("CHANGE")) {
            this.f9044s.setEnabled(true);
            this.f9044s.setText(R.string.layout_chat_fragment_cancel);
            C3241p.m11405c(true);
        } else {
            C3241p.m11405c(true);
        }
        String string = getResources().getString(R.string.multideivce_delete_account2);
        if (C1954g.m7916a().m7918a(this.f9046u, EnumC1955h.ChatONV)) {
            this.f9024D = new C0045a();
            if (this.f9024D.m55d(this.f9046u)) {
                this.f9024D.m51a(this.f9046u, this);
                C3250y.m11450b("onCreate:mChatonV.setListener()", getClass().getSimpleName());
            }
        }
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f9046u);
        abstractC3271aM11494a.mo11500a(getResources().getString(R.string.deregister_device)).mo11509b(string).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2446bg(this)).mo11507b(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC2445bf(this));
        this.f9022B = abstractC3271aM11494a.mo11505a();
        this.f9022B.setOnCancelListener(new DialogInterfaceOnCancelListenerC2447bh(this));
        m9014d();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C3250y.m11453c("[LIFE] onNewIntent", this.f9029d);
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveCreateAccount(boolean z, String str) {
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveRemoveAccount(boolean z) {
        C3250y.m11450b("onReceiveRemoveAccount" + z, getClass().getSimpleName());
        if (z) {
            new AsyncTaskC2453bn(this, null).execute(new Void[0]);
        } else {
            this.f9026a.sendEmptyMessage(0);
        }
    }

    public void clickkeypad_back(View view) {
        C3250y.m11450b("clickkeypad_back", this.f9029d);
        if (this.f9037l > 0) {
            C3250y.m11450b("INPUT_PASSWORD : " + this.f9034i[this.f9036k], this.f9029d);
            this.f9037l--;
            this.f9034i[this.f9036k] = this.f9034i[this.f9036k].substring(0, this.f9037l);
            this.f9035j = this.f9035j.substring(0, this.f9037l);
            m9026c(this.f9037l);
            return;
        }
        if (this.f9037l == 0) {
            m9024b();
        }
    }

    public void clickkeypad_cancel(View view) {
        C3250y.m11450b("clickkeypad_cancel", this.f9029d);
        C3241p.m11398a(true);
        C3241p.m11405c(false);
        if (this.f9033h.equals("HOME") || this.f9033h.equals("RECEIVER")) {
            Intent intent = new Intent(this, (Class<?>) TabActivity.class);
            intent.addFlags(67108864);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setAction("android.intent.action.MAIN");
            intent.putExtra("finish", true);
            startActivityForResult(intent, -1);
            return;
        }
        finish();
    }

    public void clickkeypad(View view) {
        C3250y.m11450b("clickkeypad", this.f9029d);
        if (this.f9037l != 4) {
            this.f9043r = 0;
            int i = 0;
            while (true) {
                if (i >= this.f9031f.length - 1) {
                    break;
                }
                if (view.getId() != this.f9031f[i]) {
                    i++;
                } else {
                    this.f9043r = i;
                    break;
                }
            }
            m9019f(this.f9043r);
            String string = Integer.toString(this.f9043r);
            StringBuilder sb = new StringBuilder();
            String[] strArr = this.f9034i;
            int i2 = this.f9036k;
            strArr[i2] = sb.append(strArr[i2]).append(string).toString();
            this.f9035j += string;
            C3250y.m11450b("INPUT_PASSWORD : " + this.f9034i[this.f9036k], this.f9029d);
            m9025b(this.f9037l);
            this.f9037l++;
            if (this.f9037l == 4) {
                C3250y.m11450b("MODE : " + this.f9033h, this.f9029d);
                C3250y.m11450b("keypad_input : " + this.f9037l, this.f9029d);
                String[] strArr2 = new String[2];
                String[] strArrM9023a = m9023a("GET", "", "");
                String strM11401b = C3241p.m11401b(this.f9034i[this.f9036k]);
                String strM11401b2 = C3241p.m11401b(this.f9034i[this.f9036k] + this.f9028c);
                if (C3250y.f11734b) {
                    C3250y.m11450b("inputUserPasswordMD5 : " + strM11401b + " inputUserPasswordMD5new : " + strM11401b2 + " savedData : " + strArrM9023a[this.f9041p], this.f9029d);
                }
                if (this.f9033h.equals("PRIVACY")) {
                    if (strM11401b.equals(strArrM9023a[this.f9041p]) || strM11401b2.equals(strArrM9023a[this.f9041p])) {
                        C3241p.m11405c(false);
                        if (C3241p.m11404b()) {
                            C3241p.m11403b(false);
                        }
                        this.f9039n = 0;
                        if (GlobalApplication.m6456e()) {
                            setResult(-1);
                            finish();
                            return;
                        } else {
                            startActivity(new Intent(this, (Class<?>) ActivityPasswordLockView.class));
                            finish();
                            return;
                        }
                    }
                    m9020a();
                    this.f9037l = 0;
                    m9021a(HttpResponseCode.INTERNAL_SERVER_ERROR);
                    this.f9045t.setTextColor(Color.parseColor("#5f5f5f"));
                    m9027d(R.string.description_for_wrong_passlock);
                    m9022a((String) null);
                    this.f9048w = 0;
                    m9017e();
                    m9024b();
                    return;
                }
                if (this.f9033h.equals("RECEIVER") || this.f9033h.equals("HOME")) {
                    if (strM11401b.equals(strArrM9023a[this.f9041p]) || strM11401b2.equals(strArrM9023a[this.f9041p])) {
                        C3241p.m11405c(false);
                        if (C3241p.m11404b()) {
                            C3241p.m11403b(false);
                        }
                        C3241p.m11398a(true);
                        this.f9039n = 0;
                        setResult(-1, this.f9025E);
                        Intent intent = new Intent();
                        intent.setAction("password_lock_finish");
                        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
                        finish();
                        return;
                    }
                    m9020a();
                    this.f9037l = 0;
                    m9021a(HttpResponseCode.INTERNAL_SERVER_ERROR);
                    this.f9045t.setTextColor(Color.parseColor("#5f5f5f"));
                    m9027d(R.string.description_for_wrong_passlock);
                    m9022a((String) null);
                    this.f9048w = 0;
                    m9017e();
                    m9024b();
                    return;
                }
                if (this.f9033h.equals("CHANGE")) {
                    if (strM11401b.equals(strArrM9023a[this.f9041p]) || strM11401b2.equals(strArrM9023a[this.f9041p])) {
                        C3241p.m11405c(false);
                        if (C3241p.m11404b()) {
                            C3241p.m11403b(false);
                        }
                        this.f9039n = 0;
                        finish();
                        Intent intent2 = new Intent(this, (Class<?>) ActivityPasswordLockSet.class);
                        intent2.putExtra("MODE", "SET");
                        startActivityForResult(intent2, -1);
                        return;
                    }
                    m9020a();
                    this.f9037l = 0;
                    m9021a(HttpResponseCode.INTERNAL_SERVER_ERROR);
                    this.f9045t.setTextColor(Color.parseColor("#5f5f5f"));
                    m9027d(R.string.description_for_wrong_passlock);
                    m9022a((String) null);
                    this.f9048w = 0;
                    m9017e();
                    m9024b();
                    return;
                }
                this.f9036k++;
                if (this.f9036k == 2) {
                    if (this.f9034i[this.f9036k - 2].equals(this.f9034i[this.f9036k - 1])) {
                        C3241p.m11405c(false);
                        if (C3241p.m11404b()) {
                            C3241p.m11403b(false);
                        }
                        m9023a("SET", "ON", this.f9034i[this.f9036k - 1]);
                        return;
                    }
                    m9020a();
                    this.f9037l = 0;
                    this.f9036k = 0;
                    m9021a(HttpResponseCode.INTERNAL_SERVER_ERROR);
                    m9028e(R.string.title_for_passlock_set_activity);
                    this.f9045t.setTextColor(Color.parseColor("#5f5f5f"));
                    m9027d(R.string.description_for_wrong_passlock);
                    m9022a((String) null);
                    m9024b();
                    return;
                }
                this.f9037l = 0;
                m9028e(R.string.title_for_passlock_set_activity_retry);
                m9024b();
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 67) {
            for (int i2 = 0; i2 < 10; i2++) {
                findViewById(this.f9031f[i2]).clearFocus();
            }
            C3250y.m11450b("clickkeypad_back", this.f9029d);
            if (this.f9037l > 0) {
                C3250y.m11450b("INPUT_PASSWORD : " + this.f9034i[this.f9036k], this.f9029d);
                this.f9037l--;
                this.f9034i[this.f9036k] = this.f9034i[this.f9036k].substring(0, this.f9037l);
                this.f9035j = this.f9035j.substring(0, this.f9037l);
                m9026c(this.f9037l);
            } else if (this.f9037l == 0) {
                m9024b();
            }
        }
        if (i == 33 || i == 46 || i == 48 || i == 32 || i == 34 || i == 35 || i == 30 || i == 31 || i == 50 || i == 7 || i == 16 || i == 15 || i == 14 || i == 13 || i == 12 || i == 11 || i == 10 || i == 9 || i == 8) {
            if (keyEvent.getKeyCode() == 7) {
            }
            int i3 = keyEvent.getKeyCode() == 33 ? 1 : 0;
            if (keyEvent.getKeyCode() == 46) {
                i3 = 2;
            }
            if (keyEvent.getKeyCode() == 48) {
                i3 = 3;
            }
            if (keyEvent.getKeyCode() == 32) {
                i3 = 4;
            }
            if (keyEvent.getKeyCode() == 34) {
                i3 = 5;
            }
            if (keyEvent.getKeyCode() == 35) {
                i3 = 6;
            }
            if (keyEvent.getKeyCode() == 31) {
                i3 = 7;
            }
            if (keyEvent.getKeyCode() == 50) {
                i3 = 8;
            }
            if (keyEvent.getKeyCode() == 30) {
                i3 = 9;
            }
            if (keyEvent.getKeyCode() == 8) {
                i3 = 1;
            }
            if (keyEvent.getKeyCode() == 9) {
                i3 = 2;
            }
            if (keyEvent.getKeyCode() == 10) {
                i3 = 3;
            }
            if (keyEvent.getKeyCode() == 11) {
                i3 = 4;
            }
            if (keyEvent.getKeyCode() == 12) {
                i3 = 5;
            }
            if (keyEvent.getKeyCode() == 13) {
                i3 = 6;
            }
            int i4 = keyEvent.getKeyCode() != 15 ? keyEvent.getKeyCode() != 14 ? i3 : 7 : 8;
            if (keyEvent.getKeyCode() == 16) {
                i4 = 9;
            }
            m9019f(i4);
            if (this.f9037l != 4) {
                this.f9043r = 0;
                this.f9043r = i4;
                String string = Integer.toString(this.f9043r);
                StringBuilder sb = new StringBuilder();
                String[] strArr = this.f9034i;
                int i5 = this.f9036k;
                strArr[i5] = sb.append(strArr[i5]).append(string).toString();
                this.f9035j += string;
                C3250y.m11450b("INPUT_PASSWORD : " + this.f9034i[this.f9036k], this.f9029d);
                m9025b(this.f9037l);
                this.f9037l++;
                if (this.f9037l == 4) {
                    for (int i6 = 0; i6 < 10; i6++) {
                        findViewById(this.f9031f[i6]).clearFocus();
                    }
                    C3250y.m11450b("MODE : " + this.f9033h, this.f9029d);
                    C3250y.m11450b("keypad_input : " + this.f9037l, this.f9029d);
                    String[] strArr2 = new String[2];
                    String[] strArrM9023a = m9023a("GET", "", "");
                    String strM11401b = C3241p.m11401b(this.f9034i[this.f9036k] + this.f9028c);
                    if (this.f9033h.equals("PRIVACY")) {
                        if (strM11401b.equals(strArrM9023a[this.f9041p])) {
                            C3241p.m11405c(false);
                            if (C3241p.m11404b()) {
                                C3241p.m11403b(false);
                            }
                            this.f9039n = 0;
                            startActivity(new Intent(this, (Class<?>) ActivityPasswordLockView.class));
                            finish();
                        } else {
                            m9020a();
                            this.f9037l = 0;
                            m9021a(HttpResponseCode.INTERNAL_SERVER_ERROR);
                            this.f9045t.setTextColor(Color.parseColor("#5f5f5f"));
                            m9027d(R.string.description_for_wrong_passlock);
                            m9022a((String) null);
                            this.f9048w = 0;
                            m9017e();
                            m9024b();
                        }
                    } else if (this.f9033h.equals("RECEIVER") || this.f9033h.equals("HOME")) {
                        if (strM11401b.equals(strArrM9023a[this.f9041p])) {
                            C3241p.m11405c(false);
                            if (C3241p.m11404b()) {
                                C3241p.m11403b(false);
                            }
                            C3241p.m11398a(true);
                            this.f9039n = 0;
                            finish();
                        } else {
                            m9020a();
                            this.f9037l = 0;
                            m9021a(HttpResponseCode.INTERNAL_SERVER_ERROR);
                            this.f9045t.setTextColor(Color.parseColor("#5f5f5f"));
                            m9027d(R.string.description_for_wrong_passlock);
                            m9022a((String) null);
                            this.f9048w = 0;
                            m9017e();
                            m9024b();
                        }
                    } else if (this.f9033h.equals("CHANGE")) {
                        if (strM11401b.equals(strArrM9023a[this.f9041p])) {
                            C3241p.m11405c(false);
                            if (C3241p.m11404b()) {
                                C3241p.m11403b(false);
                            }
                            this.f9039n = 0;
                            finish();
                            Intent intent = new Intent(this, (Class<?>) ActivityPasswordLockSet.class);
                            intent.putExtra("MODE", "SET");
                            startActivityForResult(intent, -1);
                        } else {
                            m9020a();
                            this.f9037l = 0;
                            m9021a(HttpResponseCode.INTERNAL_SERVER_ERROR);
                            this.f9045t.setTextColor(Color.parseColor("#5f5f5f"));
                            m9027d(R.string.description_for_wrong_passlock);
                            m9022a((String) null);
                            this.f9048w = 0;
                            m9017e();
                            m9024b();
                        }
                    } else {
                        this.f9036k++;
                        if (this.f9036k == 2) {
                            if (this.f9034i[this.f9036k - 2].equals(this.f9034i[this.f9036k - 1])) {
                                C3241p.m11405c(false);
                                if (C3241p.m11404b()) {
                                    C3241p.m11403b(false);
                                }
                                m9023a("SET", "ON", this.f9034i[this.f9036k - 1]);
                            } else {
                                ((Button) findViewById(R.id.keypad_1)).clearFocus();
                                m9020a();
                                this.f9037l = 0;
                                this.f9036k = 0;
                                m9021a(HttpResponseCode.INTERNAL_SERVER_ERROR);
                                m9028e(R.string.title_for_passlock_set_activity);
                                this.f9045t.setTextColor(Color.parseColor("#5f5f5f"));
                                m9027d(R.string.description_for_wrong_passlock);
                                m9022a((String) null);
                                m9024b();
                            }
                        } else {
                            this.f9037l = 0;
                            ((Button) findViewById(R.id.keypad_1)).clearFocus();
                            m9028e(R.string.title_for_passlock_set_activity_retry);
                            m9024b();
                        }
                    }
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: a */
    public void m9021a(int i) {
        C3250y.m11450b("start_vibrator", this.f9029d);
        ((Vibrator) getApplicationContext().getSystemService("vibrator")).vibrate(i);
    }

    /* renamed from: f */
    private void m9019f(int i) {
        findViewById(this.f9031f[i]).setFocusable(true);
        findViewById(this.f9031f[i]).requestFocus();
        this.f9021A = i;
        this.f9051z = new CountDownTimerC2448bi(this, 300L, 100L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m9012c() {
        if (this.f9051z != null) {
            this.f9051z.cancel();
        }
        findViewById(this.f9031f[this.f9021A]).clearFocus();
    }

    /* renamed from: a */
    public void m9020a() {
        C3250y.m11450b("initialize_password", this.f9029d);
        for (int i = 0; i < 2; i++) {
            this.f9034i[i] = "";
        }
        this.f9035j = "";
    }

    /* renamed from: b */
    public void m9025b(int i) {
        C3250y.m11450b("passlock_setImage", this.f9029d);
        for (int i2 = 0; i2 <= i; i2++) {
            this.f9030e[i2].setVisibility(0);
        }
    }

    /* renamed from: c */
    public void m9026c(int i) {
        C3250y.m11450b("passlock_backImage", this.f9029d);
        this.f9030e[i].setVisibility(4);
    }

    /* renamed from: b */
    public void m9024b() {
        C3250y.m11450b("passlock_defaultImage", this.f9029d);
        new Handler().postDelayed(new RunnableC2449bj(this), 15L);
    }

    /* renamed from: d */
    public void m9027d(int i) {
        C3250y.m11450b("passlock_setText", this.f9029d);
        ((TextView) findViewById(R.id.description)).setText(i);
        this.f9040o = i;
    }

    /* renamed from: e */
    public void m9028e(int i) {
        C3250y.m11450b("passlock_title_setText", this.f9029d);
        ((TextView) findViewById(R.id.title)).setText(i);
        this.f9049x = i;
    }

    /* renamed from: a */
    public void m9022a(String str) {
        C3250y.m11450b("passlock_hint_setText", this.f9029d);
        TextView textView = (TextView) findViewById(R.id.hint);
        textView.setText(str);
        textView.setTextColor(Color.parseColor("#f16623"));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        C3250y.m11450b("onBackPressed", this.f9029d);
        C3241p.m11398a(true);
        C3241p.m11405c(false);
        if (this.f9033h.equals("HOME") || this.f9033h.equals("RECEIVER")) {
            C3250y.m11450b("onBackPressed MODE " + this.f9033h, this.f9029d);
            Intent intent = new Intent(this, (Class<?>) TabActivity.class);
            intent.addFlags(67108864);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setAction("android.intent.action.MAIN");
            intent.putExtra("finish", true);
            startActivityForResult(intent, -1);
            return;
        }
        if (C3241p.m11404b()) {
            C3241p.m11403b(false);
        }
        finish();
    }

    /* renamed from: a */
    public String[] m9023a(String str, String str2, String str3) {
        C3250y.m11450b("prePassword", this.f9029d);
        String[] strArr = new String[2];
        for (int i = 0; i < 2; i++) {
            strArr[i] = "";
        }
        SharedPreferences sharedPreferences = getSharedPreferences("PASSWORD_LOCK", 0);
        C3160ab c3160abM10962a = C3159aa.m10962a();
        if (str.equals("GET")) {
            C3250y.m11450b("GET preference", this.f9029d);
            strArr[0] = sharedPreferences.getString("LOCK_STATE", C3241p.m11409e());
            strArr[1] = sharedPreferences.getString("PASSWORD", "0000");
        } else {
            C3250y.m11450b("SET preference", this.f9029d);
            C3250y.m11450b("state : " + str2, this.f9029d);
            C3250y.m11450b("original pass : " + str3, this.f9029d);
            String str4 = str3 + this.f9028c;
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            String strM11401b = C3241p.m11401b(str2);
            String strM11401b2 = C3241p.m11401b(str4);
            editorEdit.putString("LOCK_STATE", strM11401b);
            editorEdit.putString("PASSWORD", strM11401b2);
            editorEdit.putString("PASSWORD_HINT", "");
            editorEdit.commit();
            C3250y.m11450b("final pass : " + str4, this.f9029d);
            C3250y.m11450b("editor : " + editorEdit, this.f9029d);
            c3160abM10962a.m10986b("OFF", str2);
            C3250y.m11450b("LOCK_STATE : " + c3160abM10962a.m10979a("OFF", "default"), this.f9029d);
            C3241p.m11405c(false);
            finish();
        }
        return strArr;
    }

    @Override // android.app.Activity
    public Object onRetainNonConfigurationInstance() {
        C3250y.m11450b("onRetainNonConfigurationInstance", this.f9029d);
        HashMap map = new HashMap();
        C3250y.m11450b("backupmapclear : " + map, this.f9029d);
        map.put("INPUT_PASSWORD[0]", this.f9034i[0]);
        C3250y.m11450b("INPUT_PASSWORD[0] :" + this.f9034i[0], this.f9029d);
        map.put("INPUT_PASSWORD[1]", this.f9034i[1]);
        C3250y.m11450b("INPUT_PASSWORD[1] :" + this.f9034i[1], this.f9029d);
        map.put("inputUserPassword", this.f9035j);
        C3250y.m11450b("inputUserPassword :" + this.f9035j, this.f9029d);
        String string = Integer.toString(this.f9036k);
        map.put("password_index", string);
        C3250y.m11450b("password_index : " + string, this.f9029d);
        String string2 = Integer.toString(this.f9037l);
        map.put("keypad_input", string2);
        C3250y.m11450b("keypad_input : " + string2, this.f9029d);
        map.put("descriptionbackup", Integer.toString(this.f9040o));
        map.put("titlebackup", Integer.toString(this.f9049x));
        map.put("hintbackup", this.f9042q);
        String string3 = Integer.toString(this.f9038m);
        map.put("error_count", string3);
        C3250y.m11450b("error_count : " + string3, this.f9029d);
        String string4 = Integer.toString(this.f9048w);
        map.put("error_count_temp", string4);
        C3250y.m11450b("error_count_temp : " + string4, this.f9029d);
        String string5 = Integer.toString(this.f9039n);
        map.put("error_number_count", string5);
        C3250y.m11450b("error_number_count : " + string5, this.f9029d);
        if (this.f9023C) {
            map.put("config_changed", "yes");
            C3250y.m11450b("config is changing", this.f9029d);
        }
        return map;
    }

    /* renamed from: d */
    private void m9014d() throws NumberFormatException {
        C3250y.m11450b("Restore", this.f9029d);
        Object lastNonConfigurationInstance = getLastNonConfigurationInstance();
        if (lastNonConfigurationInstance != null) {
            HashMap map = (HashMap) lastNonConfigurationInstance;
            this.f9034i[0] = (String) map.get("INPUT_PASSWORD[0]");
            C3250y.m11450b("INPUT_PASSWORD[0] :" + this.f9034i[0], this.f9029d);
            this.f9034i[1] = (String) map.get("INPUT_PASSWORD[1]");
            C3250y.m11450b("INPUT_PASSWORD[1] :" + this.f9034i[1], this.f9029d);
            this.f9035j = (String) map.get("inputUserPassword");
            C3250y.m11450b("inputUserPassword :" + this.f9035j, this.f9029d);
            int i = Integer.parseInt((String) map.get("password_index"));
            this.f9036k = i;
            C3250y.m11450b("password_index : " + i, this.f9029d);
            int i2 = Integer.parseInt((String) map.get("keypad_input"));
            this.f9037l = i2;
            C3250y.m11450b("keypad_input : " + i2, this.f9029d);
            this.f9040o = Integer.parseInt((String) map.get("descriptionbackup"));
            if (this.f9040o != 0) {
                m9027d(this.f9040o);
            }
            this.f9049x = Integer.parseInt((String) map.get("titlebackup"));
            if (this.f9049x != 0) {
                m9028e(this.f9049x);
            }
            int i3 = Integer.parseInt((String) map.get("error_count"));
            this.f9038m = i3;
            C3250y.m11450b("error_count : " + i3, this.f9029d);
            int i4 = Integer.parseInt((String) map.get("error_count_temp"));
            this.f9048w = i4;
            C3250y.m11450b("error_count_temp : " + i4, this.f9029d);
            int i5 = Integer.parseInt((String) map.get("error_number_count"));
            this.f9039n = i5;
            C3250y.m11450b("error_number_count : " + i5, this.f9029d);
            this.f9042q = (String) map.get("hintbackup");
            C3250y.m11450b("Restore error_count" + this.f9038m, this.f9029d);
            String str = (String) map.get("config_changed");
            if (str != null && str.equals("yes")) {
                this.f9022B.show();
                this.f9023C = true;
            }
            if (this.f9048w >= 5) {
                if ("".equals(this.f9042q)) {
                    C3250y.m11450b("Hint null", this.f9029d);
                } else {
                    m9022a(getResources().getString(R.string.description_for_hint) + " : " + m9011b(this.f9042q));
                }
                this.f9044s.setEnabled(true);
                this.f9044s.setText(R.string.deregister_device);
                this.f9044s.setOnClickListener(new ViewOnClickListenerC2450bk(this));
            }
            C3250y.m11450b("backupmap : " + map, this.f9029d);
            for (int i6 = 1; i6 <= this.f9037l; i6++) {
                m9025b(i6 - 1);
            }
        }
    }

    /* renamed from: e */
    private void m9017e() {
        this.f9038m++;
        this.f9039n++;
        this.f9042q = getSharedPreferences("PASSWORD_LOCK", 0).getString("PASSWORD_HINT", "");
        if (this.f9038m >= 5) {
            this.f9048w = this.f9038m;
            C3250y.m11450b("error_count_temp : " + this.f9048w, this.f9029d);
            if ("".equals(this.f9042q)) {
                C3250y.m11450b("Hint null", this.f9029d);
            } else {
                m9022a(getResources().getString(R.string.description_for_hint) + " : " + m9011b(this.f9042q));
            }
            m9027d(R.string.description_for_passlock_footer);
            this.f9044s.setEnabled(true);
            this.f9044s.setText(R.string.deregister_device);
            this.f9044s.setOnClickListener(new ViewOnClickListenerC2451bl(this));
            return;
        }
        this.f9044s.setEnabled(false);
        this.f9044s.setText("");
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        C3250y.m11453c("[LIFE] onStart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f9029d);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        C3250y.m11453c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f9029d);
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        C3250y.m11453c("[LIFE] onRestart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f9029d);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C3250y.m11453c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f9029d);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        C3250y.m11453c("[LIFE] onStop, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f9029d);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f9047v != null && this.f9047v.isShowing()) {
            this.f9047v.dismiss();
        }
        if (C1954g.m7916a().m7918a(this.f9046u, EnumC1955h.ChatONV)) {
            this.f9024D.m51a(this.f9046u, (InterfaceC0047c) null);
            C3250y.m11450b("onDestroy:mChatonV.setListener(null)", getClass().getSimpleName());
        }
        C3250y.m11453c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f9029d);
    }

    /* renamed from: b */
    private String m9011b(String str) {
        return new String(Base64.decode(str, 0));
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        if (this.f9033h.equals("SET")) {
            C3241p.m11403b(true);
            finish();
        }
    }

    @Override // com.sec.chaton.util.InterfaceC3226cn
    public int getDefaultTheme() {
        return R.style.AppTheme_NoTitleBar;
    }

    @Override // com.sec.chaton.util.InterfaceC3226cn
    public int getBlackTheme() {
        return R.style.AppTheme_NoTitleBar;
    }
}
