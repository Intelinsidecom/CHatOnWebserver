package com.sec.chaton.msgbox;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.AsyncTask;
import android.os.RemoteException;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2202p;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.smsplugin.provider.C3947e;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: MsgboxSMSMergingTask.java */
/* renamed from: com.sec.chaton.msgbox.bi */
/* loaded from: classes.dex */
public class AsyncTaskC2644bi extends AsyncTask<ArrayList<String>, Void, Void> {

    /* renamed from: b */
    static final String f9495b = AsyncTaskC2644bi.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(ArrayList<String>... arrayListArr) throws Throwable {
        if (C4904y.f17872b) {
            C4904y.m18639b("MsgboxSMSMergingTask start", f9495b);
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = (arrayListArr == null || arrayListArr.length == 0) ? null : arrayListArr[0];
        ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
        ArrayList<C2645bj> arrayListM9976a = C2202p.m9976a(contentResolver);
        ArrayList<String> arrayListM9982b = C2202p.m9982b(contentResolver);
        ArrayList arrayList3 = new ArrayList();
        Iterator<C2645bj> it = arrayListM9976a.iterator();
        while (it.hasNext()) {
            C2645bj next = it.next();
            boolean zM15018a = C3892o.m15018a(contentResolver, next.f9497b);
            if (next.f9503h == 0 && zM15018a) {
                String strM9974a = C2202p.m9974a(contentResolver, next.f9497b);
                arrayList.add(C2202p.m9972a(strM9974a, next.f9500e, next.f9502g));
                arrayList.add(C2202p.m9980b(strM9974a, next.f9499d, next.f9501f));
                if (C2202p.m9983b(contentResolver, strM9974a)) {
                    arrayList.add(C2202p.m9971a(strM9974a, next.f9496a, next.f9498c));
                }
                arrayList3.add(next.f9496a);
            } else if (arrayListM9982b.contains(next.f9496a)) {
                arrayList.addAll(C2202p.m9992i(contentResolver, next.f9496a));
            }
        }
        C2198l.m9932a(contentResolver, (ArrayList<String>) arrayList3);
        Iterator<String> it2 = C2202p.m9984c(contentResolver).iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            if (C2202p.m9985c(contentResolver, next2)) {
                arrayList.add(C2202p.m9969a(next2));
            }
            if (C2202p.m9987d(contentResolver, next2)) {
                arrayList.add(C2202p.m9969a(next2));
            }
            String[] strArrM9689c = C2176ab.m9689c(contentResolver, next2);
            if (strArrM9689c.length != 0 && !C3892o.m15018a(contentResolver, strArrM9689c[0])) {
                String strM9988e = C2202p.m9988e(contentResolver, next2);
                arrayList.add(C2202p.m9969a(next2));
                ContentProviderOperation contentProviderOperationM9946c = C2198l.m9946c(contentResolver, next2);
                if (contentProviderOperationM9946c != null) {
                    arrayList.add(contentProviderOperationM9946c);
                }
                arrayList.add(C3947e.m15260b(contentResolver, Long.valueOf(strM9988e).longValue()));
            }
        }
        if (arrayList2 != null) {
            Iterator<String> it3 = arrayListM9982b.iterator();
            while (it3.hasNext()) {
                String next3 = it3.next();
                if (arrayList2.size() <= 0 || !arrayList2.contains(next3)) {
                    arrayList.addAll(C2202p.m9992i(contentResolver, next3));
                }
            }
        }
        try {
            CommonApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
        } catch (OperationApplicationException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f9495b);
            }
        } catch (RemoteException e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, f9495b);
            }
        }
        return null;
    }
}
