package com.google.p034a.p036b;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0564b;
import com.google.p034a.C0676j;
import com.google.p034a.InterfaceC0553a;
import com.google.p034a.InterfaceC0563af;
import com.google.p034a.p035a.InterfaceC0554a;
import com.google.p034a.p035a.InterfaceC0556c;
import com.google.p034a.p035a.InterfaceC0557d;
import com.google.p034a.p038c.C0664a;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Excluder.java */
/* renamed from: com.google.a.b.s */
/* loaded from: classes.dex */
public final class C0656s implements InterfaceC0563af, Cloneable {

    /* renamed from: a */
    public static final C0656s f1535a = new C0656s();

    /* renamed from: e */
    private boolean f1539e;

    /* renamed from: b */
    private double f1536b = -1.0d;

    /* renamed from: c */
    private int f1537c = 136;

    /* renamed from: d */
    private boolean f1538d = true;

    /* renamed from: f */
    private List<InterfaceC0553a> f1540f = Collections.emptyList();

    /* renamed from: g */
    private List<InterfaceC0553a> f1541g = Collections.emptyList();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0656s clone() {
        try {
            return (C0656s) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override // com.google.p034a.InterfaceC0563af
    /* renamed from: a */
    public <T> AbstractC0562ae<T> mo1950a(C0676j c0676j, C0664a<T> c0664a) {
        Class<? super T> clsM2103a = c0664a.m2103a();
        boolean zM2079a = m2079a((Class<?>) clsM2103a, true);
        boolean zM2079a2 = m2079a((Class<?>) clsM2103a, false);
        if (zM2079a || zM2079a2) {
            return new C0657t(this, zM2079a2, zM2079a, c0676j, c0664a);
        }
        return null;
    }

    /* renamed from: a */
    public boolean m2080a(Field field, boolean z) {
        InterfaceC0554a interfaceC0554a;
        if ((this.f1537c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f1536b == -1.0d || m2073a((InterfaceC0556c) field.getAnnotation(InterfaceC0556c.class), (InterfaceC0557d) field.getAnnotation(InterfaceC0557d.class))) && !field.isSynthetic()) {
            if (this.f1539e && ((interfaceC0554a = (InterfaceC0554a) field.getAnnotation(InterfaceC0554a.class)) == null || (!z ? interfaceC0554a.m1943b() : interfaceC0554a.m1942a()))) {
                return true;
            }
            if ((this.f1538d || !m2076b(field.getType())) && !m2075a(field.getType())) {
                List<InterfaceC0553a> list = z ? this.f1540f : this.f1541g;
                if (!list.isEmpty()) {
                    C0564b c0564b = new C0564b(field);
                    Iterator<InterfaceC0553a> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next().m1940a(c0564b)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    /* renamed from: a */
    public boolean m2079a(Class<?> cls, boolean z) {
        if (this.f1536b != -1.0d && !m2073a((InterfaceC0556c) cls.getAnnotation(InterfaceC0556c.class), (InterfaceC0557d) cls.getAnnotation(InterfaceC0557d.class))) {
            return true;
        }
        if ((this.f1538d || !m2076b(cls)) && !m2075a(cls)) {
            Iterator<InterfaceC0553a> it = (z ? this.f1540f : this.f1541g).iterator();
            while (it.hasNext()) {
                if (it.next().m1941a(cls)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m2075a(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    /* renamed from: b */
    private boolean m2076b(Class<?> cls) {
        return cls.isMemberClass() && !m2077c(cls);
    }

    /* renamed from: c */
    private boolean m2077c(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    /* renamed from: a */
    private boolean m2073a(InterfaceC0556c interfaceC0556c, InterfaceC0557d interfaceC0557d) {
        return m2072a(interfaceC0556c) && m2074a(interfaceC0557d);
    }

    /* renamed from: a */
    private boolean m2072a(InterfaceC0556c interfaceC0556c) {
        return interfaceC0556c == null || interfaceC0556c.m1945a() <= this.f1536b;
    }

    /* renamed from: a */
    private boolean m2074a(InterfaceC0557d interfaceC0557d) {
        return interfaceC0557d == null || interfaceC0557d.m1946a() > this.f1536b;
    }
}
