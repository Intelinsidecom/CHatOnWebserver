package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.Preference;
import com.sec.chaton.C0062R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;

/* renamed from: com.sec.chaton.settings.ba */
/* loaded from: classes.dex */
class HandlerC0479ba extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivitySettings f3170a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0479ba(ActivitySettings activitySettings, Looper looper) {
        super(looper);
        this.f3170a = activitySettings;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1003) {
            boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
            Preference preferenceFindPreference = this.f3170a.findPreference("pref_item_push_status");
            if (ChatONPref.m3519a().getInt(ChatONLogWriter.f3623a, 0) > 0) {
                preferenceFindPreference.setOnPreferenceClickListener(new C0487bi(this));
            }
            if (GlobalApplication.f1895b == null) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                this.f3170a.m3133a(this.f3170a.getString(C0062R.string.settings_push_status_available), preferenceFindPreference, this.f3170a.getResources().getColor(C0062R.color.blue_color_021));
            } else {
                this.f3170a.m3133a(this.f3170a.getString(C0062R.string.settings_push_status_unavailable), preferenceFindPreference, this.f3170a.getResources().getColor(C0062R.color.blue_color_021));
            }
        }
    }
}
