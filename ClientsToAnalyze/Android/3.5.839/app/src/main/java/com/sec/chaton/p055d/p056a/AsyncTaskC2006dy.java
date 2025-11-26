package com.sec.chaton.p055d.p056a;

import android.os.AsyncTask;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4873ck;
import java.util.Calendar;

/* compiled from: ProfileUploadTaskFromSNS.java */
/* renamed from: com.sec.chaton.d.a.dy */
/* loaded from: classes.dex */
public class AsyncTaskC2006dy extends AsyncTask<String, Integer, Boolean> {

    /* renamed from: e */
    private static String f7371e = "";

    /* renamed from: a */
    private int f7372a = 30000;

    /* renamed from: b */
    String f7373b = C4873ck.m18501b();

    /* renamed from: c */
    private String f7374c;

    /* renamed from: d */
    private String f7375d;

    public AsyncTaskC2006dy(String str) {
        this.f7374c = str;
        String strValueOf = String.valueOf(Calendar.getInstance().getTimeInMillis());
        C4809aa.m18108a("profile_image_timestamp", strValueOf);
        f7371e = C4809aa.m18104a().m18121a("chaton_id", "");
        this.f7375d = strValueOf + "_profileImage.jpg";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d9 A[Catch: IOException -> 0x01b6, TryCatch #0 {IOException -> 0x01b6, blocks: (B:19:0x00c9, B:21:0x00d9, B:23:0x0159, B:33:0x0197, B:32:0x0191), top: B:41:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0190  */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Boolean doInBackground(java.lang.String... r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p055d.p056a.AsyncTaskC2006dy.doInBackground(java.lang.String[]):java.lang.Boolean");
    }
}
