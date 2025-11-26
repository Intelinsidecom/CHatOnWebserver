package com.sec.chaton;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.AvaliableApps;
import com.sec.chaton.settings.AboutFragment;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: UpgradeDialog.java */
/* renamed from: com.sec.chaton.az */
/* loaded from: classes.dex */
class HandlerC0235az extends Handler {

    /* renamed from: a */
    final /* synthetic */ UpgradeDialog f767a;

    HandlerC0235az(UpgradeDialog upgradeDialog) {
        this.f767a = upgradeDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f767a.f302d != null) {
            this.f767a.f303e.dismiss();
        }
        C0101b c0101b = (C0101b) message.obj;
        AvaliableApps avaliableApps = (AvaliableApps) c0101b.m671d();
        if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR && avaliableApps.resultCode.equals("2")) {
            String string = C1789u.m6075a().getString("SamsungappsUrl", "");
            if (string != null) {
                string = string.replace("com.sec.chaton", this.f767a.f302d.getPackageName());
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            Uri uri = Uri.parse(string);
            intent.addFlags(335544352);
            intent.setData(uri);
            try {
                this.f767a.startActivity(intent);
                C1786r.m6061b("apps market was installed in the device", getClass().getSimpleName());
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
            this.f767a.finish();
            return;
        }
        if (!AboutFragment.m4476a(this.f767a.f302d, false)) {
            this.f767a.finish();
        }
    }
}
