package com.sec.chaton.hugefiletransfer;

import android.os.Handler;
import com.sec.chaton.util.C4904y;
import com.sec.common.p126d.p127a.p128a.C4980d;
import com.sec.common.p126d.p127a.p128a.C4982f;
import com.sec.common.util.C5052r;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

/* compiled from: MultichannelUploadChunk.java */
/* renamed from: com.sec.chaton.hugefiletransfer.m */
/* loaded from: classes.dex */
public class C2399m extends C4982f {

    /* renamed from: a */
    private static final String f8534a = C2399m.class.getSimpleName();

    /* renamed from: b */
    private long f8535b;

    public C2399m(long j, C2393g c2393g, int i, Handler handler) {
        super(c2393g, i, handler);
        this.f8535b = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a5 A[Catch: all -> 0x009e, TRY_ENTER, TryCatch #3 {all -> 0x009e, blocks: (B:10:0x008b, B:11:0x008f, B:13:0x0095, B:14:0x009d, B:19:0x00a5, B:21:0x00ac, B:30:0x00dd, B:32:0x00e6, B:33:0x00ee, B:34:0x00ef, B:23:0x00b3, B:25:0x00b7), top: B:49:0x008b }] */
    @Override // com.sec.common.p126d.p127a.p128a.C4982f, com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void mo9167a(java.net.HttpURLConnection r14, java.io.OutputStream r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.hugefiletransfer.C2399m.mo9167a(java.net.HttpURLConnection, java.io.OutputStream):void");
    }

    @Override // com.sec.common.p126d.p127a.p128a.C4982f, com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: a */
    protected void mo10415a(HttpURLConnection httpURLConnection) throws ProtocolException {
        super.mo10415a(httpURLConnection);
        if (C4904y.f17872b) {
            C4904y.m18639b(C5052r.m19199a("chunk Content-Length: ", Long.valueOf(this.f8535b)), f8534a);
        }
        httpURLConnection.setFixedLengthStreamingMode((int) this.f8535b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
    
        throw new java.lang.InterruptedException("ChatONJsonParser is interrupted.");
     */
    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void mo10416a(java.net.HttpURLConnection r7, java.io.InputStream r8) throws java.lang.Throwable {
        /*
            r6 = this;
            r2 = 0
            if (r8 == 0) goto L81
            com.sec.common.d.a.e r0 = r6.m18919i()
            com.sec.chaton.hugefiletransfer.h r0 = (com.sec.chaton.hugefiletransfer.C2394h) r0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L92
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L92
            r4.<init>(r8)     // Catch: java.lang.Throwable -> L92
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L92
            java.lang.String r4 = ""
        L1b:
            java.lang.String r4 = r1.readLine()     // Catch: java.lang.Throwable -> L30
            if (r4 == 0) goto L3c
            boolean r5 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L30
            if (r5 == 0) goto L38
            java.lang.InterruptedException r0 = new java.lang.InterruptedException     // Catch: java.lang.Throwable -> L30
            java.lang.String r2 = "ChatONJsonParser is interrupted."
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L30
            throw r0     // Catch: java.lang.Throwable -> L30
        L30:
            r0 = move-exception
            r2 = r1
        L32:
            if (r2 == 0) goto L37
            r2.close()     // Catch: java.io.IOException -> L8e
        L37:
            throw r0
        L38:
            r3.append(r4)     // Catch: java.lang.Throwable -> L30
            goto L1b
        L3c:
            if (r1 == 0) goto L41
            r1.close()     // Catch: java.io.IOException -> L90
        L41:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L82
            java.lang.String r4 = r3.toString()     // Catch: org.json.JSONException -> L82
            r1.<init>(r4)     // Catch: org.json.JSONException -> L82
        L4a:
            r0.mo18925b(r1)
            boolean r0 = com.sec.chaton.util.C4904y.f17875e
            if (r0 == 0) goto L81
            r0 = 4
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r0 = 0
            java.lang.String r2 = "chunk : "
            r1[r0] = r2
            r2 = 1
            com.sec.common.d.a.c r0 = r6.m18918h()
            com.sec.chaton.hugefiletransfer.g r0 = (com.sec.chaton.hugefiletransfer.C2393g) r0
            int r0 = r0.m10390a()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1[r2] = r0
            r0 = 2
            java.lang.String r2 = ", Error : "
            r1[r0] = r2
            r0 = 3
            java.lang.String r2 = r3.toString()
            r1[r0] = r2
            java.lang.String r0 = com.sec.common.util.C5052r.m19199a(r1)
            java.lang.String r1 = com.sec.chaton.hugefiletransfer.C2399m.f8534a
            com.sec.chaton.util.C4904y.m18634a(r0, r1)
        L81:
            return
        L82:
            r1 = move-exception
            boolean r4 = com.sec.chaton.util.C4904y.f17875e
            if (r4 == 0) goto L8c
            java.lang.String r4 = com.sec.chaton.hugefiletransfer.C2399m.f8534a
            com.sec.chaton.util.C4904y.m18635a(r1, r4)
        L8c:
            r1 = r2
            goto L4a
        L8e:
            r1 = move-exception
            goto L37
        L90:
            r1 = move-exception
            goto L41
        L92:
            r0 = move-exception
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.hugefiletransfer.C2399m.mo10416a(java.net.HttpURLConnection, java.io.InputStream):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
    
        throw new java.lang.InterruptedException("ChatONJsonParser is interrupted.");
     */
    @Override // com.sec.common.p126d.p127a.p128a.C4982f, com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void mo10418b(java.net.HttpURLConnection r7, java.io.InputStream r8) throws java.lang.Throwable {
        /*
            r6 = this;
            r2 = 0
            if (r8 == 0) goto L81
            com.sec.common.d.a.e r0 = r6.m18919i()
            com.sec.chaton.hugefiletransfer.h r0 = (com.sec.chaton.hugefiletransfer.C2394h) r0
            int r1 = r0.m18953m()
            r3 = 204(0xcc, float:2.86E-43)
            if (r1 == r3) goto L81
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L92
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L92
            r4.<init>(r8)     // Catch: java.lang.Throwable -> L92
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L92
            java.lang.String r4 = ""
        L23:
            java.lang.String r4 = r1.readLine()     // Catch: java.lang.Throwable -> L38
            if (r4 == 0) goto L44
            boolean r5 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L38
            if (r5 == 0) goto L40
            java.lang.InterruptedException r0 = new java.lang.InterruptedException     // Catch: java.lang.Throwable -> L38
            java.lang.String r2 = "ChatONJsonParser is interrupted."
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L38
            throw r0     // Catch: java.lang.Throwable -> L38
        L38:
            r0 = move-exception
            r2 = r1
        L3a:
            if (r2 == 0) goto L3f
            r2.close()     // Catch: java.io.IOException -> L8e
        L3f:
            throw r0
        L40:
            r3.append(r4)     // Catch: java.lang.Throwable -> L38
            goto L23
        L44:
            if (r1 == 0) goto L49
            r1.close()     // Catch: java.io.IOException -> L90
        L49:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L82
            java.lang.String r4 = r3.toString()     // Catch: org.json.JSONException -> L82
            r1.<init>(r4)     // Catch: org.json.JSONException -> L82
        L52:
            r0.m10393a(r1)
            boolean r1 = com.sec.chaton.util.C4904y.f17872b
            if (r1 == 0) goto L72
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            java.lang.String r4 = "chunk Response : "
            r1[r2] = r4
            r2 = 1
            java.lang.String r3 = r3.toString()
            r1[r2] = r3
            java.lang.String r1 = com.sec.common.util.C5052r.m19199a(r1)
            java.lang.String r2 = com.sec.chaton.hugefiletransfer.C2399m.f8534a
            com.sec.chaton.util.C4904y.m18639b(r1, r2)
        L72:
            android.os.Handler r1 = r6.m18912c()
            int r2 = r6.m18909a()
            android.os.Message r0 = android.os.Message.obtain(r1, r2, r0)
            r1.sendMessage(r0)
        L81:
            return
        L82:
            r1 = move-exception
            boolean r4 = com.sec.chaton.util.C4904y.f17875e
            if (r4 == 0) goto L8c
            java.lang.String r4 = com.sec.chaton.hugefiletransfer.C2399m.f8534a
            com.sec.chaton.util.C4904y.m18635a(r1, r4)
        L8c:
            r1 = r2
            goto L52
        L8e:
            r1 = move-exception
            goto L3f
        L90:
            r1 = move-exception
            goto L49
        L92:
            r0 = move-exception
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.hugefiletransfer.C2399m.mo10418b(java.net.HttpURLConnection, java.io.InputStream):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.p126d.p127a.p128a.C4982f
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C2394h mo6146a(C4980d c4980d) {
        return new C2394h((C2393g) c4980d);
    }
}
