package com.sec.chaton.updates;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;

/* compiled from: UpdatesAdapter.java */
/* renamed from: com.sec.chaton.updates.e */
/* loaded from: classes.dex */
public enum EnumC4698e {
    NONE("none"),
    IMAGE(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE),
    VIDEO("video"),
    LOCATION("location"),
    IMGLOC("image,location"),
    VDOLOC("viedo,location");


    /* renamed from: g */
    String f17028g;

    EnumC4698e(String str) {
        this.f17028g = str;
    }

    /* renamed from: a */
    public String m17757a() {
        return this.f17028g;
    }

    /* renamed from: a */
    public static EnumC4698e m17756a(String str) {
        for (EnumC4698e enumC4698e : values()) {
            if (enumC4698e.m17757a().equals(str)) {
                return enumC4698e;
            }
        }
        return NONE;
    }
}
