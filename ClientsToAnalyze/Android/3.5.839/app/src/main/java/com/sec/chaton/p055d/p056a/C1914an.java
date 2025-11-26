package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2181ag;
import com.sec.chaton.p065io.entry.inner.SnsId;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: DeleteSNSIdTask.java */
/* renamed from: com.sec.chaton.d.a.an */
/* loaded from: classes.dex */
public class C1914an extends AbstractC1900a {

    /* renamed from: b */
    private String f7138b;

    /* renamed from: c */
    private String f7139c;

    /* renamed from: d */
    private Integer f7140d;

    /* renamed from: e */
    private ContentResolver f7141e;

    public C1914an(C2454e c2454e, String str, String str2, Integer num) {
        super(c2454e);
        this.f7138b = str;
        this.f7139c = str2;
        this.f7140d = num;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    protected String mo9086c() {
        ArrayList arrayList = new ArrayList();
        SnsId snsId = new SnsId();
        if (this.f7138b != null) {
            snsId.f8581sp = this.f7138b;
        }
        if (this.f7139c != null) {
            snsId.value = this.f7139c;
        }
        arrayList.add(snsId);
        String strM18172a = new C4815ag().m18172a(arrayList);
        C4904y.m18639b(strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    protected void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            this.f7141e = CommonApplication.m18732r().getContentResolver();
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            arrayList.add(C2181ag.m9735a(this.f7140d.intValue()));
            try {
                this.f7141e.applyBatch("com.sec.chaton.provider", arrayList);
            } catch (OperationApplicationException e) {
                e.printStackTrace();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            C4904y.m18639b("[TEST] Delete SnsiD cpo applyBatch", null);
        }
    }
}
