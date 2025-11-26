package com.sec.vip.amschaton;

import android.content.DialogInterface;
import android.content.res.Resources;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.vip.amschaton.ce */
/* loaded from: classes.dex */
class DialogInterfaceOnShowListenerC0685ce implements DialogInterface.OnShowListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4306a;

    DialogInterfaceOnShowListenerC0685ce(AMSComposerActivity aMSComposerActivity) {
        this.f4306a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) throws Resources.NotFoundException {
        int dimensionPixelOffset = this.f4306a.m3735G().getResources().getDimensionPixelOffset(C0062R.dimen.ams_stamp_button_padding);
        this.f4306a.f3863n.setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
    }
}
