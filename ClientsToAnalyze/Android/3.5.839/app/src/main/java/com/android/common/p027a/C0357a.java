package com.android.common.p027a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: DataUsageStatUpdater.java */
/* renamed from: com.android.common.a.a */
/* loaded from: classes.dex */
public class C0357a {

    /* renamed from: a */
    private static final String f862a = C0357a.class.getSimpleName();

    /* renamed from: b */
    private final ContentResolver f863b;

    public C0357a(Context context) {
        this.f863b = context.getContentResolver();
    }

    /* renamed from: a */
    public boolean m1253a(Collection<String> collection) {
        if (Log.isLoggable(f862a, 3)) {
            Log.d(f862a, "updateWithPhoneNumber: " + Arrays.toString(collection.toArray()));
        }
        if (collection != null && !collection.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            String[] strArr = new String[collection.size()];
            arrayList.addAll(collection);
            Arrays.fill(strArr, "?");
            sb.append("data1 IN (").append(TextUtils.join(",", strArr)).append(")");
            Cursor cursorQuery = this.f863b.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"contact_id", "_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null);
            if (cursorQuery == null) {
                Log.w(f862a, "Cursor for Phone.CONTENT_URI became null.");
            } else {
                HashSet hashSet = new HashSet(cursorQuery.getCount());
                HashSet hashSet2 = new HashSet(cursorQuery.getCount());
                try {
                    cursorQuery.move(-1);
                    while (cursorQuery.moveToNext()) {
                        hashSet.add(Long.valueOf(cursorQuery.getLong(0)));
                        hashSet2.add(Long.valueOf(cursorQuery.getLong(1)));
                    }
                    cursorQuery.close();
                    return m1252a(hashSet, hashSet2, "short_text");
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m1252a(Collection<Long> collection, Collection<Long> collection2, String str) {
        boolean z;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT >= 14) {
            if (collection2.isEmpty()) {
                if (!Log.isLoggable(f862a, 3)) {
                    return false;
                }
                Log.d(f862a, "Given list for data IDs is null. Ignoring.");
                return false;
            }
            if (this.f863b.update(C0358b.f864a.buildUpon().appendPath(TextUtils.join(",", collection2)).appendQueryParameter("type", str).build(), new ContentValues(), null, null) > 0) {
                z = true;
            } else {
                if (Log.isLoggable(f862a, 3)) {
                    Log.d(f862a, "update toward data rows " + collection2 + " failed");
                }
                z = false;
            }
            return z;
        }
        if (collection.isEmpty()) {
            if (!Log.isLoggable(f862a, 3)) {
                return false;
            }
            Log.d(f862a, "Given list for contact IDs is null. Ignoring.");
            return false;
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        String[] strArr = new String[collection.size()];
        Iterator<Long> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().longValue()));
        }
        Arrays.fill(strArr, "?");
        sb.append("_id IN (").append(TextUtils.join(",", strArr)).append(")");
        if (Log.isLoggable(f862a, 3)) {
            Log.d(f862a, "contactId where: " + sb.toString());
            Log.d(f862a, "contactId selection: " + arrayList);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("last_time_contacted", Long.valueOf(jCurrentTimeMillis));
        if (this.f863b.update(ContactsContract.Contacts.CONTENT_URI, contentValues, sb.toString(), (String[]) arrayList.toArray(new String[0])) > 0) {
            return true;
        }
        if (!Log.isLoggable(f862a, 3)) {
            return false;
        }
        Log.d(f862a, "update toward raw contacts " + collection + " failed");
        return false;
    }
}
