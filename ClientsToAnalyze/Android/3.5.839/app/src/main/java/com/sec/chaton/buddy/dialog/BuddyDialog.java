package com.sec.chaton.buddy.dialog;

import android.annotation.TargetApi;
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
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.R;
import com.sec.chaton.account.C1002i;
import com.sec.chaton.account.C1004k;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.buddy.BuddyEditNickNameActivity;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.BuddyProfileImageView;
import com.sec.chaton.buddy.C1331gk;
import com.sec.chaton.buddy.C1337gq;
import com.sec.chaton.buddy.CallableC1330gj;
import com.sec.chaton.buddy.InterfaceC1336gp;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2075ah;
import com.sec.chaton.p055d.C2126g;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p055d.C2130k;
import com.sec.chaton.p055d.C2135p;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.p057e.C2293m;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2181ag;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p057e.p058a.C2191e;
import com.sec.chaton.p057e.p058a.C2192f;
import com.sec.chaton.p057e.p058a.C2195i;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.chaton.p065io.entry.inner.ProfileImage;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.passwordlock.PasswordLockActivity;
import com.sec.chaton.plugin.C2923b;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.poston.C2955a;
import com.sec.chaton.privateplugin.data.SetSpamReq;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.privateplugin.p088a.C3033b;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p102b.C3789h;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.chaton.trunk.p121c.C4636a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4855bt;
import com.sec.chaton.util.C4865cc;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4883f;
import com.sec.chaton.util.C4884g;
import com.sec.chaton.util.C4892m;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4868cf;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.common.p132g.C5007c;
import com.sec.common.p132g.InterfaceC5010f;
import com.sec.widget.C5179v;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class BuddyDialog extends PasswordLockActivity implements View.OnClickListener, InterfaceC5010f {

    /* renamed from: a */
    public static final String f4430a = BuddyDialog.class.getSimpleName();

    /* renamed from: b */
    public static String f4431b;

    /* renamed from: c */
    public static String f4432c;

    /* renamed from: A */
    private ImageView f4433A;

    /* renamed from: B */
    private LinearLayout f4434B;

    /* renamed from: C */
    private TextView f4435C;

    /* renamed from: D */
    private TextView f4436D;

    /* renamed from: E */
    private TextView f4437E;

    /* renamed from: F */
    private TextView f4438F;

    /* renamed from: G */
    private TextView f4439G;

    /* renamed from: H */
    private TextView f4440H;

    /* renamed from: I */
    private ImageView f4441I;

    /* renamed from: J */
    private ImageView f4442J;

    /* renamed from: K */
    private ImageView f4443K;

    /* renamed from: L */
    private ImageView f4444L;

    /* renamed from: M */
    private ImageView f4445M;

    /* renamed from: N */
    private ImageView f4446N;

    /* renamed from: O */
    private ImageView f4447O;

    /* renamed from: P */
    private ImageView f4448P;

    /* renamed from: Q */
    private ImageButton f4449Q;

    /* renamed from: R */
    private ImageView f4450R;

    /* renamed from: S */
    private ImageView f4451S;

    /* renamed from: T */
    private C1337gq f4452T;

    /* renamed from: U */
    private C1337gq f4453U;

    /* renamed from: V */
    private C1337gq f4454V;

    /* renamed from: W */
    private C1337gq f4455W;

    /* renamed from: X */
    private LinearLayout f4456X;

    /* renamed from: Y */
    private LinearLayout f4457Y;

    /* renamed from: Z */
    private LinearLayout f4458Z;

    /* renamed from: aA */
    private Button f4459aA;

    /* renamed from: aE */
    private View f4463aE;

    /* renamed from: aF */
    private ViewGroup f4464aF;

    /* renamed from: aG */
    private LinearLayout f4465aG;

    /* renamed from: aH */
    private LinearLayout f4466aH;

    /* renamed from: aI */
    private LinearLayout f4467aI;

    /* renamed from: aJ */
    private LinearLayout f4468aJ;

    /* renamed from: aK */
    private LinearLayout f4469aK;

    /* renamed from: aL */
    private ViewGroup f4470aL;

    /* renamed from: aM */
    private LinearLayout f4471aM;

    /* renamed from: aN */
    private LinearLayout f4472aN;

    /* renamed from: aO */
    private LinearLayout f4473aO;

    /* renamed from: aP */
    private LinearLayout f4474aP;

    /* renamed from: aU */
    private C0416a f4479aU;

    /* renamed from: aV */
    private String f4480aV;

    /* renamed from: aa */
    private LinearLayout f4483aa;

    /* renamed from: ab */
    private LinearLayout f4484ab;

    /* renamed from: ac */
    private LinearLayout f4485ac;

    /* renamed from: ad */
    private LinearLayout f4486ad;

    /* renamed from: ae */
    private LinearLayout f4487ae;

    /* renamed from: ai */
    private C5007c f4491ai;

    /* renamed from: am */
    private Toast f4495am;

    /* renamed from: an */
    private boolean f4496an;

    /* renamed from: ap */
    private boolean f4498ap;

    /* renamed from: aq */
    private int f4499aq;

    /* renamed from: ar */
    private C2210x f4500ar;

    /* renamed from: as */
    private TextView f4501as;

    /* renamed from: at */
    private ImageView f4502at;

    /* renamed from: au */
    private ImageView f4503au;

    /* renamed from: av */
    private ImageView f4504av;

    /* renamed from: aw */
    private TextView f4505aw;

    /* renamed from: ax */
    private ViewGroup f4506ax;

    /* renamed from: ay */
    private Button f4507ay;

    /* renamed from: az */
    private Button f4508az;

    /* renamed from: d */
    String f4509d;

    /* renamed from: e */
    String f4510e;

    /* renamed from: f */
    String f4511f;

    /* renamed from: g */
    ArrayList<ProfileImage> f4512g;

    /* renamed from: o */
    private String f4520o;

    /* renamed from: p */
    private int f4521p;

    /* renamed from: q */
    private C2075ah f4522q;

    /* renamed from: r */
    private C2130k f4523r;

    /* renamed from: s */
    private C1106c f4524s;

    /* renamed from: t */
    private TextView f4525t;

    /* renamed from: u */
    private LinearLayout f4526u;

    /* renamed from: v */
    private ImageView f4527v;

    /* renamed from: w */
    private String f4528w;

    /* renamed from: z */
    private Context f4531z;

    /* renamed from: n */
    private final String f4519n = C4873ck.m18502c() + "/flag/";

    /* renamed from: x */
    private String f4529x = null;

    /* renamed from: y */
    private String f4530y = null;

    /* renamed from: af */
    private boolean f4488af = false;

    /* renamed from: ag */
    private boolean f4489ag = true;

    /* renamed from: ah */
    private boolean f4490ah = false;

    /* renamed from: aj */
    private final String f4492aj = "?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&imei=" + C4809aa.m18104a().m18121a("imei", "");

    /* renamed from: ak */
    private final String f4493ak = "&size=800";

    /* renamed from: al */
    private final String f4494al = "&size=100";

    /* renamed from: ao */
    private boolean f4497ao = false;

    /* renamed from: aB */
    private boolean f4460aB = false;

    /* renamed from: aC */
    private boolean f4461aC = false;

    /* renamed from: aD */
    private boolean f4462aD = false;

    /* renamed from: aQ */
    private boolean f4475aQ = false;

    /* renamed from: aR */
    private boolean f4476aR = false;

    /* renamed from: aS */
    private int f4477aS = 0;

    /* renamed from: aT */
    private boolean f4478aT = false;

    /* renamed from: h */
    boolean f4513h = false;

    /* renamed from: i */
    InterfaceC1336gp f4514i = new C1224b(this);

    /* renamed from: aW */
    private Handler f4481aW = new HandlerC1225c(this);

    /* renamed from: j */
    InterfaceC2211y f4515j = new C1226d(this);

    /* renamed from: aX */
    private final Handler f4482aX = new HandlerC1227e(this);

    /* renamed from: k */
    Handler f4516k = new HandlerC1228f(this);

    /* renamed from: l */
    InterfaceC2243d f4517l = new C1229g(this);

    /* renamed from: m */
    public final Handler f4518m = new HandlerC1231i(this);

    /* renamed from: g */
    static /* synthetic */ int m7213g(BuddyDialog buddyDialog) {
        int i = buddyDialog.f4521p;
        buddyDialog.f4521p = i + 1;
        return i;
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    @TargetApi(11)
    protected void onCreate(Bundle bundle) throws UnsupportedEncodingException {
        C4904y.m18639b("onCreate()", f4430a);
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        this.f4531z = this;
        this.f4524s = null;
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.f4523r = new C2130k(this.f4481aW);
        this.f4500ar = new C2210x(getContentResolver(), this.f4515j);
        this.f4495am = C5179v.m19811a(this, (CharSequence) null, 0);
        this.f4509d = getIntent().getExtras().getString("BUDDY_DIALOG_BUDDY_NO");
        this.f4510e = getIntent().getExtras().getString("BUDDY_DIALOG_BUDDY_NAME");
        this.f4460aB = getIntent().getExtras().getBoolean("BUDDY_DIALOG_BUDDY_FROM_SUGGESTION");
        this.f4461aC = getIntent().getExtras().getBoolean("BUDDY_DIALOG_BUDDY_FROM_SUGGESTION_SEARCH");
        this.f4462aD = getIntent().getExtras().getBoolean("BUDDY_DIALOG_BUDDY_FROM_PROFILE");
        if (this.f4462aD && C4904y.f17872b) {
            C4904y.m18639b(" Buddy dialog is called from buddy profile fragment !!! ", f4430a);
            m7210f();
        }
        if (getIntent().hasExtra("BUDDY_DIALOG_CHATROOM_TYPE")) {
            this.f4480aV = getIntent().getExtras().getString("BUDDY_DIALOG_CHATROOM_TYPE");
        }
        this.f4500ar.startQuery(3, null, C2289i.m10166d(), null, "buddy_no = ? ", new String[]{this.f4509d}, null);
        this.f4529x = getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        this.f4491ai = new C5007c();
        this.f4522q = new C2075ah(this.f4481aW);
        f4431b = getApplicationContext().getCacheDir() + "/";
        f4432c = this.f4529x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7175a(boolean z) {
        setContentView(R.layout.buddy_profile_popup);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.buddy_profile_popup_layout);
        Context context = this.f4531z;
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams((((WindowManager) getSystemService("window")).getDefaultDisplay().getWidth() * getResources().getInteger(R.integer.buddy_popup_dialog_width_percent)) / 100, -2));
        this.f4479aU = new C0416a();
        this.f4475aQ = false;
        this.f4476aR = false;
        this.f4491ai.m19019a((InterfaceC5010f) this);
        this.f4525t = (TextView) findViewById(R.id.buddy_profile_popup_name);
        if (this.f4524s.m7051b() != null) {
            this.f4525t.setText(this.f4524s.m7051b());
            if (this.f4524s.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                this.f4525t.setSelected(true);
                this.f4525t.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            }
        }
        this.f4526u = (LinearLayout) findViewById(R.id.buddy_profile_popup_favorite_btn);
        this.f4434B = (LinearLayout) findViewById(R.id.buddy_profile_popup_pen_btn);
        this.f4456X = (LinearLayout) findViewById(R.id.buddy_profile_popup_view_profile);
        this.f4456X.setOnClickListener(this);
        if (!this.f4490ah) {
            this.f4526u.setOnClickListener(this);
            this.f4433A = (ImageView) findViewById(R.id.buddy_profile_popup_favorite);
            if (this.f4488af) {
                this.f4433A.setImageResource(R.drawable.actionbar_ic_favorite_01);
            } else {
                this.f4433A.setImageResource(R.drawable.actionbar_ic_favorite_02);
            }
            this.f4434B.setOnClickListener(this);
        } else {
            this.f4526u.setVisibility(8);
            this.f4434B.setVisibility(8);
            this.f4456X.setBackgroundResource(R.drawable.buddy_popup_right_selector);
        }
        this.f4527v = (ImageView) findViewById(R.id.buddy_profile_popup_coverimage);
        this.f4435C = (TextView) findViewById(R.id.buddy_profile_popup_status_message);
        if (this.f4524s.m7054c() != null && !TextUtils.isEmpty(this.f4524s.m7054c())) {
            if (this.f4524s.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                this.f4435C.setText(this.f4524s.m7054c().replaceAll(", ", "\n"));
            } else {
                this.f4435C.setText(this.f4524s.m7054c());
            }
        } else {
            this.f4435C.setVisibility(4);
        }
        this.f4436D = (TextView) findViewById(R.id.buddy_dialog_info_phonenumber1);
        this.f4437E = (TextView) findViewById(R.id.buddy_dialog_info_phonenumber2);
        this.f4438F = (TextView) findViewById(R.id.buddy_dialog_info_phonenumber3);
        this.f4439G = (TextView) findViewById(R.id.buddy_dialog_info_phonenumber4);
        this.f4440H = (TextView) findViewById(R.id.buddy_dialog_info_samsungaccount);
        if (this.f4524s.m7043F().compareTo(Spam.ACTIVITY_REPORT) != 0) {
            if (!TextUtils.isEmpty(this.f4524s.m7044G())) {
                List listAsList = Arrays.asList(this.f4524s.m7044G().split(" "));
                if (listAsList.size() == 4) {
                    this.f4436D.setText((CharSequence) listAsList.get(0));
                    this.f4437E.setText((CharSequence) listAsList.get(1));
                    this.f4438F.setText((CharSequence) listAsList.get(2));
                    this.f4439G.setText((CharSequence) listAsList.get(3));
                    this.f4436D.setVisibility(0);
                    this.f4437E.setVisibility(0);
                    this.f4438F.setVisibility(0);
                    this.f4439G.setVisibility(0);
                } else if (listAsList.size() == 3) {
                    this.f4436D.setText((CharSequence) listAsList.get(0));
                    this.f4437E.setText((CharSequence) listAsList.get(1));
                    this.f4438F.setText((CharSequence) listAsList.get(2));
                    this.f4436D.setVisibility(0);
                    this.f4437E.setVisibility(0);
                    this.f4438F.setVisibility(0);
                } else if (listAsList.size() == 2) {
                    this.f4436D.setText((CharSequence) listAsList.get(0));
                    this.f4437E.setText((CharSequence) listAsList.get(1));
                    this.f4436D.setVisibility(0);
                    this.f4437E.setVisibility(0);
                } else if (listAsList.size() == 1) {
                    this.f4436D.setText((CharSequence) listAsList.get(0));
                    this.f4436D.setVisibility(0);
                }
            }
            if (!TextUtils.isEmpty(this.f4524s.m7055d())) {
                this.f4440H.setText(this.f4524s.m7055d());
                this.f4440H.setVisibility(0);
            }
        }
        this.f4441I = (ImageView) findViewById(R.id.buddy_profile_popup_image);
        this.f4441I.setFocusable(false);
        this.f4441I.setClickable(false);
        this.f4445M = (ImageView) findViewById(R.id.buddy_profile_popup_image_loading);
        this.f4450R = (ImageView) findViewById(R.id.buddy_profile_popup_image_webonly);
        this.f4451S = (ImageView) findViewById(R.id.buddy_profile_popup_image_chatonv);
        this.f4442J = (ImageView) findViewById(R.id.buddy_profile_popup_image_1);
        this.f4442J.setFocusable(false);
        this.f4442J.setClickable(false);
        this.f4446N = (ImageView) findViewById(R.id.buddy_profile_popup_image_1_loading);
        this.f4443K = (ImageView) findViewById(R.id.buddy_profile_popup_image_2);
        this.f4443K.setFocusable(false);
        this.f4443K.setClickable(false);
        this.f4447O = (ImageView) findViewById(R.id.buddy_profile_popup_image_2_loading);
        this.f4444L = (ImageView) findViewById(R.id.buddy_profile_popup_image_3);
        this.f4444L.setFocusable(false);
        this.f4444L.setClickable(false);
        this.f4448P = (ImageView) findViewById(R.id.buddy_profile_popup_image_3_loading);
        this.f4449Q = (ImageButton) findViewById(R.id.buddy_profile_more_icon);
        this.f4452T = new C1337gq(this.f4441I);
        this.f4453U = new C1337gq(this.f4442J);
        this.f4454V = new C1337gq(this.f4443K);
        this.f4455W = new C1337gq(this.f4444L);
        if (this.f4524s.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
            this.f4450R.setVisibility(8);
            try {
                C2496n.m10784c(this.f4441I, this.f4524s.m7046a(), EnumC2498p.SQUARE);
                C1331gk.m7458a(this.f4527v);
                m7260a((String) null);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        } else {
            try {
                C1331gk.m7453a(getApplicationContext()).m7463a(this.f4452T, this.f4453U, this.f4454V, this.f4455W, this.f4527v, this.f4509d, this.f4514i);
                C4904y.m18639b("Is Web Only buddy : " + this.f4524s.m7041D(), f4430a);
                this.f4450R.setVisibility(this.f4524s.m7041D() == 1 ? 0 : 8);
                if (C2923b.m12153h(getApplicationContext()) && m7218h()) {
                    this.f4451S.setVisibility(0);
                } else {
                    this.f4451S.setVisibility(8);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            } catch (OutOfMemoryError e4) {
                e4.printStackTrace();
            }
        }
        this.f4434B.requestFocus();
        if (!z) {
            if (this.f4522q == null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("[BuddyDialog] mProfileControl is null ", f4430a);
                }
                this.f4522q = new C2075ah(this.f4481aW);
            }
            if (this.f4524s != null && this.f4524s.m7043F().compareTo(Spam.ACTIVITY_CANCEL) == 0) {
                this.f4522q.m9310b(this.f4509d, "5");
            }
        }
        this.f4457Y = (LinearLayout) findViewById(R.id.buddy_profile_popup_chat);
        this.f4457Y.setOnClickListener(this);
        this.f4458Z = (LinearLayout) findViewById(R.id.buddy_profile_popup_call);
        this.f4458Z.setOnClickListener(this);
        this.f4483aa = (LinearLayout) findViewById(R.id.buddy_profile_popup_contact);
        this.f4483aa.setOnClickListener(this);
        this.f4484ab = (LinearLayout) findViewById(R.id.buddy_profile_popup_voice_call);
        this.f4484ab.setOnClickListener(this);
        this.f4484ab.setVisibility(8);
        this.f4485ac = (LinearLayout) findViewById(R.id.buddy_profile_popup_video_call);
        this.f4485ac.setOnClickListener(this);
        this.f4485ac.setVisibility(8);
        this.f4486ad = (LinearLayout) findViewById(R.id.buddy_profile_popup_solo_chat);
        this.f4486ad.setOnClickListener(this);
        this.f4487ae = (LinearLayout) findViewById(R.id.buddy_profile_popup_sms);
        this.f4487ae.setOnClickListener(this);
        if (z && this.f4512g != null && this.f4477aS != 0) {
            if (Spam.ACTIVITY_REPORT.equals(this.f4512g.get(0).represent)) {
                if (this.f4477aS > 4 && this.f4449Q != null) {
                    this.f4449Q.setVisibility(0);
                    this.f4449Q.setOnClickListener(this);
                }
            } else if (this.f4477aS > 3 && this.f4449Q != null) {
                this.f4449Q.setVisibility(0);
                this.f4449Q.setOnClickListener(this);
            }
        }
        if (C2349a.m10301a("sms_feature")) {
            this.f4483aa.setVisibility(8);
        } else {
            this.f4487ae.setVisibility(8);
        }
        m7239q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m7210f() throws UnsupportedEncodingException {
        setContentView(R.layout.buddy_variation_profile_popup);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.buddy_variation_profile_popup_layout);
        Context context = this.f4531z;
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams((int) (((double) defaultDisplay.getWidth()) * 0.9d > ((double) defaultDisplay.getHeight()) * 0.9d ? defaultDisplay.getHeight() * 0.9d : defaultDisplay.getWidth() * 0.9d), -2));
        if (this.f4462aD && this.f4491ai == null) {
            this.f4491ai = new C5007c();
        }
        this.f4491ai.m19019a((InterfaceC5010f) this);
        this.f4501as = (TextView) findViewById(R.id.buddy_cprofile_popup_name);
        if (TextUtils.isEmpty(this.f4510e)) {
            if (this.f4462aD) {
                this.f4501as.setText(this.f4509d);
            } else {
                this.f4501as.setText(getString(R.string.unknown));
            }
        } else {
            this.f4501as.setText(this.f4510e);
        }
        this.f4502at = (ImageView) findViewById(R.id.buddy_cprofile_popup_image);
        C2496n.m10790e(getApplicationContext(), this.f4509d);
        C2496n.m10765a(this.f4502at, this.f4509d, EnumC2498p.SQUARE);
        this.f4503au = (ImageView) findViewById(R.id.buddy_cprofile_popup_unauthenticated_image);
        this.f4504av = (ImageView) findViewById(R.id.buddy_cprofile_popup_flag_image);
        this.f4474aP = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_loading_area);
        this.f4505aw = (TextView) findViewById(R.id.buddy_cprofile_popup_guidetext_view);
        this.f4506ax = (ViewGroup) findViewById(R.id.buddy_cprofile_popup_3_buttons);
        this.f4467aI = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_add);
        this.f4466aH = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_alarm);
        this.f4465aG = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_block);
        this.f4468aJ = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_unblock);
        this.f4469aK = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_ignore);
        this.f4467aI.setOnClickListener(this);
        this.f4466aH.setOnClickListener(this);
        this.f4465aG.setOnClickListener(this);
        this.f4468aJ.setOnClickListener(this);
        this.f4469aK.setOnClickListener(this);
        this.f4463aE = findViewById(R.id.buddy_variation_popup_divider);
        this.f4464aF = (ViewGroup) findViewById(R.id.buddy_cprofile_popup_buttons);
        this.f4507ay = (Button) findViewById(R.id.buddy_cprofile_popup_button_cancel);
        this.f4508az = (Button) findViewById(R.id.buddy_cprofile_popup_button_ok);
        this.f4459aA = (Button) findViewById(R.id.buddy_cprofile_popup_button_retry);
        this.f4507ay.setOnClickListener(this);
        this.f4508az.setOnClickListener(this);
        this.f4459aA.setOnClickListener(this);
        m7254y();
        new C2128i(this.f4482aX).m9522e(this.f4509d, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m7214g() {
        setContentView(R.layout.buddy_variation_profile_popup);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.buddy_variation_profile_popup_layout);
        Context context = this.f4531z;
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams((int) (((double) defaultDisplay.getWidth()) * 0.9d > ((double) defaultDisplay.getHeight()) * 0.9d ? defaultDisplay.getHeight() * 0.9d : defaultDisplay.getWidth() * 0.9d), -2));
        this.f4501as = (TextView) findViewById(R.id.buddy_cprofile_popup_name);
        if (TextUtils.isEmpty(this.f4510e)) {
            this.f4501as.setText(getString(R.string.unknown));
        } else {
            this.f4501as.setText(this.f4510e);
        }
        this.f4502at = (ImageView) findViewById(R.id.buddy_cprofile_popup_image);
        this.f4505aw = (TextView) findViewById(R.id.buddy_cprofile_popup_guidetext_view);
        this.f4505aw.setText(getResources().getString(R.string.privacy_dialog_not_identified_user, this.f4501as.getText().toString()));
        this.f4470aL = (ViewGroup) findViewById(R.id.buddy_cprofile_popup_buttons_for_sms);
        this.f4470aL.setVisibility(0);
        this.f4471aM = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_add_contact_for_sms);
        this.f4471aM.setOnClickListener(this);
        this.f4472aN = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_spam_for_sms);
        this.f4472aN.setOnClickListener(this);
        this.f4473aO = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_remove_spam_for_sms);
        this.f4473aO.setOnClickListener(this);
        if (C4149cd.m16431d(this, this.f4510e)) {
            this.f4471aM.setVisibility(8);
            this.f4472aN.setVisibility(8);
        } else {
            this.f4473aO.setVisibility(8);
        }
        this.f4503au = (ImageView) findViewById(R.id.buddy_cprofile_popup_unauthenticated_image);
        this.f4504av = (ImageView) findViewById(R.id.buddy_cprofile_popup_flag_image);
        this.f4474aP = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_loading_area);
        this.f4474aP.setVisibility(8);
        this.f4506ax = (ViewGroup) findViewById(R.id.buddy_cprofile_popup_3_buttons);
        this.f4506ax.setVisibility(8);
        this.f4467aI = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_add);
        this.f4467aI.setVisibility(8);
        this.f4466aH = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_alarm);
        this.f4466aH.setVisibility(8);
        this.f4465aG = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_block);
        this.f4465aG.setVisibility(8);
        this.f4468aJ = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_unblock);
        this.f4468aJ.setVisibility(8);
        this.f4469aK = (LinearLayout) findViewById(R.id.buddy_cprofile_popup_ignore);
        this.f4469aK.setVisibility(8);
        this.f4463aE = findViewById(R.id.buddy_variation_popup_divider);
        this.f4464aF = (ViewGroup) findViewById(R.id.buddy_cprofile_popup_buttons);
        this.f4464aF.setVisibility(8);
        this.f4507ay = (Button) findViewById(R.id.buddy_cprofile_popup_button_cancel);
        this.f4508az = (Button) findViewById(R.id.buddy_cprofile_popup_button_ok);
        this.f4459aA = (Button) findViewById(R.id.buddy_cprofile_popup_button_retry);
    }

    /* renamed from: c */
    private boolean m7199c(String str) {
        if (str.length() >= 19 && str.startsWith("10")) {
            C4904y.m18639b("chaton id : " + str, f4430a);
            return false;
        }
        if (str.startsWith(Spam.ACTIVITY_CANCEL)) {
            C4904y.m18639b("pin number : " + str, f4430a);
            return false;
        }
        C4904y.m18639b("phone number: " + str, f4430a);
        return true;
    }

    /* renamed from: h */
    private boolean m7218h() {
        boolean z = false;
        if (this.f4524s != null) {
            try {
                if (!TextUtils.isEmpty(this.f4524s.m7058g())) {
                    String strM7040C = this.f4524s.m7040C();
                    if (!TextUtils.isEmpty(strM7040C)) {
                        if (strM7040C.contains("voip=1")) {
                            z = true;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        C4904y.m18639b("isChatONVBuddy() : " + z, f4430a);
        return z;
    }

    /* renamed from: i */
    private boolean m7221i() {
        boolean z = false;
        try {
            if (C2923b.m12153h(getApplicationContext())) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C4904y.m18639b("isChatONVSupportedDevice() : " + z, f4430a);
        return z;
    }

    /* renamed from: j */
    private boolean m7224j() {
        boolean z = false;
        try {
            if (C2948h.m12190a().m12192a(getApplicationContext(), EnumC2949i.ChatONV)) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C4904y.m18639b("isChatONVAvaiable() : " + z, f4430a);
        return z;
    }

    /* renamed from: k */
    private boolean m7227k() {
        boolean z = false;
        try {
            C0416a c0416a = this.f4479aU;
            if (C0416a.m1477b(getApplicationContext())) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C4904y.m18639b("isChatONVInstalled() : " + z, f4430a);
        return z;
    }

    /* renamed from: l */
    private boolean m7229l() {
        boolean zM1495d;
        Exception e;
        try {
            zM1495d = this.f4479aU.m1495d(getApplicationContext());
            try {
                C4904y.m18639b("isReadyToCall() : " + zM1495d, f4430a);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                C4904y.m18639b("isChatONVReadyToCall() : " + zM1495d, f4430a);
                return zM1495d;
            }
        } catch (Exception e3) {
            zM1495d = false;
            e = e3;
        }
        C4904y.m18639b("isChatONVReadyToCall() : " + zM1495d, f4430a);
        return zM1495d;
    }

    /* renamed from: m */
    private boolean m7231m() {
        boolean zM7177a;
        if (((TelephonyManager) getApplicationContext().getSystemService("phone")).getPhoneType() == 0) {
            zM7177a = false;
        } else {
            zM7177a = m7177a(this, new Intent("android.intent.action.CALL", Uri.parse("tel:+000")));
        }
        C4904y.m18639b("is3GCallAvailable : " + zM7177a, f4430a);
        return zM7177a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public boolean m7233n() {
        int iM10677a = C2471v.m10677a(getApplicationContext());
        if (-3 != iM10677a && -2 != iM10677a) {
            return true;
        }
        C5179v.m19810a(getApplicationContext(), R.string.popup_no_network_connection, 0).show();
        return false;
    }

    /* renamed from: o */
    private void m7235o() {
        this.f4487ae.setBackgroundResource(R.drawable.buddy_profile_popup_left_btn_bg);
        this.f4487ae.setVisibility(0);
        this.f4457Y.setVisibility(8);
        this.f4483aa.setVisibility(8);
        this.f4458Z.setBackgroundResource(R.drawable.buddy_profile_popup_right_btn_bg);
        this.f4526u.setVisibility(8);
        this.f4456X.setVisibility(8);
        this.f4434B.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ab  */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m7237p() {
        /*
            r7 = this;
            r1 = 1
            r2 = 0
            com.sec.chaton.buddy.a.c r0 = r7.f4524s
            int r0 = r0.m7039B()
            if (r0 == 0) goto La4
            r0 = r1
        Lb:
            if (r0 == 0) goto Lad
            boolean r3 = r7.m7231m()
            if (r3 != 0) goto Lab
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
            boolean r0 = m7177a(r0, r4)
            if (r0 == 0) goto Lab
            r0 = r1
        L3a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "processNoChatONVCase : buddyPhoneNumberAvailable = "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r3)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = com.sec.chaton.buddy.dialog.BuddyDialog.f4430a
            com.sec.chaton.util.C4904y.m18639b(r4, r5)
            java.lang.String r4 = r7.f4509d
            boolean r4 = r7.m7199c(r4)
            if (r4 != 0) goto La9
            if (r3 == 0) goto La7
            boolean r3 = r7.m7243s()
            if (r3 == 0) goto La7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "processNoChatONVCase : buddyPhoneNumberAvailable2 = "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = com.sec.chaton.buddy.dialog.BuddyDialog.f4430a
            com.sec.chaton.util.C4904y.m18639b(r2, r3)
        L7c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "processNoChatONVCase : buddyPhoneNumberAvailable = "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r1)
            java.lang.String r3 = " @ isContactShow = "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = com.sec.chaton.buddy.dialog.BuddyDialog.f4430a
            com.sec.chaton.util.C4904y.m18639b(r2, r3)
            r7.m7176a(r1, r0)
            return
        La4:
            r0 = r2
            goto Lb
        La7:
            r1 = r2
            goto L7c
        La9:
            r1 = r3
            goto L7c
        Lab:
            r0 = r2
            goto L3a
        Lad:
            r3 = r0
            r0 = r2
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.dialog.BuddyDialog.m7237p():void");
    }

    /* renamed from: a */
    private void m7176a(boolean z, boolean z2) {
        if (!z) {
            if (z2) {
                this.f4458Z.setVisibility(8);
                if (C2349a.m10301a("sms_feature")) {
                    this.f4487ae.setVisibility(8);
                    this.f4457Y.setBackgroundResource(R.drawable.buddy_profile_popup_solo_btn_bg);
                    return;
                } else {
                    this.f4483aa.setVisibility(0);
                    return;
                }
            }
            this.f4458Z.setVisibility(8);
            this.f4483aa.setVisibility(8);
            this.f4487ae.setVisibility(8);
            this.f4457Y.setBackgroundResource(R.drawable.buddy_profile_popup_solo_btn_bg);
        }
    }

    /* renamed from: b */
    private void m7194b(boolean z, boolean z2) {
        if (z) {
            this.f4458Z.setVisibility(0);
            this.f4484ab.setVisibility(0);
            this.f4485ac.setVisibility(0);
            this.f4485ac.setBackgroundResource(R.drawable.buddy_profile_popup_right_btn_bg);
            if (C2349a.m10301a("sms_feature")) {
                this.f4487ae.setVisibility(0);
                return;
            } else {
                this.f4483aa.setVisibility(8);
                return;
            }
        }
        if (z2) {
            this.f4458Z.setVisibility(8);
            this.f4484ab.setVisibility(0);
            this.f4485ac.setVisibility(0);
            if (C2349a.m10301a("sms_feature")) {
                this.f4487ae.setVisibility(8);
                this.f4485ac.setBackgroundResource(R.drawable.buddy_profile_popup_right_btn_bg);
                return;
            } else {
                this.f4483aa.setVisibility(0);
                return;
            }
        }
        this.f4458Z.setVisibility(8);
        this.f4483aa.setVisibility(8);
        this.f4487ae.setVisibility(8);
        this.f4484ab.setVisibility(0);
        this.f4485ac.setVisibility(0);
        this.f4485ac.setBackgroundResource(R.drawable.buddy_profile_popup_right_btn_bg);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0089 A[PHI: r9
  0x0089: PHI (r9v1 boolean) = (r9v0 boolean), (r9v3 boolean), (r9v3 boolean) binds: [B:3:0x000d, B:5:0x002c, B:7:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m7193b(boolean r9) {
        /*
            r8 = this;
            boolean r2 = r8.m7221i()
            boolean r3 = r8.m7224j()
            boolean r4 = r8.m7229l()
            r1 = 0
            if (r9 == 0) goto L89
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "processMultiDeviceCase : buddyPhoneNumberAvailable = "
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = com.sec.chaton.buddy.dialog.BuddyDialog.f4430a
            com.sec.chaton.util.C4904y.m18639b(r0, r5)
            boolean r9 = r8.m7231m()
            if (r9 != 0) goto L89
            android.content.Context r0 = r8.getApplicationContext()
            java.lang.String r5 = "phone"
            java.lang.Object r0 = r0.getSystemService(r5)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            android.content.Context r0 = r8.getApplicationContext()
            android.content.Intent r5 = new android.content.Intent
            java.lang.String r6 = "android.intent.action.SENDTO"
            java.lang.String r7 = "smsto:+000"
            android.net.Uri r7 = android.net.Uri.parse(r7)
            r5.<init>(r6, r7)
            boolean r0 = m7177a(r0, r5)
            if (r0 == 0) goto L89
            r0 = 1
        L55:
            boolean r1 = r8.m7218h()
            if (r2 == 0) goto L73
            if (r3 == 0) goto L73
            if (r4 == 0) goto L69
            if (r1 == 0) goto L65
            r8.m7194b(r9, r0)
        L64:
            return
        L65:
            r8.m7176a(r9, r0)
            goto L64
        L69:
            if (r1 == 0) goto L6f
            r8.m7194b(r9, r0)
            goto L64
        L6f:
            r8.m7176a(r9, r0)
            goto L64
        L73:
            if (r2 == 0) goto L85
            boolean r2 = r8.m7227k()
            if (r2 != 0) goto L81
            if (r1 == 0) goto L81
            r8.m7194b(r9, r0)
            goto L64
        L81:
            r8.m7176a(r9, r0)
            goto L64
        L85:
            r8.m7176a(r9, r0)
            goto L64
        L89:
            r0 = r1
            goto L55
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.dialog.BuddyDialog.m7193b(boolean):void");
    }

    /* renamed from: q */
    private void m7239q() {
        boolean z;
        if (this.f4524s != null) {
            if (this.f4524s.m7039B() != 0) {
            }
            C4904y.m18639b("showphonenumber : " + this.f4524s.m7039B(), f4430a);
            if (this.f4524s.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                C4904y.m18639b("refreshCommunicationButtons : is lite feature user", f4430a);
                m7235o();
            } else {
                if (!this.f4498ap) {
                    C4904y.m18639b("refreshCommunicationButtons : is not multi-device", f4430a);
                    m7237p();
                    return;
                }
                C4904y.m18639b("refreshCommunicationButtons : is multi-device", f4430a);
                if (m7241r().size() == 0) {
                    z = false;
                } else {
                    z = true;
                }
                m7193b(z);
            }
        }
    }

    /* renamed from: a */
    public static boolean m7177a(Context context, Intent intent) {
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
        if (this.f4489ag && this.f4524s != null) {
            m7175a(true);
            if (configuration.orientation == 2) {
                this.f4438F.setVisibility(8);
                this.f4439G.setVisibility(8);
            } else {
                this.f4438F.setVisibility(0);
                this.f4439G.setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        switch (view.getId()) {
            case R.id.buddy_profile_popup_favorite_btn /* 2131165339 */:
                if (!this.f4488af) {
                    this.f4500ar.startQuery(4, this.f4524s, C2293m.f8204a, null, "group_relation_group = 1 ", null, null);
                    this.f4433A.setImageResource(R.drawable.actionbar_ic_favorite_01);
                    this.f4488af = true;
                    break;
                } else {
                    this.f4500ar.startDelete(2, this.f4524s, C2293m.f8204a, "group_relation_group = 1 AND group_relation_buddy = ? ", new String[]{this.f4509d});
                    this.f4433A.setImageResource(R.drawable.actionbar_ic_favorite_02);
                    this.f4488af = false;
                    break;
                }
            case R.id.buddy_profile_popup_view_profile /* 2131165341 */:
                BuddyFragment.f3586l = true;
                Intent intent = new Intent(getApplicationContext(), (Class<?>) BuddyProfileActivity.class);
                intent.putExtra("PROFILE_BUDDY_NO", this.f4509d);
                intent.putExtra("PROFILE_BUDDY_NAME", this.f4524s.m7051b());
                intent.putExtra("PROFILE_BUDDY_PROFILE_LOAD_DONE", this.f4475aQ);
                intent.putExtra("PROFILE_BUDDY_PROFILE_IMAGE_LOAD_DONE", this.f4476aR);
                intent.putExtra("PROFILE_BUDDY_PROFILE_IMAGE_COUNT", this.f4477aS);
                intent.putExtra("PROFILE_BUDDY_EXIST_REPRESENT", this.f4478aT);
                intent.putExtra("PROFILE_BUDDY_FROM_BUDDYDIALOG", true);
                intent.putExtra("PROFILE_BUDDY_IS_HIDDEN_BUDDY", this.f4490ah);
                intent.setFlags(335544320);
                startActivity(intent);
                finish();
                break;
            case R.id.buddy_profile_popup_pen_btn /* 2131165342 */:
                BuddyFragment.f3586l = true;
                Intent intent2 = new Intent(getApplicationContext(), (Class<?>) BuddyEditNickNameActivity.class);
                intent2.putExtra("PROFILE_ID", this.f4509d);
                intent2.putExtra("PROFILE_NAME", this.f4510e);
                intent2.putExtra("PROFILE_BUDDY_MODE", true);
                startActivity(intent2);
                finish();
                break;
            case R.id.buddy_profile_popup_image /* 2131165347 */:
            case R.id.buddy_profile_more_icon /* 2131165362 */:
                Intent intent3 = new Intent(getApplicationContext(), (Class<?>) BuddyProfileImageView.class);
                intent3.putExtra("PROFILE_BUDDY_NO", this.f4509d);
                intent3.putExtra("PROFILE_BUDDY_IMAGE_ID", this.f4452T.m7485b());
                intent3.putExtra("PROFILE_BUDDY_IMAGE_TYPE", "FULL");
                startActivity(intent3);
                finish();
                break;
            case R.id.buddy_profile_popup_image_1 /* 2131165356 */:
                String strM7485b = this.f4453U.m7485b();
                C4904y.m18639b("profileImageId : " + strM7485b, f4430a);
                Intent intent4 = new Intent(getApplicationContext(), (Class<?>) BuddyProfileImageView.class);
                intent4.putExtra("PROFILE_BUDDY_NO", this.f4509d);
                intent4.putExtra("PROFILE_BUDDY_IMAGE_ID", strM7485b);
                intent4.putExtra("PROFILE_BUDDY_IMAGE_TYPE", "THUMB");
                startActivity(intent4);
                finish();
                break;
            case R.id.buddy_profile_popup_image_2 /* 2131165358 */:
                String strM7485b2 = this.f4454V.m7485b();
                C4904y.m18639b("profileImageId : " + strM7485b2, f4430a);
                Intent intent5 = new Intent(getApplicationContext(), (Class<?>) BuddyProfileImageView.class);
                intent5.putExtra("PROFILE_BUDDY_NO", this.f4509d);
                intent5.putExtra("PROFILE_BUDDY_IMAGE_ID", strM7485b2);
                intent5.putExtra("PROFILE_BUDDY_IMAGE_TYPE", "THUMB");
                startActivity(intent5);
                finish();
                break;
            case R.id.buddy_profile_popup_image_3 /* 2131165360 */:
                String strM7485b3 = this.f4455W.m7485b();
                C4904y.m18639b("profileImageId : " + strM7485b3, f4430a);
                Intent intent6 = new Intent(getApplicationContext(), (Class<?>) BuddyProfileImageView.class);
                intent6.putExtra("PROFILE_BUDDY_NO", this.f4509d);
                intent6.putExtra("PROFILE_BUDDY_IMAGE_ID", strM7485b3);
                intent6.putExtra("PROFILE_BUDDY_IMAGE_TYPE", "THUMB");
                startActivity(intent6);
                finish();
                break;
            case R.id.buddy_profile_popup_chat /* 2131165363 */:
            case R.id.buddy_profile_popup_solo_chat /* 2131165369 */:
                BuddyFragment.f3586l = true;
                if (this.f4524s.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                    if (!C4822an.m18218a()) {
                    }
                    Intent intent7 = new Intent("com.sec.chaton.smsplugin.SEND");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f4524s.m7054c());
                    intent7.setFlags(67108864);
                    intent7.putExtra("receiver_array", (String[]) arrayList.toArray(new String[0]));
                    startActivity(intent7);
                } else {
                    Intent intent8 = new Intent(getApplicationContext(), (Class<?>) ChatActivity.class);
                    intent8.setFlags(67108864);
                    intent8.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
                    intent8.putExtra("receivers", new String[]{this.f4509d});
                    intent8.putExtra("showPhoneNumber", this.f4524s.m7039B());
                    intent8.putExtra("extraInfo", this.f4524s.m7040C());
                    intent8.putExtra("msisdns", this.f4524s.m7057f());
                    intent8.putExtra("is_buddy", true);
                    intent8.putExtra(ChatFragment.f5473i, true);
                    startActivity(intent8);
                }
                finish();
                break;
            case R.id.buddy_profile_popup_sms /* 2131165364 */:
                BuddyFragment.f3586l = true;
                m7266e();
                break;
            case R.id.buddy_profile_popup_voice_call /* 2131165365 */:
                BuddyFragment.f3586l = true;
                if (!m7227k()) {
                    startActivity(new Intent(getApplicationContext(), (Class<?>) ChatONVRedirectDialog.class));
                } else if (m7224j() && m7229l() && m7218h()) {
                    try {
                        if (m7233n()) {
                            C4904y.m18639b("ChatON V call id : " + this.f4524s.m7058g(), f4430a);
                            C4904y.m18639b("ChatON V call name : " + C4809aa.m18104a().m18121a("Push Name", ""), f4430a);
                            if (this.f4479aU.m1487a(this, false, this.f4509d, C4809aa.m18104a().m18121a("Push Name", ""), null) != 0) {
                                C5179v.m19810a(getApplicationContext(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                            }
                        }
                    } catch (Exception e) {
                        C4904y.m18635a(e, getClass().getSimpleName());
                    }
                } else {
                    startActivity(new Intent(getApplicationContext(), (Class<?>) ChatONVInstallDialog.class));
                }
                finish();
                break;
            case R.id.buddy_profile_popup_video_call /* 2131165366 */:
                BuddyFragment.f3586l = true;
                if (!m7227k()) {
                    startActivity(new Intent(getApplicationContext(), (Class<?>) ChatONVRedirectDialog.class));
                } else if (m7224j() && m7229l() && m7218h()) {
                    try {
                        if (m7233n()) {
                            C4904y.m18639b("ChatON V call id : " + this.f4524s.m7058g(), f4430a);
                            C4904y.m18639b("ChatON V call name : " + C4809aa.m18104a().m18121a("Push Name", ""), f4430a);
                            if (this.f4479aU.m1487a(this, true, this.f4509d, C4809aa.m18104a().m18121a("Push Name", ""), null) != 0) {
                                C5179v.m19810a(getApplicationContext(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                            }
                        }
                    } catch (Exception e2) {
                        C4904y.m18635a(e2, getClass().getSimpleName());
                    }
                } else {
                    startActivity(new Intent(getApplicationContext(), (Class<?>) ChatONVInstallDialog.class));
                }
                finish();
                break;
            case R.id.buddy_profile_popup_call /* 2131165367 */:
                BuddyFragment.f3586l = true;
                m7139B();
                break;
            case R.id.buddy_profile_popup_contact /* 2131165368 */:
                BuddyFragment.f3586l = true;
                m7141C();
                break;
            case R.id.buddy_cprofile_popup_button_cancel /* 2131165380 */:
                finish();
                break;
            case R.id.buddy_cprofile_popup_button_ok /* 2131165381 */:
                if (this.f4460aB) {
                    ContentResolver contentResolver = getApplicationContext().getContentResolver();
                    ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                    arrayList2.add(C2181ag.m9738a(this.f4509d));
                    try {
                        contentResolver.applyBatch("com.sec.chaton.provider", arrayList2);
                    } catch (OperationApplicationException e3) {
                        e3.printStackTrace();
                    } catch (RemoteException e4) {
                        e4.printStackTrace();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                finish();
                break;
            case R.id.buddy_cprofile_popup_button_retry /* 2131165382 */:
            case R.id.buddy_cprofile_popup_add /* 2131165384 */:
                int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
                if (-3 == iM10677a || -2 == iM10677a) {
                    C5179v.m19810a(getApplicationContext(), R.string.popup_no_network_connection, 0).show();
                    break;
                } else {
                    m7247u();
                    break;
                }
            case R.id.buddy_cprofile_popup_block /* 2131165385 */:
                int iM10677a2 = C2471v.m10677a(CommonApplication.m18732r());
                if (-3 == iM10677a2 || -2 == iM10677a2) {
                    C5179v.m19810a(getApplicationContext(), R.string.popup_no_network_connection, 0).show();
                    break;
                } else {
                    m7249v();
                    break;
                }
            case R.id.buddy_cprofile_popup_ignore /* 2131165386 */:
                int iM10677a3 = C2471v.m10677a(CommonApplication.m18732r());
                if (-3 != iM10677a3 && -2 != iM10677a3) {
                    AbstractC4932a.m18733a(this).mo18740a(getResources().getString(R.string.buddy_suggestion_ignore)).mo18749b(getResources().getString(R.string.suggestion_ignore_popup_message, this.f4510e)).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1200a(this)).mo18741a(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
                    break;
                } else {
                    C5179v.m19810a(getApplicationContext(), R.string.popup_no_network_connection, 0).show();
                    break;
                }
            case R.id.buddy_cprofile_popup_alarm /* 2131165387 */:
                Intent intent9 = new Intent(getApplicationContext(), (Class<?>) SpamConfirmDialog.class);
                if (TextUtils.isEmpty(this.f4510e)) {
                    if (this.f4462aD) {
                        intent9.putExtra("SCD_DIALOG_BUDDY_NAME", this.f4509d);
                    } else {
                        intent9.putExtra("SCD_DIALOG_BUDDY_NAME", getString(R.string.unknown));
                    }
                } else {
                    intent9.putExtra("SCD_DIALOG_BUDDY_NAME", this.f4510e);
                }
                intent9.putExtra("SCD_DIALOG_BUDDY_NO", this.f4509d);
                startActivity(intent9);
                finish();
                break;
            case R.id.buddy_cprofile_popup_unblock /* 2131165388 */:
                int iM10677a4 = C2471v.m10677a(CommonApplication.m18732r());
                if (-3 == iM10677a4 || -2 == iM10677a4) {
                    C5179v.m19810a(getApplicationContext(), R.string.popup_no_network_connection, 0).show();
                    break;
                } else {
                    m7251w();
                    break;
                }
            case R.id.buddy_cprofile_popup_add_contact_for_sms /* 2131165390 */:
                C1736gi.m8639a(this, (String) null, this.f4510e, (String) null);
                break;
            case R.id.buddy_cprofile_popup_spam_for_sms /* 2131165391 */:
                C4149cd.m16434e(this, this.f4510e);
                Spam spam = new Spam();
                spam.setCat(Spam.CATEGORY_DEFAULT).setAct(Spam.ACTIVITY_REPORT);
                spam.setNum(this.f4510e);
                spam.setMsg("");
                SetSpamReq setSpamReq = new SetSpamReq();
                setSpamReq.setMsisdn(m7142D()).setImei(C4822an.m18228d()).setImsi(C4822an.m18238h());
                setSpamReq.setSpam(spam);
                new Thread(new C3033b(C4865cc.m18450b(EnumC4868cf.CONTACT), 33947648, setSpamReq, this.f4518m)).start();
                m7256z();
                this.f4471aM.setVisibility(8);
                this.f4472aN.setVisibility(8);
                break;
            case R.id.buddy_cprofile_popup_remove_spam_for_sms /* 2131165392 */:
                C4149cd.m16435f(this, this.f4510e);
                Spam spam2 = new Spam();
                spam2.setCat(Spam.CATEGORY_DEFAULT).setAct(Spam.ACTIVITY_CANCEL);
                spam2.setNum(this.f4510e);
                spam2.setMsg("");
                SetSpamReq setSpamReq2 = new SetSpamReq();
                setSpamReq2.setMsisdn(m7142D()).setImei(C4822an.m18228d()).setImsi(C4822an.m18238h());
                setSpamReq2.setSpam(spam2);
                new Thread(new C3033b(C4865cc.m18450b(EnumC4868cf.CONTACT), 34013184, setSpamReq2, this.f4518m)).start();
                m7256z();
                this.f4473aO.setVisibility(8);
                break;
        }
    }

    /* renamed from: d */
    private void m7201d(String str) throws Throwable {
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        m7263b(str);
        if (!this.f4496an) {
            Bundle bundle = new Bundle();
            bundle.putString("phone", str);
            bundle.putString("name", this.f4524s.m7051b());
            C4904y.m18639b("phoneNum: " + str, f4430a);
            C4904y.m18639b("NAME: " + this.f4524s.m7051b(), f4430a);
            if (this.f4524s.m7055d() != null) {
                bundle.putString("email", this.f4524s.m7055d());
            }
            Intent intent = new Intent("android.intent.action.INSERT", uri);
            intent.putExtras(bundle);
            intent.putExtra("return-data", true);
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                C4904y.m18635a(e, getClass().getSimpleName());
                C5179v.m19810a(getApplicationContext(), R.string.toast_contact_not_found, 0).show();
            }
            finish();
            return;
        }
        long jM6055a = (this.f4498ap || this.f4497ao) ? 0L : C1002i.m6055a(this.f4524s.m7061j());
        if (jM6055a == 0) {
            jM6055a = this.f4499aq;
        }
        C4904y.m18639b("id: " + jM6055a, f4430a);
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse(uri + "/" + jM6055a));
        try {
            startActivity(intent2);
        } catch (ActivityNotFoundException e2) {
            C4904y.m18635a(e2, getClass().getSimpleName());
            C5179v.m19810a(getApplicationContext(), R.string.toast_contact_not_found, 0).show();
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public List<String> m7241r() {
        String strM7057f;
        StringTokenizer stringTokenizer;
        ArrayList arrayList = new ArrayList();
        if (this.f4524s.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
            strM7057f = this.f4524s.m7054c();
            this.f4511f = this.f4524s.m7054c();
            stringTokenizer = new StringTokenizer(strM7057f, ", ");
        } else {
            strM7057f = this.f4524s.m7057f();
            stringTokenizer = new StringTokenizer(strM7057f, "|");
        }
        if (!TextUtils.isEmpty(strM7057f)) {
            while (stringTokenizer.hasMoreTokens()) {
                new String();
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.length() >= 19 && strNextToken.startsWith("10")) {
                    C4904y.m18639b("chaton id : " + strNextToken, f4430a);
                } else if (strNextToken.startsWith(Spam.ACTIVITY_CANCEL)) {
                    C4904y.m18639b("pin number : " + strNextToken, f4430a);
                } else {
                    C4904y.m18639b("msisdn: " + strNextToken, f4430a);
                    arrayList.add(strNextToken);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void m7258a() {
        if (this.f4452T.m7486c()) {
            this.f4452T.m7482a().setOnClickListener(this);
            this.f4452T.m7482a().setFocusable(true);
            this.f4452T.m7482a().setClickable(true);
        } else {
            this.f4452T.m7482a().setOnClickListener(null);
            this.f4452T.m7482a().setFocusable(false);
            this.f4452T.m7482a().setClickable(false);
        }
        if (this.f4453U.m7486c()) {
            this.f4453U.m7482a().setOnClickListener(this);
            this.f4453U.m7482a().setBackgroundResource(R.drawable.profile_photo_bg2);
            this.f4453U.m7482a().setFocusable(true);
            this.f4453U.m7482a().setClickable(true);
        } else {
            this.f4453U.m7482a().setFocusable(false);
            this.f4453U.m7482a().setClickable(false);
        }
        if (this.f4454V.m7486c()) {
            this.f4454V.m7482a().setOnClickListener(this);
            this.f4454V.m7482a().setBackgroundResource(R.drawable.profile_photo_bg2);
            this.f4454V.m7482a().setFocusable(true);
            this.f4454V.m7482a().setClickable(true);
        } else {
            this.f4454V.m7482a().setFocusable(false);
            this.f4454V.m7482a().setClickable(false);
        }
        if (this.f4455W.m7486c()) {
            this.f4455W.m7482a().setOnClickListener(this);
            this.f4455W.m7482a().setBackgroundResource(R.drawable.profile_photo_bg2);
            this.f4455W.m7482a().setFocusable(true);
            this.f4455W.m7482a().setClickable(true);
        } else {
            this.f4455W.m7482a().setFocusable(false);
            this.f4455W.m7482a().setClickable(false);
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("setClickListenerOnImage", f4430a);
            C4904y.m18639b("mMainImage Clickable: " + this.f4452T.m7486c(), f4430a);
            C4904y.m18639b("mThumbImage1 Clickable: " + this.f4453U.m7486c(), f4430a);
            C4904y.m18639b("mThumbImage2 Clickable: " + this.f4454V.m7486c(), f4430a);
            C4904y.m18639b("mThumbImage3 Clickable: " + this.f4455W.m7486c(), f4430a);
        }
        if (this.f4449Q != null) {
            this.f4449Q.setOnClickListener(this);
        }
    }

    /* renamed from: b */
    public void m7262b() {
        C1331gk.m7453a(getApplicationContext()).m7464a(this.f4452T, this.f4453U, this.f4454V, this.f4455W, this.f4509d);
        m7258a();
    }

    /* renamed from: a */
    public void m7259a(int i) {
        C1331gk.m7453a(getApplicationContext()).m7466a(this.f4453U, this.f4454V, this.f4455W, this.f4509d, i - 1);
    }

    @Override // com.sec.common.p132g.InterfaceC5010f
    /* renamed from: a */
    public void mo6852a(View view, AbstractRunnableC5005a<?> abstractRunnableC5005a) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onFailed / task.isSuccess() : " + abstractRunnableC5005a.m18999m() + " / " + abstractRunnableC5005a.toString(), f4430a);
        }
        if ((abstractRunnableC5005a instanceof CallableC1330gj) && this.f4489ag) {
            if (view.equals(this.f4441I)) {
                this.f4452T.m7484a(false);
                if (C4904y.f17872b) {
                    C4904y.m18639b("mMainImage.setClickableState(false)", f4430a);
                }
            } else if (view.equals(this.f4453U.m7482a())) {
                this.f4453U.m7484a(false);
                if (C4904y.f17872b) {
                    C4904y.m18639b("mThumbImage1.setClickableState(false)", f4430a);
                }
            } else if (view.equals(this.f4454V.m7482a())) {
                this.f4454V.m7484a(false);
                if (C4904y.f17872b) {
                    C4904y.m18639b("mThumbImage2.setClickableState(false)", f4430a);
                }
            } else if (view.equals(this.f4455W.m7482a())) {
                this.f4455W.m7484a(false);
                if (C4904y.f17872b) {
                    C4904y.m18639b("mThumbImage3.setClickableState(false)", f4430a);
                }
            }
            this.f4521p--;
            if (C4904y.f17872b) {
                C4904y.m18639b("mTotalProfileImageCount: " + this.f4521p, f4430a);
            }
            if (this.f4521p == 0) {
                m7258a();
                this.f4476aR = true;
            }
        }
    }

    @Override // com.sec.common.p132g.InterfaceC5010f
    /* renamed from: b */
    public void mo6860b(View view, AbstractRunnableC5005a<?> abstractRunnableC5005a) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onCompleted / task.isSuccess() : " + abstractRunnableC5005a.m18999m() + " / " + abstractRunnableC5005a.toString(), f4430a);
        }
        if (abstractRunnableC5005a instanceof CallableC1330gj) {
            if (this.f4489ag) {
                if (view.equals(this.f4441I)) {
                    this.f4452T.m7484a(true);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("mMainImage.setClickableState(true)", f4430a);
                    }
                } else if (view.equals(this.f4453U.m7482a())) {
                    this.f4453U.m7484a(true);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("mThumbImage1.setClickableState(true)", f4430a);
                    }
                } else if (view.equals(this.f4454V.m7482a())) {
                    this.f4454V.m7484a(true);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("mThumbImage2.setClickableState(true)", f4430a);
                    }
                } else if (view.equals(this.f4455W.m7482a())) {
                    this.f4455W.m7484a(true);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("mThumbImage3.setClickableState(true)", f4430a);
                    }
                }
                this.f4521p--;
                if (C4904y.f17872b) {
                    C4904y.m18639b("mTotalProfileImageCount: " + this.f4521p, f4430a);
                }
                if (this.f4521p == 0) {
                    m7258a();
                    this.f4476aR = true;
                    return;
                }
                return;
            }
            this.f4504av.setVisibility(0);
        }
    }

    /* renamed from: c */
    public void m7264c() throws Throwable {
        C4904y.m18639b("This buddy is not chaton User, so it will be deleted : " + this.f4509d, getClass().getSimpleName());
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(C2190d.m9819b(this.f4509d));
        if (C2349a.m10301a("sms_feature")) {
            String strM9842g = C2190d.m9842g(this.f4509d);
            String strM7056e = this.f4524s.m7056e();
            if (!TextUtils.isEmpty(strM7056e) && C4883f.m18539a(strM7056e) && strM7056e.length() >= 8) {
                arrayList.add(C2192f.m9878b(strM7056e));
            }
            if (strM9842g != null && strM9842g.length() >= 8) {
                if (strM9842g.contains(" ")) {
                    StringTokenizer stringTokenizer = new StringTokenizer(strM9842g, " ");
                    while (stringTokenizer.hasMoreTokens()) {
                        String strNextToken = stringTokenizer.nextToken();
                        if (strNextToken != null && !TextUtils.isEmpty(strNextToken) && C4883f.m18539a(strNextToken) && strNextToken.length() >= 8) {
                            arrayList.add(C2192f.m9878b("%" + strNextToken.substring(strNextToken.length() - 8)));
                        }
                    }
                } else if (C4883f.m18539a(strM9842g)) {
                    arrayList.add(C2192f.m9878b("%" + strM9842g.substring(strM9842g.length() - 8)));
                }
            }
        }
        arrayList.add(C2191e.m9849a(this.f4509d));
        arrayList.add(C2198l.m9917a(this.f4509d));
        C4855bt.m18351a(GlobalApplication.m10279a()).m18363a(this.f4509d);
        C1331gk.m7453a(GlobalApplication.m10279a()).m7467a(this.f4509d);
        C1004k.m6082b(this.f4509d);
        try {
            GlobalApplication.m10279a().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        C5179v.m19811a(getApplicationContext(), getApplicationContext().getResources().getString(R.string.buddy_profile_dialog_addbuddy_failed_invaliduser, this.f4510e), 1).show();
        finish();
    }

    /* renamed from: d */
    public boolean m7265d() {
        C4904y.m18639b("Buddy didn't set Coverstory ", getClass().getSimpleName());
        String strM9895a = C2195i.m9895a();
        if (strM9895a != null) {
            if (!m7261a(strM9895a, this.f4509d)) {
                this.f4530y = strM9895a;
                this.f4523r.m9540a(strM9895a, Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
            }
            return true;
        }
        C4904y.m18639b(" Random ERROR !!", getClass().getSimpleName());
        this.f4523r.m9543b(Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public boolean m7243s() {
        if (this.f4509d.length() < 19 || !this.f4509d.startsWith("10") || TextUtils.isEmpty(this.f4524s.m7056e())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m7245t() {
        this.f4464aF.setVisibility(0);
        this.f4507ay.setVisibility(0);
        this.f4506ax.setVisibility(8);
        this.f4467aI.setVisibility(8);
        this.f4466aH.setVisibility(8);
        this.f4465aG.setVisibility(8);
        this.f4469aK.setVisibility(8);
        this.f4508az.setVisibility(8);
        this.f4459aA.setVisibility(8);
        this.f4468aJ.setVisibility(8);
        this.f4505aw.setText(getResources().getString(R.string.trunk_network_not_available));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public boolean m7207e(String str) {
        return new File(this.f4519n).exists() && new File(this.f4519n, new StringBuilder().append(str).append(".png").toString()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m7211f(String str) {
        Bitmap bitmapM18144a;
        File file = new File(this.f4519n, str + ".png");
        if (file.exists()) {
            try {
                if (file.length() > 0 && (bitmapM18144a = C4812ad.m18144a(getApplicationContext(), Uri.fromFile(file), 66, 44)) != null) {
                    this.f4504av.setVisibility(0);
                    this.f4504av.setImageBitmap(bitmapM18144a);
                }
            } catch (Exception e) {
                C4904y.m18635a(e, f4430a);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public boolean m7260a(String str) throws IOException {
        boolean z;
        boolean z2 = false;
        File file = new File(this.f4529x);
        if (file.exists()) {
            String[] list = file.list();
            if (list != null && list.length > 0) {
                String str2 = list[(int) (Math.random() * list.length)];
                int iLastIndexOf = str2.lastIndexOf(".");
                String strSubstring = str2.substring(0, iLastIndexOf);
                C4904y.m18639b("loadRandomimage filename : " + str2 + "### pos : " + iLastIndexOf + " ### randomId : " + strSubstring, f4430a);
                z = true;
                if (!TextUtils.isEmpty(strSubstring)) {
                    String str3 = this.f4529x + strSubstring + ".jpg";
                    C4904y.m18639b("loadRandomimage randomId : " + strSubstring + " ### randomFile : " + str3, f4430a);
                    if (this.f4527v == null) {
                        return true;
                    }
                    this.f4527v.setImageURI(Uri.parse(str3));
                    if (TextUtils.isEmpty(str)) {
                        return true;
                    }
                    m7192b(strSubstring, str);
                    return true;
                }
            } else {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Default Coverstory Image download for only MMS user.", f4430a);
                }
                C2955a c2955a = new C2955a("http://cdn.samsungbigdata.com/itemshop/sms/coverstory/pr_480_480_img06.jpg", "MMS", getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/", "dCoverstory.jpg", "buddy", CommonApplication.m18732r());
                if (this.f4491ai == null) {
                    this.f4491ai = new C5007c();
                }
                this.f4491ai.m19023b(this.f4527v, c2955a);
                z = false;
            }
            z2 = z;
        } else {
            if (C4904y.f17872b) {
                C4904y.m18639b("loadRandomimage No random images in file folder ", f4430a);
            }
            if (TextUtils.isEmpty(str)) {
                String str4 = getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/";
                if (new File(str4 + "dCoverstory.jpg").exists()) {
                    if (this.f4527v != null) {
                        this.f4527v.setImageURI(Uri.parse(str4 + "dCoverstory.jpg"));
                        if (C4904y.f17872b) {
                            C4904y.m18639b("Default Coverstory Image setting for only MMS user.", f4430a);
                        }
                    }
                } else {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Default Coverstory Image download for only MMS user.", f4430a);
                    }
                    C2955a c2955a2 = new C2955a("http://cdn.samsungbigdata.com/itemshop/sms/coverstory/pr_480_480_img06.jpg", "MMS", str4, "dCoverstory.jpg", "buddy", CommonApplication.m18732r());
                    if (this.f4491ai == null) {
                        this.f4491ai = new C5007c();
                    }
                    this.f4491ai.m19023b(this.f4527v, c2955a2);
                }
            }
        }
        return z2;
    }

    /* renamed from: a */
    public static boolean m7179a(String str, String str2, String str3, ImageView imageView) throws IOException {
        boolean z = false;
        File file = new File(str2);
        if (file.exists()) {
            String[] list = file.list();
            if (list != null) {
                String str4 = list[(int) (Math.random() * list.length)];
                int iLastIndexOf = str4.lastIndexOf(".");
                String strSubstring = str4.substring(0, iLastIndexOf);
                C4904y.m18639b("loadRandomimage filename : " + str4 + "### pos : " + iLastIndexOf + " ### randomId : " + strSubstring, f4430a);
                z = true;
                if (!TextUtils.isEmpty(strSubstring)) {
                    String str5 = str2 + strSubstring + ".jpg";
                    C4904y.m18639b("loadRandomimage randomId : " + strSubstring + " ### randomFile : " + str5, f4430a);
                    if (imageView != null) {
                        imageView.setImageURI(Uri.parse(str5));
                        m7174a(strSubstring, str, str2, str3);
                    }
                }
            }
        } else if (C4904y.f17872b) {
            C4904y.m18639b("loadRandomimage No random images in file folder ", f4430a);
        }
        return z;
    }

    /* renamed from: a */
    public boolean m7261a(String str, String str2) throws IOException {
        boolean z = false;
        if (!new File(this.f4529x).exists()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("checkAndSetCoverStoryRandomImages No random images in file folder ", f4430a);
            }
        } else {
            String str3 = this.f4529x + str + ".jpg";
            File file = new File(str3);
            if (file.exists()) {
                if (file.length() == 0) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("checkAndSetCoverStoryRandomImages file size is 0.", f4430a);
                    }
                    file.delete();
                } else {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("checkAndSetCoverStoryRandomImages get the random image in file folder #3#", f4430a);
                    }
                    z = true;
                    if (this.f4527v != null) {
                        this.f4527v.setImageURI(Uri.parse(str3));
                        m7192b(str, str2);
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("checkAndSetCoverStoryRandomImages set the random image from file folder #4#", f4430a);
                    }
                }
            } else if (C4904y.f17872b) {
                C4904y.m18639b("checkAndSetCoverStoryRandomImages not exists the random image in file folder #2#", f4430a);
            }
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m7180a(String str, String str2, String str3, String str4, ImageView imageView) throws IOException {
        boolean z = false;
        if (!new File(str3).exists()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("checkAndSetCoverStoryRandomImages No random images in file folder ", f4430a);
            }
        } else {
            String str5 = str3 + str + ".jpg";
            File file = new File(str5);
            if (file.exists()) {
                if (file.length() == 0) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("checkAndSetCoverStoryRandomImages file size is 0.", f4430a);
                    }
                    file.delete();
                } else {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("checkAndSetCoverStoryRandomImages get the random image in file folder #3#", f4430a);
                    }
                    z = true;
                    if (imageView != null) {
                        imageView.setImageURI(Uri.parse(str5));
                        m7174a(str, str2, str3, str4 + str2 + "/coverstory/");
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("checkAndSetCoverStoryRandomImages set the random image from file folder #4#", f4430a);
                    }
                }
            } else if (C4904y.f17872b) {
                C4904y.m18639b("checkAndSetCoverStoryRandomImages not exists the random image in file folder #2#", f4430a);
            }
        }
        return z;
    }

    /* renamed from: a */
    public static void m7173a(String str, String str2, String str3) throws IOException {
        try {
            if (str3 != null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b(" static copyCoverStoryforRandomImages mOriginPath : " + str2, f4430a);
                    C4904y.m18639b(" static copyCoverStoryforRandomImages mDestPath : " + str3 + str + ".jpg", f4430a);
                }
                new File(str3).mkdirs();
                File file = new File(str2);
                File file2 = new File(str3 + str + ".jpg");
                if (file2.exists() && file2.length() != 0) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b(" static copyCoverStoryforRandomImages already exist...", f4430a);
                        return;
                    }
                    return;
                } else {
                    if (file.length() > 0) {
                        new FileOutputStream(file2).close();
                        if (C4904y.f17872b) {
                            C4904y.m18639b(" static copyCoverStoryforRandomImages copy to : " + file2.getPath(), f4430a);
                        }
                        C4636a.m17602a(file, file2);
                        return;
                    }
                    return;
                }
            }
            if (C4904y.f17872b) {
                C4904y.m18639b(" static copyCoverStoryforRandomImages dirInternalPathS is null : ", f4430a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m7192b(String str, String str2) throws IOException {
        String str3 = getApplicationContext().getCacheDir() + "/" + str2 + "/coverstory/";
        if (C4904y.f17872b) {
            C4904y.m18639b("dirInternalPath : " + this.f4529x + str + ".jpg", "copyCoverStoryforBuddyProfile");
            C4904y.m18639b("mBuddyCoverStoryDir : " + str3, "copyCoverStoryforBuddyProfile");
        }
        new File(str3).mkdirs();
        File file = new File(str3 + "coverstory.jpg");
        File file2 = new File(this.f4529x + str + ".jpg");
        if (file2.length() > 0) {
            try {
                new FileOutputStream(file).close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            C4636a.m17602a(file2, file);
        }
    }

    /* renamed from: a */
    private static void m7174a(String str, String str2, String str3, String str4) throws IOException {
        if (C4904y.f17872b) {
            C4904y.m18639b("randomDir : " + str3 + str + ".jpg", "copyCoverStoryforBuddyProfile");
            C4904y.m18639b("mBuddyPath : " + str4, "copyCoverStoryforBuddyProfile");
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
            C4636a.m17602a(file2, file);
        }
    }

    /* renamed from: u */
    private void m7247u() {
        m7254y();
        new C2128i(this.f4516k).m9508b(this.f4509d);
    }

    /* renamed from: v */
    private void m7249v() {
        m7254y();
        C2126g.m9476a(this.f4516k).m9479a(this.f4509d, 1);
    }

    /* renamed from: w */
    private void m7251w() {
        m7254y();
        C2126g.m9476a(this.f4516k).m9478a(this.f4509d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m7253x() {
        ArrayList<String> arrayList = new ArrayList<>();
        m7254y();
        C2135p c2135pM9578a = C2135p.m9578a(this.f4516k);
        arrayList.add(this.f4509d);
        c2135pM9578a.m9579a("true", arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m7215g(String str) {
        new C2128i(this.f4516k).m9531g(str);
    }

    /* renamed from: y */
    private void m7254y() {
        this.f4474aP.setVisibility(0);
        this.f4464aF.setVisibility(8);
        this.f4506ax.setVisibility(8);
    }

    /* renamed from: z */
    private void m7256z() {
        this.f4474aP.setVisibility(0);
        this.f4464aF.setVisibility(8);
        this.f4470aL.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m7136A() {
        this.f4474aP.setVisibility(8);
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x008e A[PHI: r1
  0x008e: PHI (r1v7 android.database.Cursor) = (r1v4 android.database.Cursor), (r1v11 android.database.Cursor) binds: [B:19:0x00be, B:10:0x008c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m7263b(java.lang.String r9) throws java.lang.Throwable {
        /*
            r8 = this;
            r7 = 0
            r6 = 0
            r8.f4496an = r7
            java.lang.String r0 = "[contactSavedCheck] Contact Saved Find Start"
            java.lang.String r1 = com.sec.chaton.buddy.dialog.BuddyDialog.f4430a     // Catch: java.lang.Exception -> Lb1 java.lang.Throwable -> Lc1
            com.sec.chaton.util.C4904y.m18639b(r0, r1)     // Catch: java.lang.Exception -> Lb1 java.lang.Throwable -> Lc1
            android.net.Uri r0 = android.provider.ContactsContract.PhoneLookup.CONTENT_FILTER_URI     // Catch: java.lang.Exception -> Lb1 java.lang.Throwable -> Lc1
            java.lang.String r1 = android.net.Uri.encode(r9)     // Catch: java.lang.Exception -> Lb1 java.lang.Throwable -> Lc1
            android.net.Uri r1 = android.net.Uri.withAppendedPath(r0, r1)     // Catch: java.lang.Exception -> Lb1 java.lang.Throwable -> Lc1
            android.content.Context r0 = r8.getApplicationContext()     // Catch: java.lang.Exception -> Lb1 java.lang.Throwable -> Lc1
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> Lb1 java.lang.Throwable -> Lc1
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Exception -> Lb1 java.lang.Throwable -> Lc1
            r3 = 0
            java.lang.String r4 = "display_name"
            r2[r3] = r4     // Catch: java.lang.Exception -> Lb1 java.lang.Throwable -> Lc1
            r3 = 1
            java.lang.String r4 = "number"
            r2[r3] = r4     // Catch: java.lang.Exception -> Lb1 java.lang.Throwable -> Lc1
            r3 = 2
            java.lang.String r4 = "_id"
            r2[r3] = r4     // Catch: java.lang.Exception -> Lb1 java.lang.Throwable -> Lc1
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> Lb1 java.lang.Throwable -> Lc1
            if (r1 == 0) goto L8c
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            if (r0 <= 0) goto L8c
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            if (r0 == 0) goto L8c
            r0 = 1
            r8.f4496an = r0     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            java.lang.String r0 = "_id"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            r8.f4499aq = r0     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            r0.<init>()     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            java.lang.String r2 = "[contactSavedCheck] Found in Contact Number : "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            java.lang.StringBuilder r0 = r0.append(r9)     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            java.lang.String r2 = com.sec.chaton.buddy.dialog.BuddyDialog.f4430a     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            com.sec.chaton.util.C4904y.m18639b(r0, r2)     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            r0.<init>()     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            java.lang.String r2 = "[contactSavedCheck] ContactSaved id : "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            int r2 = r8.f4499aq     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            java.lang.String r2 = com.sec.chaton.buddy.dialog.BuddyDialog.f4430a     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
            com.sec.chaton.util.C4904y.m18639b(r0, r2)     // Catch: java.lang.Throwable -> Lc9 java.lang.Exception -> Lcb
        L8c:
            if (r1 == 0) goto L91
        L8e:
            r1.close()
        L91:
            boolean r0 = r8.f4496an
            if (r0 != 0) goto Lb0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "[contactSavedCheck] No PhoneNumber in Contact : "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = com.sec.chaton.buddy.dialog.BuddyDialog.f4430a
            com.sec.chaton.util.C4904y.m18639b(r0, r1)
            r8.f4499aq = r7
        Lb0:
            return
        Lb1:
            r0 = move-exception
            r1 = r6
        Lb3:
            java.lang.Class r2 = r8.getClass()     // Catch: java.lang.Throwable -> Lc9
            java.lang.String r2 = r2.getSimpleName()     // Catch: java.lang.Throwable -> Lc9
            com.sec.chaton.util.C4904y.m18635a(r0, r2)     // Catch: java.lang.Throwable -> Lc9
            if (r1 == 0) goto L91
            goto L8e
        Lc1:
            r0 = move-exception
            r1 = r6
        Lc3:
            if (r1 == 0) goto Lc8
            r1.close()
        Lc8:
            throw r0
        Lc9:
            r0 = move-exception
            goto Lc3
        Lcb:
            r0 = move-exception
            goto Lb3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.dialog.BuddyDialog.m7263b(java.lang.String):void");
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        C4904y.m18641c("[LIFE] onStart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        C4904y.m18641c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onDestroy() {
        if (this.f4481aW != null) {
            this.f4481aW.removeCallbacksAndMessages(null);
            this.f4481aW = null;
        }
        if (this.f4500ar != null) {
            this.f4500ar.removeCallbacksAndMessages(null);
        }
        if (this.f4523r != null) {
            this.f4523r.m9541b();
            this.f4523r.m9546e();
            this.f4523r.m9548g();
            this.f4523r = null;
        }
        if (this.f4527v != null) {
            this.f4527v.setImageBitmap(null);
            this.f4527v = null;
        }
        if (this.f4491ai != null) {
            this.f4491ai.m19019a((InterfaceC5010f) null);
            this.f4491ai.m19014a();
        }
        if (this.f4522q != null) {
            this.f4522q.m9321h();
            this.f4522q.m9317f();
            this.f4522q.m9308b();
            this.f4522q.m9311c();
            this.f4522q = null;
        }
        if (this.f4441I != null) {
            this.f4441I.setImageBitmap(null);
            this.f4441I = null;
        }
        if (this.f4442J != null) {
            this.f4442J.setImageBitmap(null);
            this.f4442J = null;
        }
        if (this.f4443K != null) {
            this.f4443K.setImageBitmap(null);
            this.f4443K = null;
        }
        if (this.f4444L != null) {
            this.f4444L.setImageBitmap(null);
            this.f4444L = null;
        }
        if (this.f4449Q != null) {
            this.f4449Q.setImageBitmap(null);
            this.f4449Q = null;
            if (C4904y.f17872b) {
                C4904y.m18639b("[BuddyDialog] moreImgs is null ", f4430a);
            }
        }
        if (this.f4502at != null) {
            this.f4502at.setImageBitmap(null);
            this.f4502at = null;
        }
        super.onDestroy();
        this.f4531z = null;
    }

    /* renamed from: e */
    public void m7266e() {
        if (!C4822an.m18223b()) {
            if (C2349a.m10301a("sms_feature") && C3847e.m14686ar()) {
                Intent intentM15026c = C3892o.m15026c();
                if (intentM15026c != null) {
                    startActivity(intentM15026c);
                    C3892o.m15031e();
                    return;
                }
                return;
            }
            if (!C4822an.m18226c()) {
                C4884g.m18541a(this.f4531z, new DialogInterfaceOnClickListenerC1230h(this)).show();
                return;
            }
            return;
        }
        Intent intent = null;
        List listAsList = Arrays.asList(this.f4524s.m7044G().split(" "));
        if (listAsList.size() == 1) {
            Intent intent2 = new Intent("com.sec.chaton.smsplugin.SEND");
            ArrayList arrayList = new ArrayList();
            if (this.f4524s.m7043F() != null && this.f4524s.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                arrayList.add(this.f4524s.m7054c());
            } else {
                arrayList.addAll(Arrays.asList(this.f4524s.m7044G().split(" ")));
            }
            intent2.setFlags(67108864);
            intent2.putExtra("receiver_array", (String[]) arrayList.toArray(new String[0]));
            intent = intent2;
        } else if (listAsList.size() > 1) {
            intent = new Intent(GlobalApplication.m18732r(), (Class<?>) PhoneNumberSelectorDialog.class);
            intent.putExtra("PN_DIALOG_BUDDY_TYPE", 3);
            intent.putExtra("PN_DIALOG_BUDDY_NAME", this.f4524s.m7051b());
            if (this.f4524s.m7043F() != null && this.f4524s.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                intent.putExtra("PN_DIALOG_BUDDY_PHONE_NUMBERS", this.f4524s.m7054c());
            } else {
                intent.putExtra("PN_DIALOG_BUDDY_PHONE_NUMBERS", this.f4524s.m7044G());
                intent.putExtra("PN_DIALOG_BUDDY_HAS_EXTERNAL_PHONENUMBER_USE", true);
            }
        }
        if (intent != null) {
            startActivity(intent);
        }
        finish();
    }

    /* renamed from: B */
    private void m7139B() {
        Uri uri = null;
        List listAsList = Arrays.asList(this.f4524s.m7044G().split(" "));
        if (listAsList.size() == 1) {
            if (0 == 0) {
                uri = Uri.parse("tel:" + C3789h.m14307c((String) listAsList.get(0)));
            }
            C4904y.m18639b("Call Number: " + uri.toString(), f4430a);
            Intent intent = new Intent("android.intent.action.CALL", uri);
            C4892m.m18577c(true);
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
            finish();
            return;
        }
        if (listAsList.size() > 1) {
            Intent intent2 = new Intent(GlobalApplication.m18732r(), (Class<?>) PhoneNumberSelectorDialog.class);
            intent2.putExtra("PN_DIALOG_BUDDY_TYPE", 1);
            if (this.f4524s.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                intent2.putExtra("PN_DIALOG_BUDDY_PHONE_NUMBERS", this.f4524s.m7054c());
            } else {
                intent2.putExtra("PN_DIALOG_BUDDY_PHONE_NUMBERS", this.f4524s.m7044G());
                intent2.putExtra("PN_DIALOG_BUDDY_HAS_EXTERNAL_PHONENUMBER_USE", true);
            }
            startActivity(intent2);
            finish();
        }
    }

    /* renamed from: C */
    private void m7141C() throws Throwable {
        C4904y.m18639b("RAWCONTACTID: " + this.f4524s.m7061j() + ", mContactId: " + this.f4499aq, f4430a);
        C4892m.m18577c(true);
        List listAsList = Arrays.asList(this.f4524s.m7044G().split(" "));
        if (listAsList.size() == 1) {
            m7201d((String) listAsList.get(0));
            return;
        }
        if (listAsList.size() > 1) {
            Intent intent = new Intent(getApplicationContext(), (Class<?>) PhoneNumberSelectorDialog.class);
            intent.putExtra("PN_DIALOG_BUDDY_TYPE", 2);
            intent.putExtra("PN_DIALOG_BUDDY_NAME", this.f4524s.m7051b());
            intent.putExtra("PN_DIALOG_BUDDY_PHONE_NUMBERS", this.f4524s.m7044G());
            intent.putExtra("PN_DIALOG_BUDDY_HAS_EXTERNAL_PHONENUMBER_USE", true);
            if (this.f4524s.m7055d() != null) {
                intent.putExtra("PN_DIALOG_BUDDY_SAMSUNGEMAIL", this.f4524s.m7055d());
            }
            startActivity(intent);
            finish();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a6  */
    /* renamed from: D */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m7142D() throws android.content.res.Resources.NotFoundException {
        /*
            r9 = this;
            java.lang.String r2 = com.sec.chaton.util.C4822an.m18234f()
            com.sec.chaton.util.ab r0 = com.sec.chaton.util.C4809aa.m18104a()
            java.lang.String r1 = "country_code"
            java.lang.String r3 = ""
            java.lang.String r1 = r0.m18121a(r1, r3)
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 == 0) goto La6
            com.sec.chaton.util.ab r0 = com.sec.chaton.util.C4809aa.m18104a()
            java.lang.String r3 = "country_ISO"
            r4 = 0
            java.lang.String r0 = r0.m18121a(r3, r4)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L2e
            java.lang.String r0 = com.sec.chaton.util.C4822an.m18236g()
        L2e:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto La6
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            android.content.res.Resources r1 = r9.getResources()
            r4 = 2131558429(0x7f0d001d, float:1.8742174E38)
            java.lang.CharSequence[] r4 = r1.getTextArray(r4)
            android.content.res.Resources r1 = r9.getResources()
            r5 = 2131558430(0x7f0d001e, float:1.8742176E38)
            java.lang.CharSequence[] r5 = r1.getTextArray(r5)
            android.content.res.Resources r1 = r9.getResources()
            r6 = 2131558431(0x7f0d001f, float:1.8742178E38)
            java.lang.CharSequence[] r6 = r1.getTextArray(r6)
            r1 = 0
        L5b:
            int r7 = r4.length
            if (r1 >= r7) goto L68
            r7 = r6[r1]
            r8 = r5[r1]
            r3.put(r7, r8)
            int r1 = r1 + 1
            goto L5b
        L68:
            java.lang.String r0 = r0.toUpperCase()
            java.lang.Object r0 = r3.get(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
        L74:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto La4
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto La4
            boolean r1 = r2.contains(r0)
            if (r1 != 0) goto La4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "+"
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.StringBuilder r0 = r1.append(r0)
            r1 = 1
            java.lang.String r1 = r2.substring(r1)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
        La3:
            return r0
        La4:
            r0 = r2
            goto La3
        La6:
            r0 = r1
            goto L74
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.dialog.BuddyDialog.m7142D():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void m7145E() {
        this.f4470aL.setVisibility(0);
        this.f4473aO.setVisibility(0);
        this.f4473aO.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public void m7146F() {
        this.f4470aL.setVisibility(0);
        this.f4471aM.setVisibility(0);
        this.f4471aM.requestLayout();
        this.f4472aN.setVisibility(0);
        this.f4472aN.requestLayout();
    }
}
