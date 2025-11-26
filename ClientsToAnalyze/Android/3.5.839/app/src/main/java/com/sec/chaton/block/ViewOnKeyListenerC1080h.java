package com.sec.chaton.block;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.sec.chaton.R;

/* compiled from: BlockFragment.java */
/* renamed from: com.sec.chaton.block.h */
/* loaded from: classes.dex */
class ViewOnKeyListenerC1080h implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ BlockFragment f3460a;

    ViewOnKeyListenerC1080h(BlockFragment blockFragment) {
        this.f3460a = blockFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        Button button;
        if (keyEvent.getAction() == 0) {
            switch (i) {
                case 23:
                case 66:
                    if (this.f3460a.f3408d != null && (button = (Button) this.f3460a.f3408d.findViewById(R.id.button1)) != null) {
                        button.performClick();
                        break;
                    }
                    break;
            }
            return false;
        }
        return false;
    }
}
