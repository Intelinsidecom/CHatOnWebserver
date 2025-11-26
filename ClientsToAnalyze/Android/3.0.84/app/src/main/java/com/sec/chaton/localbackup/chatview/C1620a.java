package com.sec.chaton.localbackup.chatview;

import android.os.AsyncTask;
import android.os.Build;
import android.view.View;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: BackupMediaPlayerManager.java */
/* renamed from: com.sec.chaton.localbackup.chatview.a */
/* loaded from: classes.dex */
public class C1620a {

    /* renamed from: a */
    private static final String f6048a = C1620a.class.getSimpleName();

    /* renamed from: b */
    private static final C1620a f6049b = new C1620a();

    /* renamed from: c */
    private CopyOnWriteArrayList<AsyncTaskC1621b> f6050c = new CopyOnWriteArrayList<>();

    private C1620a() {
    }

    /* renamed from: a */
    public static C1620a m6897a() {
        return f6049b;
    }

    /* renamed from: a */
    public void m6899a(String str, long j, View view) {
        boolean zM6900a = m6900a(j);
        m6898d();
        if (!zM6900a) {
            AsyncTaskC1621b asyncTaskC1621b = new AsyncTaskC1621b(view, str, j);
            this.f6050c.add(asyncTaskC1621b);
            if (Build.VERSION.SDK_INT < 11) {
                asyncTaskC1621b.execute(new String[0]);
            } else {
                asyncTaskC1621b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }
    }

    /* renamed from: b */
    public void m6902b() {
        this.f6050c.clear();
    }

    /* renamed from: c */
    public void m6903c() {
        m6898d();
    }

    /* renamed from: d */
    private void m6898d() {
        synchronized (f6048a) {
            Iterator<AsyncTaskC1621b> it = this.f6050c.iterator();
            while (it.hasNext()) {
                AsyncTaskC1621b next = it.next();
                if (next != null) {
                    next.cancel(true);
                }
            }
            this.f6050c.clear();
        }
    }

    /* renamed from: a */
    public boolean m6900a(long j) {
        return this.f6050c.size() > 0 && j == this.f6050c.get(0).m7340c() && this.f6050c.get(0).getStatus() == AsyncTask.Status.RUNNING;
    }

    /* renamed from: b */
    public AsyncTaskC1621b m6901b(long j) {
        if (this.f6050c.size() > 0) {
            Iterator<AsyncTaskC1621b> it = this.f6050c.iterator();
            while (it.hasNext()) {
                AsyncTaskC1621b next = it.next();
                if (j == next.m7340c()) {
                    return next;
                }
            }
        }
        return null;
    }
}
