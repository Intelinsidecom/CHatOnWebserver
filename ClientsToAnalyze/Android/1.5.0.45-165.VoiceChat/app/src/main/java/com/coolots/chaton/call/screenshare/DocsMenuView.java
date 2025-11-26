package com.coolots.chaton.call.screenshare;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
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
import com.coolots.chaton.call.screenshare.util.SPenSDKUtils;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.coolots.chaton.call.screenshare.util.ScreenShareRemotePacket;
import com.coolots.chaton.call.screenshare.util.ScreenShareScale;
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
public class DocsMenuView extends OverlayView implements DisposeInterface {
    private static final String CLASSNAME = "[DocsMenuView] ";
    private static final int HIDE_DOCS_VIEW_INFO = 1000;
    public static final int SWIPE_MAX_OFF_PATH = 250;
    public static final int SWIPE_MIN_DISTANCE = 120;
    public static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private static final int ZOOM = 3;
    private static long gDownTime;
    private final int DRAG;
    private final int MULTITOUCH;
    private final int NONE;
    private boolean isCanceled;
    private boolean isFlinkUpDown;
    private boolean isHidden;
    private PageSettingAlertView mAlertView;
    private View.OnClickListener mBtnClickListener;
    private ImageView mCaptureBtn;
    private AlertView mClearAlertView;
    private int mCurrentPage;
    private BoardDataController mDataController;
    private boolean mDialogHasFocus;
    private int mDisMaxSize;
    private int mDisMinSize;
    private Button mDocsMenuViewInfo;
    private DocsMenuViewInfoHandler mDocsMenuViewInfoHandler;
    private boolean mDocsPenMode;
    private ImageView mDocsViewModeBtn;
    private Button mEndBtn;
    private ImageView mEraserBtn;
    private Handler mHandler;
    private ImageView mHideBtn;
    private IDocsViewTouchImage mIDocsViewTouchImage;
    private boolean mIsDocsviewMode;
    private boolean mIsSelectedFile;
    private boolean mIsTouch;
    private ImageView mPenBtn;
    private RelativeLayout mPenBtnLayout;
    private View mPenColor;
    private PenWritingCapture mPenWritingCapture;
    private boolean mRecveDraw;
    private ImageView mRedoBtn;
    private SCanvasView mSCanvas;
    private Matrix mSCanvasMatrix;
    SCanvasDeleteAllConfirmListener mSCanvasOnDeleteAllConfirmListener;
    SPenTouchIDListener mSCanvasOnPenTouchIDListener;
    SObjectUpdateListener mSObjectListenerUI;
    private ScreenShareScale mScreenScale;
    private SettingStrokeInfo mSendSettingStrokeInfo;
    private int mTempCur;
    private int mTempMax;
    private ImageView mTextBtn;
    private RelativeLayout mToolBarLayout;
    private LinearLayout mToolbarBtnLayout;
    private LinearLayout mToolbarCaptureLayout;
    private ImageView mUndoBtn;
    private int mode;
    private float oldDist;
    private FrameLayout settingViewContainer;
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

