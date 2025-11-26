package com.sec.chaton.buddy.dialog;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.sso.p006a.C0045a;
import com.sec.chaton.R;
import com.sec.chaton.account.C0423i;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.buddy.BuddyEditNickNameActivity;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.BuddyProfileImageView;
import com.sec.chaton.buddy.C0699fj;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.p025d.C1328f;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p025d.C1331i;
import com.sec.chaton.p025d.C1336n;
import com.sec.chaton.p025d.C1345w;
import com.sec.chaton.p025d.p026a.C1206cg;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.p027e.C1445m;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.p028a.C1365i;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.plugin.C1948a;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.trunk.p061c.C3020a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3231f;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.common.p069e.C3326c;
import com.sec.common.p069e.InterfaceC3329f;
import com.sec.widget.C3641ai;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class BuddyDialog extends Activity implements View.OnClickListener, InterfaceC3329f {

    /* renamed from: a */
    public static final String f2599a = BuddyDialog.class.getSimpleName();

    /* renamed from: b */
    public static String f2600b;

    /* renamed from: c */
    public static String f2601c;

    /* renamed from: A */
    private LinearLayout f2602A;

    /* renamed from: B */
    private TextView f2603B;

    /* renamed from: C */
    private ImageView f2604C;

    /* renamed from: D */
    private ImageView f2605D;

    /* renamed from: E */
    private ImageView f2606E;

    /* renamed from: F */
    private ImageView f2607F;

    /* renamed from: G */
    private ImageView f2608G;

    /* renamed from: H */
    private ImageView f2609H;

    /* renamed from: I */
    private ImageView f2610I;

    /* renamed from: J */
    private ImageView f2611J;

    /* renamed from: K */
    private ImageButton f2612K;

    /* renamed from: L */
    private ImageView f2613L;

    /* renamed from: M */
    private ImageView f2614M;

    /* renamed from: N */
    private LinearLayout f2615N;

    /* renamed from: O */
    private C0699fj f2616O;

    /* renamed from: P */
    private C0699fj f2617P;

    /* renamed from: Q */
    private C0699fj f2618Q;

    /* renamed from: R */
    private C0699fj f2619R;

    /* renamed from: S */
    private LinearLayout f2620S;

    /* renamed from: T */
    private LinearLayout f2621T;

    /* renamed from: U */
    private LinearLayout f2622U;

    /* renamed from: V */
    private LinearLayout f2623V;

    /* renamed from: W */
    private LinearLayout f2624W;

    /* renamed from: X */
    private LinearLayout f2625X;

    /* renamed from: Y */
    private LinearLayout f2626Y;

    /* renamed from: aA */
    private LinearLayout f2628aA;

    /* renamed from: aB */
    private LinearLayout f2629aB;

    /* renamed from: aC */
    private LinearLayout f2630aC;

    /* renamed from: aD */
    private LinearLayout f2631aD;

    /* renamed from: aE */
    private LinearLayout f2632aE;

    /* renamed from: aF */
    private int f2633aF;

    /* renamed from: aJ */
    private C0045a f2637aJ;

    /* renamed from: ac */
    private C3326c f2642ac;

    /* renamed from: ai */
    private Toast f2648ai;

    /* renamed from: aj */
    private boolean f2649aj;

    /* renamed from: al */
    private boolean f2651al;

    /* renamed from: am */
    private int f2652am;

    /* renamed from: an */
    private C1377u f2653an;

    /* renamed from: ao */
    private TextView f2654ao;

    /* renamed from: ap */
    private ImageView f2655ap;

    /* renamed from: aq */
    private ImageView f2656aq;

    /* renamed from: ar */
    private ImageView f2657ar;

    /* renamed from: as */
    private TextView f2658as;

    /* renamed from: at */
    private ViewGroup f2659at;

    /* renamed from: au */
    private Button f2660au;

    /* renamed from: av */
    private Button f2661av;

    /* renamed from: aw */
    private Button f2662aw;

    /* renamed from: ay */
    private ViewGroup f2664ay;

    /* renamed from: az */
    private LinearLayout f2665az;

    /* renamed from: d */
    String f2666d;

    /* renamed from: e */
    String f2667e;

    /* renamed from: f */
    String f2668f;

    /* renamed from: l */
    private String f2674l;

    /* renamed from: n */
    private int f2676n;

    /* renamed from: o */
    private C1345w f2677o;

    /* renamed from: p */
    private C1331i f2678p;

    /* renamed from: q */
    private C0513c f2679q;

    /* renamed from: r */
    private TextView f2680r;

    /* renamed from: s */
    private LinearLayout f2681s;

    /* renamed from: t */
    private ImageView f2682t;

    /* renamed from: u */
    private String f2683u;

    /* renamed from: y */
    private Context f2687y;

    /* renamed from: z */
    private ImageView f2688z;

    /* renamed from: k */
    private String f2673k = C3223ck.m11329c() + "/flag/";

    /* renamed from: m */
    private boolean f2675m = false;

    /* renamed from: v */
    private String f2684v = "coverstory.jpg";

    /* renamed from: w */
    private String f2685w = null;

    /* renamed from: x */
    private String f2686x = null;

    /* renamed from: Z */
    private boolean f2627Z = false;

    /* renamed from: aa */
    private boolean f2640aa = true;

    /* renamed from: ab */
    private boolean f2641ab = false;

    /* renamed from: ad */
    private String f2643ad = "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3159aa.m10962a().m10979a("imei", "");

    /* renamed from: ae */
    private String f2644ae = "&size=800";

    /* renamed from: af */
    private String f2645af = "&size=100";

    /* renamed from: ag */
    private boolean f2646ag = false;

    /* renamed from: ah */
    private boolean f2647ah = false;

    /* renamed from: ak */
    private boolean f2650ak = false;

    /* renamed from: ax */
    private boolean f2663ax = false;

    /* renamed from: aG */
    private boolean f2634aG = false;

    /* renamed from: aH */
    private boolean f2635aH = false;

    /* renamed from: aI */
    private int f2636aI = 0;

    /* renamed from: g */
    boolean f2669g = false;

    /* renamed from: aK */
    private Handler f2638aK = new HandlerC0620b(this);

    /* renamed from: h */
    InterfaceC1378v f2670h = new C0621c(this);

    /* renamed from: aL */
    private Handler f2639aL = new HandlerC0622d(this);

    /* renamed from: i */
    Handler f2671i = new HandlerC0623e(this);

    /* renamed from: j */
    InterfaceC1413d f2672j = new C0624f(this);

    /* renamed from: f */
    static /* synthetic */ int m4145f(BuddyDialog buddyDialog) {
        int i = buddyDialog.f2676n;
        buddyDialog.f2676n = i + 1;
        return i;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        C3250y.m11458g("onCreate()", f2599a);
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.f2653an = new C1377u(getContentResolver(), this.f2670h);
        this.f2648ai = C3641ai.m13211a(this, (CharSequence) null, 0);
        this.f2666d = getIntent().getExtras().getString("BUDDY_DIALOG_BUDDY_NO");
        this.f2667e = getIntent().getExtras().getString("BUDDY_DIALOG_BUDDY_NAME");
        this.f2663ax = getIntent().getExtras().getBoolean("BUDDY_DIALOG_BUDDY_FROM_SUGGESTION");
        this.f2653an.startQuery(3, null, C1441i.m6310c(), null, "buddy_no = ? ", new String[]{this.f2666d}, null);
        this.f2685w = getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        this.f2678p = new C1331i(this.f2638aK);
        this.f2678p.m5758a(this.f2666d);
        this.f2642ac = new C3326c();
        this.f2677o = new C1345w(this.f2638aK);
        f2600b = getApplicationContext().getCacheDir() + "/";
        f2601c = this.f2685w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4118a(boolean z) {
        setContentView(R.layout.buddy_profile_popup);
        this.f2687y = this;
        this.f2637aJ = new C0045a();
        this.f2634aG = false;
        this.f2635aH = false;
        this.f2642ac.m11735a(this);
        this.f2680r = (TextView) findViewById(R.id.buddy_profile_popup_name);
        if (this.f2679q.m3976c() != null) {
            this.f2680r.setText(this.f2679q.m3976c());
        }
        this.f2681s = (LinearLayout) findViewById(R.id.buddy_profile_popup_favorite_btn);
        this.f2681s.setOnClickListener(this);
        this.f2688z = (ImageView) findViewById(R.id.buddy_profile_popup_favorite);
        if (this.f2627Z) {
            this.f2688z.setImageResource(R.drawable.actionbar_ic_favorite_01);
        } else {
            this.f2688z.setImageResource(R.drawable.actionbar_ic_favorite_02);
        }
        this.f2602A = (LinearLayout) findViewById(R.id.buddy_profile_popup_pen_btn);
        this.f2602A.setOnClickListener(this);
        this.f2682t = (ImageView) findViewById(R.id.buddy_profile_popup_coverimage);
        this.f2603B = (TextView) findViewById(R.id.buddy_profile_popup_status_message);
        if (this.f2679q.m3977d() != null && !TextUtils.isEmpty(this.f2679q.m3977d())) {
            this.f2603B.setText(this.f2679q.m3977d());
        } else {
            this.f2603B.setVisibility(4);
        }
        this.f2604C = (ImageView) findViewById(R.id.buddy_profile_popup_image);
        this.f2608G = (ImageView) findViewById(R.id.buddy_profile_popup_image_loading);
        this.f2613L = (ImageView) findViewById(R.id.buddy_profile_popup_image_webonly);
        this.f2614M = (ImageView) findViewById(R.id.buddy_profile_popup_image_chatonv);
        this.f2615N = (LinearLayout) findViewById(R.id.buddy_profile_popup_image_history_layout);
        this.f2605D = (ImageView) findViewById(R.id.buddy_profile_popup_image_1);
        this.f2609H = (ImageView) findViewById(R.id.buddy_profile_popup_image_1_loading);
        this.f2606E = (ImageView) findViewById(R.id.buddy_profile_popup_image_2);
        this.f2610I = (ImageView) findViewById(R.id.buddy_profile_popup_image_2_loading);
        this.f2607F = (ImageView) findViewById(R.id.buddy_profile_popup_image_3);
        this.f2611J = (ImageView) findViewById(R.id.buddy_profile_popup_image_3_loading);
        this.f2612K = (ImageButton) findViewById(R.id.buddy_profile_more_icon);
        this.f2616O = new C0699fj(this.f2604C);
        this.f2617P = new C0699fj(this.f2605D);
        this.f2618Q = new C0699fj(this.f2606E);
        this.f2619R = new C0699fj(this.f2607F);
        this.f2617P.m4339a().setBackgroundResource(R.drawable.mypage_profile_image_selector);
        this.f2618Q.m4339a().setBackgroundResource(R.drawable.mypage_profile_image_selector);
        this.f2619R.m4339a().setBackgroundResource(R.drawable.mypage_profile_image_selector);
        try {
            C3231f.m11361a(getApplicationContext()).m11378a(this.f2616O, this.f2617P, this.f2618Q, this.f2619R, this.f2682t, this.f2666d);
            C3250y.m11450b("Is Web Only buddy : " + this.f2679q.m3968E(), f2599a);
            this.f2613L.setVisibility(this.f2679q.m3968E() == 1 ? 0 : 8);
            if (C1948a.m7903a(getApplicationContext()) && m4143e()) {
                this.f2614M.setVisibility(0);
            } else {
                this.f2614M.setVisibility(8);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
        m4192a();
        this.f2602A.requestFocus();
        if (!z) {
            if (this.f2677o == null) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("[BuddyDialog] mProfileControl is null ", f2599a);
                }
                this.f2677o = new C1345w(this.f2638aK);
            }
            this.f2677o.m5934b(this.f2666d, "160");
        }
        this.f2620S = (LinearLayout) findViewById(R.id.buddy_profile_popup_view_profile);
        this.f2620S.setOnClickListener(this);
        this.f2621T = (LinearLayout) findViewById(R.id.buddy_profile_popup_chat);
        this.f2621T.setOnClickListener(this);
        this.f2622U = (LinearLayout) findViewById(R.id.buddy_profile_popup_call);
        this.f2622U.setOnClickListener(this);
        this.f2623V = (LinearLayout) findViewById(R.id.buddy_profile_popup_contact);
        this.f2623V.setOnClickListener(this);
        this.f2624W = (LinearLayout) findViewById(R.id.buddy_profile_popup_voice_call);
        this.f2624W.setOnClickListener(this);
        this.f2624W.setVisibility(8);
        this.f2625X = (LinearLayout) findViewById(R.id.buddy_profile_popup_video_call);
        this.f2625X.setOnClickListener(this);
        this.f2625X.setVisibility(8);
        this.f2626Y = (LinearLayout) findViewById(R.id.buddy_profile_popup_solo_chat);
        this.f2626Y.setOnClickListener(this);
        if (this.f2636aI > 4 && this.f2612K != null) {
            this.f2612K.setVisibility(0);
            this.f2612K.setOnClickListener(this);
        }
        m4168m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m4136d() {
        setContentView(R.layout.buddy_variation_profile_popup);
        this.f2642ac.m11735a(this);
        this.f2654ao = (TextView) findViewById(R.id.buddy_cprofile_popup_name);
        if (TextUtils.isEmpty(this.f2667e)) {
            this.f2654ao.setText(getString(R.string.unknown));
        } else {
            this.f2654ao.setText(this.f2667e);
        }
        this.f2655ap = (ImageView) findViewById(R.id.buddy_cprofile_popup_image);
        C3205bt.m11182a(getApplicationContext()).m11210a(this.f2655ap, this.f2666d);
        this.f2656aq = (ImageView) findViewById(R.id.buddy_cprofile_popup_unauthenticated_image);
        this.f2657ar = (ImageView) findViewById(R.id.buddy_cprofile_popup_flag_image);
        this.f2632aE = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_loading_area);
        this.f2658as = (TextView) findViewById(R.id.buddy_cprofile_popup_guidetext_view);
        this.f2659at = (ViewGroup) findViewById(R.id.buddy_cprofile_popup_3_buttons);
        this.f2629aB = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_add);
        this.f2628aA = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_alarm);
        this.f2665az = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_block);
        this.f2630aC = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_unblock);
        this.f2631aD = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_ignore);
        this.f2629aB.setOnClickListener(this);
        this.f2628aA.setOnClickListener(this);
        this.f2665az.setOnClickListener(this);
        this.f2630aC.setOnClickListener(this);
        this.f2631aD.setOnClickListener(this);
        this.f2664ay = (ViewGroup) findViewById(R.id.buddy_cprofile_popup_buttons);
        this.f2660au = (Button) findViewById(R.id.buddy_cprofile_popup_button_cancel);
        this.f2661av = (Button) findViewById(R.id.buddy_cprofile_popup_button_ok);
        this.f2662aw = (Button) findViewById(R.id.buddy_cprofile_popup_button_retry);
        this.f2660au.setOnClickListener(this);
        this.f2661av.setOnClickListener(this);
        this.f2662aw.setOnClickListener(this);
        this.f2633aF = R.drawable.rotate_emoticon_loading;
        m4184u();
        new C1330h(this.f2639aL).m5748f(this.f2666d, false);
    }

    /* renamed from: d */
    private boolean m4139d(String str) {
        if (str.length() >= 19 && str.startsWith("10")) {
            C3250y.m11450b("chaton id : " + str, f2599a);
            return false;
        }
        if (str.startsWith("0")) {
            C3250y.m11450b("pin number : " + str, f2599a);
            return false;
        }
        C3250y.m11450b("phone number: " + str, f2599a);
        return true;
    }

    /* renamed from: e */
    private boolean m4143e() {
        boolean z = false;
        if (this.f2679q != null) {
            try {
                if (!TextUtils.isEmpty(this.f2679q.m3981h())) {
                    String strM3967D = this.f2679q.m3967D();
                    if (!TextUtils.isEmpty(strM3967D)) {
                        if (strM3967D.contains("voip=1")) {
                            z = true;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        C3250y.m11450b("isChatONVBuddy() : " + z, f2599a);
        return z;
    }

    /* renamed from: f */
    private boolean m4147f() {
        boolean z = false;
        try {
            if (C1948a.m7903a(getApplicationContext())) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3250y.m11450b("isChatONVSupportedDevice() : " + z, f2599a);
        return z;
    }

    /* renamed from: g */
    private boolean m4152g() {
        boolean z = false;
        try {
            if (C1954g.m7916a().m7918a(getApplicationContext(), EnumC1955h.ChatONV)) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3250y.m11450b("isChatONVAvaiable() : " + z, f2599a);
        return z;
    }

    /* renamed from: h */
    private boolean m4157h() {
        boolean z = false;
        try {
            C0045a c0045a = this.f2637aJ;
            if (C0045a.m37b(getApplicationContext())) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3250y.m11450b("isChatONVInstalled() : " + z, f2599a);
        return z;
    }

    /* renamed from: i */
    private boolean m4160i() {
        boolean zM55d;
        Exception e;
        try {
            zM55d = this.f2637aJ.m55d(getApplicationContext());
            try {
                C3250y.m11450b("isReadyToCall() : " + zM55d, f2599a);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                C3250y.m11450b("isChatONVReadyToCall() : " + zM55d, f2599a);
                return zM55d;
            }
        } catch (Exception e3) {
            zM55d = false;
            e = e3;
        }
        C3250y.m11450b("isChatONVReadyToCall() : " + zM55d, f2599a);
        return zM55d;
    }

    /* renamed from: j */
    private boolean m4162j() {
        boolean zM4120a;
        if (((TelephonyManager) getApplicationContext().getSystemService("phone")).getPhoneType() == 0) {
            zM4120a = false;
        } else {
            zM4120a = m4120a(this, new Intent("android.intent.action.CALL", Uri.parse("tel:+000")));
        }
        C3250y.m11458g("is3GCallAvailable : " + zM4120a, f2599a);
        return zM4120a;
    }

    /* renamed from: k */
    private boolean m4164k() {
        int iM6733a = C1594v.m6733a(getApplicationContext());
        if (-3 != iM6733a && -2 != iM6733a) {
            return true;
        }
        C3641ai.m13210a(getApplicationContext(), R.string.popup_no_network_connection, 0).show();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m4166l() {
        /*
            r7 = this;
            r1 = 1
            r2 = 0
            com.sec.chaton.buddy.a.c r0 = r7.f2679q
            int r0 = r0.m3966C()
            if (r0 == 0) goto L9d
            r0 = r1
        Lb:
            if (r0 == 0) goto La6
            boolean r3 = r7.m4162j()
            if (r3 != 0) goto La4
            android.content.Context r0 = r7.getApplicationContext()
            java.lang.String r4 = "phone"
            java.lang.Object r0 = r0.getSystemService(r4)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            android.content.Context r0 = r7.getApplicationContext()
            android.content.Intent r4 = new android.content.Intent
            java.lang.String r5 = "android.intent.action.SENDTO"
            java.lang.String r6 = "smsto:+000"
            android.net.Uri r6 = android.net.Uri.parse(r6)
            r4.<init>(r5, r6)
            boolean r0 = m4120a(r0, r4)
            if (r0 == 0) goto La4
            r0 = r1
        L37:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "processNoChatONVCase : buddyPhoneNumberAvailable = "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r3)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = com.sec.chaton.buddy.dialog.BuddyDialog.f2599a
            com.sec.chaton.util.C3250y.m11458g(r4, r5)
            java.lang.String r4 = r7.f2666d
            boolean r4 = r7.m4139d(r4)
            if (r4 != 0) goto La2
            if (r3 == 0) goto La0
            boolean r3 = r7.m4172o()
            if (r3 == 0) goto La0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "processNoChatONVCase : buddyPhoneNumberAvailable2 = "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = com.sec.chaton.buddy.dialog.BuddyDialog.f2599a
            com.sec.chaton.util.C3250y.m11458g(r2, r3)
        L77:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "processNoChatONVCase : buddyPhoneNumberAvailable = "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r1)
            java.lang.String r3 = " @ isContactShow = "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = com.sec.chaton.buddy.dialog.BuddyDialog.f2599a
            com.sec.chaton.util.C3250y.m11458g(r2, r3)
            r7.m4119a(r1, r0)
            return
        L9d:
            r0 = r2
            goto Lb
        La0:
            r1 = r2
            goto L77
        La2:
            r1 = r3
            goto L77
        La4:
            r0 = r2
            goto L37
        La6:
            r3 = r0
            r0 = r2
            goto L37
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.dialog.BuddyDialog.m4166l():void");
    }

    /* renamed from: a */
    private void m4119a(boolean z, boolean z2) {
        if (z) {
            this.f2646ag = true;
            return;
        }
        if (z2) {
            this.f2622U.setVisibility(8);
            this.f2623V.setVisibility(0);
        } else {
            this.f2622U.setVisibility(8);
            this.f2623V.setVisibility(8);
            this.f2621T.setBackgroundResource(R.drawable.buddy_profile_popup_solo_btn_bg);
        }
    }

    /* renamed from: b */
    private void m4129b(boolean z, boolean z2) {
        if (z) {
            this.f2622U.setVisibility(0);
            this.f2623V.setVisibility(8);
            this.f2624W.setVisibility(0);
            this.f2625X.setVisibility(0);
            this.f2625X.setBackgroundResource(R.drawable.buddy_profile_popup_right_btn_bg);
            return;
        }
        if (z2) {
            this.f2622U.setVisibility(8);
            this.f2623V.setVisibility(0);
            this.f2624W.setVisibility(0);
            this.f2625X.setVisibility(0);
            return;
        }
        this.f2622U.setVisibility(8);
        this.f2623V.setVisibility(8);
        this.f2624W.setVisibility(0);
        this.f2625X.setVisibility(0);
        this.f2625X.setBackgroundResource(R.drawable.buddy_profile_popup_right_btn_bg);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008a A[PHI: r10
  0x008a: PHI (r10v1 boolean) = (r10v0 boolean), (r10v3 boolean), (r10v3 boolean) binds: [B:3:0x000e, B:5:0x002c, B:7:0x004f] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m4128b(boolean r10) {
        /*
            r9 = this;
            r1 = 1
            r2 = 0
            boolean r3 = r9.m4147f()
            boolean r4 = r9.m4152g()
            boolean r5 = r9.m4160i()
            if (r10 == 0) goto L8a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "processMultiDeviceCase : buddyPhoneNumberAvailable = "
            java.lang.StringBuilder r0 = r0.append(r6)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = com.sec.chaton.buddy.dialog.BuddyDialog.f2599a
            com.sec.chaton.util.C3250y.m11458g(r0, r6)
            boolean r10 = r9.m4162j()
            if (r10 != 0) goto L8a
            android.content.Context r0 = r9.getApplicationContext()
            java.lang.String r6 = "phone"
            java.lang.Object r0 = r0.getSystemService(r6)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            android.content.Context r0 = r9.getApplicationContext()
            android.content.Intent r6 = new android.content.Intent
            java.lang.String r7 = "android.intent.action.SENDTO"
            java.lang.String r8 = "smsto:+000"
            android.net.Uri r8 = android.net.Uri.parse(r8)
            r6.<init>(r7, r8)
            boolean r0 = m4120a(r0, r6)
            if (r0 == 0) goto L8a
            r0 = r1
        L52:
            boolean r6 = r9.m4143e()
            if (r3 == 0) goto L74
            if (r4 == 0) goto L74
            if (r5 == 0) goto L68
            if (r6 == 0) goto L64
            r9.m4129b(r10, r0)
            r9.f2647ah = r1
        L63:
            return
        L64:
            r9.m4119a(r10, r0)
            goto L63
        L68:
            if (r6 == 0) goto L70
            r9.m4129b(r10, r0)
            r9.f2647ah = r2
            goto L63
        L70:
            r9.m4119a(r10, r0)
            goto L63
        L74:
            if (r3 == 0) goto L86
            boolean r1 = r9.m4157h()
            if (r1 != 0) goto L82
            if (r6 == 0) goto L82
            r9.m4129b(r10, r0)
            goto L63
        L82:
            r9.m4119a(r10, r0)
            goto L63
        L86:
            r9.m4119a(r10, r0)
            goto L63
        L8a:
            r0 = r2
            goto L52
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.dialog.BuddyDialog.m4128b(boolean):void");
    }

    /* renamed from: m */
    private void m4168m() {
        boolean z;
        if (this.f2679q != null) {
            if (this.f2679q.m3966C() != 0) {
            }
            C3250y.m11458g("showphonenumber : " + this.f2679q.m3966C(), f2599a);
            if (!this.f2651al) {
                C3250y.m11458g("refreshCommunicationButtons : is not multi-device", f2599a);
                m4166l();
                return;
            }
            C3250y.m11458g("refreshCommunicationButtons : is multi-device", f2599a);
            if (m4170n().size() == 0) {
                z = false;
            } else {
                z = true;
            }
            m4128b(z);
        }
    }

    /* renamed from: a */
    public static boolean m4120a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
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
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f2640aa) {
            m4118a(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        Uri uriM4196b;
        Uri uriM4196b2;
        switch (view.getId()) {
            case R.id.buddy_profile_popup_favorite_btn /* 2131165350 */:
                if (!this.f2627Z) {
                    this.f2653an.startQuery(4, this.f2679q, C1445m.f5377a, null, "group_relation_group = 1 ", null, null);
                    this.f2688z.setImageResource(R.drawable.actionbar_ic_favorite_01);
                    this.f2627Z = true;
                    break;
                } else {
                    this.f2653an.startDelete(2, this.f2679q, C1445m.f5377a, "group_relation_group = 1 AND group_relation_buddy = ? ", new String[]{this.f2666d});
                    this.f2688z.setImageResource(R.drawable.actionbar_ic_favorite_02);
                    this.f2627Z = false;
                    break;
                }
            case R.id.buddy_profile_popup_view_profile /* 2131165352 */:
                BuddyFragment.f1734m = true;
                Intent intent = new Intent(getApplicationContext(), (Class<?>) BuddyProfileActivity.class);
                intent.putExtra("PROFILE_BUDDY_NO", this.f2666d);
                intent.putExtra("PROFILE_BUDDY_NAME", this.f2679q.m3976c());
                intent.putExtra("PROFILE_BUDDY_PROFILE_LOAD_DONE", this.f2634aG);
                intent.putExtra("PROFILE_BUDDY_PROFILE_IMAGE_LOAD_DONE", this.f2635aH);
                intent.putExtra("PROFILE_BUDDY_PROFILE_IMAGE_COUNT", this.f2636aI);
                intent.putExtra("PROFILE_BUDDY_FROM_BUDDYDIALOG", true);
                intent.setFlags(335544320);
                startActivity(intent);
                finish();
                break;
            case R.id.buddy_profile_popup_pen_btn /* 2131165353 */:
                BuddyFragment.f1734m = true;
                Intent intent2 = new Intent(getApplicationContext(), (Class<?>) BuddyEditNickNameActivity.class);
                intent2.putExtra("PROFILE_ID", this.f2666d);
                intent2.putExtra("PROFILE_NAME", this.f2667e);
                intent2.putExtra("PROFILE_BUDDY_MODE", true);
                startActivity(intent2);
                finish();
                break;
            case R.id.buddy_profile_popup_image /* 2131165358 */:
            case R.id.buddy_profile_more_icon /* 2131165367 */:
                Intent intent3 = new Intent(getApplicationContext(), (Class<?>) BuddyProfileImageView.class);
                intent3.putExtra("PROFILE_BUDDY_NO", this.f2666d);
                intent3.putExtra("PROFILE_BUDDY_IMAGE_ID", this.f2616O.m4342b());
                intent3.putExtra("PROFILE_BUDDY_IMAGE_TYPE", "FULL");
                startActivity(intent3);
                finish();
                break;
            case R.id.buddy_profile_popup_image_1 /* 2131165361 */:
                String strM4342b = this.f2617P.m4342b();
                C3250y.m11458g("profileImageId : " + strM4342b, f2599a);
                Intent intent4 = new Intent(getApplicationContext(), (Class<?>) BuddyProfileImageView.class);
                intent4.putExtra("PROFILE_BUDDY_NO", this.f2666d);
                intent4.putExtra("PROFILE_BUDDY_IMAGE_ID", strM4342b);
                intent4.putExtra("PROFILE_BUDDY_IMAGE_TYPE", "THUMB");
                startActivity(intent4);
                finish();
                break;
            case R.id.buddy_profile_popup_image_2 /* 2131165363 */:
                String strM4342b2 = this.f2618Q.m4342b();
                C3250y.m11458g("profileImageId : " + strM4342b2, f2599a);
                Intent intent5 = new Intent(getApplicationContext(), (Class<?>) BuddyProfileImageView.class);
                intent5.putExtra("PROFILE_BUDDY_NO", this.f2666d);
                intent5.putExtra("PROFILE_BUDDY_IMAGE_ID", strM4342b2);
                intent5.putExtra("PROFILE_BUDDY_IMAGE_TYPE", "THUMB");
                startActivity(intent5);
                finish();
                break;
            case R.id.buddy_profile_popup_image_3 /* 2131165365 */:
                String strM4342b3 = this.f2619R.m4342b();
                C3250y.m11458g("profileImageId : " + strM4342b3, f2599a);
                Intent intent6 = new Intent(getApplicationContext(), (Class<?>) BuddyProfileImageView.class);
                intent6.putExtra("PROFILE_BUDDY_NO", this.f2666d);
                intent6.putExtra("PROFILE_BUDDY_IMAGE_ID", strM4342b3);
                intent6.putExtra("PROFILE_BUDDY_IMAGE_TYPE", "THUMB");
                startActivity(intent6);
                finish();
                break;
            case R.id.buddy_profile_popup_chat /* 2131165368 */:
            case R.id.buddy_profile_popup_solo_chat /* 2131165373 */:
                BuddyFragment.f1734m = true;
                Intent intent7 = new Intent(getApplicationContext(), (Class<?>) ChatActivity.class);
                intent7.setFlags(67108864);
                intent7.putExtra("chatType", EnumC1450r.ONETOONE.m6342a());
                intent7.putExtra("receivers", new String[]{this.f2666d});
                intent7.putExtra("showPhoneNumber", this.f2679q.m3966C());
                intent7.putExtra("extraInfo", this.f2679q.m3967D());
                intent7.putExtra("msisdns", this.f2679q.m3980g());
                intent7.putExtra("is_buddy", true);
                intent7.putExtra(ChatFragment.f3494k, true);
                startActivity(intent7);
                finish();
                break;
            case R.id.buddy_profile_popup_call /* 2131165369 */:
                BuddyFragment.f1734m = true;
                if (!this.f2651al) {
                    if (this.f2679q.m3979f() != null && this.f2679q.m3979f().length() > 0) {
                        uriM4196b2 = Uri.parse("tel:" + this.f2679q.m3979f());
                        C3250y.m11450b("no multi [1] Call Number: " + uriM4196b2.toString(), f2599a);
                    } else if (this.f2668f != null) {
                        uriM4196b2 = m4196b(this.f2668f);
                        if (uriM4196b2 == null) {
                            uriM4196b2 = Uri.parse("tel:" + this.f2668f);
                        }
                        C3250y.m11450b("no multi [2] Call Number: " + uriM4196b2.toString(), f2599a);
                    } else {
                        uriM4196b2 = Uri.parse("tel:+" + this.f2666d);
                        C3250y.m11450b("no multi [3] Call Number: " + uriM4196b2.toString(), f2599a);
                    }
                    C3250y.m11450b("Call Number: " + uriM4196b2.toString(), f2599a);
                    Intent intent8 = new Intent("android.intent.action.CALL", uriM4196b2);
                    C3241p.m11403b(true);
                    finish();
                    try {
                        startActivity(intent8);
                        break;
                    } catch (ActivityNotFoundException e) {
                        C3250y.m11443a(e, getClass().getSimpleName());
                        return;
                    }
                } else {
                    List<String> listM4170n = m4170n();
                    if (listM4170n.size() == 1) {
                        if (this.f2668f != null) {
                            uriM4196b = m4196b(this.f2668f);
                            if (uriM4196b == null) {
                                uriM4196b = Uri.parse("tel:" + this.f2668f);
                            }
                            C3250y.m11450b("[r2d209] multi [1] Call Number: " + uriM4196b.toString(), f2599a);
                        } else {
                            uriM4196b = Uri.parse("tel:+" + listM4170n.get(0));
                            C3250y.m11450b("[r2d209] multi [2] Call Number: " + uriM4196b.toString(), f2599a);
                        }
                        C3250y.m11450b("Call Number: " + uriM4196b.toString(), f2599a);
                        Intent intent9 = new Intent("android.intent.action.CALL", uriM4196b);
                        C3241p.m11403b(true);
                        finish();
                        try {
                            startActivity(intent9);
                            break;
                        } catch (ActivityNotFoundException e2) {
                            C3250y.m11443a(e2, getClass().getSimpleName());
                            return;
                        }
                    } else if (listM4170n.size() > 1) {
                        Intent intent10 = new Intent(getApplicationContext(), (Class<?>) PhoneNumberSelectorDialog.class);
                        intent10.putExtra("PN_DIALOG_BUDDY_TYPE", 1);
                        intent10.putExtra("PN_DIALOG_BUDDY_MSISDNS", this.f2679q.m3980g());
                        startActivity(intent10);
                        C3241p.m11403b(true);
                        finish();
                        break;
                    }
                }
                break;
            case R.id.buddy_profile_popup_voice_call /* 2131165370 */:
                BuddyFragment.f1734m = true;
                if (!m4157h()) {
                    startActivity(new Intent(getApplicationContext(), (Class<?>) ChatONVRedirectDialog.class));
                } else if (m4152g() && m4160i() && m4143e()) {
                    try {
                        if (m4164k()) {
                            C3250y.m11450b("ChatON V call id : " + this.f2679q.m3981h(), f2599a);
                            C3250y.m11450b("ChatON V call name : " + C3159aa.m10962a().m10979a("Push Name", ""), f2599a);
                            if (this.f2637aJ.m47a(this, false, this.f2666d, C3159aa.m10962a().m10979a("Push Name", ""), null) != 0) {
                                C3641ai.m13210a(getApplicationContext(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                            }
                        }
                    } catch (Exception e3) {
                        C3250y.m11443a(e3, getClass().getSimpleName());
                    }
                } else {
                    startActivity(new Intent(getApplicationContext(), (Class<?>) ChatONVInstallDialog.class));
                }
                finish();
                break;
            case R.id.buddy_profile_popup_video_call /* 2131165371 */:
                BuddyFragment.f1734m = true;
                if (!m4157h()) {
                    startActivity(new Intent(getApplicationContext(), (Class<?>) ChatONVRedirectDialog.class));
                } else if (m4152g() && m4160i() && m4143e()) {
                    try {
                        if (m4164k()) {
                            C3250y.m11450b("ChatON V call id : " + this.f2679q.m3981h(), f2599a);
                            C3250y.m11450b("ChatON V call name : " + C3159aa.m10962a().m10979a("Push Name", ""), f2599a);
                            if (this.f2637aJ.m47a(this, true, this.f2666d, C3159aa.m10962a().m10979a("Push Name", ""), null) != 0) {
                                C3641ai.m13210a(getApplicationContext(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                            }
                        }
                    } catch (Exception e4) {
                        C3250y.m11443a(e4, getClass().getSimpleName());
                    }
                } else {
                    startActivity(new Intent(getApplicationContext(), (Class<?>) ChatONVInstallDialog.class));
                }
                finish();
                break;
            case R.id.buddy_profile_popup_contact /* 2131165372 */:
                BuddyFragment.f1734m = true;
                Uri uri = ContactsContract.Contacts.CONTENT_URI;
                C3250y.m11450b("RAWCONTACTID: " + this.f2679q.m3984k() + ", mContactId: " + this.f2652am, f2599a);
                C3241p.m11403b(true);
                if (!this.f2651al) {
                    if (this.f2650ak) {
                        m4142e(this.f2679q.m3979f());
                        break;
                    } else if (this.f2666d.startsWith("+")) {
                        m4142e(this.f2666d);
                        break;
                    } else {
                        m4142e("+" + this.f2666d);
                        break;
                    }
                } else {
                    List<String> listM4170n2 = m4170n();
                    if (listM4170n2.size() == 1) {
                        if (listM4170n2.get(0).startsWith("+")) {
                            m4142e(listM4170n2.get(0));
                            break;
                        } else {
                            m4142e("+" + listM4170n2.get(0));
                            break;
                        }
                    } else if (listM4170n2.size() > 1) {
                        Intent intent11 = new Intent(getApplicationContext(), (Class<?>) PhoneNumberSelectorDialog.class);
                        intent11.putExtra("PN_DIALOG_BUDDY_TYPE", 2);
                        intent11.putExtra("PN_DIALOG_BUDDY_NAME", this.f2679q.m3976c());
                        intent11.putExtra("PN_DIALOG_BUDDY_MSISDNS", this.f2679q.m3980g());
                        if (this.f2679q.m3978e() != null) {
                            intent11.putExtra("PN_DIALOG_BUDDY_SAMSUNGEMAIL", this.f2679q.m3978e());
                        }
                        startActivity(intent11);
                        finish();
                        break;
                    }
                }
                break;
            case R.id.buddy_cprofile_popup_button_cancel /* 2131165382 */:
                finish();
                break;
            case R.id.buddy_cprofile_popup_button_ok /* 2131165383 */:
                if (this.f2663ax) {
                    ContentResolver contentResolver = getApplicationContext().getContentResolver();
                    ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                    arrayList.add(C1206cg.m5544a(this.f2666d));
                    try {
                        contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
                    } catch (OperationApplicationException e5) {
                        e5.printStackTrace();
                    } catch (RemoteException e6) {
                        e6.printStackTrace();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                finish();
                break;
            case R.id.buddy_cprofile_popup_button_retry /* 2131165384 */:
            case R.id.buddy_cprofile_popup_add /* 2131165386 */:
                m4176q();
                break;
            case R.id.buddy_cprofile_popup_alarm /* 2131165387 */:
                Intent intent12 = new Intent(getApplicationContext(), (Class<?>) SpamConfirmDialog.class);
                if (TextUtils.isEmpty(this.f2667e)) {
                    intent12.putExtra("SCD_DIALOG_BUDDY_NAME", getString(R.string.unknown));
                } else {
                    intent12.putExtra("SCD_DIALOG_BUDDY_NAME", this.f2667e);
                }
                intent12.putExtra("SCD_DIALOG_BUDDY_NO", this.f2666d);
                startActivity(intent12);
                finish();
                break;
            case R.id.buddy_cprofile_popup_block /* 2131165388 */:
                m4178r();
                break;
            case R.id.buddy_cprofile_popup_ignore /* 2131165389 */:
                AbstractC3271a.m11494a(this).mo11500a(getResources().getString(R.string.buddy_suggestion_ignore)).mo11509b(getResources().getString(R.string.suggestion_ignore_popup_message, this.f2667e)).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0606a(this)).mo11501a(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                break;
            case R.id.buddy_cprofile_popup_unblock /* 2131165390 */:
                m4180s();
                break;
        }
    }

    /* renamed from: e */
    private void m4142e(String str) throws Throwable {
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        m4198c(str);
        if (!this.f2649aj) {
            Bundle bundle = new Bundle();
            bundle.putString("phone", str);
            bundle.putString("name", this.f2679q.m3976c());
            C3250y.m11450b("phoneNum: " + str, f2599a);
            C3250y.m11450b("NAME: " + this.f2679q.m3976c(), f2599a);
            if (this.f2679q.m3978e() != null) {
                bundle.putString("email", this.f2679q.m3978e());
            }
            Intent intent = new Intent("android.intent.action.INSERT", uri);
            intent.putExtras(bundle);
            intent.putExtra("return-data", true);
            finish();
            try {
                startActivity(intent);
                return;
            } catch (ActivityNotFoundException e) {
                C3250y.m11443a(e, getClass().getSimpleName());
                C3641ai.m13210a(getApplicationContext(), R.string.toast_contact_not_found, 0).show();
                return;
            }
        }
        long jM3035a = (this.f2651al || this.f2650ak) ? 0L : C0423i.m3035a(this.f2679q.m3984k());
        if (jM3035a == 0) {
            jM3035a = this.f2652am;
        }
        C3250y.m11450b("id: " + jM3035a, f2599a);
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse(uri + "/" + jM3035a));
        finish();
        try {
            startActivity(intent2);
        } catch (ActivityNotFoundException e2) {
            C3250y.m11443a(e2, getClass().getSimpleName());
            C3641ai.m13210a(getApplicationContext(), R.string.toast_contact_not_found, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public List<String> m4170n() {
        ArrayList arrayList = new ArrayList();
        String strM3980g = this.f2679q.m3980g();
        if (!TextUtils.isEmpty(strM3980g)) {
            StringTokenizer stringTokenizer = new StringTokenizer(strM3980g, "|");
            while (stringTokenizer.hasMoreTokens()) {
                new String();
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.length() >= 19 && strNextToken.startsWith("10")) {
                    C3250y.m11450b("chaton id : " + strNextToken, f2599a);
                } else if (strNextToken.startsWith("0")) {
                    C3250y.m11450b("pin number : " + strNextToken, f2599a);
                } else {
                    C3250y.m11450b("msisdn: " + strNextToken, f2599a);
                    arrayList.add(strNextToken);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void m4192a() {
        if (this.f2616O.m4343c()) {
            this.f2616O.m4339a().setOnClickListener(this);
        } else {
            this.f2616O.m4339a().setFocusable(false);
        }
        if (this.f2617P.m4343c()) {
            this.f2617P.m4339a().setOnClickListener(this);
        } else {
            this.f2617P.m4339a().setFocusable(false);
        }
        if (this.f2618Q.m4343c()) {
            this.f2618Q.m4339a().setOnClickListener(this);
        } else {
            this.f2618Q.m4339a().setFocusable(false);
        }
        if (this.f2619R.m4343c()) {
            this.f2619R.m4339a().setOnClickListener(this);
        } else {
            this.f2619R.m4339a().setFocusable(false);
        }
        if (this.f2612K != null) {
            this.f2612K.setOnClickListener(this);
        }
    }

    /* renamed from: b */
    public void m4197b() {
        C3231f.m11361a(getApplicationContext()).m11385b(this.f2616O, this.f2617P, this.f2618Q, this.f2619R, this.f2666d);
        m4192a();
    }

    /* renamed from: a */
    public void m4193a(int i) {
        C3231f.m11361a(getApplicationContext()).m11380a(this.f2617P, this.f2618Q, this.f2619R, this.f2666d, i - 1);
    }

    @Override // com.sec.common.p069e.InterfaceC3329f
    /* renamed from: a */
    public void mo3713a(View view, AbstractRunnableC3324a<?> abstractRunnableC3324a) {
        if (this.f2640aa) {
            if (view == this.f2604C) {
                this.f2616O.m4341a(false);
                this.f2616O.m4339a().setFocusable(false);
            } else if (view == this.f2617P.m4339a()) {
                this.f2617P.m4341a(false);
                this.f2617P.m4339a().setFocusable(false);
            } else if (view == this.f2618Q.m4339a()) {
                this.f2618Q.m4341a(false);
                this.f2618Q.m4339a().setFocusable(false);
            } else if (view == this.f2619R.m4339a()) {
                this.f2619R.m4341a(false);
                this.f2619R.m4339a().setFocusable(false);
            }
            this.f2676n--;
            if (this.f2676n == 0) {
                m4192a();
                this.f2635aH = true;
            }
        }
    }

    @Override // com.sec.common.p069e.InterfaceC3329f
    /* renamed from: b */
    public void mo3722b(View view, AbstractRunnableC3324a<?> abstractRunnableC3324a) {
        if (this.f2640aa) {
            if (view == this.f2604C) {
                this.f2616O.m4341a(true);
                this.f2616O.m4339a().setFocusable(true);
            } else if (view == this.f2617P.m4339a()) {
                this.f2617P.m4341a(true);
                this.f2617P.m4339a().setFocusable(true);
            } else if (view == this.f2618Q.m4339a()) {
                this.f2618Q.m4341a(true);
                this.f2618Q.m4339a().setFocusable(true);
            } else if (view == this.f2619R.m4339a()) {
                this.f2619R.m4341a(true);
                this.f2619R.m4339a().setFocusable(true);
            }
            this.f2676n--;
            if (this.f2676n == 0) {
                m4192a();
                this.f2635aH = true;
                return;
            }
            return;
        }
        this.f2657ar.setVisibility(0);
    }

    /* renamed from: c */
    public boolean m4199c() {
        C3250y.m11450b("Buddy didn't set Coverstory ", getClass().getSimpleName());
        String strM6090a = C1365i.m6090a();
        if (strM6090a != null) {
            if (!m4195a(strM6090a, this.f2666d)) {
                this.f2686x = strM6090a;
                this.f2678p.m5760a(strM6090a, Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
            }
            return true;
        }
        C3250y.m11450b(" Random ERROR !!", getClass().getSimpleName());
        this.f2678p.m5763b(Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public boolean m4172o() {
        if (this.f2666d.length() < 19 || !this.f2666d.startsWith("10") || TextUtils.isEmpty(this.f2679q.m3979f())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m4174p() {
        this.f2664ay.setVisibility(0);
        this.f2660au.setVisibility(0);
        this.f2659at.setVisibility(8);
        this.f2629aB.setVisibility(8);
        this.f2628aA.setVisibility(8);
        this.f2665az.setVisibility(8);
        this.f2631aD.setVisibility(8);
        this.f2661av.setVisibility(8);
        this.f2662aw.setVisibility(8);
        this.f2630aC.setVisibility(8);
        this.f2658as.setText(getResources().getString(R.string.trunk_network_not_available));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public boolean m4149f(String str) {
        return new File(this.f2673k).exists() && new File(this.f2673k, new StringBuilder().append(str).append(".png").toString()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m4151g(String str) {
        Bitmap bitmapM10999a;
        File file = new File(this.f2673k, str + ".png");
        if (file.exists()) {
            try {
                if (file.length() > 0 && (bitmapM10999a = C3162ad.m10999a(getApplicationContext(), Uri.fromFile(file), 66, 44)) != null) {
                    this.f2657ar.setVisibility(0);
                    this.f2657ar.setImageBitmap(bitmapM10999a);
                }
            } catch (Exception e) {
                C3250y.m11443a(e, f2599a);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public boolean m4194a(String str) throws IOException {
        boolean z = false;
        String strSubstring = null;
        File file = new File(this.f2685w);
        if (file.exists()) {
            String[] list = file.list();
            if (list != null) {
                if (0 < list.length) {
                    String str2 = list[0];
                    int iLastIndexOf = str2.lastIndexOf(".");
                    strSubstring = str2.substring(0, iLastIndexOf);
                    C3250y.m11450b("loadRandomimage filename : " + str2 + "### pos : " + iLastIndexOf + " ### randomId : " + strSubstring, f2599a);
                    z = true;
                }
                if (!TextUtils.isEmpty(strSubstring)) {
                    String str3 = this.f2685w + strSubstring + ".jpg";
                    C3250y.m11450b("loadRandomimage randomId : " + strSubstring + " ### randomFile : " + str3, f2599a);
                    if (this.f2682t != null) {
                        this.f2682t.setImageURI(Uri.parse(str3));
                        m4127b(strSubstring, str);
                    }
                }
            }
        } else if (C3250y.f11734b) {
            C3250y.m11450b("loadRandomimage No random images in file folder ", f2599a);
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m4122a(String str, String str2, String str3, ImageView imageView) throws IOException {
        boolean z = false;
        File file = new File(str2);
        if (file.exists()) {
            String[] list = file.list();
            if (list != null) {
                String str4 = list[(int) (Math.random() * list.length)];
                int iLastIndexOf = str4.lastIndexOf(".");
                String strSubstring = str4.substring(0, iLastIndexOf);
                C3250y.m11450b("loadRandomimage filename : " + str4 + "### pos : " + iLastIndexOf + " ### randomId : " + strSubstring, f2599a);
                z = true;
                if (!TextUtils.isEmpty(strSubstring)) {
                    String str5 = str2 + strSubstring + ".jpg";
                    C3250y.m11450b("loadRandomimage randomId : " + strSubstring + " ### randomFile : " + str5, f2599a);
                    if (imageView != null) {
                        imageView.setImageURI(Uri.parse(str5));
                        m4117a(strSubstring, str, str2, str3);
                    }
                }
            }
        } else if (C3250y.f11734b) {
            C3250y.m11450b("loadRandomimage No random images in file folder ", f2599a);
        }
        return z;
    }

    /* renamed from: a */
    public boolean m4195a(String str, String str2) throws IOException {
        boolean z = false;
        if (!new File(this.f2685w).exists()) {
            if (C3250y.f11734b) {
                C3250y.m11450b("checkAndSetCoverStoryRandomImages No random images in file folder ", f2599a);
            }
        } else {
            String str3 = this.f2685w + str + ".jpg";
            File file = new File(str3);
            if (file.exists()) {
                if (file.length() == 0) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("checkAndSetCoverStoryRandomImages file size is 0.", f2599a);
                    }
                    file.delete();
                } else {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("checkAndSetCoverStoryRandomImages get the random image in file folder #3#", f2599a);
                    }
                    z = true;
                    if (this.f2682t != null) {
                        this.f2682t.setImageURI(Uri.parse(str3));
                        m4127b(str, str2);
                    }
                    if (C3250y.f11734b) {
                        C3250y.m11450b("checkAndSetCoverStoryRandomImages set the random image from file folder #4#", f2599a);
                    }
                }
            } else if (C3250y.f11734b) {
                C3250y.m11450b("checkAndSetCoverStoryRandomImages not exists the random image in file folder #2#", f2599a);
            }
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m4123a(String str, String str2, String str3, String str4, ImageView imageView) throws IOException {
        boolean z = false;
        if (!new File(str3).exists()) {
            if (C3250y.f11734b) {
                C3250y.m11450b("checkAndSetCoverStoryRandomImages No random images in file folder ", f2599a);
            }
        } else {
            String str5 = str3 + str + ".jpg";
            File file = new File(str5);
            if (file.exists()) {
                if (file.length() == 0) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("checkAndSetCoverStoryRandomImages file size is 0.", f2599a);
                    }
                    file.delete();
                } else {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("checkAndSetCoverStoryRandomImages get the random image in file folder #3#", f2599a);
                    }
                    z = true;
                    if (imageView != null) {
                        imageView.setImageURI(Uri.parse(str5));
                        m4117a(str, str2, str3, str4 + str2 + "/coverstory/");
                    }
                    if (C3250y.f11734b) {
                        C3250y.m11450b("checkAndSetCoverStoryRandomImages set the random image from file folder #4#", f2599a);
                    }
                }
            } else if (C3250y.f11734b) {
                C3250y.m11450b("checkAndSetCoverStoryRandomImages not exists the random image in file folder #2#", f2599a);
            }
        }
        return z;
    }

    /* renamed from: a */
    public static void m4116a(String str, String str2, String str3) throws IOException {
        try {
            if (str3 != null) {
                if (C3250y.f11734b) {
                    C3250y.m11450b(" static copyCoverStoryforRandomImages mOriginPath : " + str2, f2599a);
                    C3250y.m11450b(" static copyCoverStoryforRandomImages mDestPath : " + str3 + str + ".jpg", f2599a);
                }
                new File(str3).mkdirs();
                File file = new File(str2);
                File file2 = new File(str3 + str + ".jpg");
                if (file2.exists() && file2.length() != 0) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b(" static copyCoverStoryforRandomImages already exist...", f2599a);
                        return;
                    }
                    return;
                } else {
                    if (file.length() > 0) {
                        new FileOutputStream(file2).close();
                        if (C3250y.f11734b) {
                            C3250y.m11450b(" static copyCoverStoryforRandomImages copy to : " + file2.getPath(), f2599a);
                        }
                        C3020a.m10525a(file, file2);
                        return;
                    }
                    return;
                }
            }
            if (C3250y.f11734b) {
                C3250y.m11450b(" static copyCoverStoryforRandomImages dirInternalPathS is null : ", f2599a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m4127b(String str, String str2) throws IOException {
        String str3 = getApplicationContext().getCacheDir() + "/" + str2 + "/coverstory/";
        if (C3250y.f11734b) {
            C3250y.m11450b("dirInternalPath : " + this.f2685w + str + ".jpg", "copyCoverStoryforBuddyProfile");
            C3250y.m11450b("mBuddyCoverStoryDir : " + str3, "copyCoverStoryforBuddyProfile");
        }
        new File(str3).mkdirs();
        File file = new File(str3 + "coverstory.jpg");
        File file2 = new File(this.f2685w + str + ".jpg");
        if (file2.length() > 0) {
            try {
                new FileOutputStream(file).close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            C3020a.m10525a(file2, file);
        }
    }

    /* renamed from: a */
    private static void m4117a(String str, String str2, String str3, String str4) throws IOException {
        if (C3250y.f11734b) {
            C3250y.m11450b("randomDir : " + str3 + str + ".jpg", "copyCoverStoryforBuddyProfile");
            C3250y.m11450b("mBuddyPath : " + str4, "copyCoverStoryforBuddyProfile");
        }
        new File(str4).mkdirs();
        File file = new File(str4 + "coverstory.jpg");
        File file2 = new File(str3 + str + ".jpg");
        if (file2.length() > 0) {
            try {
                new FileOutputStream(file).close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            C3020a.m10525a(file2, file);
        }
    }

    /* renamed from: q */
    private void m4176q() {
        m4184u();
        new C1330h(this.f2671i).m5730b(this.f2666d);
    }

    /* renamed from: r */
    private void m4178r() {
        m4184u();
        new C1328f(this.f2671i).m5706a(this.f2666d, 1);
    }

    /* renamed from: s */
    private void m4180s() {
        m4184u();
        new C1328f(this.f2671i).m5705a(this.f2666d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m4182t() {
        ArrayList<String> arrayList = new ArrayList<>();
        m4184u();
        C1336n c1336n = new C1336n(this.f2671i);
        arrayList.add(this.f2666d);
        c1336n.m5791a("true", arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m4156h(String str) {
        new C1330h(this.f2671i).m5756h(str);
    }

    /* renamed from: u */
    private void m4184u() {
        this.f2632aE.setVisibility(0);
        this.f2664ay.setVisibility(8);
        this.f2659at.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m4186v() {
        this.f2632aE.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m4188w();
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C3250y.m11450b("onUserLeaveHint", getClass().getSimpleName());
        C3241p.m11402b(getApplicationContext());
    }

    /* renamed from: w */
    private void m4188w() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        if (C3241p.m11407c(getApplicationContext())) {
            Intent intent = new Intent(getApplicationContext(), (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    /* renamed from: i */
    private String m4159i(String str) {
        return str.replaceAll("\\D+", "");
    }

    /* renamed from: c */
    private boolean m4134c(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        C3250y.m11450b("[isMatchNumber] matching for original Number : " + ((String) null), f2599a);
        if (length > 8 && length2 > 8) {
            String strSubstring = str.substring(length - 8);
            String strSubstring2 = str2.substring(length2 - 8);
            C3250y.m11450b("[isMatchNumber] matching for contact Number : " + strSubstring2, f2599a);
            if (strSubstring.equals(strSubstring2)) {
                C3250y.m11450b("[isMatchNumber] found match number : " + str2, f2599a);
                return true;
            }
            C3250y.m11450b("[isMatchNumber] phone number not matched", f2599a);
            return false;
        }
        C3250y.m11450b("[isMatchNumber] phone number length is less than 8", f2599a);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00df, code lost:
    
        r7 = android.net.Uri.parse("tel:" + r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.net.Uri m4196b(java.lang.String r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.dialog.BuddyDialog.m4196b(java.lang.String):android.net.Uri");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008d A[PHI: r1
  0x008d: PHI (r1v6 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v10 android.database.Cursor) binds: [B:23:0x00c2, B:12:0x008b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m4198c(java.lang.String r9) throws java.lang.Throwable {
        /*
            r8 = this;
            r7 = 0
            r6 = 0
            r8.f2649aj = r7
            java.lang.String r0 = "[contactSavedCheck] Contact Saved Find Start"
            java.lang.String r1 = com.sec.chaton.buddy.dialog.BuddyDialog.f2599a     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            com.sec.chaton.util.C3250y.m11450b(r0, r1)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            android.net.Uri r0 = android.provider.ContactsContract.PhoneLookup.CONTENT_FILTER_URI     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            java.lang.String r1 = android.net.Uri.encode(r9)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            android.net.Uri r1 = android.net.Uri.withAppendedPath(r0, r1)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            android.content.Context r0 = r8.getApplicationContext()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            r3 = 0
            java.lang.String r4 = "display_name"
            r2[r3] = r4     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            r3 = 1
            java.lang.String r4 = "number"
            r2[r3] = r4     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            r3 = 2
            java.lang.String r4 = "_id"
            r2[r3] = r4     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> Laf java.lang.Throwable -> Lc5
            if (r1 == 0) goto L85
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            if (r0 <= 0) goto L85
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            if (r0 == 0) goto L85
            r0 = 1
            r8.f2649aj = r0     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.String r0 = "_id"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            r8.f2652am = r0     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            r0.<init>()     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.String r2 = "[contactSavedCheck] Found in Contact Number : "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.StringBuilder r0 = r0.append(r9)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.String r2 = com.sec.chaton.buddy.dialog.BuddyDialog.f2599a     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            com.sec.chaton.util.C3250y.m11450b(r0, r2)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            r0.<init>()     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.String r2 = "[contactSavedCheck] ContactSaved id : "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            int r2 = r8.f2652am     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            java.lang.String r2 = com.sec.chaton.buddy.dialog.BuddyDialog.f2599a     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
            com.sec.chaton.util.C3250y.m11450b(r0, r2)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld5
        L85:
            if (r1 == 0) goto L90
            boolean r0 = r1.isClosed()
            if (r0 != 0) goto L90
        L8d:
            r1.close()
        L90:
            boolean r0 = r8.f2649aj
            if (r0 != 0) goto Lae
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "[contactSavedCheck] No PhoneNumber in Contact : "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = com.sec.chaton.buddy.dialog.BuddyDialog.f2599a
            com.sec.chaton.util.C3250y.m11450b(r0, r1)
            r8.f2652am = r7
        Lae:
            return
        Laf:
            r0 = move-exception
            r1 = r6
        Lb1:
            java.lang.Class r2 = r8.getClass()     // Catch: java.lang.Throwable -> Ld3
            java.lang.String r2 = r2.getSimpleName()     // Catch: java.lang.Throwable -> Ld3
            com.sec.chaton.util.C3250y.m11443a(r0, r2)     // Catch: java.lang.Throwable -> Ld3
            if (r1 == 0) goto L90
            boolean r0 = r1.isClosed()
            if (r0 != 0) goto L90
            goto L8d
        Lc5:
            r0 = move-exception
            r1 = r6
        Lc7:
            if (r1 == 0) goto Ld2
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto Ld2
            r1.close()
        Ld2:
            throw r0
        Ld3:
            r0 = move-exception
            goto Lc7
        Ld5:
            r0 = move-exception
            goto Lb1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.dialog.BuddyDialog.m4198c(java.lang.String):void");
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        C3250y.m11453c("[LIFE] onStart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C3250y.m11453c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.f2638aK != null) {
            this.f2638aK.removeCallbacksAndMessages(null);
            this.f2638aK = null;
            if (C3250y.f11734b) {
                C3250y.m11450b("[BuddyDialog] mHandler is null ", f2599a);
            }
        }
        if (this.f2678p != null) {
            this.f2678p.m5764c();
            this.f2678p.m5766e();
            this.f2678p = null;
        }
        if (this.f2682t != null) {
            this.f2682t.setImageBitmap(null);
            this.f2682t = null;
        }
        if (this.f2642ac != null) {
            this.f2642ac.m11735a((InterfaceC3329f) null);
            this.f2642ac.m11731a();
        }
        if (this.f2677o != null) {
            this.f2677o.m5941f();
            this.f2677o.m5932b();
            this.f2677o = null;
        }
        if (this.f2604C != null) {
            this.f2604C.setImageBitmap(null);
            this.f2604C = null;
        }
        if (this.f2605D != null) {
            this.f2605D.setImageBitmap(null);
            this.f2605D = null;
        }
        if (this.f2606E != null) {
            this.f2606E.setImageBitmap(null);
            this.f2606E = null;
        }
        if (this.f2607F != null) {
            this.f2607F.setImageBitmap(null);
            this.f2607F = null;
        }
        if (this.f2612K != null) {
            this.f2612K.setImageBitmap(null);
            this.f2612K = null;
            if (C3250y.f11734b) {
                C3250y.m11450b("[BuddyDialog] moreImgs is null ", f2599a);
            }
        }
        if (this.f2655ap != null) {
            this.f2655ap.setImageBitmap(null);
            this.f2655ap = null;
        }
        super.onDestroy();
    }
}
