package com.sds.coolots.call.model;

import com.coolots.p2pmsg.model.Server;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.model.EventCode;
import java.util.ArrayList;

/* renamed from: com.sds.coolots.call.model.t */
/* loaded from: classes.dex */
class RunnableC1218t implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1217s f2779a;

    RunnableC1218t(C1217s c1217s) {
        this.f2779a = c1217s;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2779a.m2706f("<YHT98> <handleConferenceMakeSuccess> make conference step 1!!");
        String ip = null;
        int port = 0;
        ArrayList arrayListServerInfo = MainApplication.mPhoneManager.getLoginManager().serverInfo();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayListServerInfo.size()) {
                break;
            }
            Server server = (Server) arrayListServerInfo.get(i2);
            if (server.getServerType().equals("BS")) {
                ip = server.getIP();
                port = server.getPort();
                break;
            }
            i = i2 + 1;
        }
        if (ip == null) {
            ip = "121.253.18.97";
            port = 80;
        }
        this.f2779a.m2706f("<YHT98> <handleConferenceMakeSuccess> make conference step 2!!");
        C1189D c1189dM2717a = this.f2779a.m2717a(this.f2779a.f2763G);
        if (c1189dM2717a != null) {
            this.f2779a.f2541j = EngineInterface.getInstance().startConference(c1189dM2717a, this.f2779a.f2763G.getDomainAddr(), this.f2779a.f2763G.getPhoneNo(), this.f2779a.f2763G.getPassword(), this.f2779a.f2763G.getMCUPhoneNo(), this.f2779a.f2537f.isUseVideo(), ip, port, this.f2779a.f2542k.getChargeType(), this.f2779a.f2762F, this.f2779a.f2774S);
            this.f2779a.m2704e("YHT100!!!! set conference call id:" + this.f2779a.f2541j);
            this.f2779a.f2537f.setConferenceCallID(this.f2779a.f2541j);
        }
        if (this.f2779a.f2541j < 0) {
            this.f2779a.m2704e("startOutGoingCall failure!!! error code: " + this.f2779a.f2541j);
            this.f2779a.mo2290I();
            return;
        }
        this.f2779a.m2706f("<YHT98> <handleConferenceMakeSuccess> make conference step 3!!");
        if (!this.f2779a.f2540i.setCallState(1)) {
            this.f2779a.m2704e("startOutGoingCall State Setting Error!!! current state:" + this.f2779a.f2540i.getStateDescription());
            this.f2779a.mo2290I();
            return;
        }
        this.f2779a.m2706f("<YHT98> <handleConferenceMakeSuccess> make conference step 4!!");
        this.f2779a.f2545n = true;
        if (!this.f2779a.f2537f.registVoipCallState()) {
            this.f2779a.m2704e("startOutGoingCall registVoipCallState error!!!!");
            this.f2779a.mo2290I();
        } else {
            this.f2779a.m2706f("<YHT98> <handleConferenceMakeSuccess> make conference step 5!!");
            this.f2779a.f2537f.setActivityStatus(EventCode.EVENT_CALL_CALLING, 0, 0, null);
            this.f2779a.f2537f.updateVoipCallState();
        }
    }
}
