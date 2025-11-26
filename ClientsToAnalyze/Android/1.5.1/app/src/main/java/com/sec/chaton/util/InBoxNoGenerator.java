package com.sec.chaton.util;

import com.sec.chaton.database.ChatONContract;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class InBoxNoGenerator {
    /* renamed from: a */
    public static String m3594a(ChatONContract.InBoxTable.ChatType chatType, String str) {
        return str + chatType.m2189a() + "-" + MessageIDGenerator.m3598a();
    }

    /* renamed from: a */
    public static String m3595a(ChatONContract.InBoxTable.ChatType chatType, List list) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            str = str + ((String) list.get(i));
        }
        return chatType != ChatONContract.InBoxTable.ChatType.ONETOONE ? UUID.randomUUID().toString() : str;
    }

    /* renamed from: a */
    public static String m3596a(ChatONContract.InBoxTable.ChatType chatType, String[] strArr) {
        String str = "";
        for (String str2 : strArr) {
            str = str + str2;
        }
        return chatType != ChatONContract.InBoxTable.ChatType.ONETOONE ? UUID.randomUUID().toString() : str;
    }
}
