package com.coolots.chaton.call.screenshare.util;

import android.graphics.Matrix;
import android.graphics.Point;
import android.view.MotionEvent;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.screenshare.ScreenShareProc;
import com.nuance.nmsp.client.sdk.common.protocols.ProtocolDefines;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.ShareScreenInterface;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.ShareScreenCallback;
import com.sds.coolots.common.util.Log;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* loaded from: classes.dex */
public class PenWriteNetwork {
    private static final String CLASSNAME = "[PenWriteNetwork]";
    private OnRecvDataCB mOnCallback;
    private Queue<byte[]> mSendQ = new LinkedList();
    private int mSendQTotal = 0;
    private int mSleepTime = 100;
    private int mFullCnt = 1200;
    private Thread sendTr = null;
    private Boolean sendTrRun = false;
    private long mEndMilli = 0;
    private ShareScreenInterface mShareScreenInterface = MainApplication.mPhoneManager.getShareScreenManager();
    private Destination mDestination = this.mShareScreenInterface.getCurrentCallDestination();

    public interface OnRecvDataCB {
        void onCallNotifyNetworkWeakReceive(int i);

        void onPause(int i);

        void onRecvData(byte[] bArr, int i);

        void onResultCaptureImage(int i);

        void onResume(Point point, boolean z);

        void onSecureErrorForShareScreen();

        void onSecureModeEndForShareScreen();

        void onStart(int i, int i2, String str);

        void onStop(int i);
    }

    public static class shareSAMMMatrixData {
        public int MultiUserID;
        public Matrix matrixData;
    }

    public static class shareSAMMScreenSize {
        public int MultiUserID;
        public int screenHeight;
        public int screenWidth;
    }

    public static class shareSAMMStrokePoint {
        public int Action;
        public int MultiStrokeID;
        public int MultiUserID;
        public long downtime;
        public long eventtime;
        public float pressure;
        public int sammMetaState;

        /* renamed from: x */
        public float f6x;

        /* renamed from: y */
        public float f7y;
    }

    public static class shareSAMMTextData {
        public int MultiUserID;
        public String strFont;
        public String strText;
        public int textColor;
        public int textID;
        public float textRectBottom;
        public float textRectLeft;
        public float textRectRight;
        public float textRectTop;
        public float textSize;
        public int textStyle;
    }

    public static class shareSpenMotionEvent {
        public int action;
        public int buttonstate;
        public int deviceid;
        public long downtime;
        public int edgeflags;
        public long eventtime;
        public int flags;
        public int metastate;
        public int multiStrokeID;
        public int multiUserID;
        public int source;
        public float xprecision;
        public float yprecision;

        /* renamed from: pp */
        public MotionEvent.PointerProperties[] f9pp = new MotionEvent.PointerProperties[1];

