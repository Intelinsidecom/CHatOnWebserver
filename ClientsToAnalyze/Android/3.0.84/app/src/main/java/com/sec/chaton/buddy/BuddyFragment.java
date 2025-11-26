package com.sec.chaton.buddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.OperationApplicationException;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.motion.MotionRecognitionManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.sso.p006a.C0045a;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;
import com.sec.chaton.C2310s;
import com.sec.chaton.EnumC3073u;
import com.sec.chaton.InterfaceC0813bw;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.account.C0425k;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.InterfaceC0459d;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.dialog.ChatONVInstallDialog;
import com.sec.chaton.buddy.dialog.ChatONVRedirectDialog;
import com.sec.chaton.buddy.dialog.GroupDialog;
import com.sec.chaton.buddy.dialog.MeDialog;
import com.sec.chaton.buddy.dialog.SpecialBuddyDialog;
import com.sec.chaton.buddy.p019a.C0511a;
import com.sec.chaton.buddy.p019a.C0512b;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1328f;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p025d.C1335m;
import com.sec.chaton.p025d.C1345w;
import com.sec.chaton.p027e.C1388af;
import com.sec.chaton.p027e.C1390ah;
import com.sec.chaton.p027e.C1404av;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.p027e.C1445m;
import com.sec.chaton.p027e.C1446n;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p027e.p028a.C1362f;
import com.sec.chaton.p027e.p028a.C1363g;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p027e.p029b.C1419j;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.plugin.C1948a;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.settings.ActivityContactSync;
import com.sec.chaton.settings.ActivityManageBuddy;
import com.sec.chaton.settings.ActivitySettings;
import com.sec.chaton.userprofile.MyPageFragment;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3161ac;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3177as;
import com.sec.chaton.util.C3178at;
import com.sec.chaton.util.C3180av;
import com.sec.chaton.util.C3191bf;
import com.sec.chaton.util.C3201bp;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.InterfaceC3204bs;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.chaton.widget.ImageTextViewGroup;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.common.util.log.collector.C3358h;
import com.sec.widget.C3641ai;
import com.sec.widget.ChoicePanel;
import com.sec.widget.EditTextWithClearButton;
import com.sec.widget.FastScrollableExpandableListView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import twitter4j.internal.http.HttpResponseCode;

/* loaded from: classes.dex */
public class BuddyFragment extends Fragment implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener, ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener, InterfaceC0459d, InterfaceC0531ap, InterfaceC0532aq, InterfaceC0533ar, InterfaceC0813bw {

    /* renamed from: bm */
    private static HashMap<String, String> f1727bm;

    /* renamed from: k */
    public static HashMap<String, String> f1732k;

    /* renamed from: A */
    private LinearLayout f1737A;

    /* renamed from: B */
    private FastScrollableExpandableListView f1738B;

    /* renamed from: C */
    private C3205bt f1739C;

    /* renamed from: D */
    private TextView f1740D;

    /* renamed from: E */
    private EditTextWithClearButton f1741E;

    /* renamed from: F */
    private FrameLayout f1742F;

    /* renamed from: H */
    private LinearLayout f1744H;

    /* renamed from: I */
    private LinearLayout f1745I;

    /* renamed from: J */
    private Button f1746J;

    /* renamed from: K */
    private View f1747K;

    /* renamed from: L */
    private LinearLayout f1748L;

    /* renamed from: M */
    private CheckedTextView f1749M;

    /* renamed from: P */
    private String f1752P;

    /* renamed from: Q */
    private String f1753Q;

    /* renamed from: R */
    private int f1754R;

    /* renamed from: S */
    private String[] f1755S;

    /* renamed from: T */
    private String f1756T;

    /* renamed from: U */
    private LinearLayout f1757U;

    /* renamed from: V */
    private ImageButton f1758V;

    /* renamed from: W */
    private ImageButton f1759W;

    /* renamed from: X */
    private ImageButton f1760X;

    /* renamed from: Y */
    private ImageButton f1761Y;

    /* renamed from: Z */
    private Bundle f1762Z;

    /* renamed from: aA */
    private String f1763aA;

    /* renamed from: aB */
    private String f1764aB;

    /* renamed from: aD */
    private int f1766aD;

    /* renamed from: aE */
    private TextView f1767aE;

    /* renamed from: aF */
    private String f1768aF;

    /* renamed from: aJ */
    private Toast f1772aJ;

    /* renamed from: aK */
    private C1377u f1773aK;

    /* renamed from: aL */
    private AlertDialogC0599dc f1774aL;

    /* renamed from: aM */
    private C3201bp f1775aM;

    /* renamed from: aN */
    private View f1776aN;

    /* renamed from: aO */
    private TextView f1777aO;

    /* renamed from: aP */
    private ImageView f1778aP;

    /* renamed from: aQ */
    private View f1779aQ;

    /* renamed from: aR */
    private View f1780aR;

    /* renamed from: aS */
    private ImageView f1781aS;

    /* renamed from: aT */
    private TextView f1782aT;

    /* renamed from: aU */
    private TextView f1783aU;

    /* renamed from: aV */
    private String f1784aV;

    /* renamed from: aW */
    private boolean f1785aW;

    /* renamed from: aX */
    private C0513c f1786aX;

    /* renamed from: aZ */
    private ArrayList<C0513c> f1788aZ;

    /* renamed from: an */
    private C0513c f1802an;

    /* renamed from: ao */
    private C0522ag f1803ao;

    /* renamed from: aq */
    private ChoicePanel f1805aq;

    /* renamed from: ay */
    private int f1813ay;

    /* renamed from: az */
    private String f1814az;

    /* renamed from: bA */
    private C0593cx f1815bA;

    /* renamed from: bB */
    private boolean f1816bB;

    /* renamed from: bC */
    private boolean f1817bC;

    /* renamed from: bD */
    private View f1818bD;

    /* renamed from: bE */
    private View f1819bE;

    /* renamed from: bF */
    private View f1820bF;

    /* renamed from: bG */
    private View f1821bG;

    /* renamed from: bH */
    private View f1822bH;

    /* renamed from: bI */
    private View f1823bI;

    /* renamed from: bJ */
    private View f1824bJ;

    /* renamed from: bK */
    private View f1825bK;

    /* renamed from: bN */
    private RelativeLayout f1827bN;

    /* renamed from: bP */
    private String f1829bP;

    /* renamed from: bQ */
    private InterfaceC0598db f1830bQ;

    /* renamed from: bR */
    private InterfaceC0597da f1831bR;

    /* renamed from: bT */
    private CheckBox f1833bT;

    /* renamed from: bY */
    private int f1838bY;

    /* renamed from: bZ */
    private int f1839bZ;

    /* renamed from: ba */
    private InterfaceC0594cy f1840ba;

    /* renamed from: bb */
    private HashMap<String, String> f1841bb;

    /* renamed from: bc */
    private boolean f1842bc;

    /* renamed from: bd */
    private View f1843bd;

    /* renamed from: be */
    private ImageTextViewGroup f1844be;

    /* renamed from: bf */
    private View f1845bf;

    /* renamed from: bg */
    private ImageTextViewGroup f1846bg;

    /* renamed from: bh */
    private ImageTextViewGroup f1847bh;

    /* renamed from: bl */
    private AbstractC3271a f1851bl;

    /* renamed from: bp */
    private C0513c f1854bp;

    /* renamed from: bq */
    private MenuItem f1855bq;

    /* renamed from: br */
    private MenuItem f1856br;

    /* renamed from: bs */
    private View f1857bs;

    /* renamed from: bt */
    private ClearableEditText f1858bt;

    /* renamed from: bu */
    private View f1859bu;

    /* renamed from: bv */
    private ImageButton f1860bv;

    /* renamed from: bw */
    private C0592cw f1861bw;

    /* renamed from: by */
    private int f1863by;

    /* renamed from: bz */
    private int f1864bz;

    /* renamed from: ca */
    private int f1865ca;

    /* renamed from: cb */
    private int f1866cb;

    /* renamed from: f */
    protected C0512b f1881f;

    /* renamed from: g */
    public BuddyFragment f1882g;

    /* renamed from: h */
    boolean f1883h;

    /* renamed from: j */
    public C0045a f1884j;

    /* renamed from: y */
    private TextView f1894y;

    /* renamed from: z */
    private LinearLayout f1895z;

    /* renamed from: a */
    public static final String f1724a = BuddyFragment.class.getSimpleName();

    /* renamed from: b */
    public static String f1725b = "purposeGroupProfile";

    /* renamed from: c */
    public static int f1728c = 0;

    /* renamed from: d */
    public static int f1729d = 0;

    /* renamed from: e */
    public static boolean f1730e = false;

    /* renamed from: i */
    public static boolean f1731i = false;

    /* renamed from: l */
    public static boolean f1733l = false;

    /* renamed from: m */
    public static boolean f1734m = false;

    /* renamed from: n */
    public static String f1735n = "PROFILE_CHAT_ACTION";

    /* renamed from: o */
    public static String f1736o = "PROFILE_LIST_REFRESH_ACTION";

    /* renamed from: bM */
    private static boolean f1726bM = false;

    /* renamed from: v */
    private boolean f1891v = false;

    /* renamed from: w */
    private int f1892w = 0;

    /* renamed from: x */
    private String f1893x = null;

    /* renamed from: G */
    private C1345w f1743G = null;

    /* renamed from: N */
    private boolean f1750N = false;

    /* renamed from: O */
    private boolean f1751O = false;

    /* renamed from: aa */
    private int f1789aa = 11;

    /* renamed from: ab */
    private int f1790ab = 0;

    /* renamed from: ac */
    private int f1791ac = 1;

    /* renamed from: ad */
    private int f1792ad = 0;

    /* renamed from: ae */
    private String[] f1793ae = null;

    /* renamed from: af */
    private String[] f1794af = null;

    /* renamed from: ag */
    private String[] f1795ag = null;

    /* renamed from: ah */
    private ArrayList<C0511a> f1796ah = new ArrayList<>();

    /* renamed from: ai */
    private ArrayList<ArrayList<C0513c>> f1797ai = new ArrayList<>();

    /* renamed from: aj */
    private final ArrayList<C0511a> f1798aj = new ArrayList<>();

    /* renamed from: ak */
    private final ArrayList<ArrayList<C0513c>> f1799ak = new ArrayList<>();

    /* renamed from: al */
    private final ArrayList<C0511a> f1800al = new ArrayList<>();

    /* renamed from: am */
    private final ArrayList<ArrayList<C0513c>> f1801am = new ArrayList<>();

    /* renamed from: ap */
    private C0595cz f1804ap = null;

    /* renamed from: ar */
    private boolean f1806ar = false;

    /* renamed from: as */
    private ProgressDialog f1807as = null;

    /* renamed from: at */
    private InterfaceC3274d f1808at = null;

    /* renamed from: au */
    private boolean f1809au = true;

    /* renamed from: av */
    private boolean f1810av = false;

    /* renamed from: aw */
    private boolean f1811aw = false;

    /* renamed from: ax */
    private boolean f1812ax = false;

    /* renamed from: aC */
    private EnumC3073u f1765aC = EnumC3073u.INSIDE;

    /* renamed from: aG */
    private ArrayList<String> f1769aG = new ArrayList<>();

    /* renamed from: aH */
    private ArrayList<String> f1770aH = null;

    /* renamed from: aI */
    private HashMap<String, String> f1771aI = new HashMap<>();

    /* renamed from: aY */
    private boolean f1787aY = false;

    /* renamed from: bi */
    private boolean f1848bi = false;

    /* renamed from: bj */
    private boolean f1849bj = false;

    /* renamed from: bk */
    private String f1850bk = "";

    /* renamed from: bn */
    private int f1852bn = -1;

    /* renamed from: bo */
    private int f1853bo = -1;

    /* renamed from: bx */
    private boolean f1862bx = false;

    /* renamed from: bL */
    private final int f1826bL = -1;

    /* renamed from: bO */
    private final int f1828bO = 30;

    /* renamed from: p */
    InterfaceC1378v f1885p = new C0588cs(this);

    /* renamed from: bS */
    private View.OnClickListener f1832bS = new ViewOnClickListenerC0550bh(this);

    /* renamed from: bU */
    private TextWatcher f1834bU = new C0552bj(this);

    /* renamed from: bV */
    private ArrayList<String> f1835bV = new ArrayList<>();

    /* renamed from: bW */
    private Handler f1836bW = new HandlerC0562bt(this);

    /* renamed from: bX */
    private Handler f1837bX = new HandlerC0565bw(this);

    /* renamed from: q */
    Handler f1886q = new HandlerC0568bz(this);

    /* renamed from: r */
    InterfaceC1413d f1887r = new C0571cb(this);

    /* renamed from: s */
    InterfaceC1413d f1888s = new C0572cc(this);

    /* renamed from: t */
    InterfaceC1413d f1889t = new C0573cd(this);

    /* renamed from: u */
    ContentObserver f1890u = new C0574ce(this, new Handler());

    /* renamed from: cc */
    private C0045a f1867cc = new C0045a();

    /* renamed from: cd */
    private Handler f1868cd = new HandlerC0575cf(this);

    /* renamed from: ce */
    private int f1869ce = 0;

    /* renamed from: cf */
    private int f1870cf = -1;

    /* renamed from: cg */
    private int f1871cg = -1;

    /* renamed from: ch */
    private int f1872ch = 0;

    /* renamed from: ci */
    private boolean f1873ci = false;

    /* renamed from: cj */
    private int f1874cj = 0;

    /* renamed from: ck */
    private InterfaceC3204bs f1875ck = new C0577ch(this);

    /* renamed from: cl */
    private Handler f1876cl = new HandlerC0578ci(this);

    /* renamed from: cm */
    private BroadcastReceiver f1877cm = new C0579cj(this);

    /* renamed from: cn */
    private BroadcastReceiver f1878cn = new C0583cn(this);

    /* renamed from: co */
    private SlookAirButton.ItemSelectListener f1879co = new C0584co(this);

    /* renamed from: cp */
    private View.OnClickListener f1880cp = new ViewOnClickListenerC0586cq(this);

    /* renamed from: d */
    public void m3439d() {
        int i;
        int i2;
        int size = this.f1798aj.size();
        int size2 = this.f1799ak.get(this.f1864bz).size();
        if (this.f1863by + 1 <= size2 - 1) {
            i2 = this.f1863by + 1;
            i = this.f1864bz;
        } else if (this.f1863by + 1 <= size2 - 1) {
            i = 0;
            i2 = 0;
        } else if (this.f1864bz + 1 <= size - 1) {
            i = this.f1864bz + 1;
            i2 = 0;
        } else {
            if (this.f1864bz + 1 > size - 1) {
                ((TabActivity) getActivity()).m1312a(R.id.fragment_buddy, new Intent(), Fragment.class);
                return;
            }
            i = 0;
            i2 = 0;
        }
        C0513c c0513c = this.f1799ak.get(i).get(i2);
        if (c0513c.m3975b().startsWith("0999")) {
            Intent intent = new Intent();
            intent.setAction(SpecialBuddyFragment.class.getName());
            intent.putExtra("specialuserid", c0513c.m3975b());
            intent.putExtra("speicalusername", c0513c.m3976c());
            intent.putExtra("specialBuddyAdded", true);
            ((TabActivity) getActivity()).m1312a(R.id.fragment_buddy, intent, SpecialBuddyFragment.class);
            return;
        }
        if (c0513c.m3997x()) {
            Intent intent2 = new Intent();
            intent2.setAction(BuddyGroupProfileFragment.class.getName());
            C0512b c0512b = new C0512b(Integer.parseInt(c0513c.m3975b()), c0513c.m3976c(), c0513c.m3999z() != null ? c0513c.m3999z().size() : 0, 2);
            intent2.putExtra("ACTIVITY_PURPOSE", 18);
            intent2.putExtra("groupInfo", c0512b);
            intent2.putExtra("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST", m3443h());
            intent2.putExtra("LAUNCH_AS_CHILD", true);
            ((TabActivity) getActivity()).m1312a(R.id.fragment_buddy, intent2, BuddyGroupProfileFragment.class);
            return;
        }
        Intent intent3 = new Intent();
        intent3.setAction(BuddyProfileFragment.class.getName());
        intent3.putExtra("PROFILE_BUDDY_NO", c0513c.m3975b());
        intent3.putExtra("PROFILE_BUDDY_NAME", c0513c.m3976c());
        intent3.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
        ((TabActivity) getActivity()).m1312a(R.id.fragment_buddy, intent3, BuddyProfileFragment.class);
    }

