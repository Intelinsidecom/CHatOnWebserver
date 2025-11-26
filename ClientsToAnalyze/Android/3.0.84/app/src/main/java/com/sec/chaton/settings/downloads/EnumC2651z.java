package com.sec.chaton.settings.downloads;

/* compiled from: AniconHelper.java */
/* renamed from: com.sec.chaton.settings.downloads.z */
/* loaded from: classes.dex */
public enum EnumC2651z {
    NORMAL(0),
    HAPTIC(1),
    SOUND(2),
    MOTION(4),
    HAPTIC_SOUND(3),
    HAPTIC_MOTION(5),
    SOUND_MOTION(6),
    ALL_HSM(7);


    /* renamed from: i */
    private int f9911i;

    EnumC2651z(int i) {
        this.f9911i = i;
    }

    /* renamed from: a */
    public int m9676a() {
        return this.f9911i;
    }

    /* renamed from: a */
    public static EnumC2651z m9675a(int i) {
        switch (i) {
        }
        return NORMAL;
    }
}
