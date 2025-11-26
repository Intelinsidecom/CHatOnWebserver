package com.coolots.chaton.call.view;

import android.os.Message;
import com.sds.coolots.call.view.CallActivity;
import com.sds.coolots.call.view.CallHandler;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class ChatOnCallHandler extends CallHandler implements DisposeInterface {
    private boolean bDisposed;

    private void logI(String message) {
        Log.m2963i("[ChatOnCallHandler]" + message);
    }

    public ChatOnCallHandler(CallActivity parent) {
        super(parent);
        this.bDisposed = false;
    }

    @Override // com.sds.coolots.call.view.CallHandler, com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        this.bDisposed = true;
    }

    @Override // com.sds.coolots.call.view.CallHandler, android.os.Handler
    public void handleMessage(Message msg) {
        logI("ChatOnCallHandler handleMessage(" + msg + ")");
        if (this.bDisposed) {
            logI("ChatOnCallHandler was disposed. so this message is going to be ignored.");
            return;
        }
        if (msg.what == 10002) {
            this.mParent.setDisplayDialog(10002);
        }
        if (msg.what == 10003) {
            this.mParent.startRecordTime();
        }
        if (msg.what == 10004) {
            this.mParent.stopRecordFromEngine();
        }
        super.handleMessage(msg);
    }
}
