package com.samsung.android.sdk.pen.settingui;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.samsung.android.sdk.pen.SpenSettingEraserInfo;
import com.samsung.android.sdk.pen.SpenSettingViewInterface;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.IOException;

/* loaded from: classes.dex */
public class SpenSettingEraserLayout extends LinearLayout {
    protected static final int ERASER_SIZE_MAX = 99;
    protected static final int EXIT_BUTTON_HEIGHT = 36;
    protected static final int EXIT_BUTTON_WIDTH = 38;
    private static final int IB_ERASER_EXIT_ID = 12070901;
    private static final int IB_ERASER_SIZE_MINUS_ID = 12070903;
    private static final int IB_ERASER_SIZE_PLUS_ID = 12070902;
    protected static final int LINE_BUTTON_BOTTOM_MARGIN = 8;
    protected static final int LINE_BUTTON_HEIGHT = 19;
    protected static final int LINE_BUTTON_TOP_MARGIN = 9;
    protected static final int LINE_BUTTON_WIDTH = 1;
    private static final int REP_DELAY = 20;
    private static final String TAG = "settingui-settingEraser";
    protected static final int TITLE_LAYOUT_HEIGHT = 41;
    public static final int VIEW_MODE_NORMAL = 0;
    public static final int VIEW_MODE_SIZE = 2;
    public static final int VIEW_MODE_TITLE = 3;
    public static final int VIEW_MODE_TYPE = 1;
    private static final String bodyLeftPath = "snote_popup_bg_left";
    private static final String bodyRightPath = "snote_popup_bg_right";
    private static final String btnFocusPath = "snote_popup_btn_focus";
    private static final String btnNoramlPath = "snote_popup_btn_normal";
    private static final String btnPressPath = "snote_popup_btn_press";
    private static final String eraserPopupDrawPress = "snote_eraser_popup_draw_press";
    private static final String eraserPopupDrawUnselect = "snote_eraser_popup_draw";
    private static final String eraserPopupTextPress = "snote_eraser_popup_text_press";
    private static final String eraserPopupTextUnselect = "snote_eraser_popup_text";
    private static final String exitPath = "snote_popup_close";
    private static final String exitPressPath = "snote_popup_close_press";
    private static final String exitfocusPath = "snote_popup_close_focus";
    private static final String handelFocusPath = "progress_handle_focus";
    private static final String handelPath = "progress_handle_normal";
    private static final String handelPressPath = "progress_handle_press";
    private static final String linePath = "snote_popup_divider";
    private static final int mSdkVersion = Build.VERSION.SDK_INT;
    private static final String minusBgDimPath = "snote_popup_progress_btn_minus_dim";
    private static final String minusBgFocusPath = "snote_popup_progress_btn_minus_focus";
    private static final String minusBgPath = "snote_popup_progress_btn_minus_normal";
    private static final String minusBgPressPath = "snote_popup_progress_btn_minus_press";
    private static final String plusBgDimPath = "snote_popup_progress_btn_plus_dim";
    private static final String plusBgFocusPath = "snote_popup_progress_btn_plus_focus";
    private static final String plusBgPath = "snote_popup_progress_btn_plus_normal";
    private static final String plusBgPressPath = "snote_popup_progress_btn_plus_press";
    private static final String progressBgPath = "progress_bg";
    private static final String progressShadowPath = "progress_shadow";
    private static final String titleCenterPath = "snote_popup_title_center";
    private static final String titleLeftPath = "snote_popup_title_left";
    private static final String titleRightPath = "snote_popup_title_right";
    protected ActionListener mActionListener;
    private boolean mAutoDecrement;
    private boolean mAutoIncrement;
    protected View mBodyLayout;
    protected RelativeLayout mCanvasLayout;
    protected SpenSettingViewInterface mCanvasView;
    protected View mClearAllButton;
    private final View.OnClickListener mClearAllListener;
    protected Context mContext;
    protected int mCurrentEraserType;
    protected SPenImageUtil mDrawableImg;
    protected SpenSettingEraserInfo[] mEraserDataList;
    private final View.OnKeyListener mEraserKeyListener;
    protected EventListener mEraserListener;
    protected View mEraserMinusButton;
    protected View mEraserPlusButton;
    protected ViewGroup mEraserSizeButtonSeekbar;
    private final SeekBar.OnSeekBarChangeListener mEraserSizeListener;
    protected SeekBar mEraserSizeSeekBar;
    protected TextView mEraserSizeTextView;
    protected ImageButton mEraserType01;
    protected ImageButton mEraserType02;
    protected ViewGroup mEraserTypeLayout;
    private final View.OnClickListener mEraserTypeListner;
    protected View[] mEraserTypeView;
    protected View mExitButton;
    private final View.OnClickListener mExitButtonListener;
    protected boolean mFirstLongPress;
    protected GestureDetector mGestureDetector;
    private final GestureDetector.OnGestureListener mGestureListener;
    private SpenImageLoader mImageLoader;
    protected ImageView mIndicator;
    protected boolean mIsRotated;
    View.OnLayoutChangeListener mLayoutChangeListener;
    protected int mLeftMargin;
    private final View.OnLongClickListener mLongClickMinusButtonListener;
    private final View.OnLongClickListener mLongClickPlusButtonListener;
    private final View.OnKeyListener mMinusButtonKeyListener;
    private final View.OnClickListener mMinusButtonListener;
    protected Rect mMovableRect;
    protected boolean mMoveSettingLayout;
    protected boolean mNeedCalculateMargin;
    protected int[] mOldLocation;
    protected Rect mOldMovableRect;
    private final View.OnTouchListener mOnConsumedTouchListener;
    private final View.OnTouchListener mOnTouchListener;
    private final View.OnKeyListener mPlusButtonKeyListener;
    private final View.OnClickListener mPlusButtonListener;
    protected float mScale;
    protected SpenSettingEraserInfo mSettingInfo;
    protected ViewGroup mSettingSizeLayout;
    protected SPenTextUtil mStringUtil;
    protected View mTitleLayout;
    protected int mTopMargin;
    private final View.OnTouchListener mTouchMinusButtonListener;
    private final View.OnTouchListener mTouchPlusButtonListener;
    protected int mViewMode;
    protected ViewListener mVisibilityListener;
    protected int mXDelta;
    protected int mYDelta;
    private final Handler repeatUpdateHandler;
    protected boolean requestLayoutDisable;

    public interface ActionListener {
        void onMoved();
    }

    public interface EventListener {
        void onClearAll();
    }

