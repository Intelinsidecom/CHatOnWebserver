package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;

/* compiled from: AMSComposerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.ag */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3459ag implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerFragment f12819a;

    DialogInterfaceOnClickListenerC3459ag(AMSComposerFragment aMSComposerFragment) {
        this.f12819a = aMSComposerFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        this.f12819a.m12459e();
        dialogInterface.dismiss();
        SharedPreferences sharedPreferences = this.f12819a.getActivity().getSharedPreferences("AMSPref", 1);
        this.f12819a.f12687ai = false;
        sharedPreferences.edit().putBoolean("AMS_BG_SET_FLAG", this.f12819a.f12687ai).commit();
        this.f12819a.m12512x();
    }
}
