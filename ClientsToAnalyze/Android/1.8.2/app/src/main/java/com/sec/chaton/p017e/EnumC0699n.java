package com.sec.chaton.p017e;

import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.n */
/* loaded from: classes.dex */
public enum EnumC0699n {
    SYSTEM(-1),
    TEXT(0),
    IMAGE(1),
    VIDEO(2),
    GEO(3),
    AUDIO(4),
    CONTACT(5),
    CALENDAR(6),
    ANICON(7),
    DOCUMENT(8),
    UNDEFINED(99);


    /* renamed from: l */
    private int f2639l;

    EnumC0699n(int i) {
        this.f2639l = i;
    }

    /* renamed from: a */
    public int m3162a() {
        return this.f2639l;
    }

    /* renamed from: a */
    public static EnumC0699n m3160a(int i) {
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
            case 7:
                return ANICON;
            case 8:
                return DOCUMENT;
            case 99:
                return UNDEFINED;
            default:
                return UNDEFINED;
        }
    }

    /* renamed from: a */
    public static String m3161a(EnumC0699n enumC0699n) {
        switch (enumC0699n) {
            case IMAGE:
                return GlobalApplication.m3260b().getString(R.string.send_image_to_you);
            case VIDEO:
                return GlobalApplication.m3260b().getString(R.string.send_video_to_you);
            case GEO:
                return GlobalApplication.m3260b().getString(R.string.send_location_to_you);
            case AUDIO:
                return GlobalApplication.m3260b().getString(R.string.send_voice_to_you);
            case CONTACT:
                return GlobalApplication.m3260b().getString(R.string.send_contact_to_you);
            case CALENDAR:
                return GlobalApplication.m3260b().getString(R.string.send_calendar_to_you);
            case ANICON:
                return GlobalApplication.m3260b().getString(R.string.send_anicon_to_you);
            case DOCUMENT:
                return GlobalApplication.m3260b().getString(R.string.send_file_to_you);
            case UNDEFINED:
                return GlobalApplication.m3260b().getString(R.string.toast_supported_format);
            default:
                return null;
        }
    }
}
