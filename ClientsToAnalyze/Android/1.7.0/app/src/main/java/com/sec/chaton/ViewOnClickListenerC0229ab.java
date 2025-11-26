package com.sec.chaton;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.registration.ActivityChatonVDisclaimer;
import com.sec.chaton.util.C1323bs;

/* compiled from: ChatONVDialog.java */
/* renamed from: com.sec.chaton.ab */
/* loaded from: classes.dex */
class ViewOnClickListenerC0229ab implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatONVDialog f563a;

    ViewOnClickListenerC0229ab(ChatONVDialog chatONVDialog) {
        this.f563a = chatONVDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1323bs.m4576a("ChatONVDiaglog", Boolean.valueOf(this.f563a.f238c.isChecked()));
        this.f563a.startActivity(new Intent(this.f563a, (Class<?>) ActivityChatonVDisclaimer.class));
        C1323bs.m4576a("ChatONVDownloadPopup", (Boolean) false);
        this.f563a.finish();
    }
}
