package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.msgsend.C1757q;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.o */
/* loaded from: classes.dex */
class C2717o implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f10040a;

    C2717o(ActivityChat activityChat) {
        this.f10040a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (this.f10040a.f8945g == null) {
            return false;
        }
        if (Boolean.valueOf(Boolean.parseBoolean(obj.toString())) == Boolean.TRUE) {
            C1757q.m7253c();
            this.f10040a.m8942a(this.f10040a.getResources().getString(R.string.setting_chat_autoresend_description_on), this.f10040a.f8945g, this.f10040a.getResources().getColor(R.color.buddy_list_item_status_changed));
        } else {
            C1757q.m7254d();
            this.f10040a.m8942a(this.f10040a.getResources().getString(R.string.setting_chat_autoresend_description_off), this.f10040a.f8945g, this.f10040a.getResources().getColor(R.color.buddy_list_item_status_changed));
        }
        return true;
    }
}
