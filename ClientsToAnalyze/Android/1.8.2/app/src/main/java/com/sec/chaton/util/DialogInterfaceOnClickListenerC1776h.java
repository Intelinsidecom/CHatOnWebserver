package com.sec.chaton.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.p017e.EnumC0695j;

/* compiled from: BlackScreenNotification.java */
/* renamed from: com.sec.chaton.util.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1776h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BlackScreenNotification f6435a;

    DialogInterfaceOnClickListenerC1776h(BlackScreenNotification blackScreenNotification) {
        this.f6435a = blackScreenNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intentM585a;
        if (this.f6435a.f6244j == EnumC0695j.WEB_AUTH.m3146a()) {
            intentM585a = HomeActivity.m585a((Context) this.f6435a, false);
            intentM585a.putExtra("inboxNO", this.f6435a.f6243i);
            intentM585a.putExtra("chatType", this.f6435a.f6244j);
            intentM585a.putExtra("fromPush", 1);
            intentM585a.putExtra("Content", this.f6435a.f6242e);
        } else {
            intentM585a = HomeActivity.m585a((Context) this.f6435a, true);
            intentM585a.putExtra("inboxNO", this.f6435a.f6243i);
            intentM585a.putExtra("chatType", this.f6435a.f6244j);
            intentM585a.putExtra("fromPush", 1);
            intentM585a.putExtra(ChatFragment.f1754j, 1);
            if (this.f6435a.f6254t != null) {
                String string = this.f6435a.f6254t.getText().toString();
                if (!TextUtils.isEmpty(string)) {
                    intentM585a.putExtra("lastTempMessage", string);
                }
            }
            intentM585a.putExtra("buddyNO", this.f6435a.f6248n);
            intentM585a.addFlags(268435456);
        }
        this.f6435a.startActivity(intentM585a);
        this.f6435a.finish();
    }
}
