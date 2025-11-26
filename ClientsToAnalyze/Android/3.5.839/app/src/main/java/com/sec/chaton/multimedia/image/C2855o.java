package com.sec.chaton.multimedia.image;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: ImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.o */
/* loaded from: classes.dex */
class C2855o extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ImagePagerActivity f10489a;

    C2855o(ImagePagerActivity imagePagerActivity) {
        this.f10489a = imagePagerActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4904y.m18639b("onReceive : " + intent.getAction(), ImagePagerActivity.f10196o);
        this.f10489a.m11807r();
    }
}
