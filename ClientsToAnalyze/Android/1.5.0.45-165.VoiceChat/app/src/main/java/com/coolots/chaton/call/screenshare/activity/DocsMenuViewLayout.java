package com.coolots.chaton.call.screenshare.activity;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
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
import com.coolots.chaton.call.screenshare.util.BoardData;
import com.coolots.chaton.call.screenshare.util.BoardDataController;
import com.coolots.chaton.call.screenshare.util.MultiSettingStrokeInfo;
import com.coolots.chaton.call.screenshare.util.PenWriteNetwork;
import com.coolots.chaton.call.screenshare.util.PenWritingCapture;
import com.coolots.chaton.call.screenshare.util.SPenSDKUtils;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.coolots.chaton.call.screenshare.util.SettingPacket;
import com.samsung.samm.common.SObject;
import com.samsung.samm.common.SObjectStroke;
import com.samsung.samm.common.SObjectText;
import com.samsung.sdraw.CanvasView;
import com.samsung.spen.settings.SettingStrokeInfo;
import com.samsung.spensdk.SCanvasView;
import com.samsung.spensdk.applistener.HistoryUpdateListener;
import com.samsung.spensdk.applistener.SCanvasDeleteAllConfirmListener;
import com.samsung.spensdk.applistener.SCanvasInitializeListener;
import com.samsung.spensdk.applistener.SCanvasModeChangedListener;
import com.samsung.spensdk.applistener.SObjectUpdateListener;
import com.samsung.spensdk.applistener.SPenTouchIDListener;
import com.samsung.spensdk.applistener.SettingPresetDeleteBtnClickListener;
import com.samsung.spensdk.applistener.SettingStrokeChangeListener;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class DocsMenuViewLayout extends ScreenShareLayout implements DisposeInterface {
    private static final String CLASSNAME = "[DocsMenuViewLayout]";
    private static long gDownTime;
    private static int mCurrentPage = 0;
    private final int DRAG;
    private final int MULTITOUCH;
    private final int NONE;
    private boolean isCanceled;
    private boolean isHidden;
    private View.OnClickListener mBtnClickListener;
    private ImageView mCaptureBtn;
    private boolean mChangePenMode;
    private AlertView mClearAlertView;
    private BoardDataController mDataController;
    private Display mDisplay;
    private boolean mDocsPenMode;
    private ImageView mDocsViewModeBtn;
    private Button mEndBtn;
    private ImageView mEraserBtn;
    private Handler mHandler;
    private ImageView mHideBtn;
    private boolean mIsDocsviewMode;
    private boolean mIsRecvDraw;
    private RelativeLayout.LayoutParams mLayoutParams;
    private ArrayList<byte[]> mNoInitialData;
    private ImageView mPenBtn;
    private View mPenColor;
    private PenWritingCapture mPenWritingCapture;
    private ImageView mRedoBtn;
    private SCanvasView mSCanvas;
    private boolean mSCanvasInital;
    private Matrix mSCanvasMatrix;
    SCanvasDeleteAllConfirmListener mSCanvasOnDeleteAllConfirmListener;
    SPenTouchIDListener mSCanvasOnPenTouchIDListener;
    SObjectUpdateListener mSObjectListenerUI;
    private ScreenShareActivity mScreenShareActivity;
    private SettingStrokeInfo mSendSettingStrokeInfo;
    private FrameLayout mSettingViewContainer;
    private RelativeLayout mShareViewToolbarLayout;
    private ImageView mTextBtn;
    private LinearLayout mToolbarBtnLayout;
    private LinearLayout mToolbarCaptureLayout;
    private LayoutTransition mTransition;
    private ImageView mUndoBtn;
    private WindowManager mWindowsManager;
    private int mode;
    private View.OnClickListener undoNredoBtnClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public DocsMenuViewLayout(Context context, int layoutResId, ScreenShareActivity screenShareActivity) {
        super(context, layoutResId);
        this.NONE = 0;
        this.DRAG = 1;
        this.MULTITOUCH = 2;
        this.mode = 0;
        this.isCanceled = false;
        this.isHidden = false;
        this.mHandler = new Handler();
        this.mNoInitialData = new ArrayList<>();
        this.mSCanvasInital = false;
        this.mChangePenMode = false;
        this.mDocsPenMode = false;
        this.mIsDocsviewMode = false;
        this.mSCanvasMatrix = null;
        this.mIsRecvDraw = false;
        this.mSCanvasOnDeleteAllConfirmListener = new SCanvasDeleteAllConfirmListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.1
            @Override // com.samsung.spensdk.applistener.SCanvasDeleteAllConfirmListener
            public boolean onDeleteAllConfirm(int nLayerID) throws Resources.NotFoundException {
                DocsMenuViewLayout.this.mClearAlertView = new AlertView(MainApplication.mContext);
                DocsMenuViewLayout.this.mClearAlertView.setTitle(C0000R.string.screenshare_alertView_attention_title);
                DocsMenuViewLayout.this.mClearAlertView.setMessage(C0000R.string.screenshare_alertView_attention_message);
                DocsMenuViewLayout.this.mClearAlertView.setPositiveButton(C0000R.string.ok, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.1.1
                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                    public void onClick(AlertView dialog, int which) {
                        DocsMenuViewLayout.this.mSCanvas.deleteAll(true);
                        DocsMenuViewLayout.this.clearPageData();
                        DocsMenuViewLayout.this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARPAGE, null);
                        DocsMenuViewLayout.this.closeSettingView();
                    }
                });
                DocsMenuViewLayout.this.mClearAlertView.setNegativeButton(C0000R.string.cancel, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.1.2
                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                    public void onClick(AlertView dialog, int which) {
                    }
                });
                DocsMenuViewLayout.this.mClearAlertView.setCancelable(true);
                DocsMenuViewLayout.this.mClearAlertView.show();
                return true;
            }
        };
        this.mBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int nBtnID = view.getId();
                if (nBtnID != DocsMenuViewLayout.this.mDocsViewModeBtn.getId()) {
                    if (nBtnID == DocsMenuViewLayout.this.mPenBtn.getId()) {
                        DocsMenuViewLayout.this.mSCanvas.setCanvasDrawable(true);
                        DocsMenuViewLayout.this.mChangePenMode = true;
                        if (DocsMenuViewLayout.this.mSCanvas.getCanvasMode() != 10 || DocsMenuViewLayout.this.getDocsViewMode()) {
                            DocsMenuViewLayout.this.mSCanvas.setCanvasMode(10);
                            DocsMenuViewLayout.this.mSCanvas.showSettingView(1, false);
                        } else {
                            DocsMenuViewLayout.this.mSCanvas.setSettingViewSizeOption(1, 2);
                            DocsMenuViewLayout.this.mSCanvas.toggleShowSettingView(1);
                        }
                        DocsMenuViewLayout.this.setDocsViewMode(false);
                        DocsMenuViewLayout.this.setMenuIconSelected(nBtnID);
                        DocsMenuViewLayout.this.mSCanvas.setCanvasDrawable(true);
                        if (DocsMenuViewLayout.this.mOnSendCommandData != null && DocsMenuViewLayout.this.mChangePenMode) {
                            DocsMenuViewLayout.this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_DRAWING_REQ_MODE, null);
                            DocsMenuViewLayout.this.mChangePenMode = false;
                            return;
                        }
                        return;
                    }
                    if (nBtnID != DocsMenuViewLayout.this.mEraserBtn.getId()) {
                        if (nBtnID != DocsMenuViewLayout.this.mTextBtn.getId()) {
                            if (nBtnID == DocsMenuViewLayout.this.mEndBtn.getId()) {
                                DocsMenuViewLayout.this.logI("PenWriting EndBtn Clicked ");
                                if (DocsMenuViewLayout.this.mOnSendCommandData != null) {
                                    DocsMenuViewLayout.this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_SHARE_MODE, null);
                                }
                                DocsMenuViewLayout.this.mScreenShareActivity.setOtherPause(false);
                                DocsMenuViewLayout.this.mScreenShareActivity.chageShareView();
                                return;
                            }
                            if (nBtnID == DocsMenuViewLayout.this.mCaptureBtn.getId()) {
                                DocsMenuViewLayout.this.logI("PenWritingCapture is Clicked!!");
                                int res = DocsMenuViewLayout.this.mPenWritingCapture.ScreenOtherCapture();
                                if (res < 0) {
                                    ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_pen_writing_capture_fail), 0);
                                    return;
                                } else {
                                    ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_pen_writing_capture), 0);
                                    return;
                                }
                            }
                            if (nBtnID != DocsMenuViewLayout.this.mHideBtn.getId()) {
                                return;
                            }
                            DocsMenuViewLayout.this.btnHidden(DocsMenuViewLayout.this.isHidden);
                            if (DocsMenuViewLayout.this.mSCanvas.getCanvasMode() == 10) {
                                DocsMenuViewLayout.this.mSCanvas.setCanvasMode(10);
                                DocsMenuViewLayout.this.mSCanvas.showSettingView(1, false);
                                return;
                            } else if (DocsMenuViewLayout.this.mSCanvas.getCanvasMode() == 11) {
                                DocsMenuViewLayout.this.mSCanvas.setCanvasMode(11);
                                DocsMenuViewLayout.this.mSCanvas.showSettingView(2, false);
                                return;
                            } else {
                                if (DocsMenuViewLayout.this.mSCanvas.getCanvasMode() == 12) {
                                    DocsMenuViewLayout.this.mSCanvas.setCanvasMode(12);
                                    DocsMenuViewLayout.this.mSCanvas.showSettingView(3, false);
                                    return;
                                }
                                return;
                            }
                        }
                        DocsMenuViewLayout.this.mChangePenMode = true;
                        if (DocsMenuViewLayout.this.mSCanvas.getCanvasMode() != 12 || DocsMenuViewLayout.this.getDocsViewMode()) {
                            DocsMenuViewLayout.this.mSCanvas.setCanvasMode(12);
                            DocsMenuViewLayout.this.mSCanvas.showSettingView(3, false);
                        } else {
                            DocsMenuViewLayout.this.mSCanvas.setSettingViewSizeOption(3, 1);
                            DocsMenuViewLayout.this.mSCanvas.toggleShowSettingView(3);
                        }
                        DocsMenuViewLayout.this.setDocsViewMode(false);
                        DocsMenuViewLayout.this.setMenuIconSelected(nBtnID);
                        DocsMenuViewLayout.this.mSCanvas.setCanvasDrawable(true);
                        if (DocsMenuViewLayout.this.mOnSendCommandData != null && DocsMenuViewLayout.this.mChangePenMode) {
                            DocsMenuViewLayout.this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_DRAWING_REQ_MODE, null);
                            DocsMenuViewLayout.this.mChangePenMode = false;
                            return;
                        }
                        return;
                    }
                    DocsMenuViewLayout.this.mChangePenMode = true;
                    if (DocsMenuViewLayout.this.mSCanvas.getCanvasMode() != 11 || DocsMenuViewLayout.this.getDocsViewMode()) {
                        DocsMenuViewLayout.this.mSCanvas.setCanvasMode(11);
                        DocsMenuViewLayout.this.mSCanvas.showSettingView(2, false);
                    } else {
                        DocsMenuViewLayout.this.mSCanvas.setSettingViewSizeOption(2, 0);
                        DocsMenuViewLayout.this.mSCanvas.toggleShowSettingView(2);
                    }
                    DocsMenuViewLayout.this.setDocsViewMode(false);
                    DocsMenuViewLayout.this.setMenuIconSelected(nBtnID);
                    DocsMenuViewLayout.this.mSCanvas.setCanvasDrawable(true);
                    if (DocsMenuViewLayout.this.mOnSendCommandData != null && DocsMenuViewLayout.this.mChangePenMode) {
                        DocsMenuViewLayout.this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_DRAWING_REQ_MODE, null);
                        DocsMenuViewLayout.this.mChangePenMode = false;
                        return;
                    }
                    return;
                }
                DocsMenuViewLayout.this.mChangePenMode = true;
                DocsMenuViewLayout.this.mSCanvas.setCanvasMode(0);
                DocsMenuViewLayout.this.mSCanvas.showSettingView(0, false);
                DocsMenuViewLayout.this.closeSettingView();
                DocsMenuViewLayout.this.setPenDocsMode(false);
                DocsMenuViewLayout.this.setDocsViewMode(true);
                DocsMenuViewLayout.this.setMenuIconSelected(nBtnID);
            }
        };
        this.mSObjectListenerUI = new SObjectUpdateListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.3
            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectChanged(SObject sObject, boolean byUndo, boolean byRedo) {
                if ((sObject instanceof SObjectText) && !byRedo && !byUndo) {
                    int mutiUserId = sObject.getTempIntData("SObjectMultiUserIDKey", -1);
                    int mutiTextId = sObject.getTempIntData("SObjectMultiObjectIDKey", -1);
                    if (mutiUserId != 1) {
                        SObjectText textData = (SObjectText) sObject;
                        int nColor = textData.getColor();
                        int nStyle = textData.getStyle();
                        float fSize = textData.getSize();
                        RectF rRect = textData.getRect();
                        String strText = textData.getText();
                        String strFont = textData.getFontName();
                        byte[] cmdData = PenWriteNetwork.makeSAMMTextInput(DocsMenuViewLayout.this.mUserID, mutiTextId, nColor, nStyle, fSize, rRect.left, rRect.top, rRect.right, rRect.bottom, strFont, strText);
                        if (DocsMenuViewLayout.this.mSCanvas.getCanvasMode() != 12) {
                            return;
                        }
                        DocsMenuViewLayout.this.onSendData(302, cmdData);
                    }
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeleted(SObject sObject, boolean byUndo, boolean byRedo, boolean arg3) {
                if ((sObject instanceof SObjectText) && !byRedo && !byUndo) {
                    int mutiUserId = sObject.getTempIntData("SObjectMultiUserIDKey", -1);
                    int mutiTextId = sObject.getTempIntData("SObjectMultiObjectIDKey", -1);
                    if (mutiUserId != 1) {
                        SObjectText textData = (SObjectText) sObject;
                        int nColor = textData.getColor();
                        int nStyle = textData.getStyle();
                        float fSize = textData.getSize();
                        RectF rRect = textData.getRect();
                        String strFont = textData.getFontName();
                        byte[] cmdData = PenWriteNetwork.makeSAMMTextInput(DocsMenuViewLayout.this.mUserID, mutiTextId, nColor, nStyle, fSize, rRect.left, rRect.top, rRect.right, rRect.bottom, strFont, "");
                        if (DocsMenuViewLayout.this.mSCanvas.getCanvasMode() != 12) {
                            return;
                        }
                        DocsMenuViewLayout.this.onSendData(302, cmdData);
                    }
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeletedAll(boolean arg0, int arg1) {
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectInserted(SObject sObject, boolean byUndo, boolean byRedo) {
                if ((sObject instanceof SObjectText) && !byRedo && !byUndo) {
                    int mutiUserId = sObject.getTempIntData("SObjectMultiUserIDKey", -1);
                    int mutiTextId = sObject.getTempIntData("SObjectMultiObjectIDKey", -1);
                    if (mutiUserId != 1) {
                        SObjectText textData = (SObjectText) sObject;
                        int nColor = textData.getColor();
                        int nStyle = textData.getStyle();
                        float fSize = textData.getSize();
                        RectF rRect = textData.getRect();
                        String strText = textData.getText();
                        String strFont = textData.getFontName();
                        byte[] cmdData = PenWriteNetwork.makeSAMMTextInput(DocsMenuViewLayout.this.mUserID, mutiTextId, nColor, nStyle, fSize, rRect.left, rRect.top, rRect.right, rRect.bottom, strFont, strText);
                        if (DocsMenuViewLayout.this.mSCanvas.getCanvasMode() != 12) {
                            return;
                        }
                        DocsMenuViewLayout.this.onSendData(301, cmdData);
                    }
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectSelected(SObject arg0, boolean arg1) {
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public boolean onSObjectStrokeInserting(SObjectStroke arg0) {
                return false;
            }
        };
        this.undoNredoBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DocsMenuViewLayout.this.logI("undoNredoBtnClickListener()");
                int nBtnID = view.getId();
                byte[] cmdData = PenWriteNetwork.intToByte(DocsMenuViewLayout.this.mUserID);
                if (nBtnID == DocsMenuViewLayout.this.mUndoBtn.getId()) {
                    DocsMenuViewLayout.this.mSCanvas.undo();
                    DocsMenuViewLayout.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO, cmdData);
                } else if (nBtnID == DocsMenuViewLayout.this.mRedoBtn.getId()) {
                    DocsMenuViewLayout.this.mSCanvas.redo();
                    DocsMenuViewLayout.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO, cmdData);
                }
                DocsMenuViewLayout.this.mUndoBtn.setEnabled(DocsMenuViewLayout.this.mSCanvas.isUndoable());
                DocsMenuViewLayout.this.mRedoBtn.setEnabled(DocsMenuViewLayout.this.mSCanvas.isRedoable());
            }
        };
        this.mSCanvasOnPenTouchIDListener = new SPenTouchIDListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.5
            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchFinger(View view, MotionEvent event, int multiObjectID) {
                DocsMenuViewLayout.this.setTouchMode(event);
                DocsMenuViewLayout.this.sendTouchEvent(event, multiObjectID, 0);
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPen(View view, MotionEvent event, int multiObjectID) {
                DocsMenuViewLayout.this.sendTouchEvent(event, multiObjectID, 1);
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPenEraser(View view, MotionEvent event, int multiObjectID) {
                DocsMenuViewLayout.this.sendTouchEvent(event, multiObjectID, 2);
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onDrawingPen(View arg0, MotionEvent arg1, int arg2, int arg3) {
                return false;
            }
        };
        logI("PenWritingViewLayout()");
        this.mScreenShareActivity = screenShareActivity;
        this.mWindowsManager = (WindowManager) getContext().getSystemService("window");
        this.mDisplay = this.mWindowsManager.getDefaultDisplay();
        RelativeLayout.LayoutParams thisLayoutParam = new RelativeLayout.LayoutParams(-1, -1);
        setLayoutParams(thisLayoutParam);
        initScaleData();
        load();
        this.mDataController = this.mScreenShareActivity.getBoardDataController();
    }

    private void initScaleData() {
        this.mScreenShareActivity.initScaleData();
    }

    public void setPenDocsMode(boolean isPenMode) {
        this.mDocsPenMode = isPenMode;
        if (isPenMode) {
            if (this.mDocsViewModeBtn.isSelected()) {
                this.mSCanvas.setCanvasMode(10);
                this.mSCanvas.showSettingView(1, false);
                setMenuIconSelected(this.mPenBtn.getId());
                if (this.mOnSendCommandData != null && this.mChangePenMode) {
                    this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_DRAWING_REQ_MODE, null);
                    this.mChangePenMode = false;
                }
            }
            this.mSCanvas.setCanvasDrawable(true);
            return;
        }
        this.mSCanvas.setCanvasDrawable(false);
        closeSettingView();
        setMenuIconSelected(this.mDocsViewModeBtn.getId());
        if (this.mOnSendCommandData != null && this.mChangePenMode) {
            this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_MODE, null);
            this.mChangePenMode = false;
        }
    }

    public void setDocsViewMode(boolean isDocsViewMode) {
        this.mIsDocsviewMode = isDocsViewMode;
    }

    public boolean getDocsViewMode() {
        return this.mIsDocsviewMode;
    }

    private void load() {
        logI("load UI Setting");
        this.mDocsViewModeBtn = (ImageView) findViewById(C0000R.id.docs_view_mode_btn_docs_layout);
        this.mPenBtn = (ImageView) findViewById(C0000R.id.pen_btn_docs_layout);
        this.mEraserBtn = (ImageView) findViewById(C0000R.id.eraser_btn_docs_layout);
        this.mUndoBtn = (ImageView) findViewById(C0000R.id.undo_btn_docs_layout);
        this.mRedoBtn = (ImageView) findViewById(C0000R.id.redo_btn_docs_layout);
        this.mCaptureBtn = (ImageView) findViewById(C0000R.id.camera_btn_docs_layout);
        this.mTextBtn = (ImageView) findViewById(C0000R.id.text_btn_docs_layout);
        this.mEndBtn = (Button) findViewById(C0000R.id.end_btn_docs_layout);
        this.mDocsViewModeBtn.setOnClickListener(this.mBtnClickListener);
        this.mPenBtn.setOnClickListener(this.mBtnClickListener);
        this.mEraserBtn.setOnClickListener(this.mBtnClickListener);
        this.mTextBtn.setOnClickListener(this.mBtnClickListener);
        this.mCaptureBtn.setOnClickListener(this.mBtnClickListener);
        this.mEndBtn.setOnClickListener(this.mBtnClickListener);
        this.mUndoBtn.setOnClickListener(this.undoNredoBtnClickListener);
        this.mRedoBtn.setOnClickListener(this.undoNredoBtnClickListener);
        this.mShareViewToolbarLayout = (RelativeLayout) findViewById(C0000R.id.share_view_toolbar_layout_docs_layout_1);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mShareViewToolbarLayout.getLayoutParams();
        layoutParams.width = this.mDisplay.getWidth() > this.mDisplay.getHeight() ? this.mDisplay.getHeight() : this.mDisplay.getWidth();
        this.mShareViewToolbarLayout.setLayoutParams(layoutParams);
        this.mToolbarBtnLayout = (LinearLayout) findViewById(C0000R.id.share_view_toolbar_layout_docs_layout);
        this.mToolbarCaptureLayout = (LinearLayout) findViewById(C0000R.id.camera_btn_layout_docs_layout);
        this.mHideBtn = (ImageView) findViewById(C0000R.id.showhide_btn_docs_layout);
        this.mHideBtn.setOnClickListener(this.mBtnClickListener);
        this.mSCanvas = (SCanvasView) findViewById(C0000R.id.canvas_view_docs_layout);
        this.mSCanvas.setSelectLayer(0);
        this.mSCanvas.setSPenTouchIDListener(this.mSCanvasOnPenTouchIDListener);
        this.mSCanvas.setSObjectUpdateListener(this.mSObjectListenerUI);
        HashMap<String, Integer> settingResourceMapInt = SPenSDKUtils.getSettingLayoutLocaleResourceMap(true, true, false, false);
        HashMap<String, String> settingResourceMapString = SPenSDKUtils.getSettingLayoutStringResourceMap(true, true, false, false);
        this.mSettingViewContainer = (FrameLayout) findViewById(C0000R.id.draw_canvas_docs_layout);
        this.mSCanvas.createSettingView(this.mSettingViewContainer, settingResourceMapInt, settingResourceMapString);
        this.mPenColor = findViewById(C0000R.id.pen_color_bar_docs_layout);
        this.mSCanvas.setSettingStrokeChangeListener(new SettingStrokeChangeListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.6
            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeWidthChanged(int arg0) {
                DocsMenuViewLayout.this.mShareViewToolbarLayout.invalidate();
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeStyleChanged(int arg0) {
                DocsMenuViewLayout.this.mShareViewToolbarLayout.invalidate();
                DocsMenuViewLayout.this.mPenColor.invalidate();
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeColorChanged(int arg0) {
                DocsMenuViewLayout.this.logI("mPenColor.setBackgroundColor(arg0)");
                DocsMenuViewLayout.this.mPenColor.setBackgroundColor(arg0);
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeAlphaChanged(int arg0) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onEraserWidthChanged(int arg0) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onDeleteAll(boolean arg0) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            @Deprecated
            public void onClearAll(boolean arg0) {
            }
        });
        this.mSCanvas.setSCanvasInitializeListener(new SCanvasInitializeListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.7
            @Override // com.samsung.spensdk.applistener.SCanvasInitializeListener
            public void onInitialized() {
                DocsMenuViewLayout.this.logI("onInitialized()");
                DocsMenuViewLayout.this.mSCanvas.setSelectLayer(0);
                DocsMenuViewLayout.this.mSCanvas.setCanvasMode(10);
                DocsMenuViewLayout.this.mSCanvas.setCanvasDrawable(false);
                DocsMenuViewLayout.this.mSCanvas.setMultiStroke(true);
                DocsMenuViewLayout.this.mSCanvas.setUserID(DocsMenuViewLayout.this.mUserID);
                DocsMenuViewLayout.this.mSCanvas.setMultiTouchCancel(false);
                DocsMenuViewLayout.this.mSCanvas.setPanEnable(false);
                DocsMenuViewLayout.this.setDefaultSettingStrokeInfo();
                DocsMenuViewLayout.this.mSCanvas.setZoomEnable(false);
                DocsMenuViewLayout.this.mLayoutParams = (RelativeLayout.LayoutParams) DocsMenuViewLayout.this.mSCanvas.getLayoutParams();
                Point disSize = new Point();
                DocsMenuViewLayout.this.mDisplay.getSize(disSize);
                DocsMenuViewLayout.this.mLayoutParams.width = disSize.x;
                DocsMenuViewLayout.this.mLayoutParams.height = disSize.y;
                DocsMenuViewLayout.this.mSCanvas.setLayoutParams(DocsMenuViewLayout.this.mLayoutParams);
                DocsMenuViewLayout.this.mSCanvas.setCanvasSize(disSize.x, disSize.y);
                DocsMenuViewLayout.this.mSCanvasInital = true;
                DocsMenuViewLayout.this.setMenuIconSelected(DocsMenuViewLayout.this.mDocsViewModeBtn.getId());
                DocsMenuViewLayout.this.setPenDocsMode(false);
                DocsMenuViewLayout.this.addDrawPenData();
            }
        });
        this.mSCanvas.setHistoryUpdateListener(new HistoryUpdateListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.8
            @Override // com.samsung.spensdk.applistener.HistoryUpdateListener
            public void onHistoryChanged(boolean undoable, boolean redoable) {
                DocsMenuViewLayout.this.mUndoBtn.setEnabled(undoable);
                DocsMenuViewLayout.this.mRedoBtn.setEnabled(redoable);
            }
        });
        this.mSCanvas.setSCanvasModeChangedListener(new SCanvasModeChangedListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.9
            @Override // com.samsung.spensdk.applistener.SCanvasModeChangedListener
            public void onModeChanged(int mode) {
                DocsMenuViewLayout.this.logI("setSCanvasModeChangedListener() updateModeState: " + mode);
            }
        });
        this.mUndoBtn.setEnabled(false);
        this.mRedoBtn.setEnabled(false);
        this.mPenBtn.setSelected(false);
        this.mDocsViewModeBtn.setSelected(true);
        setDocsViewMode(true);
        this.mPenWritingCapture = new PenWritingCapture();
        this.mSCanvas.setSCanvasDeleteAllConfirmListener(this.mSCanvasOnDeleteAllConfirmListener);
        this.mSCanvas.setSettingPresetDeleteBtnClickListener(new SettingPresetDeleteBtnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.10
            @Override // com.samsung.spensdk.applistener.SettingPresetDeleteBtnClickListener
            public void onClick(int nPresetIndex) {
                DocsMenuViewLayout.this.mSCanvas.deleteSettingViewPresetInfo(nPresetIndex, false);
            }
        });
        this.mSCanvas.setOnCancelListener(new CanvasView.OnCancelListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.11
            @Override // com.samsung.sdraw.CanvasView.OnCancelListener
            public void onCancel(int arg0) {
                if (!DocsMenuViewLayout.this.isCanceled) {
                    byte[] cmdData = PenWriteNetwork.intToByte(DocsMenuViewLayout.this.mUserID);
                    DocsMenuViewLayout.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO, cmdData);
                    DocsMenuViewLayout.this.isCanceled = true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDrawPenData() {
        if (this.mNoInitialData.size() > 0) {
            for (int i = 0; i < this.mNoInitialData.size(); i++) {
                PenWriteNetwork.shareSAMMStrokePoint SAMMStrokePoint = PenWriteNetwork.parseSAMMStrokePoint(this.mNoInitialData.get(i));
                if (SAMMStrokePoint != null) {
                    if (SAMMStrokePoint.Action == 0) {
                        gDownTime = SystemClock.uptimeMillis();
                    }
                    this.mSCanvas.drawMultiUserSAMMStrokePoint(SAMMStrokePoint.MultiUserID, SAMMStrokePoint.MultiStrokeID, SAMMStrokePoint.Action, SAMMStrokePoint.f6x, SAMMStrokePoint.f7y, SAMMStrokePoint.pressure, SAMMStrokePoint.sammMetaState, gDownTime, gDownTime + SAMMStrokePoint.eventtime);
                    this.mSCanvas.invalidate();
                } else {
                    logI("OnRecveData() SAMMStrokePoint is null");
                }
            }
            this.mNoInitialData.clear();
        }
    }

    private void onStartSettingViewInfo() {
        logI("onStartSettingViewInfo()");
        SettingStrokeInfo crayon = new SettingStrokeInfo();
        crayon.setStrokeStyle(1);
        crayon.setStrokeWidth(50.0f);
        crayon.setStrokeColor(-16711936);
        this.mSCanvas.setSettingViewStrokeInfo(crayon);
        SettingStrokeInfo brush = new SettingStrokeInfo();
        brush.setStrokeStyle(6);
        brush.setStrokeWidth(1.0f);
        brush.setStrokeColor(-16776961);
        this.mSCanvas.setSettingViewStrokeInfo(brush);
        SettingStrokeInfo chinesebrush = new SettingStrokeInfo();
        chinesebrush.setStrokeStyle(7);
        chinesebrush.setStrokeWidth(20.0f);
        chinesebrush.setStrokeColor(-16777216);
        this.mSCanvas.setSettingViewStrokeInfo(chinesebrush);
        SettingStrokeInfo eraser = new SettingStrokeInfo();
        eraser.setStrokeStyle(4);
        eraser.setStrokeWidth(70.0f);
        this.mSCanvas.setSettingViewStrokeInfo(eraser);
        SettingStrokeInfo solid = new SettingStrokeInfo();
        solid.setStrokeStyle(0);
        solid.setStrokeWidth(10.0f);
        solid.setStrokeColor(-65536);
        this.mSCanvas.setSettingViewStrokeInfo(solid);
    }

    @Override // com.coolots.chaton.call.screenshare.activity.ScreenShareLayout
    public void show() {
        logI("show()");
        btnHidden(true);
        super.show();
        this.mSCanvas.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultSettingStrokeInfo() {
        SettingStrokeInfo sendSettingStrokeInfo = new SettingStrokeInfo();
        sendSettingStrokeInfo.setStrokeStyle(0);
        sendSettingStrokeInfo.setStrokeColor(-5921371);
        this.mPenColor.setBackgroundColor(-5921371);
        sendSettingStrokeInfo.setStrokeWidth(10.0f);
        this.mSCanvas.setSettingViewStrokeInfo(sendSettingStrokeInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeSettingView() {
        this.mSCanvas.showSettingView(1, false);
        this.mSCanvas.showSettingView(2, false);
        this.mSCanvas.showSettingView(3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMenuIconSelected(int menuIconId) {
        if (menuIconId == this.mDocsViewModeBtn.getId()) {
            this.mDocsViewModeBtn.setSelected(true);
            this.mPenBtn.setSelected(false);
            this.mEraserBtn.setSelected(false);
            this.mTextBtn.setSelected(false);
            this.mUndoBtn.setEnabled(false);
            this.mRedoBtn.setEnabled(false);
            return;
        }
        if (menuIconId == this.mPenBtn.getId()) {
            this.mDocsViewModeBtn.setSelected(false);
            this.mPenBtn.setSelected(true);
            this.mEraserBtn.setSelected(false);
            this.mTextBtn.setSelected(false);
            this.mUndoBtn.setEnabled(this.mSCanvas.isUndoable());
            this.mRedoBtn.setEnabled(this.mSCanvas.isRedoable());
            return;
        }
        if (menuIconId == this.mEraserBtn.getId()) {
            this.mDocsViewModeBtn.setSelected(false);
            this.mPenBtn.setSelected(false);
            this.mEraserBtn.setSelected(true);
            this.mTextBtn.setSelected(false);
            this.mUndoBtn.setEnabled(this.mSCanvas.isUndoable());
            this.mRedoBtn.setEnabled(this.mSCanvas.isRedoable());
            return;
        }
        if (menuIconId == this.mTextBtn.getId()) {
            this.mDocsViewModeBtn.setSelected(false);
            this.mPenBtn.setSelected(false);
            this.mEraserBtn.setSelected(false);
            this.mTextBtn.setSelected(true);
            this.mUndoBtn.setEnabled(this.mSCanvas.isUndoable());
            this.mRedoBtn.setEnabled(this.mSCanvas.isRedoable());
        }
    }

    public void setUserID(int userid) {
        this.mUserID = userid;
        this.mSCanvas.setUserID(userid);
    }

    protected void sendTouchEvent(MotionEvent event, int multiObjectID, int sammMetaState) {
        if (this.mDocsPenMode) {
            if (event.getAction() == 0) {
                SettingStrokeInfo settingStrokeInfo = this.mSCanvas.getSettingViewStrokeInfo();
                byte[] cmdData = SettingPacket.makeSettingStrokeInfo(this.mUserID, settingStrokeInfo);
                if (this.mSendSettingStrokeInfo == null) {
                    this.mSendSettingStrokeInfo = SettingPacket.copySettingInfo(settingStrokeInfo);
                    this.mSendSettingStrokeInfo.setStrokeAlpha(settingStrokeInfo.getStrokeAlpha());
                    if (this.mOnSendCommandData != null) {
                        onSendData(100, cmdData);
                    }
                } else {
                    this.mSendSettingStrokeInfo = SettingPacket.copySettingInfo(settingStrokeInfo);
                    if (this.mOnSendCommandData != null) {
                        onSendData(100, cmdData);
                    }
                }
            }
            if (this.mode != 2) {
                float[] matrixVal = new float[9];
                if (this.mSCanvasMatrix != null) {
                    this.mSCanvasMatrix.getValues(matrixVal);
                }
                float rawX = (this.mScreenShareActivity.mScreenScale.modifyExpandScaleX(event.getRawX()) / matrixVal[0]) - (matrixVal[2] / matrixVal[0]);
                float rawY = (this.mScreenShareActivity.mScreenScale.modifyExpandScaleY(event.getRawY()) / matrixVal[0]) - (matrixVal[5] / matrixVal[0]);
                byte[] cmdData2 = PenWriteNetwork.makeSAMMStrokePoint(this.mUserID, multiObjectID, event.getAction(), rawX, rawY, event.getPressure(), sammMetaState, event.getDownTime(), event.getEventTime() - event.getDownTime());
                if (this.mOnSendCommandData != null && this.mSCanvas.getCanvasMode() != 12) {
                    onSendData(300, cmdData2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTouchMode(MotionEvent event) {
        switch (event.getAction() & 255) {
            case 0:
                this.mode = 1;
                break;
            case 1:
                this.mode = 0;
                this.isCanceled = false;
                break;
            case 5:
                this.mode = 2;
                break;
        }
    }

    @Override // com.coolots.chaton.call.screenshare.activity.ScreenShareLayout
    public void OnRecveData(int command, byte[] data) {
        logI("OnRecveData():" + command);
        addBoardData(command, data);
        if (command == 300) {
            this.mIsRecvDraw = true;
        }
        setDrawData(command, data);
    }

    private void setDrawData(int command, final byte[] data) {
        switch (command) {
            case 100:
                final MultiSettingStrokeInfo settingInfo = SettingPacket.parserSettingStrokeInfo(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.13
                    @Override // java.lang.Runnable
                    public void run() {
                        DocsMenuViewLayout.this.mSCanvas.setSettingStrokeInfo(settingInfo.userId, settingInfo.settingInfo);
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO /* 150 */:
                PenWriteNetwork.shareSAMMMatrixData SAMMMatrixData = PenWriteNetwork.parseMatrixData(data);
                this.mSCanvas.setMatrix(SAMMMatrixData.matrixData);
                this.mSCanvasMatrix = SAMMMatrixData.matrixData;
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_SCREENSIZE /* 151 */:
                PenWriteNetwork.shareSAMMScreenSize SAMMScreenSize = PenWriteNetwork.parseSAMMScreenSize(data);
                this.mSCanvas.setCanvasSize(SAMMScreenSize.screenWidth, SAMMScreenSize.screenHeight);
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO /* 203 */:
                final int destUserID = PenWriteNetwork.byteToInt(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.14
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DocsMenuViewLayout.this.mSCanvas.undo(destUserID);
                        } catch (Exception e) {
                            DocsMenuViewLayout.this.logE("mSCanvas.undo: " + e);
                        }
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO /* 204 */:
                final int destUserID2 = PenWriteNetwork.byteToInt(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.15
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DocsMenuViewLayout.this.mSCanvas.redo(destUserID2);
                        } catch (Exception e) {
                            DocsMenuViewLayout.this.logE("mSCanvas.redo: " + e);
                        }
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARALL /* 205 */:
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.16
                    @Override // java.lang.Runnable
                    public void run() {
                        DocsMenuViewLayout.this.mSCanvas.deleteAll(true);
                        DocsMenuViewLayout.this.initBoardDataController();
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARPAGE /* 206 */:
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.17
                    @Override // java.lang.Runnable
                    public void run() {
                        DocsMenuViewLayout.this.mSCanvas.deleteAll(true);
                        DocsMenuViewLayout.this.clearPageData();
                    }
                });
                break;
            case 300:
                final PenWriteNetwork.shareSAMMStrokePoint SAMMStrokePoint = PenWriteNetwork.parseSAMMStrokePoint(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.12
                    @Override // java.lang.Runnable
                    public void run() {
                        float rawX;
                        float rawY;
                        if (SAMMStrokePoint == null) {
                            DocsMenuViewLayout.this.logI("OnRecveData() SAMMStrokePoint is null");
                            return;
                        }
                        if (SAMMStrokePoint.Action == 0) {
                            DocsMenuViewLayout.gDownTime = SystemClock.uptimeMillis();
                        }
                        float[] matrixVal = new float[9];
                        if (DocsMenuViewLayout.this.mSCanvasMatrix != null) {
                            DocsMenuViewLayout.this.mSCanvasMatrix.getValues(matrixVal);
                        }
                        if (!DocsMenuViewLayout.this.mIsRecvDraw || DocsMenuViewLayout.this.mSCanvasMatrix != null) {
                            rawX = DocsMenuViewLayout.this.mScreenShareActivity.mScreenScale.modifyScaleX(SAMMStrokePoint.f6x);
                            rawY = DocsMenuViewLayout.this.mScreenShareActivity.mScreenScale.modifyScaleY(SAMMStrokePoint.f7y);
                        } else {
                            rawX = DocsMenuViewLayout.this.mScreenShareActivity.mScreenScale.modifyScaleX(SAMMStrokePoint.f6x);
                            rawY = DocsMenuViewLayout.this.mScreenShareActivity.mScreenScale.modifyScaleY(SAMMStrokePoint.f7y);
                        }
                        boolean result = DocsMenuViewLayout.this.mSCanvas.drawMultiUserSAMMStrokePoint(SAMMStrokePoint.MultiUserID, SAMMStrokePoint.MultiStrokeID, SAMMStrokePoint.Action, rawX, rawY, SAMMStrokePoint.pressure, SAMMStrokePoint.sammMetaState, DocsMenuViewLayout.gDownTime, DocsMenuViewLayout.gDownTime + SAMMStrokePoint.eventtime);
                        DocsMenuViewLayout.this.mSCanvas.invalidate();
                        if (!result || !DocsMenuViewLayout.this.mSCanvasInital) {
                            DocsMenuViewLayout.this.mNoInitialData.add(data);
                        }
                    }
                });
                break;
            case 301:
                final PenWriteNetwork.shareSAMMTextData SAMMTextData = PenWriteNetwork.parseSAMMTextData(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.18
                    @Override // java.lang.Runnable
                    public void run() {
                        RectF r = new RectF(SAMMTextData.textRectLeft, SAMMTextData.textRectTop, SAMMTextData.textRectRight, SAMMTextData.textRectBottom);
                        SObjectText textData = new SObjectText();
                        textData.setColor(SAMMTextData.textColor);
                        textData.setRect(r);
                        textData.setStyle(SAMMTextData.textStyle);
                        textData.setSize(SAMMTextData.textSize);
                        textData.setText(SAMMTextData.strText);
                        textData.setLayer(1);
                        DocsMenuViewLayout.this.mSCanvas.insertSAMMText(SAMMTextData.MultiUserID, SAMMTextData.textID, textData);
                        DocsMenuViewLayout.this.mSCanvas.invalidate();
                    }
                });
                break;
            case 302:
                this.mHandler.post(new Runnable(data) { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout.19
                    final PenWriteNetwork.shareSAMMTextData SAMMTextData;

                    {
                        this.SAMMTextData = PenWriteNetwork.parseSAMMTextData(data);
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        RectF r = new RectF(this.SAMMTextData.textRectLeft, this.SAMMTextData.textRectTop, this.SAMMTextData.textRectRight, this.SAMMTextData.textRectBottom);
                        SObjectText textData = new SObjectText();
                        textData.setColor(this.SAMMTextData.textColor);
                        textData.setRect(r);
                        textData.setStyle(this.SAMMTextData.textStyle);
                        textData.setSize(this.SAMMTextData.textSize);
                        textData.setText(this.SAMMTextData.strText);
                        textData.setLayer(1);
                        DocsMenuViewLayout.this.mSCanvas.changeSAMMObject(this.SAMMTextData.MultiUserID, this.SAMMTextData.textID, textData);
                        DocsMenuViewLayout.this.mSCanvas.invalidate();
                    }
                });
                break;
        }
    }

    public void penToolbarResize() {
        Point disSize = new Point();
        this.mDisplay.getSize(disSize);
        this.mLayoutParams = (RelativeLayout.LayoutParams) this.mSCanvas.getLayoutParams();
        this.mLayoutParams.width = disSize.x;
        this.mLayoutParams.height = disSize.y;
        this.mSCanvas.setLayoutParams(this.mLayoutParams);
        this.mSCanvas.setCanvasSize(disSize.x, disSize.y);
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

    @Override // com.coolots.chaton.call.screenshare.activity.ScreenShareLayout
    public void dismiss() {
        this.mShow = false;
        setEnabled(this.mShow);
        setVisibility(8);
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mHandler != null) {
            this.mHandler = null;
        }
        if (this.mSettingViewContainer != null) {
            this.mSettingViewContainer.removeAllViews();
            this.mSettingViewContainer = null;
        }
        if (this.mSCanvas != null) {
            this.mSCanvas.removeCallbacks(null);
            this.mSCanvas = null;
        }
        if (this.mDocsViewModeBtn != null) {
            this.mDocsViewModeBtn.removeCallbacks(null);
            this.mDocsViewModeBtn = null;
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
        if (this.mTextBtn != null) {
            this.mTextBtn.removeCallbacks(null);
            this.mTextBtn = null;
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
        if (this.mSCanvasMatrix != null) {
            this.mSCanvasMatrix = null;
        }
    }

    private void getPageCanvas(int page) {
        this.mDataController.getCurrentContainer(page);
        this.mSCanvas.deleteAll(true);
        ArrayList<BoardData> boardData = this.mDataController.getCurrentPageData(page);
        logI("getPageCanvas : " + boardData);
        if (boardData != null) {
            logI("getPageCanvas size : " + boardData.size());
            this.mIsRecvDraw = false;
            this.mSCanvas.setCanvasMode(10);
            this.mSCanvas.showSettingView(1, false);
            Iterator<BoardData> it = boardData.iterator();
            while (it.hasNext()) {
                BoardData data = it.next();
                setDrawData(data.getType(), data.getData());
            }
            this.mSCanvas.setCanvasMode(0);
            this.mSCanvas.showSettingView(0, false);
        }
        this.mSCanvas.setVisibility(0);
    }

    private void addBoardData(int type, byte[] data) {
        if (this.mDataController != null) {
            this.mDataController.addBoardData(mCurrentPage, type, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSendData(int type, byte[] data) {
        if (this.mOnSendCommandData != null) {
            this.mOnSendCommandData.onSendData(type, data);
            addBoardData(type, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPageData() {
        if (this.mDataController != null) {
            this.mDataController.removeBoardDataInPage(mCurrentPage);
        }
    }

    public void onOtherPartyPage(int page) {
        logI("onOtherPartyPage data  page: " + page);
        if (mCurrentPage != page) {
            getPageCanvas(page);
        }
        mCurrentPage = page;
    }

    public void initBoardDataController() {
        this.mScreenShareActivity.initBoardDataController();
    }
}
