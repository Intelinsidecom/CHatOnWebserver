package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2181ag;
import com.sec.chaton.p065io.entry.GetRecommendeeList;
import com.sec.chaton.p065io.entry.GetSpecialUserList;
import com.sec.chaton.p065io.entry.inner.Recommendee;
import com.sec.chaton.p065io.entry.inner.SpecialUser;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetRecommendeeListTask.java */
/* renamed from: com.sec.chaton.d.a.cl */
/* loaded from: classes.dex */
public class C1966cl extends AbstractC1900a {

    /* renamed from: b */
    private boolean f7260b;

    public C1966cl(C2454e c2454e, boolean z) {
        super(c2454e);
        this.f7260b = false;
        this.f7260b = z;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4904y.m18646e("beforeRequest", "GetRecommendeeListTask");
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
                if (this.f7260b) {
                    arrayList.add(C2181ag.m9735a(100));
                } else {
                    arrayList.add(C2181ag.m9735a(200));
                }
            }
            if (c0778b.m3107b() == EnumC2464o.SUCCESS && c0778b.m3110e() != null) {
                if (this.f7260b) {
                    GetSpecialUserList getSpecialUserList = (GetSpecialUserList) c0778b.m3110e();
                    C4904y.m18641c("the number of specialbuddy from Server : " + getSpecialUserList.specialuser.size(), getClass().getSimpleName());
                    arrayList.add(C2181ag.m9735a(100));
                    for (SpecialUser specialUser : getSpecialUserList.specialuser) {
                        C4904y.m18646e("NO : " + specialUser.specialuserid + ", Name : " + specialUser.name, getClass().getSimpleName());
                        if (specialUser.specialuserid.startsWith("0999")) {
                            arrayList.add(C2181ag.m9737a(specialUser));
                        }
                    }
                } else {
                    GetRecommendeeList getRecommendeeList = (GetRecommendeeList) c0778b.m3110e();
                    C4904y.m18641c("the number of recommendee from Server : " + getRecommendeeList.recommendee.size(), getClass().getSimpleName());
                    arrayList.add(C2181ag.m9735a(200));
                    Iterator<Recommendee> it = getRecommendeeList.recommendee.iterator();
                    while (it.hasNext()) {
                        Recommendee next = it.next();
                        C4904y.m18646e("NO : " + next.ruserid + ", Name : " + next.rname, getClass().getSimpleName());
                        arrayList.add(C2181ag.m9736a(next));
                        C2496n.m10790e(CommonApplication.m18732r(), next.ruserid);
                    }
                }
            }
            CommonApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
        }
    }
}
