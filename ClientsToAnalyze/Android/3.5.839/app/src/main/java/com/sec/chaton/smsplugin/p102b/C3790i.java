package com.sec.chaton.smsplugin.p102b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3811d;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3887j;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.common.CommonApplication;
import com.sec.google.android.p134a.p136b.C5108d;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: Conversation.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.b.i */
/* loaded from: classes.dex */
public class C3790i {

    /* renamed from: s */
    private static ContentValues f13594s;

    /* renamed from: t */
    private static boolean f13595t;

    /* renamed from: h */
    private final Context f13596h;

    /* renamed from: i */
    private long f13597i;

    /* renamed from: j */
    private C3789h f13598j;

    /* renamed from: k */
    private long f13599k;

    /* renamed from: l */
    private int f13600l;

    /* renamed from: m */
    private int f13601m;

    /* renamed from: n */
    private String f13602n;

    /* renamed from: o */
    private boolean f13603o;

    /* renamed from: p */
    private boolean f13604p;

    /* renamed from: q */
    private boolean f13605q;

    /* renamed from: r */
    private boolean f13606r;

    /* renamed from: u */
    private boolean f13607u;

    /* renamed from: v */
    private final Object f13608v;

    /* renamed from: b */
    private static final Uri f13588b = Telephony.Threads.CONTENT_URI.buildUpon().appendQueryParameter("simple", "true").build();

    /* renamed from: c */
    private static final String[] f13589c = {"_id", "date", "message_count", "recipient_ids", "snippet", "snippet_cs", "read", "error", "has_attachment", "-1"};

    /* renamed from: d */
    private static final String[] f13590d = {"_id", "date", "message_count", "recipient_ids", "snippet", "snippet_cs", "read", "error", "has_attachment", "unread_count"};

    /* renamed from: e */
    private static final String[] f13591e = {"_id", "read"};

    /* renamed from: f */
    private static final String[] f13592f = {"sum(unread_count)"};

    /* renamed from: g */
    private static final String[] f13593g = {"seen"};

    /* renamed from: a */
    static final String[] f13587a = {"_id", "thread_id", "address", "body", "date", "read", "type", "status", "locked", VKApiConst.ERROR_CODE};

    private C3790i(Context context) {
        this.f13608v = new Object();
        this.f13596h = context;
        this.f13598j = new C3789h();
        this.f13597i = 0L;
    }

    private C3790i(Context context, long j, boolean z) {
        this.f13608v = new Object();
        this.f13596h = context;
        if (!m14331a(j, z)) {
            this.f13598j = new C3789h();
            this.f13597i = 0L;
        }
    }

    private C3790i(Context context, Cursor cursor, boolean z) {
        this.f13608v = new Object();
        this.f13596h = context;
        m14329a(context, this, cursor, z);
    }

    /* renamed from: a */
    public static C3790i m14316a(Context context) {
        return new C3790i(context);
    }

    /* renamed from: a */
    public static C3790i m14317a(Context context, long j, boolean z) {
        C3790i c3790iM14370a = C3794m.m14370a(j);
        if (c3790iM14370a == null) {
            c3790iM14370a = new C3790i(context, j, z);
            try {
                C3794m.m14373a(c3790iM14370a);
            } catch (IllegalStateException e) {
                C3811d.m14487c("Tried to add duplicate Conversation to Cache (from threadId): " + c3790iM14370a, new Object[0]);
                if (!C3794m.m14377b(c3790iM14370a)) {
                    C3811d.m14487c("get by threadId cache.replace failed on " + c3790iM14370a, new Object[0]);
                }
            }
        }
        return c3790iM14370a;
    }

