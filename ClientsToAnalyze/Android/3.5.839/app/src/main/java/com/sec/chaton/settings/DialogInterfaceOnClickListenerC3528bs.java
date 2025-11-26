package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.content.res.Resources;
import com.sec.chaton.R;
import com.sec.chaton.util.C4809aa;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.util.Calendar;

/* compiled from: ActivityNoti2.java */
/* renamed from: com.sec.chaton.settings.bs */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3528bs implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti2 f13016a;

    DialogInterfaceOnClickListenerC3528bs(ActivityNoti2 activityNoti2) {
        this.f13016a = activityNoti2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        Calendar calendar = Calendar.getInstance();
        switch (i) {
            case 0:
                long jCurrentTimeMillis = System.currentTimeMillis();
                C4809aa.m18104a().m18124a("Setting mute hour start Long", Long.valueOf(jCurrentTimeMillis));
                C4809aa.m18104a().m18124a("Setting mute hour end Long", Long.valueOf(3600000 + jCurrentTimeMillis));
                C4809aa.m18104a().m18126b("Setting mute type", (Integer) 0);
                C5179v.m19810a(CommonApplication.m18732r(), R.string.settings_mute_set_toast, 0).show();
                this.f13016a.m13440d();
                break;
            case 1:
                calendar.add(5, 1);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(calendar.get(1), calendar.get(2), calendar.get(5), 7, 0);
                C4809aa.m18104a().m18124a("Setting mute hour start Long", Long.valueOf(calendar.getTimeInMillis()));
                C4809aa.m18104a().m18124a("Setting mute hour end Long", Long.valueOf(calendar2.getTimeInMillis()));
                C4809aa.m18104a().m18126b("Setting mute type", (Integer) 1);
                C5179v.m19810a(CommonApplication.m18732r(), R.string.settings_mute_set_toast, 0).show();
                this.f13016a.m13440d();
                break;
            case 2:
                this.f13016a.m13438c();
                break;
            case 3:
                C4809aa.m18104a().m18126b("Setting mute type", (Integer) 3);
                C4809aa.m18104a().m18123a("Setting mute hour start Long");
                C4809aa.m18104a().m18123a("Setting mute hour end Long");
                C4809aa.m18104a().m18123a("Setting mute repeat");
                this.f13016a.m13440d();
                break;
        }
        this.f13016a.f12551a.dismiss();
    }
}
