package com.samsung.android.sdk.pen.settingui;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.SpenSettingViewInterface;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
public class SpenSettingSelectionLayout extends LinearLayout {
    protected static final int EXIT_BUTTON_HEIGHT = 36;
    protected static final int EXIT_BUTTON_WIDTH = 38;
    protected static final int LINE_BUTTON_BOTTOM_MARGIN = 8;
    protected static final int LINE_BUTTON_HEIGHT = 19;
    protected static final int LINE_BUTTON_TOP_MARGIN = 9;
    protected static final int LINE_BUTTON_WIDTH = 1;
    private static final String TAG = "settingui-settingSelection";
    protected static final int TITLE_LAYOUT_HEIGHT = 41;
    public static final int VIEW_MODE_NORMAL = 0;
    public static final int VIEW_MODE_TITLE = 1;
    private static final String btnFocusPath = "snote_popup_btn_focus";
    private static final String btnNoramlPath = "snote_popup_btn_normal";
    private static final String btnPressPath = "snote_popup_btn_press";
    private static final String exitPath = "snote_popup_close";
    private static final String exitPressPath = "snote_popup_close_press";
    private static final String exitfocusPath = "snote_popup_close_focus";
    private static final String lassoPath = "snote_popup_icon_lasso";
    private static final String linePath = "snote_popup_divider";
    protected static final String mDefaultPath = "";
    private static final String rectPath = "snote_popup_icon_rectangle";
    private static final String titleBodyLeftPath = "snote_popup_bg_left";
    private static final String titleBodyRightPath = "snote_popup_bg_right";
    private static final String titleCenterPath = "snote_popup_title_center";
    private static final String titleLeftPath = "snote_popup_title_left";
    private static final String titleRightPath = "snote_popup_title_right";
    protected ActionListener mActionListener;
    protected View mBodyLayout;
    protected RelativeLayout mCanvasLayout;
    protected SpenSettingViewInterface mCanvasView;
    protected Context mContext;
    protected SPenImageUtil mDrawableImg;
    protected View mExitButton;
    private View.OnClickListener mExitButtonListener;
    protected boolean mFirstLongPress;
    protected GestureDetector mGestureDetector;
    private GestureDetector.OnGestureListener mGestureListener;
    private SpenImageLoader mImageLoader;
    protected ImageView mIndicator;
    protected boolean mIsRotated;
    protected RelativeLayout mLassoButton;
    View.OnLayoutChangeListener mLayoutChangeListener;
    protected int mLeftMargin;
    protected Rect mMovableRect;
    protected boolean mMoveSettingLayout;
    protected boolean mNeedCalculateMargin;
    protected int[] mOldLocation;
    protected Rect mOldMovableRect;
    private View.OnTouchListener mOnConsumedTouchListener;
    private final View.OnKeyListener mOnKeyListener;
    private View.OnTouchListener mOnTouchListener;
    protected RelativeLayout mRectangleButton;
    protected float mScale;
    protected ViewGroup mSelectionTypeLayout;
    private View.OnClickListener mSelectionTypeListner;
    protected View[] mSelectionTypeView;
    protected SpenSettingSelectionInfo mSettingInfo;
    protected SPenTextUtil mStringUtil;
    protected View mTitleLayout;
    protected int mTopMargin;
    protected int mViewMode;
    protected ViewListener mVisibilityListener;
    protected int mXDelta;
    protected int mYDelta;

    public interface ActionListener {
        void onMoved();
    }

    public interface ViewListener {
        void onVisibilityChanged(int i);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        Log.d(TAG, "onConfig selection " + getVisibility());
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

