package com.sec.chaton.localbackup;

import android.view.View;
import android.widget.CheckBox;
import com.sec.chaton.util.C4809aa;

/* compiled from: ActivityLocalBackup.java */
/* renamed from: com.sec.chaton.localbackup.i */
/* loaded from: classes.dex */
class ViewOnClickListenerC2549i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityLocalBackup f9155a;

    ViewOnClickListenerC2549i(ActivityLocalBackup activityLocalBackup) {
        this.f9155a = activityLocalBackup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C4809aa.m18105a("backup_sms_popup", Boolean.valueOf(((CheckBox) view).isChecked()));
    }
}
