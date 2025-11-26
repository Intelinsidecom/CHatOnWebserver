package com.sec.chaton.smsplugin.p111h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.provider.Telephony;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: DraftCache.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.h.j */
/* loaded from: classes.dex */
public class C3887j {

    /* renamed from: a */
    static final String[] f13985a = {"thread_id"};

    /* renamed from: b */
    private static C3887j f13986b;

    /* renamed from: c */
    private final Context f13987c;

    /* renamed from: d */
    private boolean f13988d;

    /* renamed from: e */
    private HashSet<Long> f13989e = new HashSet<>(4);

    /* renamed from: f */
    private final HashSet<InterfaceC3889l> f13990f = new HashSet<>(1);

    private C3887j(Context context) {
        if (C3890m.m15000f("Mms:app", C3890m.f13992a)) {
            m14981a("DraftCache.constructor", new Object[0]);
        }
        this.f13987c = context;
        m14984a();
    }

    /* renamed from: a */
    public void m14984a() {
        if (C3890m.m15000f("Mms:app", C3890m.f13992a)) {
            m14981a("refresh", new Object[0]);
        }
        new Thread(new RunnableC3888k(this)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public synchronized void m14983e() {
        if (C3890m.m15000f("Mms:app", C3890m.f13992a)) {
            m14981a("rebuildCache", new Object[0]);
        }
        HashSet<Long> hashSet = this.f13989e;
        HashSet<Long> hashSet2 = new HashSet<>(hashSet.size());
        Cursor cursorQuery = SqliteWrapper.query(this.f13987c, this.f13987c.getContentResolver(), Telephony.MmsSms.CONTENT_DRAFT_URI, f13985a, (String) null, (String[]) null, (String) null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    while (!cursorQuery.isAfterLast()) {
                        long j = cursorQuery.getLong(0);
                        hashSet2.add(Long.valueOf(j));
                        if (C3890m.m15000f("Mms:app", C3890m.f13992a)) {
                            m14981a("rebuildCache: add tid=" + j, new Object[0]);
                        }
                        cursorQuery.moveToNext();
                    }
                }
            } finally {
                cursorQuery.close();
            }
        }
        this.f13989e = hashSet2;
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            m14991d();
        }
        if (this.f13990f.size() >= 1) {
            HashSet hashSet3 = new HashSet(hashSet2);
            hashSet3.removeAll(hashSet);
            HashSet hashSet4 = new HashSet(hashSet);
            hashSet4.removeAll(hashSet2);
            Iterator<InterfaceC3889l> it = this.f13990f.iterator();
            while (it.hasNext()) {
                InterfaceC3889l next = it.next();
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    next.mo14992a(((Long) it2.next()).longValue(), true);
                }
                Iterator it3 = hashSet4.iterator();
                while (it3.hasNext()) {
                    next.mo14992a(((Long) it3.next()).longValue(), false);
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized void m14985a(long j, boolean z) {
        boolean zRemove;
        if (j > 0) {
            if (z) {
                zRemove = this.f13989e.add(Long.valueOf(j));
            } else {
                zRemove = this.f13989e.remove(Long.valueOf(j));
            }
            if (C3890m.m15000f("Mms:app", C3890m.f13992a)) {
                m14981a("setDraftState: tid=" + j + ", value=" + z + ", changed=" + zRemove, new Object[0]);
            }
            if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
                m14991d();
            }
            if (zRemove) {
                Iterator<InterfaceC3889l> it = this.f13990f.iterator();
                while (it.hasNext()) {
                    it.next().mo14992a(j, z);
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized boolean m14988a(long j) {
        return this.f13989e.contains(Long.valueOf(j));
    }

    /* renamed from: a */
    public synchronized void m14986a(InterfaceC3889l interfaceC3889l) {
        if (C3890m.m15000f("Mms:app", C3890m.f13992a)) {
            m14981a("addOnDraftChangedListener " + interfaceC3889l, new Object[0]);
        }
        this.f13990f.add(interfaceC3889l);
    }

    /* renamed from: b */
    public synchronized void m14989b(InterfaceC3889l interfaceC3889l) {
        if (C3890m.m15000f("Mms:app", C3890m.f13992a)) {
            m14981a("removeOnDraftChangedListener " + interfaceC3889l, new Object[0]);
        }
        this.f13990f.remove(interfaceC3889l);
    }

    /* renamed from: a */
    public synchronized void m14987a(boolean z) {
        this.f13988d = z;
    }

    /* renamed from: b */
    public synchronized boolean m14990b() {
        return this.f13988d;
    }

    /* renamed from: a */
    public static void m14979a(Context context) {
        f13986b = new C3887j(context);
    }

    /* renamed from: c */
    public static C3887j m14982c() {
        return f13986b;
    }

    /* renamed from: d */
    public void m14991d() {
        C3890m.m14997c("Mms/draft", "dump:");
        Iterator<Long> it = this.f13989e.iterator();
        while (it.hasNext()) {
            C3890m.m14997c("Mms/draft", "  tid: " + it.next());
        }
    }

    /* renamed from: a */
    private void m14981a(String str, Object... objArr) {
        C3890m.m14996b("Mms/draft", "[DraftCache/" + Thread.currentThread().getId() + "] " + String.format(str, objArr));
    }
}
