package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p025d.p026a.C0623c;
import com.sec.chaton.util.C1341p;

/* compiled from: DeleteMemoTask.java */
/* renamed from: com.sec.chaton.a.a.bi */
/* loaded from: classes.dex */
public class C0160bi extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private String f378a;

    public C0160bi(Handler handler, C0503j c0503j, String str) {
        super(handler, c0503j);
        this.f378a = "";
        this.f378a = str;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        return null;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
            C1341p.m4662e("delete from db" + this.f378a, "DeleteMemoTask");
            int iM2851a = C0623c.m2851a(this.f378a);
            if (iM2851a == 1) {
                C1341p.m4662e("deletedRowCount is 1", "DeleteMemoTask");
            } else {
                C1341p.m4651a("Memo DB delete error: deletedRowCount is " + iM2851a, "DeleteMemoTask");
            }
        }
    }
}
