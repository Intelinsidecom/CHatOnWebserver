package com.sec.chaton.chat;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.HomeTabletFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.trunk.TrunkActivity;
import com.sec.chaton.trunk.TrunkView;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.y */
/* loaded from: classes.dex */
class ViewOnClickListenerC0519y implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f2129a;

    ViewOnClickListenerC0519y(ChatFragment chatFragment) {
        this.f2129a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (GlobalApplication.m3265f()) {
            this.f2129a.getActivity().getIntent().putExtra("sessionId", this.f2129a.f1766G);
            this.f2129a.getActivity().getIntent().putExtra("inboxNO", this.f2129a.f1912z);
            this.f2129a.getActivity().getIntent().putExtra("chatTitle", this.f2129a.f1801aP.getText().toString());
            this.f2129a.getActivity().getIntent().putExtra("buddyNo", this.f2129a.f1760A);
            this.f2129a.getActivity().getIntent().putExtra("trunkChatType", this.f2129a.f1765F);
            HomeTabletFragment.m628a(this.f2129a.getFragmentManager(), new TrunkView());
            return;
        }
        Intent intent = new Intent();
        intent.setClass(GlobalApplication.m3256a(), TrunkActivity.class);
        intent.putExtra("sessionId", this.f2129a.f1766G);
        intent.putExtra("inboxNO", this.f2129a.f1912z);
        this.f2129a.startActivity(intent);
    }
}
