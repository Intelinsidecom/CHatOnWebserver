package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.util.C4904y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cs */
/* loaded from: classes.dex */
class HandlerC1638cs extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6167a;

    HandlerC1638cs(ChatFragment chatFragment) {
        this.f6167a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String string = message.getData().getString("download_uri");
        EnumC2214ab enumC2214abM10070a = EnumC2214ab.m10070a(message.arg1);
        if (C4904y.f17872b) {
            C4904y.m18639b("msgType : " + enumC2214abM10070a + ", uri: " + string, ChatFragment.f5461a);
        }
        if (this.f6167a.m8053ax() && this.f6167a.m8058az() && !TextUtils.isEmpty(string) && !C1427a.f5066d.equals(string)) {
            switch (enumC2214abM10070a) {
                case CONTACT:
                    this.f6167a.m8190n(string);
                    break;
                case CALENDAR:
                    this.f6167a.m8185m(string);
                    break;
                case DOCUMENT:
                case FILE:
                    this.f6167a.m8192o(string);
                    break;
            }
        }
    }
}
