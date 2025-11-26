package com.sec.chaton.network.code;

import java.util.HashMap;

/* loaded from: classes.dex */
public class FaultCodeConvertor {

    /* renamed from: b */
    private static final Object[][] f2513b = {new Object[]{"CCS-00001", 10000}, new Object[]{"CCS-00002", 10001}, new Object[]{"CCS-00003", 10002}, new Object[]{"CCS-00011", 10003}, new Object[]{"CCS-00012", 10004}, new Object[]{"CCS-00911", 10005}, new Object[]{"CCS-00912", 10006}, new Object[]{"CCS-00013", 10007}, new Object[]{"CCS-00014", 10008}, new Object[]{"CCS-00052", 10009}, new Object[]{"CCS-00404", 10010}, new Object[]{"CCS-00900", 10011}};

    /* renamed from: c */
    private static final Object[][] f2514c = {new Object[]{"CGS-11001", 11000}, new Object[]{"CGS-11002", 11001}, new Object[]{"CGS-11003", 11002}, new Object[]{"CGS-11004", 11003}, new Object[]{"CGS-11005", 11004}, new Object[]{"CGS-11006", 11005}, new Object[]{"CGS-11007", 11006}, new Object[]{"CGS-11008", 11007}, new Object[]{"CGS-11051", 11008}, new Object[]{"CGS-11900", 11009}, new Object[]{"CGS-11901", 11010}};

    /* renamed from: d */
    private static final Object[][] f2515d = {new Object[]{"CCS-11001", 12000}, new Object[]{"CCS-11003", 12001}, new Object[]{"CCS-11004", 12002}, new Object[]{"CCS-11005", 12003}, new Object[]{"CCS-11006", 12004}, new Object[]{"CCS-11007", 12005}, new Object[]{"CCS-11051", 12006}, new Object[]{"CCS-11101", 12007}, new Object[]{"CCS-11102", 12008}, new Object[]{"CCS-11900", 12009}};

    /* renamed from: e */
    private static final Object[][] f2516e = {new Object[]{"CCS-12900", 13000}};

    /* renamed from: f */
    private static final Object[][] f2517f = {new Object[]{"CCS-21001", 14000}, new Object[]{"CCS-21002", 14001}, new Object[]{"CCS-21003", 14002}, new Object[]{"CCS-21004", 14003}, new Object[]{"CCS-21051", 14004}, new Object[]{"CCS-21052", 14005}, new Object[]{"CCS-21900", 14006}};

    /* renamed from: g */
    private static final Object[][] f2518g = {new Object[]{"CCS-22001", 15000}, new Object[]{"CCS-23001", 15001}, new Object[]{"CCS-24001", 15002}, new Object[]{"CCS-24002", 15003}, new Object[]{"CCS-24003", 15004}, new Object[]{"CCS-23900", 15005}, new Object[]{"CCS-23901", 15006}};

    /* renamed from: h */
    private static final Object[][] f2519h = {new Object[]{"CCS-25001", 16000}, new Object[]{"CCS-25002", 16001}, new Object[]{"CCS-25003", 16002}, new Object[]{"CCS-25004", 16003}, new Object[]{"CCS-25005", 16004}, new Object[]{"CCS-25007", 16005}, new Object[]{"CCS-25051", 16006}, new Object[]{"CCS-25052", 16007}, new Object[]{"CCS-25900", 16008}, new Object[]{"CCS-25901", 16009}};

    /* renamed from: i */
    private static final Object[][] f2520i = {new Object[]{"CCS-33900", 17000}, new Object[]{"CCS-33901", 17001}};

    /* renamed from: j */
    private static final Object[][] f2521j = {new Object[]{"CCS-31001", 18000}, new Object[]{"CCS-31002", 18001}, new Object[]{"CCS-31900", 18002}};

    /* renamed from: k */
    private static final Object[][] f2522k = {new Object[]{"CCS-32001", 19000}, new Object[]{"CCS-32002", 19001}, new Object[]{"CCS-32900", 19002}, new Object[]{"CCS-32901", 19003}};

