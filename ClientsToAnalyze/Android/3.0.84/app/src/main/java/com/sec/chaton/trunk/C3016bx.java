package com.sec.chaton.trunk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

/* compiled from: TrunkPageActivity.java */
/* renamed from: com.sec.chaton.trunk.bx */
/* loaded from: classes.dex */
public class C3016bx extends FragmentStatePagerAdapter {

    /* renamed from: a */
    final /* synthetic */ TrunkPageActivity f10864a;

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.f10864a.f10658t.remove(Integer.valueOf(i));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3016bx(TrunkPageActivity trunkPageActivity, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f10864a = trunkPageActivity;
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (this.f10864a.f10642c.size() <= i || this.f10864a.f10642c.get(i) == null) {
            return null;
        }
        TrunkFullView trunkFullView = new TrunkFullView();
        Bundle bundle = new Bundle();
        bundle.putInt("position", i);
        trunkFullView.setArguments(bundle);
        this.f10864a.f10658t.put(Integer.valueOf(i), trunkFullView);
        return trunkFullView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.f10864a.f10642c.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }
}
