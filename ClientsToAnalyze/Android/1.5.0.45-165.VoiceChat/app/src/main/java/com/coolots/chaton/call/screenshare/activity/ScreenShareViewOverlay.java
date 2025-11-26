package com.coolots.chaton.call.screenshare.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.screenshare.core.OverlayView;
import com.coolots.chaton.call.screenshare.util.AlertView;
import com.coolots.sso.util.ChatONVAPII;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class ScreenShareViewOverlay extends OverlayView implements DisposeInterface {
    private static final String CLASSNAME = "[ScreenShareViewOverlay]";
    private static final int START_DRAG = 1;
    private static final int STOP_DRAG = 0;
    private int dragFlag;
    private boolean isMoveFirst;
    private View.OnLongClickListener mBtnOnLongClickListener;
    private View.OnTouchListener mBtnOnTouchListener;
    private Point mCurrentPoint;
    private Button mEndBtn;
    private ImageButton mMainBtn;
    private ScreenShareViewOverlayPopupMenu mScreenShareViewOverlayPopupMenu;
    private RelativeLayout mShareBtnLayout;
    private int mShareMode;
    private Point mStartPoint;
    private WindowManager windowManager;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public ScreenShareViewOverlay(Context context, int layoutResId, int shareMode) {
        super(context, layoutResId);
        this.dragFlag = 0;
        this.mStartPoint = null;
        this.mCurrentPoint = new Point(0, 0);
        this.isMoveFirst = false;
        this.mBtnOnLongClickListener = new View.OnLongClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareViewOverlay.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (ScreenShareViewOverlay.this.dragFlag == 0) {
                    ScreenShareViewOverlay.this.dragFlag = 1;
                    ScreenShareViewOverlay.this.isMoveFirst = false;
                }
                return false;
            }
        };
        this.mBtnOnTouchListener = new View.OnTouchListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareViewOverlay.2
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) throws Resources.NotFoundException {
                switch (event.getAction()) {
                    case 0:
                        if (ScreenShareViewOverlay.this.mStartPoint == null) {
                            ScreenShareViewOverlay.this.mStartPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                        }
                        ScreenShareViewOverlay.this.mCurrentPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                        return false;
                    case 1:
                        if (ScreenShareViewOverlay.this.dragFlag == 1) {
                            ScreenShareViewOverlay.this.dragFlag = 0;
                            if (!ScreenShareViewOverlay.this.isMoveFirst) {
                                ScreenShareViewOverlay.this.sendBtnEdge();
                            }
                        } else if (view.getId() == C0000R.id.share_overlay_btn) {
                            if (ScreenShareViewOverlay.this.mScreenShareViewOverlayPopupMenu.mShow) {
                                ScreenShareViewOverlay.this.mScreenShareViewOverlayPopupMenu.dismiss();
                                ScreenShareViewOverlay.this.setMainButtonContentDiscription(false);
                            } else {
                                ScreenShareViewOverlay.this.mScreenShareViewOverlayPopupMenu.show();
                                ScreenShareViewOverlay.this.setMainButtonContentDiscription(true);
                            }
                        } else if (view.getId() == C0000R.id.share_overlay_end_btn) {
                            ScreenShareViewOverlay.this.mEndBtnClick(view);
                        }
                        return false;
                    case 2:
                        if (ScreenShareViewOverlay.this.dragFlag == 1) {
                            int[] pos = {((int) event.getRawX()) - ScreenShareViewOverlay.this.mCurrentPoint.x, ((int) event.getRawY()) - ScreenShareViewOverlay.this.mCurrentPoint.y};
                            if (ScreenShareViewOverlay.this.isMoveFirst || Math.abs(pos[0]) > 10 || Math.abs(pos[1]) > 10) {
                                ScreenShareViewOverlay.this.isMoveFirst = true;
                                ScreenShareViewOverlay.this.mCurrentPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                            } else {
                                pos[0] = 0;
                                pos[1] = 0;
                            }
                            ScreenShareViewOverlay.this.moveView2(pos[0], pos[1], 1);
                        }
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.windowManager = null;
        this.mShareMode = shareMode;
        load();
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView, android.widget.RelativeLayout
    public int getGravity() {
        return 51;
    }

    public void setMenuPosition(Point point) {
        setPosition(point);
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void onInflateView() {
        logI("onInflateView()");
        this.mScreenShareViewOverlayPopupMenu = new ScreenShareViewOverlayPopupMenu(MainApplication.mContext, C0000R.layout.screenshare_main_popup_menu, this);
        this.mScreenShareViewOverlayPopupMenu.setViewMode(ScreenShareActivity.mOverlayPopupMenuMode);
        this.mScreenShareViewOverlayPopupMenu.dismiss();
        this.mMainBtn = (ImageButton) findViewById(C0000R.id.share_overlay_btn);
        this.mMainBtn.setImageResource(C0000R.drawable.screenshare_main_pause_btn_selector);
        this.mEndBtn = (Button) findViewById(C0000R.id.share_overlay_end_btn);
        this.mShareBtnLayout = (RelativeLayout) findViewById(C0000R.id.share_overlay_btn_layout);
        this.mMainBtn.setOnLongClickListener(this.mBtnOnLongClickListener);
        this.mMainBtn.setOnTouchListener(this.mBtnOnTouchListener);
        this.mEndBtn.setOnLongClickListener(this.mBtnOnLongClickListener);
        this.mEndBtn.setOnTouchListener(this.mBtnOnTouchListener);
        setMainButtonContentDiscription(false);
    }

    public void mMenuBtnClick(View view) {
        Intent i = new Intent(MainApplication.mContext, (Class<?>) ScreenShareActivity.class);
        i.addFlags(268435456);
        i.addFlags(536870912);
        i.addFlags(8388608);
        MainApplication.mContext.startActivity(i);
        setMainButtonContentDiscription(false);
        dismiss();
    }

    public void mEndBtnClick(View view) throws Resources.NotFoundException {
        AlertView alertView = new AlertView(MainApplication.mContext);
        alertView.setTitle(C0000R.string.call_btn_share_screen);
        alertView.setMessage(C0000R.string.screenshare_end_popup);
        alertView.setPositiveButton(C0000R.string.ok, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareViewOverlay.3
            @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
            public void onClick(AlertView dialog, int which) {
                ScreenShareViewOverlay.this.logI("setShareScreenCallback onStopShareScreen 00 - " + ScreenShareViewOverlay.this.mShareMode);
                if (ScreenShareViewOverlay.this.mShareMode != 1) {
                    if (ScreenShareViewOverlay.this.mShareMode == 3) {
                        MainApplication.mPhoneManager.getPhoneStateMachine().localHangupCall(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination(), 10);
                        return;
                    }
                    return;
                }
                MainApplication.mPhoneManager.getShareScreenManager().stopShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination());
            }
        });
        alertView.setNegativeButton(C0000R.string.cancel, new AlertView.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareViewOverlay.4
            @Override // com.coolots.chaton.call.screenshare.util.AlertView.OnClickListener
            public void onClick(AlertView dialog, int which) {
            }
        });
        alertView.setCancelable(true);
        alertView.show();
    }

    public void sendBtnEdge() {
        Point screenSize = getScreenSize();
        int screenCenter = screenSize.x / 2;
        int layoutCenter = this.layoutParams.x + (this.mShareBtnLayout.getWidth() / 2);
        int lastX = 0;
        if (screenCenter > layoutCenter) {
            lastX = screenSize.x - this.mShareBtnLayout.getWidth();
        }
        logI("move Pos= " + lastX + ChatONVAPII.USERID_DELEMETER + this.layoutParams.x);
        moveBtnEdge(lastX);
    }

    public void setPause(int pause) {
        this.mScreenShareViewOverlayPopupMenu.setPasue(pause);
    }

    private Point getScreenSize() {
        Point size = new Point();
        if (this.windowManager == null) {
            this.windowManager = (WindowManager) getContext().getSystemService("window");
        }
        Display screenSize = this.windowManager.getDefaultDisplay();
        screenSize.getSize(size);
        return size;
    }

    public void setMenuViewMode(int mode) {
        if (this.mScreenShareViewOverlayPopupMenu != null) {
            this.mScreenShareViewOverlayPopupMenu.setViewMode(mode);
            setMainButtonContentDiscription(this.mScreenShareViewOverlayPopupMenu.mShow);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        logI("onConfigurationChanged");
        if (newConfig.orientation == 1 || newConfig.orientation == 2) {
            moveView(0, (int) (25.0f * getResources().getDisplayMetrics().density));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMainButtonContentDiscription(boolean show) {
        if (this.mMainBtn != null) {
            if (show) {
                this.mMainBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_talkback_share));
            } else {
                this.mMainBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_talkback_share_show_controller));
            }
        }
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    public void dismissMenu(boolean show) {
        setMainButtonContentDiscription(show);
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        logI("dispose()");
        if (this.mMainBtn != null) {
            this.mMainBtn.removeCallbacks(null);
            this.mMainBtn = null;
        }
        if (this.mEndBtn != null) {
            this.mEndBtn.removeCallbacks(null);
            this.mEndBtn = null;
        }
        if (this.mShareBtnLayout != null) {
            this.mShareBtnLayout.removeAllViewsInLayout();
            this.mShareBtnLayout = null;
        }
        if (this.mScreenShareViewOverlayPopupMenu != null) {
            this.mScreenShareViewOverlayPopupMenu.dispose();
        }
    }
}
