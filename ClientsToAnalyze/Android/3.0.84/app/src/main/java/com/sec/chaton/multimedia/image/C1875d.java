package com.sec.chaton.multimedia.image;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3250y;

/* compiled from: ImageEffectActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.d */
/* loaded from: classes.dex */
class C1875d extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ImageEffectActivity f7136a;

    C1875d(ImageEffectActivity imageEffectActivity) {
        this.f7136a = imageEffectActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C3250y.m11450b("onReceive : " + intent.getAction(), ImageEffectActivity.class.getSimpleName());
        this.f7136a.m7558e();
    }
}
