package com.sec.chaton.chat.p024b;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.widget.C3641ai;

/* compiled from: TranslateHelper.java */
/* renamed from: com.sec.chaton.chat.b.o */
/* loaded from: classes.dex */
final class HandlerC0964o extends Handler {
    HandlerC0964o() {
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        C3641ai.m13210a(GlobalApplication.m11493l(), R.string.failed_to_translate, 0).show();
    }
}
