package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.C2228ap;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.p065io.entry.GetCurationList;
import com.sec.chaton.p065io.entry.inner.SpecialUser;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: GetCurationTask.java */
/* renamed from: com.sec.chaton.d.a.bs */
/* loaded from: classes.dex */
public class C1946bs extends AbstractC1900a {

    /* renamed from: b */
    public static final String f7241b = C1946bs.class.getSimpleName();

    public C1946bs(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    protected String mo9086c() {
        C4904y.m18646e("beforeRequest()", f7241b);
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    protected void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        C4904y.m18646e("afterRequest()", f7241b);
        EnumC2464o enumC2464oM3107b = c0778b.m3107b();
        if (c0778b.m18954n() && enumC2464oM3107b != EnumC2464o.ERROR) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (enumC2464oM3107b == EnumC2464o.SUCCESS && c0778b.m3110e() != null) {
                GetCurationList getCurationList = (GetCurationList) c0778b.m3110e();
                C4904y.m18641c("the number of curation : " + getCurationList.curation.size(), f7241b);
                ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2228ap.f7956a);
                builderNewUpdate.withSelection("rank > ?", new String[]{Spam.ACTIVITY_CANCEL});
                builderNewUpdate.withValue("rank", null);
                builderNewUpdate.withValue("targetiso2", null);
                arrayList.add(builderNewUpdate.build());
                for (SpecialUser specialUser : getCurationList.curation) {
                    if (C2186al.m9766a(specialUser.specialuserid) && C2186al.m9772b(CommonApplication.m18732r().getContentResolver(), specialUser.specialuserid)) {
                        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2228ap.f7956a);
                        builderNewInsert.withValue("buddy_no", specialUser.specialuserid);
                        builderNewInsert.withValue("rank", specialUser.rank);
                        builderNewInsert.withValue("targetiso2", specialUser.targetiso2);
                        arrayList.add(builderNewInsert.build());
                    }
                }
                CommonApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
            }
        }
    }
}
