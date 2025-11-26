package com.coolots.chaton.call.screenshare.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.SurfaceControl;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.SECConfig;
import com.coolots.chaton.call.screenshare.ScreenShareProc;
import com.coolots.chaton.call.screenshare.activity.ScreenShareLayout;
import com.coolots.chaton.call.screenshare.core.OverlayView;
import com.coolots.chaton.call.screenshare.util.BoardDataController;
import com.coolots.chaton.call.screenshare.util.PenWriteNetwork;
import com.coolots.chaton.call.screenshare.util.ScreenShareMessageReceiver;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.coolots.chaton.call.screenshare.util.ScreenShareRemotePacket;
import com.coolots.chaton.call.screenshare.util.ScreenShareScale;
import com.coolots.chaton.call.screenshare.util.ScreenShareToast;
import com.coolots.chaton.common.util.ChatONDialog;
import com.coolots.sso.util.ChatONVAPII;
import com.infraware.office.evengine.InterfaceC0507E;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.PhoneStateMachine;
import com.sds.coolots.common.controller.EngineCallBackInterface;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import com.vlingo.sdk.internal.net.ConnectionManager;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class ScreenShareActivity extends Activity implements SurfaceHolder.Callback2, DisposeInterface {
    private static final int CHANGE_VIEW_DOCS = 1002;
    private static final int CHANGE_VIEW_PEN = 1000;
    private static final int CHANGE_VIEW_SHARE = 1001;
    private static final String CLASSNAME = "[ScreenShareActivity]";
    private static final int REMOTEVIEW = 1;
    private static final int START_DRAG = 1;
    private static final int STOP_DRAG = 0;
    private static final int SURFACEVIEW = 0;
    public static DocsMenuViewLayout mDocsMenuViewLayout;
    public static ScreenShareActivity mInstance;
    public static int mIsRemote;
    public static FrameLayout mMainLayout;
    public static PenWritingViewLayout mPenWritingViewLayout;
    public static ScreenSharePopupMenuLayout mScreenSharePopupMenuLayout;
    public static ScreenShareViewLayout mScreenShareViewLayout;
    public static ScreenShareViewOverlay mScreenShareViewOverlay;
    public static LinearLayout mSecureModeLayout;
    public static FrameLayout mTransParentLayout;
    private BoardDataController mBoardDataController;
    private Handler mConsentRemoteControlDialogTimerHandler;
    private Runnable mConsentRemoteControlDialogTimerRunnable;
    private int mCurOrientation;
    private int mCurrentMode;
    private Button mEndBtn;
    private SurfaceHolder mHolder;
    private LayoutInflater mInflater;
    private ImageButton mMainBtn;
    private OrientationEventListener mOrientation;
    private PhoneStateMachine mPhoneStateMachine;
    private SurfaceHolder mRemoteHolder;
    protected ScreenShareScale mScreenScale;
    private ScreenShareToast mSecureToast;
    private RelativeLayout mShareBtnLayout;
    private int mShareMode;
    private boolean mStartDownEvent;
    private int mUserID;
    private PenWriteNetwork mWriteNetwork;
    public static int mOverlayPopupMenuMode = 2;
    public static boolean mOnFinish = false;
    public static boolean mIsOnPause = false;
    private static int dragFlag = 0;
    private SurfaceView mRemoteSurface = null;
    private SurfaceView mSurface = null;
    protected ProgressDialog mConsentRemoteControlDialog = null;
    protected AlertDialog mEndRemoteControlDialog = null;
    private Point mStartPoint = null;
    private Point mCurrentPoint = new Point(0, 0);
    private boolean isMoveFirst = false;
    private boolean mOtherPenWriteMode = false;
    private int mOtherStateMode = 0;
    public int mOtherPauseType = 0;
    public int mPauseType = 0;
    public PowerManager mPowerManager = null;
    public PowerManager.WakeLock mWakeLock = null;
    private Boolean mOtherRestart = false;
    private Bitmap mBitmapBackup = null;
    private int mOtherOrientation = 0;
    public Point mMenuPoint = new Point(0, 0);
    PenWriteNetwork.OnRecvDataCB onRecvDataCB = new PenWriteNetwork.OnRecvDataCB() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareActivity.1
        @Override // com.coolots.chaton.call.screenshare.util.PenWriteNetwork.OnRecvDataCB
        public void onRecvData(byte[] data, int len) {
            ScreenSharePacket packet = ScreenSharePacket.parserPacket(data);
            ScreenShareActivity.logI("onRecvDataCB:" + packet.getCommand());
            switch (packet.getCommand()) {
                case 400:
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_DRAWING_REQ_MODE /* 401 */:
                    ScreenShareActivity.this.mOtherPenWriteMode = true;
                    ScreenShareActivity.this.mOtherStateMode = 1;
                    if (ScreenShareActivity.this.mPauseType == 0) {
                        ScreenShareActivity.this.setPenWritingView(true, false, false);
                    }
                    byte[] cmdData = PenWriteNetwork.intToByte(ScreenShareActivity.this.mUserID);
                    ScreenShareActivity.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_DRAWING_RESP_MODE, cmdData);
                    ScreenShareActivity.logI("Data Flow = send response penwriting open");
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_DRAWING_RESP_MODE /* 402 */:
                    ScreenShareActivity.this.mOtherPenWriteMode = true;
                    ScreenShareActivity.this.mOtherStateMode = 1;
                    if (ScreenShareActivity.this.mPauseType == 0) {
                        ScreenShareActivity.this.setPenWritingView(true, false, false);
                        break;
                    }
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_SHARE_MODE /* 403 */:
                    ScreenShareActivity.logI("Other's PenWriting EndBtn Clicked ");
                    if (ScreenShareActivity.this.mOtherStateMode == 3) {
                        ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_docs_view_cancelled), 0);
                    }
                    ScreenShareActivity.this.mOtherPenWriteMode = false;
                    ScreenShareActivity.this.mOtherStateMode = 0;
                    ScreenShareActivity.this.chageShareView();
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_CHNAGE_REMOTE_RESP_MODE /* 405 */:
                    int isRemote = PenWriteNetwork.byteToInt(packet.getCommandData());
                    ScreenShareActivity.logI("SCREEN_SHARE_CMD_CHNAGE_REMOTE_RESP_MODE" + ScreenShareActivity.mIsRemote);
                    if (isRemote == 0) {
                        ScreenShareActivity.mIsRemote = 0;
                        if (ScreenShareActivity.this.mConsentRemoteControlDialog != null) {
                            ScreenShareActivity.this.mConsentRemoteControlDialog.dismiss();
                            ScreenShareActivity.this.mConsentRemoteControlDialogTimerHandler.removeCallbacks(ScreenShareActivity.this.mConsentRemoteControlDialogTimerRunnable);
                            ScreenShareActivity.this.mConsentRemoteControlDialog = null;
                        }
                        ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_remote_control_reject), 0);
                        break;
                    } else if (isRemote == 1) {
                        ScreenShareActivity.mIsRemote = 1;
                        if (ScreenShareActivity.this.mConsentRemoteControlDialog != null) {
                            ScreenShareActivity.this.mConsentRemoteControlDialog.dismiss();
                            ScreenShareActivity.this.mConsentRemoteControlDialogTimerHandler.removeCallbacks(ScreenShareActivity.this.mConsentRemoteControlDialogTimerRunnable);
                            ScreenShareActivity.this.mConsentRemoteControlDialog = null;
                        }
                        ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_remote_control_start), 0);
                        ScreenShareActivity.mScreenSharePopupMenuLayout.setViewMode(3);
                        ScreenShareActivity.mOverlayPopupMenuMode = 3;
                        ScreenShareActivity.this.setMenuPos(new int[2]);
                        break;
                    } else if (isRemote == 2) {
                        ScreenShareActivity.mIsRemote = 0;
                        if (ScreenShareActivity.this.mConsentRemoteControlDialog != null) {
                            ScreenShareActivity.this.mConsentRemoteControlDialog.dismiss();
                            ScreenShareActivity.this.mConsentRemoteControlDialogTimerHandler.removeCallbacks(ScreenShareActivity.this.mConsentRemoteControlDialogTimerRunnable);
                            ScreenShareActivity.this.mConsentRemoteControlDialog = null;
                        }
                        Toast.makeText(ScreenShareActivity.this, ScreenShareActivity.this.getString(C0000R.string.screenshare_remote_control_timeout), 0).show();
                        break;
                    }
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_CHNAGE_REMOTE_END /* 406 */:
                    ScreenShareActivity.mIsRemote = 0;
                    ScreenShareActivity.mScreenSharePopupMenuLayout.setViewMode(2);
                    ScreenShareActivity.mOverlayPopupMenuMode = 2;
                    ScreenShareActivity.this.setMenuHeight();
                    ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_remote_control_end), 0);
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_START /* 410 */:
                    ScreenShareActivity.this.mOtherStateMode = 3;
                    String userName = ScreenSharePacket.parserStringPacket(packet.getCommandData());
                    ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_docs_view_ready, userName), 1);
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_MODE /* 411 */:
                    ScreenShareActivity.this.setRemoteEnd();
                    ScreenShareActivity.this.mOtherStateMode = 3;
                    if (ScreenShareActivity.this.mPauseType == 0) {
                        ScreenShareActivity.this.mOtherRestart = true;
                        ScreenShareActivity.this.setPenWritingView(false, true, false);
                    }
                    ScreenShareActivity.this.mOtherPauseType = 0;
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_DRAWING_REQ_MODE /* 412 */:
                    ScreenShareActivity.this.mOtherStateMode = 4;
                    if (ScreenShareActivity.this.mPauseType == 0) {
                        ScreenShareActivity.this.setPenWritingView(false, true, false);
                    }
                    byte[] cmdDocsData = PenWriteNetwork.intToByte(ScreenShareActivity.this.mUserID);
                    ScreenShareActivity.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_DRAWING_RESP_MODE, cmdDocsData);
                    ScreenShareActivity.logI("Data Flow = send response penwriting open");
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_DRAWING_RESP_MODE /* 413 */:
                    if (ScreenShareActivity.this.mPauseType == 0) {
                        if (ScreenShareActivity.this.mOtherStateMode == 3 || ScreenShareActivity.this.mOtherStateMode == 4) {
                            ScreenShareActivity.this.setPenWritingView(false, true, false);
                            ScreenShareActivity.this.mOtherStateMode = 4;
                            break;
                        }
                    }
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_MOVE_PAGE /* 414 */:
                    ScreenShareRemotePacket remotePacket = ScreenShareRemotePacket.parserRemoteTouch(packet.getCommandData());
                    ScreenShareActivity.logI("docs other page: " + remotePacket.getKeycode());
                    if (ScreenShareActivity.mDocsMenuViewLayout != null) {
                        ScreenShareActivity.mDocsMenuViewLayout.onOtherPartyPage(remotePacket.getKeycode());
                        break;
                    }
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_FILE_OPEN /* 415 */:
                    ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_docs_view_started), 1);
                    break;
                case 600:
                    ScreenShareActivity.this.setRemoteEnd();
                    if (ScreenShareActivity.this.mOtherPauseType == 0 && ScreenShareActivity.this.mPauseType == 0) {
                        ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_pause), 1);
                    }
                    if (ScreenShareActivity.this.mOtherPauseType != 2) {
                        ScreenShareActivity.this.mOtherPauseType = 1;
                        ScreenShareActivity.mScreenSharePopupMenuLayout.setOtherPause(ScreenShareActivity.this.mOtherPauseType);
                        ScreenShareActivity.mScreenShareViewLayout.setOtherPause(ScreenShareActivity.this.mOtherPauseType);
                        break;
                    }
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_RESTART /* 601 */:
                    if (ScreenShareActivity.this.mPauseType == 0) {
                        ScreenShareActivity.this.mOtherRestart = true;
                        MainApplication.mPhoneManager.getShareScreenManager().pauseShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), 0);
                        ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_restart), 0);
                    }
                    ScreenShareActivity.this.mOtherPauseType = 0;
                    ScreenShareActivity.mScreenShareViewLayout.setX(ScreenShareActivity.this.mMenuPoint.x);
                    ScreenShareActivity.mScreenShareViewLayout.setY(ScreenShareActivity.this.mMenuPoint.y);
                    ScreenShareActivity.mScreenSharePopupMenuLayout.setOtherPause(ScreenShareActivity.this.mOtherPauseType);
                    ScreenShareActivity.mScreenShareViewLayout.setOtherPause(ScreenShareActivity.this.mOtherPauseType);
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_ROTATE /* 602 */:
                    ScreenShareActivity.logI("onRecvDataCB case ScreenSharePacket.SCREEN_SHARE_CMD_ROTATE:");
                    ScreenShareActivity.this.mOtherOrientation = PenWriteNetwork.byteToInt(packet.getCommandData());
                    ScreenShareActivity.logI("onRecvDataCB case ScreenSharePacket.SCREEN_SHARE_CMD_ROTATE: setOrientation = " + ScreenShareActivity.this.mOtherOrientation);
                    if (ScreenShareActivity.this.mOtherPauseType == 0 && ScreenShareActivity.this.mPauseType == 0) {
                        ScreenShareActivity.this.setOrientation();
                        break;
                    }
                    break;
                case ScreenSharePacket.SCREEN_SHARE_CMD_EXTERNAL_PAUSE /* 603 */:
                    if (ScreenShareActivity.this.mOtherPauseType == 0 && ScreenShareActivity.this.mPauseType == 0) {
                        ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_pause), 1);
                    }
                    ScreenShareActivity.this.setRemoteEnd();
                    ScreenShareActivity.this.mOtherPauseType = 2;
                    ScreenShareActivity.mScreenSharePopupMenuLayout.setOtherPause(ScreenShareActivity.this.mOtherPauseType);
                    ScreenShareActivity.mScreenShareViewLayout.setOtherPause(ScreenShareActivity.this.mOtherPauseType);
                    break;
                default:
                    ScreenShareActivity.this.OnRecveData(packet.getCommand(), packet.getCommandData());
                    break;
            }
        }

        @Override // com.coolots.chaton.call.screenshare.util.PenWriteNetwork.OnRecvDataCB
        public void onStop(int type) {
            ScreenShareActivity.mOnFinish = true;
            ScreenShareActivity.this.finish();
            ScreenShareActivity.logI("onStop mWriteNetwork");
            if (ScreenShareActivity.this.mWriteNetwork != null) {
                ScreenShareActivity.this.mWriteNetwork.stop();
            }
            ScreenShareActivity.logI("onStop mScreenShareViewOverlay");
            if (ScreenShareActivity.mScreenShareViewOverlay != null) {
                ScreenShareActivity.mScreenShareViewOverlay.destory();
                ScreenShareActivity.mScreenShareViewOverlay = null;
                ScreenShareViewOverlayPopupMenu.mInstance.destory();
            }
            ScreenShareActivity.logI("onStop mConsentRemoteControlDialog");
            if (ScreenShareActivity.this.mConsentRemoteControlDialog != null) {
                ScreenShareActivity.this.mConsentRemoteControlDialog.dismiss();
                ScreenShareActivity.this.mConsentRemoteControlDialogTimerHandler.removeCallbacks(ScreenShareActivity.this.mConsentRemoteControlDialogTimerRunnable);
                ScreenShareActivity.this.mConsentRemoteControlDialog = null;
            }
            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                ScreenShareActivity.this.overridePendingTransition(0, 0);
            }
            ScreenShareActivity.this.releaseWakelock();
        }

        @Override // com.coolots.chaton.call.screenshare.util.PenWriteNetwork.OnRecvDataCB
        public void onPause(int type) {
            ScreenShareActivity.logI("onPause(final int type) type = " + type);
            if (ScreenShareActivity.this.mOtherRestart.booleanValue()) {
                ScreenShareActivity.this.setOrientation();
                MainApplication.mPhoneManager.getShareScreenManager().resumeShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), ScreenShareActivity.this.mMenuPoint, false);
                return;
            }
            ScreenShareActivity.this.setRemoteEnd();
            if (ScreenShareActivity.this.mPauseType == 0) {
                ScreenShareActivity.this.releaseWakelock();
                if (ScreenShareActivity.this.mOtherPauseType == 0) {
                    ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_pause), 1);
                }
            }
            if (ScreenShareActivity.this.mPauseType == 2) {
                ScreenShareActivity.logI("OnRecvDataCB - OverlayView.SCREEN_SHARE_EXTERNAL_PAUSE_MODE!!!!!");
                ScreenShareActivity.mScreenShareViewLayout.setPause(2);
                ScreenShareActivity.mScreenSharePopupMenuLayout.setPause(2);
                if (ScreenShareActivity.mScreenShareViewOverlay != null) {
                    ScreenShareActivity.mScreenShareViewOverlay.setPause(2);
                    return;
                }
                return;
            }
            ScreenShareActivity.this.mPauseType = type;
            if (ScreenShareActivity.this.mPauseType == 1) {
                if (MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination().getDestinationType() == 4) {
                    byte[] packetData = ScreenSharePacket.makeStringPacket(MainApplication.mConfig.getProfileUserName());
                    ScreenShareActivity.this.onSendData(600, packetData);
                } else {
                    ScreenShareActivity.this.onSendData(600, null);
                }
            } else if (ScreenShareActivity.this.mPauseType == 2) {
                ScreenShareActivity.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_EXTERNAL_PAUSE, null);
            }
            ScreenShareActivity.mScreenShareViewLayout.setPause(ScreenShareActivity.this.mPauseType);
            ScreenShareActivity.mScreenSharePopupMenuLayout.setPause(ScreenShareActivity.this.mPauseType);
            if (ScreenShareActivity.mScreenShareViewOverlay != null) {
                ScreenShareActivity.mScreenShareViewOverlay.setMenuPosition(ScreenShareActivity.this.mMenuPoint);
                ScreenShareActivity.mScreenShareViewOverlay.setPause(ScreenShareActivity.this.mPauseType);
            }
            ScreenShareActivity.this.mMainBtn.setImageResource(C0000R.drawable.screenshare_main_pause_btn_selector);
            if (ScreenShareActivity.this.mCurrentMode == 101) {
                ScreenShareActivity.this.setPenWritingView(false, false, false);
            }
        }

        @Override // com.coolots.chaton.call.screenshare.util.PenWriteNetwork.OnRecvDataCB
        public void onResume(Point point, boolean mode) {
            ScreenShareActivity.logI("onResume(point, mode)" + ScreenShareActivity.this.mPauseType);
            if (ScreenShareActivity.this.mOtherRestart.booleanValue()) {
                ScreenShareActivity.this.mOtherRestart = false;
                return;
            }
            if (ScreenShareActivity.this.mPauseType == 2) {
                Intent i = new Intent(MainApplication.mContext, (Class<?>) ScreenShareActivity.class);
                i.addFlags(268435456);
                i.addFlags(536870912);
                i.addFlags(8388608);
                i.putExtra("menu_point", point);
                MainApplication.mContext.startActivity(i);
            }
            if (ScreenShareActivity.this.mPauseType != 0) {
                ScreenShareActivity.this.acquireWakelock();
                if (ScreenShareActivity.this.mOtherPauseType == 0) {
                    ScreenShareActivity.this.setOrientation();
                    ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_restart), 1);
                } else {
                    ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_other_pause), 1);
                }
                ScreenShareActivity.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_RESTART, null);
            }
            ScreenShareActivity.this.mPauseType = 0;
            if (ScreenShareActivity.mScreenShareViewOverlay != null) {
                ScreenShareActivity.mScreenShareViewOverlay.dispose();
                ScreenShareActivity.mScreenShareViewOverlay.destory();
                ScreenShareActivity.mScreenShareViewOverlay = null;
                ScreenShareViewOverlayPopupMenu.mInstance.destory();
            }
            ScreenShareActivity.this.setMainMenuPos(ScreenShareActivity.this.mMenuPoint.x, ScreenShareActivity.this.mMenuPoint.y);
            ScreenShareActivity.mScreenShareViewLayout.setPause(ScreenShareActivity.this.mPauseType);
            ScreenShareActivity.mScreenSharePopupMenuLayout.setPause(ScreenShareActivity.this.mPauseType);
            ScreenShareActivity.this.mMainBtn.setImageResource(C0000R.drawable.screenshare_main_share_btn_selector);
            boolean isDocsMode = false;
            if (ScreenShareActivity.this.mOtherStateMode == 3 || ScreenShareActivity.this.mOtherStateMode == 4) {
                isDocsMode = true;
            }
            ScreenShareActivity.this.setPenWritingView(ScreenShareActivity.this.mOtherPenWriteMode, isDocsMode, false);
            if (mode || ScreenShareActivity.this.mOtherStateMode == 3) {
                ScreenShareActivity.this.setPenWritingView(false, true, false);
            }
        }

        @Override // com.coolots.chaton.call.screenshare.util.PenWriteNetwork.OnRecvDataCB
        public void onStart(int w, int h, String userID) {
        }

        @Override // com.coolots.chaton.call.screenshare.util.PenWriteNetwork.OnRecvDataCB
        public void onCallNotifyNetworkWeakReceive(int bandWidth) {
            ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_network_weak_popup), 1);
        }

        @Override // com.coolots.chaton.call.screenshare.util.PenWriteNetwork.OnRecvDataCB
        public void onSecureErrorForShareScreen() {
            ScreenShareActivity.this.showSecureMode();
        }

        @Override // com.coolots.chaton.call.screenshare.util.PenWriteNetwork.OnRecvDataCB
        public void onSecureModeEndForShareScreen() {
            ScreenShareActivity.this.hideSecureMode();
        }

        @Override // com.coolots.chaton.call.screenshare.util.PenWriteNetwork.OnRecvDataCB
        public void onResultCaptureImage(int arg0) {
        }
    };
    private View.OnLongClickListener mBtnOnLongClickListener = new View.OnLongClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareActivity.2
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ScreenShareActivity.dragFlag == 0) {
                ScreenShareActivity.dragFlag = 1;
                ScreenShareActivity.this.isMoveFirst = false;
            }
            return false;
        }
    };
    private View.OnTouchListener mBtnOnTouchListener = new View.OnTouchListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareActivity.3
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent event) {
            switch (event.getAction()) {
                case 0:
                    if (ScreenShareActivity.this.mStartPoint == null) {
                        ScreenShareActivity.this.mStartPoint = new Point((int) ScreenShareActivity.this.mShareBtnLayout.getX(), (int) ScreenShareActivity.this.mShareBtnLayout.getY());
                    }
                    ScreenShareActivity.this.mCurrentPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                    return false;
                case 1:
                    if (ScreenShareActivity.dragFlag != 1) {
                        ScreenShareActivity.logI("mBtnOnClickListener");
                        int nBtnId = view.getId();
                        if (nBtnId == C0000R.id.share_btn) {
                            if (ScreenShareActivity.mScreenSharePopupMenuLayout.getIsShow()) {
                                ScreenShareActivity.this.setMainButtonContentDiscription(false);
                                ScreenShareActivity.mScreenSharePopupMenuLayout.dismiss();
                            } else {
                                ScreenShareActivity.this.setMainButtonContentDiscription(true);
                                ScreenShareActivity.mScreenSharePopupMenuLayout.show();
                            }
                        } else if (nBtnId == C0000R.id.share_end_btn) {
                            ScreenShareActivity.logI("MainEndBtn Clicked ");
                            ScreenShareActivity.this.setShareEnd();
                        }
                    } else {
                        ScreenShareActivity.dragFlag = 0;
                        if (!ScreenShareActivity.this.isMoveFirst) {
                            ScreenShareActivity.this.sendBtnEdge();
                        }
                    }
                    return false;
                case 2:
                    if (ScreenShareActivity.dragFlag == 1) {
                        int[] gap = {((int) event.getRawX()) - ScreenShareActivity.this.mCurrentPoint.x, ((int) event.getRawY()) - ScreenShareActivity.this.mCurrentPoint.y};
                        if (ScreenShareActivity.this.isMoveFirst || Math.abs(gap[0]) > 10 || Math.abs(gap[1]) > 10) {
                            ScreenShareActivity.this.isMoveFirst = true;
                            ScreenShareActivity.this.mCurrentPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                        } else {
                            gap[0] = 0;
                            gap[1] = 0;
                        }
                        ScreenShareActivity.this.setBtnPos(gap);
                    }
                    return false;
                default:
                    return false;
            }
        }
    };
    public ActivityManager activitymanager = null;

    private static void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logI("onCreate()");
        if (!ScreenShareProc.getInstance().getStart()) {
            logI(" not excute share screen! ");
            finish();
            return;
        }
        mIsOnPause = false;
        mInstance = this;
        mScreenShareViewOverlay = null;
        getWindow().setFlags(1024, 1024);
        ScreenShareMessageReceiver.setShare(false);
        mIsRemote = 0;
        Intent intent = getIntent();
        this.mUserID = intent.getIntExtra("UserID", 2);
        this.mShareMode = intent.getIntExtra("StartMode", 1);
        this.mMenuPoint = (Point) intent.getExtra("menu_point");
        if (this.mMenuPoint != null) {
            logI("onCreate pos x: " + this.mMenuPoint.x + " y: " + this.mMenuPoint.y);
        }
        logI("mShareMode :" + this.mShareMode);
        this.mPhoneStateMachine = MainApplication.mPhoneManager.getPhoneStateMachine();
        if (this.mInflater == null) {
            this.mInflater = (LayoutInflater) getSystemService("layout_inflater");
        }
        mMainLayout = (FrameLayout) this.mInflater.inflate(C0000R.layout.screenshare_videoview, (ViewGroup) null);
        this.mCurrentMode = 100;
        initView();
        initScaleData();
        this.mWriteNetwork = new PenWriteNetwork();
        this.mWriteNetwork.setOnRecvDataCB(this.onRecvDataCB);
        mSecureModeLayout = (LinearLayout) this.mInflater.inflate(C0000R.layout.screenshare_secure_mode, (ViewGroup) null);
        mScreenShareViewLayout = new ScreenShareViewLayout(this, C0000R.layout.screenshare_main_screen_share);
        mPenWritingViewLayout = new PenWritingViewLayout(this, C0000R.layout.screenshare_pen_writing, this);
        mDocsMenuViewLayout = new DocsMenuViewLayout(this, C0000R.layout.screenshare_docs_view_layout, this);
        mScreenSharePopupMenuLayout = new ScreenSharePopupMenuLayout(this, C0000R.layout.screenshare_main_popup_menu);
        mTransParentLayout = (FrameLayout) mMainLayout.findViewById(C0000R.id.transparent_layout);
        mScreenSharePopupMenuLayout.dismiss();
        mScreenSharePopupMenuLayout.setViewMode(2);
        mOverlayPopupMenuMode = 2;
        this.mShareBtnLayout = (RelativeLayout) mScreenShareViewLayout.findViewById(C0000R.id.share_btn_layout);
        this.mMainBtn = (ImageButton) mScreenShareViewLayout.findViewById(C0000R.id.share_btn);
        this.mMainBtn.setImageResource(C0000R.drawable.screenshare_main_share_btn_selector);
        this.mEndBtn = (Button) mScreenShareViewLayout.findViewById(C0000R.id.share_end_btn);
        setMainButtonContentDiscription(false);
        mScreenShareViewLayout.setLayoutParams((RelativeLayout.LayoutParams) mScreenShareViewLayout.getLayoutParams());
        RelativeLayout penToolbarLayout = (RelativeLayout) mPenWritingViewLayout.findViewById(C0000R.id.share_view_toolbar_layout1);
        RelativeLayout docsPenToolbarLayout = (RelativeLayout) mDocsMenuViewLayout.findViewById(C0000R.id.share_view_toolbar_layout_docs_layout_1);
        RelativeLayout.LayoutParams ScreenShareViewLayoutParams = (RelativeLayout.LayoutParams) penToolbarLayout.getLayoutParams();
        ScreenShareViewLayoutParams.topMargin = (int) (getResources().getDisplayMetrics().density * 25.0f);
        penToolbarLayout.setLayoutParams(ScreenShareViewLayoutParams);
        docsPenToolbarLayout.setLayoutParams(ScreenShareViewLayoutParams);
        mPenWritingViewLayout.setUserID(this.mUserID);
        mDocsMenuViewLayout.setUserID(this.mUserID);
        Toast.makeText(this, getString(C0000R.string.screenshare_start), 1).show();
        getSystemPowermanager();
        getSystemWakeLock();
        acquireWakelock();
        this.mMainBtn.setOnLongClickListener(this.mBtnOnLongClickListener);
        this.mEndBtn.setOnLongClickListener(this.mBtnOnLongClickListener);
        this.mMainBtn.setOnTouchListener(this.mBtnOnTouchListener);
        this.mEndBtn.setOnTouchListener(this.mBtnOnTouchListener);
        mScreenSharePopupMenuLayout.setOnButtonEvent(new ScreenShareLayout.OnButtonEvent() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareActivity.4
            @Override // com.coolots.chaton.call.screenshare.activity.ScreenShareLayout.OnButtonEvent
            public void onClickButtonEvent(int id) {
                if (id == C0000R.id.menu_pen_writing_btn) {
                    if (ScreenShareActivity.this.mOtherPauseType == 2 && ScreenShareActivity.this.mPauseType == 1) {
                        ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.unable_pen_writing_chatonv_call_hold), 0);
                        return;
                    } else if (ScreenShareActivity.this.mPauseType == 2) {
                        ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.unable_pen_writing_chatonv_call_hold), 0);
                        return;
                    } else {
                        if (ScreenShareActivity.this.mPauseType != 0) {
                            MainApplication.mPhoneManager.getShareScreenManager().resumeShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), ScreenShareActivity.this.mMenuPoint, false);
                        }
                        ScreenShareActivity.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_DRAWING_REQ_MODE, null);
                    }
                } else if (id != C0000R.id.menu_end_btn) {
                    if (id == C0000R.id.menu_pause_btn) {
                        if (ScreenShareActivity.this.mPauseType == 2) {
                            ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.unable_restart_chatonv_call_hold), 0);
                            return;
                        } else if (ScreenShareActivity.this.mPauseType != 0) {
                            if (ScreenShareActivity.this.mOtherPauseType == 2) {
                                ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.unable_restart_chatonv_call_hold), 0);
                                return;
                            }
                            MainApplication.mPhoneManager.getShareScreenManager().resumeShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), ScreenShareActivity.this.mMenuPoint, false);
                        } else if (ScreenShareActivity.this.mPauseType == 0) {
                            MainApplication.mPhoneManager.getShareScreenManager().pauseShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), 0);
                        }
                    } else if (id == C0000R.id.menu_remote_btn) {
                        if (ScreenShareActivity.this.mPauseType != 0) {
                            MainApplication.mPhoneManager.getShareScreenManager().resumeShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), ScreenShareActivity.this.mMenuPoint, false);
                        }
                        if (ScreenShareActivity.mIsRemote == 0 && ScreenShareActivity.this.mCurrentMode == 100) {
                            ScreenShareActivity.logI("Remote Mode request onSendData");
                            byte[] packetData = ScreenSharePacket.makeStringPacket(MainApplication.mConfig.getProfileUserName());
                            ScreenShareActivity.this.onSendData(404, packetData);
                            ScreenShareActivity.this.makeProgressDialogForRemoteControlProcess(ScreenShareActivity.this.getString(C0000R.string.call_dialog_share_screen));
                            ScreenShareActivity.this.consentRemoteControlProgressDialogTimer();
                        } else if (ScreenShareActivity.mIsRemote == 1 && ScreenShareActivity.this.mCurrentMode == 100) {
                            ScreenShareActivity.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHNAGE_REMOTE_END, null);
                            ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_remote_control_end), 0);
                            ScreenShareActivity.this.setRemoteEnd();
                        }
                    } else if (id == C0000R.id.menu_main_remote_menu) {
                        if (ScreenShareActivity.mIsRemote == 1 && ScreenShareActivity.this.mCurrentMode == 100) {
                            ScreenShareActivity.logI("remote btn clicked - menu_main_remote_menu");
                            byte[] cmdData = ScreenShareRemotePacket.makeRemoteKey(82);
                            ScreenShareActivity.this.onSendData(500, cmdData);
                        }
                    } else if (id == C0000R.id.menu_main_remote_home) {
                        if (ScreenShareActivity.mIsRemote == 1 && ScreenShareActivity.this.mCurrentMode == 100) {
                            byte[] cmdData2 = ScreenShareRemotePacket.makeRemoteKey(3);
                            ScreenShareActivity.this.onSendData(500, cmdData2);
                        }
                    } else if (id == C0000R.id.menu_main_remote_back && ScreenShareActivity.mIsRemote == 1 && ScreenShareActivity.this.mCurrentMode == 100) {
                        byte[] cmdData3 = ScreenShareRemotePacket.makeRemoteKey(4);
                        ScreenShareActivity.this.onSendData(500, cmdData3);
                    }
                } else {
                    ScreenShareActivity.this.setShareEnd();
                }
                if (ScreenShareActivity.mScreenSharePopupMenuLayout.getIsShow()) {
                    ScreenShareActivity.mScreenSharePopupMenuLayout.dismiss(0);
                }
            }
        });
        mPenWritingViewLayout.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == C0000R.id.share_end_btn) {
                    ScreenShareActivity.logI("Pen Writing End Button Clicked!!");
                    ScreenShareActivity.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_SHARE_MODE, null);
                    ScreenShareActivity.this.mOtherPenWriteMode = false;
                    ScreenShareActivity.this.mOtherStateMode = 0;
                }
            }
        });
        mDocsMenuViewLayout.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == C0000R.id.share_end_btn) {
                    ScreenShareActivity.logI("Pen Writing End Button Clicked!!");
                    ScreenShareActivity.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_SHARE_MODE, null);
                    ScreenShareActivity.this.mOtherPenWriteMode = false;
                    ScreenShareActivity.this.mOtherStateMode = 0;
                }
            }
        });
        mScreenShareViewLayout.SetOnSendCommandData(new OverlayView.OnSendCommandData() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareActivity.7
            @Override // com.coolots.chaton.call.screenshare.core.OverlayView.OnSendCommandData
            public void onSendData(int command, byte[] data) {
                ScreenShareActivity.this.onSendData(command, data);
            }
        });
        mPenWritingViewLayout.SetOnSendCommandData(new OverlayView.OnSendCommandData() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareActivity.8
            @Override // com.coolots.chaton.call.screenshare.core.OverlayView.OnSendCommandData
            public void onSendData(int command, byte[] data) {
                ScreenShareActivity.this.onSendData(command, data);
            }
        });
        mDocsMenuViewLayout.SetOnSendCommandData(new OverlayView.OnSendCommandData() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareActivity.9
            @Override // com.coolots.chaton.call.screenshare.core.OverlayView.OnSendCommandData
            public void onSendData(int command, byte[] data) {
                ScreenShareActivity.this.onSendData(command, data);
            }
        });
        if (MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination() != null) {
            if (MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination().getDestinationType() == 4) {
                this.mCurOrientation = getSystemBarOrientation();
                setScreenRotation();
                this.mOrientation = new OrientationEventListener(MainApplication.mContext) { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareActivity.10
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int orientation) {
                        if (ScreenShareActivity.this.mPauseType == 2 || ScreenShareActivity.this.mPauseType == 1) {
                            ScreenShareActivity.logI("coference call, pause => not onOrientationChanged");
                            return;
                        }
                        int dir = ScreenShareActivity.this.get45UnitAngleFromFullAngle(orientation);
                        if (dir != ScreenShareActivity.this.mCurOrientation) {
                            try {
                                ScreenShareActivity.logI("onOrientationChanged orientation=" + dir);
                                ScreenShareActivity.this.mCurOrientation = dir;
                                ScreenShareActivity.this.setScreenRotation();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
                this.mOrientation.enable();
            } else {
                MainApplication.mPhoneManager.getPhoneStateMachine().sendRotationInfo(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), 0, isAutoRatationActive(), false);
            }
        }
        mTransParentLayout.addView(mSecureModeLayout);
        mTransParentLayout.addView(mPenWritingViewLayout);
        mTransParentLayout.addView(mDocsMenuViewLayout);
        mTransParentLayout.addView(mScreenShareViewLayout);
        mTransParentLayout.addView(mScreenSharePopupMenuLayout);
        FrameLayout.LayoutParams screenShareViewLayotParams = (FrameLayout.LayoutParams) mScreenShareViewLayout.getLayoutParams();
        if (this.mMenuPoint == null || (this.mMenuPoint.x == 0 && this.mMenuPoint.y == 0)) {
            float posY = 25.0f * getResources().getDisplayMetrics().density;
            mScreenShareViewLayout.setY(posY);
            this.mMenuPoint = new Point(0, (int) posY);
        } else {
            mScreenShareViewLayout.setX(this.mMenuPoint.x);
            mScreenShareViewLayout.setY(this.mMenuPoint.y);
        }
        mScreenShareViewLayout.setLayoutParams(screenShareViewLayotParams);
        setContentView(mMainLayout);
        mPenWritingViewLayout.setVisibility(8);
        mDocsMenuViewLayout.setVisibility(8);
        mSecureModeLayout.setVisibility(8);
        attentionAlertDialog();
        if (MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination() != null && MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination().getDestinationType() == 4) {
            stretchShareScreenView();
        }
    }

    public void initScaleData() {
        if (this.mScreenScale == null) {
            this.mScreenScale = ScreenShareScale.getInstance();
        }
        this.mScreenScale.initScaleData();
    }

    public void OnRecveData(int command, byte[] data) {
        logI("command " + command);
        if (mDocsMenuViewLayout != null && (this.mOtherStateMode == 3 || this.mOtherStateMode == 4)) {
            mDocsMenuViewLayout.OnRecveData(command, data);
        }
        if (mPenWritingViewLayout != null && this.mOtherPenWriteMode) {
            mPenWritingViewLayout.OnRecveData(command, data);
        }
        if (mScreenShareViewLayout != null) {
            mScreenShareViewLayout.OnRecveData(command, data);
        }
    }

    protected void onSendData(int command, byte[] data) {
        byte[] sendData = ScreenSharePacket.makePacket(command, data);
        if (this.mWriteNetwork != null) {
            this.mWriteNetwork.sendData(sendData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShareEnd() {
        ChatONDialog.Builder dialogs = new ChatONDialog.Builder(this);
        dialogs.setTitle(C0000R.string.call_btn_share_screen);
        dialogs.setMessage(C0000R.string.screenshare_end_popup);
        dialogs.setPositiveButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareActivity.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                ScreenShareActivity.mScreenSharePopupMenuLayout.dismiss(0);
                if (ScreenShareActivity.this.mShareMode != 1) {
                    if (ScreenShareActivity.this.mShareMode == 3) {
                        ScreenShareActivity.this.mPhoneStateMachine.localHangupCall(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), 10);
                        return;
                    }
                    return;
                }
                MainApplication.mPhoneManager.getShareScreenManager().stopShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination());
            }
        });
        dialogs.setNegativeButton(C0000R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareActivity.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        dialogs.setCancelable(true);
        dialogs.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareActivity.13
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface arg0) {
                ScreenShareActivity.logI("haeri= back key press!!!!");
            }
        });
        dialogs.show();
    }

    private void initView() {
        this.mRemoteSurface = (SurfaceView) mMainLayout.findViewById(C0000R.id.remote_view);
        this.mRemoteHolder = this.mRemoteSurface.getHolder();
        this.mRemoteHolder.addCallback(this);
        this.mRemoteHolder.setType(3);
        gonePreviewLayout();
    }

    private void gonePreviewLayout() {
        FrameLayout previewContainer = (FrameLayout) mMainLayout.findViewById(C0000R.id.preview_layout);
        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) previewContainer.getLayoutParams();
        param.width = 100;
        param.height = 100;
        param.gravity = 51;
        param.setMargins(-300, -332, 0, 0);
        previewContainer.setLayoutParams(param);
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        logI("onUserLeaveHint()");
        if (this.mPauseType == 0) {
            MainApplication.mPhoneManager.getShareScreenManager().pauseShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), 0);
        }
        doScreenShotByUsingReflection();
    }

    private void doScreenShotByUsingReflection() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        logI("Build.VERSION.SDK_INT:  " + Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT < 18) {
            logI("doScreenShotByUsingReflection android.view.Surface.screenshot(1080, 1920, 20000, 40000)");
            try {
                Class surfaceClass = Class.forName("android.view.Surface");
                if (surfaceClass != null) {
                    Class[] paramtypes = {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE};
                    Method method = surfaceClass.getMethod("screenshot", paramtypes);
                    Object[] arglist = {new Integer(1080), new Integer(1920), new Integer(20000), new Integer(ConnectionManager.DEFAULT_TIMEOUT_SLOW_NETWORK)};
                    Object retobj = method.invoke(null, arglist);
                    this.mBitmapBackup = (Bitmap) retobj;
                    return;
                }
                return;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return;
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return;
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
                return;
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
                return;
            } catch (Exception e6) {
                e6.printStackTrace();
                return;
            }
        }
        logI("doScreenShotByUsingReflection SurfaceControl.screenshot(1080, 1920, 20000, 40000)");
        this.mBitmapBackup = SurfaceControl.screenshot(1080, 1920, 20000, ConnectionManager.DEFAULT_TIMEOUT_SLOW_NETWORK);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        if (this.mRemoteHolder != null && this.mRemoteHolder.equals(holder) && this.mBitmapBackup != null) {
            Canvas can = this.mRemoteHolder.lockCanvas();
            synchronized (this.mRemoteHolder) {
                can.drawColor(0, PorterDuff.Mode.CLEAR);
                if (MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination() != null && MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination().getDestinationType() == 4) {
                    can.drawBitmap(this.mBitmapBackup, 192.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
                } else {
                    can.drawBitmap(this.mBitmapBackup, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
                }
            }
            this.mRemoteHolder.unlockCanvasAndPost(can);
        }
        if (this.mSurface != null) {
            this.mHolder.equals(holder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (this.mRemoteHolder != null && this.mRemoteHolder.equals(holder)) {
            SECConfig.setVideoSurfaceData(1, null);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        logI("surfaceChanged()");
        if (this.mRemoteHolder != null && this.mRemoteHolder.equals(holder)) {
            logI("surfaceChanged() remoteview");
            SECConfig.setVideoSurfaceData(1, null);
            SECConfig.setVideoSurfaceData(1, this.mRemoteHolder.getSurface());
        } else if (this.mSurface != null && this.mHolder.equals(holder)) {
            SECConfig.setVideoSurfaceData(0, null);
            SECConfig.setVideoSurfaceData(0, this.mHolder.getSurface());
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder holder) {
        logI("surfaceChanged()");
        if (this.mRemoteHolder != null && this.mRemoteHolder.equals(holder)) {
            logI("surfaceChanged() remoteview");
            SECConfig.setVideoSurfaceData(1, null);
            SECConfig.setVideoSurfaceData(1, this.mRemoteHolder.getSurface());
        } else if (this.mSurface != null && this.mHolder.equals(holder)) {
            SECConfig.setVideoSurfaceData(0, null);
            SECConfig.setVideoSurfaceData(0, this.mHolder.getSurface());
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4) {
            return super.onKeyDown(keyCode, event);
        }
        logI("haeri=KeyEvent.KEYCODE_BACK");
        return true;
    }

    public void sendKeyEvent(int KeyCode) {
        byte[] cmdData = ScreenShareRemotePacket.makeRemoteKey(KeyCode);
        onSendData(500, cmdData);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0114  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coolots.chaton.call.screenshare.activity.ScreenShareActivity.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void makeProgressDialogForRemoteControlProcess(String str) {
        if (this.mConsentRemoteControlDialog != null) {
            this.mConsentRemoteControlDialog.dismiss();
            this.mConsentRemoteControlDialog = null;
        }
        this.mConsentRemoteControlDialog = new ProgressDialog(this, C0000R.style.ChatOnVProgress);
        this.mConsentRemoteControlDialog.setIndeterminate(true);
        this.mConsentRemoteControlDialog.setCancelable(false);
        this.mConsentRemoteControlDialog.setCanceledOnTouchOutside(false);
        this.mConsentRemoteControlDialog.setIndeterminateDrawable(getResources().getDrawable(C0000R.drawable.chaton_ani_progress));
        this.mConsentRemoteControlDialog.setMessage(str);
        this.mConsentRemoteControlDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void consentRemoteControlProgressDialogTimer() {
        if (this.mConsentRemoteControlDialog != null) {
            this.mConsentRemoteControlDialogTimerHandler = new Handler();
            this.mConsentRemoteControlDialogTimerRunnable = new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareActivity.14
                @Override // java.lang.Runnable
                public void run() {
                    ScreenShareActivity.this.mConsentRemoteControlDialog.dismiss();
                    ScreenShareActivity.this.mConsentRemoteControlDialog = null;
                    Toast.makeText(ScreenShareActivity.this, ScreenShareActivity.this.getString(C0000R.string.screenshare_remote_control_timeout), 0).show();
                }
            };
            this.mConsentRemoteControlDialogTimerHandler.postDelayed(this.mConsentRemoteControlDialogTimerRunnable, 10000L);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        logI("onPause()");
        mIsOnPause = true;
        if (!mOnFinish) {
            setRemoteEnd();
            logI("ScreenShareViewOverlay onPause");
            mScreenSharePopupMenuLayout.dismiss(0);
            mScreenShareViewOverlay = new ScreenShareViewOverlay(MainApplication.mContext, C0000R.layout.screenshare_main_screen_share_overlay, this.mShareMode);
            mScreenShareViewOverlay.setMenuPosition(this.mMenuPoint);
            mScreenShareViewOverlay.show();
            mScreenShareViewOverlay.setPause(this.mPauseType);
            onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_EXTERNAL_PAUSE, null);
            releaseWakelock();
            if (this.mPauseType == 0) {
                ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_pause), 1);
                this.mPauseType = 2;
            }
            if (this.mCurrentMode == 101) {
                setPenWritingView(false, false, true);
            }
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        logI("onResume()");
        mIsOnPause = false;
        if (mScreenShareViewOverlay != null) {
            mScreenShareViewOverlay.dispose();
            mScreenShareViewOverlay.destory();
            mScreenShareViewOverlay = null;
            ScreenShareViewOverlayPopupMenu.mInstance.destory();
            this.mPauseType = 0;
            onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_RESTART, null);
            acquireWakelock();
            if (this.mOtherPauseType == 0) {
                if (MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination().getDestinationType() == 4) {
                    setScreenRotation();
                } else {
                    setOrientation();
                }
                ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_restart), 1);
            } else {
                ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_other_pause), 1);
            }
            mScreenShareViewLayout.setPause(this.mPauseType);
            mScreenSharePopupMenuLayout.setPause(this.mPauseType);
            this.mMainBtn.setImageResource(C0000R.drawable.screenshare_main_share_btn_selector);
            boolean isDocsMode = false;
            if (this.mOtherStateMode == 3 || this.mOtherStateMode == 4) {
                isDocsMode = true;
            }
            setPenWritingView(this.mOtherPenWriteMode, isDocsMode, false);
        }
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        logI("onDestroy");
        dispose();
        ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_end), 1);
        super.onDestroy();
    }

    public void setOrientation() {
        int rotate = 1;
        switch (this.mOtherOrientation) {
            case 1:
                rotate = 0;
                break;
            case 2:
                rotate = 9;
                break;
            case 3:
                rotate = 8;
                break;
        }
        logI("setRequestedOrientation : " + rotate);
        setRequestedOrientation(rotate);
        mPenWritingViewLayout.penToolbarResize();
        mDocsMenuViewLayout.penToolbarResize();
        if (this.mMenuPoint == null || (this.mMenuPoint.x == 0 && this.mMenuPoint.y == 0)) {
            int posY = (int) (25.0f * getResources().getDisplayMetrics().density);
            mScreenShareViewLayout.setX(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            mScreenShareViewLayout.setY(posY);
            this.mMenuPoint = new Point(0, 0);
        } else {
            mScreenShareViewLayout.setX(this.mMenuPoint.x);
            mScreenShareViewLayout.setY(this.mMenuPoint.y);
        }
        mScreenSharePopupMenuLayout.setMenuRotated();
    }

    public void sendBtnEdge() {
        Point screenSize = getScreenSize();
        int screenCenter = screenSize.x / 2;
        int posX = (int) mScreenShareViewLayout.getX();
        int lastX = 0;
        int layoutCenter = posX + (mScreenShareViewLayout.getWidth() / 2);
        if (screenCenter > layoutCenter) {
            lastX = screenSize.x - this.mShareBtnLayout.getWidth();
        }
        logI("move Pos= " + lastX + ChatONVAPII.USERID_DELEMETER + posX);
        ObjectAnimator an = ObjectAnimator.ofFloat(mScreenShareViewLayout, "translationX", posX, lastX);
        an.setDuration(500L);
        an.start();
    }

    public void setBtnPos(int[] gap) {
        int[] pos = {((int) mScreenShareViewLayout.getX()) + gap[0], ((int) mScreenShareViewLayout.getY()) + gap[1]};
        int[] moveArea = getMoveArea(mScreenShareViewLayout.getWidth(), mScreenShareViewLayout.getHeight());
        logI("Menu Position btn moveArea=" + moveArea[0] + ", " + moveArea[1] + ", " + moveArea[2] + ", " + moveArea[3]);
        if (pos[0] < moveArea[0]) {
            pos[0] = moveArea[0];
        }
        if (pos[0] > moveArea[2]) {
            pos[0] = moveArea[2];
        }
        if (pos[1] < moveArea[1]) {
            pos[1] = moveArea[1];
        }
        if (pos[1] > moveArea[3]) {
            pos[1] = moveArea[3];
        }
        logI("Menu Position Btn Changed X=" + pos[0] + ", Y=" + pos[1]);
        mScreenShareViewLayout.setX(pos[0]);
        mScreenShareViewLayout.setY(pos[1]);
        this.mMenuPoint.x = pos[0];
        this.mMenuPoint.y = pos[1];
    }

    public void setMainMenuPos(int posX, int posY) {
        logI("1.Menu setMenuPos=" + posX + ", " + posY + ", " + posY);
        int[] pos = {posX, posY};
        int hei = mScreenShareViewLayout.getHeight();
        int[] moveArea = getMoveArea(mScreenShareViewLayout.getWidth(), hei);
        logI("1.Menu setMainMenuPos moveArea=" + moveArea[0] + ", " + moveArea[1] + ", " + moveArea[2] + ", " + moveArea[3]);
        if (pos[0] < moveArea[0]) {
            pos[0] = moveArea[0];
        }
        if (pos[1] < moveArea[1]) {
            pos[1] = moveArea[1];
        }
        if (pos[0] > moveArea[2]) {
            pos[0] = moveArea[2];
        }
        if (pos[1] > moveArea[3]) {
            pos[1] = moveArea[3];
        }
        logI("1.Menu setMainMenuPos Changed X=" + pos[0] + ", Y=" + pos[1]);
        mScreenShareViewLayout.setX(pos[0]);
        mScreenShareViewLayout.setY(pos[1]);
        this.mMenuPoint.x = pos[0];
        this.mMenuPoint.y = pos[1];
    }

    public void setMenuPos(int posX, int posY) {
        int[] pos = {posX, posY};
        int hei = mScreenSharePopupMenuLayout.getMenuHeightDPI();
        int[] moveArea = getMoveArea(mScreenSharePopupMenuLayout.getWidth(), hei);
        logI("1.Menu Position moveArea=" + moveArea[0] + ", " + moveArea[1] + ", " + moveArea[2] + ", " + moveArea[3]);
        if (pos[0] < moveArea[0]) {
            pos[0] = moveArea[0];
        }
        if (pos[1] < moveArea[1]) {
            pos[1] = moveArea[1];
        }
        if (pos[0] > moveArea[2]) {
            pos[0] = moveArea[2];
        }
        if (pos[1] > moveArea[3]) {
            pos[1] = moveArea[3];
        }
        logI("1.Menu Position Changed X=" + pos[0] + ", Y=" + pos[1]);
        mScreenSharePopupMenuLayout.setX(pos[0]);
        mScreenSharePopupMenuLayout.setY(pos[1]);
        setMenuHeight();
    }

    public void setMenuPos(int[] gap) {
        int[] pos = {((int) mScreenSharePopupMenuLayout.getX()) + gap[0], ((int) mScreenSharePopupMenuLayout.getY()) + gap[1]};
        logI("Menu Position X=" + pos[0] + ", Y=" + pos[1]);
        int hei = mScreenSharePopupMenuLayout.getMenuHeightDPI();
        int[] moveArea = getMoveArea(mScreenSharePopupMenuLayout.getWidth(), hei);
        logI("2.Menu Position moveArea=" + moveArea[0] + ", " + moveArea[1] + ", " + moveArea[2] + ", " + moveArea[3]);
        if (pos[0] < moveArea[0]) {
            pos[0] = moveArea[0];
        }
        if (pos[1] < moveArea[1]) {
            pos[1] = moveArea[1];
        }
        if (pos[0] > moveArea[2]) {
            pos[0] = moveArea[2];
        }
        if (pos[1] > moveArea[3]) {
            pos[1] = moveArea[3];
        }
        logI("2.Menu Position Changed X=" + pos[0] + ", Y=" + pos[1]);
        mScreenSharePopupMenuLayout.setX(pos[0]);
        mScreenSharePopupMenuLayout.setY(pos[1]);
        setMenuHeight();
    }

    public void setMenuHeight() {
        int hei = mScreenSharePopupMenuLayout.getMenuHeightDPI();
        FrameLayout.LayoutParams layoutparams = (FrameLayout.LayoutParams) mScreenSharePopupMenuLayout.getLayoutParams();
        layoutparams.height = hei;
        mScreenSharePopupMenuLayout.setLayoutParams(layoutparams);
    }

    public int[] getMoveArea(int layout_width, int layout_hei) {
        Point size = new Point();
        getWindow().getWindowManager().getDefaultDisplay().getRealSize(size);
        int[] iArr = new int[4];
        int[] points = {0, 0, size.x - layout_width, size.y - layout_hei};
        return points;
    }

    public void setOtherPause(boolean flag) {
        this.mOtherPenWriteMode = flag;
    }

    public void setOtherState(int value) {
        this.mOtherStateMode = value;
    }

    public static void showToast(int resid, int duration) {
        String msg = MainApplication.mContext.getString(resid);
        showToast(msg, duration);
    }

    public static void showToast(String msg, int duration) {
    }

    private ScreenShareToast showToast(String msg) {
        LinearLayout ll = new LinearLayout(MainApplication.mContext);
        ll.setOrientation(0);
        ll.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        ll.setBackgroundResource(C0000R.drawable.progress_popup_bg);
        ll.setGravity(17);
        logI("Toast Message: " + msg);
        TextView tvmsg = new TextView(MainApplication.mContext);
        int pad2 = (int) (5.0f * tvmsg.getResources().getDisplayMetrics().density);
        tvmsg.setGravity(17);
        tvmsg.setPadding(pad2, 0, pad2, 0);
        tvmsg.setTextColor(-16777216);
        tvmsg.setText(msg);
        ll.addView(tvmsg);
        ScreenShareToast toast_view = new ScreenShareToast(MainApplication.mContext);
        toast_view.setView(ll);
        toast_view.setDuration(0);
        return toast_view;
    }

    public void getSystemPowermanager() {
        logI("WAKE LOCK - getSystemPowermanager");
        if (this.mPowerManager == null) {
            this.mPowerManager = (PowerManager) MainApplication.mContext.getSystemService("power");
        }
    }

    public void getSystemWakeLock() {
        if (this.mPowerManager != null) {
            logI("WAKE LOCK - not null - getSystemWakeLock");
            this.mWakeLock = this.mPowerManager.newWakeLock(10, MainApplication.mContext.getClass().getName());
        }
    }

    public void acquireWakelock() {
        logI("WAKE LOCK - acquireWakelock");
        if (this.mWakeLock == null) {
            this.mWakeLock = this.mPowerManager.newWakeLock(10, MainApplication.mContext.getClass().getName());
        }
        this.mWakeLock.acquire();
    }

    public void releaseWakelock() {
        if (this.mWakeLock != null) {
            logI("WAKE LOCK - releaseWakelock");
            this.mWakeLock.release();
            this.mWakeLock = null;
        }
    }

    public Point getScreenSize() {
        Point size = new Point();
        Display screenSize = getWindow().getWindowManager().getDefaultDisplay();
        screenSize.getRealSize(size);
        return size;
    }

    static class MainHandler extends Handler {
        WeakReference<ScreenShareActivity> mFrag;

        MainHandler(ScreenShareActivity aFragment) {
            this.mFrag = new WeakReference<>(aFragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == 1000) {
                ScreenShareActivity.mPenWritingViewLayout.show();
                return;
            }
            if (msg.what == 1001) {
                ScreenShareActivity.mScreenShareViewLayout.show();
            } else if (msg.what == 1002) {
                ScreenShareActivity.mDocsMenuViewLayout.penToolbarResize();
                ScreenShareActivity.mDocsMenuViewLayout.show();
            }
        }
    }

    protected void setPenWritingView(boolean penWriting, boolean docsView, boolean isOverlay) {
        logI("setPenWritingView:  " + penWriting);
        if (penWriting) {
            if (!isOverlay) {
                if (mScreenShareViewLayout != null) {
                    mScreenShareViewLayout.dismiss();
                }
                if (mScreenSharePopupMenuLayout != null) {
                    mScreenSharePopupMenuLayout.dismiss(0);
                }
                if (mDocsMenuViewLayout != null) {
                    mDocsMenuViewLayout.dismiss();
                }
            }
            if (mPenWritingViewLayout != null) {
                mPenWritingViewLayout.setPenDocsMode(this.mOtherStateMode == 1);
                mPenWritingViewLayout.show();
            }
            this.mCurrentMode = 101;
            return;
        }
        if (docsView) {
            if (!isOverlay) {
                if (mScreenShareViewLayout != null) {
                    mScreenShareViewLayout.dismiss();
                }
                if (mScreenSharePopupMenuLayout != null) {
                    mScreenSharePopupMenuLayout.dismiss(0);
                }
                if (mPenWritingViewLayout != null) {
                    mPenWritingViewLayout.dismiss();
                }
            }
            if (mDocsMenuViewLayout != null) {
                mDocsMenuViewLayout.setPenDocsMode(this.mOtherStateMode == 4);
                mDocsMenuViewLayout.show();
            }
            this.mCurrentMode = 200;
            return;
        }
        if (!isOverlay && mScreenShareViewLayout != null) {
            mScreenShareViewLayout.show();
        }
        if (mPenWritingViewLayout != null) {
            mPenWritingViewLayout.dismiss();
        }
        if (mDocsMenuViewLayout != null) {
            mDocsMenuViewLayout.dismiss();
        }
        this.mCurrentMode = 100;
    }

    public void chageShareView() {
        setPenWritingView(false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRemoteEnd() {
        logI("Remote End by Pause");
        if (mIsRemote == 1) {
            this.mStartDownEvent = false;
            mIsRemote = 0;
            mScreenSharePopupMenuLayout.setViewMode(2);
            mOverlayPopupMenuMode = 2;
            if (mScreenShareViewOverlay != null) {
                mScreenShareViewOverlay.setMenuViewMode(mOverlayPopupMenuMode);
            }
        }
    }

    public void showSecureMode() {
        mSecureModeLayout.setVisibility(0);
        if (this.mSecureToast == null) {
            this.mSecureToast = showToast(MainApplication.mContext.getString(C0000R.string.screenshare_secure_mode));
        }
        this.mSecureToast.show();
    }

    public void hideSecureMode() {
        mSecureModeLayout.setVisibility(8);
        if (this.mSecureToast != null) {
            this.mSecureToast.cancel();
            this.mSecureToast = null;
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        logI("ScreenShareActivity onLowMemory");
        super.onLowMemory();
    }

    private void attentionAlertDialog() {
        ChatONDialog.Builder builder = new ChatONDialog.Builder(this);
        builder.setTitle(getResources().getText(C0000R.string.screenshare_alertView_attention_title));
        builder.setMessage(getResources().getText(C0000R.string.screenshare_attention_body));
        builder.setPositiveButton(C0000R.string.ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareActivity.15
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int arg1) {
            }
        });
        builder.create();
        builder.show();
    }

    public void setScreenRotation() {
        logI("setScreenRotation() mCurOrientation : " + this.mCurOrientation);
        int rotate = 1;
        if (this.mCurOrientation == -1) {
            logI("ORIENTATION_UNKNOWN");
            this.mCurOrientation = getSystemBarOrientation();
        }
        if (this.mCurOrientation == 0) {
            rotate = 1;
        } else if (this.mCurOrientation == 90) {
            rotate = 8;
        } else if (this.mCurOrientation != 180) {
            if (this.mCurOrientation == 270) {
                rotate = 0;
            }
        } else {
            return;
        }
        logI("setScreenRotation : " + rotate);
        setRequestedOrientation(rotate);
        stretchShareScreenView();
        setRotation();
    }

    public void setRotation() {
        logI("setRotation()");
        MainApplication.mPhoneManager.getPhoneStateMachine().sendRotationInfo(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), this.mCurOrientation << 16, isAutoRatationActive(), false);
        logI("Rotaion Value=" + getWindow().getWindowManager().getDefaultDisplay().getRotation() + ", boolean=" + isAutoRatationActive() + " ((mCurOrientation << 16)|0): " + (this.mCurOrientation << 16));
    }

    private boolean isAutoRatationActive() throws Settings.SettingNotFoundException {
        int sysAutoRotate = 0;
        try {
            sysAutoRotate = Settings.System.getInt(MainApplication.mContext.getContentResolver(), "accelerometer_rotation");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return sysAutoRotate == 1;
    }

    public int getSystemBarOrientation() {
        WindowManager windowManager = (WindowManager) getSystemService("window");
        Display display = windowManager.getDefaultDisplay();
        int rotation = ((4 - display.getRotation()) % 4) * 90;
        logI("getSystemBarOrientation() return: " + rotation);
        return rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int get45UnitAngleFromFullAngle(int angle) {
        if (angle < 45 || angle > 315) {
            return 0;
        }
        if (angle < 45 || angle >= 135) {
            return (angle < 135 || angle >= 225) ? InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MIDDLE_ALIGN_EVENT : EngineCallBackInterface.SIP_RINGTONE_NONE;
        }
        return 90;
    }

    public void stretchShareScreenView() {
        try {
            FrameLayout layout = (FrameLayout) findViewById(C0000R.id.remote_view_layout);
            FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) layout.getLayoutParams();
            param.gravity = 51;
            if (this.mCurOrientation == 90 || this.mCurOrientation == 270) {
                param.setMargins(0, -192, 0, 0);
                param.height = 1464;
                param.width = 1920;
            } else {
                param.setMargins(-192, 0, 0, 0);
                param.width = 1464;
                param.height = 1920;
            }
            layout.setLayoutParams(param);
        } catch (Exception e) {
            logI("exception e: " + e);
        }
    }

    public void setMainButtonContentDiscription(boolean show) {
        if (show) {
            this.mMainBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_talkback_share));
        } else {
            this.mMainBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_talkback_share_show_controller));
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        mOnFinish = false;
        this.mInflater = null;
        this.activitymanager = null;
        this.mPowerManager = null;
        try {
            if (this.mSecureToast != null) {
                this.mSecureToast.cancel();
                this.mSecureToast = null;
            }
            if (this.mMainBtn != null) {
                this.mMainBtn.removeCallbacks(null);
                this.mMainBtn = null;
            }
            if (this.mEndBtn != null) {
                this.mEndBtn.removeCallbacks(null);
                this.mEndBtn = null;
            }
            if (this.mRemoteHolder != null) {
                this.mRemoteHolder = null;
            }
            if (this.mRemoteSurface != null) {
                this.mRemoteSurface.removeCallbacks(null);
                this.mRemoteSurface = null;
            }
            if (this.mHolder != null) {
                this.mHolder = null;
            }
            if (this.mSurface != null) {
                this.mSurface.removeCallbacks(null);
                this.mSurface = null;
            }
            if (mScreenShareViewOverlay != null) {
                mScreenShareViewOverlay.dispose();
                mScreenShareViewOverlay.destory();
                mScreenShareViewOverlay = null;
                ScreenShareViewOverlayPopupMenu.mInstance.destory();
            }
            if (this.mConsentRemoteControlDialog != null) {
                this.mConsentRemoteControlDialog.dismiss();
                this.mConsentRemoteControlDialog = null;
            }
            if (this.mEndRemoteControlDialog != null) {
                this.mEndRemoteControlDialog.dismiss();
                this.mEndRemoteControlDialog = null;
            }
            if (this.mConsentRemoteControlDialogTimerHandler != null) {
                this.mConsentRemoteControlDialogTimerHandler.removeCallbacks(null);
                this.mConsentRemoteControlDialogTimerHandler = null;
            }
            if (this.mWriteNetwork != null) {
                this.mWriteNetwork.stop();
                this.mWriteNetwork = null;
            }
            if (mScreenShareViewLayout != null) {
                mScreenShareViewLayout.dispose();
                mScreenShareViewLayout.removeAllViewsInLayout();
                mScreenShareViewLayout = null;
            }
            if (mPenWritingViewLayout != null) {
                mPenWritingViewLayout.dispose();
                mPenWritingViewLayout.removeAllViewsInLayout();
                mPenWritingViewLayout = null;
            }
            if (mDocsMenuViewLayout != null) {
                mDocsMenuViewLayout.dispose();
                mDocsMenuViewLayout.removeAllViewsInLayout();
                mDocsMenuViewLayout = null;
            }
            if (mScreenSharePopupMenuLayout != null) {
                mScreenSharePopupMenuLayout.dispose();
                mScreenSharePopupMenuLayout.removeAllViewsInLayout();
                mScreenSharePopupMenuLayout = null;
            }
            if (mMainLayout != null) {
                mMainLayout = null;
            }
            if (mSecureModeLayout != null) {
                mSecureModeLayout.removeAllViewsInLayout();
                mSecureModeLayout = null;
            }
            if (this.mShareBtnLayout != null) {
                this.mShareBtnLayout.removeAllViewsInLayout();
                this.mShareBtnLayout = null;
            }
            if (this.mScreenScale != null) {
                this.mScreenScale = null;
            }
            if (this.mOrientation != null) {
                this.mOrientation.disable();
                this.mOrientation = null;
            }
            if (this.mBoardDataController != null) {
                this.mBoardDataController.dispose();
                this.mBoardDataController = null;
            }
        } catch (Exception e) {
            logI("exception " + e);
        }
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
}
