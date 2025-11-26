package com.sec.vip.amschaton;

import android.content.res.Resources;
import android.view.View;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.vip.amschaton.am */
/* loaded from: classes.dex */
class ViewOnClickListenerC0639am implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerActivity f4250a;

    ViewOnClickListenerC0639am(AMSPlayerActivity aMSPlayerActivity) {
        this.f4250a = aMSPlayerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, Resources.NotFoundException {
        if (!this.f4250a.m3713c()) {
            ChatONLogWriter.m3506b("Loading resources!", getClass().getSimpleName());
        } else if ((this.f4250a.f4086a.m4199e() & 1) == 1) {
            this.f4250a.m4049q();
            this.f4250a.m4047o();
        } else {
            this.f4250a.m4050r();
            this.f4250a.m4046n();
        }
    }
}
