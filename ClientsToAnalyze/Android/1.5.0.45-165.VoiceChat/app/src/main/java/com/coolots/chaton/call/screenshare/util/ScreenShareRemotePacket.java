package com.coolots.chaton.call.screenshare.util;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public class ScreenShareRemotePacket {
    public static final int SCREENSHARE_REMOTE_KEY = 1;
    public static final int SCREENSHARE_REMOTE_TOUCH = 2;
    private static ScreenShareScale mScreenScale;
    private int mAction;
    private long mEventTime;
    private int mKeycode;
    private int mMetaState;
    private int mPointCount;
    private MotionEvent.PointerCoords[] mPointerCoords;
    private MotionEvent.PointerProperties[] mPointerProperties;
    public int mType;

    public int getType() {
        return this.mType;
    }

    public int getKeycode() {
        return this.mKeycode;
    }

    public int getAction() {
        return this.mAction;
    }

    public long getEventTime() {
        return this.mEventTime;
    }

    public int getMetaState() {
        return this.mMetaState;
    }

    public MotionEvent.PointerCoords[] getPointerCoords() {
        return this.mPointerCoords;
    }

    public MotionEvent.PointerProperties[] getPointerProperties() {
        return this.mPointerProperties;
    }

    public int getPointerCount() {
        return this.mPointCount;
    }

    private static void initScaleData() {
        if (mScreenScale == null) {
            mScreenScale = ScreenShareScale.getInstance();
        }
    }

    public static byte[] makeRemoteKey(int keyCode) {
        byte[] packetData = new byte[8];
        byte[] tmpArr = PenWriteNetwork.intToByte(1);
        System.arraycopy(tmpArr, 0, packetData, 0, 4);
        byte[] tmpArr2 = PenWriteNetwork.intToByte(keyCode);
        System.arraycopy(tmpArr2, 0, packetData, 4, 4);
        return packetData;
    }

    public static byte[] makeRemoteTouch(int Action, long eventTime, int PointCount, MotionEvent.PointerProperties[] PointerProperties, MotionEvent.PointerCoords[] PointerCoords, int metaState) {
        initScaleData();
        byte[] packetData = new byte[(PointCount * 8) + 20 + (PointCount * 36) + 4];
        byte[] tmpArr = PenWriteNetwork.intToByte(2);
        System.arraycopy(tmpArr, 0, packetData, 0, 4);
        int pos = 0 + 4;
        byte[] tmpArr2 = PenWriteNetwork.intToByte(Action);
        System.arraycopy(tmpArr2, 0, packetData, pos, 4);
        int pos2 = pos + 4;
        byte[] tmpArr3 = PenWriteNetwork.longToByte(eventTime);
        System.arraycopy(tmpArr3, 0, packetData, pos2, 8);
        int pos3 = pos2 + 8;
        byte[] tmpArr4 = PenWriteNetwork.intToByte(PointCount);
        System.arraycopy(tmpArr4, 0, packetData, pos3, 4);
        int pos4 = pos3 + 4;
        for (int i = 0; i < PointCount; i++) {
            byte[] tmpArr5 = PenWriteNetwork.intToByte(PointerProperties[i].id);
            System.arraycopy(tmpArr5, 0, packetData, pos4, 4);
            int pos5 = pos4 + 4;
            byte[] tmpArr6 = PenWriteNetwork.intToByte(PointerProperties[i].toolType);
            System.arraycopy(tmpArr6, 0, packetData, pos5, 4);
            pos4 = pos5 + 4;
        }
        for (int i2 = 0; i2 < PointCount; i2++) {
            byte[] tmpArr7 = PenWriteNetwork.floatToByte(PointerCoords[i2].orientation);
            System.arraycopy(tmpArr7, 0, packetData, pos4, 4);
            int pos6 = pos4 + 4;
            byte[] tmpArr8 = PenWriteNetwork.floatToByte(PointerCoords[i2].pressure);
            System.arraycopy(tmpArr8, 0, packetData, pos6, 4);
            int pos7 = pos6 + 4;
            byte[] tmpArr9 = PenWriteNetwork.floatToByte(PointerCoords[i2].size);
            System.arraycopy(tmpArr9, 0, packetData, pos7, 4);
            int pos8 = pos7 + 4;
            byte[] tmpArr10 = PenWriteNetwork.floatToByte(PointerCoords[i2].toolMajor);
            System.arraycopy(tmpArr10, 0, packetData, pos8, 4);
            int pos9 = pos8 + 4;
            byte[] tmpArr11 = PenWriteNetwork.floatToByte(PointerCoords[i2].toolMinor);
            System.arraycopy(tmpArr11, 0, packetData, pos9, 4);
            int pos10 = pos9 + 4;
            byte[] tmpArr12 = PenWriteNetwork.floatToByte(PointerCoords[i2].touchMajor);
            System.arraycopy(tmpArr12, 0, packetData, pos10, 4);
            int pos11 = pos10 + 4;
            byte[] tmpArr13 = PenWriteNetwork.floatToByte(PointerCoords[i2].touchMinor);
            System.arraycopy(tmpArr13, 0, packetData, pos11, 4);
            int pos12 = pos11 + 4;
            byte[] tmpArr14 = PenWriteNetwork.floatToByte(mScreenScale.modifyExpandScaleX(PointerCoords[i2].x));
            System.arraycopy(tmpArr14, 0, packetData, pos12, 4);
            int pos13 = pos12 + 4;
            byte[] tmpArr15 = PenWriteNetwork.floatToByte(mScreenScale.modifyExpandScaleY(PointerCoords[i2].y));
            System.arraycopy(tmpArr15, 0, packetData, pos13, 4);
            pos4 = pos13 + 4;
        }
        byte[] tmpArr16 = PenWriteNetwork.intToByte(metaState);
        System.arraycopy(tmpArr16, 0, packetData, pos4, 4);
        int i3 = pos4 + 4;
        return packetData;
    }

    public static ScreenShareRemotePacket parserRemoteTouch(byte[] packetData) {
        initScaleData();
        byte[] tmpArr8 = new byte[8];
        byte[] tmpArr = new byte[4];
        ScreenShareRemotePacket screenShareRemotePacket = new ScreenShareRemotePacket();
        System.arraycopy(packetData, 0, tmpArr, 0, 4);
        screenShareRemotePacket.mType = PenWriteNetwork.byteToInt(tmpArr);
        if (screenShareRemotePacket.mType == 2) {
            int pos = 0 + 4;
            System.arraycopy(packetData, pos, tmpArr, 0, 4);
            screenShareRemotePacket.mAction = PenWriteNetwork.byteToInt(tmpArr);
            int pos2 = pos + 4;
            System.arraycopy(packetData, pos2, tmpArr8, 0, 8);
            screenShareRemotePacket.mEventTime = PenWriteNetwork.byteToLong(tmpArr8);
            int pos3 = pos2 + 8;
            System.arraycopy(packetData, pos3, tmpArr, 0, 4);
            screenShareRemotePacket.mPointCount = PenWriteNetwork.byteToInt(tmpArr);
            screenShareRemotePacket.mPointerProperties = new MotionEvent.PointerProperties[screenShareRemotePacket.mPointCount];
            for (int i = 0; i < screenShareRemotePacket.mPointCount; i++) {
                screenShareRemotePacket.mPointerProperties[i] = new MotionEvent.PointerProperties();
                int pos4 = pos3 + 4;
                System.arraycopy(packetData, pos4, tmpArr, 0, 4);
                screenShareRemotePacket.mPointerProperties[i].id = PenWriteNetwork.byteToInt(tmpArr);
                pos3 = pos4 + 4;
                System.arraycopy(packetData, pos3, tmpArr, 0, 4);
                screenShareRemotePacket.mPointerProperties[i].toolType = PenWriteNetwork.byteToInt(tmpArr);
            }
            screenShareRemotePacket.mPointerCoords = new MotionEvent.PointerCoords[screenShareRemotePacket.mPointCount];
            for (int i2 = 0; i2 < screenShareRemotePacket.mPointCount; i2++) {
                screenShareRemotePacket.mPointerCoords[i2] = new MotionEvent.PointerCoords();
                int pos5 = pos3 + 4;
                System.arraycopy(packetData, pos5, tmpArr, 0, 4);
                screenShareRemotePacket.mPointerCoords[i2].orientation = PenWriteNetwork.byteToFloat(tmpArr);
                int pos6 = pos5 + 4;
                System.arraycopy(packetData, pos6, tmpArr, 0, 4);
                screenShareRemotePacket.mPointerCoords[i2].pressure = PenWriteNetwork.byteToFloat(tmpArr);
                int pos7 = pos6 + 4;
                System.arraycopy(packetData, pos7, tmpArr, 0, 4);
                screenShareRemotePacket.mPointerCoords[i2].size = PenWriteNetwork.byteToFloat(tmpArr);
                int pos8 = pos7 + 4;
                System.arraycopy(packetData, pos8, tmpArr, 0, 4);
                screenShareRemotePacket.mPointerCoords[i2].toolMajor = PenWriteNetwork.byteToFloat(tmpArr);
                int pos9 = pos8 + 4;
                System.arraycopy(packetData, pos9, tmpArr, 0, 4);
                screenShareRemotePacket.mPointerCoords[i2].toolMinor = PenWriteNetwork.byteToFloat(tmpArr);
                int pos10 = pos9 + 4;
                System.arraycopy(packetData, pos10, tmpArr, 0, 4);
                screenShareRemotePacket.mPointerCoords[i2].touchMajor = PenWriteNetwork.byteToFloat(tmpArr);
                int pos11 = pos10 + 4;
                System.arraycopy(packetData, pos11, tmpArr, 0, 4);
                screenShareRemotePacket.mPointerCoords[i2].touchMinor = PenWriteNetwork.byteToFloat(tmpArr);
                int pos12 = pos11 + 4;
                System.arraycopy(packetData, pos12, tmpArr, 0, 4);
                screenShareRemotePacket.mPointerCoords[i2].x = mScreenScale.modifyScaleX(PenWriteNetwork.byteToFloat(tmpArr));
                pos3 = pos12 + 4;
                System.arraycopy(packetData, pos3, tmpArr, 0, 4);
                screenShareRemotePacket.mPointerCoords[i2].y = mScreenScale.modifyScaleY(PenWriteNetwork.byteToFloat(tmpArr));
            }
            System.arraycopy(packetData, pos3 + 4, tmpArr, 0, 4);
            screenShareRemotePacket.mMetaState = PenWriteNetwork.byteToInt(tmpArr);
            return screenShareRemotePacket;
        }
        if (screenShareRemotePacket.mType == 1) {
            System.arraycopy(packetData, 0 + 4, tmpArr, 0, 4);
            screenShareRemotePacket.mKeycode = PenWriteNetwork.byteToInt(tmpArr);
            return screenShareRemotePacket;
        }
        return null;
    }
}
