package com.sec.chaton.smsplugin.p102b;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.smsplugin.C3811d;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: RecipientIdCache.java */
/* renamed from: com.sec.chaton.smsplugin.b.n */
/* loaded from: classes.dex */
public class C3795n {

    /* renamed from: a */
    private static Uri f13615a = Uri.parse("content://mms-sms/canonical-addresses");

    /* renamed from: b */
    private static Uri f13616b = Uri.parse("content://mms-sms/canonical-address");

    /* renamed from: c */
    private static C3795n f13617c;

    /* renamed from: d */
    private final Map<Long, String> f13618d = new HashMap();

    /* renamed from: e */
    private final Context f13619e;

    /* renamed from: a */
    static C3795n m14378a() {
        return f13617c;
    }

    /* renamed from: a */
    static void m14383a(Context context) {
        f13617c = new C3795n(context);
        new Thread(new RunnableC3796o()).start();
    }

    C3795n(Context context) {
        this.f13619e = context;
    }

    /* renamed from: b */
    public static void m14384b() {
        C3811d.m14485a("[RecipientIdCache] fill: begin", new Object[0]);
        Context context = f13617c.f13619e;
        Cursor cursorQuery = SqliteWrapper.query(context, context.getContentResolver(), f13615a, (String[]) null, (String) null, (String[]) null, (String) null);
        if (cursorQuery == null) {
            C3890m.m14997c("Mms/cache", "null Cursor in fill()");
            return;
        }
        try {
            synchronized (f13617c) {
                f13617c.f13618d.clear();
                while (cursorQuery.moveToNext()) {
                    long j = cursorQuery.getLong(0);
                    f13617c.f13618d.put(Long.valueOf(j), cursorQuery.getString(1));
                }
            }
        } finally {
            cursorQuery.close();
        }
    }

    /* renamed from: a */
    public static List<C3798q> m14380a(String str) {
        ArrayList arrayList;
        synchronized (f13617c) {
            arrayList = new ArrayList();
            for (String str2 : str.split(" ")) {
                try {
                    long j = Long.parseLong(str2);
                    String str3 = f13617c.f13618d.get(Long.valueOf(j));
                    if (str3 == null) {
                        C3890m.m14997c("Mms/cache", "RecipientId " + j + " not in cache!");
                        if (C3890m.m15000f("Mms:threadcache", C3890m.f13993b)) {
                            m14385c();
                        }
                        m14384b();
                        str3 = f13617c.f13618d.get(Long.valueOf(j));
                    }
                    if (TextUtils.isEmpty(str3)) {
                        C3890m.m14997c("Mms/cache", "RecipientId " + j + " has empty number!");
                    } else {
                        arrayList.add(new C3798q(j, str3));
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m14381a(long j, C3789h c3789h) {
        boolean z;
        Iterator<C3782a> it = c3789h.iterator();
        while (it.hasNext()) {
            C3782a next = it.next();
            if (next.m14263e()) {
                next.m14259b(false);
                long jM14267i = next.m14267i();
                if (jM14267i != 0) {
                    String strM14262d = next.m14262d();
                    synchronized (f13617c) {
                        String str = f13617c.f13618d.get(Long.valueOf(jM14267i));
                        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
                            C3890m.m14996b("Mms/cache", "[RecipientIdCache] updateNumbers: contact=" + next + ", wasModified=true, recipientId=" + jM14267i);
                            C3890m.m14996b("Mms/cache", "   contact.getNumber=" + strM14262d + ", sInstance.mCache.get(recipientId)=" + str);
                        }
                        if (strM14262d.equalsIgnoreCase(str)) {
                            z = false;
                        } else {
                            f13617c.f13618d.put(Long.valueOf(jM14267i), strM14262d);
                            z = true;
                        }
                    }
                    if (z) {
                        f13617c.m14382a(jM14267i, strM14262d);
                    }
                } else {
                    continue;
                }
            }
        }
    }

    /* renamed from: a */
    private void m14382a(long j, String str) {
        C3890m.m14996b("Mms/cache", "[RecipientIdCache] updateCanonicalAddressInDb: id=" + j + ", number=" + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put("address", str);
        StringBuilder sb = new StringBuilder("_id");
        sb.append('=').append(j);
        new C3797p(this, "updateCanonicalAddressInDb", this.f13619e.getContentResolver(), ContentUris.withAppendedId(f13616b, j), contentValues, sb).start();
    }

    /* renamed from: c */
    public static void m14385c() {
        synchronized (f13617c) {
            C3890m.m14996b("Mms/cache", "*** Recipient ID cache dump ***");
            for (Long l : f13617c.f13618d.keySet()) {
                C3890m.m14996b("Mms/cache", l + ": " + f13617c.f13618d.get(l));
            }
        }
    }

    /* renamed from: a */
    public static String m14379a(Context context, String str) {
        Cursor cursorQuery = SqliteWrapper.query(context, context.getContentResolver(), ContentUris.withAppendedId(f13616b, Long.parseLong(str)), (String[]) null, (String) null, (String[]) null, (String) null);
        if (cursorQuery == null) {
            C3811d.m14486b("Mms/cache", "null Cursor looking up recipient: " + str);
        } else {
            try {
                string = cursorQuery.moveToFirst() ? cursorQuery.getString(0) : null;
            } finally {
                cursorQuery.close();
            }
        }
        return string;
    }
}
