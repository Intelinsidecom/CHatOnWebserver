package com.sec.chaton.p057e;

import com.sec.common.util.C5052r;

/* compiled from: ChatONContract2.java */
/* renamed from: com.sec.chaton.e.bd */
/* loaded from: classes.dex */
public enum EnumC2258bd {
    AmsBackground("amsbackground"),
    AmsStamp("amsstamp"),
    AmsTemplate("amstemplate"),
    AmsUserTemplate("amsuserfiles"),
    Anicon("anicon_package"),
    Skin("skin"),
    Font("font"),
    Sound("sound"),
    SkinTheme("skin_theme"),
    Unknown("unknown");


    /* renamed from: k */
    private String f8051k;

    EnumC2258bd(String str) {
        this.f8051k = str;
    }

    /* renamed from: a */
    public String m10123a() {
        return this.f8051k;
    }

    /* renamed from: a */
    public static EnumC2258bd m10122a(String str) {
        if (AmsBackground.m10123a().equals(str)) {
            return AmsBackground;
        }
        if (AmsStamp.m10123a().equals(str)) {
            return AmsStamp;
        }
        if (AmsTemplate.m10123a().equals(str)) {
            return AmsTemplate;
        }
        if (AmsUserTemplate.m10123a().equals(str)) {
            return AmsUserTemplate;
        }
        if (Anicon.m10123a().equals(str)) {
            return Anicon;
        }
        if (Font.m10123a().equals(str)) {
            return Font;
        }
        if (Skin.m10123a().equals(str)) {
            return Skin;
        }
        if (Sound.m10123a().equals(str)) {
            return Sound;
        }
        if (SkinTheme.m10123a().equals(str)) {
            return SkinTheme;
        }
        if (Unknown.m10123a().equals(str)) {
            return Unknown;
        }
        throw new IllegalArgumentException(C5052r.m19199a("Unknown item type. ", str));
    }
}
