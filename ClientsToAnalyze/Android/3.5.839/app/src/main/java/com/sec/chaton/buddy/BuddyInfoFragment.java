package com.sec.chaton.buddy;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.R;
import com.sec.chaton.account.C1002i;
import com.sec.chaton.buddy.dialog.PhoneNumberSelectorDialog;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.plugin.C2923b;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.userprofile.MyInfoFragment;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4884g;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class BuddyInfoFragment extends Fragment {

    /* renamed from: j */
    private static String f3830j = BuddyInfoFragment.class.getSimpleName();

    /* renamed from: A */
    private View f3831A;

    /* renamed from: B */
    private TextView f3832B;

    /* renamed from: C */
    private TextView f3833C;

    /* renamed from: D */
    private View f3834D;

    /* renamed from: E */
    private TextView f3835E;

    /* renamed from: F */
    private TextView f3836F;

    /* renamed from: G */
    private ImageView f3837G;

    /* renamed from: H */
    private ImageButton f3838H;

    /* renamed from: I */
    private ImageButton f3839I;

    /* renamed from: J */
    private ImageButton f3840J;

    /* renamed from: K */
    private ImageButton f3841K;

    /* renamed from: L */
    private ImageButton f3842L;

    /* renamed from: M */
    private ImageButton f3843M;

    /* renamed from: O */
    private Activity f3845O;

    /* renamed from: P */
    private boolean f3846P;

    /* renamed from: R */
    private boolean f3848R;

    /* renamed from: T */
    private C0416a f3850T;

    /* renamed from: U */
    private View f3851U;

    /* renamed from: V */
    private C2210x f3852V;

    /* renamed from: W */
    private String f3853W;

    /* renamed from: X */
    private String f3854X;

    /* renamed from: b */
    protected ViewGroup f3857b;

    /* renamed from: c */
    protected ViewGroup f3858c;

    /* renamed from: d */
    protected ViewGroup f3859d;

    /* renamed from: e */
    protected ImageView f3860e;

    /* renamed from: f */
    protected TextView f3861f;

    /* renamed from: k */
    private C1106c f3865k;

    /* renamed from: l */
    private String f3866l;

    /* renamed from: m */
    private String f3867m;

    /* renamed from: n */
    private String f3868n;

    /* renamed from: o */
    private String f3869o;

    /* renamed from: p */
    private int f3870p;

    /* renamed from: t */
    private Toast f3874t;

    /* renamed from: u */
    private View f3875u;

    /* renamed from: v */
    private TextView f3876v;

    /* renamed from: w */
    private TextView f3877w;

    /* renamed from: x */
    private View f3878x;

    /* renamed from: y */
    private TextView f3879y;

    /* renamed from: z */
    private TextView f3880z;

    /* renamed from: q */
    private List<String> f3871q = null;

    /* renamed from: r */
    private boolean f3872r = false;

    /* renamed from: s */
    private boolean f3873s = false;

    /* renamed from: N */
    private boolean f3844N = false;

    /* renamed from: Q */
    private boolean f3847Q = false;

    /* renamed from: S */
    private boolean f3849S = false;

    /* renamed from: a */
    boolean f3856a = false;

    /* renamed from: Y */
    private int f3855Y = 20;

    /* renamed from: g */
    Handler f3862g = new HandlerC1289ew(this);

    /* renamed from: h */
    View.OnClickListener f3863h = new ViewOnClickListenerC1300fg(this);

    /* renamed from: i */
    InterfaceC2211y f3864i = new C1301fh(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3852V = new C2210x(this.f3845O.getContentResolver(), this.f3864i);
        this.f3845O.setTitle(getText(R.string.mypage_info));
        this.f3874t = C5179v.m19811a(this.f3845O, (CharSequence) null, 0);
        this.f3866l = this.f3845O.getIntent().getExtras().getString("PROFILE_BUDDY_NO");
        this.f3867m = this.f3845O.getIntent().getExtras().getString("PROFILE_BUDDY_NAME");
        this.f3852V.startQuery(3, null, C2289i.m10166d(), null, "buddy_no = ? ", new String[]{this.f3866l}, null);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3850T = new C0416a();
        this.f3851U = layoutInflater.inflate(R.layout.layout_buddypage_info, viewGroup, false);
        this.f3857b = (ViewGroup) this.f3851U.findViewById(R.id.layout_profile_info);
        this.f3857b.setVisibility(8);
        this.f3858c = (ViewGroup) this.f3851U.findViewById(R.id.progress);
        this.f3858c.setVisibility(0);
        return this.f3851U;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6693d() throws NumberFormatException {
        int i;
        int i2 = 1;
        this.f3875u = this.f3851U.findViewById(R.id.layout_name);
        this.f3876v = (TextView) this.f3875u.findViewById(R.id.title);
        this.f3877w = (TextView) this.f3875u.findViewById(R.id.content);
        this.f3876v.setText(R.string.mypage_profile_name);
        this.f3877w.setText(this.f3865k.m7051b());
        this.f3878x = this.f3851U.findViewById(R.id.layout_phone);
        this.f3879y = (TextView) this.f3878x.findViewById(R.id.title);
        this.f3880z = (TextView) this.f3878x.findViewById(R.id.content);
        this.f3879y.setText(R.string.buddy_phone_number);
        this.f3831A = this.f3851U.findViewById(R.id.layout_account);
        this.f3832B = (TextView) this.f3831A.findViewById(R.id.title);
        this.f3833C = (TextView) this.f3831A.findViewById(R.id.content);
        this.f3832B.setText(R.string.setting_account);
        this.f3834D = this.f3851U.findViewById(R.id.layout_birthday);
        this.f3835E = (TextView) this.f3834D.findViewById(R.id.title);
        this.f3836F = (TextView) this.f3834D.findViewById(R.id.content);
        this.f3837G = (ImageView) this.f3834D.findViewById(R.id.icon);
        this.f3835E.setText(R.string.setting_birthday);
        this.f3837G.setBackgroundResource(R.drawable.profile_birthday_ic);
        this.f3859d = (ViewGroup) this.f3851U.findViewById(R.id.info_sns_account);
        this.f3860e = (ImageView) this.f3859d.findViewById(R.id.sns_info_type);
        this.f3861f = (TextView) this.f3859d.findViewById(R.id.sns_info_name);
        if (TextUtils.isEmpty(this.f3853W)) {
            this.f3859d.setVisibility(8);
        } else {
            if (C4368e.f15815a.equalsIgnoreCase(this.f3853W)) {
                this.f3860e.setImageDrawable(getResources().getDrawable(R.drawable.profile_info_ic_facebook));
            } else if (C4368e.f15817c.equalsIgnoreCase(this.f3853W)) {
                this.f3860e.setImageDrawable(getResources().getDrawable(R.drawable.profile_info_ic_weibo));
            }
            this.f3861f.setText(this.f3854X);
        }
        this.f3875u.setOnClickListener(new ViewOnClickListenerC1294fa(this));
        if (isAdded()) {
            this.f3834D.setEnabled(false);
            this.f3837G.setVisibility(8);
        } else {
            this.f3834D.setEnabled(true);
            this.f3837G.setVisibility(0);
        }
        this.f3838H = (ImageButton) this.f3851U.findViewById(R.id.profile_chat);
        this.f3838H.setOnTouchListener(new ViewOnTouchListenerC1295fb(this));
        this.f3839I = (ImageButton) this.f3851U.findViewById(R.id.profile_sms);
        this.f3839I.setOnTouchListener(new ViewOnTouchListenerC1296fc(this));
        this.f3840J = (ImageButton) this.f3851U.findViewById(R.id.profile_call);
        this.f3840J.setOnTouchListener(new ViewOnTouchListenerC1297fd(this));
        this.f3841K = (ImageButton) this.f3851U.findViewById(R.id.profile_contact);
        this.f3841K.setOnTouchListener(new ViewOnTouchListenerC1298fe(this));
        this.f3842L = (ImageButton) this.f3851U.findViewById(R.id.profile_v_voice);
        this.f3842L.setOnClickListener(this.f3863h);
        this.f3842L.setVisibility(8);
        this.f3843M = (ImageButton) this.f3851U.findViewById(R.id.profile_v_video);
        this.f3843M.setOnClickListener(this.f3863h);
        this.f3843M.setVisibility(8);
        this.f3838H.setOnClickListener(this.f3863h);
        this.f3840J.setOnClickListener(this.f3863h);
        this.f3841K.setOnClickListener(this.f3863h);
        this.f3839I.setOnClickListener(this.f3863h);
        if (C2349a.m10301a("sms_feature")) {
            this.f3841K.setVisibility(8);
        } else {
            this.f3839I.setVisibility(8);
        }
        m6717n();
        C4904y.m18639b("************** BIRTHDAY : " + this.f3865k.m7059h(), f3830j);
        if (this.f3865k.m7059h().equals("0000-12-31") || this.f3865k.m7059h().length() == 0) {
            this.f3834D.setVisibility(8);
            View viewFindViewById = this.f3851U.findViewById(R.id.buddypage_scrollview);
            viewFindViewById.setFocusable(false);
            viewFindViewById.setFocusableInTouchMode(false);
        } else if (this.f3865k.m7059h() != null && !TextUtils.isEmpty(this.f3865k.m7059h())) {
            String strReplaceAll = this.f3865k.m7059h().replaceAll(" ", "");
            String strM17841a = MyInfoFragment.m17841a(strReplaceAll);
            if ((strReplaceAll.length() == 5 || strReplaceAll.length() == 10) && strM17841a.length() > 0) {
                this.f3836F.setText(strM17841a);
                this.f3834D.setContentDescription(strM17841a);
                this.f3834D.setOnClickListener(new ViewOnClickListenerC1299ff(this));
                this.f3837G.setVisibility(0);
                this.f3868n = this.f3865k.m7051b();
                m6733a();
            } else {
                this.f3837G.setVisibility(8);
                this.f3834D.setOnClickListener(null);
            }
        }
        int iM7065n = this.f3865k.m7065n() > 0 ? this.f3865k.m7065n() : 0;
        int iM7064m = this.f3865k.m7064m() > 0 ? this.f3865k.m7064m() : 0;
        if (iM7065n == 0 && iM7064m == 0) {
            i = 1;
        } else {
            i2 = iM7065n;
            i = iM7064m;
        }
        if (i2 <= i && i > i2) {
        }
        this.f3858c.setVisibility(8);
        this.f3857b.setVisibility(0);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3845O = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3845O = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m6733a();
        if (this.f3847Q && this.f3869o != null) {
            this.f3852V.startQuery(6, null, Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(this.f3869o)), null, null, null, null);
            this.f3847Q = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f3852V != null) {
            this.f3852V.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public boolean m6698e() {
        boolean z = false;
        if (this.f3865k != null) {
            try {
                if (!TextUtils.isEmpty(this.f3865k.m7058g())) {
                    String strM7040C = this.f3865k.m7040C();
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
        C4904y.m18639b("isChatONVBuddy() : " + z, f3830j);
        return z;
    }

    /* renamed from: f */
    private boolean m6701f() {
        boolean z = false;
        try {
            if (C2923b.m12153h(this.f3845O.getApplicationContext())) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C4904y.m18639b("isChatONVSupportedDevice : " + z, f3830j);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public boolean m6703g() {
        boolean z = false;
        try {
            if (C2948h.m12190a().m12192a(this.f3845O.getApplicationContext(), EnumC2949i.ChatONV)) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C4904y.m18639b("isChatONVAvaiable : " + z, f3830j);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public boolean m6704h() {
        boolean z = false;
        try {
            C0416a c0416a = this.f3850T;
            if (C0416a.m1477b(this.f3845O.getApplicationContext())) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C4904y.m18639b("isChatONVInstalled : " + z, f3830j);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public boolean m6706i() {
        boolean zM1495d;
        Exception e;
        try {
            zM1495d = this.f3850T.m1495d(this.f3845O.getApplicationContext());
            try {
                C4904y.m18639b("isReadyToCall : " + zM1495d, f3830j);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                C4904y.m18639b("isChatONVReadyToCall : " + zM1495d, f3830j);
                return zM1495d;
            }
        } catch (Exception e3) {
            zM1495d = false;
            e = e3;
        }
        C4904y.m18639b("isChatONVReadyToCall : " + zM1495d, f3830j);
        return zM1495d;
    }

    /* renamed from: j */
    private boolean m6708j() {
        if (this.f3845O == null) {
            return false;
        }
        boolean zM6678a = ((TelephonyManager) this.f3845O.getApplicationContext().getSystemService("phone")).getPhoneType() == 0 ? false : m6678a(this.f3845O, new Intent("android.intent.action.CALL", Uri.parse("tel:+000")));
        C4904y.m18639b("is3GCallAvailable : " + zM6678a, f3830j);
        return zM6678a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public boolean m6710k() {
        int iM10677a = C2471v.m10677a(this.f3845O.getApplicationContext());
        if (-3 != iM10677a && -2 != iM10677a) {
            return true;
        }
        C5179v.m19810a(this.f3845O.getApplicationContext(), R.string.popup_no_network_connection, 0).show();
        return false;
    }

    /* renamed from: l */
    private void m6712l() {
        this.f3839I.setVisibility(0);
        this.f3838H.setVisibility(8);
        this.f3841K.setVisibility(8);
    }

    /* renamed from: m */
    private void m6715m() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        boolean z4 = this.f3865k.m7039B() != 0;
        if (z4) {
            C4904y.m18639b("processNoChatONVCase : buddyPhoneNumberAvailable = " + z4, f3830j);
            boolean zM6708j = m6708j();
            if (zM6708j || !m6678a(this.f3845O, new Intent("android.intent.action.SENDTO", Uri.parse("smsto:+000")))) {
                z = zM6708j;
                z2 = false;
            } else {
                z = zM6708j;
                z2 = true;
            }
        } else {
            z = z4;
            z2 = false;
        }
        if (m6680a(this.f3866l)) {
            z3 = z;
        } else if (z && m6718o()) {
            C4904y.m18639b("processNoChatONVCase : buddyPhoneNumberAvailable2 = true", f3830j);
        } else {
            z3 = false;
        }
        C4904y.m18639b("processNoChatONVCase : buddyPhoneNumberAvailable = " + z3 + " @ isContactShow = " + z2, f3830j);
        m6677a(z3, z2);
    }

    /* renamed from: a */
    private void m6677a(boolean z, boolean z2) {
        if (!z) {
            if (z2) {
                this.f3840J.setVisibility(8);
                if (C2349a.m10301a("sms_feature")) {
                    this.f3839I.setVisibility(8);
                    return;
                } else {
                    this.f3841K.setVisibility(0);
                    return;
                }
            }
            this.f3840J.setVisibility(8);
            this.f3841K.setVisibility(8);
            this.f3839I.setVisibility(8);
        }
    }

    /* renamed from: b */
    private void m6684b(boolean z, boolean z2) {
        C4904y.m18639b("drawVButtons : buddyPhoneNumberAvailable = " + z, f3830j);
        if (z) {
            this.f3840J.setVisibility(0);
            this.f3842L.setVisibility(0);
            this.f3843M.setVisibility(0);
            if (C2349a.m10301a("sms_feature")) {
                this.f3839I.setVisibility(0);
                return;
            } else {
                this.f3841K.setVisibility(8);
                return;
            }
        }
        if (z2) {
            this.f3840J.setVisibility(8);
            this.f3842L.setVisibility(0);
            this.f3843M.setVisibility(0);
            if (C2349a.m10301a("sms_feature")) {
                this.f3839I.setVisibility(8);
                return;
            } else {
                this.f3841K.setVisibility(0);
                return;
            }
        }
        this.f3840J.setVisibility(8);
        this.f3841K.setVisibility(8);
        this.f3839I.setVisibility(8);
        this.f3842L.setVisibility(0);
        this.f3843M.setVisibility(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007f A[PHI: r10
  0x007f: PHI (r10v1 boolean) = (r10v0 boolean), (r10v3 boolean), (r10v3 boolean) binds: [B:3:0x000e, B:5:0x002d, B:7:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m6676a(boolean r10) {
        /*
            r9 = this;
            r1 = 1
            r2 = 0
            boolean r3 = r9.m6701f()
            boolean r4 = r9.m6703g()
            boolean r5 = r9.m6706i()
            if (r10 == 0) goto L7f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "processMultiDeviceCase : buddyPhoneNumberAvailable = "
            java.lang.StringBuilder r0 = r0.append(r6)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = com.sec.chaton.buddy.BuddyInfoFragment.f3830j
            com.sec.chaton.util.C4904y.m18639b(r0, r6)
            boolean r10 = r9.m6708j()
            if (r10 != 0) goto L7f
            android.app.Activity r0 = r9.f3845O
            android.content.Intent r6 = new android.content.Intent
            java.lang.String r7 = "android.intent.action.SENDTO"
            java.lang.String r8 = "smsto:+000"
            android.net.Uri r8 = android.net.Uri.parse(r8)
            r6.<init>(r7, r8)
            boolean r0 = m6678a(r0, r6)
            if (r0 == 0) goto L7f
            r0 = r1
        L47:
            boolean r6 = r9.m6698e()
            if (r3 == 0) goto L69
            if (r4 == 0) goto L69
            if (r5 == 0) goto L5d
            if (r6 == 0) goto L59
            r9.m6684b(r10, r0)
            r9.f3873s = r1
        L58:
            return
        L59:
            r9.m6677a(r10, r0)
            goto L58
        L5d:
            if (r6 == 0) goto L65
            r9.m6684b(r10, r0)
            r9.f3873s = r2
            goto L58
        L65:
            r9.m6677a(r10, r0)
            goto L58
        L69:
            if (r3 == 0) goto L7b
            boolean r1 = r9.m6704h()
            if (r1 != 0) goto L77
            if (r6 == 0) goto L77
            r9.m6684b(r10, r0)
            goto L58
        L77:
            r9.m6677a(r10, r0)
            goto L58
        L7b:
            r9.m6677a(r10, r0)
            goto L58
        L7f:
            r0 = r2
            goto L47
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyInfoFragment.m6676a(boolean):void");
    }

    /* renamed from: n */
    private void m6717n() {
        if (this.f3865k != null) {
            boolean z = this.f3865k.m7039B() != 0;
            C4904y.m18639b("showphonenumber : " + z + " @ getShowPhoneNumber : " + this.f3865k.m7039B(), f3830j);
            if (this.f3865k.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                C4904y.m18639b("refreshCommunicationButtons : is lite feature user", f3830j);
                this.f3831A.setVisibility(8);
                m6712l();
            } else if (!this.f3846P) {
                C4904y.m18639b("refreshCommunicationButtons : is not multi-device", f3830j);
                this.f3831A.setVisibility(8);
                m6715m();
            } else {
                C4904y.m18639b("refreshCommunicationButtons : is multi-device", f3830j);
                z = m6725r().size() != 0;
                m6676a(z);
                if (!TextUtils.isEmpty(this.f3865k.m7055d())) {
                    this.f3831A.setVisibility(0);
                    this.f3833C.setText(this.f3865k.m7055d());
                    this.f3833C.setSelected(true);
                } else {
                    this.f3831A.setVisibility(8);
                }
            }
            if (!this.f3846P && !m6680a(this.f3866l)) {
                z = z && m6718o();
            }
            if (z) {
                if (this.f3871q.size() >= 1) {
                    this.f3880z.setText(this.f3865k.m7044G().replaceAll(" ", "\n"));
                    this.f3878x.setVisibility(0);
                    return;
                } else {
                    this.f3878x.setVisibility(8);
                    return;
                }
            }
            this.f3878x.setVisibility(8);
        }
    }

    /* renamed from: a */
    private boolean m6680a(String str) {
        if (str.length() >= 19 && str.startsWith("10")) {
            C4904y.m18639b("chaton id : " + str, f3830j);
            return false;
        }
        if (str.startsWith(Spam.ACTIVITY_CANCEL)) {
            C4904y.m18639b("pin number : " + str, f3830j);
            return false;
        }
        C4904y.m18639b("phone number: " + str, f3830j);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6683b(String str) {
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        if (!this.f3848R) {
            m6675a(uri, str);
            return;
        }
        long jM6055a = (this.f3846P || this.f3849S) ? 0L : C1002i.m6055a(this.f3865k.m7061j());
        if (jM6055a == 0) {
            jM6055a = this.f3870p;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(uri + "/" + jM6055a));
        try {
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException e) {
            C4904y.m18635a(e, getClass().getSimpleName());
            C5179v.m19810a(this.f3845O, R.string.toast_contact_not_found, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public boolean m6718o() {
        if (this.f3866l.length() < 19 || !this.f3866l.startsWith("10") || TextUtils.isEmpty(this.f3865k.m7056e())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6689c(String str) {
        AbstractC4932a.m18733a(this.f3845O).mo18740a(getResources().getString(R.string.buddy_profile_birthday)).mo18749b(String.format(getResources().getString(R.string.buddy_profile_dialog_addbuddy_birthday_to_calendar), this.f3867m)).mo18741a(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1290ex(this, str)).mo18752b();
    }

    /* renamed from: a */
    private void m6675a(Uri uri, String str) {
        AbstractC4932a.m18733a(this.f3845O).mo18740a(getResources().getString(R.string.popup_media_contact)).mo18749b(getResources().getString(R.string.buddy_profile_dialog_addbuddy_phonenumber_to_contact)).mo18741a(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1291ey(this, str, uri)).mo18752b();
    }

    /* renamed from: a */
    public void m6733a() {
        if (this.f3865k != null && !this.f3865k.m7059h().equals("0000-12-31") && this.f3865k.m7059h().length() != 0 && this.f3865k.m7059h() != null && !TextUtils.isEmpty(this.f3865k.m7059h())) {
            String strReplaceAll = this.f3865k.m7059h().replaceAll(" ", "");
            if (strReplaceAll != null && strReplaceAll.length() == 10) {
                strReplaceAll = strReplaceAll.substring(5);
            }
            new AsyncTaskC1302fi(this).execute(strReplaceAll);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public Uri m6691d(String str) {
        try {
            int iM6720p = m6720p();
            if (iM6720p <= 0) {
                return null;
            }
            return m6669a(iM6720p, this.f3868n, str);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: p */
    private int m6720p() throws NumberFormatException {
        int i;
        String[] strArr = {"_id", "name"};
        String str = "selected=1";
        if (Build.VERSION.SDK_INT >= 14) {
            str = null;
        }
        Cursor cursorM6668a = m6668a(strArr, str, "calendars");
        if (cursorM6668a == null || !cursorM6668a.moveToFirst()) {
            i = 0;
        } else {
            int columnIndex = cursorM6668a.getColumnIndex("name");
            int columnIndex2 = cursorM6668a.getColumnIndex("_id");
            do {
                String string = cursorM6668a.getString(columnIndex);
                String string2 = cursorM6668a.getString(columnIndex2);
                if (string != null) {
                    i = Integer.parseInt(string2);
                    break;
                }
            } while (cursorM6668a.moveToNext());
            i = 0;
        }
        if (cursorM6668a != null) {
            cursorM6668a.close();
        }
        return i;
    }

    /* renamed from: a */
    private Cursor m6668a(String[] strArr, String str, String str2) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = this.f3845O.getContentResolver().query(Uri.parse("content://calendar/" + str2), strArr, str, null, null);
        } catch (IllegalArgumentException e) {
        }
        if (cursorQuery != null) {
            return cursorQuery;
        }
        try {
            return this.f3845O.getContentResolver().query(Uri.parse("content://com.android.calendar/" + str2), strArr, str, null, null);
        } catch (IllegalArgumentException e2) {
            return cursorQuery;
        }
    }

    @TargetApi(14)
    /* renamed from: a */
    private Uri m6669a(int i, String str, String str2) {
        Calendar calendar = Calendar.getInstance();
        String str3 = String.valueOf(calendar.get(1)) + "-" + str2;
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(str3));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(str3));
        this.f3855Y = 2036 - Calendar.getInstance().get(1);
        calendar2.add(1, this.f3855Y);
        String str4 = new SimpleDateFormat("yyyyMMdd").format(calendar2.getTime());
        ContentValues contentValues = new ContentValues();
        if (Build.VERSION.SDK_INT < 14) {
            contentValues.put("calendar_id", Integer.valueOf(i));
            contentValues.put("title", String.format(getString(R.string.buddy_profile_save_birthday_calendar_title), str));
            contentValues.put("dtstart", Long.valueOf(calendar.getTimeInMillis() + calendar.getTimeZone().getRawOffset()));
            contentValues.put("eventTimezone", calendar.getTimeZone().getID());
            contentValues.put("duration", "P1D");
            contentValues.put("allDay", (Integer) 1);
            contentValues.put("visibility", (Integer) 0);
            contentValues.put("transparency", (Integer) 0);
            contentValues.put("hasAlarm", (Integer) 0);
            contentValues.put("hasExtendedProperties", (Integer) 1);
            contentValues.put("hasAttendeeData", (Integer) 1);
            if (str2.contains("02-29")) {
                contentValues.put("rrule", "FREQ=YEARLY;INTERVAL=4;UNTIL=" + str4 + ";WKST=SU;BYMONTHDAY=" + calendar.get(5) + ";BYMONTH=" + (calendar.get(2) + 1));
            } else {
                contentValues.put("rrule", "FREQ=YEARLY;UNTIL=" + str4 + ";WKST=SU;BYMONTHDAY=" + calendar.get(5) + ";BYMONTH=" + (calendar.get(2) + 1));
            }
            contentValues.put("lastDate", Long.valueOf(calendar2.getTimeInMillis()));
            return this.f3845O.getContentResolver().insert(Uri.parse(m6722q() + "events"), contentValues);
        }
        contentValues.put("calendar_id", Integer.valueOf(i));
        contentValues.put("title", String.format(getString(R.string.buddy_profile_save_birthday_calendar_title), str));
        contentValues.put("dtstart", Long.valueOf(calendar.getTimeInMillis() + calendar.getTimeZone().getRawOffset()));
        contentValues.put("eventTimezone", calendar.getTimeZone().getID());
        contentValues.put("duration", "P1D");
        contentValues.put("allDay", (Integer) 1);
        contentValues.put("hasAlarm", (Integer) 0);
        contentValues.put("hasExtendedProperties", (Integer) 1);
        contentValues.put("hasAttendeeData", (Integer) 1);
        if (str2.contains("02-29")) {
            contentValues.put("rrule", "FREQ=YEARLY;INTERVAL=4;UNTIL=" + str4 + ";WKST=SU;BYMONTHDAY=" + calendar.get(5) + ";BYMONTH=" + (calendar.get(2) + 1));
        } else {
            contentValues.put("rrule", "FREQ=YEARLY;UNTIL=" + str4 + ";WKST=SU;BYMONTHDAY=" + calendar.get(5) + ";BYMONTH=" + (calendar.get(2) + 1));
        }
        contentValues.put("lastDate", Long.valueOf(calendar2.getTimeInMillis()));
        return this.f3845O.getContentResolver().insert(CalendarContract.Events.CONTENT_URI, contentValues);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m6673a(String str, long j, long j2) throws Throwable {
        Cursor cursor;
        String str2;
        String str3 = str + "'s birthday";
        Cursor cursor2 = null;
        try {
            Cursor cursorQuery = this.f3845O.getContentResolver().query(Uri.parse("content://com.android.calendar/events"), new String[]{"calendar_id", "title", "description", "dtstart", "dtend", "eventLocation", "deleted"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    cursorQuery.moveToFirst();
                    int count = cursorQuery.getCount();
                    boolean z = false;
                    for (int i = 0; i < count; i++) {
                        Date date = new Date(j);
                        Date date2 = new Date(cursorQuery.getLong(3));
                        int i2 = cursorQuery.getInt(6);
                        if (date.compareTo(date2) == 0 && i2 == 0) {
                            z = true;
                        }
                        if (str3.equals(cursorQuery.getString(1)) && z) {
                            str2 = "Success";
                            break;
                        }
                        cursorQuery.moveToNext();
                    }
                    str2 = "UnSuccess";
                } catch (IllegalArgumentException e) {
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return "UnSuccess";
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursorQuery;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } else {
                str2 = "UnSuccess";
            }
            if (cursorQuery == null) {
                return str2;
            }
            cursorQuery.close();
            return str2;
        } catch (IllegalArgumentException e2) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: q */
    private String m6722q() {
        String str;
        Cursor cursor;
        Cursor cursor2 = null;
        String str2 = null;
        byte b2 = 0;
        try {
            Cursor cursorQuery = this.f3845O.getContentResolver().query(Uri.parse("content://calendar/calendars"), null, null, null, null);
            if (cursorQuery != null) {
                cursorQuery.close();
                str2 = "content://calendar/";
            }
            cursor = cursorQuery;
        } catch (Exception e) {
            if (0 != 0) {
                (b2 == true ? 1 : 0).close();
                str = "content://calendar/";
            } else {
                str = null;
            }
            cursor = null;
            str2 = str;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor2.close();
            }
            throw th;
        }
        if (str2 == null) {
            try {
                Cursor cursorQuery2 = this.f3845O.getContentResolver().query(Uri.parse("content://com.android.calendar/calendars"), null, null, null, null);
                if (cursorQuery2 != null) {
                    cursorQuery2.close();
                    return "content://com.android.calendar/";
                }
            } catch (Exception e2) {
                if (cursor != null) {
                    cursor.close();
                    return "content://com.android.calendar/";
                }
            } catch (Throwable th2) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public List<String> m6725r() {
        ArrayList arrayList = new ArrayList();
        String strM7057f = this.f3865k.m7057f();
        if (!TextUtils.isEmpty(strM7057f)) {
            StringTokenizer stringTokenizer = new StringTokenizer(strM7057f, "|");
            while (stringTokenizer.hasMoreTokens()) {
                new String();
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.length() >= 19 && strNextToken.startsWith("10")) {
                    C4904y.m18639b("chaton id : " + strNextToken, f3830j);
                } else if (strNextToken.startsWith(Spam.ACTIVITY_CANCEL)) {
                    C4904y.m18639b("pin number : " + strNextToken, f3830j);
                } else {
                    C4904y.m18639b("msisdn: " + strNextToken, f3830j);
                    arrayList.add(strNextToken);
                }
            }
        }
        return arrayList;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 5) {
            if (!this.f3848R && this.f3869o != null) {
                this.f3852V.startQuery(6, null, Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(this.f3869o)), null, null, null, null);
                return;
            }
            return;
        }
        if (i == 7 && i2 == -1) {
            C4904y.m18646e("PROFILE_EDIT_BUDDY_NAME", f3830j);
            String string = intent.getExtras().getString("PROFILE_BUDDY_RENAME");
            this.f3867m = string;
            this.f3868n = string;
            this.f3877w.setText(this.f3867m);
            Intent intent2 = new Intent();
            intent2.putExtra("PROFILE_BUDDY_RENAME", this.f3867m);
            this.f3845O.setResult(-1, intent2);
        }
    }

    /* renamed from: a */
    public static boolean m6678a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    /* renamed from: b */
    public void m6734b() {
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
                C4884g.m18541a(this.f3845O, new DialogInterfaceOnClickListenerC1292ez(this)).show();
                return;
            }
            return;
        }
        Intent intent = null;
        List listAsList = Arrays.asList(this.f3865k.m7044G().split(" "));
        if (listAsList.size() == 1) {
            Intent intent2 = new Intent("com.sec.chaton.smsplugin.SEND");
            ArrayList arrayList = new ArrayList();
            if (this.f3865k.m7043F() != null && this.f3865k.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                arrayList.add(this.f3865k.m7054c());
            } else {
                arrayList.addAll(Arrays.asList(this.f3865k.m7044G().split(" ")));
            }
            intent2.setFlags(67108864);
            intent2.putExtra("receiver_array", (String[]) arrayList.toArray(new String[0]));
            intent = intent2;
        } else if (listAsList.size() > 1) {
            intent = new Intent(GlobalApplication.m18732r(), (Class<?>) PhoneNumberSelectorDialog.class);
            intent.putExtra("PN_DIALOG_BUDDY_TYPE", 3);
            intent.putExtra("PN_DIALOG_BUDDY_NAME", this.f3865k.m7051b());
            if (this.f3865k.m7043F() != null && this.f3865k.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                intent.putExtra("PN_DIALOG_BUDDY_PHONE_NUMBERS", this.f3865k.m7054c());
            } else {
                intent.putExtra("PN_DIALOG_BUDDY_PHONE_NUMBERS", this.f3865k.m7044G());
                intent.putExtra("PN_DIALOG_BUDDY_HAS_EXTERNAL_PHONENUMBER_USE", true);
            }
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
