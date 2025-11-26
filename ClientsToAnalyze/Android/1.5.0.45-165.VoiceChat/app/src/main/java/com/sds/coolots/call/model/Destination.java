package com.sds.coolots.call.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.calllog.model.CallLogUser;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Destination implements Parcelable {
    public static final int CHARGE_TYPE_16_PEOPLE = 2;
    public static final int CHARGE_TYPE_4_PEOPLE = 1;
    public static final int CHARGE_TYPE_DEFAULT = 0;
    public static final int CHARGE_TYPE_PARTICIPANT = -1;
    public static final int DEST_TYPE_CNTALK = 1;
    public static final int DEST_TYPE_CONFERENCE = 4;
    public static final int DEST_TYPE_COOLOTS = 2;
    public static final int DEST_TYPE_ERROR = 0;
    public static final int DEST_TYPE_P2P_CONFERENCE = 5;
    public static final int DEST_TYPE_SIP = 3;
    protected static final String MOBILE_ID_DOMAIN = "@phone";

    /* renamed from: a */
    private static final String f2602a = "00755";

    /* renamed from: b */
    private int f2604b;

    /* renamed from: c */
    private String f2605c;

    /* renamed from: d */
    private String f2606d;

    /* renamed from: e */
    private String f2607e;

    /* renamed from: f */
    private String f2608f;

    /* renamed from: g */
    private long f2609g;

    /* renamed from: h */
    private int f2610h;

    /* renamed from: i */
    private ArrayList f2611i;

    /* renamed from: k */
    private int f2612k;

    /* renamed from: l */
    private ArrayList f2613l;

    /* renamed from: m */
    private String f2614m;

    /* renamed from: n */
    private int f2615n;

    /* renamed from: j */
    private static ArrayList f2603j = new ArrayList();
    public static final Parcelable.Creator CREATOR = new C1190E();

    public Destination(int i, int i2, String str) {
        this.f2604b = -1;
        this.f2605c = "";
        this.f2606d = "";
        this.f2607e = "";
        this.f2608f = "";
        this.f2609g = 0L;
        this.f2610h = 0;
        this.f2611i = new ArrayList();
        this.f2612k = -1;
        this.f2613l = new ArrayList();
        this.f2615n = -1;
        this.f2604b = i2;
        if (i == 3) {
            this.f2607e = str;
        } else if (i == 2) {
            this.f2605c = str;
        }
    }

    public Destination(int i, String str) {
        this.f2604b = -1;
        this.f2605c = "";
        this.f2606d = "";
        this.f2607e = "";
        this.f2608f = "";
        this.f2609g = 0L;
        this.f2610h = 0;
        this.f2611i = new ArrayList();
        this.f2612k = -1;
        this.f2613l = new ArrayList();
        this.f2615n = -1;
        switch (i) {
            case 1:
                this.f2604b = 82;
                this.f2605c = str;
                break;
            case 2:
                this.f2606d = str;
                break;
            default:
                this.f2607e = str;
                break;
        }
    }

    public Destination(int i, List list, long j) {
        this.f2604b = -1;
        this.f2605c = "";
        this.f2606d = "";
        this.f2607e = "";
        this.f2608f = "";
        this.f2609g = 0L;
        this.f2610h = 0;
        this.f2611i = new ArrayList();
        this.f2612k = -1;
        this.f2613l = new ArrayList();
        this.f2615n = -1;
        this.f2612k = i;
        this.f2609g = j;
        if (this.f2613l != null) {
            this.f2613l.clear();
            this.f2613l = (ArrayList) ((ArrayList) list).clone();
        }
    }

    public Destination(Parcel parcel) {
        this.f2604b = -1;
        this.f2605c = "";
        this.f2606d = "";
        this.f2607e = "";
        this.f2608f = "";
        this.f2609g = 0L;
        this.f2610h = 0;
        this.f2611i = new ArrayList();
        this.f2612k = -1;
        this.f2613l = new ArrayList();
        this.f2615n = -1;
        m2398a(parcel);
    }

    public Destination(String str, List list, long j) {
        this.f2604b = -1;
        this.f2605c = "";
        this.f2606d = "";
        this.f2607e = "";
        this.f2608f = "";
        this.f2609g = 0L;
        this.f2610h = 0;
        this.f2611i = new ArrayList();
        this.f2612k = -1;
        this.f2613l = new ArrayList();
        this.f2615n = -1;
        Log.m2958e("<<YHT47>> init group id:" + j);
        this.f2608f = str;
        this.f2609g = j;
        if (list != null) {
            this.f2611i.clear();
            this.f2611i = (ArrayList) ((ArrayList) list).clone();
        }
    }

    public Destination(String str, List list, String str2) {
        this.f2604b = -1;
        this.f2605c = "";
        this.f2606d = "";
        this.f2607e = "";
        this.f2608f = "";
        this.f2609g = 0L;
        this.f2610h = 0;
        this.f2611i = new ArrayList();
        this.f2612k = -1;
        this.f2613l = new ArrayList();
        this.f2615n = -1;
        Log.m2958e("<<YHT47>> init group name:" + str2);
        this.f2608f = str;
        this.f2614m = str2;
        if (list != null) {
            this.f2611i.clear();
            this.f2611i = (ArrayList) ((ArrayList) list).clone();
        }
    }

    /* renamed from: a */
    private void m2398a(Parcel parcel) {
        this.f2604b = parcel.readInt();
        this.f2605c = parcel.readString();
        this.f2606d = parcel.readString();
        this.f2607e = parcel.readString();
        this.f2608f = parcel.readString();
        this.f2609g = parcel.readLong();
        this.f2614m = parcel.readString();
        int i = parcel.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.f2611i.add(new SimpleUserInfo(parcel.readString(), parcel.readString()));
        }
        this.f2612k = parcel.readInt();
        this.f2615n = parcel.readInt();
        int i3 = parcel.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            this.f2613l.add(new P2PUserInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt()));
        }
    }

    /* renamed from: a */
    private boolean m2399a(List list, List list2) {
        boolean z;
        if (list == null || list2 == null) {
            return false;
        }
        if (list.size() != list2.size()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            Iterator it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                SimpleUserInfo simpleUserInfo2 = (SimpleUserInfo) it2.next();
                if (!simpleUserInfo2.getStatus().equals("1") && !simpleUserInfo2.getStatus().equals("0") && !simpleUserInfo2.getStatus().equals(SimpleUserInfo.STATE_MOVETO_CONFERENCE)) {
                    Log.m2958e("<<YHT47>> size is different!! find disconnected person");
                    return false;
                }
                if (simpleUserInfo.getUserID().equals(simpleUserInfo2.getUserID())) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public void copyDestination(Destination destination) {
        this.f2604b = destination.f2604b;
        this.f2605c = destination.f2605c;
        this.f2606d = destination.f2606d;
        this.f2607e = destination.f2607e;
        this.f2608f = destination.f2608f;
        this.f2610h = destination.f2610h;
        this.f2612k = destination.f2612k;
        this.f2609g = destination.f2609g;
        this.f2614m = destination.f2614m;
        this.f2615n = destination.f2615n;
        this.f2611i.clear();
        this.f2611i = (ArrayList) destination.getConferenceMember().clone();
        this.f2613l.clear();
        Iterator it = destination.f2613l.iterator();
        while (it.hasNext()) {
            P2PUserInfo p2PUserInfo = (P2PUserInfo) it.next();
            this.f2613l.add(new P2PUserInfo(p2PUserInfo.userID, p2PUserInfo.userName, p2PUserInfo.userType, p2PUserInfo.userState, p2PUserInfo.callID));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Destination destination) {
        if (this == destination) {
            return true;
        }
        if (destination instanceof Destination) {
            return getDestinationType() == destination.getDestinationType() && this.f2604b == destination.f2604b && this.f2605c.equals(destination.f2605c) && this.f2606d.equals(destination.f2606d) && this.f2607e.equals(destination.f2607e) && this.f2608f.equals(destination.f2608f) && this.f2612k == destination.f2612k && this.f2615n == destination.f2615n;
        }
        return false;
    }

    public int getCallInstanceID() {
        return this.f2615n;
    }

    public int getChargeType() {
        return this.f2610h;
    }

    public ArrayList getConferenceMember() {
        return (ArrayList) this.f2611i.clone();
    }

    public ArrayList getConferenceMemberAsCallLogUser(int i) {
        ArrayList arrayList = new ArrayList();
        if (i == 1) {
            Iterator it = f2603j.iterator();
            while (it.hasNext()) {
                SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
                CallLogUser callLogUser = new CallLogUser();
                callLogUser.userid = simpleUserInfo.getUserID();
                callLogUser.username = simpleUserInfo.getUserName();
                callLogUser.userType = simpleUserInfo.getUserType();
                callLogUser.phoneno = this.f2608f;
                callLogUser.countrycode = Integer.toString(getCountryCode());
                callLogUser.state = simpleUserInfo.getStatus();
                arrayList.add(callLogUser);
            }
        } else {
            Iterator it2 = this.f2611i.iterator();
            while (it2.hasNext()) {
                SimpleUserInfo simpleUserInfo2 = (SimpleUserInfo) it2.next();
                CallLogUser callLogUser2 = new CallLogUser();
                callLogUser2.userid = simpleUserInfo2.getUserID();
                callLogUser2.username = simpleUserInfo2.getUserName();
                callLogUser2.userType = simpleUserInfo2.getUserType();
                callLogUser2.phoneno = this.f2608f;
                callLogUser2.countrycode = Integer.toString(getCountryCode());
                callLogUser2.state = simpleUserInfo2.getStatus();
                arrayList.add(callLogUser2);
            }
        }
        return arrayList;
    }

    public int getConferenceMemberCountWithMe() {
        int i = 1;
        if (getDestinationType() == 4) {
            Iterator it = this.f2611i.iterator();
            while (it.hasNext()) {
                SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
                if ("1".equals(simpleUserInfo.getStatus()) || "0".equals(simpleUserInfo.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo.getStatus())) {
                    i++;
                }
            }
            return i;
        }
        if (getDestinationType() != 5) {
            return 0;
        }
        Iterator it2 = this.f2613l.iterator();
        int i2 = 1;
        while (it2.hasNext()) {
            P2PUserInfo p2PUserInfo = (P2PUserInfo) it2.next();
            if (p2PUserInfo.userState == 0 || p2PUserInfo.userState == 1) {
                i2++;
            }
        }
        return i2;
    }

    public ArrayList getConferenceMemberName() {
        ArrayList arrayList = new ArrayList();
        if (getDestinationType() == 4) {
            Iterator it = this.f2611i.iterator();
            while (it.hasNext()) {
                SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
                if ("1".equals(simpleUserInfo.getStatus()) || "0".equals(simpleUserInfo.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo.getStatus())) {
                    if (!simpleUserInfo.getUserID().equals(MainApplication.mConfig.getProfileUserID())) {
                        String userNameByUserID = MainApplication.mPhoneManager.getContactManager().getUserNameByUserID(simpleUserInfo.getUserID());
                        arrayList.add((userNameByUserID == null || userNameByUserID.length() == 0) ? simpleUserInfo.getUserName() : userNameByUserID);
                    }
                }
            }
        } else if (getDestinationType() == 5) {
            Iterator it2 = this.f2613l.iterator();
            while (it2.hasNext()) {
                P2PUserInfo p2PUserInfo = (P2PUserInfo) it2.next();
                if (1 == p2PUserInfo.userState || p2PUserInfo.userState == 0) {
                    if (!p2PUserInfo.userID.equals(MainApplication.mConfig.getProfileUserID())) {
                        String userNameByUserID2 = MainApplication.mPhoneManager.getContactManager().getUserNameByUserID(p2PUserInfo.userID);
                        arrayList.add((userNameByUserID2 == null || userNameByUserID2.length() == 0) ? p2PUserInfo.userID : userNameByUserID2);
                    }
                }
            }
        }
        return arrayList;
    }

    public int getCountryCode() {
        return this.f2604b;
    }

    public int getDestinationType() {
        if (this.f2607e.length() != 0) {
            return 3;
        }
        if (this.f2604b != -1) {
            return 1;
        }
        if (this.f2606d.length() != 0) {
            return 2;
        }
        if (this.f2608f.length() != 0) {
            return 4;
        }
        if (this.f2611i == null || this.f2611i.size() <= 1) {
            return (this.f2612k == -1 && this.f2613l == null) ? 0 : 5;
        }
        return 4;
    }

    public String getDestinationTypeString() {
        switch (getDestinationType()) {
            case 1:
                return "DEST_TYPE_CNTALK";
            case 2:
                return "DEST_TYPE_COOLOTS";
            case 3:
                return "DEST_TYPE_SIP";
            case 4:
                return "DEST_TYPE_CONFERENCE";
            case 5:
                return "DEST_TYPE_P2P_CONFERENCE";
            default:
                return "DEST_TYPE_ERROR";
        }
    }

    public long getGroupID() {
        return this.f2609g;
    }

    public String getGroupName() {
        return this.f2614m;
    }

    public ArrayList getP2PConferenceMember() {
        return (ArrayList) this.f2613l.clone();
    }

    public int getP2PConferenceNo() {
        return this.f2612k;
    }

    public String getPhoneNo() {
        if (this.f2607e.length() != 0) {
            return this.f2607e;
        }
        if (this.f2604b != -1) {
            return this.f2605c.endsWith(MOBILE_ID_DOMAIN) ? this.f2605c.substring(0, this.f2605c.indexOf(MOBILE_ID_DOMAIN)) : this.f2605c;
        }
        if (this.f2606d.length() != 0) {
            return this.f2606d;
        }
        if (this.f2608f.length() != 0) {
            return this.f2608f;
        }
        if ((this.f2611i != null && !this.f2611i.isEmpty()) || this.f2613l == null || this.f2613l.isEmpty()) {
            return "";
        }
        String str = ((P2PUserInfo) this.f2613l.get(0)).userID;
        Iterator it = this.f2613l.iterator();
        String str2 = str;
        while (it.hasNext()) {
            P2PUserInfo p2PUserInfo = (P2PUserInfo) it.next();
            if (p2PUserInfo.userType == 0) {
                str2 = p2PUserInfo.userID;
            }
        }
        return str2;
    }

    public String getString() {
        String str = this.f2604b != -1 ? String.valueOf(this.f2604b) + "_" + this.f2605c : "";
        if (this.f2606d.length() != 0) {
            str = this.f2606d;
        }
        if (this.f2607e.length() != 0) {
            if (this.f2604b == -1 || this.f2604b == 82) {
                str = this.f2607e;
            } else {
                str = "00755" + this.f2604b + (this.f2607e.charAt(0) == '0' ? this.f2607e.substring(1) : this.f2607e);
            }
        }
        if (this.f2608f.length() != 0) {
            str = this.f2608f;
        }
        if (this.f2613l == null || this.f2613l.isEmpty()) {
            return str;
        }
        String str2 = ((P2PUserInfo) this.f2613l.get(0)).userName;
        Iterator it = this.f2613l.iterator();
        String str3 = str2;
        while (it.hasNext()) {
            P2PUserInfo p2PUserInfo = (P2PUserInfo) it.next();
            if (p2PUserInfo.userType == 0) {
                str3 = p2PUserInfo.userName;
            }
        }
        return str3;
    }

    public void setCallInstanceID(int i) {
        this.f2615n = i;
    }

    public void setCallLogDestForConfHost(List list) {
        f2603j.clear();
        f2603j = (ArrayList) list;
    }

    public void setChargeType(int i) {
        this.f2610h = i;
    }

    public void setConferenceMember(List list) {
        if (this.f2609g != 0 && !m2399a(this.f2611i, list)) {
            Log.m2958e("<<YHT47>> setConferenceMember!! reset group ID");
            this.f2609g = 0L;
        }
        this.f2611i = (ArrayList) list;
    }

    public void setConferenceNo(String str) {
        this.f2608f = str;
    }

    public void setP2PConferenceMember(List list) {
        this.f2613l = (ArrayList) list;
    }

    public void setP2PConferenceNo(int i) {
        this.f2612k = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2604b);
        parcel.writeString(this.f2605c);
        parcel.writeString(this.f2606d);
        parcel.writeString(this.f2607e);
        parcel.writeString(this.f2608f);
        parcel.writeLong(this.f2609g);
        parcel.writeString(this.f2614m);
        parcel.writeInt(this.f2611i.size());
        Iterator it = this.f2611i.iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            parcel.writeString(simpleUserInfo.getUserID());
            parcel.writeString(simpleUserInfo.getUserName());
        }
        parcel.writeInt(this.f2612k);
        parcel.writeInt(this.f2615n);
        parcel.writeInt(this.f2613l.size());
        Iterator it2 = this.f2613l.iterator();
        while (it2.hasNext()) {
            P2PUserInfo p2PUserInfo = (P2PUserInfo) it2.next();
            parcel.writeString(p2PUserInfo.userID);
            parcel.writeString(p2PUserInfo.userName);
            parcel.writeInt(p2PUserInfo.userType);
            parcel.writeInt(p2PUserInfo.userState);
            parcel.writeInt(p2PUserInfo.callID);
        }
    }
}
