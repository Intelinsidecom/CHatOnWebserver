package com.sec.chaton.smsplugin.p112ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.smsplugin.p110g.C3855a;
import com.sec.common.CommonApplication;
import java.io.IOException;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.dc */
/* loaded from: classes.dex */
class HandlerC4175dc extends Handler {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15497a;

    HandlerC4175dc(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15497a = pluginComposeMessageActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws IOException {
        Intent intent;
        switch (message.what) {
            case 1:
                this.f15497a.m16096p();
                break;
            case 2:
                if (this.f15497a.m15920Z()) {
                    this.f15497a.m16102s();
                    break;
                }
                break;
            case 3:
            case 8:
            case 9:
            case 10:
                C4149cd.m16407a(this.f15497a, this.f15497a.f14996ap, message.what);
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                this.f15497a.m16080g(true);
                break;
            case 11:
                C3855a c3855a = this.f15497a.f14996ap.m14457g().m14923l().get(0);
                String strM14744a = c3855a.m14744a();
                if ("text/x-vCard".equals(strM14744a) || "text/x-vcard".equals(strM14744a)) {
                    intent = new Intent("android.intent.action.VIEW");
                    intent.putExtra("showDetail", true);
                } else {
                    intent = new Intent("android.intent.action.VIEW");
                }
                intent.addFlags(1);
                if ("text/x-vNote".equals(strM14744a)) {
                    intent.setDataAndType(c3855a.m14746b(), "text/x-vnote");
                } else if ("text/x-vCard".equals(strM14744a) || "text/x-vcard".equals(strM14744a)) {
                    intent.setDataAndType(c3855a.m14746b(), "text/x-vcard");
                } else {
                    intent.setDataAndType(c3855a.m14746b(), strM14744a);
                }
                intent.addFlags(268435456);
                try {
                    CommonApplication.m18732r().startActivity(intent);
                    break;
                } catch (ActivityNotFoundException e) {
                    this.f15497a.m15935a(e, intent);
                    return;
                }
                break;
            case 12:
                this.f15497a.f15031bh = false;
                this.f15497a.f14996ap.m14442a(true);
                this.f15497a.f14996ap.m14471u();
                break;
        }
    }
}
