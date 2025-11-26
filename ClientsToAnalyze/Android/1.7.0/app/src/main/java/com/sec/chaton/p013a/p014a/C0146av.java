package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p033io.entry.GetBlockBuddyList;
import java.util.List;

/* compiled from: GetBlockListTask.java */
/* renamed from: com.sec.chaton.a.a.av */
/* loaded from: classes.dex */
public class C0146av extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private List f360a;

    public C0146av(Handler handler, C0503j c0503j) {
        super(handler, c0503j);
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        return null;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        if (c0259g.m927a() && c0259g.m928b() == EnumC0518y.SUCCESS) {
            this.f360a = ((GetBlockBuddyList) c0259g.m932d()).buddy;
        }
    }
}
