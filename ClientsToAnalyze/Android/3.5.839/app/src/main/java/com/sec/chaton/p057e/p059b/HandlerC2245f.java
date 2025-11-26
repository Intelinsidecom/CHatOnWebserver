package com.sec.chaton.p057e.p059b;

import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.util.C4904y;

/* compiled from: AsyncCursorCloseTask.java */
/* renamed from: com.sec.chaton.e.b.f */
/* loaded from: classes.dex */
public class HandlerC2245f extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2244e f7994a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2245f(C2244e c2244e, Looper looper) {
        super(looper);
        this.f7994a = c2244e;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        Cursor cursor = (Cursor) message.obj;
        C4904y.m18646e("[CursorClose] CursorCloseHandler handleMessage()", getClass().getSimpleName());
        C4904y.m18646e("[CursorClose] start close cursor", getClass().getSimpleName());
        cursor.close();
        C4904y.m18646e("[CursorClose] end close cursor", getClass().getSimpleName());
    }
}
