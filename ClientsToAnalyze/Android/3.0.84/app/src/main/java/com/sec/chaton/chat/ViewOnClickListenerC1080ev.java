package com.sec.chaton.chat;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: DuringCallController.java */
/* renamed from: com.sec.chaton.chat.ev */
/* loaded from: classes.dex */
class ViewOnClickListenerC1080ev implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1078et f4331a;

    ViewOnClickListenerC1080ev(C1078et c1078et) {
        this.f4331a = c1078et;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C3250y.m11450b("switch to V call", C1078et.f4319a);
        if (!C3171am.m11072j()) {
            C3641ai.m13210a(this.f4331a.f4320b, R.string.chatonv_unable_to_make_call, 0).show();
            C3250y.m11450b("can not switch to V call due to phone online", C1078et.f4319a);
        } else if (this.f4331a.f4327i != null) {
            this.f4331a.f4327i.m58g(this.f4331a.f4320b);
        }
    }
}
