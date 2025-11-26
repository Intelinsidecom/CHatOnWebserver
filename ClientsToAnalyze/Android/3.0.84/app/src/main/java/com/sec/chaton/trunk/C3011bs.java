package com.sec.chaton.trunk;

import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import com.sec.chaton.util.C3250y;

/* compiled from: TrunkPageActivity.java */
/* renamed from: com.sec.chaton.trunk.bs */
/* loaded from: classes.dex */
class C3011bs implements ViewPager.OnPageChangeListener {

    /* renamed from: a */
    final /* synthetic */ TrunkPageActivity f10859a;

    C3011bs(TrunkPageActivity trunkPageActivity) {
        this.f10859a = trunkPageActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) throws Resources.NotFoundException {
        C3250y.m11450b("onPageSelected : " + i, TrunkPageActivity.f10632f);
        this.f10859a.m10337a(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
