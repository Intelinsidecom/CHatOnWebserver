package com.sec.chaton.event;

import android.support.v4.view.ViewPager;

/* compiled from: NewFeatureFragment.java */
/* renamed from: com.sec.chaton.event.l */
/* loaded from: classes.dex */
class C1470l extends ViewPager.SimpleOnPageChangeListener {

    /* renamed from: a */
    final /* synthetic */ NewFeatureFragment f5448a;

    C1470l(NewFeatureFragment newFeatureFragment) {
        this.f5448a = newFeatureFragment;
    }

    @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.f5448a.f5431h = i;
        if (this.f5448a.f5432i > 1) {
            this.f5448a.m6375a();
        }
    }
}
