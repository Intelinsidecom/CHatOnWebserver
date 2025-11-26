package com.sec.chaton.settings.p096a;

/* compiled from: AniconHelper.java */
/* renamed from: com.sec.chaton.settings.a.i */
/* loaded from: classes.dex */
public enum EnumC3465i {
    NORMAL(0),
    HAPTIC(1),
    SOUND(2),
    MOTION(4),
    HAPTIC_SOUND(3),
    HAPTIC_MOTION(5),
    SOUND_MOTION(6),
    ALL_HSM(7);


    /* renamed from: i */
    private int f12933i;

    EnumC3465i(int i) {
        this.f12933i = i;
    }

    /* renamed from: a */
    public int m13792a() {
        return this.f12933i;
    }

    /* renamed from: a */
    public static EnumC3465i m13791a(int i) {
        switch (i) {
        }
        return NORMAL;
    }
}
