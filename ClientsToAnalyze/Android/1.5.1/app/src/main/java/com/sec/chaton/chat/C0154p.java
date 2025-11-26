package com.sec.chaton.chat;

import android.widget.CompoundButton;
import com.sec.chaton.chat.ChatListAdapter;

/* renamed from: com.sec.chaton.chat.p */
/* loaded from: classes.dex */
class C0154p implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ int f970a;

    /* renamed from: b */
    final /* synthetic */ ChatListAdapter.BalloonHolder f971b;

    /* renamed from: c */
    final /* synthetic */ String f972c;

    /* renamed from: d */
    final /* synthetic */ ChatListAdapter f973d;

    C0154p(ChatListAdapter chatListAdapter, int i, ChatListAdapter.BalloonHolder balloonHolder, String str) {
        this.f973d = chatListAdapter;
        this.f970a = i;
        this.f971b = balloonHolder;
        this.f972c = str;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        compoundButton.setChecked(z);
        this.f973d.f831A.setItemChecked(this.f970a, z);
        this.f973d.m790a(this.f971b.f877P, this.f971b.f862A, this.f972c);
    }
}
