package com.sec.chaton.control;

import android.os.Handler;
import com.sec.chaton.control.task.BlockTask;
import com.sec.chaton.control.task.GetBlockListTask;
import com.sec.chaton.control.task.UnBlockTask;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpNetworkQueue;
import com.sec.chaton.network.TcpNetworkQueue;
import com.sec.chaton.p000io.entry.GetBlockBuddyList;
import com.sec.chaton.p000io.entry.UnBlock;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.DeviceInfoUtil;
import com.sec.chaton.util.ServerAddressMgr;

/* loaded from: classes.dex */
public class BlockControl {

    /* renamed from: a */
    private Handler f1357a;

    public BlockControl(Handler handler) {
        this.f1357a = handler;
    }

    /* renamed from: a */
    public void m1989a() {
        HttpNetworkQueue.m2745a().offer(new GetBlockListTask(this.f1357a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/blockbuddy").m2738a(HttpEnvelope.RequestMethod.GET).m2739a(GetBlockBuddyList.class).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2737a(601).m2742a()));
    }

    /* renamed from: a */
    public void m1990a(String str) {
        TcpNetworkQueue.m2817a().offer(new UnBlockTask(this.f1357a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/unblock/" + str).m2739a(UnBlock.class).m2738a(HttpEnvelope.RequestMethod.GET).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2737a(603).m2742a(), str));
    }

    /* renamed from: a */
    public void m1991a(String str, int i) {
        HttpNetworkQueue.m2745a().offer(new BlockTask(this.f1357a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/block/" + str).m2738a(HttpEnvelope.RequestMethod.POST).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2737a(602).m2742a(), str, i));
    }
}
