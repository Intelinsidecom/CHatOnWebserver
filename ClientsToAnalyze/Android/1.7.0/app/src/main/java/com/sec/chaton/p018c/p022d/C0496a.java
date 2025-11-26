package com.sec.chaton.p018c.p022d;

import java.util.HashMap;

/* compiled from: FaultCodeConvertor.java */
/* renamed from: com.sec.chaton.c.d.a */
/* loaded from: classes.dex */
public class C0496a {

    /* renamed from: b */
    private static final Object[][] f1588b = {new Object[]{"CCS-00001", 10000}, new Object[]{"CCS-00002", 10001}, new Object[]{"CCS-00003", 10002}, new Object[]{"CCS-00011", 10003}, new Object[]{"CCS-00012", 10004}, new Object[]{"CCS-00911", 10005}, new Object[]{"CCS-00912", 10006}, new Object[]{"CCS-00013", 10007}, new Object[]{"CCS-00014", 10008}, new Object[]{"CCS-00052", 10009}, new Object[]{"CCS-00404", 10010}, new Object[]{"CCS-00900", 10011}};

    /* renamed from: c */
    private static final Object[][] f1589c = {new Object[]{"CGS-11001", 11000}, new Object[]{"CGS-11002", 11001}, new Object[]{"CGS-11003", 11002}, new Object[]{"CGS-11004", 11003}, new Object[]{"CGS-11005", 11004}, new Object[]{"CGS-11006", 11005}, new Object[]{"CGS-11007", 11006}, new Object[]{"CGS-11008", 11007}, new Object[]{"CGS-11051", 11008}, new Object[]{"CGS-11900", 11009}, new Object[]{"CGS-11901", 11010}};

    /* renamed from: d */
    private static final Object[][] f1590d = {new Object[]{"CCS-11001", 12000}, new Object[]{"CCS-11003", 12001}, new Object[]{"CCS-11004", 12002}, new Object[]{"CCS-11005", 12003}, new Object[]{"CCS-11006", 12004}, new Object[]{"CCS-11007", 12005}, new Object[]{"CCS-11051", 12006}, new Object[]{"CCS-11101", 12007}, new Object[]{"CCS-11102", 12008}, new Object[]{"CCS-11900", 12009}};

    /* renamed from: e */
    private static final Object[][] f1591e = {new Object[]{"CCS-12900", 13000}};

    /* renamed from: f */
    private static final Object[][] f1592f = {new Object[]{"CCS-21001", 14000}, new Object[]{"CCS-21002", 14001}, new Object[]{"CCS-21003", 14002}, new Object[]{"CCS-21004", 14003}, new Object[]{"CCS-21051", 14004}, new Object[]{"CCS-21052", 14005}, new Object[]{"CCS-21900", 14006}};

    /* renamed from: g */
    private static final Object[][] f1593g = {new Object[]{"CCS-22001", 15000}, new Object[]{"CCS-23001", 15001}, new Object[]{"CCS-24001", 15002}, new Object[]{"CCS-24002", 15003}, new Object[]{"CCS-24003", 15004}, new Object[]{"CCS-23900", 15005}, new Object[]{"CCS-23901", 15006}, new Object[]{"CCS-24007", 15007}, new Object[]{"CCS-24008", 15008}, new Object[]{"CCS-24009", 15009}, new Object[]{"CCS-24010", 15010}};

    /* renamed from: h */
    private static final Object[][] f1594h = {new Object[]{"CCS-25001", 16000}, new Object[]{"CCS-25002", 16001}, new Object[]{"CCS-25003", 16002}, new Object[]{"CCS-25004", 16003}, new Object[]{"CCS-25005", 16004}, new Object[]{"CCS-25007", 16005}, new Object[]{"CCS-25051", 16006}, new Object[]{"CCS-25052", 16007}, new Object[]{"CCS-25900", 16008}, new Object[]{"CCS-25901", 16009}};

    /* renamed from: i */
    private static final Object[][] f1595i = {new Object[]{"CCS-33900", 17000}, new Object[]{"CCS-33901", 17001}};

    /* renamed from: j */
    private static final Object[][] f1596j = {new Object[]{"CCS-31001", 18000}, new Object[]{"CCS-31002", 18001}, new Object[]{"CCS-31900", 18002}};

    /* renamed from: k */
    private static final Object[][] f1597k = {new Object[]{"CCS-32001", 19000}, new Object[]{"CCS-32002", 19001}, new Object[]{"CCS-32900", 19002}, new Object[]{"CCS-32901", 19003}};

    /* renamed from: l */
    private static final Object[][] f1598l = {new Object[]{"CCS-41001", 20000}, new Object[]{"CCS-41002", 20001}, new Object[]{"CCS-41003", 20002}, new Object[]{"CCS-41004", 20003}, new Object[]{"CCS-41005", 20004}, new Object[]{"CCS-41006", 20005}, new Object[]{"CCS-41051", 20008}, new Object[]{"CCS-41052", 20007}, new Object[]{"CCS-41900", 20008}};

