package com.sec.chaton.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.p017e.EnumC0695j;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.bo */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1759bo implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ScreenOnNotification f6397a;

    DialogInterfaceOnClickListenerC1759bo(ScreenOnNotification screenOnNotification) {
        this.f6397a = screenOnNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intentM585a;
        if (this.f6397a.f6300j == EnumC0695j.WEB_AUTH.m3146a()) {
            intentM585a = HomeActivity.m585a((Context) this.f6397a, false);
            intentM585a.putExtra("inboxNO", this.f6397a.f6299i);
            intentM585a.putExtra("chatType", this.f6397a.f6300j);
            intentM585a.putExtra("fromPush", 1);
            intentM585a.putExtra("Content", this.f6397a.f6298e);
        } else {
            intentM585a = HomeActivity.m585a((Context) this.f6397a, true);
            intentM585a.putExtra("inboxNO", this.f6397a.f6299i);
            intentM585a.putExtra("chatType", this.f6397a.f6300j);
            intentM585a.putExtra("fromPush", 1);
            intentM585a.putExtra(ChatFragment.f1754j, 1);
            if (this.f6397a.f6308r != null) {
                String string = this.f6397a.f6308r.getText().toString();
                if (!TextUtils.isEmpty(string)) {
                    intentM585a.putExtra("lastTempMessage", string);
                }
            }
            intentM585a.putExtra("buddyNO", this.f6397a.f6302l);
            intentM585a.addFlags(268435456);
        }
        this.f6397a.startActivity(intentM585a);
        this.f6397a.finish();
    }
}
