package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import com.sec.chaton.util.C3250y;

/* compiled from: ProfileImageHistoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.br */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3119br implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3117bp f11352a;

    DialogInterfaceOnClickListenerC3119br(HandlerC3117bp handlerC3117bp) {
        this.f11352a = handlerC3117bp;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f11352a.f11350a.f11256p.m5929a(this.f11352a.f11350a.f11260v.getPath());
            this.f11352a.f11350a.f11254n.show();
            this.f11352a.f11350a.m10846l();
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
            this.f11352a.f11350a.m10852o();
        }
    }
}
