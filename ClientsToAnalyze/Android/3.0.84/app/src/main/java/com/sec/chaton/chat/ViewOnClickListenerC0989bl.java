package com.sec.chaton.chat;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.vip.amschaton.AMSPlayerActivity;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bl */
/* loaded from: classes.dex */
class ViewOnClickListenerC0989bl implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4059a;

    ViewOnClickListenerC0989bl(ChatFragment chatFragment) {
        this.f4059a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4059a.f3556af == EnumC1455w.AMS) {
            Intent intent = new Intent(this.f4059a.f3672cr, (Class<?>) AMSPlayerActivity.class);
            intent.putExtra("AMS_FILE_PATH", this.f4059a.f3555ae.getPath());
            intent.putExtra("VIEWER_MODE", 1002);
            this.f4059a.startActivity(intent);
        }
    }
}
