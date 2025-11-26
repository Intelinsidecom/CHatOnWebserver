package com.sec.chaton.push.p039c;

import android.content.Context;
import com.sec.chaton.push.util.C0921g;
import com.sec.chaton.push.util.InterfaceC0922h;

/* compiled from: MessageTaskQueue.java */
/* renamed from: com.sec.chaton.push.c.i */
/* loaded from: classes.dex */
class C0897i implements InterfaceC0922h {

    /* renamed from: a */
    final /* synthetic */ AbstractC0894f f3069a;

    /* renamed from: b */
    final /* synthetic */ String f3070b;

    /* renamed from: c */
    final /* synthetic */ C0896h f3071c;

    C0897i(C0896h c0896h, AbstractC0894f abstractC0894f, String str) {
        this.f3071c = c0896h;
        this.f3069a = abstractC0894f;
        this.f3070b = str;
    }

    @Override // com.sec.chaton.push.util.InterfaceC0922h
    /* renamed from: a */
    public void mo3462a(Context context) {
        try {
            if (C0921g.f3116a) {
                C0921g.m3637a(C0896h.f3065a, String.format("Put delayed task to MessageTaskQueue. task: %s", this.f3069a));
            }
            synchronized (C0896h.f3066b) {
                this.f3071c.f3068d.remove(this.f3070b);
            }
            this.f3071c.m3527a(this.f3069a);
        } catch (InterruptedException e) {
            if (C0921g.f3119d) {
                C0921g.m3638a(C0896h.f3065a, e.getMessage(), e);
            }
        }
    }
}
