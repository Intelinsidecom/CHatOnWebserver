package com.coolots.chaton.call.screenshare.activity;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.screenshare.ScreenShareProc;
import com.coolots.chaton.call.screenshare.util.AlertView;
import com.coolots.chaton.call.screenshare.util.MultiSettingStrokeInfo;
import com.coolots.chaton.call.screenshare.util.PenWriteNetwork;
import com.coolots.chaton.call.screenshare.util.PenWritingCapture;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.coolots.chaton.call.screenshare.util.SettingPacket;
import com.coolots.chaton.call.screenshare.util.SettingView;
import com.coolots.chaton.call.screenshare.util.SpenSettingInfo;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.SpenSettingEraserInfo;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingTextInfo;
import com.samsung.android.sdk.pen.document.SpenNoteDoc;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.engine.SpenColorPickerListener;
import com.samsung.android.sdk.pen.engine.SpenMultiView;
import com.samsung.android.sdk.pen.engine.SpenTouchListener;
import com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout;
import com.samsung.spen.settings.SettingStrokeInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class PenWritingViewLayout3 extends ScreenShareLayout implements DisposeInterface {
    private static final String CLASSNAME = "[PenWritingViewLayout]";
    private static final int OTHERID = 2;
    private static final int SHARERID = 1;
    private static long gDownTime;
    final int INKPEN;
    private boolean isHidden;
    private boolean isSpenFeatureEnabled;
    private View.OnClickListener mBtnClickListener;
    private RelativeLayout mCanvasLayout;
    private ImageView mCaptureBtn;
    private AlertView mClearAlertView;
    private ImageView mClearBtn;
    SpenColorPickerListener mColorPickerListener;
    private Display mDisplay;
    private Button mEndBtn;
    private ImageView mEraserBtn;
    private Handler mHandler;
    private ImageView mHideBtn;
    SpenPageDoc.HistoryListener mHistoryListener;
    private RelativeLayout.LayoutParams mLayoutParams;
    private SpenNoteDoc mNoteDoc;
    private ImageView mPenBtn;
    private View mPenColor;
    SpenTouchListener mPenTouchListener;
    private PenWritingCapture mPenWritingCapture;
    private ImageView mRedoBtn;
    private ScreenShareActivity mScreenShareActivity;
    private SettingStrokeInfo mSendSettingStrokeInfo;
    private SettingView mSettingView;
    private RelativeLayout mShareViewToolbarLayout;
    private SpenMultiView mSpenMulitView;
    private SpenPageDoc mSpenPageDoc;
    private SpenSettingInfo mSpenSettingInfo;
    private int mSpenSettingMode;
    private LinearLayout mToolbarBtnLayout;
    private LinearLayout mToolbarCaptureLayout;
    private LayoutTransition mTransition;
    private ImageView mUndoBtn;
    private View.OnClickListener undoNredoBtnClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public PenWritingViewLayout3(Context context, int layoutResId, ScreenShareActivity screenShareActivity) {
        super(context, layoutResId);
        this.mHandler = new Handler();
        this.isHidden = false;
        this.isSpenFeatureEnabled = false;
        this.undoNredoBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout3.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                byte[] cmdData = PenWriteNetwork.intToByte(PenWritingViewLayout3.this.mUserID);
                if (v.equals(PenWritingViewLayout3.this.mUndoBtn)) {
                    SpenPageDoc.HistoryUpdateInfo[] userData = PenWritingViewLayout3.this.mSpenPageDoc.undo(2);
                    PenWritingViewLayout3.this.mSpenMulitView.updateUndo(userData, 2);
                    PenWritingViewLayout3.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO, cmdData);
                } else {
                    SpenPageDoc.HistoryUpdateInfo[] userData2 = PenWritingViewLayout3.this.mSpenPageDoc.redo(2);
                    PenWritingViewLayout3.this.mSpenMulitView.updateRedo(userData2, 2);
                    PenWritingViewLayout3.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO, cmdData);
                }
                PenWritingViewLayout3.this.updateUndoRedoBtnState();
            }
        };
        this.mBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout3.2
            int fingerAction;
            int settingViewSize;
            int spenAction;

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (PenWritingViewLayout3.this.mSpenMulitView.getToolTypeAction(2) == 5) {
                    PenWritingViewLayout3.this.mSettingView.closeSettingView();
                }
                if (!v.equals(PenWritingViewLayout3.this.mEndBtn)) {
                    if (!v.equals(PenWritingViewLayout3.this.mHideBtn)) {
                        if (!v.equals(PenWritingViewLayout3.this.mCaptureBtn)) {
                            if (!v.equals(PenWritingViewLayout3.this.mEraserBtn)) {
                                if (v.equals(PenWritingViewLayout3.this.mClearBtn)) {
                                    PenWritingViewLayout3.this.mSpenSettingMode = 3;
                                    this.fingerAction = 7;
                                    if (this.spenAction != 7) {
                                        PenWritingViewLayout3.this.mSettingView.closeSettingView();
                                    } else {
                                        PenWritingViewLayout3.this.mSettingView.toggleShowSettingView(PenWritingViewLayout3.this.mSpenSettingMode, this.settingViewSize);
                                    }
                                    this.spenAction = 7;
                                    this.settingViewSize = 0;
                                } else {
                                    PenWritingViewLayout3.this.mSpenSettingMode = 1;
                                    this.fingerAction = 2;
                                    if (this.spenAction != 2) {
                                        PenWritingViewLayout3.this.mSettingView.closeSettingView();
                                    } else {
                                        PenWritingViewLayout3.this.mSettingView.toggleShowSettingView(PenWritingViewLayout3.this.mSpenSettingMode, this.settingViewSize);
                                    }
                                    this.spenAction = 2;
                                    this.settingViewSize = 2;
                                }
                            } else {
                                PenWritingViewLayout3.this.mSpenSettingMode = 2;
                                this.fingerAction = 3;
                                if (this.spenAction != 3) {
                                    PenWritingViewLayout3.this.mSettingView.closeSettingView();
                                } else {
                                    PenWritingViewLayout3.this.mSettingView.toggleShowSettingView(PenWritingViewLayout3.this.mSpenSettingMode, this.settingViewSize);
                                }
                                this.spenAction = 3;
                                this.settingViewSize = 0;
                            }
                            if (PenWritingViewLayout3.this.mSpenMulitView.getToolTypeAction(2) != this.spenAction) {
                                PenWritingViewLayout3.this.mSpenMulitView.setToolTypeAction(1, this.fingerAction);
                                PenWritingViewLayout3.this.mSpenMulitView.setToolTypeAction(2, this.spenAction);
                            }
                            PenWritingViewLayout3.this.updateUndoRedoBtnState();
                            PenWritingViewLayout3.this.updateBtnState(v);
                            return;
                        }
                        int res = PenWritingViewLayout3.this.mPenWritingCapture.ScreenOtherCapture();
                        if (res < 0) {
                            ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_pen_writing_capture_fail), 0);
                            return;
                        } else {
                            ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_pen_writing_capture), 0);
                            return;
                        }
                    }
                    PenWritingViewLayout3.this.btnHidden(PenWritingViewLayout3.this.isHidden);
                    PenWritingViewLayout3.this.mSettingView.closeSettingView();
                    return;
                }
                PenWritingViewLayout3.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_SHARE_MODE, null);
                PenWritingViewLayout3.this.mScreenShareActivity.setOtherPause(false);
                PenWritingViewLayout3.this.mScreenShareActivity.chageShareView();
            }
        };
        this.INKPEN = 1;
        this.mSpenSettingMode = 1;
        this.mColorPickerListener = new SpenColorPickerListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout3.3
            @Override // com.samsung.android.sdk.pen.engine.SpenColorPickerListener
            public void onChanged(int color, int x, int y) {
                if (PenWritingViewLayout3.this.mSettingView != null) {
                    SpenSettingPenInfo penInfo = PenWritingViewLayout3.this.mSettingView.getSpenPenInfo();
                    penInfo.color = color;
                    PenWritingViewLayout3.this.mSettingView.setSpenPenInfo(penInfo);
                    SpenSettingTextInfo textInfo = PenWritingViewLayout3.this.mSettingView.getTextInfo();
                    textInfo.color = color;
                    PenWritingViewLayout3.this.mSettingView.setTextInfo(textInfo);
                }
            }
        };
        this.mHistoryListener = new SpenPageDoc.HistoryListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout3.4
            @Override // com.samsung.android.sdk.pen.document.SpenPageDoc.HistoryListener
            public void onCommit(SpenPageDoc page) {
            }

            @Override // com.samsung.android.sdk.pen.document.SpenPageDoc.HistoryListener
            public void onRedoable(SpenPageDoc page, boolean redoable) {
            }

            @Override // com.samsung.android.sdk.pen.document.SpenPageDoc.HistoryListener
            public void onUndoable(SpenPageDoc page, boolean undoable) {
            }
        };
        this.mPenTouchListener = new SpenTouchListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout3.5
            @Override // com.samsung.android.sdk.pen.engine.SpenTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if (PenWritingViewLayout3.this.mSpenMulitView != null) {
                    if (event.getAction() == 0) {
                        SpenSettingInfo spensettinginfo = new SpenSettingInfo(PenWritingViewLayout3.this.mSpenSettingMode, PenWritingViewLayout3.this.mSpenMulitView, 2);
                        byte[] cmdData = SettingPacket.makeSettingStrokeInfo(2, spensettinginfo);
                        if (PenWritingViewLayout3.this.mSpenSettingInfo == null || !SettingPacket.equalsSettingInfo(PenWritingViewLayout3.this.mSpenSettingInfo, spensettinginfo)) {
                            PenWritingViewLayout3.this.mSpenSettingInfo = SettingPacket.copySettingInfo(PenWritingViewLayout3.this.mSpenSettingMode, spensettinginfo);
                            PenWritingViewLayout3.this.onSendData(100, cmdData);
                        }
                    }
                    if (PenWritingViewLayout3.this.mOnSendCommandData != null) {
                        float rawX = PenWritingViewLayout3.this.mScreenShareActivity.mScreenScale.modifyExpandScaleX(event.getX(event.getPointerCount() - 1));
                        float rawY = PenWritingViewLayout3.this.mScreenShareActivity.mScreenScale.modifyExpandScaleY(event.getY(event.getPointerCount() - 1));
                        MotionEvent.PointerProperties[] pp = {new MotionEvent.PointerProperties()};
                        pp[0].toolType = event.getToolType(0);
                        pp[0].id = 0;
                        MotionEvent.PointerCoords[] pc = {new MotionEvent.PointerCoords()};
                        pc[0].x = rawX;
                        pc[0].y = rawY;
                        MotionEvent mEvent = MotionEvent.obtain(event.getDownTime(), event.getDownTime() + (event.getEventTime() - event.getDownTime()), event.getAction(), 1, pp, pc, event.getMetaState(), event.getButtonState(), event.getXPrecision(), event.getYPrecision(), event.getDeviceId(), event.getEdgeFlags(), event.getSource(), event.getFlags());
                        byte[] cmdData2 = PenWriteNetwork.makeSpenMotionEvent(2, 0, mEvent);
                        if (PenWritingViewLayout3.this.mSpenSettingMode != 3) {
                            PenWritingViewLayout3.this.logI("YKYU sendTouchEvent() -4-");
                            PenWritingViewLayout3.this.onSendData(300, cmdData2);
                        }
                    }
                    PenWritingViewLayout3.this.updateUndoRedoBtnState();
                    PenWritingViewLayout3.this.mSpenMulitView.invalidate();
                    return false;
                }
                return false;
            }
        };
        logI("PenWritingViewLayout()");
        this.mScreenShareActivity = screenShareActivity;
        WindowManager windowsManager = (WindowManager) getContext().getSystemService("window");
        this.mDisplay = windowsManager.getDefaultDisplay();
        RelativeLayout.LayoutParams thisLayoutParam = new RelativeLayout.LayoutParams(-1, -1);
        setLayoutParams(thisLayoutParam);
        initScaleData();
        load();
    }

    private void initScaleData() {
        this.mScreenShareActivity.initScaleData();
    }

    private void load() {
        this.mPenWritingCapture = new PenWritingCapture();
        initPenMenuView();
        initSpen();
        initCanvas();
        initPage();
        initSettingView();
        initSettingInfo();
    }

    private void initPenMenuView() {
        this.mEndBtn = (Button) findViewById(C0000R.id.end_btn);
        this.mPenBtn = (ImageView) findViewById(C0000R.id.pen_btn);
        this.mEraserBtn = (ImageView) findViewById(C0000R.id.eraser_btn);
        this.mClearBtn = (ImageView) findViewById(C0000R.id.clear_btn);
        this.mUndoBtn = (ImageView) findViewById(C0000R.id.undo_btn);
        this.mRedoBtn = (ImageView) findViewById(C0000R.id.redo_btn);
        this.mCaptureBtn = (ImageView) findViewById(C0000R.id.camera_btn);
        this.mHideBtn = (ImageView) findViewById(C0000R.id.showhide_btn);
        this.mToolbarBtnLayout = (LinearLayout) findViewById(C0000R.id.share_view_toolbar_layout);
        this.mToolbarCaptureLayout = (LinearLayout) findViewById(C0000R.id.camera_btn_layout);
        this.mShareViewToolbarLayout = (RelativeLayout) findViewById(C0000R.id.share_view_toolbar_layout1);
        this.mPenBtn.setOnClickListener(this.mBtnClickListener);
        this.mEraserBtn.setOnClickListener(this.mBtnClickListener);
        this.mClearBtn.setOnClickListener(this.mBtnClickListener);
        this.mCaptureBtn.setOnClickListener(this.mBtnClickListener);
        this.mEndBtn.setOnClickListener(this.mBtnClickListener);
        this.mHideBtn.setOnClickListener(this.mBtnClickListener);
        this.mUndoBtn.setOnClickListener(this.undoNredoBtnClickListener);
        this.mRedoBtn.setOnClickListener(this.undoNredoBtnClickListener);
        this.mUndoBtn.setEnabled(false);
        this.mRedoBtn.setEnabled(false);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mShareViewToolbarLayout.getLayoutParams();
        layoutParams.width = this.mDisplay.getWidth() > this.mDisplay.getHeight() ? this.mDisplay.getHeight() : this.mDisplay.getWidth();
        this.mShareViewToolbarLayout.setLayoutParams(layoutParams);
    }

    private void stopScreenShare() {
        MainApplication.mPhoneManager.getShareScreenManager().stopShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination());
        ScreenShareProc.stopScreenShare();
    }

    private void initSpen() {
        Spen spenSdk = new Spen();
        try {
            spenSdk.initialize(this.mContext);
            this.isSpenFeatureEnabled = spenSdk.isFeatureEnabled(0);
        } catch (SsdkUnsupportedException e) {
            e.printStackTrace();
            stopScreenShare();
        } catch (Exception e1) {
            e1.printStackTrace();
            stopScreenShare();
        }
    }

    private void initCanvas() {
        this.mCanvasLayout = (RelativeLayout) findViewById(C0000R.id.draw_canvas);
        try {
            this.mSpenMulitView = new SpenMultiView(this.mContext);
            this.mSpenMulitView.setLocalUserId(2);
            this.mSpenMulitView.addUser(1);
            this.mCanvasLayout.addView(this.mSpenMulitView);
        } catch (Exception e) {
            e.printStackTrace();
            stopScreenShare();
        } catch (UnsatisfiedLinkError error) {
            error.printStackTrace();
            stopScreenShare();
        }
    }

    private void initPage() {
        Rect screenSize = new Rect();
        Display display = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        display.getRectSize(screenSize);
        try {
            this.mNoteDoc = new SpenNoteDoc(this.mContext, screenSize.width(), screenSize.height());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mSpenPageDoc = this.mNoteDoc.appendPage();
        this.mSpenPageDoc.setBackgroundColor(0);
        this.mSpenPageDoc.setBackgroundImageMode(2);
        this.mSpenPageDoc.clearHistory();
        setRegisterListener();
        this.mSpenPageDoc.setHistoryManagerMode(1);
        this.mSpenMulitView.setPageDoc(this.mSpenPageDoc, true);
        updateBtnState(this.mPenBtn);
    }

    private void setRegisterListener() {
        this.mSpenMulitView.setColorPickerListener(this.mColorPickerListener);
        this.mSpenPageDoc.setHistoryListener(this.mHistoryListener);
        this.mSpenMulitView.setTouchListener(this.mPenTouchListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUndoRedoBtnState() {
        this.mRedoBtn.setEnabled(this.mSpenPageDoc.isRedoable(2));
        this.mUndoBtn.setEnabled(this.mSpenPageDoc.isUndoable(2));
    }

    private void initSettingView() {
        FrameLayout settingViewParent = (FrameLayout) findViewById(C0000R.id.canvas_container);
        this.mSettingView = new SettingView(this.mContext, this.mCanvasLayout);
        this.mSettingView.setCanvasView(this.mSpenMulitView);
        settingViewParent.addView(this.mSettingView);
    }

    private void initSettingInfo() {
        SpenSettingPenInfo penInfo = this.mSpenMulitView.getPenSettingInfo(2);
        penInfo.color = -5921371;
        penInfo.size = 20.0f;
        this.mSpenMulitView.setPenSettingInfo(2, penInfo);
        this.mSettingView.setSpenPenInfo(penInfo);
        SpenSettingEraserInfo eraserInfo = this.mSpenMulitView.getEraserSettingInfo(2);
        eraserInfo.size = 20.0f;
        this.mSpenMulitView.setEraserSettingInfo(2, eraserInfo);
        this.mSettingView.setEraserInfo(eraserInfo);
        this.mSettingView.setEraserListener(new SpenSettingEraserLayout.EventListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout3.6
            @Override // com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.EventListener
            public void onClearAll() throws Resources.NotFoundException {
                PenWritingViewLayout3.this.mClearAlertView = new AlertView(MainApplication.mContext);
                PenWritingViewLayout3.this.mClearAlertView.setTitle(C0000R.string.screenshare_alertView_attention_title);
                PenWritingViewLayout3.this.mClearAlertView.setMessage(C0000R.string.screenshare_alertView_attention_message);
                PenWritingViewLayout3.this.mClearAlertView.setPositiveButton(C0000R.string.ok, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout3.6.1
                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                    public void onClick(AlertView dialog, int which) {
                        SpenPageDoc.HistoryUpdateInfo[] userDataOther = PenWritingViewLayout3.this.mSpenPageDoc.undoAll(2);
                        SpenPageDoc.HistoryUpdateInfo[] userData = PenWritingViewLayout3.this.mSpenPageDoc.undoAll(1);
                        PenWritingViewLayout3.this.mSpenMulitView.updateUndo(userDataOther, 2);
                        PenWritingViewLayout3.this.mSpenMulitView.updateUndo(userData, 1);
                        PenWritingViewLayout3.this.mSpenPageDoc.clearHistory();
                        PenWritingViewLayout3.this.updateUndoRedoBtnState();
                        SpenSettingEraserLayout layout = PenWritingViewLayout3.this.mSettingView.getSpenSettingEraserLayout();
                        layout.setVisibility(8);
                        PenWritingViewLayout3.this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARALL, null);
                    }
                });
                PenWritingViewLayout3.this.mClearAlertView.setNegativeButton(C0000R.string.cancel, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout3.6.2
                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                    public void onClick(AlertView dialog, int which) {
                    }
                });
                PenWritingViewLayout3.this.mClearAlertView.setCancelable(true);
                PenWritingViewLayout3.this.mClearAlertView.show();
            }
        });
        this.mSpenMulitView.setToolTypeAction(2, 1, 2);
        this.mSpenMulitView.setToolTypeAction(2, 2, 2);
    }

    @Override // com.coolots.chaton.call.screenshare.activity.ScreenShareLayout
    public void show() {
        logI("show()");
        btnHidden(true);
        super.show();
    }

    @Override // com.coolots.chaton.call.screenshare.activity.ScreenShareLayout
    public void dismiss() {
        this.mShow = false;
        setEnabled(this.mShow);
        setVisibility(8);
    }

    public void setUserID(int userid) {
        logI("setUserID()");
        this.mUserID = userid;
    }

    @Override // com.coolots.chaton.call.screenshare.activity.ScreenShareLayout
    public void OnRecveData(int command, byte[] data) {
        logI("OnRecveData():" + command);
        switch (command) {
            case 100:
                final MultiSettingStrokeInfo settingInfo = SettingPacket.parserSpenSettingStrokeInfo(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout3.8
                    @Override // java.lang.Runnable
                    public void run() {
                        settingInfo.spenSettingInfo.setSpenSettingInfoIntoSpenMultiView(PenWritingViewLayout3.this.mSpenMulitView, PenWritingViewLayout3.this.mSettingView, 1);
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO /* 203 */:
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout3.9
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            SpenPageDoc.HistoryUpdateInfo[] userData = PenWritingViewLayout3.this.mSpenPageDoc.undo(1);
                            PenWritingViewLayout3.this.mSpenMulitView.updateUndo(userData, 1);
                        } catch (Exception e) {
                            PenWritingViewLayout3.this.logE("mSCanvas.undo: " + e);
                        }
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO /* 204 */:
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout3.10
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            SpenPageDoc.HistoryUpdateInfo[] userData = PenWritingViewLayout3.this.mSpenPageDoc.redo(1);
                            PenWritingViewLayout3.this.mSpenMulitView.updateRedo(userData, 1);
                        } catch (Exception e) {
                            PenWritingViewLayout3.this.logE("mSCanvas.redo: " + e);
                        }
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARALL /* 205 */:
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout3.11
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            SpenPageDoc.HistoryUpdateInfo[] userDataOther = PenWritingViewLayout3.this.mSpenPageDoc.undoAll(2);
                            SpenPageDoc.HistoryUpdateInfo[] userData = PenWritingViewLayout3.this.mSpenPageDoc.undoAll(1);
                            PenWritingViewLayout3.this.mSpenMulitView.updateUndo(userDataOther, 2);
                            PenWritingViewLayout3.this.mSpenMulitView.updateUndo(userData, 1);
                            PenWritingViewLayout3.this.mSpenPageDoc.clearHistory();
                            PenWritingViewLayout3.this.updateUndoRedoBtnState();
                        } catch (Exception e) {
                            PenWritingViewLayout3.this.logE("mSCanvas.redo: " + e);
                        }
                    }
                });
                break;
            case 300:
                final PenWriteNetwork.shareSpenMotionEvent SpenMotionEvent = PenWriteNetwork.parseTransMotionEvent(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout3.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SpenMotionEvent != null) {
                            if (SpenMotionEvent.action == 0) {
                                PenWritingViewLayout3.gDownTime = SystemClock.uptimeMillis();
                            }
                            SpenMotionEvent.f8pc[0].x = PenWritingViewLayout3.this.mScreenShareActivity.mScreenScale.modifyScaleX(SpenMotionEvent.f8pc[0].x);
                            SpenMotionEvent.f8pc[0].y = PenWritingViewLayout3.this.mScreenShareActivity.mScreenScale.modifyScaleY(SpenMotionEvent.f8pc[0].y);
                            MotionEvent event = MotionEvent.obtain(PenWritingViewLayout3.gDownTime, PenWritingViewLayout3.gDownTime + SpenMotionEvent.eventtime, SpenMotionEvent.action, 1, SpenMotionEvent.f9pp, SpenMotionEvent.f8pc, SpenMotionEvent.metastate, SpenMotionEvent.buttonstate, SpenMotionEvent.xprecision, SpenMotionEvent.yprecision, SpenMotionEvent.deviceid, SpenMotionEvent.edgeflags, SpenMotionEvent.source, SpenMotionEvent.flags);
                            PenWritingViewLayout3.this.mSpenMulitView.onTouchEvent(1, event);
                        }
                    }
                });
                break;
        }
    }

    public void dissmissAlertView() throws Resources.NotFoundException {
        if (this.mClearAlertView != null) {
            this.mClearAlertView.dismiss();
            this.mClearAlertView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSendData(int command, byte[] cmdData) {
        if (this.mOnSendCommandData != null) {
            this.mOnSendCommandData.onSendData(command, cmdData);
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mSpenMulitView != null) {
            this.mSpenMulitView.setColorPickerListener(null);
            this.mSpenMulitView.setTouchListener(null);
            this.mSpenMulitView.removeCallbacks(null);
            this.mSpenMulitView = null;
        }
        if (this.mHandler != null) {
            this.mHandler = null;
        }
        if (this.mPenBtn != null) {
            this.mPenBtn.removeCallbacks(null);
            this.mPenBtn = null;
        }
        if (this.mEraserBtn != null) {
            this.mEraserBtn.removeCallbacks(null);
            this.mEraserBtn = null;
        }
        if (this.mUndoBtn != null) {
            this.mUndoBtn.removeCallbacks(null);
            this.mUndoBtn = null;
        }
        if (this.mRedoBtn != null) {
            this.mRedoBtn.removeCallbacks(null);
            this.mRedoBtn = null;
        }
        if (this.mCaptureBtn != null) {
            this.mCaptureBtn.removeCallbacks(null);
            this.mCaptureBtn = null;
        }
        if (this.mHideBtn != null) {
            this.mHideBtn.removeCallbacks(null);
            this.mHideBtn = null;
        }
        if (this.mClearAlertView != null) {
            this.mClearAlertView = null;
        }
        if (this.mClearBtn != null) {
            this.mClearBtn.removeCallbacks(null);
            this.mClearBtn = null;
        }
        if (this.mEndBtn != null) {
            this.mEndBtn.removeCallbacks(null);
            this.mEndBtn = null;
        }
        if (this.mShareViewToolbarLayout != null) {
            this.mShareViewToolbarLayout.removeAllViews();
            this.mShareViewToolbarLayout = null;
        }
        if (this.mToolbarBtnLayout != null) {
            this.mToolbarBtnLayout.removeAllViews();
            this.mToolbarBtnLayout = null;
        }
        if (this.mToolbarCaptureLayout != null) {
            this.mToolbarCaptureLayout.removeAllViews();
            this.mToolbarCaptureLayout = null;
        }
        if (this.mTransition != null) {
            this.mTransition.removeTransitionListener(null);
            this.mTransition = null;
        }
        if (this.mPenColor != null) {
            this.mPenColor.removeCallbacks(null);
            this.mPenColor = null;
        }
        if (this.mSendSettingStrokeInfo != null) {
            this.mSendSettingStrokeInfo = null;
        }
        if (this.mPenWritingCapture != null) {
            this.mPenWritingCapture = null;
        }
        if (this.mScreenShareActivity != null) {
            this.mScreenShareActivity = null;
        }
    }

    public void penToolbarResize() {
        Point disSize = new Point();
        this.mDisplay.getSize(disSize);
        this.mLayoutParams = (RelativeLayout.LayoutParams) this.mSpenMulitView.getLayoutParams();
        this.mLayoutParams.width = disSize.x;
        this.mLayoutParams.height = disSize.y;
        this.mSpenMulitView.setLayoutParams(this.mLayoutParams);
    }

    public void setPenDocsMode(boolean isPenMode) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtnState(View v) {
        this.mPenBtn.setSelected(false);
        this.mEraserBtn.setSelected(false);
        this.mClearBtn.setSelected(false);
        v.setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnHidden(boolean ishidden) {
        if (!ishidden) {
            this.mToolbarBtnLayout.setVisibility(8);
            this.mToolbarCaptureLayout.setVisibility(8);
            this.mShareViewToolbarLayout.setBackgroundColor(Color.alpha(0));
            this.mHideBtn.setImageResource(C0000R.drawable.screenshare_penwriting_toolbar_hide_selector);
            this.mHideBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.video_option_menu_show));
            this.isHidden = true;
            return;
        }
        this.mToolbarBtnLayout.setVisibility(0);
        this.mToolbarCaptureLayout.setVisibility(0);
        this.mShareViewToolbarLayout.setBackgroundResource(C0000R.drawable.share_screen_btn_bg);
        this.mHideBtn.setImageResource(C0000R.drawable.screenshare_penwriting_toolbar_show_selector);
        this.mHideBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.video_option_menu_hide));
        this.isHidden = false;
    }
}
