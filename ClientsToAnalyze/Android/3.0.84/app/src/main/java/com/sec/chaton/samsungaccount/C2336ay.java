package com.sec.chaton.samsungaccount;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.ay */
/* loaded from: classes.dex */
class C2336ay extends FragmentPagerAdapter {

    /* renamed from: a */
    final /* synthetic */ MainActivity f8760a;

    /* renamed from: b */
    private boolean f8761b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2336ay(MainActivity mainActivity, FragmentManager fragmentManager, boolean z) {
        super(fragmentManager);
        this.f8760a = mainActivity;
        this.f8761b = z;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new FlickImageLayout(0);
            case 1:
                return new FlickImageLayout(1);
            case 2:
                return new FlickImageLayout(2);
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.f8761b ? 3 : 2;
    }
}
