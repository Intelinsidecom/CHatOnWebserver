package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;

/* compiled from: AMSComposerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.af */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3458af implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerFragment f12818a;

    DialogInterfaceOnClickListenerC3458af(AMSComposerFragment aMSComposerFragment) {
        this.f12818a = aMSComposerFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        dialogInterface.dismiss();
        SharedPreferences sharedPreferences = this.f12818a.getActivity().getSharedPreferences("AMSPref", 1);
        this.f12818a.f12687ai = false;
        sharedPreferences.edit().putBoolean("AMS_BG_SET_FLAG", this.f12818a.f12687ai).commit();
        this.f12818a.m12512x();
    }
}
