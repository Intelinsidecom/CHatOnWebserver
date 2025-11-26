package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.ap */
/* loaded from: classes.dex */
class HandlerC1018ap extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f3619a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1018ap(ActivityNoti activityNoti, Looper looper) {
        super(looper);
        this.f3619a = activityNoti;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1003) {
            boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
            Preference preferenceFindPreference = this.f3619a.findPreference("pref_item_push_status");
            if (C1323bs.m4575a().getInt(C1341p.f4582f, 0) > 0) {
                preferenceFindPreference.setOnPreferenceClickListener(new C1012aj(this));
            }
            if (GlobalApplication.f2407a == null) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                this.f3619a.m3798a(this.f3619a.getString(R.string.settings_push_status_available), preferenceFindPreference, this.f3619a.getResources().getColor(R.color.buddy_list_item_status_changed));
            } else {
                this.f3619a.m3798a(this.f3619a.getString(R.string.settings_push_status_unavailable), preferenceFindPreference, this.f3619a.getResources().getColor(R.color.buddy_list_item_status_changed));
            }
        }
    }
}
