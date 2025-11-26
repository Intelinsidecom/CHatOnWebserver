package com.sec.chaton.database.helper;

import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.database.helper.a */
/* loaded from: classes.dex */
/* synthetic */ class C0214a {

    /* renamed from: a */
    static final /* synthetic */ int[] f1779a;

    /* renamed from: b */
    static final /* synthetic */ int[] f1780b = new int[ChatONContract.InBoxTable.ChatType.values().length];

    static {
        try {
            f1780b[ChatONContract.InBoxTable.ChatType.ONETOONE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1780b[ChatONContract.InBoxTable.ChatType.BROADCAST.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1780b[ChatONContract.InBoxTable.ChatType.GROUPCHAT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        f1779a = new int[ChatONContract.MessageTable.MsgContentType.values().length];
        try {
            f1779a[ChatONContract.MessageTable.MsgContentType.IMAGE.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f1779a[ChatONContract.MessageTable.MsgContentType.VIDEO.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f1779a[ChatONContract.MessageTable.MsgContentType.AUDIO.ordinal()] = 3;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f1779a[ChatONContract.MessageTable.MsgContentType.GEO.ordinal()] = 4;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f1779a[ChatONContract.MessageTable.MsgContentType.CONTACT.ordinal()] = 5;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f1779a[ChatONContract.MessageTable.MsgContentType.CALENDAR.ordinal()] = 6;
        } catch (NoSuchFieldError e9) {
        }
    }
}
