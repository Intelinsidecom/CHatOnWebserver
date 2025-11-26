package com.sec.chaton.multimedia.image;

import android.os.Handler;
import android.os.Message;

/* compiled from: ImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.ab */
/* loaded from: classes.dex */
class HandlerC2817ab extends Handler {

    /* renamed from: a */
    final /* synthetic */ ImagePagerFragment f10381a;

    HandlerC2817ab(ImagePagerFragment imagePagerFragment) {
        this.f10381a = imagePagerFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f10381a.f10260v != null && this.f10381a.m11844d() != null && !this.f10381a.m11844d().isFinishing() && message.obj != null && message.obj.equals(this.f10381a.f10256r) && this.f10381a.f10264z != null) {
            if (this.f10381a.f10262x != null) {
                this.f10381a.f10262x.setVisibility(0);
                this.f10381a.m11844d().m11822j().m19023b(this.f10381a.f10262x, this.f10381a.f10264z);
            } else {
                this.f10381a.m11844d().m11822j().m19023b(this.f10381a.f10252n, this.f10381a.f10264z);
            }
        }
    }
}
