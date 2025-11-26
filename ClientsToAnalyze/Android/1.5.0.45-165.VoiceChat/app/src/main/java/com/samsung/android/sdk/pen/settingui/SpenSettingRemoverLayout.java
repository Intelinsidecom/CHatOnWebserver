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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingViewInterface;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.IOException;

/* loaded from: classes.dex */
public class SpenSettingRemoverLayout extends LinearLayout {
    protected static final int ERASER_PROGRESS_MAX = 9;
    protected static final int ERASER_SIZE_MAX = 10;
    protected static final int EXIT_BUTTON_HEIGHT = 36;
    protected static final int EXIT_BUTTON_WIDTH = 38;
    private static final int IB_REMOVER_EXIT_ID = 12070801;
    private static final int IB_REMOVER_SIZE_MINUS_ID = 12070803;
    private static final int IB_REMOVER_SIZE_PLUS_ID = 12070802;
    protected static final int LINE_BUTTON_BOTTOM_MARGIN = 8;
    protected static final int LINE_BUTTON_HEIGHT = 19;
    protected static final int LINE_BUTTON_TOP_MARGIN = 9;
    protected static final int LINE_BUTTON_WIDTH = 1;
    private static final int REP_DELAY = 20;
    private static final String TAG = "settingui-settingRemover";
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
    private static final String cutterPopupDrawPress = "snote_eraser_popup_draw_press";
    private static final String cutterPopupDrawUnselect = "snote_eraser_popup_draw";
    private static final String cutterPopupTextPress = "snote_eraser_popup_text_press";
    private static final String cutterPopupTextUnselect = "snote_eraser_popup_text";
    private static final String exitPath = "snote_popup_close";
    private static final String exitPressPath = "snote_popup_close_press";
    private static final String exitfocusPath = "snote_popup_close_focus";
    private static final String handelFocusPath = "progress_handle_focus";
    private static final String handelPath = "progress_handle_normal";
    private static final String handelPressPath = "progress_handle_press";
    private static final String lineDivider = "snote_popup_line";
    private static final String linePath = "snote_popup_divider";
    protected static final String mDefaultPath = "";
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
    protected int mCanvasSize;
    protected SpenSettingViewInterface mCanvasView;
    private final CompoundButton.OnCheckedChangeListener mCheckedChangeListener;
    protected View mClearAllButton;
    private View.OnClickListener mClearAllListener;
    protected Context mContext;
    protected int mCurrentCutterType;
    protected SpenSettingRemoverInfo[] mCutterDataList;
    private View.OnKeyListener mCutterKeyListener;
    protected EventListener mCutterListener;
    protected View mCutterMinusButton;
    protected View mCutterPlusButton;
    protected ViewGroup mCutterSizeButton;
    private SeekBar.OnSeekBarChangeListener mCutterSizeListener;
    protected SeekBar mCutterSizeSeekBar;
    protected ImageButton mCutterType01;
    protected ImageButton mCutterType02;
    protected View mCutterTypeChekBox;
    protected ViewGroup mCutterTypeLayout;
    private View.OnClickListener mCutterTypeListner;
    protected View[] mCutterTypeView;
    protected SPenImageUtil mDrawableImg;
    protected TextView mEraserSizeTextView;
    protected View mExitButton;
    private View.OnClickListener mExitButtonListener;
    protected boolean mFirstLongPress;
    protected GestureDetector mGestureDetector;
    private GestureDetector.OnGestureListener mGestureListener;
    private SpenImageLoader mImageLoader;
    protected ImageView mIndicator;
    protected boolean mIsRotated;
    View.OnLayoutChangeListener mLayoutChangeListener;
    protected int mLeftMargin;
    private View.OnLongClickListener mLongClickMinusButtonListener;
    private View.OnLongClickListener mLongClickPlusButtonListener;
    private final View.OnKeyListener mMinusButtonKeyListener;
    private View.OnClickListener mMinusButtonListener;
    protected Rect mMovableRect;
    protected boolean mMoveSettingLayout;
    protected boolean mNeedCalculateMargin;
    protected int[] mOldLocation;
    protected Rect mOldMovableRect;
    private View.OnTouchListener mOnConsumedTouchListener;
    private View.OnTouchListener mOnTouchListener;
    private final View.OnKeyListener mPlusButtonKeyListener;
    private View.OnClickListener mPlusButtonListener;
    protected float mScale;
    protected SpenSettingRemoverInfo mSettingInfo;
    protected ViewGroup mSettingSizeLayout;
    protected SPenTextUtil mStringUtil;
    protected View mTitleLayout;
    protected int mTopMargin;
    private View.OnTouchListener mTouchMinusButtonListener;
    private View.OnTouchListener mTouchPlusButtonListener;
    protected int mViewMode;
    protected ViewListener mVisibilityListener;
    protected int mXDelta;
    protected int mYDelta;
    private Handler repeatUpdateHandler;
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
        Log.d(TAG, "onConfig remover " + getVisibility());
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
            try {
                if (!SpenSettingRemoverLayout.this.mAutoIncrement) {
                    if (SpenSettingRemoverLayout.this.mAutoDecrement) {
                        if (SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getProgress() != 0) {
                            SpenSettingRemoverLayout.this.mCutterDataList[SpenSettingRemoverLayout.this.mCurrentCutterType].size -= (SpenSettingRemoverLayout.this.mCanvasSize / 1080.0f) * 1.0f;
                            SpenSettingRemoverLayout.this.mCutterSizeSeekBar.incrementProgressBy(-1);
                            SpenSettingRemoverLayout.this.mSettingInfo.size = SpenSettingRemoverLayout.this.mCutterDataList[SpenSettingRemoverLayout.this.mCurrentCutterType].size;
                        }
                        SpenSettingRemoverLayout.this.repeatUpdateHandler.postDelayed(SpenSettingRemoverLayout.this.new RptUpdater(), 20L);
                        return;
                    }
                    return;
                }
                if (SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getProgress() != SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getMax()) {
                    SpenSettingRemoverLayout.this.mCutterDataList[SpenSettingRemoverLayout.this.mCurrentCutterType].size += (SpenSettingRemoverLayout.this.mCanvasSize / 1080.0f) * 1.0f;
                    SpenSettingRemoverLayout.this.mCutterSizeSeekBar.incrementProgressBy(1);
                    SpenSettingRemoverLayout.this.mSettingInfo.size = SpenSettingRemoverLayout.this.mCutterDataList[SpenSettingRemoverLayout.this.mCurrentCutterType].size;
                }
                SpenSettingRemoverLayout.this.repeatUpdateHandler.postDelayed(SpenSettingRemoverLayout.this.new RptUpdater(), 20L);
            } catch (NullPointerException e) {
            }
        }
    }

    public SpenSettingRemoverLayout(Context context, String customImagePath, RelativeLayout relativeLayout) {
        super(context);
        this.requestLayoutDisable = false;
        this.mScale = 1.0f;
        this.mCanvasSize = 1080;
        this.mCurrentCutterType = 0;
        this.mSettingInfo = null;
        this.mCutterDataList = null;
        this.mGestureDetector = null;
        this.mMoveSettingLayout = false;
        this.mNeedCalculateMargin = true;
        this.mFirstLongPress = true;
        this.mIsRotated = false;
        this.mImageLoader = null;
        this.mCutterListener = null;
        this.mActionListener = null;
        this.mVisibilityListener = null;
        this.mViewMode = 0;
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (SpenSettingRemoverLayout.this.mGestureDetector == null || !SpenSettingRemoverLayout.this.mGestureDetector.onTouchEvent(event)) {
                    int x = (int) event.getRawX();
                    int y = (int) event.getRawY();
                    switch (event.getAction()) {
                        case 1:
                            if (SpenSettingRemoverLayout.this.mMoveSettingLayout && SpenSettingRemoverLayout.this.mActionListener != null) {
                                SpenSettingRemoverLayout.this.mActionListener.onMoved();
                                break;
                            }
                            break;
                        case 2:
                            if (SpenSettingRemoverLayout.this.mMoveSettingLayout) {
                                int mMoveX = x - SpenSettingRemoverLayout.this.mXDelta;
                                int mMoveY = y - SpenSettingRemoverLayout.this.mYDelta;
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                if (mMoveX > (SpenSettingRemoverLayout.this.mCanvasLayout.getWidth() - SpenSettingRemoverLayout.this.getWidth()) - 2) {
                                    mMoveX = (SpenSettingRemoverLayout.this.mCanvasLayout.getWidth() - SpenSettingRemoverLayout.this.getWidth()) - 2;
                                }
                                if (mMoveY > SpenSettingRemoverLayout.this.mMovableRect.height() - SpenSettingRemoverLayout.this.getHeight()) {
                                    mMoveY = SpenSettingRemoverLayout.this.mMovableRect.height() - SpenSettingRemoverLayout.this.getHeight();
                                }
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                ViewGroup.MarginLayoutParams Params = (ViewGroup.MarginLayoutParams) SpenSettingRemoverLayout.this.getLayoutParams();
                                Params.leftMargin = mMoveX;
                                Params.topMargin = mMoveY;
                                SpenSettingRemoverLayout.this.setLayoutParams(Params);
                                break;
                            }
                            break;
                    }
                    SpenSettingRemoverLayout.this.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
        };
        this.mOnConsumedTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpenSettingRemoverLayout.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mClearAllListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingRemoverLayout.this.mCutterListener != null) {
                    SpenSettingRemoverLayout.this.mCutterListener.onClearAll();
                }
                SpenSettingRemoverLayout.this.setVisibility(8);
            }
        };
        this.mCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SpenSettingRemoverInfo info;
                if (SpenSettingRemoverLayout.this.mCanvasView != null && (info = SpenSettingRemoverLayout.this.mCanvasView.getRemoverSettingInfo()) != null) {
                    if (isChecked) {
                        SpenSettingRemoverInfo spenSettingRemoverInfo = SpenSettingRemoverLayout.this.mSettingInfo;
                        info.type = 1;
                        spenSettingRemoverInfo.type = 1;
                        SpenSettingRemoverLayout.this.setEnableSizeSeekbar(false);
                        SpenSettingRemoverLayout.this.playSoundEffect(0);
                    } else {
                        SpenSettingRemoverInfo spenSettingRemoverInfo2 = SpenSettingRemoverLayout.this.mSettingInfo;
                        info.type = 0;
                        spenSettingRemoverInfo2.type = 0;
                        SpenSettingRemoverLayout.this.setEnableSizeSeekbar(true);
                        SpenSettingRemoverLayout.this.playSoundEffect(0);
                    }
                    SpenSettingRemoverLayout.this.mCanvasView.setRemoverSettingInfo(info);
                }
            }
        };
        this.mGestureListener = new GestureDetector.OnGestureListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.5
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
                if (SpenSettingRemoverLayout.this.mNeedCalculateMargin) {
                    int[] location = new int[2];
                    SpenSettingRemoverLayout.this.mCanvasLayout.getLocationOnScreen(location);
                    SpenSettingRemoverLayout.this.mLeftMargin = (int) ((event.getRawX() - location[0]) - event.getX());
                    SpenSettingRemoverLayout.this.mTopMargin = (int) ((event.getRawY() - location[1]) - event.getY());
                    int[] rootLocation = new int[2];
                    SpenSettingRemoverLayout.this.getRootView().getLocationOnScreen(rootLocation);
                    SpenSettingRemoverLayout.this.mNeedCalculateMargin = false;
                }
                if (SpenSettingRemoverLayout.this.mFirstLongPress) {
                    SpenSettingRemoverLayout.this.mTitleLayout.performHapticFeedback(1);
                    SpenSettingRemoverLayout.this.mFirstLongPress = false;
                }
                Rect r = SpenSettingRemoverLayout.this.getMovableRect();
                SpenSettingRemoverLayout.this.mMovableRect.set(r);
                SpenSettingRemoverLayout.this.mMoveSettingLayout = true;
                SpenSettingRemoverLayout.this.mIndicator.setVisibility(8);
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent event) {
                SpenSettingRemoverLayout.this.mMovableRect.set(SpenSettingRemoverLayout.this.getMovableRect());
                int x = (int) event.getRawX();
                int y = (int) event.getRawY();
                ViewGroup.MarginLayoutParams Params = (ViewGroup.MarginLayoutParams) SpenSettingRemoverLayout.this.getLayoutParams();
                SpenSettingRemoverLayout.this.mXDelta = x - Params.leftMargin;
                SpenSettingRemoverLayout.this.mYDelta = y - Params.topMargin;
                return true;
            }
        };
        this.mExitButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingRemoverLayout.this.setVisibility(8);
            }
        };
        this.mPlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getProgress() != SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getMax()) {
                    SpenSettingRemoverLayout.this.mCutterDataList[SpenSettingRemoverLayout.this.mCurrentCutterType].size += 1.0f * (SpenSettingRemoverLayout.this.mCanvasSize / 1080.0f);
                    SpenSettingRemoverLayout.this.mCutterSizeSeekBar.incrementProgressBy(1);
                    SpenSettingRemoverLayout.this.mSettingInfo.size = SpenSettingRemoverLayout.this.mCutterDataList[SpenSettingRemoverLayout.this.mCurrentCutterType].size;
                }
            }
        };
        this.mMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getProgress() != 0) {
                    SpenSettingRemoverLayout.this.mCutterDataList[SpenSettingRemoverLayout.this.mCurrentCutterType].size -= 1.0f * (SpenSettingRemoverLayout.this.mCanvasSize / 1080.0f);
                    SpenSettingRemoverLayout.this.mCutterSizeSeekBar.incrementProgressBy(-1);
                    SpenSettingRemoverLayout.this.mSettingInfo.size = SpenSettingRemoverLayout.this.mCutterDataList[SpenSettingRemoverLayout.this.mCurrentCutterType].size;
                }
            }
        };
        this.repeatUpdateHandler = new Handler();
        this.mAutoIncrement = false;
        this.mAutoDecrement = false;
        this.mLongClickPlusButtonListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingRemoverLayout.this.mAutoIncrement = true;
                SpenSettingRemoverLayout.this.mCutterPlusButton.setSelected(true);
                SpenSettingRemoverLayout.this.repeatUpdateHandler.post(SpenSettingRemoverLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mTouchPlusButtonListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingRemoverLayout.this.mAutoIncrement) {
                    SpenSettingRemoverLayout.this.mCutterPlusButton.setSelected(false);
                    SpenSettingRemoverLayout.this.mAutoIncrement = false;
                }
                return false;
            }
        };
        this.mPlusButtonKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.11
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (SpenSettingRemoverLayout.this.mCutterPlusButton.isSelected() && event.getAction() == 1) {
                            SpenSettingRemoverLayout.this.mCutterPlusButton.setSelected(false);
                            SpenSettingRemoverLayout.this.mAutoIncrement = false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        };
        this.mLongClickMinusButtonListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.12
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingRemoverLayout.this.mAutoDecrement = true;
                SpenSettingRemoverLayout.this.mCutterMinusButton.setSelected(true);
                SpenSettingRemoverLayout.this.repeatUpdateHandler.post(SpenSettingRemoverLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mTouchMinusButtonListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingRemoverLayout.this.mAutoDecrement) {
                    SpenSettingRemoverLayout.this.mCutterMinusButton.setSelected(false);
                    SpenSettingRemoverLayout.this.mAutoDecrement = false;
                }
                return false;
            }
        };
        this.mMinusButtonKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.14
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (SpenSettingRemoverLayout.this.mCutterMinusButton.isSelected() && event.getAction() == 1) {
                            SpenSettingRemoverLayout.this.mCutterMinusButton.setSelected(false);
                            SpenSettingRemoverLayout.this.mAutoDecrement = false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        };
        this.mCutterSizeListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SpenSettingRemoverInfo info;
                if (SpenSettingRemoverLayout.this.mCutterDataList[SpenSettingRemoverLayout.this.mCurrentCutterType] != null) {
                    SpenSettingRemoverLayout.this.mCutterDataList[SpenSettingRemoverLayout.this.mCurrentCutterType].size = (((progress + 1) * 10.0f) / 10.0f) * (SpenSettingRemoverLayout.this.mCanvasSize / 1080.0f);
                }
                int currentType = 1;
                SpenSettingRemoverLayout.this.requestLayoutDisable = fromUser;
                SpenSettingRemoverLayout.this.mEraserSizeTextView.setText(String.valueOf(progress + 1));
                int seek_label_pos = SpenSettingRemoverLayout.this.mDrawableImg.getIntValueAppliedDensity(30.0f) + ((int) (SpenSettingRemoverLayout.this.mDrawableImg.getIntValueAppliedDensity(150.0f) * (progress / 9.0f)));
                if (progress + 1 >= 10) {
                    seek_label_pos -= SpenSettingRemoverLayout.this.mDrawableImg.getIntValueAppliedDensity(4.0f);
                }
                SpenSettingRemoverLayout.this.mEraserSizeTextView.setX(seek_label_pos);
                SpenSettingRemoverLayout.this.mEraserSizeTextView.setY(SpenSettingRemoverLayout.this.mDrawableImg.getIntValueAppliedDensity(5.0f));
                if (SpenSettingRemoverLayout.this.mCanvasView != null && (info = SpenSettingRemoverLayout.this.mCanvasView.getRemoverSettingInfo()) != null) {
                    SpenSettingRemoverInfo spenSettingRemoverInfo = SpenSettingRemoverLayout.this.mSettingInfo;
                    float f = (progress + 1) * (SpenSettingRemoverLayout.this.mCanvasSize / 1080.0f);
                    info.size = f;
                    spenSettingRemoverInfo.size = f;
                    SpenSettingRemoverInfo spenSettingRemoverInfo2 = SpenSettingRemoverLayout.this.mSettingInfo;
                    currentType = info.type;
                    spenSettingRemoverInfo2.type = currentType;
                    SpenSettingRemoverLayout.this.mCanvasView.setRemoverSettingInfo(info);
                }
                SpenSettingRemoverLayout.this.mCutterSizeSeekBar.setContentDescription(String.valueOf(SpenSettingRemoverLayout.this.mEraserSizeTextView.getText().toString()) + "\u0000");
                if (currentType != 1) {
                    if (SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getProgress() == SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getMax()) {
                        SpenSettingRemoverLayout.this.mCutterPlusButton.setSelected(false);
                        SpenSettingRemoverLayout.this.mCutterPlusButton.setEnabled(false);
                        if (SpenSettingRemoverLayout.this.mAutoIncrement) {
                            SpenSettingRemoverLayout.this.mAutoIncrement = false;
                        }
                    } else {
                        SpenSettingRemoverLayout.this.mCutterPlusButton.setEnabled(true);
                    }
                    if (SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getProgress() == 0) {
                        SpenSettingRemoverLayout.this.mCutterMinusButton.setSelected(false);
                        SpenSettingRemoverLayout.this.mCutterMinusButton.setEnabled(false);
                        if (SpenSettingRemoverLayout.this.mAutoDecrement) {
                            SpenSettingRemoverLayout.this.mAutoDecrement = false;
                            return;
                        }
                        return;
                    }
                    SpenSettingRemoverLayout.this.mCutterMinusButton.setEnabled(true);
                }
            }
        };
        this.mCutterTypeListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingRemoverLayout.this.cutterTypeSetting(v);
            }
        };
        this.mCutterKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.17
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingRemoverLayout.this.mCutterSizeSeekBar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getProgress() != 0) {
                                SpenSettingRemoverLayout.this.mCutterSizeSeekBar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingRemoverLayout.this.mCutterSizeSeekBar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getProgress() != SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getMax()) {
                                SpenSettingRemoverLayout.this.mCutterSizeSeekBar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.mLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.18
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                try {
                    if (SpenSettingRemoverLayout.this.getVisibility() == 8) {
                        return;
                    }
                    SpenSettingRemoverLayout.this.mMovableRect.set(SpenSettingRemoverLayout.this.getMovableRect());
                    if (SpenSettingRemoverLayout.this.mIsRotated) {
                        SpenSettingRemoverLayout.this.rotatePosition();
                        SpenSettingRemoverLayout.this.mIsRotated = false;
                    } else {
                        SpenSettingRemoverLayout.this.checkPosition();
                    }
                    Handler handler = new Handler();
                    handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SpenSettingRemoverLayout.this.requestLayout();
                        }
                    });
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

    public SpenSettingRemoverLayout(Context context, String customImagePath, RelativeLayout relativeLayout, float ratio) {
        super(context);
        this.requestLayoutDisable = false;
        this.mScale = 1.0f;
        this.mCanvasSize = 1080;
        this.mCurrentCutterType = 0;
        this.mSettingInfo = null;
        this.mCutterDataList = null;
        this.mGestureDetector = null;
        this.mMoveSettingLayout = false;
        this.mNeedCalculateMargin = true;
        this.mFirstLongPress = true;
        this.mIsRotated = false;
        this.mImageLoader = null;
        this.mCutterListener = null;
        this.mActionListener = null;
        this.mVisibilityListener = null;
        this.mViewMode = 0;
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (SpenSettingRemoverLayout.this.mGestureDetector == null || !SpenSettingRemoverLayout.this.mGestureDetector.onTouchEvent(event)) {
                    int x = (int) event.getRawX();
                    int y = (int) event.getRawY();
                    switch (event.getAction()) {
                        case 1:
                            if (SpenSettingRemoverLayout.this.mMoveSettingLayout && SpenSettingRemoverLayout.this.mActionListener != null) {
                                SpenSettingRemoverLayout.this.mActionListener.onMoved();
                                break;
                            }
                            break;
                        case 2:
                            if (SpenSettingRemoverLayout.this.mMoveSettingLayout) {
                                int mMoveX = x - SpenSettingRemoverLayout.this.mXDelta;
                                int mMoveY = y - SpenSettingRemoverLayout.this.mYDelta;
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                if (mMoveX > (SpenSettingRemoverLayout.this.mCanvasLayout.getWidth() - SpenSettingRemoverLayout.this.getWidth()) - 2) {
                                    mMoveX = (SpenSettingRemoverLayout.this.mCanvasLayout.getWidth() - SpenSettingRemoverLayout.this.getWidth()) - 2;
                                }
                                if (mMoveY > SpenSettingRemoverLayout.this.mMovableRect.height() - SpenSettingRemoverLayout.this.getHeight()) {
                                    mMoveY = SpenSettingRemoverLayout.this.mMovableRect.height() - SpenSettingRemoverLayout.this.getHeight();
                                }
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                ViewGroup.MarginLayoutParams Params = (ViewGroup.MarginLayoutParams) SpenSettingRemoverLayout.this.getLayoutParams();
                                Params.leftMargin = mMoveX;
                                Params.topMargin = mMoveY;
                                SpenSettingRemoverLayout.this.setLayoutParams(Params);
                                break;
                            }
                            break;
                    }
                    SpenSettingRemoverLayout.this.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
        };
        this.mOnConsumedTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpenSettingRemoverLayout.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mClearAllListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingRemoverLayout.this.mCutterListener != null) {
                    SpenSettingRemoverLayout.this.mCutterListener.onClearAll();
                }
                SpenSettingRemoverLayout.this.setVisibility(8);
            }
        };
        this.mCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SpenSettingRemoverInfo info;
                if (SpenSettingRemoverLayout.this.mCanvasView != null && (info = SpenSettingRemoverLayout.this.mCanvasView.getRemoverSettingInfo()) != null) {
                    if (isChecked) {
                        SpenSettingRemoverInfo spenSettingRemoverInfo = SpenSettingRemoverLayout.this.mSettingInfo;
                        info.type = 1;
                        spenSettingRemoverInfo.type = 1;
                        SpenSettingRemoverLayout.this.setEnableSizeSeekbar(false);
                        SpenSettingRemoverLayout.this.playSoundEffect(0);
                    } else {
                        SpenSettingRemoverInfo spenSettingRemoverInfo2 = SpenSettingRemoverLayout.this.mSettingInfo;
                        info.type = 0;
                        spenSettingRemoverInfo2.type = 0;
                        SpenSettingRemoverLayout.this.setEnableSizeSeekbar(true);
                        SpenSettingRemoverLayout.this.playSoundEffect(0);
                    }
                    SpenSettingRemoverLayout.this.mCanvasView.setRemoverSettingInfo(info);
                }
            }
        };
        this.mGestureListener = new GestureDetector.OnGestureListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.5
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
                if (SpenSettingRemoverLayout.this.mNeedCalculateMargin) {
                    int[] location = new int[2];
                    SpenSettingRemoverLayout.this.mCanvasLayout.getLocationOnScreen(location);
                    SpenSettingRemoverLayout.this.mLeftMargin = (int) ((event.getRawX() - location[0]) - event.getX());
                    SpenSettingRemoverLayout.this.mTopMargin = (int) ((event.getRawY() - location[1]) - event.getY());
                    int[] rootLocation = new int[2];
                    SpenSettingRemoverLayout.this.getRootView().getLocationOnScreen(rootLocation);
                    SpenSettingRemoverLayout.this.mNeedCalculateMargin = false;
                }
                if (SpenSettingRemoverLayout.this.mFirstLongPress) {
                    SpenSettingRemoverLayout.this.mTitleLayout.performHapticFeedback(1);
                    SpenSettingRemoverLayout.this.mFirstLongPress = false;
                }
                Rect r = SpenSettingRemoverLayout.this.getMovableRect();
                SpenSettingRemoverLayout.this.mMovableRect.set(r);
                SpenSettingRemoverLayout.this.mMoveSettingLayout = true;
                SpenSettingRemoverLayout.this.mIndicator.setVisibility(8);
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent event) {
                SpenSettingRemoverLayout.this.mMovableRect.set(SpenSettingRemoverLayout.this.getMovableRect());
                int x = (int) event.getRawX();
                int y = (int) event.getRawY();
                ViewGroup.MarginLayoutParams Params = (ViewGroup.MarginLayoutParams) SpenSettingRemoverLayout.this.getLayoutParams();
                SpenSettingRemoverLayout.this.mXDelta = x - Params.leftMargin;
                SpenSettingRemoverLayout.this.mYDelta = y - Params.topMargin;
                return true;
            }
        };
        this.mExitButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingRemoverLayout.this.setVisibility(8);
            }
        };
        this.mPlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getProgress() != SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getMax()) {
                    SpenSettingRemoverLayout.this.mCutterDataList[SpenSettingRemoverLayout.this.mCurrentCutterType].size += 1.0f * (SpenSettingRemoverLayout.this.mCanvasSize / 1080.0f);
                    SpenSettingRemoverLayout.this.mCutterSizeSeekBar.incrementProgressBy(1);
                    SpenSettingRemoverLayout.this.mSettingInfo.size = SpenSettingRemoverLayout.this.mCutterDataList[SpenSettingRemoverLayout.this.mCurrentCutterType].size;
                }
            }
        };
        this.mMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getProgress() != 0) {
                    SpenSettingRemoverLayout.this.mCutterDataList[SpenSettingRemoverLayout.this.mCurrentCutterType].size -= 1.0f * (SpenSettingRemoverLayout.this.mCanvasSize / 1080.0f);
                    SpenSettingRemoverLayout.this.mCutterSizeSeekBar.incrementProgressBy(-1);
                    SpenSettingRemoverLayout.this.mSettingInfo.size = SpenSettingRemoverLayout.this.mCutterDataList[SpenSettingRemoverLayout.this.mCurrentCutterType].size;
                }
            }
        };
        this.repeatUpdateHandler = new Handler();
        this.mAutoIncrement = false;
        this.mAutoDecrement = false;
        this.mLongClickPlusButtonListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingRemoverLayout.this.mAutoIncrement = true;
                SpenSettingRemoverLayout.this.mCutterPlusButton.setSelected(true);
                SpenSettingRemoverLayout.this.repeatUpdateHandler.post(SpenSettingRemoverLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mTouchPlusButtonListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingRemoverLayout.this.mAutoIncrement) {
                    SpenSettingRemoverLayout.this.mCutterPlusButton.setSelected(false);
                    SpenSettingRemoverLayout.this.mAutoIncrement = false;
                }
                return false;
            }
        };
        this.mPlusButtonKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.11
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (SpenSettingRemoverLayout.this.mCutterPlusButton.isSelected() && event.getAction() == 1) {
                            SpenSettingRemoverLayout.this.mCutterPlusButton.setSelected(false);
                            SpenSettingRemoverLayout.this.mAutoIncrement = false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        };
        this.mLongClickMinusButtonListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.12
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingRemoverLayout.this.mAutoDecrement = true;
                SpenSettingRemoverLayout.this.mCutterMinusButton.setSelected(true);
                SpenSettingRemoverLayout.this.repeatUpdateHandler.post(SpenSettingRemoverLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mTouchMinusButtonListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingRemoverLayout.this.mAutoDecrement) {
                    SpenSettingRemoverLayout.this.mCutterMinusButton.setSelected(false);
                    SpenSettingRemoverLayout.this.mAutoDecrement = false;
                }
                return false;
            }
        };
        this.mMinusButtonKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.14
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (SpenSettingRemoverLayout.this.mCutterMinusButton.isSelected() && event.getAction() == 1) {
                            SpenSettingRemoverLayout.this.mCutterMinusButton.setSelected(false);
                            SpenSettingRemoverLayout.this.mAutoDecrement = false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        };
        this.mCutterSizeListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.15
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SpenSettingRemoverInfo info;
                if (SpenSettingRemoverLayout.this.mCutterDataList[SpenSettingRemoverLayout.this.mCurrentCutterType] != null) {
                    SpenSettingRemoverLayout.this.mCutterDataList[SpenSettingRemoverLayout.this.mCurrentCutterType].size = (((progress + 1) * 10.0f) / 10.0f) * (SpenSettingRemoverLayout.this.mCanvasSize / 1080.0f);
                }
                int currentType = 1;
                SpenSettingRemoverLayout.this.requestLayoutDisable = fromUser;
                SpenSettingRemoverLayout.this.mEraserSizeTextView.setText(String.valueOf(progress + 1));
                int seek_label_pos = SpenSettingRemoverLayout.this.mDrawableImg.getIntValueAppliedDensity(30.0f) + ((int) (SpenSettingRemoverLayout.this.mDrawableImg.getIntValueAppliedDensity(150.0f) * (progress / 9.0f)));
                if (progress + 1 >= 10) {
                    seek_label_pos -= SpenSettingRemoverLayout.this.mDrawableImg.getIntValueAppliedDensity(4.0f);
                }
                SpenSettingRemoverLayout.this.mEraserSizeTextView.setX(seek_label_pos);
                SpenSettingRemoverLayout.this.mEraserSizeTextView.setY(SpenSettingRemoverLayout.this.mDrawableImg.getIntValueAppliedDensity(5.0f));
                if (SpenSettingRemoverLayout.this.mCanvasView != null && (info = SpenSettingRemoverLayout.this.mCanvasView.getRemoverSettingInfo()) != null) {
                    SpenSettingRemoverInfo spenSettingRemoverInfo = SpenSettingRemoverLayout.this.mSettingInfo;
                    float f = (progress + 1) * (SpenSettingRemoverLayout.this.mCanvasSize / 1080.0f);
                    info.size = f;
                    spenSettingRemoverInfo.size = f;
                    SpenSettingRemoverInfo spenSettingRemoverInfo2 = SpenSettingRemoverLayout.this.mSettingInfo;
                    currentType = info.type;
                    spenSettingRemoverInfo2.type = currentType;
                    SpenSettingRemoverLayout.this.mCanvasView.setRemoverSettingInfo(info);
                }
                SpenSettingRemoverLayout.this.mCutterSizeSeekBar.setContentDescription(String.valueOf(SpenSettingRemoverLayout.this.mEraserSizeTextView.getText().toString()) + "\u0000");
                if (currentType != 1) {
                    if (SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getProgress() == SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getMax()) {
                        SpenSettingRemoverLayout.this.mCutterPlusButton.setSelected(false);
                        SpenSettingRemoverLayout.this.mCutterPlusButton.setEnabled(false);
                        if (SpenSettingRemoverLayout.this.mAutoIncrement) {
                            SpenSettingRemoverLayout.this.mAutoIncrement = false;
                        }
                    } else {
                        SpenSettingRemoverLayout.this.mCutterPlusButton.setEnabled(true);
                    }
                    if (SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getProgress() == 0) {
                        SpenSettingRemoverLayout.this.mCutterMinusButton.setSelected(false);
                        SpenSettingRemoverLayout.this.mCutterMinusButton.setEnabled(false);
                        if (SpenSettingRemoverLayout.this.mAutoDecrement) {
                            SpenSettingRemoverLayout.this.mAutoDecrement = false;
                            return;
                        }
                        return;
                    }
                    SpenSettingRemoverLayout.this.mCutterMinusButton.setEnabled(true);
                }
            }
        };
        this.mCutterTypeListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingRemoverLayout.this.cutterTypeSetting(v);
            }
        };
        this.mCutterKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.17
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingRemoverLayout.this.mCutterSizeSeekBar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getProgress() != 0) {
                                SpenSettingRemoverLayout.this.mCutterSizeSeekBar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingRemoverLayout.this.mCutterSizeSeekBar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getProgress() != SpenSettingRemoverLayout.this.mCutterSizeSeekBar.getMax()) {
                                SpenSettingRemoverLayout.this.mCutterSizeSeekBar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.mLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.18
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                try {
                    if (SpenSettingRemoverLayout.this.getVisibility() == 8) {
                        return;
                    }
                    SpenSettingRemoverLayout.this.mMovableRect.set(SpenSettingRemoverLayout.this.getMovableRect());
                    if (SpenSettingRemoverLayout.this.mIsRotated) {
                        SpenSettingRemoverLayout.this.rotatePosition();
                        SpenSettingRemoverLayout.this.mIsRotated = false;
                    } else {
                        SpenSettingRemoverLayout.this.checkPosition();
                    }
                    Handler handler = new Handler();
                    handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SpenSettingRemoverLayout.this.requestLayout();
                        }
                    });
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
        this.mExitButton.setId(IB_REMOVER_EXIT_ID);
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
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.addView(bodyBg());
        this.mClearAllButton = cutterSettingClearAllButton();
        this.mCutterTypeLayout = cutterTypeLayout();
        this.mSettingSizeLayout = cutterSettingSize();
        ImageView imgDivider = new ImageView(this.mContext);
        RelativeLayout.LayoutParams dividerParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(1.0f));
        dividerParams.alignWithParent = true;
        dividerParams.addRule(6);
        dividerParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(5.0f);
        dividerParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(5.0f);
        dividerParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(50.0f);
        imgDivider.setLayoutParams(dividerParams);
        this.mImageLoader.addViewSetBackgroundImageLoad(imgDivider, lineDivider);
        relativeLayout.addView(imgDivider);
        this.mCutterTypeChekBox = eraseByStroke();
        setEnableSizeSeekbar(false);
        this.mCutterTypeLayout.setVisibility(8);
        relativeLayout.addView(this.mCutterTypeLayout);
        relativeLayout.addView(this.mSettingSizeLayout);
        relativeLayout.addView(this.mCutterTypeChekBox);
        relativeLayout.addView(this.mClearAllButton);
        return relativeLayout;
    }

    private ViewGroup bodyBg() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.setLayoutParams(layoutParams);
        ImageView bodyLeft = new ImageView(this.mContext);
        RelativeLayout.LayoutParams bodyLeftParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(114.0f), this.mDrawableImg.getIntValueAppliedDensity(120.0f));
        bodyLeftParam.alignWithParent = true;
        bodyLeftParam.addRule(9);
        bodyLeftParam.addRule(10);
        bodyLeft.setLayoutParams(bodyLeftParam);
        ImageView bodyRight = new ImageView(this.mContext);
        RelativeLayout.LayoutParams bodyRightParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(114.0f), this.mDrawableImg.getIntValueAppliedDensity(120.0f));
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

    public void close() {
        this.mCanvasView = null;
        this.mCanvasLayout = null;
        this.mContext = null;
        this.mOnTouchListener = null;
        this.mOnConsumedTouchListener = null;
        this.mClearAllListener = null;
        this.mGestureListener = null;
        this.mExitButtonListener = null;
        this.mPlusButtonListener = null;
        this.mMinusButtonListener = null;
        this.mLongClickPlusButtonListener = null;
        this.mTouchPlusButtonListener = null;
        this.mLongClickMinusButtonListener = null;
        this.mTouchMinusButtonListener = null;
        this.mCutterSizeListener = null;
        this.mCutterTypeListner = null;
        this.mCutterKeyListener = null;
        this.repeatUpdateHandler = null;
        if (this.mDrawableImg != null) {
            this.mDrawableImg.unbindDrawables(this);
            this.mDrawableImg.unbindDrawables(this.mCutterSizeSeekBar);
            this.mCutterSizeSeekBar = null;
            this.mDrawableImg.unbindDrawables(this.mCutterSizeButton);
            this.mCutterSizeButton = null;
            this.mDrawableImg.unbindDrawables(this.mIndicator);
            this.mIndicator = null;
            this.mDrawableImg.unbindDrawables(this.mExitButton);
            this.mExitButton = null;
            this.mDrawableImg.unbindDrawables(this.mCutterPlusButton);
            this.mCutterPlusButton = null;
            this.mDrawableImg.unbindDrawables(this.mCutterMinusButton);
            this.mCutterMinusButton = null;
            this.mDrawableImg.unbindDrawables(this.mClearAllButton);
            this.mClearAllButton = null;
            this.mDrawableImg.unbindDrawables(this.mCutterTypeChekBox);
            this.mCutterTypeChekBox = null;
            this.mDrawableImg.unbindDrawables(this.mSettingSizeLayout);
            this.mSettingSizeLayout = null;
            this.mDrawableImg.unbindDrawables(this.mCutterType01);
            this.mCutterType01 = null;
            this.mDrawableImg.unbindDrawables(this.mCutterType02);
            this.mCutterType02 = null;
            if (this.mCutterTypeLayout != null) {
                for (int i = 0; i < this.mCutterTypeLayout.getChildCount(); i++) {
                    this.mDrawableImg.unbindDrawables(this.mCutterTypeView[i]);
                    this.mCutterTypeView[i] = null;
                }
            }
            this.mEraserSizeTextView = null;
            this.mCutterTypeView = null;
            this.mDrawableImg.unbindDrawables(this.mCutterTypeLayout);
            this.mCutterTypeLayout = null;
            this.mDrawableImg.unbindDrawables(this.mTitleLayout);
            this.mTitleLayout = null;
            this.mDrawableImg.unbindDrawables(this.mBodyLayout);
            this.mBodyLayout = null;
            this.mSettingInfo = null;
            if (this.mCutterDataList != null) {
                this.mCutterDataList[0] = null;
                this.mCutterDataList[1] = null;
                this.mCutterDataList = null;
            }
            this.mGestureDetector = null;
            this.mDrawableImg.unbindDrawables(this);
            this.mCutterListener = null;
            this.mActionListener = null;
            this.mVisibilityListener = null;
            this.mDrawableImg = null;
            this.mStringUtil = null;
            this.mImageLoader.close();
            this.mImageLoader = null;
        }
    }

    protected void initView() {
        totalLayout();
        LinearLayout cutterTypeViewGroup = (LinearLayout) this.mCutterTypeLayout;
        this.mCutterTypeView = new View[cutterTypeViewGroup.getChildCount()];
        for (int i = 0; i < cutterTypeViewGroup.getChildCount(); i++) {
            this.mCutterTypeView[i] = cutterTypeViewGroup.getChildAt(i);
        }
        this.mCutterSizeSeekBar.setMax(9);
        this.mSettingInfo = new SpenSettingRemoverInfo();
        if (this.mCutterDataList == null) {
            this.mCutterDataList = new SpenSettingRemoverInfo[2];
            this.mCutterDataList[0] = new SpenSettingRemoverInfo();
            this.mCutterDataList[1] = new SpenSettingRemoverInfo();
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
        if (this.mCutterMinusButton != null) {
            this.mCutterMinusButton.setOnClickListener(this.mMinusButtonListener);
            this.mCutterMinusButton.setOnLongClickListener(this.mLongClickMinusButtonListener);
            this.mCutterMinusButton.setOnTouchListener(this.mTouchMinusButtonListener);
            this.mCutterMinusButton.setOnKeyListener(this.mMinusButtonKeyListener);
        }
        if (this.mCutterPlusButton != null) {
            this.mCutterPlusButton.setOnClickListener(this.mPlusButtonListener);
            this.mCutterPlusButton.setOnLongClickListener(this.mLongClickPlusButtonListener);
            this.mCutterPlusButton.setOnTouchListener(this.mTouchPlusButtonListener);
            this.mCutterPlusButton.setOnKeyListener(this.mPlusButtonKeyListener);
        }
        if (this.mCutterSizeSeekBar != null) {
            this.mCutterSizeSeekBar.setOnSeekBarChangeListener(this.mCutterSizeListener);
        }
        if (this.mClearAllButton != null) {
            this.mClearAllButton.setOnClickListener(this.mClearAllListener);
        }
        if (this.mCutterTypeChekBox != null) {
            ((CompoundButton) this.mCutterTypeChekBox).setOnCheckedChangeListener(this.mCheckedChangeListener);
        }
        if (this.mCutterTypeView != null) {
            for (int i = 0; i <= 1; i++) {
                if (this.mCutterTypeView[i] != null) {
                    this.mCutterTypeView[i].setOnClickListener(this.mCutterTypeListner);
                }
            }
        }
        if (this.mCutterSizeSeekBar != null) {
            this.mCutterSizeSeekBar.setOnKeyListener(this.mCutterKeyListener);
        }
    }

    public void setIndicatorPosition(int position) {
        if (position < 0) {
            this.mIndicator.setVisibility(8);
            this.mMoveSettingLayout = true;
            return;
        }
        this.mMoveSettingLayout = false;
        this.mIndicator.setVisibility(0);
        RelativeLayout.LayoutParams titleCenterParam = new RelativeLayout.LayoutParams(-2, -1);
        titleCenterParam.setMargins(position, 0, 0, 0);
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

    private ViewGroup cutterTypeLayout() {
        LinearLayout localLinearLayout = new LinearLayout(this.mContext);
        localLinearLayout.setOrientation(0);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLinearLayout.setLayoutParams(localLayoutParams);
        this.mCutterType01 = new ImageButton(this.mContext);
        this.mCutterType01.setImageDrawable(this.mDrawableImg.setDrawableImg(cutterPopupDrawUnselect));
        this.mCutterType01.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.19
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        SpenSettingRemoverLayout.this.mCutterType01.setImageDrawable(SpenSettingRemoverLayout.this.mDrawableImg.setDrawableImg(SpenSettingRemoverLayout.cutterPopupDrawPress));
                        break;
                    case 1:
                        SpenSettingRemoverLayout.this.mCutterType01.setImageDrawable(SpenSettingRemoverLayout.this.mDrawableImg.setDrawableImg(SpenSettingRemoverLayout.cutterPopupDrawUnselect));
                        break;
                }
                return false;
            }
        });
        localLinearLayout.addView(this.mCutterType01);
        this.mCutterType02 = new ImageButton(this.mContext);
        this.mCutterType02.setImageDrawable(this.mDrawableImg.setDrawableImg(cutterPopupTextUnselect));
        this.mCutterType02.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingRemoverLayout.20
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        SpenSettingRemoverLayout.this.mCutterType02.setImageDrawable(SpenSettingRemoverLayout.this.mDrawableImg.setDrawableImg(SpenSettingRemoverLayout.cutterPopupTextPress));
                        break;
                    case 1:
                        SpenSettingRemoverLayout.this.mCutterType02.setImageDrawable(SpenSettingRemoverLayout.this.mDrawableImg.setDrawableImg(SpenSettingRemoverLayout.cutterPopupTextUnselect));
                        break;
                }
                return false;
            }
        });
        localLinearLayout.addView(this.mCutterType02);
        return localLinearLayout;
    }

    private ViewGroup cutterSettingSize() {
        RelativeLayout cutterSettingSizeLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams cutterSettingSizeLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(46.0f));
        cutterSettingSizeLayoutParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(5.0f), this.mDrawableImg.getIntValueAppliedDensity(-2.0f), this.mDrawableImg.getIntValueAppliedDensity(5.0f), this.mDrawableImg.getIntValueAppliedDensity(8.0f));
        cutterSettingSizeLayout.setLayoutParams(cutterSettingSizeLayoutParams);
        this.mEraserSizeTextView = new TextView(this.mContext);
        this.mEraserSizeTextView.setTypeface(Typeface.SANS_SERIF, 1);
        this.mEraserSizeTextView.setTextColor(Color.rgb(86, 87, 91));
        this.mEraserSizeTextView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(12.0f));
        this.mEraserSizeTextView.setGravity(51);
        RelativeLayout.LayoutParams eraserSizeTextParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(50.0f), this.mDrawableImg.getIntValueAppliedDensity(13.0f));
        eraserSizeTextParam.addRule(4);
        this.mEraserSizeTextView.setLayoutParams(eraserSizeTextParam);
        cutterSettingSizeLayout.addView(this.mEraserSizeTextView);
        this.mCutterSizeButton = cutterSettingSizeDisplay();
        cutterSettingSizeLayout.addView(this.mCutterSizeButton);
        return cutterSettingSizeLayout;
    }

    private SeekBar cutterSettingSizeSeekBar() throws Resources.NotFoundException, IOException {
        SeekBar seekBar = new SeekBar(this.mContext);
        RelativeLayout.LayoutParams seekBarParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(170.0f), this.mDrawableImg.getIntValueAppliedDensity(22.0f));
        seekBarParams.setMargins(0, 0, 0, 0);
        seekBarParams.alignWithParent = true;
        seekBarParams.addRule(14);
        seekBarParams.addRule(8);
        seekBar.setLayoutParams(seekBarParams);
        seekBar.setPadding(0, 0, 0, 0);
        seekBar.setMax(9);
        Drawable thumbImage = this.mDrawableImg.setDrawableSelectImg(handelPath, handelPressPath, handelFocusPath, 22, 22);
        seekBar.setThumb(thumbImage);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnableSizeSeekbar(boolean enabled) {
        this.mCutterSizeSeekBar.setPressed(false);
        if (enabled) {
            this.mCutterSizeSeekBar.setEnabled(true);
            this.mCutterPlusButton.setEnabled(true);
            this.mCutterMinusButton.setEnabled(true);
            this.mEraserSizeTextView.setVisibility(0);
            this.mEraserSizeTextView.setText(String.valueOf(this.mCutterSizeSeekBar.getProgress() + 1));
            int seek_label_pos = this.mDrawableImg.getIntValueAppliedDensity(30.0f) + ((int) (this.mDrawableImg.getIntValueAppliedDensity(150.0f) * (this.mCutterSizeSeekBar.getProgress() / 9.0f)));
            if (this.mCutterSizeSeekBar.getProgress() + 1 >= 10) {
                seek_label_pos -= this.mDrawableImg.getIntValueAppliedDensity(4.0f);
            }
            this.mEraserSizeTextView.setX(seek_label_pos);
            this.mEraserSizeTextView.setY(this.mDrawableImg.getIntValueAppliedDensity(5.0f));
            this.mEraserSizeTextView.setX(seek_label_pos);
            this.mEraserSizeTextView.setY(this.mDrawableImg.getIntValueAppliedDensity(5.0f));
            ((CompoundButton) this.mCutterTypeChekBox).setChecked(false);
            if (this.mSettingInfo.type != 1) {
                if (this.mCutterSizeSeekBar.getProgress() == this.mCutterSizeSeekBar.getMax()) {
                    this.mCutterPlusButton.setSelected(false);
                    this.mCutterPlusButton.setEnabled(false);
                    if (this.mAutoIncrement) {
                        this.mAutoIncrement = false;
                    }
                } else {
                    this.mCutterPlusButton.setEnabled(true);
                }
                if (this.mCutterSizeSeekBar.getProgress() == 0) {
                    this.mCutterMinusButton.setSelected(false);
                    this.mCutterMinusButton.setEnabled(false);
                    if (this.mAutoDecrement) {
                        this.mAutoDecrement = false;
                        return;
                    }
                    return;
                }
                this.mCutterMinusButton.setEnabled(true);
                return;
            }
            return;
        }
        this.mCutterSizeSeekBar.setEnabled(false);
        this.mCutterPlusButton.setEnabled(false);
        this.mCutterMinusButton.setEnabled(false);
        this.mEraserSizeTextView.setVisibility(8);
        ((CompoundButton) this.mCutterTypeChekBox).setChecked(true);
    }

    private ViewGroup cutterSettingSizeDisplay() {
        RelativeLayout cutterSettingSizeDisplayLayout = new RelativeLayout(this.mContext);
        cutterSettingSizeDisplayLayout.setPadding(0, 0, 0, this.mDrawableImg.getIntValueAppliedDensity(3.0f));
        this.mCutterPlusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams cutterPlusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(24.0f), this.mDrawableImg.getIntValueAppliedDensity(24.0f));
        cutterPlusImageParam.alignWithParent = true;
        cutterPlusImageParam.addRule(11);
        cutterPlusImageParam.addRule(8);
        this.mCutterPlusButton.setLayoutParams(cutterPlusImageParam);
        this.mCutterPlusButton.setContentDescription(this.mStringUtil.setString("string_plus"));
        if (mSdkVersion < 16) {
            this.mCutterPlusButton.setBackgroundDrawable(this.mDrawableImg.setDrawableDimImg(plusBgPath, plusBgPressPath, plusBgFocusPath, plusBgDimPath, 24, 24));
        } else {
            this.mCutterPlusButton.setBackground(this.mDrawableImg.setDrawableDimImg(plusBgPath, plusBgPressPath, plusBgFocusPath, plusBgDimPath, 24, 24));
        }
        this.mCutterMinusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams cutterMinusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(24.0f), this.mDrawableImg.getIntValueAppliedDensity(24.0f));
        cutterMinusImageParam.alignWithParent = true;
        cutterMinusImageParam.addRule(9);
        cutterMinusImageParam.addRule(8);
        this.mCutterMinusButton.setLayoutParams(cutterMinusImageParam);
        this.mCutterMinusButton.setContentDescription(this.mStringUtil.setString("string_minus"));
        if (mSdkVersion < 16) {
            this.mCutterMinusButton.setBackgroundDrawable(this.mDrawableImg.setDrawableDimImg(minusBgPath, minusBgPressPath, minusBgFocusPath, minusBgDimPath, 24, 24));
        } else {
            this.mCutterMinusButton.setBackground(this.mDrawableImg.setDrawableDimImg(minusBgPath, minusBgPressPath, minusBgFocusPath, minusBgDimPath, 24, 24));
        }
        this.mCutterSizeSeekBar = cutterSettingSizeSeekBar();
        cutterSettingSizeDisplayLayout.addView(this.mCutterSizeSeekBar);
        cutterSettingSizeDisplayLayout.addView(this.mCutterPlusButton);
        cutterSettingSizeDisplayLayout.addView(this.mCutterMinusButton);
        this.mCutterMinusButton.setId(IB_REMOVER_SIZE_MINUS_ID);
        this.mCutterPlusButton.setId(IB_REMOVER_SIZE_PLUS_ID);
        this.mCutterMinusButton.setNextFocusUpId(IB_REMOVER_EXIT_ID);
        this.mCutterPlusButton.setNextFocusUpId(IB_REMOVER_EXIT_ID);
        this.mCutterSizeSeekBar.setNextFocusUpId(IB_REMOVER_EXIT_ID);
        this.mCutterSizeSeekBar.setNextFocusLeftId(IB_REMOVER_SIZE_MINUS_ID);
        this.mCutterSizeSeekBar.setNextFocusRightId(IB_REMOVER_SIZE_PLUS_ID);
        return cutterSettingSizeDisplayLayout;
    }

    private View cutterSettingClearAllButton() {
        Button clearAllButton = new Button(this.mContext);
        RelativeLayout.LayoutParams clearAllButtonParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(33.0f));
        clearAllButtonParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(10.0f), this.mDrawableImg.getIntValueAppliedDensity(84.0f), this.mDrawableImg.getIntValueAppliedDensity(10.0f), this.mDrawableImg.getIntValueAppliedDensity(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET));
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

    private View eraseByStroke() {
        CheckBox typeCheckBox = new CheckBox(this.mContext);
        RelativeLayout.LayoutParams typeCheckBoxParams = new RelativeLayout.LayoutParams(-2, this.mDrawableImg.getIntValueAppliedDensity(33.0f));
        typeCheckBoxParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(13.0f), this.mDrawableImg.getIntValueAppliedDensity(51.0f), this.mDrawableImg.getIntValueAppliedDensity(10.0f), this.mDrawableImg.getIntValueAppliedDensity(8.0f));
        typeCheckBox.setLayoutParams(typeCheckBoxParams);
        typeCheckBox.setFocusable(true);
        typeCheckBox.setSingleLine(true);
        typeCheckBox.setEllipsize(TextUtils.TruncateAt.END);
        if (mSdkVersion > 16) {
            typeCheckBox.setPadding(this.mDrawableImg.getIntValueAppliedDensity(10.0f), 0, 0, 0);
        } else {
            typeCheckBox.setPadding(this.mDrawableImg.getIntValueAppliedDensity(28.0f), 0, 0, 0);
        }
        typeCheckBox.setText(this.mStringUtil.setString("string_erase_line_by_line"));
        typeCheckBox.setButtonDrawable(this.mDrawableImg.setDrawableCheckedImg("snote_btn_check_off", "snote_btn_check_on", "snote_btn_check_on_focused", "snote_btn_check_off_focused", "snote_btn_check_on_pressed", "snote_btn_check_off_pressed", 19, 19));
        typeCheckBox.setTextColor(-16777216);
        typeCheckBox.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(15.0f));
        typeCheckBox.setChecked(true);
        return typeCheckBox;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cutterTypeSetting(View selectedView) {
        SpenSettingRemoverInfo info;
        SpenSettingRemoverInfo info2;
        for (int i = 0; i < this.mCutterTypeView.length; i++) {
            if (this.mCutterTypeView[i] != null) {
                this.mCutterTypeView[i].setSelected(false);
                if (selectedView.equals(this.mCutterTypeView[i])) {
                    this.mCutterTypeView[i].invalidate();
                    this.mCurrentCutterType = i;
                    if (i == 0) {
                        this.mCurrentCutterType = 0;
                    } else if (i == 1) {
                        this.mCurrentCutterType = 1;
                    }
                    switch (i) {
                        case 0:
                            if (this.mCanvasView != null && (info2 = this.mCanvasView.getRemoverSettingInfo()) != null) {
                                info2.type = 0;
                                this.mCanvasView.setRemoverSettingInfo(info2);
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if (this.mCanvasView != null && (info = this.mCanvasView.getRemoverSettingInfo()) != null) {
                                info.type = 1;
                                this.mCanvasView.setRemoverSettingInfo(info);
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
        Log.v(TAG, "==== SettingRemover ====");
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
        int minHeight = this.mDrawableImg.getIntValueAppliedDensity(161.0f);
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

    public SpenSettingRemoverInfo getInfo() {
        return this.mSettingInfo;
    }

    public void setViewMode(int viewMode) {
        this.mViewMode = viewMode;
        boolean tempRequestLayoutDisable = this.requestLayoutDisable;
        this.requestLayoutDisable = false;
        if (this.mViewMode == 0) {
            this.mCutterTypeLayout.setVisibility(8);
            this.mSettingSizeLayout.setVisibility(0);
            this.mClearAllButton.setVisibility(0);
        } else if (this.mViewMode == 1) {
            this.mCutterTypeLayout.setVisibility(0);
            this.mClearAllButton.setVisibility(8);
            this.mSettingSizeLayout.setVisibility(8);
        } else if (this.mViewMode == 2) {
            this.mCutterTypeLayout.setVisibility(8);
            this.mClearAllButton.setVisibility(8);
            this.mSettingSizeLayout.setVisibility(0);
        } else if (this.mViewMode == 3) {
            this.mBodyLayout.setVisibility(8);
            this.mTitleLayout.setVisibility(0);
        } else {
            this.mViewMode = 0;
            this.mCutterTypeLayout.setVisibility(8);
            this.mSettingSizeLayout.setVisibility(0);
            this.mClearAllButton.setVisibility(0);
        }
        this.requestLayoutDisable = tempRequestLayoutDisable;
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        if (visibility == 0) {
            try {
                if (!this.mImageLoader.mLoaded) {
                    this.mImageLoader.loadImage();
                }
            } catch (NullPointerException e) {
                return;
            }
        }
        super.setVisibility(visibility);
    }

    public void setCanvasView(SpenSettingViewInterface canvasView) {
        if (canvasView != null) {
            this.mCanvasView = canvasView;
            if (this.mCanvasView != null) {
                if (this.mCanvasView.getCanvasWidth() < this.mCanvasView.getCanvasHeight()) {
                    this.mCanvasSize = this.mCanvasView.getCanvasWidth();
                } else {
                    this.mCanvasSize = this.mCanvasView.getCanvasHeight();
                }
                if (this.mCanvasSize == 0) {
                    this.mCanvasSize = 1080;
                    return;
                }
                return;
            }
            this.mCanvasSize = 1080;
        }
    }

    public void setInfo(SpenSettingRemoverInfo settingCutterInfo) {
        if (settingCutterInfo != null) {
            this.mCurrentCutterType = settingCutterInfo.type;
            if (settingCutterInfo.type == 1) {
                setEnableSizeSeekbar(false);
            } else {
                setEnableSizeSeekbar(true);
            }
            if (this.mCanvasView != null) {
                if (this.mCanvasView.getCanvasWidth() < this.mCanvasView.getCanvasHeight()) {
                    this.mCanvasSize = this.mCanvasView.getCanvasWidth();
                } else {
                    this.mCanvasSize = this.mCanvasView.getCanvasHeight();
                }
                if (this.mCanvasSize == 0) {
                    this.mCanvasSize = 1080;
                }
            } else {
                this.mCanvasSize = 1080;
            }
            this.mCutterDataList[this.mCurrentCutterType].size = settingCutterInfo.size * (1080.0f / this.mCanvasSize);
            this.mCutterSizeSeekBar.setProgress(((int) this.mCutterDataList[this.mCurrentCutterType].size) - 1);
            this.mSettingInfo.size = this.mCutterDataList[this.mCurrentCutterType].size;
            this.mSettingInfo.type = settingCutterInfo.type;
        }
    }

    public void setRemoverInfoList(SpenSettingRemoverInfo[] list) {
        if (list != null) {
            this.mCutterDataList = list;
        }
    }

    public void setRemoverListener(EventListener listener) {
        if (listener != null) {
            this.mCutterListener = listener;
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
}
