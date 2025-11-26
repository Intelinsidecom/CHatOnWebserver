package com.sec.chaton.smsplugin.p102b;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.smsplugin.C3811d;

/* compiled from: Conversation.java */
/* renamed from: com.sec.chaton.smsplugin.b.j */
/* loaded from: classes.dex */
class RunnableC3791j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Uri f13609a;

    /* renamed from: b */
    final /* synthetic */ C3790i f13610b;

    RunnableC3791j(C3790i c3790i, Uri uri) {
        this.f13610b = c3790i;
        this.f13609a = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        synchronized (this.f13610b.f13608v) {
            if (this.f13610b.f13607u) {
                try {
                    this.f13610b.f13608v.wait();
                } catch (InterruptedException e) {
                }
            }
            if (this.f13609a != null) {
                this.f13610b.m14350s();
                Cursor cursorQuery = this.f13610b.f13596h.getContentResolver().query(this.f13609a, C3790i.f13591e, "(read=0 OR seen=0)", null, null);
                if (cursorQuery != null) {
                    try {
                        z = cursorQuery.getCount() > 0;
                    } finally {
                        cursorQuery.close();
                    }
                } else {
                    z = true;
                }
                if (z) {
                    C3811d.m14485a("markAsRead: update read/seen for thread uri: " + this.f13609a, new Object[0]);
                    this.f13610b.f13596h.getContentResolver().update(this.f13609a, C3790i.f13594s, "(read=0 OR seen=0)", null);
                }
                this.f13610b.m14339d(false);
            }
        }
    }
}
