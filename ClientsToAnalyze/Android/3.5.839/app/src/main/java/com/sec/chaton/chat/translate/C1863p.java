package com.sec.chaton.chat.translate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: TranslateExecutor.java */
/* renamed from: com.sec.chaton.chat.translate.p */
/* loaded from: classes.dex */
public class C1863p {

    /* renamed from: a */
    private final ExecutorService f7081a = Executors.newSingleThreadExecutor(new ThreadFactoryC1864q(this));

    /* renamed from: a */
    public static C1863p m9065a() {
        return new C1863p();
    }

    private C1863p() {
    }

    /* renamed from: a */
    public void m9066a(RunnableC1861n runnableC1861n) {
        this.f7081a.submit(runnableC1861n);
    }
}
