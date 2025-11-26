package com.sec.chaton.event;

import android.os.Parcelable;
import android.support.v4.view.AbstractC0144ae;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

/* compiled from: NewFeatureFragment.java */
/* renamed from: com.sec.chaton.event.b */
/* loaded from: classes.dex */
public class C2321b extends AbstractC0144ae {

    /* renamed from: a */
    String f8274a = "";

    /* renamed from: b */
    final /* synthetic */ NewFeatureFragment f8275b;

    public C2321b(NewFeatureFragment newFeatureFragment) {
        this.f8275b = newFeatureFragment;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public void mo611a(View view, int i, Object obj) {
        ((ViewPager) view).removeView((RelativeLayout) obj);
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: b */
    public void mo614b(View view) {
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: b */
    public int mo612b() {
        return this.f8275b.f8246c.size();
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public Object mo608a(View view, int i) {
        int i2 = 0;
        RelativeLayout relativeLayout = new RelativeLayout(this.f8275b.f8249f);
        this.f8275b.f8253j = new WebView(this.f8275b.f8249f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.f8275b.f8253j.clearCache(false);
        this.f8275b.f8253j.setLayoutParams(layoutParams);
        this.f8275b.f8253j.getSettings().setJavaScriptEnabled(true);
        this.f8275b.f8253j.setVerticalScrollBarEnabled(false);
        this.f8275b.f8253j.setHorizontalScrollBarEnabled(false);
        this.f8275b.f8253j.getSettings().setBuiltInZoomControls(true);
        this.f8275b.f8253j.requestFocusFromTouch();
        this.f8275b.f8253j.setWebChromeClient(new WebChromeClient());
        this.f8275b.f8253j.getSettings().setLoadsImagesAutomatically(true);
        this.f8275b.f8253j.setWebViewClient(new WebViewClient());
        while (true) {
            int i3 = i2;
            if (i3 >= this.f8275b.f8251h) {
                this.f8275b.f8253j.setWebViewClient(new C2322c(this));
                relativeLayout.addView(this.f8275b.f8253j);
                ((ViewPager) view).addView(relativeLayout);
                relativeLayout.setTag(Integer.valueOf(i));
                return relativeLayout;
            }
            if (i == i3) {
                this.f8275b.f8253j.loadUrl((String) this.f8275b.f8252i.get(i3));
                if (this.f8275b.f8251h > 1) {
                    this.f8275b.m10236a();
                }
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public boolean mo80a(View view, Object obj) {
        return view.equals((RelativeLayout) obj);
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public void mo77a(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public Parcelable mo74a() {
        return null;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public void mo610a(View view) {
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public int mo607a(Object obj) {
        return -2;
    }
}
