package com.sec.chaton.p025d;

import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.d.d */
/* loaded from: classes.dex */
public enum EnumC0651d {
    SYSTEM(-1),
    TEXT(0),
    IMAGE(1),
    VIDEO(2),
    GEO(3),
    AUDIO(4),
    CONTACT(5),
    CALENDAR(6),
    UNDEFINED(99);


    /* renamed from: j */
    private int f2274j;

    EnumC0651d(int i) {
        this.f2274j = i;
    }

    /* renamed from: a */
    public int m2978a() {
        return this.f2274j;
    }

    /* renamed from: a */
    public static EnumC0651d m2976a(int i) {
        switch (i) {
            case -1:
                return SYSTEM;
            case 0:
                return TEXT;
            case 1:
                return IMAGE;
            case 2:
                return VIDEO;
            case 3:
                return GEO;
            case 4:
                return AUDIO;
            case 5:
                return CONTACT;
            case 6:
                return CALENDAR;
            case 99:
                return UNDEFINED;
            default:
                return UNDEFINED;
        }
    }

    /* renamed from: a */
    public static String m2977a(EnumC0651d enumC0651d) {
        switch (enumC0651d) {
            case IMAGE:
                return GlobalApplication.m3100a().getString(R.string.send_image_to_you);
            case VIDEO:
                return GlobalApplication.m3100a().getString(R.string.send_video_to_you);
            case GEO:
                return GlobalApplication.m3100a().getString(R.string.send_location_to_you);
            case AUDIO:
                return GlobalApplication.m3100a().getString(R.string.send_voice_to_you);
            case CONTACT:
                return GlobalApplication.m3100a().getString(R.string.send_contact_to_you);
            case CALENDAR:
                return GlobalApplication.m3100a().getString(R.string.send_calendar_to_you);
            case UNDEFINED:
                return GlobalApplication.m3100a().getString(R.string.toast_supported_format);
            default:
                return null;
        }
    }
}