    @Override // com.sec.chaton.InterfaceC0813bw
    /* renamed from: b */
    public void mo1189b() {
        BaseActivity.m3081a(this, true);
        if (GlobalApplication.m6456e()) {
            Intent intent = new Intent();
            intent.putExtra(EmptyFragment.f2243c, EmptyFragment.f2241a);
            ((TabActivity) getActivity()).m1312a(R.id.fragment_buddy, intent, EmptyFragment.class);
        }
        if (this.f1791ac == 1) {
            if (m3444i() > 0) {
                f1733l = true;
            }
            ((ActionBarFragmentActivity) getActivity()).supportInvalidateOptionsMenu();
        }
        this.f1788aZ = new ArrayList<>();
        this.f1841bb = new HashMap<>();
        this.f1883h = false;
        this.f1809au = true;
        C3250y.m11458g("onTabSelected() : " + this.f1809au, f1724a);
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C3358h.m11842a().m11846a("00030001");
        }
        if (f1734m) {
            m3430a(true);
            f1734m = false;
        }
        if (this.f1810av) {
            this.f1804ap.m4054b();
        }
        this.f1810av = false;
        if (this.f1775aM == null) {
            m3318ae();
        } else {
            this.f1775aM.m11163a();
        }
        this.f1787aY = true;
        if (this.f1738B != null) {
            this.f1738B.setFastScrollEnabled(true);
        }
        if (!C3159aa.m10962a().m10977a("Is Group Uploaded", (Boolean) false).booleanValue()) {
            m3234K();
        }
        if (m3444i() == 0) {
            m3447l();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        if (getActivity() != null) {
            LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.f1878cn, intentFilter);
        }
        C3205bt.m11182a(getActivity()).m11231c(this.f1781aS, C3159aa.m10962a().m10979a("chaton_id", ""));
        if (GlobalApplication.m6456e() && this.f1803ao != null && this.f1791ac == 1) {
            this.f1803ao.m4032a(-1, -1);
            if (this.f1843bd.getVisibility() == 0 || this.f1845bf.getVisibility() == 0) {
                this.f1820bF.setVisibility(0);
            } else {
                this.f1820bF.setVisibility(8);
            }
        }
    }

    @Override // com.sec.chaton.InterfaceC0813bw
    /* renamed from: c */
    public void mo1190c() {
        BaseActivity.m3081a(this, false);
        if (!TextUtils.isEmpty(this.f1858bt.m11463a().toString())) {
            f1734m = true;
        }
        if (GlobalApplication.m6456e()) {
            if (((TabActivity) getActivity()).m1326g()) {
                ((TabActivity) getActivity()).m1317a(false);
            } else if (this.f1858bt != null) {
                this.f1858bt.setText("");
            }
        } else if (this.f1858bt != null) {
            this.f1858bt.setText("");
        }
        m3240N();
        this.f1809au = false;
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.f1878cn);
        C3250y.m11458g("onTabUnSelected() : " + this.f1809au, f1724a);
        this.f1787aY = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        C3250y.m11458g("onCreate()", f1724a);
        super.onCreate(bundle);
        this.f1882g = this;
        this.f1804ap = new C0595cz(this);
        this.f1772aJ = C3641ai.m13211a(getActivity(), (CharSequence) null, 0);
        getActivity().getContentResolver().registerContentObserver(C1441i.f5369a, true, this.f1890u);
        getActivity().getContentResolver().registerContentObserver(C1446n.f5378a, true, this.f1890u);
        getActivity().getContentResolver().registerContentObserver(C1445m.f5377a, true, this.f1890u);
        getActivity().getContentResolver().registerContentObserver(C1388af.f5186a, true, this.f1890u);
        getActivity().getContentResolver().registerContentObserver(C1390ah.f5188a, true, this.f1890u);
        m3318ae();
        this.f1884j = new C0045a();
        this.f1804ap.m4065h();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("buddy_tab_badge_update");
        LocalBroadcastManager.getInstance(GlobalApplication.m11493l()).registerReceiver(this.f1877cm, intentFilter);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C3250y.m11458g("onCreateView()", f1724a);
        View viewInflate = layoutInflater.inflate(R.layout.buddy_layout2, viewGroup, false);
        m3325ai();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        C3250y.m11458g("onActivityCreated()", f1724a);
        if (getArguments() == null) {
            this.f1791ac = 1;
        } else {
            this.f1791ac = getArguments().getInt("ACTIVITY_PURPOSE", 1);
            this.f1792ad = getArguments().getInt("ACTIVITY_PURPOSE_ARG2");
            BaseActivity.m3081a(this, true);
        }
        super.onActivityCreated(bundle);
        this.f1773aK = new C1377u(getActivity().getContentResolver(), this.f1885p);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            try {
                f1730e = bundle.getBoolean("savedInstanceStateCheck");
            } catch (NullPointerException e) {
                f1730e = false;
            }
            if (f1730e) {
                f1728c = bundle.getInt("INDEX");
                f1729d = bundle.getInt("TOP");
            }
            if (arguments.containsKey("content_type")) {
                this.f1813ay = arguments.getInt("content_type");
                C3250y.m11454d("Buddy content_type:" + this.f1813ay);
                this.f1812ax = true;
            }
            if (arguments.containsKey("download_uri")) {
                this.f1814az = arguments.getString("download_uri");
                C3250y.m11454d("Buddy download_uri:" + this.f1814az);
            }
            if (arguments.containsKey("sub_content")) {
                this.f1763aA = arguments.getString("sub_content");
                C3250y.m11454d("Buddy sub_content:" + this.f1763aA);
            }
            if (arguments.containsKey("forward_sender_name")) {
                this.f1764aB = arguments.getString("forward_sender_name");
                C3250y.m11454d("Buddy mForwardSenderName:" + this.f1764aB);
            }
            if (arguments.containsKey("is_forward_mode")) {
                this.f1842bc = arguments.getBoolean("is_forward_mode");
                C3250y.m11454d("Buddy mIsForward:" + this.f1842bc);
            }
            if (arguments.containsKey(C2310s.f8621e)) {
                this.f1765aC = (EnumC3073u) arguments.get(C2310s.f8621e);
                C3250y.m11454d("Buddy mForwardFrom:" + this.f1765aC);
            }
            if (arguments.containsKey("null")) {
                this.f1784aV = arguments.getString("null");
                C3250y.m11454d("Buddy mForwardFrom:" + this.f1765aC);
            }
            this.f1785aW = arguments.getBoolean("mShowChatONBuddies");
            C3250y.m11454d("Buddy mShowChatONBuddies:" + this.f1785aW);
        }
        m3229I();
        this.f1739C = C3205bt.m11182a(getActivity().getApplicationContext());
        m3405s();
        this.f1749M.setOnClickListener(new ViewOnClickListenerC0544bb(this));
        this.f1776aN.setOnClickListener(new ViewOnClickListenerC0555bm(this));
        if (this.f1791ac == 9 && bundle == null) {
            this.f1769aG = getArguments().getStringArrayList("ACTIVITY_PURPOSE_ARG");
        }
        if (this.f1791ac == 6 || this.f1791ac == 18) {
            m3417y();
        } else {
            this.f1804ap.m4054b();
        }
        if (getActivity() instanceof InterfaceC0598db) {
            this.f1830bQ = (InterfaceC0598db) getActivity();
        } else {
            this.f1830bQ = new C0567by(this);
        }
        this.f1858bt.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0581cl(this));
    }

    /* renamed from: a */
    public void m3426a(InterfaceC0597da interfaceC0597da) {
        this.f1831bR = interfaceC0597da;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        int i = 0;
        C3250y.m11458g("onStart() : " + this.f1809au, f1724a);
        super.onStart();
        if (f1734m && this.f1791ac == 1) {
            m3430a(true);
            f1734m = false;
            m3216B();
        }
        if (this.f1791ac == 1 && this.f1796ah.size() > 0) {
            boolean zBooleanValue = C3159aa.m10962a().m10977a("Profile Birth Chk", (Boolean) true).booleanValue();
            C3250y.m11458g("onStart() isShowBirthdayCategory : " + zBooleanValue, f1724a);
            if (zBooleanValue) {
                while (true) {
                    int i2 = i;
                    if (i2 < this.f1796ah.size()) {
                        if (this.f1796ah.get(i2).m3956d() != 0) {
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    } else {
                        if (m3221E()) {
                            m3284a(this.f1796ah, this.f1797ai);
                            return;
                        }
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = i;
                    if (i3 < this.f1796ah.size()) {
                        if (this.f1796ah.get(i3).m3956d() != 0) {
                            i = i3 + 1;
                        } else {
                            this.f1796ah.remove(i3);
                            this.f1797ai.remove(i3);
                            m3284a(this.f1796ah, this.f1797ai);
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
    public void onResume() throws Throwable {
        Cursor cursorQuery;
        int count;
        super.onResume();
        boolean zBooleanValue = C3159aa.m10962a().m10977a("recomned_receive", (Boolean) true).booleanValue();
        this.f1782aT.setText(C3159aa.m10962a().m10979a("Push Name", ""));
        this.f1783aU.setText(C3159aa.m10962a().m10979a("status_message", ""));
        this.f1809au = true;
        C3250y.m11458g("onResume() : " + this.f1809au, f1724a);
        C3250y.m11458g("isChanged : " + this.f1810av, f1724a);
        this.f1804ap.m4057c();
        this.f1804ap.m4054b();
        this.f1804ap.m4059d();
        this.f1858bt.m11464a(this.f1834bU);
        this.f1858bt.setOnKeyListener(new ViewOnKeyListenerC0587cr(this));
        C3250y.m11458g("###mIsTabSelected: " + this.f1787aY, f1724a);
        if (this.f1787aY) {
            if (this.f1810av) {
                this.f1804ap.m4054b();
            } else {
                this.f1810av = false;
            }
            if (this.f1791ac == 1) {
                this.f1804ap.m4061e();
            }
            if (this.f1767aE != null) {
                if (zBooleanValue) {
                    try {
                        cursorQuery = getActivity().getApplicationContext().getContentResolver().query(C1388af.f5186a, null, "type='200' AND timestamp>" + C3159aa.m10962a().m10976a("recommend_timestamp", 0L), null, null);
                        if (cursorQuery != null) {
                            try {
                                count = cursorQuery.getCount();
                            } catch (Throwable th) {
                                th = th;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                throw th;
                            }
                        } else {
                            count = 0;
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        m3434b(count);
                    } catch (Throwable th2) {
                        th = th2;
                        cursorQuery = null;
                    }
                } else {
                    m3434b(0);
                }
            }
        }
        this.f1848bi = !TextUtils.isEmpty(C3159aa.m10962a().m10979a("msisdn", ""));
        this.f1849bj = C3171am.m11080r();
        if (m3444i() == 0) {
            m3447l();
        }
        if (this.f1848bi && this.f1849bj) {
            this.f1744H.setVisibility(8);
            this.f1745I.setVisibility(0);
            this.f1746J.setEnabled(true);
        }
        if (this.f1858bt != null && this.f1858bt.hasFocus()) {
            m3238M();
        }
        m3309aa();
        if (this.f1771aI != null) {
            this.f1771aI.clear();
        }
        if (GlobalApplication.m6456e() && this.f1791ac == 1 && this.f1820bF != null) {
            if (this.f1843bd.getVisibility() == 0 || this.f1845bf.getVisibility() == 0) {
                this.f1820bF.setVisibility(0);
            } else {
                this.f1820bF.setVisibility(8);
            }
        }
        C3205bt.m11182a(getActivity()).m11231c(this.f1781aS, C3159aa.m10962a().m10979a("chaton_id", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public int m3400q() {
        return C1948a.m7903a(getActivity()) ? 1 : -1;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        this.f1809au = false;
        f1733l = false;
        this.f1858bt.m11467b(this.f1834bU);
        m3228H();
        C3250y.m11458g("onPause() : " + this.f1809au, f1724a);
        super.onPause();
        m3240N();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        C3250y.m11458g("onStop()", f1724a);
        try {
            this.f1858bt.m11467b(this.f1834bU);
        } catch (Exception e) {
        }
        m3241O();
        m3244P();
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.f1739C = null;
        this.f1804ap.m4050a();
        getActivity().getApplicationContext().getContentResolver().unregisterContentObserver(this.f1890u);
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.f1878cn);
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.f1877cm);
        if (this.f1774aL != null && this.f1774aL.isShowing()) {
            this.f1774aL.dismiss();
        }
        if (this.f1738B != null) {
            this.f1738B.setAdapter((ExpandableListAdapter) null);
            this.f1738B.setOnGroupClickListener(null);
            this.f1738B.setOnGroupCollapseListener(null);
            this.f1738B.setOnGroupExpandListener(null);
            this.f1738B.setOnChildClickListener(null);
            this.f1738B.setOnScrollListener(null);
            this.f1738B = null;
        }
        if (this.f1803ao != null) {
            this.f1803ao.m4038b();
            this.f1803ao.m4033a((BuddyFragment) null);
            this.f1803ao.m4034a((InterfaceC0531ap) null);
            this.f1803ao.m4035a((InterfaceC0532aq) null);
            this.f1803ao.m4036a((InterfaceC0533ar) null);
            this.f1803ao = null;
        }
        if (this.f1781aS != null) {
            this.f1781aS.setImageBitmap(null);
            this.f1781aS = null;
        }
        if (this.f1745I != null) {
            this.f1745I.removeAllViews();
            this.f1745I = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getResources().getConfiguration().orientation == 1) {
            if (this.f1741E != null) {
                this.f1741E.f13382c.clearFocus();
            }
            m3332al();
        } else if (getResources().getConfiguration().orientation == 2 && this.f1858bt != null && this.f1858bt.m11463a().toString().length() > 0 && this.f1791ac == 1) {
            m3334am();
        }
    }

    /* renamed from: r */
    private boolean m3402r() {
        return (this.f1806ar || this.f1874cj == 2 || this.f1874cj == 3 || this.f1874cj == 4) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007c  */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m3405s() {
        /*
            Method dump skipped, instructions count: 1969
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyFragment.m3405s():void");
    }

    /* renamed from: a */
    public C0513c m3421a(String[] strArr) {
        if (this.f1803ao != null) {
            ArrayList<ArrayList<C0513c>> arrayListM4043d = this.f1803ao.m4043d();
            for (int i = 0; i < arrayListM4043d.size(); i++) {
                for (int i2 = 0; i2 < arrayListM4043d.get(i).size(); i2++) {
                    if (arrayListM4043d.get(i).get(i2).m3997x() && arrayListM4043d.get(i).get(i2).m3999z().size() == strArr.length && m3433a(arrayListM4043d.get(i).get(i2).m3999z().keySet(), strArr)) {
                        C3250y.m11453c("get selected buddy group : group name - " + arrayListM4043d.get(i).get(i2).m3976c(), getClass().getSimpleName());
                        return arrayListM4043d.get(i).get(i2);
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean m3433a(Set<String> set, String[] strArr) {
        boolean z = true;
        for (String str : strArr) {
            if (!set.contains(str)) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m3407t() {
        int iM48a;
        if (m3400q() == 1) {
            if (m3321ag()) {
                if (m3319af()) {
                    int i = 0;
                    for (int i2 = 0; i2 < m3443h().length; i2++) {
                        String strM6043c = C1360d.m6043c(GlobalApplication.m11493l().getContentResolver(), m3443h()[i2]);
                        String strM6046d = C1360d.m6046d(GlobalApplication.m11493l().getContentResolver(), m3443h()[i2]);
                        if (!TextUtils.isEmpty(strM6043c) && !TextUtils.isEmpty(strM6046d) && strM6043c.contains("voip=1")) {
                            i++;
                        }
                    }
                    if (i != 0 && i <= this.f1884j.m53b((Context) getActivity(), false) - 1) {
                        if (m3443h().length <= 1) {
                            iM48a = this.f1884j.m47a(getActivity(), false, m3443h()[0], C3159aa.m10962a().m10979a("Push Name", ""), null);
                        } else {
                            this.f1854bp = m3421a(m3443h());
                            if (this.f1854bp != null && m3444i() == this.f1854bp.m3999z().size() && this.f1738B.m13108a((String[]) this.f1854bp.m3999z().keySet().toArray(new String[0]))) {
                                iM48a = this.f1884j.m48a(getActivity(), false, m3443h(), C3159aa.m10962a().m10979a("Push Name", ""), null, this.f1854bp.m3976c());
                            } else {
                                iM48a = this.f1884j.m48a(getActivity(), false, m3443h(), C3159aa.m10962a().m10979a("Push Name", ""), null, null);
                            }
                        }
                        if (iM48a != 0) {
                            C3641ai.m13210a(getActivity(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                            return;
                        }
                        return;
                    }
                    return;
                }
                startActivity(new Intent(getActivity(), (Class<?>) ChatONVInstallDialog.class));
                return;
            }
            if (!m3324ah()) {
                startActivity(new Intent(getActivity(), (Class<?>) ChatONVRedirectDialog.class));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m3408u() {
        int iM48a;
        if (m3400q() == 1) {
            if (m3321ag()) {
                if (m3319af()) {
                    int i = 0;
                    for (int i2 = 0; i2 < m3443h().length; i2++) {
                        String strM6043c = C1360d.m6043c(GlobalApplication.m11493l().getContentResolver(), m3443h()[i2]);
                        String strM6046d = C1360d.m6046d(GlobalApplication.m11493l().getContentResolver(), m3443h()[i2]);
                        if (!TextUtils.isEmpty(strM6043c) && !TextUtils.isEmpty(strM6046d) && strM6043c.contains("voip=1")) {
                            i++;
                        }
                    }
                    if (i != 0 && i <= this.f1884j.m53b((Context) getActivity(), true) - 1) {
                        if (m3443h().length <= 1) {
                            iM48a = this.f1884j.m47a(getActivity(), true, m3443h()[0], C3159aa.m10962a().m10979a("Push Name", ""), null);
                        } else {
                            this.f1854bp = m3421a(m3443h());
                            if (this.f1854bp != null && m3444i() == this.f1854bp.m3999z().size() && this.f1738B.m13108a((String[]) this.f1854bp.m3999z().keySet().toArray(new String[0]))) {
                                iM48a = this.f1884j.m48a(getActivity(), true, m3443h(), C3159aa.m10962a().m10979a("Push Name", ""), null, this.f1854bp.m3976c());
                            } else {
                                iM48a = this.f1884j.m48a(getActivity(), true, m3443h(), C3159aa.m10962a().m10979a("Push Name", ""), null, null);
                            }
                        }
                        if (iM48a != 0) {
                            C3641ai.m13210a(getActivity(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                            return;
                        }
                        return;
                    }
                    return;
                }
                startActivity(new Intent(getActivity(), (Class<?>) ChatONVInstallDialog.class));
                return;
            }
            if (!m3324ah()) {
                startActivity(new Intent(getActivity(), (Class<?>) ChatONVRedirectDialog.class));
            }
        }
    }

    /* renamed from: v */
    private void m3410v() {
        m3422a(-1);
    }

    /* renamed from: a */
    void m3422a(int i) {
        C3250y.m11458g("setTitle() : " + i, "BuddyFragment");
        String string = null;
        if (this.f1791ac != 1) {
            if (this.f1791ac == 2) {
                string = getString(R.string.menu_button_start_chat);
            } else if (this.f1791ac == 3) {
                string = getString(R.string.buddy_list_optionmenu_broadcast);
            } else if (this.f1791ac == 15) {
                string = getString(R.string.menu_video_call);
            } else if (this.f1791ac == 14) {
                string = getString(R.string.menu_voice_call);
            } else if (this.f1791ac == 12) {
                string = getString(R.string.tab_chat);
            } else if (this.f1791ac == 5) {
                string = getString(R.string.chat_view_menu_invite);
            } else if (this.f1791ac != 8 && this.f1791ac != 20) {
                if (this.f1791ac == 9) {
                    switch (this.f1792ad) {
                        case 1:
                            string = getString(R.string.poston_title);
                            break;
                        case 2:
                            string = getString(R.string.settings_hided);
                            break;
                        case 3:
                            string = getString(R.string.settings_blocked);
                            break;
                    }
                    i = -1;
                } else if (this.f1791ac == 10) {
                    string = getString(R.string.buddy_select_no_list_select_buddies);
                } else if (this.f1791ac != 7) {
                    if (this.f1791ac == 6 && this.f1762Z != null && this.f1762Z.containsKey("ACTIVITY_PURPOSE_ARG") && !this.f1762Z.getBoolean("ACTIVITY_PURPOSE_ARG")) {
                        string = getString(R.string.buddy_select_no_list_select_buddies);
                    } else if (this.f1791ac != 18 && this.f1791ac != 19) {
                        string = getString(R.string.buddy_select_no_list_select_buddies);
                        if (this.f1892w == 0) {
                            i = -1;
                        }
                    }
                }
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
    public void m3427a(String str, String str2) {
        m3432a(str, !this.f1738B.m13110b(str), str2, false, true);
    }

    /* renamed from: a */
    public void m3428a(String str, boolean z, String str2) {
        m3432a(str, z, str2, false, true);
    }

    /* renamed from: a */
    public boolean m3432a(String str, boolean z, String str2, boolean z2, boolean z3) {
        View viewFindViewById;
        View viewFindViewById2;
        if (z) {
            if (str2 == null) {
                C0513c c0513cM3269a = m3269a(str, this.f1797ai);
                if (c0513cM3269a == null) {
                    return true;
                }
                str2 = c0513cM3269a.m3976c();
            }
            if (m3314ac()) {
                this.f1738B.setChildChecked(str, z);
                if (this.f1892w == 2) {
                    this.f1805aq.m13055a(str, str2);
                }
            } else if (this.f1738B.m13107a(str) != z) {
                m3316ad();
                return false;
            }
        } else {
            this.f1738B.setChildChecked(str, z);
            if (this.f1892w == 2) {
                this.f1805aq.m13054a(str);
            }
        }
        if (z2) {
            return true;
        }
        if (this.f1830bQ != null) {
            this.f1830bQ.mo3452a(this.f1738B.m13106a());
        }
        if (m3444i() == 0) {
            getView().findViewById(R.id.layoutChatButtons).setVisibility(8);
            if (GlobalApplication.m6456e() && (viewFindViewById2 = getView().findViewById(R.id.child_buddy_choice_gradient)) != null && this.f1791ac == 1) {
                viewFindViewById2.setVisibility(8);
            }
        } else if (this.f1791ac == 1 || this.f1791ac == 1000) {
            if (z3) {
                C0513c c0513cM3269a2 = m3269a(str, this.f1797ai);
                if (m3400q() == 1 && c0513cM3269a2 != null) {
                    m3354b(c0513cM3269a2.m3997x());
                }
            }
            if (GlobalApplication.m6456e() && (viewFindViewById = getView().findViewById(R.id.child_buddy_choice_gradient)) != null && this.f1791ac == 1) {
                viewFindViewById.setLayoutParams(new RelativeLayout.LayoutParams(-2, this.f1805aq.getHeight()));
            }
        } else {
            getView().findViewById(R.id.layoutChatButtons).setVisibility(8);
        }
        if (this.f1791ac != 1000 || this.f1768aF == null || this.f1768aF.equals("voip")) {
        }
        return true;
    }

    /* renamed from: a */
    public static void m3273a(ClipData clipData, C0513c c0513c, Context context) {
        int iM6364a;
        Intent intent = new Intent(context, (Class<?>) ChatActivity.class);
        intent.setFlags(67108864);
        if (c0513c.m3997x()) {
            intent.putExtra("chatType", EnumC1450r.GROUPCHAT.m6342a());
            intent.putExtra("groupId", c0513c.m3975b());
            intent.putExtra("receivers", (String[]) c0513c.m3999z().keySet().toArray(new String[0]));
        } else {
            intent.putExtra("chatType", EnumC1450r.ONETOONE.m6342a());
            intent.putExtra("receivers", new String[]{c0513c.m3975b()});
        }
        if (clipData != null) {
            clipData.getItemCount();
            if (ClipDescription.compareMimeTypes(clipData.getDescription().getMimeType(0), "image/*")) {
                iM6364a = EnumC1455w.IMAGE.m6364a();
            } else {
                iM6364a = ClipDescription.compareMimeTypes(clipData.getDescription().getMimeType(0), "video/*") ? EnumC1455w.VIDEO.m6364a() : 0;
            }
            ClipData.Item itemAt = clipData.getItemAt(0);
            if (itemAt.getUri() != null) {
                Uri uri = itemAt.getUri();
                if (iM6364a == EnumC1455w.VIDEO.m6364a()) {
                    intent.putExtra("content_type", EnumC1455w.VIDEO.m6364a());
                    intent.putExtra("download_uri", uri.toString());
                } else if (iM6364a == EnumC1455w.IMAGE.m6364a()) {
                    intent.putExtra("content_type", EnumC1455w.IMAGE.m6364a());
                    intent.putExtra("download_uri", uri.toString());
                } else {
                    intent.putExtra("content_type", EnumC1455w.UNDEFINED.m6364a());
                    intent.putExtra("download_uri", uri.toString());
                }
            } else {
                intent.putExtra("content_type", EnumC1455w.UNDEFINED.m6364a());
            }
            intent.setFlags(67108864);
            intent.putExtra("is_forward_mode", false);
            intent.putExtra(C2310s.f8621e, EnumC3073u.INSIDE);
            intent.putExtra("is_attach_on_the_edittext", true);
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_clipdata", clipData);
            intent.putExtras(bundle);
            intent.putExtra("buddy_dragdata", true);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public void m3412w() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f1835bV.size() || !m3432a(this.f1835bV.get(i2), true, null, true, true)) {
                break;
            } else {
                i = i2 + 1;
            }
        }
        if (this.f1830bQ != null) {
            this.f1830bQ.mo3452a(this.f1738B.m13106a());
        }
    }

    /* renamed from: a */
    public void m3430a(boolean z) {
        for (int i = 0; i < this.f1835bV.size(); i++) {
            m3432a(this.f1835bV.get(i), false, null, z, true);
        }
        if (getView() != null) {
            getView().findViewById(R.id.layoutChatButtons).setVisibility(8);
            m3447l();
            f1733l = false;
            ((ActionBarFragmentActivity) getActivity()).supportInvalidateOptionsMenu();
            if (this.f1830bQ != null) {
                this.f1830bQ.mo3452a(this.f1738B.m13106a());
            }
            if (GlobalApplication.m6456e() && this.f1820bF != null) {
                if (this.f1843bd.getVisibility() == 0 || this.f1845bf.getVisibility() == 0) {
                    this.f1820bF.setVisibility(0);
                } else {
                    this.f1820bF.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: b */
    public void m3435b(String[] strArr) {
        for (String str : strArr) {
            m3432a(str, false, null, false, false);
        }
        if (this.f1830bQ != null) {
            this.f1830bQ.mo3452a(this.f1738B.m13106a());
        }
    }

    /* renamed from: d */
    private boolean m3372d(String str) {
        if (this.f1768aF == null) {
            return true;
        }
        return mo3436b(m3269a(str, this.f1797ai));
    }

    @Override // com.sec.chaton.buddy.InterfaceC0533ar
    /* renamed from: b */
    public boolean mo3436b(C0513c c0513c) {
        return this.f1768aF == null || c0513c == null || c0513c.m3997x() || c0513c.m3974a(this.f1768aF);
    }

    @Override // com.sec.chaton.buddy.InterfaceC0531ap
    /* renamed from: a */
    public void mo3423a(C0513c c0513c) {
        this.f1802an = c0513c;
        m3262Y();
        C1330h c1330h = new C1330h(this.f1886q);
        this.f1850bk = c0513c.m3976c();
        c1330h.m5730b(c0513c.m3975b());
    }

    /* renamed from: a */
    public void m3429a(ArrayList<ArrayList<C0513c>> arrayList) {
        if (this.f1892w == 1 || this.f1892w == 2) {
            Iterator<String> it = this.f1738B.m13109b().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (m3269a(next, this.f1797ai) == null) {
                    m3432a(next, false, null, true, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m3415x() {
        this.f1791ac = 7;
        this.f1895z.setVisibility(8);
        this.f1737A.setVisibility(0);
        this.f1738B.setFastScrollEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public void m3417y() {
        if (this.f1791ac == 7) {
            this.f1791ac = 1;
        }
        C3250y.m11458g("viewBuddyList() : " + this.f1791ac, f1724a);
        if (this.f1800al.size() <= 0 && this.f1801am.size() <= 0 && TextUtils.isEmpty(this.f1858bt.m11463a().toString())) {
            this.f1738B.setVisibility(0);
            this.f1747K.setVisibility(8);
        }
        this.f1895z.setVisibility(0);
        this.f1737A.setVisibility(8);
        if (this.f1803ao == null) {
            if (!GlobalApplication.m6456e()) {
                this.f1803ao = new C0522ag(this.f1738B, getActivity(), this.f1798aj, R.layout.layout_common_group_header, this.f1799ak, R.layout.list_item_common_7, this.f1892w != 0, m3402r(), this, false, this.f1879co);
            } else {
                this.f1803ao = new C0522ag(this.f1738B, getActivity(), this.f1798aj, R.layout.layout_common_group_header, this.f1799ak, R.layout.list_item_common_6, this.f1892w != 0, m3402r(), this, false, this.f1879co);
            }
            this.f1803ao.m4033a(this);
            this.f1803ao.m4031a(this.f1791ac);
            this.f1803ao.m4039b(this.f1768aF);
            if (this.f1791ac == 6 && this.f1762Z.containsKey("ACTIVITY_PURPOSE_ARG") && this.f1762Z.getBoolean("ACTIVITY_PURPOSE_ARG")) {
                View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.chat_info_header, (ViewGroup) this.f1738B, false);
                viewInflate.setFocusable(true);
                ((ViewGroup) viewInflate).setDescendantFocusability(MotionRecognitionManager.EVENT_CALL_POSE);
                this.f1738B.addHeaderView(viewInflate, null, false);
                ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(R.id.alert_layout);
                this.f1833bT = (CheckBox) viewInflate.findViewById(android.R.id.checkbox);
                viewGroup.setFocusable(true);
                viewGroup.setBackgroundResource(R.drawable.listview_selector);
                viewGroup.setPadding((int) getActivity().getResources().getDimension(R.dimen.li4_padding_left), (int) getActivity().getResources().getDimension(R.dimen.li4_padding_top), (int) getActivity().getResources().getDimension(R.dimen.li4_padding_right), (int) getActivity().getResources().getDimension(R.dimen.li4_padding_bottom));
                viewGroup.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0551bi(this));
                this.f1833bT.setDuplicateParentStateEnabled(true);
                this.f1833bT.setEnabled(true);
                this.f1738B.setItemsCanFocus(true);
                this.f1803ao.m4034a((InterfaceC0531ap) this);
            }
            if (!GlobalApplication.m6456e() || f1726bM) {
                if (this.f1791ac == 18) {
                    m3419z();
                }
                f1726bM = false;
            }
            if (this.f1791ac == 1 || this.f1791ac == 1000) {
                this.f1803ao.m4035a((InterfaceC0532aq) this);
            }
            this.f1738B.setAdapter(this.f1803ao);
        }
        m3214A();
    }

    /* renamed from: z */
    private void m3419z() {
        this.f1738B.addHeaderView(LayoutInflater.from(getActivity()).inflate(R.layout.buddy_group_profile, (ViewGroup) this.f1738B, false));
        this.f1738B.setItemsCanFocus(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m3214A() {
        if (!this.f1806ar) {
            C3250y.m11458g("refreshList()", f1724a);
            this.f1858bt.m11467b(this.f1834bU);
            this.f1858bt.m11464a(this.f1834bU);
            if (this.f1803ao != null) {
                this.f1804ap.m4051a(this.f1789aa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public void m3216B() {
        C3250y.m11458g("forceRefreshList()", f1724a);
        this.f1858bt.m11467b(this.f1834bU);
        this.f1858bt.setText("");
        this.f1806ar = false;
        this.f1858bt.m11464a(this.f1834bU);
        if (this.f1803ao != null) {
            this.f1804ap.m4051a(this.f1789aa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public boolean m3218C() {
        ArrayList<C0513c> arrayList = new ArrayList<>();
        arrayList.add(new C0513c(getResources().getString(R.string.setting_interaction_me), C3159aa.m10962a().m10979a("Push Name", ""), C3159aa.m10962a().m10979a("status_message", ""), "", "", "", false, 0, "", false, 0, 0, 0, 0, 0, 0, 0, false, false, 0, "", 0));
        if (arrayList.size() > 0) {
            this.f1796ah.add(0, new C0511a(1, getResources().getString(R.string.setting_interaction_me), arrayList.size(), -2, false, false, 0));
            this.f1797ai.add(0, arrayList);
        }
        return arrayList.size() > 0;
    }

    /* renamed from: a */
    private boolean m3285a(Cursor cursor) {
        C3250y.m11450b("addFavoriteDataSetFromCursor " + cursor, f1724a);
        ArrayList<C0513c> arrayList = new ArrayList<>();
        int columnIndex = cursor.getColumnIndex("group_type");
        int columnIndex2 = cursor.getColumnIndex("buddy_no");
        int columnIndex3 = cursor.getColumnIndex("buddy_name");
        int columnIndex4 = cursor.getColumnIndex("buddy_status_message");
        int columnIndex5 = cursor.getColumnIndex("buddy_samsung_email");
        int columnIndex6 = cursor.getColumnIndex("buddy_orginal_number");
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
        int columnIndex23 = cursor.getColumnIndex("buddy_is_hide");
        int columnIndex24 = cursor.getColumnIndex("buddy_account_info");
        int columnIndex25 = cursor.getColumnIndex("buddy_sainfo");
        cursor.moveToPosition(-1);
        while (cursor.moveToNext() && cursor.getInt(columnIndex) <= 1) {
            if (columnIndex23 == -1 || cursor.getString(columnIndex23) == null || !cursor.getString(columnIndex23).equals("Y")) {
                arrayList.add(new C0513c(cursor.getString(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4), cursor.getString(columnIndex5), cursor.getString(columnIndex6), cursor.getString(columnIndex7), !"Y".equals(cursor.getString(columnIndex8)), cursor.getInt(columnIndex9), cursor.getString(columnIndex10), "Y".equals(cursor.getString(columnIndex11)), cursor.getInt(columnIndex12), cursor.getInt(columnIndex13), cursor.getInt(columnIndex14), cursor.getInt(columnIndex15), cursor.getInt(columnIndex16), cursor.getInt(columnIndex17), cursor.getInt(columnIndex18), "Y".equals(cursor.getString(columnIndex19)), "Y".equals(cursor.getString(columnIndex20)), cursor.getInt(columnIndex21), cursor.getString(columnIndex22), cursor.getInt(columnIndex24), cursor.getString(columnIndex25)));
            }
        }
        if (arrayList.size() > 0) {
            this.f1796ah.add(new C0511a(1, getResources().getString(R.string.buddy_list_group_favorites), arrayList.size(), 1, false, false, 0));
            this.f1797ai.add(arrayList);
        }
        return arrayList.size() > 0;
    }

    /* renamed from: b */
    private boolean m3355b(Cursor cursor) {
        String strValueOf;
        boolean z;
        if (this.f1791ac == 1000 && this.f1768aF != null && this.f1768aF.equals("voip")) {
            return false;
        }
        C3250y.m11450b("addGroupDataSetFromCursor " + cursor, f1724a);
        ArrayList<C0513c> arrayList = new ArrayList<>();
        if (this.f1791ac != 19) {
            strValueOf = null;
        } else {
            strValueOf = String.valueOf(this.f1881f.m3960a());
        }
        int columnIndex = cursor.getColumnIndex("group_name");
        int columnIndex2 = cursor.getColumnIndex("buddy_no");
        int columnIndex3 = cursor.getColumnIndex("buddy_email");
        int columnIndex4 = cursor.getColumnIndex("buddy_samsung_email");
        int columnIndex5 = cursor.getColumnIndex("buddy_is_new");
        int columnIndex6 = cursor.getColumnIndex("buddy_extra_info");
        cursor.moveToPrevious();
        while (cursor.moveToNext()) {
            String string = cursor.getString(columnIndex);
            if (string != null && string.length() != 0) {
                C0513c c0513c = new C0513c(cursor.getString(columnIndex2), cursor.getString(columnIndex), null, null, null, null, true, 0, cursor.getString(columnIndex), "Y".equals(cursor.getString(columnIndex5)), 0, 0, 0, 0, 0, 0, 0, false, false, 0);
                HashMap<String, String> map = new HashMap<>();
                String str = "%%" + cursor.getString(columnIndex2) + "%%";
                c0513c.m3973a(true);
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
                if (this.f1791ac == 15 || this.f1791ac == 14) {
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
                    c0513c.m3972a(map);
                }
                if (strValueOf != null && c0513c.m3975b() != null && c0513c.m3975b().equals(strValueOf)) {
                    this.f1770aH = new ArrayList<>();
                    if (strArrSplit != null && strArrSplit.length > 0) {
                        for (String str2 : strArrSplit) {
                            this.f1770aH.add(str2);
                        }
                    }
                } else if (c0513c.m3999z() != null) {
                    arrayList.add(c0513c);
                } else {
                    try {
                        C1379w.m6203a(new C1379w(), -1, new C1419j(this.f1887r, Integer.parseInt(c0513c.m3975b())));
                    } catch (NumberFormatException e) {
                        C3250y.m11442a(e.getMessage(), getClass().getSimpleName());
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            this.f1796ah.add(new C0511a(1, getResources().getString(R.string.buddy_list_optionmenu_sortby_group), arrayList.size(), 4, false, false, 0));
            this.f1797ai.add(arrayList);
        }
        return arrayList.size() > 0;
    }

    /* renamed from: a */
    private void m3274a(Cursor cursor, boolean z) {
        String str;
        int i;
        C3250y.m11450b("addBuddiesByNameDataSetFromCursor " + cursor, f1724a);
        ArrayList<C0513c> arrayList = new ArrayList<>();
        HashMap map = new HashMap();
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
        this.f1835bV.clear();
        this.f1865ca = 0;
        cursor.moveToPosition(-1);
        int i2 = 2;
        String strM11119d = null;
        ArrayList<C0513c> arrayList2 = arrayList;
        char c = 0;
        while (cursor.moveToNext()) {
            if (this.f1791ac != 1000 || this.f1768aF == null || !this.f1768aF.equals("voip") || (!TextUtils.isEmpty(cursor.getString(columnIndex15)) && !TextUtils.isEmpty(cursor.getString(columnIndex18)) && cursor.getString(columnIndex15).contains("voip=1"))) {
                if (columnIndex19 == -1 || cursor.getString(columnIndex19) == null || cursor.getString(columnIndex19) == null) {
                    if (columnIndex16 != -1) {
                        strM11119d = cursor.getString(columnIndex16);
                    } else {
                        C3250y.m11442a("query without hanzitopinyin", getClass().getSimpleName());
                    }
                    if (TextUtils.isEmpty(strM11119d)) {
                        strM11119d = C3178at.m11103a().m11119d(cursor.getString(columnIndex2));
                    }
                    if (strM11119d != null && strM11119d.trim().length() != 0) {
                        str = strM11119d;
                    } else if (this.f1891v) {
                        str = ".";
                    }
                    if (columnIndex19 > 0) {
                        String string = cursor.getString(columnIndex19);
                        if (this.f1791ac == 10 && string != null && string.length() != 0) {
                            strM11119d = str;
                        }
                    }
                    if (columnIndex20 != -1 && cursor.getString(columnIndex20) != null && cursor.getString(columnIndex20).equals("Y")) {
                        this.f1865ca++;
                        strM11119d = str;
                    } else {
                        char cM11144a = C3191bf.m11144a(Character.toUpperCase(str.charAt(0)));
                        C0513c c0513c = new C0513c(cursor.getString(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4), cursor.getString(columnIndex5), cursor.getString(columnIndex6), !"Y".equals(cursor.getString(columnIndex7)), cursor.getInt(columnIndex8), cursor.getString(columnIndex9), "Y".equals(cursor.getString(columnIndex10)), z ? cursor.getInt(columnIndexOrThrow) : 0, z ? cursor.getInt(columnIndexOrThrow2) : 0, z ? cursor.getInt(columnIndexOrThrow3) : 0, z ? cursor.getInt(columnIndexOrThrow4) : 0, z ? cursor.getInt(columnIndexOrThrow5) : 0, z ? cursor.getInt(columnIndexOrThrow6) : 0, cursor.getInt(columnIndex11), "Y".equals(cursor.getString(columnIndex12)), "Y".equals(cursor.getString(columnIndex13)), cursor.getInt(columnIndex14), cursor.getString(columnIndex15), cursor.getInt(columnIndex17), cursor.getString(columnIndex18));
                        arrayList2.add(c0513c);
                        this.f1835bV.add(c0513c.m3975b());
                        if (map.get(Character.valueOf(cM11144a)) == null) {
                            this.f1797ai.add(arrayList2);
                            C0511a c0511a = new C0511a(i2, String.valueOf(cM11144a), arrayList2.size(), 2, false, false, 0);
                            this.f1796ah.add(c0511a);
                            map.put(Character.valueOf(cM11144a), c0511a);
                            i = i2 + 1;
                        } else {
                            int iIndexOf = this.f1796ah.indexOf((C0511a) map.get(Character.valueOf(cM11144a)));
                            ArrayList<C0513c> arrayList3 = this.f1797ai.get(iIndexOf);
                            arrayList3.addAll(arrayList2);
                            this.f1797ai.set(iIndexOf, arrayList3);
                            C0511a c0511a2 = this.f1796ah.get(iIndexOf);
                            c0511a2.m3953a(arrayList3.size());
                            this.f1796ah.set(iIndexOf, c0511a2);
                            map.put(Character.valueOf(cM11144a), c0511a2);
                            i = i2;
                        }
                        i2 = i;
                        arrayList2 = new ArrayList<>();
                        c = cM11144a;
                        strM11119d = str;
                    }
                }
            }
        }
        if (arrayList2.size() > 0) {
            int i3 = i2 + 1;
            this.f1796ah.add(new C0511a(i2, String.valueOf(c), arrayList2.size(), 2, false, false, 0));
            this.f1797ai.add(arrayList2);
        }
        if (this.f1830bQ != null) {
            this.f1830bQ.mo3453b(this.f1835bV.size());
        }
        if (this.f1791ac == 1000 && this.f1768aF != null && this.f1768aF.equals("voip") && this.f1797ai.size() == 0 && this.f1851bl == null) {
            this.f1851bl = AbstractC3271a.m11494a(getActivity());
            this.f1851bl.mo11500a(getResources().getString(R.string.poll_list_empty_title));
            this.f1851bl.mo11509b(getResources().getString(R.string.poll_list_empty_title)).mo11511b(true).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0553bk(this));
            this.f1851bl.mo11512b();
        }
        map.clear();
    }

    /* renamed from: c */
    private void m3360c(Cursor cursor) {
        int i;
        C3250y.m11450b("addBuddiesByRelationDataSetFromCursor " + cursor, f1724a);
        ArrayList<C0513c> arrayList = new ArrayList<>();
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
        this.f1835bV.clear();
        this.f1865ca = 0;
        cursor.moveToPrevious();
        int i3 = 0;
        while (cursor.moveToNext()) {
            int i4 = cursor.getInt(columnIndex13);
            if (columnIndex22 != -1 && cursor.getString(columnIndex22).equals("Y")) {
                this.f1865ca++;
            } else {
                C0513c c0513c = new C0513c(cursor.getString(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4), cursor.getString(columnIndex5), cursor.getString(columnIndex6), !"Y".equals(cursor.getString(columnIndex7)), cursor.getInt(columnIndex8), cursor.getString(columnIndex9), "Y".equals(cursor.getString(columnIndex10)), cursor.getInt(columnIndex11), cursor.getInt(columnIndex12), cursor.getInt(columnIndex13), cursor.getInt(columnIndex14), cursor.getInt(columnIndex15), cursor.getInt(columnIndex16), cursor.getInt(columnIndex17), "Y".equals(cursor.getString(columnIndex18)), "Y".equals(cursor.getString(columnIndex19)), cursor.getInt(columnIndex20), cursor.getString(columnIndex21), cursor.getInt(columnIndex23), cursor.getString(columnIndex24));
                arrayList.add(c0513c);
                this.f1835bV.add(c0513c.m3975b());
                i3 = cursor.getInt(columnIndex13) > 0 ? i3 + 1 : i3;
                i2 = i4;
            }
        }
        if (arrayList.size() > 0) {
            if (i3 > 30) {
                i3 = 30;
            }
            if (arrayList.size() < i3) {
                this.f1796ah.add(new C0511a(2, getResources().getString(R.string.buddy_list_best_buddies) + "", arrayList.size(), 6, false, false, i2));
                this.f1797ai.add(arrayList);
            } else {
                if (i3 <= 0) {
                    i = 2;
                } else {
                    ArrayList<C0513c> arrayList2 = new ArrayList<>(arrayList.subList(0, i3));
                    this.f1796ah.add(new C0511a(2, getResources().getString(R.string.buddy_list_best_buddies) + "", arrayList2.size(), 6, false, false, i2));
                    this.f1797ai.add(arrayList2);
                    i = 3;
                }
                if (arrayList.size() > i3) {
                    ArrayList<C0513c> arrayList3 = new ArrayList<>(arrayList.subList(i3, arrayList.size()));
                    int i5 = i + 1;
                    this.f1796ah.add(new C0511a(i, getResources().getString(R.string.tab_buddies) + "", arrayList3.size(), 6, false, false, i2));
                    this.f1797ai.add(arrayList3);
                }
            }
        }
        if (this.f1830bQ != null) {
            this.f1830bQ.mo3453b(this.f1835bV.size());
        }
    }

    /* renamed from: d */
    private void m3367d(Cursor cursor) {
        int i;
        C3250y.m11450b("addChatonvDataSetFromCursor " + cursor, f1724a);
        ArrayList<C0513c> arrayList = new ArrayList<>();
        ArrayList<C0513c> arrayList2 = new ArrayList<>();
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
        this.f1835bV.clear();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            String strM11119d = null;
            if (columnIndex27 != -1) {
                strM11119d = cursor.getString(columnIndex27);
            } else {
                C3250y.m11442a("query without hanzitopinyin", getClass().getSimpleName());
            }
            if (TextUtils.isEmpty(strM11119d)) {
                strM11119d = C3178at.m11103a().m11119d(cursor.getString(columnIndex2));
            }
            if (strM11119d != null && strM11119d.trim().length() != 0 && (columnIndex25 == -1 || cursor.getString(columnIndex25) == null || cursor.getString(columnIndex25) == null)) {
                if (columnIndex25 > 0) {
                    String string = cursor.getString(columnIndex25);
                    if (this.f1791ac != 10 || string == null || string.length() == 0) {
                    }
                }
                if (columnIndex26 == -1 || cursor.getString(columnIndex26) == null || !cursor.getString(columnIndex26).equals("Y")) {
                    C0513c c0513c = new C0513c(cursor.getString(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4), cursor.getString(columnIndex5), cursor.getString(columnIndex6), !"Y".equals(cursor.getString(columnIndex7)), cursor.getInt(columnIndex8), cursor.getString(columnIndex9), "Y".equals(cursor.getString(columnIndex10)), cursor.getInt(columnIndex11), cursor.getInt(columnIndex12), cursor.getInt(columnIndex13), cursor.getInt(columnIndex14), cursor.getInt(columnIndex15), cursor.getInt(columnIndex16), cursor.getInt(columnIndex17), "Y".equals(cursor.getString(columnIndex18)), "Y".equals(cursor.getString(columnIndex19)), cursor.getInt(columnIndex20), cursor.getString(columnIndex21), cursor.getInt(columnIndex22), cursor.getString(columnIndex23));
                    if (cursor.getInt(columnIndex24) != 1) {
                        if (c0513c.m3967D() != null && !TextUtils.isEmpty(c0513c.m3981h()) && c0513c.m3967D().contains("voip=1")) {
                            arrayList.add(c0513c);
                        } else {
                            arrayList2.add(c0513c);
                        }
                        this.f1835bV.add(c0513c.m3975b());
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            this.f1796ah.add(new C0511a(2, getResources().getString(R.string.chatonv_buddies) + "", arrayList.size(), 6, false, false, 0));
            this.f1797ai.add(arrayList);
            i = 3;
        } else {
            i = 2;
        }
        if (arrayList2.size() > 0) {
            int i2 = i + 1;
            this.f1796ah.add(new C0511a(i, getResources().getString(R.string.tab_buddies) + "", arrayList2.size(), 6, false, false, 0));
            this.f1797ai.add(arrayList2);
        }
        if (this.f1830bQ != null) {
            this.f1830bQ.mo3453b(this.f1835bV.size());
        }
    }

    /* renamed from: D */
    private boolean m3220D() {
        int i;
        int i2;
        Cursor cursorQuery = getActivity().getContentResolver().query(C1390ah.f5188a, null, null, null, "buddy_name ASC");
        if (cursorQuery == null) {
            return false;
        }
        C3250y.m11450b("addSpecialBuddyDataSet " + cursorQuery, f1724a);
        ArrayList<C0513c> arrayList = new ArrayList<>();
        int columnIndex = cursorQuery.getColumnIndex("buddy_no");
        int columnIndex2 = cursorQuery.getColumnIndex("buddy_name");
        int columnIndex3 = cursorQuery.getColumnIndex("msgstatus");
        int columnIndex4 = cursorQuery.getColumnIndex("isNew");
        int columnIndex5 = cursorQuery.getColumnIndex("is_hide");
        this.f1866cb = 0;
        cursorQuery.moveToPosition(-1);
        while (cursorQuery.moveToNext()) {
            if (columnIndex5 != -1 && cursorQuery.getString(columnIndex5).equals("Y")) {
                this.f1866cb++;
            } else {
                arrayList.add(new C0513c(cursorQuery.getString(columnIndex), cursorQuery.getString(columnIndex2), cursorQuery.getString(columnIndex3), null, cursorQuery.getString(columnIndex), null, true, 0, cursorQuery.getString(columnIndex2), "Y".equals(cursorQuery.getString(columnIndex4)), 0, 0, 0, 0, 0, 0, 1, false, false, 0));
            }
        }
        if (arrayList.size() > 0) {
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            while (i3 < this.f1796ah.size()) {
                C0511a c0511a = this.f1796ah.get(i3);
                if (c0511a.m3956d() == 4) {
                    i = i4;
                    i2 = i3;
                } else if (c0511a.m3956d() == 1) {
                    i = i3;
                    i2 = i5;
                } else {
                    i = i4;
                    i2 = i5;
                }
                i3++;
                i5 = i2;
                i4 = i;
            }
            if (i5 > 0) {
                this.f1796ah.add(i5 + 1, new C0511a(1, getResources().getString(R.string.more_live_partner_button_name), arrayList.size(), 7, false, false, 0));
                this.f1797ai.add(arrayList);
            } else if (i4 > 0) {
                this.f1796ah.add(i4 + 1, new C0511a(1, getResources().getString(R.string.more_live_partner_button_name), arrayList.size(), 7, false, false, 0));
                this.f1797ai.add(arrayList);
            } else {
                this.f1796ah.add(new C0511a(1, getResources().getString(R.string.more_live_partner_button_name), arrayList.size(), 7, false, false, 0));
                this.f1797ai.add(arrayList);
            }
        }
        cursorQuery.close();
        return arrayList.size() > 0;
    }

    /* renamed from: E */
    private boolean m3221E() {
        C3250y.m11450b("addBirthdayDataSet", f1724a);
        String str = new SimpleDateFormat("MM-dd").format(new Date());
        ArrayList<C0513c> arrayList = new ArrayList<>();
        for (int i = 0; i < this.f1796ah.size(); i++) {
            C0511a c0511a = this.f1796ah.get(i);
            if (c0511a.m3956d() == 2 || c0511a.m3956d() == 3 || c0511a.m3956d() == 6) {
                Iterator<C0513c> it = this.f1797ai.get(i).iterator();
                while (it.hasNext()) {
                    C0513c next = it.next();
                    if (!TextUtils.isEmpty(next.m3982i()) && ((next.m3982i().length() == 10 && next.m3982i().substring(5).equals(str)) || (next.m3982i().length() == 5 && next.m3982i().equals(str)))) {
                        arrayList.add(next);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            for (int i2 = 0; i2 < this.f1796ah.size(); i2++) {
                if (this.f1796ah.get(i2).m3956d() > 0) {
                    this.f1796ah.add(i2, new C0511a(0, getResources().getString(R.string.buddy_list_group_birthday), arrayList.size(), 0, true, false, 0));
                    this.f1797ai.add(i2, arrayList);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m3376e(Cursor cursor) {
        this.f1796ah.clear();
        this.f1797ai.clear();
        if (cursor.getCount() == 0 && this.f1791ac == 5) {
            C3641ai.m13211a(getActivity(), getResources().getString(R.string.buddy_list_invite_toast_failed_nomore), 0).show();
            Intent intent = new Intent();
            intent.putExtra("receivers", new String[0]);
            getActivity().setResult(0, intent);
            getActivity().finish();
            return;
        }
        if (this.f1791ac == 1) {
            m3218C();
        }
        m3285a(cursor);
        m3355b(cursor);
        if (this.f1791ac == 1) {
            m3220D();
        }
        m3274a(cursor, true);
        if (C3159aa.m10962a().m10977a("Profile Birth Chk", (Boolean) true).booleanValue() && this.f1791ac == 1) {
            m3221E();
        }
        m3225G();
        if (m3400q() == 1) {
            this.f1804ap.m4065h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m3379f(Cursor cursor) {
        this.f1796ah.clear();
        this.f1797ai.clear();
        m3285a(cursor);
        m3274a(cursor, true);
        if (C3159aa.m10962a().m10977a("Profile Birth Chk", (Boolean) true).booleanValue()) {
            m3221E();
        }
        m3225G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m3383g(Cursor cursor) {
        this.f1796ah.clear();
        this.f1797ai.clear();
        m3274a(cursor, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m3385h(Cursor cursor) {
        this.f1796ah.clear();
        this.f1797ai.clear();
        m3274a(cursor, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m3387i(Cursor cursor) {
        this.f1796ah.clear();
        this.f1797ai.clear();
        if (this.f1791ac == 1) {
            m3218C();
        }
        if (!this.f1812ax) {
            m3285a(cursor);
        }
        m3285a(cursor);
        m3355b(cursor);
        if (this.f1791ac == 1) {
            m3220D();
        }
        m3360c(cursor);
        if (C3159aa.m10962a().m10977a("Profile Birth Chk", (Boolean) true).booleanValue() && this.f1791ac == 1) {
            m3221E();
        }
        m3225G();
        if (m3400q() == 1) {
            this.f1804ap.m4065h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m3390j(Cursor cursor) {
        this.f1796ah.clear();
        this.f1797ai.clear();
        if (this.f1791ac == 1) {
            m3218C();
        }
        if (!this.f1812ax) {
            m3285a(cursor);
        }
        m3355b(cursor);
        if (this.f1791ac == 1) {
            m3220D();
        }
        m3367d(cursor);
        if (C3159aa.m10962a().m10977a("Profile Birth Chk", (Boolean) true).booleanValue() && this.f1791ac == 1) {
            m3221E();
        }
        m3225G();
        if (m3400q() == 1) {
            this.f1804ap.m4065h();
        }
    }

    /* renamed from: k */
    private void m3392k(Cursor cursor) {
        if (this.f1788aZ == null) {
            this.f1788aZ = new ArrayList<>();
        }
        if (this.f1841bb == null) {
            this.f1841bb = new HashMap<>();
        }
        this.f1788aZ.clear();
        this.f1841bb.clear();
        while (cursor.moveToNext()) {
            if (this.f1791ac != 1000 || this.f1768aF == null || !this.f1768aF.equals("voip") || (!TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex("buddy_extra_info"))) && !TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex("buddy_sainfo"))) && cursor.getString(cursor.getColumnIndex("buddy_extra_info")).contains("voip=1"))) {
                if (cursor.getColumnIndex("buddy_is_hide") == -1 || cursor.getString(cursor.getColumnIndex("buddy_is_hide")) == null || !cursor.getString(cursor.getColumnIndex("buddy_is_hide")).equals("Y")) {
                    ArrayList<C3180av> arrayListM11117a = C3178at.m11103a().m11117a(cursor.getString(cursor.getColumnIndex("buddy_name")));
                    String str = "";
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= arrayListM11117a.size()) {
                            break;
                        }
                        str = str + arrayListM11117a.get(i2).f11519c;
                        i = i2 + 1;
                    }
                    this.f1788aZ.add(new C0513c(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), 0, 0, 0, 0, 0, 0, cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), cursor.getString(cursor.getColumnIndex("buddy_is_profile_updated")).equals("Y"), cursor.getString(cursor.getColumnIndex("buddy_is_status_updated")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_show_phone_number")), cursor.getString(cursor.getColumnIndex("buddy_extra_info")), cursor.getInt(cursor.getColumnIndex("group_relation_group")), cursor.getString(cursor.getColumnIndex("buddy_msisdns")), str, arrayListM11117a, cursor.getInt(cursor.getColumnIndex("buddy_account_info")), cursor.getString(cursor.getColumnIndex("buddy_sainfo"))));
                    if (!TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex("buddy_phonenumber_external_use")))) {
                        this.f1841bb.put(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_phonenumber_external_use")));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m3393l(Cursor cursor) {
        boolean z;
        char cM11144a;
        this.f1800al.clear();
        this.f1801am.clear();
        String string = this.f1858bt.m11463a().toString();
        ArrayList<C0513c> arrayList = new ArrayList<>();
        if (cursor.getCount() != 0) {
            if (!cursor.isBeforeFirst()) {
                cursor.moveToPosition(-1);
            }
            int i = 0;
            if (this.f1883h) {
                m3392k(cursor);
                this.f1883h = false;
            }
            if (this.f1788aZ == null || this.f1788aZ.size() == 0) {
                m3392k(cursor);
            }
            Iterator<C0513c> it = this.f1788aZ.iterator();
            char c = 0;
            while (it.hasNext()) {
                C0513c next = it.next();
                String strM3976c = next.m3976c();
                boolean z2 = false;
                String upperCase = string.toUpperCase();
                if (!next.m3964A().toLowerCase().equals(strM3976c.replace(" ", "").toLowerCase())) {
                    C3178at.m11103a();
                    C3178at.m11109a(next.m3965B(), upperCase);
                }
                C3178at.m11103a();
                if (C3178at.m11110b() != -1 || C3177as.m11095a(strM3976c.toUpperCase(), upperCase) || (!TextUtils.isEmpty(this.f1841bb.get(next.m3975b())) && this.f1841bb.get(next.m3975b()).contains(upperCase))) {
                    if (this.f1873ci) {
                        String strM3975b = next.m3975b();
                        Iterator<ArrayList<C0513c>> it2 = this.f1797ai.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z = z2;
                                break;
                            }
                            Iterator<C0513c> it3 = it2.next().iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    z = z2;
                                    break;
                                }
                                C0513c next2 = it3.next();
                                if (!next2.m3997x() && strM3975b.equals(next2.m3975b())) {
                                    z = true;
                                    break;
                                }
                            }
                            if (z) {
                                break;
                            } else {
                                z2 = z;
                            }
                        }
                    } else {
                        z = true;
                    }
                    if (z) {
                        cM11144a = C3191bf.m11144a(Character.toUpperCase(strM3976c.charAt(0)));
                        if (next.m3998y() != 1) {
                            arrayList.add(next);
                            i++;
                            C3178at.m11103a();
                            C3178at.m11116e();
                            c = cM11144a;
                        }
                    }
                } else {
                    cM11144a = c;
                    C3178at.m11103a();
                    C3178at.m11116e();
                    c = cM11144a;
                }
            }
            if (c != 0) {
                this.f1801am.add(arrayList);
                this.f1800al.add(new C0511a(2, String.valueOf(c), i, 2, false, false, 0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3284a(ArrayList<C0511a> arrayList, ArrayList<ArrayList<C0513c>> arrayList2) {
        if (this.f1740D != null) {
            int size = (this.f1838bY - this.f1865ca) - this.f1866cb;
            if (this.f1806ar && arrayList2.size() > 0) {
                size = arrayList2.get(0).size();
            }
            if (size > 1) {
                this.f1740D.setText(getResources().getString(R.string.buddy_list_total_count, Integer.valueOf(size)));
            } else {
                this.f1740D.setText(getResources().getString(R.string.buddy_list_total_count_1));
            }
        }
        this.f1798aj.clear();
        this.f1799ak.clear();
        Iterator<C0511a> it = arrayList.iterator();
        while (it.hasNext()) {
            this.f1798aj.add(new C0511a(it.next()));
        }
        Iterator<ArrayList<C0513c>> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            ArrayList<C0513c> next = it2.next();
            ArrayList<C0513c> arrayList3 = new ArrayList<>();
            Iterator<C0513c> it3 = next.iterator();
            while (it3.hasNext()) {
                C0513c next2 = it3.next();
                arrayList3.add(new C0513c(next2));
                if (GlobalApplication.m6456e() && next2.m3997x() && next2.m3986m() && m3328aj() && getActivity() != null && (getActivity() instanceof TabActivity)) {
                    Intent intent = new Intent();
                    intent.setAction(BuddyGroupProfileFragment.class.getName());
                    C0512b c0512b = new C0512b(Integer.parseInt(next2.m3975b()), next2.m3976c(), next2.m3999z() == null ? 0 : next2.m3999z().size(), 2);
                    intent.putExtra("ACTIVITY_PURPOSE", 18);
                    intent.putExtra("groupInfo", c0512b);
                    intent.putExtra("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST", m3443h());
                    intent.putExtra("LAUNCH_AS_CHILD", true);
                    ((TabActivity) getActivity()).m1312a(R.id.fragment_buddy, intent, BuddyGroupProfileFragment.class);
                    if (GlobalApplication.m6456e()) {
                        m3437c(next2);
                    }
                    m3362c(false);
                    m3371d(false);
                }
            }
            this.f1799ak.add(arrayList3);
        }
        if (this.f1791ac == 19) {
            this.f1769aG = this.f1770aH;
        }
        if (this.f1791ac == 6 && this.f1762Z != null && this.f1762Z.containsKey("ACTIVITY_PURPOSE_ARG") && !this.f1762Z.getBoolean("ACTIVITY_PURPOSE_ARG")) {
            for (String str : this.f1755S) {
                this.f1769aG.add(str);
            }
            this.f1871cg = this.f1755S.length;
        }
        if (this.f1769aG != null && this.f1769aG.size() > 0) {
            Iterator<String> it4 = this.f1769aG.iterator();
            while (it4.hasNext()) {
                String next3 = it4.next();
                if (this.f1771aI.get(next3) == null) {
                    m3432a(next3, true, null, true, true);
                }
            }
            if (this.f1791ac != 9) {
                this.f1769aG.clear();
            }
        }
        if (this.f1803ao != null) {
            this.f1803ao.m4037a(m3402r());
            this.f1803ao.m4046e(this.f1858bt.m11463a().toString());
            this.f1803ao.notifyDataSetChanged();
        }
        if (this.f1830bQ != null) {
            this.f1830bQ.mo3452a(this.f1738B.m13106a());
        }
        if (this.f1803ao != null && m3224F() && f1728c != 0 && f1729d != 0) {
            this.f1738B.setSelectionFromTop(f1728c, f1729d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public boolean m3224F() {
        if (getActivity() != null) {
            return getActivity().getClass().getSimpleName().equals(TabActivity.class.getSimpleName());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public void m3225G() {
        C3250y.m11450b("createNewBuddyGroup", f1724a);
        ArrayList<C0513c> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        Iterator<ArrayList<C0513c>> it = this.f1797ai.iterator();
        while (it.hasNext()) {
            Iterator<C0513c> it2 = it.next().iterator();
            while (it2.hasNext()) {
                C0513c next = it2.next();
                if (next.m3986m() && !next.m3997x() && !arrayList2.contains(next.m3975b())) {
                    arrayList.add(next);
                    arrayList2.add(next.m3975b());
                }
            }
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("createNewBuddyGroup size " + arrayList.size(), f1724a);
        }
        if (arrayList.size() > 0) {
            this.f1796ah.add(1, new C0511a(-1, getResources().getString(R.string.buddy_list_group_new_buddy), arrayList.size(), -1, true, false, 0));
            this.f1797ai.add(1, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public void m3228H() {
        StringBuffer stringBuffer = new StringBuffer();
        if (!this.f1806ar && this.f1798aj.size() != 0 && this.f1738B != null) {
            for (int i = 0; i < this.f1798aj.size(); i++) {
                try {
                    if (!this.f1738B.isGroupExpanded(i) && this.f1798aj.get(i).m3956d() != -1) {
                        stringBuffer.append("," + this.f1798aj.get(i).m3954b());
                    }
                } catch (Exception e) {
                    C3250y.m11442a("isn't GroupExpanded", getClass().getSimpleName());
                }
            }
            if (this.f1791ac == 1) {
                getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putInt("BUDDY_SORT_STYLE", this.f1789aa).commit();
                if (this.f1789aa == 12) {
                    if (stringBuffer.toString().length() > 0) {
                        getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("RELATIONSHIP_FOLDER_STATE", stringBuffer.toString().substring(1)).commit();
                        return;
                    } else {
                        getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("RELATIONSHIP_FOLDER_STATE", null).commit();
                        return;
                    }
                }
                if (this.f1789aa == 11) {
                    if (stringBuffer.toString().length() > 0) {
                        getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("ALPHABET_FOLDER_STATE", stringBuffer.toString().substring(1)).commit();
                        return;
                    } else {
                        getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("ALPHABET_FOLDER_STATE", null).commit();
                        return;
                    }
                }
                if (this.f1789aa == 13) {
                    if (stringBuffer.toString().length() > 0) {
                        getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("CHATONV_FOLDER_STATE", stringBuffer.toString().substring(1)).commit();
                    } else {
                        getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("CHATONV_FOLDER_STATE", null).commit();
                    }
                }
            }
        }
    }

    /* renamed from: I */
    private void m3229I() {
        String string = getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).getString("RELATIONSHIP_FOLDER_STATE", null);
        if (string != null) {
            this.f1793ae = string.split(",");
        } else {
            this.f1793ae = new String[0];
        }
        String string2 = getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).getString("ALPHABET_FOLDER_STATE", null);
        if (string2 != null) {
            this.f1794af = string2.split(",");
        } else {
            this.f1794af = new String[0];
        }
        String string3 = getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).getString("CHATONV_FOLDER_STATE", null);
        if (string3 != null) {
            this.f1795ag = string3.split(",");
        } else {
            this.f1795ag = new String[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public void m3232J() {
        String[] strArr;
        if (this.f1806ar || this.f1791ac == 6 || this.f1791ac == 18) {
            for (int i = 0; i < this.f1798aj.size(); i++) {
                this.f1738B.expandGroup(i);
            }
            return;
        }
        if (this.f1791ac == 5) {
            for (int i2 = 0; i2 < this.f1798aj.size(); i2++) {
                if (this.f1798aj.get(i2).m3956d() < 2) {
                    this.f1738B.collapseGroup(i2);
                } else {
                    this.f1738B.expandGroup(i2);
                }
            }
            return;
        }
        m3229I();
        for (int i3 = 0; i3 < this.f1798aj.size(); i3++) {
            this.f1738B.expandGroup(i3);
        }
        if (this.f1789aa == 12 && this.f1793ae != null) {
            strArr = this.f1793ae;
        } else if (this.f1789aa == 11 && this.f1794af != null) {
            strArr = this.f1794af;
        } else if (this.f1789aa != 13 || this.f1795ag == null) {
            strArr = null;
        } else {
            strArr = this.f1795ag;
        }
        if (strArr != null) {
            for (int i4 = 0; i4 < this.f1798aj.size(); i4++) {
                int i5 = 0;
                while (true) {
                    if (i5 >= strArr.length) {
                        break;
                    }
                    if (!this.f1798aj.get(i4).m3954b().equals(strArr[i5])) {
                        i5++;
                    } else {
                        this.f1738B.collapseGroup(i4);
                        break;
                    }
                }
                if (this.f1791ac == 1 && this.f1790ab != this.f1789aa && (this.f1798aj.get(i4).m3956d() < 2 || this.f1798aj.get(i4).m3956d() == 4 || this.f1798aj.get(i4).m3956d() == 7)) {
                    this.f1738B.collapseGroup(i4);
                }
            }
        }
        this.f1790ab = this.f1789aa;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.f1791ac == 1 || this.f1791ac == 7) {
            menuInflater.inflate(R.menu.activity_buddylist_menu, menu);
        } else if (this.f1791ac != 18) {
            menuInflater.inflate(R.menu.cancel_done_menu, menu);
        }
        super.onCreateOptionsMenu(menu, menuInflater);
        C3250y.m11458g("onCreateOptionsMenu()", f1724a);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (!GlobalApplication.m6456e() || !m3330ak()) {
            MenuItem menuItemFindItem = menu.findItem(R.id.buddylist_menu_add_group);
            MenuItem menuItemFindItem2 = menu.findItem(R.id.buddylist_menu_deselect_all);
            MenuItem menuItemFindItem3 = menu.findItem(R.id.buddylist_menu_sort);
            MenuItem menuItemFindItem4 = menu.findItem(R.id.buddylist_menu_manage_buddies);
            MenuItem menuItemFindItem5 = menu.findItem(R.id.buddylist_menu_tell_friends);
            MenuItem menuItemFindItem6 = menu.findItem(R.id.buddylist_menu_contact_sync);
            int iM6034b = C1360d.m6034b(getActivity().getContentResolver());
            int iM6041c = C1360d.m6041c(getActivity().getContentResolver());
            int i = iM6034b - iM6041c;
            C3250y.m11450b("BuddyFragment -> onPrepareOptionsMenu -> buddyCount : " + iM6034b, getClass().getSimpleName());
            C3250y.m11450b("BuddyFragment -> onPrepareOptionsMenu -> hideBuddyCount : " + iM6041c, getClass().getSimpleName());
            C3250y.m11450b("BuddyFragment -> onPrepareOptionsMenu -> normalBuddyCount : " + i, getClass().getSimpleName());
            if (this.f1738B != null && m3444i() != 0) {
                if (menuItemFindItem != null) {
                    if (this.f1789aa == 11 || this.f1789aa == 12 || this.f1789aa == 13) {
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
            } else if (this.f1791ac == 1) {
                if (menuItemFindItem2 != null) {
                    menuItemFindItem2.setVisible(false);
                }
                if (menuItemFindItem3 != null) {
                    if (m3400q() == 1 && i > 0) {
                        menuItemFindItem3.setVisible(true);
                    } else {
                        menuItemFindItem3.setVisible(false);
                    }
                }
                if (menuItemFindItem != null) {
                    if ((this.f1789aa == 11 || this.f1789aa == 12 || this.f1789aa == 13) && i > 0) {
                        menuItemFindItem.setVisible(true);
                    } else {
                        menuItemFindItem.setVisible(false);
                    }
                }
                if (menuItemFindItem4 != null && i > 0) {
                    menuItemFindItem4.setVisible(true);
                } else {
                    menuItemFindItem4.setVisible(false);
                }
                if (menuItemFindItem5 != null) {
                    menuItemFindItem5.setVisible(true);
                } else {
                    menuItemFindItem5.setVisible(false);
                }
                if (menuItemFindItem6 != null) {
                    if (!C1493a.m6463a("for_wifi_only_device") || !TextUtils.isEmpty(C3159aa.m10962a().m10979a("msisdn", ""))) {
                        menuItemFindItem6.setVisible(true);
                    } else {
                        menuItemFindItem6.setVisible(false);
                    }
                }
            } else if (this.f1791ac == 7) {
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
                if (menuItemFindItem6 != null) {
                    if (!C1493a.m6463a("for_wifi_only_device") || !TextUtils.isEmpty(C3159aa.m10962a().m10979a("msisdn", ""))) {
                        menuItemFindItem6.setVisible(true);
                    } else {
                        menuItemFindItem6.setVisible(false);
                    }
                }
            } else {
                menu.setGroupVisible(R.id.buddy_fragment_menu_group_option, false);
            }
            this.f1855bq = menu.findItem(R.id.menu_done);
            if (this.f1855bq != null) {
                this.f1855bq.setVisible(false);
            }
            this.f1856br = menu.findItem(R.id.menu_cancel);
            if (this.f1856br != null) {
                this.f1856br.setVisible(false);
            }
            if (this.f1791ac == 1 || this.f1791ac == 7) {
                return;
            }
            if (this.f1791ac == 1000 && this.f1892w == 0) {
                return;
            }
            if ((this.f1791ac != 6 || getArguments() == null || !getArguments().containsKey("ACTIVITY_PURPOSE_ARG") || !getArguments().getBoolean("ACTIVITY_PURPOSE_ARG")) && this.f1791ac != 18) {
                if (this.f1855bq != null) {
                    this.f1855bq.setVisible(true);
                    if (this.f1738B != null) {
                        if (m3444i() > 0) {
                            this.f1855bq.setEnabled(true);
                        } else {
                            this.f1855bq.setEnabled(false);
                        }
                    }
                    m3425a(new C0554bl(this));
                }
                if (this.f1856br != null && this.f1791ac != 1000) {
                    this.f1856br.setVisible(true);
                    this.f1856br.setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0556bn(this));
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intent intent;
        Bitmap bitmap;
        this.f1858bt.setText("");
        m3240N();
        switch (menuItem.getItemId()) {
            case 2:
                m3246Q();
                return true;
            case 4:
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11846a("00030008");
                }
                m3228H();
                Intent intent2 = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                intent2.putExtra("BUDDY_SORT_STYLE", this.f1789aa);
                intent2.putExtra("ACTIVITY_PURPOSE", 2);
                startActivity(intent2);
                return true;
            case 5:
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11846a("00030009");
                }
                m3228H();
                Intent intent3 = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                intent3.putExtra("BUDDY_SORT_STYLE", this.f1789aa);
                intent3.putExtra("ACTIVITY_PURPOSE", 3);
                startActivity(intent3);
                return true;
            case 6:
                startActivity(new Intent(getActivity(), (Class<?>) ActivitySettings.class));
                return true;
            case 7:
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11846a("00030015");
                }
                String str = this.f1752P;
                EnumC1450r enumC1450rM6339a = EnumC1450r.m6339a(this.f1754R);
                ProfileImageView profileImageView = new ProfileImageView(getActivity());
                profileImageView.m11473a(profileImageView, EnumC1450r.m6339a(this.f1754R));
                if (enumC1450rM6339a == EnumC1450r.ONETOONE) {
                    str = this.f1753Q;
                    C3205bt.m11182a(getActivity()).m11210a(profileImageView, this.f1753Q);
                    profileImageView.setBuddyNo(this.f1753Q);
                }
                Intent intentM10991a = C3161ac.m10991a(getActivity(), str, enumC1450rM6339a);
                String str2 = this.f1756T;
                String str3 = enumC1450rM6339a == EnumC1450r.GROUPCHAT ? String.format("%s(%d)", str2, Integer.valueOf(this.f1755S.length + 1)) : str2;
                try {
                    bitmap = ((BitmapDrawable) profileImageView.getDrawable()).getBitmap();
                } catch (Exception e) {
                    bitmap = null;
                }
                C3161ac.m10992a(getActivity(), intentM10991a, str3, Bitmap.createScaledBitmap(C3162ad.m10995a(getActivity(), bitmap), C3161ac.m10989a(getResources().getDisplayMetrics().density), C3161ac.m10989a(getResources().getDisplayMetrics().density), true));
                return true;
            case 8:
                if (this.f1804ap == null) {
                    return true;
                }
                this.f1804ap.m4066i();
                return true;
            case 9:
                m3228H();
                Intent intent4 = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                intent4.putExtra("BUDDY_SORT_STYLE", this.f1789aa);
                intent4.putExtra("ACTIVITY_PURPOSE", 12);
                startActivity(intent4);
                return true;
            case 14:
                AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(getActivity());
                abstractC3271aM11494a.mo11495a(R.string.chat_info_delete_all);
                abstractC3271aM11494a.mo11506b(R.string.dialog_title_msgbox_delete).mo11511b(true).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0560br(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0559bq(this));
                abstractC3271aM11494a.mo11512b();
                return true;
            case R.id.buddylist_menu_sort /* 2131166532 */:
                if (m3400q() == 1) {
                    String[] strArr = {getString(R.string.mypage_profile_name), getString(R.string.chatonv_buddies)};
                    int i = this.f1789aa - 11;
                    if (i == 2) {
                        i = 1;
                    }
                    this.f1808at = AbstractC3271a.m11494a(getActivity()).mo11500a(getString(R.string.buddy_list_optionmenu_listby)).mo11503a(strArr, i, new DialogInterfaceOnClickListenerC0558bp(this)).mo11501a(GlobalApplication.m6451b().getString(R.string.cancel), new DialogInterfaceOnClickListenerC0557bo(this)).mo11512b();
                    return true;
                }
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11847a("00030006", "00000001");
                }
                this.f1789aa = 11;
                m3228H();
                if (this.f1790ab == this.f1789aa) {
                    return true;
                }
                m3214A();
                return true;
            case R.id.buddylist_menu_add_group /* 2131166533 */:
                if (m3444i() > 199) {
                    m3283a((CharSequence) getActivity().getString(R.string.buddy_list_select_maximum_failed, new Object[]{199}));
                    return true;
                }
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11846a("00030007");
                }
                this.f1774aL = new AlertDialogC0599dc(getActivity(), this);
                this.f1774aL.m4084a(true);
                this.f1774aL.show();
                m3362c(true);
                return true;
            case R.id.buddylist_menu_manage_buddies /* 2131166534 */:
                startActivity(new Intent(getActivity(), (Class<?>) ActivityManageBuddy.class));
                return true;
            case R.id.buddylist_menu_tell_friends /* 2131166535 */:
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11846a("00030010");
                }
                Intent intent5 = new Intent(getActivity(), (Class<?>) AddBuddyActivity.class);
                intent5.putExtra("ADD_BUDDY_TYPE", 103);
                startActivityForResult(intent5, 100);
                return true;
            case R.id.buddylist_menu_contact_sync /* 2131166536 */:
                if (TextUtils.isEmpty(C3159aa.m10962a().m10979a("msisdn", ""))) {
                    intent = new Intent(getActivity(), (Class<?>) ActivityRegist.class);
                } else {
                    intent = new Intent(getActivity(), (Class<?>) ActivityContactSync.class);
                }
                intent.putExtra("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC", "ACTIVITY_PURPOSE_CALL_CONTACT_SYNC");
                startActivity(intent);
                return true;
            case R.id.buddylist_menu_deselect_all /* 2131166537 */:
                m3430a(true);
                getView().findViewById(R.id.layoutChatButtons).setVisibility(8);
                m3447l();
                if (GlobalApplication.m6456e() && this.f1791ac == 1) {
                    if (this.f1843bd.getVisibility() == 0 || this.f1845bf.getVisibility() == 0) {
                        this.f1820bF.setVisibility(0);
                    } else {
                        this.f1820bF.setVisibility(8);
                    }
                    this.f1818bD.setVisibility(8);
                    this.f1819bE.setVisibility(8);
                }
                C3641ai.m13210a(getActivity(), R.string.buddy_list_deselectall_toast, 0).show();
                return true;
            case R.id.menu_done /* 2131166604 */:
                m3260X();
                return true;
            case R.id.group_page_delete_menu /* 2131166613 */:
                if (!GlobalApplication.m6456e()) {
                    return true;
                }
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11846a("00030019");
                }
                AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.buddy_group_list_dialog_removegroup_title)).mo11509b(getResources().getString(R.string.buddy_group_list_dialog_removegroup_message)).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0561bs(this)).mo11501a(getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).mo11512b();
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public void m3234K() {
        ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
        ArrayList<String> arrayListM6068b = C1362f.m6068b(contentResolver);
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<Integer> arrayListM6059a = C1362f.m6059a(contentResolver);
        for (int i = 0; i < arrayListM6059a.size(); i++) {
            ArrayList<String> arrayListM6060a = C1362f.m6060a(contentResolver, arrayListM6059a.get(i).intValue());
            if (!arrayListM6068b.get(i).equals("Favorites")) {
                map.put(arrayListM6068b.get(i), arrayListM6060a);
            }
        }
        arrayListM6068b.remove("Favorites");
        if (arrayListM6068b.size() == 0) {
            C3159aa.m10962a().m10983b("Is Group Uploaded", (Boolean) true);
        } else {
            new C1330h(this.f1836bW).m5714a("group", false, 328, arrayListM6068b, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public void m3235L() {
        ArrayList<Integer> arrayListM6059a;
        ArrayList<String> arrayListM6068b;
        int i = 0;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
            arrayListM6059a = C1362f.m6059a(contentResolver);
            arrayListM6068b = C1362f.m6068b(contentResolver);
        } catch (Exception e) {
            C3250y.m11453c("group image name changed failed", getClass().getSimpleName());
        }
        while (true) {
            int i2 = i;
            if (i2 >= arrayListM6059a.size()) {
                break;
            }
            if (!arrayListM6068b.get(i2).toLowerCase().equals("Favorites".toLowerCase())) {
                try {
                    File file = new File(CommonApplication.m11493l().getFilesDir(), Integer.toString(arrayListM6059a.get(i2).intValue()) + "_group_profile.png_");
                    File file2 = new File(CommonApplication.m11493l().getFilesDir(), arrayListM6068b.get(i2) + "_group_profile.png_");
                    if (file.exists()) {
                        C3250y.m11453c("[LOCAL STORAGE]group image name changed " + arrayListM6059a.get(i2) + " to " + arrayListM6068b.get(i2) + " is " + Boolean.toString(file.renameTo(file2)), getClass().getSimpleName());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    File file3 = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "//profile");
                    if (file3.exists()) {
                        File file4 = new File(file3, String.format("%s_big.jpeg_", Integer.toString(arrayListM6059a.get(i2).intValue())));
                        File file5 = new File(file3, String.format("%s_big.jpeg_", arrayListM6068b.get(i2)));
                        if (file4.exists()) {
                            C3250y.m11453c("[SDCARD]group image name changed " + arrayListM6059a.get(i2) + " to " + arrayListM6068b.get(i2) + " is " + Boolean.toString(file4.renameTo(file5)), getClass().getSimpleName());
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                try {
                    File file6 = new File(CommonApplication.m11493l().getExternalFilesDir(null) + "/profile/", String.format("%s_big.jpeg_", Integer.toString(arrayListM6059a.get(i2).intValue())));
                    File file7 = new File(CommonApplication.m11493l().getExternalFilesDir(null) + "/profile/", String.format("%s_big.jpeg_", arrayListM6068b.get(i2)));
                    if (file6.exists()) {
                        C3250y.m11453c("[NEW SDCARD]group image name changed " + arrayListM6059a.get(i2) + " to " + arrayListM6068b.get(i2) + " is " + Boolean.toString(file6.renameTo(file7)), getClass().getSimpleName());
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                try {
                    File file8 = new File(C3223ck.m11329c() + "/" + Integer.toString(arrayListM6059a.get(i2).intValue()) + "/");
                    File file9 = new File(C3223ck.m11329c() + "/" + arrayListM6068b.get(i2) + "/");
                    if (file8.exists()) {
                        C3250y.m11453c("[CACHE DIR]group image name changed " + arrayListM6059a.get(i2) + " to " + arrayListM6068b.get(i2) + " is " + Boolean.toString(file8.renameTo(file9)), getClass().getSimpleName());
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            i = i2 + 1;
            C3250y.m11453c("group image name changed failed", getClass().getSimpleName());
            C3250y.m11453c("group image name changed delay " + (System.currentTimeMillis() - jCurrentTimeMillis) + " milles", getClass().getSimpleName());
        }
        m3353b(arrayListM6068b);
        C3159aa.m10962a().m10983b("Is Group Profile Image Name Changed", (Boolean) true);
        C3250y.m11453c("group image name changed delay " + (System.currentTimeMillis() - jCurrentTimeMillis) + " milles", getClass().getSimpleName());
    }

    /* renamed from: b */
    private void m3353b(ArrayList<String> arrayList) {
        String strM3375e;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                if (!arrayList.get(i2).toLowerCase().equals("Favorites".toLowerCase()) && (strM3375e = m3375e(arrayList.get(i2))) != null) {
                    C1335m.m5786a(this.f1836bW, strM3375e, arrayList.get(i2), arrayList.get(i2));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m3375e(java.lang.String r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyFragment.m3375e(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0203 A[SYNTHETIC] */
    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreateContextMenu(android.view.ContextMenu r13, android.view.View r14, android.view.ContextMenu.ContextMenuInfo r15) {
        /*
            Method dump skipped, instructions count: 527
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyFragment.onCreateContextMenu(android.view.ContextMenu, android.view.View, android.view.ContextMenu$ContextMenuInfo):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m3431a(java.lang.String r9) throws java.lang.Throwable {
        /*
            r8 = this;
            r6 = 0
            r7 = 0
            android.support.v4.app.FragmentActivity r0 = r8.getActivity()     // Catch: android.database.CursorIndexOutOfBoundsException -> L40 java.lang.Throwable -> L56
            android.content.Context r0 = r0.getApplicationContext()     // Catch: android.database.CursorIndexOutOfBoundsException -> L40 java.lang.Throwable -> L56
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: android.database.CursorIndexOutOfBoundsException -> L40 java.lang.Throwable -> L56
            android.net.Uri r1 = com.sec.chaton.p027e.C1390ah.f5188a     // Catch: android.database.CursorIndexOutOfBoundsException -> L40 java.lang.Throwable -> L56
            r2 = 0
            java.lang.String r3 = "buddy_no=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: android.database.CursorIndexOutOfBoundsException -> L40 java.lang.Throwable -> L56
            r5 = 0
            r4[r5] = r9     // Catch: android.database.CursorIndexOutOfBoundsException -> L40 java.lang.Throwable -> L56
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: android.database.CursorIndexOutOfBoundsException -> L40 java.lang.Throwable -> L56
            if (r1 == 0) goto L67
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L5d android.database.CursorIndexOutOfBoundsException -> L64
            if (r0 <= 0) goto L67
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L5d android.database.CursorIndexOutOfBoundsException -> L64
            java.lang.String r0 = "islike"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L5d android.database.CursorIndexOutOfBoundsException -> L64
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L5d android.database.CursorIndexOutOfBoundsException -> L64
            java.lang.String r2 = "Y"
            boolean r6 = r0.equals(r2)     // Catch: java.lang.Throwable -> L5d android.database.CursorIndexOutOfBoundsException -> L64
            r0 = r6
        L3a:
            if (r1 == 0) goto L3f
            r1.close()
        L3f:
            return r0
        L40:
            r0 = move-exception
            r0 = r7
        L42:
            java.lang.String r1 = "CursorIndexOob"
            java.lang.Class r2 = r8.getClass()     // Catch: java.lang.Throwable -> L60
            java.lang.String r2 = r2.getSimpleName()     // Catch: java.lang.Throwable -> L60
            com.sec.chaton.util.C3250y.m11442a(r1, r2)     // Catch: java.lang.Throwable -> L60
            if (r0 == 0) goto L54
            r0.close()
        L54:
            r0 = r6
            goto L3f
        L56:
            r0 = move-exception
        L57:
            if (r7 == 0) goto L5c
            r7.close()
        L5c:
            throw r0
        L5d:
            r0 = move-exception
            r7 = r1
            goto L57
        L60:
            r1 = move-exception
            r7 = r0
            r0 = r1
            goto L57
        L64:
            r0 = move-exception
            r0 = r1
            goto L42
        L67:
            r0 = r6
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyFragment.m3431a(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) {
        C0513c c0513c = this.f1802an;
        switch (menuItem.getItemId()) {
            case 101:
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11846a("00030016");
                }
                if (c0513c.m3975b().startsWith("0999")) {
                    Intent intent = new Intent(getActivity(), (Class<?>) SpecialBuddyActivity.class);
                    intent.putExtra("specialuserid", c0513c.m3975b());
                    intent.putExtra("speicalusername", c0513c.m3976c());
                    intent.putExtra("specialBuddyAdded", true);
                    startActivity(intent);
                } else {
                    Intent intent2 = new Intent(getActivity(), (Class<?>) BuddyProfileActivity.class);
                    intent2.putExtra("PROFILE_BUDDY_NO", c0513c.m3975b());
                    intent2.putExtra("PROFILE_BUDDY_NAME", c0513c.m3976c());
                    if (GlobalApplication.m6456e()) {
                        intent2.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
                    }
                    startActivityForResult(intent2, 11);
                }
                return true;
            case 102:
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11846a("00030011");
                }
                this.f1804ap.m4052a(c0513c);
                return true;
            case 103:
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11846a("00030012");
                }
                this.f1804ap.m4055b(c0513c);
                return true;
            case 104:
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11846a("00030017");
                }
                m3262Y();
                new C1328f(this.f1886q).m5706a(c0513c.m3975b(), 1);
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
                m3281a(c0513c, menuItem.getItemId());
                return true;
            case 111:
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11846a("00030019");
                }
                AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.buddy_group_list_dialog_removegroup_title)).mo11509b(getResources().getString(R.string.buddy_group_list_dialog_removegroup_message)).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0563bu(this, c0513c)).mo11501a(getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).mo11512b();
                return true;
            case 112:
                HashMap<String, String> mapM3999z = c0513c.m3999z();
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11846a("00030018");
                }
                C0512b c0512b = new C0512b(Integer.parseInt(c0513c.m3975b()), c0513c.m3976c(), mapM3999z == null ? 0 : mapM3999z.size(), 2);
                if (GlobalApplication.m6456e()) {
                    f1726bM = true;
                }
                Intent intent3 = new Intent(getActivity(), (Class<?>) BuddyGroupProfileActivity.class);
                intent3.putExtra("ACTIVITY_PURPOSE", 18);
                intent3.putExtra("groupInfo", c0512b);
                intent3.putExtra("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST", (String[]) c0513c.m3999z().keySet().toArray(new String[0]));
                startActivity(intent3);
                return true;
            case 113:
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11846a("00030013");
                }
                if (this.f1803ao != null) {
                    C0522ag c0522ag = this.f1803ao;
                    C0522ag.m4025f(c0513c.m3975b());
                    C1357af.m5989a(C1404av.m6253a(getActivity()).getReadableDatabase(), c0513c.m3975b());
                }
                this.f1804ap.m4058c(c0513c);
                return true;
            case 114:
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11846a("00030014");
                }
                if (this.f1803ao != null) {
                    C0522ag c0522ag2 = this.f1803ao;
                    C0522ag.m4027g(c0513c.m3975b());
                    C1357af.m5994b(C1404av.m6253a(getActivity()).getReadableDatabase(), c0513c.m3975b());
                }
                this.f1804ap.m4060d(c0513c);
                return true;
            case 116:
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11846a("00030029");
                }
                m3262Y();
                this.f1804ap.m4062e(c0513c);
                return true;
            case 117:
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11846a("00030029");
                }
                m3262Y();
                new C1330h(this.f1886q).m5741d(c0513c.m3975b());
                return true;
            case 118:
                m3370d(c0513c);
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0095  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3281a(com.sec.chaton.buddy.p019a.C0513c r6, int r7) {
        /*
            r5 = this;
            r2 = 0
            r1 = 1
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            boolean r0 = r6.m3997x()
            if (r0 != 0) goto L7c
            int r0 = r5.m3400q()
            if (r0 != r1) goto L95
            java.lang.String r0 = r6.m3975b()
            boolean r0 = m3357b(r0)
            if (r0 != r1) goto L95
            r0 = r1
        L1e:
            if (r0 != r1) goto L91
            android.content.res.Resources r0 = com.sec.chaton.global.GlobalApplication.m6451b()
            r1 = 2131428305(0x7f0b03d1, float:1.847825E38)
            java.lang.String r0 = r0.getString(r1)
            r3.add(r0)
            android.content.res.Resources r0 = com.sec.chaton.global.GlobalApplication.m6451b()
            r1 = 2131428306(0x7f0b03d2, float:1.8478253E38)
            java.lang.String r0 = r0.getString(r1)
            r3.add(r0)
            android.content.res.Resources r0 = com.sec.chaton.global.GlobalApplication.m6451b()
            r1 = 2131428307(0x7f0b03d3, float:1.8478255E38)
            java.lang.String r0 = r0.getString(r1)
            r3.add(r0)
            int r0 = r3.size()
            java.lang.CharSequence[] r0 = new java.lang.CharSequence[r0]
            java.lang.Object[] r0 = r3.toArray(r0)
            java.lang.CharSequence[] r0 = (java.lang.CharSequence[]) r0
            android.support.v4.app.FragmentActivity r1 = r5.getActivity()
            com.sec.common.a.a r1 = com.sec.common.p063a.AbstractC3271a.m11494a(r1)
            android.content.res.Resources r2 = com.sec.chaton.global.GlobalApplication.m6451b()
            r3 = 2131427741(0x7f0b019d, float:1.8477107E38)
            java.lang.String r2 = r2.getString(r3)
            r1.mo11500a(r2)
            com.sec.chaton.buddy.bv r2 = new com.sec.chaton.buddy.bv
            r2.<init>(r5, r6, r7)
            r1.mo11504a(r0, r2)
            com.sec.common.a.d r0 = r1.mo11505a()
            r0.show()
        L7b:
            return
        L7c:
            int r0 = r5.m3400q()
            if (r0 != r1) goto L95
            int r0 = r6.m3969F()
            r4 = -1
            if (r0 == r4) goto L95
            int r0 = r6.m3969F()
            if (r0 != r1) goto L95
            r0 = r1
            goto L1e
        L91:
            r5.m3282a(r6, r7, r2)
            goto L7b
        L95:
            r0 = r2
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyFragment.m3281a(com.sec.chaton.buddy.a.c, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01a5 A[PHI: r2
  0x01a5: PHI (r2v10 android.graphics.Bitmap) = (r2v9 android.graphics.Bitmap), (r2v13 android.graphics.Bitmap) binds: [B:35:0x0188, B:17:0x0080] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01ab  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3282a(com.sec.chaton.buddy.p019a.C0513c r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyFragment.m3282a(com.sec.chaton.buddy.a.c, int, int):void");
    }

    /* renamed from: b */
    public void m3434b(int i) {
        if (this.f1767aE != null) {
            if (i > 0) {
                if (i >= 100) {
                    this.f1767aE.setText(R.string.chat_max_unread);
                } else {
                    this.f1767aE.setText(String.valueOf(i));
                }
                this.f1767aE.setVisibility(0);
                return;
            }
            this.f1767aE.setVisibility(8);
        }
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        this.f1863by = i2;
        this.f1864bz = i;
        C0513c c0513c = this.f1799ak.get(i).get(i2);
        if (GlobalApplication.m6456e() && this.f1803ao != null) {
            this.f1803ao.m4032a(i, i2);
        }
        if (GlobalApplication.m6456e()) {
            this.f1829bP = c0513c.m3975b();
        }
        if (c0513c.m3975b().equals(getActivity().getResources().getString(R.string.setting_interaction_me))) {
            if (GlobalApplication.m6456e()) {
                Intent intent = new Intent();
                intent.setAction(MyPageFragment.class.getName());
                intent.putExtra("ACTIVITY_PURPOSE_CALL_MYPAGE", 22);
                ((TabActivity) getActivity()).m1312a(R.id.fragment_user_profile, intent, MyPageFragment.class);
                this.f1803ao.notifyDataSetChanged();
            } else {
                Intent intent2 = new Intent(getActivity(), (Class<?>) MeDialog.class);
                intent2.putExtra("ME_DIALOG_NAME", c0513c.m3976c());
                intent2.putExtra("ME_DIALOG_STATUSMSG", c0513c.m3977d());
                getActivity().startActivity(intent2);
            }
        }
        if (this.f1791ac == 1) {
            if (c0513c.m3975b().startsWith("0999")) {
                if (GlobalApplication.m6456e()) {
                    Intent intent3 = new Intent();
                    intent3.setAction(SpecialBuddyFragment.class.getName());
                    intent3.putExtra("specialuserid", c0513c.m3975b());
                    intent3.putExtra("speicalusername", c0513c.m3976c());
                    intent3.putExtra("specialBuddyAdded", true);
                    ((TabActivity) getActivity()).m1312a(R.id.fragment_buddy, intent3, SpecialBuddyFragment.class);
                } else {
                    Intent intent4 = new Intent(getActivity(), (Class<?>) SpecialBuddyDialog.class);
                    intent4.putExtra("specialuserid", c0513c.m3975b());
                    intent4.putExtra("speicalusername", c0513c.m3976c());
                    intent4.putExtra("specialBuddyAdded", true);
                    getActivity().startActivity(intent4);
                }
            } else if (c0513c.m3997x()) {
                if (GlobalApplication.m6456e()) {
                    this.f1802an = this.f1799ak.get(this.f1864bz).get(this.f1863by);
                    Intent intent5 = new Intent();
                    intent5.setAction(BuddyGroupProfileFragment.class.getName());
                    C0512b c0512b = new C0512b(Integer.parseInt(c0513c.m3975b()), c0513c.m3976c(), c0513c.m3999z() == null ? 0 : c0513c.m3999z().size(), 2);
                    intent5.putExtra("ACTIVITY_PURPOSE", 18);
                    intent5.putExtra("groupInfo", c0512b);
                    intent5.putExtra("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST", (String[]) c0513c.m3999z().keySet().toArray(new String[0]));
                    intent5.putExtra("LAUNCH_AS_CHILD", true);
                    ((TabActivity) getActivity()).m1312a(R.id.fragment_buddy, intent5, BuddyGroupProfileFragment.class);
                } else {
                    Intent intent6 = new Intent(getActivity(), (Class<?>) GroupDialog.class);
                    intent6.setFlags(67108864);
                    intent6.putExtra("GROUP_DIALOG_GROUP_NAME", c0513c.m3976c());
                    intent6.putExtra("GROUP_DIALOG_CHAT_RECEIVER", (String[]) c0513c.m3999z().keySet().toArray(new String[0]));
                    Iterator<String> it = c0513c.m3999z().keySet().iterator();
                    StringBuffer stringBuffer = new StringBuffer();
                    while (it.hasNext()) {
                        stringBuffer.append(c0513c.m3999z().get(it.next()) + ", ");
                    }
                    String string = stringBuffer.toString();
                    if (string.endsWith(", ")) {
                        string = string.substring(0, string.length() - 2);
                    }
                    intent6.putExtra("GROUP_DIALOG_GROUP_MEMBERS", string);
                    intent6.putExtra("GROUP_DIALOG_GROUP_ID", c0513c.m3975b());
                    getActivity().startActivity(intent6);
                }
            } else if (!c0513c.m3975b().equals(getActivity().getResources().getString(R.string.setting_interaction_me))) {
                if (GlobalApplication.m6456e()) {
                    Intent intent7 = new Intent();
                    intent7.setAction(BuddyProfileFragment.class.getName());
                    intent7.putExtra("PROFILE_BUDDY_NO", c0513c.m3975b());
                    intent7.putExtra("PROFILE_BUDDY_NAME", c0513c.m3976c());
                    intent7.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
                    ((TabActivity) getActivity()).m1312a(R.id.fragment_buddy, intent7, BuddyProfileFragment.class);
                } else {
                    Intent intent8 = new Intent(getActivity(), (Class<?>) BuddyDialog.class);
                    intent8.putExtra("BUDDY_DIALOG_BUDDY_NO", c0513c.m3975b());
                    intent8.putExtra("BUDDY_DIALOG_BUDDY_NAME", c0513c.m3976c());
                    intent8.setFlags(268435456);
                    startActivity(intent8);
                }
            }
        } else if (c0513c.m3997x()) {
            if (this.f1892w == 1 || this.f1892w == 2) {
                HashMap<String, String> mapM3999z = c0513c.m3999z();
                if (mapM3999z != null && mapM3999z.size() > 0) {
                    Iterator<String> it2 = mapM3999z.keySet().iterator();
                    while (it2.hasNext()) {
                        String strValueOf = String.valueOf(it2.next());
                        String str = mapM3999z.get(strValueOf);
                        C3250y.m11458g(strValueOf + ", " + str, f1724a);
                        String str2 = this.f1873ci ? null : str;
                        if (m3372d(strValueOf)) {
                            if (!m3432a(strValueOf, !this.f1738B.m13112d(), str2, true, true)) {
                                break;
                            }
                        }
                    }
                    if (this.f1830bQ != null) {
                        this.f1830bQ.mo3452a(this.f1738B.m13106a());
                    }
                }
            } else if (c0513c.m3999z().size() > 199) {
                m3283a((CharSequence) getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed, 199));
            } else if (this.f1812ax) {
                Intent intent9 = new Intent(getActivity(), (Class<?>) ChatActivity.class);
                intent9.setFlags(67108864);
                intent9.putExtra("chatType", EnumC1450r.GROUPCHAT.m6342a());
                intent9.putExtra("receivers", (String[]) c0513c.m3999z().keySet().toArray(new String[0]));
                intent9.putExtra("groupId", c0513c.m3975b());
                intent9.putExtra("content_type", this.f1813ay);
                intent9.putExtra("download_uri", this.f1814az);
                intent9.putExtra("sub_content", this.f1763aA);
                intent9.putExtra("forward_sender_name", this.f1764aB);
                intent9.putExtra("is_forward_mode", this.f1842bc);
                intent9.putExtra(C2310s.f8621e, this.f1765aC);
                startActivity(intent9);
            } else {
                Intent intent10 = new Intent(getActivity(), (Class<?>) GroupDialog.class);
                intent10.setFlags(67108864);
                intent10.putExtra("GROUP_DIALOG_GROUP_NAME", c0513c.m3976c());
                intent10.putExtra("GROUP_DIALOG_CHAT_RECEIVER", (String[]) c0513c.m3999z().keySet().toArray(new String[0]));
                Iterator<String> it3 = c0513c.m3999z().keySet().iterator();
                StringBuffer stringBuffer2 = new StringBuffer();
                while (it3.hasNext()) {
                    stringBuffer2.append(c0513c.m3999z().get(it3.next()) + ", ");
                }
                String string2 = stringBuffer2.toString();
                if (string2.endsWith(", ")) {
                    string2 = string2.substring(0, string2.length() - 2);
                }
                intent10.putExtra("GROUP_DIALOG_GROUP_MEMBERS", string2);
                intent10.putExtra("GROUP_DIALOG_GROUP_ID", c0513c.m3975b());
                startActivity(intent10);
            }
        } else if (this.f1892w == 0) {
            if (c0513c.m3975b().toString().startsWith("0999")) {
            }
            this.f1803ao.m4044d(null);
            if (this.f1791ac == 1000) {
                if (this.f1785aW) {
                    m3352b(c0513c.m3975b(), c0513c.m3976c());
                } else {
                    m3363c(new String[]{c0513c.m3975b()});
                }
                return true;
            }
            if (c0513c.m3975b().toString().startsWith("0999")) {
                this.f1804ap.m4056b(c0513c.m3975b());
                this.f1802an = c0513c;
            } else {
                this.f1804ap.m4053a(c0513c.m3975b());
                this.f1802an = c0513c;
            }
        } else {
            m3427a(c0513c.m3975b(), c0513c.m3976c());
            m3444i();
            if (m3314ac() && this.f1749M.getVisibility() == 0) {
                this.f1749M.setChecked(false);
            } else {
                this.f1749M.setChecked(true);
            }
            if (this.f1771aI != null) {
                this.f1771aI.put(c0513c.m3975b(), c0513c.m3975b());
            }
        }
        if (this.f1840ba != null) {
            if (m3444i() > 0) {
                this.f1840ba.mo4049a(true);
            } else {
                this.f1840ba.mo4049a(false);
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

    /* renamed from: M */
    private void m3238M() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.f1858bt, 2);
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public void m3240N() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f1858bt.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        C3250y.m11458g("onActivityResult()", f1724a);
        if (i == 100) {
            if (i2 == -1) {
                C3250y.m11458g("Add buddy success", f1724a);
                if (this.f1804ap != null) {
                    this.f1804ap.m4054b();
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
            intent2.putExtra("inboxNO", this.f1752P);
            intent2.putExtra("buddyNO", this.f1753Q);
            intent2.putExtra("chatType", this.f1754R);
            getActivity().setResult(-1, intent2);
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public void m3241O() {
        Iterator<ArrayList<C0513c>> it = this.f1797ai.iterator();
        while (it.hasNext()) {
            Iterator<C0513c> it2 = it.next().iterator();
            while (it2.hasNext()) {
                C0513c next = it2.next();
                if (next.m3986m() || next.m3996w() || next.m3995v()) {
                    this.f1804ap.m4063f();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public void m3244P() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<ArrayList<C0513c>> it = this.f1797ai.iterator();
        while (it.hasNext()) {
            Iterator<C0513c> it2 = it.next().iterator();
            while (it2.hasNext()) {
                C0513c next = it2.next();
                if (next.m3997x() && next.m3986m()) {
                    stringBuffer.append(next.m3975b() + ",");
                }
            }
        }
        if (this.f1791ac != 10 && stringBuffer.toString().length() > 0) {
            this.f1804ap.m4064g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public C0513c m3269a(String str, ArrayList<ArrayList<C0513c>> arrayList) {
        Iterator<ArrayList<C0513c>> it = arrayList.iterator();
        while (it.hasNext()) {
            Iterator<C0513c> it2 = it.next().iterator();
            while (it2.hasNext()) {
                C0513c next = it2.next();
                if (next.m3975b().equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    public void m3437c(C0513c c0513c) {
        this.f1802an = new C0513c(c0513c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public void m3246Q() {
        Intent intent = new Intent(getActivity(), (Class<?>) AddBuddyActivity.class);
        intent.putExtra("ADD_BUDDY_TYPE", 102);
        startActivityForResult(intent, 100);
    }

    /* renamed from: e */
    public void m3440e() {
        Intent intent;
        int iM3444i = m3444i();
        if (iM3444i > 0) {
            if (iM3444i <= 199) {
                if (iM3444i == 1) {
                    this.f1804ap.m4053a(m3443h()[0]);
                    return;
                }
                if (GlobalApplication.m6456e()) {
                    intent = TabActivity.m1226a(getActivity());
                } else {
                    intent = new Intent(getActivity(), (Class<?>) ChatActivity.class);
                }
                intent.setFlags(67108864);
                intent.putExtra("chatType", EnumC1450r.GROUPCHAT.m6342a());
                intent.putExtra("chatType", EnumC1450r.GROUPCHAT.m6342a());
                intent.putExtra(ChatFragment.f3494k, true);
                LinearLayout linearLayout = (LinearLayout) this.f1805aq.getChildAt(0);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < linearLayout.getChildCount(); i++) {
                    arrayList.add(linearLayout.getChildAt(i).getTag().toString());
                }
                intent.putExtra("receivers", (String[]) arrayList.toArray(new String[0]));
                if (this.f1854bp != null && m3444i() == this.f1854bp.m3999z().size() && this.f1738B.m13108a((String[]) this.f1854bp.m3999z().keySet().toArray(new String[0]))) {
                    intent.putExtra("groupId", this.f1854bp.m3975b());
                }
                if (this.f1812ax) {
                    intent.putExtra("content_type", this.f1813ay);
                    intent.putExtra("download_uri", this.f1814az);
                    intent.putExtra("sub_content", this.f1763aA);
                    intent.putExtra("forward_sender_name", this.f1764aB);
                    intent.putExtra("is_forward_mode", this.f1842bc);
                    intent.putExtra(C2310s.f8621e, this.f1765aC);
                }
                if (GlobalApplication.m6456e()) {
                    intent.putExtra("callChatList", true);
                }
                startActivity(intent);
                if (GlobalApplication.m6456e()) {
                    getActivity().sendBroadcast(new Intent(f1735n));
                }
                if (!this.f1787aY) {
                    getActivity().finish();
                    return;
                }
                return;
            }
            C3641ai.m13211a(getActivity(), String.format(getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed), 199), 0).show();
        }
    }

    /* renamed from: f */
    public void m3441f() {
        Intent intentM1226a;
        int iM3444i = m3444i();
        if (iM3444i > 0) {
            if (iM3444i <= 199) {
                if (GlobalApplication.m6456e()) {
                    intentM1226a = TabActivity.m1226a(getActivity());
                } else {
                    Intent intent = new Intent(getActivity(), (Class<?>) ChatActivity.class);
                    intent.setFlags(67108864);
                    intentM1226a = intent;
                }
                intentM1226a.putExtra(ChatFragment.f3494k, true);
                if (C1493a.m6463a("broadcast2_feature")) {
                    intentM1226a.putExtra("chatType", EnumC1450r.BROADCAST2.m6342a());
                } else {
                    intentM1226a.putExtra("chatType", EnumC1450r.BROADCAST.m6342a());
                }
                LinearLayout linearLayout = (LinearLayout) this.f1805aq.getChildAt(0);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < linearLayout.getChildCount(); i++) {
                    arrayList.add(linearLayout.getChildAt(i).getTag().toString());
                }
                intentM1226a.putExtra("receivers", (String[]) arrayList.toArray(new String[0]));
                if (this.f1812ax) {
                    intentM1226a.putExtra("content_type", this.f1813ay);
                    intentM1226a.putExtra("download_uri", this.f1814az);
                    intentM1226a.putExtra("sub_content", this.f1763aA);
                    intentM1226a.putExtra("forward_sender_name", this.f1764aB);
                    intentM1226a.putExtra("is_forward_mode", this.f1842bc);
                    intentM1226a.putExtra(C2310s.f8621e, this.f1765aC);
                }
                if (GlobalApplication.m6456e()) {
                    intentM1226a.putExtra("callChatList", true);
                }
                startActivity(intentM1226a);
                if (GlobalApplication.m6456e()) {
                    getActivity().sendBroadcast(new Intent(f1735n));
                }
                if (!this.f1787aY) {
                    getActivity().finish();
                    return;
                }
                return;
            }
            C3641ai.m13211a(getActivity(), String.format(getResources().getString(R.string.buddy_list_broadcast_toast_failed_exceed), 199), 0).show();
        }
    }

    /* renamed from: d */
    private void m3370d(C0513c c0513c) {
        C0512b c0512b = new C0512b(Integer.parseInt(c0513c.m3975b()), c0513c.m3976c(), c0513c.m3999z().keySet().toArray(new String[0]) == null ? 0 : ((String[]) c0513c.m3999z().keySet().toArray(new String[0])).length, 18);
        Intent intent = new Intent(getActivity(), (Class<?>) BuddyGroupMemberEditActivity.class);
        intent.putExtra("ACTIVITY_PURPOSE", 19);
        intent.putExtra("groupInfo", c0512b);
        intent.putExtra("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST", (String[]) c0513c.m3999z().keySet().toArray(new String[0]));
        startActivity(intent);
    }

    /* renamed from: R */
    private boolean m3248R() {
        int iM6733a = C1594v.m6733a(GlobalApplication.m11493l());
        if (-3 != iM6733a && -2 != iM6733a) {
            return true;
        }
        C3641ai.m13210a(GlobalApplication.m11493l(), R.string.popup_no_network_connection, 0).show();
        return false;
    }

    /* renamed from: S */
    private boolean m3250S() {
        if (!m3324ah()) {
            startActivity(new Intent(GlobalApplication.m11493l(), (Class<?>) ChatONVRedirectDialog.class));
            return false;
        }
        if (!m3319af()) {
            startActivity(new Intent(GlobalApplication.m11493l(), (Class<?>) ChatONVInstallDialog.class));
            return false;
        }
        return true;
    }

    /* renamed from: T */
    private void m3251T() {
        int iM48a;
        if (m3250S() && m3248R()) {
            LinearLayout linearLayout = (LinearLayout) this.f1805aq.getChildAt(0);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                arrayList.add(linearLayout.getChildAt(i).getTag().toString());
            }
            try {
                if (arrayList.size() == 1) {
                    iM48a = this.f1867cc.m47a(getActivity(), false, (String) arrayList.get(0), C3159aa.m10962a().m10979a("Push Name", ""), null);
                } else {
                    iM48a = this.f1867cc.m48a(getActivity(), false, (String[]) arrayList.toArray(new String[arrayList.size()]), C3159aa.m10962a().m10979a("Push Name", ""), null, null);
                }
            } catch (Exception e) {
                C3250y.m11443a(e, getClass().getSimpleName());
                iM48a = -1;
            }
            if (iM48a != 0) {
                C3641ai.m13210a(GlobalApplication.m11493l(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
            }
            if (!this.f1787aY) {
                getActivity().finish();
            }
        }
    }

    /* renamed from: U */
    private void m3253U() {
        int iM48a;
        if (m3250S() && m3248R()) {
            LinearLayout linearLayout = (LinearLayout) this.f1805aq.getChildAt(0);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                arrayList.add(linearLayout.getChildAt(i).getTag().toString());
            }
            try {
                if (arrayList.size() == 1) {
                    iM48a = this.f1867cc.m47a(getActivity(), true, (String) arrayList.get(0), C3159aa.m10962a().m10979a("Push Name", ""), null);
                } else {
                    iM48a = this.f1867cc.m48a(getActivity(), true, (String[]) arrayList.toArray(new String[arrayList.size()]), C3159aa.m10962a().m10979a("Push Name", ""), null, null);
                }
            } catch (Exception e) {
                C3250y.m11443a(e, getClass().getSimpleName());
                iM48a = -1;
            }
            if (iM48a != 0) {
                C3641ai.m13210a(GlobalApplication.m11493l(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
            }
            if (!this.f1787aY) {
                getActivity().finish();
            }
        }
    }

    /* renamed from: f */
    private void m3381f(String str) {
        if (m3444i() > 0) {
            int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
            if (-3 == iM6733a || -2 == iM6733a) {
                C3641ai.m13210a(getActivity(), R.string.popup_no_network_connection, 0).show();
            } else {
                new C1330h(this.f1868cd).m5716a("group", false, (String) null, str, m3443h(), 325);
                m3262Y();
            }
        }
    }

    /* renamed from: V */
    private void m3255V() {
        int iM3444i = m3444i();
        C3250y.m11458g("Button.OnClickListener() : INVITE BUDDY", f1724a);
        C3250y.m11458g("count : " + iM3444i, f1724a);
        C3250y.m11458g("mBundle.getStringArray(ChatFragment.EXTRA_PARTICIPANT).length : " + this.f1762Z.getStringArray(ChatFragment.f3489f).length, f1724a);
        C3250y.m11458g("mBundle.getInt(ChatFragment.KEY_CHAT_TYPE) : " + this.f1762Z.getInt("chatType"), f1724a);
        if (iM3444i > 0) {
            if (this.f1762Z.getInt("chatType") == EnumC1450r.GROUPCHAT.m6342a() || this.f1762Z.getInt("chatType") == EnumC1450r.ONETOONE.m6342a()) {
                if (iM3444i + this.f1762Z.getStringArray(ChatFragment.f3489f).length > 199) {
                    C3641ai.m13211a(getActivity(), String.format(getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed), 199), 0).show();
                    return;
                }
            } else if (EnumC1450r.m6340a(EnumC1450r.m6339a(this.f1762Z.getInt("chatType"))) && iM3444i + this.f1762Z.getStringArray(ChatFragment.f3489f).length > 199) {
                C3641ai.m13211a(getActivity(), String.format(getResources().getString(R.string.buddy_list_broadcast_toast_failed_exceed), 199), 0).show();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("receivers", m3443h());
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    /* renamed from: W */
    private void m3257W() {
        Intent intent = new Intent();
        intent.putExtra("blindlist", m3443h());
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    /* renamed from: X */
    private void m3260X() {
        if (this.f1791ac == 2) {
            m3440e();
            return;
        }
        if (this.f1791ac == 3) {
            m3441f();
            return;
        }
        if (this.f1791ac == 14) {
            m3251T();
            return;
        }
        if (this.f1791ac == 15) {
            m3253U();
            return;
        }
        if (this.f1791ac == 10) {
            m3381f(this.f1762Z.getString("ACTIVITY_PURPOSE_ARG2"));
            return;
        }
        if (this.f1791ac == 5) {
            m3255V();
            return;
        }
        if (this.f1791ac == 9) {
            m3257W();
            return;
        }
        if (this.f1791ac == 1000) {
            m3363c(m3443h());
        } else if (this.f1791ac == 6 && this.f1762Z.containsKey("ACTIVITY_PURPOSE_ARG") && !this.f1762Z.getBoolean("ACTIVITY_PURPOSE_ARG")) {
            this.f1831bR.mo4067a(this.f1797ai, m3443h());
        }
    }

    /* renamed from: c */
    private void m3363c(String[] strArr) {
        Intent intent = new Intent();
        intent.putExtra("result", strArr);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    /* renamed from: b */
    private void m3352b(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("chaton_buddy_number", str);
        intent.putExtra("chaton_buddy_name", str2);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    /* renamed from: g */
    public HashSet<String> m3442g() {
        return this.f1738B.m13109b();
    }

    /* renamed from: h */
    public String[] m3443h() {
        return this.f1738B.m13111c();
    }

    /* renamed from: i */
    public int m3444i() {
        if (this.f1738B != null) {
            return this.f1738B.m13106a();
        }
        return 0;
    }

    /* renamed from: j */
    public String[] m3445j() {
        return (String[]) this.f1835bV.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y */
    public void m3262Y() {
        if (getActivity() != null) {
            if (this.f1807as == null) {
                this.f1807as = ProgressDialogC3265l.m11490a(getActivity(), null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            } else {
                this.f1807as.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public void m3264Z() {
        if (getActivity() != null && this.f1807as != null) {
            this.f1807as.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3283a(CharSequence charSequence) {
        if (this.f1772aJ == null) {
            this.f1772aJ = C3641ai.m13211a(getActivity(), (CharSequence) null, 0);
        }
        this.f1772aJ.setText(charSequence);
        this.f1772aJ.show();
    }

    /* renamed from: a */
    private void m3275a(Bundle bundle) {
        if (bundle == null) {
            this.f1791ac = 1;
            this.f1790ab = this.f1789aa;
        } else {
            this.f1791ac = bundle.getInt("ACTIVITY_PURPOSE", 1);
            this.f1792ad = bundle.getInt("ACTIVITY_PURPOSE_ARG2");
            this.f1768aF = bundle.getString("require");
            this.f1755S = this.f1762Z.getStringArray(ChatFragment.f3489f);
            this.f1881f = (C0512b) bundle.get("groupInfo");
            this.f1891v = bundle.getBoolean("PROFILE_BUDDY_FROM_CHATINFO", this.f1891v);
        }
        if (this.f1791ac == 2 || this.f1791ac == 3 || this.f1791ac == 12 || this.f1791ac == 10 || this.f1791ac == 11 || this.f1791ac == 19 || this.f1791ac == 5 || ((this.f1791ac == 6 && this.f1762Z.containsKey("ACTIVITY_PURPOSE_ARG") && !this.f1762Z.getBoolean("ACTIVITY_PURPOSE_ARG")) || this.f1791ac == 20 || this.f1791ac == 8 || this.f1791ac == 9 || this.f1791ac == 15 || this.f1791ac == 14 || this.f1791ac == 1)) {
            this.f1892w = 2;
        } else {
            this.f1892w = 0;
        }
        this.f1870cf = 1;
        this.f1869ce = 0;
        if (this.f1791ac == 2) {
            this.f1871cg = 199;
            this.f1872ch = R.string.buddy_list_groupchat_toast_failed_exceed;
        } else if (this.f1791ac == 3) {
            this.f1871cg = 199;
            this.f1872ch = R.string.buddy_list_broadcast_toast_failed_exceed;
        } else if (this.f1791ac == 15) {
            this.f1871cg = this.f1853bo - 1;
            this.f1872ch = R.string.chatonv_max_call_members_limit_msg;
        } else if (this.f1791ac == 14) {
            this.f1871cg = this.f1852bn - 1;
            this.f1872ch = R.string.chatonv_max_call_members_limit_msg;
        } else if (this.f1791ac == 5) {
            this.f1869ce = this.f1762Z.getStringArray(ChatFragment.f3489f).length;
            int i = this.f1762Z.getInt("chatType");
            if (i == EnumC1450r.ONETOONE.m6342a() || i == EnumC1450r.GROUPCHAT.m6342a()) {
                this.f1871cg = 199;
                this.f1872ch = R.string.buddy_list_groupchat_toast_failed_exceed;
            } else if (EnumC1450r.m6340a(EnumC1450r.m6339a(i))) {
                this.f1871cg = 199;
                this.f1872ch = R.string.buddy_list_broadcast_toast_failed_exceed;
            } else {
                this.f1872ch = R.string.buddy_list_groupchat_toast_failed_exceed;
            }
        } else if (this.f1791ac == 9 || this.f1791ac == 6) {
            if (this.f1791ac == 6 && this.f1762Z.containsKey("ACTIVITY_PURPOSE_ARG") && !this.f1762Z.getBoolean("ACTIVITY_PURPOSE_ARG")) {
                this.f1871cg = 199;
                this.f1872ch = R.string.buddy_list_select_maximum_failed;
            }
        } else if (this.f1791ac == 10 || this.f1791ac == 19) {
            this.f1871cg = 199;
            this.f1872ch = R.string.buddy_list_select_maximum_failed;
        }
        if (this.f1791ac == 6) {
            if (this.f1762Z.containsKey("ACTIVITY_PURPOSE_CALLLOG_GROUP") && this.f1762Z.getBoolean("ACTIVITY_PURPOSE_CALLLOG_GROUP")) {
                this.f1874cj = 4;
            } else {
                this.f1874cj = 3;
            }
        } else if (this.f1791ac != 8 && this.f1791ac == 18) {
            this.f1874cj = 2;
        } else {
            this.f1874cj = 0;
        }
        if (this.f1791ac == 5 || this.f1791ac == 8 || this.f1791ac == 9 || this.f1791ac == 10 || this.f1791ac == 19 || this.f1791ac == 2 || this.f1791ac == 3 || this.f1791ac == 15 || this.f1791ac == 14) {
            if (this.f1791ac == 8 && bundle.containsKey("chatType")) {
                EnumC1450r enumC1450rM6339a = EnumC1450r.m6339a(bundle.getInt("chatType"));
                if (enumC1450rM6339a == EnumC1450r.BROADCAST || enumC1450rM6339a == EnumC1450r.GROUPCHAT) {
                    this.f1873ci = false;
                } else {
                    this.f1873ci = true;
                }
            } else {
                this.f1873ci = true;
            }
        } else {
            this.f1873ci = false;
        }
        if (this.f1791ac == 1000) {
            this.f1871cg = bundle.getInt("max", -1);
            this.f1870cf = bundle.getInt("min", 1);
            this.f1872ch = R.string.buddy_list_select_maximum_failed;
            this.f1755S = bundle.getStringArray("except");
            if (this.f1755S != null && this.f1755S.length > 0) {
                this.f1873ci = true;
                this.f1869ce = 0;
                this.f1871cg -= this.f1755S.length + 1;
            } else {
                this.f1873ci = false;
                this.f1869ce = 0;
            }
            if (bundle.getBoolean("single", false) || this.f1785aW) {
                this.f1892w = 0;
                this.f1874cj = 1;
            } else {
                this.f1892w = 2;
                this.f1874cj = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aa */
    public void m3309aa() {
        int iM13106a = this.f1738B.m13106a();
        C3250y.m11450b("check=" + iM13106a + ", def=" + this.f1869ce + ", min=" + this.f1870cf + ", max=" + this.f1871cg, f1724a);
        if (this.f1870cf != -1 && iM13106a < this.f1870cf) {
            if (this.f1840ba != null) {
                this.f1840ba.mo4049a(false);
            }
        } else if (this.f1871cg != -1 && iM13106a + this.f1869ce > this.f1871cg) {
            if (this.f1840ba != null) {
                this.f1840ba.mo4049a(false);
            }
            m3316ad();
        } else if (this.f1840ba != null) {
            this.f1840ba.mo4049a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ab */
    public void m3312ab() {
        int iM13106a = this.f1738B.m13106a();
        C3250y.m11450b("check=" + iM13106a, f1724a);
        if (iM13106a == 0) {
            this.f1758V.setEnabled(false);
            this.f1759W.setEnabled(false);
        }
        if (iM13106a > 199) {
            m3283a((CharSequence) getResources().getString(R.string.buddy_list_groupchat_toast_failed_exceed, 199));
            this.f1758V.setEnabled(false);
        } else {
            this.f1758V.setEnabled(true);
        }
        if (iM13106a > 199) {
            m3283a((CharSequence) getResources().getString(R.string.buddy_list_broadcast_toast_failed_exceed, 199));
            this.f1759W.setEnabled(false);
        } else {
            this.f1759W.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ac */
    public boolean m3314ac() {
        if (this.f1871cg == -1) {
            return true;
        }
        int iM13106a = this.f1738B.m13106a();
        C3250y.m11450b("canSelectMore check=" + iM13106a + ", def=" + this.f1869ce + ", min=" + this.f1870cf + ", max=" + this.f1871cg, f1724a);
        return iM13106a + this.f1869ce < this.f1871cg;
    }

    /* renamed from: ad */
    private void m3316ad() {
        C3250y.m11450b("showSelectionReachedMaximumPopup " + this.f1871cg, f1724a);
        m3283a((CharSequence) getActivity().getString(this.f1872ch, new Object[]{Integer.valueOf(this.f1871cg)}));
    }

    @Override // com.sec.chaton.base.InterfaceC0459d
    /* renamed from: a */
    public boolean mo3094a() {
        if (m3444i() <= 0) {
            return false;
        }
        m3430a(true);
        getView().findViewById(R.id.layoutChatButtons).setVisibility(8);
        m3447l();
        return true;
    }

    /* renamed from: ae */
    private void m3318ae() {
        this.f1775aM = new C3201bp();
        this.f1775aM.m11164a("get_all_buddies_in_buddylist", this.f1875ck, 600000L, "last_sync_time_get_all_buddies_in_buddylist");
    }

    /* renamed from: k */
    public void m3446k() {
        if (this.f1858bt != null) {
            this.f1858bt.requestFocus();
        }
    }

    /* renamed from: a */
    public void m3425a(InterfaceC0594cy interfaceC0594cy) {
        this.f1840ba = interfaceC0594cy;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (f1728c != 0) {
            bundle.putInt("INDEX", f1728c);
            bundle.putInt("TOP", f1729d);
            bundle.putBoolean("savedInstanceStateCheck", true);
            return;
        }
        bundle.putBoolean("savedInstanceStateCheck", false);
    }

    /* renamed from: l */
    public void m3447l() {
        if (C1493a.m6463a("for_wifi_only_device") || !TextUtils.isEmpty(C3159aa.m10962a().m10979a("msisdn", ""))) {
            this.f1848bi = true;
        } else {
            this.f1848bi = false;
        }
        this.f1849bj = C3171am.m11080r();
        if (this.f1791ac == 1 || this.f1791ac == 7) {
            if (this.f1843bd != null && this.f1845bf != null && this.f1846bg != null && this.f1847bh != null) {
                if (!this.f1848bi && !this.f1849bj) {
                    this.f1843bd.setVisibility(8);
                    this.f1845bf.setVisibility(0);
                } else if (!this.f1848bi && this.f1849bj) {
                    this.f1843bd.setVisibility(0);
                    this.f1844be.setText(R.string.buddy_contact_sync);
                    this.f1844be.setImageResource(R.drawable.sync_ic_contact);
                    this.f1844be.setContentDescription(getString(R.string.buddy_contact_sync));
                    if (this.f1844be != null) {
                        this.f1844be.setFocusable(true);
                        this.f1844be.setOnClickListener(new ViewOnClickListenerC0580ck(this));
                    }
                    this.f1845bf.setVisibility(8);
                } else if (this.f1848bi && !this.f1849bj) {
                    this.f1843bd.setVisibility(0);
                    this.f1844be.setText(R.string.setting_samsung_account);
                    this.f1844be.setImageResource(R.drawable.sync_ic_account);
                    this.f1844be.setContentDescription(getString(R.string.setting_samsung_account));
                    if (this.f1844be != null) {
                        this.f1844be.setFocusable(true);
                        this.f1844be.setOnClickListener(new ViewOnClickListenerC0582cm(this));
                    }
                    this.f1845bf.setVisibility(8);
                } else if (this.f1848bi && this.f1849bj) {
                    this.f1843bd.setVisibility(8);
                    this.f1845bf.setVisibility(8);
                }
            }
        } else if (this.f1843bd != null && this.f1845bf != null) {
            this.f1843bd.setVisibility(8);
            this.f1845bf.setVisibility(8);
        }
        if (GlobalApplication.m6456e() && this.f1827bN != null && 8 == this.f1846bg.getVisibility() && 8 == this.f1847bh.getVisibility()) {
            this.f1827bN.setVisibility(8);
        }
    }

    @Override // com.sec.chaton.buddy.InterfaceC0532aq
    /* renamed from: a */
    public void mo3424a(C0513c c0513c, View view) {
        if (this.f1791ac == 1 || this.f1791ac == 1000) {
            if (c0513c.m3997x()) {
                if (this.f1892w == 1 || this.f1892w == 2) {
                    HashMap<String, String> mapM3999z = c0513c.m3999z();
                    if (mapM3999z != null && mapM3999z.size() > 0) {
                        Iterator<String> it = mapM3999z.keySet().iterator();
                        while (it.hasNext()) {
                            String strValueOf = String.valueOf(it.next());
                            String str = this.f1873ci ? null : mapM3999z.get(strValueOf);
                            if (m3372d(strValueOf)) {
                                if (((CheckBox) view).isChecked()) {
                                    m3432a(strValueOf, !this.f1738B.m13112d(), str, true, true);
                                    this.f1854bp = c0513c;
                                    ((CheckBox) view).setChecked(!this.f1738B.m13112d());
                                } else {
                                    m3432a(strValueOf, this.f1738B.m13112d(), str, true, true);
                                    ((CheckBox) view).setChecked(this.f1738B.m13112d());
                                }
                            }
                        }
                        if (this.f1830bQ != null) {
                            this.f1830bQ.mo3452a(this.f1738B.m13106a());
                        }
                    }
                    if (((CheckBox) view).isChecked()) {
                        ((CheckBox) view).setChecked(false);
                    } else {
                        ((CheckBox) view).setChecked(true);
                    }
                }
            } else if (this.f1892w == 0) {
                this.f1803ao.m4044d(null);
                if (this.f1791ac == 1000) {
                    if (this.f1785aW) {
                        m3352b(c0513c.m3975b(), c0513c.m3976c());
                        return;
                    } else {
                        m3363c(new String[]{c0513c.m3975b()});
                        return;
                    }
                }
            } else {
                int iM3444i = m3444i();
                m3427a(c0513c.m3975b(), c0513c.m3976c());
                int iM3444i2 = m3444i();
                if (this.f1871cg != -1 && m3444i() + this.f1869ce > this.f1871cg) {
                    this.f1738B.setChildChecked(c0513c.m3975b(), false);
                    C3250y.m11450b("showSelectionReachedMaximumPopup " + this.f1871cg, f1724a);
                    m3283a((CharSequence) getActivity().getString(this.f1872ch, new Object[]{Integer.valueOf(this.f1871cg)}));
                } else if (m3372d(c0513c.m3975b())) {
                    if (((CheckBox) view).isChecked() && iM3444i != iM3444i2) {
                        this.f1738B.setChildChecked(c0513c.m3975b(), true);
                        ((CheckBox) view).setChecked(true);
                    } else {
                        this.f1738B.setChildChecked(c0513c.m3975b(), false);
                        ((CheckBox) view).setChecked(false);
                    }
                }
                if (m3314ac() && this.f1749M.getVisibility() == 0) {
                    this.f1749M.setChecked(false);
                } else {
                    this.f1749M.setChecked(true);
                }
            }
            if (this.f1791ac == 1) {
                if (m3400q() == 1) {
                    m3354b(c0513c.m3997x());
                    if (m3444i() > 0) {
                        if (this.f1843bd != null && this.f1845bf != null) {
                            this.f1843bd.setVisibility(8);
                            this.f1845bf.setVisibility(8);
                        }
                    } else {
                        m3447l();
                    }
                } else if (m3444i() > 0) {
                    getView().findViewById(R.id.layoutChatButtons).setVisibility(0);
                    if (this.f1843bd != null && this.f1845bf != null) {
                        this.f1843bd.setVisibility(8);
                        this.f1845bf.setVisibility(8);
                    }
                } else {
                    getView().findViewById(R.id.layoutChatButtons).setVisibility(8);
                    m3447l();
                }
                if (Build.VERSION.SDK_INT >= 11) {
                    getActivity().invalidateOptionsMenu();
                }
            }
        }
        if (m3444i() > 0) {
            f1733l = true;
            if (GlobalApplication.m6456e() && this.f1791ac == 1) {
                this.f1827bN.setVisibility(0);
                this.f1818bD.setVisibility(0);
                this.f1820bF.setVisibility(0);
                this.f1819bE.setVisibility(8);
            }
        } else {
            f1733l = false;
            if (GlobalApplication.m6456e() && this.f1791ac == 1) {
                this.f1818bD.setVisibility(8);
                this.f1820bF.setVisibility(8);
            }
        }
        if (GlobalApplication.m6456e() && this.f1791ac == 1) {
            if (this.f1843bd.getVisibility() == 0 || this.f1845bf.getVisibility() == 0) {
                this.f1820bF.setVisibility(0);
            } else {
                this.f1820bF.setVisibility(8);
            }
        }
        ((ActionBarFragmentActivity) getActivity()).supportInvalidateOptionsMenu();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0094  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m3354b(boolean r11) {
        /*
            Method dump skipped, instructions count: 479
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyFragment.m3354b(boolean):void");
    }

    /* renamed from: b */
    public static boolean m3357b(String str) {
        return (f1732k == null || f1732k.get(str) == null) ? false : true;
    }

    /* renamed from: af */
    private boolean m3319af() {
        boolean zM55d;
        Exception e;
        try {
            zM55d = this.f1884j.m55d(getActivity());
            try {
                C3250y.m11450b("[ChatONV] isReadyToCall : " + zM55d, f1724a);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                C3250y.m11450b("[ChatONV] isChatONVReadyToCall : " + zM55d, f1724a);
                return zM55d;
            }
        } catch (Exception e3) {
            zM55d = false;
            e = e3;
        }
        C3250y.m11450b("[ChatONV] isChatONVReadyToCall : " + zM55d, f1724a);
        return zM55d;
    }

    /* renamed from: ag */
    private boolean m3321ag() {
        boolean z = false;
        try {
            if (C1954g.m7916a().m7918a(getActivity(), EnumC1955h.ChatONV)) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3250y.m11450b("[ChatONV] isChatONVAvaiable : " + z, f1724a);
        return z;
    }

    /* renamed from: ah */
    private boolean m3324ah() {
        boolean z = false;
        try {
            C0045a c0045a = this.f1884j;
            if (C0045a.m37b(getActivity())) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3250y.m11450b("[ChatONV] isChatONVInstalled : " + z, f1724a);
        return z;
    }

    /* renamed from: ai */
    private void m3325ai() {
        if (C3159aa.m10962a().m10977a("buddy_delete_copied_contacts", (Boolean) false).booleanValue() && C3159aa.m10962a().m10987b("uid")) {
            C3250y.m11450b("migrationBuddyOperation() (delete all contact)", f1724a);
            C1363g.m6080a();
            C3159aa.m10962a().m10983b("buddy_delete_copied_contacts", (Boolean) false);
        }
        if (!C3159aa.m10962a().m10977a("Is migration hanzitopinyin", (Boolean) false).booleanValue()) {
            try {
                C1360d.m6027a(GlobalApplication.m11493l().getContentResolver());
                C3159aa.m10962a().m10983b("Is migration hanzitopinyin", (Boolean) true);
            } catch (OperationApplicationException e) {
                C3250y.m11442a("Operation application occured, hanzitopinyin migration is failed", getClass().getSimpleName());
            } catch (RemoteException e2) {
                C3250y.m11442a("Remote exception occured, hanzitopinyin migration is failed", getClass().getSimpleName());
            }
        }
        if (C3159aa.m10962a().m10977a("buddy_delete_all_chaton_icon_in_contact", (Boolean) true).booleanValue()) {
            C3250y.m11450b("migrationBuddyOperation() delete all chaton icon in contact", f1724a);
            C0425k.m3059b();
            C3159aa.m10962a().m10983b("buddy_delete_all_chaton_icon_in_contact", (Boolean) false);
        }
        if (C3159aa.m10962a().m10977a("buddy_get_all_buddy_mode_instance", (Boolean) false).booleanValue()) {
            C3250y.m11450b("migrationBuddyOperation() execute getallbuddy with mode instance", f1724a);
            new C1330h(null).m5728a(false, HttpResponseCode.f13733OK);
            C3159aa.m10962a().m10983b("buddy_get_all_buddy_mode_instance", (Boolean) false);
        }
        if (C3159aa.m10962a().m10977a("restore_livepartner_user_list", (Boolean) false).booleanValue() && C3250y.f11734b) {
            C3250y.m11450b("migrationBuddyOperation() restore livepartner user list", f1724a);
            new C1330h(null).m5718a(600);
            C3159aa.m10962a().m10983b("restore_livepartner_user_list", (Boolean) false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        ViewOnClickListenerC0544bb viewOnClickListenerC0544bb = null;
        super.onAttach(activity);
        if (this.f1861bw == null) {
            this.f1861bw = new C0592cw(this, viewOnClickListenerC0544bb);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(f1735n);
            activity.registerReceiver(this.f1861bw, intentFilter);
        }
        if (this.f1815bA == null) {
            this.f1815bA = new C0593cx(this, viewOnClickListenerC0544bb);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction(f1736o);
            activity.registerReceiver(this.f1815bA, intentFilter2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        FragmentActivity activity;
        FragmentActivity activity2;
        super.onDetach();
        if (this.f1861bw != null && (activity2 = getActivity()) != null) {
            activity2.unregisterReceiver(this.f1861bw);
        }
        this.f1861bw = null;
        if (this.f1815bA != null && (activity = getActivity()) != null) {
            activity.unregisterReceiver(this.f1815bA);
        }
        this.f1815bA = null;
    }

    /* renamed from: c */
    public boolean m3438c(String str) {
        boolean zEquals;
        Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1445m.f5377a, null, "group_relation_buddy=?", new String[]{str}, null);
        if (cursorQuery == null || cursorQuery.getCount() == 0) {
            zEquals = false;
        } else {
            cursorQuery.moveToFirst();
            zEquals = cursorQuery.getString(cursorQuery.getColumnIndex("group_relation_group")).equals("1");
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return zEquals;
    }

    /* renamed from: c */
    private void m3362c(boolean z) {
        this.f1816bB = z;
    }

    /* renamed from: aj */
    private boolean m3328aj() {
        return this.f1816bB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m3371d(boolean z) {
        this.f1817bC = z;
    }

    /* renamed from: ak */
    private boolean m3330ak() {
        try {
            return getArguments().getBoolean(f1725b);
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: m */
    public void m3448m() {
        if (this.f1803ao != null) {
            this.f1803ao.m4040b(true);
            this.f1803ao.notifyDataSetChanged();
        }
        if (GlobalApplication.m6456e() && this.f1791ac == 1) {
            if (m3444i() > 0) {
                this.f1819bE.setVisibility(0);
                this.f1821bG.setVisibility(0);
            } else {
                this.f1819bE.setVisibility(8);
                if (this.f1827bN.isShown()) {
                    this.f1821bG.setVisibility(0);
                } else {
                    this.f1821bG.setVisibility(8);
                }
            }
            this.f1820bF.setVisibility(8);
            this.f1818bD.setVisibility(8);
            return;
        }
        if (GlobalApplication.m6456e() && this.f1776aN.isShown()) {
            this.f1822bH.setVisibility(8);
            this.f1823bI.setVisibility(0);
        }
        if (GlobalApplication.m6456e() && this.f1779aQ.isShown()) {
            this.f1824bJ.setVisibility(8);
            this.f1825bK.setVisibility(0);
        }
        if (GlobalApplication.m6456e() && this.f1827bN.isShown()) {
            this.f1820bF.setVisibility(8);
            this.f1821bG.setVisibility(0);
        }
    }

    /* renamed from: n */
    public void m3449n() {
        if (this.f1803ao != null) {
            this.f1803ao.m4040b(false);
            this.f1803ao.notifyDataSetChanged();
        }
        if (GlobalApplication.m6456e() && this.f1791ac == 1) {
            if (m3444i() > 0) {
                this.f1818bD.setVisibility(0);
                this.f1820bF.setVisibility(0);
            } else {
                this.f1818bD.setVisibility(8);
                if (this.f1827bN.isShown()) {
                    this.f1820bF.setVisibility(0);
                } else {
                    this.f1820bF.setVisibility(8);
                }
            }
            this.f1821bG.setVisibility(8);
            this.f1819bE.setVisibility(8);
            return;
        }
        if (GlobalApplication.m6456e() && this.f1776aN.isShown()) {
            this.f1822bH.setVisibility(0);
            this.f1823bI.setVisibility(8);
        }
        if (GlobalApplication.m6456e() && this.f1779aQ.isShown()) {
            this.f1824bJ.setVisibility(0);
            this.f1825bK.setVisibility(8);
        }
        if (GlobalApplication.m6456e() && this.f1827bN.isShown()) {
            this.f1820bF.setVisibility(0);
            this.f1821bG.setVisibility(8);
        }
    }

    /* renamed from: o */
    public void m3450o() {
        this.f1806ar = true;
        this.f1738B.setFastScrollEnabled(false);
        this.f1804ap.m4051a(21);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: al */
    public void m3332al() {
        if (!GlobalApplication.m6456e() && getActivity() != null && !((ActionBarFragmentActivity) getActivity()).m11543k().mo11594d()) {
            ((ActionBarFragmentActivity) getActivity()).m11543k().mo11595e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: am */
    public void m3334am() {
        if (!GlobalApplication.m6456e() && getActivity() != null && ((ActionBarFragmentActivity) getActivity()).m11543k().mo11594d()) {
            ((ActionBarFragmentActivity) getActivity()).m11543k().mo11597f();
        }
    }

    /* renamed from: a */
    public int m3420a(float f) {
        return (int) ((CommonApplication.m11493l().getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
