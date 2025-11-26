package android.hardware.motion;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.motion.IMotionRecognitionCallback;
import android.hardware.motion.IMotionRecognitionService;
import android.hardware.motion.MotionRecognitionEngineAppId;
import android.os.FileObserver;
import android.os.FileUtils;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.Slog;
import android.view.WindowOrientationListener;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MotionRecognitionService extends IMotionRecognitionService.Stub {
    private static final String ACTION_MOTIONS_SETTINGS_CHANGED = "com.sec.motions.MOTIONS_SETTINGS_CHANGED";
    private static final boolean CONFIG_BROADCAST_INTENT = false;
    private static final boolean CONFIG_ENGINE_SEND_GYRO = false;
    private static final boolean CONFIG_READ_SETTINGS = true;
    private static final boolean CONFIG_USE_ALWAYS = false;
    public static final String FILE_DIR = "/data/log/acc_int";
    private static final String TAG = "MotionRecognitionService";
    private static final boolean localLOGD = false;
    private static final boolean localLOGV = false;
    private static final boolean localLOGVV = false;
    private static final int mDefaultAppId = MotionRecognitionEngineAppId.eAPPID.APPID_TEST.ordinal();
    private static final int mSensitivityDef = 5;
    private static final int mSensitivityMax = 10;
    boolean mBootCompeleted;
    private final Context mContext;
    boolean mEnableAccINT;
    boolean mEngineInitialized;
    boolean mEngineIsAvailable;
    EventPool mEventPool;
    boolean mFlatEvent;
    ServiceHandler mHandler;
    boolean mInterrupt;
    ArrayList mListeners;
    Object mLockEngine;
    PrintWriter mLogPW;
    String mLogPath;
    long mLogTime;
    Handler mMsgHandler;
    private double[] mPostAccelVal;
    private double[] mPostGyroVal;
    private int mPostLightVal;
    private short mPostProxVal;
    private boolean mPostTouch;
    long mPowerTime;
    final BroadcastReceiver mReceiver;
    ContentResolver mResolver;
    int mRotate;
    boolean mScreenOn;
    int mSensorDelayInMsec;
    int mSensorsEnabled;
    int mSensorsUsed;
    HandlerThread mThread;
    private FileObserver observer;
    WindowOrientationListener orientationListener;
    private final SensorEventListener sensorAccelerometerListener;
    private final SensorEventListener sensorGyroscopeListener;
    private final SensorEventListener sensorLightListener;
    SensorManager sensorManager;
    private final SensorEventListener sensorProximityListener;

    private native void native_clear_scenario_result(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void native_finalize_motionengine(int i);

    private native int native_get_panning_dx();

    private native int native_get_panning_dy();

    private native int native_get_panning_dz();

    private native int native_get_walking_status();

    /* JADX INFO: Access modifiers changed from: private */
    public native int native_getscenario_id(double d, double d2, double d3, double d4, double d5, double d6, short s, int i, boolean z, int i2, int i3);

    private native void native_initialize_motionengine(int i);

    private native int native_motionengine_is_available();

    private native void native_set_motion_angle(int i);

    private native void native_set_tilt_level(int i, int i2, int i3, int i4, int i5, int i6);

    public MotionRecognitionService(Context context) {
        boolean z = CONFIG_READ_SETTINGS;
        this.mLogPW = null;
        this.mLogPath = "";
        this.mLogTime = 0L;
        this.mPowerTime = 0L;
        this.mThread = null;
        this.mHandler = null;
        this.mListeners = new ArrayList();
        this.mEventPool = null;
        this.mLockEngine = new Object();
        this.mEngineIsAvailable = CONFIG_READ_SETTINGS;
        this.mEngineInitialized = false;
        this.mBootCompeleted = false;
        this.mScreenOn = false;
        this.mEnableAccINT = false;
        this.mFlatEvent = false;
        this.mInterrupt = false;
        this.mRotate = 28;
        this.mSensorsUsed = 0;
        this.mSensorsEnabled = 0;
        this.mSensorDelayInMsec = 20;
        this.mReceiver = new BroadcastReceiver() { // from class: android.hardware.motion.MotionRecognitionService.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                    MotionRecognitionService.this.mScreenOn = MotionRecognitionService.CONFIG_READ_SETTINGS;
                    if (MotionRecognitionService.this.mListeners.size() == 0) {
                        return;
                    }
                    MotionRecognitionService.this.initializeMotionEngine();
                    return;
                }
                if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    MotionRecognitionService.this.mScreenOn = false;
                    MotionRecognitionService.this.finalizeIfPossible();
                    return;
                }
                if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
                    Slog.d(MotionRecognitionService.TAG, "  mReceiver.onReceive : ACTION_BOOT_COMPLETED");
                    MotionRecognitionService.this.mBootCompeleted = MotionRecognitionService.CONFIG_READ_SETTINGS;
                    MotionRecognitionService.this.mScreenOn = MotionRecognitionService.CONFIG_READ_SETTINGS;
                    return;
                }
                if ("android.intent.action.ACTION_POWER_CONNECTED".equals(intent.getAction()) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(intent.getAction()) || "android.intent.action.BATTERY_LOW".equals(intent.getAction())) {
                    MotionRecognitionService.this.mPowerTime = System.currentTimeMillis();
                    return;
                }
                if (MotionRecognitionService.ACTION_MOTIONS_SETTINGS_CHANGED.equals(intent.getAction())) {
                    boolean booleanExtra = intent.getBooleanExtra("isEnable", false);
                    Slog.d(MotionRecognitionService.TAG, "  mReceiver.onReceive : ACTION_MOTIONS_SETTINGS_CHANGED - " + booleanExtra);
                    if (booleanExtra) {
                        if (MotionRecognitionService.this.mListeners.size() <= 0) {
                            return;
                        }
                        MotionRecognitionService.this.initializeMotionEngine();
                        return;
                    }
                    MotionRecognitionService.this.finalizeMotionEngine();
                    return;
                }
                if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                    Slog.e(MotionRecognitionService.TAG, "  mReceiver.onReceive : ACTION_USER_PRESENT  :: UNLOCK SCREEN");
                }
            }
        };
        this.mMsgHandler = new Handler() { // from class: android.hardware.motion.MotionRecognitionService.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 10) {
                    synchronized (MotionRecognitionService.this.mLockEngine) {
                        Slog.i(MotionRecognitionService.TAG, "disable all sensors");
                        MotionRecognitionService.this.enableAllSensors(false);
                        if (MotionRecognitionService.this.mFlatEvent) {
                            Slog.e(MotionRecognitionService.TAG, "start reactive alert mode");
                            Slog.d(MotionRecognitionService.TAG, "ignore .finalizeMotionEngine");
                        } else {
                            Slog.e(MotionRecognitionService.TAG, "skip reactive alert mode");
                            MotionRecognitionService.this.disableAccINT();
                            MotionRecognitionService.this.mEngineInitialized = false;
                            Slog.d(MotionRecognitionService.TAG, "  .finalizeMotionEngine");
                            MotionRecognitionService.this.native_finalize_motionengine(MotionRecognitionService.mDefaultAppId);
                        }
                    }
                }
                if (message.what == 20) {
                    synchronized (MotionRecognitionService.this.mLockEngine) {
                        Slog.i(MotionRecognitionService.TAG, "disable acc sensor");
                        MotionRecognitionService.this.enableSensor(1, false);
                        MotionRecognitionService.this.disableAccINT();
                    }
                }
            }
        };
        this.mPostAccelVal = new double[3];
        this.mPostGyroVal = new double[3];
        this.mPostProxVal = (short) 5;
        this.mPostTouch = false;
        this.sensorAccelerometerListener = new SensorEventListener() { // from class: android.hardware.motion.MotionRecognitionService.3
            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
                sensor.getType();
            }

            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.sensor.getType() == 1) {
                    MotionRecognitionService.this.mPostAccelVal[0] = sensorEvent.values[0];
                    MotionRecognitionService.this.mPostAccelVal[1] = sensorEvent.values[1];
                    MotionRecognitionService.this.mPostAccelVal[2] = sensorEvent.values[2];
                    if ((MotionRecognitionService.this.mSensorsUsed & 1) != 0) {
                        MotionRecognitionService.this.sensorLogWrite();
                        int iNative_getscenario_id = 0;
                        synchronized (MotionRecognitionService.this.mLockEngine) {
                            if (MotionRecognitionService.this.mEngineInitialized) {
                                iNative_getscenario_id = MotionRecognitionService.this.native_getscenario_id(MotionRecognitionService.this.mPostAccelVal[0], MotionRecognitionService.this.mPostAccelVal[1], MotionRecognitionService.this.mPostAccelVal[2], MotionRecognitionService.this.mPostGyroVal[0], MotionRecognitionService.this.mPostGyroVal[1], MotionRecognitionService.this.mPostGyroVal[2], MotionRecognitionService.this.mPostProxVal, MotionRecognitionService.this.mPostLightVal, MotionRecognitionService.this.mPostTouch, MotionRecognitionService.this.mSensorsUsed, MotionRecognitionService.this.mSensorDelayInMsec);
                            }
                        }
                        MotionRecognitionService.this.sendMotionEvent(iNative_getscenario_id);
                    }
                }
            }
        };
        this.sensorGyroscopeListener = new SensorEventListener() { // from class: android.hardware.motion.MotionRecognitionService.4
            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
                sensor.getType();
            }

            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.sensor.getType() == 4) {
                    MotionRecognitionService.this.mPostGyroVal[0] = sensorEvent.values[0];
                    MotionRecognitionService.this.mPostGyroVal[1] = sensorEvent.values[1];
                    MotionRecognitionService.this.mPostGyroVal[2] = sensorEvent.values[2];
                    if ((MotionRecognitionService.this.mSensorsUsed & 1) == 0 && (MotionRecognitionService.this.mSensorsUsed & 2) != 0) {
                        MotionRecognitionService.this.sensorLogWrite();
                        int iNative_getscenario_id = 0;
                        synchronized (MotionRecognitionService.this.mLockEngine) {
                            if (MotionRecognitionService.this.mEngineInitialized) {
                                iNative_getscenario_id = MotionRecognitionService.this.native_getscenario_id(MotionRecognitionService.this.mPostAccelVal[0], MotionRecognitionService.this.mPostAccelVal[1], MotionRecognitionService.this.mPostAccelVal[2], MotionRecognitionService.this.mPostGyroVal[0], MotionRecognitionService.this.mPostGyroVal[1], MotionRecognitionService.this.mPostGyroVal[2], MotionRecognitionService.this.mPostProxVal, MotionRecognitionService.this.mPostLightVal, MotionRecognitionService.this.mPostTouch, MotionRecognitionService.this.mSensorsUsed, MotionRecognitionService.this.mSensorDelayInMsec);
                            }
                        }
                        MotionRecognitionService.this.sendMotionEvent(iNative_getscenario_id);
                    }
                }
            }
        };
        this.sensorProximityListener = new SensorEventListener() { // from class: android.hardware.motion.MotionRecognitionService.5
            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
                sensor.getType();
            }

            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.sensor.getType() == 8) {
                    MotionRecognitionService.this.mPostProxVal = (short) sensorEvent.values[0];
                    if ((MotionRecognitionService.this.mSensorsUsed & 4) != 0) {
                        MotionRecognitionService.this.sensorLogWrite();
                        int iNative_getscenario_id = 0;
                        synchronized (MotionRecognitionService.this.mLockEngine) {
                            if (MotionRecognitionService.this.mEngineInitialized) {
                                iNative_getscenario_id = MotionRecognitionService.this.native_getscenario_id(MotionRecognitionService.this.mPostAccelVal[0], MotionRecognitionService.this.mPostAccelVal[1], MotionRecognitionService.this.mPostAccelVal[2], MotionRecognitionService.this.mPostGyroVal[0], MotionRecognitionService.this.mPostGyroVal[1], MotionRecognitionService.this.mPostGyroVal[2], MotionRecognitionService.this.mPostProxVal, MotionRecognitionService.this.mPostLightVal, MotionRecognitionService.this.mPostTouch, MotionRecognitionService.this.mSensorsUsed, MotionRecognitionService.this.mSensorDelayInMsec);
                            }
                        }
                        MotionRecognitionService.this.sendMotionEvent(iNative_getscenario_id);
                    }
                }
            }
        };
        this.sensorLightListener = new SensorEventListener() { // from class: android.hardware.motion.MotionRecognitionService.6
            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
                sensor.getType();
            }

            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.sensor.getType() == 5) {
                    MotionRecognitionService.this.mPostLightVal = (int) sensorEvent.values[0];
                    if ((MotionRecognitionService.this.mSensorsUsed & 8) != 0) {
                        MotionRecognitionService.this.sensorLogWrite();
                        int iNative_getscenario_id = 0;
                        synchronized (MotionRecognitionService.this.mLockEngine) {
                            if (MotionRecognitionService.this.mEngineInitialized) {
                                iNative_getscenario_id = MotionRecognitionService.this.native_getscenario_id(MotionRecognitionService.this.mPostAccelVal[0], MotionRecognitionService.this.mPostAccelVal[1], MotionRecognitionService.this.mPostAccelVal[2], MotionRecognitionService.this.mPostGyroVal[0], MotionRecognitionService.this.mPostGyroVal[1], MotionRecognitionService.this.mPostGyroVal[2], MotionRecognitionService.this.mPostProxVal, MotionRecognitionService.this.mPostLightVal, MotionRecognitionService.this.mPostTouch, MotionRecognitionService.this.mSensorsUsed, MotionRecognitionService.this.mSensorDelayInMsec);
                            }
                        }
                        MotionRecognitionService.this.sendMotionEvent(iNative_getscenario_id);
                    }
                }
            }
        };
        this.mContext = context;
        this.mEngineIsAvailable = native_motionengine_is_available() == 0 ? false : z;
        if (!this.mEngineIsAvailable) {
            Slog.e(TAG, "  Engine is not included");
            return;
        }
        this.mThread = new HandlerThread("motion_recognition");
        this.mThread.start();
        this.mHandler = new ServiceHandler(this.mThread.getLooper());
        this.mEventPool = new EventPool();
        this.mResolver = context.getContentResolver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        intentFilter.addAction(ACTION_MOTIONS_SETTINGS_CHANGED);
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        context.registerReceiver(this.mReceiver, intentFilter);
        this.sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        this.orientationListener = new WindowOrientationListener(context) { // from class: android.hardware.motion.MotionRecognitionService.7
            public void onProposedRotationChanged(int i) {
                switch (i) {
                    case 1:
                        MotionRecognitionService.this.mRotate = 29;
                        break;
                    case 2:
                        MotionRecognitionService.this.mRotate = 30;
                        break;
                    case 3:
                        MotionRecognitionService.this.mRotate = 31;
                        break;
                    default:
                        MotionRecognitionService.this.mRotate = 28;
                        break;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializeMotionEngine() {
        if (this.mEngineIsAvailable && !this.mEngineInitialized && this.mBootCompeleted && checkSettingEngineEnabled()) {
            Slog.d(TAG, "  .initializeMotionEngine");
            this.orientationListener.enable();
            sensorLogStart();
            synchronized (this.mLockEngine) {
                this.mEngineInitialized = CONFIG_READ_SETTINGS;
                native_initialize_motionengine(mDefaultAppId);
                enableAllSensors(CONFIG_READ_SETTINGS);
            }
        }
    }

    public void enableAccINT() throws IOException {
        Slog.d(TAG, "enableAccINT ");
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(new File("/sys/class/sensors/accelerometer_sensor/reactive_alert"));
            } catch (FileNotFoundException e) {
                Slog.e(TAG, "File not found!");
            }
            if (fileOutputStream == null) {
                Slog.e(TAG, "Output file is null!");
                return;
            }
            fileOutputStream.write(49);
            fileOutputStream.close();
            this.mEnableAccINT = CONFIG_READ_SETTINGS;
            Slog.d(TAG, "enableAccINT Complete!!");
        } catch (IOException e2) {
            e2.printStackTrace();
            if (0 != 0) {
                try {
                    fileOutputStream.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            Slog.e(TAG, "File write fail!!");
        }
    }

    public void disableAccINT() throws IOException {
        Slog.d(TAG, "disableAccINT ");
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(new File("/sys/class/sensors/accelerometer_sensor/reactive_alert"));
            } catch (FileNotFoundException e) {
                Slog.e(TAG, "File not found!");
            }
            if (fileOutputStream == null) {
                Slog.e(TAG, "Output file is null!");
                return;
            }
            fileOutputStream.write(48);
            fileOutputStream.close();
            this.mEnableAccINT = false;
            this.mInterrupt = false;
            Slog.d(TAG, "disableAccINT Complete!!");
        } catch (IOException e2) {
            e2.printStackTrace();
            if (0 != 0) {
                try {
                    fileOutputStream.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            Slog.e(TAG, "File write fail!!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finalizeMotionEngine() {
        if (this.mEngineIsAvailable && this.mEngineInitialized) {
            this.orientationListener.disable();
            sensorLogEnd();
            synchronized (this.mLockEngine) {
                if (this.mEnableAccINT) {
                    this.observer = new FileObserver(FILE_DIR, 4095) { // from class: android.hardware.motion.MotionRecognitionService.8
                        @Override // android.os.FileObserver
                        public void onEvent(int i, String str) {
                            if (!MotionRecognitionService.this.mInterrupt) {
                                Slog.i(MotionRecognitionService.TAG, "FileObserver :: updated file = " + i);
                                MotionRecognitionService.this.mInterrupt = MotionRecognitionService.CONFIG_READ_SETTINGS;
                                synchronized (MotionRecognitionService.this.mLockEngine) {
                                    Slog.i(MotionRecognitionService.TAG, "enable acc sensor");
                                    MotionRecognitionService.this.enableSensor(1, MotionRecognitionService.CONFIG_READ_SETTINGS);
                                }
                                MotionRecognitionService.this.mMsgHandler.sendEmptyMessageDelayed(20, 2000L);
                                MotionRecognitionService.this.observer.stopWatching();
                                Slog.d(MotionRecognitionService.TAG, "FileObserver@ stopWatching");
                            }
                        }
                    };
                    this.observer.startWatching();
                    Slog.d(TAG, "FileObserver@ startWatching");
                    this.mMsgHandler.sendEmptyMessageDelayed(10, 1000L);
                } else {
                    this.mEngineInitialized = false;
                    enableAllSensors(false);
                    Slog.d(TAG, "  .finalizeMotionEngine");
                    native_finalize_motionengine(mDefaultAppId);
                }
            }
        }
    }

    private void sendMotionEvent(MREvent mREvent) {
        int motion = mREvent.getMotion();
        if (checkSettingMotionEnabled(motion) && this.mListeners.size() > 0) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 0;
            messageObtain.obj = mREvent;
            this.mHandler.sendMessage(messageObtain);
            if (motion == 67) {
                this.mFlatEvent = false;
                Slog.i(TAG, "send pick up event ~~");
            }
            if (motion == 71) {
                this.mFlatEvent = CONFIG_READ_SETTINGS;
                Slog.i(TAG, "send flat event ~~");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMotionEvent(int i) {
        int iNative_get_panning_dx;
        int iNative_get_panning_dy;
        int iNative_get_panning_dz;
        int iNative_get_walking_status;
        int i2;
        int i3;
        boolean z = CONFIG_READ_SETTINGS;
        synchronized (this.mLockEngine) {
            iNative_get_panning_dx = native_get_panning_dx();
            iNative_get_panning_dy = native_get_panning_dy();
            iNative_get_panning_dz = native_get_panning_dz();
            iNative_get_walking_status = native_get_walking_status();
        }
        if (i > 0 && i < 86) {
            switch (i) {
                case MREvent.SNAP1_X_POSITIVE /* 47 */:
                    i3 = 2;
                    break;
                case MREvent.SNAP1_X_NEGATIVE /* 48 */:
                    i3 = 3;
                    break;
                case MREvent.TWO_TAPPING_GYRO /* 63 */:
                    i3 = 1;
                    break;
                default:
                    i3 = i;
                    break;
            }
            if (i != i3) {
            }
            switch (i3) {
                case 1:
                    long jCurrentTimeMillis = System.currentTimeMillis() - this.mPowerTime;
                    if (jCurrentTimeMillis > 0 && jCurrentTimeMillis < 2000) {
                        Slog.d(TAG, "  .sendMotionEvent : ignore TWO_TAPPING. (time=" + jCurrentTimeMillis + ")");
                        z = false;
                        break;
                    }
                    break;
                case 10:
                case MREvent.SHAKE_START /* 35 */:
                case MREvent.SHAKE_STOP /* 36 */:
                case MREvent.REACTIVE_ALERT /* 67 */:
                case MREvent.DIRECT_CALL /* 68 */:
                case MREvent.VOLUMEDOWN /* 70 */:
                case MREvent.FLAT /* 71 */:
                case MREvent.LOCK_EXECUTE_CAMERA_L /* 73 */:
                case MREvent.LOCK_EXECUTE_CAMERA_R /* 74 */:
                case MREvent.TILT_TO_UNLOCK /* 75 */:
                case MREvent.CALLPOSE_L /* 76 */:
                case MREvent.CALLPOSE_R /* 77 */:
                case MREvent.TILT_UP_LEVEL_1 /* 78 */:
                case MREvent.TILT_UP_LEVEL_2 /* 79 */:
                case MREvent.TILT_UP_LEVEL_3 /* 80 */:
                case MREvent.TILT_DOWN_LEVEL_1 /* 81 */:
                case MREvent.TILT_DOWN_LEVEL_2 /* 82 */:
                case MREvent.TILT_DOWN_LEVEL_3 /* 83 */:
                case MREvent.TILT_LEVEL_ZERO /* 84 */:
                case MREvent.TILT_LEVEL_FLAT /* 85 */:
                    break;
                case MREvent.PANNING_GYRO /* 61 */:
                    z = false;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                MREvent mREventObtain = this.mEventPool.obtain();
                mREventObtain.setMotion(i3);
                sendMotionEvent(mREventObtain);
            }
        }
        if (iNative_get_panning_dx != 0 || iNative_get_panning_dy != 0) {
            switch (this.mRotate) {
                case MREvent.ROTATE_90 /* 29 */:
                    i2 = iNative_get_panning_dx;
                    break;
                case MREvent.ROTATE_180 /* 30 */:
                    i2 = -iNative_get_panning_dy;
                    break;
                case MREvent.ROTATE_270 /* 31 */:
                    i2 = -iNative_get_panning_dx;
                    break;
                default:
                    i2 = iNative_get_panning_dy;
                    break;
            }
            int settingMotionSensitivity = getSettingMotionSensitivity(61);
            int settingMotionSensitivity2 = i2 + (((getSettingMotionSensitivity(72) - 5) * i2) / 10);
            MREvent mREventObtain2 = this.mEventPool.obtain();
            mREventObtain2.setMotion(61);
            mREventObtain2.setPanningDx(iNative_get_panning_dx + (((settingMotionSensitivity - 5) * iNative_get_panning_dx) / 10));
            mREventObtain2.setPanningDy(iNative_get_panning_dy + (((settingMotionSensitivity - 5) * iNative_get_panning_dy) / 10));
            mREventObtain2.setPanningDz((((settingMotionSensitivity - 5) * iNative_get_panning_dz) / 10) + iNative_get_panning_dz);
            sendMotionEvent(mREventObtain2);
            if (settingMotionSensitivity2 != 0) {
                MREvent mREventObtain3 = this.mEventPool.obtain();
                mREventObtain3.setMotion(72);
                mREventObtain3.setTilt(settingMotionSensitivity2);
                mREventObtain3.setWalkingStatus(iNative_get_walking_status);
                sendMotionEvent(mREventObtain3);
            }
        }
    }

    private void sendBroadcastIntent(int i) {
    }

    private boolean checkSettingEngineEnabled() {
        boolean z = CONFIG_READ_SETTINGS;
        if (Settings.System.getInt(this.mResolver, "motion_engine", 0) != 1) {
            z = false;
        }
        boolean z2 = SystemProperties.getBoolean("debug.motion.enabled", false);
        if (z2) {
            Slog.d(TAG, "  .checkSettingEngineEnabled : isEnabled=" + z + ",  debugEnabled=" + z2);
            return z2;
        }
        return z;
    }

    private boolean checkSettingMotionEnabled(int i) {
        if (SystemProperties.getBoolean("debug.motion.enabled", false)) {
            return CONFIG_READ_SETTINGS;
        }
        String str = null;
        switch (i) {
            case 1:
                str = "motion_double_tap";
                break;
            case 10:
                str = "motion_overturn";
                break;
            case MREvent.SHAKE_START /* 35 */:
            case MREvent.SHAKE_STOP /* 36 */:
                str = "motion_shake";
                break;
            case MREvent.PANNING_GYRO /* 61 */:
                str = "motion_panning";
                break;
            case MREvent.REACTIVE_ALERT /* 67 */:
                str = "motion_pick_up";
                break;
            case MREvent.TILT /* 72 */:
                str = "motion_zooming";
                break;
        }
        if (str == null || Settings.System.getInt(this.mResolver, str, 1) == 1) {
            return CONFIG_READ_SETTINGS;
        }
        return false;
    }

    private int getSettingMotionSensitivity(int i) {
        String str = null;
        switch (i) {
            case MREvent.PANNING_GYRO /* 61 */:
                str = "motion_panning_sensitivity";
                break;
            case MREvent.TILT /* 72 */:
                str = "motion_zooming_sensitivity";
                break;
        }
        if (str != null) {
            return Settings.System.getInt(this.mResolver, str, 5);
        }
        return 5;
    }

    public void registerCallback(IBinder iBinder, int i) {
        if (this.mEngineIsAvailable) {
            if (i != 0) {
                i |= 1;
            }
            synchronized (this.mListeners) {
                Iterator it = this.mListeners.iterator();
                while (it.hasNext()) {
                    if (iBinder == ((Listener) it.next()).mToken) {
                        return;
                    }
                }
                if (0 == 0) {
                    Listener listener = new Listener(iBinder, i);
                    iBinder.linkToDeath(listener, 0);
                    this.mListeners.add(listener);
                    String listenerInfo = "";
                    try {
                        listenerInfo = IMotionRecognitionCallback.Stub.asInterface(iBinder).getListenerInfo();
                    } catch (RemoteException e) {
                    }
                    Slog.d(TAG, "  .registerCallback : " + this.mListeners.size() + ", motion_sensors=" + i + ", client=" + listenerInfo);
                    native_initialize_motionengine(mDefaultAppId);
                    this.mListeners.notify();
                    if (listenerInfo.contains("com.android.motionservicetestGyro") || listenerInfo.contains("com.android.server.NotificationManagerService") || listenerInfo.contains("com.android.pickuptutorial.PickUpBlackScreen")) {
                        enableAccINT();
                    }
                }
                if (!this.mEngineInitialized && this.mScreenOn) {
                    initializeMotionEngine();
                }
                for (int i2 = 0; i2 < 4; i2++) {
                    int i3 = 1 << i2;
                    if ((i3 & i) != 0) {
                        useSensor(i3, CONFIG_READ_SETTINGS);
                        synchronized (this.mLockEngine) {
                            if (this.mEngineInitialized) {
                                enableSensor(i3, CONFIG_READ_SETTINGS);
                            }
                        }
                    }
                }
            }
        }
    }

    public void unregisterCallback(IBinder iBinder) {
        Listener listener;
        String listenerInfo;
        if (this.mEngineIsAvailable) {
            synchronized (this.mListeners) {
                Iterator it = this.mListeners.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        listener = null;
                        break;
                    } else {
                        listener = (Listener) it.next();
                        if (iBinder == listener.mToken) {
                            break;
                        }
                    }
                }
                if (listener == null) {
                    listenerInfo = "";
                } else {
                    iBinder.unlinkToDeath(listener, 0);
                    this.mListeners.remove(listener);
                    try {
                        listenerInfo = IMotionRecognitionCallback.Stub.asInterface(iBinder).getListenerInfo();
                    } catch (RemoteException e) {
                        listenerInfo = "";
                    }
                    Slog.d(TAG, "  .unregisterCallback : " + this.mListeners.size() + ", client=" + listenerInfo);
                    this.mListeners.notify();
                }
                disableUnusedSensors();
                if ((listenerInfo.contains("com.android.motionservicetestGyro") || listenerInfo.contains("com.android.server.NotificationManagerService") || listenerInfo.contains("com.android.pickuptutorial.PickUpBlackScreen")) && this.mEnableAccINT) {
                    Slog.e(TAG, " Cancel reactive alert mode ");
                    disableAccINT();
                    this.mFlatEvent = false;
                }
                if (this.mListeners.size() == 0) {
                    finalizeIfPossible();
                }
            }
        }
    }

    public void useMotionAlways(IBinder iBinder, boolean z) {
        if (this.mEngineIsAvailable) {
            Listener listener = null;
            synchronized (this.mListeners) {
                Iterator it = this.mListeners.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Listener listener2 = (Listener) it.next();
                    if (iBinder == listener2.mToken) {
                        listener = listener2;
                        break;
                    }
                }
                String listenerInfo = "";
                try {
                    listenerInfo = IMotionRecognitionCallback.Stub.asInterface(iBinder).getListenerInfo();
                } catch (RemoteException e) {
                }
                if (listener != null) {
                    listener.mUseAlways = z;
                    Slog.d(TAG, "  .useMotionAlways : " + listener.mUseAlways + ", client=" + listenerInfo);
                } else {
                    Slog.d(TAG, "  .useMotionAlways : unregistered client, " + listenerInfo);
                }
                this.mListeners.notify();
            }
        }
    }

    public void setMotionAngle(IBinder iBinder, int i) {
        if (this.mEngineIsAvailable) {
            Listener listener = null;
            synchronized (this.mListeners) {
                Iterator it = this.mListeners.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Listener listener2 = (Listener) it.next();
                    if (iBinder == listener2.mToken) {
                        listener = listener2;
                        break;
                    }
                }
                String listenerInfo = "";
                try {
                    listenerInfo = IMotionRecognitionCallback.Stub.asInterface(iBinder).getListenerInfo();
                } catch (RemoteException e) {
                }
                if (listener != null) {
                    native_set_motion_angle(i);
                    Slog.i(TAG, "  .setMotionAngle : " + i + ", client=" + listenerInfo);
                }
                this.mListeners.notify();
            }
        }
    }

    public void setMotionTiltLevel(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.mEngineIsAvailable) {
            Slog.d(TAG, " @ " + i + ", " + i2 + ", " + i3 + ", " + i4 + ", " + i5 + ", " + i6);
            native_set_tilt_level(i, i2, i3, i4, i5, i6);
            Slog.d(TAG, "  .setMotionTiltLevel : 2");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finalizeIfPossible() {
        if (this.mEngineInitialized) {
            finalizeMotionEngine();
        }
    }

    protected void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        printWriter.println("motion_recognition");
        printWriter.println(" : mEngineInitialized=" + this.mEngineInitialized + ", mEngineIsAvailable=" + this.mEngineIsAvailable);
        printWriter.println(" : mSensorsUsed=" + this.mSensorsUsed + ", mSensorsEnabled=" + this.mSensorsEnabled);
        printWriter.println(" : currentTimeMillis=" + jCurrentTimeMillis + ", lastSensorEventTime=" + this.mLogTime + ", diff=" + (jCurrentTimeMillis - this.mLogTime));
        synchronized (this.mListeners) {
            printWriter.println(" : listener count=" + this.mListeners.size());
            Iterator it = this.mListeners.iterator();
            int i = 0;
            while (it.hasNext()) {
                Listener listener = (Listener) it.next();
                int i2 = i + 1;
                printWriter.println("   mListeners[" + i + "] = mMotionSensors=" + listener.mMotionSensors + ", mUseAlways=" + listener.mUseAlways);
                try {
                    printWriter.println("                   " + IMotionRecognitionCallback.Stub.asInterface(listener.mToken).getListenerInfo());
                    i = i2;
                } catch (RemoteException e) {
                    i = i2;
                }
            }
            this.mListeners.notify();
        }
    }

    public void setLogPath(String str) {
        if (str == null) {
            this.mLogPath = "";
        } else {
            this.mLogPath = str;
        }
        Slog.d(TAG, "  .setLogPath : " + this.mLogPath);
    }

    void sensorLogStart() {
        if (this.mLogPath.length() == 0) {
            this.mLogPath = SystemProperties.get("log.path.motion.sensor", "");
        }
        if (this.mLogPath != null && this.mLogPath.length() != 0) {
            synchronized (this.mLogPath) {
                File file = new File(this.mLogPath);
                try {
                    File parentFile = file.getParentFile();
                    if (parentFile != null) {
                        if (!parentFile.exists()) {
                            file.mkdirs();
                        }
                        FileUtils.setPermissions(parentFile.getPath(), 509, -1, -1);
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    FileUtils.setPermissions(file.getPath(), 438, -1, -1);
                    this.mLogPW = new PrintWriter(file);
                    Slog.d(TAG, "  .sensorLogStart : started - " + this.mLogPath);
                } catch (IOException e) {
                    Slog.d(TAG, "  .sensorLogStart : " + e + " - " + this.mLogPath);
                    this.mLogPW = null;
                }
            }
        }
    }

    void sensorLogWrite() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.mLogTime;
        if (j < 0 || j > 1000) {
            j = 0;
        }
        this.mLogTime = jCurrentTimeMillis;
        synchronized (this.mLogPath) {
            if (this.mLogPW != null) {
                this.mLogPW.print(String.format("%.6f\t%.6f\t%.6f\t%.6f\t%.6f\t%.6f\t%h\t%d\t%B\t%d\r\n", Double.valueOf(this.mPostAccelVal[0]), Double.valueOf(this.mPostAccelVal[1]), Double.valueOf(this.mPostAccelVal[2]), Double.valueOf(this.mPostGyroVal[0]), Double.valueOf(this.mPostGyroVal[1]), Double.valueOf(this.mPostGyroVal[2]), Short.valueOf(this.mPostProxVal), Integer.valueOf(this.mPostLightVal), Boolean.valueOf(this.mPostTouch), Long.valueOf(j)));
            }
        }
    }

    void sensorLogEnd() {
        synchronized (this.mLogPath) {
            if (this.mLogPW != null) {
                this.mLogPW.close();
                this.mLogPW = null;
            }
        }
    }

    private boolean isSensorUsed(int i) {
        if (MotionRecognitionManager.isValidMotionSensor(i) && (this.mSensorsUsed & i) == i) {
            return CONFIG_READ_SETTINGS;
        }
        return false;
    }

    private boolean isSensorEnabled(int i) {
        if (MotionRecognitionManager.isValidMotionSensor(i) && (this.mSensorsEnabled & i) == i) {
            return CONFIG_READ_SETTINGS;
        }
        return false;
    }

    private void useSensor(int i, boolean z) {
        if (MotionRecognitionManager.isValidMotionSensor(i) && z != isSensorUsed(i)) {
            if (z) {
                this.mSensorsUsed |= i;
            } else {
                this.mSensorsUsed &= i ^ (-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableSensor(int i, boolean z) {
        if (MotionRecognitionManager.isValidMotionSensor(i) && z != isSensorEnabled(i)) {
            if (z) {
                if (isSensorUsed(i)) {
                    this.mSensorsEnabled |= i;
                    if (i == 1) {
                        this.sensorManager.registerListener(this.sensorAccelerometerListener, this.sensorManager.getDefaultSensor(1), this.mSensorDelayInMsec * 1000, this.mHandler);
                        return;
                    }
                    if (i == 2) {
                        this.sensorManager.registerListener(this.sensorGyroscopeListener, this.sensorManager.getDefaultSensor(4), this.mSensorDelayInMsec * 1000, this.mHandler, 1);
                        return;
                    } else if (i == 4) {
                        this.sensorManager.registerListener(this.sensorProximityListener, this.sensorManager.getDefaultSensor(8), this.mSensorDelayInMsec * 1000, this.mHandler);
                        return;
                    } else {
                        if (i == 8) {
                            this.sensorManager.registerListener(this.sensorLightListener, this.sensorManager.getDefaultSensor(5), this.mSensorDelayInMsec * 1000, this.mHandler);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            this.mSensorsEnabled &= i ^ (-1);
            if (i == 1) {
                this.sensorManager.unregisterListener(this.sensorAccelerometerListener);
                return;
            }
            if (i == 2) {
                this.sensorManager.unregisterListener(this.sensorGyroscopeListener);
            } else if (i == 4) {
                this.sensorManager.unregisterListener(this.sensorProximityListener);
            } else if (i == 8) {
                this.sensorManager.unregisterListener(this.sensorLightListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableAllSensors(boolean z) {
        for (int i = 0; i < 4; i++) {
            enableSensor(1 << i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disableUnusedSensors() {
        if (this.mListeners.size() == 0) {
            for (int i = 0; i < 4; i++) {
                useSensor(1 << i, false);
            }
            enableAllSensors(false);
            return;
        }
        Iterator it = this.mListeners.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 = ((Listener) it.next()).mMotionSensors | i2;
        }
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = 1 << i3;
            if ((i2 & i4) == 0 && isSensorUsed(i4)) {
                useSensor(i4, false);
                enableSensor(i4, false);
            }
        }
    }

    final class Listener implements IBinder.DeathRecipient {
        final int mMotionSensors;
        final IBinder mToken;
        boolean mUseAlways = false;

        Listener(IBinder iBinder, int i) {
            this.mToken = iBinder;
            this.mMotionSensors = i;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            synchronized (MotionRecognitionService.this.mListeners) {
                MotionRecognitionService.this.mListeners.remove(this);
                Slog.d(MotionRecognitionService.TAG, "  .binderDied : " + MotionRecognitionService.this.mListeners.size());
                this.mToken.unlinkToDeath(this, 0);
                MotionRecognitionService.this.mListeners.notify();
                MotionRecognitionService.this.disableUnusedSensors();
            }
        }

        public void callback(MREvent mREvent) {
            mREvent.getMotion();
            switch (mREvent.getMotion()) {
                case 1:
                case 10:
                case MREvent.SHAKE_START /* 35 */:
                case MREvent.SHAKE_STOP /* 36 */:
                    if ((this.mMotionSensors & 1) == 0) {
                        return;
                    }
                    break;
                case MREvent.PANNING_GYRO /* 61 */:
                case MREvent.TILT /* 72 */:
                    if ((this.mMotionSensors & 2) == 0) {
                        return;
                    }
                    break;
            }
            try {
                IMotionRecognitionCallback.Stub.asInterface(this.mToken).motionCallback(mREvent);
            } catch (RemoteException e) {
            }
        }
    }

    final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MREvent mREvent = (MREvent) message.obj;
            synchronized (MotionRecognitionService.this.mListeners) {
                Iterator it = MotionRecognitionService.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((Listener) it.next()).callback(mREvent);
                }
                MotionRecognitionService.this.mEventPool.recycle(mREvent);
                MotionRecognitionService.this.mListeners.notify();
            }
        }
    }

    final class EventPool {
        static final int POOL_SIZE = 10;
        Object mLockEventPool = new Object();
        MREvent[] events = new MREvent[10];

        public EventPool() {
            for (int i = 0; i < 10; i++) {
                this.events[i] = new MREvent();
            }
        }

        public MREvent obtain() {
            MREvent mREvent = null;
            synchronized (this.mLockEventPool) {
                int i = 0;
                while (true) {
                    if (i >= 10) {
                        break;
                    }
                    if (this.events[i] == null) {
                        i++;
                    } else {
                        mREvent = this.events[i];
                        this.events[i] = null;
                        break;
                    }
                }
            }
            if (mREvent == null) {
                return new MREvent();
            }
            return mREvent;
        }

        public void recycle(MREvent mREvent) {
            synchronized (this.mLockEventPool) {
                int i = 0;
                while (true) {
                    if (i >= 10) {
                        break;
                    }
                    if (this.events[i] != null) {
                        i++;
                    } else {
                        this.events[i] = mREvent;
                        break;
                    }
                }
            }
        }
    }
}
