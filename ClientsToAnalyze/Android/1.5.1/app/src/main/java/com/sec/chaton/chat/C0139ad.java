package com.sec.chaton.chat;

import com.sec.chaton.common.entry.MessageResultEntry;
import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.chat.ad */
/* loaded from: classes.dex */
/* synthetic */ class C0139ad {

    /* renamed from: a */
    static final /* synthetic */ int[] f937a;

    /* renamed from: b */
    static final /* synthetic */ int[] f938b = new int[MessageResultEntry.errorCode.values().length];

    static {
        try {
            f938b[MessageResultEntry.errorCode.CHANGE_SERVER.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f938b[MessageResultEntry.errorCode.BLOCK_RECEIVER.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f938b[MessageResultEntry.errorCode.INVALID_USER.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f938b[MessageResultEntry.errorCode.RETRY.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        f937a = new int[ChatONContract.MessageTable.MsgContentType.values().length];
        try {
            f937a[ChatONContract.MessageTable.MsgContentType.IMAGE.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f937a[ChatONContract.MessageTable.MsgContentType.AUDIO.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f937a[ChatONContract.MessageTable.MsgContentType.CALENDAR.ordinal()] = 3;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f937a[ChatONContract.MessageTable.MsgContentType.CONTACT.ordinal()] = 4;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f937a[ChatONContract.MessageTable.MsgContentType.GEO.ordinal()] = 5;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f937a[ChatONContract.MessageTable.MsgContentType.VIDEO.ordinal()] = 6;
        } catch (NoSuchFieldError e10) {
        }
    }
}
