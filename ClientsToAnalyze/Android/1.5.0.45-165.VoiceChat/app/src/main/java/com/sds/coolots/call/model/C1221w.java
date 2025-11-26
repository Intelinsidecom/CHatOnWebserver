package com.sds.coolots.call.model;

import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.calllog.model.CallLogUser;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.contact.ContactManagerInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.sds.coolots.call.model.w */
/* loaded from: classes.dex */
public class C1221w {

    /* renamed from: b */
    private static final String f2782b = "[ConferenceCallDuration]";

    /* renamed from: c */
    private final ArrayList f2784c = new ArrayList();

    /* renamed from: d */
    private final ArrayList f2785d = new ArrayList();

    /* renamed from: a */
    final ContactManagerInterface f2783a = MainApplication.mPhoneManager.getContactManager();

    /* renamed from: a */
    private int m2726a(int i, String str, Destination destination, String str2) {
        String profileUserID = MainApplication.mConfig.getProfileUserID();
        SimpleUserInfo simpleUserInfoM2727a = m2727a(str, destination);
        if (!str.equals(str2)) {
            return (simpleUserInfoM2727a.getInviteUserID() == null || !simpleUserInfoM2727a.getInviteUserID().equals(profileUserID)) ? 5 : 1;
        }
        if (i == 2 || i == 3) {
            return i;
        }
        return 0;
    }

