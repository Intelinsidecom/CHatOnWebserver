package p021c;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import p021c.p022a.C0334i;
import p021c.p023b.p024a.C0339c;

/* compiled from: WeiboResponse.java */
/* renamed from: c.k */
/* loaded from: classes.dex */
public class C0352k implements Serializable {

    /* renamed from: a */
    private static Map<String, SimpleDateFormat> f853a = new HashMap();

    /* renamed from: e */
    private static final boolean f854e = C0325a.m1095b();

    /* renamed from: b */
    private transient int f855b;

    /* renamed from: c */
    private transient int f856c;

    /* renamed from: d */
    private transient long f857d;

    public C0352k() {
        this.f855b = -1;
        this.f856c = -1;
        this.f857d = -1L;
    }

    public C0352k(C0334i c0334i) {
        this.f855b = -1;
        this.f856c = -1;
        this.f857d = -1L;
        String strM1173a = c0334i.m1173a("X-RateLimit-Limit");
        if (strM1173a != null) {
            this.f855b = Integer.parseInt(strM1173a);
        }
        String strM1173a2 = c0334i.m1173a("X-RateLimit-Remaining");
        if (strM1173a2 != null) {
            this.f856c = Integer.parseInt(strM1173a2);
        }
        String strM1173a3 = c0334i.m1173a("X-RateLimit-Reset");
        if (strM1173a3 != null) {
            this.f857d = Long.parseLong(strM1173a3);
        }
    }

    /* renamed from: a */
    protected static Date m1243a(String str, String str2) throws C0351j {
        SimpleDateFormat simpleDateFormat;
        Date date;
        if (str == null || "".equals(str)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat2 = f853a.get(str2);
        if (simpleDateFormat2 == null) {
            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(str2, Locale.ENGLISH);
            simpleDateFormat3.setTimeZone(TimeZone.getTimeZone("GMT"));
            f853a.put(str2, simpleDateFormat3);
            simpleDateFormat = simpleDateFormat3;
        } else {
            simpleDateFormat = simpleDateFormat2;
        }
        try {
            synchronized (simpleDateFormat) {
                date = simpleDateFormat.parse(str);
            }
            return date;
        } catch (ParseException e) {
            throw new C0351j("Unexpected format(" + str + ") returned from sina.com.cn");
        }
    }

    /* renamed from: a */
    protected static int m1242a(String str, C0339c c0339c) {
        String strM1202h = c0339c.m1202h(str);
        if (strM1202h == null || "".equals(strM1202h) || "null".equals(strM1202h)) {
            return -1;
        }
        return Integer.parseInt(strM1202h);
    }

    /* renamed from: b */
    protected static long m1244b(String str, C0339c c0339c) {
        String strM1202h = c0339c.m1202h(str);
        if (strM1202h == null || "".equals(strM1202h) || "null".equals(strM1202h)) {
            return -1L;
        }
        return Long.parseLong(strM1202h);
    }

    /* renamed from: c */
    protected static boolean m1245c(String str, C0339c c0339c) {
        String strM1202h = c0339c.m1202h(str);
        if (strM1202h == null || "".equals(strM1202h) || "null".equals(strM1202h)) {
            return false;
        }
        return Boolean.valueOf(strM1202h).booleanValue();
    }
}
