package com.sec.chaton.block;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: BlockListFragment.java */
/* renamed from: com.sec.chaton.block.z */
/* loaded from: classes.dex */
class ViewOnKeyListenerC0500z implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ BlockListFragment f1638a;

    ViewOnKeyListenerC0500z(BlockListFragment blockListFragment) {
        this.f1638a = blockListFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (i) {
                case 23:
                case 66:
                    if (this.f1638a.f1560d != null) {
                        this.f1638a.f1560d.performClick();
                        break;
                    }
                    break;
            }
            return false;
        }
        return false;
    }
}
