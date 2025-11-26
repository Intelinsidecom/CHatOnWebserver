package com.sec.chaton.p025d.p026a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0274k;

/* compiled from: GroupProfileUploadTask.java */
/* renamed from: com.sec.chaton.d.a.cs */
/* loaded from: classes.dex */
public class AsyncTaskC1218cs extends AsyncTask<String, Integer, Boolean> {

    /* renamed from: a */
    private String f4721a;

    /* renamed from: b */
    private String f4722b;

    /* renamed from: c */
    private Handler f4723c;

    public AsyncTaskC1218cs(Handler handler, String str, String str2, String str3) {
        this.f4721a = str;
        this.f4722b = str3;
        this.f4723c = handler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.FileInputStream] */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Boolean doInBackground(java.lang.String... r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p025d.p026a.AsyncTaskC1218cs.doInBackground(java.lang.String[]):java.lang.Boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        Message message = new Message();
        message.what = 809;
        message.obj = new C0274k(bool.booleanValue());
        this.f4723c.sendMessage(message);
    }
}
