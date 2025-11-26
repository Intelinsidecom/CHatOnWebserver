package com.samsung.android.service.gesture;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class GestureEvent implements Parcelable {
    public static final Parcelable.Creator<GestureEvent> CREATOR = new Parcelable.Creator<GestureEvent>() { // from class: com.samsung.android.service.gesture.GestureEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GestureEvent createFromParcel(Parcel source) {
            return new GestureEvent(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GestureEvent[] newArray(int size) {
            return new GestureEvent[size];
        }
    };
    public static final int GESTURE_EVENT_APPROACH = 2;
    public static final int GESTURE_EVENT_HANDSHAPE = 6;
    public static final int GESTURE_EVENT_HOVER = 5;
    public static final int GESTURE_EVENT_SWEEP_DOWN = 4;
    public static final int GESTURE_EVENT_SWEEP_LEFT = 1;
    public static final int GESTURE_EVENT_SWEEP_RIGHT = 0;
    public static final int GESTURE_EVENT_SWEEP_UP = 3;
    private int mEvent;
    private String mProvider;

    public GestureEvent() {
        this.mEvent = 0;
    }

    public GestureEvent(Parcel src) {
        readFromParcel(src);
    }

    public int getEvent() {
        return this.mEvent;
    }

    public void setEvent(int event) {
        this.mEvent = event;
    }

    public String getProvider() {
        return this.mProvider;
    }

    public void setProvider(String provider) {
        this.mProvider = provider;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mEvent);
        dest.writeString(this.mProvider);
    }

    private void readFromParcel(Parcel src) {
        this.mEvent = src.readInt();
        this.mProvider = src.readString();
    }
}
