package com.sec.chaton.control.task;

import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.control.task.n */
/* loaded from: classes.dex */
/* synthetic */ class C0205n {

    /* renamed from: a */
    static final /* synthetic */ int[] f1698a = new int[ChatONContract.MessageTable.MsgContentType.values().length];

    static {
        try {
            f1698a[ChatONContract.MessageTable.MsgContentType.IMAGE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1698a[ChatONContract.MessageTable.MsgContentType.VIDEO.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1698a[ChatONContract.MessageTable.MsgContentType.AUDIO.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f1698a[ChatONContract.MessageTable.MsgContentType.CALENDAR.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f1698a[ChatONContract.MessageTable.MsgContentType.CONTACT.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f1698a[ChatONContract.MessageTable.MsgContentType.GEO.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
    }
}
