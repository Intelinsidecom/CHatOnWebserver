package com.sec.chaton.widget;

import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.widget.c */
/* loaded from: classes.dex */
/* synthetic */ class C0622c {

    /* renamed from: a */
    static final /* synthetic */ int[] f3805a = new int[ChatONContract.InBoxTable.ChatType.values().length];

    static {
        try {
            f3805a[ChatONContract.InBoxTable.ChatType.ONETOONE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f3805a[ChatONContract.InBoxTable.ChatType.GROUPCHAT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f3805a[ChatONContract.InBoxTable.ChatType.BROADCAST.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
