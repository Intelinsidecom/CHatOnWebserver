package com.sec.chaton.userprofile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.content.C0096i;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C0992ab;
import com.sec.chaton.C1047as;
import com.sec.chaton.InterfaceC2318el;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.C1331gk;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.image.PostONImagePagerActivity;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p049b.ContextMenuC1056a;
import com.sec.chaton.p055d.C2074ag;
import com.sec.chaton.p055d.C2075ah;
import com.sec.chaton.p055d.C2130k;
import com.sec.chaton.p057e.C2225am;
import com.sec.chaton.p057e.p058a.C2179ae;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p065io.entry.GetPostONList;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.poston.C3009d;
import com.sec.chaton.poston.C3016k;
import com.sec.chaton.poston.InterfaceC3015j;
import com.sec.chaton.poston.PostONDetailActivity;
import com.sec.chaton.poston.PostONDetailFragment;
import com.sec.chaton.trunk.p121c.C4636a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4851bp;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4878cp;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4879cq;
import com.sec.chaton.util.InterfaceC4854bs;
import com.sec.chaton.widget.C4923p;
import com.sec.chaton.widget.SelectableImageView;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.p130e.InterfaceC4995d;
import com.sec.common.p132g.C5007c;
import com.sec.common.tooltip.C5013c;
import com.sec.common.util.log.collector.C5043h;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.C5179v;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class MyPageFragment extends Fragment implements InterfaceC2318el, InterfaceC3015j {

    /* renamed from: A */
    private LinearLayout f17196A;

    /* renamed from: B */
    private TextView f17197B;

    /* renamed from: C */
    private TextView f17198C;

    /* renamed from: D */
    private TextView f17199D;

    /* renamed from: E */
    private TextView f17200E;

    /* renamed from: F */
    private TextView f17201F;

    /* renamed from: G */
    private TextView f17202G;

    /* renamed from: H */
    private FrameLayout f17203H;

    /* renamed from: I */
    private LinearLayout f17204I;

    /* renamed from: J */
    private TextView f17205J;

    /* renamed from: K */
    private C4851bp f17206K;

    /* renamed from: L */
    private C2074ag f17207L;

    /* renamed from: M */
    private C2075ah f17208M;

    /* renamed from: N */
    private C5007c f17209N;

    /* renamed from: O */
    private String f17210O;

    /* renamed from: P */
    private String f17211P;

    /* renamed from: Q */
    private String f17212Q;

    /* renamed from: R */
    private String f17213R;

    /* renamed from: S */
    private String f17214S;

    /* renamed from: T */
    private String f17215T;

    /* renamed from: U */
    private C2210x f17216U;

    /* renamed from: V */
    private boolean f17217V;

    /* renamed from: W */
    private boolean f17218W;

    /* renamed from: X */
    private C0416a f17219X;

    /* renamed from: Y */
    private InterfaceC4936e f17220Y;

    /* renamed from: Z */
    private ProgressDialog f17221Z;

    /* renamed from: aa */
    private C4923p f17232aa;

    /* renamed from: ab */
    private Uri f17233ab;

    /* renamed from: ai */
    private File f17240ai;

    /* renamed from: am */
    private C3009d f17244am;

    /* renamed from: ap */
    private File f17247ap;

    /* renamed from: aq */
    private File f17248aq;

    /* renamed from: ar */
    private Uri f17249ar;

    /* renamed from: as */
    private C4756bo f17250as;

    /* renamed from: at */
    private C2130k f17251at;

    /* renamed from: au */
    private ImageView f17252au;

    /* renamed from: av */
    private String f17253av;

    /* renamed from: f */
    private View f17259f;

    /* renamed from: g */
    private View f17260g;

    /* renamed from: h */
    private ListView f17261h;

    /* renamed from: i */
    private View f17262i;

    /* renamed from: j */
    private TextView f17263j;

    /* renamed from: k */
    private TextView f17264k;

    /* renamed from: l */
    private ImageView f17265l;

    /* renamed from: m */
    private ImageButton f17266m;

    /* renamed from: n */
    private ImageView f17267n;

    /* renamed from: o */
    private LinearLayout f17268o;

    /* renamed from: p */
    private SelectableImageView f17269p;

    /* renamed from: q */
    private SelectableImageView f17270q;

    /* renamed from: r */
    private SelectableImageView f17271r;

    /* renamed from: s */
    private SelectableImageView f17272s;

    /* renamed from: t */
    private ImageView f17273t;

    /* renamed from: u */
    private RelativeLayout f17274u;

    /* renamed from: v */
    private LinearLayout f17275v;

    /* renamed from: w */
    private LinearLayout f17276w;

    /* renamed from: x */
    private LinearLayout f17277x;

    /* renamed from: y */
    private ProgressDialog f17278y;

    /* renamed from: z */
    private LinearLayout f17279z;

    /* renamed from: a */
    public static final String f17192a = MyPageFragment.class.getSimpleName();

    /* renamed from: b */
    public static String f17194b = "profile_f_mine_";

    /* renamed from: c */
    public static String f17195c = "profile_t_mine_";

    /* renamed from: aw */
    private static String f17193aw = "mypage";

    /* renamed from: ac */
    private final int f17234ac = 0;

    /* renamed from: ad */
    private final int f17235ad = 9;

    /* renamed from: ae */
    private final int f17236ae = 11;

    /* renamed from: af */
    private final int f17237af = 97;

    /* renamed from: ag */
    private final int f17238ag = 29;

    /* renamed from: ah */
    private final String f17239ah = "profile";

    /* renamed from: aj */
    private String f17241aj = "";

    /* renamed from: ak */
    private final String f17242ak = C4873ck.m18501b();

    /* renamed from: al */
    private File f17243al = new File(this.f17242ak + "/profile/");

    /* renamed from: an */
    private ArrayList<C3016k> f17245an = new ArrayList<>();

    /* renamed from: ao */
    private ArrayList<C4757bp> f17246ao = new ArrayList<>();

    /* renamed from: ax */
    private final String f17254ax = "updated";

    /* renamed from: ay */
    private final String f17255ay = "coverstory_sample_changed";

    /* renamed from: d */
    AbsListView.OnScrollListener f17257d = new C4736av(this);

    /* renamed from: e */
    ContentObserver f17258e = new C4738ax(this, new Handler());

    /* renamed from: az */
    private InterfaceC4854bs f17256az = new C4739ay(this);

    /* renamed from: aA */
    private Handler f17222aA = new HandlerC4740az(this);

    /* renamed from: aB */
    private Handler f17223aB = new HandlerC4747bf(this);

    /* renamed from: aC */
    private InterfaceC2211y f17224aC = new C4748bg(this);

    /* renamed from: aD */
    private Handler f17225aD = new HandlerC4752bk(this);

    /* renamed from: aE */
    private View.OnClickListener f17226aE = new ViewOnClickListenerC4725ak(this);

    /* renamed from: aF */
    private View.OnClickListener f17227aF = new ViewOnClickListenerC4726al(this);

    /* renamed from: aG */
    private DialogInterface.OnClickListener f17228aG = new DialogInterfaceOnClickListenerC4733as(this);

    /* renamed from: aH */
    private DialogInterface.OnClickListener f17229aH = new DialogInterfaceOnClickListenerC4734at(this);

    /* renamed from: aI */
    private DialogInterface.OnClickListener f17230aI = new DialogInterfaceOnClickListenerC4735au(this);

    /* renamed from: aJ */
    private DialogInterface.OnClickListener f17231aJ = new DialogInterfaceOnClickListenerC4737aw(this);

    @Override // com.sec.chaton.InterfaceC2318el
    /* renamed from: j_ */
    public void mo2964j_() {
        this.f17217V = true;
        C5043h.m19179a().m19185a("3000", "2103", false);
        if (C4904y.f17872b) {
            C4904y.m18639b("onTabSelected()", f17192a);
        }
        BaseActivity.m6160a((Fragment) this, true);
        if (C4809aa.m18104a().m18119a("coverstory_first_set", (Boolean) true).booleanValue()) {
            C4904y.m18639b(" onTabSelected listCoverStory First @@@@", f17192a);
            this.f17251at.m9544c();
        }
        if ("updated".equals(C4809aa.m18104a().m18121a("mypage_coverstory_state", ""))) {
            C4754bm.m18042a(this.f17252au);
        } else {
            if (C4904y.f17872b) {
                C4904y.m18639b(" coverstory default image loadDefaultCoverStory() in onResume()", f17192a);
            }
            C1331gk.m7458a(this.f17252au);
        }
        m17902e();
        m17920n();
    }

    @Override // com.sec.chaton.InterfaceC2318el
    /* renamed from: k_ */
    public void mo2965k_() {
        this.f17217V = false;
        if (C4904y.f17872b) {
            C4904y.m18639b("onTabUnSelected()", f17192a);
        }
        BaseActivity.m6160a((Fragment) this, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m17903f();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onCreateView()", f17192a);
        }
        m17896c();
        this.f17259f = layoutInflater.inflate(R.layout.layout_mypage_main_header, (ViewGroup) null);
        this.f17263j = (TextView) this.f17259f.findViewById(R.id.mypage_main_profile_name);
        this.f17264k = (TextView) this.f17259f.findViewById(R.id.mypage_main_profile_status_message);
        this.f17265l = (ImageView) this.f17259f.findViewById(R.id.mypage_main_profile_status_icon);
        this.f17203H = (FrameLayout) this.f17259f.findViewById(R.id.mypage_info_layout);
        this.f17203H.setVisibility(0);
        this.f17266m = (ImageButton) this.f17259f.findViewById(R.id.btn_mypage_info);
        this.f17267n = (ImageView) this.f17259f.findViewById(R.id.mypage_main_profile_image_camera);
        this.f17204I = (LinearLayout) this.f17259f.findViewById(R.id.mypage_info_text_layout);
        this.f17269p = (SelectableImageView) this.f17259f.findViewById(R.id.mypage_main_profile_image_represent);
        this.f17270q = (SelectableImageView) this.f17259f.findViewById(R.id.mypage_main_profile_image_sub1);
        this.f17271r = (SelectableImageView) this.f17259f.findViewById(R.id.mypage_main_profile_image_sub2);
        this.f17272s = (SelectableImageView) this.f17259f.findViewById(R.id.mypage_main_profile_image_sub3);
        this.f17273t = (ImageView) this.f17259f.findViewById(R.id.mypage_profile_more);
        this.f17274u = (RelativeLayout) this.f17259f.findViewById(R.id.mypage_poston_write_frame);
        this.f17268o = (LinearLayout) this.f17259f.findViewById(R.id.mypage_name_status_layout);
        this.f17205J = (TextView) this.f17259f.findViewById(R.id.mypage_poston_write_text);
        this.f17275v = (LinearLayout) this.f17259f.findViewById(R.id.llayout_mypage_coverstory_press_area);
        this.f17275v.setOnLongClickListener(new ViewOnLongClickListenerC4724aj(this));
        this.f17279z = (LinearLayout) this.f17259f.findViewById(R.id.mypage_samsungaccount_layout);
        this.f17196A = (LinearLayout) this.f17259f.findViewById(R.id.mypage_birthday_layout);
        this.f17197B = (TextView) this.f17259f.findViewById(R.id.mypage_info_phonenumber1);
        this.f17198C = (TextView) this.f17259f.findViewById(R.id.mypage_info_phonenumber2);
        this.f17199D = (TextView) this.f17259f.findViewById(R.id.mypage_info_phonenumber3);
        this.f17200E = (TextView) this.f17259f.findViewById(R.id.mypage_info_phonenumber4);
        this.f17201F = (TextView) this.f17259f.findViewById(R.id.mypage_info_samsungaccount);
        this.f17202G = (TextView) this.f17259f.findViewById(R.id.mypage_info_birthday);
        this.f17260g = layoutInflater.inflate(R.layout.layout_mypage_main_poston_list, viewGroup, false);
        this.f17261h = (ListView) this.f17260g.findViewById(R.id.mypage_main_poston_list);
        this.f17252au = (ImageView) this.f17260g.findViewById(R.id.change_skin_bg);
        registerForContextMenu(this.f17261h);
        this.f17262i = layoutInflater.inflate(R.layout.poston_refresh_footer, (ViewGroup) null);
        this.f17276w = (LinearLayout) this.f17262i.findViewById(R.id.footer_progress);
        this.f17277x = (LinearLayout) this.f17262i.findViewById(R.id.footer_content_layout);
        this.f17277x.setVisibility(8);
        this.f17244am = new C3009d(this.f17261h, getActivity(), this.f17245an, R.layout.list_item_common_9, this.f17209N);
        this.f17244am.m12364a(this);
        this.f17261h.addHeaderView(this.f17259f, null, true);
        this.f17261h.setFocusable(true);
        this.f17261h.setFocusableInTouchMode(true);
        this.f17261h.setItemsCanFocus(true);
        this.f17261h.addFooterView(this.f17262i, null, false);
        this.f17261h.setAdapter((ListAdapter) this.f17244am);
        this.f17261h.setScrollbarFadingEnabled(true);
        this.f17261h.setOnScrollListener(this.f17257d);
        m17900d();
        m17913k();
        if (bundle == null) {
            this.f17233ab = null;
        } else {
            String string = bundle.getString("CAPTURE_IMAGE_URI");
            if (!TextUtils.isEmpty(string)) {
                this.f17233ab = Uri.parse(string);
            }
            String string2 = bundle.getString("PROFILE_IMAGE_TEMP_FILE_URI");
            if (!TextUtils.isEmpty(string2)) {
                this.f17240ai = new File(string2);
            }
            String string3 = bundle.getString("COVERSTORY_IMAGE_TEMP_FILE_URI");
            if (!TextUtils.isEmpty(string3)) {
                this.f17247ap = new File(string3);
            }
        }
        return this.f17260g;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f17233ab != null) {
            bundle.putString("CAPTURE_IMAGE_URI", this.f17233ab.toString());
        }
        if (this.f17240ai != null) {
            bundle.putString("PROFILE_IMAGE_TEMP_FILE_URI", this.f17240ai.toString());
        }
        if (this.f17247ap != null) {
            bundle.putString("COVERSTORY_IMAGE_TEMP_FILE_URI", this.f17247ap.toString());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (GlobalApplication.m10286e()) {
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
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case R.id.mypage_menu_sync /* 2131166658 */:
                C4904y.m18639b("onOptionsItemSelected():mypage_menu_sync", f17192a);
                m17912j();
                return true;
            default:
                return false;
        }
    }

    /* renamed from: c */
    private void m17896c() {
        this.f17207L = new C2074ag(this.f17222aA);
        this.f17208M = new C2075ah(this.f17222aA);
        this.f17251at = new C2130k(this.f17222aA);
        this.f17209N = new C5007c();
        this.f17216U = new C2210x(getActivity().getContentResolver(), this.f17224aC);
        this.f17218W = true;
        this.f17219X = new C0416a();
        this.f17232aa = new C4923p(getActivity());
        this.f17221Z = (ProgressDialog) this.f17232aa.m18724a(R.string.wait_sending);
        C0991aa.m6037a().m18959a(this);
        this.f17278y = (ProgressDialog) this.f17232aa.m18724a(R.string.mypage_wait_saving);
        this.f17253av = getActivity().getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/";
        getActivity().getContentResolver().registerContentObserver(C2225am.f7951a, true, this.f17258e);
    }

    @InterfaceC4995d
    public void onMyProfileImageChanged(C1047as c1047as) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onMyProfileImageChanged", f17192a);
        }
        m17908h();
        if (this.f17244am != null) {
            this.f17244am.notifyDataSetChanged();
        }
        if (this.f17261h != null) {
            this.f17261h.invalidateViews();
        }
    }

    @InterfaceC4995d
    public void onBuddyProfileImageChanged(C0992ab c0992ab) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onBuddyProfileImageChanged.", f17192a);
            List<String> list = c0992ab.f3246a;
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    C4904y.m18639b(" - " + it.next(), f17192a);
                }
            }
        }
        if (this.f17244am != null) {
            this.f17244am.notifyDataSetChanged();
        }
        if (this.f17261h != null) {
            this.f17261h.invalidateViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m17900d() {
        this.f17210O = C4809aa.m18104a().m18121a("Push Name", "");
        this.f17211P = C4809aa.m18104a().m18121a("status_message", "");
        this.f17212Q = C4809aa.m18104a().m18121a("msisdn", "");
        if (C4822an.m18255w()) {
            this.f17213R = C4822an.m18254v();
        } else {
            this.f17213R = "";
        }
        if (this.f17219X.m1495d(getActivity())) {
            this.f17265l.setVisibility(0);
        } else {
            this.f17265l.setVisibility(8);
        }
        this.f17263j.setText(this.f17210O);
        if (this.f17211P.length() == 0) {
            this.f17264k.setText(R.string.mypage_default_status_message);
        } else {
            this.f17264k.setText(this.f17211P);
        }
        C4754bm.m18045a(this.f17197B, this.f17198C, this.f17199D, this.f17200E);
        if (!TextUtils.isEmpty(this.f17213R)) {
            this.f17201F.setText(this.f17213R);
            this.f17279z.setVisibility(0);
        } else {
            this.f17279z.setVisibility(8);
        }
        String strM18055b = C4754bm.m18055b();
        if (strM18055b != null && strM18055b.length() > 0) {
            this.f17202G.setText(strM18055b);
            this.f17196A.setVisibility(0);
        } else {
            this.f17196A.setVisibility(8);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (C4904y.f17872b) {
            C4904y.m18639b("onDestroyView()", f17192a);
        }
        C0991aa.m6037a().m18960b(this);
        if (this.f17209N != null) {
            this.f17209N.m19014a();
        }
        if (this.f17261h != null) {
            this.f17261h.setAdapter((ListAdapter) null);
            this.f17261h.setOnScrollListener(null);
            this.f17261h.setOnItemSelectedListener(null);
            this.f17261h.setOnKeyListener(null);
            this.f17261h = null;
        }
        if (this.f17220Y != null) {
            this.f17220Y.dismiss();
        }
        if (this.f17221Z != null && this.f17221Z.isShowing()) {
            this.f17221Z.dismiss();
        }
        this.f17244am = null;
        this.f17257d = null;
        if (this.f17207L != null) {
            this.f17207L.m9286a();
        }
        if (this.f17208M != null) {
            this.f17208M.m9321h();
        }
        if (this.f17269p != null) {
            this.f17269p.setImageBitmap(null);
            this.f17269p = null;
        }
        if (this.f17270q != null) {
            this.f17270q.setImageBitmap(null);
            this.f17270q = null;
        }
        if (this.f17271r != null) {
            this.f17271r.setImageBitmap(null);
            this.f17271r = null;
        }
        if (this.f17272s != null) {
            this.f17272s.setImageBitmap(null);
            this.f17272s = null;
        }
        getActivity().getContentResolver().unregisterContentObserver(this.f17258e);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        if (C4904y.f17872b) {
            C4904y.m18639b("onResume()", f17192a);
        }
        if ("coverstory_sample_changed".equals(C4809aa.m18104a().m18121a("mypage_coverstory_state", ""))) {
            C4754bm.m18042a(this.f17252au);
            C5179v.m19811a(CommonApplication.m18732r(), getResources().getString(R.string.mypage_coverstory_sample_changed), 0).show();
            C4809aa.m18108a("mypage_coverstory_state", "updated");
        }
        if (this.f17217V) {
            m17902e();
            if ("updated".equals(C4809aa.m18104a().m18121a("mypage_coverstory_state", ""))) {
                C4754bm.m18042a(this.f17252au);
                return;
            }
            if (C4904y.f17872b) {
                C4904y.m18639b(" coverstory default image loadDefaultCoverStory() in onResume()", f17192a);
            }
            C1331gk.m7458a(this.f17252au);
            return;
        }
        if (C4809aa.m18104a().m18119a("coverstory_first_set", (Boolean) true).booleanValue()) {
            C4904y.m18639b(" onResume !mIsTabSelected listCoverStory First @@@@", f17192a);
            this.f17251at.m9544c();
        }
    }

    /* renamed from: e */
    private void m17902e() {
        if (C4904y.f17872b) {
            C4904y.m18639b("callPollingSchedular()", f17192a);
        }
        if (this.f17206K == null) {
            m17903f();
            return;
        }
        if (this.f17206K.m18341a("get_profile_information")) {
            this.f17206K.m18338a();
            return;
        }
        m17900d();
        C4754bm.m18046a(this.f17216U);
        m17910i();
        if (C4809aa.m18104a().m18120a("new_post_on_count", (Integer) 0).intValue() > 0) {
            m17905g();
        }
    }

    /* renamed from: f */
    private void m17903f() {
        this.f17206K = new C4851bp();
        this.f17206K.m18339a("get_profile_information", this.f17256az, 300000L, "last_sync_time_get_mypage_information");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m17905g() {
        if (C4904y.f17871a) {
            C4904y.m18646e("getPostONList()", f17192a);
        }
        this.f17277x.setVisibility(8);
        this.f17276w.setVisibility(0);
        this.f17218W = true;
        this.f17207L.m9288a(C4809aa.m18104a().m18121a("chaton_id", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m17908h() {
        if (C4904y.f17871a) {
            C4904y.m18646e("getProfileImageInfo()", f17192a);
        }
        this.f17208M.m9310b(null, "4");
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 2:
                    if (i2 == -1) {
                        this.f17214S = intent.getExtras().getString("HAS_MORE");
                        this.f17215T = intent.getExtras().getString("END_TIME");
                        break;
                    }
                    break;
                case 4:
                case 5:
                    if (i2 == -1) {
                        if (intent.getExtras().getBoolean("POSTON_HAS_CHANGED")) {
                            if (C4904y.f17872b) {
                                C4904y.m18639b("POSTON_HAS_CHANGED", f17192a);
                            }
                            m17905g();
                        }
                        if (intent.getExtras().getBoolean("IS_DELETED")) {
                            this.f17214S = intent.getExtras().getString("HAS_MORE");
                            this.f17215T = intent.getExtras().getString("END_TIME");
                            break;
                        }
                    }
                    break;
                case 8:
                    int iM10677a = C2471v.m10677a(getActivity());
                    if (-3 == iM10677a || -2 == iM10677a) {
                        C5179v.m19810a(getActivity(), R.string.popup_no_network_connection, 0).show();
                        break;
                    } else if (i2 == -1) {
                        Uri uri = Uri.parse(intent.getExtras().getString("temp_file_path"));
                        File file = new File(uri.getPath());
                        if (file.length() <= 0) {
                            if (C4904y.f17875e) {
                                C4904y.m18634a("Crop return null!", f17192a);
                                break;
                            }
                        } else {
                            try {
                                this.f17278y.show();
                                if (file.exists()) {
                                    this.f17248aq = file;
                                    this.f17249ar = uri;
                                    new AsyncTaskC4755bn(file, this.f17225aD).execute(new Void[0]);
                                    break;
                                }
                            } catch (Exception e) {
                                if (C4904y.f17875e) {
                                    C4904y.m18635a(e, getClass().getSimpleName());
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    break;
                case 9:
                    if (intent == null) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("Crop Return is NULL", getClass().getSimpleName());
                            break;
                        }
                    } else {
                        this.f17233ab = intent.getData();
                        Intent intent2 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                        intent2.setDataAndType(this.f17233ab, "image/*");
                        intent2.putExtra("outputX", 600);
                        intent2.putExtra("outputY", 600);
                        intent2.putExtra("aspectX", 1);
                        intent2.putExtra("aspectY", 1);
                        intent2.putExtra("return-data", true);
                        startActivityForResult(intent2, 14);
                        break;
                    }
                    break;
                case 10:
                    if (intent == null) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("Crop Return is NULL", getClass().getSimpleName());
                            break;
                        }
                    } else {
                        this.f17233ab = intent.getData();
                        Intent intent3 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                        intent3.setDataAndType(this.f17233ab, "image/*");
                        if (!GlobalApplication.m10286e()) {
                            intent3.putExtra("outputX", C4754bm.f17425h);
                            intent3.putExtra("outputY", C4754bm.f17426i);
                        }
                        intent3.putExtra("aspectX", 2);
                        intent3.putExtra("aspectY", 3);
                        intent3.putExtra("return-data", true);
                        startActivityForResult(intent3, 8);
                        break;
                    }
                    break;
                case 11:
                    Intent intent4 = new Intent(getActivity().getApplicationContext(), (Class<?>) ImageModify.class);
                    intent4.setDataAndType(this.f17233ab, "image/*");
                    intent4.putExtra("outputX", 600);
                    intent4.putExtra("outputY", 600);
                    intent4.putExtra("aspectX", 1);
                    intent4.putExtra("aspectY", 1);
                    intent4.putExtra("return-data", true);
                    startActivityForResult(intent4, 15);
                    break;
                case 12:
                    Intent intent5 = new Intent(getActivity().getApplicationContext(), (Class<?>) ImageModify.class);
                    intent5.setDataAndType(this.f17233ab, "image/*");
                    if (!GlobalApplication.m10286e()) {
                        intent5.putExtra("outputX", C4754bm.f17425h);
                        intent5.putExtra("outputY", C4754bm.f17426i);
                    }
                    intent5.putExtra("aspectX", 2);
                    intent5.putExtra("aspectY", 3);
                    intent5.putExtra("return-data", true);
                    startActivityForResult(intent5, 8);
                    break;
                case 14:
                case 15:
                    File file2 = new File(Uri.parse(intent.getExtras().getString("temp_file_path")).getPath());
                    if (file2.length() <= 0) {
                        if (C4904y.f17875e) {
                            C4904y.m18634a("Crop return null!", f17192a);
                            break;
                        }
                    } else {
                        try {
                            C4636a.m17602a(file2, this.f17240ai);
                            this.f17278y.show();
                            this.f17208M.m9305a(this.f17240ai.getPath());
                            break;
                        } catch (Exception e2) {
                            if (C4904y.f17875e) {
                                C4904y.m18635a(e2, getClass().getSimpleName());
                            }
                            C4754bm.m18044a(this.f17269p, this.f17209N);
                            return;
                        }
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17887a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
            GetPostONList getPostONList = (GetPostONList) c0778b.m3110e();
            if (getPostONList.postonlist.size() > 0) {
                this.f17214S = getPostONList.postonlist.get(0).hasmore;
                this.f17215T = getPostONList.postonlist.get(0).endtime;
            }
            m17918m();
        } else {
            int iM10677a = C2471v.m10677a(getActivity().getApplicationContext());
            if (-3 == iM10677a || -2 == iM10677a) {
                Toast.makeText(getActivity(), R.string.popup_no_network_connection, 0).show();
            } else {
                Toast.makeText(getActivity(), R.string.toast_network_unable, 0).show();
            }
        }
        m17910i();
        this.f17218W = false;
    }

    /* renamed from: i */
    private void m17910i() {
        if (C4904y.f17871a) {
            C4904y.m18646e("queryPostONList", f17192a);
        }
        this.f17216U.startQuery(1, null, C2225am.f7952b, null, null, null, "order_msec DESC");
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
            intent.putExtra(PostONDetailFragment.f10876i, c3016k.m12365a());
            intent.putExtra(PostONDetailFragment.f10882o, "MY_PAGE");
            intent.putExtra(PostONDetailFragment.f10879l, c3016k.m12373h());
            if (!c3016k.m12375j().isEmpty()) {
                Iterator<C2179ae> it = c3016k.m12375j().iterator();
                while (it.hasNext()) {
                    C2179ae next = it.next();
                    if (next.m9726a().equals(C3009d.f11133d)) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("getMultimediaDownload has geo tag, content.getUrl() = " + next.m9728b(), f17192a);
                        }
                        intent.putExtra(PostONDetailFragment.f10880m, next.m9728b());
                    } else {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("getMultimediaDownload has Multimedia, content.getUrl() = " + next.m9728b() + " / content.getMetaType() = " + next.m9726a(), f17192a);
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
            startActivityForResult(intent, 4);
        }
    }

    @Override // com.sec.chaton.poston.InterfaceC3015j
    /* renamed from: a */
    public void mo6855a(String str) {
        Intent intent = new Intent(getActivity(), (Class<?>) PostONImagePagerActivity.class);
        intent.putExtra("buddyId", C4809aa.m18104a().m18121a("chaton_id", ""));
        intent.putExtra("url", str);
        startActivityForResult(intent, 5);
    }

    @Override // com.sec.chaton.poston.InterfaceC3015j
    /* renamed from: a */
    public void mo6856a(String str, String str2) {
        if (!C4847bl.m18333a()) {
            ((InterfaceC4753bl) getActivity()).mo3085a(str, str2);
        }
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        ContextMenuC1056a contextMenuC1056a = new ContextMenuC1056a(getActivity().getApplicationContext(), contextMenu);
        C3016k c3016k = (C3016k) this.f17261h.getAdapter().getItem(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position);
        if (c3016k != null) {
            String strM12368c = c3016k.m12368c();
            c3016k.m12371f();
            String strM12365a = c3016k.m12365a();
            if (strM12368c.equals(C4809aa.m18104a().m18121a("chaton_id", ""))) {
                contextMenuC1056a.setHeaderTitle(R.string.setting_interaction_me);
            } else {
                contextMenuC1056a.setHeaderTitle(c3016k.m12369d());
            }
            contextMenuC1056a.add(0, 0, 1, R.string.memo_delete_context_menu).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC4749bh(this, strM12365a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m17912j() {
        this.f17247ap = C4754bm.m18041a();
        this.f17233ab = Uri.fromFile(this.f17247ap);
        if (!C4873ck.m18500a()) {
            C5179v.m19811a(getActivity(), getString(R.string.toast_sdcard_amount), 1).show();
            return;
        }
        new Intent("android.intent.action.PICK").setType("image/*");
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(getActivity());
        if (C4822an.m18251s()) {
            abstractC4932aM18733a.mo18734a(R.string.change_cover_image).mo18736a(R.array.coverstory_with_camera, this.f17230aI);
        } else {
            abstractC4932aM18733a.mo18734a(R.string.change_cover_image).mo18736a(R.array.coverstory_without_camera, this.f17231aJ);
        }
        abstractC4932aM18733a.mo18745a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17886a(int i) {
        ((InterfaceC4753bl) getActivity()).mo3083a(i, true);
    }

    /* renamed from: k */
    private void m17913k() {
        this.f17273t.setOnClickListener(this.f17226aE);
        this.f17270q.setOnClickListener(new ViewOnClickListenerC4728an(this));
        this.f17271r.setOnClickListener(new ViewOnClickListenerC4729ao(this));
        this.f17272s.setOnClickListener(new ViewOnClickListenerC4730ap(this));
        this.f17266m.setOnClickListener(new ViewOnClickListenerC4731aq(this));
        if (this.f17274u != null) {
            this.f17274u.setOnClickListener(new ViewOnClickListenerC4732ar(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m17916l() {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(getActivity(), R.string.popup_no_network_connection, 0).show();
            if (C4904y.f17872b) {
                C4904y.m18639b("setCoverstorySample network error!!", f17192a);
                return;
            }
            return;
        }
        startActivityForResult(new Intent(getActivity(), (Class<?>) CoverstorySampleActivity.class), 13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m17894b(String str) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        if (!BuddyProfileActivity.m6743a(getActivity(), intent)) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
            return;
        }
        try {
            if (str.equals("profile")) {
                startActivityForResult(intent, 9);
            } else {
                startActivityForResult(intent, 10);
            }
        } catch (ActivityNotFoundException e) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f17192a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m17898c(String str) {
        if (!C4822an.m18245m() || !C4822an.m18246n()) {
            C5179v.m19810a(getActivity(), R.string.recordvideo_unable_to_record_during_call, 0).show();
            return;
        }
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(getActivity(), R.string.sdcard_not_found, 0).show();
            return;
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("return-data", false);
        intent.putExtra("output", this.f17233ab);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        try {
            if (str.equals("coverstory")) {
                startActivityForResult(intent, 12);
            } else {
                startActivityForResult(intent, 11);
            }
        } catch (ActivityNotFoundException e) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f17192a);
            }
        }
    }

    /* renamed from: m */
    private void m17918m() {
        C4809aa.m18104a().m18126b("new_post_on_count", (Integer) 0);
        if (C4904y.f17871a) {
            C4904y.m18646e("Selected My page totalNumBadge : " + C4809aa.m18104a().m18120a("new_post_on_count", (Integer) 0), getClass().getSimpleName());
        }
        C4822an.m18222b(0);
        C4822an.m18200J();
        C0096i.m358a(getActivity().getApplicationContext()).m363a(new Intent("mypage_badge_update"));
    }

    /* renamed from: n */
    private void m17920n() {
        if (C4878cp.m18516a().m18518b(EnumC4879cq.MYPAGE_COVERSTORY)) {
            new C5013c().m19049a(R.string.mypage_coverstory_user_guide).m19048a().m19042a(getActivity());
            C4878cp.m18516a().m18517a(EnumC4879cq.MYPAGE_COVERSTORY);
        } else if (C4878cp.m18516a().m18518b(EnumC4879cq.MYPAGE_POSTON)) {
            new C5013c().m19050a(this.f17205J).m19049a(R.string.mypage_coverstory_poston_guide).m19048a().m19042a(getActivity());
            C4878cp.m18516a().m18517a(EnumC4879cq.MYPAGE_POSTON);
        }
    }
}
