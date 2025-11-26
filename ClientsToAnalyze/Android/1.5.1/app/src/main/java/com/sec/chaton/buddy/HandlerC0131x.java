package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.database.helper.NotifyingAsyncTaskWorker;
import com.sec.chaton.database.task.BuddyBlockTask;

/* renamed from: com.sec.chaton.buddy.x */
/* loaded from: classes.dex */
class HandlerC0131x extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f717a;

    HandlerC0131x(BuddyProfileActivity buddyProfileActivity) {
        this.f717a = buddyProfileActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 8) {
            NotifyingAsyncTaskWorker.m2304a(new NotifyingAsyncTaskWorker(), 2, new BuddyBlockTask(this.f717a.f580e, this.f717a.f585j, 2, true));
        }
    }
}
