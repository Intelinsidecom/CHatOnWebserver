package com.sec.chaton.smsplugin.p111h;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.provider.Telephony;

/* compiled from: RateController.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.h.u */
/* loaded from: classes.dex */
public class C3898u {

    /* renamed from: a */
    private static C3898u f14008a;

    /* renamed from: b */
    private static boolean f14009b;

    /* renamed from: c */
    private final Context f14010c;

    /* renamed from: d */
    private int f14011d;

    /* renamed from: e */
    private final BroadcastReceiver f14012e = new C3899v(this);

    private C3898u(Context context) {
        this.f14010c = context;
    }

    /* renamed from: a */
    public static void m15060a(Context context) {
        if (f14008a != null) {
            C3890m.m14997c("RateController", "Already initialized.");
        }
        f14008a = new C3898u(context);
    }

    /* renamed from: a */
    public static C3898u m15059a() {
        if (f14008a == null) {
            throw new IllegalStateException("Uninitialized.");
        }
        return f14008a;
    }

    /* renamed from: b */
    public final void m15062b() {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("sent_time", Long.valueOf(System.currentTimeMillis()));
        SqliteWrapper.insert(this.f14010c, this.f14010c.getContentResolver(), Telephony.Mms.Rate.CONTENT_URI, contentValues);
    }

    /* renamed from: c */
    public final boolean m15063c() {
        Cursor cursorQuery = SqliteWrapper.query(this.f14010c, this.f14010c.getContentResolver(), Telephony.Mms.Rate.CONTENT_URI, new String[]{"COUNT(*) AS rate"}, "sent_time>" + (System.currentTimeMillis() - 3600000), (String[]) null, (String) null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    return cursorQuery.getInt(0) >= 100;
                }
            } finally {
                cursorQuery.close();
            }
        }
        return false;
    }

    /* renamed from: d */
    public synchronized boolean m15064d() {
        boolean z;
        synchronized (this) {
            while (f14009b) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            f14009b = true;
            this.f14010c.registerReceiver(this.f14012e, new IntentFilter("com.sec.chaton.smsplugin.RATE_LIMIT_CONFIRMED"));
            this.f14011d = 0;
            try {
                Intent intent = new Intent("com.sec.chaton.smsplugin.RATE_LIMIT_SURPASSED");
                intent.addFlags(268435456);
                this.f14010c.startActivity(intent);
                z = m15061e() == 1;
            } finally {
                this.f14010c.unregisterReceiver(this.f14012e);
                f14009b = false;
                notifyAll();
            }
        }
        return z;
    }

    /* renamed from: e */
    private synchronized int m15061e() {
        for (int i = 0; this.f14011d == 0 && i < 20000; i += 1000) {
            try {
                wait(1000L);
            } catch (InterruptedException e) {
            }
        }
        return this.f14011d;
    }
}
