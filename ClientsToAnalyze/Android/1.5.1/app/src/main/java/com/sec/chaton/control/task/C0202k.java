package com.sec.chaton.control.task;

import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.control.task.k */
/* loaded from: classes.dex */
/* synthetic */ class C0202k {

    /* renamed from: a */
    static final /* synthetic */ int[] f1695a = new int[ChatONContract.InBoxTable.ChatType.values().length];

    static {
        try {
            f1695a[ChatONContract.InBoxTable.ChatType.ONETOONE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1695a[ChatONContract.InBoxTable.ChatType.GROUPCHAT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1695a[ChatONContract.InBoxTable.ChatType.BROADCAST.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
