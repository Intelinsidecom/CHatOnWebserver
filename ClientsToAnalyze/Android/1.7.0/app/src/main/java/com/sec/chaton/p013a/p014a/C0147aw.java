package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import com.sec.chaton.memo.C0734g;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p033io.entry.inner.Memo;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1349x;
import java.util.ArrayList;

/* compiled from: WriteMemoTask.java */
/* renamed from: com.sec.chaton.a.a.aw */
/* loaded from: classes.dex */
public class C0147aw extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private C0734g f361a;

    public C0147aw(Handler handler, C0503j c0503j, C0734g c0734g) {
        super(handler, c0503j);
        this.f361a = c0734g;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        ArrayList arrayList = new ArrayList();
        Memo memo = new Memo();
        if (this.f361a.m3138a() != null) {
            memo.buddyid = this.f361a.m3138a();
        }
        if (this.f361a.m3140c() != null) {
            memo.value = this.f361a.m3140c();
        }
        arrayList.add(memo);
        if (arrayList.size() == 0) {
            m685c();
        }
        String strM4714a = new C1349x().m4714a(arrayList);
        C1341p.m4662e(strM4714a, "WriteMemoTask");
        return strM4714a;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        C1341p.m4662e("afterRequest", "WriteMemoTask");
    }
}
