package com.sec.chaton.control;

import android.os.Message;
import com.sec.chaton.common.entry.ResultEntry;
import com.sec.chaton.control.task.ProfileUploadTask;

/* renamed from: com.sec.chaton.control.l */
/* loaded from: classes.dex */
class AsyncTaskC0183l extends ProfileUploadTask {

    /* renamed from: a */
    final /* synthetic */ ProfileControl f1423a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncTaskC0183l(ProfileControl profileControl, String str) {
        super(str);
        this.f1423a = profileControl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        Message message = new Message();
        message.what = 402;
        message.obj = new ResultEntry(bool.booleanValue());
        this.f1423a.f1380a.sendMessage(message);
    }
}
