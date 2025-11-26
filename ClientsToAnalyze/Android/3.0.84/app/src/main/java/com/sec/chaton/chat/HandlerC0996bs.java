package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3250y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bs */
/* loaded from: classes.dex */
class HandlerC0996bs extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4067a;

    HandlerC0996bs(ChatFragment chatFragment) {
        this.f4067a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String string = message.getData().getString("download_uri");
        EnumC1455w enumC1455wM6358a = EnumC1455w.m6358a(message.arg1);
        if (C3250y.f11734b) {
            C3250y.m11450b("msgType : " + enumC1455wM6358a + ", uri: " + string, ChatFragment.f3484a);
        }
        if (this.f4067a.m4827ai() && this.f4067a.m4830ak() && !TextUtils.isEmpty(string) && !C0816a.f3113b.equals(string)) {
            switch (enumC1455wM6358a) {
                case CONTACT:
                    this.f4067a.m4930m(string);
                    break;
                case CALENDAR:
                    this.f4067a.m4927l(string);
                    break;
                case DOCUMENT:
                case FILE:
                    this.f4067a.m4935n(string);
                    break;
            }
        }
    }
}
