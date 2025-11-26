package com.sec.chaton.multimedia.image;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: ImageEffectActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.e */
/* loaded from: classes.dex */
class C2845e extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ImageEffectActivity f10457a;

    C2845e(ImageEffectActivity imageEffectActivity) {
        this.f10457a = imageEffectActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4904y.m18639b("onReceive : " + intent.getAction(), ImageEffectActivity.class.getSimpleName());
        this.f10457a.m11763i();
    }
}
