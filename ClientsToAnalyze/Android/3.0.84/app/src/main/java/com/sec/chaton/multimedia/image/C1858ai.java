package com.sec.chaton.multimedia.image;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.sec.chaton.util.C3250y;

/* compiled from: PostONImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.ai */
/* loaded from: classes.dex */
public class C1858ai extends FragmentStatePagerAdapter {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerActivity f7086a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1858ai(PostONImagePagerActivity postONImagePagerActivity, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f7086a = postONImagePagerActivity;
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        PostONImagePagerFragment postONImagePagerFragment = new PostONImagePagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", i);
        bundle.putString("buddyId", this.f7086a.f6975f);
        postONImagePagerFragment.setArguments(bundle);
        if (C3250y.f11734b) {
            C3250y.m11450b("getItem : " + i, PostONImagePagerActivity.f6962b);
        }
        return postONImagePagerFragment;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.f7086a.f6986q.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }
}
