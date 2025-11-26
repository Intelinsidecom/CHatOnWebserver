package com.sec.chaton.chat;

import android.view.View;
import android.widget.CheckBox;
import com.sec.chaton.chat.translate.C1865r;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.af */
/* loaded from: classes.dex */
class ViewOnClickListenerC1559af implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f5964a;

    /* renamed from: b */
    final /* synthetic */ C1505a f5965b;

    /* renamed from: c */
    final /* synthetic */ CheckBox f5966c;

    /* renamed from: d */
    final /* synthetic */ ChatFragment f5967d;

    ViewOnClickListenerC1559af(ChatFragment chatFragment, CheckBox checkBox, C1505a c1505a, CheckBox checkBox2) {
        this.f5967d = chatFragment;
        this.f5964a = checkBox;
        this.f5965b = c1505a;
        this.f5966c = checkBox2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C1865r.m9070b()) {
            this.f5964a.performClick();
            if (this.f5965b != null) {
                this.f5967d.m8076b(this.f5965b.m8356a(), this.f5964a.isChecked());
                return;
            }
            return;
        }
        this.f5966c.performClick();
        if (this.f5965b != null) {
            this.f5967d.m8076b(this.f5965b.m8356a(), this.f5966c.isChecked());
        }
    }
}
