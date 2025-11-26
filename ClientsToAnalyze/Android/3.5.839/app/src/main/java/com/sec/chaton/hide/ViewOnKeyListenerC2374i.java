package com.sec.chaton.hide;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.sec.chaton.R;

/* compiled from: HideFragment.java */
/* renamed from: com.sec.chaton.hide.i */
/* loaded from: classes.dex */
class ViewOnKeyListenerC2374i implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ HideFragment f8450a;

    ViewOnKeyListenerC2374i(HideFragment hideFragment) {
        this.f8450a = hideFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        Button button;
        if (keyEvent.getAction() == 0) {
            switch (i) {
                case 23:
                case 66:
                    if (this.f8450a.f8399d != null && (button = (Button) this.f8450a.f8399d.findViewById(R.id.button1)) != null) {
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
