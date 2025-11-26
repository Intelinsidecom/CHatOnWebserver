package com.sec.chaton.smsplugin.p112ui;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.privateplugin.data.SetSpamResp;
import com.sec.chaton.smsplugin.C3847e;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fn */
/* loaded from: classes.dex */
class HandlerC4240fn extends Handler {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15594a;

    HandlerC4240fn(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15594a = pluginComposeMessageActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException, NumberFormatException {
        long j = 0;
        if (C3847e.m14651aB()) {
            this.f15594a.m16021ax();
            switch (message.what) {
                case 0:
                    if (message.arg1 == 34078720) {
                        SetSpamResp setSpamResp = (SetSpamResp) message.obj;
                        if (setSpamResp != null && !TextUtils.isEmpty(setSpamResp.getSpamCount())) {
                            long j2 = Long.parseLong(setSpamResp.getSpamCount());
                            if (j2 <= 0) {
                                j2 = 0;
                            }
                            j = j2;
                        }
                        this.f15594a.m16076g(j);
                        break;
                    } else if (message.arg1 == 33947648) {
                        this.f15594a.m16015ar();
                        break;
                    } else if (message.arg1 == 34013184) {
                        this.f15594a.m16015ar();
                        break;
                    }
                    break;
                default:
                    if (message.arg1 == 34078720) {
                        this.f15594a.m16017at();
                        break;
                    } else if (message.arg1 == 33947648) {
                        this.f15594a.m16015ar();
                        break;
                    } else if (message.arg1 == 34013184) {
                        this.f15594a.m16015ar();
                        break;
                    }
                    break;
            }
        }
    }
}