    public interface ViewListener {
        void onVisibilityChanged(int i);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.requestLayoutDisable) {
            super.requestLayout();
        }
        this.requestLayoutDisable = false;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        Log.d(TAG, "onConfig eraser " + getVisibility());
        try {
            if (getVisibility() != 8) {
                this.mOldMovableRect.set(getMovableRect());
                getLocationOnScreen(this.mOldLocation);
                this.mIsRotated = true;
            }
        } catch (NullPointerException e) {
        }
        super.onConfigurationChanged(newConfig);
    }

    class RptUpdater implements Runnable {
        RptUpdater() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!SpenSettingEraserLayout.this.mAutoIncrement) {
                if (SpenSettingEraserLayout.this.mAutoDecrement) {
                    if (SpenSettingEraserLayout.this.mEraserSizeSeekBar.getProgress() != 0) {
                        SpenSettingEraserLayout.this.mEraserDataList[SpenSettingEraserLayout.this.mCurrentEraserType].size -= 1.0f;
                        SpenSettingEraserLayout.this.mEraserSizeSeekBar.incrementProgressBy(-1);
                        SpenSettingEraserLayout.this.mSettingInfo.size = SpenSettingEraserLayout.this.mEraserDataList[SpenSettingEraserLayout.this.mCurrentEraserType].size;
                    }
                    SpenSettingEraserLayout.this.repeatUpdateHandler.postDelayed(SpenSettingEraserLayout.this.new RptUpdater(), 20L);
                    return;
                }
                return;
            }
            if (SpenSettingEraserLayout.this.mEraserSizeSeekBar.getProgress() != SpenSettingEraserLayout.this.mEraserSizeSeekBar.getMax()) {
                SpenSettingEraserLayout.this.mEraserDataList[SpenSettingEraserLayout.this.mCurrentEraserType].size += 1.0f;
                SpenSettingEraserLayout.this.mEraserSizeSeekBar.incrementProgressBy(1);
                SpenSettingEraserLayout.this.mSettingInfo.size = SpenSettingEraserLayout.this.mEraserDataList[SpenSettingEraserLayout.this.mCurrentEraserType].size;
            }
            SpenSettingEraserLayout.this.repeatUpdateHandler.postDelayed(SpenSettingEraserLayout.this.new RptUpdater(), 20L);
        }
    }

    public SpenSettingEraserLayout(Context context, String customImagePath, RelativeLayout relativeLayout) {
        super(context);
        this.requestLayoutDisable = false;
        this.mScale = 1.0f;
        this.mCurrentEraserType = 0;
        this.mSettingInfo = null;
        this.mEraserDataList = null;
        this.mGestureDetector = null;
        this.mMoveSettingLayout = false;
        this.mNeedCalculateMargin = true;
        this.mFirstLongPress = true;
        this.mIsRotated = false;
        this.mImageLoader = null;
        this.mEraserListener = null;
        this.mActionListener = null;
        this.mVisibilityListener = null;
        this.mViewMode = 0;
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (SpenSettingEraserLayout.this.mGestureDetector == null || !SpenSettingEraserLayout.this.mGestureDetector.onTouchEvent(event)) {
                    int x = (int) event.getRawX();
                    int y = (int) event.getRawY();
                    switch (event.getAction()) {
                        case 1:
                            if (SpenSettingEraserLayout.this.mMoveSettingLayout && SpenSettingEraserLayout.this.mActionListener != null) {
                                SpenSettingEraserLayout.this.mActionListener.onMoved();
                                break;
                            }
                            break;
                        case 2:
                            if (SpenSettingEraserLayout.this.mMoveSettingLayout) {
                                int mMoveX = x - SpenSettingEraserLayout.this.mXDelta;
                                int mMoveY = y - SpenSettingEraserLayout.this.mYDelta;
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                if (mMoveX > (SpenSettingEraserLayout.this.mCanvasLayout.getWidth() - SpenSettingEraserLayout.this.getWidth()) - 2) {
                                    mMoveX = (SpenSettingEraserLayout.this.mCanvasLayout.getWidth() - SpenSettingEraserLayout.this.getWidth()) - 2;
                                }
                                if (mMoveY > SpenSettingEraserLayout.this.mMovableRect.height() - SpenSettingEraserLayout.this.getHeight()) {
                                    mMoveY = SpenSettingEraserLayout.this.mMovableRect.height() - SpenSettingEraserLayout.this.getHeight();
                                }
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                ViewGroup.MarginLayoutParams Params = (ViewGroup.MarginLayoutParams) SpenSettingEraserLayout.this.getLayoutParams();
                                Params.leftMargin = mMoveX;
                                Params.topMargin = mMoveY;
                                SpenSettingEraserLayout.this.setLayoutParams(Params);
                                break;
                            }
                            break;
                    }
                    SpenSettingEraserLayout.this.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
        };
        this.mOnConsumedTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpenSettingEraserLayout.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mClearAllListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingEraserLayout.this.mEraserListener != null) {
                    SpenSettingEraserLayout.this.mEraserListener.onClearAll();
                }
                SpenSettingEraserLayout.this.setVisibility(8);
            }
        };
        this.mGestureListener = new GestureDetector.OnGestureListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.4
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent arg0) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent arg0) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent event) {
                if (SpenSettingEraserLayout.this.mNeedCalculateMargin) {
                    int[] location = new int[2];
                    SpenSettingEraserLayout.this.mCanvasLayout.getLocationOnScreen(location);
                    SpenSettingEraserLayout.this.mLeftMargin = (int) ((event.getRawX() - location[0]) - event.getX());
                    SpenSettingEraserLayout.this.mTopMargin = (int) ((event.getRawY() - location[1]) - event.getY());
                    int[] rootLocation = new int[2];
                    SpenSettingEraserLayout.this.getRootView().getLocationOnScreen(rootLocation);
                    SpenSettingEraserLayout.this.mNeedCalculateMargin = false;
                }
                if (SpenSettingEraserLayout.this.mFirstLongPress) {
                    SpenSettingEraserLayout.this.mTitleLayout.performHapticFeedback(1);
                    SpenSettingEraserLayout.this.mFirstLongPress = false;
                }
                Rect r = SpenSettingEraserLayout.this.getMovableRect();
                SpenSettingEraserLayout.this.mMovableRect.set(r);
                SpenSettingEraserLayout.this.mMoveSettingLayout = true;
                SpenSettingEraserLayout.this.mIndicator.setVisibility(8);
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent event) {
                SpenSettingEraserLayout.this.mMovableRect.set(SpenSettingEraserLayout.this.getMovableRect());
                int x = (int) event.getRawX();
                int y = (int) event.getRawY();
                ViewGroup.MarginLayoutParams Params = (ViewGroup.MarginLayoutParams) SpenSettingEraserLayout.this.getLayoutParams();
                SpenSettingEraserLayout.this.mXDelta = x - Params.leftMargin;
                SpenSettingEraserLayout.this.mYDelta = y - Params.topMargin;
                return true;
            }
        };
        this.mExitButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingEraserLayout.this.setVisibility(8);
            }
        };
        this.mPlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingEraserLayout.this.mEraserSizeSeekBar.getProgress() != SpenSettingEraserLayout.this.mEraserSizeSeekBar.getMax()) {
                    SpenSettingEraserLayout.this.mEraserDataList[SpenSettingEraserLayout.this.mCurrentEraserType].size += 1.0f;
                    SpenSettingEraserLayout.this.mEraserSizeSeekBar.incrementProgressBy(1);
                    SpenSettingEraserLayout.this.mSettingInfo.size = SpenSettingEraserLayout.this.mEraserDataList[SpenSettingEraserLayout.this.mCurrentEraserType].size;
                }
            }
        };
        this.mMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingEraserLayout.this.mEraserSizeSeekBar.getProgress() != 0) {
                    SpenSettingEraserLayout.this.mEraserDataList[SpenSettingEraserLayout.this.mCurrentEraserType].size -= 1.0f;
                    SpenSettingEraserLayout.this.mEraserSizeSeekBar.incrementProgressBy(-1);
                    SpenSettingEraserLayout.this.mSettingInfo.size = SpenSettingEraserLayout.this.mEraserDataList[SpenSettingEraserLayout.this.mCurrentEraserType].size;
                }
            }
        };
        this.repeatUpdateHandler = new Handler();
        this.mAutoIncrement = false;
        this.mAutoDecrement = false;
        this.mLongClickPlusButtonListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.8
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingEraserLayout.this.mAutoIncrement = true;
                SpenSettingEraserLayout.this.mEraserPlusButton.setSelected(true);
                SpenSettingEraserLayout.this.repeatUpdateHandler.post(SpenSettingEraserLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mTouchPlusButtonListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingEraserLayout.this.mAutoIncrement) {
                    SpenSettingEraserLayout.this.mEraserPlusButton.setSelected(false);
                    SpenSettingEraserLayout.this.mAutoIncrement = false;
                }
                return false;
            }
        };
        this.mPlusButtonKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.10
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (SpenSettingEraserLayout.this.mEraserPlusButton.isSelected() && event.getAction() == 1) {
                            SpenSettingEraserLayout.this.mEraserPlusButton.setSelected(false);
                            SpenSettingEraserLayout.this.mAutoIncrement = false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        };
        this.mLongClickMinusButtonListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingEraserLayout.this.mAutoDecrement = true;
                SpenSettingEraserLayout.this.mEraserMinusButton.setSelected(true);
                SpenSettingEraserLayout.this.repeatUpdateHandler.post(SpenSettingEraserLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mTouchMinusButtonListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingEraserLayout.this.mAutoDecrement) {
                    SpenSettingEraserLayout.this.mEraserMinusButton.setSelected(false);
                    SpenSettingEraserLayout.this.mAutoDecrement = false;
                }
                return false;
            }
        };
        this.mMinusButtonKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.13
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (SpenSettingEraserLayout.this.mEraserMinusButton.isSelected() && event.getAction() == 1) {
                            SpenSettingEraserLayout.this.mEraserMinusButton.setSelected(false);
                            SpenSettingEraserLayout.this.mAutoDecrement = false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        };
        this.mEraserSizeListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.14
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SpenSettingEraserInfo info;
                if (SpenSettingEraserLayout.this.mEraserDataList[SpenSettingEraserLayout.this.mCurrentEraserType] != null) {
                    SpenSettingEraserLayout.this.mEraserDataList[SpenSettingEraserLayout.this.mCurrentEraserType].size = progress;
                }
                SpenSettingEraserLayout.this.requestLayoutDisable = fromUser;
                SpenSettingEraserLayout.this.mEraserSizeTextView.setText(String.valueOf(progress + 1));
                int seek_label_pos = SpenSettingEraserLayout.this.mDrawableImg.getIntValueAppliedDensity(26.0f) + ((int) (SpenSettingEraserLayout.this.mDrawableImg.getIntValueAppliedDensity(153.0f) * (progress / 100.0f)));
                if (progress + 1 < 10) {
                    seek_label_pos += SpenSettingEraserLayout.this.mDrawableImg.getIntValueAppliedDensity(4.0f);
                } else if (progress + 1 >= 100) {
                    seek_label_pos -= SpenSettingEraserLayout.this.mDrawableImg.getIntValueAppliedDensity(4.0f);
                }
                SpenSettingEraserLayout.this.mEraserSizeTextView.setX(seek_label_pos);
                SpenSettingEraserLayout.this.mEraserSizeTextView.setY(SpenSettingEraserLayout.this.mDrawableImg.getIntValueAppliedDensity(5.0f));
                if (SpenSettingEraserLayout.this.mCanvasView != null && (info = SpenSettingEraserLayout.this.mCanvasView.getEraserSettingInfo()) != null) {
                    SpenSettingEraserInfo spenSettingEraserInfo = SpenSettingEraserLayout.this.mSettingInfo;
                    float f = progress + 1;
                    info.size = f;
                    spenSettingEraserInfo.size = f;
                    SpenSettingEraserLayout.this.mCanvasView.setEraserSettingInfo(info);
                }
                SpenSettingEraserLayout.this.mEraserSizeSeekBar.setContentDescription(String.valueOf(SpenSettingEraserLayout.this.mEraserSizeTextView.getText().toString()) + "\u0000");
                if (SpenSettingEraserLayout.this.mEraserSizeSeekBar.getProgress() == SpenSettingEraserLayout.this.mEraserSizeSeekBar.getMax()) {
                    SpenSettingEraserLayout.this.mEraserPlusButton.setSelected(false);
                    SpenSettingEraserLayout.this.mEraserPlusButton.setEnabled(false);
                    if (SpenSettingEraserLayout.this.mAutoIncrement) {
                        SpenSettingEraserLayout.this.mAutoIncrement = false;
                    }
                } else {
                    SpenSettingEraserLayout.this.mEraserPlusButton.setEnabled(true);
                }
                if (SpenSettingEraserLayout.this.mEraserSizeSeekBar.getProgress() == 0) {
                    SpenSettingEraserLayout.this.mEraserMinusButton.setSelected(false);
                    SpenSettingEraserLayout.this.mEraserMinusButton.setEnabled(false);
                    if (SpenSettingEraserLayout.this.mAutoDecrement) {
                        SpenSettingEraserLayout.this.mAutoDecrement = false;
                        return;
                    }
                    return;
                }
                SpenSettingEraserLayout.this.mEraserMinusButton.setEnabled(true);
            }
        };
        this.mEraserTypeListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingEraserLayout.this.eraserTypeSetting(v);
            }
        };
        this.mEraserKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingEraserLayout.this.mEraserSizeSeekBar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingEraserLayout.this.mEraserSizeSeekBar.getProgress() != 0) {
                                SpenSettingEraserLayout.this.mEraserSizeSeekBar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingEraserLayout.this.mEraserSizeSeekBar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingEraserLayout.this.mEraserSizeSeekBar.getProgress() != SpenSettingEraserLayout.this.mEraserSizeSeekBar.getMax()) {
                                SpenSettingEraserLayout.this.mEraserSizeSeekBar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.mLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.17
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                try {
                    if (SpenSettingEraserLayout.this.getVisibility() != 8) {
                        SpenSettingEraserLayout.this.mMovableRect.set(SpenSettingEraserLayout.this.getMovableRect());
                        if (SpenSettingEraserLayout.this.mIsRotated) {
                            SpenSettingEraserLayout.this.rotatePosition();
                            SpenSettingEraserLayout.this.mIsRotated = false;
                        } else {
                            SpenSettingEraserLayout.this.checkPosition();
                        }
                        Handler handler = new Handler();
                        handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.17.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SpenSettingEraserLayout.this.requestLayout();
                            }
                        });
                    }
                } catch (NullPointerException e) {
                }
            }
        };
        this.requestLayoutDisable = false;
        this.mDrawableImg = new SPenImageUtil(context, customImagePath, 1.0f);
        this.mStringUtil = new SPenTextUtil(context);
        this.mImageLoader = new SpenImageLoader(this.mDrawableImg);
        this.mContext = context;
        this.mCanvasLayout = relativeLayout;
        this.mCanvasLayout.addOnLayoutChangeListener(this.mLayoutChangeListener);
        initView();
        setListener();
        this.mMovableRect = new Rect();
        this.mOldMovableRect = new Rect();
        this.mOldLocation = new int[2];
    }

    public SpenSettingEraserLayout(Context context, String customImagePath, RelativeLayout relativeLayout, float ratio) {
        super(context);
        this.requestLayoutDisable = false;
        this.mScale = 1.0f;
        this.mCurrentEraserType = 0;
        this.mSettingInfo = null;
        this.mEraserDataList = null;
        this.mGestureDetector = null;
        this.mMoveSettingLayout = false;
        this.mNeedCalculateMargin = true;
        this.mFirstLongPress = true;
        this.mIsRotated = false;
        this.mImageLoader = null;
        this.mEraserListener = null;
        this.mActionListener = null;
        this.mVisibilityListener = null;
        this.mViewMode = 0;
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (SpenSettingEraserLayout.this.mGestureDetector == null || !SpenSettingEraserLayout.this.mGestureDetector.onTouchEvent(event)) {
                    int x = (int) event.getRawX();
                    int y = (int) event.getRawY();
                    switch (event.getAction()) {
                        case 1:
                            if (SpenSettingEraserLayout.this.mMoveSettingLayout && SpenSettingEraserLayout.this.mActionListener != null) {
                                SpenSettingEraserLayout.this.mActionListener.onMoved();
                                break;
                            }
                            break;
                        case 2:
                            if (SpenSettingEraserLayout.this.mMoveSettingLayout) {
                                int mMoveX = x - SpenSettingEraserLayout.this.mXDelta;
                                int mMoveY = y - SpenSettingEraserLayout.this.mYDelta;
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                if (mMoveX > (SpenSettingEraserLayout.this.mCanvasLayout.getWidth() - SpenSettingEraserLayout.this.getWidth()) - 2) {
                                    mMoveX = (SpenSettingEraserLayout.this.mCanvasLayout.getWidth() - SpenSettingEraserLayout.this.getWidth()) - 2;
                                }
                                if (mMoveY > SpenSettingEraserLayout.this.mMovableRect.height() - SpenSettingEraserLayout.this.getHeight()) {
                                    mMoveY = SpenSettingEraserLayout.this.mMovableRect.height() - SpenSettingEraserLayout.this.getHeight();
                                }
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                ViewGroup.MarginLayoutParams Params = (ViewGroup.MarginLayoutParams) SpenSettingEraserLayout.this.getLayoutParams();
                                Params.leftMargin = mMoveX;
                                Params.topMargin = mMoveY;
                                SpenSettingEraserLayout.this.setLayoutParams(Params);
                                break;
                            }
                            break;
                    }
                    SpenSettingEraserLayout.this.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
        };
        this.mOnConsumedTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpenSettingEraserLayout.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mClearAllListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingEraserLayout.this.mEraserListener != null) {
                    SpenSettingEraserLayout.this.mEraserListener.onClearAll();
                }
                SpenSettingEraserLayout.this.setVisibility(8);
            }
        };
        this.mGestureListener = new GestureDetector.OnGestureListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.4
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent arg0) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent arg0) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent event) {
                if (SpenSettingEraserLayout.this.mNeedCalculateMargin) {
                    int[] location = new int[2];
                    SpenSettingEraserLayout.this.mCanvasLayout.getLocationOnScreen(location);
                    SpenSettingEraserLayout.this.mLeftMargin = (int) ((event.getRawX() - location[0]) - event.getX());
                    SpenSettingEraserLayout.this.mTopMargin = (int) ((event.getRawY() - location[1]) - event.getY());
                    int[] rootLocation = new int[2];
                    SpenSettingEraserLayout.this.getRootView().getLocationOnScreen(rootLocation);
                    SpenSettingEraserLayout.this.mNeedCalculateMargin = false;
                }
                if (SpenSettingEraserLayout.this.mFirstLongPress) {
                    SpenSettingEraserLayout.this.mTitleLayout.performHapticFeedback(1);
                    SpenSettingEraserLayout.this.mFirstLongPress = false;
                }
                Rect r = SpenSettingEraserLayout.this.getMovableRect();
                SpenSettingEraserLayout.this.mMovableRect.set(r);
                SpenSettingEraserLayout.this.mMoveSettingLayout = true;
                SpenSettingEraserLayout.this.mIndicator.setVisibility(8);
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent event) {
                SpenSettingEraserLayout.this.mMovableRect.set(SpenSettingEraserLayout.this.getMovableRect());
                int x = (int) event.getRawX();
                int y = (int) event.getRawY();
                ViewGroup.MarginLayoutParams Params = (ViewGroup.MarginLayoutParams) SpenSettingEraserLayout.this.getLayoutParams();
                SpenSettingEraserLayout.this.mXDelta = x - Params.leftMargin;
                SpenSettingEraserLayout.this.mYDelta = y - Params.topMargin;
                return true;
            }
        };
        this.mExitButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingEraserLayout.this.setVisibility(8);
            }
        };
        this.mPlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingEraserLayout.this.mEraserSizeSeekBar.getProgress() != SpenSettingEraserLayout.this.mEraserSizeSeekBar.getMax()) {
                    SpenSettingEraserLayout.this.mEraserDataList[SpenSettingEraserLayout.this.mCurrentEraserType].size += 1.0f;
                    SpenSettingEraserLayout.this.mEraserSizeSeekBar.incrementProgressBy(1);
                    SpenSettingEraserLayout.this.mSettingInfo.size = SpenSettingEraserLayout.this.mEraserDataList[SpenSettingEraserLayout.this.mCurrentEraserType].size;
                }
            }
        };
        this.mMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingEraserLayout.this.mEraserSizeSeekBar.getProgress() != 0) {
                    SpenSettingEraserLayout.this.mEraserDataList[SpenSettingEraserLayout.this.mCurrentEraserType].size -= 1.0f;
                    SpenSettingEraserLayout.this.mEraserSizeSeekBar.incrementProgressBy(-1);
                    SpenSettingEraserLayout.this.mSettingInfo.size = SpenSettingEraserLayout.this.mEraserDataList[SpenSettingEraserLayout.this.mCurrentEraserType].size;
                }
            }
        };
        this.repeatUpdateHandler = new Handler();
        this.mAutoIncrement = false;
        this.mAutoDecrement = false;
        this.mLongClickPlusButtonListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.8
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingEraserLayout.this.mAutoIncrement = true;
                SpenSettingEraserLayout.this.mEraserPlusButton.setSelected(true);
                SpenSettingEraserLayout.this.repeatUpdateHandler.post(SpenSettingEraserLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mTouchPlusButtonListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingEraserLayout.this.mAutoIncrement) {
                    SpenSettingEraserLayout.this.mEraserPlusButton.setSelected(false);
                    SpenSettingEraserLayout.this.mAutoIncrement = false;
                }
                return false;
            }
        };
        this.mPlusButtonKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.10
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (SpenSettingEraserLayout.this.mEraserPlusButton.isSelected() && event.getAction() == 1) {
                            SpenSettingEraserLayout.this.mEraserPlusButton.setSelected(false);
                            SpenSettingEraserLayout.this.mAutoIncrement = false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        };
        this.mLongClickMinusButtonListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingEraserLayout.this.mAutoDecrement = true;
                SpenSettingEraserLayout.this.mEraserMinusButton.setSelected(true);
                SpenSettingEraserLayout.this.repeatUpdateHandler.post(SpenSettingEraserLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mTouchMinusButtonListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingEraserLayout.this.mAutoDecrement) {
                    SpenSettingEraserLayout.this.mEraserMinusButton.setSelected(false);
                    SpenSettingEraserLayout.this.mAutoDecrement = false;
                }
                return false;
            }
        };
        this.mMinusButtonKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.13
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (SpenSettingEraserLayout.this.mEraserMinusButton.isSelected() && event.getAction() == 1) {
                            SpenSettingEraserLayout.this.mEraserMinusButton.setSelected(false);
                            SpenSettingEraserLayout.this.mAutoDecrement = false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        };
        this.mEraserSizeListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.14
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SpenSettingEraserInfo info;
                if (SpenSettingEraserLayout.this.mEraserDataList[SpenSettingEraserLayout.this.mCurrentEraserType] != null) {
                    SpenSettingEraserLayout.this.mEraserDataList[SpenSettingEraserLayout.this.mCurrentEraserType].size = progress;
                }
                SpenSettingEraserLayout.this.requestLayoutDisable = fromUser;
                SpenSettingEraserLayout.this.mEraserSizeTextView.setText(String.valueOf(progress + 1));
                int seek_label_pos = SpenSettingEraserLayout.this.mDrawableImg.getIntValueAppliedDensity(26.0f) + ((int) (SpenSettingEraserLayout.this.mDrawableImg.getIntValueAppliedDensity(153.0f) * (progress / 100.0f)));
                if (progress + 1 < 10) {
                    seek_label_pos += SpenSettingEraserLayout.this.mDrawableImg.getIntValueAppliedDensity(4.0f);
                } else if (progress + 1 >= 100) {
                    seek_label_pos -= SpenSettingEraserLayout.this.mDrawableImg.getIntValueAppliedDensity(4.0f);
                }
                SpenSettingEraserLayout.this.mEraserSizeTextView.setX(seek_label_pos);
                SpenSettingEraserLayout.this.mEraserSizeTextView.setY(SpenSettingEraserLayout.this.mDrawableImg.getIntValueAppliedDensity(5.0f));
                if (SpenSettingEraserLayout.this.mCanvasView != null && (info = SpenSettingEraserLayout.this.mCanvasView.getEraserSettingInfo()) != null) {
                    SpenSettingEraserInfo spenSettingEraserInfo = SpenSettingEraserLayout.this.mSettingInfo;
                    float f = progress + 1;
                    info.size = f;
                    spenSettingEraserInfo.size = f;
                    SpenSettingEraserLayout.this.mCanvasView.setEraserSettingInfo(info);
                }
                SpenSettingEraserLayout.this.mEraserSizeSeekBar.setContentDescription(String.valueOf(SpenSettingEraserLayout.this.mEraserSizeTextView.getText().toString()) + "\u0000");
                if (SpenSettingEraserLayout.this.mEraserSizeSeekBar.getProgress() == SpenSettingEraserLayout.this.mEraserSizeSeekBar.getMax()) {
                    SpenSettingEraserLayout.this.mEraserPlusButton.setSelected(false);
                    SpenSettingEraserLayout.this.mEraserPlusButton.setEnabled(false);
                    if (SpenSettingEraserLayout.this.mAutoIncrement) {
                        SpenSettingEraserLayout.this.mAutoIncrement = false;
                    }
                } else {
                    SpenSettingEraserLayout.this.mEraserPlusButton.setEnabled(true);
                }
                if (SpenSettingEraserLayout.this.mEraserSizeSeekBar.getProgress() == 0) {
                    SpenSettingEraserLayout.this.mEraserMinusButton.setSelected(false);
                    SpenSettingEraserLayout.this.mEraserMinusButton.setEnabled(false);
                    if (SpenSettingEraserLayout.this.mAutoDecrement) {
                        SpenSettingEraserLayout.this.mAutoDecrement = false;
                        return;
                    }
                    return;
                }
                SpenSettingEraserLayout.this.mEraserMinusButton.setEnabled(true);
            }
        };
        this.mEraserTypeListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingEraserLayout.this.eraserTypeSetting(v);
            }
        };
        this.mEraserKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingEraserLayout.this.mEraserSizeSeekBar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingEraserLayout.this.mEraserSizeSeekBar.getProgress() != 0) {
                                SpenSettingEraserLayout.this.mEraserSizeSeekBar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingEraserLayout.this.mEraserSizeSeekBar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingEraserLayout.this.mEraserSizeSeekBar.getProgress() != SpenSettingEraserLayout.this.mEraserSizeSeekBar.getMax()) {
                                SpenSettingEraserLayout.this.mEraserSizeSeekBar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.mLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.17
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                try {
                    if (SpenSettingEraserLayout.this.getVisibility() != 8) {
                        SpenSettingEraserLayout.this.mMovableRect.set(SpenSettingEraserLayout.this.getMovableRect());
                        if (SpenSettingEraserLayout.this.mIsRotated) {
                            SpenSettingEraserLayout.this.rotatePosition();
                            SpenSettingEraserLayout.this.mIsRotated = false;
                        } else {
                            SpenSettingEraserLayout.this.checkPosition();
                        }
                        Handler handler = new Handler();
                        handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.17.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SpenSettingEraserLayout.this.requestLayout();
                            }
                        });
                    }
                } catch (NullPointerException e) {
                }
            }
        };
        this.requestLayoutDisable = false;
        this.mScale = ratio;
        this.mDrawableImg = new SPenImageUtil(context, customImagePath, ratio);
        this.mStringUtil = new SPenTextUtil(context);
        this.mImageLoader = new SpenImageLoader(this.mDrawableImg);
        this.mContext = context;
        this.mCanvasLayout = relativeLayout;
        this.mCanvasLayout.addOnLayoutChangeListener(this.mLayoutChangeListener);
        initView();
        setListener();
        this.mMovableRect = new Rect();
        this.mOldMovableRect = new Rect();
        this.mOldLocation = new int[2];
    }

    private void totalLayout() {
        setLayoutParams(new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(228.0f), -2));
        setOrientation(1);
        this.mTitleLayout = titleLayout();
        this.mBodyLayout = bodyLayout();
        addView(this.mTitleLayout);
        addView(this.mBodyLayout);
    }

    private ViewGroup titleLayout() {
        RelativeLayout layout = new RelativeLayout(this.mContext);
        layout.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(41.0f)));
        this.mExitButton = exitButton();
        this.mExitButton.setId(IB_ERASER_EXIT_ID);
        layout.addView(titleBg());
        layout.addView(titleText());
        layout.addView(lineButton1());
        layout.addView(this.mExitButton);
        return layout;
    }

    private View titleBg() {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        ImageView titleLeft = new ImageView(this.mContext);
        RelativeLayout.LayoutParams titleLeftParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(114.3f), -1);
        titleLeftParam.alignWithParent = true;
        titleLeftParam.addRule(9);
        titleLeftParam.addRule(10);
        titleLeft.setLayoutParams(titleLeftParam);
        this.mIndicator = new ImageView(this.mContext);
        RelativeLayout.LayoutParams titleCenterParam = new RelativeLayout.LayoutParams(-2, -1);
        this.mIndicator.setLayoutParams(titleCenterParam);
        ImageView titleRight = new ImageView(this.mContext);
        RelativeLayout.LayoutParams titleRightParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(114.3f), -1);
        titleRightParam.alignWithParent = true;
        titleRightParam.addRule(11);
        titleRightParam.addRule(10);
        titleRight.setLayoutParams(titleRightParam);
        this.mImageLoader.addViewSetBackgroundImageLoad(titleLeft, titleLeftPath);
        this.mImageLoader.addViewSetBackgroundImageLoad(this.mIndicator, titleCenterPath);
        this.mImageLoader.addViewSetBackgroundImageLoad(titleRight, titleRightPath);
        relativeLayout.addView(this.mIndicator);
        relativeLayout.addView(titleLeft);
        relativeLayout.addView(titleRight);
        this.mIndicator.setVisibility(8);
        return relativeLayout;
    }

    private View titleText() throws Resources.NotFoundException {
        TextView titleView = new TextView(this.mContext);
        titleView.setLayoutParams(new FrameLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(41.0f)));
        titleView.setTextColor(-1);
        titleView.setGravity(19);
        titleView.setFocusable(true);
        String eraserText = this.mStringUtil.setString("string_eraser_settings");
        titleView.setSingleLine(true);
        titleView.setEllipsize(TextUtils.TruncateAt.END);
        titleView.setText(eraserText);
        if (eraserText.length() > 28) {
            titleView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(12.0f));
        } else if (eraserText.length() > 19) {
            titleView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(14.0f));
        } else {
            titleView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(16.0f));
        }
        titleView.setTypeface(Typeface.SANS_SERIF);
        titleView.setContentDescription(this.mStringUtil.setString("string_eraser_settings"));
        titleView.setPadding(this.mDrawableImg.getIntValueAppliedDensity(10.0f) + 9, 15, 0, 0);
        return titleView;
    }

    private ViewGroup bodyLayout() {
        RelativeLayout layout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layout.setLayoutParams(layoutParams);
        layout.addView(bodyBg());
        this.mClearAllButton = eraserSettingClearAllButton();
        this.mEraserTypeLayout = eraserTypeLayout();
        this.mSettingSizeLayout = eraserSizeLayout();
        this.mEraserTypeLayout.setVisibility(8);
        layout.addView(this.mEraserTypeLayout);
        layout.addView(this.mSettingSizeLayout);
        layout.addView(this.mClearAllButton);
        return layout;
    }

    private ViewGroup bodyBg() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.setLayoutParams(layoutParams);
        ImageView bodyLeft = new ImageView(this.mContext);
        RelativeLayout.LayoutParams bodyLeftParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(114.0f), this.mDrawableImg.getIntValueAppliedDensity(88.0f));
        bodyLeftParam.alignWithParent = true;
        bodyLeftParam.addRule(9);
        bodyLeftParam.addRule(10);
        bodyLeft.setLayoutParams(bodyLeftParam);
        ImageView bodyRight = new ImageView(this.mContext);
        RelativeLayout.LayoutParams bodyRightParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(114.0f), this.mDrawableImg.getIntValueAppliedDensity(88.0f));
        bodyRightParam.alignWithParent = true;
        bodyRightParam.addRule(11);
        bodyRightParam.addRule(10);
        bodyRight.setLayoutParams(bodyRightParam);
        this.mImageLoader.addViewSetBackgroundImageLoad(bodyLeft, bodyLeftPath);
        this.mImageLoader.addViewSetBackgroundImageLoad(bodyRight, bodyRightPath);
        linearLayout.setOnTouchListener(this.mOnConsumedTouchListener);
        linearLayout.addView(bodyLeft);
        linearLayout.addView(bodyRight);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getMovableRect() {
        int[] location = new int[2];
        Rect r = new Rect();
        this.mCanvasLayout.getLocationOnScreen(location);
        r.left = location[0] + this.mLeftMargin;
        r.top = location[1] + this.mTopMargin;
        r.right = location[0] + this.mCanvasLayout.getWidth();
        r.bottom = location[1] + this.mCanvasLayout.getHeight();
        return r;
    }

    public void close() {
        this.mCanvasView = null;
        this.mCanvasLayout = null;
        this.mContext = null;
        if (this.mDrawableImg != null) {
            this.mDrawableImg.unbindDrawables(this.mEraserSizeSeekBar);
            this.mEraserSizeSeekBar = null;
            this.mDrawableImg.unbindDrawables(this.mEraserSizeButtonSeekbar);
            this.mEraserSizeButtonSeekbar = null;
            this.mDrawableImg.unbindDrawables(this.mIndicator);
            this.mIndicator = null;
            this.mDrawableImg.unbindDrawables(this.mExitButton);
            this.mExitButton = null;
            this.mDrawableImg.unbindDrawables(this.mEraserPlusButton);
            this.mEraserPlusButton = null;
            this.mDrawableImg.unbindDrawables(this.mEraserMinusButton);
            this.mEraserMinusButton = null;
            this.mDrawableImg.unbindDrawables(this.mClearAllButton);
            this.mClearAllButton = null;
            this.mDrawableImg.unbindDrawables(this.mSettingSizeLayout);
            this.mSettingSizeLayout = null;
            this.mDrawableImg.unbindDrawables(this.mEraserType01);
            this.mEraserType01 = null;
            this.mDrawableImg.unbindDrawables(this.mEraserType02);
            this.mEraserType02 = null;
            if (this.mEraserTypeLayout != null) {
                for (int i = 0; i < this.mEraserTypeLayout.getChildCount(); i++) {
                    this.mDrawableImg.unbindDrawables(this.mEraserTypeView[i]);
                    this.mEraserTypeView[i] = null;
                }
            }
            this.mEraserTypeView = null;
            this.mDrawableImg.unbindDrawables(this.mEraserTypeLayout);
            this.mEraserTypeLayout = null;
            this.mDrawableImg.unbindDrawables(this.mTitleLayout);
            this.mTitleLayout = null;
            this.mDrawableImg.unbindDrawables(this.mBodyLayout);
            this.mBodyLayout = null;
            this.mSettingInfo = null;
            if (this.mEraserDataList != null) {
                this.mEraserDataList[0] = null;
                this.mEraserDataList[1] = null;
                this.mEraserDataList = null;
            }
            this.mGestureDetector = null;
            this.mEraserListener = null;
            this.mActionListener = null;
            this.mVisibilityListener = null;
            this.mDrawableImg.unbindDrawables(this);
            this.mDrawableImg = null;
            this.mImageLoader.close();
            this.mImageLoader = null;
        }
    }

    protected void initView() {
        totalLayout();
        LinearLayout eraserTypeViewGroup = (LinearLayout) this.mEraserTypeLayout;
        this.mEraserTypeView = new View[eraserTypeViewGroup.getChildCount()];
        for (int i = 0; i < eraserTypeViewGroup.getChildCount(); i++) {
            this.mEraserTypeView[i] = eraserTypeViewGroup.getChildAt(i);
        }
        this.mSettingInfo = new SpenSettingEraserInfo();
        if (this.mEraserDataList == null) {
            this.mEraserDataList = new SpenSettingEraserInfo[2];
            this.mEraserDataList[0] = new SpenSettingEraserInfo();
            this.mEraserDataList[1] = new SpenSettingEraserInfo();
        }
        setVisibility(8);
    }

    private void setListener() {
        if (this.mTitleLayout != null) {
            this.mTitleLayout.setOnTouchListener(this.mOnTouchListener);
        }
        this.mGestureDetector = new GestureDetector(this.mContext, this.mGestureListener);
        if (this.mExitButton != null) {
            this.mExitButton.setOnClickListener(this.mExitButtonListener);
        }
        if (this.mEraserMinusButton != null) {
            this.mEraserMinusButton.setOnClickListener(this.mMinusButtonListener);
            this.mEraserMinusButton.setOnLongClickListener(this.mLongClickMinusButtonListener);
            this.mEraserMinusButton.setOnTouchListener(this.mTouchMinusButtonListener);
            this.mEraserMinusButton.setOnKeyListener(this.mMinusButtonKeyListener);
        }
        if (this.mEraserPlusButton != null) {
            this.mEraserPlusButton.setOnClickListener(this.mPlusButtonListener);
            this.mEraserPlusButton.setOnLongClickListener(this.mLongClickPlusButtonListener);
            this.mEraserPlusButton.setOnTouchListener(this.mTouchPlusButtonListener);
            this.mEraserPlusButton.setOnKeyListener(this.mPlusButtonKeyListener);
        }
        if (this.mEraserSizeSeekBar != null) {
            this.mEraserSizeSeekBar.setOnSeekBarChangeListener(this.mEraserSizeListener);
        }
        if (this.mClearAllButton != null) {
            this.mClearAllButton.setOnClickListener(this.mClearAllListener);
        }
        if (this.mEraserTypeView != null) {
            for (int i = 0; i <= 1; i++) {
                if (this.mEraserTypeView[i] != null) {
                    this.mEraserTypeView[i].setOnClickListener(this.mEraserTypeListner);
                }
            }
        }
        if (this.mEraserSizeSeekBar != null) {
            this.mEraserSizeSeekBar.setOnKeyListener(this.mEraserKeyListener);
        }
    }

    public void setIndicatorPosition(int x) {
        if (x < 0) {
            this.mIndicator.setVisibility(8);
            this.mMoveSettingLayout = true;
            return;
        }
        this.mMoveSettingLayout = false;
        this.mIndicator.setVisibility(0);
        RelativeLayout.LayoutParams titleCenterParam = new RelativeLayout.LayoutParams(-2, -1);
        titleCenterParam.setMargins(x, 0, 0, 0);
        this.mIndicator.setLayoutParams(titleCenterParam);
    }

    public void setPosition(int x, int y) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) getLayoutParams();
        params.leftMargin = x;
        params.topMargin = y;
        setLayoutParams(params);
    }

    private View exitButton() {
        ImageButton exitButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams exitButtonParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(38.0f), this.mDrawableImg.getIntValueAppliedDensity(36.0f));
        exitButtonParams.addRule(11);
        exitButtonParams.topMargin = 15;
        exitButtonParams.rightMargin = 9;
        exitButton.setLayoutParams(exitButtonParams);
        exitButton.setFocusable(true);
        exitButton.setContentDescription(this.mStringUtil.setString("string_close"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(exitButton, exitPath, exitPressPath, exitfocusPath, 38, 36);
        return exitButton;
    }

    private View lineButton1() {
        ImageView lineView = new ImageView(this.mContext);
        RelativeLayout.LayoutParams presetButtonParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(1.0f), this.mDrawableImg.getIntValueAppliedDensity(19.0f));
        presetButtonParams.addRule(11);
        presetButtonParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(9.0f) + 15;
        presetButtonParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(38.0f) + 9;
        presetButtonParams.bottomMargin = this.mDrawableImg.getIntValueAppliedDensity(8.0f);
        lineView.setLayoutParams(presetButtonParams);
        this.mImageLoader.addViewSetBackgroundImageLoad(lineView, linePath);
        return lineView;
    }

    private ViewGroup eraserTypeLayout() {
        LinearLayout localLinearLayout = new LinearLayout(this.mContext);
        localLinearLayout.setOrientation(0);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLinearLayout.setLayoutParams(localLayoutParams);
        this.mEraserType01 = new ImageButton(this.mContext);
        this.mEraserType01.setImageDrawable(this.mDrawableImg.setDrawableImg(eraserPopupDrawUnselect));
        this.mEraserType01.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        SpenSettingEraserLayout.this.mEraserType01.setImageDrawable(SpenSettingEraserLayout.this.mDrawableImg.setDrawableImg(SpenSettingEraserLayout.eraserPopupDrawPress));
                        break;
                    case 1:
                        SpenSettingEraserLayout.this.mEraserType01.setImageDrawable(SpenSettingEraserLayout.this.mDrawableImg.setDrawableImg(SpenSettingEraserLayout.eraserPopupDrawUnselect));
                        break;
                }
                return false;
            }
        });
        localLinearLayout.addView(this.mEraserType01);
        this.mEraserType02 = new ImageButton(this.mContext);
        this.mEraserType02.setImageDrawable(this.mDrawableImg.setDrawableImg(eraserPopupTextUnselect));
        this.mEraserType02.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingEraserLayout.19
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        SpenSettingEraserLayout.this.mEraserType02.setImageDrawable(SpenSettingEraserLayout.this.mDrawableImg.setDrawableImg(SpenSettingEraserLayout.eraserPopupTextPress));
                        break;
                    case 1:
                        SpenSettingEraserLayout.this.mEraserType02.setImageDrawable(SpenSettingEraserLayout.this.mDrawableImg.setDrawableImg(SpenSettingEraserLayout.eraserPopupTextUnselect));
                        break;
                }
                return false;
            }
        });
        localLinearLayout.addView(this.mEraserType02);
        return localLinearLayout;
    }

    private ViewGroup eraserSizeLayout() {
        RelativeLayout eraserSettingSizeLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams eraserSettingSizeLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(46.0f));
        eraserSettingSizeLayoutParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(5.0f), this.mDrawableImg.getIntValueAppliedDensity(-2.0f), this.mDrawableImg.getIntValueAppliedDensity(5.0f), this.mDrawableImg.getIntValueAppliedDensity(8.0f));
        eraserSettingSizeLayout.setLayoutParams(eraserSettingSizeLayoutParams);
        this.mEraserSizeTextView = new TextView(this.mContext);
        this.mEraserSizeTextView.setTypeface(Typeface.SANS_SERIF, 1);
        this.mEraserSizeTextView.setTextColor(Color.rgb(86, 87, 91));
        this.mEraserSizeTextView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(12.0f));
        RelativeLayout.LayoutParams eraserSizeTextParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(50.0f), this.mDrawableImg.getIntValueAppliedDensity(13.0f));
        eraserSizeTextParam.addRule(4);
        this.mEraserSizeTextView.setLayoutParams(eraserSizeTextParam);
        eraserSettingSizeLayout.addView(this.mEraserSizeTextView);
        this.mEraserSizeButtonSeekbar = eraserSizeButtonSeekbar();
        eraserSettingSizeLayout.addView(this.mEraserSizeButtonSeekbar);
        return eraserSettingSizeLayout;
    }

    private SeekBar eraserSettingSizeSeekBar() throws Resources.NotFoundException, IOException {
        SeekBar seekBar = new SeekBar(this.mContext);
        RelativeLayout.LayoutParams seekBarParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(170.0f), this.mDrawableImg.getIntValueAppliedDensity(22.0f));
        seekBarParams.setMargins(0, 0, 0, 0);
        seekBarParams.alignWithParent = true;
        seekBarParams.addRule(14);
        seekBarParams.addRule(8);
        seekBar.setLayoutParams(seekBarParams);
        seekBar.setPadding(0, 0, 0, 0);
        seekBar.setMax(ERASER_SIZE_MAX);
        seekBar.setThumb(this.mDrawableImg.setDrawableSelectImg(handelPath, handelPressPath, handelFocusPath, 22, 22));
        seekBar.setThumbOffset(this.mDrawableImg.getIntValueAppliedDensity(1.0f));
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColor(0);
        localGradientDrawable.setCornerRadius(this.mDrawableImg.getIntValueAppliedDensity(4.5f));
        ClipDrawable localClipDrawable = new ClipDrawable(localGradientDrawable, 3, 1);
        Drawable bgDrawable = this.mDrawableImg.setDrawableImg(progressBgPath, 190, 9);
        Drawable shadowDrawable = this.mDrawableImg.setDrawableImg(progressShadowPath, 190, 9);
        InsetDrawable bgInsetDrawable = new InsetDrawable(bgDrawable, 0, 0, 0, 0);
        InsetDrawable shadowInsetDrawable = new InsetDrawable(shadowDrawable, 0, 0, 0, 0);
        LayerDrawable localLayerDrawable = new LayerDrawable(new Drawable[]{localClipDrawable, bgInsetDrawable, shadowInsetDrawable});
        seekBar.setProgressDrawable(localLayerDrawable);
        return seekBar;
    }

    private ViewGroup eraserSizeButtonSeekbar() {
        RelativeLayout eraserSettingSizeDisplayLayout = new RelativeLayout(this.mContext);
        this.mEraserPlusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams eraserPlusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(24.0f), this.mDrawableImg.getIntValueAppliedDensity(24.0f));
        eraserPlusImageParam.alignWithParent = true;
        eraserPlusImageParam.addRule(11);
        eraserPlusImageParam.addRule(8);
        this.mEraserPlusButton.setLayoutParams(eraserPlusImageParam);
        this.mEraserPlusButton.setContentDescription(this.mStringUtil.setString("string_plus"));
        if (mSdkVersion < 16) {
            this.mEraserPlusButton.setBackgroundDrawable(this.mDrawableImg.setDrawableDimImg(plusBgPath, plusBgPressPath, plusBgFocusPath, plusBgDimPath, 24, 24));
        } else {
            this.mEraserPlusButton.setBackground(this.mDrawableImg.setDrawableDimImg(plusBgPath, plusBgPressPath, plusBgFocusPath, plusBgDimPath, 24, 24));
        }
        this.mEraserMinusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams eraserMinusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(24.0f), this.mDrawableImg.getIntValueAppliedDensity(24.0f));
        eraserMinusImageParam.alignWithParent = true;
        eraserMinusImageParam.addRule(9);
        eraserMinusImageParam.addRule(8);
        this.mEraserMinusButton.setLayoutParams(eraserMinusImageParam);
        this.mEraserMinusButton.setContentDescription(this.mStringUtil.setString("string_minus"));
        if (mSdkVersion < 16) {
            this.mEraserMinusButton.setBackgroundDrawable(this.mDrawableImg.setDrawableDimImg(minusBgPath, minusBgPressPath, minusBgFocusPath, minusBgDimPath, 24, 24));
        } else {
            this.mEraserMinusButton.setBackground(this.mDrawableImg.setDrawableDimImg(minusBgPath, minusBgPressPath, minusBgFocusPath, minusBgDimPath, 24, 24));
        }
        this.mEraserSizeSeekBar = eraserSettingSizeSeekBar();
        eraserSettingSizeDisplayLayout.addView(this.mEraserSizeSeekBar);
        eraserSettingSizeDisplayLayout.addView(this.mEraserPlusButton);
        eraserSettingSizeDisplayLayout.addView(this.mEraserMinusButton);
        this.mEraserMinusButton.setId(IB_ERASER_SIZE_MINUS_ID);
        this.mEraserPlusButton.setId(IB_ERASER_SIZE_PLUS_ID);
        this.mEraserMinusButton.setNextFocusUpId(IB_ERASER_EXIT_ID);
        this.mEraserPlusButton.setNextFocusUpId(IB_ERASER_EXIT_ID);
        this.mEraserSizeSeekBar.setNextFocusUpId(IB_ERASER_EXIT_ID);
        this.mEraserSizeSeekBar.setNextFocusLeftId(IB_ERASER_SIZE_MINUS_ID);
        this.mEraserSizeSeekBar.setNextFocusRightId(IB_ERASER_SIZE_PLUS_ID);
        return eraserSettingSizeDisplayLayout;
    }

    private View eraserSettingClearAllButton() {
        Button clearAllButton = new Button(this.mContext);
        RelativeLayout.LayoutParams clearAllButtonParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(33.0f));
        clearAllButtonParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(10.0f), this.mDrawableImg.getIntValueAppliedDensity(51.0f), this.mDrawableImg.getIntValueAppliedDensity(10.0f), 0);
        clearAllButton.setLayoutParams(clearAllButtonParams);
        clearAllButton.setFocusable(true);
        clearAllButton.setText(this.mStringUtil.setString("string_clear_all"));
        int[] arrayOfStates1 = {R.attr.state_pressed};
        int[][] arrayOfStates = {arrayOfStates1, new int[0]};
        int[] textColor = {-1, -16777216};
        clearAllButton.setTextColor(new ColorStateList(arrayOfStates, textColor));
        clearAllButton.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(14.0f));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(clearAllButton, btnNoramlPath, btnPressPath, btnFocusPath);
        return clearAllButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eraserTypeSetting(View selectedView) {
        SpenSettingEraserInfo info;
        SpenSettingEraserInfo info2;
        for (int i = 0; i < this.mEraserTypeView.length; i++) {
            if (this.mEraserTypeView[i] != null) {
                this.mEraserTypeView[i].setSelected(false);
                if (selectedView.equals(this.mEraserTypeView[i])) {
                    this.mEraserTypeView[i].invalidate();
                    this.mCurrentEraserType = i;
                    if (i == 0) {
                        this.mCurrentEraserType = 0;
                    } else if (i == 1) {
                        this.mCurrentEraserType = 1;
                    }
                    switch (i) {
                        case 0:
                            if (this.mCanvasView != null && (info2 = this.mCanvasView.getEraserSettingInfo()) != null) {
                                info2.type = 0;
                                this.mCanvasView.setEraserSettingInfo(info2);
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if (this.mCanvasView != null && (info = this.mCanvasView.getEraserSettingInfo()) != null) {
                                info.type = 1;
                                this.mCanvasView.setEraserSettingInfo(info);
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
        }
        selectedView.setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rotatePosition() {
        Log.v(TAG, "==== SettingEraser ====");
        Log.i(TAG, "old  = " + this.mOldMovableRect.left + ", " + this.mOldMovableRect.top + ", " + this.mOldMovableRect.right + ", " + this.mOldMovableRect.bottom);
        Log.e(TAG, "new  = " + this.mMovableRect.left + ", " + this.mMovableRect.top + ", " + this.mMovableRect.right + ", " + this.mMovableRect.bottom);
        Rect r = new Rect();
        r.left = this.mOldLocation[0];
        r.top = this.mOldLocation[1];
        r.right = r.left + getWidth();
        r.bottom = r.top + getHeight();
        Log.d(TAG, "view = " + r.left + ", " + r.top + ", " + r.right + ", " + r.bottom);
        float left = r.left - this.mOldMovableRect.left;
        float right = this.mOldMovableRect.right - r.right;
        float top = r.top - this.mOldMovableRect.top;
        float bottom = this.mOldMovableRect.bottom - r.bottom;
        float hRatio = left / (left + right);
        float vRatio = top / (top + bottom);
        Log.w(TAG, "left :" + left + ", right :" + right);
        Log.w(TAG, "top :" + top + ", bottom :" + bottom);
        Log.v(TAG, "hRatio = " + hRatio + ", vRatio = " + vRatio);
        if (hRatio > 0.99f) {
            hRatio = 1.0f;
        } else if (hRatio < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            hRatio = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        if (vRatio > 0.99f) {
            vRatio = 1.0f;
        } else if (vRatio < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            vRatio = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) getLayoutParams();
        if (r.width() < this.mMovableRect.width()) {
            params.leftMargin = Math.round((this.mMovableRect.width() - r.width()) * hRatio);
        } else {
            params.leftMargin = 0;
        }
        if (r.height() < this.mMovableRect.height()) {
            params.topMargin = Math.round((this.mMovableRect.height() - r.height()) * vRatio);
        } else {
            params.topMargin = 0;
        }
        Log.e(TAG, "lMargin = " + params.leftMargin + ", tMargin = " + params.topMargin);
        setLayoutParams(params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPosition() {
        int[] location = new int[2];
        int minWidth = this.mDrawableImg.getIntValueAppliedDensity(228.0f);
        int minHeight = this.mDrawableImg.getIntValueAppliedDensity(129.0f);
        getLocationOnScreen(location);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) getLayoutParams();
        if (location[0] < this.mMovableRect.left) {
            params.leftMargin = 0;
        }
        if (location[1] < this.mMovableRect.top) {
            params.topMargin = 0;
        }
        if (this.mMovableRect.right - location[0] < minWidth) {
            params.leftMargin = this.mMovableRect.width() - minWidth;
            if (params.leftMargin < 0) {
                params.leftMargin = 0;
            }
        }
        if (this.mMovableRect.bottom - location[1] < minHeight) {
            params.topMargin = this.mMovableRect.height() - minHeight;
            if (params.topMargin < 0) {
                params.topMargin = 0;
            }
        }
        setLayoutParams(params);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        if (changedView == this) {
            try {
                if (this.mVisibilityListener != null) {
                    this.mVisibilityListener.onVisibilityChanged(visibility);
                }
            } catch (NullPointerException e) {
            }
        }
        if (changedView == this && visibility == 0) {
            int[] location = new int[2];
            getLocationOnScreen(location);
            if (this.mNeedCalculateMargin) {
                int[] parentLocation = new int[2];
                this.mCanvasLayout.getLocationOnScreen(parentLocation);
                this.mLeftMargin = location[0] - parentLocation[0];
                this.mTopMargin = location[1] - parentLocation[1];
                int[] rootLocation = new int[2];
                getRootView().getLocationOnScreen(rootLocation);
                this.mNeedCalculateMargin = false;
            }
            this.mMovableRect.set(getMovableRect());
            if (!this.mMovableRect.contains(new Rect(location[0], location[1], location[0] + getWidth(), location[1] + getHeight()))) {
                checkPosition();
            }
        }
        super.onVisibilityChanged(changedView, visibility);
    }

    public int getViewMode() {
        return this.mViewMode;
    }

    public SpenSettingEraserInfo getInfo() {
        return this.mSettingInfo;
    }

    public void setViewMode(int viewMode) {
        this.mViewMode = viewMode;
        boolean tempRequestLayoutDisable = this.requestLayoutDisable;
        this.requestLayoutDisable = false;
        if (this.mViewMode == 0) {
            this.mBodyLayout.setVisibility(0);
            this.mEraserTypeLayout.setVisibility(8);
            this.mSettingSizeLayout.setVisibility(0);
            this.mClearAllButton.setVisibility(0);
        } else if (this.mViewMode == 1) {
            this.mBodyLayout.setVisibility(0);
            this.mEraserTypeLayout.setVisibility(0);
            this.mClearAllButton.setVisibility(8);
            this.mSettingSizeLayout.setVisibility(8);
        } else if (this.mViewMode == 2) {
            this.mBodyLayout.setVisibility(0);
            this.mEraserTypeLayout.setVisibility(8);
            this.mClearAllButton.setVisibility(8);
            this.mSettingSizeLayout.setVisibility(0);
        } else if (this.mViewMode == 3) {
            this.mBodyLayout.setVisibility(8);
            this.mTitleLayout.setVisibility(0);
        } else {
            this.mViewMode = 0;
            this.mBodyLayout.setVisibility(0);
            this.mEraserTypeLayout.setVisibility(8);
            this.mSettingSizeLayout.setVisibility(0);
            this.mClearAllButton.setVisibility(0);
        }
        this.requestLayoutDisable = tempRequestLayoutDisable;
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        if (visibility == 0 && !this.mImageLoader.mLoaded) {
            this.mImageLoader.loadImage();
        }
        super.setVisibility(visibility);
    }

    public void setCanvasView(SpenSettingViewInterface canvasView) {
        if (canvasView != null) {
            this.mCanvasView = canvasView;
        }
    }

    public void setInfo(SpenSettingEraserInfo settingEraserInfo) {
        if (settingEraserInfo != null) {
            this.mCurrentEraserType = settingEraserInfo.type;
            this.mEraserDataList[this.mCurrentEraserType].size = settingEraserInfo.size;
            this.mEraserSizeSeekBar.setProgress(((int) settingEraserInfo.size) - 1);
            this.mSettingInfo.size = settingEraserInfo.size;
            this.mSettingInfo.type = settingEraserInfo.type;
        }
    }

    public void setEraserInfoList(SpenSettingEraserInfo[] list) {
        if (list != null) {
            this.mEraserDataList = list;
        }
    }

    public void setEraserListener(EventListener listener) {
        if (listener != null) {
            this.mEraserListener = listener;
        }
    }

    public void setActionListener(ActionListener listener) {
        if (listener != null) {
            this.mActionListener = listener;
        }
    }

    public void setVisibilityChangedListener(ViewListener listener) {
        if (listener != null) {
            this.mVisibilityListener = listener;
        }
    }
}
