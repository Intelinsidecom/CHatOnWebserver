package com.sec.chaton.multimedia.emoticon;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.common.p056b.p060d.C1828c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: EmoticonSelectionView.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.l */
/* loaded from: classes.dex */
class C0966l extends FragmentStatePagerAdapter {

    /* renamed from: b */
    private static Map f3554b = new HashMap();

    /* renamed from: a */
    private EmoticonSelectionView f3555a;

    public C0966l(EmoticonSelectionView emoticonSelectionView, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f3555a = emoticonSelectionView;
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (C1786r.f6452b) {
            C1786r.m6061b(C1828c.m6207a("EmoticonPagerAdapter.getItem() ", Integer.valueOf(i)), EmoticonSelectionView.f3354a);
        }
        EmoticonContainer emoticonContainerM3655a = null;
        if (i == 0) {
            emoticonContainerM3655a = EmoticonContainer.m3655a(R.layout.layout_emoticon_container, true);
        } else if (i == 1) {
            emoticonContainerM3655a = EmoticonContainer.m3655a(R.layout.layout_emoticon_container, false);
        }
        emoticonContainerM3655a.m3656a(this.f3555a);
        f3554b.put(Integer.valueOf(i), emoticonContainerM3655a);
        return emoticonContainerM3655a;
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        super.destroyItem(view, i, obj);
        f3554b.remove(Integer.valueOf(i));
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }
}
