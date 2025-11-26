package com.sec.chaton.p013a;

import android.os.Message;
import com.sec.chaton.p013a.p014a.AsyncTaskC0143as;
import com.sec.chaton.p015b.p016a.C0254b;

/* compiled from: ProfileControl.java */
/* renamed from: com.sec.chaton.a.ab */
/* loaded from: classes.dex */
class AsyncTaskC0189ab extends AsyncTaskC0143as {

    /* renamed from: a */
    final /* synthetic */ C0226y f473a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncTaskC0189ab(C0226y c0226y, String str) {
        super(str);
        this.f473a = c0226y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        Message message = new Message();
        message.what = 402;
        message.obj = new C0254b(bool.booleanValue());
        this.f473a.f561a.sendMessage(message);
    }
}
