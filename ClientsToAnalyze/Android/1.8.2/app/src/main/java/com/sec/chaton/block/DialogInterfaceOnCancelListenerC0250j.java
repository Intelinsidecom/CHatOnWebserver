package com.sec.chaton.block;

import android.content.DialogInterface;

/* compiled from: BlockFragment.java */
/* renamed from: com.sec.chaton.block.j */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0250j implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ BlockFragment f833a;

    DialogInterfaceOnCancelListenerC0250j(BlockFragment blockFragment) {
        this.f833a = blockFragment;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f833a.f801g.m2849b();
        this.f833a.f806l = true;
        this.f833a.getFragmentManager().popBackStack((String) null, 0);
    }
}
