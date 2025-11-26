package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.content.res.Resources;
import com.sec.chaton.R;
import com.sec.chaton.util.C3159aa;
import com.sec.widget.C3641ai;
import java.util.Calendar;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.bc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2442bc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f9302a;

    DialogInterfaceOnClickListenerC2442bc(ActivityNoti activityNoti) {
        this.f9302a = activityNoti;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        Calendar calendar = Calendar.getInstance();
        switch (i) {
            case 0:
                long jCurrentTimeMillis = System.currentTimeMillis();
                C3159aa.m10962a().m10982a("Setting mute hour start Long", Long.valueOf(jCurrentTimeMillis));
                C3159aa.m10962a().m10982a("Setting mute hour end Long", Long.valueOf(3600000 + jCurrentTimeMillis));
                C3159aa.m10962a().m10984b("Setting mute type", (Integer) 0);
                C3641ai.m13210a(this.f9302a.f9006k, R.string.settings_mute_set_toast, 0).show();
                this.f9302a.m8995c();
                break;
            case 1:
                calendar.add(5, 1);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(calendar.get(1), calendar.get(2), calendar.get(5), 7, 0);
                C3159aa.m10962a().m10982a("Setting mute hour start Long", Long.valueOf(calendar.getTimeInMillis()));
                C3159aa.m10962a().m10982a("Setting mute hour end Long", Long.valueOf(calendar2.getTimeInMillis()));
                C3159aa.m10962a().m10984b("Setting mute type", (Integer) 1);
                C3641ai.m13210a(this.f9302a.f9006k, R.string.settings_mute_set_toast, 0).show();
                this.f9302a.m8995c();
                break;
            case 2:
                this.f9302a.m8991b();
                break;
            case 3:
                C3159aa.m10962a().m10984b("Setting mute type", (Integer) 3);
                C3159aa.m10962a().m10981a("Setting mute hour start Long");
                C3159aa.m10962a().m10981a("Setting mute hour end Long");
                C3159aa.m10962a().m10981a("Setting mute repeat");
                this.f9302a.m8995c();
                break;
        }
        this.f9302a.f9002g.dismiss();
    }
}