    public SpenSettingSelectionLayout(Context context, String customImagePath, RelativeLayout relativeLayout) {
        super(context);
        this.mScale = 1.0f;
        this.mSettingInfo = null;
        this.mGestureDetector = null;
        this.mMoveSettingLayout = false;
        this.mNeedCalculateMargin = true;
        this.mFirstLongPress = true;
        this.mIsRotated = false;
        this.mActionListener = null;
        this.mVisibilityListener = null;
        this.mViewMode = 0;
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (SpenSettingSelectionLayout.this.mGestureDetector == null || !SpenSettingSelectionLayout.this.mGestureDetector.onTouchEvent(event)) {
                    int x = (int) event.getRawX();
                    int y = (int) event.getRawY();
                    switch (event.getAction()) {
                        case 1:
                            if (SpenSettingSelectionLayout.this.mMoveSettingLayout && SpenSettingSelectionLayout.this.mActionListener != null) {
                                SpenSettingSelectionLayout.this.mActionListener.onMoved();
                                break;
                            }
                            break;
                        case 2:
                            if (SpenSettingSelectionLayout.this.mMoveSettingLayout) {
                                int mMoveX = x - SpenSettingSelectionLayout.this.mXDelta;
                                int mMoveY = y - SpenSettingSelectionLayout.this.mYDelta;
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                if (mMoveX > (SpenSettingSelectionLayout.this.mCanvasLayout.getWidth() - SpenSettingSelectionLayout.this.getWidth()) - 2) {
                                    mMoveX = (SpenSettingSelectionLayout.this.mCanvasLayout.getWidth() - SpenSettingSelectionLayout.this.getWidth()) - 2;
                                }
                                if (mMoveY > SpenSettingSelectionLayout.this.mMovableRect.height() - SpenSettingSelectionLayout.this.getHeight()) {
                                    mMoveY = SpenSettingSelectionLayout.this.mMovableRect.height() - SpenSettingSelectionLayout.this.getHeight();
                                }
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                ViewGroup.MarginLayoutParams Params = (ViewGroup.MarginLayoutParams) SpenSettingSelectionLayout.this.getLayoutParams();
                                Params.leftMargin = mMoveX;
                                Params.topMargin = mMoveY;
                                SpenSettingSelectionLayout.this.setLayoutParams(Params);
                                break;
                            }
                            break;
                    }
                    SpenSettingSelectionLayout.this.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
        };
        this.mOnConsumedTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpenSettingSelectionLayout.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mGestureListener = new GestureDetector.OnGestureListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout.3
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
                if (SpenSettingSelectionLayout.this.mNeedCalculateMargin) {
                    int[] location = new int[2];
                    SpenSettingSelectionLayout.this.mCanvasLayout.getLocationOnScreen(location);
                    SpenSettingSelectionLayout.this.mLeftMargin = (int) ((event.getRawX() - location[0]) - event.getX());
                    SpenSettingSelectionLayout.this.mTopMargin = (int) ((event.getRawY() - location[1]) - event.getY());
                    int[] rootLocation = new int[2];
                    SpenSettingSelectionLayout.this.getRootView().getLocationOnScreen(rootLocation);
                    SpenSettingSelectionLayout.this.mNeedCalculateMargin = false;
                }
                if (SpenSettingSelectionLayout.this.mFirstLongPress) {
                    SpenSettingSelectionLayout.this.mTitleLayout.performHapticFeedback(1);
                    SpenSettingSelectionLayout.this.mFirstLongPress = false;
                }
                Rect r = SpenSettingSelectionLayout.this.getMovableRect();
                SpenSettingSelectionLayout.this.mMovableRect.set(r);
                SpenSettingSelectionLayout.this.mMoveSettingLayout = true;
                SpenSettingSelectionLayout.this.mIndicator.setVisibility(8);
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent event) {
                SpenSettingSelectionLayout.this.mMovableRect.set(SpenSettingSelectionLayout.this.getMovableRect());
                int x = (int) event.getRawX();
                int y = (int) event.getRawY();
                ViewGroup.MarginLayoutParams Params = (ViewGroup.MarginLayoutParams) SpenSettingSelectionLayout.this.getLayoutParams();
                SpenSettingSelectionLayout.this.mXDelta = x - Params.leftMargin;
                SpenSettingSelectionLayout.this.mYDelta = y - Params.topMargin;
                return true;
            }
        };
        this.mExitButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingSelectionLayout.this.setVisibility(8);
            }
        };
        this.mSelectionTypeListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingSelectionLayout.this.selectionTypeSetting(v);
            }
        };
        this.mOnKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout.6
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (view.isFocused() && event.getAction() == 1) {
                            view.performClick();
                            break;
                        }
                        break;
                }
                return false;
            }
        };
        this.mLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout.7
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                try {
                    if (SpenSettingSelectionLayout.this.getVisibility() == 8) {
                        return;
                    }
                    SpenSettingSelectionLayout.this.mMovableRect.set(SpenSettingSelectionLayout.this.getMovableRect());
                    if (SpenSettingSelectionLayout.this.mIsRotated) {
                        SpenSettingSelectionLayout.this.rotatePosition();
                        SpenSettingSelectionLayout.this.mIsRotated = false;
                    } else {
                        SpenSettingSelectionLayout.this.checkPosition();
                    }
                    Handler handler = new Handler();
                    handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SpenSettingSelectionLayout.this.requestLayout();
                        }
                    });
                } catch (NullPointerException e) {
                }
            }
        };
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

    public SpenSettingSelectionLayout(Context context, String customImagePath, RelativeLayout relativeLayout, float ratio) {
        super(context);
        this.mScale = 1.0f;
        this.mSettingInfo = null;
        this.mGestureDetector = null;
        this.mMoveSettingLayout = false;
        this.mNeedCalculateMargin = true;
        this.mFirstLongPress = true;
        this.mIsRotated = false;
        this.mActionListener = null;
        this.mVisibilityListener = null;
        this.mViewMode = 0;
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (SpenSettingSelectionLayout.this.mGestureDetector == null || !SpenSettingSelectionLayout.this.mGestureDetector.onTouchEvent(event)) {
                    int x = (int) event.getRawX();
                    int y = (int) event.getRawY();
                    switch (event.getAction()) {
                        case 1:
                            if (SpenSettingSelectionLayout.this.mMoveSettingLayout && SpenSettingSelectionLayout.this.mActionListener != null) {
                                SpenSettingSelectionLayout.this.mActionListener.onMoved();
                                break;
                            }
                            break;
                        case 2:
                            if (SpenSettingSelectionLayout.this.mMoveSettingLayout) {
                                int mMoveX = x - SpenSettingSelectionLayout.this.mXDelta;
                                int mMoveY = y - SpenSettingSelectionLayout.this.mYDelta;
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                if (mMoveX > (SpenSettingSelectionLayout.this.mCanvasLayout.getWidth() - SpenSettingSelectionLayout.this.getWidth()) - 2) {
                                    mMoveX = (SpenSettingSelectionLayout.this.mCanvasLayout.getWidth() - SpenSettingSelectionLayout.this.getWidth()) - 2;
                                }
                                if (mMoveY > SpenSettingSelectionLayout.this.mMovableRect.height() - SpenSettingSelectionLayout.this.getHeight()) {
                                    mMoveY = SpenSettingSelectionLayout.this.mMovableRect.height() - SpenSettingSelectionLayout.this.getHeight();
                                }
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                ViewGroup.MarginLayoutParams Params = (ViewGroup.MarginLayoutParams) SpenSettingSelectionLayout.this.getLayoutParams();
                                Params.leftMargin = mMoveX;
                                Params.topMargin = mMoveY;
                                SpenSettingSelectionLayout.this.setLayoutParams(Params);
                                break;
                            }
                            break;
                    }
                    SpenSettingSelectionLayout.this.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
        };
        this.mOnConsumedTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpenSettingSelectionLayout.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mGestureListener = new GestureDetector.OnGestureListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout.3
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
                if (SpenSettingSelectionLayout.this.mNeedCalculateMargin) {
                    int[] location = new int[2];
                    SpenSettingSelectionLayout.this.mCanvasLayout.getLocationOnScreen(location);
                    SpenSettingSelectionLayout.this.mLeftMargin = (int) ((event.getRawX() - location[0]) - event.getX());
                    SpenSettingSelectionLayout.this.mTopMargin = (int) ((event.getRawY() - location[1]) - event.getY());
                    int[] rootLocation = new int[2];
                    SpenSettingSelectionLayout.this.getRootView().getLocationOnScreen(rootLocation);
                    SpenSettingSelectionLayout.this.mNeedCalculateMargin = false;
                }
                if (SpenSettingSelectionLayout.this.mFirstLongPress) {
                    SpenSettingSelectionLayout.this.mTitleLayout.performHapticFeedback(1);
                    SpenSettingSelectionLayout.this.mFirstLongPress = false;
                }
                Rect r = SpenSettingSelectionLayout.this.getMovableRect();
                SpenSettingSelectionLayout.this.mMovableRect.set(r);
                SpenSettingSelectionLayout.this.mMoveSettingLayout = true;
                SpenSettingSelectionLayout.this.mIndicator.setVisibility(8);
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent event) {
                SpenSettingSelectionLayout.this.mMovableRect.set(SpenSettingSelectionLayout.this.getMovableRect());
                int x = (int) event.getRawX();
                int y = (int) event.getRawY();
                ViewGroup.MarginLayoutParams Params = (ViewGroup.MarginLayoutParams) SpenSettingSelectionLayout.this.getLayoutParams();
                SpenSettingSelectionLayout.this.mXDelta = x - Params.leftMargin;
                SpenSettingSelectionLayout.this.mYDelta = y - Params.topMargin;
                return true;
            }
        };
        this.mExitButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingSelectionLayout.this.setVisibility(8);
            }
        };
        this.mSelectionTypeListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingSelectionLayout.this.selectionTypeSetting(v);
            }
        };
        this.mOnKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout.6
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (view.isFocused() && event.getAction() == 1) {
                            view.performClick();
                            break;
                        }
                        break;
                }
                return false;
            }
        };
        this.mLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout.7
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                try {
                    if (SpenSettingSelectionLayout.this.getVisibility() == 8) {
                        return;
                    }
                    SpenSettingSelectionLayout.this.mMovableRect.set(SpenSettingSelectionLayout.this.getMovableRect());
                    if (SpenSettingSelectionLayout.this.mIsRotated) {
                        SpenSettingSelectionLayout.this.rotatePosition();
                        SpenSettingSelectionLayout.this.mIsRotated = false;
                    } else {
                        SpenSettingSelectionLayout.this.checkPosition();
                    }
                    Handler handler = new Handler();
                    handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingSelectionLayout.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SpenSettingSelectionLayout.this.requestLayout();
                        }
                    });
                } catch (NullPointerException e) {
                }
            }
        };
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
        setClickable(true);
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

    private View titleText() {
        TextView titleView = new TextView(this.mContext);
        titleView.setLayoutParams(new FrameLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(41.0f)));
        titleView.setTextColor(-1);
        titleView.setGravity(19);
        titleView.setFocusable(true);
        titleView.setSingleLine(true);
        titleView.setEllipsize(TextUtils.TruncateAt.END);
        titleView.setText(this.mStringUtil.setString("string_selection_mode"));
        titleView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(16.0f));
        titleView.setTypeface(Typeface.SANS_SERIF);
        titleView.setContentDescription(this.mStringUtil.setString("string_selection_mode"));
        titleView.setPadding(this.mDrawableImg.getIntValueAppliedDensity(10.0f) + 9, 15, 0, 0);
        return titleView;
    }

    private ViewGroup bodyLayout() {
        RelativeLayout layout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layout.setLayoutParams(layoutParams);
        layout.addView(bodyBg());
        this.mSelectionTypeLayout = selectionTypeLayout();
        layout.addView(this.mSelectionTypeLayout);
        return layout;
    }

    private ViewGroup bodyBg() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.setLayoutParams(layoutParams);
        ImageView bodyLeft = new ImageView(this.mContext);
        RelativeLayout.LayoutParams bodyLeftParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(114.0f), this.mDrawableImg.getIntValueAppliedDensity(42.0f));
        bodyLeftParam.alignWithParent = true;
        bodyLeftParam.addRule(9);
        bodyLeftParam.addRule(10);
        bodyLeft.setLayoutParams(bodyLeftParam);
        ImageView bodyRight = new ImageView(this.mContext);
        RelativeLayout.LayoutParams bodyRightParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(114.0f), this.mDrawableImg.getIntValueAppliedDensity(42.0f));
        bodyRightParam.alignWithParent = true;
        bodyRightParam.addRule(11);
        bodyRightParam.addRule(10);
        bodyRight.setLayoutParams(bodyRightParam);
        this.mImageLoader.addViewSetBackgroundImageLoad(bodyLeft, titleBodyLeftPath);
        this.mImageLoader.addViewSetBackgroundImageLoad(bodyRight, titleBodyRightPath);
        linearLayout.setOnTouchListener(this.mOnConsumedTouchListener);
        linearLayout.addView(bodyLeft);
        linearLayout.addView(bodyRight);
        return linearLayout;
    }

    public void close() {
        this.mCanvasView = null;
        this.mCanvasLayout = null;
        this.mContext = null;
        if (this.mDrawableImg != null) {
            this.mDrawableImg.unbindDrawables(this.mExitButton);
            this.mExitButton = null;
            this.mDrawableImg.unbindDrawables(this.mLassoButton);
            this.mLassoButton = null;
            this.mDrawableImg.unbindDrawables(this.mRectangleButton);
            this.mRectangleButton = null;
            this.mDrawableImg.unbindDrawables(this.mIndicator);
            this.mIndicator = null;
            if (this.mSelectionTypeLayout != null) {
                for (int i = 0; i < this.mSelectionTypeLayout.getChildCount(); i++) {
                    this.mDrawableImg.unbindDrawables(this.mSelectionTypeView[i]);
                    this.mSelectionTypeView[i] = null;
                }
            }
            this.mSelectionTypeView = null;
            this.mDrawableImg.unbindDrawables(this.mSelectionTypeLayout);
            this.mSelectionTypeLayout = null;
            this.mDrawableImg.unbindDrawables(this.mTitleLayout);
            this.mTitleLayout = null;
            this.mDrawableImg.unbindDrawables(this.mBodyLayout);
            this.mBodyLayout = null;
            this.mActionListener = null;
            this.mDrawableImg.unbindDrawables(this);
            this.mDrawableImg = null;
            this.mStringUtil = null;
            this.mSettingInfo = null;
            this.mGestureDetector = null;
            this.mOnTouchListener = null;
            this.mOnConsumedTouchListener = null;
            this.mGestureListener = null;
            this.mExitButtonListener = null;
            this.mSelectionTypeListner = null;
            this.mActionListener = null;
            this.mVisibilityListener = null;
            this.mImageLoader.close();
            this.mImageLoader = null;
        }
    }

    protected void initView() {
        totalLayout();
        RelativeLayout selectionTypeViewGroup = (RelativeLayout) this.mSelectionTypeLayout;
        this.mSelectionTypeView = new View[selectionTypeViewGroup.getChildCount()];
        for (int i = 0; i < selectionTypeViewGroup.getChildCount(); i++) {
            this.mSelectionTypeView[i] = selectionTypeViewGroup.getChildAt(i);
        }
        this.mSettingInfo = new SpenSettingSelectionInfo();
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
        if (this.mSelectionTypeView != null) {
            for (int i = 0; i <= 1; i++) {
                if (this.mSelectionTypeView[i] != null) {
                    this.mSelectionTypeView[i].setOnClickListener(this.mSelectionTypeListner);
                }
            }
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
        exitButton.setPadding(0, 0, 0, 0);
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

    private ViewGroup selectionTypeLayout() {
        RelativeLayout localLinearLayout = new RelativeLayout(this.mContext);
        localLinearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(42.0f)));
        localLinearLayout.setPadding(0, this.mDrawableImg.getIntValueAppliedDensity(5.0f), 0, this.mDrawableImg.getIntValueAppliedDensity(4.0f));
        RelativeLayout.LayoutParams lassoLayoutParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(106.5f), this.mDrawableImg.getIntValueAppliedDensity(33.0f));
        lassoLayoutParams.alignWithParent = true;
        lassoLayoutParams.addRule(9);
        lassoLayoutParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(8.0f), 0, 0, 0);
        int[] arrayOfStates1 = {R.attr.state_pressed};
        int[][] arrayOfStates = {arrayOfStates1, new int[0]};
        int[] textColor = {-1, -16777216};
        TextView txtLassoString = new TextView(this.mContext);
        RelativeLayout.LayoutParams txtLassoStringParams = new RelativeLayout.LayoutParams(-2, -1);
        txtLassoString.setText(this.mStringUtil.setString("string_lasso"));
        txtLassoString.setSingleLine(true);
        txtLassoString.setTextColor(new ColorStateList(arrayOfStates, textColor));
        txtLassoString.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(12.0f));
        txtLassoString.setCompoundDrawablesWithIntrinsicBounds(this.mDrawableImg.setDrawableImg(lassoPath, 24, 24), (Drawable) null, (Drawable) null, (Drawable) null);
        txtLassoString.setCompoundDrawablePadding(this.mDrawableImg.getIntValueAppliedDensity(2.0f));
        txtLassoString.setGravity(17);
        txtLassoString.setPadding(0, this.mDrawableImg.getIntValueAppliedDensity(1.25f), 0, 0);
        txtLassoString.setLayoutParams(txtLassoStringParams);
        this.mLassoButton = new RelativeLayout(this.mContext);
        this.mLassoButton.setFocusable(true);
        this.mLassoButton.setGravity(17);
        this.mLassoButton.setLayoutParams(lassoLayoutParams);
        this.mLassoButton.addView(txtLassoString);
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mLassoButton, btnNoramlPath, btnPressPath, btnFocusPath);
        this.mLassoButton.setOnKeyListener(this.mOnKeyListener);
        localLinearLayout.addView(this.mLassoButton);
        RelativeLayout.LayoutParams rectangleLayoutParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(106.5f), this.mDrawableImg.getIntValueAppliedDensity(33.0f));
        rectangleLayoutParams.alignWithParent = true;
        rectangleLayoutParams.addRule(11);
        rectangleLayoutParams.setMargins(0, 0, this.mDrawableImg.getIntValueAppliedDensity(8.0f), 0);
        arrayOfStates1[0] = 16842919;
        arrayOfStates[0] = arrayOfStates1;
        arrayOfStates[1] = new int[0];
        textColor[0] = -1;
        textColor[1] = -16777216;
        TextView txtRectangleString = new TextView(this.mContext);
        RelativeLayout.LayoutParams txtRectangleStringParams = new RelativeLayout.LayoutParams(-2, -1);
        txtRectangleString.setText(this.mStringUtil.setString("string_rectangle"));
        txtRectangleString.setSingleLine(true);
        txtRectangleString.setCompoundDrawablesWithIntrinsicBounds(this.mDrawableImg.setDrawableImg(rectPath, 24, 24), (Drawable) null, (Drawable) null, (Drawable) null);
        txtRectangleString.setCompoundDrawablePadding(this.mDrawableImg.getIntValueAppliedDensity(2.0f));
        txtRectangleString.setTextColor(new ColorStateList(arrayOfStates, textColor));
        txtRectangleString.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(12.0f));
        txtRectangleString.setGravity(17);
        txtRectangleString.setPadding(0, this.mDrawableImg.getIntValueAppliedDensity(1.0f), 0, 0);
        txtRectangleString.setLayoutParams(txtRectangleStringParams);
        this.mRectangleButton = new RelativeLayout(this.mContext);
        this.mRectangleButton.setFocusable(true);
        this.mRectangleButton.setGravity(17);
        this.mRectangleButton.setLayoutParams(rectangleLayoutParams);
        this.mRectangleButton.addView(txtRectangleString);
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mRectangleButton, btnNoramlPath, btnPressPath, btnFocusPath);
        this.mRectangleButton.setOnKeyListener(this.mOnKeyListener);
        localLinearLayout.addView(this.mRectangleButton);
        return localLinearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectionTypeSetting(View selectedView) {
        SpenSettingSelectionInfo info;
        SpenSettingSelectionInfo info2;
        for (int i = 0; i < this.mSelectionTypeView.length; i++) {
            if (this.mSelectionTypeView[i] != null) {
                this.mSelectionTypeView[i].setSelected(false);
                if (selectedView.equals(this.mSelectionTypeView[i])) {
                    this.mSelectionTypeView[i].invalidate();
                    if (i == 0) {
                        this.mSettingInfo.type = 0;
                    } else if (i == 1) {
                        this.mSettingInfo.type = 1;
                    }
                    switch (i) {
                        case 0:
                            this.mLassoButton.setSelected(true);
                            this.mRectangleButton.setSelected(false);
                            if (this.mCanvasView != null && (info2 = this.mCanvasView.getSelectionSettingInfo()) != null) {
                                info2.type = 0;
                                this.mCanvasView.setSelectionSettingInfo(info2);
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            this.mLassoButton.setSelected(false);
                            this.mRectangleButton.setSelected(true);
                            if (this.mCanvasView != null && (info = this.mCanvasView.getSelectionSettingInfo()) != null) {
                                info.type = 1;
                                this.mCanvasView.setSelectionSettingInfo(info);
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
        Log.v(TAG, "==== SettingSelection ====");
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
        int minHeight = this.mDrawableImg.getIntValueAppliedDensity(83.0f);
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

    public SpenSettingSelectionInfo getInfo() {
        return this.mSettingInfo;
    }

    public void setViewMode(int viewMode) {
        this.mViewMode = viewMode;
        if (this.mViewMode == 0) {
            this.mSelectionTypeLayout.setVisibility(0);
        } else if (this.mViewMode == 1) {
            this.mBodyLayout.setVisibility(8);
            this.mTitleLayout.setVisibility(0);
        } else {
            this.mViewMode = 0;
            this.mSelectionTypeLayout.setVisibility(0);
        }
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
        }
    }

    public void setInfo(SpenSettingSelectionInfo settingSelectionInfo) {
        if (settingSelectionInfo != null) {
            this.mSettingInfo.type = settingSelectionInfo.type;
            if (settingSelectionInfo.type == 0) {
                if (this.mLassoButton != null) {
                    this.mLassoButton.setSelected(true);
                    this.mRectangleButton.setSelected(false);
                    this.mLassoButton.invalidate();
                    return;
                }
                return;
            }
            if (this.mRectangleButton != null) {
                this.mLassoButton.setSelected(false);
                this.mRectangleButton.setSelected(true);
                this.mRectangleButton.invalidate();
            }
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
