package com.sec.chaton.settings;

import android.content.res.Resources;
import android.preference.Preference;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.EnumC4864cb;

/* compiled from: ActivityNoti2.java */
/* renamed from: com.sec.chaton.settings.bl */
/* loaded from: classes.dex */
class C3521bl implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti2 f13009a;

    C3521bl(ActivityNoti2 activityNoti2) {
        this.f13009a = activityNoti2;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) throws Resources.NotFoundException {
        this.f13009a.f12541A = ((Boolean) obj).booleanValue();
        if (this.f13009a.f12541A) {
            C1813b.m8906b().m8934b(C1813b.f6835d);
        } else {
            C1813b.m8906b().m8938d();
        }
        this.f13009a.m13426a();
        this.f13009a.f12557g.m18125b("Setting Notification", Boolean.valueOf(this.f13009a.f12541A));
        if (C4859bx.m18415j() && this.f13009a.f12550J) {
            if (this.f13009a.f12541A) {
                C4859bx.m18383a(EnumC4864cb.agree, this.f13009a);
                return true;
            }
            C4859bx.m18383a(EnumC4864cb.disagree, this.f13009a);
            return true;
        }
        return true;
    }
}