    /* renamed from: a */
    private SimpleUserInfo m2727a(String str, Destination destination) {
        if (str == null || str.isEmpty()) {
            SimpleUserInfo simpleUserInfo = new SimpleUserInfo();
            simpleUserInfo.setUserID(str);
            simpleUserInfo.setUserName("");
            simpleUserInfo.setUserType("P");
            simpleUserInfo.setRejectedMessage("");
            return simpleUserInfo;
        }
        Iterator it = destination.getConferenceMember().iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo2 = (SimpleUserInfo) it.next();
            if (str.equals(simpleUserInfo2.getUserID())) {
                return simpleUserInfo2;
            }
        }
        SimpleUserInfo simpleUserInfo3 = new SimpleUserInfo();
        simpleUserInfo3.setUserID(str);
        simpleUserInfo3.setUserName("");
        simpleUserInfo3.setUserType("P");
        simpleUserInfo3.setRejectedMessage("");
        return simpleUserInfo3;
    }

    /* renamed from: a */
    private String m2728a(String str, String str2) {
        String userNameByUserID;
        return (!this.f2783a.isFriend(str) || (userNameByUserID = this.f2783a.getUserNameByUserID(str)) == null || userNameByUserID.isEmpty()) ? str2 : userNameByUserID;
    }

    /* renamed from: a */
    public static ArrayList m2729a(Destination destination, int i) {
        ArrayList arrayList = new ArrayList();
        Date date = new Date();
        Iterator it = destination.getConferenceMember().iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            CallLogUser callLogUser = new CallLogUser();
            callLogUser.userid = simpleUserInfo.getUserID();
            callLogUser.username = simpleUserInfo.getUserName();
            callLogUser.phoneno = destination.getPhoneNo();
            callLogUser.countrycode = Integer.toString(destination.getCountryCode());
            callLogUser.calllogtype = i;
            callLogUser.userType = simpleUserInfo.getUserType();
            callLogUser.state = simpleUserInfo.getStatus();
            callLogUser.rejectMsg = simpleUserInfo.getRejectedMessage();
            callLogUser.callStartTime = date.getTime();
            callLogUser.callDuration = 0;
            arrayList.add(callLogUser);
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m2730a(C1204f c1204f, SimpleUserInfo simpleUserInfo, Date date) {
        if ("0".equals(simpleUserInfo.getStatus())) {
            return;
        }
        c1204f.m2451a(date);
    }

    /* renamed from: b */
    private void m2731b(C1204f c1204f, SimpleUserInfo simpleUserInfo, Date date) {
        if ("0".equals(simpleUserInfo.getStatus()) || "1".equals(simpleUserInfo.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo.getStatus())) {
            return;
        }
        c1204f.m2453b(date);
    }

    /* renamed from: c */
    private void m2732c(String str) {
        Log.m2958e(f2782b + str);
    }

    /* renamed from: d */
    private void m2733d(String str) {
        Log.m2963i(f2782b + str);
    }

    /* renamed from: e */
    private C1204f m2734e(String str) {
        Iterator it = this.f2784c.iterator();
        while (it.hasNext()) {
            C1204f c1204f = (C1204f) it.next();
            if (c1204f.m2450a().equals(str)) {
                return c1204f;
            }
        }
        return null;
    }

    /* renamed from: a */
    public ArrayList m2735a(Destination destination, int i, String str) {
        ArrayList arrayList = new ArrayList();
        if (i == 3 || i == 2) {
            m2733d("getCallDurations(): reject call or missed call");
            Iterator it = destination.getConferenceMember().iterator();
            while (it.hasNext()) {
                SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
                CallLogUser callLogUser = new CallLogUser();
                callLogUser.userid = simpleUserInfo.getUserID();
                callLogUser.username = m2728a(callLogUser.userid, simpleUserInfo.getUserName());
                callLogUser.phoneno = null;
                callLogUser.countrycode = Integer.toString(destination.getCountryCode());
                callLogUser.calllogtype = m2726a(i, simpleUserInfo.getUserID(), destination, str);
                callLogUser.userType = simpleUserInfo.getUserType();
                callLogUser.state = simpleUserInfo.getStatus();
                callLogUser.rejectMsg = simpleUserInfo.getRejectedMessage();
                callLogUser.callStartTime = 0L;
                callLogUser.callDuration = 0;
                Iterator it2 = this.f2785d.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (simpleUserInfo.getUserID().equals((String) it2.next())) {
                        callLogUser.isNewInvitedUser = true;
                        break;
                    }
                }
                arrayList.add(callLogUser);
            }
        } else {
            m2733d("getCallDurations()");
            Iterator it3 = this.f2784c.iterator();
            while (it3.hasNext()) {
                C1204f c1204f = (C1204f) it3.next();
                SimpleUserInfo simpleUserInfoM2727a = m2727a(c1204f.m2450a(), destination);
                CallLogUser callLogUser2 = new CallLogUser();
                callLogUser2.userid = c1204f.m2450a();
                callLogUser2.username = m2728a(callLogUser2.userid, simpleUserInfoM2727a.getUserName());
                callLogUser2.phoneno = destination.getPhoneNo();
                callLogUser2.countrycode = Integer.toString(destination.getCountryCode());
                callLogUser2.calllogtype = m2726a(i, c1204f.m2450a(), destination, str);
                callLogUser2.userType = simpleUserInfoM2727a.getUserType();
                callLogUser2.state = simpleUserInfoM2727a.getStatus();
                callLogUser2.rejectMsg = simpleUserInfoM2727a.getRejectedMessage();
                callLogUser2.callStartTime = c1204f.m2452b().getTime();
                callLogUser2.callDuration = c1204f.m2456e();
                Iterator it4 = this.f2785d.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    if (c1204f.m2450a().equals((String) it4.next())) {
                        callLogUser2.isNewInvitedUser = true;
                        break;
                    }
                }
                arrayList.add(callLogUser2);
            }
        }
        if (arrayList.size() > 0) {
            m2733d("add my log");
            CallLogUser callLogUser3 = new CallLogUser();
            callLogUser3.userid = MainApplication.mConfig.getProfileUserID();
            callLogUser3.username = MainApplication.mConfig.getProfileUserName();
            callLogUser3.calllogtype = i;
            if (MainApplication.mPhoneManager.getPhoneStateMachine().getCallConnectedTime() != null) {
                callLogUser3.callStartTime = MainApplication.mPhoneManager.getPhoneStateMachine().getCallConnectedTime().getTime();
            } else {
                callLogUser3.callStartTime = new Date().getTime();
            }
            callLogUser3.callDuration = 0;
            arrayList.add(callLogUser3);
        }
        return arrayList;
    }

    /* renamed from: a */
    public void m2736a() {
        Date date = new Date();
        Iterator it = this.f2784c.iterator();
        while (it.hasNext()) {
            C1204f c1204f = (C1204f) it.next();
            if (c1204f.m2454c() == null) {
                c1204f.m2451a(date);
            }
            if (c1204f.m2455d() == null) {
                c1204f.m2453b(date);
            }
        }
    }

    /* renamed from: a */
    public void m2737a(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f2785d.add(str);
    }

    /* renamed from: a */
    public void m2738a(List list) {
        Date date = new Date();
        String profileUserID = MainApplication.mConfig.getProfileUserID();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if (profileUserID == null || !profileUserID.equals(simpleUserInfo.getUserID())) {
                C1204f c1204fM2734e = m2734e(simpleUserInfo.getUserID());
                if (c1204fM2734e != null) {
                    if (c1204fM2734e.m2454c() == null) {
                        m2730a(c1204fM2734e, simpleUserInfo, date);
                    }
                    if (c1204fM2734e.m2455d() == null) {
                        m2731b(c1204fM2734e, simpleUserInfo, date);
                    }
                } else if ("1".equals(simpleUserInfo.getStatus()) || "0".equals(simpleUserInfo.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo.getStatus())) {
                    this.f2784c.add(new C1204f(simpleUserInfo, date));
                }
            }
        }
    }

    /* renamed from: a */
    public void m2739a(List list, Date date) {
        String profileUserID = MainApplication.mConfig.getProfileUserID();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if (profileUserID == null || !profileUserID.equals(simpleUserInfo.getUserID())) {
                C1204f c1204fM2734e = m2734e(simpleUserInfo.getUserID());
                if (c1204fM2734e != null && (c1204fM2734e.m2454c() == null || (MainApplication.mPhoneManager.getPhoneStateMachine().getCallConnectedTime() != null && c1204fM2734e.m2454c().before(MainApplication.mPhoneManager.getPhoneStateMachine().getCallConnectedTime())))) {
                    m2730a(c1204fM2734e, simpleUserInfo, date);
                }
            }
        }
    }

    /* renamed from: b */
    public void m2740b(String str) {
        Date date = new Date();
        C1204f c1204fM2734e = m2734e(str);
        if (c1204fM2734e != null) {
            if (c1204fM2734e.m2454c() == null) {
                c1204fM2734e.m2451a(date);
            }
            c1204fM2734e.m2453b(date);
        }
    }
}
