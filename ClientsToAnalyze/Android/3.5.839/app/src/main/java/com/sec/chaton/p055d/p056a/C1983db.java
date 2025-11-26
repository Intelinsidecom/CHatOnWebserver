package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2181ag;
import com.sec.chaton.p065io.entry.inner.Ignore;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: IgnoreControlTask.java */
/* renamed from: com.sec.chaton.d.a.db */
/* loaded from: classes.dex */
public class C1983db extends AbstractC1900a {

    /* renamed from: b */
    private String f7276b;

    /* renamed from: c */
    private ArrayList<String> f7277c;

    /* renamed from: d */
    private ContentResolver f7278d;

    public C1983db(C2454e c2454e, String str, ArrayList<String> arrayList) {
        super(c2454e);
        this.f7276b = str;
        this.f7277c = arrayList;
        this.f7278d = CommonApplication.m18732r().getContentResolver();
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4904y.m18646e("beforeRequest", "IgnoreControlTask");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f7277c.size()) {
                arrayList.add(new Ignore(this.f7276b, this.f7277c.get(i2)));
                i = i2 + 1;
            } else {
                String strM18172a = new C4815ag().m18172a(arrayList);
                C4904y.m18646e(strM18172a, "IgnoreControlTask");
                return strM18172a;
            }
        }
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        C4904y.m18646e("afterRequest", "IgnoreControlTask");
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f7277c.size()) {
                    C2496n.m10790e(CommonApplication.m18732r(), this.f7277c.get(i2));
                    arrayList.add(C2181ag.m9738a(this.f7277c.get(i2)));
                    i = i2 + 1;
                } else {
                    this.f7278d.applyBatch("com.sec.chaton.provider", arrayList);
                    return;
                }
            }
        } else {
            C4904y.m18646e("httpEntry.isConnectionSuccess() = " + c0778b.m18954n() + " ResultCode : " + c0778b.m3107b(), "IgnoreControlTask");
        }
    }
}
