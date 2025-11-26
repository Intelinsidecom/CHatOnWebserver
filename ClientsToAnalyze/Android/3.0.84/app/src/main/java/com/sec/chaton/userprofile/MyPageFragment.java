package com.sec.chaton.userprofile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.sso.p006a.C0045a;
import com.sec.chaton.InterfaceC0813bw;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p018b.ContextMenuC0453a;
import com.sec.chaton.p025d.C1331i;
import com.sec.chaton.p025d.C1344v;
import com.sec.chaton.p025d.C1345w;
import com.sec.chaton.p027e.p028a.C1352aa;
import com.sec.chaton.p027e.p028a.C1365i;
import com.sec.chaton.p035io.entry.GetPostONList;
import com.sec.chaton.p035io.entry.GetProfileImageList;
import com.sec.chaton.p035io.entry.inner.ProfileImage;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.poston.C1960a;
import com.sec.chaton.poston.C2013d;
import com.sec.chaton.poston.C2020k;
import com.sec.chaton.poston.InterfaceC2019j;
import com.sec.chaton.poston.PostONDetailActivity;
import com.sec.chaton.poston.PostONDetailFragment;
import com.sec.chaton.trunk.p061c.C3020a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3201bp;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3231f;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.InterfaceC3204bs;
import com.sec.chaton.widget.C3263j;
import com.sec.chaton.widget.SelectableImageView;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.C3347i;
import com.sec.common.util.log.collector.C3358h;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.C3641ai;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MyPageFragment extends Fragment implements InterfaceC0813bw, InterfaceC2019j {

    /* renamed from: A */
    private TextView f11098A;

    /* renamed from: B */
    private ImageView f11099B;

    /* renamed from: C */
    private ImageView f11100C;

    /* renamed from: D */
    private ImageView f11101D;

    /* renamed from: E */
    private String f11102E;

    /* renamed from: F */
    private String f11103F;

    /* renamed from: G */
    private String f11104G;

    /* renamed from: H */
    private LinearLayout f11105H;

    /* renamed from: aA */
    private File f11123aA;

    /* renamed from: aD */
    private BitmapDrawable f11126aD;

    /* renamed from: aE */
    private int f11127aE;

    /* renamed from: aF */
    private int f11128aF;

    /* renamed from: aG */
    private File f11129aG;

    /* renamed from: aH */
    private Uri f11130aH;

    /* renamed from: aI */
    private C3111bj f11131aI;

    /* renamed from: aJ */
    private ArrayList<C3147p> f11132aJ;

    /* renamed from: aK */
    private C3263j f11133aK;

    /* renamed from: aL */
    private FrameLayout f11134aL;

    /* renamed from: aM */
    private FrameLayout f11135aM;

    /* renamed from: aN */
    private FrameLayout f11136aN;

    /* renamed from: aO */
    private C0045a f11137aO;

    /* renamed from: aa */
    private boolean f11146aa;

    /* renamed from: ad */
    private SelectableImageView f11147ad;

    /* renamed from: ae */
    private SelectableImageView f11148ae;

    /* renamed from: af */
    private SelectableImageView f11149af;

    /* renamed from: ag */
    private SelectableImageView f11150ag;

    /* renamed from: ah */
    private ImageView f11151ah;

    /* renamed from: ai */
    private ArrayList<ProfileImage> f11152ai;

    /* renamed from: aj */
    private C3326c f11153aj;

    /* renamed from: ak */
    private CallableC3115bn f11154ak;

    /* renamed from: al */
    private boolean f11155al;

    /* renamed from: am */
    private File f11156am;

    /* renamed from: ar */
    private String f11161ar;

    /* renamed from: as */
    private boolean f11162as;

    /* renamed from: at */
    private File f11163at;

    /* renamed from: ax */
    private Uri f11167ax;

    /* renamed from: az */
    private C3201bp f11169az;

    /* renamed from: d */
    private boolean f11172d;

    /* renamed from: f */
    private View f11174f;

    /* renamed from: g */
    private View f11175g;

    /* renamed from: h */
    private boolean f11176h;

    /* renamed from: i */
    private String f11177i;

    /* renamed from: j */
    private String f11178j;

    /* renamed from: k */
    private ProgressDialog f11179k;

    /* renamed from: l */
    private ProgressDialog f11180l;

    /* renamed from: m */
    private C1345w f11181m;

    /* renamed from: n */
    private C1331i f11182n;

    /* renamed from: o */
    private ImageView f11183o;

    /* renamed from: p */
    private LinearLayout f11184p;

    /* renamed from: q */
    private InterfaceC3274d f11185q;

    /* renamed from: r */
    private LinearLayout f11186r;

    /* renamed from: s */
    private LinearLayout f11187s;

    /* renamed from: t */
    private View f11188t;

    /* renamed from: u */
    private ListView f11189u;

    /* renamed from: w */
    private C2013d f11191w;

    /* renamed from: x */
    private C1344v f11192x;

    /* renamed from: y */
    private ImageButton f11193y;

    /* renamed from: z */
    private TextView f11194z;

    /* renamed from: a */
    public static final String f11095a = MyPageFragment.class.getSimpleName();

    /* renamed from: O */
    private static String f11094O = "mypage";

    /* renamed from: ab */
    private static String f11096ab = "profile_f_mine_";

    /* renamed from: ac */
    private static String f11097ac = "profile_t_mine_";

    /* renamed from: e */
    private boolean f11173e = true;

    /* renamed from: v */
    private ArrayList<C2020k> f11190v = new ArrayList<>();

    /* renamed from: I */
    private final String f11106I = "deleted";

    /* renamed from: J */
    private final String f11107J = "updated";

    /* renamed from: K */
    private final String f11108K = "profile";

    /* renamed from: L */
    private final String f11109L = "coverstory";

    /* renamed from: M */
    private final String f11110M = "coverstory_sample_changed";

    /* renamed from: N */
    private final String f11111N = "coverstory_not_changed";

    /* renamed from: P */
    private final int f11112P = 0;

    /* renamed from: Q */
    private final int f11113Q = 1;

    /* renamed from: R */
    private final int f11114R = 2;

    /* renamed from: S */
    private final int f11115S = 3;

    /* renamed from: T */
    private final int f11116T = 1;

    /* renamed from: U */
    private final int f11117U = 2;

    /* renamed from: V */
    private final int f11118V = 3;

    /* renamed from: W */
    private final int f11119W = 4;

    /* renamed from: X */
    private final int f11120X = 5;

    /* renamed from: Y */
    private final int f11121Y = 6;

    /* renamed from: Z */
    private final int f11122Z = 9;

    /* renamed from: an */
    private String f11157an = "";

    /* renamed from: ao */
    private String f11158ao = "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3159aa.m10962a().m10979a("imei", "");

    /* renamed from: ap */
    private final int f11159ap = 4;

    /* renamed from: aq */
    private String f11160aq = C3223ck.m11329c() + "/profilehistory/";

    /* renamed from: b */
    final String f11170b = C3223ck.m11328b();

    /* renamed from: au */
    private File f11164au = new File(this.f11170b + "/profile/");

    /* renamed from: av */
    private boolean f11165av = false;

    /* renamed from: aw */
    private boolean f11166aw = false;

    /* renamed from: ay */
    private boolean f11168ay = false;

    /* renamed from: aB */
    private String f11124aB = "";

    /* renamed from: aC */
    private File f11125aC = new File(this.f11170b + "/coverstory/");

    /* renamed from: aP */
    private View.OnClickListener f11138aP = new ViewOnClickListenerC3083ai(this);

    /* renamed from: aQ */
    private InterfaceC3204bs f11139aQ = new C3097aw(this);

    /* renamed from: aR */
    private Handler f11140aR = new HandlerC3098ax(this);

    /* renamed from: aS */
    private DialogInterface.OnClickListener f11141aS = new DialogInterfaceOnClickListenerC3108bg(this);

    /* renamed from: aT */
    private DialogInterface.OnClickListener f11142aT = new DialogInterfaceOnClickListenerC3109bh(this);

    /* renamed from: aU */
    private DialogInterface.OnClickListener f11143aU = new DialogInterfaceOnClickListenerC3110bi(this);

    /* renamed from: aV */
    private DialogInterface.OnClickListener f11144aV = new DialogInterfaceOnClickListenerC3084aj(this);

    /* renamed from: aW */
    private Handler f11145aW = new HandlerC3085ak(this);

    /* renamed from: c */
    AbsListView.OnScrollListener f11171c = new C3092ar(this);

    @Override // com.sec.chaton.InterfaceC0813bw
    /* renamed from: b */
    public void mo1189b() throws Throwable {
        BaseActivity.m3081a(this, true);
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C3358h.m11842a().m11846a("00080001");
        }
        m10750n();
        if (this.f11169az == null) {
            m10740i();
        } else if (this.f11169az.m11166a("get_profile_information")) {
            this.f11169az.m11163a();
        } else {
            m10752o();
        }
        this.f11172d = true;
        if (C3159aa.m10962a().m10977a("coverstory_user_guide_popup", (Boolean) true).booleanValue()) {
            startActivity(new Intent(getActivity(), (Class<?>) CoverstoryUserGuideActivity.class));
        }
        if (C3159aa.m10962a().m10977a("coverstory_first_set", (Boolean) true).booleanValue()) {
            C3250y.m11450b(" onTabSelected listCoverStory First @@@@", f11095a);
            this.f11132aJ = new ArrayList<>();
            this.f11182n.m5765d();
        }
        if (GlobalApplication.m6456e() && getActivity() != null) {
            ((TabActivity) getActivity()).m1312a(R.id.fragment_user_profile, getActivity().getIntent(), MyInfoFragment.class);
            if (1 == getResources().getConfiguration().orientation) {
                ((TabActivity) getActivity()).m1327h();
            } else {
                ((TabActivity) getActivity()).m1319b(getResources().getDimensionPixelSize(R.dimen.flayout_mypage_left_panel));
            }
            this.f11136aN = (FrameLayout) this.f11174f.findViewById(R.id.layout_myinfo_fragment);
            if (this.f11136aN != null) {
                Fragment fragmentInstantiate = Fragment.instantiate(getActivity(), MyInfoFragment.class.getName());
                FragmentTransaction fragmentTransactionBeginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransactionBeginTransaction.replace(R.id.layout_myinfo_fragment, fragmentInstantiate);
                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
                if (1 == getResources().getConfiguration().orientation) {
                    this.f11136aN.setVisibility(0);
                } else {
                    this.f11136aN.setVisibility(8);
                }
                this.f11136aN.setOnLongClickListener(null);
                this.f11136aN.setClickable(false);
                this.f11136aN.setOnClickListener(null);
            }
        }
    }

    @Override // com.sec.chaton.InterfaceC0813bw
    /* renamed from: c */
    public void mo1190c() {
        BaseActivity.m3081a(this, false);
        this.f11172d = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m10742j();
        this.f11177i = "";
        this.f11178j = "";
        this.f11176h = true;
        this.f11155al = false;
        this.f11162as = true;
        this.f11146aa = false;
        m10766v();
        try {
            this.f11163at = getActivity().getApplicationContext().getFilesDir().getAbsoluteFile();
            this.f11161ar = getActivity().getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/";
        } catch (Exception e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, getClass().getSimpleName());
            }
        }
        this.f11192x = new C1344v(this.f11140aR);
        this.f11181m = new C1345w(this.f11140aR);
        this.f11182n = new C1331i(this.f11140aR);
        m10740i();
        this.f11185q = null;
        if (bundle == null) {
            this.f11167ax = null;
            return;
        }
        String string = bundle.getString("CAPTURE_IMAGE_URI");
        if (!TextUtils.isEmpty(string)) {
            this.f11167ax = Uri.parse(string);
        }
        String string2 = bundle.getString("PROFILE_IMAGE_TEMP_FILE_URI");
        if (!TextUtils.isEmpty(string2)) {
            this.f11156am = new File(string2);
        }
        String string3 = bundle.getString("COVERSTORY_IMAGE_TEMP_FILE_URI");
        if (!TextUtils.isEmpty(string3)) {
            this.f11123aA = new File(string3);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f11137aO = new C0045a();
        this.f11174f = layoutInflater.inflate(R.layout.layout_mypage_main_header, (ViewGroup) null);
        this.f11194z = (TextView) this.f11174f.findViewById(R.id.mypage_main_profile_name);
        this.f11098A = (TextView) this.f11174f.findViewById(R.id.mypage_main_profile_status_message);
        this.f11099B = (ImageView) this.f11174f.findViewById(R.id.mypage_main_profile_status_icon);
        this.f11100C = (ImageView) this.f11174f.findViewById(R.id.mypage_main_profile_edit_button);
        this.f11101D = (ImageView) this.f11174f.findViewById(R.id.mypage_main_profile_info_button);
        this.f11147ad = (SelectableImageView) this.f11174f.findViewById(R.id.mypage_main_profile_image_represent);
        this.f11148ae = (SelectableImageView) this.f11174f.findViewById(R.id.mypage_main_profile_image_sub1);
        this.f11149af = (SelectableImageView) this.f11174f.findViewById(R.id.mypage_main_profile_image_sub2);
        this.f11150ag = (SelectableImageView) this.f11174f.findViewById(R.id.mypage_main_profile_image_sub3);
        this.f11151ah = (ImageView) this.f11174f.findViewById(R.id.mypage_profile_more);
        this.f11193y = (ImageButton) this.f11174f.findViewById(R.id.mypage_main_poston_write);
        this.f11135aM = (FrameLayout) this.f11174f.findViewById(R.id.mypage_main_profile_image_represent_layout);
        this.f11105H = (LinearLayout) this.f11174f.findViewById(R.id.mypage_name_status_layout);
        this.f11153aj = new C3326c();
        this.f11184p = (LinearLayout) this.f11174f.findViewById(R.id.llayout_mypage_coverstory_press_area);
        this.f11184p.setOnLongClickListener(new ViewOnLongClickListenerC3096av(this));
        this.f11105H.setOnLongClickListener(null);
        this.f11133aK = new C3263j(getActivity());
        this.f11179k = (ProgressDialog) this.f11133aK.m11487a(R.string.mypage_wait_saving);
        this.f11180l = (ProgressDialog) this.f11133aK.m11487a(R.string.wait_sending);
        this.f11175g = layoutInflater.inflate(R.layout.poston_refresh_footer, (ViewGroup) null);
        this.f11186r = (LinearLayout) this.f11175g.findViewById(R.id.footer_progress);
        this.f11187s = (LinearLayout) this.f11175g.findViewById(R.id.footer_content_layout);
        this.f11187s.setVisibility(8);
        this.f11188t = layoutInflater.inflate(R.layout.layout_mypage_main_poston_list, viewGroup, false);
        this.f11189u = (ListView) this.f11188t.findViewById(R.id.mypage_main_poston_list);
        registerForContextMenu(this.f11189u);
        this.f11183o = (ImageView) this.f11188t.findViewById(R.id.change_skin_bg);
        if (this.f11173e) {
            if ("updated".equals(C3159aa.m10962a().m10979a("mypage_coverstory_state", ""))) {
                m10706a(this.f11183o);
            } else {
                if (C3250y.f11734b) {
                    C3250y.m11450b(" coverstory default image", f11095a);
                }
                m10777d();
            }
            this.f11173e = false;
        }
        registerForContextMenu(this.f11189u);
        this.f11190v.clear();
        this.f11191w = new C2013d(this.f11189u, getActivity(), this.f11190v, R.layout.list_item_common_9);
        this.f11191w.m8044a(this);
        this.f11189u.addHeaderView(this.f11174f, null, true);
        this.f11189u.setFocusable(true);
        this.f11189u.setFocusableInTouchMode(true);
        this.f11189u.setItemsCanFocus(true);
        this.f11189u.addFooterView(this.f11175g, null, false);
        this.f11189u.setAdapter((ListAdapter) this.f11191w);
        this.f11189u.setScrollbarFadingEnabled(true);
        this.f11189u.setOnScrollListener(this.f11171c);
        if (GlobalApplication.m6456e() && getArguments() != null && getArguments().getInt("ACTIVITY_PURPOSE_CALL_MYPAGE") == 22) {
            this.f11134aL = (FrameLayout) this.f11174f.findViewById(R.id.flayout_poston_write);
            if (this.f11134aL != null) {
                this.f11134aL.setVisibility(8);
                this.f11175g.setVisibility(8);
            }
            this.f11155al = true;
        }
        m10758r();
        m10754p();
        m10772y();
        return this.f11188t;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        m10742j();
        m10754p();
        if (this.f11133aK == null) {
            this.f11133aK = new C3263j(getActivity());
        }
        if (this.f11179k == null) {
            this.f11179k = (ProgressDialog) this.f11133aK.m11487a(R.string.mypage_wait_saving);
        }
        if (this.f11180l == null) {
            this.f11180l = (ProgressDialog) this.f11133aK.m11487a(R.string.wait_sending);
        }
        if ("coverstory_sample_changed".equals(C3159aa.m10962a().m10979a("mypage_coverstory_state", ""))) {
            m10706a(this.f11183o);
            C3641ai.m13211a(CommonApplication.m11493l(), getResources().getString(R.string.mypage_coverstory_sample_changed), 0).show();
            C3159aa.m10966a("mypage_coverstory_state", "updated");
        }
        if (this.f11172d) {
            if (this.f11146aa) {
                this.f11146aa = false;
            } else {
                if ("updated".equals(C3159aa.m10962a().m10979a("mypage_coverstory_state", ""))) {
                    m10706a(this.f11183o);
                } else {
                    if (C3250y.f11734b) {
                        C3250y.m11450b(" coverstory default image in onResume()", f11095a);
                    }
                    m10777d();
                }
                m10744k();
            }
        } else if (C3159aa.m10962a().m10977a("coverstory_first_set", (Boolean) true).booleanValue()) {
            C3250y.m11450b(" onResume !mIsTabSelected listCoverStory First @@@@", f11095a);
            this.f11132aJ = new ArrayList<>();
            this.f11182n.m5765d();
            m10750n();
        }
        m10756q();
        if (this.f11150ag.getVisibility() == 0) {
            this.f11151ah.setVisibility(0);
        } else {
            this.f11151ah.setVisibility(8);
        }
        if (this.f11155al) {
            m10748m();
            this.f11155al = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f11167ax != null) {
            bundle.putString("CAPTURE_IMAGE_URI", this.f11167ax.toString());
        }
        if (this.f11156am != null) {
            bundle.putString("PROFILE_IMAGE_TEMP_FILE_URI", this.f11156am.toString());
        }
        if (this.f11123aA != null) {
            bundle.putString("COVERSTORY_IMAGE_TEMP_FILE_URI", this.f11123aA.toString());
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e() && getActivity() != null && isVisible()) {
            Bundle arguments = getArguments();
            if (arguments == null || arguments.getInt("ACTIVITY_PURPOSE_CALL_MYPAGE", 0) != 22) {
                this.f11101D.setVisibility(8);
                if (1 == getResources().getConfiguration().orientation) {
                    ((TabActivity) getActivity()).m1327h();
                    if (this.f11136aN != null) {
                        this.f11136aN.setVisibility(0);
                        return;
                    }
                    return;
                }
                ((TabActivity) getActivity()).m1319b(getResources().getDimensionPixelSize(R.dimen.flayout_mypage_left_panel));
                if (this.f11136aN != null) {
                    this.f11136aN.setVisibility(8);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        try {
            super.onDestroy();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        if (this.f11179k != null && this.f11179k.isShowing()) {
            this.f11179k.dismiss();
        }
        if (this.f11180l != null && this.f11180l.isShowing()) {
            this.f11180l.dismiss();
        }
        if (this.f11147ad != null) {
            this.f11147ad.setImageBitmap(null);
            this.f11147ad = null;
        }
        if (this.f11148ae != null) {
            this.f11148ae.setImageBitmap(null);
            this.f11148ae = null;
        }
        if (this.f11149af != null) {
            this.f11149af.setImageBitmap(null);
            this.f11149af = null;
        }
        if (this.f11150ag != null) {
            this.f11150ag.setImageBitmap(null);
            this.f11150ag = null;
        }
        if (this.f11183o != null) {
            this.f11183o.setImageBitmap(null);
            this.f11183o = null;
        }
        if (this.f11185q != null) {
            this.f11185q.dismiss();
        }
        this.f11191w = null;
        this.f11171c = null;
        this.f11192x.m5911a();
        this.f11181m.m5939e();
        this.f11182n.m5761b();
        m10774z();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f11153aj != null) {
            this.f11153aj.m11731a();
        }
        if (this.f11189u != null) {
            this.f11189u.setAdapter((ListAdapter) null);
            this.f11189u.setOnScrollListener(null);
            this.f11189u.setOnItemSelectedListener(null);
            this.f11189u.setOnKeyListener(null);
            this.f11189u = null;
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        m10774z();
    }

    /* renamed from: i */
    private void m10740i() {
        this.f11169az = new C3201bp();
        this.f11169az.m11164a("get_profile_information", this.f11139aQ, 300000L, "last_sync_time_get_mypage_information");
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
            intent.putExtra(PostONDetailFragment.f7494h, c2020k.m8045a());
            intent.putExtra(PostONDetailFragment.f7500n, "MY_PAGE");
            intent.putExtra(PostONDetailFragment.f7497k, c2020k.m8053h());
            if (!c2020k.m8055j().isEmpty()) {
                Iterator<C1352aa> it = c2020k.m8055j().iterator();
                while (it.hasNext()) {
                    C1352aa next = it.next();
                    if (next.m5957a().equals(C2013d.f7737d)) {
                        if (C3250y.f11734b) {
                            C3250y.m11450b("getMultimediaDownload has geo tag, content.getUrl() = " + next.m5959b(), f11095a);
                        }
                        intent.putExtra(PostONDetailFragment.f7498l, next.m5959b());
                    } else {
                        if (C3250y.f11734b) {
                            C3250y.m11450b("getMultimediaDownload has Multimedia, content.getUrl() = " + next.m5959b() + " / content.getMetaType() = " + next.m5957a(), f11095a);
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
            startActivityForResult(intent, 8);
        }
    }

    @Override // com.sec.chaton.poston.InterfaceC2019j
    /* renamed from: a */
    public void mo3716a(String str) {
        ((InterfaceC3112bk) getActivity()).mo1320b(this.f11102E, str);
    }

    @Override // com.sec.chaton.poston.InterfaceC2019j
    /* renamed from: a */
    public void mo3717a(String str, String str2) {
        if (!C3197bl.m11159a()) {
            ((InterfaceC3112bk) getActivity()).mo1315a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m10742j() {
        this.f11102E = C3159aa.m10962a().m10979a("chaton_id", "");
        this.f11103F = C3159aa.m10962a().m10979a("Push Name", "");
        this.f11104G = C3159aa.m10962a().m10979a("status_message", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m10744k() {
        if (C3250y.f11733a) {
            C3250y.m11456e("setPostONList()", f11095a);
        }
        this.f11187s.setVisibility(8);
        this.f11186r.setVisibility(0);
        this.f11176h = true;
        this.f11192x.m5913a(this.f11102E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m10746l() {
        if (C3250y.f11733a) {
            C3250y.m11456e("getMyProfileInfo()", f11095a);
        }
        this.f11181m.m5936c(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m10748m() {
        if (C3250y.f11733a) {
            C3250y.m11456e("getProfileImageList()", f11095a);
        }
        this.f11181m.m5937d();
    }

    /* renamed from: n */
    private void m10750n() {
        if (C3250y.f11734b) {
            C3250y.m11450b(" Coverstory getCoverStory() called", f11095a);
        }
        this.f11182n.m5757a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10714a(String str, String str2, String str3) {
        this.f11182n.m5760a(str, str2, str3);
        C3159aa.m10966a("coverstory_contentid", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0197  */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m10752o() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.userprofile.MyPageFragment.m10752o():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10707a(C0267d c0267d) throws Throwable {
        int size;
        GetProfileImageList getProfileImageList = (GetProfileImageList) c0267d.m1354e();
        if (getProfileImageList != null) {
            this.f11152ai = getProfileImageList.profileimagelist;
            if (this.f11152ai == null || this.f11152ai.size() == 0) {
                C3159aa.m10966a("profile_image_status", "deleted");
                this.f11162as = true;
                m10702a(0);
                C3159aa.m10966a("profile_small_image0", (String) null);
                return;
            }
            this.f11162as = false;
            if (this.f11152ai.size() > 4) {
                size = 4;
            } else {
                size = this.f11152ai.size();
            }
            m10768w();
            if ("1".equals(this.f11152ai.get(0).represent)) {
                C3159aa.m10966a("profile_image_status", "updated");
                if (this.f11152ai.size() < 4) {
                    m10702a(3);
                    C3159aa.m10966a("profile_small_image3", (String) null);
                }
                if (this.f11152ai.size() < 3) {
                    m10702a(2);
                    C3159aa.m10966a("profile_small_image2", (String) null);
                }
                if (this.f11152ai.size() < 2) {
                    m10702a(1);
                    C3159aa.m10966a("profile_small_image1", (String) null);
                }
            } else {
                m10702a(0);
                C3159aa.m10966a("profile_image_status", "deleted");
                C3159aa.m10966a("profile_small_image0", (String) null);
                if (this.f11152ai.size() < 3) {
                    m10702a(3);
                    C3159aa.m10966a("profile_small_image3", (String) null);
                }
                if (this.f11152ai.size() < 2) {
                    m10702a(2);
                    C3159aa.m10966a("profile_small_image2", (String) null);
                }
                if (this.f11152ai.size() < 1) {
                    m10702a(1);
                    C3159aa.m10966a("profile_small_image1", (String) null);
                }
            }
            for (int i = 0; i < size; i++) {
                ProfileImage profileImage = this.f11152ai.get(i);
                if ("1".equals(profileImage.represent)) {
                    File file = new File(this.f11160aq);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    String str = this.f11160aq + f11097ac + profileImage.profileimageid;
                    String str2 = this.f11160aq + f11096ab + profileImage.profileimageid;
                    if (C3159aa.m10962a().m10977a("profile_image_update_client", (Boolean) true).booleanValue()) {
                        if (C3250y.f11734b) {
                            C3250y.m11456e("Save Profile image to Local Directory", getClass().getSimpleName());
                        }
                        String str3 = this.f11161ar + "myprofile.png_";
                        String str4 = this.f11161ar + this.f11102E + ".jpeg_";
                        File file2 = new File(str);
                        if (new File(str4).exists() && !file2.exists()) {
                            C3243r.m11420a(str4, str);
                        }
                        File file3 = new File(str2);
                        if (new File(str3).exists() && !file3.exists()) {
                            C3243r.m11420a(str3, str2);
                        }
                        C3159aa.m10963a("profile_image_update_client", (Boolean) false);
                    }
                    m10704a(0, profileImage, "profile_small_image0", (ImageView) this.f11147ad, true);
                } else {
                    if (C3250y.f11733a) {
                        C3250y.m11456e("profileimageurl: " + profileImage.profileimageurl.toString(), getClass().getSimpleName());
                    }
                    if ("1".equals(this.f11152ai.get(0).represent)) {
                        m10703a(i, profileImage);
                    } else {
                        m10703a(i + 1, profileImage);
                    }
                }
            }
            if (this.f11150ag.getVisibility() == 0) {
                this.f11151ah.setVisibility(0);
            } else {
                this.f11151ah.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10720b(C0267d c0267d) throws Throwable {
        if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
            GetPostONList getPostONList = (GetPostONList) c0267d.m1354e();
            if (getPostONList.postonlist.size() > 0) {
                this.f11177i = getPostONList.postonlist.get(0).hasmore;
                this.f11178j = getPostONList.postonlist.get(0).endtime;
            }
            m10770x();
        } else {
            if (this.f11180l != null && this.f11180l.isShowing()) {
                this.f11180l.dismiss();
            }
            int iM6733a = C1594v.m6733a(getActivity().getApplicationContext());
            if (-3 == iM6733a || -2 == iM6733a) {
                Toast.makeText(getActivity(), R.string.popup_no_network_connection, 0).show();
            } else {
                Toast.makeText(getActivity(), R.string.toast_network_unable, 0).show();
            }
        }
        m10752o();
        this.f11176h = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m10754p() {
        if (this.f11137aO.m55d(getActivity())) {
            this.f11099B.setVisibility(0);
        } else {
            this.f11099B.setVisibility(8);
        }
        this.f11194z.setText(this.f11103F);
        if (this.f11104G.length() == 0) {
            this.f11098A.setText(R.string.mypage_default_status_message);
        } else {
            this.f11098A.setText(this.f11104G);
        }
    }

    /* renamed from: q */
    private void m10756q() {
        this.f11162as = true;
        C3159aa.m10963a("profile_image_update_client", (Boolean) false);
        m10705a(0, this.f11160aq + "profile_f_mine_" + C3159aa.m10962a().m10979a("profile_small_image0", ""));
        String strM10979a = C3159aa.m10962a().m10979a("profile_small_image1", "");
        if (strM10979a != null) {
            this.f11148ae.setVisibility(0);
            m10705a(1, this.f11160aq + "profile_t_mine_" + strM10979a);
        } else {
            this.f11148ae.setVisibility(8);
        }
        String strM10979a2 = C3159aa.m10962a().m10979a("profile_small_image2", "");
        if (strM10979a2 != null) {
            this.f11149af.setVisibility(0);
            m10705a(2, this.f11160aq + "profile_t_mine_" + strM10979a2);
        } else {
            this.f11149af.setVisibility(8);
        }
        String strM10979a3 = C3159aa.m10962a().m10979a("profile_small_image3", "");
        if (strM10979a3 != null) {
            this.f11150ag.setVisibility(0);
            m10705a(3, this.f11160aq + "profile_t_mine_" + strM10979a3);
        } else {
            this.f11150ag.setVisibility(8);
        }
        if (this.f11162as) {
            String strM10979a4 = C3159aa.m10962a().m10979a("profile_image_status", "");
            if ((strM10979a4.equals("deleted") || strM10979a4.equals("")) && strM10979a != null && strM10979a.equals("")) {
            }
        }
    }

    /* renamed from: r */
    private void m10758r() {
        if (C3250y.f11733a) {
            C3250y.m11456e("MyPageFragment initialize() - img status: " + C3159aa.m10962a().m10979a("profile_image_status", ""), f11095a);
        }
        if (C3159aa.m10962a().m10979a("profile_image_status", "").equals("updated")) {
            File file = new File(this.f11163at, "myprofile.png_");
            if (C3250y.f11734b) {
                C3250y.m11450b("photoFile=" + file, getClass().getSimpleName());
            }
            if (file.exists()) {
                this.f11153aj.m11730a(this.f11147ad, new CallableC3134cf(file, true, true));
                return;
            } else {
                m10702a(0);
                return;
            }
        }
        m10702a(0);
    }

    /* renamed from: a */
    private void m10705a(int i, String str) {
        SelectableImageView selectableImageView;
        CallableC3134cf callableC3134cf;
        String strM10979a = null;
        if (C3250y.f11733a) {
            C3250y.m11456e("[setProfileSmallImages] MyPageFragment initialize() - " + i, f11095a);
        }
        File file = new File(str);
        if (C3250y.f11734b) {
            C3250y.m11450b("[setProfileSmallImages] photoFile=" + file, f11095a);
        }
        switch (i) {
            case 0:
                selectableImageView = this.f11147ad;
                strM10979a = C3159aa.m10962a().m10979a("profile_small_image0", "");
                break;
            case 1:
                selectableImageView = this.f11148ae;
                strM10979a = C3159aa.m10962a().m10979a("profile_small_image1", "");
                break;
            case 2:
                selectableImageView = this.f11149af;
                strM10979a = C3159aa.m10962a().m10979a("profile_small_image2", "");
                break;
            case 3:
                selectableImageView = this.f11150ag;
                strM10979a = C3159aa.m10962a().m10979a("profile_small_image3", "");
                break;
            default:
                selectableImageView = null;
                break;
        }
        if (selectableImageView != null) {
            if (file.exists() && file.length() > 0) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("[setProfileSmallImages] photoFile.exists() && (photoFile.length() > 0) ", f11095a);
                }
                if (i == 0) {
                    callableC3134cf = new CallableC3134cf(file, true, true);
                } else {
                    callableC3134cf = new CallableC3134cf(file, true, false);
                }
                this.f11153aj.m11730a(selectableImageView, callableC3134cf);
                return;
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("[setProfileSmallImages] photoFile not exist ", f11095a);
            }
            if (TextUtils.isEmpty(strM10979a)) {
                m10702a(i);
            }
        }
    }

    /* renamed from: a */
    public void m10775a() throws IOException {
        int i;
        try {
            if (!this.f11125aC.exists()) {
                this.f11125aC.mkdirs();
            }
            m10729d("/coverstory/");
            this.f11124aB = "tmp_" + System.currentTimeMillis() + ".jpeg_";
            this.f11123aA = new File(this.f11125aC + "/", this.f11124aB);
            boolean zCreateNewFile = this.f11123aA.createNewFile();
            if (C3250y.f11734b) {
                C3250y.m11450b("[Create File] " + this.f11125aC.toString() + this.f11124aB + " : " + zCreateNewFile, f11095a);
            }
            this.f11167ax = Uri.fromFile(this.f11123aA);
            if (!C3223ck.m11327a()) {
                Toast.makeText(getActivity(), getString(R.string.toast_sdcard_amount), 1).show();
                return;
            }
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            intent.putExtra("set-as-image", true);
            if (C3171am.m11077o()) {
                i = R.array.coverstory_with_camera;
            } else {
                i = R.array.coverstory_without_camera;
            }
            AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(getActivity());
            if (C3171am.m11077o()) {
                abstractC3271aM11494a.mo11495a(R.string.change_cover_image).mo11497a(i, this.f11143aU);
            } else {
                abstractC3271aM11494a.mo11495a(R.string.change_cover_image).mo11497a(i, this.f11144aV);
            }
            abstractC3271aM11494a.mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3105bd(this));
            abstractC3271aM11494a.mo11505a().show();
        } catch (Exception e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, getClass().getSimpleName());
            }
        }
    }

    /* renamed from: d */
    public boolean m10777d() {
        C3250y.m11450b("Buddy didn't set Coverstory ", getClass().getSimpleName());
        String strM6090a = C1365i.m6090a();
        if (strM6090a != null) {
            if (!m10776b(strM6090a)) {
                m10714a(strM6090a, Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
            }
            C3159aa.m10966a("coverstory_contentid", strM6090a);
            this.f11182n.m5762b(strM6090a);
            return true;
        }
        C3250y.m11450b(" Random ERROR !!", getClass().getSimpleName());
        if (!new File(this.f11161ar + "mycoverstory.jpg").exists()) {
            if (C3250y.f11734b) {
                C3250y.m11450b("First time loadDefaultCoverStory in MypageFragment ", f11095a);
            }
            C3231f.m11368a(this.f11183o);
        } else {
            if (C3250y.f11734b) {
                C3250y.m11450b(" downloadRandomCoverStory in setRandomImages ", f11095a);
            }
            this.f11182n.m5763b(Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
        }
        return false;
    }

    /* renamed from: b */
    public boolean m10776b(String str) throws IOException {
        boolean z = false;
        if (!new File(this.f11161ar).exists()) {
            if (C3250y.f11734b) {
                C3250y.m11450b("checkAndSetCoverStoryRandomImages No random images in file folder ", f11095a);
            }
        } else {
            String str2 = this.f11161ar + str + ".jpg";
            File file = new File(str2);
            if (file.exists()) {
                if (file.length() == 0) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("checkAndSetCoverStoryRandomImages file size is 0.", f11095a);
                    }
                    file.delete();
                } else {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("checkAndSetCoverStoryRandomImages get the random image in file folder #3#", f11095a);
                    }
                    z = true;
                    if (this.f11183o != null) {
                        this.f11183o.setImageURI(Uri.parse(str2));
                        m10726c(str);
                    }
                    if (C3250y.f11734b) {
                        C3250y.m11450b("checkAndSetCoverStoryRandomImages set the random image from file folder #4#", f11095a);
                    }
                }
            } else if (C3250y.f11734b) {
                C3250y.m11450b("checkAndSetCoverStoryRandomImages not exists the random image in file folder #2#", f11095a);
            }
        }
        return z;
    }

    /* renamed from: c */
    private void m10726c(String str) throws IOException {
        String str2 = getActivity().getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        String str3 = this.f11161ar + "mycoverstory.jpg";
        if (C3250y.f11734b) {
            C3250y.m11450b("dirInternalPath : " + this.f11161ar + str + ".jpg", "copyCoverStoryforMyProfile");
            C3250y.m11450b("myCoverstoryPath : " + str3, "copyCoverStoryforMyProfile");
        }
        try {
            File file = new File(str3);
            File file2 = new File(str2 + str + ".jpg");
            if (file2.length() > 0) {
                new FileOutputStream(file).close();
                C3020a.m10525a(file2, file);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: e */
    public void m10778e() {
        AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.mypage_profile_add_photo).mo11509b(CommonApplication.m11493l().getResources().getString(R.string.mypage_add_photo_warning)).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3106be(this)).mo11512b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m10729d(String str) {
        if (!m10779f() || !m10780g()) {
            if (C3250y.f11737e) {
                C3250y.m11442a("[deleteTempFolder] External Storage Is Not Available or Writable!", f11095a);
            }
            Toast.makeText(getActivity(), getString(R.string.toast_sdcard_amount), 1).show();
            return;
        }
        String strM11328b = C3223ck.m11328b();
        if (strM11328b.length() == 0) {
            Toast.makeText(getActivity(), getString(R.string.toast_sdcard_amount), 1).show();
            return;
        }
        try {
            String[] list = new File(strM11328b + str).list();
            if (list != null) {
                for (String str2 : list) {
                    boolean zDelete = new File(strM11328b + str + str2).delete();
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[Delete File] " + strM11328b + str + str2 + " : " + zDelete, f11095a);
                    }
                }
            }
        } catch (Exception e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, getClass().getSimpleName());
            }
        }
    }

    /* renamed from: f */
    protected boolean m10779f() {
        m10760s();
        return this.f11165av;
    }

    /* renamed from: g */
    protected boolean m10780g() {
        m10760s();
        return this.f11166aw;
    }

    /* renamed from: s */
    private void m10760s() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f11165av = true;
            this.f11166aw = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f11165av = true;
            this.f11166aw = false;
        } else {
            this.f11165av = false;
            this.f11166aw = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m10762t() {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(getActivity(), R.string.popup_no_network_connection, 0).show();
            if (C3250y.f11734b) {
                C3250y.m11450b("setCoverstorySample network error!!", f11095a);
                return;
            }
            return;
        }
        startActivityForResult(new Intent(getActivity(), (Class<?>) CoverstorySampleActivity.class), 9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m10732e(String str) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        intent.putExtra("set-as-image", true);
        if (!BuddyProfileActivity.m3573a(getActivity(), intent)) {
            Toast.makeText(getActivity(), R.string.mypage_no_pictures_are_available, 0).show();
        } else if (str.equals("profile")) {
            startActivityForResult(intent, 3);
        } else {
            startActivityForResult(intent, 4);
        }
        this.f11168ay = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                case 10:
                case 11:
                    if (i2 == -1) {
                        File file = new File(Uri.parse(intent.getExtras().getString("temp_file_path")).getPath());
                        if (file.length() <= 0) {
                            if (C3250y.f11737e) {
                                C3250y.m11442a("Crop return null!", f11095a);
                                break;
                            }
                        } else {
                            try {
                                C3020a.m10525a(file, this.f11156am);
                                this.f11155al = true;
                                this.f11179k.show();
                                this.f11181m.m5929a(this.f11156am.getPath());
                                break;
                            } catch (Exception e) {
                                if (C3250y.f11737e) {
                                    C3250y.m11443a(e, getClass().getSimpleName());
                                }
                                m10702a(0);
                                return;
                            }
                        }
                    }
                    break;
                case 2:
                    if (i2 == -1) {
                        Uri uri = Uri.parse(intent.getExtras().getString("temp_file_path"));
                        File file2 = new File(uri.getPath());
                        if (file2.length() <= 0) {
                            if (C3250y.f11737e) {
                                C3250y.m11442a("Crop return null!", f11095a);
                                break;
                            }
                        } else {
                            try {
                                this.f11179k.show();
                                if (file2.exists()) {
                                    new AsyncTaskC3113bl(this, file2, uri).execute(new Void[0]);
                                    break;
                                }
                            } catch (Exception e2) {
                                if (C3250y.f11737e) {
                                    C3250y.m11443a(e2, getClass().getSimpleName());
                                }
                                m10702a(0);
                                return;
                            }
                        }
                    }
                    break;
                case 3:
                    if (intent == null) {
                        if (C3250y.f11734b) {
                            C3250y.m11450b("Crop Return is NULL", getClass().getSimpleName());
                            break;
                        }
                    } else {
                        this.f11167ax = intent.getData();
                        Intent intent2 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                        intent2.setDataAndType(this.f11167ax, "image/*");
                        intent2.putExtra("outputX", 600);
                        intent2.putExtra("outputY", 600);
                        intent2.putExtra("aspectX", 1);
                        intent2.putExtra("aspectY", 1);
                        intent2.putExtra("return-data", true);
                        startActivityForResult(intent2, 10);
                        break;
                    }
                    break;
                case 4:
                    if (intent == null) {
                        if (C3250y.f11734b) {
                            C3250y.m11450b("Crop Return is NULL", getClass().getSimpleName());
                            break;
                        }
                    } else {
                        this.f11167ax = intent.getData();
                        Intent intent3 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                        intent3.setDataAndType(this.f11167ax, "image/*");
                        intent3.putExtra("outputX", this.f11127aE);
                        intent3.putExtra("outputY", this.f11128aF);
                        intent3.putExtra("aspectX", 2);
                        intent3.putExtra("aspectY", 3);
                        intent3.putExtra("return-data", true);
                        startActivityForResult(intent3, 2);
                        break;
                    }
                    break;
                case 5:
                    if (i2 == -1) {
                        Intent intent4 = new Intent(getActivity().getApplicationContext(), (Class<?>) ImageModify.class);
                        intent4.setDataAndType(this.f11167ax, "image/*");
                        intent4.putExtra("outputX", 600);
                        intent4.putExtra("outputY", 600);
                        intent4.putExtra("aspectX", 1);
                        intent4.putExtra("aspectY", 1);
                        intent4.putExtra("return-data", true);
                        startActivityForResult(intent4, 11);
                        break;
                    } else if (C3250y.f11734b) {
                        C3250y.m11450b("Camera Return is NULL", getClass().getSimpleName());
                        break;
                    }
                    break;
                case 6:
                    if (i2 == -1) {
                        Intent intent5 = new Intent(getActivity().getApplicationContext(), (Class<?>) ImageModify.class);
                        intent5.setDataAndType(this.f11167ax, "image/*");
                        intent5.putExtra("outputX", this.f11127aE);
                        intent5.putExtra("outputY", this.f11128aF);
                        intent5.putExtra("aspectX", 2);
                        intent5.putExtra("aspectY", 3);
                        intent5.putExtra("return-data", true);
                        startActivityForResult(intent5, 2);
                        break;
                    } else if (C3250y.f11734b) {
                        C3250y.m11450b("Camera Return is NULL", getClass().getSimpleName());
                        break;
                    }
                    break;
                case 7:
                    if (i2 == -1) {
                        this.f11177i = intent.getExtras().getString("HAS_MORE");
                        this.f11178j = intent.getExtras().getString("END_TIME");
                        m10752o();
                        this.f11146aa = true;
                        break;
                    }
                    break;
                case 8:
                    if (i2 == -1) {
                        this.f11177i = intent.getExtras().getString("HAS_MORE");
                        this.f11178j = intent.getExtras().getString("END_TIME");
                        m10752o();
                        this.f11146aa = true;
                        break;
                    }
                    break;
            }
            return;
        }
        if (m10715a(i, intent)) {
        }
    }

    /* renamed from: a */
    private boolean m10715a(int i, Intent intent) {
        switch (i) {
            case 10:
                if (intent != null && intent.getBooleanExtra("restart", false)) {
                    m10764u();
                    return true;
                }
                break;
            case 11:
                if (intent != null && intent.getBooleanExtra("restart", false)) {
                    m10734f("profile");
                    return true;
                }
                break;
        }
        return false;
    }

    /* renamed from: u */
    private void m10764u() {
        m10732e("profile");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m10734f(String str) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("return-data", false);
        intent.putExtra("output", this.f11167ax);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        if (str.equals("coverstory")) {
            startActivityForResult(intent, 6);
        } else {
            startActivityForResult(intent, 5);
        }
        this.f11168ay = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public C3111bj m10735g(String str) {
        C3111bj c3111bj = new C3111bj(this);
        String[] strArrSplit = str.split("\n");
        if (strArrSplit != null) {
            for (int i = 0; i < strArrSplit.length; i++) {
                C3250y.m11456e(" strArray[" + i + "]= " + strArrSplit[i], getClass().getSimpleName());
            }
            if (strArrSplit.length == 3) {
                c3111bj.f11324a = strArrSplit[0].substring(0, strArrSplit[0].indexOf("/file"));
                c3111bj.f11325b = "/file/" + strArrSplit[2] + "/" + strArrSplit[1];
                C3250y.m11456e(" Coverstory Added host [" + c3111bj.f11324a + "] metacontents : " + c3111bj.f11325b, getClass().getSimpleName());
            }
        }
        return c3111bj;
    }

    /* renamed from: v */
    private void m10766v() {
        this.f11127aE = C3347i.m11779b();
        this.f11128aF = C3347i.m11780c();
        if (C3250y.f11734b) {
            C3250y.m11450b("1. windows size=width:" + this.f11127aE + " height:" + this.f11128aF, getClass().getSimpleName());
        }
    }

    /* renamed from: w */
    private void m10768w() {
        this.f11148ae.setVisibility(0);
        this.f11149af.setVisibility(0);
        this.f11150ag.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10702a(int i) {
        try {
            switch (i) {
                case 0:
                    this.f11147ad.setImageDrawable(getResources().getDrawable(R.drawable.profile_photo_buddy_default));
                    C3205bt.m11182a(getActivity().getApplicationContext()).m11227b(this.f11102E);
                    this.f11153aj.m11732a(this.f11147ad);
                    break;
                case 1:
                    this.f11148ae.setImageDrawable(getResources().getDrawable(R.drawable.profile_photo_buddy_default));
                    this.f11148ae.setVisibility(8);
                    this.f11153aj.m11732a(this.f11148ae);
                    break;
                case 2:
                    this.f11149af.setImageDrawable(getResources().getDrawable(R.drawable.profile_photo_buddy_default));
                    this.f11149af.setVisibility(8);
                    this.f11153aj.m11732a(this.f11149af);
                    break;
                case 3:
                    this.f11150ag.setImageDrawable(getResources().getDrawable(R.drawable.profile_photo_buddy_default));
                    this.f11150ag.setVisibility(8);
                    this.f11153aj.m11732a(this.f11150ag);
                    break;
                default:
                    return;
            }
        } catch (Exception e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, getClass().getSimpleName());
            }
        }
    }

    /* renamed from: a */
    private void m10708a(ProfileImage profileImage, String str, String str2, ImageView imageView, boolean z) {
        if (this.f11154ak != null) {
            this.f11154ak = null;
        }
        this.f11154ak = new CallableC3115bn((ImageView) null, profileImage.profileimageurl.toString() + this.f11158ao + "&size=800", 600, 600, str2, str + "mine_" + profileImage.profileimageid, z, this.f11140aR);
        this.f11153aj.m11730a(imageView, this.f11154ak);
    }

    /* renamed from: x */
    private void m10770x() {
        C3159aa.m10962a().m10984b("new_post_on_count", (Integer) 0);
        if (C3250y.f11733a) {
            C3250y.m11456e("Selected My page totalNumBadge : " + C3159aa.m10962a().m10978a("new_post_on_count", (Integer) 0), getClass().getSimpleName());
        }
        LocalBroadcastManager.getInstance(getActivity().getApplicationContext()).sendBroadcast(new Intent("mypage_badge_update"));
    }

    /* renamed from: y */
    private void m10772y() {
        this.f11147ad.setOnClickListener(this.f11138aP);
        this.f11151ah.setOnClickListener(this.f11138aP);
        this.f11148ae.setOnClickListener(new ViewOnClickListenerC3086al(this));
        this.f11149af.setOnClickListener(new ViewOnClickListenerC3087am(this));
        this.f11150ag.setOnClickListener(new ViewOnClickListenerC3088an(this));
        this.f11100C.setOnClickListener(new ViewOnClickListenerC3089ao(this));
        this.f11101D.setOnClickListener(new ViewOnClickListenerC3090ap(this));
        this.f11193y.setOnClickListener(new ViewOnClickListenerC3091aq(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10706a(ImageView imageView) {
        C1960a c1960a = new C1960a(this.f11102E, f11094O, getActivity(), this.f11161ar, "mycoverstory.jpg", C3159aa.m10962a().m10979a("coverstory_metaid", ""));
        if (C3250y.f11734b) {
            C3250y.m11450b(" Coverstory setCoverstoryAndDownload() MYPAGE_STATUS_UPDATED set", f11095a);
        }
        C3159aa.m10966a("mypage_coverstory_state", "updated");
        this.f11153aj.m11730a(imageView, c1960a);
    }

    /* renamed from: z */
    private void m10774z() {
        Bitmap bitmap;
        if (this.f11126aD != null && (bitmap = this.f11126aD.getBitmap()) != null) {
            bitmap.recycle();
        }
    }

    /* renamed from: a */
    private void m10703a(int i, ProfileImage profileImage) {
        switch (i) {
            case 1:
                m10704a(i, profileImage, "profile_small_image1", (ImageView) this.f11148ae, false);
                break;
            case 2:
                m10704a(i, profileImage, "profile_small_image2", (ImageView) this.f11149af, false);
                break;
            case 3:
                m10704a(i, profileImage, "profile_small_image3", (ImageView) this.f11150ag, false);
                break;
        }
    }

    /* renamed from: a */
    private void m10704a(int i, ProfileImage profileImage, String str, ImageView imageView, boolean z) {
        String str2;
        if (z) {
            str2 = "profile_f_";
        } else {
            str2 = "profile_t_";
        }
        String str3 = this.f11160aq + str2 + "mine_" + profileImage.profileimageid;
        m10705a(i, str3);
        File file = new File(str3);
        if (!C3159aa.m10962a().m10979a(str, "").equals(profileImage.profileimageid) || !file.exists()) {
            C3159aa.m10966a(str, profileImage.profileimageid);
            if (!file.exists()) {
                m10708a(profileImage, str2, this.f11160aq, imageView, z);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (GlobalApplication.m6456e()) {
            menu.clear();
            ((TabActivity) getActivity()).getMenuInflater().inflate(R.menu.activity_main, menu);
        }
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.activity_mypage_menu, menu);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.setGroupVisible(R.id.mypage_menu_group_sync_option, true);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) throws IOException {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case R.id.mypage_menu_sync /* 2131166568 */:
                C3250y.m11450b("onOptionsItemSelected():mypage_menu_sync", f11095a);
                m10775a();
                return true;
            default:
                return false;
        }
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        ContextMenuC0453a contextMenuC0453a = new ContextMenuC0453a(getActivity().getApplicationContext(), contextMenu);
        C2020k c2020k = (C2020k) this.f11189u.getAdapter().getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position);
        if (c2020k != null) {
            String strM8048c = c2020k.m8048c();
            c2020k.m8051f();
            String strM8045a = c2020k.m8045a();
            if (strM8048c.equals(this.f11102E)) {
                contextMenuC0453a.setHeaderTitle(R.string.setting_interaction_me);
            } else {
                contextMenuC0453a.setHeaderTitle(c2020k.m8049d());
            }
            contextMenuC0453a.add(0, 0, 1, R.string.memo_delete_context_menu).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC3093as(this, strM8045a));
        }
    }
}
