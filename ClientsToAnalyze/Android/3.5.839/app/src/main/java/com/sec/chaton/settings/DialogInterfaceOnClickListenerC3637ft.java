package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.media.Ringtone;
import android.net.Uri;
import com.sec.chaton.util.C4847bl;

/* compiled from: RingtonePreference2.java */
/* renamed from: com.sec.chaton.settings.ft */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3637ft implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RingtonePreference2 f13198a;

    DialogInterfaceOnClickListenerC3637ft(RingtonePreference2 ringtonePreference2) {
        this.f13198a = ringtonePreference2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Ringtone ringtone;
        this.f13198a.m13672h();
        this.f13198a.f12818b.stopPreviousRingtone();
        if (!C4847bl.m18333a() && dialogInterface != null) {
            this.f13198a.f12824h = null;
            if (i < this.f13198a.f12820d.size()) {
                this.f13198a.f12824h = (C3632fo) this.f13198a.f12820d.get(i);
                if (this.f13198a.f12824h != null) {
                    switch (this.f13198a.f12824h.m13910a()) {
                        case SYSTEM:
                            if (this.f13198a.f12824h.m13912c() != null && (ringtone = this.f13198a.f12818b.getRingtone(this.f13198a.f12824h.m13913d())) != null) {
                                ringtone.play();
                                break;
                            }
                            break;
                        case EMBED:
                            if (this.f13198a.f12821e == null) {
                                this.f13198a.m13666e();
                            }
                            int iM13913d = this.f13198a.f12824h.m13913d();
                            if (iM13913d > 0 && !this.f13198a.f12821e.m11427a(iM13913d, String.valueOf(iM13913d))) {
                                this.f13198a.f12821e.m11426a(String.valueOf(iM13913d));
                                break;
                            }
                            break;
                        case DOWNLOAD:
                            if (this.f13198a.f12821e == null) {
                                this.f13198a.m13666e();
                            }
                            Uri uriM13912c = this.f13198a.f12824h.m13912c();
                            if (uriM13912c != null && !this.f13198a.f12821e.m11428a(uriM13912c.getPath(), uriM13912c.getPath())) {
                                this.f13198a.f12821e.m11426a(uriM13912c.getPath());
                                break;
                            }
                            break;
                    }
                }
            }
        }
    }
}
