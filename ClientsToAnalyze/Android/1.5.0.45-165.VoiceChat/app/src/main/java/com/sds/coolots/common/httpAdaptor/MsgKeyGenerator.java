package com.sds.coolots.common.httpAdaptor;

import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import java.io.File;

/* loaded from: classes.dex */
public final class MsgKeyGenerator {

    /* renamed from: a */
    private static final String f3025a = "[MsgKeyGenerator]";

    /* renamed from: b */
    private static final String f3026b = "pref_msg_key";

    /* renamed from: c */
    private static MsgKeyGenerator f3027c;

    /* renamed from: e */
    private static int f3028e = 0;

    /* renamed from: f */
    private static final int f3029f = 0;

    /* renamed from: d */
    private final Object f3030d = new Object();

    private MsgKeyGenerator() {
    }

    /* renamed from: a */
    private void m2923a(int i) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext).edit();
        editorEdit.putInt(f3026b, i);
        if (Build.VERSION.SDK_INT < 9) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }

    public static MsgKeyGenerator getInstance() {
        if (f3027c == null) {
            synchronized (MsgKeyGenerator.class) {
                f3027c = new MsgKeyGenerator();
                try {
                    File file = new File("/data/data/" + MainApplication.mContext.getPackageManager().getPackageInfo(MainApplication.mContext.getPackageName(), 0).packageName + "/textpref.pref");
                    if (file.exists()) {
                        if (file.delete()) {
                            logI("Legacy TextPref File is successfully deleted!!");
                        } else {
                            logI("Legacy TextPref File delete Failed!!");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                f3028e = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext).getInt(f3026b, 0);
            }
        }
        return f3027c;
    }

    public static void logI(String str) {
        Log.m2958e(f3025a + str);
    }

    public int getKey() {
        int i;
        synchronized (this.f3030d) {
            i = f3028e + 1;
            f3028e = i;
            m2923a(i);
        }
        return i;
    }

    public void resetKey() {
        logI("ResetMsgKey called!! Current MsgKey : " + f3028e);
        synchronized (this.f3030d) {
            f3028e = 0;
            m2923a(0);
        }
    }
}
