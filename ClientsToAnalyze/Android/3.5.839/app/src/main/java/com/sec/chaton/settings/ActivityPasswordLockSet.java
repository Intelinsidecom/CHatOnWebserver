package com.sec.chaton.settings;

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
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v4.content.C0096i;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.coolots.sso.p030a.C0416a;
import com.coolots.sso.p030a.InterfaceC0418c;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.p055d.AbstractC1899a;
import com.sec.chaton.p055d.C2093az;
import com.sec.chaton.passwordlock.PasswordLockActivity;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4810ab;
import com.sec.chaton.util.C4892m;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.HandlerC4826ar;
import com.sec.chaton.util.InterfaceC4876cn;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.util.C5033j;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ActivityPasswordLockSet extends PasswordLockActivity implements InterfaceC0418c, InterfaceC4876cn {

    /* renamed from: J */
    private static long f12577J = -1;

    /* renamed from: A */
    private int f12578A;

    /* renamed from: C */
    private CountDownTimer f12580C;

    /* renamed from: D */
    private int f12581D;

    /* renamed from: E */
    private InterfaceC4936e f12582E;

    /* renamed from: F */
    private boolean f12583F;

    /* renamed from: G */
    private C0416a f12584G;

    /* renamed from: H */
    private Intent f12585H;

    /* renamed from: I */
    private AbstractC1899a<?> f12586I;

    /* renamed from: r */
    private int f12605r;

    /* renamed from: t */
    private String f12607t;

    /* renamed from: v */
    private Button f12609v;

    /* renamed from: w */
    private TextView f12610w;

    /* renamed from: x */
    private Context f12611x;

    /* renamed from: z */
    private int f12613z;

    /* renamed from: b */
    private final int f12589b = 3;

    /* renamed from: c */
    private final int f12590c = 5;

    /* renamed from: d */
    private final int f12591d = 30000;

    /* renamed from: e */
    private final int f12592e = 0;

    /* renamed from: f */
    private final String f12593f = C4809aa.m18104a().m18121a("imei", "");

    /* renamed from: g */
    private String f12594g = ActivityPasswordLockSet.class.getSimpleName();

    /* renamed from: h */
    private ImageView[] f12595h = new ImageView[4];

    /* renamed from: i */
    private int[] f12596i = {R.id.keypad_0, R.id.keypad_1, R.id.keypad_2, R.id.keypad_3, R.id.keypad_4, R.id.keypad_5, R.id.keypad_6, R.id.keypad_7, R.id.keypad_8, R.id.keypad_9, R.id.keypad_back};

    /* renamed from: j */
    private int[] f12597j = {R.id.code_1, R.id.code_2, R.id.code_3, R.id.code_4};

    /* renamed from: k */
    private String f12598k = "";

    /* renamed from: l */
    private String[] f12599l = new String[2];

    /* renamed from: m */
    private String f12600m = "";

    /* renamed from: n */
    private int f12601n = 0;

    /* renamed from: o */
    private int f12602o = 0;

    /* renamed from: p */
    private int f12603p = 0;

    /* renamed from: q */
    private int f12604q = 0;

    /* renamed from: s */
    private int f12606s = 1;

    /* renamed from: u */
    private int f12608u = 0;

    /* renamed from: y */
    private ProgressDialog f12612y = null;

    /* renamed from: B */
    private final int f12579B = 0;

    /* renamed from: K */
    private HandlerC4826ar f12587K = new HandlerC3547ck(this);

    /* renamed from: a */
    Handler f12588a = new HandlerC3548cl(this, Looper.getMainLooper());

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException, NumberFormatException {
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        C4892m.m18587g(true);
        C4904y.m18641c("[LIFE] onCreate, SUNFFIX: " + this.f12593f, this.f12594g);
        setContentView(R.layout.layout_password_lock);
        this.f12609v = (Button) findViewById(R.id.keypad_cancel);
        this.f12610w = (TextView) findViewById(R.id.description);
        this.f12611x = this;
        this.f12583F = false;
        try {
            this.f12585H = getIntent();
            this.f12598k = this.f12585H.getExtras().get("MODE").toString();
            C4904y.m18639b("MODE : " + this.f12598k, this.f12594g);
        } catch (Exception e) {
            C4904y.m18639b("error : " + e.toString(), this.f12594g);
        }
        C4892m.m18573b(false);
        this.f12586I = C2093az.m9337a();
        m13488a();
        for (int i = 0; i < 4; i++) {
            this.f12595h[i] = (ImageView) findViewById(this.f12597j[i]);
        }
        if (this.f12598k.equals("SET")) {
            C4892m.m18582e(false);
            m13496e(R.string.title_for_passlock_set_activity);
            this.f12609v.setEnabled(true);
            this.f12609v.setText(R.string.layout_chat_fragment_cancel);
        } else if (this.f12598k.equals("CHANGE")) {
            this.f12609v.setEnabled(true);
            this.f12609v.setText(R.string.layout_chat_fragment_cancel);
            C4892m.m18582e(true);
        } else {
            C4892m.m18582e(true);
        }
        String string = getResources().getString(R.string.multideivce_delete_account2);
        if (C2948h.m12190a().m12192a(this.f12611x, EnumC2949i.ChatONV)) {
            this.f12584G = new C0416a();
            if (this.f12584G.m1495d(this.f12611x)) {
                this.f12584G.m1491a(this.f12611x, this);
                C4904y.m18639b("onCreate:mChatonV.setListener()", getClass().getSimpleName());
            }
        }
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f12611x);
        abstractC4932aM18733a.mo18740a(getResources().getString(R.string.deregister_device)).mo18749b(string).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3542cf(this)).mo18747b(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC3541ce(this));
        this.f12582E = abstractC4932aM18733a.mo18745a();
        this.f12582E.setOnCancelListener(new DialogInterfaceOnCancelListenerC3543cg(this));
        m13481e();
        if (f12577J != -1) {
            m13483f();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C4904y.m18641c("[LIFE] onNewIntent", this.f12594g);
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a */
    public void mo1508a(boolean z, String str) {
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a_ */
    public void mo1509a_(boolean z) {
        C4904y.m18639b("onReceiveRemoveAccount" + z, getClass().getSimpleName());
        this.f12586I.mo9079b(this.f12587K);
        this.f12587K.m18263a(1002, 30000);
    }

    public void clickkeypad_back(View view) {
        C4904y.m18639b("clickkeypad_back", this.f12594g);
        if (this.f12602o > 0) {
            C4904y.m18639b("INPUT_PASSWORD : " + this.f12599l[this.f12601n], this.f12594g);
            this.f12602o--;
            this.f12599l[this.f12601n] = this.f12599l[this.f12601n].substring(0, this.f12602o);
            this.f12600m = this.f12600m.substring(0, this.f12602o);
            m13494c(this.f12602o);
            return;
        }
        if (this.f12602o == 0) {
            m13492b();
        }
    }

    public void clickkeypad_cancel(View view) {
        C4904y.m18639b("clickkeypad_cancel", this.f12594g);
        C4892m.m18573b(true);
        C4892m.m18582e(false);
        if (this.f12598k.equals("HOME") || this.f12598k.equals("RECEIVER")) {
            Intent intent = new Intent(this, (Class<?>) TabActivity.class);
            intent.addFlags(67108864);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setAction("android.intent.action.MAIN");
            intent.putExtra("finish", true);
            startActivityForResult(intent, -1);
            return;
        }
        C4892m.m18570a(false);
        finish();
    }

    public void clickkeypad(View view) {
        C4904y.m18639b("clickkeypad", this.f12594g);
        if (this.f12602o != 4) {
            this.f12608u = 0;
            int i = 0;
            while (true) {
                if (i >= this.f12596i.length - 1) {
                    break;
                }
                if (view.getId() != this.f12596i[i]) {
                    i++;
                } else {
                    this.f12608u = i;
                    break;
                }
            }
            m13484f(this.f12608u);
            String string = Integer.toString(this.f12608u);
            StringBuilder sb = new StringBuilder();
            String[] strArr = this.f12599l;
            int i2 = this.f12601n;
            strArr[i2] = sb.append(strArr[i2]).append(string).toString();
            this.f12600m += string;
            C4904y.m18639b("INPUT_PASSWORD : " + this.f12599l[this.f12601n], this.f12594g);
            m13493b(this.f12602o);
            this.f12602o++;
            if (this.f12602o == 4) {
                C4904y.m18639b("MODE : " + this.f12598k, this.f12594g);
                C4904y.m18639b("keypad_input : " + this.f12602o, this.f12594g);
                String[] strArr2 = new String[2];
                String[] strArrM13491a = m13491a("GET", "", "");
                String strM18567a = C4892m.m18567a(this.f12599l[this.f12601n]);
                String strM18567a2 = C4892m.m18567a(this.f12599l[this.f12601n] + this.f12593f);
                if (C4904y.f17872b) {
                    C4904y.m18639b("inputUserPasswordMD5 : " + strM18567a + " inputUserPasswordMD5new : " + strM18567a2 + " savedData : " + strArrM13491a[this.f12606s], this.f12594g);
                }
                if (this.f12598k.equals("PRIVACY")) {
                    if (strM18567a.equals(strArrM13491a[this.f12606s]) || strM18567a2.equals(strArrM13491a[this.f12606s])) {
                        C4892m.m18582e(false);
                        if (C4892m.m18578c()) {
                            C4892m.m18577c(false);
                        }
                        this.f12604q = 0;
                        startActivity(new Intent(this, (Class<?>) ActivityPasswordLockView.class));
                        finish();
                        return;
                    }
                    m13488a();
                    this.f12602o = 0;
                    m13489a(500);
                    this.f12610w.setTextColor(Color.parseColor("#5f5f5f"));
                    m13495d(R.string.backup_password_toast);
                    m13490a((String) null);
                    this.f12613z = 0;
                    m13483f();
                    m13492b();
                    return;
                }
                if (this.f12598k.equals("RECEIVER") || this.f12598k.equals("HOME")) {
                    if (strM18567a.equals(strArrM13491a[this.f12606s]) || strM18567a2.equals(strArrM13491a[this.f12606s])) {
                        C4892m.m18582e(false);
                        if (C4892m.m18578c()) {
                            C4892m.m18577c(false);
                        }
                        C4892m.m18573b(true);
                        C4892m.m18570a(false);
                        C4892m.m18587g(false);
                        this.f12604q = 0;
                        setResult(-1, this.f12585H);
                        Intent intent = new Intent();
                        intent.setAction("password_lock_finish");
                        C0096i.m358a(this).m363a(intent);
                        finish();
                        return;
                    }
                    m13488a();
                    this.f12602o = 0;
                    m13489a(500);
                    this.f12610w.setTextColor(Color.parseColor("#5f5f5f"));
                    m13495d(R.string.backup_password_toast);
                    m13490a((String) null);
                    this.f12613z = 0;
                    m13483f();
                    m13492b();
                    return;
                }
                if (this.f12598k.equals("CHANGE")) {
                    if (strM18567a.equals(strArrM13491a[this.f12606s]) || strM18567a2.equals(strArrM13491a[this.f12606s])) {
                        C4892m.m18582e(false);
                        if (C4892m.m18578c()) {
                            C4892m.m18577c(false);
                        }
                        this.f12604q = 0;
                        finish();
                        Intent intent2 = new Intent(this, (Class<?>) ActivityPasswordLockSet.class);
                        intent2.putExtra("MODE", "SET");
                        startActivityForResult(intent2, -1);
                        return;
                    }
                    m13488a();
                    this.f12602o = 0;
                    m13489a(500);
                    this.f12610w.setTextColor(Color.parseColor("#5f5f5f"));
                    m13495d(R.string.backup_password_toast);
                    m13490a((String) null);
                    this.f12613z = 0;
                    m13483f();
                    m13492b();
                    return;
                }
                this.f12601n++;
                if (this.f12601n == 2) {
                    if (this.f12599l[this.f12601n - 2].equals(this.f12599l[this.f12601n - 1])) {
                        C4892m.m18582e(false);
                        if (C4892m.m18578c()) {
                            C4892m.m18577c(false);
                        }
                        m13491a("SET", "ON", this.f12599l[this.f12601n - 1]);
                        return;
                    }
                    m13488a();
                    this.f12602o = 0;
                    this.f12601n = 0;
                    m13489a(500);
                    m13496e(R.string.title_for_passlock_set_activity);
                    this.f12610w.setTextColor(Color.parseColor("#5f5f5f"));
                    m13495d(R.string.backup_password_toast);
                    m13490a((String) null);
                    m13492b();
                    return;
                }
                this.f12602o = 0;
                m13496e(R.string.title_for_passlock_set_activity_retry);
                m13492b();
                m13480d();
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 67) {
            for (int i2 = 0; i2 < 10; i2++) {
                findViewById(this.f12596i[i2]).clearFocus();
            }
            C4904y.m18639b("clickkeypad_back", this.f12594g);
            if (this.f12602o > 0) {
                C4904y.m18639b("INPUT_PASSWORD : " + this.f12599l[this.f12601n], this.f12594g);
                this.f12602o--;
                this.f12599l[this.f12601n] = this.f12599l[this.f12601n].substring(0, this.f12602o);
                this.f12600m = this.f12600m.substring(0, this.f12602o);
                m13494c(this.f12602o);
            } else if (this.f12602o == 0) {
                m13492b();
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
            m13484f(i4);
            if (this.f12602o != 4) {
                this.f12608u = 0;
                this.f12608u = i4;
                String string = Integer.toString(this.f12608u);
                StringBuilder sb = new StringBuilder();
                String[] strArr = this.f12599l;
                int i5 = this.f12601n;
                strArr[i5] = sb.append(strArr[i5]).append(string).toString();
                this.f12600m += string;
                C4904y.m18639b("INPUT_PASSWORD : " + this.f12599l[this.f12601n], this.f12594g);
                m13493b(this.f12602o);
                this.f12602o++;
                if (this.f12602o == 4) {
                    for (int i6 = 0; i6 < 10; i6++) {
                        findViewById(this.f12596i[i6]).clearFocus();
                    }
                    C4904y.m18639b("MODE : " + this.f12598k, this.f12594g);
                    C4904y.m18639b("keypad_input : " + this.f12602o, this.f12594g);
                    String[] strArr2 = new String[2];
                    String[] strArrM13491a = m13491a("GET", "", "");
                    String strM18567a = C4892m.m18567a(this.f12599l[this.f12601n] + this.f12593f);
                    if (this.f12598k.equals("PRIVACY")) {
                        if (strM18567a.equals(strArrM13491a[this.f12606s])) {
                            C4892m.m18582e(false);
                            if (C4892m.m18578c()) {
                                C4892m.m18577c(false);
                            }
                            this.f12604q = 0;
                            startActivity(new Intent(this, (Class<?>) ActivityPasswordLockView.class));
                            finish();
                        } else {
                            m13488a();
                            this.f12602o = 0;
                            m13489a(500);
                            this.f12610w.setTextColor(Color.parseColor("#5f5f5f"));
                            m13495d(R.string.backup_password_toast);
                            m13490a((String) null);
                            this.f12613z = 0;
                            m13483f();
                            m13492b();
                        }
                    } else if (this.f12598k.equals("RECEIVER") || this.f12598k.equals("HOME")) {
                        if (strM18567a.equals(strArrM13491a[this.f12606s])) {
                            C4892m.m18582e(false);
                            if (C4892m.m18578c()) {
                                C4892m.m18577c(false);
                            }
                            C4892m.m18573b(true);
                            C4892m.m18570a(false);
                            C4892m.m18587g(false);
                            this.f12604q = 0;
                            finish();
                        } else {
                            m13488a();
                            this.f12602o = 0;
                            m13489a(500);
                            this.f12610w.setTextColor(Color.parseColor("#5f5f5f"));
                            m13495d(R.string.backup_password_toast);
                            m13490a((String) null);
                            this.f12613z = 0;
                            m13483f();
                            m13492b();
                        }
                    } else if (this.f12598k.equals("CHANGE")) {
                        if (strM18567a.equals(strArrM13491a[this.f12606s])) {
                            C4892m.m18582e(false);
                            if (C4892m.m18578c()) {
                                C4892m.m18577c(false);
                            }
                            this.f12604q = 0;
                            finish();
                            Intent intent = new Intent(this, (Class<?>) ActivityPasswordLockSet.class);
                            intent.putExtra("MODE", "SET");
                            startActivityForResult(intent, -1);
                        } else {
                            m13488a();
                            this.f12602o = 0;
                            m13489a(500);
                            this.f12610w.setTextColor(Color.parseColor("#5f5f5f"));
                            m13495d(R.string.backup_password_toast);
                            m13490a((String) null);
                            this.f12613z = 0;
                            m13483f();
                            m13492b();
                        }
                    } else {
                        this.f12601n++;
                        if (this.f12601n == 2) {
                            if (this.f12599l[this.f12601n - 2].equals(this.f12599l[this.f12601n - 1])) {
                                C4892m.m18582e(false);
                                if (C4892m.m18578c()) {
                                    C4892m.m18577c(false);
                                }
                                m13491a("SET", "ON", this.f12599l[this.f12601n - 1]);
                            } else {
                                ((Button) findViewById(R.id.keypad_1)).clearFocus();
                                m13488a();
                                this.f12602o = 0;
                                this.f12601n = 0;
                                m13489a(500);
                                m13496e(R.string.title_for_passlock_set_activity);
                                this.f12610w.setTextColor(Color.parseColor("#5f5f5f"));
                                m13495d(R.string.backup_password_toast);
                                m13490a((String) null);
                                m13492b();
                            }
                        } else {
                            this.f12602o = 0;
                            ((Button) findViewById(R.id.keypad_1)).clearFocus();
                            m13496e(R.string.title_for_passlock_set_activity_retry);
                            m13492b();
                            m13480d();
                        }
                    }
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: a */
    public void m13489a(int i) {
        C4904y.m18639b("start_vibrator", this.f12594g);
        ((Vibrator) getApplicationContext().getSystemService("vibrator")).vibrate(i);
    }

    /* renamed from: f */
    private void m13484f(int i) {
        findViewById(this.f12596i[i]).setFocusable(true);
        findViewById(this.f12596i[i]).requestFocus();
        this.f12581D = i;
        this.f12580C = new CountDownTimerC3544ch(this, 300L, 100L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m13477c() {
        if (this.f12580C != null) {
            this.f12580C.cancel();
        }
        findViewById(this.f12596i[this.f12581D]).clearFocus();
    }

    /* renamed from: a */
    public void m13488a() {
        C4904y.m18639b("initialize_password", this.f12594g);
        for (int i = 0; i < 2; i++) {
            this.f12599l[i] = "";
        }
        this.f12600m = "";
    }

    /* renamed from: b */
    public void m13493b(int i) {
        C4904y.m18639b("passlock_setImage", this.f12594g);
        for (int i2 = 0; i2 <= i; i2++) {
            this.f12595h[i2].setVisibility(0);
        }
    }

    /* renamed from: c */
    public void m13494c(int i) {
        C4904y.m18639b("passlock_backImage", this.f12594g);
        this.f12595h[i].setVisibility(4);
    }

    /* renamed from: b */
    public void m13492b() {
        C4904y.m18639b("passlock_defaultImage", this.f12594g);
        new Handler().postDelayed(new RunnableC3545ci(this), 15L);
    }

    /* renamed from: d */
    public void m13495d(int i) {
        C4904y.m18639b("passlock_setText", this.f12594g);
        TextView textView = (TextView) findViewById(R.id.description);
        if (i == -1) {
            textView.setText("");
        } else {
            textView.setText(i);
        }
        this.f12605r = i;
    }

    /* renamed from: d */
    private void m13480d() {
        if (C4904y.f17872b) {
            C4904y.m18639b("passlock_clearDescription", this.f12594g);
        }
        ((TextView) findViewById(R.id.description)).setText("");
    }

    /* renamed from: e */
    public void m13496e(int i) {
        C4904y.m18639b("passlock_title_setText", this.f12594g);
        ((TextView) findViewById(R.id.title)).setText(i);
        this.f12578A = i;
    }

    /* renamed from: a */
    public void m13490a(String str) {
        C4904y.m18639b("passlock_hint_setText", this.f12594g);
        TextView textView = (TextView) findViewById(R.id.hint);
        textView.setText(str);
        textView.setTextColor(Color.parseColor("#f16623"));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        C4904y.m18639b("onBackPressed", this.f12594g);
        C4892m.m18573b(true);
        C4892m.m18582e(false);
        if (this.f12598k.equals("HOME") || this.f12598k.equals("RECEIVER")) {
            C4904y.m18639b("onBackPressed MODE " + this.f12598k, this.f12594g);
            Intent intent = new Intent(this, (Class<?>) TabActivity.class);
            intent.addFlags(67108864);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setAction("android.intent.action.MAIN");
            intent.putExtra("finish", true);
            startActivityForResult(intent, -1);
            return;
        }
        if (C4892m.m18578c()) {
            C4892m.m18577c(false);
        }
        finish();
    }

    /* renamed from: a */
    public String[] m13491a(String str, String str2, String str3) {
        String strM18588h;
        C4904y.m18639b("prePassword", this.f12594g);
        String[] strArr = new String[2];
        for (int i = 0; i < 2; i++) {
            strArr[i] = "";
        }
        SharedPreferences sharedPreferences = getSharedPreferences("PASSWORD_LOCK", 0);
        C4810ab c4810abM18104a = C4809aa.m18104a();
        if (str.equals("GET")) {
            C4904y.m18639b("GET preference", this.f12594g);
            strArr[0] = sharedPreferences.getString("LOCK_STATE", C4892m.m18588h());
            strArr[1] = sharedPreferences.getString("PASSWORD", "0000");
        } else {
            C4904y.m18639b("SET preference", this.f12594g);
            C4904y.m18639b("state : " + str2, this.f12594g);
            C4904y.m18639b("original pass : " + str3, this.f12594g);
            String str4 = str3 + this.f12593f;
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (!str2.equals("OFF")) {
                strM18588h = C4892m.m18586g();
                if (!C1059a.f3350a) {
                    C1059a.m6165a(true);
                }
            } else {
                strM18588h = C4892m.m18588h();
            }
            String strM18567a = C4892m.m18567a(str4);
            editorEdit.putString("LOCK_STATE", strM18588h);
            editorEdit.putString("PASSWORD", strM18567a);
            editorEdit.putString("PASSWORD_HINT", "");
            C5033j.m19087a(editorEdit);
            C4904y.m18639b("final pass : " + str4, this.f12594g);
            C4904y.m18639b("editor : " + editorEdit, this.f12594g);
            c4810abM18104a.m18128b("OFF", str2);
            C4904y.m18639b("LOCK_STATE : " + c4810abM18104a.m18121a("OFF", "default"), this.f12594g);
            C4892m.m18582e(false);
            finish();
        }
        return strArr;
    }

    @Override // android.app.Activity
    public Object onRetainNonConfigurationInstance() {
        C4904y.m18639b("onRetainNonConfigurationInstance", this.f12594g);
        HashMap map = new HashMap();
        C4904y.m18639b("backupmapclear : " + map, this.f12594g);
        map.put("INPUT_PASSWORD[0]", this.f12599l[0]);
        C4904y.m18639b("INPUT_PASSWORD[0] :" + this.f12599l[0], this.f12594g);
        map.put("INPUT_PASSWORD[1]", this.f12599l[1]);
        C4904y.m18639b("INPUT_PASSWORD[1] :" + this.f12599l[1], this.f12594g);
        map.put("inputUserPassword", this.f12600m);
        C4904y.m18639b("inputUserPassword :" + this.f12600m, this.f12594g);
        String string = Integer.toString(this.f12601n);
        map.put("password_index", string);
        C4904y.m18639b("password_index : " + string, this.f12594g);
        String string2 = Integer.toString(this.f12602o);
        map.put("keypad_input", string2);
        C4904y.m18639b("keypad_input : " + string2, this.f12594g);
        map.put("descriptionbackup", Integer.toString(this.f12605r));
        map.put("titlebackup", Integer.toString(this.f12578A));
        map.put("hintbackup", this.f12607t);
        String string3 = Integer.toString(this.f12603p);
        map.put("error_count", string3);
        C4904y.m18639b("error_count : " + string3, this.f12594g);
        String string4 = Integer.toString(this.f12613z);
        map.put("error_count_temp", string4);
        C4904y.m18639b("error_count_temp : " + string4, this.f12594g);
        String string5 = Integer.toString(this.f12604q);
        map.put("error_number_count", string5);
        C4904y.m18639b("error_number_count : " + string5, this.f12594g);
        if (this.f12583F) {
            map.put("config_changed", "yes");
            C4904y.m18639b("config is changing", this.f12594g);
        }
        return map;
    }

    /* renamed from: e */
    private void m13481e() throws NumberFormatException {
        C4904y.m18639b("Restore", this.f12594g);
        Object lastNonConfigurationInstance = getLastNonConfigurationInstance();
        if (lastNonConfigurationInstance != null) {
            HashMap map = (HashMap) lastNonConfigurationInstance;
            this.f12599l[0] = (String) map.get("INPUT_PASSWORD[0]");
            C4904y.m18639b("INPUT_PASSWORD[0] :" + this.f12599l[0], this.f12594g);
            this.f12599l[1] = (String) map.get("INPUT_PASSWORD[1]");
            C4904y.m18639b("INPUT_PASSWORD[1] :" + this.f12599l[1], this.f12594g);
            this.f12600m = (String) map.get("inputUserPassword");
            C4904y.m18639b("inputUserPassword :" + this.f12600m, this.f12594g);
            int i = Integer.parseInt((String) map.get("password_index"));
            this.f12601n = i;
            C4904y.m18639b("password_index : " + i, this.f12594g);
            int i2 = Integer.parseInt((String) map.get("keypad_input"));
            this.f12602o = i2;
            C4904y.m18639b("keypad_input : " + i2, this.f12594g);
            this.f12605r = Integer.parseInt((String) map.get("descriptionbackup"));
            if (this.f12605r != 0) {
                m13495d(this.f12605r);
            }
            this.f12578A = Integer.parseInt((String) map.get("titlebackup"));
            if (this.f12578A != 0) {
                m13496e(this.f12578A);
            }
            int i3 = Integer.parseInt((String) map.get("error_count"));
            this.f12603p = i3;
            C4904y.m18639b("error_count : " + i3, this.f12594g);
            int i4 = Integer.parseInt((String) map.get("error_count_temp"));
            this.f12613z = i4;
            C4904y.m18639b("error_count_temp : " + i4, this.f12594g);
            int i5 = Integer.parseInt((String) map.get("error_number_count"));
            this.f12604q = i5;
            C4904y.m18639b("error_number_count : " + i5, this.f12594g);
            this.f12607t = (String) map.get("hintbackup");
            C4904y.m18639b("Restore error_count" + this.f12603p, this.f12594g);
            String str = (String) map.get("config_changed");
            if (str != null && str.equals("yes")) {
                this.f12582E.show();
                this.f12583F = true;
            }
            m13478c(false);
            C4904y.m18639b("backupmap : " + map, this.f12594g);
            for (int i6 = 1; i6 <= this.f12602o; i6++) {
                m13493b(i6 - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m13475b(boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("changeKeypadsStatus : " + z, this.f12594g);
        }
        for (int i : this.f12596i) {
            findViewById(i).setEnabled(z);
        }
    }

    /* renamed from: f */
    private void m13483f() {
        this.f12607t = getSharedPreferences("PASSWORD_LOCK", 0).getString("PASSWORD_HINT", "");
        m13478c(true);
    }

    /* renamed from: c */
    private void m13478c(boolean z) {
        Long lValueOf;
        if (z) {
            this.f12603p++;
            this.f12604q++;
        }
        if (this.f12603p >= 5 || f12577J != -1) {
            if (f12577J == -1) {
                f12577J = SystemClock.elapsedRealtime();
                lValueOf = 0L;
            } else {
                lValueOf = Long.valueOf(SystemClock.elapsedRealtime() - f12577J);
            }
            new CountDownTimerC3546cj(this, 30000 - lValueOf.longValue(), 1000L).start();
            m13475b(false);
            return;
        }
        if (this.f12603p >= 3) {
            this.f12613z = this.f12603p;
            C4904y.m18639b("error_count_temp : " + this.f12613z, this.f12594g);
            if ("".equals(this.f12607t)) {
                C4904y.m18639b("Hint null", this.f12594g);
            } else {
                m13490a(getResources().getString(R.string.description_for_hint) + " : " + m13473b(this.f12607t));
            }
            m13495d(R.string.description_for_passlock_footer);
            return;
        }
        this.f12609v.setEnabled(false);
        this.f12609v.setText("");
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        C4904y.m18641c("[LIFE] onStart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f12594g);
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C4904y.m18641c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f12594g);
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        C4904y.m18641c("[LIFE] onRestart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f12594g);
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        C4904y.m18641c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f12594g);
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        C4904y.m18641c("[LIFE] onStop, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f12594g);
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f12612y != null && this.f12612y.isShowing()) {
            this.f12612y.dismiss();
        }
        if (C2948h.m12190a().m12192a(this.f12611x, EnumC2949i.ChatONV)) {
            this.f12584G.m1491a(this.f12611x, (InterfaceC0418c) null);
            C4904y.m18639b("onDestroy:mChatonV.setListener(null)", getClass().getSimpleName());
        }
        C4904y.m18641c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, this.f12594g);
    }

    /* renamed from: b */
    private String m13473b(String str) {
        return new String(Base64.decode(str, 0));
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onUserLeaveHint() {
        if (this.f12598k.equals("SET")) {
            C4892m.m18577c(true);
            finish();
        }
    }

    @Override // com.sec.chaton.util.InterfaceC4876cn
    public int getDefaultTheme() {
        return R.style.AppTheme_NoTitleBar;
    }

    @Override // com.sec.chaton.util.InterfaceC4876cn
    public int getBlackTheme() {
        return R.style.AppTheme_NoTitleBar;
    }
}
