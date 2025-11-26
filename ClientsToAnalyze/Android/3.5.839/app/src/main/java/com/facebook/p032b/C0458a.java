package com.facebook.p032b;

import android.content.Context;
import android.hardware.motion.MotionRecognitionManager;
import com.facebook.C0498bu;
import com.facebook.EnumC0441ak;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FileLruCache.java */
/* renamed from: com.facebook.b.a */
/* loaded from: classes.dex */
public final class C0458a {

    /* renamed from: a */
    static final String f1129a = C0458a.class.getSimpleName();

    /* renamed from: b */
    private static final AtomicLong f1130b = new AtomicLong();

    /* renamed from: c */
    private final String f1131c;

    /* renamed from: d */
    private final C0466i f1132d;

    /* renamed from: e */
    private final File f1133e;

    /* renamed from: f */
    private boolean f1134f;

    /* renamed from: g */
    private final Object f1135g = new Object();

    public C0458a(Context context, String str, C0466i c0466i) {
        this.f1131c = str;
        this.f1132d = c0466i;
        this.f1133e = new File(context.getCacheDir(), str);
        this.f1133e.mkdirs();
        C0461d.m1677a(this.f1133e);
    }

    /* renamed from: a */
    public InputStream m1670a(String str) {
        return m1672a(str, (String) null);
    }

    /* renamed from: a */
    public InputStream m1672a(String str, String str2) throws IOException {
        File file = new File(this.f1133e, C0476s.m1720b(str));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), MotionRecognitionManager.EVENT_FLAT);
            try {
                JSONObject jSONObjectM1685a = C0469l.m1685a(bufferedInputStream);
                if (jSONObjectM1685a == null) {
                    return null;
                }
                String strOptString = jSONObjectM1685a.optString("key");
                if (strOptString == null || !strOptString.equals(str)) {
                    return null;
                }
                String strOptString2 = jSONObjectM1685a.optString("tag", null);
                if ((str2 == null && strOptString2 != null) || (str2 != null && !str2.equals(strOptString2))) {
                    return null;
                }
                long time = new Date().getTime();
                C0470m.m1688a(EnumC0441ak.CACHE, f1129a, "Setting lastModified to " + Long.valueOf(time) + " for " + file.getName());
                file.setLastModified(time);
                return bufferedInputStream;
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException e) {
            return null;
        }
    }

    /* renamed from: b */
    OutputStream m1673b(String str) {
        return m1674b(str, null);
    }

    /* renamed from: b */
    public OutputStream m1674b(String str, String str2) throws IOException {
        File fileM1678b = C0461d.m1678b(this.f1133e);
        fileM1678b.delete();
        if (!fileM1678b.createNewFile()) {
            throw new IOException("Could not create file at " + fileM1678b.getAbsolutePath());
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new C0464g(new FileOutputStream(fileM1678b), new C0459b(this, str, fileM1678b)), MotionRecognitionManager.EVENT_FLAT);
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", str);
                    if (!C0476s.m1717a(str2)) {
                        jSONObject.put("tag", str2);
                    }
                    C0469l.m1686a(bufferedOutputStream, jSONObject);
                    return bufferedOutputStream;
                } catch (JSONException e) {
                    C0470m.m1687a(EnumC0441ak.CACHE, 5, f1129a, "Error creating JSON header for cache file: " + e);
                    throw new IOException(e.getMessage());
                }
            } catch (Throwable th) {
                bufferedOutputStream.close();
                throw th;
            }
        } catch (FileNotFoundException e2) {
            C0470m.m1687a(EnumC0441ak.CACHE, 5, f1129a, "Error creating buffer output stream: " + e2);
            throw new IOException(e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1667a(String str, File file) {
        if (!file.renameTo(new File(this.f1133e, C0476s.m1720b(str)))) {
            file.delete();
        }
        m1668b();
    }

    /* renamed from: a */
    public InputStream m1671a(String str, InputStream inputStream) {
        return new C0465h(inputStream, m1673b(str));
    }

    public String toString() {
        return "{FileLruCache: tag:" + this.f1131c + " file:" + this.f1133e.getName() + "}";
    }

    /* renamed from: b */
    private void m1668b() {
        synchronized (this.f1135g) {
            if (!this.f1134f) {
                this.f1134f = true;
                C0498bu.m1808a().execute(new RunnableC0460c(this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m1669c() {
        try {
            C0470m.m1688a(EnumC0441ak.CACHE, f1129a, "trim started");
            PriorityQueue priorityQueue = new PriorityQueue();
            File[] fileArrListFiles = this.f1133e.listFiles(C0461d.m1676a());
            int length = fileArrListFiles.length;
            long j = 0;
            long length2 = 0;
            int i = 0;
            while (i < length) {
                File file = fileArrListFiles[i];
                C0467j c0467j = new C0467j(file);
                priorityQueue.add(c0467j);
                C0470m.m1688a(EnumC0441ak.CACHE, f1129a, "  trim considering time=" + Long.valueOf(c0467j.m1684b()) + " name=" + c0467j.m1683a().getName());
                i++;
                j++;
                length2 = file.length() + length2;
            }
            long length3 = length2;
            long j2 = j;
            while (true) {
                if (length3 > this.f1132d.m1680a() || j2 > this.f1132d.m1681b()) {
                    File fileM1683a = ((C0467j) priorityQueue.remove()).m1683a();
                    C0470m.m1688a(EnumC0441ak.CACHE, f1129a, "  trim removing " + fileM1683a.getName());
                    length3 -= fileM1683a.length();
                    long j3 = j2 - 1;
                    fileM1683a.delete();
                    j2 = j3;
                } else {
                    synchronized (this.f1135g) {
                        this.f1134f = false;
                        this.f1135g.notifyAll();
                    }
                    return;
                }
            }
        } catch (Throwable th) {
            synchronized (this.f1135g) {
                this.f1134f = false;
                this.f1135g.notifyAll();
                throw th;
            }
        }
    }
}
