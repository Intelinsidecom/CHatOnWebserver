package com.sec.vip.amschaton.fragment;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.o */
/* loaded from: classes.dex */
class HandlerC3562o extends Handler {

    /* renamed from: a */
    final /* synthetic */ ImageView f12995a;

    /* renamed from: b */
    final /* synthetic */ C3561n f12996b;

    HandlerC3562o(C3561n c3561n, ImageView imageView) {
        this.f12996b = c3561n;
        this.f12995a = imageView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f12995a.setImageBitmap((Bitmap) message.obj);
    }
}
