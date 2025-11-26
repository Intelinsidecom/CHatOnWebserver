package com.sec.chaton.settings;

import android.media.RingtoneManager;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;

/* compiled from: FragmentRingToneView.java */
/* renamed from: com.sec.chaton.settings.ce */
/* loaded from: classes.dex */
class C1280ce implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1279cd f4826a;

    C1280ce(AsyncTaskC1279cd asyncTaskC1279cd) {
        this.f4826a = asyncTaskC1279cd;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C1786r.m6063c("position = " + i, getClass().getSimpleName());
        if (i == 0) {
            this.f4826a.f4825a.f4636g = RingtoneManager.getRingtone(this.f4826a.f4825a.getActivity(), RingtoneManager.getDefaultUri(2));
            this.f4826a.f4825a.f4636g.play();
            this.f4826a.f4825a.f4640k = this.f4826a.f4825a.f4636g.getTitle(this.f4826a.f4825a.getActivity());
            SettingFragment.m4705b(this.f4826a.f4825a.f4640k);
            this.f4826a.f4825a.f4641l = RingtoneManager.getDefaultUri(2).toString();
            return;
        }
        if (i == 1) {
            this.f4826a.f4825a.f4640k = this.f4826a.f4825a.getString(R.string.ringtone_silent);
            this.f4826a.f4825a.f4641l = "Silent";
            SettingFragment.m4705b(this.f4826a.f4825a.getString(R.string.ringtone_silent));
            return;
        }
        this.f4826a.f4825a.f4636g = this.f4826a.f4825a.f4635f.getRingtone(i - 2);
        this.f4826a.f4825a.f4636g.play();
        if (i < this.f4826a.f4825a.f4634e.length) {
            this.f4826a.f4825a.f4640k = this.f4826a.f4825a.f4634e[i];
        } else {
            C1786r.m6054a("arrayindexounofbounded", getClass().getSimpleName());
            this.f4826a.f4825a.f4640k = "";
        }
        this.f4826a.f4825a.f4641l = this.f4826a.f4825a.f4635f.getRingtoneUri(i - 2).toString();
        SettingFragment.m4705b(this.f4826a.f4825a.f4640k);
    }
}
