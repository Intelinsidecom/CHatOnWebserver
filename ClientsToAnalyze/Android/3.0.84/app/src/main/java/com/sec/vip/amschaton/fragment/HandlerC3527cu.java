package com.sec.vip.amschaton.fragment;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.cu */
/* loaded from: classes.dex */
class HandlerC3527cu extends Handler {

    /* renamed from: a */
    final /* synthetic */ ImageView f12931a;

    /* renamed from: b */
    final /* synthetic */ C3526ct f12932b;

    HandlerC3527cu(C3526ct c3526ct, ImageView imageView) {
        this.f12932b = c3526ct;
        this.f12931a = imageView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f12931a.setImageBitmap((Bitmap) message.obj);
    }
}
