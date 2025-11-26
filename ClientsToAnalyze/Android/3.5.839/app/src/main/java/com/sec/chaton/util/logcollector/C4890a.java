package com.sec.chaton.util.logcollector;

import android.content.SharedPreferences;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: LogCollectorPreference.java */
/* renamed from: com.sec.chaton.util.logcollector.a */
/* loaded from: classes.dex */
public class C4890a {

    /* renamed from: a */
    private static SharedPreferences f17832a = GlobalApplication.m18732r().getSharedPreferences("com.sec.common.logcollector", 0);

    /* renamed from: a */
    public static String m18557a(String str) {
        return f17832a.getString("chaton_account", str);
    }

    /* renamed from: b */
    public static void m18559b(String str) {
        SharedPreferences.Editor editorEdit = f17832a.edit();
        editorEdit.putString("chaton_account", str);
        editorEdit.commit();
    }

    /* renamed from: a */
    public static long m18556a(long j) {
        return f17832a.getLong("last_upload_time", j);
    }

    /* renamed from: b */
    public static void m18558b(long j) {
        SharedPreferences.Editor editorEdit = f17832a.edit();
        editorEdit.putLong("last_upload_time", j);
        editorEdit.commit();
    }
}
