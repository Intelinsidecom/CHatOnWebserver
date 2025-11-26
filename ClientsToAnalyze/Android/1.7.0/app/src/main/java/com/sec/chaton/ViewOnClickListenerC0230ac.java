package com.sec.chaton;

import android.view.View;
import com.sec.chaton.util.C1323bs;

/* compiled from: ChatONVDialog.java */
/* renamed from: com.sec.chaton.ac */
/* loaded from: classes.dex */
class ViewOnClickListenerC0230ac implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatONVDialog f564a;

    ViewOnClickListenerC0230ac(ChatONVDialog chatONVDialog) {
        this.f564a = chatONVDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f564a.f238c.isChecked()) {
            this.f564a.f238c.setChecked(false);
        } else {
            this.f564a.f238c.setChecked(true);
        }
        C1323bs.m4576a("ChatONVDownloadPopup", (Boolean) false);
    }
}
