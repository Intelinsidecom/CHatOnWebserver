package com.sec.vip.amschaton.honeycomb;

import android.content.res.Resources;
import android.view.View;
import com.sec.chaton.util.C1786r;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.bl */
/* loaded from: classes.dex */
class ViewOnClickListenerC1931bl implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7071a;

    ViewOnClickListenerC1931bl(AMSPlayerActivity aMSPlayerActivity) {
        this.f7071a = aMSPlayerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, Resources.NotFoundException {
        if (this.f7071a.m6263b()) {
            if (this.f7071a.f6688l != null) {
                if (this.f7071a.f6993y) {
                    if ((this.f7071a.f6688l.m6514g() & 1) == 1) {
                        if (view == this.f7071a.f6990v || view == this.f7071a.f6689m) {
                            this.f7071a.m6732e(false);
                            this.f7071a.m6737g(false);
                            this.f7071a.m6763r();
                            return;
                        }
                        return;
                    }
                    if (view == this.f7071a.f6990v || view == this.f7071a.f6989u) {
                        this.f7071a.m6732e(true);
                        this.f7071a.m6741h(false);
                        this.f7071a.m6762q();
                        return;
                    }
                    return;
                }
                if ((this.f7071a.f6688l.m6514g() & 1) == 1) {
                    this.f7071a.m6745i(true);
                    this.f7071a.m6737g(false);
                    this.f7071a.m6763r();
                    return;
                }
                if (view == this.f7071a.f6990v || view == this.f7071a.f6989u) {
                    this.f7071a.m6741h(false);
                    if (this.f7071a.f6973A) {
                        if (this.f7071a.f6975C != null) {
                            this.f7071a.f6975C.removeCallbacks(this.f7071a.f6982J);
                        }
                        this.f7071a.m6748j(true);
                    }
                    this.f7071a.m6762q();
                    return;
                }
                if (this.f7071a.f6973A) {
                    if (this.f7071a.f6975C != null) {
                        this.f7071a.f6975C.removeCallbacks(this.f7071a.f6982J);
                    }
                    this.f7071a.m6748j(true);
                    return;
                }
                this.f7071a.m6745i(true);
                return;
            }
            C1786r.m6061b("mViewer is null!", getClass().getSimpleName());
            return;
        }
        C1786r.m6061b("Loading resources!", getClass().getSimpleName());
    }
}
