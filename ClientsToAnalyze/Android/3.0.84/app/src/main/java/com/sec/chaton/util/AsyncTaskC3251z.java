package com.sec.chaton.util;

import android.content.Context;
import android.os.AsyncTask;
import com.sec.chaton.p037j.C1540a;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.common.CommonApplication;
import java.io.File;
import java.io.FileInputStream;

/* compiled from: ChatONLogWriter.java */
/* renamed from: com.sec.chaton.util.z */
/* loaded from: classes.dex */
public class AsyncTaskC3251z extends AsyncTask<Void, Void, Void> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        C3160ab c3160abM10962a;
        String str;
        int i;
        Context contextM11493l = CommonApplication.m11493l();
        String strM10979a = C3159aa.m10962a().m10979a("CrashLog", "");
        String strM10954a = "";
        try {
            strM10954a = C3158a.m10954a(new C3158a(C3158a.m10955a(), C3158a.m10957b()).m10960b(("imei=" + C3171am.m11045a() + "&filename=" + strM10979a).getBytes()));
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
        C1582j c1582jM6714a = new C1582j(EnumC3219cg.FILE, "/file").m6710a(EnumC1583k.POST).m6713a("text/log").m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("param", strM10954a);
        try {
            try {
                File file = new File(contextM11493l.getFilesDir(), strM10979a);
                if (file.exists()) {
                    FileInputStream fileInputStreamOpenFileInput = contextM11493l.openFileInput(strM10979a);
                    byte[] bArr = new byte[(int) file.length()];
                    int i2 = 0;
                    while (i2 < bArr.length && (i = fileInputStreamOpenFileInput.read(bArr, i2, bArr.length - i2)) >= 0) {
                        i2 += i;
                    }
                    fileInputStreamOpenFileInput.close();
                    C1540a.m6537a(c1582jM6714a.m6708a(), bArr);
                    file.delete();
                }
                c3160abM10962a = C3159aa.m10962a();
                str = "CrashLog";
            } catch (Exception e2) {
                C3250y.m11443a(e2, getClass().getSimpleName());
                c3160abM10962a = C3159aa.m10962a();
                str = "CrashLog";
            }
            c3160abM10962a.m10981a(str);
            return null;
        } catch (Throwable th) {
            C3159aa.m10962a().m10981a("CrashLog");
            throw th;
        }
    }
}
