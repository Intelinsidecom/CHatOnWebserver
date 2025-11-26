package com.sec.chaton.trunk.p050c;

import android.os.AsyncTask;
import android.os.Handler;
import com.sec.chaton.util.C1786r;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* compiled from: FileDownloadTask.java */
/* renamed from: com.sec.chaton.trunk.c.b */
/* loaded from: classes.dex */
public class AsyncTaskC1570b extends AsyncTask {

    /* renamed from: a */
    private static final String f5652a = AsyncTaskC1570b.class.getSimpleName();

    /* renamed from: n */
    private static final Random f5653n = new Random(System.currentTimeMillis());

    /* renamed from: d */
    private HttpURLConnection f5656d;

    /* renamed from: e */
    private File f5657e;

    /* renamed from: h */
    private String f5660h;

    /* renamed from: i */
    private String f5661i;

    /* renamed from: j */
    private String f5662j;

    /* renamed from: k */
    private String f5663k;

    /* renamed from: l */
    private boolean f5664l;

    /* renamed from: m */
    private Object f5665m;

    /* renamed from: b */
    private final Object f5654b = new Object();

    /* renamed from: c */
    private final Object f5655c = new Object();

    /* renamed from: f */
    private boolean f5658f = false;

    /* renamed from: g */
    private List f5659g = new ArrayList();

    AsyncTaskC1570b(Handler handler, String str, String str2, String str3, boolean z, Object obj) {
        this.f5659g.add(handler);
        this.f5660h = str;
        this.f5661i = str2;
        this.f5662j = str3;
        this.f5663k = str2 + File.separator + str3;
        this.f5664l = z;
        this.f5665m = obj;
    }

    /* renamed from: a */
    public void m5436a(Object obj) {
        this.f5665m = obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x011b, code lost:
    
        if (r14.f5657e == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x011d, code lost:
    
        r14.f5657e.delete();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0183 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x018a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x012f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0134 A[Catch: Exception -> 0x00a6, TRY_ENTER, TRY_LEAVE, TryCatch #19 {Exception -> 0x00a6, blocks: (B:17:0x00a2, B:43:0x0134, B:63:0x0174), top: B:178:0x0045 }] */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2, types: [long] */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX WARN: Type inference failed for: r0v80 */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String doInBackground(java.lang.Void... r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 621
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.trunk.p050c.AsyncTaskC1570b.doInBackground(java.lang.Void[]):java.lang.String");
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        C1786r.m6061b("FileDownloadTask.onPreExecute()", f5652a);
        C1569a.m5430a().m5432b().put(this.f5663k, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        if (str == null) {
            m5433a(4, 0, 0, null);
        } else {
            m5433a(2, 0, 0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        m5433a(1, numArr[0].intValue(), 0, null);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        synchronized (this.f5654b) {
            super.onCancelled();
            C1786r.m6061b("File download is canceled: " + this.f5660h, f5652a);
            if (this.f5656d != null) {
                try {
                    this.f5656d.disconnect();
                } catch (Exception e) {
                }
            }
            m5433a(3, 0, 0, null);
        }
    }

    /* renamed from: a */
    private boolean m5434a(String str, String str2) {
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
    private void m5433a(int r6, int r7, int r8, java.lang.Object r9) {
        /*
            r5 = this;
            java.lang.Object r3 = r5.f5655c
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
            com.sec.chaton.trunk.c.e r2 = new com.sec.chaton.trunk.c.e     // Catch: java.lang.Throwable -> L51
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L51
            r0 = r2
            com.sec.chaton.trunk.c.e r0 = (com.sec.chaton.trunk.p050c.C1573e) r0     // Catch: java.lang.Throwable -> L51
            r1 = r0
            java.lang.String r4 = r5.f5661i     // Catch: java.lang.Throwable -> L51
            r1.m5441a(r4)     // Catch: java.lang.Throwable -> L51
            r0 = r2
            com.sec.chaton.trunk.c.e r0 = (com.sec.chaton.trunk.p050c.C1573e) r0     // Catch: java.lang.Throwable -> L51
            r1 = r0
            java.lang.String r4 = r5.f5662j     // Catch: java.lang.Throwable -> L51
            r1.m5443b(r4)     // Catch: java.lang.Throwable -> L51
            r0 = r2
            com.sec.chaton.trunk.c.e r0 = (com.sec.chaton.trunk.p050c.C1573e) r0     // Catch: java.lang.Throwable -> L51
            r1 = r0
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> L51
            r1.m5445c(r9)     // Catch: java.lang.Throwable -> L51
            r1 = r2
        L2a:
            if (r1 != 0) goto L31
            com.sec.chaton.trunk.c.d r1 = new com.sec.chaton.trunk.c.d     // Catch: java.lang.Throwable -> L51
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L51
        L31:
            if (r1 != 0) goto L8d
            com.sec.chaton.trunk.c.f r1 = new com.sec.chaton.trunk.c.f     // Catch: java.lang.Throwable -> L51
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L51
            r2 = r1
        L39:
            java.lang.Object r1 = r5.f5665m     // Catch: java.lang.Throwable -> L51
            r2.m5440a(r1)     // Catch: java.lang.Throwable -> L51
            com.sec.chaton.trunk.c.a r1 = com.sec.chaton.trunk.p050c.C1569a.m5430a()     // Catch: java.lang.Throwable -> L51
            java.util.Map r1 = r1.m5432b()     // Catch: java.lang.Throwable -> L51
            java.lang.String r4 = r5.f5663k     // Catch: java.lang.Throwable -> L51
            r1.remove(r4)     // Catch: java.lang.Throwable -> L51
            boolean r1 = r5.f5658f     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L54
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L51
            goto L8
        L51:
            r1 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L51
            throw r1
        L54:
            r1 = 1
            r5.f5658f = r1     // Catch: java.lang.Throwable -> L51
            java.util.List r1 = r5.f5659g     // Catch: java.lang.Throwable -> L51
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
            java.util.List r1 = r5.f5659g     // Catch: java.lang.Throwable -> L51
            java.util.Iterator r2 = r1.iterator()     // Catch: java.lang.Throwable -> L51
        L77:
            boolean r1 = r2.hasNext()     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L7
            java.lang.Object r1 = r2.next()     // Catch: java.lang.Throwable -> L51
            android.os.Handler r1 = (android.os.Handler) r1     // Catch: java.lang.Throwable -> L51
            java.lang.Object r4 = r5.f5665m     // Catch: java.lang.Throwable -> L51
            android.os.Message r1 = android.os.Message.obtain(r1, r6, r7, r8, r4)     // Catch: java.lang.Throwable -> L51
            r1.sendToTarget()     // Catch: java.lang.Throwable -> L51
            goto L77
        L8d:
            r2 = r1
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.trunk.p050c.AsyncTaskC1570b.m5433a(int, int, int, java.lang.Object):void");
    }
}
