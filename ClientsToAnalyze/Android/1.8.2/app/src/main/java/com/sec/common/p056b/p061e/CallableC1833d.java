package com.sec.common.p056b.p061e;

import android.os.Handler;
import android.os.Message;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;

/* compiled from: FileDownloadTask.java */
/* renamed from: com.sec.common.b.e.d */
/* loaded from: classes.dex */
public final class CallableC1833d implements Callable {

    /* renamed from: a */
    private static final String f6558a = CallableC1833d.class.getSimpleName();

    /* renamed from: c */
    private static final Random f6559c = new Random(System.currentTimeMillis());

    /* renamed from: f */
    private boolean f6563f;

    /* renamed from: g */
    private String f6564g;

    /* renamed from: h */
    private File f6565h;

    /* renamed from: b */
    private final Object f6560b = new Object();

    /* renamed from: i */
    private List f6566i = new ArrayList();

    /* renamed from: j */
    private Map f6567j = new HashMap();

    /* renamed from: d */
    private boolean f6561d = false;

    /* renamed from: e */
    private boolean f6562e = false;

    CallableC1833d(String str, File file, boolean z) {
        this.f6564g = str;
        this.f6565h = file;
        this.f6563f = z;
    }

    /* renamed from: a */
    void m6225a(Handler handler, Object obj) {
        synchronized (this.f6560b) {
            if (!this.f6566i.contains(handler)) {
                this.f6566i.add(handler);
                this.f6567j.put(handler, obj);
            }
        }
    }

    /* renamed from: a */
    int m6223a(Handler handler) {
        int size;
        synchronized (this.f6560b) {
            if (this.f6566i.contains(handler)) {
                this.f6566i.remove(handler);
                this.f6567j.remove(handler);
            }
            size = this.f6566i.size();
        }
        return size;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public File call() {
        C1830a c1830aM6211a;
        String str;
        File file = null;
        try {
            try {
                if (m6220c()) {
                    m6219a(2, 0, 0, this.f6565h);
                    file = this.f6565h;
                    c1830aM6211a = C1830a.m6211a();
                    str = this.f6564g;
                } else {
                    m6219a(3, 0, 0, null);
                    c1830aM6211a = C1830a.m6211a();
                    str = this.f6564g;
                }
                c1830aM6211a.m6215a(str);
                return file;
            } catch (IOException e) {
                m6219a(4, 0, 0, null);
                throw e;
            }
        } catch (Throwable th) {
            C1830a.m6211a().m6215a(this.f6564g);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m6220c() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.common.p056b.p061e.CallableC1833d.m6220c():boolean");
    }

    /* renamed from: b */
    void m6226b() {
        synchronized (this.f6560b) {
            this.f6562e = true;
        }
    }

    /* renamed from: a */
    private void m6218a(int i) {
        m6219a(1, i, 0, null);
    }

    /* renamed from: d */
    private boolean m6221d() {
        if (this.f6565h.length() == 0) {
            this.f6565h.delete();
        }
        return this.f6565h.exists();
    }

    /* renamed from: e */
    private void m6222e() {
        synchronized (this.f6560b) {
            this.f6566i.clear();
            this.f6567j.clear();
        }
    }

    /* renamed from: a */
    private void m6219a(int i, int i2, int i3, Object obj) {
        synchronized (this.f6560b) {
            if (!this.f6561d) {
                C1834e c1835f = null;
                switch (i) {
                    case 1:
                        for (Handler handler : this.f6566i) {
                            Message.obtain(handler, i, i2, i3, this.f6567j.get(handler)).sendToTarget();
                        }
                        break;
                    case 2:
                        C1834e c1836g = new C1836g(this);
                        ((C1836g) c1836g).m6229a(this.f6565h);
                        ((C1836g) c1836g).m6230a(this.f6564g);
                        c1835f = c1836g;
                    case 3:
                        if (c1835f == null) {
                            c1835f = new C1835f(this);
                        }
                    case 4:
                        C1834e c1837h = c1835f == null ? new C1837h(this) : c1835f;
                        this.f6561d = true;
                        for (Handler handler2 : this.f6566i) {
                            c1837h.m6228a(this.f6567j.get(handler2));
                            Message.obtain(handler2, i, c1837h).sendToTarget();
                        }
                        m6222e();
                        break;
                }
            }
        }
    }
}
