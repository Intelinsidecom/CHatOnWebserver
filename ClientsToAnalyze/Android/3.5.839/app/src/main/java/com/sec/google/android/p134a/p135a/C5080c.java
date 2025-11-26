package com.sec.google.android.p134a.p135a;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* compiled from: CharacterSets.java */
/* renamed from: com.sec.google.android.a.a.c */
/* loaded from: classes.dex */
public class C5080c {

    /* renamed from: a */
    static final /* synthetic */ boolean f18519a;

    /* renamed from: b */
    private static final int[] f18520b;

    /* renamed from: c */
    private static final String[] f18521c;

    /* renamed from: d */
    private static final HashMap<Integer, String> f18522d;

    /* renamed from: e */
    private static final HashMap<String, Integer> f18523e;

    static {
        f18519a = !C5080c.class.desiredAssertionStatus();
        f18520b = new int[]{0, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 17, 106, 2026, 1000, 1015};
        f18521c = new String[]{"*", "us-ascii", "iso-8859-1", "iso-8859-2", "iso-8859-3", "iso-8859-4", "iso-8859-5", "iso-8859-6", "iso-8859-7", "iso-8859-8", "iso-8859-9", "shift_JIS", "utf-8", "big5", "iso-10646-ucs-2", "utf-16"};
        f18522d = new HashMap<>();
        f18523e = new HashMap<>();
        if (!f18519a && f18520b.length != f18521c.length) {
            throw new AssertionError();
        }
        int length = f18520b.length - 1;
        for (int i = 0; i <= length; i++) {
            f18522d.put(Integer.valueOf(f18520b[i]), f18521c[i]);
            f18523e.put(f18521c[i], Integer.valueOf(f18520b[i]));
        }
    }

    private C5080c() {
    }

    /* renamed from: a */
    public static String m19300a(int i) throws UnsupportedEncodingException {
        String str = f18522d.get(Integer.valueOf(i));
        if (str == null) {
            throw new UnsupportedEncodingException();
        }
        return str;
    }

    /* renamed from: a */
    public static int m19299a(String str) throws UnsupportedEncodingException {
        if (str == null) {
            return -1;
        }
        Integer num = f18523e.get(str);
        if (num == null) {
            throw new UnsupportedEncodingException();
        }
        return num.intValue();
    }
}
