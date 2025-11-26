package com.sec.chaton.multimedia.image;

import android.support.v4.view.InterfaceC0196cc;
import com.sec.chaton.util.C4904y;

/* compiled from: ImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.l */
/* loaded from: classes.dex */
class C2852l implements InterfaceC0196cc {

    /* renamed from: a */
    final /* synthetic */ ImagePagerActivity f10486a;

    C2852l(ImagePagerActivity imagePagerActivity) {
        this.f10486a = imagePagerActivity;
    }

    @Override // android.support.v4.view.InterfaceC0196cc
    /* renamed from: a */
    public void mo619a(int i) {
        C4904y.m18639b("onPageSelected : " + i, ImagePagerActivity.f10196o);
        this.f10486a.m11786a(i);
    }

    @Override // android.support.v4.view.InterfaceC0196cc
    /* renamed from: a */
    public void mo620a(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.InterfaceC0196cc
    /* renamed from: b */
    public void mo622b(int i) {
    }
}
