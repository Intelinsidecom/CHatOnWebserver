package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.util.C3250y;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.bt */
/* loaded from: classes.dex */
class C0508bt extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1647a;

    C0508bt(TabActivity tabActivity) {
        this.f1647a = tabActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        FragmentManager supportFragmentManager;
        if (intent.getAction().compareTo("buddy_tab_badge_update") == 0) {
            C3250y.m11450b("receive ACTION_BUDDY_TAB_BADGE_UPDATE", getClass().getSimpleName());
        } else if (intent.getAction().compareTo("buddy_tab_name_update") == 0 && (supportFragmentManager = this.f1647a.getSupportFragmentManager()) != null && (supportFragmentManager.findFragmentById(this.f1647a.f778as) instanceof BuddyFragment)) {
            ((BuddyFragment) supportFragmentManager.findFragmentById(this.f1647a.f778as)).m3450o();
            C3250y.m11450b("receive ACTION_BUDDY_TAB_NAME_UPDATE", getClass().getSimpleName());
        }
    }
}
