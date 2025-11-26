package com.sec.chaton.msgbox;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.chat.ChatUtil;
import com.sec.chaton.common.entry.MessageResultEntry;
import com.sec.chaton.trunk.database.helper.TrunkDatabaseHelper;

/* renamed from: com.sec.chaton.msgbox.p */
/* loaded from: classes.dex */
class HandlerC0266p extends Handler {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f2007a;

    HandlerC0266p(MsgboxFragment msgboxFragment) {
        this.f2007a = msgboxFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f2007a.getActivity() == null) {
        }
        MessageResultEntry messageResultEntry = (MessageResultEntry) message.obj;
        switch (message.what) {
            case 2:
                if (!messageResultEntry.f1325a && ChatUtil.m792a(message.what, messageResultEntry.m1963a()) != MessageResultEntry.errorCode.CHANGE_SERVER) {
                    this.f2007a.f1968J.m2054b(false);
                    Toast.makeText(this.f2007a.getActivity(), C0062R.string.toast_end_chat_fail, 0).show();
                    break;
                } else {
                    if (!this.f2007a.f1969K.isShowing()) {
                        this.f2007a.f1969K.show();
                    }
                    this.f2007a.f1968J.m2040a(this.f2007a.f1986y, this.f2007a.f1985x, this.f2007a.f1982u, (String[]) this.f2007a.f1980s.toArray(new String[0]));
                    break;
                }
                break;
            case 8:
                if (this.f2007a.f1969K.isShowing()) {
                    this.f2007a.f1969K.dismiss();
                }
                this.f2007a.f1968J.m2054b(false);
                if (!messageResultEntry.f1325a && ChatUtil.m792a(message.what, messageResultEntry.m1963a()) != MessageResultEntry.errorCode.REGARD_SUCCEESS) {
                    Toast.makeText(this.f2007a.getActivity(), C0062R.string.toast_end_chat_fail, 0).show();
                    break;
                } else {
                    this.f2007a.m2429g();
                    this.f2007a.f1968J.m2057d();
                    this.f2007a.f1968J.m2055c();
                    new TrunkDatabaseHelper(this.f2007a.getActivity()).removeTrunk(this.f2007a.f1985x);
                    break;
                }
                break;
        }
    }
}
