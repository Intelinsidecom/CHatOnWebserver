package com.sec.chaton.buddy.dialog;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.buddy.C1331gk;
import com.sec.chaton.buddy.C1337gq;
import com.sec.chaton.p055d.C2075ah;
import com.sec.chaton.p055d.C2130k;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p065io.entry.inner.BuddyProfile;
import com.sec.chaton.passwordlock.PasswordLockActivity;
import com.sec.chaton.userprofile.C4754bm;
import com.sec.chaton.userprofile.C4757bp;
import com.sec.chaton.userprofile.MyInfoActivity;
import com.sec.chaton.userprofile.ProfileImageHistoryActivity;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.common.p132g.C5007c;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MeDialog extends PasswordLockActivity implements View.OnClickListener {

    /* renamed from: a */
    public static final String f4578a = MeDialog.class.getSimpleName();

    /* renamed from: A */
    private ImageView f4579A;

    /* renamed from: B */
    private ImageView f4580B;

    /* renamed from: C */
    private ImageView f4581C;

    /* renamed from: D */
    private ImageView f4582D;

    /* renamed from: E */
    private ImageButton f4583E;

    /* renamed from: F */
    private C2130k f4584F;

    /* renamed from: G */
    private ImageView f4585G;

    /* renamed from: H */
    private BitmapDrawable f4586H;

    /* renamed from: K */
    private C1337gq f4589K;

    /* renamed from: L */
    private C1337gq f4590L;

    /* renamed from: M */
    private C1337gq f4591M;

    /* renamed from: N */
    private C1337gq f4592N;

    /* renamed from: O */
    private LinearLayout f4593O;

    /* renamed from: Q */
    private C0416a f4595Q;

    /* renamed from: R */
    private C2210x f4596R;

    /* renamed from: f */
    private String f4605f;

    /* renamed from: g */
    private File f4606g;

    /* renamed from: h */
    private C2075ah f4607h;

    /* renamed from: i */
    private String f4608i;

    /* renamed from: j */
    private C5007c f4609j;

    /* renamed from: k */
    private String f4610k;

    /* renamed from: l */
    private String f4611l;

    /* renamed from: m */
    private TextView f4612m;

    /* renamed from: n */
    private LinearLayout f4613n;

    /* renamed from: o */
    private LinearLayout f4614o;

    /* renamed from: p */
    private ImageView f4615p;

    /* renamed from: q */
    private TextView f4616q;

    /* renamed from: r */
    private TextView f4617r;

    /* renamed from: s */
    private TextView f4618s;

    /* renamed from: t */
    private TextView f4619t;

    /* renamed from: u */
    private TextView f4620u;

    /* renamed from: v */
    private TextView f4621v;

    /* renamed from: w */
    private ImageView f4622w;

    /* renamed from: x */
    private ImageView f4623x;

    /* renamed from: y */
    private ImageView f4624y;

    /* renamed from: z */
    private ImageView f4625z;

    /* renamed from: b */
    private String f4601b = C4873ck.m18502c() + "/profilehistory/";

    /* renamed from: c */
    private String f4602c = "?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&imei=" + C4809aa.m18104a().m18121a("imei", "");

    /* renamed from: d */
    private final String f4603d = "160";

    /* renamed from: e */
    private final int f4604e = 4;

    /* renamed from: I */
    private final String f4587I = "updated";

    /* renamed from: J */
    private String f4588J = null;

    /* renamed from: P */
    private boolean f4594P = true;

    /* renamed from: S */
    private ArrayList<C4757bp> f4597S = new ArrayList<>();

    /* renamed from: T */
    private Handler f4598T = new HandlerC1201aa(this);

    /* renamed from: U */
    private InterfaceC2211y f4599U = new C1202ab(this);

    /* renamed from: V */
    private Handler f4600V = new HandlerC1203ac(this);

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    @TargetApi(11)
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        C4904y.m18639b("onCreate()", f4578a);
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        this.f4584F = new C2130k(this.f4598T);
        this.f4607h = new C2075ah(this.f4598T);
        this.f4596R = new C2210x(getApplicationContext().getContentResolver(), this.f4599U);
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.f4605f = getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/";
        this.f4609j = new C5007c();
        this.f4610k = getIntent().getExtras().getString("ME_DIALOG_NAME");
        this.f4611l = getIntent().getExtras().getString("ME_DIALOG_STATUSMSG");
        this.f4606g = getApplicationContext().getFilesDir().getAbsoluteFile();
        m7301a(false);
    }

    /* renamed from: a */
    private void m7301a(boolean z) throws Resources.NotFoundException {
        setContentView(R.layout.me_profile_popup);
        this.f4608i = C4809aa.m18104a().m18121a("chaton_id", "");
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.me_profile_popup_layout);
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams((defaultDisplay.getWidth() * getResources().getInteger(R.integer.me_popup_dialog_width_percent)) / 100, -2));
        this.f4612m = (TextView) findViewById(R.id.me_profile_popup_name);
        if (this.f4610k != null) {
            this.f4612m.setText(this.f4610k);
        }
        this.f4613n = (LinearLayout) findViewById(R.id.me_profile_popup_info_btn);
        this.f4613n.setOnClickListener(this);
        this.f4614o = (LinearLayout) findViewById(R.id.me_profile_popup_view_profile);
        this.f4614o.setOnClickListener(this);
        this.f4585G = (ImageView) findViewById(R.id.me_profile_popup_coverimage);
        m7298a(this.f4585G);
        this.f4616q = (TextView) findViewById(R.id.me_profile_popup_status_message);
        if (this.f4611l != null && !TextUtils.isEmpty(this.f4611l)) {
            this.f4616q.setText(this.f4611l);
        } else {
            this.f4616q.setText(R.string.mypage_enter_status_message);
        }
        this.f4615p = (ImageView) findViewById(R.id.buddy_profile_popup_image_chatonv);
        this.f4595Q = new C0416a();
        if (this.f4595Q != null && this.f4595Q.m1495d(getApplicationContext())) {
            this.f4615p.setVisibility(0);
        } else {
            this.f4615p.setVisibility(8);
        }
        this.f4617r = (TextView) findViewById(R.id.me_dialog_info_phonenumber1);
        this.f4618s = (TextView) findViewById(R.id.me_dialog_info_phonenumber2);
        this.f4619t = (TextView) findViewById(R.id.me_dialog_info_phonenumber3);
        this.f4620u = (TextView) findViewById(R.id.me_dialog_info_phonenumber4);
        this.f4621v = (TextView) findViewById(R.id.me_dialog_info_samsungaccount);
        C4754bm.m18045a(this.f4617r, this.f4618s, this.f4619t, this.f4620u);
        if (TextUtils.isEmpty(C4822an.m18254v())) {
            this.f4621v.setVisibility(8);
        } else {
            this.f4621v.setText(C4822an.m18254v());
        }
        this.f4622w = (ImageView) findViewById(R.id.me_profile_popup_image);
        this.f4579A = (ImageView) findViewById(R.id.me_profile_popup_image_loading);
        this.f4623x = (ImageView) findViewById(R.id.me_profile_popup_image_1);
        this.f4580B = (ImageView) findViewById(R.id.me_profile_popup_image_1_loading);
        this.f4624y = (ImageView) findViewById(R.id.me_profile_popup_image_2);
        this.f4581C = (ImageView) findViewById(R.id.me_profile_popup_image_2_loading);
        this.f4625z = (ImageView) findViewById(R.id.me_profile_popup_image_3);
        this.f4582D = (ImageView) findViewById(R.id.me_profile_popup_image_3_loading);
        this.f4583E = (ImageButton) findViewById(R.id.me_profile_more_icon);
        this.f4589K = new C1337gq(this.f4622w);
        this.f4590L = new C1337gq(this.f4623x);
        this.f4591M = new C1337gq(this.f4624y);
        this.f4592N = new C1337gq(this.f4625z);
        this.f4593O = (LinearLayout) findViewById(R.id.me_profile_popup_image_history_layout);
        m7297a();
        String strM18121a = C4809aa.m18104a().m18121a("samsung_account_email", "");
        this.f4614o.requestFocus();
        if ((!TextUtils.isEmpty(strM18121a) || C4822an.m18197G()) && !z) {
            this.f4607h.m9310b(null, "5");
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
        m7301a(true);
        if (configuration.orientation == 2) {
            this.f4619t.setVisibility(8);
            this.f4620u.setVisibility(8);
        } else {
            this.f4619t.setVisibility(0);
            this.f4620u.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            switch (view.getId()) {
                case R.id.me_profile_popup_info_btn /* 2131166372 */:
                    Intent intent = new Intent(getApplicationContext(), (Class<?>) MyInfoActivity.class);
                    intent.putExtra("INTENT_FROM", 10);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.me_profile_popup_view_profile /* 2131166373 */:
                    Intent intentM3014a = TabActivity.m3014a(getApplicationContext());
                    intentM3014a.putExtra("callMyPageTab", true);
                    startActivity(intentM3014a);
                    finish();
                    break;
                case R.id.me_profile_popup_image /* 2131166376 */:
                case R.id.me_profile_more_icon /* 2131166391 */:
                    startActivity(new Intent(getApplicationContext(), (Class<?>) ProfileImageHistoryActivity.class));
                    finish();
                    break;
                case R.id.me_profile_popup_image_1 /* 2131166385 */:
                    Intent intent2 = new Intent(getApplicationContext(), (Class<?>) ProfileImageHistoryActivity.class);
                    intent2.putExtra("mSmallImageNum", 1);
                    startActivity(intent2);
                    finish();
                    break;
                case R.id.me_profile_popup_image_2 /* 2131166387 */:
                    Intent intent3 = new Intent(getApplicationContext(), (Class<?>) ProfileImageHistoryActivity.class);
                    intent3.putExtra("mSmallImageNum", 2);
                    startActivity(intent3);
                    finish();
                    break;
                case R.id.me_profile_popup_image_3 /* 2131166389 */:
                    Intent intent4 = new Intent(getApplicationContext(), (Class<?>) ProfileImageHistoryActivity.class);
                    intent4.putExtra("mSmallImageNum", 3);
                    startActivity(intent4);
                    finish();
                    break;
            }
        }
    }

    /* renamed from: a */
    private void m7297a() {
        this.f4622w.setOnClickListener(this);
        this.f4623x.setOnClickListener(this);
        this.f4624y.setOnClickListener(this);
        this.f4625z.setOnClickListener(this);
        this.f4583E.setOnClickListener(this);
        C4754bm.m18046a(this.f4596R);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7300a(BuddyProfile buddyProfile) {
        if (buddyProfile.name != null) {
            this.f4612m.setText(buddyProfile.name);
        }
        this.f4616q = (TextView) findViewById(R.id.me_profile_popup_status_message);
        if (buddyProfile.status != null) {
            if (!TextUtils.isEmpty(buddyProfile.status)) {
                this.f4616q.setText(buddyProfile.status);
                return;
            } else {
                this.f4616q.setText(R.string.mypage_enter_status_message);
                return;
            }
        }
        if (this.f4611l != null && !TextUtils.isEmpty(this.f4611l)) {
            this.f4616q.setText(this.f4611l);
        } else {
            this.f4616q.setText(R.string.mypage_enter_status_message);
        }
    }

    /* renamed from: b */
    private void m7303b() {
        Bitmap bitmap;
        if (this.f4586H != null && (bitmap = this.f4586H.getBitmap()) != null) {
            bitmap.recycle();
        }
    }

    /* renamed from: a */
    private void m7298a(ImageView imageView) {
        m7303b();
        C4809aa.m18104a().m18121a("coverstory_metaid", "");
        C4904y.m18639b(" setCoverstoryAndDownload [dirInternalPath] : " + this.f4605f + " [filename] : mycoverstory.jpg", f4578a);
        File file = new File(this.f4605f);
        if (!new File(this.f4605f + "mycoverstory.jpg").exists() || TextUtils.isEmpty("mycoverstory.jpg")) {
            C4904y.m18639b("setCoverStory there is no mycoverstory.jpg loadDefaultCoverStory()", f4578a);
            C1331gk.m7458a(this.f4585G);
            return;
        }
        C4904y.m18639b("setCoverStory", f4578a);
        if (imageView != null) {
            imageView.setImageURI(Uri.parse(file + "/mycoverstory.jpg"));
        } else {
            C4904y.m18639b("loadCoverStoryImages bitmap is null. loadDefaultCoverStory()", f4578a);
            C1331gk.m7458a(this.f4585G);
        }
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f4622w != null) {
            this.f4622w.setImageBitmap(null);
            this.f4622w = null;
        }
        if (this.f4623x != null) {
            this.f4623x.setImageBitmap(null);
            this.f4623x = null;
        }
        if (this.f4624y != null) {
            this.f4624y.setImageBitmap(null);
            this.f4624y = null;
        }
        if (this.f4625z != null) {
            this.f4625z.setImageBitmap(null);
            this.f4625z = null;
        }
        if (this.f4583E != null) {
            this.f4583E.setImageBitmap(null);
            this.f4583E = null;
        }
        if (this.f4584F != null) {
            this.f4584F.m9537a();
            this.f4584F.m9546e();
            this.f4584F.m9547f();
            this.f4584F.m9548g();
            this.f4584F = null;
        }
        if (this.f4607h != null) {
            this.f4607h.m9321h();
            this.f4607h = null;
        }
        this.f4598T = null;
    }
}
