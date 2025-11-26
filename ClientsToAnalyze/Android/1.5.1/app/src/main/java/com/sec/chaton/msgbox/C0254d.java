package com.sec.chaton.msgbox;

import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.msgbox.d */
/* loaded from: classes.dex */
/* synthetic */ class C0254d {

    /* renamed from: a */
    static final /* synthetic */ int[] f1991a = new int[ChatONContract.MessageTable.MsgContentType.values().length];

    static {
        try {
            f1991a[ChatONContract.MessageTable.MsgContentType.TEXT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1991a[ChatONContract.MessageTable.MsgContentType.IMAGE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1991a[ChatONContract.MessageTable.MsgContentType.AUDIO.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f1991a[ChatONContract.MessageTable.MsgContentType.CALENDAR.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f1991a[ChatONContract.MessageTable.MsgContentType.CONTACT.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f1991a[ChatONContract.MessageTable.MsgContentType.GEO.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f1991a[ChatONContract.MessageTable.MsgContentType.VIDEO.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
    }
}
