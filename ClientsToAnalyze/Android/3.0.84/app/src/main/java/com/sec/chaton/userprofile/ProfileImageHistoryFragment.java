package com.sec.chaton.userprofile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.C0522ag;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.image.ZoomableImageView;
import com.sec.chaton.multimedia.p048a.AsyncTaskC1767a;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1345w;
import com.sec.chaton.p035io.entry.GetProfileImageList;
import com.sec.chaton.p035io.entry.inner.ProfileImage;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.trunk.p061c.C3020a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3220ch;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.C3347i;
import com.sec.common.util.C3348j;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.C3641ai;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/* loaded from: classes.dex */
public class ProfileImageHistoryFragment extends Fragment {

    /* renamed from: A */
    private ViewTreeObserver.OnGlobalLayoutListener f11199A;

    /* renamed from: B */
    private GridView f11200B;

    /* renamed from: C */
    private FrameLayout f11201C;

    /* renamed from: D */
    private LinearLayout f11202D;

    /* renamed from: E */
    private FrameLayout f11203E;

    /* renamed from: F */
    private FrameLayout f11204F;

    /* renamed from: G */
    private LinearLayout f11205G;

    /* renamed from: H */
    private C3114bm f11206H;

    /* renamed from: I */
    private ArrayList<ProfileImageItem> f11207I;

    /* renamed from: J */
    private C3326c f11208J;

    /* renamed from: K */
    private String f11209K;

    /* renamed from: L */
    private String f11210L;

    /* renamed from: M */
    private ProgressBar f11211M;

    /* renamed from: N */
    private int f11212N;

    /* renamed from: O */
    private ImageView f11213O;

    /* renamed from: P */
    private Boolean f11214P;

    /* renamed from: Q */
    private Boolean f11215Q;

    /* renamed from: R */
    private ImageView f11216R;

    /* renamed from: S */
    private Context f11217S;

    /* renamed from: T */
    private View f11218T;

    /* renamed from: U */
    private InterfaceC3274d f11219U;

    /* renamed from: V */
    private InterfaceC3274d f11220V;

    /* renamed from: W */
    private InterfaceC3274d f11221W;

    /* renamed from: X */
    private InterfaceC3274d f11222X;

    /* renamed from: Y */
    private String f11223Y;

    /* renamed from: Z */
    private String f11224Z;

    /* renamed from: a */
    String f11225a;

    /* renamed from: aa */
    private int f11226aa;

    /* renamed from: ab */
    private int f11227ab;

    /* renamed from: ac */
    private int f11228ac;

    /* renamed from: ad */
    private ArrayList<ProfileImage> f11229ad;

    /* renamed from: ae */
    private String f11230ae;

    /* renamed from: af */
    private ProfileImageHistoryActivity f11231af;

    /* renamed from: ag */
    private InterfaceC3274d f11232ag;

    /* renamed from: ah */
    private int f11233ah;

    /* renamed from: ai */
    private boolean f11234ai;

    /* renamed from: aj */
    private String f11235aj;

    /* renamed from: ak */
    private String f11236ak;

    /* renamed from: al */
    private String f11237al;

    /* renamed from: am */
    private boolean f11238am;

    /* renamed from: an */
    private DialogInterface.OnClickListener f11239an;

    /* renamed from: ao */
    private DialogInterface.OnClickListener f11240ao;

    /* renamed from: ap */
    private DialogInterface.OnClickListener f11241ap;

    /* renamed from: aq */
    private Handler f11242aq;

    /* renamed from: b */
    String f11243b;

    /* renamed from: c */
    String f11244c;

    /* renamed from: e */
    AdapterView.OnItemClickListener f11245e;

    /* renamed from: f */
    AdapterView.OnItemLongClickListener f11246f;

    /* renamed from: g */
    private ZoomableImageView f11247g;

    /* renamed from: h */
    private Uri f11248h;

    /* renamed from: i */
    private final int f11249i;

    /* renamed from: j */
    private final int f11250j;

    /* renamed from: k */
    private final int f11251k;

    /* renamed from: l */
    private boolean f11252l;

    /* renamed from: m */
    private boolean f11253m;

    /* renamed from: n */
    private ProgressDialog f11254n;

    /* renamed from: o */
    private ProgressDialog f11255o;

    /* renamed from: p */
    private C1345w f11256p;

    /* renamed from: q */
    private String f11257q;

    /* renamed from: r */
    private File f11258r;

    /* renamed from: u */
    private File f11259u;

    /* renamed from: v */
    private File f11260v;

    /* renamed from: w */
    private String f11261w;

    /* renamed from: x */
    private boolean f11262x;

    /* renamed from: y */
    private boolean f11263y;

    /* renamed from: z */
    private Toast f11264z;

    /* renamed from: s */
    private static String f11197s = "profile_f_mine_";

    /* renamed from: t */
    private static String f11198t = "profile_t_mine_";

    /* renamed from: d */
    public static final String f11196d = ProfileImageHistoryActivity.class.getSimpleName();

    public ProfileImageHistoryFragment() {
        this.f11249i = 0;
        this.f11250j = 5;
        this.f11251k = 6;
        this.f11252l = false;
        this.f11253m = false;
        this.f11257q = C3223ck.m11328b();
        this.f11258r = new File(this.f11257q + "/profile/");
        this.f11225a = C3223ck.m11329c() + "/profilehistory/";
        this.f11243b = GlobalApplication.m11493l().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/";
        this.f11244c = GlobalApplication.m11493l().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/profilehistory/";
        this.f11259u = GlobalApplication.m11493l().getFilesDir().getAbsoluteFile();
        this.f11261w = "";
        this.f11262x = false;
        this.f11263y = false;
        this.f11209K = "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3159aa.m10962a().m10979a("imei", "");
        this.f11223Y = "";
        this.f11224Z = "";
        this.f11226aa = 1;
        this.f11230ae = C3159aa.m10962a().m10979a("chaton_id", "");
        this.f11234ai = false;
        this.f11235aj = "";
        this.f11236ak = "";
        this.f11237al = "";
        this.f11238am = false;
        this.f11245e = new C3122bu(this);
        this.f11239an = new DialogInterfaceOnClickListenerC3125bx(this);
        this.f11246f = new C3126by(this);
        this.f11240ao = new DialogInterfaceOnClickListenerC3127bz(this);
        this.f11241ap = new DialogInterfaceOnClickListenerC3129ca(this);
        this.f11242aq = new HandlerC3117bp(this);
        this.f11234ai = false;
    }

