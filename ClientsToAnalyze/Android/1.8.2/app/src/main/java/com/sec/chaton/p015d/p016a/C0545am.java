package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetBlockBuddyList;
import java.util.List;

/* compiled from: GetBlockListTask.java */
/* renamed from: com.sec.chaton.d.a.am */
/* loaded from: classes.dex */
public class C0545am extends AbstractRunnableC0532a {

    /* renamed from: d */
    private List f2219d;

    public C0545am(Handler handler, C0798h c0798h) {
        super(handler, c0798h);
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        if (c0101b.m664a() && c0101b.m665b() == EnumC0803m.SUCCESS) {
            this.f2219d = ((GetBlockBuddyList) c0101b.m671d()).buddy;
        }
    }

    /* renamed from: f */
    public List m2745f() {
        return this.f2219d;
    }
}
