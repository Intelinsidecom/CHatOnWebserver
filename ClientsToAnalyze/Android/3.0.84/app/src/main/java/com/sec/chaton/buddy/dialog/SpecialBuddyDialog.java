package com.sec.chaton.buddy.dialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.buddy.p019a.C0514d;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.C1388af;
import com.sec.chaton.p027e.C1390ah;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p035io.entry.inner.SpecialUser;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.common.p069e.InterfaceC3329f;
import com.sec.common.util.C3347i;
import com.sec.widget.C3641ai;

/* loaded from: classes.dex */
public class SpecialBuddyDialog extends Activity implements View.OnClickListener, InterfaceC3329f {

    /* renamed from: A */
    private LinearLayout f2788A;

    /* renamed from: B */
    private ViewGroup f2789B;

    /* renamed from: C */
    private Button f2790C;

    /* renamed from: D */
    private Button f2791D;

    /* renamed from: E */
    private Button f2792E;

    /* renamed from: F */
    private Button f2793F;

    /* renamed from: d */
    private C1377u f2798d;

    /* renamed from: e */
    private C0514d f2799e;

    /* renamed from: f */
    private ProgressDialog f2800f;

    /* renamed from: g */
    private Toast f2801g;

    /* renamed from: h */
    private Context f2802h;

    /* renamed from: i */
    private String f2803i;

    /* renamed from: j */
    private String f2804j;

    /* renamed from: n */
    private ImageView f2808n;

    /* renamed from: o */
    private ImageView f2809o;

    /* renamed from: p */
    private TextView f2810p;

    /* renamed from: q */
    private TextView f2811q;

    /* renamed from: r */
    private TextView f2812r;

    /* renamed from: s */
    private ProgressBar f2813s;

    /* renamed from: t */
    private ProgressBar f2814t;

    /* renamed from: u */
    private boolean f2815u;

    /* renamed from: v */
    private LinearLayout f2816v;

    /* renamed from: w */
    private LinearLayout f2817w;

    /* renamed from: x */
    private LinearLayout f2818x;

    /* renamed from: y */
    private LinearLayout f2819y;

    /* renamed from: z */
    private LinearLayout f2820z;

    /* renamed from: k */
    private int f2805k = 0;

    /* renamed from: l */
    private int f2806l = 0;

    /* renamed from: m */
    private boolean f2807m = false;

    /* renamed from: G */
    private Bitmap f2794G = null;

    /* renamed from: a */
    View.OnClickListener f2795a = new ViewOnClickListenerC0617ak(this);

    /* renamed from: b */
    InterfaceC1378v f2796b = new C0618al(this);

