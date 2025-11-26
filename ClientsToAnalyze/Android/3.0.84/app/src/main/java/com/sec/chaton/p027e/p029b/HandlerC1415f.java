package com.sec.chaton.p027e.p029b;

import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.util.C3250y;

/* compiled from: AsyncCursorCloseTask.java */
/* renamed from: com.sec.chaton.e.b.f */
/* loaded from: classes.dex */
public class HandlerC1415f extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1414e f5254a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1415f(C1414e c1414e, Looper looper) {
        super(looper);
        this.f5254a = c1414e;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        Cursor cursor = (Cursor) message.obj;
        C3250y.m11456e("[CursorClose] CursorCloseHandler handleMessage()", getClass().getSimpleName());
        C3250y.m11456e("[CursorClose] start close cursor", getClass().getSimpleName());
        cursor.close();
        C3250y.m11456e("[CursorClose] end close cursor", getClass().getSimpleName());
    }
}
