package com.sec.chaton.trunk.p042b;

import android.os.AsyncTask;
import android.os.Handler;
import com.sec.chaton.util.C1341p;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* compiled from: FileDownloadTask.java */
/* renamed from: com.sec.chaton.trunk.b.a */
/* loaded from: classes.dex */
public class AsyncTaskC1130a extends AsyncTask {

    /* renamed from: a */
    private static final String f3940a = AsyncTaskC1130a.class.getSimpleName();

    /* renamed from: n */
    private static final Random f3941n = new Random(System.currentTimeMillis());

    /* renamed from: d */
    private HttpURLConnection f3944d;

    /* renamed from: e */
    private File f3945e;

    /* renamed from: h */
    private String f3948h;

    /* renamed from: i */
    private String f3949i;

    /* renamed from: j */
    private String f3950j;

    /* renamed from: k */
    private String f3951k;

    /* renamed from: l */
    private boolean f3952l;

    /* renamed from: m */
    private Object f3953m;

    /* renamed from: b */
    private final Object f3942b = new Object();

    /* renamed from: c */
    private final Object f3943c = new Object();

    /* renamed from: f */
    private boolean f3946f = false;

    /* renamed from: g */
    private List f3947g = new ArrayList();

    AsyncTaskC1130a(Handler handler, String str, String str2, String str3, boolean z, Object obj) {
        this.f3947g.add(handler);
        this.f3948h = str;
        this.f3949i = str2;
        this.f3950j = str3;
        this.f3951k = str2 + File.separator + str3;
        this.f3952l = z;
        this.f3953m = obj;
    }

