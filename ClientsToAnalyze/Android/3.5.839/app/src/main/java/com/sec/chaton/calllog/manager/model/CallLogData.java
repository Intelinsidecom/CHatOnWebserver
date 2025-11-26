package com.sec.chaton.calllog.manager.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.sec.chaton.calllog.manager.p053b.C1452a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class CallLogData implements Parcelable {
    private static final String CLASSNAME = "[CallLogData]";
    public static final int DONT_CARE = -1;
    public static final int METHOD_CONFERENCE_VIDEO = 11;
    public static final int METHOD_CONFERENCE_VOICE = 10;
    public static final int METHOD_P2P_VIDEO = 7;
    public static final int METHOD_P2P_VOICE = 6;
    public static final int METHOD_SIP_VIDEO = 9;
    public static final int METHOD_SIP_VOICE = 8;
    public static final int REJECT_MESSAGE = 12;
    public static final int TYPE_BLOCKED = 4;
    public static final int TYPE_INCOMING = 0;
    public static final int TYPE_MISSED = 2;
    public static final int TYPE_OUTGOING = 1;
    public static final int TYPE_PARTICIPANT = 5;
    public static final int TYPE_REJECTED = 3;
    public static final int UPDATE_DATA_DIFERENCE_CALL = 1;
    public static final int UPDATE_DATA_DUP_SINGLE_CALL = 2;
    public static final int UPDATE_DATA_DUP_SINGLE_CALL_OTHER_DAY = 6;
    public static final int UPDATE_DATA_NEW_CONF_CALL = 4;
    public static final int UPDATE_DATA_SAME_CONF_CALL = 3;
    public static final int UPDATE_DATA_SKIP = 5;
    public static final String TAG = CallLogData.class.getSimpleName();
    public static final Parcelable.Creator CREATOR = new C1454b();
    public int _id = -1;
    public int callmethod = -1;
    public int myCalllogtype = -1;
    public int myDuration = -1;
    public List<C1455c> userInfo = null;
    public List<Integer> groupcallkey = null;
    public List<List<Integer>> totalIDList = null;
    public String rejectmsg = null;
    public long groupid = 0;

    public CallLogData() {
    }

    public CallLogData(Cursor cursor) {
        m7621a(cursor);
    }

    /* renamed from: a */
    private void m7621a(Cursor cursor) {
        if ((cursor == null || (cursor.getPosition() < cursor.getCount() && cursor.getPosition() >= 0)) && cursor != null) {
            int columnIndex = cursor.getColumnIndex("_id");
            if (columnIndex >= 0) {
                this._id = cursor.getInt(columnIndex);
                this.totalIDList = new ArrayList();
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(this._id));
                this.totalIDList.add(arrayList);
            }
            int columnIndex2 = cursor.getColumnIndex("callmethod");
            if (columnIndex2 >= 0) {
                this.callmethod = cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("calllogtype");
            if (columnIndex3 >= 0) {
                this.myCalllogtype = cursor.getInt(columnIndex3);
            }
            String string = null;
            int columnIndex4 = cursor.getColumnIndex("userid");
            if (columnIndex4 >= 0) {
                string = cursor.getString(columnIndex4);
            }
            String string2 = null;
            int columnIndex5 = cursor.getColumnIndex("username");
            if (columnIndex5 >= 0) {
                string2 = cursor.getString(columnIndex5);
            }
            String string3 = null;
            int columnIndex6 = cursor.getColumnIndex("buddy_name");
            if (columnIndex6 >= 0) {
                string3 = cursor.getString(columnIndex6);
            }
            String string4 = null;
            int columnIndex7 = cursor.getColumnIndex("buddy_status_message");
            if (columnIndex7 >= 0) {
                string4 = cursor.getString(columnIndex7);
            }
            String string5 = null;
            int columnIndex8 = cursor.getColumnIndex("buddy_orginal_number");
            if (columnIndex8 >= 0) {
                string5 = cursor.getString(columnIndex8);
            }
            int i = -1;
            int columnIndex9 = cursor.getColumnIndex("buddy_raw_contact_id");
            if (columnIndex9 >= 0) {
                i = cursor.getInt(columnIndex9);
            }
            int i2 = -1;
            int columnIndex10 = cursor.getColumnIndex("buddy_show_phone_number");
            if (columnIndex10 >= 0) {
                i2 = cursor.getInt(columnIndex10);
            }
            String string6 = null;
            int columnIndex11 = cursor.getColumnIndex("buddy_extra_info");
            if (columnIndex11 >= 0) {
                string6 = cursor.getString(columnIndex11);
            }
            String string7 = null;
            int columnIndex12 = cursor.getColumnIndex("buddy_msisdns");
            if (columnIndex12 >= 0) {
                string7 = cursor.getString(columnIndex12);
            }
            String string8 = null;
            int columnIndex13 = cursor.getColumnIndex("calldate");
            if (columnIndex13 >= 0) {
                string8 = cursor.getString(columnIndex13);
            }
            int i3 = -1;
            int columnIndex14 = cursor.getColumnIndex("duration");
            if (columnIndex14 >= 0) {
                i3 = cursor.getInt(columnIndex14);
                this.myDuration = i3;
            }
            int i4 = -1;
            int columnIndex15 = cursor.getColumnIndex("calllogtype");
            if (columnIndex15 >= 0) {
                i4 = cursor.getInt(columnIndex15);
            }
            if (string != null && !TextUtils.isEmpty(string)) {
                this.userInfo = new ArrayList();
                this.userInfo.add(new C1455c(this, string, string2, string3, string4, string5, i, i2, string6, string7, string8, i3, i4));
            }
            int columnIndex16 = cursor.getColumnIndex("groupcallkey");
            if (columnIndex16 > 0) {
                if (cursor.getInt(columnIndex16) > 0) {
                    this.groupcallkey = new ArrayList();
                    this.groupcallkey.add(Integer.valueOf(cursor.getInt(columnIndex16)));
                } else {
                    this.groupcallkey = null;
                }
            }
            int columnIndex17 = cursor.getColumnIndex("rejectmsg");
            if (columnIndex17 >= 0) {
                this.rejectmsg = cursor.getString(columnIndex17);
            }
            int columnIndex18 = cursor.getColumnIndex("groupid");
            if (columnIndex18 > 0) {
                this.groupid = cursor.getLong(columnIndex18);
            }
        }
    }

    /* renamed from: a */
    public ContentValues m7624a(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(i));
        return contentValues;
    }

    /* renamed from: a */
    public int m7623a(Cursor cursor, int i) {
        CallLogData callLogData = new CallLogData(cursor);
        if (callLogData.userInfo == null || callLogData.userInfo.isEmpty() || callLogData.userInfo.get(0).f5175a == null || TextUtils.isEmpty(callLogData.userInfo.get(0).f5175a)) {
            return 5;
        }
        if ((callLogData.rejectmsg != null || this.rejectmsg != null) && callLogData.groupcallkey == null) {
            return 1;
        }
        if (callLogData.groupcallkey == null && this.groupcallkey == null) {
            if (i != 2 && callLogData.userInfo.get(0).f5175a.equals(this.userInfo.get(0).f5175a) && (callLogData.userInfo.get(0).f5186l == this.userInfo.get(0).f5186l || ((callLogData.userInfo.get(0).f5186l == 0 && this.userInfo.get(0).f5186l == 1) || (callLogData.userInfo.get(0).f5186l == 1 && this.userInfo.get(0).f5186l == 0)))) {
                if (!C1452a.m7605a().m7617c(callLogData.userInfo.get(0).f5184j, this.userInfo.get(0).f5184j)) {
                    return 6;
                }
                if (i == 1) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(callLogData._id));
                    this.totalIDList.add(arrayList);
                }
                return 2;
            }
        } else if (callLogData.groupcallkey != null && this.groupcallkey != null) {
            if (this.groupcallkey.get(this.groupcallkey.size() - 1).intValue() == callLogData.groupcallkey.get(0).intValue()) {
                if (i == 0) {
                    return 1;
                }
                this.userInfo.add(new C1455c(this, callLogData.userInfo.get(0).f5175a, callLogData.userInfo.get(0).f5176b, callLogData.userInfo.get(0).f5177c, callLogData.userInfo.get(0).f5178d, callLogData.userInfo.get(0).f5179e, callLogData.userInfo.get(0).f5180f, callLogData.userInfo.get(0).f5181g, callLogData.userInfo.get(0).f5182h, callLogData.userInfo.get(0).f5183i, callLogData.userInfo.get(0).f5184j, callLogData.userInfo.get(0).f5185k, callLogData.userInfo.get(0).f5186l));
                this.totalIDList.get(this.totalIDList.size() - 1).add(Integer.valueOf(callLogData._id));
                return 3;
            }
            return 4;
        }
        return 1;
    }

    /* renamed from: a */
    public boolean m7626a(CallLogData callLogData) {
        return false;
    }

    /* renamed from: a */
    public ArrayList<Integer> m7625a() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Iterator<List<Integer>> it = this.totalIDList.iterator();
        while (it.hasNext()) {
            Iterator<Integer> it2 = it.next().iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next());
            }
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this._id);
        parcel.writeInt(this.callmethod);
        parcel.writeInt(this.myCalllogtype);
        parcel.writeLong(this.groupid);
        if (this.rejectmsg == null || TextUtils.isEmpty(this.rejectmsg)) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.rejectmsg.length());
            parcel.writeString(this.rejectmsg);
        }
        if (this.userInfo == null || this.userInfo.isEmpty()) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.userInfo.size());
            for (C1455c c1455c : this.userInfo) {
                if (c1455c.f5175a == null || TextUtils.isEmpty(c1455c.f5175a)) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(c1455c.f5175a.length());
                    parcel.writeString(c1455c.f5175a);
                }
                if (c1455c.f5176b == null || TextUtils.isEmpty(c1455c.f5176b)) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(c1455c.f5176b.length());
                    parcel.writeString(c1455c.f5176b);
                }
                if (c1455c.f5177c == null || TextUtils.isEmpty(c1455c.f5177c)) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(c1455c.f5177c.length());
                    parcel.writeString(c1455c.f5177c);
                }
                if (c1455c.f5178d == null || TextUtils.isEmpty(c1455c.f5178d)) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(c1455c.f5178d.length());
                    parcel.writeString(c1455c.f5178d);
                }
                if (c1455c.f5179e == null || TextUtils.isEmpty(c1455c.f5179e)) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(c1455c.f5179e.length());
                    parcel.writeString(c1455c.f5179e);
                }
                parcel.writeInt(c1455c.f5180f);
                parcel.writeInt(c1455c.f5181g);
                if (c1455c.f5182h == null || TextUtils.isEmpty(c1455c.f5182h)) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(c1455c.f5182h.length());
                    parcel.writeString(c1455c.f5182h);
                }
                if (c1455c.f5183i == null || TextUtils.isEmpty(c1455c.f5183i)) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(c1455c.f5183i.length());
                    parcel.writeString(c1455c.f5183i);
                }
                if (c1455c.f5184j == null || TextUtils.isEmpty(c1455c.f5184j)) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(c1455c.f5184j.length());
                    parcel.writeString(c1455c.f5184j);
                }
                parcel.writeInt(c1455c.f5185k);
                parcel.writeInt(c1455c.f5186l);
            }
        }
        if (this.groupcallkey == null || this.groupcallkey.isEmpty()) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.groupcallkey.size());
            Iterator<Integer> it = this.groupcallkey.iterator();
            while (it.hasNext()) {
                parcel.writeInt(it.next().intValue());
            }
        }
        if (this.totalIDList == null || this.totalIDList.isEmpty()) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(this.totalIDList.size());
        for (List<Integer> list : this.totalIDList) {
            if (list == null || list.isEmpty()) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(list.size());
                Iterator<Integer> it2 = list.iterator();
                while (it2.hasNext()) {
                    parcel.writeInt(it2.next().intValue());
                }
            }
        }
    }

    /* renamed from: a */
    private void m7622a(Parcel parcel) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        this._id = parcel.readInt();
        this.callmethod = parcel.readInt();
        this.myCalllogtype = parcel.readInt();
        this.groupid = parcel.readLong();
        if (parcel.readInt() == 0) {
            this.rejectmsg = null;
        } else {
            this.rejectmsg = parcel.readString();
        }
        int i = parcel.readInt();
        if (i == 0) {
            this.userInfo = null;
        } else {
            this.userInfo = new ArrayList();
            for (int i2 = i; i2 > 0; i2--) {
                if (parcel.readInt() == 0) {
                    string = null;
                } else {
                    string = parcel.readString();
                }
                if (parcel.readInt() == 0) {
                    string2 = null;
                } else {
                    string2 = parcel.readString();
                }
                if (parcel.readInt() == 0) {
                    string3 = null;
                } else {
                    string3 = parcel.readString();
                }
                if (parcel.readInt() == 0) {
                    string4 = null;
                } else {
                    string4 = parcel.readString();
                }
                if (parcel.readInt() == 0) {
                    string5 = null;
                } else {
                    string5 = parcel.readString();
                }
                int i3 = parcel.readInt();
                int i4 = parcel.readInt();
                if (parcel.readInt() == 0) {
                    string6 = null;
                } else {
                    string6 = parcel.readString();
                }
                if (parcel.readInt() == 0) {
                    string7 = null;
                } else {
                    string7 = parcel.readString();
                }
                if (parcel.readInt() == 0) {
                    string8 = null;
                } else {
                    string8 = parcel.readString();
                }
                this.userInfo.add(new C1455c(this, string, string2, string3, string4, string5, i3, i4, string6, string7, string8, parcel.readInt(), parcel.readInt()));
            }
        }
        int i5 = parcel.readInt();
        if (i5 == 0) {
            this.groupcallkey = null;
        } else {
            this.groupcallkey = new ArrayList();
            while (i5 > 0) {
                this.groupcallkey.add(Integer.valueOf(parcel.readInt()));
                i5--;
            }
        }
        int i6 = parcel.readInt();
        if (i6 == 0) {
            this.totalIDList = null;
            return;
        }
        this.totalIDList = new ArrayList();
        for (int i7 = i6; i7 > 0; i7--) {
            int i8 = parcel.readInt();
            if (i8 != 0) {
                ArrayList arrayList = new ArrayList();
                while (i8 > 0) {
                    arrayList.add(Integer.valueOf(parcel.readInt()));
                    i8--;
                }
                this.totalIDList.add(arrayList);
            }
        }
    }

    public CallLogData(Parcel parcel) {
        m7622a(parcel);
    }
}
