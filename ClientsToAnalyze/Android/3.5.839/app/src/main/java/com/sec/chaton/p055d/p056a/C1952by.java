package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.p065io.entry.GetSpecialUserList;
import com.sec.chaton.p065io.entry.inner.SpecialUser;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: GetLivepartnerProfileTask.java */
/* renamed from: com.sec.chaton.d.a.by */
/* loaded from: classes.dex */
public class C1952by extends AbstractC1900a {

    /* renamed from: b */
    private boolean f7244b;

    public C1952by(C2454e c2454e, boolean z) {
        super(c2454e);
        this.f7244b = z;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    protected String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    protected void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        if (c0778b.m18954n()) {
            if (c0778b.m3107b() == EnumC2464o.SUCCESS && c0778b.m3110e() != null) {
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                for (SpecialUser specialUser : ((GetSpecialUserList) c0778b.m3110e()).specialuser) {
                    C4904y.m18646e("NO : " + specialUser.specialuserid + ", Name : " + specialUser.name, getClass().getSimpleName());
                    if (!this.f7244b && C2186al.m9766a(specialUser.specialuserid)) {
                        arrayList.add(C2186al.m9759a(specialUser));
                    }
                }
                CommonApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
                return;
            }
            C4904y.m18646e("result code : " + c0778b.m3107b(), getClass().getSimpleName());
            return;
        }
        C4904y.m18646e("isConnectionSuccess : " + Boolean.toString(c0778b.m18954n()), getClass().getSimpleName());
    }
}
