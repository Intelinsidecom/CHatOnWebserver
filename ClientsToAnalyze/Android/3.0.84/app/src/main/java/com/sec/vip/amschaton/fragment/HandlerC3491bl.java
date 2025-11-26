package com.sec.vip.amschaton.fragment;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.bl */
/* loaded from: classes.dex */
class HandlerC3491bl extends Handler {

    /* renamed from: a */
    final /* synthetic */ ImageView f12862a;

    /* renamed from: b */
    final /* synthetic */ C3490bk f12863b;

    HandlerC3491bl(C3490bk c3490bk, ImageView imageView) {
        this.f12863b = c3490bk;
        this.f12862a = imageView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f12862a.setImageBitmap((Bitmap) message.obj);
    }
}
