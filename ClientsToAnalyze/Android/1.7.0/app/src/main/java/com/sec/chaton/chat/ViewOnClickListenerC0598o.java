package com.sec.chaton.chat;

import android.view.View;
import com.sec.chaton.trunk.TrunkView;
import com.sec.chaton.util.C1341p;

/* compiled from: ChatActivity.java */
/* renamed from: com.sec.chaton.chat.o */
/* loaded from: classes.dex */
class ViewOnClickListenerC0598o implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatActivity f2040a;

    ViewOnClickListenerC0598o(ChatActivity chatActivity) {
        this.f2040a = chatActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f2040a.f1701a.getCurrentTabTag().equals("chatroom")) {
            ChatFragment chatFragment = (ChatFragment) ((C0594k) this.f2040a.f1702b.f2029e.get("chatroom")).f2036d;
            if (chatFragment != null) {
                if (!chatFragment.m2699a(view)) {
                    C1341p.m4660c("ChatFragment.showDroupMenu failed", getClass().getSimpleName());
                }
            } else {
                C1341p.m4660c("ChatFragment is null", getClass().getSimpleName());
            }
            C1341p.m4660c("chat compatpopup menu", getClass().getSimpleName());
            return;
        }
        TrunkView trunkView = (TrunkView) ((C0594k) this.f2040a.f1702b.f2029e.get("trunk")).f2036d;
        if (trunkView != null) {
            if (!trunkView.m4086a(view)) {
                C1341p.m4660c("TrunkView.showDroupMenu failed", getClass().getSimpleName());
            }
        } else {
            C1341p.m4660c("TrunkView is null", getClass().getSimpleName());
        }
        C1341p.m4660c("trunk compatpopup menu", getClass().getSimpleName());
    }
}
