package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.GetAllMessageList;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: MessageLoader.java */
/* renamed from: com.sec.chaton.chat.hm */
/* loaded from: classes.dex */
class HandlerC1767hm extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1763hi f6641a;

    HandlerC1767hm(C1763hi c1763hi) {
        this.f6641a = c1763hi;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 811:
                this.f6641a.f6630m = false;
                this.f6641a.f6632o = false;
                if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    GetAllMessageList getAllMessageList = (GetAllMessageList) c0778b.m3110e();
                    if (getAllMessageList == null) {
                        if (C4904y.f17873c) {
                            C4904y.m18641c("METHOD_GET_ALL_MESSAGES handling - allMessages is null", "MessageLoader");
                            break;
                        }
                    } else {
                        boolean zBooleanValue = getAllMessageList.has_more.booleanValue();
                        ArrayList<com.sec.chaton.p065io.entry.inner.Message> arrayList = getAllMessageList.messages;
                        if (zBooleanValue) {
                            if (arrayList.size() <= 0) {
                                str = Spam.ACTIVITY_CANCEL;
                            } else {
                                Collections.sort(arrayList, new C1768hn(this));
                                str = arrayList.get(0).tid;
                            }
                        } else {
                            str = "-1";
                        }
                    }
                } else if (c0778b.m3107b() != EnumC2464o.NO_CONTENT) {
                    this.f6641a.f6632o = true;
                    str = Spam.ACTIVITY_CANCEL;
                } else {
                    str = "-1";
                }
                if (this.f6641a.f6628k != null) {
                    this.f6641a.f6628k.m8752a(str);
                }
                if (C4904y.f17873c) {
                    C4904y.m18641c("METHOD_GET_ALL_MESSAGES handling", "MessageLoader");
                    break;
                }
                break;
        }
    }
}
