package com.sec.chaton.specialbuddy;

import com.sec.chaton.util.C4904y;

/* compiled from: LiveServiceType.java */
/* renamed from: com.sec.chaton.specialbuddy.n */
/* loaded from: classes.dex */
public enum EnumC4549n {
    LIVEINVALID(-1),
    LIVECHAT(1),
    LIVECONTENTS(2);


    /* renamed from: d */
    private int f16421d;

    EnumC4549n(int i) {
        this.f16421d = i;
    }

    /* renamed from: a */
    public int m17247a() {
        return this.f16421d;
    }

    /* renamed from: b */
    public String m17248b() {
        return String.valueOf(this.f16421d);
    }

    /* renamed from: a */
    public static EnumC4549n m17245a(int i) {
        switch (i) {
            case 1:
                return LIVECHAT;
            case 2:
                return LIVECONTENTS;
            default:
                return LIVEINVALID;
        }
    }

    /* renamed from: a */
    public static EnumC4549n m17246a(String str) throws NumberFormatException {
        int i = 0;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, EnumC4549n.class.getSimpleName());
            }
        }
        return m17245a(i);
    }
}
