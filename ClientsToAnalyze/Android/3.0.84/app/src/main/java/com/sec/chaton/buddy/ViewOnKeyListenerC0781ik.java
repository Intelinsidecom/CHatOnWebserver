package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.sec.chaton.R;

/* compiled from: SpecialBuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.ik */
/* loaded from: classes.dex */
class ViewOnKeyListenerC0781ik implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyRecommendListFragment f3053a;

    ViewOnKeyListenerC0781ik(SpecialBuddyRecommendListFragment specialBuddyRecommendListFragment) {
        this.f3053a = specialBuddyRecommendListFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (i) {
                case 23:
                case 66:
                    if (this.f3053a.f2322a != null) {
                        ((Button) this.f3053a.f2322a.findViewById(R.id.listItemButton)).performClick();
                        break;
                    }
                    break;
            }
            return false;
        }
        return false;
    }
}
