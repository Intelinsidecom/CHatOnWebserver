package com.sec.chaton.settings.downloads;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.multimedia.audio.AsyncTaskC1772d;
import com.sec.chaton.multimedia.audio.EnumC1774f;
import com.sec.chaton.multimedia.audio.InterfaceC1775g;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: PlaySoundTaskManager.java */
/* renamed from: com.sec.chaton.settings.downloads.bt */
/* loaded from: classes.dex */
public class C2580bt implements InterfaceC1775g {

    /* renamed from: a */
    static HashMap<String, C2582bv> f9781a;

    /* renamed from: e */
    private static final String f9782e = C2580bt.class.getSimpleName();

    /* renamed from: b */
    String f9783b;

    /* renamed from: c */
    boolean f9784c;

    /* renamed from: d */
    ArrayList<Handler> f9785d;

    /* renamed from: f */
    private HashMap<String, AsyncTaskC1772d> f9786f;

    /* renamed from: a */
    static C2580bt m9540a(String str, Handler handler) {
        if (f9781a == null) {
            f9781a = new HashMap<>();
        }
        C2582bv c2582bv = f9781a.get(str);
        if (c2582bv == null) {
            c2582bv = new C2582bv(str);
            f9781a.put(str, c2582bv);
        }
        c2582bv.m9551a();
        C2580bt c2580bt = c2582bv.f9788a;
        c2580bt.m9543a(handler);
        return c2580bt;
    }

    /* renamed from: b */
    static void m9541b(String str, Handler handler) {
        C2582bv c2582bv;
        if (f9781a != null && (c2582bv = f9781a.get(str)) != null) {
            C2580bt c2580bt = c2582bv.f9788a;
            c2580bt.m9546b(handler);
            c2582bv.m9552b();
            if (c2582bv.m9553c()) {
                c2580bt.m9545b();
                c2580bt.m9542a();
                f9781a.remove(str);
            }
        }
    }

    private C2580bt(String str) {
        this.f9784c = false;
        this.f9783b = str;
        this.f9786f = new HashMap<>();
        this.f9785d = new ArrayList<>();
    }

    /* renamed from: a */
    void m9543a(Handler handler) {
        if (handler != null && !this.f9785d.contains(handler)) {
            this.f9785d.add(handler);
        }
    }

    /* renamed from: b */
    boolean m9546b(Handler handler) {
        if (handler == null) {
            return false;
        }
        return this.f9785d.remove(handler);
    }

    /* renamed from: a */
    void m9542a() {
        this.f9785d.clear();
    }

    /* renamed from: b */
    boolean m9547b(AsyncTaskC1772d asyncTaskC1772d) {
        String strM7321b;
        if (asyncTaskC1772d != null && (strM7321b = asyncTaskC1772d.m7321b()) != null) {
            if (m9544a(strM7321b)) {
                m9548b(strM7321b);
                return false;
            }
            if (!this.f9784c) {
                m9545b();
            }
            AsyncTaskC1772d asyncTaskC1772d2 = this.f9786f.get(strM7321b);
            if (asyncTaskC1772d2 != null) {
                m9550c(asyncTaskC1772d2);
            }
            asyncTaskC1772d.m7317a(this);
            this.f9786f.put(strM7321b, asyncTaskC1772d);
            asyncTaskC1772d.execute(new String[0]);
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public void m9545b() {
        for (AsyncTaskC1772d asyncTaskC1772d : this.f9786f.values()) {
            if (asyncTaskC1772d != null) {
                asyncTaskC1772d.cancel(true);
            }
        }
    }

    /* renamed from: a */
    boolean m9544a(String str) {
        AsyncTaskC1772d asyncTaskC1772d = this.f9786f.get(str);
        return (asyncTaskC1772d == null || asyncTaskC1772d.isCancelled() || asyncTaskC1772d.getStatus() == AsyncTask.Status.FINISHED) ? false : true;
    }

    /* renamed from: b */
    boolean m9548b(String str) {
        AsyncTaskC1772d asyncTaskC1772d = this.f9786f.get(str);
        if (asyncTaskC1772d != null && asyncTaskC1772d.getStatus() != AsyncTask.Status.FINISHED) {
            asyncTaskC1772d.cancel(true);
            return true;
        }
        return false;
    }

    /* renamed from: c */
    boolean m9550c(AsyncTaskC1772d asyncTaskC1772d) {
        if (asyncTaskC1772d == null) {
            return false;
        }
        this.f9786f.remove(asyncTaskC1772d.m7321b());
        asyncTaskC1772d.m7322c();
        return true;
    }

    /* renamed from: c */
    public EnumC1774f m9549c(String str) {
        AsyncTaskC1772d asyncTaskC1772d;
        if (this.f9786f != null && (asyncTaskC1772d = this.f9786f.get(str)) != null) {
            return asyncTaskC1772d.m7314a();
        }
        return null;
    }

    @Override // com.sec.chaton.multimedia.audio.InterfaceC1775g
    /* renamed from: a */
    public void mo7325a(AsyncTaskC1772d asyncTaskC1772d) {
        switch (asyncTaskC1772d.m7314a()) {
            case PLAY_STATUS_CANCELED:
            case PLAY_STATUS_FINISHED:
                m9550c(asyncTaskC1772d);
                break;
        }
        Iterator<Handler> it = this.f9785d.iterator();
        while (it.hasNext()) {
            Message.obtain(it.next(), asyncTaskC1772d.m7314a().m7324a(), asyncTaskC1772d).sendToTarget();
            if (!C3250y.f11734b) {
                C3250y.m11450b("onStatusChanged(), managerKey/taskKey/status : " + this.f9783b + "/" + asyncTaskC1772d.m7321b() + "/" + asyncTaskC1772d.m7314a(), f9782e);
            }
        }
    }
}
