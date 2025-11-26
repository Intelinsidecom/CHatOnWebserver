package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.l */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC0982l implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f3601a;

    DialogInterfaceOnKeyListenerC0982l(GeotagActivity geotagActivity) {
        this.f3601a = geotagActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 84) {
            return true;
        }
        if (i == 4) {
            this.f3601a.f3571i.dismiss();
            if (this.f3601a.f3564b != null) {
                this.f3601a.f3564b.removeCallbacks(this.f3601a.f3566d);
            }
            if (this.f3601a.f3565c != null) {
                this.f3601a.f3565c.removeCallbacks(this.f3601a.f3567e);
            }
            this.f3601a.finish();
            return true;
        }
        return false;
    }
}
