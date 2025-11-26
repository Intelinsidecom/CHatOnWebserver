package com.sec.chaton.chat;

import android.view.View;
import android.widget.CheckBox;
import com.sec.chaton.smsplugin.p112ui.C4108aq;
import com.sec.chaton.smsplugin.p112ui.MessageListItem;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.ga */
/* loaded from: classes.dex */
class ViewOnClickListenerC1728ga implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ long f6379a;

    /* renamed from: b */
    final /* synthetic */ C4108aq f6380b;

    /* renamed from: c */
    final /* synthetic */ MessageListItem f6381c;

    /* renamed from: d */
    final /* synthetic */ C1723fw f6382d;

    ViewOnClickListenerC1728ga(C1723fw c1723fw, long j, C4108aq c4108aq, MessageListItem messageListItem) {
        this.f6382d = c1723fw;
        this.f6379a = j;
        this.f6380b = c4108aq;
        this.f6381c = messageListItem;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean zIsChecked = ((CheckBox) view).isChecked();
        if (this.f6382d.f6346L != EnumC1731gd.SELECT_NONE && this.f6382d.f6346L != EnumC1731gd.SELECT_PART) {
            if (this.f6382d.f6346L == EnumC1731gd.SELECT_ALL || this.f6382d.f6346L == EnumC1731gd.SELECT_PART_AFTER_ALL) {
                if (zIsChecked) {
                    this.f6382d.f6351Q.remove(Long.valueOf(this.f6379a));
                } else {
                    this.f6382d.f6351Q.put(Long.valueOf(this.f6379a), this.f6380b);
                }
                this.f6382d.m8554m();
            }
        } else {
            if (zIsChecked) {
                this.f6382d.f6351Q.put(Long.valueOf(this.f6379a), this.f6380b);
            } else {
                this.f6382d.f6351Q.remove(Long.valueOf(this.f6379a));
            }
            this.f6382d.m8553l();
        }
        this.f6381c.setCheckBox(0, zIsChecked);
        this.f6382d.f6368v.invalidateViews();
    }
}
