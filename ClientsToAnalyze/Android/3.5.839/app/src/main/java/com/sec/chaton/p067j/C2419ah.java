package com.sec.chaton.p067j;

import com.sec.chaton.util.C4904y;
import java.util.concurrent.ExecutorService;

/* compiled from: TcpClient.java */
/* renamed from: com.sec.chaton.j.ah */
/* loaded from: classes.dex */
class C2419ah extends AbstractC2429ar {

    /* renamed from: a */
    final /* synthetic */ C2417af f8607a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2419ah(C2417af c2417af, ExecutorService executorService, String str) {
        super(executorService, str);
        this.f8607a = c2417af;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.p067j.AbstractC2473x
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean mo10474b(Void... voidArr) {
        this.f8607a.m10463i();
        return true;
    }

    @Override // com.sec.chaton.p067j.AbstractC2429ar, com.sec.chaton.p067j.AbstractC2473x
    /* renamed from: c */
    protected void mo10476c() {
        C4904y.m18639b("tcp_queue, closeIMPL(), onCancelled()", "TcpClient");
        super.mo10476c();
    }
}