    /* renamed from: l */
    private static final Object[][] f2523l = {new Object[]{"CCS-41001", 20000}, new Object[]{"CCS-41002", 20001}, new Object[]{"CCS-41003", 20002}, new Object[]{"CCS-41004", 20003}, new Object[]{"CCS-41005", 20004}, new Object[]{"CCS-41006", 20005}, new Object[]{"CCS-41051", 20008}, new Object[]{"CCS-41052", 20007}, new Object[]{"CCS-41900", 20008}};

    /* renamed from: m */
    private static final Object[][] f2524m = {new Object[]{"CCS-42900", 21000}};

    /* renamed from: n */
    private static final Object[][] f2525n = {new Object[]{"CCS-43900", 22000}};

    /* renamed from: o */
    private static final Object[][] f2526o = {new Object[]{"CCS-53001", 23000}, new Object[]{"CCS-53002", 23001}, new Object[]{"CCS-53900", 23002}, new Object[]{"CCS-53901", 23003}};

    /* renamed from: p */
    private static final Object[][] f2527p = {new Object[]{"CCS-54001", 24000}, new Object[]{"CCS-54002", 24001}, new Object[]{"CCS-54051", 24002}, new Object[]{"CCS-54052", 24003}, new Object[]{"CCS-54900", 24004}};

    /* renamed from: q */
    private static final Object[][] f2528q = {new Object[]{"CCS-61001", 25000}, new Object[]{"CCS-61002", 25001}, new Object[]{"CCS-61003", 25002}, new Object[]{"CCS-61051", 25003}, new Object[]{"CCS-61052", 25004}, new Object[]{"CCS-61900", 25005}};

    /* renamed from: r */
    private static final Object[][] f2529r = {new Object[]{"CCS-71001", 26000}, new Object[]{"CCS-71002", 26001}, new Object[]{"CCS-71003", 26002}, new Object[]{"CCS-71004", 26003}, new Object[]{"CCS-71005", 26004}, new Object[]{"CCS-71006", 26005}, new Object[]{"CCS-71900", 26006}, new Object[]{"CCS-71901", 26007}, new Object[]{"CCS-71902", 26008}, new Object[]{"CCS-71910", 26009}};

    /* renamed from: s */
    private static final Object[][] f2530s = {new Object[]{"CFS-00001", 27000}, new Object[]{"CFS-00002", 27001}, new Object[]{"CFS-00003", 27002}, new Object[]{"CFS-00011", 27003}, new Object[]{"CFS-00012", 27004}, new Object[]{"CFS-00911", 27005}, new Object[]{"CFS-00912", 27006}, new Object[]{"CFS-00013", 27007}, new Object[]{"CFS-00014", 27008}, new Object[]{"CFS-00404", 27009}, new Object[]{"CFS-00900", 27010}};

    /* renamed from: t */
    private static final Object[][] f2531t = {new Object[]{"CFS-11001", 28000}, new Object[]{"CFS-11002", 28001}, new Object[]{"CFS-11003", 28002}, new Object[]{"CFS-11004", 28003}, new Object[]{"CFS-11005", 28004}, new Object[]{"CFS-11900", 28005}, new Object[]{"CFS-11901", 28006}, new Object[]{"CFS-11902", 28007}};

    /* renamed from: u */
    private static final Object[][] f2532u = {new Object[]{"CFS-12001", 29000}, new Object[]{"CFS-12002", 29001}, new Object[]{"CFS-12003", 29002}, new Object[]{"CFS-12004", 29003}, new Object[]{"CFS-12005", 29004}, new Object[]{"CFS-12006", 29005}, new Object[]{"CFS-12900", 29006}, new Object[]{"CFS-12901", 29007}, new Object[]{"CFS-12902", 29008}};

    /* renamed from: v */
    private static final Object[][] f2533v = {new Object[]{"CSS-11001", 30000}, new Object[]{"CSS-11002", 30001}, new Object[]{"CSS-11005", 30002}, new Object[]{"CSS-11900", 30003}};

    /* renamed from: w */
    private static final Object[][] f2534w = {new Object[]{"CSS-12001", 40000}, new Object[]{"CSS-12002", 40001}, new Object[]{"CSS-12003", 40002}, new Object[]{"CSS-12004", 40003}, new Object[]{"CSS-12900", 40004}};

    /* renamed from: x */
    private static final Object[][] f2535x = {new Object[]{"CCS-86411", 86411}, new Object[]{"CCS-89411", 89411}};

