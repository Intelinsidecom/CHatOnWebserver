package com.sec.vip.cropimage;

import android.content.res.Resources;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.c */
/* loaded from: classes.dex */
class RunnableC3607c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CropImage f13275a;

    RunnableC3607c(CropImage cropImage) {
        this.f13275a = cropImage;
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        this.f13275a.m12901g();
        this.f13275a.f13152G = true;
    }
}
