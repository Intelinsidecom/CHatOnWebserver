package com.coolots.chaton.call.screenshare;

import android.app.Service;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.screenshare.core.OverlayView;
import com.coolots.chaton.call.screenshare.util.AlertView;
import com.coolots.chaton.call.screenshare.util.MultiSettingStrokeInfo;
import com.coolots.chaton.call.screenshare.util.PenMenuView3;
import com.coolots.chaton.call.screenshare.util.PenWriteNetwork;
import com.coolots.chaton.call.screenshare.util.PenWritingCallBack;
import com.coolots.chaton.call.screenshare.util.PenWritingCapture;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.coolots.chaton.call.screenshare.util.ScreenShareScale;
import com.coolots.chaton.call.screenshare.util.SettingPacket;
import com.coolots.chaton.call.screenshare.util.SettingView;
import com.coolots.chaton.call.screenshare.util.SpenSettingInfo;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.SpenSettingEraserInfo;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.document.SpenNoteDoc;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.engine.SpenColorPickerListener;
import com.samsung.android.sdk.pen.engine.SpenMultiView;
import com.samsung.android.sdk.pen.engine.SpenTouchListener;
import com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class PenWritingView3 extends OverlayView implements DisposeInterface {
    private static final String CLASSNAME = "[PenWritingView3]";
    private static final int OTHERID = 2;
    private static final int SHARERID = 1;
    private static long gDownTime;
    final int INKPEN;
    private int fingerAction;
    private boolean isSpenFeatureEnabled;
    private RelativeLayout mCanvasLayout;
    private AlertView mClearAlertView;
    SpenColorPickerListener mColorPickerListener;
    private Handler mHandler;
    private SpenPageDoc.HistoryListener mHistoryListener;
    private SpenNoteDoc mNoteDoc;
    private PenMenuView3 mPenMenuView;
    private SpenTouchListener mPenTouchListener;
    private PenWritingCapture mPenWritingCapture;
    private ScreenShareScale mScreenScale;
    private SettingView mSettingView;
    private SpenMultiView mSpenMulitView;
    private SpenPageDoc mSpenPageDoc;
    private SpenSettingInfo mSpenSettingInfo;
    private int mSpenSettingMode;
    private int settingViewSize;
    private int spenAction;
    public WindowManager windowManager;

    /* JADX INFO: Access modifiers changed from: private */
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public PenWritingView3(Service service) {
        super(service, C0000R.layout.pen_writing_view3);
        this.mHandler = new Handler();
        this.windowManager = null;
        this.INKPEN = 1;
        this.isSpenFeatureEnabled = false;
        this.mColorPickerListener = new SpenColorPickerListener() { // from class: com.coolots.chaton.call.screenshare.PenWritingView3.1
            @Override // com.samsung.android.sdk.pen.engine.SpenColorPickerListener
            public void onChanged(int color, int x, int y) {
                if (PenWritingView3.this.mSettingView != null) {
                    SpenSettingPenInfo penInfo = PenWritingView3.this.mSettingView.getSpenPenInfo();
                    penInfo.color = color;
                    PenWritingView3.this.mSettingView.setSpenPenInfo(penInfo);
                }
            }
        };
        this.mHistoryListener = new SpenPageDoc.HistoryListener() { // from class: com.coolots.chaton.call.screenshare.PenWritingView3.2
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
        this.mPenTouchListener = new SpenTouchListener() { // from class: com.coolots.chaton.call.screenshare.PenWritingView3.3
            @Override // com.samsung.android.sdk.pen.engine.SpenTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if (PenWritingView3.this.mSpenMulitView != null) {
                    if (event.getAction() == 0) {
                        SpenSettingInfo spensettinginfo = new SpenSettingInfo(PenWritingView3.this.mSpenSettingMode, PenWritingView3.this.mSpenMulitView, 1);
                        byte[] cmdData = SettingPacket.makeSettingStrokeInfo(1, spensettinginfo);
                        if (PenWritingView3.this.mSpenSettingInfo == null || !SettingPacket.equalsSettingInfo(PenWritingView3.this.mSpenSettingInfo, spensettinginfo)) {
                            PenWritingView3.this.mSpenSettingInfo = SettingPacket.copySettingInfo(PenWritingView3.this.mSpenSettingMode, spensettinginfo);
                            PenWritingView3.this.onSendData(100, cmdData);
                        }
                    }
                    if (PenWritingView3.this.mOnSendCommandData != null) {
                        float rawX = PenWritingView3.this.mScreenScale.modifyExpandScaleX(event.getX(event.getPointerCount() - 1));
                        float rawY = PenWritingView3.this.mScreenScale.modifyExpandScaleY(event.getY(event.getPointerCount() - 1));
                        MotionEvent.PointerProperties[] pp = {new MotionEvent.PointerProperties()};
                        pp[0].toolType = event.getToolType(0);
                        pp[0].id = 0;
                        MotionEvent.PointerCoords[] pc = {new MotionEvent.PointerCoords()};
                        pc[0].x = rawX;
                        pc[0].y = rawY;
                        MotionEvent mEvent = MotionEvent.obtain(event.getDownTime(), event.getDownTime() + (event.getEventTime() - event.getDownTime()), event.getAction(), 1, pp, pc, event.getMetaState(), event.getButtonState(), event.getXPrecision(), event.getYPrecision(), event.getDeviceId(), event.getEdgeFlags(), event.getSource(), event.getFlags());
                        byte[] cmdData2 = PenWriteNetwork.makeSpenMotionEvent(1, 0, mEvent);
                        if (PenWritingView3.this.mSpenSettingMode != 3) {
                            PenWritingView3.this.logI("YKYU sendTouchEvent() -4-");
                            PenWritingView3.this.onSendData(300, cmdData2);
                        }
                    }
                    PenWritingView3.this.updateUndoRedoBtnState();
                    PenWritingView3.this.mSpenMulitView.invalidate();
                    return false;
                }
                return false;
            }
        };
        this.mSpenSettingMode = 1;
        initScaleData();
        load();
        initPenMenuView(service);
    }

    private void initPenMenuView(Service service) {
        this.mPenMenuView = new PenMenuView3(service);
        this.mPenMenuView.setCallback(new PenWritingCallBack() { // from class: com.coolots.chaton.call.screenshare.PenWritingView3.4
            @Override // com.coolots.chaton.call.screenshare.util.PenWritingCallBack
            public void undoNredoClicked(boolean isUndo) {
                PenWritingView3.this.logI("undoNredoBtnClickListener()");
                if (isUndo) {
                    SpenPageDoc.HistoryUpdateInfo[] userData = PenWritingView3.this.mSpenPageDoc.undo(1);
                    PenWritingView3.this.mSpenMulitView.updateUndo(userData, 1);
                    PenWritingView3.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO, null);
                } else {
                    SpenPageDoc.HistoryUpdateInfo[] userData2 = PenWritingView3.this.mSpenPageDoc.redo(1);
                    PenWritingView3.this.mSpenMulitView.updateRedo(userData2, 1);
                    PenWritingView3.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO, null);
                }
                PenWritingView3.this.updateUndoRedoBtnState();
            }

            @Override // com.coolots.chaton.call.screenshare.util.PenWritingCallBack
            public void btnClicked(View v) {
                if (PenWritingView3.this.mSpenMulitView.getToolTypeAction(2) == 5) {
                    PenWritingView3.this.mSettingView.closeSettingView();
                }
                int viewId = v.getId();
                if (viewId == C0000R.id.end_btn) {
                    ScreenShareProc.setPenWriting(false);
                    PenWritingView3.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_SHARE_MODE, null);
                    return;
                }
                if (viewId == C0000R.id.showhide_btn) {
                    PenWritingView3.this.mPenMenuView.btnHidden();
                    PenWritingView3.this.mSettingView.closeSettingView();
                    return;
                }
                if (viewId == C0000R.id.camera_btn) {
                    PenWritingView3.this.mPenWritingCapture.ScreenCapture();
                    return;
                }
                if (viewId != C0000R.id.eraser_btn) {
                    if (viewId == C0000R.id.clear_btn) {
                        PenWritingView3.this.mSpenSettingMode = 3;
                        PenWritingView3.this.fingerAction = 7;
                        if (PenWritingView3.this.spenAction != 7) {
                            PenWritingView3.this.mSettingView.closeSettingView();
                        } else {
                            PenWritingView3.this.mSettingView.toggleShowSettingView(PenWritingView3.this.mSpenSettingMode, PenWritingView3.this.settingViewSize);
                        }
                        PenWritingView3.this.spenAction = 7;
                        PenWritingView3.this.settingViewSize = 0;
                    } else {
                        PenWritingView3.this.mSpenSettingMode = 1;
                        PenWritingView3.this.fingerAction = 2;
                        if (PenWritingView3.this.spenAction != 2) {
                            PenWritingView3.this.mSettingView.closeSettingView();
                        } else {
                            PenWritingView3.this.mSettingView.toggleShowSettingView(PenWritingView3.this.mSpenSettingMode, PenWritingView3.this.settingViewSize);
                        }
                        PenWritingView3.this.spenAction = 2;
                        PenWritingView3.this.settingViewSize = 2;
                    }
                } else {
                    PenWritingView3.this.mSpenSettingMode = 2;
                    PenWritingView3.this.fingerAction = 3;
                    if (PenWritingView3.this.spenAction != 3) {
                        PenWritingView3.this.mSettingView.closeSettingView();
                    } else {
                        PenWritingView3.this.mSettingView.toggleShowSettingView(PenWritingView3.this.mSpenSettingMode, PenWritingView3.this.settingViewSize);
                    }
                    PenWritingView3.this.spenAction = 3;
                    PenWritingView3.this.settingViewSize = 0;
                }
                if (PenWritingView3.this.mSpenMulitView.getToolTypeAction(2) != PenWritingView3.this.spenAction) {
                    PenWritingView3.this.mSpenMulitView.setToolTypeAction(1, PenWritingView3.this.fingerAction);
                    PenWritingView3.this.mSpenMulitView.setToolTypeAction(2, PenWritingView3.this.spenAction);
                }
                PenWritingView3.this.mPenMenuView.updateBtnState(v);
                PenWritingView3.this.updateUndoRedoBtnState();
            }
        });
    }

    private void initScaleData() {
        if (this.mScreenScale == null) {
            this.mScreenScale = ScreenShareScale.getInstance();
        }
        this.mScreenScale.initScaleData();
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void setupLayoutParams() {
        logI("setupLayoutParams()");
        this.layoutParams = new WindowManager.LayoutParams(-1, -1, 2021, 65792, -3);
        this.layoutParams.gravity = 51;
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void onInflateView() {
        logI("onInflateView()");
        this.mContext = getService().getApplicationContext();
        this.mPenWritingCapture = new PenWritingCapture();
        initSpen();
        initCanvas();
        initPage();
        initSettingView();
        initSettingInfo();
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

    private void stopScreenShare() {
        logI("stopScreenShare()");
        MainApplication.mPhoneManager.getShareScreenManager().stopShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination());
        ScreenShareProc.stopScreenShare();
    }

    private void initCanvas() {
        this.mCanvasLayout = (RelativeLayout) findViewById(C0000R.id.draw_canvas);
        try {
            this.mSpenMulitView = new SpenMultiView(this.mContext);
            this.mSpenMulitView.setLocalUserId(1);
            this.mSpenMulitView.addUser(2);
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
            this.mSpenPageDoc = this.mNoteDoc.appendPage();
            this.mSpenPageDoc.setBackgroundColor(0);
            this.mSpenPageDoc.setBackgroundImageMode(2);
            this.mSpenPageDoc.clearHistory();
            setRegisterListener();
            this.mSpenPageDoc.setHistoryManagerMode(1);
            this.mSpenMulitView.setPageDoc(this.mSpenPageDoc, true);
        } catch (Exception e) {
            e.printStackTrace();
            stopScreenShare();
        } catch (UnsatisfiedLinkError error) {
            error.printStackTrace();
            stopScreenShare();
        }
    }

    private void setRegisterListener() {
        this.mSpenMulitView.setColorPickerListener(this.mColorPickerListener);
        this.mSpenPageDoc.setHistoryListener(this.mHistoryListener);
        this.mSpenMulitView.setTouchListener(this.mPenTouchListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUndoRedoBtnState() {
        this.mPenMenuView.mRedoBtn.setEnabled(this.mSpenPageDoc.isRedoable(1));
        this.mPenMenuView.mUndoBtn.setEnabled(this.mSpenPageDoc.isUndoable(1));
    }

    private void initSettingView() {
        FrameLayout settingViewParent = (FrameLayout) findViewById(C0000R.id.canvas_container);
        this.mSettingView = new SettingView(this.mContext, this.mCanvasLayout);
        this.mSettingView.setCanvasView(this.mSpenMulitView);
        settingViewParent.addView(this.mSettingView);
    }

    private void initSettingInfo() {
        SpenSettingPenInfo penInfo = this.mSpenMulitView.getPenSettingInfo(1);
        penInfo.color = -15527149;
        penInfo.size = 20.0f;
        this.mSpenMulitView.setPenSettingInfo(1, penInfo);
        this.mSettingView.setSpenPenInfo(penInfo);
        SpenSettingEraserInfo eraserInfo = this.mSpenMulitView.getEraserSettingInfo(1);
        eraserInfo.size = 20.0f;
        this.mSpenMulitView.setEraserSettingInfo(1, eraserInfo);
        this.mSettingView.setEraserInfo(eraserInfo);
        this.mSettingView.setEraserListener(new SpenSettingEraserLayout.EventListener() { // from class: com.coolots.chaton.call.screenshare.PenWritingView3.5
            @Override // com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.EventListener
            public void onClearAll() throws Resources.NotFoundException {
                PenWritingView3.this.mClearAlertView = new AlertView(ScreenSharePopupMenu.mParent);
                PenWritingView3.this.mClearAlertView.setTitle(C0000R.string.screenshare_alertView_attention_title);
                PenWritingView3.this.mClearAlertView.setMessage(C0000R.string.screenshare_alertView_attention_message);
                PenWritingView3.this.mClearAlertView.setPositiveButton(C0000R.string.ok, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.PenWritingView3.5.1
                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                    public void onClick(AlertView dialog, int which) {
                        SpenPageDoc.HistoryUpdateInfo[] userDataOther = PenWritingView3.this.mSpenPageDoc.undoAll(2);
                        SpenPageDoc.HistoryUpdateInfo[] userData = PenWritingView3.this.mSpenPageDoc.undoAll(1);
                        PenWritingView3.this.mSpenMulitView.updateUndo(userDataOther, 2);
                        PenWritingView3.this.mSpenMulitView.updateUndo(userData, 1);
                        PenWritingView3.this.mSpenPageDoc.clearHistory();
                        PenWritingView3.this.updateUndoRedoBtnState();
                        SpenSettingEraserLayout layout = PenWritingView3.this.mSettingView.getSpenSettingEraserLayout();
                        layout.setVisibility(8);
                        PenWritingView3.this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARALL, null);
                    }
                });
                PenWritingView3.this.mClearAlertView.setNegativeButton(C0000R.string.cancel, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.PenWritingView3.5.2
                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                    public void onClick(AlertView dialog, int which) {
                    }
                });
                PenWritingView3.this.mClearAlertView.setCancelable(true);
                PenWritingView3.this.mClearAlertView.show();
            }
        });
        this.mSpenMulitView.setToolTypeAction(1, this.mSpenMulitView.getToolTypeAction(2));
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    public void SetOnSendCommandData(OverlayView.OnSendCommandData onSendCmd) {
        super.SetOnSendCommandData(onSendCmd);
        if (this.mPenMenuView != null) {
            this.mPenMenuView.SetOnSendCommandData(onSendCmd);
        }
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    public void show() {
        super.show();
        if (this.mPenMenuView != null) {
            this.mPenMenuView.show();
        }
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    public void dismiss() {
        super.dismiss();
        if (this.mPenMenuView != null) {
            this.mPenMenuView.dismiss();
        }
    }

    public void setUserID(int userid) {
        logI("setUserID()");
        this.mUserId = userid;
        if (this.mPenMenuView != null) {
            this.mPenMenuView.setUserID(userid);
        }
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    public void OnRecveData(int command, byte[] data) {
        logI("OnRecveData():" + command);
        switch (command) {
            case 100:
                final MultiSettingStrokeInfo settingInfo = SettingPacket.parserSpenSettingStrokeInfo(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.PenWritingView3.7
                    @Override // java.lang.Runnable
                    public void run() {
                        settingInfo.spenSettingInfo.setSpenSettingInfoIntoSpenMultiView(PenWritingView3.this.mSpenMulitView, PenWritingView3.this.mSettingView, 2);
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO /* 203 */:
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.PenWritingView3.8
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            SpenPageDoc.HistoryUpdateInfo[] userData = PenWritingView3.this.mSpenPageDoc.undo(2);
                            PenWritingView3.this.mSpenMulitView.updateUndo(userData, 2);
                        } catch (Exception e) {
                            PenWritingView3.this.logE("mSCanvas.undo: " + e);
                        }
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO /* 204 */:
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.PenWritingView3.9
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            SpenPageDoc.HistoryUpdateInfo[] userData = PenWritingView3.this.mSpenPageDoc.redo(2);
                            PenWritingView3.this.mSpenMulitView.updateRedo(userData, 2);
                        } catch (Exception e) {
                            PenWritingView3.this.logE("mSCanvas.redo: " + e);
                        }
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARALL /* 205 */:
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.PenWritingView3.10
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            SpenPageDoc.HistoryUpdateInfo[] userDataOther = PenWritingView3.this.mSpenPageDoc.undoAll(2);
                            SpenPageDoc.HistoryUpdateInfo[] userData = PenWritingView3.this.mSpenPageDoc.undoAll(1);
                            PenWritingView3.this.mSpenMulitView.updateUndo(userDataOther, 2);
                            PenWritingView3.this.mSpenMulitView.updateUndo(userData, 1);
                            PenWritingView3.this.mSpenPageDoc.clearHistory();
                            PenWritingView3.this.updateUndoRedoBtnState();
                        } catch (Exception e) {
                            PenWritingView3.this.logE("mSCanvas.redo: " + e);
                        }
                    }
                });
                break;
            case 300:
                final PenWriteNetwork.shareSpenMotionEvent SpenMotionEvent = PenWriteNetwork.parseTransMotionEvent(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.PenWritingView3.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SpenMotionEvent != null) {
                            if (SpenMotionEvent.action == 0) {
                                PenWritingView3.gDownTime = SystemClock.uptimeMillis();
                            }
                            SpenMotionEvent.f8pc[0].x = PenWritingView3.this.mScreenScale.modifyScaleX(SpenMotionEvent.f8pc[0].x);
                            SpenMotionEvent.f8pc[0].y = PenWritingView3.this.mScreenScale.modifyScaleY(SpenMotionEvent.f8pc[0].y);
                            MotionEvent event = MotionEvent.obtain(PenWritingView3.gDownTime, PenWritingView3.gDownTime + SpenMotionEvent.eventtime, SpenMotionEvent.action, 1, SpenMotionEvent.f9pp, SpenMotionEvent.f8pc, SpenMotionEvent.metastate, SpenMotionEvent.buttonstate, SpenMotionEvent.xprecision, SpenMotionEvent.yprecision, SpenMotionEvent.deviceid, SpenMotionEvent.edgeflags, SpenMotionEvent.source, SpenMotionEvent.flags);
                            PenWritingView3.this.mSpenMulitView.onTouchEvent(2, event);
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

    @Override // android.view.View
    protected void onSizeChanged(int width, int height, int oldWidth, int odHeight) {
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
        if (this.mPenMenuView != null) {
            this.mPenMenuView.dismiss();
            this.mPenMenuView.dispose();
            this.mPenMenuView.destory();
            this.mPenMenuView = null;
        }
        if (this.mHandler != null) {
            this.mHandler = null;
        }
        if (this.mClearAlertView != null) {
            this.mClearAlertView = null;
        }
        if (this.mPenWritingCapture != null) {
            this.mPenWritingCapture = null;
        }
        if (this.mScreenScale != null) {
            this.mScreenScale = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == 4 && event.getAction() == 1) {
            logI("dispatchKeyEvent KeyEvent.KEYCODE_BACK & KeyEvent.ACTION_UP Clicked ");
            ScreenShareProc.setPenWriting(false);
            onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_SHARE_MODE, null);
        }
        return super.dispatchKeyEvent(event);
    }
}
