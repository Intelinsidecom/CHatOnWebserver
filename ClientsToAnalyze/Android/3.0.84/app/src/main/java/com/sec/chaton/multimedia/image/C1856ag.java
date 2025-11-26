package com.sec.chaton.multimedia.image;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3250y;

/* compiled from: PostONImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.ag */
/* loaded from: classes.dex */
class C1856ag extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerActivity f7084a;

    C1856ag(PostONImagePagerActivity postONImagePagerActivity) {
        this.f7084a = postONImagePagerActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C3250y.m11450b("onReceive : " + intent.getAction(), PostONImagePagerActivity.f6962b);
        this.f7084a.m7651l();
    }
}
