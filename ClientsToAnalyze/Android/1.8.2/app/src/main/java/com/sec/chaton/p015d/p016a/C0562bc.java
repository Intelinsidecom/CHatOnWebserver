package com.sec.chaton.p015d.p016a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.inner.Ignore;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1793y;
import java.util.ArrayList;

/* compiled from: IgnoreControlTask.java */
/* renamed from: com.sec.chaton.d.a.bc */
/* loaded from: classes.dex */
public class C0562bc extends AbstractRunnableC0532a {

    /* renamed from: d */
    private String f2244d;

    /* renamed from: e */
    private ArrayList f2245e;

    /* renamed from: f */
    private ContentResolver f2246f;

    public C0562bc(Handler handler, C0798h c0798h, String str, ArrayList arrayList) {
        super(handler, c0798h);
        this.f2244d = str;
        this.f2245e = arrayList;
        this.f2246f = GlobalApplication.m3260b().getContentResolver();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        C1786r.m6066e("beforeRequest", "IgnoreControlTask");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f2245e.size()) {
                arrayList.add(new Ignore(this.f2244d, (String) this.f2245e.get(i2)));
                i = i2 + 1;
            } else {
                String strM6112a = new C1793y().m6112a(arrayList);
                C1786r.m6066e(strM6112a, "IgnoreControlTask");
                return strM6112a;
            }
        }
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) throws RemoteException, OperationApplicationException {
        C1786r.m6066e("afterRequest", "IgnoreControlTask");
        if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f2245e.size()) {
                    C1746bb.m5945a(GlobalApplication.m3260b()).m5961a((String) this.f2245e.get(i2));
                    arrayList.add(C0555aw.m2754a((String) this.f2245e.get(i2)));
                    i = i2 + 1;
                } else {
                    this.f2246f.applyBatch("com.sec.chaton.provider", arrayList);
                    return;
                }
            }
        } else {
            C1786r.m6066e("httpEntry.isConnectionSuccess() = " + c0101b.m664a() + " ResultCode : " + c0101b.m665b(), "IgnoreControlTask");
        }
    }
}
