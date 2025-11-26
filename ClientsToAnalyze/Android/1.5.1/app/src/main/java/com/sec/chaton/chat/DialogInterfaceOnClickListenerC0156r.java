package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.sec.chaton.control.MessageControl;
import com.sec.chaton.control.task.FileDownloadTask2;
import com.sec.chaton.control.task.FileUploadTask2;
import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.chat.r */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0156r implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f975a;

    /* renamed from: b */
    final /* synthetic */ ChatONContract.InBoxTable.ChatType f976b;

    /* renamed from: c */
    final /* synthetic */ String f977c;

    /* renamed from: d */
    final /* synthetic */ ChatFragment f978d;

    DialogInterfaceOnClickListenerC0156r(ChatFragment chatFragment, String str, ChatONContract.InBoxTable.ChatType chatType, String str2) {
        this.f978d = chatFragment;
        this.f975a = str;
        this.f976b = chatType;
        this.f977c = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!TextUtils.isEmpty(this.f975a) && this.f976b != ChatONContract.InBoxTable.ChatType.BROADCAST) {
            if (!this.f978d.f734D.isShowing()) {
                this.f978d.f734D.show();
            }
            this.f978d.f785ac.m2040a(this.f978d.f826w, this.f978d.f827x, this.f978d.f822s, (String[]) this.f978d.f786ad.toArray(new String[0]));
            return;
        }
        this.f978d.f743M.startDelete(1, null, ChatONContract.InBoxTable.f1717a, "inbox_no IN ('" + this.f977c + "')", null);
        this.f978d.f743M.startDelete(2, null, ChatONContract.MessageTable.f1726a, "message_inbox_no='" + this.f977c + "'", null);
        if (MessageControl.m2012a(this.f977c) != null && MessageControl.m2012a(this.f977c).f1367d != null) {
            for (Long l : MessageControl.m2012a(this.f977c).f1367d.keySet()) {
                if (MessageControl.m2012a(this.f977c).f1367d.containsKey(l)) {
                    ((FileDownloadTask2) MessageControl.m2012a(this.f977c).f1367d.get(l)).cancel(true);
                    MessageControl.m2012a(this.f977c).f1367d.remove(l);
                }
            }
        }
        if (MessageControl.m2012a(this.f977c) != null && MessageControl.m2012a(this.f977c).f1366c != null) {
            for (Long l2 : MessageControl.m2012a(this.f977c).f1366c.keySet()) {
                if (MessageControl.m2012a(this.f977c).f1366c.containsKey(l2)) {
                    ((FileUploadTask2) MessageControl.m2012a(this.f977c).f1366c.get(l2)).cancel(true);
                    MessageControl.m2012a(this.f977c).f1366c.remove(l2);
                }
            }
        }
        this.f978d.m726f();
    }
}
