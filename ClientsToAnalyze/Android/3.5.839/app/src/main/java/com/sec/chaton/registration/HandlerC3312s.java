package com.sec.chaton.registration;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.GetVersionNotice;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.samsungaccount.MainActivity;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.s */
/* loaded from: classes.dex */
class HandlerC3312s extends Handler {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f12089a;

    HandlerC3312s(AuthenticatorActivity authenticatorActivity) {
        this.f12089a = authenticatorActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 104:
                if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                    this.f12089a.m12795a(EnumC3316w.get_server_address, c0778b.m3112g());
                    break;
                } else {
                    this.f12089a.f11579k.m9471b();
                    break;
                }
                break;
            case 1104:
                if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                    this.f12089a.m12795a(EnumC3316w.version_for_upgrade, c0778b.m3112g());
                    break;
                } else {
                    GetVersionNotice getVersionNotice = (GetVersionNotice) c0778b.m3110e();
                    if (getVersionNotice == null) {
                        this.f12089a.m12795a(EnumC3316w.version_for_upgrade, c0778b.m3112g());
                        break;
                    } else if (getVersionNotice.uptodate == null || getVersionNotice.uptodate.booleanValue()) {
                        this.f12089a.m12807f();
                        break;
                    } else {
                        this.f12089a.m12805e();
                        if (!this.f12089a.f11585q || getVersionNotice.critical == null || getVersionNotice.critical.booleanValue()) {
                            this.f12089a.f11585q = true;
                            C4822an.m18213a(getVersionNotice, this.f12089a.f11580l, false, "YES");
                            break;
                        } else {
                            this.f12089a.m12807f();
                            break;
                        }
                    }
                }
                break;
            case 1105:
                if (this.f12089a.f11582n != null && this.f12089a.f11582n.isShowing()) {
                    this.f12089a.f11582n.dismiss();
                }
                if ((!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) && c0778b.m3111f() != 42001) {
                    if (this.f12089a.f11580l != null) {
                        this.f12089a.m12795a(EnumC3316w.accept_disclaimer, c0778b.m3112g());
                        break;
                    }
                } else {
                    try {
                        if (this.f12089a.f11571c.getStatus() != AsyncTask.Status.RUNNING) {
                            this.f12089a.f11571c.execute(new Void[0]);
                        }
                    } catch (IllegalStateException e) {
                        C4904y.m18639b("the task is already running or finished", this.f12089a.f11593y);
                    }
                    if (C4822an.m18236g() != null) {
                        C4809aa.m18104a().m18128b("accept_disclaimer_iso", C4822an.m18236g().toUpperCase());
                    }
                    this.f12089a.startActivityForResult(new Intent(this.f12089a, (Class<?>) MainActivity.class), 9);
                    break;
                }
                break;
        }
    }
}
