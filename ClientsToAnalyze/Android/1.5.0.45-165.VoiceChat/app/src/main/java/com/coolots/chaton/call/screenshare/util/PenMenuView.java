package com.coolots.chaton.call.screenshare.util;

import android.app.Service;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.screenshare.ScreenShareProc;
import com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout;
import com.coolots.chaton.call.screenshare.core.OverlayView;
import com.samsung.spensdk.SCanvasView;
import com.samsung.spensdk.applistener.SettingPresetDeleteBtnClickListener;
import com.samsung.spensdk.applistener.SettingViewShowListener;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.HashMap;

/* loaded from: classes.dex */
public class PenMenuView extends OverlayView implements DisposeInterface {
    private static final String CLASSNAME = "[PenMenuView]";
    private boolean isHidden;
    private View.OnClickListener mBtnClickListener;
    private ImageView mCaptureBtn;
    public ImageView mClearBtn;
    private float mDensity;
    private Button mEndBtn;
    public ImageView mEraserBtn;
    private ImageView mHideBtn;
    boolean mIsConference;
    public ImageView mPenBtn;
    public RelativeLayout mPenBtnLayout;
    public View mPenColor;
    public PenWritingCapture mPenWritingCapture;
    public ImageView mRedoBtn;
    private SCanvasView mSCanvas;
    private ScreenShareScale mScreenScale;
    private FrameLayout mSettingViewContainer;
    public RelativeLayout mToolBarLayout;
    private LinearLayout mToolbarBtnLayout;
    private LinearLayout mToolbarCaptureLayout;
    public ImageView mUndoBtn;
    private View.OnClickListener undoNredoBtnClickListener;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public PenMenuView(Service service) {
        super(service, C0000R.layout.screenshare_pen_menu);
        this.isHidden = false;
        this.mIsConference = false;
        this.mBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.util.PenMenuView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PenMenuView.this.logI("mBtnClickListener()");
                int nBtnID = v.getId();
                if (nBtnID == PenMenuView.this.mPenBtn.getId()) {
                    if (PenMenuView.this.mSCanvas.getCanvasMode() == 10) {
                        PenMenuView.this.mSCanvas.setSettingViewSizeOption(1, 2);
                        PenMenuView.this.mSCanvas.toggleShowSettingView(1);
                        return;
                    } else {
                        PenMenuView.this.mSCanvas.setCanvasMode(10);
                        PenMenuView.this.mSCanvas.showSettingView(1, false);
                        PenMenuView.this.updateModeState();
                        return;
                    }
                }
                if (nBtnID == PenMenuView.this.mEraserBtn.getId()) {
                    if (PenMenuView.this.mSCanvas.getCanvasMode() == 11) {
                        PenMenuView.this.mSCanvas.setSettingViewSizeOption(2, 0);
                        PenMenuView.this.mSCanvas.toggleShowSettingView(2);
                        return;
                    } else {
                        PenMenuView.this.mSCanvas.setCanvasMode(11);
                        PenMenuView.this.mSCanvas.showSettingView(2, false);
                        PenMenuView.this.updateModeState();
                        return;
                    }
                }
                if (nBtnID == PenMenuView.this.mClearBtn.getId()) {
                    if (PenMenuView.this.mSCanvas.getCanvasMode() == 12) {
                        PenMenuView.this.mSCanvas.setSettingViewSizeOption(3, 1);
                        PenMenuView.this.mSCanvas.toggleShowSettingView(3);
                        return;
                    } else {
                        PenMenuView.this.mSCanvas.setCanvasMode(12);
                        PenMenuView.this.mSCanvas.showSettingView(3, false);
                        PenMenuView.this.updateModeState();
                        return;
                    }
                }
                if (nBtnID == PenMenuView.this.mEndBtn.getId()) {
                    PenMenuView.this.logI("PenWriting EndBtn Clicked ");
                    ScreenShareProc.setPenWriting(false);
                    PenMenuView.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_SHARE_MODE, null);
                    return;
                }
                if (nBtnID == PenMenuView.this.mCaptureBtn.getId()) {
                    PenMenuView.this.logI("PenWritingCapture is Clicked!!");
                    PenMenuView.this.mPenWritingCapture.ScreenCapture();
                    return;
                }
                if (nBtnID == PenMenuView.this.mHideBtn.getId()) {
                    PenMenuView.this.logI("PenWriting Toolbar is show/Hide");
                    PenMenuView.this.btnHidden(PenMenuView.this.isHidden);
                    if (PenMenuView.this.mSCanvas.getCanvasMode() == 10) {
                        PenMenuView.this.mSCanvas.setCanvasMode(10);
                        PenMenuView.this.mSCanvas.showSettingView(1, false);
                    } else if (PenMenuView.this.mSCanvas.getCanvasMode() == 11) {
                        PenMenuView.this.mSCanvas.setCanvasMode(11);
                        PenMenuView.this.mSCanvas.showSettingView(2, false);
                    } else if (PenMenuView.this.mSCanvas.getCanvasMode() == 12) {
                        PenMenuView.this.mSCanvas.setCanvasMode(12);
                        PenMenuView.this.mSCanvas.showSettingView(3, false);
                    }
                }
            }
        };
        this.undoNredoBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.util.PenMenuView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PenMenuView.this.logI("undoNredoBtnClickListener()");
                int nBtnID = v.getId();
                byte[] cmdData = PenWriteNetwork.intToByte(PenMenuView.this.mUserId);
                if (nBtnID == PenMenuView.this.mUndoBtn.getId()) {
                    PenMenuView.this.mSCanvas.undo();
                    PenMenuView.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO, cmdData);
                } else if (nBtnID == PenMenuView.this.mRedoBtn.getId()) {
                    PenMenuView.this.mSCanvas.redo();
                    PenMenuView.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO, cmdData);
                }
                PenMenuView.this.mUndoBtn.setEnabled(PenMenuView.this.mSCanvas.isUndoable());
                PenMenuView.this.mRedoBtn.setEnabled(PenMenuView.this.mSCanvas.isRedoable());
            }
        };
        Destination destination = MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination();
        if (destination != null && destination.getDestinationType() == 4) {
            this.mIsConference = true;
        }
        DisplayMetrics outMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(outMetrics);
        this.mDensity = outMetrics.density;
        load();
    }

    public PenMenuView(Service service, int layoutResId) {
        super(service, layoutResId);
        this.isHidden = false;
        this.mIsConference = false;
        this.mBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.util.PenMenuView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PenMenuView.this.logI("mBtnClickListener()");
                int nBtnID = v.getId();
                if (nBtnID == PenMenuView.this.mPenBtn.getId()) {
                    if (PenMenuView.this.mSCanvas.getCanvasMode() == 10) {
                        PenMenuView.this.mSCanvas.setSettingViewSizeOption(1, 2);
                        PenMenuView.this.mSCanvas.toggleShowSettingView(1);
                        return;
                    } else {
                        PenMenuView.this.mSCanvas.setCanvasMode(10);
                        PenMenuView.this.mSCanvas.showSettingView(1, false);
                        PenMenuView.this.updateModeState();
                        return;
                    }
                }
                if (nBtnID == PenMenuView.this.mEraserBtn.getId()) {
                    if (PenMenuView.this.mSCanvas.getCanvasMode() == 11) {
                        PenMenuView.this.mSCanvas.setSettingViewSizeOption(2, 0);
                        PenMenuView.this.mSCanvas.toggleShowSettingView(2);
                        return;
                    } else {
                        PenMenuView.this.mSCanvas.setCanvasMode(11);
                        PenMenuView.this.mSCanvas.showSettingView(2, false);
                        PenMenuView.this.updateModeState();
                        return;
                    }
                }
                if (nBtnID == PenMenuView.this.mClearBtn.getId()) {
                    if (PenMenuView.this.mSCanvas.getCanvasMode() == 12) {
                        PenMenuView.this.mSCanvas.setSettingViewSizeOption(3, 1);
                        PenMenuView.this.mSCanvas.toggleShowSettingView(3);
                        return;
                    } else {
                        PenMenuView.this.mSCanvas.setCanvasMode(12);
                        PenMenuView.this.mSCanvas.showSettingView(3, false);
                        PenMenuView.this.updateModeState();
                        return;
                    }
                }
                if (nBtnID == PenMenuView.this.mEndBtn.getId()) {
                    PenMenuView.this.logI("PenWriting EndBtn Clicked ");
                    ScreenShareProc.setPenWriting(false);
                    PenMenuView.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_SHARE_MODE, null);
                    return;
                }
                if (nBtnID == PenMenuView.this.mCaptureBtn.getId()) {
                    PenMenuView.this.logI("PenWritingCapture is Clicked!!");
                    PenMenuView.this.mPenWritingCapture.ScreenCapture();
                    return;
                }
                if (nBtnID == PenMenuView.this.mHideBtn.getId()) {
                    PenMenuView.this.logI("PenWriting Toolbar is show/Hide");
                    PenMenuView.this.btnHidden(PenMenuView.this.isHidden);
                    if (PenMenuView.this.mSCanvas.getCanvasMode() == 10) {
                        PenMenuView.this.mSCanvas.setCanvasMode(10);
                        PenMenuView.this.mSCanvas.showSettingView(1, false);
                    } else if (PenMenuView.this.mSCanvas.getCanvasMode() == 11) {
                        PenMenuView.this.mSCanvas.setCanvasMode(11);
                        PenMenuView.this.mSCanvas.showSettingView(2, false);
                    } else if (PenMenuView.this.mSCanvas.getCanvasMode() == 12) {
                        PenMenuView.this.mSCanvas.setCanvasMode(12);
                        PenMenuView.this.mSCanvas.showSettingView(3, false);
                    }
                }
            }
        };
        this.undoNredoBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.util.PenMenuView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PenMenuView.this.logI("undoNredoBtnClickListener()");
                int nBtnID = v.getId();
                byte[] cmdData = PenWriteNetwork.intToByte(PenMenuView.this.mUserId);
                if (nBtnID == PenMenuView.this.mUndoBtn.getId()) {
                    PenMenuView.this.mSCanvas.undo();
                    PenMenuView.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO, cmdData);
                } else if (nBtnID == PenMenuView.this.mRedoBtn.getId()) {
                    PenMenuView.this.mSCanvas.redo();
                    PenMenuView.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO, cmdData);
                }
                PenMenuView.this.mUndoBtn.setEnabled(PenMenuView.this.mSCanvas.isUndoable());
                PenMenuView.this.mRedoBtn.setEnabled(PenMenuView.this.mSCanvas.isRedoable());
            }
        };
        Destination destination = MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination();
        if (destination != null && destination.getDestinationType() == 4) {
            this.mIsConference = true;
        }
        DisplayMetrics outMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(outMetrics);
        this.mDensity = outMetrics.density;
        load();
    }

    public void setSCanvasView(SCanvasView canvasView) {
        this.mSCanvas = canvasView;
        if (this.mIsConference) {
            this.mSettingViewContainer = (FrameLayout) findViewById(C0000R.id.draw_canvas);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) this.mSettingViewContainer.getLayoutParams();
            params.topMargin = (int) (50.0f * this.mDensity);
            this.mSettingViewContainer.setLayoutParams(params);
            logI("Resource Map for Layout & Locale");
            HashMap<String, Integer> settingResourceMapInt = SPenSDKUtils.getSettingLayoutLocaleResourceMap(true, true, false, false);
            logI("Resource Map for Custom font path");
            HashMap<String, String> settingResourceMapString = SPenSDKUtils.getSettingLayoutStringResourceMap(true, true, false, false);
            logI("createSettingView");
            this.mSCanvas.createSettingView(this.mSettingViewContainer, settingResourceMapInt, settingResourceMapString);
            this.mSCanvas.setSettingViewShowListener(new SettingViewShowListener() { // from class: com.coolots.chaton.call.screenshare.util.PenMenuView.3
                @Override // com.samsung.spensdk.applistener.SettingViewShowListener
                public void onEraserSettingViewShow(boolean arg0) {
                    if (!PenMenuView.this.mSCanvas.isSettingViewVisible(2)) {
                        PenMenuView.this.mSettingViewContainer.setVisibility(8);
                        return;
                    }
                    RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) PenMenuView.this.mSettingViewContainer.getLayoutParams();
                    params2.height = (int) (143.0f * PenMenuView.this.mDensity);
                    PenMenuView.this.mSettingViewContainer.setLayoutParams(params2);
                    PenMenuView.this.mSettingViewContainer.setVisibility(0);
                }

                @Override // com.samsung.spensdk.applistener.SettingViewShowListener
                public void onFillingSettingViewShow(boolean arg0) {
                    if (!PenMenuView.this.mSCanvas.isSettingViewVisible(4)) {
                        PenMenuView.this.mSettingViewContainer.setVisibility(8);
                    } else {
                        PenMenuView.this.mSettingViewContainer.setVisibility(0);
                    }
                }

                @Override // com.samsung.spensdk.applistener.SettingViewShowListener
                public void onPenSettingViewShow(boolean arg0) {
                    if (!PenMenuView.this.mSCanvas.isSettingViewVisible(1)) {
                        PenMenuView.this.mSettingViewContainer.setVisibility(8);
                        return;
                    }
                    RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) PenMenuView.this.mSettingViewContainer.getLayoutParams();
                    params2.height = -2;
                    PenMenuView.this.mSettingViewContainer.setLayoutParams(params2);
                    PenMenuView.this.mSettingViewContainer.setVisibility(0);
                }

                @Override // com.samsung.spensdk.applistener.SettingViewShowListener
                public void onTextSettingViewShow(boolean arg0) {
                    if (!PenMenuView.this.mSCanvas.isSettingViewVisible(3)) {
                        PenMenuView.this.mSettingViewContainer.setVisibility(8);
                        return;
                    }
                    RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) PenMenuView.this.mSettingViewContainer.getLayoutParams();
                    params2.height = (int) (143.0f * PenMenuView.this.mDensity);
                    PenMenuView.this.mSettingViewContainer.setLayoutParams(params2);
                    PenMenuView.this.mSettingViewContainer.setVisibility(0);
                }
            });
        }
        this.mSCanvas.setSettingPresetDeleteBtnClickListener(new SettingPresetDeleteBtnClickListener() { // from class: com.coolots.chaton.call.screenshare.util.PenMenuView.4
            @Override // com.samsung.spensdk.applistener.SettingPresetDeleteBtnClickListener
            public void onClick(int nPresetIndex) {
                PenMenuView.this.mSCanvas.deleteSettingViewPresetInfo(nPresetIndex, false);
            }
        });
    }

    public void setParent(PenWritingViewLayout parent) {
        this.mParent = parent;
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void setupLayoutParams() {
        logI("setupLayoutParams()");
        this.layoutParams = new WindowManager.LayoutParams(-1, -2, 2021, 262440, -3);
        this.layoutParams.gravity = 51;
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void onInflateView() {
        logI("onInflateView()");
        this.mContext = getService().getApplicationContext();
        this.mPenBtn = (ImageView) findViewById(C0000R.id.pen_btn);
        this.mEraserBtn = (ImageView) findViewById(C0000R.id.eraser_btn);
        this.mUndoBtn = (ImageView) findViewById(C0000R.id.undo_btn);
        this.mRedoBtn = (ImageView) findViewById(C0000R.id.redo_btn);
        this.mCaptureBtn = (ImageView) findViewById(C0000R.id.camera_btn);
        this.mClearBtn = (ImageView) findViewById(C0000R.id.clear_btn);
        this.mEndBtn = (Button) findViewById(C0000R.id.end_btn);
        this.mHideBtn = (ImageView) findViewById(C0000R.id.showhide_btn);
        this.mToolBarLayout = (RelativeLayout) findViewById(C0000R.id.pen_menu_view);
        this.mPenBtnLayout = (RelativeLayout) findViewById(C0000R.id.pen_btn_layout);
        this.mPenBtn.setOnClickListener(this.mBtnClickListener);
        this.mEraserBtn.setOnClickListener(this.mBtnClickListener);
        this.mCaptureBtn.setOnClickListener(this.mBtnClickListener);
        this.mClearBtn.setOnClickListener(this.mBtnClickListener);
        this.mEndBtn.setOnClickListener(this.mBtnClickListener);
        this.mHideBtn.setOnClickListener(this.mBtnClickListener);
        this.mUndoBtn.setOnClickListener(this.undoNredoBtnClickListener);
        this.mRedoBtn.setOnClickListener(this.undoNredoBtnClickListener);
        this.mToolbarBtnLayout = (LinearLayout) findViewById(C0000R.id.share_view_toolbar_layout);
        this.mToolbarCaptureLayout = (LinearLayout) findViewById(C0000R.id.camera_btn_layout);
        this.mPenColor = findViewById(C0000R.id.pen_color_bar);
        this.mUndoBtn.setEnabled(false);
        this.mRedoBtn.setEnabled(false);
        this.mPenBtn.setSelected(true);
        this.mPenWritingCapture = new PenWritingCapture();
        btnHidden(true);
    }

    public void updateModeState() {
        logI("updateModeState()");
        int nCurMode = this.mSCanvas.getCanvasMode();
        this.mPenBtn.setSelected(nCurMode == 10);
        this.mEraserBtn.setSelected(nCurMode == 11);
        this.mClearBtn.setSelected(nCurMode == 12);
    }

    public void btnHidden(boolean ishidden) {
        if (!ishidden) {
            this.mToolbarBtnLayout.setVisibility(8);
            this.mToolbarCaptureLayout.setVisibility(8);
            this.mHideBtn.setImageResource(C0000R.drawable.screenshare_penwriting_toolbar_hide_selector);
            this.mHideBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.video_option_menu_show));
            this.isHidden = true;
            return;
        }
        this.mToolbarBtnLayout.setVisibility(0);
        this.mToolbarCaptureLayout.setVisibility(0);
        this.mHideBtn.setImageResource(C0000R.drawable.screenshare_penwriting_toolbar_show_selector);
        this.mHideBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.video_option_menu_hide));
        this.isHidden = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSendData(int command, byte[] cmdData) {
        if (this.mOnSendCommandData != null) {
            this.mOnSendCommandData.onSendData(command, cmdData);
        }
    }

    public void setUserID(int userid) {
        this.mUserId = userid;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mToolBarLayout != null) {
            this.mToolBarLayout = null;
        }
        if (this.mPenBtnLayout != null) {
            this.mPenBtnLayout = null;
        }
        if (this.mToolbarBtnLayout != null) {
            this.mToolbarBtnLayout = null;
        }
        if (this.mToolbarCaptureLayout != null) {
            this.mToolbarCaptureLayout = null;
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
        if (this.mClearBtn != null) {
            this.mClearBtn.removeCallbacks(null);
            this.mClearBtn = null;
        }
        if (this.mEndBtn != null) {
            this.mEndBtn.removeCallbacks(null);
            this.mEndBtn = null;
        }
        if (this.mHideBtn != null) {
            this.mHideBtn.removeCallbacks(null);
            this.mHideBtn = null;
        }
        if (this.mPenColor != null) {
            this.mPenColor.removeCallbacks(null);
            this.mPenColor = null;
        }
        if (this.mPenWritingCapture != null) {
            this.mPenWritingCapture = null;
        }
        if (this.mScreenScale != null) {
            this.mScreenScale = null;
        }
    }
}
