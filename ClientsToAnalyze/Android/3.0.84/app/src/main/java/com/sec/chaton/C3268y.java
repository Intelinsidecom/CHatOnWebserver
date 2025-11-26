package com.sec.chaton;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.settings.ActivityDownloads;
import com.sec.chaton.specialbuddy.ChatONLiveEventActivity;
import com.sec.chaton.specialbuddy.ChatONLiveMainActivity;

/* compiled from: PlusFragment.java */
/* renamed from: com.sec.chaton.y */
/* loaded from: classes.dex */
class C3268y implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ PlusFragment f11793a;

    C3268y(PlusFragment plusFragment) {
        this.f11793a = plusFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = ((C0430ah) this.f11793a.f716n.get(i)).f1493b;
        Intent intent = new Intent();
        switch (i2) {
            case R.string.setting_events /* 2131427957 */:
                intent = new Intent(this.f11793a.getActivity(), (Class<?>) ChatONLiveEventActivity.class).setFlags(67108864);
                break;
            case R.string.settings_title_downloads /* 2131428103 */:
                intent = new Intent(this.f11793a.getActivity(), (Class<?>) ActivityDownloads.class);
                break;
            case R.string.more_live_partner_button_name /* 2131428282 */:
                intent = new Intent(this.f11793a.getActivity(), (Class<?>) ChatONLiveMainActivity.class);
                break;
        }
        this.f11793a.startActivity(intent);
    }
}
