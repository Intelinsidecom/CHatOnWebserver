package com.samsung.samm.lib.p003a;

import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.samsung.samm.lib.a.f */
/* loaded from: classes.dex */
public class C0892f {

    /* renamed from: a */
    private C0895i f551a;

    /* renamed from: b */
    private C0893g f552b;

    /* renamed from: c */
    private C0894h f553c;

    /* renamed from: d */
    private a[] f554d;

    /* renamed from: e */
    private boolean f555e;

    public C0892f() {
        m431e();
    }

    /* renamed from: e */
    private void m431e() {
        this.f551a = new C0895i();
        this.f552b = new C0893g();
        this.f553c = new C0894h();
        this.f555e = false;
        this.f554d = new a[255];
        for (int i = 0; i < 255; i++) {
            this.f554d[i] = new a();
        }
    }

    /* renamed from: a */
    public C0895i m432a() {
        return this.f551a;
    }

    /* renamed from: b */
    public C0893g m433b() {
        return this.f552b;
    }

    /* renamed from: c */
    public C0894h m436c() {
        return this.f553c;
    }

    /* renamed from: d */
    public boolean m437d() {
        return this.f555e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m430a(java.lang.String r6) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r6 != 0) goto L4
        L3:
            return r0
        L4:
            java.io.File r1 = new java.io.File
            r1.<init>(r6)
            boolean r2 = r1.exists()
            if (r2 == 0) goto L3
            r3 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.io.FileNotFoundException -> L3a java.lang.Throwable -> L72
            java.lang.String r4 = "r"
            r2.<init>(r1, r4)     // Catch: java.io.FileNotFoundException -> L3a java.lang.Throwable -> L72
            int r0 = m429a(r2)     // Catch: java.lang.Throwable -> L93 java.io.FileNotFoundException -> L95
            if (r2 == 0) goto L3
            r2.close()     // Catch: java.io.IOException -> L21
            goto L3
        L21:
            r1 = move-exception
            java.lang.String r2 = "SAMMLibraryCore"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Read AMS Header Error : IOException : "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r2, r3)
            r1.printStackTrace()
            goto L3
        L3a:
            r1 = move-exception
            r2 = r3
        L3c:
            java.lang.String r3 = "SAMMLibraryCore"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            java.lang.String r5 = "Read AMS Header Error : FileNotFoundException : "
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L93
            java.lang.StringBuilder r4 = r4.append(r1)     // Catch: java.lang.Throwable -> L93
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L93
            android.util.Log.e(r3, r4)     // Catch: java.lang.Throwable -> L93
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L93
            if (r2 == 0) goto L3
            r2.close()     // Catch: java.io.IOException -> L59
            goto L3
        L59:
            r1 = move-exception
            java.lang.String r2 = "SAMMLibraryCore"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Read AMS Header Error : IOException : "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r2, r3)
            r1.printStackTrace()
            goto L3
        L72:
            r0 = move-exception
            r2 = r3
        L74:
            if (r2 == 0) goto L79
            r2.close()     // Catch: java.io.IOException -> L7a
        L79:
            throw r0
        L7a:
            r1 = move-exception
            java.lang.String r2 = "SAMMLibraryCore"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Read AMS Header Error : IOException : "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r2, r3)
            r1.printStackTrace()
            goto L79
        L93:
            r0 = move-exception
            goto L74
        L95:
            r1 = move-exception
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.samm.lib.p003a.C0892f.m430a(java.lang.String):int");
    }

    /* renamed from: a */
    public static int m429a(RandomAccessFile randomAccessFile) throws IOException {
        int i = 0;
        try {
            int length = (int) randomAccessFile.length();
            int i2 = length - 16;
            try {
                if (i2 < 0) {
                    Log.e("SAMMLibraryCore", "Not AMS File(Not enough data size)");
                } else {
                    randomAccessFile.seek(0L);
                    if (randomAccessFile.skipBytes(i2) != i2) {
                        Log.e("SAMMLibraryCore", "Skip to the tail of AMS Data Fail");
                    } else {
                        C0893g c0893g = new C0893g();
                        if (c0893g.m440a(randomAccessFile)) {
                            int iM438a = ((length - 4) - c0893g.m438a()) - 16;
                            randomAccessFile.seek(0L);
                            if (randomAccessFile.skipBytes(iM438a) != iM438a) {
                                Log.e("SAMMLibraryCore", "Skip to the head of AMS Data Fail");
                            } else if (new C0895i().m506a(randomAccessFile)) {
                                i = iM438a;
                            }
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                Log.e("SAMMLibraryCore", "Read AMS Tag Error : FileNotFoundException : " + e);
                e.printStackTrace();
            } catch (IOException e2) {
                Log.e("SAMMLibraryCore", "Read AMS Tag Error : IOException : " + e2);
                e2.printStackTrace();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            Log.e("SAMMLibraryCore", "Error while getting file length");
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m435b(java.lang.String r7) throws java.lang.Throwable {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L4
        L3:
            return r0
        L4:
            java.io.File r1 = new java.io.File
            r1.<init>(r7)
            boolean r2 = r1.exists()
            if (r2 == 0) goto L3
            r3 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.io.FileNotFoundException -> L3c java.lang.Throwable -> L74
            java.lang.String r4 = "r"
            r2.<init>(r1, r4)     // Catch: java.io.FileNotFoundException -> L3c java.lang.Throwable -> L74
            boolean r1 = r6.m434b(r2)     // Catch: java.lang.Throwable -> Lb6 java.io.FileNotFoundException -> Lb8
            if (r1 != 0) goto L95
            if (r2 == 0) goto L3
            r2.close()     // Catch: java.io.IOException -> L23
            goto L3
        L23:
            r1 = move-exception
            java.lang.String r2 = "SAMMLibraryCore"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Read AMS Header Error : IOException : "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r2, r3)
            r1.printStackTrace()
            goto L3
        L3c:
            r1 = move-exception
            r2 = r3
        L3e:
            java.lang.String r3 = "SAMMLibraryCore"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r5 = "Read AMS Header Error : FileNotFoundException : "
            r4.<init>(r5)     // Catch: java.lang.Throwable -> Lb6
            java.lang.StringBuilder r4 = r4.append(r1)     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> Lb6
            android.util.Log.e(r3, r4)     // Catch: java.lang.Throwable -> Lb6
            r1.printStackTrace()     // Catch: java.lang.Throwable -> Lb6
            if (r2 == 0) goto L3
            r2.close()     // Catch: java.io.IOException -> L5b
            goto L3
        L5b:
            r1 = move-exception
            java.lang.String r2 = "SAMMLibraryCore"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Read AMS Header Error : IOException : "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r2, r3)
            r1.printStackTrace()
            goto L3
        L74:
            r0 = move-exception
            r2 = r3
        L76:
            if (r2 == 0) goto L7b
            r2.close()     // Catch: java.io.IOException -> L7c
        L7b:
            throw r0
        L7c:
            r1 = move-exception
            java.lang.String r2 = "SAMMLibraryCore"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Read AMS Header Error : IOException : "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r2, r3)
            r1.printStackTrace()
            goto L7b
        L95:
            if (r2 == 0) goto L9a
            r2.close()     // Catch: java.io.IOException -> L9d
        L9a:
            r0 = 1
            goto L3
        L9d:
            r0 = move-exception
            java.lang.String r1 = "SAMMLibraryCore"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Read AMS Header Error : IOException : "
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
            r0.printStackTrace()
            goto L9a
        Lb6:
            r0 = move-exception
            goto L76
        Lb8:
            r1 = move-exception
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.samm.lib.p003a.C0892f.m435b(java.lang.String):boolean");
    }

    /* renamed from: b */
    public boolean m434b(RandomAccessFile randomAccessFile) throws IOException {
        boolean z = false;
        try {
            int length = (int) randomAccessFile.length();
            int i = length - 16;
            try {
                if (i < 0) {
                    Log.e("SAMMLibraryCore", "Not AMS File(Not enough data size)");
                } else {
                    randomAccessFile.seek(0L);
                    if (randomAccessFile.skipBytes(i) != i) {
                        Log.e("SAMMLibraryCore", "Skip to the tail of AMS Data Fail");
                    } else if (this.f552b.m440a(randomAccessFile)) {
                        int iM438a = ((length - 4) - this.f552b.m438a()) - 16;
                        randomAccessFile.seek(0L);
                        if (randomAccessFile.skipBytes(iM438a) != iM438a) {
                            Log.e("SAMMLibraryCore", "Skip to the head of AMS Data Fail");
                        } else if (this.f551a.m506a(randomAccessFile)) {
                            this.f555e = true;
                            z = true;
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                Log.e("SAMMLibraryCore", "Read AMS Tag Error : FileNotFoundException : " + e);
                e.printStackTrace();
            } catch (IOException e2) {
                Log.e("SAMMLibraryCore", "Read AMS Tag Error : IOException : " + e2);
                e2.printStackTrace();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            Log.e("SAMMLibraryCore", "Error while getting file length");
        }
        return z;
    }

    /* renamed from: com.samsung.samm.lib.a.f$a */
    public class a {

        /* renamed from: b */
        private int f557b = -1;

        /* renamed from: c */
        private int f558c = 0;

        public a() {
        }
    }
}
