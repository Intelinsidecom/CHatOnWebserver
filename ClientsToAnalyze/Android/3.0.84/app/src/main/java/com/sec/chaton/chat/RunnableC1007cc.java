package com.sec.chaton.chat;

import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.C1454v;
import com.sec.widget.C3641ai;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cc */
/* loaded from: classes.dex */
class RunnableC1007cc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4081a;

    RunnableC1007cc(ChatFragment chatFragment) {
        this.f4081a = chatFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4081a.f3551aa != null) {
            ChatFragment.m4862b(this.f4081a, 30);
            this.f4081a.f3551aa.startQuery(19, null, C1454v.m6344a(this.f4081a.f3597bT), null, "message_inbox_no=?", new String[]{this.f4081a.f3703r}, null);
        }
        if (!this.f4081a.f3548aX.equals("-1") || this.f4081a.f3672cr == null || this.f4081a.getResources() == null) {
            return;
        }
        C3641ai.m13211a(GlobalApplication.m11493l(), this.f4081a.getResources().getString(R.string.end_of_messages, 15), 0).show();
    }
}
