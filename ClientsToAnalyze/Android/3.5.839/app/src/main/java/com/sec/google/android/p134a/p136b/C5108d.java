package com.sec.google.android.p134a.p136b;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.Telephony;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: PduCache.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.google.android.a.b.d */
/* loaded from: classes.dex */
public final class C5108d extends AbstractC5105a<Uri, C5109e> {

    /* renamed from: a */
    private static final UriMatcher f18587a = new UriMatcher(-1);

    /* renamed from: b */
    private static final HashMap<Integer, Integer> f18588b;

    /* renamed from: c */
    private static C5108d f18589c;

    /* renamed from: d */
    private final HashMap<Integer, HashSet<Uri>> f18590d = new HashMap<>();

    /* renamed from: e */
    private final HashMap<Long, HashSet<Uri>> f18591e = new HashMap<>();

    static {
        f18587a.addURI("mms", null, 0);
        f18587a.addURI("mms", "#", 1);
        f18587a.addURI("mms", "inbox", 2);
        f18587a.addURI("mms", "inbox/#", 3);
        f18587a.addURI("mms", "sent", 4);
        f18587a.addURI("mms", "sent/#", 5);
        f18587a.addURI("mms", "drafts", 6);
        f18587a.addURI("mms", "drafts/#", 7);
        f18587a.addURI("mms", "outbox", 8);
        f18587a.addURI("mms", "outbox/#", 9);
        f18587a.addURI("mms-sms", "conversations", 10);
        f18587a.addURI("mms-sms", "conversations/#", 11);
        f18588b = new HashMap<>();
        f18588b.put(2, 1);
        f18588b.put(4, 2);
        f18588b.put(6, 3);
        f18588b.put(8, 4);
    }

    private C5108d() {
    }

    /* renamed from: b */
    public static final synchronized C5108d m19487b() {
        if (f18589c == null) {
            f18589c = new C5108d();
        }
        return f18589c;
    }

    @Override // com.sec.google.android.p134a.p136b.AbstractC5105a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public synchronized boolean mo19483a(Uri uri, C5109e c5109e) {
        HashSet<Uri> hashSet;
        boolean zMo19483a;
        int iM19493b = c5109e.m19493b();
        HashSet<Uri> hashSet2 = this.f18590d.get(Integer.valueOf(iM19493b));
        if (hashSet2 == null) {
            HashSet<Uri> hashSet3 = new HashSet<>();
            this.f18590d.put(Integer.valueOf(iM19493b), hashSet3);
            hashSet = hashSet3;
        } else {
            hashSet = hashSet2;
        }
        long jM19494c = c5109e.m19494c();
        HashSet<Uri> hashSet4 = this.f18591e.get(Long.valueOf(jM19494c));
        if (hashSet4 == null) {
            hashSet4 = new HashSet<>();
            this.f18591e.put(Long.valueOf(jM19494c), hashSet4);
        }
        Uri uriM19489c = m19489c(uri);
        zMo19483a = super.mo19483a((C5108d) uriM19489c, (Uri) c5109e);
        if (zMo19483a) {
            hashSet.add(uriM19489c);
            hashSet4.add(uriM19489c);
        }
        return zMo19483a;
    }

    @Override // com.sec.google.android.p134a.p136b.AbstractC5105a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized C5109e mo19484b(Uri uri) {
        C5109e c5109eB2;
        int iMatch = f18587a.match(uri);
        switch (iMatch) {
            case 0:
            case 10:
                mo19482a();
                c5109eB2 = null;
                break;
            case 1:
                c5109eB2 = b2(uri);
                break;
            case 2:
            case 4:
            case 6:
            case 8:
                m19486a(f18588b.get(Integer.valueOf(iMatch)));
                c5109eB2 = null;
                break;
            case 3:
            case 5:
            case 7:
            case 9:
                c5109eB2 = b2(Uri.withAppendedPath(Telephony.Mms.CONTENT_URI, uri.getLastPathSegment()));
                break;
            case 11:
                m19485a(ContentUris.parseId(uri));
                c5109eB2 = null;
                break;
            default:
                c5109eB2 = null;
                break;
        }
        return c5109eB2;
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private C5109e b2(Uri uri) {
        C5109e c5109e = (C5109e) super.mo19484b((C5108d) uri);
        if (c5109e == null) {
            return null;
        }
        m19488b(uri, c5109e);
        m19490c(uri, c5109e);
        return c5109e;
    }

    @Override // com.sec.google.android.p134a.p136b.AbstractC5105a
    /* renamed from: a */
    public synchronized void mo19482a() {
        super.mo19482a();
        this.f18590d.clear();
        this.f18591e.clear();
    }

    /* renamed from: c */
    private Uri m19489c(Uri uri) {
        switch (f18587a.match(uri)) {
            case 1:
                return uri;
            case 2:
            case 4:
            case 6:
            case 8:
            default:
                return null;
            case 3:
            case 5:
            case 7:
            case 9:
                return Uri.withAppendedPath(Telephony.Mms.CONTENT_URI, uri.getLastPathSegment());
        }
    }

    /* renamed from: a */
    private void m19486a(Integer num) {
        HashSet<Uri> hashSetRemove;
        if (num != null && (hashSetRemove = this.f18590d.remove(num)) != null) {
            Iterator<Uri> it = hashSetRemove.iterator();
            while (it.hasNext()) {
                Uri next = it.next();
                C5109e c5109e = (C5109e) super.mo19484b((C5108d) next);
                if (c5109e != null) {
                    m19488b(next, c5109e);
                }
            }
        }
    }

    /* renamed from: b */
    private void m19488b(Uri uri, C5109e c5109e) {
        HashSet<Uri> hashSet = this.f18591e.get(Long.valueOf(c5109e.m19494c()));
        if (hashSet != null) {
            hashSet.remove(uri);
        }
    }

    /* renamed from: a */
    private void m19485a(long j) {
        HashSet<Uri> hashSetRemove = this.f18591e.remove(Long.valueOf(j));
        if (hashSetRemove != null) {
            Iterator<Uri> it = hashSetRemove.iterator();
            while (it.hasNext()) {
                Uri next = it.next();
                C5109e c5109e = (C5109e) super.mo19484b((C5108d) next);
                if (c5109e != null) {
                    m19490c(next, c5109e);
                }
            }
        }
    }

    /* renamed from: c */
    private void m19490c(Uri uri, C5109e c5109e) {
        HashSet<Uri> hashSet = this.f18591e.get(Long.valueOf(c5109e.m19493b()));
        if (hashSet != null) {
            hashSet.remove(uri);
        }
    }
}
