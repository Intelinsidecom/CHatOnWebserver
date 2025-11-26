package com.sec.chaton.msgbox;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.sec.chaton.control.MessageControl;
import com.sec.chaton.control.task.FileDownloadTask2;
import com.sec.chaton.control.task.FileUploadTask2;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.util.ChatONNotificationManager;

/* renamed from: com.sec.chaton.msgbox.r */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0268r implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2009a;

    /* renamed from: b */
    final /* synthetic */ ChatONContract.InBoxTable.ChatType f2010b;

    /* renamed from: c */
    final /* synthetic */ String f2011c;

    /* renamed from: d */
    final /* synthetic */ String f2012d;

    /* renamed from: e */
    final /* synthetic */ int f2013e;

    /* renamed from: f */
    final /* synthetic */ MsgboxFragment f2014f;

    DialogInterfaceOnClickListenerC0268r(MsgboxFragment msgboxFragment, String str, ChatONContract.InBoxTable.ChatType chatType, String str2, String str3, int i) {
        this.f2014f = msgboxFragment;
        this.f2009a = str;
        this.f2010b = chatType;
        this.f2011c = str2;
        this.f2012d = str3;
        this.f2013e = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ChatONNotificationManager.m3515a(this.f2014f.getActivity()).m3517a(this.f2014f.f1959A);
        if (!TextUtils.isEmpty(this.f2009a) && this.f2010b != ChatONContract.InBoxTable.ChatType.BROADCAST) {
            this.f2014f.f1968J = MessageControl.m2011a(this.f2014f.f1970L, this.f2011c);
            this.f2014f.f1968J.m2050a(this.f2011c, this.f2012d, this.f2013e);
            this.f2014f.f1968J.m2056c(Long.MAX_VALUE);
            if (!this.f2014f.f1969K.isShowing()) {
                this.f2014f.f1969K.show();
            }
            this.f2014f.f1968J.m2040a(this.f2010b, this.f2009a, this.f2011c, (String[]) this.f2014f.f1980s.toArray(new String[0]));
            this.f2014f.f1968J.m2054b(true);
            return;
        }
        this.f2014f.f1979r.startDelete(1, null, ChatONContract.InBoxTable.f1717a, "inbox_no IN ('" + this.f2011c + "')", null);
        this.f2014f.f1979r.startDelete(2, null, ChatONContract.MessageTable.f1726a, "message_inbox_no='" + this.f2011c + "'", null);
        if (MessageControl.m2012a(this.f2011c) != null && MessageControl.m2012a(this.f2011c).f1367d != null) {
            for (Long l : MessageControl.m2012a(this.f2011c).f1367d.keySet()) {
                if (MessageControl.m2012a(this.f2011c).f1367d.containsKey(l)) {
                    ((FileDownloadTask2) MessageControl.m2012a(this.f2011c).f1367d.get(l)).cancel(true);
                    MessageControl.m2012a(this.f2011c).f1367d.remove(l);
                }
            }
        }
        if (MessageControl.m2012a(this.f2011c) != null && MessageControl.m2012a(this.f2011c).f1366c != null) {
            for (Long l2 : MessageControl.m2012a(this.f2011c).f1366c.keySet()) {
                if (MessageControl.m2012a(this.f2011c).f1366c.containsKey(l2)) {
                    ((FileUploadTask2) MessageControl.m2012a(this.f2011c).f1366c.get(l2)).cancel(true);
                    MessageControl.m2012a(this.f2011c).f1366c.remove(l2);
                }
            }
        }
        this.f2014f.m2429g();
    }
}
