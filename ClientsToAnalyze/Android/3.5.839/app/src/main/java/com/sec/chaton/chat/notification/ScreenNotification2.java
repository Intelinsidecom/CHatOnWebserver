package com.sec.chaton.chat.notification;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.sec.multiwindow.MultiWindow;
import android.sec.multiwindow.MultiWindowManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.InterfaceC0196cc;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.cover.ScoverManager;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1062bb;
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.R;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C2717y;
import com.sec.chaton.p055d.C2136q;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.C2302v;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.smsplugin.transaction.BackgroundSenderService;
import com.sec.chaton.specialbuddy.EnumC4549n;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4810ab;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.CustomViewPager;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class ScreenNotification2 extends FragmentActivity implements View.OnClickListener, InterfaceC1829r {

    /* renamed from: B */
    private Context f6729B;

    /* renamed from: D */
    private C4810ab f6731D;

    /* renamed from: G */
    private Toast f6734G;

    /* renamed from: J */
    private int f6737J;

    /* renamed from: K */
    private TextView f6738K;

    /* renamed from: L */
    private TextView f6739L;

    /* renamed from: M */
    private ImageButton f6740M;

    /* renamed from: N */
    private Button f6741N;

    /* renamed from: O */
    private Button f6742O;

    /* renamed from: P */
    private Button f6743P;

    /* renamed from: Q */
    private Button f6744Q;

    /* renamed from: R */
    private EditText f6745R;

    /* renamed from: S */
    private CustomViewPager f6746S;

    /* renamed from: T */
    private C1807an f6747T;

    /* renamed from: U */
    private LinearLayout f6748U;

    /* renamed from: W */
    private C1830s f6750W;

    /* renamed from: X */
    private ProgressBar f6751X;

    /* renamed from: Y */
    private TextView f6752Y;

    /* renamed from: Z */
    private LinearLayout f6753Z;

    /* renamed from: aa */
    private ImageView f6754aa;

    /* renamed from: ab */
    private ImageView f6755ab;

    /* renamed from: ac */
    private ImageView f6756ac;

    /* renamed from: ae */
    private Runnable f6758ae;

    /* renamed from: af */
    private C2210x f6759af;

    /* renamed from: ag */
    private boolean f6760ag;

    /* renamed from: ah */
    private boolean f6761ah;

    /* renamed from: aj */
    private int f6763aj;

    /* renamed from: al */
    private ScoverManager f6765al;

    /* renamed from: am */
    private C1806am f6766am;

    /* renamed from: v */
    private static final String f6727v = ScreenNotification2.class.getSimpleName();

    /* renamed from: n */
    public static String f6726n = "is_black_popup";

    /* renamed from: w */
    private final int f6777w = 99;

    /* renamed from: x */
    private final int f6778x = 10;

    /* renamed from: y */
    private final int f6779y = 11;

    /* renamed from: z */
    private final int f6780z = 100;

    /* renamed from: A */
    private final int f6728A = 101;

    /* renamed from: C */
    private C1813b f6730C = null;

    /* renamed from: E */
    private C2142w f6732E = null;

    /* renamed from: F */
    private C2136q f6733F = null;

    /* renamed from: H */
    private C1828q f6735H = null;

    /* renamed from: o */
    boolean f6770o = false;

    /* renamed from: p */
    boolean f6771p = false;

    /* renamed from: I */
    private boolean f6736I = false;

    /* renamed from: V */
    private int f6749V = 0;

    /* renamed from: ad */
    private int f6757ad = 5000;

    /* renamed from: q */
    String f6772q = null;

    /* renamed from: ai */
    private boolean f6762ai = false;

    /* renamed from: ak */
    private boolean f6764ak = false;

    /* renamed from: an */
    private BroadcastReceiver f6767an = null;

    /* renamed from: ao */
    private Handler f6768ao = new HandlerC1835x(this);

    /* renamed from: ap */
    private InterfaceC0196cc f6769ap = new C1836y(this);

    /* renamed from: r */
    InterfaceC2211y f6773r = new C1837z(this);

    /* renamed from: s */
    protected Handler f6774s = new HandlerC1794aa(this);

    /* renamed from: t */
    protected Handler f6775t = new HandlerC1795ab(this);

    /* renamed from: u */
    public Handler f6776u = new HandlerC1796ac(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        int i;
        HandlerC1835x handlerC1835x = null;
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        if (C4904y.f17873c) {
            C4904y.m18641c("[onCreate]", f6727v);
        }
        this.f6729B = this;
        if (MultiWindowManager.isMultiWindowServiceEnabled(this.f6729B)) {
            MultiWindow multiWindowCreateInstance = MultiWindow.createInstance(this);
            if (multiWindowCreateInstance.isMultiWindow()) {
                multiWindowCreateInstance.normalWindow();
                this.f6762ai = true;
            }
        }
        if (MultiWindowManager.isMultiWindowServiceEnabled(this.f6729B)) {
            MultiWindow multiWindowCreateInstance2 = MultiWindow.createInstance(this);
            if (multiWindowCreateInstance2.isMultiWindow()) {
                multiWindowCreateInstance2.normalWindow();
                this.f6762ai = true;
            }
        }
        this.f6734G = C5179v.m19811a(this.f6729B, (CharSequence) null, 0);
        this.f6759af = new C2210x(this.f6729B.getContentResolver(), this.f6773r);
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_popup_noti, (ViewGroup) null);
        requestWindowFeature(1);
        if (getIntent().getExtras().getBoolean(f6726n)) {
            getWindow().getDecorView().setBackgroundColor(-16777216);
            getClass();
            this.f6737J = 11;
            getWindow().addFlags(2621442);
        } else {
            getWindow().getDecorView().setBackgroundColor(0);
            if (C4822an.m18237g(this.f6729B)) {
                getClass();
                i = 11;
            } else {
                getClass();
                i = 10;
            }
            this.f6737J = i;
            getWindow().addFlags(2621440);
            this.f6758ae = new RunnableC1798ae(this);
            this.f6768ao.postDelayed(this.f6758ae, this.f6757ad);
        }
        setContentView(viewInflate);
        if (this.f6730C == null) {
            this.f6730C = C1813b.m8906b();
        }
        this.f6730C.m8932a(true);
        if (this.f6735H == null) {
            this.f6735H = C1828q.m8956a();
        }
        if (this.f6735H.m8974f() <= 0) {
            if (C4904y.f17873c) {
                C4904y.m18641c("[onCreate] unread count is zero. finish popup.", f6727v);
            }
            m8882g();
            return;
        }
        this.f6731D = C4809aa.m18104a();
        this.f6751X = (ProgressBar) viewInflate.findViewById(R.id.noti_progress);
        this.f6751X.setVisibility(8);
        this.f6738K = (TextView) viewInflate.findViewById(R.id.textSenderName);
        this.f6739L = (TextView) viewInflate.findViewById(R.id.textMsgCount);
        this.f6745R = (EditText) viewInflate.findViewById(R.id.noti_edit_chat);
        this.f6745R.setFocusable(true);
        this.f6745R.setFocusableInTouchMode(true);
        this.f6745R.setOnFocusChangeListener(new ViewOnFocusChangeListenerC1799af(this));
        this.f6745R.addTextChangedListener(new C1800ag(this));
        this.f6745R.setOnClickListener(this);
        this.f6745R.setOnEditorActionListener(new C1801ah(this));
        this.f6748U = (LinearLayout) findViewById(R.id.noti_chat);
        this.f6740M = (ImageButton) findViewById(R.id.noti_send_button);
        this.f6740M.setEnabled(false);
        this.f6740M.setOnClickListener(this);
        this.f6742O = (Button) findViewById(R.id.button2);
        this.f6742O.setText(R.string.close);
        this.f6742O.setOnClickListener(this);
        this.f6741N = (Button) findViewById(R.id.button3);
        this.f6741N.setText(R.string.dialog_view);
        this.f6741N.setOnClickListener(this);
        this.f6744Q = (Button) findViewById(R.id.button4);
        this.f6744Q.setText(R.string.menu_chat_delete);
        this.f6744Q.setOnClickListener(this);
        this.f6744Q.setVisibility(8);
        this.f6743P = (Button) findViewById(R.id.button1);
        this.f6743P.setOnClickListener(this);
        this.f6743P.setText(R.string.dialog_ok);
        this.f6743P.setVisibility(8);
        this.f6746S = (CustomViewPager) findViewById(R.id.pagerContents);
        this.f6763aj = this.f6735H.m8974f();
        this.f6747T = new C1807an(this, m50e());
        this.f6746S.setAdapter(this.f6747T);
        this.f6746S.setOnPageChangeListener(this.f6769ap);
        this.f6752Y = (TextView) findViewById(R.id.errorContents);
        this.f6752Y.setVisibility(8);
        this.f6746S.setVisibility(4);
        this.f6753Z = (LinearLayout) findViewById(R.id.imageSettings);
        this.f6753Z.setOnClickListener(this);
        this.f6754aa = (ImageView) findViewById(R.id.leftArrow);
        this.f6754aa.setVisibility(4);
        this.f6755ab = (ImageView) findViewById(R.id.rightArrow);
        this.f6755ab.setVisibility(4);
        this.f6756ac = (ImageView) findViewById(R.id.imageTitle);
        getWindow().getDecorView().setOnTouchListener(new ViewOnTouchListenerC1802ai(this));
        this.f6755ab.setOnClickListener(new ViewOnClickListenerC1803aj(this));
        this.f6754aa.setOnClickListener(new ViewOnClickListenerC1804ak(this));
        this.f6735H.m8961a(this);
        m8861q();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.f6767an = new C1808ao(this, handlerC1835x);
        registerReceiver(this.f6767an, intentFilter);
        if (18 < Build.VERSION.SDK_INT) {
            this.f6765al = new ScoverManager(this);
            this.f6765al.setCoverModeToWindow(getWindow(), 1);
        }
        this.f6766am = new C1806am(this, handlerC1835x);
        C0991aa.m6037a().m18959a(this.f6766am);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C4904y.m18639b("onResume", f6727v);
        if (this.f6737J == 11) {
            if (this.f6760ag && !this.f6761ah) {
                this.f6761ah = true;
            }
            if (!this.f6760ag) {
                this.f6760ag = true;
            }
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: p */
    private String m8858p() {
        String strM18121a = this.f6731D.m18121a("OFF", "OFF");
        if (Build.VERSION.SDK_INT >= 16 && strM18121a.equals("OFF")) {
            KeyguardManager keyguardManager = (KeyguardManager) this.f6729B.getSystemService("keyguard");
            if (C4904y.f17873c) {
                C4904y.m18641c("isLocked:" + keyguardManager.isKeyguardLocked() + ", isSecure:" + keyguardManager.isKeyguardSecure(), getClass().getSimpleName());
            }
            if (keyguardManager.isKeyguardLocked() && keyguardManager.isKeyguardSecure()) {
                return "ON";
            }
        }
        return strM18121a;
    }

    /* renamed from: q */
    private void m8861q() throws Resources.NotFoundException {
        this.f6750W = this.f6735H.m8958a(this.f6749V);
        this.f6736I = false;
        if (this.f6745R != null && (this.f6745R.hasFocus() || this.f6745R.getText().length() > 0)) {
            this.f6736I = true;
        }
        if (this.f6749V >= this.f6763aj) {
            if (C4904y.f17875e) {
                C4904y.m18634a("[EXCEPTION] current index is smaller than unread count. Finish pop-up. index:" + this.f6749V + ", count:" + this.f6763aj, f6727v);
            }
            m8882g();
            return;
        }
        this.f6772q = m8858p();
        boolean zStartsWith = this.f6750W.f6927a.startsWith("0999");
        if (this.f6731D.m18119a("Setting show receive message", (Boolean) true).booleanValue() && this.f6772q.equals("OFF")) {
            this.f6739L.setText("" + (this.f6749V + 1) + "/" + m8863r());
            this.f6738K.setText(this.f6750W.f6928b);
            this.f6746S.setCurrentItem(this.f6749V, false);
            this.f6752Y.setVisibility(8);
            this.f6746S.setVisibility(0);
            if (this.f6749V == 0) {
                m8835a(EnumC1809ap.HIDE);
                if (this.f6763aj > 1) {
                    m8835a(EnumC1809ap.SHOW_RIGHT);
                }
            }
            if (zStartsWith && this.f6750W.f6933g == EnumC2214ab.LIVECONTENTS.m10076a()) {
                this.f6748U.setVisibility(8);
            } else {
                this.f6748U.setVisibility(0);
                if (this.f6742O.isShown()) {
                    this.f6742O.setEnabled(true);
                }
                if (this.f6741N.isShown()) {
                    this.f6741N.setEnabled(true);
                }
            }
            if (C2349a.m10301a("sms_feature")) {
                if (this.f6750W.f6943q != C1828q.f6914b) {
                    this.f6744Q.setVisibility(0);
                    this.f6756ac.setBackgroundResource(R.drawable.actionbar_ic_chaton_sns_lite);
                    return;
                } else {
                    this.f6744Q.setVisibility(8);
                    this.f6756ac.setBackgroundResource(R.drawable.actionbar_ic_chaton);
                    return;
                }
            }
            return;
        }
        m8841c(101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public String m8863r() {
        if (this.f6763aj > 99) {
            return Integer.toString(99) + "+";
        }
        return Integer.toString(this.f6763aj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8841c(int i) throws Resources.NotFoundException {
        String string;
        this.f6738K.setText(this.f6729B.getResources().getString(R.string.app_name));
        this.f6739L.setVisibility(8);
        this.f6746S.setVisibility(8);
        this.f6748U.setVisibility(8);
        if (C4904y.f17873c) {
            C4904y.m18641c("[setSimpleInfo] type:" + i, f6727v);
        }
        m8835a(EnumC1809ap.HIDE);
        if (i == 100) {
            this.f6752Y.setText(this.f6729B.getResources().getString(R.string.auth_error_restart));
            this.f6752Y.setVisibility(0);
            this.f6742O.setVisibility(8);
            this.f6741N.setVisibility(8);
            this.f6743P.setVisibility(0);
            return;
        }
        if (i == 101) {
            if (this.f6763aj > 1) {
                string = this.f6729B.getResources().getString(R.string.new_chaton_messages, Integer.valueOf(this.f6763aj));
            } else {
                string = this.f6729B.getResources().getString(R.string.twitter_post_message);
            }
            this.f6752Y.setText(string);
            this.f6752Y.setVisibility(0);
            this.f6742O.setVisibility(0);
            this.f6741N.setVisibility(0);
            this.f6743P.setVisibility(8);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) throws Resources.NotFoundException {
        super.onNewIntent(intent);
        setIntent(intent);
        if (C4904y.f17873c) {
            C4904y.m18641c("[onNewIntent]", f6727v);
        }
        if (this.f6735H.m8974f() == 0) {
            if (C4904y.f17873c) {
                C4904y.m18641c("[onNewIntent] msg count is zero. finish", f6727v);
            }
            m8882g();
            return;
        }
        if (this.f6768ao != null) {
            this.f6768ao.removeCallbacks(this.f6758ae);
            if (!this.f6736I) {
                this.f6768ao.postDelayed(this.f6758ae, this.f6757ad);
            }
        }
        if (this.f6747T != null) {
            this.f6747T.m617c();
        }
        this.f6746S.setVisibility(4);
        m8861q();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1 /* 2131165821 */:
                C0991aa.m6037a().m18962d(new C1062bb());
                break;
            case R.id.button2 /* 2131165822 */:
                if (!C4822an.m18218a()) {
                }
                m8882g();
                break;
            case R.id.button3 /* 2131165823 */:
                if (!C4822an.m18218a()) {
                }
                m8885j();
                break;
            case R.id.button4 /* 2131165824 */:
                this.f6746S.setScrollDisable(true);
                m8884i();
                break;
            case R.id.imageSettings /* 2131166104 */:
                if (!C4822an.m18218a()) {
                }
                m8867t();
                break;
            case R.id.noti_edit_chat /* 2131166110 */:
                m8883h();
                break;
            case R.id.noti_send_button /* 2131166111 */:
                if (!C4822an.m18218a()) {
                }
                this.f6746S.setScrollDisable(true);
                m8888m();
                break;
        }
    }

    /* renamed from: s */
    private void m8865s() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_unread_count", (Integer) 0);
        this.f6759af.startUpdate(0, null, C2299s.m10186a(this.f6750W.f6931e, EnumC4549n.LIVECHAT), contentValues, null, null);
    }

    /* renamed from: f */
    protected void m8881f() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_unread_count", (Integer) 0);
        this.f6759af.startUpdate(0, null, C2299s.m10198k(), contentValues, "inbox_no = ?", new String[]{this.f6750W.f6931e});
    }

    /* renamed from: g */
    protected void m8882g() {
        m8869u();
        finish();
        overridePendingTransition(0, 0);
    }

    /* renamed from: t */
    private void m8867t() {
        Intent intentM2923a = IntentControllerActivity.m2923a(CommonApplication.m18732r(), true);
        Uri uri = Uri.parse("chaton://settings/alerts");
        intentM2923a.setAction("android.intent.action.VIEW");
        intentM2923a.addCategory("android.intent.category.BROWSABLE");
        intentM2923a.setData(uri);
        startActivity(intentM2923a);
        m8882g();
    }

    /* renamed from: h */
    protected void m8883h() {
        GlobalApplication.f8358d = true;
        this.f6736I = true;
        if (this.f6768ao != null) {
            this.f6768ao.removeCallbacks(this.f6758ae);
        }
    }

    /* renamed from: a */
    protected void m8878a(CharSequence charSequence) {
        if (charSequence.length() == 10000) {
            this.f6740M.setEnabled(true);
            C5179v.m19810a(this.f6729B, R.string.toast_text_max_Length, 0).show();
        } else if (charSequence.toString().replaceAll(" ", "").replaceAll("\n", "").length() > 0 && !this.f6740M.isEnabled()) {
            this.f6740M.setEnabled(true);
        } else if (charSequence.toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
            this.f6740M.setEnabled(false);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: i */
    protected void m8884i() {
        if (this.f6750W.f6943q != C1828q.f6914b) {
            this.f6751X.setVisibility(0);
            this.f6748U.setVisibility(8);
            this.f6759af.startQuery(101, null, C2302v.f8225a, new String[]{"inboxsms_mapping_sms_no"}, "inboxsms_mapping_inbox_no=?", new String[]{this.f6750W.f6931e}, null);
        }
    }

    /* renamed from: j */
    protected void m8885j() {
        Intent intentM2923a;
        if (this.f6750W == null || TextUtils.isEmpty(this.f6750W.f6931e)) {
            if (C4904y.f17873c) {
                C4904y.m18641c("[processClickViewButton] current item or inbox is null. Go to 4 tab", f6727v);
            }
            Intent intentM2923a2 = IntentControllerActivity.m2923a(CommonApplication.m18732r(), true);
            intentM2923a2.setAction("com.sec.chaton.action.NOTI_MESSAGE");
            intentM2923a2.putExtra("callChatTab", true);
            startActivity(intentM2923a2);
            m8882g();
            return;
        }
        if (this.f6750W.f6932f == EnumC2300t.WEB_AUTH.m10210a()) {
            intentM2923a = IntentControllerActivity.m2923a((Context) this, true);
            intentM2923a.putExtra("inboxNO", this.f6750W.f6931e);
            intentM2923a.putExtra("chatType", this.f6750W.f6932f);
            intentM2923a.putExtra("fromPush", 1);
            intentM2923a.putExtra("Content", this.f6750W.f6929c);
        } else {
            intentM2923a = IntentControllerActivity.m2923a((Context) this, true);
            intentM2923a.putExtra("callChatList", true);
            intentM2923a.putExtra("inboxNO", this.f6750W.f6931e);
            intentM2923a.putExtra("chatType", this.f6750W.f6932f);
            if (!TextUtils.isEmpty(this.f6750W.f6935i)) {
                intentM2923a.putExtra("sessionID", this.f6750W.f6935i);
            }
            intentM2923a.putExtra("fromPush", 1);
            intentM2923a.putExtra("roomType", this.f6750W.f6942p.m10212a());
            intentM2923a.putExtra("msgContentType", this.f6750W.f6933g);
            if (this.f6736I) {
                intentM2923a.putExtra(ChatFragment.f5473i, true);
            }
            intentM2923a.putExtra("buddyNO", this.f6750W.f6927a);
            if (this.f6745R != null && this.f6748U.getVisibility() == 0) {
                String string = this.f6745R.getText().toString();
                if (!TextUtils.isEmpty(string)) {
                    intentM2923a.putExtra("lastTempMessage", string);
                }
            }
        }
        startActivity(intentM2923a);
    }

    /* renamed from: k */
    protected void m8886k() {
        String string = this.f6745R.getText().toString();
        String[] strArr = {this.f6750W.f6927a};
        if (C4904y.f17873c) {
            int length = string.length() > 4 ? 3 : string.length();
            C4904y.m18641c("[processClickSmsSendButton] Recipients:" + this.f6750W.f6927a, f6727v);
            C4904y.m18641c("[processClickSmsSendButton] message:" + string.substring(0, length), f6727v);
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("[processClickSmsSendButton] request sms message send", f6727v);
        }
        BackgroundSenderService.m15514a(this.f6729B, string, strArr, 100, this.f6776u);
        new C1805al(this, Long.valueOf(Long.parseLong(this.f6750W.f6931e))).start();
        C5179v.m19810a(this.f6729B, R.string.ams_btn_done, 0).show();
        this.f6735H.m8961a((InterfaceC1829r) null);
        C1813b.m8906b().m8922a(this.f6750W.f6931e, C1813b.f6840i);
        m8882g();
    }

    /* renamed from: l */
    protected void m8887l() {
        if (this.f6745R.getText().toString().replace(" ", "").replaceAll("\n", "").length() == 0) {
            this.f6745R.setText("");
            return;
        }
        this.f6748U.setVisibility(8);
        this.f6751X.setVisibility(0);
        m8886k();
    }

    /* renamed from: m */
    protected void m8888m() {
        C1832u c1832u;
        if (C2349a.m10301a("sms_feature") && this.f6750W.f6942p == EnumC2301u.SMS) {
            m8887l();
            return;
        }
        if (this.f6745R.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
            this.f6745R.setText("");
            return;
        }
        this.f6748U.setVisibility(8);
        if (this.f6742O.isShown()) {
            this.f6742O.setEnabled(false);
        }
        if (this.f6741N.isShown()) {
            this.f6741N.setEnabled(false);
        }
        if (this.f6744Q.isShown()) {
            this.f6744Q.setEnabled(false);
        }
        this.f6751X.setVisibility(0);
        this.f6764ak = true;
        if (this.f6750W.f6927a.startsWith("0999") && this.f6750W.f6933g != EnumC2214ab.LIVECONTENTS.m10076a()) {
            if (C4904y.f17873c) {
                C4904y.m18641c("[processClickOnSendButton] It is message from Live partner.", f6727v);
            }
            m8865s();
            this.f6733F = C2136q.m9582a(this.f6750W.f6931e, EnumC2300t.m10207a(this.f6750W.f6932f));
            this.f6733F.m9246a(this.f6774s);
            this.f6733F.m9220a(EnumC2214ab.TEXT, EnumC2300t.m10207a(this.f6750W.f6932f), "", new String[]{this.f6750W.f6927a}, this.f6745R.getText().toString(), "");
            return;
        }
        int iM10677a = C2471v.m10677a(this.f6729B);
        if (!((-3 == iM10677a || -2 == iM10677a) ? false : true) && !C2717y.m11398b()) {
            this.f6734G.setText(R.string.popup_no_network_connection);
            this.f6734G.setDuration(0);
            this.f6734G.show();
            return;
        }
        if (!C4873ck.m18503d()) {
            this.f6734G.setText(R.string.popup_not_enough_memory);
            this.f6734G.setDuration(0);
            this.f6734G.show();
            return;
        }
        String str = this.f6750W.f6931e;
        C1832u c1832uM8968b = this.f6735H.m8968b(this.f6750W.f6931e);
        if (c1832uM8968b == null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("Can not find server. Start DB query inboxNo:" + this.f6750W.f6931e, f6727v);
            }
            Cursor cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2299s.f8209a, null, "inbox_no=?", new String[]{str}, null);
            if (cursorQuery == null) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("Failed to db query inboxNo:" + str, f6727v);
                }
                C5179v.m19810a(this.f6729B, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                return;
            }
            cursorQuery.moveToFirst();
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_session_id"));
            long j = cursorQuery.getLong(cursorQuery.getColumnIndex("lasst_session_merge_time"));
            int i = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_participants"));
            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_server_ip"));
            int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_server_port"));
            C1828q c1828q = this.f6735H;
            c1828q.getClass();
            C1832u c1832u2 = new C1832u(c1828q, string2, i2, string, i, j);
            cursorQuery.close();
            c1832u = c1832u2;
        } else {
            c1832u = c1832uM8968b;
        }
        m8879a(this.f6750W.f6931e, c1832u);
        if (!C2142w.m9613f(c1832u.f6950c) && !C2717y.m11398b()) {
            this.f6732E.mo9240a(this.f6750W.f6931e, EnumC2214ab.TEXT, EnumC2300t.m10207a(this.f6750W.f6932f), new String[]{this.f6750W.f6927a}, this.f6745R.getText().toString(), (String) null);
        } else {
            this.f6732E.mo9227a(EnumC2300t.m10207a(this.f6750W.f6932f), c1832u.f6950c);
            String[] strArr = new String[c1832u.f6952e];
            strArr[0] = this.f6750W.f6927a;
            this.f6732E.m9220a(EnumC2214ab.TEXT, EnumC2300t.m10207a(this.f6750W.f6932f), c1832u.f6950c, strArr, this.f6745R.getText().toString(), (String) null);
        }
        m8881f();
    }

    /* renamed from: a */
    protected void m8879a(String str, C1832u c1832u) {
        if (c1832u == null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("Can not find server inboxNo:" + str, f6727v);
            }
            C5179v.m19810a(this.f6729B, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
            m8882g();
            return;
        }
        if (this.f6732E == null) {
            this.f6732E = C2142w.m9593a(this.f6750W.f6931e, EnumC2300t.m10207a(this.f6750W.f6932f));
            this.f6732E.m9246a(this.f6775t);
            this.f6732E.mo9252a(str, c1832u.f6948a, c1832u.f6949b);
            this.f6732E.mo9243a(Long.MAX_VALUE);
            this.f6732E.mo9244a(c1832u.f6950c);
            this.f6732E.mo9266b(c1832u.f6951d);
        }
    }

    /* renamed from: n */
    protected void m8889n() {
        if (this.f6732E != null) {
            this.f6732E.m9267b(this.f6775t);
            this.f6732E.mo9243a(SystemClock.elapsedRealtime() + 300000);
            this.f6732E = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8835a(EnumC1809ap enumC1809ap) {
        if (enumC1809ap == EnumC1809ap.SHOW_LEFTRIGHT) {
            this.f6754aa.setVisibility(0);
            this.f6755ab.setVisibility(0);
        } else if (enumC1809ap == EnumC1809ap.SHOW_LEFT) {
            this.f6754aa.setVisibility(0);
            this.f6755ab.setVisibility(4);
        } else if (enumC1809ap == EnumC1809ap.SHOW_RIGHT) {
            this.f6755ab.setVisibility(0);
            this.f6754aa.setVisibility(4);
        } else {
            this.f6755ab.setVisibility(4);
            this.f6754aa.setVisibility(4);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C4904y.m18639b("onDestroy", f6727v);
        this.f6749V = 0;
        this.f6750W = null;
        if (this.f6766am != null) {
            C0991aa.m6037a().m18960b(this.f6766am);
        }
        if (this.f6768ao != null) {
            this.f6768ao.removeCallbacks(this.f6758ae);
        }
        this.f6730C.m8932a(false);
        this.f6735H.m8961a((InterfaceC1829r) null);
        this.f6747T = null;
        m8889n();
        if (this.f6762ai) {
            MultiWindow.createInstance(this).multiWindow();
        }
        if (this.f6767an != null) {
            unregisterReceiver(this.f6767an);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        C4904y.m18639b("onPause", f6727v);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        C4904y.m18639b("onstop", f6727v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m8869u() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && this.f6745R != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f6745R.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    @Override // com.sec.chaton.chat.notification.InterfaceC1829r
    /* renamed from: a */
    public void mo8876a() {
        if (C4904y.f17873c) {
            C4904y.m18641c("[messageDataChanged]", f6727v);
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            m8871v();
            return;
        }
        Message messageObtain = Message.obtain(this.f6768ao);
        messageObtain.what = 202;
        this.f6768ao.sendMessage(messageObtain);
    }

    @Override // com.sec.chaton.chat.notification.InterfaceC1829r
    /* renamed from: b */
    public void mo8880b(int i) throws Resources.NotFoundException {
        if (C4904y.f17873c) {
            C4904y.m18641c("[messageDeleted] unreadCount:" + this.f6763aj + " -> " + i, f6727v);
        }
        if (!this.f6764ak) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                m8842d(i);
                return;
            }
            Message messageObtain = Message.obtain(this.f6768ao);
            messageObtain.what = 201;
            messageObtain.arg1 = i;
            this.f6768ao.sendMessage(messageObtain);
        }
    }

    @Override // com.sec.chaton.chat.notification.InterfaceC1829r
    /* renamed from: a */
    public void mo8877a(int i) throws Resources.NotFoundException {
        if (C4904y.f17873c) {
            C4904y.m18641c("[newMessageInserted] unreadCount:" + this.f6763aj + " -> " + i, f6727v);
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            m8846e(i);
            return;
        }
        Message messageObtain = Message.obtain(this.f6768ao);
        messageObtain.what = 200;
        messageObtain.arg1 = i;
        this.f6768ao.sendMessage(messageObtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m8871v() {
        if (isFinishing()) {
            if (C4904y.f17873c) {
                C4904y.m18641c("Activity has been detroyed. Do not refresh view", f6727v);
            }
        } else if (this.f6747T != null) {
            this.f6747T.m617c();
            this.f6750W = this.f6735H.m8958a(this.f6749V);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m8842d(int i) throws Resources.NotFoundException {
        if (isFinishing()) {
            if (C4904y.f17873c) {
                C4904y.m18641c("Activity has been detroyed. Do not refresh view", f6727v);
            }
        } else {
            if (i == 0) {
                m8882g();
                return;
            }
            if (i - 1 < this.f6749V) {
                this.f6749V--;
            }
            if (this.f6747T != null) {
                this.f6763aj = i;
                this.f6747T.m617c();
                m8861q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m8846e(int i) throws Resources.NotFoundException {
        if (isFinishing()) {
            if (C4904y.f17873c) {
                C4904y.m18641c("Activity has been detroyed. Do not refresh view", f6727v);
                return;
            }
            return;
        }
        if (this.f6768ao != null) {
            this.f6768ao.removeCallbacks(this.f6758ae);
            if (!this.f6736I) {
                this.f6768ao.postDelayed(this.f6758ae, this.f6757ad);
            }
        }
        C1830s c1830sM8972d = this.f6735H.m8972d();
        if (TextUtils.isEmpty(this.f6750W.f6931e) || !this.f6736I || this.f6750W.f6931e.equals(c1830sM8972d.f6931e)) {
            this.f6749V = 0;
        } else if (this.f6749V + 1 <= i - 1) {
            this.f6749V++;
        }
        if (this.f6747T != null) {
            this.f6763aj = i;
            this.f6747T.m617c();
            m8861q();
        }
    }
}
