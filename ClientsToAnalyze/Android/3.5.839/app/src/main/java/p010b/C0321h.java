package p010b;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import p010b.p012b.C0274c;
import p010b.p012b.InterfaceC0273b;
import p010b.p013c.C0283b;
import p010b.p013c.InterfaceC0282a;

/* compiled from: TwitterFactory.java */
/* renamed from: b.h */
/* loaded from: classes.dex */
public final class C0321h implements Serializable {

    /* renamed from: a */
    static final InterfaceC0273b f709a = C0274c.m956a(C0283b.m989a());

    /* renamed from: b */
    private static final Constructor<InterfaceC0319f> f710b;

    /* renamed from: c */
    private static final InterfaceC0319f f711c;

    /* renamed from: d */
    private final InterfaceC0282a f712d;

    static {
        String str = null;
        if (C0283b.m989a().m978b()) {
            try {
                Class.forName("twitter4j.AppEngineTwitterImpl");
                str = "twitter4j.AppEngineTwitterImpl";
            } catch (ClassNotFoundException e) {
            }
        }
        if (str == null) {
            str = "twitter4j.TwitterImpl";
        }
        try {
            f710b = Class.forName(str).getDeclaredConstructor(InterfaceC0282a.class, InterfaceC0273b.class);
            try {
                f711c = f710b.newInstance(C0283b.m989a(), f709a);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InstantiationException e3) {
                throw new AssertionError(e3);
            } catch (InvocationTargetException e4) {
                throw new AssertionError(e4);
            }
        } catch (ClassNotFoundException e5) {
            throw new AssertionError(e5);
        } catch (NoSuchMethodException e6) {
            throw new AssertionError(e6);
        }
    }

    public C0321h() {
        this(C0283b.m989a());
    }

    public C0321h(InterfaceC0282a interfaceC0282a) {
        if (interfaceC0282a == null) {
            throw new NullPointerException("configuration cannot be null");
        }
        this.f712d = interfaceC0282a;
    }

    /* renamed from: a */
    public InterfaceC0319f m1082a() {
        return m1083a(C0274c.m956a(this.f712d));
    }

    /* renamed from: a */
    public InterfaceC0319f m1083a(InterfaceC0273b interfaceC0273b) {
        try {
            return f710b.newInstance(this.f712d, interfaceC0273b);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new AssertionError(e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError(e3);
        }
    }
}
