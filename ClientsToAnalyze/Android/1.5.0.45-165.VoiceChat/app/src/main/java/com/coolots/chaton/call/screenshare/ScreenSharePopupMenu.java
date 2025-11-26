package com.coolots.chaton.call.screenshare;

import android.app.Service;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.screenshare.activity.ScreenShareLayout;
import com.coolots.chaton.call.screenshare.core.OverlayView;
import com.coolots.chaton.call.screenshare.util.AlertView;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.Locale;

/* loaded from: classes.dex */
public class ScreenSharePopupMenu extends OverlayView implements DisposeInterface {
    private static final String CLASSNAME = "[ScreenSharePopupMenu]";
    public static final int SCREEN_SHARE_POPUP_MENU_SHARE_MODE = 0;
    public static final int SCREEN_SHARE_POPUP_MENU_SHARE_MODE_DOCSVIEW_REMOTE = 4;
    public static final int SCREEN_SHARE_POPUP_MENU_SHARE_MODE_REMOTE = 1;
    public static final int SCREEN_SHARE_POPUP_MENU_VIEW_MODE = 2;
    public static final int SCREEN_SHARE_POPUP_MENU_VIEW_MODE_REMOTE = 3;
    public static final int UPDATE_POPUP_MENU = 0;
    public static Service mParent;
    public static OverlayView mParentView;
    private AlertView alertView;
    View.OnLongClickListener btnOnLongClickListener;
    View.OnTouchListener btnOnTouchListener;
    private boolean dragFlag;
    private boolean isFirstPlace;
    private boolean isMoveFirst;
    private Point mCurrentPoint;
    private Destination mDestination;
    private Handler mHandler;
    private String mLocale;
    private MenuBtnHandler mMenuBtnHandler;
    private Button mMenuDocsViewBtn;
    private ImageView mMenuDocsViewImage;
    private FrameLayout mMenuDocsViewLayout;
    private TextView mMenuDocsViewText;
    private FrameLayout mMenuEndLayout;
    private int mMenuHeight;
    private LinearLayout mMenuMaineMenuLayout;
    private Button mMenuPauseBtn;
    private ImageView mMenuPauseImg;
    private FrameLayout mMenuPauseLayout;
    private TextView mMenuPauseTxt;
    private Button mMenuPenWritingBtn;
    private FrameLayout mMenuPenWritingLayout;
    private TextView mMenuPenWritingText;
    private Button mMenuRemoteBtn;
    private ImageView mMenuRemoteImg;
    private FrameLayout mMenuRemoteLayout;
    private TextView mMenuRemoteTextView;
    private TextView mMenuRemoteTxt;
    private LinearLayout mMenuRomoteMenuLayout;
    private int mMode;
    private int mPauseMode;
    private Point mStartPoint;
    private int menuWidth;
    ScreenShareLayout.OnButtonEvent onButtonEvent;

