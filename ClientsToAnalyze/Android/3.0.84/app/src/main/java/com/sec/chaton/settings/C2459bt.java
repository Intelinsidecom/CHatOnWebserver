package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.bt */
/* loaded from: classes.dex */
class C2459bt implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f9319a;

    C2459bt(ActivityPrivacy activityPrivacy) {
        this.f9319a = activityPrivacy;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (this.f9319a.f9088z.booleanValue()) {
            C3641ai.m13210a(this.f9319a.f9064b, R.string.popup_no_network_connection, 0).show();
        } else {
            this.f9319a.f9087y = AbstractC3271a.m11494a(this.f9319a).mo11500a(this.f9319a.getString(R.string.setting_privacy_show_my_profile_picture)).mo11510b(this.f9319a.getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11503a(new String[]{this.f9319a.getString(R.string.tab_buddies), this.f9319a.getString(R.string.setting_downloads_font_filter_all)}, this.f9319a.f9086x, new DialogInterfaceOnClickListenerC2460bu(this)).mo11512b();
        }
        return true;
    }
}
