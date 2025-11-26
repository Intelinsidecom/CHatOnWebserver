package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.ct */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3556ct implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3555cs f13045a;

    DialogInterfaceOnClickListenerC3556ct(C3555cs c3555cs) {
        this.f13045a = c3555cs;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f13045a.f13044a.f12637o.m9525e(false);
                this.f13045a.f13044a.f12628f.show();
                break;
            case 1:
                this.f13045a.f13044a.f12637o.m9525e(true);
                this.f13045a.f13044a.f12628f.show();
                break;
        }
        this.f13045a.f13044a.f12645w.dismiss();
    }
}
