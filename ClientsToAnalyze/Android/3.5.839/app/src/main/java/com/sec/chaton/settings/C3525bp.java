package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4864cb;

/* compiled from: ActivityNoti2.java */
/* renamed from: com.sec.chaton.settings.bp */
/* loaded from: classes.dex */
class C3525bp implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti2 f13013a;

    C3525bp(ActivityNoti2 activityNoti2) {
        this.f13013a = activityNoti2;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        this.f13013a.f12550J = ((Boolean) obj).booleanValue();
        if (C4904y.f17872b) {
            C4904y.m18639b("onPreferenceChange Service noti : " + ((Boolean) obj), getClass().getSimpleName());
        }
        if (this.f13013a.f12550J) {
            C4859bx.m18383a(EnumC4864cb.agree, this.f13013a);
            return true;
        }
        C4859bx.m18383a(EnumC4864cb.disagree, this.f13013a);
        return true;
    }
}
