package com.sec.chaton.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p022h.C0764a;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.EnumC0801k;
import java.io.File;
import java.io.FileInputStream;

/* compiled from: ChatONLogWriter.java */
/* renamed from: com.sec.chaton.util.s */
/* loaded from: classes.dex */
public class AsyncTaskC1787s extends AsyncTask {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        SharedPreferences.Editor editorRemove;
        int i;
        Context contextM3260b = GlobalApplication.m3260b();
        String string = C1789u.m6075a().getString("CrashLog", "");
        String strM6009a = "";
        try {
            strM6009a = C1771c.m6009a(new C1771c(C1771c.m6010a(), C1771c.m6012b()).m6015b(("imei=" + C1721ad.m5873a() + "&filename=" + string).getBytes()));
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getSimpleName());
        }
        C0800j c0800jM3409a = new C0800j(EnumC1765bu.FILE, "/file").m3406a(EnumC0801k.POST).m3408a("text/log").m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("param", strM6009a);
        try {
            try {
                File file = new File(contextM3260b.getFilesDir(), string);
                if (file.exists()) {
                    FileInputStream fileInputStreamOpenFileInput = contextM3260b.openFileInput(string);
                    byte[] bArr = new byte[(int) file.length()];
                    int i2 = 0;
                    while (i2 < bArr.length && (i = fileInputStreamOpenFileInput.read(bArr, i2, bArr.length - i2)) >= 0) {
                        i2 += i;
                    }
                    fileInputStreamOpenFileInput.close();
                    C0764a.m3269a(c0800jM3409a.m3404a(), bArr);
                    file.delete();
                }
                editorRemove = C1789u.m6075a().edit().remove("CrashLog");
            } catch (Exception e2) {
                C1786r.m6056a(e2, getClass().getSimpleName());
                editorRemove = C1789u.m6075a().edit().remove("CrashLog");
            }
            editorRemove.commit();
            return null;
        } catch (Throwable th) {
            C1789u.m6075a().edit().remove("CrashLog").commit();
            throw th;
        }
    }
}
