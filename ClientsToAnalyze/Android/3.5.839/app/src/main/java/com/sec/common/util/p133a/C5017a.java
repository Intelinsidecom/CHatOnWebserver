package com.sec.common.util.p133a;

import android.content.Context;
import android.os.Handler;
import com.sec.common.C4996f;
import com.sec.common.util.C5048n;
import com.sec.common.util.C5052r;
import com.sec.common.util.EnumC5050p;
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
public class C5017a {

    /* renamed from: a */
    private static final String f18306a = C5017a.class.getSimpleName();

    /* renamed from: b */
    private static C5017a f18307b;

    /* renamed from: c */
    private final Object f18308c = new Object();

    /* renamed from: d */
    private int f18309d = 10000;

    /* renamed from: e */
    private Map<String, C5019c> f18310e = new HashMap();

    /* renamed from: f */
    private final ThreadFactory f18311f = new ThreadFactoryC5018b(this);

    /* renamed from: g */
    private final ExecutorService f18312g = Executors.newFixedThreadPool(5, this.f18311f);

    private C5017a() {
    }

    /* renamed from: a */
    public static synchronized C5017a m19064a() {
        if (f18307b == null) {
            f18307b = new C5017a();
        }
        return f18307b;
    }

    /* renamed from: a */
    public static File m19065a(Context context) {
        return m19066a(context, EnumC5050p.USE_BOTH_EXTERNAL_FIRST);
    }

    /* renamed from: a */
    public static File m19066a(Context context, EnumC5050p enumC5050p) throws IOException {
        File file = new File(C5048n.m19197b(context, enumC5050p), "download");
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException(C5052r.m19199a("Couldn't create temp download directory. option : ", enumC5050p, " / ", file));
        }
        return file;
    }

    /* renamed from: b */
    public int m19071b() {
        return this.f18309d;
    }

    /* renamed from: a */
    public Future<File> m19068a(Handler handler, String str, File file, Object obj) {
        Future<File> future;
        synchronized (this.f18308c) {
            if (C4996f.f18229a.f18171c) {
                C4996f.f18229a.m18892f(f18306a, C5052r.m19199a("File download task count: ", Integer.valueOf(this.f18310e.size())));
            }
            C5019c c5019c = this.f18310e.get(str);
            if (c5019c == null) {
                if (C4996f.f18229a.f18171c) {
                    C4996f.f18229a.m18892f(f18306a, "Create new FileDownloadTask.");
                }
                C5019c c5019c2 = new C5019c(this);
                c5019c2.f18314a = new CallableC5020d(str, file, true);
                if (handler != null) {
                    c5019c2.f18314a.m19080a(handler, obj);
                }
                c5019c2.f18315b = this.f18312g.submit(c5019c2.f18314a);
                c5019c2.f18316c = 1;
                future = c5019c2.f18315b;
                this.f18310e.put(str, c5019c2);
            } else {
                if (C4996f.f18229a.f18171c) {
                    C4996f.f18229a.m18892f(f18306a, "Using created FileDownloadTask.");
                }
                Future<File> future2 = c5019c.f18315b;
                c5019c.f18316c++;
                if (handler != null) {
                    c5019c.f18314a.m19080a(handler, obj);
                }
                future = future2;
            }
        }
        return future;
    }

    /* renamed from: a */
    public File m19067a(String str, File file) throws InterruptedException, IOException {
        try {
            return m19068a(null, str, file, null).get();
        } catch (InterruptedException e) {
            if (C4996f.f18229a.f18171c) {
                C4996f.f18229a.m18892f(f18306a, C5052r.m19199a(str, "'s caller thread is interrupted."));
            }
            synchronized (this.f18308c) {
                m19070a((Handler) null, str);
                throw e;
            }
        } catch (ExecutionException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* renamed from: b */
    public File m19072b(Handler handler, String str, File file, Object obj) throws InterruptedException, IOException {
        try {
            return m19068a(handler, str, file, obj).get();
        } catch (InterruptedException e) {
            if (C4996f.f18229a.f18171c) {
                C4996f.f18229a.m18892f(f18306a, C5052r.m19199a(str, "'s caller thread is interrupted."));
            }
            synchronized (this.f18308c) {
                m19070a((Handler) null, str);
                throw e;
            }
        } catch (ExecutionException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* renamed from: a */
    public boolean m19070a(Handler handler, String str) {
        synchronized (this.f18308c) {
            C5019c c5019c = this.f18310e.get(str);
            if (c5019c == null) {
                if (C4996f.f18229a.f18173e) {
                    C4996f.f18229a.m18894h(f18306a, C5052r.m19199a("Unknown url. ", str));
                }
                return false;
            }
            if (handler != null) {
                c5019c.f18314a.m19078a(handler);
            }
            if (c5019c.f18316c == 1) {
                if (C4996f.f18229a.f18173e) {
                    C4996f.f18229a.m18894h(f18306a, C5052r.m19199a(str, "'s reference count is 0. Stop download."));
                }
                c5019c.f18314a.m19081b();
                c5019c.f18315b.cancel(true);
                this.f18310e.remove(str);
            } else {
                c5019c.f18316c--;
            }
            return true;
        }
    }

    /* renamed from: a */
    void m19069a(String str) {
        synchronized (this.f18308c) {
            this.f18310e.remove(str);
        }
    }
}
