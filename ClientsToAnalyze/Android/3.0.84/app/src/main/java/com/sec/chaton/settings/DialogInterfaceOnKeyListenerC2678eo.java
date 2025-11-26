package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: PostONHideFragment.java */
/* renamed from: com.sec.chaton.settings.eo */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC2678eo implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ PostONHideFragment f9964a;

    DialogInterfaceOnKeyListenerC2678eo(PostONHideFragment postONHideFragment) {
        this.f9964a = postONHideFragment;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f9964a.f9224d.m5922c();
        if (PostONHideFragment.f9221a != null) {
            PostONHideFragment.f9221a.dismiss();
        }
        this.f9964a.getActivity().finish();
        return true;
    }
}
