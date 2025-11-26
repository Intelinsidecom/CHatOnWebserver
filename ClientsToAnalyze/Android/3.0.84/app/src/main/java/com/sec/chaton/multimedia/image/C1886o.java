package com.sec.chaton.multimedia.image;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3250y;

/* compiled from: ImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.o */
/* loaded from: classes.dex */
class C1886o extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ImagePagerActivity f7169a;

    C1886o(ImagePagerActivity imagePagerActivity) {
        this.f7169a = imagePagerActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C3250y.m11450b("onReceive : " + intent.getAction(), ImagePagerActivity.f6898b);
        this.f7169a.m7602n();
    }
}
