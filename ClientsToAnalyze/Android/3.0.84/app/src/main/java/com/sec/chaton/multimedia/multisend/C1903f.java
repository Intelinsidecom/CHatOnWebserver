package com.sec.chaton.multimedia.multisend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3250y;

/* compiled from: GalleryActivity.java */
/* renamed from: com.sec.chaton.multimedia.multisend.f */
/* loaded from: classes.dex */
class C1903f extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ GalleryActivity f7249a;

    C1903f(GalleryActivity galleryActivity) {
        this.f7249a = galleryActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C3250y.m11450b("onReceive : " + intent.getAction(), GalleryActivity.f7206b);
        this.f7249a.m7738e();
    }
}
