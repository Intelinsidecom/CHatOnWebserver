package p021c.p023b.p024a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: JSONArray.java */
/* renamed from: c.b.a.a */
/* loaded from: classes.dex */
public class C0337a {

    /* renamed from: a */
    private ArrayList f775a;

    public C0337a() {
        this.f775a = new ArrayList();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:200)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:61)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:281)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public C0337a(p021c.p023b.p024a.C0343g r5) {
        /*
            r4 = this;
            r1 = 93
            r4.<init>()
            char r0 = r5.m1212c()
            r2 = 91
            if (r0 != r2) goto L15
            r0 = r1
        Le:
            char r2 = r5.m1212c()
            if (r2 != r1) goto L24
        L14:
            return
        L15:
            r2 = 40
            if (r0 != r2) goto L1c
            r0 = 41
            goto Le
        L1c:
            java.lang.String r0 = "A JSONArray text must start with '['"
            c.b.a.b r0 = r5.m1207a(r0)
            throw r0
        L24:
            r5.m1210a()
        L27:
            char r2 = r5.m1212c()
            r3 = 44
            if (r2 != r3) goto L47
            r5.m1210a()
            java.util.ArrayList r2 = r4.f775a
            r3 = 0
            r2.add(r3)
        L38:
            char r2 = r5.m1212c()
            switch(r2) {
                case 41: goto L5e;
                case 44: goto L54;
                case 59: goto L54;
                case 93: goto L5e;
                default: goto L3f;
            }
        L3f:
            java.lang.String r0 = "Expected a ',' or ']'"
            c.b.a.b r0 = r5.m1207a(r0)
            throw r0
        L47:
            r5.m1210a()
            java.util.ArrayList r2 = r4.f775a
            java.lang.Object r3 = r5.m1213d()
            r2.add(r3)
            goto L38
        L54:
            char r2 = r5.m1212c()
            if (r2 == r1) goto L14
            r5.m1210a()
            goto L27
        L5e:
            if (r0 == r2) goto L14
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected a '"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.Character r2 = new java.lang.Character
            r2.<init>(r0)
            java.lang.StringBuilder r0 = r1.append(r2)
            java.lang.String r1 = "'"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            c.b.a.b r0 = r5.m1207a(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p021c.p023b.p024a.C0337a.<init>(c.b.a.g):void");
    }

    public C0337a(Collection collection) {
        this.f775a = collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public C0337a(Object obj) throws C0338b {
        this();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                m1180a(Array.get(obj, i));
            }
            return;
        }
        throw new C0338b("JSONArray initial value should be a string or collection or array.");
    }

    /* renamed from: a */
    public Object m1181a(int i) throws C0338b {
        Object objM1186e = m1186e(i);
        if (objM1186e == null) {
            throw new C0338b("JSONArray[" + i + "] not found.");
        }
        return objM1186e;
    }

    /* renamed from: b */
    public double m1183b(int i) throws C0338b {
        Object objM1181a = m1181a(i);
        try {
            return objM1181a instanceof Number ? ((Number) objM1181a).doubleValue() : Double.valueOf((String) objM1181a).doubleValue();
        } catch (Exception e) {
            throw new C0338b("JSONArray[" + i + "] is not a number.");
        }
    }

    /* renamed from: c */
    public C0339c m1184c(int i) throws C0338b {
        Object objM1181a = m1181a(i);
        if (objM1181a instanceof C0339c) {
            return (C0339c) objM1181a;
        }
        throw new C0338b("JSONArray[" + i + "] is not a JSONObject.");
    }

    /* renamed from: d */
    public long m1185d(int i) throws C0338b {
        Object objM1181a = m1181a(i);
        return objM1181a instanceof Number ? ((Number) objM1181a).longValue() : (long) m1183b(i);
    }

    /* renamed from: a */
    public String m1182a(String str) {
        int iM1179a = m1179a();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iM1179a; i++) {
            if (i > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(C0339c.m1189b(this.f775a.get(i)));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public int m1179a() {
        return this.f775a.size();
    }

    /* renamed from: e */
    public Object m1186e(int i) {
        if (i < 0 || i >= m1179a()) {
            return null;
        }
        return this.f775a.get(i);
    }

    /* renamed from: a */
    public C0337a m1180a(Object obj) {
        this.f775a.add(obj);
        return this;
    }

    public String toString() {
        try {
            return '[' + m1182a(",") + ']';
        } catch (Exception e) {
            return null;
        }
    }
}
