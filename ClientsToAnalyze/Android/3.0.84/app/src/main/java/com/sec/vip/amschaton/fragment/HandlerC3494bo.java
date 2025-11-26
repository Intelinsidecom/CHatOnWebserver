package com.sec.vip.amschaton.fragment;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.bo */
/* loaded from: classes.dex */
class HandlerC3494bo extends Handler {

    /* renamed from: a */
    final /* synthetic */ ImageView f12871a;

    /* renamed from: b */
    final /* synthetic */ C3493bn f12872b;

    HandlerC3494bo(C3493bn c3493bn, ImageView imageView) {
        this.f12872b = c3493bn;
        this.f12871a = imageView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f12871a.setImageBitmap((Bitmap) message.obj);
    }
}
