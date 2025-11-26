package com.sec.chaton.multimedia.multisend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3250y;

/* compiled from: PreviewPageActivity.java */
/* renamed from: com.sec.chaton.multimedia.multisend.p */
/* loaded from: classes.dex */
class C1913p extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ PreviewPageActivity f7287a;

    C1913p(PreviewPageActivity previewPageActivity) {
        this.f7287a = previewPageActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C3250y.m11450b("onReceive : " + intent.getAction(), PreviewPageActivity.f7220a);
        this.f7287a.m7759e();
    }
}
