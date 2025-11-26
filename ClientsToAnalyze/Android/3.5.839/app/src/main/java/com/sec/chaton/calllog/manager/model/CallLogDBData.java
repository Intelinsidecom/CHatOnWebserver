package com.sec.chaton.calllog.manager.model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.coolots.sso.calllog.ChatONCallLogData;

/* loaded from: classes.dex */
public class CallLogDBData implements Parcelable {
    public int _id;
    public String calldate;
    public int calllogtype;
    public int callmethod;
    public int duration;
    public int groupcallkey;
    public String rejectmsg;
    public String userid;
    public String username;
    private static final String TAG = CallLogDBData.class.getSimpleName();
    public static final Parcelable.Creator CREATOR = new C1453a();

    public CallLogDBData() {
        this._id = -1;
        this.calldate = "";
        this.duration = 0;
        this.calllogtype = -1;
        this.callmethod = -1;
        this.username = "";
        this.userid = "";
        this.groupcallkey = -1;
        this.rejectmsg = "";
    }

    public CallLogDBData(ChatONCallLogData chatONCallLogData) {
        this._id = -1;
        this.calldate = "";
        this.duration = 0;
        this.calllogtype = -1;
        this.callmethod = -1;
        this.username = "";
        this.userid = "";
        this.groupcallkey = -1;
        this.rejectmsg = "";
        this.calldate = chatONCallLogData.m1512a();
        this.duration = chatONCallLogData.m1514b();
        this.calllogtype = chatONCallLogData.m1515c();
        this.callmethod = chatONCallLogData.m1516d();
        this.username = chatONCallLogData.m1517e();
        this.userid = chatONCallLogData.m1518f();
        this.groupcallkey = chatONCallLogData.m1519g();
        this.rejectmsg = chatONCallLogData.m1520h();
    }

    /* renamed from: a */
    public ContentValues m7619a() {
        ContentValues contentValues = new ContentValues();
        if (this.calldate != null && !this.calldate.equals("")) {
            contentValues.put("calldate", this.calldate);
        }
        if (this.duration > 0) {
            contentValues.put("duration", Integer.valueOf(this.duration));
        }
        if (this.calllogtype >= 0) {
            contentValues.put("calllogtype", Integer.valueOf(this.calllogtype));
        }
        if (this.callmethod >= 0) {
            contentValues.put("callmethod", Integer.valueOf(this.callmethod));
        }
        if (this.username != null && !this.username.equals("")) {
            contentValues.put("username", this.username);
        }
        if (this.userid != null && !this.userid.equals("")) {
            contentValues.put("userid", this.userid);
        }
        if (this.groupcallkey >= 0) {
            contentValues.put("groupcallkey", Integer.valueOf(this.groupcallkey));
        }
        if (this.rejectmsg != null && !this.rejectmsg.equals("")) {
            contentValues.put("rejectmsg", this.rejectmsg);
        }
        return contentValues;
    }

    /* renamed from: b */
    public boolean m7620b() {
        return (this.calldate == null || this.calldate.equals("")) ? false : true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.calldate == null || TextUtils.isEmpty(this.calldate)) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.calldate.length());
            parcel.writeString(this.calldate);
        }
        parcel.writeInt(this.duration);
        parcel.writeInt(this.calllogtype);
        parcel.writeInt(this.callmethod);
        if (this.username == null || TextUtils.isEmpty(this.username)) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.username.length());
            parcel.writeString(this.username);
        }
        if (this.userid == null || TextUtils.isEmpty(this.userid)) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.userid.length());
            parcel.writeString(this.userid);
        }
        parcel.writeInt(this.groupcallkey);
        if (this.rejectmsg == null || TextUtils.isEmpty(this.rejectmsg)) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.rejectmsg.length());
            parcel.writeString(this.rejectmsg);
        }
    }

    /* renamed from: a */
    private void m7618a(Parcel parcel) {
        if (parcel.readInt() == 0) {
            this.calldate = null;
        } else {
            this.calldate = parcel.readString();
        }
        this.duration = parcel.readInt();
        this.calllogtype = parcel.readInt();
        this.callmethod = parcel.readInt();
        if (parcel.readInt() == 0) {
            this.username = null;
        } else {
            this.username = parcel.readString();
        }
        if (parcel.readInt() == 0) {
            this.userid = null;
        } else {
            this.userid = parcel.readString();
        }
        this.groupcallkey = parcel.readInt();
        if (parcel.readInt() == 0) {
            this.rejectmsg = null;
        } else {
            this.rejectmsg = parcel.readString();
        }
    }

    public CallLogDBData(Parcel parcel) {
        this._id = -1;
        this.calldate = "";
        this.duration = 0;
        this.calllogtype = -1;
        this.callmethod = -1;
        this.username = "";
        this.userid = "";
        this.groupcallkey = -1;
        this.rejectmsg = "";
        m7618a(parcel);
    }
}
