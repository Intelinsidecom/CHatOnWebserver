package com.sec.chaton.registration;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.GetVersionNotice;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.samsungaccount.MainActivity;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.at */
/* loaded from: classes.dex */
class HandlerC2142at extends Handler {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8416a;

    HandlerC2142at(AuthenticatorActivity authenticatorActivity) {
        this.f8416a = authenticatorActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 104:
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    this.f8416a.m8443a(EnumC2157bh.get_server_address, c0267d.m1356g());
                    break;
                } else {
                    this.f8416a.f8153l.m5694b();
                    break;
                }
                break;
            case 1104:
                if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                    this.f8416a.m8443a(EnumC2157bh.version_for_upgrade, c0267d.m1356g());
                    break;
                } else {
                    GetVersionNotice getVersionNotice = (GetVersionNotice) c0267d.m1354e();
                    if (getVersionNotice == null) {
                        this.f8416a.m8443a(EnumC2157bh.version_for_upgrade, c0267d.m1356g());
                        break;
                    } else if (getVersionNotice.uptodate == null || getVersionNotice.uptodate.booleanValue()) {
                        this.f8416a.m8466j();
                        break;
                    } else {
                        this.f8416a.m8464i();
                        if (!this.f8416a.f8161t || getVersionNotice.critical == null || getVersionNotice.critical.booleanValue()) {
                            this.f8416a.f8161t = true;
                            C3171am.m11049a(getVersionNotice, this.f8416a.f8154m, false, "YES");
                            break;
                        } else {
                            this.f8416a.m8466j();
                            break;
                        }
                    }
                }
                break;
            case 1105:
                if (this.f8416a.f8158q != null && this.f8416a.f8158q.isShowing()) {
                    this.f8416a.f8158q.dismiss();
                }
                if ((!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) && c0267d.m1355f() != 42001) {
                    if (this.f8416a.f8154m != null) {
                        this.f8416a.m8443a(EnumC2157bh.accept_disclaimer, c0267d.m1356g());
                        break;
                    }
                } else {
                    C3159aa.m10966a("first_disclaimer_status", "DONE");
                    try {
                        if (this.f8416a.f8145d.getStatus() != AsyncTask.Status.RUNNING) {
                            this.f8416a.f8145d.execute(new Void[0]);
                        }
                    } catch (IllegalStateException e) {
                        C3250y.m11450b("the task is already running or finished", this.f8416a.f8138A);
                    }
                    C3159aa.m10962a().m10986b("provisioning_disclaimer_status", "DONE");
                    if (C3171am.m11060d() != null) {
                        C3159aa.m10962a().m10986b("accept_disclaimer_iso", C3171am.m11060d().toUpperCase());
                    }
                    Intent intent = new Intent(this.f8416a, (Class<?>) MainActivity.class);
                    intent.putExtra("is_before_regi", true);
                    this.f8416a.startActivityForResult(intent, 12);
                    break;
                }
                break;
        }
    }
}
