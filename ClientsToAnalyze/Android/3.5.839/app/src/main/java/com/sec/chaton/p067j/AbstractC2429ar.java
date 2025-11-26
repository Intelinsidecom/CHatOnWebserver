package com.sec.chaton.p067j;

import com.sec.chaton.util.C4904y;
import java.util.concurrent.ExecutorService;

/* compiled from: TcpNetworkWorker.java */
/* renamed from: com.sec.chaton.j.ar */
/* loaded from: classes.dex */
public abstract class AbstractC2429ar extends AbstractC2473x<Void, Void, Boolean> {

    /* renamed from: f */
    long f8652f;

    /* renamed from: g */
    String f8653g;

    public AbstractC2429ar(ExecutorService executorService) {
        super(executorService);
        this.f8652f = System.nanoTime();
    }

    public AbstractC2429ar(ExecutorService executorService, String str) {
        this(executorService);
        this.f8653g = str;
    }

    /* renamed from: f */
    public long m10530f() {
        return this.f8652f;
    }

    /* renamed from: g */
    public String m10531g() {
        return this.f8653g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.p067j.AbstractC2473x
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo10529a(Boolean bool) {
        C4904y.m18639b("tcp_queue, onPostExecute(), " + this, C2417af.class.getSimpleName());
        C2428aq.m10525a(this.f8652f);
        super.mo10529a((AbstractC2429ar) bool);
    }

    @Override // com.sec.chaton.p067j.AbstractC2473x
    /* renamed from: c */
    protected void mo10476c() {
        C4904y.m18639b("tcp_queue, onCancelled(), " + this, C2417af.class.getSimpleName());
        C2428aq.m10525a(this.f8652f);
        super.mo10476c();
    }

    public String toString() {
        return "key: " + this.f8652f + ", name: " + this.f8653g;
    }
}
