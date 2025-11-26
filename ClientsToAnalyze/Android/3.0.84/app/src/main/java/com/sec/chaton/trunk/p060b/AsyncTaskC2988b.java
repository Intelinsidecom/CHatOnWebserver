package com.sec.chaton.trunk.p060b;

import android.os.AsyncTask;
import android.os.Handler;
import com.sec.chaton.util.C3250y;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* compiled from: FileDownloadTask.java */
/* renamed from: com.sec.chaton.trunk.b.b */
/* loaded from: classes.dex */
public class AsyncTaskC2988b extends AsyncTask<Void, Integer, String> {

    /* renamed from: a */
    private static final String f10816a = AsyncTaskC2988b.class.getSimpleName();

    /* renamed from: o */
    private static final Random f10817o = new Random(System.currentTimeMillis());

    /* renamed from: d */
    private HttpURLConnection f10820d;

    /* renamed from: e */
    private File f10821e;

    /* renamed from: h */
    private String f10824h;

    /* renamed from: i */
    private String f10825i;

    /* renamed from: j */
    private String f10826j;

    /* renamed from: k */
    private String f10827k;

    /* renamed from: l */
    private boolean f10828l;

    /* renamed from: m */
    private Object f10829m;

    /* renamed from: n */
    private boolean f10830n;

    /* renamed from: b */
    private final Object f10818b = new Object();

    /* renamed from: c */
    private final Object f10819c = new Object();

    /* renamed from: f */
    private boolean f10822f = false;

    /* renamed from: g */
    private List<Handler> f10823g = new ArrayList();

    AsyncTaskC2988b(Handler handler, String str, String str2, String str3, boolean z, Object obj, boolean z2) {
        this.f10823g.add(handler);
        this.f10824h = str;
        this.f10825i = str2;
        this.f10826j = str3;
        this.f10827k = str2 + File.separator + str3;
        this.f10828l = z;
        this.f10829m = obj;
        this.f10830n = z2;
    }

    /* renamed from: a */
    public void m10488a(Object obj) {
        this.f10829m = obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x011f, code lost:
    
        if (r14.f10821e == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0121, code lost:
    
        r14.f10821e.delete();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:160:0x018e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0187 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0133 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:204:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0138 A[Catch: Exception -> 0x00a6, TRY_ENTER, TRY_LEAVE, TryCatch #18 {Exception -> 0x00a6, blocks: (B:17:0x00a2, B:46:0x0138, B:66:0x0178), top: B:178:0x0045 }] */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2, types: [long] */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX WARN: Type inference failed for: r0v81 */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String doInBackground(java.lang.Void... r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 625
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.trunk.p060b.AsyncTaskC2988b.doInBackground(java.lang.Void[]):java.lang.String");
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        C3250y.m11450b("FileDownloadTask.onPreExecute()", f10816a);
        C2987a.m10482a().m10484b().put(this.f10827k, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        if (str == null) {
            m10485a(4, 0, 0, null);
        } else {
            m10485a(2, 0, 0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        m10485a(1, numArr[0].intValue(), 0, null);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        synchronized (this.f10818b) {
            super.onCancelled();
            C3250y.m11450b("File download is canceled: " + this.f10824h, f10816a);
            if (this.f10820d != null) {
                try {
                    this.f10820d.disconnect();
                } catch (Exception e) {
                }
            }
            m10485a(3, 0, 0, null);
        }
    }

    /* renamed from: a */
    private boolean m10486a(String str, String str2) {
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
    private void m10485a(int r6, int r7, int r8, java.lang.Object r9) {
        /*
            r5 = this;
            java.lang.Object r3 = r5.f10819c
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
            com.sec.chaton.trunk.b.e r2 = new com.sec.chaton.trunk.b.e     // Catch: java.lang.Throwable -> L51
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L51
            r0 = r2
            com.sec.chaton.trunk.b.e r0 = (com.sec.chaton.trunk.p060b.C2991e) r0     // Catch: java.lang.Throwable -> L51
            r1 = r0
            java.lang.String r4 = r5.f10825i     // Catch: java.lang.Throwable -> L51
            r1.m10493a(r4)     // Catch: java.lang.Throwable -> L51
            r0 = r2
            com.sec.chaton.trunk.b.e r0 = (com.sec.chaton.trunk.p060b.C2991e) r0     // Catch: java.lang.Throwable -> L51
            r1 = r0
            java.lang.String r4 = r5.f10826j     // Catch: java.lang.Throwable -> L51
            r1.m10495b(r4)     // Catch: java.lang.Throwable -> L51
            r0 = r2
            com.sec.chaton.trunk.b.e r0 = (com.sec.chaton.trunk.p060b.C2991e) r0     // Catch: java.lang.Throwable -> L51
            r1 = r0
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> L51
            r1.m10497c(r9)     // Catch: java.lang.Throwable -> L51
            r1 = r2
        L2a:
            if (r1 != 0) goto L31
            com.sec.chaton.trunk.b.d r1 = new com.sec.chaton.trunk.b.d     // Catch: java.lang.Throwable -> L51
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L51
        L31:
            if (r1 != 0) goto L8d
            com.sec.chaton.trunk.b.f r1 = new com.sec.chaton.trunk.b.f     // Catch: java.lang.Throwable -> L51
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L51
            r2 = r1
        L39:
            java.lang.Object r1 = r5.f10829m     // Catch: java.lang.Throwable -> L51
            r2.m10492a(r1)     // Catch: java.lang.Throwable -> L51
            com.sec.chaton.trunk.b.a r1 = com.sec.chaton.trunk.p060b.C2987a.m10482a()     // Catch: java.lang.Throwable -> L51
            java.util.Map r1 = r1.m10484b()     // Catch: java.lang.Throwable -> L51
            java.lang.String r4 = r5.f10827k     // Catch: java.lang.Throwable -> L51
            r1.remove(r4)     // Catch: java.lang.Throwable -> L51
            boolean r1 = r5.f10822f     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L54
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L51
            goto L8
        L51:
            r1 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L51
            throw r1
        L54:
            r1 = 1
            r5.f10822f = r1     // Catch: java.lang.Throwable -> L51
            java.util.List<android.os.Handler> r1 = r5.f10823g     // Catch: java.lang.Throwable -> L51
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
            java.util.List<android.os.Handler> r1 = r5.f10823g     // Catch: java.lang.Throwable -> L51
            java.util.Iterator r2 = r1.iterator()     // Catch: java.lang.Throwable -> L51
        L77:
            boolean r1 = r2.hasNext()     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L7
            java.lang.Object r1 = r2.next()     // Catch: java.lang.Throwable -> L51
            android.os.Handler r1 = (android.os.Handler) r1     // Catch: java.lang.Throwable -> L51
            java.lang.Object r4 = r5.f10829m     // Catch: java.lang.Throwable -> L51
            android.os.Message r1 = android.os.Message.obtain(r1, r6, r7, r8, r4)     // Catch: java.lang.Throwable -> L51
            r1.sendToTarget()     // Catch: java.lang.Throwable -> L51
            goto L77
        L8d:
            r2 = r1
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.trunk.p060b.AsyncTaskC2988b.m10485a(int, int, int, java.lang.Object):void");
    }
}
