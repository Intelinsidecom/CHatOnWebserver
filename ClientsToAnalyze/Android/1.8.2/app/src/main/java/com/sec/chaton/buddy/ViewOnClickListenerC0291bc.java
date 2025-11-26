package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.chat.ChatFragment;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bc */
/* loaded from: classes.dex */
class ViewOnClickListenerC0291bc implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1387a;

    ViewOnClickListenerC0291bc(BuddyFragment buddyFragment) {
        this.f1387a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f1387a.getActivity(), (Class<?>) BuddyActivity2.class);
        intent.putExtra("ACTIVITY_PURPOSE", 5);
        intent.putExtra("inboxNO", this.f1387a.f934V);
        intent.putExtra(ChatFragment.f1753i, this.f1387a.f921I);
        intent.putExtra(ChatFragment.f1749e, this.f1387a.f938Z);
        intent.putExtra("chatType", this.f1387a.f937Y);
        intent.putExtra("ACTION_PURPOSE", 6);
        this.f1387a.startActivityForResult(intent, 5);
    }
}
