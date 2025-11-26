package com.sec.chaton.multimedia.emoticon;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.anicon.AniconContainer;
import com.sec.chaton.multimedia.emoticon.anicon.EmptyAniconView;
import com.sec.chaton.util.C1786r;
import com.sec.common.p056b.p060d.C1828c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: EmoticonSelectionView.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.i */
/* loaded from: classes.dex */
class C0963i extends FragmentStatePagerAdapter {

    /* renamed from: e */
    private static Map f3546e = new HashMap();

    /* renamed from: f */
    private static final Handler f3547f = new Handler();

    /* renamed from: a */
    private EmoticonSelectionView f3548a;

    /* renamed from: b */
    private Cursor f3549b;

    /* renamed from: c */
    private ContentObserver f3550c;

    /* renamed from: d */
    private boolean f3551d;

    public C0963i(EmoticonSelectionView emoticonSelectionView, FragmentManager fragmentManager, Cursor cursor) {
        super(fragmentManager);
        this.f3548a = emoticonSelectionView;
        this.f3549b = cursor;
        this.f3550c = new C0964j(this, new Handler());
        this.f3549b.registerContentObserver(this.f3550c);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return this.f3551d ? -2 : -1;
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void finishUpdate(View view) {
        super.finishUpdate(view);
        if (this.f3551d) {
            this.f3551d = false;
            f3547f.post(new RunnableC0965k(this));
        }
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        super.destroyItem(view, i, obj);
        f3546e.remove(Integer.valueOf(i));
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        AniconContainer aniconContainerM3675a;
        if (this.f3549b.getCount() == 0) {
            this.f3548a.f3363j.setVisibility(4);
            return new EmptyAniconView();
        }
        this.f3548a.f3363j.setVisibility(0);
        if (i == 0) {
            aniconContainerM3675a = AniconContainer.m3674a(R.layout.layout_anicon_container);
        } else {
            this.f3549b.moveToPosition(i - 1);
            String string = this.f3549b.getString(this.f3549b.getColumnIndex("package_id"));
            if (C1786r.f6452b) {
                C1786r.m6061b(C1828c.m6207a("Get anicon of PackageId: ", string), EmoticonSelectionView.f3354a);
            }
            if (i == 1) {
                aniconContainerM3675a = AniconContainer.m3675a(R.layout.layout_anicon_container, string, true);
            } else {
                aniconContainerM3675a = AniconContainer.m3675a(R.layout.layout_anicon_container, string, false);
            }
        }
        aniconContainerM3675a.m3679a(this.f3548a);
        f3546e.put(Integer.valueOf(i), aniconContainerM3675a);
        return aniconContainerM3675a;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.f3549b.getCount() + 1;
    }
}
