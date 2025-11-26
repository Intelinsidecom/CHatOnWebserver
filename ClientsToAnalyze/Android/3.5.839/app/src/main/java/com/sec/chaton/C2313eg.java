package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.AbstractC0069w;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.util.C4904y;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.eg */
/* loaded from: classes.dex */
class C2313eg extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ TabActivity f8236a;

    C2313eg(TabActivity tabActivity) {
        this.f8236a = tabActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        AbstractC0069w abstractC0069wE;
        if (intent.getAction().compareTo("buddy_tab_badge_update") == 0) {
            C4904y.m18639b("receive ACTION_BUDDY_TAB_BADGE_UPDATE", getClass().getSimpleName());
        } else if (intent.getAction().compareTo("buddy_tab_name_update") == 0 && (abstractC0069wE = this.f8236a.m50e()) != null && (abstractC0069wE.mo180a(this.f8236a.f2061aF) instanceof BuddyFragment)) {
            ((BuddyFragment) abstractC0069wE.mo180a(this.f8236a.f2061aF)).m6609l();
            C4904y.m18639b("receive ACTION_BUDDY_TAB_NAME_UPDATE", getClass().getSimpleName());
        }
    }
}