    /* renamed from: m */
    private static final Object[][] f1599m = {new Object[]{"CCS-42900", 21000}};

    /* renamed from: n */
    private static final Object[][] f1600n = {new Object[]{"CCS-43900", 22000}};

    /* renamed from: o */
    private static final Object[][] f1601o = {new Object[]{"CCS-53001", 23000}, new Object[]{"CCS-53002", 23001}, new Object[]{"CCS-53900", 23002}, new Object[]{"CCS-53901", 23003}};

    /* renamed from: p */
    private static final Object[][] f1602p = {new Object[]{"CCS-54001", 24000}, new Object[]{"CCS-54002", 24001}, new Object[]{"CCS-54051", 24002}, new Object[]{"CCS-54052", 24003}, new Object[]{"CCS-54900", 24004}};

    /* renamed from: q */
    private static final Object[][] f1603q = {new Object[]{"CCS-61001", 25000}, new Object[]{"CCS-61002", 25001}, new Object[]{"CCS-61003", 25002}, new Object[]{"CCS-61051", 25003}, new Object[]{"CCS-61052", 25004}, new Object[]{"CCS-61900", 25005}};

    /* renamed from: r */
    private static final Object[][] f1604r = {new Object[]{"CCS-71001", 26000}, new Object[]{"CCS-71002", 26001}, new Object[]{"CCS-71003", 26002}, new Object[]{"CCS-71004", 26003}, new Object[]{"CCS-71005", 26004}, new Object[]{"CCS-71006", 26005}, new Object[]{"CCS-71900", 26006}, new Object[]{"CCS-71901", 26007}, new Object[]{"CCS-71902", 26008}, new Object[]{"CCS-71910", 26009}};

    /* renamed from: s */
    private static final Object[][] f1605s = {new Object[]{"CFS-00001", 27000}, new Object[]{"CFS-00002", 27001}, new Object[]{"CFS-00003", 27002}, new Object[]{"CFS-00011", 27003}, new Object[]{"CFS-00012", 27004}, new Object[]{"CFS-00911", 27005}, new Object[]{"CFS-00912", 27006}, new Object[]{"CFS-00013", 27007}, new Object[]{"CFS-00014", 27008}, new Object[]{"CFS-00404", 27009}, new Object[]{"CFS-00900", 27010}};

    /* renamed from: t */
    private static final Object[][] f1606t = {new Object[]{"CFS-11001", 28000}, new Object[]{"CFS-11002", 28001}, new Object[]{"CFS-11003", 28002}, new Object[]{"CFS-11004", 28003}, new Object[]{"CFS-11005", 28004}, new Object[]{"CFS-11900", 28005}, new Object[]{"CFS-11901", 28006}, new Object[]{"CFS-11902", 28007}};

    /* renamed from: u */
    private static final Object[][] f1607u = {new Object[]{"CFS-12001", 29000}, new Object[]{"CFS-12002", 29001}, new Object[]{"CFS-12003", 29002}, new Object[]{"CFS-12004", 29003}, new Object[]{"CFS-12005", 29004}, new Object[]{"CFS-12006", 29005}, new Object[]{"CFS-12900", 29006}, new Object[]{"CFS-12901", 29007}, new Object[]{"CFS-12902", 29008}};

    /* renamed from: v */
    private static final Object[][] f1608v = {new Object[]{"CSS-11001", 30000}, new Object[]{"CSS-11002", 30001}, new Object[]{"CSS-11005", 30002}, new Object[]{"CSS-11900", 30003}};

    /* renamed from: w */
    private static final Object[][] f1609w = {new Object[]{"CSS-12001", 40000}, new Object[]{"CSS-12002", 40001}, new Object[]{"CSS-12003", 40002}, new Object[]{"CSS-12004", 40003}, new Object[]{"CSS-12005", 40005}, new Object[]{"CSS-12900", 40004}};

    /* renamed from: x */
    private static final Object[][] f1610x = {new Object[]{"CSS-22001", 41000}, new Object[]{"CSS-22002", 41001}, new Object[]{"CSS-22005", 41002}, new Object[]{"CSS-22900", 41003}};

    /* renamed from: y */
    private static final Object[][] f1611y = {new Object[]{"CSS-21001", 31000}, new Object[]{"CSS-21002", 31001}, new Object[]{"CSS-21900", 31002}};

    /* renamed from: z */
    private static final Object[][] f1612z = {new Object[]{"CCS-86411", 86411}, new Object[]{"CCS-89411", 89411}};

    /* renamed from: A */
    private static final Object[][] f1586A = {new Object[]{"CCS-73004", 42001}, new Object[]{"CCS-73002", 42002}};

