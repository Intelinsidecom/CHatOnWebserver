package com.sec.chaton.smsplugin.p112ui;

import android.content.Intent;
import android.provider.Telephony;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.dialog.MeDialog;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.util.C4822an;
import com.sec.common.CommonApplication;

/* compiled from: MessageListItem.java */
/* renamed from: com.sec.chaton.smsplugin.ui.bj */
/* loaded from: classes.dex */
class ViewOnClickListenerC4128bj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4108aq f15368a;

    /* renamed from: b */
    final /* synthetic */ MessageListItem f15369b;

    ViewOnClickListenerC4128bj(MessageListItem messageListItem, C4108aq c4108aq) {
        this.f15369b = messageListItem;
        this.f15368a = c4108aq;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean zIsOutgoingFolder = Telephony.Sms.isOutgoingFolder(this.f15368a.m16306i());
        C3782a c3782aM14205a = zIsOutgoingFolder ? C3782a.m14205a(false) : C3782a.m14204a(zIsOutgoingFolder ? null : this.f15368a.f15275j, false);
        if (zIsOutgoingFolder) {
            if (C4822an.m18218a()) {
                GlobalApplication.m10279a();
                Intent intent = new Intent(CommonApplication.m18732r(), (Class<?>) MeDialog.class);
                intent.putExtra("ME_DIALOG_NAME", GlobalApplication.m10279a().getString(R.string.buddy_profile_interaction_me));
                intent.putExtra("ME_DIALOG_STATUSMSG", "");
                intent.setFlags(268435456);
                GlobalApplication.m10279a();
                CommonApplication.m18732r().startActivity(intent);
                return;
            }
            return;
        }
        GlobalApplication.m10279a();
        Intent intent2 = new Intent(CommonApplication.m18732r(), (Class<?>) BuddyDialog.class);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_NO", c3782aM14205a.m14269k());
        intent2.putExtra("BUDDY_DIALOG_BUDDY_NAME", c3782aM14205a.m14264f());
        intent2.putExtra("BUDDY_DIALOG_CHATROOM_TYPE", "sms");
        intent2.setFlags(268435456);
        GlobalApplication.m10279a();
        CommonApplication.m18732r().startActivity(intent2);
    }
}
