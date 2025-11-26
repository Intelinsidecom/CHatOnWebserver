package com.sec.chaton.chat;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.fy */
/* loaded from: classes.dex */
class ViewOnClickListenerC1725fy implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1729gb f6374a;

    /* renamed from: b */
    final /* synthetic */ C1723fw f6375b;

    ViewOnClickListenerC1725fy(C1723fw c1723fw, C1729gb c1729gb) {
        this.f6375b = c1723fw;
        this.f6374a = c1729gb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean zIsChecked = ((CheckBox) view).isChecked();
        if (this.f6375b.f6346L != EnumC1731gd.SELECT_NONE && this.f6375b.f6346L != EnumC1731gd.SELECT_PART) {
            if (this.f6375b.f6346L == EnumC1731gd.SELECT_ALL || this.f6375b.f6346L == EnumC1731gd.SELECT_PART_AFTER_ALL) {
                if (zIsChecked) {
                    this.f6375b.f6342H.remove(Long.valueOf(this.f6374a.f6457b));
                } else {
                    this.f6375b.f6342H.put(Long.valueOf(this.f6374a.f6457b), true);
                }
                this.f6375b.m8554m();
            }
        } else {
            if (zIsChecked) {
                this.f6375b.f6342H.put(Long.valueOf(this.f6374a.f6457b), true);
            } else {
                this.f6375b.f6342H.remove(Long.valueOf(this.f6374a.f6457b));
            }
            this.f6375b.m8553l();
        }
        this.f6375b.f6368v.invalidateViews();
    }
}
