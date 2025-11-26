package com.sec.chaton.chat;

import android.view.View;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.u */
/* loaded from: classes.dex */
class ViewOnClickListenerC1874u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f7092a;

    ViewOnClickListenerC1874u(ChatFragment chatFragment) {
        this.f7092a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (C4809aa.m18104a().m18119a("show_draw_menu_info", (Boolean) false).booleanValue()) {
                this.f7092a.f5729eh.removeView(this.f7092a.f5727ef);
                C4809aa.m18105a("draw_menu_info", (Boolean) true);
                C4809aa.m18105a("show_draw_menu_info", (Boolean) false);
                this.f7092a.m8273r();
            }
        } catch (IllegalArgumentException e) {
            C4904y.m18635a(e, ChatFragment.f5461a);
        }
    }
}
