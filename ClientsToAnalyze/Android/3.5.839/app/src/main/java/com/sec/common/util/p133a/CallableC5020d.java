package com.sec.common.util.p133a;

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
@Deprecated
/* renamed from: com.sec.common.util.a.d */
/* loaded from: classes.dex */
public final class CallableC5020d implements Callable<File> {

    /* renamed from: a */
    private static final String f18318a = CallableC5020d.class.getSimpleName();

    /* renamed from: c */
    private static final Random f18319c = new Random(System.currentTimeMillis());

    /* renamed from: f */
    private boolean f18323f;

    /* renamed from: g */
    private String f18324g;

    /* renamed from: h */
    private File f18325h;

    /* renamed from: b */
    private final Object f18320b = new Object();

    /* renamed from: i */
    private List<Handler> f18326i = new ArrayList();

    /* renamed from: j */
    private Map<Handler, Object> f18327j = new HashMap();

    /* renamed from: d */
    private boolean f18321d = false;

    /* renamed from: e */
    private boolean f18322e = false;

    CallableC5020d(String str, File file, boolean z) {
        this.f18324g = str;
        this.f18325h = file;
        this.f18323f = z;
    }

    /* renamed from: a */
    void m19080a(Handler handler, Object obj) {
        synchronized (this.f18320b) {
            if (!this.f18326i.contains(handler)) {
                this.f18326i.add(handler);
                this.f18327j.put(handler, obj);
            }
        }
    }

    /* renamed from: a */
    int m19078a(Handler handler) {
        int size;
        synchronized (this.f18320b) {
            if (this.f18326i.contains(handler)) {
                this.f18326i.remove(handler);
                this.f18327j.remove(handler);
            }
            size = this.f18326i.size();
        }
        return size;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public File call() {
        File file = null;
        try {
            try {
                if (m19075c()) {
                    m19074a(2, 0, 0, this.f18325h);
                    file = this.f18325h;
                } else {
                    m19074a(3, 0, 0, null);
                }
                return file;
            } catch (IOException e) {
                m19074a(4, 0, 0, null);
                throw e;
            }
        } finally {
            C5017a.m19064a().m19069a(this.f18324g);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:149:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m19075c() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 572
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.common.util.p133a.CallableC5020d.m19075c():boolean");
    }

    /* renamed from: b */
    void m19081b() {
        synchronized (this.f18320b) {
            this.f18322e = true;
        }
    }

    /* renamed from: a */
    private void m19073a(int i) {
        m19074a(1, i, 0, null);
    }

    /* renamed from: d */
    private boolean m19076d() {
        if (this.f18325h.length() == 0) {
            this.f18325h.delete();
        }
        return this.f18325h.exists();
    }

    /* renamed from: e */
    private void m19077e() {
        synchronized (this.f18320b) {
            this.f18326i.clear();
            this.f18327j.clear();
        }
    }

    /* renamed from: a */
    private void m19074a(int i, int i2, int i3, Object obj) {
        synchronized (this.f18320b) {
            if (!this.f18321d) {
                switch (i) {
                    case 1:
                        for (Handler handler : this.f18326i) {
                            Message.obtain(handler, i, i2, i3, this.f18327j.get(handler)).sendToTarget();
                        }
                        break;
                    case 2:
                        C5023g c5023g = new C5023g(this);
                        c5023g.m19084a(this.f18325h);
                        c5023g.m19085a(this.f18324g);
                        this.f18321d = true;
                        for (Handler handler2 : this.f18326i) {
                            c5023g.m19083a(this.f18327j.get(handler2));
                            Message.obtain(handler2, i, c5023g).sendToTarget();
                        }
                        m19077e();
                        break;
                    case 3:
                        C5022f c5022f = new C5022f(this);
                        this.f18321d = true;
                        for (Handler handler3 : this.f18326i) {
                            c5022f.m19083a(this.f18327j.get(handler3));
                            Message.obtain(handler3, i, c5022f).sendToTarget();
                        }
                        m19077e();
                        break;
                    case 4:
                        C5024h c5024h = new C5024h(this);
                        this.f18321d = true;
                        for (Handler handler4 : this.f18326i) {
                            c5024h.m19083a(this.f18327j.get(handler4));
                            Message.obtain(handler4, i, c5024h).sendToTarget();
                        }
                        m19077e();
                        break;
                }
            }
        }
    }
}
