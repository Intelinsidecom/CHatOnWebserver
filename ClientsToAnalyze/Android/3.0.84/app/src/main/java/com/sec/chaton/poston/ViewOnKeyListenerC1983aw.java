package com.sec.chaton.poston;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.sec.chaton.R;

/* compiled from: PostONHideListFragment.java */
/* renamed from: com.sec.chaton.poston.aw */
/* loaded from: classes.dex */
class ViewOnKeyListenerC1983aw implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ PostONHideListFragment f7679a;

    ViewOnKeyListenerC1983aw(PostONHideListFragment postONHideListFragment) {
        this.f7679a = postONHideListFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (i) {
                case 23:
                case 66:
                    if (this.f7679a.f7568h != null) {
                        ((Button) this.f7679a.f7568h.findViewById(R.id.listItemButton)).performClick();
                        break;
                    }
                    break;
            }
            return false;
        }
        return false;
    }
}
