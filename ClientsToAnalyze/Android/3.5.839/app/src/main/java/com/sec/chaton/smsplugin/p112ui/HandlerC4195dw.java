package com.sec.chaton.smsplugin.p112ui;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.io.File;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.dw */
/* loaded from: classes.dex */
class HandlerC4195dw extends Handler {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15522a;

    HandlerC4195dw(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15522a = pluginComposeMessageActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws IllegalStateException {
        super.handleMessage(message);
        if (this.f15522a.f15038bo != null) {
            this.f15522a.f15038bo.dismiss();
        }
        this.f15522a.f14953Y.setItemsCanFocus(true);
        if (message.obj == null) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.toast_error, 0).show();
        } else if (message.arg1 >= 13) {
            this.f15522a.m16063e(Uri.fromFile(new File(message.obj.toString())), false);
        }
    }
}
