package com.facebook.p008b;

import android.content.Context;
import com.facebook.C0127bu;
import com.facebook.EnumC0070ak;
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
public final class C0087a {

    /* renamed from: a */
    static final String f160a = C0087a.class.getSimpleName();

    /* renamed from: b */
    private static final AtomicLong f161b = new AtomicLong();

    /* renamed from: c */
    private final String f162c;

    /* renamed from: d */
    private final C0095i f163d;

    /* renamed from: e */
    private final File f164e;

    /* renamed from: f */
    private boolean f165f;

    /* renamed from: g */
    private final Object f166g = new Object();

    public C0087a(Context context, String str, C0095i c0095i) {
        this.f162c = str;
        this.f163d = c0095i;
        this.f164e = new File(context.getCacheDir(), str);
        this.f164e.mkdirs();
        C0090d.m233a(this.f164e);
    }

    /* renamed from: a */
    public InputStream m226a(String str) {
        return m228a(str, (String) null);
    }

    /* renamed from: a */
    public InputStream m228a(String str, String str2) throws IOException {
        File file = new File(this.f164e, C0105s.m276b(str));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
            try {
                JSONObject jSONObjectM241a = C0098l.m241a(bufferedInputStream);
                if (jSONObjectM241a == null) {
                    return null;
                }
                String strOptString = jSONObjectM241a.optString("key");
                if (strOptString == null || !strOptString.equals(str)) {
                    return null;
                }
                String strOptString2 = jSONObjectM241a.optString("tag", null);
                if ((str2 == null && strOptString2 != null) || (str2 != null && !str2.equals(strOptString2))) {
                    return null;
                }
                long time = new Date().getTime();
                C0099m.m244a(EnumC0070ak.CACHE, f160a, "Setting lastModified to " + Long.valueOf(time) + " for " + file.getName());
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
    OutputStream m229b(String str) {
        return m230b(str, null);
    }

    /* renamed from: b */
    public OutputStream m230b(String str, String str2) throws IOException {
        File fileM234b = C0090d.m234b(this.f164e);
        fileM234b.delete();
        if (!fileM234b.createNewFile()) {
            throw new IOException("Could not create file at " + fileM234b.getAbsolutePath());
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new C0093g(new FileOutputStream(fileM234b), new C0088b(this, str, fileM234b)), 8192);
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", str);
                    if (!C0105s.m273a(str2)) {
                        jSONObject.put("tag", str2);
                    }
                    C0098l.m242a(bufferedOutputStream, jSONObject);
                    return bufferedOutputStream;
                } catch (JSONException e) {
                    C0099m.m243a(EnumC0070ak.CACHE, 5, f160a, "Error creating JSON header for cache file: " + e);
                    throw new IOException(e.getMessage());
                }
            } catch (Throwable th) {
                bufferedOutputStream.close();
                throw th;
            }
        } catch (FileNotFoundException e2) {
            C0099m.m243a(EnumC0070ak.CACHE, 5, f160a, "Error creating buffer output stream: " + e2);
            throw new IOException(e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m223a(String str, File file) {
        if (!file.renameTo(new File(this.f164e, C0105s.m276b(str)))) {
            file.delete();
        }
        m224b();
    }

    /* renamed from: a */
    public InputStream m227a(String str, InputStream inputStream) {
        return new C0094h(inputStream, m229b(str));
    }

    public String toString() {
        return "{FileLruCache: tag:" + this.f162c + " file:" + this.f164e.getName() + "}";
    }

    /* renamed from: b */
    private void m224b() {
        synchronized (this.f166g) {
            if (!this.f165f) {
                this.f165f = true;
                C0127bu.m365a().execute(new RunnableC0089c(this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m225c() {
        try {
            C0099m.m244a(EnumC0070ak.CACHE, f160a, "trim started");
            PriorityQueue priorityQueue = new PriorityQueue();
            File[] fileArrListFiles = this.f164e.listFiles(C0090d.m232a());
            int length = fileArrListFiles.length;
            long j = 0;
            long length2 = 0;
            int i = 0;
            while (i < length) {
                File file = fileArrListFiles[i];
                C0096j c0096j = new C0096j(file);
                priorityQueue.add(c0096j);
                C0099m.m244a(EnumC0070ak.CACHE, f160a, "  trim considering time=" + Long.valueOf(c0096j.m240b()) + " name=" + c0096j.m239a().getName());
                i++;
                j++;
                length2 = file.length() + length2;
            }
            long length3 = length2;
            long j2 = j;
            while (true) {
                if (length3 > this.f163d.m236a() || j2 > this.f163d.m237b()) {
                    File fileM239a = ((C0096j) priorityQueue.remove()).m239a();
                    C0099m.m244a(EnumC0070ak.CACHE, f160a, "  trim removing " + fileM239a.getName());
                    length3 -= fileM239a.length();
                    long j3 = j2 - 1;
                    fileM239a.delete();
                    j2 = j3;
                } else {
                    synchronized (this.f166g) {
                        this.f165f = false;
                        this.f166g.notifyAll();
                    }
                    return;
                }
            }
        } catch (Throwable th) {
            synchronized (this.f166g) {
                this.f165f = false;
                this.f166g.notifyAll();
                throw th;
            }
        }
    }
}
