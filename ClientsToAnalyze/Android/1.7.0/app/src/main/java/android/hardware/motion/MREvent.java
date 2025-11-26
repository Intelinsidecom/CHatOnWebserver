package android.hardware.motion;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class MREvent implements Parcelable {
    public static final int BLOW = 66;
    public static final int BOUNCE = 46;
    public static final int BT_SHARING_RECEIVE_NOT_READY = 41;
    public static final int BT_SHARING_RECEIVE_READY = 40;
    public static final int BT_SHARING_SEND_PAUSE = 43;
    public static final int BT_SHARING_SEND_START = 42;
    public static final int BT_SHARING_SEND_STOP = 44;
    public static final int CALLPOSE_L = 76;
    public static final int CALLPOSE_R = 77;
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: android.hardware.motion.MREvent.1
        @Override // android.os.Parcelable.Creator
        public MREvent createFromParcel(Parcel parcel) {
            return new MREvent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MREvent[] newArray(int i) {
            return new MREvent[i];
        }
    };
    public static final int DIRECT_CALL = 68;
    public static final int FLAT = 71;
    public static final int FLIP_TOP_TO_BOTTOM = 10;
    public static final int LOCK_EXECUTE_APP = 69;
    public static final int LOCK_EXECUTE_CAMERA_L = 73;
    public static final int LOCK_EXECUTE_CAMERA_R = 74;
    public static final int MAX = 86;
    public static final int NONE = 0;
    public static final int ONE_TAPPING_GYRO = 62;
    public static final int ONE_TIPPING_GYRO = 64;
    public static final int PANNING_GYRO = 61;
    public static final int REACTIVE_ALERT = 67;
    public static final int ROTATE_0 = 28;
    public static final int ROTATE_180 = 30;
    public static final int ROTATE_270 = 31;
    public static final int ROTATE_90 = 29;
    public static final int ROTATE_HORIZONTAL = 45;
    public static final int ROTATE_START = 32;
    public static final int ROTATE_STOP = 33;
    public static final int SHAKE = 34;
    public static final int SHAKE_START = 35;
    public static final int SHAKE_STOP = 36;
    public static final int SHORT_SHAKE = 37;
    public static final int SHORT_SHAKE_START = 38;
    public static final int SHORT_SHAKE_STOP = 39;
    public static final int SNAP1_X_NEGATIVE = 48;
    public static final int SNAP1_X_POSITIVE = 47;
    public static final int SNAP1_Y_NEGATIVE = 50;
    public static final int SNAP1_Y_POSITIVE = 49;
    public static final int SNAP1_Z_NEGATIVE = 52;
    public static final int SNAP1_Z_POSITIVE = 51;
    public static final int SNAP2_X_NEGATIVE = 54;
    public static final int SNAP2_X_POSITIVE = 53;
    public static final int SNAP2_Y_NEGATIVE = 56;
    public static final int SNAP2_Y_POSITIVE = 55;
    public static final int SNAP2_Z_NEGATIVE = 58;
    public static final int SNAP2_Z_POSITIVE = 57;
    public static final int SNAP_LEFT = 59;
    public static final int SNAP_RIGHT = 60;
    public static final int SNAP_X_NEGATIVE = 3;
    public static final int SNAP_X_POSITIVE = 2;
    public static final int SNAP_Y_NEGATIVE = 5;
    public static final int SNAP_Y_POSITIVE = 4;
    public static final int SNAP_Z_NEGATIVE = 7;
    public static final int SNAP_Z_POSITIVE = 6;
    public static final int SPEAKER_PHONE_OFF = 9;
    public static final int SPEAKER_PHONE_ON = 8;
    public static final int TILT = 72;
    public static final int TILT_BACK = 23;
    public static final int TILT_DOWN_LEVEL_1 = 81;
    public static final int TILT_DOWN_LEVEL_2 = 82;
    public static final int TILT_DOWN_LEVEL_3 = 83;
    public static final int TILT_FRONT = 22;
    public static final int TILT_FRONT_BACK_END = 24;
    public static final int TILT_LANDSCAPE_LEFT_LEVEL_1 = 17;
    public static final int TILT_LANDSCAPE_LEFT_LEVEL_2 = 18;
    public static final int TILT_LANDSCAPE_LEFT_RIGHT_STOP = 21;
    public static final int TILT_LANDSCAPE_RIGHT_LEVEL_1 = 19;
    public static final int TILT_LANDSCAPE_RIGHT_LEVEL_2 = 20;
    public static final int TILT_LEFT = 25;
    public static final int TILT_LEFT_RIGHT_END = 27;
    public static final int TILT_LEVEL_FLAT = 85;
    public static final int TILT_LEVEL_ZERO = 84;
    public static final int TILT_PORTRAIT_BACK = 12;
    public static final int TILT_PORTRAIT_FRONT = 11;
    public static final int TILT_PORTRAIT_FRONT_BACK_STOP = 13;
    public static final int TILT_PORTRAIT_LEFT = 14;
    public static final int TILT_PORTRAIT_LEFT_RIGHT_STOP = 16;
    public static final int TILT_PORTRAIT_RIGHT = 15;
    public static final int TILT_RIGHT = 26;
    public static final int TILT_TO_UNLOCK = 75;
    public static final int TILT_UP_LEVEL_1 = 78;
    public static final int TILT_UP_LEVEL_2 = 79;
    public static final int TILT_UP_LEVEL_3 = 80;
    public static final int TWO_TAPPING = 1;
    public static final int TWO_TAPPING_GYRO = 63;
    public static final int TWO_TIPPING_GYRO = 65;
    public static final int VOLUMEDOWN = 70;
    private int motion;
    private int panningDx;
    private int panningDy;
    private int panningDz;
    private int tilt;
    private int walkingStatus;

    public MREvent() {
        this.motion = 0;
        this.panningDx = 0;
        this.panningDy = 0;
        this.panningDz = 0;
        this.walkingStatus = 0;
    }

    public MREvent(Parcel parcel) {
        readFromParcel(parcel);
    }

    public int getMotion() {
        return this.motion;
    }

    public void setMotion(int i) {
        this.motion = 0;
        if (i >= 0 && i <= 86) {
            this.motion = i;
        }
    }

    public void setPanningDx(int i) {
        this.panningDx = i;
    }

    public void setPanningDy(int i) {
        this.panningDy = i;
    }

    public void setPanningDz(int i) {
        this.panningDz = i;
    }

    public void setTilt(int i) {
        this.tilt = i;
    }

    public void setWalkingStatus(int i) {
        this.walkingStatus = i;
    }

    public int getPanningDx() {
        return this.panningDx;
    }

    public int getPanningDy() {
        return this.panningDy;
    }

    public int getPanningDz() {
        return this.panningDz;
    }

    public int getTilt() {
        return this.tilt;
    }

    public int getWalkingStatus() {
        return this.walkingStatus;
    }

    public String toString() {
        String str = String.valueOf(Integer.toString(this.motion)) + "=";
        switch (this.motion) {
            case 0:
                str = String.valueOf(str) + "NONE";
                break;
            case 1:
                str = String.valueOf(str) + "TWO_TAPPING";
                break;
            case 2:
                str = String.valueOf(str) + "SNAP_X_POSITIVE";
                break;
            case 3:
                str = String.valueOf(str) + "SNAP_X_NEGATIVE";
                break;
            case 4:
                str = String.valueOf(str) + "SNAP_Y_POSITIVE";
                break;
            case 5:
                str = String.valueOf(str) + "SNAP_Y_NEGATIVE";
                break;
            case 6:
                str = String.valueOf(str) + "SNAP_Z_POSITIVE";
                break;
            case 7:
                str = String.valueOf(str) + "SNAP_Z_NEGATIVE";
                break;
            case 8:
                str = String.valueOf(str) + "SPEAKER_PHONE_ON";
                break;
            case 9:
                str = String.valueOf(str) + "SPEAKER_PHONE_OFF";
                break;
            case 10:
                str = String.valueOf(str) + "FLIP_TOP_TO_BOTTOM";
                break;
            case 11:
                str = String.valueOf(str) + "TILT_PORTRAIT_FRONT";
                break;
            case TILT_PORTRAIT_BACK /* 12 */:
                str = String.valueOf(str) + "TILT_PORTRAIT_BACK";
                break;
            case TILT_PORTRAIT_FRONT_BACK_STOP /* 13 */:
                str = String.valueOf(str) + "TILT_PORTRAIT_FRONT_BACK_STOP";
                break;
            case 14:
                str = String.valueOf(str) + "TILT_PORTRAIT_LEFT";
                break;
            case 15:
                str = String.valueOf(str) + "TILT_PORTRAIT_RIGHT";
                break;
            case 16:
                str = String.valueOf(str) + "TILT_PORTRAIT_LEFT_RIGHT_STOP";
                break;
            case TILT_LANDSCAPE_LEFT_LEVEL_1 /* 17 */:
                str = String.valueOf(str) + "TILT_LANDSCAPE_LEFT_LEVEL_1";
                break;
            case TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                str = String.valueOf(str) + "TILT_LANDSCAPE_LEFT_LEVEL_2";
                break;
            case 19:
                str = String.valueOf(str) + "TILT_LANDSCAPE_RIGHT_LEVEL_1";
                break;
            case TILT_LANDSCAPE_RIGHT_LEVEL_2 /* 20 */:
                str = String.valueOf(str) + "TILT_LANDSCAPE_RIGHT_LEVEL_2";
                break;
            case TILT_LANDSCAPE_LEFT_RIGHT_STOP /* 21 */:
                str = String.valueOf(str) + "TILT_LANDSCAPE_LEFT_RIGHT_STOP";
                break;
            case TILT_FRONT /* 22 */:
                str = String.valueOf(str) + "TILT_FRONT";
                break;
            case TILT_BACK /* 23 */:
                str = String.valueOf(str) + "TILT_BACK";
                break;
            case TILT_FRONT_BACK_END /* 24 */:
                str = String.valueOf(str) + "TILT_FRONT_BACK_END";
                break;
            case TILT_LEFT /* 25 */:
                str = String.valueOf(str) + "TILT_LEFT";
                break;
            case TILT_RIGHT /* 26 */:
                str = String.valueOf(str) + "TILT_RIGHT";
                break;
            case TILT_LEFT_RIGHT_END /* 27 */:
                str = String.valueOf(str) + "TILT_LEFT_RIGHT_END";
                break;
            case ROTATE_0 /* 28 */:
                str = String.valueOf(str) + "ROTATE_0";
                break;
            case ROTATE_90 /* 29 */:
                str = String.valueOf(str) + "ROTATE_90";
                break;
            case ROTATE_180 /* 30 */:
                str = String.valueOf(str) + "ROTATE_180";
                break;
            case ROTATE_270 /* 31 */:
                str = String.valueOf(str) + "ROTATE_270";
                break;
            case 32:
                str = String.valueOf(str) + "ROTATE_START";
                break;
            case ROTATE_STOP /* 33 */:
                str = String.valueOf(str) + "ROTATE_STOP";
                break;
            case SHAKE /* 34 */:
                str = String.valueOf(str) + "SHAKE";
                break;
            case SHAKE_START /* 35 */:
                str = String.valueOf(str) + "SHAKE_START";
                break;
            case SHAKE_STOP /* 36 */:
                str = String.valueOf(str) + "SHAKE_STOP";
                break;
            case SHORT_SHAKE /* 37 */:
                str = String.valueOf(str) + "SHORT_SHAKE";
                break;
            case SHORT_SHAKE_START /* 38 */:
                str = String.valueOf(str) + "SHORT_SHAKE_START";
                break;
            case SHORT_SHAKE_STOP /* 39 */:
                str = String.valueOf(str) + "SHORT_SHAKE_STOP";
                break;
            case BT_SHARING_RECEIVE_READY /* 40 */:
                str = String.valueOf(str) + "BT_SHARING_RECEIVE_READY";
                break;
            case BT_SHARING_RECEIVE_NOT_READY /* 41 */:
                str = String.valueOf(str) + "BT_SHARING_RECEIVE_NOT_READY";
                break;
            case BT_SHARING_SEND_START /* 42 */:
                str = String.valueOf(str) + "BT_SHARING_SEND_START";
                break;
            case BT_SHARING_SEND_PAUSE /* 43 */:
                str = String.valueOf(str) + "BT_SHARING_SEND_PAUSE";
                break;
            case BT_SHARING_SEND_STOP /* 44 */:
                str = String.valueOf(str) + "BT_SHARING_SEND_STOP";
                break;
            case ROTATE_HORIZONTAL /* 45 */:
                str = String.valueOf(str) + "ROTATE_HORIZONTAL";
                break;
            case BOUNCE /* 46 */:
                str = String.valueOf(str) + "BOUNCE";
                break;
            case SNAP1_X_POSITIVE /* 47 */:
                str = String.valueOf(str) + "SNAP1_X_POSITIVE";
                break;
            case SNAP1_X_NEGATIVE /* 48 */:
                str = String.valueOf(str) + "SNAP1_X_NEGATIVE";
                break;
            case SNAP1_Y_POSITIVE /* 49 */:
                str = String.valueOf(str) + "SNAP1_Y_POSITIVE";
                break;
            case SNAP1_Y_NEGATIVE /* 50 */:
                str = String.valueOf(str) + "SNAP1_Y_NEGATIVE";
                break;
            case SNAP1_Z_POSITIVE /* 51 */:
                str = String.valueOf(str) + "SNAP1_Z_POSITIVE";
                break;
            case SNAP1_Z_NEGATIVE /* 52 */:
                str = String.valueOf(str) + "SNAP1_Z_NEGATIVE";
                break;
            case SNAP2_X_POSITIVE /* 53 */:
                str = String.valueOf(str) + "SNAP2_X_POSITIVE";
                break;
            case SNAP2_X_NEGATIVE /* 54 */:
                str = String.valueOf(str) + "SNAP2_X_NEGATIVE";
                break;
            case SNAP2_Y_POSITIVE /* 55 */:
                str = String.valueOf(str) + "SNAP2_Y_POSITIVE";
                break;
            case SNAP2_Y_NEGATIVE /* 56 */:
                str = String.valueOf(str) + "SNAP2_Y_NEGATIVE";
                break;
            case SNAP2_Z_POSITIVE /* 57 */:
                str = String.valueOf(str) + "SNAP2_Z_POSITIVE";
                break;
            case SNAP2_Z_NEGATIVE /* 58 */:
                str = String.valueOf(str) + "SNAP2_Z_NEGATIVE";
                break;
            case SNAP_LEFT /* 59 */:
                str = String.valueOf(str) + "SNAP_LEFT";
                break;
            case SNAP_RIGHT /* 60 */:
                str = String.valueOf(str) + "SNAP_RIGHT";
                break;
            case PANNING_GYRO /* 61 */:
                str = String.valueOf(str) + "PANNING_GYRO";
                break;
            case ONE_TAPPING_GYRO /* 62 */:
                str = String.valueOf(str) + "ONE_TAPPING_GYRO";
                break;
            case TWO_TAPPING_GYRO /* 63 */:
                str = String.valueOf(str) + "TWO_TAPPING_GYRO";
                break;
            case 64:
                str = String.valueOf(str) + "ONE_TIPPING_GYRO";
                break;
            case TWO_TIPPING_GYRO /* 65 */:
                str = String.valueOf(str) + "TWO_TIPPING_GYRO";
                break;
            case BLOW /* 66 */:
                str = String.valueOf(str) + "BLOW";
                break;
            case REACTIVE_ALERT /* 67 */:
                str = String.valueOf(str) + "REACTIVE_ALERT";
                break;
            case DIRECT_CALL /* 68 */:
                str = String.valueOf(str) + "DIRECT_CALL";
                break;
            case LOCK_EXECUTE_APP /* 69 */:
                str = String.valueOf(str) + "LOCK_EXECUTE_APP";
                break;
            case VOLUMEDOWN /* 70 */:
                str = String.valueOf(str) + "VOLUMEDOWN";
                break;
            case FLAT /* 71 */:
                str = String.valueOf(str) + "FLAT";
                break;
            case TILT /* 72 */:
                str = String.valueOf(str) + "TILT";
                break;
            case LOCK_EXECUTE_CAMERA_L /* 73 */:
                str = String.valueOf(str) + "LOCK_EXECUTE_CAMERA_L";
                break;
            case LOCK_EXECUTE_CAMERA_R /* 74 */:
                str = String.valueOf(str) + "LOCK_EXECUTE_CAMERA_R";
                break;
            case TILT_TO_UNLOCK /* 75 */:
                str = String.valueOf(str) + "TILT_TO_UNLOCK";
                break;
            case CALLPOSE_L /* 76 */:
                str = String.valueOf(str) + "CALLPOSE_L";
                break;
            case CALLPOSE_R /* 77 */:
                str = String.valueOf(str) + "CALLPOSE_R";
                break;
            case TILT_UP_LEVEL_1 /* 78 */:
                str = String.valueOf(str) + "TILT_UP_LEVEL_1";
                break;
            case TILT_UP_LEVEL_2 /* 79 */:
                str = String.valueOf(str) + "TILT_UP_LEVEL_2";
                break;
            case TILT_UP_LEVEL_3 /* 80 */:
                str = String.valueOf(str) + "TILT_UP_LEVEL_3";
                break;
            case TILT_DOWN_LEVEL_1 /* 81 */:
                str = String.valueOf(str) + "TILT_DOWN_LEVEL_1";
                break;
            case TILT_DOWN_LEVEL_2 /* 82 */:
                str = String.valueOf(str) + "TILT_DOWN_LEVEL_2";
                break;
            case TILT_DOWN_LEVEL_3 /* 83 */:
                str = String.valueOf(str) + "TILT_DOWN_LEVEL_3";
                break;
            case TILT_LEVEL_ZERO /* 84 */:
                str = String.valueOf(str) + "TILT_LEVEL_ZERO";
                break;
            case TILT_LEVEL_FLAT /* 85 */:
                str = String.valueOf(str) + "TILT_LEVEL_FLAT";
                break;
            case MAX /* 86 */:
                str = String.valueOf(str) + "MAX";
                break;
        }
        String strTrim = str.trim();
        if (this.motion == 61) {
            strTrim = String.valueOf(strTrim) + " (" + this.panningDx + ", " + this.panningDy + ", " + this.panningDz + ")";
        }
        if (this.motion == 72) {
            return String.valueOf(strTrim) + " (" + this.tilt + "), walking status (" + this.walkingStatus + ")";
        }
        return strTrim;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.motion);
        parcel.writeInt(this.panningDx);
        parcel.writeInt(this.panningDy);
        parcel.writeInt(this.panningDz);
        parcel.writeInt(this.tilt);
        parcel.writeInt(this.walkingStatus);
    }

    public void readFromParcel(Parcel parcel) {
        this.motion = parcel.readInt();
        this.panningDx = parcel.readInt();
        this.panningDy = parcel.readInt();
        this.panningDz = parcel.readInt();
        this.tilt = parcel.readInt();
        this.walkingStatus = parcel.readInt();
    }
}
