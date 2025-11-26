package com.sec.chaton.settings;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.downloads.ActivitySoundDownloads;
import com.sec.common.CommonApplication;

/* compiled from: RingtonePreference2.java */
/* renamed from: com.sec.chaton.settings.es */
/* loaded from: classes.dex */
class ViewOnClickListenerC2682es implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RingtonePreference2 f9975a;

    ViewOnClickListenerC2682es(RingtonePreference2 ringtonePreference2) {
        this.f9975a = ringtonePreference2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f9975a.getContext().startActivity(new Intent(CommonApplication.m11493l(), (Class<?>) ActivitySoundDownloads.class));
        if (this.f9975a.f9244c != null) {
            this.f9975a.f9244c.dismiss();
        }
    }
}
