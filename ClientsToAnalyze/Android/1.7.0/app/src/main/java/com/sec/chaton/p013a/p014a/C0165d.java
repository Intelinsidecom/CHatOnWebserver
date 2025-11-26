package com.sec.chaton.p013a.p014a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p025d.C0670w;
import com.sec.chaton.p033io.entry.GetRecommendeeList;
import com.sec.chaton.p033io.entry.inner.Recommendee;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetRecommendeeListTask.java */
/* renamed from: com.sec.chaton.a.a.d */
/* loaded from: classes.dex */
public class C0165d extends AbstractRunnableC0153bb {
    public C0165d(Handler handler, C0503j c0503j) {
        super(handler, c0503j);
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        return null;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) throws RemoteException, OperationApplicationException {
        if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (c0259g.m928b() == EnumC0518y.NO_CONTENT || c0259g.m928b() == EnumC0518y.SUCCESS) {
                arrayList.add(m704a(200));
                arrayList.add(m704a(100));
            }
            if (c0259g.m932d() != null) {
                GetRecommendeeList getRecommendeeList = (GetRecommendeeList) c0259g.m932d();
                C1341p.m4660c("the number of recommendee from Server : " + getRecommendeeList.recommendee.size(), getClass().getSimpleName());
                arrayList.add(m704a(200));
                Iterator it = getRecommendeeList.recommendee.iterator();
                while (it.hasNext()) {
                    Recommendee recommendee = (Recommendee) it.next();
                    C1341p.m4662e("NO : " + recommendee.ruserid + ", Name : " + recommendee.rname, getClass().getSimpleName());
                    arrayList.add(m705a(recommendee, 200));
                }
            }
            GlobalApplication.m3100a().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
        }
    }

    /* renamed from: a */
    private static ContentProviderOperation m705a(Recommendee recommendee, int i) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C0670w.f2314a);
        builderNewInsert.withValue("buddy_no", recommendee.ruserid);
        builderNewInsert.withValue("buddy_name", recommendee.rname);
        builderNewInsert.withValue("type", Integer.valueOf(i));
        return builderNewInsert.build();
    }

    /* renamed from: a */
    private static ContentProviderOperation m704a(int i) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C0670w.f2314a);
        builderNewDelete.withSelection("type=" + i, null);
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m706a(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C0670w.f2314a);
        builderNewDelete.withSelection("buddy_no=" + str, null);
        return builderNewDelete.build();
    }
}
