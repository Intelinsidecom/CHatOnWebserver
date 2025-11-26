package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.AbstractC0686t;
import com.google.p034a.InterfaceC0563af;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.a.b.a.y */
/* loaded from: classes.dex */
public final class C0622y {

    /* renamed from: a */
    public static final AbstractC0562ae<Class> f1456a = new C0623z();

    /* renamed from: b */
    public static final InterfaceC0563af f1457b = m2030a(Class.class, f1456a);

    /* renamed from: c */
    public static final AbstractC0562ae<BitSet> f1458c = new C0577ak();

    /* renamed from: d */
    public static final InterfaceC0563af f1459d = m2030a(BitSet.class, f1458c);

    /* renamed from: e */
    public static final AbstractC0562ae<Boolean> f1460e = new C0588av();

    /* renamed from: f */
    public static final AbstractC0562ae<Boolean> f1461f = new C0592az();

    /* renamed from: g */
    public static final InterfaceC0563af f1462g = m2031a(Boolean.TYPE, Boolean.class, f1460e);

    /* renamed from: h */
    public static final AbstractC0562ae<Number> f1463h = new C0594ba();

    /* renamed from: i */
    public static final InterfaceC0563af f1464i = m2031a(Byte.TYPE, Byte.class, f1463h);

    /* renamed from: j */
    public static final AbstractC0562ae<Number> f1465j = new C0595bb();

    /* renamed from: k */
    public static final InterfaceC0563af f1466k = m2031a(Short.TYPE, Short.class, f1465j);

    /* renamed from: l */
    public static final AbstractC0562ae<Number> f1467l = new C0596bc();

    /* renamed from: m */
    public static final InterfaceC0563af f1468m = m2031a(Integer.TYPE, Integer.class, f1467l);

    /* renamed from: n */
    public static final AbstractC0562ae<Number> f1469n = new C0597bd();

    /* renamed from: o */
    public static final AbstractC0562ae<Number> f1470o = new C0598be();

    /* renamed from: p */
    public static final AbstractC0562ae<Number> f1471p = new C0567aa();

    /* renamed from: q */
    public static final AbstractC0562ae<Number> f1472q = new C0568ab();

    /* renamed from: r */
    public static final InterfaceC0563af f1473r = m2030a(Number.class, f1472q);

    /* renamed from: s */
    public static final AbstractC0562ae<Character> f1474s = new C0569ac();

    /* renamed from: t */
    public static final InterfaceC0563af f1475t = m2031a(Character.TYPE, Character.class, f1474s);

    /* renamed from: u */
    public static final AbstractC0562ae<String> f1476u = new C0570ad();

    /* renamed from: v */
    public static final AbstractC0562ae<BigDecimal> f1477v = new C0571ae();

    /* renamed from: w */
    public static final AbstractC0562ae<BigInteger> f1478w = new C0572af();

    /* renamed from: x */
    public static final InterfaceC0563af f1479x = m2030a(String.class, f1476u);

    /* renamed from: y */
    public static final AbstractC0562ae<StringBuilder> f1480y = new C0573ag();

    /* renamed from: z */
    public static final InterfaceC0563af f1481z = m2030a(StringBuilder.class, f1480y);

    /* renamed from: A */
    public static final AbstractC0562ae<StringBuffer> f1438A = new C0574ah();

    /* renamed from: B */
    public static final InterfaceC0563af f1439B = m2030a(StringBuffer.class, f1438A);

    /* renamed from: C */
    public static final AbstractC0562ae<URL> f1440C = new C0575ai();

    /* renamed from: D */
    public static final InterfaceC0563af f1441D = m2030a(URL.class, f1440C);

    /* renamed from: E */
    public static final AbstractC0562ae<URI> f1442E = new C0576aj();

    /* renamed from: F */
    public static final InterfaceC0563af f1443F = m2030a(URI.class, f1442E);

    /* renamed from: G */
    public static final AbstractC0562ae<InetAddress> f1444G = new C0578al();

    /* renamed from: H */
    public static final InterfaceC0563af f1445H = m2032b(InetAddress.class, f1444G);

    /* renamed from: I */
    public static final AbstractC0562ae<UUID> f1446I = new C0579am();

    /* renamed from: J */
    public static final InterfaceC0563af f1447J = m2030a(UUID.class, f1446I);

    /* renamed from: K */
    public static final InterfaceC0563af f1448K = new C0580an();

    /* renamed from: L */
    public static final AbstractC0562ae<Calendar> f1449L = new C0582ap();

    /* renamed from: M */
    public static final InterfaceC0563af f1450M = m2033b(Calendar.class, GregorianCalendar.class, f1449L);

    /* renamed from: N */
    public static final AbstractC0562ae<Locale> f1451N = new C0583aq();

    /* renamed from: O */
    public static final InterfaceC0563af f1452O = m2030a(Locale.class, f1451N);

    /* renamed from: P */
    public static final AbstractC0562ae<AbstractC0686t> f1453P = new C0584ar();

    /* renamed from: Q */
    public static final InterfaceC0563af f1454Q = m2032b(AbstractC0686t.class, f1453P);

    /* renamed from: R */
    public static final InterfaceC0563af f1455R = m2029a();

    /* renamed from: a */
    public static InterfaceC0563af m2029a() {
        return new C0585as();
    }

    /* renamed from: a */
    public static <TT> InterfaceC0563af m2030a(Class<TT> cls, AbstractC0562ae<TT> abstractC0562ae) {
        return new C0586at(cls, abstractC0562ae);
    }

    /* renamed from: a */
    public static <TT> InterfaceC0563af m2031a(Class<TT> cls, Class<TT> cls2, AbstractC0562ae<? super TT> abstractC0562ae) {
        return new C0587au(cls, cls2, abstractC0562ae);
    }

    /* renamed from: b */
    public static <TT> InterfaceC0563af m2033b(Class<TT> cls, Class<? extends TT> cls2, AbstractC0562ae<? super TT> abstractC0562ae) {
        return new C0589aw(cls, cls2, abstractC0562ae);
    }

    /* renamed from: b */
    public static <TT> InterfaceC0563af m2032b(Class<TT> cls, AbstractC0562ae<TT> abstractC0562ae) {
        return new C0590ax(cls, abstractC0562ae);
    }
}
