package com.sec.chaton.event;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

/* compiled from: NewFeatureFragment.java */
/* renamed from: com.sec.chaton.event.i */
/* loaded from: classes.dex */
public class C1467i extends PagerAdapter {

    /* renamed from: a */
    String f5445a = "";

    /* renamed from: b */
    final /* synthetic */ NewFeatureFragment f5446b;

    public C1467i(NewFeatureFragment newFeatureFragment) {
        this.f5446b = newFeatureFragment;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView((RelativeLayout) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void finishUpdate(View view) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.f5446b.f5426c.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        int i2 = 0;
        RelativeLayout relativeLayout = new RelativeLayout(this.f5446b.f5430g);
        this.f5446b.f5434k = new WebView(this.f5446b.f5430g);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.f5446b.f5434k.clearCache(false);
        this.f5446b.f5434k.setLayoutParams(layoutParams);
        this.f5446b.f5434k.getSettings().setJavaScriptEnabled(true);
        this.f5446b.f5434k.setVerticalScrollBarEnabled(false);
        this.f5446b.f5434k.setHorizontalScrollBarEnabled(false);
        this.f5446b.f5434k.getSettings().setBuiltInZoomControls(true);
        this.f5446b.f5434k.requestFocusFromTouch();
        this.f5446b.f5434k.setWebChromeClient(new WebChromeClient());
        this.f5446b.f5434k.getSettings().setLoadsImagesAutomatically(true);
        this.f5446b.f5434k.setWebViewClient(new WebViewClient());
        while (true) {
            int i3 = i2;
            if (i3 >= this.f5446b.f5432i) {
                this.f5446b.f5434k.setWebViewClient(new C1468j(this));
                relativeLayout.addView(this.f5446b.f5434k);
                ((ViewPager) view).addView(relativeLayout);
                relativeLayout.setTag(Integer.valueOf(i));
                return relativeLayout;
            }
            if (i == i3) {
                this.f5446b.f5434k.loadUrl((String) this.f5446b.f5433j.get(i3));
                if (this.f5446b.f5432i > 1) {
                    this.f5446b.m6375a();
                }
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == ((RelativeLayout) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public Parcelable saveState() {
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void startUpdate(View view) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }
}
