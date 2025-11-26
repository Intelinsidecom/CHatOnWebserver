package com.coolots.chaton.call.view;

import android.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Instrumentation;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
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
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.SECConfig;
import com.coolots.chaton.buddy.model.BuddyListChildItem;
import com.coolots.chaton.call.controller.ChatONBlueTooth;
import com.coolots.chaton.call.controller.IInviteViewController;
import com.coolots.chaton.call.controller.IMemberViewController;
import com.coolots.chaton.call.controller.InviteViewController;
import com.coolots.chaton.call.controller.MemberViewController;
import com.coolots.chaton.call.controller.VideoShareViewController;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.model.VideoOptionMenuData;
import com.coolots.chaton.call.model.VideoShareViewRestoreData;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.coolots.chaton.call.util.BubbleTTSPlayer;
import com.coolots.chaton.call.util.ChatOnTranslationDataController;
import com.coolots.chaton.call.util.ITranslationTTSInterface;
import com.coolots.chaton.call.util.StaticsManager;
import com.coolots.chaton.call.util.TranslatorViewController;
import com.coolots.chaton.call.view.layout.AcceptCallCoveredLayout;
import com.coolots.chaton.call.view.layout.CallTranslatorScrollViewLayout;
import com.coolots.chaton.call.view.layout.EndedCallCoveredLayout;
import com.coolots.chaton.call.view.layout.EndedCallCoveredLayoutBig;
import com.coolots.chaton.call.view.layout.EndedCallCoveredWidget;
import com.coolots.chaton.call.view.layout.IncomingSlidingWidget;
import com.coolots.chaton.call.view.layout.VideoCallCoveredLayoutBig;
import com.coolots.chaton.call.view.layout.video.IVideoCallOptionMenu;
import com.coolots.chaton.call.view.layout.video.VideoCallAvatarOptionMenu;
import com.coolots.chaton.call.view.layout.video.VideoCallBtnLayout;
import com.coolots.chaton.call.view.layout.video.VideoCallCallerImageLayout;
import com.coolots.chaton.call.view.layout.video.VideoCallDrivingBtnLayout;
import com.coolots.chaton.call.view.layout.video.VideoCallEmotiAnimationLayout;
import com.coolots.chaton.call.view.layout.video.VideoCallOutgoingCallLayout;
import com.coolots.chaton.call.view.layout.video.VideoCallRepositionView;
import com.coolots.chaton.call.view.layout.video.VideoCallStatusBar;
import com.coolots.chaton.call.view.layout.video.VideoCallThemeShotLayout;
import com.coolots.chaton.call.view.layout.video.VideoCallTranslatorBtnLayout;
import com.coolots.chaton.call.view.layout.video.VideoCallTranslatorLayout;
import com.coolots.chaton.call.view.layout.voice.VoiceCallEndBtnLayout;
import com.coolots.chaton.common.controller.ChatONStatusBarController;
import com.coolots.chaton.common.controller.IPinchZoomController;
import com.coolots.chaton.common.controller.PinchZoomController;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.controller.translation.util.TranslationUtil;
import com.coolots.chaton.common.dialog.ContextDialogMenuBuilder;
import com.coolots.chaton.common.dialog.ContextDialogMenuInterface;
import com.coolots.chaton.common.util.ChatONDialog;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.coolots.chaton.common.util.ChatONTranslatorChangeLanguageDialog;
import com.coolots.chaton.common.util.ChatONTranslatorDialog;
import com.coolots.chaton.common.util.ChatOnConfigInterface;
import com.coolots.chaton.common.util.ChatOnService;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.coolots.chaton.common.view.layout.OptionMenuLayout;
import com.coolots.chaton.setting.data.ChatONHideMeImgData;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.sso.util.ChatONInterface;
import com.google.protobuf.CodedOutputStream;
import com.infraware.office.evengine.InterfaceC0507E;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.entitlement.EntitlementController;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.model.ConsentDisplayInfo;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.call.view.CallActivity;
import com.sds.coolots.common.controller.EngineCallBackInterface;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.model.CoolotsWakeLockList;
import com.sds.coolots.common.model.ErrorCode;
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
import java.util.Set;

/* loaded from: classes.dex */
public class VideoCallActivity extends ChatOnCallActivity implements SurfaceHolder.Callback2, DisposeInterface, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, Animation.AnimationListener, IPinchZoomController, IInviteViewController, IMemberViewController, ContextDialogMenuInterface, ITranslationTTSInterface {
    private static final int ACTIVITY_SATATUS_CREATE = 1;
    private static final int ACTIVITY_SATATUS_DESTROY = 4;
    private static final int ACTIVITY_SATATUS_NONE = -1;
    private static final int ACTIVITY_SATATUS_PAUSE = 3;
    private static final int ACTIVITY_SATATUS_RESUME = 2;
    private static final int ACTIVITY_SATATUS_USERLEAVEHINT = 5;
    private static final boolean APPLY_PREVIEW_GUIDE_LINE = true;
    public static final int CAMERA_VISIBLE_FRONT = 444;
    public static final int CAMERA_VISIBLE_REAR = 666;
    private static final String CLASSNAME = "[VideoCallActivity] ";
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
    private static final int DIALOG_SCAMERA_ZOOM_ERROR = 109;
    private static final int DIALOG_SHARE_SCREEN_CHANGE_VOICE = 111;
    private static final int DIALOG_SHARE_VIEW = 107;
    private static final int DISPLAY_CALL_END_BUTTON = 1;
    private static final int DISPLAY_CAPTURE_IMAGE = 9367;
    private static final int DISPLAY_CAPTURE_IMAGE_PREVIEW = 9368;
    private static final int DUAL_CAMERA_CHANGE_FINISH = 6;
    private static final int GONE_INVITE_AND_STATUS_BAR_MSG = 4;
    private static final int GONE_INVITE_BAR_MSG = 2;
    private static final int GONE_STATUS_BAR_MSG = 0;
    private static final int PINCH_ZOOM_DISMISS_GUIDLINE_DELAY = 2;
    private static final int PINCH_ZOOM_DISMISS_GUIDLINE_DELAY_TIME = 800;
    private static final int PREVIEW_OUTLINE = 0;
    private static final int PREVIEW_OUTLINE_MOVE = 2;
    private static final int PREVIEW_OUTLINE_NO = 0;
    private static final int PREVIEW_OUTLINE_WHITE = 1;
    private static final int REMOTEVIEW = 1;
    private static final int REMOTEVIEW_OUTLINE = 1;
    private static final int RESULT_INVITE_BUDDY_DONE = 1;
    private static final int SCREEN_AUTOBRIGHTNESS_OFF = 0;
    private static final int SCREEN_AUTOBRIGHTNESS_ON = 1;
    private static final int STOP_CAPTURE_IMAGE_ANIMATION = 9371;
    private static final int SURFACEVIEW = 0;
    private static final int TITLE_BAR_TIMER = 3000;
    private static final int TITLE_BAR_TIMER_FOR_INVITE = 500;
    private static final int TITLE_BAR_TIMER_IMMEDIATELY = 0;
    private static final int TOUCH_MIN_DISTANCE = 80;
    private static final int TRANSLATION_DEFAULT_TRANSLATED_LANGUAGE = 20;
    private static final int TRANSLATION_DEFAULT_VOICE_LANGUAGE = 10;
    private static final int TRANSLATOR_CHANGE_LANGUAGE_DIALOG = 999;
    private static final int TRANSLATOR_DIALOG = 99;
    private static final int TRANSLATOR_MENU_SIZE = 144;
    private static final int VCALL_REMOTE_SELECT_MODE = 202;
    private static final int VIEW_INVITE_BAR_MSG = 3;
    private static final int VIEW_STATUS_BAR_MSG = 1;
    private BubbleTTSPlayer mBubbleTTSPlayer;
    private VideoCallBtnLayout mCallBtnLayout;
    private VoiceCallEndBtnLayout mCallEndBtnLayout;
    private FrameLayout mCallInfoBGLayout;
    private VideoCallOutgoingCallLayout mCallOutgoingCallLayout;
    private IncomingSlidingWidget mCallReceiveBtnLayout;
    private VideoCallTranslatorBtnLayout mCallTranslatorBtnLayout;
    private VideoCallTranslatorLayout mCallTranslatorLayout;
    public CallTranslatorScrollViewLayout mCallTranslatorScrollViewLayout;
    private VideoCallCallerImageLayout mCallerImageLayout;
    public CallDisplayUserInfo mCalluserInfo;
    private ImageView mCaptureImage;
    private AnimationDrawable mCaptureImageAnimation;
    private EndedCallCoveredWidget mCoverEndCallLayout;
    private AcceptCallCoveredLayout mCoverRecieveLayout;
    private int mDisplayHeight;
    private int mDisplayWidth;
    private CountDownTimer mDualCameraTimer;
    private GestureDetector mGestureDetector;
    private SurfaceHolder mHolder;
    ImageView mImageCaptureAnimationImageView;
    private Point mImgPoint;
    private InviteViewMemberLayout mInviteviewMemberLayout;
    private int mMaxRemoteCnt;
    private Menu mMenu;
    private FrameLayout mOnlyBuddyLayout;
    private ImageView mOtherPartyCapture;
    private ViewGroup mRecordLayout;
    private Chronometer mRecordTime;
    private SurfaceHolder mRemoteHolder;
    private SurfaceView mRemoteSurface;
    private FrameLayout mRemoteVideoLayoutRadvision;
    private ScaleGestureDetector mScaleGestureDetector;
    private VideoShareViewController mShareViewCtrl;
    private TranslateAnimation mShareviewCloseBtnTrans;
    private SurfaceView mSurface;
    private FrameLayout mSurfaceViewlayout;
    private LinearLayout mSurfaceViewlayoutAnim;
    public TranslatorViewController mTranslatorViewController;
    private boolean mUseFrontCamera;
    private VideoCallAvatarOptionMenu mVideoCallAvatarOptionMenu;
    private VideoCallDrivingBtnLayout mVideoCallDrivingBtnLayout;
    private VideoCallEmotiAnimationLayout mVideoCallEmotiAnimationLayout;
    private IVideoCallOptionMenu mVideoCallOptionMng;
    private VideoCallStatusBar mVideoCallStatusBar;
    private VideoCallThemeShotLayout mVideoCallThemeShotLayout;
    private VideoCallRepositionView mVideoRepositionView;
    private FrameLayout mVideolayout;
    private static String mKeyBaseTime = "BASETIME";
    private static String mHideMeClicked = "HIDEMECLICKED";
    private static String mKeyRecordBaseTime = "RECBASETIME";
    private static String mEndBlinkCount = "ENDBLINkCOUNT";
    private static String mAlwaysMode = "ALWAYSMODE";
    private static String mStoreConfigInfo = "STORECONFIGINFO";
    private static String mPointStatus = "POINTSTATUS";
    private static String mAddGroupDialog = "ADDGROUPDIALOG";
    private static String mAddGroupName = "ADDGROUPNAME";
    private static String mIsMemberView = "MEMBERSVIEW";
    private static String mIsRequestRecording = "RECORDINGREQUEST";
    private static String mIsDualCamera = "DUALCAMERA";
    private static String mCartoonView = "CARTOONVIEW";
    private static String mIsInviteViewAnimationChecking = "INVITEANIMATION";
    private static Date mLastOrientationChangeDate = new Date();
    private int option_menu_mode = -1;
    private int mPrviewPaddingButton = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_OBJECT_POSITION_EVENT;
    private int mPreViewPaddingTop = 540;
    private int mPreviewPaddingRight = 24;
    private int mPreviewPaddigLeft = 24;
    private int mPreviewMarginButtom = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MIDDLE_ALIGN_EVENT;
    private int mLandPrviewPaddingButton = 18;
    private int mLandPreViewPaddingTop = 390;
    private int mLandPreviewPaddingRight = 386;
    private int mLandPreviewPaddigLeft = 540;
    private int mLandRemoteViewMarginButtom = 0;
    private int mLandPreviewFullHeight = 894;
    private int mLandPreviewFullWidth = 670;
    private int mStatusBarLength = 50;
    private int mHWGap = 40;
    public int mPreviewWidth = 256;
    public int mPreviewHeight = 336;
    private Dialog mTranslatorDialog = null;
    private Dialog mTranslatorChangeLanguageDialog = null;
    private boolean mIsRecording = false;
    private boolean mIsRecordRequested = false;
    private boolean mUseAlterImage = false;
    private boolean mPreAlterImage = false;
    private boolean mIsCartoonView = false;
    private boolean mSurfaceDestroyed = false;
    private SurfaceView[] mRemoteSurfaceArray = null;
    private SurfaceHolder[] mRemoteHolderArray = null;
    private int[] mRemoteRotationArray = null;
    private int[] mRemoteSurfaceIDArray = null;
    private boolean[] mIsRemoteDeactivatedArray = null;
    private boolean mIsLocalDeactivated = false;
    private MobileMCUImageView[] mRemoteImageView = null;
    private MobileMCUImageView mLocalImageView = null;
    private int mRemoteSurfacePos = 0;
    private int mVoiceActivityPos = -1;
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
    private Dialog mLayoutDialog = null;
    private Dialog mShareViewSelectDialog = null;
    private Dialog mSwitchLayoutDialog = null;
    private Dialog mPreviewSingleTabDialog = null;
    private Dialog mShareScreenAttentionDialog = null;
    private boolean mHangUpCall = false;
    private boolean mIsNativeCall = false;
    private int mNativeStauts = 0;
    private boolean mSpeakerOn = true;
    private boolean mIsShowMemberView = false;
    private int mConfigInfo = 0;
    private HashMap<String, Object> mBackUpObj = null;
    private HashMap<String, Object> mP2PBackUpObj = null;
    private boolean mChanagePreview = false;
    private boolean mBuddyImageOnly = false;
    private boolean mMyImageOnly = false;
    private boolean mRecordTimer = false;
    private boolean mIsTabDevice = false;
    private boolean mIsSpeaker = true;
    private int mIsBlueTooth = 0;
    private ContentObserver mContentObserver = null;
    public int mInitialBrightnessMode = 0;
    public int mAutomatic = 0;
    private int mHideMeModeType = 0;
    private Object hangupMutex = new Object();
    private ChatOnTranslationDataController mChatOnTranslationDataController = new ChatOnTranslationDataController();
    private int mActivityStatus = -1;
    private boolean mChangePreviewRotation = false;
    private boolean mIsOtherCapture = false;
    private boolean mIsQuickEndCall = false;
    private ViewGroup mShareViewLayout = null;
    private Button mShareViewCloseButtonUp = null;
    private Button mShareViewCloseButtonDown = null;
    private Button mShareViewZoomInButton = null;
    private Button mShareViewZoomOutButton = null;
    private boolean mReturnPreview = false;
    private boolean mShowRecordIcon = false;
    private PinchZoomController mPinchZoomController = null;
    private RelativeLayout mShareViewPinchZoomView = null;
    private ViewGroup mShareViewPinchZoomGuideLineLayout = null;
    private TextView mShareViewPinchZoomGuideScaleText = null;
    private VideoOptionMenuData mOptionMenuData = null;
    private Handler mTitleBarHandler = new TitleBarHandler();
    private boolean mIsPreviewAreaScroll = false;
    private boolean mIsLandscapeMode = false;
    private int mSwitchCameraState = CAMERA_VISIBLE_FRONT;
    private Dialog mContextDialog = null;
    private boolean mIsSCameraZoomError = false;
    private Object UIMutex = new Object();
    private InnerHandler mInnerHandler = new InnerHandler(this, null);
    private boolean mIsPowerLongPressed = false;
    public WindowManager windowManager = null;
    private boolean mAlreadyDenied = false;
    private InputMethodManager imm = null;
    private int mSavedPreviewWidth = 0;
    private int mSavedPreviewHeight = 0;
    private int mSavedPreviewMarginTop = 0;
    private int mSavedPreviewMarginLeft = 0;
    private int mSavedPreviewMarginRight = 0;
    private int mSavedPreviewMarginBottom = 0;

    @Override // com.sds.coolots.call.view.CallActivity, com.sds.coolots.call.CallingInterface
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

    public void onCreate(Bundle savedInstanceState, boolean callFromChild) {
        super.onCreate(savedInstanceState);
    }

    public void onConfigurationChanged(Configuration newConfig, boolean callFromChild) {
        super.onConfigurationChanged(newConfig);
    }

    protected void onNewIntent(Intent intent, boolean callFromChild) {
        super.onNewIntent(intent);
    }

    protected void onResume(boolean callFromChild) {
        super.onResume();
    }

    protected void onPause(boolean callFromChild) {
        super.onPause();
    }

    protected void onUserLeaveHint(boolean callFromChild) {
        super.onUserLeaveHint();
    }

    protected void onDestroy(boolean callFromChild) {
        super.onDestroy();
    }

    public void checkCallInstanceNRefresh(boolean callFromChild) {
        super.checkCallInstanceNRefresh();
    }

    public boolean onKeyUp(int keyCode, KeyEvent event, boolean callFromChild) {
        return super.onKeyUp(keyCode, event);
    }

    public boolean onKeyDown(int arg0, KeyEvent arg1, boolean callFromChild) {
        return super.onKeyDown(arg0, arg1);
    }

    public boolean onPrepareOptionsMenu(Menu menu, boolean callFromChild) {
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item, boolean callFromChild) {
        return super.onOptionsItemSelected(item);
    }

    public void dispose(boolean callFromChild) {
        super.dispose();
    }

    public boolean onTouchEvent(MotionEvent event, boolean callFromChild) {
        return super.onTouchEvent(event);
    }

    protected Dialog onCreateDialog(int menuID, boolean callFromChild) {
        return super.onCreateDialog(menuID);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data, boolean callFromChild) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    protected void startMemberView(boolean callFromChild) {
        super.startMemberView(this.mVideoCallStatusBar);
    }

