package com.coolots.chaton.call.screenshare.activity;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
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
import com.coolots.chaton.call.screenshare.util.MultiSettingStrokeInfo;
import com.coolots.chaton.call.screenshare.util.PenWriteNetwork;
import com.coolots.chaton.call.screenshare.util.PenWritingCapture;
import com.coolots.chaton.call.screenshare.util.SPenSDKUtils;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.coolots.chaton.call.screenshare.util.SettingPacket;
import com.coolots.chaton.common.util.ChatONDialog;
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

/* loaded from: classes.dex */
public class PenWritingViewLayout extends ScreenShareLayout implements DisposeInterface {
    private static final String CLASSNAME = "[PenWritingViewLayout]";
    private static long gDownTime;
    private final int DRAG;
    private final int MULTITOUCH;
    private final int NONE;
    private boolean isCanceled;
    private boolean isHidden;
    private View.OnClickListener mBtnClickListener;
    private ImageView mCaptureBtn;
    private ImageView mClearBtn;
    private Display mDisplay;
    private Button mEndBtn;
    private ImageView mEraserBtn;
    private Handler mHandler;
    private ImageView mHideBtn;
    private RelativeLayout.LayoutParams mLayoutParams;
    private ArrayList<byte[]> mNoInitialData;
    private ImageView mPenBtn;
    private View mPenColor;
    private PenWritingCapture mPenWritingCapture;
    private ImageView mRedoBtn;
    private SCanvasView mSCanvas;
    private boolean mSCanvasInital;
    SCanvasDeleteAllConfirmListener mSCanvasOnDeleteAllConfirmListener;
    SPenTouchIDListener mSCanvasOnPenTouchIDListener;
    SObjectUpdateListener mSObjectListenerUI;
    private ScreenShareActivity mScreenShareActivity;
    private SettingStrokeInfo mSendSettingStrokeInfo;
    private FrameLayout mSettingViewContainer;
    private RelativeLayout mShareViewToolbarLayout;
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

