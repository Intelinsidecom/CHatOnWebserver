package android.hardware.motion;

import android.hardware.motion.IMotionRecognitionCallback;
import android.hardware.motion.IMotionRecognitionService;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.p000os.ServiceManager;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MotionRecognitionManager {
    public static final String ACTION_MOTION_RECOGNITION_EVENT = "android.hardware.motion.MOTION_RECOGNITION_EVENT";
    public static final int EVENT_ALL = 16383;
    public static final int EVENT_DIRECT_CALLING = 1024;
    public static final int EVENT_DOUBLE_TAP = 8;
    public static final int EVENT_FLAT = 8192;
    public static final int EVENT_LOCK_EXECUTE_L = 128;
    public static final int EVENT_LOCK_EXECUTE_R = 256;
    public static final int EVENT_NUM = 14;
    public static final int EVENT_OVER_TURN = 1;
    public static final int EVENT_PANNING_GALLERY = 32;
    public static final int EVENT_PANNING_HOME = 64;
    public static final int EVENT_REACTIVE_ALERT = 4;
    public static final int EVENT_SHAKE = 2;
    public static final int EVENT_TILT = 16;
    public static final int EVENT_TILT_LEVEL_ZERO = 4096;
    public static final int EVENT_TILT_TO_UNLOCK = 2048;
    public static final int EVENT_VOLUME_DOWN = 512;
    public static final int MOTION_SENSOR_NUM = 4;
    public static final int MOTION_USE_ACC = 1;
    public static final int MOTION_USE_ALL = 15;
    public static final int MOTION_USE_GYRO = 2;
    public static final int MOTION_USE_LIGHT = 8;
    public static final int MOTION_USE_PROX = 4;
    private static final String TAG = "MotionRecognitionManager";
    private static final boolean localLOGV = false;
    private static final int mMotionVersion = 1;
    Looper mMainLooper;
    private final ArrayList sListenerDelegates = new ArrayList();
    private IMotionRecognitionService motionService = IMotionRecognitionService.Stub.asInterface(ServiceManager.getService("motion_recognition"));

    public MotionRecognitionManager(Looper looper) {
        this.mMainLooper = looper;
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
        int i2 = i & 15;
        int i3 = (i2 & 15) == 0 ? 1 : i2;
        if (mRListener != null) {
            synchronized (this.sListenerDelegates) {
                int size = this.sListenerDelegates.size();
                for (int i4 = 0; i4 < size; i4++) {
                    if (((MRListenerDelegate) this.sListenerDelegates.get(i4)).getListener() == mRListener) {
                        Log.d(TAG, "  .registerListener : fail. already registered / listener count = " + this.sListenerDelegates.size() + ", listener=" + mRListener);
                        return;
                    }
                }
                IMotionRecognitionCallback.Stub mRListenerDelegate = new MRListenerDelegate(mRListener, i3, handler);
                this.sListenerDelegates.add(mRListenerDelegate);
                try {
                    this.motionService.registerCallback(mRListenerDelegate, i3);
                } catch (RemoteException e) {
                    Log.e(TAG, "RemoteException in registerListener: ", e);
                }
                Log.v(TAG, "  .registerListener : success. listener count = " + size + "->" + this.sListenerDelegates.size() + ", motion_sensors=" + i3 + ", listener=" + mRListener);
            }
        }
    }

    public void registerListenerEvent(MRListener mRListener, int i) {
        registerListenerEvent(mRListener, i, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void registerListenerEvent(android.hardware.motion.MRListener r7, int r8, android.os.Handler r9) {
        /*
            r6 = this;
            r4 = 1
            r2 = 0
            r3 = r2
            r1 = r4
        L4:
            r0 = 14
            if (r3 < r0) goto L5e
            if (r7 == 0) goto L5d
            java.util.ArrayList r3 = r6.sListenerDelegates
            monitor-enter(r3)
            java.util.ArrayList r0 = r6.sListenerDelegates     // Catch: java.lang.Throwable -> Lae
            int r4 = r0.size()     // Catch: java.lang.Throwable -> Lae
        L13:
            if (r2 < r4) goto L7a
            android.hardware.motion.MotionRecognitionManager$MRListenerDelegate r0 = new android.hardware.motion.MotionRecognitionManager$MRListenerDelegate     // Catch: java.lang.Throwable -> Lae
            r0.<init>(r7, r1, r9)     // Catch: java.lang.Throwable -> Lae
            java.util.ArrayList r2 = r6.sListenerDelegates     // Catch: java.lang.Throwable -> Lae
            r2.add(r0)     // Catch: java.lang.Throwable -> Lae
            android.hardware.motion.IMotionRecognitionService r2 = r6.motionService     // Catch: java.lang.Throwable -> Lae android.os.RemoteException -> Lb6
            r2.registerCallback(r0, r1)     // Catch: java.lang.Throwable -> Lae android.os.RemoteException -> Lb6
        L24:
            java.lang.String r0 = "MotionRecognitionManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lae
            java.lang.String r5 = "  .registerListenerEvent : success. listener count = "
            r2.<init>(r5)     // Catch: java.lang.Throwable -> Lae
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r4 = "->"
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> Lae
            java.util.ArrayList r4 = r6.sListenerDelegates     // Catch: java.lang.Throwable -> Lae
            int r4 = r4.size()     // Catch: java.lang.Throwable -> Lae
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r4 = ", motion_sensors="
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> Lae
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r2 = ", listener="
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lae
            java.lang.StringBuilder r1 = r1.append(r7)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lae
            android.util.Log.v(r0, r1)     // Catch: java.lang.Throwable -> Lae
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lae
        L5d:
            return
        L5e:
            int r0 = r4 << r3
            r5 = r0 & r8
            if (r5 == 0) goto L67
            switch(r0) {
                case 1: goto L6d;
                case 2: goto L6d;
                case 4: goto L6d;
                case 8: goto L6f;
                case 16: goto L6f;
                case 32: goto L6f;
                case 64: goto L6f;
                case 128: goto L6f;
                case 256: goto L6f;
                case 512: goto L6f;
                case 1024: goto L72;
                case 2048: goto L75;
                case 8192: goto L6d;
                case 16383: goto L77;
                default: goto L67;
            }     // Catch: java.lang.Throwable -> Lae
        L67:
            r0 = r1
        L68:
            int r1 = r3 + 1
            r3 = r1
            r1 = r0
            goto L4
        L6d:
            r0 = r1
            goto L68
        L6f:
            r0 = r1 | 6
            goto L68
        L72:
            r0 = r1 | 6
            goto L68
        L75:
            r0 = 2
            goto L68
        L77:
            r0 = 15
            goto L68
        L7a:
            java.util.ArrayList r0 = r6.sListenerDelegates     // Catch: java.lang.Throwable -> Lae
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> Lae
            android.hardware.motion.MotionRecognitionManager$MRListenerDelegate r0 = (android.hardware.motion.MotionRecognitionManager.MRListenerDelegate) r0     // Catch: java.lang.Throwable -> Lae
            android.hardware.motion.MRListener r0 = r0.getListener()     // Catch: java.lang.Throwable -> Lae
            if (r0 != r7) goto Lb1
            java.lang.String r0 = "MotionRecognitionManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lae
            java.lang.String r2 = "  .registerListenerEvent : fail. already registered / listener count = "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lae
            java.util.ArrayList r2 = r6.sListenerDelegates     // Catch: java.lang.Throwable -> Lae
            int r2 = r2.size()     // Catch: java.lang.Throwable -> Lae
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r2 = ", listener="
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lae
            java.lang.StringBuilder r1 = r1.append(r7)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lae
            android.util.Log.d(r0, r1)     // Catch: java.lang.Throwable -> Lae
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lae
            goto L5d
        Lae:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lae
            throw r0
        Lb1:
            int r0 = r2 + 1
            r2 = r0
            goto L13
        Lb6:
            r0 = move-exception
            java.lang.String r2 = "MotionRecognitionManager"
            java.lang.String r5 = "RemoteException in registerListenerEvent: "
            android.util.Log.e(r2, r5, r0)     // Catch: java.lang.Throwable -> Lae
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: android.hardware.motion.MotionRecognitionManager.registerListenerEvent(android.hardware.motion.MRListener, int, android.os.Handler):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x007f, code lost:
    
        r8.sListenerDelegates.remove(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0084, code lost:
    
        r8.motionService.unregisterCallback((android.os.IBinder) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x008a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008b, code lost:
    
        android.util.Log.e(android.hardware.motion.MotionRecognitionManager.TAG, "RemoteException in unregisterListener: ", r0);
     */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.hardware.motion.MotionRecognitionManager$MRListenerDelegate, android.os.IBinder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void unregisterListener(android.hardware.motion.MRListener r9) {
        /*
            r8 = this;
            r1 = 0
            java.util.ArrayList r3 = r8.sListenerDelegates
            monitor-enter(r3)
            java.util.ArrayList r0 = r8.sListenerDelegates     // Catch: java.lang.Throwable -> L94
            int r4 = r0.size()     // Catch: java.lang.Throwable -> L94
            r2 = r1
        Lb:
            if (r2 < r4) goto L3f
        Ld:
            if (r1 < r4) goto L71
        Lf:
            java.lang.String r0 = "MotionRecognitionManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L94
            java.lang.String r2 = "  .unregisterListener : / listener count = "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L94
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch: java.lang.Throwable -> L94
            java.lang.String r2 = "->"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L94
            java.util.ArrayList r2 = r8.sListenerDelegates     // Catch: java.lang.Throwable -> L94
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L94
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L94
            java.lang.String r2 = ", listener="
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L94
            java.lang.StringBuilder r1 = r1.append(r9)     // Catch: java.lang.Throwable -> L94
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L94
            android.util.Log.i(r0, r1)     // Catch: java.lang.Throwable -> L94
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L94
            return
        L3f:
            java.util.ArrayList r0 = r8.sListenerDelegates     // Catch: java.lang.Throwable -> L94
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L94
            android.hardware.motion.MotionRecognitionManager$MRListenerDelegate r0 = (android.hardware.motion.MotionRecognitionManager.MRListenerDelegate) r0     // Catch: java.lang.Throwable -> L94
            android.hardware.motion.MRListener r0 = r0.getListener()     // Catch: java.lang.Throwable -> L94
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L94
            java.lang.String r5 = "MotionRecognitionManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L94
            java.lang.String r7 = "@ member "
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L94
            java.lang.StringBuilder r6 = r6.append(r2)     // Catch: java.lang.Throwable -> L94
            java.lang.String r7 = " = "
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L94
            java.lang.StringBuilder r0 = r6.append(r0)     // Catch: java.lang.Throwable -> L94
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L94
            android.util.Log.d(r5, r0)     // Catch: java.lang.Throwable -> L94
            int r0 = r2 + 1
            r2 = r0
            goto Lb
        L71:
            java.util.ArrayList r0 = r8.sListenerDelegates     // Catch: java.lang.Throwable -> L94
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L94
            android.hardware.motion.MotionRecognitionManager$MRListenerDelegate r0 = (android.hardware.motion.MotionRecognitionManager.MRListenerDelegate) r0     // Catch: java.lang.Throwable -> L94
            android.hardware.motion.MRListener r2 = r0.getListener()     // Catch: java.lang.Throwable -> L94
            if (r2 != r9) goto L97
            java.util.ArrayList r2 = r8.sListenerDelegates     // Catch: java.lang.Throwable -> L94
            r2.remove(r1)     // Catch: java.lang.Throwable -> L94
            android.hardware.motion.IMotionRecognitionService r1 = r8.motionService     // Catch: android.os.RemoteException -> L8a java.lang.Throwable -> L94
            r1.unregisterCallback(r0)     // Catch: android.os.RemoteException -> L8a java.lang.Throwable -> L94
            goto Lf
        L8a:
            r0 = move-exception
            java.lang.String r1 = "MotionRecognitionManager"
            java.lang.String r2 = "RemoteException in unregisterListener: "
            android.util.Log.e(r1, r2, r0)     // Catch: java.lang.Throwable -> L94
            goto Lf
        L94:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L94
            throw r0
        L97:
            int r0 = r1 + 1
            r1 = r0
            goto Ld
        */
        throw new UnsupportedOperationException("Method not decompiled: android.hardware.motion.MotionRecognitionManager.unregisterListener(android.hardware.motion.MRListener):void");
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [android.hardware.motion.MotionRecognitionManager$MRListenerDelegate, android.os.IBinder] */
    public void useMotionAlways(MRListener mRListener, boolean z) {
        synchronized (this.sListenerDelegates) {
            int size = this.sListenerDelegates.size();
            for (int i = 0; i < size; i++) {
                ?? r0 = (MRListenerDelegate) this.sListenerDelegates.get(i);
                if (r0.getListener() == mRListener) {
                    try {
                        this.motionService.useMotionAlways((IBinder) r0, z);
                    } catch (RemoteException e) {
                        Log.e(TAG, "RemoteException in useMotionAlways: ", e);
                    }
                    return;
                }
            }
            Log.d(TAG, "  .useMotionAlways : listener has to be registered first");
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [android.hardware.motion.MotionRecognitionManager$MRListenerDelegate, android.os.IBinder] */
    public void setMotionAngle(MRListener mRListener, int i) {
        synchronized (this.sListenerDelegates) {
            int size = this.sListenerDelegates.size();
            for (int i2 = 0; i2 < size; i2++) {
                ?? r0 = (MRListenerDelegate) this.sListenerDelegates.get(i2);
                if (r0.getListener() == mRListener) {
                    try {
                        this.motionService.setMotionAngle((IBinder) r0, i);
                    } catch (RemoteException e) {
                        Log.e(TAG, "RemoteException in setMotionAngle: ", e);
                    }
                    return;
                }
            }
            Log.d(TAG, "  .setMotionAngle : listener has to be registered first");
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

    public static boolean isValidMotionSensor(int i) {
        if (i == 1 || i == 2 || i == 4 || i == 8) {
            return true;
        }
        return localLOGV;
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

    class MRListenerDelegate extends IMotionRecognitionCallback.Stub {
        private final Handler mHandler;
        private final MRListener mListener;
        private final int mMotionSensors;

        MRListenerDelegate(MRListener mRListener, int i, Handler handler) {
            this.mListener = mRListener;
            Looper looper = handler != null ? handler.getLooper() : MotionRecognitionManager.this.mMainLooper;
            this.mMotionSensors = i;
            this.mHandler = new Handler(looper) { // from class: android.hardware.motion.MotionRecognitionManager.MRListenerDelegate.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    try {
                        if (MRListenerDelegate.this.mListener != null) {
                            MRListenerDelegate.this.mListener.onMotionListener((MREvent) message.obj);
                        }
                    } catch (ClassCastException e) {
                        Log.e(MotionRecognitionManager.TAG, "ClassCastException in handleMessage: msg.obj = " + message.obj, e);
                    }
                }
            };
        }

        public MRListener getListener() {
            return this.mListener;
        }

        public void motionCallback(MREvent mREvent) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 0;
            messageObtain.obj = mREvent;
            this.mHandler.sendMessage(messageObtain);
        }

        public String getListenerInfo() {
            return this.mListener.toString();
        }
    }
}
