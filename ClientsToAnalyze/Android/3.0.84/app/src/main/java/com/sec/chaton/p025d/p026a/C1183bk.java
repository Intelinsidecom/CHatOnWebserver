package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.GetBlockBuddyList;
import com.sec.chaton.p035io.entry.inner.BlockBuddy;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import java.util.List;

/* compiled from: GetBlockListTask.java */
/* renamed from: com.sec.chaton.d.a.bk */
/* loaded from: classes.dex */
public class C1183bk extends AbstractC1145a {

    /* renamed from: b */
    private List<BlockBuddy> f4683b;

    public C1183bk(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
            this.f4683b = ((GetBlockBuddyList) c0267d.m1354e()).buddy;
        }
    }
}
