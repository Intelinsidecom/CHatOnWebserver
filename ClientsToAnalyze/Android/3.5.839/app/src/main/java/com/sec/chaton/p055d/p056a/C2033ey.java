package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.block.C1093u;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p065io.entry.inner.Address;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* compiled from: UnBlockBuddiesTask.java */
/* renamed from: com.sec.chaton.d.a.ey */
/* loaded from: classes.dex */
public class C2033ey extends AbstractC1900a {

    /* renamed from: b */
    private ArrayList<C1093u> f7437b;

    public C2033ey(C2454e c2454e, ArrayList<C1093u> arrayList) {
        super(c2454e);
        this.f7437b = arrayList;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f7437b.size(); i++) {
            Address address = new Address();
            address.f8559id = this.f7437b.get(i).f3484a;
            address.isblock = Boolean.toString(false);
            arrayList.add(address);
        }
        String strM18172a = new C4815ag().m18172a(arrayList);
        C4904y.m18646e("\n" + strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws RemoteException, UnsupportedEncodingException, OperationApplicationException {
        if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
            new C2128i(null).m9504a(true);
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            for (int i = 0; i < this.f7437b.size(); i++) {
                arrayList.add(C2176ab.m9669a(this.f7437b.get(i).f3484a, 0));
            }
            CommonApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
            return;
        }
        if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.NO_CONTENT && this.f7437b != null && this.f7437b.size() > 0) {
            new C2128i(null).m9504a(true);
            ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < this.f7437b.size(); i2++) {
                arrayList2.add(C2176ab.m9669a(this.f7437b.get(i2).f3484a, 0));
            }
            CommonApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList2);
        }
    }
}
