package com.sec.chaton.chat;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.ek */
/* loaded from: classes.dex */
class ViewOnClickListenerC1069ek implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1070el f4210a;

    /* renamed from: b */
    final /* synthetic */ C1067ei f4211b;

    ViewOnClickListenerC1069ek(C1067ei c1067ei, C1070el c1070el) {
        this.f4211b = c1067ei;
        this.f4210a = c1070el;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean zIsChecked = ((CheckBox) view).isChecked();
        if (this.f4211b.f4204u != EnumC1071em.SELECT_NONE && this.f4211b.f4204u != EnumC1071em.SELECT_PART) {
            if (this.f4211b.f4204u == EnumC1071em.SELECT_ALL || this.f4211b.f4204u == EnumC1071em.SELECT_PART_AFTER_ALL) {
                if (zIsChecked) {
                    this.f4211b.f4202s.remove(Long.valueOf(this.f4210a.f4272b));
                } else {
                    this.f4211b.f4202s.put(Long.valueOf(this.f4210a.f4272b), true);
                }
                this.f4211b.m5279i();
            }
        } else {
            if (zIsChecked) {
                this.f4211b.f4202s.put(Long.valueOf(this.f4210a.f4272b), true);
            } else {
                this.f4211b.f4202s.remove(Long.valueOf(this.f4210a.f4272b));
            }
            this.f4211b.m5278h();
        }
        this.f4211b.f4188e.invalidateViews();
    }
}
