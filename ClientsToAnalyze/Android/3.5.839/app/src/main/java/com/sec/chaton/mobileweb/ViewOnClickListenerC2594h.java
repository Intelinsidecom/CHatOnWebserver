package com.sec.chaton.mobileweb;

import android.view.View;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: GeneralWebFragment.java */
/* renamed from: com.sec.chaton.mobileweb.h */
/* loaded from: classes.dex */
class ViewOnClickListenerC2594h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GeneralWebFragment f9254a;

    ViewOnClickListenerC2594h(GeneralWebFragment generalWebFragment) {
        this.f9254a = generalWebFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (C4809aa.m18104a().m18119a("show_draw_menu_info", (Boolean) false).booleanValue()) {
                this.f9254a.f9218v.removeView(this.f9254a.f9219w);
                C4809aa.m18105a("draw_menu_info", (Boolean) true);
                C4809aa.m18105a("show_draw_menu_info", (Boolean) false);
            }
        } catch (IllegalArgumentException e) {
            C4904y.m18635a(e, GeneralWebFragment.f9200b);
        }
    }
}
