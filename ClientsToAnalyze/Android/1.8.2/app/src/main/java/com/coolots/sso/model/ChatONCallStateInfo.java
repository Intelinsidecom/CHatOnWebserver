package com.coolots.sso.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ChatONCallStateInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new C0042b();
    public static final int STATE_BUSY = 6;
    public static final int STATE_CALLING = 1;
    public static final int STATE_CONNECTED = 2;
    public static final int STATE_DISCONNECTED = 3;
    public static final int STATE_ERROR = -1;
    public static final int STATE_HOLD = 4;
    public static final int STATE_INIT = 0;
    public static final int STATE_MUTE = 5;
    private int mCallState;
    private List mMSISDNs;

    public ChatONCallStateInfo() {
        this.mCallState = 0;
        this.mMSISDNs = new ArrayList();
    }

    public ChatONCallStateInfo(Parcel parcel) {
        m62a(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCallState);
        parcel.writeStringList(this.mMSISDNs);
    }

    /* renamed from: a */
    public void m62a(Parcel parcel) {
        this.mCallState = parcel.readInt();
        parcel.readStringList(this.mMSISDNs);
    }
}
