package com.sec.chaton.smsplugin.p111h;

import android.content.Context;
import com.sec.chaton.R;
import java.util.HashMap;
import java.util.regex.Pattern;

/* compiled from: SmileyParser.java */
/* renamed from: com.sec.chaton.smsplugin.h.aa */
/* loaded from: classes.dex */
public class C3876aa {

    /* renamed from: a */
    public static final int[] f13942a = {C3877ab.m14954a(C3877ab.f13948a), C3877ab.m14954a(C3877ab.f13949b), C3877ab.m14954a(C3877ab.f13950c), C3877ab.m14954a(C3877ab.f13951d), C3877ab.m14954a(C3877ab.f13952e), C3877ab.m14954a(C3877ab.f13953f), C3877ab.m14954a(C3877ab.f13954g), C3877ab.m14954a(C3877ab.f13955h), C3877ab.m14954a(C3877ab.f13956i), C3877ab.m14954a(C3877ab.f13957j), C3877ab.m14954a(C3877ab.f13958k), C3877ab.m14954a(C3877ab.f13959l), C3877ab.m14954a(C3877ab.f13960m), C3877ab.m14954a(C3877ab.f13961n), C3877ab.m14954a(C3877ab.f13962o), C3877ab.m14954a(C3877ab.f13963p), C3877ab.m14954a(C3877ab.f13964q), C3877ab.m14954a(C3877ab.f13965r), C3877ab.m14954a(C3877ab.f13966s), C3877ab.m14954a(C3877ab.f13967t), C3877ab.m14954a(C3877ab.f13968u)};

    /* renamed from: b */
    private static C3876aa f13943b;

    /* renamed from: c */
    private final Context f13944c;

    /* renamed from: d */
    private final String[] f13945d;

    /* renamed from: f */
    private final HashMap<String, Integer> f13947f = m14951a();

    /* renamed from: e */
    private final Pattern f13946e = m14953b();

    /* renamed from: a */
    public static void m14952a(Context context) {
        f13943b = new C3876aa(context);
    }

    private C3876aa(Context context) {
        this.f13944c = context;
        this.f13945d = this.f13944c.getResources().getStringArray(R.array.default_smiley_texts);
    }

    /* renamed from: a */
    private HashMap<String, Integer> m14951a() {
        if (f13942a.length != this.f13945d.length) {
            throw new IllegalStateException("Smiley resource ID/text mismatch");
        }
        HashMap<String, Integer> map = new HashMap<>(this.f13945d.length);
        for (int i = 0; i < this.f13945d.length; i++) {
            map.put(this.f13945d[i], Integer.valueOf(f13942a[i]));
        }
        return map;
    }

    /* renamed from: b */
    private Pattern m14953b() {
        StringBuilder sb = new StringBuilder(this.f13945d.length * 3);
        sb.append('(');
        for (String str : this.f13945d) {
            sb.append(Pattern.quote(str));
            sb.append('|');
        }
        sb.replace(sb.length() - 1, sb.length(), ")");
        return Pattern.compile(sb.toString());
    }
}
