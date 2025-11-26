package com.sec.chaton.buddy;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.R;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p049b.ContextMenuC1056a;
import com.sec.chaton.p055d.C2074ag;
import com.sec.chaton.p055d.C2075ah;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p055d.C2130k;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.p057e.C2293m;
import com.sec.chaton.p057e.p058a.C2179ae;
import com.sec.chaton.p057e.p058a.C2195i;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.chaton.p065io.entry.GetPostONList;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.plugin.C2923b;
import com.sec.chaton.poston.C3009d;
import com.sec.chaton.poston.C3016k;
import com.sec.chaton.poston.InterfaceC3015j;
import com.sec.chaton.poston.PostONDetailActivity;
import com.sec.chaton.poston.PostONDetailFragment;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import com.sec.common.CommonApplication;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.common.p132g.C5007c;
import com.sec.common.p132g.InterfaceC5010f;
import com.sec.widget.C5179v;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class BuddyProfileFragment extends Fragment implements InterfaceC3015j, InterfaceC5010f {

    /* renamed from: a */
    public static final String f3906a = BuddyProfileFragment.class.getSimpleName();

    /* renamed from: ak */
    private static String f3907ak = "";

    /* renamed from: F */
    private ImageView f3913F;

    /* renamed from: G */
    private ImageView f3914G;

    /* renamed from: H */
    private ImageView f3915H;

    /* renamed from: I */
    private ImageView f3916I;

    /* renamed from: J */
    private ImageView f3917J;

    /* renamed from: K */
    private ImageView f3918K;

    /* renamed from: L */
    private ImageView f3919L;

    /* renamed from: M */
    private ImageView f3920M;

    /* renamed from: N */
    private C1337gq f3921N;

    /* renamed from: O */
    private C1337gq f3922O;

    /* renamed from: P */
    private C1337gq f3923P;

    /* renamed from: Q */
    private C1337gq f3924Q;

    /* renamed from: R */
    private ImageView f3925R;

    /* renamed from: S */
    private TextView f3926S;

    /* renamed from: T */
    private TextView f3927T;

    /* renamed from: U */
    private ImageButton f3928U;

    /* renamed from: V */
    private ImageView f3929V;

    /* renamed from: W */
    private LinearLayout f3930W;

    /* renamed from: X */
    private LinearLayout f3931X;

    /* renamed from: Y */
    private TextView f3932Y;

    /* renamed from: Z */
    private TextView f3933Z;

    /* renamed from: aA */
    private String f3934aA;

    /* renamed from: aB */
    private String f3935aB;

    /* renamed from: aC */
    private String f3936aC;

    /* renamed from: aD */
    private String f3937aD;

    /* renamed from: aE */
    private String f3938aE;

    /* renamed from: aF */
    private String f3939aF;

    /* renamed from: aG */
    private boolean f3940aG;

    /* renamed from: aH */
    private C2075ah f3941aH;

    /* renamed from: aP */
    private boolean f3949aP;

    /* renamed from: aR */
    private int f3951aR;

    /* renamed from: aS */
    private int f3952aS;

    /* renamed from: aT */
    private C0416a f3953aT;

    /* renamed from: aU */
    private Activity f3954aU;

    /* renamed from: aa */
    private TextView f3960aa;

    /* renamed from: ab */
    private TextView f3961ab;

    /* renamed from: ac */
    private TextView f3962ac;

    /* renamed from: ad */
    private TextView f3963ad;

    /* renamed from: af */
    private String f3965af;

    /* renamed from: ag */
    private C3009d f3966ag;

    /* renamed from: ah */
    private ListView f3967ah;

    /* renamed from: aj */
    private C2074ag f3969aj;

    /* renamed from: al */
    private View f3970al;

    /* renamed from: am */
    private View f3971am;

    /* renamed from: an */
    private ImageView f3972an;

    /* renamed from: ao */
    private View f3973ao;

    /* renamed from: ap */
    private ImageView f3974ap;

    /* renamed from: aq */
    private TextView f3975aq;

    /* renamed from: ar */
    private RelativeLayout f3976ar;

    /* renamed from: as */
    private LinearLayout f3977as;

    /* renamed from: at */
    private TextView f3978at;

    /* renamed from: au */
    private LinearLayout f3979au;

    /* renamed from: av */
    private InputMethodManager f3980av;

    /* renamed from: aw */
    private ImageView f3981aw;

    /* renamed from: ay */
    private C2130k f3983ay;

    /* renamed from: az */
    private String f3984az;

    /* renamed from: be */
    private String f3990be;

    /* renamed from: j */
    private boolean f4003j;

    /* renamed from: l */
    private C2210x f4005l;

    /* renamed from: m */
    private Menu f4006m;

    /* renamed from: p */
    private Toast f4009p;

    /* renamed from: q */
    private BuddyProfileFragment f4010q;

    /* renamed from: r */
    private BuddyProfileFragment f4011r;

    /* renamed from: s */
    private C1106c f4012s;

    /* renamed from: t */
    private String f4013t;

    /* renamed from: u */
    private String f4014u;

    /* renamed from: v */
    private String f4015v;

    /* renamed from: w */
    private boolean f4016w;

    /* renamed from: x */
    private boolean f4017x;

    /* renamed from: k */
    private int f4004k = 2;

    /* renamed from: n */
    private MenuItem f4007n = null;

    /* renamed from: o */
    private MenuItem f4008o = null;

    /* renamed from: y */
    private boolean f4018y = false;

    /* renamed from: z */
    private boolean f4019z = false;

    /* renamed from: A */
    private boolean f3908A = false;

    /* renamed from: B */
    private boolean f3909B = false;

    /* renamed from: C */
    private boolean f3910C = true;

    /* renamed from: D */
    private int f3911D = 0;

    /* renamed from: E */
    private boolean f3912E = false;

    /* renamed from: ae */
    private ProgressDialog f3964ae = null;

    /* renamed from: ai */
    private ArrayList<C3016k> f3968ai = new ArrayList<>();

    /* renamed from: ax */
    private boolean f3982ax = false;

    /* renamed from: aI */
    private Bitmap f3942aI = null;

    /* renamed from: aJ */
    private C5007c f3943aJ = null;

    /* renamed from: aK */
    private String f3944aK = "?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&imei=" + C4809aa.m18104a().m18121a("imei", "");

    /* renamed from: aL */
    private String f3945aL = "&size=800";

    /* renamed from: aM */
    private String f3946aM = "&size=100";

    /* renamed from: aN */
    private boolean f3947aN = false;

    /* renamed from: aO */
    private ArrayList<String> f3948aO = new ArrayList<>();

    /* renamed from: aQ */
    private boolean f3950aQ = false;

    /* renamed from: b */
    boolean f3985b = false;

    /* renamed from: aV */
    private LinearLayout f3955aV = null;

    /* renamed from: aW */
    private LinearLayout f3956aW = null;

    /* renamed from: aX */
    private LinearLayout f3957aX = null;

    /* renamed from: aY */
    private LinearLayout f3958aY = null;

    /* renamed from: aZ */
    private LinearLayout f3959aZ = null;

    /* renamed from: ba */
    private TextView f3986ba = null;

    /* renamed from: bb */
    private ImageView f3987bb = null;

    /* renamed from: bc */
    private ImageView f3988bc = null;

    /* renamed from: bd */
    private String f3989bd = C4873ck.m18502c() + "/flag/";

    /* renamed from: bf */
    private boolean f3991bf = false;

    /* renamed from: bg */
    private boolean f3992bg = false;

    /* renamed from: bh */
    private ImageView f3993bh = null;

    /* renamed from: bi */
    private Handler f3994bi = new HandlerC1318fy(this);

    /* renamed from: c */
    View.OnClickListener f3996c = new ViewOnClickListenerC1319fz(this);

    /* renamed from: d */
    Handler f3997d = new HandlerC1321ga(this);

    /* renamed from: e */
    InterfaceC2211y f3998e = new C1323gc(this);

    /* renamed from: f */
    AbsListView.OnScrollListener f3999f = new C1327gg(this);

    /* renamed from: g */
    InterfaceC1336gp f4000g = new C1312fs(this);

    /* renamed from: bj */
    private Handler f3995bj = new HandlerC1313ft(this);

    /* renamed from: h */
    InterfaceC2243d f4001h = new C1314fu(this);

    /* renamed from: i */
    ContentObserver f4002i = new C1315fv(this, new Handler());

    /* renamed from: S */
    static /* synthetic */ int m6772S(BuddyProfileFragment buddyProfileFragment) {
        int i = buddyProfileFragment.f3952aS;
        buddyProfileFragment.f3952aS = i + 1;
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3954aU = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3954aU = null;
    }

    /* renamed from: e */
    private void m6816e() {
        this.f3979au.setVisibility(8);
        this.f3977as.setVisibility(0);
        this.f3940aG = true;
        this.f3969aj.m9288a(this.f4013t);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f4004k == 1) {
            if (this.f4003j) {
                this.f4003j = false;
            } else {
                m6816e();
            }
        }
        if (this.f4018y && this.f4015v != null) {
            this.f4005l.startQuery(6, null, Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(this.f4015v)), null, null, null, null);
            this.f4018y = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f3995bj != null) {
            this.f3995bj.removeCallbacksAndMessages(null);
            this.f3995bj = null;
        }
        if (this.f4005l != null) {
            this.f4005l.removeCallbacksAndMessages(null);
        }
        if (this.f3983ay != null) {
            this.f3983ay.m9541b();
            this.f3983ay.m9546e();
            this.f3983ay.m9548g();
            this.f3983ay = null;
        }
        if (this.f3981aw != null) {
            this.f3981aw.setImageBitmap(null);
            this.f3981aw = null;
        }
        if (this.f3943aJ != null) {
            this.f3943aJ.m19019a((InterfaceC5010f) null);
            this.f3943aJ.m19014a();
        }
        if (this.f3913F != null) {
            this.f3913F.setImageBitmap(null);
            this.f3913F = null;
        }
        if (this.f3914G != null) {
            this.f3914G.setImageBitmap(null);
            this.f3914G = null;
        }
        if (this.f3915H != null) {
            this.f3915H.setImageBitmap(null);
            this.f3915H = null;
        }
        if (this.f3916I != null) {
            this.f3916I.setImageBitmap(null);
            this.f3916I = null;
        }
        if (this.f3925R != null) {
            this.f3925R.setImageBitmap(null);
            this.f3925R = null;
        }
        if (this.f3941aH != null) {
            this.f3941aH.m9321h();
            this.f3941aH.m9317f();
            this.f3941aH.m9308b();
            this.f3941aH.m9311c();
            this.f3941aH = null;
        }
        super.onDestroy();
        m6832j();
        this.f4010q = null;
        this.f4011r = null;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f4006m = menu;
        if (!this.f3912E) {
            menuInflater.inflate(R.menu.buddy_page_menu, menu);
            this.f4007n = menu.findItem(R.id.buddypage_menu_favoriate);
            this.f4008o = menu.findItem(R.id.buddypage_menu_favoriate_off);
            m6857a(this.f4017x);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        C4904y.m18639b("onPrepareOptionsMenu()", f3906a);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case R.id.buddypage_menu_favoriate /* 2131166670 */:
                if (this.f4017x) {
                    this.f4005l.startDelete(2, this.f4012s, C2293m.f8204a, "group_relation_group = 1 AND group_relation_buddy = ? ", new String[]{this.f4013t});
                    m6857a(this.f4017x);
                    this.f4017x = false;
                }
                return true;
            case R.id.buddypage_menu_favoriate_off /* 2131166671 */:
                if (!this.f4017x) {
                    this.f4005l.startQuery(4, this.f4012s, C2293m.f8204a, null, "group_relation_group = 1 ", null, null);
                    m6857a(this.f4017x);
                    this.f4017x = true;
                }
                return true;
            default:
                return true;
        }
    }

    /* renamed from: a */
    public void m6857a(boolean z) {
        if (this.f4007n != null && this.f4008o != null) {
            if (z) {
                this.f4007n.setVisible(true);
                this.f4008o.setVisible(false);
            } else {
                this.f4007n.setVisible(false);
                this.f4008o.setVisible(true);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C4904y.m18639b("onCreateView()", f3906a);
        setHasOptionsMenu(true);
        this.f3954aU.setTitle(getText(R.string.friend_page_title));
        this.f3970al = layoutInflater.inflate(R.layout.layout_mypage_main_header, (ViewGroup) null);
        this.f3971am = layoutInflater.inflate(R.layout.poston_refresh_footer, (ViewGroup) null);
        this.f3973ao = layoutInflater.inflate(R.layout.layout_mypage_main_poston_list, viewGroup, false);
        this.f3943aJ = new C5007c();
        m6820f();
        this.f4005l.startQuery(3, null, C2289i.m10166d(), null, "buddy_no = ? ", new String[]{this.f4013t}, null);
        return this.f3973ao;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4010q = this;
        this.f4011r = this;
        this.f4005l = new C2210x(this.f3954aU.getContentResolver(), this.f3998e);
        this.f4009p = C5179v.m19811a(this.f3954aU, (CharSequence) null, 0);
        if (getArguments() != null) {
            this.f4013t = getArguments().getString("PROFILE_BUDDY_NO");
            this.f4014u = getArguments().getString("PROFILE_BUDDY_NAME");
            this.f3947aN = getArguments().getBoolean("PROFILE_BUDDY_SUGGESTION");
            this.f4019z = getArguments().getBoolean("PROFILE_BUDDY_PROFILE_LOAD_DONE", false);
            this.f3908A = getArguments().getBoolean("PROFILE_BUDDY_PROFILE_IMAGE_LOAD_DONE", false);
            this.f3909B = getArguments().getBoolean("PROFILE_BUDDY_EXIST_REPRESENT", false);
            this.f3911D = getArguments().getInt("PROFILE_BUDDY_PROFILE_IMAGE_COUNT", 0);
            this.f3982ax = getArguments().getBoolean("PROFILE_BUDDY_FROM_BUDDYDIALOG", false);
            this.f3912E = getArguments().getBoolean("PROFILE_BUDDY_IS_HIDDEN_BUDDY", false);
        } else if (this.f3954aU.getIntent() != null) {
            this.f4013t = this.f3954aU.getIntent().getExtras().getString("PROFILE_BUDDY_NO");
            this.f4014u = this.f3954aU.getIntent().getExtras().getString("PROFILE_BUDDY_NAME");
            this.f3947aN = this.f3954aU.getIntent().getExtras().getBoolean("PROFILE_BUDDY_SUGGESTION");
            this.f4019z = this.f3954aU.getIntent().getExtras().getBoolean("PROFILE_BUDDY_PROFILE_LOAD_DONE", false);
            this.f3908A = this.f3954aU.getIntent().getExtras().getBoolean("PROFILE_BUDDY_PROFILE_IMAGE_LOAD_DONE", false);
            this.f3982ax = this.f3954aU.getIntent().getExtras().getBoolean("PROFILE_BUDDY_FROM_BUDDYDIALOG", false);
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("*********** BUDDY NO : " + this.f4013t, f3906a);
        }
        if (!TextUtils.isEmpty(this.f4014u) && C4904y.f17872b) {
            C4904y.m18639b("*********** BUDDY NAME : " + this.f4014u, f3906a);
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("*********** BUDDY SUGGESTION : " + this.f3947aN, f3906a);
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("*********** BUDDY FROM BUDDY DIALOG : " + this.f3982ax, f3906a);
        }
        if (this.f4013t == null) {
            this.f3954aU.finish();
        }
        if (this.f4014u == null) {
            this.f4014u = "";
        }
        this.f3983ay = new C2130k(this.f3995bj);
        this.f3941aH = new C2075ah(this.f3995bj);
        this.f3980av = (InputMethodManager) this.f3954aU.getSystemService("input_method");
    }

    /* renamed from: f */
    private void m6820f() {
        this.f3953aT = new C0416a();
        f3907ak = C4809aa.m18104a().m18121a("chaton_id", "");
        this.f3969aj = new C2074ag(this.f3997d);
        this.f3977as = (LinearLayout) this.f3971am.findViewById(R.id.footer_progress);
        this.f3978at = (TextView) this.f3971am.findViewById(R.id.footer_content);
        this.f3979au = (LinearLayout) this.f3971am.findViewById(R.id.footer_content_layout);
        this.f3979au.setVisibility(8);
        this.f3976ar = (RelativeLayout) this.f3970al.findViewById(R.id.mypage_poston_write_frame);
        this.f3974ap = (ImageView) this.f3970al.findViewById(R.id.mypage_main_poston_write);
        this.f3975aq = (TextView) this.f3970al.findViewById(R.id.mypage_write_text);
        this.f3976ar.setOnClickListener(this.f3996c);
        this.f3926S = (TextView) this.f3970al.findViewById(R.id.mypage_main_profile_name);
        this.f3937aD = "";
        this.f3938aE = "";
        this.f3939aF = null;
        this.f4003j = false;
        this.f3940aG = true;
        this.f3964ae = (ProgressDialog) new C4923p(this.f3954aU).m18724a(R.string.buddy_list_progress_dialog_message);
        this.f3936aC = CommonApplication.m18732r().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        this.f3934aA = CommonApplication.m18732r().getCacheDir() + "/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(14)
    /* renamed from: b */
    public void m6799b(int i) {
        this.f4004k = i;
        if (i == 1) {
            this.f3943aJ.m19019a((InterfaceC5010f) this);
            this.f3913F = (ImageView) this.f3970al.findViewById(R.id.mypage_main_profile_image_represent);
            this.f3913F.setFocusable(false);
            this.f3913F.setClickable(false);
            this.f3917J = (ImageView) this.f3970al.findViewById(R.id.profile_image_loading);
            this.f3914G = (ImageView) this.f3970al.findViewById(R.id.mypage_main_profile_image_sub1);
            this.f3914G.setFocusable(false);
            this.f3914G.setClickable(false);
            this.f3918K = (ImageView) this.f3970al.findViewById(R.id.profile_image_1_loading);
            this.f3915H = (ImageView) this.f3970al.findViewById(R.id.mypage_main_profile_image_sub2);
            this.f3915H.setFocusable(false);
            this.f3915H.setClickable(false);
            this.f3919L = (ImageView) this.f3970al.findViewById(R.id.profile_image_2_loading);
            this.f3916I = (ImageView) this.f3970al.findViewById(R.id.mypage_main_profile_image_sub3);
            this.f3916I.setFocusable(false);
            this.f3916I.setClickable(false);
            this.f3920M = (ImageView) this.f3970al.findViewById(R.id.profile_image_3_loading);
            this.f3925R = (ImageView) this.f3970al.findViewById(R.id.mypage_profile_more);
            this.f3927T = (TextView) this.f3970al.findViewById(R.id.mypage_main_profile_status_message);
            this.f3972an = (ImageView) this.f3970al.findViewById(R.id.mypage_main_profile_status_icon);
            if (this.f4012s.m7041D() == 1) {
                this.f3972an.setImageResource(R.drawable.buddies_webonly);
                this.f3972an.setVisibility(0);
            } else if (getActivity() != null && C2923b.m12153h(getActivity()) && BuddyFragment.m6463b(this.f4013t)) {
                this.f3972an.setImageResource(R.drawable.buddies_videocall);
                this.f3972an.setVisibility(0);
            } else {
                this.f3972an.setVisibility(8);
            }
            this.f3929V = (ImageView) this.f3970al.findViewById(R.id.mypage_main_profile_image_camera);
            this.f3929V.setVisibility(8);
            this.f3928U = (ImageButton) this.f3970al.findViewById(R.id.btn_mypage_info);
            if (!this.f3912E) {
                this.f3928U.setOnClickListener(this.f3996c);
            } else {
                this.f3928U.setVisibility(8);
            }
            this.f3930W = (LinearLayout) this.f3970al.findViewById(R.id.mypage_samsungaccount_layout);
            this.f3931X = (LinearLayout) this.f3970al.findViewById(R.id.mypage_birthday_layout);
            this.f3932Y = (TextView) this.f3970al.findViewById(R.id.mypage_info_phonenumber1);
            this.f3933Z = (TextView) this.f3970al.findViewById(R.id.mypage_info_phonenumber2);
            this.f3960aa = (TextView) this.f3970al.findViewById(R.id.mypage_info_phonenumber3);
            this.f3961ab = (TextView) this.f3970al.findViewById(R.id.mypage_info_phonenumber4);
            this.f3962ac = (TextView) this.f3970al.findViewById(R.id.mypage_info_samsungaccount);
            this.f3963ad = (TextView) this.f3970al.findViewById(R.id.mypage_info_birthday);
            if (!TextUtils.isEmpty(this.f4012s.m7044G())) {
                List listAsList = Arrays.asList(this.f4012s.m7044G().split(" "));
                if (listAsList.size() == 4) {
                    this.f3932Y.setText((CharSequence) listAsList.get(0));
                    this.f3933Z.setText((CharSequence) listAsList.get(1));
                    this.f3960aa.setText((CharSequence) listAsList.get(2));
                    this.f3961ab.setText((CharSequence) listAsList.get(3));
                    this.f3932Y.setVisibility(0);
                    this.f3933Z.setVisibility(0);
                    this.f3960aa.setVisibility(0);
                    this.f3961ab.setVisibility(0);
                } else if (listAsList.size() == 3) {
                    this.f3932Y.setText((CharSequence) listAsList.get(0));
                    this.f3933Z.setText((CharSequence) listAsList.get(1));
                    this.f3960aa.setText((CharSequence) listAsList.get(2));
                    this.f3932Y.setVisibility(0);
                    this.f3933Z.setVisibility(0);
                    this.f3960aa.setVisibility(0);
                } else if (listAsList.size() == 2) {
                    this.f3932Y.setText((CharSequence) listAsList.get(0));
                    this.f3933Z.setText((CharSequence) listAsList.get(1));
                    this.f3932Y.setVisibility(0);
                    this.f3933Z.setVisibility(0);
                } else if (listAsList.size() == 1) {
                    this.f3932Y.setText((CharSequence) listAsList.get(0));
                    this.f3932Y.setVisibility(0);
                }
            }
            if (!TextUtils.isEmpty(this.f4012s.m7055d())) {
                this.f3962ac.setText(this.f4012s.m7055d());
                this.f3930W.setVisibility(0);
            } else {
                this.f3930W.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.f4012s.m7059h())) {
                this.f3963ad.setText(this.f4012s.m7059h());
                this.f3931X.setVisibility(0);
            } else {
                this.f3931X.setVisibility(8);
            }
            this.f3921N = new C1337gq(this.f3913F);
            this.f3922O = new C1337gq(this.f3914G);
            this.f3923P = new C1337gq(this.f3915H);
            this.f3924Q = new C1337gq(this.f3916I);
            if (this.f4017x) {
                m6857a(true);
            } else {
                m6857a(false);
            }
            try {
                C1331gk.m7453a(this.f3954aU).m7465a(this.f3921N, this.f3922O, this.f3923P, this.f3924Q, this.f4013t, this.f4000g);
            } catch (Exception e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, getClass().getSimpleName());
                }
            } catch (OutOfMemoryError e2) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e2, getClass().getSimpleName());
                }
            }
            this.f3926S.setText(this.f4012s.m7051b());
            this.f3926S.setContentDescription(this.f4012s.m7051b());
            this.f3926S.setOnTouchListener(new ViewOnTouchListenerC1311fr(this));
            if (!TextUtils.isEmpty(this.f4012s.m7054c())) {
                this.f3927T.setText(this.f4012s.m7054c());
                this.f3927T.setOnTouchListener(new ViewOnTouchListenerC1316fw(this));
            }
            this.f3967ah = (ListView) this.f3973ao.findViewById(R.id.mypage_main_poston_list);
            this.f3981aw = (ImageView) this.f3973ao.findViewById(R.id.change_skin_bg);
            m6782a(this.f3981aw);
            registerForContextMenu(this.f3967ah);
            this.f3940aG = true;
            this.f3969aj.m9288a(this.f4013t);
            this.f3966ag = new C3009d(this.f3967ah, this.f3954aU, this.f3968ai, R.layout.list_item_common_9, this.f4013t, this.f3943aJ);
            this.f3966ag.m12364a(this);
            this.f3967ah.addHeaderView(this.f3970al, null, false);
            this.f3967ah.setFocusable(false);
            this.f3967ah.setFocusableInTouchMode(false);
            this.f3967ah.setItemsCanFocus(true);
            this.f3967ah.addFooterView(this.f3971am, null, false);
            this.f3967ah.setAdapter((ListAdapter) this.f3966ag);
            this.f3967ah.setScrollbarFadingEnabled(true);
            this.f3967ah.setOnScrollListener(this.f3999f);
            this.f3977as.setVisibility(0);
            C4904y.m18639b("mProfileImageHistoryDone : " + this.f3908A, f3906a);
            C4904y.m18639b("mProfileAllDone : " + this.f4019z, f3906a);
            if (!this.f3908A) {
                this.f3941aH.m9310b(this.f4013t, "5");
            }
            if (GlobalApplication.m10289h()) {
                this.f3967ah.setOnDragListener(new C1317fx(this));
            }
            int iM10677a = C2471v.m10677a(this.f3954aU);
            if (-3 == iM10677a || -2 == iM10677a) {
                C5179v.m19810a(this.f3954aU, R.string.popup_no_network_connection, 0).show();
            }
            if (this.f3908A) {
                if (this.f3909B) {
                    if (this.f3911D > 4) {
                        this.f3925R.setVisibility(0);
                        return;
                    }
                    return;
                } else {
                    if (this.f3911D > 3) {
                        this.f3925R.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (i == 2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m6802b(String str) {
        return new File(this.f3989bd).exists() && new File(this.f3989bd, new StringBuilder().append(str).append(".png").toString()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6807c(String str) {
        Bitmap bitmapM18142a;
        File file = new File(this.f3989bd, str + ".png");
        if (file.exists()) {
            try {
                if (file.length() > 0 && (bitmapM18142a = C4812ad.m18142a(getActivity(), Uri.fromFile(file))) != null) {
                    this.f3988bc.setVisibility(0);
                    this.f3988bc.setImageBitmap(bitmapM18142a);
                }
            } catch (Exception e) {
                C4904y.m18635a(e, f3906a);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6811d(String str) {
        new C2128i(this.f3997d).m9531g(str);
    }

    /* renamed from: a */
    public boolean m6858a() {
        C4904y.m18639b("Buddy didn't set Coverstory ", getClass().getSimpleName());
        String strM9895a = C2195i.m9895a();
        if (strM9895a != null) {
            if (!BuddyDialog.m7180a(strM9895a, this.f4013t, this.f3936aC, this.f3934aA, this.f3981aw)) {
                this.f3984az = strM9895a;
                this.f3983ay.m9540a(strM9895a, Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
            }
            return true;
        }
        C4904y.m18639b(" Random ERROR !!", getClass().getSimpleName());
        this.f3983ay.m9543b(Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m6859b() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 499
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyProfileFragment.m6859b():void");
    }

    /* renamed from: a */
    void m6853a(C0778b c0778b) throws Throwable {
        if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
            GetPostONList getPostONList = (GetPostONList) c0778b.m3110e();
            if (getPostONList.postonlist.size() > 0) {
                this.f3937aD = getPostONList.postonlist.get(0).hasmore;
                this.f3938aE = getPostONList.postonlist.get(0).endtime;
                this.f3939aF = getPostONList.postonlist.get(0).isblind;
            }
            m6859b();
        } else {
            m6832j();
            if (this.f3977as != null) {
                this.f3977as.setVisibility(8);
            }
            if (this.f3939aF != null && this.f3939aF.equals("true")) {
                this.f3968ai.clear();
                if (this.f3966ag != null) {
                    this.f3966ag.notifyDataSetChanged();
                }
                if (this.f4014u == null || this.f4014u.length() == 0) {
                    if (C4904y.f17875e) {
                        C4904y.m18634a("Buddy name is null", f3906a);
                    }
                    this.f4014u = getString(R.string.unknown);
                }
                this.f3978at.setText(String.format(getResources().getString(R.string.poston_not_use), this.f4014u));
                this.f3979au.setVisibility(0);
                this.f3974ap.setVisibility(8);
                this.f3975aq.setVisibility(8);
                this.f3976ar.setClickable(false);
            } else if (this.f3939aF != null && this.f3939aF.equals("false")) {
                this.f3979au.setVisibility(8);
            } else if (this.f3939aF == null) {
                this.f3978at.setText(String.format(getResources().getString(R.string.poston_not_posted), new Object[0]));
                this.f3979au.setVisibility(0);
            }
            if (this.f3966ag != null) {
                this.f3966ag.notifyDataSetChanged();
            }
        }
        this.f3940aG = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public boolean m6824g() {
        if (this.f4013t.length() < 19 || !this.f4013t.startsWith("10") || TextUtils.isEmpty(this.f4012s.m7056e())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public String m6815e(String str) {
        return str.replaceAll("\\D+", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m6803b(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (C4904y.f17872b) {
            C4904y.m18639b("[isMatchNumber] matching for original Number : " + ((String) null), f3906a);
        }
        if (length > 8 && length2 > 8) {
            String strSubstring = str.substring(length - 8);
            String strSubstring2 = str2.substring(length2 - 8);
            C4904y.m18639b("[isMatchNumber] matching for contact Number : " + strSubstring2, f3906a);
            if (strSubstring.equals(strSubstring2)) {
                C4904y.m18639b("[isMatchNumber] found match number : " + str2, f3906a);
                return true;
            }
            C4904y.m18639b("[isMatchNumber] phone number not matched", f3906a);
            return false;
        }
        C4904y.m18639b("[isMatchNumber] phone number length is less than 8", f3906a);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m6828h() {
        C5179v.m19811a(this.f3954aU, getResources().getString(R.string.toast_network_unable), 0).show();
        this.f3954aU.finish();
    }

    @Override // com.sec.chaton.poston.InterfaceC3015j
    /* renamed from: a */
    public void mo6854a(C3016k c3016k) {
        if (!C4847bl.m18333a()) {
            Intent intent = new Intent(getActivity(), (Class<?>) PostONDetailActivity.class);
            intent.putExtra(PostONDetailFragment.f10867a, c3016k.m12367b());
            intent.putExtra(PostONDetailFragment.f10869b, c3016k.m12368c());
            intent.putExtra(PostONDetailFragment.f10870c, c3016k.m12369d());
            intent.putExtra(PostONDetailFragment.f10873f, c3016k.m12370e());
            intent.putExtra(PostONDetailFragment.f10871d, c3016k.m12371f());
            intent.putExtra(PostONDetailFragment.f10872e, C3009d.m12358a(Long.parseLong(c3016k.m12371f())));
            intent.putExtra(PostONDetailFragment.f10874g, c3016k.m12376k());
            intent.putExtra(PostONDetailFragment.f10882o, "BUDDY_PAGE");
            intent.putExtra(PostONDetailFragment.f10876i, c3016k.m12365a());
            intent.putExtra(PostONDetailFragment.f10879l, c3016k.m12373h());
            if (!c3016k.m12375j().isEmpty()) {
                Iterator<C2179ae> it = c3016k.m12375j().iterator();
                while (it.hasNext()) {
                    C2179ae next = it.next();
                    if (next.m9726a().equals(C3009d.f11133d)) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("getMultimediaDownload has geo tag, content.getUrl() = " + next.m9728b(), f3906a);
                        }
                        intent.putExtra(PostONDetailFragment.f10880m, next.m9728b());
                    } else {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("getMultimediaDownload has Multimedia, content.getUrl() = " + next.m9728b() + " / content.getMetaType() = " + next.m9726a(), f3906a);
                        }
                        intent.putExtra(PostONDetailFragment.f10877j, next.m9728b());
                        intent.putExtra(PostONDetailFragment.f10878k, next.m9726a());
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

    @Override // com.sec.chaton.poston.InterfaceC3015j
    /* renamed from: a */
    public void mo6856a(String str, String str2) {
        if (!C4847bl.m18333a()) {
            Intent intent = new Intent(getActivity(), (Class<?>) BuddyDialog.class);
            intent.putExtra("BUDDY_DIALOG_BUDDY_NO", str);
            intent.putExtra("BUDDY_DIALOG_BUDDY_NAME", str2);
            if (getActivity() instanceof Activity) {
                intent.setFlags(67108864);
            } else {
                intent.setFlags(335544320);
            }
            startActivity(intent);
        }
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        C3016k c3016k;
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        ContextMenuC1056a contextMenuC1056a = new ContextMenuC1056a(this.f3954aU, contextMenu);
        if ((contextMenuInfo instanceof AdapterView.AdapterContextMenuInfo) && (c3016k = (C3016k) this.f3967ah.getAdapter().getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position)) != null) {
            String strM12368c = c3016k.m12368c();
            c3016k.m12371f();
            String strM12365a = c3016k.m12365a();
            if (strM12368c.equals(f3907ak)) {
                contextMenuC1056a.setHeaderTitle(R.string.setting_interaction_me);
                contextMenuC1056a.add(0, 2000, 1, R.string.memo_delete_context_menu).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC1324gd(this, strM12365a));
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        if (i == 9 && i2 == -1) {
            C4904y.m18646e("Write PostON from Write page Success", f3906a);
            this.f3940aG = true;
            this.f4003j = true;
            this.f3937aD = intent.getExtras().getString("HAS_MORE");
            this.f3938aE = intent.getExtras().getString("END_TIME");
            this.f3939aF = intent.getExtras().getString("IS_BLIND");
            m6859b();
            this.f3940aG = false;
            return;
        }
        if (i == 10 && i2 == -1) {
            if (intent.getExtras().getBoolean("IS_DELETED")) {
                C4904y.m18646e("Delete PostON from Detail page Success", f3906a);
                this.f3940aG = true;
                this.f4003j = true;
                this.f3937aD = intent.getExtras().getString("HAS_MORE");
                this.f3938aE = intent.getExtras().getString("END_TIME");
                this.f3939aF = intent.getExtras().getString("IS_BLIND");
                m6859b();
                this.f3940aG = false;
                return;
            }
            return;
        }
        if (i == 7 && i2 == -1) {
            C4904y.m18646e("PROFILE_EDIT_BUDDY_NAME", f3906a);
            String string = intent.getExtras().getString("PROFILE_BUDDY_RENAME");
            this.f4014u = string;
            this.f3965af = string;
            this.f3926S.setText(this.f4014u);
        }
    }

    /* renamed from: a */
    public static boolean m6784a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m6830i() {
        if (this.f3954aU != null && !this.f3954aU.isFinishing()) {
            this.f3964ae.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m6832j() {
        if (this.f3954aU != null && !this.f3954aU.isFinishing()) {
            this.f3964ae.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public List<String> m6834k() {
        ArrayList arrayList = new ArrayList();
        String strM7057f = this.f4012s.m7057f();
        if (!TextUtils.isEmpty(strM7057f)) {
            StringTokenizer stringTokenizer = new StringTokenizer(strM7057f, "|");
            while (stringTokenizer.hasMoreTokens()) {
                new String();
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.length() >= 19 && strNextToken.startsWith("10")) {
                    C4904y.m18639b("chaton id : " + strNextToken, f3906a);
                } else if (strNextToken.startsWith(Spam.ACTIVITY_CANCEL)) {
                    C4904y.m18639b("pin number : " + strNextToken, f3906a);
                } else {
                    C4904y.m18639b("msisdn: " + strNextToken, f3906a);
                    arrayList.add(strNextToken);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public void m6861c() {
        if (this.f3921N != null) {
            if (this.f3921N.m7486c()) {
                this.f3921N.m7482a().setOnClickListener(this.f3996c);
                this.f3921N.m7482a().setFocusable(true);
                this.f3921N.m7482a().setClickable(true);
            } else {
                this.f3921N.m7482a().setOnClickListener(null);
                this.f3921N.m7482a().setFocusable(false);
                this.f3921N.m7482a().setClickable(false);
            }
        }
        if (this.f3922O != null) {
            if (this.f3922O.m7486c()) {
                this.f3922O.m7482a().setOnClickListener(this.f3996c);
                this.f3922O.m7482a().setFocusable(true);
                this.f3922O.m7482a().setClickable(true);
            } else {
                this.f3922O.m7482a().setFocusable(false);
                this.f3922O.m7482a().setClickable(false);
            }
        }
        if (this.f3923P != null) {
            if (this.f3923P.m7486c()) {
                this.f3923P.m7482a().setOnClickListener(this.f3996c);
                this.f3923P.m7482a().setFocusable(true);
                this.f3923P.m7482a().setClickable(true);
            } else {
                this.f3923P.m7482a().setFocusable(false);
                this.f3923P.m7482a().setClickable(false);
            }
        }
        if (this.f3924Q != null) {
            if (this.f3924Q.m7486c()) {
                this.f3924Q.m7482a().setOnClickListener(this.f3996c);
                this.f3923P.m7482a().setFocusable(true);
                this.f3923P.m7482a().setClickable(true);
            } else {
                this.f3924Q.m7482a().setFocusable(false);
                this.f3924Q.m7482a().setClickable(false);
            }
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("setClickListenerOnImage", f3906a);
            if (this.f3921N != null) {
                C4904y.m18639b("mMainImage Clickable: " + this.f3921N.m7486c(), f3906a);
            }
            if (this.f3922O != null) {
                C4904y.m18639b("mThumbImage1 Clickable: " + this.f3922O.m7486c(), f3906a);
            }
            if (this.f3923P != null) {
                C4904y.m18639b("mThumbImage2 Clickable: " + this.f3923P.m7486c(), f3906a);
            }
            if (this.f3924Q != null) {
                C4904y.m18639b("mThumbImage3 Clickable: " + this.f3924Q.m7486c(), f3906a);
            }
        }
        if (this.f3925R != null) {
            this.f3925R.setOnClickListener(this.f3996c);
        }
    }

    /* renamed from: d */
    public void m6862d() {
        C1331gk.m7453a(this.f3954aU).m7464a(this.f3921N, this.f3922O, this.f3923P, this.f3924Q, this.f4013t);
        m6861c();
    }

    /* renamed from: a */
    public void m6851a(int i) {
        C1331gk.m7453a(this.f3954aU).m7466a(this.f3922O, this.f3923P, this.f3924Q, this.f4013t, i - 1);
    }

    @Override // com.sec.common.p132g.InterfaceC5010f
    /* renamed from: a */
    public void mo6852a(View view, AbstractRunnableC5005a<?> abstractRunnableC5005a) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onFailed / task.isSuccess() : " + abstractRunnableC5005a.m18999m() + " / " + abstractRunnableC5005a.toString(), f3906a);
        }
        if ((abstractRunnableC5005a instanceof CallableC1330gj) && this.f3910C && view != null) {
            if (this.f3921N != null && view.equals(this.f3913F)) {
                this.f3921N.m7484a(false);
                if (C4904y.f17872b) {
                    C4904y.m18639b("mMainImage.setClickableState(false)", f3906a);
                }
            } else if (this.f3922O != null && view.equals(this.f3922O.m7482a())) {
                this.f3922O.m7484a(false);
                if (C4904y.f17872b) {
                    C4904y.m18639b("mThumbImage1.setClickableState(false)", f3906a);
                }
            } else if (this.f3923P != null && view.equals(this.f3923P.m7482a())) {
                this.f3923P.m7484a(false);
                if (C4904y.f17872b) {
                    C4904y.m18639b("mThumbImage2.setClickableState(false)", f3906a);
                }
            } else if (this.f3924Q != null && view.equals(this.f3924Q.m7482a())) {
                this.f3924Q.m7484a(false);
                if (C4904y.f17872b) {
                    C4904y.m18639b("mThumbImage3.setClickableState(false)", f3906a);
                }
            }
            this.f3952aS--;
            if (C4904y.f17872b) {
                C4904y.m18639b("mTotalProfileImageCount: " + this.f3952aS, f3906a);
            }
            if (this.f3952aS == 0) {
                m6861c();
            }
        }
    }

    @Override // com.sec.common.p132g.InterfaceC5010f
    /* renamed from: b */
    public void mo6860b(View view, AbstractRunnableC5005a<?> abstractRunnableC5005a) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onCompleted / task.isSuccess() : " + abstractRunnableC5005a.m18999m() + " / " + abstractRunnableC5005a.toString(), f3906a);
        }
        if (abstractRunnableC5005a instanceof CallableC1330gj) {
            if (this.f3910C && view != null) {
                if (this.f3921N != null && view.equals(this.f3913F)) {
                    this.f3921N.m7484a(true);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("mMainImage.setClickableState(true)", f3906a);
                    }
                } else if (this.f3922O != null && view.equals(this.f3922O.m7482a())) {
                    this.f3922O.m7484a(true);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("mThumbImage1.setClickableState(true)", f3906a);
                    }
                } else if (this.f3923P != null && view.equals(this.f3923P.m7482a())) {
                    this.f3923P.m7484a(true);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("mThumbImage2.setClickableState(true)", f3906a);
                    }
                } else if (this.f3924Q != null && view.equals(this.f3924Q.m7482a())) {
                    this.f3924Q.m7484a(true);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("mThumbImage3.setClickableState(true)", f3906a);
                    }
                }
                this.f3952aS--;
                if (C4904y.f17872b) {
                    C4904y.m18639b("mTotalProfileImageCount: " + this.f3952aS, f3906a);
                }
                if (this.f3952aS == 0) {
                    m6861c();
                    return;
                }
                return;
            }
            this.f3988bc.setVisibility(0);
        }
    }

    /* renamed from: a */
    private void m6782a(ImageView imageView) {
        if (isAdded() && getActivity() != null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("setCoverstory is called in BPF", f3906a);
            }
            try {
                String str = this.f3954aU.getApplicationContext().getCacheDir() + "/" + this.f4013t + "/coverstory/";
                if (!new File(str + "coverstory.jpg").exists()) {
                    C4904y.m18639b("setCoverstory CoverStory is empty. loadDefaultCoverStory() ", f3906a);
                    C1331gk.m7458a(imageView);
                    if (this.f3982ax) {
                        C4904y.m18639b("getBuddiesCoverStory in case of mProfileFromBuddyDialog ", f3906a);
                        if (this.f3983ay == null) {
                            this.f3983ay = new C2130k(this.f3995bj);
                        }
                        this.f3983ay.m9538a(this.f4013t);
                        return;
                    }
                    return;
                }
                C4904y.m18639b("setCoverstory", f3906a);
                if (imageView != null) {
                    imageView.setImageURI(Uri.parse(str + "coverstory.jpg"));
                } else {
                    C4904y.m18639b("mCoverstoryImg is null. loadDefaultCoverStory()", f3906a);
                }
            } catch (Exception e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, getClass().getSimpleName());
                }
            }
        }
    }

    @Override // com.sec.chaton.poston.InterfaceC3015j
    /* renamed from: a */
    public void mo6855a(String str) {
        ((InterfaceC1328gh) getActivity()).mo3088b(this.f4013t, str);
    }
}
