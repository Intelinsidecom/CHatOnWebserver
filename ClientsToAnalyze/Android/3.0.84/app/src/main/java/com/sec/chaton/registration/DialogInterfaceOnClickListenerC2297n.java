package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.util.C3159aa;

/* compiled from: ActivitySyncSignInPopup.java */
/* renamed from: com.sec.chaton.registration.n */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2297n implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC2124ab f8602a;

    /* renamed from: b */
    final /* synthetic */ ActivitySyncSignInPopup f8603b;

    DialogInterfaceOnClickListenerC2297n(ActivitySyncSignInPopup activitySyncSignInPopup, EnumC2124ab enumC2124ab) {
        this.f8603b = activitySyncSignInPopup;
        this.f8602a = enumC2124ab;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f8602a.equals(EnumC2124ab.mapping)) {
            C3159aa.m10963a("account_mapping_fail", (Boolean) true);
            this.f8603b.f8120i.setVisibility(8);
        } else {
            this.f8603b.finish();
        }
    }
}
