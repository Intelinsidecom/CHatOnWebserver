package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.C1388af;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p035io.entry.GetCurationList;
import com.sec.chaton.p035io.entry.inner.SpecialUser;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: GetCurationTask.java */
/* renamed from: com.sec.chaton.d.a.bs */
/* loaded from: classes.dex */
public class C1191bs extends AbstractC1145a {

    /* renamed from: b */
    public static final String f4690b = C1191bs.class.getSimpleName();

    public C1191bs(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    protected String mo5496f() {
        C3250y.m11456e("beforeRequest()", f4690b);
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    protected void mo5488a(C0267d c0267d) throws RemoteException, OperationApplicationException {
        C3250y.m11456e("afterRequest()", f4690b);
        EnumC1587o enumC1587oM1351b = c0267d.m1351b();
        if (c0267d.m11704n() && enumC1587oM1351b != EnumC1587o.ERROR) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (enumC1587oM1351b == EnumC1587o.SUCCESS && c0267d.m1354e() != null) {
                GetCurationList getCurationList = (GetCurationList) c0267d.m1354e();
                C3250y.m11453c("the number of curation : " + getCurationList.curation.size(), f4690b);
                ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C1388af.f5186a);
                builderNewUpdate.withSelection("rank > ?", new String[]{"0"});
                builderNewUpdate.withValue("rank", null);
                builderNewUpdate.withValue("targetiso2", null);
                arrayList.add(builderNewUpdate.build());
                for (SpecialUser specialUser : getCurationList.curation) {
                    if (C1357af.m5991a(specialUser.specialuserid) && C1357af.m5995b(CommonApplication.m11493l().getContentResolver(), specialUser.specialuserid)) {
                        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C1388af.f5186a);
                        builderNewInsert.withValue("buddy_no", specialUser.specialuserid);
                        builderNewInsert.withValue("rank", specialUser.rank);
                        builderNewInsert.withValue("targetiso2", specialUser.targetiso2);
                        arrayList.add(builderNewInsert.build());
                    }
                }
                CommonApplication.m11493l().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
            }
        }
    }
}
