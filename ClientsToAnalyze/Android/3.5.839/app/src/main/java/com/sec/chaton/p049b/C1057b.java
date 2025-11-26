package com.sec.chaton.p049b;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;
import com.sec.chaton.global.GlobalApplication;
import java.io.IOException;

/* compiled from: Utils.java */
/* renamed from: com.sec.chaton.b.b */
/* loaded from: classes.dex */
public class C1057b {
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static long m6155a() {
        try {
            UserManager userManager = (UserManager) GlobalApplication.m18732r().getSystemService("user");
            if (userManager != null) {
                long serialNumberForUser = userManager.getSerialNumberForUser(Process.myUserHandle());
                if (serialNumberForUser >= 0) {
                    return serialNumberForUser;
                }
            }
            return -1L;
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    /* renamed from: a */
    public static IOException m6156a(String str) {
        return new IOException(str);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static IOException m6157a(Throwable th) {
        return Build.VERSION.SDK_INT < 9 ? m6156a(th.getMessage()) : new IOException(th);
    }
}
