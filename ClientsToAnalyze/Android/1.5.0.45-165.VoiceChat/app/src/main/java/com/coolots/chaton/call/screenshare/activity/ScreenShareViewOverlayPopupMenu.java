package com.coolots.chaton.call.screenshare.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.screenshare.ScreenShareProc;
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
public class ScreenShareViewOverlayPopupMenu extends OverlayView implements DisposeInterface {
    private static final String CLASSNAME = "[ScreenShareViewOverlayPopupMenu]";
    public static final int SCREEN_SHARE_POPUP_MENU_SHARE_MODE = 0;
    public static final int SCREEN_SHARE_POPUP_MENU_SHARE_MODE_REMOTE = 1;
    public static final int SCREEN_SHARE_POPUP_MENU_VIEW_MODE = 2;
    public static final int SCREEN_SHARE_POPUP_MENU_VIEW_MODE_REMOTE = 3;
    public static ScreenShareViewOverlayPopupMenu mInstance;
    public static OverlayView mOverlayView;
    private Point currentTouchPoint;
    private boolean isDragMode;
    private boolean isFirstPlace;
    private boolean isMoveFirst;
    private View.OnLongClickListener mBtnOnLongClickListener;
    private View.OnTouchListener mBtnOnTouchListener;
    private ScreenShareViewOverlayPopupMenuHandler mHandler;
    private String mLocale;
    private Button mMenuEndBtn;
    private ImageView mMenuEndImg;
    private FrameLayout mMenuEndLayout;
    private TextView mMenuEndTxt;
    private int mMenuHeight;
    private Button mMenuPanWritingBtn;
    private TextView mMenuPanWritingTxt;
    private Button mMenuPasueBtn;
    private ImageView mMenuPauseImg;
    private FrameLayout mMenuPauseLayout;
    private TextView mMenuPauseTxt;
    private FrameLayout mMenuPenWritingLayout;
    private Button mMenuRemoteBtn;
    private ImageView mMenuRemoteImg;
    private FrameLayout mMenuRemoteLayout;
    private TextView mMenuRemoteTextView;
    private TextView mMenuRemoteTxt;
    private LinearLayout mMenuRomoteMenuLayout;
    public int mPauseType;
    private int menuWidth;
    ScreenShareLayout.OnButtonEvent onButtonEvent;
    private Point startTouchPoint;

