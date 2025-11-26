package com.sec.chaton.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.p025d.EnumC0665r;

/* compiled from: BlackScreenNotification.java */
/* renamed from: com.sec.chaton.util.ae */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1282ae implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BlackScreenNotification f4463a;

    DialogInterfaceOnClickListenerC1282ae(BlackScreenNotification blackScreenNotification) {
        this.f4463a = blackScreenNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intentM630a;
        if (this.f4463a.f4385g == EnumC0665r.WEB_AUTH.m3012a()) {
            intentM630a = HomeActivity.m630a((Context) this.f4463a, false);
            intentM630a.putExtra("inboxNO", this.f4463a.f4384f);
            intentM630a.putExtra("chatType", this.f4463a.f4385g);
            intentM630a.putExtra("fromPush", 1);
            intentM630a.putExtra("Content", this.f4463a.f4383e);
        } else {
            intentM630a = HomeActivity.m630a((Context) this.f4463a, true);
            intentM630a.putExtra("inboxNO", this.f4463a.f4384f);
            intentM630a.putExtra("chatType", this.f4463a.f4385g);
            intentM630a.putExtra("fromPush", 1);
            intentM630a.putExtra(ChatFragment.f1735h, 1);
            intentM630a.putExtra("buddyNO", this.f4463a.f4389l);
            intentM630a.addFlags(268435456);
        }
        this.f4463a.startActivity(intentM630a);
        this.f4463a.finish();
    }
}
