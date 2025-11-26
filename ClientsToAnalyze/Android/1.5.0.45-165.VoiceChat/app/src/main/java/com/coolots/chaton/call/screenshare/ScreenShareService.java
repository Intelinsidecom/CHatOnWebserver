package com.coolots.chaton.call.screenshare;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.screenshare.util.ScreenShareMessageReceiver;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sec.chaton.clientapi.NotificationAPI;
import com.sec.chaton.clientapi.exception.NotActivatedClientAPIException;
import com.sec.chaton.clientapi.exception.NotAvailableClientAPIException;

/* loaded from: classes.dex */
public class ScreenShareService extends Service {
    public static final String CHECK_KEYGUARD_LOCK = "com.coolots.chaton.call.screenshare.ckeckkeyguard";
    private static final String CLASSNAME = "[ScreenShareService]";
    public static final String LOCK_SCREEN_UNLOCK = "com.coolots.chaton.call.screenshare.unlockscreen";
    public static ScreenShareService mInstance;
    public static PowerManager mPowerManager = null;
    public static PowerManager.WakeLock mWakeLock = null;
    private int mCurOrientation;
    private OrientationEventListener mOrientation;
    private ScreenShareProc mScreenShareProc;
    private boolean mRunMode = false;
    private ScreenLockReceiver mScreenLockReceiver = null;
    public WindowManager windowManager = null;
    private ScreenShareMessageReceiver mScreenShareMessageReceiver = null;