    public ProfileImageHistoryFragment(int i) {
        this.f11249i = 0;
        this.f11250j = 5;
        this.f11251k = 6;
        this.f11252l = false;
        this.f11253m = false;
        this.f11257q = C3223ck.m11328b();
        this.f11258r = new File(this.f11257q + "/profile/");
        this.f11225a = C3223ck.m11329c() + "/profilehistory/";
        this.f11243b = GlobalApplication.m11493l().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/";
        this.f11244c = GlobalApplication.m11493l().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/profilehistory/";
        this.f11259u = GlobalApplication.m11493l().getFilesDir().getAbsoluteFile();
        this.f11261w = "";
        this.f11262x = false;
        this.f11263y = false;
        this.f11209K = "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3159aa.m10962a().m10979a("imei", "");
        this.f11223Y = "";
        this.f11224Z = "";
        this.f11226aa = 1;
        this.f11230ae = C3159aa.m10962a().m10979a("chaton_id", "");
        this.f11234ai = false;
        this.f11235aj = "";
        this.f11236ak = "";
        this.f11237al = "";
        this.f11238am = false;
        this.f11245e = new C3122bu(this);
        this.f11239an = new DialogInterfaceOnClickListenerC3125bx(this);
        this.f11246f = new C3126by(this);
        this.f11240ao = new DialogInterfaceOnClickListenerC3127bz(this);
        this.f11241ap = new DialogInterfaceOnClickListenerC3129ca(this);
        this.f11242aq = new HandlerC3117bp(this);
        this.f11212N = i;
    }

