package com.sec.chaton.control;

import android.os.Handler;
import com.sec.chaton.common.entry.UserProfileEntry;
import com.sec.chaton.control.task.DeleteProfileImageTask2;
import com.sec.chaton.control.task.UploadProfileTask2;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpNetworkQueue;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.DeviceInfoUtil;
import com.sec.chaton.util.ServerAddressMgr;

/* loaded from: classes.dex */
public class ProfileControl {

    /* renamed from: a */
    private Handler f1380a;

    public ProfileControl(Handler handler) {
        this.f1380a = handler;
    }

    /* renamed from: a */
    public void m2064a() {
        HttpNetworkQueue.m2745a().offer(new DeleteProfileImageTask2(this.f1380a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/delprofileimage").m2738a(HttpEnvelope.RequestMethod.GET).m2737a(403).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2742a()));
    }

    /* renamed from: a */
    public void m2065a(UserProfileEntry userProfileEntry, String str) {
        HttpNetworkQueue.m2745a().offer(new UploadProfileTask2(this.f1380a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/profile").m2738a(HttpEnvelope.RequestMethod.POST).m2737a(401).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2742a(), userProfileEntry, str));
    }

    /* renamed from: a */
    public void m2066a(String str) {
        new AsyncTaskC0183l(this, str).execute(new String[0]);
    }
}
