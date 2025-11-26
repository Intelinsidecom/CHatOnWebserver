package com.coolots.chaton.call.screenshare;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Service;
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
import com.coolots.sso.util.ChatONVAPII;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
public class ScreenShareView extends OverlayView implements DisposeInterface {
    private static final String CLASSNAME = "[ScreenShareView]";
    private static final int START_DRAG = 1;
    private static final int STOP_DRAG = 0;
    View.OnLongClickListener btnOnLongClickListener;
    View.OnTouchListener btnOnTouchListener;
    private int dragFlag;
    private Point mCurrentPoint;
    private Button mEndBtn;
    private boolean mIsMoveFirst;
    private ImageButton mMainBtn;
    private RelativeLayout mMainBtnLayout;
    private int mModeState;
    private Point mStartPoint;
    private WindowManager windowManager;

    private static void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public ScreenShareView(Service service) {
        super(service, C0000R.layout.screenshare_main_screen_share);
        this.dragFlag = 0;
        this.mStartPoint = null;
        this.mCurrentPoint = new Point(0, 0);
        this.mIsMoveFirst = false;
        this.mModeState = 0;
        this.btnOnLongClickListener = new View.OnLongClickListener() { // from class: com.coolots.chaton.call.screenshare.ScreenShareView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View arg0) {
                if (ScreenShareView.this.dragFlag == 0) {
                    ScreenShareView.this.dragFlag = 1;
                    ScreenShareView.this.mIsMoveFirst = false;
                }
                return false;
            }
        };
        this.btnOnTouchListener = new View.OnTouchListener() { // from class: com.coolots.chaton.call.screenshare.ScreenShareView.2
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) throws Resources.NotFoundException {
                switch (event.getAction()) {
                    case 0:
                        if (ScreenShareView.this.mStartPoint == null) {
                            ScreenShareView.this.mStartPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                        }
                        ScreenShareView.this.mCurrentPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                        return false;
                    case 1:
                        if (ScreenShareView.this.dragFlag == 1) {
                            ScreenShareView.this.dragFlag = 0;
                            if (!ScreenShareView.this.mIsMoveFirst) {
                                ScreenShareView.this.sendBtnEdge();
                            }
                        } else if (view.getId() == C0000R.id.share_btn) {
                            ScreenShareView.logI("ScreenShareProc.showPopupMenu()");
                            ScreenShareProc.showPopupMenu();
                            ScreenShareView.this.setMainButtonContentDiscription(ScreenShareProc.getInstance().getScreenSharePopupMenuShow());
                        } else if (view.getId() == C0000R.id.share_end_btn) {
                            ScreenShareView.logI("MainEndBtn Clicked ");
                            ScreenShareProc.setShareEnd();
                        }
                        return false;
                    case 2:
                        if (ScreenShareView.this.dragFlag == 1) {
                            int[] pos = {((int) event.getRawX()) - ScreenShareView.this.mCurrentPoint.x, ((int) event.getRawY()) - ScreenShareView.this.mCurrentPoint.y};
                            if (ScreenShareView.this.mIsMoveFirst || Math.abs(pos[0]) > 10 || Math.abs(pos[1]) > 10) {
                                ScreenShareView.this.mIsMoveFirst = true;
                                ScreenShareView.this.mCurrentPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                            } else {
                                pos[0] = 0;
                                pos[1] = 0;
                            }
                            ScreenShareView.this.moveView2(pos[0], pos[1], 2);
                        }
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.windowManager = null;
        load();
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView, android.widget.RelativeLayout
    public int getGravity() {
        return 51;
    }

    public ImageButton getMainButton() {
        return this.mMainBtn;
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void onInflateView() {
        this.mMainBtn = (ImageButton) findViewById(C0000R.id.share_btn);
        this.mEndBtn = (Button) findViewById(C0000R.id.share_end_btn);
        this.mMainBtnLayout = (RelativeLayout) findViewById(C0000R.id.share_btn_layout);
        this.mMainBtn.setOnLongClickListener(this.btnOnLongClickListener);
        this.mEndBtn.setOnLongClickListener(this.btnOnLongClickListener);
        this.mMainBtn.setOnTouchListener(this.btnOnTouchListener);
        this.mEndBtn.setOnTouchListener(this.btnOnTouchListener);
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void onTouchEvent_Move(MotionEvent event, boolean inside) {
    }

    public void setUserID(int id) {
        this.mUserId = id;
    }

    public void setPause(int mode) {
        this.mModeState = mode;
        if (this.mModeState == 1 || this.mModeState == 2) {
            this.mMainBtn.setImageResource(C0000R.drawable.screenshare_main_pause_btn_selector);
        } else if (this.mModeState == 0) {
            this.mMainBtn.setImageResource(C0000R.drawable.screenshare_main_share_btn_selector);
        }
    }

    public void setOtherPause(int mode) {
        if (mode == 1 || mode != 0) {
        }
    }

    public void show(boolean isAnimation) {
        if (isAnimation) {
            super.show();
            ObjectAnimator fadeOut = ObjectAnimator.ofFloat(this.mMainBtnLayout, "alpha", VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1.0f);
            fadeOut.setDuration(200L);
            fadeOut.start();
            return;
        }
        super.show();
    }

    public void dismiss(boolean isAnimation) {
        if (isAnimation) {
            ObjectAnimator fadeOut = ObjectAnimator.ofFloat(this.mMainBtnLayout, "alpha", 1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            fadeOut.setDuration(200L);
            fadeOut.addListener(new Animator.AnimatorListener() { // from class: com.coolots.chaton.call.screenshare.ScreenShareView.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ScreenShareView.this.dismiss();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator arg0) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator arg0) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator arg0) {
                }
            });
            fadeOut.start();
            return;
        }
        dismiss();
    }

    public void sendBtnEdge() {
        Point screenSize = getScreenSize();
        int screenCenter = screenSize.x / 2;
        int layoutCenter = this.layoutParams.x + (this.mMainBtnLayout.getWidth() / 2);
        int lastX = 0;
        if (screenCenter > layoutCenter) {
            lastX = screenSize.x - this.mMainBtnLayout.getWidth();
        }
        logI("move Pos= " + lastX + ChatONVAPII.USERID_DELEMETER + this.layoutParams.x);
        moveBtnEdge(lastX);
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
        if (this.mMainBtn != null) {
            this.mMainBtn.removeCallbacks(null);
            this.mMainBtn = null;
        }
        if (this.mEndBtn != null) {
            this.mEndBtn.removeCallbacks(null);
            this.mEndBtn = null;
        }
        this.mMainBtnLayout = null;
    }
}
