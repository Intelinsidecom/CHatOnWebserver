package com.sec.vip.amschaton.honeycomb;

import android.content.res.Resources;
import android.view.View;
import com.sec.chaton.util.C1341p;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.bi */
/* loaded from: classes.dex */
class ViewOnClickListenerC1440bi implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5075a;

    ViewOnClickListenerC1440bi(AMSPlayerActivity aMSPlayerActivity) {
        this.f5075a = aMSPlayerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        if (this.f5075a.m4740c()) {
            if (this.f5075a.f5007w) {
                if ((this.f5075a.f4701a.m5642h() & 1) == 1) {
                    if (view == this.f5075a.f5004t) {
                        this.f5075a.m5175f(false);
                        this.f5075a.m5199o();
                        return;
                    }
                    return;
                }
                if (view == this.f5075a.f5004t || view == this.f5075a.f5003s) {
                    this.f5075a.m5179g(false);
                    this.f5075a.m5197n();
                    return;
                }
                return;
            }
            if ((this.f5075a.f4701a.m5642h() & 1) == 1) {
                this.f5075a.m5182h(true);
                this.f5075a.m5175f(false);
                this.f5075a.m5199o();
                return;
            }
            if (view == this.f5075a.f5004t || view == this.f5075a.f5003s) {
                this.f5075a.m5179g(false);
                if (this.f5075a.f5009y) {
                    if (this.f5075a.f4988A != null) {
                        this.f5075a.f4988A.removeCallbacks(this.f5075a.f4997J);
                    }
                    this.f5075a.m5187i(true);
                }
                this.f5075a.m5197n();
                return;
            }
            if (this.f5075a.f5009y) {
                if (this.f5075a.f4988A != null) {
                    this.f5075a.f4988A.removeCallbacks(this.f5075a.f4997J);
                }
                this.f5075a.m5187i(true);
                return;
            }
            this.f5075a.m5182h(true);
            return;
        }
        C1341p.m4658b("Loading resources!", getClass().getSimpleName());
    }
}
