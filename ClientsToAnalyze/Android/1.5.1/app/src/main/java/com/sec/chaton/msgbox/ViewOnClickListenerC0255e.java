package com.sec.chaton.msgbox;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;

/* renamed from: com.sec.chaton.msgbox.e */
/* loaded from: classes.dex */
class ViewOnClickListenerC0255e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f1992a;

    /* renamed from: b */
    final /* synthetic */ String f1993b;

    /* renamed from: c */
    final /* synthetic */ MsgBoxListAdapter f1994c;

    ViewOnClickListenerC0255e(MsgBoxListAdapter msgBoxListAdapter, String str, String str2) {
        this.f1994c = msgBoxListAdapter;
        this.f1992a = str;
        this.f1993b = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f1994c.mContext, (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", this.f1992a);
        intent.putExtra("PROFILE_BUDDY_NAME", this.f1993b);
        this.f1994c.mContext.startActivity(intent);
    }
}
