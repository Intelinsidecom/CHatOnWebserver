package com.sec.chaton.samsungaccount;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4863ca;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.g */
/* loaded from: classes.dex */
class HandlerC3387g extends Handler {

    /* renamed from: a */
    final /* synthetic */ AbstractMultiDeviceActivity f12348a;

    HandlerC3387g(AbstractMultiDeviceActivity abstractMultiDeviceActivity) {
        this.f12348a = abstractMultiDeviceActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f12348a.f12166t) {
            switch (message.what) {
                case 302:
                    if (!((C0778b) message.obj).m18954n()) {
                        if (this.f12348a.f12129U != null && this.f12348a.f12129U.isShowing()) {
                            this.f12348a.f12129U.dismiss();
                            this.f12348a.f12145ak = null;
                        }
                        this.f12348a.f12141ag = AbstractC4932a.m18733a(this.f12348a.f12118J).mo18734a(R.string.ams_attention_title).mo18746b(R.string.sync_fail_retry_again).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3389i(this)).mo18747b(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC3388h(this)).mo18751b(true).mo18745a();
                        if (!this.f12348a.f12166t) {
                            this.f12348a.f12141ag.show();
                            break;
                        }
                    } else {
                        C4809aa.m18104a().m18125b("Is Group Uploaded", (Boolean) true);
                        C4904y.m18641c("local group info upload to server", getClass().getSimpleName());
                        if (C2349a.m10301a("auto_regi_feature")) {
                            if (C4859bx.m18374a().equals(EnumC4863ca.OTHER) || C4859bx.m18374a().equals(EnumC4863ca.FAIL)) {
                                this.f12348a.f12119K.m9387a();
                                break;
                            } else if (C4859bx.m18374a().equals(EnumC4863ca.SUCCESS)) {
                                this.f12348a.m13093b(this.f12348a.getResources().getString(R.string.auto_regi_buddy_sync));
                                this.f12348a.f12122N.m9495a();
                                break;
                            }
                        }
                    }
                    break;
            }
        }
    }
}
