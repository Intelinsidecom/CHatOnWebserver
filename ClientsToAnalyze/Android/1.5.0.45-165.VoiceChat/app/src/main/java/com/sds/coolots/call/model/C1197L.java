package com.sds.coolots.call.model;

import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;

/* renamed from: com.sds.coolots.call.model.L */
/* loaded from: classes.dex */
public class C1197L implements RemoteManagerInterface {

    /* renamed from: d */
    private static final String f2636d = "[RemoteManager]";

    /* renamed from: a */
    private ArrayList f2637a = null;

    /* renamed from: b */
    private Destination f2638b = null;

    /* renamed from: c */
    private String f2639c = "";

    public C1197L() {
        m2435a(" RemoteManager");
        m2434a();
    }

    /* renamed from: a */
    private void m2434a() {
        this.f2637a = new ArrayList();
        for (int i = 0; i < 3; i++) {
            this.f2637a.add(new RemoteInfo(i, "", "", "", null));
        }
    }

    /* renamed from: a */
    private void m2435a(String str) {
        Log.m2954d(f2636d + str);
    }

    /* renamed from: b */
    private boolean m2436b() {
        if (this.f2637a == null) {
            m2434a();
        }
        if (this.f2638b == null || this.f2638b.getDestinationType() != 4) {
            return false;
        }
        ArrayList conferenceMember = this.f2638b.getConferenceMember();
        int i = 0;
        int i2 = 0;
        while (i < this.f2637a.size()) {
            RemoteInfo remoteInfo = (RemoteInfo) this.f2637a.get(i);
            int i3 = i2;
            for (int i4 = 0; i4 < conferenceMember.size(); i4++) {
                SimpleUserInfo simpleUserInfo = (SimpleUserInfo) conferenceMember.get(i4);
                if (simpleUserInfo != null && simpleUserInfo.getPhoneNo() != null && simpleUserInfo.getPhoneNo().equals(remoteInfo.sipID)) {
                    remoteInfo.setUserID(simpleUserInfo.getUserID());
                    remoteInfo.setUserName(simpleUserInfo.getUserName());
                    i3++;
                }
            }
            i++;
            i2 = i3;
        }
        return i2 >= 1;
    }

    @Override // com.sds.coolots.call.model.RemoteManagerInterface
    public ArrayList getMappingRemoteInfo() {
        if (this.f2637a == null) {
            this.f2637a = new ArrayList();
        }
        return (ArrayList) this.f2637a.clone();
    }

    @Override // com.sds.coolots.call.model.RemoteManagerInterface
    public void resetRemoteInfoData() {
        if (this.f2637a != null) {
            this.f2637a.clear();
            this.f2637a = null;
        }
    }

    @Override // com.sds.coolots.call.model.RemoteManagerInterface
    public boolean setMappingEngineData(String str, String str2, String str3) {
        if (this.f2637a == null) {
            m2434a();
        }
        m2435a("setMappingEngineData sipID1 :" + str + " sipID2: " + str2 + " sipID3: " + str3 + " mMySipID: " + this.f2639c);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2637a.size()) {
                return m2436b();
            }
            RemoteInfo remoteInfo = (RemoteInfo) this.f2637a.get(i2);
            if (i2 == 0 && !str.equals("") && !this.f2639c.equals(str)) {
                remoteInfo.sipID = str;
            }
            if (i2 == 1 && !str2.equals("")) {
                remoteInfo.sipID = str2;
            }
            if (i2 == 2 && !str3.equals("")) {
                remoteInfo.sipID = str3;
            }
            i = i2 + 1;
        }
    }

    @Override // com.sds.coolots.call.model.RemoteManagerInterface
    public boolean setMappingPushData(Destination destination, String str) {
        if (destination == null) {
            return false;
        }
        this.f2638b = destination;
        this.f2639c = str;
        if (this.f2639c == null) {
            this.f2639c = "";
        }
        m2435a("setMappingPushData mMySipID: " + this.f2639c);
        return m2436b();
    }
}
