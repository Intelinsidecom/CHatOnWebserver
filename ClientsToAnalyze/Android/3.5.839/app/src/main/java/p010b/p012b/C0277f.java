package p010b.p012b;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import p010b.p013c.InterfaceC0282a;
import p010b.p014d.p015a.C0286a;
import p010b.p014d.p015a.C0293h;
import p010b.p014d.p015a.C0295j;
import p010b.p014d.p015a.C0296k;
import p010b.p014d.p017c.AbstractC0307a;
import p010b.p014d.p020e.C0317a;

/* compiled from: OAuthAuthorization.java */
/* renamed from: b.b.f */
/* loaded from: classes.dex */
public class C0277f implements InterfaceC0273b, InterfaceC0278g, Serializable {

    /* renamed from: b */
    private static transient C0293h f619b;

    /* renamed from: c */
    private static final C0295j f620c = new C0295j("oauth_signature_method", "HMAC-SHA1");

    /* renamed from: d */
    private static final AbstractC0307a f621d = AbstractC0307a.m1036a(C0277f.class);

    /* renamed from: i */
    private static Random f622i = new Random();

    /* renamed from: a */
    private final InterfaceC0282a f623a;

    /* renamed from: f */
    private String f625f;

    /* renamed from: e */
    private String f624e = "";

    /* renamed from: g */
    private String f626g = null;

    /* renamed from: h */
    private AbstractC0279h f627h = null;

    public C0277f(InterfaceC0282a interfaceC0282a) {
        this.f623a = interfaceC0282a;
        f619b = new C0293h(interfaceC0282a);
        mo973b(interfaceC0282a.m982f(), interfaceC0282a.m983g());
        if (interfaceC0282a.m984h() != null && interfaceC0282a.m985i() != null) {
            mo972a(new C0272a(interfaceC0282a.m984h(), interfaceC0282a.m985i()));
        }
    }

    @Override // p010b.p012b.InterfaceC0273b
    /* renamed from: a */
    public String mo955a(C0296k c0296k) {
        return m970a(c0296k.m1019a().name(), c0296k.m1021c(), c0296k.m1020b(), this.f627h);
    }

    /* renamed from: b */
    private void m965b() {
        if (this.f627h == null) {
            throw new IllegalStateException("No Token available.");
        }
    }

    @Override // p010b.p012b.InterfaceC0278g
    /* renamed from: a */
    public C0280i mo967a() {
        return m968a((String) null, (String) null);
    }

