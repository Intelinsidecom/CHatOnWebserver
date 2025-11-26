package com.sec.chaton.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.OperationApplicationException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import com.sec.chaton.p027e.C1404av;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class BaseContentProvider extends ContentProvider {

    /* renamed from: a */
    private static final String f7825a = BaseContentProvider.class.getSimpleName();

    /* renamed from: b */
    private final ThreadLocal<Boolean> f7826b = new ThreadLocal<>();

    protected BaseContentProvider() {
    }

    /* renamed from: a */
    protected boolean m8070a() {
        return (this.f7826b == null || this.f7826b.get() == null || !this.f7826b.get().booleanValue()) ? false : true;
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) {
        SQLiteDatabase writableDatabase = C1404av.m6253a(getContext()).getWritableDatabase();
        HashSet hashSet = new HashSet();
        writableDatabase.beginTransaction();
        int size = arrayList.size();
        try {
            try {
                this.f7826b.set(true);
                ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
                for (int i = 0; i < size; i++) {
                    contentProviderResultArr[i] = arrayList.get(i).apply(this, contentProviderResultArr, i);
                    hashSet.add(arrayList.get(i).getUri());
                }
                writableDatabase.setTransactionSuccessful();
                return contentProviderResultArr;
            } catch (SQLiteException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f7825a);
                }
                throw new OperationApplicationException(e);
            }
        } finally {
            this.f7826b.set(false);
            writableDatabase.endTransaction();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                getContext().getContentResolver().notifyChange((Uri) it.next(), null);
            }
        }
    }

    /* renamed from: a */
    public ContentProviderResult[] m8071a(ArrayList<ContentProviderOperation> arrayList, boolean z) {
        SQLiteDatabase writableDatabase = C1404av.m6253a(getContext()).getWritableDatabase();
        HashSet hashSet = new HashSet();
        writableDatabase.beginTransaction();
        int size = arrayList.size();
        try {
            try {
                this.f7826b.set(true);
                ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
                for (int i = 0; i < size; i++) {
                    contentProviderResultArr[i] = arrayList.get(i).apply(this, contentProviderResultArr, i);
                    hashSet.add(arrayList.get(i).getUri());
                }
                writableDatabase.setTransactionSuccessful();
                this.f7826b.set(false);
                writableDatabase.endTransaction();
                if (z) {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        getContext().getContentResolver().notifyChange((Uri) it.next(), null);
                    }
                }
                return contentProviderResultArr;
            } catch (SQLiteException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f7825a);
                }
                throw new OperationApplicationException(e);
            }
        } catch (Throwable th) {
            this.f7826b.set(false);
            writableDatabase.endTransaction();
            if (!z) {
                throw th;
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                getContext().getContentResolver().notifyChange((Uri) it2.next(), null);
            }
            throw th;
        }
    }
}