    public ProfileImageHistoryFragment(String str, String str2, String str3) {
        this.f11249i = 0;
        this.f11250j = 5;
        this.f11251k = 6;
        this.f11252l = false;
        this.f11253m = false;
        this.f11257q = C3223ck.m11328b();
        this.f11258r = new File(this.f11257q + "/profile/");
        this.f11225a = C3223ck.m11329c() + "/profilehistory/";
        this.f11243b = GlobalApplication.m11493l().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/";
        this.f11244c = GlobalApplication.m11493l().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/profilehistory/";
        this.f11259u = GlobalApplication.m11493l().getFilesDir().getAbsoluteFile();
        this.f11261w = "";
        this.f11262x = false;
        this.f11263y = false;
        this.f11209K = "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3159aa.m10962a().m10979a("imei", "");
        this.f11223Y = "";
        this.f11224Z = "";
        this.f11226aa = 1;
        this.f11230ae = C3159aa.m10962a().m10979a("chaton_id", "");
        this.f11234ai = false;
        this.f11235aj = "";
        this.f11236ak = "";
        this.f11237al = "";
        this.f11238am = false;
        this.f11245e = new C3122bu(this);
        this.f11239an = new DialogInterfaceOnClickListenerC3125bx(this);
        this.f11246f = new C3126by(this);
        this.f11240ao = new DialogInterfaceOnClickListenerC3127bz(this);
        this.f11241ap = new DialogInterfaceOnClickListenerC3129ca(this);
        this.f11242aq = new HandlerC3117bp(this);
        this.f11235aj = str;
        this.f11236ak = str2;
        this.f11237al = str3;
        this.f11234ai = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11231af = (ProfileImageHistoryActivity) activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f11231af = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11231af.m10781c().mo11583a(getText(R.string.mypage_profile_image));
        if (!this.f11234ai) {
            BaseActivity.m3083b(this, true);
        } else {
            BaseActivity.m3083b(this, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10799a(int i) throws IOException {
        if (this.f11233ah == R.array.profile_image_long_click_main) {
            switch (i) {
                case 0:
                    m10836g();
                    break;
                case 1:
                    m10838h();
                    break;
                case 2:
                    m10830e();
                    break;
                case 3:
                    m10834f();
                    break;
            }
        }
        switch (i) {
            case 0:
                m10836g();
                break;
            case 1:
                m10838h();
                break;
            case 2:
                m10828d();
                break;
            case 3:
                m10830e();
                break;
        }
    }

    /* renamed from: d */
    private void m10828d() {
        m10846l();
        this.f11256p.m5940e(this.f11224Z);
        this.f11254n.show();
    }

    /* renamed from: e */
    private void m10830e() {
        if (!this.f11223Y.equals(this.f11224Z)) {
            this.f11256p.m5931a(this.f11224Z, false);
            this.f11255o.show();
            this.f11252l = true;
        } else {
            if (this.f11219U == null) {
                AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f11217S);
                abstractC3271aM11494a.mo11495a(R.string.menu_chat_delete).mo11506b(R.string.mypage_delete_current_image).mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3120bs(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3116bo(this));
                this.f11219U = abstractC3271aM11494a.mo11505a();
            }
            this.f11219U.show();
        }
    }

    /* renamed from: f */
    private void m10834f() {
        m10846l();
        this.f11215Q = true;
        this.f11256p.m5940e("-1");
        this.f11254n.show();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Throwable {
        CallableC3115bn callableC3115bn;
        BaseActivity.m3081a(this, false);
        View viewInflate = layoutInflater.inflate(R.layout.layout_profile_image_view, viewGroup, false);
        this.f11254n = (ProgressDialog) new C3263j(getActivity()).m11487a(R.string.dialog_userprofile_updating);
        this.f11255o = (ProgressDialog) new C3263j(getActivity()).m11487a(R.string.dialog_connecting_server);
        this.f11247g = (ZoomableImageView) viewInflate.findViewById(R.id.profile_big_image);
        this.f11201C = (FrameLayout) viewInflate.findViewById(R.id.networkErrorView);
        this.f11201C.setVisibility(8);
        this.f11213O = (ImageView) viewInflate.findViewById(R.id.profile_image_loading);
        this.f11205G = (LinearLayout) viewInflate.findViewById(R.id.profile_default_image);
        this.f11205G.setVisibility(8);
        this.f11216R = (ImageView) viewInflate.findViewById(R.id.profile_error_image);
        this.f11217S = getActivity();
        this.f11218T = viewInflate.findViewById(R.id.network_error_layout);
        ((ImageView) this.f11218T.findViewById(R.id.image1)).setImageResource(R.drawable.no_contents_network);
        ((TextView) this.f11218T.findViewById(R.id.text1)).setText(R.string.toast_network_unable);
        ((TextView) this.f11218T.findViewById(R.id.text2)).setVisibility(8);
        this.f11208J = new C3326c();
        this.f11200B = (GridView) viewInflate.findViewById(R.id.list_bg_horizontal);
        this.f11200B.setOnItemClickListener(this.f11245e);
        this.f11202D = (LinearLayout) viewInflate.findViewById(R.id.profile_holder);
        this.f11203E = (FrameLayout) viewInflate.findViewById(R.id.profile_main_images);
        this.f11204F = (FrameLayout) viewInflate.findViewById(R.id.profile_grid_images);
        this.f11200B.setOnItemLongClickListener(this.f11246f);
        m10831e(this.f11217S.getResources().getConfiguration().orientation);
        setHasOptionsMenu(false);
        this.f11207I = new ArrayList<>();
        this.f11256p = new C1345w(this.f11242aq);
        this.f11211M = (ProgressBar) viewInflate.findViewById(R.id.progress_loading);
        ProfileImageHistoryActivity.f11195a = this.f11224Z;
        this.f11214P = false;
        this.f11215Q = false;
        if (bundle != null && bundle.getParcelableArrayList("array") != null && bundle.getString("mProfileImageUrl") != null) {
            this.f11223Y = bundle.getString("mRepresentPImageId");
            this.f11224Z = bundle.getString("mCurrentPImageId");
            this.f11207I = bundle.getParcelableArrayList("array");
            this.f11210L = bundle.getString("mProfileImageUrl");
            this.f11226aa = bundle.getInt("mCurrentPosition");
            this.f11227ab = bundle.getInt("mTotalProfileImageCount");
            this.f11212N = bundle.getInt("mSmallImageNum");
            this.f11215Q = Boolean.valueOf(bundle.getBoolean("mSetDefaultImageFlag"));
            this.f11228ac = bundle.getInt("mMaxImageCount");
            this.f11234ai = bundle.getBoolean("mBuddyMode");
            this.f11235aj = bundle.getString("mBuddyNo");
            this.f11236ak = bundle.getString("mbuddyImageID");
            this.f11237al = bundle.getString("mbuddyImageType");
            this.f11238am = bundle.getBoolean("mNoSuchImage");
            C3250y.m11456e("mCurrentPImageId: " + this.f11224Z, getClass().getSimpleName());
            C3250y.m11456e("mProfileImageUrl: " + this.f11210L, getClass().getSimpleName());
            if (this.f11224Z == null) {
                this.f11205G.setVisibility(0);
            } else {
                ProfileImageHistoryActivity.f11195a = this.f11224Z;
                this.f11231af.m10781c().mo11583a(((Object) getText(R.string.mypage_profile_image)) + " (" + this.f11226aa + "/" + this.f11227ab + ")");
            }
            m10844k();
            this.f11216R.setVisibility(8);
            this.f11213O.setVisibility(8);
            if (!this.f11234ai) {
                callableC3115bn = new CallableC3115bn(this.f11213O, this.f11216R, this.f11210L + "&size=800", 600, 600, this.f11225a, "profile_f_mine_" + this.f11224Z, false);
            } else {
                callableC3115bn = new CallableC3115bn(this.f11213O, this.f11216R, this.f11210L + "&size=800", 600, 600, this.f11244c, "buddy_f_" + this.f11235aj + "_" + this.f11224Z, false);
            }
            if (callableC3115bn != null) {
                this.f11208J.m11730a(this.f11247g, callableC3115bn);
            }
        } else {
            this.f11211M.setVisibility(0);
            setHasOptionsMenu(false);
            m10811a(false, (C0267d) null);
        }
        if (bundle != null) {
            String string = bundle.getString("CAPTURE_IMAGE_URI");
            if (!TextUtils.isEmpty(string)) {
                this.f11248h = Uri.parse(string);
            }
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f11247g != null) {
            ViewTreeObserver viewTreeObserver = this.f11247g.getViewTreeObserver();
            this.f11199A = new ViewTreeObserverOnGlobalLayoutListenerC3121bt(this);
            viewTreeObserver.addOnGlobalLayoutListener(this.f11199A);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f11247g != null) {
            this.f11247g.getViewTreeObserver().removeGlobalOnLayoutListener(this.f11199A);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10810a(String str, String str2, boolean z) throws Throwable {
        File file = new File(this.f11225a, "profile_t_mine_" + str);
        File file2 = new File(this.f11225a, "profile_f_mine_" + str);
        if (file2.exists()) {
            m10807a(file2);
            if (z) {
                m10819b(str);
            }
        } else {
            m10807a(file);
            this.f11216R.setVisibility(8);
            this.f11213O.setVisibility(8);
            C3250y.m11456e("setThumbOrFullProfileImage mUrl: " + str2 + "&size=800", getClass().getSimpleName());
            this.f11208J.m11730a(this.f11247g, new CallableC3115bn(this.f11213O, this.f11216R, str2 + "&size=800", 600, 600, this.f11225a, "profile_f_mine_" + str, z));
        }
        this.f11205G.setVisibility(8);
        C3250y.m11450b("photoFile=" + file, getClass().getSimpleName());
        C3250y.m11450b("photoFileFull=" + file2, getClass().getSimpleName());
    }

    /* renamed from: a */
    private void m10807a(File file) {
        this.f11216R.setVisibility(8);
        this.f11213O.setVisibility(8);
        if (file.exists()) {
            this.f11208J.m11730a(this.f11247g, new CallableC3134cf(file, false, true));
        }
    }

    /* renamed from: g */
    private void m10836g() {
        if (!C3197bl.m11159a()) {
            String str = this.f11225a + "profile_f_mine_" + this.f11224Z;
            if (!C3223ck.m11327a()) {
                C3641ai.m13210a(this.f11217S, R.string.sdcard_not_found, 0).show();
            } else {
                new AsyncTaskC1767a(str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//ChatON", "profile_f_mine_" + this.f11224Z + ".jpg", false).execute(new String[0]);
            }
        }
    }

    /* renamed from: h */
    private void m10838h() throws IOException {
        if (!C3197bl.m11159a()) {
            Bitmap bitmapM11791a = C3348j.m11791a(CommonApplication.m11493l(), new File(this.f11225a + "profile_f_mine_" + this.f11224Z), 600, 600);
            if (bitmapM11791a != null) {
                bitmapM11791a.setDensity(160);
                Intent intentM11316a = C3220ch.m11316a(this.f11217S, getString(R.string.trunk_opt_header_share), bitmapM11791a, (String) null, (String) null, false);
                if (intentM11316a != null) {
                    startActivity(intentM11316a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10808a(String str) {
        ProfileImageItem profileImageItem;
        for (int i = 0; i < this.f11200B.getChildCount() && (profileImageItem = (ProfileImageItem) this.f11200B.getChildAt(i).getTag()) != null; i++) {
            if (profileImageItem.imageId == null || profileImageItem.imageId.equals("addImage")) {
                profileImageItem.selectedImage.setVisibility(8);
            } else if (profileImageItem.imageId.toString().equals(str.toString())) {
                profileImageItem.selectedImage.setVisibility(0);
            } else {
                profileImageItem.selectedImage.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10811a(boolean z, C0267d c0267d) throws Throwable {
        if (!this.f11234ai) {
            ProfileImageItem profileImageItem = new ProfileImageItem();
            profileImageItem.f11265id = "addImage";
            this.f11207I.add(profileImageItem);
            m10844k();
            this.f11200B.setEnabled(false);
            this.f11214P = false;
            if (z && c0267d != null) {
                m10802a(c0267d);
                return;
            } else {
                this.f11256p.m5937d();
                m10856q();
                return;
            }
        }
        this.f11256p.m5930a(this.f11235aj, "600");
        m10857r();
    }

    public class ProfileImageItem implements Parcelable {
        public static final Parcelable.Creator<ProfileImageItem> CREATOR = new C3130cb();
        public String FullfileName;
        public String Represent;
        public String ThumbfileName;
        public String dirCachePath;

        /* renamed from: id */
        public String f11265id;
        public String imageId;
        public ImageView selectedImage;
        public ImageView thumbImage;

        public ProfileImageItem() {
        }

        public ProfileImageItem(Parcel parcel) {
            m10872a(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f11265id);
            parcel.writeString(this.imageId);
            parcel.writeString(this.dirCachePath);
            parcel.writeString(this.ThumbfileName);
            parcel.writeString(this.FullfileName);
            parcel.writeString(this.Represent);
        }

        /* renamed from: a */
        private void m10872a(Parcel parcel) {
            this.f11265id = parcel.readString();
            this.imageId = parcel.readString();
            this.dirCachePath = parcel.readString();
            this.ThumbfileName = parcel.readString();
            this.FullfileName = parcel.readString();
            this.Represent = parcel.readString();
        }
    }

    /* renamed from: a */
    public void m10869a() throws IOException {
        int i = R.array.selphoto_first_nocamera_nodelete;
        try {
            if (!this.f11258r.canRead()) {
                this.f11258r.mkdirs();
            }
            m10860s();
            this.f11261w = "tmp_" + System.currentTimeMillis() + ".jpeg_";
            this.f11260v = new File(this.f11258r + "/", this.f11261w);
            C3250y.m11450b("[Create File] " + this.f11258r.toString() + this.f11261w + " : " + this.f11260v.createNewFile(), f11196d);
            this.f11248h = null;
            this.f11248h = Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//Camera//", new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()) + ".jpg"));
            if (!m10870b() || !m10871c()) {
                if (this.f11264z == null) {
                    this.f11264z = C3641ai.m13211a(this.f11217S, getString(R.string.toast_sdcard_amount), 1);
                }
                this.f11264z.show();
                return;
            }
            if (C3159aa.m10962a().m10979a("profile_image_status", "").equals("updated")) {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("image/*");
                intent.putExtra("set-as-image", true);
                if (BuddyProfileActivity.m3573a(this.f11217S, intent)) {
                    if (C3171am.m11077o()) {
                        i = R.array.selphoto;
                    }
                } else if (C3171am.m11077o()) {
                    i = R.array.cselphoto;
                }
            } else {
                Intent intent2 = new Intent("android.intent.action.PICK");
                intent2.setType("image/*");
                intent2.putExtra("set-as-image", true);
                if (BuddyProfileActivity.m3573a(this.f11217S, intent2)) {
                    if (C3171am.m11077o()) {
                        i = R.array.selphoto_first;
                    }
                } else if (C3171am.m11077o()) {
                    i = R.array.selphoto_first;
                }
            }
            AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f11217S);
            if (C3171am.m11077o()) {
                abstractC3271aM11494a.mo11495a(R.string.mypage_profile_add_photo).mo11497a(i, this.f11240ao);
            } else {
                abstractC3271aM11494a.mo11495a(R.string.mypage_profile_add_photo).mo11497a(i, this.f11241ap);
            }
            if (this.f11221W == null) {
                abstractC3271aM11494a.mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3124bw(this));
                this.f11221W = abstractC3271aM11494a.mo11505a();
            }
            this.f11221W.show();
            if (this.f11252l) {
                this.f11221W.dismiss();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m10840i() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        intent.putExtra("set-as-image", true);
        if (!BuddyProfileActivity.m3573a(this.f11217S, intent)) {
            Toast.makeText(this.f11217S, R.string.mypage_no_pictures_are_available, 0).show();
        } else {
            startActivityForResult(intent, 5);
        }
        this.f11252l = true;
    }

    /* renamed from: a */
    private void m10800a(int i, String str) {
        switch (i) {
            case 0:
                C3159aa.m10966a("profile_small_image1", str);
                break;
            case 1:
                C3159aa.m10966a("profile_small_image2", str);
                break;
            case 2:
                C3159aa.m10966a("profile_small_image3", str);
                break;
        }
    }

    /* renamed from: a */
    private void m10801a(int i, ArrayList<ProfileImage> arrayList) {
        if (i < 4 && i > 0) {
            C3250y.m11456e("mImageNum: " + i, getClass().getSimpleName());
            if (arrayList != null && arrayList.size() >= i && !this.f11214P.booleanValue()) {
                this.f11224Z = arrayList.get(i - 1).profileimageid;
                this.f11210L = arrayList.get(i - 1).profileimageurl;
                this.f11231af.m10781c().mo11583a(((Object) getText(R.string.mypage_profile_image)) + " (" + i + "/" + this.f11227ab + ")");
                this.f11205G.setVisibility(8);
                m10809a(this.f11210L, this.f11224Z, this.f11247g, this.f11213O, this.f11216R, true);
                this.f11214P = true;
                this.f11212N = 0;
                return;
            }
            if (arrayList != null && arrayList.size() > i && this.f11214P.booleanValue()) {
                this.f11224Z = arrayList.get(i).profileimageid;
                this.f11210L = arrayList.get(i).profileimageurl;
                this.f11231af.m10781c().mo11583a(((Object) getText(R.string.mypage_profile_image)) + " (" + (i + 1) + "/" + this.f11227ab + ")");
                this.f11205G.setVisibility(8);
                m10809a(this.f11210L, this.f11224Z, this.f11247g, this.f11213O, this.f11216R, true);
                this.f11214P = true;
                this.f11212N = 0;
                return;
            }
            if (!this.f11214P.booleanValue()) {
                setHasOptionsMenu(false);
                this.f11205G.setVisibility(0);
                return;
            } else {
                if (arrayList != null && arrayList.size() > 0) {
                    m10809a(this.f11210L, this.f11224Z, this.f11247g, this.f11213O, this.f11216R, true);
                    return;
                }
                return;
            }
        }
        if (this.f11214P.booleanValue()) {
            m10809a(this.f11210L, this.f11224Z, this.f11247g, this.f11213O, this.f11216R, true);
        }
    }

    /* renamed from: b */
    private void m10817b(int i) {
        if (i < 4) {
            C3159aa.m10966a("profile_small_image3", (String) null);
        }
        if (i < 3) {
            C3159aa.m10966a("profile_small_image2", (String) null);
        }
        if (i < 2) {
            C3159aa.m10966a("profile_small_image1", (String) null);
        }
    }

    /* renamed from: j */
    private void m10842j() {
        C3205bt.m11182a(GlobalApplication.m11493l()).m11227b(this.f11230ae);
        C3159aa.m10966a("profile_image_status", "deleted");
        C3159aa.m10966a("profile_small_image0", (String) null);
        this.f11205G.setVisibility(0);
        File file = new File(this.f11243b + "myprofile.png_");
        if (file.exists()) {
            file.delete();
        }
    }

    /* renamed from: b */
    private void m10819b(String str) throws Throwable {
        String str2 = C3223ck.m11329c() + "/profilehistory/";
        String str3 = GlobalApplication.m11493l().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/";
        String strM10979a = C3159aa.m10962a().m10979a("chaton_id", "");
        C3159aa.m10962a().m10979a("msisdn", "");
        C3159aa.m10966a("profile_image_status", "updated");
        String str4 = str2 + "profile_t_mine_" + str;
        String str5 = str2 + "profile_f_mine_" + str;
        File file = new File(str3 + "myprofile.png_");
        if (file.exists()) {
            file.delete();
        }
        String str6 = str3 + "myprofile.png_";
        C3205bt.m11182a(GlobalApplication.m11493l()).m11227b(strM10979a);
        C3243r.m11420a(str4, str3 + strM10979a + ".jpeg_");
        C3243r.m11420a(str5, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m10844k() {
        ProfileImageHistoryActivity.f11195a = this.f11224Z;
        this.f11206H = new C3114bm(this.f11217S.getApplicationContext(), R.layout.item_profile_image, this.f11207I, this.f11208J);
        this.f11200B.setAdapter((ListAdapter) this.f11206H);
        if (this.f11234ai) {
            for (int i = 0; i < this.f11227ab; i++) {
                if (this.f11224Z.equals(this.f11206H.getItem(i).imageId)) {
                    this.f11226aa = i + 1;
                    this.f11231af.m10781c().mo11583a(((Object) getText(R.string.mypage_profile_image)) + " (" + this.f11226aa + "/" + this.f11227ab + ")");
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m10846l() {
        getActivity().setRequestedOrientation(C3347i.m11773a((Activity) getActivity()));
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        System.gc();
        if (i2 == -1) {
            switch (i) {
                case 3:
                case 10:
                case 11:
                    if (this.f11254n != null) {
                        this.f11254n.dismiss();
                    }
                    if (this.f11224Z == null || this.f11224Z.length() == 0) {
                        this.f11205G.setVisibility(0);
                    }
                    if (i2 == -1) {
                        intent.getExtras().getInt("activity_orientation");
                        getActivity().setRequestedOrientation(C3347i.m11773a((Activity) getActivity()));
                        File file = new File(Uri.parse(intent.getExtras().getString("temp_file_path")).getPath());
                        this.f11261w = "tmp_" + System.currentTimeMillis() + ".jpeg_";
                        this.f11260v = new File(this.f11258r + "/", this.f11261w);
                        if (file.length() <= 0) {
                            C3250y.m11442a("Crop return null!", f11196d);
                            break;
                        } else {
                            try {
                                C3020a.m10525a(file, this.f11260v);
                                this.f11256p.m5929a(this.f11260v.getPath());
                                if (this.f11254n != null) {
                                    this.f11254n.show();
                                    break;
                                }
                            } catch (Exception e) {
                                C3250y.m11443a(e, getClass().getSimpleName());
                                m10852o();
                                return;
                            }
                        }
                    }
                    break;
                case 5:
                    if (intent == null) {
                        C3250y.m11450b("Crop Return is NULL", getClass().getSimpleName());
                        if (this.f11254n != null) {
                            this.f11254n.dismiss();
                            break;
                        }
                    } else {
                        this.f11205G.setVisibility(8);
                        this.f11248h = intent.getData();
                        m10823c(10);
                        break;
                    }
                    break;
                case 6:
                    if (i2 == -1) {
                        this.f11205G.setVisibility(8);
                        m10829d(11);
                        break;
                    } else {
                        if (this.f11254n != null) {
                            this.f11254n.dismiss();
                        }
                        C3250y.m11450b("Camera Return is NULL", getClass().getSimpleName());
                        break;
                    }
            }
            return;
        }
        if (m10812a(i, intent)) {
        }
    }

    /* renamed from: a */
    private boolean m10812a(int i, Intent intent) {
        switch (i) {
            case 10:
                if (intent != null && intent.getBooleanExtra("restart", false)) {
                    m10848m();
                    return true;
                }
                break;
            case 11:
                if (intent != null && intent.getBooleanExtra("restart", false)) {
                    m10850n();
                    return true;
                }
                break;
        }
        return false;
    }

    /* renamed from: m */
    private void m10848m() {
        m10840i();
    }

    /* renamed from: n */
    private void m10850n() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("return-data", false);
        intent.putExtra("output", this.f11248h);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        startActivityForResult(intent, 6);
        this.f11252l = true;
    }

    /* renamed from: c */
    private void m10823c(int i) {
        Intent intent = new Intent(this.f11217S, (Class<?>) ImageModify.class);
        intent.setDataAndType(this.f11248h, "image/*");
        intent.putExtra("outputX", 600);
        intent.putExtra("outputY", 600);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, i);
    }

    /* renamed from: d */
    private void m10829d(int i) {
        Intent intent = new Intent(this.f11217S, (Class<?>) ImageModify.class);
        intent.setDataAndType(this.f11248h, "image/*");
        intent.putExtra("outputX", 600);
        intent.putExtra("outputY", 600);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m10852o() {
        try {
            this.f11205G.setVisibility(0);
            C0522ag.m4019a("Me", BitmapFactory.decodeResource(GlobalApplication.m6451b(), R.drawable.contacts_default_01));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: p */
    private void m10854p() {
        try {
            this.f11247g.setImageResource(R.drawable.contacts_default_01);
            C0522ag.m4019a("Me", BitmapFactory.decodeResource(GlobalApplication.m6451b(), R.drawable.contacts_default_01));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: q */
    private void m10856q() {
        File file;
        this.f11216R.setVisibility(8);
        this.f11213O.setVisibility(8);
        C3250y.m11456e("UserProfile initialize() - img status: " + C3159aa.m10962a().m10979a("profile_image_status", ""), getClass().getSimpleName());
        if (C3159aa.m10962a().m10979a("profile_image_status", "").equals("updated") || this.f11212N != 0) {
            if (this.f11212N == 1 && !C3159aa.m10962a().m10979a("profile_small_image1", "").equals("")) {
                file = new File(this.f11225a, "profile_f_mine_" + C3159aa.m10962a().m10979a("profile_small_image1", ""));
                if (!file.exists()) {
                    file = new File(this.f11225a, "profile_t_mine_" + C3159aa.m10962a().m10979a("profile_small_image1", ""));
                }
            } else if (this.f11212N == 2 && !C3159aa.m10962a().m10979a("profile_small_image2", "").equals("")) {
                file = new File(this.f11225a, "profile_f_mine_" + C3159aa.m10962a().m10979a("profile_small_image2", ""));
                if (!file.exists()) {
                    file = new File(this.f11225a, "profile_t_mine_" + C3159aa.m10962a().m10979a("profile_small_image2", ""));
                }
            } else if (this.f11212N == 3 && !C3159aa.m10962a().m10979a("profile_small_image3", "").equals("")) {
                file = new File(this.f11225a, "profile_f_mine_" + C3159aa.m10962a().m10979a("profile_small_image3", ""));
                if (!file.exists()) {
                    file = new File(this.f11225a, "profile_t_mine_" + C3159aa.m10962a().m10979a("profile_small_image3", ""));
                }
            } else {
                file = new File(this.f11259u, "myprofile.png_");
            }
            C3250y.m11450b("photoFile=" + file, getClass().getSimpleName());
            if (file.exists()) {
                this.f11208J.m11730a(this.f11247g, new CallableC3134cf(file, false, true));
                return;
            } else {
                m10852o();
                return;
            }
        }
        m10852o();
    }

    /* renamed from: r */
    private void m10857r() {
        boolean z;
        if (this.f11237al.equals("FULL")) {
            File file = new File(this.f11243b + this.f11235aj + "/", "buddy_f_" + this.f11235aj + "_" + this.f11236ak);
            if (file.exists()) {
                this.f11208J.m11730a(this.f11247g, new CallableC3134cf(file, false, true));
                return;
            } else {
                m10854p();
                return;
            }
        }
        if (this.f11237al.equals("THUMB")) {
            File file2 = new File(this.f11244c, "buddy_f_" + this.f11235aj + "_" + this.f11236ak);
            if (file2.exists()) {
                z = true;
            } else {
                file2 = new File(this.f11243b + this.f11235aj + "/", "buddy_t_" + this.f11235aj + "_" + this.f11236ak);
                if (file2.exists()) {
                    this.f11238am = true;
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                if (file2.exists()) {
                    this.f11208J.m11730a(this.f11247g, new CallableC3134cf(file2, false, true));
                    return;
                }
                return;
            }
            m10854p();
        }
    }

    /* renamed from: s */
    private void m10860s() {
        if (!m10870b() || !m10871c()) {
            C3250y.m11442a("[deleteTempFolder] External Storage Is Not Available or Writable!", f11196d);
            if (this.f11264z == null) {
                this.f11264z = C3641ai.m13211a(this.f11217S, getString(R.string.toast_sdcard_amount), 1);
            }
            this.f11264z.show();
            return;
        }
        String strM11328b = C3223ck.m11328b();
        if (strM11328b.length() == 0) {
            this.f11264z.show();
            return;
        }
        try {
            String[] list = new File(strM11328b + "/profile/").list();
            if (list != null) {
                for (String str : list) {
                    C3250y.m11450b("[Delete File] " + strM11328b + "/profile/" + str + " : " + new File(strM11328b + "/profile/" + str).delete(), f11196d);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    protected boolean m10870b() {
        m10862t();
        return this.f11262x;
    }

    /* renamed from: c */
    protected boolean m10871c() {
        m10862t();
        return this.f11263y;
    }

    /* renamed from: t */
    private void m10862t() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f11262x = true;
            this.f11263y = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f11262x = true;
            this.f11263y = false;
        } else {
            this.f11262x = false;
            this.f11263y = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.f11208J != null) {
            this.f11208J.m11731a();
        }
        if (this.f11254n.isShowing()) {
            this.f11254n.dismiss();
        }
        if (this.f11255o.isShowing()) {
            this.f11255o.dismiss();
        }
        if (this.f11219U != null) {
            this.f11219U.dismiss();
        }
        if (this.f11220V != null) {
            this.f11220V.dismiss();
        }
        if (this.f11221W != null) {
            this.f11221W.dismiss();
        }
        if (this.f11222X != null) {
            this.f11222X.dismiss();
        }
        if (this.f11200B != null) {
            this.f11200B.setAdapter((ListAdapter) null);
            this.f11200B.setOnItemClickListener(null);
            this.f11200B = null;
        }
        this.f11256p.m5939e();
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("mCurrentPImageId", this.f11224Z);
        bundle.putString("mRepresentPImageId", this.f11223Y);
        bundle.putString("mProfileImageUrl", this.f11210L);
        bundle.putParcelableArrayList("array", this.f11207I);
        bundle.putInt("mCurrentPosition", this.f11226aa);
        bundle.putInt("mTotalProfileImageCount", this.f11227ab);
        bundle.putInt("mSmallImageNum", this.f11212N);
        bundle.putBoolean("mSetDefaultImageFlag", this.f11215Q.booleanValue());
        bundle.putInt("mMaxImageCount", this.f11228ac);
        bundle.putBoolean("mBuddyMode", this.f11234ai);
        bundle.putString("mBuddyNo", this.f11235aj);
        bundle.putString("mbuddyImageID", this.f11236ak);
        bundle.putString("mbuddyImageType", this.f11237al);
        bundle.putBoolean("mNoSuchImage", this.f11238am);
        if (this.f11248h != null) {
            bundle.putString("CAPTURE_IMAGE_URI", this.f11248h.toString());
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m10831e(configuration.orientation);
    }

    /* renamed from: e */
    private void m10831e(int i) {
        LinearLayout.LayoutParams layoutParams = null;
        LinearLayout.LayoutParams layoutParams2 = null;
        if (!GlobalApplication.m6456e()) {
            if (i == 2) {
                layoutParams = new LinearLayout.LayoutParams(0, -1);
                layoutParams.weight = 0.5f;
                layoutParams2 = new LinearLayout.LayoutParams(0, -1);
                layoutParams2.weight = 0.5f;
                layoutParams2.leftMargin = 4;
                layoutParams2.rightMargin = 4;
                this.f11202D.setOrientation(0);
            } else if (i == 1) {
                layoutParams = new LinearLayout.LayoutParams(-1, 0);
                layoutParams.weight = 0.7f;
                layoutParams.gravity = 17;
                layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                layoutParams2.weight = 0.3f;
                layoutParams2.gravity = 17;
                this.f11202D.setOrientation(1);
            }
            this.f11203E.setLayoutParams(layoutParams);
            this.f11204F.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10802a(C0267d c0267d) throws Throwable {
        if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
            GetProfileImageList getProfileImageList = (GetProfileImageList) c0267d.m1354e();
            if (getProfileImageList != null) {
                this.f11227ab = getProfileImageList.listcount.intValue();
                this.f11228ac = getProfileImageList.maxcount.intValue();
                this.f11229ad = getProfileImageList.profileimagelist;
                C3250y.m11456e("mTotalProfileImageCount: " + this.f11227ab, getClass().getSimpleName());
                C3250y.m11456e("mMaxImageCount: " + this.f11228ac, getClass().getSimpleName());
                if (this.f11229ad.size() > 0) {
                    if ("1".equals(this.f11229ad.get(0).represent)) {
                        this.f11205G.setVisibility(8);
                        C3159aa.m10966a("profile_image_status", "updated");
                        m10817b(this.f11229ad.size());
                    } else {
                        m10842j();
                        m10817b(this.f11229ad.size() - 1);
                    }
                } else {
                    m10842j();
                    C3159aa.m10966a("profile_small_image1", (String) null);
                    C3159aa.m10966a("profile_small_image2", (String) null);
                    C3159aa.m10966a("profile_small_image3", (String) null);
                }
                if (this.f11229ad != null && this.f11229ad.size() > 0) {
                    for (int i = 0; i < this.f11229ad.size(); i++) {
                        ProfileImage profileImage = this.f11229ad.get(i);
                        if ("1".equals(profileImage.represent)) {
                            this.f11223Y = profileImage.profileimageid;
                            this.f11224Z = profileImage.profileimageid;
                            this.f11210L = profileImage.profileimageurl;
                            ProfileImageHistoryActivity.f11195a = this.f11224Z;
                            this.f11214P = true;
                            this.f11231af.m10781c().mo11583a(((Object) getText(R.string.mypage_profile_image)) + " (" + (i + 1) + "/" + this.f11227ab + ")");
                            File file = new File(this.f11225a);
                            if (!file.exists()) {
                                file.mkdir();
                            }
                            if (C3159aa.m10962a().m10977a("profile_image_update_client", (Boolean) true).booleanValue()) {
                                String str = this.f11225a + "profile_t_mine_" + profileImage.profileimageid;
                                String str2 = this.f11225a + "profile_f_mine_" + profileImage.profileimageid;
                                String str3 = this.f11243b + "myprofile.png_";
                                String str4 = this.f11243b + this.f11230ae + ".jpeg_";
                                File file2 = new File(str);
                                if (new File(str4).exists() && !file2.exists()) {
                                    C3243r.m11420a(str4, str);
                                }
                                File file3 = new File(str2);
                                if (new File(str3).exists() && !file3.exists()) {
                                    C3243r.m11420a(str3, str2);
                                }
                            }
                            File file4 = new File(this.f11243b + "myprofile.png_");
                            if (!C3159aa.m10962a().m10979a("profile_small_image0", "").equals(profileImage.profileimageid) || !file4.exists()) {
                                C3159aa.m10966a("profile_small_image0", profileImage.profileimageid);
                                m10810a(profileImage.profileimageid, profileImage.profileimageurl + this.f11209K, true);
                            }
                        }
                        if (!"1".equals(profileImage.represent)) {
                            if ("1".equals(this.f11229ad.get(0).represent)) {
                                m10800a(i - 1, profileImage.profileimageid);
                            } else {
                                m10800a(i, profileImage.profileimageid);
                                C3159aa.m10966a("profile_small_image0", (String) null);
                            }
                        }
                        C3250y.m11456e("profileimageurl: " + profileImage.profileimageurl.toString(), getClass().getSimpleName());
                        ProfileImageItem profileImageItem = new ProfileImageItem();
                        profileImageItem.f11265id = profileImage.profileimageurl.toString() + this.f11209K;
                        profileImageItem.dirCachePath = this.f11225a;
                        profileImageItem.ThumbfileName = "profile_t_mine_" + profileImage.profileimageid;
                        profileImageItem.FullfileName = "profile_f_mine_" + profileImage.profileimageid;
                        profileImageItem.Represent = profileImage.represent;
                        profileImageItem.imageId = profileImage.profileimageid;
                        C3250y.m11456e("profileimageurl : " + profileImageItem.f11265id, getClass().getSimpleName());
                        this.f11207I.add(profileImageItem);
                    }
                }
                m10801a(this.f11212N, this.f11229ad);
                if (!this.f11214P.booleanValue()) {
                    setHasOptionsMenu(false);
                }
                m10844k();
                this.f11200B.setEnabled(true);
                this.f11211M.setVisibility(8);
                if (this.f11254n.isShowing()) {
                    this.f11254n.dismiss();
                }
                if (this.f11255o.isShowing()) {
                    this.f11255o.dismiss();
                }
                if (this.f11253m) {
                    m10869a();
                    this.f11253m = false;
                }
                getActivity().setRequestedOrientation(-1);
                return;
            }
            return;
        }
        this.f11211M.setVisibility(8);
        if (this.f11255o.isShowing()) {
            this.f11255o.dismiss();
        }
        if (this.f11254n.isShowing()) {
            this.f11254n.dismiss();
        }
        this.f11201C.setVisibility(0);
        C3641ai.m13210a(getActivity(), R.string.toast_network_unable, 0).show();
        getActivity().setRequestedOrientation(-1);
    }

    /* renamed from: a */
    private void m10809a(String str, String str2, ImageView imageView, ImageView imageView2, ImageView imageView3, Boolean bool) {
        String str3;
        int i;
        String str4;
        if (bool.booleanValue()) {
            str3 = str + this.f11209K + "&size=800";
            i = 800;
            str4 = f11197s;
        } else {
            str3 = str + this.f11209K + "&size=140";
            i = 140;
            str4 = f11198t;
        }
        if (str2 != null) {
            File file = new File(this.f11225a, str4 + str2);
            if (!file.exists()) {
                this.f11208J.m11730a(imageView, new CallableC3115bn(imageView2, imageView3, str3, i, i, this.f11225a, str4 + str2, false));
                return;
            }
            imageView.setImageBitmap(C3162ad.m11000a(GlobalApplication.m11493l(), file.getAbsolutePath()));
        }
    }
}
