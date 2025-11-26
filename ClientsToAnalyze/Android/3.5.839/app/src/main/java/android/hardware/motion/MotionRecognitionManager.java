package android.hardware.motion;

import android.hardware.motion.IMotionRecognitionService;
import android.hardware.scontext.SContextListener;
import android.hardware.scontext.SContextManager;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.p004os.ServiceManager;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MotionRecognitionManager {
    public static final String ACTION_MOTION_RECOGNITION_EVENT = "android.hardware.motion.MOTION_RECOGNITION_EVENT";
    private static final int DEBUG_LEVEL_HIGH = 18760;
    private static final int DEBUG_LEVEL_LOW = 20300;
    private static final int DEBUG_LEVEL_MID = 18765;
    public static final int EVENT_ALL = 1048575;
    public static final int EVENT_CALL_POSE = 262144;
    public static final int EVENT_DIRECT_CALLING = 1024;
    public static final int EVENT_DOUBLE_TAP = 8;
    public static final int EVENT_FLAT = 8192;
    public static final int EVENT_LCD_UP_STEADY = 65536;
    public static final int EVENT_LOCK_EXECUTE_L = 128;
    public static final int EVENT_LOCK_EXECUTE_R = 256;
    public static final int EVENT_NUM = 20;
    public static final int EVENT_OVER_TURN = 1;
    public static final int EVENT_OVER_TURN_LOW_POWER = 131072;
    public static final int EVENT_PANNING_GALLERY = 32;
    public static final int EVENT_PANNING_HOME = 64;
    public static final int EVENT_REACTIVE_ALERT = 4;
    public static final int EVENT_SHAKE = 2;
    public static final int EVENT_SMART_ALERT_SETTING = 32768;
    public static final int EVENT_SMART_SCROLL = 524288;
    public static final int EVENT_TILT = 16;
    public static final int EVENT_TILT_LEVEL_ZERO = 4096;
    public static final int EVENT_TILT_LEVEL_ZERO_LAND = 16384;
    public static final int EVENT_TILT_TO_UNLOCK = 2048;
    public static final int EVENT_VOLUME_DOWN = 512;
    public static final int MOTION_SENSOR_NUM = 4;
    public static final int MOTION_USE_ACC = 1;
    public static final int MOTION_USE_ALL = 31;
    public static final int MOTION_USE_GYRO = 2;
    public static final int MOTION_USE_LIGHT = 8;
    public static final int MOTION_USE_MOVEMENT = 16;
    public static final int MOTION_USE_PROX = 4;
    private static final String TAG = "MotionRecognitionManager";
    private static final boolean localLOGV = false;
    private static final int mMotionVersion = 1;
    Looper mMainLooper;
    private SContextManager mSContextManager;
    public boolean mSSPEnabled;
    private final ArrayList<MRListenerDelegate> sListenerDelegates = new ArrayList<>();
    private final ArrayList<String> sListenerwithSSP = new ArrayList<>();
    private final SContextListener mySContextMotionListener = new 1(this);
    private IMotionRecognitionService motionService = IMotionRecognitionService.Stub.asInterface(ServiceManager.getService("motion_recognition"));
    private int mMovementCnt = 0;

    public MotionRecognitionManager(Looper looper) {
        this.mMainLooper = looper;
        this.mSContextManager = new SContextManager(this.mMainLooper);
        try {
            this.mSSPEnabled = this.motionService.getSSPstatus();
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in getSSPstatus: ", e);
        }
    }

    @Deprecated
    public void registerListener(MRListener mRListener) {
        registerListener(mRListener, 0, null);
    }

    @Deprecated
    public void registerListener(MRListener mRListener, Handler handler) {
        registerListener(mRListener, 0, handler);
    }

    @Deprecated
    public void registerListener(MRListener mRListener, int i) {
        registerListener(mRListener, i, null);
    }

    @Deprecated
    public void registerListener(MRListener mRListener, int i, Handler handler) {
        int i2 = 0;
        if ((i & 1) != 0) {
            i2 = 237570;
        }
        if ((i & 2) != 0) {
            i2 |= 20985;
        }
        if ((i & 4) != 0) {
            i2 |= 3072;
        }
        registerListenerEvent(mRListener, i2, handler);
    }

    public void registerListenerEvent(MRListener mRListener, int i) {
        registerListenerEvent(mRListener, i, null);
    }

    public void registerListenerEvent(MRListener mRListener, int i, Handler handler) {
        if (mRListener != null) {
            synchronized (this.sListenerDelegates) {
                int size = this.sListenerDelegates.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.sListenerDelegates.get(i2).getListener() == mRListener) {
                        Log.d(TAG, "  .registerListenerEvent : fail. already registered / listener count = " + this.sListenerDelegates.size() + ", " + EncodeLog("name :" + mRListener));
                        return;
                    }
                }
                MRListenerDelegate mRListenerDelegate = new MRListenerDelegate(this, mRListener, i, handler);
                this.sListenerDelegates.add(mRListenerDelegate);
                try {
                    if ((i & 4) != 0) {
                        if (this.mSSPEnabled) {
                            if (this.mySContextMotionListener != null && this.mMovementCnt == 0) {
                                Log.d(TAG, " [MOVEMENT_SERVICE] registerListener ");
                                this.mSContextManager.registerListener(this.mySContextMotionListener, 5);
                            } else {
                                Log.e(TAG, " [MOVEMENT_SERVICE] registerListener : fail. already registered ");
                            }
                            this.mMovementCnt++;
                        } else {
                            try {
                                this.mSSPEnabled = this.motionService.getSSPstatus();
                            } catch (RemoteException e) {
                                Log.e(TAG, "RemoteException in getSSPstatus: ", e);
                            }
                            Log.d(TAG, "SSP disabled : " + this.mSSPEnabled);
                            this.motionService.registerCallback(mRListenerDelegate, 0, i);
                        }
                    } else {
                        this.motionService.registerCallback(mRListenerDelegate, 0, i);
                    }
                } catch (RemoteException e2) {
                    Log.e(TAG, "RemoteException in registerListenerEvent: ", e2);
                }
                Log.v(TAG, "  .registerListenerEvent : success. listener count = " + size + "->" + this.sListenerDelegates.size() + ", motion_events=" + i + ", " + EncodeLog("name :" + mRListener));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x005d, code lost:
    
        r8.sListenerDelegates.remove(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0068, code lost:
    
        if ((r0.getMotionEvents() & 4) == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006d, code lost:
    
        if (r8.mSSPEnabled != true) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006f, code lost:
    
        r8.mMovementCnt--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0077, code lost:
    
        if (r8.mMovementCnt > 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0079, code lost:
    
        android.util.Log.d(android.hardware.motion.MotionRecognitionManager.TAG, " [MOVEMENT_SERVICE] unregisterListener ");
        r8.mMovementCnt = 0;
        r8.mSContextManager.unregisterListener(r8.mySContextMotionListener, 5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008d, code lost:
    
        android.util.Log.d(android.hardware.motion.MotionRecognitionManager.TAG, "unregisterListener - mMovementCnt : " + r8.mMovementCnt);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00f9, code lost:
    
        r8.mSSPEnabled = r8.motionService.getSSPstatus();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0123, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0124, code lost:
    
        android.util.Log.e(android.hardware.motion.MotionRecognitionManager.TAG, "RemoteException in unregisterListener: ", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0132, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0133, code lost:
    
        android.util.Log.e(android.hardware.motion.MotionRecognitionManager.TAG, "RemoteException in getSSPstatus: ", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x013d, code lost:
    
        r8.motionService.unregisterCallback(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void unregisterListener(android.hardware.motion.MRListener r9) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.hardware.motion.MotionRecognitionManager.unregisterListener(android.hardware.motion.MRListener):void");
    }

    public void useMotionAlways(MRListener mRListener, boolean z) {
    }

    public void setMotionAngle(MRListener mRListener, int i) {
    }

    public void setSmartMotionAngle(MRListener mRListener, int i) {
        synchronized (this.sListenerDelegates) {
            int size = this.sListenerDelegates.size();
            for (int i2 = 0; i2 < size; i2++) {
                MRListenerDelegate mRListenerDelegate = this.sListenerDelegates.get(i2);
                if (mRListenerDelegate.getListener() == mRListener) {
                    try {
                        this.motionService.setMotionAngle(mRListenerDelegate, i);
                    } catch (RemoteException e) {
                        Log.e(TAG, "RemoteException in setSmartMotionAngle: ", e);
                    }
                    return;
                }
            }
            Log.d(TAG, "  .setSmartMotionAngle : listener has to be registered first");
        }
    }

    public void setMotionTiltLevel(int i, int i2, int i3, int i4, int i5, int i6) {
        try {
            this.motionService.setMotionTiltLevel(i, i2, i3, i4, i5, i6);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in setMotionTiltLevel: ", e);
        }
        Log.d(TAG, "  .setMotionTiltLevel : 1");
    }

    public int resetMotionEngine() {
        try {
            return this.motionService.resetMotionEngine();
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in resetMotionEngine: ", e);
            return 0;
        }
    }

    public static boolean isValidMotionSensor(int i) {
        return i == 1 || i == 2 || i == 4 || i == 8;
    }

    public static int getMotionVersion() {
        return 1;
    }

    public void setLogPath(String str) {
        try {
            this.motionService.setLogPath(str);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in setLogPath: ", e);
        }
    }

    protected static String EncodeLog(String str) throws NumberFormatException {
        String str2 = SystemProperties.get("ro.debug_level", "Unknown");
        if (str2.equals("Unknown")) {
            return " ";
        }
        try {
            int i = Integer.parseInt(str2.substring(2), 16);
            if (i == DEBUG_LEVEL_LOW) {
                return " ";
            }
            return (i == DEBUG_LEVEL_MID || i == DEBUG_LEVEL_HIGH) ? str : " ";
        } catch (NumberFormatException e) {
            return " ";
        }
    }
}
