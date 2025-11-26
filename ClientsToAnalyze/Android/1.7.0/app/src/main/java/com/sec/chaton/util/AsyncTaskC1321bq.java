package com.sec.chaton.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0478ac;
import com.sec.chaton.p018c.C0519z;
import com.sec.chaton.p018c.EnumC0511r;
import java.io.File;
import java.io.FileInputStream;

/* compiled from: ChatONLogWriter.java */
/* renamed from: com.sec.chaton.util.bq */
/* loaded from: classes.dex */
public class AsyncTaskC1321bq extends AsyncTask {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        SharedPreferences.Editor editorRemove;
        int i;
        Context contextM3100a = GlobalApplication.m3100a();
        String string = C1323bs.m4575a().getString("CrashLog", "");
        String strM4567a = "";
        try {
            strM4567a = C1322br.m4567a(new C1322br(C1322br.m4568a(), C1322br.m4570b()).m4573b(("imei=" + C1336k.m4621a() + "&filename=" + string).getBytes()));
        } catch (Exception e) {
            C1341p.m4653a(e, getClass().getSimpleName());
        }
        C0519z c0519zM2584a = new C0519z(EnumC1333h.FILE, "/file").m2581a(EnumC0511r.POST).m2583a("text/log").m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("param", strM4567a);
        try {
            try {
                File file = new File(contextM3100a.getFilesDir(), string);
                if (file.exists()) {
                    FileInputStream fileInputStreamOpenFileInput = contextM3100a.openFileInput(string);
                    byte[] bArr = new byte[(int) file.length()];
                    int i2 = 0;
                    while (i2 < bArr.length && (i = fileInputStreamOpenFileInput.read(bArr, i2, bArr.length - i2)) >= 0) {
                        i2 += i;
                    }
                    fileInputStreamOpenFileInput.close();
                    C0478ac.m2467a(c0519zM2584a.m2579a(), bArr);
                    file.delete();
                }
                editorRemove = C1323bs.m4575a().edit().remove("CrashLog");
            } catch (Exception e2) {
                C1341p.m4653a(e2, getClass().getSimpleName());
                editorRemove = C1323bs.m4575a().edit().remove("CrashLog");
            }
            editorRemove.commit();
            return null;
        } catch (Throwable th) {
            C1323bs.m4575a().edit().remove("CrashLog").commit();
            throw th;
        }
    }
}
