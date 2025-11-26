package com.sec.chaton.smsplugin.p112ui;

import android.content.Intent;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.dialog.BuddyDialog;

/* compiled from: MessagingInfoActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.cp */
/* loaded from: classes.dex */
class C4161cp implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ MessagingInfoActivity f15465a;

    C4161cp(MessagingInfoActivity messagingInfoActivity) {
        this.f15465a = messagingInfoActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C4168cw c4168cw = (C4168cw) view.getTag();
        if (c4168cw.f15482g == 2) {
            String number = !TextUtils.isEmpty(c4168cw.f15483h) ? PhoneNumberUtils.formatNumber(c4168cw.f15483h) : this.f15465a.f14885W.getString(R.string.unknown);
            Intent intent = new Intent(this.f15465a.f14885W, (Class<?>) BuddyDialog.class);
            intent.putExtra("BUDDY_DIALOG_BUDDY_NO", "");
            intent.putExtra("BUDDY_DIALOG_BUDDY_NAME", number);
            intent.putExtra("BUDDY_DIALOG_CHATROOM_TYPE", "sms");
            this.f15465a.f14885W.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this.f15465a.f14885W, (Class<?>) BuddyDialog.class);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_NO", c4168cw.f15480e);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_NAME", c4168cw.f15481f);
        this.f15465a.f14885W.startActivity(intent2);
    }
}
