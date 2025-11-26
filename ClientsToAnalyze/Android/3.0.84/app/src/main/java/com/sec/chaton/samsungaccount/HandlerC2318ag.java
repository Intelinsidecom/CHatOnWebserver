package com.sec.chaton.samsungaccount;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3215cc;
import com.sec.common.p063a.AbstractC3271a;
import java.io.UnsupportedEncodingException;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.ag */
/* loaded from: classes.dex */
class HandlerC2318ag extends Handler {

    /* renamed from: a */
    final /* synthetic */ MainActivity f8740a;

    HandlerC2318ag(MainActivity mainActivity) {
        this.f8740a = mainActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws UnsupportedEncodingException {
        if (!this.f8740a.f8695aq) {
            switch (message.what) {
                case HttpResponseCode.FOUND /* 302 */:
                    if (!((C0267d) message.obj).m11704n()) {
                        if (this.f8740a.f8729z != null && this.f8740a.f8729z.isShowing()) {
                            this.f8740a.f8729z.dismiss();
                            this.f8740a.f8696ar = null;
                        }
                        this.f8740a.f8689ak = AbstractC3271a.m11494a(this.f8740a.f8714k).mo11495a(R.string.ams_attention_title).mo11506b(R.string.sync_fail_retry_again).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2320ai(this)).mo11507b(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC2319ah(this)).mo11511b(true).mo11505a();
                        if (!this.f8740a.f8695aq) {
                            this.f8740a.f8689ak.show();
                            break;
                        }
                    } else {
                        C3159aa.m10962a().m10983b("Is Group Uploaded", (Boolean) true);
                        C3250y.m11453c("local group info upload to server", getClass().getSimpleName());
                        if (C1493a.m6463a("auto_regi_feature")) {
                            if (C3214cb.m11248a().equals(EnumC3215cc.OTHER) || C3214cb.m11248a().equals(EnumC3215cc.FAIL)) {
                                this.f8740a.f8716m.m5614a();
                                break;
                            } else if (C3214cb.m11248a().equals(EnumC3215cc.SUCCESS)) {
                                this.f8740a.m8742a(this.f8740a.getResources().getString(R.string.auto_regi_buddy_sync));
                                this.f8740a.f8719p.m5717a();
                                break;
                            }
                        }
                    }
                    break;
            }
        }
    }
}
