package com.sec.chaton.block;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: BlockListFragment.java */
/* renamed from: com.sec.chaton.block.r */
/* loaded from: classes.dex */
class ViewOnKeyListenerC1090r implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ BlockListFragment f3481a;

    ViewOnKeyListenerC1090r(BlockListFragment blockListFragment) {
        this.f3481a = blockListFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (i) {
                case 23:
                case 66:
                    if (this.f3481a.f3428d != null) {
                        this.f3481a.f3428d.performClick();
                        break;
                    }
                    break;
            }
            return false;
        }
        return false;
    }
}
