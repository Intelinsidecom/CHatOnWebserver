package com.sec.chaton.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.OperationApplicationException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import com.sec.chaton.p017e.C0706u;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class BaseContentProvider extends ContentProvider {

    /* renamed from: a */
    private static final String f3963a = BaseContentProvider.class.getSimpleName();

    /* renamed from: b */
    private final ThreadLocal f3964b = new ThreadLocal();

    protected BaseContentProvider() {
    }

    /* renamed from: a */
    protected boolean m4094a() {
        return (this.f3964b == null || this.f3964b.get() == null || !((Boolean) this.f3964b.get()).booleanValue()) ? false : true;
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList arrayList) {
        SQLiteDatabase writableDatabase = C0706u.m3172a(getContext()).getWritableDatabase();
        HashSet hashSet = new HashSet();
        writableDatabase.beginTransaction();
        int size = arrayList.size();
        try {
            try {
                this.f3964b.set(true);
                ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
                for (int i = 0; i < size; i++) {
                    contentProviderResultArr[i] = ((ContentProviderOperation) arrayList.get(i)).apply(this, contentProviderResultArr, i);
                    hashSet.add(((ContentProviderOperation) arrayList.get(i)).getUri());
                }
                writableDatabase.setTransactionSuccessful();
                return contentProviderResultArr;
            } catch (SQLiteException e) {
                if (C1786r.f6455e) {
                    C1786r.m6056a(e, f3963a);
                }
                throw new OperationApplicationException(e);
            }
        } finally {
            this.f3964b.set(false);
            writableDatabase.endTransaction();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                getContext().getContentResolver().notifyChange((Uri) it.next(), null);
            }
        }
    }
}
