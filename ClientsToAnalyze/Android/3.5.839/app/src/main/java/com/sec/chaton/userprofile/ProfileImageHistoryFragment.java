package com.sec.chaton.userprofile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
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
import com.sec.chaton.buddy.C1113ad;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.image.ZoomableImageView;
import com.sec.chaton.multimedia.p079b.AsyncTaskC2751a;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2075ah;
import com.sec.chaton.p065io.entry.GetProfileImageList;
import com.sec.chaton.p065io.entry.inner.ProfileImage;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.trunk.p121c.C4636a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4869cg;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5035l;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.C5179v;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/* loaded from: classes.dex */
public class ProfileImageHistoryFragment extends Fragment {

    /* renamed from: A */
    private ViewTreeObserver.OnGlobalLayoutListener f17284A;

    /* renamed from: B */
    private GridView f17285B;

    /* renamed from: C */
    private FrameLayout f17286C;

    /* renamed from: D */
    private LinearLayout f17287D;

    /* renamed from: E */
    private FrameLayout f17288E;

    /* renamed from: F */
    private FrameLayout f17289F;

    /* renamed from: G */
    private LinearLayout f17290G;

    /* renamed from: H */
    private C4760bs f17291H;

    /* renamed from: I */
    private ArrayList<ProfileImageItem> f17292I;

    /* renamed from: J */
    private C5007c f17293J;

    /* renamed from: K */
    private String f17294K;

    /* renamed from: L */
    private String f17295L;

    /* renamed from: M */
    private ProgressBar f17296M;

    /* renamed from: N */
    private int f17297N;

    /* renamed from: O */
    private ImageView f17298O;

    /* renamed from: P */
    private Boolean f17299P;

    /* renamed from: Q */
    private Boolean f17300Q;

    /* renamed from: R */
    private ImageView f17301R;

    /* renamed from: S */
    private Context f17302S;

    /* renamed from: T */
    private ViewStub f17303T;

    /* renamed from: U */
    private View f17304U;

    /* renamed from: V */
    private ImageView f17305V;

    /* renamed from: W */
    private TextView f17306W;

    /* renamed from: X */
    private TextView f17307X;

    /* renamed from: Y */
    private InterfaceC4936e f17308Y;

    /* renamed from: Z */
    private InterfaceC4936e f17309Z;

    /* renamed from: a */
    String f17310a;

    /* renamed from: aa */
    private InterfaceC4936e f17311aa;

    /* renamed from: ab */
    private InterfaceC4936e f17312ab;

    /* renamed from: ac */
    private InterfaceC4936e f17313ac;

    /* renamed from: ad */
    private String f17314ad;

    /* renamed from: ae */
    private String f17315ae;

    /* renamed from: af */
    private int f17316af;

    /* renamed from: ag */
    private int f17317ag;

    /* renamed from: ah */
    private int f17318ah;

    /* renamed from: ai */
    private ArrayList<ProfileImage> f17319ai;

    /* renamed from: aj */
    private String f17320aj;

    /* renamed from: ak */
    private ProfileImageHistoryActivity f17321ak;

    /* renamed from: al */
    private InterfaceC4936e f17322al;

    /* renamed from: am */
    private int f17323am;

    /* renamed from: an */
    private boolean f17324an;

    /* renamed from: ao */
    private boolean f17325ao;

    /* renamed from: ap */
    private String f17326ap;

    /* renamed from: aq */
    private String f17327aq;

    /* renamed from: ar */
    private String f17328ar;

    /* renamed from: as */
    private boolean f17329as;

    /* renamed from: at */
    private Menu f17330at;

    /* renamed from: au */
    private DialogInterface.OnClickListener f17331au;

    /* renamed from: av */
    private DialogInterface.OnClickListener f17332av;

    /* renamed from: aw */
    private DialogInterface.OnClickListener f17333aw;

    /* renamed from: ax */
    private Handler f17334ax;

    /* renamed from: b */
    String f17335b;

    /* renamed from: c */
    String f17336c;

    /* renamed from: e */
    AdapterView.OnItemClickListener f17337e;

    /* renamed from: f */
    AdapterView.OnItemLongClickListener f17338f;

    /* renamed from: g */
    private ZoomableImageView f17339g;

    /* renamed from: h */
    private Uri f17340h;

    /* renamed from: i */
    private final int f17341i;

    /* renamed from: j */
    private final int f17342j;

    /* renamed from: k */
    private final int f17343k;

    /* renamed from: l */
    private boolean f17344l;

    /* renamed from: m */
    private boolean f17345m;

    /* renamed from: n */
    private ProgressDialog f17346n;

    /* renamed from: o */
    private ProgressDialog f17347o;

    /* renamed from: p */
    private C2075ah f17348p;

    /* renamed from: q */
    private String f17349q;

    /* renamed from: r */
    private File f17350r;

    /* renamed from: u */
    private File f17351u;

    /* renamed from: v */
    private File f17352v;

    /* renamed from: w */
    private String f17353w;

    /* renamed from: x */
    private boolean f17354x;

    /* renamed from: y */
    private boolean f17355y;

    /* renamed from: z */
    private Toast f17356z;

    /* renamed from: s */
    private static String f17282s = "profile_f_mine_";

    /* renamed from: t */
    private static String f17283t = "profile_t_mine_";

    /* renamed from: d */
    public static final String f17281d = ProfileImageHistoryActivity.class.getSimpleName();

