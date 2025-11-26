package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2181ag;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.common.CommonApplication;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* compiled from: BlockTask.java */
/* renamed from: com.sec.chaton.d.a.s */
/* loaded from: classes.dex */
public class C2060s extends AbstractC1900a {

    /* renamed from: b */
    private String f7521b;

    public C2060s(C2454e c2454e, String str, int i) {
        super(c2454e);
        this.f7521b = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws RemoteException, UnsupportedEncodingException, OperationApplicationException {
        if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            arrayList.add(C2176ab.m9669a(this.f7521b, 2));
            arrayList.add(C2198l.m9917a(this.f7521b));
            arrayList.add(C2181ag.m9738a(this.f7521b));
            CommonApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
            new C2128i(null).m9504a(true);
        }
    }
}
