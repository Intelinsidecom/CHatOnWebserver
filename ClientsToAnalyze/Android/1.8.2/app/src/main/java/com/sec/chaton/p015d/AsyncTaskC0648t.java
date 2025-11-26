package com.sec.chaton.p015d;

import android.os.Message;
import com.sec.chaton.p007a.p008a.C0105f;
import com.sec.chaton.p015d.p016a.AsyncTaskC0572bm;

/* compiled from: ProfileControl.java */
/* renamed from: com.sec.chaton.d.t */
/* loaded from: classes.dex */
class AsyncTaskC0648t extends AsyncTaskC0572bm {

    /* renamed from: a */
    final /* synthetic */ C0647s f2515a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncTaskC0648t(C0647s c0647s, String str) {
        super(str);
        this.f2515a = c0647s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        Message message = new Message();
        message.what = 402;
        message.obj = new C0105f(bool.booleanValue());
        this.f2515a.f2514b.sendMessage(message);
    }
}