    /* renamed from: a */
    public static C3790i m14320a(Context context, C3789h c3789h, boolean z) {
        if (c3789h.size() < 1) {
            return m14316a(context);
        }
        long jM14314a = m14314a(context, c3789h);
        C3790i c3790iM14371a = C3794m.m14371a(c3789h);
        if (c3790iM14371a != null && c3790iM14371a.m14359d() == jM14314a) {
            C3890m.m14996b("Mms/conv", "Conversation.get: get conversation from cache");
            return c3790iM14371a;
        }
        C3790i c3790i = new C3790i(context, jM14314a, z);
        C3890m.m14996b("Mms/conv", "Conversation.get: created new conversation xxxxxxx");
        if (!c3790i.m14362g().equals(c3789h)) {
            C3811d.m14487c("Mms/conv", "Conversation.get: new conv's recipients don't match input recpients xxxxxxx");
        }
        try {
            C3794m.m14373a(c3790i);
            return c3790i;
        } catch (IllegalStateException e) {
            C3811d.m14487c("Tried to add duplicate Conversation to Cache (from recipients): " + c3790i, new Object[0]);
            if (!C3794m.m14377b(c3790i)) {
                C3811d.m14487c("get by recipients cache.replace failed on " + c3790i, new Object[0]);
                return c3790i;
            }
            return c3790i;
        }
    }

    /* renamed from: a */
    public static C3790i m14319a(Context context, Uri uri, boolean z) {
        if (uri == null) {
            return m14316a(context);
        }
        if (uri.getPathSegments().size() >= 2) {
            try {
                return m14317a(context, Long.parseLong(uri.getPathSegments().get(1)), z);
            } catch (NumberFormatException e) {
                C3811d.m14487c("Invalid URI: " + uri, new Object[0]);
            }
        }
        return m14320a(context, C3789h.m14304a(m14323a(uri), z, true), z);
    }

    /* renamed from: a */
    public boolean m14354a() {
        return this.f13597i > 0;
    }

    /* renamed from: a */
    public static C3790i m14318a(Context context, Cursor cursor) {
        C3790i c3790i;
        long j = cursor.getLong(0);
        if (j > 0 && (c3790i = C3794m.m14370a(j)) != null) {
            m14329a(context, c3790i, cursor, false);
        } else {
            c3790i = new C3790i(context, cursor, false);
            try {
                C3794m.m14373a(c3790i);
            } catch (IllegalStateException e) {
                C3811d.m14487c("Mms/conv", "Tried to add duplicate Conversation to Cache (from cursor): " + c3790i);
                if (!C3794m.m14377b(c3790i)) {
                    C3811d.m14487c("Converations.from cache.replace failed on " + c3790i, new Object[0]);
                }
            }
        }
        return c3790i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m14350s() {
        if (f13594s == null) {
            f13594s = new ContentValues(2);
            f13594s.put("read", (Integer) 1);
            f13594s.put("seen", (Integer) 1);
        }
    }

    /* renamed from: b */
    public void m14355b() {
        new Thread(new RunnableC3791j(this, m14357c())).start();
    }

    /* renamed from: a */
    public void m14353a(boolean z) {
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3811d.m14485a("blockMarkAsRead: " + z, new Object[0]);
        }
        synchronized (this.f13608v) {
            if (z != this.f13607u) {
                this.f13607u = z;
                if (!this.f13607u) {
                    this.f13608v.notifyAll();
                }
            }
        }
    }

    /* renamed from: c */
    public synchronized Uri m14357c() {
        return this.f13597i <= 0 ? null : ContentUris.withAppendedId(Telephony.Threads.CONTENT_URI, this.f13597i);
    }

    @Deprecated
    /* renamed from: a */
    public static Uri m14315a(long j) {
        return ContentUris.withAppendedId(Telephony.Threads.CONTENT_URI, j);
    }

    /* renamed from: d */
    public synchronized long m14359d() {
        return this.f13597i;
    }

    /* renamed from: e */
    public synchronized long m14360e() {
        if (this.f13597i <= 0) {
            this.f13597i = m14314a(this.f13596h, this.f13598j);
        }
        return this.f13597i;
    }

