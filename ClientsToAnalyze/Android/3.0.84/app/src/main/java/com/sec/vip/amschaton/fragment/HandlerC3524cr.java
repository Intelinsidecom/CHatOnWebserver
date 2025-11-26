package com.sec.vip.amschaton.fragment;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.cr */
/* loaded from: classes.dex */
class HandlerC3524cr extends Handler {

    /* renamed from: a */
    final /* synthetic */ ImageView f12923a;

    /* renamed from: b */
    final /* synthetic */ C3523cq f12924b;

    HandlerC3524cr(C3523cq c3523cq, ImageView imageView) {
        this.f12924b = c3523cq;
        this.f12923a = imageView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f12923a.setImageBitmap((Bitmap) message.obj);
    }
}
