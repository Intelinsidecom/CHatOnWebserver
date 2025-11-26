package com.sds.coolots;

import java.io.IOException;
import java.util.TimerTask;

/* renamed from: com.sds.coolots.c */
/* loaded from: classes.dex */
class C1133c extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ EngineInterface f2322a;

    C1133c(EngineInterface engineInterface) {
        this.f2322a = engineInterface;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() throws IOException {
        this.f2322a.m2028a();
    }
}
