package com.sec.chaton.chat;

import com.sec.chaton.msgbox.AsyncTaskC2644bi;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.dh */
/* loaded from: classes.dex */
class AsyncTaskC1654dh extends AsyncTaskC2644bi {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6186a;

    AsyncTaskC1654dh(ChatFragment chatFragment) {
        this.f6186a = chatFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r3) {
        this.f6186a.m8259f(this.f6186a.f5750v);
        super.onPostExecute(r3);
    }
}
