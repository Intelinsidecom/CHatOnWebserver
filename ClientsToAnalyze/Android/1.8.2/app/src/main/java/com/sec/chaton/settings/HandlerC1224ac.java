package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.ac */
/* loaded from: classes.dex */
class HandlerC1224ac extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f4763a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1224ac(ActivityNoti activityNoti, Looper looper) {
        super(looper);
        this.f4763a = activityNoti;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f4763a.getActivity() == null) {
            C1786r.m6061b("handleMessage, activity NULL", getClass().getSimpleName());
            return;
        }
        if (message.what == 1003) {
            boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
            Preference preferenceA = this.f4763a.m6121a("pref_item_push_status");
            if (GlobalApplication.f2775a == null) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                this.f4763a.m4507a(this.f4763a.getString(R.string.settings_push_status_available), preferenceA, this.f4763a.getResources().getColor(R.color.ics_orange_font_color));
            } else {
                this.f4763a.m4507a(this.f4763a.getString(R.string.settings_push_status_unavailable), preferenceA, this.f4763a.getResources().getColor(R.color.ics_orange_font_color));
            }
        }
    }
}
