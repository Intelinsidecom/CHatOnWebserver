package com.sds.coolots.call.model;

import com.coolots.p2pmsg.model.Server;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.model.EventCode;
import java.util.ArrayList;

/* renamed from: com.sds.coolots.call.model.b */
/* loaded from: classes.dex */
class RunnableC1200b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1199a f2650a;

    RunnableC1200b(C1199a c1199a) {
        this.f2650a = c1199a;
    }

    @Override // java.lang.Runnable
    public void run() {
        int port;
        this.f2650a.m2442f("<YHT98> <handleConferenceMakeSuccess> make conference step 1!!");
        String ip = null;
        ArrayList arrayListServerInfo = MainApplication.mPhoneManager.getLoginManager().serverInfo();
        int i = 0;
        while (true) {
            if (i >= arrayListServerInfo.size()) {
                port = 0;
                break;
            }
            Server server = (Server) arrayListServerInfo.get(i);
            if (server.getServerType().equals("BS")) {
                ip = server.getIP();
                port = server.getPort();
                break;
            }
            i++;
        }
        if (ip == null) {
            ip = "121.253.18.97";
            port = 80;
        }
        this.f2650a.m2442f("<YHT98> <handleConferenceMakeSuccess> make conference step 2!!");
        C1189D c1189dA = this.f2650a.m2717a(this.f2650a.f2763G);
        if (c1189dA != null) {
            this.f2650a.f2541j = EngineInterface.getInstance().startConference(c1189dA, this.f2650a.f2763G.getDomainAddr(), this.f2650a.f2763G.getPhoneNo(), this.f2650a.f2763G.getPassword(), this.f2650a.f2763G.getMCUPhoneNo(), this.f2650a.f2537f.isUseVideo(), ip, port, this.f2650a.f2542k.getChargeType(), this.f2650a.f2762F, false);
        }
        if (this.f2650a.f2541j < 0) {
            this.f2650a.m2441e("startOutGoingCall failure!!! error code: " + this.f2650a.f2541j);
            this.f2650a.mo2290I();
            return;
        }
        this.f2650a.m2442f("<YHT98> <handleConferenceMakeSuccess> make conference step 3!!");
        if (!this.f2650a.f2540i.setCallState(2)) {
            this.f2650a.m2441e("startOutGoingCall State Setting Error!!! current state:" + this.f2650a.f2540i.getStateDescription());
            this.f2650a.mo2290I();
            return;
        }
        this.f2650a.m2442f("<YHT98> <handleConferenceMakeSuccess> make conference step 4!!");
        this.f2650a.f2545n = true;
        if (!this.f2650a.f2537f.registVoipCallState()) {
            this.f2650a.m2441e("startOutGoingCall registVoipCallState error!!!!");
            this.f2650a.mo2290I();
        } else {
            this.f2650a.m2442f("<YHT98> <handleConferenceMakeSuccess> make conference step 5!!");
            this.f2650a.m2444a(EventCode.EVENT_CONF_MAKE_SUCCESS, this.f2650a.f2542k);
            this.f2650a.f2537f.updateVoipCallState();
        }
    }
}
