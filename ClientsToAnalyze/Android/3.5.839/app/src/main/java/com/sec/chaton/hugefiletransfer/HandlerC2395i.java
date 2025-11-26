package com.sec.chaton.hugefiletransfer;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: HugeFileUploadService.java */
/* renamed from: com.sec.chaton.hugefiletransfer.i */
/* loaded from: classes.dex */
class HandlerC2395i extends Handler {

    /* renamed from: a */
    final /* synthetic */ HugeFileUploadService f8506a;

    HandlerC2395i(HugeFileUploadService hugeFileUploadService) {
        this.f8506a = hugeFileUploadService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (C4904y.f17872b) {
        }
        switch (message.what) {
            case 1:
                Intent intent = (Intent) message.obj;
                if (intent != null) {
                    if (intent.getBooleanExtra("huge_file_from_chat", false)) {
                        intent.setClass(this.f8506a.getApplicationContext(), HugeFileUploadBroadcastReceiver.class);
                        this.f8506a.sendBroadcast(intent);
                        break;
                    } else if (C3847e.m14652aC()) {
                        if (C4822an.m18226c()) {
                            this.f8506a.m10376a(intent);
                            int intExtra = intent.getIntExtra("huge_file_max_upload_count", 0);
                            C5179v.m19811a(this.f8506a, this.f8506a.getString(R.string.hugefile_file_system_message, new Object[]{Integer.valueOf(intExtra), Integer.valueOf(intExtra - intent.getIntExtra("huge_file_upload_count", 0))}), 0).show();
                            break;
                        } else {
                            C3890m.m14996b(HugeFileUploadService.f8481a, "Large file message cannot be sent because SMS MMS mode is off");
                            break;
                        }
                    }
                }
                break;
            case 2:
                C2402p c2402p = (C2402p) message.obj;
                if (C4904y.f17872b) {
                    C4904y.m18639b("mCurrentUploadId: " + this.f8506a.f8483c + " info: " + c2402p, HugeFileUploadService.f8481a);
                }
                if (this.f8506a.f8483c == c2402p.m10425a()) {
                    this.f8506a.startForeground((int) c2402p.m10425a(), this.f8506a.m10373a(c2402p));
                    break;
                }
                break;
            case 3:
                if (this.f8506a.f8482b != null) {
                    this.f8506a.f8482b.m10413a(false);
                }
                Intent intent2 = (Intent) message.obj;
                if (intent2 != null) {
                    if (intent2.getBooleanExtra("huge_file_from_chat", false)) {
                        intent2.setClass(this.f8506a.getApplicationContext(), HugeFileUploadBroadcastReceiver.class);
                        this.f8506a.sendBroadcast(intent2);
                        break;
                    } else if (C3847e.m14652aC()) {
                        this.f8506a.m10375a(intent2.getLongExtra("huge_file_request_id", 0L));
                        this.f8506a.m10381b(intent2);
                        break;
                    }
                }
                break;
            case 4:
                C5179v.m19811a(CommonApplication.m18732r(), message.obj.toString(), 0).show();
                break;
        }
    }
}
