package p000a.p001a.p003b;

/* compiled from: StoryItem.java */
/* renamed from: a.a.b.d */
/* loaded from: classes.dex */
public class C0006d {

    /* renamed from: a */
    private String f16a;

    /* renamed from: b */
    private String f17b;

    /* renamed from: c */
    private String f18c;

    /* renamed from: d */
    private String f19d;

    /* renamed from: e */
    private EnumC0007e f20e;

    /* renamed from: f */
    private C0003a f21f;

    /* renamed from: g */
    private String f22g;

    /* renamed from: h */
    private String f23h;

    /* renamed from: i */
    private long f24i;

    /* renamed from: j */
    private C0004b f25j;

    /* renamed from: k */
    private int f26k;

    /* renamed from: l */
    private String f27l;

    public C0006d(String str, String str2, String str3, String str4, String str5, EnumC0007e enumC0007e, C0003a c0003a, C0004b c0004b, long j, int i, String str6) {
        this(str, str2, str3, str3, str4, str5, enumC0007e, c0003a, c0004b, j, i, str6);
    }

    public C0006d(String str, String str2, String str3, String str4, String str5, String str6, EnumC0007e enumC0007e, C0003a c0003a, C0004b c0004b, long j, int i, String str7) {
        if (str == null || str2 == null || str4 == null) {
            throw new NullPointerException();
        }
        if (!str2.equalsIgnoreCase("samsung.media") && !str2.equalsIgnoreCase("samsung.personal") && !str2.equalsIgnoreCase("samsung.here.and.now") && !str2.equalsIgnoreCase("flipboard.temporary.will.change.later.news") && !str2.equalsIgnoreCase("flipboard.temporary.will.change.later.social")) {
            throw new IllegalArgumentException("Not a valid streamId: " + str2);
        }
        this.f16a = str;
        this.f17b = str2;
        this.f19d = str3;
        this.f18c = str4;
        this.f21f = c0003a;
        this.f22g = str5;
        this.f23h = str6;
        this.f20e = enumC0007e == null ? EnumC0007e.ARTICLE : enumC0007e;
        this.f24i = j;
        this.f25j = c0004b;
        this.f26k = i;
        this.f27l = str7;
    }

    /* renamed from: a */
    public String m13a() {
        return this.f19d;
    }

    /* renamed from: b */
    public String m14b() {
        return this.f22g;
    }

    /* renamed from: c */
    public String m15c() {
        return this.f16a;
    }

    /* renamed from: d */
    public C0003a m16d() {
        return this.f21f;
    }

    /* renamed from: e */
    public String m17e() {
        if (this.f23h != null) {
            return this.f23h.trim();
        }
        return null;
    }

    /* renamed from: f */
    public long m18f() {
        return this.f24i;
    }

    /* renamed from: g */
    public C0004b m19g() {
        return this.f25j;
    }

    /* renamed from: h */
    public String m20h() {
        return this.f17b;
    }

    /* renamed from: i */
    public String m21i() {
        return this.f18c;
    }

    /* renamed from: j */
    public EnumC0007e m22j() {
        return this.f20e;
    }

    /* renamed from: k */
    public int m23k() {
        return this.f26k;
    }

    /* renamed from: l */
    public String m24l() {
        return this.f27l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22g);
        sb.append(" - ");
        sb.append(this.f25j != null ? this.f25j.m9a() : null);
        return sb.toString();
    }
}
