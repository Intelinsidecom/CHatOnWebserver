package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.getBuddyIgnoreList;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;

/* compiled from: GetBuddyIgnoreListTask.java */
/* renamed from: com.sec.chaton.d.a.an */
/* loaded from: classes.dex */
public class C0546an extends AbstractRunnableC0532a {

    /* renamed from: d */
    private ArrayList f2220d;

    public C0546an(Handler handler, C0798h c0798h) {
        super(handler, c0798h);
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        C1786r.m6066e("beforeRequest", "GetBuddyIgnoreListTask");
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        C1786r.m6066e("afterRequest", "GetBuddyIgnoreListTask");
        if (c0101b.m664a() && c0101b.m671d() != null && c0101b.m665b() != EnumC0803m.ERROR) {
            m2746a(((getBuddyIgnoreList) c0101b.m671d()).ignore);
        }
    }

    /* renamed from: a */
    public void m2746a(ArrayList arrayList) {
        this.f2220d = this.f2220d;
    }
}
