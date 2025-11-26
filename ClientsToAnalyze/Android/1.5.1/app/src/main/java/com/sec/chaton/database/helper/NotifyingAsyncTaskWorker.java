package com.sec.chaton.database.helper;

import android.content.AsyncQueryHandler;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.database.task.AbstractQueryTask;

/* loaded from: classes.dex */
public class NotifyingAsyncTaskWorker extends AsyncQueryHandler {

    /* renamed from: a */
    private Handler f1776a;

    public class WorkerThreadHandler extends AsyncQueryHandler.WorkerHandler {
        public WorkerThreadHandler(Looper looper) {
            super(NotifyingAsyncTaskWorker.this, looper);
        }

        @Override // android.content.AsyncQueryHandler.WorkerHandler, android.os.Handler
        public void handleMessage(Message message) {
            ((AbstractQueryTask) message.obj).m2321a(message.what);
        }
    }

    public NotifyingAsyncTaskWorker() {
        super(null);
    }

    /* renamed from: a */
    private final void m2303a(int i, AbstractQueryTask abstractQueryTask) {
        Message message = new Message();
        message.what = i;
        message.obj = abstractQueryTask;
        this.f1776a.sendMessage(message);
    }

    /* renamed from: a */
    public static void m2304a(NotifyingAsyncTaskWorker notifyingAsyncTaskWorker, int i, AbstractQueryTask abstractQueryTask) {
        notifyingAsyncTaskWorker.m2303a(i, abstractQueryTask);
    }

    @Override // android.content.AsyncQueryHandler
    protected Handler createHandler(Looper looper) {
        this.f1776a = new WorkerThreadHandler(looper);
        return this.f1776a;
    }
}
