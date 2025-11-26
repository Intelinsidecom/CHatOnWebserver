package com.sec.chaton.settings;

import android.content.DialogInterface;
import com.sec.chaton.util.C3159aa;

/* compiled from: RingtonePreference2.java */
/* renamed from: com.sec.chaton.settings.et */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2683et implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RingtonePreference2 f9976a;

    DialogInterfaceOnClickListenerC2683et(RingtonePreference2 ringtonePreference2) {
        this.f9976a = ringtonePreference2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f9976a.f9249h != null) {
            C3159aa.m10962a().m10986b("Ringtone title", this.f9976a.f9249h.m9686b());
            if (this.f9976a.f9249h.m9687c() != null) {
                this.f9976a.callChangeListener(this.f9976a.f9249h.m9687c().toString());
            } else {
                this.f9976a.callChangeListener(null);
            }
        }
    }
}
