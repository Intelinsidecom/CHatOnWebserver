package com.sec.chaton.p061g;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.common.CommonApplication;

/* compiled from: InviteHelper.java */
/* renamed from: com.sec.chaton.g.g */
/* loaded from: classes.dex */
class HandlerC2348g extends Handler {
    HandlerC2348g() {
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 100:
                Toast.makeText(CommonApplication.m18732r(), R.string.freesms_invitation_sent, 0).show();
                break;
        }
    }
}
