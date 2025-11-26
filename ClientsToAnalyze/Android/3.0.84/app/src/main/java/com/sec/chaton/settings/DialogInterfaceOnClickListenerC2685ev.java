package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.media.Ringtone;
import android.net.Uri;
import com.sec.chaton.util.C3197bl;

/* compiled from: RingtonePreference2.java */
/* renamed from: com.sec.chaton.settings.ev */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2685ev implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RingtonePreference2 f9978a;

    DialogInterfaceOnClickListenerC2685ev(RingtonePreference2 ringtonePreference2) {
        this.f9978a = ringtonePreference2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Ringtone ringtone;
        this.f9978a.m9183g();
        this.f9978a.f9243b.stopPreviousRingtone();
        if (!C3197bl.m11159a() && dialogInterface != null) {
            this.f9978a.f9249h = null;
            if (i < this.f9978a.f9245d.size()) {
                this.f9978a.f9249h = (C2680eq) this.f9978a.f9245d.get(i);
                if (this.f9978a.f9249h != null) {
                    switch (this.f9978a.f9249h.m9685a()) {
                        case SYSTEM:
                            if (this.f9978a.f9249h.m9687c() != null && (ringtone = this.f9978a.f9243b.getRingtone(this.f9978a.f9249h.m9688d())) != null) {
                                ringtone.play();
                                break;
                            }
                            break;
                        case EMBED:
                            if (this.f9978a.f9246e == null) {
                                this.f9978a.m9179e();
                            }
                            int iM9688d = this.f9978a.f9249h.m9688d();
                            if (iM9688d > 0 && !this.f9978a.f9246e.m7287a(iM9688d, String.valueOf(iM9688d))) {
                                this.f9978a.f9246e.m7286a(String.valueOf(iM9688d));
                                break;
                            }
                            break;
                        case DOWNLOAD:
                            if (this.f9978a.f9246e == null) {
                                this.f9978a.m9179e();
                            }
                            Uri uriM9687c = this.f9978a.f9249h.m9687c();
                            if (uriM9687c != null && !this.f9978a.f9246e.m7288a(uriM9687c.getPath(), uriM9687c.getPath())) {
                                this.f9978a.f9246e.m7286a(uriM9687c.getPath());
                                break;
                            }
                            break;
                    }
                }
            }
        }
    }
}
