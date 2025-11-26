package com.sec.chaton.control.task;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.ChatONHttpClient2;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public abstract class AbstractHttpTask2 implements Runnable {
    private String bodyXml = null;
    private boolean isInterrupted = false;
    protected final HttpEnvelope mHttpEnvelope;
    protected Handler mUiHandler;
    protected Message msg;

    public AbstractHttpTask2(Handler handler, HttpEnvelope httpEnvelope) {
        this.mUiHandler = null;
        this.mHttpEnvelope = httpEnvelope;
        this.mUiHandler = handler;
    }

    public abstract void afterRequest(HttpEntry httpEntry);

    public abstract String beforeRequest();

    protected final void interrupt() {
        this.isInterrupted = true;
    }

    public Message retrieveResultMsg() {
        return this.msg;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.msg = new Message();
        HttpEntry httpEntry = new HttpEntry(this.mHttpEnvelope);
        httpEntry.m1946a(HttpResultCode.ERROR);
        this.msg.what = this.mHttpEnvelope.m2734g();
        try {
            this.bodyXml = beforeRequest();
            if (this.isInterrupted) {
                httpEntry.m1946a(HttpResultCode.NO_REQUEST);
            } else {
                ChatONHttpClient2.m2704a(httpEntry, this.bodyXml);
            }
            afterRequest(httpEntry);
            this.msg.obj = httpEntry;
            this.mUiHandler.sendMessage(this.msg);
        } catch (Exception e) {
            ChatONLogWriter.m3501a(e, getClass().getSimpleName());
            this.msg.obj = httpEntry;
            this.mUiHandler.sendMessage(this.msg);
        }
    }

    public HttpEntry runForNonThread() {
        HttpEntry httpEntry = new HttpEntry(this.mHttpEnvelope);
        httpEntry.m1946a(HttpResultCode.ERROR);
        try {
            this.bodyXml = beforeRequest();
            if (this.isInterrupted) {
                httpEntry.m1946a(HttpResultCode.NO_REQUEST);
            } else {
                ChatONHttpClient2.m2704a(httpEntry, this.bodyXml);
            }
            afterRequest(httpEntry);
        } catch (Exception e) {
            ChatONLogWriter.m3501a(e, getClass().getSimpleName());
        }
        return httpEntry;
    }
}
