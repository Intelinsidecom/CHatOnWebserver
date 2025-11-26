package com.sec.vip.amschaton.ics;

import android.content.res.Resources;
import android.view.View;
import com.sec.chaton.util.C1341p;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bt */
/* loaded from: classes.dex */
class ViewOnClickListenerC1516bt implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f5342a;

    ViewOnClickListenerC1516bt(AMSPlayerActivity aMSPlayerActivity) {
        this.f5342a = aMSPlayerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        if (this.f5342a.m4740c()) {
            if (this.f5342a.f5251w) {
                if ((this.f5342a.f4701a.m5642h() & 1) == 1) {
                    if (view == this.f5342a.f5248t || view == this.f5342a.f4702b) {
                        this.f5342a.m5493d(false);
                        this.f5342a.m5522o();
                        return;
                    }
                    return;
                }
                if (view == this.f5342a.f5248t || view == this.f5342a.f5247s) {
                    this.f5342a.m5496e(false);
                    this.f5342a.m5520n();
                    return;
                }
                return;
            }
            if ((this.f5342a.f4701a.m5642h() & 1) == 1) {
                this.f5342a.m5499f(true);
                this.f5342a.m5493d(false);
                this.f5342a.m5522o();
                return;
            }
            if (view == this.f5342a.f5248t || view == this.f5342a.f5247s) {
                this.f5342a.m5496e(false);
                if (this.f5342a.f5252x) {
                    if (this.f5342a.f5254z != null) {
                        this.f5342a.f5254z.removeCallbacks(this.f5342a.f5241H);
                    }
                    this.f5342a.m5501g(true);
                }
                this.f5342a.m5520n();
                return;
            }
            if (this.f5342a.f5252x) {
                if (this.f5342a.f5254z != null) {
                    this.f5342a.f5254z.removeCallbacks(this.f5342a.f5241H);
                }
                this.f5342a.m5501g(true);
                return;
            }
            this.f5342a.m5499f(true);
            return;
        }
        C1341p.m4658b("Loading resources!", getClass().getSimpleName());
    }
}
