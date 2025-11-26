package com.sec.chaton.buddy;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SyncInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.motion.MotionRecognitionManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.C0096i;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.sso.p030a.C0416a;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1071bk;
import com.sec.chaton.EnumC1094bm;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.InterfaceC2318el;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.account.C1002i;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.InterfaceC1061c;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.dialog.ChatONVInstallDialog;
import com.sec.chaton.buddy.dialog.ChatONVRedirectDialog;
import com.sec.chaton.buddy.dialog.GroupDialog;
import com.sec.chaton.buddy.dialog.MeDialog;
import com.sec.chaton.buddy.dialog.MultipleExpandableDialog;
import com.sec.chaton.buddy.dialog.PhoneNumberSelectorDialog;
import com.sec.chaton.buddy.p050a.C1104a;
import com.sec.chaton.buddy.p050a.C1105b;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.buddy.p050a.C1107d;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p055d.C2075ah;
import com.sec.chaton.p055d.C2126g;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p055d.C2133n;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p057e.C2228ap;
import com.sec.chaton.p057e.C2230ar;
import com.sec.chaton.p057e.C2268bn;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.p057e.C2293m;
import com.sec.chaton.p057e.C2294n;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p057e.p058a.C2191e;
import com.sec.chaton.p057e.p058a.C2192f;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p057e.p059b.C2244e;
import com.sec.chaton.p057e.p059b.C2249j;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.chaton.p065io.entry.inner.LiveGroupFollower;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.plugin.C2923b;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.settings.ActivityManageBuddy;
import com.sec.chaton.settings.ActivitySettings;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p102b.C3789h;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.specialbuddy.EnumC4549n;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4811ac;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4828at;
import com.sec.chaton.util.C4841bf;
import com.sec.chaton.util.C4851bp;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4874cl;
import com.sec.chaton.util.C4878cp;
import com.sec.chaton.util.C4883f;
import com.sec.chaton.util.C4884g;
import com.sec.chaton.util.C4892m;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4879cq;
import com.sec.chaton.util.InterfaceC4854bs;
import com.sec.chaton.widget.AdaptableTextView;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.tooltip.C5013c;
import com.sec.common.tooltip.ToolTipLayout;
import com.sec.common.util.C5033j;
import com.sec.common.util.log.collector.C5043h;
import com.sec.common.widget.HoneycombLinearLayout;
import com.sec.spp.push.Config;
import com.sec.widget.C5179v;
import com.sec.widget.ChoicePanel;
import com.sec.widget.EditTextWithClearButton;
import com.sec.widget.FastScrollableExpandableListView;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class BuddyFragment extends Fragment implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener, ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener, InterfaceC1061c, InterfaceC1121al, InterfaceC1122am, InterfaceC1123an, InterfaceC2318el {

    /* renamed from: bN */
    private static String f3578bN;

    /* renamed from: by */
    private static HashMap<String, String> f3580by;

    /* renamed from: j */
    public static HashMap<String, String> f3584j;

    /* renamed from: D */
    private TextView f3597D;

    /* renamed from: E */
    private C2210x f3598E;

    /* renamed from: F */
    private LinearLayout f3599F;

    /* renamed from: G */
    private ScrollView f3600G;

    /* renamed from: H */
    private LinearLayout f3601H;

    /* renamed from: I */
    private FastScrollableExpandableListView f3602I;

    /* renamed from: J */
    private TextView f3603J;

    /* renamed from: K */
    private EditTextWithClearButton f3604K;

    /* renamed from: M */
    private ViewStub f3606M;

    /* renamed from: N */
    private View f3607N;

    /* renamed from: O */
    private ImageView f3608O;

    /* renamed from: P */
    private TextView f3609P;

    /* renamed from: Q */
    private TextView f3610Q;

    /* renamed from: R */
    private LinearLayout f3611R;

    /* renamed from: S */
    private ImageView f3612S;

    /* renamed from: T */
    private View f3613T;

    /* renamed from: U */
    private Button f3614U;

    /* renamed from: V */
    private View f3615V;

    /* renamed from: W */
    private CheckedTextView f3616W;

    /* renamed from: Z */
    private String f3619Z;

    /* renamed from: aA */
    private C1113ad f3620aA;

    /* renamed from: aC */
    private ChoicePanel f3622aC;

    /* renamed from: aL */
    private int f3631aL;

    /* renamed from: aM */
    private String f3632aM;

    /* renamed from: aN */
    private String f3633aN;

    /* renamed from: aO */
    private String f3634aO;

    /* renamed from: aQ */
    private int f3636aQ;

    /* renamed from: aR */
    private TextView f3637aR;

    /* renamed from: aS */
    private String f3638aS;

    /* renamed from: aW */
    private Toast f3642aW;

    /* renamed from: aX */
    private C2210x f3643aX;

    /* renamed from: aY */
    private AlertDialogC1262dw f3644aY;

    /* renamed from: aZ */
    private C4851bp f3645aZ;

    /* renamed from: aa */
    private String f3646aa;

    /* renamed from: ab */
    private int f3647ab;

    /* renamed from: ac */
    private String[] f3648ac;

    /* renamed from: ad */
    private String f3649ad;

    /* renamed from: ae */
    private LinearLayout f3650ae;

    /* renamed from: af */
    private ImageButton f3651af;

    /* renamed from: ag */
    private ImageButton f3652ag;

    /* renamed from: ah */
    private ImageButton f3653ah;

    /* renamed from: ai */
    private ImageButton f3654ai;

    /* renamed from: aj */
    private ImageButton f3655aj;

    /* renamed from: ak */
    private ImageButton f3656ak;

    /* renamed from: al */
    private Bundle f3657al;

    /* renamed from: az */
    private C1106c f3671az;

    /* renamed from: bB */
    private C1106c f3673bB;

    /* renamed from: bC */
    private MenuItem f3674bC;

    /* renamed from: bD */
    private MenuItem f3675bD;

    /* renamed from: bE */
    private View f3676bE;

    /* renamed from: bF */
    private ClearableEditText f3677bF;

    /* renamed from: bG */
    private View f3678bG;

    /* renamed from: bH */
    private ImageButton f3679bH;

    /* renamed from: bJ */
    private int f3681bJ;

    /* renamed from: bK */
    private int f3682bK;

    /* renamed from: bL */
    private boolean f3683bL;

    /* renamed from: bM */
    private boolean f3684bM;

    /* renamed from: bQ */
    private View f3686bQ;

    /* renamed from: bR */
    private TextView f3687bR;

    /* renamed from: bW */
    private ArrayList<LiveGroupFollower> f3692bW;

    /* renamed from: bY */
    private C1259dt f3694bY;

    /* renamed from: ba */
    private View f3696ba;

    /* renamed from: bb */
    private TextView f3697bb;

    /* renamed from: bc */
    private ImageView f3698bc;

    /* renamed from: bd */
    private View f3699bd;

    /* renamed from: be */
    private View f3700be;

    /* renamed from: bf */
    private ImageView f3701bf;

    /* renamed from: bg */
    private TextView f3702bg;

    /* renamed from: bh */
    private TextView f3703bh;

    /* renamed from: bi */
    private String f3704bi;

    /* renamed from: bj */
    private boolean f3705bj;

    /* renamed from: bk */
    private C1106c f3706bk;

    /* renamed from: bm */
    private ArrayList<C1106c> f3708bm;

    /* renamed from: bn */
    private InterfaceC1257dr f3709bn;

    /* renamed from: bo */
    private HashMap<String, String> f3710bo;

    /* renamed from: bp */
    private boolean f3711bp;

    /* renamed from: br */
    private LinearLayout f3713br;

    /* renamed from: bx */
    private AbstractC4932a f3719bx;

    /* renamed from: ca */
    private HashSet<String> f3737ca;

    /* renamed from: cc */
    private HoneycombLinearLayout f3739cc;

    /* renamed from: ce */
    private HashMap<String, Boolean> f3741ce;

    /* renamed from: cf */
    private InterfaceC1261dv f3742cf;

    /* renamed from: cg */
    private InterfaceC1260du f3743cg;

    /* renamed from: ci */
    private CheckBox f3745ci;

    /* renamed from: cn */
    private int f3750cn;

    /* renamed from: co */
    private int f3751co;

    /* renamed from: cp */
    private int f3752cp;

    /* renamed from: cq */
    private int f3753cq;

    /* renamed from: cr */
    private int f3754cr;

    /* renamed from: f */
    protected C1105b f3763f;

    /* renamed from: g */
    public BuddyFragment f3764g;

    /* renamed from: h */
    boolean f3765h;

    /* renamed from: i */
    public C0416a f3766i;

    /* renamed from: a */
    public static final String f3576a = BuddyFragment.class.getSimpleName();

    /* renamed from: b */
    public static String f3577b = "purposeGroupProfile";

    /* renamed from: c */
    public static int f3581c = 0;

    /* renamed from: d */
    public static int f3582d = 0;

    /* renamed from: e */
    public static boolean f3583e = false;

    /* renamed from: k */
    public static boolean f3585k = false;

    /* renamed from: l */
    public static boolean f3586l = false;

    /* renamed from: m */
    public static String f3587m = "PROFILE_CHAT_ACTION";

    /* renamed from: n */
    public static String f3588n = "PROFILE_LIST_REFRESH_ACTION";

    /* renamed from: bP */
    private static boolean f3579bP = false;

    /* renamed from: o */
    public static int f3589o = 1;

    /* renamed from: p */
    public static int f3590p = 1;

    /* renamed from: q */
    public static int f3591q = 2;

    /* renamed from: r */
    public static int f3592r = 3;

    /* renamed from: s */
    public static boolean f3593s = false;

    /* renamed from: A */
    private boolean f3594A = false;

    /* renamed from: B */
    private int f3595B = 0;

    /* renamed from: C */
    private String f3596C = null;

    /* renamed from: L */
    private C2075ah f3605L = null;

    /* renamed from: X */
    private final boolean f3617X = false;

    /* renamed from: Y */
    private final boolean f3618Y = false;

    /* renamed from: am */
    private int f3658am = 11;

    /* renamed from: an */
    private int f3659an = 0;

    /* renamed from: ao */
    private int f3660ao = 1;

    /* renamed from: ap */
    private int f3661ap = 0;

    /* renamed from: aq */
    private String[] f3662aq = null;

    /* renamed from: ar */
    private String[] f3663ar = null;

    /* renamed from: as */
    private String[] f3664as = null;

    /* renamed from: at */
    private final ArrayList<C1104a> f3665at = new ArrayList<>();

    /* renamed from: au */
    private final ArrayList<ArrayList<C1106c>> f3666au = new ArrayList<>();

    /* renamed from: av */
    private final ArrayList<C1104a> f3667av = new ArrayList<>();

    /* renamed from: aw */
    private final ArrayList<ArrayList<C1106c>> f3668aw = new ArrayList<>();

    /* renamed from: ax */
    private final ArrayList<C1104a> f3669ax = new ArrayList<>();

    /* renamed from: ay */
    private final ArrayList<ArrayList<C1106c>> f3670ay = new ArrayList<>();

    /* renamed from: aB */
    private C1258ds f3621aB = null;

    /* renamed from: aD */
    private boolean f3623aD = false;

    /* renamed from: aE */
    private ProgressDialog f3624aE = null;

    /* renamed from: aF */
    private ProgressDialog f3625aF = null;

    /* renamed from: aG */
    private InterfaceC4936e f3626aG = null;

    /* renamed from: aH */
    private boolean f3627aH = true;

    /* renamed from: aI */
    private boolean f3628aI = false;

    /* renamed from: aJ */
    private boolean f3629aJ = false;

    /* renamed from: aK */
    private boolean f3630aK = false;

    /* renamed from: aP */
    private EnumC1094bm f3635aP = EnumC1094bm.INSIDE;

    /* renamed from: aT */
    private ArrayList<String> f3639aT = new ArrayList<>();

    /* renamed from: aU */
    private ArrayList<String> f3640aU = null;

    /* renamed from: aV */
    private final HashMap<String, String> f3641aV = new HashMap<>();

    /* renamed from: bl */
    private boolean f3707bl = false;

    /* renamed from: bq */
    private boolean f3712bq = false;

    /* renamed from: bs */
    private boolean f3714bs = false;

    /* renamed from: bt */
    private boolean f3715bt = false;

    /* renamed from: bu */
    private boolean f3716bu = false;

    /* renamed from: bv */
    private String f3717bv = "";

    /* renamed from: bw */
    private boolean f3718bw = false;

    /* renamed from: bz */
    private int f3720bz = -1;

    /* renamed from: bA */
    private int f3672bA = -1;

    /* renamed from: bI */
    private final boolean f3680bI = false;

    /* renamed from: bO */
    private final int f3685bO = -1;

    /* renamed from: bS */
    private final int f3688bS = 30;

    /* renamed from: bT */
    private boolean f3689bT = true;

    /* renamed from: bU */
    private boolean f3690bU = false;

    /* renamed from: bV */
    private int f3691bV = -1;

    /* renamed from: bX */
    private boolean f3693bX = false;

    /* renamed from: bZ */
    private boolean f3695bZ = false;

    /* renamed from: cb */
    private boolean f3738cb = false;

    /* renamed from: cd */
    private final String f3740cd = "unknown_buddy";

    /* renamed from: t */
    InterfaceC2211y f3767t = new C1195de(this);

    /* renamed from: u */
    View.OnClickListener f3768u = new ViewOnClickListenerC1252dm(this);

    /* renamed from: ch */
    private final View.OnClickListener f3744ch = new ViewOnClickListenerC1144bh(this);

    /* renamed from: cj */
    private final TextWatcher f3746cj = new C1147bk(this);

    /* renamed from: ck */
    private final ArrayList<String> f3747ck = new ArrayList<>();

    /* renamed from: cl */
    private final Handler f3748cl = new HandlerC1164ca(this);

    /* renamed from: cm */
    private final Handler f3749cm = new HandlerC1172ci(this);

    /* renamed from: v */
    Handler f3769v = new HandlerC1174ck(this);

    /* renamed from: w */
    InterfaceC2243d f3770w = new C1176cm(this);

    /* renamed from: x */
    InterfaceC2243d f3771x = new C1177cn(this);

    /* renamed from: cs */
    private int f3755cs = 0;

    /* renamed from: y */
    InterfaceC2243d f3772y = new C1178co(this);

    /* renamed from: z */
    ContentObserver f3773z = new C1180cq(this, new Handler());

    /* renamed from: ct */
    private final C0416a f3756ct = new C0416a();

    /* renamed from: cu */
    private final Handler f3757cu = new HandlerC1182cs(this);

    /* renamed from: cv */
    private int f3758cv = 0;

    /* renamed from: cw */
    private int f3759cw = -1;

    /* renamed from: cx */
    private int f3760cx = -1;

    /* renamed from: cy */
    private int f3761cy = 0;

    /* renamed from: cz */
    private boolean f3762cz = false;

    /* renamed from: cA */
    private int f3721cA = 0;

    /* renamed from: cB */
    private final InterfaceC4854bs f3722cB = new C1184cu(this);

    /* renamed from: cC */
    private final InterfaceC4854bs f3723cC = new C1185cv(this);

    /* renamed from: cD */
    private final Handler f3724cD = new HandlerC1186cw(this);

    /* renamed from: cE */
    private final BroadcastReceiver f3725cE = new C1187cx(this);

    /* renamed from: cF */
    private final BroadcastReceiver f3726cF = new C1188cy(this);

    /* renamed from: cG */
    private final BroadcastReceiver f3727cG = new C1189cz(this);

    /* renamed from: cH */
    private final BroadcastReceiver f3728cH = new C1191da(this);

    /* renamed from: cI */
    private final SlookAirButton.ItemSelectListener f3729cI = new C1192db(this);

    /* renamed from: cJ */
    private final View.OnClickListener f3730cJ = new ViewOnClickListenerC1194dd(this);

    /* renamed from: cK */
    private boolean f3731cK = false;

    /* renamed from: cL */
    private int f3732cL = 0;

    /* renamed from: cM */
    private int f3733cM = 0;

    /* renamed from: cN */
    private FrameLayout f3734cN = null;

    /* renamed from: cO */
    private ImageView f3735cO = null;

    /* renamed from: cP */
    private AdaptableTextView f3736cP = null;

    /* renamed from: a */
    public void m6590a(boolean z) {
        this.f3689bT = z;
    }

    @Override // com.sec.chaton.InterfaceC2318el
    /* renamed from: j_ */
    public void mo2964j_() throws Resources.NotFoundException {
        BaseActivity.m6160a((Fragment) this, true);
        if (this.f3660ao == 1) {
            if (m6605h() > 0) {
                f3585k = true;
            }
            ((ActionBarFragmentActivity) getActivity()).mo51u_();
        }
        this.f3765h = false;
        this.f3627aH = true;
        C4904y.m18639b("onTabSelected() : isShow : " + this.f3627aH + ", isChanged : " + Boolean.toString(this.f3628aI), f3576a);
        if (f3586l) {
            m6595b(true);
            f3586l = false;
        }
        if (this.f3628aI) {
            this.f3621aB.m7403b();
        }
        this.f3628aI = false;
        if (!C4809aa.m18104a().m18129b("contact_sim_sync")) {
            C4809aa.m18104a().m18125b("contact_sim_sync", (Boolean) true);
        }
        if (this.f3645aZ == null) {
            m6405ab();
        } else {
            this.f3645aZ.m18338a();
        }
        this.f3707bl = true;
        if (this.f3602I != null) {
            this.f3602I.setFastScrollEnabled(true);
        }
        if (!C4809aa.m18104a().m18119a("Is Group Uploaded", (Boolean) false).booleanValue()) {
            m6296G();
        }
        if (!C4809aa.m18104a().m18119a("Is DB Hide List Uploaded", (Boolean) false).booleanValue()) {
            m6298H();
        }
        if (m6605h() == 0) {
            m6608k();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        if (getActivity() != null) {
            C0096i.m358a(getActivity()).m362a(this.f3728cH, intentFilter);
        }
        if (this.f3701bf != null) {
            C2496n.m10763a(this.f3701bf, EnumC2498p.ROUND);
        }
        if (C4822an.m18218a()) {
            C5043h.m19179a().m19185a("1000", "2101", false);
        } else {
            C5043h.m19179a().m19185a("0100", "2108", false);
        }
        m6429an();
        if (this.f3734cN != null && this.f3734cN.getVisibility() != 0 && m6605h() <= 0) {
            this.f3734cN.setVisibility(0);
            m6352a(this.f3734cN, (View) this.f3713br, this.f3732cL, this.f3733cM, true);
        }
    }

    @Override // com.sec.chaton.InterfaceC2318el
    /* renamed from: k_ */
    public void mo2965k_() {
        BaseActivity.m6160a((Fragment) this, false);
        if (this.f3677bF != null && !TextUtils.isEmpty(this.f3677bF.m18658a().toString())) {
            f3586l = true;
        }
        if (this.f3677bF != null && !TextUtils.isEmpty(this.f3677bF.m18658a().toString())) {
            this.f3677bF.setText("");
        }
        m6304K();
        this.f3627aH = false;
        C0096i.m358a(getActivity()).m361a(this.f3728cH);
        C4904y.m18639b("onTabUnSelected() : " + this.f3627aH, f3576a);
        this.f3707bl = false;
        m6534h(false);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        C4904y.m18639b("onCreate()", f3576a);
        super.onCreate(bundle);
        this.f3764g = this;
        this.f3621aB = new C1258ds(this);
        this.f3642aW = C5179v.m19811a(getActivity(), (CharSequence) null, 0);
        getActivity().getContentResolver().registerContentObserver(C2289i.f8196a, true, this.f3773z);
        getActivity().getContentResolver().registerContentObserver(C2294n.f8205a, true, this.f3773z);
        getActivity().getContentResolver().registerContentObserver(C2293m.f8204a, true, this.f3773z);
        getActivity().getContentResolver().registerContentObserver(C2228ap.f7956a, true, this.f3773z);
        getActivity().getContentResolver().registerContentObserver(C2230ar.f7958a, true, this.f3773z);
        m6405ab();
        this.f3694bY = new C1259dt(this, null);
        C0991aa.m6037a().m18959a(this.f3694bY);
        this.f3766i = new C0416a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("buddy_tab_badge_update");
        C0096i.m358a(GlobalApplication.m18732r()).m362a(this.f3725cE, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("promotion_event_update");
        C0096i.m358a(GlobalApplication.m18732r()).m362a(this.f3726cF, intentFilter2);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws UnsupportedEncodingException {
        C4904y.m18639b("onCreateView()", f3576a);
        View viewInflate = layoutInflater.inflate(R.layout.buddy_layout2, viewGroup, false);
        m6415ag();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        C4904y.m18639b("onActivityCreated()", f3576a);
        if (getArguments() == null) {
            this.f3660ao = 1;
        } else {
            this.f3660ao = getArguments().getInt("ACTIVITY_PURPOSE", 1);
            this.f3661ap = getArguments().getInt("ACTIVITY_PURPOSE_ARG2");
            BaseActivity.m6160a((Fragment) this, true);
        }
        super.onActivityCreated(bundle);
        this.f3643aX = new C2210x(getActivity().getContentResolver(), this.f3767t);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            try {
                f3583e = bundle.getBoolean("savedInstanceStateCheck");
            } catch (NullPointerException e) {
                f3583e = false;
            }
            if (f3583e) {
                f3581c = bundle.getInt("INDEX");
                f3582d = bundle.getInt("TOP");
            }
            if (arguments.containsKey("content_type")) {
                this.f3631aL = arguments.getInt("content_type");
                C4904y.m18644d("Buddy content_type:" + this.f3631aL);
                this.f3630aK = true;
            }
            if (arguments.containsKey("download_uri")) {
                this.f3632aM = arguments.getString("download_uri");
                C4904y.m18644d("Buddy download_uri:" + this.f3632aM);
            }
            if (arguments.containsKey("sub_content")) {
                this.f3633aN = arguments.getString("sub_content");
                C4904y.m18644d("Buddy sub_content:" + this.f3633aN);
            }
            if (arguments.containsKey("forward_sender_name")) {
                this.f3634aO = arguments.getString("forward_sender_name");
                C4904y.m18644d("Buddy mForwardSenderName:" + this.f3634aO);
            }
            if (arguments.containsKey("is_forward_mode")) {
                this.f3711bp = arguments.getBoolean("is_forward_mode");
                C4904y.m18644d("Buddy mIsForward:" + this.f3711bp);
            }
            if (arguments.containsKey("forward_chat_message")) {
                this.f3712bq = arguments.getBoolean("forward_chat_message");
                C4904y.m18644d("Buddy mForwardFromShop:" + this.f3712bq);
            }
            if (arguments.containsKey(C1071bk.f3371e)) {
                this.f3635aP = (EnumC1094bm) arguments.get(C1071bk.f3371e);
                C4904y.m18644d("Buddy mForwardFrom:" + this.f3635aP);
            }
            if (arguments.containsKey("null")) {
                this.f3704bi = arguments.getString("null");
                C4904y.m18644d("Buddy mForwardFrom:" + this.f3635aP);
            }
            this.f3705bj = arguments.getBoolean("mShowChatONBuddies");
            C4904y.m18644d("Buddy mShowChatONBuddies:" + this.f3705bj);
        }
        m6292E();
        m6562r();
        this.f3616W.setOnClickListener(new ViewOnClickListenerC1133ax(this));
        this.f3696ba.setOnClickListener(new ViewOnClickListenerC1145bi(this));
        if ((this.f3660ao == 9 || this.f3660ao == 24 || this.f3660ao == 25) && bundle == null) {
            if (this.f3661ap == 1) {
                this.f3648ac = (String[]) getArguments().getStringArrayList("ACTIVITY_PURPOSE_ARG").toArray(new String[0]);
                m6440at();
            } else {
                this.f3639aT = getArguments().getStringArrayList("ACTIVITY_PURPOSE_ARG");
            }
        }
        if (this.f3660ao == 6 || this.f3660ao == 18 || this.f3660ao == 23) {
            m6569v();
        } else if (this.f3660ao != 1) {
            this.f3621aB.m7403b();
        }
        if (getActivity() instanceof InterfaceC1261dv) {
            this.f3742cf = (InterfaceC1261dv) getActivity();
        } else {
            this.f3742cf = new C1156bt(this);
        }
        this.f3677bF.setOnFocusChangeListener(new ViewOnFocusChangeListenerC1168ce(this));
    }

    /* renamed from: a */
    public void m6586a(InterfaceC1260du interfaceC1260du) {
        this.f3743cg = interfaceC1260du;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() throws Resources.NotFoundException {
        int i = 0;
        C4904y.m18639b("onStart() : " + this.f3627aH, f3576a);
        super.onStart();
        if (f3586l && this.f3660ao == 1) {
            m6595b(true);
            f3586l = false;
        }
        if (this.f3677bF != null && !TextUtils.isEmpty(this.f3677bF.m18658a().toString())) {
            this.f3677bF.m18659a(this.f3746cj);
            this.f3677bF.setText("");
        }
        if (this.f3660ao == 1 && this.f3665at.size() > 0) {
            boolean zBooleanValue = C4809aa.m18104a().m18119a("Profile Birth Chk", (Boolean) true).booleanValue();
            C4904y.m18639b("onStart() isShowBirthdayCategory : " + zBooleanValue, f3576a);
            if (zBooleanValue) {
                while (true) {
                    int i2 = i;
                    if (i2 < this.f3665at.size()) {
                        if (this.f3665at.get(i2).m7030d() != 0) {
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    } else {
                        if (m6284A()) {
                            m6371a(this.f3665at, this.f3666au);
                            return;
                        }
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = i;
                    if (i3 < this.f3665at.size()) {
                        if (this.f3665at.get(i3).m7030d() != 0) {
                            i = i3 + 1;
                        } else {
                            this.f3665at.remove(i3);
                            this.f3666au.remove(i3);
                            m6371a(this.f3665at, this.f3666au);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (C4892m.m18586g().compareTo(m6442au()) != 0 || f3593s) {
            boolean zBooleanValue = C4809aa.m18104a().m18119a("recomned_receive", (Boolean) true).booleanValue();
            m6433ap();
            m6437ar();
            this.f3702bg.setText(C4809aa.m18104a().m18121a("Push Name", ""));
            this.f3703bh.setText(C4809aa.m18104a().m18121a("status_message", ""));
            if (m6409ad()) {
                this.f3703bh.setCompoundDrawablesWithIntrinsicBounds(GlobalApplication.m10283b().getDrawable(R.drawable.buddies_videocall), (Drawable) null, (Drawable) null, (Drawable) null);
                this.f3703bh.setCompoundDrawablePadding(m6579a(7.0f));
            }
            this.f3627aH = true;
            C4904y.m18639b("onResume() : " + this.f3627aH, f3576a);
            C4904y.m18639b("isChanged : " + this.f3628aI, f3576a);
            this.f3621aB.m7408d();
            this.f3621aB.m7406c();
            this.f3621aB.m7403b();
            this.f3677bF.m18659a(this.f3746cj);
            this.f3677bF.setOnKeyListener(new ViewOnKeyListenerC1181cr(this));
            C4904y.m18639b("###mIsTabSelected: " + this.f3707bl, f3576a);
            if (this.f3707bl) {
                if (this.f3628aI) {
                    this.f3621aB.m7403b();
                } else {
                    this.f3628aI = false;
                }
                if (this.f3660ao == 1) {
                    this.f3621aB.m7410e();
                }
                if (this.f3637aR != null) {
                    if (zBooleanValue) {
                        this.f3621aB.m7412f();
                    } else {
                        m6594b(0);
                    }
                }
            }
            this.f3714bs = !TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""));
            this.f3715bt = C4822an.m18255w();
            if (C2349a.m10301a("for_wifi_only_device") || C4822an.m18196F()) {
                this.f3716bu = true;
            }
            if (m6605h() == 0) {
                m6608k();
            }
            if (this.f3750cn - this.f3752cp <= 0) {
                if (this.f3714bs && this.f3715bt && !this.f3716bu) {
                    if (this.f3607N != null) {
                        this.f3607N.setVisibility(8);
                    }
                    if (this.f3660ao == 1 || this.f3660ao == 7) {
                        this.f3601H.setVisibility(0);
                        this.f3611R.setVisibility(0);
                        this.f3612S.setBackgroundResource(R.drawable.upgrade_info_character);
                        this.f3613T.setVisibility(0);
                        this.f3614U.setEnabled(true);
                    } else {
                        this.f3601H.setVisibility(8);
                    }
                } else if (this.f3714bs && this.f3715bt && this.f3716bu) {
                    this.f3611R.setVisibility(8);
                    this.f3613T.setVisibility(0);
                    this.f3614U.setEnabled(true);
                    m6351a(this.f3606M);
                } else {
                    this.f3611R.setVisibility(8);
                    this.f3613T.setVisibility(8);
                    m6351a(this.f3606M);
                }
            } else {
                this.f3600G.setVisibility(8);
                this.f3613T.setVisibility(8);
            }
            if (this.f3677bF != null && this.f3677bF.hasFocus()) {
                m6301J();
            }
            m6329X();
            if (this.f3641aV != null && this.f3660ao != 19) {
                this.f3641aV.clear();
            }
            if (this.f3660ao == 1) {
                if (m6605h() > 0) {
                    f3585k = true;
                } else {
                    f3585k = false;
                }
            }
            C2496n.m10763a(this.f3701bf, EnumC2498p.ROUND);
            if (C4892m.m18586g().compareTo(m6442au()) == 0) {
                f3593s = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public int m6557p() {
        return C2923b.m12153h(getActivity()) ? 1 : -1;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        this.f3627aH = false;
        f3585k = false;
        this.f3677bF.m18661b(this.f3746cj);
        m6289D();
        C4904y.m18639b("onPause() : " + this.f3627aH, f3576a);
        super.onPause();
        m6304K();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        C4904y.m18639b("onStop()", f3576a);
        try {
            this.f3677bF.m18661b(this.f3746cj);
        } catch (Exception e) {
        }
        m6305L();
        m6308M();
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.f3621aB.m7399a();
        getActivity().getApplicationContext().getContentResolver().unregisterContentObserver(this.f3773z);
        C0096i.m358a(getActivity()).m361a(this.f3728cH);
        C0096i.m358a(getActivity()).m361a(this.f3725cE);
        if (this.f3644aY != null && this.f3644aY.isShowing()) {
            this.f3644aY.dismiss();
        }
        if (this.f3602I != null) {
            this.f3602I.setAdapter((ExpandableListAdapter) null);
            this.f3602I.setOnGroupClickListener(null);
            this.f3602I.setOnGroupCollapseListener(null);
            this.f3602I.setOnGroupExpandListener(null);
            this.f3602I.setOnChildClickListener(null);
            this.f3602I.setOnScrollListener(null);
            this.f3602I = null;
        }
        if (this.f3620aA != null) {
            this.f3620aA.m7117a();
            this.f3620aA.m7119a((BuddyFragment) null);
            this.f3620aA.m7120a((InterfaceC1121al) null);
            this.f3620aA.m7121a((InterfaceC1122am) null);
            this.f3620aA.m7122a((InterfaceC1123an) null);
            this.f3620aA = null;
        }
        if (this.f3701bf != null) {
            this.f3701bf.setImageBitmap(null);
            this.f3701bf = null;
        }
        if (this.f3611R != null) {
            this.f3611R.removeAllViews();
            this.f3611R = null;
        }
        C0991aa.m6037a().m18960b(this.f3694bY);
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getResources().getConfiguration().orientation == 1) {
            if (this.f3604K != null) {
                this.f3604K.f18749c.clearFocus();
            }
            m6418ai();
            m6608k();
        } else if (getResources().getConfiguration().orientation == 2 && this.f3677bF != null && this.f3677bF.m18658a().toString().length() > 0 && this.f3660ao == 1) {
            m6421aj();
            this.f3713br.setVisibility(8);
        }
        if (this.f3734cN != null && m6605h() <= 0 && this.f3707bl) {
            this.f3734cN.setVisibility(0);
            m6352a(this.f3734cN, (View) this.f3713br, this.f3732cL, this.f3733cM, true);
        }
    }

    /* renamed from: q */
    private boolean m6560q() {
        return (this.f3623aD || this.f3721cA == 2 || this.f3721cA == 3 || this.f3721cA == 4) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x005e  */
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m6562r() {
        /*
            Method dump skipped, instructions count: 1821
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyFragment.m6562r():void");
    }

    /* renamed from: a */
    public C1106c m6580a(String[] strArr) {
        if (this.f3620aA != null) {
            ArrayList<ArrayList<C1106c>> arrayListM7126c = this.f3620aA.m7126c();
            for (int i = 0; i < arrayListM7126c.size(); i++) {
                for (int i2 = 0; i2 < arrayListM7126c.get(i).size(); i2++) {
                    if (arrayListM7126c.get(i).get(i2).m7074w() && arrayListM7126c.get(i).get(i2).m7076y().size() == strArr.length && m6593a(arrayListM7126c.get(i).get(i2).m7076y().keySet(), strArr)) {
                        C4904y.m18641c("get selected buddy group : group name - " + arrayListM7126c.get(i).get(i2).m7051b(), getClass().getSimpleName());
                        return arrayListM7126c.get(i).get(i2);
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean m6593a(Set<String> set, String[] strArr) {
        boolean z = true;
        for (String str : strArr) {
            if (!set.contains(str)) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: c */
    private void m6483c(int i) {
        AbstractC4932a.m18733a(getActivity()).mo18734a(R.string.pop_up_attention).mo18746b(R.string.dev_network_error).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC1141be(this, i)).mo18747b(R.string.dialog_cancel, (DialogInterface.OnClickListener) null).mo18745a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6494d(int i) {
        int iM1488a;
        if (!m6312O()) {
            m6483c(i);
            return;
        }
        if (m6557p() == 1) {
            if (m6411ae()) {
                if (m6409ad()) {
                    int i2 = 0;
                    for (int i3 = 0; i3 < m6604g().length; i3++) {
                        String strM9836e = C2190d.m9836e(GlobalApplication.m18732r().getContentResolver(), m6604g()[i3]);
                        String strM9839f = C2190d.m9839f(GlobalApplication.m18732r().getContentResolver(), m6604g()[i3]);
                        if (!TextUtils.isEmpty(strM9836e) && !TextUtils.isEmpty(strM9839f) && strM9836e.contains("voip=1")) {
                            i2++;
                        }
                    }
                    if (i2 != 0 && i2 <= this.f3766i.m1493b((Context) getActivity(), false) - 1) {
                        if (m6604g().length <= 1) {
                            iM1488a = this.f3766i.m1487a(getActivity(), false, m6604g()[0], C4809aa.m18104a().m18121a("Push Name", ""), null);
                        } else {
                            this.f3673bB = m6580a(m6604g());
                            if (this.f3673bB != null && m6605h() == this.f3673bB.m7076y().size() && this.f3602I.m19641a((String[]) this.f3673bB.m7076y().keySet().toArray(new String[0]))) {
                                iM1488a = this.f3766i.m1488a(getActivity(), false, m6604g(), C4809aa.m18104a().m18121a("Push Name", ""), null, this.f3673bB.m7051b());
                            } else {
                                iM1488a = this.f3766i.m1488a(getActivity(), false, m6604g(), C4809aa.m18104a().m18121a("Push Name", ""), null, null);
                            }
                        }
                        if (iM1488a != 0) {
                            C5179v.m19810a(getActivity(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                            return;
                        }
                        return;
                    }
                    return;
                }
                startActivity(new Intent(getActivity(), (Class<?>) ChatONVInstallDialog.class));
                return;
            }
            if (!m6413af()) {
                startActivity(new Intent(getActivity(), (Class<?>) ChatONVRedirectDialog.class));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m6506e(int i) {
        int iM1488a;
        if (!m6312O()) {
            m6483c(i);
            return;
        }
        if (m6557p() == 1) {
            if (m6411ae()) {
                if (m6409ad()) {
                    int i2 = 0;
                    for (int i3 = 0; i3 < m6604g().length; i3++) {
                        String strM9836e = C2190d.m9836e(GlobalApplication.m18732r().getContentResolver(), m6604g()[i3]);
                        String strM9839f = C2190d.m9839f(GlobalApplication.m18732r().getContentResolver(), m6604g()[i3]);
                        if (!TextUtils.isEmpty(strM9836e) && !TextUtils.isEmpty(strM9839f) && strM9836e.contains("voip=1")) {
                            i2++;
                        }
                    }
                    if (i2 != 0 && i2 <= this.f3766i.m1493b((Context) getActivity(), true) - 1) {
                        if (m6604g().length <= 1) {
                            iM1488a = this.f3766i.m1487a(getActivity(), true, m6604g()[0], C4809aa.m18104a().m18121a("Push Name", ""), null);
                        } else {
                            this.f3673bB = m6580a(m6604g());
                            if (this.f3673bB != null && m6605h() == this.f3673bB.m7076y().size() && this.f3602I.m19641a((String[]) this.f3673bB.m7076y().keySet().toArray(new String[0]))) {
                                iM1488a = this.f3766i.m1488a(getActivity(), true, m6604g(), C4809aa.m18104a().m18121a("Push Name", ""), null, this.f3673bB.m7051b());
                            } else {
                                iM1488a = this.f3766i.m1488a(getActivity(), true, m6604g(), C4809aa.m18104a().m18121a("Push Name", ""), null, null);
                            }
                        }
                        if (iM1488a != 0) {
                            C5179v.m19810a(getActivity(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                            return;
                        }
                        return;
                    }
                    return;
                }
                startActivity(new Intent(getActivity(), (Class<?>) ChatONVInstallDialog.class));
                return;
            }
            if (!m6413af()) {
                startActivity(new Intent(getActivity(), (Class<?>) ChatONVRedirectDialog.class));
            }
        }
    }

    /* renamed from: s */
    private void m6564s() {
        m6581a(-1);
    }

    /* renamed from: a */
    void m6581a(int i) {
        String string;
        String string2;
        C4904y.m18639b("setTitle() : " + i, "BuddyFragment");
        if (this.f3660ao == 1) {
            string = null;
        } else if (this.f3660ao == 2 || this.f3660ao == 3 || this.f3660ao == 15 || this.f3660ao == 14) {
            string = getString(R.string.buddy_selected);
        } else if (this.f3660ao == 12) {
            string = getString(R.string.tab_chat);
        } else if (this.f3660ao == 5) {
            string = getString(R.string.buddy_selected);
        } else if (this.f3660ao == 20) {
            string = null;
        } else if (this.f3660ao == 9 || this.f3660ao == 24 || this.f3660ao == 25 || this.f3660ao == 10) {
            string = getString(R.string.buddy_selected);
        } else if (this.f3660ao == 7) {
            string = null;
        } else if (this.f3660ao == 6 && this.f3657al != null && this.f3657al.containsKey("ACTIVITY_PURPOSE_ARG") && !this.f3657al.getBoolean("ACTIVITY_PURPOSE_ARG")) {
            string = getString(R.string.buddy_selected);
        } else if (this.f3660ao == 6 && this.f3657al != null && !this.f3657al.containsKey("ACTIVITY_PURPOSE_CALLLOG_GROUP")) {
            string = getString(R.string.chat_view_menu_info2);
        } else if (this.f3660ao == 18 || this.f3660ao == 19) {
            string = null;
        } else if (this.f3660ao == 23) {
            string = getString(R.string.buddy_selected);
        } else {
            if (this.f3660ao == 1000) {
                string2 = getString(R.string.buddy_selected);
            } else {
                string2 = getString(R.string.buddy_select_no_list_select_buddies);
            }
            ((ActionBarFragmentActivity) getActivity()).mo51u_();
            if (this.f3660ao == 8) {
                if (this.f3661ap > 0) {
                    string2 = getString(this.f3661ap);
                } else {
                    string2 = getString(R.string.chatview_menu_forward);
                }
            }
            if (this.f3595B == 0) {
                i = -1;
                string = string2;
            } else {
                string = string2;
            }
        }
        if (string != null && i >= 0) {
            string = string + " (" + i + ")";
        }
        if (string != null) {
            getActivity().setTitle(string);
        }
    }

    /* renamed from: a */
    public void m6587a(String str, String str2) throws Resources.NotFoundException {
        if (this.f3602I != null) {
            m6592a(str, !this.f3602I.m19643b(str), str2, false, true);
        }
    }

    /* renamed from: a */
    public void m6588a(String str, boolean z, String str2) throws Resources.NotFoundException {
        m6592a(str, z, str2, false, true);
    }

    /* renamed from: a */
    public boolean m6592a(String str, boolean z, String str2, boolean z2, boolean z3) throws Resources.NotFoundException {
        int i = 0;
        if (this.f3602I == null) {
            return false;
        }
        if (z) {
            if (m6334Z()) {
                this.f3602I.setChildChecked(str, z);
                if (this.f3595B == 2 && str2 == null) {
                    C1106c c1106cM6341a = m6341a(str, this.f3666au);
                    if (c1106cM6341a == null) {
                        this.f3739cc.setVisibility(8);
                        return true;
                    }
                    this.f3622aC.m19615a(str, c1106cM6341a.m7051b());
                }
            } else {
                if (getActivity().getIntent().getStringExtra("fromsms") != null) {
                    AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(getActivity());
                    abstractC4932aM18733a.mo18753c(android.R.drawable.ic_dialog_alert);
                    abstractC4932aM18733a.mo18749b(getResources().getString(R.string.max_recipient_limit_exceed, Integer.valueOf(this.f3760cx)));
                    abstractC4932aM18733a.mo18756d(R.string.ok_button, new DialogInterfaceOnClickListenerC1142bf(this));
                    abstractC4932aM18733a.mo18734a(R.string.chat_alert).mo18752b();
                    return false;
                }
                if (this.f3602I != null && this.f3602I.m19639a(str) != z) {
                    m6403aa();
                    return false;
                }
            }
        } else {
            this.f3602I.setChildChecked(str, z);
            if (this.f3595B == 2) {
                this.f3622aC.m19614a(str);
            }
        }
        if (z2) {
            return true;
        }
        if (this.f3742cf != null && this.f3602I != null) {
            this.f3742cf.mo6198a(this.f3602I.m19638a());
        }
        if (m6605h() == 0) {
            this.f3739cc.setVisibility(8);
            f3589o = f3590p;
        } else if (this.f3660ao == 1 || this.f3660ao == 1000 || this.f3660ao == 23) {
            if (z3) {
                C1106c c1106cM6341a2 = m6341a(str, this.f3666au);
                if (m6557p() != 1 || c1106cM6341a2 != null) {
                }
            }
        } else {
            this.f3739cc.setVisibility(8);
        }
        if (this.f3660ao == 1) {
            this.f3693bX = false;
            String[] strArrM6604g = m6604g();
            while (true) {
                if (i < strArrM6604g.length) {
                    C1106c c1106cM6341a3 = m6341a(strArrM6604g[i], this.f3666au);
                    if (c1106cM6341a3 == null || c1106cM6341a3.m7043F().compareTo(Spam.ACTIVITY_REPORT) != 0) {
                        i++;
                    } else {
                        this.f3693bX = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (this.f3660ao != 1000 || this.f3638aS == null || this.f3638aS.equals("voip")) {
        }
        return true;
    }

    /* renamed from: f */
    private boolean m6518f(int i) {
        if (getActivity().getIntent().getStringExtra("fromsms") == null || i < this.f3760cx) {
            return false;
        }
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(getActivity());
        abstractC4932aM18733a.mo18753c(android.R.drawable.ic_dialog_alert);
        abstractC4932aM18733a.mo18749b(getResources().getString(R.string.max_recipient_limit_exceed, Integer.valueOf(this.f3760cx)));
        abstractC4932aM18733a.mo18756d(R.string.ok_button, new DialogInterfaceOnClickListenerC1143bg(this));
        abstractC4932aM18733a.mo18734a(R.string.chat_alert).mo18752b();
        return true;
    }

    @TargetApi(14)
    /* renamed from: a */
    public static void m6346a(ClipData clipData, C1106c c1106c, Context context) {
        int iM10076a;
        Intent intent = new Intent(context, (Class<?>) ChatActivity.class);
        intent.setFlags(67108864);
        if (c1106c.m7074w()) {
            intent.putExtra("chatType", EnumC2300t.GROUPCHAT.m10210a());
            intent.putExtra("groupId", c1106c.m7046a());
            intent.putExtra("receivers", (String[]) c1106c.m7076y().keySet().toArray(new String[0]));
        } else {
            intent.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
            intent.putExtra("receivers", new String[]{c1106c.m7046a()});
        }
        if (clipData != null) {
            if (ClipDescription.compareMimeTypes(clipData.getDescription().getMimeType(0), "image/*")) {
                iM10076a = EnumC2214ab.IMAGE.m10076a();
            } else {
                iM10076a = ClipDescription.compareMimeTypes(clipData.getDescription().getMimeType(0), "video/*") ? EnumC2214ab.VIDEO.m10076a() : 0;
            }
            ClipData.Item itemAt = clipData.getItemAt(0);
            if (itemAt.getUri() != null) {
                Uri uri = itemAt.getUri();
                if (iM10076a == EnumC2214ab.VIDEO.m10076a()) {
                    intent.putExtra("content_type", EnumC2214ab.VIDEO.m10076a());
                    intent.putExtra("download_uri", uri.toString());
                } else if (iM10076a == EnumC2214ab.IMAGE.m10076a()) {
                    intent.putExtra("content_type", EnumC2214ab.IMAGE.m10076a());
                    intent.putExtra("download_uri", uri.toString());
                } else {
                    intent.putExtra("content_type", EnumC2214ab.UNDEFINED.m10076a());
                    intent.putExtra("download_uri", uri.toString());
                }
            } else {
                intent.putExtra("content_type", EnumC2214ab.UNDEFINED.m10076a());
            }
            intent.setFlags(67108864);
            intent.putExtra("is_forward_mode", false);
            intent.putExtra("forward_chat_message", false);
            intent.putExtra(C1071bk.f3371e, EnumC1094bm.INSIDE);
            intent.putExtra("is_attach_on_the_edittext", true);
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_clipdata", clipData);
            intent.putExtras(bundle);
            intent.putExtra("buddy_dragdata", true);
            context.startActivity(intent);
        }
    }

    @TargetApi(14)
    /* renamed from: a */
    public static void m6347a(ClipData clipData, String[] strArr, Context context) {
        int iM10076a;
        Uri uri;
        Intent intentM2915a = HomeActivity.m2915a(context, true);
        intentM2915a.setFlags(67108864);
        if (strArr.length == 1) {
            intentM2915a.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
        } else {
            intentM2915a.putExtra("chatType", EnumC2300t.GROUPCHAT.m10210a());
        }
        intentM2915a.putExtra("receivers", strArr);
        if (clipData != null) {
            if (clipData.getItemCount() > 1) {
                Toast.makeText(GlobalApplication.m18732r(), "file type not supported...", 0).show();
            }
            if (ClipDescription.compareMimeTypes(clipData.getDescription().getMimeType(0), "image/")) {
                iM10076a = EnumC2214ab.IMAGE.m10076a();
            } else if (ClipDescription.compareMimeTypes(clipData.getDescription().getMimeType(0), "video/")) {
                iM10076a = EnumC2214ab.VIDEO.m10076a();
            } else {
                Toast.makeText(GlobalApplication.m18732r(), "file type not supported...", 0).show();
                iM10076a = 0;
            }
            ClipData.Item itemAt = clipData.getItemAt(0);
            if (itemAt.getUri() != null) {
                uri = itemAt.getUri();
            } else {
                Toast.makeText(GlobalApplication.m18732r(), "file loading error....", 0).show();
                uri = null;
            }
            if (uri != null) {
                if (iM10076a == EnumC2214ab.VIDEO.m10076a()) {
                    intentM2915a.putExtra("content_type", EnumC2214ab.VIDEO.m10076a());
                    intentM2915a.putExtra("download_uri", uri.toString());
                } else if (iM10076a == EnumC2214ab.IMAGE.m10076a()) {
                    intentM2915a.putExtra("content_type", EnumC2214ab.IMAGE.m10076a());
                    intentM2915a.putExtra("download_uri", uri.toString());
                }
            }
            context.startActivity(intentM2915a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m6565t() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3747ck.size() || !m6592a(this.f3747ck.get(i2), true, (String) null, true, true)) {
                break;
            } else {
                i = i2 + 1;
            }
        }
        if (this.f3742cf != null) {
            this.f3742cf.mo6198a(this.f3602I.m19638a());
        }
    }

    /* renamed from: b */
    public void m6595b(boolean z) throws Resources.NotFoundException {
        for (int i = 0; i < this.f3666au.size(); i++) {
            ArrayList<C1106c> arrayList = this.f3666au.get(i);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                m6592a(arrayList.get(i2).m7046a(), false, (String) null, z, true);
            }
        }
        if (getView() != null) {
            this.f3739cc.setVisibility(8);
            m6608k();
            f3585k = false;
            ((ActionBarFragmentActivity) getActivity()).mo51u_();
            if (this.f3742cf != null) {
                this.f3742cf.mo6198a(this.f3602I.m19638a());
            }
            f3589o = f3590p;
        }
    }

    /* renamed from: b */
    public void m6596b(String[] strArr) throws Resources.NotFoundException {
        for (String str : strArr) {
            m6592a(str, false, (String) null, false, false);
        }
        if (this.f3742cf != null) {
            this.f3742cf.mo6198a(this.f3602I.m19638a());
        }
    }

    /* renamed from: d */
    private boolean m6502d(String str) {
        if (this.f3638aS == null) {
            return true;
        }
        return mo6597b(m6341a(str, this.f3666au));
    }

    @Override // com.sec.chaton.buddy.InterfaceC1123an
    /* renamed from: b */
    public boolean mo6597b(C1106c c1106c) {
        return this.f3638aS == null || c1106c == null || c1106c.m7074w() || c1106c.m7050a(this.f3638aS);
    }

    @Override // com.sec.chaton.buddy.InterfaceC1121al
    /* renamed from: a */
    public void mo6583a(C1106c c1106c) {
        this.f3671az = c1106c;
        m6326V();
        C2128i c2128i = new C2128i(this.f3769v);
        this.f3717bv = c1106c.m7051b();
        c2128i.m9508b(c1106c.m7046a());
    }

    /* renamed from: a */
    public void m6589a(ArrayList<ArrayList<C1106c>> arrayList) throws Resources.NotFoundException {
        if ((this.f3595B == 1 || this.f3595B == 2) && this.f3602I != null) {
            Iterator<String> it = this.f3602I.m19642b().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (m6341a(next, this.f3666au) == null) {
                    m6592a(next, false, (String) null, true, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m6567u() {
        this.f3660ao = 7;
        this.f3599F.setVisibility(8);
        this.f3600G.setVisibility(0);
        if (C2349a.m10301a("sms_feature") && !C4822an.m18218a()) {
            this.f3601H.setVisibility(8);
        } else {
            this.f3601H.setVisibility(0);
        }
        this.f3602I.setFastScrollEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m6569v() {
        if (this.f3660ao == 7) {
            this.f3660ao = 1;
        }
        C4904y.m18639b("viewBuddyList() : " + this.f3660ao, f3576a);
        if (this.f3669ax.size() <= 0 && this.f3677bF != null && this.f3670ay.size() <= 0 && TextUtils.isEmpty(this.f3677bF.m18658a().toString())) {
            this.f3602I.setVisibility(0);
            this.f3615V.setVisibility(8);
        }
        this.f3599F.setVisibility(0);
        this.f3600G.setVisibility(8);
        this.f3601H.setVisibility(8);
        this.f3613T.setVisibility(8);
        if (this.f3620aA == null) {
            this.f3620aA = new C1113ad(this.f3602I, getActivity(), this.f3667av, R.layout.layout_common_group_header, this.f3668aw, R.layout.list_item_common_7, this.f3595B != 0, m6560q(), this, false, this.f3729cI, this.f3695bZ);
            this.f3620aA.m7119a(this);
            this.f3620aA.m7118a(this.f3660ao);
            this.f3620aA.m7125b(this.f3638aS);
            if (this.f3660ao == 6 && this.f3657al.containsKey("ACTIVITY_PURPOSE_ARG") && this.f3657al.getBoolean("ACTIVITY_PURPOSE_ARG")) {
                View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.chat_info_header, (ViewGroup) this.f3602I, false);
                viewInflate.setFocusable(true);
                ((ViewGroup) viewInflate).setDescendantFocusability(MotionRecognitionManager.EVENT_CALL_POSE);
                this.f3602I.addHeaderView(viewInflate, null, false);
                ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(R.id.alert_layout);
                this.f3745ci = (CheckBox) viewInflate.findViewById(android.R.id.checkbox);
                viewGroup.setFocusable(true);
                viewGroup.setBackgroundResource(R.drawable.listview_selector);
                viewGroup.setPadding((int) getActivity().getResources().getDimension(R.dimen.li4_padding_left), (int) getActivity().getResources().getDimension(R.dimen.li4_padding_top), (int) getActivity().getResources().getDimension(R.dimen.li4_padding_right), (int) getActivity().getResources().getDimension(R.dimen.li4_padding_bottom));
                viewGroup.setOnFocusChangeListener(new ViewOnFocusChangeListenerC1146bj(this));
                this.f3745ci.setDuplicateParentStateEnabled(true);
                this.f3745ci.setEnabled(true);
                this.f3602I.setItemsCanFocus(true);
                this.f3620aA.m7120a((InterfaceC1121al) this);
            }
            if (this.f3660ao == 18) {
                m6572w();
            }
            f3579bP = false;
            if (this.f3660ao == 1 || this.f3660ao == 1000) {
                this.f3620aA.m7121a((InterfaceC1122am) this);
            }
            if (this.f3660ao == 23) {
                this.f3620aA.m7121a((InterfaceC1122am) this);
                this.f3620aA.m7120a((InterfaceC1121al) this);
            }
            this.f3602I.setAdapter(this.f3620aA);
            m6574x();
            if (this.f3708bm == null || this.f3708bm.size() == 0) {
                this.f3621aB.m7400a(21);
            }
        }
    }

    /* renamed from: w */
    private void m6572w() {
        this.f3602I.addHeaderView(LayoutInflater.from(getActivity()).inflate(R.layout.buddy_group_profile, (ViewGroup) this.f3602I, false));
        this.f3602I.setItemsCanFocus(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m6574x() {
        if (!this.f3623aD) {
            C4904y.m18639b("refreshList()", f3576a);
            if (this.f3677bF != null) {
                this.f3677bF.m18661b(this.f3746cj);
                this.f3677bF.m18659a(this.f3746cj);
            }
            if (this.f3620aA != null) {
                this.f3621aB.m7400a(this.f3658am);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public void m6576y() {
        C4904y.m18639b("forceRefreshList()", f3576a);
        if (this.f3677bF != null) {
            this.f3677bF.m18661b(this.f3746cj);
            this.f3677bF.setText("");
            this.f3623aD = false;
            this.f3677bF.m18659a(this.f3746cj);
        }
        if (this.f3620aA != null) {
            this.f3621aB.m7400a(this.f3658am);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public boolean m6577z() {
        ArrayList<C1106c> arrayList = new ArrayList<>();
        arrayList.add(new C1106c(getResources().getString(R.string.setting_interaction_me), C4809aa.m18104a().m18121a("Push Name", ""), C4809aa.m18104a().m18121a("status_message", ""), "", "", "", false, 0, "", false, 0, 0, 0, 0, 0, 0, 0, false, false, 0, "", 0));
        if (arrayList.size() > 0) {
            this.f3665at.add(0, new C1104a(1, getResources().getString(R.string.setting_interaction_me), arrayList.size(), -2, false, false, 0));
            this.f3666au.add(0, arrayList);
        }
        return arrayList.size() > 0;
    }

    /* renamed from: a */
    private boolean m6373a(Cursor cursor) {
        C4904y.m18639b("addFavoriteDataSetFromCursor " + cursor, f3576a);
        ArrayList<C1106c> arrayList = new ArrayList<>();
        int columnIndex = cursor.getColumnIndex("group_type");
        int columnIndex2 = cursor.getColumnIndex("buddy_no");
        int columnIndex3 = cursor.getColumnIndex("buddy_name");
        int columnIndex4 = cursor.getColumnIndex("buddy_status_message");
        int columnIndex5 = cursor.getColumnIndex("buddy_samsung_email");
        int columnIndex6 = getActivity().getIntent().getStringExtra("fromsms") != null ? cursor.getColumnIndex("buddy_phonenumber_external_use") : cursor.getColumnIndex("buddy_orginal_number");
        int columnIndex7 = cursor.getColumnIndex("buddy_birthday");
        int columnIndex8 = cursor.getColumnIndex("buddy_relation_hide");
        int columnIndex9 = cursor.getColumnIndex("buddy_raw_contact_id");
        int columnIndex10 = cursor.getColumnIndex("buddy_push_name");
        int columnIndex11 = cursor.getColumnIndex("buddy_is_new");
        int columnIndex12 = cursor.getColumnIndex("relation_send");
        int columnIndex13 = cursor.getColumnIndex("relation_received");
        int columnIndex14 = cursor.getColumnIndex("relation_point");
        int columnIndex15 = cursor.getColumnIndex("relation_icon");
        int columnIndex16 = cursor.getColumnIndex("relation_increase");
        int columnIndex17 = cursor.getColumnIndex("relation_rank");
        int columnIndex18 = cursor.getColumnIndex("buddy_profile_status");
        int columnIndex19 = cursor.getColumnIndex("buddy_is_profile_updated");
        int columnIndex20 = cursor.getColumnIndex("buddy_is_status_updated");
        int columnIndex21 = cursor.getColumnIndex("buddy_show_phone_number");
        int columnIndex22 = cursor.getColumnIndex("buddy_extra_info");
        cursor.getColumnIndex("buddy_is_hide");
        int columnIndex23 = cursor.getColumnIndex("buddy_account_info");
        int columnIndex24 = cursor.getColumnIndex("buddy_sainfo");
        int columnIndex25 = cursor.getColumnIndex("buddy_contact_buddy");
        cursor.moveToPosition(-1);
        while (cursor.moveToNext() && cursor.getInt(columnIndex) <= 1) {
            String string = "";
            if (cursor.getColumnIndex("buddy_phonenumber_external_use") != -1) {
                string = cursor.getString(cursor.getColumnIndex("buddy_phonenumber_external_use"));
            }
            if (getActivity().getIntent().getExtra("fromsms") == null || cursor.getInt(columnIndex23) != 1) {
                C1106c c1106c = new C1106c(cursor.getString(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4), cursor.getString(columnIndex5), cursor.getString(columnIndex6), cursor.getString(columnIndex7), !"Y".equals(cursor.getString(columnIndex8)), cursor.getInt(columnIndex9), cursor.getString(columnIndex10), "Y".equals(cursor.getString(columnIndex11)), cursor.getInt(columnIndex12), cursor.getInt(columnIndex13), cursor.getInt(columnIndex14), cursor.getInt(columnIndex15), cursor.getInt(columnIndex16), cursor.getInt(columnIndex17), cursor.getInt(columnIndex18), "Y".equals(cursor.getString(columnIndex19)), "Y".equals(cursor.getString(columnIndex20)), cursor.getInt(columnIndex21), cursor.getString(columnIndex22), cursor.getInt(columnIndex23), cursor.getString(columnIndex24), cursor.getString(columnIndex25), string);
                if (this.f3738cb && this.f3737ca.contains(cursor.getString(columnIndex2))) {
                    c1106c.m7053b(true);
                }
                arrayList.add(c1106c);
            }
        }
        if (arrayList.size() > 0) {
            this.f3665at.add(new C1104a(1, getResources().getString(R.string.buddy_list_group_favorites), arrayList.size(), 1, false, false, 0));
            this.f3666au.add(arrayList);
        }
        return arrayList.size() > 0;
    }

    /* renamed from: b */
    private boolean m6462b(Cursor cursor) {
        String strValueOf;
        String string;
        boolean z;
        if (getActivity().getIntent().getStringExtra("fromsms") != null) {
            return false;
        }
        if (this.f3660ao == 1000 && this.f3638aS != null && this.f3638aS.equals("voip")) {
            return false;
        }
        C4904y.m18639b("addGroupDataSetFromCursor " + cursor, f3576a);
        ArrayList<C1106c> arrayList = new ArrayList<>();
        if (this.f3660ao != 19) {
            strValueOf = null;
        } else {
            strValueOf = String.valueOf(this.f3763f.m7034a());
        }
        int columnIndex = cursor.getColumnIndex("group_name");
        int columnIndex2 = cursor.getColumnIndex("buddy_no");
        int columnIndex3 = cursor.getColumnIndex("buddy_email");
        int columnIndex4 = cursor.getColumnIndex("buddy_samsung_email");
        int columnIndex5 = cursor.getColumnIndex("buddy_is_new");
        int columnIndex6 = cursor.getColumnIndex("buddy_extra_info");
        cursor.moveToPrevious();
        while (cursor.moveToNext()) {
            if (!TextUtils.isEmpty(cursor.getString(columnIndex2)) && (string = cursor.getString(columnIndex)) != null && string.length() != 0) {
                C1106c c1106c = new C1106c(cursor.getString(columnIndex2), cursor.getString(columnIndex), null, null, null, null, true, 0, cursor.getString(columnIndex), "Y".equals(cursor.getString(columnIndex5)), 0, 0, 0, 0, 0, 0, 0, false, false, 0);
                HashMap<String, String> map = new HashMap<>();
                String str = "%%" + cursor.getString(columnIndex2) + "%%";
                c1106c.m7049a(true);
                String[] strArrSplit = null;
                String[] strArrSplit2 = null;
                String[] strArrSplit3 = null;
                if (cursor.getString(columnIndex3) != null) {
                    strArrSplit = cursor.getString(columnIndex3).split(str);
                }
                if (cursor.getString(columnIndex4) != null) {
                    strArrSplit2 = cursor.getString(columnIndex4).split(str);
                }
                if (cursor.getString(columnIndex6) != null) {
                    strArrSplit3 = cursor.getString(columnIndex6).split(str);
                }
                if (this.f3660ao == 15 || this.f3660ao == 14) {
                    if (strArrSplit3 != null && strArrSplit3.length == strArrSplit2.length) {
                        int length = strArrSplit3.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                z = false;
                                break;
                            }
                            if (strArrSplit3[i].contains("voip=1")) {
                                i++;
                            } else {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                        }
                    }
                }
                if (strArrSplit != null && strArrSplit2 != null) {
                    if (strArrSplit.length > 0 && strArrSplit.length == strArrSplit2.length) {
                        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                            map.put(strArrSplit[i2], strArrSplit2[i2]);
                        }
                    }
                    c1106c.m7048a(map);
                }
                if (strValueOf != null && c1106c.m7046a() != null && c1106c.m7046a().equals(strValueOf)) {
                    this.f3640aU = new ArrayList<>();
                    if (strArrSplit != null && strArrSplit.length > 0) {
                        for (String str2 : strArrSplit) {
                            this.f3640aU.add(str2);
                        }
                    }
                } else if (c1106c.m7076y() != null) {
                    arrayList.add(c1106c);
                } else {
                    try {
                        C2212z.m10068a(new C2212z(), -1, new C2249j(this.f3770w, Integer.parseInt(c1106c.m7046a())));
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            this.f3665at.add(new C1104a(1, getResources().getString(R.string.buddy_list_optionmenu_sortby_group), arrayList.size(), 4, false, false, 0));
            this.f3666au.add(arrayList);
        }
        return arrayList.size() > 0;
    }

    /* renamed from: a */
    private void m6348a(Cursor cursor, boolean z) {
        String str;
        boolean z2;
        int i;
        C1104a c1104a;
        int i2;
        C4904y.m18639b("addBuddiesByNameDataSetFromCursor " + cursor, f3576a);
        ArrayList<C1106c> arrayList = new ArrayList<>();
        HashMap map = new HashMap();
        String str2 = "\u0000";
        int columnIndex = cursor.getColumnIndex("buddy_no");
        int columnIndex2 = cursor.getColumnIndex("buddy_name");
        int columnIndex3 = cursor.getColumnIndex("buddy_status_message");
        int columnIndex4 = cursor.getColumnIndex("buddy_samsung_email");
        int columnIndex5 = getActivity().getIntent().getStringExtra("fromsms") != null ? cursor.getColumnIndex("buddy_phonenumber_external_use") : cursor.getColumnIndex("buddy_orginal_number");
        int columnIndex6 = cursor.getColumnIndex("buddy_birthday");
        int columnIndex7 = cursor.getColumnIndex("buddy_relation_hide");
        int columnIndex8 = cursor.getColumnIndex("buddy_raw_contact_id");
        int columnIndex9 = cursor.getColumnIndex("buddy_push_name");
        int columnIndex10 = cursor.getColumnIndex("buddy_is_new");
        int columnIndex11 = cursor.getColumnIndex("buddy_profile_status");
        int columnIndex12 = cursor.getColumnIndex("buddy_is_profile_updated");
        int columnIndex13 = cursor.getColumnIndex("buddy_is_status_updated");
        int columnIndex14 = cursor.getColumnIndex("buddy_show_phone_number");
        int columnIndex15 = cursor.getColumnIndex("buddy_extra_info");
        int columnIndex16 = cursor.getColumnIndex("buddy_hanzitopinyin");
        int columnIndex17 = cursor.getColumnIndex("buddy_account_info");
        int columnIndex18 = cursor.getColumnIndex("buddy_sainfo");
        int columnIndexOrThrow = z ? cursor.getColumnIndexOrThrow("relation_send") : -1;
        int columnIndexOrThrow2 = z ? cursor.getColumnIndexOrThrow("relation_received") : -1;
        int columnIndexOrThrow3 = z ? cursor.getColumnIndexOrThrow("relation_point") : -1;
        int columnIndexOrThrow4 = z ? cursor.getColumnIndexOrThrow("relation_icon") : -1;
        int columnIndexOrThrow5 = z ? cursor.getColumnIndexOrThrow("relation_increase") : -1;
        int columnIndexOrThrow6 = z ? cursor.getColumnIndexOrThrow("relation_rank") : -1;
        int columnIndex19 = cursor.getColumnIndex("group_name");
        int columnIndex20 = cursor.getColumnIndex("buddy_is_hide");
        int columnIndex21 = cursor.getColumnIndex("buddy_contact_buddy");
        int columnIndex22 = cursor.getColumnIndex("buddy_phonenumber_external_use");
        this.f3747ck.clear();
        this.f3752cp = 0;
        this.f3754cr = 0;
        cursor.moveToPosition(-1);
        String strM18292d = null;
        int i3 = 2;
        ArrayList<C1106c> arrayList2 = arrayList;
        while (cursor.moveToNext()) {
            String string = "";
            if (cursor.getColumnIndex("buddy_phonenumber_external_use") != -1) {
                string = cursor.getString(columnIndex22);
            }
            if (this.f3660ao != 1000 || this.f3638aS == null || !this.f3638aS.equals("voip") || (!TextUtils.isEmpty(cursor.getString(columnIndex15)) && !TextUtils.isEmpty(cursor.getString(columnIndex18)) && cursor.getString(columnIndex15).contains("voip=1"))) {
                if (cursor.getString(columnIndex21) != null && cursor.getString(columnIndex21).compareTo(Spam.ACTIVITY_REPORT) == 0) {
                    this.f3754cr++;
                }
                if ((this.f3660ao != 23 && !this.f3695bZ) || cursor.getString(columnIndex21) == null || cursor.getString(columnIndex21).compareTo(Spam.ACTIVITY_REPORT) == 0) {
                    if (this.f3660ao != 1) {
                        if (this.f3660ao == 8 || this.f3660ao == 10 || this.f3660ao == 19 || this.f3660ao == 9 || this.f3660ao == 24 || this.f3660ao == 25) {
                            if (C4822an.m18218a()) {
                                if (cursor.getString(columnIndex21) == null || cursor.getString(columnIndex21).compareTo(Spam.ACTIVITY_REPORT) != 0) {
                                }
                            } else if (cursor.getString(columnIndex21) == null || cursor.getString(columnIndex21).compareTo(Spam.ACTIVITY_REPORT) == 0) {
                            }
                        } else if (this.f3660ao == 5) {
                            if (getArguments() == null || !getArguments().containsKey("chatType") || getArguments().getInt("chatType") != EnumC2300t.BROADCAST2.m10210a() || !C4822an.m18218a() || cursor.getString(columnIndex21) == null || cursor.getString(columnIndex21).compareTo(Spam.ACTIVITY_REPORT) != 0) {
                            }
                        } else if (this.f3660ao == 1000 || cursor.getString(columnIndex21) == null || cursor.getString(columnIndex21).compareTo(Spam.ACTIVITY_REPORT) == 0) {
                        }
                    }
                    if (columnIndex19 == -1 || cursor.getString(columnIndex19) == null || cursor.getString(columnIndex19) == null) {
                        if (columnIndex16 != -1) {
                            strM18292d = cursor.getString(columnIndex16);
                        }
                        if (TextUtils.isEmpty(strM18292d)) {
                            strM18292d = C4828at.m18276a().m18292d(cursor.getString(columnIndex2));
                        }
                        if (strM18292d != null && strM18292d.trim().length() != 0) {
                            str = strM18292d;
                        } else if (this.f3594A) {
                            str = ".";
                        }
                        if (columnIndex19 > 0) {
                            String string2 = cursor.getString(columnIndex19);
                            if (this.f3660ao == 10 && string2 != null && string2.length() != 0) {
                                strM18292d = str;
                            }
                        }
                        if (columnIndex20 == -1 || cursor.getString(columnIndex20) == null || !cursor.getString(columnIndex20).equals("Y")) {
                            String str3 = C4841bf.m18318a(Character.toUpperCase(str.charAt(0))) + "";
                            if (cursor.getString(columnIndex21) == null || cursor.getString(columnIndex21).compareTo(Spam.ACTIVITY_REPORT) != 0) {
                                z2 = false;
                                str2 = str3;
                            } else if (C4822an.m18218a()) {
                                z2 = true;
                                str2 = getResources().getString(R.string.vcard_type_other) + " - " + C4841bf.m18318a(Character.toUpperCase(str.charAt(0))) + "";
                            } else {
                                z2 = true;
                                str2 = C4841bf.m18318a(Character.toUpperCase(str.charAt(0))) + "";
                            }
                            C1106c c1106c = new C1106c(cursor.getString(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4), cursor.getString(columnIndex5), cursor.getString(columnIndex6), !"Y".equals(cursor.getString(columnIndex7)), cursor.getInt(columnIndex8), cursor.getString(columnIndex9), "Y".equals(cursor.getString(columnIndex10)), z ? cursor.getInt(columnIndexOrThrow) : 0, z ? cursor.getInt(columnIndexOrThrow2) : 0, z ? cursor.getInt(columnIndexOrThrow3) : 0, z ? cursor.getInt(columnIndexOrThrow4) : 0, z ? cursor.getInt(columnIndexOrThrow5) : 0, z ? cursor.getInt(columnIndexOrThrow6) : 0, cursor.getInt(columnIndex11), "Y".equals(cursor.getString(columnIndex12)), "Y".equals(cursor.getString(columnIndex13)), cursor.getInt(columnIndex14), cursor.getString(columnIndex15), cursor.getInt(columnIndex17), cursor.getString(columnIndex18), cursor.getString(columnIndex21), string);
                            if (this.f3738cb && this.f3737ca.contains(cursor.getString(columnIndex))) {
                                c1106c.m7053b(true);
                            }
                            if (getActivity().getIntent().getStringExtra("fromsms") == null || !TextUtils.isEmpty(c1106c.m7056e())) {
                                arrayList2.add(c1106c);
                                this.f3747ck.add(c1106c.m7046a());
                                if (map.get(str2) == null) {
                                    this.f3666au.add(arrayList2);
                                    if (z2) {
                                        c1104a = new C1104a(i3, str2, arrayList2.size(), 5, false, false, 0);
                                        i2 = i3 + 1;
                                    } else {
                                        c1104a = new C1104a(i3, str2, arrayList2.size(), 2, false, false, 0);
                                        i2 = i3 + 1;
                                    }
                                    this.f3665at.add(c1104a);
                                    map.put(str2, c1104a);
                                    i = i2;
                                } else {
                                    int iIndexOf = this.f3665at.indexOf((C1104a) map.get(str2));
                                    ArrayList<C1106c> arrayList3 = this.f3666au.get(iIndexOf);
                                    arrayList3.addAll(arrayList2);
                                    this.f3666au.set(iIndexOf, arrayList3);
                                    C1104a c1104a2 = this.f3665at.get(iIndexOf);
                                    c1104a2.m7027a(arrayList3.size());
                                    this.f3665at.set(iIndexOf, c1104a2);
                                    map.put(str2, c1104a2);
                                    i = i3;
                                }
                                i3 = i;
                                arrayList2 = new ArrayList<>();
                                strM18292d = str;
                            } else {
                                strM18292d = str;
                            }
                        } else {
                            this.f3752cp++;
                            strM18292d = str;
                        }
                    }
                }
            }
        }
        if (arrayList2.size() > 0) {
            int i4 = i3 + 1;
            this.f3665at.add(new C1104a(i3, String.valueOf(str2), arrayList2.size(), 2, false, false, 0));
            this.f3666au.add(arrayList2);
        }
        if (this.f3742cf != null) {
            this.f3742cf.mo6199b(this.f3747ck.size());
        }
        if (this.f3660ao == 1000 && this.f3638aS != null && this.f3638aS.equals("voip") && this.f3666au.size() == 0 && this.f3719bx == null) {
            this.f3719bx = AbstractC4932a.m18733a(getActivity());
            this.f3719bx.mo18740a(getResources().getString(R.string.poll_list_empty_title));
            this.f3719bx.mo18749b(getResources().getString(R.string.poll_list_empty_title)).mo18751b(true).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC1148bl(this));
            this.f3719bx.mo18752b();
        }
        if (C4822an.m18218a()) {
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= this.f3665at.size()) {
                    break;
                }
                if (this.f3665at.get(i6).m7030d() == 5) {
                    int iIndexOf2 = this.f3665at.indexOf((C1104a) map.get(this.f3665at.get(i6).m7028b()));
                    ArrayList<C1106c> arrayList7 = this.f3666au.get(iIndexOf2);
                    arrayList5.add(arrayList7);
                    C1104a c1104a3 = this.f3665at.get(iIndexOf2);
                    c1104a3.m7027a(arrayList7.size());
                    arrayList6.add(Integer.valueOf(iIndexOf2));
                    arrayList4.add(c1104a3);
                }
                i5 = i6 + 1;
            }
            for (int i7 = 0; i7 < arrayList4.size(); i7++) {
                this.f3665at.remove(arrayList4.get(i7));
            }
            for (int i8 = 0; i8 < arrayList5.size(); i8++) {
                this.f3666au.remove(arrayList5.get(i8));
            }
            this.f3665at.addAll(arrayList4);
            this.f3666au.addAll(arrayList5);
            arrayList6.clear();
            arrayList5.clear();
            arrayList4.clear();
        }
        map.clear();
    }

    /* renamed from: c */
    private void m6484c(Cursor cursor) {
        int i;
        C4904y.m18639b("addBuddiesByRelationDataSetFromCursor " + cursor, f3576a);
        ArrayList<C1106c> arrayList = new ArrayList<>();
        int i2 = -1;
        int columnIndex = cursor.getColumnIndex("buddy_no");
        int columnIndex2 = cursor.getColumnIndex("buddy_name");
        int columnIndex3 = cursor.getColumnIndex("buddy_status_message");
        int columnIndex4 = cursor.getColumnIndex("buddy_samsung_email");
        int columnIndex5 = cursor.getColumnIndex("buddy_orginal_number");
        int columnIndex6 = cursor.getColumnIndex("buddy_birthday");
        int columnIndex7 = cursor.getColumnIndex("buddy_relation_hide");
        int columnIndex8 = cursor.getColumnIndex("buddy_raw_contact_id");
        int columnIndex9 = cursor.getColumnIndex("buddy_push_name");
        int columnIndex10 = cursor.getColumnIndex("buddy_is_new");
        int columnIndex11 = cursor.getColumnIndex("relation_send");
        int columnIndex12 = cursor.getColumnIndex("relation_received");
        int columnIndex13 = cursor.getColumnIndex("relation_point");
        int columnIndex14 = cursor.getColumnIndex("relation_icon");
        int columnIndex15 = cursor.getColumnIndex("relation_increase");
        int columnIndex16 = cursor.getColumnIndex("relation_rank");
        int columnIndex17 = cursor.getColumnIndex("buddy_profile_status");
        int columnIndex18 = cursor.getColumnIndex("buddy_is_profile_updated");
        int columnIndex19 = cursor.getColumnIndex("buddy_is_status_updated");
        int columnIndex20 = cursor.getColumnIndex("buddy_show_phone_number");
        int columnIndex21 = cursor.getColumnIndex("buddy_extra_info");
        int columnIndex22 = cursor.getColumnIndex("buddy_is_hide");
        int columnIndex23 = cursor.getColumnIndex("buddy_account_info");
        int columnIndex24 = cursor.getColumnIndex("buddy_sainfo");
        int columnIndex25 = cursor.getColumnIndex("buddy_contact_buddy");
        this.f3747ck.clear();
        this.f3752cp = 0;
        this.f3754cr = 0;
        cursor.moveToPrevious();
        int i3 = 0;
        while (cursor.moveToNext()) {
            int i4 = cursor.getInt(columnIndex13);
            String string = "";
            if (cursor.getColumnIndex("buddy_phonenumber_external_use") != -1) {
                string = cursor.getString(cursor.getColumnIndex("buddy_phonenumber_external_use"));
            }
            if (columnIndex22 != -1 && cursor.getString(columnIndex22).equals("Y")) {
                this.f3752cp++;
            } else {
                if (cursor.getString(columnIndex25) != null && cursor.getString(columnIndex25).compareTo(Spam.ACTIVITY_REPORT) == 0) {
                    this.f3754cr++;
                }
                if ((this.f3660ao != 23 && !this.f3695bZ) || cursor.getString(columnIndex25) == null || cursor.getString(columnIndex25).compareTo(Spam.ACTIVITY_REPORT) == 0) {
                    if (this.f3660ao != 1) {
                        if (this.f3660ao == 8) {
                            if (C4822an.m18218a()) {
                                if (cursor.getString(columnIndex25) == null || cursor.getString(columnIndex25).compareTo(Spam.ACTIVITY_REPORT) != 0) {
                                }
                            } else if (cursor.getString(columnIndex25) == null || cursor.getString(columnIndex25).compareTo(Spam.ACTIVITY_REPORT) == 0) {
                            }
                        } else if (cursor.getString(columnIndex25) == null || cursor.getString(columnIndex25).compareTo(Spam.ACTIVITY_REPORT) != 0) {
                        }
                    }
                    C1106c c1106c = new C1106c(cursor.getString(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4), cursor.getString(columnIndex5), cursor.getString(columnIndex6), !"Y".equals(cursor.getString(columnIndex7)), cursor.getInt(columnIndex8), cursor.getString(columnIndex9), "Y".equals(cursor.getString(columnIndex10)), cursor.getInt(columnIndex11), cursor.getInt(columnIndex12), cursor.getInt(columnIndex13), cursor.getInt(columnIndex14), cursor.getInt(columnIndex15), cursor.getInt(columnIndex16), cursor.getInt(columnIndex17), "Y".equals(cursor.getString(columnIndex18)), "Y".equals(cursor.getString(columnIndex19)), cursor.getInt(columnIndex20), cursor.getString(columnIndex21), cursor.getInt(columnIndex23), cursor.getString(columnIndex24), cursor.getString(columnIndex25), string);
                    if (this.f3738cb && this.f3737ca.contains(cursor.getString(columnIndex))) {
                        c1106c.m7053b(true);
                    }
                    arrayList.add(c1106c);
                    this.f3747ck.add(c1106c.m7046a());
                    i3 = cursor.getInt(columnIndex13) > 0 ? i3 + 1 : i3;
                    i2 = i4;
                }
            }
        }
        if (arrayList.size() > 0) {
            if (i3 > 30) {
                i3 = 30;
            }
            if (arrayList.size() < i3) {
                this.f3665at.add(new C1104a(2, getResources().getString(R.string.buddy_list_best_buddies) + "", arrayList.size(), 6, false, false, i2));
                this.f3666au.add(arrayList);
            } else {
                if (i3 <= 0) {
                    i = 2;
                } else {
                    ArrayList<C1106c> arrayList2 = new ArrayList<>(arrayList.subList(0, i3));
                    this.f3665at.add(new C1104a(2, getResources().getString(R.string.buddy_list_best_buddies) + "", arrayList2.size(), 6, false, false, i2));
                    this.f3666au.add(arrayList2);
                    i = 3;
                }
                if (arrayList.size() > i3) {
                    ArrayList<C1106c> arrayList3 = new ArrayList<>(arrayList.subList(i3, arrayList.size()));
                    int i5 = i + 1;
                    this.f3665at.add(new C1104a(i, getResources().getString(R.string.chaton_contacts_tab) + "", arrayList3.size(), 6, false, false, i2));
                    this.f3666au.add(arrayList3);
                }
            }
        }
        if (this.f3742cf != null) {
            this.f3742cf.mo6199b(this.f3747ck.size());
        }
    }

    /* renamed from: d */
    private void m6495d(Cursor cursor) {
        int i;
        C4904y.m18639b("addChatonvDataSetFromCursor " + cursor, f3576a);
        ArrayList<C1106c> arrayList = new ArrayList<>();
        ArrayList<C1106c> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        int columnIndex = cursor.getColumnIndex("buddy_no");
        int columnIndex2 = cursor.getColumnIndex("buddy_name");
        int columnIndex3 = cursor.getColumnIndex("buddy_status_message");
        int columnIndex4 = cursor.getColumnIndex("buddy_samsung_email");
        int columnIndex5 = cursor.getColumnIndex("buddy_orginal_number");
        int columnIndex6 = cursor.getColumnIndex("buddy_birthday");
        int columnIndex7 = cursor.getColumnIndex("buddy_relation_hide");
        int columnIndex8 = cursor.getColumnIndex("buddy_raw_contact_id");
        int columnIndex9 = cursor.getColumnIndex("buddy_push_name");
        int columnIndex10 = cursor.getColumnIndex("buddy_is_new");
        int columnIndex11 = cursor.getColumnIndex("relation_send");
        int columnIndex12 = cursor.getColumnIndex("relation_received");
        int columnIndex13 = cursor.getColumnIndex("relation_point");
        int columnIndex14 = cursor.getColumnIndex("relation_icon");
        int columnIndex15 = cursor.getColumnIndex("relation_increase");
        int columnIndex16 = cursor.getColumnIndex("relation_rank");
        int columnIndex17 = cursor.getColumnIndex("buddy_profile_status");
        int columnIndex18 = cursor.getColumnIndex("buddy_is_profile_updated");
        int columnIndex19 = cursor.getColumnIndex("buddy_is_status_updated");
        int columnIndex20 = cursor.getColumnIndex("buddy_show_phone_number");
        int columnIndex21 = cursor.getColumnIndex("buddy_extra_info");
        int columnIndex22 = cursor.getColumnIndex("buddy_account_info");
        int columnIndex23 = cursor.getColumnIndex("buddy_sainfo");
        int columnIndex24 = cursor.getColumnIndex("group_type");
        int columnIndex25 = cursor.getColumnIndex("group_name");
        int columnIndex26 = cursor.getColumnIndex("buddy_is_hide");
        int columnIndex27 = cursor.getColumnIndex("buddy_hanzitopinyin");
        int columnIndex28 = cursor.getColumnIndex("buddy_contact_buddy");
        this.f3747ck.clear();
        this.f3754cr = 0;
        try {
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                String string = "";
                if (cursor.getColumnIndex("buddy_phonenumber_external_use") != -1) {
                    string = cursor.getString(cursor.getColumnIndex("buddy_phonenumber_external_use"));
                }
                if (cursor.getString(cursor.getColumnIndex("buddy_no")) == null || !cursor.getString(cursor.getColumnIndex("buddy_no")).startsWith("0999")) {
                    if ((this.f3660ao != 23 && !this.f3695bZ) || cursor.getString(columnIndex28) == null || cursor.getString(columnIndex28).compareTo(Spam.ACTIVITY_REPORT) == 0) {
                        if (cursor.getString(columnIndex28) != null && cursor.getString(columnIndex28).compareTo(Spam.ACTIVITY_REPORT) == 0) {
                            this.f3754cr++;
                        }
                        if (this.f3660ao != 1) {
                            if (this.f3660ao == 8) {
                                if (C4822an.m18218a()) {
                                    if (cursor.getString(columnIndex28) == null || cursor.getString(columnIndex28).compareTo(Spam.ACTIVITY_REPORT) != 0) {
                                    }
                                } else if (cursor.getString(columnIndex28) == null || cursor.getString(columnIndex28).compareTo(Spam.ACTIVITY_REPORT) == 0) {
                                }
                            } else if (cursor.getString(columnIndex28) == null || cursor.getString(columnIndex28).compareTo(Spam.ACTIVITY_REPORT) == 0) {
                            }
                        }
                        String strM18292d = null;
                        if (columnIndex27 != -1) {
                            strM18292d = cursor.getString(columnIndex27);
                        }
                        if (TextUtils.isEmpty(strM18292d)) {
                            strM18292d = C4828at.m18276a().m18292d(cursor.getString(columnIndex2));
                        }
                        if (strM18292d != null && strM18292d.trim().length() != 0 && (columnIndex25 == -1 || cursor.getString(columnIndex25) == null || cursor.getString(columnIndex25) == null)) {
                            if (columnIndex25 > 0) {
                                String string2 = cursor.getString(columnIndex25);
                                if (this.f3660ao != 10 || string2 == null || string2.length() == 0) {
                                }
                            }
                            if (columnIndex26 == -1 || cursor.getString(columnIndex26) == null || !cursor.getString(columnIndex26).equals("Y")) {
                                C1106c c1106c = new C1106c(cursor.getString(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4), cursor.getString(columnIndex5), cursor.getString(columnIndex6), !"Y".equals(cursor.getString(columnIndex7)), cursor.getInt(columnIndex8), cursor.getString(columnIndex9), "Y".equals(cursor.getString(columnIndex10)), cursor.getInt(columnIndex11), cursor.getInt(columnIndex12), cursor.getInt(columnIndex13), cursor.getInt(columnIndex14), cursor.getInt(columnIndex15), cursor.getInt(columnIndex16), cursor.getInt(columnIndex17), "Y".equals(cursor.getString(columnIndex18)), "Y".equals(cursor.getString(columnIndex19)), cursor.getInt(columnIndex20), cursor.getString(columnIndex21), cursor.getInt(columnIndex22), cursor.getString(columnIndex23), cursor.getString(columnIndex28), string);
                                if (this.f3738cb && this.f3737ca.contains(cursor.getString(columnIndex))) {
                                    c1106c.m7053b(true);
                                }
                                if (cursor.getInt(columnIndex24) != 1) {
                                    if (c1106c.m7040C() != null && !TextUtils.isEmpty(c1106c.m7058g()) && c1106c.m7040C().contains("voip=1")) {
                                        arrayList.add(c1106c);
                                    } else if (cursor.getString(columnIndex28).compareTo(Spam.ACTIVITY_REPORT) == 0) {
                                        arrayList3.add(c1106c);
                                    } else {
                                        arrayList2.add(c1106c);
                                    }
                                    this.f3747ck.add(c1106c.m7046a());
                                }
                            }
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.f3665at.add(new C1104a(2, getResources().getString(R.string.chatonv_contacts) + "", arrayList.size(), 6, false, false, 0));
                this.f3666au.add(arrayList);
                i = 3;
            } else {
                i = 2;
            }
            if (arrayList2.size() > 0 || arrayList3.size() > 0) {
                int i2 = i + 1;
                this.f3665at.add(new C1104a(i, getResources().getString(R.string.chaton_contacts_tab) + "", arrayList2.size() + arrayList3.size(), 6, false, false, 0));
                arrayList2.addAll(arrayList3);
                this.f3666au.add(arrayList2);
            }
            if (this.f3742cf != null) {
                this.f3742cf.mo6199b(this.f3747ck.size());
            }
        } catch (IllegalArgumentException e) {
            C4904y.m18634a("addChatonvDataSetFromCursor " + e.getMessage(), getClass().getSimpleName());
        }
    }

    /* renamed from: e */
    private boolean m6510e(Cursor cursor) {
        if (cursor == null) {
            return false;
        }
        C4904y.m18639b("addSpecialBuddyDataSet " + cursor, f3576a);
        ArrayList<C1106c> arrayList = new ArrayList<>();
        int columnIndex = cursor.getColumnIndex("buddy_no");
        int columnIndex2 = cursor.getColumnIndex("buddy_name");
        int columnIndex3 = cursor.getColumnIndex("buddy_status_message");
        int columnIndex4 = cursor.getColumnIndex("buddy_is_new");
        int columnIndex5 = cursor.getColumnIndex("buddy_is_hide");
        int columnIndex6 = cursor.getColumnIndex("buddy_account_info");
        this.f3753cq = 0;
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            if (cursor.getString(cursor.getColumnIndex("buddy_no")) == null || cursor.getString(cursor.getColumnIndex("buddy_no")).startsWith("0999")) {
                if (!TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex("buddy_no")))) {
                    if (columnIndex5 != -1 && cursor.getString(columnIndex5) != null && cursor.getString(columnIndex5).equals("Y")) {
                        this.f3753cq++;
                    } else {
                        arrayList.add(new C1106c(cursor.getString(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex3), null, cursor.getString(columnIndex), null, true, 0, cursor.getString(columnIndex2), "Y".equals(cursor.getString(columnIndex4)), 0, 0, 0, 0, 0, 0, 1, false, false, cursor.getInt(columnIndex6)));
                    }
                }
            }
        }
        int i = 0;
        if (arrayList.size() > 0) {
            int i2 = 0;
            while (i2 < this.f3665at.size()) {
                C1104a c1104a = this.f3665at.get(i2);
                int i3 = c1104a.m7030d() == -2 ? i2 + 1 : i;
                if (c1104a.m7030d() == -1) {
                    i3 = i2 + 1;
                }
                if (c1104a.m7030d() == 0) {
                    i3 = i2 + 1;
                }
                if (c1104a.m7030d() == 1) {
                    i3 = i2 + 1;
                }
                if (c1104a.m7030d() == 4) {
                    i3 = i2 + 1;
                }
                if (c1104a.m7030d() != 7) {
                    i2++;
                    i = i3;
                } else {
                    return false;
                }
            }
            this.f3665at.add(i, new C1104a(1, getResources().getString(R.string.live), arrayList.size(), 7, false, false, 0));
            this.f3666au.add(i, arrayList);
        }
        return arrayList.size() > 0;
    }

    /* renamed from: A */
    private boolean m6284A() {
        C4904y.m18639b("addBirthdayDataSet", f3576a);
        String str = new SimpleDateFormat("MM-dd").format(new Date());
        ArrayList<C1106c> arrayList = new ArrayList<>();
        for (int i = 0; i < this.f3665at.size(); i++) {
            C1104a c1104a = this.f3665at.get(i);
            if (c1104a.m7030d() == 2 || c1104a.m7030d() == 3 || c1104a.m7030d() == 6) {
                Iterator<C1106c> it = this.f3666au.get(i).iterator();
                while (it.hasNext()) {
                    C1106c next = it.next();
                    if (!TextUtils.isEmpty(next.m7059h()) && ((next.m7059h().length() == 10 && next.m7059h().substring(5).equals(str)) || (next.m7059h().length() == 5 && next.m7059h().equals(str)))) {
                        arrayList.add(next);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            for (int i2 = 0; i2 < this.f3665at.size(); i2++) {
                if (this.f3665at.get(i2).m7030d() > 0) {
                    this.f3665at.add(i2, new C1104a(0, getResources().getString(R.string.buddy_list_group_birthday), arrayList.size(), 0, true, false, 0));
                    this.f3666au.add(i2, arrayList);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m6515f(Cursor cursor) {
        this.f3665at.clear();
        this.f3666au.clear();
        if (cursor.getCount() == 0 && this.f3660ao == 5) {
            C5179v.m19811a(getActivity(), getResources().getString(R.string.buddy_list_invite_toast_failed_nomore), 0).show();
            Intent intent = new Intent();
            intent.putExtra("receivers", new String[0]);
            getActivity().setResult(0, intent);
            getActivity().finish();
            return;
        }
        if (this.f3660ao == 1 && C4822an.m18218a()) {
            m6577z();
        }
        m6373a(cursor);
        m6462b(cursor);
        if (this.f3660ao == 1) {
            m6510e(cursor);
        }
        m6348a(cursor, true);
        if (C4809aa.m18104a().m18119a("Profile Birth Chk", (Boolean) true).booleanValue() && this.f3660ao == 1) {
            m6284A();
        }
        m6288C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m6524g(Cursor cursor) {
        this.f3665at.clear();
        this.f3666au.clear();
        m6373a(cursor);
        m6348a(cursor, true);
        if (C4809aa.m18104a().m18119a("Profile Birth Chk", (Boolean) true).booleanValue()) {
            m6284A();
        }
        m6288C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m6530h(Cursor cursor) {
        this.f3665at.clear();
        this.f3666au.clear();
        m6348a(cursor, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m6537i(Cursor cursor) {
        this.f3665at.clear();
        this.f3666au.clear();
        m6348a(cursor, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6452b(Cursor cursor, boolean z) {
        String str;
        int i;
        this.f3665at.clear();
        this.f3666au.clear();
        C4904y.m18639b("createAlphabetSortDataSetForLiveGroup " + cursor, f3576a);
        ArrayList<C1106c> arrayList = new ArrayList<>();
        HashMap map = new HashMap();
        int columnIndex = cursor.getColumnIndex("buddy_no");
        int columnIndex2 = cursor.getColumnIndex("buddy_name");
        int columnIndex3 = cursor.getColumnIndex("buddy_status_message");
        int columnIndex4 = cursor.getColumnIndex("buddy_email");
        int columnIndex5 = cursor.getColumnIndex("buddy_samsung_email");
        int columnIndex6 = cursor.getColumnIndex("buddy_orginal_number");
        int columnIndex7 = cursor.getColumnIndex("buddy_birthday");
        int columnIndex8 = cursor.getColumnIndex("buddy_relation_hide");
        int columnIndex9 = cursor.getColumnIndex("buddy_raw_contact_id");
        int columnIndex10 = cursor.getColumnIndex("buddy_push_name");
        int columnIndex11 = cursor.getColumnIndex("buddy_is_new");
        int columnIndex12 = cursor.getColumnIndex("buddy_profile_status");
        int columnIndex13 = cursor.getColumnIndex("buddy_is_profile_updated");
        int columnIndex14 = cursor.getColumnIndex("buddy_is_status_updated");
        int columnIndex15 = cursor.getColumnIndex("buddy_show_phone_number");
        int columnIndex16 = cursor.getColumnIndex("buddy_extra_info");
        int columnIndex17 = cursor.getColumnIndex("buddy_hanzitopinyin");
        int columnIndex18 = cursor.getColumnIndex("buddy_account_info");
        int columnIndex19 = cursor.getColumnIndex("buddy_sainfo");
        int columnIndexOrThrow = z ? cursor.getColumnIndexOrThrow("relation_send") : -1;
        int columnIndexOrThrow2 = z ? cursor.getColumnIndexOrThrow("relation_received") : -1;
        int columnIndexOrThrow3 = z ? cursor.getColumnIndexOrThrow("relation_point") : -1;
        int columnIndexOrThrow4 = z ? cursor.getColumnIndexOrThrow("relation_icon") : -1;
        int columnIndexOrThrow5 = z ? cursor.getColumnIndexOrThrow("relation_increase") : -1;
        int columnIndexOrThrow6 = z ? cursor.getColumnIndexOrThrow("relation_rank") : -1;
        int columnIndex20 = cursor.getColumnIndex("group_name");
        int columnIndex21 = cursor.getColumnIndex("buddy_is_hide");
        int columnIndex22 = cursor.getColumnIndex("buddy_contact_buddy");
        int columnIndex23 = cursor.getColumnIndex("buddy_phonenumber_external_use");
        this.f3747ck.clear();
        this.f3752cp = 0;
        HashMap map2 = new HashMap();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f3692bW.size()) {
                break;
            }
            map2.put(this.f3692bW.get(i3).chatonid, this.f3692bW.get(i3));
            i2 = i3 + 1;
        }
        MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames());
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            if (map2.get(cursor.getString(cursor.getColumnIndex("buddy_no"))) != null && C4809aa.m18104a().m18121a("chaton_id", "").compareTo(cursor.getString(cursor.getColumnIndex("buddy_no"))) != 0) {
                Object[] objArr = new Object[31];
                objArr[0] = cursor.getString(cursor.getColumnIndex("group_relation_group"));
                objArr[1] = cursor.getString(cursor.getColumnIndex("group_name"));
                objArr[2] = cursor.getString(cursor.getColumnIndex("group_type"));
                objArr[3] = cursor.getString(columnIndex);
                objArr[4] = cursor.getString(columnIndex2);
                objArr[5] = cursor.getString(columnIndex3);
                objArr[6] = cursor.getString(columnIndex4);
                objArr[7] = cursor.getString(columnIndex5);
                objArr[8] = cursor.getString(columnIndex6);
                objArr[9] = cursor.getString(columnIndex23);
                objArr[10] = cursor.getString(columnIndex17);
                objArr[11] = cursor.getString(columnIndex8);
                objArr[12] = cursor.getString(columnIndex7);
                objArr[13] = cursor.getString(columnIndex9);
                objArr[14] = cursor.getString(columnIndex10);
                objArr[15] = cursor.getString(columnIndex11);
                objArr[16] = Integer.valueOf(cursor.getInt(columnIndex12));
                objArr[17] = cursor.getString(columnIndex13);
                objArr[18] = Integer.valueOf(cursor.getInt(columnIndex15));
                objArr[19] = cursor.getString(columnIndex16);
                objArr[20] = Integer.valueOf(cursor.getInt(columnIndex18));
                objArr[21] = cursor.getString(columnIndex21);
                objArr[22] = cursor.getString(columnIndex22);
                objArr[23] = cursor.getString(columnIndex19);
                objArr[24] = cursor.getString(columnIndex14);
                objArr[25] = Integer.valueOf(z ? cursor.getInt(columnIndexOrThrow) : 0);
                objArr[26] = Integer.valueOf(z ? cursor.getInt(columnIndexOrThrow2) : 0);
                objArr[27] = Integer.valueOf(z ? cursor.getInt(columnIndexOrThrow3) : 0);
                objArr[28] = Integer.valueOf(z ? cursor.getInt(columnIndexOrThrow4) : 0);
                objArr[29] = Integer.valueOf(z ? cursor.getInt(columnIndexOrThrow5) : 0);
                objArr[30] = Integer.valueOf(z ? cursor.getInt(columnIndexOrThrow6) : 0);
                matrixCursor.addRow(objArr);
                map2.remove(cursor.getString(cursor.getColumnIndex("buddy_no")));
            }
        }
        matrixCursor.moveToPosition(-1);
        int i4 = 2;
        String strM18292d = null;
        char c2 = 0;
        ArrayList<C1106c> arrayList2 = arrayList;
        while (matrixCursor.moveToNext()) {
            if (matrixCursor.getString(matrixCursor.getColumnIndex("buddy_no")) == null || !matrixCursor.getString(matrixCursor.getColumnIndex("buddy_no")).startsWith("0999")) {
                if (this.f3660ao != 1000 || this.f3638aS == null || !this.f3638aS.equals("voip") || (!TextUtils.isEmpty(matrixCursor.getString(columnIndex16)) && !TextUtils.isEmpty(matrixCursor.getString(columnIndex19)) && matrixCursor.getString(columnIndex16).contains("voip=1"))) {
                    if (columnIndex20 == -1 || matrixCursor.getString(columnIndex20) == null || matrixCursor.getString(columnIndex20) == null) {
                        if (columnIndex17 != -1) {
                            strM18292d = matrixCursor.getString(columnIndex17);
                        }
                        if (TextUtils.isEmpty(strM18292d)) {
                            strM18292d = C4828at.m18276a().m18292d(matrixCursor.getString(columnIndex2));
                        }
                        if (strM18292d != null && strM18292d.trim().length() != 0) {
                            str = strM18292d;
                        } else if (this.f3594A) {
                            str = ".";
                        }
                        if (columnIndex20 > 0) {
                            String string = matrixCursor.getString(columnIndex20);
                            if (this.f3660ao == 10 && string != null && string.length() != 0) {
                                strM18292d = str;
                            }
                        }
                        if (columnIndex21 == -1 || matrixCursor.getString(columnIndex21) == null || !matrixCursor.getString(columnIndex21).equals("Y")) {
                            String string2 = "";
                            if (columnIndex23 != -1) {
                                string2 = matrixCursor.getString(columnIndex23);
                            }
                            char cM18318a = C4841bf.m18318a(Character.toUpperCase(str.charAt(0)));
                            C1106c c1106c = new C1106c(matrixCursor.getString(columnIndex), matrixCursor.getString(columnIndex2), matrixCursor.getString(columnIndex3), matrixCursor.getString(columnIndex5), matrixCursor.getString(columnIndex6), matrixCursor.getString(columnIndex7), !"Y".equals(matrixCursor.getString(columnIndex8)), matrixCursor.getInt(columnIndex9), matrixCursor.getString(columnIndex10), "Y".equals(matrixCursor.getString(columnIndex11)), z ? matrixCursor.getInt(columnIndexOrThrow) : 0, z ? matrixCursor.getInt(columnIndexOrThrow2) : 0, z ? matrixCursor.getInt(columnIndexOrThrow3) : 0, z ? matrixCursor.getInt(columnIndexOrThrow4) : 0, z ? matrixCursor.getInt(columnIndexOrThrow5) : 0, z ? matrixCursor.getInt(columnIndexOrThrow6) : 0, matrixCursor.getInt(columnIndex12), "Y".equals(matrixCursor.getString(columnIndex13)), "Y".equals(matrixCursor.getString(columnIndex14)), matrixCursor.getInt(columnIndex15), matrixCursor.getString(columnIndex16), matrixCursor.getInt(columnIndex18), matrixCursor.getString(columnIndex19), matrixCursor.getString(columnIndex22), string2);
                            if (this.f3738cb && this.f3737ca.contains(matrixCursor.getString(columnIndex))) {
                                c1106c.m7053b(true);
                            }
                            arrayList2.add(c1106c);
                            this.f3747ck.add(c1106c.m7046a());
                            if (map.get(Character.valueOf(cM18318a)) == null) {
                                this.f3666au.add(arrayList2);
                                C1104a c1104a = new C1104a(i4, String.valueOf(cM18318a), arrayList2.size(), 2, false, false, 0);
                                this.f3665at.add(c1104a);
                                map.put(Character.valueOf(cM18318a), c1104a);
                                i = i4 + 1;
                            } else {
                                int iIndexOf = this.f3665at.indexOf((C1104a) map.get(Character.valueOf(cM18318a)));
                                ArrayList<C1106c> arrayList3 = this.f3666au.get(iIndexOf);
                                arrayList3.addAll(arrayList2);
                                this.f3666au.set(iIndexOf, arrayList3);
                                C1104a c1104a2 = this.f3665at.get(iIndexOf);
                                c1104a2.m7027a(arrayList3.size());
                                this.f3665at.set(iIndexOf, c1104a2);
                                map.put(Character.valueOf(cM18318a), c1104a2);
                                i = i4;
                            }
                            i4 = i;
                            arrayList2 = new ArrayList<>();
                            c2 = cM18318a;
                            strM18292d = str;
                        } else {
                            this.f3752cp++;
                            strM18292d = str;
                        }
                    }
                }
            }
        }
        if (arrayList2.size() > 0) {
            this.f3665at.add(new C1104a(i4, String.valueOf(c2), arrayList2.size(), 2, false, false, 0));
            this.f3666au.add(arrayList2);
            i4++;
        }
        if (this.f3742cf != null) {
            this.f3742cf.mo6199b(this.f3692bW.size());
        }
        if (this.f3660ao == 1000 && this.f3638aS != null && this.f3638aS.equals("voip") && this.f3666au.size() == 0 && this.f3719bx == null) {
            this.f3719bx = AbstractC4932a.m18733a(getActivity());
            this.f3719bx.mo18740a(getResources().getString(R.string.poll_list_empty_title));
            this.f3719bx.mo18749b(getResources().getString(R.string.poll_list_empty_title)).mo18751b(true).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC1149bm(this));
            this.f3719bx.mo18752b();
        }
        int i5 = 0;
        int size = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.f3666au.size()) {
                break;
            }
            size += this.f3666au.get(i6).size();
            i5 = i6 + 1;
        }
        this.f3760cx = size;
        for (String str2 : map2.keySet()) {
            ArrayList<C1106c> arrayList4 = new ArrayList<>();
            char cM18318a2 = C4841bf.m18318a(Character.toUpperCase(((LiveGroupFollower) map2.get(str2)).name.charAt(0)));
            arrayList4.add(new C1106c(((LiveGroupFollower) map2.get(str2)).chatonid, ((LiveGroupFollower) map2.get(str2)).name, ((LiveGroupFollower) map2.get(str2)).msgstatus, null, null, null, false, 0, ((LiveGroupFollower) map2.get(str2)).name, false, 0, 0, 0, 0, 0, 9999999, 3, false, false, 0, "unknown_buddy", 0, null, Spam.ACTIVITY_REPORT, ""));
            if (map.get(Character.valueOf(cM18318a2)) == null) {
                this.f3666au.add(arrayList4);
                C1104a c1104a3 = new C1104a(i4, String.valueOf(cM18318a2), arrayList4.size(), 2, false, false, 0);
                this.f3665at.add(c1104a3);
                map.put(Character.valueOf(cM18318a2), c1104a3);
                i4++;
            } else {
                int iIndexOf2 = this.f3665at.indexOf((C1104a) map.get(Character.valueOf(cM18318a2)));
                ArrayList<C1106c> arrayList5 = this.f3666au.get(iIndexOf2);
                arrayList5.addAll(arrayList4);
                this.f3666au.set(iIndexOf2, arrayList5);
                C1104a c1104a4 = this.f3665at.get(iIndexOf2);
                c1104a4.m7027a(arrayList5.size());
                this.f3665at.set(iIndexOf2, c1104a4);
                map.put(Character.valueOf(cM18318a2), c1104a4);
            }
        }
        Collections.sort(this.f3665at, new C1150bn(this));
        Collections.sort(this.f3666au, new C1151bo(this));
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= this.f3666au.size()) {
                break;
            }
            Collections.sort(this.f3666au.get(i8), new C1152bp(this));
            i7 = i8 + 1;
        }
        map.clear();
        if (cursor != null) {
            cursor.close();
        }
        if (matrixCursor != null) {
            matrixCursor.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m6543j(Cursor cursor) {
        this.f3665at.clear();
        this.f3666au.clear();
        if (this.f3660ao == 1 && C4822an.m18218a()) {
            m6577z();
        }
        if (!this.f3630aK) {
            m6373a(cursor);
        }
        m6373a(cursor);
        m6462b(cursor);
        if (this.f3660ao == 1) {
            m6510e(cursor);
        }
        m6484c(cursor);
        if (C4809aa.m18104a().m18119a("Profile Birth Chk", (Boolean) true).booleanValue() && this.f3660ao == 1) {
            m6284A();
        }
        m6288C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m6547k(Cursor cursor) {
        this.f3665at.clear();
        this.f3666au.clear();
        if (this.f3660ao == 1 && C4822an.m18218a()) {
            m6577z();
        }
        if (!this.f3630aK) {
            m6373a(cursor);
        }
        m6462b(cursor);
        if (this.f3660ao == 1) {
            m6510e(cursor);
        }
        m6495d(cursor);
        if (C4809aa.m18104a().m18119a("Profile Birth Chk", (Boolean) true).booleanValue() && this.f3660ao == 1) {
            m6284A();
        }
        m6288C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m6550l(Cursor cursor) {
        if (this.f3708bm == null) {
            this.f3708bm = new ArrayList<>();
        }
        if (this.f3710bo == null) {
            this.f3710bo = new HashMap<>();
        }
        this.f3708bm.clear();
        this.f3710bo.clear();
        int columnIndex = cursor.getColumnIndex("buddy_no");
        int columnIndex2 = cursor.getColumnIndex("buddy_name");
        int columnIndex3 = cursor.getColumnIndex("buddy_status_message");
        int columnIndex4 = cursor.getColumnIndex("buddy_samsung_email");
        int columnIndex5 = cursor.getColumnIndex("buddy_orginal_number");
        int columnIndex6 = cursor.getColumnIndex("buddy_birthday");
        int columnIndex7 = cursor.getColumnIndex("buddy_relation_hide");
        int columnIndex8 = cursor.getColumnIndex("buddy_raw_contact_id");
        int columnIndex9 = cursor.getColumnIndex("buddy_push_name");
        int columnIndex10 = cursor.getColumnIndex("buddy_is_new");
        int columnIndex11 = cursor.getColumnIndex("buddy_profile_status");
        int columnIndex12 = cursor.getColumnIndex("buddy_is_profile_updated");
        int columnIndex13 = cursor.getColumnIndex("buddy_is_status_updated");
        int columnIndex14 = cursor.getColumnIndex("buddy_show_phone_number");
        int columnIndex15 = cursor.getColumnIndex("buddy_extra_info");
        int columnIndex16 = cursor.getColumnIndex("group_relation_group");
        int columnIndex17 = cursor.getColumnIndex("buddy_msisdns");
        int columnIndex18 = cursor.getColumnIndex("buddy_hanzitopinyin");
        int columnIndex19 = cursor.getColumnIndex("buddy_account_info");
        int columnIndex20 = cursor.getColumnIndex("buddy_sainfo");
        int columnIndex21 = cursor.getColumnIndex("buddy_contact_buddy");
        int columnIndex22 = cursor.getColumnIndex("buddy_phonenumber_external_use");
        while (cursor.moveToNext()) {
            if (getActivity().getIntent().getStringExtra("fromsms") == null || !TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex("buddy_phonenumber_external_use")))) {
                if (!TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex("buddy_contact_buddy"))) && (this.f3660ao != 1000 || this.f3638aS == null || !this.f3638aS.equals("voip") || (!TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex("buddy_extra_info"))) && !TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex("buddy_sainfo"))) && cursor.getString(cursor.getColumnIndex("buddy_extra_info")).contains("voip=1")))) {
                    if ((this.f3660ao != 23 && !this.f3695bZ) || cursor.getString(columnIndex21) == null || cursor.getString(columnIndex21).compareTo(Spam.ACTIVITY_REPORT) == 0) {
                        if (this.f3660ao != 1 && this.f3660ao != 2) {
                            if (this.f3660ao == 8) {
                                if (C4822an.m18218a()) {
                                    if (cursor.getString(cursor.getColumnIndex("buddy_contact_buddy")).compareTo(Spam.ACTIVITY_REPORT) != 0) {
                                    }
                                } else if (cursor.getString(cursor.getColumnIndex("buddy_contact_buddy")).compareTo(Spam.ACTIVITY_REPORT) != 0) {
                                }
                            } else if (this.f3660ao == 1000 || ((getArguments() != null && getArguments().containsKey("chatType") && getArguments().getInt("chatType") == EnumC2300t.GROUPCHAT.m10210a()) || !C4822an.m18218a() || cursor.getString(cursor.getColumnIndex("buddy_contact_buddy")).compareTo(Spam.ACTIVITY_REPORT) != 0)) {
                            }
                        }
                        if (cursor.getColumnIndex("buddy_is_hide") == -1 || cursor.getString(cursor.getColumnIndex("buddy_is_hide")) == null || !cursor.getString(cursor.getColumnIndex("buddy_is_hide")).equals("Y")) {
                            if (this.f3660ao == 1 || cursor.getString(cursor.getColumnIndex("buddy_no")) == null || !cursor.getString(cursor.getColumnIndex("buddy_no")).startsWith("0999")) {
                                C1106c c1106c = new C1106c(cursor.getString(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4), cursor.getString(columnIndex5), cursor.getString(columnIndex6), !cursor.getString(columnIndex7).equals("Y"), cursor.getInt(columnIndex8), cursor.getString(columnIndex9), cursor.getString(columnIndex10).equals("Y"), 0, 0, 0, 0, 0, 0, cursor.getInt(columnIndex11), cursor.getString(columnIndex12).equals("Y"), cursor.getString(columnIndex13).equals("Y"), cursor.getInt(columnIndex14), cursor.getString(columnIndex15), cursor.getInt(columnIndex16), cursor.getString(columnIndex17), cursor.getString(columnIndex18).toLowerCase(), C4828at.m18276a().m18290a(cursor.getString(cursor.getColumnIndex("buddy_name"))), cursor.getInt(columnIndex19), cursor.getString(columnIndex20), cursor.getString(columnIndex21), cursor.getString(columnIndex22), cursor.getString(columnIndex2).toLowerCase());
                                if (this.f3738cb && this.f3737ca.contains(cursor.getString(columnIndex))) {
                                    c1106c.m7053b(true);
                                }
                                this.f3708bm.add(c1106c);
                                if (!TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex("buddy_phonenumber_external_use")))) {
                                    this.f3710bo.put(cursor.getString(columnIndex), cursor.getString(columnIndex22));
                                }
                            }
                        }
                    }
                }
            }
        }
        if (this.f3660ao == 23) {
            HashMap map = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f3692bW.size()) {
                    break;
                }
                map.put(this.f3692bW.get(i2).chatonid, this.f3692bW.get(i2));
                i = i2 + 1;
            }
            for (String str : map.keySet()) {
                this.f3708bm.add(new C1106c(((LiveGroupFollower) map.get(str)).chatonid, ((LiveGroupFollower) map.get(str)).name, ((LiveGroupFollower) map.get(str)).msgstatus, null, null, null, false, 0, ((LiveGroupFollower) map.get(str)).name, false, 0, 0, 0, 0, 0, 9999999, 3, false, false, 0, "unknown_buddy", 0, null, cursor.getString(columnIndex18), C4828at.m18276a().m18290a(((LiveGroupFollower) map.get(str)).name), 0, null, Spam.ACTIVITY_REPORT, cursor.getString(columnIndex22), ((LiveGroupFollower) map.get(str)).name.toLowerCase()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00d3 A[SYNTHETIC] */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m6552m(android.database.Cursor r23) {
        /*
            Method dump skipped, instructions count: 689
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyFragment.m6552m(android.database.Cursor):void");
    }

    /* renamed from: e */
    private boolean m6512e(String str) {
        return Pattern.compile("[a-zA-Z\\s]+").matcher(str).matches();
    }

    /* renamed from: f */
    private boolean m6520f(String str) {
        return str.replaceAll("[+]?\\d+", "").equals("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6371a(ArrayList<C1104a> arrayList, ArrayList<ArrayList<C1106c>> arrayList2) throws Resources.NotFoundException {
        if (this.f3603J != null) {
            int size = (this.f3750cn - this.f3752cp) - this.f3753cq;
            if (this.f3623aD && arrayList2.size() > 0) {
                size = arrayList2.get(0).size();
            }
            if (size > 1) {
                this.f3603J.setText(getResources().getString(R.string.buddy_list_total_contacts, Integer.valueOf(size)));
            } else {
                this.f3603J.setText(getResources().getString(R.string.buddy_list_total_1_contact, 1));
            }
        }
        this.f3667av.clear();
        this.f3668aw.clear();
        Iterator<C1104a> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            C1104a next = it.next();
            this.f3667av.add(new C1104a(next));
            if (next.m7030d() == 1) {
                this.f3691bV = i;
            }
            i++;
        }
        Iterator<ArrayList<C1106c>> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            ArrayList<C1106c> next2 = it2.next();
            ArrayList<C1106c> arrayList3 = new ArrayList<>();
            Iterator<C1106c> it3 = next2.iterator();
            while (it3.hasNext()) {
                arrayList3.add(new C1106c(it3.next()));
            }
            this.f3668aw.add(arrayList3);
        }
        if (this.f3660ao == 19) {
            this.f3639aT = this.f3640aU;
        }
        if (this.f3660ao == 6 && this.f3657al != null && this.f3657al.containsKey("ACTIVITY_PURPOSE_ARG") && !this.f3657al.getBoolean("ACTIVITY_PURPOSE_ARG") && this.f3689bT && m6604g().length == 0) {
            for (String str : this.f3648ac) {
                this.f3639aT.add(str);
            }
            this.f3760cx = this.f3648ac.length;
        }
        if (this.f3639aT != null && this.f3639aT.size() > 0) {
            Iterator<String> it4 = this.f3639aT.iterator();
            while (it4.hasNext()) {
                String next3 = it4.next();
                if (this.f3641aV.get(next3) == null) {
                    m6592a(next3, true, (String) null, true, true);
                }
            }
            if (this.f3660ao != 9 || this.f3660ao != 24 || this.f3660ao != 25) {
                this.f3639aT.clear();
            }
        }
        if (this.f3620aA != null) {
            this.f3620aA.m7123a(m6560q());
            String string = this.f3677bF.m18658a().toString();
            if (!string.trim().equals("")) {
                string = C4874cl.m18505a(string);
            }
            this.f3620aA.m7129e(string);
            this.f3620aA.notifyDataSetChanged();
        }
        if (this.f3742cf != null && this.f3602I != null) {
            this.f3742cf.mo6198a(this.f3602I.m19638a());
        }
        if (this.f3620aA != null && m6286B() && f3581c != 0 && f3582d != 0 && this.f3602I != null) {
            this.f3602I.setSelectionFromTop(f3581c, f3582d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public boolean m6286B() {
        if (getActivity() != null) {
            return getActivity().getClass().getSimpleName().equals(TabActivity.class.getSimpleName());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public void m6288C() {
        boolean z;
        C4904y.m18639b("createNewBuddyGroup", f3576a);
        if (C2349a.m10301a("sms_feature") && !C4822an.m18218a()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("createNewBuddyGroup : should not need to add NEW cartegory because this is lite feature", f3576a);
                return;
            }
            return;
        }
        ArrayList<C1106c> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        Iterator<ArrayList<C1106c>> it = this.f3666au.iterator();
        while (it.hasNext()) {
            Iterator<C1106c> it2 = it.next().iterator();
            while (it2.hasNext()) {
                C1106c next = it2.next();
                if (next.m7063l() && !next.m7074w() && !arrayList2.contains(next.m7046a())) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("new buddy added : " + next.m7046a() + ", " + next.m7051b() + ", " + next.m7054c(), f3576a);
                    }
                    arrayList.add(next);
                    arrayList2.add(next.m7046a());
                }
            }
        }
        if (arrayList.size() > 0) {
            int i = 0;
            while (true) {
                if (i >= this.f3665at.size()) {
                    z = false;
                    break;
                } else {
                    if (this.f3665at.get(i).m7030d() == -2) {
                        z = true;
                        break;
                    }
                    i++;
                }
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("isMeCategoryExist : " + Boolean.toString(z), f3576a);
            }
            if (z) {
                this.f3665at.add(1, new C1104a(-1, getResources().getString(R.string.category_name_new), arrayList.size(), -1, true, false, 0));
                this.f3666au.add(1, arrayList);
            } else {
                this.f3665at.add(0, new C1104a(-1, getResources().getString(R.string.category_name_new), arrayList.size(), -1, true, false, 0));
                this.f3666au.add(0, arrayList);
            }
        }
        if (this.f3708bm != null) {
            this.f3708bm.clear();
            this.f3621aB.m7400a(21);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public void m6289D() {
        StringBuffer stringBuffer = new StringBuffer();
        if (!this.f3623aD && this.f3667av.size() != 0 && this.f3602I != null) {
            for (int i = 0; i < this.f3667av.size(); i++) {
                try {
                    if (!this.f3602I.isGroupExpanded(i) && this.f3667av.get(i).m7030d() != -1) {
                        stringBuffer.append("," + this.f3667av.get(i).m7028b());
                    }
                } catch (Exception e) {
                    C4904y.m18634a("isn't GroupExpanded", getClass().getSimpleName());
                }
            }
            if (this.f3660ao == 1) {
                C5033j.m19087a(getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putInt("BUDDY_SORT_STYLE", this.f3658am));
                if (this.f3658am == 12) {
                    if (stringBuffer.toString().length() > 0) {
                        C5033j.m19087a(getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("RELATIONSHIP_FOLDER_STATE", stringBuffer.toString().substring(1)));
                        return;
                    } else {
                        C5033j.m19087a(getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("RELATIONSHIP_FOLDER_STATE", null));
                        return;
                    }
                }
                if (this.f3658am == 11) {
                    if (stringBuffer.toString().length() > 0) {
                        C5033j.m19087a(getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("ALPHABET_FOLDER_STATE", stringBuffer.toString().substring(1)));
                        return;
                    } else {
                        C5033j.m19087a(getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("ALPHABET_FOLDER_STATE", null));
                        return;
                    }
                }
                if (this.f3658am == 13) {
                    if (stringBuffer.toString().length() > 0) {
                        C5033j.m19087a(getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("CHATONV_FOLDER_STATE", stringBuffer.toString().substring(1)));
                    } else {
                        C5033j.m19087a(getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("CHATONV_FOLDER_STATE", null));
                    }
                }
            }
        }
    }

    /* renamed from: E */
    private void m6292E() {
        String string = getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).getString("RELATIONSHIP_FOLDER_STATE", null);
        if (string != null) {
            this.f3662aq = string.split(",");
        } else {
            this.f3662aq = new String[0];
        }
        String string2 = getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).getString("ALPHABET_FOLDER_STATE", null);
        if (string2 != null) {
            this.f3663ar = string2.split(",");
        } else {
            this.f3663ar = new String[0];
        }
        String string3 = getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).getString("CHATONV_FOLDER_STATE", null);
        if (string3 != null) {
            this.f3664as = string3.split(",");
        } else {
            this.f3664as = new String[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public void m6293F() {
        String[] strArr;
        if (this.f3623aD || this.f3660ao == 6 || this.f3660ao == 18 || this.f3660ao == 23) {
            for (int i = 0; i < this.f3667av.size(); i++) {
                this.f3602I.expandGroup(i);
            }
            return;
        }
        if (this.f3660ao == 5) {
            for (int i2 = 0; i2 < this.f3667av.size(); i2++) {
                if (this.f3667av.get(i2).m7030d() < 1) {
                    this.f3602I.collapseGroup(i2);
                } else {
                    this.f3602I.expandGroup(i2);
                }
            }
            return;
        }
        m6292E();
        for (int i3 = 0; i3 < this.f3667av.size(); i3++) {
            if (this.f3602I != null && this.f3750cn > 0) {
                this.f3602I.expandGroup(i3);
            }
        }
        if (this.f3658am == 12 && this.f3662aq != null) {
            strArr = this.f3662aq;
        } else if (this.f3658am == 11 && this.f3663ar != null) {
            strArr = this.f3663ar;
        } else if (this.f3658am != 13 || this.f3664as == null) {
            strArr = null;
        } else {
            strArr = this.f3664as;
        }
        if (strArr != null) {
            for (int i4 = 0; i4 < this.f3667av.size(); i4++) {
                int i5 = 0;
                while (true) {
                    if (i5 >= strArr.length) {
                        break;
                    }
                    if (!this.f3667av.get(i4).m7028b().equals(strArr[i5])) {
                        i5++;
                    } else if (this.f3602I != null) {
                        this.f3602I.collapseGroup(i4);
                    }
                }
                if (this.f3660ao == 1 && this.f3659an != this.f3658am && ((this.f3667av.get(i4).m7030d() < 2 || this.f3667av.get(i4).m7030d() == 4 || this.f3667av.get(i4).m7030d() == 7) && this.f3602I != null)) {
                    this.f3602I.collapseGroup(i4);
                }
            }
        }
        this.f3659an = this.f3658am;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.f3660ao == 1 || this.f3660ao == 7) {
            menuInflater.inflate(R.menu.activity_buddylist_menu, menu);
        } else if (this.f3660ao != 18) {
            menuInflater.inflate(R.menu.cancel_done_menu, menu);
        }
        super.onCreateOptionsMenu(menu, menuInflater);
        C4904y.m18639b("onCreateOptionsMenu()", f3576a);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        boolean z;
        super.onPrepareOptionsMenu(menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.buddylist_menu_add_group);
        MenuItem menuItemFindItem2 = menu.findItem(R.id.buddylist_menu_deselect_all);
        MenuItem menuItemFindItem3 = menu.findItem(R.id.buddylist_menu_sort);
        MenuItem menuItemFindItem4 = menu.findItem(R.id.buddylist_menu_manage_buddies);
        MenuItem menuItemFindItem5 = menu.findItem(R.id.buddylist_menu_tell_friends);
        MenuItem menuItemFindItem6 = menu.findItem(R.id.buddylist_menu_contact_sync);
        MenuItem menuItemFindItem7 = menu.findItem(R.id.buddylist_menu_hide_buddy);
        MenuItem menuItemFindItem8 = menu.findItem(R.id.buddylist_menu_block_buddy);
        MenuItem menuItemFindItem9 = menu.findItem(R.id.buddylist_menu_delete_buddy);
        int i = (this.f3750cn - this.f3754cr) - this.f3752cp;
        C4904y.m18639b("BuddyFragment -> onPrepareOptionsMenu -> buddyCount : " + this.f3750cn, getClass().getSimpleName());
        C4904y.m18639b("BuddyFragment -> onPrepareOptionsMenu -> mContactBuddyCount : " + this.f3754cr, getClass().getSimpleName());
        C4904y.m18639b("BuddyFragment -> onPrepareOptionsMenu -> hideBuddyCount : " + this.f3752cp, getClass().getSimpleName());
        C4904y.m18639b("BuddyFragment -> onPrepareOptionsMenu -> normalBuddyCount : " + i, getClass().getSimpleName());
        if (this.f3602I != null && m6605h() != 0) {
            if (menuItemFindItem != null) {
                if ((this.f3658am == 11 || this.f3658am == 12 || this.f3658am == 13) && !this.f3693bX) {
                    menuItemFindItem.setVisible(true);
                } else {
                    menuItemFindItem.setVisible(false);
                }
            }
            if (menuItemFindItem3 != null) {
                menuItemFindItem3.setVisible(false);
            }
            if (menuItemFindItem4 != null) {
                menuItemFindItem4.setVisible(false);
            }
            if (menuItemFindItem5 != null) {
                menuItemFindItem5.setVisible(false);
            }
            if (menuItemFindItem6 != null) {
                menuItemFindItem6.setVisible(false);
            }
        } else if (this.f3660ao == 1) {
            if (menuItemFindItem2 != null) {
                menuItemFindItem2.setVisible(false);
            }
            if (menuItemFindItem3 != null) {
                if (m6557p() == 1 && i > 0 && C4822an.m18218a()) {
                    menuItemFindItem3.setVisible(true);
                } else {
                    menuItemFindItem3.setVisible(false);
                }
            }
            if (menuItemFindItem != null) {
                if ((this.f3658am == 11 || this.f3658am == 12 || this.f3658am == 13) && i > 0 && C4822an.m18218a() && !this.f3693bX) {
                    menuItemFindItem.setVisible(true);
                } else {
                    menuItemFindItem.setVisible(false);
                }
            }
            if (menuItemFindItem4 != null && i > 0) {
                if (C4822an.m18218a()) {
                    menuItemFindItem4.setVisible(true);
                } else {
                    menuItemFindItem4.setVisible(false);
                }
            } else if (menuItemFindItem4 != null) {
                menuItemFindItem4.setVisible(false);
            }
            if (menuItemFindItem5 != null) {
                menuItemFindItem5.setVisible(true);
            }
            if (menuItemFindItem6 != null) {
                if (C2349a.m10301a("sms_feature") || !TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
                    menuItemFindItem6.setVisible(true);
                } else {
                    menuItemFindItem6.setVisible(false);
                }
                m6582a(menuItemFindItem6);
            }
            if (menuItemFindItem7 != null) {
                menuItemFindItem7.setVisible(false);
            }
            if (menuItemFindItem8 != null) {
                menuItemFindItem8.setVisible(false);
            }
            if (menuItemFindItem9 != null) {
                menuItemFindItem9.setVisible(false);
            }
        } else if (this.f3660ao == 7) {
            if (menuItemFindItem5 != null) {
                menuItemFindItem5.setVisible(true);
            }
            if (menuItemFindItem3 != null) {
                menuItemFindItem3.setVisible(false);
            }
            if (menuItemFindItem != null) {
                menuItemFindItem.setVisible(false);
            }
            if (menuItemFindItem4 != null) {
                menuItemFindItem4.setVisible(false);
            }
            if (menuItemFindItem2 != null) {
                menuItemFindItem2.setVisible(false);
            }
            if (menuItemFindItem7 != null) {
                menuItemFindItem7.setVisible(false);
            }
            if (menuItemFindItem8 != null) {
                menuItemFindItem8.setVisible(false);
            }
            if (menuItemFindItem9 != null) {
                menuItemFindItem9.setVisible(false);
            }
            if (menuItemFindItem6 != null) {
                if (C2349a.m10301a("sms_feature")) {
                    menuItemFindItem6.setVisible(true);
                } else if ((!C2349a.m10301a("for_wifi_only_device") && !C4822an.m18196F()) || !TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
                    menuItemFindItem6.setVisible(true);
                } else {
                    menuItemFindItem6.setVisible(false);
                }
                m6582a(menuItemFindItem6);
            }
        } else {
            menu.setGroupVisible(R.id.buddy_fragment_menu_group_option, false);
        }
        this.f3674bC = menu.findItem(R.id.menu_done);
        if (this.f3674bC != null) {
            this.f3674bC.setVisible(false);
        }
        this.f3675bD = menu.findItem(R.id.menu_cancel);
        if (this.f3675bD != null) {
            this.f3675bD.setVisible(false);
        }
        if (this.f3660ao != 1 && this.f3660ao != 7 && ((this.f3660ao != 1000 || this.f3595B != 0) && ((this.f3660ao != 6 || getArguments() == null || !getArguments().containsKey("ACTIVITY_PURPOSE_ARG") || !getArguments().getBoolean("ACTIVITY_PURPOSE_ARG")) && this.f3660ao != 18))) {
            if (this.f3674bC != null) {
                if (this.f3660ao != 23) {
                    this.f3674bC.setVisible(true);
                }
                if (this.f3602I != null) {
                    int iM6605h = m6605h();
                    boolean zM6435aq = m6435aq();
                    if (iM6605h > 0) {
                        if (zM6435aq && !this.f3695bZ) {
                            this.f3674bC.setEnabled(false);
                        } else {
                            this.f3674bC.setEnabled(true);
                        }
                        if (this.f3660ao == 1000) {
                            this.f3674bC.setEnabled(true);
                        }
                    } else {
                        this.f3674bC.setEnabled(false);
                    }
                }
                m6585a(new C1153bq(this));
            }
            if (this.f3675bD != null) {
                this.f3675bD.setVisible(true);
                this.f3675bD.setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1154br(this));
            }
        }
        m6407ac();
        if (m6557p() == 1 && this.f3677bF != null && TextUtils.isEmpty(this.f3677bF.m18658a().toString())) {
            m6499d(false);
        }
        if (!C2349a.m10301a("sms_feature")) {
            z = true;
        } else {
            for (int i2 = 0; i2 < m6605h(); i2++) {
                C1106c c1106cM6341a = m6341a(m6604g()[i2], this.f3666au);
                if (c1106cM6341a != null && c1106cM6341a.m7043F() != null && c1106cM6341a.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                    z = false;
                    break;
                }
            }
            z = true;
        }
        if (z) {
            if (i == 0) {
                m6350a(menuItemFindItem, false);
            } else {
                m6350a(menuItemFindItem, true);
            }
        } else {
            m6350a(menuItemFindItem, false);
            m6350a(menuItemFindItem7, false);
            m6350a(menuItemFindItem8, false);
            m6350a(menuItemFindItem9, false);
        }
        m6350a(menuItemFindItem9, false);
    }

    @TargetApi(14)
    /* renamed from: c */
    public boolean m6599c() {
        if (Build.VERSION.SDK_INT >= 11) {
            List<SyncInfo> currentSyncs = ContentResolver.getCurrentSyncs();
            if (currentSyncs == null || currentSyncs.size() <= 0) {
                return false;
            }
            boolean z = false;
            for (int i = 0; i < currentSyncs.size(); i++) {
                if (currentSyncs.get(i).account != null && Config.CHATON_PACKAGE_NAME.equals(currentSyncs.get(i).account.type)) {
                    z = true;
                }
                C4904y.m18639b("isSyncing return value = " + z, "SyncStatePreference");
            }
            return z;
        }
        SyncInfo currentSync = ContentResolver.getCurrentSync();
        return (currentSync == null || currentSync.account == null || !Config.CHATON_PACKAGE_NAME.equals(currentSync.account.type)) ? false : true;
    }

    /* renamed from: a */
    public void m6582a(MenuItem menuItem) {
        if (menuItem.isVisible()) {
            if (m6599c()) {
                menuItem.setEnabled(false);
            } else {
                menuItem.setEnabled(true);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) throws Resources.NotFoundException {
        String string;
        String string2;
        String string3;
        Bitmap bitmap;
        if (this.f3677bF != null && !TextUtils.isEmpty(this.f3677bF.m18658a().toString())) {
            this.f3677bF.setText("");
        }
        m6304K();
        switch (menuItem.getItemId()) {
            case 2:
                m6309N();
                return true;
            case 4:
                m6289D();
                Intent intent = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                intent.putExtra("BUDDY_SORT_STYLE", this.f3658am);
                intent.putExtra("ACTIVITY_PURPOSE", 2);
                startActivity(intent);
                return true;
            case 5:
                m6289D();
                Intent intent2 = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                intent2.putExtra("BUDDY_SORT_STYLE", this.f3658am);
                intent2.putExtra("ACTIVITY_PURPOSE", 3);
                startActivity(intent2);
                return true;
            case 6:
                if (!C4822an.m18218a()) {
                }
                startActivity(new Intent(getActivity(), (Class<?>) ActivitySettings.class));
                return true;
            case 7:
                String str = this.f3619Z;
                EnumC2300t enumC2300tM10207a = EnumC2300t.m10207a(this.f3647ab);
                ProfileImageView profileImageView = new ProfileImageView(getActivity());
                profileImageView.m18704a(profileImageView, EnumC2300t.m10207a(this.f3647ab));
                if (enumC2300tM10207a == EnumC2300t.ONETOONE) {
                    str = this.f3646aa;
                    C2496n.m10765a(profileImageView, this.f3646aa, EnumC2498p.ROUND);
                    profileImageView.setBuddyNo(this.f3646aa);
                }
                Intent intentM18133a = C4811ac.m18133a(getActivity(), str, enumC2300tM10207a);
                String str2 = this.f3649ad;
                String str3 = enumC2300tM10207a == EnumC2300t.GROUPCHAT ? String.format("%s(%d)", str2, Integer.valueOf(this.f3648ac.length + 1)) : str2;
                try {
                    bitmap = ((BitmapDrawable) profileImageView.getDrawable()).getBitmap();
                } catch (Exception e) {
                    bitmap = null;
                }
                C4811ac.m18136a(getActivity(), intentM18133a, str3, Bitmap.createScaledBitmap(C4812ad.m18140a(getActivity(), bitmap), C4811ac.m18131a(getResources().getDisplayMetrics().density), C4811ac.m18131a(getResources().getDisplayMetrics().density), true));
                return true;
            case 8:
                if (this.f3621aB == null) {
                    return true;
                }
                this.f3621aB.m7416j();
                return true;
            case 9:
                m6289D();
                Intent intent3 = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                intent3.putExtra("BUDDY_SORT_STYLE", this.f3658am);
                intent3.putExtra("ACTIVITY_PURPOSE", 12);
                startActivity(intent3);
                return true;
            case 14:
                AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(getActivity());
                abstractC4932aM18733a.mo18734a(R.string.chat_info_delete_all);
                abstractC4932aM18733a.mo18746b(R.string.dialog_title_msgbox_delete).mo18751b(true).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC1159bw(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1158bv(this));
                abstractC4932aM18733a.mo18752b();
                return true;
            case R.id.buddylist_menu_sort /* 2131166616 */:
                if (m6557p() == 1) {
                    String[] strArr = {getString(R.string.setting_downloads_font_filter_all), getString(R.string.chatonv_contacts)};
                    int i = this.f3658am - 11;
                    if (i == 2) {
                        i = 1;
                    }
                    this.f3626aG = AbstractC4932a.m18733a(getActivity()).mo18740a(getString(R.string.buddy_list_optionmenu_listby)).mo18743a(strArr, i, new DialogInterfaceOnClickListenerC1157bu(this)).mo18741a(GlobalApplication.m10283b().getString(R.string.cancel), new DialogInterfaceOnClickListenerC1155bs(this)).mo18752b();
                    return true;
                }
                this.f3658am = 11;
                m6289D();
                if (this.f3659an == this.f3658am) {
                    return true;
                }
                m6574x();
                return true;
            case R.id.buddylist_menu_add_group /* 2131166617 */:
                if (m6605h() > C1427a.m7524g()) {
                    m6370a((CharSequence) getActivity().getString(R.string.buddy_list_select_maximum_contacts, new Object[]{Integer.valueOf(C1427a.m7524g())}));
                    return true;
                }
                this.f3644aY = new AlertDialogC1262dw(getActivity(), this);
                this.f3644aY.m7435a(true);
                this.f3644aY.show();
                m6509e(true);
                return true;
            case R.id.buddylist_menu_manage_buddies /* 2131166618 */:
                startActivity(new Intent(getActivity(), (Class<?>) ActivityManageBuddy.class));
                return true;
            case R.id.buddylist_menu_tell_friends /* 2131166619 */:
                if (C4822an.m18218a()) {
                    Intent intent4 = new Intent(getActivity(), (Class<?>) AddBuddyActivity.class);
                    intent4.putExtra("ADD_BUDDY_TYPE", 103);
                    startActivityForResult(intent4, 100);
                    return true;
                }
                startActivity(new Intent(getActivity(), (Class<?>) TellFriendsActivity.class));
                return true;
            case R.id.buddylist_menu_contact_sync /* 2131166620 */:
                C5179v.m19810a(getActivity(), R.string.chaton_sms_buddy_sync_contact_list, 0).show();
                if (!TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
                    int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
                    if (-3 == iM10677a || -2 == iM10677a) {
                        C5179v.m19810a(getActivity(), R.string.trunk_network_not_available, 0).show();
                        return false;
                    }
                    C4809aa.m18104a().m18125b("buddy_request_sync_in_chaton", (Boolean) true);
                    C1002i.m6059a(true);
                    return true;
                }
                if (TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
                    C4809aa.m18104a().m18128b("Setting Sync TimeInMillis", String.valueOf(System.currentTimeMillis()));
                }
                new C2128i(null).m9497a("localsms");
                return true;
            case R.id.buddylist_menu_deselect_all /* 2131166621 */:
                m6595b(true);
                this.f3739cc.setVisibility(8);
                m6608k();
                C5179v.m19810a(getActivity(), R.string.buddy_list_deselectall_toast, 0).show();
                return true;
            case R.id.buddylist_menu_hide_buddy /* 2131166622 */:
                if (m6604g().length == 0) {
                    return true;
                }
                if (m6604g().length > 1) {
                    string3 = getResources().getString(R.string.selected_contacts_hidden);
                } else {
                    string3 = String.format(getResources().getString(R.string.hide_popup_body), m6341a(m6604g()[0], this.f3666au).m7051b());
                }
                AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.buddy_list_contextual_menu_hide)).mo18749b(string3).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1160bx(this)).mo18741a(getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).mo18752b();
                return true;
            case R.id.buddylist_menu_block_buddy /* 2131166623 */:
                if (m6604g().length == 0) {
                    return true;
                }
                if (m6604g().length > 1) {
                    string2 = getResources().getString(R.string.selected_contacts_blocked);
                } else {
                    string2 = String.format(getResources().getString(R.string.block_popup_body), m6341a(m6604g()[0], this.f3666au).m7051b());
                }
                AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.buddy_list_contextual_menu_block)).mo18749b(string2).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1161by(this)).mo18741a(getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).mo18752b();
                return true;
            case R.id.buddylist_menu_delete_buddy /* 2131166624 */:
                if (m6604g().length == 0) {
                    return true;
                }
                if (m6604g().length > 1) {
                    string = getResources().getString(R.string.selected_contacts_reomved);
                } else {
                    string = String.format(getResources().getString(R.string.delete_popup_body), m6341a(m6604g()[0], this.f3666au).m7051b());
                }
                AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.buddy_list_contextual_menu_delete)).mo18749b(string).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1162bz(this)).mo18741a(getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).mo18752b();
                return true;
            case R.id.menu_done /* 2131166685 */:
                m6324U();
                return true;
            case R.id.group_page_delete_menu /* 2131166705 */:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public void m6296G() {
        ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
        ArrayList<String> arrayListM9861b = C2191e.m9861b(contentResolver);
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<Integer> arrayListM9851a = C2191e.m9851a(contentResolver);
        for (int i = 0; i < arrayListM9851a.size(); i++) {
            ArrayList<String> arrayListM9852a = C2191e.m9852a(contentResolver, arrayListM9851a.get(i).intValue());
            if (!arrayListM9861b.get(i).equals("Favorites")) {
                map.put(arrayListM9861b.get(i), arrayListM9852a);
            }
        }
        arrayListM9861b.remove("Favorites");
        if (arrayListM9861b.size() == 0) {
            C4809aa.m18104a().m18125b("Is Group Uploaded", (Boolean) true);
        } else {
            new C2128i(this.f3748cl).m9487a("group", false, 328, arrayListM9861b, map);
        }
    }

    /* renamed from: H */
    private void m6298H() {
        this.f3598E = new C2210x(getActivity().getContentResolver(), this.f3767t);
        this.f3598E.startQuery(1000, null, C2289i.m10175m(), null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public void m6299I() {
        ArrayList<Integer> arrayListM9851a;
        ArrayList<String> arrayListM9861b;
        int i = 0;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
            arrayListM9851a = C2191e.m9851a(contentResolver);
            arrayListM9861b = C2191e.m9861b(contentResolver);
        } catch (RuntimeException e) {
            C4904y.m18641c("group image name changed failed", getClass().getSimpleName());
        }
        while (true) {
            int i2 = i;
            if (i2 >= arrayListM9851a.size()) {
                break;
            }
            if (!arrayListM9861b.get(i2).toLowerCase().equals("Favorites".toLowerCase())) {
                try {
                    File file = new File(CommonApplication.m18732r().getFilesDir(), Integer.toString(arrayListM9851a.get(i2).intValue()) + "_group_profile.png_");
                    File file2 = new File(CommonApplication.m18732r().getFilesDir(), arrayListM9861b.get(i2) + "_group_profile.png_");
                    if (file.exists()) {
                        C4904y.m18641c("[LOCAL STORAGE]group image name changed " + arrayListM9851a.get(i2) + " to " + arrayListM9861b.get(i2) + " is " + Boolean.toString(file.renameTo(file2)), getClass().getSimpleName());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    File file3 = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "//profile");
                    if (file3.exists()) {
                        File file4 = new File(file3, String.format("%s_big.jpeg_", Integer.toString(arrayListM9851a.get(i2).intValue())));
                        File file5 = new File(file3, String.format("%s_big.jpeg_", arrayListM9861b.get(i2)));
                        if (file4.exists()) {
                            C4904y.m18641c("[SDCARD]group image name changed " + arrayListM9851a.get(i2) + " to " + arrayListM9861b.get(i2) + " is " + Boolean.toString(file4.renameTo(file5)), getClass().getSimpleName());
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                try {
                    File file6 = new File(CommonApplication.m18732r().getExternalFilesDir(null) + "/profile/", String.format("%s_big.jpeg_", Integer.toString(arrayListM9851a.get(i2).intValue())));
                    File file7 = new File(CommonApplication.m18732r().getExternalFilesDir(null) + "/profile/", String.format("%s_big.jpeg_", arrayListM9861b.get(i2)));
                    if (file6.exists()) {
                        C4904y.m18641c("[NEW SDCARD]group image name changed " + arrayListM9851a.get(i2) + " to " + arrayListM9861b.get(i2) + " is " + Boolean.toString(file6.renameTo(file7)), getClass().getSimpleName());
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                try {
                    File file8 = new File(C4873ck.m18502c() + "/" + Integer.toString(arrayListM9851a.get(i2).intValue()) + "/");
                    File file9 = new File(C4873ck.m18502c() + "/" + arrayListM9861b.get(i2) + "/");
                    if (file8.exists()) {
                        C4904y.m18641c("[CACHE DIR]group image name changed " + arrayListM9851a.get(i2) + " to " + arrayListM9861b.get(i2) + " is " + Boolean.toString(file8.renameTo(file9)), getClass().getSimpleName());
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            i = i2 + 1;
            C4904y.m18641c("group image name changed failed", getClass().getSimpleName());
            C4904y.m18641c("group image name changed delay " + (System.currentTimeMillis() - jCurrentTimeMillis) + " milles", getClass().getSimpleName());
        }
        m6460b(arrayListM9861b);
        C4809aa.m18104a().m18125b("Is Group Profile Image Name Changed", (Boolean) true);
        C4904y.m18641c("group image name changed delay " + (System.currentTimeMillis() - jCurrentTimeMillis) + " milles", getClass().getSimpleName());
    }

    /* renamed from: b */
    private void m6460b(ArrayList<String> arrayList) {
        String strM6523g;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                if (!arrayList.get(i2).toLowerCase().equals("Favorites".toLowerCase()) && (strM6523g = m6523g(arrayList.get(i2))) != null) {
                    C2134o.m9573a(this.f3748cl, strM6523g, arrayList.get(i2), arrayList.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m6523g(java.lang.String r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyFragment.m6523g(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x020e A[SYNTHETIC] */
    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreateContextMenu(android.view.ContextMenu r12, android.view.View r13, android.view.ContextMenu.ContextMenuInfo r14) {
        /*
            Method dump skipped, instructions count: 538
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyFragment.onCreateContextMenu(android.view.ContextMenu, android.view.View, android.view.ContextMenu$ContextMenuInfo):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006b  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m6591a(java.lang.String r9) throws java.lang.Throwable {
        /*
            r8 = this;
            r6 = 0
            r7 = 0
            android.support.v4.app.FragmentActivity r0 = r8.getActivity()     // Catch: android.database.CursorIndexOutOfBoundsException -> L43 java.lang.Throwable -> L5a
            android.content.Context r0 = r0.getApplicationContext()     // Catch: android.database.CursorIndexOutOfBoundsException -> L43 java.lang.Throwable -> L5a
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: android.database.CursorIndexOutOfBoundsException -> L43 java.lang.Throwable -> L5a
            android.net.Uri r1 = com.sec.chaton.p057e.C2230ar.f7958a     // Catch: android.database.CursorIndexOutOfBoundsException -> L43 java.lang.Throwable -> L5a
            r2 = 0
            java.lang.String r3 = "buddy_no=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: android.database.CursorIndexOutOfBoundsException -> L43 java.lang.Throwable -> L5a
            r5 = 0
            r4[r5] = r9     // Catch: android.database.CursorIndexOutOfBoundsException -> L43 java.lang.Throwable -> L5a
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: android.database.CursorIndexOutOfBoundsException -> L43 java.lang.Throwable -> L5a
            if (r1 == 0) goto L6b
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L61 android.database.CursorIndexOutOfBoundsException -> L68
            if (r0 <= 0) goto L6b
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L61 android.database.CursorIndexOutOfBoundsException -> L68
            java.lang.String r0 = "islike"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L61 android.database.CursorIndexOutOfBoundsException -> L68
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L61 android.database.CursorIndexOutOfBoundsException -> L68
            java.lang.String r2 = "Y"
            boolean r6 = r0.equals(r2)     // Catch: java.lang.Throwable -> L61 android.database.CursorIndexOutOfBoundsException -> L68
            r0 = r6
        L3d:
            if (r1 == 0) goto L42
            r1.close()
        L42:
            return r0
        L43:
            r0 = move-exception
            r0 = r7
        L45:
            java.lang.String r1 = "CursorIndexOob"
            java.lang.Class r2 = r8.getClass()     // Catch: java.lang.Throwable -> L64
            java.lang.String r2 = r2.getSimpleName()     // Catch: java.lang.Throwable -> L64
            com.sec.chaton.util.C4904y.m18634a(r1, r2)     // Catch: java.lang.Throwable -> L64
            if (r0 == 0) goto L58
            r0.close()
        L58:
            r0 = r6
            goto L42
        L5a:
            r0 = move-exception
        L5b:
            if (r7 == 0) goto L60
            r7.close()
        L60:
            throw r0
        L61:
            r0 = move-exception
            r7 = r1
            goto L5b
        L64:
            r1 = move-exception
            r7 = r0
            r0 = r1
            goto L5b
        L68:
            r0 = move-exception
            r0 = r1
            goto L45
        L6b:
            r0 = r6
            goto L3d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyFragment.m6591a(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) throws Throwable {
        boolean z = false;
        C1106c c1106c = this.f3671az;
        switch (menuItem.getItemId()) {
            case 101:
                if (c1106c.m7046a().startsWith("0999")) {
                    if (this.f3598E == null) {
                        this.f3598E = new C2210x(getActivity().getContentResolver(), this.f3767t);
                    }
                    this.f3598E.startQuery(1001, null, C2230ar.f7958a, null, "buddy_no = ? ", new String[]{c1106c.m7046a()}, null);
                    m6326V();
                } else {
                    Intent intent = new Intent(getActivity(), (Class<?>) BuddyProfileActivity.class);
                    intent.putExtra("PROFILE_BUDDY_NO", c1106c.m7046a());
                    intent.putExtra("PROFILE_BUDDY_NAME", c1106c.m7051b());
                    startActivityForResult(intent, 11);
                }
                return true;
            case 102:
                this.f3621aB.m7401a(c1106c);
                return true;
            case 103:
                this.f3621aB.m7404b(c1106c);
                return true;
            case 104:
                AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.buddy_list_contextual_menu_block)).mo18749b(getResources().getString(R.string.block_popup_body, c1106c.m7051b())).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1166cc(this, c1106c)).mo18741a(getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).mo18752b();
                return true;
            case 105:
            case 109:
            case 110:
            default:
                return true;
            case 106:
            case 107:
            case 108:
            case 115:
            case 120:
                m6366a(c1106c, menuItem.getItemId());
                return true;
            case 111:
                AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.buddy_group_list_dialog_removegroup_title)).mo18749b(getResources().getString(R.string.buddy_group_list_dialog_removegroup_message)).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1167cd(this, c1106c)).mo18741a(getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).mo18752b();
                return true;
            case 112:
                HashMap<String, String> mapM7076y = c1106c.m7076y();
                C1105b c1105b = new C1105b(Integer.parseInt(c1106c.m7046a()), c1106c.m7051b(), mapM7076y == null ? 0 : mapM7076y.size(), 2);
                Intent intent2 = new Intent(getActivity(), (Class<?>) BuddyGroupProfileActivity.class);
                intent2.putExtra("ACTIVITY_PURPOSE", 18);
                intent2.putExtra("groupInfo", c1105b);
                intent2.putExtra("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST", (String[]) c1106c.m7076y().keySet().toArray(new String[0]));
                startActivity(intent2);
                return true;
            case 113:
                if (this.f3620aA != null) {
                    SQLiteDatabase readableDatabase = C2268bn.m10126a(getActivity()).getReadableDatabase();
                    C2186al.m9764a(readableDatabase, c1106c.m7046a());
                    readableDatabase.close();
                }
                this.f3621aB.m7407c(c1106c);
                return true;
            case 114:
                if (this.f3620aA != null) {
                    SQLiteDatabase readableDatabase2 = C2268bn.m10126a(getActivity()).getReadableDatabase();
                    C2186al.m9771b(readableDatabase2, c1106c.m7046a());
                    readableDatabase2.close();
                }
                this.f3621aB.m7409d(c1106c);
                return true;
            case 116:
                AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.buddy_list_contextual_menu_hide)).mo18749b(getResources().getString(R.string.hide_popup_body, c1106c.m7051b())).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1165cb(this, c1106c)).mo18741a(getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).mo18752b();
                return true;
            case 117:
                m6326V();
                new C2128i(this.f3769v).m9516c(c1106c.m7046a());
                return true;
            case 118:
                m6488c(c1106c);
                return true;
            case 119:
                AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.buddy_list_contextual_menu_delete)).mo18749b(getResources().getString(R.string.delete_popup_body, c1106c.m7051b())).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1169cf(this, c1106c)).mo18741a(getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).mo18752b();
                return true;
            case 121:
                String strM7054c = c1106c.m7054c();
                boolean z2 = ((strM7054c.length() >= 19 && strM7054c.startsWith("10")) || strM7054c.startsWith(Spam.ACTIVITY_CANCEL)) && !TextUtils.isEmpty(c1106c.m7057f());
                C4892m.m18577c(true);
                if (!z2) {
                    if (strM7054c.length() >= 19 && strM7054c.startsWith("10") && !TextUtils.isEmpty(c1106c.m7056e())) {
                        z = true;
                    }
                    if (z) {
                        m6372a(z2, z, c1106c.m7054c(), c1106c);
                    } else if (strM7054c.startsWith("+")) {
                        m6372a(z2, z, strM7054c, c1106c);
                    } else {
                        m6372a(z2, z, "+" + strM7054c, c1106c);
                    }
                } else {
                    List<String> listM6505e = m6505e(c1106c);
                    if (listM6505e.size() == 1) {
                        if (listM6505e.get(0).startsWith("+")) {
                            m6372a(z2, false, listM6505e.get(0), c1106c);
                        } else {
                            m6372a(z2, false, "+" + listM6505e.get(0), c1106c);
                        }
                    } else if (listM6505e.size() > 1) {
                        Intent intent3 = new Intent(GlobalApplication.m18732r(), (Class<?>) PhoneNumberSelectorDialog.class);
                        intent3.putExtra("PN_DIALOG_BUDDY_TYPE", 2);
                        intent3.putExtra("PN_DIALOG_BUDDY_NAME", c1106c.m7051b());
                        intent3.putExtra("PN_DIALOG_BUDDY_MSISDNS", c1106c.m7057f());
                        if (c1106c.m7055d() != null) {
                            intent3.putExtra("PN_DIALOG_BUDDY_SAMSUNGEMAIL", c1106c.m7055d());
                        }
                        startActivity(intent3);
                    }
                }
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d3  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m6366a(com.sec.chaton.buddy.p050a.C1106c r5, int r6) {
        /*
            r4 = this;
            r2 = 0
            r1 = 1
            java.lang.String r0 = r5.m7046a()
            java.lang.String r3 = "0999"
            boolean r0 = r0.startsWith(r3)
            if (r0 == 0) goto L74
            android.content.Context r0 = com.sec.common.CommonApplication.m18732r()
            android.content.ContentResolver r0 = r0.getContentResolver()
            java.lang.String r3 = r5.m7046a()
            java.lang.String r0 = com.sec.chaton.p057e.p058a.C2186al.m9761a(r0, r3)
            com.sec.chaton.buddy.a.f r3 = com.sec.chaton.buddy.p050a.EnumC1109f.NONE
            java.lang.String r3 = r3.m7095a()
            int r3 = r0.compareTo(r3)
            if (r3 != 0) goto L2c
        L2b:
            return
        L2c:
            com.sec.chaton.buddy.a.f r3 = com.sec.chaton.buddy.p050a.EnumC1109f.CHAT
            java.lang.String r3 = r3.m7095a()
            int r3 = r0.compareTo(r3)
            if (r3 != 0) goto L3c
            r4.m6367a(r5, r6, r2)
            goto L2b
        L3c:
            com.sec.chaton.buddy.a.f r3 = com.sec.chaton.buddy.p050a.EnumC1109f.CONTENTS
            java.lang.String r3 = r3.m7095a()
            int r3 = r0.compareTo(r3)
            if (r3 == 0) goto L54
            com.sec.chaton.buddy.a.f r3 = com.sec.chaton.buddy.p050a.EnumC1109f.LIVEGROUP
            java.lang.String r3 = r3.m7095a()
            int r3 = r0.compareTo(r3)
            if (r3 != 0) goto L58
        L54:
            r4.m6367a(r5, r6, r1)
            goto L2b
        L58:
            com.sec.chaton.buddy.a.f r1 = com.sec.chaton.buddy.p050a.EnumC1109f.CHATCONTENTS
            java.lang.String r1 = r1.m7095a()
            int r1 = r0.compareTo(r1)
            if (r1 == 0) goto L70
            com.sec.chaton.buddy.a.f r1 = com.sec.chaton.buddy.p050a.EnumC1109f.LIVEGROUPCHAT
            java.lang.String r1 = r1.m7095a()
            int r0 = r0.compareTo(r1)
            if (r0 != 0) goto L2b
        L70:
            r4.m6367a(r5, r6, r2)
            goto L2b
        L74:
            boolean r0 = r5.m7074w()
            if (r0 != 0) goto Laf
            int r0 = r4.m6557p()
            if (r0 != r1) goto Ld3
            java.lang.String r0 = r5.m7046a()
            boolean r0 = m6463b(r0)
            if (r0 != r1) goto Ld3
            r0 = r1
        L8b:
            if (r0 != r1) goto Lce
            boolean r0 = r5.m7074w()
            if (r0 == 0) goto Lc9
            java.util.HashMap r0 = r5.m7076y()
            java.util.Set r0 = r0.keySet()
            java.lang.String[] r1 = new java.lang.String[r2]
            java.lang.Object[] r0 = r0.toArray(r1)
            java.lang.String[] r0 = (java.lang.String[]) r0
            int r0 = r0.length
            int r1 = r4.f3720bz
            int r1 = r1 + (-1)
            if (r0 > r1) goto Lc4
            r4.m6458b(r5, r6)
            goto L2b
        Laf:
            int r0 = r4.m6557p()
            if (r0 != r1) goto Ld3
            int r0 = r5.m7042E()
            r3 = -1
            if (r0 == r3) goto Ld3
            int r0 = r5.m7042E()
            if (r0 != r1) goto Ld3
            r0 = r1
            goto L8b
        Lc4:
            r4.m6367a(r5, r6, r2)
            goto L2b
        Lc9:
            r4.m6458b(r5, r6)
            goto L2b
        Lce:
            r4.m6367a(r5, r6, r2)
            goto L2b
        Ld3:
            r0 = r2
            goto L8b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyFragment.m6366a(com.sec.chaton.buddy.a.c, int):void");
    }

    /* renamed from: b */
    private void m6458b(C1106c c1106c, int i) {
        ArrayList arrayList = new ArrayList();
        if (i == 120) {
            arrayList.add("LIVE CHAT");
            arrayList.add("LIVE CONTENTS");
        } else {
            arrayList.add(GlobalApplication.m10283b().getString(R.string.buddy_list_add_to_home_screen));
            arrayList.add(GlobalApplication.m10283b().getString(R.string.buddy_list_set_for_chaton_voice_chat));
            arrayList.add(GlobalApplication.m10283b().getString(R.string.buddy_list_set_for_chaton_video_chat));
        }
        CharSequence[] charSequenceArr = (CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]);
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(getActivity());
        abstractC4932aM18733a.mo18740a(GlobalApplication.m10283b().getString(R.string.dialog_header_text));
        if (i == 120) {
            abstractC4932aM18733a.mo18744a(charSequenceArr, new DialogInterfaceOnClickListenerC1170cg(this, c1106c, i));
        } else {
            abstractC4932aM18733a.mo18744a(charSequenceArr, new DialogInterfaceOnClickListenerC1171ch(this, c1106c, i));
        }
        abstractC4932aM18733a.mo18745a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6367a(C1106c c1106c, int i, int i2) {
        C4904y.m18641c("[SHORTCUT] CONTEXT_MENU_ADD_SHORTCUT item=" + i + ", buddy=" + c1106c.m7046a(), getClass().getSimpleName());
        Intent intentM18132a = null;
        int i3 = R.drawable.shortcut_chat_icon;
        if (i == 120) {
            if (i2 == 0 || i2 == 1 || i2 == 0) {
                i3 = R.drawable.shortcut_livepartner_icon;
            }
        } else if (i2 == 0) {
            i3 = R.drawable.shortcut_chat_icon;
        } else if (i2 == 1) {
            i3 = R.drawable.shortcut_voicecall_icon;
        } else if (i2 == 2) {
            i3 = R.drawable.shortcut_videocall_icon;
        }
        if (i == 106) {
            if (i2 == 0) {
                intentM18132a = C4811ac.m18133a(getActivity(), c1106c.m7046a(), EnumC2300t.ONETOONE);
            } else if (i2 == 1) {
                intentM18132a = IntentControllerActivity.m2920a(getActivity());
                intentM18132a.putExtra("chatonno", c1106c.m7046a());
                intentM18132a.setAction(C1071bk.f3378l);
            } else if (i2 == 2) {
                intentM18132a = IntentControllerActivity.m2920a(getActivity());
                intentM18132a.putExtra("chatonno", c1106c.m7046a());
                intentM18132a.setAction(C1071bk.f3379m);
            } else if (i2 == 0 || i2 == 1 || i2 == 0) {
                intentM18132a = C4811ac.m18134a(getActivity(), c1106c.m7046a(), EnumC2300t.ONETOONE, EnumC2301u.LIVE);
            }
        }
        if (i == 115) {
            if (i2 == 0) {
                intentM18132a = C4811ac.m18132a(getActivity(), c1106c, EnumC2300t.ONETOONE);
            } else if (i2 == 1) {
                Intent intentM2920a = IntentControllerActivity.m2920a(getActivity());
                intentM2920a.putExtra("groupId", c1106c.m7046a());
                intentM2920a.putExtra("chatonno", (String[]) c1106c.m7076y().keySet().toArray(new String[0]));
                intentM2920a.setAction(C1071bk.f3380n);
                intentM18132a = intentM2920a;
            } else if (i2 == 2) {
                Intent intentM2920a2 = IntentControllerActivity.m2920a(getActivity());
                intentM2920a2.putExtra("groupId", c1106c.m7046a());
                intentM2920a2.putExtra("chatonno", (String[]) c1106c.m7076y().keySet().toArray(new String[0]));
                intentM2920a2.setAction(C1071bk.f3381o);
                intentM18132a = intentM2920a2;
            }
        }
        Intent intentM18134a = (i == 120 && (i2 == 0 || i2 == 1 || i2 == 0)) ? C4811ac.m18134a(getActivity(), c1106c.m7046a(), EnumC2300t.ONETOONE, EnumC2301u.LIVE) : intentM18132a;
        try {
            if (c1106c.m7074w()) {
                if (C2496n.m10772b(getActivity(), c1106c.m7051b(), 160).get() == null) {
                    ((BitmapDrawable) C2496n.m10779c(EnumC2498p.ROUND)).getBitmap();
                }
            } else if (C2496n.m10758a(getActivity(), c1106c.m7046a(), 160).get() == null) {
                ((BitmapDrawable) C2496n.m10754a(EnumC2498p.ROUND)).getBitmap();
            }
        } catch (Exception e) {
        }
        Bitmap bitmapM18135a = null;
        if (c1106c.m7074w()) {
            try {
                bitmapM18135a = C4811ac.m18135a(C2496n.m10787d(getActivity(), c1106c.m7051b(), 160), C2496n.m10768b(), i3);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } else {
            try {
                bitmapM18135a = C4811ac.m18135a(C2496n.m10781c(getActivity(), c1106c.m7046a(), 160), C2496n.m10751a(), i3);
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
        C4811ac.m18136a(getActivity(), intentM18134a, c1106c.m7051b(), Bitmap.createScaledBitmap(bitmapM18135a, C4811ac.m18131a(getResources().getDisplayMetrics().density), C4811ac.m18131a(getResources().getDisplayMetrics().density), true));
    }

    /* renamed from: b */
    public void m6594b(int i) {
        if (this.f3637aR != null) {
            if (i > 0) {
                if (i >= 100) {
                    this.f3637aR.setText(R.string.chat_max_unread);
                } else {
                    this.f3637aR.setText(String.valueOf(i));
                }
                this.f3637aR.setVisibility(0);
                return;
            }
            this.f3637aR.setVisibility(8);
        }
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) throws Resources.NotFoundException {
        this.f3681bJ = i2;
        this.f3682bK = i;
        C1106c c1106c = this.f3668aw.get(i).get(i2);
        if (c1106c.m7046a().equals(getActivity().getResources().getString(R.string.setting_interaction_me)) || C4809aa.m18104a().m18121a("chaton_id", "").compareTo(c1106c.m7046a()) == 0) {
            Intent intent = new Intent(getActivity(), (Class<?>) MeDialog.class);
            intent.putExtra("ME_DIALOG_NAME", c1106c.m7051b());
            intent.putExtra("ME_DIALOG_STATUSMSG", c1106c.m7054c());
            getActivity().startActivity(intent);
        }
        if (this.f3660ao == 1 || this.f3660ao == 23) {
            if (c1106c.m7046a().startsWith("0999")) {
                if (this.f3598E == null) {
                    this.f3598E = new C2210x(getActivity().getContentResolver(), this.f3767t);
                }
                this.f3598E.startQuery(1001, null, C2230ar.f7958a, null, "buddy_no = ? ", new String[]{c1106c.m7046a()}, null);
                m6326V();
            } else if (c1106c.m7074w()) {
                Intent intent2 = new Intent(getActivity(), (Class<?>) GroupDialog.class);
                intent2.setFlags(67108864);
                intent2.putExtra("GROUP_DIALOG_GROUP_NAME", c1106c.m7051b());
                intent2.putExtra("GROUP_DIALOG_CHAT_RECEIVER", (String[]) c1106c.m7076y().keySet().toArray(new String[0]));
                Iterator<String> it = c1106c.m7076y().keySet().iterator();
                StringBuffer stringBuffer = new StringBuffer();
                while (it.hasNext()) {
                    stringBuffer.append(c1106c.m7076y().get(it.next()) + ", ");
                }
                String string = stringBuffer.toString();
                if (string.endsWith(", ")) {
                    string = string.substring(0, string.length() - 2);
                }
                intent2.putExtra("GROUP_DIALOG_GROUP_MEMBERS", string);
                intent2.putExtra("GROUP_DIALOG_GROUP_ID", c1106c.m7046a());
                getActivity().startActivity(intent2);
            } else if (!c1106c.m7046a().equals(getActivity().getResources().getString(R.string.setting_interaction_me)) && C4809aa.m18104a().m18121a("chaton_id", "").compareTo(c1106c.m7046a()) != 0) {
                if (!C4822an.m18218a()) {
                }
                Intent intent3 = new Intent(getActivity(), (Class<?>) BuddyDialog.class);
                intent3.putExtra("BUDDY_DIALOG_BUDDY_NO", c1106c.m7046a());
                intent3.putExtra("BUDDY_DIALOG_BUDDY_NAME", c1106c.m7051b());
                intent3.setFlags(268435456);
                startActivity(intent3);
            }
        } else if (c1106c.m7074w()) {
            if (this.f3595B == 1 || this.f3595B == 2) {
                HashMap<String, String> mapM7076y = c1106c.m7076y();
                if (mapM7076y != null && m6518f(this.f3602I.m19638a() + mapM7076y.size())) {
                    return false;
                }
                if (mapM7076y != null && mapM7076y.size() > 0) {
                    Iterator<String> it2 = mapM7076y.keySet().iterator();
                    new C1255dp(this, view, Executors.newSingleThreadExecutor()).m19059d(mapM7076y);
                    while (it2.hasNext()) {
                        String strValueOf = String.valueOf(it2.next());
                        C4904y.m18639b(strValueOf + ", " + mapM7076y.get(strValueOf), f3576a);
                        if (this.f3762cz) {
                        }
                        if (m6334Z()) {
                            this.f3602I.setChildChecked(strValueOf, true);
                        }
                    }
                    if (this.f3742cf != null) {
                        this.f3742cf.mo6198a(this.f3602I.m19638a());
                    }
                }
            } else if (c1106c.m7076y().size() > C1427a.m7524g()) {
                m6370a((CharSequence) getResources().getString(R.string.buddy_list_select_maximum_contacts, Integer.valueOf(C1427a.m7524g())));
            } else if (this.f3630aK) {
                Intent intent4 = new Intent(getActivity(), (Class<?>) ChatActivity.class);
                intent4.setFlags(67108864);
                intent4.putExtra(ChatFragment.f5473i, true);
                intent4.putExtra("chatType", EnumC2300t.GROUPCHAT.m10210a());
                intent4.putExtra("receivers", (String[]) c1106c.m7076y().keySet().toArray(new String[0]));
                intent4.putExtra("groupId", c1106c.m7046a());
                intent4.putExtra("content_type", this.f3631aL);
                intent4.putExtra("download_uri", this.f3632aM);
                intent4.putExtra("sub_content", this.f3633aN);
                intent4.putExtra("forward_sender_name", this.f3634aO);
                intent4.putExtra("is_forward_mode", this.f3711bp);
                intent4.putExtra("forward_chat_message", this.f3712bq);
                intent4.putExtra(C1071bk.f3371e, this.f3635aP);
                startActivity(intent4);
            } else {
                Intent intent5 = new Intent(getActivity(), (Class<?>) GroupDialog.class);
                intent5.setFlags(67108864);
                intent5.putExtra("GROUP_DIALOG_GROUP_NAME", c1106c.m7051b());
                intent5.putExtra("GROUP_DIALOG_CHAT_RECEIVER", (String[]) c1106c.m7076y().keySet().toArray(new String[0]));
                Iterator<String> it3 = c1106c.m7076y().keySet().iterator();
                StringBuffer stringBuffer2 = new StringBuffer();
                while (it3.hasNext()) {
                    stringBuffer2.append(c1106c.m7076y().get(it3.next()) + ", ");
                }
                String string2 = stringBuffer2.toString();
                if (string2.endsWith(", ")) {
                    string2 = string2.substring(0, string2.length() - 2);
                }
                intent5.putExtra("GROUP_DIALOG_GROUP_MEMBERS", string2);
                intent5.putExtra("GROUP_DIALOG_GROUP_ID", c1106c.m7046a());
                startActivity(intent5);
            }
        } else if (this.f3595B == 0) {
            if (c1106c.m7046a().toString().startsWith("0999")) {
            }
            if (this.f3620aA != null) {
                this.f3620aA.m7128d((String) null);
            }
            if (this.f3660ao == 1000) {
                if (this.f3705bj) {
                    m6459b(c1106c.m7046a(), c1106c.m7051b());
                } else {
                    m6490c(new String[]{c1106c.m7046a()});
                }
                return true;
            }
            if (c1106c.m7046a().toString().startsWith("0999")) {
                this.f3621aB.m7405b(c1106c.m7046a());
                this.f3671az = c1106c;
            } else {
                this.f3621aB.m7402a(c1106c.m7046a());
                this.f3671az = c1106c;
            }
        } else {
            if (m6334Z()) {
                if (!this.f3602I.m19643b(c1106c.m7046a())) {
                    this.f3622aC.m19615a(c1106c.m7046a(), c1106c.m7051b());
                } else {
                    this.f3622aC.m19614a(c1106c.m7046a());
                }
            }
            m6587a(c1106c.m7046a(), c1106c.m7051b());
            m6605h();
            if (m6334Z() && this.f3616W.getVisibility() == 0) {
                this.f3616W.setChecked(false);
            } else {
                this.f3616W.setChecked(true);
            }
            if (this.f3641aV != null) {
                this.f3641aV.put(c1106c.m7046a(), c1106c.m7046a());
            }
        }
        if (this.f3709bn != null) {
            if (m6605h() > 0) {
                this.f3709bn.mo7134a(true);
            } else {
                this.f3709bn.mo7134a(false);
            }
        }
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public void onGroupExpand(int i) {
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public void onGroupCollapse(int i) {
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        return false;
    }

    /* renamed from: J */
    private void m6301J() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.f3677bF, 2);
            }
        } catch (Exception e) {
            if (C4904y.f17872b) {
                C4904y.m18634a(e.getMessage(), f3576a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public void m6304K() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (inputMethodManager != null && this.f3677bF != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f3677bF.getWindowToken(), 0);
            }
        } catch (Exception e) {
            if (C4904y.f17872b) {
                C4904y.m18634a(e.getMessage(), f3576a);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        C4904y.m18639b("onActivityResult()", f3576a);
        if (i == 100) {
            if (i2 == -1) {
                C4904y.m18639b("Add buddy success", f3576a);
                if (this.f3621aB != null) {
                    this.f3621aB.m7403b();
                    return;
                }
                return;
            }
            return;
        }
        if (i == 5 && i2 == -1) {
            String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
            Intent intent2 = new Intent(getActivity(), (Class<?>) ChatActivity.class);
            intent2.putExtra("receivers", stringArrayExtra);
            intent2.putExtra("inboxNO", this.f3619Z);
            intent2.putExtra("buddyNO", this.f3646aa);
            intent2.putExtra("chatType", this.f3647ab);
            getActivity().setResult(-1, intent2);
            getActivity().finish();
        }
        if (i == 101 && i2 == -1) {
            m6576y();
        }
        if (i == 102 && intent != null) {
            if (this.f3695bZ) {
                C4884g.m18545b(getActivity(), new DialogInterfaceOnClickListenerC1179cp(this, intent)).show();
            } else {
                m6461b((HashMap<String, String>) intent.getSerializableExtra("KEY_SELECTED_RESULT_FOR_COMPOSER"));
            }
        }
    }

    /* renamed from: L */
    private void m6305L() {
        Iterator<ArrayList<C1106c>> it = this.f3666au.iterator();
        while (it.hasNext()) {
            Iterator<C1106c> it2 = it.next().iterator();
            while (it2.hasNext()) {
                C1106c next = it2.next();
                if (next.m7063l() || next.m7073v() || next.m7072u()) {
                    this.f3621aB.m7413g();
                    return;
                }
            }
        }
    }

    /* renamed from: M */
    private void m6308M() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<ArrayList<C1106c>> it = this.f3666au.iterator();
        while (it.hasNext()) {
            Iterator<C1106c> it2 = it.next().iterator();
            while (it2.hasNext()) {
                C1106c next = it2.next();
                if (next.m7074w() && next.m7063l()) {
                    stringBuffer.append(next.m7046a() + ",");
                }
            }
        }
        if (this.f3660ao != 10 && stringBuffer.toString().length() > 0) {
            this.f3621aB.m7414h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public C1106c m6341a(String str, ArrayList<ArrayList<C1106c>> arrayList) {
        Iterator<ArrayList<C1106c>> it = arrayList.iterator();
        while (it.hasNext()) {
            Iterator<C1106c> it2 = it.next().iterator();
            while (it2.hasNext()) {
                C1106c next = it2.next();
                try {
                } catch (Exception e) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("findBuddy exception occured " + str, f3576a);
                    }
                }
                if (next.m7046a().equals(str) && !next.m7074w()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public void m6309N() {
        Intent intent = new Intent(getActivity(), (Class<?>) AddBuddyActivity.class);
        intent.putExtra("ADD_BUDDY_TYPE", 102);
        startActivityForResult(intent, 100);
    }

    /* renamed from: d */
    public void m6601d() {
        int iM6605h = m6605h();
        if (iM6605h > 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            boolean z = false;
            for (int i = 0; i < m6605h(); i++) {
                C1106c c1106cM6341a = m6341a(m6604g()[i], this.f3666au);
                if (c1106cM6341a != null) {
                    if (c1106cM6341a.m7043F() != null && c1106cM6341a.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                        arrayList2.add(c1106cM6341a.m7046a());
                        for (String str : c1106cM6341a.m7044G().split("\\s")) {
                            arrayList3.add(str);
                        }
                        z = true;
                    } else {
                        arrayList.add(c1106cM6341a.m7046a());
                    }
                }
            }
            if (iM6605h > C1427a.m7524g()) {
                if (z) {
                    C5179v.m19811a(getActivity(), String.format(getResources().getString(R.string.buddy_list_select_maximum_contacts_with_buddy), Integer.valueOf(C1427a.m7524g())), 0).show();
                    return;
                } else {
                    C5179v.m19811a(getActivity(), String.format(getResources().getString(R.string.buddy_list_select_maximum_contacts), Integer.valueOf(C1427a.m7524g())), 0).show();
                    return;
                }
            }
            if (iM6605h == 1) {
                this.f3621aB.m7402a(m6604g()[0]);
            } else {
                Intent intent = new Intent(getActivity(), (Class<?>) ChatActivity.class);
                intent.setFlags(67108864);
                intent.putExtra("chatType", EnumC2300t.GROUPCHAT.m10210a());
                intent.putExtra(ChatFragment.f5473i, true);
                intent.putExtra("receivers", (String[]) arrayList.toArray(new String[0]));
                intent.putExtra("contact_receivers_id", (String[]) arrayList2.toArray(new String[0]));
                intent.putExtra("contact_receivers_phone", (String[]) arrayList3.toArray(new String[0]));
                if (this.f3673bB != null && m6605h() == this.f3673bB.m7076y().size() && this.f3602I.m19641a((String[]) this.f3673bB.m7076y().keySet().toArray(new String[0]))) {
                    intent.putExtra("groupId", this.f3673bB.m7046a());
                }
                if (this.f3630aK) {
                    intent.putExtra("content_type", this.f3631aL);
                    intent.putExtra("download_uri", this.f3632aM);
                    intent.putExtra("sub_content", this.f3633aN);
                    intent.putExtra("forward_sender_name", this.f3634aO);
                    intent.putExtra("is_forward_mode", this.f3711bp);
                    intent.putExtra("forward_chat_message", this.f3712bq);
                    intent.putExtra(C1071bk.f3371e, this.f3635aP);
                }
                startActivity(intent);
            }
            if (!this.f3707bl) {
                getActivity().finish();
            }
        }
    }

    /* renamed from: e */
    public void m6602e() {
        int iM6605h = m6605h();
        if (iM6605h > 0) {
            if (iM6605h <= C1427a.m7523f()) {
                Intent intent = new Intent(getActivity(), (Class<?>) ChatActivity.class);
                intent.setFlags(67108864);
                intent.putExtra(ChatFragment.f5473i, true);
                if (C2349a.m10301a("broadcast2_feature")) {
                    intent.putExtra("chatType", EnumC2300t.BROADCAST2.m10210a());
                } else {
                    intent.putExtra("chatType", EnumC2300t.BROADCAST.m10210a());
                }
                LinearLayout linearLayout = (LinearLayout) this.f3622aC.getChildAt(0);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < linearLayout.getChildCount(); i++) {
                    arrayList.add(linearLayout.getChildAt(i).getTag().toString());
                }
                intent.putExtra("receivers", (String[]) arrayList.toArray(new String[0]));
                if (this.f3630aK) {
                    intent.putExtra("content_type", this.f3631aL);
                    intent.putExtra("sub_content", this.f3633aN);
                    intent.putExtra("forward_sender_name", this.f3634aO);
                    intent.putExtra("is_forward_mode", this.f3711bp);
                    intent.putExtra("forward_chat_message", this.f3712bq);
                    intent.putExtra("download_uri", this.f3632aM);
                    intent.putExtra(C1071bk.f3371e, this.f3635aP);
                }
                startActivity(intent);
                if (!this.f3707bl) {
                    getActivity().finish();
                    return;
                }
                return;
            }
            C5179v.m19811a(getActivity(), String.format(getResources().getString(R.string.buddy_list_select_maximum_contacts), Integer.valueOf(C1427a.m7523f())), 0).show();
        }
    }

    /* renamed from: c */
    private void m6488c(C1106c c1106c) {
        C1105b c1105b = new C1105b(Integer.parseInt(c1106c.m7046a()), c1106c.m7051b(), c1106c.m7076y().keySet().toArray(new String[0]) == null ? 0 : ((String[]) c1106c.m7076y().keySet().toArray(new String[0])).length, 18);
        Intent intent = new Intent(getActivity(), (Class<?>) BuddyGroupMemberEditActivity.class);
        intent.putExtra("ACTIVITY_PURPOSE", 19);
        intent.putExtra("groupInfo", c1105b);
        intent.putExtra("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST", (String[]) c1106c.m7076y().keySet().toArray(new String[0]));
        startActivity(intent);
    }

    /* renamed from: O */
    private boolean m6312O() {
        int iM10677a = C2471v.m10677a(GlobalApplication.m18732r());
        if (-3 != iM10677a && -2 != iM10677a) {
            return true;
        }
        C5179v.m19810a(GlobalApplication.m18732r(), R.string.popup_no_network_connection, 0).show();
        return false;
    }

    /* renamed from: P */
    private boolean m6314P() {
        if (!m6413af()) {
            startActivity(new Intent(GlobalApplication.m18732r(), (Class<?>) ChatONVRedirectDialog.class));
            return false;
        }
        if (!m6409ad()) {
            startActivity(new Intent(GlobalApplication.m18732r(), (Class<?>) ChatONVInstallDialog.class));
            return false;
        }
        return true;
    }

    /* renamed from: Q */
    private void m6316Q() {
        int iM1488a;
        if (m6314P() && m6312O()) {
            LinearLayout linearLayout = (LinearLayout) this.f3622aC.getChildAt(0);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                arrayList.add(linearLayout.getChildAt(i).getTag().toString());
            }
            try {
                if (arrayList.size() == 1) {
                    iM1488a = this.f3756ct.m1487a(getActivity(), false, (String) arrayList.get(0), C4809aa.m18104a().m18121a("Push Name", ""), null);
                } else {
                    iM1488a = this.f3756ct.m1488a(getActivity(), false, (String[]) arrayList.toArray(new String[arrayList.size()]), C4809aa.m18104a().m18121a("Push Name", ""), null, null);
                }
            } catch (Exception e) {
                C4904y.m18635a(e, getClass().getSimpleName());
                iM1488a = -1;
            }
            if (iM1488a != 0) {
                C5179v.m19810a(GlobalApplication.m18732r(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
            }
            if (!this.f3707bl) {
                getActivity().finish();
            }
        }
    }

    /* renamed from: R */
    private void m6318R() {
        int iM1488a;
        if (m6314P() && m6312O()) {
            LinearLayout linearLayout = (LinearLayout) this.f3622aC.getChildAt(0);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                arrayList.add(linearLayout.getChildAt(i).getTag().toString());
            }
            try {
                if (arrayList.size() == 1) {
                    iM1488a = this.f3756ct.m1487a(getActivity(), true, (String) arrayList.get(0), C4809aa.m18104a().m18121a("Push Name", ""), null);
                } else {
                    iM1488a = this.f3756ct.m1488a(getActivity(), true, (String[]) arrayList.toArray(new String[arrayList.size()]), C4809aa.m18104a().m18121a("Push Name", ""), null, null);
                }
            } catch (Exception e) {
                C4904y.m18635a(e, getClass().getSimpleName());
                iM1488a = -1;
            }
            if (iM1488a != 0) {
                C5179v.m19810a(GlobalApplication.m18732r(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
            }
            if (!this.f3707bl) {
                getActivity().finish();
            }
        }
    }

    /* renamed from: h */
    private void m6533h(String str) {
        if (m6605h() > 0) {
            int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
            if (-3 == iM10677a || -2 == iM10677a) {
                C5179v.m19810a(getActivity(), R.string.popup_no_network_connection, 0).show();
                return;
            }
            new C2128i(this.f3757cu).m9489a("group", false, (String) null, str, m6604g(), 325);
            if (this.f3625aF == null) {
                this.f3625aF = ProgressDialogC4926s.m18728a(getActivity(), null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            } else {
                this.f3625aF.show();
            }
        }
    }

    /* renamed from: S */
    private void m6319S() {
        int iM6605h = m6605h();
        C4904y.m18639b("Button.OnClickListener() : INVITE BUDDY", f3576a);
        C4904y.m18639b("count : " + iM6605h, f3576a);
        C4904y.m18639b("mBundle.getStringArray(ChatFragment.EXTRA_PARTICIPANT).length : " + this.f3657al.getStringArray(ChatFragment.f5465d).length, f3576a);
        C4904y.m18639b("mBundle.getInt(ChatFragment.KEY_CHAT_TYPE) : " + this.f3657al.getInt("chatType"), f3576a);
        if (iM6605h > 0) {
            LinearLayout linearLayout = (LinearLayout) this.f3622aC.getChildAt(0);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            linearLayout.getChildCount();
            boolean z = false;
            for (int i = 0; i < iM6605h; i++) {
                C1106c c1106cM6341a = m6341a(m6604g()[i], this.f3666au);
                if (c1106cM6341a != null) {
                    if (c1106cM6341a.m7043F() != null && c1106cM6341a.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                        arrayList2.add(c1106cM6341a.m7046a());
                        arrayList3.add(c1106cM6341a.m7044G());
                        z = true;
                    } else {
                        arrayList.add(c1106cM6341a.m7046a());
                    }
                }
            }
            if (this.f3657al.getInt("chatType") == EnumC2300t.GROUPCHAT.m10210a() || this.f3657al.getInt("chatType") == EnumC2300t.ONETOONE.m10210a()) {
                if (this.f3657al.getStringArray(ChatFragment.f5465d).length + iM6605h > C1427a.m7524g()) {
                    if (z) {
                        C5179v.m19811a(getActivity(), String.format(getResources().getString(R.string.buddy_list_select_maximum_contacts_with_buddy), Integer.valueOf(C1427a.m7524g())), 0).show();
                        return;
                    } else {
                        C5179v.m19811a(getActivity(), String.format(getResources().getString(R.string.buddy_list_select_maximum_contacts), Integer.valueOf(C1427a.m7524g())), 0).show();
                        return;
                    }
                }
            } else if (EnumC2300t.m10208a(EnumC2300t.m10207a(this.f3657al.getInt("chatType"))) && this.f3657al.getStringArray(ChatFragment.f5465d).length + iM6605h > C1427a.m7523f()) {
                C5179v.m19811a(getActivity(), String.format(getResources().getString(R.string.buddy_list_select_maximum_contacts), Integer.valueOf(C1427a.m7523f())), 0).show();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("receivers", (String[]) arrayList.toArray(new String[0]));
            intent.putExtra("contact_receivers_id", (String[]) arrayList2.toArray(new String[0]));
            intent.putExtra("contact_receivers_phone", (String[]) arrayList3.toArray(new String[0]));
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    /* renamed from: T */
    private void m6321T() {
        Intent intent = new Intent();
        intent.putExtra("blindlist", m6604g());
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    /* renamed from: U */
    private void m6324U() {
        if (this.f3660ao == 2) {
            m6601d();
            return;
        }
        if (this.f3660ao == 3) {
            m6602e();
            return;
        }
        if (this.f3660ao == 14) {
            m6316Q();
            return;
        }
        if (this.f3660ao == 15) {
            m6318R();
            return;
        }
        if (this.f3660ao == 10) {
            m6533h(this.f3657al.getString("ACTIVITY_PURPOSE_ARG2"));
            return;
        }
        if (this.f3660ao == 5) {
            m6319S();
            return;
        }
        if (this.f3660ao == 9 || this.f3660ao == 24 || this.f3660ao == 25) {
            m6321T();
            return;
        }
        if (this.f3660ao == 1000) {
            if (getActivity().getIntent().getStringExtra("fromsms") != null) {
                m6598c(true);
                return;
            } else {
                m6490c(m6604g());
                return;
            }
        }
        if (this.f3660ao == 6 && this.f3657al.containsKey("ACTIVITY_PURPOSE_ARG") && !this.f3657al.getBoolean("ACTIVITY_PURPOSE_ARG")) {
            if (this.f3743cg != null) {
                this.f3743cg.mo7417a(this.f3666au, m6604g());
                return;
            }
            return;
        }
        if (this.f3660ao == 23) {
        }
    }

    /* renamed from: c */
    private void m6490c(String[] strArr) {
        Intent intent = new Intent();
        intent.putExtra("result", strArr);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6500d(String[] strArr) {
        HashMap map = new HashMap();
        for (String str : strArr) {
            C1106c c1106cM6341a = m6341a(str, this.f3666au);
            if (c1106cM6341a != null) {
                if (c1106cM6341a.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                    map.put(c1106cM6341a.m7054c(), c1106cM6341a.m7051b());
                } else {
                    map.put(c1106cM6341a.m7044G(), c1106cM6341a.m7051b());
                }
            }
        }
        Intent intent = new Intent();
        intent.putExtra("result", map);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6461b(HashMap<String, String> map) {
        Intent intent = new Intent();
        intent.putExtra("result", map);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    /* renamed from: b */
    private void m6459b(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("chaton_buddy_number", str);
        intent.putExtra("chaton_buddy_name", str2);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    /* renamed from: f */
    public HashSet<String> m6603f() {
        return this.f3602I != null ? this.f3602I.m19642b() : new HashSet<>();
    }

    /* renamed from: g */
    public String[] m6604g() {
        return this.f3602I != null ? this.f3602I.m19644c() : new String[0];
    }

    /* renamed from: h */
    public int m6605h() {
        if (this.f3602I != null) {
            return this.f3602I.m19638a();
        }
        return 0;
    }

    /* renamed from: i */
    public String[] m6606i() {
        return (String[]) this.f3747ck.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public void m6326V() {
        if (getActivity() != null) {
            if (this.f3624aE == null) {
                this.f3624aE = ProgressDialogC4926s.m18728a(getActivity(), null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            } else {
                this.f3624aE.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W */
    public void m6327W() {
        if (getActivity() != null && this.f3624aE != null) {
            this.f3624aE.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6370a(CharSequence charSequence) {
        if (this.f3642aW == null) {
            this.f3642aW = C5179v.m19811a(getActivity(), (CharSequence) null, 0);
        }
        this.f3642aW.setText(charSequence);
        this.f3642aW.show();
    }

    /* renamed from: a */
    private void m6349a(Bundle bundle) {
        if (bundle == null) {
            this.f3660ao = 1;
            this.f3659an = this.f3658am;
        } else {
            this.f3660ao = bundle.getInt("ACTIVITY_PURPOSE", 1);
            this.f3661ap = bundle.getInt("ACTIVITY_PURPOSE_ARG2");
            this.f3638aS = bundle.getString("require");
            this.f3648ac = this.f3657al.getStringArray(ChatFragment.f5465d);
            this.f3692bW = (ArrayList) this.f3657al.getSerializable("live_group_followers");
            this.f3763f = (C1105b) bundle.get("groupInfo");
            this.f3594A = bundle.getBoolean("PROFILE_BUDDY_FROM_CHATINFO", this.f3594A);
        }
        if (this.f3660ao == 2 || this.f3660ao == 3 || this.f3660ao == 12 || this.f3660ao == 10 || this.f3660ao == 11 || this.f3660ao == 19 || this.f3660ao == 5 || ((this.f3660ao == 6 && this.f3657al.containsKey("ACTIVITY_PURPOSE_ARG") && !this.f3657al.getBoolean("ACTIVITY_PURPOSE_ARG")) || this.f3660ao == 20 || this.f3660ao == 8 || this.f3660ao == 9 || this.f3660ao == 24 || this.f3660ao == 25 || this.f3660ao == 15 || this.f3660ao == 14 || this.f3660ao == 1 || this.f3660ao == 23)) {
            this.f3595B = 2;
        } else {
            this.f3595B = 0;
        }
        this.f3759cw = 1;
        this.f3758cv = 0;
        if (this.f3660ao == 2) {
            this.f3760cx = C1427a.m7524g();
            this.f3761cy = R.string.buddy_list_select_maximum_contacts;
        } else if (this.f3660ao == 3) {
            this.f3760cx = C1427a.m7523f();
            this.f3761cy = R.string.buddy_list_select_maximum_contacts;
        } else if (this.f3660ao == 15) {
            this.f3760cx = this.f3672bA - 1;
            this.f3761cy = R.string.chatonv_max_call_members_limit_msg;
        } else if (this.f3660ao == 14) {
            this.f3760cx = this.f3720bz - 1;
            this.f3761cy = R.string.chatonv_max_call_members_limit_msg;
        } else if (this.f3660ao == 5) {
            this.f3758cv = this.f3657al.getStringArray(ChatFragment.f5465d).length;
            int i = this.f3657al.getInt("chatType");
            if (i == EnumC2300t.ONETOONE.m10210a() || i == EnumC2300t.GROUPCHAT.m10210a()) {
                this.f3760cx = C1427a.m7524g();
                this.f3761cy = R.string.buddy_list_select_maximum_contacts;
            } else if (EnumC2300t.m10208a(EnumC2300t.m10207a(i))) {
                this.f3760cx = C1427a.m7523f();
                this.f3761cy = R.string.buddy_list_select_maximum_contacts;
            } else {
                this.f3761cy = R.string.buddy_list_select_maximum_contacts;
            }
        } else if (this.f3660ao == 9 || this.f3660ao == 6 || this.f3660ao == 24 || this.f3660ao == 25) {
            if (this.f3660ao == 6 && this.f3657al.containsKey("ACTIVITY_PURPOSE_ARG") && !this.f3657al.getBoolean("ACTIVITY_PURPOSE_ARG")) {
                this.f3760cx = C1427a.m7524g();
                this.f3761cy = R.string.buddy_list_select_maximum_contacts;
            }
        } else if (this.f3660ao == 10 || this.f3660ao == 19 || this.f3660ao == 23) {
            this.f3760cx = C1427a.m7524g();
            this.f3761cy = R.string.buddy_list_select_maximum_contacts;
        }
        if (this.f3660ao == 6) {
            if (this.f3657al.containsKey("ACTIVITY_PURPOSE_CALLLOG_GROUP") && this.f3657al.getBoolean("ACTIVITY_PURPOSE_CALLLOG_GROUP")) {
                this.f3721cA = 4;
            } else {
                this.f3721cA = 3;
            }
        } else if (this.f3660ao == 8) {
            this.f3721cA = 0;
            this.f3760cx = C1427a.m7523f();
            this.f3761cy = R.string.buddy_list_broadcast_toast_failed_exceed;
        } else if (this.f3660ao == 18) {
            this.f3721cA = 2;
        } else if (this.f3660ao == 23) {
            this.f3721cA = 5;
        } else {
            this.f3721cA = 0;
        }
        if (this.f3660ao == 5 || this.f3660ao == 8 || this.f3660ao == 9 || this.f3660ao == 24 || this.f3660ao == 25 || this.f3660ao == 10 || this.f3660ao == 19 || this.f3660ao == 2 || this.f3660ao == 3 || this.f3660ao == 15 || this.f3660ao == 14) {
            if (this.f3660ao == 8 && bundle.containsKey("chatType")) {
                EnumC2300t enumC2300tM10207a = EnumC2300t.m10207a(bundle.getInt("chatType"));
                if (enumC2300tM10207a == EnumC2300t.BROADCAST || enumC2300tM10207a == EnumC2300t.GROUPCHAT) {
                    this.f3762cz = false;
                } else {
                    this.f3762cz = true;
                }
            } else {
                this.f3762cz = true;
            }
        } else {
            this.f3762cz = false;
        }
        if (this.f3660ao == 1000) {
            this.f3760cx = bundle.getInt("max", -1);
            this.f3759cw = bundle.getInt("min", 1);
            this.f3761cy = R.string.buddy_list_select_maximum_contacts;
            this.f3648ac = bundle.getStringArray("except");
            m6440at();
            if (this.f3648ac != null && this.f3648ac.length > 0) {
                this.f3762cz = true;
                this.f3758cv = 0;
                if (this.f3760cx != -1 && bundle.getString("fromsms") == null) {
                    this.f3760cx -= this.f3648ac.length + 1;
                }
            } else {
                this.f3762cz = false;
                this.f3758cv = 0;
            }
            if (bundle.getBoolean("single", false) || this.f3705bj) {
                this.f3595B = 0;
                this.f3721cA = 1;
            } else {
                this.f3595B = 2;
                this.f3721cA = 0;
            }
            this.f3695bZ = bundle.getBoolean("from_send_invitation");
            if (this.f3695bZ) {
                this.f3737ca = (HashSet) bundle.getSerializable("freesms_invite_list");
                if (this.f3737ca != null && this.f3737ca.size() > 0) {
                    this.f3738cb = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public void m6329X() {
        int iM19638a = this.f3602I.m19638a();
        C4904y.m18639b("check=" + iM19638a + ", def=" + this.f3758cv + ", min=" + this.f3759cw + ", max=" + this.f3760cx, f3576a);
        if (this.f3759cw != -1 && iM19638a < this.f3759cw) {
            if (this.f3709bn != null) {
                this.f3709bn.mo7134a(false);
            }
        } else if (this.f3760cx != -1 && iM19638a + this.f3758cv > this.f3760cx) {
            if (this.f3709bn != null) {
                this.f3709bn.mo7134a(false);
            }
            m6403aa();
        } else if (this.f3709bn != null) {
            this.f3709bn.mo7134a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y */
    public void m6331Y() {
        int iM19638a = this.f3602I.m19638a();
        C4904y.m18639b("check=" + iM19638a, f3576a);
        if (iM19638a == 0) {
            this.f3651af.setEnabled(false);
            this.f3652ag.setEnabled(false);
        }
        if (iM19638a > C1427a.m7524g()) {
            m6370a((CharSequence) getResources().getString(R.string.buddy_list_select_maximum_contacts, Integer.valueOf(C1427a.m7524g())));
            this.f3651af.setEnabled(false);
        } else {
            this.f3651af.setEnabled(true);
        }
        if (iM19638a > C1427a.m7523f()) {
            m6370a((CharSequence) getResources().getString(R.string.buddy_list_select_maximum_contacts, Integer.valueOf(C1427a.m7523f())));
            this.f3652ag.setEnabled(false);
        } else {
            this.f3652ag.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public boolean m6334Z() {
        if (this.f3760cx == -1) {
            return true;
        }
        int iM19638a = this.f3602I != null ? this.f3602I.m19638a() : 0;
        C4904y.m18639b("canSelectMore check=" + iM19638a + ", def=" + this.f3758cv + ", min=" + this.f3759cw + ", max=" + this.f3760cx, f3576a);
        return iM19638a + this.f3758cv < this.f3760cx;
    }

    /* renamed from: aa */
    private void m6403aa() {
        C4904y.m18639b("showSelectionReachedMaximumPopup " + this.f3760cx, f3576a);
        m6370a((CharSequence) getActivity().getString(this.f3761cy, new Object[]{Integer.valueOf(this.f3760cx)}));
    }

    @Override // com.sec.chaton.base.InterfaceC1061c
    public boolean onBackKeyPressed() throws Resources.NotFoundException {
        if (m6605h() <= 0 || this.f3660ao != 1) {
            return false;
        }
        m6595b(true);
        this.f3739cc.setVisibility(8);
        m6608k();
        return true;
    }

    /* renamed from: ab */
    private void m6405ab() {
        this.f3645aZ = new C4851bp();
        this.f3645aZ.m18339a("get_all_buddies_in_buddylist", this.f3722cB, 3600000L, "last_sync_time_get_all_buddies_in_buddylist");
        if (C2349a.m10301a("sms_feature") && TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
            this.f3645aZ.m18339a("local_calculation_in_buddylist", this.f3723cC, 60000L, "last_sync_time_on_start_in_buddylist");
        }
    }

    /* renamed from: j */
    public void m6607j() {
        if (this.f3677bF != null) {
            this.f3677bF.requestFocus();
        }
    }

    /* renamed from: a */
    public void m6585a(InterfaceC1257dr interfaceC1257dr) {
        this.f3709bn = interfaceC1257dr;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (f3581c != 0) {
            bundle.putInt("INDEX", f3581c);
            bundle.putInt("TOP", f3582d);
            bundle.putBoolean("savedInstanceStateCheck", true);
            return;
        }
        bundle.putBoolean("savedInstanceStateCheck", false);
    }

    /* renamed from: k */
    public void m6608k() {
        if (m6605h() > 0) {
            this.f3713br.setVisibility(8);
            return;
        }
        if (C2349a.m10301a("for_wifi_only_device") || !TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", "")) || C4822an.m18196F()) {
            this.f3714bs = true;
        } else {
            this.f3714bs = false;
        }
        this.f3715bt = C4822an.m18255w();
        if (this.f3713br != null && (this.f3660ao == 1 || this.f3660ao == 7)) {
            if (!this.f3714bs) {
                if (C2349a.m10301a("sms_feature")) {
                    if (C4822an.m18218a()) {
                        this.f3713br.setVisibility(0);
                        return;
                    } else {
                        this.f3713br.setVisibility(8);
                        return;
                    }
                }
                this.f3713br.setVisibility(0);
                return;
            }
            this.f3713br.setVisibility(8);
            return;
        }
        if (this.f3713br != null) {
            this.f3713br.setVisibility(8);
        }
    }

    @Override // com.sec.chaton.buddy.InterfaceC1122am
    /* renamed from: a */
    public void mo6584a(C1106c c1106c, View view) throws Resources.NotFoundException {
        this.f3671az = c1106c;
        if (this.f3660ao == 1 || this.f3660ao == 1000 || this.f3660ao == 23) {
            if (c1106c.m7074w()) {
                if (this.f3595B == 1 || this.f3595B == 2) {
                    HashMap<String, String> mapM7076y = c1106c.m7076y();
                    if (mapM7076y != null && mapM7076y.size() > 0) {
                        Iterator<String> it = mapM7076y.keySet().iterator();
                        while (it.hasNext()) {
                            String strValueOf = String.valueOf(it.next());
                            String str = this.f3762cz ? null : mapM7076y.get(strValueOf);
                            if (mo6597b(c1106c)) {
                                if (((CheckBox) view).isChecked()) {
                                    m6592a(strValueOf, !this.f3602I.m19645d(), str, true, true);
                                    this.f3673bB = c1106c;
                                    ((CheckBox) view).setChecked(!this.f3602I.m19645d());
                                } else {
                                    m6592a(strValueOf, this.f3602I.m19645d(), str, true, true);
                                    ((CheckBox) view).setChecked(this.f3602I.m19645d());
                                }
                            }
                        }
                        if (this.f3742cf != null) {
                            this.f3742cf.mo6198a(this.f3602I.m19638a());
                        }
                    }
                    if (((CheckBox) view).isChecked()) {
                        ((CheckBox) view).setChecked(false);
                        new C1255dp(this, view, Executors.newSingleThreadExecutor()).m19059d(mapM7076y);
                    } else {
                        ((CheckBox) view).setChecked(true);
                    }
                }
            } else if (this.f3595B == 0) {
                this.f3620aA.m7128d((String) null);
                if (this.f3660ao == 1000) {
                    if (this.f3705bj) {
                        m6459b(c1106c.m7046a(), c1106c.m7051b());
                        return;
                    } else {
                        m6490c(new String[]{c1106c.m7046a()});
                        return;
                    }
                }
            } else {
                int iM6605h = m6605h();
                m6587a(c1106c.m7046a(), c1106c.m7051b());
                int iM6605h2 = m6605h();
                if (this.f3760cx != -1 && m6605h() + this.f3758cv > this.f3760cx) {
                    this.f3602I.setChildChecked(c1106c.m7046a(), false);
                    C4904y.m18639b("showSelectionReachedMaximumPopup " + this.f3760cx, f3576a);
                    m6370a((CharSequence) getActivity().getString(this.f3761cy, new Object[]{Integer.valueOf(this.f3760cx)}));
                } else if (m6502d(c1106c.m7046a())) {
                    if (((CheckBox) view).isChecked() && iM6605h != iM6605h2) {
                        this.f3602I.setChildChecked(c1106c.m7046a(), true);
                        this.f3622aC.m19615a(c1106c.m7046a(), c1106c.m7051b());
                        ((CheckBox) view).setChecked(true);
                    } else {
                        this.f3602I.setChildChecked(c1106c.m7046a(), false);
                        ((CheckBox) view).setChecked(false);
                    }
                }
                if (m6334Z() && this.f3616W.getVisibility() == 0) {
                    this.f3616W.setChecked(false);
                } else {
                    this.f3616W.setChecked(true);
                }
            }
            if (this.f3660ao == 1) {
                if (m6557p() == 1) {
                    if (m6605h() > 0) {
                        if (this.f3713br != null) {
                            this.f3713br.setVisibility(8);
                        }
                    } else {
                        m6608k();
                    }
                } else if (m6605h() > 0) {
                    this.f3739cc.setVisibility(0);
                    if (this.f3713br != null) {
                        this.f3713br.setVisibility(8);
                    }
                } else {
                    this.f3739cc.setVisibility(8);
                    m6608k();
                }
                ((ActionBarFragmentActivity) getActivity()).mo51u_();
            } else if (this.f3660ao == 23 && m6557p() != 1) {
                if (this.f3654ai == null) {
                    this.f3654ai = (ImageButton) getView().findViewById(R.id.button_chatonvideo);
                }
                if (this.f3653ah == null) {
                    this.f3653ah = (ImageButton) getView().findViewById(R.id.button_chatonvoice);
                }
                this.f3654ai.setVisibility(8);
                this.f3653ah.setVisibility(8);
            }
        }
        if (m6605h() > 0) {
            f3585k = true;
            m6534h(true);
        } else {
            f3585k = false;
            m6526g(true);
        }
        ((ActionBarFragmentActivity) getActivity()).mo51u_();
        if (this.f3620aA != null) {
            if (m6605h() == 0) {
                f3589o = f3590p;
            } else if (c1106c.m7043F().compareTo(Spam.ACTIVITY_REPORT) != 0) {
                f3589o = f3591q;
            } else {
                f3589o = f3592r;
            }
        }
    }

    /* renamed from: ac */
    private void m6407ac() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (this.f3739cc != null) {
            if (m6605h() == 0 || (this.f3660ao != 1 && this.f3660ao != 23)) {
                this.f3739cc.setVisibility(8);
            } else {
                this.f3739cc.setVisibility(0);
                if (this.f3655aj == null) {
                    this.f3655aj = (ImageButton) getView().findViewById(R.id.button_sms);
                }
                this.f3655aj.setVisibility(0);
                if (this.f3656ak == null) {
                    this.f3656ak = (ImageButton) getView().findViewById(R.id.button_call);
                }
                this.f3656ak.setVisibility(0);
                if (this.f3651af == null) {
                    this.f3651af = (ImageButton) getView().findViewById(R.id.button_chatonvideo);
                }
                this.f3651af.setVisibility(0);
                if (this.f3652ag == null) {
                    this.f3652ag = (ImageButton) getView().findViewById(R.id.button_chatonvoice);
                }
                this.f3652ag.setVisibility(0);
                if (m6605h() == 1) {
                    this.f3652ag.setVisibility(8);
                    C1106c c1106cM6341a = m6341a(m6604g()[0], this.f3666au);
                    if (c1106cM6341a == null) {
                        this.f3739cc.setVisibility(8);
                        return;
                    }
                    if (TextUtils.isEmpty(c1106cM6341a.m7044G())) {
                        this.f3655aj.setVisibility(8);
                        this.f3656ak.setVisibility(8);
                    }
                    if (c1106cM6341a.m7043F() != null && c1106cM6341a.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                        this.f3651af.setVisibility(8);
                        this.f3656ak.setVisibility(0);
                    } else if (TextUtils.isEmpty(c1106cM6341a.m7044G())) {
                        this.f3655aj.setVisibility(8);
                        this.f3656ak.setVisibility(8);
                    }
                } else {
                    System.currentTimeMillis();
                    String[] strArrM6604g = m6604g();
                    if (C2349a.m10301a("sms_feature")) {
                        int i = 0;
                        while (true) {
                            if (i >= strArrM6604g.length) {
                                z2 = true;
                                break;
                            }
                            C1106c c1106cM6341a2 = m6341a(strArrM6604g[i], this.f3666au);
                            if (c1106cM6341a2 != null && c1106cM6341a2.m7043F() != null && c1106cM6341a2.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                                z2 = false;
                                break;
                            }
                            i++;
                        }
                        int i2 = 0;
                        while (true) {
                            if (i2 >= strArrM6604g.length) {
                                z = true;
                                break;
                            }
                            C1106c c1106cM6341a3 = m6341a(strArrM6604g[i2], this.f3666au);
                            if (c1106cM6341a3 != null && c1106cM6341a3.m7043F() != null && c1106cM6341a3.m7043F().compareTo(Spam.ACTIVITY_REPORT) != 0) {
                                z = false;
                                break;
                            }
                            i2++;
                        }
                    } else {
                        z = false;
                        z2 = true;
                    }
                    int i3 = 0;
                    while (true) {
                        if (i3 >= strArrM6604g.length) {
                            z3 = true;
                            break;
                        }
                        C1106c c1106cM6341a4 = m6341a(strArrM6604g[i3], this.f3666au);
                        if (c1106cM6341a4 != null && !TextUtils.isEmpty(c1106cM6341a4.m7044G())) {
                            z3 = false;
                            break;
                        }
                        i3++;
                    }
                    int i4 = 0;
                    while (true) {
                        if (i4 < strArrM6604g.length) {
                            C1106c c1106cM6341a5 = m6341a(strArrM6604g[i4], this.f3666au);
                            if (c1106cM6341a5 != null && TextUtils.isEmpty(c1106cM6341a5.m7044G())) {
                                z4 = false;
                                break;
                            }
                            i4++;
                        } else {
                            break;
                        }
                    }
                    if (z4) {
                        this.f3655aj.setVisibility(0);
                    } else {
                        this.f3655aj.setVisibility(8);
                    }
                    this.f3656ak.setVisibility(8);
                    if (z3) {
                        this.f3655aj.setVisibility(8);
                        this.f3656ak.setVisibility(8);
                    }
                    if (z) {
                        this.f3651af.setVisibility(8);
                        this.f3652ag.setVisibility(8);
                    } else {
                        this.f3651af.setVisibility(0);
                    }
                    if (!z2) {
                        this.f3652ag.setVisibility(8);
                    }
                }
            }
            if (!C4883f.m18537a(GlobalApplication.m18732r()) && this.f3656ak != null) {
                this.f3656ak.setVisibility(8);
            }
            if (!C2349a.m10301a("sms_feature") && this.f3655aj != null) {
                this.f3655aj.setVisibility(8);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c5  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m6499d(boolean r11) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyFragment.m6499d(boolean):void");
    }

    /* renamed from: b */
    public static boolean m6463b(String str) {
        return (f3584j == null || f3584j.get(str) == null) ? false : true;
    }

    /* renamed from: ad */
    private boolean m6409ad() {
        boolean zM1495d;
        Exception e;
        try {
            zM1495d = this.f3766i.m1495d(getActivity());
            try {
                C4904y.m18639b("[ChatONV] isReadyToCall : " + zM1495d, f3576a);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                C4904y.m18639b("[ChatONV] isChatONVReadyToCall : " + zM1495d, f3576a);
                return zM1495d;
            }
        } catch (Exception e3) {
            zM1495d = false;
            e = e3;
        }
        C4904y.m18639b("[ChatONV] isChatONVReadyToCall : " + zM1495d, f3576a);
        return zM1495d;
    }

    /* renamed from: ae */
    private boolean m6411ae() {
        boolean z = false;
        try {
            if (C2948h.m12190a().m12192a(getActivity(), EnumC2949i.ChatONV)) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C4904y.m18639b("[ChatONV] isChatONVAvaiable : " + z, f3576a);
        return z;
    }

    /* renamed from: af */
    private boolean m6413af() {
        boolean z = false;
        try {
            C0416a c0416a = this.f3766i;
            if (C0416a.m1477b(getActivity())) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C4904y.m18639b("[ChatONV] isChatONVInstalled : " + z, f3576a);
        return z;
    }

    /* renamed from: ag */
    private void m6415ag() throws UnsupportedEncodingException {
        if (C4809aa.m18104a().m18119a("buddy_get_all_buddy_mode_instance", (Boolean) false).booleanValue()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("migrationBuddyOperation() execute getallbuddy with mode instance", f3576a);
            }
            new C2128i(null).m9505a(false, 200);
            new C2128i(null).m9518d();
            C4809aa.m18104a().m18125b("buddy_get_all_buddy_mode_instance", (Boolean) false);
        }
        if (C4809aa.m18104a().m18119a("buddy_sync_unknown_list", (Boolean) false).booleanValue()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("migrationBuddyOperation() sync blocked hided buddy list", f3576a);
            }
            C2126g.m9476a(this.f3724cD).m9477a();
            new C2133n(this.f3724cD).m9558a();
            C4809aa.m18104a().m18125b("buddy_sync_unknown_list", (Boolean) false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    /* renamed from: c */
    public boolean m6600c(String str) {
        boolean z;
        Cursor cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2293m.f8204a, null, "group_relation_buddy=?", new String[]{str}, null);
        if (cursorQuery == null || cursorQuery.getCount() == 0) {
            z = false;
        } else {
            while (cursorQuery.moveToNext()) {
                if (cursorQuery.getString(cursorQuery.getColumnIndex("group_relation_group")).equals(Spam.ACTIVITY_REPORT)) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return z;
    }

    /* renamed from: e */
    private void m6509e(boolean z) {
        this.f3683bL = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m6539i(String str) {
        f3578bN = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m6517f(boolean z) {
        this.f3684bM = z;
    }

    /* renamed from: ah */
    private boolean m6416ah() {
        try {
            return getArguments().getBoolean(f3577b);
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: l */
    public void m6609l() {
        this.f3623aD = true;
        this.f3602I.setFastScrollEnabled(false);
        this.f3621aB.m7400a(21);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ai */
    public void m6418ai() {
        if (getActivity() != null && !((ActionBarFragmentActivity) getActivity()).m18784t().mo18834d()) {
            ((ActionBarFragmentActivity) getActivity()).m18784t().mo18835e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aj */
    public void m6421aj() {
        if (getActivity() != null && ((ActionBarFragmentActivity) getActivity()).m18784t().mo18834d()) {
            ((ActionBarFragmentActivity) getActivity()).m18784t().mo18837f();
        }
    }

    /* renamed from: a */
    public int m6579a(float f) {
        return (int) ((CommonApplication.m18732r().getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6351a(ViewStub viewStub) {
        if (this.f3607N == null) {
            this.f3607N = viewStub.inflate();
            this.f3608O = (ImageView) this.f3607N.findViewById(R.id.image1);
            this.f3608O.setImageResource(R.drawable.no_contents_buddies);
            this.f3609P = (TextView) this.f3607N.findViewById(R.id.text1);
            this.f3609P.setText(getResources().getString(R.string.no_contacts));
            this.f3610Q = (TextView) this.f3607N.findViewById(R.id.text2);
            this.f3610Q.setVisibility(8);
        }
        if (this.f3660ao == 7) {
            if (C2349a.m10301a("sms_feature") && !C4822an.m18218a()) {
                this.f3601H.setVisibility(8);
            } else {
                this.f3601H.setVisibility(0);
            }
        } else {
            this.f3601H.setVisibility(8);
        }
        if (this.f3660ao == 6 && this.f3657al != null && this.f3657al.containsKey("ACTIVITY_PURPOSE_ARG") && !this.f3657al.getBoolean("ACTIVITY_PURPOSE_ARG")) {
            this.f3600G.setVisibility(8);
        } else {
            this.f3600G.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ak */
    public void m6423ak() {
        if (this.f3607N != null) {
            this.f3607N.setVisibility(8);
        }
        this.f3600G.setVisibility(8);
        this.f3613T.setVisibility(8);
    }

    @Deprecated
    /* renamed from: m */
    public void m6610m() {
        m6574x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m6554n(Cursor cursor) {
        Message messageM10105c = C2244e.m10103a().m10105c();
        messageM10105c.obj = cursor;
        C2244e.m10103a().m10104b().sendMessage(messageM10105c);
    }

    /* renamed from: a */
    private Intent m6336a(String str, Object obj, boolean z) {
        C1106c c1106cM6341a = m6341a(str, this.f3666au);
        Intent intent = new Intent(GlobalApplication.m18732r(), (Class<?>) PhoneNumberSelectorDialog.class);
        intent.putExtra("PN_DIALOG_BUDDY_NAME", c1106cM6341a.m7051b());
        if (obj instanceof Map) {
            intent.putExtra("PN_DIALOG_BUDDY_PHONE_NUMBERS_EXTERNAL", (HashMap) obj);
        } else if (obj instanceof List) {
            intent.putExtra("PN_DIALOG_BUDDY_PHONE_NUMBERS_EXTERNAL", (ArrayList) obj);
        }
        if (z) {
            intent.putExtra("PN_DIALOG_BUDDY_TYPE", 4);
        } else {
            intent.putExtra("PN_DIALOG_BUDDY_TYPE", 3);
        }
        if (c1106cM6341a.m7043F() != null && c1106cM6341a.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
            intent.putExtra("PN_DIALOG_BUDDY_PHONE_NUMBERS", c1106cM6341a.m7054c());
        } else {
            intent.putExtra("PN_DIALOG_BUDDY_PHONE_NUMBERS", c1106cM6341a.m7044G());
            intent.putExtra("PN_DIALOG_BUDDY_HAS_EXTERNAL_PHONENUMBER_USE", true);
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: al */
    public Intent m6424al() {
        String strM6611n = m6611n();
        if (strM6611n != null) {
            C1106c c1106cM6341a = m6341a(m6604g()[0], this.f3666au);
            if (c1106cM6341a.m7043F() != null && c1106cM6341a.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                Intent intent = new Intent(GlobalApplication.m18732r(), (Class<?>) PhoneNumberSelectorDialog.class);
                intent.putExtra("PN_DIALOG_BUDDY_TYPE", 3);
                intent.putExtra("PN_DIALOG_BUDDY_NAME", c1106cM6341a.m7051b());
                intent.putExtra("PN_DIALOG_BUDDY_PHONE_NUMBERS", c1106cM6341a.m7054c());
                return intent;
            }
            Intent intent2 = new Intent(GlobalApplication.m18732r(), (Class<?>) PhoneNumberSelectorDialog.class);
            intent2.putExtra("PN_DIALOG_BUDDY_TYPE", 3);
            intent2.putExtra("PN_DIALOG_BUDDY_NAME", m6341a(m6604g()[0], this.f3666au).m7051b());
            intent2.putExtra("PN_DIALOG_BUDDY_PHONE_NUMBERS", strM6611n);
            return intent2;
        }
        Intent intent3 = new Intent("com.sec.chaton.smsplugin.SEND");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < m6604g().length; i++) {
            C1106c c1106cM6341a2 = m6341a(m6604g()[i], this.f3666au);
            if (c1106cM6341a2.m7043F() != null && c1106cM6341a2.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                arrayList.add(c1106cM6341a2.m7054c());
            } else {
                arrayList.addAll(Arrays.asList(c1106cM6341a2.m7044G().split(" ")));
            }
        }
        intent3.setFlags(67108864);
        intent3.putExtra("receiver_array", (String[]) arrayList.toArray(new String[0]));
        return intent3;
    }

    /* renamed from: a */
    private void m6372a(boolean z, boolean z2, String str, C1106c c1106c) throws Throwable {
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        String strM9884h = C2192f.m9884h(str);
        if (strM9884h == null) {
            Bundle bundle = new Bundle();
            bundle.putString("phone", str);
            bundle.putString("name", c1106c.m7051b());
            C4904y.m18639b("phoneNum: " + str, f3576a);
            C4904y.m18639b("NAME: " + c1106c.m7051b(), f3576a);
            if (c1106c.m7055d() != null) {
                bundle.putString("email", c1106c.m7055d());
            }
            Intent intent = new Intent("android.intent.action.INSERT", uri);
            intent.putExtras(bundle);
            intent.putExtra("return-data", true);
            try {
                startActivity(intent);
                return;
            } catch (ActivityNotFoundException e) {
                C4904y.m18635a(e, getClass().getSimpleName());
                C5179v.m19810a(GlobalApplication.m18732r(), R.string.toast_contact_not_found, 0).show();
                return;
            }
        }
        long jM6055a = (z || z2) ? 0L : C1002i.m6055a(c1106c.m7061j());
        if (jM6055a == 0) {
            jM6055a = Long.parseLong(strM9884h);
        }
        C4904y.m18639b("id: " + jM6055a, f3576a);
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse(uri + "/" + jM6055a));
        try {
            startActivity(intent2);
        } catch (ActivityNotFoundException e2) {
            C4904y.m18635a(e2, getClass().getSimpleName());
            C5179v.m19810a(GlobalApplication.m18732r(), R.string.toast_contact_not_found, 0).show();
        }
    }

    /* renamed from: c */
    public void m6598c(boolean z) {
        List listAsList;
        Intent intent;
        if (!C4822an.m18223b()) {
            if (C2349a.m10301a("sms_feature") && C3847e.m14686ar()) {
                Intent intentM15026c = C3892o.m15026c();
                if (intentM15026c != null) {
                    startActivity(intentM15026c);
                    C3892o.m15031e();
                    return;
                }
                return;
            }
            if (!C4822an.m18226c()) {
                C4884g.m18541a(getActivity(), new DialogInterfaceOnClickListenerC1196df(this, z)).show();
                return;
            }
            return;
        }
        int iM6605h = m6605h();
        int iM14708n = C3847e.m14708n();
        if (C4904y.f17872b) {
            C4904y.m18639b("SMS Recipients MAX Count : " + iM14708n, f3576a);
        }
        if (iM6605h > 0) {
            if (iM6605h <= iM14708n) {
                if (iM6605h == 1) {
                    if (z) {
                        String strM6611n = m6611n();
                        if (strM6611n != null) {
                            C1106c c1106cM6341a = m6341a(m6604g()[0], this.f3666au);
                            if (c1106cM6341a.m7043F() != null && c1106cM6341a.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                                intent = new Intent(GlobalApplication.m18732r(), (Class<?>) PhoneNumberSelectorDialog.class);
                                intent.putExtra("PN_DIALOG_BUDDY_TYPE", 3);
                                intent.putExtra("PN_DIALOG_BUDDY_NAME", c1106cM6341a.m7051b());
                                intent.putExtra("PN_DIALOG_BUDDY_PHONE_NUMBERS", c1106cM6341a.m7054c());
                                intent.putExtra("PN_DIALOG_BUDDY_TYPE", 4);
                            } else {
                                intent = new Intent(GlobalApplication.m18732r(), (Class<?>) PhoneNumberSelectorDialog.class);
                                intent.putExtra("PN_DIALOG_BUDDY_TYPE", 3);
                                intent.putExtra("PN_DIALOG_BUDDY_NAME", m6341a(m6604g()[0], this.f3666au).m7051b());
                                intent.putExtra("PN_DIALOG_BUDDY_PHONE_NUMBERS", strM6611n);
                                intent.putExtra("PN_DIALOG_BUDDY_TYPE", 4);
                            }
                            startActivityForResult(intent, 102);
                        } else if (this.f3695bZ) {
                            C4884g.m18545b(getActivity(), new DialogInterfaceOnClickListenerC1197dg(this)).show();
                        } else {
                            m6500d(m6604g());
                        }
                    } else {
                        startActivity(m6424al());
                    }
                } else {
                    ArrayList arrayList = new ArrayList();
                    HashMap map = new HashMap();
                    String strM7046a = null;
                    int i = 0;
                    for (int i2 = 0; i2 < m6604g().length; i2++) {
                        new ArrayList();
                        C1106c c1106cM6341a2 = m6341a(m6604g()[i2], this.f3666au);
                        if (c1106cM6341a2.m7043F() != null && c1106cM6341a2.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                            listAsList = Arrays.asList(c1106cM6341a2.m7054c().split(", "));
                        } else {
                            listAsList = Arrays.asList(c1106cM6341a2.m7044G().split(" "));
                        }
                        if (listAsList.size() >= 2) {
                            i++;
                            strM7046a = c1106cM6341a2.m7046a();
                        } else {
                            arrayList.addAll(listAsList);
                            map.put(c1106cM6341a2.m7044G(), c1106cM6341a2.m7051b());
                        }
                    }
                    if (i >= 2) {
                        Intent intent2 = new Intent(GlobalApplication.m18732r(), (Class<?>) MultipleExpandableDialog.class);
                        intent2.putExtra("activity_arg_buddyno_list", m6604g());
                        intent2.setFlags(67108864);
                        if (z) {
                            intent2.putExtra("activity_arg_from_sms", true);
                            startActivityForResult(intent2, 102);
                        } else {
                            startActivity(intent2);
                        }
                    } else if (i == 1) {
                        if (z) {
                            startActivityForResult(m6336a(strM7046a, (Object) map, true), 102);
                        } else {
                            startActivity(m6336a(strM7046a, (Object) arrayList, false));
                        }
                    } else if (z) {
                        if (this.f3695bZ) {
                            C4884g.m18545b(getActivity(), new DialogInterfaceOnClickListenerC1198dh(this)).show();
                        } else {
                            m6500d(m6604g());
                        }
                    } else {
                        Intent intent3 = new Intent("com.sec.chaton.smsplugin.SEND");
                        ArrayList arrayList2 = new ArrayList();
                        for (int i3 = 0; i3 < m6604g().length; i3++) {
                            C1106c c1106cM6341a3 = m6341a(m6604g()[i3], this.f3666au);
                            if (c1106cM6341a3.m7043F() != null && c1106cM6341a3.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                                arrayList2.add(c1106cM6341a3.m7054c());
                            } else {
                                arrayList2.addAll(Arrays.asList(c1106cM6341a3.m7044G().split(" ")));
                            }
                        }
                        intent3.setFlags(67108864);
                        intent3.putExtra("receiver_array", (String[]) arrayList2.toArray(new String[0]));
                        startActivity(intent3);
                    }
                }
                if (!this.f3707bl && !z) {
                    getActivity().finish();
                    return;
                }
                return;
            }
            C5179v.m19811a(getActivity(), String.format(getResources().getString(R.string.buddy_list_select_maximum_contacts), Integer.valueOf(iM14708n)), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6498d(C1106c c1106c) {
        Uri uri = null;
        List listAsList = Arrays.asList(c1106c.m7044G().split(" "));
        if (listAsList.size() == 1) {
            if (0 == 0) {
                uri = Uri.parse("tel:" + C3789h.m14307c((String) listAsList.get(0)));
            }
            C4904y.m18639b("Call Number: " + uri.toString(), f3576a);
            Intent intent = new Intent("android.intent.action.CALL", uri);
            C4892m.m18577c(true);
            try {
                startActivity(intent);
                return;
            } catch (ActivityNotFoundException e) {
                C4904y.m18635a(e, getClass().getSimpleName());
                return;
            }
        }
        if (listAsList.size() > 1) {
            Intent intent2 = new Intent(GlobalApplication.m18732r(), (Class<?>) PhoneNumberSelectorDialog.class);
            intent2.putExtra("PN_DIALOG_BUDDY_TYPE", 1);
            if (c1106c.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                intent2.putExtra("PN_DIALOG_BUDDY_PHONE_NUMBERS", c1106c.m7054c());
            } else {
                intent2.putExtra("PN_DIALOG_BUDDY_PHONE_NUMBERS", c1106c.m7044G());
                intent2.putExtra("PN_DIALOG_BUDDY_HAS_EXTERNAL_PHONENUMBER_USE", true);
            }
            startActivity(intent2);
            C4892m.m18577c(true);
        }
    }

    /* renamed from: e */
    private List<String> m6505e(C1106c c1106c) {
        ArrayList arrayList = new ArrayList();
        String strM7057f = c1106c.m7057f();
        if (!TextUtils.isEmpty(strM7057f)) {
            StringTokenizer stringTokenizer = new StringTokenizer(strM7057f, "|");
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.length() >= 19 && strNextToken.startsWith("10")) {
                    C4904y.m18639b("chaton id : " + strNextToken, f3576a);
                } else if (strNextToken.startsWith(Spam.ACTIVITY_CANCEL)) {
                    C4904y.m18639b("pin number : " + strNextToken, f3576a);
                } else {
                    C4904y.m18639b("msisdn: " + strNextToken, f3576a);
                    arrayList.add(strNextToken);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: am */
    public void m6427am() {
        if ((((this.f3660ao == 1 || this.f3660ao == 7) ? this.f3751co : 0) + this.f3750cn) - this.f3752cp <= 0) {
            if (this.f3714bs && this.f3715bt && !this.f3716bu) {
                if (this.f3607N != null) {
                    this.f3607N.setVisibility(8);
                }
                if (this.f3660ao == 1 || this.f3660ao == 7) {
                    if (C2349a.m10301a("sms_feature") && !C4822an.m18218a()) {
                        this.f3601H.setVisibility(8);
                    } else {
                        this.f3601H.setVisibility(0);
                    }
                    this.f3611R.setVisibility(0);
                    this.f3612S.setBackgroundResource(R.drawable.upgrade_info_character);
                    this.f3613T.setVisibility(0);
                    this.f3614U.setEnabled(true);
                    return;
                }
                this.f3601H.setVisibility(8);
                return;
            }
            if (this.f3714bs && this.f3715bt && this.f3716bu) {
                this.f3611R.setVisibility(8);
                this.f3613T.setVisibility(0);
                this.f3614U.setEnabled(true);
                m6351a(this.f3606M);
                return;
            }
            this.f3611R.setVisibility(8);
            this.f3613T.setVisibility(8);
            m6351a(this.f3606M);
            return;
        }
        this.f3600G.setVisibility(8);
        this.f3613T.setVisibility(8);
    }

    /* renamed from: n */
    public String m6611n() {
        String strM9841g = C2190d.m9841g(GlobalApplication.m10279a().getContentResolver(), m6341a(m6604g()[0], this.f3666au).m7046a());
        if (!TextUtils.isEmpty(strM9841g)) {
            StringTokenizer stringTokenizer = new StringTokenizer(strM9841g, " ");
            boolean z = stringTokenizer.countTokens() > 1;
            String str = "" + stringTokenizer.nextToken();
            while (stringTokenizer.hasMoreTokens()) {
                str = str + ", " + stringTokenizer.nextToken();
            }
            if (z) {
                return str;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m6350a(MenuItem menuItem, boolean z) {
        if (menuItem != null) {
            menuItem.setVisible(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6369a(ClearableEditText clearableEditText, boolean z) {
        if (clearableEditText != null) {
            if (!GlobalApplication.m10286e() || !GlobalApplication.m10290i()) {
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
                if (z) {
                    if (GlobalApplication.m10286e()) {
                        inputMethodManager.toggleSoftInputFromWindow(clearableEditText.getApplicationWindowToken(), 2, 1);
                        return;
                    } else {
                        inputMethodManager.showSoftInput(clearableEditText.findViewById(R.id.clearable_text1), 2);
                        return;
                    }
                }
                inputMethodManager.hideSoftInputFromWindow(clearableEditText.getWindowToken(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    /* renamed from: j */
    public void m6544j(String str) {
        int i = 0;
        ArrayList<C1106c> arrayList = null;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f3665at.size()) {
                i2 = -1;
                break;
            } else if (this.f3665at.get(i2).m7030d() != 1) {
                i2++;
            } else {
                arrayList = this.f3666au.get(i2);
                break;
            }
        }
        if (arrayList != null) {
            while (true) {
                if (i >= arrayList.size()) {
                    i = -1;
                    break;
                } else if (arrayList.get(i).m7046a().equals(str)) {
                    break;
                } else {
                    i++;
                }
            }
            arrayList.remove(i);
            this.f3666au.set(i2, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    /* renamed from: k */
    public void m6548k(String str) {
        C1104a c1104a;
        ArrayList<C1106c> arrayList;
        int i = 0;
        while (true) {
            if (i >= this.f3665at.size()) {
                i = -1;
                c1104a = null;
                arrayList = null;
                break;
            } else if (this.f3665at.get(i).m7030d() != 1) {
                i++;
            } else {
                c1104a = this.f3665at.get(i);
                arrayList = this.f3666au.get(i);
                break;
            }
        }
        C1106c c1106cM6341a = m6341a(str, this.f3666au);
        if (arrayList != null) {
            c1104a.m7027a(c1104a.m7029c() + 1);
            this.f3665at.set(i, c1104a);
            arrayList.add(c1106cM6341a);
            this.f3666au.set(i, arrayList);
            return;
        }
        ArrayList<C1106c> arrayList2 = new ArrayList<>();
        arrayList2.add(c1106cM6341a);
        this.f3665at.add(new C1104a(1, getResources().getString(R.string.buddy_list_group_favorites), arrayList2.size(), 1, false, false, 0));
        this.f3666au.add(arrayList2);
    }

    /* renamed from: an */
    private void m6429an() {
        EnumC4879cq enumC4879cq;
        int i = 0;
        while (true) {
            if (i < EnumC4879cq.values().length) {
                if (!EnumC4879cq.values()[i].m18522a().contains("buddy_tooltip") || !C4878cp.m18516a().m18518b(EnumC4879cq.values()[i])) {
                    i++;
                } else {
                    enumC4879cq = EnumC4879cq.values()[i];
                    break;
                }
            } else {
                enumC4879cq = null;
                break;
            }
        }
        if (enumC4879cq == EnumC4879cq.BUDDY_MENU_CHAT && C4822an.m18218a()) {
            new C5013c().m19050a(getActivity().getWindow().getDecorView().findViewById(R.id.menu_chat)).m19049a(R.string.tooltip_menu_chat).m19048a().m19042a(getActivity());
            C4878cp.m18516a().m18517a(EnumC4879cq.BUDDY_MENU_CHAT);
        } else if (enumC4879cq == EnumC4879cq.BUDDY_ADDBUDDY && C4822an.m18218a()) {
            new C5013c().m19050a(this.f3679bH).m19049a(R.string.tooltip_addbuddy).m19048a().m19042a(getActivity());
            C4878cp.m18516a().m18517a(EnumC4879cq.BUDDY_ADDBUDDY);
        } else if (enumC4879cq == EnumC4879cq.BUDDY_BUDDYLIST_ITEM && C4822an.m18218a()) {
            new C5013c().m19049a(R.string.tooltip_buddylist_item).m19048a().m19042a(getActivity());
            C4878cp.m18516a().m18517a(EnumC4879cq.BUDDY_BUDDYLIST_ITEM);
        }
    }

    /* renamed from: ao */
    private void m6431ao() {
        if (this.f3739cc.getVisibility() == 0 && C4878cp.m18516a().m18518b(EnumC4879cq.BUDDY_COMMUNICATION_TOOLS) && C4822an.m18218a()) {
            new C5013c().m19050a(this.f3739cc).m19049a(R.string.tooltip_communication_tools).m19048a().m19042a(getActivity());
            C4878cp.m18516a().m18517a(EnumC4879cq.BUDDY_COMMUNICATION_TOOLS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6368a(C1107d c1107d) {
        f3586l = true;
        if (C4904y.f17873c) {
            C4904y.m18641c("goToMobileWebLive : " + c1107d.m7082a(), f3576a);
        }
        Intent intentM2923a = IntentControllerActivity.m2923a(CommonApplication.m18732r(), true);
        intentM2923a.setFlags(67108864);
        intentM2923a.putExtra("callChatList", true);
        intentM2923a.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
        intentM2923a.putExtra("receivers", new String[]{c1107d.m7082a()});
        intentM2923a.putExtra("specialbuddy", true);
        intentM2923a.putExtra("roomType", EnumC2301u.LIVE.m10212a());
        intentM2923a.putExtra("liveUserType", c1107d.m7093j().m7095a());
        intentM2923a.putExtra("liveServiceType", EnumC4549n.LIVECONTENTS.m17247a());
        if (getActivity() != null) {
            startActivity(intentM2923a);
        }
    }

    /* renamed from: ap */
    private void m6433ap() {
        if (m6557p() == 1) {
            if (f3584j == null) {
                f3584j = C2190d.m9837e(GlobalApplication.m18732r().getContentResolver());
            }
            if (f3580by == null) {
                this.f3621aB.m7415i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aq */
    public boolean m6435aq() {
        for (String str : m6604g()) {
            C1106c c1106cM6341a = m6341a(str, this.f3666au);
            if (c1106cM6341a != null) {
                if (c1106cM6341a.m7043F() != null && c1106cM6341a.m7043F().compareTo(Spam.ACTIVITY_REPORT) != 0) {
                    return false;
                }
                if (c1106cM6341a.m7040C() != null && c1106cM6341a.m7040C().compareTo("unknown_buddy") == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: ar */
    private void m6437ar() {
        if (TextUtils.isEmpty(C4809aa.m18104a().m18121a("sms_feature_changes_gld", ""))) {
            C4904y.m18639b("checkSMSFeatureChangesByGLD() SMSFEATURE do nothing ", f3576a);
            return;
        }
        if (C4809aa.m18104a().m18121a("sms_feature_changes_gld", "").equals(Spam.ACTIVITY_REPORT)) {
            C2190d.m9829c();
            C4904y.m18639b("checkSMSFeatureChangesByGLD() SMSFEATURE deleteAllContactBuddy ", f3576a);
            C4809aa.m18104a().m18128b("sms_feature_changes_gld", "");
        } else if (C4809aa.m18104a().m18121a("sms_feature_changes_gld", "").equals(Spam.ACTIVITY_CHECK)) {
            C2192f.m9877a();
            C4904y.m18639b("checkSMSFeatureChangesByGLD() SMSFEATURE deleteAllContact ", f3576a);
            C4809aa.m18104a().m18128b("sms_feature_changes_gld", "");
        }
    }

    /* renamed from: as */
    private ToolTipLayout m6438as() {
        if (Build.VERSION.SDK_INT <= 11 || getActivity() == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) getActivity().getWindow().getDecorView();
        ToolTipLayout toolTipLayout = (ToolTipLayout) viewGroup.findViewById(R.id.toolTipLayout);
        if (toolTipLayout != null) {
            return toolTipLayout;
        }
        getActivity().getLayoutInflater().inflate(R.layout.layout_tooltip_container, viewGroup, true);
        return (ToolTipLayout) viewGroup.findViewById(R.id.toolTipLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6489c(String str, String str2) {
        if (Build.VERSION.SDK_INT > 11) {
            ToolTipLayout toolTipLayoutM6438as = m6438as();
            if (toolTipLayoutM6438as == null) {
                C4904y.m18639b("[EventBanner] ToolTipLayout isn't initilize", f3576a);
                return;
            }
            if (this.f3734cN == null) {
                this.f3734cN = (FrameLayout) getActivity().getLayoutInflater().inflate(R.layout.layout_event_banner, (ViewGroup) toolTipLayoutM6438as, false);
                this.f3734cN.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC1199di(this));
                this.f3735cO = (ImageView) this.f3734cN.findViewById(R.id.event_banner_character);
                this.f3736cP = (AdaptableTextView) this.f3734cN.findViewById(R.id.event_banner_textview);
                ViewOnClickListenerC1249dj viewOnClickListenerC1249dj = new ViewOnClickListenerC1249dj(this, str, str2);
                this.f3735cO.setOnClickListener(viewOnClickListenerC1249dj);
                this.f3736cP.setOnClickListener(viewOnClickListenerC1249dj);
                toolTipLayoutM6438as.addView(this.f3734cN, -2, -2);
                toolTipLayoutM6438as.getWindowVisibleDisplayFrame(new Rect());
                this.f3734cN.setX(r0.right);
                this.f3734cN.setY(r0.bottom);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m6526g(boolean z) {
        if (getActivity() != null && this.f3707bl) {
            if (this.f3734cN != null) {
                C4904y.m18639b("[EventBanner] showEventBanner " + this.f3734cN.getVisibility(), f3576a);
            }
            if (this.f3734cN != null && this.f3734cN.getVisibility() != 0 && m6605h() <= 0) {
                this.f3734cN.setVisibility(0);
                m6352a(this.f3734cN, this.f3713br, this.f3732cL, this.f3733cM, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m6534h(boolean z) {
        if (getActivity() != null && this.f3734cN != null && this.f3734cN.getVisibility() != 8) {
            this.f3734cN.setVisibility(8);
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
                translateAnimation.setDuration(1000L);
                translateAnimation.setAnimationListener(new AnimationAnimationListenerC1250dk(this));
                this.f3734cN.startAnimation(translateAnimation);
            }
        }
    }

    /* renamed from: a */
    private void m6352a(FrameLayout frameLayout, View view, int i, int i2, boolean z) {
        C4904y.m18639b("[EventBanner] applyPositionWithAnchorView " + i2 + ", " + i, f3576a);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        Rect rect = new Rect();
        view.getLocationOnScreen(iArr);
        view.getWindowVisibleDisplayFrame(rect);
        ((View) frameLayout.getParent()).getLocationOnScreen(iArr2);
        int i3 = iArr[0] - iArr2[0];
        int i4 = iArr[1] - iArr2[1];
        int width = view.getWidth();
        int height = view.getHeight();
        int i5 = i3 + (width / 2);
        float f = rect.right - i2;
        float f2 = i4 - i;
        Math.max(0, i4 + height);
        float f3 = rect.bottom - i;
        frameLayout.setX(f);
        frameLayout.setY(f3);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(1000L);
            translateAnimation.setAnimationListener(new AnimationAnimationListenerC1251dl(this));
            frameLayout.startAnimation(translateAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: at */
    public void m6440at() {
        if (this.f3648ac != null) {
            this.f3741ce = new HashMap<>();
            for (int i = 0; i < this.f3648ac.length; i++) {
                this.f3741ce.put(this.f3648ac[i], true);
            }
        }
    }

    /* renamed from: au */
    private String m6442au() {
        if (getActivity() == null) {
            return "";
        }
        FragmentActivity activity = getActivity();
        getActivity();
        return activity.getSharedPreferences("PASSWORD_LOCK", 0).getString("LOCK_STATE", C4892m.m18588h());
    }
}
