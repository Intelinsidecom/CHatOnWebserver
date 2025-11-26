package com.sec.chaton.chat.notification;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.sec.multiwindow.MultiWindow;
import android.sec.multiwindow.MultiWindowManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
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
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.R;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* loaded from: classes.dex */
public class ScreenNotification2 extends FragmentActivity implements View.OnClickListener {

    /* renamed from: d */
    private static final String f4381d = ScreenNotification2.class.getSimpleName();

    /* renamed from: A */
    private ViewPager f4382A;

    /* renamed from: B */
    private C1127w f4383B;

    /* renamed from: C */
    private LinearLayout f4384C;

    /* renamed from: E */
    private C1111g f4386E;

    /* renamed from: F */
    private ProgressBar f4387F;

    /* renamed from: G */
    private TextView f4388G;

    /* renamed from: H */
    private LinearLayout f4389H;

    /* renamed from: I */
    private ImageView f4390I;

    /* renamed from: J */
    private ImageView f4391J;

    /* renamed from: L */
    private Runnable f4393L;

    /* renamed from: N */
    private C1377u f4395N;

    /* renamed from: O */
    private boolean f4396O;

    /* renamed from: P */
    private boolean f4397P;

    /* renamed from: j */
    private Context f4409j;

    /* renamed from: l */
    private C3160ab f4411l;

    /* renamed from: n */
    private Toast f4413n;

    /* renamed from: o */
    private KeyguardManager f4414o;

    /* renamed from: p */
    private PowerManager f4415p;

    /* renamed from: s */
    private int f4418s;

    /* renamed from: t */
    private TextView f4419t;

    /* renamed from: u */
    private TextView f4420u;

    /* renamed from: v */
    private ImageButton f4421v;

    /* renamed from: w */
    private Button f4422w;

    /* renamed from: x */
    private Button f4423x;

    /* renamed from: y */
    private Button f4424y;

    /* renamed from: z */
    private EditText f4425z;

    /* renamed from: e */
    private final int f4404e = 99;

    /* renamed from: f */
    private final int f4405f = 10;

    /* renamed from: g */
    private final int f4406g = 11;

    /* renamed from: h */
    private final int f4407h = 100;

    /* renamed from: i */
    private final int f4408i = 101;

    /* renamed from: k */
    private C1103a f4410k = null;

    /* renamed from: m */
    private C1337o f4412m = null;

    /* renamed from: q */
    private boolean f4416q = false;

    /* renamed from: r */
    private boolean f4417r = false;

    /* renamed from: D */
    private int f4385D = 0;

    /* renamed from: K */
    private int f4392K = 5000;

    /* renamed from: M */
    private Handler f4394M = null;

    /* renamed from: a */
    String f4401a = null;

    /* renamed from: Q */
    private boolean f4398Q = false;

    /* renamed from: R */
    private BroadcastReceiver f4399R = null;

    /* renamed from: S */
    private ViewPager.OnPageChangeListener f4400S = new C1123s(this);

    /* renamed from: b */
    InterfaceC1378v f4402b = new C1124t(this);

