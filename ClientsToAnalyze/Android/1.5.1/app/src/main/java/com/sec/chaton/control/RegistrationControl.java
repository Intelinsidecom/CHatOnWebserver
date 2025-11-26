package com.sec.chaton.control;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.control.task.DeRegistrationTask;
import com.sec.chaton.control.task.RegistrationTask;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpNetworkQueue;
import com.sec.chaton.p000io.entry.RegisterSSMServer;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.DeviceInfoUtil;
import com.sec.chaton.util.ServerAddressMgr;

/* loaded from: classes.dex */
public class RegistrationControl {

    /* renamed from: a */
    private Handler f1387a;

    public RegistrationControl(Handler handler) {
        this.f1387a = handler;
    }

    /* renamed from: a */
    public void m2074a() {
        HttpNetworkQueue.m2745a().offer(new DeRegistrationTask(this.f1387a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/dereg").m2738a(HttpEnvelope.RequestMethod.GET).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a("uid", ChatONPref.m3519a().getString("uid", null)).m2737a(202).m2742a()));
    }

    /* renamed from: a */
    public void m2075a(Context context) {
        HttpNetworkQueue.m2745a().offer(new DeRegistrationTask(this.f1387a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/dereg").m2738a(HttpEnvelope.RequestMethod.GET).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a("uid", context.getSharedPreferences("ChatON", 0).getString("uid", null)).m2737a(202).m2742a()));
    }

    /* renamed from: a */
    public void m2076a(String str, String str2, String str3, String str4) {
        HttpNetworkQueue.m2745a().offer(new RegistrationTask(this.f1387a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/v2/reg").m2738a(HttpEnvelope.RequestMethod.POST).m2739a(RegisterSSMServer.class).m2737a(201).m2742a(), str, str2, str3, str4));
    }
}
