package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import com.sec.chaton.memo.C0839c;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.inner.Memo;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1793y;
import java.util.ArrayList;

/* compiled from: WriteMemoTask.java */
/* renamed from: com.sec.chaton.d.a.ca */
/* loaded from: classes.dex */
public class C0587ca extends AbstractRunnableC0532a {

    /* renamed from: d */
    private C0839c f2333d;

    public C0587ca(Handler handler, C0798h c0798h, C0839c c0839c) {
        super(handler, c0798h);
        this.f2333d = c0839c;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        ArrayList arrayList = new ArrayList();
        Memo memo = new Memo();
        if (this.f2333d.m3495a() != null) {
            memo.buddyid = this.f2333d.m3495a();
        }
        if (this.f2333d.m3497c() != null) {
            memo.value = this.f2333d.m3497c();
        }
        arrayList.add(memo);
        if (arrayList.size() == 0) {
            m2709b();
        }
        String strM6112a = new C1793y().m6112a(arrayList);
        C1786r.m6066e(strM6112a, "WriteMemoTask");
        return strM6112a;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        C1786r.m6066e("afterRequest", "WriteMemoTask");
        if (!c0101b.m664a() || c0101b.m671d() == null || c0101b.m665b() != EnumC0803m.ERROR) {
        }
    }
}
