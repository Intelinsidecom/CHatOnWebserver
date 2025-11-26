package com.coolots.chaton.call.screenshare;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.screenshare.core.OverlayView;
import com.coolots.chaton.call.screenshare.util.AlertView;
import com.coolots.chaton.call.screenshare.util.BoardData;
import com.coolots.chaton.call.screenshare.util.BoardDataController;
import com.coolots.chaton.call.screenshare.util.IDocsViewTouchImage;
import com.coolots.chaton.call.screenshare.util.MultiSettingStrokeInfo;
import com.coolots.chaton.call.screenshare.util.PageSettingAlertView;
import com.coolots.chaton.call.screenshare.util.PenWriteNetwork;
import com.coolots.chaton.call.screenshare.util.PenWritingCapture;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.coolots.chaton.call.screenshare.util.ScreenShareRemotePacket;
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
import com.samsung.android.sdk.pen.engine.SpenMultiView;
import com.samsung.android.sdk.pen.engine.SpenPenChangeListener;
import com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class DocsMenuView3 extends OverlayView implements DisposeInterface {
    private static final String CLASSNAME = "[DocsMenuView] ";
    private static final int HIDE_DOCS_VIEW_INFO = 1000;
    private static final int OTHERID = 2;
    private static final int SHARERID = 1;
    public static final int SWIPE_MAX_OFF_PATH = 250;
    public static final int SWIPE_MIN_DISTANCE = 120;
    public static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private static long gDownTime;
    private boolean isFlinkUpDown;
    private boolean isHidden;
    private boolean isRedrawEventData;
    private boolean isSpenFeatureEnabled;
    private PageSettingAlertView mAlertView;
    private View.OnClickListener mBtnClickListener;
    private RelativeLayout mCanvasLayout;
    private ImageView mCaptureBtn;
    private AlertView mClearAlertView;
    private BoardDataController mDataController;
    private boolean mDialogHasFocus;
    private int mDisMaxSize;
    private int mDisMinSize;
    private Button mDocsMenuViewInfo;
    private DocsMenuViewInfoHandler mDocsMenuViewInfoHandler;
    private ImageView mDocsViewBtn;
    private Button mEndBtn;
    private ImageView mEraserBtn;
    private Handler mHandler;
    private ImageView mHideBtn;
    private IDocsViewTouchImage mIDocsViewTouchImage;
    private int mInputMode;
    private boolean mIsDocsviewMode;
    private boolean mIsFingerDrawing;
    private boolean mIsPenMode;
    private boolean mIsSelectedFile;
    private boolean mIsTouch;
    private ImageView mPenBtn;
    private RelativeLayout mPenBtnLayout;
    private View mPenColor;
    private PenWritingCapture mPenWritingCapture;
    private ImageView mRedoBtn;
    private int mScreenHeight;
    private ScreenShareScale mScreenScale;
    private int mScreenWidth;
    private SettingView mSettingView;
    private SpenMultiView mSpenMulitView;
    private SpenNoteDoc mSpenNoteDoc;
    private SpenPageDoc mSpenPageDoc;
    private int mSpenSettingMode;
    private SpenSettingInfo mSpensettinginfo;
    private int mTempCur;
    private int mTempMax;
    private RelativeLayout mToolBarLayout;
    private LinearLayout mToolbarBtnLayout;
    private LinearLayout mToolbarCaptureLayout;
    private ImageView mUndoBtn;
    private View.OnClickListener undoNredoBtnClickListener;
    public WindowManager windowManager;

    /* JADX INFO: Access modifiers changed from: private */
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public DocsMenuView3(Context context, IDocsViewTouchImage Idocsviewtouchimage) {
        super(context, C0000R.layout.screenshare_docs_view_v3);
        this.mHandler = new Handler();
        this.isHidden = false;
        this.mSpensettinginfo = null;
        this.isFlinkUpDown = true;
        this.windowManager = null;
        this.mIsPenMode = false;
        this.mIsSelectedFile = false;
        this.mDialogHasFocus = false;
        this.mIsDocsviewMode = false;
        this.mIsTouch = false;
        this.mIsFingerDrawing = false;
        this.mSpenSettingMode = 1;
        this.isRedrawEventData = false;
        this.isSpenFeatureEnabled = false;
        this.mInputMode = 1;
        this.mBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView3.1
            int fingerAction;
            int settingViewSize;
            int spenAction;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws Resources.NotFoundException {
                DocsMenuView3.this.logI("onClick");
                if (DocsMenuView3.this.mSpenMulitView.getToolTypeAction(2) == 5) {
                    DocsMenuView3.this.mSettingView.closeSettingView();
                }
                if (view.equals(DocsMenuView3.this.mDocsViewBtn)) {
                    DocsMenuView3.this.logI("<CIH> mIsFingerDrawing = " + DocsMenuView3.this.mIsFingerDrawing);
                    if (DocsMenuView3.this.mIsFingerDrawing) {
                        DocsMenuView3.this.mSpenMulitView.setToolTypeAction(1, 1, 1);
                        DocsMenuView3.this.mIsFingerDrawing = false;
                    } else {
                        DocsMenuView3.this.mSpenMulitView.setToolTypeAction(1, 1, 1);
                    }
                    this.spenAction = 1;
                    DocsMenuView3.this.setNormalMode(true);
                    DocsMenuView3.this.setInputMode(5);
                    DocsMenuView3.this.updateBtnState(view);
                    return;
                }
                if (!view.equals(DocsMenuView3.this.mPenBtn)) {
                    if (!view.equals(DocsMenuView3.this.mEraserBtn)) {
                        if (DocsMenuView3.this.mEndBtn != null && view.equals(DocsMenuView3.this.mEndBtn)) {
                            DocsMenuView3.this.logI("PenWriting EndBtn Clicked ");
                            DocsMenuView3.this.mIsSelectedFile = false;
                            DocsMenuView3.this.mIDocsViewTouchImage.finishDocsView();
                            return;
                        }
                        if (DocsMenuView3.this.mDocsMenuViewInfo == null || !view.equals(DocsMenuView3.this.mDocsMenuViewInfo)) {
                            if (view.equals(DocsMenuView3.this.mCaptureBtn)) {
                                DocsMenuView3.this.logI("PenWritingCapture is Clicked!!");
                                int res = DocsMenuView3.this.mPenWritingCapture.ScreenOtherCapture();
                                if (res < 0) {
                                    ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_pen_writing_capture_fail), 0);
                                    return;
                                } else {
                                    ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_pen_writing_capture), 0);
                                    return;
                                }
                            }
                            if (view.equals(DocsMenuView3.this.mHideBtn)) {
                                DocsMenuView3.this.mSettingView.closeSettingView();
                                DocsMenuView3.this.btnHidden(DocsMenuView3.this.isHidden);
                                return;
                            }
                        } else {
                            DocsMenuView3.this.showDialogForPageSetting();
                            return;
                        }
                    } else {
                        DocsMenuView3.this.mIsFingerDrawing = true;
                        DocsMenuView3.this.mSpenSettingMode = 2;
                        this.fingerAction = 3;
                        if (DocsMenuView3.this.mSpenMulitView.getToolTypeAction(1, 2) != 3) {
                            DocsMenuView3.this.mSettingView.closeSettingView();
                        } else {
                            DocsMenuView3.this.mSettingView.toggleShowSettingView(DocsMenuView3.this.mSpenSettingMode, this.settingViewSize);
                        }
                        this.spenAction = 3;
                        this.settingViewSize = 0;
                        DocsMenuView3.this.setNormalMode(false);
                        DocsMenuView3.this.setInputMode(2);
                    }
                } else {
                    DocsMenuView3.this.mIsFingerDrawing = true;
                    DocsMenuView3.this.mSpenSettingMode = 1;
                    this.fingerAction = 2;
                    if (DocsMenuView3.this.mSpenMulitView.getToolTypeAction(1, 2) != 2) {
                        DocsMenuView3.this.mSettingView.closeSettingView();
                    } else {
                        DocsMenuView3.this.mSettingView.toggleShowSettingView(DocsMenuView3.this.mSpenSettingMode, this.settingViewSize);
                    }
                    this.spenAction = 2;
                    this.settingViewSize = 2;
                    DocsMenuView3.this.setNormalMode(false);
                    DocsMenuView3.this.setInputMode(1);
                }
                if (DocsMenuView3.this.mSpenMulitView.getToolTypeAction(2) != this.spenAction && !DocsMenuView3.this.mIsFingerDrawing) {
                    this.fingerAction = 1;
                }
                DocsMenuView3.this.mSpenMulitView.setToolTypeAction(1, 1, this.fingerAction);
                DocsMenuView3.this.mSpenMulitView.setToolTypeAction(1, 2, this.spenAction);
                DocsMenuView3.this.updateBtnState(view);
                DocsMenuView3.this.updateUndoRedoBtnState();
            }
        };
        this.undoNredoBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView3.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DocsMenuView3.this.logI("undoNredoBtnClickListener()");
                byte[] cmdData = PenWriteNetwork.intToByte(DocsMenuView3.this.mUserId);
                DocsMenuView3.this.logE("panda     undoNredoBtnClickListener");
                DocsMenuView3.this.logE("panda     mSpenPageDoc.isUndoable() = " + DocsMenuView3.this.mSpenPageDoc.isUndoable(1));
                DocsMenuView3.this.logE("panda     mSpenPageDoc.isRedoable() = " + DocsMenuView3.this.mSpenPageDoc.isRedoable(1));
                if (!v.equals(DocsMenuView3.this.mUndoBtn) || !DocsMenuView3.this.mSpenPageDoc.isUndoable(1)) {
                    if (v.equals(DocsMenuView3.this.mRedoBtn) && DocsMenuView3.this.mSpenPageDoc.isRedoable(1)) {
                        DocsMenuView3.this.logE("panda     mSpenPageDoc.isRedoable()");
                        SpenPageDoc.HistoryUpdateInfo[] userData = DocsMenuView3.this.mSpenPageDoc.redo(1);
                        DocsMenuView3.this.mSpenMulitView.updateRedo(userData, 1);
                        DocsMenuView3.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO, cmdData);
                    }
                } else {
                    SpenPageDoc.HistoryUpdateInfo[] userData2 = DocsMenuView3.this.mSpenPageDoc.undo(1);
                    DocsMenuView3.this.mSpenMulitView.updateUndo(userData2, 1);
                    DocsMenuView3.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO, cmdData);
                }
                DocsMenuView3.this.updateUndoRedoBtnState();
            }
        };
        this.mDocsMenuViewInfoHandler = new DocsMenuViewInfoHandler();
        this.mIDocsViewTouchImage = Idocsviewtouchimage;
        Spen spenSdk = new Spen();
        try {
            spenSdk.initialize(context);
            this.isSpenFeatureEnabled = spenSdk.isFeatureEnabled(0);
            Point disSize = new Point();
            if (this.windowManager == null) {
                this.windowManager = (WindowManager) getContext().getSystemService("window");
            }
            this.windowManager.getDefaultDisplay().getSize(disSize);
            this.mDisMaxSize = disSize.x > disSize.y ? disSize.x : disSize.y;
            this.mDisMinSize = disSize.x > disSize.y ? disSize.y : disSize.x;
            initScaleData();
            load();
            this.mIsSelectedFile = false;
            this.mDataController = ScreenShareProc.mInstance.getBoardDataController();
            getPageCanvas(0);
            showDocsViewInfo();
            hideDocsViewInfo();
        } catch (SsdkUnsupportedException e) {
            e.printStackTrace();
            stopScreenShare();
        } catch (Exception e1) {
            e1.printStackTrace();
            stopScreenShare();
        }
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
        RelativeLayout.LayoutParams toolbarLayoutParams = (RelativeLayout.LayoutParams) this.mToolBarLayout.getLayoutParams();
        toolbarLayoutParams.width = this.mDisMinSize;
        this.mToolBarLayout.setLayoutParams(toolbarLayoutParams);
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void onInflateView() {
        logI("onInflateView()");
        this.mPenWritingCapture = new PenWritingCapture();
        initToolBtn();
        initPage();
        initSettingInfo();
    }

    public void initToolBtn() {
        this.mDocsViewBtn = (ImageView) findViewById(C0000R.id.docs_view_mode_btn_docs);
        this.mPenBtn = (ImageView) findViewById(C0000R.id.pen_btn_docs);
        this.mPenColor = findViewById(C0000R.id.pen_color_bar_docs);
        this.mEraserBtn = (ImageView) findViewById(C0000R.id.eraser_btn_docs);
        this.mUndoBtn = (ImageView) findViewById(C0000R.id.undo_btn_docs);
        this.mRedoBtn = (ImageView) findViewById(C0000R.id.redo_btn_docs);
        this.mCaptureBtn = (ImageView) findViewById(C0000R.id.camera_btn_docs);
        this.mEndBtn = (Button) findViewById(C0000R.id.end_btn_docs);
        this.mHideBtn = (ImageView) findViewById(C0000R.id.showhide_btn_docs);
        this.mToolBarLayout = (RelativeLayout) findViewById(C0000R.id.share_view_toolbar_layout1_docs);
        this.mPenBtnLayout = (RelativeLayout) findViewById(C0000R.id.pen_btn_layout_docs);
        this.mDocsViewBtn.setOnClickListener(this.mBtnClickListener);
        this.mPenBtn.setOnClickListener(this.mBtnClickListener);
        this.mEraserBtn.setOnClickListener(this.mBtnClickListener);
        this.mCaptureBtn.setOnClickListener(this.mBtnClickListener);
        this.mEndBtn.setOnClickListener(this.mBtnClickListener);
        this.mHideBtn.setOnClickListener(this.mBtnClickListener);
        this.mUndoBtn.setOnClickListener(this.undoNredoBtnClickListener);
        this.mRedoBtn.setOnClickListener(this.undoNredoBtnClickListener);
        this.mUndoBtn.setEnabled(false);
        this.mRedoBtn.setEnabled(true);
        this.mDocsMenuViewInfo = (Button) findViewById(C0000R.id.docs_menuview_info_text);
        this.mDocsMenuViewInfo.setOnClickListener(this.mBtnClickListener);
        this.mToolbarBtnLayout = (LinearLayout) findViewById(C0000R.id.share_view_toolbar_layout_docs);
        this.mToolbarCaptureLayout = (LinearLayout) findViewById(C0000R.id.camera_btn_layout_docs);
    }

    private void stopScreenShare() {
        if (this.mIDocsViewTouchImage == null) {
            MainApplication.mPhoneManager.getShareScreenManager().stopShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination());
            ScreenShareProc.stopScreenShare();
        } else {
            this.mIDocsViewTouchImage.finishDocsView();
        }
    }

    void initPage() {
        this.mCanvasLayout = (RelativeLayout) findViewById(C0000R.id.canvasLayout);
        FrameLayout settingViewParent = (FrameLayout) findViewById(C0000R.id.canvas_container);
        try {
            this.mSpenMulitView = new SpenMultiView(this.mContext);
            this.mSpenMulitView.setLocalUserId(1);
            this.mSpenMulitView.addUser(2);
            setSpenSurfaceViewTouchListener();
            this.mCanvasLayout.addView(this.mSpenMulitView);
            this.mSpenMulitView.setMinZoomRatio(1.0f);
            this.mIDocsViewTouchImage.setSCanvas(this.mSpenMulitView);
            this.mSettingView = new SettingView(this.mContext, this.mCanvasLayout);
            settingViewParent.addView(this.mSettingView);
            this.mSettingView.setCanvasView(this.mSpenMulitView);
            try {
                Display display = this.windowManager.getDefaultDisplay();
                Rect rect = new Rect();
                display.getRectSize(rect);
                this.mScreenWidth = rect.width();
                this.mScreenHeight = rect.height();
                this.mSpenNoteDoc = new SpenNoteDoc(this.mContext, this.mScreenWidth, this.mScreenHeight);
                this.mSpenPageDoc = this.mSpenNoteDoc.appendPage();
                this.mSpenPageDoc.setHistoryManagerMode(1);
                this.mSpenPageDoc.setBackgroundColor(0);
                this.mSpenPageDoc.setBackgroundImageMode(3);
                this.mSpenPageDoc.clearHistory();
                if (!this.isSpenFeatureEnabled) {
                    this.mSpenMulitView.setToolTypeAction(1, 2);
                }
            } catch (IOException e) {
                e.printStackTrace();
                this.mIDocsViewTouchImage.finishDocsView();
            } catch (Exception e2) {
                e2.printStackTrace();
                this.mIDocsViewTouchImage.finishDocsView();
            }
            this.mSpenMulitView.setPageDoc(this.mSpenPageDoc, true);
            this.mSpenPageDoc.setHistoryListener(new SpenPageDoc.HistoryListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView3.3
                @Override // com.samsung.android.sdk.pen.document.SpenPageDoc.HistoryListener
                public void onCommit(SpenPageDoc page) {
                }

                @Override // com.samsung.android.sdk.pen.document.SpenPageDoc.HistoryListener
                public void onRedoable(SpenPageDoc page, boolean redoable) {
                    DocsMenuView3.this.logE("panda     onRedoable redoable = " + redoable);
                    DocsMenuView3.this.mRedoBtn.setEnabled(redoable);
                }

                @Override // com.samsung.android.sdk.pen.document.SpenPageDoc.HistoryListener
                public void onUndoable(SpenPageDoc page, boolean undoable) {
                    DocsMenuView3.this.logE("panda     onUndoable undoable = " + undoable);
                    DocsMenuView3.this.mUndoBtn.setEnabled(undoable);
                }
            });
        } catch (Exception e3) {
            e3.printStackTrace();
            stopScreenShare();
        } catch (UnsatisfiedLinkError error) {
            error.printStackTrace();
            stopScreenShare();
        }
    }

    void initSettingInfo() {
        SpenSettingPenInfo penInfo = this.mSpenMulitView.getPenSettingInfo(1);
        penInfo.color = -15527149;
        penInfo.size = 20.0f;
        this.mSpenMulitView.setPenSettingInfo(1, penInfo);
        this.mSettingView.setSpenPenInfo(penInfo);
        this.mPenColor.setBackgroundColor(penInfo.color);
        this.mSpenMulitView.setPenChangeListener(new SpenPenChangeListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView3.4
            @Override // com.samsung.android.sdk.pen.engine.SpenPenChangeListener
            public void onChanged(SpenSettingPenInfo penInfo2) {
                DocsMenuView3.this.logI("<CIH> onChanged");
                DocsMenuView3.this.mPenColor.setBackgroundColor(penInfo2.color);
                if (DocsMenuView3.this.mSpenMulitView != null) {
                    DocsMenuView3.this.mSpenMulitView.setPenSettingInfo(1, penInfo2);
                }
            }
        });
        SpenSettingEraserInfo eraserInfo = this.mSpenMulitView.getEraserSettingInfo(1);
        eraserInfo.size = 20.0f;
        this.mSpenMulitView.setEraserSettingInfo(1, eraserInfo);
        this.mSettingView.setEraserInfo(eraserInfo);
        this.mSettingView.setEraserListener(new SpenSettingEraserLayout.EventListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView3.5
            @Override // com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.EventListener
            public void onClearAll() throws Resources.NotFoundException {
                DocsMenuView3.this.mClearAlertView = new AlertView(MainApplication.mContext);
                DocsMenuView3.this.mClearAlertView.setTitle(C0000R.string.screenshare_alertView_attention_title);
                DocsMenuView3.this.mClearAlertView.setMessage(C0000R.string.screenshare_alertView_attention_message);
                DocsMenuView3.this.mClearAlertView.setPositiveButton(C0000R.string.ok, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView3.5.1
                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                    public void onClick(AlertView dialog, int which) {
                        DocsMenuView3.this.EraseAllDrawInView();
                        DocsMenuView3.this.clearPageData();
                        SpenSettingEraserLayout layout = DocsMenuView3.this.mSettingView.getSpenSettingEraserLayout();
                        layout.setVisibility(8);
                        DocsMenuView3.this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARPAGE, null);
                    }
                });
                DocsMenuView3.this.mClearAlertView.setNegativeButton(C0000R.string.cancel, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView3.5.2
                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                    public void onClick(AlertView dialog, int which) {
                    }
                });
                DocsMenuView3.this.mClearAlertView.setCancelable(true);
                DocsMenuView3.this.mClearAlertView.show();
            }
        });
        setInputMode(5);
        this.mIsFingerDrawing = false;
        this.mDocsViewBtn.setSelected(true);
        this.mPenBtn.setSelected(false);
        SpenSettingInfo spensettinginfo = new SpenSettingInfo(this.mSpenSettingMode, this.mSpenMulitView, 1);
        if (this.mSpensettinginfo == null) {
            this.mSpensettinginfo = SettingPacket.copySettingInfo(this.mSpenSettingMode, spensettinginfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPageData() {
        if (this.mDataController != null) {
            this.mDataController.removeBoardDataInPage(this.mIDocsViewTouchImage.getCurrentPageNumber());
        }
    }

    public void setBackGroudSyncImageTouchView() {
    }

    private void onStartSettingViewInfo() {
    }

    public void setIChatOnSCanvasView(IDocsViewTouchImage Idocsviewtouchimage) {
        this.mIDocsViewTouchImage = Idocsviewtouchimage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtnState(View view) {
        if (this.mDocsViewBtn != null) {
            this.mDocsViewBtn.setSelected(false);
        }
        if (this.mPenBtn != null) {
            this.mPenBtn.setSelected(false);
        }
        if (this.mEraserBtn != null) {
            this.mEraserBtn.setSelected(false);
        }
        if (view != null) {
            view.setSelected(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUndoRedoBtnState() {
        if (this.mUndoBtn != null) {
            this.mUndoBtn.setEnabled(this.mSpenPageDoc.isUndoable(1));
        }
        if (this.mRedoBtn != null) {
            this.mRedoBtn.setEnabled(this.mSpenPageDoc.isRedoable(1));
        }
    }

    private void closeSettingView() {
    }

    private void setMenuIconSelected(int menuIconId) {
        if (menuIconId == this.mDocsViewBtn.getId()) {
            this.mDocsViewBtn.setSelected(true);
            this.mPenBtn.setSelected(false);
            this.mEraserBtn.setSelected(false);
            this.mUndoBtn.setEnabled(false);
            return;
        }
        if (menuIconId == this.mPenBtn.getId()) {
            this.mDocsViewBtn.setSelected(false);
            this.mPenBtn.setSelected(true);
            this.mEraserBtn.setSelected(false);
            this.mUndoBtn.setEnabled(this.mSpenPageDoc.isUndoable(1));
            this.mRedoBtn.setEnabled(this.mSpenPageDoc.isRedoable(1));
            return;
        }
        if (menuIconId == this.mEraserBtn.getId()) {
            this.mDocsViewBtn.setSelected(false);
            this.mPenBtn.setSelected(false);
            this.mEraserBtn.setSelected(true);
            this.mUndoBtn.setEnabled(this.mSpenPageDoc.isUndoable(1));
            this.mRedoBtn.setEnabled(this.mSpenPageDoc.isRedoable(1));
        }
    }

    public void setUserID(int userid) {
        logI("setUserID()");
        this.mUserId = userid;
    }

    public void setNormalMode(boolean isNormal) {
        if (this.mSpenMulitView != null) {
            logI("<CIH> setNormalMode(), isNormal = " + isNormal);
            if (isNormal) {
                logI("  ========setNormalMode====  SCREEN_SHARE_CMD_DOCS_VIEW_MODE ");
                if (this.mOnSendCommandData != null) {
                    this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_MODE, null);
                }
                this.mIsFingerDrawing = false;
                this.mSettingView.closeSettingView();
                updateBtnState(this.mDocsViewBtn);
                this.mSpenMulitView.setToolTypeAction(1, 1, 1);
                this.mSpenMulitView.setToolTypeAction(1, 2, 1);
                return;
            }
            logI("  ========setNormalMode====  SCREEN_SHARE_CMD_DOCS_VIEW_DRAWING_REQ_MODE ");
            if (this.mDocsViewBtn.isSelected()) {
                if (this.mOnSendCommandData != null) {
                    this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_DRAWING_REQ_MODE, null);
                }
                this.mIsFingerDrawing = true;
                updateBtnState(this.mPenBtn);
                this.mSpenMulitView.setToolTypeAction(1, 1, 2);
                this.mSpenMulitView.setToolTypeAction(1, 2, 2);
            }
        }
    }

    private int getInputMode() {
        return this.mInputMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInputMode(int mode) {
        this.mInputMode = mode;
        if (mode == 2) {
            this.mSpenMulitView.setToolTypeAction(2, 3);
            this.mSpenMulitView.setToolTypeAction(1, 1);
        } else if (mode == 1) {
            this.mSpenMulitView.setToolTypeAction(2, 2);
            this.mSpenMulitView.setToolTypeAction(1, 1);
        } else if (mode == 5) {
            this.mSpenMulitView.setToolTypeAction(2, 6);
            this.mSpenMulitView.setToolTypeAction(1, 1);
        }
    }

    public void setDocsViewMode(boolean isDocsViewMode) {
        this.mIsDocsviewMode = isDocsViewMode;
    }

    public boolean getDocsViewMode() {
        return this.mIsDocsviewMode;
    }

    public void showStartDocsView() {
        this.mIsSelectedFile = true;
        MainApplication.mPhoneManager.getShareScreenManager().resumeShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), null, true);
        onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_MODE, null);
    }

    public void OnUserLeaveHintDocsView() {
        this.mIsSelectedFile = false;
    }

    public void onOtherPartyPage(int page) {
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    public void OnRecveData(int command, byte[] data) {
        logI("OnRecveData()");
        this.isRedrawEventData = false;
        addBoardData(command, data);
        setDrawData(command, data);
    }

    private void setDrawData(int command, byte[] data) {
        logI("setDrawData()");
        switch (command) {
            case 100:
                final MultiSettingStrokeInfo settingInfo = SettingPacket.parserSpenSettingStrokeInfo(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView3.7
                    @Override // java.lang.Runnable
                    public void run() {
                        settingInfo.spenSettingInfo.setSpenSettingInfoIntoSpenMultiView(DocsMenuView3.this.mSpenMulitView, DocsMenuView3.this.mSettingView, 2);
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO /* 203 */:
                PenWriteNetwork.byteToInt(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView3.8
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DocsMenuView3.this.logE("panda     SCREEN_SHARE_CMD_DRAWING_UNDO");
                            SpenPageDoc.HistoryUpdateInfo[] userData = DocsMenuView3.this.mSpenPageDoc.undo(2);
                            DocsMenuView3.this.mSpenMulitView.updateUndo(userData, 2);
                        } catch (Exception e) {
                            DocsMenuView3.this.logE("mSpenPageDoc.undo: " + e);
                        }
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO /* 204 */:
                PenWriteNetwork.byteToInt(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView3.9
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DocsMenuView3.this.logE("panda     SCREEN_SHARE_CMD_DRAWING_REDO");
                            SpenPageDoc.HistoryUpdateInfo[] userData = DocsMenuView3.this.mSpenPageDoc.redo(2);
                            DocsMenuView3.this.mSpenMulitView.updateRedo(userData, 2);
                        } catch (Exception e) {
                            DocsMenuView3.this.logE("mSpenPageDoc.redo: " + e);
                        }
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARALL /* 205 */:
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView3.10
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DocsMenuView3.this.EraseAllDrawInView();
                        } catch (Exception e) {
                            DocsMenuView3.this.logE("mSCanvas.redo: " + e);
                        }
                        DocsMenuView3.this.initBoardDataController();
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARPAGE /* 206 */:
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView3.11
                    @Override // java.lang.Runnable
                    public void run() {
                        DocsMenuView3.this.EraseAllDrawInView();
                        DocsMenuView3.this.clearPageData();
                    }
                });
                break;
            case 300:
                final PenWriteNetwork.shareSpenMotionEvent SpenMotionEvent = PenWriteNetwork.parseTransMotionEvent(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView3.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SpenMotionEvent != null) {
                            DocsMenuView3.this.logE("YKYU setDrawData SpenMotionEvent.action = " + SpenMotionEvent.action);
                            if (SpenMotionEvent.action == 0) {
                                DocsMenuView3.gDownTime = SystemClock.uptimeMillis();
                            }
                            Matrix matrix = DocsMenuView3.this.mIDocsViewTouchImage.getMatrix();
                            float[] values = new float[9];
                            matrix.getValues(values);
                            SpenMotionEvent.f8pc[0].x = (((-1.0f) * values[2]) + SpenMotionEvent.f8pc[0].x) / values[0];
                            SpenMotionEvent.f8pc[0].y = (((-1.0f) * values[5]) + SpenMotionEvent.f8pc[0].y) / values[0];
                            MotionEvent event = MotionEvent.obtain(DocsMenuView3.gDownTime, DocsMenuView3.gDownTime + SpenMotionEvent.eventtime, SpenMotionEvent.action, 1, SpenMotionEvent.f9pp, SpenMotionEvent.f8pc, SpenMotionEvent.metastate, SpenMotionEvent.buttonstate, SpenMotionEvent.xprecision, SpenMotionEvent.yprecision, SpenMotionEvent.deviceid, SpenMotionEvent.edgeflags, SpenMotionEvent.source, SpenMotionEvent.flags);
                            DocsMenuView3.this.logI("YKYU setDrawData() multiUserID = " + SpenMotionEvent.multiUserID);
                            DocsMenuView3.this.logI("YKYU setDrawData() multiUserID mSpenMulitView.getLocalUserId() = " + DocsMenuView3.this.mSpenMulitView.getLocalUserId());
                            DocsMenuView3.this.mSpenMulitView.onTouchEvent(2, event);
                        }
                    }
                });
                break;
        }
    }

    protected void sendTouchEvent(MotionEvent event, int multiObjectID, int sammMetaState) {
        if (this.mIsTouch) {
            logI("YKYU sendTouchEvent : mIsFingerDrawing = " + this.mIsFingerDrawing);
            if (this.mIsFingerDrawing) {
                if (this.mSpenMulitView != null) {
                    if (event.getAction() == 0) {
                        SpenSettingInfo spensettinginfo = new SpenSettingInfo(this.mSpenSettingMode, this.mSpenMulitView, 1);
                        byte[] cmdData = SettingPacket.makeSettingStrokeInfo(1, spensettinginfo);
                        if (this.mSpensettinginfo == null) {
                            this.mSpensettinginfo = SettingPacket.copySettingInfo(this.mSpenSettingMode, spensettinginfo);
                            onSendData(100, cmdData);
                        } else {
                            this.mSpensettinginfo = SettingPacket.copySettingInfo(this.mSpenSettingMode, spensettinginfo);
                            onSendData(100, cmdData);
                        }
                    }
                    if (this.mOnSendCommandData != null && this.mScreenScale != null) {
                        this.mScreenScale.modifyExpandScaleX(event.getRawX());
                        this.mScreenScale.modifyExpandScaleY(event.getRawY());
                        byte[] cmdData2 = PenWriteNetwork.makeSpenMotionEvent(1, multiObjectID, event);
                        if (this.mSpenSettingMode != 3) {
                            logI("YKYU sendTouchEvent() -4-");
                            onSendData(300, cmdData2);
                        }
                    }
                    updateUndoRedoBtnState();
                    this.mSpenMulitView.invalidate();
                    return;
                }
                return;
            }
            if (event.getAction() == 1 || event.getAction() == 6) {
                this.mIDocsViewTouchImage.TouchEvent(event);
                setPageInfo();
                hideDocsViewInfo();
                return;
            }
            this.mIDocsViewTouchImage.TouchEvent(event);
            setPageInfo();
            Matrix matrixDocs = this.mIDocsViewTouchImage.getMatrix();
            float[] matrixVal = new float[9];
            matrixDocs.getValues(matrixVal);
            float scaleRatio = matrixVal[0];
            float distanceX = matrixVal[2];
            float distanceY = matrixVal[5];
            logI("YKYU scaleRatio = " + scaleRatio);
            logI("YKYU distanceX = " + distanceX);
            logI("YKYU distanceY = " + distanceX);
            this.mSpenMulitView.setZoom(-(distanceX / scaleRatio), -(distanceY / scaleRatio), scaleRatio);
            this.mSpenMulitView.setPan(new PointF(-(distanceX / scaleRatio), -(distanceY / scaleRatio)));
            byte[] cmdData3 = PenWriteNetwork.makeSAMMMatrix(this.mUserId, matrixDocs);
            onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO, cmdData3);
        }
    }

    public void sendMatrix() {
        Matrix matrixDocs = this.mIDocsViewTouchImage.getMatrix();
        byte[] cmdData = PenWriteNetwork.makeSAMMMatrix(this.mUserId, matrixDocs);
        onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO, cmdData);
    }

    public void setPageInfo() {
        this.mDocsMenuViewInfo.setText(this.mIDocsViewTouchImage.getPageInfo());
        showDocsViewInfo();
    }

    public class DocsMenuViewInfoHandler extends Handler {
        public DocsMenuViewInfoHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1000:
                    DocsMenuView3.this.mDocsMenuViewInfo.setVisibility(8);
                    break;
            }
        }
    }

    private void showDocsViewInfo() {
        this.mDocsMenuViewInfoHandler.removeMessages(1000);
        if (this.mDocsMenuViewInfo.getVisibility() != 0) {
            this.mDocsMenuViewInfo.setVisibility(0);
        }
    }

    public void hideDocsViewInfo() {
        logI("Elcyde hideDocsViewInfo()");
        if (this.mDocsMenuViewInfo.getVisibility() == 0) {
            this.mDocsMenuViewInfoHandler.removeMessages(1000);
            this.mDocsMenuViewInfoHandler.sendEmptyMessageDelayed(1000, 2000L);
        }
    }

    public void setSpenSurfaceViewTouchListener() {
        this.mSpenMulitView.setOnTouchListener(new View.OnTouchListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView3.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if (!DocsMenuView3.this.mIsFingerDrawing) {
                    if (DocsMenuView3.this.mSpenMulitView.getMatrix() == null) {
                        DocsMenuView3.this.logI("YKYU matrix is null");
                    }
                    DocsMenuView3.this.mIDocsViewTouchImage.TouchEvent(event);
                    DocsMenuView3.this.sendTouchEvent(event, 0, 0);
                } else {
                    DocsMenuView3.this.sendTouchEvent(event, 0, 0);
                }
                return false;
            }
        });
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
    public void showDialogForPageSetting() throws Resources.NotFoundException {
        this.mTempCur = this.mIDocsViewTouchImage.getCurrentPageNumber() + 1;
        this.mTempMax = this.mIDocsViewTouchImage.getMaxPageNumber();
        this.mAlertView = new PageSettingAlertView(MainApplication.mContext);
        InputMethodManager imm = (InputMethodManager) this.mContext.getSystemService("input_method");
        imm.toggleSoftInput(2, 1);
        this.mAlertView.setTitle(C0000R.string.call_btn_share_screen);
        this.mAlertView.setPositiveButton(C0000R.string.ok, new PageSettingAlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView3.13
            @Override // com.coolots.chaton.call.screenshare.util.PageSettingAlertView.OnClickListener
            public void onClick(PageSettingAlertView dialog, int which) {
                DocsMenuView3.this.mIDocsViewTouchImage.setPageSwap(Integer.parseInt(DocsMenuView3.this.mAlertView.getPageText()));
                DocsMenuView3.this.setPageInfo();
                InputMethodManager imm2 = (InputMethodManager) DocsMenuView3.this.mContext.getSystemService("input_method");
                imm2.hideSoftInputFromWindow(DocsMenuView3.this.mAlertView.getTextView().getWindowToken(), 0);
            }
        });
        this.mAlertView.setNegativeButton(C0000R.string.cancel, new PageSettingAlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView3.14
            @Override // com.coolots.chaton.call.screenshare.util.PageSettingAlertView.OnClickListener
            public void onClick(PageSettingAlertView dialog, int which) {
                InputMethodManager imm2 = (InputMethodManager) DocsMenuView3.this.mContext.getSystemService("input_method");
                imm2.hideSoftInputFromWindow(DocsMenuView3.this.mAlertView.getTextView().getWindowToken(), 0);
            }
        });
        this.mAlertView.setLeftArrowButton((String) null, new PageSettingAlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView3.15
            @Override // com.coolots.chaton.call.screenshare.util.PageSettingAlertView.OnClickListener
            public void onClick(PageSettingAlertView dialog, int which) {
                if (DocsMenuView3.this.mTempCur - 1 > 0) {
                    DocsMenuView3 docsMenuView3 = DocsMenuView3.this;
                    docsMenuView3.mTempCur--;
                    DocsMenuView3.this.mAlertView.setPageText(Integer.toString(DocsMenuView3.this.mTempCur));
                } else {
                    DocsMenuView3.this.mTempCur = DocsMenuView3.this.mTempMax;
                    DocsMenuView3.this.mAlertView.setPageText(Integer.toString(DocsMenuView3.this.mTempCur));
                }
            }
        });
        this.mAlertView.setRightArrowButton((String) null, new PageSettingAlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView3.16
            @Override // com.coolots.chaton.call.screenshare.util.PageSettingAlertView.OnClickListener
            public void onClick(PageSettingAlertView dialog, int which) {
                if (DocsMenuView3.this.mTempCur + 1 > DocsMenuView3.this.mTempMax) {
                    if (DocsMenuView3.this.mTempCur + 1 > DocsMenuView3.this.mTempMax) {
                        DocsMenuView3.this.mTempCur = 1;
                        DocsMenuView3.this.mAlertView.setPageText(Integer.toString(DocsMenuView3.this.mTempCur));
                        return;
                    }
                    return;
                }
                DocsMenuView3.this.mTempCur++;
                DocsMenuView3.this.mAlertView.setPageText(Integer.toString(DocsMenuView3.this.mTempCur));
            }
        });
        this.mAlertView.setCancelable(true);
        this.mAlertView.show();
        this.mAlertView.setPageText(Integer.toString(this.mTempCur));
        this.mAlertView.setPageTextFilter(this.mIDocsViewTouchImage);
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() throws Resources.NotFoundException {
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
        if (this.mDocsViewBtn != null) {
            this.mDocsViewBtn.removeCallbacks(null);
            this.mDocsViewBtn = null;
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
        if (this.mEndBtn != null) {
            this.mEndBtn.removeCallbacks(null);
            this.mEndBtn = null;
        }
        if (this.mHideBtn != null) {
            this.mHideBtn.removeCallbacks(null);
            this.mHideBtn = null;
        }
        if (this.mHandler != null) {
            this.mHandler = null;
        }
        if (this.mPenColor != null) {
            this.mPenColor.removeCallbacks(null);
            this.mPenColor = null;
        }
        if (this.mPenWritingCapture != null) {
            this.mPenWritingCapture = null;
        }
        if (this.mClearAlertView != null) {
            this.mClearAlertView = null;
        }
        if (this.mScreenScale != null) {
            this.mScreenScale = null;
        }
        if (this.mAlertView != null) {
            if (this.mAlertView.isShown()) {
                this.mAlertView.dismiss();
                InputMethodManager imm = (InputMethodManager) this.mContext.getSystemService("input_method");
                imm.hideSoftInputFromWindow(this.mAlertView.getTextView().getWindowToken(), 0);
            }
            this.mAlertView = null;
        }
    }

    private boolean isShowingDialog() {
        if (this.mAlertView == null || !this.mAlertView.isShown()) {
            return this.mClearAlertView != null && this.mClearAlertView.isShown();
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowFocusChanged(boolean hasWindowFocus) {
        logI("moon dispatchWindowFocusChanged : " + hasWindowFocus + " mIsSelectedFile: " + this.mIsSelectedFile);
        if (isShowingDialog()) {
            this.mDialogHasFocus = true;
            return;
        }
        if (this.mIsSelectedFile) {
            if (hasWindowFocus) {
                if (this.mDialogHasFocus) {
                    this.mDialogHasFocus = false;
                } else {
                    MainApplication.mPhoneManager.getShareScreenManager().resumeShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), null, true);
                    if (this.mToolBarLayout != null) {
                        this.mToolBarLayout.setVisibility(0);
                    }
                    if (this.mSpenMulitView != null) {
                        this.mSpenMulitView.setVisibility(0);
                    }
                }
            } else {
                MainApplication.mPhoneManager.getShareScreenManager().pauseShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), 0);
                if (this.mToolBarLayout != null) {
                    this.mToolBarLayout.setVisibility(8);
                }
                if (this.mDocsMenuViewInfoHandler != null) {
                    this.mDocsMenuViewInfoHandler.sendEmptyMessage(1000);
                }
                if (this.mSpenMulitView != null) {
                    this.mSpenMulitView.setVisibility(4);
                }
            }
            super.dispatchWindowFocusChanged(hasWindowFocus);
        }
    }

    public void getPageCanvas(int page) {
        byte[] cmdPage = ScreenShareRemotePacket.makeRemoteKey(page);
        if (this.mOnSendCommandData != null) {
            this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_MOVE_PAGE, cmdPage);
        }
        logI("getPageCanvas : " + page);
        if (this.mDataController != null) {
            this.mDataController.getCurrentContainer(page);
        }
        EraseAllDrawInView();
        float[] value = new float[9];
        this.mIDocsViewTouchImage.getMatrix().getValues(value);
        this.mSpenMulitView.setZoom(-value[2], -value[5], value[0]);
        this.mSpenMulitView.setPan(new PointF(-value[2], -value[5]));
        if (this.mDataController != null) {
            ArrayList<BoardData> boardData = this.mDataController.getCurrentPageData(page);
            logI("getPageCanvas : " + boardData);
            if (boardData != null) {
                this.isRedrawEventData = true;
                this.mSpenMulitView.setToolTypeAction(1, 1, this.mSpenMulitView.getToolTypeAction(2));
                logI("getPageCanvas size : " + boardData.size());
                Iterator<BoardData> it = boardData.iterator();
                while (it.hasNext()) {
                    BoardData data = it.next();
                    setDrawData(data.getType(), data.getData());
                }
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView3.17
                    @Override // java.lang.Runnable
                    public void run() {
                        DocsMenuView3.this.mSpenMulitView.setToolTypeAction(1, 1, 0);
                    }
                });
            }
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void onSendData(int type, byte[] data) {
        logI("YKYU onSendData() -1-");
        if (this.mOnSendCommandData != null) {
            logI("YKYU onSendData() -2-");
            addBoardData(type, data);
            this.mOnSendCommandData.onSendData(type, data);
        }
        logI("YKYU onSendData() -3-");
    }

    private void addBoardData(int type, byte[] data) {
        if (this.mDataController != null) {
            logI("onSendData add data  page: " + this.mIDocsViewTouchImage.getCurrentPageNumber());
            this.mDataController.addBoardData(this.mIDocsViewTouchImage.getCurrentPageNumber(), type, data);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == 4 && event.getAction() == 1) {
            this.mIDocsViewTouchImage.finishDocsView();
        }
        return super.dispatchKeyEvent(event);
    }

    public void setDocsImgeDumpPath(String docsImgDumpPath) {
        this.mDataController.setmDocsImgeDumpPath(docsImgDumpPath);
    }

    public String getDocsImgeDumpPath() {
        return this.mDataController.getDocImgDumpPath();
    }

    public void setDocsFilePath(String filePath) {
        this.mDataController.setFilePath(filePath);
    }

    public String getDocsFilePath() {
        return this.mDataController.getFilePath();
    }

    public void setDocsName(String name) {
        this.mDataController.setDocsName(name);
    }

    public String getDocsName() {
        return this.mDataController.getDocsName();
    }

    public boolean isFlinkUpDown() {
        return this.isFlinkUpDown;
    }

    public void pressHomeKey(boolean pressed) {
        this.mDataController.pressedHomeKey(pressed);
    }

    public void disposeDataController() {
        if (this.mDataController != null) {
            this.mDataController.dispose();
            this.mDataController = null;
        }
    }

    public void enableTouch(boolean isTouch) {
        this.mIsTouch = isTouch;
    }

    public void initBoardDataController() {
        logE("panda     initBoardDataController");
        if (this.mDataController != null) {
            this.mDataController.dispose();
            this.mDataController = null;
        }
        this.mDataController = new BoardDataController();
    }

    public void setDocsTotalPageNum(int totalPage) {
        this.mDataController.setDocsToltalPageNum(totalPage);
    }

    public int getDocsToltalPageNum() {
        return this.mDataController.getDocsToltalPageNum();
    }
}
