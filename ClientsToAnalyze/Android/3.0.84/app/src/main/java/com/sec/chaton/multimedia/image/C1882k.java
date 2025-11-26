package com.sec.chaton.multimedia.image;

import android.support.v4.view.ViewPager;
import com.sec.chaton.util.C3250y;

/* compiled from: ImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.k */
/* loaded from: classes.dex */
class C1882k implements ViewPager.OnPageChangeListener {

    /* renamed from: a */
    final /* synthetic */ ImagePagerActivity f7165a;

    C1882k(ImagePagerActivity imagePagerActivity) {
        this.f7165a = imagePagerActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        C3250y.m11450b("onPageSelected : " + i, ImagePagerActivity.f6898b);
        this.f7165a.m7579a(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
