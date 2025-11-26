package com.sec.chaton.buddy;

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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.sso.p006a.C0045a;
import com.sec.chaton.R;
import com.sec.chaton.account.C0423i;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.plugin.C1948a;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.userprofile.MyInfoFragment;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class BuddyInfoFragment extends Fragment {

    /* renamed from: d */
    private static String f1952d = BuddyInfoFragment.class.getSimpleName();

    /* renamed from: A */
    private ImageButton f1953A;

    /* renamed from: B */
    private ImageButton f1954B;

    /* renamed from: C */
    private View f1955C;

    /* renamed from: D */
    private View f1956D;

    /* renamed from: E */
    private View f1957E;

    /* renamed from: F */
    private View f1958F;

    /* renamed from: G */
    private ImageButton f1959G;

    /* renamed from: H */
    private ImageButton f1960H;

    /* renamed from: I */
    private ImageButton f1961I;

    /* renamed from: K */
    private Activity f1963K;

    /* renamed from: L */
    private boolean f1964L;

    /* renamed from: N */
    private boolean f1966N;

    /* renamed from: P */
    private C0045a f1968P;

    /* renamed from: Q */
    private View f1969Q;

    /* renamed from: R */
    private C1377u f1970R;

    /* renamed from: e */
    private C0513c f1975e;

    /* renamed from: f */
    private String f1976f;

    /* renamed from: g */
    private String f1977g;

    /* renamed from: h */
    private String f1978h;

    /* renamed from: i */
    private String f1979i;

    /* renamed from: j */
    private int f1980j;

    /* renamed from: m */
    private Toast f1983m;

    /* renamed from: n */
    private LinearLayout f1984n;

    /* renamed from: o */
    private LinearLayout f1985o;

    /* renamed from: p */
    private LinearLayout f1986p;

    /* renamed from: q */
    private LinearLayout f1987q;

    /* renamed from: r */
    private TextView f1988r;

    /* renamed from: s */
    private TextView f1989s;

    /* renamed from: t */
    private TextView f1990t;

    /* renamed from: u */
    private TextView f1991u;

    /* renamed from: v */
    private LinearLayout f1992v;

    /* renamed from: w */
    private TextView f1993w;

    /* renamed from: x */
    private LinearLayout f1994x;

    /* renamed from: y */
    private ImageView f1995y;

    /* renamed from: z */
    private TextView f1996z;

    /* renamed from: k */
    private boolean f1981k = false;

    /* renamed from: l */
    private boolean f1982l = false;

    /* renamed from: J */
    private boolean f1962J = false;

    /* renamed from: M */
    private boolean f1965M = false;

    /* renamed from: O */
    private boolean f1967O = false;

    /* renamed from: a */
    boolean f1972a = false;

    /* renamed from: S */
    private int f1971S = 20;

    /* renamed from: b */
    View.OnClickListener f1973b = new ViewOnClickListenerC0669eg(this);

    /* renamed from: c */
    InterfaceC1378v f1974c = new C0670eh(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1970R = new C1377u(this.f1963K.getContentResolver(), this.f1974c);
        this.f1963K.setTitle(getText(R.string.mypage_info));
        this.f1983m = C3641ai.m13211a(this.f1963K, (CharSequence) null, 0);
        this.f1976f = this.f1963K.getIntent().getExtras().getString("PROFILE_BUDDY_NO");
        this.f1977g = this.f1963K.getIntent().getExtras().getString("PROFILE_BUDDY_NAME");
        this.f1970R.startQuery(3, null, C1441i.m6310c(), null, "buddy_no = ? ", new String[]{this.f1976f}, null);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1968P = new C0045a();
        this.f1969Q = layoutInflater.inflate(R.layout.layout_buddypage_info, viewGroup, false);
        return this.f1969Q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3533c() throws NumberFormatException {
        int i;
        int i2 = 1;
        this.f1984n = (LinearLayout) this.f1969Q.findViewById(R.id.layout_profile_phone_no);
        this.f1988r = (TextView) this.f1984n.findViewById(R.id.profile_phone_num);
        this.f1985o = (LinearLayout) this.f1969Q.findViewById(R.id.layout_profile_phone_no2);
        this.f1989s = (TextView) this.f1985o.findViewById(R.id.profile_phone_num2);
        this.f1986p = (LinearLayout) this.f1969Q.findViewById(R.id.layout_profile_phone_no3);
        this.f1990t = (TextView) this.f1986p.findViewById(R.id.profile_phone_num3);
        this.f1987q = (LinearLayout) this.f1969Q.findViewById(R.id.layout_profile_phone_no4);
        this.f1991u = (TextView) this.f1987q.findViewById(R.id.profile_phone_num4);
        this.f1992v = (LinearLayout) this.f1969Q.findViewById(R.id.layout_profile_samsung_email);
        this.f1993w = (TextView) this.f1992v.findViewById(R.id.samsung_email_address);
        this.f1994x = (LinearLayout) this.f1969Q.findViewById(R.id.layout_profile_birthday);
        this.f1996z = (TextView) this.f1994x.findViewById(R.id.profile_birthday);
        this.f1995y = (ImageView) this.f1994x.findViewById(R.id.birthday_add_icon);
        this.f1995y.setEnabled(false);
        this.f1995y.setImageDrawable(getResources().getDrawable(R.drawable.list_ic_add_disable));
        this.f1953A = (ImageButton) this.f1969Q.findViewById(R.id.profile_chat);
        this.f1953A.setOnTouchListener(new ViewOnTouchListenerC0661dz(this));
        this.f1954B = (ImageButton) this.f1969Q.findViewById(R.id.profile_call);
        this.f1954B.setOnTouchListener(new ViewOnTouchListenerC0664eb(this));
        this.f1955C = this.f1969Q.findViewById(R.id.profile_call_divider);
        this.f1956D = this.f1969Q.findViewById(R.id.profile_contact_divider);
        this.f1959G = (ImageButton) this.f1969Q.findViewById(R.id.profile_contact);
        this.f1959G.setOnTouchListener(new ViewOnTouchListenerC0665ec(this));
        this.f1960H = (ImageButton) this.f1969Q.findViewById(R.id.profile_v_voice);
        this.f1960H.setOnClickListener(this.f1973b);
        this.f1960H.setVisibility(8);
        this.f1961I = (ImageButton) this.f1969Q.findViewById(R.id.profile_v_video);
        this.f1961I.setOnClickListener(this.f1973b);
        this.f1961I.setVisibility(8);
        this.f1957E = this.f1969Q.findViewById(R.id.profile_v_voice_divider);
        this.f1957E.setVisibility(8);
        this.f1958F = this.f1969Q.findViewById(R.id.profile_v_video_divider);
        this.f1958F.setVisibility(8);
        this.f1953A.setOnClickListener(this.f1973b);
        this.f1954B.setOnClickListener(this.f1973b);
        this.f1959G.setOnClickListener(this.f1973b);
        if (this.f1975e.m3966C() == 0) {
            this.f1959G.setVisibility(8);
        } else {
            this.f1959G.setVisibility(0);
        }
        m3555l();
        if (!this.f1964L) {
            if (this.f1967O) {
                this.f1988r.setText(this.f1979i);
                this.f1984n.setContentDescription(this.f1979i);
            } else {
                this.f1988r.setText("+" + this.f1976f);
                this.f1984n.setContentDescription(this.f1976f);
            }
            this.f1984n.setOnTouchListener(new ViewOnTouchListenerC0666ed(this));
        } else {
            List<String> listM3563p = m3563p();
            if (listM3563p.size() == 4) {
                this.f1988r.setText("+" + listM3563p.get(0));
                this.f1989s.setText("+" + listM3563p.get(1));
                this.f1990t.setText("+" + listM3563p.get(2));
                this.f1991u.setText("+" + listM3563p.get(3));
            } else if (listM3563p.size() == 3) {
                this.f1988r.setText("+" + listM3563p.get(0));
                this.f1989s.setText("+" + listM3563p.get(1));
                this.f1990t.setText("+" + listM3563p.get(2));
            } else if (listM3563p.size() == 2) {
                this.f1988r.setText("+" + listM3563p.get(0));
                this.f1989s.setText("+" + listM3563p.get(1));
            } else if (listM3563p.size() == 1) {
                this.f1988r.setText("+" + listM3563p.get(0));
            }
        }
        C3250y.m11450b("************** BIRTHDAY : " + this.f1975e.m3982i(), f1952d);
        if (this.f1975e.m3982i().equals("0000-12-31") || this.f1975e.m3982i().length() == 0) {
            this.f1994x.setVisibility(8);
        } else if (this.f1975e.m3982i() != null && !TextUtils.isEmpty(this.f1975e.m3982i())) {
            String strReplaceAll = this.f1975e.m3982i().replaceAll(" ", "");
            String strM10678b = MyInfoFragment.m10678b(strReplaceAll);
            if ((strReplaceAll.length() == 5 || strReplaceAll.length() == 10) && strM10678b.length() > 0) {
                this.f1996z.setText(strM10678b);
                this.f1994x.setContentDescription(strM10678b);
                this.f1994x.setOnTouchListener(new ViewOnTouchListenerC0667ee(this));
                this.f1995y.setOnClickListener(new ViewOnClickListenerC0668ef(this));
                this.f1995y.setVisibility(0);
                this.f1978h = this.f1975e.m3976c();
                m3572a();
            } else {
                this.f1995y.setVisibility(4);
                this.f1995y.setOnClickListener(null);
            }
        }
        int iM3988o = this.f1975e.m3988o() > 0 ? this.f1975e.m3988o() : 0;
        int iM3987n = this.f1975e.m3987n() > 0 ? this.f1975e.m3987n() : 0;
        if (iM3988o == 0 && iM3987n == 0) {
            i = 1;
        } else {
            i2 = iM3988o;
            i = iM3987n;
        }
        if (i2 <= i && i > i2) {
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f1963K = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f1963K = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m3572a();
        m3566q();
        if (this.f1965M && this.f1979i != null) {
            this.f1970R.startQuery(6, null, Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(this.f1979i)), null, null, null, null);
            this.f1965M = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public boolean m3538d() {
        boolean z = false;
        if (this.f1975e != null) {
            try {
                if (!TextUtils.isEmpty(this.f1975e.m3981h())) {
                    String strM3967D = this.f1975e.m3967D();
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
        C3250y.m11450b("isChatONVBuddy() : " + z, f1952d);
        return z;
    }

    /* renamed from: e */
    private boolean m3542e() {
        boolean z = false;
        try {
            if (C1948a.m7903a(this.f1963K.getApplicationContext())) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3250y.m11450b("isChatONVSupportedDevice : " + z, f1952d);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public boolean m3544f() {
        boolean z = false;
        try {
            if (C1954g.m7916a().m7918a(this.f1963K.getApplicationContext(), EnumC1955h.ChatONV)) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3250y.m11450b("isChatONVAvaiable : " + z, f1952d);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public boolean m3546g() {
        boolean z = false;
        try {
            C0045a c0045a = this.f1968P;
            if (C0045a.m37b(this.f1963K.getApplicationContext())) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3250y.m11450b("isChatONVInstalled : " + z, f1952d);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public boolean m3547h() {
        boolean zM55d;
        Exception e;
        try {
            zM55d = this.f1968P.m55d(this.f1963K.getApplicationContext());
            try {
                C3250y.m11450b("isReadyToCall : " + zM55d, f1952d);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                C3250y.m11450b("isChatONVReadyToCall : " + zM55d, f1952d);
                return zM55d;
            }
        } catch (Exception e3) {
            zM55d = false;
            e = e3;
        }
        C3250y.m11450b("isChatONVReadyToCall : " + zM55d, f1952d);
        return zM55d;
    }

    /* renamed from: i */
    private boolean m3549i() {
        if (this.f1963K == null) {
            return false;
        }
        boolean zM3522a = ((TelephonyManager) this.f1963K.getApplicationContext().getSystemService("phone")).getPhoneType() == 0 ? false : m3522a(this.f1963K, new Intent("android.intent.action.CALL", Uri.parse("tel:+000")));
        C3250y.m11458g("is3GCallAvailable : " + zM3522a, f1952d);
        return zM3522a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public boolean m3551j() {
        int iM6733a = C1594v.m6733a(this.f1963K.getApplicationContext());
        if (-3 != iM6733a && -2 != iM6733a) {
            return true;
        }
        C3641ai.m13210a(this.f1963K.getApplicationContext(), R.string.popup_no_network_connection, 0).show();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a0  */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m3553k() {
        /*
            r7 = this;
            r1 = 1
            r2 = 0
            com.sec.chaton.buddy.a.c r0 = r7.f1975e
            int r0 = r0.m3966C()
            if (r0 == 0) goto L99
            r0 = r1
        Lb:
            if (r0 == 0) goto La2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "processNoChatONVCase : buddyPhoneNumberAvailable = "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = com.sec.chaton.buddy.BuddyInfoFragment.f1952d
            com.sec.chaton.util.C3250y.m11458g(r0, r3)
            boolean r3 = r7.m3549i()
            if (r3 != 0) goto La0
            android.app.Activity r0 = r7.f1963K
            java.lang.String r4 = "phone"
            java.lang.Object r0 = r0.getSystemService(r4)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            android.app.Activity r0 = r7.f1963K
            android.content.Intent r4 = new android.content.Intent
            java.lang.String r5 = "android.intent.action.SENDTO"
            java.lang.String r6 = "smsto:+000"
            android.net.Uri r6 = android.net.Uri.parse(r6)
            r4.<init>(r5, r6)
            boolean r0 = m3522a(r0, r4)
            if (r0 == 0) goto La0
            r0 = r1
        L4b:
            java.lang.String r4 = r7.f1976f
            boolean r4 = r7.m3524a(r4)
            if (r4 != 0) goto L9e
            if (r3 == 0) goto L9c
            boolean r3 = r7.m3557m()
            if (r3 == 0) goto L9c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "processNoChatONVCase : buddyPhoneNumberAvailable2 = "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = com.sec.chaton.buddy.BuddyInfoFragment.f1952d
            com.sec.chaton.util.C3250y.m11458g(r2, r3)
        L73:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "processNoChatONVCase : buddyPhoneNumberAvailable = "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r1)
            java.lang.String r3 = " @ isContactShow = "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = com.sec.chaton.buddy.BuddyInfoFragment.f1952d
            com.sec.chaton.util.C3250y.m11458g(r2, r3)
            r7.m3521a(r1, r0)
            return
        L99:
            r0 = r2
            goto Lb
        L9c:
            r1 = r2
            goto L73
        L9e:
            r1 = r3
            goto L73
        La0:
            r0 = r2
            goto L4b
        La2:
            r3 = r0
            r0 = r2
            goto L4b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyInfoFragment.m3553k():void");
    }

    /* renamed from: a */
    private void m3521a(boolean z, boolean z2) {
        if (z) {
            this.f1981k = true;
            this.f1954B.setVisibility(0);
            this.f1955C.setVisibility(0);
            this.f1959G.setVisibility(0);
            this.f1956D.setVisibility(0);
            this.f1960H.setVisibility(8);
            this.f1961I.setVisibility(8);
            this.f1957E.setVisibility(8);
            this.f1958F.setVisibility(8);
            return;
        }
        if (z2) {
            this.f1954B.setVisibility(8);
            this.f1955C.setVisibility(8);
            this.f1959G.setVisibility(0);
            this.f1956D.setVisibility(0);
            this.f1960H.setVisibility(8);
            this.f1961I.setVisibility(8);
            this.f1957E.setVisibility(8);
            this.f1958F.setVisibility(8);
            return;
        }
        this.f1954B.setVisibility(8);
        this.f1955C.setVisibility(8);
        this.f1959G.setVisibility(8);
        this.f1956D.setVisibility(8);
        this.f1960H.setVisibility(8);
        this.f1961I.setVisibility(8);
        this.f1957E.setVisibility(8);
        this.f1958F.setVisibility(8);
    }

    /* renamed from: b */
    private void m3529b(boolean z, boolean z2) {
        C3250y.m11458g("drawVButtons : buddyPhoneNumberAvailable = " + z, f1952d);
        if (z) {
            this.f1954B.setVisibility(0);
            this.f1955C.setVisibility(0);
            this.f1959G.setVisibility(8);
            this.f1956D.setVisibility(8);
            this.f1960H.setVisibility(0);
            this.f1961I.setVisibility(0);
            this.f1957E.setVisibility(0);
            this.f1958F.setVisibility(0);
            return;
        }
        if (z2) {
            this.f1954B.setVisibility(8);
            this.f1955C.setVisibility(8);
            this.f1959G.setVisibility(0);
            this.f1956D.setVisibility(0);
            this.f1960H.setVisibility(0);
            this.f1961I.setVisibility(0);
            this.f1957E.setVisibility(0);
            this.f1958F.setVisibility(0);
            return;
        }
        this.f1954B.setVisibility(8);
        this.f1955C.setVisibility(8);
        this.f1959G.setVisibility(8);
        this.f1956D.setVisibility(8);
        this.f1960H.setVisibility(0);
        this.f1961I.setVisibility(0);
        this.f1957E.setVisibility(0);
        this.f1958F.setVisibility(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0086 A[PHI: r10
  0x0086: PHI (r10v1 boolean) = (r10v0 boolean), (r10v3 boolean), (r10v3 boolean) binds: [B:3:0x000e, B:5:0x002c, B:7:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m3520a(boolean r10) {
        /*
            r9 = this;
            r1 = 1
            r2 = 0
            boolean r3 = r9.m3542e()
            boolean r4 = r9.m3544f()
            boolean r5 = r9.m3547h()
            if (r10 == 0) goto L86
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "processMultiDeviceCase : buddyPhoneNumberAvailable = "
            java.lang.StringBuilder r0 = r0.append(r6)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = com.sec.chaton.buddy.BuddyInfoFragment.f1952d
            com.sec.chaton.util.C3250y.m11458g(r0, r6)
            boolean r10 = r9.m3549i()
            if (r10 != 0) goto L86
            android.app.Activity r0 = r9.f1963K
            java.lang.String r6 = "phone"
            java.lang.Object r0 = r0.getSystemService(r6)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            android.app.Activity r0 = r9.f1963K
            android.content.Intent r6 = new android.content.Intent
            java.lang.String r7 = "android.intent.action.SENDTO"
            java.lang.String r8 = "smsto:+000"
            android.net.Uri r8 = android.net.Uri.parse(r8)
            r6.<init>(r7, r8)
            boolean r0 = m3522a(r0, r6)
            if (r0 == 0) goto L86
            r0 = r1
        L4e:
            boolean r6 = r9.m3538d()
            if (r3 == 0) goto L70
            if (r4 == 0) goto L70
            if (r5 == 0) goto L64
            if (r6 == 0) goto L60
            r9.m3529b(r10, r0)
            r9.f1982l = r1
        L5f:
            return
        L60:
            r9.m3521a(r10, r0)
            goto L5f
        L64:
            if (r6 == 0) goto L6c
            r9.m3529b(r10, r0)
            r9.f1982l = r2
            goto L5f
        L6c:
            r9.m3521a(r10, r0)
            goto L5f
        L70:
            if (r3 == 0) goto L82
            boolean r1 = r9.m3546g()
            if (r1 != 0) goto L7e
            if (r6 == 0) goto L7e
            r9.m3529b(r10, r0)
            goto L5f
        L7e:
            r9.m3521a(r10, r0)
            goto L5f
        L82:
            r9.m3521a(r10, r0)
            goto L5f
        L86:
            r0 = r2
            goto L4e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyInfoFragment.m3520a(boolean):void");
    }

    /* renamed from: l */
    private void m3555l() {
        if (this.f1975e != null) {
            boolean z = this.f1975e.m3966C() != 0;
            C3250y.m11458g("showphonenumber : " + z + " @ getShowPhoneNumber : " + this.f1975e.m3966C(), f1952d);
            if (!this.f1964L) {
                C3250y.m11458g("refreshCommunicationButtons : is not multi-device", f1952d);
                this.f1992v.setVisibility(8);
                m3553k();
            } else {
                C3250y.m11458g("refreshCommunicationButtons : is multi-device", f1952d);
                z = m3563p().size() != 0;
                m3520a(z);
                if (!TextUtils.isEmpty(this.f1975e.m3978e())) {
                    this.f1992v.setVisibility(0);
                    this.f1993w.setText(this.f1975e.m3978e());
                    this.f1993w.setSelected(true);
                } else {
                    this.f1992v.setVisibility(8);
                }
            }
            if (!this.f1964L && !m3524a(this.f1976f)) {
                z = z && m3557m();
            }
            if (!z) {
                this.f1984n.setVisibility(8);
                return;
            }
            if (!this.f1964L) {
                this.f1984n.setVisibility(0);
                return;
            }
            List<String> listM3563p = m3563p();
            if (listM3563p.size() == 4) {
                this.f1984n.setVisibility(0);
                this.f1985o.setVisibility(0);
                this.f1986p.setVisibility(0);
                this.f1987q.setVisibility(0);
                return;
            }
            if (listM3563p.size() == 3) {
                this.f1984n.setVisibility(0);
                this.f1985o.setVisibility(0);
                this.f1986p.setVisibility(0);
            } else if (listM3563p.size() == 2) {
                this.f1984n.setVisibility(0);
                this.f1985o.setVisibility(0);
            } else if (listM3563p.size() == 1) {
                this.f1984n.setVisibility(0);
            }
        }
    }

    /* renamed from: a */
    private boolean m3524a(String str) {
        if (str.length() >= 19 && str.startsWith("10")) {
            C3250y.m11450b("chaton id : " + str, f1952d);
            return false;
        }
        if (str.startsWith("0")) {
            C3250y.m11450b("pin number : " + str, f1952d);
            return false;
        }
        C3250y.m11450b("phone number: " + str, f1952d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3528b(String str) {
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        if (!this.f1966N) {
            m3518a(uri, str);
            return;
        }
        long jM3035a = (this.f1964L || this.f1967O) ? 0L : C0423i.m3035a(this.f1975e.m3984k());
        if (jM3035a == 0) {
            jM3035a = this.f1980j;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(uri + "/" + jM3035a));
        try {
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException e) {
            C3250y.m11443a(e, getClass().getSimpleName());
            C3641ai.m13210a(this.f1963K, R.string.toast_contact_not_found, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public boolean m3557m() {
        if (this.f1976f.length() < 19 || !this.f1976f.startsWith("10") || TextUtils.isEmpty(this.f1975e.m3979f())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3534c(String str) {
        AbstractC3271a.m11494a(this.f1963K).mo11500a(getResources().getString(R.string.buddy_profile_birthday)).mo11509b(String.format(getResources().getString(R.string.buddy_profile_dialog_addbuddy_birthday_to_calendar), this.f1977g)).mo11501a(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0671ei(this, str)).mo11512b();
    }

    /* renamed from: a */
    private void m3518a(Uri uri, String str) {
        AbstractC3271a.m11494a(this.f1963K).mo11500a(getResources().getString(R.string.popup_media_contact)).mo11509b(getResources().getString(R.string.buddy_profile_dialog_addbuddy_phonenumber_to_contact)).mo11501a(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0663ea(this, str, uri)).mo11512b();
    }

    /* renamed from: a */
    public void m3572a() {
        if (this.f1975e != null && !this.f1975e.m3982i().equals("0000-12-31") && this.f1975e.m3982i().length() != 0 && this.f1975e.m3982i() != null && !TextUtils.isEmpty(this.f1975e.m3982i())) {
            String strReplaceAll = this.f1975e.m3982i().replaceAll(" ", "");
            if (strReplaceAll != null && strReplaceAll.length() == 10) {
                strReplaceAll = strReplaceAll.substring(5);
            }
            new AsyncTaskC0672ej(this).execute(strReplaceAll);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public Uri m3537d(String str) {
        try {
            int iM3559n = m3559n();
            if (iM3559n <= 0) {
                return null;
            }
            return m3513a(iM3559n, this.f1978h, str);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: n */
    private int m3559n() throws NumberFormatException {
        int i;
        String[] strArr = {"_id", "name"};
        String str = "selected=1";
        if (Build.VERSION.SDK_INT >= 14) {
            str = null;
        }
        Cursor cursorM3512a = m3512a(strArr, str, "calendars");
        if (cursorM3512a == null || !cursorM3512a.moveToFirst()) {
            return 0;
        }
        int columnIndex = cursorM3512a.getColumnIndex("name");
        int columnIndex2 = cursorM3512a.getColumnIndex("_id");
        while (true) {
            String string = cursorM3512a.getString(columnIndex);
            String string2 = cursorM3512a.getString(columnIndex2);
            if (string != null) {
                i = Integer.parseInt(string2);
                break;
            }
            if (!cursorM3512a.moveToNext()) {
                i = 0;
                break;
            }
        }
        cursorM3512a.close();
        return i;
    }

    /* renamed from: a */
    private Cursor m3512a(String[] strArr, String str, String str2) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = this.f1963K.getContentResolver().query(Uri.parse("content://calendar/" + str2), strArr, str, null, null);
        } catch (IllegalArgumentException e) {
        }
        if (cursorQuery != null) {
            return cursorQuery;
        }
        try {
            return this.f1963K.getContentResolver().query(Uri.parse("content://com.android.calendar/" + str2), strArr, str, null, null);
        } catch (IllegalArgumentException e2) {
            return cursorQuery;
        }
    }

    /* renamed from: a */
    private Uri m3513a(int i, String str, String str2) {
        Calendar calendar = Calendar.getInstance();
        String str3 = String.valueOf(calendar.get(1)) + "-" + str2;
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(str3));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(str3));
        this.f1971S = 2036 - Calendar.getInstance().get(1);
        calendar2.add(1, this.f1971S);
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
            return this.f1963K.getContentResolver().insert(Uri.parse(m3562o() + "events"), contentValues);
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
        return this.f1963K.getContentResolver().insert(CalendarContract.Events.CONTENT_URI, contentValues);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m3517a(String str, long j, long j2) throws Throwable {
        Cursor cursor;
        String str2;
        String str3 = str + "'s birthday";
        Cursor cursor2 = null;
        try {
            Cursor cursorQuery = this.f1963K.getContentResolver().query(Uri.parse("content://com.android.calendar/events"), new String[]{"calendar_id", "title", "description", "dtstart", "dtend", "eventLocation", "deleted"}, null, null, null);
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

    /* renamed from: o */
    private String m3562o() {
        String str;
        Cursor cursor;
        Cursor cursor2 = null;
        String str2 = null;
        byte b = 0;
        try {
            Cursor cursorQuery = this.f1963K.getContentResolver().query(Uri.parse("content://calendar/calendars"), null, null, null, null);
            if (cursorQuery != null) {
                cursorQuery.close();
                str2 = "content://calendar/";
            }
            cursor = cursorQuery;
        } catch (Exception e) {
            if (0 != 0) {
                (b == true ? 1 : 0).close();
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
                Cursor cursorQuery2 = this.f1963K.getContentResolver().query(Uri.parse("content://com.android.calendar/calendars"), null, null, null, null);
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
    /* renamed from: p */
    public List<String> m3563p() {
        ArrayList arrayList = new ArrayList();
        String strM3980g = this.f1975e.m3980g();
        if (!TextUtils.isEmpty(strM3980g)) {
            StringTokenizer stringTokenizer = new StringTokenizer(strM3980g, "|");
            while (stringTokenizer.hasMoreTokens()) {
                new String();
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.length() >= 19 && strNextToken.startsWith("10")) {
                    C3250y.m11450b("chaton id : " + strNextToken, f1952d);
                } else if (strNextToken.startsWith("0")) {
                    C3250y.m11450b("pin number : " + strNextToken, f1952d);
                } else {
                    C3250y.m11450b("msisdn: " + strNextToken, f1952d);
                    arrayList.add(strNextToken);
                }
            }
        }
        return arrayList;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 5 && !this.f1966N && this.f1979i != null) {
            this.f1970R.startQuery(6, null, Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(this.f1979i)), null, null, null, null);
        }
    }

    /* renamed from: a */
    public static boolean m3522a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    /* renamed from: q */
    private void m3566q() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = this.f1963K.getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }
}