    /* renamed from: wm */
    protected WindowManager f4wm;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public class ScreenShareViewOverlayPopupMenuHandler extends Handler implements DisposeInterface {
        private boolean bDisposed = false;

        public ScreenShareViewOverlayPopupMenuHandler() {
        }

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            ScreenShareViewOverlayPopupMenu.this.logI("Dispose ScreenShareViewOverlayPopupMenuHandler");
            this.bDisposed = true;
        }
    }

    public ScreenShareViewOverlayPopupMenu(Context context, int layoutId) {
        super(context, layoutId);
        this.mHandler = new ScreenShareViewOverlayPopupMenuHandler();
        this.isDragMode = false;
        this.startTouchPoint = null;
        this.currentTouchPoint = new Point(0, 0);
        this.isMoveFirst = false;
        this.isFirstPlace = true;
        this.menuWidth = 360;
        this.mMenuHeight = 68;
        this.mBtnOnLongClickListener = new View.OnLongClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareViewOverlayPopupMenu.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (!ScreenShareViewOverlayPopupMenu.this.isDragMode) {
                    ScreenShareViewOverlayPopupMenu.this.isDragMode = true;
                    ScreenShareViewOverlayPopupMenu.this.isMoveFirst = false;
                }
                return false;
            }
        };
        this.mBtnOnTouchListener = new View.OnTouchListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareViewOverlayPopupMenu.2
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) throws Resources.NotFoundException {
                switch (event.getAction()) {
                    case 0:
                        if (ScreenShareViewOverlayPopupMenu.this.startTouchPoint == null) {
                            ScreenShareViewOverlayPopupMenu.this.startTouchPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                        }
                        ScreenShareViewOverlayPopupMenu.this.currentTouchPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                        return false;
                    case 1:
                        if (ScreenShareViewOverlayPopupMenu.this.isDragMode) {
                            ScreenShareViewOverlayPopupMenu.this.isDragMode = false;
                        } else if (view.getId() == C0000R.id.menu_pause_btn) {
                            ScreenShareViewOverlayPopupMenu.this.logI("Press Pause Button ");
                            if (ScreenShareViewOverlayPopupMenu.this.mPauseType == 2 || ScreenShareActivity.mInstance.mOtherPauseType == 2) {
                                ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.unable_restart_chatonv_call_hold), 0);
                                ScreenShareViewOverlayPopupMenu.this.dismissMenu(ScreenShareViewOverlayPopupMenu.this.mShow);
                            } else {
                                ScreenShareViewOverlayPopupMenu.this.resumeActivity(view);
                                ScreenShareViewOverlayPopupMenu.this.dismissMenu(ScreenShareViewOverlayPopupMenu.this.mShow);
                            }
                        } else {
                            if (view.getId() == C0000R.id.menu_pen_writing_btn) {
                                ScreenShareViewOverlayPopupMenu.this.logI("Press PenWriting Button");
                                if ((ScreenShareViewOverlayPopupMenu.this.mPauseType == 1 && ScreenShareActivity.mInstance.mOtherPauseType == 2) || ScreenShareViewOverlayPopupMenu.this.mPauseType == 2) {
                                    ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.unable_restart_chatonv_call_hold), 0);
                                    ScreenShareViewOverlayPopupMenu.this.dismissMenu(ScreenShareViewOverlayPopupMenu.this.mShow);
                                } else {
                                    ScreenShareViewOverlayPopupMenu.this.resumeActivity(view);
                                    ScreenShareActivity.mInstance.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_DRAWING_REQ_MODE, null);
                                }
                            } else if (view.getId() == C0000R.id.menu_remote_btn) {
                                ScreenShareViewOverlayPopupMenu.this.logI("Press Remote Button");
                            } else if (view.getId() == C0000R.id.menu_end_btn) {
                                ScreenShareViewOverlayPopupMenu.this.logI("mMenuEndBtn ");
                                AlertView alertView = new AlertView(MainApplication.mContext);
                                alertView.setTitle(C0000R.string.call_btn_share_screen);
                                alertView.setMessage(C0000R.string.screenshare_end_popup);
                                alertView.setPositiveButton(C0000R.string.ok, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareViewOverlayPopupMenu.2.1
                                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                                    public void onClick(AlertView dialog, int which) {
                                        MainApplication.mPhoneManager.getShareScreenManager().stopShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination());
                                        ScreenShareActivity.mInstance.finish();
                                    }
                                });
                                alertView.setNegativeButton(C0000R.string.cancel, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareViewOverlayPopupMenu.2.2
                                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                                    public void onClick(AlertView dialog, int which) {
                                    }
                                });
                                alertView.setCancelable(true);
                                alertView.show();
                            }
                            ScreenShareViewOverlayPopupMenu.this.dismissMenu(ScreenShareViewOverlayPopupMenu.this.mShow);
                        }
                        return false;
                    case 2:
                        if (ScreenShareViewOverlayPopupMenu.this.isDragMode) {
                            int[] pos = {((int) event.getRawX()) - ScreenShareViewOverlayPopupMenu.this.currentTouchPoint.x, ((int) event.getRawY()) - ScreenShareViewOverlayPopupMenu.this.currentTouchPoint.y};
                            if (ScreenShareViewOverlayPopupMenu.this.isMoveFirst || Math.abs(pos[0]) > 10 || Math.abs(pos[1]) > 10) {
                                ScreenShareViewOverlayPopupMenu.this.isMoveFirst = true;
                                ScreenShareViewOverlayPopupMenu.this.currentTouchPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                            } else {
                                pos[0] = 0;
                                pos[1] = 0;
                            }
                            ScreenShareViewOverlayPopupMenu.this.moveView2(pos[0], pos[1], 2);
                        }
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.f4wm = null;
        mInstance = this;
        load();
    }

    public ScreenShareViewOverlayPopupMenu(Context context, int layoutId, OverlayView overlayView) {
        super(context, layoutId);
        this.mHandler = new ScreenShareViewOverlayPopupMenuHandler();
        this.isDragMode = false;
        this.startTouchPoint = null;
        this.currentTouchPoint = new Point(0, 0);
        this.isMoveFirst = false;
        this.isFirstPlace = true;
        this.menuWidth = 360;
        this.mMenuHeight = 68;
        this.mBtnOnLongClickListener = new View.OnLongClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareViewOverlayPopupMenu.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (!ScreenShareViewOverlayPopupMenu.this.isDragMode) {
                    ScreenShareViewOverlayPopupMenu.this.isDragMode = true;
                    ScreenShareViewOverlayPopupMenu.this.isMoveFirst = false;
                }
                return false;
            }
        };
        this.mBtnOnTouchListener = new View.OnTouchListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareViewOverlayPopupMenu.2
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) throws Resources.NotFoundException {
                switch (event.getAction()) {
                    case 0:
                        if (ScreenShareViewOverlayPopupMenu.this.startTouchPoint == null) {
                            ScreenShareViewOverlayPopupMenu.this.startTouchPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                        }
                        ScreenShareViewOverlayPopupMenu.this.currentTouchPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                        return false;
                    case 1:
                        if (ScreenShareViewOverlayPopupMenu.this.isDragMode) {
                            ScreenShareViewOverlayPopupMenu.this.isDragMode = false;
                        } else if (view.getId() == C0000R.id.menu_pause_btn) {
                            ScreenShareViewOverlayPopupMenu.this.logI("Press Pause Button ");
                            if (ScreenShareViewOverlayPopupMenu.this.mPauseType == 2 || ScreenShareActivity.mInstance.mOtherPauseType == 2) {
                                ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.unable_restart_chatonv_call_hold), 0);
                                ScreenShareViewOverlayPopupMenu.this.dismissMenu(ScreenShareViewOverlayPopupMenu.this.mShow);
                            } else {
                                ScreenShareViewOverlayPopupMenu.this.resumeActivity(view);
                                ScreenShareViewOverlayPopupMenu.this.dismissMenu(ScreenShareViewOverlayPopupMenu.this.mShow);
                            }
                        } else {
                            if (view.getId() == C0000R.id.menu_pen_writing_btn) {
                                ScreenShareViewOverlayPopupMenu.this.logI("Press PenWriting Button");
                                if ((ScreenShareViewOverlayPopupMenu.this.mPauseType == 1 && ScreenShareActivity.mInstance.mOtherPauseType == 2) || ScreenShareViewOverlayPopupMenu.this.mPauseType == 2) {
                                    ScreenShareProc.showToast(MainApplication.mContext.getApplicationContext(), MainApplication.mContext.getString(C0000R.string.unable_restart_chatonv_call_hold), 0);
                                    ScreenShareViewOverlayPopupMenu.this.dismissMenu(ScreenShareViewOverlayPopupMenu.this.mShow);
                                } else {
                                    ScreenShareViewOverlayPopupMenu.this.resumeActivity(view);
                                    ScreenShareActivity.mInstance.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_DRAWING_REQ_MODE, null);
                                }
                            } else if (view.getId() == C0000R.id.menu_remote_btn) {
                                ScreenShareViewOverlayPopupMenu.this.logI("Press Remote Button");
                            } else if (view.getId() == C0000R.id.menu_end_btn) {
                                ScreenShareViewOverlayPopupMenu.this.logI("mMenuEndBtn ");
                                AlertView alertView = new AlertView(MainApplication.mContext);
                                alertView.setTitle(C0000R.string.call_btn_share_screen);
                                alertView.setMessage(C0000R.string.screenshare_end_popup);
                                alertView.setPositiveButton(C0000R.string.ok, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareViewOverlayPopupMenu.2.1
                                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                                    public void onClick(AlertView dialog, int which) {
                                        MainApplication.mPhoneManager.getShareScreenManager().stopShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination());
                                        ScreenShareActivity.mInstance.finish();
                                    }
                                });
                                alertView.setNegativeButton(C0000R.string.cancel, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareViewOverlayPopupMenu.2.2
                                    @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
                                    public void onClick(AlertView dialog, int which) {
                                    }
                                });
                                alertView.setCancelable(true);
                                alertView.show();
                            }
                            ScreenShareViewOverlayPopupMenu.this.dismissMenu(ScreenShareViewOverlayPopupMenu.this.mShow);
                        }
                        return false;
                    case 2:
                        if (ScreenShareViewOverlayPopupMenu.this.isDragMode) {
                            int[] pos = {((int) event.getRawX()) - ScreenShareViewOverlayPopupMenu.this.currentTouchPoint.x, ((int) event.getRawY()) - ScreenShareViewOverlayPopupMenu.this.currentTouchPoint.y};
                            if (ScreenShareViewOverlayPopupMenu.this.isMoveFirst || Math.abs(pos[0]) > 10 || Math.abs(pos[1]) > 10) {
                                ScreenShareViewOverlayPopupMenu.this.isMoveFirst = true;
                                ScreenShareViewOverlayPopupMenu.this.currentTouchPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                            } else {
                                pos[0] = 0;
                                pos[1] = 0;
                            }
                            ScreenShareViewOverlayPopupMenu.this.moveView2(pos[0], pos[1], 2);
                        }
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.f4wm = null;
        mInstance = this;
        mOverlayView = overlayView;
        load();
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView, android.widget.RelativeLayout
    public int getGravity() {
        return 51;
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void onInflateView() {
        this.mMenuPasueBtn = (Button) findViewById(C0000R.id.menu_pause_btn);
        this.mMenuPanWritingBtn = (Button) findViewById(C0000R.id.menu_pen_writing_btn);
        this.mMenuEndBtn = (Button) findViewById(C0000R.id.menu_end_btn);
        this.mMenuRemoteBtn = (Button) findViewById(C0000R.id.menu_remote_btn);
        this.mMenuPauseImg = (ImageView) findViewById(C0000R.id.menu_pause_img);
        this.mMenuRemoteImg = (ImageView) findViewById(C0000R.id.menu_remote_img);
        this.mMenuPauseTxt = (TextView) findViewById(C0000R.id.menu_pause_txt);
        this.mMenuRemoteTxt = (TextView) findViewById(C0000R.id.menu_remote_txt);
        this.mMenuPanWritingTxt = (TextView) findViewById(C0000R.id.menu_pen_writing_txt);
        setTextViewEditor(this.mMenuRemoteTxt);
        this.mMenuPauseLayout = (FrameLayout) findViewById(C0000R.id.menu_pause_layout);
        this.mMenuPenWritingLayout = (FrameLayout) findViewById(C0000R.id.menu_pen_writing_layout);
        this.mMenuRemoteLayout = (FrameLayout) findViewById(C0000R.id.menu_remote_layout);
        this.mMenuEndLayout = (FrameLayout) findViewById(C0000R.id.menu_end_layout);
        this.mMenuRemoteTextView = (TextView) findViewById(C0000R.id.remote_textview);
        this.mMenuRemoteTextView.setVisibility(8);
        this.mMenuRomoteMenuLayout = (LinearLayout) findViewById(C0000R.id.remote_control_layout);
        this.mMenuRomoteMenuLayout.setVisibility(8);
        this.mMenuEndImg = (ImageView) findViewById(C0000R.id.menu_end_img);
        this.mMenuEndImg.setImageDrawable(getResources().getDrawable(C0000R.drawable.screenshare_main_popup_end_selector));
        this.mMenuEndTxt = (TextView) findViewById(C0000R.id.menu_end_txt);
        this.mMenuEndTxt.setText(getResources().getString(C0000R.string.call_info_callend));
        this.mMenuPasueBtn.setOnLongClickListener(this.mBtnOnLongClickListener);
        this.mMenuPanWritingBtn.setOnLongClickListener(this.mBtnOnLongClickListener);
        this.mMenuEndBtn.setOnLongClickListener(this.mBtnOnLongClickListener);
        this.mMenuRemoteBtn.setOnLongClickListener(this.mBtnOnLongClickListener);
        this.mMenuPasueBtn.setOnTouchListener(this.mBtnOnTouchListener);
        this.mMenuPanWritingBtn.setOnTouchListener(this.mBtnOnTouchListener);
        this.mMenuEndBtn.setOnTouchListener(this.mBtnOnTouchListener);
        this.mMenuRemoteBtn.setOnTouchListener(this.mBtnOnTouchListener);
        this.mMenuPauseTxt.setText(C0000R.string.screenshare_menu_restart);
        this.mMenuPauseImg.setImageResource(C0000R.drawable.screenshare_main_popup_restart_selector);
        this.mMenuRemoteBtn.setEnabled(false);
        this.mLocale = getResources().getConfiguration().locale.toString();
    }

    public void setViewMode(final int mode) {
        this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareViewOverlayPopupMenu.3
            @Override // java.lang.Runnable
            public void run() {
                if (ScreenShareViewOverlayPopupMenu.this.mHandler != null && ScreenShareViewOverlayPopupMenu.this.mHandler.bDisposed) {
                    ScreenShareViewOverlayPopupMenu.this.logI("ScreenShareViewOverlayPopupMenuHandler was disposed. so this message is going to be ignored.");
                    return;
                }
                if (ScreenShareViewOverlayPopupMenu.this.mMenuRemoteTextView != null) {
                    ScreenShareViewOverlayPopupMenu.this.mMenuRemoteTextView.setVisibility(8);
                }
                if (ScreenShareViewOverlayPopupMenu.this.mMenuRomoteMenuLayout != null) {
                    ScreenShareViewOverlayPopupMenu.this.mMenuRomoteMenuLayout.setVisibility(8);
                }
                Destination dest = MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination();
                if (ScreenShareViewOverlayPopupMenu.this.mMenuPenWritingLayout != null) {
                    if (dest == null || dest.getDestinationType() != 4) {
                        ScreenShareViewOverlayPopupMenu.this.mMenuPenWritingLayout.setEnabled(true);
                    } else {
                        ScreenShareViewOverlayPopupMenu.this.mMenuPenWritingLayout.setEnabled(false);
                    }
                }
                if (mode == 3 || mode == 1) {
                    if (ScreenShareViewOverlayPopupMenu.this.mMenuRemoteImg != null) {
                        ScreenShareViewOverlayPopupMenu.this.mMenuRemoteImg.setImageResource(C0000R.drawable.screenshare_main_popup_end_remotecontrol_selector);
                        ScreenShareViewOverlayPopupMenu.this.mMenuRemoteImg.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_talkback_share_menu_remote_end));
                    }
                    if (ScreenShareViewOverlayPopupMenu.this.mMenuRemoteTxt != null) {
                        ScreenShareViewOverlayPopupMenu.this.mMenuRemoteTxt.setText(C0000R.string.screenshare_menu_end_remote_btn);
                        ScreenShareViewOverlayPopupMenu.this.setTextViewEditor(ScreenShareViewOverlayPopupMenu.this.mMenuRemoteTxt);
                    }
                } else {
                    if (ScreenShareViewOverlayPopupMenu.this.mMenuRemoteImg != null) {
                        ScreenShareViewOverlayPopupMenu.this.mMenuRemoteImg.setImageResource(C0000R.drawable.screenshare_main_popup_remotecontrol_selector);
                        ScreenShareViewOverlayPopupMenu.this.mMenuRemoteImg.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_menu_remote_btn));
                    }
                    if (ScreenShareViewOverlayPopupMenu.this.mMenuRemoteTxt != null) {
                        ScreenShareViewOverlayPopupMenu.this.mMenuRemoteTxt.setText(C0000R.string.screenshare_menu_remote_btn);
                        ScreenShareViewOverlayPopupMenu.this.setTextViewEditor(ScreenShareViewOverlayPopupMenu.this.mMenuRemoteTxt);
                    }
                }
                if (mode == 0) {
                    if (ScreenShareViewOverlayPopupMenu.this.mMenuRemoteLayout != null) {
                        ScreenShareViewOverlayPopupMenu.this.mMenuRemoteLayout.setEnabled(false);
                        ScreenShareViewOverlayPopupMenu.this.mMenuRemoteLayout.setVisibility(8);
                    }
                    if (ScreenShareViewOverlayPopupMenu.this.mMenuPauseLayout != null) {
                        ScreenShareViewOverlayPopupMenu.this.setLayoutWidth(ScreenShareViewOverlayPopupMenu.this.mMenuPauseLayout, 113);
                    }
                    if (ScreenShareViewOverlayPopupMenu.this.mMenuPenWritingLayout != null) {
                        ScreenShareViewOverlayPopupMenu.this.setLayoutWidth(ScreenShareViewOverlayPopupMenu.this.mMenuPenWritingLayout, 114);
                    }
                    if (ScreenShareViewOverlayPopupMenu.this.mMenuEndLayout != null) {
                        ScreenShareViewOverlayPopupMenu.this.setLayoutWidth(ScreenShareViewOverlayPopupMenu.this.mMenuEndLayout, 113);
                    }
                } else {
                    if (ScreenShareViewOverlayPopupMenu.this.mMenuRemoteLayout != null) {
                        ScreenShareViewOverlayPopupMenu.this.mMenuRemoteLayout.setEnabled(true);
                        ScreenShareViewOverlayPopupMenu.this.mMenuRemoteLayout.setVisibility(0);
                    }
                    if (ScreenShareViewOverlayPopupMenu.this.mMenuPauseLayout != null) {
                        ScreenShareViewOverlayPopupMenu.this.setLayoutWidth(ScreenShareViewOverlayPopupMenu.this.mMenuPauseLayout, 85);
                    }
                    if (ScreenShareViewOverlayPopupMenu.this.mMenuPenWritingLayout != null) {
                        ScreenShareViewOverlayPopupMenu.this.setLayoutWidth(ScreenShareViewOverlayPopupMenu.this.mMenuPenWritingLayout, 85);
                    }
                    if (ScreenShareViewOverlayPopupMenu.this.mMenuEndLayout != null) {
                        ScreenShareViewOverlayPopupMenu.this.setLayoutWidth(ScreenShareViewOverlayPopupMenu.this.mMenuEndLayout, 85);
                    }
                }
                if (ScreenShareViewOverlayPopupMenu.this.mMenuRemoteLayout != null) {
                    ScreenShareViewOverlayPopupMenu.this.mMenuRemoteLayout.setEnabled(false);
                }
            }
        });
    }

    public void setPasue(int pause) {
        logI("setPasue()" + pause);
        this.mPauseType = pause;
    }

    public void setLayoutWidth(FrameLayout layout, int witdh) {
        if (layout != null) {
            int btnWidth = (int) (witdh * getResources().getDisplayMetrics().density);
            ViewGroup.LayoutParams layoutParams = layout.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = btnWidth;
                layout.setLayoutParams(layoutParams);
            }
        }
    }

    protected void initPosition() {
        int posX = this.layoutParams.x;
        int posY = this.layoutParams.y;
        Point disMaxPos = new Point();
        if (this.f4wm == null) {
            this.f4wm = (WindowManager) getContext().getSystemService("window");
        }
        Display display = this.f4wm.getDefaultDisplay();
        display.getSize(disMaxPos);
        int width = (int) (this.menuWidth * MainApplication.mContext.getResources().getDisplayMetrics().density);
        int height = (int) (this.mMenuHeight * MainApplication.mContext.getResources().getDisplayMetrics().density);
        logI("initPosition Menu Size - " + width + ", " + height + " - " + getWidth() + " isFirstPlace: " + this.isFirstPlace);
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
        this.isFirstPlace = false;
        sizeView(width, height);
        moveView(posX, posY);
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    public void show() {
        initPosition();
        super.show();
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void onTouchEvent_PressOutside(MotionEvent event) {
        logI("onTouchEvent_PressOutside");
        if (!ScreenShareProc.isShareButtonRect((int) event.getRawX(), (int) event.getRawY())) {
            dismissMenu(this.mShow);
        }
    }

    public void resumeActivity(View view) {
        Intent i = new Intent(MainApplication.mContext, (Class<?>) ScreenShareActivity.class);
        i.addFlags(268435456);
        i.addFlags(536870912);
        i.addFlags(8388608);
        i.putExtra("menu_point", this.mMenuPoint);
        MainApplication.mContext.startActivity(i);
        dismissMenu(this.mShow);
        ScreenShareActivity.mInstance.onSendData(ScreenSharePacket.SCREEN_SHARE_CMD_RESTART, null);
        MainApplication.mPhoneManager.getShareScreenManager().resumeShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), this.mMenuPoint, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextViewEditor(TextView textView) {
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

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        logI("onConfigurationChanged");
        if (newConfig.orientation == 1 || newConfig.orientation == 2) {
            logI("onConfigurationChanged Configuration.ORIENTATION_PORTRAIT");
            this.isFirstPlace = true;
            initPosition();
        }
        if (!newConfig.locale.toString().equalsIgnoreCase(this.mLocale)) {
            this.mMenuPasueBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_menu_restart));
            this.mMenuPanWritingBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_talkback_share_menu_penwriting));
            this.mMenuEndBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.call_info_callend));
            this.mMenuRemoteBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_menu_end_remote_btn));
            this.mMenuPauseTxt.setText(C0000R.string.screenshare_menu_restart);
            this.mMenuRemoteTxt.setText(C0000R.string.screenshare_menu_end_remote_btn);
            this.mMenuEndTxt.setText(C0000R.string.call_info_callend);
            this.mMenuPanWritingTxt.setText(C0000R.string.screenshare_talkback_share_menu_penwriting);
            this.mLocale = newConfig.locale.toString();
        }
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    public void dismissMenu(boolean show) {
        dismiss();
        if (mOverlayView != null) {
            mOverlayView.dismissMenu(show);
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        logI("dispose()");
        if (this.mMenuPasueBtn != null) {
            this.mMenuPasueBtn.removeCallbacks(null);
            this.mMenuPasueBtn = null;
        }
        if (this.mMenuPanWritingBtn != null) {
            this.mMenuPanWritingBtn.removeCallbacks(null);
            this.mMenuPanWritingBtn = null;
        }
        if (this.mMenuEndBtn != null) {
            this.mMenuEndBtn.removeCallbacks(null);
            this.mMenuEndBtn = null;
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
            this.mMenuPauseLayout.removeAllViews();
            this.mMenuPauseLayout = null;
        }
        if (this.mMenuPenWritingLayout != null) {
            this.mMenuPenWritingLayout.removeAllViewsInLayout();
            this.mMenuPenWritingLayout = null;
        }
        if (this.mMenuRemoteLayout != null) {
            this.mMenuRemoteLayout.removeAllViewsInLayout();
            this.mMenuRemoteLayout = null;
        }
        if (this.mMenuEndLayout != null) {
            this.mMenuEndLayout.removeAllViewsInLayout();
            this.mMenuEndLayout = null;
        }
        if (this.mMenuRomoteMenuLayout != null) {
            this.mMenuRomoteMenuLayout.removeAllViewsInLayout();
            this.mMenuRomoteMenuLayout = null;
        }
        if (this.mHandler != null) {
            this.mHandler.dispose();
            this.mHandler = null;
        }
    }
}
