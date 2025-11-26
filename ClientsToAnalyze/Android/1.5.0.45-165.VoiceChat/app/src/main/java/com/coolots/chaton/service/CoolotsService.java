package com.coolots.chaton.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import com.coolots.chaton.common.controller.CoolotsCallStateEventReceiver;
import com.coolots.chaton.common.controller.CoolotsEventReceiver;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.ChatOnConfigInterface;
import com.coolots.chaton.common.view.ConfigActivity;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.model.ConfFileName;
import com.sds.coolots.common.model.IntentName;
import com.sds.coolots.common.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class CoolotsService extends Service {
    private static final String CLASSNAME = "[CoolotsService]";
    public static final int DELAY_TO_RESTART_SERVICE = 5000;
    public static final String QUICKPANELDELETE_ACTION = "QUICKPANELDELETE_ACTION";
    public static final String QUICKPANELSHOW_ACTION = "QUICKPANELSHOW_ACTION";
    private CoolotsCallStateEventReceiver mCoolotsCallStateReceiver;
    private CoolotsEventReceiver mCoolotsEventReceiver;
    private BroadcastReceiver quickPanelReceiver = new BroadcastReceiver() { // from class: com.coolots.chaton.service.CoolotsService.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null) {
                if (action.equals(CoolotsService.QUICKPANELSHOW_ACTION)) {
                    CoolotsService.this.logI("startForeground()");
                    CoolotsService.this.startForeground(1001, MainApplication.mCallNotification.getQuickPanelNotification());
                } else if (action.equals(CoolotsService.QUICKPANELDELETE_ACTION)) {
                    CoolotsService.this.logI("stopForeground()");
                    CoolotsService.this.stopForeground(true);
                }
            }
        }
    };
    private final Handler mHandler = new Handler() { // from class: com.coolots.chaton.service.CoolotsService.2
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Log.m2958e("<<YHT2>> BUDDY_TRACE CoolotsService handleMessage");
            CoolotsService.this.executeAfterCopyAsset();
            super.handleMessage(msg);
        }
    };

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        logI("CoolotsService onStartCommand started!!!!!");
        if (MainApplication.mPhoneManager.getClientType() == 2) {
            logI("CoolotsService onStartCommand START_NOT_STICKY!!!!!");
            return 2;
        }
        logI("CoolotsService onStartCommand START_STICKY!!!!!");
        return 1;
    }

    @Override // android.app.Service
    public void onCreate() {
        logI("CoolotsService started.");
        super.onCreate();
        initialize();
        if (MainApplication.mPhoneManager.getClientType() != 2) {
            ((VAppPhoneManager) MainApplication.mPhoneManager).initBRManager(this);
            ((VAppPhoneManager) MainApplication.mPhoneManager).registerBR();
        }
        try {
            unregisterReceiver(this.quickPanelReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(QUICKPANELSHOW_ACTION);
        filter.addAction(QUICKPANELDELETE_ACTION);
        registerReceiver(this.quickPanelReceiver, filter);
        if (MainApplication.mConfig.isFixedLCDFrame() && MainApplication.mContext != null) {
            Intent boostIntent = new Intent();
            boostIntent.setAction("com.sec.android.intent.action.SSRM_REQUEST");
            boostIntent.putExtra("SSRM_STATUS_NAME", "ChatOnV_vtCall");
            boostIntent.putExtra("SSRM_STATUS_VALUE", false);
            boostIntent.putExtra("PackageName", MainApplication.mContext.getApplicationInfo().packageName);
            boostIntent.putExtra("PID", Process.myPid());
            MainApplication.mContext.sendBroadcast(boostIntent);
        }
    }

    private void initialize() {
        logI("<<YHT2>> CoolotsService is initialized.");
        boolean startLogin = copyConfigurationFiles();
        MainApplication.mPhoneManager.getLoginManager().checkNonceExpiredTimePassed();
        if (startLogin) {
            logI("<<YHT2>> copyConfigurationFiles returns true!!!");
            registerBroadcastReceiver();
            if (PhoneManager.isNetworkConnected(this)) {
                MainApplication.mPhoneManager.getLoginManager().login();
                return;
            }
            return;
        }
        logI("<<YHT2>> copyConfigurationFiles returns false!!!");
    }

    private boolean isPackageNewInstalled(String localPath, String localPathFaceEmotion) {
        if (ConfigActivity.getAssetVersion() == MainApplication.mPhoneManager.getAssetVersion()) {
            return false;
        }
        deleteFiles(localPath);
        deleteFiles(localPathFaceEmotion);
        return true;
    }

    private void deleteFiles(String localPath) {
        if (localPath != null) {
            logI("deleteFiles() is started");
            File localFile = new File(localPath);
            String[] files = localFile.list();
            if (files != null) {
                for (String str : files) {
                    deleteFiles(String.valueOf(localPath) + '/' + str);
                }
            }
            if (localFile.delete()) {
                logI("localPath is deleted");
            }
            logI("deleteFiles() is stopped");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copyFiles(AssetManager assetMgr, String assetPath, String localPath) throws Throwable {
        String assetFullPath;
        OutputStream out;
        InputStream instream = null;
        byte[] buffer = new byte[1048576];
        if (assetMgr == null || assetPath == null || localPath == null) {
            logI("Invalid parameters in copyFiles");
            return;
        }
        logI("CopyFiles() is started");
        File localDir = new File(localPath);
        localDir.mkdirs();
        try {
            String[] assetFiles = assetMgr.list(assetPath);
            int i = 0;
            OutputStream out2 = null;
            while (i < assetFiles.length) {
                try {
                    String localFullPath = String.valueOf(localPath) + "/" + assetFiles[i];
                    if (assetPath.length() == 0) {
                        assetFullPath = assetFiles[i];
                    } else {
                        assetFullPath = String.valueOf(assetPath) + "/" + assetFiles[i];
                    }
                    String[] subAssetFiles = assetMgr.list(assetFullPath);
                    if (subAssetFiles.length > 0) {
                        copyFiles(assetMgr, assetFullPath, localFullPath);
                        out = out2;
                    } else {
                        File localFile = new File(localFullPath);
                        try {
                            instream = assetMgr.open(assetFullPath);
                            out = new FileOutputStream(localFile);
                            if (instream == null || out == null) {
                                logI("Failed to open file stream");
                            } else {
                                while (true) {
                                    try {
                                        try {
                                            int read = instream.read(buffer);
                                            if (read == -1) {
                                                break;
                                            } else {
                                                out.write(buffer, 0, read);
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            e.printStackTrace();
                                            if (instream != null) {
                                                instream.close();
                                                instream = null;
                                            }
                                            if (out != null) {
                                                out.flush();
                                                out.close();
                                                out = null;
                                            }
                                            logI("Copy " + assetFullPath + " file to " + localFullPath);
                                            i++;
                                            out2 = out;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        if (instream != null) {
                                            instream.close();
                                        }
                                        if (out != null) {
                                            out.flush();
                                            out.close();
                                        }
                                        throw th;
                                    }
                                }
                            }
                            if (instream != null) {
                                instream.close();
                                instream = null;
                            }
                            if (out != null) {
                                out.flush();
                                out.close();
                                out = null;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            out = out2;
                        } catch (Throwable th2) {
                            th = th2;
                            out = out2;
                        }
                        logI("Copy " + assetFullPath + " file to " + localFullPath);
                    }
                    i++;
                    out2 = out;
                } catch (Exception e3) {
                    logI("Failed to copy assets to local file system because of unknown exception");
                    return;
                }
            }
            logI("CopyFiles() is stopped");
        } catch (Exception e4) {
        }
    }

    private boolean copyConfigurationFiles() {
        logI("<<YHT2>> CopyConfigurationFiles() is started");
        final AssetManager assetMgr = getAssets();
        if (assetMgr == null) {
            logI("<<YHT2>> AssetManager is null");
            return true;
        }
        final String localPath = String.valueOf(MainApplication.mContext.getFilesDir().getAbsolutePath()) + "/" + ConfFileName.ANIMATION_CONFIG_DIR_PATH;
        final String localPathFaceEmotion = String.valueOf(MainApplication.mContext.getFilesDir().getAbsolutePath()) + "/" + ConfFileName.FACE_EMOTION_CONFIG_DIR_PATH;
        if (isPackageNewInstalled(localPath, localPathFaceEmotion)) {
            logI("<<YHT2>> isPackageNewInstalled return true");
            new Thread(new Runnable() { // from class: com.coolots.chaton.service.CoolotsService.3
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    CoolotsService.this.copyFiles(assetMgr, ConfFileName.ANIMATION_CONFIG_DIR_PATH, localPath);
                    CoolotsService.this.copyFiles(assetMgr, ConfFileName.FACE_EMOTION_CONFIG_DIR_PATH, localPathFaceEmotion);
                    CoolotsService.this.mHandler.sendEmptyMessage(1);
                }
            }).start();
            ConfigActivity.setAssetVersion(MainApplication.mPhoneManager.getAssetVersion());
        } else {
            logI("<<YHT2>> isPackageNewInstalled return false");
            this.mHandler.sendEmptyMessage(1);
        }
        logI("<<YHT2>> CopyConfigurationFiles() is stopped");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeAfterCopyAsset() {
        Log.m2958e("<<YHT2>> executeAfterCopyAsset!!!");
        registerBroadcastReceiver();
        if (PhoneManager.isNetworkConnected(MainApplication.mContext)) {
            MainApplication.mPhoneManager.getLoginManager().login();
        }
    }

    private void registerBroadcastReceiver() {
        logI("<<YHT2>> registerBroadcastReceiver");
        MainApplication.mPhoneManager.getPhoneStateMachine();
        this.mCoolotsEventReceiver = new CoolotsEventReceiver();
        IntentFilter intentfilter_0 = new IntentFilter();
        intentfilter_0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentfilter_0.addAction("android.intent.action.BATTERY_CHANGED");
        intentfilter_0.addAction("android.intent.action.HEADSET_PLUG");
        intentfilter_0.addAction("android.intent.action.LOCALE_CHANGED");
        intentfilter_0.addAction("android.intent.action.USER_PRESENT");
        intentfilter_0.addAction("android.intent.action.SCREEN_OFF");
        intentfilter_0.addAction("android.intent.action.SCREEN_ON");
        intentfilter_0.addAction("android.intent.action.NEW_OUTGOING_CALL");
        intentfilter_0.addAction("android.intent.action.MEDIA_MOUNTED");
        intentfilter_0.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentfilter_0.addAction("android.intent.action.MEDIA_EJECT");
        intentfilter_0.addAction("android.net.wifi.STATE_CHANGE");
        intentfilter_0.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentfilter_0.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentfilter_0.addAction("android.net.conn.BACKGROUND_DATA_SETTING_CHANGED");
        intentfilter_0.addAction(IntentName.ACTION_ALARM_GOES_OFF);
        intentfilter_0.addAction(IntentName.ACTION_ALARM_NONCE_TIME);
        intentfilter_0.addAction(IntentName.ACTION_ALARM_NONCE_DELETE_TIME);
        intentfilter_0.addAction(IntentName.ACTION_ALARM_PUSH_REREGISTER);
        intentfilter_0.addAction(IntentName.ACTION_CHAT_NOTI_CLICK);
        intentfilter_0.addAction("android.intent.action.AIRPLANE_MODE");
        intentfilter_0.addAction(IntentName.ACTION_ALARM_PREVENT_UMTS);
        intentfilter_0.addAction("android.intent.action.HEADSET_PLUG");
        intentfilter_0.addAction("android.intent.action.DOCK_EVENT");
        intentfilter_0.addAction(((ChatOnConfigInterface) MainApplication.mConfig).getBTConnectActionName());
        intentfilter_0.addAction(((ChatOnConfigInterface) MainApplication.mConfig).getBTAudioPathActionName());
        registerReceiver(this.mCoolotsEventReceiver, intentfilter_0);
        IntentFilter intentfilter_1 = new IntentFilter();
        this.mCoolotsCallStateReceiver = new CoolotsCallStateEventReceiver();
        intentfilter_1.addAction(CoolotsCallStateEventReceiver.ACTION_PHONE_STATE_CHANGED);
        intentfilter_1.addAction(CoolotsCallStateEventReceiver.ACTION_SS_INFO_CLI);
        intentfilter_1.setPriority(100);
        registerReceiver(this.mCoolotsCallStateReceiver, intentfilter_1);
    }

    @Override // android.app.Service
    public void onDestroy() {
        logI("CoolotsService is destroyed.");
        try {
            unregisterReceiver(this.mCoolotsEventReceiver);
            unregisterReceiver(this.mCoolotsCallStateReceiver);
            unregisterReceiver(this.quickPanelReceiver);
        } catch (IllegalArgumentException e) {
            logE("IllegalArgumentException \n e");
        }
        if (MainApplication.mPhoneManager.getClientType() != 2) {
            ((VAppPhoneManager) MainApplication.mPhoneManager).unregisterBR();
        }
        super.onDestroy();
    }
}
