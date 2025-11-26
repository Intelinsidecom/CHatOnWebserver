package com.sec.chaton.control;

import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.control.r */
/* loaded from: classes.dex */
/* synthetic */ class C0189r {

    /* renamed from: a */
    static final /* synthetic */ int[] f1449a = new int[ChatONContract.InBoxTable.ChatType.values().length];

    static {
        try {
            f1449a[ChatONContract.InBoxTable.ChatType.ONETOONE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1449a[ChatONContract.InBoxTable.ChatType.GROUPCHAT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1449a[ChatONContract.InBoxTable.ChatType.BROADCAST.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
