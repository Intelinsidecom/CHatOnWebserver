package com.sec.chaton.localbackup.chatview;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;
import android.view.View;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: BackupMediaPlayerManager.java */
/* renamed from: com.sec.chaton.localbackup.chatview.a */
/* loaded from: classes.dex */
public class C2522a {

    /* renamed from: a */
    private static final String f9092a = C2522a.class.getSimpleName();

    /* renamed from: b */
    private static final C2522a f9093b = new C2522a();

    /* renamed from: c */
    private CopyOnWriteArrayList<AsyncTaskC2523b> f9094c = new CopyOnWriteArrayList<>();

    private C2522a() {
    }

    /* renamed from: a */
    public static C2522a m10927a() {
        return f9093b;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m10929a(String str, long j, View view) {
        boolean zM10930a = m10930a(j);
        m10928d();
        if (!zM10930a) {
            AsyncTaskC2523b asyncTaskC2523b = new AsyncTaskC2523b(view, str, j);
            this.f9094c.add(asyncTaskC2523b);
            if (Build.VERSION.SDK_INT < 11) {
                asyncTaskC2523b.execute(new String[0]);
            } else {
                asyncTaskC2523b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }
    }

    /* renamed from: b */
    public void m10932b() {
        this.f9094c.clear();
    }

    /* renamed from: c */
    public void m10933c() {
        m10928d();
    }

    /* renamed from: d */
    private void m10928d() {
        synchronized (f9092a) {
            Iterator<AsyncTaskC2523b> it = this.f9094c.iterator();
            while (it.hasNext()) {
                AsyncTaskC2523b next = it.next();
                if (next != null) {
                    next.cancel(true);
                }
            }
            this.f9094c.clear();
        }
    }

    /* renamed from: a */
    public boolean m10930a(long j) {
        return this.f9094c.size() > 0 && j == this.f9094c.get(0).m11464c() && this.f9094c.get(0).getStatus() == AsyncTask.Status.RUNNING;
    }

    /* renamed from: b */
    public AsyncTaskC2523b m10931b(long j) {
        if (this.f9094c.size() > 0) {
            Iterator<AsyncTaskC2523b> it = this.f9094c.iterator();
            while (it.hasNext()) {
                AsyncTaskC2523b next = it.next();
                if (j == next.m11464c()) {
                    return next;
                }
            }
        }
        return null;
    }
}
