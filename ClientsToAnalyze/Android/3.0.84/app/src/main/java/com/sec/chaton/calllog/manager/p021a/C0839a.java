package com.sec.chaton.calllog.manager.p021a;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.C1438f;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CallLogDbAdaptor.java */
/* renamed from: com.sec.chaton.calllog.manager.a.a */
/* loaded from: classes.dex */
public class C0839a {
    public C0839a() {
        m4438a();
    }

    protected void finalize() throws Throwable {
        m4442b();
        super.finalize();
    }

    /* renamed from: a */
    public void m4438a() {
    }

    /* renamed from: b */
    public void m4442b() {
    }

    /* renamed from: a */
    public synchronized int m4433a(ArrayList<ContentValues> arrayList) {
        int i;
        ContentProviderResult[] contentProviderResultArrApplyBatch;
        synchronized (this) {
            ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
            Iterator<ContentValues> it = arrayList.iterator();
            while (it.hasNext()) {
                ContentValues next = it.next();
                ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C1438f.f5365a);
                builderNewInsert.withValues(next);
                arrayList2.add(builderNewInsert.build());
            }
            try {
                if (arrayList2.size() <= 0) {
                    contentProviderResultArrApplyBatch = null;
                } else {
                    contentProviderResultArrApplyBatch = GlobalApplication.m11493l().getContentResolver().applyBatch("com.sec.chaton.provider.call", arrayList2);
                }
                if (contentProviderResultArrApplyBatch != null) {
                    i = 0;
                    for (ContentProviderResult contentProviderResult : contentProviderResultArrApplyBatch) {
                        if (C1438f.f5365a.equals(contentProviderResult.uri)) {
                            i++;
                        }
                    }
                } else {
                    i = 0;
                }
            } catch (Exception e) {
                C3250y.m11442a(e.getMessage(), getClass().getSimpleName());
                i = -1;
            }
        }
        return i;
    }

    /* renamed from: a */
    public synchronized int m4432a(ContentValues contentValues) {
        return GlobalApplication.m11493l().getContentResolver().delete(C1438f.f5365a, C0840b.m4449a(contentValues, null), null);
    }

    /* renamed from: a */
    public synchronized int m4434a(boolean z) {
        return GlobalApplication.m11493l().getContentResolver().delete(C1438f.m6293a(z), null, null);
    }

    /* renamed from: b */
    public Cursor m4440b(ContentValues contentValues) {
        return GlobalApplication.m11493l().getContentResolver().query(C1438f.m6296d(), null, C0840b.m4449a(contentValues, null), null, "_id DESC");
    }

    /* renamed from: b */
    public Cursor m4441b(ArrayList<Integer> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i == 0) {
                stringBuffer.append("_id=" + arrayList.get(i));
            } else {
                stringBuffer.append(" OR _id=" + arrayList.get(i));
            }
        }
        return GlobalApplication.m11493l().getContentResolver().query(C1438f.m6296d(), null, stringBuffer.toString(), null, "_id DESC");
    }

    /* renamed from: c */
    public Cursor m4443c() {
        return GlobalApplication.m11493l().getContentResolver().query(C1441i.m6318k(), null, null, null, null);
    }

    /* renamed from: d */
    public Cursor m4444d() {
        return GlobalApplication.m11493l().getContentResolver().query(C1438f.m6297e(), null, null, null, null);
    }

    /* renamed from: a */
    public Cursor m4437a(String str, int i) {
        return GlobalApplication.m11493l().getContentResolver().query(C1438f.f5365a, new String[]{"_id"}, "userid= ? AND groupcallkey= ?", new String[]{str, String.valueOf(i)}, null);
    }

    /* renamed from: e */
    public Cursor m4445e() {
        return GlobalApplication.m11493l().getContentResolver().query(C1438f.f5365a, new String[]{"COUNT(*)"}, "groupcallkey = ?", new String[]{"0"}, null);
    }

    /* renamed from: f */
    public Cursor m4446f() {
        return GlobalApplication.m11493l().getContentResolver().query(C1438f.f5365a, new String[]{"COUNT(DISTINCT groupcallkey)"}, null, null, null);
    }

    /* renamed from: a */
    public Cursor m4435a(int i) {
        String str;
        Uri uriM6296d = C1438f.f5365a;
        switch (i) {
            case 0:
                uriM6296d = C1438f.m6296d();
                str = "";
                break;
            case 1:
                uriM6296d = C1438f.m6296d();
                str = "callmethod = 6 OR callmethod = 10";
                break;
            case 2:
                uriM6296d = C1438f.m6296d();
                str = "callmethod = 7 OR callmethod = 11";
                break;
            case 3:
                uriM6296d = C1438f.m6296d();
                str = "callmethod = 6 OR callmethod = 7";
                break;
            case 4:
                uriM6296d = C1438f.m6296d();
                str = "callmethod = 10 OR callmethod = 11";
                break;
            case 5:
                uriM6296d = C1438f.m6298f();
                str = null;
                break;
            case 6:
                uriM6296d = C1438f.m6299g();
                str = null;
                break;
            case 7:
                uriM6296d = C1438f.m6300h();
                str = null;
                break;
            case 8:
                uriM6296d = C1438f.m6301i();
                str = null;
                break;
            case 9:
                uriM6296d = C1438f.m6296d();
                str = "callmethod=12";
                break;
            default:
                str = null;
                break;
        }
        return GlobalApplication.m11493l().getContentResolver().query(uriM6296d, null, str, null, "_id DESC");
    }

    /* renamed from: a */
    public Cursor m4436a(long j) {
        return GlobalApplication.m11493l().getContentResolver().query(C1438f.m6295c(), null, null, new String[]{Long.toString(j), Long.toString(j)}, null);
    }

    /* renamed from: g */
    public Cursor m4447g() {
        return GlobalApplication.m11493l().getContentResolver().query(C1438f.m6294b(), null, null, null, null);
    }

    /* renamed from: h */
    public Cursor m4448h() {
        return GlobalApplication.m11493l().getContentResolver().query(C1438f.m6292a(), null, null, null, null);
    }

    /* renamed from: b */
    public Cursor m4439b(int i) {
        return GlobalApplication.m11493l().getContentResolver().query(C1438f.f5365a, new String[]{"_id"}, "groupcallkey= ?", new String[]{Integer.toString(i)}, null);
    }
}
