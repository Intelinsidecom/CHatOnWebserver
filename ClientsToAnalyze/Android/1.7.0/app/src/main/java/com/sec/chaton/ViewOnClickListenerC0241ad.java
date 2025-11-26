package com.sec.chaton;

import android.view.View;
import com.sec.chaton.util.C1323bs;

/* compiled from: ChatONVDialog.java */
/* renamed from: com.sec.chaton.ad */
/* loaded from: classes.dex */
class ViewOnClickListenerC0241ad implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatONVDialog f585a;

    ViewOnClickListenerC0241ad(ChatONVDialog chatONVDialog) {
        this.f585a = chatONVDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1323bs.m4576a("ChatONVDownloadPopup", (Boolean) false);
        this.f585a.finish();
    }
}
