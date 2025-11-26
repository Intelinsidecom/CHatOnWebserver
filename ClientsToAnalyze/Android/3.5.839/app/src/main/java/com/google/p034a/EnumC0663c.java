package com.google.p034a;

import java.lang.reflect.Field;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FieldNamingPolicy.java */
/* renamed from: com.google.a.c */
/* loaded from: classes.dex */
public abstract class EnumC0663c implements InterfaceC0675i {

    /* renamed from: a */
    public static final EnumC0663c f1561a = new C0665d("IDENTITY", 0);

    /* renamed from: b */
    public static final EnumC0663c f1562b;

    /* renamed from: c */
    public static final EnumC0663c f1563c;

    /* renamed from: d */
    public static final EnumC0663c f1564d;

    /* renamed from: e */
    public static final EnumC0663c f1565e;

    /* renamed from: f */
    private static final /* synthetic */ EnumC0663c[] f1566f;

    private EnumC0663c(String str, int i) {
    }

    /* synthetic */ EnumC0663c(String str, int i, C0665d c0665d) {
        this(str, i);
    }

    public static EnumC0663c valueOf(String str) {
        return (EnumC0663c) Enum.valueOf(EnumC0663c.class, str);
    }

    public static EnumC0663c[] values() {
        return (EnumC0663c[]) f1566f.clone();
    }

    static {
        final int i = 4;
        final int i2 = 3;
        final int i3 = 2;
        final int i4 = 1;
        final String str = "UPPER_CAMEL_CASE";
        f1562b = new EnumC0663c(str, i4) { // from class: com.google.a.e
            {
                C0665d c0665d = null;
            }

            @Override // com.google.p034a.InterfaceC0675i
            /* renamed from: a */
            public String mo2105a(Field field) {
                return EnumC0663c.m2098b(field.getName());
            }
        };
        final String str2 = "UPPER_CAMEL_CASE_WITH_SPACES";
        f1563c = new EnumC0663c(str2, i3) { // from class: com.google.a.f
            {
                C0665d c0665d = null;
            }

            @Override // com.google.p034a.InterfaceC0675i
            /* renamed from: a */
            public String mo2105a(Field field) {
                return EnumC0663c.m2098b(EnumC0663c.m2099b(field.getName(), " "));
            }
        };
        final String str3 = "LOWER_CASE_WITH_UNDERSCORES";
        f1564d = new EnumC0663c(str3, i2) { // from class: com.google.a.g
            {
                C0665d c0665d = null;
            }

            @Override // com.google.p034a.InterfaceC0675i
            /* renamed from: a */
            public String mo2105a(Field field) {
                return EnumC0663c.m2099b(field.getName(), "_").toLowerCase();
            }
        };
        final String str4 = "LOWER_CASE_WITH_DASHES";
        f1565e = new EnumC0663c(str4, i) { // from class: com.google.a.h
            {
                C0665d c0665d = null;
            }

            @Override // com.google.p034a.InterfaceC0675i
            /* renamed from: a */
            public String mo2105a(Field field) {
                return EnumC0663c.m2099b(field.getName(), "-").toLowerCase();
            }
        };
        f1566f = new EnumC0663c[]{f1561a, f1562b, f1563c, f1564d, f1565e};
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m2099b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m2098b(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        char cCharAt = str.charAt(0);
        while (i < str.length() - 1 && !Character.isLetter(cCharAt)) {
            sb.append(cCharAt);
            i++;
            cCharAt = str.charAt(i);
        }
        if (i == str.length()) {
            return sb.toString();
        }
        if (!Character.isUpperCase(cCharAt)) {
            return sb.append(m2095a(Character.toUpperCase(cCharAt), str, i + 1)).toString();
        }
        return str;
    }

    /* renamed from: a */
    private static String m2095a(char c2, String str, int i) {
        return i < str.length() ? c2 + str.substring(i) : String.valueOf(c2);
    }
}
