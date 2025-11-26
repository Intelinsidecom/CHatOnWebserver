package p021c;

import java.util.Arrays;
import p021c.p022a.C0334i;
import p021c.p023b.p024a.C0337a;
import p021c.p023b.p024a.C0338b;
import p021c.p023b.p024a.C0339c;

/* compiled from: IDs.java */
/* renamed from: c.b */
/* loaded from: classes.dex */
public class C0336b extends C0352k {

    /* renamed from: d */
    private static String[] f771d = {"id_list", "ids"};

    /* renamed from: a */
    private long[] f772a;

    /* renamed from: b */
    private long f773b;

    /* renamed from: c */
    private long f774c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0336b(C0334i c0334i, C0349h c0349h) throws C0351j {
        super(c0334i);
        if ("[]\n".equals(c0334i.m1174b())) {
            this.f773b = 0L;
            this.f774c = 0L;
            this.f772a = new long[0];
            return;
        }
        C0339c c0339cM1175c = c0334i.m1175c();
        try {
            this.f773b = c0339cM1175c.m1201g("previous_cursor");
            this.f774c = c0339cM1175c.m1201g("next_cursor");
            if (!c0339cM1175c.m1203i("ids")) {
                C0337a c0337aM1199e = c0339cM1175c.m1199e("ids");
                int iM1179a = c0337aM1199e.m1179a();
                this.f772a = new long[iM1179a];
                for (int i = 0; i < iM1179a; i++) {
                    this.f772a[i] = c0337aM1199e.m1185d(i);
                }
            }
        } catch (C0338b e) {
            throw new C0351j(e);
        }
    }

    /* renamed from: a */
    public long[] m1177a() {
        return this.f772a;
    }

    /* renamed from: b */
    public long m1178b() {
        return this.f774c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0336b)) {
            return false;
        }
        return Arrays.equals(this.f772a, ((C0336b) obj).f772a);
    }

    public int hashCode() {
        if (this.f772a != null) {
            return Arrays.hashCode(this.f772a);
        }
        return 0;
    }

    public String toString() {
        return "IDs{ids=" + this.f772a + ", previousCursor=" + this.f773b + ", nextCursor=" + this.f774c + '}';
    }
}
