package com.sds.coolots.login;

import com.sds.coolots.MainApplication;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* renamed from: com.sds.coolots.login.b */
/* loaded from: classes.dex */
class RunnableC1276b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ LoginManager f3207a;

    RunnableC1276b(LoginManager loginManager) {
        this.f3207a = loginManager;
    }

    @Override // java.lang.Runnable
    public void run() throws UnknownHostException {
        try {
            this.f3207a.m3011b("<<YHT10>> CENTER DOMAIN:" + MainApplication.mConfig.getCenterDomain());
            InetAddress[] allByName = InetAddress.getAllByName(MainApplication.mConfig.getCenterDomain());
            this.f3207a.m3011b("address cnt : " + allByName.length);
            for (InetAddress inetAddress : allByName) {
                this.f3207a.m3011b("ip : " + inetAddress.getHostName() + "=" + inetAddress.getHostAddress());
                if (inetAddress instanceof Inet4Address) {
                    this.f3207a.m3011b("IPv4 address");
                    MainApplication.mConfig.setCenterDomainIP(inetAddress.getHostAddress());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            MainApplication.mConfig.setCenterDomainIP("0.0.0.0");
        }
    }
}
