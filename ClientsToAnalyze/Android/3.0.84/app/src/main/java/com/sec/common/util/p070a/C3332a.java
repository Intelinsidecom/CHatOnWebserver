package com.sec.common.util.p070a;

import android.content.Context;
import android.os.Handler;
import com.sec.common.C3330f;
import com.sec.common.util.C3350l;
import com.sec.common.util.C3364o;
import com.sec.common.util.EnumC3363n;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/* compiled from: FileDownloadManager.java */
/* renamed from: com.sec.common.util.a.a */
/* loaded from: classes.dex */
public class C3332a {

    /* renamed from: a */
    private static final String f12041a = C3332a.class.getSimpleName();

    /* renamed from: b */
    private static C3332a f12042b;

    /* renamed from: c */
    private final Object f12043c = new Object();

    /* renamed from: d */
    private int f12044d = 10000;

    /* renamed from: e */
    private Map<String, C3334c> f12045e = new HashMap();

    /* renamed from: f */
    private final ThreadFactory f12046f = new ThreadFactoryC3333b(this);

    /* renamed from: g */
    private final ExecutorService f12047g = Executors.newFixedThreadPool(5, this.f12046f);

    private C3332a() {
    }

    /* renamed from: a */
    public static synchronized C3332a m11750a() {
        if (f12042b == null) {
            f12042b = new C3332a();
        }
        return f12042b;
    }

    /* renamed from: a */
    public static File m11751a(Context context) {
        return m11752a(context, EnumC3363n.USE_BOTH_EXTERNAL_FIRST);
    }

    /* renamed from: a */
    public static File m11752a(Context context, EnumC3363n enumC3363n) throws IOException {
        File file = new File(C3350l.m11807b(context, enumC3363n), "download");
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException(C3364o.m11849a("Couldn't create temp download directory. option : ", enumC3363n, " / ", file));
        }
        return file;
    }

    /* renamed from: b */
    public int m11757b() {
        return this.f12044d;
    }

    /* renamed from: a */
    public Future<File> m11754a(Handler handler, String str, File file, Object obj) {
        Future<File> future;
        synchronized (this.f12043c) {
            if (C3330f.f12033a.f11972b) {
                C3330f.f12033a.m11651a(f12041a, C3364o.m11849a("File download task count: ", Integer.valueOf(this.f12045e.size())));
            }
            C3334c c3334c = this.f12045e.get(str);
            if (c3334c == null) {
                if (C3330f.f12033a.f11972b) {
                    C3330f.f12033a.m11651a(f12041a, "Create new FileDownloadTask.");
                }
                C3334c c3334c2 = new C3334c(this);
                c3334c2.f12049a = new CallableC3335d(str, file, true);
                if (handler != null) {
                    c3334c2.f12049a.m11766a(handler, obj);
                }
                c3334c2.f12050b = this.f12047g.submit(c3334c2.f12049a);
                c3334c2.f12051c = 1;
                future = c3334c2.f12050b;
                this.f12045e.put(str, c3334c2);
            } else {
                if (C3330f.f12033a.f11972b) {
                    C3330f.f12033a.m11651a(f12041a, "Using created FileDownloadTask.");
                }
                Future<File> future2 = c3334c.f12050b;
                c3334c.f12051c++;
                if (handler != null) {
                    c3334c.f12049a.m11766a(handler, obj);
                }
                future = future2;
            }
        }
        return future;
    }

    /* renamed from: a */
    public File m11753a(String str, File file) throws InterruptedException, IOException {
        try {
            return m11754a(null, str, file, null).get();
        } catch (InterruptedException e) {
            if (C3330f.f12033a.f11972b) {
                C3330f.f12033a.m11651a(f12041a, C3364o.m11849a(str, "'s caller thread is interrupted."));
            }
            synchronized (this.f12043c) {
                m11756a((Handler) null, str);
                throw e;
            }
        } catch (ExecutionException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* renamed from: b */
    public File m11758b(Handler handler, String str, File file, Object obj) throws InterruptedException, IOException {
        try {
            return m11754a(handler, str, file, obj).get();
        } catch (InterruptedException e) {
            if (C3330f.f12033a.f11972b) {
                C3330f.f12033a.m11651a(f12041a, C3364o.m11849a(str, "'s caller thread is interrupted."));
            }
            synchronized (this.f12043c) {
                m11756a((Handler) null, str);
                throw e;
            }
        } catch (ExecutionException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* renamed from: a */
    public boolean m11756a(Handler handler, String str) {
        synchronized (this.f12043c) {
            C3334c c3334c = this.f12045e.get(str);
            if (c3334c == null) {
                if (C3330f.f12033a.f11974d) {
                    C3330f.f12033a.m11656c(f12041a, C3364o.m11849a("Unknown url. ", str));
                }
                return false;
            }
            if (handler != null) {
                c3334c.f12049a.m11764a(handler);
            }
            if (c3334c.f12051c == 1) {
                if (C3330f.f12033a.f11974d) {
                    C3330f.f12033a.m11656c(f12041a, C3364o.m11849a(str, "'s reference count is 0. Stop download."));
                }
                c3334c.f12049a.m11767b();
                c3334c.f12050b.cancel(true);
                this.f12045e.remove(str);
            } else {
                c3334c.f12051c--;
            }
            return true;
        }
    }

    /* renamed from: a */
    void m11755a(String str) {
        synchronized (this.f12043c) {
            this.f12045e.remove(str);
        }
    }
}
