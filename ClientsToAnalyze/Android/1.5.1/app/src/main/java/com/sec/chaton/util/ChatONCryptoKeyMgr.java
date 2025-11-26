package com.sec.chaton.util;

import android.text.TextUtils;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.constant.ChatONConst;
import com.sec.chaton.control.task.GetVersionTask;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.p000io.entry.GetVersion;
import com.sec.chaton.util.ServerAddressMgr;

/* loaded from: classes.dex */
public class ChatONCryptoKeyMgr {

    /* renamed from: a */
    private String f3617a = "";

    /* renamed from: c */
    private boolean m3476c() {
        ChatONLogWriter.m3506b("retrieveCryptoKey", getClass().getSimpleName());
        HttpEnvelope.Builder builderM2739a = new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/version").m2738a(HttpEnvelope.RequestMethod.GET).m2737a(1101).m2739a(GetVersion.class);
        builderM2739a.m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a("version", ChatONConst.f1338b);
        if (GlobalApplication.f1895b != null) {
            builderM2739a.m2741a("regid", GlobalApplication.f1895b).m2741a("pushtype", "SPP");
        }
        builderM2739a.m2741a("region", ChatONPref.m3519a().getString("primary_region", ""));
        HttpEntry httpEntryRunForNonThread = new GetVersionTask(null, builderM2739a.m2742a()).runForNonThread();
        if (httpEntryRunForNonThread.m1950a() && httpEntryRunForNonThread.m1951b() != HttpResultCode.ERROR) {
            GetVersion getVersion = (GetVersion) httpEntryRunForNonThread.m1955d();
            ChatONLogWriter.m3511e(getVersion.toString(), getClass().getSimpleName());
            if (getVersion.key != null) {
                this.f3617a = getVersion.key;
                ChatONLogWriter.m3506b("retrieveCryptoKey - Success", getClass().getSimpleName());
                return true;
            }
        }
        ChatONLogWriter.m3506b("retrieveCryptoKey - Fail", getClass().getSimpleName());
        return false;
    }

    /* renamed from: a */
    public synchronized String m3477a() {
        if (TextUtils.isEmpty(this.f3617a)) {
            m3476c();
        }
        return this.f3617a;
    }

    /* renamed from: b */
    public synchronized void m3478b() {
        this.f3617a = "";
    }
}
