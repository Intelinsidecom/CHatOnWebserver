package android.support.v4.view;

import android.view.View;

/* compiled from: PagerTabStrip.java */
/* renamed from: android.support.v4.view.af */
/* loaded from: classes.dex */
class ViewOnClickListenerC0145af implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PagerTabStrip f462a;

    ViewOnClickListenerC0145af(PagerTabStrip pagerTabStrip) {
        this.f462a = pagerTabStrip;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f462a.f368a.setCurrentItem(this.f462a.f368a.m424c() - 1);
    }
}
