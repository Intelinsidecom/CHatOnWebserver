package com.sec.chaton.calllog.view;

import android.os.Handler;
import com.sec.chaton.calllog.manager.model.CallLogData;
import java.util.ArrayList;

/* compiled from: CallLogDetailFragment.java */
/* renamed from: com.sec.chaton.calllog.view.k */
/* loaded from: classes.dex */
class C1480k extends Thread {

    /* renamed from: a */
    final Handler f5363a;

    /* renamed from: b */
    final /* synthetic */ CallLogDetailFragment f5364b;

    C1480k(CallLogDetailFragment callLogDetailFragment, Handler handler) {
        this.f5364b = callLogDetailFragment;
        this.f5363a = handler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ArrayList<CallLogData> arrayList = new ArrayList<>();
        arrayList.add(this.f5364b.f5226n);
        this.f5364b.f5201B.m7583b(arrayList);
        this.f5363a.sendMessage(this.f5363a.obtainMessage());
    }
}
