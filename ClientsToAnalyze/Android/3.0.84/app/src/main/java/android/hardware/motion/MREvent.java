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
    public static final int CALLPOSE_NONE = 100;
    public static final int CALLPOSE_R = 77;
    public static final Parcelable.Creator<MREvent> CREATOR = new 1();
    public static final int DIRECT_CALL = 68;
    public static final int DIRECT_CALL_LEFT = 101;
    public static final int DIRECT_CALL_RIGHT = 102;
    public static final int FLAT = 71;
    public static final int FLIP_BOTTOM_TO_TOP = 86;
    public static final int FLIP_TOP_TO_BOTTOM = 10;
    public static final int LCD_UP_STEADY = 99;
    public static final int LOCK_EXECUTE_APP = 69;
    public static final int LOCK_EXECUTE_CAMERA_L = 73;
    public static final int LOCK_EXECUTE_CAMERA_R = 74;
    public static final int MAX = 113;
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
    public static final int ROTATION_AXIS_X = 94;
    public static final int ROTATION_AXIS_Y = 95;
    public static final int ROTATION_AXIS_Z = 96;
    public static final int SHAKE = 34;
    public static final int SHAKE_START = 35;
    public static final int SHAKE_STOP = 36;
    public static final int SHORT_SHAKE = 37;
    public static final int SHORT_SHAKE_START = 38;
    public static final int SHORT_SHAKE_STOP = 39;
    public static final int SMART_ALERT_SETTING = 98;
    public static final int SMART_SCROLL_CAMERA_OFF = 111;
    public static final int SMART_SCROLL_CAMERA_ON = 112;
    public static final int SMART_SCROLL_TILT_DOWN_START = 104;
    public static final int SMART_SCROLL_TILT_DOWN_START_LAND = 108;
    public static final int SMART_SCROLL_TILT_FACE_IN_STOP = 105;
    public static final int SMART_SCROLL_TILT_FACE_IN_STOP_LAND = 109;
    public static final int SMART_SCROLL_TILT_FACE_OUT_STOP = 106;
    public static final int SMART_SCROLL_TILT_FACE_OUT_STOP_LAND = 110;
    public static final int SMART_SCROLL_TILT_UP_START = 103;
    public static final int SMART_SCROLL_TILT_UP_START_LAND = 107;
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
    public static final int TILT_DOWN_LEVEL_1_LAND = 90;
    public static final int TILT_DOWN_LEVEL_2 = 82;
    public static final int TILT_DOWN_LEVEL_2_LAND = 91;
    public static final int TILT_DOWN_LEVEL_3 = 83;
    public static final int TILT_DOWN_LEVEL_3_LAND = 92;
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
    public static final int TILT_LEVEL_ZERO_LAND = 93;
    public static final int TILT_PORTRAIT_BACK = 12;
    public static final int TILT_PORTRAIT_FRONT = 11;
    public static final int TILT_PORTRAIT_FRONT_BACK_STOP = 13;
    public static final int TILT_PORTRAIT_LEFT = 14;
    public static final int TILT_PORTRAIT_LEFT_RIGHT_STOP = 16;
    public static final int TILT_PORTRAIT_RIGHT = 15;
    public static final int TILT_RIGHT = 26;
    public static final int TILT_TO_UNLOCK = 75;
    public static final int TILT_TO_UNLOCK_LAND = 97;
    public static final int TILT_UP_LEVEL_1 = 78;
    public static final int TILT_UP_LEVEL_1_LAND = 87;
    public static final int TILT_UP_LEVEL_2 = 79;
    public static final int TILT_UP_LEVEL_2_LAND = 88;
    public static final int TILT_UP_LEVEL_3 = 80;
    public static final int TILT_UP_LEVEL_3_LAND = 89;
    public static final int TWO_TAPPING = 1;
    public static final int TWO_TAPPING_GYRO = 63;
    public static final int TWO_TIPPING_GYRO = 65;
    public static final int VOLUMEDOWN = 70;
    private int motion;
    private int panningDx;
    private int panningDxImage;
    private int panningDy;
    private int panningDyImage;
    private int panningDz;
    private int panningDzImage;
    private int tilt;
    private int walkingStatus;

    public MREvent() {
        this.motion = 0;
        this.panningDx = 0;
        this.panningDy = 0;
        this.panningDz = 0;
        this.panningDxImage = 0;
        this.panningDyImage = 0;
        this.panningDzImage = 0;
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
        if (i >= 0 && i <= 113) {
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

    public int getSmartMotion() {
        return this.panningDz;
    }

    public int getTilt() {
        return this.tilt;
    }

    public int getWalkingStatus() {
        return this.walkingStatus;
    }

    public void setPanningDxImage(int i) {
        this.panningDxImage = i;
    }

    public void setPanningDyImage(int i) {
        this.panningDyImage = i;
    }

    public void setPanningDzImage(int i) {
        this.panningDzImage = i;
    }

    public int getPanningDxImage() {
        return this.panningDxImage;
    }

    public int getPanningDyImage() {
        return this.panningDyImage;
    }

    public int getPanningDzImage() {
        return this.panningDzImage;
    }

    public String toString() {
        String str = Integer.toString(this.motion) + "=";
        switch (this.motion) {
            case 0:
                str = str + "NONE";
                break;
            case 1:
                str = str + "TWO_TAPPING";
                break;
            case 2:
                str = str + "SNAP_X_POSITIVE";
                break;
            case 3:
                str = str + "SNAP_X_NEGATIVE";
                break;
            case 4:
                str = str + "SNAP_Y_POSITIVE";
                break;
            case 5:
                str = str + "SNAP_Y_NEGATIVE";
                break;
            case 6:
                str = str + "SNAP_Z_POSITIVE";
                break;
            case 7:
                str = str + "SNAP_Z_NEGATIVE";
                break;
            case 8:
                str = str + "SPEAKER_PHONE_ON";
                break;
            case 9:
                str = str + "SPEAKER_PHONE_OFF";
                break;
            case 10:
                str = str + "FLIP_TOP_TO_BOTTOM";
                break;
            case 11:
                str = str + "TILT_PORTRAIT_FRONT";
                break;
            case 12:
                str = str + "TILT_PORTRAIT_BACK";
                break;
            case 13:
                str = str + "TILT_PORTRAIT_FRONT_BACK_STOP";
                break;
            case 14:
                str = str + "TILT_PORTRAIT_LEFT";
                break;
            case 15:
                str = str + "TILT_PORTRAIT_RIGHT";
                break;
            case 16:
                str = str + "TILT_PORTRAIT_LEFT_RIGHT_STOP";
                break;
            case 17:
                str = str + "TILT_LANDSCAPE_LEFT_LEVEL_1";
                break;
            case 18:
                str = str + "TILT_LANDSCAPE_LEFT_LEVEL_2";
                break;
            case 19:
                str = str + "TILT_LANDSCAPE_RIGHT_LEVEL_1";
                break;
            case 20:
                str = str + "TILT_LANDSCAPE_RIGHT_LEVEL_2";
                break;
            case 21:
                str = str + "TILT_LANDSCAPE_LEFT_RIGHT_STOP";
                break;
            case 22:
                str = str + "TILT_FRONT";
                break;
            case 23:
                str = str + "TILT_BACK";
                break;
            case 24:
                str = str + "TILT_FRONT_BACK_END";
                break;
            case 25:
                str = str + "TILT_LEFT";
                break;
            case 26:
                str = str + "TILT_RIGHT";
                break;
            case 27:
                str = str + "TILT_LEFT_RIGHT_END";
                break;
            case 28:
                str = str + "ROTATE_0";
                break;
            case 29:
                str = str + "ROTATE_90";
                break;
            case 30:
                str = str + "ROTATE_180";
                break;
            case 31:
                str = str + "ROTATE_270";
                break;
            case 32:
                str = str + "ROTATE_START";
                break;
            case 33:
                str = str + "ROTATE_STOP";
                break;
            case 34:
                str = str + "SHAKE";
                break;
            case 35:
                str = str + "SHAKE_START";
                break;
            case 36:
                str = str + "SHAKE_STOP";
                break;
            case 37:
                str = str + "SHORT_SHAKE";
                break;
            case 38:
                str = str + "SHORT_SHAKE_START";
                break;
            case 39:
                str = str + "SHORT_SHAKE_STOP";
                break;
            case 40:
                str = str + "BT_SHARING_RECEIVE_READY";
                break;
            case 41:
                str = str + "BT_SHARING_RECEIVE_NOT_READY";
                break;
            case 42:
                str = str + "BT_SHARING_SEND_START";
                break;
            case 43:
                str = str + "BT_SHARING_SEND_PAUSE";
                break;
            case 44:
                str = str + "BT_SHARING_SEND_STOP";
                break;
            case 45:
                str = str + "ROTATE_HORIZONTAL";
                break;
            case 46:
                str = str + "BOUNCE";
                break;
            case 47:
                str = str + "SNAP1_X_POSITIVE";
                break;
            case 48:
                str = str + "SNAP1_X_NEGATIVE";
                break;
            case 49:
                str = str + "SNAP1_Y_POSITIVE";
                break;
            case 50:
                str = str + "SNAP1_Y_NEGATIVE";
                break;
            case 51:
                str = str + "SNAP1_Z_POSITIVE";
                break;
            case 52:
                str = str + "SNAP1_Z_NEGATIVE";
                break;
            case 53:
                str = str + "SNAP2_X_POSITIVE";
                break;
            case 54:
                str = str + "SNAP2_X_NEGATIVE";
                break;
            case 55:
                str = str + "SNAP2_Y_POSITIVE";
                break;
            case 56:
                str = str + "SNAP2_Y_NEGATIVE";
                break;
            case 57:
                str = str + "SNAP2_Z_POSITIVE";
                break;
            case 58:
                str = str + "SNAP2_Z_NEGATIVE";
                break;
            case 59:
                str = str + "SNAP_LEFT";
                break;
            case 60:
                str = str + "SNAP_RIGHT";
                break;
            case 61:
                str = str + "PANNING_GYRO";
                break;
            case 62:
                str = str + "ONE_TAPPING_GYRO";
                break;
            case 63:
                str = str + "TWO_TAPPING_GYRO";
                break;
            case 64:
                str = str + "ONE_TIPPING_GYRO";
                break;
            case 65:
                str = str + "TWO_TIPPING_GYRO";
                break;
            case 66:
                str = str + "BLOW";
                break;
            case 67:
                str = str + "REACTIVE_ALERT";
                break;
            case 68:
                str = str + "DIRECT_CALL";
                break;
            case 69:
                str = str + "LOCK_EXECUTE_APP";
                break;
            case 70:
                str = str + "VOLUMEDOWN";
                break;
            case 71:
                str = str + "FLAT";
                break;
            case 72:
                str = str + "TILT";
                break;
            case 73:
                str = str + "LOCK_EXECUTE_CAMERA_L";
                break;
            case 74:
                str = str + "LOCK_EXECUTE_CAMERA_R";
                break;
            case 75:
                str = str + "TILT_TO_UNLOCK";
                break;
            case 76:
                str = str + "CALLPOSE_L";
                break;
            case 77:
                str = str + "CALLPOSE_R";
                break;
            case 78:
                str = str + "TILT_UP_LEVEL_1";
                break;
            case 79:
                str = str + "TILT_UP_LEVEL_2";
                break;
            case 80:
                str = str + "TILT_UP_LEVEL_3";
                break;
            case 81:
                str = str + "TILT_DOWN_LEVEL_1";
                break;
            case 82:
                str = str + "TILT_DOWN_LEVEL_2";
                break;
            case 83:
                str = str + "TILT_DOWN_LEVEL_3";
                break;
            case 84:
                str = str + "TILT_LEVEL_ZERO";
                break;
            case 85:
                str = str + "TILT_LEVEL_FLAT";
                break;
            case 86:
                str = str + "FLIP_BOTTOM_TO_TOP";
                break;
            case 87:
                str = str + "TILT_UP_LEVEL_1_LAND";
                break;
            case 88:
                str = str + "TILT_UP_LEVEL_2_LAND";
                break;
            case 89:
                str = str + "TILT_UP_LEVEL_3_LAND";
                break;
            case 90:
                str = str + "TILT_DOWN_LEVEL_1_LAND";
                break;
            case 91:
                str = str + "TILT_DOWN_LEVEL_2_LAND";
                break;
            case 92:
                str = str + "TILT_DOWN_LEVEL_3_LAND";
                break;
            case 93:
                str = str + "TILT_LEVEL_ZERO_LAND";
                break;
            case 97:
                str = str + "TILT_TO_UNLOCK_LAND";
                break;
            case 98:
                str = str + "SMART_ALERT_SETTING";
                break;
            case 99:
                str = str + "LCD_UP_STEADY";
                break;
            case 100:
                str = str + "CALLPOSE_NONE";
                break;
            case 101:
                str = str + "DIRECT_CALL_LEFT";
                break;
            case 102:
                str = str + "DIRECT_CALL_RIGHT";
                break;
            case 103:
                str = str + "SMART_SCROLL_TILT_UP_START";
                break;
            case 104:
                str = str + "SMART_SCROLL_TILT_DOWN_START";
                break;
            case 105:
                str = str + "SMART_SCROLL_TILT_FACE_IN_STOP";
                break;
            case 106:
                str = str + "SMART_SCROLL_TILT_FACE_OUT_STOP";
                break;
            case 107:
                str = str + "SMART_SCROLL_TILT_UP_START_LAND";
                break;
            case 108:
                str = str + "SMART_SCROLL_TILT_DOWN_START_LAND";
                break;
            case 109:
                str = str + "SMART_SCROLL_TILT_FACE_IN_STOP_LAND";
                break;
            case 110:
                str = str + "SMART_SCROLL_TILT_FACE_OUT_STOP_LAND";
                break;
            case 111:
                str = str + "SMART_SCROLL_CAMERA_OFF";
                break;
            case 112:
                str = str + "SMART_SCROLL_CAMERA_ON";
                break;
            case 113:
                str = str + "MAX";
                break;
        }
        String strTrim = str.trim();
        if (this.motion == 61) {
            strTrim = strTrim + " (" + this.panningDx + ", " + this.panningDy + ", " + this.panningDz + ")";
        }
        if (this.motion == 72) {
            return strTrim + " (" + this.tilt + "), walking status (" + this.walkingStatus + ")";
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
        parcel.writeInt(this.panningDxImage);
        parcel.writeInt(this.panningDyImage);
        parcel.writeInt(this.panningDzImage);
        parcel.writeInt(this.tilt);
        parcel.writeInt(this.walkingStatus);
    }

    public void readFromParcel(Parcel parcel) {
        this.motion = parcel.readInt();
        this.panningDx = parcel.readInt();
        this.panningDy = parcel.readInt();
        this.panningDz = parcel.readInt();
        this.panningDxImage = parcel.readInt();
        this.panningDyImage = parcel.readInt();
        this.panningDzImage = parcel.readInt();
        this.tilt = parcel.readInt();
        this.walkingStatus = parcel.readInt();
    }
}
