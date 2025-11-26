package com.sec.chaton.block;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.sec.chaton.R;

/* compiled from: BlockImpl.java */
/* renamed from: com.sec.chaton.block.q */
/* loaded from: classes.dex */
class ViewOnKeyListenerC0491q implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC0487m f1618a;

    ViewOnKeyListenerC0491q(MenuItemOnMenuItemClickListenerC0487m menuItemOnMenuItemClickListenerC0487m) {
        this.f1618a = menuItemOnMenuItemClickListenerC0487m;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (i) {
                case 23:
                case 66:
                    if (this.f1618a.f1602d != null) {
                        ((Button) this.f1618a.f1602d.findViewById(R.id.button1)).performClick();
                        break;
                    }
                    break;
            }
            return false;
        }
        return false;
    }
}
