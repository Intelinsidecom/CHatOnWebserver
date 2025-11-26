package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p035io.entry.GetSpecialUserList;
import com.sec.chaton.p035io.entry.inner.SpecialUser;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: GetLivepartnerListTask.java */
/* renamed from: com.sec.chaton.d.a.bx */
/* loaded from: classes.dex */
public class C1196bx extends AbstractC1145a {

    /* renamed from: b */
    private static final String f4695b = C1196bx.class.getSimpleName();

    public C1196bx(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3250y.m11456e("beforeRequest", f4695b);
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws RemoteException, OperationApplicationException {
        C3250y.m11456e("afterRequest", f4695b);
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (c0267d.m1351b() == EnumC1587o.SUCCESS && c0267d.m1354e() != null) {
                GetSpecialUserList getSpecialUserList = (GetSpecialUserList) c0267d.m1354e();
                String strValueOf = String.valueOf(getSpecialUserList.utc);
                C3159aa.m10962a().m10986b("get_special_buddies_timestamp", strValueOf);
                C3250y.m11453c("the number of Livepartner from Server : " + getSpecialUserList.specialuser.size(), f4695b);
                C3250y.m11453c("Livepartner timestamp : " + strValueOf, f4695b);
                for (SpecialUser specialUser : getSpecialUserList.specialuser) {
                    C3250y.m11453c("\n" + specialUser.toString(), f4695b);
                    if (C1357af.m5991a(specialUser.specialuserid)) {
                        if (specialUser.deleted != null && specialUser.deleted.booleanValue()) {
                            arrayList.add(C1357af.m5999d(specialUser));
                        } else {
                            arrayList.add(C1357af.m5984a(specialUser));
                        }
                    }
                }
            }
            GlobalApplication.m11493l().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
        }
    }
}