    public PenWritingViewLayout(Context context, int layoutResId, ScreenShareActivity screenShareActivity) {
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
        this.mSCanvasOnDeleteAllConfirmListener = new SCanvasDeleteAllConfirmListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.1
            @Override // com.samsung.spensdk.applistener.SCanvasDeleteAllConfirmListener
            public boolean onDeleteAllConfirm(int nLayerID) {
                ChatONDialog.Builder dialogs = new ChatONDialog.Builder(ScreenShareActivity.mInstance);
                dialogs.setTitle(C0000R.string.screenshare_alertView_attention_title);
                dialogs.setMessage(C0000R.string.screenshare_alertView_attention_message);
                dialogs.setPositiveButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        PenWritingViewLayout.this.mSCanvas.deleteAll(true);
                        PenWritingViewLayout.this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARALL, null);
                    }
                });
                dialogs.setNegativeButton(C0000R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.1.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });
                dialogs.setCancelable(true);
                dialogs.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.1.3
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface arg0) {
                        PenWritingViewLayout.this.logI("haeri= back key press!!!!");
                    }
                });
                dialogs.show();
                return true;
            }
        };
        this.mBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int nBtnID = view.getId();
                if (nBtnID == PenWritingViewLayout.this.mPenBtn.getId()) {
                    if (PenWritingViewLayout.this.mSCanvas.getCanvasMode() == 10) {
                        PenWritingViewLayout.this.mSCanvas.setSettingViewSizeOption(1, 2);
                        PenWritingViewLayout.this.mSCanvas.toggleShowSettingView(1);
                        return;
                    } else {
                        PenWritingViewLayout.this.mSCanvas.setCanvasMode(10);
                        PenWritingViewLayout.this.mSCanvas.showSettingView(1, false);
                        PenWritingViewLayout.this.updateModeState();
                        return;
                    }
                }
                if (nBtnID == PenWritingViewLayout.this.mEraserBtn.getId()) {
                    if (PenWritingViewLayout.this.mSCanvas.getCanvasMode() == 11) {
                        PenWritingViewLayout.this.mSCanvas.setSettingViewSizeOption(2, 0);
                        PenWritingViewLayout.this.mSCanvas.toggleShowSettingView(2);
                        return;
                    } else {
                        PenWritingViewLayout.this.mSCanvas.setCanvasMode(11);
                        PenWritingViewLayout.this.mSCanvas.showSettingView(2, false);
                        PenWritingViewLayout.this.updateModeState();
                        return;
                    }
                }
                if (nBtnID == PenWritingViewLayout.this.mClearBtn.getId()) {
                    if (PenWritingViewLayout.this.mSCanvas.getCanvasMode() == 12) {
                        PenWritingViewLayout.this.mSCanvas.setSettingViewSizeOption(3, 1);
                        PenWritingViewLayout.this.mSCanvas.toggleShowSettingView(3);
                        return;
                    } else {
                        PenWritingViewLayout.this.mSCanvas.setCanvasMode(12);
                        PenWritingViewLayout.this.mSCanvas.showSettingView(3, false);
                        PenWritingViewLayout.this.updateModeState();
                        return;
                    }
                }
                if (nBtnID == PenWritingViewLayout.this.mEndBtn.getId()) {
                    PenWritingViewLayout.this.logI("PenWriting EndBtn Clicked ");
                    PenWritingViewLayout.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_SHARE_MODE, null);
                    PenWritingViewLayout.this.mScreenShareActivity.setOtherPause(false);
                    PenWritingViewLayout.this.mScreenShareActivity.chageShareView();
                    return;
                }
                if (nBtnID == PenWritingViewLayout.this.mCaptureBtn.getId()) {
                    PenWritingViewLayout.this.logI("PenWritingCapture is Clicked!!");
                    int res = PenWritingViewLayout.this.mPenWritingCapture.ScreenOtherCapture();
                    if (res < 0) {
                        ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_pen_writing_capture_fail), 0);
                        return;
                    } else {
                        ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_pen_writing_capture), 0);
                        return;
                    }
                }
                if (nBtnID != PenWritingViewLayout.this.mHideBtn.getId()) {
                    return;
                }
                PenWritingViewLayout.this.btnHidden(PenWritingViewLayout.this.isHidden);
                if (PenWritingViewLayout.this.mSCanvas.getCanvasMode() == 10) {
                    PenWritingViewLayout.this.mSCanvas.setCanvasMode(10);
                    PenWritingViewLayout.this.mSCanvas.showSettingView(1, false);
                } else if (PenWritingViewLayout.this.mSCanvas.getCanvasMode() == 11) {
                    PenWritingViewLayout.this.mSCanvas.setCanvasMode(11);
                    PenWritingViewLayout.this.mSCanvas.showSettingView(2, false);
                } else if (PenWritingViewLayout.this.mSCanvas.getCanvasMode() == 12) {
                    PenWritingViewLayout.this.mSCanvas.setCanvasMode(12);
                    PenWritingViewLayout.this.mSCanvas.showSettingView(3, false);
                }
            }
        };
        this.undoNredoBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PenWritingViewLayout.this.logI("undoNredoBtnClickListener()");
                int nBtnID = view.getId();
                byte[] cmdData = PenWriteNetwork.intToByte(PenWritingViewLayout.this.mUserID);
                if (nBtnID == PenWritingViewLayout.this.mUndoBtn.getId()) {
                    PenWritingViewLayout.this.mSCanvas.undo();
                    PenWritingViewLayout.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO, cmdData);
                } else if (nBtnID == PenWritingViewLayout.this.mRedoBtn.getId()) {
                    PenWritingViewLayout.this.mSCanvas.redo();
                    PenWritingViewLayout.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO, cmdData);
                }
                PenWritingViewLayout.this.mUndoBtn.setEnabled(PenWritingViewLayout.this.mSCanvas.isUndoable());
                PenWritingViewLayout.this.mRedoBtn.setEnabled(PenWritingViewLayout.this.mSCanvas.isRedoable());
            }
        };
        this.mSObjectListenerUI = new SObjectUpdateListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.4
            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectChanged(SObject sObject, boolean byUndo, boolean byRedo) {
                PenWritingViewLayout.this.logI("onSObjectChanged  byUndo = " + byUndo + " , byRedo = " + byRedo);
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
                        byte[] cmdData = PenWriteNetwork.makeSAMMTextInput(PenWritingViewLayout.this.mUserID, mutiTextId, nColor, nStyle, fSize, rRect.left, rRect.top, rRect.right, rRect.bottom, strFont, strText);
                        if (PenWritingViewLayout.this.mSCanvas.getCanvasMode() != 12) {
                            return;
                        }
                        PenWritingViewLayout.this.onSendData(302, cmdData);
                    }
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeleted(SObject sObject, boolean byUndo, boolean byRedo, boolean arg3) {
                PenWritingViewLayout.this.logI("onSObjectDeleted  byUndo = " + byUndo + " , byRedo = " + byRedo + " , arg3 = " + arg3);
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
                        byte[] cmdData = PenWriteNetwork.makeSAMMTextInput(PenWritingViewLayout.this.mUserID, mutiTextId, nColor, nStyle, fSize, rRect.left, rRect.top, rRect.right, rRect.bottom, strFont, "");
                        if (PenWritingViewLayout.this.mSCanvas.getCanvasMode() != 12) {
                            return;
                        }
                        PenWritingViewLayout.this.onSendData(302, cmdData);
                    }
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeletedAll(boolean arg0, int arg1) {
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectInserted(SObject sObject, boolean byUndo, boolean byRedo) {
                PenWritingViewLayout.this.logI("onSObjectInserted  byUndo = " + byUndo + " , byRedo = " + byRedo);
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
                        byte[] cmdData = PenWriteNetwork.makeSAMMTextInput(PenWritingViewLayout.this.mUserID, mutiTextId, nColor, nStyle, fSize, rRect.left, rRect.top, rRect.right, rRect.bottom, strFont, strText);
                        if (PenWritingViewLayout.this.mSCanvas.getCanvasMode() != 12) {
                            return;
                        }
                        PenWritingViewLayout.this.onSendData(301, cmdData);
                    }
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectSelected(SObject arg0, boolean bSelected) {
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public boolean onSObjectStrokeInserting(SObjectStroke arg0) {
                return false;
            }
        };
        this.mSCanvasOnPenTouchIDListener = new SPenTouchIDListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.5
            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchFinger(View view, MotionEvent event, int multiObjectID) {
                PenWritingViewLayout.this.setTouchMode(event);
                PenWritingViewLayout.this.sendTouchEvent(event, multiObjectID, 0);
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPen(View view, MotionEvent event, int multiObjectID) {
                PenWritingViewLayout.this.sendTouchEvent(event, multiObjectID, 1);
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPenEraser(View view, MotionEvent event, int multiObjectID) {
                PenWritingViewLayout.this.sendTouchEvent(event, multiObjectID, 2);
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
    }

    private void initScaleData() {
        this.mScreenShareActivity.initScaleData();
    }

    public void setPenDocsMode(boolean isPenMode) {
    }

    private void load() {
        logI("load UI Setting");
        this.mPenBtn = (ImageView) findViewById(C0000R.id.pen_btn);
        this.mEraserBtn = (ImageView) findViewById(C0000R.id.eraser_btn);
        this.mUndoBtn = (ImageView) findViewById(C0000R.id.undo_btn);
        this.mRedoBtn = (ImageView) findViewById(C0000R.id.redo_btn);
        this.mCaptureBtn = (ImageView) findViewById(C0000R.id.camera_btn);
        this.mClearBtn = (ImageView) findViewById(C0000R.id.clear_btn);
        this.mEndBtn = (Button) findViewById(C0000R.id.end_btn);
        this.mPenBtn.setOnClickListener(this.mBtnClickListener);
        this.mEraserBtn.setOnClickListener(this.mBtnClickListener);
        this.mClearBtn.setOnClickListener(this.mBtnClickListener);
        this.mCaptureBtn.setOnClickListener(this.mBtnClickListener);
        this.mEndBtn.setOnClickListener(this.mBtnClickListener);
        this.mUndoBtn.setOnClickListener(this.undoNredoBtnClickListener);
        this.mRedoBtn.setOnClickListener(this.undoNredoBtnClickListener);
        this.mShareViewToolbarLayout = (RelativeLayout) findViewById(C0000R.id.share_view_toolbar_layout1);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mShareViewToolbarLayout.getLayoutParams();
        layoutParams.width = this.mDisplay.getWidth() > this.mDisplay.getHeight() ? this.mDisplay.getHeight() : this.mDisplay.getWidth();
        this.mShareViewToolbarLayout.setLayoutParams(layoutParams);
        this.mToolbarBtnLayout = (LinearLayout) findViewById(C0000R.id.share_view_toolbar_layout);
        this.mToolbarCaptureLayout = (LinearLayout) findViewById(C0000R.id.camera_btn_layout);
        this.mHideBtn = (ImageView) findViewById(C0000R.id.showhide_btn);
        this.mHideBtn.setOnClickListener(this.mBtnClickListener);
        this.mSCanvas = (SCanvasView) findViewById(C0000R.id.canvas_view);
        this.mSCanvas.setSelectLayer(0);
        this.mSCanvas.setSPenTouchIDListener(this.mSCanvasOnPenTouchIDListener);
        this.mSCanvas.setSObjectUpdateListener(this.mSObjectListenerUI);
        HashMap<String, Integer> settingResourceMapInt = SPenSDKUtils.getSettingLayoutLocaleResourceMap(true, true, false, false);
        HashMap<String, String> settingResourceMapString = SPenSDKUtils.getSettingLayoutStringResourceMap(true, true, false, false);
        this.mSettingViewContainer = (FrameLayout) findViewById(C0000R.id.draw_canvas);
        this.mSCanvas.createSettingView(this.mSettingViewContainer, settingResourceMapInt, settingResourceMapString);
        this.mPenColor = findViewById(C0000R.id.pen_color_bar);
        this.mSCanvas.setSettingStrokeChangeListener(new SettingStrokeChangeListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.6
            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeWidthChanged(int arg0) {
                if (PenWritingViewLayout.this.mShareViewToolbarLayout != null) {
                    PenWritingViewLayout.this.mShareViewToolbarLayout.invalidate();
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeStyleChanged(int arg0) {
                if (PenWritingViewLayout.this.mShareViewToolbarLayout != null) {
                    PenWritingViewLayout.this.mShareViewToolbarLayout.invalidate();
                }
                if (PenWritingViewLayout.this.mPenColor != null) {
                    PenWritingViewLayout.this.mPenColor.invalidate();
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeColorChanged(int arg0) {
                PenWritingViewLayout.this.logI("mPenColor.setBackgroundColor(arg0)");
                if (PenWritingViewLayout.this.mPenColor != null) {
                    PenWritingViewLayout.this.mPenColor.setBackgroundColor(arg0);
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
        this.mSCanvas.setSCanvasInitializeListener(new SCanvasInitializeListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.7
            @Override // com.samsung.spensdk.applistener.SCanvasInitializeListener
            public void onInitialized() {
                PenWritingViewLayout.this.logI("SCanvasInitializeListener onInitialized");
                PenWritingViewLayout.this.mSCanvas.setSelectLayer(0);
                PenWritingViewLayout.this.mSCanvas.setCanvasMode(10);
                PenWritingViewLayout.this.mSCanvas.setMultiStroke(true);
                PenWritingViewLayout.this.mSCanvas.setUserID(PenWritingViewLayout.this.mUserID);
                PenWritingViewLayout.this.mSCanvas.setMultiTouchCancel(false);
                SettingStrokeInfo sendSettingStrokeInfo = new SettingStrokeInfo();
                sendSettingStrokeInfo.setStrokeStyle(0);
                sendSettingStrokeInfo.setStrokeColor(-5921371);
                PenWritingViewLayout.this.logI("mPenColor.setBackgroundColor(Color.GRAY)");
                PenWritingViewLayout.this.mPenColor.setBackgroundColor(-5921371);
                sendSettingStrokeInfo.setStrokeWidth(10.0f);
                PenWritingViewLayout.this.mSCanvas.setSettingViewStrokeInfo(sendSettingStrokeInfo);
                PenWritingViewLayout.this.mSCanvas.setZoomEnable(false);
                PenWritingViewLayout.this.mLayoutParams = (RelativeLayout.LayoutParams) PenWritingViewLayout.this.mSCanvas.getLayoutParams();
                Point disSize = new Point();
                PenWritingViewLayout.this.mDisplay.getSize(disSize);
                PenWritingViewLayout.this.mLayoutParams.width = disSize.x;
                PenWritingViewLayout.this.mLayoutParams.height = disSize.y;
                PenWritingViewLayout.this.mSCanvas.setLayoutParams(PenWritingViewLayout.this.mLayoutParams);
                PenWritingViewLayout.this.mSCanvas.setCanvasSize(disSize.x, disSize.y);
                PenWritingViewLayout.this.mSCanvasInital = true;
                PenWritingViewLayout.this.updateModeState();
                PenWritingViewLayout.this.addDrawPenData();
            }
        });
        this.mSCanvas.setHistoryUpdateListener(new HistoryUpdateListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.8
            @Override // com.samsung.spensdk.applistener.HistoryUpdateListener
            public void onHistoryChanged(boolean undoable, boolean redoable) {
                PenWritingViewLayout.this.mUndoBtn.setEnabled(undoable);
                PenWritingViewLayout.this.mRedoBtn.setEnabled(redoable);
            }
        });
        this.mSCanvas.setSCanvasModeChangedListener(new SCanvasModeChangedListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.9
            @Override // com.samsung.spensdk.applistener.SCanvasModeChangedListener
            public void onModeChanged(int mode) {
                PenWritingViewLayout.this.logI("setSCanvasModeChangedListener()");
                PenWritingViewLayout.this.updateModeState();
            }
        });
        this.mUndoBtn.setEnabled(false);
        this.mRedoBtn.setEnabled(false);
        this.mPenBtn.setSelected(true);
        this.mPenWritingCapture = new PenWritingCapture();
        this.mSCanvas.setSCanvasDeleteAllConfirmListener(this.mSCanvasOnDeleteAllConfirmListener);
        this.mSCanvas.setSettingPresetDeleteBtnClickListener(new SettingPresetDeleteBtnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.10
            @Override // com.samsung.spensdk.applistener.SettingPresetDeleteBtnClickListener
            public void onClick(int nPresetIndex) {
                PenWritingViewLayout.this.mSCanvas.deleteSettingViewPresetInfo(nPresetIndex, false);
            }
        });
        this.mSCanvas.setOnCancelListener(new CanvasView.OnCancelListener() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.11
            @Override // com.samsung.sdraw.CanvasView.OnCancelListener
            public void onCancel(int arg0) {
                if (!PenWritingViewLayout.this.isCanceled) {
                    byte[] cmdData = PenWriteNetwork.intToByte(PenWritingViewLayout.this.mUserID);
                    PenWritingViewLayout.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO, cmdData);
                    PenWritingViewLayout.this.isCanceled = true;
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
        penToolbarResize();
        super.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateModeState() {
        logI("updateModeState()");
        int nCurMode = this.mSCanvas.getCanvasMode();
        this.mPenBtn.setSelected(nCurMode == 10);
        this.mEraserBtn.setSelected(nCurMode == 11);
        this.mClearBtn.setSelected(nCurMode == 12);
    }

    public void setUserID(int userid) {
        this.mUserID = userid;
        this.mSCanvas.setUserID(userid);
    }

    @Override // com.coolots.chaton.call.screenshare.activity.ScreenShareLayout
    public void OnRecveData(int command, final byte[] data) {
        logI("OnRecveData():" + command);
        switch (command) {
            case 100:
                final MultiSettingStrokeInfo settingInfo = SettingPacket.parserSettingStrokeInfo(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.13
                    @Override // java.lang.Runnable
                    public void run() {
                        PenWritingViewLayout.this.mSCanvas.setSettingStrokeInfo(settingInfo.userId, settingInfo.settingInfo);
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO /* 203 */:
                final int destUserID = PenWriteNetwork.byteToInt(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.14
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            PenWritingViewLayout.this.mSCanvas.undo(destUserID);
                        } catch (Exception e) {
                            PenWritingViewLayout.this.logE("mSCanvas.undo: " + e);
                        }
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO /* 204 */:
                final int destUserID2 = PenWriteNetwork.byteToInt(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.15
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            PenWritingViewLayout.this.mSCanvas.redo(destUserID2);
                        } catch (Exception e) {
                            PenWritingViewLayout.this.logE("mSCanvas.redo: " + e);
                        }
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARALL /* 205 */:
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.16
                    @Override // java.lang.Runnable
                    public void run() {
                        PenWritingViewLayout.this.mSCanvas.deleteAll(true);
                    }
                });
                break;
            case 300:
                final PenWriteNetwork.shareSAMMStrokePoint SAMMStrokePoint = PenWriteNetwork.parseSAMMStrokePoint(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SAMMStrokePoint == null) {
                            PenWritingViewLayout.this.logI("OnRecveData() SAMMStrokePoint is null");
                            return;
                        }
                        if (SAMMStrokePoint.Action == 0) {
                            PenWritingViewLayout.gDownTime = SystemClock.uptimeMillis();
                        }
                        float rawX = PenWritingViewLayout.this.mScreenShareActivity.mScreenScale.modifyScaleX(SAMMStrokePoint.f6x);
                        float rawY = PenWritingViewLayout.this.mScreenShareActivity.mScreenScale.modifyScaleY(SAMMStrokePoint.f7y);
                        boolean result = PenWritingViewLayout.this.mSCanvas.drawMultiUserSAMMStrokePoint(SAMMStrokePoint.MultiUserID, SAMMStrokePoint.MultiStrokeID, SAMMStrokePoint.Action, rawX, rawY, SAMMStrokePoint.pressure, SAMMStrokePoint.sammMetaState, PenWritingViewLayout.gDownTime, PenWritingViewLayout.gDownTime + SAMMStrokePoint.eventtime);
                        PenWritingViewLayout.this.mSCanvas.invalidate();
                        if (!result || !PenWritingViewLayout.this.mSCanvasInital) {
                            PenWritingViewLayout.this.mNoInitialData.add(data);
                        }
                    }
                });
                break;
            case 301:
                final PenWriteNetwork.shareSAMMTextData SAMMTextData = PenWriteNetwork.parseSAMMTextData(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.17
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
                        PenWritingViewLayout.this.mSCanvas.insertSAMMText(SAMMTextData.MultiUserID, SAMMTextData.textID, textData);
                        PenWritingViewLayout.this.mSCanvas.invalidate();
                    }
                });
                break;
            case 302:
                final PenWriteNetwork.shareSAMMTextData SAMMTextData2 = PenWriteNetwork.parseSAMMTextData(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.PenWritingViewLayout.18
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
                        PenWritingViewLayout.this.mSCanvas.changeSAMMObject(SAMMTextData2.MultiUserID, SAMMTextData2.textID, textData);
                        PenWritingViewLayout.this.mSCanvas.invalidate();
                    }
                });
                break;
        }
    }

    protected void sendTouchEvent(MotionEvent event, int multiObjectID, int sammMetaState) {
        SettingStrokeInfo settingStrokeInfo;
        if (event.getAction() == 0 && (settingStrokeInfo = this.mSCanvas.getSettingViewStrokeInfo()) != null) {
            byte[] cmdData = SettingPacket.makeSettingStrokeInfo(this.mUserID, settingStrokeInfo);
            if (this.mSendSettingStrokeInfo == null) {
                this.mSendSettingStrokeInfo = SettingPacket.copySettingInfo(settingStrokeInfo);
                this.mSendSettingStrokeInfo.setStrokeAlpha(settingStrokeInfo.getStrokeAlpha());
                onSendData(100, cmdData);
            } else if (!SettingPacket.equalsSettingInfo(this.mSendSettingStrokeInfo, settingStrokeInfo)) {
                this.mSendSettingStrokeInfo = SettingPacket.copySettingInfo(settingStrokeInfo);
                onSendData(100, cmdData);
            }
        }
        if (this.mSCanvas != null && this.mode != 2) {
            float rawX = event.getRawX();
            float rawY = event.getRawY();
            if (this.mScreenShareActivity != null && this.mScreenShareActivity.mScreenScale != null) {
                rawX = this.mScreenShareActivity.mScreenScale.modifyExpandScaleX(event.getRawX());
                rawY = this.mScreenShareActivity.mScreenScale.modifyExpandScaleY(event.getRawY());
            }
            byte[] cmdData2 = PenWriteNetwork.makeSAMMStrokePoint(this.mUserID, multiObjectID, event.getAction(), rawX, rawY, event.getPressure(), sammMetaState, event.getDownTime(), event.getEventTime() - event.getDownTime());
            if (this.mSCanvas.getCanvasMode() != 12) {
                onSendData(300, cmdData2);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void onSendData(int command, byte[] cmdData) {
        if (this.mOnSendCommandData != null) {
            this.mOnSendCommandData.onSendData(command, cmdData);
        }
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
}
