package com.sec.chaton;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.coolots.sso.p006a.C0045a;
import com.coolots.sso.p006a.InterfaceC0048d;
import com.renren.android.feed.FeedPublishRequestParam;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.buddy.AddBuddyActivity;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.InterfaceC0696fg;
import com.sec.chaton.buddy.InterfaceC0777ig;
import com.sec.chaton.buddy.SpecialBuddyActivity;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.dialog.ChatONVInstallDialog;
import com.sec.chaton.buddy.dialog.ChatONVRedirectDialog;
import com.sec.chaton.calllog.view.CallLogActivity;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.chat.EmptyChatFragment;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.event.C1464f;
import com.sec.chaton.event.EventDialog;
import com.sec.chaton.event.NewFeature;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.localbackup.ActivitySecretKey;
import com.sec.chaton.localbackup.noti.C1653a;
import com.sec.chaton.msgbox.InterfaceC1701ae;
import com.sec.chaton.msgbox.MsgboxFragment;
import com.sec.chaton.msgbox.MsgboxSelectionActivity;
import com.sec.chaton.multimedia.image.PostONImagePagerActivity;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.p027e.C1390ah;
import com.sec.chaton.p027e.C1404av;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p027e.p028a.C1362f;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p027e.p029b.C1414e;
import com.sec.chaton.p035io.entry.GetVersionNotice;
import com.sec.chaton.plugin.C1948a;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.registration.ActivityDisclaimer;
import com.sec.chaton.registration.ActivitySyncSignInPopup;
import com.sec.chaton.settings.ActivityGeneral;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.settings2.SettingActivity;
import com.sec.chaton.trunk.InterfaceC3039cm;
import com.sec.chaton.trunk.TrunkPageActivity;
import com.sec.chaton.trunk.TrunkView;
import com.sec.chaton.trunk.p061c.EnumC3026g;
import com.sec.chaton.userprofile.EditProfileActivity;
import com.sec.chaton.userprofile.InterfaceC3112bk;
import com.sec.chaton.userprofile.MyInfoActivity;
import com.sec.chaton.userprofile.MyPageFragment;
import com.sec.chaton.userprofile.ProfileImageHistoryActivity;
import com.sec.chaton.util.AsyncTaskC3251z;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3169ak;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3201bp;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.InterfaceC3204bs;
import com.sec.chaton.util.InterfaceC3226cn;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.spp.push.Config;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class TabActivity extends FlexibleActivity implements InterfaceC0696fg, InterfaceC0777ig, InterfaceC1701ae, InterfaceC3039cm, InterfaceC3112bk, InterfaceC3226cn {

    /* renamed from: B */
    private int f735B;

    /* renamed from: C */
    private int f736C;

    /* renamed from: D */
    private View f737D;

    /* renamed from: E */
    private View f738E;

    /* renamed from: F */
    private View f739F;

    /* renamed from: G */
    private View f740G;

    /* renamed from: H */
    private LinearLayout.LayoutParams f741H;

    /* renamed from: I */
    private LinearLayout.LayoutParams f742I;

    /* renamed from: J */
    private int f743J;

    /* renamed from: K */
    private int f744K;

    /* renamed from: L */
    private boolean f745L;

    /* renamed from: M */
    private boolean f746M;

    /* renamed from: N */
    private boolean f747N;

    /* renamed from: O */
    private boolean f748O;

    /* renamed from: P */
    private InterfaceC3274d f749P;

    /* renamed from: V */
    private ViewGroup f755V;

    /* renamed from: ab */
    private C3201bp f761ab;

    /* renamed from: aq */
    private C0812bv f776aq;

    /* renamed from: ar */
    private Fragment f777ar;

    /* renamed from: as */
    private int f778as;

    /* renamed from: h */
    private EnumC2947t f784h;

    /* renamed from: i */
    private InterfaceC3274d f785i;

    /* renamed from: j */
    private BroadcastReceiver f786j;

    /* renamed from: k */
    private BroadcastReceiver f787k;

    /* renamed from: l */
    private boolean f788l;

    /* renamed from: m */
    private boolean f789m;

    /* renamed from: n */
    private boolean f790n;

    /* renamed from: o */
    private boolean f791o;

    /* renamed from: p */
    private boolean f792p;

    /* renamed from: q */
    private int f793q;

    /* renamed from: r */
    private int f794r;

    /* renamed from: s */
    private int f795s;

    /* renamed from: t */
    private int f796t;

    /* renamed from: u */
    private int f797u;

    /* renamed from: v */
    private View f798v;

    /* renamed from: w */
    private ViewTreeObserver f799w;

    /* renamed from: x */
    private C1377u f800x;

    /* renamed from: y */
    private GetVersionNotice f801y;

    /* renamed from: f */
    private static final String f732f = TabActivity.class.getSimpleName();

    /* renamed from: g */
    private static final int f733g = 604045312;

    /* renamed from: a */
    public static final String f731a = "baseIntent";

    /* renamed from: z */
    private boolean f802z = false;

    /* renamed from: A */
    private boolean f734A = false;

    /* renamed from: Q */
    private ContentObserver f750Q = new C0435am(this, new Handler());

    /* renamed from: R */
    private ContentObserver f751R = new C0450ay(this, new Handler());

    /* renamed from: S */
    private ContentObserver f752S = new C0468bi(this, new Handler());

    /* renamed from: T */
    private InterfaceC1378v f753T = new C0504bp(this);

    /* renamed from: U */
    private BroadcastReceiver f754U = new C0505bq(this);

    /* renamed from: b */
    View.OnTouchListener f780b = new ViewOnTouchListenerC0506br(this);

    /* renamed from: W */
    private ViewTreeObserver.OnGlobalLayoutListener f756W = new ViewTreeObserverOnGlobalLayoutListenerC0507bs(this);

    /* renamed from: X */
    private BroadcastReceiver f757X = new C0508bt(this);

    /* renamed from: Y */
    private BroadcastReceiver f758Y = new C0509bu(this);

    /* renamed from: Z */
    private BroadcastReceiver f759Z = new C0436an(this);

    /* renamed from: aa */
    private BroadcastReceiver f760aa = new C0437ao(this);

    /* renamed from: ac */
    private InterfaceC3204bs f762ac = new C0438ap(this);

    /* renamed from: ad */
    private InterfaceC3204bs f763ad = new C0442aq(this);

    /* renamed from: ae */
    private InterfaceC3204bs f764ae = new C0443ar(this);

    /* renamed from: af */
    private InterfaceC3204bs f765af = new C0445at(this);

    /* renamed from: ag */
    private InterfaceC3204bs f766ag = new C0446au(this);

    /* renamed from: ah */
    private InterfaceC3204bs f767ah = new C0447av(this);

    /* renamed from: ai */
    private InterfaceC3204bs f768ai = new C0448aw(this);

    /* renamed from: aj */
    private InterfaceC3204bs f769aj = new C0449ax(this);

    /* renamed from: ak */
    private InterfaceC3204bs f770ak = new C0451az(this);

    /* renamed from: al */
    private InterfaceC3204bs f771al = new C0455ba(this);

    /* renamed from: am */
    private InterfaceC3204bs f772am = new C0461bb(this);

    /* renamed from: an */
    private InterfaceC3204bs f773an = new C0462bc(this);

    /* renamed from: ao */
    private InterfaceC3204bs f774ao = new C0463bd(this);

    /* renamed from: c */
    Handler f781c = new HandlerC0467bh(this, Looper.getMainLooper());

    /* renamed from: d */
    Handler f782d = new HandlerC0469bj(this, Looper.getMainLooper());

    /* renamed from: e */
    public Handler f783e = new HandlerC0470bk(this);

    /* renamed from: ap */
    private Handler f775ap = new HandlerC0471bl(this);

    /* renamed from: at */
    private InterfaceC0048d f779at = new C0502bn(this);

    /* renamed from: c */
    static /* synthetic */ int m1255c(TabActivity tabActivity, int i) {
        int i2 = tabActivity.f795s + i;
        tabActivity.f795s = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m1283l() {
        mo1151a().notifyDataSetChanged();
    }

    /* renamed from: m */
    private void m1285m() {
        if (this.f789m) {
            this.f789m = false;
            if (this.f792p) {
                this.f792p = false;
                this.f800x.startQuery(2, null, C1449q.f5381a, null, "inbox_unread_count > 0", null, null);
            }
            if (this.f790n) {
                this.f790n = false;
                this.f800x.startQuery(1, null, C1441i.f5369a, null, "buddy_is_new='Y' AND buddy_is_hide='N'", null, null);
            }
            if (this.f791o) {
                this.f791o = false;
                this.f800x.startQuery(3, null, C1390ah.f5188a, null, "isNew='Y'", null, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m1287n() {
        this.f796t = C3159aa.m10962a().m10978a("new_post_on_count", (Integer) 0).intValue();
        m1283l();
    }

    @Deprecated
    /* renamed from: a */
    public static Intent m1228a(Context context, boolean z) {
        Intent intentM1226a = m1226a(context);
        if (z) {
            intentM1226a.putExtra("callChatList", true);
        } else {
            intentM1226a.putExtra("callChatList", false);
        }
        return intentM1226a;
    }

    /* renamed from: a */
    public static Intent m1226a(Context context) {
        Intent intent = new Intent(context, (Class<?>) TabActivity.class);
        intent.setFlags(f733g);
        return intent;
    }

    /* renamed from: a */
    public static Intent m1227a(Context context, Intent intent) {
        Intent intentM1226a = m1226a(context);
        intentM1226a.putExtra(f731a, intent);
        return intentM1226a;
    }

    /* renamed from: a */
    private Fragment m1229a(int i, Class<? extends Fragment> cls) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(i);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (GlobalApplication.m6456e()) {
            this.f755V.addView(frameLayout);
        } else {
            ((ViewGroup) findViewById(android.R.id.content)).addView(frameLayout);
        }
        Fragment fragmentFindFragmentById = supportFragmentManager.findFragmentById(i);
        FragmentTransaction fragmentTransactionBeginTransaction = null;
        try {
            fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            if (fragmentFindFragmentById == null) {
                fragmentFindFragmentById = Fragment.instantiate(this, cls.getName());
                fragmentTransactionBeginTransaction.replace(i, fragmentFindFragmentById);
            }
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentById);
            return fragmentFindFragmentById;
        } finally {
            if (fragmentTransactionBeginTransaction != null) {
                fragmentTransactionBeginTransaction.commit();
            }
        }
    }

    /* renamed from: o */
    private void m1289o() {
        float f;
        float f2 = -1.0f;
        View viewFindViewById = findViewById(R.id.splitView);
        View viewFindViewById2 = findViewById(R.id.child_gradient);
        if ((GlobalApplication.m6457f() || m1252b((Context) this)) && this.f798v != null) {
            this.f736C = this.f798v.getWidth();
        } else {
            this.f736C = m1222O();
        }
        this.f735B = m1223P();
        this.f737D = findViewById(R.id.splitView_indicator);
        this.f738E = findViewById(R.id.splitView_indicator_default);
        this.f739F = findViewById(R.id.parent_fragment);
        this.f740G = findViewById(R.id.child_fragment);
        this.f741H = (LinearLayout.LayoutParams) this.f739F.getLayoutParams();
        this.f742I = (LinearLayout.LayoutParams) this.f740G.getLayoutParams();
        int i = getResources().getConfiguration().orientation;
        if (viewFindViewById != null) {
            this.f737D.setVisibility(8);
            viewFindViewById.setVisibility(0);
            viewFindViewById.setOnTouchListener(this.f780b);
            this.f738E.setOnTouchListener(this.f780b);
            this.f738E.setVisibility(8);
            View viewFindViewById3 = findViewById(R.id.child_fragment);
            viewFindViewById3.setVisibility(0);
            String str = "";
            if (this.f778as == R.id.fragment_buddy || this.f778as == R.id.fragment_msg_box) {
                viewFindViewById.setVisibility(0);
                viewFindViewById2.setVisibility(0);
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                if (this.f778as == R.id.fragment_buddy) {
                    ((BuddyFragment) supportFragmentManager.findFragmentById(this.f778as)).m3449n();
                    str = "splitview_position_buddy";
                } else if (this.f778as == R.id.fragment_msg_box) {
                    ((MsgboxFragment) supportFragmentManager.findFragmentById(this.f778as)).m7074e();
                    str = "splitview_position_chat";
                }
                if (str.equals("")) {
                    f = -1.0f;
                } else {
                    float fIntValue = C3159aa.m10962a().m10978a(str, (Integer) (-1)).intValue();
                    if (fIntValue == -1.0f) {
                        f = 0.25f;
                    } else {
                        f = fIntValue / 1000.0f;
                    }
                }
                int iRound = Math.round(this.f736C * f);
                this.f738E.setBackgroundResource(R.drawable.tablet_tw_preference_contents_list_no_arrow_left_split_default_holo_light);
                m1233a(f, iRound, this.f736C, false);
                return;
            }
            viewFindViewById.setVisibility(8);
            this.f738E.setVisibility(8);
            viewFindViewById2.setVisibility(8);
            if (this.f778as == R.id.fragment_user_profile) {
                if (i == 1) {
                    this.f755V.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
                    viewFindViewById3.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 0.0f));
                    return;
                }
                f2 = 0.623f;
            } else if (this.f778as == R.id.fragment_plus) {
                f2 = 1.0f;
            }
            this.f755V.setLayoutParams(new LinearLayout.LayoutParams(Math.round(this.f736C * f2), -1, 0.0f));
            viewFindViewById3.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        }
    }

    @Override // com.sec.chaton.FlexibleActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        Log.i("VerificationLog", "ChatON onCreate");
        C0456a.m3090a(this, bundle);
        if (GlobalApplication.m6456e() && GlobalApplication.m6457f()) {
            this.f798v = getWindow().getDecorView();
        }
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (GlobalApplication.m6456e()) {
            ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
            View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_viewpager, viewGroup, false);
            viewGroup.addView(viewInflate);
            this.f755V = (ViewGroup) viewInflate.findViewById(R.id.parent_fragment);
            m1289o();
        }
        m1229a(R.id.fragment_buddy, BuddyFragment.class);
        m1229a(R.id.fragment_msg_box, MsgboxFragment.class);
        m1229a(R.id.fragment_user_profile, MyPageFragment.class);
        m1229a(R.id.fragment_plus, PlusFragment.class);
        getSupportFragmentManager().executePendingTransactions();
        if (!C3223ck.m11330d()) {
            if (C3250y.f11736d) {
                C3250y.m11455d("There isn't enough memory for executing ChatON.", f732f);
            }
            Toast.makeText(CommonApplication.m11493l(), R.string.popup_not_enough_memory, 0).show();
            finish();
            return;
        }
        if (m1199C()) {
            if (C3250y.f11735c) {
                C3250y.m11453c("HomeActivity is requested finish.", f732f);
            }
            finish();
            return;
        }
        if (C0816a.f3115d) {
            if (C3250y.f11734b) {
                C3250y.m11450b("Welcome, First Time after update ChatON.", f732f);
            }
            C3171am.m11081s();
            m1293q();
            C3159aa.m10966a("chaton_version", C0816a.f3112a);
            C0816a.f3115d = false;
            C3159aa.m10962a().m10983b("buddy_get_all_buddy_mode_instance", (Boolean) true);
            C3159aa.m10962a().m10983b("restore_livepartner_user_list", (Boolean) true);
        }
        if (m1311z()) {
            C3241p.m11403b(true);
            return;
        }
        if (!m1309y()) {
            finish();
            startActivity(HomeActivity.m1157a((Context) this));
            return;
        }
        m1305w();
        m1302v();
        m1202E();
        if (bundle == null) {
            Intent intent2 = (Intent) intent.getParcelableExtra(f731a);
            if (intent2 == null) {
                intent2 = intent;
            }
            m1234a(intent2);
        }
        if (this.f784h == EnumC2947t.HOME && C1464f.m6395c()) {
            startActivity(new Intent(this, (Class<?>) EventDialog.class));
        }
        C3159aa.m10963a("enteredtab", (Boolean) true);
        int iIntValue = C3159aa.m10962a().m10978a("new_feature_count", (Integer) 0).intValue();
        String strM10979a = C3159aa.m10962a().m10979a("new_feature_url_list", "");
        Intent intent3 = new Intent(GlobalApplication.m11493l(), (Class<?>) NewFeature.class);
        if (!TextUtils.isEmpty(strM10979a) && iIntValue > 0) {
            startActivity(intent3);
        }
        m1300u();
        if (C3159aa.m10962a().m10977a("first_time_after_regi", (Boolean) false).booleanValue()) {
            m1295r();
            if (C1493a.m6463a("local_backup_feature")) {
                m1297s();
            }
        }
        C3250y.m11450b("onCreate : set setShowPasswordLock value", f732f);
        if (getIntent().getBooleanExtra("extra_from_chaton", false)) {
            C3241p.m11403b(false);
        } else if (bundle != null && C3241p.m11399a()) {
            C3250y.m11450b("savedInstanceState" + bundle, f732f);
        } else {
            C3241p.m11403b(true);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("password_lock_finish");
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f760aa, intentFilter);
        if (C1493a.m6463a("wifi_80_port")) {
            C3159aa.m10962a().m10984b(Config.PROVIDER_PATH_WIFI_PORT, Integer.valueOf(C3194bi.m11150d()));
        }
        this.f789m = true;
        this.f792p = true;
        this.f790n = true;
        this.f791o = true;
        this.f800x = new C1377u(getContentResolver(), this.f753T);
        getContentResolver().registerContentObserver(C1449q.f5381a, true, this.f752S);
        getContentResolver().registerContentObserver(C1441i.f5369a, true, this.f750Q);
        getContentResolver().registerContentObserver(C1390ah.f5188a, true, this.f751R);
        if (GlobalApplication.m6456e() && GlobalApplication.m6457f() && this.f798v != null) {
            m1291p();
            this.f743J = this.f798v.getHeight();
            this.f744K = this.f798v.getWidth();
        }
    }

    /* renamed from: b */
    public static boolean m1252b(Context context) {
        if (context == null) {
            return false;
        }
        View decorView = ((Activity) context).getWindow().getDecorView();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return (displayMetrics.heightPixels == decorView.getMeasuredHeight() && decorView.getMeasuredWidth() == displayMetrics.widthPixels) ? false : true;
    }

    /* renamed from: p */
    private void m1291p() {
        this.f799w = this.f798v.getViewTreeObserver();
        this.f799w.addOnGlobalLayoutListener(this.f756W);
    }

    /* renamed from: q */
    private void m1293q() {
        try {
            Cursor cursorRawQuery = C1404av.m6253a(CommonApplication.m11493l()).getReadableDatabase().rawQuery("SELECT g._id, group_name, group_relation_buddy FROM buddy_group g left outer join grouprelation r on g._id = r.group_relation_group order by g._id", null);
            if (cursorRawQuery != null && cursorRawQuery.getCount() != 0) {
                cursorRawQuery.moveToPosition(-1);
                while (cursorRawQuery.moveToNext()) {
                    String string = cursorRawQuery.getString(0);
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("group_name"));
                    String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("group_relation_buddy"));
                    if (!string2.equals("Favorites") && string3 == null) {
                        C1362f.m6069b(GlobalApplication.m11493l().getContentResolver(), string);
                        C3250y.m11453c("remove garbage group " + string + ", name : " + string2, getClass().getSimpleName());
                    }
                }
            }
        } catch (Exception e) {
            C3250y.m11450b(e.getMessage(), getClass().getSimpleName());
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        C3250y.m11453c("[LIFE] onStart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m1298t(), f732f);
        if (m1311z()) {
            String strM10979a = C3159aa.m10962a().m10979a("UpdateAppsReady", "NO");
            Intent intent = new Intent(this, (Class<?>) UpgradeDialog.class);
            intent.putExtra("isCritical", true);
            intent.setFlags(67108864);
            intent.putExtra("isReadyApps", strM10979a);
            startActivity(intent);
            new C1324bj(this.f781c).m5694b();
            return;
        }
        if (m1204F().equals("RUN")) {
            m1242a(m1197B());
        } else if (m1217L()) {
            m1251b(true);
        } else if (this.f761ab != null) {
            this.f761ab.m11163a();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        Log.i("VerificationLog", "ChatON onResume");
        this.f788l = false;
        C3250y.m11453c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m1298t(), f732f);
        if (!C3223ck.m11330d()) {
            if (C3250y.f11736d) {
                C3250y.m11455d("There isn't enough memory for executing ChatON.", f732f);
            }
            Toast.makeText(CommonApplication.m11493l(), R.string.popup_not_enough_memory, 0).show();
            finish();
            return;
        }
        m1209H();
        m1285m();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("mypage_badge_update");
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f754U, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("more_tab_badge_update");
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f758Y, intentFilter2);
        IntentFilter intentFilter3 = new IntentFilter();
        intentFilter3.addAction("new_feature_update");
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f759Z, intentFilter3);
        IntentFilter intentFilter4 = new IntentFilter();
        intentFilter4.addAction("buddy_tab_badge_update");
        intentFilter4.addAction("buddy_tab_name_update");
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f757X, intentFilter4);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f788l = true;
        C3250y.m11453c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m1298t(), f732f);
        try {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f754U);
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f758Y);
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f759Z);
        } catch (IllegalArgumentException e) {
            Log.e(f732f, "in ONPause .receiver not registered properly");
        }
    }

    @Override // com.sec.chaton.FlexibleActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.f777ar = null;
        super.onDestroy();
        C3250y.m11453c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m1298t(), f732f);
        if (this.f749P != null && this.f749P.isShowing()) {
            this.f749P.dismiss();
        }
        try {
            C3214cb.m11268d(this);
            if (this.f786j != null) {
                LocalBroadcastManager.getInstance(CommonApplication.m11493l()).unregisterReceiver(this.f786j);
                this.f786j = null;
            }
            if (this.f787k != null) {
                unregisterReceiver(this.f787k);
                this.f787k = null;
            }
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f760aa);
            LocalBroadcastManager.getInstance(CommonApplication.m11493l()).unregisterReceiver(this.f757X);
        } catch (IllegalArgumentException e) {
            Log.e(f732f, "receiver not registered properly");
        }
        if (this.f785i != null && this.f785i.isShowing()) {
            this.f785i.dismiss();
        }
        this.f802z = true;
        getContentResolver().unregisterContentObserver(this.f752S);
        getContentResolver().unregisterContentObserver(this.f750Q);
        getContentResolver().unregisterContentObserver(this.f751R);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C3250y.m11453c("[LIFE] onNewIntent, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m1298t(), f732f);
        setIntent(intent);
        if (m1199C()) {
            finish();
            return;
        }
        if (m1195A()) {
            finish();
            startActivity(m1226a((Context) this));
            return;
        }
        Intent intent2 = (Intent) intent.getParcelableExtra(f731a);
        if (intent2 != null) {
            intent = intent2;
        }
        m1234a(intent);
        if (C3241p.m11406c()) {
            C3241p.m11403b(true);
        }
    }

    /* renamed from: r */
    private void m1295r() {
        Intent intent = new Intent(this, (Class<?>) ActivitySyncSignInPopup.class);
        intent.setFlags(67108864);
        if (!C3171am.m11080r()) {
            intent.putExtra("isSyncContacts", true);
            startActivity(intent);
            if (C3250y.f11734b) {
                C3250y.m11450b("SA was NOT registered", f732f);
            }
        }
        C3159aa.m10962a().m10981a("first_time_after_regi");
    }

    /* renamed from: s */
    private void m1297s() throws Resources.NotFoundException {
        Context contextM11493l = CommonApplication.m11493l();
        String string = contextM11493l.getResources().getString(R.string.auto_backup_setting_notification);
        String string2 = contextM11493l.getResources().getString(R.string.backup);
        C3169ak c3169akM11035a = C3169ak.m11035a();
        c3169akM11035a.m11038a(string2);
        c3169akM11035a.m11040b(C2310s.f8624h);
        c3169akM11035a.m11037a(contextM11493l, string, C3169ak.f11485f, C3169ak.f11482c);
    }

    /* renamed from: a */
    private void m1234a(Intent intent) {
        EnumC2947t enumC2947tM8680a = C2310s.m8680a(intent, this);
        this.f784h = enumC2947tM8680a;
        switch (C0503bo.f1641a[enumC2947tM8680a.ordinal()]) {
            case 1:
                m1249b(intent);
                break;
            case 2:
                m1257c(intent);
                break;
            case 4:
                m11543k().mo11592d(1);
                break;
            case 5:
                m11543k().mo11592d(2);
                break;
            case 6:
                startActivity(new Intent(this, (Class<?>) ChatONVInstallDialog.class));
                break;
            case 7:
                m11543k().mo11592d(3);
                Intent intent2 = new Intent(this, (Class<?>) SettingActivity.class);
                intent2.putExtra("gotoAlert", true);
                startActivity(intent2);
                break;
            case 8:
            case 9:
            case 10:
            case 11:
                m1241a(enumC2947tM8680a, intent);
                break;
            case 12:
                intent.setClass(this, AddBuddyActivity.class);
                intent.setFlags(67108864);
                startActivity(intent);
                break;
            case 13:
                String string = intent.getExtras().getString("PROFILE_BUDDY_NO");
                if (C1357af.m5991a(string)) {
                    intent.putExtra("specialuserid", string);
                    intent.setClass(this, SpecialBuddyActivity.class);
                } else {
                    intent.setClass(this, BuddyProfileActivity.class);
                }
                intent.setFlags(67108864);
                startActivity(intent);
                break;
            case 14:
                if (C1493a.m6463a("local_backup_feature") && intent != null && intent.getBooleanExtra(C3169ak.f11485f, false)) {
                    Intent intent3 = new Intent(CommonApplication.m11493l(), (Class<?>) ActivitySecretKey.class);
                    intent3.putExtra("password_mode", true);
                    startActivityForResult(intent3, 2);
                    C3169ak.m11035a().m11036a(CommonApplication.m11493l(), C3169ak.f11482c);
                    break;
                }
                break;
        }
    }

    /* renamed from: a */
    private void m1241a(EnumC2947t enumC2947t, Intent intent) {
        if (C1948a.m7903a(this)) {
            if (m1212J()) {
                if (m1210I()) {
                    if (!getSharedPreferences("PASSWORD_LOCK", 0).getString("LOCK_STATE", C3241p.m11409e()).equals(C3241p.m11408d())) {
                        if (C3250y.f11734b) {
                            C3250y.m11450b("psswordLock was enabled", f732f);
                        }
                        m1250b(enumC2947t, intent);
                        return;
                    }
                    if (C3250y.f11734b) {
                        C3250y.m11450b("showPasswordLockActivity for Result", f732f);
                    }
                    C3241p.m11403b(true);
                    Context applicationContext = getApplicationContext();
                    if (C3241p.m11407c(applicationContext)) {
                        intent.setClass(applicationContext, ActivityPasswordLockSet.class);
                        intent.setFlags(67108864);
                        intent.putExtra("requestMode", enumC2947t);
                        intent.putExtra("MODE", "HOME");
                        startActivityForResult(intent, 5);
                        return;
                    }
                    return;
                }
                startActivity(new Intent(this, (Class<?>) ChatONVInstallDialog.class));
                return;
            }
            if (!m1214K()) {
                startActivity(new Intent(this, (Class<?>) ChatONVRedirectDialog.class));
            }
        }
    }

    /* renamed from: t */
    private String m1298t() {
        String str = getIntent().getAction() != null ? ", Intent Action: " + getIntent().getAction() : ", Intent Action: Null";
        if (getIntent().getCategories() != null) {
            return str + ", Intent Category: " + getIntent().getCategories().toString();
        }
        return str + ", Intent Category: Null";
    }

    public class SendCrashLogFragment extends Fragment {

        /* renamed from: a */
        public static final String f803a = SendCrashLogFragment.class.getSimpleName();

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            new AsyncTaskC3251z().execute(new Void[0]);
        }
    }

    /* renamed from: u */
    private void m1300u() {
        C3250y.m11453c("[LIFE] initView, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m1298t(), f732f);
        if (ExitAppDialogActivity.m1139a()) {
            startActivity(new Intent(this, (Class<?>) ExitAppDialogActivity.class));
        }
    }

    /* renamed from: v */
    private void m1302v() {
        this.f761ab = new C3201bp();
        this.f761ab.m11164a("get_chaton_crypto_key", this.f771al, 60000L, "last_sync_time_get_chaton_crypto_key");
        this.f761ab.m11164a("local_calculation", this.f762ac, 60000L, "last_sync_time_on_start");
        this.f761ab.m11164a("get_push_status", this.f764ae, 60000L, "last_sync_time_get_push_status");
        this.f761ab.m11164a("version_notice", this.f767ah, 21600000L, "last_sync_time_get_version_notice");
        if (C3214cb.m11246a("com.sec.spp.push") < 21) {
            this.f761ab.m11164a("spp_update_check", this.f768ai, 259200000L, "last_sync_time_get_spp_update_check");
        } else {
            if (C3250y.f11734b) {
                C3250y.m11450b("don't need to add poliing scheduler for SPP", f732f);
            }
            m1306x();
        }
        this.f761ab.m11164a("notification", this.f766ag, 1800000L, "last_sync_time_notification");
        this.f761ab.m11164a("get_all_buddies", this.f763ad, 10800000L, "last_sync_time_get_all_buddies");
        this.f761ab.m11164a("recommendee_sync", this.f769aj, 86400000L, "last_recommendee_sync_time1");
        this.f761ab.m11164a("more_app_sync", this.f770ak, 86400000L, "last_more_app_sync_time");
        if (C1493a.m6463a("chatonv_feature")) {
            this.f761ab.m11164a("chatonv_available", this.f774ao, 86400000L, "last_chatonv_available_time");
        }
        this.f761ab.m11164a("chatonv_update_check", this.f772am, 86400000L, "last_chatonv_upgrade_check");
        this.f761ab.m11164a("set_compatibility", this.f773an, 900000L, "last_compatibility_time");
    }

    /* renamed from: w */
    private void m1305w() {
        if (this.f786j == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.sec.chaton.ACTION_EXIT_APP");
            this.f786j = new C0464be(this);
            LocalBroadcastManager.getInstance(CommonApplication.m11493l()).registerReceiver(this.f786j, intentFilter);
        }
    }

    /* renamed from: x */
    private void m1306x() {
        if (this.f787k == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action_noti_spp_update");
            this.f787k = new C0465bf(this);
            registerReceiver(this.f787k, intentFilter);
        }
    }

    /* renamed from: y */
    private boolean m1309y() {
        return C3159aa.m10962a().m10987b("uid");
    }

    /* renamed from: z */
    private boolean m1311z() {
        return C3159aa.m10962a().m10977a("UpdateIsCritical", (Boolean) false).booleanValue();
    }

    /* renamed from: A */
    private boolean m1195A() {
        return getIntent().getBooleanExtra("callRestart", false);
    }

    /* renamed from: B */
    private String m1197B() {
        return C3159aa.m10962a().m10979a("disclaimer_UID", "");
    }

    /* renamed from: C */
    private boolean m1199C() {
        Intent intent = getIntent();
        return intent.getBooleanExtra("finish", false) && (intent.getFlags() & FeedPublishRequestParam.MESSAGE_TOO_LONG) != 1048576;
    }

    /* renamed from: b */
    private void m1249b(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("callChatList", false);
        if (C3250y.f11735c) {
            C3250y.m11453c("Shortcut or Notification: " + booleanExtra, f732f);
        }
        if (booleanExtra) {
            boolean booleanExtra2 = intent.getBooleanExtra("specialbuddy", false);
            if (GlobalApplication.m6456e() && !booleanExtra2) {
                this.f734A = true;
                m11543k().mo11592d(1);
                m1312a(R.id.fragment_msg_box, intent, ChatFragment.class);
                return;
            } else {
                intent.putExtra("callChatList", false);
                intent.setClass(this, ChatActivity.class);
                intent.setFlags(67108864);
                startActivity(intent);
                return;
            }
        }
        if (EnumC1450r.m6339a(intent.getIntExtra("chatType", -1)) == EnumC1450r.WEB_AUTH) {
            C1103a.m5432a(this).m5460b();
            AbstractC3271a.m11494a(this).mo11495a(R.string.app_name).mo11509b(intent.getStringExtra("Content")).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0466bg(this)).mo11505a().show();
        }
    }

    /* renamed from: c */
    private void m1257c(Intent intent) {
        if (C3250y.f11735c) {
            C3250y.m11453c("Shortcut or Notification: " + intent.getBooleanExtra("callChatList", false), f732f);
        }
        if (intent.getBooleanExtra("callForward", false)) {
            intent.putExtra("callForward", false);
            intent.setClass(this, ChatForwardActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public boolean m1201D() {
        Context applicationContext = getApplicationContext();
        if (!m1321c(applicationContext).equals("com.sec.chaton.settings.ActivityPasswordLockSet")) {
            return false;
        }
        C3250y.m11450b("getClassName : " + m1321c(applicationContext), f732f);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1242a(String str) {
        if (!C3171am.m11080r()) {
            C3250y.m11450b("showDisclaimer", f732f);
            C3159aa.m10966a("update_disclaimer_status", "RUN");
            C3171am.m11050a("agree_disclaimer", (Object) false);
            C3159aa.m10966a("disclaimer_ID", str);
            Intent intent = new Intent(this, (Class<?>) ActivityDisclaimer.class);
            intent.putExtra("disclaimerUID", str);
            intent.setFlags(131072);
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void m1202E() {
        if (C3250y.f11734b) {
            C3250y.m11450b("initializeUpdateFactor", f732f);
        }
        this.f745L = false;
        this.f746M = false;
        this.f747N = false;
        this.f748O = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public String m1204F() {
        return C3159aa.m10962a().m10979a("update_disclaimer_status", "");
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 2:
                if (i2 == -1) {
                    C1653a.m6926a(GlobalApplication.m11493l(), false);
                    C3159aa.m10963a("setting_backup_enable", (Boolean) true);
                    break;
                } else if (i2 == 0) {
                    C3159aa.m10963a("auto_backup_on", (Boolean) false);
                    break;
                }
                break;
            case 4:
                if (GlobalApplication.m6456e() && i2 == -1) {
                    m1312a(R.id.fragment_msg_box, new Intent(), EmptyChatFragment.class);
                    if (this.f778as == R.id.fragment_msg_box) {
                        ((MsgboxFragment) getSupportFragmentManager().findFragmentById(this.f778as)).m7075f();
                        break;
                    }
                }
                break;
            case 5:
                EnumC2947t enumC2947t = null;
                if (intent != null) {
                    enumC2947t = (EnumC2947t) intent.getExtras().get("requestMode");
                }
                if (enumC2947t != null) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("REQ_CODE_DIRECT_CHATONV_CALL, mode : " + enumC2947t, f732f);
                    }
                    m1250b(enumC2947t, intent);
                    break;
                }
                break;
        }
    }

    /* renamed from: b */
    private void m1250b(EnumC2947t enumC2947t, Intent intent) {
        if (m1259c(enumC2947t, intent)) {
            Toast.makeText(CommonApplication.m11493l(), R.string.shortcut_buddy_blocked_or_notfound, 0).show();
        }
        switch (C0503bo.f1641a[enumC2947t.ordinal()]) {
            case 8:
                new C0045a().m47a(this, false, intent.getStringExtra("chatonno"), C3159aa.m10962a().m10979a("Push Name", ""), null);
                break;
            case 9:
                new C0045a().m47a(this, true, intent.getStringExtra("chatonno"), C3159aa.m10962a().m10979a("Push Name", ""), null);
                break;
            case 10:
                String[] stringArrayExtra = intent.getStringArrayExtra("chatonno");
                if (stringArrayExtra == null && intent.getStringExtra("groupId") != null) {
                    stringArrayExtra = (String[]) C1362f.m6060a(CommonApplication.m11493l().getContentResolver(), Integer.parseInt(intent.getStringExtra("groupId"))).toArray(new String[0]);
                }
                if (stringArrayExtra != null && stringArrayExtra.length == 1) {
                    new C0045a().m47a(this, false, stringArrayExtra[0], C3159aa.m10962a().m10979a("Push Name", ""), null);
                    break;
                } else {
                    new C0045a().m48a(this, false, stringArrayExtra, C3159aa.m10962a().m10979a("Push Name", ""), null, null);
                    break;
                }
                break;
            case 11:
                String[] stringArrayExtra2 = intent.getStringArrayExtra("chatonno");
                if (stringArrayExtra2 == null && intent.getStringExtra("groupId") != null) {
                    stringArrayExtra2 = (String[]) C1362f.m6060a(CommonApplication.m11493l().getContentResolver(), Integer.parseInt(intent.getStringExtra("groupId"))).toArray(new String[0]);
                }
                if (stringArrayExtra2 != null && stringArrayExtra2.length == 1) {
                    new C0045a().m47a(this, true, stringArrayExtra2[0], C3159aa.m10962a().m10979a("Push Name", ""), null);
                    break;
                } else {
                    new C0045a().m48a(this, true, stringArrayExtra2, C3159aa.m10962a().m10979a("Push Name", ""), null, null);
                    break;
                }
                break;
        }
    }

    /* renamed from: c */
    private boolean m1259c(EnumC2947t enumC2947t, Intent intent) {
        switch (C0503bo.f1641a[enumC2947t.ordinal()]) {
            case 8:
            case 9:
                if (!C1360d.m6054h(CommonApplication.m11493l().getContentResolver(), intent.getStringExtra("chatonno"))) {
                    break;
                }
                break;
            case 10:
            case 11:
                String[] stringArrayExtra = intent.getStringArrayExtra("chatonno");
                if (stringArrayExtra == null && intent.getStringExtra("groupId") != null) {
                    stringArrayExtra = (String[]) C1362f.m6060a(CommonApplication.m11493l().getContentResolver(), Integer.parseInt(intent.getStringExtra("groupId"))).toArray(new String[0]);
                }
                for (String str : stringArrayExtra) {
                    if (!C1360d.m6054h(CommonApplication.m11493l().getContentResolver(), str)) {
                        break;
                    }
                }
                break;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public void m1206G() {
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(new Intent("com.sec.chaton.ACTION_DISMISS"));
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(new Intent("more_tab_badge_update"));
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C3250y.m11450b("onUserLeaveHint", f732f);
        C3241p.m11402b(getApplicationContext());
    }

    /* renamed from: c */
    public String m1321c(Context context) {
        String className = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getClassName();
        C3250y.m11450b("getClassName : " + className, "HomeActivity");
        return className;
    }

    /* renamed from: H */
    private void m1209H() {
        C3250y.m11450b("showPasswordLockActivity", f732f);
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            intent.setFlags(67108864);
            startActivity(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        BuddyFragment buddyFragment = (BuddyFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_buddy);
        if (buddyFragment != null) {
            C3250y.m11450b("dispatchKeyEvent : KeyCode = " + keyEvent.getKeyCode(), f732f);
            C3250y.m11450b("dispatchKeyEvent : Current Tab ID = " + this.f778as, f732f);
            if (keyEvent.getKeyCode() == 84) {
                if (this.f778as == 0) {
                    buddyFragment.m3446k();
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return super.onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportPrepareOptionsMenu(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_chat);
        menu.findItem(R.id.menu_settings);
        if (menuItemFindItem != null) {
            if (BuddyFragment.f1733l && this.f778as == R.id.fragment_buddy) {
                menuItemFindItem.setVisible(false);
            } else {
                menuItemFindItem.setVisible(true);
            }
        }
        return super.onSupportPrepareOptionsMenu(menu);
    }

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        super.onSupportOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case R.id.menu_chat /* 2131166559 */:
                if (this.f749P != null && this.f749P.isShowing()) {
                    break;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(GlobalApplication.m6451b().getString(R.string.menu_button_start_chat));
                    arrayList.add(GlobalApplication.m6451b().getString(R.string.menu_inbox_broadcast));
                    if (C1948a.m7903a(GlobalApplication.m11493l())) {
                        arrayList.add(GlobalApplication.m6451b().getString(R.string.menu_voice_call));
                        arrayList.add(GlobalApplication.m6451b().getString(R.string.menu_video_call));
                    }
                    CharSequence[] charSequenceArr = (CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]);
                    AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this);
                    abstractC3271aM11494a.mo11500a(GlobalApplication.m6451b().getString(R.string.select_chat_type));
                    abstractC3271aM11494a.mo11504a(charSequenceArr, new DialogInterfaceOnClickListenerC0501bm(this));
                    this.f749P = abstractC3271aM11494a.mo11512b();
                    this.f749P.setCanceledOnTouchOutside(true);
                    break;
                }
                break;
            case R.id.menu_settings /* 2131166560 */:
                startActivity(new Intent(this, (Class<?>) SettingActivity.class));
                break;
            case R.id.menu_support /* 2131166561 */:
                startActivity(new Intent(this, (Class<?>) ActivityGeneral.class));
                break;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public boolean m1210I() {
        boolean zM55d;
        Exception e;
        try {
            zM55d = new C0045a().m55d(getApplicationContext());
            try {
                C3250y.m11450b("[ChatONV] isReadyToCall : " + zM55d, f732f);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                C3250y.m11450b("[ChatONV] isChatONVReadyToCall : " + zM55d, f732f);
                return zM55d;
            }
        } catch (Exception e3) {
            zM55d = false;
            e = e3;
        }
        C3250y.m11450b("[ChatONV] isChatONVReadyToCall : " + zM55d, f732f);
        return zM55d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public boolean m1212J() {
        boolean z = false;
        try {
            if (C1954g.m7916a().m7918a(getApplicationContext(), EnumC1955h.ChatONV)) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3250y.m11450b("[ChatONV] isChatONVAvaiable : " + z, f732f);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public boolean m1214K() {
        boolean z = false;
        new C0045a();
        try {
            if (C0045a.m37b(getApplicationContext())) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3250y.m11450b("[ChatONV] isChatONVInstalled : " + z, f732f);
        return z;
    }

    @Override // com.sec.chaton.FlexibleActivity
    /* renamed from: a */
    protected BaseAdapter mo1151a() {
        if (this.f776aq == null) {
            this.f776aq = new C0812bv(this, null);
        }
        return this.f776aq;
    }

    @Override // com.sec.chaton.FlexibleActivity
    /* renamed from: a */
    protected void mo1152a(int i) {
        Fragment fragmentFindFragmentById;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragmentFindFragmentById2 = null;
        if (this.f777ar != null) {
            if (this.f777ar instanceof InterfaceC0813bw) {
                ((InterfaceC0813bw) this.f777ar).mo1190c();
            }
            fragmentTransactionBeginTransaction.hide(this.f777ar);
        }
        if (GlobalApplication.m6456e() && (fragmentFindFragmentById = supportFragmentManager.findFragmentById(R.id.child)) != null) {
            fragmentTransactionBeginTransaction.remove(fragmentFindFragmentById);
        }
        switch (i) {
            case 0:
                fragmentFindFragmentById2 = supportFragmentManager.findFragmentById(R.id.fragment_buddy);
                break;
            case 1:
                fragmentFindFragmentById2 = supportFragmentManager.findFragmentById(R.id.fragment_msg_box);
                if (GlobalApplication.m6456e()) {
                    m1312a(R.id.child, new Intent(), EmptyChatFragment.class);
                    break;
                }
                break;
            case 2:
                fragmentFindFragmentById2 = supportFragmentManager.findFragmentById(R.id.fragment_user_profile);
                break;
            case 3:
                fragmentFindFragmentById2 = supportFragmentManager.findFragmentById(R.id.fragment_plus);
                break;
        }
        if (fragmentFindFragmentById2 != null) {
            if (fragmentFindFragmentById2 instanceof InterfaceC0813bw) {
                ((InterfaceC0813bw) fragmentFindFragmentById2).mo1189b();
            }
            fragmentTransactionBeginTransaction.show(fragmentFindFragmentById2);
        }
        this.f777ar = fragmentFindFragmentById2;
        if (fragmentFindFragmentById2 != null) {
            this.f778as = fragmentFindFragmentById2.getId();
        }
        if (GlobalApplication.m6456e()) {
            m1289o();
        }
        supportInvalidateOptionsMenu();
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1235a(Cursor cursor) {
        Message messageM6267c = C1414e.m6265a().m6267c();
        messageM6267c.obj = cursor;
        C1414e.m6265a().m6266b().sendMessage(messageM6267c);
    }

    @Override // com.sec.chaton.msgbox.InterfaceC1701ae
    /* renamed from: b */
    public void mo1318b() {
        startActivity(new Intent(this, (Class<?>) CallLogActivity.class));
    }

    @Override // com.sec.chaton.msgbox.InterfaceC1701ae
    /* renamed from: c */
    public void mo1322c() {
        Intent intent = new Intent(this, (Class<?>) MsgboxSelectionActivity.class);
        if (GlobalApplication.m6456e()) {
            startActivityForResult(intent, 4);
        } else {
            startActivity(intent);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0331  */
    @Override // com.sec.chaton.msgbox.InterfaceC1701ae
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo1314a(android.database.Cursor r14, boolean r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 826
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.TabActivity.mo1314a(android.database.Cursor, boolean):void");
    }

    @Override // com.sec.chaton.userprofile.InterfaceC3112bk
    /* renamed from: a */
    public void mo1313a(int i, boolean z) {
        Intent intent = new Intent(this, (Class<?>) ProfileImageHistoryActivity.class);
        if (z) {
            intent.putExtra("mSmallImageNum", i);
        }
        startActivity(intent);
    }

    @Override // com.sec.chaton.userprofile.InterfaceC3112bk
    /* renamed from: d */
    public void mo1323d() {
        startActivity(new Intent(this, (Class<?>) EditProfileActivity.class));
    }

    @Override // com.sec.chaton.userprofile.InterfaceC3112bk
    /* renamed from: e */
    public void mo1324e() {
        startActivity(new Intent(this, (Class<?>) MyInfoActivity.class));
    }

    @Override // com.sec.chaton.userprofile.InterfaceC3112bk
    /* renamed from: a */
    public void mo1315a(String str, String str2) {
        if (GlobalApplication.m6456e()) {
            Intent intent = new Intent(this, (Class<?>) BuddyProfileActivity.class);
            intent.putExtra("PROFILE_BUDDY_NO", str);
            intent.putExtra("PROFILE_BUDDY_NAME", str2);
            intent.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
            startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this, (Class<?>) BuddyDialog.class);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_NO", str);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_NAME", str2);
        if (this instanceof Activity) {
            intent2.setFlags(67108864);
        } else {
            intent2.setFlags(335544320);
        }
        startActivity(intent2);
    }

    @Override // com.sec.chaton.buddy.InterfaceC0696fg, com.sec.chaton.userprofile.InterfaceC3112bk
    /* renamed from: b */
    public void mo1320b(String str, String str2) {
        Intent intent = new Intent(this, (Class<?>) PostONImagePagerActivity.class);
        intent.putExtra("buddyId", str);
        intent.putExtra("url", str2);
        startActivity(intent);
    }

    /* renamed from: a */
    public void m1312a(int i, Intent intent, Class<? extends Fragment> cls) {
        Fragment fragmentInstantiate = Fragment.instantiate(this, cls.getName());
        if (intent != null) {
            fragmentInstantiate.setArguments(intent.getExtras());
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.child, fragmentInstantiate);
        if (fragmentInstantiate instanceof TrunkView) {
            fragmentTransactionBeginTransaction.addToBackStack(null);
        }
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @Override // com.sec.chaton.buddy.InterfaceC0777ig
    /* renamed from: f */
    public void mo1325f() {
        ((BuddyFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_buddy)).m3439d();
    }

    @Override // com.sec.chaton.FlexibleActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (GlobalApplication.m6456e()) {
            m1221N();
            m1289o();
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // com.sec.chaton.trunk.InterfaceC3039cm
    /* renamed from: a */
    public void mo1316a(String str, String str2, String str3, String str4, EnumC3026g enumC3026g, int i, boolean z) {
        Intent intent = new Intent();
        intent.setClass(this, TrunkPageActivity.class);
        intent.putExtra("sessionId", str);
        intent.putExtra("inboxNo", str2);
        intent.putExtra("itemId", str3);
        intent.putExtra("isvalid", z);
        startActivity(intent);
    }

    /* renamed from: g */
    public boolean m1326g() {
        return this.f734A;
    }

    /* renamed from: a */
    public void m1317a(boolean z) {
        this.f734A = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1251b(boolean z) {
        Intent intent = new Intent(this, (Class<?>) ChatONVUpgradeDialog.class);
        intent.putExtra("isCritical", z);
        intent.putExtra("isFromHome", true);
        intent.setFlags(131072);
        startActivity(intent);
    }

    /* renamed from: L */
    private boolean m1217L() {
        return C3159aa.m10962a().m10977a("chatonv_critical_update", (Boolean) false).booleanValue();
    }

    /* renamed from: h */
    public void m1327h() {
        findViewById(R.id.splitView).setVisibility(8);
        findViewById(R.id.child_fragment).setVisibility(8);
    }

    /* renamed from: b */
    public void m1319b(int i) {
        findViewById(R.id.splitView).setVisibility(8);
        findViewById(R.id.child_fragment).setVisibility(0);
    }

    @Override // com.sec.chaton.util.InterfaceC3226cn
    public int getDefaultTheme() {
        return R.style.AppTheme_Home;
    }

    @Override // com.sec.chaton.util.InterfaceC3226cn
    public int getBlackTheme() {
        return R.style.AppTheme_Black_Home;
    }

    /* renamed from: i */
    public int m1328i() {
        return this.f778as;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public void m1219M() {
        if (GlobalApplication.m6457f()) {
            this.f799w = this.f798v.getViewTreeObserver();
            this.f799w.removeOnGlobalLayoutListener(this.f756W);
        }
        View viewFindViewById = findViewById(R.id.splitView_indicator_default);
        findViewById(R.id.splitView_indicator).setVisibility(0);
        if (viewFindViewById.getVisibility() == 0) {
            viewFindViewById.setBackgroundResource(R.drawable.tablet_tw_preference_contents_list_no_arrow_left_split_pressed_holo_light);
        }
        if (this.f778as == R.id.fragment_buddy) {
            ((BuddyFragment) getSupportFragmentManager().findFragmentById(this.f778as)).m3448m();
        } else if (this.f778as == R.id.fragment_msg_box) {
            ((MsgboxFragment) getSupportFragmentManager().findFragmentById(this.f778as)).m7073d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public void m1221N() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f755V.getLayoutParams();
        if (GlobalApplication.m6457f() && m1252b((Context) this)) {
            this.f736C = this.f798v.getWidth();
        }
        String str = "";
        if (this.f778as == R.id.fragment_buddy) {
            str = "splitview_position_buddy";
        } else if (this.f778as == R.id.fragment_msg_box) {
            str = "splitview_position_chat";
        }
        if (!str.equals("")) {
            C3159aa.m10962a().m10984b(str, Integer.valueOf(Math.round((layoutParams.width * 1000.0f) / this.f736C)));
        }
        double d = (1.0f * this.f741H.width) / this.f736C;
        this.f738E.setBackgroundResource(R.drawable.tablet_tw_preference_contents_list_no_arrow_left_split_default_holo_light);
        if ((this.f735B == 1 && d < 0.20000000298023224d) || (this.f735B == 2 && d < 0.20000000298023224d)) {
            this.f737D.setVisibility(0);
            this.f738E.setVisibility(0);
        } else {
            this.f737D.setVisibility(8);
            this.f738E.setVisibility(8);
        }
        if (this.f778as == R.id.fragment_buddy) {
            ((BuddyFragment) getSupportFragmentManager().findFragmentById(this.f778as)).m3449n();
        } else if (this.f778as == R.id.fragment_msg_box) {
            ((MsgboxFragment) getSupportFragmentManager().findFragmentById(this.f778as)).m7074e();
        }
        if (GlobalApplication.m6457f()) {
            this.f799w = this.f798v.getViewTreeObserver();
            this.f799w.addOnGlobalLayoutListener(this.f756W);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1236a(MotionEvent motionEvent, int i) {
        if (GlobalApplication.m6457f()) {
            this.f799w = this.f798v.getViewTreeObserver();
            this.f799w.removeOnGlobalLayoutListener(this.f756W);
            if (m1252b((Context) this)) {
                this.f736C = this.f798v.getWidth();
            }
        }
        m1233a((1.0f * r3) / this.f736C, this.f741H.width + (((int) motionEvent.getX()) - i), this.f736C, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public int m1222O() {
        Point point = new Point();
        WindowManager windowManager = getWindowManager();
        if (Build.VERSION.SDK_INT >= 13) {
            windowManager.getDefaultDisplay().getSize(point);
            return point.x;
        }
        return windowManager.getDefaultDisplay().getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public int m1223P() {
        return getResources().getConfiguration().orientation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1233a(double d, int i, int i2, boolean z) {
        this.f741H.weight = 0.0f;
        this.f742I.weight = 0.0f;
        if (d > 0.5d) {
            this.f741H.width = Math.round(0.5f * i2);
            this.f742I.width = i2 - this.f741H.width;
        } else {
            this.f738E.setBackgroundResource(R.drawable.tablet_tw_preference_contents_list_no_arrow_left_split_default_holo_light);
            if ((this.f735B == 1 && d < 0.20000000298023224d) || (this.f735B == 2 && d < 0.20000000298023224d)) {
                if (z) {
                    this.f738E.setBackgroundResource(R.drawable.tablet_tw_preference_contents_list_no_arrow_left_split_pressed_holo_light);
                }
                this.f738E.setVisibility(0);
                this.f741H.width = 0;
                this.f742I.width = i2 - getResources().getDimensionPixelSize(R.dimen.splitview_width_default);
            } else {
                this.f738E.setVisibility(8);
                this.f741H.width = i;
                this.f742I.width = 0;
                this.f742I.weight = 1.0f;
            }
        }
        this.f739F.setLayoutParams(this.f741H);
        this.f740G.setLayoutParams(this.f742I);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f778as == R.id.fragment_buddy) {
            BuddyFragment buddyFragment = (BuddyFragment) getSupportFragmentManager().findFragmentById(this.f778as);
            if (buddyFragment.m3444i() > 0) {
                buddyFragment.mo3094a();
                return;
            } else {
                super.onBackPressed();
                return;
            }
        }
        super.onBackPressed();
    }
}
