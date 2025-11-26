package com.sec.chaton.p025d;

import android.os.Message;
import com.sec.chaton.p016a.p017a.C0274k;
import com.sec.chaton.p025d.p026a.AsyncTaskC1234dh;

/* compiled from: ProfileControl.java */
/* renamed from: com.sec.chaton.d.x */
/* loaded from: classes.dex */
class AsyncTaskC1346x extends AsyncTaskC1234dh {

    /* renamed from: a */
    final /* synthetic */ C1345w f5081a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncTaskC1346x(C1345w c1345w, String str) {
        super(str);
        this.f5081a = c1345w;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        Message message = new Message();
        message.what = 402;
        message.obj = new C0274k(bool.booleanValue());
        this.f5081a.f5075b.sendMessage(message);
    }
}
