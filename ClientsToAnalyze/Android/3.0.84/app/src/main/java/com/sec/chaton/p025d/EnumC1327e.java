package com.sec.chaton.p025d;

import com.sec.chaton.p027e.EnumC1399aq;

/* compiled from: AmsItemMessageControl.java */
/* renamed from: com.sec.chaton.d.e */
/* loaded from: classes.dex */
public enum EnumC1327e {
    Background("1"),
    Stamp("2"),
    Template("3");


    /* renamed from: d */
    private String f5009d;

    EnumC1327e(String str) {
        this.f5009d = str;
    }

    /* renamed from: a */
    public String m5702a() {
        return this.f5009d;
    }

    /* renamed from: a */
    public static EnumC1327e m5701a(String str) {
        if (Background.m5702a().equals(str)) {
            return Background;
        }
        if (Stamp.m5702a().equals(str)) {
            return Stamp;
        }
        if (Template.m5702a().equals(str)) {
            return Template;
        }
        return null;
    }

    /* renamed from: b */
    public EnumC1399aq m5703b() {
        if (Background.m5702a().equals(this.f5009d)) {
            return EnumC1399aq.AmsBackground;
        }
        if (Stamp.m5702a().equals(this.f5009d)) {
            return EnumC1399aq.AmsStamp;
        }
        if (Template.m5702a().equals(this.f5009d)) {
            return EnumC1399aq.AmsTemplate;
        }
        return null;
    }
}
