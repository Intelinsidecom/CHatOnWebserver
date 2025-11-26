package com.coolots.chaton.call.screenshare;

import android.app.Service;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Handler;
import android.os.SystemClock;
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
import com.coolots.chaton.call.screenshare.util.PenMenuView;
import com.coolots.chaton.call.screenshare.util.PenWriteNetwork;
import com.coolots.chaton.call.screenshare.util.SPenSDKUtils;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
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
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.HashMap;

/* loaded from: classes.dex */
public class PenWritingView extends OverlayView implements DisposeInterface {
    private static final String CLASSNAME = "[PenWritingView]";
    private static long gDownTime;
    private final int DRAG;
    private final int MULTITOUCH;
    private final int NONE;
    private boolean isCanceled;
    private AlertView mClearAlertView;
    private int mDisMaxSize;
    private int mDisMinSize;
    private Handler mHandler;
    private boolean mIsConference;
    private PenMenuView mPenMenuView;
    private SCanvasView mSCanvas;
    SCanvasDeleteAllConfirmListener mSCanvasOnDeleteAllConfirmListener;
    SPenTouchIDListener mSCanvasOnPenTouchIDListener;
    SObjectUpdateListener mSObjectListenerUI;
    private ScreenShareScale mScreenScale;
    private SettingStrokeInfo mSendSettingStrokeInfo;
    private int mode;
    public WindowManager windowManager;

