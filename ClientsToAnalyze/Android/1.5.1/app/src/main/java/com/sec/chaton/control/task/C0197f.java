package com.sec.chaton.control.task;

import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.control.task.f */
/* loaded from: classes.dex */
/* synthetic */ class C0197f {

    /* renamed from: a */
    static final /* synthetic */ int[] f1690a = new int[ChatONContract.MessageTable.MsgContentType.values().length];

    static {
        try {
            f1690a[ChatONContract.MessageTable.MsgContentType.IMAGE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1690a[ChatONContract.MessageTable.MsgContentType.AUDIO.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1690a[ChatONContract.MessageTable.MsgContentType.CALENDAR.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f1690a[ChatONContract.MessageTable.MsgContentType.CONTACT.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f1690a[ChatONContract.MessageTable.MsgContentType.GEO.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f1690a[ChatONContract.MessageTable.MsgContentType.VIDEO.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
    }
}
