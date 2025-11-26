package com.sec.chaton.ignore;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.sec.chaton.C0229at;
import com.sec.chaton.R;

/* compiled from: IgnoreFragment.java */
/* renamed from: com.sec.chaton.ignore.f */
/* loaded from: classes.dex */
class ViewOnKeyListenerC0827f implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ IgnoreFragment f3041a;

    ViewOnKeyListenerC0827f(IgnoreFragment ignoreFragment) {
        this.f3041a = ignoreFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (i) {
                case C0229at.HorizontalSrollView_android_fadingEdge /* 23 */:
                case 66:
                    if (this.f3041a.f3017d != null) {
                        ((Button) this.f3041a.f3017d.findViewById(R.id.listItemButton)).performClick();
                        break;
                    }
                    break;
            }
            return false;
        }
        return false;
    }
}
