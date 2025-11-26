package com.sec.chaton.push.util;

/* compiled from: NetworkUtil.java */
/* renamed from: com.sec.chaton.push.util.d */
/* loaded from: classes.dex */
public enum EnumC0918d {
    NoActive,
    WIFI,
    Mobile,
    ETC;

    @Override // java.lang.Enum
    public String toString() {
        return super.toString();
    }

    /* renamed from: a */
    public static EnumC0918d m3619a(int i) {
        switch (i) {
            case -1:
                return NoActive;
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
                return Mobile;
            case 1:
            case 6:
                return WIFI;
            default:
                return ETC;
        }
    }
}
