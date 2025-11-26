package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: PostONHideFragment.java */
/* renamed from: com.sec.chaton.settings.fm */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC3630fm implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ PostONHideFragment f13184a;

    DialogInterfaceOnKeyListenerC3630fm(PostONHideFragment postONHideFragment) {
        this.f13184a = postONHideFragment;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f13184a.f12798d.m9297c();
        if (PostONHideFragment.f12795a != null) {
            PostONHideFragment.f12795a.dismiss();
        }
        this.f13184a.getActivity().finish();
        return true;
    }
}
