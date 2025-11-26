package com.sec.chaton.buddy.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.buddy.C0699fj;
import com.sec.chaton.buddy.CallableC0698fi;
import com.sec.chaton.p025d.C1331i;
import com.sec.chaton.p025d.C1345w;
import com.sec.chaton.p027e.p028a.C1365i;
import com.sec.chaton.p035io.entry.inner.BuddyProfile;
import com.sec.chaton.p035io.entry.inner.ProfileImage;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.userprofile.CallableC3134cf;
import com.sec.chaton.userprofile.EditProfileActivity;
import com.sec.chaton.userprofile.ProfileImageHistoryActivity;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3231f;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.log.collector.C3358h;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MeDialog extends Activity implements View.OnClickListener {

    /* renamed from: a */
    public static final String f2732a = MeDialog.class.getSimpleName();

    /* renamed from: A */
    private ImageView f2733A;

    /* renamed from: B */
    private ImageButton f2734B;

    /* renamed from: C */
    private C1331i f2735C;

    /* renamed from: D */
    private ImageView f2736D;

    /* renamed from: E */
    private BitmapDrawable f2737E;

    /* renamed from: H */
    private C0699fj f2740H;

    /* renamed from: I */
    private C0699fj f2741I;

    /* renamed from: J */
    private C0699fj f2742J;

    /* renamed from: K */
    private C0699fj f2743K;

    /* renamed from: L */
    private LinearLayout f2744L;

    /* renamed from: f */
    private boolean f2751f;

    /* renamed from: g */
    private String f2752g;

    /* renamed from: h */
    private File f2753h;

    /* renamed from: i */
    private C1345w f2754i;

    /* renamed from: j */
    private ArrayList<ProfileImage> f2755j;

    /* renamed from: k */
    private String f2756k;

    /* renamed from: l */
    private C3326c f2757l;

    /* renamed from: m */
    private int f2758m;

    /* renamed from: n */
    private String f2759n;

    /* renamed from: o */
    private String f2760o;

    /* renamed from: p */
    private TextView f2761p;

    /* renamed from: q */
    private LinearLayout f2762q;

    /* renamed from: r */
    private LinearLayout f2763r;

    /* renamed from: s */
    private TextView f2764s;

    /* renamed from: t */
    private ImageView f2765t;

    /* renamed from: u */
    private ImageView f2766u;

    /* renamed from: v */
    private ImageView f2767v;

    /* renamed from: w */
    private ImageView f2768w;

    /* renamed from: x */
    private ImageView f2769x;

    /* renamed from: y */
    private ImageView f2770y;

    /* renamed from: z */
    private ImageView f2771z;

    /* renamed from: b */
    private String f2747b = C3223ck.m11329c() + "/profilehistory/";

    /* renamed from: c */
    private String f2748c = "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3159aa.m10962a().m10979a("imei", "");

    /* renamed from: d */
    private final String f2749d = "160";

    /* renamed from: e */
    private final int f2750e = 4;

    /* renamed from: F */
    private final String f2738F = "updated";

    /* renamed from: G */
    private String f2739G = null;

    /* renamed from: M */
    private boolean f2745M = true;

    /* renamed from: N */
    private Handler f2746N = new HandlerC0639u(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        C3250y.m11458g("onCreate()", f2732a);
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        this.f2735C = new C1331i(this.f2746N);
        this.f2735C.m5757a();
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.f2754i = new C1345w(this.f2746N);
        this.f2751f = true;
        this.f2752g = getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/";
        this.f2757l = new C3326c();
        this.f2759n = getIntent().getExtras().getString("ME_DIALOG_NAME");
        this.f2760o = getIntent().getExtras().getString("ME_DIALOG_STATUSMSG");
        this.f2753h = getApplicationContext().getFilesDir().getAbsoluteFile();
        m4247a(false);
    }

    /* renamed from: a */
    private void m4247a(boolean z) throws Resources.NotFoundException {
        setContentView(R.layout.me_profile_popup);
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C3358h.m11842a().m11846a("00030003");
        }
        this.f2756k = C3159aa.m10962a().m10979a("chaton_id", "");
        this.f2761p = (TextView) findViewById(R.id.me_profile_popup_name);
        if (this.f2759n != null) {
            this.f2761p.setText(this.f2759n);
        }
        this.f2762q = (LinearLayout) findViewById(R.id.me_profile_popup_pen_btn);
        this.f2762q.setOnClickListener(this);
        this.f2763r = (LinearLayout) findViewById(R.id.me_profile_popup_view_profile);
        this.f2763r.setOnClickListener(this);
        this.f2736D = (ImageView) findViewById(R.id.me_profile_popup_coverimage);
        m4240a(this.f2736D);
        this.f2764s = (TextView) findViewById(R.id.me_profile_popup_status_message);
        if (this.f2760o != null && !TextUtils.isEmpty(this.f2760o)) {
            this.f2764s.setText(this.f2760o);
        } else {
            this.f2764s.setText(R.string.mypage_enter_status_message);
        }
        this.f2765t = (ImageView) findViewById(R.id.me_profile_popup_image);
        this.f2769x = (ImageView) findViewById(R.id.me_profile_popup_image_loading);
        this.f2766u = (ImageView) findViewById(R.id.me_profile_popup_image_1);
        this.f2770y = (ImageView) findViewById(R.id.me_profile_popup_image_1_loading);
        this.f2767v = (ImageView) findViewById(R.id.me_profile_popup_image_2);
        this.f2771z = (ImageView) findViewById(R.id.me_profile_popup_image_2_loading);
        this.f2768w = (ImageView) findViewById(R.id.me_profile_popup_image_3);
        this.f2733A = (ImageView) findViewById(R.id.me_profile_popup_image_3_loading);
        this.f2734B = (ImageButton) findViewById(R.id.me_profile_more_icon);
        this.f2740H = new C0699fj(this.f2765t);
        this.f2741I = new C0699fj(this.f2766u);
        this.f2742J = new C0699fj(this.f2767v);
        this.f2743K = new C0699fj(this.f2768w);
        this.f2744L = (LinearLayout) findViewById(R.id.me_profile_popup_image_history_layout);
        m4254c();
        String strM10979a = C3159aa.m10962a().m10979a("samsung_account_email", "");
        this.f2763r.requestFocus();
        if (!TextUtils.isEmpty(strM10979a) && !z) {
            m4258e();
            m4256d();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Rect rect = new Rect();
        getWindow().getDecorView().getHitRect(rect);
        if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY()) && motionEvent.getAction() == 0) {
            finish();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        m4247a(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C3197bl.m11159a()) {
            switch (view.getId()) {
                case R.id.me_profile_popup_view_profile /* 2131166401 */:
                    Intent intentM1226a = TabActivity.m1226a(getApplicationContext());
                    intentM1226a.putExtra("callMyPageTab", true);
                    startActivity(intentM1226a);
                    finish();
                    break;
                case R.id.me_profile_popup_pen_btn /* 2131166402 */:
                    Intent intent = new Intent(getApplicationContext(), (Class<?>) EditProfileActivity.class);
                    intent.putExtra("INTENT_FROM", 10);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.me_profile_popup_image /* 2131166405 */:
                case R.id.me_profile_more_icon /* 2131166414 */:
                    startActivity(new Intent(getApplicationContext(), (Class<?>) ProfileImageHistoryActivity.class));
                    finish();
                    break;
                case R.id.me_profile_popup_image_1 /* 2131166408 */:
                    Intent intent2 = new Intent(getApplicationContext(), (Class<?>) ProfileImageHistoryActivity.class);
                    intent2.putExtra("mSmallImageNum", 1);
                    startActivity(intent2);
                    finish();
                    break;
                case R.id.me_profile_popup_image_2 /* 2131166410 */:
                    Intent intent3 = new Intent(getApplicationContext(), (Class<?>) ProfileImageHistoryActivity.class);
                    intent3.putExtra("mSmallImageNum", 2);
                    startActivity(intent3);
                    finish();
                    break;
                case R.id.me_profile_popup_image_3 /* 2131166412 */:
                    Intent intent4 = new Intent(getApplicationContext(), (Class<?>) ProfileImageHistoryActivity.class);
                    intent4.putExtra("mSmallImageNum", 3);
                    startActivity(intent4);
                    finish();
                    break;
            }
        }
    }

    /* renamed from: b */
    private boolean m4252b() {
        if (new File(this.f2753h, "myprofile.png_").exists()) {
            return false;
        }
        String strM10979a = C3159aa.m10962a().m10979a("profile_small_image1", "");
        if (strM10979a != null && new File(this.f2747b + "profile_t_mine_" + strM10979a).exists()) {
            return false;
        }
        String strM10979a2 = C3159aa.m10962a().m10979a("profile_small_image2", "");
        if (strM10979a2 != null && new File(this.f2747b + "profile_t_mine_" + strM10979a2).exists()) {
            return false;
        }
        String strM10979a3 = C3159aa.m10962a().m10979a("profile_small_image3", "");
        return strM10979a3 == null || !new File(new StringBuilder().append(this.f2747b).append("profile_t_").append("mine_").append(strM10979a3).toString()).exists();
    }

    /* renamed from: c */
    private void m4254c() {
        this.f2745M = m4252b();
        if (this.f2745M) {
            this.f2744L.setVisibility(8);
            this.f2765t.setOnClickListener(this);
            return;
        }
        m4239a(0, this.f2747b + "profile_f_mine_" + C3159aa.m10962a().m10979a("profile_small_image0", ""));
        String strM10979a = C3159aa.m10962a().m10979a("profile_small_image1", "");
        if (!TextUtils.isEmpty(strM10979a)) {
            m4239a(1, this.f2747b + "profile_t_mine_" + strM10979a);
            this.f2766u.setOnClickListener(this);
            this.f2766u.setBackgroundResource(R.drawable.mypage_profile_image_selector);
        } else {
            this.f2766u.setVisibility(8);
        }
        String strM10979a2 = C3159aa.m10962a().m10979a("profile_small_image2", "");
        if (!TextUtils.isEmpty(strM10979a2)) {
            m4239a(2, this.f2747b + "profile_t_mine_" + strM10979a2);
            this.f2767v.setOnClickListener(this);
            this.f2767v.setBackgroundResource(R.drawable.mypage_profile_image_selector);
        } else {
            this.f2767v.setVisibility(8);
        }
        String strM10979a3 = C3159aa.m10962a().m10979a("profile_small_image3", "");
        if (!TextUtils.isEmpty(strM10979a3)) {
            m4239a(3, this.f2747b + "profile_t_mine_" + strM10979a3);
            this.f2768w.setOnClickListener(this);
            this.f2768w.setBackgroundResource(R.drawable.mypage_profile_image_selector);
        } else {
            this.f2768w.setVisibility(8);
        }
        this.f2765t.setOnClickListener(this);
        this.f2734B.setOnClickListener(this);
    }

    /* renamed from: a */
    private void m4239a(int i, String str) {
        ImageView imageView;
        CallableC3134cf callableC3134cf;
        C3250y.m11456e("MyPageFragment initialize() - " + i, f2732a);
        File file = new File(str);
        C3250y.m11450b("photoFile=" + file, f2732a);
        switch (i) {
            case 0:
                ImageView imageView2 = this.f2765t;
                C3159aa.m10962a().m10979a("profile_small_image0", "");
                imageView = imageView2;
                break;
            case 1:
                ImageView imageView3 = this.f2766u;
                C3159aa.m10962a().m10979a("profile_small_image1", "");
                imageView = imageView3;
                break;
            case 2:
                ImageView imageView4 = this.f2767v;
                C3159aa.m10962a().m10979a("profile_small_image2", "");
                imageView = imageView4;
                break;
            case 3:
                ImageView imageView5 = this.f2768w;
                C3159aa.m10962a().m10979a("profile_small_image3", "");
                imageView = imageView5;
                break;
            default:
                imageView = null;
                break;
        }
        if (imageView != null && file.exists()) {
            if (i == 0) {
                callableC3134cf = new CallableC3134cf(file, true, true);
            } else {
                callableC3134cf = new CallableC3134cf(file, true, false);
            }
            this.f2757l.m11730a(imageView, callableC3134cf);
        }
    }

    /* renamed from: d */
    private void m4256d() {
        this.f2754i.m5937d();
    }

    /* renamed from: e */
    private void m4258e() {
        this.f2754i.m5936c(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4246a(BuddyProfile buddyProfile) {
        if (buddyProfile.name != null) {
            this.f2761p.setText(buddyProfile.name);
        }
        this.f2764s = (TextView) findViewById(R.id.me_profile_popup_status_message);
        if (buddyProfile.status != null && !TextUtils.isEmpty(buddyProfile.status)) {
            this.f2764s.setText(buddyProfile.status);
        } else {
            this.f2764s.setText(R.string.mypage_enter_status_message);
        }
    }

    /* renamed from: a */
    public boolean m4268a(String str) {
        boolean z = false;
        if (!new File(this.f2752g).exists()) {
            if (C3250y.f11734b) {
                C3250y.m11450b("checkAndSetCoverStoryRandomImages No random images in file folder ", f2732a);
            }
        } else {
            String str2 = this.f2752g + str + ".jpg";
            File file = new File(str2);
            if (file.exists()) {
                if (file.length() == 0) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("checkAndSetCoverStoryRandomImages file size is 0.", f2732a);
                    }
                    file.delete();
                } else {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("checkAndSetCoverStoryRandomImages get the random image in file folder #3#", f2732a);
                    }
                    z = true;
                    if (this.f2736D != null) {
                        this.f2736D.setImageURI(Uri.parse(str2));
                    }
                    if (C3250y.f11734b) {
                        C3250y.m11450b("checkAndSetCoverStoryRandomImages set the random image from file folder #4#", f2732a);
                    }
                }
            } else if (C3250y.f11734b) {
                C3250y.m11450b("checkAndSetCoverStoryRandomImages not exists the random image in file folder #2#", f2732a);
            }
        }
        return z;
    }

    /* renamed from: a */
    public boolean m4267a() {
        C3250y.m11450b("Buddy didn't set Coverstory ", getClass().getSimpleName());
        String strM6090a = C1365i.m6090a();
        if (strM6090a != null) {
            if (!m4268a(strM6090a)) {
                this.f2735C.m5760a(strM6090a, Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                this.f2739G = strM6090a;
            }
            this.f2735C.m5762b(strM6090a);
            return true;
        }
        C3250y.m11450b(" Random ERROR !!", getClass().getSimpleName());
        this.f2735C.m5763b(Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4236a(int i) {
        try {
            switch (i) {
                case 0:
                    this.f2765t.setImageBitmap(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.profile_photo_buddy_default));
                    C3205bt.m11182a(getApplicationContext()).m11227b(this.f2756k);
                    C3205bt.m11182a(getApplicationContext()).m11206a();
                    break;
                case 1:
                    this.f2766u.setImageBitmap(null);
                    this.f2766u.setVisibility(8);
                    break;
                case 2:
                    this.f2767v.setImageBitmap(null);
                    this.f2767v.setVisibility(8);
                    break;
                case 3:
                    this.f2768w.setImageBitmap(null);
                    this.f2768w.setVisibility(8);
                    break;
                default:
                    return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4238a(int i, ProfileImage profileImage, String str, ImageView imageView, boolean z) throws Throwable {
        String str2;
        if (z) {
            str2 = "profile_f_";
        } else {
            str2 = "profile_t_";
        }
        String str3 = this.f2747b + str2 + "mine_" + profileImage.profileimageid;
        m4239a(i, str3);
        File file = new File(str3);
        if (!C3159aa.m10962a().m10979a(str, "").equals(profileImage.profileimageid) || !file.exists()) {
            C3159aa.m10966a(str, profileImage.profileimageid);
            if (!file.exists()) {
                m4241a(this.f2770y, profileImage, str2, this.f2747b, imageView, z, z);
            }
        }
        if (z) {
            m4251b(profileImage.profileimageid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4237a(int i, ProfileImage profileImage) throws Throwable {
        switch (i) {
            case 1:
                m4238a(i, profileImage, "profile_small_image1", this.f2766u, false);
                break;
            case 2:
                m4238a(i, profileImage, "profile_small_image2", this.f2767v, false);
                break;
            case 3:
                m4238a(i, profileImage, "profile_small_image3", this.f2768w, false);
                break;
        }
    }

    /* renamed from: b */
    private void m4251b(String str) throws Throwable {
        String str2 = C3223ck.m11329c() + "/profilehistory/";
        String str3 = CommonApplication.m11493l().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/";
        String strM10979a = C3159aa.m10962a().m10979a("chaton_id", "");
        C3159aa.m10962a().m10979a("msisdn", "");
        C3159aa.m10966a("profile_image_status", "updated");
        String str4 = str2 + "profile_t_mine_" + str;
        String str5 = str2 + "profile_f_mine_" + str;
        String str6 = str3 + "myprofile.png_";
        String str7 = str3 + strM10979a + ".jpeg_";
        if (C3159aa.m10962a().m10979a("profile_small_image0", "").compareTo(str) != 0) {
            C3250y.m11450b("changed " + C3159aa.m10962a().m10979a("profile_small_image0", "") + " to " + str, getClass().getSimpleName());
            C3205bt.m11182a(CommonApplication.m11493l()).m11227b(strM10979a);
        }
        C3243r.m11420a(str4, str7);
        C3243r.m11420a(str5, str6);
    }

    /* renamed from: a */
    private void m4241a(ImageView imageView, ProfileImage profileImage, String str, String str2, ImageView imageView2, boolean z, boolean z2) {
        CallableC0698fi callableC0698fi;
        if (z2) {
            callableC0698fi = new CallableC0698fi(imageView, profileImage.profileimageurl.toString() + this.f2748c + "&size=800", 600, 600, str2, str + "mine_" + profileImage.profileimageid, z, z2);
        } else {
            callableC0698fi = new CallableC0698fi(imageView, profileImage.profileimageurl.toString() + this.f2748c + "&size=140", 600, 600, str2, str + "mine_" + profileImage.profileimageid, z, z2);
        }
        this.f2757l.m11730a(imageView2, callableC0698fi);
    }

    /* renamed from: f */
    private void m4260f() {
        Bitmap bitmap;
        if (this.f2737E != null && (bitmap = this.f2737E.getBitmap()) != null) {
            bitmap.recycle();
        }
    }

    /* renamed from: a */
    private void m4240a(ImageView imageView) throws Resources.NotFoundException {
        int dimensionPixelSize;
        Bitmap bitmapM11012b;
        m4260f();
        Context applicationContext = getApplicationContext();
        if (getResources().getConfiguration().orientation == 1) {
            dimensionPixelSize = applicationContext.getResources().getDimensionPixelSize(R.dimen.buddy_popup_boddy_height);
        } else {
            dimensionPixelSize = applicationContext.getResources().getDimensionPixelSize(R.dimen.buddy_popup_whole_width);
        }
        C3159aa.m10962a().m10979a("coverstory_metaid", "");
        C3250y.m11450b(" setCoverstoryAndDownload [dirInternalPath] : " + this.f2752g + " [filename] : mycoverstory.jpg", f2732a);
        File file = new File(this.f2752g);
        if (!new File(this.f2752g + "mycoverstory.jpg").exists() || TextUtils.isEmpty("mycoverstory.jpg")) {
            C3250y.m11450b("setCoverStory there is no mycoverstory.jpg loadDefaultCoverStory()", f2732a);
            C3231f.m11368a(this.f2736D);
            return;
        }
        C3250y.m11450b("setCoverStory", f2732a);
        try {
            bitmapM11012b = C3162ad.m11012b(applicationContext, Uri.parse(file + "/mycoverstory.jpg"), dimensionPixelSize);
        } catch (IOException e) {
            C3250y.m11450b("setCoverStory IOException loadDefaultCoverStory()", f2732a);
            C3231f.m11368a(this.f2736D);
            e.printStackTrace();
            bitmapM11012b = null;
        }
        if (bitmapM11012b != null) {
            imageView.setImageBitmap(bitmapM11012b);
        } else {
            C3250y.m11450b("loadCoverStoryImages bitmap is null. loadDefaultCoverStory()", f2732a);
            C3231f.m11368a(this.f2736D);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m4262g();
    }

    /* renamed from: g */
    private void m4262g() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f2765t != null) {
            this.f2765t.setImageBitmap(null);
            this.f2765t = null;
        }
        if (this.f2766u != null) {
            this.f2766u.setImageBitmap(null);
            this.f2766u = null;
        }
        if (this.f2767v != null) {
            this.f2767v.setImageBitmap(null);
            this.f2767v = null;
        }
        if (this.f2768w != null) {
            this.f2768w.setImageBitmap(null);
            this.f2768w = null;
        }
        if (this.f2734B != null) {
            this.f2734B.setImageBitmap(null);
            this.f2734B = null;
        }
        this.f2746N = null;
    }
}
