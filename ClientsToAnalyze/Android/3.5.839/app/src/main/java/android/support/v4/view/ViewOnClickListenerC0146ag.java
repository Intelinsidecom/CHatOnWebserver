package android.support.v4.view;

import android.view.View;

/* compiled from: PagerTabStrip.java */
/* renamed from: android.support.v4.view.ag */
/* loaded from: classes.dex */
class ViewOnClickListenerC0146ag implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PagerTabStrip f463a;

    ViewOnClickListenerC0146ag(PagerTabStrip pagerTabStrip) {
        this.f463a = pagerTabStrip;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f463a.f368a.setCurrentItem(this.f463a.f368a.m424c() + 1);
    }
}
