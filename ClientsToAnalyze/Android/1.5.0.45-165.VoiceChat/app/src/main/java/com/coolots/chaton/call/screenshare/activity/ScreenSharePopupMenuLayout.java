package com.coolots.chaton.call.screenshare.activity;

import android.content.Context;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.Locale;

/* loaded from: classes.dex */
public class ScreenSharePopupMenuLayout extends ScreenShareLayout implements DisposeInterface {
    private static final String CLASSNAME = "[ScreenSharePopupMenuLayout]";
    private boolean dragFlag;
    private boolean isFirstPlace;
    private boolean isManualMove;
    private boolean isMoveFirst;
    protected FrameLayout.LayoutParams layoutParams;
    View.OnLongClickListener mBtnLongClickListener;
    View.OnTouchListener mBtnTouchListener;
    private Point mCurrentPoint;
    private Handler mHandler;
    private MenuBtnHandler mMenuBtnHandler;
    private Button mMenuEndBtn;
    private ImageView mMenuEndImg;
    private FrameLayout mMenuEndLayout;
    private TextView mMenuEndTxt;
    private int mMenuHeight;
    private int mMenuHeight2;
    private LinearLayout mMenuMainLayout;
    private Button mMenuPanWritingBtn;
    private Button mMenuPasueBtn;
    private ImageView mMenuPauseImg;
    private FrameLayout mMenuPauseLayout;
    private TextView mMenuPauseTxt;
    private FrameLayout mMenuPenWritingLayout;
    private Button mMenuRemoteBackBtn;
    private Button mMenuRemoteBtn;
    private Button mMenuRemoteHomeBtn;
    private ImageView mMenuRemoteImg;
    private FrameLayout mMenuRemoteLayout;
    private Button mMenuRemoteMenuBtn;
    private TextView mMenuRemoteTextView;
    private TextView mMenuRemoteTxt;
    private LinearLayout mMenuRomoteLayout;
    private int mMenuWidth;
    private int mRemoteMode;
    private ScreenShareActivity mScreenShareActivity;
    private Point mStartPoint;