    /* renamed from: c */
    protected Handler f4403c = new HandlerC1125u(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        int i;
        RunnableC1118n runnableC1118n = null;
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        if (C3250y.f11735c) {
            C3250y.m11453c("[onCreate]", f4381d);
        }
        this.f4409j = this;
        if (MultiWindowManager.isMultiWindowServiceEnabled(this.f4409j)) {
            MultiWindow multiWindowCreateInstance = MultiWindow.createInstance(this);
            if (multiWindowCreateInstance.isMultiWindow()) {
                multiWindowCreateInstance.normalWindow();
                this.f4398Q = true;
            }
        }
        getWindow().addFlags(2621440);
        this.f4413n = C3641ai.m13211a(this.f4409j, (CharSequence) null, 0);
        this.f4414o = (KeyguardManager) this.f4409j.getSystemService("keyguard");
        this.f4415p = (PowerManager) this.f4409j.getSystemService("power");
        this.f4395N = new C1377u(this.f4409j.getContentResolver(), this.f4402b);
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_popup_noti, (ViewGroup) null);
        requestWindowFeature(1);
        if (!C3171am.m11069h(this.f4409j) && (!this.f4415p.isScreenOn() || this.f4414o.inKeyguardRestrictedInputMode())) {
            getWindow().getDecorView().setBackgroundColor(-16777216);
            getClass();
            this.f4418s = 11;
        } else {
            getWindow().getDecorView().setBackgroundColor(0);
            if (C3171am.m11069h(this.f4409j)) {
                getClass();
                i = 11;
            } else {
                getClass();
                i = 10;
            }
            this.f4418s = i;
            this.f4394M = new Handler();
            this.f4393L = new RunnableC1118n(this);
            this.f4394M.postDelayed(this.f4393L, this.f4392K);
        }
        setContentView(viewInflate);
        if (this.f4410k == null) {
            this.f4410k = C1103a.m5432a(this.f4409j);
        }
        this.f4410k.m5459a(true);
        this.f4411l = C3159aa.m10962a();
        this.f4387F = (ProgressBar) viewInflate.findViewById(R.id.noti_progress);
        this.f4387F.setVisibility(8);
        this.f4419t = (TextView) viewInflate.findViewById(R.id.textSenderName);
        this.f4420u = (TextView) viewInflate.findViewById(R.id.textMsgCount);
        this.f4425z = (EditText) viewInflate.findViewById(R.id.noti_edit_chat);
        this.f4425z.setFocusable(true);
        this.f4425z.setFocusableInTouchMode(true);
        this.f4425z.setOnFocusChangeListener(new ViewOnFocusChangeListenerC1119o(this));
        this.f4425z.addTextChangedListener(new C1120p(this));
        this.f4425z.setOnClickListener(this);
        this.f4425z.setOnEditorActionListener(new C1121q(this));
        this.f4384C = (LinearLayout) findViewById(R.id.noti_chat);
        this.f4421v = (ImageButton) findViewById(R.id.noti_send_button);
        this.f4421v.setEnabled(false);
        this.f4421v.setOnClickListener(this);
        this.f4423x = (Button) findViewById(R.id.button2);
        this.f4423x.setText(R.string.close);
        this.f4423x.setOnClickListener(this);
        this.f4422w = (Button) findViewById(R.id.button3);
        this.f4422w.setText(R.string.dialog_view);
        this.f4422w.setOnClickListener(this);
        this.f4424y = (Button) findViewById(R.id.button1);
        this.f4424y.setOnClickListener(this);
        this.f4424y.setText(R.string.dialog_ok);
        this.f4424y.setVisibility(8);
        this.f4382A = (ViewPager) findViewById(R.id.pagerContents);
        this.f4383B = new C1127w(this, getSupportFragmentManager());
        this.f4382A.setAdapter(this.f4383B);
        this.f4382A.setOnPageChangeListener(this.f4400S);
        this.f4388G = (TextView) findViewById(R.id.errorContents);
        this.f4388G.setVisibility(8);
        this.f4382A.setVisibility(4);
        this.f4389H = (LinearLayout) findViewById(R.id.imageSettings);
        this.f4389H.setOnClickListener(this);
        this.f4390I = (ImageView) findViewById(R.id.leftArrow);
        this.f4390I.setVisibility(4);
        this.f4391J = (ImageView) findViewById(R.id.rightArrow);
        this.f4391J.setVisibility(4);
        getWindow().getDecorView().setOnTouchListener(new ViewOnTouchListenerC1122r(this));
        m5407i();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.f4399R = new C1128x(this, runnableC1118n);
        registerReceiver(this.f4399R, intentFilter);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C3250y.m11450b("onResume", f4381d);
        if (this.f4418s == 11) {
            if (this.f4396O && !this.f4397P) {
                this.f4397P = true;
            }
            if (!this.f4396O) {
                this.f4396O = true;
            }
        }
    }

    /* renamed from: h */
    private String m5405h() {
        String strM10979a = this.f4411l.m10979a("OFF", "OFF");
        if (Build.VERSION.SDK_INT >= 16 && strM10979a.equals("OFF")) {
            KeyguardManager keyguardManager = (KeyguardManager) this.f4409j.getSystemService("keyguard");
            if (C3250y.f11735c) {
                C3250y.m11453c("isLocked:" + keyguardManager.isKeyguardLocked() + ", isSecure:" + keyguardManager.isKeyguardSecure(), getClass().getSimpleName());
            }
            if (keyguardManager.isKeyguardLocked() && keyguardManager.isKeyguardSecure()) {
                return "ON";
            }
        }
        return strM10979a;
    }

    /* renamed from: i */
    private void m5407i() throws Resources.NotFoundException {
        this.f4416q = false;
        if (this.f4425z != null && (this.f4425z.hasFocus() || this.f4425z.getText().length() > 0)) {
            this.f4416q = true;
        }
        if (this.f4385D >= this.f4410k.f4463m) {
            if (C3250y.f11737e) {
                C3250y.m11442a("[EXCEPTION] current index is smaller than unread count. Finish pop-up. index:" + this.f4385D + ", count:" + this.f4410k.f4463m, f4381d);
            }
            m5424b();
            return;
        }
        this.f4401a = m5405h();
        StringBuilder sb = new StringBuilder();
        this.f4386E = this.f4410k.f4462l.get(this.f4385D);
        boolean zStartsWith = this.f4386E.f4498a.startsWith("0999");
        if (this.f4411l.m10977a("Setting show receive message", (Boolean) true).booleanValue() && this.f4401a.equals("OFF")) {
            if (this.f4410k.f4463m > 1) {
                m5395a(EnumC1129y.SHOW_RIGHT);
            }
            sb.append("** Information for current push popup **").append("\n");
            sb.append("> replyOn:" + this.f4416q).append("\n");
            sb.append("> currentIndex:" + this.f4385D).append("\n");
            sb.append("> current Inbox:" + this.f4386E.f4502e).append("\n");
            sb.append("> isUpdated:" + this.f4417r).append("\n");
            if (this.f4417r) {
                this.f4382A.setCurrentItem(this.f4385D, false);
                this.f4388G.setVisibility(8);
                this.f4382A.setVisibility(0);
                sb.append(">> update message, keep current page");
                if (C3250y.f11735c) {
                    C3250y.m11453c(sb.toString(), f4381d);
                    return;
                }
                return;
            }
            if (this.f4416q) {
                sb.append(">> replying on... ");
                sb.append("new message Inbox:" + this.f4410k.f4462l.get(0).f4502e).append("\n");
                if (this.f4386E.f4502e.equals(this.f4410k.f4462l.get(0).f4502e)) {
                    this.f4420u.setText("1/" + this.f4410k.f4463m);
                    this.f4382A.setCurrentItem(0, false);
                    this.f4385D = 0;
                    this.f4386E = this.f4410k.f4462l.get(this.f4385D);
                    sb.append(">>> new message from same inbox. set currentIndex to 0").append("\n");
                    if (C3250y.f11735c) {
                        sb.append(">>> sender:" + this.f4386E.f4499b + ", " + this.f4386E.f4498a);
                    }
                } else {
                    this.f4386E = this.f4410k.f4462l.get(this.f4385D);
                    this.f4420u.setText("" + this.f4385D + "/" + this.f4410k.f4463m);
                    this.f4382A.setCurrentItem(this.f4385D, false);
                    sb.append(">>> new message from different inbox. ").append("\n");
                    if (C3250y.f11735c) {
                        sb.append(">>> sender:" + this.f4386E.f4499b + ", " + this.f4386E.f4498a);
                    }
                }
            } else {
                sb.append(">> not replying on... ");
                this.f4385D = 0;
                this.f4386E = this.f4410k.f4462l.get(this.f4385D);
                this.f4419t.setText(this.f4386E.f4499b);
                this.f4420u.setText("1/" + m5409j());
                this.f4382A.setCurrentItem(0, false);
                sb.append("set currentIndex to 0").append("\n");
                if (C3250y.f11735c) {
                    C3250y.m11453c("extra text:" + m5392a(this.f4386E.f4500c), f4381d);
                    sb.append(">>> sender:" + this.f4386E.f4499b + ", " + this.f4386E.f4498a);
                }
            }
            if (C3250y.f11735c) {
                C3250y.m11453c(sb.toString(), f4381d);
            }
            if (zStartsWith) {
                this.f4384C.setVisibility(8);
            } else {
                this.f4384C.setVisibility(0);
            }
            this.f4388G.setVisibility(8);
            this.f4382A.setVisibility(0);
            return;
        }
        m5393a(101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public String m5409j() {
        if (this.f4410k.f4463m > 99) {
            return Integer.toString(99) + "+";
        }
        return Integer.toString(this.f4410k.f4463m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5393a(int i) throws Resources.NotFoundException {
        String string;
        this.f4419t.setText(this.f4409j.getResources().getString(R.string.app_name));
        this.f4420u.setVisibility(8);
        this.f4382A.setVisibility(8);
        this.f4384C.setVisibility(8);
        if (C3250y.f11735c) {
            C3250y.m11453c("[setSimpleInfo] type:" + i, f4381d);
        }
        m5395a(EnumC1129y.HIDE);
        if (i == 100) {
            this.f4388G.setText(this.f4409j.getResources().getString(R.string.auth_error_restart));
            this.f4388G.setVisibility(0);
            this.f4423x.setVisibility(8);
            this.f4422w.setVisibility(8);
            this.f4424y.setVisibility(0);
            return;
        }
        if (i == 101) {
            if (this.f4410k.f4463m > 1) {
                string = this.f4409j.getResources().getString(R.string.new_chaton_messages, Integer.valueOf(this.f4410k.f4463m));
            } else {
                string = this.f4409j.getResources().getString(R.string.new_1_message_dont_preview);
            }
            this.f4388G.setText(string);
            this.f4388G.setVisibility(0);
            this.f4423x.setVisibility(0);
            this.f4422w.setVisibility(0);
            this.f4424y.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) throws Resources.NotFoundException {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f4417r = intent.getBooleanExtra("isUpdated", false);
        if (C3250y.f11735c) {
            C3250y.m11453c("[onNewIntent]", f4381d);
        }
        if (this.f4394M != null) {
            this.f4394M.removeCallbacks(this.f4393L);
            if (!this.f4416q) {
                this.f4394M.postDelayed(this.f4393L, this.f4392K);
            }
        }
        if (this.f4383B != null) {
            this.f4383B.notifyDataSetChanged();
        }
        this.f4382A.setVisibility(4);
        if (!this.f4417r) {
            this.f4385D++;
        }
        m5407i();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1 /* 2131165901 */:
                GlobalApplication.m6454c(this.f4409j);
                break;
            case R.id.button2 /* 2131165902 */:
                m5424b();
                break;
            case R.id.button3 /* 2131165903 */:
                m5426d();
                break;
            case R.id.imageSettings /* 2131166143 */:
                m5411k();
                break;
            case R.id.noti_edit_chat /* 2131166149 */:
                m5425c();
                break;
            case R.id.noti_send_button /* 2131166150 */:
                m5427e();
                break;
        }
    }

    /* renamed from: a */
    protected void m5421a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_unread_count", (Integer) 0);
        this.f4395N.startUpdate(0, null, C1449q.f5381a, contentValues, "inbox_no='" + this.f4386E.f4502e + "'", null);
    }

    /* renamed from: b */
    protected void m5424b() {
        if (this.f4394M != null) {
            this.f4394M.removeCallbacks(this.f4393L);
        }
        this.f4410k.m5459a(false);
        m5415m();
        finish();
        overridePendingTransition(0, 0);
    }

    /* renamed from: k */
    private void m5411k() {
        Intent intentM1171a = IntentControllerActivity.m1171a(CommonApplication.m11493l(), true);
        intentM1171a.putExtra("callAlertSetting", true);
        startActivity(intentM1171a);
        m5424b();
    }

    /* renamed from: c */
    protected void m5425c() {
        GlobalApplication.f5513c = true;
        this.f4416q = true;
        if (this.f4394M != null) {
            this.f4394M.removeCallbacks(this.f4393L);
        }
    }

    /* renamed from: a */
    protected void m5422a(CharSequence charSequence) {
        if (charSequence.length() == 10000) {
            this.f4421v.setEnabled(true);
            C3641ai.m13210a(this.f4409j, R.string.toast_text_max_Length, 0).show();
        } else if (charSequence.toString().replaceAll(" ", "").replaceAll("\n", "").length() > 0 && !this.f4421v.isEnabled()) {
            this.f4421v.setEnabled(true);
        } else if (charSequence.toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
            this.f4421v.setEnabled(false);
        }
    }

    /* renamed from: d */
    protected void m5426d() {
        Intent intentM1171a;
        if (this.f4386E.f4503f == EnumC1450r.WEB_AUTH.m6342a()) {
            intentM1171a = IntentControllerActivity.m1171a((Context) this, true);
            intentM1171a.putExtra("inboxNO", this.f4386E.f4498a);
            intentM1171a.putExtra("chatType", this.f4386E.f4503f);
            intentM1171a.putExtra("fromPush", 1);
            intentM1171a.putExtra("Content", this.f4386E.f4500c);
        } else {
            intentM1171a = IntentControllerActivity.m1171a((Context) this, true);
            intentM1171a.putExtra("callChatList", true);
            intentM1171a.putExtra("inboxNO", this.f4386E.f4502e);
            intentM1171a.putExtra("chatType", this.f4386E.f4503f);
            intentM1171a.putExtra("fromPush", 1);
            intentM1171a.putExtra("disable", true);
            if (this.f4416q) {
                intentM1171a.putExtra(ChatFragment.f3494k, true);
            }
            intentM1171a.putExtra("buddyNO", this.f4386E.f4498a);
            if (this.f4425z != null && this.f4384C.getVisibility() == 0) {
                String string = this.f4425z.getText().toString();
                if (!TextUtils.isEmpty(string)) {
                    intentM1171a.putExtra("lastTempMessage", string);
                }
            }
        }
        startActivity(intentM1171a);
        m5424b();
    }

    /* renamed from: e */
    protected void m5427e() {
        if (this.f4425z.getText().toString().replaceAll(" ", "").replaceAll("\n", "").length() == 0) {
            this.f4425z.setText("");
            return;
        }
        int iM6733a = C1594v.m6733a(this.f4409j);
        if (!((-3 == iM6733a || -2 == iM6733a) ? false : true) && !C1757q.m7251b()) {
            this.f4413n.setText(R.string.popup_no_network_connection);
            this.f4413n.setDuration(0);
            this.f4413n.show();
            return;
        }
        if (!C3223ck.m11330d()) {
            this.f4413n.setText(R.string.popup_not_enough_memory);
            this.f4413n.setDuration(0);
            this.f4413n.show();
            return;
        }
        String str = this.f4386E.f4502e;
        C1113i c1113i = this.f4410k.f4460j.get(str);
        if (c1113i == null) {
            if (C3250y.f11735c) {
                C3250y.m11453c("Can not find server. Start DB query inboxNo:" + this.f4386E.f4502e, f4381d);
            }
            Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1449q.f5381a, null, "inbox_no=?", new String[]{str}, null);
            if (cursorQuery == null) {
                if (C3250y.f11735c) {
                    C3250y.m11453c("Failed to db query inboxNo:" + str, f4381d);
                }
                C3641ai.m13210a(this.f4409j, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                return;
            }
            cursorQuery.moveToFirst();
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_session_id"));
            long j = cursorQuery.getLong(cursorQuery.getColumnIndex("lasst_session_merge_time"));
            int i = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_participants"));
            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_server_ip"));
            int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_server_port"));
            C1103a c1103a = this.f4410k;
            c1103a.getClass();
            C1113i c1113i2 = new C1113i(c1103a, string2, i2, string, i, j);
            cursorQuery.close();
            c1113i = c1113i2;
        }
        m5423a(this.f4386E.f4502e, c1113i);
        if (!C1337o.m5816f(c1113i.f4520c) && !C1757q.m7251b()) {
            this.f4412m.m5861a(this.f4386E.f4502e, EnumC1455w.TEXT, EnumC1450r.m6339a(this.f4386E.f4503f), new String[]{this.f4386E.f4498a}, this.f4425z.getText().toString(), (String) null);
        } else {
            String[] strArr = new String[c1113i.f4522e];
            strArr[0] = this.f4386E.f4498a;
            this.f4412m.m5853a(EnumC1455w.TEXT, EnumC1450r.m6339a(this.f4386E.f4503f), c1113i.f4520c, strArr, this.f4425z.getText().toString(), (String) null);
        }
        m5421a();
        this.f4384C.setVisibility(8);
        this.f4387F.setVisibility(0);
        if (C1757q.m7251b()) {
            finish();
        }
    }

    /* renamed from: a */
    protected void m5423a(String str, C1113i c1113i) {
        m5428f();
        this.f4412m = C1337o.m5795a(this.f4386E.f4502e, EnumC1450r.m6339a(this.f4386E.f4503f));
        this.f4412m.m5874a(this.f4403c);
        this.f4412m.m5880a(str, c1113i.f4518a, c1113i.f4519b);
        this.f4412m.m5893c(Long.MAX_VALUE);
        this.f4412m.m5894c(c1113i.f4520c);
        this.f4412m.m5867a(c1113i.f4521d);
    }

    /* renamed from: f */
    protected void m5428f() {
        if (this.f4412m != null) {
            this.f4412m.m5888b(this.f4403c);
            this.f4412m.m5893c(SystemClock.elapsedRealtime() + 480000);
            this.f4412m = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public boolean m5412l() {
        return !this.f4425z.hasFocus() && this.f4425z.getText().length() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5395a(EnumC1129y enumC1129y) {
        if (enumC1129y == EnumC1129y.SHOW_LEFTRIGHT) {
            this.f4390I.setVisibility(0);
            this.f4391J.setVisibility(0);
        } else if (enumC1129y == EnumC1129y.SHOW_LEFT) {
            this.f4390I.setVisibility(0);
            this.f4391J.setVisibility(4);
        } else if (enumC1129y == EnumC1129y.SHOW_RIGHT) {
            this.f4391J.setVisibility(0);
            this.f4390I.setVisibility(4);
        } else {
            this.f4391J.setVisibility(4);
            this.f4390I.setVisibility(4);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        m5428f();
        this.f4385D = 0;
        this.f4386E = null;
        C3250y.m11450b("onDestroy", f4381d);
        if (this.f4398Q) {
            MultiWindow.createInstance(this).multiWindow();
        }
        if (this.f4399R != null) {
            unregisterReceiver(this.f4399R);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        C3250y.m11450b("onPause", f4381d);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        C3250y.m11450b("onstop", f4381d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m5415m() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && this.f4425z != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f4425z.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private String m5392a(String str) {
        int length = str.length();
        return str.substring(0, length <= 4 ? length : 4);
    }
}
