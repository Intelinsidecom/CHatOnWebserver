package com.sec.chaton;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.hardware.motion.MotionRecognitionManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.AbstractC0024aj;
import android.support.v4.app.AbstractC0069w;
import android.support.v4.app.Fragment;
import android.support.v4.content.C0096i;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.sso.p030a.C0416a;
import com.coolots.sso.p030a.InterfaceC0419d;
import com.renren.android.feed.FeedPublishRequestParam;
import com.sec.chaton.api.p048a.AbstractC1019a;
import com.sec.chaton.api.p048a.C1020b;
import com.sec.chaton.api.p048a.C1021c;
import com.sec.chaton.api.p048a.C1025g;
import com.sec.chaton.api.p048a.C1026h;
import com.sec.chaton.api.p048a.C1027i;
import com.sec.chaton.api.p048a.C1028j;
import com.sec.chaton.api.p048a.C1029k;
import com.sec.chaton.api.p048a.C1031m;
import com.sec.chaton.api.p048a.C1032n;
import com.sec.chaton.api.p048a.C1034p;
import com.sec.chaton.api.p048a.C1035q;
import com.sec.chaton.api.p048a.C1036r;
import com.sec.chaton.api.p048a.C1037s;
import com.sec.chaton.api.p048a.C1039u;
import com.sec.chaton.api.p048a.C1040v;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.InterfaceC1328gh;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.dialog.ChatONVInstallDialog;
import com.sec.chaton.buddy.dialog.ChatONVRedirectDialog;
import com.sec.chaton.calllog.view.CallLogActivity;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.event.NewFeature;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.localbackup.noti.C2555a;
import com.sec.chaton.msgbox.InterfaceC2641bf;
import com.sec.chaton.msgbox.MsgboxFragment;
import com.sec.chaton.msgbox.MsgboxSelectionActivity;
import com.sec.chaton.multimedia.image.PostONImagePagerActivity;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p055d.C2122ca;
import com.sec.chaton.p057e.C2230ar;
import com.sec.chaton.p057e.C2268bn;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p057e.p058a.C2191e;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p057e.p059b.C2244e;
import com.sec.chaton.p065io.entry.GetVersionNotice;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.plugin.C2923b;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.qmlog.C3119a;
import com.sec.chaton.registration.ActivityDisclaimerUpdate;
import com.sec.chaton.registration.C3299gf;
import com.sec.chaton.settings.ActivityGeneral;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;
import com.sec.chaton.settings.p096a.C3469m;
import com.sec.chaton.settings2.SettingActivity;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.smsplugin.p112ui.PluginComposeMessageActivity;
import com.sec.chaton.trunk.InterfaceC4659cq;
import com.sec.chaton.trunk.TrunkPageActivity;
import com.sec.chaton.trunk.p121c.EnumC4642g;
import com.sec.chaton.updates.UpdatesActivity;
import com.sec.chaton.userprofile.InterfaceC4753bl;
import com.sec.chaton.userprofile.MyInfoActivity;
import com.sec.chaton.userprofile.MyPageFragment;
import com.sec.chaton.userprofile.ProfileImageHistoryActivity;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4820al;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4851bp;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4880cr;
import com.sec.chaton.util.C4892m;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.InterfaceC4854bs;
import com.sec.chaton.util.InterfaceC4876cn;
import com.sec.common.C5004g;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.util.log.collector.C5038c;
import com.sec.common.util.log.collector.C5043h;
import com.sec.spp.push.Config;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class TabActivity extends FlexibleActivity implements InterfaceC1328gh, InterfaceC2641bf, InterfaceC4659cq, InterfaceC4753bl, InterfaceC4876cn {

    /* renamed from: A */
    private boolean f2032A;

    /* renamed from: B */
    private boolean f2033B;

    /* renamed from: C */
    private boolean f2034C;

    /* renamed from: D */
    private boolean f2035D;

    /* renamed from: E */
    private boolean f2036E;

    /* renamed from: F */
    private int f2037F;

    /* renamed from: G */
    private int f2038G;

    /* renamed from: H */
    private int f2039H;

    /* renamed from: I */
    private int f2040I;

    /* renamed from: J */
    private int f2041J;

    /* renamed from: K */
    private C2210x f2042K;

    /* renamed from: L */
    private GetVersionNotice f2043L;

    /* renamed from: O */
    private boolean f2046O;

    /* renamed from: P */
    private boolean f2047P;

    /* renamed from: Q */
    private boolean f2048Q;

    /* renamed from: R */
    private boolean f2049R;

    /* renamed from: S */
    private int f2050S;

    /* renamed from: T */
    private InterfaceC4936e f2051T;

    /* renamed from: W */
    private boolean f2052W;

    /* renamed from: aD */
    private C2317ek f2059aD;

    /* renamed from: aE */
    private Fragment f2060aE;

    /* renamed from: aF */
    private int f2061aF;

    /* renamed from: aj */
    private C4851bp f2073aj;

    /* renamed from: v */
    private EnumC1072bl f2094v;

    /* renamed from: w */
    private InterfaceC4936e f2095w;

    /* renamed from: y */
    private C2316ej f2096y;

    /* renamed from: z */
    private BroadcastReceiver f2097z;

    /* renamed from: t */
    private static final String f2029t = TabActivity.class.getSimpleName();

    /* renamed from: u */
    private static final int f2030u = 604045312;

    /* renamed from: n */
    public static final String f2027n = "baseIntent";

    /* renamed from: o */
    public static final String f2028o = "requestTabId";

    /* renamed from: x */
    private static final C1027i f2031x = new C1027i(new AbstractC1019a[]{new C1040v(), new C1036r(), new C1020b(), new C1021c(), new C1031m(), new C1035q(), new C1025g(), new C1028j(), new C1029k(), new C1037s(), new C1034p(), new C1039u(), new C1032n()});

    /* renamed from: U */
    private static boolean f2025U = false;

    /* renamed from: V */
    private static String f2026V = "";

    /* renamed from: M */
    private boolean f2044M = false;

    /* renamed from: N */
    private boolean f2045N = false;

    /* renamed from: X */
    private boolean f2053X = false;

    /* renamed from: Y */
    private boolean f2054Y = false;

    /* renamed from: Z */
    private boolean f2055Z = false;

    /* renamed from: aa */
    private final ContentObserver f2064aa = new C1891ct(this, new Handler());

    /* renamed from: ab */
    private final ContentObserver f2065ab = new C2151df(this, new Handler());

    /* renamed from: ac */
    private final ContentObserver f2066ac = new C2162dq(this, new Handler());

    /* renamed from: ad */
    private final InterfaceC2211y f2067ad = new C2307ea(this);

    /* renamed from: ae */
    private final BroadcastReceiver f2068ae = new C2311ee(this);

    /* renamed from: p */
    Handler f2090p = new HandlerC2312ef(this);

    /* renamed from: af */
    private final BroadcastReceiver f2069af = new C2313eg(this);

    /* renamed from: ag */
    private final BroadcastReceiver f2070ag = new C2314eh(this);

    /* renamed from: ah */
    private final BroadcastReceiver f2071ah = new C2315ei(this);

    /* renamed from: ai */
    private final BroadcastReceiver f2072ai = new C1892cu(this);

    /* renamed from: ak */
    private final InterfaceC4854bs f2074ak = new C1896cy(this);

    /* renamed from: al */
    private final InterfaceC4854bs f2075al = new C1897cz(this);

    /* renamed from: am */
    private final InterfaceC4854bs f2076am = new C2146da(this);

    /* renamed from: an */
    private final InterfaceC4854bs f2077an = new C2148dc(this);

    /* renamed from: ao */
    private final InterfaceC4854bs f2078ao = new C2149dd(this);

    /* renamed from: ap */
    private final InterfaceC4854bs f2079ap = new C2150de(this);

    /* renamed from: aq */
    private final InterfaceC4854bs f2080aq = new C2152dg(this);

    /* renamed from: ar */
    private final InterfaceC4854bs f2081ar = new C2153dh(this);

    /* renamed from: as */
    private final InterfaceC4854bs f2082as = new C2154di(this);

    /* renamed from: at */
    private final InterfaceC4854bs f2083at = new C2155dj(this);

    /* renamed from: au */
    private final InterfaceC4854bs f2084au = new C2156dk(this);

    /* renamed from: av */
    private final InterfaceC4854bs f2085av = new C2157dl(this);

    /* renamed from: aw */
    private final InterfaceC4854bs f2086aw = new C2158dm(this);

    /* renamed from: ax */
    private final InterfaceC4854bs f2087ax = new C2159dn(this);

    /* renamed from: ay */
    private final InterfaceC4854bs f2088ay = new C2160do(this);

    /* renamed from: az */
    private final InterfaceC4854bs f2089az = new C2161dp(this);

    /* renamed from: aA */
    private final InterfaceC4854bs f2056aA = new C2163dr(this);

    /* renamed from: q */
    Handler f2091q = new HandlerC2166du(this, Looper.getMainLooper());

    /* renamed from: r */
    Handler f2092r = new HandlerC2167dv(this, Looper.getMainLooper());

    /* renamed from: s */
    public Handler f2093s = new HandlerC2168dw(this);

    /* renamed from: aB */
    private final Handler f2057aB = new HandlerC2169dx(this);

    /* renamed from: aC */
    private final Handler f2058aC = new HandlerC2170dy(this);

    /* renamed from: aG */
    private final InterfaceC0419d f2062aG = new C2308eb(this);

    /* renamed from: aH */
    private final InterfaceC4854bs f2063aH = new C2309ec(this);

    /* renamed from: c */
    static /* synthetic */ int m3035c(TabActivity tabActivity, int i) {
        int i2 = tabActivity.f2039H + i;
        tabActivity.f2039H = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m3061o() {
        mo2911f().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m3062p() {
        new C3299gf(this).m13041a();
    }

    /* renamed from: q */
    private void m3064q() {
        if (this.f2033B) {
            this.f2033B = false;
            if (this.f2036E) {
                this.f2036E = false;
                this.f2042K.startQuery(2, null, C2299s.m10205r(), null, "inbox_unread_count > 0 OR sms_unread_count > 0", null, null);
            }
            if (this.f2034C) {
                this.f2034C = false;
                this.f2042K.startQuery(1, null, C2289i.f8196a, null, "buddy_is_new='Y' AND buddy_is_hide='N'", null, null);
            }
            if (this.f2035D) {
                this.f2035D = false;
                this.f2042K.startQuery(3, null, C2230ar.f7958a, null, "isNew='Y'", null, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m3067r() {
        this.f2040I = C4809aa.m18104a().m18120a("new_post_on_count", (Integer) 0).intValue();
        if (C4822an.m18199I() == 0) {
            if (this.f2042K != null) {
                this.f2042K.startQuery(4, null, C2299s.m10205r(), null, "inbox_unread_count > 0 OR sms_unread_count > 0", null, null);
            }
        } else {
            C4822an.m18222b(this.f2040I);
            C4822an.m18200J();
            m3061o();
        }
    }

    @Deprecated
    /* renamed from: a */
    public static Intent m3017a(Context context, boolean z) {
        Intent intentM3014a = m3014a(context);
        if (z) {
            intentM3014a.putExtra("callChatList", true);
        } else {
            intentM3014a.putExtra("callChatList", false);
        }
        return intentM3014a;
    }

    /* renamed from: a */
    public static Intent m3014a(Context context) {
        Intent intent = new Intent(context, (Class<?>) TabActivity.class);
        intent.setFlags(f2030u);
        return intent;
    }

    /* renamed from: a */
    public static Intent m3016a(Context context, Intent intent) {
        Intent intentM3014a = m3014a(context);
        intentM3014a.putExtra(f2027n, intent);
        return intentM3014a;
    }

    /* renamed from: a */
    public static Intent m3015a(Context context, int i) {
        Intent intentM3014a = m3014a(context);
        intentM3014a.putExtra(f2028o, i);
        return intentM3014a;
    }

    /* renamed from: a */
    private Fragment m3018a(int i, Class<? extends Fragment> cls) {
        AbstractC0069w abstractC0069wE = m50e();
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(i);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ((ViewGroup) findViewById(android.R.id.content)).addView(frameLayout);
        Fragment fragmentMo180a = abstractC0069wE.mo180a(i);
        AbstractC0024aj abstractC0024ajMo183a = null;
        try {
            abstractC0024ajMo183a = m50e().mo183a();
            if (fragmentMo180a == null) {
                fragmentMo180a = Fragment.instantiate(this, cls.getName());
                abstractC0024ajMo183a.mo100b(i, fragmentMo180a);
            }
            abstractC0024ajMo183a.mo102b(fragmentMo180a);
            return fragmentMo180a;
        } finally {
            if (abstractC0024ajMo183a != null) {
                abstractC0024ajMo183a.mo99b();
            }
        }
    }

    @Override // com.sec.chaton.FlexibleActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws NoSuchAlgorithmException {
        boolean zM3024a;
        Log.i("VerificationLog", "ChatON onCreate");
        f2025U = true;
        if (C2349a.m10301a("sms_feature")) {
            if (!C4822an.m18218a()) {
                C4809aa.m18104a().m18126b("menuIndex", (Integer) 1);
            } else if (!C4809aa.m18104a().m18129b("menuIndex")) {
                C4809aa.m18104a().m18126b("menuIndex", (Integer) (-1));
            }
        }
        C5004g.m18989a(this);
        C1059a.m6164a(this, bundle);
        if (((Application) CommonApplication.m18732r().getApplicationContext()).getApplicationInfo().icon == R.drawable.icon_white) {
            C4904y.m18632a(1);
        } else {
            if (C4904y.m18630a() == 1) {
                C4904y.m18632a(1);
            }
            C4904y.m18638b();
        }
        super.onCreate(bundle);
        if (m3003G()) {
            if (C4904y.f17873c) {
                C4904y.m18641c("HomeActivity is requested finish.", f2029t);
            }
            finish();
            return;
        }
        C5038c.m19155d(C4822an.m18228d());
        if (C4822an.m18218a()) {
            C5038c.m19152c(C4809aa.m18104a().m18121a("uid", ""));
        } else {
            String string = "";
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(C4822an.m18228d().getBytes());
                string = new BigInteger(1, messageDigest.digest()).toString(16);
            } catch (NoSuchAlgorithmException e) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("[Log] onCreate App StartLog MessageDigest :: " + e.toString(), f2029t);
                }
            }
            C5038c.m19152c("cht-" + string.toLowerCase());
        }
        C5038c.m19148b(C4809aa.m18104a().m18121a("samsung_account_user_id", ""));
        Intent intent = getIntent();
        this.f2042K = new C2210x(getContentResolver(), this.f2067ad);
        m3018a(R.id.fragment_buddy, BuddyFragment.class);
        m3018a(R.id.fragment_msg_box, MsgboxFragment.class);
        if (bundle != null) {
            this.f2054Y = bundle.getBoolean("mDidMyPageFragmentAttached");
            this.f2055Z = bundle.getBoolean("mDidPlusFragmentAttached");
            if (this.f2054Y) {
                m3018a(R.id.fragment_user_profile, MyPageFragment.class);
            }
            if (this.f2055Z) {
                m3018a(R.id.fragment_plus, PlusFragment.class);
            }
        }
        m50e().mo186b();
        if (!C4873ck.m18503d()) {
            if (C4904y.f17874d) {
                C4904y.m18645d("There isn't enough memory for executing ChatON.", f2029t);
            }
            Toast.makeText(CommonApplication.m18732r(), R.string.popup_not_enough_memory, 0).show();
            finish();
            return;
        }
        if (!m2998C()) {
            if ((!C2349a.m10301a("sms_feature") || !C4809aa.m18104a().m18129b("provisioning_disclaimer_status")) && !m2995B()) {
                finish();
                C4859bx.m18398d();
                startActivity(HomeActivity.m2912a((Context) this));
                return;
            }
            if (!this.f2044M) {
                C4859bx.m18387a(C4822an.m18257y(), this);
            }
            this.f2096y = new C2316ej(this, null);
            C0991aa.m6037a().m18959a(this.f2096y);
            if (bundle == null) {
                Intent intent2 = (Intent) intent.getParcelableExtra(f2027n);
                if (intent2 == null) {
                    intent2 = intent;
                }
                zM3024a = m3024a(intent2);
            } else {
                zM3024a = true;
            }
            if (C1427a.f5070h) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Welcome, First Time after update ChatON.", f2029t);
                }
                C4822an.m18256x();
                m3069s();
                C4809aa.m18108a("chaton_version", C1427a.f5063a);
                C1427a.f5070h = false;
                C4809aa.m18104a().m18125b("buddy_get_all_buddy_mode_instance", (Boolean) true);
                C4809aa.m18104a().m18125b("restore_livepartner_user_list", (Boolean) true);
            } else if (!m2998C() && m3000D() && !zM3024a) {
                String strM18121a = C4809aa.m18104a().m18121a("UpdateAppsReady", "NO");
                Intent intent3 = new Intent(this, (Class<?>) UpgradeDialog.class);
                intent3.putExtra("isCritical", false);
                intent3.setFlags(67108864);
                intent3.putExtra("isReadyApps", strM18121a);
                startActivity(intent3);
            }
            if (C4822an.m18218a()) {
                m3081z();
                C4809aa.m18105a("enteredtab", (Boolean) true);
                if (C2349a.m10301a("wifi_80_port")) {
                    C4809aa.m18104a().m18126b(Config.PROVIDER_PATH_WIFI_PORT, Integer.valueOf(C4844bi.m18324d()));
                }
            } else {
                m3077x();
            }
            m3005I();
            m3080y();
            m3012P();
            if (C4809aa.m18104a().m18119a("first_time_after_regi", (Boolean) false).booleanValue()) {
                C4809aa.m18104a().m18123a("first_time_after_regi");
                C4809aa.m18104a().m18123a("provisioning_state");
            }
            if (C4859bx.m18415j() && !C4809aa.m18104a().m18129b("marketing_disclaimer")) {
                m3074v();
            }
            C4904y.m18639b("onCreate : set setShowPasswordLock value", f2029t);
            if (getIntent().getBooleanExtra("extra_from_chaton", false)) {
                this.f2052W = true;
            } else if (bundle != null && C4892m.m18574b()) {
                C4904y.m18639b("savedInstanceState" + bundle, f2029t);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("password_lock_finish");
            C0096i.m358a(this).m362a(this.f2072ai, intentFilter);
            this.f2033B = true;
            this.f2036E = true;
            this.f2034C = true;
            this.f2035D = true;
            getContentResolver().registerContentObserver(C2289i.f8196a, true, this.f2064aa);
            getContentResolver().registerContentObserver(C2230ar.f7958a, true, this.f2065ab);
            this.f2090p.sendEmptyMessageDelayed(0, 5000L);
            if (C4904y.f17872b) {
                C4904y.m18639b("livechat, feedback, timer start...", f2029t);
            }
        }
    }

    /* renamed from: s */
    private void m3069s() {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = C2268bn.m10126a(CommonApplication.m18732r()).getReadableDatabase().rawQuery("SELECT g._id, group_name, group_relation_buddy FROM buddy_group g left outer join grouprelation r on g._id = r.group_relation_group order by g._id", null);
                if (cursorRawQuery != null && cursorRawQuery.getCount() != 0) {
                    cursorRawQuery.moveToPosition(-1);
                    while (cursorRawQuery.moveToNext()) {
                        String string = cursorRawQuery.getString(0);
                        String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("group_name"));
                        String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("group_relation_buddy"));
                        if (!string2.equals("Favorites") && string3 == null) {
                            C2191e.m9862b(GlobalApplication.m18732r().getContentResolver(), string);
                            C4904y.m18641c("remove garbage group " + string + ", name : " + string2, getClass().getSimpleName());
                        }
                    }
                }
                if (cursorRawQuery == null) {
                    return;
                }
            } catch (Exception e) {
                C4904y.m18639b(e.getMessage(), getClass().getSimpleName());
                if (cursorRawQuery == null) {
                    return;
                }
            }
            cursorRawQuery.close();
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        Intent intentM18566a;
        super.onStart();
        C4904y.m18641c("[LIFE] onStart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m3075w(), f2029t);
        if (m2998C()) {
            String strM18121a = C4809aa.m18104a().m18121a("UpdateAppsReady", "NO");
            Intent intent = new Intent(this, (Class<?>) UpgradeDialog.class);
            intent.putExtra("isCritical", true);
            intent.setFlags(67108864);
            intent.putExtra("isReadyApps", strM18121a);
            startActivity(intent);
            new C2122ca(this.f2091q).m9471b();
        } else if (m3006J().equals("RUN")) {
            m3030b(m3002F());
        } else if (m3011O()) {
            m3031b(true);
        } else if (this.f2073aj != null) {
            this.f2073aj.m18338a();
        }
        if (this.f2052W) {
            C4892m.m18577c(false);
            this.f2052W = false;
        } else if (this.f2053X) {
            this.f2053X = false;
            if (C4892m.m18571a()) {
                C4892m.m18570a(false);
                C4892m.m18577c(true);
                if (C4892m.m18575b(this) && (intentM18566a = C4892m.m18566a((Context) this)) != null) {
                    startActivity(intentM18566a);
                }
            } else {
                C1059a.m6163a(this);
            }
        } else {
            C1059a.m6163a(this);
        }
        C3847e.m14655aF();
    }

    @Override // com.sec.chaton.FlexibleActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        C1059a.m6170f(this);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C1059a.m6166b(this);
        int iM10677a = C2471v.m10677a(GlobalApplication.m18732r());
        Log.i("VerificationLog", "ChatON onResume");
        if (C2349a.m10301a("chaton_qmlog_sending")) {
            C3119a.m12716a().m12723b(System.currentTimeMillis());
        }
        if (-3 != iM10677a && -2 != iM10677a && C4809aa.m18104a().m18119a("new_feature_ready_to_show", (Boolean) false).booleanValue()) {
            int iIntValue = C4809aa.m18104a().m18120a("new_feature_count", (Integer) 0).intValue();
            Intent intent = new Intent(GlobalApplication.m18732r(), (Class<?>) NewFeature.class);
            if (!TextUtils.isEmpty(C4809aa.m18104a().m18121a("new_feature_url_list", "")) && iIntValue > 0) {
                startActivity(intent);
            }
            C4809aa.m18104a().m18125b("new_feature_ready_to_show", (Boolean) false);
        }
        this.f2032A = false;
        C4904y.m18641c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m3075w(), f2029t);
        if (!C4873ck.m18503d()) {
            if (C4904y.f17874d) {
                C4904y.m18645d("There isn't enough memory for executing ChatON.", f2029t);
            }
            Toast.makeText(CommonApplication.m18732r(), R.string.popup_not_enough_memory, 0).show();
            finish();
            return;
        }
        m3064q();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("mypage_badge_update");
        C0096i.m358a(this).m362a(this.f2068ae, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("more_tab_badge_update");
        intentFilter2.addAction("promotion_event_update");
        C0096i.m358a(this).m362a(this.f2070ag, intentFilter2);
        IntentFilter intentFilter3 = new IntentFilter();
        intentFilter3.addAction("splash_update");
        C0096i.m358a(this).m362a(this.f2071ah, intentFilter3);
        IntentFilter intentFilter4 = new IntentFilter();
        intentFilter4.addAction("buddy_tab_badge_update");
        intentFilter4.addAction("buddy_tab_name_update");
        C0096i.m358a(this).m362a(this.f2069af, intentFilter4);
        this.f2041J = m3071u();
        m3067r();
        Log.i("VerificationLog", "ChatON Executed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public int m3071u() {
        return (C4809aa.m18104a().m18120a("new_livepartner_count", (Integer) 0).intValue() > 0 ? 1 : 0) + (C3469m.m13793a() <= 0 ? 0 : 1) + C4809aa.m18104a().m18120a("new_promotion_count", (Integer) 0).intValue();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        C1059a.m6167c(this);
        this.f2032A = true;
        C4904y.m18641c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m3075w(), f2029t);
        try {
            C0096i.m358a(this).m361a(this.f2068ae);
            C0096i.m358a(this).m361a(this.f2070ag);
            C0096i.m358a(this).m361a(this.f2071ah);
        } catch (IllegalArgumentException e) {
            Log.e(f2029t, "in ONPause .receiver not registered properly");
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("mDidMyPageFragmentAttached", this.f2054Y);
        bundle.putBoolean("mDidPlusFragmentAttached", this.f2055Z);
    }

    @Override // com.sec.chaton.FlexibleActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.f2060aE = null;
        super.onDestroy();
        C1059a.m6171g(this);
        C4904y.m18641c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m3075w(), f2029t);
        if (C4822an.m18218a()) {
            C5043h.m19179a().m19185a(f2026V, "0102", true);
        } else {
            C5043h.m19179a().m19185a(f2026V, "0104", true);
        }
        if (this.f2051T != null && this.f2051T.isShowing()) {
            this.f2051T.dismiss();
        }
        try {
            C4859bx.m18400d(this);
            if (this.f2096y != null) {
                C0991aa.m6037a().m18960b(this.f2096y);
            }
            if (this.f2097z != null) {
                unregisterReceiver(this.f2097z);
                this.f2097z = null;
            }
            C0096i.m358a(this).m361a(this.f2072ai);
            C0096i.m358a(CommonApplication.m18732r()).m361a(this.f2069af);
        } catch (IllegalArgumentException e) {
            Log.e(f2029t, "receiver not registered properly");
        }
        if (this.f2095w != null && this.f2095w.isShowing()) {
            this.f2095w.dismiss();
        }
        this.f2044M = true;
        getContentResolver().unregisterContentObserver(this.f2064aa);
        getContentResolver().unregisterContentObserver(this.f2065ab);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C4904y.m18641c("[LIFE] onNewIntent, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m3075w(), f2029t);
        setIntent(intent);
        if (m3003G()) {
            finish();
            return;
        }
        if (m3001E()) {
            finish();
            startActivity(m3014a((Context) this));
            return;
        }
        Intent intent2 = (Intent) intent.getParcelableExtra(f2027n);
        if (intent2 != null) {
            intent = intent2;
        }
        m3024a(intent);
        if (intent.getBooleanExtra("extra_from_chaton", false)) {
            this.f2052W = true;
        }
        if (C4892m.m18583e()) {
            C4892m.m18577c(true);
        }
        this.f2053X = true;
    }

    /* renamed from: v */
    private void m3074v() {
        if (C4904y.f17872b) {
            C4904y.m18639b("acceptPushMarketingPopup", f2029t);
        }
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_text_checkbox, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.linear_packet_chekcbox);
        ((TextView) viewInflate.findViewById(R.id.commenttextview)).setText(R.string.setting_push_marketing_agree_pop_up);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.data_packet_chekcbox);
        checkBox.setText(R.string.disclaimer_agree);
        linearLayout.setOnClickListener(new ViewOnClickListenerC1893cv(this, checkBox));
        InterfaceC4936e interfaceC4936eMo18745a = AbstractC4932a.m18733a(this).mo18748b(viewInflate).mo18742a(true).mo18751b(false).mo18748b(viewInflate).mo18740a(getResources().getString(R.string.setting_service_notifications_popup_title)).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1895cx(this, checkBox)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1894cw(this)).mo18745a();
        if (!this.f2044M) {
            interfaceC4936eMo18745a.show();
        }
    }

    /* renamed from: a */
    private boolean m3024a(Intent intent) {
        boolean zM6130a;
        boolean z = false;
        if (m3036c(intent)) {
            finish();
            return true;
        }
        if (m3032b(intent)) {
            finish();
            startActivity(m3014a((Context) this));
            return true;
        }
        try {
            zM6130a = f2031x.m6130a(this, intent);
        } catch (C1026h e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f2029t);
            }
            zM6130a = false;
        }
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey(f2028o)) {
            m18784t().mo18832d(extras.getInt(f2028o));
        }
        if (zM6130a) {
            return true;
        }
        EnumC1072bl enumC1072blM6178a = C1071bk.m6178a(intent, this);
        this.f2094v = enumC1072blM6178a;
        switch (C2310ed.f8233a[enumC1072blM6178a.ordinal()]) {
            case 1:
                m3040d(intent);
                z = true;
                break;
            case 3:
                m18784t().mo18832d(1);
                break;
            case 4:
                startActivity(new Intent(this, (Class<?>) ChatONVInstallDialog.class));
                z = true;
                break;
            case 5:
                m18784t().mo18832d(3);
                Intent intent2 = new Intent(this, (Class<?>) SettingActivity.class);
                intent2.putExtra("gotoAlert", true);
                startActivity(intent2);
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                m3023a(enumC1072blM6178a, intent);
                z = true;
                break;
            case 10:
                C4820al.m18181a().m18183a(CommonApplication.m18732r(), C4820al.f17591d);
                m18784t().mo18832d(0);
                break;
        }
        return z;
    }

    /* renamed from: a */
    private void m3023a(EnumC1072bl enumC1072bl, Intent intent) {
        if (C2923b.m12153h(this)) {
            if (m3009M()) {
                if (m3008L()) {
                    if (getSharedPreferences("PASSWORD_LOCK", 0).getString("LOCK_STATE", C4892m.m18588h()).equals(C4892m.m18588h())) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("psswordLock was enabled", f2029t);
                        }
                        m3029b(enumC1072bl, intent);
                        return;
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("showPasswordLockActivity for Result", f2029t);
                    }
                    C4892m.m18577c(true);
                    Context applicationContext = getApplicationContext();
                    if (C4892m.m18575b(applicationContext)) {
                        intent.setClass(applicationContext, ActivityPasswordLockSet.class);
                        intent.setFlags(67108864);
                        intent.putExtra("requestMode", enumC1072bl);
                        intent.putExtra("MODE", "HOME");
                        startActivityForResult(intent, 5);
                        return;
                    }
                    return;
                }
                startActivity(new Intent(this, (Class<?>) ChatONVInstallDialog.class));
                return;
            }
            if (!m3010N()) {
                startActivity(new Intent(this, (Class<?>) ChatONVRedirectDialog.class));
            }
        }
    }

    /* renamed from: w */
    private String m3075w() {
        String str = getIntent().getAction() != null ? ", Intent Action: " + getIntent().getAction() : ", Intent Action: Null";
        if (getIntent().getCategories() != null) {
            return str + ", Intent Category: " + getIntent().getCategories().toString();
        }
        return str + ", Intent Category: Null";
    }

    /* renamed from: x */
    private void m3077x() {
        this.f2073aj = new C4851bp();
        this.f2073aj.m18339a("local_calculation", this.f2075al, 60000L, "last_sync_time_on_start");
        if (C4809aa.m18104a().m18121a("first_disclaimer_status", "").equals("DONE")) {
            if (C4904y.f17872b) {
                C4904y.m18639b("already accepted disclaimer in Lite User", f2029t);
            }
            this.f2073aj.m18339a("version_notice", this.f2080aq, 21600000L, "last_sync_time_get_version_notice");
            return;
        }
        this.f2073aj.m18339a("accpet_disclaimer", this.f2079ap, 259200000L, "last_sync_time_accept_disclaimer");
    }

    /* renamed from: y */
    private void m3080y() {
        C4904y.m18641c("[LIFE] initView, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m3075w(), f2029t);
        if (ExitAppDialogActivity.m2892a()) {
            startActivity(new Intent(this, (Class<?>) ExitAppDialogActivity.class));
        }
    }

    /* renamed from: z */
    private void m3081z() {
        this.f2073aj = new C4851bp();
        this.f2073aj.m18339a("get_chaton_crypto_key", this.f2086aw, 60000L, "last_sync_time_get_chaton_crypto_key");
        this.f2073aj.m18339a("local_calculation", this.f2074ak, 60000L, "last_sync_time_on_start");
        this.f2073aj.m18339a("get_push_status", this.f2076am, 60000L, "last_sync_time_get_push_status");
        this.f2073aj.m18339a("version_notice", this.f2080aq, 21600000L, "last_sync_time_get_version_notice");
        if (C4859bx.m18370a("com.sec.spp.push") < 21) {
            this.f2073aj.m18339a("spp_update_check", this.f2081ar, 259200000L, "last_sync_time_get_spp_update_check");
        } else {
            if (C4904y.f17872b) {
                C4904y.m18639b("don't need to add poliing scheduler for SPP", f2029t);
            }
            m2993A();
        }
        this.f2073aj.m18339a("notification", this.f2078ao, 1800000L, "last_sync_time_notification");
        this.f2073aj.m18339a("more_app_sync", this.f2084au, 86400000L, "last_more_app_sync_time");
        this.f2073aj.m18339a("plus_list_sync", this.f2085av, 86400000L, "last_pluslist_sync_time");
        if (C2349a.m10301a("chatonv_feature")) {
            this.f2073aj.m18339a("chatonv_available", this.f2056aA, 86400000L, "last_chatonv_available_time");
        }
        this.f2073aj.m18339a("chatonv_update_check", this.f2087ax, 86400000L, "last_chatonv_upgrade_check");
        this.f2073aj.m18339a("set_compatibility", this.f2088ay, 900000L, "last_compatibility_time");
        this.f2073aj.m18339a("set_uploadPurchaseList", this.f2089az, 900000L, "last_upload_purchase_list");
        this.f2073aj.m18339a("recommendee_sync", this.f2082as, 86400000L, "last_recommendee_sync_time1");
        this.f2073aj.m18339a("sns_recommend_buddy_sync", this.f2083at, 10800000L, "last_getting_chaton_buddy_from_sns");
        this.f2073aj.m18339a("gld_feature_policy", this.f2063aH, 86400000L, "last_sync_gld_feature_policy_time");
    }

    /* renamed from: A */
    private void m2993A() {
        if (this.f2097z == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action_noti_spp_update");
            this.f2097z = new C2164ds(this);
            registerReceiver(this.f2097z, intentFilter);
        }
    }

    /* renamed from: B */
    private boolean m2995B() {
        return C4809aa.m18104a().m18129b("uid");
    }

    /* renamed from: C */
    private boolean m2998C() {
        return C4809aa.m18104a().m18119a("UpdateIsCritical", (Boolean) false).booleanValue();
    }

    /* renamed from: D */
    private boolean m3000D() {
        return !C4809aa.m18104a().m18119a("UpdateIsNormal", (Boolean) true).booleanValue();
    }

    /* renamed from: E */
    private boolean m3001E() {
        return m3032b(getIntent());
    }

    /* renamed from: b */
    private boolean m3032b(Intent intent) {
        return intent.getBooleanExtra("callRestart", false);
    }

    /* renamed from: F */
    private String m3002F() {
        return C4809aa.m18104a().m18121a("disclaimer_UID", "");
    }

    /* renamed from: G */
    private boolean m3003G() {
        return m3036c(getIntent());
    }

    /* renamed from: c */
    private boolean m3036c(Intent intent) {
        return intent.getBooleanExtra("finish", false) && (intent.getFlags() & FeedPublishRequestParam.MESSAGE_TOO_LONG) != 1048576;
    }

    /* renamed from: d */
    private void m3040d(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("callChatList", false);
        if (C4904y.f17873c) {
            C4904y.m18641c("Shortcut or Notification: " + booleanExtra, f2029t);
        }
        if (booleanExtra) {
            intent.getBooleanExtra("specialbuddy", false);
            if (EnumC2301u.m10211a(intent.getIntExtra("roomType", EnumC2301u.NORMAL.m10212a())) == EnumC2301u.SMS) {
                Intent intentM15925a = PluginComposeMessageActivity.m15925a(this, Long.parseLong(intent.getStringExtra("inboxNO")));
                if (intent.hasExtra("disable")) {
                    intentM15925a.putExtra("disable", intent.getBooleanExtra("disable", false));
                }
                startActivity(intentM15925a);
                return;
            }
            intent.putExtra("callChatList", false);
            intent.setClass(this, ChatActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            return;
        }
        if (EnumC2300t.m10207a(intent.getIntExtra("chatType", -1)) == EnumC2300t.WEB_AUTH) {
            C1813b.m8906b().m8940e();
            AbstractC4932a.m18733a(this).mo18734a(R.string.app_name).mo18749b(intent.getStringExtra("Content")).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2165dt(this)).mo18745a().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public boolean m3004H() {
        Context applicationContext = getApplicationContext();
        if (!m3087b(applicationContext).equals("com.sec.chaton.settings.ActivityPasswordLockSet")) {
            return false;
        }
        C4904y.m18639b("getClassName : " + m3087b(applicationContext), f2029t);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3030b(String str) {
        if (!C4822an.m18255w()) {
            C4904y.m18639b("showDisclaimer", f2029t);
            C4809aa.m18108a("update_disclaimer_status", "RUN");
            C4822an.m18216a("agree_disclaimer", (Object) false);
            C4809aa.m18108a("disclaimer_ID", str);
            Intent intent = new Intent(this, (Class<?>) ActivityDisclaimerUpdate.class);
            intent.putExtra("disclaimerUID", str);
            intent.setFlags(MotionRecognitionManager.EVENT_OVER_TURN_LOW_POWER);
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public void m3005I() {
        if (C4904y.f17872b) {
            C4904y.m18639b("initializeUpdateFactor", f2029t);
        }
        this.f2046O = false;
        this.f2047P = false;
        this.f2048Q = false;
        this.f2049R = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public String m3006J() {
        return C4809aa.m18104a().m18121a("update_disclaimer_status", "");
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C1059a.m6169e(this);
        switch (i) {
            case 2:
                if (i2 == -1) {
                    C2555a.m10957a(GlobalApplication.m18732r(), false);
                    C4809aa.m18105a("setting_backup_enable", (Boolean) true);
                    break;
                } else if (i2 == 0) {
                    C4809aa.m18105a("auto_backup_on", (Boolean) false);
                    break;
                }
                break;
            case 5:
                EnumC1072bl enumC1072bl = null;
                if (intent != null) {
                    enumC1072bl = (EnumC1072bl) intent.getExtras().get("requestMode");
                }
                if (enumC1072bl != null) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("REQ_CODE_DIRECT_CHATONV_CALL, mode : " + enumC1072bl, f2029t);
                    }
                    m3029b(enumC1072bl, intent);
                    break;
                }
                break;
        }
    }

    /* renamed from: b */
    private void m3029b(EnumC1072bl enumC1072bl, Intent intent) {
        if (m3038c(enumC1072bl, intent)) {
            Toast.makeText(CommonApplication.m18732r(), R.string.shortcut_contact_blocked_or_notfound, 0).show();
        }
        switch (C2310ed.f8233a[enumC1072bl.ordinal()]) {
            case 6:
                new C0416a().m1487a(this, false, intent.getStringExtra("chatonno"), C4809aa.m18104a().m18121a("Push Name", ""), null);
                break;
            case 7:
                new C0416a().m1487a(this, true, intent.getStringExtra("chatonno"), C4809aa.m18104a().m18121a("Push Name", ""), null);
                break;
            case 8:
                String[] stringArrayExtra = intent.getStringArrayExtra("chatonno");
                if (stringArrayExtra == null && intent.getStringExtra("groupId") != null) {
                    stringArrayExtra = (String[]) C2191e.m9852a(CommonApplication.m18732r().getContentResolver(), Integer.parseInt(intent.getStringExtra("groupId"))).toArray(new String[0]);
                }
                if (stringArrayExtra != null && stringArrayExtra.length == 1) {
                    new C0416a().m1487a(this, false, stringArrayExtra[0], C4809aa.m18104a().m18121a("Push Name", ""), null);
                    break;
                } else {
                    new C0416a().m1488a(this, false, stringArrayExtra, C4809aa.m18104a().m18121a("Push Name", ""), null, null);
                    break;
                }
                break;
            case 9:
                String[] stringArrayExtra2 = intent.getStringArrayExtra("chatonno");
                if (stringArrayExtra2 == null && intent.getStringExtra("groupId") != null) {
                    stringArrayExtra2 = (String[]) C2191e.m9852a(CommonApplication.m18732r().getContentResolver(), Integer.parseInt(intent.getStringExtra("groupId"))).toArray(new String[0]);
                }
                if (stringArrayExtra2 != null && stringArrayExtra2.length == 1) {
                    new C0416a().m1487a(this, true, stringArrayExtra2[0], C4809aa.m18104a().m18121a("Push Name", ""), null);
                    break;
                } else {
                    new C0416a().m1488a(this, true, stringArrayExtra2, C4809aa.m18104a().m18121a("Push Name", ""), null, null);
                    break;
                }
                break;
        }
    }

    /* renamed from: c */
    private boolean m3038c(EnumC1072bl enumC1072bl, Intent intent) {
        switch (C2310ed.f8233a[enumC1072bl.ordinal()]) {
            case 6:
            case 7:
                if (!C2190d.m9846i(CommonApplication.m18732r().getContentResolver(), intent.getStringExtra("chatonno"))) {
                    break;
                }
                break;
            case 8:
            case 9:
                String[] stringArrayExtra = intent.getStringArrayExtra("chatonno");
                if (stringArrayExtra == null && intent.getStringExtra("groupId") != null) {
                    stringArrayExtra = (String[]) C2191e.m9852a(CommonApplication.m18732r().getContentResolver(), Integer.parseInt(intent.getStringExtra("groupId"))).toArray(new String[0]);
                }
                for (String str : stringArrayExtra) {
                    if (!C2190d.m9846i(CommonApplication.m18732r().getContentResolver(), str)) {
                        break;
                    }
                }
                break;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public void m3007K() {
        C0096i.m358a(getApplicationContext()).m363a(new Intent("com.sec.chaton.ACTION_DISMISS"));
        C0096i.m358a(getApplicationContext()).m363a(new Intent("more_tab_badge_update"));
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        C1059a.m6168d(this);
    }

    /* renamed from: b */
    public String m3087b(Context context) {
        String className = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getClassName();
        C4904y.m18639b("getClassName : " + className, "HomeActivity");
        return className;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        BuddyFragment buddyFragment = (BuddyFragment) m50e().mo180a(R.id.fragment_buddy);
        if (buddyFragment != null) {
            C4904y.m18639b("dispatchKeyEvent : KeyCode = " + keyEvent.getKeyCode(), f2029t);
            C4904y.m18639b("dispatchKeyEvent : Current Tab ID = " + this.f2061aF, f2029t);
            if (keyEvent.getKeyCode() == 84) {
                if (this.f2061aF == 0) {
                    buddyFragment.m6607j();
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        if (C4822an.m18218a() && menu.findItem(R.id.menu_updates) != null) {
            C4880cr.m18526b(menu.findItem(R.id.menu_updates));
        }
        return super.onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportPrepareOptionsMenu(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_chat);
        menu.findItem(R.id.menu_settings);
        MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_updates);
        if (menuItemFindItem != null) {
            if (BuddyFragment.f3585k && this.f2061aF == R.id.fragment_buddy) {
                menuItemFindItem.setVisible(false);
            } else {
                menuItemFindItem.setVisible(true);
            }
        }
        if (C4822an.m18218a()) {
            if (menuItemFindItem2 != null) {
                menuItemFindItem2.setVisible(true);
                if (C4809aa.m18104a().m18119a("updates_show_new_badge", (Boolean) false).booleanValue()) {
                    C4880cr.m18524a(menuItemFindItem2, true);
                } else {
                    C4880cr.m18524a(menuItemFindItem2, false);
                }
            }
        } else {
            menuItemFindItem2.setVisible(false);
        }
        return super.onSupportPrepareOptionsMenu(menu);
    }

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        super.onSupportOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case R.id.menu_chat /* 2131166647 */:
                if (this.f2051T != null && this.f2051T.isShowing()) {
                    return true;
                }
                ArrayList arrayList = new ArrayList();
                if (C4822an.m18218a()) {
                    arrayList.add(GlobalApplication.m10283b().getString(R.string.menu_send_to_freechat));
                }
                if (C4822an.m18226c()) {
                    arrayList.add(GlobalApplication.m10283b().getString(R.string.menu_send_to_message));
                }
                if (C2923b.m12153h(GlobalApplication.m18732r())) {
                    arrayList.add(GlobalApplication.m10283b().getString(R.string.menu_voice_call));
                    arrayList.add(GlobalApplication.m10283b().getString(R.string.menu_video_call));
                }
                if (arrayList.size() == 1) {
                    if (((CharSequence) arrayList.get(0)).equals(GlobalApplication.m10283b().getString(R.string.menu_send_to_freechat))) {
                        m3089g();
                        return true;
                    }
                    if (((CharSequence) arrayList.get(0)).equals(GlobalApplication.m10283b().getString(R.string.menu_send_to_message))) {
                        m3090h();
                        return true;
                    }
                } else if (arrayList.size() == 0 && !C4822an.m18218a()) {
                    m3012P();
                    return true;
                }
                CharSequence[] charSequenceArr = (CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]);
                AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this);
                abstractC4932aM18733a.mo18740a(GlobalApplication.m10283b().getString(R.string.select_communication_type));
                abstractC4932aM18733a.mo18744a(charSequenceArr, new DialogInterfaceOnClickListenerC2171dz(this, arrayList));
                this.f2051T = abstractC4932aM18733a.mo18752b();
                this.f2051T.setCanceledOnTouchOutside(true);
                return true;
            case R.id.menu_updates /* 2131166648 */:
                startActivity(new Intent(this, (Class<?>) UpdatesActivity.class));
                return true;
            case R.id.menu_announcements /* 2131166649 */:
                Intent intent = new Intent(this, (Class<?>) ActivityWebView.class);
                intent.putExtra(FragmentWebView.PARAM_MENU, "Noti");
                intent.putExtra(FragmentWebView.SHOW_BREADCRUMB, true);
                startActivity(intent);
                return true;
            case R.id.menu_settings /* 2131166650 */:
                startActivity(new Intent(this, (Class<?>) SettingActivity.class));
                return true;
            case R.id.menu_help /* 2131166651 */:
                startActivity(new Intent(this, (Class<?>) ActivityGeneral.class));
                return true;
            default:
                return false;
        }
    }

    /* renamed from: g */
    protected void m3089g() {
        Intent intent = new Intent(getApplicationContext(), (Class<?>) BuddyActivity2.class);
        intent.putExtra("ACTIVITY_PURPOSE", 2);
        intent.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
        startActivity(intent);
    }

    /* renamed from: h */
    protected void m3090h() {
        if (C2349a.m10301a("sms_feature")) {
            startActivity(PluginComposeMessageActivity.m15925a(getApplicationContext(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public boolean m3008L() {
        boolean zM1495d;
        Exception e;
        try {
            zM1495d = new C0416a().m1495d(getApplicationContext());
        } catch (Exception e2) {
            zM1495d = false;
            e = e2;
        }
        try {
            C4904y.m18639b("[ChatONV] isReadyToCall : " + zM1495d, f2029t);
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            C4904y.m18639b("[ChatONV] isChatONVReadyToCall : " + zM1495d, f2029t);
            return zM1495d;
        }
        C4904y.m18639b("[ChatONV] isChatONVReadyToCall : " + zM1495d, f2029t);
        return zM1495d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public boolean m3009M() {
        boolean z = false;
        try {
            if (C2948h.m12190a().m12192a(getApplicationContext(), EnumC2949i.ChatONV)) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C4904y.m18639b("[ChatONV] isChatONVAvaiable : " + z, f2029t);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public boolean m3010N() {
        boolean z = false;
        new C0416a();
        try {
            if (C0416a.m1477b(getApplicationContext())) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C4904y.m18639b("[ChatONV] isChatONVInstalled : " + z, f2029t);
        return z;
    }

    @Override // com.sec.chaton.FlexibleActivity
    /* renamed from: f */
    protected BaseAdapter mo2911f() {
        if (this.f2059aD == null) {
            this.f2059aD = new C2317ek(this);
        }
        return this.f2059aD;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010d  */
    @Override // com.sec.chaton.FlexibleActivity
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void mo2906a(int r10) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.TabActivity.mo2906a(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3020a(Cursor cursor) {
        Message messageM10105c = C2244e.m10103a().m10105c();
        messageM10105c.obj = cursor;
        C2244e.m10103a().m10104b().sendMessage(messageM10105c);
    }

    @Override // com.sec.chaton.msgbox.InterfaceC2641bf
    /* renamed from: i */
    public void mo3091i() {
        startActivity(new Intent(this, (Class<?>) CallLogActivity.class));
    }

    @Override // com.sec.chaton.msgbox.InterfaceC2641bf
    /* renamed from: j */
    public void mo3092j() {
        startActivity(new Intent(this, (Class<?>) MsgboxSelectionActivity.class));
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x03fd  */
    @Override // com.sec.chaton.msgbox.InterfaceC2641bf
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo3084a(android.database.Cursor r13, boolean r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1030
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.TabActivity.mo3084a(android.database.Cursor, boolean):void");
    }

    @Override // com.sec.chaton.userprofile.InterfaceC4753bl
    /* renamed from: a */
    public void mo3083a(int i, boolean z) {
        Intent intent = new Intent(this, (Class<?>) ProfileImageHistoryActivity.class);
        if (z) {
            intent.putExtra("mSmallImageNum", i);
        }
        startActivity(intent);
    }

    @Override // com.sec.chaton.userprofile.InterfaceC4753bl
    /* renamed from: k */
    public void mo3093k() {
        startActivity(new Intent(this, (Class<?>) MyInfoActivity.class));
    }

    @Override // com.sec.chaton.userprofile.InterfaceC4753bl
    /* renamed from: a */
    public void mo3085a(String str, String str2) {
        Intent intent = new Intent(this, (Class<?>) BuddyDialog.class);
        intent.putExtra("BUDDY_DIALOG_BUDDY_NO", str);
        intent.putExtra("BUDDY_DIALOG_BUDDY_NAME", str2);
        if (this instanceof Activity) {
            intent.setFlags(67108864);
        } else {
            intent.setFlags(335544320);
        }
        startActivity(intent);
    }

    @Override // com.sec.chaton.buddy.InterfaceC1328gh
    /* renamed from: b */
    public void mo3088b(String str, String str2) {
        Intent intent = new Intent(this, (Class<?>) PostONImagePagerActivity.class);
        intent.putExtra("buddyId", str);
        intent.putExtra("url", str2);
        startActivity(intent);
    }

    @Override // com.sec.chaton.FlexibleActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.sec.chaton.trunk.InterfaceC4659cq
    /* renamed from: a */
    public void mo3086a(String str, String str2, String str3, String str4, EnumC4642g enumC4642g, int i, boolean z) {
        Intent intent = new Intent();
        intent.setClass(this, TrunkPageActivity.class);
        intent.putExtra("sessionId", str);
        intent.putExtra("inboxNo", str2);
        intent.putExtra("itemId", str3);
        intent.putExtra("isvalid", z);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3031b(boolean z) {
        Intent intent = new Intent(this, (Class<?>) ChatONVUpgradeDialog.class);
        intent.putExtra("isCritical", z);
        intent.putExtra("isFromHome", true);
        intent.setFlags(MotionRecognitionManager.EVENT_OVER_TURN_LOW_POWER);
        startActivity(intent);
    }

    /* renamed from: O */
    private boolean m3011O() {
        return C4809aa.m18104a().m18119a("chatonv_critical_update", (Boolean) false).booleanValue();
    }

    @Override // com.sec.chaton.util.InterfaceC4876cn
    public int getDefaultTheme() {
        return R.style.AppTheme_Home;
    }

    @Override // com.sec.chaton.util.InterfaceC4876cn
    public int getBlackTheme() {
        return R.style.AppTheme_Home;
    }

    /* renamed from: l */
    public int m3094l() {
        return this.f2061aF;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() throws Resources.NotFoundException {
        if (this.f2061aF == R.id.fragment_buddy) {
            BuddyFragment buddyFragment = (BuddyFragment) m50e().mo180a(this.f2061aF);
            if (buddyFragment != null && buddyFragment.m6605h() > 0) {
                buddyFragment.onBackKeyPressed();
                return;
            } else {
                super.onBackPressed();
                return;
            }
        }
        super.onBackPressed();
    }

    /* renamed from: m */
    public int m3095m() {
        return this.f2050S;
    }

    /* renamed from: P */
    private void m3012P() {
        if (C3892o.m15029d()) {
            String strM15022b = C3892o.m15022b(this);
            if (C4904y.f17872b) {
                C4904y.m18639b("checkSMSDefaultToast : " + strM15022b, f2029t);
            }
            if (!TextUtils.isEmpty(strM15022b)) {
                Toast.makeText(CommonApplication.m18732r(), getString(R.string.register_show_sms_default_toast, new Object[]{strM15022b}), 1).show();
            }
        }
    }
}
