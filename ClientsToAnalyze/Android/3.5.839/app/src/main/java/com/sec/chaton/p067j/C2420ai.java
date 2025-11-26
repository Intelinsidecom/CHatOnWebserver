package com.sec.chaton.p067j;

import android.os.SystemClock;
import com.sec.chaton.util.C4904y;
import java.util.concurrent.ExecutorService;

/* compiled from: TcpClient.java */
/* renamed from: com.sec.chaton.j.ai */
/* loaded from: classes.dex */
class C2420ai extends AbstractC2429ar {

    /* renamed from: a */
    final /* synthetic */ C2426ao f8608a;

    /* renamed from: b */
    final /* synthetic */ long f8609b;

    /* renamed from: c */
    final /* synthetic */ long f8610c;

    /* renamed from: d */
    final /* synthetic */ boolean f8611d;

    /* renamed from: e */
    final /* synthetic */ C2417af f8612e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2420ai(C2417af c2417af, ExecutorService executorService, String str, C2426ao c2426ao, long j, long j2, boolean z) {
        super(executorService, str);
        this.f8612e = c2417af;
        this.f8608a = c2426ao;
        this.f8609b = j;
        this.f8610c = j2;
        this.f8611d = z;
    }

    @Override // com.sec.chaton.p067j.AbstractC2429ar, com.sec.chaton.p067j.AbstractC2473x
    /* renamed from: c */
    protected void mo10476c() {
        C4904y.m18639b("tcp_queue, sendIMPL - onCancelled()", getClass().getSimpleName());
        this.f8608a.m10508a(35, this.f8608a);
        super.mo10476c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.p067j.AbstractC2473x
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean mo10474b(Void... voidArr) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C4904y.m18639b("tcp_queue, sendIMPL - executeTime : " + String.valueOf(jElapsedRealtime), getClass().getSimpleName());
        if (jElapsedRealtime - this.f8609b <= this.f8610c) {
            this.f8612e.m10447a(this.f8608a, this.f8611d);
            return true;
        }
        C4904y.m18639b("tcp_queue, TcpClient.sendIMPL().run() : waiting timeout. try tcp error callback.", "TcpClient");
        this.f8608a.m10508a(31, this.f8608a);
        return null;
    }
}
