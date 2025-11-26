package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;

/* compiled from: TWFollowingsListActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bh */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC1380bh implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ TWFollowingsListActivity f5220a;

    DialogInterfaceOnDismissListenerC1380bh(TWFollowingsListActivity tWFollowingsListActivity) {
        this.f5220a = tWFollowingsListActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f5220a.f5031r) {
            if (this.f5220a.f5029p) {
                this.f5220a.f5029p = false;
            }
            this.f5220a.f5031r = false;
        }
    }
}
