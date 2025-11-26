package com.sec.vip.cropimage;

import android.os.Handler;
import android.os.Message;
import com.sec.widget.C3641ai;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.j */
/* loaded from: classes.dex */
class HandlerC3614j extends Handler {

    /* renamed from: a */
    final /* synthetic */ CropImage f13286a;

    HandlerC3614j(CropImage cropImage) {
        this.f13286a = cropImage;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C3641ai.m13210a(this.f13286a, message.what, 0).show();
    }
}
