package com.sec.chaton.multimedia.p078a;

import android.view.View;

/* compiled from: GlympseInstallDialog.java */
/* renamed from: com.sec.chaton.multimedia.a.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC2721c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogC2719a f9744a;

    ViewOnClickListenerC2721c(DialogC2719a dialogC2719a) {
        this.f9744a = dialogC2719a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f9744a.cancel();
    }
}
