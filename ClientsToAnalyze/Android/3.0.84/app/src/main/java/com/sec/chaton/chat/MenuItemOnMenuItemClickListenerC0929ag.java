package com.sec.chaton.chat;

import android.text.TextUtils;
import android.view.MenuItem;
import com.sec.chaton.chat.p024b.C0952c;
import com.sec.widget.C3641ai;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ag */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0929ag implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C1070el f3870a;

    /* renamed from: b */
    final /* synthetic */ C0952c f3871b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f3872c;

    MenuItemOnMenuItemClickListenerC0929ag(ChatFragment chatFragment, C1070el c1070el, C0952c c0952c) {
        this.f3872c = chatFragment;
        this.f3870a = c1070el;
        this.f3871b = c0952c;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (this.f3870a.f4245aG == null || TextUtils.isEmpty(this.f3870a.f4245aG)) {
            if (this.f3872c.f3647cS) {
                this.f3872c.m4762a(this.f3871b, this.f3870a, this.f3872c.f3643cM, this.f3872c.f3644cN);
                return true;
            }
            this.f3872c.m4899f(this.f3870a);
            return true;
        }
        C3641ai.m13211a(this.f3872c.getActivity(), "Already Translated", 0).show();
        return true;
    }
}
