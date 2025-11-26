package com.samsung.samm.lib.engine.p004a;

import android.media.MediaPlayer;

/* renamed from: com.samsung.samm.lib.engine.a.a */
/* loaded from: classes.dex */
public class C0908a {

    /* renamed from: a */
    private MediaPlayer f642a;

    /* renamed from: b */
    private int f643b = 0;

    public C0908a() {
        this.f642a = null;
        this.f642a = new MediaPlayer();
    }

    /* renamed from: a */
    public void m642a() {
        this.f642a.release();
        this.f642a = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m643a(java.lang.String r6, float r7, boolean r8) throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto Lb
            java.lang.String r1 = "SAMMLibraryCore"
            java.lang.String r2 = "fail startPlayEmbededAudio"
            android.util.Log.e(r1, r2)
        La:
            return r0
        Lb:
            r5.m644b()
            r3 = 0
            android.media.MediaPlayer r1 = r5.f642a     // Catch: java.io.IOException -> L47 java.lang.Throwable -> L69
            r1.reset()     // Catch: java.io.IOException -> L47 java.lang.Throwable -> L69
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.io.IOException -> L47 java.lang.Throwable -> L69
            r2.<init>(r6)     // Catch: java.io.IOException -> L47 java.lang.Throwable -> L69
            java.io.FileDescriptor r1 = r2.getFD()     // Catch: java.lang.Throwable -> L8d java.io.IOException -> L8f
            android.media.MediaPlayer r3 = r5.f642a     // Catch: java.lang.Throwable -> L8d java.io.IOException -> L8f
            r3.setDataSource(r1)     // Catch: java.lang.Throwable -> L8d java.io.IOException -> L8f
            android.media.MediaPlayer r1 = r5.f642a     // Catch: java.lang.Throwable -> L8d java.io.IOException -> L8f
            r1.setVolume(r7, r7)     // Catch: java.lang.Throwable -> L8d java.io.IOException -> L8f
            android.media.MediaPlayer r1 = r5.f642a     // Catch: java.lang.Throwable -> L8d java.io.IOException -> L8f
            r1.setLooping(r8)     // Catch: java.lang.Throwable -> L8d java.io.IOException -> L8f
            android.media.MediaPlayer r1 = r5.f642a     // Catch: java.lang.Throwable -> L8d java.io.IOException -> L8f
            r1.prepare()     // Catch: java.lang.Throwable -> L8d java.io.IOException -> L8f
            android.media.MediaPlayer r1 = r5.f642a     // Catch: java.lang.Throwable -> L8d java.io.IOException -> L8f
            r1.start()     // Catch: java.lang.Throwable -> L8d java.io.IOException -> L8f
            if (r2 == 0) goto L3b
            r2.close()     // Catch: java.io.IOException -> L7f
        L3b:
            android.media.MediaPlayer r0 = r5.f642a
            com.samsung.samm.lib.engine.a.a$1 r1 = new com.samsung.samm.lib.engine.a.a$1
            r1.<init>()
            r0.setOnCompletionListener(r1)
            r0 = 1
            goto La
        L47:
            r1 = move-exception
            r2 = r3
        L49:
            java.lang.String r3 = "SAMMLibraryCore"
            java.lang.String r4 = r1.getMessage()     // Catch: java.lang.Throwable -> L8d
            android.util.Log.e(r3, r4)     // Catch: java.lang.Throwable -> L8d
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L8d
            if (r2 == 0) goto La
            r2.close()     // Catch: java.io.IOException -> L5b
            goto La
        L5b:
            r1 = move-exception
            java.lang.String r2 = "SAMMLibraryCore"
            java.lang.String r3 = r1.getMessage()
            android.util.Log.e(r2, r3)
            r1.printStackTrace()
            goto La
        L69:
            r0 = move-exception
            r2 = r3
        L6b:
            if (r2 == 0) goto L70
            r2.close()     // Catch: java.io.IOException -> L71
        L70:
            throw r0
        L71:
            r1 = move-exception
            java.lang.String r2 = "SAMMLibraryCore"
            java.lang.String r3 = r1.getMessage()
            android.util.Log.e(r2, r3)
            r1.printStackTrace()
            goto L70
        L7f:
            r0 = move-exception
            java.lang.String r1 = "SAMMLibraryCore"
            java.lang.String r2 = r0.getMessage()
            android.util.Log.e(r1, r2)
            r0.printStackTrace()
            goto L3b
        L8d:
            r0 = move-exception
            goto L6b
        L8f:
            r1 = move-exception
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.samm.lib.engine.p004a.C0908a.m643a(java.lang.String, float, boolean):boolean");
    }

    /* renamed from: b */
    public void m644b() throws IllegalStateException {
        if (this.f642a.isPlaying()) {
            this.f642a.stop();
        }
        this.f643b = 0;
    }

