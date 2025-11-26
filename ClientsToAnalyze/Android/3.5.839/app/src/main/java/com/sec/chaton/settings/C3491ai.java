package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.msgsend.C2717y;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.ai */
/* loaded from: classes.dex */
class C3491ai implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f12979a;

    C3491ai(ActivityChat activityChat) {
        this.f12979a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (this.f12979a.f12505e == null) {
            return false;
        }
        if (Boolean.valueOf(Boolean.parseBoolean(obj.toString())) == Boolean.TRUE) {
            C2717y.m11399c();
            this.f12979a.m13373a(this.f12979a.getResources().getString(R.string.setting_chat_autoresend_description_on), this.f12979a.f12505e, this.f12979a.getResources().getColor(R.color.buddy_list_item_status_changed));
        } else {
            C2717y.m11401d();
            this.f12979a.m13373a(this.f12979a.getResources().getString(R.string.setting_chat_autoresend_description_off), this.f12979a.f12505e, this.f12979a.getResources().getColor(R.color.buddy_list_item_status_changed));
        }
        return true;
    }
}
