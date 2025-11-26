package com.sec.chaton.p027e;

import com.sec.common.util.C3364o;

/* compiled from: ChatONContract2.java */
/* renamed from: com.sec.chaton.e.aq */
/* loaded from: classes.dex */
public enum EnumC1399aq {
    AmsBackground("amsbackground"),
    AmsStamp("amsstamp"),
    AmsTemplate("amstemplate"),
    Anicon("anicon_package"),
    Skin("skin"),
    Font("font"),
    Sound("sound");


    /* renamed from: h */
    private String f5213h;

    EnumC1399aq(String str) {
        this.f5213h = str;
    }

    /* renamed from: a */
    public String m6252a() {
        return this.f5213h;
    }

    /* renamed from: a */
    public static EnumC1399aq m6251a(String str) {
        if (AmsBackground.m6252a().equals(str)) {
            return AmsBackground;
        }
        if (AmsStamp.m6252a().equals(str)) {
            return AmsStamp;
        }
        if (AmsTemplate.m6252a().equals(str)) {
            return AmsTemplate;
        }
        if (Anicon.m6252a().equals(str)) {
            return Anicon;
        }
        if (Font.m6252a().equals(str)) {
            return Font;
        }
        if (Skin.m6252a().equals(str)) {
            return Skin;
        }
        if (Sound.m6252a().equals(str)) {
            return Sound;
        }
        throw new IllegalArgumentException(C3364o.m11849a("Unknown item type. ", str));
    }
}