    /* renamed from: a */
    private static HashMap f2512a = new HashMap();

    static {
        for (int i = 0; i < f2513b.length; i++) {
            f2512a.put((String) f2513b[i][0], (Integer) f2513b[i][1]);
        }
        for (int i2 = 0; i2 < f2514c.length; i2++) {
            f2512a.put((String) f2514c[i2][0], (Integer) f2514c[i2][1]);
        }
        for (int i3 = 0; i3 < f2515d.length; i3++) {
            f2512a.put((String) f2515d[i3][0], (Integer) f2515d[i3][1]);
        }
        for (int i4 = 0; i4 < f2516e.length; i4++) {
            f2512a.put((String) f2516e[i4][0], (Integer) f2516e[i4][1]);
        }
        for (int i5 = 0; i5 < f2517f.length; i5++) {
            f2512a.put((String) f2517f[i5][0], (Integer) f2517f[i5][1]);
        }
        for (int i6 = 0; i6 < f2518g.length; i6++) {
            f2512a.put((String) f2518g[i6][0], (Integer) f2518g[i6][1]);
        }
        for (int i7 = 0; i7 < f2519h.length; i7++) {
            f2512a.put((String) f2519h[i7][0], (Integer) f2519h[i7][1]);
        }
        for (int i8 = 0; i8 < f2520i.length; i8++) {
            f2512a.put((String) f2520i[i8][0], (Integer) f2520i[i8][1]);
        }
        for (int i9 = 0; i9 < f2521j.length; i9++) {
            f2512a.put((String) f2521j[i9][0], (Integer) f2521j[i9][1]);
        }
        for (int i10 = 0; i10 < f2522k.length; i10++) {
            f2512a.put((String) f2522k[i10][0], (Integer) f2522k[i10][1]);
        }
        for (int i11 = 0; i11 < f2523l.length; i11++) {
            f2512a.put((String) f2523l[i11][0], (Integer) f2523l[i11][1]);
        }
        for (int i12 = 0; i12 < f2524m.length; i12++) {
            f2512a.put((String) f2524m[i12][0], (Integer) f2524m[i12][1]);
        }
        for (int i13 = 0; i13 < f2525n.length; i13++) {
            f2512a.put((String) f2525n[i13][0], (Integer) f2525n[i13][1]);
        }
        for (int i14 = 0; i14 < f2526o.length; i14++) {
            f2512a.put((String) f2526o[i14][0], (Integer) f2526o[i14][1]);
        }
        for (int i15 = 0; i15 < f2527p.length; i15++) {
            f2512a.put((String) f2527p[i15][0], (Integer) f2527p[i15][1]);
        }
        for (int i16 = 0; i16 < f2528q.length; i16++) {
            f2512a.put((String) f2528q[i16][0], (Integer) f2528q[i16][1]);
        }
        for (int i17 = 0; i17 < f2529r.length; i17++) {
            f2512a.put((String) f2529r[i17][0], (Integer) f2529r[i17][1]);
        }
        for (int i18 = 0; i18 < f2530s.length; i18++) {
            f2512a.put((String) f2530s[i18][0], (Integer) f2530s[i18][1]);
        }
        for (int i19 = 0; i19 < f2531t.length; i19++) {
            f2512a.put((String) f2531t[i19][0], (Integer) f2531t[i19][1]);
        }
        for (int i20 = 0; i20 < f2532u.length; i20++) {
            f2512a.put((String) f2532u[i20][0], (Integer) f2532u[i20][1]);
        }
        for (int i21 = 0; i21 < f2533v.length; i21++) {
            f2512a.put((String) f2533v[i21][0], (Integer) f2533v[i21][1]);
        }
        for (int i22 = 0; i22 < f2534w.length; i22++) {
            f2512a.put((String) f2534w[i22][0], (Integer) f2534w[i22][1]);
        }
        for (int i23 = 0; i23 < f2535x.length; i23++) {
            f2512a.put((String) f2535x[i23][0], (Integer) f2535x[i23][1]);
        }
    }

    /* renamed from: a */
    public static int m2824a(String str) {
        if (f2512a.containsKey(str)) {
            return ((Integer) f2512a.get(str)).intValue();
        }
        return 0;
    }
}
