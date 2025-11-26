package com.sec.chaton.control;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.constant.ChatONConst;
import com.sec.chaton.control.task.GetVersionTask;
import com.sec.chaton.control.task.GetVersionTask3;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpNetworkQueue;
import com.sec.chaton.p000io.entry.GetVersion;
import com.sec.chaton.p000io.entry.GetVersion3;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.DeviceInfoUtil;
import com.sec.chaton.util.ServerAddressMgr;
import java.net.URLEncoder;

/* loaded from: classes.dex */
public class VersionControl {

    /* renamed from: a */
    private Handler f1402a;

    public VersionControl(Handler handler) {
        this.f1402a = handler;
    }

    /* renamed from: a */
    public void m2094a() {
        HttpEnvelope.Builder builderM2739a = new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/version").m2738a(HttpEnvelope.RequestMethod.GET).m2737a(1101).m2739a(GetVersion.class);
        builderM2739a.m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a("version", ChatONConst.f1338b);
        if (GlobalApplication.f1895b != null) {
            builderM2739a.m2741a("regid", GlobalApplication.f1895b).m2741a("pushtype", "SPP");
        }
        builderM2739a.m2741a("region", ChatONPref.m3519a().getString("primary_region", ""));
        HttpNetworkQueue.m2745a().offer(new GetVersionTask(this.f1402a, builderM2739a.m2742a()));
    }

    /* renamed from: b */
    public void m2095b() {
        if (GlobalApplication.f1895b == null) {
            PushControlFactory.m2072a().mo1974a(new HandlerC0181j(this, Looper.getMainLooper()));
            return;
        }
        HttpEnvelope.Builder builderM2739a = new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/version").m2738a(HttpEnvelope.RequestMethod.GET).m2737a(1101).m2739a(GetVersion.class);
        builderM2739a.m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a("version", ChatONConst.f1338b);
        if (GlobalApplication.f1895b != null) {
            builderM2739a.m2741a("regid", GlobalApplication.f1895b).m2741a("pushtype", "SPP");
        }
        builderM2739a.m2741a("region", ChatONPref.m3519a().getString("primary_region", ""));
        HttpNetworkQueue.m2745a().offer(new GetVersionTask(this.f1402a, builderM2739a.m2742a()));
    }

    /* renamed from: c */
    public void m2096c() {
        if (ChatONPref.m3519a().getString("primary_contact_addrss", null) == null) {
            return;
        }
        HttpEnvelope.Builder builderM2739a = new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/v3/version").m2738a(HttpEnvelope.RequestMethod.GET).m2737a(1103).m2739a(GetVersion3.class);
        builderM2739a.m2741a("platform", "android").m2741a("osversion", Build.VERSION.SDK).m2741a("model", URLEncoder.encode(DeviceInfoUtil.m3565b())).m2741a("appversion", ChatONConst.f1338b);
        HttpNetworkQueue.m2745a().offer(new GetVersionTask3(this.f1402a, builderM2739a.m2742a()));
    }
}
