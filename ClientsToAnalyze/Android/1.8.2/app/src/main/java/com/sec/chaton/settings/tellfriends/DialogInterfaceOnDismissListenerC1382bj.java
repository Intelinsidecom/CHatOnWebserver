package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;

/* compiled from: TWFollowingsListActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bj */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC1382bj implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ TWFollowingsListActivity f5222a;

    DialogInterfaceOnDismissListenerC1382bj(TWFollowingsListActivity tWFollowingsListActivity) {
        this.f5222a = tWFollowingsListActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f5222a.f5031r) {
            if (this.f5222a.f5029p) {
                this.f5222a.f5029p = false;
            }
            this.f5222a.f5031r = false;
        }
    }
}
