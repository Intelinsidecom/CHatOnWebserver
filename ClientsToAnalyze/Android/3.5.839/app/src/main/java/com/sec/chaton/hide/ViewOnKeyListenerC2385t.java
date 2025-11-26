package com.sec.chaton.hide;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: HideListFragment.java */
/* renamed from: com.sec.chaton.hide.t */
/* loaded from: classes.dex */
class ViewOnKeyListenerC2385t implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ HideListFragment f8472a;

    ViewOnKeyListenerC2385t(HideListFragment hideListFragment) {
        this.f8472a = hideListFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (i) {
                case 23:
                case 66:
                    if (this.f8472a.f8418d != null) {
                        this.f8472a.f8418d.performClick();
                        break;
                    }
                    break;
            }
            return false;
        }
        return false;
    }
}
