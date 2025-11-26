package com.sec.chaton.calllog.manager.p052a;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.C2286f;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CallLogDbAdaptor.java */
/* renamed from: com.sec.chaton.calllog.manager.a.a */
/* loaded from: classes.dex */
public class C1450a {
    public C1450a() {
        m7592a();
    }

    protected void finalize() throws Throwable {
        m7596b();
        super.finalize();
    }

    /* renamed from: a */
    public void m7592a() {
    }

    /* renamed from: b */
    public void m7596b() {
    }

    /* renamed from: a */
    public synchronized int m7587a(ArrayList<ContentValues> arrayList) {
        int i;
        ContentProviderResult[] contentProviderResultArrApplyBatch;
        synchronized (this) {
            ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
            Iterator<ContentValues> it = arrayList.iterator();
            while (it.hasNext()) {
                ContentValues next = it.next();
                ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2286f.f8192a);
                builderNewInsert.withValues(next);
                arrayList2.add(builderNewInsert.build());
            }
            try {
                if (arrayList2.size() <= 0) {
                    contentProviderResultArrApplyBatch = null;
                } else {
                    contentProviderResultArrApplyBatch = GlobalApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider.call", arrayList2);
                }
                if (contentProviderResultArrApplyBatch != null) {
                    i = 0;
                    for (ContentProviderResult contentProviderResult : contentProviderResultArrApplyBatch) {
                        if (C2286f.f8192a.equals(contentProviderResult.uri)) {
                            i++;
                        }
                    }
                } else {
                    i = 0;
                }
            } catch (Exception e) {
                C4904y.m18634a(e.getMessage(), getClass().getSimpleName());
                i = -1;
            }
        }
        return i;
    }

    /* renamed from: a */
    public synchronized int m7586a(ContentValues contentValues) {
        return GlobalApplication.m18732r().getContentResolver().delete(C2286f.f8192a, C1451b.m7603a(contentValues, null), null);
    }

    /* renamed from: a */
    public synchronized int m7588a(boolean z) {
        return GlobalApplication.m18732r().getContentResolver().delete(C2286f.m10149a(z), null, null);
    }

    /* renamed from: b */
    public Cursor m7594b(ContentValues contentValues) {
        return GlobalApplication.m18732r().getContentResolver().query(C2286f.m10152d(), null, C1451b.m7603a(contentValues, null), null, "_id DESC");
    }

    /* renamed from: b */
    public Cursor m7595b(ArrayList<Integer> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i == 0) {
                stringBuffer.append("_id=" + arrayList.get(i));
            } else {
                stringBuffer.append(" OR _id=" + arrayList.get(i));
            }
        }
        return GlobalApplication.m18732r().getContentResolver().query(C2286f.m10152d(), null, stringBuffer.toString(), null, "_id DESC");
    }

    /* renamed from: c */
    public Cursor m7597c() {
        return GlobalApplication.m18732r().getContentResolver().query(C2289i.m10174l(), null, null, null, null);
    }

    /* renamed from: d */
    public Cursor m7598d() {
        return GlobalApplication.m18732r().getContentResolver().query(C2286f.m10153e(), null, null, null, null);
    }

    /* renamed from: a */
    public Cursor m7591a(String str, int i) {
        return GlobalApplication.m18732r().getContentResolver().query(C2286f.f8192a, new String[]{"_id"}, "userid= ? AND groupcallkey= ?", new String[]{str, String.valueOf(i)}, null);
    }

    /* renamed from: e */
    public Cursor m7599e() {
        return GlobalApplication.m18732r().getContentResolver().query(C2286f.f8192a, new String[]{"COUNT(*)"}, "groupcallkey = ?", new String[]{Spam.ACTIVITY_CANCEL}, null);
    }

    /* renamed from: f */
    public Cursor m7600f() {
        return GlobalApplication.m18732r().getContentResolver().query(C2286f.f8192a, new String[]{"COUNT(DISTINCT groupcallkey)"}, null, null, null);
    }

    /* renamed from: a */
    public Cursor m7589a(int i) {
        String str;
        Uri uriM10157i = C2286f.f8192a;
        switch (i) {
            case 0:
                uriM10157i = C2286f.m10152d();
                str = "";
                break;
            case 1:
                uriM10157i = C2286f.m10152d();
                str = "callmethod = 6 OR callmethod = 10";
                break;
            case 2:
                uriM10157i = C2286f.m10152d();
                str = "callmethod = 7 OR callmethod = 11";
                break;
            case 3:
                uriM10157i = C2286f.m10152d();
                str = "callmethod = 6 OR callmethod = 7";
                break;
            case 4:
                uriM10157i = C2286f.m10152d();
                str = "callmethod = 10 OR callmethod = 11";
                break;
            case 5:
                uriM10157i = C2286f.m10154f();
                str = null;
                break;
            case 6:
                uriM10157i = C2286f.m10155g();
                str = null;
                break;
            case 7:
                uriM10157i = C2286f.m10156h();
                str = null;
                break;
            case 8:
                uriM10157i = C2286f.m10157i();
                str = null;
                break;
            default:
                str = null;
                break;
        }
        return GlobalApplication.m18732r().getContentResolver().query(uriM10157i, null, str, null, "_id DESC");
    }

    /* renamed from: a */
    public Cursor m7590a(long j) {
        return GlobalApplication.m18732r().getContentResolver().query(C2286f.m10151c(), null, null, new String[]{Long.toString(j), Long.toString(j)}, null);
    }

    /* renamed from: g */
    public Cursor m7601g() {
        return GlobalApplication.m18732r().getContentResolver().query(C2286f.m10150b(), null, null, null, null);
    }

    /* renamed from: h */
    public Cursor m7602h() {
        return GlobalApplication.m18732r().getContentResolver().query(C2286f.m10148a(), null, null, null, null);
    }

    /* renamed from: b */
    public Cursor m7593b(int i) {
        return GlobalApplication.m18732r().getContentResolver().query(C2286f.f8192a, new String[]{"_id"}, "groupcallkey= ?", new String[]{Integer.toString(i)}, null);
    }
}
