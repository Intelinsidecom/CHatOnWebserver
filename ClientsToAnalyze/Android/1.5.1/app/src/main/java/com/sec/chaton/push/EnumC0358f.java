package com.sec.chaton.push;

import com.sec.chaton.push.util.PushLog;

/* renamed from: com.sec.chaton.push.f */
/* loaded from: classes.dex */
enum EnumC0358f {
    Unknown,
    NoActive,
    WIFI,
    Mobile;

    /* renamed from: a */
    public static EnumC0358f m2864a(int i) {
        switch (i) {
            case -1:
                return NoActive;
            case 0:
                return Mobile;
            case 1:
                return WIFI;
            default:
                PushLog.m3031d(SystemStateMoniter.f2594a, "Unknown connect type: " + i);
                return Unknown;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return super.toString();
    }
}
