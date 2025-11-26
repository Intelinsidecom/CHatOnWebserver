package com.sec.chaton.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.p025d.EnumC0665r;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.bi */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1313bi implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ScreenOnNotification f4532a;

    DialogInterfaceOnClickListenerC1313bi(ScreenOnNotification screenOnNotification) {
        this.f4532a = screenOnNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intentM630a;
        if (this.f4532a.f4439g == EnumC0665r.WEB_AUTH.m3012a()) {
            intentM630a = HomeActivity.m630a((Context) this.f4532a, false);
            intentM630a.putExtra("inboxNO", this.f4532a.f4438f);
            intentM630a.putExtra("chatType", this.f4532a.f4439g);
            intentM630a.putExtra("fromPush", 1);
            intentM630a.putExtra("Content", this.f4532a.f4437e);
        } else {
            intentM630a = HomeActivity.m630a((Context) this.f4532a, true);
            intentM630a.putExtra("inboxNO", this.f4532a.f4438f);
            intentM630a.putExtra("chatType", this.f4532a.f4439g);
            intentM630a.putExtra("fromPush", 1);
            intentM630a.putExtra(ChatFragment.f1735h, 1);
            intentM630a.putExtra("buddyNO", this.f4532a.f4441j);
            intentM630a.addFlags(268435456);
        }
        this.f4532a.startActivity(intentM630a);
        this.f4532a.finish();
    }
}
