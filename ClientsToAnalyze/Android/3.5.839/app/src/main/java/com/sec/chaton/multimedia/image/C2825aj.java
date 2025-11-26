package com.sec.chaton.multimedia.image;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: PostONImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.aj */
/* loaded from: classes.dex */
class C2825aj extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerActivity f10395a;

    C2825aj(PostONImagePagerActivity postONImagePagerActivity) {
        this.f10395a = postONImagePagerActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4904y.m18639b("onReceive : " + intent.getAction(), PostONImagePagerActivity.f10266o);
        this.f10395a.m11867o();
    }
}