    public DocsMenuView(Context context) {
        super(context, C0000R.layout.screenshare_docs_view);
        this.NONE = 0;
        this.DRAG = 1;
        this.MULTITOUCH = 2;
        this.mode = 0;
        this.isCanceled = false;
        this.mHandler = new Handler();
        this.isHidden = false;
        this.isFlinkUpDown = true;
        this.windowManager = null;
        this.mDocsPenMode = false;
        this.mIsSelectedFile = false;
        this.mDialogHasFocus = false;
        this.mIsDocsviewMode = false;
        this.mIsTouch = false;
        this.mRecveDraw = false;
        this.mCurrentPage = -1;
        this.mSCanvasMatrix = null;
        this.mSCanvasOnDeleteAllConfirmListener = new SCanvasDeleteAllConfirmListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.1
            @Override // com.samsung.spensdk.applistener.SCanvasDeleteAllConfirmListener
            public boolean onDeleteAllConfirm(int nLayerID) throws Resources.NotFoundException {
                DocsMenuView.this.mClearAlertView = new AlertView(MainApplication.mContext);
                DocsMenuView.this.mClearAlertView.setTitle(C0000R.string.screenshare_alertView_attention_title);
                DocsMenuView.this.mClearAlertView.setMessage(C0000R.string.screenshare_alertView_attention_message);
                DocsMenuView.this.mClearAlertView.setPositiveButton(C0000R.string.ok, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.1.1
                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                    public void onClick(AlertView dialog, int which) {
                        DocsMenuView.this.mSCanvas.deleteAll(true);
                        DocsMenuView.this.clearPageData();
                        DocsMenuView.this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARPAGE, null);
                        DocsMenuView.this.closeSettingView();
                    }
                });
                DocsMenuView.this.mClearAlertView.setNegativeButton(C0000R.string.cancel, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.1.2
                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                    public void onClick(AlertView dialog, int which) {
                    }
                });
                DocsMenuView.this.mClearAlertView.setCancelable(true);
                DocsMenuView.this.mClearAlertView.show();
                return true;
            }
        };
        this.mBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws Resources.NotFoundException {
                DocsMenuView.this.logI("mBtnClickListener()");
                int nBtnID = v.getId();
                if (DocsMenuView.this.mDocsViewModeBtn != null && nBtnID == DocsMenuView.this.mDocsViewModeBtn.getId()) {
                    DocsMenuView.this.logI("mDocsViewModeBtn Clicked ");
                    DocsMenuView.this.setNormalMode(true);
                    DocsMenuView.this.mSCanvas.setCanvasMode(0);
                    DocsMenuView.this.mSCanvas.showSettingView(0, false);
                    DocsMenuView.this.setDocsViewMode(true);
                    DocsMenuView.this.setMenuIconSelected(nBtnID);
                    return;
                }
                if (DocsMenuView.this.mPenBtn != null && nBtnID == DocsMenuView.this.mPenBtn.getId()) {
                    DocsMenuView.this.logI("PenWriting mPenBtn Clicked ");
                    DocsMenuView.this.setNormalMode(false);
                    if (DocsMenuView.this.mSCanvas.getCanvasMode() != 10 || DocsMenuView.this.getDocsViewMode()) {
                        DocsMenuView.this.mSCanvas.setCanvasMode(10);
                        DocsMenuView.this.mSCanvas.showSettingView(1, false);
                    } else {
                        DocsMenuView.this.mSCanvas.setSettingViewSizeOption(1, 2);
                        DocsMenuView.this.mSCanvas.toggleShowSettingView(1);
                    }
                    DocsMenuView.this.setDocsViewMode(false);
                    DocsMenuView.this.setMenuIconSelected(nBtnID);
                    DocsMenuView.this.sendMatrix();
                    return;
                }
                if (DocsMenuView.this.mEraserBtn != null && nBtnID == DocsMenuView.this.mEraserBtn.getId()) {
                    DocsMenuView.this.logI("PenWriting mEraserBtn Clicked ");
                    DocsMenuView.this.setNormalMode(false);
                    if (DocsMenuView.this.mSCanvas.getCanvasMode() != 11 || DocsMenuView.this.getDocsViewMode()) {
                        DocsMenuView.this.mSCanvas.setCanvasMode(11);
                        DocsMenuView.this.mSCanvas.showSettingView(2, false);
                    } else {
                        DocsMenuView.this.mSCanvas.setSettingViewSizeOption(2, 0);
                        DocsMenuView.this.mSCanvas.toggleShowSettingView(2);
                    }
                    DocsMenuView.this.setDocsViewMode(false);
                    DocsMenuView.this.setMenuIconSelected(nBtnID);
                    return;
                }
                if (DocsMenuView.this.mTextBtn != null && nBtnID == DocsMenuView.this.mTextBtn.getId()) {
                    DocsMenuView.this.logI("PenWriting mTextBtn Clicked ");
                    DocsMenuView.this.setNormalMode(false);
                    if (DocsMenuView.this.mSCanvas.getCanvasMode() != 12 || DocsMenuView.this.getDocsViewMode()) {
                        DocsMenuView.this.mSCanvas.setCanvasMode(12);
                        DocsMenuView.this.mSCanvas.showSettingView(3, false);
                    } else {
                        DocsMenuView.this.mSCanvas.setSettingViewSizeOption(3, 1);
                        DocsMenuView.this.mSCanvas.toggleShowSettingView(3);
                    }
                    DocsMenuView.this.setDocsViewMode(false);
                    DocsMenuView.this.setMenuIconSelected(nBtnID);
                    return;
                }
                if (DocsMenuView.this.mCaptureBtn != null && nBtnID == DocsMenuView.this.mCaptureBtn.getId()) {
                    DocsMenuView.this.logI("PenWritingCapture is Clicked!!");
                    DocsMenuView.this.mPenWritingCapture.ScreenCapture();
                    return;
                }
                if (DocsMenuView.this.mHideBtn != null && nBtnID == DocsMenuView.this.mHideBtn.getId()) {
                    DocsMenuView.this.logI("PenWriting Toolbar is show/Hide");
                    DocsMenuView.this.btnHidden(DocsMenuView.this.isHidden);
                    if (DocsMenuView.this.mSCanvas.getCanvasMode() != 0) {
                        if (DocsMenuView.this.mSCanvas.getCanvasMode() == 10) {
                            DocsMenuView.this.mSCanvas.setCanvasMode(10);
                            DocsMenuView.this.mSCanvas.showSettingView(1, false);
                            DocsMenuView.this.setNormalMode(false);
                            return;
                        } else if (DocsMenuView.this.mSCanvas.getCanvasMode() == 11) {
                            DocsMenuView.this.mSCanvas.setCanvasMode(11);
                            DocsMenuView.this.mSCanvas.showSettingView(2, false);
                            DocsMenuView.this.setNormalMode(false);
                            return;
                        } else {
                            if (DocsMenuView.this.mSCanvas.getCanvasMode() == 12) {
                                DocsMenuView.this.mSCanvas.setCanvasMode(12);
                                DocsMenuView.this.mSCanvas.showSettingView(3, false);
                                DocsMenuView.this.setNormalMode(false);
                                return;
                            }
                            return;
                        }
                    }
                    DocsMenuView.this.setNormalMode(true);
                    DocsMenuView.this.mSCanvas.setCanvasMode(0);
                    DocsMenuView.this.mSCanvas.showSettingView(0, false);
                    return;
                }
                if (DocsMenuView.this.mEndBtn != null && nBtnID == DocsMenuView.this.mEndBtn.getId()) {
                    DocsMenuView.this.logI("PenWriting EndBtn Clicked ");
                    DocsMenuView.this.mIsSelectedFile = false;
                    DocsMenuView.this.mIDocsViewTouchImage.finishDocsView();
                } else {
                    if (DocsMenuView.this.mDocsMenuViewInfo == null || nBtnID != DocsMenuView.this.mDocsMenuViewInfo.getId() || DocsMenuView.this.mIDocsViewTouchImage.isDocsViewInfoZoom() || !DocsMenuView.this.mDocsMenuViewInfo.isShown()) {
                        return;
                    }
                    DocsMenuView.this.showDialogForPageSetting();
                }
            }
        };
        this.undoNredoBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DocsMenuView.this.logI("undoNredoBtnClickListener()");
                int nBtnID = v.getId();
                byte[] cmdData = PenWriteNetwork.intToByte(DocsMenuView.this.mUserId);
                if (nBtnID == DocsMenuView.this.mUndoBtn.getId()) {
                    DocsMenuView.this.mSCanvas.undo();
                    DocsMenuView.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO, cmdData);
                } else if (nBtnID == DocsMenuView.this.mRedoBtn.getId()) {
                    DocsMenuView.this.mSCanvas.redo();
                    DocsMenuView.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO, cmdData);
                }
                if (DocsMenuView.this.mUndoBtn != null) {
                    DocsMenuView.this.mUndoBtn.setEnabled(DocsMenuView.this.mSCanvas.isUndoable());
                }
                if (DocsMenuView.this.mRedoBtn != null) {
                    DocsMenuView.this.mRedoBtn.setEnabled(DocsMenuView.this.mSCanvas.isRedoable());
                }
            }
        };
        this.oldDist = 1.0f;
        this.mDocsMenuViewInfoHandler = new DocsMenuViewInfoHandler();
        this.mSCanvasOnPenTouchIDListener = new SPenTouchIDListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.4
            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchFinger(View view, MotionEvent event, int multiObjectID) {
                DocsMenuView.this.setTouchMode(event);
                DocsMenuView.this.sendTouchEvent(event, multiObjectID, 0);
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPen(View view, MotionEvent event, int multiObjectID) {
                DocsMenuView.this.sendTouchEvent(event, multiObjectID, 1);
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPenEraser(View view, MotionEvent event, int multiObjectID) {
                DocsMenuView.this.sendTouchEvent(event, multiObjectID, 2);
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onDrawingPen(View arg0, MotionEvent arg1, int arg2, int arg3) {
                return false;
            }
        };
        this.mSObjectListenerUI = new SObjectUpdateListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.5
            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectChanged(SObject sObject, boolean byUndo, boolean byRedo) {
                DocsMenuView.this.logI("Elcyde onSObjectChanged byUndo = " + byUndo + " , byRedo = " + byRedo);
                if ((sObject instanceof SObjectText) && !byRedo && !byUndo) {
                    int mutiUserId = sObject.getTempIntData("SObjectMultiUserIDKey", -1);
                    int mutiTextId = sObject.getTempIntData("SObjectMultiObjectIDKey", -1);
                    if (mutiUserId == 1) {
                        SObjectText textData = (SObjectText) sObject;
                        int nColor = textData.getColor();
                        int nStyle = textData.getStyle();
                        float fSize = textData.getSize();
                        RectF rRect = textData.getRect();
                        String strText = textData.getText();
                        String strFont = textData.getFontName();
                        byte[] cmdData = PenWriteNetwork.makeSAMMTextInput(DocsMenuView.this.mUserId, mutiTextId, nColor, nStyle, fSize, rRect.left, rRect.top, rRect.right, rRect.bottom, strFont, strText);
                        if (DocsMenuView.this.mSCanvas.getCanvasMode() != 12) {
                            return;
                        }
                        DocsMenuView.this.onSendData(302, cmdData);
                    }
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeleted(SObject sObject, boolean byUndo, boolean byRedo, boolean arg3) {
                DocsMenuView.this.logI("Elcyde onSObjectDeleted byUndo = " + byUndo + " , byRedo = " + byRedo);
                if ((sObject instanceof SObjectText) && !byRedo && !byUndo) {
                    int mutiUserId = sObject.getTempIntData("SObjectMultiUserIDKey", -1);
                    int mutiTextId = sObject.getTempIntData("SObjectMultiObjectIDKey", -1);
                    if (mutiUserId == 1) {
                        SObjectText textData = (SObjectText) sObject;
                        int nColor = textData.getColor();
                        int nStyle = textData.getStyle();
                        float fSize = textData.getSize();
                        RectF rRect = textData.getRect();
                        String strFont = textData.getFontName();
                        byte[] cmdData = PenWriteNetwork.makeSAMMTextInput(DocsMenuView.this.mUserId, mutiTextId, nColor, nStyle, fSize, rRect.left, rRect.top, rRect.right, rRect.bottom, strFont, "");
                        if (DocsMenuView.this.mSCanvas.getCanvasMode() != 12) {
                            return;
                        }
                        DocsMenuView.this.onSendData(302, cmdData);
                    }
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeletedAll(boolean arg0, int arg1) {
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectInserted(SObject sObject, boolean byUndo, boolean byRedo) {
                DocsMenuView.this.logI("Elcyde onSObjectInserted byUndo = " + byUndo + " , byRedo = " + byRedo);
                if ((sObject instanceof SObjectText) && !byRedo && !byUndo) {
                    int mutiUserId = sObject.getTempIntData("SObjectMultiUserIDKey", -1);
                    int mutiTextId = sObject.getTempIntData("SObjectMultiObjectIDKey", -1);
                    if (mutiUserId == 1) {
                        SObjectText textData = (SObjectText) sObject;
                        int nColor = textData.getColor();
                        int nStyle = textData.getStyle();
                        float fSize = textData.getSize();
                        RectF rRect = textData.getRect();
                        String strText = textData.getText();
                        String strFont = textData.getFontName();
                        byte[] cmdData = PenWriteNetwork.makeSAMMTextInput(DocsMenuView.this.mUserId, mutiTextId, nColor, nStyle, fSize, rRect.left, rRect.top, rRect.right, rRect.bottom, strFont, strText);
                        if (DocsMenuView.this.mSCanvas.getCanvasMode() != 12) {
                            return;
                        }
                        DocsMenuView.this.onSendData(301, cmdData);
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
    }

    public DocsMenuView(Context context, IDocsViewTouchImage Idocsviewtouchimage) {
        super(context, C0000R.layout.screenshare_docs_view);
        this.NONE = 0;
        this.DRAG = 1;
        this.MULTITOUCH = 2;
        this.mode = 0;
        this.isCanceled = false;
        this.mHandler = new Handler();
        this.isHidden = false;
        this.isFlinkUpDown = true;
        this.windowManager = null;
        this.mDocsPenMode = false;
        this.mIsSelectedFile = false;
        this.mDialogHasFocus = false;
        this.mIsDocsviewMode = false;
        this.mIsTouch = false;
        this.mRecveDraw = false;
        this.mCurrentPage = -1;
        this.mSCanvasMatrix = null;
        this.mSCanvasOnDeleteAllConfirmListener = new SCanvasDeleteAllConfirmListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.1
            @Override // com.samsung.spensdk.applistener.SCanvasDeleteAllConfirmListener
            public boolean onDeleteAllConfirm(int nLayerID) throws Resources.NotFoundException {
                DocsMenuView.this.mClearAlertView = new AlertView(MainApplication.mContext);
                DocsMenuView.this.mClearAlertView.setTitle(C0000R.string.screenshare_alertView_attention_title);
                DocsMenuView.this.mClearAlertView.setMessage(C0000R.string.screenshare_alertView_attention_message);
                DocsMenuView.this.mClearAlertView.setPositiveButton(C0000R.string.ok, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.1.1
                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                    public void onClick(AlertView dialog, int which) {
                        DocsMenuView.this.mSCanvas.deleteAll(true);
                        DocsMenuView.this.clearPageData();
                        DocsMenuView.this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARPAGE, null);
                        DocsMenuView.this.closeSettingView();
                    }
                });
                DocsMenuView.this.mClearAlertView.setNegativeButton(C0000R.string.cancel, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.1.2
                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                    public void onClick(AlertView dialog, int which) {
                    }
                });
                DocsMenuView.this.mClearAlertView.setCancelable(true);
                DocsMenuView.this.mClearAlertView.show();
                return true;
            }
        };
        this.mBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws Resources.NotFoundException {
                DocsMenuView.this.logI("mBtnClickListener()");
                int nBtnID = v.getId();
                if (DocsMenuView.this.mDocsViewModeBtn != null && nBtnID == DocsMenuView.this.mDocsViewModeBtn.getId()) {
                    DocsMenuView.this.logI("mDocsViewModeBtn Clicked ");
                    DocsMenuView.this.setNormalMode(true);
                    DocsMenuView.this.mSCanvas.setCanvasMode(0);
                    DocsMenuView.this.mSCanvas.showSettingView(0, false);
                    DocsMenuView.this.setDocsViewMode(true);
                    DocsMenuView.this.setMenuIconSelected(nBtnID);
                    return;
                }
                if (DocsMenuView.this.mPenBtn != null && nBtnID == DocsMenuView.this.mPenBtn.getId()) {
                    DocsMenuView.this.logI("PenWriting mPenBtn Clicked ");
                    DocsMenuView.this.setNormalMode(false);
                    if (DocsMenuView.this.mSCanvas.getCanvasMode() != 10 || DocsMenuView.this.getDocsViewMode()) {
                        DocsMenuView.this.mSCanvas.setCanvasMode(10);
                        DocsMenuView.this.mSCanvas.showSettingView(1, false);
                    } else {
                        DocsMenuView.this.mSCanvas.setSettingViewSizeOption(1, 2);
                        DocsMenuView.this.mSCanvas.toggleShowSettingView(1);
                    }
                    DocsMenuView.this.setDocsViewMode(false);
                    DocsMenuView.this.setMenuIconSelected(nBtnID);
                    DocsMenuView.this.sendMatrix();
                    return;
                }
                if (DocsMenuView.this.mEraserBtn != null && nBtnID == DocsMenuView.this.mEraserBtn.getId()) {
                    DocsMenuView.this.logI("PenWriting mEraserBtn Clicked ");
                    DocsMenuView.this.setNormalMode(false);
                    if (DocsMenuView.this.mSCanvas.getCanvasMode() != 11 || DocsMenuView.this.getDocsViewMode()) {
                        DocsMenuView.this.mSCanvas.setCanvasMode(11);
                        DocsMenuView.this.mSCanvas.showSettingView(2, false);
                    } else {
                        DocsMenuView.this.mSCanvas.setSettingViewSizeOption(2, 0);
                        DocsMenuView.this.mSCanvas.toggleShowSettingView(2);
                    }
                    DocsMenuView.this.setDocsViewMode(false);
                    DocsMenuView.this.setMenuIconSelected(nBtnID);
                    return;
                }
                if (DocsMenuView.this.mTextBtn != null && nBtnID == DocsMenuView.this.mTextBtn.getId()) {
                    DocsMenuView.this.logI("PenWriting mTextBtn Clicked ");
                    DocsMenuView.this.setNormalMode(false);
                    if (DocsMenuView.this.mSCanvas.getCanvasMode() != 12 || DocsMenuView.this.getDocsViewMode()) {
                        DocsMenuView.this.mSCanvas.setCanvasMode(12);
                        DocsMenuView.this.mSCanvas.showSettingView(3, false);
                    } else {
                        DocsMenuView.this.mSCanvas.setSettingViewSizeOption(3, 1);
                        DocsMenuView.this.mSCanvas.toggleShowSettingView(3);
                    }
                    DocsMenuView.this.setDocsViewMode(false);
                    DocsMenuView.this.setMenuIconSelected(nBtnID);
                    return;
                }
                if (DocsMenuView.this.mCaptureBtn != null && nBtnID == DocsMenuView.this.mCaptureBtn.getId()) {
                    DocsMenuView.this.logI("PenWritingCapture is Clicked!!");
                    DocsMenuView.this.mPenWritingCapture.ScreenCapture();
                    return;
                }
                if (DocsMenuView.this.mHideBtn != null && nBtnID == DocsMenuView.this.mHideBtn.getId()) {
                    DocsMenuView.this.logI("PenWriting Toolbar is show/Hide");
                    DocsMenuView.this.btnHidden(DocsMenuView.this.isHidden);
                    if (DocsMenuView.this.mSCanvas.getCanvasMode() != 0) {
                        if (DocsMenuView.this.mSCanvas.getCanvasMode() == 10) {
                            DocsMenuView.this.mSCanvas.setCanvasMode(10);
                            DocsMenuView.this.mSCanvas.showSettingView(1, false);
                            DocsMenuView.this.setNormalMode(false);
                            return;
                        } else if (DocsMenuView.this.mSCanvas.getCanvasMode() == 11) {
                            DocsMenuView.this.mSCanvas.setCanvasMode(11);
                            DocsMenuView.this.mSCanvas.showSettingView(2, false);
                            DocsMenuView.this.setNormalMode(false);
                            return;
                        } else {
                            if (DocsMenuView.this.mSCanvas.getCanvasMode() == 12) {
                                DocsMenuView.this.mSCanvas.setCanvasMode(12);
                                DocsMenuView.this.mSCanvas.showSettingView(3, false);
                                DocsMenuView.this.setNormalMode(false);
                                return;
                            }
                            return;
                        }
                    }
                    DocsMenuView.this.setNormalMode(true);
                    DocsMenuView.this.mSCanvas.setCanvasMode(0);
                    DocsMenuView.this.mSCanvas.showSettingView(0, false);
                    return;
                }
                if (DocsMenuView.this.mEndBtn != null && nBtnID == DocsMenuView.this.mEndBtn.getId()) {
                    DocsMenuView.this.logI("PenWriting EndBtn Clicked ");
                    DocsMenuView.this.mIsSelectedFile = false;
                    DocsMenuView.this.mIDocsViewTouchImage.finishDocsView();
                } else {
                    if (DocsMenuView.this.mDocsMenuViewInfo == null || nBtnID != DocsMenuView.this.mDocsMenuViewInfo.getId() || DocsMenuView.this.mIDocsViewTouchImage.isDocsViewInfoZoom() || !DocsMenuView.this.mDocsMenuViewInfo.isShown()) {
                        return;
                    }
                    DocsMenuView.this.showDialogForPageSetting();
                }
            }
        };
        this.undoNredoBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DocsMenuView.this.logI("undoNredoBtnClickListener()");
                int nBtnID = v.getId();
                byte[] cmdData = PenWriteNetwork.intToByte(DocsMenuView.this.mUserId);
                if (nBtnID == DocsMenuView.this.mUndoBtn.getId()) {
                    DocsMenuView.this.mSCanvas.undo();
                    DocsMenuView.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO, cmdData);
                } else if (nBtnID == DocsMenuView.this.mRedoBtn.getId()) {
                    DocsMenuView.this.mSCanvas.redo();
                    DocsMenuView.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO, cmdData);
                }
                if (DocsMenuView.this.mUndoBtn != null) {
                    DocsMenuView.this.mUndoBtn.setEnabled(DocsMenuView.this.mSCanvas.isUndoable());
                }
                if (DocsMenuView.this.mRedoBtn != null) {
                    DocsMenuView.this.mRedoBtn.setEnabled(DocsMenuView.this.mSCanvas.isRedoable());
                }
            }
        };
        this.oldDist = 1.0f;
        this.mDocsMenuViewInfoHandler = new DocsMenuViewInfoHandler();
        this.mSCanvasOnPenTouchIDListener = new SPenTouchIDListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.4
            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchFinger(View view, MotionEvent event, int multiObjectID) {
                DocsMenuView.this.setTouchMode(event);
                DocsMenuView.this.sendTouchEvent(event, multiObjectID, 0);
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPen(View view, MotionEvent event, int multiObjectID) {
                DocsMenuView.this.sendTouchEvent(event, multiObjectID, 1);
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPenEraser(View view, MotionEvent event, int multiObjectID) {
                DocsMenuView.this.sendTouchEvent(event, multiObjectID, 2);
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onDrawingPen(View arg0, MotionEvent arg1, int arg2, int arg3) {
                return false;
            }
        };
        this.mSObjectListenerUI = new SObjectUpdateListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.5
            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectChanged(SObject sObject, boolean byUndo, boolean byRedo) {
                DocsMenuView.this.logI("Elcyde onSObjectChanged byUndo = " + byUndo + " , byRedo = " + byRedo);
                if ((sObject instanceof SObjectText) && !byRedo && !byUndo) {
                    int mutiUserId = sObject.getTempIntData("SObjectMultiUserIDKey", -1);
                    int mutiTextId = sObject.getTempIntData("SObjectMultiObjectIDKey", -1);
                    if (mutiUserId == 1) {
                        SObjectText textData = (SObjectText) sObject;
                        int nColor = textData.getColor();
                        int nStyle = textData.getStyle();
                        float fSize = textData.getSize();
                        RectF rRect = textData.getRect();
                        String strText = textData.getText();
                        String strFont = textData.getFontName();
                        byte[] cmdData = PenWriteNetwork.makeSAMMTextInput(DocsMenuView.this.mUserId, mutiTextId, nColor, nStyle, fSize, rRect.left, rRect.top, rRect.right, rRect.bottom, strFont, strText);
                        if (DocsMenuView.this.mSCanvas.getCanvasMode() != 12) {
                            return;
                        }
                        DocsMenuView.this.onSendData(302, cmdData);
                    }
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeleted(SObject sObject, boolean byUndo, boolean byRedo, boolean arg3) {
                DocsMenuView.this.logI("Elcyde onSObjectDeleted byUndo = " + byUndo + " , byRedo = " + byRedo);
                if ((sObject instanceof SObjectText) && !byRedo && !byUndo) {
                    int mutiUserId = sObject.getTempIntData("SObjectMultiUserIDKey", -1);
                    int mutiTextId = sObject.getTempIntData("SObjectMultiObjectIDKey", -1);
                    if (mutiUserId == 1) {
                        SObjectText textData = (SObjectText) sObject;
                        int nColor = textData.getColor();
                        int nStyle = textData.getStyle();
                        float fSize = textData.getSize();
                        RectF rRect = textData.getRect();
                        String strFont = textData.getFontName();
                        byte[] cmdData = PenWriteNetwork.makeSAMMTextInput(DocsMenuView.this.mUserId, mutiTextId, nColor, nStyle, fSize, rRect.left, rRect.top, rRect.right, rRect.bottom, strFont, "");
                        if (DocsMenuView.this.mSCanvas.getCanvasMode() != 12) {
                            return;
                        }
                        DocsMenuView.this.onSendData(302, cmdData);
                    }
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeletedAll(boolean arg0, int arg1) {
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectInserted(SObject sObject, boolean byUndo, boolean byRedo) {
                DocsMenuView.this.logI("Elcyde onSObjectInserted byUndo = " + byUndo + " , byRedo = " + byRedo);
                if ((sObject instanceof SObjectText) && !byRedo && !byUndo) {
                    int mutiUserId = sObject.getTempIntData("SObjectMultiUserIDKey", -1);
                    int mutiTextId = sObject.getTempIntData("SObjectMultiObjectIDKey", -1);
                    if (mutiUserId == 1) {
                        SObjectText textData = (SObjectText) sObject;
                        int nColor = textData.getColor();
                        int nStyle = textData.getStyle();
                        float fSize = textData.getSize();
                        RectF rRect = textData.getRect();
                        String strText = textData.getText();
                        String strFont = textData.getFontName();
                        byte[] cmdData = PenWriteNetwork.makeSAMMTextInput(DocsMenuView.this.mUserId, mutiTextId, nColor, nStyle, fSize, rRect.left, rRect.top, rRect.right, rRect.bottom, strFont, strText);
                        if (DocsMenuView.this.mSCanvas.getCanvasMode() != 12) {
                            return;
                        }
                        DocsMenuView.this.onSendData(301, cmdData);
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
        this.mDocsViewModeBtn = (ImageView) findViewById(C0000R.id.docs_view_mode_btn_docs);
        this.mPenBtn = (ImageView) findViewById(C0000R.id.pen_btn_docs);
        this.mEraserBtn = (ImageView) findViewById(C0000R.id.eraser_btn_docs);
        this.mUndoBtn = (ImageView) findViewById(C0000R.id.undo_btn_docs);
        this.mRedoBtn = (ImageView) findViewById(C0000R.id.redo_btn_docs);
        this.mCaptureBtn = (ImageView) findViewById(C0000R.id.camera_btn_docs);
        this.mTextBtn = (ImageView) findViewById(C0000R.id.text_btn_docs);
        this.mEndBtn = (Button) findViewById(C0000R.id.end_btn_docs);
        this.mHideBtn = (ImageView) findViewById(C0000R.id.showhide_btn_docs);
        this.mToolBarLayout = (RelativeLayout) findViewById(C0000R.id.share_view_toolbar_layout1_docs);
        this.mPenBtnLayout = (RelativeLayout) findViewById(C0000R.id.pen_btn_layout_docs);
        this.mDocsViewModeBtn.setOnClickListener(this.mBtnClickListener);
        this.mPenBtn.setOnClickListener(this.mBtnClickListener);
        this.mEraserBtn.setOnClickListener(this.mBtnClickListener);
        this.mCaptureBtn.setOnClickListener(this.mBtnClickListener);
        this.mTextBtn.setOnClickListener(this.mBtnClickListener);
        this.mEndBtn.setOnClickListener(this.mBtnClickListener);
        this.mHideBtn.setOnClickListener(this.mBtnClickListener);
        this.mUndoBtn.setOnClickListener(this.undoNredoBtnClickListener);
        this.mRedoBtn.setOnClickListener(this.undoNredoBtnClickListener);
        this.mDocsMenuViewInfo = (Button) findViewById(C0000R.id.docs_menuview_info_text);
        this.mDocsMenuViewInfo.setOnClickListener(this.mBtnClickListener);
        this.mToolbarBtnLayout = (LinearLayout) findViewById(C0000R.id.share_view_toolbar_layout_docs);
        this.mToolbarCaptureLayout = (LinearLayout) findViewById(C0000R.id.camera_btn_layout_docs);
        logI("findViewById SCanvasView");
        this.mSCanvas = (SCanvasView) findViewById(C0000R.id.canvas_view_docs);
        this.mSCanvas.setSPenTouchIDListener(this.mSCanvasOnPenTouchIDListener);
        this.mSCanvas.setSObjectUpdateListener(this.mSObjectListenerUI);
        this.settingViewContainer = (FrameLayout) findViewById(C0000R.id.draw_canvas_docs);
        logI("setSPenTouchIDListener END");
        logI("Resource Map for Layout & Locale");
        HashMap<String, Integer> settingResourceMapInt = SPenSDKUtils.getSettingLayoutLocaleResourceMap(true, true, false, false);
        logI("Resource Map for Custom font path");
        HashMap<String, String> settingResourceMapString = SPenSDKUtils.getSettingLayoutStringResourceMap(true, true, false, false);
        logI("createSettingView");
        this.mSCanvas.createSettingView(this.settingViewContainer, settingResourceMapInt, settingResourceMapString);
        logI("createSettingView END");
        this.mPenColor = findViewById(C0000R.id.pen_color_bar_docs);
        this.mSCanvas.setSettingStrokeChangeListener(new SettingStrokeChangeListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.6
            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeWidthChanged(int arg0) {
                if (DocsMenuView.this.mToolBarLayout != null) {
                    DocsMenuView.this.mToolBarLayout.invalidate();
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeStyleChanged(int arg0) {
                if (DocsMenuView.this.mToolBarLayout != null) {
                    DocsMenuView.this.mToolBarLayout.invalidate();
                }
                if (DocsMenuView.this.mPenBtnLayout != null) {
                    DocsMenuView.this.mPenBtnLayout.invalidate();
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeColorChanged(int arg0) {
                if (DocsMenuView.this.mPenColor != null) {
                    DocsMenuView.this.mPenColor.setBackgroundColor(arg0);
                }
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
        this.mSCanvas.setSCanvasInitializeListener(new SCanvasInitializeListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.7
            @Override // com.samsung.spensdk.applistener.SCanvasInitializeListener
            public void onInitialized() {
                DocsMenuView.this.logI("SCanvasInitializeListener onInitialized");
                DocsMenuView.this.mSCanvas.setSelectLayer(0);
                DocsMenuView.this.mSCanvas.setCanvasMode(10);
                DocsMenuView.this.mSCanvas.setCanvasDrawable(false);
                DocsMenuView.this.mSCanvas.setZoomEnable(false);
                DocsMenuView.this.mSCanvas.setMultiStroke(true);
                DocsMenuView.this.mSCanvas.setUserID(DocsMenuView.this.mUserId);
                DocsMenuView.this.mSCanvas.setMultiTouchCancel(false);
                SettingStrokeInfo sendSettingStrokeInfo = new SettingStrokeInfo();
                sendSettingStrokeInfo.setStrokeStyle(0);
                sendSettingStrokeInfo.setStrokeColor(-15527149);
                sendSettingStrokeInfo.setStrokeWidth(10.0f);
                DocsMenuView.this.mSCanvas.setSettingViewStrokeInfo(sendSettingStrokeInfo);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) DocsMenuView.this.mSCanvas.getLayoutParams();
                layoutParams.width = DocsMenuView.this.mDisMaxSize;
                layoutParams.height = DocsMenuView.this.mDisMaxSize;
                DocsMenuView.this.mSCanvas.setLayoutParams(layoutParams);
                DocsMenuView.this.mPenColor.setBackgroundColor(-15527149);
                DocsMenuView.this.setDocsViewMode(true);
            }
        });
        this.mSCanvas.setHistoryUpdateListener(new HistoryUpdateListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.8
            @Override // com.samsung.spensdk.applistener.HistoryUpdateListener
            public void onHistoryChanged(boolean undoable, boolean redoable) {
                if (DocsMenuView.this.mUndoBtn != null && DocsMenuView.this.mRedoBtn != null) {
                    DocsMenuView.this.logI("onHistoryChanged");
                    DocsMenuView.this.mUndoBtn.setEnabled(undoable);
                    DocsMenuView.this.mRedoBtn.setEnabled(redoable);
                }
            }
        });
        this.mSCanvas.setSCanvasModeChangedListener(new SCanvasModeChangedListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.9
            @Override // com.samsung.spensdk.applistener.SCanvasModeChangedListener
            public void onModeChanged(int mode) {
                DocsMenuView.this.logI("onInitialized updateModeState: " + mode);
            }
        });
        logI("SCanvas Mode Changed Listener END");
        this.mUndoBtn.setEnabled(false);
        this.mRedoBtn.setEnabled(false);
        this.mPenBtn.setSelected(false);
        this.mDocsViewModeBtn.setSelected(true);
        this.mPenWritingCapture = new PenWritingCapture();
        btnHidden(true);
        this.mSCanvas.setSCanvasDeleteAllConfirmListener(this.mSCanvasOnDeleteAllConfirmListener);
        this.mSCanvas.setSettingPresetDeleteBtnClickListener(new SettingPresetDeleteBtnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.10
            @Override // com.samsung.spensdk.applistener.SettingPresetDeleteBtnClickListener
            public void onClick(int nPresetIndex) {
                if (DocsMenuView.this.mSCanvas != null) {
                    DocsMenuView.this.mSCanvas.deleteSettingViewPresetInfo(nPresetIndex, false);
                }
            }
        });
        this.mSCanvas.setOnCancelListener(new CanvasView.OnCancelListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.11
            @Override // com.samsung.sdraw.CanvasView.OnCancelListener
            public void onCancel(int arg0) {
                if (!DocsMenuView.this.isCanceled) {
                    byte[] cmdData = PenWriteNetwork.intToByte(DocsMenuView.this.mUserId);
                    DocsMenuView.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO, cmdData);
                    DocsMenuView.this.isCanceled = true;
                }
            }
        });
    }

    public void setBackGroudSyncImageTouchView() {
        this.mSCanvas.setPanEnable(false);
        this.mSCanvas.setCanvasSize(this.mIDocsViewTouchImage.getViewTouchImage().getDrawable().getIntrinsicWidth(), this.mIDocsViewTouchImage.getViewTouchImage().getDrawable().getIntrinsicHeight());
        Matrix matrixDocs = this.mIDocsViewTouchImage.getMatrix();
        this.mSCanvasMatrix = this.mIDocsViewTouchImage.getMatrix();
        byte[] cmdData = PenWriteNetwork.makeSAMMScreenSize(this.mUserId, this.mIDocsViewTouchImage.getViewTouchImage().getDrawable().getIntrinsicWidth(), this.mIDocsViewTouchImage.getViewTouchImage().getDrawable().getIntrinsicHeight());
        onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_SCREENSIZE, cmdData);
        byte[] cmdData2 = PenWriteNetwork.makeSAMMMatrix(this.mUserId, matrixDocs);
        onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO, cmdData2);
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
        solid.setStrokeWidth(25.0f);
        solid.setStrokeColor(-65536);
        this.mSCanvas.setSettingViewStrokeInfo(solid);
    }

    public void setIChatOnSCanvasView(IDocsViewTouchImage Idocsviewtouchimage) {
        this.mIDocsViewTouchImage = Idocsviewtouchimage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeSettingView() {
        if (this.mSCanvas != null) {
            this.mSCanvas.showSettingView(1, false);
            this.mSCanvas.showSettingView(2, false);
            this.mSCanvas.showSettingView(3, false);
        }
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
        logI("setUserID()");
        this.mUserId = userid;
        this.mSCanvas.setUserID(userid);
    }

    public void setNormalMode(boolean isNormal) {
        if (this.mSCanvas != null) {
            if (isNormal) {
                logI("  ========setNormalMode====  oSCREEN_SHARE_CMD_DOCS_VIEW_MODE ");
                closeSettingView();
                this.mSCanvas.setCanvasDrawable(false);
                this.mSCanvas.setZoomEnable(false);
                if (this.mOnSendCommandData != null) {
                    this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_MODE, null);
                }
                this.mDocsPenMode = false;
                setMenuIconSelected(this.mDocsViewModeBtn.getId());
                return;
            }
            logI("  ========setNormalMode====  SCREEN_SHARE_CMD_DOCS_VIEW_DRAWING_REQ_MODE ");
            this.mSCanvas.setCanvasDrawable(true);
            if (this.mOnSendCommandData != null) {
                this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_VIEW_DRAWING_REQ_MODE, null);
            }
            this.mDocsPenMode = true;
            if (this.mDocsViewModeBtn.isSelected()) {
                this.mSCanvas.setCanvasMode(10);
                this.mSCanvas.showSettingView(1, false);
                setMenuIconSelected(this.mPenBtn.getId());
            }
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
        this.mRecveDraw = true;
        addBoardData(command, data);
        setDrawData(command, data);
    }

    private void setDrawData(int command, byte[] data) {
        logI("setDrawData()");
        switch (command) {
            case 100:
                final MultiSettingStrokeInfo settingInfo = SettingPacket.parserSettingStrokeInfo(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.13
                    @Override // java.lang.Runnable
                    public void run() {
                        DocsMenuView.this.logI("OnRecveData getStrokeStyle " + settingInfo.settingInfo.getStrokeStyle());
                        DocsMenuView.this.mSCanvas.setSettingStrokeInfo(settingInfo.userId, settingInfo.settingInfo);
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO /* 203 */:
                final int destUserID = PenWriteNetwork.byteToInt(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.14
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DocsMenuView.this.mSCanvas.undo(destUserID);
                            DocsMenuView.this.mSCanvas.invalidate();
                        } catch (Exception e) {
                            DocsMenuView.this.logE("mSCanvas.undo: " + e);
                        }
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO /* 204 */:
                final int destUserID2 = PenWriteNetwork.byteToInt(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.15
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DocsMenuView.this.mSCanvas.redo(destUserID2);
                            DocsMenuView.this.mSCanvas.invalidate();
                        } catch (Exception e) {
                            DocsMenuView.this.logE("mSCanvas.redo: " + e);
                        }
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARALL /* 205 */:
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.16
                    @Override // java.lang.Runnable
                    public void run() {
                        DocsMenuView.this.mSCanvas.deleteAll(true);
                        ScreenShareProc.mInstance.initBoardDataController();
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARPAGE /* 206 */:
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.17
                    @Override // java.lang.Runnable
                    public void run() {
                        DocsMenuView.this.mSCanvas.deleteAll(true);
                        DocsMenuView.this.clearPageData();
                    }
                });
                break;
            case 300:
                final PenWriteNetwork.shareSAMMStrokePoint SAMMStrokePoint = PenWriteNetwork.parseSAMMStrokePoint(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.12
                    @Override // java.lang.Runnable
                    public void run() {
                        float rawX;
                        float rawY;
                        DocsMenuView.this.logI("OnRecveData() drawMultiUserSAMMStrokePoint, Action-" + SAMMStrokePoint.Action + ", X=" + SAMMStrokePoint.f6x + ", y=" + SAMMStrokePoint.f7y);
                        if (SAMMStrokePoint.Action == 0) {
                            DocsMenuView.gDownTime = SystemClock.uptimeMillis();
                        }
                        Matrix mSCanvasMatrix = DocsMenuView.this.mIDocsViewTouchImage.getMatrix();
                        float[] matrixVal = new float[9];
                        mSCanvasMatrix.getValues(matrixVal);
                        DocsMenuView.this.mSCanvas.setMatrix(DocsMenuView.this.mIDocsViewTouchImage.getMatrix());
                        if (DocsMenuView.this.mScreenScale != null && DocsMenuView.this.mSCanvas != null) {
                            if (DocsMenuView.this.mRecveDraw) {
                                rawX = DocsMenuView.this.mScreenScale.modifyScaleX(SAMMStrokePoint.f6x);
                                rawY = DocsMenuView.this.mScreenScale.modifyScaleY(SAMMStrokePoint.f7y);
                            } else {
                                rawX = DocsMenuView.this.mScreenScale.modifyScaleX(SAMMStrokePoint.f6x);
                                rawY = DocsMenuView.this.mScreenScale.modifyScaleY(SAMMStrokePoint.f7y);
                            }
                            DocsMenuView.this.mSCanvas.drawMultiUserSAMMStrokePoint(SAMMStrokePoint.MultiUserID, SAMMStrokePoint.MultiStrokeID, SAMMStrokePoint.Action, rawX, rawY, SAMMStrokePoint.pressure, SAMMStrokePoint.sammMetaState, DocsMenuView.gDownTime, DocsMenuView.gDownTime + SAMMStrokePoint.eventtime);
                            DocsMenuView.this.mSCanvas.invalidate();
                        }
                    }
                });
                break;
            case 301:
                final PenWriteNetwork.shareSAMMTextData SAMMTextData = PenWriteNetwork.parseSAMMTextData(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.18
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
                        DocsMenuView.this.mSCanvas.insertSAMMText(SAMMTextData.MultiUserID, SAMMTextData.textID, textData);
                        DocsMenuView.this.mSCanvas.invalidate();
                    }
                });
                break;
            case 302:
                final PenWriteNetwork.shareSAMMTextData SAMMTextData2 = PenWriteNetwork.parseSAMMTextData(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.19
                    @Override // java.lang.Runnable
                    public void run() {
                        RectF r = new RectF(SAMMTextData2.textRectLeft, SAMMTextData2.textRectTop, SAMMTextData2.textRectRight, SAMMTextData2.textRectBottom);
                        SObjectText textData = new SObjectText();
                        textData.setColor(SAMMTextData2.textColor);
                        textData.setRect(r);
                        textData.setStyle(SAMMTextData2.textStyle);
                        textData.setSize(SAMMTextData2.textSize);
                        textData.setText(SAMMTextData2.strText);
                        textData.setLayer(1);
                        DocsMenuView.this.mSCanvas.changeSAMMObject(SAMMTextData2.MultiUserID, SAMMTextData2.textID, textData);
                        DocsMenuView.this.mSCanvas.invalidate();
                    }
                });
                break;
        }
    }

    protected void sendTouchEvent(MotionEvent event, int multiObjectID, int sammMetaState) {
        if (this.mIsTouch) {
            logI("sendTouchEvent : " + this.mDocsPenMode);
            if (this.mDocsPenMode) {
                if (this.mSCanvas != null) {
                    if (event.getAction() == 0) {
                        SettingStrokeInfo settingStrokeInfo = this.mSCanvas.getSettingViewStrokeInfo();
                        byte[] cmdData = SettingPacket.makeSettingStrokeInfo(this.mUserId, settingStrokeInfo);
                        if (this.mSendSettingStrokeInfo == null) {
                            this.mSendSettingStrokeInfo = SettingPacket.copySettingInfo(settingStrokeInfo);
                            this.mSendSettingStrokeInfo.setStrokeAlpha(settingStrokeInfo.getStrokeAlpha());
                            onSendData(100, cmdData);
                        } else {
                            this.mSendSettingStrokeInfo = SettingPacket.copySettingInfo(settingStrokeInfo);
                            onSendData(100, cmdData);
                        }
                    }
                    if (this.mOnSendCommandData != null && this.mScreenScale != null && this.mode != 2) {
                        float[] matrixVal = new float[9];
                        if (this.mSCanvasMatrix != null) {
                            this.mSCanvasMatrix.getValues(matrixVal);
                        }
                        float saveRawX = (this.mScreenScale.modifyExpandScaleX(event.getRawX()) / matrixVal[0]) - (matrixVal[2] / matrixVal[0]);
                        float saveRawY = (this.mScreenScale.modifyExpandScaleY(event.getRawY()) / matrixVal[0]) - (matrixVal[5] / matrixVal[0]);
                        byte[] cmdData2 = PenWriteNetwork.makeSAMMStrokePoint(this.mUserId, multiObjectID, event.getAction(), saveRawX, saveRawY, event.getPressure(), sammMetaState, event.getDownTime(), event.getEventTime() - event.getDownTime());
                        if (this.mSCanvas.getCanvasMode() != 12) {
                            onSendData(300, cmdData2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            this.mIDocsViewTouchImage.TouchEvent(event);
            setPageInfo();
            if (event.getAction() == 1 || event.getAction() == 6) {
                hideDocsViewInfo();
            } else {
                sendMatrix();
            }
        }
    }

    public void sendMatrix() {
        Matrix matrixDocs = this.mIDocsViewTouchImage.getMatrix();
        this.mSCanvasMatrix = matrixDocs;
        this.mSCanvas.setMatrix(matrixDocs);
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
                    DocsMenuView.this.mDocsMenuViewInfo.setVisibility(8);
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

    public void dissmissAlertView() throws Resources.NotFoundException {
        if (this.mClearAlertView != null) {
            this.mClearAlertView.dismiss();
            this.mClearAlertView = null;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int width, int height, int oldWidth, int odHeight) {
        this.mSCanvas.setCanvasSize(width, height);
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
        this.mAlertView.setPositiveButton(C0000R.string.ok, new PageSettingAlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.20
            @Override // com.coolots.chaton.call.screenshare.util.PageSettingAlertView.OnClickListener
            public void onClick(PageSettingAlertView dialog, int which) {
                if (DocsMenuView.this.mAlertView != null) {
                    String page = DocsMenuView.this.mAlertView.getPageText();
                    if (page != null && !page.equals("")) {
                        DocsMenuView.this.mIDocsViewTouchImage.setPageSwap(Integer.parseInt(page));
                        DocsMenuView.this.setPageInfo();
                    }
                    InputMethodManager imm2 = (InputMethodManager) DocsMenuView.this.mContext.getSystemService("input_method");
                    imm2.hideSoftInputFromWindow(DocsMenuView.this.mAlertView.getTextView().getWindowToken(), 0);
                }
            }
        });
        this.mAlertView.setNegativeButton(C0000R.string.cancel, new PageSettingAlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.21
            @Override // com.coolots.chaton.call.screenshare.util.PageSettingAlertView.OnClickListener
            public void onClick(PageSettingAlertView dialog, int which) {
                InputMethodManager imm2 = (InputMethodManager) DocsMenuView.this.mContext.getSystemService("input_method");
                imm2.hideSoftInputFromWindow(DocsMenuView.this.mAlertView.getTextView().getWindowToken(), 0);
            }
        });
        this.mAlertView.setLeftArrowButton((String) null, new PageSettingAlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.22
            @Override // com.coolots.chaton.call.screenshare.util.PageSettingAlertView.OnClickListener
            public void onClick(PageSettingAlertView dialog, int which) {
                if (DocsMenuView.this.mTempCur - 1 > 0) {
                    DocsMenuView docsMenuView = DocsMenuView.this;
                    docsMenuView.mTempCur--;
                    DocsMenuView.this.mAlertView.setPageText(Integer.toString(DocsMenuView.this.mTempCur));
                } else {
                    DocsMenuView.this.mTempCur = DocsMenuView.this.mIDocsViewTouchImage.getMaxPageNumber();
                    DocsMenuView.this.mAlertView.setPageText(Integer.toString(DocsMenuView.this.mTempCur));
                }
            }
        });
        this.mAlertView.setRightArrowButton((String) null, new PageSettingAlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.DocsMenuView.23
            @Override // com.coolots.chaton.call.screenshare.util.PageSettingAlertView.OnClickListener
            public void onClick(PageSettingAlertView dialog, int which) {
                if (DocsMenuView.this.mTempCur + 1 > DocsMenuView.this.mIDocsViewTouchImage.getMaxPageNumber()) {
                    if (DocsMenuView.this.mTempCur + 1 > DocsMenuView.this.mIDocsViewTouchImage.getMaxPageNumber()) {
                        DocsMenuView.this.mTempCur = 1;
                        DocsMenuView.this.mAlertView.setPageText(Integer.toString(DocsMenuView.this.mTempCur));
                        return;
                    }
                    return;
                }
                DocsMenuView.this.mTempCur++;
                DocsMenuView.this.mAlertView.setPageText(Integer.toString(DocsMenuView.this.mTempCur));
            }
        });
        this.mAlertView.setCancelable(true);
        this.mAlertView.show();
        this.mAlertView.setPageText(Integer.toString(this.mTempCur));
        this.mAlertView.setPageTextFilter(this.mIDocsViewTouchImage);
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
        if (this.mTextBtn != null) {
            this.mTextBtn.removeCallbacks(null);
            this.mTextBtn = null;
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
        if (this.mSCanvasMatrix != null) {
            this.mSCanvasMatrix = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowFocusChanged(boolean hasWindowFocus) {
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
                    if (this.settingViewContainer != null) {
                        this.settingViewContainer.setVisibility(0);
                    }
                    if (this.mSCanvas != null) {
                        this.mSCanvas.setVisibility(0);
                    }
                }
            } else {
                MainApplication.mPhoneManager.getShareScreenManager().pauseShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), 0);
                if (this.mToolBarLayout != null) {
                    this.mToolBarLayout.setVisibility(8);
                }
                if (this.settingViewContainer != null && this.settingViewContainer.isShown()) {
                    this.settingViewContainer.setVisibility(8);
                }
                if (this.mDocsMenuViewInfoHandler != null) {
                    this.mDocsMenuViewInfoHandler.sendEmptyMessage(1000);
                }
                if (this.mSCanvas != null) {
                    this.mSCanvas.setVisibility(4);
                }
            }
            super.dispatchWindowFocusChanged(hasWindowFocus);
        }
    }

    private boolean isShowingDialog() {
        if (this.mAlertView == null || !this.mAlertView.isShown()) {
            return this.mClearAlertView != null && this.mClearAlertView.isShown();
        }
        return true;
    }

    public void getPageCanvas(int page) {
        ArrayList<BoardData> boardData;
        byte[] cmdPage = ScreenShareRemotePacket.makeRemoteKey(page);
        if (this.mOnSendCommandData != null) {
            this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_MOVE_PAGE, cmdPage);
        }
        logI("getPageCanvas : " + page);
        if (this.mDataController != null) {
            this.mDataController.getCurrentContainer(page);
        }
        if (this.mCurrentPage == -1 || this.mCurrentPage != page) {
            this.mCurrentPage = page;
            this.mSCanvas.deleteAll(true);
            if (this.mDataController != null && (boardData = this.mDataController.getCurrentPageData(page)) != null) {
                logI("getPageCanvas size : " + boardData.size());
                this.mRecveDraw = false;
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSendData(int type, byte[] data) {
        if (this.mOnSendCommandData != null) {
            this.mOnSendCommandData.onSendData(type, data);
            addBoardData(type, data);
        }
    }

    private void addBoardData(int type, byte[] data) {
        if (this.mDataController != null) {
            logI("onSendData add data  page: " + this.mIDocsViewTouchImage.getCurrentPageNumber());
            this.mDataController.addBoardData(this.mIDocsViewTouchImage.getCurrentPageNumber(), type, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPageData() {
        if (this.mDataController != null) {
            this.mDataController.removeBoardDataInPage(this.mIDocsViewTouchImage.getCurrentPageNumber());
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

    public void setDocsName(String name) {
        this.mDataController.setDocsName(name);
    }

    public void setDocsFilePath(String filePath) {
        this.mDataController.setFilePath(filePath);
    }

    public String getDocsFilePath() {
        return this.mDataController.getFilePath();
    }

    public String getDocsName() {
        return this.mDataController.getDocsName();
    }

    public void setDocsTotalPageNum(int totalPage) {
        this.mDataController.setDocsToltalPageNum(totalPage);
    }

    public int getDocsToltalPageNum() {
        return this.mDataController.getDocsToltalPageNum();
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
}
