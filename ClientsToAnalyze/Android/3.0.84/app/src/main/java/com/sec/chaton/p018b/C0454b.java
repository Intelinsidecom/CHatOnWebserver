package com.sec.chaton.p018b;

import android.os.Process;
import android.os.UserManager;
import com.sec.chaton.global.GlobalApplication;
import twitter4j.conf.PropertyConfiguration;

/* compiled from: Utils.java */
/* renamed from: com.sec.chaton.b.b */
/* loaded from: classes.dex */
public class C0454b {
    /* renamed from: a */
    public static long m3079a() {
        try {
            UserManager userManager = (UserManager) GlobalApplication.m11493l().getSystemService(PropertyConfiguration.USER);
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
}
