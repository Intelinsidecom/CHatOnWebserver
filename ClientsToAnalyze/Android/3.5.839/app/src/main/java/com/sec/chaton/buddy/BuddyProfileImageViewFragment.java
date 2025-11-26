package com.sec.chaton.buddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
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
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.image.ZoomableImageView;
import com.sec.chaton.p055d.C2075ah;
import com.sec.chaton.p065io.entry.inner.ProfileImage;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.userprofile.CallableC4761bt;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import com.sec.common.p132g.C5007c;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BuddyProfileImageViewFragment extends Fragment {

    /* renamed from: e */
    public static final String f4021e = BuddyProfileImageView.class.getSimpleName();

    /* renamed from: A */
    private String f4022A;

    /* renamed from: B */
    private ProgressBar f4023B;

    /* renamed from: C */
    private int f4024C;

    /* renamed from: D */
    private ImageView f4025D;

    /* renamed from: E */
    private Boolean f4026E;

    /* renamed from: F */
    private Boolean f4027F;

    /* renamed from: G */
    private String f4028G;

    /* renamed from: H */
    private String f4029H;

    /* renamed from: I */
    private int f4030I;

    /* renamed from: J */
    private int f4031J;

    /* renamed from: K */
    private ArrayList<ProfileImage> f4032K;

    /* renamed from: L */
    private String f4033L;

    /* renamed from: M */
    private String f4034M;

    /* renamed from: N */
    private String f4035N;

    /* renamed from: O */
    private boolean f4036O;

    /* renamed from: P */
    private Activity f4037P;

    /* renamed from: Q */
    private Handler f4038Q;

    /* renamed from: a */
    String f4039a;

    /* renamed from: b */
    String f4040b;

    /* renamed from: c */
    String f4041c;

    /* renamed from: d */
    String f4042d;

    /* renamed from: f */
    ImageView f4043f;

    /* renamed from: g */
    AdapterView.OnItemClickListener f4044g;

    /* renamed from: h */
    int f4045h;

    /* renamed from: i */
    private ZoomableImageView f4046i;

    /* renamed from: j */
    private ProgressDialog f4047j;

    /* renamed from: k */
    private C2075ah f4048k;

    /* renamed from: l */
    private boolean f4049l;

    /* renamed from: m */
    private boolean f4050m;

    /* renamed from: n */
    private ViewTreeObserver.OnGlobalLayoutListener f4051n;

    /* renamed from: o */
    private GridView f4052o;

    /* renamed from: p */
    private FrameLayout f4053p;

    /* renamed from: q */
    private LinearLayout f4054q;

    /* renamed from: r */
    private FrameLayout f4055r;

    /* renamed from: s */
    private FrameLayout f4056s;

    /* renamed from: t */
    private LinearLayout f4057t;

    /* renamed from: u */
    private C1329gi f4058u;

    /* renamed from: v */
    private ArrayList<ProfileImageItem> f4059v;

    /* renamed from: w */
    private C5007c f4060w;

    /* renamed from: x */
    private String f4061x;

    /* renamed from: y */
    private String f4062y;

    /* renamed from: z */
    private String f4063z;

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f4037P = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f4037P = null;
    }

    public BuddyProfileImageViewFragment() {
        this.f4039a = C4873ck.m18502c();
        this.f4040b = C4873ck.m18502c() + "/profilehistory/";
        this.f4041c = GlobalApplication.m18732r().getCacheDir().getAbsoluteFile().getAbsolutePath() + "/";
        this.f4042d = GlobalApplication.m18732r().getCacheDir().getAbsoluteFile().getAbsolutePath() + "/profilehistory/";
        this.f4049l = false;
        this.f4050m = false;
        this.f4061x = "?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&imei=" + C4809aa.m18104a().m18121a("imei", "");
        this.f4028G = "";
        this.f4029H = "";
        this.f4030I = 1;
        this.f4033L = "";
        this.f4034M = "";
        this.f4035N = "";
        this.f4036O = false;
        this.f4043f = null;
        this.f4044g = new C1339gs(this);
        this.f4038Q = new HandlerC1340gt(this);
        this.f4045h = 20;
    }

    public BuddyProfileImageViewFragment(String str, String str2, String str3) {
        this.f4039a = C4873ck.m18502c();
        this.f4040b = C4873ck.m18502c() + "/profilehistory/";
        this.f4041c = GlobalApplication.m18732r().getCacheDir().getAbsoluteFile().getAbsolutePath() + "/";
        this.f4042d = GlobalApplication.m18732r().getCacheDir().getAbsoluteFile().getAbsolutePath() + "/profilehistory/";
        this.f4049l = false;
        this.f4050m = false;
        this.f4061x = "?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&imei=" + C4809aa.m18104a().m18121a("imei", "");
        this.f4028G = "";
        this.f4029H = "";
        this.f4030I = 1;
        this.f4033L = "";
        this.f4034M = "";
        this.f4035N = "";
        this.f4036O = false;
        this.f4043f = null;
        this.f4044g = new C1339gs(this);
        this.f4038Q = new HandlerC1340gt(this);
        this.f4045h = 20;
        this.f4033L = str;
        this.f4034M = str2;
        this.f4035N = str3;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BaseActivity.m6160a((Fragment) this, false);
        View viewInflate = layoutInflater.inflate(R.layout.layout_profile_image_view, viewGroup, false);
        this.f4047j = (ProgressDialog) new C4923p(this.f4037P).m18724a(R.string.dialog_userprofile_updating);
        this.f4046i = (ZoomableImageView) viewInflate.findViewById(R.id.profile_big_image);
        this.f4053p = (FrameLayout) viewInflate.findViewById(R.id.networkErrorView);
        this.f4053p.setVisibility(8);
        this.f4025D = (ImageView) viewInflate.findViewById(R.id.profile_image_loading);
        this.f4057t = (LinearLayout) viewInflate.findViewById(R.id.profile_default_image);
        this.f4057t.setVisibility(8);
        this.f4060w = new C5007c();
        this.f4052o = (GridView) viewInflate.findViewById(R.id.list_bg_horizontal);
        this.f4052o.setOnItemClickListener(this.f4044g);
        this.f4054q = (LinearLayout) viewInflate.findViewById(R.id.profile_holder);
        this.f4055r = (FrameLayout) viewInflate.findViewById(R.id.profile_main_images);
        this.f4056s = (FrameLayout) viewInflate.findViewById(R.id.profile_grid_images);
        m6868a(this.f4037P.getResources().getConfiguration().orientation);
        setHasOptionsMenu(false);
        this.f4059v = new ArrayList<>();
        this.f4048k = new C2075ah(this.f4038Q);
        this.f4023B = (ProgressBar) viewInflate.findViewById(R.id.progress_loading);
        BuddyProfileImageView.f4020n = this.f4029H;
        this.f4026E = false;
        this.f4027F = false;
        if (bundle != null && bundle.getParcelableArrayList("array") != null && bundle.getString("mProfileImageUrl") != null) {
            this.f4028G = bundle.getString("mRepresentPImageId");
            this.f4029H = bundle.getString("mCurrentPImageId");
            this.f4059v = bundle.getParcelableArrayList("array");
            this.f4022A = bundle.getString("mProfileImageUrl");
            this.f4030I = bundle.getInt("mCurrentPosition");
            this.f4031J = bundle.getInt("mTotalProfileImageCount");
            this.f4024C = bundle.getInt("mSmallImageNum");
            this.f4033L = bundle.getString("mBuddyNo");
            this.f4034M = bundle.getString("mbuddyImageID");
            this.f4035N = bundle.getString("mbuddyImageType");
            this.f4036O = bundle.getBoolean("mNoSuchImage");
            C4904y.m18646e("mCurrentPImageId: " + this.f4029H, getClass().getSimpleName());
            C4904y.m18646e("mProfileImageUrl: " + this.f4022A, getClass().getSimpleName());
            BuddyProfileImageView.f4020n = this.f4029H;
            this.f4037P.setTitle(((Object) getText(R.string.mypage_profile_image)) + " (" + this.f4030I + "/" + this.f4031J + ")");
            this.f4060w.m19023b(this.f4046i, new CallableC4761bt(this.f4025D, this.f4022A, 600, 600, m6898a(), "buddy_f_" + this.f4033L + "_" + this.f4029H));
        } else {
            this.f4023B.setVisibility(0);
            setHasOptionsMenu(false);
            m6874b();
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f4046i != null) {
            ViewTreeObserver viewTreeObserver = this.f4046i.getViewTreeObserver();
            this.f4051n = new ViewTreeObserverOnGlobalLayoutListenerC1338gr(this);
            viewTreeObserver.addOnGlobalLayoutListener(this.f4051n);
        }
        this.f4037P.setTitle(getText(R.string.mypage_profile_image));
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f4046i != null) {
            this.f4046i.getViewTreeObserver().removeGlobalOnLayoutListener(this.f4051n);
        }
    }

    /* renamed from: a */
    public String m6898a() {
        return this.f4042d + this.f4033L + "/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6870a(String str, View view) {
        for (int i = 0; i < this.f4052o.getChildCount(); i++) {
            try {
                if (this.f4052o.getChildAt(i) != null) {
                    ProfileImageItem profileImageItem = (ProfileImageItem) this.f4052o.getChildAt(i).getTag();
                    if (profileImageItem == null) {
                        C4904y.m18646e("BuddyProfileImageView: mItem == null", getClass().getSimpleName());
                        return;
                    }
                    if (profileImageItem.imageId == null) {
                        C4904y.m18646e("BuddyProfileImageView: mItem.imageId == null", getClass().getSimpleName());
                        profileImageItem.selectedImage.setVisibility(8);
                    } else if (profileImageItem.imageId.toString().equals(str.toString())) {
                        if (Spam.ACTIVITY_REPORT.equals(profileImageItem.Represent)) {
                            this.f4043f = (ImageView) view.findViewById(R.id.profile_image_select_layout);
                            this.f4043f.setVisibility(0);
                        } else {
                            profileImageItem.selectedImage.setVisibility(0);
                        }
                    } else if (Spam.ACTIVITY_REPORT.equals(profileImageItem.Represent)) {
                        if (this.f4043f != null) {
                            this.f4043f.setVisibility(8);
                        }
                    } else {
                        profileImageItem.selectedImage.setVisibility(8);
                    }
                }
            } catch (Exception e) {
                return;
            }
        }
    }

    /* renamed from: b */
    private void m6874b() {
        this.f4048k.m9306a(this.f4033L, "600");
        m6885f();
    }

    public class ProfileImageItem implements Parcelable {
        public static final Parcelable.Creator<ProfileImageItem> CREATOR = new C1343gw();
        public String FullfileName;
        public String Represent;
        public String ThumbfileName;
        public String dirCachePath;

        /* renamed from: id */
        public String f4064id;
        public String imageId;
        public ImageView selectedImage;
        public ImageView thumbImage;

        public ProfileImageItem() {
        }

        public ProfileImageItem(Parcel parcel) {
            m6899a(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f4064id);
            parcel.writeString(this.imageId);
            parcel.writeString(this.dirCachePath);
            parcel.writeString(this.ThumbfileName);
            parcel.writeString(this.FullfileName);
            parcel.writeString(this.Represent);
        }

        /* renamed from: a */
        private void m6899a(Parcel parcel) {
            this.f4064id = parcel.readString();
            this.imageId = parcel.readString();
            this.dirCachePath = parcel.readString();
            this.ThumbfileName = parcel.readString();
            this.FullfileName = parcel.readString();
            this.Represent = parcel.readString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6877c() {
        BuddyProfileImageView.f4020n = this.f4029H;
        this.f4058u = new C1329gi(this.f4037P, R.layout.item_profile_image, this.f4059v, this.f4060w);
        this.f4052o.setAdapter((ListAdapter) this.f4058u);
        for (int i = 0; i < this.f4031J; i++) {
            if (this.f4029H == this.f4058u.getItem(i).imageId) {
                this.f4030I = i + 1;
                this.f4037P.setTitle(((Object) getText(R.string.mypage_profile_image)) + " (" + this.f4030I + "/" + this.f4031J + ")");
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6880d() {
        try {
            this.f4057t.setVisibility(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private void m6883e() {
        try {
            this.f4046i.setImageResource(R.drawable.profile_photo_buddy_default);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    private void m6885f() {
        boolean z;
        if (this.f4035N.equals("FULL")) {
            if (this.f4034M != null) {
                File file = new File(this.f4041c + this.f4033L + "/", this.f4034M);
                if (file.exists()) {
                    new AsyncTaskC1341gu(this, file).execute(new Void[0]);
                    return;
                } else {
                    m6883e();
                    return;
                }
            }
            m6883e();
            return;
        }
        if (this.f4035N.equals("THUMB")) {
            File file2 = new File(m6898a(), "buddy_f_" + this.f4033L + "_" + this.f4034M);
            if (file2.exists()) {
                z = true;
            } else {
                file2 = new File(this.f4041c + this.f4033L + "/", this.f4034M);
                if (file2.exists()) {
                    this.f4036O = true;
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                if (file2.exists()) {
                    new AsyncTaskC1342gv(this, file2).execute(new Void[0]);
                    return;
                }
                return;
            }
            m6883e();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f4060w != null) {
            this.f4060w.m19014a();
        }
        if (this.f4047j.isShowing()) {
            this.f4047j.dismiss();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("mCurrentPImageId", this.f4029H);
        bundle.putString("mRepresentPImageId", this.f4028G);
        bundle.putString("mProfileImageUrl", this.f4022A);
        bundle.putParcelableArrayList("array", this.f4059v);
        bundle.putInt("mCurrentPosition", this.f4030I);
        bundle.putInt("mTotalProfileImageCount", this.f4031J);
        bundle.putInt("mSmallImageNum", this.f4024C);
        bundle.putString("mBuddyNo", this.f4033L);
        bundle.putString("mbuddyImageID", this.f4034M);
        bundle.putString("mbuddyImageType", this.f4035N);
        bundle.putBoolean("mNoSuchImage", this.f4036O);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m6868a(configuration.orientation);
    }

    /* renamed from: a */
    private void m6868a(int i) {
        LinearLayout.LayoutParams layoutParams = null;
        LinearLayout.LayoutParams layoutParams2 = null;
        if (i == 2) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 0.5f;
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            layoutParams2.weight = 0.5f;
            layoutParams2.leftMargin = 4;
            layoutParams2.rightMargin = 4;
            this.f4054q.setOrientation(0);
        } else if (i == 1) {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 0.7f;
            layoutParams.gravity = 17;
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
            layoutParams2.weight = 0.3f;
            layoutParams2.gravity = 17;
            this.f4054q.setOrientation(1);
        }
        this.f4055r.setLayoutParams(layoutParams);
        this.f4056s.setLayoutParams(layoutParams2);
    }
}
