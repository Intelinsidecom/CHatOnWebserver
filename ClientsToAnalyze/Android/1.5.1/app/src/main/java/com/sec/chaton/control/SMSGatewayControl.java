package com.sec.chaton.control;

import android.os.Handler;
import com.sec.chaton.constant.ChatONConst;
import com.sec.chaton.control.task.GetSMSAuthTokenTask;
import com.sec.chaton.control.task.SendSMSTask;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpNetworkQueue;
import com.sec.chaton.p000io.entry.GetSMSAuthToken;
import com.sec.chaton.util.DeviceInfoUtil;
import com.sec.chaton.util.ServerAddressMgr;

/* loaded from: classes.dex */
public class SMSGatewayControl {

    /* renamed from: a */
    private Handler f1388a;

    public SMSGatewayControl(Handler handler) {
        this.f1388a = handler;
    }

    /* renamed from: a */
    public void m2077a(String str, String str2) {
        HttpNetworkQueue.m2745a().offer(new GetSMSAuthTokenTask(this.f1388a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.SMS_GATEWAY, "/sms/v2/authtoken").m2738a(HttpEnvelope.RequestMethod.GET).m2737a(1301).m2744b("sms-encryptedkey", "1b7ef4fe31b24450b47c7f0082f956f5").m2744b("sms-platform", "android").m2744b("sms-version", ChatONConst.f1338b).m2741a("countrycallingcode", str).m2741a("phonenumber", str2).m2741a("did", DeviceInfoUtil.m3564a()).m2739a(GetSMSAuthToken.class).m2742a()));
    }

    /* renamed from: a */
    public void m2078a(String str, String str2, String str3, String str4) {
        HttpNetworkQueue.m2745a().offer(new SendSMSTask(this.f1388a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.SMS_GATEWAY, "/sms/v2/send").m2738a(HttpEnvelope.RequestMethod.GET).m2737a(1302).m2744b("sms-token", str).m2744b("sms-platform", "android").m2744b("sms-version", ChatONConst.f1338b).m2741a("countrycallingcode", str2).m2741a("phonenumber", str3).m2741a("did", DeviceInfoUtil.m3564a()).m2741a("msisdn", str4).m2742a()));
    }
}
