package com.sec.common.util.p070a;

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
/* renamed from: com.sec.common.util.a.d */
/* loaded from: classes.dex */
public final class CallableC3335d implements Callable<File> {

    /* renamed from: a */
    private static final String f12053a = CallableC3335d.class.getSimpleName();

    /* renamed from: c */
    private static final Random f12054c = new Random(System.currentTimeMillis());

    /* renamed from: f */
    private boolean f12058f;

    /* renamed from: g */
    private String f12059g;

    /* renamed from: h */
    private File f12060h;

    /* renamed from: b */
    private final Object f12055b = new Object();

    /* renamed from: i */
    private List<Handler> f12061i = new ArrayList();

    /* renamed from: j */
    private Map<Handler, Object> f12062j = new HashMap();

    /* renamed from: d */
    private boolean f12056d = false;

    /* renamed from: e */
    private boolean f12057e = false;

    CallableC3335d(String str, File file, boolean z) {
        this.f12059g = str;
        this.f12060h = file;
        this.f12058f = z;
    }

    /* renamed from: a */
    void m11766a(Handler handler, Object obj) {
        synchronized (this.f12055b) {
            if (!this.f12061i.contains(handler)) {
                this.f12061i.add(handler);
                this.f12062j.put(handler, obj);
            }
        }
    }

    /* renamed from: a */
    int m11764a(Handler handler) {
        int size;
        synchronized (this.f12055b) {
            if (this.f12061i.contains(handler)) {
                this.f12061i.remove(handler);
                this.f12062j.remove(handler);
            }
            size = this.f12061i.size();
        }
        return size;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public File call() {
        File file = null;
        try {
            try {
                if (m11761c()) {
                    m11760a(2, 0, 0, this.f12060h);
                    file = this.f12060h;
                } else {
                    m11760a(3, 0, 0, null);
                }
                return file;
            } catch (IOException e) {
                m11760a(4, 0, 0, null);
                throw e;
            }
        } finally {
            C3332a.m11750a().m11755a(this.f12059g);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m11761c() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 523
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.common.util.p070a.CallableC3335d.m11761c():boolean");
    }

    /* renamed from: b */
    void m11767b() {
        synchronized (this.f12055b) {
            this.f12057e = true;
        }
    }

    /* renamed from: a */
    private void m11759a(int i) {
        m11760a(1, i, 0, null);
    }

    /* renamed from: d */
    private boolean m11762d() {
        if (this.f12060h.length() == 0) {
            this.f12060h.delete();
        }
        return this.f12060h.exists();
    }

    /* renamed from: e */
    private void m11763e() {
        synchronized (this.f12055b) {
            this.f12061i.clear();
            this.f12062j.clear();
        }
    }

    /* renamed from: a */
    private void m11760a(int i, int i2, int i3, Object obj) {
        synchronized (this.f12055b) {
            if (!this.f12056d) {
                switch (i) {
                    case 1:
                        for (Handler handler : this.f12061i) {
                            Message.obtain(handler, i, i2, i3, this.f12062j.get(handler)).sendToTarget();
                        }
                        break;
                    case 2:
                        C3338g c3338g = new C3338g(this);
                        c3338g.m11770a(this.f12060h);
                        c3338g.m11771a(this.f12059g);
                        this.f12056d = true;
                        for (Handler handler2 : this.f12061i) {
                            c3338g.m11769a(this.f12062j.get(handler2));
                            Message.obtain(handler2, i, c3338g).sendToTarget();
                        }
                        m11763e();
                        break;
                    case 3:
                        C3337f c3337f = new C3337f(this);
                        this.f12056d = true;
                        for (Handler handler3 : this.f12061i) {
                            c3337f.m11769a(this.f12062j.get(handler3));
                            Message.obtain(handler3, i, c3337f).sendToTarget();
                        }
                        m11763e();
                        break;
                    case 4:
                        C3339h c3339h = new C3339h(this);
                        this.f12056d = true;
                        for (Handler handler4 : this.f12061i) {
                            c3339h.m11769a(this.f12062j.get(handler4));
                            Message.obtain(handler4, i, c3339h).sendToTarget();
                        }
                        m11763e();
                        break;
                }
            }
        }
    }
}
