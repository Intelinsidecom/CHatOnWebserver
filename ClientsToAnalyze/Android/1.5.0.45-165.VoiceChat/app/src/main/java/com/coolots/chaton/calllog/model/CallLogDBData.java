package com.coolots.chaton.calllog.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.coolots.sso.calllog.ChatONCallLogData;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.DatabaseHelper;

/* loaded from: classes.dex */
public class CallLogDBData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.coolots.chaton.calllog.model.CallLogDBData.1
        @Override // android.os.Parcelable.Creator
        public CallLogDBData createFromParcel(Parcel inParcel) {
            return new CallLogDBData(inParcel);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int size) {
            return new CallLogDBData[size];
        }
    };
    public int _id = -1;
    public String calldate = "";
    public int duration = 0;
    public int calllogtype = -1;
    public int callmethod = -1;
    public long userno = -1;
    public String username = "";
    public String userid = "";
    public String phoneno = "";
    public String countrycode = "";
    public int groupcallkey = -1;
    public int hangupcode = -1;
    public String rejectmsg = "";
    public long groupid = -1;

    public CallLogDBData() {
    }

    public CallLogDBData setCallLogData(Cursor cursorC) {
        if (cursorC != null && (cursorC.getPosition() >= cursorC.getCount() || cursorC.getPosition() < 0)) {
            return null;
        }
        if (cursorC != null) {
            int nIndex = cursorC.getColumnIndex(DatabaseHelper.KEY_ROWID);
            if (nIndex >= 0) {
                this._id = cursorC.getInt(nIndex);
            }
            int nIndex2 = cursorC.getColumnIndex(DatabaseHelper.KEY_CALLDATE);
            if (nIndex2 >= 0) {
                this.calldate = cursorC.getString(nIndex2);
            }
            int nIndex3 = cursorC.getColumnIndex(DatabaseHelper.KEY_DURATION);
            if (nIndex3 >= 0) {
                this.duration = cursorC.getInt(nIndex3);
            }
            int nIndex4 = cursorC.getColumnIndex(DatabaseHelper.KEY_CALLLOGTYPE);
            if (nIndex4 >= 0) {
                this.calllogtype = cursorC.getInt(nIndex4);
            }
            int nIndex5 = cursorC.getColumnIndex(DatabaseHelper.KEY_CALLMETHOD);
            if (nIndex5 >= 0) {
                this.callmethod = cursorC.getInt(nIndex5);
            }
            int nIndex6 = cursorC.getColumnIndex(DatabaseHelper.KEY_USERNO);
            if (nIndex6 >= 0) {
                this.userno = cursorC.getLong(nIndex6);
            }
            int nIndex7 = cursorC.getColumnIndex(DatabaseHelper.KEY_USERNAME);
            if (nIndex7 >= 0) {
                this.username = cursorC.getString(nIndex7);
            }
            int nIndex8 = cursorC.getColumnIndex(DatabaseHelper.KEY_USERID);
            if (nIndex8 >= 0) {
                this.userid = cursorC.getString(nIndex8);
            }
            int nIndex9 = cursorC.getColumnIndex(DatabaseHelper.KEY_PHONENO);
            if (nIndex9 >= 0) {
                this.phoneno = cursorC.getString(nIndex9);
            }
            int nIndex10 = cursorC.getColumnIndex("countrycode");
            if (nIndex10 >= 0) {
                this.countrycode = cursorC.getString(nIndex10);
            }
            int nIndex11 = cursorC.getColumnIndex(DatabaseHelper.KEY_GROUPCALLKEY);
            if (nIndex11 >= 0) {
                this.groupcallkey = cursorC.getInt(nIndex11);
            }
            int nIndex12 = cursorC.getColumnIndex(DatabaseHelper.KEY_HANGUPCODE);
            if (nIndex12 >= 0) {
                this.hangupcode = cursorC.getInt(nIndex12);
            }
            int nIndex13 = cursorC.getColumnIndex(DatabaseHelper.KEY_REJECTMSG);
            if (nIndex13 >= 0) {
                this.rejectmsg = cursorC.getString(nIndex13);
            }
            int nIndex14 = cursorC.getColumnIndex(DatabaseHelper.KEY_GROUPID);
            if (nIndex14 >= 0) {
                this.groupid = cursorC.getLong(nIndex14);
                return this;
            }
            return this;
        }
        return this;
    }

    public ContentValues getContentValue() {
        ContentValues value = new ContentValues();
        if (this.calldate != null && !this.calldate.equals("")) {
            value.put(DatabaseHelper.KEY_CALLDATE, this.calldate);
        }
        if (this.duration > 0) {
            value.put(DatabaseHelper.KEY_DURATION, Integer.valueOf(this.duration));
        }
        if (this.calllogtype >= 0) {
            value.put(DatabaseHelper.KEY_CALLLOGTYPE, Integer.valueOf(this.calllogtype));
        }
        if (this.callmethod >= 0) {
            value.put(DatabaseHelper.KEY_CALLMETHOD, Integer.valueOf(this.callmethod));
        }
        if (this.userno >= 0) {
            value.put(DatabaseHelper.KEY_USERNO, Long.valueOf(this.userno));
        }
        if (this.username != null && !this.username.equals("")) {
            value.put(DatabaseHelper.KEY_USERNAME, this.username);
        }
        if (this.userid != null && !this.userid.equals("")) {
            value.put(DatabaseHelper.KEY_USERID, this.userid);
        }
        if (this.phoneno != null && !this.phoneno.equals("")) {
            value.put(DatabaseHelper.KEY_PHONENO, this.phoneno);
        }
        if (this.countrycode != null && !this.countrycode.equals("")) {
            value.put("countrycode", this.countrycode);
        }
        if (this.groupcallkey >= 0) {
            value.put(DatabaseHelper.KEY_GROUPCALLKEY, Integer.valueOf(this.groupcallkey));
        }
        if (this.hangupcode >= 0) {
            value.put(DatabaseHelper.KEY_HANGUPCODE, Integer.valueOf(this.hangupcode));
        }
        if (this.rejectmsg != null && !this.rejectmsg.equals("")) {
            value.put(DatabaseHelper.KEY_REJECTMSG, this.rejectmsg);
        }
        if (this.groupid >= 0) {
            value.put(DatabaseHelper.KEY_GROUPID, Long.valueOf(this.groupid));
        }
        return value;
    }

    public void setContentValue(ContentValues cvalue) {
        this.calldate = (String) cvalue.get(DatabaseHelper.KEY_CALLDATE);
        this.duration = ((Integer) cvalue.get(DatabaseHelper.KEY_DURATION)).intValue();
        this.calllogtype = ((Integer) cvalue.get(DatabaseHelper.KEY_CALLLOGTYPE)).intValue();
        this.callmethod = ((Integer) cvalue.get(DatabaseHelper.KEY_CALLMETHOD)).intValue();
        this.userno = ((Long) cvalue.get(DatabaseHelper.KEY_USERNO)).longValue();
        this.username = (String) cvalue.get(DatabaseHelper.KEY_USERNAME);
        this.userid = (String) cvalue.get(DatabaseHelper.KEY_USERID);
        this.phoneno = (String) cvalue.get(DatabaseHelper.KEY_PHONENO);
        this.countrycode = (String) cvalue.get("countrycode");
        this.groupcallkey = ((Integer) cvalue.get(DatabaseHelper.KEY_GROUPCALLKEY)).intValue();
        this.hangupcode = ((Integer) cvalue.get(DatabaseHelper.KEY_HANGUPCODE)).intValue();
        this.rejectmsg = (String) cvalue.get(DatabaseHelper.KEY_REJECTMSG);
        this.groupid = ((Long) cvalue.get(DatabaseHelper.KEY_GROUPID)).longValue();
    }

    public boolean checkNecessaries() {
        return (this.calldate == null || this.calldate.equals("")) ? false : true;
    }

    public void setChatONCallLogData(ChatONCallLogData dest) {
        if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            dest.setCalldate(this.calldate);
            dest.setDuration(this.duration);
            dest.setCalllogtype(this.calllogtype);
            dest.setCallmethod(this.callmethod);
            dest.setUserid(ChatONStringConvert.getInstance().removeFooter(this.userid));
            dest.setUsername(this.username);
            dest.setRejectmsg(this.rejectmsg);
            dest.setGroupcallkey(this.groupcallkey);
        }
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
            dest.writeString(ChatONStringConvert.getInstance().removeFooter(this.userid));
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

    public CallLogDBData(Parcel parcel) {
        readFromParcel(parcel);
    }
}
