package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetMemoBlindList;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;

/* compiled from: GetMemoBlindListTask.java */
/* renamed from: com.sec.chaton.d.a.at */
/* loaded from: classes.dex */
public class C0552at extends AbstractRunnableC0532a {

    /* renamed from: d */
    private ArrayList f2228d;

    public C0552at(Handler handler, C0798h c0798h) {
        super(handler, c0798h);
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        C1786r.m6066e("beforeRequest", "GetMemoBlindListTask");
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        C1786r.m6066e("afterRequest", "GetMemoBlindListTask");
        if (c0101b.m664a() && c0101b.m671d() != null && c0101b.m665b() != EnumC0803m.ERROR) {
            m2751a(((GetMemoBlindList) c0101b.m671d()).blind);
        }
    }

    /* renamed from: a */
    public void m2751a(ArrayList arrayList) {
        this.f2228d = arrayList;
    }
}