        /* renamed from: pc */
        public MotionEvent.PointerCoords[] f8pc = new MotionEvent.PointerCoords[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public void finalize() {
        stop();
    }

    public void setOnRecvDataCB(OnRecvDataCB cb) {
        this.mOnCallback = cb;
    }

    public PenWriteNetwork() {
        this.mShareScreenInterface.setShareScreenCallback(this.mDestination, new ShareScreenCallback() { // from class: com.coolots.chaton.call.screenshare.util.PenWriteNetwork.1
            @Override // com.sds.coolots.call.model.ShareScreenCallback
            public void onConferenceMemberUpdate(List arg0) {
            }

            @Override // com.sds.coolots.call.model.ShareScreenCallback
            public void onReceiveBoardData(String arg0, int arg1, byte[] recvedData) {
                int start = 0;
                int totalLen = recvedData.length;
                while (totalLen - start > 0) {
                    byte[] intData = new byte[4];
                    System.arraycopy(recvedData, start, intData, 0, 4);
                    int length = PenWriteNetwork.byteToInt(intData);
                    byte[] recvData = new byte[length];
                    System.arraycopy(recvedData, start + 4, recvData, 0, length);
                    if (PenWriteNetwork.this.mOnCallback != null) {
                        PenWriteNetwork.this.mOnCallback.onRecvData(recvData, recvData.length);
                    }
                    start += length + 4;
                }
            }

            @Override // com.sds.coolots.call.model.ShareScreenCallback
            public void onResumeShareScreen(Point point, boolean mode) {
                PenWriteNetwork.this.logI("setShareScreenCallback onResumeShareScreen ");
                if (PenWriteNetwork.this.mOnCallback != null) {
                    PenWriteNetwork.this.mOnCallback.onResume(point, mode);
                }
            }

            @Override // com.sds.coolots.call.model.ShareScreenCallback
            public void onStartShareScreen(int arg0, int arg1, String arg2, boolean isLiveShare) {
                PenWriteNetwork.this.logI("onStartShareScreen userid" + arg2);
                if (PenWriteNetwork.this.mOnCallback != null) {
                    PenWriteNetwork.this.mOnCallback.onStart(arg0, arg1, arg2);
                }
            }

            @Override // com.sds.coolots.call.model.ShareScreenCallback
            public void onStopShareScreen(int arg0) {
                PenWriteNetwork.this.logI("setShareScreenCallback onStopShareScreen " + arg0);
                if (PenWriteNetwork.this.mOnCallback != null) {
                    PenWriteNetwork.this.mOnCallback.onStop(arg0);
                }
            }

            @Override // com.sds.coolots.call.model.ShareScreenCallback
            public void onPauseShareScreen(int arg0) {
                PenWriteNetwork.this.logI("setShareScreenCallback onPauseShareScreen " + arg0);
                if (PenWriteNetwork.this.mOnCallback != null) {
                    PenWriteNetwork.this.mOnCallback.onPause(1);
                }
            }

            @Override // com.sds.coolots.call.model.ShareScreenCallback
            public void onCallHoldState(boolean arg0) {
                if (arg0) {
                    PenWriteNetwork.this.logI("onCallHoldState - Pause");
                    if (PenWriteNetwork.this.mOnCallback != null) {
                        PenWriteNetwork.this.mOnCallback.onPause(2);
                    }
                    MainApplication.mPhoneManager.getShareScreenManager().pauseShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), 0);
                    return;
                }
                PenWriteNetwork.this.logI("onCallHoldState - Resume");
                MainApplication.mPhoneManager.getShareScreenManager().resumeShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), null, false);
            }

            @Override // com.sds.coolots.call.model.ShareScreenCallback
            public void onCallState(int arg0) {
                PenWriteNetwork.this.logI("setShareScreenCallback onCallState " + arg0);
            }

            @Override // com.sds.coolots.call.model.ShareScreenCallback
            public void onResultCaptureImage(int arg0) {
                PenWriteNetwork.this.logI("PenWritingCapture CaptureImage Result : " + arg0);
                if (PenWriteNetwork.this.mOnCallback != null) {
                    PenWriteNetwork.this.mOnCallback.onResultCaptureImage(arg0);
                }
                if (arg0 == 7231) {
                    PenWriteNetwork.this.logI("PenWritingCapture is Success in Service");
                } else if (arg0 == 7232) {
                    PenWriteNetwork.this.logI("PenWritingCapture is Fail in Service");
                    ScreenShareProc.showToast(C0000R.string.screenshare_pen_writing_capture_fail, 0);
                }
            }

            @Override // com.sds.coolots.call.model.ShareScreenCallback
            public void onSecureErrorForShareScreen() {
                PenWriteNetwork.this.logI("onSecureErrorForShareScreen");
                if (PenWriteNetwork.this.mOnCallback != null) {
                    PenWriteNetwork.this.mOnCallback.onSecureErrorForShareScreen();
                }
            }

            @Override // com.sds.coolots.call.model.ShareScreenCallback
            public void onSecureModeEndForShareScreen() {
                PenWriteNetwork.this.logI("onSecureModeEndForShareScreen");
                if (PenWriteNetwork.this.mOnCallback != null) {
                    PenWriteNetwork.this.mOnCallback.onSecureModeEndForShareScreen();
                }
            }

