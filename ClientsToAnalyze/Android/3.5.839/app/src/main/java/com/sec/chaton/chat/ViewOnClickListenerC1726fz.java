package com.sec.chaton.chat;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.fz */
/* loaded from: classes.dex */
class ViewOnClickListenerC1726fz implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1729gb f6376a;

    /* renamed from: b */
    final /* synthetic */ C1723fw f6377b;

    ViewOnClickListenerC1726fz(C1723fw c1723fw, C1729gb c1729gb) {
        this.f6377b = c1723fw;
        this.f6376a = c1729gb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean zIsChecked = ((CheckBox) view).isChecked();
        if (this.f6377b.f6346L != EnumC1731gd.SELECT_NONE && this.f6377b.f6346L != EnumC1731gd.SELECT_PART) {
            if (this.f6377b.f6346L == EnumC1731gd.SELECT_ALL || this.f6377b.f6346L == EnumC1731gd.SELECT_PART_AFTER_ALL) {
                if (zIsChecked) {
                    this.f6377b.f6344J.remove(Long.valueOf(this.f6376a.f6457b));
                } else {
                    this.f6377b.f6344J.put(Long.valueOf(this.f6376a.f6457b), true);
                }
                this.f6377b.m8554m();
            }
        } else {
            if (zIsChecked) {
                this.f6377b.f6344J.put(Long.valueOf(this.f6376a.f6457b), true);
            } else {
                this.f6377b.f6344J.remove(Long.valueOf(this.f6376a.f6457b));
            }
            this.f6377b.m8553l();
        }
        this.f6377b.f6368v.invalidateViews();
    }
}
