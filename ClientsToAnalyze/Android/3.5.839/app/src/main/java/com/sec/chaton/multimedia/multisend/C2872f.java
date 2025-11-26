package com.sec.chaton.multimedia.multisend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: GalleryActivity.java */
/* renamed from: com.sec.chaton.multimedia.multisend.f */
/* loaded from: classes.dex */
class C2872f extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ GalleryActivity f10570a;

    C2872f(GalleryActivity galleryActivity) {
        this.f10570a = galleryActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4904y.m18639b("onReceive : " + intent.getAction(), GalleryActivity.f10527o);
        this.f10570a.m11968j();
    }
}