    private static void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.app.Service
    public void onCreate() throws IntentFilter.MalformedMimeTypeException {
        super.onCreate();
        logI("ScreenShareService onCreate");
        this.mCurOrientation = getSystemBarOrientation();
        this.mOrientation = new OrientationEventListener(MainApplication.mContext) { // from class: com.coolots.chaton.call.screenshare.ScreenShareService.1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int orientation) {
                int dir = ScreenShareService.this.getSystemBarOrientation();
                if (dir != ScreenShareService.this.mCurOrientation) {
                    try {
                        ScreenShareService.logI("onOrientationChanged orientation=" + dir);
                        ScreenShareService.this.mScreenShareProc.setScreenRotation();
                        ScreenShareService.this.mCurOrientation = dir;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.mOrientation.enable();
        IntentFilter filter = new IntentFilter("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.SCREEN_OFF");
        filter.addAction("android.intent.action.USER_PRESENT");
        filter.addAction(LOCK_SCREEN_UNLOCK);
        filter.addAction(CHECK_KEYGUARD_LOCK);
        this.mScreenLockReceiver = new ScreenLockReceiver(this, null);
        registerReceiver(this.mScreenLockReceiver, filter);
        registScreenShareMessageReceiver();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        int dir = -1;
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == 1) {
            logI("onConfigurationChanged Configuration.ORIENTATION_PORTRAIT");
            dir = getSystemBarOrientation();
        } else if (newConfig.orientation == 2) {
            logI("onConfigurationChanged Configuration.ORIENTATION_LANDSCAPE");
            dir = getSystemBarOrientation();
        }
        if (dir != -1 && dir != this.mCurOrientation) {
            this.mScreenShareProc.setScreenRotation();
            this.mCurOrientation = dir;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            stopSelf();
        } else {
            int startMode = intent.getIntExtra("StartMode", -1);
            logI("ScreenShareService startMode " + startMode);
            if (startMode == 0 || startMode == 2) {
                if (!this.mRunMode) {
                    this.mRunMode = true;
                    this.mScreenShareProc = ScreenShareProc.getInstance();
                    if (!this.mScreenShareProc.getStart()) {
                        logI("ScreenShareService mScreenShareProc.getStart() false");
                        stopSelf();
                    } else {
                        getSystemPowermanager();
                        getSystemWakeLock();
                        acquireWakelock();
                        this.mScreenShareProc.setService(this);
                        this.mScreenShareProc.startShare();
                        ScreenShareProc.showToast(C0000R.string.screenshare_start, 1);
                        if (getApplication().getResources().getConfiguration().orientation == 1) {
                            logI("ScreenShareService Configuration.ORIENTATION_PORTRAIT");
                        } else {
                            logI("ScreenShareService Configuration.ORIENTATION_LANDSCAPE");
                        }
                    }
                }
            } else if (!this.mRunMode) {
                stopSelf();
            }
        }
        return 2;
    }

    @Override // android.app.Service
    public void onDestroy() throws Resources.NotFoundException {
        super.onDestroy();
        logI("ScreenShareService onDestroy");
        if (this.mScreenShareProc != null) {
            this.mScreenShareProc.stop();
            try {
                ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_end), 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mScreenShareProc = null;
        }
        if (this.mOrientation != null) {
            this.mOrientation.disable();
            this.mOrientation = null;
        }
        releaseWakelock();
        unregistScreenShareMessageReceiver();
        try {
            unregisterReceiver(this.mScreenLockReceiver);
        } catch (IllegalArgumentException e2) {
            logE("IllegalArgumentException \n e");
        }
        mPowerManager = null;
    }

    public void getSystemPowermanager() {
        logI("WAKE LOCK - getSystemPowermanager");
        if (mPowerManager == null) {
            mPowerManager = (PowerManager) MainApplication.mContext.getSystemService("power");
        }
    }

    public void getSystemWakeLock() {
        if (mPowerManager != null) {
            logI("WAKE LOCK - getSystemWakeLock");
            mWakeLock = mPowerManager.newWakeLock(10, MainApplication.mContext.getClass().getName());
        }
    }

    public static void acquireWakelock() {
        logI("WAKE LOCK - acquireWakelock");
        if (mWakeLock == null) {
            mWakeLock = mPowerManager.newWakeLock(10, MainApplication.mContext.getClass().getName());
        }
        mWakeLock.acquire();
    }

    public static void releaseWakelock() {
        if (mWakeLock != null) {
            logI("WAKE LOCK - releaseWakelock");
            mWakeLock.release();
            mWakeLock = null;
        }
    }

    public int getSystemBarOrientation() {
        if (this.windowManager == null) {
            this.windowManager = (WindowManager) getSystemService("window");
        }
        Display display = this.windowManager.getDefaultDisplay();
        int rotation = ((4 - display.getRotation()) % 4) * 90;
        logI("getSystemBarOrientation() return: " + rotation);
        return rotation;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent arg0) {
        return null;
    }

    private void registScreenShareMessageReceiver() throws IntentFilter.MalformedMimeTypeException {
        logI("registScreenShareMessageReceiver()");
        this.mScreenShareMessageReceiver = new ScreenShareMessageReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ScreenShareMessageReceiver.PUSH_RECEIVED);
        intentFilter.addAction(ScreenShareMessageReceiver.SMS_RECEIVED);
        try {
            NotificationAPI.register(this, getPackageName(), null);
            intentFilter.addAction(ScreenShareMessageReceiver.CHATON_MSG_RECEIVED);
        } catch (NotActivatedClientAPIException e1) {
            logE("Receiver couldn't regist to ChatON due to NotActivatedClientAPIException \n " + e1);
        } catch (NotAvailableClientAPIException e12) {
            logE("Receiver couldn't regist to ChatON because of NotAvailableClientAPIException \n" + e12);
        }
        try {
            intentFilter.addDataType("application/vnd.wap.mms-message");
        } catch (IntentFilter.MalformedMimeTypeException e) {
            e.printStackTrace();
        }
        MainApplication.mContext.registerReceiver(this.mScreenShareMessageReceiver, intentFilter);
    }

    private void unregistScreenShareMessageReceiver() {
        logI("unregistScreenShareMessageReceiver()");
        try {
            NotificationAPI.deregister(this, getPackageName());
            MainApplication.mContext.unregisterReceiver(this.mScreenShareMessageReceiver);
        } catch (NotActivatedClientAPIException e) {
            logE("Receiver couldn't deregist to ChatON due to NotActivatedClientAPIException \n " + e);
        } catch (NotAvailableClientAPIException e2) {
            logE("Receiver couldn't deregist to ChatON because of NotAvailableClientAPIException \n" + e2);
        } catch (IllegalArgumentException e3) {
            logE("IllegalArgumentException \n e");
        }
    }

    private class ScreenLockReceiver extends BroadcastReceiver {
        private ScreenLockReceiver() {
        }

        /* synthetic */ ScreenLockReceiver(ScreenShareService screenShareService, ScreenLockReceiver screenLockReceiver) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            ScreenShareService.logI("ScreenLockReceiver onReceive action? " + action);
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                ScreenShareService.this.mScreenShareProc.setVisibilityMainButton(false);
                MainApplication.mPhoneManager.getShareScreenManager().pauseShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), 0);
                return;
            }
            if (!"android.intent.action.SCREEN_ON".equals(action)) {
                if ("android.intent.action.USER_PRESENT".equals(action)) {
                    ScreenShareService.this.mScreenShareProc.setVisibilityMainButton(true);
                    MainApplication.mPhoneManager.getShareScreenManager().resumeShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), null, false);
                } else if (ScreenShareService.LOCK_SCREEN_UNLOCK.equals(action)) {
                    ScreenShareService.this.mScreenShareProc.setVisibilityMainButton(true);
                } else if (ScreenShareService.CHECK_KEYGUARD_LOCK.equals(action)) {
                    ScreenShareService.this.mScreenShareProc.checkKeyguardLockStatus();
                }
            }
        }
    }
}