    /* renamed from: wm */
    protected WindowManager f3wm;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public ScreenSharePopupMenuLayout(Context context, int layoutResId) {
        super(context, layoutResId);
        this.mHandler = new Handler();
        this.mMenuBtnHandler = new MenuBtnHandler(this, null);
        this.mMenuWidth = 360;
        this.mMenuHeight = 68;
        this.mMenuHeight2 = 145;
        this.dragFlag = false;
        this.mStartPoint = null;
        this.mCurrentPoint = new Point(0, 0);
        this.isMoveFirst = false;
        this.isFirstPlace = true;
        this.isManualMove = false;
        this.mBtnLongClickListener = new View.OnLongClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenSharePopupMenuLayout.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View arg0) {
                if (!ScreenSharePopupMenuLayout.this.dragFlag) {
                    ScreenSharePopupMenuLayout.this.dragFlag = true;
                    ScreenSharePopupMenuLayout.this.isMoveFirst = false;
                }
                return false;
            }
        };
        this.mBtnTouchListener = new View.OnTouchListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenSharePopupMenuLayout.2
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        if (ScreenSharePopupMenuLayout.this.mStartPoint == null) {
                            ScreenSharePopupMenuLayout.this.mStartPoint = new Point((int) ScreenSharePopupMenuLayout.this.mMenuMainLayout.getX(), (int) ScreenSharePopupMenuLayout.this.mMenuMainLayout.getY());
                        }
                        ScreenSharePopupMenuLayout.this.mCurrentPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                        return false;
                    case 1:
                        if (ScreenSharePopupMenuLayout.this.dragFlag) {
                            ScreenSharePopupMenuLayout.this.dragFlag = false;
                        } else {
                            ScreenSharePopupMenuLayout.this.dismiss(view.getId());
                            ScreenSharePopupMenuLayout.this.mScreenShareActivity.setMainButtonContentDiscription(ScreenSharePopupMenuLayout.this.mShow);
                        }
                        return false;
                    case 2:
                        if (ScreenSharePopupMenuLayout.this.dragFlag) {
                            int[] gap = {((int) event.getRawX()) - ScreenSharePopupMenuLayout.this.mCurrentPoint.x, ((int) event.getRawY()) - ScreenSharePopupMenuLayout.this.mCurrentPoint.y};
                            if (ScreenSharePopupMenuLayout.this.isMoveFirst || Math.abs(gap[0]) > 10 || Math.abs(gap[1]) > 10) {
                                ScreenSharePopupMenuLayout.this.isMoveFirst = true;
                                ScreenSharePopupMenuLayout.this.isManualMove = true;
                                ScreenSharePopupMenuLayout.this.mCurrentPoint = new Point((int) event.getRawX(), (int) event.getRawY());
                            } else {
                                gap[0] = 0;
                                gap[1] = 0;
                            }
                            ScreenSharePopupMenuLayout.this.mScreenShareActivity.setMenuPos(gap);
                        }
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.f3wm = null;
        logI("ScreenSharePopupMenuLayout constructor");
        this.mContext = context;
        this.mScreenShareActivity = (ScreenShareActivity) context;
        RelativeLayout.LayoutParams thisLayoutParam = new RelativeLayout.LayoutParams(-2, -2);
        setLayoutParams(thisLayoutParam);
        this.mMenuPasueBtn = (Button) findViewById(C0000R.id.menu_pause_btn);
        this.mMenuPanWritingBtn = (Button) findViewById(C0000R.id.menu_pen_writing_btn);
        this.mMenuEndBtn = (Button) findViewById(C0000R.id.menu_end_btn);
        this.mMenuRemoteBtn = (Button) findViewById(C0000R.id.menu_remote_btn);
        this.mMenuRemoteMenuBtn = (Button) findViewById(C0000R.id.menu_main_remote_menu);
        this.mMenuRemoteHomeBtn = (Button) findViewById(C0000R.id.menu_main_remote_home);
        this.mMenuRemoteBackBtn = (Button) findViewById(C0000R.id.menu_main_remote_back);
        this.mMenuPauseImg = (ImageView) findViewById(C0000R.id.menu_pause_img);
        this.mMenuRemoteImg = (ImageView) findViewById(C0000R.id.menu_remote_img);
        this.mMenuPauseTxt = (TextView) findViewById(C0000R.id.menu_pause_txt);
        this.mMenuRemoteTxt = (TextView) findViewById(C0000R.id.menu_remote_txt);
        setTextViewEditor(this.mMenuRemoteTxt);
        this.mMenuPauseLayout = (FrameLayout) findViewById(C0000R.id.menu_pause_layout);
        this.mMenuPenWritingLayout = (FrameLayout) findViewById(C0000R.id.menu_pen_writing_layout);
        this.mMenuRemoteLayout = (FrameLayout) findViewById(C0000R.id.menu_remote_layout);
        this.mMenuEndLayout = (FrameLayout) findViewById(C0000R.id.menu_end_layout);
        Destination dest = MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination();
        if (dest != null && dest.getDestinationType() == 4) {
            this.mMenuPenWritingLayout.setEnabled(false);
            this.mMenuPanWritingBtn.setEnabled(false);
            this.mMenuRemoteLayout.setEnabled(false);
            this.mMenuRemoteBtn.setEnabled(false);
        }
        this.mMenuMainLayout = (LinearLayout) findViewById(C0000R.id.menu_main_layout);
        this.mMenuRemoteTextView = (TextView) findViewById(C0000R.id.remote_textview);
        this.mMenuRomoteLayout = (LinearLayout) findViewById(C0000R.id.remote_control_layout);
        this.mRemoteMode = 2;
        this.mMenuEndImg = (ImageView) findViewById(C0000R.id.menu_end_img);
        this.mMenuEndTxt = (TextView) findViewById(C0000R.id.menu_end_txt);
        this.mMenuEndLayout.setEnabled(false);
        this.mMenuEndBtn.setEnabled(false);
        this.mMenuEndImg.setEnabled(false);
        this.mMenuEndTxt.setEnabled(false);
        this.mMenuMainLayout.setOnLongClickListener(this.mBtnLongClickListener);
        this.mMenuPasueBtn.setOnLongClickListener(this.mBtnLongClickListener);
        this.mMenuPanWritingBtn.setOnLongClickListener(this.mBtnLongClickListener);
        this.mMenuEndBtn.setOnLongClickListener(this.mBtnLongClickListener);
        this.mMenuRemoteBtn.setOnLongClickListener(this.mBtnLongClickListener);
        this.mMenuRemoteMenuBtn.setOnLongClickListener(this.mBtnLongClickListener);
        this.mMenuRemoteHomeBtn.setOnLongClickListener(this.mBtnLongClickListener);
        this.mMenuRemoteBackBtn.setOnLongClickListener(this.mBtnLongClickListener);
        this.mMenuMainLayout.setOnTouchListener(this.mBtnTouchListener);
        this.mMenuPasueBtn.setOnTouchListener(this.mBtnTouchListener);
        this.mMenuPanWritingBtn.setOnTouchListener(this.mBtnTouchListener);
        this.mMenuEndBtn.setOnTouchListener(this.mBtnTouchListener);
        this.mMenuRemoteBtn.setOnTouchListener(this.mBtnTouchListener);
        this.mMenuRemoteMenuBtn.setOnTouchListener(this.mBtnTouchListener);
        this.mMenuRemoteHomeBtn.setOnTouchListener(this.mBtnTouchListener);
        this.mMenuRemoteBackBtn.setOnTouchListener(this.mBtnTouchListener);
    }

    public void setViewMode(final int mode) {
        this.mRemoteMode = mode;
        this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenSharePopupMenuLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ScreenSharePopupMenuLayout.this.logI("setViewMode:" + mode);
                Destination dest = MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination();
                if (mode != 3 || ScreenShareActivity.mIsOnPause) {
                    ScreenSharePopupMenuLayout.this.mMenuRemoteTextView.setVisibility(8);
                    ScreenSharePopupMenuLayout.this.mMenuRomoteLayout.setVisibility(8);
                } else {
                    ScreenSharePopupMenuLayout.this.mMenuRemoteTextView.setVisibility(0);
                    ScreenSharePopupMenuLayout.this.mMenuRomoteLayout.setVisibility(0);
                    if (dest != null && dest.getDestinationType() == 4) {
                        ScreenSharePopupMenuLayout.this.mMenuRomoteLayout.setEnabled(false);
                    }
                }
                if (mode == 3 || mode == 1) {
                    ScreenSharePopupMenuLayout.this.mMenuRemoteImg.setImageResource(C0000R.drawable.screenshare_main_popup_end_remotecontrol_selector);
                    ScreenSharePopupMenuLayout.this.mMenuRemoteBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_talkback_share_menu_remote_end));
                    ScreenSharePopupMenuLayout.this.mMenuRemoteTxt.setText(C0000R.string.screenshare_menu_end_remote_btn);
                    ScreenSharePopupMenuLayout.this.setTextViewEditor(ScreenSharePopupMenuLayout.this.mMenuRemoteTxt);
                } else {
                    ScreenSharePopupMenuLayout.this.mMenuRemoteImg.setImageResource(C0000R.drawable.screenshare_main_popup_remotecontrol_selector);
                    ScreenSharePopupMenuLayout.this.mMenuRemoteBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_menu_remote_btn));
                    ScreenSharePopupMenuLayout.this.mMenuRemoteTxt.setText(C0000R.string.screenshare_menu_remote_btn);
                    ScreenSharePopupMenuLayout.this.setTextViewEditor(ScreenSharePopupMenuLayout.this.mMenuRemoteTxt);
                }
                if (mode == 0) {
                    ScreenSharePopupMenuLayout.this.mMenuRemoteLayout.setEnabled(false);
                    ScreenSharePopupMenuLayout.this.mMenuRemoteLayout.setVisibility(8);
                    ScreenSharePopupMenuLayout.this.setLayoutWidth(ScreenSharePopupMenuLayout.this.mMenuPauseLayout, 113);
                    ScreenSharePopupMenuLayout.this.setLayoutWidth(ScreenSharePopupMenuLayout.this.mMenuPenWritingLayout, 114);
                    ScreenSharePopupMenuLayout.this.setLayoutWidth(ScreenSharePopupMenuLayout.this.mMenuEndLayout, 113);
                    return;
                }
                ScreenSharePopupMenuLayout.this.mMenuRemoteLayout.setEnabled(true);
                ScreenSharePopupMenuLayout.this.mMenuRemoteLayout.setVisibility(0);
                ScreenSharePopupMenuLayout.this.setLayoutWidth(ScreenSharePopupMenuLayout.this.mMenuPauseLayout, 85);
                ScreenSharePopupMenuLayout.this.setLayoutWidth(ScreenSharePopupMenuLayout.this.mMenuPenWritingLayout, 85);
                ScreenSharePopupMenuLayout.this.setLayoutWidth(ScreenSharePopupMenuLayout.this.mMenuEndLayout, 85);
                if (dest != null && dest.getDestinationType() == 4) {
                    ScreenSharePopupMenuLayout.this.mMenuRemoteLayout.setEnabled(false);
                }
            }
        });
    }

    public void setPause(int Pause) {
        logI("setPause:" + Pause);
        if (Pause == 1) {
            this.mMenuPauseTxt.setText(C0000R.string.screenshare_menu_restart);
            this.mMenuPauseImg.setImageResource(C0000R.drawable.screenshare_main_popup_restart_selector);
            this.mMenuPasueBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_menu_restart));
            this.mMenuRemoteTextView.setVisibility(8);
            this.mMenuRomoteLayout.setVisibility(8);
            return;
        }
        if (Pause == 2) {
            this.mMenuPauseTxt.setText(C0000R.string.screenshare_menu_restart);
            this.mMenuPauseImg.setImageResource(C0000R.drawable.screenshare_main_popup_restart_selector);
            this.mMenuPasueBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_menu_restart));
            this.mMenuRemoteTextView.setVisibility(8);
            this.mMenuRomoteLayout.setVisibility(8);
            return;
        }
        if (Pause == 0) {
            this.mMenuPauseTxt.setText(C0000R.string.screenshare_menu_pause);
            this.mMenuPauseImg.setImageResource(C0000R.drawable.screenshare_main_popup_pause_selector);
            this.mMenuPasueBtn.setContentDescription(MainApplication.mContext.getString(C0000R.string.screenshare_menu_pause));
            this.mMenuPauseLayout.setEnabled(true);
            Destination dest = MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination();
            if (dest != null && dest.getDestinationType() == 4) {
                this.mMenuPenWritingLayout.setEnabled(false);
            } else {
                this.mMenuPenWritingLayout.setEnabled(true);
            }
            if (ScreenShareActivity.mIsRemote == 1) {
                this.mMenuRemoteTextView.setVisibility(0);
                this.mMenuRomoteLayout.setVisibility(0);
            } else {
                this.mMenuRemoteTextView.setVisibility(8);
                this.mMenuRomoteLayout.setVisibility(8);
            }
            if (ScreenShareActivity.mInstance.mOtherPauseType == 1) {
                this.mMenuRemoteTextView.setVisibility(8);
                this.mMenuRomoteLayout.setVisibility(8);
            }
        }
    }

    public void setOtherPause(int pause) {
        logI("setOtherPause:" + pause);
        if (pause == 1 || pause == 2) {
            this.mMenuRemoteLayout.setEnabled(false);
            this.mMenuRemoteBtn.setEnabled(false);
            this.mMenuRemoteTextView.setVisibility(8);
            this.mMenuRomoteLayout.setVisibility(8);
            return;
        }
        if (pause == 0) {
            this.mMenuRemoteLayout.setEnabled(true);
            this.mMenuRemoteBtn.setEnabled(true);
            this.mMenuPauseLayout.setEnabled(true);
            this.mMenuPenWritingLayout.setEnabled(true);
            Destination dest = MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination();
            if (dest != null && dest.getDestinationType() == 4) {
                this.mMenuRemoteLayout.setEnabled(false);
                this.mMenuRemoteBtn.setEnabled(false);
                this.mMenuPenWritingLayout.setEnabled(false);
            }
            if (ScreenShareActivity.mIsRemote == 1 && ScreenShareActivity.mInstance.mPauseType == 0) {
                this.mMenuRemoteTextView.setVisibility(0);
                this.mMenuRomoteLayout.setVisibility(0);
            }
        }
    }

    public void setLayoutWidth(FrameLayout layout, int witdh) {
        int btnWidth = (int) (witdh * getResources().getDisplayMetrics().density);
        ViewGroup.LayoutParams layoutParams = layout.getLayoutParams();
        layoutParams.width = btnWidth;
        layout.setLayoutParams(layoutParams);
    }

    protected int initGetX() {
        if (this.f3wm == null) {
            this.f3wm = (WindowManager) getContext().getSystemService("window");
        }
        Display display = this.f3wm.getDefaultDisplay();
        Point disSize = new Point();
        display.getSize(disSize);
        return (disSize.x - ((int) (this.mMenuWidth * this.mContext.getResources().getDisplayMetrics().density))) / 2;
    }

    protected int initGetY() {
        int hei;
        if (this.f3wm == null) {
            this.f3wm = (WindowManager) getContext().getSystemService("window");
        }
        Display display = this.f3wm.getDefaultDisplay();
        Point disSize = new Point();
        display.getSize(disSize);
        logI("Density= " + this.mContext.getResources().getDisplayMetrics().density);
        if (this.mRemoteMode == 3) {
            hei = this.mMenuHeight2;
        } else {
            hei = this.mMenuHeight;
        }
        return disSize.y - ((int) (hei * this.mContext.getResources().getDisplayMetrics().density));
    }

    @Override // com.coolots.chaton.call.screenshare.activity.ScreenShareLayout
    public void show() {
        logE("show()");
        setPos();
        this.mMenuMainLayout.clearAnimation();
        super.show();
        Animation animation = AnimationUtils.loadAnimation(getContext(), C0000R.anim.screenshare_zoom_in);
        animation.reset();
        this.mMenuMainLayout.startAnimation(animation);
        this.mShow = true;
    }

    public int getMenuHeightDPI() {
        int curHeight = this.mMenuHeight;
        if (this.mRemoteMode == 3) {
            curHeight = this.mMenuHeight2;
        }
        return (int) (curHeight * this.mContext.getResources().getDisplayMetrics().density);
    }

    public void setMenuRotated() {
        this.isFirstPlace = true;
        this.isManualMove = false;
        logI("MENU SIZE = " + getWidth() + ", " + getHeight());
        setPos();
    }

    protected void setPos() {
        if (this.isFirstPlace || !this.isManualMove) {
            this.isFirstPlace = false;
            this.mScreenShareActivity.setMenuPos(initGetX(), initGetY());
        } else {
            this.mScreenShareActivity.setMenuPos(new int[2]);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasFocus) {
        logI("show Width :" + this.mMenuMainLayout.getWidth() + " Height: " + this.mMenuMainLayout.getHeight());
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setPos();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void dismiss(final int action) {
        if (this.mShow) {
            setEnabled(false);
            Animation animation = AnimationUtils.loadAnimation(getContext(), C0000R.anim.screenshare_zoom_out);
            animation.reset();
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenSharePopupMenuLayout.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation arg0) {
                    ScreenSharePopupMenuLayout.this.setVisibility(8);
                    if (action != 0) {
                        Message msg = ScreenSharePopupMenuLayout.this.mMenuBtnHandler.obtainMessage(action);
                        ScreenSharePopupMenuLayout.this.mMenuBtnHandler.sendMessage(msg);
                    }
                    ScreenSharePopupMenuLayout.this.mShow = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation arg0) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation arg0) {
                }
            });
            if (this.mMenuMainLayout != null) {
                this.mMenuMainLayout.clearAnimation();
                this.mMenuMainLayout.startAnimation(animation);
            }
        } else {
            super.dismiss();
        }
        this.mShow = false;
        this.mScreenShareActivity.setMainButtonContentDiscription(this.mShow);
    }

    private class MenuBtnHandler extends Handler {
        private MenuBtnHandler() {
        }

        /* synthetic */ MenuBtnHandler(ScreenSharePopupMenuLayout screenSharePopupMenuLayout, MenuBtnHandler menuBtnHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case C0000R.id.menu_pause_btn /* 2131493287 */:
                case C0000R.id.menu_pen_writing_btn /* 2131493291 */:
                case C0000R.id.menu_remote_btn /* 2131493295 */:
                case C0000R.id.menu_end_btn /* 2131493299 */:
                case C0000R.id.menu_main_remote_menu /* 2131493305 */:
                case C0000R.id.menu_main_remote_home /* 2131493309 */:
                case C0000R.id.menu_main_remote_back /* 2131493313 */:
                    ScreenSharePopupMenuLayout.this.onButtonEvent.onClickButtonEvent(msg.what);
                    break;
            }
        }
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

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
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
        if (this.mMenuRemoteMenuBtn != null) {
            this.mMenuRemoteMenuBtn.removeCallbacks(null);
            this.mMenuRemoteMenuBtn = null;
        }
        if (this.mMenuRemoteHomeBtn != null) {
            this.mMenuRemoteHomeBtn.removeCallbacks(null);
            this.mMenuRemoteHomeBtn = null;
        }
        if (this.mMenuRemoteBackBtn != null) {
            this.mMenuRemoteBackBtn.removeCallbacks(null);
            this.mMenuRemoteBackBtn = null;
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
        if (this.mMenuRemoteTextView != null) {
            this.mMenuRemoteTextView.removeCallbacks(null);
            this.mMenuRemoteTextView = null;
        }
        if (this.mMenuPauseLayout != null) {
            this.mMenuPauseLayout.removeAllViewsInLayout();
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
        if (this.mMenuMainLayout != null) {
            this.mMenuMainLayout.removeAllViewsInLayout();
            this.mMenuMainLayout = null;
        }
    }
}
