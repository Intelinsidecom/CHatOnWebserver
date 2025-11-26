package com.coolots.sso.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class ChatONCallStartInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new C0041a();
    public static final int ERROR_ACCOUNT_NONE = -1021;
    public static final int ERROR_AIRPLAINMODE = -1019;
    public static final int ERROR_ALREADY_RECORDING = -1015;
    public static final int ERROR_BATTERY_LOW = -1022;
    public static final int ERROR_BUSY = -1011;
    public static final int ERROR_BUSY_3GCALL = -1017;
    public static final int ERROR_CANT_FIND_DESTINATION = -1012;
    public static final int ERROR_INVALID_CALLID = -1014;
    public static final int ERROR_INVALID_MEMBER_CNT = -1020;
    public static final int ERROR_INVALID_STATE = -1013;
    public static final int ERROR_IN_LOGIN_PROCESS = -1021;
    public static final int ERROR_NETWORK_CONNECTION = -1018;
    public static final int ERROR_NOT_INITIALIZED_ENGINE = -1001;
    public static final int ERROR_NOT_RECORDING = -1016;
    public static final int ERROR_OVER_MEMBER_CNT = -1021;
    public static final int ERROR_SUCCESS = 0;
    public static final int ERROR_UNKNOWN = -1002;
    private int mCallStartInfo;
    private boolean mGotoChattingPage;
    private String mIncomingRejectMessage;

    public ChatONCallStartInfo() {
        this.mCallStartInfo = ERROR_UNKNOWN;
        this.mGotoChattingPage = false;
        this.mIncomingRejectMessage = "";
    }

    public ChatONCallStartInfo(Parcel parcel) {
        m61a(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCallStartInfo);
        parcel.writeInt(this.mGotoChattingPage ? 0 : 1);
        parcel.writeString(this.mIncomingRejectMessage);
    }

    /* renamed from: a */
    public void m61a(Parcel parcel) {
        this.mCallStartInfo = parcel.readInt();
        this.mGotoChattingPage = parcel.readInt() == 0;
        this.mIncomingRejectMessage = parcel.readString();
    }
}
