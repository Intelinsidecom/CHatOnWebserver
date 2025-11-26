package com.sec.chaton.smsplugin.p102b;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.Telephony;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: Contact.java */
@TargetApi(14)
/* renamed from: com.sec.chaton.smsplugin.b.a */
/* loaded from: classes.dex */
public class C3782a {

    /* renamed from: a */
    private static C3784c f13550a;

    /* renamed from: b */
    private static final HashSet<InterfaceC3788g> f13551b = new HashSet<>();

    /* renamed from: c */
    private long f13552c;

    /* renamed from: d */
    private int f13553d;

    /* renamed from: e */
    private String f13554e;

    /* renamed from: f */
    private String f13555f;

    /* renamed from: g */
    private String f13556g;

    /* renamed from: h */
    private String f13557h;

    /* renamed from: i */
    private boolean f13558i;

    /* renamed from: j */
    private long f13559j;

    /* renamed from: k */
    private String f13560k;

    /* renamed from: l */
    private long f13561l;

    /* renamed from: m */
    private int f13562m;

    /* renamed from: n */
    private String f13563n;

    /* renamed from: o */
    private BitmapDrawable f13564o;

    /* renamed from: p */
    private byte[] f13565p;

    /* renamed from: q */
    private boolean f13566q;

    /* renamed from: r */
    private boolean f13567r;

    /* renamed from: s */
    private boolean f13568s;

    /* renamed from: t */
    private boolean f13569t;

    /* renamed from: u */
    private String f13570u;

    /* renamed from: v */
    private long f13571v;

    /* renamed from: w */
    private String f13572w;

    private C3782a(String str, String str2) {
        m14213a(str, str2);
    }

    private C3782a(String str) {
        m14213a(str, "");
    }

    private C3782a(boolean z) {
        m14213a("Self_Item_Key", "");
        this.f13568s = z;
    }

    /* renamed from: a */
    private void m14213a(String str, String str2) {
        this.f13552c = -1L;
        this.f13556g = str2;
        m14258b(str);
        this.f13558i = false;
        this.f13560k = "";
        this.f13561l = 0L;
        this.f13562m = 0;
        this.f13566q = true;
        this.f13569t = false;
        this.f13570u = "";
        this.f13571v = 0L;
        this.f13572w = "";
    }

    public String toString() {
        Object[] objArr = new Object[9];
        objArr[0] = this.f13572w != null ? this.f13572w : "null";
        objArr[1] = this.f13570u != null ? this.f13570u : "null";
        objArr[2] = this.f13554e != null ? this.f13554e : "null";
        objArr[3] = this.f13556g != null ? this.f13556g : "null";
        objArr[4] = this.f13557h != null ? this.f13557h : "null";
        objArr[5] = this.f13560k != null ? this.f13560k : "null";
        objArr[6] = Long.valueOf(this.f13561l);
        objArr[7] = Integer.valueOf(hashCode());
        objArr[8] = Long.valueOf(this.f13552c);
        return String.format("{ buddyRawId=%s, buddyNo=%s, number=%s, name=%s, nameAndNumber=%s, label=%s, person_id=%d, hash=%d method_id=%d }", objArr);
    }

    /* renamed from: a */
    public static C3782a m14204a(String str, boolean z) {
        m14241g("###Contact number : " + str);
        if (f13550a == null) {
            m14211a(CommonApplication.m18732r());
        }
        return f13550a.m14293a(str, z);
    }

    /* renamed from: a */
    public static C3782a m14205a(boolean z) {
        return f13550a.m14294a(z);
    }

    /* renamed from: a */
    public static List<C3782a> m14209a(Parcelable[] parcelableArr) {
        return f13550a.m14295a(parcelableArr);
    }

