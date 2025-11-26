package com.sec.chaton.p055d;

import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.privateplugin.data.Spam;

/* compiled from: AmsItemMessageControl.java */
/* renamed from: com.sec.chaton.d.f */
/* loaded from: classes.dex */
public enum EnumC2125f {
    Background(Spam.ACTIVITY_REPORT),
    Stamp(Spam.ACTIVITY_CHECK),
    Template("3"),
    Unknown("4");


    /* renamed from: e */
    private String f7706e;

    EnumC2125f(String str) {
        this.f7706e = str;
    }

    /* renamed from: a */
    public String m9474a() {
        return this.f7706e;
    }

    /* renamed from: b */
    public EnumC2258bd m9475b() {
        if (Background.m9474a().equals(this.f7706e)) {
            return EnumC2258bd.AmsBackground;
        }
        if (Stamp.m9474a().equals(this.f7706e)) {
            return EnumC2258bd.AmsStamp;
        }
        if (Template.m9474a().equals(this.f7706e)) {
            return EnumC2258bd.AmsTemplate;
        }
        return EnumC2258bd.Unknown;
    }

    /* renamed from: a */
    public static EnumC2125f m9473a(EnumC2258bd enumC2258bd) {
        switch (enumC2258bd) {
            case AmsBackground:
                return Background;
            case AmsStamp:
                return Stamp;
            case AmsTemplate:
                return Template;
            default:
                return Unknown;
        }
    }
}