    /* renamed from: wm */
    protected WindowManager f2wm;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private class PopupMenuHandler extends Handler implements DisposeInterface {
        private boolean bDisposed;

        private PopupMenuHandler() {
            this.bDisposed = false;
        }

        /* synthetic */ PopupMenuHandler(ScreenSharePopupMenu screenSharePopupMenu, PopupMenuHandler popupMenuHandler) {
            this();
        }

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            this.bDisposed = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (this.bDisposed) {
            }
            switch (msg.what) {
                case 0:
                    ScreenSharePopupMenu.this.setViewMode();
                    break;
            }
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (!newConfig.locale.toString().equalsIgnoreCase(this.mLocale)) {
            this.mMenuPenWritingText.setText(getResources().getString(C0000R.string.screenshare_talkback_share_menu_penwriting));
            this.mMenuPenWritingBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_talkback_share_menu_penwriting));
            this.mMenuDocsViewText.setText(getResources().getString(C0000R.string.call_menu_docs_view));
            this.mMenuDocsViewBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.call_menu_docs_view));
            if (this.mMode == 3 || this.mMode == 1) {
                this.mMenuRemoteBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_talkback_share_menu_remote_end));
                this.mMenuRemoteTxt.setText(C0000R.string.screenshare_menu_end_remote_btn);
                setTextViewEditor(this.mMenuRemoteTxt);
            } else {
                this.mMenuRemoteBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_menu_remote_btn));
                this.mMenuRemoteTxt.setText(C0000R.string.screenshare_menu_remote_btn);
                setTextViewEditor(this.mMenuRemoteTxt);
            }
            if (this.mPauseMode == 1 || this.mPauseMode == 2) {
                this.mMenuPauseTxt.setText(C0000R.string.screenshare_menu_restart);
                this.mMenuPauseBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_menu_restart));
            } else if (this.mPauseMode == 0) {
                this.mMenuPauseTxt.setText(C0000R.string.screenshare_menu_pause);
                this.mMenuPauseBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_menu_pause));
            }
            this.mLocale = newConfig.locale.toString();
        }
    }

    public ScreenSharePopupMenu(Service service, OverlayView overlayView) {
        super(service, C0000R.layout.screenshare_main_popup_menu);
        this.mHandler = new PopupMenuHandler(this, null);
        this.mMenuBtnHandler = new MenuBtnHandler(this, 0 == true ? 1 : 0);
        this.mPauseMode = 0;
        this.dragFlag = false;
        this.isMoveFirst = false;
        this.mStartPoint = null;
        this.mCurrentPoint = null;
        this.isFirstPlace = true;
        this.menuWidth = 360;
        this.mMenuHeight = 68;
        this.f2wm = null;
        this.btnOnLongClickListener = new View.OnLongClickListener() { // from class: com.coolots.chaton.call.screenshare.ScreenSharePopupMenu.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View arg0) {
                if (!ScreenSharePopupMenu.this.dragFlag) {
                    ScreenSharePopupMenu.this.dragFlag = true;
                    ScreenSharePopupMenu.this.isMoveFirst = false;
                }
                return false;
            }
        };
        this.btnOnTouchListener = new View.OnTouchListener() { // from class: com.coolots.chaton.call.screenshare.ScreenSharePopupMenu.2
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        if (ScreenSharePopupMenu.this.mStartPoint == null) {
                            ScreenSharePopupMenu.this.mStartPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                        }
                        ScreenSharePopupMenu.this.mCurrentPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                        return false;
                    case 1:
                        if (ScreenSharePopupMenu.this.dragFlag) {
                            ScreenSharePopupMenu.this.dragFlag = false;
                        } else {
                            ScreenSharePopupMenu.this.dismiss(view.getId());
                        }
                        return false;
                    case 2:
                        if (ScreenSharePopupMenu.this.dragFlag) {
                            int[] pos = {((int) event.getRawX()) - ScreenSharePopupMenu.this.mCurrentPoint.x, ((int) event.getRawY()) - ScreenSharePopupMenu.this.mCurrentPoint.y};
                            if (ScreenSharePopupMenu.this.isMoveFirst || Math.abs(pos[0]) > 10 || Math.abs(pos[1]) > 10) {
                                ScreenSharePopupMenu.this.isMoveFirst = true;
                                ScreenSharePopupMenu.this.mCurrentPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                            } else {
                                pos[0] = 0;
                                pos[1] = 0;
                            }
                            ScreenSharePopupMenu.this.moveView2(pos[0], pos[1], 2);
                        }
                        return false;
                    default:
                        return false;
                }
            }
        };
        mParent = service;
        mParentView = overlayView;
        load();
    }

    public ScreenSharePopupMenu(Service service) {
        super(service, C0000R.layout.screenshare_main_popup_menu);
        this.mHandler = new PopupMenuHandler(this, null);
        this.mMenuBtnHandler = new MenuBtnHandler(this, 0 == true ? 1 : 0);
        this.mPauseMode = 0;
        this.dragFlag = false;
        this.isMoveFirst = false;
        this.mStartPoint = null;
        this.mCurrentPoint = null;
        this.isFirstPlace = true;
        this.menuWidth = 360;
        this.mMenuHeight = 68;
        this.f2wm = null;
        this.btnOnLongClickListener = new View.OnLongClickListener() { // from class: com.coolots.chaton.call.screenshare.ScreenSharePopupMenu.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View arg0) {
                if (!ScreenSharePopupMenu.this.dragFlag) {
                    ScreenSharePopupMenu.this.dragFlag = true;
                    ScreenSharePopupMenu.this.isMoveFirst = false;
                }
                return false;
            }
        };
        this.btnOnTouchListener = new View.OnTouchListener() { // from class: com.coolots.chaton.call.screenshare.ScreenSharePopupMenu.2
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        if (ScreenSharePopupMenu.this.mStartPoint == null) {
                            ScreenSharePopupMenu.this.mStartPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                        }
                        ScreenSharePopupMenu.this.mCurrentPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                        return false;
                    case 1:
                        if (ScreenSharePopupMenu.this.dragFlag) {
                            ScreenSharePopupMenu.this.dragFlag = false;
                        } else {
                            ScreenSharePopupMenu.this.dismiss(view.getId());
                        }
                        return false;
                    case 2:
                        if (ScreenSharePopupMenu.this.dragFlag) {
                            int[] pos = {((int) event.getRawX()) - ScreenSharePopupMenu.this.mCurrentPoint.x, ((int) event.getRawY()) - ScreenSharePopupMenu.this.mCurrentPoint.y};
                            if (ScreenSharePopupMenu.this.isMoveFirst || Math.abs(pos[0]) > 10 || Math.abs(pos[1]) > 10) {
                                ScreenSharePopupMenu.this.isMoveFirst = true;
                                ScreenSharePopupMenu.this.mCurrentPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                            } else {
                                pos[0] = 0;
                                pos[1] = 0;
                            }
                            ScreenSharePopupMenu.this.moveView2(pos[0], pos[1], 2);
                        }
                        return false;
                    default:
                        return false;
                }
            }
        };
        mParent = service;
        load();
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView, android.widget.RelativeLayout
    public int getGravity() {
        return 51;
    }

    protected void initPosition() {
        int posX = this.layoutParams.x;
        int posY = this.layoutParams.y;
        Point disMaxPos = new Point();
        if (this.f2wm == null) {
            this.f2wm = (WindowManager) getContext().getSystemService("window");
        }
        Display display = this.f2wm.getDefaultDisplay();
        display.getSize(disMaxPos);
        int width = (int) (this.menuWidth * this.mContext.getResources().getDisplayMetrics().density);
        int height = (int) (this.mMenuHeight * this.mContext.getResources().getDisplayMetrics().density);
        logI("initPosition Menu Size - " + width + ", " + height);
        if (this.isFirstPlace) {
            this.isFirstPlace = false;
            posX = (disMaxPos.x - width) / 2;
            posY = disMaxPos.y - height;
            logI("initPosition first Pos - " + posX + ", " + posY);
        } else {
            if (disMaxPos.x < posX + width) {
                posX = disMaxPos.x - width;
            }
            if (disMaxPos.y < posY + height) {
                posY = disMaxPos.y - height;
            }
            logI("initPosition show Pos - " + posX + ", " + posY);
        }
        sizeView(width, height);
        moveView(posX, posY);
    }

    public void setViewMode(int mode) {
        logI("setViewMode(final int mode) mode = " + mode);
        this.mMode = mode;
        this.mHandler.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewMode() {
        logI("setViewMode()");
        if (this.mMenuRemoteTextView != null) {
            this.mMenuRemoteTextView.setVisibility(8);
        }
        if (this.mMenuRomoteMenuLayout != null) {
            this.mMenuRomoteMenuLayout.setVisibility(8);
        }
        if (this.mMode == 3 || this.mMode == 1) {
            this.mMenuRemoteImg.setImageResource(C0000R.drawable.screenshare_main_popup_end_remotecontrol_selector);
            this.mMenuRemoteBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_talkback_share_menu_remote_end));
            this.mMenuRemoteTxt.setText(C0000R.string.screenshare_menu_end_remote_btn);
            setTextViewEditor(this.mMenuRemoteTxt);
        } else {
            this.mMenuRemoteImg.setImageResource(C0000R.drawable.screenshare_main_popup_remotecontrol_selector);
            this.mMenuRemoteBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_menu_remote_btn));
            this.mMenuRemoteTxt.setText(C0000R.string.screenshare_menu_remote_btn);
            setTextViewEditor(this.mMenuRemoteTxt);
        }
        if (this.mMode == 0) {
            this.mMenuRemoteLayout.setEnabled(false);
            this.mMenuRemoteLayout.setVisibility(8);
            setLayoutWidth(this.mMenuPauseLayout, 113);
            setLayoutWidth(this.mMenuPenWritingLayout, 114);
            setLayoutWidth(this.mMenuEndLayout, 113);
        } else {
            this.mMenuRemoteLayout.setEnabled(true);
            this.mMenuRemoteLayout.setVisibility(0);
            setLayoutWidth(this.mMenuPauseLayout, 85);
            setLayoutWidth(this.mMenuPenWritingLayout, 85);
            setLayoutWidth(this.mMenuEndLayout, 85);
        }
        if (this.mMode == 4) {
            onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_DRAWING_REQ_MODE, null);
        }
    }

    public void setPause(int Pause) {
        this.mPauseMode = Pause;
        if (Pause == 1) {
            this.mMenuPauseTxt.setText(C0000R.string.screenshare_menu_restart);
            this.mMenuPauseImg.setImageResource(C0000R.drawable.screenshare_main_popup_restart_selector);
            this.mMenuPauseBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_menu_restart));
        } else if (Pause == 2) {
            this.mMenuPauseTxt.setText(C0000R.string.screenshare_menu_restart);
            this.mMenuPauseImg.setImageResource(C0000R.drawable.screenshare_main_popup_restart_selector);
            this.mMenuPauseBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_menu_restart));
        } else if (Pause == 0) {
            this.mMenuPauseTxt.setText(C0000R.string.screenshare_menu_pause);
            this.mMenuPauseImg.setImageResource(C0000R.drawable.screenshare_main_popup_pause_selector);
            this.mMenuPauseBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_menu_pause));
            this.mMenuPauseLayout.setEnabled(true);
            this.mMenuPenWritingLayout.setEnabled(true);
        }
    }

    public void setOtherPause(int pause) {
        if (pause == 1 || pause != 0) {
        }
    }

    public void setLayoutWidth(FrameLayout layout, int width) {
        int btnWidth = (int) (width * getResources().getDisplayMetrics().density);
        ViewGroup.LayoutParams layoutParams = layout.getLayoutParams();
        layoutParams.width = btnWidth;
        layout.setLayoutParams(layoutParams);
        logI("initPosition Btn Width - " + layout + ", " + btnWidth);
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void onInflateView() {
        this.mMenuPauseBtn = (Button) findViewById(C0000R.id.menu_pause_btn);
        this.mMenuPenWritingBtn = (Button) findViewById(C0000R.id.menu_pen_writing_btn);
        this.mMenuPenWritingText = (TextView) findViewById(C0000R.id.menu_pen_writing_txt);
        this.mMenuDocsViewBtn = (Button) findViewById(C0000R.id.menu_end_btn);
        this.mMenuDocsViewImage = (ImageView) findViewById(C0000R.id.menu_end_img);
        this.mMenuDocsViewText = (TextView) findViewById(C0000R.id.menu_end_txt);
        this.mMenuRemoteBtn = (Button) findViewById(C0000R.id.menu_remote_btn);
        this.mMenuRemoteTextView = (TextView) findViewById(C0000R.id.remote_textview);
        this.mMenuRomoteMenuLayout = (LinearLayout) findViewById(C0000R.id.remote_control_layout);
        this.mMenuMaineMenuLayout = (LinearLayout) findViewById(C0000R.id.menu_main_layout);
        this.mMenuPauseImg = (ImageView) findViewById(C0000R.id.menu_pause_img);
        this.mMenuRemoteImg = (ImageView) findViewById(C0000R.id.menu_remote_img);
        this.mMenuPauseTxt = (TextView) findViewById(C0000R.id.menu_pause_txt);
        this.mMenuRemoteTxt = (TextView) findViewById(C0000R.id.menu_remote_txt);
        setTextViewEditor(this.mMenuRemoteTxt);
        this.mMenuDocsViewLayout = (FrameLayout) findViewById(C0000R.id.menu_end_layout);
        this.mMenuPauseLayout = (FrameLayout) findViewById(C0000R.id.menu_pause_layout);
        this.mMenuPenWritingLayout = (FrameLayout) findViewById(C0000R.id.menu_pen_writing_layout);
        this.mMenuRemoteLayout = (FrameLayout) findViewById(C0000R.id.menu_remote_layout);
        this.mMenuEndLayout = (FrameLayout) findViewById(C0000R.id.menu_end_layout);
        this.mDestination = MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination();
        if (this.mDestination != null && this.mDestination.getDestinationType() == 4) {
            this.mMenuPenWritingText.setEnabled(false);
            this.mMenuRemoteLayout.setEnabled(false);
            this.mMenuRemoteBtn.setEnabled(false);
            this.mMenuDocsViewLayout.setEnabled(false);
            this.mMenuDocsViewBtn.setEnabled(false);
            this.mMenuDocsViewImage.setEnabled(false);
            this.mMenuDocsViewText.setEnabled(false);
        }
        if (!MainApplication.mPhoneManager.getPhoneStateMachine().getNegoFeatureController().isP2pShareDocView()) {
            this.mMenuDocsViewLayout.setEnabled(false);
            this.mMenuDocsViewBtn.setEnabled(false);
            this.mMenuDocsViewImage.setEnabled(false);
            this.mMenuDocsViewText.setEnabled(false);
        }
        this.mMenuPauseBtn.setOnLongClickListener(this.btnOnLongClickListener);
        this.mMenuPenWritingBtn.setOnLongClickListener(this.btnOnLongClickListener);
        this.mMenuDocsViewBtn.setOnLongClickListener(this.btnOnLongClickListener);
        this.mMenuRemoteBtn.setOnLongClickListener(this.btnOnLongClickListener);
        this.mMenuPauseBtn.setOnTouchListener(this.btnOnTouchListener);
        this.mMenuPenWritingBtn.setOnTouchListener(this.btnOnTouchListener);
        this.mMenuDocsViewBtn.setOnTouchListener(this.btnOnTouchListener);
        this.mMenuRemoteBtn.setOnTouchListener(this.btnOnTouchListener);
        this.mLocale = getResources().getConfiguration().locale.toString();
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    public void show() {
        logI("show()");
        initPosition();
        super.show();
        Animation a = AnimationUtils.loadAnimation(getContext(), C0000R.anim.screenshare_zoom_in);
        a.reset();
        this.mMenuMaineMenuLayout.clearAnimation();
        this.mMenuMaineMenuLayout.startAnimation(a);
        this.mShow = true;
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void onTouchEvent_PressOutside(MotionEvent event) {
        logI("onTouchEvent_PressOutside");
        if (!ScreenShareProc.isShareButtonRect((int) event.getRawX(), (int) event.getRawY())) {
            dismiss();
            if (mParentView != null) {
                mParentView.dismissMenu(this.mShow);
            }
        }
    }

    public void dismiss(final int action) {
        if (this.mShow) {
            setEnabled(false);
            Animation a = AnimationUtils.loadAnimation(getContext(), C0000R.anim.screenshare_zoom_out);
            a.reset();
            a.setAnimationListener(new Animation.AnimationListener() { // from class: com.coolots.chaton.call.screenshare.ScreenSharePopupMenu.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation arg0) {
                    ScreenSharePopupMenu.this.setVisibility(8);
                    ScreenSharePopupMenu.this.mShow = false;
                    if (action != 0) {
                        Message msg = ScreenSharePopupMenu.this.mMenuBtnHandler.obtainMessage(action);
                        ScreenSharePopupMenu.this.mMenuBtnHandler.sendMessage(msg);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation arg0) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation arg0) {
                }
            });
            if (this.mMenuMaineMenuLayout != null) {
                this.mMenuMaineMenuLayout.clearAnimation();
                this.mMenuMaineMenuLayout.startAnimation(a);
            }
        } else {
            super.dismiss();
        }
        this.mShow = false;
        if (mParentView != null) {
            mParentView.dismissMenu(this.mShow);
        }
    }

    private class MenuBtnHandler extends Handler {
        private MenuBtnHandler() {
        }

        /* synthetic */ MenuBtnHandler(ScreenSharePopupMenu screenSharePopupMenu, MenuBtnHandler menuBtnHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) throws Resources.NotFoundException {
            switch (msg.what) {
                case C0000R.id.menu_pause_btn /* 2131493287 */:
                case C0000R.id.menu_pen_writing_btn /* 2131493291 */:
                case C0000R.id.menu_remote_btn /* 2131493295 */:
                case C0000R.id.menu_end_btn /* 2131493299 */:
                    ScreenSharePopupMenu.this.menuHandle(msg.what);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void menuHandle(int viewid) throws Resources.NotFoundException {
        if (viewid == C0000R.id.menu_pause_btn) {
            if (this.mPauseMode == 2) {
                ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.unable_restart_chatonv_call_hold), 0);
                return;
            }
            if (this.mPauseMode == 1) {
                if (ScreenShareProc.getInstance().mOtherPauseType == 2) {
                    ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.unable_restart_chatonv_call_hold), 0);
                    return;
                } else {
                    MainApplication.mPhoneManager.getShareScreenManager().resumeShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), null, false);
                    return;
                }
            }
            if (this.mPauseMode == 0) {
                MainApplication.mPhoneManager.getShareScreenManager().pauseShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), 0);
                return;
            }
            return;
        }
        if (viewid == C0000R.id.menu_pen_writing_btn) {
            logI("mMenuPenWritingBtn ");
            if (this.mPauseMode == 1 && ScreenShareProc.getInstance().mOtherPauseType == 2) {
                ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.unable_pen_writing_chatonv_call_hold), 0);
                return;
            }
            if (this.mPauseMode == 2) {
                ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.unable_pen_writing_chatonv_call_hold), 0);
                return;
            }
            if (this.mPauseMode != 0) {
                MainApplication.mPhoneManager.getShareScreenManager().resumeShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), null, false);
            }
            if (this.mDestination != null && this.mDestination.getDestinationType() == 4) {
                ScreenShareProc.getInstance().setConferencePenMode(true);
                return;
            } else {
                onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_DRAWING_REQ_MODE, null);
                return;
            }
        }
        if (viewid == C0000R.id.menu_remote_btn) {
            if (this.mPauseMode != 0) {
                MainApplication.mPhoneManager.getShareScreenManager().resumeShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), null, false);
            }
            ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_remote_control_end), 0);
            onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHNAGE_REMOTE_END, null);
            ScreenShareProc.remoteModeEnd();
            setViewMode(0);
            return;
        }
        if (viewid == C0000R.id.menu_end_btn) {
            logI("haeri=mMenuEndBtn -------> for docs view");
            logE("menuHandle() docs view btn mMode = " + this.mMode);
            if (this.mMode == 1) {
                ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.screenshare_remote_control_end), 0);
                onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHNAGE_REMOTE_END, null);
                ScreenShareProc.remoteModeEnd();
                setViewMode(0);
            }
            if (this.mPauseMode == 1 && ScreenShareProc.getInstance().mOtherPauseType == 2) {
                ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.unable_pen_writing_chatonv_call_hold), 0);
            } else if (this.mPauseMode == 2) {
                ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.unable_pen_writing_chatonv_call_hold), 0);
            } else {
                startDocsView();
            }
        }
    }

    private void startDocsView() throws Resources.NotFoundException {
        MainApplication.mPhoneManager.getShareScreenManager().pauseShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), 0);
        byte[] packetData = ScreenSharePacket.makeStringPacket(MainApplication.mConfig.getProfileUserName());
        onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DOCS_START, packetData);
        if (ScreenShareProc.mInstance.getDocsFileName() != null && !ScreenShareProc.mInstance.getBoardDataController().isHomeKeyExit()) {
            showDialogContinueDocsView();
        } else {
            ScreenShareProc.mInstance.getBoardDataController().pressedHomeKey(false);
            ScreenShareProc.mInstance.startDocsView();
        }
    }

    public void setMenuRotated() {
        this.isFirstPlace = true;
        initPosition();
    }

    private void showDialogContinueDocsView() throws Resources.NotFoundException {
        this.alertView = new AlertView(MainApplication.mContext);
        this.alertView.setTitle(C0000R.string.docs_view_continue_title);
        this.alertView.setMessage(getResources().getString(C0000R.string.docs_view_continue_msg, ScreenShareProc.mInstance.getDocsFileName()));
        this.alertView.setPositiveButton(C0000R.string.alert_dialog_ok, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.ScreenSharePopupMenu.4
            @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
            public void onClick(AlertView dialog, int which) {
                ScreenShareProc.mInstance.startDocsView();
            }
        });
        this.alertView.setNegativeButton(C0000R.string.alert_dialog_cancel, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.ScreenSharePopupMenu.5
            @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
            public void onClick(AlertView dialog, int which) {
                MainApplication.mPhoneManager.getShareScreenManager().resumeShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), null, false);
            }
        });
        this.alertView.setNeutralButton(C0000R.string.alert_dialog_new, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.ScreenSharePopupMenu.6
            @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
            public void onClick(AlertView dialog, int which) {
                if (ScreenShareProc.mInstance != null) {
                    ScreenShareProc.mInstance.initBoardDataController();
                    ScreenSharePopupMenu.this.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARALL, null);
                }
                ScreenShareProc.mInstance.startDocsView();
            }
        });
        this.alertView.setCancelable(true);
        this.alertView.show();
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void setupLayoutParams() {
        this.layoutParams = new WindowManager.LayoutParams((int) (this.menuWidth * this.mContext.getResources().getDisplayMetrics().density), -2, 2021, 262440, -3);
        this.layoutParams.gravity = getGravity();
    }

    private void setTextViewEditor(TextView textView) {
        String mSystemLanguage = MainApplication.mContext.getResources().getConfiguration().locale.getLanguage();
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) textView.getLayoutParams();
        int mDestiny = (int) MainApplication.mContext.getResources().getDisplayMetrics().density;
        if (mSystemLanguage.equals(Locale.KOREAN.toString())) {
            textView.setTextSize(1, 13.0f);
            textView.setLines(1);
            lp.setMargins(0, mDestiny * 30, 0, 0);
            textView.setLayoutParams(lp);
            return;
        }
        textView.setTextSize(1, 13.0f);
        if (mDestiny * 84 > textView.getPaint().measureText(textView.getText().toString())) {
            logE(String.valueOf(textView.getText().toString()) + "/" + textView.getPaint().measureText(textView.getText().toString()) + "/" + mDestiny);
            textView.setTextSize(1, 13.0f);
            textView.setLines(1);
            lp.setMargins(0, mDestiny * 30, 0, 0);
            textView.setLayoutParams(lp);
            return;
        }
        textView.setTextSize(1, 11.0f);
        if (mDestiny * 84 > textView.getPaint().measureText(textView.getText().toString())) {
            textView.setLines(1);
            lp.setMargins(0, ((int) MainApplication.mContext.getResources().getDisplayMetrics().density) * 32, 0, 0);
            textView.setLayoutParams(lp);
        } else {
            textView.setLines(2);
            lp.setMargins(0, ((int) MainApplication.mContext.getResources().getDisplayMetrics().density) * 25, 0, 0);
            textView.setLayoutParams(lp);
        }
    }

    public void setDocViewBtnEnabled(boolean state) {
        this.mMenuDocsViewBtn.setEnabled(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSendData(int command, byte[] cmdData) {
        if (this.mOnSendCommandData != null) {
            this.mOnSendCommandData.onSendData(command, cmdData);
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mMenuPauseBtn != null) {
            this.mMenuPauseBtn.removeCallbacks(null);
            this.mMenuPauseBtn = null;
        }
        if (this.mMenuPenWritingBtn != null) {
            this.mMenuPenWritingBtn.removeCallbacks(null);
            this.mMenuPenWritingBtn = null;
        }
        if (this.mMenuDocsViewBtn != null) {
            this.mMenuDocsViewBtn.removeCallbacks(null);
            this.mMenuDocsViewBtn = null;
        }
        if (this.mMenuRemoteBtn != null) {
            this.mMenuRemoteBtn.removeCallbacks(null);
            this.mMenuRemoteBtn = null;
        }
        if (this.mMenuPauseImg != null) {
            this.mMenuPauseImg.removeCallbacks(null);
            this.mMenuPauseImg = null;
        }
        if (this.mMenuRemoteImg != null) {
            this.mMenuRemoteImg.removeCallbacks(null);
            this.mMenuRemoteImg = null;
        }
        if (this.mMenuPauseTxt != null) {
            this.mMenuPauseTxt.removeCallbacks(null);
            this.mMenuPauseTxt = null;
        }
        if (this.mMenuRemoteTxt != null) {
            this.mMenuRemoteTxt.removeCallbacks(null);
            this.mMenuRemoteTxt = null;
        }
        if (this.mMenuRemoteTextView != null) {
            this.mMenuRemoteTextView.removeCallbacks(null);
            this.mMenuRemoteTextView = null;
        }
        if (this.mMenuPauseLayout != null) {
            this.mMenuPauseLayout = null;
        }
        if (this.mMenuPenWritingLayout != null) {
            this.mMenuPenWritingLayout = null;
        }
        if (this.mMenuRemoteLayout != null) {
            this.mMenuRemoteLayout = null;
        }
        if (this.mMenuEndLayout != null) {
            this.mMenuEndLayout = null;
        }
        if (this.mMenuRomoteMenuLayout != null) {
            this.mMenuRomoteMenuLayout = null;
        }
        if (this.mMenuMaineMenuLayout != null) {
            this.mMenuMaineMenuLayout = null;
        }
        if (this.alertView != null) {
            this.alertView.dismiss();
            this.alertView = null;
        }
        if (this.mLocale != null) {
            this.mLocale = null;
        }
    }
}
