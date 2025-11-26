package com.sec.chaton.hide;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.sec.chaton.R;

/* compiled from: HideImpl.java */
/* renamed from: com.sec.chaton.hide.k */
/* loaded from: classes.dex */
class ViewOnKeyListenerC1520k implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ C1516g f5598a;

    ViewOnKeyListenerC1520k(C1516g c1516g) {
        this.f5598a = c1516g;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (i) {
                case 23:
                case 66:
                    if (this.f5598a.f5578d != null) {
                        ((Button) this.f5598a.f5578d.findViewById(R.id.button1)).performClick();
                        break;
                    }
                    break;
            }
            return false;
        }
        return false;
    }
}
