package com.google.p034a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LongSerializationPolicy.java */
/* renamed from: com.google.a.ab */
/* loaded from: classes.dex */
public abstract class EnumC0559ab {

    /* renamed from: a */
    public static final EnumC0559ab f1371a = new C0560ac("DEFAULT", 0);

    /* renamed from: b */
    public static final EnumC0559ab f1372b;

    /* renamed from: c */
    private static final /* synthetic */ EnumC0559ab[] f1373c;

    private EnumC0559ab(String str, int i) {
    }

    /* synthetic */ EnumC0559ab(String str, int i, C0560ac c0560ac) {
        this(str, i);
    }

    public static EnumC0559ab valueOf(String str) {
        return (EnumC0559ab) Enum.valueOf(EnumC0559ab.class, str);
    }

    public static EnumC0559ab[] values() {
        return (EnumC0559ab[]) f1373c.clone();
    }

    static {
        final int i = 1;
        final String str = "STRING";
        f1372b = new EnumC0559ab(str, i) { // from class: com.google.a.ad
            {
                C0560ac c0560ac = null;
            }
        };
        f1373c = new EnumC0559ab[]{f1371a, f1372b};
    }
}
