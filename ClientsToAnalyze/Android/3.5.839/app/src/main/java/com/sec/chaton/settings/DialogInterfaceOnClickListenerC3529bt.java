package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.content.res.Resources;
import com.sec.chaton.R;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: ActivityNoti2.java */
/* renamed from: com.sec.chaton.settings.bt */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3529bt implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti2 f13017a;

    DialogInterfaceOnClickListenerC3529bt(ActivityNoti2 activityNoti2) {
        this.f13017a = activityNoti2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        if (this.f13017a.f12552b != null) {
            C3575dl c3575dlM13895a = this.f13017a.f12552b.m13895a();
            if (c3575dlM13895a.m13856a() > c3575dlM13895a.m13857b()) {
                c3575dlM13895a.m13858c();
            } else if (c3575dlM13895a.m13857b() < System.currentTimeMillis()) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("end time is expired. set to next day", "Mute Manually");
                }
                c3575dlM13895a.m13859d();
                c3575dlM13895a.m13858c();
            }
            C4809aa.m18104a().m18124a("Setting mute hour start Long", Long.valueOf(c3575dlM13895a.m13856a()));
            C4809aa.m18104a().m18124a("Setting mute hour end Long", Long.valueOf(c3575dlM13895a.m13857b()));
            C4809aa.m18104a().m18126b("Setting mute type", (Integer) 2);
            C4809aa.m18104a().m18125b("Setting mute repeat", Boolean.valueOf(c3575dlM13895a.m13860e()));
            if (this.f13017a.f12552b.isShowing()) {
                this.f13017a.f12552b.setDismissMessage(null);
                this.f13017a.f12552b.dismiss();
            }
            C5179v.m19810a(CommonApplication.m18732r(), R.string.settings_mute_set_toast, 0).show();
            this.f13017a.m13440d();
        }
    }
}