    /* renamed from: a */
    public static void m14210a() {
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            m14241g("invalidateCache");
        }
        f13550a.m14296a();
    }

    /* renamed from: b */
    public boolean m14260b() {
        return this.f13568s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static String m14238f(String str) {
        return str != null ? str : "";
    }

    /* renamed from: a */
    public static String m14208a(String str, String str2, String str3) {
        String number;
        if (Telephony.Mms.isEmailAddress(str2)) {
            number = str2;
        } else {
            try {
                number = PhoneNumberUtils.formatNumber(str2, str3, GlobalApplication.m10279a().m10297l());
            } catch (NoSuchMethodError e) {
                C3890m.m14996b("Contact", "NoSuchMethodError on formatNameAndNumber()");
                number = str2;
            } catch (RuntimeException e2) {
                C3890m.m14996b("Contact", "RuntimeException on formatNameAndNumber()");
            }
        }
        if (!TextUtils.isEmpty(str) && !str.equals(str2)) {
            return str + " <" + number + ">";
        }
        return number;
    }

    /* renamed from: a */
    public static String m14207a(String str) {
        String strM14264f = f13550a.m14293a(str, true).m14264f();
        return TextUtils.isEmpty(strM14264f) ? str : strM14264f;
    }

    /* renamed from: c */
    public void m14261c() {
        this.f13566q = true;
        f13550a.m14293a(this.f13554e, false);
    }

    /* renamed from: d */
    public synchronized String m14262d() {
        return this.f13554e;
    }

    /* renamed from: b */
    public synchronized void m14258b(String str) {
        this.f13554e = str;
        m14253q();
        this.f13558i = true;
    }

    /* renamed from: e */
    public boolean m14263e() {
        return this.f13558i;
    }

    /* renamed from: b */
    public void m14259b(boolean z) {
        this.f13558i = z;
    }

    /* renamed from: f */
    public synchronized String m14264f() {
        return TextUtils.isEmpty(this.f13556g) ? PhoneNumberUtils.formatNumber(this.f13554e) : this.f13556g;
    }

    /* renamed from: g */
    public synchronized boolean m14265g() {
        return TextUtils.isEmpty(this.f13556g);
    }

    /* renamed from: h */
    public synchronized String m14266h() {
        return this.f13557h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m14253q() {
        this.f13557h = m14208a(this.f13556g, this.f13554e, this.f13555f);
    }

    /* renamed from: i */
    public synchronized long m14267i() {
        return this.f13559j;
    }

    /* renamed from: a */
    public synchronized void m14257a(long j) {
        this.f13559j = j;
    }

    /* renamed from: j */
    public synchronized Uri m14268j() {
        return ContentUris.withAppendedId(C2289i.f8196a, this.f13561l);
    }

    /* renamed from: k */
    public synchronized String m14269k() {
        return this.f13570u;
    }

    /* renamed from: l */
    public synchronized long m14270l() {
        return this.f13571v;
    }

    /* renamed from: m */
    public synchronized boolean m14271m() {
        return this.f13561l > 0;
    }

    /* renamed from: a */
    public static void m14212a(InterfaceC3788g interfaceC3788g) {
        synchronized (f13551b) {
            f13551b.add(interfaceC3788g);
        }
    }

    /* renamed from: b */
    public static void m14221b(InterfaceC3788g interfaceC3788g) {
        synchronized (f13551b) {
            f13551b.remove(interfaceC3788g);
        }
    }

    /* renamed from: n */
    public synchronized boolean m14272n() {
        return Telephony.Mms.isEmailAddress(this.f13554e);
    }

    /* renamed from: a */
    public synchronized Drawable m14256a(Context context, Drawable drawable) {
        if (this.f13564o == null && this.f13565p != null) {
            this.f13564o = new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray(this.f13565p, 0, this.f13565p.length));
        }
        if (this.f13564o != null) {
            drawable = this.f13564o;
        }
        return drawable;
    }

    /* renamed from: a */
    public static void m14211a(Context context) {
        f13550a = new C3784c(context);
        C3795n.m14383a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static void m14241g(String str) {
        C3890m.m14996b("Contact", str);
    }

    /* renamed from: c */
    public static String m14228c(String str) {
        if (str.startsWith("+00")) {
            str = str.substring(1);
        }
        if (!C4149cd.m16441j(str) && str.indexOf("@") < 0) {
            if (str.indexOf("(") >= 0 || str.indexOf(")") >= 0 || str.indexOf(" ") >= 0 || str.indexOf("-") >= 0 || str.indexOf(".") >= 0) {
                return PhoneNumberUtils.stripSeparators(str);
            }
            return str;
        }
        return str;
    }

    /* renamed from: o */
    public synchronized boolean m14273o() {
        return C4149cd.m16429c(this.f13554e);
    }

    /* renamed from: a */
    public static void m14214a(ArrayList<String> arrayList) {
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            m14241g("updateCache by buddyNo");
        }
        f13550a.m14281a((ArrayList<String>) arrayList);
    }

    /* renamed from: b */
    public static void m14222b(ArrayList<String> arrayList) {
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            m14241g("updateCache by buddyNo");
        }
        f13550a.m14290b((ArrayList<String>) arrayList);
    }
}
