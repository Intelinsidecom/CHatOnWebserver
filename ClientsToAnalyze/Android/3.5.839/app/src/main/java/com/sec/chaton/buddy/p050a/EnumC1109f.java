package com.sec.chaton.buddy.p050a;

import com.sec.chaton.privateplugin.data.Spam;

/* compiled from: SpecialBuddyItem.java */
/* renamed from: com.sec.chaton.buddy.a.f */
/* loaded from: classes.dex */
public enum EnumC1109f {
    NONE(Spam.ACTIVITY_CANCEL),
    CHAT(Spam.ACTIVITY_REPORT),
    CONTENTS(Spam.ACTIVITY_CHECK),
    CHATCONTENTS("3"),
    LIVEGROUP("6"),
    LIVEGROUPCHAT("7"),
    INVITED("101"),
    INVITING("102");


    /* renamed from: i */
    String f4275i;

    EnumC1109f(String str) {
        this.f4275i = str;
    }

    /* renamed from: a */
    public String m7095a() {
        return this.f4275i;
    }

    /* renamed from: a */
    public static EnumC1109f m7094a(String str) {
        for (EnumC1109f enumC1109f : values()) {
            if (enumC1109f.m7095a().equals(str)) {
                return enumC1109f;
            }
        }
        return NONE;
    }

    /* renamed from: b */
    public boolean m7096b() {
        switch (this) {
            case CHATCONTENTS:
            case CONTENTS:
            case LIVEGROUP:
            case LIVEGROUPCHAT:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: c */
    public boolean m7097c() {
        switch (this) {
            case CHATCONTENTS:
            case LIVEGROUPCHAT:
            case CHAT:
                return true;
            case CONTENTS:
            case LIVEGROUP:
            default:
                return false;
        }
    }
}
