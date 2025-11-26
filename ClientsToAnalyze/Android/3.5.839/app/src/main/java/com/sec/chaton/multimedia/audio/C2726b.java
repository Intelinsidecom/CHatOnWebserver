package com.sec.chaton.multimedia.audio;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MediaPlayerManager.java */
/* renamed from: com.sec.chaton.multimedia.audio.b */
/* loaded from: classes.dex */
public class C2726b {

    /* renamed from: a */
    private static final String f9763a = C2726b.class.getSimpleName();

    /* renamed from: b */
    private static final C2726b f9764b = new C2726b();

    /* renamed from: c */
    private CopyOnWriteArrayList<AsyncTaskC2728d> f9765c = new CopyOnWriteArrayList<>();

    /* renamed from: d */
    private ConcurrentHashMap<String, Boolean> f9766d = new ConcurrentHashMap<>();

    /* renamed from: e */
    private HashMap<Long, View> f9767e = new HashMap<>();

    /* renamed from: f */
    private boolean f9768f;

    private C2726b() {
    }

    /* renamed from: a */
    public static C2726b m11429a() {
        return f9764b;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public boolean m11441a(String str, long j, View view, boolean z) {
        boolean zM11443b = m11443b(j);
        m11433f();
        if (!zM11443b) {
            AsyncTaskC2728d asyncTaskC2728d = new AsyncTaskC2728d(view, str, j, z);
            this.f9765c.add(asyncTaskC2728d);
            if (m11443b(asyncTaskC2728d.m11464c()) && !TextUtils.isEmpty(str) && asyncTaskC2728d.getStatus() != AsyncTask.Status.RUNNING && asyncTaskC2728d.getStatus() != AsyncTask.Status.FINISHED && !this.f9768f) {
                C4904y.m18639b("messageId: " + j + ", status:" + asyncTaskC2728d.getStatus(), f9763a);
                if (Build.VERSION.SDK_INT < 11) {
                    asyncTaskC2728d.execute(new String[0]);
                } else {
                    asyncTaskC2728d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                }
            }
        }
        C4904y.m18639b("messageId: " + j + "isPlaying: " + zM11443b, f9763a);
        return zM11443b;
    }

    /* renamed from: a */
    public void m11439a(String str, long j, View view, boolean z, Cursor cursor, int i, Handler handler, EnumC2300t enumC2300t) {
        if (!m11441a(str, j, view, z)) {
            m11431a(cursor, i, handler, enumC2300t);
        }
    }

    /* renamed from: a */
    private void m11431a(Cursor cursor, int i, Handler handler, EnumC2300t enumC2300t) {
        new Handler(Looper.getMainLooper()).post(new RunnableC2727c(this, cursor, i, handler, enumC2300t));
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m11436a(View view, String str, long j, boolean z) {
        if (!C4822an.m18245m() || !C4822an.m18246n()) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.chatroom_unable_to_record_during_call, 0).show();
            return;
        }
        AsyncTaskC2728d asyncTaskC2728dM11449e = m11449e(j);
        if (asyncTaskC2728dM11449e != null) {
            asyncTaskC2728dM11449e.m11463b(str);
        } else {
            asyncTaskC2728dM11449e = new AsyncTaskC2728d(view, str, j, z);
            this.f9765c.add(asyncTaskC2728dM11449e);
        }
        if (m11443b(asyncTaskC2728dM11449e.m11464c()) && asyncTaskC2728dM11449e.getStatus() != AsyncTask.Status.RUNNING && !TextUtils.isEmpty(asyncTaskC2728dM11449e.m11465d()) && !this.f9768f) {
            C4904y.m18639b("messageId: " + j + ", status:" + asyncTaskC2728dM11449e.getStatus(), f9763a);
            if (Build.VERSION.SDK_INT < 11) {
                asyncTaskC2728dM11449e.execute(new String[0]);
            } else {
                asyncTaskC2728dM11449e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }
    }

    /* renamed from: a */
    public void m11437a(AsyncTaskC2728d asyncTaskC2728d) {
        this.f9765c.remove(asyncTaskC2728d);
        m11432e();
    }

    /* renamed from: a */
    public void m11434a(long j) {
        Iterator<AsyncTaskC2728d> it = this.f9765c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AsyncTaskC2728d next = it.next();
            if (next != null && next.m11464c() == j) {
                next.cancel(true);
                this.f9765c.remove(next);
                break;
            }
        }
        m11432e();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: e */
    private void m11432e() {
        AsyncTaskC2728d asyncTaskC2728d;
        if (this.f9765c.size() > 0 && (asyncTaskC2728d = this.f9765c.get(0)) != null && asyncTaskC2728d.getStatus() != AsyncTask.Status.RUNNING && asyncTaskC2728d.getStatus() != AsyncTask.Status.FINISHED) {
            C4904y.m18639b("messageId: " + asyncTaskC2728d.m11464c() + ", status:" + asyncTaskC2728d.getStatus(), f9763a);
            if (!TextUtils.isEmpty(asyncTaskC2728d.m11465d())) {
                if (Build.VERSION.SDK_INT < 11) {
                    asyncTaskC2728d.execute(new String[0]);
                    return;
                } else {
                    asyncTaskC2728d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    return;
                }
            }
            m11442b();
        }
    }

    /* renamed from: b */
    public void m11442b() {
        m11433f();
    }

    /* renamed from: f */
    private void m11433f() {
        synchronized (f9763a) {
            Iterator<AsyncTaskC2728d> it = this.f9765c.iterator();
            while (it.hasNext()) {
                AsyncTaskC2728d next = it.next();
                if (next != null) {
                    next.cancel(true);
                    this.f9765c.remove(next);
                }
            }
        }
    }

    /* renamed from: b */
    public boolean m11443b(long j) {
        return this.f9765c.size() > 0 && j == this.f9765c.get(0).m11464c();
    }

    /* renamed from: c */
    public boolean m11446c(long j) {
        return this.f9765c.size() > 0 && j == this.f9765c.get(0).m11464c() && this.f9765c.get(0).getStatus() == AsyncTask.Status.RUNNING;
    }

    /* renamed from: d */
    public boolean m11448d(long j) {
        return this.f9765c.size() > 0 && j == this.f9765c.get(0).m11464c() && this.f9765c.get(0).getStatus() == AsyncTask.Status.RUNNING && this.f9765c.get(0).m11466e();
    }

    /* renamed from: e */
    public AsyncTaskC2728d m11449e(long j) {
        if (this.f9765c.size() > 0) {
            Iterator<AsyncTaskC2728d> it = this.f9765c.iterator();
            while (it.hasNext()) {
                AsyncTaskC2728d next = it.next();
                if (j == next.m11464c()) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m11438a(String str) {
        if (str != null) {
            this.f9766d.put(str, true);
        }
    }

    /* renamed from: c */
    public void m11445c() {
        this.f9766d.clear();
    }

    /* renamed from: b */
    public boolean m11444b(String str) {
        return this.f9766d.containsKey(str);
    }

    /* renamed from: a */
    public void m11435a(long j, View view) {
        this.f9767e.put(Long.valueOf(j), view);
    }

    /* renamed from: d */
    public void m11447d() {
        this.f9767e.clear();
    }

    /* renamed from: a */
    public void m11440a(boolean z) {
        this.f9768f = z;
        if (!z) {
            m11432e();
        }
    }
}
