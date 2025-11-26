package com.coolots.chaton.call.screenshare;

import android.app.Instrumentation;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.screenshare.activity.ScreenShareActivity;
import com.coolots.chaton.call.screenshare.core.OverlayView;
import com.coolots.chaton.call.screenshare.util.AlertView;
import com.coolots.chaton.call.screenshare.util.BoardDataController;
import com.coolots.chaton.call.screenshare.util.PenWriteNetwork;
import com.coolots.chaton.call.screenshare.util.ScreenShareMessageReceiver;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.coolots.chaton.call.screenshare.util.ScreenShareRemotePacket;
import com.coolots.chaton.call.screenshare.util.ScreenShareToast;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.screenshare.ScreenShareProcInterface;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import com.sec.spp.push.Config;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes.dex */
public class ScreenShareProc implements ScreenShareProcInterface, DisposeInterface {
    private static final String CLASSNAME = "[ScreenShareProc]";
    public static final int NOT_REMOTE_SHARE_SHARE_MODE = 0;
    public static final int REJECT_REMOTE_SHARE_MODE = 2;
    public static final int REMOTE_SHARE_SHARE_MODE = 1;
    public static final int SCREEN_DOCS_MODE = 200;
    public static final int SCREEN_DOCS_PEN_MODE = 201;
    public static final int SCREEN_SHARE_DRAWING_MODE = 101;
    private static final int SCREEN_SHARE_ONSTOP = 4000;
    public static final int SCREEN_SHARE_SHARE_MODE = 100;
    public static long gDownTime;
    private static AlertView mAlertView;
    public static ScreenShareProc mInstance;
    public static Service mThisService;
    private BoardDataController mBoardDataController;
    private byte[] mCommandData;
    public int mCurrentMode;
    private Instrumentation mInstrumentation;
    private int mIsRemote;
    private MainHandler mMainHandler;
    private PenWritingView mPenWritingView;
    private QuickShareView mQuickShareView;
    private AlertView mRemoteAlertView;
    private Handler mRemoteControlAlertDialogTimerHandler;
    private Runnable mRemoteControlAlertDialogTimerRunnable;
    private RemoteThread mRemoteThread;
    private ScreenSharePopupMenu mScreenSharePopupMenu;
    private ScreenShareView mScreenShareView;
    private ScreenShareToast mSecureToast;
    private byte[] mSendData;
    private int mShareMode;
    private PenWriteNetwork mWriteNetwork;
    private static int mUserID = 1;
    public static int mOtherStateMode = 0;
    private static int mScreenMode = 0;
    private boolean bStartShare = false;
    private DocsViewActivity mDocsViewActivity = null;
    private String mUserIdName = "";
    private Queue<MotionEvent> mRemoteQ = new LinkedList();
    private boolean mOtherPenWriteMode = false;
    public int mOtherPauseType = 0;
    private int mPauseType = 0;
    private KeyguardManager mKeyguardManager = null;
    PenWriteNetwork.OnRecvDataCB onRecvDataCB = new PenWriteNetwork.OnRecvDataCB() { // from class: com.coolots.chaton.call.screenshare.ScreenShareProc.1
        @Override // com.coolots.chaton.call.screenshare.util.PenWriteNetwork.OnRecvDataCB
        public void onRecvData(byte[] data, int len) throws Resources.NotFoundException {
            ScreenSharePacket packet = ScreenSharePacket.parserPacket(data);
            ScreenShareProc.logI("onRecvDataCB CMD : " + packet.getCommand());
            switch (packet.getCommand()) {
                case 400:
                case ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_START /* 410 */:
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_DRAWING_REQ_MODE /* 401 */:
                    if (ScreenShareProc.mOtherStateMode != 3 && ScreenShareProc.mOtherStateMode != 2 && ScreenShareProc.mOtherStateMode != 2) {
                        ScreenShareProc.this.mOtherPenWriteMode = true;
                        ScreenShareProc.mOtherStateMode = 1;
                        if (ScreenShareProc.this.mPauseType == 0) {
                            ScreenShareProc.this.setPenWritingView(true);
                        }
                        byte[] cmdData = PenWriteNetwork.intToByte(ScreenShareProc.mUserID);
                        byte[] sendData = ScreenSharePacket.makePacket(ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_DRAWING_RESP_MODE, cmdData);
                        ScreenShareProc.this.mWriteNetwork.sendData(sendData);
                        ScreenShareProc.logI("Data Flow = send response penwriting open");
                        break;
                    } else {
                        byte[] packetData = ScreenSharePacket.makeStringPacket(MainApplication.mConfig.getProfileUserName());
                        ScreenShareProc.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_START, packetData);
                        break;
                    }
                case ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_DRAWING_RESP_MODE /* 402 */:
                    ScreenShareProc.logI("SCREEN_SHARE_CMD_CHANGE_DRAWING_RESP_MODE mOtherStateMode: " + ScreenShareProc.mOtherStateMode);
                    if (ScreenShareProc.mOtherStateMode != 3 && ScreenShareProc.mOtherStateMode != 2 && ScreenShareProc.mOtherStateMode != 2) {
                        ScreenShareProc.this.mOtherPenWriteMode = true;
                        ScreenShareProc.mOtherStateMode = 0;
                        if (ScreenShareProc.this.mPauseType == 0) {
                            ScreenShareProc.this.setPenWritingView(true);
                            break;
                        }
                    } else {
                        byte[] packetData2 = ScreenSharePacket.makeStringPacket(MainApplication.mConfig.getProfileUserName());
                        ScreenShareProc.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_START, packetData2);
                        break;
                    }
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_SHARE_MODE /* 403 */:
                    ScreenShareProc.logI("Other's PenWriting EndBtn Clicked ");
                    ScreenShareProc.this.mOtherPenWriteMode = false;
                    if ((ScreenShareProc.mOtherStateMode == 3 || ScreenShareProc.mOtherStateMode == 4) && ScreenShareProc.this.mDocsViewActivity != null) {
                        ScreenShareProc.this.mDocsViewActivity.finishDocsView();
                    }
                    ScreenShareProc.mOtherStateMode = 0;
                    ScreenShareProc.this.setPenWritingView(false);
                    break;
                case 404:
                    if (ScreenShareProc.this.mPauseType != 0) {
                        ScreenShareProc.logI("onRecvDataCB - mPauseType != OverlayView.SCREEN_SHARE_RUN_MODE");
                        ScreenShareProc.this.mIsRemote = 0;
                        ScreenShareProc.this.mCommandData = PenWriteNetwork.intToByte(ScreenShareProc.this.mIsRemote);
                        ScreenShareProc.this.mSendData = ScreenSharePacket.makePacket(ScreenSharePacket.SCREEN_SHARE_CMD_CHNAGE_REMOTE_RESP_MODE, ScreenShareProc.this.mCommandData);
                        ScreenShareProc.this.mWriteNetwork.sendData(ScreenShareProc.this.mSendData);
                        ScreenShareProc.this.mRemoteAlertView = null;
                        ScreenShareProc.this.mRemoteControlAlertDialogTimerHandler.removeCallbacks(ScreenShareProc.this.mRemoteControlAlertDialogTimerRunnable);
                        ScreenShareProc.showToast(ScreenShareProc.mThisService.getApplicationContext(), ScreenShareProc.mThisService.getString(C0000R.string.screenshare_remote_control_reject), 1);
                        break;
                    } else {
                        ScreenShareProc.this.mUserIdName = ScreenSharePacket.parserStringPacket(packet.getCommandData());
                        if (ScreenShareProc.this.mUserIdName.equals("")) {
                            ScreenShareProc.this.mUserIdName = MainApplication.mPhoneManager.getShareScreenManager().getOtherPartyName(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination());
                        }
                        if (ScreenShareProc.this.mRemoteAlertView != null) {
                            ScreenShareProc.this.mRemoteAlertView.dismiss();
                            ScreenShareProc.this.mRemoteAlertView = null;
                        }
                        ScreenShareProc.this.mRemoteAlertView = new AlertView(MainApplication.mContext);
                        ScreenShareProc.this.mRemoteAlertView.setTitle(C0000R.string.screenshare_menu_remote_btn);
                        ScreenShareProc.this.mRemoteAlertView.setMessage(ScreenShareProc.mThisService.getApplicationContext().getString(C0000R.string.screenshare_remote_control_start_popup, ScreenShareProc.this.mUserIdName));
                        ScreenShareProc.this.mRemoteAlertView.setPositiveButton(MainApplication.mContext.getString(C0000R.string.ok), new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.ScreenShareProc.1.1
                            @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                            public void onClick(AlertView dialog, int which) throws IOException {
                                Log.m2967v("startShareScreen_posi");
                                ScreenShareProc.this.mIsRemote = 1;
                                ScreenShareProc.this.mCommandData = PenWriteNetwork.intToByte(ScreenShareProc.this.mIsRemote);
                                ScreenShareProc.this.mSendData = ScreenSharePacket.makePacket(ScreenSharePacket.SCREEN_SHARE_CMD_CHNAGE_REMOTE_RESP_MODE, ScreenShareProc.this.mCommandData);
                                if (ScreenShareProc.this.mRemoteThread == null) {
                                    ScreenShareProc.this.mRemoteThread = ScreenShareProc.this.new RemoteThread();
                                }
                                ScreenShareProc.this.mRemoteThread.start();
                                ScreenShareProc.this.mWriteNetwork.sendData(ScreenShareProc.this.mSendData);
                                ScreenShareProc.this.mScreenSharePopupMenu.setViewMode(3);
                                ScreenShareProc.this.mRemoteControlAlertDialogTimerHandler.removeCallbacks(ScreenShareProc.this.mRemoteControlAlertDialogTimerRunnable);
                                ScreenShareProc.showToast(ScreenShareProc.mThisService.getApplicationContext(), ScreenShareProc.mThisService.getString(C0000R.string.screenshare_remote_control_start), 1);
                                ScreenShareProc.this.mRemoteAlertView = null;
                            }
                        });
                        ScreenShareProc.this.mRemoteAlertView.setNegativeButton(MainApplication.mContext.getString(C0000R.string.cancel), new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.ScreenShareProc.1.2
                            @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                            public void onClick(AlertView dialog, int which) {
                                ScreenShareProc.this.mIsRemote = 0;
                                ScreenShareProc.this.mCommandData = PenWriteNetwork.intToByte(ScreenShareProc.this.mIsRemote);
                                ScreenShareProc.this.mSendData = ScreenSharePacket.makePacket(ScreenSharePacket.SCREEN_SHARE_CMD_CHNAGE_REMOTE_RESP_MODE, ScreenShareProc.this.mCommandData);
                                ScreenShareProc.this.mWriteNetwork.sendData(ScreenShareProc.this.mSendData);
                                ScreenShareProc.this.mRemoteControlAlertDialogTimerHandler.removeCallbacks(ScreenShareProc.this.mRemoteControlAlertDialogTimerRunnable);
                                ScreenShareProc.showToast(ScreenShareProc.mThisService.getApplicationContext(), ScreenShareProc.mThisService.getString(C0000R.string.screenshare_remote_control_reject), 1);
                                ScreenShareProc.this.mRemoteAlertView = null;
                            }
                        });
                        ScreenShareProc.this.mRemoteAlertView.setCancelable(true);
                        ScreenShareProc.this.mRemoteAlertView.show();
                        ScreenShareProc.this.remoteControlAlertDialogTimer();
                        break;
                    }
                case ScreenSharePacket.SCREEN_SHARE_CMD_CHNAGE_REMOTE_END /* 406 */:
                    ScreenShareProc.this.mScreenSharePopupMenu.setViewMode(2);
                    ScreenShareProc.showToast(ScreenShareProc.mThisService.getApplicationContext(), ScreenShareProc.mThisService.getString(C0000R.string.screenshare_remote_control_end), 0);
                    ScreenShareProc.this.setRemoteEnd();
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_MODE /* 411 */:
                    ScreenShareProc.mOtherStateMode = 3;
                    if (ScreenShareProc.this.mPauseType == 0) {
                        ScreenShareProc.this.setDocsView(true);
                        ScreenShareProc.this.showNormalDocsView(true);
                    }
                    ScreenShareProc.this.mOtherPauseType = 0;
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_DRAWING_REQ_MODE /* 412 */:
                    ScreenShareProc.this.mOtherPenWriteMode = false;
                    ScreenShareProc.mOtherStateMode = 4;
                    if (ScreenShareProc.this.mPauseType == 0) {
                        ScreenShareProc.this.showNormalDocsView(false);
                    }
                    byte[] cmdData2 = PenWriteNetwork.intToByte(ScreenShareProc.mUserID);
                    byte[] sendData2 = ScreenSharePacket.makePacket(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_DRAWING_RESP_MODE, cmdData2);
                    ScreenShareProc.this.mWriteNetwork.sendData(sendData2);
                    if (ScreenShareProc.this.mDocsViewActivity != null) {
                        ScreenShareProc.this.mDocsViewActivity.sendDocsViewCanvasMatrix();
                        break;
                    }
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_DRAWING_RESP_MODE /* 413 */:
                    ScreenShareProc.this.mOtherPenWriteMode = false;
                    ScreenShareProc.mOtherStateMode = 4;
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_MOVE_PAGE /* 414 */:
                    if (ScreenShareProc.this.mDocsViewActivity != null) {
                        ScreenShareRemotePacket remotePacket = ScreenShareRemotePacket.parserRemoteTouch(packet.getCommandData());
                        ScreenShareProc.logI("docs other page: " + remotePacket.getType());
                        if (ScreenShareProc.this.mDocsViewActivity != null) {
                            ScreenShareProc.this.mDocsViewActivity.onOtherPartyPage(remotePacket.getKeycode());
                            break;
                        }
                    }
                    break;
                case 500:
                    ScreenShareProc.logI("ScreenSharePacket.SCREEN_SHARE_REMOTE_DATA:" + ScreenShareProc.this.mIsRemote + " " + ScreenShareProc.this.mCurrentMode);
                    if (ScreenShareProc.this.mPauseType == 0 && ScreenShareProc.this.mIsRemote == 1 && ScreenShareProc.this.mCurrentMode == 100) {
                        ScreenShareRemotePacket remotePacket2 = ScreenShareRemotePacket.parserRemoteTouch(packet.getCommandData());
                        ScreenShareProc.logI("remotePacket.getType(): " + remotePacket2.getType());
                        if (remotePacket2.getType() == 2) {
                            ScreenShareProc.this.remoteTouchEvent(remotePacket2);
                            break;
                        } else if (remotePacket2.getType() == 1) {
                            ScreenShareProc.this.remoteKeyEvent(remotePacket2.getKeycode());
                            break;
                        }
                    }
                    break;
                case 600:
                    ScreenShareProc.this.setRemoteEnd();
                    if (MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination().getDestinationType() == 4) {
                        if (ScreenShareProc.this.mPauseType == 0) {
                            ScreenShareProc.showToast(ScreenShareProc.mThisService.getApplicationContext(), ScreenShareProc.mThisService.getString(C0000R.string.screenshare_paused_by_somebody, new Object[]{ScreenSharePacket.parserStringPacket(packet.getCommandData())}), 1);
                        }
                    } else if (ScreenShareProc.this.mOtherPauseType == 0 && ScreenShareProc.this.mPauseType == 0) {
                        ScreenShareProc.showToast(ScreenShareProc.mThisService.getApplicationContext(), ScreenShareProc.mThisService.getString(C0000R.string.screenshare_pause), 1);
                    }
                    if (ScreenShareProc.this.mOtherPauseType != 2) {
                        ScreenShareProc.this.mOtherPauseType = 1;
                        ScreenShareProc.this.mScreenSharePopupMenu.setOtherPause(ScreenShareProc.this.mOtherPauseType);
                        ScreenShareProc.this.mScreenShareView.setOtherPause(ScreenShareProc.this.mOtherPauseType);
                        break;
                    }
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_RESTART /* 601 */:
                    if (ScreenShareProc.mOtherStateMode == 3 || ScreenShareProc.mOtherStateMode == 2 || ScreenShareProc.mOtherStateMode == 2) {
                        byte[] packetData3 = ScreenSharePacket.makeStringPacket(MainApplication.mConfig.getProfileUserName());
                        ScreenShareProc.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_START, packetData3);
                    }
                    ScreenShareProc.this.mOtherPauseType = 0;
                    if (ScreenShareProc.this.mPauseType == 0) {
                        ScreenShareProc.showToast(ScreenShareProc.mThisService.getApplicationContext(), ScreenShareProc.mThisService.getString(C0000R.string.screenshare_restart), 0);
                    }
                    ScreenShareProc.this.mScreenShareView.setOtherPause(ScreenShareProc.this.mOtherPauseType);
                    ScreenShareProc.this.mScreenSharePopupMenu.setOtherPause(ScreenShareProc.this.mOtherPauseType);
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_EXTERNAL_PAUSE /* 603 */:
                    ScreenShareProc.this.setRemoteEnd();
                    if (ScreenShareProc.this.mOtherPauseType == 0 && ScreenShareProc.this.mPauseType == 0) {
                        ScreenShareProc.showToast(ScreenShareProc.mThisService.getApplicationContext(), ScreenShareProc.mThisService.getString(C0000R.string.screenshare_pause), 1);
                    }
                    ScreenShareProc.this.mOtherPauseType = 2;
                    ScreenShareProc.this.mScreenSharePopupMenu.setOtherPause(ScreenShareProc.this.mOtherPauseType);
                    ScreenShareProc.this.mScreenShareView.setOtherPause(ScreenShareProc.this.mOtherPauseType);
                    break;
                default:
                    if (ScreenShareProc.this.mScreenShareView != null) {
                        ScreenShareProc.this.mScreenShareView.OnRecveData(packet.getCommand(), packet.getCommandData());
                    }
                    if (ScreenShareProc.this.mPenWritingView != null && ScreenShareProc.this.mOtherPenWriteMode) {
                        ScreenShareProc.this.mPenWritingView.OnRecveData(packet.getCommand(), packet.getCommandData());
                    }
                    if (ScreenShareProc.this.mDocsViewActivity != null) {
                        if (ScreenShareProc.mOtherStateMode == 3 || ScreenShareProc.mOtherStateMode == 4) {
                            ScreenShareProc.this.mDocsViewActivity.OnRecveData(packet.getCommand(), packet.getCommandData());
                            break;
                        }
                    }
                    break;
            }
        }

        @Override // com.coolots.chaton.call.screenshare.util.PenWriteNetwork.OnRecvDataCB
        public void onStop(int type) {
            ScreenShareProc.logI("onStop stop()");
            ScreenShareProc.this.mPauseType = 0;
            Message msg = ScreenShareProc.this.mMainHandler.obtainMessage();
            msg.what = 4000;
            msg.arg1 = type;
            ScreenShareProc.this.mMainHandler.sendMessage(msg);
        }

        @Override // com.coolots.chaton.call.screenshare.util.PenWriteNetwork.OnRecvDataCB
        public void onPause(int type) {
            ScreenShareProc.logI("onPause()" + type + "/" + ScreenShareProc.this.mPauseType);
            ScreenShareProc.logI("onPause() mOtherStateMode: " + ScreenShareProc.mOtherStateMode + " mOtherPauseType = " + ScreenShareProc.this.mOtherPauseType);
            ScreenShareProc.this.setRemoteEnd();
            if (ScreenShareProc.this.mPauseType == 0) {
                ScreenShareService.releaseWakelock();
                if (ScreenShareProc.this.mOtherPauseType == 0) {
                    ScreenShareProc.showToast(ScreenShareProc.mThisService.getApplicationContext(), ScreenShareProc.mThisService.getString(C0000R.string.screenshare_pause), 1);
                }
            }
            if (ScreenShareProc.this.mPauseType != 2) {
                if (ScreenShareProc.this.mDocsViewActivity == null || !ScreenShareProc.this.mDocsViewActivity.isFileSelectView()) {
                    ScreenShareProc.this.mPauseType = type;
                    ScreenShareProc.this.mScreenShareView.setPause(ScreenShareProc.this.mPauseType);
                    ScreenShareProc.this.mScreenSharePopupMenu.setPause(ScreenShareProc.this.mPauseType);
                    if (ScreenShareProc.this.mCurrentMode == 101) {
                        ScreenShareProc.this.setPenWritingView(false);
                    }
                    ScreenShareProc.this.pauseSendData(ScreenShareProc.this.mPauseType);
                }
            }
        }

        @Override // com.coolots.chaton.call.screenshare.util.PenWriteNetwork.OnRecvDataCB
        public void onResume(Point point, boolean mode) {
            ScreenShareProc.logI("onResume() mode = " + mode);
            ScreenShareProc.logI("onResume mOtherStateMode: " + ScreenShareProc.mOtherStateMode + " mOtherPauseType = " + ScreenShareProc.this.mOtherPauseType);
            if (ScreenShareProc.this.mDocsViewActivity == null || !ScreenShareProc.this.mDocsViewActivity.isFileSelectView()) {
                ScreenShareProc.this.mPauseType = 0;
                ScreenShareService.acquireWakelock();
                if (ScreenShareProc.this.mOtherPauseType == 0) {
                    ScreenShareProc.showToast(ScreenShareProc.mThisService.getApplicationContext(), ScreenShareProc.mThisService.getString(C0000R.string.screenshare_restart), 1);
                } else {
                    ScreenShareProc.showToast(ScreenShareProc.mThisService.getApplicationContext(), ScreenShareProc.mThisService.getString(C0000R.string.screenshare_other_pause), 1);
                }
                ScreenShareProc.this.mScreenShareView.setPause(ScreenShareProc.this.mPauseType);
                ScreenShareProc.this.mScreenSharePopupMenu.setPause(ScreenShareProc.this.mPauseType);
                ScreenShareProc.this.pauseSendData(ScreenShareProc.this.mPauseType);
                if (ScreenShareProc.this.mOtherPenWriteMode) {
                    ScreenShareProc.this.setPenWritingView(true);
                    return;
                }
                if (MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination().getDestinationType() != 4) {
                    if (mode || ScreenShareProc.mOtherStateMode == 3 || ScreenShareProc.mOtherStateMode == 4) {
                        ScreenShareProc.this.setDocsView(true);
                        return;
                    }
                    return;
                }
                return;
            }
            ScreenShareService.acquireWakelock();
            if (ScreenShareProc.this.mScreenShareView != null) {
                ScreenShareProc.this.mScreenShareView.dismiss(false);
            }
            if (ScreenShareProc.this.mPenWritingView != null) {
                ScreenShareProc.this.mPenWritingView.dismiss();
            }
            ScreenShareProc.this.mPauseType = 0;
            ScreenShareProc.this.mScreenShareView.setPause(ScreenShareProc.this.mPauseType);
            ScreenShareProc.this.mScreenSharePopupMenu.setPause(ScreenShareProc.this.mPauseType);
        }

        @Override // com.coolots.chaton.call.screenshare.util.PenWriteNetwork.OnRecvDataCB
        public void onStart(int w, int h, String userID) throws PendingIntent.CanceledException {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.addFlags(329252864);
            PendingIntent pendIntent = PendingIntent.getActivity(MainApplication.mContext, 0, intent, 0);
            try {
                pendIntent.send();
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
            ScreenShareProc.logI("onStart mShareMode:" + ScreenShareProc.this.mShareMode);
            if (ScreenShareProc.this.mShareMode == 2) {
                ScreenShareProc.this.mQuickShareView.destory();
                ScreenShareProc.this.mQuickShareView = null;
                ScreenShareProc.this.setViews();
            }
        }

        @Override // com.coolots.chaton.call.screenshare.util.PenWriteNetwork.OnRecvDataCB
        public void onCallNotifyNetworkWeakReceive(int bandWidth) {
            ScreenShareProc.showToast(ScreenShareProc.mThisService.getApplicationContext(), ScreenShareProc.mThisService.getString(C0000R.string.screenshare_network_weak_popup), 1);
        }

        @Override // com.coolots.chaton.call.screenshare.util.PenWriteNetwork.OnRecvDataCB
        public void onSecureErrorForShareScreen() {
            if (ScreenShareProc.this.mSecureToast == null) {
                ScreenShareProc.this.mSecureToast = ScreenShareProc.showToast(ScreenShareProc.mThisService.getApplicationContext(), ScreenShareProc.mThisService.getString(C0000R.string.screenshare_secure_mode));
            }
            ScreenShareProc.this.mSecureToast.show();
        }

        @Override // com.coolots.chaton.call.screenshare.util.PenWriteNetwork.OnRecvDataCB
        public void onSecureModeEndForShareScreen() {
            if (ScreenShareProc.this.mSecureToast != null) {
                ScreenShareProc.this.mSecureToast.cancel();
                ScreenShareProc.this.mSecureToast = null;
            }
        }

        @Override // com.coolots.chaton.call.screenshare.util.PenWriteNetwork.OnRecvDataCB
        public void onResultCaptureImage(int arg0) {
            if (arg0 == 7231) {
                ScreenShareProc.logI("PenWritingCapture is Success in Service");
                ScreenShareProc.showToast(C0000R.string.screenshare_pen_writing_capture, 0);
            } else if (arg0 == 7232) {
                ScreenShareProc.logI("PenWritingCapture is Fail in Service");
                ScreenShareProc.showToast(C0000R.string.screenshare_pen_writing_capture_fail, 0);
            }
        }
    };
    private WindowManager mWindowManager = null;

    private static void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public static synchronized ScreenShareProc getInstance() {
        logI("getInstance");
        if (mInstance == null) {
            logI("ScreenShareProc() mInstance == null");
            mInstance = new ScreenShareProc();
        }
        return mInstance;
    }

    private ScreenShareProc() {
        logI("ScreenShareProc()");
        this.mInstrumentation = new Instrumentation();
    }

    @Override // com.sds.coolots.call.screenshare.ScreenShareProcInterface
    public void setService(Service service) {
        mThisService = service;
        this.mMainHandler = new MainHandler(this);
        logI("Create PenWriteNetwork");
        this.mWriteNetwork = new PenWriteNetwork();
        logI("PenWriteNetwork onRecvDataCB");
        this.mWriteNetwork.setOnRecvDataCB(this.onRecvDataCB);
    }

    @Override // com.sds.coolots.call.screenshare.ScreenShareProcInterface
    public void start(int mode) throws PendingIntent.CanceledException {
        mOtherStateMode = 0;
        this.mShareMode = mode;
        this.bStartShare = true;
        ScreenShareMessageReceiver.setShare(true);
        logI("ScreenShareProc Mode" + mode);
        if (mode == 0) {
            this.mCurrentMode = 100;
            Intent shareIntent = new Intent(MainApplication.mContext, (Class<?>) ScreenShareService.class);
            shareIntent.putExtra("StartMode", mode);
            MainApplication.mContext.startService(shareIntent);
            return;
        }
        if (mode == 1) {
            mUserID = 2;
            Intent intent = new Intent(MainApplication.mContext, (Class<?>) ScreenShareActivity.class);
            intent.putExtra("UserID", mUserID);
            intent.putExtra("StartMode", mode);
            PendingIntent pendIntent = PendingIntent.getActivity(MainApplication.mContext, 0, intent, 0);
            try {
                pendIntent.send();
                return;
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
                return;
            }
        }
        if (mode == 2) {
            this.mCurrentMode = 100;
            Intent shareIntent2 = new Intent(MainApplication.mContext, (Class<?>) ScreenShareService.class);
            shareIntent2.putExtra("StartMode", mode);
            MainApplication.mContext.startService(shareIntent2);
            return;
        }
        if (mode == 3) {
            mUserID = 2;
            Intent intent2 = new Intent(MainApplication.mContext, (Class<?>) ScreenShareActivity.class);
            intent2.putExtra("UserID", mUserID);
            intent2.putExtra("StartMode", mode);
            PendingIntent p = PendingIntent.getActivity(MainApplication.mContext, 0, intent2, 0);
            try {
                p.send();
            } catch (PendingIntent.CanceledException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.sds.coolots.call.screenshare.ScreenShareProcInterface
    public void stop() throws Resources.NotFoundException {
        logI("ScreenShare Stop  " + this.mShareMode);
        ScreenShareMessageReceiver.setShare(false);
        this.mPauseType = 0;
        if (this.mShareMode == 0 || this.mShareMode == 2) {
            logI("ScreenShare Stop mAlertView");
            if (this.mPenWritingView != null) {
                this.mPenWritingView.SetOnSendCommandData(null);
            }
            if (this.mScreenSharePopupMenu != null) {
                this.mScreenSharePopupMenu.SetOnSendCommandData(null);
            }
            if (this.mScreenShareView != null) {
                this.mScreenShareView.SetOnSendCommandData(null);
            }
            if (mAlertView != null) {
                mAlertView.dismiss();
                mAlertView = null;
            }
            if (this.mRemoteAlertView != null) {
                this.mRemoteAlertView.dismiss();
                this.mRemoteAlertView = null;
            }
            if (mScreenMode == 1) {
                logI("Docs view working!!!!!");
                Intent i = new Intent(MainApplication.mContext, (Class<?>) DocsViewActivity.class);
                i.addFlags(268435456);
                i.addFlags(4194304);
                i.putExtra("KILL_APP", true);
                MainApplication.mContext.startActivity(i);
            }
            logI("ScreenShare Stop mScreenShareView");
            if (this.mScreenShareView != null) {
                this.mScreenShareView.dispose();
                this.mScreenShareView.destory();
                this.mScreenShareView = null;
            }
            if (this.mQuickShareView != null) {
                this.mQuickShareView.dispose();
                this.mQuickShareView = null;
            }
            if (this.mScreenSharePopupMenu != null) {
                this.mScreenSharePopupMenu.dispose();
                this.mScreenSharePopupMenu.destory();
                this.mScreenSharePopupMenu = null;
            }
            logI("ScreenShare Stop mPenWritingView");
            if (this.mPenWritingView != null) {
                this.mPenWritingView.dissmissAlertView();
                this.mPenWritingView.dispose();
                this.mPenWritingView.destory();
                this.mPenWritingView = null;
            }
            if (this.mRemoteThread != null) {
                stopRemoteThread();
            }
            if (this.mWriteNetwork != null) {
                this.mWriteNetwork.stop();
            }
            if (this.mSecureToast != null) {
                this.mSecureToast.cancel();
                this.mSecureToast = null;
            }
        }
        deleteDirDocsView(DocsViewActivity.ROOT_PATH);
        logI("ScreenShare Stop mThisService");
        if (mThisService != null) {
            mThisService.stopSelf();
            mThisService = null;
        }
        if (this.mBoardDataController != null) {
            this.mBoardDataController.dispose();
            this.mBoardDataController = null;
        }
    }

    protected void CreatePenWritingView() {
        if (this.mPenWritingView == null) {
            this.mPenWritingView = new PenWritingView(mThisService);
            this.mPenWritingView.dismiss();
            this.mPenWritingView.setUserID(mUserID);
            this.mPenWritingView.SetOnSendCommandData(new OverlayView.OnSendCommandData() { // from class: com.coolots.chaton.call.screenshare.ScreenShareProc.2
                @Override // com.coolots.chaton.call.screenshare.core.OverlayView.OnSendCommandData
                public void onSendData(int command, byte[] data) {
                    if (MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination().getDestinationType() != 4) {
                        byte[] sendData = ScreenSharePacket.makePacket(command, data);
                        ScreenShareProc.this.mWriteNetwork.sendData(sendData);
                    }
                }
            });
        }
    }

    protected void CreatePopupMenu() {
        if (this.mScreenSharePopupMenu == null) {
            try {
                if (mThisService != null) {
                    this.mScreenSharePopupMenu = new ScreenSharePopupMenu(mThisService, this.mScreenShareView);
                    this.mScreenSharePopupMenu.dismiss();
                    this.mScreenSharePopupMenu.SetOnSendCommandData(new OverlayView.OnSendCommandData() { // from class: com.coolots.chaton.call.screenshare.ScreenShareProc.3
                        @Override // com.coolots.chaton.call.screenshare.core.OverlayView.OnSendCommandData
                        public void onSendData(int command, byte[] data) {
                            byte[] sendData = ScreenSharePacket.makePacket(command, data);
                            ScreenShareProc.this.mWriteNetwork.sendData(sendData);
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void onSendData(int command, byte[] data) {
        byte[] sendData = ScreenSharePacket.makePacket(command, data);
        this.mWriteNetwork.sendData(sendData);
    }

    protected void setViews() {
        mUserID = 1;
        CreatePenWritingView();
        this.mScreenShareView = new ScreenShareView(mThisService);
        this.mScreenShareView.moveView(0, 75);
        this.mScreenShareView.setUserID(mUserID);
        this.mScreenShareView.SetOnSendCommandData(new OverlayView.OnSendCommandData() { // from class: com.coolots.chaton.call.screenshare.ScreenShareProc.4
            @Override // com.coolots.chaton.call.screenshare.core.OverlayView.OnSendCommandData
            public void onSendData(int command, byte[] data) {
                byte[] sendData = ScreenSharePacket.makePacket(command, data);
                ScreenShareProc.this.mWriteNetwork.sendData(sendData);
            }
        });
        CreatePopupMenu();
    }

    public void setConferencePenMode(boolean isStart) {
        if (isStart) {
            if (this.mPauseType == 0) {
                setPenWritingView(true);
                return;
            }
            return;
        }
        setPenWritingView(false);
    }

    public void startShare() {
        if (this.mShareMode == 0) {
            MainApplication.mPhoneManager.getPhoneStateMachine().sendRotationInfo(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), getRotaionDegree() << 16, isAutoRatationActive(), false);
            setViews();
            try {
                if (this.mWindowManager == null) {
                    this.mWindowManager = (WindowManager) mThisService.getApplicationContext().getSystemService("window");
                }
                logI("sendSetRotation ScreenSharePacket.makePacket");
                byte[] sendData = ScreenSharePacket.makePacket(ScreenSharePacket.SCREEN_SHARE_CMD_ROTATE, PenWriteNetwork.intToByte(this.mWindowManager.getDefaultDisplay().getRotation()));
                logI("sendSetRotation mWriteNetwork.sendData");
                this.mWriteNetwork.sendData(sendData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.mShareMode == 2) {
            this.mQuickShareView = new QuickShareView(mThisService);
        }
        checkKeyguardLockStatus();
        initBoardDataController();
    }

    public void pauseSendData(int pause) {
        byte[] destUserID = PenWriteNetwork.intToByte(mUserID + 1);
        byte[] sendData = (byte[]) null;
        if (pause == 1) {
            sendData = ScreenSharePacket.makePacket(600, destUserID);
        } else if (pause == 0) {
            logI("pauseSendData mOtherStateMode: " + mOtherStateMode);
            if (mOtherStateMode == 3) {
                logI("pauseSendData SCREEN_SHARE_CMD_DOCS_VIEW_MODE");
                sendData = ScreenSharePacket.makePacket(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_MODE, destUserID);
            } else {
                sendData = ScreenSharePacket.makePacket(ScreenSharePacket.SCREEN_SHARE_CMD_RESTART, destUserID);
            }
            MainApplication.mPhoneManager.getPhoneStateMachine().sendRotationInfo(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), getRotaionDegree() << 16, isAutoRatationActive(), false);
        } else if (pause == 2) {
            sendData = ScreenSharePacket.makePacket(ScreenSharePacket.SCREEN_SHARE_CMD_EXTERNAL_PAUSE, destUserID);
        }
        this.mWriteNetwork.sendData(sendData);
    }

    public static void stopScreenShare() {
        if (mThisService != null) {
            mThisService.stopSelf();
        }
    }

    public static void setPenWriting(boolean penWriting) {
        if (mInstance != null) {
            mInstance.setPenWritingView(penWriting);
            if (!penWriting) {
                mInstance.setOtherPenWriteMode(false);
            }
        }
    }

    public static void setMessagePause() {
        if (mInstance != null) {
            mInstance.onMsgPause();
        }
    }

    public void onMsgPause() {
        if (this.mPauseType == 0) {
            showToast(mThisService.getApplicationContext(), mThisService.getString(C0000R.string.screenshare_pause), 1);
        }
        if (this.mPauseType != 2) {
            this.mPauseType = 1;
            this.mScreenShareView.setPause(this.mPauseType);
            this.mScreenSharePopupMenu.setPause(this.mPauseType);
            if (this.mCurrentMode == 101) {
                setPenWritingView(false);
            }
            pauseSendData(this.mPauseType);
            MainApplication.mPhoneManager.getShareScreenManager().pauseShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), 0);
        }
    }

    protected void setPenWritingView(boolean penWriting) {
        if (penWriting) {
            if (this.mScreenShareView != null) {
                this.mScreenShareView.dismiss(false);
            }
            if (this.mPenWritingView != null) {
                this.mPenWritingView.show();
            }
            if (this.mDocsViewActivity != null) {
                this.mDocsViewActivity.setVisible(false);
            }
            this.mCurrentMode = 101;
            return;
        }
        if (this.mScreenShareView != null) {
            this.mScreenShareView.show(false);
        }
        if (this.mPenWritingView != null) {
            this.mPenWritingView.dismiss();
        }
        this.mCurrentMode = 100;
    }

    protected void setDocsView(boolean docsMode) {
        if (docsMode) {
            if (this.mScreenShareView != null) {
                this.mScreenShareView.dismiss(false);
            }
            if (this.mPenWritingView != null) {
                this.mPenWritingView.dismiss();
            }
            if (this.mDocsViewActivity != null) {
                this.mDocsViewActivity.setVisible(true);
                return;
            }
            return;
        }
        if (this.mScreenShareView != null) {
            this.mScreenShareView.show(false);
        }
        if (this.mPenWritingView != null) {
            this.mPenWritingView.dismiss();
        }
        if (this.mDocsViewActivity != null) {
            this.mDocsViewActivity.setVisible(false);
        }
    }

    public void setHideForFilePicker(boolean homekey) {
        if (homekey) {
            if (this.mDocsViewActivity != null) {
                this.mDocsViewActivity.setFileSelectView(false);
                mOtherStateMode = 0;
                MainApplication.mPhoneManager.getShareScreenManager().resumeShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), null, true);
                this.mDocsViewActivity.finishDocsView();
                return;
            }
            return;
        }
        if (this.mScreenShareView != null) {
            this.mScreenShareView.dismiss(false);
        }
    }

    protected void startOtherDocsView(boolean show) {
        mOtherStateMode = 3;
        setDocsView(true);
        showNormalDocsView(show);
    }

    protected void showNormalDocsView(boolean isNormal) {
        if (this.mDocsViewActivity != null) {
            this.mDocsViewActivity.setNormalMode(isNormal);
        }
    }

    static class MainHandler extends Handler {
        WeakReference<ScreenShareProc> mFrag;

        MainHandler(ScreenShareProc aFragment) {
            this.mFrag = new WeakReference<>(aFragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) throws Resources.NotFoundException {
            if (msg.what == 4000) {
                ScreenShareProc.logI("SCREEN_SHARE_ONSTOP");
                if (ScreenShareProc.mInstance != null) {
                    ScreenShareProc.logI("onStop " + msg.arg1);
                    if (ScreenShareProc.mInstance != null) {
                        ScreenShareProc.mInstance.stop();
                    }
                    ScreenShareService.releaseWakelock();
                }
            }
        }
    }

    public static void remoteModeEnd() {
        if (mInstance != null) {
            mInstance.stopRemoteThread();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.coolots.chaton.call.screenshare.ScreenShareProc$5] */
    public void remoteKeyEvent(final int code) {
        if (this.mIsRemote == 1) {
            new Thread() { // from class: com.coolots.chaton.call.screenshare.ScreenShareProc.5
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    KeyEvent event = new KeyEvent(0, code);
                    ScreenShareProc.this.mInstrumentation.sendKeySync(event);
                    KeyEvent event2 = new KeyEvent(1, code);
                    ScreenShareProc.this.mInstrumentation.sendKeySync(event2);
                }
            }.start();
        }
    }

    public void remoteTouchEvent(ScreenShareRemotePacket remotePacket) {
        long eventTime;
        logI("remoteTouchEvent action:" + remotePacket.getAction() + "eventtime:" + remotePacket.getEventTime() + ", System Time=" + SystemClock.uptimeMillis());
        if (remotePacket.getAction() == 0) {
            eventTime = SystemClock.uptimeMillis();
            gDownTime = eventTime;
        } else {
            eventTime = gDownTime + remotePacket.getEventTime();
        }
        if (eventTime == 0) {
            logI("remoteTouchEvent eventTime == 0");
            return;
        }
        MotionEvent event = MotionEvent.obtain(gDownTime, eventTime, remotePacket.getAction(), remotePacket.getPointerCount(), remotePacket.getPointerProperties(), remotePacket.getPointerCoords(), remotePacket.getMetaState(), 0, 1.0f, 1.0f, 0, 0, 0, 0);
        synchronized (this.mRemoteQ) {
            this.mRemoteQ.add(event);
        }
        logI("remoteTouchEvent action: notify()");
        synchronized (this.mRemoteThread) {
            logI("remoteTouchEvent action: notify()");
            this.mRemoteThread.notify();
        }
        logI("remoteTouchEvent action: notify() end");
    }

    public static void showPopupMenu() {
        try {
            if (mInstance.mScreenSharePopupMenu == null) {
                mInstance.CreatePopupMenu();
            }
            if (mInstance.mScreenSharePopupMenu != null) {
                mInstance.setShowPopupMenu(mInstance.mScreenSharePopupMenu.mShow);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setShowPopupMenu(boolean show) {
        if (show) {
            this.mScreenSharePopupMenu.dismiss(0);
            return;
        }
        if (this.mIsRemote == 1) {
            this.mScreenSharePopupMenu.setViewMode(1);
        } else {
            this.mScreenSharePopupMenu.setViewMode(0);
        }
        this.mScreenSharePopupMenu.show();
    }

    private void stopRemoteThread() {
        logI("stopRemoteThread mRemoteQ clear");
        synchronized (this.mRemoteQ) {
            this.mIsRemote = 0;
            this.mRemoteQ.clear();
        }
        logI("mRemoteQ mRemoteThread notify()");
        if (this.mRemoteThread != null) {
            synchronized (this.mRemoteThread) {
                this.mRemoteThread.notify();
            }
            this.mRemoteThread = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void remoteControlAlertDialogTimer() {
        this.mRemoteControlAlertDialogTimerHandler = new Handler();
        this.mRemoteControlAlertDialogTimerRunnable = new Runnable() { // from class: com.coolots.chaton.call.screenshare.ScreenShareProc.6
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                if (ScreenShareProc.this.mRemoteAlertView != null) {
                    ScreenShareProc.this.mRemoteAlertView.dismiss();
                    ScreenShareProc.this.mCommandData = PenWriteNetwork.intToByte(2);
                    ScreenShareProc.this.mSendData = ScreenSharePacket.makePacket(ScreenSharePacket.SCREEN_SHARE_CMD_CHNAGE_REMOTE_RESP_MODE, ScreenShareProc.this.mCommandData);
                    ScreenShareProc.this.mWriteNetwork.sendData(ScreenShareProc.this.mSendData);
                    ScreenShareProc.this.mRemoteAlertView = null;
                }
            }
        };
        this.mRemoteControlAlertDialogTimerHandler.postDelayed(this.mRemoteControlAlertDialogTimerRunnable, Config.DISCONNECT_TIMEOUT);
    }

    class RemoteThread extends Thread {
        RemoteThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            MotionEvent event;
            while (ScreenShareProc.this.mIsRemote == 1) {
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ScreenShareProc.this.mIsRemote == 0) {
                    break;
                }
                ScreenShareProc.logI("remoteTouchEvent wait()");
                while (true) {
                    ScreenShareProc.logI("remoteTouchEvent  thread mRemoteQ");
                    synchronized (ScreenShareProc.this.mRemoteQ) {
                        event = (MotionEvent) ScreenShareProc.this.mRemoteQ.poll();
                    }
                    if (event != null) {
                        ScreenShareProc.logI("remoteTouchEvent  thread sendPointerSync");
                        ScreenShareProc.this.mInstrumentation.sendPointerSync(event);
                    }
                }
            }
            ScreenShareProc.logI("RemoteThread end");
        }
    }

    public static void showToast(Context context, String msg, int duration) {
        ScreenShareToast mScreenShareToastToast = showToast(context, msg);
        mScreenShareToastToast.show();
    }

    public static ScreenShareToast showToast(Context context, String msg) {
        Context nContext = context;
        String strMsg = msg;
        if (msg == null) {
            strMsg = "";
        }
        if (nContext == null) {
            if (mThisService != null) {
                nContext = mThisService.getApplicationContext();
            } else {
                nContext = MainApplication.mContext;
            }
        }
        LinearLayout ll = new LinearLayout(nContext);
        ll.setOrientation(0);
        ll.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        ll.setBackgroundResource(C0000R.drawable.progress_popup_bg);
        ll.setGravity(17);
        logI("Toast Message: " + strMsg);
        TextView tvmsg = new TextView(nContext);
        int pad2 = (int) (5.0f * tvmsg.getResources().getDisplayMetrics().density);
        tvmsg.setGravity(17);
        tvmsg.setPadding(pad2, 0, pad2, 0);
        tvmsg.setTextColor(-16777216);
        tvmsg.setText(strMsg);
        ll.addView(tvmsg);
        ScreenShareToast toast_view = new ScreenShareToast(nContext);
        toast_view.setView(ll);
        toast_view.setDuration(0);
        return toast_view;
    }

    public static void showToast(int resid, int duration) {
        if (mThisService != null) {
            String msg = mThisService.getString(resid);
            showToast(mThisService.getApplicationContext(), msg, duration);
        }
    }

    public static boolean isShareButtonRect(int x, int y) {
        if (mInstance != null) {
            return mInstance.isShareBtnRect(x, y);
        }
        return false;
    }

    private boolean isShareBtnRect(int x, int y) {
        if (this.mScreenShareView == null || this.mScreenShareView.getMainButton() == null) {
            return false;
        }
        return this.mScreenShareView.isInside(this.mScreenShareView.getMainButton(), x, y);
    }

    @Override // com.sds.coolots.call.screenshare.ScreenShareProcInterface
    public int getShareMode() {
        return this.mShareMode;
    }

    public void sendSetRotation() {
        if (mThisService != null) {
            try {
                if (this.mWindowManager == null) {
                    this.mWindowManager = (WindowManager) mThisService.getApplicationContext().getSystemService("window");
                }
                logI("sendSetRotation ScreenSharePacket.makePacket");
                if (MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination().getDestinationType() != 4) {
                    byte[] sendData = ScreenSharePacket.makePacket(ScreenSharePacket.SCREEN_SHARE_CMD_ROTATE, PenWriteNetwork.intToByte(this.mWindowManager.getDefaultDisplay().getRotation()));
                    logI("sendSetRotation mWriteNetwork.sendData");
                    this.mWriteNetwork.sendData(sendData);
                }
                logI("sendSetRotation MainApplication.mPhoneManager.getPhoneStateMachine().sendRotationInfo");
                MainApplication.mPhoneManager.getPhoneStateMachine().sendRotationInfo(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), getRotaionDegree() << 16, isAutoRatationActive(), false);
                logI("Rotaion Value=" + this.mWindowManager.getDefaultDisplay().getRotation() + ", boolean=" + isAutoRatationActive());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setScreenRotation() {
        sendSetRotation();
        if (this.mScreenShareView != null) {
            this.mScreenShareView.moveView(0, 75);
            this.mScreenSharePopupMenu.setMenuRotated();
        }
    }

    protected void setOtherPenWriteMode(boolean flag) {
        this.mOtherPenWriteMode = flag;
    }

    public static void setShareEnd() throws Resources.NotFoundException {
        mAlertView = new AlertView(ScreenSharePopupMenu.mParent);
        mAlertView.setTitle(C0000R.string.call_btn_share_screen);
        mAlertView.setMessage(C0000R.string.screenshare_end_popup);
        mAlertView.setPositiveButton(C0000R.string.ok, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.ScreenShareProc.7
            @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
            public void onClick(AlertView dialog, int which) {
                if (ScreenShareProc.getInstance().getShareMode() == 0) {
                    MainApplication.mPhoneManager.getShareScreenManager().stopShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination());
                    ScreenShareProc.stopScreenShare();
                } else if (ScreenShareProc.getInstance().getShareMode() == 2) {
                    MainApplication.mPhoneManager.getPhoneStateMachine().localHangupCall(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), 10);
                }
            }
        });
        mAlertView.setNegativeButton(C0000R.string.cancel, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.ScreenShareProc.8
            @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
            public void onClick(AlertView dialog, int which) {
            }
        });
        mAlertView.setCancelable(true);
        mAlertView.show();
    }

    public static void setModeChangeForDocsView(int mode) {
        logI("setModeChangeForDocsView() request mode?" + mode);
        mScreenMode = mode;
        if (mInstance != null && mInstance.mScreenSharePopupMenu != null) {
            if (mScreenMode == 1) {
                mOtherStateMode = 3;
                mInstance.mScreenSharePopupMenu.setDocViewBtnEnabled(true);
            } else {
                mOtherStateMode = 0;
                mInstance.mScreenSharePopupMenu.setDocViewBtnEnabled(true);
            }
        }
        MainApplication.mPhoneManager.getShareScreenManager().setModeChangeDuringShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), mScreenMode);
    }

    public void startDocsView() {
        mInstance.mOtherPenWriteMode = false;
        if ((mOtherStateMode == 3 || mOtherStateMode == 4) && this.mDocsViewActivity != null) {
            this.mDocsViewActivity.finishDocsView();
        }
        mOtherStateMode = 2;
        mInstance.setPenWritingView(false);
        logI("startDocsView");
        Intent i = new Intent(MainApplication.mContext, (Class<?>) DocsViewActivity.class);
        i.addFlags(268435456);
        i.addFlags(536870912);
        i.addFlags(8388608);
        i.putExtra("start_main", true);
        MainApplication.mContext.startActivity(i);
    }

    public void setDocsViewActivity(DocsViewActivity activity) {
        this.mDocsViewActivity = activity;
    }

    public static void endDocsView() {
        setPenWriting(false);
    }

    public boolean getStart() {
        return this.bStartShare;
    }

    public boolean setRemoteEnd() {
        if (this.mIsRemote != 1) {
            return false;
        }
        remoteModeEnd();
        this.mScreenSharePopupMenu.setViewMode(0);
        return true;
    }

    private int getRotaionDegree() {
        if (this.mWindowManager == null) {
            this.mWindowManager = (WindowManager) mThisService.getSystemService("window");
        }
        return ((4 - this.mWindowManager.getDefaultDisplay().getRotation()) % 4) * 90;
    }

    private boolean isAutoRatationActive() throws Settings.SettingNotFoundException {
        int sysAutoRotate = 0;
        try {
            sysAutoRotate = Settings.System.getInt(mThisService.getContentResolver(), "accelerometer_rotation");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return sysAutoRotate == 1;
    }

    public void deleteDirDocsView(String path) {
        File file = new File(path);
        File[] childFileList = file.listFiles();
        if (childFileList != null) {
            for (File childFile : childFileList) {
                if (childFile.isDirectory()) {
                    deleteDirDocsView(childFile.getAbsolutePath());
                } else {
                    childFile.delete();
                }
            }
        }
        file.delete();
    }

    public BoardDataController getBoardDataController() {
        if (this.mBoardDataController == null) {
            this.mBoardDataController = new BoardDataController();
        }
        return this.mBoardDataController;
    }

    public void initBoardDataController() {
        if (this.mBoardDataController != null) {
            this.mBoardDataController.dispose();
            this.mBoardDataController = null;
        }
        this.mBoardDataController = new BoardDataController();
    }

    public String getDocsFileName() {
        return this.mBoardDataController.getDocsName();
    }

    public void setVisibilityMainButton(boolean visible) {
        logI("setVisibilityMainButton() visible?" + visible);
        if (visible) {
            this.mScreenShareView.setVisibility(0);
        } else {
            this.mScreenShareView.setVisibility(4);
        }
    }

    public boolean getScreenSharePopupMenuShow() {
        if (this.mScreenSharePopupMenu != null) {
            return this.mScreenSharePopupMenu.mShow;
        }
        return false;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
    }

    public void checkKeyguardLockStatus() {
        logI("checkKeyguardLockStatus");
        if (this.mKeyguardManager == null) {
            this.mKeyguardManager = (KeyguardManager) mThisService.getApplicationContext().getSystemService("keyguard");
        }
        if (this.mKeyguardManager.inKeyguardRestrictedInputMode()) {
            setVisibilityMainButton(false);
            MainApplication.mPhoneManager.getShareScreenManager().pauseShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), 0);
        }
    }
}
