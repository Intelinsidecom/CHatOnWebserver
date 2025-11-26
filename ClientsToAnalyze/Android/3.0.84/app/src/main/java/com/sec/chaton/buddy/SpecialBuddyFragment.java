package com.sec.chaton.buddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.buddy.p019a.C0514d;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1328f;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p025d.C1336n;
import com.sec.chaton.p027e.C1388af;
import com.sec.chaton.p027e.C1390ah;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.chaton.p035io.entry.inner.SpecialUser;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3347i;
import com.sec.widget.C3641ai;

/* loaded from: classes.dex */
public class SpecialBuddyFragment extends Fragment {

    /* renamed from: A */
    private TextView f2264A;

    /* renamed from: B */
    private Button f2265B;

    /* renamed from: C */
    private ImageButton f2266C;

    /* renamed from: D */
    private ImageButton f2267D;

    /* renamed from: E */
    private ImageButton f2268E;

    /* renamed from: F */
    private ImageButton f2269F;

    /* renamed from: G */
    private ImageButton f2270G;

    /* renamed from: H */
    private ViewGroup f2271H;

    /* renamed from: I */
    private View f2272I;

    /* renamed from: J */
    private View f2273J;

    /* renamed from: K */
    private View f2274K;

    /* renamed from: L */
    private TextView f2275L;

    /* renamed from: M */
    private ImageView f2276M;

    /* renamed from: N */
    private View f2277N;

    /* renamed from: O */
    private TextView f2278O;

    /* renamed from: P */
    private ImageView f2279P;

    /* renamed from: Q */
    private LinearLayout f2280Q;

    /* renamed from: R */
    private TextView f2281R;

    /* renamed from: S */
    private ViewGroup f2282S;

    /* renamed from: T */
    private Button f2283T;

    /* renamed from: U */
    private Button f2284U;

    /* renamed from: V */
    private Button f2285V;

    /* renamed from: W */
    private Button f2286W;

    /* renamed from: Y */
    private Activity f2288Y;

    /* renamed from: aa */
    private Menu f2291aa;

    /* renamed from: ab */
    private MenuItem f2292ab;

    /* renamed from: ac */
    private MenuItem f2293ac;

    /* renamed from: ad */
    private LinearLayout f2294ad;

    /* renamed from: ae */
    private ImageView f2295ae;

    /* renamed from: af */
    private boolean f2296af;

    /* renamed from: f */
    private C1377u f2301f;

    /* renamed from: g */
    private C0514d f2302g;

    /* renamed from: h */
    private C1336n f2303h;

    /* renamed from: i */
    private ProgressDialog f2304i;

    /* renamed from: j */
    private Toast f2305j;

    /* renamed from: k */
    private String f2306k;

    /* renamed from: l */
    private String f2307l;

    /* renamed from: r */
    private ImageView f2313r;

    /* renamed from: s */
    private TextView f2314s;

    /* renamed from: t */
    private TextView f2315t;

    /* renamed from: u */
    private boolean f2316u;

    /* renamed from: v */
    private View f2317v;

    /* renamed from: w */
    private TextView f2318w;

    /* renamed from: x */
    private TextView f2319x;

    /* renamed from: y */
    private TextView f2320y;

    /* renamed from: z */
    private TextView f2321z;

    /* renamed from: m */
    private int f2308m = 0;

    /* renamed from: n */
    private int f2309n = 0;

    /* renamed from: o */
    private long f2310o = 0;

    /* renamed from: p */
    private boolean f2311p = false;

    /* renamed from: q */
    private boolean f2312q = false;

    /* renamed from: X */
    private boolean f2287X = false;

    /* renamed from: Z */
    private Bitmap f2289Z = null;

    /* renamed from: a */
    View.OnClickListener f2290a = new ViewOnClickListenerC0759hp(this);

    /* renamed from: b */
    InterfaceC1378v f2297b = new C0760hq(this);

    /* renamed from: c */
    InterfaceC1413d f2298c = new C0761hr(this);

    /* renamed from: d */
    Handler f2299d = new HandlerC0762hs(this);

