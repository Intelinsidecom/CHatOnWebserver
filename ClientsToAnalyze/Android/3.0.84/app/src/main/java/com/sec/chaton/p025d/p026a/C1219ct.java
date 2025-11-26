package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.inner.Ignore;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: IgnoreControlTask.java */
/* renamed from: com.sec.chaton.d.a.ct */
/* loaded from: classes.dex */
public class C1219ct extends AbstractC1145a {

    /* renamed from: b */
    private String f4724b;

    /* renamed from: c */
    private ArrayList<String> f4725c;

    /* renamed from: e */
    private ContentResolver f4726e;

    public C1219ct(Handler handler, C1580h c1580h, String str, ArrayList<String> arrayList) {
        super(handler, c1580h);
        this.f4724b = str;
        this.f4725c = arrayList;
        this.f4726e = CommonApplication.m11493l().getContentResolver();
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3250y.m11456e("beforeRequest", "IgnoreControlTask");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f4725c.size()) {
                arrayList.add(new Ignore(this.f4724b, this.f4725c.get(i2)));
                i = i2 + 1;
            } else {
                String strM11026a = new C3164af().m11026a(arrayList);
                C3250y.m11456e(strM11026a, "IgnoreControlTask");
                return strM11026a;
            }
        }
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws RemoteException, OperationApplicationException {
        C3250y.m11456e("afterRequest", "IgnoreControlTask");
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f4725c.size()) {
                    C3205bt.m11182a(CommonApplication.m11493l()).m11227b(this.f4725c.get(i2));
                    arrayList.add(C1206cg.m5544a(this.f4725c.get(i2)));
                    i = i2 + 1;
                } else {
                    this.f4726e.applyBatch("com.sec.chaton.provider", arrayList);
                    return;
                }
            }
        } else {
            C3250y.m11456e("httpEntry.isConnectionSuccess() = " + c0267d.m11704n() + " ResultCode : " + c0267d.m1351b(), "IgnoreControlTask");
        }
    }
}
