package com.sec.vip.amschaton.fragment;

import android.view.View;
import com.sec.chaton.util.C3250y;

/* compiled from: AMSViewerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.dr */
/* loaded from: classes.dex */
class ViewOnClickListenerC3551dr implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSViewerFragment f12981a;

    ViewOnClickListenerC3551dr(AMSViewerFragment aMSViewerFragment) {
        this.f12981a = aMSViewerFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException {
        if (this.f12981a.f12795b == null) {
            C3250y.m11450b("mViewer is null!", getClass().getSimpleName());
            return;
        }
        if (this.f12981a.f12781N) {
            if ((this.f12981a.f12795b.m12336g() & 1) == 1) {
                if (view.equals(this.f12981a.f12769B) || view.equals(this.f12981a.f12796c)) {
                    this.f12981a.m12681g(false);
                    this.f12981a.m12675e(false);
                    this.f12981a.m12703e();
                    return;
                }
                return;
            }
            if (view.equals(this.f12981a.f12769B) || view.equals(this.f12981a.f12768A)) {
                this.f12981a.m12681g(true);
                this.f12981a.m12700b(false);
                this.f12981a.m12689k();
                return;
            }
            return;
        }
        if ((this.f12981a.f12795b.m12336g() & 1) == 1) {
            this.f12981a.m12671d(true);
            this.f12981a.m12675e(false);
            this.f12981a.m12703e();
            return;
        }
        if (!view.equals(this.f12981a.f12769B) && !view.equals(this.f12981a.f12768A)) {
            if (this.f12981a.f12789V) {
                if (this.f12981a.f12791X != null) {
                    this.f12981a.f12791X.removeCallbacks(this.f12981a.f12793Z);
                }
                this.f12981a.m12698a(true);
                return;
            }
            this.f12981a.m12671d(true);
            return;
        }
        this.f12981a.m12700b(false);
        if (this.f12981a.f12789V) {
            if (this.f12981a.f12791X != null) {
                this.f12981a.f12791X.removeCallbacks(this.f12981a.f12793Z);
            }
            this.f12981a.m12698a(true);
        }
        this.f12981a.m12689k();
    }
}
