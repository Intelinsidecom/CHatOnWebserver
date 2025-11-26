package com.sec.chaton.multimedia.image;

import android.os.Handler;
import android.os.Message;

/* compiled from: ImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.z */
/* loaded from: classes.dex */
class HandlerC1897z extends Handler {

    /* renamed from: a */
    final /* synthetic */ ImagePagerFragment f7188a;

    HandlerC1897z(ImagePagerFragment imagePagerFragment) {
        this.f7188a = imagePagerFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f7188a.m7630e() != null && !this.f7188a.m7630e().isFinishing() && message.obj != null && message.obj.equals(this.f7188a.f6952r) && this.f7188a.f6960z != null) {
            if (this.f7188a.f6958x != null) {
                this.f7188a.f6958x.setVisibility(0);
                this.f7188a.m7630e().m7615e().m11730a(this.f7188a.f6958x, this.f7188a.f6960z);
            } else {
                this.f7188a.m7630e().m7615e().m11730a(this.f7188a.f6948n, this.f7188a.f6960z);
            }
        }
    }
}
