package com.sec.chaton.chat;

import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.C2306z;
import com.sec.widget.C5179v;

/* compiled from: MessageLoader.java */
/* renamed from: com.sec.chaton.chat.hk */
/* loaded from: classes.dex */
class RunnableC1765hk implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f6638a;

    /* renamed from: b */
    final /* synthetic */ C1763hi f6639b;

    RunnableC1765hk(C1763hi c1763hi, String str) {
        this.f6639b = c1763hi;
        this.f6638a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6639b.m8760b(EnumC1769ho.NONE);
        if (this.f6639b.m8760b(EnumC1769ho.LOADING_MORE_FROM_SERVER)) {
            this.f6639b.f6624g.startQuery(3, null, C2306z.m10214a(this.f6639b.f6626i + 50), null, "message_inbox_no=?", new String[]{this.f6639b.f6625h}, null);
            if (!this.f6638a.equals("-1") || this.f6639b.f6621d == null || this.f6639b.f6621d.getResources() == null) {
                return;
            }
            C5179v.m19811a(GlobalApplication.m18732r(), this.f6639b.f6621d.getResources().getString(R.string.end_of_messages, 15), 0).show();
        }
    }
}
