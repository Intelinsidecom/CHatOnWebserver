package com.sec.chaton.multimedia.image;

import android.support.v4.view.ViewPager;
import com.sec.chaton.util.C3250y;

/* compiled from: PostONImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.ac */
/* loaded from: classes.dex */
class C1852ac implements ViewPager.OnPageChangeListener {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerActivity f7080a;

    C1852ac(PostONImagePagerActivity postONImagePagerActivity) {
        this.f7080a = postONImagePagerActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        C3250y.m11450b("onPageSelected : " + i, PostONImagePagerActivity.f6962b);
        this.f7080a.m7634a(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
