package p010b.p014d.p018d.p019a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: JSONArray.java */
/* renamed from: b.d.d.a.a */
/* loaded from: classes.dex */
public class C0311a {

    /* renamed from: a */
    private ArrayList f691a;

    public C0311a() {
        this.f691a = new ArrayList();
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
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public C0311a(p010b.p014d.p018d.p019a.C0316f r4) {
        /*
            r3 = this;
            r2 = 93
            r3.<init>()
            char r0 = r4.m1071d()
            r1 = 91
            if (r0 == r1) goto L15
            java.lang.String r0 = "A JSONArray text must start with '['"
            b.d.d.a.b r0 = r4.m1065a(r0)
            throw r0
        L15:
            char r0 = r4.m1071d()
            if (r0 == r2) goto L52
            r4.m1068a()
        L1e:
            char r0 = r4.m1071d()
            r1 = 44
            if (r0 != r1) goto L3f
            r4.m1068a()
            java.util.ArrayList r0 = r3.f691a
            java.lang.Object r1 = p010b.p014d.p018d.p019a.C0313c.f693a
            r0.add(r1)
        L30:
            char r0 = r4.m1071d()
            switch(r0) {
                case 44: goto L4c;
                case 59: goto L4c;
                case 93: goto L52;
                default: goto L37;
            }
        L37:
            java.lang.String r0 = "Expected a ',' or ']'"
            b.d.d.a.b r0 = r4.m1065a(r0)
            throw r0
        L3f:
            r4.m1068a()
            java.util.ArrayList r0 = r3.f691a
            java.lang.Object r1 = r4.m1072e()
            r0.add(r1)
            goto L30
        L4c:
            char r0 = r4.m1071d()
            if (r0 != r2) goto L53
        L52:
            return
        L53:
            r4.m1068a()
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: p010b.p014d.p018d.p019a.C0311a.<init>(b.d.d.a.f):void");
    }

    public C0311a(Collection collection) {
        this.f691a = new ArrayList();
        if (collection != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                this.f691a.add(C0313c.m1052c(it.next()));
            }
        }
    }

    public C0311a(Object obj) throws C0312b {
        this();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                m1044a(C0313c.m1052c(Array.get(obj, i)));
            }
            return;
        }
        throw new C0312b("JSONArray initial value should be a string or collection or array.");
    }

    /* renamed from: a */
    public Object m1045a(int i) throws C0312b {
        Object objM1048c = m1048c(i);
        if (objM1048c == null) {
            throw new C0312b("JSONArray[" + i + "] not found.");
        }
        return objM1048c;
    }

    /* renamed from: b */
    public C0313c m1047b(int i) {
        Object objM1045a = m1045a(i);
        if (objM1045a instanceof C0313c) {
            return (C0313c) objM1045a;
        }
        throw new C0312b("JSONArray[" + i + "] is not a JSONObject.");
    }

    /* renamed from: a */
    public String m1046a(String str) {
        int iM1043a = m1043a();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iM1043a; i++) {
            if (i > 0) {
                sb.append(str);
            }
            sb.append(C0313c.m1051b(this.f691a.get(i)));
        }
        return sb.toString();
    }

    /* renamed from: a */
    public int m1043a() {
        return this.f691a.size();
    }

    /* renamed from: c */
    public Object m1048c(int i) {
        if (i < 0 || i >= m1043a()) {
            return null;
        }
        return this.f691a.get(i);
    }

    /* renamed from: a */
    public C0311a m1044a(Object obj) {
        this.f691a.add(obj);
        return this;
    }

    public String toString() {
        try {
            return '[' + m1046a(",") + ']';
        } catch (Exception e) {
            return null;
        }
    }
}
