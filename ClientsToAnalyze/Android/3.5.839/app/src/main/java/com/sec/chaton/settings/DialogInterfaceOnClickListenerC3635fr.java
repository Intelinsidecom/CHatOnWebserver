package com.sec.chaton.settings;

import android.content.DialogInterface;
import com.sec.chaton.util.C4809aa;

/* compiled from: RingtonePreference2.java */
/* renamed from: com.sec.chaton.settings.fr */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3635fr implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RingtonePreference2 f13196a;

    DialogInterfaceOnClickListenerC3635fr(RingtonePreference2 ringtonePreference2) {
        this.f13196a = ringtonePreference2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f13196a.f12824h != null) {
            C4809aa.m18104a().m18128b("Ringtone title", this.f13196a.f12824h.m13911b());
            if (this.f13196a.f12824h.m13912c() != null) {
                this.f13196a.callChangeListener(this.f13196a.f12824h.m13912c().toString());
            } else {
                this.f13196a.callChangeListener(null);
            }
        }
    }
}