    public ProfileImageHistoryFragment() {
        this.f17341i = 0;
        this.f17342j = 5;
        this.f17343k = 6;
        this.f17344l = false;
        this.f17345m = false;
        this.f17349q = C4873ck.m18501b();
        this.f17350r = new File(this.f17349q + "/profile/");
        this.f17310a = C4873ck.m18502c() + "/profilehistory/";
        this.f17335b = GlobalApplication.m18732r().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/";
        this.f17336c = GlobalApplication.m18732r().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/profilehistory/";
        this.f17351u = GlobalApplication.m18732r().getFilesDir().getAbsoluteFile();
        this.f17353w = "";
        this.f17354x = false;
        this.f17355y = false;
        this.f17294K = "?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&imei=" + C4809aa.m18104a().m18121a("imei", "");
        this.f17314ad = "";
        this.f17315ae = "";
        this.f17316af = 1;
        this.f17320aj = C4809aa.m18104a().m18121a("chaton_id", "");
        this.f17325ao = false;
        this.f17326ap = "";
        this.f17327aq = "";
        this.f17328ar = "";
        this.f17329as = false;
        this.f17337e = new C4775cg(this);
        this.f17331au = new DialogInterfaceOnClickListenerC4778cj(this);
        this.f17338f = new C4779ck(this);
        this.f17332av = new DialogInterfaceOnClickListenerC4764bw(this);
        this.f17333aw = new DialogInterfaceOnClickListenerC4765bx(this);
        this.f17334ax = new HandlerC4766by(this);
        this.f17325ao = false;
    }

    public ProfileImageHistoryFragment(int i) {
        this.f17341i = 0;
        this.f17342j = 5;
        this.f17343k = 6;
        this.f17344l = false;
        this.f17345m = false;
        this.f17349q = C4873ck.m18501b();
        this.f17350r = new File(this.f17349q + "/profile/");
        this.f17310a = C4873ck.m18502c() + "/profilehistory/";
        this.f17335b = GlobalApplication.m18732r().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/";
        this.f17336c = GlobalApplication.m18732r().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/profilehistory/";
        this.f17351u = GlobalApplication.m18732r().getFilesDir().getAbsoluteFile();
        this.f17353w = "";
        this.f17354x = false;
        this.f17355y = false;
        this.f17294K = "?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&imei=" + C4809aa.m18104a().m18121a("imei", "");
        this.f17314ad = "";
        this.f17315ae = "";
        this.f17316af = 1;
        this.f17320aj = C4809aa.m18104a().m18121a("chaton_id", "");
        this.f17325ao = false;
        this.f17326ap = "";
        this.f17327aq = "";
        this.f17328ar = "";
        this.f17329as = false;
        this.f17337e = new C4775cg(this);
        this.f17331au = new DialogInterfaceOnClickListenerC4778cj(this);
        this.f17338f = new C4779ck(this);
        this.f17332av = new DialogInterfaceOnClickListenerC4764bw(this);
        this.f17333aw = new DialogInterfaceOnClickListenerC4765bx(this);
        this.f17334ax = new HandlerC4766by(this);
        this.f17297N = i;
    }