    protected void endMemberView(boolean callFromChild) {
        super.endMemberView();
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, com.sds.coolots.call.view.CallActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws Throwable {
        logI("onCreate()++++++++++++++++++++++++++++++++++++++++++++++++++ ");
        if (MainApplication.mPhoneManager.isConfTest()) {
            this.mMaxRemoteCnt = ((ChatOnConfigInterface) MainApplication.mConfig).getConferenceCallMaxPeopleNum(true) - 1;
            if (this.mRemoteSurfaceArray == null) {
                this.mRemoteSurfaceArray = new SurfaceView[this.mMaxRemoteCnt];
                for (int i = 0; i < this.mMaxRemoteCnt; i++) {
                    this.mRemoteSurfaceArray[i] = null;
                }
            }
            if (this.mRemoteHolderArray == null) {
                this.mRemoteHolderArray = new SurfaceHolder[this.mMaxRemoteCnt];
                for (int i2 = 0; i2 < this.mMaxRemoteCnt; i2++) {
                    this.mRemoteHolderArray[i2] = null;
                }
            }
            if (this.mRemoteRotationArray == null) {
                this.mRemoteRotationArray = new int[this.mMaxRemoteCnt];
                for (int i3 = 0; i3 < this.mMaxRemoteCnt; i3++) {
                    this.mRemoteRotationArray[i3] = 0;
                }
            }
            if (this.mRemoteSurfaceIDArray == null) {
                this.mRemoteSurfaceIDArray = new int[this.mMaxRemoteCnt];
                for (int i4 = 0; i4 < this.mMaxRemoteCnt; i4++) {
                    this.mRemoteSurfaceIDArray[i4] = i4;
                }
            }
            if (this.mIsRemoteDeactivatedArray == null) {
                this.mIsRemoteDeactivatedArray = new boolean[this.mMaxRemoteCnt];
                for (int i5 = 0; i5 < this.mMaxRemoteCnt; i5++) {
                    this.mIsRemoteDeactivatedArray[i5] = false;
                }
            }
            logI("onCreate() mRemoteImageView = " + this.mRemoteImageView + ", mRemoteSurfacePos = " + this.mRemoteSurfacePos + ", mVoiceActivityPos = " + this.mVoiceActivityPos);
            if (this.mRemoteImageView == null) {
                this.mRemoteImageView = new MobileMCUImageView[this.mMaxRemoteCnt];
                for (int i6 = 0; i6 < this.mMaxRemoteCnt; i6++) {
                    this.mRemoteImageView[i6] = null;
                }
            }
        }
        this.mActivityStatus = 1;
        this.mHandler = new VideoCallHandler(this);
        if (getIntent().getIntExtra(EventCode.EVENT_IDENTIFIER, -1) == 7300) {
            this.mHandler.sendEmptyMessage(EventCode.EVENT_CALL_ACTION);
        }
        super.onCreate(savedInstanceState);
        if (checkCallInstance() == 1) {
            finish();
            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                overridePendingTransition(0, 0);
                return;
            }
            return;
        }
        if (ModelInfoUtil.IS_MODEL_SCAMERA) {
            setContentView(C0000R.layout.scamera_video_call);
        } else {
            setContentView(C0000R.layout.video_call);
        }
        getWindow().getDecorView().setSystemUiVisibility(CodedOutputStream.DEFAULT_BUFFER_SIZE);
        initActivity();
        hidekeyboard();
        this.mCountConnectedState = 0;
        this.mHideMeModeType = 0;
        this.mHangUpCall = false;
        if (getCallFunctionController().getCallSwitchingProcessing() == 2) {
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximityOnlyVideoCall();
        }
        try {
            this.mInitialBrightnessMode = Settings.System.getInt(getBaseContext().getContentResolver(), "screen_brightness_mode");
            this.mAutomatic = this.mInitialBrightnessMode;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        Uri brightnessModeUri = Settings.System.getUriFor("screen_brightness_mode");
        this.mContentObserver = new ContentObserver(new Handler()) { // from class: com.coolots.chaton.call.view.VideoCallActivity.1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                if (VideoCallActivity.this.mAutomatic == 0) {
                    VideoCallActivity.this.mAutomatic = 1;
                    VideoCallActivity.this.logI("Auto brightness mode on!!");
                } else {
                    VideoCallActivity.this.mAutomatic = 0;
                    VideoCallActivity.this.logI("Auto brightness mode off!!");
                }
                super.onChange(selfChange);
            }
        };
        getBaseContext().getContentResolver().registerContentObserver(brightnessModeUri, true, this.mContentObserver);
        logI("onCreate()--------------------------------------------------");
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        synchronized (this.UIMutex) {
            logI("Do_Something in onConfigurationChanged!!!!!!!!!!!!!!!!!!!!");
            logI("onConfigurationChanged()");
            saveData();
            disposeForChanginRotation();
            this.mReturnPreview = true;
            this.mMemberCount = getConferenceConnectCount();
            setPreviewSize();
            if (newConfig.orientation == 1) {
                logI("ORIENTATION_PORTRAIT is called!!!!!!!!");
                if (ModelInfoUtil.IS_MODEL_SCAMERA) {
                    setContentView(C0000R.layout.scamera_video_call);
                } else {
                    setContentView(C0000R.layout.video_call);
                }
                this.mIsLandscapeMode = false;
                initView();
                setHideMeOrientation();
                setPORTRAITChangedPreview();
                updateUIComponent();
                showAddDialog();
            } else if (newConfig.orientation == 2) {
                if (ModelInfoUtil.IS_MODEL_SCAMERA) {
                    setContentView(C0000R.layout.scamera_video_call);
                } else {
                    setContentView(C0000R.layout.video_call);
                }
                logI("ORIENTATION_LANDSCAPE is called!!!!!!!!");
                this.mIsLandscapeMode = true;
                initView();
                setHideMeOrientation();
                setLANDSCAPEChangedPreview();
                updateUIComponent();
                showAddDialog();
            }
            getScreenSize();
            initLayout();
            if (this.mVideoRepositionView != null) {
                this.mVideoRepositionView.setChangePointStatus(this.mImgPoint, this.mChanagePreview, this.mDisplayWidth, this.mDisplayHeight);
            }
            updateShareViewZoomLayoutRotation();
            if (this.mIsShowMemberView) {
                startMemberView(this.mVideoCallStatusBar);
                this.mVideoCallStatusBar.unClickableStatusBarFuctionBtn();
            }
            setPreViewWhiteOutLine();
            if (this.mShareViewCtrl.isActive()) {
                setSurfaceZOrderOnTop();
            }
            if (this.mUseDualCamera) {
                setDualPositionForDualPosition(true);
            }
            if (this.mMenu != null && this.mMenu.hasVisibleItems()) {
                closeOptionsMenu();
                this.mMenu = null;
                openMenu();
            }
            super.onConfigurationChanged(newConfig);
        }
    }

    private void setPreviewSize() {
        if (getResources().getConfiguration().orientation == 1) {
            this.mPreviewHeight = this.mModelInfo.getPreviewHeight();
            this.mPreviewWidth = this.mModelInfo.getPreviewWidth();
        } else {
            this.mPreviewHeight = this.mModelInfo.getLandPreviewHeight();
            this.mPreviewWidth = this.mModelInfo.getLandPreviewWidth();
        }
    }

    public void openMenu() {
        try {
            new Thread(new Runnable() { // from class: com.coolots.chaton.call.view.VideoCallActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    KeyEvent event = new KeyEvent(0, 82);
                    new Instrumentation().sendKeySync(event);
                    KeyEvent event2 = new KeyEvent(1, 82);
                    new Instrumentation().sendKeySync(event2);
                }
            }).start();
        } catch (Exception ex) {
            logE("open Menu :" + ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSurfaceZOrderOnTop() {
        logI("setZOrderOnTop");
        if (CallState.isConnected(this.mCallState)) {
            this.mSurfaceViewlayout.removeView(this.mSurface);
            this.mSurface.setZOrderOnTop(true);
            this.mSurfaceViewlayout.addView(this.mSurface);
        }
    }

    public void setSurfaceZOrderMediaOverlay() {
        logI("settingSurfaceOverlay");
        this.mSurfaceViewlayout.removeView(this.mSurface);
        this.mSurface.setZOrderMediaOverlay(true);
        this.mSurfaceViewlayout.addView(this.mSurface);
    }

    private void initLayout() throws Throwable {
        logI("initLayout()");
        if (!CallState.isNotConnected(this.mCallState)) {
            if (MainApplication.mPhoneManager.isConfTest() && CallState.isConnected(this.mCallState)) {
                setMobileMCULayout(false);
            } else {
                setSECPreviewPosition(false);
                updatePreviewLayout(false);
            }
        }
    }

    private void setLANDSCAPEChangedPreview() {
        int pointY;
        logI("setLANDSCAPEChangedPreview()");
        if (this.mIsTranslatorOptionMenuEnable) {
            this.mIsMovePreviewPosition = false;
        }
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
            initPreviewPosition(false);
        }
        if (this.mIsOtherCapture) {
            finishCaptureImgShow();
        }
    }

    private void setPORTRAITChangedPreview() {
        logI("setPORTRAITChangedPreview()");
        if (this.mIsTranslatorOptionMenuEnable) {
            this.mIsMovePreviewPosition = false;
        }
        if (this.mIsMovePreviewPosition) {
            int pointY = this.mImgPoint.x;
            if (pointY < this.mModelInfo.getPortRepositonTopMargin()) {
                pointY = this.mModelInfo.getPortRepositonTopMargin();
            }
            int imsiX = this.mLandPreviewFullWidth - (this.mImgPoint.y + this.mPreviewWidth);
            if (imsiX < 0) {
                imsiX = 0;
            }
            this.mImgPoint.x = imsiX;
            this.mImgPoint.y = pointY;
        } else {
            initPreviewPosition(false);
        }
        if (this.mIsOtherCapture) {
            finishCaptureImgShow();
        }
    }

    private void restoreData() throws Throwable {
        logI("restoreData()");
        if (this.mBackUpObj != null) {
            HashMap<String, Object> hMap = (HashMap) this.mBackUpObj.clone();
            logI("<CIH> hMap = " + hMap);
            logI("<CIH> mKeyBaseTime = " + hMap.get(mKeyBaseTime));
            if (hMap != null) {
                Integer tempINT = (Integer) hMap.get(mStoreConfigInfo);
                if (tempINT != null) {
                    this.mConfigInfo = tempINT.intValue();
                }
                Boolean tempBool = (Boolean) hMap.get(mHideMeClicked);
                boolean isHideMe = false;
                if (tempBool != null) {
                    isHideMe = tempBool.booleanValue();
                }
                if (CallState.isConnected(this.mCallState)) {
                    this.mCallBtnLayout.setRecordBtnStatus(this.mIsRecording);
                    MainApplication.mPhoneManager.isTranslateTest();
                    this.mVideoCallStatusBar.setCallBaseTime((Long) hMap.get(mKeyBaseTime));
                    this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
                    MainApplication.mPhoneManager.isTranslateTest();
                    if (this.mIsRecording) {
                        this.mRecordLayout.setVisibility(0);
                        Boolean tempBool2 = (Boolean) hMap.get(mIsRequestRecording);
                        if (tempBool2 != null) {
                            this.mIsRecordRequested = tempBool2.booleanValue();
                        }
                        logI("restoreData(): " + this.mIsRecordRequested);
                        if (this.mIsRecordRequested) {
                            setHideMeForCaptureRecord(false);
                        } else {
                            setOtherBuddyHideImageForCaptureRecord(false);
                        }
                        setLayoutRecordBaseTime((Long) hMap.get(mKeyRecordBaseTime));
                    }
                    if (this.mVideoCallOptionMng.isShowingAnyMenu()) {
                        if (this.mVideoCallOptionMng.getStatus() == 2) {
                            this.mVideoCallOptionMng.changeStatus(2);
                        } else if (this.mVideoCallOptionMng.getStatus() == 3) {
                            this.mVideoCallOptionMng.changeStatus(3);
                        } else {
                            this.mVideoCallOptionMng.setAlwaysMode((Boolean) hMap.get(mAlwaysMode));
                            this.mVideoCallOptionMng.changeStatus(1);
                        }
                        if (!this.mShareViewCtrl.isActive()) {
                            this.mVideoCallOptionMng.showOptionMenu();
                        }
                    } else {
                        this.mVideoCallOptionMng.changeStatus(0);
                    }
                    if (isHideMe) {
                        setHideMeOrientation();
                    }
                    Boolean tempBool3 = (Boolean) hMap.get(mIsDualCamera);
                    if (tempBool3 != null) {
                        this.mUseDualCamera = tempBool3.booleanValue();
                    }
                    this.mImgPoint = (Point) hMap.get(mPointStatus);
                    Boolean tempBool4 = (Boolean) hMap.get(mIsMemberView);
                    if (tempBool4 != null) {
                        boolean isMemberView = tempBool4.booleanValue();
                        this.mIsShowMemberView = isMemberView;
                    }
                } else if (CallState.isDisconnected(this.mCallState)) {
                    this.mVideoCallStatusBar.setCallBaseTime((Long) hMap.get(mKeyBaseTime));
                    Integer tempINT2 = (Integer) hMap.get(mEndBlinkCount);
                    if (tempINT2 != null) {
                        this.mCallOutgoingCallLayout.setTimeBlinkCount(tempINT2.intValue());
                    }
                }
                if (CallState.isNotConnected(this.mCallState) && isHideMe) {
                    setHideMe();
                }
            }
        }
    }

    public void saveData() {
        logI("saveData()");
        HashMap<String, Object> hMap = new HashMap<>();
        hMap.put(mKeyBaseTime, this.mVideoCallStatusBar.getCallBaseTime());
        hMap.put(mKeyRecordBaseTime, Long.valueOf(this.mRecordTime.getBase()));
        hMap.put(mHideMeClicked, Boolean.valueOf(this.mUseAlterImage));
        hMap.put(mEndBlinkCount, Integer.valueOf(this.mCallOutgoingCallLayout.getTimeBlinkCount()));
        hMap.put(mAlwaysMode, Boolean.valueOf(this.mVideoCallOptionMng.isAlwaysMode()));
        hMap.put(mStoreConfigInfo, Integer.valueOf(this.mConfigInfo));
        hMap.put(mPointStatus, this.mImgPoint);
        hMap.put(mAddGroupDialog, Boolean.valueOf(this.mCallEndBtnLayout.isAddGroupDialog()));
        hMap.put(mAddGroupName, this.mCallEndBtnLayout.getNewAddGroup());
        hMap.put(mIsMemberView, Boolean.valueOf(this.mMemberViewCtrl.ismMemberViewActive()));
        hMap.put(mIsRequestRecording, Boolean.valueOf(this.mIsRecordRequested));
        hMap.put(mIsDualCamera, Boolean.valueOf(this.mUseDualCamera));
        this.mBackUpObj = (HashMap) hMap.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveConferenceData() {
        logI("saveConferenceData()");
        if (this.mP2PBackUpObj == null) {
            this.mP2PBackUpObj = new HashMap<>();
        }
        HashMap<String, Object> hMap = new HashMap<>();
        hMap.put(mHideMeClicked, Boolean.valueOf(this.mUseAlterImage));
        hMap.put(mCartoonView, Boolean.valueOf(this.mIsCartoonView));
        hMap.put(mAlwaysMode, Boolean.valueOf(this.mVideoCallOptionMng.isAlwaysMode()));
        hMap.put(mIsDualCamera, Boolean.valueOf(this.mUseDualCamera));
        logI("hmap-  mUseAlterImage: " + this.mUseAlterImage + " mUseDualCamera: " + this.mUseDualCamera);
        logI("hmap - mVideoCallOptionMenu.isAlwaysMode(): " + this.mVideoCallOptionMng.isAlwaysMode());
        this.mP2PBackUpObj = (HashMap) hMap.clone();
    }

    private void showAddDialog() {
        HashMap<String, Object> hMap;
        if (this.mBackUpObj != null && (hMap = this.mBackUpObj) != null && CallState.isDisconnected(this.mCallState)) {
            boolean isAddDialog = ((Boolean) hMap.get(mAddGroupDialog)).booleanValue();
            if (isAddDialog) {
                cancelDelayedQuit();
                String groupName = (String) hMap.get(mAddGroupName);
                if (this.mCallEndBtnLayout == null) {
                    this.mCallEndBtnLayout = (VoiceCallEndBtnLayout) findViewById(C0000R.id.video_call_endbtn);
                }
                this.mCallEndBtnLayout.setData(this.mDestination, this, this.mCalluserInfo.userNo);
                this.mCallEndBtnLayout.showDialogAddGroupName(groupName);
            }
        }
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, android.app.Activity
    protected void onNewIntent(Intent intent) throws Throwable {
        logI("onNewIntent()++");
        super.onNewIntent(intent);
        this.mInnerHandler.removeMessages(1);
        dismissVideoDialog();
        closeOptionsMenu();
        this.mMenu = null;
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
        if (this.mUseAlterImage) {
            setDefaultHideMeImage();
        }
    }

    private void resetLayoutData() throws Throwable {
        logI("resetLayoutData()");
        this.mCalluserInfo = getCallOtherPartyUserInfo();
        if (this.mCoverRecieveLayout != null) {
            this.mCoverRecieveLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination.getDestinationType(), this);
            this.mCoverRecieveLayout.setMember(this.mDestination, this.mCalluserInfo);
        }
        if (this.mCallerImageLayout != null) {
            this.mCallerImageLayout.initLayout(this.mDestination, this.mCalluserInfo, this);
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
            }
            this.mCallOutgoingCallLayout.initLayout(this.mDestination, false, this.mCalluserInfo, this, this);
        }
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.setHangUpButtonToggle(true);
        }
        if (this.mVideoCallOptionMng != null) {
            this.mVideoCallOptionMng.setParent(this, this.mIsLandscapeMode);
        }
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, com.sds.coolots.call.view.CallActivity, android.app.Activity
    protected void onResume() throws Throwable {
        logI("onResume()++");
        this.mActivityStatus = 2;
        this.mIsQuickEndCall = false;
        this.mUseAlterImage = MainApplication.mPhoneManager.getPhoneStateMachine().getHideState();
        this.mSavedOrientation = getSystemBarOrientation();
        setHideMeOrientation();
        this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
        this.mCoverRecieveLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination.getDestinationType(), this);
        this.mCoverRecieveLayout.setMember(this.mDestination, this.mCalluserInfo);
        this.mCoverEndCallLayout.setCallType(false);
        MainApplication.mPhoneManager.isTranslateTest();
        MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().acquireScreenBrightWakeLock(CoolotsWakeLockList.WAKELOCK_TAG_VIDEO_CALL);
        if (this.mAutomatic == 1) {
            this.bTurnOnScrAB = true;
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
        } else if (this.mAudioPathController.isBlueToothOn()) {
            onBTButton();
            disableSpeakerButton();
        }
        super.onResume();
        logI("onResume()--");
        if (MainApplication.mPhoneManager.getClientType() != 2) {
            startOutGoingCallForEngine();
        }
    }

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

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, com.sds.coolots.call.view.CallActivity, android.app.Activity
    protected void onPause() {
        logI("onPause()++");
        this.mActivityStatus = 3;
        super.onPause();
        this.mConfigInfo = getChangingConfigurations();
        MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releasePartialWakeLock(CoolotsWakeLockList.WAKELOCK_TAG_VIDEO_CALL);
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, android.app.Activity
    protected void onUserLeaveHint() {
        logI("haeri=onUserLeaveHint()");
        this.mIsInitAngle = false;
        this.mActivityStatus = 5;
        super.onUserLeaveHint();
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, com.sds.coolots.call.view.CallActivity, android.app.Activity
    protected void onDestroy() {
        logI("onDestroy()++");
        this.mActivityStatus = 4;
        getBaseContext().getContentResolver().unregisterContentObserver(this.mContentObserver);
        dispose();
        super.onDestroy();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void initActivity() throws Throwable {
        logI("initActivity()++++++++++++++++++++++++++");
        getScreenSize();
        setPreviewSize();
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
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        if (getResources().getConfiguration().orientation == 1) {
            this.mImgPoint = new Point(this.mPreviewPaddigLeft, this.mPreViewPaddingTop);
        } else {
            this.mImgPoint = new Point(this.mLandPreviewPaddigLeft, this.mLandPreViewPaddingTop);
        }
        checkCallInstanceNRefresh();
        if (this.mVideoCallOptionMng != null) {
            this.mVideoCallOptionMng.resetAnimationData();
        }
        logI("initActivity()--------------------------");
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

    private void initView() throws Throwable {
        logI("initView()++++++++++++++++++++++");
        this.mCallBtnLayout = (VideoCallBtnLayout) findViewById(C0000R.id.video_call_btn);
        if (MainApplication.mPhoneManager.isTranslateTest()) {
            this.mCallTranslatorLayout = (VideoCallTranslatorLayout) findViewById(C0000R.id.video_call_translator_layout);
        }
        this.mCallEndBtnLayout = (VoiceCallEndBtnLayout) findViewById(C0000R.id.video_call_endbtn);
        this.mVideoCallDrivingBtnLayout = (VideoCallDrivingBtnLayout) findViewById(C0000R.id.video_call_driving_btn);
        this.mVideoCallDrivingBtnLayout.setParent(this);
        this.mVideoCallDrivingBtnLayout.setCallMode(this.mIsOutGoingCall);
        this.mCallReceiveBtnLayout = (IncomingSlidingWidget) findViewById(C0000R.id.video_call_receive_btn);
        this.mVideolayout = (FrameLayout) findViewById(C0000R.id.video_layout);
        this.mCallerImageLayout = (VideoCallCallerImageLayout) findViewById(C0000R.id.video_caller_image);
        this.mCallInfoBGLayout = (FrameLayout) findViewById(C0000R.id.video_call_info_bottom);
        this.mCallOutgoingCallLayout = (VideoCallOutgoingCallLayout) findViewById(C0000R.id.video_call_outgoing);
        this.mVideoCallStatusBar = (VideoCallStatusBar) findViewById(C0000R.id.video_call_status_view);
        this.mInviteviewMemberLayout = (InviteViewMemberLayout) findViewById(C0000R.id.video_call_inviteview_member);
        this.mRemoteVideoLayoutRadvision = (FrameLayout) findViewById(C0000R.id.radvision_video_layout);
        this.mSurfaceViewlayout = (FrameLayout) findViewById(C0000R.id.surface_view_layout);
        this.mSurfaceViewlayoutAnim = (LinearLayout) findViewById(C0000R.id.surface_view_anim);
        if (ModelInfoUtil.IS_MODEL_H) {
            this.mCoverRecieveLayout = (VideoCallCoveredLayoutBig) findViewById(C0000R.id.video_call_accept_cover_h);
        } else {
            this.mCoverRecieveLayout = (AcceptCallCoveredLayout) findViewById(C0000R.id.video_call_accept_cover);
        }
        if (ModelInfoUtil.IS_MODEL_H) {
            this.mCoverEndCallLayout = (EndedCallCoveredLayoutBig) findViewById(C0000R.id.video_call_ended_cover_h);
        } else {
            this.mCoverEndCallLayout = (EndedCallCoveredLayout) findViewById(C0000R.id.video_call_ended_cover);
        }
        this.mVideoCallEmotiAnimationLayout = (VideoCallEmotiAnimationLayout) findViewById(C0000R.id.video_emoti_animation_layout);
        this.mVideoCallThemeShotLayout = (VideoCallThemeShotLayout) findViewById(C0000R.id.video_theme_shot_layout);
        this.mVideoCallAvatarOptionMenu = (VideoCallAvatarOptionMenu) findViewById(C0000R.id.avatar_option_layout);
        if (this.mVideoCallOptionMng == null) {
            this.mVideoCallOptionMng = new IVideoCallOptionMenu(this);
        }
        this.mVideoCallOptionMng.setOptionMenuItems(this.mVideoCallEmotiAnimationLayout, this.mVideoCallThemeShotLayout, this.mVideoCallAvatarOptionMenu);
        this.mVideoCallOptionMng.setParent(this, this.mIsLandscapeMode);
        this.mShareViewLayout = (ViewGroup) findViewById(C0000R.id.video_share_view_layout);
        this.mShareViewCloseButtonUp = (Button) this.mShareViewLayout.findViewById(C0000R.id.share_view_btn_close_up);
        this.mShareViewCloseButtonDown = (Button) this.mShareViewLayout.findViewById(C0000R.id.share_view_btn_close_down);
        this.mShareViewZoomInButton = (Button) this.mShareViewLayout.findViewById(C0000R.id.share_view_btn_zoom_in);
        this.mShareViewZoomOutButton = (Button) this.mShareViewLayout.findViewById(C0000R.id.share_view_btn_zoom_out);
        this.mShareViewPinchZoomGuideLineLayout = (ViewGroup) findViewById(C0000R.id.video_call_camera_guideline_layout);
        this.mShareViewPinchZoomView = (RelativeLayout) this.mShareViewPinchZoomGuideLineLayout.findViewById(C0000R.id.camera_guide_line_resize_layout);
        this.mShareViewPinchZoomGuideScaleText = (TextView) this.mShareViewPinchZoomGuideLineLayout.findViewById(C0000R.id.video_call_camera_guideline_scale_text);
        this.mShareViewPinchZoomGuideLineLayout.setVisibility(8);
        this.mMemberViewLayout = (ViewGroup) findViewById(C0000R.id.video_call_member_layout);
        this.mMemberViewLayout.setVisibility(8);
        if (PhoneManager.getMediaEngineType() == 2 || PhoneManager.getMediaEngineType() == 1) {
            this.mRemoteVideoLayoutRadvision.setVisibility(0);
            this.mSurfaceViewlayout.setVisibility(0);
        }
        this.mRecordLayout = (ViewGroup) findViewById(C0000R.id.record_status_bar);
        this.mRecordTime = (Chronometer) findViewById(C0000R.id.record_status_time);
        if (this.mDualCameraTimer == null) {
            this.mDualCameraTimer = new CountDownTimer(Config.REPLY_TIMEOUT, 1000L) { // from class: com.coolots.chaton.call.view.VideoCallActivity.3
                @Override // android.os.CountDownTimer
                public void onTick(long milliUnitFinished) {
                    if (milliUnitFinished / 1000 == 60) {
                        VideoCallActivity.this.showLongToast(C0000R.string.call_menu_dual_camera_revert_to_single_camera_mode);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    VideoCallActivity.this.mDualCameraTimer.cancel();
                    VideoCallActivity.this.stopDualCamera();
                }
            };
        }
        if (this.mUseVideo) {
            this.mSurface = (SurfaceView) findViewById(C0000R.id.surface_view);
            this.mSurface.setVisibility(0);
            this.mHolder = this.mSurface.getHolder();
            this.mHolder.addCallback(this);
            this.mHolder.setType(3);
            if (PhoneManager.getMediaEngineType() == 2 || PhoneManager.getMediaEngineType() == 1) {
                if (MainApplication.mPhoneManager.isConfTest()) {
                    this.mRemoteSurfaceArray[0] = (SurfaceView) findViewById(C0000R.id.omx_video_view);
                    this.mRemoteHolderArray[0] = this.mRemoteSurfaceArray[0].getHolder();
                    this.mRemoteHolderArray[0].addCallback(this);
                    this.mRemoteHolderArray[0].setType(3);
                    this.mRemoteSurface = this.mRemoteSurfaceArray[0];
                    this.mRemoteHolder = this.mRemoteHolderArray[0];
                    this.mRemoteSurfacePos = 0;
                    if (this.mRemoteImageView[0] == null) {
                        this.mRemoteImageView[0] = new MobileMCUImageView(this);
                    }
                    this.mRemoteVideoLayoutRadvision.addView(this.mRemoteImageView[0]);
                    if (this.mLocalImageView == null) {
                        this.mLocalImageView = new MobileMCUImageView(this);
                    }
                    this.mLocalImageView.setUserInfo("", "My Image");
                    this.mRemoteVideoLayoutRadvision.addView(this.mLocalImageView);
                    for (int i = 1; i < this.mMaxRemoteCnt; i++) {
                        this.mRemoteSurfaceArray[i] = new SurfaceView(this);
                        this.mRemoteHolderArray[i] = this.mRemoteSurfaceArray[i].getHolder();
                        this.mRemoteHolderArray[i].addCallback(this);
                        this.mRemoteHolderArray[i].setType(3);
                        this.mRemoteVideoLayoutRadvision.addView(this.mRemoteSurfaceArray[i]);
                        this.mRemoteSurfaceArray[i].setZOrderMediaOverlay(true);
                        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) this.mRemoteSurfaceArray[i].getLayoutParams();
                        params.gravity = 51;
                        params.width = 5;
                        params.height = 5;
                        params.topMargin = 0;
                        params.leftMargin = 0;
                        params.bottomMargin = 0;
                        this.mRemoteSurfaceArray[i].setLayoutParams(params);
                        logI("initView() mRemoteImageView = " + this.mRemoteImageView + ", mRemoteSurfacePos = " + this.mRemoteSurfacePos + ", mVoiceActivityPos = " + this.mVoiceActivityPos);
                        if (this.mRemoteImageView[i] == null) {
                            this.mRemoteImageView[i] = new MobileMCUImageView(this);
                        }
                        this.mRemoteVideoLayoutRadvision.addView(this.mRemoteImageView[i]);
                    }
                } else {
                    this.mRemoteSurface = (SurfaceView) findViewById(C0000R.id.omx_video_view);
                    this.mRemoteSurface.setVisibility(0);
                    this.mRemoteHolder = this.mRemoteSurface.getHolder();
                    this.mRemoteHolder.addCallback(this);
                    this.mRemoteHolder.setType(3);
                }
            }
            this.mSurface.setZOrderMediaOverlay(true);
            this.mRemoteSurface.setZOrderMediaOverlay(false);
        }
        this.mCalluserInfo = getCallOtherPartyUserInfo();
        this.mCallerImageLayout.initLayout(this.mDestination, this.mCalluserInfo, this);
        this.mVideoCallStatusBar.initLayout(this.mDestination, this.mCalluserInfo, this, this);
        this.mMemberViewCtrl = new MemberViewController(this, this, this.mMemberViewLayout);
        this.mCallOutgoingCallLayout.initLayout(this.mDestination, false, this.mCalluserInfo, this, this);
        this.mCallBtnLayout.setParent(this);
        initDualCameraPreviewInfo(this);
        if (MainApplication.mPhoneManager.isTranslateTest()) {
            this.mCallTranslatorLayout.setParent(this);
            this.mCallTranslatorScrollViewLayout = (CallTranslatorScrollViewLayout) findViewById(C0000R.id.video_call_translator_content_id);
            if (this.mIsTranslatorOptionMenuEnable) {
                translatorChagneUi(this.mIsTranslatorOptionMenuEnable);
                initTranslatorViewController();
            } else {
                this.mCallTranslatorLayout.setVisibility(8);
                this.mCallTranslatorScrollViewLayout.setVisibility(8);
            }
        }
        this.mCallReceiveBtnLayout.initialize(this, this.mDestination, this.mCalluserInfo);
        this.mCoverRecieveLayout.initialize();
        this.mCoverEndCallLayout.initialize(this.mDestination, this);
        this.mVideoRepositionView = (VideoCallRepositionView) findViewById(C0000R.id.reposition_view);
        this.mVideoRepositionView.setParent(this);
        this.mVideoRepositionView.setDeviceType(this.mModelInfo);
        this.mOnlyBuddyLayout = (FrameLayout) findViewById(C0000R.id.indicator_view_layout);
        this.mOnlyBuddyLayout.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) throws Throwable {
                VideoCallActivity.this.logI("OnClickListener() mOnlyBuddyLayout");
                boolean mTemp = VideoCallActivity.this.mBuddyImageOnly;
                VideoCallActivity.this.changeLayoutRemoteSingleTab();
                if (mTemp) {
                    VideoCallActivity.this.setSurfaceZOrderOnTop();
                }
            }
        });
        this.mOtherPartyCapture = (ImageView) findViewById(C0000R.id.capture_video_view);
        this.mCaptureImage = (ImageView) findViewById(C0000R.id.capture_video_preview);
        this.mImageCaptureAnimationImageView = (ImageView) findViewById(C0000R.id.image_capture_animation_far_end);
        prepareCaptureAnimation();
        restoreData();
        logI("initView()++++++++++++++++++++++");
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public boolean checkCallInstanceNRefresh() throws Throwable {
        logI("callInstanceRefresh()");
        super.checkCallInstanceNRefresh();
        resetLayoutData();
        return true;
    }

    private void setDefaultHideMeImage() throws Throwable {
        checkCallInstanceNRefresh();
        makeHideMeImage();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void updateUIComponent() throws Throwable {
        logI("updateUIComponent()++: " + this.mCallStatusData.isCallTransforming());
        if (MainApplication.mCallNotification.showQuickPanel()) {
            MainApplication.mCallNotification.showCallButtonNotification();
        }
        if (this.mCallState == 5) {
            notifyMute();
        } else {
            cancelMute();
        }
        if (this.mShareViewCtrl.isActive()) {
            showShareViewBtn();
            resizePinchZoomLayout();
        } else {
            goneShareViewBtn();
            disposePinchZoomController();
        }
        updateCallState();
        updateSurfaceViewLayout();
        if (CallState.isNotConnected(this.mCallState)) {
            logI("CallState: NotConnected");
            if (this.mAudioPathController == null) {
                logI("mAudioPathController == null");
                return;
            }
            if (this.mAudioPathController.isBlueToothOn()) {
                onBTButton();
                disableSpeakerButton();
            }
            if (this.mAudioPathController.isSpeakerON()) {
                notifySpeakerphone();
            }
            StaticsManager.getInstance().initBeforeCallStart();
            updateAlertsOnCall(true);
            checkHookingHomeKey(!this.mIsOutGoingCall);
            checkHookingPowerKey(!this.mIsOutGoingCall);
            sendRotationInfoToServer(this.mSavedOrientation, true);
            this.mVideolayout.setVisibility(0);
            this.mCallEndBtnLayout.setVisibility(8);
            this.mCallerImageLayout.setVisibility(8);
            setViewGuideLineStatus(0, 0);
            setViewGuideLineStatus(0, 1);
            if (this.mBackUpObj == null) {
                setShowMe();
            }
            if (this.mIsOutGoingCall) {
                if (isCoverOpen()) {
                    this.mCallOutgoingCallLayout.setVisibility(0);
                    this.mCallBtnLayout.setVisibility(0);
                    this.mCoverRecieveLayout.setVisibility(8);
                } else {
                    this.mCallOutgoingCallLayout.setVisibility(8);
                    this.mCallBtnLayout.setVisibility(8);
                    this.mCoverRecieveLayout.setVisibility(0);
                    this.mCoverRecieveLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination.getDestinationType(), this);
                    this.mCoverRecieveLayout.setMember(this.mDestination, this.mCalluserInfo);
                }
                this.mCallReceiveBtnLayout.setVisibility(8);
                this.mCoverEndCallLayout.setVisibility(8);
            } else {
                disableCoverLockUI(1000);
                if (getResources().getConfiguration().orientation == 2) {
                    setLandScapeIncomingPreview();
                }
                if (!ChatONSettingData.getInstance().isOwnVideo()) {
                    makeHideMeImage();
                    this.mCallOutgoingCallLayout.setHideMeBtn(true);
                }
                this.mCallBtnLayout.setVisibility(8);
                if (isCoverOpen()) {
                    if (isDrivingModeUIOn()) {
                        this.mVideoCallDrivingBtnLayout.setVisibility(0);
                        this.mCallInfoBGLayout.setVisibility(8);
                        this.mCoverRecieveLayout.setVisibility(8);
                    } else {
                        this.mVideoCallDrivingBtnLayout.setVisibility(8);
                        this.mCallReceiveBtnLayout.setVisibility(0);
                        this.mCallInfoBGLayout.setVisibility(0);
                    }
                    this.mCallOutgoingCallLayout.setVisibility(0);
                    this.mCallOutgoingCallLayout.setHideMeBtn(this.mUseAlterImage);
                    this.mCallOutgoingCallLayout.sendAccessibilityEvent();
                    this.mCoverRecieveLayout.setVisibility(8);
                } else {
                    this.mCoverRecieveLayout.setVisibility(0);
                    this.mCoverRecieveLayout.setClearCoverActive(this.mCalluserInfo, getResources().getString(C0000R.string.call_info_incoming_video_call), false);
                    this.mCoverRecieveLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination.getDestinationType(), this);
                    this.mCoverRecieveLayout.setMember(this.mDestination, this.mCalluserInfo);
                    this.mCoverRecieveLayout.sendAccessibilityEvent();
                    this.mCallReceiveBtnLayout.setVisibility(8);
                    this.mCallOutgoingCallLayout.setVisibility(8);
                    this.mCallInfoBGLayout.setVisibility(8);
                }
                this.mCoverEndCallLayout.setVisibility(8);
                showCallIncomingAnimation();
            }
            this.mInviteViewCtrl = new InviteViewController(this, this, this.mInviteviewMemberLayout.getInviteViewLayout(), this.mInviteviewMemberLayout.getInviteListView());
            this.mInviteViewCtrl.stop();
            checkWaitMemberForInviteView();
            updateMemberCount();
            viewInviteView();
            if (!this.mIsOutGoingCall) {
                if (isLowBattery()) {
                    hangupCallWithQuickDestroy(getResources().getText(C0000R.string.video_low_battery).toString());
                    return;
                }
                if (MainApplication.mConfig.isUseWifiOnly() && !PhoneManager.isWifiNetworkConnected(MainApplication.mContext)) {
                    hangupCallWithQuickDestroy(getResources().getText(C0000R.string.video_call_wifi_only_mode).toString());
                    return;
                }
                if (EntitlementController.isATNTDevice() && !this.mIsOutGoingCall && !PhoneManager.isWifiNetworkConnected(MainApplication.mContext)) {
                    showToast(C0000R.string.atnt_entitlement_incoming_alert_msg, EventCode.EVENT_CONF_MAKE_SUCCESS);
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
            if (this.mAudioPathController == null) {
                logI("mAudioPathController == null");
                return;
            }
            checkHookingHomeKey(false);
            checkHookingPowerKey(true);
            changeCoverLockUI(true);
            if (this.mAudioPathController.isWatch()) {
                boolean isCallAcceptedByBargeIn = false;
                if (this.mBargeInController != null) {
                    isCallAcceptedByBargeIn = this.mBargeInController.isAcceptByVoice();
                    hideVoiceControlUserGuide();
                    this.mBargeInController.dispose();
                    this.mBargeInController = null;
                }
                if (this.mCountConnectedState == 0) {
                    this.mAudioPathController.initCallConnectedForWatch(true, isCallAcceptedByBargeIn);
                }
            } else {
                if (this.mAudioPathController.isBlueToothOn()) {
                    onBTButton();
                    disableSpeakerButton();
                }
                if (this.mBargeInController != null) {
                    if (this.mBargeInController.isAcceptByVoice()) {
                        this.mAudioPathController.initCallConnectedByBargeIn(true);
                    }
                    hideVoiceControlUserGuide();
                    this.mBargeInController.dispose();
                    this.mBargeInController = null;
                }
            }
            sendRotationInfoToServer(this.mSavedOrientation, true);
            if (isCoverOpen()) {
                if (!this.mVideoCallOptionMng.isShowingAnyMenu()) {
                    this.mVideoCallStatusBar.setVisibility(0);
                }
                this.mVideolayout.setVisibility(0);
                this.mCoverRecieveLayout.setVisibility(8);
            } else {
                this.mVideoCallStatusBar.setVisibility(8);
                this.mVideolayout.setVisibility(8);
                this.mCoverRecieveLayout.setVisibility(0);
                this.mCoverRecieveLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination.getDestinationType(), this);
                this.mCoverRecieveLayout.setMember(this.mDestination, this.mCalluserInfo);
            }
            this.mCallOutgoingCallLayout.setVisibility(8);
            this.mCallInfoBGLayout.setVisibility(8);
            this.mCallBtnLayout.setHideme(this.mUseAlterImage);
            this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
            this.mCallBtnLayout.setVisibility(this.mShareViewCtrl.isFullScreen() ? 8 : 0);
            MainApplication.mPhoneManager.isTranslateTest();
            setCallButtonShareViewStart();
            this.mCallEndBtnLayout.setVisibility(8);
            this.mCallReceiveBtnLayout.setVisibility(8);
            this.mCoverEndCallLayout.setVisibility(8);
            this.mCallerImageLayout.setVisibility(8);
            this.mVideoCallDrivingBtnLayout.setVisibility(8);
            if (MainApplication.mPhoneManager.isTranslateTest()) {
                if (this.mIsTranslatorOptionMenuEnable) {
                    this.mCallTranslatorLayout.setVisibility(0);
                } else {
                    this.mCallTranslatorLayout.setVisibility(8);
                }
            }
            setConferenceSurface(isConference(), false);
            this.mInviteViewCtrl = new InviteViewController(this, this, this.mInviteviewMemberLayout.getInviteViewLayout(), this.mInviteviewMemberLayout.getInviteListView());
            this.mInviteViewCtrl.stop();
            checkWaitMemberForInviteView();
            updateMemberCount();
            if (isCoverOpen()) {
                viewTopStatusBar();
                viewInviteView();
            }
            if (isConference() && showNetworkWeakPopup()) {
                showToast(C0000R.string.popup_msg_network_weak_during_videocall_atnt, 5000);
                setNetworkWeakPopupExist(false);
            }
            setPreViewWhiteOutLine();
            if (this.mMemberViewCtrl.ismMemberViewActive()) {
                gonePreviewLayout();
            }
            updatePreviewLayout(false);
            this.mCountConnectedState++;
        } else if (CallState.isDisconnected(this.mCallState)) {
            StaticsManager.getInstance().saveVideoFunctionFlags();
            if (MainApplication.mPhoneManager.isTranslateTest()) {
                closeSTTTranslationTTS(false);
                this.mCallTranslatorLayout.setVisibility(8);
                this.mCallTranslatorScrollViewLayout.setVisibility(8);
            }
            logI("CallState: Disconnected");
            notifyCallEndToOtherActivity();
            dismissCallConsentProcessingDialog();
            this.mHangUpCall = true;
            SystemClock.sleep(200L);
            updateAlertsOnCall(false);
            checkHookingPowerKey(false);
            checkHookingPowerKey(false);
            cancelSpeakerphone();
            cancelBTHeadset();
            if (this.mCountConnectedState == 0) {
                if (this.mIsOutGoingCall) {
                    if (!this.mIsSCameraZoomError) {
                        settingEndCall();
                    }
                } else {
                    quitActivity();
                }
            } else if (!this.mIsSCameraZoomError) {
                settingEndCall();
            }
            this.mSurfaceViewlayout.removeView(this.mSurface);
            this.mRemoteVideoLayoutRadvision.removeAllViewsInLayout();
            if (this.mDualCameraTimer != null) {
                this.mDualCameraTimer.cancel();
            }
            if (this.mIsRecording && this.mIsRecordRequested) {
                setRecord();
                showToast(getResources().getString(C0000R.string.video_complete_record));
            }
            checkNetworkDisconnect();
        }
        logI("updateUIComponent()--");
    }

    private void setConferenceSurface(boolean isConference, boolean forceConference) throws Throwable {
        if (SECConfig.isUseFrontCamera(isConference)) {
            logI("<<YHT101>>-------------------SECConfig.isUseFrontCamera(is_conference)-------------------");
            if (this.mDestination.getDestinationType() == 4 || forceConference) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) this.mRemoteSurface.getLayoutParams();
                params.gravity = 119;
                params.width = -1;
                params.height = -1;
                if (getResources().getConfiguration().orientation == 1) {
                    params.topMargin = this.mModelInfo.getCallStatusBarHeight();
                    params.bottomMargin = this.mModelInfo.getPortPaddingBottom();
                    params.rightMargin = 0;
                } else {
                    params.topMargin = 0;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void settingEndCall() {
        logI("settingEndCall()");
        this.mCallEndBtnLayout.videoCallRetryButtonToggle(true);
        if (getResources().getConfiguration().orientation == 2) {
            this.mVideoCallStatusBar.hideStatusBar();
            removeStatusbarAnimation();
            this.mVideoCallStatusBar.cancelAnimation();
        }
        this.mSurfaceViewlayout.setVisibility(8);
        this.mVideoCallStatusBar.hideStatusBar();
        this.mInviteviewMemberLayout.hideInviteView();
        this.mRemoteVideoLayoutRadvision.setVisibility(8);
        this.mSurface.setVisibility(8);
        this.mRemoteSurface.setVisibility(8);
        if (MainApplication.mPhoneManager.isConfTest()) {
            for (int i = 0; i < this.mMaxRemoteCnt; i++) {
                if (this.mRemoteSurfaceArray[i] != null) {
                    this.mRemoteSurfaceArray[i].setVisibility(8);
                }
            }
        }
        if (this.mInviteViewCtrl != null) {
            this.mInviteViewCtrl.endInviteView();
        }
        endMemberView();
        endShareView();
        videoCallEndUIDisplaybeforeCamrelease();
        delayedQuit();
    }

    private void updateCallState() {
        logI("updateCallState()");
        this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
        this.mCoverRecieveLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination.getDestinationType(), this);
        MainApplication.mPhoneManager.isTranslateTest();
        this.mVideoCallStatusBar.setUIState(this.mCallState);
    }

    public void updateLayoutChangeDestination() {
        logI("updateLayoutChangeDestination()");
        this.mCallOutgoingCallLayout.initLayout(this.mDestination, false, this.mCalluserInfo, this, this);
        this.mVideoCallStatusBar.initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPreviewPositionForConferenceCall() throws Throwable {
        if (!CallState.isNotConnected(this.mCallState)) {
            int newMember = getConferenceConnectCount();
            logI("checkPreviewPositinoForConferenceCall : mMemberCount: " + this.mMemberCount + " newMember: " + newMember);
            if (this.mMemberCount != -1 && this.mMemberCount < newMember) {
                initPreviewPosition(false);
                switchAutoModePreviewPosition();
                if (this.mChanagePreview) {
                    setViewGuideLineStatus(0, 1);
                    setDefaultSurfaceView(true);
                    setViewGuideLineStatus(1, 0);
                }
                setConferenceSurface(true, true);
            }
            this.mMemberCount = newMember;
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

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.coolots.chaton.call.view.ChatOnCallHandler, com.sds.coolots.call.view.CallHandler, android.os.Handler
        public void handleMessage(Message msg) throws Throwable {
            int surfID;
            VideoCallActivity.this.logI("VideoCallHandler handleMessage(" + msg + ")");
            if (this.bDisposed) {
                VideoCallActivity.this.logI("VideoCallHandler was disposed. so this message is going to be ignored.");
                return;
            }
            switch (msg.what) {
                case 10:
                    VideoCallActivity.this.logI("MSG_DELAYED_QUIT");
                    VideoCallActivity.this.changeCoverLockUI(false);
                    break;
                case EventCode.EVENT_CONF_UPDATE_MEMBER /* 7004 */:
                    VideoCallActivity.this.logI("EventCode.EVENT_CONF_UPDATE_MEMBER");
                    VideoCallActivity.this.mDestination = (Destination) msg.obj;
                    VideoCallActivity.this.updateLayoutChangeDestination();
                    VideoCallActivity.this.checkInviteView();
                    VideoCallActivity.this.checkMemberView();
                    VideoCallActivity.this.checkPreviewPositionForConferenceCall();
                    if (MainApplication.mPhoneManager.isConfTest()) {
                        int connectCount = VideoCallActivity.this.getConferenceConnectCount();
                        VideoCallActivity.this.logI("connectCount = " + connectCount);
                        if (VideoCallActivity.this.mDestination.getDestinationType() == 5 && CallState.isConnected(VideoCallActivity.this.mCallState) && connectCount > 0) {
                            String myUserID = MainApplication.mConfig.getProfileUserID();
                            int pos = 0;
                            Iterator it = VideoCallActivity.this.mDestination.getP2PConferenceMember().iterator();
                            while (it.hasNext()) {
                                P2PUserInfo member = (P2PUserInfo) it.next();
                                if (!myUserID.equals(member.userID) && 1 == member.userState) {
                                    VideoCallActivity.this.logI("pos = " + pos + ", surfID = " + (member.surfaceID - 1));
                                    if (member.surfaceID > 200) {
                                        int[] iArr = VideoCallActivity.this.mRemoteSurfaceIDArray;
                                        surfID = member.surfaceID - 201;
                                        iArr[pos] = surfID;
                                        if (!VideoCallActivity.this.mIsLocalDeactivated) {
                                            VideoCallActivity.this.mIsLocalDeactivated = true;
                                        }
                                        VideoCallActivity.this.mIsRemoteDeactivatedArray[surfID] = true;
                                        VideoCallActivity.this.mRemoteImageView[surfID].setUserInfo(member.userID, member.userName);
                                    } else if (member.surfaceID > 100) {
                                        int[] iArr2 = VideoCallActivity.this.mRemoteSurfaceIDArray;
                                        surfID = member.surfaceID + ErrorCode.ERROR_LOGIN_NO_NUMBER;
                                        iArr2[pos] = surfID;
                                        VideoCallActivity.this.mIsRemoteDeactivatedArray[surfID] = true;
                                        VideoCallActivity.this.mRemoteImageView[surfID].setUserInfo(member.userID, member.userName);
                                    } else {
                                        int[] iArr3 = VideoCallActivity.this.mRemoteSurfaceIDArray;
                                        surfID = member.surfaceID - 1;
                                        iArr3[pos] = surfID;
                                        VideoCallActivity.this.mIsRemoteDeactivatedArray[surfID] = false;
                                    }
                                    VideoCallActivity.this.logI("mIsLocalDeactivated = " + VideoCallActivity.this.mIsLocalDeactivated + ", mRemoteSurfaceIDArray[pos] = " + VideoCallActivity.this.mRemoteSurfaceIDArray[pos] + ", mIsRemoteDeactivatedArray[surfID] = " + VideoCallActivity.this.mIsRemoteDeactivatedArray[surfID]);
                                    pos++;
                                }
                            }
                            VideoCallActivity.this.setMobileMCULayout(true);
                        }
                    }
                    VideoCallActivity.this.setPreViewWhiteOutLine();
                    if (CallState.isConnected(VideoCallActivity.this.mCallState)) {
                        VideoCallActivity.this.updatePreviewLayout(false);
                        break;
                    }
                    break;
                case EventCode.EVENT_CONF_CHANGE_LAYOUT /* 7017 */:
                    VideoCallActivity.this.logI("EventCode.EVENT_CONF_CHANGE_LAYOUT");
                    VideoCallActivity.this.handleChangeConferenceLayout(msg.arg1);
                    break;
                case EventCode.EVENT_CONF_CHANGE_HOLD /* 7018 */:
                    VideoCallActivity.this.logI("EventCode.EVENT_CONF_CHANGE_HOLD");
                    ArrayList<String> userIDList = (ArrayList) msg.obj;
                    VideoCallActivity.this.handleConferenceChangeHold(userIDList);
                    break;
                case EventCode.EVENT_CONF_CHANGE_UNHOLD /* 7019 */:
                    VideoCallActivity.this.logI("EventCode.EVENT_CONF_CHANGE_UNHOLD");
                    ArrayList<String> userIDList1 = (ArrayList) msg.obj;
                    VideoCallActivity.this.handleConferenceChangeUnhold(userIDList1);
                    break;
                case EventCode.EVENT_VIDEO_INCOMING_CALL_HANGUP_QUICKLY /* 7026 */:
                    VideoCallActivity.this.logI("EVENT_VIDEO_INCOMING_CALL_HANGUP_QUICKLY");
                    VideoCallActivity.this.quicklyHangupCall();
                    break;
                case EventCode.EVENT_CALL_CAMERA_TOGGLE /* 7110 */:
                    VideoCallActivity.this.logI("EventCode.EVENT_CALL_CAMERA_TOGGLE:");
                    break;
                case EventCode.EVENT_CALL_CAMERA_VIDEOCALL /* 7111 */:
                    VideoCallActivity.this.logI("EventCode.EVENT_CALL_CAMERA_VIDEOCALL:");
                    break;
                case EventCode.EVENT_CALL_CAMERA_CLOSE_FOR_TOGGLE /* 7112 */:
                    VideoCallActivity.this.logI("EventCode.EVENT_CALL_CAMERA_CLOSE_FOR_TOGGLE:");
                    VideoCallActivity.this.removeCameraForToggle();
                    break;
                case EventCode.EVENT_CALL_CAMERA_CLOSE_FOR_VIDEOCALL /* 7113 */:
                    VideoCallActivity.this.logI("EventCode.EVENT_CALL_CAMERA_CLOSE_FOR_VIDEOCALL:");
                    VideoCallActivity.this.removeCameraForVideoCall();
                    break;
                case EventCode.EVENT_CALL_CAPTURE_IMAGE /* 7230 */:
                    VideoCallActivity.this.logI("<<YHT4>> EVENT_CALL_CAPTURE_IMAGE received!!");
                    VideoCallActivity.this.setNotiCapturedView();
                    break;
                case EventCode.EVENT_CALL_CAPTURE_MY_IMAGE_FAILURE /* 7232 */:
                    VideoCallActivity.this.logI(" EVENT_CALL_CAPTURE_MY_IMAGE_FAILURE received!!");
                    VideoCallActivity.this.showToast("Fail to capture my image");
                    break;
                case EventCode.EVENT_CHANGE_TO_CONFERENCE_START /* 7602 */:
                    VideoCallActivity.this.logI(" EVENT_CHANGE_TO_CONFERENCE_START()");
                    VideoCallActivity.this.handleChangeToConferenceStart();
                    break;
                case EventCode.EVENT_CHANGE_TO_CONFERNECE_FAILURE /* 7603 */:
                    VideoCallActivity.this.logI(" EVENT_CHANGE_TO_CONFERNECE_FAILURE()");
                    VideoCallActivity.this.handleChangeToConferenceFailure();
                    break;
                case EventCode.EVENT_CHANGE_TO_CONFERENCE_FINISH /* 7604 */:
                    VideoCallActivity.this.logI(" EVENT_CHANGE_TO_CONFERENCE_FINISH(): " + VideoCallActivity.this.mUseAlterImage);
                    VideoCallActivity.this.mCallBtnLayout.setUIState(VideoCallActivity.this.mCallState, VideoCallActivity.this.mShareViewCtrl.isActive(), VideoCallActivity.this.mShareViewCtrl.isStarter());
                    VideoCallActivity.this.handleChangeToConferenceFinish();
                    VideoCallActivity.this.checkCallInstanceNRefresh();
                    VideoCallActivity.this.checkWaitMemberForInviteView();
                    VideoCallActivity.this.updateMemberCount();
                    if (VideoCallActivity.this.getResources().getConfiguration().orientation == 2) {
                        VideoCallActivity.this.viewTopStatusBar();
                    }
                    VideoCallActivity.this.viewInviteView();
                    VideoCallActivity.this.initOptionMenuData();
                    break;
                case EventCode.EVENT_CHANGE_TO_CONFERENCE_DONE /* 7605 */:
                    VideoCallActivity.this.logI("EventCode.EVENT_CHANGE_TO_CONFERENCE_DONE");
                    VideoCallActivity.this.maintainConferenceCall();
                    break;
                case EventCode.EVENT_CHANGE_TO_P2P_START /* 7610 */:
                    VideoCallActivity.this.logI("EVENT_CHANGE_TO_P2P_START - Changed UI");
                    VideoCallActivity.this.mDestination = (Destination) msg.obj;
                    VideoCallActivity.this.maintainOptionMenu();
                    VideoCallActivity.this.updateLayoutChangeDestination();
                    VideoCallActivity.this.updatePreviewLayout(false);
                    VideoCallActivity.this.setPreViewWhiteOutLine();
                    if (VideoCallActivity.this.mMemberViewCtrl.ismMemberViewActive()) {
                        VideoCallActivity.this.endMemberView();
                    }
                    if (VideoCallActivity.this.mInviteViewCtrl != null && !VideoCallActivity.this.isConference()) {
                        VideoCallActivity.this.mInviteViewCtrl.endInviteView();
                        VideoCallActivity.this.mInviteviewMemberLayout.hideInviteView();
                    }
                    if (VideoCallActivity.this.mUseDualCamera) {
                        VideoCallActivity.this.startDualCamera();
                        break;
                    }
                    break;
                case EventCode.EVENT_CHANGE_TO_P2P_FAILURE /* 7611 */:
                    VideoCallActivity.this.logI("EVENT_CHANGE_TO_P2P_FAILURE - Changed UI");
                    VideoCallActivity.this.hangupCall();
                    break;
                case EventCode.EVENT_CHANGE_TO_P2P_NOTI_MSG /* 7612 */:
                    VideoCallActivity.this.logI("EventCode.EVENT_CHANGE_TO_P2P_NOTI_MSG");
                    String removedMemberUserID = (String) msg.obj;
                    if (removedMemberUserID == null) {
                        VideoCallActivity.this.showToast(C0000R.string.change_to_p2p_start);
                    } else {
                        VideoCallActivity videoCallActivity = VideoCallActivity.this;
                        Resources resources = VideoCallActivity.this.getResources();
                        ChatONStringConvert.getInstance();
                        videoCallActivity.showToast(resources.getString(C0000R.string.change_to_p2p_invite_call_ended, ChatONStringConvert.getInstance().removeFooter(VideoCallActivity.this.getUserName(removedMemberUserID))));
                    }
                    if (VideoCallActivity.this.mMemberViewCtrl.ismMemberViewActive()) {
                        VideoCallActivity.this.endMemberView();
                    }
                    if (VideoCallActivity.this.mInviteViewCtrl != null || !VideoCallActivity.this.isConference()) {
                        VideoCallActivity.this.mInviteViewCtrl.endInviteView();
                        VideoCallActivity.this.goneInviteView();
                    }
                    VideoCallActivity.this.saveConferenceData();
                    VideoCallActivity.this.mCallBtnLayout.setUIState(VideoCallActivity.this.mCallState, VideoCallActivity.this.mShareViewCtrl.isActive(), VideoCallActivity.this.mShareViewCtrl.isStarter());
                    VideoCallActivity.this.resetNormalSurfaceView();
                    break;
                case EventCode.EVENT_CHANGE_TO_P2P_FAIL_TIMER /* 7613 */:
                    VideoCallActivity.this.logI(" EVENT_CHANGE_TO_P2P_FAIL_TIMER ");
                    VideoCallActivity.this.logI("EVENT_CHANGE_TO_P2P_FAILURE - Changed UI");
                    VideoCallActivity.this.hangupCall();
                    break;
                case EventCode.EVENT_CALL_REMOTEROTATION /* 7700 */:
                    VideoCallActivity.this.logI("EventCode.EVENT_CALL_REMOTEROTATION:");
                    int rotation = msg.arg1;
                    int notSendEngine = msg.arg2;
                    VideoCallActivity.this.onDrawRemoteSurface(rotation, notSendEngine);
                    break;
                case EventCode.EVENT_CALL_REMOTEROTATION_P2P_CONF /* 7701 */:
                    VideoCallActivity.this.logI("EventCode.EVENT_CALL_REMOTEROTATION_P2P_CONF:");
                    int[] rotations = (int[]) msg.obj;
                    for (int i = 0; i < VideoCallActivity.this.mMaxRemoteCnt; i++) {
                        VideoCallActivity.this.logI("EVENT_CALL_REMOTEROTATION_P2P_CONF() : i = " + i + ", rotations[i] = " + rotations[i]);
                        VideoCallActivity.this.mRemoteRotationArray[i] = rotations[i];
                    }
                    VideoCallActivity.this.setMobileMCULayout(true);
                    break;
                case EventCode.EVENT_CALL_3G_RINGING_WHILE_VT /* 7800 */:
                case EventCode.EVENT_CALL_3G_CALLING_WHILE_VT /* 7801 */:
                    VideoCallActivity.this.logI("EventCode.EVENT_CALL_3G_RINGING_WHILE_VT or EVENT_CALL_3G_CALLING_WHILE_VT:");
                    String phoneNum = (String) msg.obj;
                    VideoCallActivity.this.setDisplay3GLayout(phoneNum);
                    VideoCallActivity.this.accpetNativeCall();
                    break;
                case EventCode.EVENT_CALL_3G_IDLE_WHILE_VT /* 7802 */:
                    VideoCallActivity.this.logI("EventCode.EVENT_CALL_3G_IDLE_WHILE_VT");
                    VideoCallActivity.this.endNativeCall(msg.arg1, msg.arg2);
                    break;
                case EventCode.EVENT_CALL_VIDEO_RECORD_START /* 7900 */:
                    VideoCallActivity.this.logI("<<YHT4>> EVENT_CALL_VIDEO_RECORD received!!");
                    VideoCallActivity.this.setOtherRecording(true);
                    break;
                case EventCode.EVENT_CALL_VIDEO_RECORD_END /* 7901 */:
                    VideoCallActivity.this.logI("<<YHT4>> EVENT_CALL_VIDEO_RECORD ended!!");
                    VideoCallActivity.this.setOtherRecording(false);
                    break;
                case EventCode.EVENT_SHARE_SCREEN_START /* 8112 */:
                    VideoCallActivity.this.logI("ShareScreen - EventCode.EVENT_SHARE_SCREEN_START (Video)");
                    VideoCallActivity.this.dismissCallConsentProcessingDialog();
                    MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releasePartialWakeLock(CoolotsWakeLockList.WAKELOCK_TAG_VIDEO_CALL);
                    MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximity(false);
                    break;
                case EventCode.EVENT_CAMERA_START_ERROR /* 8205 */:
                    VideoCallActivity.this.logI("EventCode.EVENT_CAMERA_START_ERROR --> hide me start!!");
                    VideoCallActivity.this.makeHideMeImage();
                    break;
                case VideoCallActivity.DISPLAY_CAPTURE_IMAGE /* 9367 */:
                    VideoCallActivity.this.logI("EventCode.DISPLAY_CAPTURE_IMAGE");
                    VideoCallActivity.this.mOtherPartyCapture.setVisibility(8);
                    break;
                case VideoCallActivity.DISPLAY_CAPTURE_IMAGE_PREVIEW /* 9368 */:
                    VideoCallActivity.this.logI("EventCode.DISPLAY_CAPTURE_IMAGE_PREVIEW");
                    VideoCallActivity.this.finishCaptureImgShow();
                    break;
                case VideoCallActivity.STOP_CAPTURE_IMAGE_ANIMATION /* 9371 */:
                    VideoCallActivity.this.logI("EventCode.STOP_CAPTURE_IMAGE_ANIMATION");
                    VideoCallActivity.this.mImageCaptureAnimationImageView.setVisibility(4);
                    VideoCallActivity.this.mCaptureImageAnimation.stop();
                    VideoCallActivity.this.showToast(VideoCallActivity.this.getResources().getString(C0000R.string.video_image_capture));
                    try {
                        VideoCallActivity.this.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
                        break;
                    } catch (Throwable t) {
                        t.printStackTrace();
                        break;
                    }
                case 10006:
                    VideoCallActivity.this.logI("EventCode.EVENT_COMMON_NOTITOUSER_DISCONNECTED:");
                    VideoCallActivity.this.mIsUpNomalTerminatingCall = true;
                    break;
                case EventCode.EVENT_DEBUG_MSG /* 95000 */:
                    VideoCallActivity.this.logI("EventCode.EVENT_VOICE_ACTIVITY_CHANGE");
                    String debugMsg = (String) msg.obj;
                    VideoCallActivity.this.showToast(debugMsg);
                    break;
                case EventCode.EVENT_CAMERA_ZOOM_ERROR /* 95005 */:
                    VideoCallActivity.this.logI("EventCode.EVENT_CAMERA_ZOOM_ERROR");
                    VideoCallActivity.this.hangupCameraZoomError();
                    break;
                case EventCode.EVENT_VOICE_ACTIVITY_CHANGE /* 95007 */:
                    VideoCallActivity.this.logI("EventCode.EVENT_VOICE_ACTIVITY_CHANGE");
                    VideoCallActivity.this.mVoiceActivityPos = msg.arg1;
                    VideoCallActivity.this.setMobileMCULayout(false);
                    break;
                case EventCode.EVENT_DUAL_CAMERA_START /* 95015 */:
                    VideoCallActivity.this.logI("DUAL CAMARA EVENT start received");
                    if (VideoCallActivity.this.mDualCameraTimer != null) {
                        VideoCallActivity.this.mDualCameraTimer.cancel();
                    }
                    VideoCallActivity.this.mDualCameraTimer.start();
                    Date startTime = new Date();
                    VideoCallActivity.this.logI("haeri=date?" + startTime);
                    MainApplication.mPhoneManager.getPhoneStateMachine().setDualCameraStartedTime(startTime);
                    VideoCallActivity.this.mCallBtnLayout.mButtonEventHandler.sendEmptyMessage(6);
                    VideoCallActivity.this.setCameraToggle(VideoCallActivity.CAMERA_VISIBLE_REAR);
                    break;
                case EventCode.EVENT_DUAL_CAMERA_STOP /* 95016 */:
                    VideoCallActivity.this.logI("DUAL CAMARA EVENT stop received");
                    VideoCallActivity.this.mDualCameraTimer.cancel();
                    VideoCallActivity.this.mCallBtnLayout.mButtonEventHandler.sendEmptyMessage(6);
                    if (VideoCallActivity.this.mShareViewCtrl.isActive() && VideoCallActivity.this.getCameraToggle() == 666) {
                        SECConfig.switchCamera();
                        break;
                    } else {
                        VideoCallActivity.this.setCameraToggle(VideoCallActivity.CAMERA_VISIBLE_FRONT);
                        break;
                    }
                    break;
                case EventCode.EVENT_WRONG_CALL_STATE_MOVE_TO_END_CALL_PAGE /* 95017 */:
                    VideoCallActivity.this.logI("EVENT_WRONG_CALL_STATE_MOVE_TO_END_CALL_PAGE");
                    VideoCallActivity.this.handleCallEvent(3);
                    break;
            }
            super.handleMessage(msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initOptionMenuData() {
        logI("initOptionMenuData() ");
        logI("mUseAlterImage: " + this.mUseAlterImage);
        logI("mVideoCallOptionMenu.isAlwaysMode(): " + this.mVideoCallOptionMng.isAlwaysMode());
        if (CallState.isConnected(this.mCallState)) {
            if (this.mVideoCallOptionMng.isShowingAnyMenu()) {
                if (this.mShareViewCtrl.isActive()) {
                    endShareView();
                }
                new Handler().postDelayed(new Runnable() { // from class: com.coolots.chaton.call.view.VideoCallActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoCallActivity.this.mVideoCallOptionMng != null) {
                            VideoCallActivity.this.mVideoCallOptionMng.refreshOptionMenu();
                        }
                    }
                }, 1000L);
            }
            if (getCameraToggle() == 666) {
                this.mCallBtnLayout.onClick(this.mCallBtnLayout.findViewById(C0000R.id.camera_change_btn));
            }
            if (this.mIsCartoonView) {
                new Handler().postDelayed(new Runnable() { // from class: com.coolots.chaton.call.view.VideoCallActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoCallActivity.this.setCartoonView(0);
                    }
                }, 1000L);
            }
            if (this.mIsRecording) {
                stopRecord();
                this.mCallBtnLayout.setRecordBtnStatus(false);
                showToast(getResources().getString(C0000R.string.video_complete_record));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maintainConferenceCall() throws Throwable {
        this.mUseAlterImage = MainApplication.mPhoneManager.getPhoneStateMachine().getHideState();
        setHideMeOrientation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maintainOptionMenu() throws Throwable {
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        this.mCallState = callInfo.getCallState();
        logI("maintainOptionMenu() ");
        logI("mUseAlterImage: " + this.mUseAlterImage + " mUseDualCamera: " + this.mUseDualCamera + " mP2PBackUpObj: " + this.mP2PBackUpObj);
        logI("mVideoCallOptionMenu.isAlwaysMode(): " + this.mVideoCallOptionMng.isAlwaysMode());
        if (this.mP2PBackUpObj == null) {
            if (CallState.isConnected(this.mCallState)) {
                if (this.mUseAlterImage) {
                    setHideMeOrientation();
                }
                if (this.mVideoCallOptionMng.isShowingAnyMenu()) {
                    if (this.mVideoCallOptionMng.getStatus() == 2) {
                        this.mVideoCallOptionMng.changeStatus(2);
                    } else if (this.mVideoCallOptionMng.getStatus() == 3) {
                        this.mVideoCallOptionMng.changeStatus(3);
                    } else {
                        this.mVideoCallOptionMng.changeStatus(1);
                        if (this.mVideoCallOptionMng.isAlwaysMode()) {
                            this.mVideoCallEmotiAnimationLayout.setAutoFaceEmotion(true);
                        }
                    }
                    if (!this.mShareViewCtrl.isActive()) {
                        if (this.mVideoCallOptionMng.getStatus() == 2) {
                            displayThemeShotForP2P();
                        } else if (this.mVideoCallOptionMng.getStatus() != 3) {
                            displayEmotionalAnimationForP2P();
                        }
                    }
                }
                if (this.mIsCartoonView) {
                    setCartoonView(0);
                }
                if (this.mMemberViewCtrl.ismMemberViewActive()) {
                    endMemberView();
                }
                if (getCameraToggle() == 666) {
                    SECConfig.switchCamera();
                    return;
                }
                return;
            }
            return;
        }
        HashMap<String, Object> hMap = (HashMap) this.mP2PBackUpObj.clone();
        if (this.mP2PBackUpObj == null) {
            logI("mP2PBackUpObj NULL");
        }
        if (hMap != null) {
            if (CallState.isConnected(this.mCallState)) {
                boolean isHideMe = ((Boolean) hMap.get(mHideMeClicked)).booleanValue();
                if (isHideMe) {
                    setHideMeOrientation();
                }
                if (this.mVideoCallOptionMng.isShowingAnyMenu()) {
                    if (this.mVideoCallOptionMng.getStatus() == 2) {
                        this.mVideoCallOptionMng.changeStatus(2);
                    } else if (this.mVideoCallOptionMng.getStatus() == 3) {
                        this.mVideoCallOptionMng.changeStatus(3);
                    } else {
                        this.mVideoCallOptionMng.setAlwaysMode((Boolean) hMap.get(mAlwaysMode));
                        this.mVideoCallOptionMng.changeStatus(1);
                    }
                    if (!this.mShareViewCtrl.isActive()) {
                        if (this.mVideoCallOptionMng.getStatus() == 2) {
                            displayThemeShotForP2P();
                        } else if (this.mVideoCallOptionMng.getStatus() != 3) {
                            displayEmotionalAnimationForP2P();
                        }
                    }
                } else {
                    this.mVideoCallOptionMng.changeStatus(0);
                }
                if (getCameraToggle() == 666) {
                    SECConfig.switchCamera();
                }
                this.mIsCartoonView = ((Boolean) hMap.get(mCartoonView)).booleanValue();
                if (this.mIsCartoonView) {
                    setCartoonView(0);
                }
                if (this.mMemberViewCtrl.ismMemberViewActive()) {
                    endMemberView();
                }
                logI("hmap mUseAlterImage: " + this.mUseAlterImage + " mUseDualCamera: " + this.mUseDualCamera);
                logI("hmap mVideoCallOptionMenu.isAlwaysMode(): " + this.mVideoCallOptionMng.isAlwaysMode());
                Log.m2963i("V_p2_ a" + this.mUseAlterImage + " d: " + this.mUseDualCamera + " w: " + this.mVideoCallOptionMng.isAlwaysMode());
                return;
            }
            return;
        }
        logI("hmap NULL");
    }

    private class InnerHandler extends Handler implements DisposeInterface {
        private boolean isDispose;

        private InnerHandler() {
            this.isDispose = false;
        }

        /* synthetic */ InnerHandler(VideoCallActivity videoCallActivity, InnerHandler innerHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (!this.isDispose) {
                VideoCallActivity.this.logI("<mInnerHandler> msg.what:" + msg.what);
                switch (msg.what) {
                    case 1:
                        VideoCallActivity.this.mCallEndBtnLayout.setVisibility(0);
                        break;
                    case 2:
                        VideoCallActivity.this.mShareViewPinchZoomGuideLineLayout.setVisibility(8);
                        break;
                }
                VideoCallActivity.this.mInnerHandler.removeMessages(msg.what);
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
    public void onDrawRemoteSurface(int rotation, int notSendEngine) throws Throwable {
        boolean isSelf;
        logI("onDrawRemoteSurface(" + rotation + ")");
        if (notSendEngine == 0) {
            isSelf = true;
        } else {
            isSelf = false;
        }
        if (!isConference()) {
            this.mRemoteRotation = rotation;
            if (this.mChanagePreview) {
                setSECPreViewOrientation(this.mRemoteRotation, isSelf);
            } else {
                setSECOrientation(this.mRemoteRotation, isSelf);
            }
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        logI("onKeyUp() keyCode: " + keyCode);
        this.mMenu = null;
        if (keyCode == 4) {
            if (CallState.isNotConnected(this.mCallState)) {
                if (!this.mIsOutGoingCall) {
                    this.mCallReceiveBtnLayout.closeRejectMsg();
                }
            } else if (CallState.isConnected(this.mCallState)) {
                if (this.mMemberViewCtrl.ismMemberViewActive()) {
                    endMemberView();
                    if (MainApplication.mPhoneManager.isConfTest() && CallState.isConnected(this.mCallState)) {
                        setMobileMCULayout(false);
                    } else {
                        setSurfaceViewLayout();
                    }
                }
                closeOptionsMenu();
            }
            return true;
        }
        if (keyCode == 26) {
            this.mIsPowerLongPressed = false;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override // com.sds.coolots.call.view.CallActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int arg0, KeyEvent arg1) {
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
                    if (isDrivingModeUIOn()) {
                        this.mVideoCallDrivingBtnLayout.setVisibility(0);
                    } else if (CallState.isConnected(this.mCallState)) {
                        this.mCallBtnLayout.endCall();
                    }
                    MainApplication.mPhoneManager.isTranslateTest();
                    return true;
                }
                break;
        }
        return super.onKeyDown(arg0, arg1);
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
            synchronized (VideoCallActivity.this.UIMutex) {
                if (!this.bDisposed) {
                    if (VideoCallActivity.this.mUseVideo && !CallState.isDisconnected(VideoCallActivity.this.mCallState)) {
                        int orientation = _orientation;
                        if (orientation == -1) {
                            VideoCallActivity.this.logI("ORIENTATION_UNKNOWN");
                            orientation = VideoCallActivity.this.mSavedOrientation;
                        }
                        VideoCallActivity.this.mInstantOrientation = VideoCallActivity.this.get45UnitAngleFromFullAngle(orientation);
                        VideoCallActivity.this.orientHandling(orientation);
                    }
                }
            }
        }
    }

    private int get30UnitAngleFromFullAngle(int angle) {
        if (this.mSavedOrientation == 0 || this.mSavedOrientation == 360) {
            if (angle < 60 || angle > 300) {
                return 0;
            }
            if (angle >= 60 && angle < 135) {
                return 90;
            }
            if (angle <= 300 && angle > 225) {
                return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MIDDLE_ALIGN_EVENT;
            }
            return EngineCallBackInterface.SIP_RINGTONE_NONE;
        }
        if (this.mSavedOrientation == 90) {
            if (angle > 30 && angle < 150) {
                return 90;
            }
            if (angle >= 150 && angle < 225) {
                return EngineCallBackInterface.SIP_RINGTONE_NONE;
            }
            if (angle <= 30 || angle > 315) {
                return 0;
            }
            return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MIDDLE_ALIGN_EVENT;
        }
        if (this.mSavedOrientation == 180) {
            if (angle > 120 && angle < 240) {
                return EngineCallBackInterface.SIP_RINGTONE_NONE;
            }
            if (angle >= 240 && angle < 315) {
                return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MIDDLE_ALIGN_EVENT;
            }
            if (angle <= 120 && angle > 45) {
                return 90;
            }
            return 0;
        }
        if (this.mSavedOrientation != 270) {
            return 0;
        }
        if (angle > 210 && angle < 330) {
            return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MIDDLE_ALIGN_EVENT;
        }
        if (angle <= 210 && angle > 135) {
            return EngineCallBackInterface.SIP_RINGTONE_NONE;
        }
        if (angle >= 330 || angle < 45) {
            return 0;
        }
        return 90;
    }

    public void orientHandling(int orientation) throws Throwable {
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
            logI("Do_Something in onOrientationChanged!!!!!!!!!!!!!!!!!!!!");
            autoRotationCameraRotate();
        }
    }

    private void autoRotationCameraRotate() throws Throwable {
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

    private void sendRotationInfoToServer(int angle, boolean isLayoutChanged) {
        if (!this.mIsInitAngle) {
            sendRotationInfoToServer();
        } else {
            logI("sendRotationInfoToServer() " + angle);
            sendRotationInfoToServerDirectly(angle, isLayoutChanged);
        }
    }

    private void sendRotationInfoToServerDirectly(int angle, boolean isLayoutChanged) {
        boolean autoRotation = isAutorotationActive();
        int systembarAngle = getSystemBarOrientation();
        logI("systembarAngle: " + systembarAngle);
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
        this.mSavedOrientation = systembarAngle;
        logI("sendRotationInfoToServer() - init : " + this.mSavedOrientation);
        logI("deviceAngle: " + systembarAngle);
        logI("systembarAngle: " + systembarAngle);
        logI("degree: " + degree);
        logI("is auto-rotation: " + autoRotation);
        MainApplication.mPhoneManager.getPhoneStateMachine().sendRotationInfo(this.mDestination, degree, autoRotation, false);
    }

    public int getSystemBarOrientation() {
        if (this.windowManager == null) {
            this.windowManager = (WindowManager) getSystemService("window");
        }
        Display display = this.windowManager.getDefaultDisplay();
        int rotation = ((4 - display.getRotation()) % 4) * 90;
        return rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int get45UnitAngleFromFullAngle(int angle) {
        if (angle < 45 || angle > 315) {
            return 0;
        }
        if (angle >= 45 && angle < 135) {
            return 90;
        }
        if (angle >= 135 && angle < 225) {
            return EngineCallBackInterface.SIP_RINGTONE_NONE;
        }
        return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MIDDLE_ALIGN_EVENT;
    }

    private void setHideMeOrientation() throws Throwable {
        logI("<CIH> mUseAlterImage = " + this.mUseAlterImage);
        if (this.mUseAlterImage) {
            logI("setHideMeOrientation()");
            setDefaultHideMeImage();
        }
    }

    private void setSECPreviewPosition(boolean paddingOff) {
        logI("setSECPreviewPosition() : paddingOff " + paddingOff);
        int height = this.mPreviewHeight;
        int width = this.mPreviewWidth;
        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mSurfaceViewlayout.getLayoutParams();
        if (getResources().getConfiguration().orientation == 1) {
            if (this.mChangePreviewRotation) {
                param.width = height;
                param.height = width;
            } else {
                param.width = width;
                param.height = height;
            }
            param.gravity = 51;
            param.setMargins(this.mImgPoint.x, this.mImgPoint.y, this.mPreviewPaddingRight, this.mPrviewPaddingButton);
        } else {
            if (this.mChangePreviewRotation) {
                param.width = width;
                param.height = height;
            } else {
                param.width = height;
                param.height = width;
            }
            param.gravity = 51;
            param.rightMargin = this.mLandPreviewPaddingRight;
            param.setMargins(this.mImgPoint.x, this.mImgPoint.y, this.mLandPreviewPaddingRight, this.mLandPrviewPaddingButton);
        }
        this.mSurfaceViewlayout.setLayoutParams(param);
        this.mSurfaceViewlayout.setVisibility(0);
        if (paddingOff) {
            if (!this.mShareViewCtrl.isStarter()) {
                if (this.mChanagePreview) {
                    setViewGuideLineStatus(2, 1);
                    return;
                } else {
                    setViewGuideLineStatus(2, 0);
                    return;
                }
            }
            return;
        }
        setPreViewWhiteOutLine();
    }

    private void setSECPreViewOrientation(int remoteRotation, boolean isSelf) throws Throwable {
        boolean isChanged;
        logI("setSECPreViewOrientation() : mSavedOrientation " + this.mSavedOrientation + " remoteRotation: " + remoteRotation + "isSelf: " + isSelf);
        if (!isConference()) {
            this.mIsTabDevice = this.mModelInfo.isTabDevice();
            int orientationChanged = (remoteRotation - this.mSavedOrientation) % EngineCallBackInterface.SIP_RINGTONE_NONE;
            logI("orientationChanged: " + orientationChanged);
            if (orientationChanged == 0) {
                if (this.mIsTabDevice) {
                    isChanged = changedPreviewLayout(false);
                } else {
                    isChanged = changedPreviewLayout(true);
                }
            } else if (this.mIsTabDevice) {
                isChanged = changedPreviewLayout(true);
            } else {
                isChanged = changedPreviewLayout(false);
            }
            if (isSelf) {
                sendRotationInfoToServer(this.mSavedOrientation, isChanged);
            }
        }
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) this.mRemoteSurface.getLayoutParams();
        params.width = -1;
        params.height = -1;
        params.gravity = 119;
        if (getResources().getConfiguration().orientation == 1) {
            if (this.mShareViewCtrl.isActive() && this.mShareViewCtrl.isFullScreen()) {
                params.topMargin = 0;
                params.bottomMargin = 0;
                params.rightMargin = 0;
            } else {
                params.topMargin = this.mModelInfo.getCallStatusBarHeight();
                params.bottomMargin = this.mPreviewMarginButtom;
                params.rightMargin = 0;
            }
        } else {
            params.topMargin = 0;
            params.bottomMargin = 0;
            params.rightMargin = 0;
        }
        this.mRemoteSurface.setLayoutParams(params);
        if (isAutorotationActive()) {
            if (this.mSavedOrientation != 180) {
                setDualPositionForDualPosition(false);
            }
        } else if (isSelf) {
            if (this.mUseDualCamera) {
                setDualPositionForDualPosition(true);
            }
            setHideMeOrientation();
        }
    }

    private void initMCURemoteSurface(int surfID) {
        if (this.mRemoteSurfaceArray[surfID] == null) {
            if (surfID == 0) {
                this.mRemoteSurfaceArray[0] = (SurfaceView) findViewById(C0000R.id.omx_video_view);
                this.mRemoteHolderArray[0] = this.mRemoteSurfaceArray[0].getHolder();
                this.mRemoteHolderArray[0].addCallback(this);
                this.mRemoteHolderArray[0].setType(3);
                this.mRemoteSurface = this.mRemoteSurfaceArray[0];
                this.mRemoteHolder = this.mRemoteHolderArray[0];
                return;
            }
            this.mRemoteSurfaceArray[surfID] = new SurfaceView(this);
            this.mRemoteHolderArray[surfID] = this.mRemoteSurfaceArray[surfID].getHolder();
            this.mRemoteHolderArray[surfID].addCallback(this);
            this.mRemoteHolderArray[surfID].setType(3);
            this.mRemoteVideoLayoutRadvision.addView(this.mRemoteSurfaceArray[surfID]);
        }
    }

    private boolean changedMCURemoteLayout(int connectCount, int pos, int surfID, boolean changed) {
        FrameLayout.LayoutParams param;
        logI("changedMCURemoteLayout() : connectCount " + connectCount + ", pos = " + pos + ", surfID = " + surfID + ", changed = " + changed + ", mIsLocalDeactivated = " + this.mIsLocalDeactivated + ", isDeactivated = " + this.mIsRemoteDeactivatedArray[surfID]);
        this.mIsOtherPartyLandscapeMode = changed;
        initMCURemoteSurface(surfID);
        boolean isChanged = true;
        boolean isDeactivated = false;
        MobileMCUImageView iView = this.mRemoteImageView[surfID];
        SurfaceView sView = this.mRemoteSurfaceArray[surfID];
        if (this.mIsLocalDeactivated || this.mIsRemoteDeactivatedArray[surfID]) {
            changed = false;
            isChanged = false;
            isDeactivated = true;
            param = (FrameLayout.LayoutParams) iView.getLayoutParams();
        } else {
            param = (FrameLayout.LayoutParams) sView.getLayoutParams();
        }
        int oldTopMargin = param.topMargin;
        int oldBottomMargin = param.bottomMargin;
        int oldLeftMargin = param.leftMargin;
        int oldRightMargin = param.rightMargin;
        int oldWidth = param.width;
        int oldHeight = param.height;
        if (pos == 0) {
            param.width = -1;
            param.height = -1;
            if (changed) {
                if (getResources().getConfiguration().orientation == 1) {
                    param.gravity = 49;
                    param.topMargin = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MIDDLE_ALIGN_EVENT;
                    param.bottomMargin = this.mPreviewMarginButtom + ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO;
                    if (this.mModelInfo != null) {
                        param.topMargin = this.mModelInfo.getCallStatusBarHeight() + this.mModelInfo.getPreviewWidth();
                        param.bottomMargin = this.mPreviewMarginButtom + this.mModelInfo.getPreviewWidth();
                    }
                } else {
                    param.gravity = 49;
                    param.leftMargin = 196;
                    param.rightMargin = 196;
                    if (this.mModelInfo != null) {
                        param.leftMargin = this.mModelInfo.getLandPreviewWidth();
                        param.rightMargin = this.mModelInfo.getLandPreviewWidth();
                    }
                    param.bottomMargin = this.mLandRemoteViewMarginButtom;
                }
            } else {
                param.gravity = 119;
                param.leftMargin = 0;
                param.rightMargin = 0;
                if (getResources().getConfiguration().orientation == 1) {
                    param.topMargin = this.mModelInfo.getCallStatusBarHeight();
                    param.bottomMargin = this.mPreviewMarginButtom;
                } else {
                    param.topMargin = 0;
                    param.bottomMargin = this.mLandRemoteViewMarginButtom;
                }
            }
        } else if (connectCount == 3) {
            param.gravity = 51;
            DisplayMetrics outMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
            float density = outMetrics.density;
            if (changed) {
                if (getResources().getConfiguration().orientation == 1) {
                    param.width = (int) (114.0f * density);
                    param.height = (int) (85.0f * density);
                    param.setMargins((int) (123.0f * density), (int) (357.0f * density), this.mPreviewPaddingRight, this.mPrviewPaddingButton);
                    if (pos == 2) {
                        param.leftMargin = (int) (241.0f * density);
                    }
                } else {
                    param.width = (int) (79.0f * density);
                    param.height = (int) (106.0f * density);
                    param.setMargins((int) (35.0f * density), (int) (225.0f * density), this.mLandPreviewPaddingRight, this.mLandPrviewPaddingButton);
                    if (pos == 2) {
                        param.leftMargin = (int) (182.0f * density);
                    }
                }
            } else if (getResources().getConfiguration().orientation == 1) {
                param.width = (int) (114.0f * density);
                param.height = (int) (151.0f * density);
                param.setMargins((int) (123.0f * density), (int) (325.0f * density), this.mPreviewPaddingRight, this.mPrviewPaddingButton);
                if (pos == 2) {
                    param.leftMargin = (int) (241.0f * density);
                }
            } else {
                param.width = (int) (141.0f * density);
                param.height = (int) (106.0f * density);
                param.setMargins((int) (5.0f * density), (int) (225.0f * density), this.mLandPreviewPaddingRight, this.mLandPrviewPaddingButton);
                if (pos == 2) {
                    param.leftMargin = (int) (152.0f * density);
                }
            }
        } else {
            param.gravity = 53;
            if (changed) {
                if (getResources().getConfiguration().orientation == 1) {
                    param.width = this.mPreviewHeight;
                    param.height = this.mPreviewWidth;
                    param.setMargins(this.mPreviewPaddingRight, this.mImgPoint.y + ((param.width - param.height) / 2), this.mImgPoint.x, this.mPrviewPaddingButton);
                } else {
                    param.width = this.mPreviewWidth;
                    param.height = this.mPreviewHeight;
                    param.setMargins(this.mLandPreviewPaddingRight, this.mImgPoint.y - (param.height - param.width), this.mImgPoint.x + ((param.height - param.width) / 2), this.mLandPrviewPaddingButton);
                }
            } else if (getResources().getConfiguration().orientation == 1) {
                param.width = this.mPreviewWidth;
                param.height = this.mPreviewHeight;
                param.setMargins(this.mPreviewPaddingRight, this.mImgPoint.y, this.mImgPoint.x, this.mPrviewPaddingButton);
            } else {
                param.width = this.mPreviewHeight;
                param.height = this.mPreviewWidth;
                param.setMargins(this.mLandPreviewPaddingRight, this.mImgPoint.y, this.mImgPoint.x, this.mLandPrviewPaddingButton);
            }
        }
        if (oldWidth == param.width && oldHeight == param.height && oldTopMargin == param.topMargin && oldBottomMargin == param.bottomMargin && oldLeftMargin == param.leftMargin && oldRightMargin == param.rightMargin) {
            isChanged = false;
        }
        if (isDeactivated) {
            iView.setLayoutParams(param);
            iView.doAction(true);
        } else {
            sView.setLayoutParams(param);
            iView.doAction(false);
        }
        return isChanged;
    }

    private void swapRemoteSurface(int connectCount) {
        int changePos = this.mRemoteSurfaceIDArray[0];
        logI("mRemoteSurfaceIDArray[0] = " + this.mRemoteSurfaceIDArray[0] + ", mVoiceActivityPos = " + this.mVoiceActivityPos);
        if (this.mVoiceActivityPos >= 0) {
            boolean isValid = false;
            int i = 0;
            while (true) {
                if (i >= connectCount) {
                    break;
                }
                if (this.mVoiceActivityPos != this.mRemoteSurfaceIDArray[i]) {
                    i++;
                } else {
                    isValid = true;
                    break;
                }
            }
            logI("isValid = " + isValid);
            if (isValid) {
                changePos = this.mVoiceActivityPos;
            } else {
                this.mVoiceActivityPos = -1;
            }
        }
        logI("changePos = " + changePos + ", mRemoteSurfacePos = " + this.mRemoteSurfacePos);
        if (this.mRemoteSurfacePos != changePos) {
            SECConfig.setVideoSurfaceData(changePos + 1, null);
            SECConfig.setVideoSurfaceData(this.mRemoteSurfacePos + 1, null);
            String id1 = this.mRemoteImageView[changePos].getUserID();
            String name1 = this.mRemoteImageView[changePos].getUserName();
            String id2 = this.mRemoteImageView[this.mRemoteSurfacePos].getUserID();
            String name2 = this.mRemoteImageView[this.mRemoteSurfacePos].getUserName();
            this.mRemoteImageView[changePos].setUserInfo(id2, name2);
            this.mRemoteImageView[this.mRemoteSurfacePos].setUserInfo(id1, name1);
            SurfaceView tmpSurf = this.mRemoteSurfaceArray[changePos];
            SurfaceHolder tmpHolder = this.mRemoteHolderArray[changePos];
            MobileMCUImageView tmpImageView = this.mRemoteImageView[changePos];
            this.mRemoteSurfaceArray[changePos] = this.mRemoteSurfaceArray[this.mRemoteSurfacePos];
            this.mRemoteHolderArray[changePos] = this.mRemoteHolderArray[this.mRemoteSurfacePos];
            this.mRemoteImageView[changePos] = this.mRemoteImageView[this.mRemoteSurfacePos];
            this.mRemoteSurfaceArray[this.mRemoteSurfacePos] = tmpSurf;
            this.mRemoteHolderArray[this.mRemoteSurfacePos] = tmpHolder;
            this.mRemoteImageView[this.mRemoteSurfacePos] = tmpImageView;
            SECConfig.setVideoSurfaceData(changePos + 1, this.mRemoteHolderArray[changePos].getSurface());
            SECConfig.setVideoSurfaceData(this.mRemoteSurfacePos + 1, this.mRemoteHolderArray[this.mRemoteSurfacePos].getSurface());
            this.mRemoteSurfacePos = changePos;
        }
    }

    private void setMCUPreviewLayout(int connectCount) {
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) this.mSurfaceViewlayout.getLayoutParams();
        if (this.mIsLocalDeactivated) {
            params.gravity = 51;
            params.width = 5;
            params.height = 5;
            params.topMargin = 0;
            params.leftMargin = 0;
            params.bottomMargin = 0;
            this.mSurfaceViewlayout.setLayoutParams(params);
            params = (FrameLayout.LayoutParams) this.mLocalImageView.getLayoutParams();
        }
        params.gravity = 51;
        logI("setMCUPreviewLayout mImgPoint.x = " + this.mImgPoint.x + ", mImgPoint.y = " + this.mImgPoint.y);
        logI("setMCUPreviewLayout mPreviewWidth = " + this.mPreviewWidth + ", mPreviewHeight = " + this.mPreviewHeight);
        if (connectCount == 3) {
            DisplayMetrics outMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
            float density = outMetrics.density;
            if (getResources().getConfiguration().orientation == 1) {
                params.width = (int) (114.0f * density);
                params.height = (int) (151.0f * density);
                params.setMargins((int) (5.0f * density), (int) (325.0f * density), this.mPreviewPaddingRight, this.mPrviewPaddingButton);
            } else {
                params.width = (int) (141.0f * density);
                params.height = (int) (106.0f * density);
                params.setMargins((int) (299.0f * density), (int) (225.0f * density), this.mPreviewPaddingRight, this.mPrviewPaddingButton);
            }
        } else if (getResources().getConfiguration().orientation == 1) {
            params.width = this.mPreviewWidth;
            params.height = this.mPreviewHeight;
            params.setMargins(this.mImgPoint.x, this.mImgPoint.y, this.mPreviewPaddingRight, this.mPrviewPaddingButton);
        } else {
            params.width = this.mPreviewHeight;
            params.height = this.mPreviewWidth;
            params.setMargins(this.mImgPoint.x, this.mImgPoint.y, this.mLandPreviewPaddingRight, this.mLandPrviewPaddingButton);
        }
        if (this.mIsLocalDeactivated) {
            this.mLocalImageView.setLayoutParams(params);
            this.mLocalImageView.doAction(true);
        } else {
            this.mSurfaceViewlayout.setLayoutParams(params);
            this.mLocalImageView.doAction(false);
        }
        FrameLayout.LayoutParams params2 = (FrameLayout.LayoutParams) this.mSurface.getLayoutParams();
        params2.width = -1;
        params2.height = -1;
        params2.gravity = 119;
        params2.setMargins(0, 0, 0, 0);
        this.mSurface.setLayoutParams(params2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMobileMCULayout(boolean isSelf) {
        int[] idArray;
        boolean changed;
        if (this.mShareViewCtrl.isActive()) {
            logI("setMobileMCULayout in ShareView Status. Skip!!");
            return;
        }
        int connectCount = getConferenceConnectCount();
        logI("setMobileMCULayout connectCount = " + connectCount);
        if (connectCount != 0 && CallState.isConnected(this.mCallState)) {
            boolean bChanged = false;
            swapRemoteSurface(connectCount);
            setMCUPreviewLayout(connectCount);
            int[] notUsedID = new int[this.mMaxRemoteCnt];
            int[] switchedID = new int[this.mMaxRemoteCnt];
            for (int i = 0; i < this.mMaxRemoteCnt; i++) {
                notUsedID[i] = i;
            }
            if (this.mVoiceActivityPos > 0) {
                for (int i2 = 0; i2 < connectCount; i2++) {
                    if (this.mRemoteSurfaceIDArray[i2] == 0) {
                        switchedID[i2] = this.mVoiceActivityPos;
                    } else if (this.mRemoteSurfaceIDArray[i2] == this.mVoiceActivityPos) {
                        switchedID[i2] = 0;
                    } else {
                        switchedID[i2] = this.mRemoteSurfaceIDArray[i2];
                    }
                }
                idArray = switchedID;
            } else {
                idArray = this.mRemoteSurfaceIDArray;
            }
            for (int i3 = 0; i3 < connectCount; i3++) {
                if (!this.mIsLocalDeactivated && !this.mIsRemoteDeactivatedArray[idArray[i3]]) {
                    notUsedID[idArray[i3]] = -1;
                }
                int orientationChanged = (this.mRemoteRotationArray[idArray[i3]] - this.mSavedOrientation) % EngineCallBackInterface.SIP_RINGTONE_NONE;
                logI("i = " + i3 + ", idArray[i] = " + idArray[i3]);
                if (orientationChanged == 0) {
                    if (this.mModelInfo.isTabDevice()) {
                        changed = false;
                    } else {
                        changed = true;
                    }
                } else if (this.mModelInfo.isTabDevice()) {
                    changed = true;
                } else {
                    changed = false;
                }
                boolean rChanged = changedMCURemoteLayout(connectCount, i3, idArray[i3], changed);
                if (!bChanged) {
                    bChanged = rChanged;
                }
            }
            for (int i4 = 0; i4 < this.mMaxRemoteCnt; i4++) {
                logI("i = " + i4 + ", notUsedID[i] = " + notUsedID[i4]);
                if (notUsedID[i4] >= 0) {
                    SurfaceView sView = this.mRemoteSurfaceArray[notUsedID[i4]];
                    FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) sView.getLayoutParams();
                    params.gravity = 51;
                    params.width = this.mPreviewWidth;
                    params.height = this.mPreviewHeight;
                    params.setMargins(-300, -332, this.mPreviewPaddingRight, this.mPrviewPaddingButton);
                    sView.setLayoutParams(params);
                }
            }
            if (isSelf) {
                sendRotationInfoToServer(this.mSavedOrientation, bChanged);
            }
        }
    }

    private void setSECOrientation(int remoteRotation, boolean isSelf) throws Throwable {
        boolean bChanged;
        logI("setSECOrientation() : mSavedOrientation " + this.mSavedOrientation + " remoteRotation: " + remoteRotation + "isSelf: " + isSelf);
        if (MainApplication.mPhoneManager.isConfTest() && CallState.isConnected(this.mCallState)) {
            setMobileMCULayout(isSelf);
            return;
        }
        if (isConference()) {
            initRemoteSurface();
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) this.mRemoteSurface.getLayoutParams();
            params.width = -1;
            params.height = -1;
            params.gravity = 119;
            if (getResources().getConfiguration().orientation == 1) {
                params.topMargin = this.mModelInfo.getCallStatusBarHeight();
                params.bottomMargin = this.mModelInfo.getPortPaddingBottom();
                params.rightMargin = 0;
            } else {
                params.topMargin = 0;
                params.bottomMargin = 0;
                params.rightMargin = 0;
            }
            this.mRemoteSurface.setLayoutParams(params);
            if (isSelf) {
                sendRotationInfoToServer(this.mSavedOrientation, false);
            }
            if (isAutorotationActive()) {
                if (isSelf && this.mUseDualCamera) {
                    setDualPositionForDualPosition(false);
                    return;
                }
                return;
            }
            if (isSelf) {
                if (this.mUseDualCamera) {
                    setDualPositionForDualPosition(true);
                }
                setHideMeOrientation();
                return;
            }
            return;
        }
        this.mIsTabDevice = this.mModelInfo.isTabDevice();
        int orientationChanged = (remoteRotation - this.mSavedOrientation) % EngineCallBackInterface.SIP_RINGTONE_NONE;
        logI("orientationChanged: " + orientationChanged);
        if (orientationChanged == 0) {
            if (this.mIsTabDevice) {
                bChanged = changedRemoteLayout(false);
            } else {
                bChanged = changedRemoteLayout(true);
            }
        } else if (this.mIsTabDevice) {
            bChanged = changedRemoteLayout(true);
        } else {
            bChanged = changedRemoteLayout(false);
        }
        if (isSelf) {
            sendRotationInfoToServer(this.mSavedOrientation, bChanged);
        }
        if (isAutorotationActive()) {
            if (isSelf && this.mUseDualCamera) {
                setDualPositionForDualPosition(false);
            }
        } else if (isSelf) {
            if (this.mUseDualCamera) {
                setDualPositionForDualPosition(true);
            }
            setHideMeOrientation();
        }
        updateShareViewZoomLayoutRotation();
    }

    private void initRemoteSurface() {
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
        initRemoteSurface();
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
                param.bottomMargin = this.mPreviewMarginButtom + ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO;
                if (this.mModelInfo != null) {
                    param.topMargin = this.mModelInfo.getCallStatusBarHeight() + this.mModelInfo.getPreviewWidth();
                    param.bottomMargin = this.mPreviewMarginButtom + this.mModelInfo.getPreviewWidth();
                }
            } else {
                param.gravity = 49;
                param.leftMargin = 196;
                param.rightMargin = 196;
                if (this.mModelInfo != null) {
                    param.leftMargin = this.mModelInfo.getLandPreviewWidth();
                    param.rightMargin = this.mModelInfo.getLandPreviewWidth();
                }
                param.bottomMargin = this.mLandRemoteViewMarginButtom;
            }
        } else {
            param.gravity = 119;
            param.leftMargin = 0;
            param.rightMargin = 0;
            if (getResources().getConfiguration().orientation == 1) {
                if (this.mShareViewCtrl.isActive() && this.mShareViewCtrl.isFullScreen()) {
                    param.topMargin = 0;
                    param.bottomMargin = 0;
                } else {
                    param.topMargin = this.mModelInfo.getCallStatusBarHeight();
                    param.bottomMargin = this.mPreviewMarginButtom;
                }
            } else {
                param.topMargin = 0;
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
        if (this.mChangePreviewRotation != changed && this.mIsOtherCapture) {
            finishCaptureImgShow();
        }
        if (!this.mReturnPreview) {
            switchAutoModePreviewPosition();
        }
        this.mChangePreviewRotation = changed;
        this.mReturnPreview = false;
        this.mVideoRepositionView.setChangePointStatus(this.mImgPoint, changed, this.mDisplayWidth, this.mDisplayHeight);
        switchPreviewPosition(changed);
        setSurfaceViewLayout();
        if (this.mMyImageOnly) {
            gonePreviewLayout();
        }
        if (getResources().getConfiguration().orientation == 1) {
            if (!this.mChangePreviewRotation) {
                return false;
            }
            return true;
        }
        if (this.mChangePreviewRotation) {
            return false;
        }
        return true;
    }

    private void setSurfaceViewLayout() {
        logI("setSurfaceViewLayout");
        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mSurfaceViewlayout.getLayoutParams();
        if (getResources().getConfiguration().orientation == 1) {
            if (this.mChangePreviewRotation) {
                param.width = this.mPreviewHeight;
                param.height = this.mPreviewWidth;
                param.setMargins(this.mImgPoint.x - this.mHWGap, this.mImgPoint.y + this.mHWGap, this.mPreviewPaddingRight, this.mPrviewPaddingButton);
            } else {
                param.width = this.mPreviewWidth;
                param.height = this.mPreviewHeight;
                param.setMargins(this.mImgPoint.x, this.mImgPoint.y, this.mPreviewPaddingRight, this.mPrviewPaddingButton);
            }
        } else if (this.mChangePreviewRotation) {
            param.width = this.mPreviewWidth;
            param.height = this.mPreviewHeight;
            param.rightMargin = this.mLandPreviewPaddingRight;
            param.setMargins((this.mImgPoint.x + this.mHWGap) - 3, (this.mImgPoint.y - this.mHWGap) + 3, this.mLandPreviewPaddingRight, this.mLandPrviewPaddingButton);
        } else {
            param.width = this.mPreviewHeight;
            param.height = this.mPreviewWidth;
            param.rightMargin = this.mLandPreviewPaddingRight;
            param.setMargins(this.mImgPoint.x, this.mImgPoint.y, this.mLandPreviewPaddingRight, this.mLandPrviewPaddingButton);
        }
        param.gravity = 51;
        this.mSurfaceViewlayout.setLayoutParams(param);
        this.mSurfaceViewlayout.setVisibility(0);
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
            Log.m2963i("switchPreviewPosition changed =  true");
            initPreviewPosition(true);
        } else {
            Log.m2963i("switchPreviewPosition changed =  false");
            initPreviewPosition(false);
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
        this.mDisplayWidth = getWindowManager().getDefaultDisplay().getWidth();
        this.mDisplayHeight = getWindowManager().getDefaultDisplay().getHeight();
        logI("getScreenSize() width: " + this.mDisplayWidth + " height: " + this.mDisplayHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCameraForVideoCall() {
        logI("removeCameraForVideoCall()");
        Message msg = new Message();
        msg.what = EventCode.EVENT_CALL_CAMERA_VIDEOCALL;
        sendHandlerMessage(msg, 200L);
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void startFadeInAnimation() throws Resources.NotFoundException {
        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mSurfaceViewlayout.getLayoutParams();
        this.mSurfaceViewlayoutAnim.setVisibility(0);
        this.mSurfaceViewlayoutAnim.setLayoutParams(param);
        Animation fade_in_animation = AnimationUtils.loadAnimation(this.mSurfaceViewlayoutAnim.getContext(), C0000R.anim.fade_in_effect);
        fade_in_animation.setDuration(300L);
        this.mSurfaceViewlayoutAnim.startAnimation(fade_in_animation);
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void startFadeOutAnimation() throws Resources.NotFoundException {
        Animation.AnimationListener fadeOutListener = new Animation.AnimationListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation arg0) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation arg0) {
                VideoCallActivity.this.mSurfaceViewlayoutAnim.setVisibility(8);
            }
        };
        Animation fade_out_animation = AnimationUtils.loadAnimation(this.mSurfaceViewlayoutAnim.getContext(), C0000R.anim.fade_out_effect);
        fade_out_animation.setAnimationListener(fadeOutListener);
        fade_out_animation.setDuration(500L);
        this.mSurfaceViewlayoutAnim.startAnimation(fade_out_animation);
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void toggleCamera() {
    }

    public void setCameraToggle(int switchCameraPosition) {
        this.mSwitchCameraState = switchCameraPosition;
    }

    public int getCameraToggle() {
        return this.mSwitchCameraState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCameraForToggle() {
        Message msg = new Message();
        msg.what = EventCode.EVENT_CALL_CAMERA_TOGGLE;
        sendHandlerMessage(msg, 200L);
    }

    public void surfaceChanged(SurfaceHolder holder, int arg1, int arg2, int arg3) {
        SurfaceHolder remoteHolder;
        logI("surfaceChanged()");
        if (!this.mIsQuickEndCall) {
            if (MainApplication.mPhoneManager.isConfTest()) {
                remoteHolder = this.mRemoteHolderArray[this.mRemoteSurfaceIDArray[0]];
            } else {
                remoteHolder = this.mRemoteHolder;
            }
            if (this.mChanagePreview) {
                if (remoteHolder != null && remoteHolder.equals(holder)) {
                    SECConfig.setVideoSurfaceData(0, null);
                    SECConfig.setVideoSurfaceData(0, holder.getSurface());
                    return;
                } else if (this.mHolder != null && this.mHolder.equals(holder)) {
                    SECConfig.setVideoSurfaceData(1, null);
                    SECConfig.setVideoSurfaceData(1, holder.getSurface());
                    return;
                }
            } else if (this.mHolder != null && this.mHolder.equals(holder)) {
                SECConfig.setVideoSurfaceData(0, null);
                SECConfig.setVideoSurfaceData(0, holder.getSurface());
                return;
            } else if (remoteHolder != null && remoteHolder.equals(holder)) {
                SECConfig.setVideoSurfaceData(1, null);
                SECConfig.setVideoSurfaceData(1, holder.getSurface());
                return;
            }
            if (MainApplication.mPhoneManager.isConfTest()) {
                for (int i = 0; i < this.mMaxRemoteCnt; i++) {
                    if (this.mRemoteHolderArray[this.mRemoteSurfaceIDArray[i]] != null && this.mRemoteHolderArray[this.mRemoteSurfaceIDArray[i]].equals(holder)) {
                        SECConfig.setVideoSurfaceData(i + 1, holder.getSurface());
                        return;
                    }
                }
            }
        }
    }

    public void surfaceCreated(SurfaceHolder holder) {
        SurfaceHolder remoteHolder;
        if (!this.mIsQuickEndCall) {
            logI("surfaceCreated()");
            if (MainApplication.mPhoneManager.isConfTest()) {
                remoteHolder = this.mRemoteHolderArray[this.mRemoteSurfaceIDArray[0]];
            } else {
                remoteHolder = this.mRemoteHolder;
            }
            if (this.mChanagePreview) {
                if (remoteHolder != null && remoteHolder.equals(holder)) {
                    SECConfig.setVideoSurfaceData(0, holder.getSurface());
                    return;
                } else if (this.mHolder != null && this.mHolder.equals(holder)) {
                    SECConfig.setVideoSurfaceData(1, holder.getSurface());
                    return;
                }
            } else if (this.mHolder != null && this.mHolder.equals(holder)) {
                SECConfig.setVideoSurfaceData(0, holder.getSurface());
                return;
            } else if (remoteHolder != null && remoteHolder.equals(holder)) {
                SECConfig.setVideoSurfaceData(1, holder.getSurface());
                return;
            }
            if (MainApplication.mPhoneManager.isConfTest()) {
                for (int i = 0; i < this.mMaxRemoteCnt; i++) {
                    if (this.mRemoteHolderArray[this.mRemoteSurfaceIDArray[i]] != null && this.mRemoteHolderArray[this.mRemoteSurfaceIDArray[i]].equals(holder)) {
                        SECConfig.setVideoSurfaceData(i + 1, holder.getSurface());
                        return;
                    }
                }
            }
        }
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        SurfaceHolder remoteHolder;
        logI("surfaceDestroyed()");
        if (!this.mSurfaceDestroyed) {
            if (MainApplication.mPhoneManager.isConfTest()) {
                remoteHolder = this.mRemoteHolderArray[this.mRemoteSurfaceIDArray[0]];
            } else {
                remoteHolder = this.mRemoteHolder;
            }
            if (this.mChanagePreview) {
                if (remoteHolder != null && remoteHolder.equals(holder)) {
                    SECConfig.setVideoSurfaceData(0, null);
                    return;
                } else if (this.mHolder != null && this.mHolder.equals(holder)) {
                    SECConfig.setVideoSurfaceData(1, null);
                    return;
                }
            } else if (this.mHolder != null && this.mHolder.equals(holder)) {
                SECConfig.setVideoSurfaceData(0, null);
                return;
            } else if (remoteHolder != null && remoteHolder.equals(holder)) {
                SECConfig.setVideoSurfaceData(1, null);
                return;
            }
            if (MainApplication.mPhoneManager.isConfTest()) {
                for (int i = 0; i < this.mMaxRemoteCnt; i++) {
                    if (this.mRemoteHolderArray[this.mRemoteSurfaceIDArray[i]] != null && this.mRemoteHolderArray[this.mRemoteSurfaceIDArray[i]].equals(holder)) {
                        SECConfig.setVideoSurfaceData(i + 1, null);
                        return;
                    }
                }
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder holder) {
        SurfaceHolder remoteHolder;
        if (!this.mIsQuickEndCall) {
            logI("surfaceRedrawNeeded()");
            if (MainApplication.mPhoneManager.isConfTest()) {
                remoteHolder = this.mRemoteHolderArray[this.mRemoteSurfaceIDArray[0]];
            } else {
                remoteHolder = this.mRemoteHolder;
            }
            if (this.mChanagePreview) {
                if (remoteHolder != null && remoteHolder.equals(holder)) {
                    SECConfig.setVideoSurfaceData(0, null);
                    SECConfig.setVideoSurfaceData(0, holder.getSurface());
                    return;
                } else if (this.mHolder != null && this.mHolder.equals(holder)) {
                    SECConfig.setVideoSurfaceData(1, null);
                    SECConfig.setVideoSurfaceData(1, holder.getSurface());
                    return;
                }
            } else if (this.mHolder != null && this.mHolder.equals(holder)) {
                SECConfig.setVideoSurfaceData(0, null);
                SECConfig.setVideoSurfaceData(0, holder.getSurface());
                return;
            } else if (remoteHolder != null && remoteHolder.equals(holder)) {
                SECConfig.setVideoSurfaceData(1, null);
                SECConfig.setVideoSurfaceData(1, holder.getSurface());
                return;
            }
            if (MainApplication.mPhoneManager.isConfTest()) {
                for (int i = 0; i < this.mMaxRemoteCnt; i++) {
                    if (this.mRemoteHolderArray[this.mRemoteSurfaceIDArray[i]] != null && this.mRemoteHolderArray[this.mRemoteSurfaceIDArray[i]].equals(holder)) {
                        SECConfig.setVideoSurfaceData(i + 1, holder.getSurface());
                        return;
                    }
                }
            }
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showDialPad(boolean showPad) {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected int calculateDuration() {
        return (int) this.mVideoCallStatusBar.getElapsedTimeInMilisec();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void denyCall() {
        logI("denyCall()");
        if (!this.mAlreadyDenied) {
            if (this.mBargeInController != null) {
                this.mBargeInController.dispose();
            }
            this.mAlreadyDenied = true;
            MainApplication.mPhoneManager.getPhoneStateMachine().setCallingActivity(null);
            immediatelyQuitWithoutAnimation();
            cancelSpeakerphone();
            cancelBTHeadset();
            this.mAutoReceiveCnt = false;
            new Thread(new Runnable() { // from class: com.coolots.chaton.call.view.VideoCallActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    MainApplication.mPhoneManager.getPhoneStateMachine().connectCall(VideoCallActivity.this.mDestination, VideoCallActivity.this.mCallID, false, 100, MainApplication.mConfig.isSecureCommunication(), "");
                }
            }).start();
            changeCoverLockUI(false);
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void denyCallwithRejectMsg(final int hangupCode, final String hangupMsg) {
        logI("denyCallwithRejectMsg() hangupCode: " + hangupCode + " hangupMsg: " + hangupMsg);
        if (!this.mAlreadyDenied && hangupCode != -1) {
            if (this.mBargeInController != null) {
                this.mBargeInController.dispose();
            }
            this.mAlreadyDenied = true;
            MainApplication.mPhoneManager.getPhoneStateMachine().setCallingActivity(null);
            immediatelyQuitWithoutAnimation();
            cancelSpeakerphone();
            cancelBTHeadset();
            new Thread(new Runnable() { // from class: com.coolots.chaton.call.view.VideoCallActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    VideoCallActivity.this.sendRejectMessage(hangupMsg);
                    MainApplication.mPhoneManager.getPhoneStateMachine().connectCall(VideoCallActivity.this.mDestination, VideoCallActivity.this.mCallID, false, hangupCode, MainApplication.mConfig.isSecureCommunication(), hangupMsg);
                }
            }).start();
            changeCoverLockUI(false);
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

    @Override // com.sds.coolots.call.view.CallActivity
    public void hangupCall() {
        logI("hangupCall()");
        if (this.mBargeInController != null) {
            this.mBargeInController.dispose();
        }
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.setHangUpButtonToggle(false);
        }
        synchronized (this.hangupMutex) {
            new Thread(new Runnable() { // from class: com.coolots.chaton.call.view.VideoCallActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    int ret = MainApplication.mPhoneManager.getPhoneStateMachine().localHangupCall(VideoCallActivity.this.mDestination, 10);
                    if (ret == -1012) {
                        Message msg = new Message();
                        msg.what = EventCode.EVENT_CALL_ACTION;
                        VideoCallActivity.this.sendHandlerMessage(msg, 0L);
                    }
                    if (ret == -1106) {
                        VideoCallActivity.this.logI(" hangupCall == ERROR_INVALID_CALL_SATATE_FOR_END_CALL ");
                        VideoCallActivity.this.mHandler.sendEmptyMessage(EventCode.EVENT_CALL_ACTION);
                    }
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void quicklyHangupCall() {
        synchronized (this.hangupMutex) {
            new Thread(new Runnable() { // from class: com.coolots.chaton.call.view.VideoCallActivity.11
                @Override // java.lang.Runnable
                public void run() {
                    if (MainApplication.mPhoneManager.getPhoneStateMachine().localHangupCall(VideoCallActivity.this.mDestination, 10) == -1012) {
                        VideoCallActivity.this.quitActivity();
                    }
                }
            }).start();
        }
    }

    public void hangupCallWithQuickDestroy(String msg) {
        logI("hangupCallWithQuickDestroy(" + msg + ")");
        showLongToast(msg);
        this.mIsQuickEndCall = true;
        this.mHandler.sendEmptyMessageDelayed(EventCode.EVENT_VIDEO_INCOMING_CALL_HANGUP_QUICKLY, 3000L);
    }

    public void videoCallEndUIDisplaybeforeCamrelease() {
        logI("videoCallEndUIDisplaybeforeCamrelease()");
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        dismissVideoDialog();
        if (this.mRecordTimer) {
            this.mRecordTime.stop();
            this.mRecordTimer = false;
        }
        this.mCallEndBtnLayout.setData(this.mDestination, this, this.mCalluserInfo.userNo);
        this.mCallOutgoingCallLayout.setTimeData(this.mVideoCallStatusBar.getElapsedTime(), this.mCountConnectedState);
        if (isCoverOpen()) {
            this.mCallOutgoingCallLayout.setVisibility(0);
            this.mCallerImageLayout.setVisibility(0);
            this.mCoverEndCallLayout.setVisibility(8);
        } else {
            this.mCallOutgoingCallLayout.setVisibility(8);
            this.mCallerImageLayout.setVisibility(8);
            this.mCoverEndCallLayout.setVisibility(0);
            this.mCoverEndCallLayout.setClearCoverActive(this.mCalluserInfo);
        }
        this.mCoverRecieveLayout.setVisibility(8);
        this.mVideolayout.setVisibility(8);
        this.mVideoRepositionView.setVisibility(8);
        this.mCallInfoBGLayout.setVisibility(8);
        this.mCallBtnLayout.setVisibility(8);
        this.mVideoCallDrivingBtnLayout.setVisibility(8);
        if (MainApplication.mPhoneManager.isTranslateTest()) {
            this.mCallTranslatorLayout.setVisibility(8);
        }
        this.mCallReceiveBtnLayout.setVisibility(8);
        this.mInnerHandler.sendEmptyMessageDelayed(1, 1300L);
        if (MainApplication.mPhoneManager.getHardwareManager().getSoundManager().isSpeakerOn(MainApplication.mContext)) {
            disableSpeakerCall();
        }
        closeOptionsMenu();
        this.mMenu = null;
        notiToUserDisconnectedInActivity();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void receiveCall() {
        logI("receiveCall()");
        if (this.mBargeInController != null) {
            this.mBargeInController.dispose();
        }
        unregisterGestureManager();
        this.mAutoReceiveCnt = false;
        cacelReceiveCall();
        int retVal = MainApplication.mPhoneManager.getPhoneStateMachine().connectCall(this.mDestination, this.mCallID, true, 10, MainApplication.mConfig.isSecureCommunication(), "");
        if (retVal != 0) {
            Message msg = new Message();
            msg.what = EventCode.EVENT_CALL_ACTION;
            sendHandlerMessage(msg, 0L);
        }
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setOptionMenu(int menuId) throws Throwable {
        logI("setOptionMenu()");
        if (isChangeToConference()) {
            showToast(C0000R.string.change_to_conference_wait);
            logE("WAIT: change to conference");
        }
        if (checkOptionMenuDisable(menuId)) {
            invalidateOptionsMenu();
            return;
        }
        switch (menuId) {
            case 1:
                logI("MENU_HIDE_ME");
                setAlterImage();
                cancelSlectedThemeShot();
                invalidateOptionsMenu();
                break;
            case 2:
                changeLayoutPreviewSingleTab();
                break;
            case 3:
                logI("OPT_INVITE_BUDDIES");
                if (this.mIsCallHoldOn) {
                    Toast.makeText(this, getResources().getString(C0000R.string.unable_invite_buddy_invalid_call_hold), 0).show();
                } else {
                    sendSelectedListIntent(1, 1);
                }
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
                if (this.mIsCallHoldOn) {
                    Toast.makeText(this, getResources().getString(C0000R.string.call_switch_on_hold_with_voice), 0).show();
                } else {
                    if (this.mDestination.getDestinationType() == 4 || this.mDestination.getDestinationType() == 5) {
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
                    } else if (sendRequestConsent(1, 1)) {
                        showCallConsentProcessingDialog(1, 1);
                    } else {
                        showToast(C0000R.string.call_switching_to_voice_cannot_start);
                    }
                }
                invalidateOptionsMenu();
                break;
            case 9:
                logI("MENU_CARTOON_VIEW");
                displayCartoonView();
                invalidateOptionsMenu();
                break;
            case 10:
                logI("OPT_SHARE_SCREEN_CHATONV ");
                this.mIsShareScreenCaller = false;
                StaticsManager.getInstance().setShareEffectsShareScreenFlag();
                if (this.mIsCallHoldOn) {
                    Toast.makeText(this, getResources().getString(C0000R.string.screenshare_other_call_hold), 0).show();
                    break;
                } else if (((ChatOnConfigInterface) MainApplication.mConfig).isShareScreenCopyRight()) {
                    displayShareScreenAttention();
                    break;
                } else {
                    displayDialog(21);
                    break;
                }
            case 11:
                logI("OPT_SHARE_VIEW_CHATONV");
                StaticsManager.getInstance().setShareEffectsShareCameraFlag();
                if (this.mIsCallHoldOn) {
                    Toast.makeText(this, getResources().getString(C0000R.string.share_view_other_call_hold), 0).show();
                } else {
                    this.mShareViewCtrl.setType(2);
                    showToast(getResources().getString(C0000R.string.share_view_toast_popup_1));
                    sendRequestConsent(2, 0);
                }
                invalidateOptionsMenu();
                break;
            case 12:
                logI("OPT_MANAGE_CONFERENCE_CALL");
                startMemberView(this.mVideoCallStatusBar);
                this.mVideoCallStatusBar.unClickableStatusBarFuctionBtn();
                invalidateOptionsMenu();
                break;
            case 13:
                if (!this.mUseDualCamera) {
                    if (IsEnableDualCamera()) {
                        startDualCamera();
                    } else {
                        showToast(C0000R.string.call_dual_camera_unable_start);
                    }
                } else {
                    stopDualCamera();
                }
                invalidateOptionsMenu();
                break;
            case 14:
                this.mIsTranslatorOptionMenuEnable = false;
                closeSTTTranslationTTS(false);
                initSTTTranslationTTS();
                showDialog(TRANSLATOR_DIALOG);
                translatorChagneUi(this.mIsTranslatorOptionMenuEnable);
                break;
            case 15:
                stopTranslator();
                break;
            case 40:
                logI("MENU_send_via_chaton");
                launchSharefile_via_ChatOn(this.mDestination.getString());
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

    private void stopTranslator() throws Throwable {
        this.mIsTranslatorOptionMenuEnable = false;
        closeSTTTranslationTTS(true);
        translatorChagneUi(this.mIsTranslatorOptionMenuEnable);
        this.mChatOnTranslationDataController.initTTSData();
    }

    public boolean IsEnableDualCamera() throws NumberFormatException {
        String level = SystemProperties.get("sys.siop.curlevel");
        logI("IsEnableDualCamera system temperature level = " + level);
        if (level == null || level.equals("")) {
            return true;
        }
        int templevel = Integer.parseInt(level);
        return templevel <= 1;
    }

    private void hideInviteViewInStatusbar() {
        if (getResources().getConfiguration().orientation == 2 && this.mInviteviewMemberLayout.isShowing()) {
            this.mTitleBarHandler.removeMessages(0);
            this.mTitleBarHandler.removeMessages(4);
            this.mTitleBarHandler.sendEmptyMessageDelayed(4, 1000L);
        }
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setOptionMenuDialog(int menuId) {
        if (isChangeToConference()) {
            showToast(C0000R.string.change_to_conference_wait);
            logE("WAIT: change to conference");
        }
        switch (menuId) {
            case 7:
                showToast(C0000R.string.video_animated_emotioins_theme_view_info);
                MainApplication.mPhoneManager.getPhoneStateMachine().stopAvatar(this.mDestination);
                this.mVideoCallOptionMng.resetAnimationData();
                this.mVideoCallOptionMng.changeStatus(1);
                this.mVideoCallStatusBar.hideStatusBar();
                this.mVideoCallOptionMng.showOptionMenu();
                hideInviteViewInStatusbar();
                break;
            case 8:
                showToast(C0000R.string.video_animated_emotioins_theme_view_info);
                MainApplication.mPhoneManager.getPhoneStateMachine().stopAvatar(this.mDestination);
                this.mVideoCallOptionMng.resetAnimationData();
                this.mVideoCallOptionMng.changeStatus(2);
                this.mVideoCallStatusBar.hideStatusBar();
                this.mVideoCallOptionMng.showOptionMenu();
                hideInviteViewInStatusbar();
                break;
            case 9:
                logI("MENU_CARTOON_VIEW");
                displayCartoonView();
                break;
            case 40:
                logI("MENU_send_via_chaton");
                launchSharefile_via_ChatOn(this.mDestination.getString());
                break;
            case 44:
                openChatService();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startShareScreen() {
        logI("Real start ShareScreen");
        MainApplication.mPhoneManager.getPhoneStateMachine().setOtherPartyName(this.mDestination, this.mCalluserInfo.userName);
        sendRequestConsent(3, 0);
        showCallConsentProcessingDialog(3, 0);
    }

    private void openChatService() {
        ChatOnService chatonservice = ChatOnService.createService(this);
        logI("openChatService No room number");
        if (isConference()) {
            logI("openChatService No room number conference");
            ArrayList<String> callmemberAccountIDlist = this.mDestinationUtil.getConferenceConnectUserIDList(this.mDestination, null);
            ArrayList<String> callmemberBuddyIDlist = chatonservice.getChatOnBuddyNumberAsIdList(callmemberAccountIDlist);
            chatonservice.openChatService(callmemberBuddyIDlist);
            return;
        }
        logI("openChatService No room number 1:1");
        String AccountId = ChatONStringConvert.getInstance().removeFooter(this.mDestination.getString());
        chatonservice.openChatService(AccountId);
    }

    private void changeAvatarOption() {
        if (this.mUseAvatar) {
            MainApplication.mPhoneManager.getPhoneStateMachine().stopAvatar(this.mDestination);
        } else {
            MainApplication.mPhoneManager.getPhoneStateMachine().startAvatar(this.mDestination);
        }
    }

    private void createCustomAvatar() {
        if (!this.mUseAvatar) {
            logE("Not Avatar mode!!");
        } else {
            MainApplication.mPhoneManager.getPhoneStateMachine().createCustomAvatar(this.mDestination);
        }
    }

    private void changeAvatarHair() {
        if (!this.mUseAvatar) {
            logE("Not Avatar mode!!");
        } else {
            MainApplication.mPhoneManager.getPhoneStateMachine().changeAvatarHair(this.mDestination);
        }
    }

    private void changeAvatarGlasses() {
        if (!this.mUseAvatar) {
            logE("Not Avatar mode!!");
        } else {
            MainApplication.mPhoneManager.getPhoneStateMachine().changeAvatarGlasses(this.mDestination);
        }
    }

    private void launchSharefile_via_ChatOn(String AccontId) {
        ChatOnService chatonservice = ChatOnService.createService(this);
        if (chatonservice != null) {
            String AccountId = ChatONStringConvert.getInstance().removeFooter(AccontId);
            Intent i = new Intent("android.intent.action.SEND");
            Uri data = Uri.parse("chaton://file");
            i.setData(data);
            i.putExtra("receiver", AccountId);
            startActivity(i);
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

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) throws Throwable {
        logI("onPrepareOptionsMenu()");
        logI("mMemberViewCtrl.ismMemberViewActive() : " + this.mMemberViewCtrl.ismMemberViewActive());
        if (this.mMemberViewCtrl.ismMemberViewActive() || !CallState.isConnected(this.mCallState)) {
            return false;
        }
        if (isChangeToConference()) {
            showToast(C0000R.string.change_to_conference_wait);
            logE("WAIT: change to conference");
            return false;
        }
        this.mMenu = menu;
        checkCallInstanceNRefresh();
        if (this.mOptionMenuData == null) {
            this.mOptionMenuData = new VideoOptionMenuData(this);
        }
        this.mOptionMenuData.loadMenu(this.mShareViewCtrl, this.mIsShareScreenWaitForAccepting, this.mCallFunctionController.isEnableConsentProcessing(), isConference(), this.mIsOutGoingCall, this.mDestinationUtil.getConferenceWaitCount(this.mDestination) > 0, this.mIsTranslatorOptionMenuEnable);
        this.mIsSpeaker = getAudioPathController().isSpeakerON();
        this.mOptionMenuData.setAttribute(this.mUseAlterImage, this.mIsSpeaker, this.mIsBlueTooth, this.mUseDualCamera);
        if (this.mVideoCallOptionMng.isShowingAnyMenu()) {
            ArrayList<String> disableItemList = new ArrayList<>();
            disableItemList.add(getResources().getText(C0000R.string.call_menu_dual_camera_enable).toString());
            this.mOptionMenuData.addToMenu(menu, disableItemList);
        } else {
            this.mOptionMenuData.addToMenu(menu, null);
        }
        OptionMenuLayout.setLayout(this, menu);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) throws Throwable {
        logI("onOptionsItemSelected()");
        super.onOptionsItemSelected(item);
        this.mMenu = null;
        setOptionMenu(item.getItemId());
        return false;
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void closeThemeShotEmotionalAnimation() {
        logI("closeThemeShotEmotionalAnimation()");
        this.mVideoCallOptionMng.changeStatus(0);
        this.mVideoCallOptionMng.resetAnimationData();
        viewTopStatusBar();
        if (this.mShareViewCtrl != null && this.mShareViewCtrl.isActive()) {
            setShareViewCloseBtn();
        }
    }

    private void displayEmotionalAnimationForP2P() {
        this.mVideoCallOptionMng.showOptionMenuForP2P();
    }

    private void displayThemeShotForP2P() {
        this.mVideoCallOptionMng.showOptionMenuForP2P();
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

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public boolean isCartoonView() {
        return this.mIsCartoonView;
    }

    private boolean setRecord() {
        logI("setRecord()");
        if (this.mIsRecording) {
            stopRecordCall();
            this.mIsRecording = false;
            this.mIsRecordRequested = false;
        } else if (startRecordCall()) {
            this.mIsRecording = true;
            setHideMeForCaptureRecord(false);
            return true;
        }
        return false;
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public boolean isRecordingVideo() {
        return this.mIsRecording;
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setAlterImage() {
        logI("setAlterImage()");
        if (this.mUseAlterImage) {
            logI("setAlterImage - stop Image");
            this.mUseAlterImage = false;
            stopHideMeVideoCall();
            reStartOptionMenu();
            this.mHideMeModeType = 0;
            this.mVideoCallOptionMng.stopHideMe();
            this.mCallBtnLayout.setHideme(false);
            this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
            MainApplication.mPhoneManager.isTranslateTest();
            setCallButtonShareViewStart();
        } else {
            this.mUseAlterImage = true;
            this.mVideoCallOptionMng.startHideMe();
            makeHideMeImage();
            visibleBottomShowMeButton(true);
            setCallButtonShareViewStart();
        }
        this.mCallOutgoingCallLayout.setHideMeBtn(this.mUseAlterImage);
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void updateHoldState(boolean bHold) {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void updateMuteState(boolean bMute) {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        Log.m2963i("dispose()");
        this.mAudioManager = null;
        this.windowManager = null;
        this.imm = null;
        ViewRecycleUtil.recurisveRecycle(getWindow().getDecorView());
        this.hangupMutex = null;
        this.mAudioManager = null;
        this.mCalluserInfo = null;
        if (this.mSurfaceViewlayout != null) {
            this.mSurfaceViewlayout.destroyDrawingCache();
            this.mSurfaceViewlayout = null;
        }
        this.mSurfaceViewlayoutAnim = null;
        if (this.mDualCameraTimer != null) {
            this.mDualCameraTimer.cancel();
        }
        this.mGestureDetector = null;
        this.mScaleGestureDetector = null;
        this.mImgPoint = null;
        if (this.mInnerHandler != null) {
            this.mInnerHandler.dispose();
            this.mInnerHandler = null;
        }
        this.mRecordTime = null;
        this.mOnlyBuddyLayout = null;
        this.mModelInfo = null;
        super.dispose();
        if (this.mVideoCallDrivingBtnLayout != null) {
            this.mVideoCallDrivingBtnLayout.dispose();
            this.mVideoCallDrivingBtnLayout = null;
        }
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.dispose();
            this.mCallBtnLayout = null;
        }
        if (this.mCallTranslatorLayout != null) {
            this.mCallTranslatorLayout.dispose();
            this.mCallTranslatorLayout = null;
        }
        if (this.mCallEndBtnLayout != null) {
            this.mCallEndBtnLayout.dispose();
            this.mCallEndBtnLayout = null;
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
        if (this.mCallerImageLayout != null) {
            this.mCallerImageLayout.dispose();
            this.mCallerImageLayout = null;
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
        if (MainApplication.mPhoneManager.isConfTest()) {
            for (int i = 0; i < this.mMaxRemoteCnt; i++) {
                if (this.mRemoteSurfaceArray[i] != null) {
                    this.mRemoteSurfaceArray[i].getHolder().removeCallback(this);
                    this.mRemoteSurfaceArray[i] = null;
                }
            }
            if (this.mRemoteSurface != null) {
                this.mRemoteSurface.getHolder().removeCallback(this);
                this.mRemoteSurface = null;
            }
        } else if (this.mRemoteSurface != null) {
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
        if (this.mInviteviewMemberLayout != null) {
            this.mInviteviewMemberLayout.dispose();
            this.mInviteviewMemberLayout = null;
        }
        if (this.mImage != null) {
            this.mImage.recycle();
            this.mImage = null;
        }
        if (this.mVideoCallEmotiAnimationLayout != null) {
            this.mVideoCallEmotiAnimationLayout.dispose();
            this.mVideoCallEmotiAnimationLayout = null;
        }
        if (this.mVideoCallThemeShotLayout != null) {
            this.mVideoCallThemeShotLayout.dispose();
            this.mVideoCallThemeShotLayout = null;
        }
        if (this.mVideoCallAvatarOptionMenu != null) {
            this.mVideoCallAvatarOptionMenu.dispose();
            this.mVideoCallAvatarOptionMenu = null;
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
        if (this.mContextDialog != null) {
            this.mContextDialog = null;
        }
        if (this.mRemoteDialog != null) {
            this.mRemoteDialog = null;
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
        if (this.mShareScreenAttentionDialog != null) {
            this.mShareScreenAttentionDialog.dismiss();
            this.mShareScreenAttentionDialog = null;
        }
        if (this.mTitleBarHandler != null) {
            removeStatusbarAnimation();
            this.mTitleBarHandler = null;
        }
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
        if (this.mShareViewCloseButtonUp != null) {
            this.mShareViewCloseButtonUp.removeCallbacks(null);
            this.mShareViewCloseButtonUp = null;
        }
        if (this.mShareViewCloseButtonDown != null) {
            this.mShareViewCloseButtonDown.removeCallbacks(null);
            this.mShareViewCloseButtonDown = null;
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
        this.mShareViewPinchZoomGuideScaleText = null;
        if (this.mOptionMenuData != null) {
            this.mOptionMenuData.dispose();
            this.mOptionMenuData = null;
        }
        if (this.option_menu_mode != -1) {
            this.option_menu_mode = -1;
        }
        if (this.mCoverRecieveLayout != null) {
            this.mCoverRecieveLayout.dispose();
            this.mCoverRecieveLayout = null;
        }
        if (this.mCoverEndCallLayout != null) {
            this.mCoverEndCallLayout.dispose();
            this.mCoverEndCallLayout = null;
        }
        if (this.mContentObserver != null) {
            this.mContentObserver = null;
        }
        if (this.mChatOnTranslationDataController != null) {
            this.mChatOnTranslationDataController.dispose();
            this.mChatOnTranslationDataController = null;
        }
        dismissCallConsentUserActionDialog();
        dismissCallConsentProcessingDialog();
    }

    public void disposeForChanginRotation() {
        logI("disposeForChanginRotation()");
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.dispose();
            this.mCallBtnLayout = null;
        }
        if (this.mCallTranslatorLayout != null) {
            this.mCallTranslatorLayout.dispose();
            this.mCallTranslatorLayout = null;
        }
        if (this.mCallEndBtnLayout != null) {
            this.mCallEndBtnLayout.dispose();
            this.mCallEndBtnLayout = null;
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
        if (this.mCallerImageLayout != null) {
            this.mCallerImageLayout.dispose();
            this.mCallerImageLayout = null;
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
        if (MainApplication.mPhoneManager.isConfTest()) {
            for (int i = 0; i < this.mMaxRemoteCnt; i++) {
                if (this.mRemoteSurfaceArray[i] != null) {
                    this.mRemoteSurfaceArray[i].getHolder().removeCallback(this);
                    this.mRemoteSurfaceArray[i] = null;
                }
            }
            if (this.mRemoteSurface != null) {
                this.mRemoteSurface = null;
            }
        } else if (this.mRemoteSurface != null) {
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
        if (this.mInviteviewMemberLayout != null) {
            this.mInviteviewMemberLayout.dispose();
            this.mInviteviewMemberLayout = null;
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
        if (this.mVideoCallEmotiAnimationLayout != null) {
            this.mVideoCallEmotiAnimationLayout.dispose();
            this.mVideoCallEmotiAnimationLayout = null;
        }
        if (this.mVideoCallThemeShotLayout != null) {
            this.mVideoCallThemeShotLayout.dispose();
            this.mVideoCallThemeShotLayout = null;
        }
        if (this.mVideoCallAvatarOptionMenu != null) {
            this.mVideoCallAvatarOptionMenu.dispose();
            this.mVideoCallAvatarOptionMenu = null;
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

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent event) throws Throwable {
        Log.m2963i("onTouchEvent()");
        if (this.mShareViewCtrl.isActive() && getCameraToggle() == 666 && this.mScaleGestureDetector != null) {
            try {
                this.mScaleGestureDetector.onTouchEvent(event);
            } catch (IllegalArgumentException e) {
            }
            if (this.mScaleGestureDetector.isInProgress()) {
                return true;
            }
        }
        if (event.getAction() == 0) {
            if (this.mVideoCallStatusBar.isShowing()) {
                if (!this.mVideoCallStatusBar.isUsingAnimation() && !this.mInviteviewMemberLayout.isUsingAnimation()) {
                    goneTopStatusBar(0);
                }
            } else {
                viewTopStatusBar();
            }
        }
        if (!this.mShareViewCtrl.isActive() && this.mGestureDetector != null) {
            this.mGestureDetector.onTouchEvent(event);
        }
        this.mVideoRepositionView.onTouchEvent(event);
        if (event.getAction() == 1 && this.mIsPreviewAreaScroll) {
            logE("MotionEvent.ACTION_UP");
            if (isShowPreviewTouchMenu()) {
                this.mIsPreviewAreaScroll = false;
                changeLayoutRemoteSingleTab();
                return true;
            }
        }
        if (!this.mIsReposotionView) {
            this.mVideoRepositionView.setDeviceType(this.mModelInfo);
            this.mVideoRepositionView.setDownEvent(event, this.mImgPoint);
        }
        return super.onTouchEvent(event);
    }

    public boolean onDown(MotionEvent arg0) {
        Log.m2963i("onDown()");
        closeOptionsMenu();
        this.mMenu = null;
        if (this.mIsReposotionView) {
            this.mVideoRepositionView.setVisibility(8);
            this.mIsReposotionView = false;
        }
        return false;
    }

    public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
        return false;
    }

    public void onLongPress(MotionEvent event) {
        Log.m2963i("onLongPress()");
        if (CallState.isConnected(this.mCallState)) {
            int posx = (int) event.getX();
            int posy = (int) event.getY();
            this.mVideoRepositionView.onTouchEvent(event);
            setSelectedViewMenu(posx, posy);
        }
    }

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

    public void onShowPress(MotionEvent arg0) {
    }

    public boolean onSingleTapUp(MotionEvent arg0) {
        return false;
    }

    public void setSelectedViewMenu(int posx, int posy) {
        Log.m2963i("setSelectedViewMenu()");
        boolean isSelectedPreview = false;
        if (CallState.isConnected(this.mCallState)) {
            if (!this.mBuddyImageOnly) {
                isSelectedPreview = isImageArea(posx, posy);
            }
            if (isSelectedPreview) {
                if (isMovePreviewTouchMenu()) {
                    closeOptionsMenu();
                    this.mMenu = null;
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
                return;
            }
            if (!isConference() && !this.mIsChangeToConference && isCoverOpen() && this.mShareViewPinchZoomGuideLineLayout.getVisibility() != 0 && !this.mIsRecording && !isRecordRequested()) {
                showDialog(105);
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
        boolean isArea = false;
        int addGap = this.mHWGap + 25;
        if (getResources().getConfiguration().orientation == 1) {
            if (this.mChangePreviewRotation) {
                if (posx > this.mImgPoint.x && posx <= this.mImgPoint.x + this.mPreviewHeight && posy > this.mImgPoint.y + addGap && posy <= this.mImgPoint.y + this.mPreviewWidth + addGap) {
                    isArea = true;
                }
            } else if (posx > this.mImgPoint.x && posx <= this.mImgPoint.x + this.mPreviewWidth && posy > this.mImgPoint.y + addGap && posy <= this.mImgPoint.y + this.mPreviewHeight + addGap) {
                isArea = true;
            }
        } else if (this.mChangePreviewRotation) {
            if (posx > this.mImgPoint.x && posx < this.mImgPoint.x + this.mPreviewWidth && posy > this.mImgPoint.y + this.mHWGap + 25 && posy < this.mImgPoint.y + this.mPreviewHeight + this.mHWGap + 25) {
                isArea = true;
            }
        } else if (posx > this.mImgPoint.x && posx < this.mImgPoint.x + this.mPreviewHeight && posy > this.mImgPoint.y + this.mHWGap + 25 && posy < this.mImgPoint.y + this.mPreviewWidth + this.mHWGap + 25) {
            isArea = true;
        }
        Log.m2963i("checkImageArea() isArea return : " + isArea);
        return isArea;
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

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int menuID) throws Resources.NotFoundException {
        dismissVideoDialog();
        ChatONDialog.Builder progress = new ChatONDialog.Builder(this);
        ChatONDialog.Builder progress_onebutton = new ChatONDialog.Builder(this);
        AlertDialog.Builder alertProgress = new AlertDialog.Builder(this, C0000R.style.ChatONDialogTheme);
        switch (menuID) {
            case TRANSLATOR_DIALOG /* 99 */:
                Set<Integer> voiceLanguage = getRecognitionSupportedVoiceLanguage();
                Set<Integer> transferLanguage = getTranslationSupportedOutLanguage(10);
                logI("voiceLanguage: " + voiceLanguage.toString());
                if (transferLanguage != null) {
                    logI("transferLanguage: " + transferLanguage.toString());
                }
                ChatONTranslatorDialog.Builder builder4 = new ChatONTranslatorDialog.Builder(this, this, voiceLanguage);
                builder4.setTitle(getResources().getText(C0000R.string.call_menu_translator));
                builder4.setMessageTop(getResources().getText(C0000R.string.translator_incoming_messages_only));
                builder4.setMyImage(MainApplication.mConfig.getProfileUserID());
                builder4.setOtherPartyImage(this.mCalluserInfo.userID);
                builder4.setMyName(MainApplication.mConfig.getProfileUserName());
                builder4.setOtherPartyName(this.mCalluserInfo.userName);
                builder4.setTopCountryLanguageCode(10);
                this.topLangCode = builder4.getTopCountryLanguageCode();
                builder4.setMiddleCountryLanguageCode(20, transferLanguage);
                this.middleLangCode = builder4.getMiddleCountryLanguageCode();
                builder4.setPositiveButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.23
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        if (MainApplication.mPhoneManager.isTranslateTest()) {
                            VideoCallActivity.this.logI("first selected language: " + VideoCallActivity.this.topLangCode + ", second selected language: " + VideoCallActivity.this.middleLangCode);
                            VideoCallActivity.this.logI("first selected language: " + VideoCallActivity.this.mHostLangCode + ", second selected language: " + VideoCallActivity.this.mTheOherPartyLangCode);
                            VideoCallActivity.this.sendRequestConsent(5, TranslationUtil.toConsentParamLanguage(VideoCallActivity.this.mHostLangCode, VideoCallActivity.this.mTheOherPartyLangCode));
                            return;
                        }
                        VideoCallActivity.this.removeDialog(VideoCallActivity.TRANSLATOR_DIALOG);
                    }
                });
                builder4.setNegativeButton(C0000R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.24
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        try {
                            VideoCallActivity.this.removeDialog(VideoCallActivity.TRANSLATOR_DIALOG);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                builder4.setCancelable(true);
                builder4.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.25
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface arg0) {
                        try {
                            VideoCallActivity.this.finish();
                            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                                VideoCallActivity.this.overridePendingTransition(0, 0);
                            }
                            VideoCallActivity.this.removeDialog(VideoCallActivity.TRANSLATOR_DIALOG);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                this.mTranslatorDialog = builder4.create();
                return this.mTranslatorDialog;
            case 100:
                progress.setMessage(getResources().getText(C0000R.string.video_image_capture));
                progress.setCancelable(false);
                return progress.create();
            case 104:
                String user_name = this.mCalluserInfo.userName;
                if (user_name == null) {
                    user_name = this.mCallStatusData.getHostDisplayName();
                }
                String msg = getResources().getString(C0000R.string.video_connect_fail_msg, user_name);
                progress.setTitle(getResources().getText(C0000R.string.video_connect_fail_title));
                progress.setMessage(msg);
                progress.setNegativeButton(C0000R.string.confirm_no, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.15
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        try {
                            VideoCallActivity.this.settingEndCall();
                            VideoCallActivity.this.removeDialog(104);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                progress.setPositiveButton(C0000R.string.confirm_yes, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.16
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        VideoCallActivity.this.setRetryCallStatus();
                    }
                });
                progress.setCancelable(true);
                progress.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.17
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface arg0) {
                        try {
                            VideoCallActivity.this.settingEndCall();
                            VideoCallActivity.this.removeDialog(104);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                this.mConnectFailDialog = progress.create();
                return this.mConnectFailDialog;
            case 105:
                String name = this.mCalluserInfo.userName;
                if (name == null) {
                    name = this.mCallStatusData.getHostDisplayName();
                }
                ContextDialogMenuBuilder.Builder contextDialogBuilder = new ContextDialogMenuBuilder.Builder(this, this);
                contextDialogBuilder.setMenuArray(C0000R.array.video_capture_record_to_video_call);
                contextDialogBuilder.setTitle(name);
                this.option_menu_mode = 202;
                this.mContextDialog = contextDialogBuilder.create();
                this.mContextDialog.show();
                return this.mContextDialog;
            case 106:
                progress.setMessage(getResources().getText(C0000R.string.video_complete_record));
                progress.setCancelable(false);
                return progress.create();
            case DIALOG_SHARE_VIEW /* 107 */:
                alertProgress.setTitle(getResources().getText(C0000R.string.call_btn_share_screen));
                alertProgress.setItems(C0000R.array.video_call_share_screen_select_menu_item, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.14
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                VideoCallActivity.this.option_menu_mode = -1;
                                break;
                            case 1:
                                VideoCallActivity.this.mShareViewCtrl.setType(2);
                                VideoCallActivity.this.sendRequestConsent(2, 0);
                                break;
                        }
                        VideoCallActivity.this.mShareViewSelectDialog = null;
                    }
                });
                this.mShareViewSelectDialog = alertProgress.create();
                this.mShareViewSelectDialog.show();
                return this.mShareViewSelectDialog;
            case DIALOG_PREVIEW_SINGLE_TAB /* 108 */:
                alertProgress.setTitle(getResources().getText(C0000R.string.video_call_preview_single_tab_dialog_title));
                alertProgress.setItems(C0000R.array.video_call_preview_single_tab_dialog_item, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.12
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) throws Throwable {
                        switch (which) {
                            case 0:
                                VideoCallActivity.this.changeLayoutPreviewSingleTab();
                                break;
                            case 1:
                                VideoCallActivity.this.changeLayoutRemoteSingleTab();
                                break;
                        }
                        dialog.dismiss();
                        VideoCallActivity.this.mPreviewSingleTabDialog = null;
                    }
                });
                alertProgress.setCancelable(true);
                alertProgress.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.13
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialog) {
                        dialog.dismiss();
                        VideoCallActivity.this.mPreviewSingleTabDialog = null;
                    }
                });
                this.mPreviewSingleTabDialog = alertProgress.create();
                this.mPreviewSingleTabDialog.show();
                return this.mPreviewSingleTabDialog;
            case 109:
                progress_onebutton.setTitle(getResources().getText(C0000R.string.scamera_camera_zoom_error_title));
                progress_onebutton.setMessage(getResources().getText(C0000R.string.scamera_camera_zoom_error_msg));
                progress_onebutton.setPositiveButton(C0000R.string.confirm_yes, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.22
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface arg0, int arg1) {
                        VideoCallActivity.this.settingEndCall();
                    }
                });
                return alertProgress.create();
            case DIALOG_SHARE_SCREEN_CHANGE_VOICE /* 111 */:
                LayoutInflater factory = LayoutInflater.from(this);
                View popupBody = factory.inflate(C0000R.layout.share_screen_vt_attention, (ViewGroup) null);
                final CheckBox checkbox = (CheckBox) popupBody.findViewById(C0000R.id.share_screen_vt_ck);
                progress.setTitle(getResources().getText(C0000R.string.screenshare_alertView_attention_title));
                progress.setView(popupBody);
                progress.setPositiveButton(C0000R.string.ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.29
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        if (checkbox.isChecked()) {
                            ((ChatOnConfigInterface) MainApplication.mConfig).setCheckShareScreenChangeVoice(true);
                        }
                        VideoCallActivity.this.logI("displayShareScreenAttention true!!: " + ((ChatOnConfigInterface) MainApplication.mConfig).isCheckShareScreenChangeVoice());
                        VideoCallActivity.this.startShareScreen();
                        VideoCallActivity.this.dismissDialog(VideoCallActivity.DIALOG_SHARE_SCREEN_CHANGE_VOICE);
                    }
                });
                progress.setNegativeButton(C0000R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.30
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        VideoCallActivity.this.dismissDialog(VideoCallActivity.DIALOG_SHARE_SCREEN_CHANGE_VOICE);
                    }
                });
                progress.setCancelable(true);
                progress.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.31
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialog) {
                        VideoCallActivity.this.dismissDialog(VideoCallActivity.DIALOG_SHARE_SCREEN_CHANGE_VOICE);
                    }
                });
                this.mShareScreenAttentionDialog = progress.create();
                return this.mShareScreenAttentionDialog;
            case 999:
                Set<Integer> changeVoiceLanguage = getRecognitionSupportedVoiceLanguage();
                final ChatONTranslatorChangeLanguageDialog.Builder builder5 = new ChatONTranslatorChangeLanguageDialog.Builder(this, changeVoiceLanguage);
                builder5.setTitle(getResources().getText(C0000R.string.translator_change_lang_title));
                builder5.setMessageTop(((Object) getResources().getText(C0000R.string.translator_message_top)) + " : ");
                String middleMessage = getResources().getString(C0000R.string.translator_chagne_lang_message_middle, changeToStringLangCode(this.mGuestLanguageCode));
                builder5.setMessageMiddle(middleMessage);
                builder5.setCountryLanguageCode(this.mHostLanguageCode);
                builder5.setPositiveButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.26
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        VideoCallActivity.this.setRecognitionVoiceLanguage(builder5.getCountryLanguageCode());
                        VideoCallActivity.this.removeDialog(999);
                    }
                });
                builder5.setNegativeButton(C0000R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.27
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        try {
                            VideoCallActivity.this.removeDialog(999);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                builder5.setCancelable(true);
                builder5.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.28
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface arg0) {
                        try {
                            VideoCallActivity.this.finish();
                            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                                VideoCallActivity.this.overridePendingTransition(0, 0);
                            }
                            VideoCallActivity.this.removeDialog(999);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                this.mTranslatorChangeLanguageDialog = builder5.create();
                return this.mTranslatorChangeLanguageDialog;
            case 1000:
                progress_onebutton.setTitle(getResources().getText(C0000R.string.information_str_title_1));
                if (MainApplication.mConfig.isUseWifiOnly()) {
                    progress_onebutton.setMessage(getResources().getText(C0000R.string.unable_make_call_wifi_only_on));
                } else {
                    progress_onebutton.setMessage(getResources().getText(C0000R.string.information_str_msg_1));
                }
                progress_onebutton.setPositiveButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.18
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        try {
                            VideoCallActivity.this.removeDialog(1000);
                            VideoCallActivity.this.finish();
                            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                                VideoCallActivity.this.overridePendingTransition(0, 0);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                progress_onebutton.setCancelable(true);
                progress_onebutton.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.19
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface arg0) {
                        try {
                            VideoCallActivity.this.removeDialog(1000);
                            VideoCallActivity.this.finish();
                            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                                VideoCallActivity.this.overridePendingTransition(0, 0);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                return progress_onebutton.create();
            case 1001:
                progress_onebutton.setTitle(getResources().getText(C0000R.string.information_str_title_2));
                progress_onebutton.setMessage(getResources().getText(C0000R.string.information_str_msg_2));
                progress_onebutton.setPositiveButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.20
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        try {
                            VideoCallActivity.this.startActivity(new Intent("android.settings.AIRPLANE_MODE_SETTINGS"));
                            VideoCallActivity.this.finish();
                            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                                VideoCallActivity.this.overridePendingTransition(0, 0);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                progress_onebutton.setCancelable(true);
                progress_onebutton.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.21
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface arg0) {
                        try {
                            VideoCallActivity.this.removeDialog(1000);
                            VideoCallActivity.this.finish();
                            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                                VideoCallActivity.this.overridePendingTransition(0, 0);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                return progress_onebutton.create();
            default:
                return super.onCreateDialog(menuID);
        }
    }

    public String changeToStringLangCode(int langCode) {
        switch (langCode) {
            case 0:
                break;
            case 10:
                break;
            case 20:
                break;
            case 21:
                break;
            case 30:
                break;
            case 31:
                break;
            case 40:
                break;
            case 50:
                break;
        }
        return "English";
    }

    public void setRecordRequested(boolean flag) {
        this.mIsRecordRequested = flag;
    }

    public boolean isRecordRequested() {
        return this.mIsRecordRequested;
    }

    @Override // com.coolots.chaton.common.dialog.ContextDialogMenuInterface
    public void sendMsgFromDialog(int which) throws Resources.NotFoundException {
        if (this.option_menu_mode == 202) {
            getResources().getStringArray(C0000R.array.video_capture_record_to_video_call);
            switch (which) {
                case 0:
                    try {
                        setCaptureImage();
                        removeDialog(105);
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                case 1:
                    try {
                        if (!this.mIsRecording) {
                            Log.m2963i("CALLCONSENT Activity에서 요청을 보냄.");
                            setRecordRequested(true);
                            sendRequestConsent(4, 2);
                        }
                        removeDialog(105);
                        this.mContextDialog.dismiss();
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
            }
        }
    }

    @Override // com.coolots.chaton.common.dialog.ContextDialogMenuInterface
    public void sendMsgFromDialog(int which, int index) {
    }

    @Override // com.coolots.chaton.common.dialog.ContextDialogMenuInterface
    public void contextDialogDismiss() {
        if (this.mContextDialog != null) {
            this.mContextDialog.dismiss();
        }
    }

    protected void setCaptureImage() {
        Log.m2963i("setCaptureImage()");
        if (captureImage()) {
            setHideMeForCaptureRecord(true);
        }
    }

    private void resetIconRecordStart() {
        Handler iconRecordHandler = new Handler();
        this.mShowRecordIcon = true;
        iconRecordHandler.postDelayed(new Runnable() { // from class: com.coolots.chaton.call.view.VideoCallActivity.32
            @Override // java.lang.Runnable
            public void run() {
                VideoCallActivity.this.mOtherPartyCapture.setVisibility(8);
                VideoCallActivity.this.mCaptureImage.setVisibility(8);
            }
        }, 3000L);
    }

    private void setHideMeForCaptureRecord(boolean isCapture) {
        if (this.mChanagePreview) {
            FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mOtherPartyCapture.getLayoutParams();
            DisplayMetrics outMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
            float density = outMetrics.density;
            if (isCapture) {
                this.mOtherPartyCapture.setImageResource(C0000R.drawable.vt_icon_capture_02);
            } else {
                this.mOtherPartyCapture.setImageResource(C0000R.drawable.vt_icon_capture_02);
            }
            if (isCapture) {
                this.mOtherPartyCapture.setVisibility(0);
                this.mHandler.sendEmptyMessageDelayed(DISPLAY_CAPTURE_IMAGE, 1000L);
            } else {
                if (!this.mShowRecordIcon) {
                    this.mOtherPartyCapture.setVisibility(0);
                }
                resetIconRecordStart();
            }
            if (this.mShareViewCtrl.isActive() && this.mShareViewCtrl.isFullScreen()) {
                param.bottomMargin = 0;
            } else {
                param.bottomMargin = (int) (87.0f * density);
            }
            this.mOtherPartyCapture.setLayoutParams(param);
        } else {
            FrameLayout.LayoutParams param2 = (FrameLayout.LayoutParams) this.mCaptureImage.getLayoutParams();
            int height = this.mPreviewHeight;
            int width = this.mPreviewWidth;
            if (getResources().getConfiguration().orientation == 1) {
                param2.height = height;
                param2.width = width;
                if (isCapture) {
                    this.mCaptureImage.setImageResource(C0000R.drawable.vt_icon_capture_01);
                } else {
                    this.mCaptureImage.setImageResource(C0000R.drawable.vt_icon_capture_01);
                }
                param2.setMargins(this.mImgPoint.x, this.mImgPoint.y, this.mPreviewPaddingRight, this.mPrviewPaddingButton);
            } else {
                param2.height = width;
                param2.width = height;
                if (isCapture) {
                    this.mCaptureImage.setImageResource(C0000R.drawable.vt_icon_capture_01_h);
                } else {
                    this.mCaptureImage.setImageResource(C0000R.drawable.vt_icon_capture_01_h);
                }
                param2.setMargins(this.mImgPoint.x, this.mImgPoint.y, this.mLandPreviewPaddingRight, this.mLandPrviewPaddingButton);
            }
            param2.gravity = 51;
            this.mCaptureImage.setLayoutParams(param2);
            if (isCapture) {
                if (this.mOnlyBuddyLayout.getVisibility() == 0) {
                    this.mCaptureImage.setVisibility(8);
                } else {
                    this.mCaptureImage.setVisibility(0);
                    this.mHandler.sendEmptyMessageDelayed(DISPLAY_CAPTURE_IMAGE_PREVIEW, 1000L);
                }
            } else {
                if (!this.mShowRecordIcon) {
                    if (this.mOnlyBuddyLayout.getVisibility() == 0) {
                        this.mCaptureImage.setVisibility(8);
                    } else {
                        this.mCaptureImage.setVisibility(0);
                    }
                }
                resetIconRecordStart();
            }
        }
        if (isCapture) {
            this.mImageCaptureAnimationImageView.setImageDrawable(this.mCaptureImageAnimation);
            this.mHandler.sendEmptyMessageDelayed(STOP_CAPTURE_IMAGE_ANIMATION, 500L);
            this.animationtype = 1;
            this.mCaptureImageAnimation.start();
            this.mImageCaptureAnimationImageView.setVisibility(0);
        }
    }

    protected void setCaptureMyImage() {
        Log.m2963i("setCaptureImage()");
        File saveDir = new File(FileUtil.VIDEO_SAVE_PATH);
        saveDir.mkdirs();
        File file = new File(String.valueOf(FileUtil.VIDEO_SAVE_PATH) + "/outgoing_take_picture.jpg");
        if (file.exists()) {
            file.delete();
        }
        if (captureMyImage()) {
            logI("captureMyImage()--------true");
        } else {
            showToast("unable to capture my image");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNotiCapturedView() {
        logI("setNotiCapturedView");
        setOtherBuddyHideImageForCaptureRecord(true);
    }

    private void setOtherBuddyHideImageForCaptureRecord(boolean isCapture) {
        if (this.mChanagePreview) {
            this.mIsOtherCapture = true;
            FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mSurfaceViewlayout.getLayoutParams();
            this.mCaptureImage.setLayoutParams(param);
            if (getResources().getConfiguration().orientation == 1) {
                if (this.mChangePreviewRotation) {
                    if (isCapture) {
                        this.mCaptureImage.setImageResource(C0000R.drawable.vt_icon_capture_01_h);
                    } else {
                        this.mCaptureImage.setImageResource(C0000R.drawable.vt_icon_record_start_01_h);
                    }
                } else if (isCapture) {
                    this.mCaptureImage.setImageResource(C0000R.drawable.vt_icon_capture_01);
                } else {
                    this.mCaptureImage.setImageResource(C0000R.drawable.vt_icon_record_start_01);
                }
            } else if (this.mChangePreviewRotation) {
                if (isCapture) {
                    this.mCaptureImage.setImageResource(C0000R.drawable.vt_icon_capture_01);
                } else {
                    this.mCaptureImage.setImageResource(C0000R.drawable.vt_icon_record_start_01);
                }
            } else if (isCapture) {
                this.mCaptureImage.setImageResource(C0000R.drawable.vt_icon_capture_01_h);
            } else {
                this.mCaptureImage.setImageResource(C0000R.drawable.vt_icon_record_start_01_h);
            }
            if (isCapture) {
                this.mCaptureImage.setVisibility(0);
                this.mHandler.sendEmptyMessageDelayed(DISPLAY_CAPTURE_IMAGE_PREVIEW, Config.DISCONNECT_TIMEOUT);
                return;
            } else {
                if (!this.mShowRecordIcon) {
                    this.mCaptureImage.setVisibility(0);
                }
                resetIconRecordStart();
                return;
            }
        }
        if (getResources().getConfiguration().orientation == 1) {
            if (isCapture) {
                this.mOtherPartyCapture.setImageResource(C0000R.drawable.vt_icon_capture_02);
            } else {
                this.mOtherPartyCapture.setImageResource(C0000R.drawable.vt_icon_record_start_02);
            }
        } else if (isCapture) {
            this.mOtherPartyCapture.setImageResource(C0000R.drawable.vt_icon_capture_02_h);
        } else {
            this.mOtherPartyCapture.setImageResource(C0000R.drawable.vt_icon_record_start_02_h);
        }
        if (isCapture) {
            this.mOtherPartyCapture.setVisibility(0);
            this.mHandler.sendEmptyMessageDelayed(DISPLAY_CAPTURE_IMAGE, Config.DISCONNECT_TIMEOUT);
        } else {
            if (!this.mShowRecordIcon) {
                this.mOtherPartyCapture.setVisibility(0);
            }
            resetIconRecordStart();
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showConnectDialog(int msg) {
        logI("showConnectDialog");
        if (msg == 1000) {
            showDialog(1000);
        } else if (msg == 1001) {
            showDialog(1001);
        }
    }

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

    public void setRepositionVisiblity() {
        logI("setRepositionVisiblity");
        if (this.mVideoRepositionView != null) {
            this.mIsReposotionView = false;
            this.mVideoRepositionView.setVisibility(8);
        }
    }

    public boolean isRepositionVisiblity() {
        logI("isRepositionVisiblity");
        return this.mIsReposotionView;
    }

    private void startVideoRecord() {
        logI("startVideoRecord()");
        MainApplication.mPhoneManager.isTranslateTest();
        if (setRecord()) {
            setLayoutRecord();
        }
        this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void stopRecord() {
        logI("stopRecord()");
        stopRecordUI();
        if (this.mChanagePreview) {
            this.mOtherPartyCapture.setVisibility(8);
        } else {
            this.mCaptureImage.setVisibility(8);
        }
        this.mShowRecordIcon = false;
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

    @Override // com.sds.coolots.call.view.CallActivity
    public void startRecordTime() {
        logI("startRecordTime()");
        this.mRecordTime.setBase(SystemClock.elapsedRealtime());
        this.mRecordTime.start();
        this.mRecordTimer = true;
    }

    @Override // com.sds.coolots.call.view.CallActivity
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

    @Override // com.sds.coolots.call.view.CallActivity
    protected void removeRecordUI() {
        logI("removeRecordUI()");
        this.mRecordTime.stop();
        this.mRecordTimer = false;
        this.mRecordLayout.setVisibility(8);
    }

    public void setOtherRecording(boolean isStart) {
        logI("setOtherRecording() : " + isStart);
        if (isStart) {
            showToast(getResources().getString(C0000R.string.video_other_recording));
            MainApplication.mPhoneManager.isTranslateTest();
            setOtherBuddyHideImageForCaptureRecord(false);
        } else {
            if (this.mIsRecording) {
                showToast(C0000R.string.other_video_ended_record);
                return;
            }
            stopRecordUI();
            this.mShowRecordIcon = false;
            if (this.mChanagePreview) {
                this.mCaptureImage.setVisibility(8);
            } else {
                this.mOtherPartyCapture.setVisibility(8);
            }
            showToast(C0000R.string.video_ended_record);
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void hangupLowBattery() {
        logI("hangupLowBattery()");
        showToast(C0000R.string.video_low_battery);
        hangupCall();
    }

    public void hangupCameraZoomError() {
        logE("hangupCameraZoomError() camera 경통 error");
        this.mIsSCameraZoomError = true;
        showDialog(109);
        hangupCall();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRetryCallStatus() {
        String userNumber;
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
        if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            userNumber = ChatONStringConvert.getInstance().removeAfterAt(this.mDestination.getPhoneNo());
        } else {
            PhoneNumberUtil phoneUtil = new PhoneNumberUtil(ChatONStringConvert.getInstance().removeAfterAt(this.mDestination.getPhoneNo()));
            userNumber = phoneUtil.getPhoneNumber();
        }
        Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + userNumber));
        startActivity(intent);
        finish();
        if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
            overridePendingTransition(0, 0);
        }
    }

    protected void dismissVideoDialog() {
        logI("dismissVideoDialog()");
        if (this.mContextDialog != null && this.mContextDialog.isShowing()) {
            this.mContextDialog.dismiss();
        }
        if (this.mRemoteDialog != null && this.mRemoteDialog.isShowing()) {
            this.mRemoteDialog.dismiss();
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
        if (this.mTranslatorDialog != null && this.mTranslatorDialog.isShowing()) {
            this.mTranslatorDialog.dismiss();
        }
        if (this.mShareScreenAttentionDialog != null && this.mShareScreenAttentionDialog.isShowing()) {
            this.mShareScreenAttentionDialog.dismiss();
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
            MainApplication.mPhoneManager.isTranslateTest();
            this.mIsRecording = false;
            this.mIsRecordRequested = false;
            try {
                sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void hideNativeCallLayout() {
        logI("hideNativeCallLayout()");
        this.mIsNativeCall = false;
        this.mNativeStauts = 0;
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
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
            MainApplication.mPhoneManager.isTranslateTest();
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
            if (MainApplication.mPhoneManager.isConfTest()) {
                for (int i = 0; i < this.mMaxRemoteCnt; i++) {
                    if (this.mRemoteSurfaceArray[i] != null) {
                        this.mRemoteSurfaceArray[i].setZOrderMediaOverlay(false);
                    }
                }
            } else {
                this.mRemoteSurface.setZOrderMediaOverlay(false);
            }
            MainApplication.mPhoneManager.getHardwareManager().setModeConnectedFor3GIdleMode(true);
            if (doUnHold == 1) {
                if (doMute == 1) {
                    MainApplication.mPhoneManager.getPhoneStateMachine().setUnHoldFor3GIdle(this.mDestination, 1);
                    this.mCallBtnLayout.setUIState(this.mCallState, false, false);
                    MainApplication.mPhoneManager.isTranslateTest();
                } else {
                    MainApplication.mPhoneManager.getPhoneStateMachine().setUnHoldFor3GIdle(this.mDestination, 0);
                    this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
                    MainApplication.mPhoneManager.isTranslateTest();
                }
            } else if (doMute == 1) {
                MainApplication.mPhoneManager.getPhoneStateMachine().muteCall(this.mDestination);
                this.mCallBtnLayout.setUIState(this.mCallState, false, false);
                MainApplication.mPhoneManager.isTranslateTest();
            } else {
                this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
                MainApplication.mPhoneManager.isTranslateTest();
            }
            if (useDualCamera()) {
                stopDualCamera();
                startDualCamera();
            }
        }
        if (this.mVideoCallOptionMng != null) {
            this.mVideoCallOptionMng.refreshOptionMenu();
            if (this.mIsNativeCall) {
                reStartOptionMenu();
            }
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showCallHoldOnStateToast() {
        showToast(C0000R.string.call_on_hold);
        this.mIsCallHoldOn = true;
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showCallHoldRetrievedStateToast() {
        showToast(C0000R.string.call_retrieved);
        this.mIsCallHoldOn = false;
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void setHideMe() throws Throwable {
        logI("setHideMe()");
        this.mUseAlterImage = true;
        this.mVideoCallOptionMng.startHideMe();
        setDefaultHideMeImage();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void setShowMe() {
        logI("setShowMe()");
        this.mUseAlterImage = false;
        stopHideMeVideoCall();
        reStartOptionMenu();
        this.mVideoCallOptionMng.stopHideMe();
        this.mCallBtnLayout.setHideme(false);
        this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
        MainApplication.mPhoneManager.isTranslateTest();
        setCallButtonShareViewStart();
    }

    private void reStartOptionMenu() {
        if (this.mIsCartoonView) {
            setCartoonView(0);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) throws Throwable {
        logI("onActivityResult()");
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == 1) {
            if (MainApplication.mPhoneManager.isTranslateTest() && this.mIsTranslatorOptionMenuEnable) {
                stopTranslator();
            }
            getCallFunctionController().setInviteProcessing(false);
            if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                String[] results = (String[]) data.getExtras().get(ChatONInterface.EXTRAS_KEY_RESULT);
                ArrayList<String> buddyNoList = new ArrayList<>();
                for (int i = 0; i < results.length; i++) {
                    logI("onActivityResult add No = [" + results[i] + "]");
                    buddyNoList.add(results[i]);
                }
                ChatOnService chatonservice = ChatOnService.createService(MainApplication.mContext);
                ArrayList<BuddyListChildItem> buddyselectList = chatonservice.getBuddyItemAsBuddyNoList(buddyNoList);
                if (this.mInviteViewCtrl != null) {
                    this.mInviteViewCtrl.preprocessInviteView(buddyselectList, this.mDestinationUtil, this.mDestination, this.mUserAddedInfo, this.mCalluserInfo);
                }
            } else if (this.mInviteViewCtrl != null) {
                this.mInviteViewCtrl.preprocessInviteView(data, this.mDestinationUtil, this.mDestination, this.mUserAddedInfo, this.mCalluserInfo);
            }
            if (getResources().getConfiguration().orientation == 2) {
                viewTopStatusBar();
            }
        }
    }

    private Bitmap makeLocalHideImage() {
        int drawableId;
        logI("makeLocalHideImage()");
        Bitmap hideImg = null;
        try {
            if (this.mSavedOrientation == 90 || this.mSavedOrientation == 270) {
                if (CallState.isNotConnected(this.mCallState)) {
                    drawableId = C0000R.drawable.vt_img_unknown_h;
                } else {
                    drawableId = C0000R.drawable.vt_hideme_bg_still_02_h;
                }
            } else if (CallState.isNotConnected(this.mCallState)) {
                drawableId = C0000R.drawable.vt_hideme_bg_still_01;
            } else {
                drawableId = C0000R.drawable.vt_hideme_bg_still_02;
            }
            BitmapFactory.Options sizeOpt = new BitmapFactory.Options();
            sizeOpt.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), drawableId, sizeOpt);
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
            hideImg = BitmapFactory.decodeResource(getResources(), drawableId, options);
            return hideImg;
        } catch (Exception ex) {
            ex.printStackTrace();
            return hideImg;
        }
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void makeHideMeImage() {
        logI("makeDefaultHideMeImage()");
        Bitmap hideImage = makeLocalHideImage();
        if (hideImage != null) {
            try {
                int widthImg = hideImage.getWidth();
                int heightImg = hideImage.getHeight();
                ByteBuffer buffer = ByteBuffer.allocateDirect(widthImg * heightImg * 4);
                hideImage.copyPixelsToBuffer(buffer);
                this.mUseAlterImage = true;
                sendHideMeImage(buffer, widthImg, heightImg);
            } catch (Exception ex) {
                logE("makeHideMeImage Exception : " + ex);
            }
        }
    }

    private void sendHideMeImage(ByteBuffer buffer, int width, int height) {
        this.mVideoCallOptionMng.startHideMe();
        boolean autoRotation = isAutorotationActive();
        int deviceAngle = this.mSavedOrientation;
        int systembarAngle = getSystemBarOrientation();
        if (autoRotation && deviceAngle != 180) {
            systembarAngle = deviceAngle;
        }
        int degree = (systembarAngle << 16) | deviceAngle;
        logI("sendHideMeImage()");
        logI("deviceAngle: " + deviceAngle);
        logI("systemBarAngle: " + systembarAngle);
        logI("degree: " + Integer.toHexString(degree));
        logI("is auto-rotation: " + isAutorotationActive());
        startHideMeVideoCall(buffer, width, height, degree, this.mHideMeModeType, true, autoRotation);
        this.mCallBtnLayout.setHideme(true);
        this.mCallBtnLayout.setUIState(this.mCallState, this.mShareViewCtrl.isActive(), this.mShareViewCtrl.isStarter());
        MainApplication.mPhoneManager.isTranslateTest();
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
        MainApplication.mPhoneManager.isTranslateTest();
    }

    private void askChangeConferenceLayout(int layoutID) {
        logI("askChangeConferenceLayout()");
        MainApplication.mPhoneManager.getPhoneStateMachine().changeConferenceLayout(this.mDestination, layoutID);
    }

    public void handleChangeConferenceLayout(int layoutID) {
        logI("handleChangeConferenceLayout()");
    }

    public boolean onDoubleTap(MotionEvent event) {
        logI("onDoubleTab");
        return false;
    }

    public boolean onDoubleTapEvent(MotionEvent arg0) {
        return false;
    }

    public boolean onSingleTapConfirmed(MotionEvent event) throws Throwable {
        logI("onSingleTapConfirmed");
        previewTouchEvent(event);
        return false;
    }

    private boolean previewTouchEvent(MotionEvent event) throws Throwable {
        if (!CallState.isConnected(this.mCallState)) {
            return false;
        }
        if (!isShowPreviewTouchMenu()) {
            return true;
        }
        int posx = (int) event.getX();
        int posy = (int) event.getY();
        boolean isPreviewArea = isImageArea(posx, posy);
        if (!isPreviewArea) {
            return true;
        }
        changeLayoutRemoteSingleTab();
        return true;
    }

    private boolean isShowPreviewTouchMenu() {
        return !this.mShareViewCtrl.isActive();
    }

    private boolean isMovePreviewTouchMenu() {
        if (this.mShareViewCtrl.isActive()) {
            return false;
        }
        return !(this.mDestination.getDestinationType() == 4 || this.mDestination.getDestinationType() == 5) || this.mDestinationUtil.getConferenceConnectCount(this.mDestination) == 1;
    }

    protected class TitleBarHandler extends Handler {
        protected TitleBarHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            VideoCallActivity.this.logI("msg.what = " + msg.what);
            switch (msg.what) {
                case 0:
                    VideoCallActivity.this.mVideoCallStatusBar.showStatusBar();
                    if (VideoCallActivity.this.getResources().getConfiguration().orientation == 2 && !VideoCallActivity.this.mVideoCallStatusBar.isUsingAnimation() && VideoCallActivity.this.mVideoCallStatusBar.isShowing()) {
                        VideoCallActivity.this.mVideoCallStatusBar.startStatusBarAnimation(false);
                        if (VideoCallActivity.this.mShareViewCtrl.isActive() && VideoCallActivity.this.mShareViewCtrl.isStarter() && !VideoCallActivity.this.mVideoCallOptionMng.isShowingAnyMenu()) {
                            VideoCallActivity.this.showShareviewBtnAnimation(false);
                            break;
                        }
                    }
                    break;
                case 1:
                    VideoCallActivity.this.mVideoCallStatusBar.showStatusBar();
                    if (!VideoCallActivity.this.mVideoCallStatusBar.isUsingAnimation() && !VideoCallActivity.this.mVideoCallStatusBar.isShowing()) {
                        VideoCallActivity.this.mVideoCallStatusBar.startStatusBarAnimation(true);
                        if (VideoCallActivity.this.mShareViewCtrl.isActive() && VideoCallActivity.this.mShareViewCtrl.isStarter() && !VideoCallActivity.this.mVideoCallOptionMng.isShowingAnyMenu()) {
                            VideoCallActivity.this.showShareviewBtnAnimation(true);
                            break;
                        }
                    }
                    break;
                case 2:
                    VideoCallActivity.this.mInviteviewMemberLayout.showInviteViewByAnimation(false);
                    VideoCallActivity.this.goneTopStatusBar(0);
                    break;
                case 3:
                    VideoCallActivity.this.mInviteviewMemberLayout.showInviteViewByAnimation(true);
                    break;
                case 4:
                    VideoCallActivity.this.mInviteviewMemberLayout.showInviteViewByAnimation(false);
                    VideoCallActivity.this.goneInviteAndTopStatusBar();
                    break;
            }
            if (VideoCallActivity.this.mVideoCallOptionMng.isShowingAnyMenu()) {
                VideoCallActivity.this.mVideoCallOptionMng.showOptionMenu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goneInviteAndTopStatusBar() {
        if (CallState.isConnected(this.mCallState) && !this.mVideoCallOptionMng.isShowingAnyMenu() && getResources().getConfiguration().orientation == 2) {
            if (this.mInviteviewMemberLayout.isShowing()) {
                this.mTitleBarHandler.removeMessages(0);
                this.mTitleBarHandler.removeMessages(4);
            } else {
                this.mTitleBarHandler.removeMessages(0);
                this.mTitleBarHandler.removeMessages(4);
                this.mTitleBarHandler.sendEmptyMessageDelayed(0, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goneTopStatusBar(int delayTime) {
        if (CallState.isConnected(this.mCallState) && !this.mVideoCallOptionMng.isShowingAnyMenu()) {
            if ((!this.mShareViewCtrl.isActive() || !this.mShareViewCtrl.isFullScreen()) && getResources().getConfiguration().orientation == 2) {
                if (this.mInviteviewMemberLayout.isShowing()) {
                    this.mTitleBarHandler.removeMessages(0);
                    this.mTitleBarHandler.removeMessages(4);
                    this.mTitleBarHandler.sendEmptyMessageDelayed(4, delayTime);
                } else {
                    this.mTitleBarHandler.removeMessages(0);
                    this.mTitleBarHandler.removeMessages(4);
                    this.mTitleBarHandler.sendEmptyMessageDelayed(0, delayTime);
                }
            }
        }
    }

    public void viewTopStatusBar() {
        if (CallState.isConnected(this.mCallState) && !this.mVideoCallOptionMng.isShowingAnyMenu()) {
            if (!this.mShareViewCtrl.isActive() || !this.mShareViewCtrl.isFullScreen()) {
                if (getResources().getConfiguration().orientation == 1) {
                    this.mVideoCallStatusBar.showStatusBar();
                    return;
                }
                this.mTitleBarHandler.removeMessages(1);
                this.mTitleBarHandler.sendEmptyMessage(1);
                goneTopStatusBar(3000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showShareviewBtnAnimation(boolean isMoved) {
        if (isMoved) {
            this.mShareviewCloseBtnTrans = new TranslateAnimation(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, getVideoCallStatusBarHeight());
        } else {
            this.mShareviewCloseBtnTrans = new TranslateAnimation(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, getVideoCallStatusBarHeight(), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        }
        this.mShareviewCloseBtnTrans.setInterpolator(AnimationUtils.loadInterpolator(MainApplication.mContext, R.anim.decelerate_interpolator));
        this.mShareviewCloseBtnTrans.setDuration(500L);
        this.mShareViewCloseButtonUp.startAnimation(this.mShareviewCloseBtnTrans);
        this.mShareviewCloseBtnTrans.setAnimationListener(new Animation.AnimationListener() { // from class: com.coolots.chaton.call.view.VideoCallActivity.33
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation arg0) {
                if (VideoCallActivity.this.mShareViewCtrl.isActive() && VideoCallActivity.this.mShareViewCtrl.isStarter()) {
                    VideoCallActivity.this.mShareViewCloseButtonUp.setVisibility(8);
                    VideoCallActivity.this.mShareViewCloseButtonDown.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation arg0) {
                if (VideoCallActivity.this.mShareViewCtrl.isActive() && VideoCallActivity.this.mShareViewCtrl.isStarter()) {
                    if (!VideoCallActivity.this.mVideoCallStatusBar.isShowing()) {
                        VideoCallActivity.this.mShareViewCloseButtonUp.setVisibility(0);
                    } else {
                        VideoCallActivity.this.mShareViewCloseButtonDown.setVisibility(0);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeLayoutRemoteSingleTab() throws Throwable {
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
        logI("changeLayoutPreviewSingleTab() : mChanagePreview: " + this.mChanagePreview);
        setViewGuideLineStatus(0, 1);
        setViewGuideLineStatus(0, 0);
        if (this.mChanagePreview) {
            logI("changeLayoutPreviewSingleTab : setDefualtSurfaceView1");
            setDefaultSurfaceView(true);
            checkImageOnly();
        } else {
            logI("changeLayoutPreviewSingleTab : setDefualtSurfaceView2");
            setRemoteSurfaceView(true);
            checkImageOnly();
        }
        setPreViewWhiteOutLine();
    }

    private void checkImageOnly() {
        if (this.mMyImageOnly) {
            this.mMyImageOnly = false;
            this.mBuddyImageOnly = true;
        } else if (this.mBuddyImageOnly) {
            this.mBuddyImageOnly = false;
            this.mMyImageOnly = true;
        }
    }

    private void restorePreviewImage() {
        if (this.mBuddyImageOnly) {
            logI("restorePreviewImage()");
            setSurfaceZOrderOnTop();
            this.mOnlyBuddyLayout.setVisibility(8);
            setSECPreviewPosition(false);
            this.mBuddyImageOnly = false;
        }
        setPreViewWhiteOutLine();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetNormalSurfaceView() {
        SurfaceHolder remoteHolder;
        if (MainApplication.mPhoneManager.isConfTest()) {
            remoteHolder = this.mRemoteHolderArray[this.mRemoteSurfaceIDArray[0]];
        } else {
            remoteHolder = this.mRemoteHolder;
        }
        SECConfig.setVideoSurfaceData(0, null);
        SECConfig.setVideoSurfaceData(1, null);
        if (MainApplication.mPhoneManager.isConfTest()) {
            for (int i = 0; i < this.mMaxRemoteCnt; i++) {
                if (!remoteHolder.equals(this.mRemoteHolderArray[i])) {
                    SECConfig.setVideoSurfaceData(i + 1, null);
                }
            }
        }
        if (remoteHolder != null) {
            SECConfig.setVideoSurfaceData(1, remoteHolder.getSurface());
        }
        if (this.mHolder != null) {
            SECConfig.setVideoSurfaceData(0, this.mHolder.getSurface());
        }
        if (MainApplication.mPhoneManager.isConfTest()) {
            for (int i2 = 0; i2 < this.mMaxRemoteCnt; i2++) {
                if (!remoteHolder.equals(this.mRemoteHolderArray[this.mRemoteSurfaceIDArray[i2]])) {
                    SECConfig.setVideoSurfaceData(i2 + 1, this.mRemoteHolderArray[this.mRemoteSurfaceIDArray[i2]].getSurface());
                }
            }
        }
    }

    private void setDefaultSurfaceView(boolean isUsePreView) {
        logI("setDefaultSurfaceView(" + isUsePreView + ")");
        if (isUsePreView) {
            restorePreviewImage();
        }
        resetNormalSurfaceView();
        changedPreviewLayout(false);
        changedRemoteLayout(false);
        this.mChanagePreview = false;
    }

    private void setDefaultSurfaceViewForStopShareView() throws Throwable {
        restorePreviewImage();
        resetNormalSurfaceView();
        onDrawRemoteSurface(this.mRemoteRotation, 0);
        changedPreviewLayout(false);
    }

    private void setRemoteSurfaceView(boolean isUsePreView) {
        SurfaceHolder remoteHolder;
        logI("setRemoteSurfaceView(" + isUsePreView + ")");
        if (isUsePreView) {
            restorePreviewImage();
        }
        if (MainApplication.mPhoneManager.isConfTest()) {
            remoteHolder = this.mRemoteHolderArray[this.mRemoteSurfaceIDArray[0]];
        } else {
            remoteHolder = this.mRemoteHolder;
        }
        SECConfig.setVideoSurfaceData(0, null);
        SECConfig.setVideoSurfaceData(1, null);
        if (MainApplication.mPhoneManager.isConfTest()) {
            for (int i = 0; i < this.mMaxRemoteCnt; i++) {
                if (!remoteHolder.equals(this.mRemoteHolderArray[this.mRemoteSurfaceIDArray[i]])) {
                    SECConfig.setVideoSurfaceData(i + 1, null);
                }
            }
        }
        if (remoteHolder != null) {
            SECConfig.setVideoSurfaceData(0, remoteHolder.getSurface());
        }
        if (this.mHolder != null) {
            SECConfig.setVideoSurfaceData(1, this.mHolder.getSurface());
        }
        if (MainApplication.mPhoneManager.isConfTest()) {
            for (int i2 = 0; i2 < this.mMaxRemoteCnt; i2++) {
                if (!remoteHolder.equals(this.mRemoteHolderArray[this.mRemoteSurfaceIDArray[i2]])) {
                    SECConfig.setVideoSurfaceData(i2 + 1, this.mRemoteHolderArray[this.mRemoteSurfaceIDArray[i2]].getSurface());
                }
            }
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
        param.setMargins(this.mModelInfo.getPreviewWidth() * (-1), this.mModelInfo.getPreviewHeight() * (-1), this.mPreviewPaddingRight, this.mPrviewPaddingButton);
        this.mSurfaceViewlayout.setLayoutParams(param);
    }

    private void showPreviewLayout() {
        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mSurfaceViewlayout.getLayoutParams();
        param.gravity = 51;
        param.width = this.mSavedPreviewWidth;
        param.height = this.mSavedPreviewHeight;
        param.setMargins(this.mSavedPreviewMarginTop, this.mSavedPreviewMarginLeft, this.mSavedPreviewMarginRight, this.mSavedPreviewMarginBottom);
        this.mSurfaceViewlayout.setLayoutParams(param);
        this.mSurfaceViewlayout.setVisibility(0);
    }

    private void changeRemoteViewOnly() {
        logI("changeRemoteViewOnly()");
        if (this.mChanagePreview) {
            setDefaultSurfaceView(false);
        }
        gonePreviewLayout();
    }

    private void changeRemoteViewForStopShareView() {
        logI("changeRemoteViewOnly()");
        setDefaultSurfaceView(false);
        gonePreviewLayout();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void setDisplayDialog(int dialogID) {
        logI("setDisplayDialog(" + dialogID + ")");
        displayDialog(dialogID);
    }

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

    @Override // com.sds.coolots.call.view.CallActivity
    public void showCallEndAnimation() {
        logI("showCallEndAnimation()");
        if (getForegounrdActivity(MainApplication.mContext).equals(getClass().getName())) {
            logI("ANIMATION start CallEndAnimation");
            this.animationtype = 0;
            AnimationSet anisetDownside = new AnimationSet(true);
            AnimationSet anisetUpside = new AnimationSet(true);
            TranslateAnimation transDownside = new TranslateAnimation(1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, 1.0f);
            TranslateAnimation transUpside = new TranslateAnimation(1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, -1.0f);
            anisetDownside.addAnimation(transDownside);
            anisetUpside.addAnimation(transUpside);
            AlphaAnimation alpha = new AlphaAnimation(1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
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
            if (this.mCallerImageLayout != null) {
                this.mCallerImageLayout.startAnimation(anisetUpside);
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

    @Override // com.sds.coolots.call.view.CallActivity
    public void showCallIncomingAnimation() {
        logI("showCallIncomingAnimation()");
        TranslateAnimation mIncomingLayoutTrans = new TranslateAnimation(1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, -1.0f, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        mIncomingLayoutTrans.setInterpolator(AnimationUtils.loadInterpolator(MainApplication.mContext, R.anim.decelerate_interpolator));
        mIncomingLayoutTrans.setDuration(400L);
        this.mCallOutgoingCallLayout.startAnimation(mIncomingLayoutTrans);
    }

    public void onAnimationEnd(Animation arg0) {
        logI("onAnimationEnd()");
        if (this.animationtype == 0) {
            super.finish();
        }
    }

    public void onAnimationRepeat(Animation arg0) {
    }

    public void onAnimationStart(Animation arg0) {
    }

    private void setLandScapeIncomingPreview() {
        logI("setLandScapeIncomingPreview()");
        if (isDrivingModeUIOn()) {
            this.mCallOutgoingCallLayout.initLayoutParams();
            return;
        }
        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mSurfaceViewlayout.getLayoutParams();
        param.width = -1;
        param.height = -1;
        param.gravity = 119;
        param.bottomMargin = this.mLandRemoteViewMarginButtom;
        param.topMargin = 0;
        if (this.mModelInfo != null) {
            param.leftMargin = this.mModelInfo.getLandPreviewWidth();
            param.rightMargin = this.mModelInfo.getLandPreviewWidth();
        } else {
            param.leftMargin = 194;
            param.rightMargin = 194;
        }
        this.mSurfaceViewlayout.setLayoutParams(param);
        this.mSurfaceViewlayout.setVisibility(0);
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
        this.mSurfaceViewlayout.setVisibility(0);
        setPreViewWhiteOutLine();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void stopRecordingForCallSwitching() {
        logI("stopRecordingForCallSwitching()");
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isRecording()) {
            stopRecordCall();
            showToast(C0000R.string.video_complete_record);
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handlePopupCloseForCallSwitch() {
        logI("handlePopupCloseForCallSwitch()");
        if (this.callSwtichingDialog != null) {
            this.callSwtichingDialog.cancel();
            this.callSwtichingDialog = null;
        }
        dismissCallConsentProcessingDialog();
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void startRecordCallAfterConsent() {
        logI("startRecordCallAfterConsent()");
        startVideoRecord();
        setRecordRequested(true);
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setRecordStatement() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void onBTButton() {
        this.mIsBlueTooth = 1;
        notifyBTHeadset();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void offBTButton() {
        this.mIsBlueTooth = 0;
        cancelBTHeadset();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void disableBTButton() {
        this.mIsBlueTooth = 2;
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void enableSpeakerButton() {
        this.mIsSpeaker = true;
        notifySpeakerphone();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void disableSpeakerButton() {
        this.mIsSpeaker = false;
        cancelSpeakerphone();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void gotoBlueToothSettingPage() {
        startActivity(ChatONBlueTooth.getBlueToothSettingPageIntent());
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setRecordStatus(boolean isRecord) {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setMenuBtnEnable(boolean enable) {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleEarphonePlugged(boolean isPlugged) {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void rejectRecordCall() {
        setRecordRequested(false);
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void clickableHoldButton() {
    }

    private void updateSurfaceViewLayout() {
        if (getResources().getConfiguration().orientation == 1) {
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) this.mSurface.getLayoutParams();
            if (CallState.isNotConnected(this.mCallState)) {
                params.topMargin = this.mModelInfo.getCallStatusBarHeight();
            } else if (CallState.isConnected(this.mCallState)) {
                params.topMargin = this.mModelInfo.getPortFullHeight();
            } else {
                params.topMargin = this.mModelInfo.getPortFullHeight();
            }
            this.mSurface.setLayoutParams(params);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePreviewLayout(boolean isStopShareView) throws Throwable {
        logI("updatePreviewLayout() mMyImageOnly: " + this.mMyImageOnly + " mBuddyImageOnly: " + this.mBuddyImageOnly + " isStopShareView: " + isStopShareView + " mChanagePreview: " + this.mChanagePreview);
        if (this.mMyImageOnly) {
            changePreviewOnly();
            if (this.mShareViewCtrl.isActive()) {
                this.mOnlyBuddyLayout.setVisibility(8);
                setPreviewHideIconLayout();
                setSurfaceZOrderOnTop();
                return;
            } else {
                this.mOnlyBuddyLayout.setVisibility(0);
                setPreviewHideIconLayout();
                setSurfaceZOrderMediaOverlay();
                return;
            }
        }
        if (this.mBuddyImageOnly) {
            if (isStopShareView) {
                changeRemoteViewForStopShareView();
            } else {
                changeRemoteViewOnly();
            }
            if (this.mShareViewCtrl.isActive()) {
                this.mOnlyBuddyLayout.setVisibility(8);
                setPreviewHideIconLayout();
                setSurfaceZOrderOnTop();
                return;
            } else {
                this.mOnlyBuddyLayout.setVisibility(0);
                setPreviewHideIconLayout();
                setSurfaceZOrderMediaOverlay();
                return;
            }
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
        setPreviewHideIconLayout();
    }

    private void setPreviewHideIconLayout() {
        FrameLayout.LayoutParams mPreviewHideIconParams = (FrameLayout.LayoutParams) this.mOnlyBuddyLayout.getLayoutParams();
        if (this.mIsTranslatorOptionMenuEnable) {
            if (getResources().getConfiguration().orientation == 1) {
                mPreviewHideIconParams.bottomMargin = 441;
            } else {
                mPreviewHideIconParams.bottomMargin = 153;
            }
        } else if (getResources().getConfiguration().orientation == 1) {
            mPreviewHideIconParams.bottomMargin = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_EDIT_COPY_EVENT;
        } else {
            mPreviewHideIconParams.bottomMargin = 27;
        }
        this.mOnlyBuddyLayout.setLayoutParams(mPreviewHideIconParams);
    }

    public void inviteViewCheck() {
        if (this.mInviteviewMemberLayout.isShowing()) {
            goneInviteView();
        } else {
            viewInviteView();
        }
    }

    public void goneInviteView() {
        if (this.mInviteViewCtrl != null && this.mInviteViewCtrl.isActive()) {
            logI("goneInviteView()");
            this.mTitleBarHandler.removeMessages(2);
            this.mTitleBarHandler.removeMessages(4);
            this.mTitleBarHandler.sendEmptyMessage(2);
        }
    }

    public void viewInviteView() {
        if (this.mInviteViewCtrl != null && this.mInviteViewCtrl.isActive()) {
            logI("viewInviteView()");
            this.mTitleBarHandler.removeMessages(0);
            this.mTitleBarHandler.removeMessages(4);
            this.mTitleBarHandler.removeMessages(3);
            this.mTitleBarHandler.sendEmptyMessage(3);
            if (getResources().getConfiguration().orientation == 2 && CallState.isConnected(this.mCallState)) {
                this.mTitleBarHandler.sendEmptyMessageDelayed(4, 3000L);
            }
        }
    }

    public void showProgressBarInviteView() throws Throwable {
        if (!isConference()) {
            handleChangeToConferenceStart();
        }
    }

    public void disableButtonDuringInviteView() {
    }

    @Override // com.coolots.chaton.call.controller.IInviteViewController
    public void updateLayoutNoInvite() {
        updateLayoutChangeDestination();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void startShareView(boolean isStarter) throws Throwable {
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

    private void startShareView() throws Throwable {
        logI("startShareView()");
        closeOptionsMenu();
        this.mMenu = null;
        if (this.mChanagePreview) {
            setViewGuideLineStatus(0, 1);
        } else {
            setViewGuideLineStatus(0, 0);
        }
        VideoShareViewRestoreData data = new VideoShareViewRestoreData();
        data.setMyImageOnly(this.mMyImageOnly);
        data.setBuddyImageOnly(this.mBuddyImageOnly);
        data.setChangePreview(this.mChanagePreview);
        data.setBackCameraToggle(getCameraToggle());
        data.setUseHideMe(this.mUseAlterImage);
        data.setThemeEmotionalAnimationVisible(this.mVideoCallEmotiAnimationLayout.getVisibility() == 0);
        data.setCartoonViewVisible(this.mIsCartoonView);
        data.setIsEmotionalAuto(this.mCallStatusData.isAlwaysEmotional());
        if (this.mCallStatusData.getThemeShotType() == 0) {
            data.setIsThemeShot(false);
            data.setThemeShotSelectedNo(-1);
            data.setThemeShotSubSelectedNo(-1);
        } else {
            data.setIsThemeShot(true);
            for (int selectedNo = 0; selectedNo < 5; selectedNo++) {
                for (int selectedSubNo = 0; selectedSubNo < 3; selectedSubNo++) {
                    if (isThemeShotActive(selectedNo, selectedSubNo)) {
                        logI("selectedNo: " + selectedNo + " selectedSubNo: " + selectedSubNo);
                        data.setThemeShotSelectedNo(selectedNo);
                        data.setThemeShotSubSelectedNo(selectedSubNo);
                    }
                }
            }
        }
        this.mShareViewCtrl.setBackupData(data);
        this.mShareViewCtrl.start(isConference(), this.mShareViewCtrl.isStarter(), this.mShareViewCtrl.getType(), this.mUseAlterImage);
        this.mVideoCallOptionMng.resetAnimationData();
        setShareViewCamera(true);
        setShareLiveVideoViewHideme(true);
        setSharePictureView(true);
        setLayoutShareViewStart();
        setCallButtonShareViewStart();
        if (MainApplication.mPhoneManager.isConfTest()) {
            for (int i = 1; i < this.mMaxRemoteCnt; i++) {
                SurfaceView sView = this.mRemoteSurfaceArray[i];
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) sView.getLayoutParams();
                params.gravity = 51;
                params.width = this.mPreviewWidth;
                params.height = this.mPreviewHeight;
                params.setMargins(-300, -332, this.mPreviewPaddingRight, this.mPrviewPaddingButton);
                sView.setLayoutParams(params);
            }
        }
    }

    private boolean setSharePictureView(boolean isServiceStart) {
        return this.mShareViewCtrl.isStarter() && this.mShareViewCtrl.getType() == 1 && !isServiceStart;
    }

    private void restoreHideMeImage() {
        if (this.mUseAlterImage) {
            makeHideMeImage();
        } else {
            setShowMe();
        }
    }

    private void setShareLiveVideoViewHideme(boolean isServiceStart) throws Throwable {
        if (this.mShareViewCtrl.isStarter() && this.mShareViewCtrl.getType() == 2) {
            if (isServiceStart) {
                if (this.mShareViewCtrl.getHidemeFlag()) {
                    setShowMe();
                }
            } else if (this.mShareViewCtrl.getHidemeFlag()) {
                setHideMe();
            }
        }
    }

    private void setLayoutShareViewStart() throws Throwable {
        logI("setLayoutShareViewStart()");
        setSurfaceZOrderOnTop();
        if (this.mShareViewCtrl.isStarter()) {
            this.mMyImageOnly = true;
            updatePreviewLayout(false);
        } else {
            this.mBuddyImageOnly = true;
            updatePreviewLayout(false);
        }
        showShareViewBtn();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void stopShareView() throws Throwable {
        logI("stopShareView()");
        if (this.mShareViewCtrl.isActive()) {
            closeOptionsMenu();
            this.mMenu = null;
            sendShareViewCameraZoomToServer(0);
            disposePinchZoomController();
            setShareViewCamera(false);
            boolean preChangePreview = false;
            VideoShareViewRestoreData data = this.mShareViewCtrl.getBackupData();
            if (data != null) {
                this.mBuddyImageOnly = data.getBuddyImageOnly();
                this.mMyImageOnly = data.getMyImageOnly();
                this.mUseAlterImage = data.getUseHideMe();
                preChangePreview = data.getChangePreview();
            }
            if (this.mShareViewCtrl.isFullScreen()) {
                this.mCallBtnLayout.setVisibility(0);
                if (!this.mVideoCallOptionMng.isShowingAnyMenu()) {
                    this.mVideoCallStatusBar.showStatusBar();
                }
                contractShareViewForZoom();
            }
            logI("after : " + this.mChanagePreview + " preChangePreview: " + preChangePreview);
            goneShareViewBtn();
            boolean isRestoreHideMeImage = setSharePictureView(false);
            setShareLiveVideoViewHideme(false);
            setCallButtonShareViewEnd();
            this.mShareViewCtrl.stop();
            this.mVideoCallStatusBar.initLayoutParams();
            this.mVideoCallEmotiAnimationLayout.setEmotionAnimationLayoutParams();
            this.mVideoCallThemeShotLayout.setThemeShotLayoutParams();
            setPreViewWhiteOutLine();
            this.mReturnPreview = false;
            setSurfaceZOrderMediaOverlay();
            updatePreviewLayout(true);
            if (data != null && preChangePreview != this.mChanagePreview) {
                changeLayoutPreviewSingleTab();
            }
            if (isRestoreHideMeImage) {
                restoreHideMeImage();
            }
            if (MainApplication.mPhoneManager.isConfTest()) {
                setMobileMCULayout(true);
            }
        }
    }

    public void endShareView() {
        logI("endShareView()");
        if (this.mShareViewCtrl.isActive()) {
            closeOptionsMenu();
            this.mMenu = null;
            goneShareViewBtn();
            this.mShareViewCtrl.stop();
            setCallButtonShareViewEnd();
        }
    }

    private void showShareViewBtn() {
        this.mShareViewLayout.setVisibility(0);
        updateShareViewZoomLayout();
        if (this.mVideoCallOptionMng.isShowingAnyMenu()) {
            this.mVideoCallOptionMng.showOptionMenu();
        }
    }

    private void goneShareViewBtn() {
        this.mShareViewLayout.setVisibility(8);
        this.mShareViewCloseButtonUp.setVisibility(8);
        this.mShareViewCloseButtonDown.setVisibility(8);
        this.mShareViewZoomInButton.setVisibility(8);
        this.mShareViewZoomOutButton.setVisibility(8);
    }

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

    public void resizePinchZoomLayout() {
        if (this.mPinchZoomController != null) {
            resizePinchZoomLayout(this.mPinchZoomController.getSize());
        }
    }

    public void setVisibilityPinchZoomLayout(boolean isVisible) {
        if (isVisible) {
            this.mInnerHandler.removeMessages(2);
            this.mShareViewPinchZoomGuideLineLayout.setVisibility(0);
        } else {
            this.mInnerHandler.sendEmptyMessageDelayed(2, 800L);
        }
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void initPinchZoomControllerSwitchCamera() {
        if (this.mShareViewCtrl.isActive()) {
            logI(" : initPinchZoomControllerSwitchCamera()");
            disposePinchZoomController();
            if (this.mShareViewCtrl.isStarter() && getCameraToggle() == 666) {
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
        logI(" : initPinchZoomController(" + forceStart + ")");
        disposePinchZoomController();
        if (this.mShareViewCtrl.isStarter() && forceStart) {
            logI("Pinch zoom controller: ON");
            this.mPinchZoomController = new PinchZoomController(this);
            this.mScaleGestureDetector = new ScaleGestureDetector(getApplicationContext(), this.mPinchZoomController);
            resizePinchZoomLayout(200);
            return;
        }
        this.mInnerHandler.sendEmptyMessage(2);
        logI("Pinch zoom controller: OFF");
    }

    public void disposePinchZoomController() {
        if (this.mPinchZoomController != null) {
            this.mPinchZoomController.dispose();
            this.mPinchZoomController = null;
        }
    }

    private void setCallButtonShareViewStart() {
        if (this.mShareViewCtrl.isActive()) {
            visibleBottomShowMeButton(false);
        }
    }

    private void setCallButtonShareViewEnd() {
        this.mCallBtnLayout.setHideme(this.mShareViewCtrl.getHidemeFlag());
        this.mCallBtnLayout.setUIState(this.mCallState, false, false);
        MainApplication.mPhoneManager.isTranslateTest();
    }

    private void setShareViewCamera(boolean isServiceStart) {
        logI("setShareViewCamera(" + isServiceStart + ")");
        if (this.mShareViewCtrl.isStarter() && this.mShareViewCtrl.getType() == 2) {
            if (isServiceStart) {
                if (getCameraToggle() == 444) {
                    if (this.mCallBtnLayout.getVisibility() == 0) {
                        this.mCallBtnLayout.onClick(this.mCallBtnLayout.findViewById(C0000R.id.camera_change_btn));
                    }
                    this.mShareViewCtrl.setFrontCamera(CAMERA_VISIBLE_REAR);
                    return;
                } else {
                    initPinchZoomController(true);
                    this.mShareViewCtrl.setFrontCamera(CAMERA_VISIBLE_FRONT);
                    return;
                }
            }
            if (this.mShareViewCtrl.getBackupData().getBackCameraToggle() != getCameraToggle() && this.mCallBtnLayout.getVisibility() == 0) {
                this.mCallBtnLayout.onClick(this.mCallBtnLayout.findViewById(C0000R.id.camera_change_btn));
            }
            initPinchZoomController(false);
        }
    }

    private void updateShareViewZoomLayoutRotation() {
        if (this.mShareViewCtrl.isActive() && this.mShareViewCtrl.isFullScreen()) {
            logI("updateZoomLayout : to full screen");
            updateShareViewZoomLayout();
        }
    }

    public boolean getShareViewFullScreen() {
        return this.mShareViewCtrl.isFullScreen();
    }

    private void updateShareViewZoomLayout() {
        if (this.mShareViewCtrl.isActive()) {
            if (this.mShareViewCtrl.isFullScreen()) {
                logI("updateZoomLayout : to full screen");
                this.mShareViewZoomInButton.setVisibility(8);
                this.mShareViewZoomOutButton.setVisibility(0);
                this.mCallBtnLayout.setVisibility(8);
                this.mVideoCallStatusBar.hideStatusBar();
                removeStatusbarAnimation();
                this.mVideoCallStatusBar.cancelAnimation();
                stretchShareViewForZoom();
            } else {
                logI("updateZoomLayout : to original screen");
                this.mShareViewZoomInButton.setVisibility(0);
                this.mShareViewZoomOutButton.setVisibility(8);
                this.mCallBtnLayout.setVisibility(0);
                if (getResources().getConfiguration().orientation == 1 && !this.mVideoCallOptionMng.isShowingAnyMenu()) {
                    this.mVideoCallStatusBar.showStatusBar();
                }
                contractShareViewForZoom();
                changedRemoteLayout(this.mIsOtherPartyLandscapeMode);
            }
            setShareViewCloseBtn();
        }
    }

    private void setShareViewCloseBtn() {
        if (this.mShareViewCtrl.isStarter()) {
            if (this.mVideoCallOptionMng.isShowingAnyMenu()) {
                this.mShareViewCloseButtonDown.setVisibility(0);
                this.mShareViewCloseButtonUp.setVisibility(8);
                return;
            }
            if (getResources().getConfiguration().orientation == 1) {
                if (this.mShareViewCtrl.isFullScreen()) {
                    this.mShareViewCloseButtonUp.setVisibility(0);
                    this.mShareViewCloseButtonDown.setVisibility(8);
                    return;
                } else {
                    this.mShareViewCloseButtonUp.setVisibility(8);
                    this.mShareViewCloseButtonDown.setVisibility(0);
                    return;
                }
            }
            if (this.mVideoCallStatusBar.isShowing()) {
                this.mShareViewCloseButtonDown.setVisibility(0);
                this.mShareViewCloseButtonUp.setVisibility(8);
                return;
            } else {
                this.mShareViewCloseButtonUp.setVisibility(0);
                this.mShareViewCloseButtonDown.setVisibility(8);
                return;
            }
        }
        this.mShareViewCloseButtonDown.setVisibility(8);
        this.mShareViewCloseButtonUp.setVisibility(8);
    }

    private void contractShareViewForZoom() {
        logI("contractShareViewForZoom()");
        getScreenSize();
        RelativeLayout layout = (RelativeLayout) findViewById(C0000R.id.share_view_btn_layout);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layout.getLayoutParams();
        if (getResources().getConfiguration().orientation == 1) {
            params.bottomMargin = this.mModelInfo.getPortPaddingBottom();
        } else {
            params.rightMargin = this.mModelInfo.getLandPaddingRight();
            this.mRemoteVideoLayoutRadvision.getLayoutParams().width = this.mDisplayWidth - getButtonLayoutSize();
            setStatusBarLength();
        }
        layout.setLayoutParams(params);
    }

    private void setStatusBarLength() {
        this.mVideoCallEmotiAnimationLayout.setEmotionAnimationLayoutParams();
        this.mVideoCallThemeShotLayout.setThemeShotLayoutParams();
    }

    private void stretchShareViewForZoom() {
        logI("stretchShareViewForZoom()");
        getScreenSize();
        RelativeLayout layout = (RelativeLayout) findViewById(C0000R.id.share_view_btn_layout);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layout.getLayoutParams();
        if (getResources().getConfiguration().orientation == 1) {
            params.bottomMargin = 0;
        } else {
            params.rightMargin = 0;
            this.mRemoteVideoLayoutRadvision.getLayoutParams().width = this.mDisplayWidth;
            setStatusBarLength();
        }
        layout.setLayoutParams(params);
        initRemoteSurface();
        FrameLayout.LayoutParams params3 = (FrameLayout.LayoutParams) this.mRemoteSurface.getLayoutParams();
        params3.width = this.mDisplayWidth;
        params3.height = this.mDisplayHeight - this.mModelInfo.getStatusBarLength();
        params3.gravity = 119;
        params3.setMargins(0, 0, 0, 0);
        this.mRemoteSurface.setLayoutParams(params3);
        this.mRemoteSurface.setPadding(0, 0, 0, 0);
    }

    public void onClickShareViewZoomInButton(View view) {
        logI("onClickShareViewZoomInButton now: " + this.mShareViewCtrl.isFullScreen() + " => true");
        this.mShareViewCtrl.setFullScreen(true);
        updateShareViewZoomLayout();
    }

    public void onClickShareViewZoomOutButton(View view) {
        logI("onClickShareViewZoomOutButton now: " + this.mShareViewCtrl.isFullScreen() + " => false");
        this.mShareViewCtrl.setFullScreen(false);
        updateShareViewZoomLayout();
    }

    public void onClickShareViewCloseButton(View view) {
        logI("onClickShareViewCloseButton");
        sendShareViewEnd();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showToastForShareView(int kind, String rejecterID) {
        logI("<CIH> showToastForShareView(), kind = " + kind + ", rejecterID = " + rejecterID);
        switch (kind) {
            case 0:
                showToast(C0000R.string.share_view_toast_popup_1);
                break;
            case 1:
                showToast(C0000R.string.share_view_toast_popup_2);
                break;
            case 2:
                showToast(getString(C0000R.string.share_view_toast_popup_3, new Object[]{"'" + getUserName(rejecterID) + "'"}));
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
                showToast(getString(C0000R.string.share_view_toast_popup_7, new Object[]{getUserName(rejecterID)}));
                break;
        }
    }

    private void sendShareViewCameraZoomToServer(int value) {
        logI("sendShareViewCameraZoomToServer: " + value);
        MainApplication.mPhoneManager.getPhoneStateMachine().sendCameraZoomInfo(value);
    }

    public void goneOtherViewForMemberView() {
        gonePreviewLayout();
        this.mCallBtnLayout.setVisibility(8);
    }

    public void showOtherViewForMemberView() {
        setSurfaceViewLayout();
        this.mCallBtnLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChangeToConferenceStart() throws Throwable {
        logI("<<YHT101>>---------- handleChangeToConferenceStart ------------------");
        this.mIsChangeToConference = true;
        if (this.mUseDualCamera) {
            stopDualCamera();
        }
        if (this.mBuddyImageOnly) {
            setSurfaceZOrderMediaOverlay();
            this.mOnlyBuddyLayout.setVisibility(8);
        }
        initPreviewPosition(false);
        if (this.mChanagePreview) {
            setViewGuideLineStatus(0, 1);
            setViewGuideLineStatus(1, 0);
            setDefaultSurfaceView(true);
        }
        setPreViewWhiteOutLine();
        setConferenceSurface(true, true);
        updatePreviewLayout(false);
        this.mMemberCount = getConferenceConnectCount();
        this.mCoverRecieveLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination.getDestinationType(), this);
        this.mCoverRecieveLayout.setMember(this.mDestination, this.mCalluserInfo);
        closeOptionsMenu();
    }

    private void initPreviewPosition(boolean otherOrientation) {
        this.mIsMovePreviewPosition = false;
        if (otherOrientation) {
            if (getResources().getConfiguration().orientation == 1) {
                if (this.mIsTranslatorOptionMenuEnable) {
                    this.mImgPoint = new Point(this.mPreviewPaddigLeft + this.mHWGap, (this.mPreViewPaddingTop + this.mHWGap) - 144);
                    return;
                } else {
                    this.mImgPoint = new Point(this.mPreviewPaddigLeft + this.mHWGap, this.mPreViewPaddingTop + this.mHWGap);
                    return;
                }
            }
            if (this.mIsTranslatorOptionMenuEnable) {
                this.mImgPoint = new Point(this.mLandPreviewPaddigLeft + this.mHWGap, (this.mLandPreViewPaddingTop - this.mHWGap) - 144);
                return;
            } else {
                this.mImgPoint = new Point(this.mLandPreviewPaddigLeft + this.mHWGap, this.mLandPreViewPaddingTop - this.mHWGap);
                return;
            }
        }
        if (getResources().getConfiguration().orientation == 1) {
            if (this.mIsTranslatorOptionMenuEnable) {
                this.mImgPoint = new Point(this.mPreviewPaddigLeft, this.mPreViewPaddingTop - 144);
                return;
            } else {
                this.mImgPoint = new Point(this.mPreviewPaddigLeft, this.mPreViewPaddingTop);
                return;
            }
        }
        if (this.mIsTranslatorOptionMenuEnable) {
            this.mImgPoint = new Point(this.mLandPreviewPaddigLeft, this.mLandPreViewPaddingTop - 144);
        } else {
            this.mImgPoint = new Point(this.mLandPreviewPaddigLeft, this.mLandPreViewPaddingTop);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChangeToConferenceFailure() {
        this.mIsChangeToConference = false;
        resizePreview2OriginalSize();
        dismissChangeToConferenceDialog();
        showToast(C0000R.string.change_to_conference_fail);
        if ((this.mInviteViewCtrl.isActive() || !isConference()) && this.mInviteviewMemberLayout != null) {
            this.mInviteViewCtrl.endInviteView();
            goneInviteView();
        }
        this.mCoverRecieveLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination.getDestinationType(), this);
        this.mCoverRecieveLayout.setMember(this.mDestination, this.mCalluserInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChangeToConferenceFinish() {
        this.mIsChangeToConference = false;
        dismissChangeToConferenceDialog();
        showToast(C0000R.string.change_to_conference_finish);
        this.mMemberCount = -1;
        this.mCoverRecieveLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination.getDestinationType(), this);
        this.mCoverRecieveLayout.setMember(this.mDestination, this.mCalluserInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPreViewWhiteOutLine() {
        if (CallState.isNotConnected(this.mCallState)) {
            setViewGuideLineStatus(0, 0);
            setViewGuideLineStatus(0, 1);
        } else if (this.mChanagePreview) {
            setViewGuideLineStatus(0, 0);
            setViewGuideLineStatus(1, 1);
        } else {
            setViewGuideLineStatus(0, 1);
            setViewGuideLineStatus(1, 0);
        }
    }

    private void setViewGuideLineStatus(int previewStaut, int isRemote) {
        setPreviewGuideLineStatus(previewStaut, 3, isRemote);
    }

    public boolean isLandscapeMode() {
        return this.mIsLandscapeMode;
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    protected void startMemberView(VideoCallStatusBar videoCallStatusBar) {
        super.startMemberView(this.mVideoCallStatusBar);
        gonePreviewLayout();
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    protected void endMemberView() {
        super.endMemberView();
        showPreviewLayout();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void notifyConsentReject(int type, int option, ConsentDisplayInfo cdi) {
        logI("<CIH> notifyConsentReject()");
        dismissCallConsentUserActionDialog();
        dismissCallConsentProcessingDialog();
        switch (type) {
            case 1:
                if (cdi.isTimeout) {
                    if (cdi.isSender) {
                        showToast(getResources().getString(C0000R.string.call_switch_timercancel_video));
                        break;
                    }
                } else if ((cdi.rejecterID == null || !cdi.rejecterID.equals(MainApplication.mConfig.getProfileUserID())) && !"".equals(cdi.rejecterID) && cdi.rejecterID != null && !cdi.rejecterID.isEmpty()) {
                    showToast(getResources().getString(C0000R.string.call_switch_reject_msg_video));
                    break;
                }
                break;
            case 2:
                if (cdi.isTimeout) {
                    if (cdi.isSender) {
                        showToast(getResources().getString(C0000R.string.share_view_toast_popup_5));
                        break;
                    }
                } else if ((cdi.rejecterID == null || !cdi.rejecterID.equals(MainApplication.mConfig.getProfileUserID())) && !"".equals(cdi.rejecterID) && cdi.rejecterID != null && !cdi.rejecterID.isEmpty()) {
                    showToast(getString(C0000R.string.share_view_toast_popup_7, new Object[]{getUserName(cdi.rejecterID)}));
                    break;
                }
                break;
            case 3:
                this.mIsShareScreenCaller = false;
                this.mIsShareScreenWaitForAccepting = false;
                if (cdi.isTimeout) {
                    if (cdi.isSender) {
                        showToast(getResources().getString(C0000R.string.screenshare_consent_timeout));
                        break;
                    }
                } else if ((cdi.rejecterID == null || !cdi.rejecterID.equals(MainApplication.mConfig.getProfileUserID())) && !"".equals(cdi.rejecterID) && cdi.rejecterID != null && !cdi.rejecterID.isEmpty()) {
                    showToast(getResources().getString(C0000R.string.screenshare_consent_reject, getUserName(cdi.rejecterID)));
                    break;
                }
                break;
            case 4:
                if (option == 2) {
                    if (!cdi.rejecterID.equals(MainApplication.mConfig.getProfileUserID())) {
                        setRecordRequested(false);
                        showToast(getResources().getString(C0000R.string.call_consent_alert_msg_record_reject_video, getUserName(cdi.rejecterID)));
                        break;
                    }
                } else if (option != 1) {
                    logE("<CIH> option Error, option = " + option);
                    break;
                }
                break;
            case 5:
                showToast("번역이 거절되었습니다");
                closeSTTTranslationTTS(false);
                break;
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void notifyConsentAccept(int type, int option, ConsentDisplayInfo cdi) throws Throwable {
        logI("<CIH> notifyConsentAccept() type = " + type + ", option = " + option + ", cid.isSender = " + cdi.isSender);
        dismissCallConsentUserActionDialog();
        if (type == 3) {
            if (this.mCallConsentProgressDialog == null) {
                this.mCallConsentProgressDialog = new ProgressDialog(this, C0000R.style.ChatOnVProgress);
            }
            if (cdi.isSender) {
                this.mCallConsentProgressDialog.setMessage(getString(C0000R.string.screenshare_attention_body_ask));
            } else {
                Toast.makeText(this, getString(C0000R.string.screenshare_attention_body_ask), 1000).show();
            }
        } else {
            dismissCallConsentProcessingDialog();
        }
        switch (type) {
            case 1:
                if (this.mUseDualCamera) {
                    stopDualCamera();
                }
                showToast(getResources().getString(C0000R.string.call_switch_accept_msg_video));
                super.notifyConsentAccept(type, option, cdi);
                break;
            case 2:
                showToast(getResources().getString(C0000R.string.share_view_toast_popup_2));
                startShareView(cdi.isSender);
                break;
            case 3:
                this.mIsShareScreenWaitForAccepting = false;
                if (cdi.isSender) {
                    this.mIsShareScreenCaller = true;
                }
                if (this.mIsRecording) {
                    setRecord();
                }
                dismissCallConsentProcessingDialog();
                break;
            case 4:
                if (option == 2) {
                    if (cdi.isSender) {
                        startRecordCallAfterConsent();
                        break;
                    } else {
                        showToast(C0000R.string.recording_started);
                        break;
                    }
                } else if (option != 1) {
                    logE("<CIH> option Error, option = " + option);
                    break;
                }
                break;
            case 5:
                if (MainApplication.mPhoneManager.isTranslateTest()) {
                    showToast("번역이 수락되었습니다");
                    this.mIsTranslatorOptionMenuEnable = true;
                    translatorChagneUi(this.mIsTranslatorOptionMenuEnable);
                    setSurfaceZOrderMediaOverlay();
                    initTranslatorViewController();
                    initSTTTranslationTTSLanguage(cdi.isSender, TranslationUtil.get1stConsentParamLanguage(option), TranslationUtil.get2ndConsentParamLanguage(option));
                    break;
                }
                break;
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void notifyConsentRequestAskReceive(int type, int option, String requesterID) {
        closeOptionsMenu();
        dismissVideoDialog();
        showCallConsentUserActionDialog(type, option, requesterID);
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleStartShareScreen() {
        super.handleStartShareScreen();
        if (!this.mSurfaceDestroyed) {
            this.mSurfaceDestroyed = true;
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleRecognitionStart(TranslationDisplayData data) {
        logI("YKYU handleRecognitionStart()");
        logI("YKYU handleRecognitionStart() " + data.getRecognizedText() + ",  " + data.getTranslatedText());
        logI("YKYU " + data.toString());
        if (this.mTranslatorViewController != null) {
            this.mTranslatorViewController.handleRecognitionStart(data);
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleRecognitionEnd(TranslationDisplayData data) {
        logI("YKYU handleRecognitionEnd() " + data.getRecognizedText() + ",  " + data.getTranslatedText());
        logI("YKYU " + data.toString());
        boolean incomingMsgOnly = false;
        if (this.mTranslatorViewController != null) {
            incomingMsgOnly = this.mTranslatorViewController.getInComingMsgOnlyOnOff(data);
            this.mTranslatorViewController.handleRecognitionEnd(data, incomingMsgOnly);
        }
        if (!incomingMsgOnly && !startTranslation(data)) {
            Log.m2963i("YKYU Translation START ERROR!!!");
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleRecognitionStop() throws Throwable {
        logI("YKYU handleRecognitionStop()");
        this.mIsTranslatorOptionMenuEnable = false;
        closeSTTTranslationTTS(false);
        initSTTTranslationTTS();
        translatorChagneUi(this.mIsTranslatorOptionMenuEnable);
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleTranslationStart(TranslationDisplayData data) {
        logI("YKYU handleTranslationStart()");
        logI("YKYU handleTranslationStart() " + data.getRecognizedText() + ",  " + data.getTranslatedText());
        logI("YKYU " + data.toString());
        if (this.mTranslatorViewController != null) {
            this.mTranslatorViewController.handleTranslationStart(data);
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleTranslationEnd(TranslationDisplayData data) {
        logI("YKYU handleTranslationEnd() " + data.getRecognizedText() + ",  " + data.getTranslatedText());
        logI("YKYU " + data.toString());
        if (this.mTranslatorViewController != null) {
            this.mTranslatorViewController.handleTranslationEnd(data);
        }
        if (this.mBubbleTTSPlayer != null) {
            this.mBubbleTTSPlayer.play();
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleTTSStart(String id) {
        Log.m2963i("YKYU handleTTSStart -start-");
        logI(id);
        if (this.mTranslatorViewController != null) {
            Log.m2963i("YKYU handleTTSStart 1-");
            this.mTranslatorViewController.handleTTSStart(id);
        }
        Log.m2963i("YKYU handleTTSStart end-");
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleTTSEnd(String id) {
        Log.m2963i("YKYU handleTTSEnd -start-");
        logI(id);
        if (this.mTranslatorViewController != null) {
            Log.m2963i("YKYU handleTTSEnd -1-");
            this.mTranslatorViewController.handleTTSEnd(id);
        }
        if (this.mBubbleTTSPlayer != null) {
            Log.m2963i("YKYU handleTTSEnd -2-");
            this.mBubbleTTSPlayer.stop();
            this.mBubbleTTSPlayer.play();
        }
        Log.m2963i("YKYU handleTTSEnd -end-");
    }

    @Override // com.coolots.chaton.call.util.ITranslationTTSInterface
    public void TTS_Start(TranslationDisplayData data) {
        playTTS(data);
    }

    public void Start_BubbleTTSPlayer() {
        logI("Start_BubbleTTSPlayer()");
        startTTSMode();
        if (this.mBubbleTTSPlayer == null) {
            this.mBubbleTTSPlayer = new BubbleTTSPlayer(this.mChatOnTranslationDataController, this);
        }
        this.mBubbleTTSPlayer.init();
    }

    public void End_BubbleTTSPlayer() {
        logI("End_BubbleTTSPlayer()");
        this.mBubbleTTSPlayer.finish();
        stopTTSMode();
    }

    public void translatorChagneUi(boolean isTranslator) throws Throwable {
        if (isTranslator) {
            this.mCallTranslatorLayout.setVisibility(0);
            this.mCallTranslatorScrollViewLayout.setVisibility(0);
        } else {
            this.mCallTranslatorLayout.setVisibility(8);
            this.mCallTranslatorScrollViewLayout.setVisibility(8);
        }
        initPreviewPosition(false);
        setSurfaceViewLayout();
        updatePreviewLayout(false);
    }

    public void initTranslatorViewController() {
        if (this.mTranslatorViewController == null) {
            this.mTranslatorViewController = new TranslatorViewController(getCallOtherPartyUserInfo().userName, this.mDestination, this.mChatOnTranslationDataController, this.mIsTranslatorIncomingMsgOnlyChecked);
            this.mTranslatorViewController.addITranslatorViewController(this.mCallTranslatorScrollViewLayout);
            this.mTranslatorViewController.addITranslatorViewController(this.mVideoCallStatusBar);
        } else {
            this.mTranslatorViewController.removeITranslatorViewController();
            this.mTranslatorViewController.addITranslatorViewController(this.mCallTranslatorScrollViewLayout);
            this.mTranslatorViewController.addITranslatorViewController(this.mVideoCallStatusBar);
            this.mTranslatorViewController.loadAllDatatoTranslatorView();
        }
        this.mCallTranslatorLayout.setTranslateModeValue(this.mTranslatorViewController.getTranslateModeValue());
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void airCallSweepRight() {
        if (isDrivingModeUIOn()) {
            receiveCall();
        } else {
            this.mCallReceiveBtnLayout.airCallSweepRight();
        }
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void airCallHandShape() {
        if (isDrivingModeUIOn()) {
            receiveCall();
            return;
        }
        this.mCallReceiveBtnLayout.airCallHandShape();
        if (isAirGestureAcceptCallSpeakerOn()) {
            this.mAudioPathController.initCallConnectedByBargeIn(false);
        }
    }

    public int getPreviewPaddingRight() {
        return this.mPreviewPaddingRight;
    }

    public int getVideoCallStatusBarHeight() {
        return this.mModelInfo.getCallStatusBarHeight();
    }

    public int getButtonLayoutSize() {
        return getButtonLayoutSize(getResources().getConfiguration().orientation);
    }

    public int getButtonLayoutSize(int orientation) {
        int size = this.mModelInfo.getPortPaddingBottom();
        if (orientation == 2) {
            int size2 = this.mModelInfo.getLandPaddingRight();
            return size2;
        }
        return size;
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setClearCover() throws Throwable {
        if (isCoverOpen()) {
            this.mStatusBarManager.disable(ChatONStatusBarController.setFlag(65536, false));
            setRequestedOrientation(2);
            checkHookingHomeKeyforCover(true);
            setSurfaceZOrderOnTop();
        } else {
            this.mStatusBarManager.disable(ChatONStatusBarController.setFlag(65536, true));
            setRequestedOrientation(1);
            checkHookingHomeKeyforCover(false);
            dismissVideoDialog();
            this.mVideoCallStatusBar.dismissFunDialog();
            setSurfaceZOrderMediaOverlay();
        }
        updateUIComponent();
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void displayShareScreenAttention() {
        if (((ChatOnConfigInterface) MainApplication.mConfig).isCheckShareScreenChangeVoice()) {
            startShareScreen();
        } else {
            showDialog(DIALOG_SHARE_SCREEN_CHANGE_VOICE);
        }
    }

    public int getSavedOrientation() {
        return this.mSavedOrientation;
    }

    public boolean isAutoRotation() {
        return isAutorotationActive();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void hangupEntitlement() {
        showToast(C0000R.string.information_str_msg_23);
        hangupCall();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void hangupNetworkErrorEntitlement() {
        showToast(C0000R.string.information_str_msg_23);
        hangupCall();
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public long getNowDateSetting() {
        Date d = MainApplication.mPhoneManager.getPhoneStateMachine().getCallConnectedTime();
        if (d == null) {
            return 0L;
        }
        Date dN = new Date();
        dNow = dN.getTime() - d.getTime();
        return dNow;
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void setMuteStateForVideo(boolean muteOn) {
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.setIsMuteStatus(muteOn);
        }
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setHangUpCallUI() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void errorForUI() {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Settings.System.putInt(getBaseContext().getContentResolver(), "screen_brightness_mode", this.mAutomatic);
        if (!hasFocus && !checkForegroundActivity() && (CallState.isCalling(this.mCallState) || (CallState.isConnected(this.mCallState) && !MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall()))) {
            MainApplication.mCallNotification.showCallButtonNotification();
        } else if (hasFocus) {
            MainApplication.mCallNotification.deleteCallNotification();
        }
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public boolean isShowingAnimationMenu() {
        return this.mVideoCallOptionMng.isShowingAnyMenu();
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void updateChangeCall() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void cancelSlectedThemeShot() {
        this.mVideoCallThemeShotLayout.setSubThemeShotAllNotSelected();
    }

    public void removeStatusbarAnimation() {
        if (this.mTitleBarHandler != null) {
            this.mTitleBarHandler.removeMessages(0);
            this.mTitleBarHandler.removeMessages(1);
            this.mTitleBarHandler.removeMessages(2);
            this.mTitleBarHandler.removeMessages(3);
            this.mTitleBarHandler.removeMessages(4);
        }
    }

    public void startStatusbarAnimation() {
        goneTopStatusBar(0);
    }
}
