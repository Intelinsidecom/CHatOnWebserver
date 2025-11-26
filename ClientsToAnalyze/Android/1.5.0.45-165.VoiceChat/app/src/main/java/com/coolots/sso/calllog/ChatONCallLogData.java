package com.coolots.sso.calllog;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ChatONCallLogData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.coolots.sso.calllog.ChatONCallLogData.1
        @Override // android.os.Parcelable.Creator
        public ChatONCallLogData createFromParcel(Parcel inParcel) {
            return new ChatONCallLogData(inParcel);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int size) {
            return new ChatONCallLogData[size];
        }
    };
    private String calldate = "";
    private int duration = 0;
    private int calllogtype = -1;
    private int callmethod = -1;
    private String username = "";
    private String userid = "";
    private int groupcallkey = -1;
    private String rejectmsg = "";

    public ChatONCallLogData() {
    }

    public String getCalldate() {
        return this.calldate;
    }

    public void setCalldate(String calldate) {
        this.calldate = calldate;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCalllogtype() {
        return this.calllogtype;
    }

    public void setCalllogtype(int calllogtype) {
        this.calllogtype = calllogtype;
    }

    public int getCallmethod() {
        return this.callmethod;
    }

    public void setCallmethod(int callmethod) {
        this.callmethod = callmethod;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getGroupcallkey() {
        return this.groupcallkey;
    }

    public void setGroupcallkey(int groupcallkey) {
        this.groupcallkey = groupcallkey;
    }

    public String getRejectmsg() {
        return this.rejectmsg;
    }

    public void setRejectmsg(String rejectmsg) {
        this.rejectmsg = rejectmsg;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        if (this.calldate == null || this.calldate.isEmpty()) {
            dest.writeInt(0);
        } else {
            dest.writeInt(this.calldate.length());
            dest.writeString(this.calldate);
        }
        dest.writeInt(this.duration);
        dest.writeInt(this.calllogtype);
        dest.writeInt(this.callmethod);
        if (this.username == null || this.username.isEmpty()) {
            dest.writeInt(0);
        } else {
            dest.writeInt(this.username.length());
            dest.writeString(this.username);
        }
        if (this.userid == null || this.userid.isEmpty()) {
            dest.writeInt(0);
        } else {
            dest.writeInt(this.userid.length());
            dest.writeString(this.userid);
        }
        dest.writeInt(this.groupcallkey);
        if (this.rejectmsg != null && !this.rejectmsg.isEmpty()) {
            dest.writeInt(this.rejectmsg.length());
            dest.writeString(this.rejectmsg);
        } else {
            dest.writeInt(0);
        }
    }

    private void readFromParcel(Parcel incoming) {
        int length = incoming.readInt();
        if (length == 0) {
            this.calldate = null;
        } else {
            this.calldate = incoming.readString();
        }
        this.duration = incoming.readInt();
        this.calllogtype = incoming.readInt();
        this.callmethod = incoming.readInt();
        int length2 = incoming.readInt();
        if (length2 == 0) {
            this.username = null;
        } else {
            this.username = incoming.readString();
        }
        int length3 = incoming.readInt();
        if (length3 == 0) {
            this.userid = null;
        } else {
            this.userid = incoming.readString();
        }
        this.groupcallkey = incoming.readInt();
        int length4 = incoming.readInt();
        if (length4 != 0) {
            this.rejectmsg = incoming.readString();
        } else {
            this.rejectmsg = null;
        }
    }

    public ChatONCallLogData(Parcel parcel) {
        readFromParcel(parcel);
    }
}
