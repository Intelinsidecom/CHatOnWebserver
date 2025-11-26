package com.sec.chaton.hide;

import android.R;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

/* compiled from: HideListFragment.java */
/* renamed from: com.sec.chaton.hide.t */
/* loaded from: classes.dex */
class ViewOnKeyListenerC1529t implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ HideListFragment f5617a;

    ViewOnKeyListenerC1529t(HideListFragment hideListFragment) {
        this.f5617a = hideListFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (i) {
                case 23:
                case 66:
                    if (this.f5617a.f5549d != null) {
                        ((Button) this.f5617a.f5549d.findViewById(R.id.checkbox)).performClick();
                        break;
                    }
                    break;
            }
            return false;
        }
        return false;
    }
}