    /* renamed from: a */
    public C0280i m968a(String str, String str2) {
        if (this.f627h instanceof C0272a) {
            throw new IllegalStateException("Access token already available.");
        }
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            arrayList.add(new C0295j("oauth_callback", str));
        }
        if (str2 != null) {
            arrayList.add(new C0295j("x_auth_access_type", str2));
        }
        this.f627h = new C0280i(f619b.m1007a(this.f623a.m986j(), (C0295j[]) arrayList.toArray(new C0295j[arrayList.size()]), this), this);
        return (C0280i) this.f627h;
    }

    @Override // p010b.p012b.InterfaceC0278g
    /* renamed from: a */
    public C0272a mo966a(String str) {
        m965b();
        this.f627h = new C0272a(f619b.m1007a(this.f623a.m987k(), new C0295j[]{new C0295j("oauth_verifier", str)}, this));
        return (C0272a) this.f627h;
    }

    @Override // p010b.p012b.InterfaceC0278g
    /* renamed from: a */
    public void mo972a(C0272a c0272a) {
        this.f627h = c0272a;
    }

    /* renamed from: a */
    String m971a(String str, String str2, C0295j[] c0295jArr, String str3, String str4, AbstractC0279h abstractC0279h) throws NoSuchAlgorithmException, InvalidKeyException {
        if (c0295jArr == null) {
            c0295jArr = new C0295j[0];
        }
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new C0295j("oauth_consumer_key", this.f624e));
        arrayList.add(f620c);
        arrayList.add(new C0295j("oauth_timestamp", str4));
        arrayList.add(new C0295j("oauth_nonce", str3));
        arrayList.add(new C0295j("oauth_version", "1.0"));
        if (abstractC0279h != null) {
            arrayList.add(new C0295j("oauth_token", abstractC0279h.mo954c()));
        }
        List<C0295j> arrayList2 = new ArrayList<>(arrayList.size() + c0295jArr.length);
        arrayList2.addAll(arrayList);
        if (!C0295j.m1010a(c0295jArr)) {
            arrayList2.addAll(m961a(c0295jArr));
        }
        m962a(str2, arrayList2);
        StringBuilder sbAppend = new StringBuilder(str).append("&").append(C0295j.m1009a(m963b(str2))).append("&");
        sbAppend.append(C0295j.m1009a(m959a(arrayList2)));
        String string = sbAppend.toString();
        f621d.mo1039a("OAuth base string: ", string);
        String strM969a = m969a(string, abstractC0279h);
        f621d.mo1039a("OAuth signature: ", strM969a);
        arrayList.add(new C0295j("oauth_signature", strM969a));
        if (this.f626g != null) {
            arrayList.add(new C0295j("realm", this.f626g));
        }
        return "OAuth " + m960a(arrayList, ",", true);
    }

    /* renamed from: a */
    private void m962a(String str, List<C0295j> list) {
        int iIndexOf = str.indexOf("?");
        if (-1 != iIndexOf) {
            try {
                for (String str2 : C0317a.m1074a(str.substring(iIndexOf + 1), "&")) {
                    String[] strArrM1074a = C0317a.m1074a(str2, "=");
                    if (strArrM1074a.length == 2) {
                        list.add(new C0295j(URLDecoder.decode(strArrM1074a[0], "UTF-8"), URLDecoder.decode(strArrM1074a[1], "UTF-8")));
                    } else {
                        list.add(new C0295j(URLDecoder.decode(strArrM1074a[0], "UTF-8"), ""));
                    }
                }
            } catch (UnsupportedEncodingException e) {
            }
        }
    }

    /* renamed from: a */
    String m970a(String str, String str2, C0295j[] c0295jArr, AbstractC0279h abstractC0279h) {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        return m971a(str, str2, c0295jArr, String.valueOf(f622i.nextInt() + jCurrentTimeMillis), String.valueOf(jCurrentTimeMillis), abstractC0279h);
    }

    /* renamed from: a */
    String m969a(String str, AbstractC0279h abstractC0279h) throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpecM975d;
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            if (abstractC0279h == null) {
                secretKeySpecM975d = new SecretKeySpec((C0295j.m1009a(this.f625f) + "&").getBytes(), "HmacSHA1");
            } else {
                secretKeySpecM975d = abstractC0279h.m975d();
                if (secretKeySpecM975d == null) {
                    secretKeySpecM975d = new SecretKeySpec((C0295j.m1009a(this.f625f) + "&" + C0295j.m1009a(abstractC0279h.mo953b())).getBytes(), "HmacSHA1");
                    abstractC0279h.m974a(secretKeySpecM975d);
                }
            }
            mac.init(secretKeySpecM975d);
            return C0286a.m991a(mac.doFinal(str.getBytes()));
        } catch (InvalidKeyException e) {
            f621d.mo1040a("Failed initialize \"Message Authentication Code\" (MAC)", e);
            throw new AssertionError(e);
        } catch (NoSuchAlgorithmException e2) {
            f621d.mo1040a("Failed to get HmacSHA1 \"Message Authentication Code\" (MAC)", e2);
            throw new AssertionError(e2);
        }
    }

    /* renamed from: a */
    static String m959a(List<C0295j> list) {
        Collections.sort(list);
        return m964b(list);
    }

    /* renamed from: a */
    static List<C0295j> m961a(C0295j[] c0295jArr) {
        ArrayList arrayList = new ArrayList(c0295jArr.length);
        arrayList.addAll(Arrays.asList(c0295jArr));
        return arrayList;
    }

    /* renamed from: b */
    public static String m964b(List<C0295j> list) {
        return m960a(list, "&", false);
    }

    /* renamed from: a */
    public static String m960a(List<C0295j> list, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (C0295j c0295j : list) {
            if (!c0295j.m1016e()) {
                if (sb.length() != 0) {
                    if (z) {
                        sb.append("\"");
                    }
                    sb.append(str);
                }
                sb.append(C0295j.m1009a(c0295j.m1012a())).append("=");
                if (z) {
                    sb.append("\"");
                }
                sb.append(C0295j.m1009a(c0295j.m1013b()));
            }
        }
        if (sb.length() != 0 && z) {
            sb.append("\"");
        }
        return sb.toString();
    }

    /* renamed from: b */
    static String m963b(String str) {
        int iIndexOf = str.indexOf("?");
        if (-1 != iIndexOf) {
            str = str.substring(0, iIndexOf);
        }
        int iIndexOf2 = str.indexOf("/", 8);
        String lowerCase = str.substring(0, iIndexOf2).toLowerCase();
        int iIndexOf3 = lowerCase.indexOf(":", 8);
        if (-1 != iIndexOf3) {
            if (lowerCase.startsWith("http://") && lowerCase.endsWith(":80")) {
                lowerCase = lowerCase.substring(0, iIndexOf3);
            } else if (lowerCase.startsWith("https://") && lowerCase.endsWith(":443")) {
                lowerCase = lowerCase.substring(0, iIndexOf3);
            }
        }
        return lowerCase + str.substring(iIndexOf2);
    }

    @Override // p010b.p012b.InterfaceC0278g
    /* renamed from: b */
    public void mo973b(String str, String str2) {
        if (str == null) {
            str = "";
        }
        this.f624e = str;
        if (str2 == null) {
            str2 = "";
        }
        this.f625f = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InterfaceC0278g)) {
            return false;
        }
        C0277f c0277f = (C0277f) obj;
        if (this.f624e == null ? c0277f.f624e != null : !this.f624e.equals(c0277f.f624e)) {
            return false;
        }
        if (this.f625f == null ? c0277f.f625f != null : !this.f625f.equals(c0277f.f625f)) {
            return false;
        }
        if (this.f627h != null) {
            if (this.f627h.equals(c0277f.f627h)) {
                return true;
            }
        } else if (c0277f.f627h == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f625f != null ? this.f625f.hashCode() : 0) + ((this.f624e != null ? this.f624e.hashCode() : 0) * 31)) * 31) + (this.f627h != null ? this.f627h.hashCode() : 0);
    }

    public String toString() {
        return "OAuthAuthorization{consumerKey='" + this.f624e + "', consumerSecret='******************************************', oauthToken=" + this.f627h + '}';
    }
}
