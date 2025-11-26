package p000a.p001a.p003b;

/* compiled from: Image.java */
/* renamed from: a.a.b.b */
/* loaded from: classes.dex */
public class C0004b {

    /* renamed from: a */
    private String f9a;

    /* renamed from: b */
    private int f10b;

    /* renamed from: c */
    private int f11c;

    /* renamed from: d */
    private String f12d;

    public C0004b(String str, int i, int i2, String str2) {
        String string;
        this.f9a = str;
        if (str != null && (i == 0 || i2 == 0)) {
            i = 480;
            i2 = 320;
        }
        this.f10b = i;
        this.f11c = i2;
        if (str2 != null && str2.equalsIgnoreCase(EnumC0005c.NO_OVERLAY_NO_CROP.toString())) {
            string = EnumC0005c.NO_OVERLAY_NO_CROP.toString();
        } else {
            string = EnumC0005c.NORMAL.toString();
        }
        this.f12d = string;
    }

    /* renamed from: a */
    public String m9a() {
        return this.f9a;
    }

    /* renamed from: b */
    public int m10b() {
        return this.f10b;
    }

    /* renamed from: c */
    public int m11c() {
        return this.f11c;
    }

    /* renamed from: d */
    public String m12d() {
        return this.f12d.toString();
    }
}
