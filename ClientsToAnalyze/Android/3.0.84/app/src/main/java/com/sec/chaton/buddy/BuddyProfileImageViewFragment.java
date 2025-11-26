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
import android.view.WindowManager;
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
import com.sec.chaton.p025d.C1345w;
import com.sec.chaton.p035io.entry.inner.ProfileImage;
import com.sec.chaton.userprofile.CallableC3115bn;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.common.p069e.C3326c;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BuddyProfileImageViewFragment extends Fragment {

    /* renamed from: e */
    public static final String f2125e = BuddyProfileImageView.class.getSimpleName();

    /* renamed from: A */
    private String f2126A;

    /* renamed from: B */
    private ProgressBar f2127B;

    /* renamed from: C */
    private int f2128C;

    /* renamed from: D */
    private ImageView f2129D;

    /* renamed from: E */
    private Boolean f2130E;

    /* renamed from: F */
    private Boolean f2131F;

    /* renamed from: G */
    private String f2132G;

    /* renamed from: H */
    private String f2133H;

    /* renamed from: I */
    private int f2134I;

    /* renamed from: J */
    private int f2135J;

    /* renamed from: K */
    private ArrayList<ProfileImage> f2136K;

    /* renamed from: L */
    private String f2137L;

    /* renamed from: M */
    private String f2138M;

    /* renamed from: N */
    private String f2139N;

    /* renamed from: O */
    private boolean f2140O;

    /* renamed from: P */
    private Activity f2141P;

    /* renamed from: Q */
    private Handler f2142Q;

    /* renamed from: a */
    String f2143a;

    /* renamed from: b */
    String f2144b;

    /* renamed from: c */
    String f2145c;

    /* renamed from: d */
    String f2146d;

    /* renamed from: f */
    ImageView f2147f;

    /* renamed from: g */
    AdapterView.OnItemClickListener f2148g;

    /* renamed from: h */
    int f2149h;

    /* renamed from: i */
    private ZoomableImageView f2150i;

    /* renamed from: j */
    private ProgressDialog f2151j;

    /* renamed from: k */
    private C1345w f2152k;

    /* renamed from: l */
    private boolean f2153l;

    /* renamed from: m */
    private boolean f2154m;

    /* renamed from: n */
    private ViewTreeObserver.OnGlobalLayoutListener f2155n;

    /* renamed from: o */
    private GridView f2156o;

    /* renamed from: p */
    private FrameLayout f2157p;

    /* renamed from: q */
    private LinearLayout f2158q;

    /* renamed from: r */
    private FrameLayout f2159r;

    /* renamed from: s */
    private FrameLayout f2160s;

    /* renamed from: t */
    private LinearLayout f2161t;

    /* renamed from: u */
    private C0697fh f2162u;

    /* renamed from: v */
    private ArrayList<ProfileImageItem> f2163v;

    /* renamed from: w */
    private C3326c f2164w;

    /* renamed from: x */
    private String f2165x;

    /* renamed from: y */
    private String f2166y;

    /* renamed from: z */
    private String f2167z;

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f2141P = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f2141P = null;
    }

    public BuddyProfileImageViewFragment() {
        this.f2143a = C3223ck.m11329c();
        this.f2144b = C3223ck.m11329c() + "/profilehistory/";
        this.f2145c = GlobalApplication.m11493l().getCacheDir().getAbsoluteFile().getAbsolutePath() + "/";
        this.f2146d = GlobalApplication.m11493l().getCacheDir().getAbsoluteFile().getAbsolutePath() + "/profilehistory/";
        this.f2153l = false;
        this.f2154m = false;
        this.f2165x = "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3159aa.m10962a().m10979a("imei", "");
        this.f2132G = "";
        this.f2133H = "";
        this.f2134I = 1;
        this.f2137L = "";
        this.f2138M = "";
        this.f2139N = "";
        this.f2140O = false;
        this.f2147f = null;
        this.f2148g = new C0701fl(this);
        this.f2142Q = new HandlerC0702fm(this);
        this.f2149h = 20;
    }

    public BuddyProfileImageViewFragment(String str, String str2, String str3) {
        this.f2143a = C3223ck.m11329c();
        this.f2144b = C3223ck.m11329c() + "/profilehistory/";
        this.f2145c = GlobalApplication.m11493l().getCacheDir().getAbsoluteFile().getAbsolutePath() + "/";
        this.f2146d = GlobalApplication.m11493l().getCacheDir().getAbsoluteFile().getAbsolutePath() + "/profilehistory/";
        this.f2153l = false;
        this.f2154m = false;
        this.f2165x = "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3159aa.m10962a().m10979a("imei", "");
        this.f2132G = "";
        this.f2133H = "";
        this.f2134I = 1;
        this.f2137L = "";
        this.f2138M = "";
        this.f2139N = "";
        this.f2140O = false;
        this.f2147f = null;
        this.f2148g = new C0701fl(this);
        this.f2142Q = new HandlerC0702fm(this);
        this.f2149h = 20;
        this.f2137L = str;
        this.f2138M = str2;
        this.f2139N = str3;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseActivity.m3083b(this, false);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BaseActivity.m3081a(this, false);
        View viewInflate = layoutInflater.inflate(R.layout.layout_profile_image_view, viewGroup, false);
        this.f2151j = (ProgressDialog) new C3263j(this.f2141P).m11487a(R.string.dialog_userprofile_updating);
        this.f2150i = (ZoomableImageView) viewInflate.findViewById(R.id.profile_big_image);
        this.f2157p = (FrameLayout) viewInflate.findViewById(R.id.networkErrorView);
        this.f2157p.setVisibility(8);
        this.f2129D = (ImageView) viewInflate.findViewById(R.id.profile_image_loading);
        this.f2161t = (LinearLayout) viewInflate.findViewById(R.id.profile_default_image);
        this.f2161t.setVisibility(8);
        this.f2164w = new C3326c();
        this.f2156o = (GridView) viewInflate.findViewById(R.id.list_bg_horizontal);
        this.f2156o.setOnItemClickListener(this.f2148g);
        this.f2158q = (LinearLayout) viewInflate.findViewById(R.id.profile_holder);
        this.f2159r = (FrameLayout) viewInflate.findViewById(R.id.profile_main_images);
        this.f2160s = (FrameLayout) viewInflate.findViewById(R.id.profile_grid_images);
        m3738b(this.f2141P.getResources().getConfiguration().orientation);
        setHasOptionsMenu(false);
        this.f2163v = new ArrayList<>();
        this.f2152k = new C1345w(this.f2142Q);
        this.f2127B = (ProgressBar) viewInflate.findViewById(R.id.progress_loading);
        BuddyProfileImageView.f2124a = this.f2133H;
        this.f2130E = false;
        this.f2131F = false;
        if (bundle != null && bundle.getParcelableArrayList("array") != null && bundle.getString("mProfileImageUrl") != null) {
            this.f2132G = bundle.getString("mRepresentPImageId");
            this.f2133H = bundle.getString("mCurrentPImageId");
            this.f2163v = bundle.getParcelableArrayList("array");
            this.f2126A = bundle.getString("mProfileImageUrl");
            this.f2134I = bundle.getInt("mCurrentPosition");
            this.f2135J = bundle.getInt("mTotalProfileImageCount");
            this.f2128C = bundle.getInt("mSmallImageNum");
            this.f2137L = bundle.getString("mBuddyNo");
            this.f2138M = bundle.getString("mbuddyImageID");
            this.f2139N = bundle.getString("mbuddyImageType");
            this.f2140O = bundle.getBoolean("mNoSuchImage");
            C3250y.m11456e("mCurrentPImageId: " + this.f2133H, getClass().getSimpleName());
            C3250y.m11456e("mProfileImageUrl: " + this.f2126A, getClass().getSimpleName());
            BuddyProfileImageView.f2124a = this.f2133H;
            this.f2141P.setTitle(((Object) getText(R.string.mypage_profile_image)) + " (" + this.f2134I + "/" + this.f2135J + ")");
            this.f2164w.m11730a(this.f2150i, new CallableC3115bn(this.f2129D, this.f2126A, 600, 600, m3763a(), "buddy_f_" + this.f2137L + "_" + this.f2133H));
        } else {
            this.f2127B.setVisibility(0);
            setHasOptionsMenu(false);
            m3741c();
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f2150i != null) {
            ViewTreeObserver viewTreeObserver = this.f2150i.getViewTreeObserver();
            this.f2155n = new ViewTreeObserverOnGlobalLayoutListenerC0700fk(this);
            viewTreeObserver.addOnGlobalLayoutListener(this.f2155n);
        }
        this.f2141P.setTitle(getText(R.string.mypage_profile_image));
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f2150i != null) {
            this.f2150i.getViewTreeObserver().removeGlobalOnLayoutListener(this.f2155n);
        }
    }

    /* renamed from: a */
    public String m3763a() {
        return this.f2146d + this.f2137L + "/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3734a(String str, View view) {
        for (int i = 0; i < this.f2156o.getChildCount(); i++) {
            try {
                if (this.f2156o.getChildAt(i) != null) {
                    ProfileImageItem profileImageItem = (ProfileImageItem) this.f2156o.getChildAt(i).getTag();
                    if (profileImageItem == null) {
                        C3250y.m11456e("BuddyProfileImageView: mItem == null", getClass().getSimpleName());
                        return;
                    }
                    if (profileImageItem.imageId == null) {
                        C3250y.m11456e("BuddyProfileImageView: mItem.imageId == null", getClass().getSimpleName());
                        profileImageItem.selectedImage.setVisibility(8);
                    } else if (profileImageItem.imageId.toString().equals(str.toString())) {
                        if ("1".equals(profileImageItem.Represent)) {
                            this.f2147f = (ImageView) view.findViewById(R.id.profile_image_select_layout);
                            this.f2147f.setVisibility(0);
                        } else {
                            profileImageItem.selectedImage.setVisibility(0);
                        }
                    } else if ("1".equals(profileImageItem.Represent)) {
                        if (this.f2147f != null) {
                            this.f2147f.setVisibility(8);
                        } else {
                            m3764b();
                            this.f2147f.setVisibility(8);
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
    public void m3764b() {
        try {
            if (this.f2156o.getChildCount() > 0 && this.f2156o.getChildAt(0) != null && "1".equals(((ProfileImageItem) this.f2156o.getChildAt(0).getTag()).Represent) && this.f2147f == null) {
                this.f2147f = (ImageView) this.f2156o.getChildAt(0).findViewById(R.id.profile_image_select_layout);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m3741c() {
        if (!GlobalApplication.m6456e()) {
            this.f2141P.setRequestedOrientation(m3727a(((WindowManager) this.f2141P.getSystemService("window")).getDefaultDisplay().getRotation()));
        }
        this.f2152k.m5930a(this.f2137L, "600");
        m3751g();
    }

    public class ProfileImageItem implements Parcelable {
        public static final Parcelable.Creator<ProfileImageItem> CREATOR = new C0705fp();
        public String FullfileName;
        public String Represent;
        public String ThumbfileName;
        public String dirCachePath;

        /* renamed from: id */
        public String f2168id;
        public String imageId;
        public ImageView selectedImage;
        public ImageView thumbImage;

        public ProfileImageItem() {
        }

        public ProfileImageItem(Parcel parcel) {
            m3765a(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f2168id);
            parcel.writeString(this.imageId);
            parcel.writeString(this.dirCachePath);
            parcel.writeString(this.ThumbfileName);
            parcel.writeString(this.FullfileName);
            parcel.writeString(this.Represent);
        }

        /* renamed from: a */
        private void m3765a(Parcel parcel) {
            this.f2168id = parcel.readString();
            this.imageId = parcel.readString();
            this.dirCachePath = parcel.readString();
            this.ThumbfileName = parcel.readString();
            this.FullfileName = parcel.readString();
            this.Represent = parcel.readString();
        }
    }

    /* renamed from: a */
    private int m3727a(int i) {
        C3250y.m11456e("getOrientation Rotation: " + i, getClass().getSimpleName());
        switch (i) {
            case 0:
            case 2:
            default:
                return 1;
            case 1:
                return 0;
            case 3:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m3744d() {
        BuddyProfileImageView.f2124a = this.f2133H;
        this.f2162u = new C0697fh(this.f2141P, R.layout.item_profile_image, this.f2163v, this.f2164w);
        this.f2156o.setAdapter((ListAdapter) this.f2162u);
        for (int i = 0; i < this.f2135J; i++) {
            if (this.f2133H == this.f2162u.getItem(i).imageId) {
                this.f2134I = i + 1;
                this.f2141P.setTitle(((Object) getText(R.string.mypage_profile_image)) + " (" + this.f2134I + "/" + this.f2135J + ")");
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m3747e() {
        try {
            this.f2161t.setVisibility(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    private void m3749f() {
        try {
            this.f2150i.setImageResource(R.drawable.contacts_default_01);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    private void m3751g() {
        boolean z;
        if (this.f2139N.equals("FULL")) {
            if (this.f2138M != null) {
                File file = new File(this.f2145c + this.f2137L + "/", this.f2138M);
                if (file.exists()) {
                    new AsyncTaskC0703fn(this, file).execute(new Void[0]);
                    return;
                } else {
                    m3749f();
                    return;
                }
            }
            m3749f();
            return;
        }
        if (this.f2139N.equals("THUMB")) {
            File file2 = new File(m3763a(), "buddy_f_" + this.f2137L + "_" + this.f2138M);
            if (file2.exists()) {
                z = true;
            } else {
                file2 = new File(this.f2145c + this.f2137L + "/", this.f2138M);
                if (file2.exists()) {
                    this.f2140O = true;
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                if (file2.exists()) {
                    new AsyncTaskC0704fo(this, file2).execute(new Void[0]);
                    return;
                }
                return;
            }
            m3749f();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f2164w != null) {
            this.f2164w.m11731a();
        }
        if (this.f2151j.isShowing()) {
            this.f2151j.dismiss();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("mCurrentPImageId", this.f2133H);
        bundle.putString("mRepresentPImageId", this.f2132G);
        bundle.putString("mProfileImageUrl", this.f2126A);
        bundle.putParcelableArrayList("array", this.f2163v);
        bundle.putInt("mCurrentPosition", this.f2134I);
        bundle.putInt("mTotalProfileImageCount", this.f2135J);
        bundle.putInt("mSmallImageNum", this.f2128C);
        bundle.putString("mBuddyNo", this.f2137L);
        bundle.putString("mbuddyImageID", this.f2138M);
        bundle.putString("mbuddyImageType", this.f2139N);
        bundle.putBoolean("mNoSuchImage", this.f2140O);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m3738b(configuration.orientation);
    }

    /* renamed from: b */
    private void m3738b(int i) {
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
                this.f2158q.setOrientation(0);
            } else if (i == 1) {
                layoutParams = new LinearLayout.LayoutParams(-1, 0);
                layoutParams.weight = 0.7f;
                layoutParams.gravity = 17;
                layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                layoutParams2.weight = 0.3f;
                layoutParams2.gravity = 17;
                this.f2158q.setOrientation(1);
            }
            this.f2159r.setLayoutParams(layoutParams);
            this.f2160s.setLayoutParams(layoutParams2);
        }
    }
}
