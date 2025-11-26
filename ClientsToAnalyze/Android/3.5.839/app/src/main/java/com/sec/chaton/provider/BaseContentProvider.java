package com.sec.chaton.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.OperationApplicationException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import com.sec.chaton.p057e.C2268bn;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class BaseContentProvider extends ContentProvider {

    /* renamed from: a */
    private static final String f11228a = BaseContentProvider.class.getSimpleName();

    /* renamed from: b */
    private final ThreadLocal<Boolean> f11229b = new ThreadLocal<>();

    protected BaseContentProvider() {
    }

    /* renamed from: a */
    protected boolean m12391a() {
        return (this.f11229b == null || this.f11229b.get() == null || !this.f11229b.get().booleanValue()) ? false : true;
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) {
        SQLiteDatabase writableDatabase = C2268bn.m10126a(getContext()).getWritableDatabase();
        HashSet hashSet = new HashSet();
        if (!writableDatabase.isOpen() && C4904y.f17872b) {
            C4904y.m18639b("applyBatch db is not opened ... fault case", f11228a);
        }
        if (writableDatabase.inTransaction() && C4904y.f17872b) {
            C4904y.m18639b("applyBatch db there are pendding transaction ... fault case", f11228a);
        }
        int size = arrayList.size();
        ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
        try {
            try {
                try {
                    try {
                        writableDatabase.beginTransaction();
                        this.f11229b.set(true);
                        for (int i = 0; i < size; i++) {
                            contentProviderResultArr[i] = arrayList.get(i).apply(this, contentProviderResultArr, i);
                            hashSet.add(arrayList.get(i).getUri());
                        }
                        writableDatabase.setTransactionSuccessful();
                        this.f11229b.set(false);
                        writableDatabase.endTransaction();
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            getContext().getContentResolver().notifyChange((Uri) it.next(), null);
                        }
                        return contentProviderResultArr;
                    } catch (SQLiteConstraintException e) {
                        if (C4904y.f17872b) {
                            C4904y.m18634a("applyBatch SQLiteConstraintException :: " + e.getStackTrace(), f11228a);
                        }
                        return contentProviderResultArr;
                    } catch (Exception e2) {
                        if (C4904y.f17872b) {
                            C4904y.m18634a("applyBatch Exception :: " + e2.getStackTrace(), f11228a);
                        }
                        return contentProviderResultArr;
                    }
                } catch (SQLiteFullException e3) {
                    if (C4904y.f17872b) {
                        C4904y.m18634a("applyBatch SQLiteFullException :: " + e3.getStackTrace(), f11228a);
                    }
                    return contentProviderResultArr;
                } catch (SQLiteException e4) {
                    if (C4904y.f17872b) {
                        C4904y.m18634a("applyBatch SQLiteException :: " + e4.getStackTrace(), f11228a);
                    }
                    throw new OperationApplicationException(e4);
                }
            } catch (SQLiteDiskIOException e5) {
                if (C4904y.f17872b) {
                    C4904y.m18634a("applyBatch SQLiteDiskIOException :: " + e5.getStackTrace(), f11228a);
                }
                return contentProviderResultArr;
            } catch (IllegalStateException e6) {
                if (C4904y.f17872b) {
                    C4904y.m18634a("applyBatch IllegalStateException :: " + e6.getStackTrace(), f11228a);
                }
                return contentProviderResultArr;
            }
        } catch (Throwable th) {
            return contentProviderResultArr;
        }
    }

    /* renamed from: a */
    public ContentProviderResult[] m12392a(ArrayList<ContentProviderOperation> arrayList, boolean z) {
        SQLiteDatabase writableDatabase = C2268bn.m10126a(getContext()).getWritableDatabase();
        HashSet hashSet = new HashSet();
        if (!writableDatabase.isOpen() && C4904y.f17872b) {
            C4904y.m18639b("applyBatch db is not opened ... fault case", f11228a);
        }
        if (writableDatabase.inTransaction() && C4904y.f17872b) {
            C4904y.m18639b("applyBatch db there are pendding transaction ... fault case", f11228a);
        }
        int size = arrayList.size();
        ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
        try {
            try {
                try {
                    try {
                        writableDatabase.beginTransaction();
                        this.f11229b.set(true);
                        for (int i = 0; i < size; i++) {
                            contentProviderResultArr[i] = arrayList.get(i).apply(this, contentProviderResultArr, i);
                            hashSet.add(arrayList.get(i).getUri());
                        }
                        writableDatabase.setTransactionSuccessful();
                        this.f11229b.set(false);
                        writableDatabase.endTransaction();
                        if (z) {
                            Iterator it = hashSet.iterator();
                            while (it.hasNext()) {
                                getContext().getContentResolver().notifyChange((Uri) it.next(), null);
                            }
                        }
                        return contentProviderResultArr;
                    } catch (SQLiteConstraintException e) {
                        if (C4904y.f17872b) {
                            C4904y.m18634a("applyBatch SQLiteConstraintException :: " + e.getStackTrace(), f11228a);
                        }
                        return contentProviderResultArr;
                    } catch (Exception e2) {
                        if (C4904y.f17872b) {
                            C4904y.m18634a("applyBatch Exception :: " + e2.getStackTrace(), f11228a);
                        }
                        return contentProviderResultArr;
                    }
                } catch (SQLiteFullException e3) {
                    if (C4904y.f17872b) {
                        C4904y.m18634a("applyBatch SQLiteFullException :: " + e3.getStackTrace(), f11228a);
                    }
                    return contentProviderResultArr;
                } catch (SQLiteException e4) {
                    if (C4904y.f17872b) {
                        C4904y.m18634a("applyBatch SQLiteException :: " + e4.getStackTrace(), f11228a);
                    }
                    throw new OperationApplicationException(e4);
                }
            } catch (SQLiteDiskIOException e5) {
                if (C4904y.f17872b) {
                    C4904y.m18634a("applyBatch SQLiteDiskIOException :: " + e5.getStackTrace(), f11228a);
                }
                return contentProviderResultArr;
            } catch (IllegalStateException e6) {
                if (C4904y.f17872b) {
                    C4904y.m18634a("applyBatch IllegalStateException :: " + e6.getStackTrace(), f11228a);
                }
                return contentProviderResultArr;
            }
        } catch (Throwable th) {
            return contentProviderResultArr;
        }
    }
}
