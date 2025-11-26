package com.sec.chaton.util;

/* compiled from: KoreanUtil.java */
/* renamed from: com.sec.chaton.util.bf */
/* loaded from: classes.dex */
public class C4841bf {

    /* renamed from: a */
    static final char[] f17653a = {12593, 12594, 12596, 12599, 12600, 12601, 12609, 12610, 12611, 12613, 12614, 12615, 12616, 12617, 12618, 12619, 12620, 12621, 12622};

    /* renamed from: b */
    static final char[] f17654b = {12623, 12624, 12625, 12626, 12627, 12628, 12629, 12630, 12631, 12632, 12633, 12634, 12635, 12636, 12637, 12638, 12639, 12640, 12641, 12642, 12643};

    /* renamed from: c */
    static final char[] f17655c = {0, 12593, 12594, 12595, 12596, 12597, 12598, 12599, 12601, 12602, 12603, 12604, 12605, 12606, 12607, 12608, 12609, 12610, 12612, 12613, 12614, 12615, 12616, 12618, 12619, 12620, 12621, 12622};

    /* renamed from: a */
    public static char m18318a(char c2) {
        if (c2 >= 44032 && c2 <= 55203) {
            int i = c2 - 44032;
            int i2 = i / 588;
            int i3 = (i % 588) % 28;
            return f17653a[i2];
        }
        if (C4842bg.m18319a(c2)) {
            return C4842bg.m18320b(c2);
        }
        if (C4842bg.m18321c(c2)) {
            return '#';
        }
        return c2;
    }
}
