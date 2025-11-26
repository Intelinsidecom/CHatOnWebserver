package com.sec.chaton.qmlog;

/* compiled from: SntpClient.java */
/* renamed from: com.sec.chaton.qmlog.j */
/* loaded from: classes.dex */
public class C3128j {

    /* renamed from: a */
    private long f11506a;

    /* renamed from: b */
    private long f11507b;

    /* renamed from: c */
    private long f11508c;

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a9  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m12757a(java.lang.String r20, int r21) throws java.lang.Throwable {
        /*
            r19 = this;
            r3 = 0
            java.net.DatagramSocket r2 = new java.net.DatagramSocket     // Catch: java.lang.Exception -> L7e java.lang.Throwable -> La5
            r2.<init>()     // Catch: java.lang.Exception -> L7e java.lang.Throwable -> La5
            r0 = r21
            r2.setSoTimeout(r0)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            java.net.InetAddress r1 = java.net.InetAddress.getByName(r20)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            r3 = 48
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            java.net.DatagramPacket r4 = new java.net.DatagramPacket     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            int r5 = r3.length     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            r6 = 123(0x7b, float:1.72E-43)
            r4.<init>(r3, r5, r1, r6)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            r1 = 0
            r5 = 27
            r3[r1] = r5     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            r1 = 40
            r0 = r19
            r0.m12754a(r3, r1, r5)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            r2.send(r4)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            java.net.DatagramPacket r1 = new java.net.DatagramPacket     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            int r4 = r3.length     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            r2.receive(r1)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            long r11 = r9 - r7
            long r4 = r5 + r11
            r1 = 24
            r0 = r19
            long r11 = r0.m12755b(r3, r1)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            r1 = 32
            r0 = r19
            long r13 = r0.m12755b(r3, r1)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            r1 = 40
            r0 = r19
            long r15 = r0.m12755b(r3, r1)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            long r6 = r9 - r7
            long r17 = r15 - r13
            long r6 = r6 - r17
            long r11 = r13 - r11
            long r13 = r15 - r4
            long r11 = r11 + r13
            r13 = 2
            long r11 = r11 / r13
            long r3 = r4 + r11
            r0 = r19
            r0.f11506a = r3     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            r0 = r19
            r0.f11507b = r9     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            r0 = r19
            r0.f11508c = r6     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Laf
            if (r2 == 0) goto L7c
            r2.close()
        L7c:
            r1 = 1
        L7d:
            return r1
        L7e:
            r1 = move-exception
            r2 = r3
        L80:
            java.lang.String r3 = "SntpClient"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lad
            r4.<init>()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r5 = "request time failed: "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> Lad
            java.lang.StringBuilder r1 = r4.append(r1)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lad
            android.util.Log.d(r3, r1)     // Catch: java.lang.Throwable -> Lad
            r1 = 0
            if (r2 == 0) goto L7d
            r2.close()
            goto L7d
        La5:
            r1 = move-exception
            r2 = r3
        La7:
            if (r2 == 0) goto Lac
            r2.close()
        Lac:
            throw r1
        Lad:
            r1 = move-exception
            goto La7
        Laf:
            r1 = move-exception
            goto L80
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.qmlog.C3128j.m12757a(java.lang.String, int):boolean");
    }

    /* renamed from: a */
    public long m12756a() {
        return this.f11506a;
    }

    /* renamed from: b */
    public long m12758b() {
        return this.f11507b;
    }

    /* renamed from: a */
    private long m12753a(byte[] bArr, int i) {
        int i2 = bArr[i];
        int i3 = bArr[i + 1];
        int i4 = bArr[i + 2];
        int i5 = bArr[i + 3];
        if ((i2 & 128) == 128) {
            i2 = (i2 & 127) + 128;
        }
        if ((i3 & 128) == 128) {
            i3 = (i3 & 127) + 128;
        }
        if ((i4 & 128) == 128) {
            i4 = (i4 & 127) + 128;
        }
        if ((i5 & 128) == 128) {
            i5 = (i5 & 127) + 128;
        }
        return (i2 << 24) + (i3 << 16) + (i4 << 8) + i5;
    }

    /* renamed from: b */
    private long m12755b(byte[] bArr, int i) {
        return ((m12753a(bArr, i) - 2208988800L) * 1000) + ((m12753a(bArr, i + 4) * 1000) / 4294967296L);
    }

    /* renamed from: a */
    private void m12754a(byte[] bArr, int i, long j) {
        long j2 = j / 1000;
        long j3 = j - (1000 * j2);
        long j4 = j2 + 2208988800L;
        int i2 = i + 1;
        bArr[i] = (byte) (j4 >> 24);
        int i3 = i2 + 1;
        bArr[i2] = (byte) (j4 >> 16);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (j4 >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j4 >> 0);
        long j5 = (4294967296L * j3) / 1000;
        int i6 = i5 + 1;
        bArr[i5] = (byte) (j5 >> 24);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j5 >> 16);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (j5 >> 8);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (Math.random() * 255.0d);
    }
}
