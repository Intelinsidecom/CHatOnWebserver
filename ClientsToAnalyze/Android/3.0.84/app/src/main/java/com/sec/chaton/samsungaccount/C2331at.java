package com.sec.chaton.samsungaccount;

import android.support.v4.view.ViewPager;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.at */
/* loaded from: classes.dex */
class C2331at implements ViewPager.OnPageChangeListener {

    /* renamed from: a */
    final /* synthetic */ MainActivity f8753a;

    C2331at(MainActivity mainActivity) {
        this.f8753a = mainActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i == 0) {
            this.f8753a.f8667R.setImageDrawable(this.f8753a.getResources().getDrawable(R.drawable.device_page_indicator_02));
            this.f8753a.f8668S.setImageDrawable(this.f8753a.getResources().getDrawable(R.drawable.device_page_indicator_01));
            this.f8753a.f8669T.setImageDrawable(this.f8753a.getResources().getDrawable(R.drawable.device_page_indicator_01));
        } else if (i == 1) {
            this.f8753a.f8667R.setImageDrawable(this.f8753a.getResources().getDrawable(R.drawable.device_page_indicator_01));
            this.f8753a.f8668S.setImageDrawable(this.f8753a.getResources().getDrawable(R.drawable.device_page_indicator_02));
            this.f8753a.f8669T.setImageDrawable(this.f8753a.getResources().getDrawable(R.drawable.device_page_indicator_01));
        } else if (i == 2) {
            this.f8753a.f8667R.setImageDrawable(this.f8753a.getResources().getDrawable(R.drawable.device_page_indicator_01));
            this.f8753a.f8668S.setImageDrawable(this.f8753a.getResources().getDrawable(R.drawable.device_page_indicator_01));
            this.f8753a.f8669T.setImageDrawable(this.f8753a.getResources().getDrawable(R.drawable.device_page_indicator_02));
        }
        C3250y.m11450b("Flick count " + this.f8753a.f8682ad, this.f8753a.f8672W);
        MainActivity.m8787l(this.f8753a);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
