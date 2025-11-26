package com.sec.chaton.control;

import android.os.Handler;
import com.sec.chaton.control.task.AddBuddyTask;
import com.sec.chaton.control.task.GetAllBuddiesTask;
import com.sec.chaton.control.task.SetPrivacyTask;
import com.sec.chaton.control.task.UploadAddressTask;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpNetworkQueue;
import com.sec.chaton.p000io.entry.GetBuddyList;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.DeviceInfoUtil;
import com.sec.chaton.util.ServerAddressMgr;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes.dex */
public class ContactControl {

    /* renamed from: a */
    private Handler f1358a;

    public ContactControl(Handler handler) {
        this.f1358a = handler;
    }

    /* renamed from: a */
    public void m1992a() {
        m1995a(false);
    }

    /* renamed from: a */
    public void m1993a(String str) {
        m1994a(str, false);
    }

    /* renamed from: a */
    public void m1994a(String str, boolean z) {
        HttpEnvelope.Builder builderM2738a = new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/address").m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a(RtspHeaders.Values.MODE, str).m2737a(302).m2738a(HttpEnvelope.RequestMethod.POST);
        if (z) {
            new UploadAddressTask(this.f1358a, builderM2738a.m2742a()).run();
        } else {
            HttpNetworkQueue.m2745a().offer(new UploadAddressTask(this.f1358a, builderM2738a.m2742a()));
        }
    }

    /* renamed from: a */
    public void m1995a(boolean z) {
        HttpEnvelope.Builder builderM2739a = new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/v2/buddies").m2738a(HttpEnvelope.RequestMethod.GET).m2737a(301).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a("timestamp", String.valueOf(Long.valueOf(ChatONPref.m3519a().getLong("get_all_buddies_timestamp", 0L)))).m2739a(GetBuddyList.class);
        if (z) {
            new GetAllBuddiesTask(this.f1358a, builderM2739a.m2742a()).run();
        } else {
            HttpNetworkQueue.m2745a().offer(new GetAllBuddiesTask(this.f1358a, builderM2739a.m2742a()));
        }
    }

    /* renamed from: b */
    public void m1996b(String str) {
        m1997b(str, true);
    }

    /* renamed from: b */
    public void m1997b(String str, boolean z) {
        HttpNetworkQueue.m2745a().offer(new AddBuddyTask(this.f1358a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/v2/buddy").m2738a(HttpEnvelope.RequestMethod.POST).m2737a(303).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a(RtspHeaders.Values.MODE, "call").m2739a(GetBuddyList.class).m2742a(), z ? "+" + str : str));
    }

    /* renamed from: b */
    public void m1998b(boolean z) {
        m1999c("phonenumber", z);
    }

    /* renamed from: c */
    public void m1999c(String str, boolean z) {
        HttpNetworkQueue.m2745a().offer(new SetPrivacyTask(this.f1358a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/privacy").m2738a(HttpEnvelope.RequestMethod.POST).m2737a(304).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2742a(), str, z));
    }
}
