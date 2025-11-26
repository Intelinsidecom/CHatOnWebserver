package com.sec.chaton.util;

import android.content.SharedPreferences;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.util.C5033j;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: ToolTipManager.java */
/* renamed from: com.sec.chaton.util.cp */
/* loaded from: classes.dex */
public class C4878cp {

    /* renamed from: a */
    private static final String f17783a = C4878cp.class.getSimpleName();

    /* renamed from: b */
    private static final C4878cp f17784b = new C4878cp();

    /* renamed from: c */
    private SharedPreferences f17785c = GlobalApplication.m18732r().getSharedPreferences("tooltip", 0);

    /* renamed from: d */
    private Lock f17786d;

    /* renamed from: e */
    private Lock f17787e;

    /* renamed from: a */
    public static C4878cp m18516a() {
        return f17784b;
    }

    private C4878cp() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f17786d = reentrantReadWriteLock.readLock();
        this.f17787e = reentrantReadWriteLock.writeLock();
    }

    /* renamed from: a */
    public void m18517a(EnumC4879cq enumC4879cq) {
        this.f17787e.lock();
        try {
            int iMin = Math.min(enumC4879cq.f17807s, m18519c(enumC4879cq) + 1);
            SharedPreferences.Editor editorEdit = this.f17785c.edit();
            editorEdit.putInt(enumC4879cq.f17806r, iMin);
            C5033j.m19087a(editorEdit);
        } finally {
            this.f17787e.unlock();
        }
    }

    /* renamed from: b */
    public boolean m18518b(EnumC4879cq enumC4879cq) {
        boolean z;
        Lock lock;
        this.f17786d.lock();
        try {
            if (m18519c(enumC4879cq) < enumC4879cq.f17807s) {
                z = true;
                lock = this.f17786d;
            } else {
                z = false;
                lock = this.f17786d;
            }
            lock.unlock();
            return z;
        } catch (Throwable th) {
            this.f17786d.unlock();
            throw th;
        }
    }

    /* renamed from: c */
    public int m18519c(EnumC4879cq enumC4879cq) {
        this.f17786d.lock();
        try {
            return this.f17785c.getInt(enumC4879cq.f17806r, 0);
        } finally {
            this.f17786d.unlock();
        }
    }
}
