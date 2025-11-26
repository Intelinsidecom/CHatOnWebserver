package com.sec.vip.amschaton;

import android.content.res.Resources;
import com.sec.vip.amschaton.Viewer;

/* renamed from: com.sec.vip.amschaton.an */
/* loaded from: classes.dex */
class C0640an implements Viewer.OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f4251a;

    C0640an(AMSPlayerActivity aMSPlayerActivity) {
        this.f4251a = aMSPlayerActivity;
    }

    @Override // com.sec.vip.amschaton.Viewer.OnCompletionListener
    /* renamed from: a */
    public void mo4203a() throws Resources.NotFoundException {
        this.f4251a.m4030d(false);
        this.f4251a.m4049q();
        this.f4251a.m4048p();
    }
}
