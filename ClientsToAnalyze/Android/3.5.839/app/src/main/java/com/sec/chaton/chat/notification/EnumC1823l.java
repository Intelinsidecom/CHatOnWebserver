package com.sec.chaton.chat.notification;

/* compiled from: FeedNotificationService.java */
/* renamed from: com.sec.chaton.chat.notification.l */
/* loaded from: classes.dex */
public enum EnumC1823l {
    POSTON("poston"),
    TRUNK("trunk"),
    BUDDY("buddy"),
    PROFILE("profile");


    /* renamed from: e */
    String f6908e;

    EnumC1823l(String str) {
        this.f6908e = str;
    }

    /* renamed from: a */
    public static EnumC1823l m8954a(String str) {
        if ("poston".equals(str)) {
            return POSTON;
        }
        if ("trunk".equals(str)) {
            return TRUNK;
        }
        if ("buddy".equals(str)) {
            return BUDDY;
        }
        return PROFILE;
    }
}