            @Override // com.sds.coolots.call.model.ShareScreenCallback
            public void onCallNotifyNetworkWeakReceive(int bandWidth) {
                if (PenWriteNetwork.this.mOnCallback != null) {
                    PenWriteNetwork.this.mOnCallback.onCallNotifyNetworkWeakReceive(bandWidth);
                }
            }
        });
        startSendThread();
    }

    public void sendData(byte[] SendData) {
        ScreenSharePacket ssp = ScreenSharePacket.parserPacket(SendData);
        int comm = ssp.getCommand();
        byte type = ssp.getCommandType();
        if (type == 1) {
            sendWriteData(comm, SendData);
        } else {
            logI("REMOTEDATAGET is delayed to sending");
            sendWriteData(comm, SendData);
        }
    }

    public void sendWriteData(int comm, byte[] SendData) {
        byte[] sharSendData = new byte[SendData.length + 4];
        byte[] dataLen = intToByte(SendData.length);
        System.arraycopy(dataLen, 0, sharSendData, 0, 4);
        System.arraycopy(SendData, 0, sharSendData, 4, SendData.length);
        switch (comm) {
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO /* 203 */:
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO /* 204 */:
                synchronized (this.mSendQ) {
                    this.mSendQ.offer(sharSendData);
                    this.mSendQTotal += sharSendData.length;
                }
                if (this.sendTr != null) {
                    synchronized (this.sendTr) {
                        logI("Wakeup Thread");
                        this.sendTr.notifyAll();
                    }
                    break;
                }
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARALL /* 205 */:
                synchronized (this.mSendQ) {
                    this.mSendQ.clear();
                    this.mSendQTotal = 0;
                }
                sendBoardData(sharSendData.length, sharSendData);
                logI("Send Data Length= " + sharSendData.length + " byte!!");
                break;
            case 500:
                ScreenSharePacket ssp = ScreenSharePacket.parserPacket(SendData);
                ScreenShareRemotePacket ssrp = ScreenShareRemotePacket.parserRemoteTouch(ssp.mCommandData);
                logI("Wakeup Thread  Type=" + ssrp.mType);
                if (ssrp.mType == 2) {
                    synchronized (this.mSendQ) {
                        this.mSendQ.offer(sharSendData);
                        this.mSendQTotal += sharSendData.length;
                    }
                    if (ssrp.getAction() == 1) {
                        logI("Remote Data is Send all for Remote Key up");
                        if (this.sendTr != null) {
                            synchronized (this.sendTr) {
                                this.sendTr.notifyAll();
                            }
                            break;
                        }
                    }
                } else if (ssrp.mType == 1) {
                    synchronized (this.mSendQ) {
                        this.mSendQ.clear();
                        this.mSendQTotal = 0;
                    }
                    sendBoardData(sharSendData.length, sharSendData);
                    logI("Remote Data is Sended immediately for Key Event");
                    break;
                }
                break;
            default:
                synchronized (this.mSendQ) {
                    this.mSendQ.offer(sharSendData);
                    this.mSendQTotal += sharSendData.length;
                    break;
                }
        }
    }

    public void stopSendThread() {
        try {
            if (this.sendTr != null && this.sendTr.isAlive()) {
                synchronized (this.sendTr) {
                    this.sendTrRun = false;
                    this.sendTr.notifyAll();
                }
                while (this.sendTr.isAlive()) {
                }
                this.sendTr = null;
            }
            this.mSendQ.clear();
            this.mSendQTotal = 0;
        } catch (Exception e) {
            Log.m2958e(" exception  stopSendThread ");
            if (this.mSendQ != null) {
                this.mSendQ.clear();
                this.mSendQTotal = 0;
            }
        }
    }

    public void startSendThread() {
        this.sendTrRun = true;
        if (this.sendTr == null) {
            this.sendTr = new Thread(new Runnable() { // from class: com.coolots.chaton.call.screenshare.util.PenWriteNetwork.2
                @Override // java.lang.Runnable
                public void run() {
                    while (PenWriteNetwork.this.sendTrRun.booleanValue()) {
                        long startMilli = System.currentTimeMillis();
                        byte[] sendData = (byte[]) null;
                        int last = 0;
                        if (PenWriteNetwork.this.mSendQTotal != 0) {
                            synchronized (PenWriteNetwork.this.mSendQ) {
                                PenWriteNetwork.this.logI("Send All");
                                sendData = new byte[PenWriteNetwork.this.mSendQTotal];
                                while (!PenWriteNetwork.this.mSendQ.isEmpty()) {
                                    byte[] tmpData = (byte[]) PenWriteNetwork.this.mSendQ.poll();
                                    if (tmpData.length + last >= PenWriteNetwork.this.mFullCnt) {
                                        byte[] srcData = new byte[last];
                                        System.arraycopy(sendData, 0, srcData, 0, last);
                                        PenWriteNetwork.this.sendBoardData(srcData.length, srcData);
                                        PenWriteNetwork.this.logI("Send Data Length= " + srcData.length + " byte!!");
                                        sendData = new byte[PenWriteNetwork.this.mFullCnt];
                                        last = 0;
                                    }
                                    System.arraycopy(tmpData, 0, sendData, last, tmpData.length);
                                    last += tmpData.length;
                                }
                                PenWriteNetwork.this.mSendQTotal = 0;
                            }
                        }
                        int unused = PenWriteNetwork.this.mSleepTime;
                        if (sendData != null) {
                            byte[] srcData2 = new byte[last];
                            System.arraycopy(sendData, 0, srcData2, 0, last);
                            PenWriteNetwork.this.sendBoardData(srcData2.length, srcData2);
                            PenWriteNetwork.this.logI("1 Send Data Length  = " + last + " byte!!");
                        }
                        PenWriteNetwork.this.mEndMilli = System.currentTimeMillis();
                        int sleepMilli = PenWriteNetwork.this.mSleepTime - ((int) (PenWriteNetwork.this.mEndMilli - startMilli));
                        if (sleepMilli > 0) {
                            synchronized (this) {
                                try {
                                    wait(sleepMilli);
                                } catch (InterruptedException e) {
                                }
                            }
                        }
                    }
                    PenWriteNetwork.this.logI("data Send Thread is Stopped!!");
                }
            });
        }
        this.sendTr.start();
    }

    public static byte[] intToByte(int value) {
        byte[] bytes = {(byte) (((-16777216) & value) >> 24), (byte) ((16711680 & value) >> 16), (byte) ((65280 & value) >> 8), (byte) (value & 255)};
        return bytes;
    }

    public static int byteToInt(byte[] src) {
        int newValue = 0 | ((src[0] << 24) & (-16777216));
        return newValue | ((src[1] << ProtocolDefines.XMODE_SERVER_SESSION_UUID_SIZE) & 16711680) | ((src[2] << 8) & 65280) | (src[3] & 255);
    }

    public static byte[] floatToByte(float value) {
        int intBits = Float.floatToIntBits(value);
        byte[] array = {(byte) ((intBits & 255) >> 0), (byte) ((65280 & intBits) >> 8), (byte) ((16711680 & intBits) >> 16), (byte) (((-16777216) & intBits) >> 24)};
        return array;
    }

    public static float byteToFloat(byte[] aBytes) {
        int accum = 0;
        int i = 0;
        for (int shiftBy = 0; shiftBy < 32; shiftBy += 8) {
            accum = (int) (accum | ((aBytes[i] & 255) << shiftBy));
            i++;
        }
        float ff = Float.intBitsToFloat(accum);
        return ff;
    }

    public static byte[] longToByte(long data) {
        byte[] result = new byte[8];
        for (int i = 0; i < 8; i++) {
            result[i] = (byte) ((data >> (56 - (i * 8))) & 255);
        }
        return result;
    }

    public static long byteToLong(byte[] data) {
        if (data == null || data.length != 8) {
            return 0L;
        }
        long result = 0;
        for (int i = 0; i < 8; i++) {
            result |= (data[i] & 255) << (56 - (i * 8));
        }
        return result;
    }

    public static int byteToShort(byte[] bytes) {
        int newValue = 0 | ((bytes[0] << 8) & 65280);
        return newValue | (bytes[1] & 255);
    }

    public static byte[] shortToByte(short shortVar) {
        byte[] littleShort = {(byte) ((shortVar >> 0) & 255), (byte) ((shortVar >> 8) & 255)};
        return littleShort;
    }

    public static byte[] matrixToByte(Matrix matrix) {
        byte[] array = new byte[36];
        float[] matrixVal = new float[9];
        byte[] bArr = new byte[4];
        matrix.getValues(matrixVal);
        for (int i = 0; i < 9; i++) {
            byte[] tmpArr = floatToByte(matrixVal[i]);
            System.arraycopy(tmpArr, 0, array, i * 4, 4);
        }
        return array;
    }

    public static Matrix byteToMatrix(byte[] matrixData) {
        Matrix matrix = new Matrix();
        float[] matrixArr = new float[9];
        byte[] tmpArr = new byte[4];
        for (int i = 0; i < 9; i++) {
            System.arraycopy(matrixData, i * 4, tmpArr, 0, 4);
            matrixArr[i] = byteToFloat(tmpArr);
        }
        matrix.setValues(matrixArr);
        return matrix;
    }

    public static byte[] makeSAMMStrokePoint(int multiUserID, int multiStrokeID, int action, float x, float y, float pressure, int sammMetaState, long downtime, long eventtime) {
        byte[] array = new byte[44];
        byte[] tmpArr = intToByte(multiUserID);
        System.arraycopy(tmpArr, 0, array, 0, 4);
        int pos = 0 + 4;
        byte[] tmpArr2 = intToByte(multiStrokeID);
        System.arraycopy(tmpArr2, 0, array, pos, 4);
        int pos2 = pos + 4;
        byte[] tmpArr3 = intToByte(action);
        System.arraycopy(tmpArr3, 0, array, pos2, 4);
        int pos3 = pos2 + 4;
        byte[] tmpArr4 = floatToByte(x);
        System.arraycopy(tmpArr4, 0, array, pos3, 4);
        int pos4 = pos3 + 4;
        byte[] tmpArr5 = floatToByte(y);
        System.arraycopy(tmpArr5, 0, array, pos4, 4);
        int pos5 = pos4 + 4;
        byte[] tmpArr6 = floatToByte(pressure);
        System.arraycopy(tmpArr6, 0, array, pos5, 4);
        int pos6 = pos5 + 4;
        byte[] tmpArr7 = intToByte(sammMetaState);
        System.arraycopy(tmpArr7, 0, array, pos6, 4);
        int pos7 = pos6 + 4;
        byte[] tmpArr8 = longToByte(downtime);
        System.arraycopy(tmpArr8, 0, array, pos7, 8);
        byte[] tmpArr9 = longToByte(eventtime);
        System.arraycopy(tmpArr9, 0, array, pos7 + 8, 8);
        return array;
    }

    public static byte[] makeSpenMotionEvent(int multiUserID, int multiStrokeID, MotionEvent event) {
        byte[] array = new byte[76];
        byte[] tmpArr = intToByte(multiUserID);
        System.arraycopy(tmpArr, 0, array, 0, 4);
        int pos = 0 + 4;
        byte[] tmpArr2 = intToByte(multiStrokeID);
        System.arraycopy(tmpArr2, 0, array, pos, 4);
        int pos2 = pos + 4;
        byte[] tmpArr3 = longToByte(event.getDownTime());
        System.arraycopy(tmpArr3, 0, array, pos2, 8);
        int pos3 = pos2 + 8;
        byte[] tmpArr4 = longToByte(event.getEventTime() - event.getDownTime());
        System.arraycopy(tmpArr4, 0, array, pos3, 8);
        int pos4 = pos3 + 8;
        byte[] tmpArr5 = intToByte(event.getAction());
        System.arraycopy(tmpArr5, 0, array, pos4, 4);
        int pos5 = pos4 + 4;
        byte[] tmpArr6 = intToByte(event.getToolType(0));
        System.arraycopy(tmpArr6, 0, array, pos5, 4);
        int pos6 = pos5 + 4;
        byte[] tmpArr7 = intToByte(0);
        System.arraycopy(tmpArr7, 0, array, pos6, 4);
        int pos7 = pos6 + 4;
        byte[] tmpArr8 = floatToByte(event.getX(event.getPointerCount() - 1));
        System.arraycopy(tmpArr8, 0, array, pos7, 4);
        int pos8 = pos7 + 4;
        byte[] tmpArr9 = floatToByte(event.getY(event.getPointerCount() - 1));
        System.arraycopy(tmpArr9, 0, array, pos8, 4);
        int pos9 = pos8 + 4;
        byte[] tmpArr10 = intToByte(event.getMetaState());
        System.arraycopy(tmpArr10, 0, array, pos9, 4);
        int pos10 = pos9 + 4;
        byte[] tmpArr11 = intToByte(event.getButtonState());
        System.arraycopy(tmpArr11, 0, array, pos10, 4);
        int pos11 = pos10 + 4;
        byte[] tmpArr12 = floatToByte(event.getXPrecision());
        System.arraycopy(tmpArr12, 0, array, pos11, 4);
        int pos12 = pos11 + 4;
        byte[] tmpArr13 = floatToByte(event.getYPrecision());
        System.arraycopy(tmpArr13, 0, array, pos12, 4);
        int pos13 = pos12 + 4;
        byte[] tmpArr14 = intToByte(event.getDeviceId());
        System.arraycopy(tmpArr14, 0, array, pos13, 4);
        int pos14 = pos13 + 4;
        byte[] tmpArr15 = intToByte(event.getEdgeFlags());
        System.arraycopy(tmpArr15, 0, array, pos14, 4);
        int pos15 = pos14 + 4;
        byte[] tmpArr16 = intToByte(event.getSource());
        System.arraycopy(tmpArr16, 0, array, pos15, 4);
        byte[] tmpArr17 = intToByte(event.getFlags());
        System.arraycopy(tmpArr17, 0, array, pos15 + 4, 4);
        return array;
    }

    public static byte[] makeSAMMTextInput(int multiUserID, int textID, int textColor, int textStyle, float textSize, float textRectLeft, float textRectTop, float textRectRight, float textRectBottom, String strFont, String strText) {
        byte[] fontArr = ScreenSharePacket.makeStringPacket(strFont);
        byte[] textArr = ScreenSharePacket.makeStringPacket(strText);
        byte[] array = new byte[fontArr.length + 36 + textArr.length];
        byte[] tmpArr = intToByte(multiUserID);
        System.arraycopy(tmpArr, 0, array, 0, 4);
        int pos = 0 + 4;
        byte[] tmpArr2 = intToByte(textID);
        System.arraycopy(tmpArr2, 0, array, pos, 4);
        int pos2 = pos + 4;
        byte[] tmpArr3 = intToByte(textColor);
        System.arraycopy(tmpArr3, 0, array, pos2, 4);
        int pos3 = pos2 + 4;
        byte[] tmpArr4 = intToByte(textStyle);
        System.arraycopy(tmpArr4, 0, array, pos3, 4);
        int pos4 = pos3 + 4;
        byte[] tmpArr5 = floatToByte(textSize);
        System.arraycopy(tmpArr5, 0, array, pos4, 4);
        int pos5 = pos4 + 4;
        byte[] tmpArr6 = floatToByte(textRectLeft);
        System.arraycopy(tmpArr6, 0, array, pos5, 4);
        int pos6 = pos5 + 4;
        byte[] tmpArr7 = floatToByte(textRectTop);
        System.arraycopy(tmpArr7, 0, array, pos6, 4);
        int pos7 = pos6 + 4;
        byte[] tmpArr8 = floatToByte(textRectRight);
        System.arraycopy(tmpArr8, 0, array, pos7, 4);
        int pos8 = pos7 + 4;
        byte[] tmpArr9 = floatToByte(textRectBottom);
        System.arraycopy(tmpArr9, 0, array, pos8, 4);
        System.arraycopy(fontArr, 0, array, pos8 + 4, fontArr.length);
        System.arraycopy(textArr, 0, array, fontArr.length + 36, textArr.length);
        return array;
    }

    public static shareSpenMotionEvent parseTransMotionEvent(byte[] pointData) {
        shareSpenMotionEvent spenmotionevent = new shareSpenMotionEvent();
        byte[] tmpArr8 = new byte[8];
        byte[] tmpArr = new byte[4];
        System.arraycopy(pointData, 0, tmpArr, 0, 4);
        spenmotionevent.multiUserID = byteToInt(tmpArr);
        int pos = 0 + 4;
        System.arraycopy(pointData, pos, tmpArr, 0, 4);
        spenmotionevent.multiStrokeID = byteToInt(tmpArr);
        int pos2 = pos + 4;
        System.arraycopy(pointData, pos2, tmpArr8, 0, 8);
        spenmotionevent.downtime = byteToLong(tmpArr8);
        int pos3 = pos2 + 8;
        System.arraycopy(pointData, pos3, tmpArr8, 0, 8);
        spenmotionevent.eventtime = byteToLong(tmpArr8);
        int pos4 = pos3 + 8;
        System.arraycopy(pointData, pos4, tmpArr, 0, 4);
        spenmotionevent.action = byteToInt(tmpArr);
        spenmotionevent.f9pp[0] = new MotionEvent.PointerProperties();
        int pos5 = pos4 + 4;
        System.arraycopy(pointData, pos5, tmpArr, 0, 4);
        spenmotionevent.f9pp[0].toolType = byteToInt(tmpArr);
        int pos6 = pos5 + 4;
        System.arraycopy(pointData, pos6, tmpArr, 0, 4);
        spenmotionevent.f9pp[0].id = byteToInt(tmpArr);
        spenmotionevent.f8pc[0] = new MotionEvent.PointerCoords();
        int pos7 = pos6 + 4;
        System.arraycopy(pointData, pos7, tmpArr, 0, 4);
        spenmotionevent.f8pc[0].x = byteToFloat(tmpArr);
        int pos8 = pos7 + 4;
        System.arraycopy(pointData, pos8, tmpArr, 0, 4);
        spenmotionevent.f8pc[0].y = byteToFloat(tmpArr);
        int pos9 = pos8 + 4;
        System.arraycopy(pointData, pos9, tmpArr, 0, 4);
        spenmotionevent.metastate = byteToInt(tmpArr);
        int pos10 = pos9 + 4;
        System.arraycopy(pointData, pos10, tmpArr, 0, 4);
        spenmotionevent.buttonstate = byteToInt(tmpArr);
        int pos11 = pos10 + 4;
        System.arraycopy(pointData, pos11, tmpArr, 0, 4);
        spenmotionevent.xprecision = byteToFloat(tmpArr);
        int pos12 = pos11 + 4;
        System.arraycopy(pointData, pos12, tmpArr, 0, 4);
        spenmotionevent.yprecision = byteToFloat(tmpArr);
        int pos13 = pos12 + 4;
        System.arraycopy(pointData, pos13, tmpArr, 0, 4);
        spenmotionevent.deviceid = byteToInt(tmpArr);
        int pos14 = pos13 + 4;
        System.arraycopy(pointData, pos14, tmpArr, 0, 4);
        spenmotionevent.edgeflags = byteToInt(tmpArr);
        int pos15 = pos14 + 4;
        System.arraycopy(pointData, pos15, tmpArr, 0, 4);
        spenmotionevent.source = byteToInt(tmpArr);
        System.arraycopy(pointData, pos15 + 4, tmpArr, 0, 4);
        spenmotionevent.flags = byteToInt(tmpArr);
        return spenmotionevent;
    }

    public static shareSAMMStrokePoint parseSAMMStrokePoint(byte[] pointData) {
        shareSAMMStrokePoint pointInfo = new shareSAMMStrokePoint();
        byte[] tmpArr8 = new byte[8];
        byte[] tmpArr = new byte[4];
        System.arraycopy(pointData, 0, tmpArr, 0, 4);
        pointInfo.MultiUserID = byteToInt(tmpArr);
        int pos = 0 + 4;
        System.arraycopy(pointData, pos, tmpArr, 0, 4);
        pointInfo.MultiStrokeID = byteToInt(tmpArr);
        int pos2 = pos + 4;
        System.arraycopy(pointData, pos2, tmpArr, 0, 4);
        pointInfo.Action = byteToInt(tmpArr);
        int pos3 = pos2 + 4;
        System.arraycopy(pointData, pos3, tmpArr, 0, 4);
        pointInfo.f6x = byteToFloat(tmpArr);
        int pos4 = pos3 + 4;
        System.arraycopy(pointData, pos4, tmpArr, 0, 4);
        pointInfo.f7y = byteToFloat(tmpArr);
        int pos5 = pos4 + 4;
        System.arraycopy(pointData, pos5, tmpArr, 0, 4);
        pointInfo.pressure = byteToFloat(tmpArr);
        int pos6 = pos5 + 4;
        System.arraycopy(pointData, pos6, tmpArr, 0, 4);
        pointInfo.sammMetaState = byteToInt(tmpArr);
        int pos7 = pos6 + 4;
        System.arraycopy(pointData, pos7, tmpArr8, 0, 8);
        pointInfo.downtime = byteToLong(tmpArr8);
        System.arraycopy(pointData, pos7 + 8, tmpArr8, 0, 8);
        pointInfo.eventtime = byteToLong(tmpArr8);
        return pointInfo;
    }

    public static shareSAMMTextData parseSAMMTextData(byte[] textData) {
        shareSAMMTextData textInfo = new shareSAMMTextData();
        byte[] tmpArr = new byte[4];
        System.arraycopy(textData, 0, tmpArr, 0, 4);
        textInfo.MultiUserID = byteToInt(tmpArr);
        int pos = 0 + 4;
        System.arraycopy(textData, pos, tmpArr, 0, 4);
        textInfo.textID = byteToInt(tmpArr);
        int pos2 = pos + 4;
        System.arraycopy(textData, pos2, tmpArr, 0, 4);
        textInfo.textColor = byteToInt(tmpArr);
        int pos3 = pos2 + 4;
        System.arraycopy(textData, pos3, tmpArr, 0, 4);
        textInfo.textStyle = byteToInt(tmpArr);
        int pos4 = pos3 + 4;
        System.arraycopy(textData, pos4, tmpArr, 0, 4);
        textInfo.textSize = byteToFloat(tmpArr);
        int pos5 = pos4 + 4;
        System.arraycopy(textData, pos5, tmpArr, 0, 4);
        textInfo.textRectLeft = byteToFloat(tmpArr);
        int pos6 = pos5 + 4;
        System.arraycopy(textData, pos6, tmpArr, 0, 4);
        textInfo.textRectTop = byteToFloat(tmpArr);
        int pos7 = pos6 + 4;
        System.arraycopy(textData, pos7, tmpArr, 0, 4);
        textInfo.textRectRight = byteToFloat(tmpArr);
        int pos8 = pos7 + 4;
        System.arraycopy(textData, pos8, tmpArr, 0, 4);
        textInfo.textRectBottom = byteToFloat(tmpArr);
        int pos9 = pos8 + 4;
        System.arraycopy(textData, pos9, tmpArr, 0, 4);
        int fontLength = byteToInt(tmpArr);
        byte[] tmpAttrFont = new byte[fontLength + 4];
        System.arraycopy(textData, pos9, tmpAttrFont, 0, fontLength + 4);
        textInfo.strFont = ScreenSharePacket.parserStringPacket(tmpAttrFont);
        int i = pos9 + 4;
        int pos10 = fontLength + 40;
        System.arraycopy(textData, pos10, tmpArr, 0, 4);
        int textLength = byteToInt(tmpArr);
        byte[] tmpAttrText = new byte[textLength + 4];
        System.arraycopy(textData, pos10, tmpAttrText, 0, textLength + 4);
        textInfo.strText = ScreenSharePacket.parserStringPacket(tmpAttrText);
        return textInfo;
    }

    public static byte[] makeSAMMMatrix(int multiUserID, Matrix matrix) {
        byte[] array = new byte[40];
        byte[] tmpArr = intToByte(multiUserID);
        System.arraycopy(tmpArr, 0, array, 0, 4);
        int pos = 0 + 4;
        byte[] tmpArr2 = matrixToByte(matrix);
        System.arraycopy(tmpArr2, 0, array, pos, 36);
        return array;
    }

    public static shareSAMMMatrixData parseMatrixData(byte[] matrxData) {
        shareSAMMMatrixData matrixInfo = new shareSAMMMatrixData();
        byte[] tmpArrM = new byte[36];
        byte[] tmpArr = new byte[4];
        System.arraycopy(matrxData, 0, tmpArr, 0, 4);
        matrixInfo.MultiUserID = byteToInt(tmpArr);
        int pos = 0 + 4;
        System.arraycopy(matrxData, pos, tmpArrM, 0, 36);
        matrixInfo.matrixData = byteToMatrix(tmpArrM);
        return matrixInfo;
    }

    public static byte[] makeSAMMScreenSize(int multiUserID, int width, int height) {
        byte[] array = new byte[12];
        byte[] tmpArr = intToByte(multiUserID);
        System.arraycopy(tmpArr, 0, array, 0, 4);
        int pos = 0 + 4;
        byte[] tmpArr2 = intToByte(width);
        System.arraycopy(tmpArr2, 0, array, pos, 4);
        byte[] tmpArr3 = intToByte(height);
        System.arraycopy(tmpArr3, 0, array, pos + 4, 4);
        return array;
    }

    public static shareSAMMScreenSize parseSAMMScreenSize(byte[] screenSizeData) {
        shareSAMMScreenSize screenSize = new shareSAMMScreenSize();
        byte[] tmpArr = new byte[4];
        System.arraycopy(screenSizeData, 0, tmpArr, 0, 4);
        screenSize.MultiUserID = byteToInt(tmpArr);
        int pos = 0 + 4;
        System.arraycopy(screenSizeData, pos, tmpArr, 0, 4);
        screenSize.screenWidth = byteToInt(tmpArr);
        System.arraycopy(screenSizeData, pos + 4, tmpArr, 0, 4);
        screenSize.screenHeight = byteToInt(tmpArr);
        return screenSize;
    }

    public void stop() {
        stopSendThread();
        if (this.mOnCallback != null) {
            this.mOnCallback = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendBoardData(int type, byte[] contents) {
        if (this.mShareScreenInterface != null) {
            this.mShareScreenInterface.sendBoardData(this.mDestination, type, contents);
        }
    }
}