    /* renamed from: c */
    Handler f2797c = new HandlerC0608ab(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        if (C3250y.f11735c) {
            C3250y.m11453c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, "SpecialBuddyDialog");
        }
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.f2802h = this;
        this.f2803i = getIntent().getExtras().getString("specialuserid");
        this.f2804j = getIntent().getExtras().getString("speicalusername");
        this.f2807m = C1357af.m5997c(getContentResolver(), this.f2803i);
        this.f2806l = getIntent().getExtras().getInt("CURRENT_POSITION");
        if (this.f2803i == null) {
            finish();
        }
        this.f2798d = new C1377u(getContentResolver(), this.f2796b);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f2807m) {
            this.f2798d.startQuery(1, null, C1390ah.f5188a, null, "buddy_no = ? ", new String[]{this.f2803i}, null);
        } else {
            this.f2798d.startQuery(4, null, C1388af.f5186a, null, "buddy_no = ? ", new String[]{this.f2803i}, null);
        }
        if (C3250y.f11735c) {
            C3250y.m11453c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, "SpecialBuddyDialog");
        }
        m4316j();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        m4309g();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4289a(boolean z) {
        if (this.f2799e != null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("[initView()] isFollowed : " + z + " mSpecialBuddyInfo : " + this.f2799e.m4001b(), "SpecialBuddyDialog");
            }
            setContentView(R.layout.special_buddy_profile_popup);
            this.f2816v = (LinearLayout) findViewById(R.id.special_buddy_profile_popup_favorite_btn);
            this.f2816v.setOnClickListener(this.f2795a);
            this.f2809o = (ImageView) findViewById(R.id.special_buddy_profile_popup_favorite);
            this.f2812r = (TextView) findViewById(R.id.special_buddy_profile_like_count);
            if (this.f2799e.m4004e() != null) {
                this.f2805k = Integer.parseInt(this.f2799e.m4004e());
            } else {
                this.f2805k = 0;
            }
            m4296c();
            this.f2810p = (TextView) findViewById(R.id.special_buddy_profile_popup_name);
            if (this.f2804j != null) {
                this.f2810p.setText(this.f2804j);
            } else {
                this.f2810p.setText("Special Buddy");
            }
            this.f2813s = (ProgressBar) findViewById(R.id.special_buddy_profile_popup_image_loading);
            this.f2814t = (ProgressBar) findViewById(R.id.special_buddy_profile_popup_progress_like_unlike);
            this.f2811q = (TextView) findViewById(R.id.special_buddy_profile_popup_status_message);
            if (TextUtils.isEmpty(this.f2799e.m4005f())) {
                this.f2811q.setVisibility(8);
            } else {
                this.f2811q.setText(this.f2799e.m4005f());
                this.f2811q.setContentDescription(this.f2799e.m4005f());
                this.f2811q.setOnTouchListener(new ViewOnTouchListenerC0607aa(this));
            }
            this.f2808n = (ImageView) findViewById(R.id.special_buddy_profile_popup_image);
            this.f2808n.setOnClickListener(this.f2795a);
            C3205bt.m11182a(this.f2802h).m11210a(this.f2808n, this.f2799e.m4000a());
            if (this.f2799e.m4006g().equalsIgnoreCase("y")) {
                m4311h();
                C3162ad.m11009a(this.f2799e.m4000a(), new C0610ad(this));
            }
            this.f2817w = (LinearLayout) findViewById(R.id.special_buddy_profile_popup_add_buddy);
            this.f2817w.setOnTouchListener(new ViewOnTouchListenerC0612af(this));
            this.f2817w.setOnClickListener(this.f2795a);
            this.f2788A = (LinearLayout) findViewById(R.id.special_buddy_profile_popup_contents);
            this.f2788A.setOnTouchListener(new ViewOnTouchListenerC0613ag(this));
            this.f2788A.setOnClickListener(this.f2795a);
            this.f2819y = (LinearLayout) findViewById(R.id.special_buddy_profile_popup_chat);
            this.f2819y.setOnTouchListener(new ViewOnTouchListenerC0614ah(this));
            this.f2819y.setOnClickListener(this.f2795a);
            this.f2818x = (LinearLayout) findViewById(R.id.special_buddy_profile_popup_ignore);
            this.f2818x.setOnTouchListener(new ViewOnTouchListenerC0615ai(this));
            this.f2818x.setOnClickListener(this.f2795a);
            this.f2820z = (LinearLayout) findViewById(R.id.special_buddy_profile_popup_view_profile);
            this.f2820z.setOnTouchListener(new ViewOnTouchListenerC0616aj(this));
            this.f2820z.setOnClickListener(this.f2795a);
            m4286a();
            return;
        }
        C3250y.m11450b("[initView()] isFollowed : " + z + " mSpecialBuddyInfo is null ", "SpecialBuddyDialog");
        setContentView(R.layout.special_buddy_profile_popup);
        this.f2810p = (TextView) findViewById(R.id.special_buddy_profile_popup_name);
        if (this.f2804j != null) {
            this.f2810p.setText(this.f2804j);
        } else {
            this.f2810p.setText("Special Buddy");
        }
        if (this.f2804j == null) {
            this.f2810p.setText(getString(R.string.unknown));
        } else {
            this.f2810p.setText(this.f2804j);
            this.f2810p.setContentDescription(this.f2804j);
        }
        this.f2811q = (TextView) findViewById(R.id.special_buddy_profile_popup_status_message);
        this.f2811q.setVisibility(8);
        this.f2790C = (Button) findViewById(R.id.special_buddy_profile_popup_add_buddy);
        this.f2791D = (Button) findViewById(R.id.special_buddy_profile_popup_ignore);
        this.f2792E = (Button) findViewById(R.id.new_buddy_unblock);
        this.f2793F = (Button) findViewById(R.id.new_buddy_cancel);
        this.f2790C.setOnClickListener(this.f2795a);
        this.f2791D.setOnClickListener(this.f2795a);
        this.f2792E.setOnClickListener(this.f2795a);
        this.f2793F.setOnClickListener(this.f2795a);
        this.f2789B.setVisibility(0);
        this.f2792E.setVisibility(0);
        this.f2793F.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 11) {
            this.f2790C.setText(R.string.buddy_profile_button_block);
            this.f2791D.setText(R.string.buddy_profile_button_addbuddy);
            this.f2792E.setText(R.string.cancel);
            this.f2793F.setText(R.string.setting_block_unblock);
        }
        new C1330h(this.f2797c).m5748f(this.f2803i, false);
    }

    /* renamed from: a */
    private void m4286a() {
        if (this.f2807m) {
            m4292b();
            this.f2818x.setVisibility(0);
            this.f2820z.setVisibility(0);
            this.f2816v.setVisibility(0);
            this.f2817w.setVisibility(8);
            return;
        }
        this.f2817w.setVisibility(0);
        this.f2820z.setVisibility(0);
        this.f2816v.setVisibility(8);
        this.f2819y.setVisibility(8);
        this.f2788A.setVisibility(8);
        this.f2818x.setVisibility(8);
    }

    /* renamed from: b */
    private void m4292b() {
        switch (C0609ac.f2824a[this.f2799e.m4012m().ordinal()]) {
            case 1:
                this.f2819y.setVisibility(0);
                this.f2788A.setVisibility(8);
                break;
            case 2:
                this.f2819y.setVisibility(8);
                this.f2788A.setVisibility(0);
                break;
            case 3:
                this.f2819y.setVisibility(0);
                this.f2788A.setVisibility(0);
                break;
            case 4:
                this.f2819y.setVisibility(8);
                this.f2788A.setVisibility(0);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4294b(boolean z) {
        if (z) {
            this.f2809o.setImageResource(R.drawable.actionbar_ic_live_01);
        } else {
            this.f2809o.setImageResource(R.drawable.actionbar_ic_live_02);
        }
    }

    /* renamed from: a */
    private void m4287a(int i) {
        if (i != 0) {
            this.f2812r.setText(getString(R.string.livepartner_body_likes_count, new Object[]{Integer.valueOf(i)}));
            this.f2812r.setVisibility(0);
        } else {
            this.f2812r.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4296c() {
        m4294b(this.f2815u);
        m4287a(this.f2805k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4298c(boolean z) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (z) {
                if (this.f2816v != null) {
                    this.f2816v.setVisibility(8);
                }
                if (this.f2814t != null) {
                    this.f2814t.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.f2816v != null) {
                this.f2816v.setVisibility(0);
            }
            if (this.f2814t != null) {
                this.f2814t.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m4299d() {
        new C1330h(this.f2797c).m5737c(this.f2803i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m4303e() {
        new C1330h(this.f2797c).m5741d(this.f2803i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m4306f() {
        if (this.f2802h != null) {
            if (this.f2800f == null) {
                this.f2800f = ProgressDialogC3265l.m11490a(this.f2802h, null, this.f2802h.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            } else {
                this.f2800f.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m4309g() {
        if (this.f2802h != null && this.f2800f != null) {
            this.f2800f.dismiss();
        }
    }

    /* renamed from: h */
    private void m4311h() {
        if (this.f2813s != null) {
            this.f2813s.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m4314i() {
        if (this.f2813s != null) {
            this.f2813s.setVisibility(8);
        }
    }

    /* renamed from: a */
    C0514d m4323a(C0514d c0514d, SpecialUser specialUser) {
        return new C0514d(specialUser.specialuserid == null ? c0514d.m4000a() : specialUser.specialuserid, specialUser.name == null ? c0514d.m4001b() : specialUser.name, specialUser.description == null ? c0514d.m4002c() : specialUser.description, specialUser.followcount == null ? c0514d.m4003d() : specialUser.followcount, specialUser.likecount == null ? c0514d.m4004e() : specialUser.likecount, specialUser.msgstatus == null ? c0514d.m4005f() : specialUser.msgstatus, specialUser.photoloaded == null ? c0514d.m4006g() : specialUser.photoloaded, specialUser.status == null ? c0514d.m4007h() : specialUser.status, specialUser.url == null ? c0514d.m4008i() : specialUser.url, specialUser.weburl == null ? c0514d.m4009j() : specialUser.weburl, c0514d.m4010k(), specialUser.tel == null ? c0514d.m4011l() : specialUser.tel);
    }

    /* renamed from: j */
    private void m4316j() {
        C3250y.m11450b("showPasswordLockActivity", "SpecialBuddyDialog");
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // com.sec.common.p069e.InterfaceC3329f
    /* renamed from: a */
    public void mo3713a(View view, AbstractRunnableC3324a<?> abstractRunnableC3324a) {
    }

    @Override // com.sec.common.p069e.InterfaceC3329f
    /* renamed from: b */
    public void mo3722b(View view, AbstractRunnableC3324a<?> abstractRunnableC3324a) {
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
    /* renamed from: d */
    public boolean m4302d(boolean z) {
        if (C3347i.m11788k()) {
            return true;
        }
        if (z) {
            m4288a(EnumC0619am.Nonetwork);
        }
        return false;
    }

    /* renamed from: a */
    private void m4288a(EnumC0619am enumC0619am) {
        if (this.f2801g == null) {
            this.f2801g = C3641ai.m13211a(CommonApplication.m11493l(), (CharSequence) null, 0);
        }
        switch (C0609ac.f2825b[enumC0619am.ordinal()]) {
            case 1:
                this.f2801g.setText(R.string.popup_no_network_connection);
                this.f2801g.setDuration(0);
                this.f2801g.show();
                break;
            case 2:
                this.f2801g.setText(R.string.toast_network_unable);
                this.f2801g.setDuration(0);
                this.f2801g.show();
                break;
        }
    }
}
