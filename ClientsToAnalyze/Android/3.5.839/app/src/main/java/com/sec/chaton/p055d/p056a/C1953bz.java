package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1063bc;
import com.sec.chaton.EnumC1064bd;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.p065io.entry.GetSpecialBuddyList;
import com.sec.chaton.p065io.entry.inner.SpecialUser;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: GetMyFollowingsLivepartnerSyncTask.java */
/* renamed from: com.sec.chaton.d.a.bz */
/* loaded from: classes.dex */
public class C1953bz extends AbstractC1900a {
    public C1953bz(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    protected String mo9086c() {
        if (C4904y.f17872b) {
            C4904y.m18639b("beforeRequest()", "GetMyFollowingsLivepartnerSyncTask");
            return null;
        }
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    protected void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        if (C4904y.f17872b) {
            C4904y.m18639b("afterRequest()", "GetMyFollowingsLivepartnerSyncTask");
        }
        EnumC2464o enumC2464oM3107b = c0778b.m3107b();
        if (c0778b.m18954n() && enumC2464oM3107b != EnumC2464o.ERROR) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (enumC2464oM3107b == EnumC2464o.SUCCESS && c0778b.m3110e() != null) {
                GetSpecialBuddyList getSpecialBuddyList = (GetSpecialBuddyList) c0778b.m3110e();
                if (C4904y.f17872b) {
                    C4904y.m18639b("the number of specialbuddy from Server : " + getSpecialBuddyList.specialbuddy.size(), "GetMyFollowingsLivepartnerSyncTask");
                    C4904y.m18639b("time stamp: " + getSpecialBuddyList.utc, "GetMyFollowingsLivepartnerSyncTask");
                }
                for (SpecialUser specialUser : getSpecialBuddyList.specialbuddy) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("NO : " + specialUser.specialuserid + ", Name : " + specialUser.name + ", deleted : " + specialUser.deleted, "GetMyFollowingsLivepartnerSyncTask");
                    }
                    if (specialUser.deleted != null && specialUser.deleted.booleanValue()) {
                        if (C2186al.m9774c(CommonApplication.m18732r().getContentResolver(), specialUser.specialuserid)) {
                            arrayList.add(C2186al.m9776d(specialUser));
                        }
                    } else if (C2186al.m9766a(specialUser.specialuserid)) {
                        if (specialUser.imgupdated != null && specialUser.imgupdated.booleanValue()) {
                            C2496n.m10790e(CommonApplication.m18732r(), specialUser.specialuserid);
                        }
                        if (C2186al.m9774c(CommonApplication.m18732r().getContentResolver(), specialUser.specialuserid)) {
                            arrayList.add(C2186al.m9773c(specialUser));
                        } else {
                            arrayList.add(C2186al.m9767b(specialUser));
                        }
                        ContentProviderOperation contentProviderOperationM9667a = C2176ab.m9667a(specialUser);
                        if (contentProviderOperationM9667a != null) {
                            arrayList.add(contentProviderOperationM9667a);
                        }
                    }
                }
                CommonApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
                C0991aa.m6037a().m18962d(C1063bc.m6172a(EnumC1064bd.GET_MY_FOLLOWING));
                return;
            }
            if (enumC2464oM3107b == EnumC2464o.NO_CONTENT && C4904y.f17872b) {
                C4904y.m18639b("no Content", "GetMyFollowingsLivepartnerSyncTask");
            }
        }
    }
}
