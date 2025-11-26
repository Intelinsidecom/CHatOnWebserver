package com.sec.vip.amschaton.ics;

import android.content.res.Resources;
import android.view.View;
import com.sec.chaton.util.C1786r;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bm */
/* loaded from: classes.dex */
class ViewOnClickListenerC2017bm implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f7301a;

    ViewOnClickListenerC2017bm(AMSPlayerActivity aMSPlayerActivity) {
        this.f7301a = aMSPlayerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, Resources.NotFoundException {
        if (this.f7301a.m6263b()) {
            if (this.f7301a.f7222y) {
                if ((this.f7301a.f6688l.m6514g() & 1) == 1) {
                    if (view == this.f7301a.f7219v) {
                        this.f7301a.m7053d(false);
                        this.f7301a.m7083p();
                        return;
                    }
                    return;
                }
                if (view == this.f7301a.f7219v || view == this.f7301a.f7218u) {
                    this.f7301a.m7055e(false);
                    this.f7301a.m7081o();
                    return;
                }
                return;
            }
            if ((this.f7301a.f6688l.m6514g() & 1) == 1) {
                this.f7301a.m7057f(true);
                this.f7301a.m7053d(false);
                this.f7301a.m7083p();
                return;
            }
            if (view == this.f7301a.f7219v || view == this.f7301a.f7218u) {
                this.f7301a.m7055e(false);
                if (this.f7301a.f7223z) {
                    if (this.f7301a.f7204B != null) {
                        this.f7301a.f7204B.removeCallbacks(this.f7301a.f7212J);
                    }
                    this.f7301a.m7061g(true);
                }
                this.f7301a.m7081o();
                return;
            }
            if (this.f7301a.f7223z) {
                if (this.f7301a.f7204B != null) {
                    this.f7301a.f7204B.removeCallbacks(this.f7301a.f7212J);
                }
                this.f7301a.m7061g(true);
                return;
            }
            this.f7301a.m7057f(true);
            return;
        }
        C1786r.m6061b("Loading resources!", getClass().getSimpleName());
    }
}
