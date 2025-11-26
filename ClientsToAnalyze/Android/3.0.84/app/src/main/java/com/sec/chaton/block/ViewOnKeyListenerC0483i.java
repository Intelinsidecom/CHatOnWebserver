package com.sec.chaton.block;

import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;

/* compiled from: BlockFragment.java */
/* renamed from: com.sec.chaton.block.i */
/* loaded from: classes.dex */
class ViewOnKeyListenerC0483i implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ BlockFragment f1595a;

    ViewOnKeyListenerC0483i(BlockFragment blockFragment) {
        this.f1595a = blockFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (i) {
                case 23:
                case 66:
                    if (this.f1595a.f1543d != null) {
                        ((ImageView) this.f1595a.f1543d.findViewById(R.id.image2)).performClick();
                        break;
                    }
                    break;
            }
            return false;
        }
        return false;
    }
}
