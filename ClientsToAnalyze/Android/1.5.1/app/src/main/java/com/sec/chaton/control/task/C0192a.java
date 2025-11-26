package com.sec.chaton.control.task;

import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.control.task.a */
/* loaded from: classes.dex */
/* synthetic */ class C0192a {

    /* renamed from: a */
    static final /* synthetic */ int[] f1683a = new int[ChatONContract.InBoxTable.ChatType.values().length];

    static {
        try {
            f1683a[ChatONContract.InBoxTable.ChatType.ONETOONE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1683a[ChatONContract.InBoxTable.ChatType.BROADCAST.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1683a[ChatONContract.InBoxTable.ChatType.GROUPCHAT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
