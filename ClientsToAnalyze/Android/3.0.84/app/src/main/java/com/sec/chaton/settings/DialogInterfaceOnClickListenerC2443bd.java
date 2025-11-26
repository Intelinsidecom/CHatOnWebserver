package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.content.res.Resources;
import com.sec.chaton.R;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.bd */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2443bd implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f9303a;

    DialogInterfaceOnClickListenerC2443bd(ActivityNoti activityNoti) {
        this.f9303a = activityNoti;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        C2480cn c2480cnM9255a = this.f9303a.f9003h.m9255a();
        if (c2480cnM9255a.m9217a() > c2480cnM9255a.m9218b()) {
            c2480cnM9255a.m9219c();
        } else if (c2480cnM9255a.m9218b() < System.currentTimeMillis()) {
            if (C3250y.f11735c) {
                C3250y.m11453c("end time is expired. set to next day", "Mute Manually");
            }
            c2480cnM9255a.m9220d();
            c2480cnM9255a.m9219c();
        }
        C3159aa.m10962a().m10982a("Setting mute hour start Long", Long.valueOf(c2480cnM9255a.m9217a()));
        C3159aa.m10962a().m10982a("Setting mute hour end Long", Long.valueOf(c2480cnM9255a.m9218b()));
        C3159aa.m10962a().m10984b("Setting mute type", (Integer) 2);
        C3159aa.m10962a().m10983b("Setting mute repeat", Boolean.valueOf(c2480cnM9255a.m9221e()));
        if (this.f9303a.f9003h != null && this.f9303a.f9003h.isShowing()) {
            this.f9303a.f9003h.setDismissMessage(null);
            this.f9303a.f9003h.dismiss();
        }
        C3641ai.m13210a(this.f9303a.f9006k, R.string.settings_mute_set_toast, 0).show();
        this.f9303a.m8995c();
    }
}
