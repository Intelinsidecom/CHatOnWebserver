package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.dl */
/* loaded from: classes.dex */
class HandlerC1314dl extends Handler {

    /* renamed from: a */
    final /* synthetic */ SettingFragment f4889a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1314dl(SettingFragment settingFragment, Looper looper) {
        super(looper);
        this.f4889a = settingFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1003) {
            boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
            Preference preferenceA = this.f4889a.m6121a((CharSequence) "pref_item_push_status");
            if (GlobalApplication.f2775a == null) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                SettingFragment.m4708c(this.f4889a.getString(R.string.settings_push_status_available), preferenceA, this.f4889a.getResources().getColor(R.color.ics_orange_font_color));
            } else {
                SettingFragment.m4708c(this.f4889a.getString(R.string.settings_push_status_unavailable), preferenceA, this.f4889a.getResources().getColor(R.color.ics_orange_font_color));
            }
        }
    }
}
