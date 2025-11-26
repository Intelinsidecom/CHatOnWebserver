package com.sec.chaton.multimedia.image;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.util.C4904y;

/* compiled from: PostONImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.ap */
/* loaded from: classes.dex */
class HandlerC2831ap extends Handler {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerFragment f10412a;

    HandlerC2831ap(PostONImagePagerFragment postONImagePagerFragment) {
        this.f10412a = postONImagePagerFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                if (C4904y.f17872b) {
                    C4904y.m18639b("PostON enable POSTON_IMAGE_DOWNLOAD_COMPLETE", PostONImagePagerFragment.f10303b);
                }
                this.f10412a.m11887a(true);
                this.f10412a.m11891b(true);
                break;
            case 1:
                this.f10412a.f10310C.m18719a(message.arg1);
                break;
            case 2:
                if (this.f10412a.f10310C != null && this.f10412a.f10310C.isShowing()) {
                    this.f10412a.f10310C.dismiss();
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("PostON enable FILE_DOWNLOAD_DONE", PostONImagePagerFragment.f10303b);
                }
                this.f10412a.m11908a();
                this.f10412a.m11887a(true);
                this.f10412a.m11891b(true);
                break;
            case 3:
            case 4:
                if (this.f10412a.f10310C != null && this.f10412a.f10310C.isShowing()) {
                    this.f10412a.f10310C.dismiss();
                    break;
                }
                break;
        }
    }
}
