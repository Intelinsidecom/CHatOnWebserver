package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.block.C0475ac;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p035io.entry.inner.Address;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* compiled from: UnBlockBuddiesTask.java */
/* renamed from: com.sec.chaton.d.a.ea */
/* loaded from: classes.dex */
public class C1254ea extends AbstractC1145a {

    /* renamed from: b */
    private ArrayList<C0475ac> f4822b;

    public C1254ea(Handler handler, C1580h c1580h, ArrayList<C0475ac> arrayList) {
        super(handler, c1580h);
        this.f4822b = arrayList;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f4822b.size(); i++) {
            Address address = new Address();
            address.f5637id = this.f4822b.get(i).f1584a;
            address.isblock = Boolean.toString(false);
            arrayList.add(address);
        }
        String strM11026a = new C3164af().m11026a(arrayList);
        C3250y.m11456e("\n" + strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws RemoteException, UnsupportedEncodingException, OperationApplicationException {
        if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
            new C1330h(null).m5727a(true);
            new C1330h(null).m5736c();
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            for (int i = 0; i < this.f4822b.size(); i++) {
                arrayList.add(C1381y.m6205a(this.f4822b.get(i).f1584a, 0));
            }
            CommonApplication.m11493l().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
            return;
        }
        if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.NO_CONTENT && this.f4822b != null && this.f4822b.size() > 0) {
            new C1330h(null).m5727a(true);
            new C1330h(null).m5736c();
            ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < this.f4822b.size(); i2++) {
                arrayList2.add(C1381y.m6205a(this.f4822b.get(i2).f1584a, 0));
            }
            CommonApplication.m11493l().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList2);
        }
    }
}
