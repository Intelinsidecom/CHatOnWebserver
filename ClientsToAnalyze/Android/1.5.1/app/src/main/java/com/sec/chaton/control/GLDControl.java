package com.sec.chaton.control;

import android.os.Build;
import android.os.Handler;
import com.sec.chaton.constant.ChatONConst;
import com.sec.chaton.control.task.GLDServer3Task;
import com.sec.chaton.control.task.GLDServerTask;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpNetworkQueue;
import com.sec.chaton.p000io.entry.GetSSMServerAddress;
import com.sec.chaton.p000io.entry.GetSSMServerAddress3;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.DeviceInfoUtil;
import com.sec.chaton.util.ServerAddressMgr;
import java.net.URLEncoder;

/* loaded from: classes.dex */
public class GLDControl {

    /* renamed from: a */
    private Handler f1359a;

    public GLDControl(Handler handler) {
        this.f1359a = handler;
    }

    /* renamed from: a */
    public void m2000a() {
        HttpNetworkQueue.m2745a().offer(new GLDServerTask(this.f1359a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.GLD, "/prov").m2737a(101).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a("msisdn", ChatONPref.m3519a().getString("msisdn", DeviceInfoUtil.m3566c())).m2741a("imsi", DeviceInfoUtil.m3568e()).m2741a("model", URLEncoder.encode(DeviceInfoUtil.m3565b())).m2741a("clientversion", ChatONConst.f1338b).m2741a("platform", "android").m2741a("osversion", Build.VERSION.SDK).m2739a(GetSSMServerAddress.class).m2738a(HttpEnvelope.RequestMethod.GET).m2742a()));
    }

    /* renamed from: a */
    public void m2001a(String str, String str2) {
        HttpNetworkQueue.m2745a().offer(new GLDServer3Task(this.f1359a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.GLD, "/prov3").m2737a(103).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a("countrycallingcode", str).m2741a("phonenumber", str2).m2741a("imsi", DeviceInfoUtil.m3568e()).m2741a("model", URLEncoder.encode(DeviceInfoUtil.m3565b())).m2741a("clientversion", ChatONConst.f1338b).m2741a("platform", "android").m2741a("osversion", Build.VERSION.SDK).m2739a(GetSSMServerAddress3.class).m2738a(HttpEnvelope.RequestMethod.GET).m2742a()));
    }
}
