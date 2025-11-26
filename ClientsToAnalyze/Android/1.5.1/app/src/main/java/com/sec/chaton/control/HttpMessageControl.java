package com.sec.chaton.control;

import android.os.Handler;
import com.sec.chaton.control.task.GetAllUnReadMessageTask;
import com.sec.chaton.control.task.SetAnsNotiReadMessage;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpNetworkQueue;
import com.sec.chaton.p000io.entry.GetUnReadMessageList;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.DeviceInfoUtil;
import com.sec.chaton.util.ServerAddressMgr;
import java.util.List;

/* loaded from: classes.dex */
public class HttpMessageControl {

    /* renamed from: a */
    private Handler f1360a;

    public HttpMessageControl(Handler handler) {
        this.f1360a = handler;
    }

    /* renamed from: a */
    public void m2002a() {
        HttpNetworkQueue.m2745a().offer(new GetAllUnReadMessageTask(this.f1360a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/inboxes").m2738a(HttpEnvelope.RequestMethod.GET).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2737a(801).m2739a(GetUnReadMessageList.class).m2742a()));
    }

    /* renamed from: a */
    public void m2003a(List list) {
        HttpNetworkQueue.m2745a().offer(new SetAnsNotiReadMessage(this.f1360a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/inbox").m2738a(HttpEnvelope.RequestMethod.POST).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2737a(802).m2742a(), list));
    }
}
