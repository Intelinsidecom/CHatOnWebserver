package com.sec.chaton.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.chat.ChatFragment;

/* renamed from: com.sec.chaton.util.j */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0612j implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BlackScreenNotification f3777a;

    DialogInterfaceOnClickListenerC0612j(BlackScreenNotification blackScreenNotification) {
        this.f3777a = blackScreenNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intentM358a = HomeActivity.m358a((Context) this.f3777a, true);
        intentM358a.putExtra("inboxNO", this.f3777a.f3614d);
        intentM358a.putExtra("chatType", this.f3777a.f3615e);
        intentM358a.putExtra("fromPush", 1);
        intentM358a.putExtra(ChatFragment.f729h, 1);
        this.f3777a.startActivity(intentM358a);
        this.f3777a.finish();
    }
}
