package com.sec.chaton.chat.notification;

import android.text.TextUtils;

/* compiled from: FeedNotificationService.java */
/* renamed from: com.sec.chaton.chat.notification.k */
/* loaded from: classes.dex */
public enum EnumC1822k {
    UNDEFINED("undefined"),
    POST("post"),
    REACTION("reaction"),
    RECOMMEND("recommend"),
    UPDATE("update"),
    INVITE("invite"),
    JOIN("join");


    /* renamed from: h */
    String f6902h;

    EnumC1822k(String str) {
        this.f6902h = str;
    }

    /* renamed from: a */
    public static EnumC1822k m8953a(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNDEFINED;
        }
        if (str.equals("post")) {
            return POST;
        }
        if (str.equals("reaction")) {
            return REACTION;
        }
        if (str.equals("recommend")) {
            return RECOMMEND;
        }
        if (str.equals("update")) {
            return UPDATE;
        }
        if (str.equals("invite")) {
            return INVITE;
        }
        if (str.equals("join")) {
            return JOIN;
        }
        return UNDEFINED;
    }
}