    /* renamed from: a */
    private static HashMap f1587a = new HashMap();

    /* renamed from: a */
    public static int m2519a(String str) {
        if (f1587a.containsKey(str)) {
            return ((Integer) f1587a.get(str)).intValue();
        }
        return 0;
    }

    static {
        for (int i = 0; i < f1588b.length; i++) {
            f1587a.put((String) f1588b[i][0], (Integer) f1588b[i][1]);
        }
        for (int i2 = 0; i2 < f1589c.length; i2++) {
            f1587a.put((String) f1589c[i2][0], (Integer) f1589c[i2][1]);
        }
        for (int i3 = 0; i3 < f1590d.length; i3++) {
            f1587a.put((String) f1590d[i3][0], (Integer) f1590d[i3][1]);
        }
        for (int i4 = 0; i4 < f1591e.length; i4++) {
            f1587a.put((String) f1591e[i4][0], (Integer) f1591e[i4][1]);
        }
        for (int i5 = 0; i5 < f1592f.length; i5++) {
            f1587a.put((String) f1592f[i5][0], (Integer) f1592f[i5][1]);
        }
        for (int i6 = 0; i6 < f1593g.length; i6++) {
            f1587a.put((String) f1593g[i6][0], (Integer) f1593g[i6][1]);
        }
        for (int i7 = 0; i7 < f1594h.length; i7++) {
            f1587a.put((String) f1594h[i7][0], (Integer) f1594h[i7][1]);
        }
        for (int i8 = 0; i8 < f1595i.length; i8++) {
            f1587a.put((String) f1595i[i8][0], (Integer) f1595i[i8][1]);
        }
        for (int i9 = 0; i9 < f1596j.length; i9++) {
            f1587a.put((String) f1596j[i9][0], (Integer) f1596j[i9][1]);
        }
        for (int i10 = 0; i10 < f1597k.length; i10++) {
            f1587a.put((String) f1597k[i10][0], (Integer) f1597k[i10][1]);
        }
        for (int i11 = 0; i11 < f1598l.length; i11++) {
            f1587a.put((String) f1598l[i11][0], (Integer) f1598l[i11][1]);
        }
        for (int i12 = 0; i12 < f1599m.length; i12++) {
            f1587a.put((String) f1599m[i12][0], (Integer) f1599m[i12][1]);
        }
        for (int i13 = 0; i13 < f1600n.length; i13++) {
            f1587a.put((String) f1600n[i13][0], (Integer) f1600n[i13][1]);
        }
        for (int i14 = 0; i14 < f1601o.length; i14++) {
            f1587a.put((String) f1601o[i14][0], (Integer) f1601o[i14][1]);
        }
        for (int i15 = 0; i15 < f1602p.length; i15++) {
            f1587a.put((String) f1602p[i15][0], (Integer) f1602p[i15][1]);
        }
        for (int i16 = 0; i16 < f1603q.length; i16++) {
            f1587a.put((String) f1603q[i16][0], (Integer) f1603q[i16][1]);
        }
        for (int i17 = 0; i17 < f1604r.length; i17++) {
            f1587a.put((String) f1604r[i17][0], (Integer) f1604r[i17][1]);
        }
        for (int i18 = 0; i18 < f1605s.length; i18++) {
            f1587a.put((String) f1605s[i18][0], (Integer) f1605s[i18][1]);
        }
        for (int i19 = 0; i19 < f1606t.length; i19++) {
            f1587a.put((String) f1606t[i19][0], (Integer) f1606t[i19][1]);
        }
        for (int i20 = 0; i20 < f1607u.length; i20++) {
            f1587a.put((String) f1607u[i20][0], (Integer) f1607u[i20][1]);
        }
        for (int i21 = 0; i21 < f1608v.length; i21++) {
            f1587a.put((String) f1608v[i21][0], (Integer) f1608v[i21][1]);
        }
        for (int i22 = 0; i22 < f1609w.length; i22++) {
            f1587a.put((String) f1609w[i22][0], (Integer) f1609w[i22][1]);
        }
        for (int i23 = 0; i23 < f1610x.length; i23++) {
            f1587a.put((String) f1610x[i23][0], (Integer) f1610x[i23][1]);
        }
        for (int i24 = 0; i24 < f1611y.length; i24++) {
            f1587a.put((String) f1611y[i24][0], (Integer) f1611y[i24][1]);
        }
        for (int i25 = 0; i25 < f1612z.length; i25++) {
            f1587a.put((String) f1612z[i25][0], (Integer) f1612z[i25][1]);
        }
        for (int i26 = 0; i26 < f1586A.length; i26++) {
            f1587a.put((String) f1586A[i26][0], (Integer) f1586A[i26][1]);
        }
    }
}