    /* renamed from: f */
    public synchronized void m14361f() {
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3811d.m14485a("clearThreadId old threadId was: " + this.f13597i + " now zero", new Object[0]);
        }
        C3794m.m14376b(this.f13597i);
        this.f13597i = 0L;
    }

    /* renamed from: a */
    public synchronized void m14352a(C3789h c3789h) {
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3890m.m14996b("Mms/conv", "setRecipients before: " + toString());
        }
        this.f13598j = c3789h;
        this.f13597i = 0L;
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3890m.m14996b("Mms/conv", "setRecipients after: " + toString());
        }
    }

    /* renamed from: g */
    public synchronized C3789h m14362g() {
        return this.f13598j;
    }

    /* renamed from: h */
    public synchronized boolean m14363h() {
        return this.f13597i <= 0 ? false : C3887j.m14982c().m14988a(this.f13597i);
    }

    /* renamed from: b */
    public synchronized void m14356b(boolean z) {
        if (this.f13597i > 0) {
            if (C3887j.m14982c() == null) {
                C3887j.m14979a(CommonApplication.m18732r());
            }
            C3887j.m14982c().m14985a(this.f13597i, z);
        }
    }

    /* renamed from: i */
    public synchronized long m14364i() {
        return this.f13599k;
    }

    /* renamed from: j */
    public synchronized int m14365j() {
        return this.f13600l;
    }

    /* renamed from: a */
    public synchronized void m14351a(int i) {
        this.f13600l = i;
    }

    /* renamed from: k */
    public synchronized int m14366k() {
        return this.f13601m;
    }

    /* renamed from: l */
    public synchronized String m14367l() {
        return this.f13602n;
    }

    /* renamed from: m */
    public boolean m14368m() {
        boolean z;
        synchronized (this) {
            z = this.f13603o;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m14339d(boolean z) {
        synchronized (this) {
            this.f13603o = z;
        }
    }

    /* renamed from: n */
    public synchronized boolean m14369n() {
        return this.f13606r;
    }

    /* renamed from: c */
    public synchronized void m14358c(boolean z) {
        this.f13606r = z;
    }

    /* renamed from: a */
    private static long m14314a(Context context, C3789h c3789h) {
        HashSet hashSet = new HashSet();
        Iterator<C3782a> it = c3789h.iterator();
        while (it.hasNext()) {
            C3782a next = it.next();
            C3782a c3782aM14204a = C3782a.m14204a(next.m14262d(), false);
            if (c3782aM14204a != null) {
                hashSet.add(c3782aM14204a.m14262d());
            } else {
                hashSet.add(next.m14262d());
            }
        }
        long orCreateThreadId = Telephony.Threads.getOrCreateThreadId(context, hashSet);
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3811d.m14485a("[Conversation] getOrCreateThreadId for (%s) returned %d", hashSet, Long.valueOf(orCreateThreadId));
        }
        return orCreateThreadId;
    }

    public synchronized boolean equals(Object obj) {
        boolean zEquals = false;
        synchronized (this) {
            if (obj != null) {
                try {
                    zEquals = this.f13598j.equals(((C3790i) obj).f13598j);
                } catch (ClassCastException e) {
                }
            }
        }
        return zEquals;
    }

    public synchronized int hashCode() {
        return this.f13598j.hashCode();
    }

    public synchronized String toString() {
        return String.format("[%s] (tid %d)", this.f13598j.m14308a(), Long.valueOf(this.f13597i));
    }

    /* renamed from: a */
    public static void m14324a(AsyncQueryHandler asyncQueryHandler, int i) {
        asyncQueryHandler.startDelete(i, null, Telephony.Threads.OBSOLETE_THREADS_URI, null, null);
    }

    /* renamed from: b */
    public static void m14332b(AsyncQueryHandler asyncQueryHandler, int i) {
        asyncQueryHandler.cancelOperation(i);
        m14325a(asyncQueryHandler, i, (String) null);
    }

    /* renamed from: a */
    public static void m14325a(AsyncQueryHandler asyncQueryHandler, int i, String str) {
        asyncQueryHandler.cancelOperation(i);
        asyncQueryHandler.startQuery(i, null, f13588b, C3847e.m14628L() ? f13590d : f13589c, str, null, "date DESC");
    }

    /* renamed from: a */
    public static void m14327a(AsyncQueryHandler asyncQueryHandler, int i, boolean z, long j) {
        Uri uriWithAppendedId = ContentUris.withAppendedId(Telephony.Threads.CONTENT_URI, j);
        String str = z ? null : "locked=0";
        C5108d.m19487b().mo19484b(uriWithAppendedId);
        asyncQueryHandler.startDelete(i, Long.valueOf(j), uriWithAppendedId, str, null);
    }

    /* renamed from: a */
    public static void m14326a(AsyncQueryHandler asyncQueryHandler, int i, boolean z) {
        String str = z ? null : "locked=0";
        C5108d.m19487b().mo19484b(Telephony.Threads.CONTENT_URI);
        asyncQueryHandler.startDelete(i, null, Telephony.Threads.CONTENT_URI, str, null);
    }

    /* renamed from: a */
    public static void m14328a(AsyncQueryHandler asyncQueryHandler, Collection<Long> collection, int i) {
        String string;
        asyncQueryHandler.cancelOperation(i);
        Uri uri = Telephony.MmsSms.CONTENT_LOCKED_URI;
        if (collection != null) {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            Iterator<Long> it = collection.iterator();
            while (true) {
                int i3 = i2;
                if (!it.hasNext()) {
                    break;
                }
                long jLongValue = it.next().longValue();
                i2 = i3 + 1;
                if (i3 > 0) {
                    sb.append(" OR ");
                }
                sb.append("thread_id").append("=").append(Long.toString(jLongValue));
            }
            string = sb.toString();
        } else {
            string = null;
        }
        asyncQueryHandler.startQuery(i, collection, uri, C3847e.m14628L() ? f13590d : f13589c, string, null, "date DESC");
    }

    /* renamed from: a */
    private static void m14329a(Context context, C3790i c3790i, Cursor cursor, boolean z) {
        synchronized (c3790i) {
            c3790i.f13597i = cursor.getLong(0);
            c3790i.f13599k = cursor.getLong(1);
            c3790i.f13600l = cursor.getInt(2);
            c3790i.f13601m = cursor.getInt(9);
            String strM16395a = C4149cd.m16395a(cursor, 4, 5);
            if (TextUtils.isEmpty(strM16395a) || strM16395a.equals(context.getString(R.string.no_subject_view))) {
                strM16395a = context.getString(R.string.pref_mms_settings_title);
            }
            c3790i.f13602n = strM16395a;
            c3790i.m14339d(cursor.getInt(6) == 0);
            c3790i.f13605q = cursor.getInt(7) != 0;
            c3790i.f13604p = cursor.getInt(8) != 0;
        }
        C3789h c3789hM14303a = C3789h.m14303a(cursor.getString(3), z);
        synchronized (c3790i) {
            c3790i.f13598j = c3789hM14303a;
        }
    }

    /* renamed from: b */
    public static void m14333b(Context context) {
        new Thread(new RunnableC3792k(context)).start();
    }

    /* renamed from: c */
    public static void m14335c(Context context) {
        new Thread(new RunnableC3793l(context)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static void m14343g(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = contentResolver.query(Telephony.Sms.Inbox.CONTENT_URI, f13593g, "seen=0", null, null);
        int count = 0;
        if (cursorQuery != null) {
            try {
                count = cursorQuery.getCount();
            } finally {
                cursorQuery.close();
            }
        }
        if (count != 0) {
            if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
                C3890m.m14996b("Mms/conv", "mark " + count + " SMS msgs as seen");
            }
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("seen", (Integer) 1);
            contentResolver.update(Telephony.Sms.Inbox.CONTENT_URI, contentValues, "seen=0", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static void m14344h(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = contentResolver.query(Telephony.Mms.Inbox.CONTENT_URI, f13593g, "seen=0", null, null);
        int count = 0;
        if (cursorQuery != null) {
            try {
                count = cursorQuery.getCount();
            } finally {
                cursorQuery.close();
            }
        }
        if (count != 0) {
            if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
                C3890m.m14996b("Mms/conv", "mark " + count + " MMS msgs as seen");
            }
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("seen", (Integer) 1);
            contentResolver.update(Telephony.Mms.Inbox.CONTENT_URI, contentValues, "seen=0", null);
        }
    }

    /* renamed from: o */
    public static boolean m14346o() {
        boolean z;
        synchronized (C3794m.m14372a()) {
            z = f13595t;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static void m14345i(Context context) {
        C3790i c3790iM14370a;
        synchronized (C3794m.m14372a()) {
            if (!f13595t) {
                f13595t = true;
                HashSet hashSet = new HashSet();
                Cursor cursorQuery = context.getContentResolver().query(f13588b, C3847e.m14628L() ? f13590d : f13589c, null, null, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        try {
                            long j = cursorQuery.getLong(0);
                            hashSet.add(Long.valueOf(j));
                            synchronized (C3794m.m14372a()) {
                                c3790iM14370a = C3794m.m14370a(j);
                            }
                            if (c3790iM14370a == null) {
                                C3790i c3790i = new C3790i(context, cursorQuery, true);
                                try {
                                    synchronized (C3794m.m14372a()) {
                                        C3794m.m14373a(c3790i);
                                    }
                                } catch (IllegalStateException e) {
                                    C3811d.m14487c("Tried to add duplicate Conversation to Cache for threadId: " + j + " new conv: " + c3790i, new Object[0]);
                                    if (!C3794m.m14377b(c3790i)) {
                                        C3811d.m14487c("cacheAllThreads cache.replace failed on " + c3790i, new Object[0]);
                                    }
                                }
                            } else {
                                m14329a(context, c3790iM14370a, cursorQuery, true);
                            }
                        } finally {
                            cursorQuery.close();
                        }
                    }
                }
                synchronized (C3794m.m14372a()) {
                    f13595t = false;
                }
                C3794m.m14374a(hashSet);
            }
        }
    }

    /* renamed from: a */
    private boolean m14331a(long j, boolean z) {
        Cursor cursorQuery = this.f13596h.getContentResolver().query(f13588b, C3847e.m14628L() ? f13590d : f13589c, "_id=" + Long.toString(j), null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    m14329a(this.f13596h, this, cursorQuery, z);
                    if (j != this.f13597i) {
                        C3811d.m14487c("loadFromThreadId: fillFromCursor returned differnt thread_id! threadId=" + j + ", mThreadId=" + this.f13597i, new Object[0]);
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return true;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        C3811d.m14487c("loadFromThreadId: Can't find thread ID " + j, new Object[0]);
        return false;
    }

    /* renamed from: a */
    public static String m14323a(Uri uri) {
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        int iIndexOf = schemeSpecificPart.indexOf(63);
        return iIndexOf == -1 ? schemeSpecificPart : schemeSpecificPart.substring(0, iIndexOf);
    }

    /* renamed from: p */
    public static void m14347p() {
        C3794m.m14375b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static String m14322a(Context context, long j, String str) {
        if (j <= 0) {
            C3811d.m14487c("verifySingleRecipient threadId is ZERO, recipient: " + str, new Object[0]);
            C3811d.m14483a(context);
        } else {
            Cursor cursorQuery = context.getContentResolver().query(f13588b, C3847e.m14628L() ? f13590d : f13589c, "_id=" + Long.toString(j), null, null);
            if (cursorQuery == null) {
                C3811d.m14487c("verifySingleRecipient threadId: " + j + " resulted in NULL cursor , recipient: " + str, new Object[0]);
                C3811d.m14483a(context);
            } else {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        C3811d.m14487c("verifySingleRecipient threadId: " + j + " can't moveToFirst , recipient: " + str, new Object[0]);
                        C3811d.m14483a(context);
                    } else {
                        String string = cursorQuery.getString(3);
                        cursorQuery.close();
                        String[] strArrSplit = string.split(" ");
                        int length = strArrSplit.length;
                        cursorQuery = length;
                        if (length == 1) {
                            String strM14379a = C3795n.m14379a(context, strArrSplit[0]);
                            if (TextUtils.isEmpty(strM14379a)) {
                                Object[] objArr = new Object[0];
                                C3811d.m14487c("verifySingleRecipient threadId: " + j + " getSingleNumberFromCanonicalAddresses returned empty number for: " + strArrSplit[0] + " recipientIds: " + string, objArr);
                                C3811d.m14483a(context);
                                cursorQuery = objArr;
                            } else {
                                boolean zCompareLoosely = PhoneNumberUtils.compareLoosely(str, strM14379a);
                                cursorQuery = strM14379a;
                                if (!zCompareLoosely) {
                                    if (context instanceof Activity) {
                                        C3811d.m14484a("verifySingleRecipient for threadId: " + j + " original recipient: " + str + " recipient from DB: " + strM14379a, (Activity) context);
                                    }
                                    C3811d.m14483a(context);
                                    str = strM14379a;
                                    cursorQuery = strM14379a;
                                }
                            }
                        }
                    }
                } finally {
                    cursorQuery.close();
                }
            }
        }
        return str;
    }
}
