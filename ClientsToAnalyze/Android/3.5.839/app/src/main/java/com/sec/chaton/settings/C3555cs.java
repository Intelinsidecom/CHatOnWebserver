package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.cs */
/* loaded from: classes.dex */
class C3555cs implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f13044a;

    C3555cs(ActivityPrivacy activityPrivacy) {
        this.f13044a = activityPrivacy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (this.f13044a.f12646x.booleanValue()) {
            C5179v.m19810a(this.f13044a.f12624b, R.string.popup_no_network_connection, 0).show();
        } else {
            this.f13044a.f12645w = AbstractC4932a.m18733a(this.f13044a).mo18740a(this.f13044a.getString(R.string.setting_privacy_show_my_profile_picture)).mo18755c(this.f13044a.getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18743a(new String[]{this.f13044a.getString(R.string.privacy_contacts_only), this.f13044a.getString(R.string.setting_downloads_font_filter_all)}, this.f13044a.f12644v, new DialogInterfaceOnClickListenerC3556ct(this)).mo18752b();
        }
        return true;
    }
}