    /* JADX INFO: Access modifiers changed from: private */
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public PenWritingView(Service service) {
        super(service, C0000R.layout.screenshare_pen_writing_canvas);
        this.NONE = 0;
        this.DRAG = 1;
        this.MULTITOUCH = 2;
        this.mode = 0;
        this.isCanceled = false;
        this.mHandler = new Handler();
        this.windowManager = null;
        this.mIsConference = false;
        this.mSCanvasOnDeleteAllConfirmListener = new SCanvasDeleteAllConfirmListener() { // from class: com.coolots.chaton.call.screenshare.PenWritingView.1
            @Override // com.samsung.spensdk.applistener.SCanvasDeleteAllConfirmListener
            public boolean onDeleteAllConfirm(int nLayerID) throws Resources.NotFoundException {
                PenWritingView.this.mClearAlertView = new AlertView(ScreenSharePopupMenu.mParent);
                PenWritingView.this.mClearAlertView.setTitle(C0000R.string.screenshare_alertView_attention_title);
                PenWritingView.this.mClearAlertView.setMessage(C0000R.string.screenshare_alertView_attention_message);
                PenWritingView.this.mClearAlertView.setPositiveButton(C0000R.string.ok, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.PenWritingView.1.1
                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                    public void onClick(AlertView dialog, int which) {
                        PenWritingView.this.mSCanvas.deleteAll(true);
                        PenWritingView.this.mOnSendCommandData.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARALL, null);
                    }
                });
                PenWritingView.this.mClearAlertView.setNegativeButton(C0000R.string.cancel, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.PenWritingView.1.2
                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                    public void onClick(AlertView dialog, int which) {
                    }
                });
                PenWritingView.this.mClearAlertView.setCancelable(true);
                PenWritingView.this.mClearAlertView.show();
                return true;
            }
        };
        this.mSObjectListenerUI = new SObjectUpdateListener() { // from class: com.coolots.chaton.call.screenshare.PenWritingView.2
            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectChanged(SObject sObject, boolean byUndo, boolean byRedo) {
                PenWritingView.this.logI("onSObjectChanged  byUndo: " + byUndo + " byRedo: " + byRedo);
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
                        byte[] cmdData = PenWriteNetwork.makeSAMMTextInput(PenWritingView.this.mUserId, mutiTextId, nColor, nStyle, fSize, rRect.left, rRect.top, rRect.right, rRect.bottom, strFont, strText);
                        if (PenWritingView.this.mSCanvas.getCanvasMode() != 12) {
                            return;
                        }
                        PenWritingView.this.onSendData(302, cmdData);
                    }
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeleted(SObject sObject, boolean byUndo, boolean byRedo, boolean bFreeMemory) {
                PenWritingView.this.logI("onSObjectDeleted  byUndo: " + byUndo + " byRedo: " + byRedo);
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
                        byte[] cmdData = PenWriteNetwork.makeSAMMTextInput(PenWritingView.this.mUserId, mutiTextId, nColor, nStyle, fSize, rRect.left, rRect.top, rRect.right, rRect.bottom, strFont, "");
                        if (PenWritingView.this.mSCanvas.getCanvasMode() != 12) {
                            return;
                        }
                        PenWritingView.this.onSendData(302, cmdData);
                    }
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeletedAll(boolean bFreeMemory, int nLayer) {
                PenWritingView.this.logI("onSObjectDeletedAll  bFreeMemory: " + bFreeMemory + " nLayer: " + nLayer);
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectInserted(SObject sObject, boolean byUndo, boolean byRedo) {
                PenWritingView.this.logI("onSObjectInserted  byUndo: " + byUndo + " byRedo: " + byRedo);
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
                        byte[] cmdData = PenWriteNetwork.makeSAMMTextInput(PenWritingView.this.mUserId, mutiTextId, nColor, nStyle, fSize, rRect.left, rRect.top, rRect.right, rRect.bottom, strFont, strText);
                        if (PenWritingView.this.mSCanvas.getCanvasMode() != 12) {
                            return;
                        }
                        PenWritingView.this.onSendData(301, cmdData);
                    }
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectSelected(SObject sObject, boolean bSelected) {
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public boolean onSObjectStrokeInserting(SObjectStroke arg0) {
                return false;
            }
        };
        this.mSCanvasOnPenTouchIDListener = new SPenTouchIDListener() { // from class: com.coolots.chaton.call.screenshare.PenWritingView.3
            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchFinger(View view, MotionEvent event, int multiObjectID) {
                PenWritingView.this.setTouchMode(event);
                PenWritingView.this.sendTouchEvent(event, multiObjectID, 0);
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPen(View view, MotionEvent event, int multiObjectID) {
                PenWritingView.this.sendTouchEvent(event, multiObjectID, 1);
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPenEraser(View view, MotionEvent event, int multiObjectID) {
                PenWritingView.this.sendTouchEvent(event, multiObjectID, 2);
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onDrawingPen(View arg0, MotionEvent arg1, int arg2, int arg3) {
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
        Destination destination = MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination();
        if (destination != null && destination.getDestinationType() == 4) {
            this.mIsConference = true;
        }
        initScaleData();
        load();
        createPenMenuView(service);
        if (this.mIsConference) {
            createSCanvas();
        }
    }

    private void initScaleData() {
        if (this.mScreenScale == null) {
            this.mScreenScale = ScreenShareScale.getInstance();
        }
        this.mScreenScale.initScaleData();
    }

    private void createPenMenuView(Service service) {
        if (this.mIsConference) {
            this.mPenMenuView = new PenMenuView(service, C0000R.layout.screenshare_pen_menu_for_conference);
        } else {
            this.mPenMenuView = new PenMenuView(service, C0000R.layout.screenshare_pen_menu);
        }
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void setupLayoutParams() {
        logI("setupLayoutParams()");
        int layoutparamsType = 2021;
        if (this.mIsConference) {
            layoutparamsType = 2026;
        }
        this.layoutParams = new WindowManager.LayoutParams(-1, -1, layoutparamsType, 65792, -3);
        this.layoutParams.gravity = 51;
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void onInflateView() {
        logI("onInflateView()");
        this.mContext = getService().getApplicationContext();
        if (!this.mIsConference) {
            createSCanvas();
        }
    }

    public void createSCanvas() {
        this.mSCanvas = (SCanvasView) findViewById(C0000R.id.canvas_view);
        this.mSCanvas.setSPenTouchIDListener(this.mSCanvasOnPenTouchIDListener);
        this.mSCanvas.setSObjectUpdateListener(this.mSObjectListenerUI);
        if (!this.mIsConference) {
            FrameLayout settingViewContainer = (FrameLayout) findViewById(C0000R.id.draw_canvas);
            logI("Resource Map for Layout & Locale");
            HashMap<String, Integer> settingResourceMapInt = SPenSDKUtils.getSettingLayoutLocaleResourceMap(true, true, false, false);
            logI("Resource Map for Custom font path");
            HashMap<String, String> settingResourceMapString = SPenSDKUtils.getSettingLayoutStringResourceMap(true, true, false, false);
            logI("createSettingView");
            this.mSCanvas.createSettingView(settingViewContainer, settingResourceMapInt, settingResourceMapString);
        } else {
            this.mPenMenuView.setSCanvasView(this.mSCanvas);
        }
        this.mSCanvas.setSettingStrokeChangeListener(new SettingStrokeChangeListener() { // from class: com.coolots.chaton.call.screenshare.PenWritingView.4
            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeWidthChanged(int arg0) {
                if (PenWritingView.this.mPenMenuView != null) {
                    PenWritingView.this.mPenMenuView.mToolBarLayout.invalidate();
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeStyleChanged(int arg0) {
                if (PenWritingView.this.mPenMenuView != null) {
                    PenWritingView.this.mPenMenuView.mToolBarLayout.invalidate();
                }
                if (PenWritingView.this.mPenMenuView != null) {
                    PenWritingView.this.mPenMenuView.mPenBtnLayout.invalidate();
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeColorChanged(int arg0) {
                if (PenWritingView.this.mPenMenuView != null) {
                    PenWritingView.this.mPenMenuView.mPenColor.setBackgroundColor(arg0);
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
        this.mSCanvas.setSCanvasInitializeListener(new SCanvasInitializeListener() { // from class: com.coolots.chaton.call.screenshare.PenWritingView.5
            @Override // com.samsung.spensdk.applistener.SCanvasInitializeListener
            public void onInitialized() {
                PenWritingView.this.logI("SCanvasInitializeListener onInitialized");
                PenWritingView.this.mSCanvas.setSelectLayer(0);
                PenWritingView.this.mSCanvas.setCanvasMode(10);
                PenWritingView.this.mSCanvas.setMultiStroke(true);
                PenWritingView.this.mSCanvas.setUserID(PenWritingView.this.mUserId);
                PenWritingView.this.mSCanvas.setMultiTouchCancel(false);
                SettingStrokeInfo sendSettingStrokeInfo = new SettingStrokeInfo();
                sendSettingStrokeInfo.setStrokeStyle(0);
                sendSettingStrokeInfo.setStrokeColor(-15527149);
                sendSettingStrokeInfo.setStrokeWidth(10.0f);
                PenWritingView.this.mSCanvas.setSettingViewStrokeInfo(sendSettingStrokeInfo);
                PenWritingView.this.mSCanvas.setZoomEnable(false);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) PenWritingView.this.mSCanvas.getLayoutParams();
                layoutParams.width = PenWritingView.this.mDisMaxSize;
                layoutParams.height = PenWritingView.this.mDisMaxSize;
                PenWritingView.this.mSCanvas.setLayoutParams(layoutParams);
                if (PenWritingView.this.mPenMenuView != null) {
                    if (!PenWritingView.this.mIsConference) {
                        PenWritingView.this.mPenMenuView.setSCanvasView(PenWritingView.this.mSCanvas);
                    }
                    PenWritingView.this.mPenMenuView.mPenColor.setBackgroundColor(-15527149);
                }
            }
        });
        this.mSCanvas.setHistoryUpdateListener(new HistoryUpdateListener() { // from class: com.coolots.chaton.call.screenshare.PenWritingView.6
            @Override // com.samsung.spensdk.applistener.HistoryUpdateListener
            public void onHistoryChanged(boolean undoable, boolean redoable) {
                PenWritingView.this.logI("onHistoryChanged");
                if (PenWritingView.this.mPenMenuView != null && PenWritingView.this.mPenMenuView.mUndoBtn != null && PenWritingView.this.mPenMenuView.mRedoBtn != null) {
                    PenWritingView.this.mPenMenuView.mUndoBtn.setEnabled(undoable);
                    PenWritingView.this.mPenMenuView.mRedoBtn.setEnabled(redoable);
                }
            }
        });
        this.mSCanvas.setSCanvasModeChangedListener(new SCanvasModeChangedListener() { // from class: com.coolots.chaton.call.screenshare.PenWritingView.7
            @Override // com.samsung.spensdk.applistener.SCanvasModeChangedListener
            public void onModeChanged(int mode) {
                PenWritingView.this.logI("onInitialized updateModeState");
                if (PenWritingView.this.mPenMenuView != null) {
                    PenWritingView.this.mPenMenuView.updateModeState();
                }
            }
        });
        this.mSCanvas.setSCanvasDeleteAllConfirmListener(this.mSCanvasOnDeleteAllConfirmListener);
        this.mSCanvas.setSettingPresetDeleteBtnClickListener(new SettingPresetDeleteBtnClickListener() { // from class: com.coolots.chaton.call.screenshare.PenWritingView.8
            @Override // com.samsung.spensdk.applistener.SettingPresetDeleteBtnClickListener
            public void onClick(int nPresetIndex) {
                PenWritingView.this.mSCanvas.deleteSettingViewPresetInfo(nPresetIndex, false);
            }
        });
        this.mSCanvas.setOnCancelListener(new CanvasView.OnCancelListener() { // from class: com.coolots.chaton.call.screenshare.PenWritingView.9
            @Override // com.samsung.sdraw.CanvasView.OnCancelListener
            public void onCancel(int arg0) {
                if (!PenWritingView.this.isCanceled) {
                    byte[] cmdData = PenWriteNetwork.intToByte(PenWritingView.this.mUserId);
                    PenWritingView.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO, cmdData);
                    PenWritingView.this.isCanceled = true;
                }
            }
        });
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
        this.mSCanvas.setUserID(userid);
        if (this.mPenMenuView != null) {
            this.mPenMenuView.setUserID(userid);
        }
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    public void OnRecveData(int command, byte[] data) {
        logI("OnRecveData():" + command);
        switch (command) {
            case 100:
                final MultiSettingStrokeInfo settingInfo = SettingPacket.parserSettingStrokeInfo(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.PenWritingView.11
                    @Override // java.lang.Runnable
                    public void run() {
                        PenWritingView.this.logI("OnRecveData getStrokeStyle " + settingInfo.settingInfo.getStrokeStyle());
                        PenWritingView.this.mSCanvas.setSettingStrokeInfo(settingInfo.userId, settingInfo.settingInfo);
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_UNDO /* 203 */:
                final int destUserID = PenWriteNetwork.byteToInt(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.PenWritingView.12
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            PenWritingView.this.mSCanvas.undo(destUserID);
                        } catch (Exception e) {
                            PenWritingView.this.logE("mSCanvas.undo: " + e);
                        }
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_REDO /* 204 */:
                final int destUserID2 = PenWriteNetwork.byteToInt(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.PenWritingView.13
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            PenWritingView.this.mSCanvas.redo(destUserID2);
                        } catch (Exception e) {
                            PenWritingView.this.logE("mSCanvas.redo: " + e);
                        }
                    }
                });
                break;
            case ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARALL /* 205 */:
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.PenWritingView.14
                    @Override // java.lang.Runnable
                    public void run() {
                        PenWritingView.this.mSCanvas.deleteAll(true);
                    }
                });
                break;
            case 300:
                final PenWriteNetwork.shareSAMMStrokePoint SAMMStrokePoint = PenWriteNetwork.parseSAMMStrokePoint(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.PenWritingView.10
                    @Override // java.lang.Runnable
                    public void run() {
                        PenWritingView.this.logI("OnRecveData() drawMultiUserSAMMStrokePoint, Action-" + SAMMStrokePoint.Action + ", X=" + SAMMStrokePoint.f6x + ", y=" + SAMMStrokePoint.f7y + SAMMStrokePoint);
                        if (SAMMStrokePoint.Action == 0) {
                            PenWritingView.gDownTime = SystemClock.uptimeMillis();
                        }
                        float rawX = PenWritingView.this.mScreenScale.modifyScaleX(SAMMStrokePoint.f6x);
                        float rawY = PenWritingView.this.mScreenScale.modifyScaleY(SAMMStrokePoint.f7y);
                        PenWritingView.this.mSCanvas.drawMultiUserSAMMStrokePoint(SAMMStrokePoint.MultiUserID, SAMMStrokePoint.MultiStrokeID, SAMMStrokePoint.Action, rawX, rawY, SAMMStrokePoint.pressure, SAMMStrokePoint.sammMetaState, PenWritingView.gDownTime, PenWritingView.gDownTime + SAMMStrokePoint.eventtime);
                        PenWritingView.this.mSCanvas.invalidate();
                    }
                });
                break;
            case 301:
                final PenWriteNetwork.shareSAMMTextData SAMMTextData = PenWriteNetwork.parseSAMMTextData(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.PenWritingView.15
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
                        PenWritingView.this.mSCanvas.insertSAMMText(SAMMTextData.MultiUserID, SAMMTextData.textID, textData);
                        PenWritingView.this.mSCanvas.invalidate();
                    }
                });
                break;
            case 302:
                final PenWriteNetwork.shareSAMMTextData SAMMTextData2 = PenWriteNetwork.parseSAMMTextData(data);
                this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.PenWritingView.16
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
                        PenWritingView.this.mSCanvas.changeSAMMObject(SAMMTextData2.MultiUserID, SAMMTextData2.textID, textData);
                        PenWritingView.this.mSCanvas.invalidate();
                    }
                });
                break;
        }
    }

    protected void sendTouchEvent(MotionEvent event, int multiObjectID, int sammMetaState) {
        SettingStrokeInfo settingStrokeInfo;
        if (this.mOnSendCommandData != null) {
            if (event.getAction() == 0 && (settingStrokeInfo = this.mSCanvas.getSettingViewStrokeInfo()) != null) {
                byte[] cmdData = SettingPacket.makeSettingStrokeInfo(this.mUserId, settingStrokeInfo);
                if (this.mSendSettingStrokeInfo == null) {
                    this.mSendSettingStrokeInfo = SettingPacket.copySettingInfo(settingStrokeInfo);
                    this.mSendSettingStrokeInfo.setStrokeAlpha(settingStrokeInfo.getStrokeAlpha());
                    onSendData(100, cmdData);
                } else if (!SettingPacket.equalsSettingInfo(this.mSendSettingStrokeInfo, settingStrokeInfo)) {
                    this.mSendSettingStrokeInfo = SettingPacket.copySettingInfo(settingStrokeInfo);
                    onSendData(100, cmdData);
                }
            }
            if (this.mScreenScale != null && this.mSCanvas != null && this.mode != 2) {
                float rawX = this.mScreenScale.modifyExpandScaleX(event.getRawX());
                float rawY = this.mScreenScale.modifyExpandScaleY(event.getRawY());
                byte[] cmdData2 = PenWriteNetwork.makeSAMMStrokePoint(this.mUserId, multiObjectID, event.getAction(), rawX, rawY, event.getPressure(), sammMetaState, event.getDownTime(), event.getEventTime() - event.getDownTime());
                if (this.mSCanvas.getCanvasMode() != 12) {
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

    public void dissmissAlertView() {
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
    public void onSendData(int command, byte[] cmdData) {
        if (this.mOnSendCommandData != null) {
            this.mOnSendCommandData.onSendData(command, cmdData);
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

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mSCanvas != null) {
            this.mSCanvas.setSettingStrokeChangeListener(null);
            this.mSCanvas.setSCanvasInitializeListener(null);
            this.mSCanvas.setHistoryUpdateListener(null);
            this.mSCanvas.setSCanvasModeChangedListener(null);
            this.mSCanvas.removeCallbacks(null);
            this.mSCanvas = null;
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
        if (this.mScreenScale != null) {
            this.mScreenScale = null;
        }
    }
}
