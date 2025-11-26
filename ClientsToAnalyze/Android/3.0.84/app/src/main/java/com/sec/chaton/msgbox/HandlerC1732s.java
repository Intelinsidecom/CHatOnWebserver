package com.sec.chaton.msgbox;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1335m;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p029b.C1421l;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.provider.p049a.C2037a;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.s */
/* loaded from: classes.dex */
class HandlerC1732s extends Handler {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f6405a;

    HandlerC1732s(MsgboxFragment msgboxFragment) {
        this.f6405a = msgboxFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 2301:
                C3250y.m11450b("mChatListSyncHandler GetChatListInfo.GET_CHATLISTINFO", getClass().getSimpleName());
                if (this.f6405a.f6233B.isShowing()) {
                    this.f6405a.f6233B.dismiss();
                    z = true;
                } else {
                    z = false;
                }
                if (this.f6405a.f6234C != null && this.f6405a.f6234C.isShowing()) {
                    this.f6405a.f6234C.dismiss();
                }
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                    C3250y.m11456e("Success to sync ChatListInfo ... ", getClass().getSimpleName());
                    if (C2037a.m8129f()) {
                        C2037a.m8128e();
                        C1379w.m6203a(new C1379w(), -1, new C1421l(null, C1103a.f4442d, false));
                    }
                    C1335m.m5781a((Handler) null);
                    if (z) {
                        if (!C2037a.m8125b()) {
                            C3250y.m11456e("GET_CHATLISTINFO : NO_CONTENT ", getClass().getSimpleName());
                            this.f6405a.m7045k();
                            break;
                        } else {
                            C3641ai.m13211a(GlobalApplication.m11493l(), this.f6405a.getResources().getString(R.string.chat_history_loaded_toast), 0).show();
                            this.f6405a.m7040h();
                            break;
                        }
                    }
                } else {
                    if (z) {
                        C3641ai.m13211a(GlobalApplication.m11493l(), this.f6405a.getResources().getString(R.string.sync_fail_retry_again), 0).show();
                    }
                    if (C3250y.f11733a) {
                        C3250y.m11456e("Fail to sync ChatListInfo ... ", getClass().getSimpleName());
                        C3250y.m11456e("ChatListInfo Fail code : " + c0267d.m1351b() + ", message : " + c0267d.m1357h(), getClass().getSimpleName());
                        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                            C1533b.m6522a("01000006", "1008", c0267d);
                            break;
                        }
                    }
                }
                break;
        }
    }
}
