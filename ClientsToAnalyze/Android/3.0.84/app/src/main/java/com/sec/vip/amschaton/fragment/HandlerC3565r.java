package com.sec.vip.amschaton.fragment;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.r */
/* loaded from: classes.dex */
class HandlerC3565r extends Handler {

    /* renamed from: a */
    final /* synthetic */ ImageView f13002a;

    /* renamed from: b */
    final /* synthetic */ C3564q f13003b;

    HandlerC3565r(C3564q c3564q, ImageView imageView) {
        this.f13003b = c3564q;
        this.f13002a = imageView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f13002a.setImageBitmap((Bitmap) message.obj);
    }
}