    /* renamed from: e */
    ContentObserver f2300e = new C0765hv(this, new Handler());

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f2288Y = activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f2288Y = null;
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11453c("[LIFE] onCreate, isTaskRoot: " + this.f2288Y.isTaskRoot() + ", Task ID: " + this.f2288Y.getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (getArguments() != null) {
            this.f2306k = getArguments().getString("specialuserid");
            this.f2307l = getArguments().getString("speicalusername");
            if (!getArguments().containsKey("specialBuddyAdded")) {
                this.f2311p = C1357af.m5998c(CommonApplication.m11493l(), this.f2306k);
            } else {
                this.f2311p = getArguments().getBoolean("specialBuddyAdded");
            }
            if (GlobalApplication.m6456e()) {
                this.f2309n = getArguments().getInt("CURRENT_POSITION");
            }
        } else {
            this.f2306k = this.f2288Y.getIntent().getExtras().getString("specialuserid");
            this.f2307l = this.f2288Y.getIntent().getExtras().getString("speicalusername");
            if (!this.f2288Y.getIntent().getExtras().containsKey("specialBuddyAdded")) {
                this.f2311p = C1357af.m5998c(CommonApplication.m11493l(), this.f2306k);
            } else {
                this.f2311p = this.f2288Y.getIntent().getExtras().getBoolean("specialBuddyAdded");
            }
            if (GlobalApplication.m6456e()) {
                this.f2309n = this.f2288Y.getIntent().getExtras().getInt("CURRENT_POSITION");
            }
        }
        if (!GlobalApplication.m6456e()) {
            this.f2309n = this.f2288Y.getIntent().getExtras().getInt("CURRENT_POSITION");
        }
        if (this.f2306k == null) {
            this.f2288Y.finish();
        }
        this.f2304i = new ProgressDialogC3265l(this.f2288Y, false);
        this.f2304i.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        this.f2305j = C3641ai.m13211a(CommonApplication.m11493l(), (CharSequence) null, 0);
        this.f2301f = new C1377u(this.f2288Y.getContentResolver(), this.f2297b);
        getActivity().getContentResolver().registerContentObserver(C1390ah.f5188a, true, this.f2300e);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f2294ad = new LinearLayout(this.f2288Y);
        this.f2294ad.setOrientation(1);
        this.f2294ad.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        m3890d();
        return this.f2294ad;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!GlobalApplication.m6456e()) {
        }
        if (m3892d(false)) {
            new C1330h(this.f2299d).m5722a(this.f2306k, -1, -1);
        }
        if (this.f2311p) {
            this.f2301f.startQuery(1, null, C1390ah.f5188a, null, "buddy_no = ? ", new String[]{this.f2306k}, null);
        } else {
            this.f2301f.startQuery(4, null, C1388af.f5186a, null, "buddy_no = ? ", new String[]{this.f2306k}, null);
        }
        C3250y.m11453c("[LIFE] onResume, isTaskRoot: " + this.f2288Y.isTaskRoot() + ", Task ID: " + this.f2288Y.getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        m3913m();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        getActivity().getApplicationContext().getContentResolver().unregisterContentObserver(this.f2300e);
        m3908k();
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (!GlobalApplication.m6456e()) {
            this.f2291aa = menu;
            menuInflater.inflate(R.menu.livepartner_page_menu, menu);
            this.f2292ab = menu.findItem(R.id.livepartenr_menu_like);
            this.f2293ac = menu.findItem(R.id.livepartenr_menu_unlike);
            m3884b(this.f2316u);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        if (m3892d(true)) {
            switch (menuItem.getItemId()) {
                case R.id.livepartenr_menu_like /* 2131166617 */:
                    if (this.f2316u) {
                        this.f2316u = this.f2316u ? false : true;
                        new C1330h(this.f2299d).m5750f(this.f2302g.m4000a());
                        m3877a(true);
                        m3884b(this.f2316u);
                        break;
                    }
                    break;
                case R.id.livepartenr_menu_unlike /* 2131166618 */:
                    if (!this.f2316u) {
                        this.f2316u = this.f2316u ? false : true;
                        new C1330h(this.f2299d).m5746e(this.f2302g.m4000a());
                        m3877a(true);
                        m3884b(this.f2316u);
                        break;
                    }
                    break;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3877a(boolean z) {
        if (Build.VERSION.SDK_INT >= 11 && !GlobalApplication.m6456e()) {
            if (z) {
                this.f2292ab.setActionView(R.layout.layout_refresh_progressbar);
                this.f2293ac.setActionView(R.layout.layout_refresh_progressbar);
            } else {
                this.f2292ab.setActionView((View) null);
                this.f2293ac.setActionView((View) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3884b(boolean z) {
        if (this.f2288Y != null && this.f2292ab != null && this.f2293ac != null) {
            if (z) {
                this.f2292ab.setVisible(true);
                this.f2293ac.setVisible(false);
            } else {
                this.f2292ab.setVisible(false);
                this.f2293ac.setVisible(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3887c(boolean z) {
        if (this.f2288Y != null) {
            if (z) {
                this.f2295ae.setImageResource(R.drawable.actionbar_ic_live_01);
            } else {
                this.f2295ae.setImageResource(R.drawable.actionbar_ic_live_02);
            }
        }
    }

    /* renamed from: a */
    private void m3876a(String str) {
        if (this.f2288Y != null) {
            this.f2315t.setContentDescription(str);
            if (TextUtils.isEmpty(str)) {
                this.f2315t.setVisibility(8);
                return;
            }
            this.f2315t.setVisibility(0);
            this.f2315t.setText(str);
            this.f2315t.setOnTouchListener(new ViewOnTouchListenerC0754hk(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3872a(long j) {
        if (this.f2288Y != null) {
            if (j != 0) {
                this.f2318w.setText(getString(R.string.livepartner_body_subscribers_count, Long.valueOf(j)));
                this.f2318w.setVisibility(0);
            } else {
                this.f2318w.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3871a(int i) {
        if (this.f2288Y != null) {
            if (i != 0) {
                this.f2319x.setText(getString(R.string.livepartner_body_likes_count, Integer.valueOf(i)));
                this.f2319x.setVisibility(0);
            } else {
                this.f2319x.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3874a(C0514d c0514d, boolean z) {
        if (c0514d != null) {
            if (z) {
                setHasOptionsMenu(true);
            } else {
                setHasOptionsMenu(false);
            }
            if (this.f2307l != null && this.f2288Y != null) {
                this.f2288Y.setTitle(this.f2307l);
                if (GlobalApplication.m6456e()) {
                    this.f2314s.setText(this.f2307l);
                }
            }
            m3876a(c0514d.m4005f());
            if (z) {
                if (this.f2287X) {
                    this.f2271H.setVisibility(0);
                    this.f2271H.setOnClickListener(this.f2290a);
                    this.f2320y.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow, 0);
                } else {
                    this.f2271H.setVisibility(8);
                    this.f2320y.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            }
            if (c0514d.m4003d() != null && !c0514d.m4003d().equals("null")) {
                this.f2310o = Long.parseLong(c0514d.m4003d());
                m3872a(this.f2310o);
            }
            C3205bt.m11182a(this.f2288Y).m11210a(this.f2313r, c0514d.m4000a());
            C3162ad.m11009a(c0514d.m4000a(), new C0767hx(this));
            if (c0514d.m4004e() != null && !c0514d.m4004e().equals("null")) {
                this.f2308m = Integer.parseInt(c0514d.m4004e());
                m3871a(this.f2308m);
            }
            if (c0514d != null && c0514d.m4008i() != null && c0514d.m4008i().length() != 0) {
                this.f2274K.setVisibility(0);
                this.f2275L.setText(c0514d.m4008i().replace(" ", ""));
                this.f2272I.setVisibility(0);
                this.f2275L.setContentDescription(c0514d.m4008i());
                this.f2274K.setOnTouchListener(new ViewOnTouchListenerC0769hz(this));
            } else {
                this.f2274K.setVisibility(8);
                this.f2272I.setVisibility(8);
            }
            this.f2274K.setOnClickListener(new ViewOnClickListenerC0771ia(this, c0514d));
            if (c0514d != null && c0514d.m4011l() != null && c0514d.m4011l().length() != 0) {
                this.f2277N.setVisibility(0);
                this.f2278O.setText(c0514d.m4011l().replace(" ", ""));
                this.f2273J.setVisibility(0);
                this.f2278O.setContentDescription(c0514d.m4011l());
                this.f2277N.setOnTouchListener(new ViewOnTouchListenerC0772ib(this));
                if (BuddyProfileFragment.m3616a(this.f2288Y, new Intent("android.intent.action.CALL", Uri.parse("tel:+000")))) {
                    this.f2277N.setOnClickListener(new ViewOnClickListenerC0773ic(this));
                }
            } else {
                this.f2277N.setVisibility(8);
                this.f2273J.setVisibility(8);
            }
            this.f2321z.setText(c0514d.m4002c());
            this.f2321z.setContentDescription(c0514d.m4002c());
            m3880b();
            if (this.f2312q) {
                this.f2280Q.setVisibility(0);
            } else {
                this.f2280Q.setVisibility(8);
            }
            if (GlobalApplication.m6456e()) {
                m3887c(this.f2316u);
            } else {
                m3884b(this.f2316u);
            }
        }
    }

    /* renamed from: b */
    private void m3880b() {
        if (this.f2311p) {
            m3886c();
            if (GlobalApplication.m6456e()) {
                this.f2265B.setVisibility(8);
            } else {
                this.f2266C.setVisibility(8);
            }
            this.f2270G.setVisibility(0);
            this.f2267D.setVisibility(0);
            return;
        }
        if (GlobalApplication.m6456e()) {
            this.f2265B.setVisibility(0);
        } else {
            this.f2266C.setVisibility(0);
        }
        this.f2268E.setVisibility(8);
        this.f2269F.setVisibility(8);
        this.f2270G.setVisibility(8);
        this.f2267D.setVisibility(8);
    }

    /* renamed from: c */
    private void m3886c() {
        switch (this.f2302g.m4012m()) {
            case CHAT:
                this.f2268E.setVisibility(0);
                this.f2269F.setVisibility(8);
                break;
            case CONTENTS:
                this.f2268E.setVisibility(8);
                this.f2269F.setVisibility(0);
                break;
            case CHATCONTENTS:
                this.f2268E.setVisibility(0);
                this.f2269F.setVisibility(0);
                break;
            case NONE:
                this.f2268E.setVisibility(8);
                this.f2269F.setVisibility(0);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m3890d() {
        View viewInflate = this.f2288Y.getLayoutInflater().inflate(R.layout.special_buddy_profile_layout2, (ViewGroup) null);
        this.f2319x = (TextView) viewInflate.findViewById(R.id.specialbuddy_like_count);
        m3871a(this.f2308m);
        if (GlobalApplication.m6456e()) {
            this.f2314s = (TextView) viewInflate.findViewById(R.id.live_name);
            this.f2295ae = (ImageView) viewInflate.findViewById(R.id.like_button);
            this.f2295ae.setOnClickListener(new ViewOnClickListenerC0774id(this));
            if (this.f2311p) {
                this.f2295ae.setVisibility(0);
            } else {
                this.f2295ae.setVisibility(8);
            }
            this.f2317v = viewInflate.findViewById(R.id.live_info_header);
            ((TextView) this.f2317v.findViewById(R.id.text1)).setText(getString(R.string.mypage_info));
        }
        this.f2315t = (TextView) viewInflate.findViewById(R.id.specialbuddy_status_msg);
        this.f2315t.setVisibility(0);
        this.f2318w = (TextView) viewInflate.findViewById(R.id.specialbuddy_subscriber_count);
        if (!GlobalApplication.m6456e()) {
            m3872a(this.f2310o);
        }
        this.f2313r = (ImageView) viewInflate.findViewById(R.id.specialbuddy_profile_image);
        if (!GlobalApplication.m6456e()) {
        }
        this.f2313r.setOnClickListener(this.f2290a);
        if (GlobalApplication.m6456e()) {
            this.f2265B = (Button) viewInflate.findViewById(R.id.profile_add_special_buddy);
            this.f2265B.setOnTouchListener(new ViewOnTouchListenerC0775ie(this));
            this.f2265B.setOnClickListener(this.f2290a);
        } else {
            this.f2266C = (ImageButton) viewInflate.findViewById(R.id.profile_add_special_buddy);
            this.f2266C.setOnTouchListener(new ViewOnTouchListenerC0776if(this));
            this.f2266C.setOnClickListener(this.f2290a);
        }
        this.f2269F = (ImageButton) viewInflate.findViewById(R.id.profile_special_contents);
        this.f2269F.setOnTouchListener(new ViewOnTouchListenerC0755hl(this));
        this.f2269F.setOnClickListener(this.f2290a);
        this.f2268E = (ImageButton) viewInflate.findViewById(R.id.profile_special_chat);
        this.f2268E.setOnTouchListener(new ViewOnTouchListenerC0756hm(this));
        this.f2268E.setOnClickListener(this.f2290a);
        this.f2270G = (ImageButton) viewInflate.findViewById(R.id.profile_recommend_special_buddy);
        this.f2270G.setOnTouchListener(new ViewOnTouchListenerC0757hn(this));
        this.f2270G.setOnClickListener(this.f2290a);
        this.f2272I = viewInflate.findViewById(R.id.profile_special_divider1);
        this.f2273J = viewInflate.findViewById(R.id.profile_special_divider2);
        this.f2267D = (ImageButton) viewInflate.findViewById(R.id.profile_unfollow_special_buddy);
        this.f2267D.setOnTouchListener(new ViewOnTouchListenerC0758ho(this));
        this.f2267D.setOnClickListener(this.f2290a);
        this.f2280Q = (LinearLayout) viewInflate.findViewById(R.id.specialbuddy_profile_footer_progress);
        this.f2274K = viewInflate.findViewById(R.id.profile_special_url_area);
        this.f2274K.setFocusable(true);
        this.f2274K.findViewById(R.id.button1).setVisibility(8);
        this.f2275L = (TextView) this.f2274K.findViewById(R.id.text1);
        this.f2276M = (ImageView) this.f2274K.findViewById(R.id.image1);
        if (GlobalApplication.m6456e()) {
            this.f2276M.setBackgroundResource(R.drawable.plus_url);
            this.f2276M.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.live_profile_info_img_size);
            this.f2276M.getLayoutParams().width = getResources().getDimensionPixelSize(R.dimen.live_profile_info_img_size);
            this.f2276M.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            this.f2276M.setBackgroundResource(R.drawable.livepartner_popup_url);
        }
        int paddingLeft = this.f2274K.getPaddingLeft();
        int paddingTop = this.f2274K.getPaddingTop();
        int paddingRight = this.f2274K.getPaddingRight();
        int paddingBottom = this.f2274K.getPaddingBottom();
        this.f2274K.setBackgroundResource(R.drawable.listview_selector);
        this.f2274K.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        this.f2277N = viewInflate.findViewById(R.id.profile_special_tel_area);
        this.f2277N.setFocusable(true);
        this.f2277N.findViewById(R.id.button1).setVisibility(8);
        this.f2278O = (TextView) this.f2277N.findViewById(R.id.text1);
        this.f2279P = (ImageView) this.f2277N.findViewById(R.id.image1);
        this.f2279P = (ImageView) this.f2277N.findViewById(R.id.image1);
        if (GlobalApplication.m6456e()) {
            this.f2279P.setBackgroundResource(R.drawable.plus_call);
            this.f2279P.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.live_profile_info_img_size);
            this.f2279P.getLayoutParams().width = getResources().getDimensionPixelSize(R.dimen.live_profile_info_img_size);
            this.f2279P.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            this.f2279P.setBackgroundResource(R.drawable.profile_info_call);
        }
        int paddingLeft2 = this.f2277N.getPaddingLeft();
        int paddingTop2 = this.f2277N.getPaddingTop();
        int paddingRight2 = this.f2277N.getPaddingRight();
        int paddingBottom2 = this.f2277N.getPaddingBottom();
        this.f2277N.setBackgroundResource(R.drawable.listview_selector);
        this.f2277N.setPadding(paddingLeft2, paddingTop2, paddingRight2, paddingBottom2);
        this.f2321z = (TextView) viewInflate.findViewById(R.id.special_buddy_profile_description);
        this.f2271H = (ViewGroup) viewInflate.findViewById(R.id.list_special_header);
        this.f2320y = (TextView) this.f2271H.findViewById(R.id.text1);
        this.f2320y.setText(getString(R.string.specialbuddy_selected_caterories, 0));
        this.f2264A = (TextView) viewInflate.findViewById(R.id.special_buddy_profile_contents_category_list);
        this.f2294ad.removeAllViews();
        this.f2294ad.addView(viewInflate);
        this.f2296af = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m3894e() {
        if (this.f2302g == null) {
            View viewInflate = this.f2288Y.getLayoutInflater().inflate(R.layout.new_specialbuddy_layout, (ViewGroup) null);
            this.f2314s = (TextView) viewInflate.findViewById(R.id.new_buddy_name);
            this.f2281R = (TextView) viewInflate.findViewById(R.id.new_buddy_information);
            if (this.f2307l == null) {
                this.f2314s.setText(getString(R.string.unknown));
            } else {
                this.f2314s.setText(this.f2307l);
                this.f2314s.setContentDescription(this.f2307l);
            }
            this.f2314s.setMarqueeRepeatLimit(-1);
            this.f2282S = (ViewGroup) viewInflate.findViewById(R.id.new_buddy_menu);
            this.f2283T = (Button) viewInflate.findViewById(R.id.new_buddy_add);
            this.f2284U = (Button) viewInflate.findViewById(R.id.new_buddy_block);
            this.f2285V = (Button) viewInflate.findViewById(R.id.new_buddy_unblock);
            this.f2286W = (Button) viewInflate.findViewById(R.id.new_buddy_cancel);
            this.f2283T.setOnClickListener(this.f2290a);
            this.f2284U.setOnClickListener(this.f2290a);
            this.f2285V.setOnClickListener(this.f2290a);
            this.f2286W.setOnClickListener(this.f2290a);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f2283T.setText(R.string.buddy_profile_button_block);
                this.f2284U.setText(R.string.buddy_profile_button_addbuddy);
                this.f2285V.setText(R.string.cancel);
                this.f2286W.setText(R.string.setting_block_unblock);
            }
            this.f2294ad.removeAllViews();
            this.f2294ad.addView(viewInflate);
            m3906j();
            new C1330h(this.f2299d).m5748f(this.f2306k, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m3896f() {
        new C1330h(this.f2299d).m5737c(this.f2306k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m3900g() {
        new C1330h(this.f2299d).m5741d(this.f2306k);
    }

    /* renamed from: a */
    public void m3929a() {
        m3906j();
        new C1330h(this.f2299d).m5730b(this.f2306k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m3902h() {
        m3906j();
        new C1328f(this.f2299d).m5706a(this.f2306k, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m3904i() {
        m3906j();
        new C1328f(this.f2299d).m5705a(this.f2306k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m3906j() {
        if (this.f2304i != null && !this.f2288Y.isFinishing()) {
            this.f2304i.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m3908k() {
        if (this.f2304i != null && this.f2304i.isShowing() && this.f2288Y != null && !this.f2288Y.isFinishing()) {
            this.f2304i.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m3911l() {
    }

    /* renamed from: a */
    C0514d m3928a(C0514d c0514d, SpecialUser specialUser) {
        return new C0514d(specialUser.specialuserid == null ? c0514d.m4000a() : specialUser.specialuserid, specialUser.name == null ? c0514d.m4001b() : specialUser.name, specialUser.description == null ? c0514d.m4002c() : specialUser.description, specialUser.followcount == null ? c0514d.m4003d() : specialUser.followcount, specialUser.likecount == null ? c0514d.m4004e() : specialUser.likecount, specialUser.msgstatus == null ? c0514d.m4005f() : specialUser.msgstatus, specialUser.photoloaded == null ? c0514d.m4006g() : specialUser.photoloaded, specialUser.status == null ? c0514d.m4007h() : specialUser.status, specialUser.url == null ? c0514d.m4008i() : specialUser.url, specialUser.weburl == null ? c0514d.m4009j() : specialUser.weburl, c0514d.m4010k(), specialUser.tel == null ? c0514d.m4011l() : specialUser.tel);
    }

    /* renamed from: a */
    C0513c m3927a(C0514d c0514d) {
        return new C0513c(c0514d.m4000a(), c0514d.m4001b(), c0514d.m4005f(), null, c0514d.m4000a(), null, true, 0, c0514d.m4001b(), false, 0, 0, 0, 0, 0, 0, 1, false, false, 0);
    }

    /* renamed from: m */
    private void m3913m() {
        if (C3250y.f11734b) {
            C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        }
        Context applicationContext = this.f2288Y.getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Intent m3866a(Context context, EnumC1455w enumC1455w, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) ChatForwardActivity.class);
        intent.putExtra("content_type", enumC1455w.m6364a());
        intent.putExtra("inboxNO", "");
        if (TextUtils.isEmpty(str2)) {
            intent.putExtra("download_uri", str);
        } else {
            intent.putExtra("download_uri", str2);
            intent.putExtra("sub_content", str);
        }
        intent.putExtra("is_forward_mode", true);
        intent.setFlags(536870912);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public boolean m3892d(boolean z) {
        if (C3347i.m11788k()) {
            return true;
        }
        if (z) {
            m3875a(EnumC0778ih.Nonetwork);
        }
        return false;
    }

    /* renamed from: a */
    private void m3875a(EnumC0778ih enumC0778ih) {
        switch (enumC0778ih) {
            case Nonetwork:
                this.f2305j.setText(R.string.popup_no_network_connection);
                this.f2305j.setDuration(0);
                this.f2305j.show();
                break;
            case NetworkErr:
                this.f2305j.setText(R.string.toast_network_unable);
                this.f2305j.setDuration(0);
                this.f2305j.show();
                break;
        }
    }
}
