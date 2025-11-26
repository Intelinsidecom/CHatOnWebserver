package com.sec.chaton.block;

import android.hardware.motion.MREvent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.sec.chaton.R;

/* compiled from: BlockFragment.java */
/* renamed from: com.sec.chaton.block.b */
/* loaded from: classes.dex */
class ViewOnKeyListenerC0355b implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ BlockFragment f1037a;

    ViewOnKeyListenerC0355b(BlockFragment blockFragment) {
        this.f1037a = blockFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (i) {
                case MREvent.TILT_BACK /* 23 */:
                case MREvent.BLOW /* 66 */:
                    if (this.f1037a.f1028d != null) {
                        ((Button) this.f1037a.f1028d.findViewById(R.id.listItemButton)).performClick();
                        break;
                    }
                    break;
            }
            return false;
        }
        return false;
    }
}
