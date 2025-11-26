package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: TwitterSubMenuActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.dg */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC1433dg implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ boolean f5316a;

    /* renamed from: b */
    final /* synthetic */ TwitterSubMenuActivity f5317b;

    DialogInterfaceOnKeyListenerC1433dg(TwitterSubMenuActivity twitterSubMenuActivity, boolean z) {
        this.f5317b = twitterSubMenuActivity;
        this.f5316a = z;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (this.f5317b.f5108i != null && this.f5317b.f5108i.isShowing()) {
            this.f5317b.f5108i.dismiss();
            this.f5317b.f5108i = null;
        }
        if (this.f5316a) {
            this.f5317b.finish();
        }
        return true;
    }
}
