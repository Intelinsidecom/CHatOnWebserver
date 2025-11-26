package com.sec.chaton.settings;

import android.preference.Preference;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: ActivityChat.java */
/* renamed from: com.sec.chaton.settings.p */
/* loaded from: classes.dex */
class C2718p implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChat f10041a;

    C2718p(ActivityChat activityChat) {
        this.f10041a = activityChat;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f10041a.f8941c);
        abstractC3271aM11494a.mo11495a(R.string.menu_chat_close);
        abstractC3271aM11494a.mo11509b(GlobalApplication.m6451b().getString(R.string.settings_chat_delete_old_chat_rooms_popup_text, 3));
        abstractC3271aM11494a.mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2720r(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2719q(this));
        abstractC3271aM11494a.mo11512b();
        return true;
    }
}
