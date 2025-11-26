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
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: GetMyFollowingsLivepartnerTask.java */
/* renamed from: com.sec.chaton.d.a.ca */
/* loaded from: classes.dex */
public class C1955ca extends AbstractC1900a {
    public C1955ca(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    protected String mo9086c() {
        C4904y.m18646e("beforeRequest()", "GetMyFollowingsLivepartner");
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    protected void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        C4904y.m18646e("afterRequest()", "GetMyFollowingsLivepartner");
        EnumC2464o enumC2464oM3107b = c0778b.m3107b();
        if (c0778b.m18954n() && enumC2464oM3107b != EnumC2464o.ERROR) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (enumC2464oM3107b == EnumC2464o.SUCCESS && c0778b.m3110e() != null) {
                GetSpecialBuddyList getSpecialBuddyList = (GetSpecialBuddyList) c0778b.m3110e();
                C4904y.m18641c("the number of specialbuddy from Server : " + getSpecialBuddyList.specialbuddy.size(), "GetMyFollowingsLivepartner");
                C4904y.m18641c("time stamp: " + getSpecialBuddyList.utc, "GetMyFollowingsLivepartner");
                for (SpecialUser specialUser : getSpecialBuddyList.specialbuddy) {
                    C4904y.m18646e("NO : " + specialUser.specialuserid + ", Name : " + specialUser.name + ", deleted : " + specialUser.deleted, "GetMyFollowingsLivepartner");
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
                C4809aa.m18104a().m18124a("get_myfollowing_buddies_timestamp", getSpecialBuddyList.utc);
                CommonApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
                C0991aa.m6037a().m18962d(C1063bc.m6172a(EnumC1064bd.GET_MY_FOLLOWING));
                return;
            }
            if (enumC2464oM3107b == EnumC2464o.NO_CONTENT) {
                C4904y.m18641c("no Content", "GetMyFollowingsLivepartner");
            }
        }
    }
}
