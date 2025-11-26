package com.sec.chaton.smsplugin.multimedia.vcalendar;

import android.os.HandlerThread;
import com.sec.chaton.multimedia.vcalendar.C2885a;

/* compiled from: MmsVCalendarDetailFragment.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.vcalendar.b */
/* loaded from: classes.dex */
class HandlerThreadC3938b extends HandlerThread {

    /* renamed from: a */
    final /* synthetic */ MmsVCalendarDetailFragment f14199a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerThreadC3938b(MmsVCalendarDetailFragment mmsVCalendarDetailFragment, String str) {
        super(str);
        this.f14199a = mmsVCalendarDetailFragment;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() throws Throwable {
        String strM12047a = C2885a.m12044a().m12047a(this.f14199a.f14175j, 1);
        if (strM12047a == null) {
            if (this.f14199a.f14179n != null) {
                this.f14199a.f14179n.finish();
                return;
            }
            return;
        }
        this.f14199a.m15197a(strM12047a);
    }
}
