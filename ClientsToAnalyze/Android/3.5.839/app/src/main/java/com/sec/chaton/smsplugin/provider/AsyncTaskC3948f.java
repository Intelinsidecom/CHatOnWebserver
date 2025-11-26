package com.sec.chaton.smsplugin.provider;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.Telephony;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.smsplugin.p111h.C3896s;
import com.sec.common.CommonApplication;
import com.sec.google.android.p134a.p136b.C5108d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: DeleteInboxExceptLockedTask.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.provider.f */
/* loaded from: classes.dex */
public class AsyncTaskC3948f extends AsyncTask<Long, Integer, Integer> {

    /* renamed from: a */
    private static final String f14229a = AsyncTaskC3948f.class.getSimpleName();

    /* renamed from: a */
    private String m15266a(Collection<Long> collection) {
        StringBuilder sb = new StringBuilder();
        String str = "";
        Iterator<Long> it = collection.iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                Long next = it.next();
                sb.append(str2);
                sb.append("'");
                sb.append(next);
                sb.append("'");
                str = ", ";
            } else {
                return sb.toString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Long... lArr) {
        int iDelete;
        ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
        if (lArr.length < 1) {
            C3896s.m15041a("Invalid parameter", f14229a);
            return 0;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(lArr));
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Uri uriWithAppendedId = ContentUris.withAppendedId(Telephony.Threads.CONTENT_URI, ((Long) arrayList.get(i)).longValue());
            C5108d.m19487b().mo19484b(uriWithAppendedId);
            contentResolver.delete(uriWithAppendedId, "locked=0", null);
        }
        String str = "_id IN (" + m15266a(arrayList) + ")";
        C3896s.m15044b("Delete candidates " + str, f14229a);
        Cursor cursorQuery = contentResolver.query(Telephony.Threads.CONTENT_URI.buildUpon().appendQueryParameter("simple", "true").build(), new String[]{"_id"}, str, null, null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.remove(Long.valueOf(cursorQuery.getLong(0)));
                } finally {
                    cursorQuery.close();
                }
            }
        }
        if (arrayList.size() > 0) {
            String str2 = "inbox_no IN (" + m15266a(arrayList) + ")";
            C3896s.m15044b("Delete these inbox " + str2, f14229a);
            iDelete = contentResolver.delete(C2299s.f8209a, str2, null);
            C3896s.m15044b("Delete " + iDelete + " rows", f14229a);
        } else {
            iDelete = 0;
        }
        contentResolver.notifyChange(C2299s.f8209a, null);
        return Integer.valueOf(iDelete);
    }
}
