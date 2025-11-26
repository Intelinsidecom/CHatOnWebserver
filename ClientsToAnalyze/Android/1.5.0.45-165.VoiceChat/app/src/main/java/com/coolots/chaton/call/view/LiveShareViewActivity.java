package com.coolots.chaton.call.view;

import android.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Instrumentation;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.ScaleGestureDetector;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.SECConfig;
import com.coolots.chaton.call.controller.ChatONBlueTooth;
import com.coolots.chaton.call.controller.InviteViewController;
import com.coolots.chaton.call.controller.MemberViewController;
import com.coolots.chaton.call.controller.VideoShareViewController;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.model.VideoOptionMenuData;
import com.coolots.chaton.call.model.VideoShareViewRestoreData;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.coolots.chaton.call.view.layout.IncomingSlidingWidget;
import com.coolots.chaton.call.view.layout.video.VideoCallBtnLayout;
import com.coolots.chaton.call.view.layout.video.VideoCallOptionMenu;
import com.coolots.chaton.call.view.layout.video.VideoCallOutgoingCallLayout;
import com.coolots.chaton.call.view.layout.video.VideoCallRepositionView;
import com.coolots.chaton.call.view.layout.video.VideoCallStartScreenLayout;
import com.coolots.chaton.call.view.layout.video.VideoCallStatusBar;
import com.coolots.chaton.call.view.layout.voice.VoiceCallEndBtnLayout;
import com.coolots.chaton.common.controller.IPinchZoomController;
import com.coolots.chaton.common.controller.PinchZoomController;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.ChatONDialog;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.coolots.chaton.common.util.LiveShareModel;
import com.coolots.chaton.common.util.ModelCreator;
import com.coolots.chaton.common.util.ModelInfomation;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.coolots.chaton.common.view.layout.OptionMenuLayout;
import com.coolots.chaton.setting.data.ChatONHideMeImgData;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.infraware.office.evengine.InterfaceC0507E;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.view.CallActivity;
import com.sds.coolots.common.controller.EngineCallBackInterface;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.model.CoolotsWakeLockList;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.FileUtil;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.ModelInfoUtil;
import com.sds.coolots.common.util.PhoneNumberUtil;
import com.sds.coolots.common.view.DisposeInterface;
import com.sec.spp.push.Config;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class LiveShareViewActivity extends VideoCallActivity implements SurfaceHolder.Callback, DisposeInterface, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, Animation.AnimationListener, IPinchZoomController {
    private static final int ACTIVITY_SATATUS_CREATE = 1;
    private static final int ACTIVITY_SATATUS_DESTROY = 4;
    private static final int ACTIVITY_SATATUS_NONE = -1;
    private static final int ACTIVITY_SATATUS_PAUSE = 3;
    private static final int ACTIVITY_SATATUS_RESUME = 2;
    private static final int ACTIVITY_SATATUS_USERLEAVEHINT = 5;
    private static final boolean APPLY_PREVIEW_GUIDE_LINE = true;
    private static final String CLASSNAME = "[LiveShareViewActivity]";
    private static final int DELAY_CONTROL_CAMERA = 200;
    private static final int DELAY_TIMER_CALL_END_BUTTON = 1300;
    private static final int DELAY_TIMER_CAPTURE_IMAGE_1 = 1000;
    private static final int DELAY_TIMER_CAPTURE_IMAGE_5 = 5000;
    private static final int DELAY_TIMER_CAPTURE_IMAGE_ANIMATION = 500;
    private static final int DELAY_TIMER_CAPTURE_IMAGE_PREVIEW_1 = 1000;
    private static final int DELAY_TIMER_CAPTURE_IMAGE_PREVIEW_5 = 5000;
    private static final int DIALOG_CAPTURE_IMAGE = 100;
    private static final int DIALOG_COMPLETE_RECORD = 106;
    private static final int DIALOG_LAYOUT = 102;
    private static final int DIALOG_PREVIEW_SINGLE_TAB = 108;
    private static final int DIALOG_REMOTE_SELECT = 105;
    public static final int DIALOG_SCAMERA_CALL_END = 109;
    private static final int DIALOG_SHARE_VIEW = 107;
    private static final int DISPLAY_CALL_END_BUTTON = 1;
    private static final int DISPLAY_CAPTURE_IMAGE = 9367;
    private static final int DISPLAY_CAPTURE_IMAGE_PREVIEW = 9368;
    private static final int PINCH_ZOOM_DISMISS_GUIDLINE_DELAY = 2;
    private static final int PINCH_ZOOM_DISMISS_GUIDLINE_DELAY_TIME = 800;
    private static final float PINCH_ZOOM_INTERPOLATION = 1.0f;
    private static final float PINCH_ZOOM_MAX_SCALE = 30.0f;
    private static final int PINCH_ZOOM_MAX_SIZE = 400;
    private static final float PINCH_ZOOM_MIN_SCALE = 0.0f;
    private static final int PINCH_ZOOM_MIN_SIZE = 150;
    private static final int PREVIEW_OUTLINE = 0;
    private static final int PREVIEW_OUTLINE_MOVE = 2;
    private static final int PREVIEW_OUTLINE_NO = 0;
    private static final int PREVIEW_OUTLINE_WHITE = 1;
    private static final int REMOTEVIEW_OUTLINE = 1;
    private static final int RESULT_HIDE_ME_IMAGE_DONE = 1;
    private static final int RESULT_INVITE_BUDDY_DONE = 2;
    private static final int SCAMERA_CAPTURE_FILE_MAX = 3;
    private static final int SCAMERA_DISPLAY_SEND_FILE_LAYOUT = 123;
    private static final int SCAMERA_HIDE_ANIMATION_MENU_BAR = 129;
    private static final int SCAMERA_HIDE_VOLUME_SEEK_BAR = 128;
    private static final int SCAMERA_SAVE_DONE = 125;
    private static final int SCAMERA_SEND_DONE = 124;
    private static final int SCAMERA_STOP_CALL_CONNECTED_MSG = 127;
    private static final int SCAMERA_WAIT_FOCUS = 126;
    private static final int SCREEN_AUTOBRIGHTNESS_OFF = 0;
    private static final int SCREEN_AUTOBRIGHTNESS_ON = 1;
    private static final int STOP_CAPTURE_IMAGE_ANIMATION = 9371;
    private static final int TITLE_BAR_TIMER = 3000;
    private static final int TOUCH_MIN_DISTANCE = 80;
    private VideoCallBtnLayout mCallBtnLayout;
    private VoiceCallEndBtnLayout mCallEndBtnLayout;
    private FrameLayout mCallInfoBGLayout;
    private VideoCallStartScreenLayout mCallInfoLayout;
    private VideoCallOutgoingCallLayout mCallOutgoingCallLayout;
    private IncomingSlidingWidget mCallReceiveBtnLayout;
    public CallDisplayUserInfo mCalluserInfo;
    private ImageView mCaptureImage;
    private AnimationDrawable mCaptureImageAnimation;
    private String mCaptureMyImageFileName;
    private float mDensity;
    private int mDisplayHeight;
    private int mDisplayWidth;
    private GestureDetector mGestureDetector;
    private Uri mHideMeUri;
    private SurfaceHolder mHolder;
    ImageView mImageCaptureAnimationImageView;
    private Point mImgPoint;
    private InviteViewMemberLayout mInviteviewMemberLayout;
    private String mLastRecvFilePath;
    int mMaxMoveX;
    int mMaxMoveY;
    private ModelInfomation mModelDeviceInfo;
    private LiveShareModel mModelInfo;
    private FrameLayout mOnlyBuddyLayout;
    private ImageView mOtherPartyCapture;
    private ViewGroup mRecordLayout;
    private Chronometer mRecordTime;
    private SurfaceHolder mRemoteHolder;
    private SurfaceView mRemoteSurface;
    private FrameLayout mRemoteVideoLayoutRadvision;
    private FrameLayout mSCameraCameraBtnLayout;
    private Chronometer mSCameraElapsedTime;
    private ViewGroup mSCameraSendFileLayout;
    private Button mSCameraVolumeBtnLayout;
    private FrameLayout mSCameraVolumeBtnLayout2;
    private HorizontalSeekBar mSCameraVolumeSeekBar;
    private FrameLayout mSCameraVolumeUiLayout;
    private ScaleGestureDetector mScaleGestureDetector;
    private VideoShareViewController mShareViewCtrl;
    private SurfaceView mSurface;
    private FrameLayout mSurfaceViewlayout;
    private boolean mUseFrontCamera;
    private VideoCallOptionMenu mVideoCallOptionMenu;
    private VideoCallStatusBar mVideoCallStatusBar;
    private VideoCallRepositionView mVideoRepositionView;
    private FrameLayout mVideolayout;
    private static String mKeyBaseTime = "BASETIME";
    private static String mHideMeClicked = "HIDEMECLICKED";
    private static String mKeyRecordBaseTime = "RECBASETIME";
    private static String mEndBlinkCount = "ENDBLINkCOUNT";
    private static String mOptionMenu = "OPTIONMENU";
    private static String mAlwaysMode = "ALWAYSmODE";
    private static String mStoreConfigInfo = "STORECONFIGINFO";
    private static String mPointStatus = "POINTSTATUS";
    private static String mAddGroupName = "ADDGROUPNAME";
    private static String mIsMemberView = "MEMBERSVIEW";
    private static Date mLastOrientationChangeDate = new Date();
    private int mPrviewPaddingButton = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_OBJECT_POSITION_EVENT;
    private int mPreViewPaddingTop = 540;
    private int mPreviewPaddingRight = 24;
    private int mPreviewPaddigLeft = 24;
    private int mPreviewMarginButtom = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MIDDLE_ALIGN_EVENT;
    private int mLandPrviewPaddingButton = 18;
    private int mLandPreViewPaddingTop = 452;
    private int mLandPreviewPaddingRight = 386;
    private int mLandPreviewPaddigLeft = 540;
    private int mLandRemoteViewMarginButtom = 0;
    private int mLandPreviewFullHeight = 894;
    private int mLandPreviewFullWidth = 670;
    private int mStatusBarLength = 50;
    private int mHWGap = 40;
    public int mPreviewWidth = 256;
    public int mPreviewHeight = 336;
    private boolean mIsRecording = false;
    private boolean mIsRecordRequested = false;
    private boolean mUseAlterImage = false;
    private boolean mPreAlterImage = false;
    private boolean mIsCartoonView = false;
    private int mConfLayout = 0;
    private boolean mSurfaceDestroyed = false;
    private OrientationHandler mOrientation = new OrientationHandler(MainApplication.mContext);
    private int mSavedOrientation = 0;
    private boolean mIsInitAngle = false;
    private int mInstantOrientation = 0;
    private boolean mIsOtherPartyLandscapeMode = false;
    private int mCountConnectedState = 0;
    private boolean mIsReposotionView = false;
    private boolean mIsMovePreviewPosition = false;
    private int mRemoteRotation = 0;
    private Bitmap mImage = null;
    private AudioManager mAudioManager = null;
    private boolean bTurnOnScrAB = false;
    private Dialog mConnectFailDialog = null;
    private Dialog mRemoteDialog = null;
    private Dialog mOutgoingImageDialog = null;
    private Dialog mLayoutDialog = null;
    private Dialog mShareViewSelectDialog = null;
    private Dialog mSwitchLayoutDialog = null;
    private Dialog mPreviewSingleTabDialog = null;
    private boolean mHangUpCall = false;
    private boolean mIsNativeCall = false;
    private int mNativeStauts = 0;
    private boolean mSpeakerOn = true;
    private Bitmap mDefaultHideImg = null;
    private boolean mIsShowMemberView = false;
    private int mConfigInfo = 0;
    private Object mBackUpObj = null;
    private boolean mChanagePreview = false;
    private boolean mShowOptionMenu = false;
    private boolean mBuddyImageOnly = false;
    private boolean mMyImageOnly = false;
    private boolean mAniThemeMenu = false;
    private boolean mIsThemeShotMenu = false;
    private boolean mRecordTimer = false;
    private boolean mIsTabDevice = false;
    private boolean mIsSpeaker = true;
    private int mIsBlueTooth = 0;
    private int mDeviceType = -1;
    private int mHideMeModeType = 0;
    private Object hangupMutex = new Object();
    private boolean mIsMSurfaceOnTop = false;
    private int mActivityStatus = -1;
    private boolean mIsExcuteIntent = false;
    private boolean mChangePreviewRotation = false;
    private boolean mIsOtherCapture = false;
    private boolean mIsQuickEndCall = false;
    private ViewGroup mShareViewLayout = null;
    private Button mShareViewCloseButton = null;
    private Button mShareViewZoomInButton = null;
    private Button mShareViewZoomOutButton = null;
    private boolean mReturnPreview = false;
    private PinchZoomController mPinchZoomController = null;
    private RelativeLayout mShareViewPinchZoomView = null;
    private ViewGroup mShareViewPinchZoomGuideLineLayout = null;
    private TextView mShareViewPinchZoomGuideScaleText = null;
    private VideoOptionMenuData mOptionMenuData = null;
    private Handler mTitleBarHandler = new TitleBarHandler();
    private boolean mIsPreviewAreaScroll = false;
    private boolean mIsLandscapeMode = false;
    ArrayList<String> sCameraSendFileList = new ArrayList<>();
    private int mCurrentCapturedImgCnt = 0;
    private ArrayList<ImageView> mCapturedImageList = new ArrayList<>();
    private ArrayList<String> mRecvImageList = new ArrayList<>();
    private TextView mSCameraTextView = null;
    private Button mSendButton = null;
    private Button mCancelButton = null;
    private boolean mIsSendingFile = false;
    private boolean mIsReceivingFile = false;
    private Dialog mSCameraCallEndDialog = null;
    private ImageView mImageView_animated = null;
    private ImageView mSCameraRecvImg = null;
    private ImageView mSCameraSendingFileAnimation = null;
    private AnimationDrawable mFrameAnimation = null;
    private RelativeLayout mSCameraOutgoingInfoLayout = null;
    private ScaleGestureDetector mScaleDetector = null;
    private float mScaleFactor = PINCH_ZOOM_INTERPOLATION;
    private BroadcastReceiver mBatteryChangeReceiver = new BroadcastReceiver() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.BATTERY_CHANGED")) {
                LiveShareViewActivity.this.updateBatteryState(intent);
            }
        }
    };
    private boolean mIsBatteryCharging = false;
    private int mBatteryLevel = 0;
    private ImageView mBatteryImageView = null;
    boolean bIsRemoteLayoutMove = false;
    int mRemoteLayoutTopPos = 0;
    int mRemoteLayoutLeftPos = 0;
    private boolean mgFlag = false;
    private InnerHandler mInnerHandler = new InnerHandler(this, null);
    int mLastZoomState = 0;
    boolean mWaitFocus = false;
    private boolean mIsPowerLongPressed = false;
    private Display display = null;
    private boolean mAlreadyDenied = false;
    private InputMethodManager imm = null;
    private int mSavedPreviewWidth = 0;
    private int mSavedPreviewHeight = 0;
    private int mSavedPreviewMarginTop = 0;
    private int mSavedPreviewMarginLeft = 0;
    private int mSavedPreviewMarginRight = 0;
    private int mSavedPreviewMarginBottom = 0;
    private ImageView mSCameraBack = null;
    private ImageView mSCameraHome = null;
    private LinearLayout mSCameraHidingMenuLayout = null;
    private LinearLayout mSCameraOrgMenu = null;
    private Button mSCameraArrowButton = null;
    private Button mSCameraArrowButton2 = null;
    private LinearLayout mSCameraHidingMenuLayout_child = null;
    private Button mSCameraMute = null;
    private Button mSCameraResolution = null;
    private TextView mSCameraName = null;
    private StrokeTextView mSCameraCallConnectedMsg = null;
    private ImageView mLoadingImage = null;
    private AnimationDrawable mConnAnimation = null;
    private boolean mIsFullScreen = true;
    private boolean mIsConnected = false;

    void updateBatteryState(Intent batteryIntent) {
        int level;
        int rawlevel = batteryIntent.getIntExtra("level", -1);
        double scale = batteryIntent.getIntExtra("scale", -1);
        int status = batteryIntent.getIntExtra("status", -1);
        if (status == 2 || status == 5) {
            this.mIsBatteryCharging = true;
        } else {
            this.mIsBatteryCharging = false;
        }
        logI("updateBatteryState rawlevel = " + rawlevel + ", scale = " + scale + ", status = " + status);
        if (rawlevel >= 0 && scale > 0.0d) {
            level = (int) ((rawlevel / scale) * 100.0d);
        } else {
            level = 0;
        }
        if (level < 10) {
            this.mBatteryLevel = 0;
        } else if (level < 20) {
            this.mBatteryLevel = 10;
        } else if (level < 25) {
            this.mBatteryLevel = 20;
        } else if (level < 70) {
            this.mBatteryLevel = 25;
        } else if (level < 85) {
            this.mBatteryLevel = 70;
        } else if (level < 100) {
            this.mBatteryLevel = 85;
        } else {
            this.mBatteryLevel = 100;
        }
        logI("updateBatteryState() level = " + level + ", mBatteryLevel = " + this.mBatteryLevel);
        changeBatteryImage();
    }

    void changeBatteryImage() {
        if (this.mBatteryImageView != null) {
            if (!this.mIsBatteryCharging) {
                switch (this.mBatteryLevel) {
                    case 0:
                        this.mBatteryImageView.setImageResource(C0000R.drawable.scamera_stat_sys_battery_0);
                        break;
                    case 10:
                        this.mBatteryImageView.setImageResource(C0000R.drawable.scamera_stat_sys_battery_10);
                        break;
                    case 20:
                        this.mBatteryImageView.setImageResource(C0000R.drawable.scamera_stat_sys_battery_20);
                        break;
                    case 25:
                        this.mBatteryImageView.setImageResource(C0000R.drawable.scamera_stat_sys_battery_25);
                        break;
                    case 70:
                        this.mBatteryImageView.setImageResource(C0000R.drawable.scamera_stat_sys_battery_70);
                        break;
                    case 85:
                        this.mBatteryImageView.setImageResource(C0000R.drawable.scamera_stat_sys_battery_85);
                        break;
                    case 100:
                        this.mBatteryImageView.setImageResource(C0000R.drawable.scamera_stat_sys_battery_100);
                        break;
                }
            }
            switch (this.mBatteryLevel) {
                case 0:
                    this.mBatteryImageView.setImageResource(C0000R.drawable.scamera_stat_sys_battery_charge_0);
                    break;
                case 10:
                    this.mBatteryImageView.setImageResource(C0000R.drawable.scamera_stat_sys_battery_charge_10);
                    break;
                case 20:
                    this.mBatteryImageView.setImageResource(C0000R.drawable.scamera_stat_sys_battery_charge_20);
                    break;
                case 25:
                    this.mBatteryImageView.setImageResource(C0000R.drawable.scamera_stat_sys_battery_charge_25);
                    break;
                case 70:
                    this.mBatteryImageView.setImageResource(C0000R.drawable.scamera_stat_sys_battery_charge_70);
                    break;
                case 85:
                    this.mBatteryImageView.setImageResource(C0000R.drawable.scamera_stat_sys_battery_charge_85);
                    break;
                case 100:
                    this.mBatteryImageView.setImageResource(C0000R.drawable.scamera_stat_sys_battery_charge_100);
                    break;
            }
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity, com.sds.coolots.call.CallingInterface
    public boolean isUseFrontCamera() {
        return this.mUseFrontCamera;
    }

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity, com.sds.coolots.call.view.CallActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        logI("onCreate()++");
        this.mActivityStatus = 1;
        this.mHandler = new VideoCallHandler(this);
        if (getIntent().getIntExtra(EventCode.EVENT_IDENTIFIER, -1) == 7300) {
            this.mHandler.sendEmptyMessage(EventCode.EVENT_CALL_ACTION);
        }
        super.onCreate(savedInstanceState, true);
        DisplayMetrics outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        this.mDensity = outMetrics.density;
        if (ModelInfoUtil.IS_MODEL_SCAMERA && this.mIsOutGoingCall) {
            hideStatusIcon();
        }
        if (ModelInfoUtil.IS_MODEL_SCAMERA) {
            setContentView(C0000R.layout.live_share_scamera_video_call);
        } else {
            setContentView(C0000R.layout.live_share_video_call);
        }
        initActivity();
        hidekeyboard();
        this.mCountConnectedState = 0;
        this.mHideMeModeType = 0;
        this.mHangUpCall = false;
        if (getCallFunctionController().getCallSwitchingProcessing() == 2) {
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximityOnlyVideoCall();
        }
        if (this.mIsOutGoingCall) {
            this.mShareViewCtrl.setType(2);
            startShareView(true);
            this.mShareViewCtrl.setFullScreen(true);
            updateShareViewZoomLayout();
            callStartedOutgoingCallLayout();
        }
        File saveDir = new File(FileUtil.VIDEO_SAVE_PATH);
        saveDir.mkdirs();
        if (!this.mIsOutGoingCall) {
            this.mScaleDetector = new ScaleGestureDetector(getBaseContext(), new ScaleListener(this, null));
        } else {
            Intent batteryIntent = registerReceiver(this.mBatteryChangeReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            updateBatteryState(batteryIntent);
        }
        logI("onCreate()--");
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private ScaleListener() {
        }

        /* synthetic */ ScaleListener(LiveShareViewActivity liveShareViewActivity, ScaleListener scaleListener) {
            this();
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector detector) {
            if (LiveShareViewActivity.this.mShareViewCtrl != null && LiveShareViewActivity.this.mShareViewCtrl.isFullScreen() && CallState.isConnected(LiveShareViewActivity.this.mCallState)) {
                LiveShareViewActivity.this.mScaleFactor = (float) (r1.mScaleFactor * (((detector.getScaleFactor() - LiveShareViewActivity.PINCH_ZOOM_INTERPOLATION) * 0.5d) + 1.0d));
                LiveShareViewActivity.this.mScaleFactor = Math.max(LiveShareViewActivity.PINCH_ZOOM_INTERPOLATION, Math.min(LiveShareViewActivity.this.mScaleFactor, 5.0f));
                LiveShareViewActivity.this.logI("mScaleFactor = " + LiveShareViewActivity.this.mScaleFactor + ", detector.getScaleFactor() = " + detector.getScaleFactor());
                FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) LiveShareViewActivity.this.mRemoteSurface.getLayoutParams();
                param.width = (int) (LiveShareViewActivity.this.mDisplayWidth * LiveShareViewActivity.this.mScaleFactor);
                param.height = (int) (LiveShareViewActivity.this.mDisplayHeight * LiveShareViewActivity.this.mScaleFactor);
                param.setMargins(0, 0, 0, 0);
                param.gravity = 17;
                if (param.width > LiveShareViewActivity.this.mDisplayWidth) {
                    LiveShareViewActivity.this.bIsRemoteLayoutMove = true;
                    LiveShareViewActivity.this.mMaxMoveX = (param.width - LiveShareViewActivity.this.mDisplayWidth) / 2;
                    LiveShareViewActivity.this.mMaxMoveY = (param.height - LiveShareViewActivity.this.mDisplayHeight) / 2;
                    LiveShareViewActivity.this.mRemoteLayoutLeftPos = (int) (LiveShareViewActivity.this.mRemoteLayoutLeftPos * LiveShareViewActivity.this.mScaleFactor);
                    LiveShareViewActivity.this.mRemoteLayoutTopPos = (int) (LiveShareViewActivity.this.mRemoteLayoutTopPos * LiveShareViewActivity.this.mScaleFactor);
                    if (LiveShareViewActivity.this.mRemoteLayoutLeftPos > LiveShareViewActivity.this.mMaxMoveX) {
                        LiveShareViewActivity.this.mRemoteLayoutLeftPos = LiveShareViewActivity.this.mMaxMoveX;
                    }
                    if (LiveShareViewActivity.this.mRemoteLayoutLeftPos < (-LiveShareViewActivity.this.mMaxMoveX)) {
                        LiveShareViewActivity.this.mRemoteLayoutLeftPos = LiveShareViewActivity.this.mMaxMoveX;
                    }
                    if (LiveShareViewActivity.this.mRemoteLayoutTopPos > LiveShareViewActivity.this.mMaxMoveY) {
                        LiveShareViewActivity.this.mRemoteLayoutTopPos = -LiveShareViewActivity.this.mMaxMoveY;
                    }
                    if (LiveShareViewActivity.this.mRemoteLayoutTopPos < (-LiveShareViewActivity.this.mMaxMoveY)) {
                        LiveShareViewActivity.this.mRemoteLayoutTopPos = -LiveShareViewActivity.this.mMaxMoveY;
                    }
                    param.leftMargin = LiveShareViewActivity.this.mRemoteLayoutLeftPos;
                    param.topMargin = LiveShareViewActivity.this.mRemoteLayoutTopPos;
                } else {
                    LiveShareViewActivity.this.bIsRemoteLayoutMove = false;
                    LiveShareViewActivity.this.mRemoteLayoutTopPos = 0;
                    LiveShareViewActivity.this.mRemoteLayoutLeftPos = 0;
                }
                LiveShareViewActivity.this.mRemoteSurface.setLayoutParams(param);
                LiveShareViewActivity.this.mRemoteSurface.setPadding(0, 0, 0, 0);
            }
            return true;
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig, true);
        logI("onConfigurationChanged()");
        this.mVideolayout.setVisibility(4);
        saveData();
        disposeForChanginRotation();
        this.mReturnPreview = true;
        this.mMemberCount = getConferenceConnectCount();
        if (newConfig.orientation == 1) {
            logI("ORIENTATION_PORTRAIT is called!!!!!!!!");
            if (ModelInfoUtil.IS_MODEL_SCAMERA) {
                setContentView(C0000R.layout.live_share_scamera_video_call);
            } else {
                setContentView(C0000R.layout.live_share_video_call);
            }
            this.mIsLandscapeMode = false;
            initView();
            setHideMeOrientation();
            this.mDefaultHideImg = ChatONSettingData.getInstance().getVideoCallImage(true, false);
            setPORTRAITChangedPreview();
            updateUIComponent();
        } else if (newConfig.orientation == 2) {
            if (ModelInfoUtil.IS_MODEL_SCAMERA) {
                setContentView(C0000R.layout.live_share_scamera_video_call);
            } else {
                setContentView(C0000R.layout.live_share_video_call);
            }
            logI("ORIENTATION_LANDSCAPE is called!!!!!!!!");
            this.mIsLandscapeMode = true;
            initView();
            setHideMeOrientation();
            this.mDefaultHideImg = ChatONSettingData.getInstance().getVideoCallImage(true, true);
            setLANDSCAPEChangedPreview();
            updateUIComponent();
        }
        getScreenSize();
        initLayout();
        if (this.mVideoRepositionView != null) {
            this.mVideoRepositionView.setChangePointStatus(this.mImgPoint, this.mChanagePreview, this.mDisplayWidth, this.mDisplayHeight);
        }
        updateShareViewZoomLayoutRotation();
        if (this.mIsShowMemberView) {
            startMemberView(this.mVideoCallStatusBar);
        }
        setPreViewWhiteOutLine();
        changeSurfaceZOrder();
    }

    private void changeSurfaceZOrder() {
        this.mSurfaceViewlayout.removeView(this.mSurface);
        this.mSurface.setZOrderOnTop(true);
        this.mSurfaceViewlayout.addView(this.mSurface);
    }

    private void initLayout() {
        logI("initLayout()");
        if (!CallState.isNotConnected(this.mCallState)) {
            setSECPreviewPosition(false);
            updatePreviewLayout(false);
        }
    }

    private void setLANDSCAPEChangedPreview() {
        int pointY;
        logI("setLANDSCAPEChangedPreview()");
        if (this.mIsMovePreviewPosition) {
            int pointX = this.mImgPoint.y;
            int pointY2 = this.mImgPoint.x;
            int gapHW = 0;
            if (this.mChanagePreview) {
                gapHW = this.mHWGap;
            }
            if (pointX > this.mLandPreviewFullHeight - this.mPreviewHeight) {
                pointX = this.mLandPreviewFullHeight - this.mPreviewHeight;
            }
            int imsiY = this.mLandPreviewFullWidth - (this.mPreviewWidth + pointY2);
            if (imsiY < this.mModelInfo.getLandRepositonTopMargin() + gapHW) {
                pointY = this.mModelInfo.getLandRepositonTopMargin() + gapHW;
            } else if (imsiY > this.mModelInfo.getLandRepositionDownMargin() - gapHW) {
                pointY = this.mModelInfo.getLandRepositionDownMargin() - gapHW;
            } else {
                pointY = imsiY;
            }
            this.mImgPoint.x = pointX;
            this.mImgPoint.y = pointY;
        } else {
            this.mImgPoint = new Point(this.mLandPreviewPaddigLeft, this.mLandPreViewPaddingTop);
        }
        if (this.mIsOtherCapture) {
            finishCaptureImgShow();
        }
    }

    private void setPORTRAITChangedPreview() {
        logI("setPORTRAITChangedPreview()");
        if (this.mIsMovePreviewPosition) {
            int pointY = this.mImgPoint.x;
            if (pointY < this.mModelInfo.getPortRepositonTopMargin()) {
                pointY = this.mModelInfo.getPortRepositonTopMargin();
            }
            int imsiX = this.mLandPreviewFullWidth - (this.mImgPoint.y + this.mPreviewWidth);
            this.mImgPoint.x = imsiX;
            this.mImgPoint.y = pointY;
        } else {
            this.mImgPoint = new Point(this.mPreviewPaddigLeft, this.mPreViewPaddingTop);
        }
        if (this.mIsOtherCapture) {
            finishCaptureImgShow();
        }
    }

    private void restoreData() {
        HashMap<String, Object> hMap;
        logI("restoreData()");
        if (this.mBackUpObj != null && (hMap = (HashMap) this.mBackUpObj) != null) {
            this.mConfigInfo = ((Integer) hMap.get(mStoreConfigInfo)).intValue();
            boolean isHideMe = ((Boolean) hMap.get(mHideMeClicked)).booleanValue();
            if (CallState.isConnected(this.mCallState)) {
                this.mCallBtnLayout.setRecordBtnStatus(this.mIsRecording);
                this.mVideoCallStatusBar.setCallBaseTime((Long) hMap.get(mKeyBaseTime));
                this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
                if (this.mIsRecording) {
                    this.mRecordLayout.setVisibility(0);
                    setLayoutRecordBaseTime((Long) hMap.get(mKeyRecordBaseTime));
                }
                Boolean menu = (Boolean) hMap.get(mOptionMenu);
                if (menu.booleanValue()) {
                    this.mShowOptionMenu = false;
                    openOptionsMenu();
                } else if (this.mAniThemeMenu) {
                    if (this.mShareViewCtrl.isActive()) {
                        if (this.mIsThemeShotMenu) {
                            this.mAniThemeMenu = true;
                            this.mIsThemeShotMenu = true;
                        } else {
                            this.mVideoCallOptionMenu.setAlwaysMode(((Boolean) hMap.get(mAlwaysMode)).booleanValue());
                            this.mAniThemeMenu = true;
                            this.mIsThemeShotMenu = false;
                        }
                    } else if (this.mIsThemeShotMenu) {
                        displayThemeShot();
                    } else {
                        this.mVideoCallOptionMenu.setAlwaysMode(((Boolean) hMap.get(mAlwaysMode)).booleanValue());
                        displayEmotionalAnimation();
                    }
                }
                if (isHideMe) {
                    setHideMeOrientation();
                }
                this.mImgPoint = (Point) hMap.get(mPointStatus);
                boolean isMemberView = ((Boolean) hMap.get(mIsMemberView)).booleanValue();
                this.mIsShowMemberView = isMemberView;
            } else if (CallState.isDisconnected(this.mCallState)) {
                this.mVideoCallStatusBar.setCallBaseTime((Long) hMap.get(mKeyBaseTime));
                changeBottomButtonPosition();
                this.mCallOutgoingCallLayout.setTimeBlinkCount(((Integer) hMap.get(mEndBlinkCount)).intValue());
            }
            if (CallState.isNotConnected(this.mCallState) && isHideMe) {
                setHideMe();
            }
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public void saveData() {
        logI("saveData()");
        HashMap<String, Object> hMap = new HashMap<>();
        hMap.put(mKeyBaseTime, this.mVideoCallStatusBar.getCallBaseTime());
        hMap.put(mKeyRecordBaseTime, Long.valueOf(this.mRecordTime.getBase()));
        hMap.put(mHideMeClicked, Boolean.valueOf(this.mUseAlterImage));
        hMap.put(mEndBlinkCount, Integer.valueOf(this.mCallOutgoingCallLayout.getTimeBlinkCount()));
        hMap.put(mOptionMenu, Boolean.valueOf(this.mShowOptionMenu));
        hMap.put(mAlwaysMode, Boolean.valueOf(this.mVideoCallOptionMenu.isAlwaysMode()));
        hMap.put(mStoreConfigInfo, Integer.valueOf(this.mConfigInfo));
        hMap.put(mPointStatus, this.mImgPoint);
        hMap.put(mAddGroupName, this.mCallEndBtnLayout.getNewAddGroup());
        hMap.put(mIsMemberView, Boolean.valueOf(this.mMemberViewCtrl.ismMemberViewActive()));
        this.mBackUpObj = hMap;
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        logI("onNewIntent()++");
        super.onNewIntent(intent, true);
        this.mInnerHandler.removeMessages(1);
        dismissVideoDialog();
        closeOptionsMenu();
        restartCall();
        if (this.mHangUpCall && (CallState.isNotConnected(this.mCallState) || CallState.isDisconnected(this.mCallState))) {
            logI("finish() receive new intent!!!! ");
            finish();
            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                overridePendingTransition(0, 0);
            }
            Intent intents = MainApplication.mCallIntentGenerator.getCallIntent(this.mUseVideo, false, this.mDestination.getDestinationType() == 3);
            intents.putExtra(EventCode.EVENT_IDENTIFIER, EventCode.EVENT_CALL_ACTION);
            intents.setAction(CallActivity.getStringForEvent(EventCode.EVENT_CALL_ACTION));
            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                intents.setFlags(65536);
            }
            intents.addFlags(268435456);
            intents.addFlags(536870912);
            intents.addFlags(8388608);
            MainApplication.mContext.startActivity(intents);
            return;
        }
        resetLayoutData();
        if (this.mUseAlterImage && isDefaultHideMeImage() && ChatONSettingData.getInstance().isChanageVideoCallImage()) {
            this.mDefaultHideImg = null;
            makeHideMeImage();
        }
        logI("onNewIntent()--");
    }

    private void setOutgoingCallLayout() {
        logI("setOutgoingCallLayout()");
        this.mCallInfoLayout.setVisibility(8);
        this.mCallInfoBGLayout.setVisibility(8);
        this.mVideoRepositionView.setVisibility(8);
        this.mCallEndBtnLayout.setVisibility(8);
        this.mCallOutgoingCallLayout.setVisibility(8);
        if (this.mSurface != null) {
            FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mSurfaceViewlayout.getLayoutParams();
            if (getResources().getConfiguration().orientation == 1) {
                param.width = -1;
                param.height = -1;
                param.gravity = 83;
                param.setMargins(this.mPreviewPaddigLeft, this.mPreViewPaddingTop, this.mPreviewPaddingRight, this.mPrviewPaddingButton);
            } else {
                param.width = this.mLandPreviewFullHeight;
                param.height = -1;
                param.gravity = 83;
                param.setMargins(this.mLandPreviewPaddigLeft, this.mLandPreViewPaddingTop, this.mLandPreviewPaddingRight, this.mLandPrviewPaddingButton);
            }
            this.mSurfaceViewlayout.setLayoutParams(param);
        }
    }

    private void resetLayoutData() {
        logI("resetLayoutData()");
        this.mCalluserInfo = getCallOtherPartyUserInfo();
        if (this.mCallInfoLayout != null) {
            this.mCallInfoLayout.initLayout(this.mDestination, this.mCalluserInfo, this);
        }
        if (this.mVideoCallStatusBar != null) {
            this.mVideoCallStatusBar.initLayout(this.mDestination, this.mCalluserInfo, this, this);
        }
        if (this.mCallReceiveBtnLayout != null) {
            this.mCallReceiveBtnLayout.setDestination(this.mDestination);
        }
        if (this.mCallOutgoingCallLayout != null) {
            if (CallState.isNotConnected(this.mCallState)) {
                setViewGuideLineStatus(0, 1);
                setViewGuideLineStatus(0, 0);
                this.mCallOutgoingCallLayout.setVisibility(8);
            }
            this.mCallOutgoingCallLayout.initLayout(this.mDestination, false, this.mCalluserInfo, this, this);
        }
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.setHangUpButtonToggle(true);
        }
        if (this.mVideoCallOptionMenu != null) {
            this.mVideoCallOptionMenu.setParent(this, this.mIsLandscapeMode);
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity, com.sds.coolots.call.view.CallActivity, android.app.Activity
    protected void onResume() throws Settings.SettingNotFoundException {
        logI("onResume()++");
        this.mActivityStatus = 2;
        this.mIsQuickEndCall = false;
        this.mUseAlterImage = MainApplication.mPhoneManager.getPhoneStateMachine().getHideState();
        this.mSavedOrientation = getSystemBarOrientation();
        setHideMeOrientation();
        this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
        MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().acquireScreenBrightWakeLock(CoolotsWakeLockList.WAKELOCK_TAG_VIDEO_CALL);
        int mAutomatic = 0;
        try {
            mAutomatic = Settings.System.getInt(getBaseContext().getContentResolver(), "screen_brightness_mode");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        if (mAutomatic == 1) {
            this.bTurnOnScrAB = true;
            Settings.System.putInt(getBaseContext().getContentResolver(), "screen_brightness_mode", 0);
            setBrightnessChange();
        } else {
            this.bTurnOnScrAB = false;
        }
        if (this.mIsNativeCall && this.mSpeakerOn && !this.mAudioPathController.isBlueToothOn() && !this.mAudioPathController.isEarPhonePlugged()) {
            enableSpeakerCall();
        }
        if (getCallFunctionController().getCallSwitchingProcessing() == 2) {
            updateUIComponent();
            getCallFunctionController().setCallSwitchingProcessing(0);
        }
        super.onResume(true);
        logI("onResume()--");
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public void setBrightnessChange() throws Settings.SettingNotFoundException {
        logI("setBrightnessChange()");
        int BrightnessValue = 0;
        boolean bAutoBrightness = false;
        try {
            BrightnessValue = Settings.System.getInt(getBaseContext().getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        Window win = getWindow();
        WindowManager.LayoutParams layoutParams = win.getAttributes();
        if (this.bTurnOnScrAB) {
            bAutoBrightness = true;
        }
        if (bAutoBrightness) {
            layoutParams.screenBrightness = -1.0f;
            int BrightnessValue2 = BrightnessValue + 20;
            if (BrightnessValue2 >= 255) {
                BrightnessValue2 = 255;
            }
            layoutParams.screenBrightness = ((BrightnessValue2 * 100) / 255) * 0.01f;
        }
        win.setAttributes(layoutParams);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity, com.sds.coolots.call.view.CallActivity, android.app.Activity
    protected void onPause() {
        logI("onPause()++");
        this.mActivityStatus = 3;
        super.onPause(true);
        this.mConfigInfo = getChangingConfigurations();
        MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releasePartialWakeLock(CoolotsWakeLockList.WAKELOCK_TAG_VIDEO_CALL);
        logI("onPause()--");
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity, android.app.Activity
    protected void onUserLeaveHint() {
        logI("onUserLeaveHint()");
        this.mIsInitAngle = false;
        this.mActivityStatus = 5;
        super.onUserLeaveHint(true);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity, com.sds.coolots.call.view.CallActivity, android.app.Activity
    protected void onDestroy() {
        logI("onDestroy()++");
        this.mActivityStatus = 4;
        dispose();
        if (this.mIsOutGoingCall) {
            try {
                unregisterReceiver(this.mBatteryChangeReceiver);
            } catch (IllegalArgumentException e) {
                logE("IllegalArgumentException \n e");
            }
            this.mBatteryChangeReceiver = null;
        }
        super.onDestroy(true);
        logI("onPause()--");
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    protected void initActivity() {
        logI("initActivity()");
        getScreenSize();
        this.mModelInfo = new LiveShareModel(this.mIsOutGoingCall);
        this.mModelDeviceInfo = ModelCreator.getModelInfo(this.mDisplayWidth, this.mDisplayHeight);
        this.mDeviceType = ModelCreator.checkDeviceModel(this.mDisplayWidth, this.mDisplayHeight);
        this.mPreviewHeight = this.mModelInfo.getPreviewHeight();
        this.mPreviewWidth = this.mModelInfo.getPreviewWidth();
        initLayoutData();
        this.mShareViewCtrl = new VideoShareViewController();
        this.mShareViewCtrl.stop();
        initView();
        if (this.mUseVideo) {
            if (PhoneManager.getMediaEngineType() != 2 && PhoneManager.getMediaEngineType() != 1) {
                MainApplication.mPhoneManager.getPhoneStateMachine().setRender(this.mDestination, getWindowManager().getDefaultDisplay().getWidth(), getWindowManager().getDefaultDisplay().getHeight());
            }
            if (isConference()) {
                this.mUseFrontCamera = SECConfig.isUseFrontCamera(true);
            } else {
                this.mUseFrontCamera = SECConfig.isUseFrontCamera(false);
            }
            logI("VideoCallActivity : initActivity() : mUseFrontCamera = " + this.mUseFrontCamera);
            if (isConference()) {
                SECConfig.getResolution(true);
            } else {
                SECConfig.getResolution(false);
            }
            this.mSavedOrientation = getSystemBarOrientation();
            this.mOrientation.enable();
        }
        this.mGestureDetector = new GestureDetector(this, this);
        this.mAudioManager = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (getResources().getConfiguration().orientation == 1) {
            this.mImgPoint = new Point(this.mPreviewPaddigLeft, this.mPreViewPaddingTop);
            this.mDefaultHideImg = ChatONSettingData.getInstance().getVideoCallImage(true, false);
        } else {
            this.mImgPoint = new Point(this.mLandPreviewPaddigLeft, this.mLandPreViewPaddingTop);
            this.mDefaultHideImg = ChatONSettingData.getInstance().getVideoCallImage(true, true);
        }
        checkCallInstanceNRefresh();
        if (this.mVideoCallOptionMenu != null) {
            this.mVideoCallOptionMenu.resetAllData();
        }
    }

    private void initLayoutData() {
        logI("initLayoutData()");
        this.mIsTabDevice = this.mModelInfo.isTabDevice();
        this.mPrviewPaddingButton = this.mModelInfo.getPortPreviewPaddingBottom();
        this.mPreViewPaddingTop = this.mModelInfo.getPortPreviewY();
        this.mPreviewPaddingRight = this.mModelInfo.getPortPaddingRight();
        this.mPreviewPaddigLeft = this.mModelInfo.getPortPreviewX();
        this.mPreviewMarginButtom = this.mModelInfo.getPortPaddingBottom();
        this.mLandPrviewPaddingButton = this.mModelInfo.getLandPreviewPaddingBottom();
        this.mLandPreViewPaddingTop = this.mModelInfo.getLandPreviewY();
        this.mLandPreviewPaddingRight = this.mModelInfo.getLandPaddingRight();
        this.mLandPreviewPaddigLeft = this.mModelInfo.getLandPreviewX();
        this.mLandRemoteViewMarginButtom = this.mModelInfo.getLandPaddingBottom();
        this.mLandPreviewFullHeight = this.mModelInfo.getLandFullHeight();
        this.mLandPreviewFullWidth = this.mModelInfo.getLandFullWidth();
        this.mStatusBarLength = this.mModelInfo.getStatusBarLength();
        this.mHWGap = (this.mModelInfo.getPreviewHeight() - this.mModelInfo.getPreviewWidth()) / 2;
    }

    private void initView() {
        logI("initView()");
        this.mCallInfoLayout = (VideoCallStartScreenLayout) findViewById(C0000R.id.video_call_info);
        this.mCallBtnLayout = (VideoCallBtnLayout) findViewById(C0000R.id.video_call_btn);
        this.mCallEndBtnLayout = (VoiceCallEndBtnLayout) findViewById(C0000R.id.video_call_endbtn);
        this.mCallReceiveBtnLayout = (IncomingSlidingWidget) findViewById(C0000R.id.video_call_receive_btn);
        this.mVideolayout = (FrameLayout) findViewById(C0000R.id.video_layout);
        this.mCallInfoBGLayout = (FrameLayout) findViewById(C0000R.id.video_call_info_bottom);
        this.mCallOutgoingCallLayout = (VideoCallOutgoingCallLayout) findViewById(C0000R.id.video_call_outgoing);
        this.mVideoCallStatusBar = (VideoCallStatusBar) findViewById(C0000R.id.video_call_status_view);
        this.mInviteviewMemberLayout = (InviteViewMemberLayout) findViewById(C0000R.id.video_call_inviteview_member);
        this.mRemoteVideoLayoutRadvision = (FrameLayout) findViewById(C0000R.id.radvision_video_layout);
        this.mSurfaceViewlayout = (FrameLayout) findViewById(C0000R.id.surface_view_layout);
        this.mShareViewLayout = (ViewGroup) findViewById(C0000R.id.video_share_view_layout);
        this.mShareViewCloseButton = (Button) this.mShareViewLayout.findViewById(C0000R.id.share_view_btn_close_up);
        this.mShareViewZoomInButton = (Button) this.mShareViewLayout.findViewById(C0000R.id.share_view_btn_zoom_in);
        this.mShareViewZoomOutButton = (Button) this.mShareViewLayout.findViewById(C0000R.id.share_view_btn_zoom_out);
        this.mShareViewPinchZoomGuideLineLayout = (ViewGroup) findViewById(C0000R.id.video_call_camera_guideline_layout);
        this.mShareViewPinchZoomView = (RelativeLayout) this.mShareViewPinchZoomGuideLineLayout.findViewById(C0000R.id.camera_guide_line_resize_layout);
        this.mShareViewPinchZoomGuideScaleText = (TextView) this.mShareViewPinchZoomGuideLineLayout.findViewById(C0000R.id.video_call_camera_guideline_scale_text);
        this.mShareViewPinchZoomGuideLineLayout.setVisibility(8);
        goneShareViewBtn();
        disposePinchZoomController();
        this.mSCameraSendFileLayout = (ViewGroup) findViewById(C0000R.id.scamera_send_file_layout);
        this.mCapturedImageList.add((ImageView) findViewById(C0000R.id.scamera_captured_img1));
        this.mCapturedImageList.add((ImageView) findViewById(C0000R.id.scamera_captured_img2));
        this.mCapturedImageList.add((ImageView) findViewById(C0000R.id.scamera_captured_img3));
        this.mSCameraTextView = (TextView) findViewById(C0000R.id.scamera_text_view);
        this.mSendButton = (Button) findViewById(C0000R.id.scamera_file_send_btn);
        this.mCancelButton = (Button) findViewById(C0000R.id.scamera_file_cancel_btn);
        this.mImageView_animated = (ImageView) findViewById(C0000R.id.scamera_captured_image_view);
        initOutgoingCallLayout();
        this.mMemberViewLayout = (ViewGroup) findViewById(C0000R.id.video_call_member_layout);
        this.mMemberViewLayout.setVisibility(8);
        if (PhoneManager.getMediaEngineType() == 2 || PhoneManager.getMediaEngineType() == 1) {
            this.mRemoteVideoLayoutRadvision.setVisibility(0);
            this.mSurfaceViewlayout.setVisibility(0);
        }
        if (this.mUseVideo) {
            this.mSurface = (SurfaceView) findViewById(C0000R.id.surface_view);
            this.mSurface.setVisibility(0);
            this.mHolder = this.mSurface.getHolder();
            this.mHolder.addCallback(this);
            this.mHolder.setType(3);
            if (PhoneManager.getMediaEngineType() == 2 || PhoneManager.getMediaEngineType() == 1) {
                this.mRemoteSurface = (SurfaceView) findViewById(C0000R.id.omx_video_view);
                this.mRemoteHolder = this.mRemoteSurface.getHolder();
                this.mRemoteHolder.addCallback(this);
                this.mRemoteHolder.setType(3);
            }
            this.mSurface.setZOrderMediaOverlay(true);
            this.mRemoteSurface.setZOrderMediaOverlay(false);
        }
        this.mCalluserInfo = getCallOtherPartyUserInfo();
        this.mCallInfoLayout.initLayout(this.mDestination, this.mCalluserInfo, this);
        this.mVideoCallStatusBar.initLayout(this.mDestination, this.mCalluserInfo, this, this);
        this.mInviteViewCtrl = new InviteViewController(this, this, this.mInviteviewMemberLayout.getInviteViewLayout(), this.mInviteviewMemberLayout.getInviteListView());
        this.mInviteViewCtrl.stop();
        checkWaitMemberForInviteView();
        updateMemberCount();
        this.mMemberViewCtrl = new MemberViewController(this, this, this.mMemberViewLayout);
        this.mCallOutgoingCallLayout.initLayout(this.mDestination, false, this.mCalluserInfo, this, this);
        this.mCallBtnLayout.setParent(this);
        this.mCallReceiveBtnLayout.initialize(this, this.mDestination, this.mCalluserInfo);
        this.mVideoRepositionView = (VideoCallRepositionView) findViewById(C0000R.id.reposition_view);
        this.mVideoRepositionView.setParent(this);
        this.mVideoRepositionView.setDeviceType(this.mModelInfo);
        this.mVideoCallOptionMenu = (VideoCallOptionMenu) findViewById(C0000R.id.video_option_layout);
        this.mVideoCallOptionMenu.setParent(this, this.mIsLandscapeMode);
        this.mOnlyBuddyLayout = (FrameLayout) findViewById(C0000R.id.indicator_view_layout);
        this.mOnlyBuddyLayout.setBackgroundDrawable(getResources().getDrawable(C0000R.drawable.scamera_showme));
        if (this.mOnlyBuddyLayout != null) {
            FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mOnlyBuddyLayout.getLayoutParams();
            param.gravity = TOUCH_MIN_DISTANCE;
            param.rightMargin = 0;
            this.mOnlyBuddyLayout.setLayoutParams(param);
        }
        this.mOnlyBuddyLayout.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                LiveShareViewActivity.this.logI("OnClickListener() mOnlyBuddyLayout");
                LiveShareViewActivity.this.changeLayoutRemoteSingleTab();
            }
        });
        this.mOtherPartyCapture = (ImageView) findViewById(C0000R.id.capture_video_view);
        this.mCaptureImage = (ImageView) findViewById(C0000R.id.capture_video_preview);
        this.mRecordLayout = (ViewGroup) findViewById(C0000R.id.record_status_bar);
        this.mRecordTime = (Chronometer) findViewById(C0000R.id.record_status_time);
        this.mImageCaptureAnimationImageView = (ImageView) findViewById(C0000R.id.image_capture_animation_far_end);
        prepareCaptureAnimation();
        restoreData();
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public boolean checkCallInstanceNRefresh() {
        logI("checkCallInstanceNRefresh()");
        super.checkCallInstanceNRefresh(true);
        resetLayoutData();
        return true;
    }

    private boolean isDefaultHideMeImage() {
        checkCallInstanceNRefresh();
        return this.mCallStatusData.isDefaultHideMeImage();
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    protected void updateUIComponent() {
        logI("updateUIComponent()++");
        if (this.mAudioPathController != null) {
            updateCallState();
            if (MainApplication.mCallNotification.showQuickPanel()) {
                MainApplication.mCallNotification.showCallButtonNotification();
            }
            if (this.mAudioPathController.isBlueToothOn()) {
                onBTButton();
            }
            if (this.mCallState == 5) {
                notifyMute();
            } else {
                cancelMute();
            }
            if (CallState.isNotConnected(this.mCallState)) {
                logI("CallState: NotConnected");
                updateAlertsOnCall(true);
                checkHookingHomeKey(!this.mIsOutGoingCall);
                checkHookingPowerKey(!this.mIsOutGoingCall);
                if (getAudioPathController() != null && getAudioPathController().isSpeakerON()) {
                    notifySpeakerphone();
                }
                sendRotationInfoToServer(this.mInstantOrientation, true);
                this.mVideolayout.setVisibility(0);
                setViewGuideLineStatus(0, 0);
                setViewGuideLineStatus(0, 1);
                this.mCallEndBtnLayout.setVisibility(8);
                if (this.mBackUpObj == null) {
                    setShowMe();
                }
                if (this.mIsOutGoingCall) {
                    this.mCallOutgoingCallLayout.setVisibility(8);
                    this.mCallBtnLayout.setVisibility(8);
                    this.mCallReceiveBtnLayout.setVisibility(8);
                } else {
                    if (getResources().getConfiguration().orientation == 2) {
                        setLandScapeIncomingPreview();
                    }
                    if (!ChatONSettingData.getInstance().isOwnVideo()) {
                        excuteOwnVideo();
                    }
                    this.mCallBtnLayout.setVisibility(8);
                    this.mCallReceiveBtnLayout.setVisibility(0);
                    this.mCallInfoLayout.setVisibility(0);
                    this.mCallInfoBGLayout.setVisibility(0);
                    showCallIncomingAnimation();
                }
                if (!this.mIsOutGoingCall) {
                    if (isLowBattery()) {
                        hangupCallWithQuickDestroy(getResources().getText(C0000R.string.video_low_battery).toString());
                        return;
                    }
                    if (MainApplication.mConfig.isUseWifiOnly() && !PhoneManager.isWifiNetworkConnected(MainApplication.mContext)) {
                        hangupCallWithQuickDestroy(getResources().getText(C0000R.string.video_call_wifi_only_mode).toString());
                        return;
                    }
                    this.mCallReceiveBtnLayout.showReceveBtnAnimation();
                    if (this.mAutoReceiveTime >= 1) {
                        this.mAutoReceiveCnt = true;
                        if (this.mAudioPathController.isBlueToothConnected() || this.mAudioPathController.isEarPhonePlugged()) {
                            autoReceiveCall();
                        }
                    }
                }
                this.mCountConnectedState = 0;
            } else if (CallState.isConnected(this.mCallState)) {
                logI("<<YHT101>>-----------------------------CallState: Connected-------------------");
                checkHookingHomeKey(false);
                checkHookingPowerKey(true);
                sendRotationInfoToServer(this.mSavedOrientation, true);
                logI("<<YHT101>>-----------------------------IsConnected!!!!-------------------");
                this.mVideolayout.setVisibility(0);
                if (!this.mIsMSurfaceOnTop) {
                    changeSurfaceZOrder();
                    this.mIsMSurfaceOnTop = true;
                }
                if (!this.mIsOutGoingCall) {
                    viewTopStatusBar();
                }
                if (this.mIsOutGoingCall) {
                    if (!this.mgFlag) {
                        callConnectedOutgoingCallLayout();
                        this.mInnerHandler.sendEmptyMessageDelayed(SCAMERA_STOP_CALL_CONNECTED_MSG, 2000L);
                    }
                } else {
                    this.mCallInfoLayout.setVisibility(8);
                }
                this.mCallInfoBGLayout.setVisibility(8);
                logE("mgFlag = " + this.mgFlag);
                if (!this.mIsOutGoingCall) {
                    this.mCallBtnLayout.setVisibility(0);
                    this.mCallBtnLayout.setHideme(this.mUseAlterImage);
                    this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
                    setCallButtonShareViewStart();
                    this.mCallEndBtnLayout.setVisibility(8);
                    this.mCallReceiveBtnLayout.setVisibility(8);
                } else {
                    this.mCallBtnLayout.setVisibility(8);
                }
                setConferenceSurface(isConference(), false);
                checkWaitMemberForInviteView();
                updateMemberCount();
                logE("mgFlag = " + this.mgFlag);
                if (!this.mgFlag) {
                    if (!this.mIsOutGoingCall) {
                        startShareView(false);
                        this.mShareViewCtrl.setFullScreen(!this.mShareViewCtrl.isFullScreen());
                        updateShareViewZoomLayout();
                        this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
                    }
                    changeLayoutRemoteSingleTab();
                    changeLayoutRemoteSingleTab();
                    this.mgFlag = true;
                }
                if (isConference() && showNetworkWeakPopup()) {
                    logI("network weak toast show!!!!!!!!!!!!!!!!!!!!!!");
                    showToast(C0000R.string.popup_msg_network_weak_during_videocall_atnt, 5000);
                    setNetworkWeakPopupExist(false);
                }
                setPreViewWhiteOutLine();
                if (this.mMemberViewCtrl.ismMemberViewActive()) {
                    gonePreviewLayout();
                }
                this.mCountConnectedState++;
            } else if (CallState.isDisconnected(this.mCallState)) {
                logI("CallState: Disconnected");
                notifyCallEndToOtherActivity();
                this.mHangUpCall = true;
                SystemClock.sleep(200L);
                updateAlertsOnCall(false);
                checkHookingPowerKey(false);
                checkHookingPowerKey(false);
                cancelSpeakerphone();
                if (this.mIsOutGoingCall) {
                    hangupOutgoingCallLayout();
                } else {
                    this.mSCameraSendFileLayout.setVisibility(8);
                    ((LinearLayout) this.mSCameraRecvImg.getParent()).setVisibility(8);
                }
                if (this.mCountConnectedState != 0 || this.mIsOutGoingCall) {
                    settingEndCall();
                } else {
                    quitActivity();
                }
                if (this.mIsRecording) {
                    setRecord();
                    showToast(getResources().getString(C0000R.string.video_complete_record));
                }
                closeImageCropActivity();
                checkNetworkDisconnect();
            }
            logI("updateUIComponent()--");
        }
    }

    private void setConferenceSurface(boolean isConference, boolean forceConference) {
        if (SECConfig.isUseFrontCamera(isConference)) {
            logI("<<YHT101>>-----------------------------SECConfig.isUseFrontCamera(is_conference)-------------------");
            if (this.mDestination.getDestinationType() == 4 || forceConference) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) this.mRemoteSurface.getLayoutParams();
                params.gravity = 119;
                params.width = -1;
                params.height = -1;
                params.topMargin = 0;
                if (getResources().getConfiguration().orientation == 1) {
                    params.bottomMargin = this.mModelInfo.getPortPaddingBottom();
                    params.rightMargin = 0;
                } else {
                    params.bottomMargin = 0;
                    params.rightMargin = 0;
                }
                this.mRemoteSurface.setLayoutParams(params);
                if (this.mCountConnectedState == 0) {
                    resizePreview2OriginalSize();
                    return;
                } else {
                    changedPreviewLayout(false);
                    return;
                }
            }
            if (this.mCountConnectedState == 0) {
                resizePreview2OriginalSize();
                return;
            }
            return;
        }
        if (ModelInfoUtil.IS_MODEL_SCAMERA && this.mCountConnectedState == 0) {
            resizePreview2OriginalSize();
        } else if (this.mChanagePreview) {
            setSECPreViewOrientation(this.mRemoteRotation, true);
        } else {
            setSECOrientation(this.mRemoteRotation, true);
        }
    }

    private void closeImageCropActivity() {
        if (this.mIsExcuteIntent) {
            if (this.mActivityStatus == 3 || this.mActivityStatus == 4 || this.mActivityStatus == 5) {
                logI("closeImageCropActivity  mIsExcuteIntent" + this.mIsExcuteIntent + " mActivityStatus: " + this.mActivityStatus);
                Intent intentFinish = new Intent("ChatONHideMeCropActivity.FINISH");
                sendBroadcast(intentFinish);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void settingEndCall() {
        logI("settingEndCall()");
        this.mCallEndBtnLayout.videoCallRetryButtonToggle(true);
        this.mSurfaceViewlayout.setVisibility(8);
        this.mCallOutgoingCallLayout.setVisibility(8);
        goneTopStatusBar();
        this.mRemoteVideoLayoutRadvision.setVisibility(8);
        this.mSurface.setVisibility(8);
        this.mRemoteSurface.setVisibility(8);
        this.mInviteViewCtrl.endInviteView();
        endMemberView();
        endShareView();
        videoCallEndUIDisplaybeforeCamrelease();
        if (this.mIsOutGoingCall) {
            quitActivity();
        } else {
            delayedQuit();
        }
    }

    private void updateCallState() {
        logI("updateCallState()");
        this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
        this.mVideoCallStatusBar.setUIState(this.mCallState);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.controller.IMemberViewController
    public void updateLayoutChangeDestination() {
        logI("updateLayoutChangeDestination()");
        if (this.mIsOutGoingCall) {
            this.mCallOutgoingCallLayout.initLayout(this.mDestination, false, this.mCalluserInfo, this, this);
        } else {
            this.mCallInfoLayout.initLayout(this.mDestination, this.mCalluserInfo, this);
        }
        this.mVideoCallStatusBar.initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPreviewPositinoForConferenceCall() {
        logI("checkPreviewPositinoForConferenceCall : mMemberCount: " + this.mMemberCount + " newMember: " + this.mDestinationUtil.getConferenceConnectCount(this.mDestination));
        if (this.mMemberCount != -1 && this.mMemberCount < getConferenceConnectCount()) {
            initPreviewPosition();
            switchAutoModePreviewPosition();
            if (this.mChanagePreview) {
                setViewGuideLineStatus(0, 1);
                setDefaultSurfaceView(true);
                setViewGuideLineStatus(1, 0);
            }
            setConferenceSurface(true, true);
        }
    }

    protected class VideoCallHandler extends ChatOnCallHandler {
        private boolean bDisposed;

        public VideoCallHandler(CallActivity parent) {
            super(parent);
            this.bDisposed = false;
        }

        @Override // com.coolots.chaton.call.view.ChatOnCallHandler, com.sds.coolots.call.view.CallHandler, com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            this.bDisposed = true;
        }

        @Override // com.coolots.chaton.call.view.ChatOnCallHandler, com.sds.coolots.call.view.CallHandler, android.os.Handler
        public void handleMessage(Message msg) {
            if (!this.bDisposed) {
                LiveShareViewActivity.this.logI("<handleMessage> msg.what:" + msg.what);
                switch (msg.what) {
                    case EventCode.EVENT_CONF_UPDATE_MEMBER /* 7004 */:
                        LiveShareViewActivity.this.logI("EventCode.EVENT_CONF_UPDATE_MEMBER");
                        LiveShareViewActivity.this.mDestination = (Destination) msg.obj;
                        if (LiveShareViewActivity.this.checkDestinationForUIUpdate()) {
                            LiveShareViewActivity.this.updateLayoutChangeDestination();
                            LiveShareViewActivity.this.checkInviteView();
                            LiveShareViewActivity.this.checkMemberView();
                            LiveShareViewActivity.this.checkPreviewPositinoForConferenceCall();
                            break;
                        } else {
                            return;
                        }
                    case EventCode.EVENT_CONF_CHANGE_LAYOUT /* 7017 */:
                        LiveShareViewActivity.this.handleChangeConferenceLayout(msg.arg1);
                        break;
                    case EventCode.EVENT_CONF_CHANGE_HOLD /* 7018 */:
                        ArrayList<String> userIDList = (ArrayList) msg.obj;
                        LiveShareViewActivity.this.handleConferenceChangeHold(userIDList);
                        break;
                    case EventCode.EVENT_CONF_CHANGE_UNHOLD /* 7019 */:
                        ArrayList<String> userIDList1 = (ArrayList) msg.obj;
                        LiveShareViewActivity.this.handleConferenceChangeUnhold(userIDList1);
                        break;
                    case EventCode.EVENT_CALL_CAMERA_CLOSE_FOR_TOGGLE /* 7112 */:
                        LiveShareViewActivity.this.removeCameraForToggle();
                        break;
                    case EventCode.EVENT_CALL_CAMERA_CLOSE_FOR_VIDEOCALL /* 7113 */:
                        LiveShareViewActivity.this.removeCameraForVideoCall();
                        break;
                    case EventCode.EVENT_CALL_CAPTURE_IMAGE /* 7230 */:
                        LiveShareViewActivity.this.logI("<<YHT4>> EVENT_CALL_CAPTURE_IMAGE received!!");
                        LiveShareViewActivity.this.setNotiCapturedView();
                        break;
                    case EventCode.EVENT_CHANGE_TO_CONFERENCE_START /* 7602 */:
                        LiveShareViewActivity.this.logI("EVENT_CHANGE_TO_CONFERENCE_START()");
                        LiveShareViewActivity.this.handleChangeToConferenceStart();
                        break;
                    case EventCode.EVENT_CHANGE_TO_CONFERNECE_FAILURE /* 7603 */:
                        LiveShareViewActivity.this.logI("EVENT_CHANGE_TO_CONFERNECE_FAILURE()");
                        LiveShareViewActivity.this.handleChangeToConferenceFailure();
                        break;
                    case EventCode.EVENT_CHANGE_TO_CONFERENCE_FINISH /* 7604 */:
                        LiveShareViewActivity.this.logI("EVENT_CHANGE_TO_CONFERENCE_FINISH()");
                        LiveShareViewActivity.this.handleChangeToConferenceFinish();
                        LiveShareViewActivity.this.checkCallInstanceNRefresh();
                        LiveShareViewActivity.this.checkWaitMemberForInviteView();
                        LiveShareViewActivity.this.updateMemberCount();
                        break;
                    case EventCode.EVENT_CALL_REMOTEROTATION /* 7700 */:
                        int rotation = msg.arg1;
                        LiveShareViewActivity.this.onDrawRemoteSurface(rotation);
                        break;
                    case EventCode.EVENT_CALL_3G_RINGING_WHILE_VT /* 7800 */:
                    case EventCode.EVENT_CALL_3G_CALLING_WHILE_VT /* 7801 */:
                        String phoneNum = (String) msg.obj;
                        LiveShareViewActivity.this.setDisplay3GLayout(phoneNum);
                        LiveShareViewActivity.this.accpetNativeCall();
                        break;
                    case EventCode.EVENT_CALL_3G_IDLE_WHILE_VT /* 7802 */:
                        LiveShareViewActivity.this.logI("EventCode.EVENT_CALL_3G_IDLE_WHILE_VT");
                        LiveShareViewActivity.this.endNativeCall(msg.arg1, msg.arg2);
                        break;
                    case EventCode.EVENT_CALL_VIDEO_RECORD_START /* 7900 */:
                        LiveShareViewActivity.this.logI("<<YHT4>> EVENT_CALL_VIDEO_RECORD received!!");
                        LiveShareViewActivity.this.setOtherRecording();
                        break;
                    case EventCode.EVENT_CAMERA_START_ERROR /* 8205 */:
                        LiveShareViewActivity.this.logI("EventCode.EVENT_CAMERA_START_ERROR --> hide me start!!!!!!!!");
                        LiveShareViewActivity.this.makeHideMeImage();
                        break;
                    case LiveShareViewActivity.DISPLAY_CAPTURE_IMAGE /* 9367 */:
                        LiveShareViewActivity.this.mOtherPartyCapture.setVisibility(8);
                        break;
                    case LiveShareViewActivity.DISPLAY_CAPTURE_IMAGE_PREVIEW /* 9368 */:
                        LiveShareViewActivity.this.finishCaptureImgShow();
                        break;
                    case LiveShareViewActivity.STOP_CAPTURE_IMAGE_ANIMATION /* 9371 */:
                        LiveShareViewActivity.this.mImageCaptureAnimationImageView.setVisibility(4);
                        LiveShareViewActivity.this.mCaptureImageAnimation.stop();
                        LiveShareViewActivity.this.showToast(LiveShareViewActivity.this.getResources().getString(C0000R.string.video_image_capture));
                        try {
                            LiveShareViewActivity.this.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
                            break;
                        } catch (Throwable t) {
                            t.printStackTrace();
                            break;
                        }
                    case 10006:
                        LiveShareViewActivity.this.mIsUpNomalTerminatingCall = true;
                        break;
                    case EventCode.EVENT_FILE_SEND_START /* 95001 */:
                        LiveShareViewActivity.this.handleFileSendStart();
                        break;
                    case EventCode.EVENT_FILE_SEND_DONE /* 95002 */:
                        LiveShareViewActivity.this.handleFileSendDone();
                        break;
                    case EventCode.EVENT_FILE_RECV_START /* 95003 */:
                        LiveShareViewActivity.this.handleFileRecvStart(msg.arg1);
                        break;
                    case EventCode.EVENT_FILE_RECV_DONE /* 95004 */:
                        LiveShareViewActivity.this.handleFileRecvDone((ArrayList) msg.obj);
                        break;
                }
                super.handleMessage(msg);
            }
        }
    }

    private class InnerHandler extends Handler implements DisposeInterface {
        private boolean isDispose;

        private InnerHandler() {
            this.isDispose = false;
        }

        /* synthetic */ InnerHandler(LiveShareViewActivity liveShareViewActivity, InnerHandler innerHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) throws Resources.NotFoundException {
            if (!this.isDispose) {
                LiveShareViewActivity.this.logI("<mInnerHandler> msg.what:" + msg.what);
                switch (msg.what) {
                    case 1:
                        if (LiveShareViewActivity.this.mCallEndBtnLayout != null) {
                            LiveShareViewActivity.this.mCallEndBtnLayout.setVisibility(0);
                            break;
                        }
                        break;
                    case 2:
                        LiveShareViewActivity.this.mShareViewPinchZoomGuideLineLayout.setVisibility(8);
                        break;
                    case LiveShareViewActivity.SCAMERA_DISPLAY_SEND_FILE_LAYOUT /* 123 */:
                        if (LiveShareViewActivity.this.mIsOutGoingCall) {
                            LiveShareViewActivity.this.setSCameraSendFileLayout();
                            break;
                        }
                        break;
                    case LiveShareViewActivity.SCAMERA_SEND_DONE /* 124 */:
                        LiveShareViewActivity.this.mSCameraSendFileLayout.setVisibility(8);
                        LiveShareViewActivity.this.changeBottomButtonPosition();
                        if (!LiveShareViewActivity.this.mIsOutGoingCall) {
                            File file = new File((String) LiveShareViewActivity.this.mRecvImageList.get(LiveShareViewActivity.this.mRecvImageList.size() - 1));
                            if (file.exists()) {
                                LiveShareViewActivity.this.showRecvImage((String) LiveShareViewActivity.this.mRecvImageList.get(LiveShareViewActivity.this.mRecvImageList.size() - 1));
                            }
                            LiveShareViewActivity.this.mRecvImageList.clear();
                        }
                        if (LiveShareViewActivity.this.mCapturedImageList != null && !LiveShareViewActivity.this.mCapturedImageList.isEmpty()) {
                            Iterator it = LiveShareViewActivity.this.mCapturedImageList.iterator();
                            while (it.hasNext()) {
                                ImageView view = (ImageView) it.next();
                                ((LinearLayout) view.getParent()).setVisibility(8);
                            }
                            LiveShareViewActivity.this.mCapturedImageList.clear();
                        }
                        LiveShareViewActivity.this.mIsReceivingFile = false;
                        break;
                    case LiveShareViewActivity.SCAMERA_SAVE_DONE /* 125 */:
                        LiveShareViewActivity.this.mFrameAnimation.stop();
                        LiveShareViewActivity.this.mSCameraSendingFileAnimation.setVisibility(8);
                        LiveShareViewActivity.this.mSCameraTextView.setText(LiveShareViewActivity.this.getResources().getString(C0000R.string.scamera_save_files));
                        LiveShareViewActivity.this.mInnerHandler.sendEmptyMessageDelayed(LiveShareViewActivity.SCAMERA_SEND_DONE, 1000L);
                        break;
                    case LiveShareViewActivity.SCAMERA_WAIT_FOCUS /* 126 */:
                        if (ModelInfoUtil.IS_MODEL_SCAMERA && LiveShareViewActivity.this.mWaitFocus) {
                            LiveShareViewActivity.this.mWaitFocus = false;
                            if (LiveShareViewActivity.this.mLastZoomState != 0) {
                                LiveShareViewActivity.this.setCameraZoomAction(LiveShareViewActivity.this.mLastZoomState);
                                break;
                            }
                        }
                        break;
                    case LiveShareViewActivity.SCAMERA_STOP_CALL_CONNECTED_MSG /* 127 */:
                        LiveShareViewActivity.this.stopCallConnectedMsgOutgoingCallLayout();
                        break;
                    case 128:
                        if (LiveShareViewActivity.this.mSCameraVolumeUiLayout.getVisibility() == 0) {
                            LiveShareViewActivity.this.mSCameraVolumeUiLayout.setVisibility(4);
                            break;
                        }
                        break;
                    case LiveShareViewActivity.SCAMERA_HIDE_ANIMATION_MENU_BAR /* 129 */:
                        LiveShareViewActivity.this.hideAnimationMenu();
                        break;
                }
                LiveShareViewActivity.this.mInnerHandler.removeMessages(msg.what);
            }
        }

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            this.isDispose = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishCaptureImgShow() {
        this.mCaptureImage.setVisibility(8);
        this.mHandler.removeMessages(DISPLAY_CAPTURE_IMAGE_PREVIEW);
        this.mIsOtherCapture = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDrawRemoteSurface(int rotation) {
        logI("onDrawRemoteSurface(" + rotation + ")");
        if (!isConference()) {
            this.mRemoteRotation = rotation;
            if (this.mChanagePreview) {
                setSECPreViewOrientation(this.mRemoteRotation, true);
            } else {
                setSECOrientation(this.mRemoteRotation, true);
            }
        }
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        int action = event.getAction();
        int scanCode = event.getScanCode();
        logI("dispatchKeyEvent() keyCode = " + keyCode + ", action = " + action + ", scanCode = " + scanCode);
        if (!ModelInfoUtil.IS_MODEL_SCAMERA) {
            return super.dispatchKeyEvent(event);
        }
        if (keyCode != 27 && keyCode != 168 && keyCode != 169) {
            return super.dispatchKeyEvent(event);
        }
        switch (keyCode) {
            case 27:
                if (action != 1 || !CallState.isConnected(this.mCallState)) {
                }
                break;
            case 168:
            case 169:
                logI("mLastZoomState = " + this.mLastZoomState + ", mWaitFocus = " + this.mWaitFocus);
                if (!this.mIsOutGoingCall) {
                    break;
                } else {
                    if (action == 1 && this.mLastZoomState != 0) {
                        if (!this.mWaitFocus) {
                            logI("Call setCameraZoomAction zero");
                            setCameraZoomAction(0);
                            this.mWaitFocus = true;
                            this.mInnerHandler.sendEmptyMessageDelayed(SCAMERA_WAIT_FOCUS, 1000L);
                        }
                        this.mLastZoomState = 0;
                    }
                    if (keyCode == 168) {
                        if (action == 0) {
                            if (this.mLastZoomState != 1) {
                                if (!this.mWaitFocus) {
                                    setCameraZoomAction(1);
                                }
                                this.mLastZoomState = 1;
                                break;
                            }
                        } else if (action == 2 && this.mLastZoomState != 3) {
                            if (!this.mWaitFocus) {
                                setCameraZoomAction(3);
                            }
                            this.mLastZoomState = 3;
                            break;
                        }
                    } else if (keyCode == 169) {
                        if (action == 0) {
                            if (this.mLastZoomState != 2) {
                                if (!this.mWaitFocus) {
                                    setCameraZoomAction(2);
                                }
                                this.mLastZoomState = 2;
                                break;
                            }
                        } else if (action == 2 && this.mLastZoomState != 4) {
                            if (!this.mWaitFocus) {
                                setCameraZoomAction(4);
                            }
                            this.mLastZoomState = 4;
                            break;
                        }
                    }
                }
                break;
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        logI("onKeyUp() keyCode: " + keyCode);
        if (keyCode == 4) {
            if (CallState.isNotConnected(this.mCallState)) {
                if (this.mIsOutGoingCall) {
                    return true;
                }
                this.mCallReceiveBtnLayout.closeRejectMsg();
                return true;
            }
            if (!CallState.isConnected(this.mCallState)) {
                return true;
            }
            if (this.mMemberViewCtrl.ismMemberViewActive()) {
                endMemberView();
                setSurfaceViewLayout();
            }
            closeOptionsMenu();
            return true;
        }
        if (keyCode == 26) {
            this.mIsPowerLongPressed = false;
        } else if (keyCode == 27 && ModelInfoUtil.IS_MODEL_SCAMERA && CallState.isConnected(this.mCallState)) {
            if (!CallState.isConnected(this.mCallState)) {
                return true;
            }
        } else {
            if (keyCode == 168 && ModelInfoUtil.IS_MODEL_SCAMERA) {
                logI("mLastZoomState = " + this.mLastZoomState + ", mWaitFocus = " + this.mWaitFocus);
                if (this.mLastZoomState == 0) {
                    return true;
                }
                if (!this.mWaitFocus) {
                    logI("Call setCameraZoomAction zero");
                    setCameraZoomAction(0);
                    this.mWaitFocus = true;
                    this.mInnerHandler.sendEmptyMessageDelayed(SCAMERA_WAIT_FOCUS, 1000L);
                }
                this.mLastZoomState = 0;
                return true;
            }
            if (keyCode == 169 && ModelInfoUtil.IS_MODEL_SCAMERA) {
                logI("mLastZoomState = " + this.mLastZoomState + ", mWaitFocus = " + this.mWaitFocus);
                if (this.mLastZoomState == 0) {
                    return true;
                }
                if (!this.mWaitFocus) {
                    logI("Call setCameraZoomAction zero");
                    setCameraZoomAction(0);
                    this.mWaitFocus = true;
                    this.mInnerHandler.sendEmptyMessageDelayed(SCAMERA_WAIT_FOCUS, 1000L);
                }
                this.mLastZoomState = 0;
                return true;
            }
        }
        return super.onKeyUp(keyCode, event, true);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int arg0, KeyEvent arg1) {
        logI("onKeyDown() keyCode: " + arg0);
        switch (arg0) {
            case 3:
                logI("onKeyDown: KEYCODE_HOME");
                if (!this.mIsOutGoingCall) {
                    receiveCall();
                    return true;
                }
                break;
            case 26:
                logI("onKeyDown: KEYCODE_POWER");
                if (arg1.isLongPress()) {
                    this.mIsPowerLongPressed = true;
                    break;
                } else if (!this.mIsPowerLongPressed) {
                    this.mCallBtnLayout.endCall();
                    return true;
                }
                break;
            case 27:
                logI("onKeyDown: KEYCODE_CAMERA");
                if (ModelInfoUtil.IS_MODEL_SCAMERA) {
                    logI("onKeyDown: KEYCODE_CAMERA");
                    return true;
                }
                break;
            case 168:
                if (ModelInfoUtil.IS_MODEL_SCAMERA) {
                    if (arg1.getScanCode() == 533) {
                        if (this.mLastZoomState == 1) {
                            return true;
                        }
                        if (!this.mWaitFocus) {
                            setCameraZoomAction(1);
                        }
                        this.mLastZoomState = 1;
                        return true;
                    }
                    if (arg1.getScanCode() != 545 || this.mLastZoomState == 3) {
                        return true;
                    }
                    if (!this.mWaitFocus) {
                        setCameraZoomAction(3);
                    }
                    this.mLastZoomState = 3;
                    return true;
                }
                break;
            case 169:
                if (ModelInfoUtil.IS_MODEL_SCAMERA) {
                    if (arg1.getScanCode() == 534) {
                        if (this.mLastZoomState == 2) {
                            return true;
                        }
                        if (!this.mWaitFocus) {
                            setCameraZoomAction(2);
                        }
                        this.mLastZoomState = 2;
                        return true;
                    }
                    if (arg1.getScanCode() != 546 || this.mLastZoomState == 4) {
                        return true;
                    }
                    if (!this.mWaitFocus) {
                        setCameraZoomAction(4);
                    }
                    this.mLastZoomState = 4;
                    return true;
                }
                break;
        }
        return super.onKeyDown(arg0, arg1, true);
    }

    public void setSCameraReceiveFileLayout() {
        this.mSCameraSendFileLayout.setVisibility(0);
        changeBottomButtonPosition();
        this.mSendButton.setVisibility(0);
        this.mCancelButton.setVisibility(0);
        this.mSCameraTextView.setText(getResources().getString(C0000R.string.scamera_receive_files, Integer.valueOf(this.mRecvImageList.size())));
        Iterator<String> it = this.mRecvImageList.iterator();
        while (it.hasNext()) {
            String str = it.next();
            logI("#########fileName = " + str);
        }
        if (this.mCapturedImageList == null) {
            logI("$$$$$$ mCapturedImageList is null");
        }
        for (int i = 0; i < this.mRecvImageList.size(); i++) {
            if (this.mCapturedImageList != null && this.mCapturedImageList.isEmpty()) {
                this.mCapturedImageList.add((ImageView) findViewById(C0000R.id.scamera_captured_img1));
                this.mCapturedImageList.add((ImageView) findViewById(C0000R.id.scamera_captured_img2));
                this.mCapturedImageList.add((ImageView) findViewById(C0000R.id.scamera_captured_img3));
            }
            Bitmap bitmap = getImage(this.mRecvImageList.get(i));
            if (bitmap == null) {
                logI("$$$$$$ getImageFail i = " + i + ", mRecvImageList.get(i) = " + this.mRecvImageList.get(i));
                Toast.makeText(this, getResources().getString(C0000R.string.scamera_fail_to_receive_file, Integer.valueOf(i)), 1000).show();
                return;
            } else {
                ((LinearLayout) this.mCapturedImageList.get(i).getParent()).setVisibility(0);
                this.mCapturedImageList.get(i).setImageBitmap(bitmap);
            }
        }
        this.mSendButton.setText(getResources().getString(C0000R.string.cancel));
        this.mSendButton.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                LiveShareViewActivity.this.logI("CancelButton!!!!");
                LiveShareViewActivity.this.mSCameraSendFileLayout.setVisibility(8);
                LiveShareViewActivity.this.changeBottomButtonPosition();
                Iterator it2 = LiveShareViewActivity.this.mCapturedImageList.iterator();
                while (it2.hasNext()) {
                    ImageView view = (ImageView) it2.next();
                    ((LinearLayout) view.getParent()).setVisibility(8);
                }
                for (int i2 = 0; i2 < LiveShareViewActivity.this.mRecvImageList.size(); i2++) {
                    File file = new File((String) LiveShareViewActivity.this.mRecvImageList.get(i2));
                    file.delete();
                }
                LiveShareViewActivity.this.mInnerHandler.sendEmptyMessageDelayed(LiveShareViewActivity.SCAMERA_SEND_DONE, 1000L);
            }
        });
        this.mCancelButton.setText(getResources().getString(C0000R.string.ok));
        this.mCancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                LiveShareViewActivity.this.mSCameraTextView.setText(LiveShareViewActivity.this.getResources().getString(C0000R.string.scamera_saving_files));
                LiveShareViewActivity.this.mSendButton.setVisibility(8);
                LiveShareViewActivity.this.mCancelButton.setVisibility(8);
                LiveShareViewActivity.this.mSCameraSendingFileAnimation.setVisibility(0);
                LiveShareViewActivity.this.mFrameAnimation.start();
                for (int i2 = 0; i2 < LiveShareViewActivity.this.mRecvImageList.size(); i2++) {
                    LiveShareViewActivity.this.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File((String) LiveShareViewActivity.this.mRecvImageList.get(i2)))));
                }
                LiveShareViewActivity.this.mInnerHandler.sendEmptyMessageDelayed(LiveShareViewActivity.SCAMERA_SAVE_DONE, 2000L);
                LiveShareViewActivity.this.mIsReceivingFile = false;
            }
        });
    }

    public Bitmap getFullScreenImage(String filePath) {
        Bitmap img;
        logI("getFullScreenImage");
        if (filePath == null || filePath.isEmpty()) {
            logI("-- getFullScreenImage filePath error");
            return null;
        }
        try {
            BitmapFactory.Options sizeOpt = new BitmapFactory.Options();
            sizeOpt.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(filePath, sizeOpt);
            int width = sizeOpt.outWidth;
            int height = sizeOpt.outHeight;
            int scaleWidth = width / (this.mDisplayWidth / 4);
            int scaleHeight = height / (this.mDisplayHeight / 4);
            int rate = 1;
            if (scaleWidth > 1 || scaleHeight > 1) {
                rate = scaleWidth < scaleHeight ? scaleWidth : scaleHeight;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = rate;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inPurgeable = true;
            options.inDither = true;
            img = BitmapFactory.decodeFile(filePath, options);
        } catch (Exception e) {
            img = null;
            e.printStackTrace();
            logE("getFullScreenImage err = " + e.getMessage());
        }
        logI("-- getFullScreenImage img = " + img);
        return img;
    }

    public void setSCameraSendFileLayout() throws Resources.NotFoundException {
        Bitmap bitmap = getImage(this.mCaptureMyImageFileName);
        Bitmap bitmap_full = getFullScreenImage(this.mCaptureMyImageFileName);
        if (bitmap == null || bitmap_full == null) {
            Toast.makeText(this, getResources().getString(C0000R.string.scamera_fail_to_take_picture), 1000).show();
            return;
        }
        sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(this.mCaptureMyImageFileName))));
        this.mSCameraSendFileLayout.setVisibility(0);
        changeBottomButtonPosition();
        this.mSendButton.setVisibility(0);
        this.mCancelButton.setVisibility(0);
        if (this.mCapturedImageList != null && this.mCapturedImageList.isEmpty()) {
            this.mCapturedImageList.add((ImageView) findViewById(C0000R.id.scamera_captured_img1));
            this.mCapturedImageList.add((ImageView) findViewById(C0000R.id.scamera_captured_img2));
            this.mCapturedImageList.add((ImageView) findViewById(C0000R.id.scamera_captured_img3));
            final ImageView view = this.mCapturedImageList.get(this.mCurrentCapturedImgCnt);
            ((LinearLayout) view.getParent()).setVisibility(0);
            switch (this.mCurrentCapturedImgCnt) {
                case 0:
                    this.mSCameraTextView.setText(getResources().getString(C0000R.string.scamera_send_file, this.mCalluserInfo.userName));
                    this.sCameraSendFileList.add(this.mCaptureMyImageFileName);
                    logI("############### bitmap = " + bitmap);
                    view.setImageBitmap(bitmap);
                    break;
                case 1:
                    this.mSCameraTextView.setText(getResources().getString(C0000R.string.scamera_send_files, Integer.valueOf(this.mCurrentCapturedImgCnt + 1), this.mCalluserInfo.userName));
                    this.sCameraSendFileList.add(this.mCaptureMyImageFileName);
                    view.setImageBitmap(bitmap);
                    break;
                case 2:
                    this.mSCameraTextView.setText(getResources().getString(C0000R.string.scamera_send_files, Integer.valueOf(this.mCurrentCapturedImgCnt + 1), this.mCalluserInfo.userName));
                    this.sCameraSendFileList.add(this.mCaptureMyImageFileName);
                    view.setImageBitmap(bitmap);
                    break;
            }
            view.setVisibility(4);
            this.mCurrentCapturedImgCnt++;
            this.mSendButton.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    LiveShareViewActivity.this.logI("SendButton!!!!");
                    LiveShareViewActivity.this.mIsSendingFile = true;
                    LiveShareViewActivity.this.startFileTransfer(LiveShareViewActivity.this.sCameraSendFileList);
                }
            });
            this.mCancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    LiveShareViewActivity.this.logI("CancelButton!!!!");
                    LiveShareViewActivity.this.mSCameraSendFileLayout.setVisibility(8);
                    LiveShareViewActivity.this.changeBottomButtonPosition();
                    Iterator it = LiveShareViewActivity.this.mCapturedImageList.iterator();
                    while (it.hasNext()) {
                        ImageView view2 = (ImageView) it.next();
                        ((LinearLayout) view2.getParent()).setVisibility(8);
                    }
                    LiveShareViewActivity.this.mCurrentCapturedImgCnt = 0;
                    LiveShareViewActivity.this.sCameraSendFileList.clear();
                    LiveShareViewActivity.this.mCapturedImageList.clear();
                }
            });
            this.mImageView_animated.setImageBitmap(bitmap_full);
            this.mImageView_animated.setVisibility(0);
            Animation scale_anim = AnimationUtils.loadAnimation(this.mImageView_animated.getContext(), C0000R.anim.scale_anim);
            Animation.AnimationListener al = new Animation.AnimationListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.7
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation arg0) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation arg0) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation arg0) {
                    LiveShareViewActivity.this.mImageView_animated.setVisibility(8);
                    if (view != null) {
                        view.setVisibility(0);
                    }
                }
            };
            scale_anim.setAnimationListener(al);
            this.mImageView_animated.startAnimation(scale_anim);
        }
    }

    private class OrientationHandler extends OrientationEventListener implements DisposeInterface {
        private boolean bDisposed;

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            this.bDisposed = true;
        }

        public OrientationHandler(Context context) {
            super(context);
            this.bDisposed = false;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int _orientation) {
            if (!this.bDisposed && LiveShareViewActivity.this.mUseVideo && !CallState.isDisconnected(LiveShareViewActivity.this.mCallState)) {
                LiveShareViewActivity.this.logI("OrientationHandler onOrientationChanged(" + _orientation + ")");
                int orientation = _orientation;
                if (orientation == -1) {
                    LiveShareViewActivity.this.logI("ORIENTATION_UNKNOWN");
                    orientation = LiveShareViewActivity.this.getSystemBarOrientation();
                }
                LiveShareViewActivity.this.mInstantOrientation = LiveShareViewActivity.this.get45UnitAngleFromFullAngle(orientation);
                LiveShareViewActivity.this.logI("mInstantAngle: " + LiveShareViewActivity.this.mInstantOrientation);
                LiveShareViewActivity.this.orientHandling(orientation);
            }
        }
    }

    private int get30UnitAngleFromFullAngle(int angle) {
        int rotation = 0;
        if (this.mSavedOrientation == 0 || this.mSavedOrientation == 360) {
            if (angle < 60 || angle > 300) {
                rotation = 0;
            } else if (angle < 60 || angle >= 135) {
                rotation = (angle > 300 || angle <= 225) ? EngineCallBackInterface.SIP_RINGTONE_NONE : InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MIDDLE_ALIGN_EVENT;
            } else {
                rotation = 90;
            }
        } else if (this.mSavedOrientation == 90) {
            if (angle > 30 && angle < 150) {
                rotation = 90;
            } else if (angle < 150 || angle >= 225) {
                rotation = (angle <= 30 || angle > 315) ? 0 : InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MIDDLE_ALIGN_EVENT;
            } else {
                rotation = EngineCallBackInterface.SIP_RINGTONE_NONE;
            }
        } else if (this.mSavedOrientation == 180) {
            if (angle > 120 && angle < 240) {
                rotation = EngineCallBackInterface.SIP_RINGTONE_NONE;
            } else if (angle < 240 || angle >= 315) {
                rotation = (angle > 120 || angle <= 45) ? 0 : 90;
            } else {
                rotation = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MIDDLE_ALIGN_EVENT;
            }
        } else if (this.mSavedOrientation == 270) {
            if (angle > 210 && angle < 330) {
                rotation = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MIDDLE_ALIGN_EVENT;
            } else if (angle > 210 || angle <= 135) {
                rotation = (angle >= 330 || angle < 45) ? 0 : 90;
            } else {
                rotation = EngineCallBackInterface.SIP_RINGTONE_NONE;
            }
        }
        logI("get30UnitAngleFromFullAngle() mSavedOrientation: " + this.mSavedOrientation + " new: " + angle + " return: " + rotation);
        return rotation;
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public void orientHandling(int orientation) {
        int newAngle = get30UnitAngleFromFullAngle(orientation);
        if (this.mActivityStatus == 3 || this.mActivityStatus == 5) {
            if (newAngle != this.mSavedOrientation) {
                logI("orientHandling() " + this.mSavedOrientation + "(" + this.mSavedOrientation + ") >> " + orientation + "(" + newAngle + ")");
                this.mSavedOrientation = newAngle;
                sendRotationInfoToServerDirectly(this.mSavedOrientation, false);
                this.mIsInitAngle = false;
                return;
            }
            return;
        }
        if (!this.mIsInitAngle || newAngle != this.mSavedOrientation) {
            logI("orientHandling() " + this.mSavedOrientation + "(" + this.mSavedOrientation + ") >> " + orientation + "(" + newAngle + ")");
            this.mSavedOrientation = newAngle;
            this.mIsInitAngle = true;
            setHideMeOrientation();
            if (isConference()) {
                setSECOrientation(this.mRemoteRotation, true);
                return;
            }
            if (this.mChanagePreview) {
                changedRemoteLayout(false);
                setSECPreViewOrientation(this.mRemoteRotation, true);
            } else {
                setSECOrientation(this.mRemoteRotation, true);
            }
            updateShareViewZoomLayoutRotation();
        }
    }

    private void sendRotationInfoToServer(int angle, boolean isLayoutChanged) {
        if (this.mIsInitAngle) {
            logI("sendRotationInfoToServer() " + angle);
            sendRotationInfoToServerDirectly(angle, isLayoutChanged);
        } else {
            sendRotationInfoToServer();
        }
    }

    private void sendRotationInfoToServerDirectly(int angle, boolean isLayoutChanged) {
        boolean autoRotation = isAutorotationActive();
        int systembarAngle = getSystemBarOrientation();
        if (autoRotation && angle != 180) {
            systembarAngle = angle;
        }
        int degree = (systembarAngle << 16) | angle;
        logI("sendRotationInfoToServerDirectly() " + angle);
        logI("deviceAngle: " + angle);
        logI("systembarAngle: " + systembarAngle);
        logI("degree: " + degree);
        logI("is auto-rotation: " + autoRotation);
        Date current = new Date();
        boolean isChanged = isLayoutChanged;
        if (current.getTime() - mLastOrientationChangeDate.getTime() < 1000) {
            isChanged = false;
        }
        if (isChanged) {
            mLastOrientationChangeDate = current;
        }
        logI("is resized: " + isChanged);
        if (this.mShareViewCtrl.isActive() && this.mShareViewCtrl.isFullScreen()) {
            isChanged = false;
        }
        MainApplication.mPhoneManager.getPhoneStateMachine().sendRotationInfo(this.mDestination, degree, autoRotation, isChanged);
    }

    private void sendRotationInfoToServer() {
        boolean autoRotation = isAutorotationActive();
        int systembarAngle = getSystemBarOrientation();
        int degree = (systembarAngle << 16) | systembarAngle;
        logI("sendRotationInfoToServer() - init");
        logI("deviceAngle: " + systembarAngle);
        logI("systembarAngle: " + systembarAngle);
        logI("degree: " + degree);
        logI("is auto-rotation: " + autoRotation);
        MainApplication.mPhoneManager.getPhoneStateMachine().sendRotationInfo(this.mDestination, degree, autoRotation, false);
    }

    private boolean isLandscapeFromAngle(int angle) {
        boolean isLandscape;
        logI("isLandscapeFromAngle(" + angle + ")");
        if (angle < 45 || angle > 315) {
            isLandscape = false;
        } else if ((angle < 45 || angle >= 135) && angle >= 135 && angle < 225) {
            isLandscape = false;
        } else {
            isLandscape = true;
        }
        logI("isLandscapeFromAngle(" + angle + ") return: " + isLandscape);
        return isLandscape;
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public int getSystemBarOrientation() {
        if (this.display == null) {
            this.display = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        }
        int rotation = ((4 - this.display.getRotation()) % 4) * 90;
        logI("getSystemBarOrientation() return: " + rotation);
        return rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int get45UnitAngleFromFullAngle(int angle) {
        int rotation;
        if (angle < 45 || angle > 315) {
            rotation = 0;
        } else if (angle < 45 || angle >= 135) {
            rotation = (angle < 135 || angle >= 225) ? InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MIDDLE_ALIGN_EVENT : EngineCallBackInterface.SIP_RINGTONE_NONE;
        } else {
            rotation = 90;
        }
        logI("get45UnitAngleFromFullAngle() input: " + angle + " return: " + rotation);
        return rotation;
    }

    private void setHideMeOrientation() {
        if (this.mUseAlterImage) {
            logI("setHideMeOrientation()");
            if (isDefaultHideMeImage()) {
                this.mDefaultHideImg = null;
                makeHideMeImage();
            }
        }
    }

    private void setSECPreviewPosition(boolean paddingOff) {
        logI("setSECPreviewPosition() : paddingOff " + paddingOff);
        int height = this.mPreviewHeight;
        int width = this.mPreviewWidth;
        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mSurfaceViewlayout.getLayoutParams();
        if (getResources().getConfiguration().orientation == 1) {
            param.width = width;
            param.height = height;
            param.gravity = 51;
            param.setMargins(this.mImgPoint.x, this.mImgPoint.y, this.mPreviewPaddingRight, this.mPrviewPaddingButton);
        } else {
            param.width = height;
            param.height = width;
            param.gravity = 51;
            param.rightMargin = this.mLandPreviewPaddingRight;
            param.setMargins(this.mImgPoint.x, this.mImgPoint.y, this.mLandPreviewPaddingRight, this.mLandPrviewPaddingButton);
        }
        logI("<<YHT101>>---------- setSECPreviewPosition: " + this.mChanagePreview + " paddingOff: " + paddingOff);
        this.mSurfaceViewlayout.setLayoutParams(param);
        if (paddingOff) {
            if (this.mChanagePreview) {
                setViewGuideLineStatus(2, 1);
                return;
            } else {
                setViewGuideLineStatus(2, 0);
                return;
            }
        }
        setPreViewWhiteOutLine();
    }

    private void setSECPreViewOrientation(int remoteRotation, boolean isSelf) {
        boolean isChanged;
        logI("setSECPreViewOrientation() : mSavedOrientation " + this.mSavedOrientation + " remoteRotation: " + remoteRotation + "isSelf: " + isSelf);
        if (!isConference()) {
            this.mIsTabDevice = this.mModelInfo.isTabDevice();
            int orientationChanged = (remoteRotation - this.mSavedOrientation) % EngineCallBackInterface.SIP_RINGTONE_NONE;
            logI("orientationChanged: " + orientationChanged);
            if (orientationChanged == 0) {
                isChanged = this.mIsTabDevice ? changedPreviewLayout(false) : changedPreviewLayout(true);
            } else {
                isChanged = this.mIsTabDevice ? changedPreviewLayout(true) : changedPreviewLayout(false);
            }
            if (isSelf) {
                sendRotationInfoToServer(this.mSavedOrientation, isChanged);
            }
        }
    }

    private void setSECOrientation(int remoteRotation, boolean isSelf) {
        boolean bChanged;
        logI("setSECOrientation() : mSavedOrientation " + this.mSavedOrientation + " remoteRotation: " + remoteRotation + "isSelf: " + isSelf);
        if (isConference()) {
            initRemoteSerface();
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) this.mRemoteSurface.getLayoutParams();
            params.width = -1;
            params.height = -1;
            params.gravity = 119;
            params.topMargin = 0;
            if (getResources().getConfiguration().orientation == 1) {
                params.bottomMargin = this.mModelInfo.getPortPaddingBottom();
                params.rightMargin = 0;
            } else {
                params.bottomMargin = 0;
                params.rightMargin = 0;
            }
            this.mRemoteSurface.setLayoutParams(params);
            if (isSelf) {
                sendRotationInfoToServer(this.mSavedOrientation, false);
                return;
            }
            return;
        }
        this.mIsTabDevice = this.mModelInfo.isTabDevice();
        int orientationChanged = (remoteRotation - this.mSavedOrientation) % EngineCallBackInterface.SIP_RINGTONE_NONE;
        logI("orientationChanged: " + orientationChanged);
        if (orientationChanged == 0) {
            bChanged = this.mIsTabDevice ? changedRemoteLayout(false) : changedRemoteLayout(true);
        } else {
            bChanged = this.mIsTabDevice ? changedRemoteLayout(true) : changedRemoteLayout(false);
        }
        if (isSelf) {
            sendRotationInfoToServer(this.mSavedOrientation, bChanged);
        }
        updateShareViewZoomLayoutRotation();
    }

    private void initRemoteSerface() {
        if (this.mRemoteSurface == null) {
            this.mRemoteSurface = (SurfaceView) findViewById(C0000R.id.omx_video_view);
            this.mRemoteHolder = this.mRemoteSurface.getHolder();
            this.mRemoteHolder.addCallback(this);
            this.mRemoteHolder.setType(3);
        }
    }

    private boolean changedRemoteLayout(boolean changed) {
        logI("changedRemoteLayout() : changed " + changed);
        this.mIsOtherPartyLandscapeMode = changed;
        initRemoteSerface();
        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mRemoteSurface.getLayoutParams();
        int oldTopMargin = param.topMargin;
        int oldBottomMargin = param.bottomMargin;
        int oldLeftMargin = param.leftMargin;
        int oldRightMargin = param.rightMargin;
        param.width = -1;
        param.height = -1;
        if (changed) {
            if (getResources().getConfiguration().orientation == 1) {
                param.gravity = 49;
                param.topMargin = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MIDDLE_ALIGN_EVENT;
                param.bottomMargin = this.mPreviewMarginButtom + 150;
                if (this.mDeviceType == 4) {
                    param.topMargin = EngineCallBackInterface.SIP_RINGTONE_NONE;
                    param.bottomMargin = this.mPreviewMarginButtom + 100;
                } else if (this.mDeviceType == 2) {
                    param.topMargin = 223;
                    param.bottomMargin = this.mPreviewMarginButtom + SCAMERA_SEND_DONE;
                } else if (this.mDeviceType == 1) {
                    param.topMargin = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_CARET_UP_EVENT;
                    param.bottomMargin = this.mPreviewMarginButtom + 190;
                } else if (this.mDeviceType == 5) {
                    param.topMargin = ScreenSharePacket.SCREEN_SHARE_CMD_CHNAGE_REMOTE_RESP_MODE;
                    param.bottomMargin = this.mPreviewMarginButtom + InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_EDIT_COPY_EVENT;
                }
            } else {
                param.gravity = 49;
                param.leftMargin = 196;
                param.rightMargin = 196;
                if (this.mDeviceType == 4) {
                    param.leftMargin = 140;
                    param.rightMargin = 140;
                } else if (this.mDeviceType == 2) {
                    param.leftMargin = 159;
                    param.rightMargin = 160;
                } else if (this.mDeviceType == 1) {
                    param.leftMargin = 200;
                    param.rightMargin = 200;
                } else if (this.mDeviceType == 5) {
                    param.leftMargin = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_OBJECT_ATT_EVENT;
                    param.rightMargin = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_OBJECT_ATT_EVENT;
                }
                param.bottomMargin = this.mLandRemoteViewMarginButtom;
            }
        } else {
            param.gravity = 119;
            param.topMargin = 0;
            param.leftMargin = 0;
            param.rightMargin = 0;
            if (getResources().getConfiguration().orientation == 1) {
                param.bottomMargin = this.mPreviewMarginButtom;
            } else {
                param.bottomMargin = this.mLandRemoteViewMarginButtom;
            }
        }
        boolean isChanged = true;
        if (oldTopMargin == param.topMargin && oldBottomMargin == param.bottomMargin && oldLeftMargin == param.leftMargin && oldRightMargin == param.rightMargin) {
            isChanged = false;
        }
        this.mRemoteSurface.setLayoutParams(param);
        return isChanged;
    }

    private boolean changedPreviewLayout(boolean changed) {
        logI("changedPreviewLayout() changed: " + changed);
        switchPreviewPosition(changed);
        if (this.mChangePreviewRotation != changed && this.mIsOtherCapture) {
            finishCaptureImgShow();
        }
        if (!this.mReturnPreview) {
            switchAutoModePreviewPosition();
        }
        setSurfaceViewLayout();
        if (this.mMyImageOnly) {
            gonePreviewLayout();
        }
        if (this.mSurface == null) {
            this.mSurface = (SurfaceView) findViewById(C0000R.id.surface_view);
            this.mHolder = this.mSurface.getHolder();
            this.mHolder.addCallback(this);
            this.mHolder.setType(3);
        }
        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mSurface.getLayoutParams();
        int oldHeight = param.height;
        int oldWidth = param.width;
        int height = this.mPreviewHeight;
        int width = this.mPreviewWidth;
        if (getResources().getConfiguration().orientation == 1) {
            param.height = height;
            param.width = width;
            if (changed) {
                param.height = width;
                param.width = height;
            }
            param.gravity = 17;
        } else {
            param.height = width;
            param.width = height;
            if (changed) {
                param.height = height;
                param.width = width;
            }
            param.gravity = 17;
        }
        this.mSurface.setLayoutParams(param);
        this.mChangePreviewRotation = changed;
        this.mVideoRepositionView.setChangePointStatus(this.mImgPoint, changed, this.mDisplayWidth, this.mDisplayHeight);
        this.mReturnPreview = false;
        return (oldWidth == param.width && oldHeight == param.height) ? false : true;
    }

    private void setSurfaceViewLayout() {
        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mSurfaceViewlayout.getLayoutParams();
        if (getResources().getConfiguration().orientation == 1) {
            param.width = this.mPreviewWidth;
            param.height = this.mPreviewHeight;
            param.gravity = 51;
            param.setMargins(this.mImgPoint.x, this.mImgPoint.y, this.mPreviewPaddingRight, this.mPrviewPaddingButton);
        } else {
            param.width = this.mPreviewHeight;
            param.height = this.mPreviewWidth;
            param.gravity = 51;
            param.rightMargin = this.mLandPreviewPaddingRight;
            param.setMargins(this.mImgPoint.x, this.mImgPoint.y, this.mLandPreviewPaddingRight, this.mLandPrviewPaddingButton);
        }
        this.mSurfaceViewlayout.setLayoutParams(param);
    }

    private void switchPreviewPosition(boolean changed) {
        int outlineFullWidth;
        int outlineFullHeight;
        int titleHeight;
        logI("switchPreviewPosition()");
        if (this.mIsMovePreviewPosition) {
            if (getResources().getConfiguration().orientation == 1) {
                outlineFullWidth = this.mDisplayWidth;
                outlineFullHeight = (this.mDisplayHeight - this.mPreviewMarginButtom) - this.mStatusBarLength;
                titleHeight = this.mModelInfo.getPortRepositonTopMargin();
            } else {
                outlineFullWidth = this.mDisplayWidth - this.mLandPreviewPaddingRight;
                outlineFullHeight = this.mDisplayHeight;
                titleHeight = this.mModelInfo.getLandRepositonTopMargin();
            }
            if (getResources().getConfiguration().orientation == 1) {
                if (isAutorotationActive()) {
                    if (this.mPreviewHeight + this.mImgPoint.x > outlineFullWidth) {
                        this.mImgPoint.x = outlineFullWidth - this.mPreviewHeight;
                    } else if (this.mImgPoint.x - this.mHWGap < 0) {
                        this.mImgPoint.x = this.mHWGap;
                    }
                    if (this.mImgPoint.y < titleHeight) {
                        this.mImgPoint.y = titleHeight;
                        return;
                    } else {
                        if (this.mImgPoint.y + this.mPreviewHeight > outlineFullHeight) {
                            this.mImgPoint.y = outlineFullHeight - this.mPreviewHeight;
                            return;
                        }
                        return;
                    }
                }
                if (this.mPreviewHeight + this.mImgPoint.x > outlineFullWidth) {
                    this.mImgPoint.x = outlineFullWidth - this.mPreviewHeight;
                } else if (this.mImgPoint.x - this.mHWGap < 0) {
                    this.mImgPoint.x = this.mHWGap;
                }
                if (this.mImgPoint.y < titleHeight) {
                    this.mImgPoint.y = titleHeight;
                    return;
                } else {
                    if (this.mImgPoint.y + this.mPreviewHeight > outlineFullHeight) {
                        this.mImgPoint.y = outlineFullHeight - this.mPreviewHeight;
                        return;
                    }
                    return;
                }
            }
            if (this.mPreviewWidth + this.mImgPoint.y > outlineFullHeight) {
                this.mImgPoint.y = outlineFullHeight - this.mPreviewWidth;
                return;
            } else {
                if (this.mImgPoint.y - this.mHWGap < titleHeight) {
                    this.mImgPoint.y = this.mHWGap + titleHeight;
                    return;
                }
                return;
            }
        }
        if (changed) {
            if (getResources().getConfiguration().orientation == 1) {
                this.mImgPoint = new Point(this.mPreviewPaddigLeft + this.mHWGap, this.mPreViewPaddingTop + this.mHWGap);
                return;
            } else {
                this.mImgPoint = new Point(this.mLandPreviewPaddigLeft + this.mHWGap, this.mLandPreViewPaddingTop - this.mHWGap);
                return;
            }
        }
        if (getResources().getConfiguration().orientation == 1) {
            this.mImgPoint = new Point(this.mPreviewPaddigLeft, this.mPreViewPaddingTop);
        } else {
            this.mImgPoint = new Point(this.mLandPreviewPaddigLeft, this.mLandPreViewPaddingTop);
        }
    }

    private void switchAutoModePreviewPosition() {
        logI("switchAutoModePreviewPosition()");
        if (getResources().getConfiguration().orientation == 1) {
            int i = this.mDisplayWidth;
            int outlineFullHeight = (this.mDisplayHeight - this.mPreviewMarginButtom) - this.mStatusBarLength;
            int titleHeight = this.mModelInfo.getPortRepositonTopMargin();
            if (this.mImgPoint.y < titleHeight) {
                this.mImgPoint.y = titleHeight;
                return;
            } else {
                if (this.mImgPoint.y + this.mPreviewHeight > outlineFullHeight) {
                    this.mImgPoint.y = outlineFullHeight - this.mPreviewHeight;
                    return;
                }
                return;
            }
        }
        int outlineFullWidth = this.mDisplayWidth - this.mLandPreviewPaddingRight;
        int i2 = this.mDisplayHeight;
        this.mModelInfo.getLandRepositonTopMargin();
        if (this.mImgPoint.x < 0) {
            this.mImgPoint.x = 0;
        } else if (this.mImgPoint.x + this.mPreviewHeight > outlineFullWidth) {
            this.mImgPoint.x = outlineFullWidth - this.mPreviewHeight;
        }
    }

    private void getScreenSize() {
        if (this.mIsOutGoingCall && ModelInfoUtil.IS_MODEL_SCAMERA) {
            this.mDisplayWidth = 1280;
            this.mDisplayHeight = 720;
        } else {
            this.mDisplayWidth = getWindowManager().getDefaultDisplay().getWidth();
            this.mDisplayHeight = getWindowManager().getDefaultDisplay().getHeight();
        }
        logI("getScreenSize() width: " + this.mDisplayWidth + " height: " + this.mDisplayHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCameraForVideoCall() {
        logI("removeCameraForVideoCall()");
        Message msg = new Message();
        msg.what = EventCode.EVENT_CALL_CAMERA_VIDEOCALL;
        sendHandlerMessage(msg, 200L);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void toggleCamera() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCameraForToggle() {
        Message msg = new Message();
        msg.what = EventCode.EVENT_CALL_CAMERA_TOGGLE;
        sendHandlerMessage(msg, 200L);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        if (!this.mIsQuickEndCall) {
            logI("surfaceCreated()");
            if (this.mChanagePreview) {
                if (this.mRemoteHolder != null && this.mRemoteHolder.equals(holder)) {
                    SECConfig.setVideoSurfaceData(0, holder.getSurface());
                    return;
                } else {
                    if (this.mHolder != null && this.mHolder.equals(holder)) {
                        SECConfig.setVideoSurfaceData(1, holder.getSurface());
                        return;
                    }
                    return;
                }
            }
            if (this.mHolder != null && this.mHolder.equals(holder)) {
                SECConfig.setVideoSurfaceData(0, holder.getSurface());
            } else if (this.mRemoteHolder != null && this.mRemoteHolder.equals(holder)) {
                SECConfig.setVideoSurfaceData(1, holder.getSurface());
            }
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        logI("surfaceDestroyed()");
        if (!this.mSurfaceDestroyed) {
            if (this.mChanagePreview) {
                if (this.mHolder != null && this.mHolder.equals(holder)) {
                    SECConfig.setVideoSurfaceData(1, null);
                    return;
                } else {
                    if (this.mRemoteHolder != null && this.mRemoteHolder.equals(holder)) {
                        SECConfig.setVideoSurfaceData(0, null);
                        return;
                    }
                    return;
                }
            }
            if (this.mHolder != null && this.mHolder.equals(holder)) {
                SECConfig.setVideoSurfaceData(0, null);
            } else if (this.mRemoteHolder != null && this.mRemoteHolder.equals(holder)) {
                SECConfig.setVideoSurfaceData(1, null);
            }
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void showDialPad(boolean showPad) {
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    protected int calculateDuration() {
        return (int) this.mVideoCallStatusBar.getElapsedTimeInMilisec();
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void denyCall() {
        logI("denyCall()");
        if (!this.mAlreadyDenied) {
            this.mAlreadyDenied = true;
            MainApplication.mPhoneManager.getPhoneStateMachine().setCallingActivity(null);
            immediatelyQuitWithoutAnimation();
            cancelSpeakerphone();
            this.mAutoReceiveCnt = false;
            new Thread(new Runnable() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    MainApplication.mPhoneManager.getPhoneStateMachine().connectCall(LiveShareViewActivity.this.mDestination, LiveShareViewActivity.this.mCallID, false, 100, MainApplication.mConfig.isSecureCommunication(), "");
                }
            }).start();
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void denyCallwithRejectMsg(final int hangupCode, final String hangupMsg) {
        logI("denyCallwithRejectMsg() hangupCode: " + hangupCode + " hangupMsg: " + hangupMsg);
        if (!this.mAlreadyDenied && hangupCode != -1) {
            this.mAlreadyDenied = true;
            MainApplication.mPhoneManager.getPhoneStateMachine().setCallingActivity(null);
            immediatelyQuitWithoutAnimation();
            cancelSpeakerphone();
            new Thread(new Runnable() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    MainApplication.mPhoneManager.getPhoneStateMachine().connectCall(LiveShareViewActivity.this.mDestination, LiveShareViewActivity.this.mCallID, false, hangupCode, MainApplication.mConfig.isSecureCommunication(), hangupMsg);
                }
            }).start();
        }
    }

    private void immediatelyQuitWithoutAnimation() {
        cancelDelayedQuit();
        this.mIsNormalTerminatingProcess = true;
        finish();
        if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void hangupCall() {
        logI("hangupCall()");
        synchronized (this.hangupMutex) {
            new Thread(new Runnable() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    if (MainApplication.mPhoneManager.getPhoneStateMachine().localHangupCall(LiveShareViewActivity.this.mDestination, 10) == -1012) {
                        Message msg = new Message();
                        msg.what = EventCode.EVENT_CALL_ACTION;
                        LiveShareViewActivity.this.sendHandlerMessage(msg, 0L);
                    }
                }
            }).start();
        }
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.setHangUpButtonToggle(false);
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public void hangupCallWithQuickDestroy(String msg) {
        logI("hangupCallWithQuickDestroy(" + msg + ")");
        showToast(msg);
        this.mIsQuickEndCall = true;
        synchronized (this.hangupMutex) {
            new Thread(new Runnable() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.11
                @Override // java.lang.Runnable
                public void run() {
                    if (MainApplication.mPhoneManager.getPhoneStateMachine().localHangupCall(LiveShareViewActivity.this.mDestination, 10) == -1012) {
                        LiveShareViewActivity.this.quitActivity();
                    }
                }
            }).start();
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public void videoCallEndUIDisplaybeforeCamrelease() {
        logI("videoCallEndUIDisplaybeforeCamrelease()");
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        dismissVideoDialog();
        if (this.mRecordTimer) {
            this.mRecordTime.stop();
            this.mRecordTimer = false;
        }
        if (!this.mIsOutGoingCall) {
            this.mCallEndBtnLayout.setData(this.mDestination, this, this.mCalluserInfo.userNo);
            this.mCallOutgoingCallLayout.setTimeData(this.mVideoCallStatusBar.getElapsedTime(), this.mCountConnectedState);
            this.mCallOutgoingCallLayout.setVisibility(0);
        }
        this.mVideolayout.setVisibility(8);
        this.mVideoRepositionView.setVisibility(8);
        this.mCallInfoLayout.setVisibility(8);
        this.mCallInfoBGLayout.setVisibility(8);
        this.mCallOutgoingCallLayout.setVisibility(8);
        this.mCallBtnLayout.setVisibility(8);
        this.mCallReceiveBtnLayout.setVisibility(8);
        if (!this.mIsOutGoingCall) {
            this.mInnerHandler.sendEmptyMessageDelayed(1, 1300L);
        }
        if (MainApplication.mPhoneManager.getHardwareManager().getSoundManager().isSpeakerOn(MainApplication.mContext)) {
            disableSpeakerCall();
        }
        closeOptionsMenu();
        notiToUserDisconnectedInActivity();
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void receiveCall() {
        logI("receiveCall()");
        this.mAutoReceiveCnt = false;
        cacelReceiveCall();
        int retVal = MainApplication.mPhoneManager.getPhoneStateMachine().connectCall(this.mDestination, this.mCallID, true, 10, MainApplication.mConfig.isSecureCommunication(), "");
        if (retVal != 0) {
            Message msg = new Message();
            msg.what = EventCode.EVENT_CALL_ACTION;
            sendHandlerMessage(msg, 0L);
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity
    public void setOptionMenu(int menuId) {
        logI("setOptionMenu()");
        if (isChangeToConference()) {
            showToast(C0000R.string.change_to_conference_wait);
            logE("WAIT: change to conference");
        }
        this.mShowOptionMenu = false;
        if (checkOptionMenuDisable(menuId)) {
            invalidateOptionsMenu();
            return;
        }
        switch (menuId) {
            case 1:
                logI("MENU_HIDE_ME");
                setAlterImage();
                invalidateOptionsMenu();
                break;
            case 2:
                changeLayoutPreviewSingleTab();
                break;
            case 3:
                logI("OPT_INVITE_BUDDIES");
                sendSelectedListIntent(1, 2);
                invalidateOptionsMenu();
                break;
            case 4:
                logI("MENU_SPEAKER_PHONE");
                this.mAudioPathController.onClickSpeakerButton();
                invalidateOptionsMenu();
                break;
            case 5:
                logI("MENU_SWITCH_HEADSET");
                if (this.mAudioPathController.onClickBlueToothButton()) {
                    gotoBlueToothSettingPage();
                }
                invalidateOptionsMenu();
                break;
            case 6:
                boolean isGroup = false;
                if (this.mDestination.getDestinationType() == 4) {
                    isGroup = true;
                }
                if (isGroup && this.mDestinationUtil.getConferenceConnectCount(this.mDestination) == 0) {
                    showToast(C0000R.string.call_switching_to_video_no_member);
                    invalidateOptionsMenu();
                    break;
                } else if (this.mDestinationUtil.getConferenceWaitCount(this.mDestination) > 0) {
                    showToast(C0000R.string.call_switching_to_voice_cannot_during_dialing);
                    invalidateOptionsMenu();
                    break;
                } else {
                    showCallConsentProcessingDialog(1, 1);
                    sendRequestConsent(1, 1);
                    invalidateOptionsMenu();
                    break;
                }
                break;
            case 7:
                showToast(C0000R.string.video_animated_emotioins_theme_view_info);
                displayEmotionalAnimation();
                invalidateOptionsMenu();
                break;
            case 8:
                showToast(C0000R.string.video_animated_emotioins_theme_view_info);
                displayThemeShot();
                invalidateOptionsMenu();
                break;
            case 9:
                logI("MENU_CARTOON_VIEW");
                displayCartoonView();
                invalidateOptionsMenu();
                break;
            case 11:
                logI("OPT_SHARE_CHATONV");
                this.mShareViewCtrl.setType(2);
                sendRequestConsent(2, 0);
                invalidateOptionsMenu();
                break;
            case 12:
                logI("OPT_MANAGE_CONFERENCE_CALL");
                startMemberView(this.mVideoCallStatusBar);
                invalidateOptionsMenu();
                break;
            case 13:
                if (this.mUseDualCamera) {
                    stopDualCamera();
                } else {
                    startDualCamera(10, 10, VLSpotterContext.DEFAULT_PHRASESPOT_PARAMB, ChatONHideMeImgData.IMAGE_DEFAULT_WIDTH);
                }
                invalidateOptionsMenu();
                break;
            case 16:
                changeAvatarOption();
                break;
            case 40:
                logI("MENU_send_via_chaton");
                isConference();
                invalidateOptionsMenu();
                break;
            case 42:
                invalidateOptionsMenu();
                break;
            case 43:
                logI("MENU_CHANGE_LAYOUT");
                showDialog(102);
                invalidateOptionsMenu();
                break;
        }
    }

    private void changeAvatarOption() {
        if (this.mUseAvatar) {
            MainApplication.mPhoneManager.getPhoneStateMachine().stopAvatar(this.mDestination);
        } else {
            MainApplication.mPhoneManager.getPhoneStateMachine().startAvatar(this.mDestination);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean checkOptionMenuDisable(int menuId) {
        logI("checkOptionMenuDisable()");
        if (!this.mOptionMenuData.isEnabledMenu(menuId)) {
            switch (menuId) {
                case 7:
                    if (this.mUseAlterImage) {
                        showToast(C0000R.string.video_call_option_enable_reason_cartoon_view);
                    } else {
                        showToast(C0000R.string.video_call_option_enable_reason_emotional_animation);
                    }
                    return true;
                case 8:
                    if (this.mUseAlterImage) {
                        showToast(C0000R.string.video_call_option_enable_reason_cartoon_view);
                    } else {
                        showToast(C0000R.string.video_call_option_enable_reason_theme_shot);
                    }
                    return true;
                case 9:
                    showToast(C0000R.string.video_call_option_enable_reason_cartoon_view);
                    return true;
                default:
                    return true;
            }
        }
        return false;
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        logI("onPrepareOptionsMenu()");
        logI("mMemberViewCtrl.ismMemberViewActive() : " + this.mMemberViewCtrl.ismMemberViewActive());
        if (this.mMemberViewCtrl.ismMemberViewActive() || !CallState.isConnected(this.mCallState)) {
            return false;
        }
        checkCallInstanceNRefresh();
        if (this.mOptionMenuData == null) {
            this.mOptionMenuData = new VideoOptionMenuData(this);
        }
        this.mOptionMenuData.loadMenu(this.mShareViewCtrl, this.mIsShareScreenWaitForAccepting, this.mCallFunctionController.isEnableConsentProcessing(), isConference(), this.mIsOutGoingCall, this.mDestinationUtil.getConferenceWaitCount(this.mDestination) > 0, false);
        this.mOptionMenuData.setAttribute(this.mUseAlterImage, this.mIsSpeaker, this.mIsBlueTooth, this.mUseDualCamera);
        this.mOptionMenuData.addToMenu(menu);
        OptionMenuLayout.setLayout(this);
        return super.onPrepareOptionsMenu(menu, true);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        logI("onOptionsItemSelected()");
        super.onOptionsItemSelected(item, true);
        setOptionMenu(item.getItemId());
        return false;
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity
    public void closeThemeShotEmotionalAnimation() {
        logI("closeThemeShotEmotionalAnimation()");
        this.mVideoCallOptionMenu.setVisibility(8);
        this.mAniThemeMenu = false;
        this.mIsThemeShotMenu = false;
    }

    private void displayEmotionalAnimation() {
        logI("displayEmotionalAnimation() ");
        this.mAniThemeMenu = true;
        this.mIsThemeShotMenu = false;
        this.mVideoCallOptionMenu.displayEmotionalAnimation();
        goneTopStatusBar();
        this.mVideoCallOptionMenu.setVisibility(0);
    }

    private void displayThemeShot() {
        logI("displayThemeShot()");
        this.mAniThemeMenu = true;
        this.mIsThemeShotMenu = true;
        this.mVideoCallOptionMenu.displayThemeShot();
        goneTopStatusBar();
        this.mVideoCallOptionMenu.setVisibility(0);
    }

    private void displayCartoonView() {
        logI("displayCartoonView() mIsCartoonView: " + this.mIsCartoonView);
        if (this.mIsCartoonView) {
            setCartoonView(-1);
            this.mIsCartoonView = false;
        } else {
            setCartoonView(0);
            this.mIsCartoonView = true;
        }
    }

    private void setRecord() {
        logI("setRecord()");
        if (this.mIsRecording) {
            stopRecordCall();
            this.mIsRecording = false;
        } else if (startRecordCall()) {
            this.mIsRecording = true;
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity
    public void setAlterImage() {
        logI("setAlterImage()");
        if (this.mUseAlterImage) {
            logI("setAlterImage - stop Image");
            this.mUseAlterImage = false;
            stopHideMeVideoCall();
            reStartOptionMenu();
            this.mHideMeModeType = 0;
            this.mCallBtnLayout.setHideme(false);
            this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
            setCallButtonShareViewStart();
        } else {
            this.mUseAlterImage = true;
            makeHideMeImage();
            visibleBottomShowMeButton(true);
            setCallButtonShareViewStart();
        }
        this.mCallInfoLayout.setHideMeBtn(this.mUseAlterImage);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    protected void updateHoldState(boolean bHold) {
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    protected void updateMuteState(boolean bMute) {
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity, com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        Log.m2958e("dispose()");
        this.imm = null;
        this.display = null;
        ViewRecycleUtil.recurisveRecycle(getWindow().getDecorView());
        this.hangupMutex = null;
        this.mAudioManager = null;
        this.mCalluserInfo = null;
        if (this.mSurfaceViewlayout != null) {
            this.mSurfaceViewlayout.destroyDrawingCache();
            this.mSurfaceViewlayout = null;
        }
        this.mGestureDetector = null;
        this.mImgPoint = null;
        if (this.mInnerHandler != null) {
            this.mInnerHandler.dispose();
            this.mInnerHandler = null;
        }
        this.mRecordTime = null;
        this.mOnlyBuddyLayout = null;
        this.mModelInfo = null;
        this.mModelDeviceInfo = null;
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.dispose();
            this.mCallBtnLayout = null;
        }
        if (this.mCallEndBtnLayout != null) {
            this.mCallEndBtnLayout.dispose();
            this.mCallEndBtnLayout = null;
        }
        if (this.mCallInfoLayout != null) {
            this.mCallInfoLayout.dispose();
            this.mCallInfoLayout = null;
        }
        if (this.mCallInfoBGLayout != null) {
            this.mCallInfoBGLayout.removeAllViewsInLayout();
            this.mCallInfoBGLayout = null;
        }
        if (this.mCallReceiveBtnLayout != null) {
            this.mCallReceiveBtnLayout.dispose();
            this.mCallReceiveBtnLayout = null;
        }
        if (this.mCallOutgoingCallLayout != null) {
            this.mCallOutgoingCallLayout.dispose();
            this.mCallOutgoingCallLayout = null;
        }
        if (this.mRemoteVideoLayoutRadvision != null) {
            this.mRemoteVideoLayoutRadvision.removeAllViewsInLayout();
            this.mRemoteVideoLayoutRadvision = null;
        }
        if (this.mOrientation != null) {
            this.mOrientation.disable();
            this.mOrientation.dispose();
            this.mOrientation = null;
        }
        if (this.mVideolayout != null) {
            this.mVideolayout.removeAllViewsInLayout();
            this.mVideolayout = null;
        }
        if (this.mRemoteHolder != null) {
            this.mRemoteHolder = null;
        }
        if (this.mSurface != null) {
            this.mSurface.getHolder().removeCallback(this);
            this.mSurface = null;
        }
        if (this.mRemoteSurface != null) {
            this.mRemoteSurface.getHolder().removeCallback(this);
            this.mRemoteSurface = null;
        }
        if (this.mHolder != null) {
            this.mHolder = null;
        }
        if (this.mInnerHandler != null) {
            this.mInnerHandler.dispose();
            this.mInnerHandler = null;
        }
        if (this.mHandler != null) {
            this.mHandler.dispose();
            this.mHandler = null;
        }
        if (this.mVideoRepositionView != null) {
            this.mVideoRepositionView.dispose();
            this.mVideoRepositionView = null;
        }
        if (this.mVideoCallStatusBar != null) {
            this.mVideoCallStatusBar.dispose();
            this.mVideoCallStatusBar = null;
        }
        if (this.mImage != null) {
            this.mImage.recycle();
            this.mImage = null;
        }
        if (this.mDefaultHideImg != null) {
            this.mDefaultHideImg.recycle();
            this.mDefaultHideImg = null;
        }
        if (this.mVideoCallOptionMenu != null) {
            this.mVideoCallOptionMenu.dispose();
            this.mVideoCallOptionMenu = null;
        }
        if (this.mOtherPartyCapture != null) {
            this.mOtherPartyCapture.removeCallbacks(null);
            this.mOtherPartyCapture = null;
        }
        if (this.mCaptureImage != null) {
            this.mCaptureImage.removeCallbacks(null);
            this.mCaptureImage = null;
        }
        if (this.mRecordLayout != null) {
            this.mRecordLayout.removeAllViews();
            this.mRecordLayout = null;
        }
        if (this.mImageCaptureAnimationImageView != null) {
            this.mImageCaptureAnimationImageView = null;
        }
        if (this.mCaptureImageAnimation != null) {
            this.mCaptureImageAnimation = null;
        }
        if (this.mConnectFailDialog != null) {
            this.mConnectFailDialog = null;
        }
        if (this.mShareViewSelectDialog != null) {
            this.mShareViewSelectDialog = null;
        }
        if (this.mRemoteDialog != null) {
            this.mRemoteDialog = null;
        }
        if (this.mOutgoingImageDialog != null) {
            this.mOutgoingImageDialog = null;
        }
        if (this.mLayoutDialog != null) {
            this.mLayoutDialog = null;
        }
        if (this.mShareViewSelectDialog != null) {
            this.mShareViewSelectDialog = null;
        }
        if (this.mSwitchLayoutDialog != null) {
            this.mSwitchLayoutDialog.dismiss();
            this.mSwitchLayoutDialog = null;
        }
        if (this.mTitleBarHandler != null) {
            this.mTitleBarHandler.removeMessages(0);
            this.mTitleBarHandler = null;
        }
        if (this.mInviteViewCtrl != null) {
            this.mInviteViewCtrl.dispose();
            this.mInviteViewCtrl = null;
        }
        if (this.mInviteviewMemberLayout != null) {
            this.mInviteviewMemberLayout.dispose();
            this.mInviteviewMemberLayout = null;
        }
        if (this.mMemberViewLayout != null) {
            this.mMemberViewLayout.removeAllViewsInLayout();
            this.mMemberViewLayout = null;
        }
        if (this.mMemberViewCtrl != null) {
            this.mMemberViewCtrl.dispose();
            this.mMemberViewCtrl = null;
        }
        if (this.mShareViewCtrl != null) {
            this.mShareViewCtrl.dispose();
            this.mShareViewCtrl = null;
        }
        if (this.mShareViewLayout != null) {
            this.mShareViewLayout.removeAllViewsInLayout();
            this.mShareViewLayout = null;
        }
        if (this.mShareViewPinchZoomGuideLineLayout != null) {
            this.mShareViewPinchZoomGuideLineLayout.removeAllViewsInLayout();
            this.mShareViewPinchZoomGuideLineLayout = null;
        }
        if (this.mShareViewCloseButton != null) {
            this.mShareViewCloseButton.removeCallbacks(null);
            this.mShareViewCloseButton = null;
        }
        if (this.mShareViewZoomInButton != null) {
            this.mShareViewZoomInButton.removeCallbacks(null);
            this.mShareViewZoomInButton = null;
        }
        if (this.mShareViewZoomOutButton != null) {
            this.mShareViewZoomOutButton.removeCallbacks(null);
            this.mShareViewZoomOutButton = null;
        }
        disposePinchZoomController();
        if (this.mShareViewPinchZoomView != null) {
            this.mShareViewPinchZoomView.removeAllViewsInLayout();
            this.mShareViewPinchZoomView = null;
        }
        if (this.mShareViewPinchZoomGuideLineLayout != null) {
            this.mShareViewPinchZoomGuideLineLayout.removeAllViewsInLayout();
            this.mShareViewPinchZoomGuideLineLayout = null;
        }
        this.mShareViewPinchZoomGuideScaleText = null;
        if (this.mOptionMenuData != null) {
            this.mOptionMenuData.dispose();
            this.mOptionMenuData = null;
        }
        if (this.sCameraSendFileList != null) {
            this.sCameraSendFileList.clear();
            this.sCameraSendFileList = null;
        }
        if (this.mSCameraSendFileLayout != null) {
            this.mSCameraSendFileLayout.removeAllViewsInLayout();
            this.mSCameraSendFileLayout = null;
        }
        if (this.mCapturedImageList != null) {
            this.mCapturedImageList.clear();
            this.mCapturedImageList = null;
        }
        if (this.mRecvImageList != null) {
            this.mRecvImageList.clear();
            this.mRecvImageList = null;
        }
        if (this.mSCameraTextView != null) {
            this.mSCameraTextView.removeCallbacks(null);
            this.mSCameraTextView = null;
        }
        if (this.mSendButton != null) {
            this.mSendButton.removeCallbacks(null);
            this.mSendButton = null;
        }
        if (this.mCancelButton != null) {
            this.mCancelButton.removeCallbacks(null);
            this.mCancelButton = null;
        }
        if (this.mSCameraVolumeBtnLayout != null) {
            this.mSCameraVolumeBtnLayout.removeCallbacks(null);
            this.mSCameraVolumeBtnLayout = null;
        }
        if (this.mSCameraVolumeBtnLayout2 != null) {
            this.mSCameraVolumeBtnLayout2.removeAllViewsInLayout();
            this.mSCameraVolumeBtnLayout2 = null;
        }
        if (this.mSCameraVolumeUiLayout != null) {
            this.mSCameraVolumeUiLayout.removeAllViewsInLayout();
            this.mSCameraVolumeUiLayout = null;
        }
        if (this.mSCameraVolumeSeekBar != null) {
            this.mSCameraVolumeSeekBar.removeCallbacks(null);
            this.mSCameraVolumeSeekBar = null;
        }
        if (this.mSCameraCameraBtnLayout != null) {
            this.mSCameraCameraBtnLayout.removeAllViewsInLayout();
            this.mSCameraCameraBtnLayout = null;
        }
        if (this.mSCameraCallEndDialog != null) {
            this.mSCameraCallEndDialog = null;
        }
        if (this.mImageView_animated != null) {
            this.mImageView_animated.removeCallbacks(null);
            this.mImageView_animated = null;
        }
        if (this.mSCameraRecvImg != null) {
            this.mSCameraRecvImg.removeCallbacks(null);
            this.mSCameraRecvImg = null;
        }
        if (this.mSCameraSendingFileAnimation != null) {
            this.mSCameraSendingFileAnimation.removeCallbacks(null);
            this.mSCameraSendingFileAnimation = null;
        }
        if (this.mFrameAnimation != null) {
            this.mFrameAnimation = null;
        }
        if (this.mSCameraOutgoingInfoLayout != null) {
            this.mSCameraOutgoingInfoLayout.removeAllViewsInLayout();
            this.mSCameraOutgoingInfoLayout = null;
        }
        if (this.mScaleDetector != null) {
            this.mScaleDetector = null;
        }
        if (this.mBatteryImageView != null) {
            this.mBatteryImageView = null;
        }
        disposeOutgoingCallLayout();
        super.dispose(true);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public void disposeForChanginRotation() {
        logI("disposeForChanginRotation()");
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.dispose();
            this.mCallBtnLayout = null;
        }
        if (this.mCallEndBtnLayout != null) {
            this.mCallEndBtnLayout.dispose();
            this.mCallEndBtnLayout = null;
        }
        if (this.mCallInfoLayout != null) {
            this.mCallInfoLayout.dispose();
            this.mCallInfoLayout = null;
        }
        if (this.mCallInfoBGLayout != null) {
            this.mCallInfoBGLayout.removeAllViewsInLayout();
            this.mCallInfoBGLayout = null;
        }
        if (this.mCallReceiveBtnLayout != null) {
            this.mCallReceiveBtnLayout.dispose();
            this.mCallReceiveBtnLayout = null;
        }
        if (this.mCallOutgoingCallLayout != null) {
            this.mCallOutgoingCallLayout.dispose();
            this.mCallOutgoingCallLayout = null;
        }
        if (this.mRemoteVideoLayoutRadvision != null) {
            this.mRemoteVideoLayoutRadvision.removeAllViewsInLayout();
            this.mRemoteVideoLayoutRadvision = null;
        }
        if (this.mVideolayout != null) {
            this.mVideolayout.removeAllViewsInLayout();
            this.mVideolayout = null;
        }
        if (this.mRemoteHolder != null) {
            this.mRemoteHolder = null;
        }
        if (this.mSurface != null) {
            this.mSurface.getHolder().removeCallback(this);
            this.mSurface = null;
        }
        if (this.mRemoteSurface != null) {
            this.mRemoteSurface.getHolder().removeCallback(this);
            this.mRemoteSurface = null;
        }
        if (this.mHolder != null) {
            this.mHolder = null;
        }
        if (this.mVideoRepositionView != null) {
            this.mVideoRepositionView.dispose();
            this.mVideoRepositionView = null;
        }
        if (this.mVideoCallStatusBar != null) {
            this.mVideoCallStatusBar.dispose();
            this.mVideoCallStatusBar = null;
        }
        if (this.mShareViewPinchZoomView != null) {
            this.mShareViewPinchZoomView.removeAllViewsInLayout();
            this.mShareViewPinchZoomView = null;
        }
        if (this.mShareViewPinchZoomGuideLineLayout != null) {
            this.mShareViewPinchZoomGuideLineLayout.removeAllViewsInLayout();
            this.mShareViewPinchZoomGuideLineLayout = null;
        }
        this.mShareViewPinchZoomGuideScaleText = null;
        if (this.mInviteViewCtrl != null) {
            this.mInviteViewCtrl.dispose();
            this.mInviteViewCtrl = null;
        }
        if (this.mMemberViewLayout != null) {
            this.mMemberViewLayout.removeAllViewsInLayout();
            this.mMemberViewLayout = null;
        }
        if (this.mMemberViewCtrl != null) {
            this.mMemberViewCtrl.dispose();
            this.mMemberViewCtrl = null;
        }
        if (this.mImage != null) {
            this.mImage.recycle();
            this.mImage = null;
        }
        if (this.mVideoCallOptionMenu != null) {
            this.mVideoCallOptionMenu.dispose();
            this.mVideoCallOptionMenu = null;
        }
        if (this.mOtherPartyCapture != null) {
            this.mOtherPartyCapture.removeCallbacks(null);
            this.mOtherPartyCapture = null;
        }
        if (this.mCaptureImage != null) {
            this.mCaptureImage.removeCallbacks(null);
            this.mCaptureImage = null;
        }
        if (this.mRecordLayout != null) {
            this.mRecordLayout.removeAllViews();
            this.mRecordLayout = null;
        }
        if (this.mImageCaptureAnimationImageView != null) {
            this.mImageCaptureAnimationImageView = null;
        }
        if (this.mCaptureImageAnimation != null) {
            this.mCaptureImageAnimation = null;
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.app.Activity
    public boolean onTouchEvent(MotionEvent event) {
        Log.m2958e("onTouchEvent()");
        if (this.mScaleDetector != null) {
            this.mScaleDetector.onTouchEvent(event);
        }
        if (this.mShareViewCtrl.isActive() && this.mScaleGestureDetector != null) {
            try {
                this.mScaleGestureDetector.onTouchEvent(event);
            } catch (IllegalArgumentException e) {
            }
            if (this.mScaleGestureDetector.isInProgress()) {
                return true;
            }
        }
        this.mVideoRepositionView.onTouchEvent(event);
        if (event.getAction() == 1 && this.mIsPreviewAreaScroll && isShowPreviewTouchMenu()) {
            this.mIsPreviewAreaScroll = false;
            showDialog(DIALOG_PREVIEW_SINGLE_TAB);
            return true;
        }
        if (!this.mIsReposotionView) {
            this.mVideoRepositionView.setDeviceType(this.mModelInfo);
            this.mVideoRepositionView.setDownEvent(event, this.mImgPoint);
        }
        if (event.getAction() == 2 && this.bIsRemoteLayoutMove && event.getPointerCount() == 1 && event.getHistorySize() > 0) {
            int hisCnt = event.getHistorySize();
            int diffX = (int) (event.getX() - event.getHistoricalX(hisCnt - 1));
            int diffY = (int) (event.getY() - event.getHistoricalY(hisCnt - 1));
            this.mRemoteLayoutLeftPos += diffX;
            this.mRemoteLayoutTopPos += diffY;
            if (this.mRemoteLayoutLeftPos > this.mMaxMoveX) {
                this.mRemoteLayoutLeftPos = this.mMaxMoveX;
            }
            if (this.mRemoteLayoutLeftPos < (-this.mMaxMoveX)) {
                this.mRemoteLayoutLeftPos = -this.mMaxMoveX;
            }
            if (this.mRemoteLayoutTopPos > this.mMaxMoveY) {
                this.mRemoteLayoutTopPos = this.mMaxMoveY;
            }
            if (this.mRemoteLayoutTopPos < (-this.mMaxMoveY)) {
                this.mRemoteLayoutTopPos = -this.mMaxMoveY;
            }
            FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mRemoteSurface.getLayoutParams();
            param.leftMargin = this.mRemoteLayoutLeftPos;
            param.topMargin = this.mRemoteLayoutTopPos;
            param.gravity = 17;
            this.mRemoteSurface.setLayoutParams(param);
        }
        return super.onTouchEvent(event, true);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent arg0) {
        Log.m2958e("onDown()");
        closeOptionsMenu();
        if (this.mIsReposotionView) {
            this.mVideoRepositionView.setVisibility(8);
            this.mIsReposotionView = false;
        }
        return false;
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
        return false;
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent event) {
        Log.m2958e("onLongPress()");
        if (CallState.isConnected(this.mCallState)) {
            int posx = (int) event.getX();
            int posy = (int) event.getY();
            if (CallState.isConnected(this.mCallState) && !this.mShowOptionMenu) {
                this.mVideoRepositionView.onTouchEvent(event);
                setSelectedViewMenu(posx, posy);
            }
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float distanceX, float distanceY) {
        try {
            if (CallState.isConnected(this.mCallState) && !isConference() && arg0 != null && arg1 != null) {
                int posx = (int) arg0.getX();
                int posy = (int) arg0.getY();
                int xGap = ((int) arg1.getX()) - posx;
                int yGap = ((int) arg1.getY()) - posy;
                boolean isPreviewArea = isImageArea(posx, posy);
                if (isPreviewArea) {
                    if (Math.abs(xGap) < TOUCH_MIN_DISTANCE && Math.abs(yGap) < TOUCH_MIN_DISTANCE) {
                        this.mIsPreviewAreaScroll = true;
                    } else {
                        this.mIsPreviewAreaScroll = false;
                    }
                } else {
                    this.mIsPreviewAreaScroll = false;
                }
            }
        } catch (Exception e) {
            logE("Exception : " + e);
        }
        return false;
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent arg0) {
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent arg0) {
        return false;
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public void setSelectedViewMenu(int posx, int posy) {
        Log.m2958e("setSelectedViewMenu()");
        boolean isSelectedPreview = false;
        if (CallState.isConnected(this.mCallState) && isMovePreviewTouchMenu()) {
            closeOptionsMenu();
            if (!this.mBuddyImageOnly) {
                isSelectedPreview = isImageArea(posx, posy);
            }
            if (isSelectedPreview) {
                if (!this.mIsReposotionView) {
                    if (this.mIsOtherCapture) {
                        finishCaptureImgShow();
                    }
                    this.mIsReposotionView = true;
                    this.mVideoRepositionView.setVisibility(0);
                    return;
                }
                return;
            }
            if (!this.mIsRecording) {
                isRecordRequested();
            }
        }
    }

    private boolean isImageArea(int posx, int posy) {
        if (this.mChanagePreview) {
            if (!this.mMyImageOnly || this.mBuddyImageOnly) {
                return checkImageArea(posx, posy);
            }
            return false;
        }
        if (this.mMyImageOnly || !this.mBuddyImageOnly) {
            return checkImageArea(posx, posy);
        }
        return false;
    }

    private boolean checkImageArea(int posx, int posy) {
        Log.m2958e("checkImageArea()");
        if (getResources().getConfiguration().orientation == 1) {
            if (posx <= this.mImgPoint.x || posx >= this.mImgPoint.x + this.mPreviewWidth || posy <= this.mImgPoint.y || posy >= this.mImgPoint.y + this.mPreviewHeight) {
                return false;
            }
            return true;
        }
        if (posx <= this.mImgPoint.x || posx >= this.mImgPoint.x + this.mPreviewHeight || posy <= this.mImgPoint.y || posy >= this.mImgPoint.y + this.mPreviewWidth) {
            return false;
        }
        return true;
    }

    private void hidekeyboard() {
        try {
            if (this.imm == null) {
                this.imm = (InputMethodManager) getSystemService("input_method");
            }
            if (this.imm != null && this.mSurface != null) {
                this.imm.hideSoftInputFromWindow(this.mSurface.getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.app.Activity
    protected Dialog onCreateDialog(int menuID) throws Resources.NotFoundException {
        dismissVideoDialog();
        ChatONDialog.Builder progress = new ChatONDialog.Builder(this);
        AlertDialog.Builder alertProgress = new AlertDialog.Builder(this);
        switch (menuID) {
            case 100:
                alertProgress.setMessage(getResources().getText(C0000R.string.video_image_capture));
                alertProgress.setCancelable(false);
                return alertProgress.create();
            case 104:
                String user_name = this.mCalluserInfo.userName;
                if (user_name == null) {
                    user_name = this.mCallStatusData.getHostDisplayName();
                }
                String msg = getResources().getString(C0000R.string.video_connect_fail_msg, user_name);
                progress.setTitle(getResources().getText(C0000R.string.video_connect_fail_title));
                progress.setMessage(msg);
                progress.setNegativeButton(C0000R.string.confirm_no, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.15
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        try {
                            LiveShareViewActivity.this.settingEndCall();
                            LiveShareViewActivity.this.removeDialog(104);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                progress.setPositiveButton(C0000R.string.confirm_yes, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.16
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        LiveShareViewActivity.this.setRetryCallStatus();
                    }
                });
                progress.setCancelable(true);
                progress.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.17
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface arg0) {
                        try {
                            LiveShareViewActivity.this.settingEndCall();
                            LiveShareViewActivity.this.removeDialog(104);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                this.mConnectFailDialog = progress.create();
                if (ModelInfoUtil.IS_MODEL_SCAMERA && this.mIsOutGoingCall) {
                    this.mConnectFailDialog.setCanceledOnTouchOutside(true);
                }
                return this.mConnectFailDialog;
            case 105:
                CharSequence[] items1 = {getResources().getText(C0000R.string.video_capture_img), getResources().getText(C0000R.string.video_record_video)};
                String name = this.mCalluserInfo.userName;
                if (name == null) {
                    name = this.mCallStatusData.getHostDisplayName();
                }
                alertProgress.setTitle(name);
                alertProgress.setItems(items1, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.18
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                try {
                                    LiveShareViewActivity.this.setCaptureImage();
                                    LiveShareViewActivity.this.removeDialog(105);
                                    break;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            case 1:
                                try {
                                    if (!LiveShareViewActivity.this.mIsRecording) {
                                        Log.m2958e("CALLCONSENT Activity에서 요청을 보냄.");
                                        LiveShareViewActivity.this.setRecordRequested(true);
                                        LiveShareViewActivity.this.sendRequestConsent(4, 2);
                                    }
                                    LiveShareViewActivity.this.removeDialog(105);
                                    break;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                        }
                    }
                });
                alertProgress.setCancelable(true);
                alertProgress.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.19
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface arg0) {
                        try {
                            LiveShareViewActivity.this.removeDialog(105);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                this.mRemoteDialog = alertProgress.create();
                if (ModelInfoUtil.IS_MODEL_SCAMERA && this.mIsOutGoingCall) {
                    this.mRemoteDialog.setCanceledOnTouchOutside(true);
                }
                this.mRemoteDialog.show();
                return this.mRemoteDialog;
            case 106:
                alertProgress.setMessage(getResources().getText(C0000R.string.video_complete_record));
                alertProgress.setCancelable(false);
                return alertProgress.create();
            case DIALOG_SHARE_VIEW /* 107 */:
                alertProgress.setTitle(getResources().getText(C0000R.string.call_btn_share_screen));
                alertProgress.setItems(C0000R.array.video_call_share_screen_select_menu_item, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.14
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 1:
                                LiveShareViewActivity.this.mShareViewCtrl.setType(2);
                                LiveShareViewActivity.this.sendRequestConsent(2, 0);
                                break;
                        }
                        LiveShareViewActivity.this.mShareViewSelectDialog = null;
                    }
                });
                this.mShareViewSelectDialog = alertProgress.create();
                if (ModelInfoUtil.IS_MODEL_SCAMERA && this.mIsOutGoingCall) {
                    this.mShareViewSelectDialog.setCanceledOnTouchOutside(true);
                }
                this.mShareViewSelectDialog.show();
                return this.mShareViewSelectDialog;
            case DIALOG_PREVIEW_SINGLE_TAB /* 108 */:
                alertProgress.setTitle(getResources().getText(C0000R.string.video_call_preview_single_tab_dialog_title));
                alertProgress.setItems(C0000R.array.video_call_preview_single_tab_dialog_item, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.12
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                LiveShareViewActivity.this.changeLayoutPreviewSingleTab();
                                break;
                            case 1:
                                LiveShareViewActivity.this.changeLayoutRemoteSingleTab();
                                break;
                        }
                        dialog.dismiss();
                        LiveShareViewActivity.this.mPreviewSingleTabDialog = null;
                    }
                });
                alertProgress.setCancelable(true);
                alertProgress.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.13
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialog) {
                        dialog.dismiss();
                        LiveShareViewActivity.this.mPreviewSingleTabDialog = null;
                    }
                });
                this.mPreviewSingleTabDialog = alertProgress.create();
                if (ModelInfoUtil.IS_MODEL_SCAMERA && this.mIsOutGoingCall) {
                    this.mPreviewSingleTabDialog.setCanceledOnTouchOutside(true);
                }
                this.mPreviewSingleTabDialog.show();
                return this.mPreviewSingleTabDialog;
            case DIALOG_SCAMERA_CALL_END /* 109 */:
                String scameraMsg = getResources().getString(C0000R.string.scamera_call_end, this.mCalluserInfo.userName);
                progress.setTitle(getResources().getText(C0000R.string.scamera_call_end_title));
                progress.setMessage(scameraMsg);
                progress.setNegativeButton(C0000R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.20
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        try {
                            LiveShareViewActivity.this.removeDialog(LiveShareViewActivity.DIALOG_SCAMERA_CALL_END);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                progress.setPositiveButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.21
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        LiveShareViewActivity.this.hangupCall();
                    }
                });
                progress.setCancelable(false);
                this.mSCameraCallEndDialog = progress.create();
                if (ModelInfoUtil.IS_MODEL_SCAMERA && this.mIsOutGoingCall) {
                    this.mSCameraCallEndDialog.setCanceledOnTouchOutside(true);
                }
                this.mSCameraCallEndDialog.show();
                return this.mSCameraCallEndDialog;
            case 1000:
                progress.setTitle(getResources().getText(C0000R.string.information_str_title_1));
                if (MainApplication.mConfig.isUseWifiOnly()) {
                    progress.setMessage(getResources().getText(C0000R.string.unable_make_call_wifi_only_on));
                } else {
                    progress.setMessage(getResources().getText(C0000R.string.information_str_msg_1));
                }
                progress.setNegativeButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.22
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        try {
                            LiveShareViewActivity.this.removeDialog(1000);
                            LiveShareViewActivity.this.finish();
                            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                                LiveShareViewActivity.this.overridePendingTransition(0, 0);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                progress.setCancelable(true);
                progress.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.23
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface arg0) {
                        try {
                            LiveShareViewActivity.this.removeDialog(1000);
                            LiveShareViewActivity.this.finish();
                            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                                LiveShareViewActivity.this.overridePendingTransition(0, 0);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                return progress.create();
            case 1001:
                ChatONDialog.Builder progress_1button = new ChatONDialog.Builder(this);
                progress_1button.setTitle(getResources().getText(C0000R.string.information_str_title_2));
                progress_1button.setMessage(getResources().getText(C0000R.string.information_str_msg_2));
                progress_1button.setPositiveButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.24
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        try {
                            LiveShareViewActivity.this.startActivity(new Intent("android.settings.AIRPLANE_MODE_SETTINGS"));
                            LiveShareViewActivity.this.finish();
                            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                                LiveShareViewActivity.this.overridePendingTransition(0, 0);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                progress_1button.setCancelable(true);
                progress_1button.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.25
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface arg0) {
                        try {
                            LiveShareViewActivity.this.removeDialog(1000);
                            LiveShareViewActivity.this.finish();
                            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                                LiveShareViewActivity.this.overridePendingTransition(0, 0);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                return progress_1button.create();
            default:
                return super.onCreateDialog(menuID, true);
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public void setRecordRequested(boolean flag) {
        this.mIsRecordRequested = flag;
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public boolean isRecordRequested() {
        return this.mIsRecordRequested;
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    protected void setCaptureImage() {
        Log.m2958e("setCaptureImage()");
        if (captureImage()) {
            if (this.mChanagePreview) {
                this.mOtherPartyCapture.setVisibility(0);
                this.mHandler.sendEmptyMessageDelayed(DISPLAY_CAPTURE_IMAGE, 1000L);
            } else {
                FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mCaptureImage.getLayoutParams();
                int height = this.mPreviewHeight;
                int width = this.mPreviewWidth;
                if (getResources().getConfiguration().orientation == 1) {
                    param.height = height;
                    param.width = width;
                    this.mCaptureImage.setImageResource(C0000R.drawable.chatonv_capture_default_02);
                    param.setMargins(this.mImgPoint.x, this.mImgPoint.y, this.mPreviewPaddingRight, this.mPrviewPaddingButton);
                } else {
                    param.height = width;
                    param.width = height;
                    this.mCaptureImage.setImageResource(C0000R.drawable.chatonv_capture_default_02);
                    param.setMargins(this.mImgPoint.x, this.mImgPoint.y, this.mLandPreviewPaddingRight, this.mLandPrviewPaddingButton);
                }
                param.gravity = 51;
                this.mCaptureImage.setLayoutParams(param);
                this.mCaptureImage.setVisibility(0);
                this.mHandler.sendEmptyMessageDelayed(DISPLAY_CAPTURE_IMAGE_PREVIEW, 1000L);
            }
            this.mImageCaptureAnimationImageView.setImageDrawable(this.mCaptureImageAnimation);
            this.mHandler.sendEmptyMessageDelayed(STOP_CAPTURE_IMAGE_ANIMATION, 500L);
            this.animationtype = 1;
            this.mCaptureImageAnimation.start();
            this.mImageCaptureAnimationImageView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNotiCapturedView() {
        logI("setNotiCapturedView");
        if (this.mDeviceType != 0 && this.mDeviceType != 5) {
            FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mOtherPartyCapture.getLayoutParams();
            param.width = -1;
            param.height = -1;
            param.gravity = 119;
            param.topMargin = 0;
            if (getResources().getConfiguration().orientation == 1) {
                param.bottomMargin = this.mPreviewMarginButtom;
            } else {
                param.bottomMargin = 0;
            }
            this.mOtherPartyCapture.setLayoutParams(param);
        }
        if (this.mChanagePreview) {
            this.mIsOtherCapture = true;
            FrameLayout.LayoutParams param2 = (FrameLayout.LayoutParams) this.mCaptureImage.getLayoutParams();
            int height = this.mPreviewHeight;
            int width = this.mPreviewWidth;
            if (getResources().getConfiguration().orientation == 1) {
                if (this.mChangePreviewRotation) {
                    param2.height = width;
                    param2.width = height;
                    this.mCaptureImage.setImageResource(C0000R.drawable.chatonv_capture_default_h_02);
                    param2.setMargins(this.mImgPoint.x - this.mHWGap, this.mImgPoint.y + this.mHWGap, this.mPreviewPaddingRight, this.mPrviewPaddingButton);
                } else {
                    param2.height = height;
                    param2.width = width;
                    this.mCaptureImage.setImageResource(C0000R.drawable.chatonv_capture_default_02);
                    param2.setMargins(this.mImgPoint.x, this.mImgPoint.y, this.mPreviewPaddingRight, this.mPrviewPaddingButton);
                }
            } else if (this.mChangePreviewRotation) {
                param2.height = height;
                param2.width = width;
                this.mCaptureImage.setImageResource(C0000R.drawable.chatonv_capture_default_02);
                param2.setMargins(this.mImgPoint.x + this.mHWGap, this.mImgPoint.y - this.mHWGap, this.mLandPreviewPaddingRight, this.mLandPrviewPaddingButton);
            } else {
                param2.height = width;
                param2.width = height;
                this.mCaptureImage.setImageResource(C0000R.drawable.chatonv_capture_default_h_02);
                param2.setMargins(this.mImgPoint.x, this.mImgPoint.y, this.mLandPreviewPaddingRight, this.mLandPrviewPaddingButton);
            }
            param2.gravity = 51;
            this.mCaptureImage.setLayoutParams(param2);
            this.mCaptureImage.setVisibility(0);
            this.mHandler.sendEmptyMessageDelayed(DISPLAY_CAPTURE_IMAGE_PREVIEW, Config.DISCONNECT_TIMEOUT);
            return;
        }
        this.mOtherPartyCapture.setVisibility(0);
        this.mHandler.sendEmptyMessageDelayed(DISPLAY_CAPTURE_IMAGE, Config.DISCONNECT_TIMEOUT);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void showConnectDialog(int msg) {
        logI("showConnectDialog");
        if (msg == 1000) {
            showDialog(1000);
        } else if (msg == 1001) {
            showDialog(1001);
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public void changePreview(Point imgLoc, boolean paddingOff) {
        logI("changePreview");
        this.mIsMovePreviewPosition = true;
        if (paddingOff) {
            this.mIsReposotionView = false;
            this.mVideoRepositionView.setVisibility(8);
        }
        this.mImgPoint = imgLoc;
        setSECPreviewPosition(paddingOff ? false : true);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public void setRepositionVisiblity() {
        logI("setRepositionVisiblity");
        if (this.mVideoRepositionView != null) {
            this.mIsReposotionView = false;
            this.mVideoRepositionView.setVisibility(8);
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public boolean isRepositionVisiblity() {
        logI("isRepositionVisiblity");
        return this.mIsReposotionView;
    }

    private void startVideoRecord() {
        logI("startVideoRecord()");
        setLayoutRecord();
        this.mCallBtnLayout.setRecordBtnStatus(true);
        setRecord();
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void stopRecord() {
        logI("stopRecord()");
        stopRecordUI();
        setRecord();
        showToast(getResources().getString(C0000R.string.video_complete_record));
    }

    private void setLayoutRecordBaseTime(Long baseTime) {
        logI("setLayoutRecordBaseTime()");
        this.mRecordLayout.setVisibility(0);
        this.mRecordTime.setBase(baseTime.longValue());
        this.mRecordTime.start();
        this.mRecordTimer = true;
    }

    private void setLayoutRecord() {
        logI("setLayoutRecord()");
        this.mRecordLayout.setVisibility(0);
        this.mRecordTime.setBase(SystemClock.elapsedRealtime());
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void startRecordTime() {
        logI("startRecordTime()");
        this.mRecordTime.setBase(SystemClock.elapsedRealtime());
        this.mRecordTime.start();
        this.mRecordTimer = true;
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void stopRecordFromEngine() {
        logI("stopRecordFromEngine()");
        this.mCallBtnLayout.setRecordBtnStatus(false);
        stopRecord();
    }

    private void stopRecordUI() {
        logI("stopRecordUI()");
        this.mRecordTime.stop();
        this.mRecordTimer = false;
        this.mRecordLayout.setVisibility(8);
    }

    public void setOtherRecording() {
        logI("setOtherRecording()");
        showToast(getResources().getString(C0000R.string.video_other_recording));
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void hangupLowBattery() {
        logI("hangupLowBattery()");
        showToast(C0000R.string.video_low_battery);
        hangupCall();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRetryCallStatus() {
        logI("hangupLowBattery()");
        if (VAppPhoneManager.checkAirPlainMode(this)) {
            logI("Call Fail: Airplain Mode");
            showConnectDialog(1001);
            return;
        }
        if (!PhoneManager.isNetworkConnected(getApplicationContext())) {
            logI("Call Fail: Network Disconnected");
            showConnectDialog(1000);
            return;
        }
        PhoneNumberUtil phoneUtil = new PhoneNumberUtil(ChatONStringConvert.getInstance().removeAfterAt(this.mDestination.getPhoneNo()));
        String userNumber = phoneUtil.getPhoneNumber();
        Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + userNumber));
        startActivity(intent);
        finish();
        if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    protected void dismissVideoDialog() {
        logI("dismissVideoDialog()");
        if (this.mRemoteDialog != null && this.mRemoteDialog.isShowing()) {
            this.mRemoteDialog.dismiss();
        }
        if (this.mOutgoingImageDialog != null && this.mOutgoingImageDialog.isShowing()) {
            this.mOutgoingImageDialog.dismiss();
        }
        if (this.mConnectFailDialog != null && this.mConnectFailDialog.isShowing()) {
            this.mConnectFailDialog.dismiss();
        }
        if (this.mLayoutDialog != null && this.mLayoutDialog.isShowing()) {
            this.mLayoutDialog.dismiss();
        }
        if (this.mShareViewSelectDialog != null && this.mShareViewSelectDialog.isShowing()) {
            this.mShareViewSelectDialog.dismiss();
        }
        if (this.mPreviewSingleTabDialog != null && this.mPreviewSingleTabDialog.isShowing()) {
            this.mPreviewSingleTabDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplay3GLayout(String number) {
        logI("setDisplay3GLayout()");
        if (this.mAudioManager != null) {
            this.mSpeakerOn = this.mAudioManager.isSpeakerphoneOn();
        }
        this.mIsNativeCall = true;
        if (this.mIsRecording) {
            stopRecordUI();
            this.mCallBtnLayout.setRecordBtnStatus(false);
            this.mIsRecording = false;
            try {
                sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity
    public void hideNativeCallLayout() {
        logI("hideNativeCallLayout()");
        this.mIsNativeCall = false;
        this.mNativeStauts = 0;
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity
    public void accpetNativeCall() {
        logI("accpetNativeCall()");
        if (this.mIsNativeCall && this.mNativeStauts == 0) {
            this.mHideMeModeType = 1;
            this.mPreAlterImage = this.mUseAlterImage;
            this.mNativeStauts++;
            this.mIsNativeCall = true;
            this.mUseAlterImage = false;
            setAlterImage();
            this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endNativeCall(int doUnHold, int doMute) {
        logI("endNativeCall()");
        if (this.mIsNativeCall) {
            this.mIsNativeCall = false;
            this.mNativeStauts = 0;
            this.mHideMeModeType = 1;
            if (this.mPreAlterImage) {
                this.mUseAlterImage = this.mPreAlterImage;
            } else {
                setAlterImage();
            }
            this.mSurface.setZOrderMediaOverlay(true);
            this.mRemoteSurface.setZOrderMediaOverlay(false);
            MainApplication.mPhoneManager.getHardwareManager().setModeConnectedFor3GIdleMode(true);
            if (doUnHold == 1) {
                if (doMute == 1) {
                    MainApplication.mPhoneManager.getPhoneStateMachine().setUnHoldFor3GIdle(this.mDestination, 1);
                    this.mCallBtnLayout.setUIState(this.mCallState, false, false);
                } else {
                    MainApplication.mPhoneManager.getPhoneStateMachine().setUnHoldFor3GIdle(this.mDestination, 0);
                    this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
                }
            } else if (doMute == 1) {
                MainApplication.mPhoneManager.getPhoneStateMachine().muteCall(this.mDestination);
                this.mCallBtnLayout.setUIState(this.mCallState, false, false);
            } else {
                this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
            }
        }
        if (this.mVideoCallOptionMenu != null) {
            this.mVideoCallOptionMenu.refreshOptionMenu(this.mAniThemeMenu, this.mIsThemeShotMenu);
            if (this.mIsNativeCall) {
                reStartOptionMenu();
            }
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void showCallHoldOnStateToast() {
        showToast(C0000R.string.call_on_hold);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void showCallHoldRetrievedStateToast() {
        showToast(C0000R.string.call_retrieved);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void setHideMe() {
        logI("setHideMe()");
        this.mUseAlterImage = true;
        if (isDefaultHideMeImage()) {
            logI(" setHideMe = default Image");
            makeHideMeImage();
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void setShowMe() {
        logI("setShowMe()");
        this.mUseAlterImage = false;
        stopHideMeVideoCall();
        reStartOptionMenu();
        this.mCallBtnLayout.setHideme(false);
        this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
        setCallButtonShareViewStart();
    }

    private void reStartOptionMenu() {
        logI("reStartOptionMenu: mAniThemeMenu: " + this.mAniThemeMenu + " mIsCartoonView: " + this.mIsCartoonView);
        int action = this.mVideoCallOptionMenu.reStartAnimation();
        if (this.mIsCartoonView) {
            setCartoonView(0);
        }
        if (action == 1) {
            this.mAniThemeMenu = true;
            this.mIsThemeShotMenu = false;
        } else if (action == 2) {
            this.mAniThemeMenu = true;
            this.mIsThemeShotMenu = true;
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        logI("onActivityResult()");
        super.onActivityResult(requestCode, resultCode, data, true);
        if (resultCode == -1) {
            if (requestCode == 1) {
                this.mIsExcuteIntent = false;
                setTempFileUri();
                File file = new File(this.mHideMeUri.getPath());
                if (file.exists()) {
                    file.delete();
                }
                this.mShareViewCtrl.setType(1);
                sendRequestConsent(2, 0);
                return;
            }
            if (requestCode == 2) {
                this.mInviteViewCtrl.preprocessInviteView(data, this.mDestinationUtil, this.mDestination, this.mUserAddedInfo, this.mCalluserInfo);
            }
        }
    }

    private void setTempFileUri() {
        logI("setTempFileUri()");
        if (this.mHideMeUri == null || this.mHideMeUri.getPath() == null) {
            this.mHideMeUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "Test.jpg"));
        }
    }

    private void excuteOwnVideo() {
        logI("excuteOwnVideo()");
        try {
            this.mDefaultHideImg = null;
            makeHideMeImage();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void makeLocalHideImage() {
        logI("makeLocalHideImage()");
        try {
            BitmapFactory.Options sizeOpt = new BitmapFactory.Options();
            sizeOpt.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), C0000R.drawable.hide_me, sizeOpt);
            int width = sizeOpt.outWidth;
            int height = sizeOpt.outHeight;
            int scaleWidth = width / ChatONHideMeImgData.IMAGE_DEFAULT_HEIGHT;
            int scaleHeight = height / ChatONHideMeImgData.IMAGE_DEFAULT_WIDTH;
            int rate = 1;
            if (scaleWidth > 1 || scaleHeight > 1) {
                rate = scaleWidth < scaleHeight ? scaleWidth : scaleHeight;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = rate;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inPurgeable = true;
            options.inDither = true;
            this.mDefaultHideImg = BitmapFactory.decodeResource(getResources(), C0000R.drawable.hide_me, options);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity
    public void makeHideMeImage() {
        logI("makeDefaultHideMeImage()");
        if (this.mDefaultHideImg == null) {
            this.mDefaultHideImg = ChatONSettingData.getInstance().getVideoCallImage(true, isLandscapeFromAngle(this.mSavedOrientation));
        }
        if (this.mDefaultHideImg == null) {
            makeLocalHideImage();
        }
        makeHideMeImage(this.mDefaultHideImg);
    }

    private void makeHideMeImage(Bitmap bitmap) {
        logI("makeHideMeImage()");
        if (bitmap != null) {
            try {
                int widthImg = bitmap.getWidth();
                int heightImg = bitmap.getHeight();
                ByteBuffer buffer = ByteBuffer.allocateDirect(widthImg * heightImg * 4);
                bitmap.copyPixelsToBuffer(buffer);
                this.mUseAlterImage = true;
                sendHideMeImage(buffer, widthImg, heightImg, this.mSavedOrientation);
            } catch (Exception ex) {
                logE("makeHideMeImage Exception : " + ex);
            }
        }
    }

    private void sendHideMeImage(ByteBuffer buffer, int width, int height, int angle) {
        this.mVideoCallOptionMenu.startHideMe();
        boolean autoRotation = isAutorotationActive();
        int systembarAngle = getSystemBarOrientation();
        if (autoRotation && angle != 180) {
            systembarAngle = angle;
        }
        int degree = (systembarAngle << 16) | angle;
        logI("sendHideMeImage()");
        logI("width: " + width + " height: " + height);
        logI("deviceAngle: " + angle);
        logI("systemBarAngle: " + systembarAngle);
        logI("degree: " + Integer.toHexString(degree));
        logI("is auto-rotation: " + isAutorotationActive());
        startHideMeVideoCall(buffer, width, height, degree, this.mHideMeModeType, true, autoRotation);
        this.mCallBtnLayout.setHideme(true);
        this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
        setCallButtonShareViewStart();
    }

    private void visibleBottomShowMeButton(boolean toHideme) {
        if (this.mCallBtnLayout != null) {
            if (CallState.isConnected(this.mCallState)) {
                this.mCallBtnLayout.setHideme(toHideme);
                this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
            } else {
                this.mCallBtnLayout.setHideme(false);
                this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
            }
        }
    }

    private void askChangeConferenceLayout(int layoutID) {
        logI("askChangeConferenceLayout()");
        MainApplication.mPhoneManager.getPhoneStateMachine().changeConferenceLayout(this.mDestination, layoutID);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public void handleChangeConferenceLayout(int layoutID) {
        logI("handleChangeConferenceLayout()");
        this.mConfLayout = layoutID;
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent event) {
        logI("onDoubleTab");
        return false;
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent arg0) {
        return false;
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent event) {
        logI("onSingleTapConfirmed");
        previewTouchEvent(event);
        return false;
    }

    private boolean previewTouchEvent(MotionEvent event) {
        if (CallState.isConnected(this.mCallState)) {
            if (isShowPreviewTouchMenu()) {
                int posx = (int) event.getX();
                int posy = (int) event.getY();
                boolean isPreviewArea = isImageArea(posx, posy);
                if (isPreviewArea) {
                    showDialog(DIALOG_PREVIEW_SINGLE_TAB);
                    return true;
                }
                if (this.mIsOutGoingCall) {
                    return true;
                }
                viewTopStatusBar();
                return true;
            }
            if (this.mIsOutGoingCall) {
                return true;
            }
            viewTopStatusBar();
            return true;
        }
        return false;
    }

    private boolean isShowPreviewTouchMenu() {
        return true;
    }

    private boolean isMovePreviewTouchMenu() {
        return this.mDestination.getDestinationType() != 4 || this.mDestinationUtil.getConferenceConnectCount(this.mDestination) == 1;
    }

    protected class TitleBarHandler extends Handler {
        protected TitleBarHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (LiveShareViewActivity.this.mDeviceType == 0 || LiveShareViewActivity.this.mDeviceType == 5) {
                LiveShareViewActivity.this.mTitleBarHandler.removeMessages(0);
                LiveShareViewActivity.this.mVideoCallStatusBar.startStatusBarAnimation(false);
                LiveShareViewActivity.this.setVisibleShareViewCloseBtn(0);
                if (LiveShareViewActivity.this.mAniThemeMenu) {
                    LiveShareViewActivity.this.mVideoCallOptionMenu.setVisibility(0);
                }
            }
        }
    }

    private void goneTopStatusBar() {
        if (this.mVideoCallStatusBar.getVisibility() != 8) {
            this.mTitleBarHandler.removeMessages(0);
            if (this.mDeviceType == 0 || this.mDeviceType == 5) {
                this.mVideoCallStatusBar.startStatusBarAnimation(false);
            } else {
                this.mVideoCallStatusBar.setVisibility(8);
                this.mInviteviewMemberLayout.setVisibility(8);
            }
            setVisibleShareViewCloseBtn(8);
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.controller.IInviteViewController
    public void viewTopStatusBar() {
        if (this.mVideoCallOptionMenu != null && this.mVideoCallOptionMenu.getVisibility() == 0) {
            logI("viewTopStatusBar = mVideoCallOptionMenu.getVisibility()");
            if (this.mInviteViewCtrl.isActive() || this.mInviteViewCtrl.isInviteWaiting()) {
                this.mVideoCallOptionMenu.setVisibility(8);
            } else {
                return;
            }
        }
        if (this.mVideoCallStatusBar.getVisibility() != 0) {
            setVisibleShareViewCloseBtn(8);
            this.mVideoCallStatusBar.setVisibility(0);
            this.mInviteviewMemberLayout.setVisibility(0);
            if (this.mDeviceType == 0 || this.mDeviceType == 5) {
                this.mVideoCallStatusBar.startStatusBarAnimation(true);
            }
            this.mTitleBarHandler.removeMessages(0);
            this.mTitleBarHandler.sendEmptyMessageDelayed(0, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeLayoutRemoteSingleTab() {
        logI("changeLayoutRemoteSingleTab()");
        if (this.mMyImageOnly) {
            logI("onDoubleTab1");
            this.mMyImageOnly = false;
            this.mBuddyImageOnly = false;
            this.mChanagePreview = true;
        } else if (this.mBuddyImageOnly) {
            logI("onDoubleTab2");
            this.mMyImageOnly = false;
            this.mBuddyImageOnly = false;
            this.mChanagePreview = false;
        } else if (this.mChanagePreview) {
            logI("onDoubleTab3");
            this.mMyImageOnly = true;
            this.mBuddyImageOnly = false;
        } else {
            logI("onDoubleTab4");
            this.mMyImageOnly = false;
            this.mBuddyImageOnly = true;
        }
        updatePreviewLayout(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeLayoutPreviewSingleTab() {
        logI("changeLayoutPreviewSingleTab()");
        setViewGuideLineStatus(0, 1);
        setViewGuideLineStatus(0, 0);
        if (this.mChanagePreview) {
            setDefaultSurfaceView(true);
        } else {
            setRemoteSurfaceView(true);
        }
        logI(" changeLayoutPreviewSingleTab :mChanagePreview " + this.mChanagePreview);
        setPreViewWhiteOutLine();
    }

    private void restorePreviewImage() {
        if (this.mBuddyImageOnly) {
            logI("restorePreviewImage()");
            this.mOnlyBuddyLayout.setVisibility(8);
            setSECPreviewPosition(false);
            this.mBuddyImageOnly = false;
        }
        setPreViewWhiteOutLine();
    }

    private void setDefaultSurfaceView(boolean isUsePreView) {
        logI("setDefaultSurfaceView(" + isUsePreView + ")");
        if (isUsePreView) {
            restorePreviewImage();
        }
        SECConfig.setVideoSurfaceData(0, null);
        SECConfig.setVideoSurfaceData(1, null);
        if (this.mHolder != null) {
            SECConfig.setVideoSurfaceData(0, this.mHolder.getSurface());
        }
        if (this.mRemoteHolder != null) {
            SECConfig.setVideoSurfaceData(1, this.mRemoteHolder.getSurface());
        }
        changedPreviewLayout(false);
        changedRemoteLayout(false);
        this.mChanagePreview = false;
    }

    private void setDefaultSurfaceViewForStopShareView() {
        restorePreviewImage();
        SECConfig.setVideoSurfaceData(0, null);
        SECConfig.setVideoSurfaceData(1, null);
        if (this.mHolder != null) {
            SECConfig.setVideoSurfaceData(0, this.mHolder.getSurface());
        }
        if (this.mRemoteHolder != null) {
            SECConfig.setVideoSurfaceData(1, this.mRemoteHolder.getSurface());
        }
        onDrawRemoteSurface(this.mRemoteRotation);
        changedPreviewLayout(false);
    }

    private void setRemoteSurfaceView(boolean isUsePreView) {
        logI("setRemoteSurfaceView(" + isUsePreView + ")");
        if (isUsePreView) {
            restorePreviewImage();
        }
        SECConfig.setVideoSurfaceData(0, null);
        SECConfig.setVideoSurfaceData(1, null);
        if (this.mRemoteHolder != null) {
            SECConfig.setVideoSurfaceData(0, this.mRemoteHolder.getSurface());
        }
        if (this.mHolder != null) {
            SECConfig.setVideoSurfaceData(1, this.mHolder.getSurface());
        }
        changedPreviewLayout(false);
        changedRemoteLayout(false);
        this.mChanagePreview = true;
    }

    private void changePreviewOnly() {
        logI("changePreviewOnly()");
        if (this.mChanagePreview) {
            gonePreviewLayout();
        } else {
            setRemoteSurfaceView(false);
        }
        if (CallState.isConnected(this.mCallState)) {
            this.mOnlyBuddyLayout.setVisibility(0);
        } else {
            this.mOnlyBuddyLayout.setVisibility(8);
        }
    }

    private void gonePreviewLayout() {
        logI("<<YHT101>>-----------------------------gonePreViewLayout()");
        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mSurfaceViewlayout.getLayoutParams();
        int i = this.mPreviewWidth;
        param.width = i;
        this.mSavedPreviewWidth = i;
        int i2 = this.mPreviewHeight;
        param.height = i2;
        this.mSavedPreviewHeight = i2;
        this.mSavedPreviewMarginTop = param.topMargin;
        this.mSavedPreviewMarginLeft = param.leftMargin;
        this.mSavedPreviewMarginRight = param.rightMargin;
        this.mSavedPreviewMarginBottom = param.bottomMargin;
        param.gravity = 51;
        param.setMargins(this.mModelDeviceInfo.getPreviewWidth() * (-1), this.mModelDeviceInfo.getPreviewHeight() * (-1), this.mPreviewPaddingRight, this.mPrviewPaddingButton);
        this.mSurfaceViewlayout.setLayoutParams(param);
    }

    private void showPreviewLayout() {
        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mSurfaceViewlayout.getLayoutParams();
        param.gravity = 51;
        param.width = this.mSavedPreviewWidth;
        param.height = this.mSavedPreviewHeight;
        param.setMargins(this.mSavedPreviewMarginTop, this.mSavedPreviewMarginLeft, this.mSavedPreviewMarginRight, this.mSavedPreviewMarginBottom);
        this.mSurfaceViewlayout.setLayoutParams(param);
    }

    private void changeRemoteViewOnly() {
        logI("changeRemoteViewOnly()");
        if (this.mChanagePreview) {
            setDefaultSurfaceView(false);
        }
        gonePreviewLayout();
        if (CallState.isConnected(this.mCallState)) {
            this.mOnlyBuddyLayout.setVisibility(0);
        } else {
            this.mOnlyBuddyLayout.setVisibility(8);
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void setDisplayDialog(int dialogID) {
        logI("setDisplayDialog(" + dialogID + ")");
        displayDialog(dialogID);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    void prepareCaptureAnimation() {
        logI("prepareCaptureAnimation()");
        this.mCaptureImageAnimation = new AnimationDrawable();
        this.mCaptureImageAnimation.addFrame(getResources().getDrawable(C0000R.drawable.video_capture_012), 100);
        this.mCaptureImageAnimation.addFrame(getResources().getDrawable(C0000R.drawable.video_capture_011), 100);
        this.mCaptureImageAnimation.addFrame(getResources().getDrawable(C0000R.drawable.video_capture_010), 50);
        this.mCaptureImageAnimation.addFrame(getResources().getDrawable(C0000R.drawable.video_capture_010), 50);
        this.mCaptureImageAnimation.addFrame(getResources().getDrawable(C0000R.drawable.video_capture_011), 100);
        this.mCaptureImageAnimation.addFrame(getResources().getDrawable(C0000R.drawable.video_capture_012), 100);
        this.mCaptureImageAnimation.setOneShot(true);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void showCallEndAnimation() {
        logI("showCallEndAnimation()");
        if (getForegounrdActivity(MainApplication.mContext).equals(getClass().getName()) && !this.mIsOutGoingCall) {
            logI("ANIMATION start CallEndAnimation");
            this.animationtype = 0;
            AnimationSet anisetDownside = new AnimationSet(true);
            AnimationSet anisetUpside = new AnimationSet(true);
            TranslateAnimation transDownside = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, PINCH_ZOOM_INTERPOLATION);
            TranslateAnimation transUpside = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            anisetDownside.addAnimation(transDownside);
            anisetUpside.addAnimation(transUpside);
            AlphaAnimation alpha = new AlphaAnimation(PINCH_ZOOM_INTERPOLATION, 0.0f);
            anisetDownside.addAnimation(alpha);
            anisetUpside.addAnimation(alpha);
            anisetDownside.setInterpolator(AnimationUtils.loadInterpolator(MainApplication.mContext, R.anim.decelerate_interpolator));
            anisetUpside.setInterpolator(AnimationUtils.loadInterpolator(MainApplication.mContext, R.anim.decelerate_interpolator));
            anisetDownside.setDuration(400L);
            anisetDownside.setFillAfter(true);
            anisetUpside.setDuration(400L);
            anisetUpside.setFillAfter(true);
            if (this.mCallOutgoingCallLayout != null) {
                this.mCallOutgoingCallLayout.startAnimation(anisetUpside);
            }
            if (this.mCallEndBtnLayout != null) {
                this.mCallEndBtnLayout.startAnimation(anisetDownside);
            }
            anisetDownside.setAnimationListener(this);
            return;
        }
        logI("ANIMATION just finish Activity");
        super.finish();
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void showCallIncomingAnimation() {
        logI("showCallIncomingAnimation()");
        TranslateAnimation mIncomingLayoutTrans = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        mIncomingLayoutTrans.setInterpolator(AnimationUtils.loadInterpolator(MainApplication.mContext, R.anim.decelerate_interpolator));
        mIncomingLayoutTrans.setDuration(400L);
        this.mCallInfoLayout.startAnimation(mIncomingLayoutTrans);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation arg0) {
        logI("onAnimationEnd()");
        if (this.animationtype == 0) {
            super.finish();
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation arg0) {
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation arg0) {
    }

    protected void handleFileSendStart() {
        this.mSCameraTextView.setText(getResources().getString(C0000R.string.scamera_sending_files, this.mCalluserInfo.userName));
        this.mSendButton.setVisibility(8);
        this.mCancelButton.setVisibility(8);
        this.mSCameraSendingFileAnimation.setVisibility(0);
        this.mFrameAnimation.start();
    }

    protected void handleFileSendDone() {
        this.mSCameraTextView.setText(getResources().getString(C0000R.string.scamera_sent_files, this.mCalluserInfo.userName));
        this.mCurrentCapturedImgCnt = 0;
        this.sCameraSendFileList.clear();
        this.mFrameAnimation.stop();
        this.mSCameraSendingFileAnimation.setVisibility(8);
        this.mIsSendingFile = false;
        this.mInnerHandler.sendEmptyMessageDelayed(SCAMERA_SEND_DONE, 1000L);
    }

    protected void handleFileRecvStart(int totalFileNum) {
        this.mIsReceivingFile = true;
    }

    protected void handleFileRecvDone(ArrayList<String> fileList) {
        this.mRecvImageList.clear();
        for (int i = 0; i < fileList.size(); i++) {
            this.mRecvImageList.add(fileList.get(i));
        }
        setSCameraReceiveFileLayout();
    }

    private void setLandScapeIncomingPreview() {
        logI("setLandScapeIncomingPreview()");
        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mSurfaceViewlayout.getLayoutParams();
        param.width = -1;
        param.height = -1;
        param.gravity = 119;
        param.bottomMargin = this.mLandRemoteViewMarginButtom;
        param.topMargin = 0;
        if (ModelInfoUtil.IS_MODEL_SCAMERA) {
            param.leftMargin = 152;
            param.rightMargin = 152;
        } else {
            param.leftMargin = 194;
            param.rightMargin = 194;
        }
        if (this.mDeviceType == 4 || this.mDeviceType == 1) {
            param.leftMargin = 140;
            param.rightMargin = 140;
        } else if (this.mDeviceType == 2) {
            param.leftMargin = 144;
            param.rightMargin = 144;
        } else if (this.mDeviceType == 5) {
            param.leftMargin = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_TABLEPROPERTY_PREVIEW_EVENT;
            param.rightMargin = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_TABLEPROPERTY_PREVIEW_EVENT;
        }
        this.mSurfaceViewlayout.setLayoutParams(param);
    }

    private void resizePreview2OriginalSize() {
        logI("resizePreview2OriginalSize()");
        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mSurfaceViewlayout.getLayoutParams();
        if (getResources().getConfiguration().orientation == 1) {
            param.width = this.mPreviewWidth;
            param.height = this.mPreviewHeight;
            param.gravity = 51;
            param.setMargins(this.mImgPoint.x, this.mImgPoint.y, this.mPreviewPaddingRight, this.mPrviewPaddingButton);
        } else {
            param.width = this.mPreviewHeight;
            param.height = this.mPreviewWidth;
            param.gravity = 51;
            param.setMargins(this.mImgPoint.x, this.mImgPoint.y, this.mLandPreviewPaddingRight, this.mLandPrviewPaddingButton);
        }
        this.mSurfaceViewlayout.setLayoutParams(param);
        setPreViewWhiteOutLine();
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void stopRecordingForCallSwitching() {
        logI("stopRecordingForCallSwitching()");
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isRecording()) {
            stopRecordCall();
            showToast(C0000R.string.video_complete_record);
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void handlePopupCloseForCallSwitch() {
        logI("handlePopupCloseForCallSwitch()");
        if (this.callSwtichingDialog != null) {
            this.callSwtichingDialog.cancel();
            this.callSwtichingDialog = null;
        }
        dismissCallConsentProcessingDialog();
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity
    public void startRecordCallAfterConsent() {
        logI("startRecordCallAfterConsent()");
        startVideoRecord();
        setRecordRequested(false);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity
    public void setRecordStatement() {
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void onBTButton() {
        this.mIsBlueTooth = 1;
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void offBTButton() {
        this.mIsBlueTooth = 0;
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void disableBTButton() {
        this.mIsBlueTooth = 2;
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void enableSpeakerButton() {
        this.mIsSpeaker = true;
        notifySpeakerphone();
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void disableSpeakerButton() {
        this.mIsSpeaker = false;
        cancelSpeakerphone();
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void gotoBlueToothSettingPage() {
        startActivity(ChatONBlueTooth.getBlueToothSettingPageIntent());
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity
    public void setRecordStatus(boolean isRecord) {
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity
    public void setMenuBtnEnable(boolean enable) {
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void handleEarphonePlugged(boolean isPlugged) {
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity
    public void rejectRecordCall() {
        setRecordRequested(false);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void clickableHoldButton() {
    }

    private void updatePreviewLayout(boolean isStopShareView) {
        logI("updatePreviewLayout() mMyImageOnly: " + this.mMyImageOnly + " mBuddyImageOnly: " + this.mBuddyImageOnly + " isStopShareView: " + isStopShareView);
        if (this.mMyImageOnly) {
            changePreviewOnly();
            return;
        }
        if (this.mBuddyImageOnly) {
            changeRemoteViewOnly();
            return;
        }
        if (isStopShareView) {
            if (this.mChanagePreview) {
                setRemoteSurfaceView(true);
            } else {
                setDefaultSurfaceViewForStopShareView();
            }
        } else {
            if (this.mChanagePreview) {
                restorePreviewImage();
            }
            setSurfaceViewLayout();
        }
        this.mOnlyBuddyLayout.setVisibility(8);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.controller.IInviteViewController
    public void showProgressBarInviteView() {
        if (!isConference()) {
            handleChangeToConferenceStart();
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.controller.IInviteViewController
    public void disableButtonDuringInviteView() {
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void startShareView(boolean isStarter) {
        logI("startShareView(" + isStarter + ")");
        this.mShareViewCtrl.setStarter(isStarter);
        if (this.mShareViewCtrl.getType() == 2) {
            logI("share view : video share view start");
            startShareView();
        } else if (this.mShareViewCtrl.getType() == 1) {
            logI("share view : image share view start(gallary)");
            startShareView();
        } else {
            startShareView();
        }
    }

    private void startShareView() {
        logI("startShareView()");
        closeOptionsMenu();
        if (this.mChanagePreview) {
            setViewGuideLineStatus(0, 1);
        } else {
            setViewGuideLineStatus(0, 0);
        }
        if (this.mShareViewCtrl.isStarter()) {
            logI("starter: close theme view, emotional animation");
            if (this.mAniThemeMenu || this.mIsThemeShotMenu) {
                this.mVideoCallOptionMenu.stopFunction();
            }
        }
        VideoShareViewRestoreData data = new VideoShareViewRestoreData();
        data.setMyImageOnly(this.mMyImageOnly);
        data.setBuddyImageOnly(this.mBuddyImageOnly);
        data.setChangePreview(this.mChanagePreview);
        data.setBackCameraToggle(getCameraToggle());
        data.setUseHideMe(this.mUseAlterImage);
        data.setThemeEmotionalAnimationVisible(this.mVideoCallOptionMenu.getVisibility() == 0);
        this.mShareViewCtrl.setBackupData(data);
        this.mShareViewCtrl.start(isConference(), this.mShareViewCtrl.isStarter(), this.mShareViewCtrl.getType(), this.mUseAlterImage);
        this.mVideoCallOptionMenu.setVisibility(8);
        setShareViewCamera(true);
        setShareLiveVideoViewHideme(true);
        setSharePictureView(true);
        setLayoutShareViewStart();
        setCallButtonShareViewStart();
    }

    private boolean setSharePictureView(boolean isServiceStart) {
        return this.mShareViewCtrl.isStarter() && this.mShareViewCtrl.getType() == 1 && !isServiceStart;
    }

    private void restoreHideMeImage() {
        if (!this.mUseAlterImage) {
            setShowMe();
        } else {
            makeHideMeImage();
        }
    }

    private void setShareLiveVideoViewHideme(boolean isServiceStart) {
        if (this.mShareViewCtrl.isStarter() && this.mShareViewCtrl.getType() == 2) {
            if (isServiceStart) {
                if (this.mShareViewCtrl.getHidemeFlag()) {
                    setShowMe();
                }
            } else if (this.mShareViewCtrl.getHidemeFlag()) {
                setHideMe();
            }
            updateCallState();
        }
    }

    private void setLayoutShareViewStart() {
        logI("setLayoutShareViewStart()");
        if (this.mShareViewCtrl.isStarter()) {
            this.mMyImageOnly = true;
            updatePreviewLayout(false);
        } else {
            this.mBuddyImageOnly = true;
            updatePreviewLayout(false);
        }
        if (!this.mIsOutGoingCall) {
            showShareViewBtn();
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void stopShareView() {
        logI("stopShareView()");
        if (this.mShareViewCtrl.isActive()) {
            closeOptionsMenu();
            sendShareViewCameraZoomToServer(0);
            disposePinchZoomController();
            setShareViewCamera(false);
            boolean visibleThemeEmotionalAni = false;
            VideoShareViewRestoreData data = this.mShareViewCtrl.getBackupData();
            if (data != null) {
                this.mBuddyImageOnly = data.getBuddyImageOnly();
                this.mMyImageOnly = data.getMyImageOnly();
                this.mChanagePreview = data.getChangePreview();
                setCameraToggle(data.getBackCameraToggle());
                this.mUseAlterImage = data.getUseHideMe();
                visibleThemeEmotionalAni = data.getThemeEmotionalAnimationVisible();
            }
            if (this.mShareViewCtrl.isFullScreen()) {
                this.mShareViewZoomInButton.setVisibility(0);
                this.mShareViewZoomOutButton.setVisibility(8);
                if (!this.mIsOutGoingCall) {
                    this.mCallBtnLayout.setVisibility(0);
                }
                contractShareViewForZoom();
            }
            goneShareViewBtn();
            setCallButtonShareViewEnd();
            boolean isRestoreHideMeImage = setSharePictureView(false);
            setShareLiveVideoViewHideme(false);
            this.mShareViewCtrl.stop();
            setPreViewWhiteOutLine();
            this.mReturnPreview = false;
            updatePreviewLayout(true);
            if (visibleThemeEmotionalAni) {
                this.mVideoCallOptionMenu.setVisibility(0);
            }
            if (isRestoreHideMeImage) {
                restoreHideMeImage();
            }
            if (this.mAniThemeMenu) {
                if (this.mIsThemeShotMenu) {
                    displayThemeShot();
                } else {
                    displayEmotionalAnimation();
                }
            }
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public void endShareView() {
        logI("endShareView()");
        if (this.mShareViewCtrl.isActive()) {
            closeOptionsMenu();
            goneShareViewBtn();
            this.mShareViewCtrl.stop();
            setCallButtonShareViewEnd();
        }
    }

    private void showShareViewBtn() {
        this.mShareViewLayout.setVisibility(0);
        this.mShareViewCloseButton.setVisibility(this.mShareViewCtrl.isStarter() ? 0 : 8);
        this.mShareViewZoomInButton.setVisibility(this.mShareViewCtrl.isFullScreen() ? 8 : 0);
        this.mShareViewZoomOutButton.setVisibility(this.mShareViewCtrl.isFullScreen() ? 0 : 8);
    }

    private void goneShareViewBtn() {
        this.mShareViewLayout.setVisibility(8);
        this.mShareViewCloseButton.setVisibility(8);
        this.mShareViewZoomInButton.setVisibility(8);
        this.mShareViewZoomOutButton.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisibleShareViewCloseBtn(int visible) {
        if (this.mShareViewCtrl.isActive() && this.mShareViewCtrl.isStarter()) {
            this.mShareViewCloseButton.setVisibility(visible);
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.common.controller.IPinchZoomController
    public void resizePinchZoomLayout(int size) {
        logI("resizePinchZoomLayout()");
        if (this.mPinchZoomController != null) {
            logI("resize to: " + size + " scale: " + this.mPinchZoomController.getScale());
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) this.mShareViewPinchZoomView.getLayoutParams();
            params.height = size;
            params.width = size;
            this.mShareViewPinchZoomView.setLayoutParams(params);
            this.mShareViewPinchZoomGuideScaleText.setText(String.valueOf(Float.toString((this.mPinchZoomController.getScale() + 10) / 10)) + "x");
            sendShareViewCameraZoomToServer(this.mPinchZoomController.getScale());
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public void resizePinchZoomLayout() {
        if (this.mPinchZoomController != null) {
            resizePinchZoomLayout(this.mPinchZoomController.getSize());
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.common.controller.IPinchZoomController
    public void setVisibilityPinchZoomLayout(boolean isVisible) {
        if (isVisible) {
            this.mInnerHandler.removeMessages(2);
            this.mShareViewPinchZoomGuideLineLayout.setVisibility(0);
        } else {
            this.mInnerHandler.sendEmptyMessageDelayed(2, 800L);
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity
    public void initPinchZoomControllerSwitchCamera() {
        if (this.mShareViewCtrl.isActive()) {
            logI("initPinchZoomController()");
            disposePinchZoomController();
            if (this.mShareViewCtrl.isStarter() && getCameraToggle() == 666) {
                logI("PJS 10");
                logI("Pinch zoom controller: ON");
                this.mPinchZoomController = new PinchZoomController(this);
                this.mScaleGestureDetector = new ScaleGestureDetector(getApplicationContext(), this.mPinchZoomController);
                resizePinchZoomLayout(200);
                return;
            }
            logI("Pinch zoom controller: OFF");
        }
    }

    private void initPinchZoomController(boolean forceStart) {
        logI("initPinchZoomController(" + forceStart + ")");
        disposePinchZoomController();
        if (this.mShareViewCtrl.isStarter() && forceStart) {
            logI("Pinch zoom controller: ON");
            this.mPinchZoomController = new PinchZoomController(this);
            this.mScaleGestureDetector = new ScaleGestureDetector(getApplicationContext(), this.mPinchZoomController);
            resizePinchZoomLayout(200);
            return;
        }
        logI("Pinch zoom controller: OFF");
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public void disposePinchZoomController() {
        if (this.mPinchZoomController != null) {
            this.mPinchZoomController.dispose();
            this.mPinchZoomController = null;
        }
    }

    private void setCallButtonShareViewStart() {
        if (!this.mShareViewCtrl.isActive()) {
        }
    }

    private void setCallButtonShareViewEnd() {
        this.mCallBtnLayout.setHideme(this.mShareViewCtrl.getHidemeFlag());
        this.mCallBtnLayout.setUIState(this.mCallState, false, false);
    }

    private void setShareViewCamera(boolean isServiceStart) {
        logI("setShareViewCamera(" + isServiceStart + ")");
        if (this.mShareViewCtrl.isStarter() && this.mShareViewCtrl.getType() == 2) {
            if (isServiceStart) {
                if (getCameraToggle() == 444) {
                    this.mCallBtnLayout.onClick(this.mCallBtnLayout.findViewById(C0000R.id.camera_change_btn));
                    this.mShareViewCtrl.setFrontCamera(VideoCallActivity.CAMERA_VISIBLE_REAR);
                    return;
                } else {
                    initPinchZoomController(true);
                    this.mShareViewCtrl.setFrontCamera(VideoCallActivity.CAMERA_VISIBLE_FRONT);
                    return;
                }
            }
            if (this.mShareViewCtrl.isFrontCamera() != getCameraToggle()) {
                this.mCallBtnLayout.onClick(this.mCallBtnLayout.findViewById(C0000R.id.camera_change_btn));
            }
        }
    }

    private void updateShareViewZoomLayoutRotation() {
        if (this.mShareViewCtrl.isActive() && this.mShareViewCtrl.isFullScreen()) {
            logI("updateZoomLayout : to full screen");
            updateShareViewZoomLayout();
        }
    }

    private void updateShareViewZoomLayout() {
        if (this.mShareViewCtrl.isActive()) {
            this.mModelInfo.setIsFullScreen(this.mShareViewCtrl.isFullScreen());
            if (this.mVideoRepositionView != null) {
                this.mVideoRepositionView.setDeviceType(this.mModelInfo);
            }
            if (this.mShareViewCtrl.isFullScreen()) {
                logI("updateZoomLayout : to full screen");
                this.mShareViewZoomInButton.setVisibility(8);
                this.mShareViewZoomOutButton.setVisibility(0);
                if (!this.mIsOutGoingCall) {
                    this.mCallBtnLayout.setVisibility(8);
                }
                stretchShareViewForZoom();
                return;
            }
            logI("updateZoomLayout : to original screen");
            this.mShareViewZoomInButton.setVisibility(0);
            this.mShareViewZoomOutButton.setVisibility(8);
            if (!this.mIsOutGoingCall) {
                this.mCallBtnLayout.setVisibility(0);
            }
            contractShareViewForZoom();
            changedRemoteLayout(this.mIsOtherPartyLandscapeMode);
            if (!this.mIsOutGoingCall && CallState.isConnected(this.mCallState) && this.mOnlyBuddyLayout.getVisibility() != 0) {
                if (this.mImgPoint.x > 568) {
                    this.mImgPoint.x = 568;
                }
                changePreview(this.mImgPoint, false);
            }
        }
    }

    private void contractShareViewForZoom() {
        int rightMargin;
        int bottomMargin;
        logI("contractShareViewForZoom()");
        getScreenSize();
        if (getResources().getConfiguration().orientation == 1) {
            rightMargin = 0;
            bottomMargin = this.mModelInfo.getPortPaddingBottom();
        } else {
            rightMargin = this.mModelInfo.getLandPaddingRight();
            bottomMargin = 0;
            this.mRemoteVideoLayoutRadvision.getLayoutParams().width = this.mDisplayWidth - this.mModelInfo.getLandPaddingRight();
            FrameLayout statusBarLayout = (FrameLayout) findViewById(C0000R.id.video_call_status_bar_layout_id);
            FrameLayout.LayoutParams params2 = (FrameLayout.LayoutParams) statusBarLayout.getLayoutParams();
            params2.width = this.mDisplayWidth - this.mModelInfo.getLandPaddingRight();
            statusBarLayout.setLayoutParams(params2);
        }
        RelativeLayout layout = (RelativeLayout) findViewById(C0000R.id.share_view_btn_layout);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layout.getLayoutParams();
        params.bottomMargin = bottomMargin;
        params.rightMargin = rightMargin;
        layout.setLayoutParams(params);
        if (!this.mIsOutGoingCall && this.mSCameraSendFileLayout != null) {
            FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mSCameraSendFileLayout.getLayoutParams();
            param.width = (int) (446.0f * this.mDensity);
            this.mSCameraSendFileLayout.setLayoutParams(param);
        }
    }

    private void stretchShareViewForZoom() {
        logI("stretchShareViewForZoom()");
        getScreenSize();
        RelativeLayout layout = (RelativeLayout) findViewById(C0000R.id.share_view_btn_layout);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layout.getLayoutParams();
        params.bottomMargin = 0;
        params.rightMargin = 0;
        layout.setLayoutParams(params);
        if (getResources().getConfiguration().orientation == 2) {
            this.mRemoteVideoLayoutRadvision.getLayoutParams().width = this.mDisplayWidth;
        }
        FrameLayout statusBarLayout = (FrameLayout) findViewById(C0000R.id.video_call_status_bar_layout_id);
        FrameLayout.LayoutParams params2 = (FrameLayout.LayoutParams) statusBarLayout.getLayoutParams();
        params2.width = this.mDisplayWidth;
        statusBarLayout.setLayoutParams(params2);
        initRemoteSerface();
        FrameLayout.LayoutParams params3 = (FrameLayout.LayoutParams) this.mRemoteSurface.getLayoutParams();
        params3.width = this.mDisplayWidth;
        params3.height = this.mDisplayHeight;
        params3.gravity = 119;
        params3.setMargins(0, 0, 0, 0);
        this.mRemoteSurface.setLayoutParams(params3);
        this.mRemoteSurface.setPadding(0, 0, 0, 0);
        if (!this.mIsOutGoingCall && this.mSCameraSendFileLayout != null) {
            FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mSCameraSendFileLayout.getLayoutParams();
            param.width = this.mDisplayWidth;
            this.mSCameraSendFileLayout.setLayoutParams(param);
        }
    }

    public void shrinkShareViewForSCamera() {
        logI("shrinkShareViewForSCamera()");
        getScreenSize();
        if (getResources().getConfiguration().orientation == 2) {
            FrameLayout.LayoutParams frameParam = (FrameLayout.LayoutParams) this.mRemoteVideoLayoutRadvision.getLayoutParams();
            frameParam.width = (this.mDisplayHeight * 4) / 3;
            frameParam.gravity = 17;
        }
        initRemoteSerface();
        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mRemoteSurface.getLayoutParams();
        param.width = (this.mDisplayHeight * 4) / 3;
        param.height = this.mDisplayHeight;
        param.gravity = 17;
        param.setMargins(0, 0, 0, 0);
        this.mRemoteSurface.setLayoutParams(param);
        this.mRemoteSurface.setPadding(0, 0, 0, 0);
    }

    public void stretchShareViewForSCamera() {
        logI("stretchShareViewForSCamera()");
        getScreenSize();
        if (getResources().getConfiguration().orientation == 2) {
            FrameLayout.LayoutParams frameParam = (FrameLayout.LayoutParams) this.mRemoteVideoLayoutRadvision.getLayoutParams();
            frameParam.width = this.mDisplayWidth;
            frameParam.gravity = 119;
        }
        initRemoteSerface();
        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mRemoteSurface.getLayoutParams();
        param.width = this.mDisplayWidth;
        param.height = this.mDisplayHeight;
        param.gravity = 119;
        param.setMargins(0, 0, 0, 0);
        this.mRemoteSurface.setLayoutParams(param);
        this.mRemoteSurface.setPadding(0, 0, 0, 0);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public void onClickShareViewZoomInButton(View view) {
        logI("onClickShareViewZoomInButton now: " + this.mShareViewCtrl.isFullScreen() + " => true");
        this.mShareViewCtrl.setFullScreen(true);
        updateShareViewZoomLayout();
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public void onClickShareViewZoomOutButton(View view) {
        logI("onClickShareViewZoomOutButton now: " + this.mShareViewCtrl.isFullScreen() + " => false");
        this.mShareViewCtrl.setFullScreen(false);
        updateShareViewZoomLayout();
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity
    public void onClickShareViewCloseButton(View view) {
        logI("onClickShareViewCloseButton");
        sendShareViewEnd();
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void showToastForShareView(int kind, String rejectUserID) {
        String otherPartyName = this.mCalluserInfo.userName;
        switch (kind) {
            case 0:
                showToast(C0000R.string.share_view_toast_popup_1);
                break;
            case 1:
                showToast(C0000R.string.share_view_toast_popup_2);
                break;
            case 2:
                showToast(getString(C0000R.string.share_view_toast_popup_3, new Object[]{"'" + otherPartyName + "'"}));
                break;
            case 3:
                showToast(C0000R.string.share_view_toast_popup_4);
                break;
            case 4:
                showToast(C0000R.string.share_view_toast_popup_5);
                break;
            case 5:
                showToast(C0000R.string.share_view_toast_popup_6);
                break;
            case 7:
                showToast(getString(C0000R.string.share_view_toast_popup_7, new Object[]{otherPartyName}));
                break;
        }
    }

    private void sendShareViewCameraZoomToServer(int value) {
        logI("sendShareViewCameraZoomToServer: " + value);
        MainApplication.mPhoneManager.getPhoneStateMachine().sendCameraZoomInfo(value);
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.controller.IMemberViewController
    public void goneOtherViewForMemberView() {
        goneTopStatusBar();
        gonePreviewLayout();
        if (!this.mIsOutGoingCall) {
            this.mCallBtnLayout.setVisibility(8);
        }
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.controller.IMemberViewController
    public void showOtherViewForMemberView() {
        setSurfaceViewLayout();
        if (!this.mIsOutGoingCall) {
            this.mCallBtnLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChangeToConferenceStart() {
        showToast(C0000R.string.change_to_conference_start);
        logI("<<YHT101>>---------- handleChangeToConferenceStart ------------------");
        this.mIsChangeToConference = true;
        if (this.mBuddyImageOnly) {
            this.mOnlyBuddyLayout.setVisibility(8);
        }
        initPreviewPosition();
        if (this.mChanagePreview) {
            setViewGuideLineStatus(0, 1);
            setDefaultSurfaceView(true);
            setViewGuideLineStatus(1, 0);
        }
        setConferenceSurface(true, true);
        this.mMemberCount = getConferenceConnectCount();
    }

    private void initPreviewPosition() {
        this.mIsMovePreviewPosition = false;
        if (getResources().getConfiguration().orientation == 1) {
            this.mImgPoint = new Point(this.mPreviewPaddigLeft, this.mPreViewPaddingTop);
        } else {
            this.mImgPoint = new Point(this.mLandPreviewPaddigLeft, this.mLandPreViewPaddingTop);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChangeToConferenceFailure() {
        this.mIsChangeToConference = false;
        resizePreview2OriginalSize();
        this.mInviteViewCtrl.endInviteView();
        dismissChangeToConferenceDialog();
        showToast(C0000R.string.change_to_conference_fail);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChangeToConferenceFinish() {
        this.mIsChangeToConference = false;
        dismissChangeToConferenceDialog();
        showToast(C0000R.string.change_to_conference_finish);
        this.mMemberCount = -1;
    }

    private void setPreViewWhiteOutLine() {
        if (this.mChanagePreview) {
            setViewGuideLineStatus(0, 0);
            setViewGuideLineStatus(1, 1);
        } else {
            setViewGuideLineStatus(0, 1);
            setViewGuideLineStatus(1, 0);
        }
    }

    private void setViewGuideLineStatus(int previewStaut, int isRemote) {
        logI(" setViewGuideLineStatus previewStaut : " + previewStaut + " isRemote: " + isRemote);
        setPreviewGuideLineStatus(previewStaut, 3, isRemote);
    }

    public void hideStatusIcon() {
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.systemUiVisibility = 8;
        getWindow().setAttributes(params);
        getWindow().setFlags(1024, 1024);
    }

    public Bitmap getImage(String filePath) {
        Bitmap img;
        logI("getPortraitImage");
        if (filePath == null || filePath.isEmpty()) {
            return null;
        }
        try {
            BitmapFactory.Options sizeOpt = new BitmapFactory.Options();
            sizeOpt.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(filePath, sizeOpt);
            int width = sizeOpt.outWidth;
            int height = sizeOpt.outHeight;
            int scaleWidth = width / 45;
            int scaleHeight = height / 46;
            int rate = 1;
            if (scaleWidth > 1 || scaleHeight > 1) {
                rate = scaleWidth < scaleHeight ? scaleWidth : scaleHeight;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = rate;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inPurgeable = true;
            options.inDither = true;
            img = BitmapFactory.decodeFile(filePath, options);
        } catch (Exception e) {
            img = null;
            e.printStackTrace();
        }
        if (img != null) {
            return getRoundedCornerBitmap(BitmapResizePrc(img, 45, 46));
        }
        return null;
    }

    public Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, 4.0f, 4.0f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    private Bitmap BitmapResizePrc(Bitmap Src, int newWidth, int newHeight) {
        int width = Src.getWidth();
        int height = Src.getHeight();
        float scaleWidth = newWidth / width;
        float scaleHeight = newHeight / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(Src, 0, 0, width, height, matrix, true);
        resizedBitmap.getWidth();
        resizedBitmap.getHeight();
        return resizedBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeBottomButtonPosition() {
        if (this.mSCameraSendFileLayout != null) {
            LinearLayout recvImgLayout = (LinearLayout) findViewById(C0000R.id.scamera_received_img_layout);
            if (this.mSCameraSendFileLayout.getVisibility() == 0) {
                if (this.mOnlyBuddyLayout != null) {
                    FrameLayout.LayoutParams frameParam = (FrameLayout.LayoutParams) this.mOnlyBuddyLayout.getLayoutParams();
                    frameParam.bottomMargin = (int) (this.mDensity * 80.0f);
                    this.mOnlyBuddyLayout.setLayoutParams(frameParam);
                }
                if (recvImgLayout != null) {
                    FrameLayout.LayoutParams frameParam2 = (FrameLayout.LayoutParams) recvImgLayout.getLayoutParams();
                    frameParam2.bottomMargin = (int) (this.mDensity * 80.0f);
                    recvImgLayout.setLayoutParams(frameParam2);
                }
                if (!this.mIsOutGoingCall) {
                    RelativeLayout.LayoutParams relativeParam = (RelativeLayout.LayoutParams) this.mShareViewZoomOutButton.getLayoutParams();
                    relativeParam.bottomMargin = (int) (this.mDensity * 80.0f);
                    this.mShareViewZoomOutButton.setLayoutParams(relativeParam);
                    RelativeLayout.LayoutParams relativeParam2 = (RelativeLayout.LayoutParams) this.mShareViewZoomInButton.getLayoutParams();
                    relativeParam2.bottomMargin = (int) (this.mDensity * 80.0f);
                    this.mShareViewZoomInButton.setLayoutParams(relativeParam2);
                }
                this.mModelInfo.setIsBottomUp(true);
                if (this.mImgPoint.y > 320) {
                    this.mImgPoint.y = VLSpotterContext.DEFAULT_PHRASESPOT_PARAMB;
                }
            } else {
                if (this.mOnlyBuddyLayout != null) {
                    FrameLayout.LayoutParams frameParam3 = (FrameLayout.LayoutParams) this.mOnlyBuddyLayout.getLayoutParams();
                    frameParam3.bottomMargin = (int) (this.mDensity * 12.0f);
                    this.mOnlyBuddyLayout.setLayoutParams(frameParam3);
                }
                if (recvImgLayout != null) {
                    FrameLayout.LayoutParams frameParam4 = (FrameLayout.LayoutParams) recvImgLayout.getLayoutParams();
                    frameParam4.bottomMargin = (int) (this.mDensity * 12.0f);
                    recvImgLayout.setLayoutParams(frameParam4);
                }
                if (!this.mIsOutGoingCall) {
                    RelativeLayout.LayoutParams relativeParam3 = (RelativeLayout.LayoutParams) this.mShareViewZoomOutButton.getLayoutParams();
                    relativeParam3.bottomMargin = 0;
                    this.mShareViewZoomOutButton.setLayoutParams(relativeParam3);
                    RelativeLayout.LayoutParams relativeParam4 = (RelativeLayout.LayoutParams) this.mShareViewZoomInButton.getLayoutParams();
                    relativeParam4.bottomMargin = 0;
                    this.mShareViewZoomInButton.setLayoutParams(relativeParam4);
                }
                this.mModelInfo.setIsBottomUp(false);
            }
            if (this.mVideoRepositionView != null) {
                this.mVideoRepositionView.setDeviceType(this.mModelInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRecvImage(String filePath) {
        if (filePath != null && !filePath.isEmpty()) {
            this.mLastRecvFilePath = filePath;
            ((LinearLayout) this.mSCameraRecvImg.getParent()).setVisibility(0);
            this.mSCameraRecvImg.setImageBitmap(getImage(filePath));
            this.mSCameraRecvImg.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.26
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    if (LiveShareViewActivity.this.mLastRecvFilePath != null && !LiveShareViewActivity.this.mLastRecvFilePath.isEmpty()) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        File file = new File(LiveShareViewActivity.this.mLastRecvFilePath);
                        Uri.fromFile(file);
                        intent.setDataAndType(Uri.parse("file://" + file.getAbsolutePath()), "image/*");
                        LiveShareViewActivity.this.startActivity(intent);
                    }
                }
            });
            if (this.mOnlyBuddyLayout != null) {
                FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mOnlyBuddyLayout.getLayoutParams();
                param.leftMargin = (int) (73.0f * this.mDensity);
                this.mOnlyBuddyLayout.setLayoutParams(param);
            }
        }
    }

    public boolean captureMyImage(String fileName) {
        if (!FileUtil.statusOfSDCard()) {
            showToast(getResources().getString(MainApplication.mResources.getStringCheckExternalStorage()));
            return false;
        }
        if (!CallState.isConnected(this.mCallState)) {
            return false;
        }
        MainApplication.mPhoneManager.getPhoneStateMachine().captureMyImage(this.mDestination, fileName);
        logI("capture media scanning!!!!!!!!");
        return true;
    }

    public boolean startFileTransfer(ArrayList<String> fileNameList) {
        if (!CallState.isConnected(this.mCallState)) {
            return false;
        }
        MainApplication.mPhoneManager.getPhoneStateMachine().startFileTransfer(this.mDestination, fileNameList);
        return true;
    }

    public boolean stopFileTransfer() {
        if (!CallState.isConnected(this.mCallState)) {
            return false;
        }
        MainApplication.mPhoneManager.getPhoneStateMachine().stopFileTransfer(this.mDestination);
        return true;
    }

    public void setCameraZoomAction(int state) {
        MainApplication.mPhoneManager.getPhoneStateMachine().setCameraZoomAction(this.mDestination, state);
    }

    void initOutgoingCallLayout() {
        this.mSCameraOutgoingInfoLayout = (RelativeLayout) findViewById(C0000R.id.scamera_outgoing_info_layout);
        this.mSCameraOrgMenu = (LinearLayout) findViewById(C0000R.id.scamera_org_menu);
        this.mSCameraBack = (ImageView) findViewById(C0000R.id.scamera_call_back_img);
        this.mSCameraBack.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.27
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                LiveShareViewActivity.this.showDialog(LiveShareViewActivity.DIALOG_SCAMERA_CALL_END);
            }
        });
        this.mSCameraHome = (ImageView) findViewById(C0000R.id.scamera_indicator_home);
        this.mSCameraHome.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.28
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                new Thread(new Runnable() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.28.1
                    @Override // java.lang.Runnable
                    public void run() {
                        new Instrumentation().sendKeyDownUpSync(3);
                    }
                }).start();
            }
        });
        this.mSCameraMute = (Button) findViewById(C0000R.id.scamera_call_mute_img);
        if (!this.mIsConnected) {
            this.mSCameraMute.setEnabled(false);
        }
        this.mSCameraMute.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.29
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                LiveShareViewActivity.this.logI("onClick: video_mute_btn");
                CallStatusData callInfo = new CallStatusData();
                MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
                if (callInfo.getCallState() == 5) {
                    LiveShareViewActivity.this.stopMute();
                    LiveShareViewActivity.this.mSCameraMute.setBackgroundDrawable(LiveShareViewActivity.this.getBaseContext().getResources().getDrawable(C0000R.drawable.scamera_outgoing_call_mute));
                } else {
                    LiveShareViewActivity.this.startMute();
                    LiveShareViewActivity.this.mSCameraMute.setBackgroundDrawable(LiveShareViewActivity.this.getBaseContext().getResources().getDrawable(C0000R.drawable.scamera_outgoing_call_unmute));
                }
                LiveShareViewActivity.this.mInnerHandler.removeMessages(LiveShareViewActivity.SCAMERA_HIDE_ANIMATION_MENU_BAR);
                LiveShareViewActivity.this.mInnerHandler.sendEmptyMessageDelayed(LiveShareViewActivity.SCAMERA_HIDE_ANIMATION_MENU_BAR, 6000L);
            }
        });
        this.mSCameraVolumeBtnLayout = (Button) findViewById(C0000R.id.scamera_call_volume_img);
        this.mSCameraVolumeBtnLayout.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.30
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                LiveShareViewActivity.this.logI("SEC = " + LiveShareViewActivity.this.mAudioManager.getStreamVolume(12) + ", voice = " + LiveShareViewActivity.this.mAudioManager.getStreamVolume(0));
                if (LiveShareViewActivity.this.mSCameraVolumeUiLayout.getVisibility() == 0) {
                    LiveShareViewActivity.this.mSCameraVolumeUiLayout.setVisibility(4);
                } else {
                    LiveShareViewActivity.this.mSCameraVolumeUiLayout.setVisibility(0);
                    int val = (LiveShareViewActivity.this.mAudioManager.getStreamVolume(12) + 1) * 16;
                    if (val == 96) {
                        val = 100;
                    }
                    LiveShareViewActivity.this.mSCameraVolumeSeekBar.setProgressAndThumb(val);
                    LiveShareViewActivity.this.mInnerHandler.removeMessages(128);
                    LiveShareViewActivity.this.mInnerHandler.sendEmptyMessageDelayed(128, 2000L);
                }
                LiveShareViewActivity.this.mInnerHandler.removeMessages(LiveShareViewActivity.SCAMERA_HIDE_ANIMATION_MENU_BAR);
                LiveShareViewActivity.this.mInnerHandler.sendEmptyMessageDelayed(LiveShareViewActivity.SCAMERA_HIDE_ANIMATION_MENU_BAR, 6000L);
            }
        });
        this.mSCameraVolumeBtnLayout2 = (FrameLayout) findViewById(C0000R.id.scamera_indicator_volume_layout);
        this.mSCameraVolumeBtnLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.31
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                if (LiveShareViewActivity.this.mSCameraVolumeUiLayout.getVisibility() == 0) {
                    LiveShareViewActivity.this.mSCameraVolumeUiLayout.setVisibility(4);
                    return;
                }
                LiveShareViewActivity.this.mSCameraVolumeUiLayout.setVisibility(0);
                int val = (LiveShareViewActivity.this.mAudioManager.getStreamVolume(12) + 1) * 16;
                if (val == 96) {
                    val = 100;
                }
                LiveShareViewActivity.this.mSCameraVolumeSeekBar.setProgressAndThumb(val);
                LiveShareViewActivity.this.mInnerHandler.removeMessages(128);
                LiveShareViewActivity.this.mInnerHandler.sendEmptyMessageDelayed(128, 2000L);
            }
        });
        this.mSCameraVolumeUiLayout = (FrameLayout) findViewById(C0000R.id.scamera_volume_ui_layout);
        this.mSCameraVolumeUiLayout.setVisibility(4);
        this.mSCameraVolumeSeekBar = (HorizontalSeekBar) findViewById(C0000R.id.scamera_volume_seekbar);
        this.mSCameraVolumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.32
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int val = (progress / 16) - 1;
                LiveShareViewActivity.this.mAudioManager.setStreamVolume(0, val, 0);
                LiveShareViewActivity.this.mAudioManager.setStreamVolume(12, val, 0);
                LiveShareViewActivity.this.mInnerHandler.removeMessages(128);
                LiveShareViewActivity.this.mInnerHandler.sendEmptyMessageDelayed(128, 2000L);
                LiveShareViewActivity.this.mInnerHandler.removeMessages(LiveShareViewActivity.SCAMERA_HIDE_ANIMATION_MENU_BAR);
                LiveShareViewActivity.this.mInnerHandler.sendEmptyMessageDelayed(LiveShareViewActivity.SCAMERA_HIDE_ANIMATION_MENU_BAR, 6000L);
            }
        });
        this.mSCameraRecvImg = (ImageView) findViewById(C0000R.id.scamera_received_img);
        this.mSCameraSendingFileAnimation = (ImageView) findViewById(C0000R.id.scamera_sending_file_img);
        this.mFrameAnimation = (AnimationDrawable) this.mSCameraSendingFileAnimation.getBackground();
        this.mSCameraResolution = (Button) findViewById(C0000R.id.scamera_call_resolution_img);
        this.mSCameraResolution.setBackgroundDrawable(getBaseContext().getResources().getDrawable(C0000R.drawable.scamera_outgoing_call_resolution4_3));
        if (!this.mIsConnected) {
            this.mSCameraResolution.setEnabled(false);
        }
        this.mSCameraResolution.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.33
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                if (LiveShareViewActivity.this.mShareViewCtrl.isFullScreen()) {
                    LiveShareViewActivity.this.shrinkShareViewForSCamera();
                    LiveShareViewActivity.this.mSCameraResolution.setBackgroundDrawable(LiveShareViewActivity.this.getApplicationContext().getResources().getDrawable(C0000R.drawable.scamera_outgoing_call_resolution));
                } else {
                    LiveShareViewActivity.this.stretchShareViewForSCamera();
                    LiveShareViewActivity.this.mSCameraResolution.setBackgroundDrawable(LiveShareViewActivity.this.getApplicationContext().getResources().getDrawable(C0000R.drawable.scamera_outgoing_call_resolution4_3));
                }
                LiveShareViewActivity.this.mShareViewCtrl.setFullScreen(!LiveShareViewActivity.this.mShareViewCtrl.isFullScreen());
                LiveShareViewActivity.this.mInnerHandler.removeMessages(LiveShareViewActivity.SCAMERA_HIDE_ANIMATION_MENU_BAR);
                LiveShareViewActivity.this.mInnerHandler.sendEmptyMessageDelayed(LiveShareViewActivity.SCAMERA_HIDE_ANIMATION_MENU_BAR, 6000L);
            }
        });
        this.mSCameraArrowButton2 = (Button) findViewById(C0000R.id.scamera_arrowbutton2);
        this.mSCameraArrowButton2.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.34
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) throws Resources.NotFoundException {
                LiveShareViewActivity.this.mInnerHandler.removeMessages(LiveShareViewActivity.SCAMERA_HIDE_ANIMATION_MENU_BAR);
                LiveShareViewActivity.this.mInnerHandler.sendEmptyMessageDelayed(LiveShareViewActivity.SCAMERA_HIDE_ANIMATION_MENU_BAR, 6000L);
                LiveShareViewActivity.this.showAnimationMenu();
            }
        });
        this.mSCameraArrowButton = (Button) findViewById(C0000R.id.scamera_arrowbutton1);
        this.mSCameraArrowButton.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.35
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) throws Resources.NotFoundException {
                LiveShareViewActivity.this.mInnerHandler.removeMessages(LiveShareViewActivity.SCAMERA_HIDE_ANIMATION_MENU_BAR);
                LiveShareViewActivity.this.hideAnimationMenu();
            }
        });
        this.mSCameraName = (TextView) findViewById(C0000R.id.scamera_call_name);
        this.mSCameraName.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                LiveShareViewActivity.this.showDialog(LiveShareViewActivity.DIALOG_SCAMERA_CALL_END);
            }
        });
        this.mSCameraCallConnectedMsg = (StrokeTextView) findViewById(C0000R.id.scamera_call_connected_textview);
        this.mSCameraHidingMenuLayout = (LinearLayout) findViewById(C0000R.id.hiding_menu_linear_layout);
        this.mSCameraHidingMenuLayout_child = (LinearLayout) findViewById(C0000R.id.hiding_menu_linear_layout_child);
        this.mLoadingImage = (ImageView) findViewById(C0000R.id.scamera_loading_img);
        this.mConnAnimation = (AnimationDrawable) this.mLoadingImage.getBackground();
        this.mSCameraHidingMenuLayout.setVisibility(4);
        if (this.mIsOutGoingCall) {
            this.mSCameraOutgoingInfoLayout.setVisibility(0);
            this.mSCameraArrowButton2.setVisibility(0);
            this.mLoadingImage.setVisibility(0);
        } else {
            this.mSCameraOutgoingInfoLayout.setVisibility(8);
            this.mSCameraArrowButton2.setVisibility(8);
            this.mLoadingImage.setVisibility(8);
        }
        this.mSCameraElapsedTime = (Chronometer) findViewById(C0000R.id.scamera_status_time);
        if (this.mIsOutGoingCall) {
            this.mBatteryImageView = (ImageView) findViewById(C0000R.id.scamera_battery_icon);
            ((LinearLayout) findViewById(C0000R.id.scamera_mode_battery_layout)).setVisibility(0);
        }
        changeBottomButtonPosition();
    }

    private void callStartedOutgoingCallLayout() {
        this.mSCameraName.setText(getResources().getString(C0000R.string.scamera_outgoing_call));
        this.mConnAnimation.start();
    }

    public void callConnectedOutgoingCallLayout() {
        if (this.mConnAnimation != null) {
            this.mConnAnimation.stop();
        }
        if (this.mLoadingImage != null) {
            this.mLoadingImage.setVisibility(8);
        }
        if (this.mSCameraMute != null) {
            this.mSCameraMute.setEnabled(true);
        }
        if (this.mSCameraResolution != null) {
            this.mSCameraResolution.setEnabled(true);
        }
        this.mIsConnected = true;
        if (this.mSCameraName != null && this.mSCameraCallConnectedMsg != null) {
            this.mSCameraName.setVisibility(8);
            this.mSCameraCallConnectedMsg.setText(getResources().getString(C0000R.string.scamera_call_connected, this.mCalluserInfo.userName));
            this.mSCameraCallConnectedMsg.setVisibility(0);
        }
        if (this.mSCameraElapsedTime != null) {
            this.mSCameraElapsedTime.setVisibility(0);
            Date d = ((VAppPhoneManager) MainApplication.mPhoneManager).getPhoneStateMachine().getCallFirstStartTime();
            Date dNow = new Date();
            this.mSCameraElapsedTime.setBase(SystemClock.elapsedRealtime() - (dNow.getTime() - d.getTime()));
            this.mSCameraElapsedTime.start();
        }
    }

    void showAnimationMenu() throws Resources.NotFoundException {
        Animation move_in_animation = AnimationUtils.loadAnimation(this.mSCameraHidingMenuLayout.getContext(), C0000R.anim.move_in_effect);
        Animation fade_in_animation = AnimationUtils.loadAnimation(this.mSCameraHidingMenuLayout_child.getContext(), C0000R.anim.fade_in_effect);
        Animation spin_animation = AnimationUtils.loadAnimation(this.mSCameraArrowButton.getContext(), C0000R.anim.spin_effect_rev);
        Animation fade_out_animation = AnimationUtils.loadAnimation(this.mSCameraOrgMenu.getContext(), C0000R.anim.fade_out_effect);
        Animation.AnimationListener al2 = new Animation.AnimationListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.37
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation arg0) {
                LiveShareViewActivity.this.mSCameraOrgMenu.setVisibility(0);
                LiveShareViewActivity.this.mSCameraHidingMenuLayout.setVisibility(0);
                LiveShareViewActivity.this.mSCameraArrowButton2.setVisibility(8);
                LiveShareViewActivity.this.mSCameraArrowButton.setClickable(false);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation arg0) {
                LiveShareViewActivity.this.mSCameraArrowButton.setClickable(true);
                LiveShareViewActivity.this.mSCameraOrgMenu.setVisibility(4);
            }
        };
        move_in_animation.setAnimationListener(al2);
        this.mSCameraArrowButton.startAnimation(spin_animation);
        this.mSCameraHidingMenuLayout_child.startAnimation(fade_in_animation);
        this.mSCameraOrgMenu.startAnimation(fade_out_animation);
        this.mSCameraHidingMenuLayout.startAnimation(move_in_animation);
    }

    void hideAnimationMenu() throws Resources.NotFoundException {
        Animation move_out_animation = AnimationUtils.loadAnimation(this.mSCameraHidingMenuLayout.getContext(), C0000R.anim.move_out_effect);
        Animation fade_out_animation = AnimationUtils.loadAnimation(this.mSCameraHidingMenuLayout_child.getContext(), C0000R.anim.fade_out_effect);
        Animation spin_animation = AnimationUtils.loadAnimation(this.mSCameraArrowButton.getContext(), C0000R.anim.spin_effect);
        Animation fade_in_animation = AnimationUtils.loadAnimation(this.mSCameraOrgMenu.getContext(), C0000R.anim.fade_in_effect);
        Animation.AnimationListener al = new Animation.AnimationListener() { // from class: com.coolots.chaton.call.view.LiveShareViewActivity.38
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation arg0) {
                LiveShareViewActivity.this.mSCameraArrowButton.setClickable(false);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation arg0) {
                LiveShareViewActivity.this.mSCameraHidingMenuLayout.setVisibility(4);
                LiveShareViewActivity.this.mSCameraArrowButton2.setVisibility(0);
                LiveShareViewActivity.this.mSCameraOrgMenu.setVisibility(0);
            }
        };
        move_out_animation.setAnimationListener(al);
        this.mSCameraArrowButton.startAnimation(spin_animation);
        this.mSCameraHidingMenuLayout_child.startAnimation(fade_out_animation);
        this.mSCameraOrgMenu.startAnimation(fade_in_animation);
        this.mSCameraHidingMenuLayout.startAnimation(move_out_animation);
    }

    void disposeOutgoingCallLayout() {
        if (this.mSCameraBack != null) {
            this.mSCameraBack.removeCallbacks(null);
            this.mSCameraBack = null;
        }
        if (this.mSCameraHome != null) {
            this.mSCameraHome.removeCallbacks(null);
            this.mSCameraHome = null;
        }
        if (this.mSCameraHidingMenuLayout != null) {
            this.mSCameraHidingMenuLayout.removeAllViewsInLayout();
            this.mSCameraHidingMenuLayout = null;
        }
        if (this.mSCameraOrgMenu != null) {
            this.mSCameraOrgMenu.removeAllViewsInLayout();
            this.mSCameraOrgMenu = null;
        }
        if (this.mSCameraArrowButton != null) {
            this.mSCameraArrowButton.removeCallbacks(null);
            this.mSCameraArrowButton = null;
        }
        if (this.mSCameraArrowButton2 != null) {
            this.mSCameraArrowButton2.removeCallbacks(null);
            this.mSCameraArrowButton2 = null;
        }
        if (this.mSCameraMute != null) {
            this.mSCameraMute.removeCallbacks(null);
            this.mSCameraMute = null;
        }
        if (this.mSCameraResolution != null) {
            this.mSCameraResolution.removeCallbacks(null);
            this.mSCameraResolution = null;
        }
        if (this.mSCameraName != null) {
            this.mSCameraName.removeCallbacks(null);
            this.mSCameraName = null;
        }
        if (this.mSCameraCallConnectedMsg != null) {
            this.mSCameraCallConnectedMsg.removeCallbacks(null);
            this.mSCameraCallConnectedMsg = null;
        }
        if (this.mLoadingImage != null) {
            this.mLoadingImage.removeCallbacks(null);
            this.mLoadingImage = null;
        }
        if (this.mConnAnimation != null) {
            this.mConnAnimation.stop();
            this.mConnAnimation = null;
        }
        if (this.mSCameraElapsedTime != null) {
            this.mSCameraElapsedTime.removeCallbacks(null);
            this.mSCameraElapsedTime = null;
        }
        if (this.mSCameraHidingMenuLayout_child != null) {
            this.mSCameraHidingMenuLayout_child.removeAllViewsInLayout();
            this.mSCameraHidingMenuLayout_child = null;
        }
    }

    public void stopCallConnectedMsgOutgoingCallLayout() {
        if (this.mSCameraName != null && this.mSCameraCallConnectedMsg != null) {
            this.mSCameraCallConnectedMsg.setVisibility(8);
        }
    }

    public void hangupOutgoingCallLayout() {
        this.mSCameraElapsedTime.stop();
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity
    protected void startMemberView(VideoCallStatusBar videoCallStatusBar) {
        super.startMemberView(true);
        gonePreviewLayout();
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.coolots.chaton.call.view.ChatOnCallActivity
    protected void endMemberView() {
        super.endMemberView(true);
        showPreviewLayout();
    }

    @Override // com.coolots.chaton.call.view.VideoCallActivity, com.sds.coolots.call.view.CallActivity
    public void handleStartShareScreen() {
        super.handleStartShareScreen();
        if (!this.mSurfaceDestroyed) {
            this.mSurfaceDestroyed = true;
        }
    }
}
