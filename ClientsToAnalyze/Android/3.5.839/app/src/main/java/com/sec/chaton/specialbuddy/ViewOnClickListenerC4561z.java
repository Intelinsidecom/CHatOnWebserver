package com.sec.chaton.specialbuddy;

import android.view.View;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: SpecialBuddyChatFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.z */
/* loaded from: classes.dex */
class ViewOnClickListenerC4561z implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyChatFragment f16433a;

    ViewOnClickListenerC4561z(SpecialBuddyChatFragment specialBuddyChatFragment) {
        this.f16433a = specialBuddyChatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (C4809aa.m18104a().m18119a("show_draw_menu_info", (Boolean) false).booleanValue()) {
                this.f16433a.f16355au.removeView(this.f16433a.f16356av);
                C4809aa.m18105a("draw_menu_info", (Boolean) true);
                C4809aa.m18105a("show_draw_menu_info", (Boolean) false);
            }
        } catch (IllegalArgumentException e) {
            C4904y.m18635a(e, SpecialBuddyChatFragment.f16299l);
        }
    }
}
