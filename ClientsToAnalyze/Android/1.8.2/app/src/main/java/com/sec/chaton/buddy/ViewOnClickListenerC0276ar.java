package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.p017e.EnumC0695j;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ar */
/* loaded from: classes.dex */
class ViewOnClickListenerC0276ar implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1371a;

    ViewOnClickListenerC0276ar(BuddyFragment buddyFragment) {
        this.f1371a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1371a.m2050g();
        Intent intent = new Intent(this.f1371a.getActivity(), (Class<?>) ChatActivity.class);
        intent.setFlags(67108864);
        if (EnumC0695j.BROADCAST != EnumC0695j.m3145a(this.f1371a.f937Y) || this.f1371a.f921I) {
            intent.putExtra("inboxNO", this.f1371a.f934V);
        }
        intent.putExtra("receivers", this.f1371a.f938Z);
        intent.putExtra("chatType", this.f1371a.f937Y);
        intent.putExtra(ChatFragment.f1754j, 1);
        intent.putExtra(ChatFragment.f1753i, this.f1371a.f936X);
        intent.putExtra(ChatFragment.f1755k, this.f1371a.f923K);
        ((BaseActivity) this.f1371a.getActivity()).mo1830a(intent);
    }
}
