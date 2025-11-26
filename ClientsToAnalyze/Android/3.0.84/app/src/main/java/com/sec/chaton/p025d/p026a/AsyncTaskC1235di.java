package com.sec.chaton.p025d.p026a;

import android.os.AsyncTask;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3223ck;
import java.util.Calendar;

/* compiled from: ProfileUploadTaskFromSNS.java */
/* renamed from: com.sec.chaton.d.a.di */
/* loaded from: classes.dex */
public class AsyncTaskC1235di extends AsyncTask<String, Integer, Boolean> {

    /* renamed from: d */
    private static String f4781d = "";

    /* renamed from: a */
    private String f4782a;

    /* renamed from: b */
    String f4783b = C3223ck.m11328b();

    /* renamed from: c */
    private String f4784c;

    public AsyncTaskC1235di(String str) {
        this.f4782a = str;
        String strValueOf = String.valueOf(Calendar.getInstance().getTimeInMillis());
        C3159aa.m10966a("profile_image_timestamp", strValueOf);
        f4781d = C3159aa.m10962a().m10979a("chaton_id", "");
        this.f4784c = strValueOf + "_profileImage.jpg";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ca A[Catch: IOException -> 0x01a6, TryCatch #2 {IOException -> 0x01a6, blocks: (B:19:0x00bb, B:21:0x00ca, B:23:0x014e, B:33:0x0189, B:32:0x0183), top: B:41:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0182  */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Boolean doInBackground(java.lang.String... r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p025d.p026a.AsyncTaskC1235di.doInBackground(java.lang.String[]):java.lang.Boolean");
    }
}
