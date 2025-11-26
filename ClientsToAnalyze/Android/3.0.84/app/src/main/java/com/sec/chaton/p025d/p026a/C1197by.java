package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p035io.entry.GetSpecialBuddyList;
import com.sec.chaton.p035io.entry.inner.SpecialUser;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: GetMyFollowingsLivepartner.java */
/* renamed from: com.sec.chaton.d.a.by */
/* loaded from: classes.dex */
public class C1197by extends AbstractC1145a {
    public C1197by(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    protected String mo5496f() {
        C3250y.m11456e("beforeRequest()", "GetMyFollowingsLivepartner");
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    protected void mo5488a(C0267d c0267d) throws RemoteException, OperationApplicationException {
        C3250y.m11456e("afterRequest()", "GetMyFollowingsLivepartner");
        EnumC1587o enumC1587oM1351b = c0267d.m1351b();
        if (c0267d.m11704n() && enumC1587oM1351b != EnumC1587o.ERROR) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (enumC1587oM1351b == EnumC1587o.SUCCESS && c0267d.m1354e() != null) {
                GetSpecialBuddyList getSpecialBuddyList = (GetSpecialBuddyList) c0267d.m1354e();
                C3250y.m11453c("the number of specialbuddy from Server : " + getSpecialBuddyList.specialbuddy.size(), "GetMyFollowingsLivepartner");
                C3250y.m11453c("time stamp: " + getSpecialBuddyList.utc, "GetMyFollowingsLivepartner");
                for (SpecialUser specialUser : getSpecialBuddyList.specialbuddy) {
                    C3250y.m11456e("NO : " + specialUser.specialuserid + ", Name : " + specialUser.name + ", deleted : " + specialUser.deleted, "GetMyFollowingsLivepartner");
                    if (specialUser.deleted != null && specialUser.deleted.booleanValue()) {
                        if (C1357af.m5997c(CommonApplication.m11493l().getContentResolver(), specialUser.specialuserid)) {
                            arrayList.add(C1357af.m6001e(specialUser));
                        }
                    } else if (C1357af.m5991a(specialUser.specialuserid)) {
                        if (C1357af.m5997c(CommonApplication.m11493l().getContentResolver(), specialUser.specialuserid)) {
                            arrayList.add(C1357af.m5996c(specialUser));
                        } else {
                            arrayList.add(C1357af.m5992b(specialUser));
                        }
                    }
                }
                C3159aa.m10962a().m10982a("get_myfollowing_buddies_timestamp", getSpecialBuddyList.utc);
                CommonApplication.m11493l().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
                return;
            }
            if (enumC1587oM1351b == EnumC1587o.NO_CONTENT) {
                C3250y.m11453c("no Content", "GetMyFollowingsLivepartner");
            }
        }
    }
}
