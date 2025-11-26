package com.sec.chaton.chat;

import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.chat.k */
/* loaded from: classes.dex */
/* synthetic */ class C0149k {

    /* renamed from: a */
    static final /* synthetic */ int[] f960a = new int[ChatONContract.MessageTable.MsgContentType.values().length];

    static {
        try {
            f960a[ChatONContract.MessageTable.MsgContentType.TEXT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f960a[ChatONContract.MessageTable.MsgContentType.IMAGE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f960a[ChatONContract.MessageTable.MsgContentType.VIDEO.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f960a[ChatONContract.MessageTable.MsgContentType.AUDIO.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f960a[ChatONContract.MessageTable.MsgContentType.CALENDAR.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f960a[ChatONContract.MessageTable.MsgContentType.CONTACT.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f960a[ChatONContract.MessageTable.MsgContentType.GEO.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
    }
}
