package com.sec.chaton.poston;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ar */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2973ar implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f11070a;

    DialogInterfaceOnClickListenerC2973ar(PostONDetailFragment postONDetailFragment) {
        this.f11070a = postONDetailFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        Intent intent = new Intent();
        intent.putExtra("POSTON_HAS_CHANGED", true);
        this.f11070a.getActivity().setResult(-1, intent);
        this.f11070a.getActivity().finish();
    }
}
