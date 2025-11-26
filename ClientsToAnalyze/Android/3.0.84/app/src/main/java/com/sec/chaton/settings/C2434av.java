package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.preference.Preference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.av */
/* loaded from: classes.dex */
class C2434av implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f9294a;

    C2434av(ActivityNoti activityNoti) {
        this.f9294a = activityNoti;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        View viewInflate = LayoutInflater.from(this.f9294a.f9006k).inflate(R.layout.layout_popup_type_list_view, (ViewGroup) null);
        ListView listView = (ListView) viewInflate.findViewById(R.id.listView);
        listView.setAdapter((ListAdapter) new C2444be(this.f9294a));
        listView.setItemChecked(this.f9294a.f9014s, true);
        listView.setOnItemClickListener(new C2435aw(this));
        this.f9294a.f9002g = AbstractC3271a.m11494a(this.f9294a.f9006k).mo11495a(R.string.settings_popup_type_title).mo11508b(viewInflate).mo11502a(true).mo11510b(this.f9294a.getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC2436ax(this)).mo11501a(this.f9294a.getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
        return true;
    }
}
