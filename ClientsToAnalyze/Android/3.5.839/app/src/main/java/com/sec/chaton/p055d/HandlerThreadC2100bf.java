package com.sec.chaton.p055d;

import android.os.HandlerThread;
import com.sec.chaton.sns.p114b.AbstractC4439w;
import com.sec.chaton.util.C4904y;

/* compiled from: SNSBuddyControl.java */
/* renamed from: com.sec.chaton.d.bf */
/* loaded from: classes.dex */
public class HandlerThreadC2100bf extends HandlerThread {

    /* renamed from: a */
    String f7625a;

    /* renamed from: b */
    final /* synthetic */ C2099be f7626b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerThreadC2100bf(C2099be c2099be, String str) {
        super(str, 10);
        this.f7626b = c2099be;
        this.f7625a = null;
        this.f7625a = str;
        C4904y.m18639b("ControlThread for SNS " + this.f7625a + " -> created", C2099be.f7618a);
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        C4904y.m18639b("ControlThread for SNS " + this.f7625a + " -> onLooperPrepared", C2099be.f7618a);
        C4904y.m18639b("ControlThread for SNS " + this.f7625a + " -> started", C2099be.f7618a);
        C2105bk<? extends AbstractC4439w> c2105bkM9396a = C2105bk.m9396a(this.f7625a, true, getLooper(), true);
        c2105bkM9396a.m9426a(new C2101bg(this.f7626b, this.f7625a, this));
        c2105bkM9396a.m9433h();
    }
}
