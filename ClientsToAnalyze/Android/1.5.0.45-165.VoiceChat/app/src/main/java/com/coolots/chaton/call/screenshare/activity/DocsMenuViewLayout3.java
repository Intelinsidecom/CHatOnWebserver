package com.coolots.chaton.call.screenshare.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
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
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.coolots.chaton.call.screenshare.util.SettingPacket;
import com.coolots.chaton.call.screenshare.util.SettingView;
import com.coolots.chaton.call.screenshare.util.SpenSettingInfo;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.SpenSettingEraserInfo;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.document.SpenNoteDoc;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.engine.SpenColorPickerListener;
import com.samsung.android.sdk.pen.engine.SpenMultiView;
import com.samsung.android.sdk.pen.engine.SpenPenChangeListener;
import com.samsung.android.sdk.pen.engine.SpenSurfaceView;
import com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class DocsMenuViewLayout3 extends ScreenShareLayout implements DisposeInterface {
    private static final String CLASSNAME = "[DocsMenuViewLayout]";
    private static final int OTHERID = 2;
    private static final int SHARERID = 1;
    private static long gDownTime;
    final int BRUSH;
    final int INKPEN;
    private boolean isHidden;
    private boolean isSpenFeatureEnabled;
    private View.OnClickListener mBtnClickListener;
    private RelativeLayout mCanvasLayout;
    private ImageView mCaptureBtn;
    private AlertView mClearAlertView;
    private Context mContext;
    private int mCurrentPage;
    private BoardDataController mDataController;
    private Display mDisplay;
    private float mDistanceX;
    private float mDistanceY;
    private boolean mDocsPenMode;
    private ImageView mDocsViewModeBtn;
    private Button mEndBtn;
    private ImageView mEraserBtn;
    private Handler mHandler;
    private ImageView mHideBtn;
    private SpenPageDoc.HistoryListener mHistoryListener;
    private boolean mIsChangingPenMode;
    private boolean mIsFingerDrawing;
    private ArrayList<byte[]> mNoInitialData;
    private ImageView mPenBtn;
    private View mPenColor;
    private PenWritingCapture mPenWritingCapture;
    private ImageView mRedoBtn;
    private float mScaleRatio;
    private ScreenShareActivity mScreenShareActivity;
    private SettingView mSettingView;
    private FrameLayout mSettingViewContainer;
    private RelativeLayout mShareViewToolbarLayout;
    private SpenMultiView mSpenMulitView;
    private SpenNoteDoc mSpenNoteDoc;
    private SpenPageDoc mSpenPageDoc;
    private int mSpenSettingMode;
    private SpenSettingInfo mSpensettinginfo;
    private LinearLayout mToolbarBtnLayout;
    private LinearLayout mToolbarCaptureLayout;
    private ImageView mUndoBtn;
    private WindowManager mWindowsManager;
    private final View.OnClickListener undoNredoBtnClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public DocsMenuViewLayout3(Context context, int layoutResId, ScreenShareActivity screenShareActivity) {
        super(context, layoutResId);
        this.mIsFingerDrawing = false;
        this.BRUSH = 0;
        this.INKPEN = 1;
        this.isHidden = false;
        this.mHandler = new Handler();
        this.mNoInitialData = new ArrayList<>();
        this.mCurrentPage = 0;
        this.mDocsPenMode = false;
        this.mScaleRatio = 1.0f;
        this.mDistanceX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mDistanceY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mSpenSettingMode = 1;
        this.mSpensettinginfo = null;
        this.isSpenFeatureEnabled = false;
        this.mHistoryListener = new SpenPageDoc.HistoryListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout3.1
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
        this.mBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout3.2
            int fingerAction;
            int settingViewSize;
            int spenAction;

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DocsMenuViewLayout3.this.mSpenMulitView.getToolTypeAction(2) == 5) {
                    DocsMenuViewLayout3.this.mSettingView.closeSettingView();
                }
                if (!v.equals(DocsMenuViewLayout3.this.mEraserBtn)) {
                    if (!v.equals(DocsMenuViewLayout3.this.mDocsViewModeBtn)) {
                        if (!v.equals(DocsMenuViewLayout3.this.mPenBtn)) {
                            if (v.equals(DocsMenuViewLayout3.this.mCaptureBtn)) {
                                DocsMenuViewLayout3.this.logI("PenWritingCapture is Clicked!!");
                                int res = DocsMenuViewLayout3.this.mPenWritingCapture.ScreenOtherCapture();
                                if (res < 0) {
                                    ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_pen_writing_capture_fail), 0);
                                    return;
                                } else {
                                    ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_pen_writing_capture), 0);
                                    return;
                                }
                            }
                            if (!v.equals(DocsMenuViewLayout3.this.mHideBtn)) {
                                if (v.equals(DocsMenuViewLayout3.this.mEndBtn)) {
                                    if (DocsMenuViewLayout3.this.mOnSendCommandData != null) {
                                        DocsMenuViewLayout3.this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_SHARE_MODE, null);
                                    }
                                    DocsMenuViewLayout3.this.mScreenShareActivity.setOtherPause(false);
                                    DocsMenuViewLayout3.this.mScreenShareActivity.chageShareView();
                                    return;
                                }
                            } else {
                                DocsMenuViewLayout3.this.btnHidden(DocsMenuViewLayout3.this.isHidden);
                                DocsMenuViewLayout3.this.mSettingView.closeSettingView();
                                return;
                            }
                        } else {
                            DocsMenuViewLayout3.this.mIsFingerDrawing = true;
                            DocsMenuViewLayout3.this.mIsChangingPenMode = true;
                            DocsMenuViewLayout3.this.mSpenSettingMode = 1;
                            this.fingerAction = 2;
                            if (DocsMenuViewLayout3.this.mSpenMulitView.getToolTypeAction(2, 2) != 2) {
                                DocsMenuViewLayout3.this.mSettingView.closeSettingView();
                            } else {
                                DocsMenuViewLayout3.this.mSettingView.toggleShowSettingView(DocsMenuViewLayout3.this.mSpenSettingMode, this.settingViewSize);
                            }
                            this.spenAction = 2;
                            this.settingViewSize = 2;
                            if (DocsMenuViewLayout3.this.mOnSendCommandData != null && DocsMenuViewLayout3.this.mIsChangingPenMode) {
                                DocsMenuViewLayout3.this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_DRAWING_REQ_MODE, null);
                                DocsMenuViewLayout3.this.mIsChangingPenMode = false;
                            }
                        }
                    } else {
                        DocsMenuViewLayout3.this.mSettingView.closeSettingView();
                        DocsMenuViewLayout3.this.mIsFingerDrawing = false;
                        DocsMenuViewLayout3.this.mIsChangingPenMode = true;
                        DocsMenuViewLayout3.this.setPenDocsMode(false);
                        this.spenAction = 0;
                        this.fingerAction = 0;
                        DocsMenuViewLayout3.this.mSpenMulitView.setToolTypeAction(2, 1, 0);
                        DocsMenuViewLayout3.this.mSpenMulitView.setToolTypeAction(2, 2, 0);
                        DocsMenuViewLayout3.this.updateBtnState(v);
                        DocsMenuViewLayout3.this.updateUndoRedoBtnState();
                        return;
                    }
                } else {
                    DocsMenuViewLayout3.this.mIsFingerDrawing = true;
                    DocsMenuViewLayout3.this.mIsChangingPenMode = true;
                    DocsMenuViewLayout3.this.mSpenSettingMode = 2;
                    this.fingerAction = 3;
                    if (DocsMenuViewLayout3.this.mSpenMulitView.getToolTypeAction(2, 2) != 3) {
                        DocsMenuViewLayout3.this.mSettingView.closeSettingView();
                    } else {
                        DocsMenuViewLayout3.this.mSettingView.toggleShowSettingView(DocsMenuViewLayout3.this.mSpenSettingMode, this.settingViewSize);
                    }
                    this.spenAction = 3;
                    this.settingViewSize = 0;
                    if (DocsMenuViewLayout3.this.mOnSendCommandData != null && DocsMenuViewLayout3.this.mIsChangingPenMode) {
                        DocsMenuViewLayout3.this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_DRAWING_REQ_MODE, null);
                        DocsMenuViewLayout3.this.mIsChangingPenMode = false;
                    }
                }
                if (DocsMenuViewLayout3.this.mSpenMulitView.getToolTypeAction(2) != this.spenAction && !DocsMenuViewLayout3.this.mIsFingerDrawing) {
                    this.fingerAction = 1;
                }
                DocsMenuViewLayout3.this.mSpenMulitView.setToolTypeAction(2, 1, this.fingerAction);
                DocsMenuViewLayout3.this.mSpenMulitView.setToolTypeAction(2, 2, this.spenAction);
                DocsMenuViewLayout3.this.updateBtnState(v);
                DocsMenuViewLayout3.this.updateUndoRedoBtnState();
            }
        };
        this.undoNredoBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout3.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DocsMenuViewLayout3.this.mSpenPageDoc != null) {
                    if (!v.equals(DocsMenuViewLayout3.this.mUndoBtn) || !DocsMenuViewLayout3.this.mSpenPageDoc.isUndoable(2)) {
                        if (v.equals(DocsMenuViewLayout3.this.mRedoBtn) && DocsMenuViewLayout3.this.mSpenPageDoc.isRedoable(2)) {
                            SpenPageDoc.HistoryUpdateInfo[] userData = DocsMenuViewLayout3.this.mSpenPageDoc.redo(2);
                            DocsMenuViewLayout3.this.mSpenMulitView.updateRedo(userData, 2);
                            DocsMenuViewLayout3.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO, null);
                        }
                    } else {
                        SpenPageDoc.HistoryUpdateInfo[] userData2 = DocsMenuViewLayout3.this.mSpenPageDoc.undo(2);
                        DocsMenuViewLayout3.this.mSpenMulitView.updateUndo(userData2, 2);
                        DocsMenuViewLayout3.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO, null);
                    }
                    DocsMenuViewLayout3.this.updateUndoRedoBtnState();
                }
            }
        };
        logI("panda     DocsMenuViewLayout3()");
        this.mContext = context;
        this.mScreenShareActivity = screenShareActivity;
        this.mWindowsManager = (WindowManager) getContext().getSystemService("window");
        this.mDisplay = this.mWindowsManager.getDefaultDisplay();
        RelativeLayout.LayoutParams thisLayoutParam = new RelativeLayout.LayoutParams(-1, -1);
        setLayoutParams(thisLayoutParam);
        initScaleData();
        initSpenSDK();
        load();
        this.mDataController = new BoardDataController();
    }

    private void initScaleData() {
        this.mScreenShareActivity.initScaleData();
    }

    private void initSpenSDK() {
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

    private void load() {
        initLayout();
        initCanvas();
        initSettingView();
        initPage();
        initSettingInfo();
        this.mPenWritingCapture = new PenWritingCapture();
    }

    private void initLayout() {
        logI("panda     load UI Setting");
        this.mDocsViewModeBtn = (ImageView) findViewById(C0000R.id.docs_view_mode_btn_docs_layout_3);
        this.mDocsViewModeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout3.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DocsMenuViewLayout3.this.mIsFingerDrawing) {
                    DocsMenuViewLayout3.this.mSpenMulitView.setToolTypeAction(2, 1, 0);
                    DocsMenuViewLayout3.this.mIsFingerDrawing = false;
                } else {
                    DocsMenuViewLayout3.this.mSpenMulitView.setToolTypeAction(2, 1, DocsMenuViewLayout3.this.mSpenMulitView.getToolTypeAction(2, 2));
                    DocsMenuViewLayout3.this.mIsFingerDrawing = true;
                }
            }
        });
        this.mPenBtn = (ImageView) findViewById(C0000R.id.pen_btn_docs_layout_3);
        this.mPenColor = findViewById(C0000R.id.pen_color_bar_docs_layout_3);
        this.mEraserBtn = (ImageView) findViewById(C0000R.id.eraser_btn_docs_layout_3);
        this.mUndoBtn = (ImageView) findViewById(C0000R.id.undo_btn_docs_layout_3);
        this.mRedoBtn = (ImageView) findViewById(C0000R.id.redo_btn_docs_layout_3);
        this.mCaptureBtn = (ImageView) findViewById(C0000R.id.camera_btn_docs_layout_3);
        this.mEndBtn = (Button) findViewById(C0000R.id.end_btn_docs_layout_3);
        this.mHideBtn = (ImageView) findViewById(C0000R.id.showhide_btn_docs_layout_3);
        this.mDocsViewModeBtn.setOnClickListener(this.mBtnClickListener);
        this.mPenBtn.setOnClickListener(this.mBtnClickListener);
        this.mEraserBtn.setOnClickListener(this.mBtnClickListener);
        this.mCaptureBtn.setOnClickListener(this.mBtnClickListener);
        this.mEndBtn.setOnClickListener(this.mBtnClickListener);
        this.mHideBtn.setOnClickListener(this.mBtnClickListener);
        this.mUndoBtn.setEnabled(false);
        this.mRedoBtn.setEnabled(true);
        this.mUndoBtn.setOnClickListener(this.undoNredoBtnClickListener);
        this.mRedoBtn.setOnClickListener(this.undoNredoBtnClickListener);
        this.mShareViewToolbarLayout = (RelativeLayout) findViewById(C0000R.id.share_view_toolbar_layout_docs_layout_1_3);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mShareViewToolbarLayout.getLayoutParams();
        layoutParams.width = this.mDisplay.getWidth() > this.mDisplay.getHeight() ? this.mDisplay.getHeight() : this.mDisplay.getWidth();
        this.mShareViewToolbarLayout.setLayoutParams(layoutParams);
        this.mToolbarBtnLayout = (LinearLayout) findViewById(C0000R.id.share_view_toolbar_layout_docs_layout_3);
        this.mToolbarCaptureLayout = (LinearLayout) findViewById(C0000R.id.camera_btn_layout_docs_layout_3);
    }

    private void stopScreenShare() {
        MainApplication.mPhoneManager.getShareScreenManager().stopShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination());
        ScreenShareProc.stopScreenShare();
    }

    private void initCanvas() {
        this.mCanvasLayout = (RelativeLayout) findViewById(C0000R.id.canvasLayout);
        try {
            this.mSpenMulitView = new SpenMultiView(this.mContext);
            if (this.mSpenMulitView != null) {
                this.mCanvasLayout.addView(this.mSpenMulitView);
                this.mSpenMulitView.setLocalUserId(2);
                this.mSpenMulitView.addUser(1);
                this.mSpenMulitView.setMinZoomRatio(1.0f);
                setSpenSurfaceViewTouchListener();
            }
        } catch (Exception e) {
            e.printStackTrace();
            stopScreenShare();
        } catch (UnsatisfiedLinkError error) {
            error.printStackTrace();
            stopScreenShare();
        }
    }

    private void initSettingView() {
        this.mSettingViewContainer = (FrameLayout) findViewById(C0000R.id.canvas_container);
        this.mSettingView = new SettingView(this.mContext, this.mCanvasLayout);
        if (this.mSettingView != null) {
            this.mSettingViewContainer.addView(this.mSettingView);
            this.mSettingView.setCanvasView(this.mSpenMulitView);
        }
    }

    private void initPage() {
        Rect rect = new Rect();
        this.mDisplay.getRectSize(rect);
        try {
            int screenWidth = rect.width();
            int screenHeight = rect.height();
            this.mSpenNoteDoc = new SpenNoteDoc(this.mContext, screenWidth, screenHeight);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mSpenPageDoc = this.mSpenNoteDoc.appendPage();
        this.mSpenPageDoc.setBackgroundColor(0);
        this.mSpenPageDoc.setBackgroundImageMode(2);
        this.mSpenPageDoc.clearHistory();
        setRegisterListener();
        this.mSpenPageDoc.setHistoryManagerMode(1);
        this.mSpenMulitView.setPageDoc(this.mSpenPageDoc, true);
    }

    private void setRegisterListener() {
        this.mSpenPageDoc.setHistoryListener(this.mHistoryListener);
        this.mSpenMulitView.setColorPickerListener(new SpenColorPickerListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout3.5
            @Override // com.samsung.android.sdk.pen.engine.SpenColorPickerListener
            public void onChanged(int color, int x, int y) {
                if (DocsMenuViewLayout3.this.mSettingView != null) {
                    SpenSettingPenInfo penInfo = DocsMenuViewLayout3.this.mSettingView.getSpenPenInfo();
                    penInfo.color = color;
                    DocsMenuViewLayout3.this.mSettingView.setSpenPenInfo(penInfo);
                }
            }
        });
    }

    private void initSettingInfo() {
        logE("panda     initSettingInfo()");
        SpenSettingPenInfo penInfo = this.mSpenMulitView.getPenSettingInfo(2);
        penInfo.color = -5921371;
        penInfo.size = 20.0f;
        this.mSpenMulitView.setPenSettingInfo(2, penInfo);
        this.mSettingView.setSpenPenInfo(penInfo);
        this.mPenColor.setBackgroundColor(penInfo.color);
        this.mSpenMulitView.setPenChangeListener(new SpenPenChangeListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout3.6
            @Override // com.samsung.android.sdk.pen.engine.SpenPenChangeListener
            public void onChanged(SpenSettingPenInfo penInfo2) {
                DocsMenuViewLayout3.this.logI("<CIH> onChanged");
                DocsMenuViewLayout3.this.mPenColor.setBackgroundColor(penInfo2.color);
            }
        });
        SpenSettingEraserInfo eraserInfo = this.mSpenMulitView.getEraserSettingInfo(2);
        eraserInfo.size = 20.0f;
        this.mSpenMulitView.setEraserSettingInfo(2, eraserInfo);
        this.mSettingView.setEraserInfo(eraserInfo);
        this.mSettingView.setEraserListener(new SpenSettingEraserLayout.EventListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout3.7
            @Override // com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.EventListener
            public void onClearAll() throws Resources.NotFoundException {
                DocsMenuViewLayout3.this.mClearAlertView = new AlertView(MainApplication.mContext);
                DocsMenuViewLayout3.this.mClearAlertView.setTitle(C0000R.string.screenshare_alertView_attention_title);
                DocsMenuViewLayout3.this.mClearAlertView.setMessage(C0000R.string.screenshare_alertView_attention_message);
                DocsMenuViewLayout3.this.mClearAlertView.setPositiveButton(C0000R.string.ok, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout3.7.1
                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                    public void onClick(AlertView dialog, int which) {
                        DocsMenuViewLayout3.this.EraseAllDrawInView();
                        DocsMenuViewLayout3.this.clearPageData();
                        SpenSettingEraserLayout layout = DocsMenuViewLayout3.this.mSettingView.getSpenSettingEraserLayout();
                        layout.setVisibility(8);
                        DocsMenuViewLayout3.this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARPAGE, null);
                    }
                });
                DocsMenuViewLayout3.this.mClearAlertView.setNegativeButton(C0000R.string.cancel, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout3.7.2
                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                    public void onClick(AlertView dialog, int which) {
                    }
                });
                DocsMenuViewLayout3.this.mClearAlertView.setCancelable(true);
                DocsMenuViewLayout3.this.mClearAlertView.show();
            }
        });
        this.mSpenMulitView.setToolTypeAction(2, 1, 0);
        this.mSpenMulitView.setToolTypeAction(2, 2, 2);
        this.mIsFingerDrawing = false;
        this.mDocsViewModeBtn.setSelected(true);
        this.mPenBtn.setSelected(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPageData() {
        logI("<CIH> mCurrentPage = " + this.mCurrentPage);
        if (this.mDataController != null) {
            this.mDataController.removeBoardDataInPage(this.mCurrentPage);
        }
    }

    public void setIsChangingPenMode(boolean isChangingPenMode) {
        this.mIsChangingPenMode = isChangingPenMode;
    }

    public void setPenDocsMode(boolean isPenMode) {
        logI("<CIH> setPenDocsMode() isPenMode = " + isPenMode + ", mIsChangingPenMode = " + this.mIsChangingPenMode);
        this.mDocsPenMode = isPenMode;
        if (isPenMode) {
            if (this.mDocsViewModeBtn.isSelected()) {
                this.mIsFingerDrawing = true;
                updateBtnState(this.mPenBtn);
                if (this.mOnSendCommandData != null && this.mIsChangingPenMode) {
                    this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_DRAWING_REQ_MODE, null);
                    this.mIsChangingPenMode = false;
                }
                this.mSpenMulitView.setToolTypeAction(2, 1, 2);
                this.mSpenMulitView.setToolTypeAction(2, 2, 2);
                return;
            }
            return;
        }
        this.mIsFingerDrawing = false;
        this.mSettingView.closeSettingView();
        updateBtnState(this.mDocsViewModeBtn);
        if (this.mOnSendCommandData != null && this.mIsChangingPenMode) {
            this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_MODE, null);
            this.mIsChangingPenMode = false;
        }
        this.mSpenMulitView.setToolTypeAction(2, 1, 0);
        this.mSpenMulitView.setToolTypeAction(2, 2, 0);
    }

    private void addDrawPenData() {
        if (this.mNoInitialData.size() > 0) {
            for (int i = 0; i < this.mNoInitialData.size(); i++) {
                PenWriteNetwork.shareSAMMStrokePoint SAMMStrokePoint = PenWriteNetwork.parseSAMMStrokePoint(this.mNoInitialData.get(i));
                if (SAMMStrokePoint != null) {
                    if (SAMMStrokePoint.Action == 0) {
                        gDownTime = SystemClock.uptimeMillis();
                    }
                } else {
                    logI("OnRecveData() SAMMStrokePoint is null");
                }
            }
            this.mNoInitialData.clear();
        }
    }

    @Override // com.coolots.chaton.call.screenshare.activity.ScreenShareLayout
    public void show() {
        logI("panda     show()");
        btnHidden(true);
        super.show();
    }

    private ArrayList<SpenObjectTextBox.TextSpanInfo> getDefaultSpanInfoList() {
        ArrayList<SpenObjectTextBox.TextSpanInfo> spans = new ArrayList<>();
        SpenObjectTextBox.FontSizeSpanInfo fs = new SpenObjectTextBox.FontSizeSpanInfo();
        fs.startPos = 0;
        fs.endPos = 0;
        fs.fontSize = this.mSpenMulitView.getTextSettingInfo().size;
        spans.add(fs);
        SpenObjectTextBox.ForegroundColorSpanInfo fc = new SpenObjectTextBox.ForegroundColorSpanInfo();
        fc.foregroundColor = -65536;
        fc.startPos = 0;
        fc.endPos = 0;
        spans.add(fc);
        return spans;
    }

    public static RectF convertAbsolute(SpenSurfaceView view, RectF srcRect) {
        PointF point = view.getPan();
        float ratio = view.getZoomRatio();
        srcRect.left = (srcRect.left / ratio) + point.x;
        srcRect.right = (srcRect.right / ratio) + point.x;
        srcRect.top = (srcRect.top / ratio) + point.y;
        srcRect.bottom = (srcRect.bottom / ratio) + point.y;
        return srcRect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtnState(View v) {
        this.mDocsViewModeBtn.setSelected(false);
        this.mPenBtn.setSelected(false);
        this.mEraserBtn.setSelected(false);
        v.setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUndoRedoBtnState() {
        this.mRedoBtn.setEnabled(this.mSpenPageDoc.isRedoable(2));
        this.mUndoBtn.setEnabled(this.mSpenPageDoc.isUndoable(2));
    }

    public void setUserID(int userid) {
        this.mUserID = userid;
    }

    @Override // com.coolots.chaton.call.screenshare.activity.ScreenShareLayout
    public void OnRecveData(int command, byte[] data) {
        logI("panda     OnRecveData():" + command);
        addBoardData(command, data);
        setDrawData(command, data);
    }

    public void setSpenSurfaceViewTouchListener() {
        this.mSpenMulitView.setOnTouchListener(new View.OnTouchListener() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout3.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if (DocsMenuViewLayout3.this.mIsFingerDrawing) {
                    DocsMenuViewLayout3.this.sendTouchEvent(event, 0, 0);
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EraseAllDrawInView() {
        if (this.mSpenMulitView != null) {
            SpenPageDoc.HistoryUpdateInfo[] userDataOther = this.mSpenPageDoc.undoAll(2);
            SpenPageDoc.HistoryUpdateInfo[] userData = this.mSpenPageDoc.undoAll(1);
            this.mSpenMulitView.updateUndo(userDataOther, 2);
            this.mSpenMulitView.updateUndo(userData, 1);
            this.mSpenPageDoc.clearHistory();
            updateUndoRedoBtnState();
        }
    }

    protected void sendTouchEvent(MotionEvent event, int multiObjectID, int sammMetaState) {
        if (this.mSpenMulitView != null) {
            if (event.getAction() == 0) {
                SpenSettingInfo spensettinginfo = new SpenSettingInfo(this.mSpenSettingMode, this.mSpenMulitView, 2);
                byte[] cmdData = SettingPacket.makeSettingStrokeInfo(2, spensettinginfo);
                if (this.mSpensettinginfo == null) {
                    this.mSpensettinginfo = SettingPacket.copySettingInfo(this.mSpenSettingMode, spensettinginfo);
                    onSendData(100, cmdData);
                } else {
                    this.mSpensettinginfo = SettingPacket.copySettingInfo(this.mSpenSettingMode, spensettinginfo);
                    onSendData(100, cmdData);
                }
            }
            if (this.mOnSendCommandData != null) {
                byte[] cmdData2 = PenWriteNetwork.makeSpenMotionEvent(2, multiObjectID, event);
                if (this.mSpenSettingMode != 3) {
                    logI("<CIH> 3");
                    logI("YKYU sendTouchEvent() -4-");
                    onSendData(300, cmdData2);
                }
            }
            updateUndoRedoBtnState();
            this.mSpenMulitView.invalidate();
        }
    }

    private void setDrawData(int command, byte[] data) {
        logE("YKYU setDrawData command = " + command);
        switch (command) {
            case 100:
                final MultiSettingStrokeInfo settingInfo = SettingPacket.parserSpenSettingStrokeInfo(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout3.10
                    @Override // java.lang.Runnable
                    public void run() {
                        settingInfo.spenSettingInfo.setSpenSettingInfoIntoSpenMultiView(DocsMenuViewLayout3.this.mSpenMulitView, DocsMenuViewLayout3.this.mSettingView, 1);
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO /* 150 */:
                PenWriteNetwork.shareSAMMMatrixData SAMMMatrixData = PenWriteNetwork.parseMatrixData(data);
                getMatrixInfo(SAMMMatrixData.matrixData);
                this.mSpenMulitView.setZoom(-(this.mDistanceX / this.mScaleRatio), -(this.mDistanceY / this.mScaleRatio), this.mScaleRatio);
                this.mSpenMulitView.setPan(new PointF(-(this.mDistanceX / this.mScaleRatio), -(this.mDistanceY / this.mScaleRatio)));
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO /* 203 */:
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout3.11
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            SpenPageDoc.HistoryUpdateInfo[] userData = DocsMenuViewLayout3.this.mSpenPageDoc.undo(1);
                            DocsMenuViewLayout3.this.mSpenMulitView.updateUndo(userData, 1);
                        } catch (Exception e) {
                            DocsMenuViewLayout3.this.logE("mSpenPageDoc.undo: " + e);
                        }
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO /* 204 */:
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout3.12
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            SpenPageDoc.HistoryUpdateInfo[] userData = DocsMenuViewLayout3.this.mSpenPageDoc.redo(1);
                            DocsMenuViewLayout3.this.mSpenMulitView.updateRedo(userData, 1);
                        } catch (Exception e) {
                            DocsMenuViewLayout3.this.logE("mSpenPageDoc.redo: " + e);
                        }
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARALL /* 205 */:
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout3.13
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DocsMenuViewLayout3.this.EraseAllDrawInView();
                        } catch (Exception e) {
                            DocsMenuViewLayout3.this.logE("mSCanvas.redo: " + e);
                        }
                        DocsMenuViewLayout3.this.initBoardDataController();
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARPAGE /* 206 */:
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout3.14
                    @Override // java.lang.Runnable
                    public void run() {
                        DocsMenuViewLayout3.this.EraseAllDrawInView();
                        DocsMenuViewLayout3.this.clearPageData();
                    }
                });
                break;
            case 300:
                final PenWriteNetwork.shareSpenMotionEvent SpenMotionEvent = PenWriteNetwork.parseTransMotionEvent(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.DocsMenuViewLayout3.9
                    @Override // java.lang.Runnable
                    public void run() {
                        DocsMenuViewLayout3.this.logE("YKYU setDrawData SpenMotionEvent.action = " + SpenMotionEvent.action);
                        if (SpenMotionEvent != null) {
                            if (SpenMotionEvent.action == 0) {
                                DocsMenuViewLayout3.gDownTime = SystemClock.uptimeMillis();
                            }
                            DocsMenuViewLayout3.this.logE("YKYU setDrawData -1-");
                            SpenMotionEvent.f8pc[0].x = (((-1.0f) * DocsMenuViewLayout3.this.mDistanceX) + SpenMotionEvent.f8pc[0].x) / DocsMenuViewLayout3.this.mScaleRatio;
                            SpenMotionEvent.f8pc[0].y = (((-1.0f) * DocsMenuViewLayout3.this.mDistanceY) + SpenMotionEvent.f8pc[0].y) / DocsMenuViewLayout3.this.mScaleRatio;
                            MotionEvent event = MotionEvent.obtain(DocsMenuViewLayout3.gDownTime, DocsMenuViewLayout3.gDownTime + SpenMotionEvent.eventtime, SpenMotionEvent.action, 1, SpenMotionEvent.f9pp, SpenMotionEvent.f8pc, SpenMotionEvent.metastate, SpenMotionEvent.buttonstate, SpenMotionEvent.xprecision, SpenMotionEvent.yprecision, SpenMotionEvent.deviceid, SpenMotionEvent.edgeflags, SpenMotionEvent.source, SpenMotionEvent.flags);
                            DocsMenuViewLayout3.this.mSpenMulitView.onTouchEvent(1, event);
                        }
                    }
                });
                break;
        }
    }

    private void getMatrixInfo(Matrix matrix) {
        float[] matrixVal = new float[9];
        matrix.getValues(matrixVal);
        this.mScaleRatio = matrixVal[0];
        this.mDistanceX = matrixVal[2];
        this.mDistanceY = matrixVal[5];
        logI("YKYU scaleRatio = " + this.mScaleRatio);
        logI("YKYU distanceX = " + this.mDistanceX);
        logI("YKYU distanceY = " + this.mDistanceY);
    }

    public void penToolbarResize() {
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
        if (this.mDocsViewModeBtn != null) {
            this.mDocsViewModeBtn.removeCallbacks(null);
            this.mDocsViewModeBtn = null;
        }
        if (this.mPenBtn != null) {
            this.mPenBtn.removeCallbacks(null);
            this.mPenBtn = null;
        }
        if (this.mPenColor != null) {
            this.mPenColor.removeCallbacks(null);
            this.mPenColor = null;
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
        if (this.mPenWritingCapture != null) {
            this.mPenWritingCapture = null;
        }
        if (this.mScreenShareActivity != null) {
            this.mScreenShareActivity = null;
        }
        if (this.mDataController != null) {
            this.mDataController.dispose();
            this.mDataController = null;
        }
    }

    private void getPageCanvas(int page) {
        logI("panda     getPageCanvas : " + page);
        this.mDataController.getCurrentContainer(page);
        EraseAllDrawInView();
        if (this.mDataController != null) {
            ArrayList<BoardData> boardData = this.mDataController.getCurrentPageData(page);
            logI("panda     getPageCanvas : " + boardData);
            if (boardData != null) {
                logI("panda     getPageCanvas size : " + boardData.size());
                Iterator<BoardData> it = boardData.iterator();
                while (it.hasNext()) {
                    BoardData data = it.next();
                    setDrawData(data.getType(), data.getData());
                }
            }
        }
    }

    private void addBoardData(int type, byte[] data) {
        if (this.mDataController != null) {
            this.mDataController.addBoardData(this.mCurrentPage, type, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSendData(int type, byte[] data) {
        if (this.mOnSendCommandData != null) {
            this.mOnSendCommandData.onSendData(type, data);
            addBoardData(type, data);
        }
    }

    public void onOtherPartyPage(int page) {
        logI("panda     onOtherPartyPage data  page: " + page);
        this.mCurrentPage = page;
        getPageCanvas(page);
    }

    public void initBoardDataController() {
        logE("panda     initBoardDataController");
        if (this.mDataController != null) {
            this.mDataController.dispose();
            this.mDataController = null;
        }
        this.mDataController = new BoardDataController();
    }
}