    /* renamed from: a */
    public void m4156a(Object obj) {
        this.f3953m = obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x011b, code lost:
    
        if (r14.f3945e == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x011d, code lost:
    
        r14.f3945e.delete();
     */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0189 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x012f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0134 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0195 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0190 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:205:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:213:? A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String doInBackground(java.lang.Void... r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 627
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.trunk.p042b.AsyncTaskC1130a.doInBackground(java.lang.Void[]):java.lang.String");
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        C1341p.m4658b("FileDownloadTask.onPreExecute()", f3940a);
        C1131b.m4159a().m4161b().put(this.f3951k, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        if (str == null) {
            m4153a(4, 0, 0, null);
        } else {
            m4153a(2, 0, 0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        m4153a(1, numArr[0].intValue(), 0, null);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        synchronized (this.f3942b) {
            super.onCancelled();
            C1341p.m4658b("File download is canceled: " + this.f3948h, f3940a);
            if (this.f3944d != null) {
                try {
                    this.f3944d.disconnect();
                } catch (Exception e) {
                }
            }
            m4153a(3, 0, 0, null);
        }
    }

    /* renamed from: a */
    private boolean m4154a(String str, String str2) {
        return new File(str + File.separator + str2).exists();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c A[Catch: all -> 0x0051, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x0009, B:10:0x002c, B:12:0x0033, B:13:0x0039, B:15:0x004f, B:21:0x0055, B:22:0x005d, B:24:0x0063, B:25:0x0071, B:26:0x0077, B:28:0x007d), top: B:31:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033 A[Catch: all -> 0x0051, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x0009, B:10:0x002c, B:12:0x0033, B:13:0x0039, B:15:0x004f, B:21:0x0055, B:22:0x005d, B:24:0x0063, B:25:0x0071, B:26:0x0077, B:28:0x007d), top: B:31:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f A[Catch: all -> 0x0051, DONT_GENERATE, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x0009, B:10:0x002c, B:12:0x0033, B:13:0x0039, B:15:0x004f, B:21:0x0055, B:22:0x005d, B:24:0x0063, B:25:0x0071, B:26:0x0077, B:28:0x007d), top: B:31:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m4153a(int r6, int r7, int r8, java.lang.Object r9) {
        /*
            r5 = this;
            java.lang.Object r3 = r5.f3943c
            monitor-enter(r3)
            r1 = 0
            switch(r6) {
                case 1: goto L71;
                case 2: goto L9;
                case 3: goto L2a;
                case 4: goto L31;
                default: goto L7;
            }
        L7:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L51
        L8:
            return
        L9:
            com.sec.chaton.trunk.b.g r2 = new com.sec.chaton.trunk.b.g     // Catch: java.lang.Throwable -> L51
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L51
            r0 = r2
            com.sec.chaton.trunk.b.g r0 = (com.sec.chaton.trunk.p042b.C1136g) r0     // Catch: java.lang.Throwable -> L51
            r1 = r0
            java.lang.String r4 = r5.f3949i     // Catch: java.lang.Throwable -> L51
            r1.m4166a(r4)     // Catch: java.lang.Throwable -> L51
            r0 = r2
            com.sec.chaton.trunk.b.g r0 = (com.sec.chaton.trunk.p042b.C1136g) r0     // Catch: java.lang.Throwable -> L51
            r1 = r0
            java.lang.String r4 = r5.f3950j     // Catch: java.lang.Throwable -> L51
            r1.m4168b(r4)     // Catch: java.lang.Throwable -> L51
            r0 = r2
            com.sec.chaton.trunk.b.g r0 = (com.sec.chaton.trunk.p042b.C1136g) r0     // Catch: java.lang.Throwable -> L51
            r1 = r0
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> L51
            r1.m4170c(r9)     // Catch: java.lang.Throwable -> L51
            r1 = r2
        L2a:
            if (r1 != 0) goto L31
            com.sec.chaton.trunk.b.f r1 = new com.sec.chaton.trunk.b.f     // Catch: java.lang.Throwable -> L51
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L51
        L31:
            if (r1 != 0) goto L8d
            com.sec.chaton.trunk.b.e r1 = new com.sec.chaton.trunk.b.e     // Catch: java.lang.Throwable -> L51
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L51
            r2 = r1
        L39:
            java.lang.Object r1 = r5.f3953m     // Catch: java.lang.Throwable -> L51
            r2.m4165a(r1)     // Catch: java.lang.Throwable -> L51
            com.sec.chaton.trunk.b.b r1 = com.sec.chaton.trunk.p042b.C1131b.m4159a()     // Catch: java.lang.Throwable -> L51
            java.util.Map r1 = r1.m4161b()     // Catch: java.lang.Throwable -> L51
            java.lang.String r4 = r5.f3951k     // Catch: java.lang.Throwable -> L51
            r1.remove(r4)     // Catch: java.lang.Throwable -> L51
            boolean r1 = r5.f3946f     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L54
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L51
            goto L8
        L51:
            r1 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L51
            throw r1
        L54:
            r1 = 1
            r5.f3946f = r1     // Catch: java.lang.Throwable -> L51
            java.util.List r1 = r5.f3947g     // Catch: java.lang.Throwable -> L51
            java.util.Iterator r4 = r1.iterator()     // Catch: java.lang.Throwable -> L51
        L5d:
            boolean r1 = r4.hasNext()     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L7
            java.lang.Object r1 = r4.next()     // Catch: java.lang.Throwable -> L51
            android.os.Handler r1 = (android.os.Handler) r1     // Catch: java.lang.Throwable -> L51
            android.os.Message r1 = android.os.Message.obtain(r1, r6, r2)     // Catch: java.lang.Throwable -> L51
            r1.sendToTarget()     // Catch: java.lang.Throwable -> L51
            goto L5d
        L71:
            java.util.List r1 = r5.f3947g     // Catch: java.lang.Throwable -> L51
            java.util.Iterator r2 = r1.iterator()     // Catch: java.lang.Throwable -> L51
        L77:
            boolean r1 = r2.hasNext()     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L7
            java.lang.Object r1 = r2.next()     // Catch: java.lang.Throwable -> L51
            android.os.Handler r1 = (android.os.Handler) r1     // Catch: java.lang.Throwable -> L51
            java.lang.Object r4 = r5.f3953m     // Catch: java.lang.Throwable -> L51
            android.os.Message r1 = android.os.Message.obtain(r1, r6, r7, r8, r4)     // Catch: java.lang.Throwable -> L51
            r1.sendToTarget()     // Catch: java.lang.Throwable -> L51
            goto L77
        L8d:
            r2 = r1
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.trunk.p042b.AsyncTaskC1130a.m4153a(int, int, int, java.lang.Object):void");
    }
}
