package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3231f;
import com.sec.common.CommonApplication;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* compiled from: BlockTask.java */
/* renamed from: com.sec.chaton.d.a.x */
/* loaded from: classes.dex */
public class C1285x extends AbstractC1145a {

    /* renamed from: b */
    private String f4899b;

    public C1285x(Handler handler, C1580h c1580h, String str, int i) {
        super(handler, c1580h);
        this.f4899b = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws RemoteException, UnsupportedEncodingException, OperationApplicationException {
        if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            arrayList.add(C1381y.m6205a(this.f4899b, 2));
            arrayList.add(C1370n.m6113a(this.f4899b));
            CommonApplication.m11493l().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
            new C1330h(null).m5727a(true);
            new C1330h(null).m5736c();
            C3231f.m11361a(CommonApplication.m11493l()).m11386b(this.f4899b);
        }
    }
}