    /* renamed from: c */
    public void m645c() throws IllegalStateException {
        if (this.f642a.isPlaying()) {
            this.f642a.pause();
            this.f643b = this.f642a.getCurrentPosition();
        }
    }

    /* renamed from: d */
    public void m646d() throws IllegalStateException {
        if (this.f643b > 0 && !this.f642a.isPlaying()) {
            this.f642a.seekTo(this.f643b);
            this.f642a.start();
        }
    }

    /* renamed from: e */
    public boolean m647e() {
        return this.f642a.isPlaying();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.String] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m640a(java.lang.String r5) throws java.lang.Throwable {
        /*
            android.media.MediaPlayer r3 = new android.media.MediaPlayer
            r3.<init>()
            r2 = 0
            r3.reset()     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L45
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L45
            r1.<init>(r5)     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L45
            java.io.FileDescriptor r0 = r1.getFD()     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6e
            r3.setDataSource(r0)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6e
            r3.release()
            if (r1 == 0) goto L1d
            r1.close()     // Catch: java.lang.Exception -> L5e
        L1d:
            r0 = 1
        L1e:
            return r0
        L1f:
            r0 = move-exception
            r1 = r2
        L21:
            java.lang.String r2 = "SAMMLibraryCore"
            java.lang.String r4 = r0.getMessage()     // Catch: java.lang.Throwable -> L6c
            android.util.Log.e(r2, r4)     // Catch: java.lang.Throwable -> L6c
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L6c
            r3.release()
            if (r1 == 0) goto L35
            r1.close()     // Catch: java.lang.Exception -> L37
        L35:
            r0 = 0
            goto L1e
        L37:
            r0 = move-exception
            java.lang.String r1 = "SAMMLibraryCore"
            java.lang.String r2 = r0.getMessage()
            android.util.Log.e(r1, r2)
            r0.printStackTrace()
            goto L35
        L45:
            r0 = move-exception
            r1 = r2
        L47:
            r3.release()
            if (r1 == 0) goto L4f
            r1.close()     // Catch: java.lang.Exception -> L50
        L4f:
            throw r0
        L50:
            r1 = move-exception
            java.lang.String r2 = "SAMMLibraryCore"
            java.lang.String r3 = r1.getMessage()
            android.util.Log.e(r2, r3)
            r1.printStackTrace()
            goto L4f
        L5e:
            r0 = move-exception
            java.lang.String r1 = "SAMMLibraryCore"
            java.lang.String r2 = r0.getMessage()
            android.util.Log.e(r1, r2)
            r0.printStackTrace()
            goto L1d
        L6c:
            r0 = move-exception
            goto L47
        L6e:
            r0 = move-exception
            goto L21
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.samm.lib.engine.p004a.C0908a.m640a(java.lang.String):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.String] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m641b(java.lang.String r5) throws java.lang.Throwable {
        /*
            android.media.MediaPlayer r3 = new android.media.MediaPlayer
            r3.<init>()
            r2 = 0
            r3.reset()     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L4b
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L4b
            r1.<init>(r5)     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L4b
            java.io.FileDescriptor r0 = r1.getFD()     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L74
            r3.setDataSource(r0)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L74
            r3.prepare()     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L74
            int r0 = r3.getDuration()     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L74
            r3.release()
            if (r1 == 0) goto L24
            r1.close()     // Catch: java.lang.Exception -> L64
        L24:
            return r0
        L25:
            r0 = move-exception
            r1 = r2
        L27:
            java.lang.String r2 = "SAMMLibraryCore"
            java.lang.String r4 = r0.getMessage()     // Catch: java.lang.Throwable -> L72
            android.util.Log.e(r2, r4)     // Catch: java.lang.Throwable -> L72
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L72
            r3.release()
            if (r1 == 0) goto L3b
            r1.close()     // Catch: java.lang.Exception -> L3d
        L3b:
            r0 = 0
            goto L24
        L3d:
            r0 = move-exception
            java.lang.String r1 = "SAMMLibraryCore"
            java.lang.String r2 = r0.getMessage()
            android.util.Log.e(r1, r2)
            r0.printStackTrace()
            goto L3b
        L4b:
            r0 = move-exception
            r1 = r2
        L4d:
            r3.release()
            if (r1 == 0) goto L55
            r1.close()     // Catch: java.lang.Exception -> L56
        L55:
            throw r0
        L56:
            r1 = move-exception
            java.lang.String r2 = "SAMMLibraryCore"
            java.lang.String r3 = r1.getMessage()
            android.util.Log.e(r2, r3)
            r1.printStackTrace()
            goto L55
        L64:
            r1 = move-exception
            java.lang.String r2 = "SAMMLibraryCore"
            java.lang.String r3 = r1.getMessage()
            android.util.Log.e(r2, r3)
            r1.printStackTrace()
            goto L24
        L72:
            r0 = move-exception
            goto L4d
        L74:
            r0 = move-exception
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.samm.lib.engine.p004a.C0908a.m641b(java.lang.String):int");
    }
}
