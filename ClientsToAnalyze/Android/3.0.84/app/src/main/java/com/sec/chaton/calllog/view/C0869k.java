package com.sec.chaton.calllog.view;

import android.os.Handler;
import com.sec.chaton.calllog.manager.model.CallLogData;
import java.util.ArrayList;

/* compiled from: CallLogDetailFragment.java */
/* renamed from: com.sec.chaton.calllog.view.k */
/* loaded from: classes.dex */
class C0869k extends Thread {

    /* renamed from: a */
    final Handler f3390a;

    /* renamed from: b */
    final /* synthetic */ CallLogDetailFragment f3391b;

    C0869k(CallLogDetailFragment callLogDetailFragment, Handler handler) {
        this.f3391b = callLogDetailFragment;
        this.f3390a = handler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ArrayList<CallLogData> arrayList = new ArrayList<>();
        arrayList.add(this.f3391b.f3254n);
        this.f3391b.f3229B.m4429b(arrayList);
        this.f3390a.sendMessage(this.f3390a.obtainMessage());
    }
}
