package com.sec.chaton.multimedia.image;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.sec.chaton.localbackup.chatview.BackupImagePagerFragment;
import com.sec.chaton.util.C3250y;

/* compiled from: ImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.s */
/* loaded from: classes.dex */
public class C1890s extends FragmentStatePagerAdapter {

    /* renamed from: a */
    final /* synthetic */ ImagePagerActivity f7173a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1890s(ImagePagerActivity imagePagerActivity, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f7173a = imagePagerActivity;
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        Fragment imagePagerFragment;
        if (this.f7173a.f6902D) {
            imagePagerFragment = new BackupImagePagerFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position", i);
            imagePagerFragment.setArguments(bundle);
            if (C3250y.f11734b) {
                C3250y.m11450b("getItem : " + i, ImagePagerActivity.f6898b);
            }
        } else {
            imagePagerFragment = new ImagePagerFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("position", i);
            imagePagerFragment.setArguments(bundle2);
            if (C3250y.f11734b) {
                C3250y.m11450b("getItem : " + i, ImagePagerActivity.f6898b);
            }
        }
        return imagePagerFragment;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.f7173a.f6923q.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }
}
