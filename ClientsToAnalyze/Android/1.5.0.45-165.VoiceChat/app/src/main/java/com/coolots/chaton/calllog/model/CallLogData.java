package com.coolots.chaton.calllog.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import com.coolots.chaton.calllog.util.CallLogStringUtil;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.DatabaseHelper;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CallLogData implements DisposeInterface, Parcelable {
    private static final String CLASSNAME = "[CallLogData]";
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.coolots.chaton.calllog.model.CallLogData.1
        @Override // android.os.Parcelable.Creator
        public CallLogData createFromParcel(Parcel inParcel) {
            return new CallLogData(inParcel);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int size) {
            return new CallLogData[size];
        }
    };
    public static final int UPDATE_DATA_DIFERENCE_CALL = 1;
    public static final int UPDATE_DATA_DUP_SINGLE_CALL = 2;
    public static final int UPDATE_DATA_DUP_SINGLE_CALL_OTHER_DAY = 6;
    public static final int UPDATE_DATA_NEW_CONF_CALL = 4;
    public static final int UPDATE_DATA_SAME_CONF_CALL = 3;
    public static final int UPDATE_DATA_SKIP = 5;
    public int _id = -1;
    public int callmethod = -1;
    public int myCalllogtype = -1;
    public List<UserInfo> userInfo = null;
    public List<Integer> groupcallkey = null;
    public List<List<Integer>> totalIDList = null;
    public String rejectmsg = null;
    public long groupid = 0;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public class UserInfo implements DisposeInterface {
        public String calldate;
        public int calllogtype;
        public int duration;
        public String userDefaultName;
        public String userDisplayName;
        public String userID;
        public String userMessage;

        public UserInfo(String userID, String displayName, String defaultName, String message, String calldate, int duration, int calllogtype) {
            this.userID = null;
            this.userDisplayName = null;
            this.userDefaultName = null;
            this.userMessage = null;
            this.calldate = null;
            this.duration = -1;
            this.calllogtype = -1;
            this.userID = userID;
            this.userDisplayName = displayName;
            this.userDefaultName = defaultName;
            this.userMessage = message;
            this.calldate = calldate;
            this.duration = duration;
            this.calllogtype = calllogtype;
        }

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            this.userID = null;
            this.userDisplayName = null;
            this.userDefaultName = null;
            this.userMessage = null;
            this.calldate = null;
        }
    }

    public CallLogData() {
    }

    public CallLogData(Cursor cursor) {
        copy(cursor);
    }

    private void copy(Cursor cursor) {
        if ((cursor == null || (cursor.getPosition() < cursor.getCount() && cursor.getPosition() >= 0)) && cursor != null) {
            int nIndex = cursor.getColumnIndex(DatabaseHelper.KEY_ROWID);
            if (nIndex >= 0) {
                this._id = cursor.getInt(nIndex);
                this.totalIDList = new ArrayList();
                List<Integer> idList = new ArrayList<>();
                idList.add(Integer.valueOf(this._id));
                this.totalIDList.add(idList);
            }
            int nIndex2 = cursor.getColumnIndex(DatabaseHelper.KEY_CALLMETHOD);
            if (nIndex2 >= 0) {
                this.callmethod = cursor.getInt(nIndex2);
            }
            int nIndex3 = cursor.getColumnIndex(DatabaseHelper.KEY_CALLLOGTYPE);
            if (nIndex3 >= 0) {
                this.myCalllogtype = cursor.getInt(nIndex3);
            }
            String userID = null;
            int nIndex4 = cursor.getColumnIndex(DatabaseHelper.KEY_USERID);
            if (nIndex4 >= 0) {
                userID = cursor.getString(nIndex4);
            }
            String userDisplayName = null;
            if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                userDisplayName = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getUserNameByUserID(userID);
            } else {
                int nIndex5 = cursor.getColumnIndex(DatabaseHelper.KEY_DISPLAYNAME);
                if (nIndex5 >= 0) {
                    userDisplayName = cursor.getString(nIndex5);
                }
            }
            String userDefaultName = null;
            int nIndex6 = cursor.getColumnIndex(DatabaseHelper.KEY_USERNAME);
            if (nIndex6 >= 0) {
                userDefaultName = cursor.getString(nIndex6);
            }
            String userMessage = null;
            if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                    userMessage = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getUserMessageByUserID(userID);
                } else {
                    userMessage = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getUserMessageByUserNO(((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getUserNoByUserID(userID));
                }
            } else {
                int nIndex7 = cursor.getColumnIndex("message");
                if (nIndex7 >= 0) {
                    userMessage = cursor.getString(nIndex7);
                }
            }
            String calldate = null;
            int nIndex8 = cursor.getColumnIndex(DatabaseHelper.KEY_CALLDATE);
            if (nIndex8 >= 0) {
                calldate = cursor.getString(nIndex8);
            }
            int duration = -1;
            int nIndex9 = cursor.getColumnIndex(DatabaseHelper.KEY_DURATION);
            if (nIndex9 >= 0) {
                duration = cursor.getInt(nIndex9);
            }
            int calllogtype = -1;
            int nIndex10 = cursor.getColumnIndex(DatabaseHelper.KEY_CALLLOGTYPE);
            if (nIndex10 >= 0) {
                calllogtype = cursor.getInt(nIndex10);
            }
            if (userID != null && !userID.isEmpty()) {
                this.userInfo = new ArrayList();
                this.userInfo.add(new UserInfo(userID, userDisplayName, userDefaultName, userMessage, calldate, duration, calllogtype));
            }
            int nIndex11 = cursor.getColumnIndex(DatabaseHelper.KEY_GROUPCALLKEY);
            if (nIndex11 > 0) {
                if (cursor.getInt(nIndex11) > 0) {
                    this.groupcallkey = new ArrayList();
                    this.groupcallkey.add(Integer.valueOf(cursor.getInt(nIndex11)));
                } else {
                    this.groupcallkey = null;
                }
            }
            int nIndex12 = cursor.getColumnIndex(DatabaseHelper.KEY_REJECTMSG);
            if (nIndex12 >= 0) {
                this.rejectmsg = cursor.getString(nIndex12);
            }
            int nIndex13 = cursor.getColumnIndex(DatabaseHelper.KEY_GROUPID);
            if (nIndex13 > 0) {
                this.groupid = cursor.getLong(nIndex13);
            }
        }
    }

    public ContentValues getContentValueForDelete(int deleteId) {
        ContentValues value = new ContentValues();
        value.put(DatabaseHelper.KEY_ROWID, Integer.valueOf(deleteId));
        return value;
    }

    public int updateData(Cursor cursor, int rule) {
        CallLogData destination = new CallLogData(cursor);
        if (destination.userInfo == null || destination.userInfo.isEmpty() || destination.userInfo.get(0).userID == null || destination.userInfo.get(0).userID.isEmpty()) {
            return 5;
        }
        if ((destination.rejectmsg != null || this.rejectmsg != null) && destination.groupcallkey == null) {
            return 1;
        }
        if (destination.groupcallkey == null && this.groupcallkey == null) {
            if (rule == 2) {
                return 1;
            }
            if (destination.userInfo.get(0).userID.equals(this.userInfo.get(0).userID) && (destination.userInfo.get(0).calllogtype == this.userInfo.get(0).calllogtype || ((destination.userInfo.get(0).calllogtype == 0 && this.userInfo.get(0).calllogtype == 1) || (destination.userInfo.get(0).calllogtype == 1 && this.userInfo.get(0).calllogtype == 0)))) {
                if (!CallLogStringUtil.getInstance().isSameDate(destination.userInfo.get(0).calldate, this.userInfo.get(0).calldate)) {
                    destination.dispose();
                    return 6;
                }
                if (rule == 1) {
                    List<Integer> idList = new ArrayList<>();
                    idList.add(Integer.valueOf(destination._id));
                    this.totalIDList.add(idList);
                }
                destination.dispose();
                return 2;
            }
        } else if (destination.groupcallkey != null && this.groupcallkey != null) {
            int thisGroupKey = this.groupcallkey.get(this.groupcallkey.size() - 1).intValue();
            int destGroupKey = destination.groupcallkey.get(0).intValue();
            if (thisGroupKey == destGroupKey) {
                if (rule == 0) {
                    destination.dispose();
                    return 1;
                }
                this.userInfo.add(new UserInfo(destination.userInfo.get(0).userID, destination.userInfo.get(0).userDisplayName, destination.userInfo.get(0).userDefaultName, destination.userInfo.get(0).userMessage, destination.userInfo.get(0).calldate, destination.userInfo.get(0).duration, destination.userInfo.get(0).calllogtype));
                this.totalIDList.get(this.totalIDList.size() - 1).add(Integer.valueOf(destination._id));
                destination.dispose();
                return 3;
            }
            destination.dispose();
            return 4;
        }
        destination.dispose();
        return 1;
    }

    public boolean isDupConferenceCall(CallLogData destination) {
        return false;
    }

    private boolean isSameGroupMember(List<UserInfo> members1, List<UserInfo> members2) {
        if (members1.size() != members2.size()) {
            return false;
        }
        for (UserInfo destUserInfo : members1) {
            if (!isContainMember(members2, destUserInfo)) {
                return false;
            }
        }
        return true;
    }

    private boolean isContainMember(List<UserInfo> members, UserInfo member) {
        for (UserInfo userInfo : members) {
            if (userInfo.userID != null && !userInfo.userID.isEmpty() && userInfo.userID.equals(member.userID)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> getAllRawIDList() {
        ArrayList<Integer> rawIDList = new ArrayList<>();
        for (List<Integer> idList : this.totalIDList) {
            for (Integer id : idList) {
                rawIDList.add(id);
            }
        }
        return rawIDList;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.userInfo != null) {
            for (UserInfo data : this.userInfo) {
                data.dispose();
            }
            this.userInfo.clear();
            this.userInfo = null;
        }
        if (this.groupcallkey != null) {
            this.groupcallkey.clear();
            this.groupcallkey = null;
        }
        if (this.totalIDList != null) {
            for (List<Integer> data2 : this.totalIDList) {
                data2.clear();
            }
            this.totalIDList.clear();
            this.totalIDList = null;
        }
        this.rejectmsg = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this._id);
        dest.writeInt(this.callmethod);
        dest.writeInt(this.myCalllogtype);
        dest.writeLong(this.groupid);
        if (this.rejectmsg == null || this.rejectmsg.isEmpty()) {
            dest.writeInt(0);
        } else {
            dest.writeInt(this.rejectmsg.length());
            dest.writeString(this.rejectmsg);
        }
        if (this.userInfo == null || this.userInfo.isEmpty()) {
            dest.writeInt(0);
        } else {
            dest.writeInt(this.userInfo.size());
            for (UserInfo user : this.userInfo) {
                if (user.userID == null || user.userID.isEmpty()) {
                    dest.writeInt(0);
                } else {
                    dest.writeInt(user.userID.length());
                    dest.writeString(user.userID);
                }
                if (user.userDisplayName == null || user.userDisplayName.isEmpty()) {
                    dest.writeInt(0);
                } else {
                    dest.writeInt(user.userDisplayName.length());
                    dest.writeString(user.userDisplayName);
                }
                if (user.userDefaultName == null || user.userDefaultName.isEmpty()) {
                    dest.writeInt(0);
                } else {
                    dest.writeInt(user.userDefaultName.length());
                    dest.writeString(user.userDefaultName);
                }
                if (user.userMessage == null || user.userMessage.isEmpty()) {
                    dest.writeInt(0);
                } else {
                    dest.writeInt(user.userMessage.length());
                    dest.writeString(user.userMessage);
                }
                if (user.calldate == null || user.calldate.isEmpty()) {
                    dest.writeInt(0);
                } else {
                    dest.writeInt(user.calldate.length());
                    dest.writeString(user.calldate);
                }
                dest.writeInt(user.duration);
                dest.writeInt(user.calllogtype);
            }
        }
        if (this.groupcallkey == null || this.groupcallkey.isEmpty()) {
            dest.writeInt(0);
        } else {
            dest.writeInt(this.groupcallkey.size());
            for (Integer key : this.groupcallkey) {
                dest.writeInt(key.intValue());
            }
        }
        if (this.totalIDList != null && !this.totalIDList.isEmpty()) {
            dest.writeInt(this.totalIDList.size());
            for (List<Integer> list : this.totalIDList) {
                if (list == null || list.isEmpty()) {
                    dest.writeInt(0);
                } else {
                    dest.writeInt(list.size());
                    for (Integer data : list) {
                        dest.writeInt(data.intValue());
                    }
                }
            }
            return;
        }
        dest.writeInt(0);
    }

    private void readFromParcel(Parcel incoming) {
        this._id = incoming.readInt();
        this.callmethod = incoming.readInt();
        this.myCalllogtype = incoming.readInt();
        this.groupid = incoming.readLong();
        if (incoming.readInt() == 0) {
            this.rejectmsg = null;
        } else {
            this.rejectmsg = incoming.readString();
        }
        int length = incoming.readInt();
        if (length == 0) {
            this.userInfo = null;
        } else {
            this.userInfo = new ArrayList();
            while (length > 0) {
                int length1 = incoming.readInt();
                String userID = length1 == 0 ? null : incoming.readString();
                int length12 = incoming.readInt();
                String userDisplayName = length12 == 0 ? null : incoming.readString();
                int length13 = incoming.readInt();
                String userDefaultName = length13 == 0 ? null : incoming.readString();
                int length14 = incoming.readInt();
                String userMessage = length14 == 0 ? null : incoming.readString();
                int length15 = incoming.readInt();
                String calldate = length15 == 0 ? null : incoming.readString();
                int duration = incoming.readInt();
                int calllogtype = incoming.readInt();
                this.userInfo.add(new UserInfo(userID, userDisplayName, userDefaultName, userMessage, calldate, duration, calllogtype));
                length--;
            }
        }
        int length2 = incoming.readInt();
        if (length2 == 0) {
            this.groupcallkey = null;
        } else {
            this.groupcallkey = new ArrayList();
            while (length2 > 0) {
                this.groupcallkey.add(Integer.valueOf(incoming.readInt()));
                length2--;
            }
        }
        int length3 = incoming.readInt();
        if (length3 != 0) {
            this.totalIDList = new ArrayList();
            while (length3 > 0) {
                int length16 = incoming.readInt();
                if (length16 != 0) {
                    List<Integer> idList = new ArrayList<>();
                    while (length16 > 0) {
                        idList.add(Integer.valueOf(incoming.readInt()));
                        length16--;
                    }
                    this.totalIDList.add(idList);
                }
                length3--;
            }
            return;
        }
        this.totalIDList = null;
    }

    public CallLogData(Parcel parcel) {
        readFromParcel(parcel);
    }
}
