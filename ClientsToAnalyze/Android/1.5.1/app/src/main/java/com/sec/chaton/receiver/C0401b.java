package com.sec.chaton.receiver;

import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.receiver.b */
/* loaded from: classes.dex */
/* synthetic */ class C0401b {

    /* renamed from: a */
    static final /* synthetic */ int[] f2805a = new int[ChatONContract.InBoxTable.ChatType.values().length];

    static {
        try {
            f2805a[ChatONContract.InBoxTable.ChatType.ONETOONE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f2805a[ChatONContract.InBoxTable.ChatType.BROADCAST.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f2805a[ChatONContract.InBoxTable.ChatType.GROUPCHAT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f2805a[ChatONContract.InBoxTable.ChatType.WEB_AUTH.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
