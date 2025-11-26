package com.sec.chaton.multimedia.multisend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: PreviewPageActivity.java */
/* renamed from: com.sec.chaton.multimedia.multisend.m */
/* loaded from: classes.dex */
class C2879m extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ PreviewPageActivity f10597a;

    C2879m(PreviewPageActivity previewPageActivity) {
        this.f10597a = previewPageActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4904y.m18639b("onReceive : " + intent.getAction(), PreviewPageActivity.f10541n);
        this.f10597a.m11989j();
    }
}
