package com.sec.chaton.chat;

import android.widget.CompoundButton;
import com.sec.chaton.chat.ChatListAdapter;

/* renamed from: com.sec.chaton.chat.m */
/* loaded from: classes.dex */
class C0151m implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ int f962a;

    /* renamed from: b */
    final /* synthetic */ ChatListAdapter.BalloonHolder f963b;

    /* renamed from: c */
    final /* synthetic */ String f964c;

    /* renamed from: d */
    final /* synthetic */ ChatListAdapter f965d;

    C0151m(ChatListAdapter chatListAdapter, int i, ChatListAdapter.BalloonHolder balloonHolder, String str) {
        this.f965d = chatListAdapter;
        this.f962a = i;
        this.f963b = balloonHolder;
        this.f964c = str;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        compoundButton.setChecked(z);
        this.f965d.f831A.setItemChecked(this.f962a, z);
        this.f965d.m790a(this.f963b.f908z, this.f963b.f862A, this.f964c);
    }
}
