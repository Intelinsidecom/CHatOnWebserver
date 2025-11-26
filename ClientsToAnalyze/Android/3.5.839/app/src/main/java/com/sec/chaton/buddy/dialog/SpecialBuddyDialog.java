package com.sec.chaton.buddy.dialog;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.buddy.p050a.C1107d;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.C2230ar;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.passwordlock.PasswordLockActivity;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4855bt;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4836ba;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.CommonApplication;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.common.p132g.InterfaceC5010f;
import com.sec.common.util.C5034k;
import com.sec.widget.C5179v;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class SpecialBuddyDialog extends PasswordLockActivity implements View.OnClickListener, InterfaceC5010f {

    /* renamed from: A */
    private LinearLayout f4657A;

    /* renamed from: B */
    private LinearLayout f4658B;

    /* renamed from: C */
    private LinearLayout f4659C;

    /* renamed from: D */
    private LinearLayout f4660D;

    /* renamed from: E */
    private LinearLayout f4661E;

    /* renamed from: F */
    private ViewGroup f4662F;

    /* renamed from: G */
    private Button f4663G;

    /* renamed from: H */
    private Button f4664H;

    /* renamed from: J */
    private ExecutorService f4666J;

    /* renamed from: d */
    private C2210x f4672d;

    /* renamed from: e */
    private C1107d f4673e;

    /* renamed from: f */
    private ProgressDialog f4674f;

    /* renamed from: g */
    private Toast f4675g;

    /* renamed from: h */
    private Context f4676h;

    /* renamed from: i */
    private String f4677i;

    /* renamed from: j */
    private String f4678j;

    /* renamed from: k */
    private String f4679k;

    /* renamed from: r */
    private ImageView f4686r;

    /* renamed from: s */
    private ImageView f4687s;

    /* renamed from: t */
    private TextView f4688t;

    /* renamed from: u */
    private TextView f4689u;

    /* renamed from: v */
    private TextView f4690v;

    /* renamed from: w */
    private ProgressBar f4691w;

    /* renamed from: x */
    private ProgressBar f4692x;

    /* renamed from: y */
    private boolean f4693y;

    /* renamed from: z */
    private LinearLayout f4694z;

    /* renamed from: l */
    private int f4680l = 0;

    /* renamed from: m */
    private long f4681m = 0;

    /* renamed from: n */
    private int f4682n = -1;

    /* renamed from: o */
    private long f4683o = -1;

    /* renamed from: p */
    private int f4684p = 0;

    /* renamed from: q */
    private boolean f4685q = false;

    /* renamed from: I */
    private Bitmap f4665I = null;

    /* renamed from: K */
    private EnumC4836ba f4667K = EnumC4836ba.NO_CONTENT;

    /* renamed from: L */
    private boolean f4668L = false;

    /* renamed from: a */
    View.OnClickListener f4669a = new ViewOnClickListenerC1221au(this);

    /* renamed from: b */
    InterfaceC2211y f4670b = new C1222av(this);

    /* renamed from: c */
    Handler f4671c = new HandlerC1212al(this);

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    @TargetApi(11)
    protected void onCreate(Bundle bundle) {
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        if (C4904y.f17873c) {
            C4904y.m18641c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, "SpecialBuddyDialog");
        }
        this.f4666J = Executors.newSingleThreadExecutor();
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.f4676h = this;
        this.f4677i = getIntent().getExtras().getString("specialuserid");
        this.f4678j = getIntent().getExtras().getString("speicalusername");
        this.f4672d = new C2210x(getContentResolver(), this.f4670b);
        this.f4672d.startQuery(501, null, C2230ar.f7958a, null, "buddy_no = ? ", new String[]{this.f4677i}, null);
        this.f4684p = getIntent().getExtras().getInt("CURRENT_POSITION");
        if (this.f4677i == null) {
            finish();
        }
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (C4904y.f17873c) {
            C4904y.m18641c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, "SpecialBuddyDialog");
        }
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onDestroy() {
        m7380h();
        if (this.f4666J != null && !this.f4666J.isShutdown()) {
            this.f4666J.shutdown();
        }
        super.onDestroy();
        this.f4676h = null;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7355a() {
        if (this.f4673e != null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("[initView()] mSpecialBuddyInfo : " + this.f4673e.m7084b(), "SpecialBuddyDialog");
            }
            if (!this.f4668L) {
                setContentView(R.layout.special_buddy_profile_popup);
            }
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.special_buddy_profile_popup_layout);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.special_buddy_profile_popup_image_layout);
            Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
            int orientation = getWindowManager().getDefaultDisplay().getOrientation();
            if (orientation == 0 || orientation == 2) {
                linearLayout.setLayoutParams(new FrameLayout.LayoutParams((int) (defaultDisplay.getWidth() * 0.9d), -2));
                frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (defaultDisplay.getWidth() * 0.875d)));
            } else {
                linearLayout.setLayoutParams(new FrameLayout.LayoutParams((int) (defaultDisplay.getWidth() * 0.6d), -2));
                frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.livepartner_popup_boddy_height)));
            }
            this.f4694z = (LinearLayout) findViewById(R.id.special_buddy_profile_popup_favorite_btn);
            this.f4694z.setOnClickListener(this.f4669a);
            this.f4687s = (ImageView) findViewById(R.id.special_buddy_profile_popup_favorite);
            this.f4690v = (TextView) findViewById(R.id.special_buddy_profile_like_count);
            if (this.f4690v != null) {
                this.f4690v.setVisibility(8);
            }
            if (this.f4673e.m7088e() != null) {
                this.f4680l = Integer.parseInt(this.f4673e.m7088e());
            } else {
                this.f4680l = 0;
            }
            m7370d();
            this.f4688t = (TextView) findViewById(R.id.special_buddy_profile_popup_name);
            if (this.f4678j != null) {
                this.f4688t.setText(this.f4678j);
            } else {
                this.f4688t.setText(R.string.live);
            }
            this.f4691w = (ProgressBar) findViewById(R.id.special_buddy_profile_popup_image_loading);
            this.f4692x = (ProgressBar) findViewById(R.id.special_buddy_profile_popup_progress_like_unlike);
            this.f4689u = (TextView) findViewById(R.id.special_buddy_profile_popup_status_message);
            if (TextUtils.isEmpty(this.f4673e.m7089f())) {
                this.f4689u.setVisibility(8);
            } else {
                this.f4689u.setVisibility(0);
                this.f4689u.setText(this.f4673e.m7089f());
                this.f4689u.setContentDescription(this.f4673e.m7089f());
                this.f4689u.setOnClickListener(new ViewOnClickListenerC1211ak(this));
                this.f4689u.setSoundEffectsEnabled(false);
            }
            if (this.f4667K != EnumC4836ba.SUCCESS) {
                C4904y.m18639b("Photo not loaded yet", "SpecialBuddyDialog");
                this.f4686r = (ImageView) findViewById(R.id.special_buddy_profile_popup_image);
                this.f4686r.setOnClickListener(this.f4669a);
                this.f4686r.setContentDescription(getString(R.string.live) + " " + getString(R.string.media_photo));
                C2496n.m10765a(this.f4686r, this.f4673e.m7082a(), EnumC2498p.SQUARE);
                if (this.f4673e.m7090g().equalsIgnoreCase("y")) {
                    m7383i();
                    C4812ad.m18155a(this.f4673e.m7082a(), this.f4666J, new C1214an(this));
                }
            }
            this.f4657A = (LinearLayout) findViewById(R.id.special_buddy_profile_popup_add_buddy);
            this.f4657A.setOnTouchListener(new ViewOnTouchListenerC1216ap(this));
            this.f4657A.setOnClickListener(this.f4669a);
            this.f4661E = (LinearLayout) findViewById(R.id.special_buddy_profile_popup_contents);
            this.f4661E.setContentDescription(getString(R.string.live) + " " + getString(R.string.dialog_view));
            this.f4661E.setOnTouchListener(new ViewOnTouchListenerC1217aq(this));
            this.f4661E.setOnClickListener(this.f4669a);
            this.f4659C = (LinearLayout) findViewById(R.id.special_buddy_profile_popup_chat);
            this.f4659C.setOnTouchListener(new ViewOnTouchListenerC1218ar(this));
            this.f4659C.setOnClickListener(this.f4669a);
            this.f4658B = (LinearLayout) findViewById(R.id.special_buddy_profile_popup_ignore);
            this.f4658B.setOnTouchListener(new ViewOnTouchListenerC1219as(this));
            this.f4658B.setOnClickListener(this.f4669a);
            this.f4660D = (LinearLayout) findViewById(R.id.special_buddy_profile_popup_view_profile);
            this.f4660D.setOnTouchListener(new ViewOnTouchListenerC1220at(this));
            this.f4660D.setOnClickListener(this.f4669a);
            m7363b();
        } else {
            C4855bt.m18351a(this.f4676h).m18362a(this.f4686r, this.f4677i, false);
            C4904y.m18639b("[initView()] mSpecialBuddyInfo is null ", "SpecialBuddyDialog");
            setContentView(R.layout.special_buddy_profile_popup);
            this.f4688t = (TextView) findViewById(R.id.special_buddy_profile_popup_name);
            if (this.f4678j != null) {
                this.f4688t.setText(this.f4678j);
            } else {
                this.f4688t.setText("Special Buddy");
            }
            if (this.f4678j == null) {
                this.f4688t.setText(getString(R.string.unknown));
            } else {
                this.f4688t.setText(this.f4678j);
                this.f4688t.setContentDescription(this.f4678j);
            }
            this.f4689u = (TextView) findViewById(R.id.special_buddy_profile_popup_status_message);
            if (this.f4679k != null) {
                this.f4689u.setText(this.f4679k);
            } else {
                this.f4689u.setVisibility(8);
            }
            this.f4687s = (ImageView) findViewById(R.id.special_buddy_profile_popup_favorite);
            this.f4690v = (TextView) findViewById(R.id.special_buddy_profile_like_count);
            if (this.f4690v != null) {
                this.f4690v.setVisibility(8);
            }
            m7370d();
            this.f4663G = (Button) findViewById(R.id.special_buddy_profile_popup_add_buddy);
            this.f4664H = (Button) findViewById(R.id.special_buddy_profile_popup_ignore);
            this.f4663G.setOnClickListener(this.f4669a);
            this.f4664H.setOnClickListener(this.f4669a);
            this.f4662F.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f4663G.setText(R.string.buddy_profile_button_block);
                this.f4664H.setText(R.string.buddy_add_contact);
            }
        }
        this.f4668L = true;
    }

    /* renamed from: b */
    private void m7363b() {
        if (this.f4685q) {
            m7367c();
            this.f4658B.setVisibility(0);
            this.f4660D.setVisibility(0);
            this.f4694z.setVisibility(0);
            this.f4657A.setVisibility(8);
            return;
        }
        this.f4657A.setVisibility(0);
        this.f4660D.setVisibility(0);
        this.f4694z.setVisibility(8);
        this.f4659C.setVisibility(8);
        this.f4661E.setVisibility(8);
        this.f4658B.setVisibility(8);
    }

    /* renamed from: c */
    private void m7367c() {
        switch (C1213am.f4708a[this.f4673e.m7093j().ordinal()]) {
            case 1:
                this.f4659C.setVisibility(0);
                this.f4661E.setVisibility(8);
                break;
            case 2:
                this.f4659C.setVisibility(8);
                this.f4661E.setVisibility(0);
                break;
            case 3:
                this.f4659C.setVisibility(0);
                this.f4661E.setVisibility(0);
                break;
            case 4:
                this.f4659C.setVisibility(8);
                this.f4661E.setVisibility(0);
                break;
            case 5:
                this.f4659C.setVisibility(0);
                this.f4661E.setVisibility(0);
                break;
            case 6:
                this.f4659C.setVisibility(8);
                this.f4661E.setVisibility(0);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7358a(boolean z) {
        if (this.f4687s != null) {
            if (z) {
                this.f4687s.setImageResource(R.drawable.actionbar_ic_live_01);
                this.f4687s.setContentDescription(getResources().getText(R.string.special_buddy_popup_unlike));
            } else {
                this.f4687s.setImageResource(R.drawable.actionbar_ic_live_02);
                this.f4687s.setContentDescription(getResources().getText(R.string.special_buddy_popup_like));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m7370d() {
        m7358a(this.f4693y);
        if (this.f4690v != null) {
            this.f4690v.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7365b(boolean z) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (z) {
                if (this.f4694z != null) {
                    this.f4694z.setVisibility(8);
                }
                if (this.f4692x != null) {
                    this.f4692x.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.f4694z != null) {
                this.f4694z.setVisibility(0);
            }
            if (this.f4692x != null) {
                this.f4692x.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m7373e() {
        new C2128i(this.f4671c).m9511b(this.f4677i, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m7376f() {
        new C2128i(this.f4671c).m9516c(this.f4677i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m7378g() {
        if (this.f4676h != null) {
            if (this.f4674f == null) {
                this.f4674f = ProgressDialogC4926s.m18728a(this.f4676h, null, this.f4676h.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            } else {
                this.f4674f.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m7380h() {
        if (this.f4676h != null && this.f4674f != null) {
            this.f4674f.dismiss();
        }
    }

    /* renamed from: i */
    private void m7383i() {
        if (this.f4691w != null) {
            this.f4691w.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m7385j() {
        if (this.f4691w != null) {
            this.f4691w.setVisibility(8);
        }
    }

    @Override // com.sec.common.p132g.InterfaceC5010f
    /* renamed from: a */
    public void mo6852a(View view, AbstractRunnableC5005a<?> abstractRunnableC5005a) {
    }

    @Override // com.sec.common.p132g.InterfaceC5010f
    /* renamed from: b */
    public void mo6860b(View view, AbstractRunnableC5005a<?> abstractRunnableC5005a) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean m7369c(boolean z) {
        if (C5034k.m19106k()) {
            return true;
        }
        if (z) {
            m7357a(EnumC1223aw.Nonetwork);
        }
        return false;
    }

    /* renamed from: a */
    private void m7357a(EnumC1223aw enumC1223aw) {
        if (this.f4675g == null) {
            this.f4675g = C5179v.m19811a(CommonApplication.m18732r(), (CharSequence) null, 0);
        }
        switch (C1213am.f4709b[enumC1223aw.ordinal()]) {
            case 1:
                m7356a(R.string.popup_no_network_connection);
                break;
            case 2:
                m7356a(R.string.toast_network_unable);
                break;
        }
    }

    /* renamed from: a */
    private void m7356a(int i) {
        if (this.f4675g != null) {
            this.f4675g.setText(i);
            this.f4675g.setDuration(0);
            this.f4675g.show();
        }
    }
}
