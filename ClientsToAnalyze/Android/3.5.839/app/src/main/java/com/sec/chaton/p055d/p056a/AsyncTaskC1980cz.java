package com.sec.chaton.p055d.p056a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0790n;

/* compiled from: GroupProfileUploadTask.java */
/* renamed from: com.sec.chaton.d.a.cz */
/* loaded from: classes.dex */
public class AsyncTaskC1980cz extends AsyncTask<String, Integer, Boolean> {

    /* renamed from: a */
    private String f7269a;

    /* renamed from: b */
    private String f7270b;

    /* renamed from: c */
    private Handler f7271c;

    public AsyncTaskC1980cz(Handler handler, String str, String str2, String str3) {
        this.f7269a = str;
        this.f7270b = str3;
        this.f7271c = handler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p055d.p056a.AsyncTaskC1980cz.doInBackground(java.lang.String[]):java.lang.Boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        Message message = new Message();
        message.what = 809;
        message.obj = new C0790n(bool.booleanValue());
        this.f7271c.sendMessage(message);
    }
}
