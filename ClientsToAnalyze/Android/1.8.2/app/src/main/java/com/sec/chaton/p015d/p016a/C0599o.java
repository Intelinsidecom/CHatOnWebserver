package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p017e.p018a.C0663g;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;

/* compiled from: DeleteMemoTask.java */
/* renamed from: com.sec.chaton.d.a.o */
/* loaded from: classes.dex */
public class C0599o extends AbstractRunnableC0532a {

    /* renamed from: d */
    private String f2363d;

    public C0599o(Handler handler, C0798h c0798h, String str) {
        super(handler, c0798h);
        this.f2363d = "";
        this.f2363d = str;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
            C1786r.m6066e("delete from db" + this.f2363d, "DeleteMemoTask");
            int iM3035a = C0663g.m3035a(this.f2363d);
            if (iM3035a == 1) {
                C1786r.m6066e("deletedRowCount is 1", "DeleteMemoTask");
            } else {
                C1786r.m6054a("Memo DB delete error: deletedRowCount is " + iM3035a, "DeleteMemoTask");
            }
        }
    }
}
