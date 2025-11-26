package com.sec.chaton.multimedia.image;

import android.os.Handler;
import android.os.Message;

/* compiled from: PostONImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.am */
/* loaded from: classes.dex */
class HandlerC1862am extends Handler {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerFragment f7101a;

    HandlerC1862am(PostONImagePagerFragment postONImagePagerFragment) {
        this.f7101a = postONImagePagerFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f7101a.f7003C.setProgress(message.arg1);
                break;
            case 2:
                if (this.f7101a.f7003C != null && this.f7101a.f7003C.isShowing()) {
                    this.f7101a.f7003C.dismiss();
                }
                this.f7101a.m7686a(false);
                break;
            case 3:
            case 4:
                if (this.f7101a.f7003C != null && this.f7101a.f7003C.isShowing()) {
                    this.f7101a.f7003C.dismiss();
                    break;
                }
                break;
        }
    }
}
