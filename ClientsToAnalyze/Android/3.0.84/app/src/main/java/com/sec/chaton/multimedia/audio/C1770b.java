package com.sec.chaton.multimedia.audio;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MediaPlayerManager.java */
/* renamed from: com.sec.chaton.multimedia.audio.b */
/* loaded from: classes.dex */
public class C1770b {

    /* renamed from: a */
    private static final String f6534a = C1770b.class.getSimpleName();

    /* renamed from: b */
    private static final C1770b f6535b = new C1770b();

    /* renamed from: c */
    private CopyOnWriteArrayList<AsyncTaskC1776h> f6536c = new CopyOnWriteArrayList<>();

    /* renamed from: d */
    private ConcurrentHashMap<String, Boolean> f6537d = new ConcurrentHashMap<>();

    /* renamed from: e */
    private HashMap<Long, View> f6538e = new HashMap<>();

    /* renamed from: f */
    private boolean f6539f;

    private C1770b() {
    }

    /* renamed from: a */
    public static C1770b m7289a() {
        return f6535b;
    }

    /* renamed from: a */
    public boolean m7301a(String str, long j, View view, boolean z) {
        boolean zM7303b = m7303b(j);
        m7293f();
        if (!zM7303b) {
            AsyncTaskC1776h asyncTaskC1776h = new AsyncTaskC1776h(view, str, j, z);
            this.f6536c.add(asyncTaskC1776h);
            if (m7303b(asyncTaskC1776h.m7340c()) && !TextUtils.isEmpty(str) && asyncTaskC1776h.getStatus() != AsyncTask.Status.RUNNING && asyncTaskC1776h.getStatus() != AsyncTask.Status.FINISHED && !this.f6539f) {
                C3250y.m11450b("messageId: " + j + ", status:" + asyncTaskC1776h.getStatus(), f6534a);
                if (Build.VERSION.SDK_INT < 11) {
                    asyncTaskC1776h.execute(new String[0]);
                } else {
                    asyncTaskC1776h.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                }
            }
        }
        C3250y.m11450b("messageId: " + j + "isPlaying: " + zM7303b, f6534a);
        return zM7303b;
    }

    /* renamed from: a */
    public void m7299a(String str, long j, View view, boolean z, Cursor cursor, int i, Handler handler, EnumC1450r enumC1450r) {
        if (!m7301a(str, j, view, z)) {
            m7291a(cursor, i, handler, enumC1450r);
        }
    }

    /* renamed from: a */
    private void m7291a(Cursor cursor, int i, Handler handler, EnumC1450r enumC1450r) {
        new Handler(Looper.getMainLooper()).post(new RunnableC1771c(this, cursor, i, handler, enumC1450r));
    }

    /* renamed from: a */
    public void m7296a(View view, String str, long j, boolean z) {
        if (!C3171am.m11072j() || !C3171am.m11073k()) {
            C3641ai.m13210a(CommonApplication.m11493l(), R.string.chatroom_unable_to_record_during_call, 0).show();
            return;
        }
        AsyncTaskC1776h asyncTaskC1776hM7309e = m7309e(j);
        if (asyncTaskC1776hM7309e != null) {
            asyncTaskC1776hM7309e.m7339b(str);
        } else {
            asyncTaskC1776hM7309e = new AsyncTaskC1776h(view, str, j, z);
            this.f6536c.add(asyncTaskC1776hM7309e);
        }
        if (m7303b(asyncTaskC1776hM7309e.m7340c()) && asyncTaskC1776hM7309e.getStatus() != AsyncTask.Status.RUNNING && !TextUtils.isEmpty(asyncTaskC1776hM7309e.m7341d()) && !this.f6539f) {
            C3250y.m11450b("messageId: " + j + ", status:" + asyncTaskC1776hM7309e.getStatus(), f6534a);
            if (Build.VERSION.SDK_INT < 11) {
                asyncTaskC1776hM7309e.execute(new String[0]);
            } else {
                asyncTaskC1776hM7309e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }
    }

    /* renamed from: a */
    public void m7297a(AsyncTaskC1776h asyncTaskC1776h) {
        this.f6536c.remove(asyncTaskC1776h);
        m7292e();
    }

    /* renamed from: a */
    public void m7294a(long j) {
        Iterator<AsyncTaskC1776h> it = this.f6536c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AsyncTaskC1776h next = it.next();
            if (next != null && next.m7340c() == j) {
                next.cancel(true);
                this.f6536c.remove(next);
                break;
            }
        }
        m7292e();
    }

    /* renamed from: e */
    private void m7292e() {
        AsyncTaskC1776h asyncTaskC1776h;
        if (this.f6536c.size() > 0 && (asyncTaskC1776h = this.f6536c.get(0)) != null && asyncTaskC1776h.getStatus() != AsyncTask.Status.RUNNING && asyncTaskC1776h.getStatus() != AsyncTask.Status.FINISHED) {
            C3250y.m11450b("messageId: " + asyncTaskC1776h.m7340c() + ", status:" + asyncTaskC1776h.getStatus(), f6534a);
            if (!TextUtils.isEmpty(asyncTaskC1776h.m7341d())) {
                if (Build.VERSION.SDK_INT < 11) {
                    asyncTaskC1776h.execute(new String[0]);
                    return;
                } else {
                    asyncTaskC1776h.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    return;
                }
            }
            m7302b();
        }
    }

    /* renamed from: b */
    public void m7302b() {
        m7293f();
    }

    /* renamed from: f */
    private void m7293f() {
        synchronized (f6534a) {
            Iterator<AsyncTaskC1776h> it = this.f6536c.iterator();
            while (it.hasNext()) {
                AsyncTaskC1776h next = it.next();
                if (next != null) {
                    next.cancel(true);
                    this.f6536c.remove(next);
                }
            }
        }
    }

    /* renamed from: b */
    public boolean m7303b(long j) {
        return this.f6536c.size() > 0 && j == this.f6536c.get(0).m7340c();
    }

    /* renamed from: c */
    public boolean m7306c(long j) {
        return this.f6536c.size() > 0 && j == this.f6536c.get(0).m7340c() && this.f6536c.get(0).getStatus() == AsyncTask.Status.RUNNING;
    }

    /* renamed from: d */
    public boolean m7308d(long j) {
        return this.f6536c.size() > 0 && j == this.f6536c.get(0).m7340c() && this.f6536c.get(0).getStatus() == AsyncTask.Status.RUNNING && this.f6536c.get(0).m7342e();
    }

    /* renamed from: e */
    public AsyncTaskC1776h m7309e(long j) {
        if (this.f6536c.size() > 0) {
            Iterator<AsyncTaskC1776h> it = this.f6536c.iterator();
            while (it.hasNext()) {
                AsyncTaskC1776h next = it.next();
                if (j == next.m7340c()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m7298a(String str) {
        this.f6537d.put(str, true);
    }

    /* renamed from: c */
    public void m7305c() {
        this.f6537d.clear();
    }

    /* renamed from: b */
    public boolean m7304b(String str) {
        return this.f6537d.containsKey(str);
    }

    /* renamed from: a */
    public void m7295a(long j, View view) {
        this.f6538e.put(Long.valueOf(j), view);
    }

    /* renamed from: d */
    public void m7307d() {
        this.f6538e.clear();
    }

    /* renamed from: a */
    public void m7300a(boolean z) {
        this.f6539f = z;
        if (!z) {
            m7292e();
        }
    }
}
