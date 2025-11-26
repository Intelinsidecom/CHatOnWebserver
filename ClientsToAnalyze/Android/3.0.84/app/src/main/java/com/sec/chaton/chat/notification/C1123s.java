package com.sec.chaton.chat.notification;

import android.support.v4.view.ViewPager;
import com.sec.chaton.util.C3250y;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.s */
/* loaded from: classes.dex */
class C1123s implements ViewPager.OnPageChangeListener {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f4533a;

    C1123s(ScreenNotification2 screenNotification2) {
        this.f4533a = screenNotification2;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.f4533a.f4385D = i;
        this.f4533a.f4386E = this.f4533a.f4410k.f4462l.get(this.f4533a.f4385D);
        this.f4533a.f4419t.setText(this.f4533a.f4386E.f4499b);
        this.f4533a.f4420u.setText("" + (i + 1) + "/" + this.f4533a.m5409j());
        boolean zStartsWith = this.f4533a.f4386E.f4498a.startsWith("0999");
        if (zStartsWith) {
            this.f4533a.f4384C.setVisibility(8);
        } else {
            this.f4533a.f4384C.setVisibility(0);
        }
        if (C3250y.f11735c) {
            C3250y.m11453c("[onPageSelected] current index:" + this.f4533a.f4385D + " isSpecialbuddy:" + zStartsWith, ScreenNotification2.f4381d);
        }
        if (this.f4533a.f4394M != null) {
            this.f4533a.f4394M.removeCallbacks(this.f4533a.f4393L);
            if (!this.f4533a.f4416q) {
                this.f4533a.f4394M.postDelayed(this.f4533a.f4393L, this.f4533a.f4392K);
            }
        }
        int i2 = this.f4533a.f4410k.f4463m > 99 ? 99 : this.f4533a.f4410k.f4463m;
        if (i == 0) {
            this.f4533a.m5395a(EnumC1129y.SHOW_RIGHT);
        } else if (i == i2 - 1) {
            this.f4533a.m5395a(EnumC1129y.SHOW_LEFT);
        } else {
            this.f4533a.m5395a(EnumC1129y.SHOW_LEFTRIGHT);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
