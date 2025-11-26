package com.sec.chaton.p067j;

import android.os.SystemClock;
import com.sec.chaton.util.C4904y;
import java.util.concurrent.ExecutorService;

/* compiled from: TcpClient.java */
/* renamed from: com.sec.chaton.j.ag */
/* loaded from: classes.dex */
class C2418ag extends AbstractC2429ar {

    /* renamed from: a */
    final /* synthetic */ long f8604a;

    /* renamed from: b */
    final /* synthetic */ long f8605b;

    /* renamed from: c */
    final /* synthetic */ C2417af f8606c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2418ag(C2417af c2417af, ExecutorService executorService, String str, long j, long j2) {
        super(executorService, str);
        this.f8606c = c2417af;
        this.f8604a = j;
        this.f8605b = j2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.p067j.AbstractC2473x
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean mo10474b(Void... voidArr) {
        if (SystemClock.elapsedRealtime() - this.f8604a <= this.f8605b) {
            this.f8606c.m10461g();
            return true;
        }
        C4904y.m18639b("TcpClient.reconnectIMPL().run() - waiting timeout", "TcpClient");
        return false;
    }
}
