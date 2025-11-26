package com.sec.chaton.p055d;

import android.os.Message;
import com.sec.chaton.p046a.p047a.C0790n;
import com.sec.chaton.p055d.p056a.AsyncTaskC2006dy;

/* compiled from: ProfileControl.java */
/* renamed from: com.sec.chaton.d.aj */
/* loaded from: classes.dex */
class AsyncTaskC2077aj extends AsyncTaskC2006dy {

    /* renamed from: a */
    final /* synthetic */ C2075ah f7575a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncTaskC2077aj(C2075ah c2075ah, String str) {
        super(str);
        this.f7575a = c2075ah;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        Message message = new Message();
        message.what = 402;
        message.obj = new C0790n(bool.booleanValue());
        this.f7575a.f7566b.sendMessage(message);
    }
}
