package com.sec.common.p056b.p061e;

import android.content.Context;
import android.os.Handler;
import com.sec.common.p056b.C1825d;
import com.sec.common.p056b.C1829e;
import com.sec.common.p056b.p060d.C1828c;
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
/* renamed from: com.sec.common.b.e.a */
/* loaded from: classes.dex */
public class C1830a {

    /* renamed from: a */
    private static final String f6546a = C1830a.class.getSimpleName();

    /* renamed from: b */
    private static C1830a f6547b;

    /* renamed from: c */
    private final Object f6548c = new Object();

    /* renamed from: d */
    private int f6549d = 10000;

    /* renamed from: e */
    private Map f6550e = new HashMap();

    /* renamed from: f */
    private final ThreadFactory f6551f = new ThreadFactoryC1831b(this);

    /* renamed from: g */
    private final ExecutorService f6552g = Executors.newFixedThreadPool(5, this.f6551f);

    private C1830a() {
    }

    /* renamed from: a */
    public static synchronized C1830a m6211a() {
        if (f6547b == null) {
            f6547b = new C1830a();
        }
        return f6547b;
    }

    /* renamed from: a */
    public static File m6212a(Context context) throws IOException {
        File file = new File(C1829e.m6210b(context), "download");
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException(C1828c.m6207a("Couldn't create temp download directory. ", file));
        }
        return file;
    }

    /* renamed from: b */
    public int m6217b() {
        return this.f6549d;
    }

    /* renamed from: a */
    public Future m6214a(Handler handler, String str, File file, Object obj) {
        Future future;
        if (C1825d.f6539a.f6541b) {
            C1825d.f6539a.m6200a(f6546a, C1828c.m6207a("File download task count: ", Integer.valueOf(this.f6550e.size())));
        }
        synchronized (this.f6548c) {
            C1832c c1832c = (C1832c) this.f6550e.get(str);
            if (c1832c == null) {
                if (C1825d.f6539a.f6541b) {
                    C1825d.f6539a.m6200a(f6546a, "Create new FileDownloadTask.");
                }
                C1832c c1832c2 = new C1832c(this);
                c1832c2.f6554a = new CallableC1833d(str, file, true);
                if (handler != null) {
                    c1832c2.f6554a.m6225a(handler, obj);
                }
                c1832c2.f6555b = this.f6552g.submit(c1832c2.f6554a);
                c1832c2.f6556c = 1;
                future = c1832c2.f6555b;
                this.f6550e.put(str, c1832c2);
            } else {
                if (C1825d.f6539a.f6541b) {
                    C1825d.f6539a.m6200a(f6546a, "Using created FileDownloadTask.");
                }
                Future future2 = c1832c.f6555b;
                c1832c.f6556c++;
                if (handler != null) {
                    c1832c.f6554a.m6225a(handler, obj);
                }
                future = future2;
            }
        }
        return future;
    }

    /* renamed from: a */
    public File m6213a(String str, File file) throws InterruptedException, IOException {
        try {
            return (File) m6214a(null, str, file, null).get();
        } catch (InterruptedException e) {
            if (C1825d.f6539a.f6541b) {
                C1825d.f6539a.m6200a(f6546a, C1828c.m6207a(str, "'s caller thread is interrupted."));
            }
            synchronized (this.f6548c) {
                m6216a((Handler) null, str);
                throw e;
            }
        } catch (ExecutionException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* renamed from: a */
    public boolean m6216a(Handler handler, String str) {
        synchronized (this.f6548c) {
            C1832c c1832c = (C1832c) this.f6550e.get(str);
            if (c1832c == null) {
                if (C1825d.f6539a.f6543d) {
                    C1825d.f6539a.m6202b(f6546a, C1828c.m6207a("Unknown url. ", str));
                }
                return false;
            }
            if (handler != null) {
                c1832c.f6554a.m6223a(handler);
            }
            if (c1832c.f6556c == 1) {
                if (C1825d.f6539a.f6544e) {
                    C1825d.f6539a.m6204c(f6546a, C1828c.m6207a(str, "'s reference count is 0. Stop download."));
                }
                c1832c.f6554a.m6226b();
                c1832c.f6555b.cancel(true);
                this.f6550e.remove(str);
            } else {
                c1832c.f6556c--;
            }
            return true;
        }
    }

    /* renamed from: a */
    void m6215a(String str) {
        synchronized (this.f6548c) {
            this.f6550e.remove(str);
        }
    }
}
