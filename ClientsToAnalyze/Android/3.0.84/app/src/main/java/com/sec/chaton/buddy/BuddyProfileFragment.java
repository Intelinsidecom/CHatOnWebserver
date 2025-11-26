package com.sec.chaton.buddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.sso.p006a.C0045a;
import com.sec.chaton.R;
import com.sec.chaton.account.C0423i;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p018b.ContextMenuC0453a;
import com.sec.chaton.p025d.C1328f;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p025d.C1331i;
import com.sec.chaton.p025d.C1336n;
import com.sec.chaton.p025d.C1344v;
import com.sec.chaton.p025d.C1345w;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.p027e.C1445m;
import com.sec.chaton.p027e.p028a.C1352aa;
import com.sec.chaton.p027e.p028a.C1365i;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.chaton.p035io.entry.GetPostONList;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.plugin.C1948a;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.poston.C2013d;
import com.sec.chaton.poston.C2020k;
import com.sec.chaton.poston.InterfaceC2019j;
import com.sec.chaton.poston.PostONDetailActivity;
import com.sec.chaton.poston.PostONDetailFragment;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3231f;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.common.p069e.C3326c;
import com.sec.common.p069e.InterfaceC3329f;
import com.sec.common.util.log.collector.C3358h;
import com.sec.widget.C3641ai;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class BuddyProfileFragment extends Fragment implements InterfaceC2019j, InterfaceC3329f {

    /* renamed from: a */
    public static final String f2014a = BuddyProfileFragment.class.getSimpleName();

    /* renamed from: aa */
    private static String f2015aa = "";

    /* renamed from: D */
    private ImageView f2019D;

    /* renamed from: E */
    private ImageView f2020E;

    /* renamed from: F */
    private ImageView f2021F;

    /* renamed from: G */
    private ImageView f2022G;

    /* renamed from: H */
    private ImageView f2023H;

    /* renamed from: I */
    private ImageView f2024I;

    /* renamed from: J */
    private ImageView f2025J;

    /* renamed from: K */
    private ImageView f2026K;

    /* renamed from: L */
    private C0699fj f2027L;

    /* renamed from: M */
    private C0699fj f2028M;

    /* renamed from: N */
    private C0699fj f2029N;

    /* renamed from: O */
    private C0699fj f2030O;

    /* renamed from: P */
    private ImageButton f2031P;

    /* renamed from: Q */
    private TextView f2032Q;

    /* renamed from: R */
    private TextView f2033R;

    /* renamed from: S */
    private ImageButton f2034S;

    /* renamed from: T */
    private ImageButton f2035T;

    /* renamed from: V */
    private String f2037V;

    /* renamed from: W */
    private C2013d f2038W;

    /* renamed from: X */
    private ListView f2039X;

    /* renamed from: Z */
    private C1344v f2041Z;

    /* renamed from: aA */
    private String f2042aA;

    /* renamed from: aB */
    private String f2043aB;

    /* renamed from: aC */
    private boolean f2044aC;

    /* renamed from: aD */
    private C1345w f2045aD;

    /* renamed from: aL */
    private boolean f2053aL;

    /* renamed from: aN */
    private int f2055aN;

    /* renamed from: aO */
    private int f2056aO;

    /* renamed from: aP */
    private C0045a f2057aP;

    /* renamed from: aQ */
    private Activity f2058aQ;

    /* renamed from: ab */
    private View f2068ab;

    /* renamed from: ac */
    private View f2069ac;

    /* renamed from: ad */
    private ImageView f2070ad;

    /* renamed from: ae */
    private View f2071ae;

    /* renamed from: af */
    private ImageButton f2072af;

    /* renamed from: ag */
    private ImageButton f2073ag;

    /* renamed from: ah */
    private ImageButton f2074ah;

    /* renamed from: ai */
    private ImageButton f2075ai;

    /* renamed from: aj */
    private ImageButton f2076aj;

    /* renamed from: ak */
    private ImageButton f2077ak;

    /* renamed from: al */
    private TextView f2078al;

    /* renamed from: am */
    private TextView f2079am;

    /* renamed from: an */
    private TextView f2080an;

    /* renamed from: ao */
    private TextView f2081ao;

    /* renamed from: ap */
    private LinearLayout f2082ap;

    /* renamed from: aq */
    private TextView f2083aq;

    /* renamed from: ar */
    private LinearLayout f2084ar;

    /* renamed from: as */
    private InputMethodManager f2085as;

    /* renamed from: at */
    private ImageView f2086at;

    /* renamed from: av */
    private C1331i f2088av;

    /* renamed from: aw */
    private String f2089aw;

    /* renamed from: ax */
    private String f2090ax;

    /* renamed from: ay */
    private String f2091ay;

    /* renamed from: az */
    private String f2092az;

    /* renamed from: ba */
    private String f2094ba;

    /* renamed from: j */
    private boolean f2107j;

    /* renamed from: l */
    private C1377u f2109l;

    /* renamed from: m */
    private Menu f2110m;

    /* renamed from: p */
    private Toast f2113p;

    /* renamed from: q */
    private BuddyProfileFragment f2114q;

    /* renamed from: r */
    private BuddyProfileFragment f2115r;

    /* renamed from: s */
    private C0513c f2116s;

    /* renamed from: t */
    private String f2117t;

    /* renamed from: u */
    private String f2118u;

    /* renamed from: v */
    private String f2119v;

    /* renamed from: w */
    private boolean f2120w;

    /* renamed from: x */
    private boolean f2121x;

    /* renamed from: k */
    private int f2108k = 2;

    /* renamed from: n */
    private MenuItem f2111n = null;

    /* renamed from: o */
    private MenuItem f2112o = null;

    /* renamed from: y */
    private boolean f2122y = false;

    /* renamed from: z */
    private boolean f2123z = false;

    /* renamed from: A */
    private boolean f2016A = false;

    /* renamed from: B */
    private boolean f2017B = true;

    /* renamed from: C */
    private int f2018C = 0;

    /* renamed from: U */
    private ProgressDialog f2036U = null;

    /* renamed from: Y */
    private ArrayList<C2020k> f2040Y = new ArrayList<>();

    /* renamed from: au */
    private boolean f2087au = false;

    /* renamed from: aE */
    private Bitmap f2046aE = null;

    /* renamed from: aF */
    private C3326c f2047aF = null;

    /* renamed from: aG */
    private String f2048aG = "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3159aa.m10962a().m10979a("imei", "");

    /* renamed from: aH */
    private String f2049aH = "&size=800";

    /* renamed from: aI */
    private String f2050aI = "&size=100";

    /* renamed from: aJ */
    private boolean f2051aJ = false;

    /* renamed from: aK */
    private ArrayList<String> f2052aK = new ArrayList<>();

    /* renamed from: aM */
    private boolean f2054aM = false;

    /* renamed from: b */
    boolean f2093b = false;

    /* renamed from: aR */
    private LinearLayout f2059aR = null;

    /* renamed from: aS */
    private LinearLayout f2060aS = null;

    /* renamed from: aT */
    private LinearLayout f2061aT = null;

    /* renamed from: aU */
    private LinearLayout f2062aU = null;

    /* renamed from: aV */
    private LinearLayout f2063aV = null;

    /* renamed from: aW */
    private TextView f2064aW = null;

    /* renamed from: aX */
    private ImageView f2065aX = null;

    /* renamed from: aY */
    private ImageView f2066aY = null;

    /* renamed from: aZ */
    private String f2067aZ = C3223ck.m11329c() + "/flag/";

    /* renamed from: bb */
    private boolean f2095bb = false;

    /* renamed from: bc */
    private boolean f2096bc = false;

    /* renamed from: bd */
    private ImageView f2097bd = null;

    /* renamed from: be */
    private Handler f2098be = new HandlerC0685ew(this);

    /* renamed from: c */
    View.OnClickListener f2100c = new ViewOnClickListenerC0686ex(this);

    /* renamed from: d */
    Handler f2101d = new HandlerC0687ey(this);

    /* renamed from: e */
    InterfaceC1378v f2102e = new C0690fa(this);

    /* renamed from: f */
    AbsListView.OnScrollListener f2103f = new C0694fe(this);

    /* renamed from: bf */
    private Handler f2099bf = new HandlerC0695ff(this);

    /* renamed from: g */
    InterfaceC1413d f2104g = new C0681es(this);

    /* renamed from: h */
    ContentObserver f2105h = new C0682et(this, new Handler());

    /* renamed from: i */
    ContentObserver f2106i = new C0683eu(this, new Handler());

    /* renamed from: ag */
    static /* synthetic */ int m3626ag(BuddyProfileFragment buddyProfileFragment) {
        int i = buddyProfileFragment.f2056aO;
        buddyProfileFragment.f2056aO = i + 1;
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f2058aQ = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f2058aQ = null;
    }

    /* renamed from: e */
    private boolean m3658e(String str) {
        if (str.length() >= 19 && str.startsWith("10")) {
            if (!C3250y.f11734b) {
                return false;
            }
            C3250y.m11450b("chaton id : " + str, f2014a);
            return false;
        }
        if (str.startsWith("0")) {
            if (!C3250y.f11734b) {
                return false;
            }
            C3250y.m11450b("pin number : " + str, f2014a);
            return false;
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("phone number: " + str, f2014a);
        }
        return true;
    }

    /* renamed from: e */
    private void m3655e() {
        this.f2084ar.setVisibility(8);
        this.f2082ap.setVisibility(0);
        this.f2044aC = true;
        this.f2041Z.m5913a(this.f2117t);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f2108k == 1) {
            if (this.f2107j) {
                this.f2107j = false;
            } else {
                m3655e();
            }
        }
        m3686n();
        if (this.f2122y && this.f2119v != null) {
            this.f2109l.startQuery(6, null, Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(this.f2119v)), null, null, null, null);
            this.f2122y = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f2099bf != null) {
            this.f2099bf.removeCallbacksAndMessages(null);
            this.f2099bf = null;
        }
        if (this.f2088av != null) {
            this.f2088av.m5764c();
            this.f2088av.m5766e();
            this.f2088av = null;
        }
        if (this.f2086at != null) {
            this.f2086at.setImageBitmap(null);
            this.f2086at = null;
        }
        if (this.f2047aF != null) {
            this.f2047aF.m11735a((InterfaceC3329f) null);
            this.f2047aF.m11731a();
        }
        if (this.f2019D != null) {
            this.f2019D.setImageBitmap(null);
            this.f2019D = null;
        }
        if (this.f2020E != null) {
            this.f2020E.setImageBitmap(null);
            this.f2020E = null;
        }
        if (this.f2021F != null) {
            this.f2021F.setImageBitmap(null);
            this.f2021F = null;
        }
        if (this.f2022G != null) {
            this.f2022G.setImageBitmap(null);
            this.f2022G = null;
        }
        if (this.f2031P != null) {
            this.f2031P.setImageBitmap(null);
            this.f2031P = null;
        }
        if (this.f2045aD != null) {
            this.f2045aD.m5941f();
            this.f2045aD.m5932b();
            this.f2045aD = null;
        }
        if (GlobalApplication.m6456e()) {
            if (this.f2105h != null) {
                this.f2058aQ.getContentResolver().unregisterContentObserver(this.f2105h);
            }
            if (this.f2106i != null) {
                this.f2058aQ.getContentResolver().unregisterContentObserver(this.f2106i);
            }
        }
        super.onDestroy();
        m3685m();
        this.f2114q = null;
        this.f2115r = null;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f2110m = menu;
        if (!GlobalApplication.m6456e()) {
            menuInflater.inflate(R.menu.buddy_page_menu, menu);
            this.f2111n = menu.findItem(R.id.buddypage_menu_favoriate);
            this.f2112o = menu.findItem(R.id.buddypage_menu_favoriate_off);
            m3718a(this.f2121x);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        C3250y.m11458g("onPrepareOptionsMenu()", f2014a);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case R.id.buddypage_menu_favoriate /* 2131166589 */:
                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11846a("00040002");
                }
                if (this.f2121x) {
                    this.f2109l.startDelete(2, this.f2116s, C1445m.f5377a, "group_relation_group = 1 AND group_relation_buddy = ? ", new String[]{this.f2117t});
                    m3718a(this.f2121x);
                    this.f2121x = false;
                }
                return true;
            case R.id.buddypage_menu_favoriate_off /* 2131166590 */:
                if (!this.f2121x) {
                    this.f2109l.startQuery(4, this.f2116s, C1445m.f5377a, null, "group_relation_group = 1 ", null, null);
                    m3718a(this.f2121x);
                    this.f2121x = true;
                }
                return true;
            default:
                return true;
        }
    }

    /* renamed from: a */
    public void m3718a(boolean z) {
        if (this.f2111n != null && this.f2112o != null) {
            if (z) {
                this.f2111n.setVisible(true);
                this.f2112o.setVisible(false);
            } else {
                this.f2111n.setVisible(false);
                this.f2112o.setVisible(true);
            }
        }
        if (GlobalApplication.m6456e() && this.f2097bd != null) {
            if (z) {
                this.f2097bd.setBackgroundResource(R.drawable.actionbar_ic_favorite_01);
            } else {
                this.f2097bd.setBackgroundResource(R.drawable.actionbar_ic_favorite_02);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C3250y.m11458g("onCreateView()", f2014a);
        setHasOptionsMenu(true);
        this.f2058aQ.setTitle(getText(R.string.buddy_page_title));
        this.f2068ab = layoutInflater.inflate(R.layout.layout_buddypage_main_header, (ViewGroup) null);
        this.f2069ac = layoutInflater.inflate(R.layout.poston_refresh_footer, (ViewGroup) null);
        this.f2071ae = layoutInflater.inflate(R.layout.layout_buddypage_main_poston_list, viewGroup, false);
        this.f2047aF = new C3326c();
        m3661f();
        this.f2109l.startQuery(3, null, C1441i.m6310c(), null, "buddy_no = ? ", new String[]{this.f2117t}, null);
        return this.f2071ae;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2114q = this;
        this.f2115r = this;
        this.f2109l = new C1377u(this.f2058aQ.getContentResolver(), this.f2102e);
        this.f2113p = C3641ai.m13211a(this.f2058aQ, (CharSequence) null, 0);
        if (getArguments() != null) {
            this.f2117t = getArguments().getString("PROFILE_BUDDY_NO");
            this.f2118u = getArguments().getString("PROFILE_BUDDY_NAME");
            this.f2051aJ = getArguments().getBoolean("PROFILE_BUDDY_SUGGESTION");
            this.f2123z = getArguments().getBoolean("PROFILE_BUDDY_PROFILE_LOAD_DONE", false);
            this.f2016A = getArguments().getBoolean("PROFILE_BUDDY_PROFILE_IMAGE_LOAD_DONE", false);
            this.f2018C = getArguments().getInt("PROFILE_BUDDY_PROFILE_IMAGE_COUNT", 0);
            this.f2087au = getArguments().getBoolean("PROFILE_BUDDY_FROM_BUDDYDIALOG", false);
        } else if (this.f2058aQ.getIntent() != null) {
            this.f2117t = this.f2058aQ.getIntent().getExtras().getString("PROFILE_BUDDY_NO");
            this.f2118u = this.f2058aQ.getIntent().getExtras().getString("PROFILE_BUDDY_NAME");
            this.f2051aJ = this.f2058aQ.getIntent().getExtras().getBoolean("PROFILE_BUDDY_SUGGESTION");
            this.f2123z = this.f2058aQ.getIntent().getExtras().getBoolean("PROFILE_BUDDY_PROFILE_LOAD_DONE", false);
            this.f2016A = this.f2058aQ.getIntent().getExtras().getBoolean("PROFILE_BUDDY_PROFILE_IMAGE_LOAD_DONE", false);
            this.f2087au = this.f2058aQ.getIntent().getExtras().getBoolean("PROFILE_BUDDY_FROM_BUDDYDIALOG", false);
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("*********** BUDDY NO : " + this.f2117t, f2014a);
        }
        if (!TextUtils.isEmpty(this.f2118u) && C3250y.f11734b) {
            C3250y.m11450b("*********** BUDDY NAME : " + this.f2118u, f2014a);
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("*********** BUDDY SUGGESTION : " + this.f2051aJ, f2014a);
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("*********** BUDDY FROM BUDDY DIALOG : " + this.f2087au, f2014a);
        }
        if (this.f2117t == null) {
            this.f2058aQ.finish();
        }
        if (this.f2118u == null) {
            this.f2118u = "";
        }
        if (!this.f2087au) {
            this.f2088av = new C1331i(this.f2101d);
            this.f2088av.m5758a(this.f2117t);
        }
        if (GlobalApplication.m6456e()) {
            this.f2058aQ.getContentResolver().registerContentObserver(C1441i.f5369a, true, this.f2105h);
            this.f2058aQ.getContentResolver().registerContentObserver(C1445m.f5377a, true, this.f2106i);
        }
        this.f2085as = (InputMethodManager) this.f2058aQ.getSystemService("input_method");
    }

    /* renamed from: f */
    private void m3661f() {
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C3358h.m11842a().m11846a("00040001");
        }
        this.f2057aP = new C0045a();
        f2015aa = C3159aa.m10962a().m10979a("chaton_id", "");
        this.f2041Z = new C1344v(this.f2101d);
        this.f2082ap = (LinearLayout) this.f2069ac.findViewById(R.id.footer_progress);
        this.f2083aq = (TextView) this.f2069ac.findViewById(R.id.footer_content);
        this.f2084ar = (LinearLayout) this.f2069ac.findViewById(R.id.footer_content_layout);
        this.f2084ar.setVisibility(8);
        this.f2072af = (ImageButton) this.f2068ab.findViewById(R.id.buddypage_main_poston_write);
        this.f2072af.setOnClickListener(this.f2100c);
        this.f2092az = "";
        this.f2042aA = "";
        this.f2043aB = null;
        this.f2107j = false;
        this.f2044aC = true;
        this.f2036U = (ProgressDialog) new C3263j(this.f2058aQ).m11487a(R.string.buddy_list_progress_dialog_message);
        this.f2091ay = CommonApplication.m11493l().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        this.f2090ax = CommonApplication.m11493l().getCacheDir() + "/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3639b(int i) {
        this.f2108k = i;
        if (i == 1) {
            this.f2045aD = new C1345w(this.f2099bf);
            this.f2047aF.m11735a(this);
            this.f2019D = (ImageView) this.f2068ab.findViewById(R.id.profile_image);
            this.f2023H = (ImageView) this.f2068ab.findViewById(R.id.profile_image_loading);
            this.f2020E = (ImageView) this.f2068ab.findViewById(R.id.profile_image_1);
            this.f2024I = (ImageView) this.f2068ab.findViewById(R.id.profile_image_1_loading);
            this.f2021F = (ImageView) this.f2068ab.findViewById(R.id.profile_image_2);
            this.f2025J = (ImageView) this.f2068ab.findViewById(R.id.profile_image_2_loading);
            this.f2022G = (ImageView) this.f2068ab.findViewById(R.id.profile_image_3);
            this.f2026K = (ImageView) this.f2068ab.findViewById(R.id.profile_image_3_loading);
            this.f2031P = (ImageButton) this.f2068ab.findViewById(R.id.buddy_profile_more_icon);
            this.f2032Q = (TextView) this.f2068ab.findViewById(R.id.profile_name);
            this.f2033R = (TextView) this.f2068ab.findViewById(R.id.profile_status_message);
            this.f2070ad = (ImageView) this.f2068ab.findViewById(R.id.buddy_profile_status_image);
            if (this.f2116s.m3968E() == 1) {
                this.f2070ad.setBackgroundResource(R.drawable.buddies_webonly);
                this.f2070ad.setVisibility(0);
            } else if (getActivity() != null && C1948a.m7903a(getActivity()) && BuddyFragment.m3357b(this.f2117t)) {
                this.f2070ad.setBackgroundResource(R.drawable.buddies_videocall);
                this.f2070ad.setVisibility(0);
            }
            this.f2034S = (ImageButton) this.f2068ab.findViewById(R.id.btn_edit_buddyname);
            this.f2034S.setOnClickListener(this.f2100c);
            this.f2035T = (ImageButton) this.f2068ab.findViewById(R.id.btn_buddyprofile_info);
            this.f2035T.setOnClickListener(this.f2100c);
            if (GlobalApplication.m6456e()) {
                this.f2097bd = (ImageButton) this.f2068ab.findViewById(R.id.btn_fav_buddyname);
                if (this.f2097bd != null) {
                    this.f2097bd.setOnClickListener(this.f2100c);
                }
            }
            this.f2027L = new C0699fj(this.f2019D);
            this.f2028M = new C0699fj(this.f2020E);
            this.f2029N = new C0699fj(this.f2021F);
            this.f2030O = new C0699fj(this.f2022G);
            if (this.f2121x) {
                m3718a(true);
            } else {
                m3718a(false);
            }
            try {
                C3231f.m11361a(this.f2058aQ).m11379a(this.f2027L, this.f2028M, this.f2029N, this.f2030O, this.f2117t);
            } catch (Exception e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, getClass().getSimpleName());
                }
            } catch (OutOfMemoryError e2) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e2, getClass().getSimpleName());
                }
            }
            m3723c();
            this.f2032Q.setText(this.f2116s.m3976c());
            if (GlobalApplication.m6456e()) {
                this.f2032Q.setSelected(true);
            }
            this.f2032Q.setContentDescription(this.f2116s.m3976c());
            this.f2032Q.setOnTouchListener(new ViewOnTouchListenerC0680er(this));
            if (!TextUtils.isEmpty(this.f2116s.m3977d())) {
                this.f2033R.setText(this.f2116s.m3977d());
                if (GlobalApplication.m6456e()) {
                    this.f2033R.setSelected(true);
                }
                this.f2033R.setOnTouchListener(new ViewOnTouchListenerC0684ev(this));
            }
            this.f2039X = (ListView) this.f2071ae.findViewById(R.id.profile_poston_list);
            this.f2086at = (ImageView) this.f2071ae.findViewById(R.id.coverstory_bg);
            m3613a(this.f2086at);
            registerForContextMenu(this.f2039X);
            this.f2044aC = true;
            this.f2041Z.m5913a(this.f2117t);
            this.f2038W = new C2013d(this.f2039X, this.f2058aQ, this.f2040Y, R.layout.list_item_common_9, this.f2117t);
            this.f2038W.m8044a(this);
            this.f2039X.addHeaderView(this.f2068ab, null, false);
            this.f2039X.setFocusable(false);
            this.f2039X.setFocusableInTouchMode(false);
            this.f2039X.setItemsCanFocus(true);
            this.f2039X.addFooterView(this.f2069ac, null, false);
            this.f2039X.setAdapter((ListAdapter) this.f2038W);
            this.f2039X.setScrollbarFadingEnabled(true);
            this.f2039X.setOnScrollListener(this.f2103f);
            this.f2082ap.setVisibility(0);
            C3250y.m11458g("mProfileImageHistoryDone : " + this.f2016A, f2014a);
            C3250y.m11458g("mProfileAllDone : " + this.f2123z, f2014a);
            if (!this.f2016A) {
                this.f2045aD.m5934b(this.f2117t, "160");
            }
            if (!this.f2123z) {
                this.f2045aD.m5938d(this.f2117t);
            }
            int iM6733a = C1594v.m6733a(this.f2058aQ);
            if (-3 == iM6733a || -2 == iM6733a) {
                C3641ai.m13210a(this.f2058aQ, R.string.popup_no_network_connection, 0).show();
            }
            if (GlobalApplication.m6456e()) {
                this.f2078al = (TextView) this.f2068ab.findViewById(R.id.tv_btn_call);
                this.f2079am = (TextView) this.f2068ab.findViewById(R.id.tv_btn_phone);
                this.f2080an = (TextView) this.f2068ab.findViewById(R.id.tv_btn_voicecall);
                this.f2081ao = (TextView) this.f2068ab.findViewById(R.id.tv_btn_videocall);
                this.f2073ag = (ImageButton) this.f2068ab.findViewById(R.id.btn_start_chat);
                if (this.f2073ag != null) {
                    this.f2073ag.setOnClickListener(this.f2100c);
                }
                this.f2074ah = (ImageButton) this.f2068ab.findViewById(R.id.btn_call);
                if (this.f2074ah != null) {
                    this.f2074ah.setOnClickListener(this.f2100c);
                    this.f2078al.setVisibility(0);
                }
                this.f2075ai = (ImageButton) this.f2068ab.findViewById(R.id.btn_phone);
                if (this.f2075ai != null) {
                    this.f2075ai.setOnClickListener(this.f2100c);
                    this.f2079am.setVisibility(0);
                }
                this.f2076aj = (ImageButton) this.f2068ab.findViewById(R.id.btn_voicecall);
                if (this.f2076aj != null) {
                    this.f2076aj.setOnClickListener(this.f2100c);
                    this.f2076aj.setVisibility(8);
                    this.f2080an.setVisibility(8);
                }
                this.f2077ak = (ImageButton) this.f2068ab.findViewById(R.id.btn_videocall);
                if (this.f2077ak != null) {
                    this.f2077ak.setOnClickListener(this.f2100c);
                    this.f2077ak.setVisibility(8);
                    this.f2081ao.setVisibility(8);
                }
                m3701u();
            }
            if (this.f2016A && this.f2018C > 4) {
                this.f2031P.setVisibility(0);
                return;
            }
            return;
        }
        if (i == 2) {
            this.f2047aF = new C3326c();
            this.f2047aF.m11735a(this);
            View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.layout_unknown_buddy, (ViewGroup) null, false);
            getActivity().setContentView(viewInflate);
            this.f2019D = (ImageView) viewInflate.findViewById(R.id.buddy_cprofile_popup_image);
            this.f2032Q = (TextView) viewInflate.findViewById(R.id.buddy_profile_popup_name);
            this.f2065aX = (ImageView) viewInflate.findViewById(R.id.buddy_cprofile_popup_unauthenticated_image);
            this.f2066aY = (ImageView) viewInflate.findViewById(R.id.buddy_cprofile_popup_flag_image);
            if (TextUtils.isEmpty(this.f2118u)) {
                this.f2032Q.setText(getString(R.string.unknown));
            } else {
                this.f2032Q.setText(this.f2118u);
            }
            this.f2064aW = (TextView) viewInflate.findViewById(R.id.buddy_profile_popup_guidetext_view);
            this.f2059aR = (LinearLayout) viewInflate.findViewById(R.id.buddy_profile_popup_button_addbuddy);
            this.f2060aS = (LinearLayout) viewInflate.findViewById(R.id.buddy_profile_popup_alarm);
            this.f2061aT = (LinearLayout) viewInflate.findViewById(R.id.buddy_profile_popup_button_block);
            this.f2062aU = (LinearLayout) viewInflate.findViewById(R.id.buddy_profile_popup_button_ignore);
            this.f2063aV = (LinearLayout) viewInflate.findViewById(R.id.buddy_profile_popup_button_unblock);
            this.f2059aR.setOnClickListener(this.f2100c);
            this.f2060aS.setOnClickListener(this.f2100c);
            this.f2061aT.setOnClickListener(this.f2100c);
            this.f2062aU.setOnClickListener(this.f2100c);
            this.f2063aV.setOnClickListener(this.f2100c);
            C3205bt.m11182a(getActivity()).m11210a(this.f2019D, this.f2117t);
            new C1330h(this.f2098be).m5744e(this.f2117t, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m3665g() {
        m3683l();
        new C1328f(this.f2101d).m5705a(this.f2117t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public boolean m3663f(String str) {
        return new File(this.f2067aZ).exists() && new File(this.f2067aZ, new StringBuilder().append(str).append(".png").toString()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m3667g(String str) {
        Bitmap bitmapM10997a;
        File file = new File(this.f2067aZ, str + ".png");
        if (file.exists()) {
            try {
                if (file.length() > 0 && (bitmapM10997a = C3162ad.m10997a(getActivity(), Uri.fromFile(file))) != null) {
                    this.f2066aY.setVisibility(0);
                    this.f2066aY.setImageBitmap(bitmapM10997a);
                }
            } catch (Exception e) {
                C3250y.m11443a(e, f2014a);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m3671h(String str) {
        new C1330h(this.f2101d).m5756h(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public boolean m3672h() {
        int iM6733a = C1594v.m6733a(this.f2058aQ.getApplicationContext());
        if (-3 != iM6733a && -2 != iM6733a) {
            return true;
        }
        C3641ai.m13210a(this.f2058aQ.getApplicationContext(), R.string.popup_no_network_connection, 0).show();
        return false;
    }

    /* renamed from: a */
    public boolean m3719a() {
        C3250y.m11450b("Buddy didn't set Coverstory ", getClass().getSimpleName());
        String strM6090a = C1365i.m6090a();
        if (strM6090a != null) {
            if (!BuddyDialog.m4123a(strM6090a, this.f2117t, CommonApplication.m11493l().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/", CommonApplication.m11493l().getCacheDir() + "/" + this.f2117t + "/coverstory/", this.f2086at)) {
                this.f2089aw = strM6090a;
                this.f2088av.m5760a(strM6090a, Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
            }
            return true;
        }
        C3250y.m11450b(" Random ERROR !!", getClass().getSimpleName());
        this.f2088av.m5763b(Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b6  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m3721b() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyProfileFragment.m3721b():void");
    }

    /* renamed from: a */
    void m3714a(C0267d c0267d) throws Throwable {
        if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
            GetPostONList getPostONList = (GetPostONList) c0267d.m1354e();
            if (getPostONList.postonlist.size() > 0) {
                this.f2092az = getPostONList.postonlist.get(0).hasmore;
                this.f2042aA = getPostONList.postonlist.get(0).endtime;
                this.f2043aB = getPostONList.postonlist.get(0).isblind;
            }
            m3721b();
        } else {
            m3685m();
            if (this.f2082ap != null) {
                this.f2082ap.setVisibility(8);
            }
            if (this.f2043aB != null && this.f2043aB.equals("true")) {
                this.f2040Y.clear();
                if (this.f2038W != null) {
                    this.f2038W.notifyDataSetChanged();
                }
                if (this.f2118u == null || this.f2118u.length() == 0) {
                    if (C3250y.f11737e) {
                        C3250y.m11442a("Buddy name is null", f2014a);
                    }
                    this.f2118u = getString(R.string.unknown);
                }
                this.f2083aq.setText(String.format(getResources().getString(R.string.poston_not_use), this.f2118u));
                this.f2084ar.setVisibility(0);
                this.f2072af.setVisibility(8);
            } else if (this.f2043aB != null && this.f2043aB.equals("false")) {
                this.f2084ar.setVisibility(8);
            } else if (this.f2043aB == null) {
                this.f2083aq.setText(String.format(getResources().getString(R.string.poston_not_posted), new Object[0]));
                this.f2084ar.setVisibility(0);
            }
            if (this.f2038W != null) {
                this.f2038W.notifyDataSetChanged();
            }
        }
        this.f2044aC = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public boolean m3676i() {
        if (this.f2117t.length() < 19 || !this.f2117t.startsWith("10") || TextUtils.isEmpty(this.f2116s.m3979f())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public String m3674i(String str) {
        return str.replaceAll("\\D+", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m3644b(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (C3250y.f11734b) {
            C3250y.m11450b("[isMatchNumber] matching for original Number : " + ((String) null), f2014a);
        }
        if (length > 8 && length2 > 8) {
            String strSubstring = str.substring(length - 8);
            String strSubstring2 = str2.substring(length2 - 8);
            C3250y.m11450b("[isMatchNumber] matching for contact Number : " + strSubstring2, f2014a);
            if (strSubstring.equals(strSubstring2)) {
                C3250y.m11450b("[isMatchNumber] found match number : " + str2, f2014a);
                return true;
            }
            C3250y.m11450b("[isMatchNumber] phone number not matched", f2014a);
            return false;
        }
        C3250y.m11450b("[isMatchNumber] phone number length is less than 8", f2014a);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m3677j() {
        if (GlobalApplication.m6456e()) {
            Intent intent = new Intent();
            intent.setAction(BuddyFragment.f1736o);
            getActivity().sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m3681k() {
        C3641ai.m13211a(this.f2058aQ, getResources().getString(R.string.toast_network_unable), 0).show();
        this.f2058aQ.finish();
    }

    @Override // com.sec.chaton.poston.InterfaceC2019j
    /* renamed from: a */
    public void mo3715a(C2020k c2020k) {
        if (!C3197bl.m11159a()) {
            Intent intent = new Intent(getActivity(), (Class<?>) PostONDetailActivity.class);
            intent.putExtra(PostONDetailFragment.f7486a, c2020k.m8047b());
            intent.putExtra(PostONDetailFragment.f7488b, c2020k.m8048c());
            intent.putExtra(PostONDetailFragment.f7489c, c2020k.m8049d());
            intent.putExtra(PostONDetailFragment.f7492f, c2020k.m8050e());
            intent.putExtra(PostONDetailFragment.f7490d, c2020k.m8051f());
            intent.putExtra(PostONDetailFragment.f7491e, C2013d.m8038a(Long.parseLong(c2020k.m8051f())));
            intent.putExtra(PostONDetailFragment.f7493g, c2020k.m8056k());
            intent.putExtra(PostONDetailFragment.f7500n, "BUDDY_PAGE");
            intent.putExtra(PostONDetailFragment.f7494h, c2020k.m8045a());
            intent.putExtra(PostONDetailFragment.f7497k, c2020k.m8053h());
            if (!c2020k.m8055j().isEmpty()) {
                Iterator<C1352aa> it = c2020k.m8055j().iterator();
                while (it.hasNext()) {
                    C1352aa next = it.next();
                    if (next.m5957a().equals(C2013d.f7737d)) {
                        if (C3250y.f11734b) {
                            C3250y.m11450b("getMultimediaDownload has geo tag, content.getUrl() = " + next.m5959b(), f2014a);
                        }
                        intent.putExtra(PostONDetailFragment.f7498l, next.m5959b());
                    } else {
                        if (C3250y.f11734b) {
                            C3250y.m11450b("getMultimediaDownload has Multimedia, content.getUrl() = " + next.m5959b() + " / content.getMetaType() = " + next.m5957a(), f2014a);
                        }
                        intent.putExtra(PostONDetailFragment.f7495i, next.m5959b());
                        intent.putExtra(PostONDetailFragment.f7496j, next.m5957a());
                    }
                }
            }
            if (getActivity() instanceof Activity) {
                intent.setFlags(67108864);
            } else {
                intent.setFlags(335544320);
            }
            startActivityForResult(intent, 10);
        }
    }

    @Override // com.sec.chaton.poston.InterfaceC2019j
    /* renamed from: a */
    public void mo3717a(String str, String str2) {
        if (!C3197bl.m11159a()) {
            if (GlobalApplication.m6456e()) {
                Intent intent = new Intent(getActivity(), (Class<?>) BuddyProfileActivity.class);
                intent.putExtra("PROFILE_BUDDY_NO", str);
                intent.putExtra("PROFILE_BUDDY_NAME", str2);
                intent.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
                startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(getActivity(), (Class<?>) BuddyDialog.class);
            intent2.putExtra("BUDDY_DIALOG_BUDDY_NO", str);
            intent2.putExtra("BUDDY_DIALOG_BUDDY_NAME", str2);
            if (getActivity() instanceof Activity) {
                intent2.setFlags(67108864);
            } else {
                intent2.setFlags(335544320);
            }
            startActivity(intent2);
        }
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        C2020k c2020k;
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        ContextMenuC0453a contextMenuC0453a = new ContextMenuC0453a(this.f2058aQ, contextMenu);
        if ((contextMenuInfo instanceof AdapterView.AdapterContextMenuInfo) && (c2020k = (C2020k) this.f2039X.getAdapter().getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position)) != null) {
            String strM8048c = c2020k.m8048c();
            c2020k.m8051f();
            String strM8045a = c2020k.m8045a();
            if (strM8048c.equals(f2015aa)) {
                contextMenuC0453a.setHeaderTitle(R.string.setting_interaction_me);
                contextMenuC0453a.add(0, 2000, 1, R.string.memo_delete_context_menu).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0691fb(this, strM8045a));
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        if (i == 9 && i2 == -1) {
            C3250y.m11456e("Write PostON from Write page Success", f2014a);
            this.f2044aC = true;
            this.f2107j = true;
            this.f2092az = intent.getExtras().getString("HAS_MORE");
            this.f2042aA = intent.getExtras().getString("END_TIME");
            this.f2043aB = intent.getExtras().getString("IS_BLIND");
            m3721b();
            this.f2044aC = false;
            return;
        }
        if (i == 10 && i2 == -1) {
            C3250y.m11456e("Delete PostON from Detail page Success", f2014a);
            this.f2044aC = true;
            this.f2107j = true;
            this.f2092az = intent.getExtras().getString("HAS_MORE");
            this.f2042aA = intent.getExtras().getString("END_TIME");
            this.f2043aB = intent.getExtras().getString("IS_BLIND");
            m3721b();
            this.f2044aC = false;
            return;
        }
        if (i == 7 && i2 == -1) {
            C3250y.m11456e("PROFILE_EDIT_BUDDY_NAME", f2014a);
            String string = intent.getExtras().getString("PROFILE_BUDDY_RENAME");
            this.f2118u = string;
            this.f2037V = string;
            this.f2032Q.setText(this.f2118u);
        }
    }

    /* renamed from: a */
    public static boolean m3616a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m3683l() {
        if (this.f2058aQ != null && !this.f2058aQ.isFinishing()) {
            this.f2036U.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m3685m() {
        if (this.f2058aQ != null && !this.f2058aQ.isFinishing()) {
            this.f2036U.dismiss();
        }
    }

    /* renamed from: n */
    private void m3686n() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = this.f2058aQ.getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public List<String> m3689o() {
        ArrayList arrayList = new ArrayList();
        String strM3980g = this.f2116s.m3980g();
        if (!TextUtils.isEmpty(strM3980g)) {
            StringTokenizer stringTokenizer = new StringTokenizer(strM3980g, "|");
            while (stringTokenizer.hasMoreTokens()) {
                new String();
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.length() >= 19 && strNextToken.startsWith("10")) {
                    C3250y.m11450b("chaton id : " + strNextToken, f2014a);
                } else if (strNextToken.startsWith("0")) {
                    C3250y.m11450b("pin number : " + strNextToken, f2014a);
                } else {
                    C3250y.m11450b("msisdn: " + strNextToken, f2014a);
                    arrayList.add(strNextToken);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public void m3723c() {
        if (this.f2027L.m4343c()) {
            this.f2027L.m4339a().setOnClickListener(this.f2100c);
        } else {
            this.f2027L.m4339a().setFocusable(false);
            this.f2027L.m4339a().setClickable(false);
        }
        if (this.f2028M.m4343c()) {
            this.f2028M.m4339a().setOnClickListener(this.f2100c);
        } else {
            this.f2028M.m4339a().setVisibility(8);
        }
        if (this.f2029N.m4343c()) {
            this.f2029N.m4339a().setOnClickListener(this.f2100c);
        } else {
            this.f2029N.m4339a().setVisibility(8);
        }
        if (this.f2030O.m4343c()) {
            this.f2030O.m4339a().setOnClickListener(this.f2100c);
        } else {
            this.f2030O.m4339a().setVisibility(8);
        }
        this.f2031P.setOnClickListener(this.f2100c);
    }

    /* renamed from: d */
    public void m3725d() {
        C3231f.m11361a(this.f2058aQ).m11385b(this.f2027L, this.f2028M, this.f2029N, this.f2030O, this.f2117t);
        m3723c();
    }

    /* renamed from: a */
    public void m3712a(int i) {
        C3231f.m11361a(this.f2058aQ).m11380a(this.f2028M, this.f2029N, this.f2030O, this.f2117t, i - 1);
    }

    @Override // com.sec.common.p069e.InterfaceC3329f
    /* renamed from: a */
    public void mo3713a(View view, AbstractRunnableC3324a<?> abstractRunnableC3324a) {
        if (this.f2017B) {
            if (this.f2027L != null && view == this.f2019D) {
                this.f2027L.m4341a(false);
            } else if (this.f2028M != null && view == this.f2028M.m4339a()) {
                this.f2028M.m4341a(false);
            } else if (this.f2029N != null && view == this.f2029N.m4339a()) {
                this.f2029N.m4341a(false);
            } else if (this.f2030O != null && view == this.f2030O.m4339a()) {
                this.f2030O.m4341a(false);
            }
            this.f2056aO--;
            if (this.f2056aO == 0) {
                m3723c();
            }
        }
    }

    @Override // com.sec.common.p069e.InterfaceC3329f
    /* renamed from: b */
    public void mo3722b(View view, AbstractRunnableC3324a<?> abstractRunnableC3324a) {
        if (this.f2017B) {
            if (this.f2027L != null && view == this.f2019D) {
                this.f2027L.m4341a(true);
            } else if (this.f2028M != null && view == this.f2028M.m4339a()) {
                this.f2028M.m4341a(true);
            } else if (this.f2029N != null && view == this.f2029N.m4339a()) {
                this.f2029N.m4341a(true);
            } else if (this.f2030O != null && view == this.f2030O.m4339a()) {
                this.f2030O.m4341a(true);
            }
            this.f2056aO--;
            if (this.f2056aO == 0) {
                m3723c();
                return;
            }
            return;
        }
        this.f2066aY.setVisibility(0);
    }

    /* renamed from: a */
    private void m3613a(ImageView imageView) {
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        Configuration configuration = getResources().getConfiguration();
        if (C3250y.f11734b) {
            C3250y.m11450b("setCoverstory is called in BPF", f2014a);
        }
        try {
            String str = this.f2058aQ.getApplicationContext().getCacheDir() + "/" + this.f2117t + "/coverstory/";
            if (!new File(str).exists()) {
                C3250y.m11450b("setCoverstory CoverStory is empty. loadDefaultCoverStory() ", f2014a);
                C3231f.m11368a(imageView);
                return;
            }
            C3250y.m11450b("setCoverstory", f2014a);
            Bitmap bitmapM10994a = configuration.orientation == 2 ? C3162ad.m10994a(getActivity(), defaultDisplay.getWidth(), defaultDisplay.getHeight(), (int) C3172an.m11085a(59.0f), str, "coverstory.jpg") : C3162ad.m11011b(getActivity(), defaultDisplay.getWidth(), defaultDisplay.getHeight(), (int) C3172an.m11085a(59.0f), str, "coverstory.jpg");
            if (bitmapM10994a != null) {
                imageView.setImageBitmap(bitmapM10994a);
            } else {
                C3250y.m11450b("image is empty. loadDefaultCoverStory()", f2014a);
                C3231f.m11368a(imageView);
            }
        } catch (Exception e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, getClass().getSimpleName());
            }
        }
    }

    @Override // com.sec.chaton.poston.InterfaceC2019j
    /* renamed from: a */
    public void mo3716a(String str) {
        ((InterfaceC0696fg) getActivity()).mo1320b(this.f2117t, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m3691p() {
        m3683l();
        new C1330h(this.f2101d).m5730b(this.f2117t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m3693q() {
        m3683l();
        new C1328f(this.f2101d).m5706a(this.f2117t, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m3695r() {
        ArrayList<String> arrayList = new ArrayList<>();
        m3683l();
        C1336n c1336n = new C1336n(this.f2101d);
        arrayList.add(this.f2117t);
        c1336n.m5791a("true", arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00e3, code lost:
    
        r7 = android.net.Uri.parse("tel:" + r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.net.Uri m3720b(java.lang.String r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyProfileFragment.m3720b(java.lang.String):android.net.Uri");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m3697s() {
        /*
            r7 = this;
            r1 = 1
            r2 = 0
            com.sec.chaton.buddy.a.c r0 = r7.f2116s
            int r0 = r0.m3966C()
            if (r0 == 0) goto L9d
            r0 = r1
        Lb:
            if (r0 == 0) goto La6
            boolean r3 = r7.m3699t()
            if (r3 != 0) goto La4
            android.support.v4.app.FragmentActivity r0 = r7.getActivity()
            java.lang.String r4 = "phone"
            java.lang.Object r0 = r0.getSystemService(r4)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            android.support.v4.app.FragmentActivity r0 = r7.getActivity()
            android.content.Intent r4 = new android.content.Intent
            java.lang.String r5 = "android.intent.action.SENDTO"
            java.lang.String r6 = "smsto:+000"
            android.net.Uri r6 = android.net.Uri.parse(r6)
            r4.<init>(r5, r6)
            boolean r0 = m3616a(r0, r4)
            if (r0 == 0) goto La4
            r0 = r1
        L37:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "processNoChatONVCase : buddyPhoneNumberAvailable = "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r3)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = com.sec.chaton.buddy.BuddyProfileFragment.f2014a
            com.sec.chaton.util.C3250y.m11458g(r4, r5)
            java.lang.String r4 = r7.f2117t
            boolean r4 = r7.m3658e(r4)
            if (r4 != 0) goto La2
            if (r3 == 0) goto La0
            boolean r3 = r7.m3676i()
            if (r3 == 0) goto La0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "processNoChatONVCase : buddyPhoneNumberAvailable2 = "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = com.sec.chaton.buddy.BuddyProfileFragment.f2014a
            com.sec.chaton.util.C3250y.m11458g(r2, r3)
        L77:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "processNoChatONVCase : buddyPhoneNumberAvailable = "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r1)
            java.lang.String r3 = " @ isContactShow = "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = com.sec.chaton.buddy.BuddyProfileFragment.f2014a
            com.sec.chaton.util.C3250y.m11458g(r2, r3)
            r7.m3615a(r1, r0)
            return
        L9d:
            r0 = r2
            goto Lb
        La0:
            r1 = r2
            goto L77
        La2:
            r1 = r3
            goto L77
        La4:
            r0 = r2
            goto L37
        La6:
            r3 = r0
            r0 = r2
            goto L37
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyProfileFragment.m3697s():void");
    }

    /* renamed from: t */
    private boolean m3699t() {
        boolean zM3616a;
        if (((TelephonyManager) getActivity().getSystemService("phone")).getPhoneType() == 0) {
            zM3616a = false;
        } else {
            zM3616a = m3616a(getActivity(), new Intent("android.intent.action.CALL", Uri.parse("tel:+000")));
        }
        C3250y.m11458g("is3GCallAvailable : " + zM3616a, f2014a);
        return zM3616a;
    }

    /* renamed from: a */
    private void m3615a(boolean z, boolean z2) {
        if (z) {
            this.f2095bb = true;
            return;
        }
        if (z2) {
            this.f2074ah.setVisibility(8);
            this.f2078al.setVisibility(8);
            this.f2075ai.setVisibility(0);
            this.f2079am.setVisibility(0);
            return;
        }
        this.f2074ah.setVisibility(8);
        this.f2078al.setVisibility(8);
        this.f2075ai.setVisibility(8);
        this.f2079am.setVisibility(8);
    }

    /* renamed from: b */
    private void m3642b(boolean z, boolean z2) {
        if (z) {
            this.f2074ah.setVisibility(0);
            this.f2078al.setVisibility(0);
            this.f2075ai.setVisibility(8);
            this.f2079am.setVisibility(8);
            this.f2076aj.setVisibility(0);
            this.f2077ak.setVisibility(0);
            this.f2077ak.setBackgroundResource(R.drawable.buddy_profile_popup_right_btn_bg);
            this.f2080an.setVisibility(0);
            this.f2081ao.setVisibility(0);
            return;
        }
        if (z2) {
            this.f2074ah.setVisibility(8);
            this.f2078al.setVisibility(8);
            this.f2075ai.setVisibility(0);
            this.f2079am.setVisibility(0);
            this.f2076aj.setVisibility(0);
            this.f2077ak.setVisibility(0);
            this.f2080an.setVisibility(0);
            this.f2081ao.setVisibility(0);
            return;
        }
        this.f2074ah.setVisibility(8);
        this.f2078al.setVisibility(8);
        this.f2075ai.setVisibility(8);
        this.f2079am.setVisibility(8);
        this.f2076aj.setVisibility(0);
        this.f2077ak.setVisibility(0);
        this.f2077ak.setBackgroundResource(R.drawable.buddy_profile_popup_right_btn_bg);
        this.f2080an.setVisibility(0);
        this.f2081ao.setVisibility(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008a A[PHI: r10
  0x008a: PHI (r10v1 boolean) = (r10v0 boolean), (r10v3 boolean), (r10v3 boolean) binds: [B:3:0x000e, B:5:0x002c, B:7:0x004f] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m3641b(boolean r10) {
        /*
            r9 = this;
            r1 = 1
            r2 = 0
            boolean r3 = r9.m3705w()
            boolean r4 = r9.m3707x()
            boolean r5 = r9.m3711z()
            if (r10 == 0) goto L8a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "processMultiDeviceCase : buddyPhoneNumberAvailable = "
            java.lang.StringBuilder r0 = r0.append(r6)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = com.sec.chaton.buddy.BuddyProfileFragment.f2014a
            com.sec.chaton.util.C3250y.m11458g(r0, r6)
            boolean r10 = r9.m3699t()
            if (r10 != 0) goto L8a
            android.support.v4.app.FragmentActivity r0 = r9.getActivity()
            java.lang.String r6 = "phone"
            java.lang.Object r0 = r0.getSystemService(r6)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            android.support.v4.app.FragmentActivity r0 = r9.getActivity()
            android.content.Intent r6 = new android.content.Intent
            java.lang.String r7 = "android.intent.action.SENDTO"
            java.lang.String r8 = "smsto:+000"
            android.net.Uri r8 = android.net.Uri.parse(r8)
            r6.<init>(r7, r8)
            boolean r0 = m3616a(r0, r6)
            if (r0 == 0) goto L8a
            r0 = r1
        L52:
            boolean r6 = r9.m3703v()
            if (r3 == 0) goto L74
            if (r4 == 0) goto L74
            if (r5 == 0) goto L68
            if (r6 == 0) goto L64
            r9.m3642b(r10, r0)
            r9.f2096bc = r1
        L63:
            return
        L64:
            r9.m3615a(r10, r0)
            goto L63
        L68:
            if (r6 == 0) goto L70
            r9.m3642b(r10, r0)
            r9.f2096bc = r2
            goto L63
        L70:
            r9.m3615a(r10, r0)
            goto L63
        L74:
            if (r3 == 0) goto L86
            boolean r1 = r9.m3709y()
            if (r1 != 0) goto L82
            if (r6 == 0) goto L82
            r9.m3642b(r10, r0)
            goto L63
        L82:
            r9.m3615a(r10, r0)
            goto L63
        L86:
            r9.m3615a(r10, r0)
            goto L63
        L8a:
            r0 = r2
            goto L52
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyProfileFragment.m3641b(boolean):void");
    }

    /* renamed from: u */
    private void m3701u() {
        boolean z;
        if (this.f2116s.m3966C() != 0) {
        }
        if (this.f2116s != null) {
            C3250y.m11458g("showphonenumber : " + this.f2116s.m3966C(), f2014a);
            if (!this.f2120w) {
                C3250y.m11458g("refreshCommunicationButtons : is not multi-device", f2014a);
                m3697s();
                return;
            }
            C3250y.m11458g("refreshCommunicationButtons : is multi-device", f2014a);
            if (m3689o().size() == 0) {
                z = false;
            } else {
                z = true;
            }
            m3641b(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public boolean m3703v() {
        boolean z = false;
        if (this.f2116s != null) {
            try {
                if (!TextUtils.isEmpty(this.f2116s.m3981h())) {
                    String strM3967D = this.f2116s.m3967D();
                    if (!TextUtils.isEmpty(strM3967D)) {
                        if (strM3967D.contains("voip=1")) {
                            z = true;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        C3250y.m11450b("isChatONVBuddy() : " + z, f2014a);
        return z;
    }

    /* renamed from: w */
    private boolean m3705w() {
        boolean z = false;
        try {
            if (C1948a.m7903a(getActivity())) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3250y.m11450b("isChatONVSupportedDevice() : " + z, f2014a);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public boolean m3707x() {
        boolean z = false;
        try {
            if (C1954g.m7916a().m7918a(getActivity(), EnumC1955h.ChatONV)) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3250y.m11450b("isChatONVAvaiable() : " + z, f2014a);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public boolean m3709y() {
        boolean z = false;
        try {
            C0045a c0045a = this.f2057aP;
            if (C0045a.m37b(getActivity())) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3250y.m11450b("isChatONVInstalled() : " + z, f2014a);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public boolean m3711z() {
        boolean zM55d;
        Exception e;
        try {
            zM55d = this.f2057aP.m55d(getActivity());
            try {
                C3250y.m11450b("isReadyToCall() : " + zM55d, f2014a);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                C3250y.m11450b("isChatONVReadyToCall() : " + zM55d, f2014a);
                return zM55d;
            }
        } catch (Exception e3) {
            zM55d = false;
            e = e3;
        }
        C3250y.m11450b("isChatONVReadyToCall() : " + zM55d, f2014a);
        return zM55d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m3679j(String str) throws Throwable {
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        m3724c(str);
        if (!this.f2053aL) {
            Bundle bundle = new Bundle();
            bundle.putString("phone", str);
            bundle.putString("name", this.f2116s.m3976c());
            C3250y.m11450b("phoneNum: " + str, f2014a);
            C3250y.m11450b("NAME: " + this.f2116s.m3976c(), f2014a);
            if (this.f2116s.m3978e() != null) {
                bundle.putString("email", this.f2116s.m3978e());
            }
            Intent intent = new Intent("android.intent.action.INSERT", uri);
            intent.putExtras(bundle);
            intent.putExtra("return-data", true);
            if (!GlobalApplication.m6456e()) {
                getActivity().finish();
            }
            try {
                startActivity(intent);
                return;
            } catch (ActivityNotFoundException e) {
                C3250y.m11443a(e, getClass().getSimpleName());
                C3641ai.m13210a(getActivity(), R.string.toast_contact_not_found, 0).show();
                return;
            }
        }
        long jM3035a = (this.f2120w || this.f2054aM) ? 0L : C0423i.m3035a(this.f2116s.m3984k());
        if (jM3035a == 0) {
            jM3035a = this.f2055aN;
        }
        C3250y.m11450b("id: " + jM3035a, f2014a);
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse(uri + "/" + jM3035a));
        try {
            startActivity(intent2);
        } catch (ActivityNotFoundException e2) {
            C3250y.m11443a(e2, getClass().getSimpleName());
            C3641ai.m13210a(getActivity(), R.string.toast_contact_not_found, 0).show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008d A[PHI: r1
  0x008d: PHI (r1v6 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v10 android.database.Cursor) binds: [B:23:0x00c2, B:12:0x008b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3724c(java.lang.String r9) throws java.lang.Throwable {
        /*
            r8 = this;
            r7 = 0
            r6 = 0
            r8.f2053aL = r7
            java.lang.String r0 = "[contactSavedCheck] Contact Saved Find Start"
            java.lang.String r1 = com.sec.chaton.buddy.BuddyProfileFragment.f2014a     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            com.sec.chaton.util.C3250y.m11450b(r0, r1)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            android.net.Uri r0 = android.provider.ContactsContract.PhoneLookup.CONTENT_FILTER_URI     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            java.lang.String r1 = android.net.Uri.encode(r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            android.net.Uri r1 = android.net.Uri.withAppendedPath(r0, r1)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            android.support.v4.app.FragmentActivity r0 = r8.getActivity()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            r3 = 0
            java.lang.String r4 = "display_name"
            r2[r3] = r4     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            r3 = 1
            java.lang.String r4 = "number"
            r2[r3] = r4     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            r3 = 2
            java.lang.String r4 = "_id"
            r2[r3] = r4     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            if (r1 == 0) goto L85
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            if (r0 <= 0) goto L85
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            if (r0 == 0) goto L85
            r0 = 1
            r8.f2053aL = r0     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.String r0 = "_id"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            r8.f2055aN = r0     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            r0.<init>()     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.String r2 = "[contactSavedCheck] Found in Contact Number : "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.StringBuilder r0 = r0.append(r9)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.String r2 = com.sec.chaton.buddy.BuddyProfileFragment.f2014a     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            com.sec.chaton.util.C3250y.m11450b(r0, r2)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            r0.<init>()     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.String r2 = "[contactSavedCheck] ContactSaved id : "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            int r2 = r8.f2055aN     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.String r2 = com.sec.chaton.buddy.BuddyProfileFragment.f2014a     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            com.sec.chaton.util.C3250y.m11450b(r0, r2)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
        L85:
            if (r1 == 0) goto L90
            boolean r0 = r1.isClosed()
            if (r0 != 0) goto L90
        L8d:
            r1.close()
        L90:
            boolean r0 = r8.f2053aL
            if (r0 != 0) goto Lae
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "[contactSavedCheck] No PhoneNumber in Contact : "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = com.sec.chaton.buddy.BuddyProfileFragment.f2014a
            com.sec.chaton.util.C3250y.m11450b(r0, r1)
            r8.f2055aN = r7
        Lae:
            return
        Laf:
            r0 = move-exception
            r1 = r6
        Lb1:
            java.lang.Class r2 = r8.getClass()     // Catch: java.lang.Throwable -> Ld3
            java.lang.String r2 = r2.getSimpleName()     // Catch: java.lang.Throwable -> Ld3
            com.sec.chaton.util.C3250y.m11443a(r0, r2)     // Catch: java.lang.Throwable -> Ld3
            if (r1 == 0) goto L90
            boolean r0 = r1.isClosed()
            if (r0 != 0) goto L90
            goto L8d
        Lc5:
            r0 = move-exception
            r1 = r6
        Lc7:
            if (r1 == 0) goto Ld2
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto Ld2
            r1.close()
        Ld2:
            throw r0
        Ld3:
            r0 = move-exception
            goto Lc7
        Ld5:
            r0 = move-exception
            goto Lb1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyProfileFragment.m3724c(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3648c(boolean z) {
        if (GlobalApplication.m6456e() && this.f2097bd != null) {
            if (z) {
                this.f2097bd.setBackgroundResource(R.drawable.actionbar_ic_favorite_01);
            } else {
                this.f2097bd.setBackgroundResource(R.drawable.actionbar_ic_favorite_02);
            }
        }
    }

    /* renamed from: d */
    public boolean m3726d(String str) {
        boolean z;
        Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1445m.f5377a, null, "group_relation_buddy=?", new String[]{str}, null);
        if (cursorQuery == null || cursorQuery.getCount() == 0) {
            z = false;
        } else {
            while (cursorQuery.moveToNext()) {
                if (cursorQuery.getString(cursorQuery.getColumnIndex("group_relation_group")).equals("1")) {
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
}