    public ProfileImageHistoryFragment(String str, String str2, String str3) {
        this.f17341i = 0;
        this.f17342j = 5;
        this.f17343k = 6;
        this.f17344l = false;
        this.f17345m = false;
        this.f17349q = C4873ck.m18501b();
        this.f17350r = new File(this.f17349q + "/profile/");
        this.f17310a = C4873ck.m18502c() + "/profilehistory/";
        this.f17335b = GlobalApplication.m18732r().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/";
        this.f17336c = GlobalApplication.m18732r().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/profilehistory/";
        this.f17351u = GlobalApplication.m18732r().getFilesDir().getAbsoluteFile();
        this.f17353w = "";
        this.f17354x = false;
        this.f17355y = false;
        this.f17294K = "?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&imei=" + C4809aa.m18104a().m18121a("imei", "");
        this.f17314ad = "";
        this.f17315ae = "";
        this.f17316af = 1;
        this.f17320aj = C4809aa.m18104a().m18121a("chaton_id", "");
        this.f17325ao = false;
        this.f17326ap = "";
        this.f17327aq = "";
        this.f17328ar = "";
        this.f17329as = false;
        this.f17337e = new C4775cg(this);
        this.f17331au = new DialogInterfaceOnClickListenerC4778cj(this);
        this.f17338f = new C4779ck(this);
        this.f17332av = new DialogInterfaceOnClickListenerC4764bw(this);
        this.f17333aw = new DialogInterfaceOnClickListenerC4765bx(this);
        this.f17334ax = new HandlerC4766by(this);
        this.f17326ap = str;
        this.f17327aq = str2;
        this.f17328ar = str3;
        this.f17325ao = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f17321ak = (ProfileImageHistoryActivity) activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f17321ak = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17324an = true;
        this.f17321ak.m17933h().mo18823a(getText(R.string.mypage_profile_image));
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        C4904y.m18639b("onPrepareOptionMenu...", getClass().getSimpleName());
        menu.clear();
        if (!this.f17314ad.equals(this.f17315ae)) {
            menu.add(0, 1, 1, getString(R.string.save)).setIcon(R.drawable.more_option_save_white);
            menu.add(0, 2, 2, getString(R.string.trunk_btn_share)).setIcon(R.drawable.more_option_share_white);
            menu.add(0, 3, 3, R.string.mypage_set_as_profile_image).setIcon(R.drawable.more_option_set_image_white);
            menu.add(0, 4, 4, R.string.chat_view_menu_delete).setIcon(R.drawable.more_option_delete_white);
        } else {
            menu.add(0, 1, 1, getString(R.string.save)).setIcon(R.drawable.more_option_save_white);
            menu.add(0, 2, 2, getString(R.string.trunk_btn_share)).setIcon(R.drawable.more_option_share_white);
            menu.add(0, 4, 3, R.string.chat_view_menu_delete).setIcon(R.drawable.more_option_delete_white);
            menu.add(0, 5, 4, R.string.mypage_profile_image_set_as_default).setIcon(R.drawable.more_option_set_as_default_white);
        }
        boolean zExists = new File(this.f17310a, "profile_f_mine_" + this.f17315ae).exists();
        menu.findItem(1).setEnabled(zExists);
        menu.findItem(2).setEnabled(zExists);
        menu.findItem(4).setEnabled(zExists);
        if (menu.findItem(3) != null) {
            menu.findItem(3).setEnabled(zExists);
        }
        if (menu.findItem(5) != null) {
            menu.findItem(5).setEnabled(zExists);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f17330at = menu;
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                m17991g();
                break;
            case 2:
                m17993h();
                break;
            case 3:
                m17983d();
                break;
            case 4:
                m17985e();
                break;
            case 5:
                m17989f();
                break;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17953a(int i) {
        if (this.f17323am == R.array.profile_image_long_click_main) {
            switch (i) {
                case 0:
                    m17991g();
                    break;
                case 1:
                    m17993h();
                    break;
                case 2:
                    m17985e();
                    break;
                case 3:
                    m17989f();
                    break;
            }
        }
        switch (i) {
            case 0:
                m17991g();
                break;
            case 1:
                m17993h();
                break;
            case 2:
                m17983d();
                break;
            case 3:
                m17985e();
                break;
        }
    }

    /* renamed from: d */
    private void m17983d() {
        m18000l();
        this.f17348p.m9318f(this.f17315ae);
        this.f17346n.show();
    }

    /* renamed from: e */
    private void m17985e() {
        if (this.f17314ad.equals(this.f17315ae)) {
            if (this.f17308Y == null) {
                AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f17302S);
                abstractC4932aM18733a.mo18734a(R.string.menu_chat_delete).mo18746b(R.string.mypage_delete_current_image).mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC4771cc(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC4763bv(this));
                this.f17308Y = abstractC4932aM18733a.mo18745a();
            }
            this.f17308Y.show();
            return;
        }
        if (this.f17309Z == null) {
            AbstractC4932a abstractC4932aM18733a2 = AbstractC4932a.m18733a(this.f17302S);
            abstractC4932aM18733a2.mo18734a(R.string.menu_chat_delete).mo18746b(R.string.ams_delete_single_item).mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC4773ce(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC4772cd(this));
            this.f17309Z = abstractC4932aM18733a2.mo18745a();
        }
        this.f17309Z.show();
    }

    /* renamed from: f */
    private void m17989f() {
        m18000l();
        this.f17300Q = true;
        this.f17348p.m9318f("-1");
        this.f17346n.show();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws IOException {
        CallableC4761bt callableC4761bt;
        if (!this.f17325ao) {
            BaseActivity.m6160a((Fragment) this, true);
        } else {
            BaseActivity.m6160a((Fragment) this, false);
        }
        View viewInflate = layoutInflater.inflate(R.layout.layout_profile_image_view, viewGroup, false);
        this.f17346n = (ProgressDialog) new C4923p(getActivity()).m18724a(R.string.dialog_userprofile_updating);
        this.f17347o = (ProgressDialog) new C4923p(getActivity()).m18724a(R.string.dialog_connecting_server);
        this.f17339g = (ZoomableImageView) viewInflate.findViewById(R.id.profile_big_image);
        this.f17286C = (FrameLayout) viewInflate.findViewById(R.id.networkErrorView);
        this.f17286C.setVisibility(8);
        this.f17298O = (ImageView) viewInflate.findViewById(R.id.profile_image_loading);
        this.f17290G = (LinearLayout) viewInflate.findViewById(R.id.profile_default_image);
        this.f17290G.setVisibility(8);
        this.f17301R = (ImageView) viewInflate.findViewById(R.id.profile_error_image);
        this.f17302S = getActivity();
        this.f17303T = (ViewStub) viewInflate.findViewById(R.id.network_error_layout);
        this.f17293J = new C5007c();
        this.f17285B = (GridView) viewInflate.findViewById(R.id.list_bg_horizontal);
        this.f17285B.setOnItemClickListener(this.f17337e);
        this.f17287D = (LinearLayout) viewInflate.findViewById(R.id.profile_holder);
        this.f17288E = (FrameLayout) viewInflate.findViewById(R.id.profile_main_images);
        this.f17289F = (FrameLayout) viewInflate.findViewById(R.id.profile_grid_images);
        this.f17285B.setOnItemLongClickListener(this.f17338f);
        m17986e(this.f17302S.getResources().getConfiguration().orientation);
        setHasOptionsMenu(true);
        this.f17292I = new ArrayList<>();
        this.f17348p = new C2075ah(this.f17334ax);
        this.f17296M = (ProgressBar) viewInflate.findViewById(R.id.progress_loading);
        ProfileImageHistoryActivity.f17280n = this.f17315ae;
        this.f17299P = false;
        this.f17300Q = false;
        if (bundle != null && bundle.getParcelableArrayList("array") != null && bundle.getString("mProfileImageUrl") != null) {
            this.f17314ad = bundle.getString("mRepresentPImageId");
            this.f17315ae = bundle.getString("mCurrentPImageId");
            this.f17292I = bundle.getParcelableArrayList("array");
            this.f17295L = bundle.getString("mProfileImageUrl");
            this.f17316af = bundle.getInt("mCurrentPosition");
            this.f17317ag = bundle.getInt("mTotalProfileImageCount");
            this.f17297N = bundle.getInt("mSmallImageNum");
            this.f17300Q = Boolean.valueOf(bundle.getBoolean("mSetDefaultImageFlag"));
            this.f17318ah = bundle.getInt("mMaxImageCount");
            this.f17325ao = bundle.getBoolean("mBuddyMode");
            this.f17326ap = bundle.getString("mBuddyNo");
            this.f17327aq = bundle.getString("mbuddyImageID");
            this.f17328ar = bundle.getString("mbuddyImageType");
            this.f17329as = bundle.getBoolean("mNoSuchImage");
            C4904y.m18646e("mCurrentPImageId: " + this.f17315ae, getClass().getSimpleName());
            C4904y.m18646e("mProfileImageUrl: " + this.f17295L, getClass().getSimpleName());
            if (this.f17315ae == null) {
                this.f17290G.setVisibility(0);
            } else {
                ProfileImageHistoryActivity.f17280n = this.f17315ae;
                this.f17321ak.m17933h().mo18823a(((Object) getText(R.string.mypage_profile_image)) + " (" + this.f17316af + "/" + this.f17317ag + ")");
            }
            m17999k();
            this.f17301R.setVisibility(8);
            this.f17298O.setVisibility(8);
            if (!this.f17325ao) {
                callableC4761bt = new CallableC4761bt(this.f17298O, this.f17301R, this.f17295L + "&size=800", 600, 600, this.f17310a, "profile_f_mine_" + this.f17315ae, false);
            } else {
                callableC4761bt = new CallableC4761bt(this.f17298O, this.f17301R, this.f17295L + "&size=800", 600, 600, this.f17336c, "buddy_f_" + this.f17326ap + "_" + this.f17315ae, false);
            }
            if (callableC4761bt != null) {
                this.f17293J.m19023b(this.f17339g, callableC4761bt);
            }
        } else {
            this.f17296M.setVisibility(0);
            setHasOptionsMenu(false);
            m17965a(false, (C0778b) null, false);
        }
        if (bundle != null) {
            String string = bundle.getString("CAPTURE_IMAGE_URI");
            if (!TextUtils.isEmpty(string)) {
                this.f17340h = Uri.parse(string);
            }
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f17339g != null) {
            ViewTreeObserver viewTreeObserver = this.f17339g.getViewTreeObserver();
            this.f17284A = new ViewTreeObserverOnGlobalLayoutListenerC4774cf(this);
            viewTreeObserver.addOnGlobalLayoutListener(this.f17284A);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f17339g != null) {
            this.f17339g.getViewTreeObserver().removeGlobalOnLayoutListener(this.f17284A);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17964a(String str, String str2, boolean z) {
        File file = new File(this.f17310a, "profile_t_mine_" + str);
        File file2 = new File(this.f17310a, "profile_f_mine_" + str);
        if (file2.exists()) {
            m17961a(file2);
            if (z) {
                m17973b(str);
            }
        } else {
            m17961a(file);
            this.f17301R.setVisibility(8);
            this.f17298O.setVisibility(8);
            C4904y.m18646e("setThumbOrFullProfileImage mUrl: " + str2 + "&size=800", getClass().getSimpleName());
            this.f17293J.m19023b(this.f17339g, new CallableC4761bt(this.f17298O, this.f17301R, str2 + "&size=800", 600, 600, this.f17310a, "profile_f_mine_" + str, z, this.f17334ax));
        }
        this.f17290G.setVisibility(8);
        C4904y.m18639b("photoFile=" + file, getClass().getSimpleName());
        C4904y.m18639b("photoFileFull=" + file2, getClass().getSimpleName());
    }

    /* renamed from: a */
    private void m17961a(File file) {
        this.f17301R.setVisibility(8);
        this.f17298O.setVisibility(8);
        if (file.exists()) {
            this.f17293J.m19023b(this.f17339g, new CallableC4784cp(file, false, true));
        }
    }

    /* renamed from: g */
    private void m17991g() {
        if (!C4847bl.m18333a()) {
            String str = this.f17310a + "profile_f_mine_" + this.f17315ae;
            if (!C4873ck.m18500a()) {
                C5179v.m19810a(this.f17302S, R.string.sdcard_not_found, 0).show();
            } else {
                AsyncTaskC2751a.m11541a(str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//ChatON", "profile_f_mine_" + this.f17315ae + ".jpg", true).execute(new String[0]);
            }
        }
    }

    /* renamed from: h */
    private void m17993h() {
        if (!C4847bl.m18333a()) {
            try {
                Bitmap bitmapM19109a = C5035l.m19109a(CommonApplication.m18732r(), new File(this.f17310a + "profile_f_mine_" + this.f17315ae), 600, 600);
                bitmapM19109a.setDensity(160);
                Intent intentM18489a = C4869cg.m18489a(this.f17302S, getString(R.string.trunk_opt_header_share), bitmapM19109a, (String) null, (String) null, false);
                if (intentM18489a != null) {
                    startActivity(intentM18489a);
                }
            } catch (IOException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f17281d);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17962a(String str) {
        ProfileImageItem profileImageItem;
        for (int i = 0; i < this.f17285B.getChildCount() && (profileImageItem = (ProfileImageItem) this.f17285B.getChildAt(i).getTag()) != null; i++) {
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
    public void m17965a(boolean z, C0778b c0778b, boolean z2) throws IOException {
        if (!this.f17325ao) {
            if (this.f17292I.size() > 0) {
                this.f17292I.clear();
            }
            ProfileImageItem profileImageItem = new ProfileImageItem();
            profileImageItem.f17357id = "addImage";
            this.f17292I.add(profileImageItem);
            m17999k();
            if (this.f17285B != null) {
                this.f17285B.setEnabled(false);
            }
            this.f17299P = false;
            if (z && c0778b != null) {
                m17956a(c0778b, z2);
                return;
            } else {
                this.f17348p.m9313d();
                m18011q();
                return;
            }
        }
        this.f17348p.m9306a(this.f17326ap, "600");
        m18013r();
    }

    public class ProfileImageItem implements Parcelable {
        public static final Parcelable.Creator<ProfileImageItem> CREATOR = new C4780cl();
        public String FullfileName;
        public String Represent;
        public String ThumbfileName;
        public String dirCachePath;

        /* renamed from: id */
        public String f17357id;
        public String imageId;
        public ImageView selectedImage;
        public ImageView thumbImage;

        public ProfileImageItem() {
        }

        public ProfileImageItem(Parcel parcel) {
            m18028a(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f17357id);
            parcel.writeString(this.imageId);
            parcel.writeString(this.dirCachePath);
            parcel.writeString(this.ThumbfileName);
            parcel.writeString(this.FullfileName);
            parcel.writeString(this.Represent);
        }

        /* renamed from: a */
        private void m18028a(Parcel parcel) {
            this.f17357id = parcel.readString();
            this.imageId = parcel.readString();
            this.dirCachePath = parcel.readString();
            this.ThumbfileName = parcel.readString();
            this.FullfileName = parcel.readString();
            this.Represent = parcel.readString();
        }
    }

    /* renamed from: a */
    public void m18025a() throws IOException {
        try {
            if (!this.f17350r.canRead()) {
                this.f17350r.mkdirs();
            }
            m18014s();
            this.f17353w = "tmp_" + System.currentTimeMillis() + ".jpeg_";
            this.f17352v = new File(this.f17350r + "/", this.f17353w);
            C4904y.m18639b("[Create File] " + this.f17350r.toString() + this.f17353w + " : " + this.f17352v.createNewFile(), f17281d);
            this.f17340h = null;
            String str = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()) + ".jpg";
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//Camera//");
            if (!file.exists()) {
                file.mkdir();
            }
            this.f17340h = Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//Camera//", str));
            if (!m18026b() || !m18027c()) {
                if (this.f17356z == null) {
                    this.f17356z = C5179v.m19811a(this.f17302S, getString(R.string.toast_sdcard_amount), 1);
                }
                this.f17356z.show();
                return;
            }
            new Intent("android.intent.action.PICK").setType("image/*");
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f17302S);
            abstractC4932aM18733a.mo18734a(R.string.mypage_profile_add_photo).mo18736a(R.array.selphoto, this.f17332av);
            if (this.f17312ab == null) {
                abstractC4932aM18733a.mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC4777ci(this));
                this.f17312ab = abstractC4932aM18733a.mo18745a();
            }
            this.f17312ab.show();
            if (this.f17344l) {
                this.f17312ab.dismiss();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m17995i() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        if (!BuddyProfileActivity.m6743a(this.f17302S, intent)) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
        } else {
            try {
                startActivityForResult(intent, 5);
            } catch (ActivityNotFoundException e) {
                C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f17281d);
                }
            }
        }
        this.f17344l = true;
    }

    /* renamed from: a */
    private void m17954a(int i, String str) {
        switch (i) {
            case 0:
                C4809aa.m18108a("profile_small_image1", str);
                break;
            case 1:
                C4809aa.m18108a("profile_small_image2", str);
                break;
            case 2:
                C4809aa.m18108a("profile_small_image3", str);
                break;
        }
    }

    /* renamed from: a */
    private void m17955a(int i, ArrayList<ProfileImage> arrayList) {
        if (i < 4 && i > 0) {
            C4904y.m18646e("mImageNum: " + i, getClass().getSimpleName());
            if (arrayList != null && arrayList.size() >= i && !this.f17299P.booleanValue()) {
                this.f17315ae = arrayList.get(i - 1).profileimageid;
                this.f17295L = arrayList.get(i - 1).profileimageurl;
                this.f17321ak.m17933h().mo18823a(((Object) getText(R.string.mypage_profile_image)) + " (" + i + "/" + this.f17317ag + ")");
                setHasOptionsMenu(true);
                this.f17290G.setVisibility(8);
                m17963a(this.f17295L, this.f17315ae, this.f17339g, this.f17298O, this.f17301R, true);
                this.f17299P = true;
                this.f17297N = 0;
                return;
            }
            if (arrayList != null && arrayList.size() > i && this.f17299P.booleanValue()) {
                this.f17315ae = arrayList.get(i).profileimageid;
                this.f17295L = arrayList.get(i).profileimageurl;
                this.f17321ak.m17933h().mo18823a(((Object) getText(R.string.mypage_profile_image)) + " (" + (i + 1) + "/" + this.f17317ag + ")");
                setHasOptionsMenu(true);
                this.f17290G.setVisibility(8);
                m17963a(this.f17295L, this.f17315ae, this.f17339g, this.f17298O, this.f17301R, true);
                this.f17299P = true;
                this.f17297N = 0;
                return;
            }
            if (!this.f17299P.booleanValue()) {
                setHasOptionsMenu(false);
                this.f17290G.setVisibility(0);
                return;
            } else {
                if (arrayList != null && arrayList.size() > 0) {
                    m17963a(this.f17295L, this.f17315ae, this.f17339g, this.f17298O, this.f17301R, true);
                    return;
                }
                return;
            }
        }
        if (this.f17299P.booleanValue()) {
            m17963a(this.f17295L, this.f17315ae, this.f17339g, this.f17298O, this.f17301R, true);
        }
    }

    /* renamed from: b */
    private void m17971b(int i) {
        if (i < 4) {
            C4809aa.m18108a("profile_small_image3", (String) null);
        }
        if (i < 3) {
            C4809aa.m18108a("profile_small_image2", (String) null);
        }
        if (i < 2) {
            C4809aa.m18108a("profile_small_image1", (String) null);
        }
    }

    /* renamed from: j */
    private void m17997j() {
        C4809aa.m18108a("profile_image_status", "deleted");
        C4809aa.m18108a("profile_small_image0", (String) null);
        this.f17290G.setVisibility(0);
        this.f17339g.setImageBitmap(null);
    }

    /* renamed from: b */
    private void m17973b(String str) {
        C4809aa.m18108a("profile_image_status", "updated");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m17999k() {
        ProfileImageHistoryActivity.f17280n = this.f17315ae;
        if (this.f17291H == null) {
            this.f17291H = new C4760bs(this.f17302S.getApplicationContext(), R.layout.item_profile_image, this.f17292I, this.f17293J);
            if (this.f17285B != null) {
                this.f17285B.setAdapter((ListAdapter) this.f17291H);
            }
        } else {
            this.f17291H.notifyDataSetChanged();
        }
        if (this.f17325ao) {
            for (int i = 0; i < this.f17317ag; i++) {
                if (this.f17315ae.equals(this.f17291H.getItem(i).imageId)) {
                    this.f17316af = i + 1;
                    if (this.f17321ak != null) {
                        this.f17321ak.m17933h().mo18823a(((Object) getText(R.string.mypage_profile_image)) + " (" + this.f17316af + "/" + this.f17317ag + ")");
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m18000l() {
        getActivity().setRequestedOrientation(C5034k.m19089a((Activity) getActivity()));
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
                    if (this.f17346n != null) {
                        this.f17346n.dismiss();
                    }
                    if (this.f17315ae == null || this.f17315ae.length() == 0) {
                        this.f17290G.setVisibility(0);
                    }
                    if (i2 == -1) {
                        intent.getExtras().getInt("activity_orientation");
                        getActivity().setRequestedOrientation(C5034k.m19089a((Activity) getActivity()));
                        File file = new File(Uri.parse(intent.getExtras().getString("temp_file_path")).getPath());
                        this.f17353w = "tmp_" + System.currentTimeMillis() + ".jpeg_";
                        this.f17352v = new File(this.f17350r + "/", this.f17353w);
                        if (file.length() <= 0) {
                            C4904y.m18634a("Crop return null!", f17281d);
                            break;
                        } else {
                            try {
                                C4636a.m17602a(file, this.f17352v);
                                this.f17348p.m9305a(this.f17352v.getPath());
                                if (this.f17346n != null) {
                                    this.f17346n.show();
                                    break;
                                }
                            } catch (Exception e) {
                                C4904y.m18635a(e, getClass().getSimpleName());
                                m18007o();
                                return;
                            }
                        }
                    }
                    break;
                case 5:
                    if (intent == null) {
                        C4904y.m18639b("Crop Return is NULL", getClass().getSimpleName());
                        if (this.f17346n != null) {
                            this.f17346n.dismiss();
                            break;
                        }
                    } else {
                        this.f17340h = intent.getData();
                        m17978c(10);
                        break;
                    }
                    break;
                case 6:
                    if (i2 == -1) {
                        if (this.f17340h != null) {
                            MediaScannerConnection.scanFile(this.f17321ak, new String[]{this.f17340h.getPath()}, null, null);
                        }
                        m17984d(11);
                        break;
                    } else {
                        if (this.f17346n != null) {
                            this.f17346n.dismiss();
                        }
                        C4904y.m18639b("Camera Return is NULL", getClass().getSimpleName());
                        break;
                    }
            }
            return;
        }
        if (m17966a(i, intent)) {
        }
    }

    /* renamed from: a */
    private boolean m17966a(int i, Intent intent) {
        switch (i) {
            case 10:
                if (intent != null && intent.getBooleanExtra("restart", false)) {
                    m18003m();
                    return true;
                }
                break;
            case 11:
                if (intent != null && intent.getBooleanExtra("restart", false)) {
                    m18005n();
                    return true;
                }
                break;
        }
        return false;
    }

    /* renamed from: m */
    private void m18003m() {
        m17995i();
    }

    /* renamed from: n */
    private void m18005n() {
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
        intent.putExtra("output", this.f17340h);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        try {
            startActivityForResult(intent, 6);
        } catch (ActivityNotFoundException e) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f17281d);
            }
        }
        this.f17344l = true;
    }

    /* renamed from: c */
    private void m17978c(int i) {
        Intent intent = new Intent(this.f17302S, (Class<?>) ImageModify.class);
        intent.setDataAndType(this.f17340h, "image/*");
        intent.putExtra("outputX", 600);
        intent.putExtra("outputY", 600);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, i);
    }

    /* renamed from: d */
    private void m17984d(int i) {
        Intent intent = new Intent(this.f17302S, (Class<?>) ImageModify.class);
        intent.setDataAndType(this.f17340h, "image/*");
        intent.putExtra("outputX", 600);
        intent.putExtra("outputY", 600);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m18007o() {
        try {
            this.f17290G.setVisibility(0);
            C1113ad.m7106a("Me", BitmapFactory.decodeResource(GlobalApplication.m10283b(), R.drawable.profile_photo_buddy_default));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: p */
    private void m18009p() {
        try {
            this.f17339g.setImageResource(R.drawable.profile_photo_buddy_default);
            C1113ad.m7106a("Me", BitmapFactory.decodeResource(GlobalApplication.m10283b(), R.drawable.profile_photo_buddy_default));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: q */
    private void m18011q() {
        File file;
        this.f17301R.setVisibility(8);
        this.f17298O.setVisibility(8);
        C4904y.m18646e("UserProfile initialize() - img status: " + C4809aa.m18104a().m18121a("profile_image_status", ""), getClass().getSimpleName());
        if (C4809aa.m18104a().m18121a("profile_image_status", "").equals("updated") || this.f17297N != 0) {
            if (this.f17297N == 1 && !C4809aa.m18104a().m18121a("profile_small_image1", "").equals("")) {
                file = new File(this.f17310a, "profile_f_mine_" + C4809aa.m18104a().m18121a("profile_small_image1", ""));
                if (!file.exists()) {
                    file = new File(this.f17310a, "profile_t_mine_" + C4809aa.m18104a().m18121a("profile_small_image1", ""));
                }
            } else if (this.f17297N == 2 && !C4809aa.m18104a().m18121a("profile_small_image2", "").equals("")) {
                file = new File(this.f17310a, "profile_f_mine_" + C4809aa.m18104a().m18121a("profile_small_image2", ""));
                if (!file.exists()) {
                    file = new File(this.f17310a, "profile_t_mine_" + C4809aa.m18104a().m18121a("profile_small_image2", ""));
                }
            } else if (this.f17297N == 3 && !C4809aa.m18104a().m18121a("profile_small_image3", "").equals("")) {
                file = new File(this.f17310a, "profile_f_mine_" + C4809aa.m18104a().m18121a("profile_small_image3", ""));
                if (!file.exists()) {
                    file = new File(this.f17310a, "profile_t_mine_" + C4809aa.m18104a().m18121a("profile_small_image3", ""));
                }
            } else {
                file = new File(this.f17351u, "myprofile.png_");
            }
            C4904y.m18639b("photoFile=" + file, getClass().getSimpleName());
            if (file.exists()) {
                this.f17293J.m19023b(this.f17339g, new CallableC4784cp(file, false, true));
                return;
            } else {
                m18007o();
                return;
            }
        }
        m18007o();
    }

    /* renamed from: r */
    private void m18013r() {
        boolean z;
        if (this.f17328ar.equals("FULL")) {
            File file = new File(this.f17335b + this.f17326ap + "/", "buddy_f_" + this.f17326ap + "_" + this.f17327aq);
            if (file.exists()) {
                this.f17293J.m19023b(this.f17339g, new CallableC4784cp(file, false, true));
                return;
            } else {
                m18009p();
                return;
            }
        }
        if (this.f17328ar.equals("THUMB")) {
            File file2 = new File(this.f17336c, "buddy_f_" + this.f17326ap + "_" + this.f17327aq);
            if (file2.exists()) {
                z = true;
            } else {
                file2 = new File(this.f17335b + this.f17326ap + "/", "buddy_t_" + this.f17326ap + "_" + this.f17327aq);
                if (file2.exists()) {
                    this.f17329as = true;
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                if (file2.exists()) {
                    this.f17293J.m19023b(this.f17339g, new CallableC4784cp(file2, false, true));
                    return;
                }
                return;
            }
            m18009p();
        }
    }

    /* renamed from: s */
    private void m18014s() {
        if (!m18026b() || !m18027c()) {
            C4904y.m18634a("[deleteTempFolder] External Storage Is Not Available or Writable!", f17281d);
            if (this.f17356z == null) {
                this.f17356z = C5179v.m19811a(this.f17302S, getString(R.string.toast_sdcard_amount), 1);
            }
            this.f17356z.show();
            return;
        }
        String strM18501b = C4873ck.m18501b();
        if (strM18501b.length() == 0) {
            this.f17356z.show();
            return;
        }
        try {
            String[] list = new File(strM18501b + "/profile/").list();
            if (list != null) {
                for (String str : list) {
                    C4904y.m18639b("[Delete File] " + strM18501b + "/profile/" + str + " : " + new File(strM18501b + "/profile/" + str).delete(), f17281d);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    protected boolean m18026b() {
        m18017t();
        return this.f17354x;
    }

    /* renamed from: c */
    protected boolean m18027c() {
        m18017t();
        return this.f17355y;
    }

    /* renamed from: t */
    private void m18017t() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f17354x = true;
            this.f17355y = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f17354x = true;
            this.f17355y = false;
        } else {
            this.f17354x = false;
            this.f17355y = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.f17293J != null) {
            this.f17293J.m19014a();
        }
        if (this.f17346n.isShowing()) {
            this.f17346n.dismiss();
        }
        if (this.f17347o.isShowing()) {
            this.f17347o.dismiss();
        }
        if (this.f17308Y != null) {
            this.f17308Y.dismiss();
        }
        if (this.f17309Z != null) {
            this.f17309Z.dismiss();
        }
        if (this.f17311aa != null) {
            this.f17311aa.dismiss();
        }
        if (this.f17312ab != null) {
            this.f17312ab.dismiss();
        }
        if (this.f17313ac != null) {
            this.f17313ac.dismiss();
        }
        if (this.f17285B != null) {
            this.f17285B.setAdapter((ListAdapter) null);
            this.f17285B.setOnItemClickListener(null);
            this.f17285B = null;
        }
        this.f17348p.m9315e();
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("mCurrentPImageId", this.f17315ae);
        bundle.putString("mRepresentPImageId", this.f17314ad);
        bundle.putString("mProfileImageUrl", this.f17295L);
        bundle.putParcelableArrayList("array", this.f17292I);
        bundle.putInt("mCurrentPosition", this.f17316af);
        bundle.putInt("mTotalProfileImageCount", this.f17317ag);
        bundle.putInt("mSmallImageNum", this.f17297N);
        bundle.putBoolean("mSetDefaultImageFlag", this.f17300Q.booleanValue());
        bundle.putInt("mMaxImageCount", this.f17318ah);
        bundle.putBoolean("mBuddyMode", this.f17325ao);
        bundle.putString("mBuddyNo", this.f17326ap);
        bundle.putString("mbuddyImageID", this.f17327aq);
        bundle.putString("mbuddyImageType", this.f17328ar);
        bundle.putBoolean("mNoSuchImage", this.f17329as);
        if (this.f17340h != null) {
            bundle.putString("CAPTURE_IMAGE_URI", this.f17340h.toString());
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m17986e(configuration.orientation);
    }

    /* renamed from: e */
    private void m17986e(int i) {
        LinearLayout.LayoutParams layoutParams = null;
        LinearLayout.LayoutParams layoutParams2 = null;
        if (i == 2) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 0.5f;
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            layoutParams2.weight = 0.5f;
            layoutParams2.leftMargin = 4;
            layoutParams2.rightMargin = 4;
            this.f17287D.setOrientation(0);
        } else if (i == 1) {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 0.7f;
            layoutParams.gravity = 17;
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
            layoutParams2.weight = 0.3f;
            layoutParams2.gravity = 17;
            this.f17287D.setOrientation(1);
        }
        this.f17288E.setLayoutParams(layoutParams);
        this.f17289F.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17956a(C0778b c0778b, boolean z) throws IOException {
        if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
            GetProfileImageList getProfileImageList = (GetProfileImageList) c0778b.m3110e();
            if (getProfileImageList == null) {
                this.f17316af = 0;
                return;
            }
            this.f17317ag = getProfileImageList.listcount.intValue();
            this.f17318ah = getProfileImageList.maxcount.intValue();
            this.f17319ai = getProfileImageList.profileimagelist;
            C4904y.m18646e("mTotalProfileImageCount: " + this.f17317ag, getClass().getSimpleName());
            C4904y.m18646e("mMaxImageCount: " + this.f17318ah, getClass().getSimpleName());
            if (this.f17319ai != null && this.f17319ai.size() > 0) {
                if (Spam.ACTIVITY_REPORT.equals(this.f17319ai.get(0).represent)) {
                    this.f17290G.setVisibility(8);
                    C4809aa.m18108a("profile_image_status", "updated");
                    m17971b(this.f17319ai.size());
                } else {
                    m17997j();
                    m17971b(this.f17319ai.size() - 1);
                }
            } else {
                m17997j();
                C4809aa.m18108a("profile_small_image1", (String) null);
                C4809aa.m18108a("profile_small_image2", (String) null);
                C4809aa.m18108a("profile_small_image3", (String) null);
            }
            if (this.f17319ai != null && this.f17319ai.size() > 0) {
                for (int i = 0; i < this.f17319ai.size(); i++) {
                    ProfileImage profileImage = this.f17319ai.get(i);
                    if (Spam.ACTIVITY_REPORT.equals(profileImage.represent)) {
                        this.f17315ae = profileImage.profileimageid;
                        this.f17295L = profileImage.profileimageurl;
                        this.f17314ad = profileImage.profileimageid;
                        ProfileImageHistoryActivity.f17280n = this.f17315ae;
                        this.f17299P = true;
                        int i2 = i + 1;
                        if (this.f17321ak != null) {
                            this.f17321ak.m17933h().mo18823a(((Object) getText(R.string.mypage_profile_image)) + " (" + i2 + "/" + this.f17317ag + ")");
                        }
                        File file = new File(this.f17335b + "myprofile.png_");
                        if (!C4809aa.m18104a().m18121a("profile_small_image0", "").equals(profileImage.profileimageid) || !file.exists()) {
                            m17964a(profileImage.profileimageid, profileImage.profileimageurl + this.f17294K, true);
                        }
                    } else if (Spam.ACTIVITY_REPORT.equals(this.f17319ai.get(0).represent)) {
                        m17954a(i - 1, profileImage.profileimageid);
                    } else {
                        m17954a(i, profileImage.profileimageid);
                        C4809aa.m18108a("profile_small_image0", (String) null);
                    }
                    C4904y.m18646e("profileimageurl: " + profileImage.profileimageurl.toString(), getClass().getSimpleName());
                    ProfileImageItem profileImageItem = new ProfileImageItem();
                    profileImageItem.f17357id = profileImage.profileimageurl.toString() + this.f17294K;
                    profileImageItem.dirCachePath = this.f17310a;
                    profileImageItem.ThumbfileName = "profile_t_mine_" + profileImage.profileimageid;
                    profileImageItem.FullfileName = "profile_f_mine_" + profileImage.profileimageid;
                    profileImageItem.Represent = profileImage.represent;
                    profileImageItem.imageId = profileImage.profileimageid;
                    C4904y.m18646e("profileimageurl : " + profileImageItem.f17357id, getClass().getSimpleName());
                    this.f17292I.add(profileImageItem);
                }
                if (z && this.f17316af > 1) {
                    if (this.f17319ai.size() >= this.f17316af - 1) {
                        this.f17315ae = this.f17319ai.get(this.f17316af - 2).profileimageid;
                        this.f17295L = this.f17319ai.get(this.f17316af - 2).profileimageurl;
                        this.f17321ak.m17933h().mo18823a(((Object) getText(R.string.mypage_profile_image)) + " (" + (this.f17316af - 1) + "/" + this.f17317ag + ")");
                        m17964a(this.f17315ae, this.f17295L + this.f17294K, false);
                        this.f17316af--;
                    } else {
                        this.f17315ae = this.f17319ai.get(this.f17319ai.size() - 1).profileimageid;
                        this.f17295L = this.f17319ai.get(this.f17319ai.size() - 1).profileimageurl;
                        this.f17321ak.m17933h().mo18823a(((Object) getText(R.string.mypage_profile_image)) + " (" + this.f17319ai.size() + "/" + this.f17317ag + ")");
                        m17964a(this.f17315ae, this.f17295L + this.f17294K, false);
                        this.f17316af = this.f17319ai.size();
                    }
                    this.f17290G.setVisibility(8);
                } else if (this.f17297N == 0) {
                    if (Spam.ACTIVITY_REPORT.equals(this.f17319ai.get(0).represent)) {
                        this.f17316af = 1;
                    } else {
                        this.f17316af = 0;
                    }
                }
            }
            m17955a(this.f17297N, this.f17319ai);
            if (!this.f17299P.booleanValue()) {
                setHasOptionsMenu(false);
            } else {
                setHasOptionsMenu(true);
            }
            m17999k();
            if (this.f17285B != null) {
                this.f17285B.setEnabled(true);
            }
            this.f17296M.setVisibility(8);
            if (this.f17346n.isShowing()) {
                this.f17346n.dismiss();
            }
            if (this.f17347o.isShowing()) {
                this.f17347o.dismiss();
            }
            if (this.f17345m) {
                m18025a();
                this.f17345m = false;
            }
            getActivity().setRequestedOrientation(-1);
            return;
        }
        this.f17296M.setVisibility(8);
        if (this.f17347o.isShowing()) {
            this.f17347o.dismiss();
        }
        if (this.f17346n.isShowing()) {
            this.f17346n.dismiss();
        }
        this.f17286C.setVisibility(0);
        m18019u();
        C5179v.m19810a(getActivity(), R.string.toast_network_unable, 0).show();
        getActivity().setRequestedOrientation(-1);
    }

    /* renamed from: a */
    private void m17963a(String str, String str2, ImageView imageView, ImageView imageView2, ImageView imageView3, Boolean bool) {
        String str3;
        int i;
        String str4;
        if (bool.booleanValue()) {
            str3 = str + this.f17294K + "&size=800";
            i = 800;
            str4 = f17282s;
        } else {
            str3 = str + this.f17294K + "&size=140";
            i = 140;
            str4 = f17283t;
        }
        if (str2 != null) {
            File file = new File(this.f17310a, str4 + str2);
            if (!file.exists()) {
                this.f17293J.m19023b(imageView, new CallableC4761bt(imageView2, imageView3, str3, i, i, this.f17310a, str4 + str2, false, this.f17334ax));
                return;
            }
            imageView.setImageBitmap(C4812ad.m18145a(GlobalApplication.m18732r(), file.getAbsolutePath()));
        }
    }

    /* renamed from: u */
    private void m18019u() {
        if (this.f17304U == null) {
            this.f17304U = this.f17303T.inflate();
            this.f17305V = (ImageView) this.f17304U.findViewById(R.id.image1);
            this.f17305V.setImageResource(R.drawable.no_contents_network);
            this.f17306W = (TextView) this.f17304U.findViewById(R.id.text1);
            this.f17306W.setText(getResources().getString(R.string.toast_network_unable));
            this.f17307X = (TextView) this.f17304U.findViewById(R.id.text2);
            this.f17307X.setVisibility(8);
        }
    }
}
