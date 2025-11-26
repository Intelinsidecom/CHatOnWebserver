package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.settings.downloads.C2642q;
import com.sec.chaton.util.C3250y;
import java.io.IOException;

/* compiled from: AMSPlayerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.by */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3504by implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSPlayerFragment f12898a;

    DialogInterfaceOnClickListenerC3504by(AMSPlayerFragment aMSPlayerFragment) {
        this.f12898a = aMSPlayerFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            C2642q.m9641c(this.f12898a.getActivity(), EnumC1327e.Template, this.f12898a.f12808x);
        } catch (IOException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, getClass().getName());
            }
        }
        this.f12898a.mo12415c();
    }
}
