package com.samsung.android.sdk.pen.settingui;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.infraware.office.evengine.InterfaceC0507E;
import com.samsung.android.sdk.pen.SpenSettingTextInfo;
import com.samsung.android.sdk.pen.SpenSettingViewInterface;
import com.samsung.android.sdk.pen.settingui.SPenFontNameDropdown;
import com.samsung.android.sdk.pen.settingui.SPenFontSizeDropdown;
import com.samsung.android.sdk.pen.settingui.SpenColorGradationView;
import com.samsung.android.sdk.pen.settingui.SpenColorPaletteView;
import com.samsung.android.sdk.pen.settingui.SpenScrollView;
import com.samsung.android.sdk.pen.util.SpenFont;
import com.sds.coolots.common.controller.NativeFormatInterface;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class SpenSettingTextLayout extends LinearLayout {
    protected static final int BODY_LAYOUT_HEIGHT = 238;
    protected static final int BOTTOM_LAYOUT_HEIGHT = 16;
    protected static final int EXIT_BUTTON_HEIGHT = 36;
    protected static final int EXIT_BUTTON_WIDTH = 38;
    protected static final int GRADIENT_LAYOUT_HEIGHT = 52;
    protected static final int LINE_BUTTON_BOTTOM_MARGIN = 8;
    protected static final int LINE_BUTTON_HEIGHT = 19;
    protected static final int LINE_BUTTON_TOP_MARGIN = 9;
    protected static final int LINE_BUTTON_WIDTH = 1;
    private static final String TAG = "settingui-settingText";
    protected static final int TEXT_SETTING_BOLD = 2;
    protected static final int TEXT_SETTING_ITALIC = 3;
    protected static final int TEXT_SETTING_UNDERLINE = 4;
    protected static final int TITLE_LAYOUT_HEIGHT = 41;
    protected static final int TOTAL_LAYOUT_WIDTH = 250;
    public static final int VIEW_MODE_COLOR = 4;
    public static final int VIEW_MODE_MINIMUM = 1;
    public static final int VIEW_MODE_MINIMUM_WITHOUT_PREVIEW = 2;
    public static final int VIEW_MODE_NORMAL = 0;
    public static final int VIEW_MODE_PARAGRAPH = 5;
    public static final int VIEW_MODE_STYLE = 3;
    public static final int VIEW_MODE_TITLE = 6;
    private static final String bottomExpandPath = "snote_popup_bg_expand";
    private static final String bottomExpandPressPath = "snote_popup_bg_expand_press";
    private static final String bottomHandlePath = "snote_popup_handler";
    private static final String exitPath = "snote_popup_close";
    private static final String exitPressPath = "snote_popup_close_press";
    private static final String exitfocusPath = "snote_popup_close_focus";
    private static final String grayBodyLeftPath = "snote_popup_bg02_left";
    private static final String grayBodyRightPath = "snote_popup_bg02_right";
    private static final String lefBgDimPath = "snote_popup_arrow_left_dim";
    private static final String lefBgFocusPath = "snote_popup_arrow_left_focus";
    private static final String lefBgPressPath = "snote_popup_arrow_left_press";
    private static final String leftBgPath = "snote_popup_arrow_left_normal";
    private static final String lightBodyLeftPath = "snote_popup_bg_left";
    private static final String lightBodyRightPath = "snote_popup_bg_right";
    private static final String linePath = "snote_popup_divider";
    protected static final String mBoldIconPath = "snote_popup_textoption_bold";
    protected static final String mBoldIconPressPath = "snote_text_icon_bold_press";
    private static final String mBoldLeftFocusPath = "snote_popup_option_btn_left_focus";
    private static final String mBoldLeftNomarPath = "snote_popup_option_btn_left_normal";
    private static final String mBoldLeftPressPath = "snote_popup_option_btn_left_press_1";
    protected static final String mButtonBgFocusPath = "snote_popup_btn_focus";
    protected static final String mButtonBgPath = "snote_popup_btn_normal";
    protected static final String mButtonBgPressPath = "snote_popup_btn_press";
    protected static final String mDefaultPath = "";
    private static final String mDropdownFocusPath = "snote_dropdown_focused";
    private static final String mDropdownNormalPath = "snote_dropdown_normal";
    private static final String mDropdownPressPath = "snote_dropdown_pressed";
    protected static final String mItalicIconPath = "snote_popup_textoption_italic";
    protected static final String mItalicIconPressPath = "snote_text_icon_italic_press";
    private static final String mItalicLeftFocusPath = "snote_popup_option_btn_center_focus";
    private static final String mItalicLeftNomarPath = "snote_popup_option_btn_center_normal";
    private static final String mItalicLeftPressPath = "snote_popup_option_btn_center_press";
    protected static final String mPreviewBgPath = "snote_popup_preview_bg";
    protected static final String mSpinnerBgEnablePath = "tw_spinner_disabled_holo_light";
    protected static final String mSpinnerBgFocusPath = "tw_spinner_focused_holo_light";
    protected static final String mSpinnerBgPath = "tw_spinner_default_holo_light";
    protected static final String mSpinnerBgPressPath = "tw_spinner_pressed_holo_light";
    protected static final String mSpinnerBgSelectPath = "tw_spinner_selected_holo_light";
    protected static final String mSpinnerListBgPath = "snote_popup_option_btn_normal";
    protected static final String mSpinnerListFocusBgPath = "snote_popup_option_btn_focus";
    protected static final String mSpinnerListPressBgPath = "snote_popup_option_btn_press";
    private static final String mUnderLeftFocusPath = "snote_popup_option_btn_right_focus";
    private static final String mUnderLeftNomarPath = "snote_popup_option_btn_right_normal";
    private static final String mUnderLeftPressPath = "snote_popup_option_btn_right_press_1";
    protected static final String mUnderLineIconPath = "snote_popup_textoption_underline";
    protected static final String mUnderLineIconPressPath = "snote_text_icon_underline_press";
    private static final String rightBgDimPath = "snote_popup_arrow_right_dim";
    private static final String rightBgFocusPath = "snote_popup_arrow_right_focus";
    private static final String rightBgPath = "snote_popup_arrow_right_normal";
    private static final String rightBgPressPath = "snote_popup_arrow_right_press";
    private static final String titleCenterPath = "snote_popup_title_center";
    private static final String titleLeftPath = "snote_popup_title_left";
    private static final String titleRightPath = "snote_popup_title_right";
    private int deltaOfFirstTime;
    private int deltaPreview;
    protected boolean isChangePosition;
    private boolean isFirstTime;
    private DisplayMetrics localDisplayMetrics;
    protected ActionListener mActionListener;
    protected ImageButton mAlignCenterBtn;
    protected ImageButton mAlignLeftBtn;
    protected ImageButton mAlignRightBtn;
    protected View mBodyBg;
    protected View mBodyLayout;
    protected int mBodyLayoutHeight;
    protected ImageButton mBoldBtn;
    protected ImageView mBottomExtendBg;
    protected View mBottomLayout;
    protected RelativeLayout mCanvasLayout;
    protected SpenSettingViewInterface mCanvasView;
    protected int mCanvasWidth;
    protected SpenColorGradationView mColorGradationView;
    protected SpenColorPaletteView mColorPaletteView;
    protected View mColorPickerColor;
    private final SpenColorGradationView.onColorChangedListener mColorPickerColorChangeListenerText;
    private final View.OnClickListener mColorPickerColorListener;
    protected SpenColorPickerLayout mColorPickerSetting;
    protected View mColorPickerSettingExitButton;
    protected View mColorSelectedAndPicker;
    protected Context mContext;
    private String mCurrentFontName;
    private String mCurrentFontSize;
    protected int[] mCurrentLocation;
    protected SPenImageUtil mDrawableImg;
    protected View mExitButton;
    private final View.OnClickListener mExitButtonListener;
    protected boolean mExpandFlag;
    View.OnHoverListener mExpendBarHoverListener;
    View.OnTouchListener mExpendBarListener;
    protected boolean mFirstLongPress;
    protected Spinner mFontLineSpaceSpinner;
    private SPenFontNameDropdown mFontNameDropdown;
    private Button mFontSizeButton;
    private SPenFontSizeDropdown mFontSizeDropdown;
    private final View.OnClickListener mFontSizeOnClickListener;
    protected ViewGroup mFontSizeSpinnerOptButton;
    protected Button mFontSizeSpinnerView;
    private Button mFontTypeButton;
    private final View.OnClickListener mFontTypeOnClickListener;
    protected ViewGroup mFontTypeSpinnerView;
    protected GestureDetector mGestureDetector;
    private final GestureDetector.OnGestureListener mGestureDetectorListener;
    private final View.OnHoverListener mHoverListener;
    private SpenImageLoader mImageLoader;
    protected ImageButton mIndentLeftBtn;
    protected ImageButton mIndentRightBtn;
    protected ImageView mIndicator;
    protected boolean mIsRotated;
    protected boolean mIsRotated2;
    protected ImageButton mItalicBtn;
    View.OnLayoutChangeListener mLayoutChangeListener;
    protected int mLeftMargin;
    protected Rect mMovableRect;
    protected boolean mMoveSettingLayout;
    protected boolean mNeedCalculateMargin;
    protected int[] mOldLocation;
    protected Rect mOldMovableRect;
    private final SpenColorPaletteView.OnColorChangedListener mOnColorChangedListenerText;
    private final View.OnTouchListener mOnConsumedTouchListener;
    private final View.OnTouchListener mOnTouchListener;
    private final View.OnClickListener mPaletteBackButtonListener;
    protected View mPaletteBg;
    protected View mPaletteLeftButton;
    private final View.OnClickListener mPaletteNextButtonListener;
    protected View mPaletteRightButton;
    protected View mPaletteView;
    protected boolean mParaLineSpinner1stSelect;
    protected View mParagraphSetting;
    protected View mPickerView;
    protected int mPreCanvasFingerAction;
    protected int mPreCanvasPenAction;
    protected float mScale;
    protected ImageView mScrollHandle;
    protected SpenScrollView mScrollView;
    private final SpenScrollView.scrollChangedListener mScrollViewListner;
    protected int mScrollY;
    protected SpenSettingTextInfo mSettingInfo;

    @SuppressLint({"NewApi"})
    private final View.OnClickListener mTextAlignSettingListener;
    protected ArrayList<String> mTextFontSizeList;

    @SuppressLint({"NewApi"})
    private final View.OnClickListener mTextIndentSettingListener;

    @SuppressLint({"NewApi"})
    private final AdapterView.OnItemSelectedListener mTextLineSpacingSettingListener;
    private final View.OnClickListener mTextOptButtonListener;
    protected SpenTextPreView mTextPreView;
    protected View mTextSettingPreview;
    protected View[] mTextSizeButtonView;
    protected SPenTextUtil mTextUtil;
    protected View mTitleLayout;
    protected int mTopMargin;
    protected ImageButton mUnderlineBtn;
    protected int mViewMode;
    protected ViewListener mVisibilityListener;
    protected int mXDelta;
    protected int mYDelta;
    protected static int mSdkVersion = Build.VERSION.SDK_INT;
    protected static final String mLeftIconPath = "snote_text_left";
    protected static final String mCenterIocnPath = "snote_text_center";
    protected static final String mRightIconPath = "snote_text_right";
    protected static final String mLeftIndentIconPath = "snote_text_all_left";
    protected static final String mRightIndentIconPath = "snote_text_all_right";
    protected static final String mLeftIconPressPath = "snote_text_left_press";
    protected static final String mCenterIconPressPath = "snote_text_center_press";
    protected static final String mRightIconPressPath = "snote_text_right_press";
    private static final String mOptionBgPath = "snote_option_in_bg";
    private static final String mScrollHandelNormal = "snote_popup_scroll_handle_n";

    public interface ActionListener {
        void onMoved();

        void onResized();
    }

    public interface ViewListener {
        void onVisibilityChanged(int i);
    }

    enum scrollBar {
        SCROLL_NORMAL,
        SCROLL_PRESS;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static scrollBar[] valuesCustom() {
            scrollBar[] scrollbarArrValuesCustom = values();
            int length = scrollbarArrValuesCustom.length;
            scrollBar[] scrollbarArr = new scrollBar[length];
            System.arraycopy(scrollbarArrValuesCustom, 0, scrollbarArr, 0, length);
            return scrollbarArr;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        Log.d(TAG, "onConfig text " + getVisibility());
        try {
            if (getVisibility() != 8) {
                this.mOldMovableRect.set(getMovableRect());
                getLocationOnScreen(this.mOldLocation);
            }
            this.mIsRotated = true;
            if (this.mColorPickerSetting != null) {
                this.mColorPickerSetting.setRotation();
            }
            if (this.mFontSizeDropdown != null) {
                this.mFontSizeDropdown.updatePosition();
            }
            if (this.mFontNameDropdown != null) {
                this.mFontNameDropdown.updatePosition();
            }
            super.onConfigurationChanged(newConfig);
        } catch (NullPointerException e) {
        }
    }

    public SpenSettingTextLayout(Context context, String customImagePath, HashMap<String, String> fontName, RelativeLayout relativeLayout) {
        super(context);
        this.mCurrentFontSize = SimpleUserInfo.STATE_DENY;
        this.mExpandFlag = false;
        this.mBodyLayoutHeight = -2;
        this.mActionListener = null;
        this.mVisibilityListener = null;
        this.mParaLineSpinner1stSelect = true;
        this.mTextFontSizeList = new ArrayList<>();
        this.mGestureDetector = null;
        this.mMoveSettingLayout = false;
        this.mScrollY = 0;
        this.mNeedCalculateMargin = true;
        this.mFirstLongPress = true;
        this.mIsRotated = false;
        this.mIsRotated2 = false;
        this.isChangePosition = false;
        this.mScale = 1.0f;
        this.mCanvasWidth = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_PPT_SLIDEMOVEPREV_EVENT;
        this.mViewMode = 0;
        this.deltaPreview = 0;
        this.isFirstTime = false;
        this.deltaOfFirstTime = 0;
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (SpenSettingTextLayout.this.mGestureDetector == null || !SpenSettingTextLayout.this.mGestureDetector.onTouchEvent(event)) {
                    int x = Math.round(event.getRawX());
                    int y = Math.round(event.getRawY());
                    switch (event.getAction()) {
                        case 1:
                            if (SpenSettingTextLayout.this.mMoveSettingLayout && SpenSettingTextLayout.this.mActionListener != null) {
                                SpenSettingTextLayout.this.mActionListener.onMoved();
                                break;
                            }
                            break;
                        case 2:
                            if (SpenSettingTextLayout.this.mMoveSettingLayout) {
                                int mMoveX = x - SpenSettingTextLayout.this.mXDelta;
                                int mMoveY = y - SpenSettingTextLayout.this.mYDelta;
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                if (mMoveX > (SpenSettingTextLayout.this.mCanvasLayout.getWidth() - SpenSettingTextLayout.this.getWidth()) - 2) {
                                    mMoveX = (SpenSettingTextLayout.this.mCanvasLayout.getWidth() - SpenSettingTextLayout.this.getWidth()) - 2;
                                }
                                int minHeight = SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(143.0f + SpenSettingTextLayout.this.deltaPreview);
                                int height = SpenSettingTextLayout.this.getHeight();
                                Log.e(SpenSettingTextLayout.TAG, "height = " + height);
                                Log.i(SpenSettingTextLayout.TAG, "before mMoveY = " + mMoveY);
                                if (height <= minHeight && mMoveY > SpenSettingTextLayout.this.mMovableRect.height() - minHeight) {
                                    mMoveY = SpenSettingTextLayout.this.mMovableRect.height() - minHeight;
                                } else if (mMoveY > SpenSettingTextLayout.this.mMovableRect.height() - height) {
                                    SpenSettingTextLayout.this.setExpandBarPosition((SpenSettingTextLayout.this.mMovableRect.height() - mMoveY) - SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(57.0f));
                                    if (mMoveY > SpenSettingTextLayout.this.mMovableRect.height() - minHeight) {
                                        mMoveY = SpenSettingTextLayout.this.mMovableRect.height() - minHeight;
                                    }
                                }
                                Log.w(SpenSettingTextLayout.TAG, "after mMoveY = " + mMoveY);
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                ViewGroup.MarginLayoutParams Params = (ViewGroup.MarginLayoutParams) SpenSettingTextLayout.this.getLayoutParams();
                                Params.leftMargin = mMoveX;
                                Params.topMargin = mMoveY;
                                SpenSettingTextLayout.this.setLayoutParams(Params);
                                break;
                            }
                            break;
                    }
                    SpenSettingTextLayout.this.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
        };
        this.mHoverListener = new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.2
            @Override // android.view.View.OnHoverListener
            public boolean onHover(View arg0, MotionEvent arg1) {
                return true;
            }
        };
        this.mGestureDetectorListener = new GestureDetector.OnGestureListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.3
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
                if (SpenSettingTextLayout.this.mNeedCalculateMargin) {
                    int[] location = new int[2];
                    SpenSettingTextLayout.this.mCanvasLayout.getLocationOnScreen(location);
                    SpenSettingTextLayout.this.mLeftMargin = Math.round((event.getRawX() - location[0]) - event.getX());
                    SpenSettingTextLayout.this.mTopMargin = Math.round((event.getRawY() - location[1]) - event.getY());
                    int[] rootLocation = new int[2];
                    SpenSettingTextLayout.this.getRootView().getLocationOnScreen(rootLocation);
                    SpenSettingTextLayout.this.mNeedCalculateMargin = false;
                }
                if (SpenSettingTextLayout.this.mFirstLongPress) {
                    SpenSettingTextLayout.this.mTitleLayout.performHapticFeedback(1);
                    SpenSettingTextLayout.this.mFirstLongPress = false;
                }
                Rect r = SpenSettingTextLayout.this.getMovableRect();
                SpenSettingTextLayout.this.mMovableRect.set(r);
                SpenSettingTextLayout.this.mMoveSettingLayout = true;
                SpenSettingTextLayout.this.mIndicator.setVisibility(8);
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent event) {
                SpenSettingTextLayout.this.mMovableRect.set(SpenSettingTextLayout.this.getMovableRect());
                int x = Math.round(event.getRawX());
                int y = Math.round(event.getRawY());
                ViewGroup.MarginLayoutParams Params = (ViewGroup.MarginLayoutParams) SpenSettingTextLayout.this.getLayoutParams();
                SpenSettingTextLayout.this.mXDelta = x - Params.leftMargin;
                SpenSettingTextLayout.this.mYDelta = y - Params.topMargin;
                return true;
            }
        };
        this.mColorPickerColorChangeListenerText = new SpenColorGradationView.onColorChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.4
            @Override // com.samsung.android.sdk.pen.settingui.SpenColorGradationView.onColorChangedListener
            public void onColorChanged(int color, int x, int y) {
                SpenSettingTextLayout.this.mColorPaletteView.setColor(SpenSettingTextLayout.this.mTextPreView.getPreviewTextColor());
                if (SpenSettingTextLayout.this.getVisibility() == 0) {
                    SpenSettingTextLayout.this.mTextPreView.setPreviewTextColor(color);
                    SpenSettingTextLayout.this.mTextPreView.invalidate();
                    if (SpenSettingTextLayout.this.mCanvasView != null) {
                        SpenSettingTextInfo info = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                        info.color = color;
                        SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info);
                        SpenSettingTextLayout.this.mColorPickerSetting.setColorPickerColor(info.color);
                        SpenSettingTextLayout.this.mSettingInfo.color = color;
                    }
                }
            }
        };
        this.mOnColorChangedListenerText = new SpenColorPaletteView.OnColorChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.5
            @Override // com.samsung.android.sdk.pen.settingui.SpenColorPaletteView.OnColorChangedListener
            public void colorChanged(int color, int selectedItem) {
                if (SpenSettingTextLayout.this.getVisibility() == 0) {
                    if (selectedItem == 13) {
                        SpenSettingTextLayout.this.setViewMode(0);
                        if (SpenSettingTextLayout.this.mCanvasView != null) {
                            SpenSettingTextLayout.this.mPreCanvasPenAction = SpenSettingTextLayout.this.mCanvasView.getToolTypeAction(2);
                            SpenSettingTextLayout.this.mPreCanvasFingerAction = SpenSettingTextLayout.this.mCanvasView.getToolTypeAction(1);
                            SpenSettingTextLayout.this.mCanvasView.setToolTypeAction(2, 5);
                            SpenSettingTextLayout.this.mCanvasView.setToolTypeAction(1, 5);
                        }
                        SpenSettingTextLayout.this.mColorPaletteView.setColorPickerMode();
                        SpenSettingTextLayout.this.setVisibility(8);
                        SpenSettingTextLayout.this.mColorPickerSetting.show();
                        return;
                    }
                    if (selectedItem == 12 && !SpenSettingTextLayout.this.isFirstTime) {
                        SpenSettingTextLayout.this.isFirstTime = true;
                        SpenSettingTextLayout.this.mColorGradationView.setVisibility(0);
                        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(118.0f));
                        SpenSettingTextLayout.this.mColorSelectedAndPicker.setLayoutParams(localLayoutParams);
                        SpenSettingTextLayout.this.setExpandBarPosition(SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(SpenSettingTextLayout.this.deltaPreview + SpenSettingTextLayout.BODY_LAYOUT_HEIGHT));
                    }
                    SpenSettingTextLayout.this.mTextPreView.setPreviewTextColor(color);
                    SpenSettingTextLayout.this.mTextPreView.invalidate();
                    if (SpenSettingTextLayout.this.mCanvasView != null) {
                        SpenSettingTextInfo info = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                        SpenSettingTextInfo spenSettingTextInfo = SpenSettingTextLayout.this.mSettingInfo;
                        info.color = color;
                        spenSettingTextInfo.color = color;
                        SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info);
                        SpenSettingTextLayout.this.mColorPickerSetting.setColorPickerColor(info.color);
                    }
                }
            }
        };
        this.mFontSizeOnClickListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingTextLayout.this.mFontSizeDropdown = new SPenFontSizeDropdown(v, SpenSettingTextLayout.this.mTextFontSizeList, SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(36.0f), SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(160.0f), SpenSettingTextLayout.this.mScale);
                SpenSettingTextLayout.this.mFontSizeDropdown.setOnItemSelectListner(new SPenFontSizeDropdown.SizeDropdownSelectListner() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.6.1
                    @Override // com.samsung.android.sdk.pen.settingui.SPenFontSizeDropdown.SizeDropdownSelectListner
                    public void onSelectItem(int position) {
                        if (SpenSettingTextLayout.this.mCanvasView != null) {
                            if (SpenSettingTextLayout.this.mCanvasView.getCanvasWidth() < SpenSettingTextLayout.this.mCanvasView.getCanvasHeight()) {
                                SpenSettingTextLayout.this.mCanvasWidth = SpenSettingTextLayout.this.mCanvasView.getCanvasWidth();
                            } else {
                                SpenSettingTextLayout.this.mCanvasWidth = SpenSettingTextLayout.this.mCanvasView.getCanvasHeight();
                            }
                            if (SpenSettingTextLayout.this.mCanvasWidth == 0) {
                                SpenSettingTextLayout.this.mCanvasWidth = 1080;
                            }
                        } else {
                            SpenSettingTextLayout.this.mCanvasWidth = 1080;
                        }
                        float fontPointPixel = (float) (SpenSettingTextLayout.this.mCanvasWidth / 360.0d);
                        SpenSettingTextLayout.this.mSettingInfo.size = Integer.valueOf(SpenSettingTextLayout.this.mTextFontSizeList.get(position)).intValue() * fontPointPixel;
                        SpenSettingTextLayout.this.mTextPreView.setPreviewTextSize(SpenSettingTextLayout.this.mSettingInfo.size);
                        SpenSettingTextLayout.this.mCurrentFontSize = SpenSettingTextLayout.this.mTextFontSizeList.get(position);
                        SpenSettingTextLayout.this.mFontSizeButton.setText(SpenSettingTextLayout.this.mCurrentFontSize);
                        SpenSettingTextLayout.this.mTextPreView.invalidate();
                        if (SpenSettingTextLayout.this.mCanvasView != null) {
                            SpenSettingTextInfo info = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                            info.size = SpenSettingTextLayout.this.mSettingInfo.size;
                            SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info);
                        }
                    }
                });
                SpenSettingTextLayout.this.mFontSizeDropdown.show(0, 0, SpenSettingTextLayout.this.mCurrentFontSize);
            }
        };
        this.mFontTypeOnClickListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingTextLayout.this.mFontNameDropdown = new SPenFontNameDropdown(v, (ArrayList) SpenFont.getFontList(), SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(170.0f), SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(160.0f), SpenSettingTextLayout.this.mScale);
                SpenSettingTextLayout.this.mFontNameDropdown.setOnItemSelectListner(new SPenFontNameDropdown.NameDropdownSelectListner() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.7.1
                    @Override // com.samsung.android.sdk.pen.settingui.SPenFontNameDropdown.NameDropdownSelectListner
                    public void onSelectItem(int position) {
                        SpenSettingTextLayout.this.mCurrentFontName = SpenFont.getFontList().get(position);
                        SpenSettingTextLayout.this.mTextPreView.setPreviewTypeface(SpenFont.getTypeFace(position));
                        SpenSettingTextLayout.this.mTextPreView.invalidate();
                        if (SpenSettingTextLayout.this.mCanvasView != null) {
                            SpenSettingTextInfo info = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                            info.font = SpenFont.getFontName(SpenFont.getFontList().indexOf(SpenSettingTextLayout.this.mCurrentFontName));
                            SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info);
                        }
                        if (SpenSettingTextLayout.mSdkVersion < 16) {
                            String mTempFontName = SpenSettingTextLayout.this.mCurrentFontName;
                            Paint mPaint = new Paint();
                            int mTextWidth = SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(mPaint.measureText(mTempFontName));
                            if (SpenSettingTextLayout.this.mCurrentFontName == null || mTextWidth < SpenSettingTextLayout.this.mFontTypeButton.getWidth() - SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(33.0f)) {
                                SpenSettingTextLayout.this.mFontTypeButton.setText(SpenSettingTextLayout.this.mCurrentFontName);
                            } else {
                                while (mTextWidth > SpenSettingTextLayout.this.mFontTypeButton.getWidth() - SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(33.0f)) {
                                    mTempFontName = mTempFontName.substring(0, mTempFontName.length() - 1);
                                    mTextWidth = SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(mPaint.measureText(mTempFontName) + mPaint.measureText("..."));
                                }
                                SpenSettingTextLayout.this.mFontTypeButton.setText(String.valueOf(mTempFontName) + "...");
                            }
                        } else {
                            SpenSettingTextLayout.this.mFontTypeButton.setText(SpenSettingTextLayout.this.mCurrentFontName);
                        }
                        SpenSettingTextLayout.this.mFontTypeButton.setTypeface(SpenFont.getTypeFace(position));
                    }
                });
                SpenSettingTextLayout.this.mFontNameDropdown.show(0, 0, SpenSettingTextLayout.this.mCurrentFontName);
            }
        };
        this.mTextOptButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingTextLayout.this.setTextStyle(v);
            }
        };
        this.mExitButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingTextLayout.this.mColorPickerSetting.getColorPickerSettingVisible() == 0) {
                    if (SpenSettingTextLayout.this.mSettingInfo.color != 0) {
                        if (SpenSettingTextLayout.this.mCanvasView != null) {
                            SpenSettingTextLayout.this.mCanvasView.setToolTypeAction(2, SpenSettingTextLayout.this.mPreCanvasPenAction);
                            SpenSettingTextLayout.this.mCanvasView.setToolTypeAction(1, SpenSettingTextLayout.this.mPreCanvasFingerAction);
                            SpenSettingTextInfo info = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                            info.color = SpenSettingTextLayout.this.mSettingInfo.color;
                            SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info);
                        }
                        SpenSettingTextLayout.this.mTextPreView.setPreviewTextColor(SpenSettingTextLayout.this.mSettingInfo.color);
                        SpenSettingTextLayout.this.mTextPreView.invalidate();
                        SpenSettingTextLayout.this.mColorPaletteView.setColor(SpenSettingTextLayout.this.mSettingInfo.color);
                        SpenSettingTextLayout.this.mColorPaletteView.invalidate();
                    }
                    SpenSettingTextLayout.this.mColorPickerSetting.hide();
                }
                SpenSettingTextLayout.this.setVisibility(8);
            }
        };
        this.mColorPickerColorListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingTextLayout.this.mColorPickerSetting.getColorPickerSettingVisible() == 0) {
                    SpenSettingTextLayout.this.mTextPreView.setPreviewTextColor(SpenSettingTextLayout.this.mSettingInfo.color);
                    SpenSettingTextLayout.this.mTextPreView.invalidate();
                    SpenSettingTextLayout.this.mColorPaletteView.setColor(SpenSettingTextLayout.this.mSettingInfo.color);
                    SpenSettingTextLayout.this.mColorPaletteView.invalidate();
                    if (SpenSettingTextLayout.this.mCanvasView != null) {
                        SpenSettingTextLayout.this.mCanvasView.setToolTypeAction(2, SpenSettingTextLayout.this.mPreCanvasPenAction);
                        SpenSettingTextLayout.this.mCanvasView.setToolTypeAction(1, SpenSettingTextLayout.this.mPreCanvasFingerAction);
                        SpenSettingTextInfo info = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                        info.color = SpenSettingTextLayout.this.mSettingInfo.color;
                        SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info);
                    }
                    SpenSettingTextLayout.this.mColorPickerSetting.hide();
                    SpenSettingTextLayout.this.setVisibility(0);
                }
            }
        };
        this.mTextAlignSettingListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v.equals(SpenSettingTextLayout.this.mAlignLeftBtn)) {
                    SpenSettingTextLayout.this.mAlignLeftBtn.setSelected(true);
                    SpenSettingTextLayout.this.mAlignCenterBtn.setSelected(false);
                    SpenSettingTextLayout.this.mAlignRightBtn.setSelected(false);
                    if (SpenSettingTextLayout.this.mCanvasView != null) {
                        SpenSettingTextInfo info = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                        info.align = 0;
                        SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info);
                        return;
                    }
                    return;
                }
                if (v.equals(SpenSettingTextLayout.this.mAlignCenterBtn)) {
                    SpenSettingTextLayout.this.mAlignLeftBtn.setSelected(false);
                    SpenSettingTextLayout.this.mAlignCenterBtn.setSelected(true);
                    SpenSettingTextLayout.this.mAlignRightBtn.setSelected(false);
                    if (SpenSettingTextLayout.this.mCanvasView != null) {
                        SpenSettingTextInfo info2 = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                        info2.align = 2;
                        SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info2);
                        return;
                    }
                    return;
                }
                if (v.equals(SpenSettingTextLayout.this.mAlignRightBtn)) {
                    SpenSettingTextLayout.this.mAlignLeftBtn.setSelected(false);
                    SpenSettingTextLayout.this.mAlignCenterBtn.setSelected(false);
                    SpenSettingTextLayout.this.mAlignRightBtn.setSelected(true);
                    if (SpenSettingTextLayout.this.mCanvasView != null) {
                        SpenSettingTextInfo info3 = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                        info3.align = 1;
                        SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info3);
                    }
                }
            }
        };
        this.mTextIndentSettingListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v.equals(SpenSettingTextLayout.this.mIndentLeftBtn)) {
                    if (SpenSettingTextLayout.this.mCanvasView != null) {
                        SpenSettingTextInfo info = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                        info.lineIndent += 10;
                        SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info);
                        return;
                    }
                    return;
                }
                if (v.equals(SpenSettingTextLayout.this.mIndentRightBtn) && SpenSettingTextLayout.this.mCanvasView != null) {
                    SpenSettingTextInfo info2 = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                    info2.lineIndent -= 10;
                    SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info2);
                }
            }
        };
        this.mPaletteNextButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingTextLayout.this.mColorPaletteView != null) {
                    int index = SpenSettingTextLayout.this.mColorPaletteView.getCurrentTableIndex();
                    if (index == 3) {
                        SpenSettingTextLayout.this.mPaletteLeftButton.setEnabled(true);
                    }
                    SpenSettingTextLayout.this.mColorPaletteView.setNextColorTable(index);
                    SpenSettingTextLayout.this.mColorPaletteView.setSelectBoxPos(SpenSettingTextLayout.this.mSettingInfo.color);
                    if (SpenSettingTextLayout.this.mColorPaletteView.getCurrentTableIndex() == 2) {
                        SpenSettingTextLayout.this.mPaletteRightButton.setEnabled(false);
                    }
                }
            }
        };
        this.mPaletteBackButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingTextLayout.this.mColorPaletteView != null) {
                    int index = SpenSettingTextLayout.this.mColorPaletteView.getCurrentTableIndex();
                    if (index == 2) {
                        SpenSettingTextLayout.this.mPaletteRightButton.setEnabled(true);
                    }
                    SpenSettingTextLayout.this.mColorPaletteView.setBackColorTable(index);
                    SpenSettingTextLayout.this.mColorPaletteView.setSelectBoxPos(SpenSettingTextLayout.this.mSettingInfo.color);
                    if (SpenSettingTextLayout.this.mColorPaletteView.getCurrentTableIndex() == 3) {
                        SpenSettingTextLayout.this.mPaletteLeftButton.setEnabled(false);
                    }
                }
            }
        };
        this.mTextLineSpacingSettingListener = new AdapterView.OnItemSelectedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.15
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(-16777216);
                ((TextView) parent.getChildAt(0)).setTextSize(0, SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(15.0f));
                if (SpenSettingTextLayout.this.mParaLineSpinner1stSelect) {
                    SpenSettingTextLayout.this.mParaLineSpinner1stSelect = false;
                    return;
                }
                int[] arrChange = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 22, 24, 26, 28, 30, 32, 36, 40, 43, 44, 48, 52, 56, 60, 64, 68, 72, 80, 88};
                if (SpenSettingTextLayout.this.mCanvasView != null) {
                    SpenSettingTextInfo info = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                    info.lineSpacingType = 0;
                    info.lineSpacing = arrChange[position];
                    SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        this.mOnConsumedTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.16
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpenSettingTextLayout.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mExpendBarHoverListener = new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.17
            @Override // android.view.View.OnHoverListener
            public boolean onHover(View v, MotionEvent event) {
                return true;
            }
        };
        this.mExpendBarListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int x = Math.round(event.getRawX());
                int y = Math.round(event.getRawY());
                switch (event.getAction()) {
                    case 0:
                        RelativeLayout.LayoutParams bottomParams = (RelativeLayout.LayoutParams) SpenSettingTextLayout.this.mBottomLayout.getLayoutParams();
                        SpenSettingTextLayout.this.mXDelta = x - bottomParams.leftMargin;
                        SpenSettingTextLayout.this.mYDelta = y - bottomParams.topMargin;
                        SpenSettingTextLayout.this.mBottomExtendBg.setPressed(true);
                        break;
                    case 1:
                        if (SpenSettingTextLayout.this.mExpandFlag) {
                            if (SpenSettingTextLayout.this.mActionListener != null) {
                                SpenSettingTextLayout.this.mActionListener.onResized();
                            }
                            SpenSettingTextLayout.this.mExpandFlag = false;
                        }
                        SpenSettingTextLayout.this.mBottomExtendBg.setPressed(false);
                        break;
                    case 2:
                        if (y - SpenSettingTextLayout.this.mYDelta > 0) {
                            SpenSettingTextLayout.this.mExpandFlag = true;
                            SpenSettingTextLayout.this.setExpandBarPosition(y - SpenSettingTextLayout.this.mYDelta);
                            break;
                        }
                        break;
                    case 3:
                        SpenSettingTextLayout.this.mBottomExtendBg.setPressed(false);
                        break;
                }
                SpenSettingTextLayout.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mScrollViewListner = new SpenScrollView.scrollChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.19
            @Override // com.samsung.android.sdk.pen.settingui.SpenScrollView.scrollChangedListener
            public void scrollChanged(int scrollY) {
                SpenSettingTextLayout.this.scroll(scrollY);
                SpenSettingTextLayout.this.mScrollY = scrollY;
                RelativeLayout.LayoutParams PaletteBgParam = new RelativeLayout.LayoutParams(-1, (SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(118.0f) - (SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(SpenSettingTextLayout.this.deltaPreview + SpenSettingTextLayout.BODY_LAYOUT_HEIGHT) - SpenSettingTextLayout.this.mBodyLayoutHeight)) + SpenSettingTextLayout.this.mScrollY);
                PaletteBgParam.setMargins(0, 0, 0, 0);
                if (PaletteBgParam.height >= 0) {
                    SpenSettingTextLayout.this.mPaletteBg.setLayoutParams(PaletteBgParam);
                }
            }
        };
        this.mLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.20
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                try {
                    if (SpenSettingTextLayout.this.getVisibility() == 8) {
                        if (SpenSettingTextLayout.this.mIsRotated) {
                            SpenSettingTextLayout.this.mIsRotated = false;
                            return;
                        }
                        return;
                    }
                    if (!SpenSettingTextLayout.this.mIsRotated && SpenSettingTextLayout.this.mIsRotated2) {
                        SpenSettingTextLayout.this.mIsRotated2 = false;
                    }
                    int[] location = new int[2];
                    SpenSettingTextLayout.this.getLocationOnScreen(location);
                    if (SpenSettingTextLayout.this.mCurrentLocation[0] != location[0] || SpenSettingTextLayout.this.mCurrentLocation[1] != location[1]) {
                        SpenSettingTextLayout.this.isChangePosition = true;
                        SpenSettingTextLayout.this.mCurrentLocation[0] = location[0];
                        SpenSettingTextLayout.this.mCurrentLocation[1] = location[1];
                    }
                    int mMoveableRect = SpenSettingTextLayout.this.mMovableRect.height();
                    SpenSettingTextLayout.this.mMovableRect.set(SpenSettingTextLayout.this.getMovableRect());
                    if (Math.abs(mMoveableRect - SpenSettingTextLayout.this.mMovableRect.height()) > 150 && SpenSettingTextLayout.this.isChangePosition) {
                        if (SpenSettingTextLayout.this.mFontNameDropdown != null) {
                            SpenSettingTextLayout.this.mFontNameDropdown.updatePosition();
                        }
                        if (SpenSettingTextLayout.this.mFontSizeDropdown != null) {
                            SpenSettingTextLayout.this.mFontSizeDropdown.updatePosition();
                        }
                        SpenSettingTextLayout.this.isChangePosition = false;
                    }
                    if (SpenSettingTextLayout.this.mIsRotated) {
                        SpenSettingTextLayout.this.rotatePosition();
                        SpenSettingTextLayout.this.mIsRotated = false;
                        SpenSettingTextLayout.this.mIsRotated2 = true;
                    } else {
                        SpenSettingTextLayout.this.checkPosition();
                    }
                    Handler handler = new Handler();
                    handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SpenSettingTextLayout.this.requestLayout();
                        }
                    });
                } catch (NullPointerException e) {
                }
            }
        };
        this.mContext = context;
        this.mDrawableImg = new SPenImageUtil(context, customImagePath, this.mScale);
        this.mTextUtil = new SPenTextUtil(context);
        this.mImageLoader = new SpenImageLoader(this.mDrawableImg);
        this.mCanvasLayout = relativeLayout;
        this.mCanvasLayout.addOnLayoutChangeListener(this.mLayoutChangeListener);
        new SpenFont(context, fontName);
        for (int mTextSize = 8; mTextSize < 21; mTextSize++) {
            this.mTextFontSizeList.add(Integer.toString(mTextSize));
        }
        for (int mTextSize2 = 22; mTextSize2 < 33; mTextSize2 += 2) {
            this.mTextFontSizeList.add(Integer.toString(mTextSize2));
        }
        for (int mTextSize3 = 36; mTextSize3 < 65; mTextSize3 += 4) {
            this.mTextFontSizeList.add(Integer.toString(mTextSize3));
        }
        this.localDisplayMetrics = context.getResources().getDisplayMetrics();
        initView();
        setListener();
        this.mMovableRect = new Rect();
        this.mOldMovableRect = new Rect();
        this.mOldLocation = new int[2];
        this.mCurrentLocation = new int[2];
    }

    public SpenSettingTextLayout(Context context, String customImagePath, HashMap<String, String> fontName, RelativeLayout relativeLayout, float ratio) {
        super(context);
        this.mCurrentFontSize = SimpleUserInfo.STATE_DENY;
        this.mExpandFlag = false;
        this.mBodyLayoutHeight = -2;
        this.mActionListener = null;
        this.mVisibilityListener = null;
        this.mParaLineSpinner1stSelect = true;
        this.mTextFontSizeList = new ArrayList<>();
        this.mGestureDetector = null;
        this.mMoveSettingLayout = false;
        this.mScrollY = 0;
        this.mNeedCalculateMargin = true;
        this.mFirstLongPress = true;
        this.mIsRotated = false;
        this.mIsRotated2 = false;
        this.isChangePosition = false;
        this.mScale = 1.0f;
        this.mCanvasWidth = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_PPT_SLIDEMOVEPREV_EVENT;
        this.mViewMode = 0;
        this.deltaPreview = 0;
        this.isFirstTime = false;
        this.deltaOfFirstTime = 0;
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (SpenSettingTextLayout.this.mGestureDetector == null || !SpenSettingTextLayout.this.mGestureDetector.onTouchEvent(event)) {
                    int x = Math.round(event.getRawX());
                    int y = Math.round(event.getRawY());
                    switch (event.getAction()) {
                        case 1:
                            if (SpenSettingTextLayout.this.mMoveSettingLayout && SpenSettingTextLayout.this.mActionListener != null) {
                                SpenSettingTextLayout.this.mActionListener.onMoved();
                                break;
                            }
                            break;
                        case 2:
                            if (SpenSettingTextLayout.this.mMoveSettingLayout) {
                                int mMoveX = x - SpenSettingTextLayout.this.mXDelta;
                                int mMoveY = y - SpenSettingTextLayout.this.mYDelta;
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                if (mMoveX > (SpenSettingTextLayout.this.mCanvasLayout.getWidth() - SpenSettingTextLayout.this.getWidth()) - 2) {
                                    mMoveX = (SpenSettingTextLayout.this.mCanvasLayout.getWidth() - SpenSettingTextLayout.this.getWidth()) - 2;
                                }
                                int minHeight = SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(143.0f + SpenSettingTextLayout.this.deltaPreview);
                                int height = SpenSettingTextLayout.this.getHeight();
                                Log.e(SpenSettingTextLayout.TAG, "height = " + height);
                                Log.i(SpenSettingTextLayout.TAG, "before mMoveY = " + mMoveY);
                                if (height <= minHeight && mMoveY > SpenSettingTextLayout.this.mMovableRect.height() - minHeight) {
                                    mMoveY = SpenSettingTextLayout.this.mMovableRect.height() - minHeight;
                                } else if (mMoveY > SpenSettingTextLayout.this.mMovableRect.height() - height) {
                                    SpenSettingTextLayout.this.setExpandBarPosition((SpenSettingTextLayout.this.mMovableRect.height() - mMoveY) - SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(57.0f));
                                    if (mMoveY > SpenSettingTextLayout.this.mMovableRect.height() - minHeight) {
                                        mMoveY = SpenSettingTextLayout.this.mMovableRect.height() - minHeight;
                                    }
                                }
                                Log.w(SpenSettingTextLayout.TAG, "after mMoveY = " + mMoveY);
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                ViewGroup.MarginLayoutParams Params = (ViewGroup.MarginLayoutParams) SpenSettingTextLayout.this.getLayoutParams();
                                Params.leftMargin = mMoveX;
                                Params.topMargin = mMoveY;
                                SpenSettingTextLayout.this.setLayoutParams(Params);
                                break;
                            }
                            break;
                    }
                    SpenSettingTextLayout.this.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
        };
        this.mHoverListener = new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.2
            @Override // android.view.View.OnHoverListener
            public boolean onHover(View arg0, MotionEvent arg1) {
                return true;
            }
        };
        this.mGestureDetectorListener = new GestureDetector.OnGestureListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.3
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
                if (SpenSettingTextLayout.this.mNeedCalculateMargin) {
                    int[] location = new int[2];
                    SpenSettingTextLayout.this.mCanvasLayout.getLocationOnScreen(location);
                    SpenSettingTextLayout.this.mLeftMargin = Math.round((event.getRawX() - location[0]) - event.getX());
                    SpenSettingTextLayout.this.mTopMargin = Math.round((event.getRawY() - location[1]) - event.getY());
                    int[] rootLocation = new int[2];
                    SpenSettingTextLayout.this.getRootView().getLocationOnScreen(rootLocation);
                    SpenSettingTextLayout.this.mNeedCalculateMargin = false;
                }
                if (SpenSettingTextLayout.this.mFirstLongPress) {
                    SpenSettingTextLayout.this.mTitleLayout.performHapticFeedback(1);
                    SpenSettingTextLayout.this.mFirstLongPress = false;
                }
                Rect r = SpenSettingTextLayout.this.getMovableRect();
                SpenSettingTextLayout.this.mMovableRect.set(r);
                SpenSettingTextLayout.this.mMoveSettingLayout = true;
                SpenSettingTextLayout.this.mIndicator.setVisibility(8);
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent event) {
                SpenSettingTextLayout.this.mMovableRect.set(SpenSettingTextLayout.this.getMovableRect());
                int x = Math.round(event.getRawX());
                int y = Math.round(event.getRawY());
                ViewGroup.MarginLayoutParams Params = (ViewGroup.MarginLayoutParams) SpenSettingTextLayout.this.getLayoutParams();
                SpenSettingTextLayout.this.mXDelta = x - Params.leftMargin;
                SpenSettingTextLayout.this.mYDelta = y - Params.topMargin;
                return true;
            }
        };
        this.mColorPickerColorChangeListenerText = new SpenColorGradationView.onColorChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.4
            @Override // com.samsung.android.sdk.pen.settingui.SpenColorGradationView.onColorChangedListener
            public void onColorChanged(int color, int x, int y) {
                SpenSettingTextLayout.this.mColorPaletteView.setColor(SpenSettingTextLayout.this.mTextPreView.getPreviewTextColor());
                if (SpenSettingTextLayout.this.getVisibility() == 0) {
                    SpenSettingTextLayout.this.mTextPreView.setPreviewTextColor(color);
                    SpenSettingTextLayout.this.mTextPreView.invalidate();
                    if (SpenSettingTextLayout.this.mCanvasView != null) {
                        SpenSettingTextInfo info = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                        info.color = color;
                        SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info);
                        SpenSettingTextLayout.this.mColorPickerSetting.setColorPickerColor(info.color);
                        SpenSettingTextLayout.this.mSettingInfo.color = color;
                    }
                }
            }
        };
        this.mOnColorChangedListenerText = new SpenColorPaletteView.OnColorChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.5
            @Override // com.samsung.android.sdk.pen.settingui.SpenColorPaletteView.OnColorChangedListener
            public void colorChanged(int color, int selectedItem) {
                if (SpenSettingTextLayout.this.getVisibility() == 0) {
                    if (selectedItem == 13) {
                        SpenSettingTextLayout.this.setViewMode(0);
                        if (SpenSettingTextLayout.this.mCanvasView != null) {
                            SpenSettingTextLayout.this.mPreCanvasPenAction = SpenSettingTextLayout.this.mCanvasView.getToolTypeAction(2);
                            SpenSettingTextLayout.this.mPreCanvasFingerAction = SpenSettingTextLayout.this.mCanvasView.getToolTypeAction(1);
                            SpenSettingTextLayout.this.mCanvasView.setToolTypeAction(2, 5);
                            SpenSettingTextLayout.this.mCanvasView.setToolTypeAction(1, 5);
                        }
                        SpenSettingTextLayout.this.mColorPaletteView.setColorPickerMode();
                        SpenSettingTextLayout.this.setVisibility(8);
                        SpenSettingTextLayout.this.mColorPickerSetting.show();
                        return;
                    }
                    if (selectedItem == 12 && !SpenSettingTextLayout.this.isFirstTime) {
                        SpenSettingTextLayout.this.isFirstTime = true;
                        SpenSettingTextLayout.this.mColorGradationView.setVisibility(0);
                        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(118.0f));
                        SpenSettingTextLayout.this.mColorSelectedAndPicker.setLayoutParams(localLayoutParams);
                        SpenSettingTextLayout.this.setExpandBarPosition(SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(SpenSettingTextLayout.this.deltaPreview + SpenSettingTextLayout.BODY_LAYOUT_HEIGHT));
                    }
                    SpenSettingTextLayout.this.mTextPreView.setPreviewTextColor(color);
                    SpenSettingTextLayout.this.mTextPreView.invalidate();
                    if (SpenSettingTextLayout.this.mCanvasView != null) {
                        SpenSettingTextInfo info = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                        SpenSettingTextInfo spenSettingTextInfo = SpenSettingTextLayout.this.mSettingInfo;
                        info.color = color;
                        spenSettingTextInfo.color = color;
                        SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info);
                        SpenSettingTextLayout.this.mColorPickerSetting.setColorPickerColor(info.color);
                    }
                }
            }
        };
        this.mFontSizeOnClickListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingTextLayout.this.mFontSizeDropdown = new SPenFontSizeDropdown(v, SpenSettingTextLayout.this.mTextFontSizeList, SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(36.0f), SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(160.0f), SpenSettingTextLayout.this.mScale);
                SpenSettingTextLayout.this.mFontSizeDropdown.setOnItemSelectListner(new SPenFontSizeDropdown.SizeDropdownSelectListner() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.6.1
                    @Override // com.samsung.android.sdk.pen.settingui.SPenFontSizeDropdown.SizeDropdownSelectListner
                    public void onSelectItem(int position) {
                        if (SpenSettingTextLayout.this.mCanvasView != null) {
                            if (SpenSettingTextLayout.this.mCanvasView.getCanvasWidth() < SpenSettingTextLayout.this.mCanvasView.getCanvasHeight()) {
                                SpenSettingTextLayout.this.mCanvasWidth = SpenSettingTextLayout.this.mCanvasView.getCanvasWidth();
                            } else {
                                SpenSettingTextLayout.this.mCanvasWidth = SpenSettingTextLayout.this.mCanvasView.getCanvasHeight();
                            }
                            if (SpenSettingTextLayout.this.mCanvasWidth == 0) {
                                SpenSettingTextLayout.this.mCanvasWidth = 1080;
                            }
                        } else {
                            SpenSettingTextLayout.this.mCanvasWidth = 1080;
                        }
                        float fontPointPixel = (float) (SpenSettingTextLayout.this.mCanvasWidth / 360.0d);
                        SpenSettingTextLayout.this.mSettingInfo.size = Integer.valueOf(SpenSettingTextLayout.this.mTextFontSizeList.get(position)).intValue() * fontPointPixel;
                        SpenSettingTextLayout.this.mTextPreView.setPreviewTextSize(SpenSettingTextLayout.this.mSettingInfo.size);
                        SpenSettingTextLayout.this.mCurrentFontSize = SpenSettingTextLayout.this.mTextFontSizeList.get(position);
                        SpenSettingTextLayout.this.mFontSizeButton.setText(SpenSettingTextLayout.this.mCurrentFontSize);
                        SpenSettingTextLayout.this.mTextPreView.invalidate();
                        if (SpenSettingTextLayout.this.mCanvasView != null) {
                            SpenSettingTextInfo info = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                            info.size = SpenSettingTextLayout.this.mSettingInfo.size;
                            SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info);
                        }
                    }
                });
                SpenSettingTextLayout.this.mFontSizeDropdown.show(0, 0, SpenSettingTextLayout.this.mCurrentFontSize);
            }
        };
        this.mFontTypeOnClickListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingTextLayout.this.mFontNameDropdown = new SPenFontNameDropdown(v, (ArrayList) SpenFont.getFontList(), SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(170.0f), SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(160.0f), SpenSettingTextLayout.this.mScale);
                SpenSettingTextLayout.this.mFontNameDropdown.setOnItemSelectListner(new SPenFontNameDropdown.NameDropdownSelectListner() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.7.1
                    @Override // com.samsung.android.sdk.pen.settingui.SPenFontNameDropdown.NameDropdownSelectListner
                    public void onSelectItem(int position) {
                        SpenSettingTextLayout.this.mCurrentFontName = SpenFont.getFontList().get(position);
                        SpenSettingTextLayout.this.mTextPreView.setPreviewTypeface(SpenFont.getTypeFace(position));
                        SpenSettingTextLayout.this.mTextPreView.invalidate();
                        if (SpenSettingTextLayout.this.mCanvasView != null) {
                            SpenSettingTextInfo info = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                            info.font = SpenFont.getFontName(SpenFont.getFontList().indexOf(SpenSettingTextLayout.this.mCurrentFontName));
                            SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info);
                        }
                        if (SpenSettingTextLayout.mSdkVersion < 16) {
                            String mTempFontName = SpenSettingTextLayout.this.mCurrentFontName;
                            Paint mPaint = new Paint();
                            int mTextWidth = SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(mPaint.measureText(mTempFontName));
                            if (SpenSettingTextLayout.this.mCurrentFontName == null || mTextWidth < SpenSettingTextLayout.this.mFontTypeButton.getWidth() - SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(33.0f)) {
                                SpenSettingTextLayout.this.mFontTypeButton.setText(SpenSettingTextLayout.this.mCurrentFontName);
                            } else {
                                while (mTextWidth > SpenSettingTextLayout.this.mFontTypeButton.getWidth() - SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(33.0f)) {
                                    mTempFontName = mTempFontName.substring(0, mTempFontName.length() - 1);
                                    mTextWidth = SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(mPaint.measureText(mTempFontName) + mPaint.measureText("..."));
                                }
                                SpenSettingTextLayout.this.mFontTypeButton.setText(String.valueOf(mTempFontName) + "...");
                            }
                        } else {
                            SpenSettingTextLayout.this.mFontTypeButton.setText(SpenSettingTextLayout.this.mCurrentFontName);
                        }
                        SpenSettingTextLayout.this.mFontTypeButton.setTypeface(SpenFont.getTypeFace(position));
                    }
                });
                SpenSettingTextLayout.this.mFontNameDropdown.show(0, 0, SpenSettingTextLayout.this.mCurrentFontName);
            }
        };
        this.mTextOptButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingTextLayout.this.setTextStyle(v);
            }
        };
        this.mExitButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingTextLayout.this.mColorPickerSetting.getColorPickerSettingVisible() == 0) {
                    if (SpenSettingTextLayout.this.mSettingInfo.color != 0) {
                        if (SpenSettingTextLayout.this.mCanvasView != null) {
                            SpenSettingTextLayout.this.mCanvasView.setToolTypeAction(2, SpenSettingTextLayout.this.mPreCanvasPenAction);
                            SpenSettingTextLayout.this.mCanvasView.setToolTypeAction(1, SpenSettingTextLayout.this.mPreCanvasFingerAction);
                            SpenSettingTextInfo info = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                            info.color = SpenSettingTextLayout.this.mSettingInfo.color;
                            SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info);
                        }
                        SpenSettingTextLayout.this.mTextPreView.setPreviewTextColor(SpenSettingTextLayout.this.mSettingInfo.color);
                        SpenSettingTextLayout.this.mTextPreView.invalidate();
                        SpenSettingTextLayout.this.mColorPaletteView.setColor(SpenSettingTextLayout.this.mSettingInfo.color);
                        SpenSettingTextLayout.this.mColorPaletteView.invalidate();
                    }
                    SpenSettingTextLayout.this.mColorPickerSetting.hide();
                }
                SpenSettingTextLayout.this.setVisibility(8);
            }
        };
        this.mColorPickerColorListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingTextLayout.this.mColorPickerSetting.getColorPickerSettingVisible() == 0) {
                    SpenSettingTextLayout.this.mTextPreView.setPreviewTextColor(SpenSettingTextLayout.this.mSettingInfo.color);
                    SpenSettingTextLayout.this.mTextPreView.invalidate();
                    SpenSettingTextLayout.this.mColorPaletteView.setColor(SpenSettingTextLayout.this.mSettingInfo.color);
                    SpenSettingTextLayout.this.mColorPaletteView.invalidate();
                    if (SpenSettingTextLayout.this.mCanvasView != null) {
                        SpenSettingTextLayout.this.mCanvasView.setToolTypeAction(2, SpenSettingTextLayout.this.mPreCanvasPenAction);
                        SpenSettingTextLayout.this.mCanvasView.setToolTypeAction(1, SpenSettingTextLayout.this.mPreCanvasFingerAction);
                        SpenSettingTextInfo info = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                        info.color = SpenSettingTextLayout.this.mSettingInfo.color;
                        SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info);
                    }
                    SpenSettingTextLayout.this.mColorPickerSetting.hide();
                    SpenSettingTextLayout.this.setVisibility(0);
                }
            }
        };
        this.mTextAlignSettingListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v.equals(SpenSettingTextLayout.this.mAlignLeftBtn)) {
                    SpenSettingTextLayout.this.mAlignLeftBtn.setSelected(true);
                    SpenSettingTextLayout.this.mAlignCenterBtn.setSelected(false);
                    SpenSettingTextLayout.this.mAlignRightBtn.setSelected(false);
                    if (SpenSettingTextLayout.this.mCanvasView != null) {
                        SpenSettingTextInfo info = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                        info.align = 0;
                        SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info);
                        return;
                    }
                    return;
                }
                if (v.equals(SpenSettingTextLayout.this.mAlignCenterBtn)) {
                    SpenSettingTextLayout.this.mAlignLeftBtn.setSelected(false);
                    SpenSettingTextLayout.this.mAlignCenterBtn.setSelected(true);
                    SpenSettingTextLayout.this.mAlignRightBtn.setSelected(false);
                    if (SpenSettingTextLayout.this.mCanvasView != null) {
                        SpenSettingTextInfo info2 = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                        info2.align = 2;
                        SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info2);
                        return;
                    }
                    return;
                }
                if (v.equals(SpenSettingTextLayout.this.mAlignRightBtn)) {
                    SpenSettingTextLayout.this.mAlignLeftBtn.setSelected(false);
                    SpenSettingTextLayout.this.mAlignCenterBtn.setSelected(false);
                    SpenSettingTextLayout.this.mAlignRightBtn.setSelected(true);
                    if (SpenSettingTextLayout.this.mCanvasView != null) {
                        SpenSettingTextInfo info3 = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                        info3.align = 1;
                        SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info3);
                    }
                }
            }
        };
        this.mTextIndentSettingListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v.equals(SpenSettingTextLayout.this.mIndentLeftBtn)) {
                    if (SpenSettingTextLayout.this.mCanvasView != null) {
                        SpenSettingTextInfo info = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                        info.lineIndent += 10;
                        SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info);
                        return;
                    }
                    return;
                }
                if (v.equals(SpenSettingTextLayout.this.mIndentRightBtn) && SpenSettingTextLayout.this.mCanvasView != null) {
                    SpenSettingTextInfo info2 = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                    info2.lineIndent -= 10;
                    SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info2);
                }
            }
        };
        this.mPaletteNextButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingTextLayout.this.mColorPaletteView != null) {
                    int index = SpenSettingTextLayout.this.mColorPaletteView.getCurrentTableIndex();
                    if (index == 3) {
                        SpenSettingTextLayout.this.mPaletteLeftButton.setEnabled(true);
                    }
                    SpenSettingTextLayout.this.mColorPaletteView.setNextColorTable(index);
                    SpenSettingTextLayout.this.mColorPaletteView.setSelectBoxPos(SpenSettingTextLayout.this.mSettingInfo.color);
                    if (SpenSettingTextLayout.this.mColorPaletteView.getCurrentTableIndex() == 2) {
                        SpenSettingTextLayout.this.mPaletteRightButton.setEnabled(false);
                    }
                }
            }
        };
        this.mPaletteBackButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingTextLayout.this.mColorPaletteView != null) {
                    int index = SpenSettingTextLayout.this.mColorPaletteView.getCurrentTableIndex();
                    if (index == 2) {
                        SpenSettingTextLayout.this.mPaletteRightButton.setEnabled(true);
                    }
                    SpenSettingTextLayout.this.mColorPaletteView.setBackColorTable(index);
                    SpenSettingTextLayout.this.mColorPaletteView.setSelectBoxPos(SpenSettingTextLayout.this.mSettingInfo.color);
                    if (SpenSettingTextLayout.this.mColorPaletteView.getCurrentTableIndex() == 3) {
                        SpenSettingTextLayout.this.mPaletteLeftButton.setEnabled(false);
                    }
                }
            }
        };
        this.mTextLineSpacingSettingListener = new AdapterView.OnItemSelectedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.15
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(-16777216);
                ((TextView) parent.getChildAt(0)).setTextSize(0, SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(15.0f));
                if (SpenSettingTextLayout.this.mParaLineSpinner1stSelect) {
                    SpenSettingTextLayout.this.mParaLineSpinner1stSelect = false;
                    return;
                }
                int[] arrChange = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 22, 24, 26, 28, 30, 32, 36, 40, 43, 44, 48, 52, 56, 60, 64, 68, 72, 80, 88};
                if (SpenSettingTextLayout.this.mCanvasView != null) {
                    SpenSettingTextInfo info = SpenSettingTextLayout.this.mCanvasView.getTextSettingInfo();
                    info.lineSpacingType = 0;
                    info.lineSpacing = arrChange[position];
                    SpenSettingTextLayout.this.mCanvasView.setTextSettingInfo(info);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        this.mOnConsumedTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.16
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpenSettingTextLayout.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mExpendBarHoverListener = new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.17
            @Override // android.view.View.OnHoverListener
            public boolean onHover(View v, MotionEvent event) {
                return true;
            }
        };
        this.mExpendBarListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int x = Math.round(event.getRawX());
                int y = Math.round(event.getRawY());
                switch (event.getAction()) {
                    case 0:
                        RelativeLayout.LayoutParams bottomParams = (RelativeLayout.LayoutParams) SpenSettingTextLayout.this.mBottomLayout.getLayoutParams();
                        SpenSettingTextLayout.this.mXDelta = x - bottomParams.leftMargin;
                        SpenSettingTextLayout.this.mYDelta = y - bottomParams.topMargin;
                        SpenSettingTextLayout.this.mBottomExtendBg.setPressed(true);
                        break;
                    case 1:
                        if (SpenSettingTextLayout.this.mExpandFlag) {
                            if (SpenSettingTextLayout.this.mActionListener != null) {
                                SpenSettingTextLayout.this.mActionListener.onResized();
                            }
                            SpenSettingTextLayout.this.mExpandFlag = false;
                        }
                        SpenSettingTextLayout.this.mBottomExtendBg.setPressed(false);
                        break;
                    case 2:
                        if (y - SpenSettingTextLayout.this.mYDelta > 0) {
                            SpenSettingTextLayout.this.mExpandFlag = true;
                            SpenSettingTextLayout.this.setExpandBarPosition(y - SpenSettingTextLayout.this.mYDelta);
                            break;
                        }
                        break;
                    case 3:
                        SpenSettingTextLayout.this.mBottomExtendBg.setPressed(false);
                        break;
                }
                SpenSettingTextLayout.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mScrollViewListner = new SpenScrollView.scrollChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.19
            @Override // com.samsung.android.sdk.pen.settingui.SpenScrollView.scrollChangedListener
            public void scrollChanged(int scrollY) {
                SpenSettingTextLayout.this.scroll(scrollY);
                SpenSettingTextLayout.this.mScrollY = scrollY;
                RelativeLayout.LayoutParams PaletteBgParam = new RelativeLayout.LayoutParams(-1, (SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(118.0f) - (SpenSettingTextLayout.this.mDrawableImg.getIntValueAppliedDensity(SpenSettingTextLayout.this.deltaPreview + SpenSettingTextLayout.BODY_LAYOUT_HEIGHT) - SpenSettingTextLayout.this.mBodyLayoutHeight)) + SpenSettingTextLayout.this.mScrollY);
                PaletteBgParam.setMargins(0, 0, 0, 0);
                if (PaletteBgParam.height >= 0) {
                    SpenSettingTextLayout.this.mPaletteBg.setLayoutParams(PaletteBgParam);
                }
            }
        };
        this.mLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.20
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                try {
                    if (SpenSettingTextLayout.this.getVisibility() == 8) {
                        if (SpenSettingTextLayout.this.mIsRotated) {
                            SpenSettingTextLayout.this.mIsRotated = false;
                            return;
                        }
                        return;
                    }
                    if (!SpenSettingTextLayout.this.mIsRotated && SpenSettingTextLayout.this.mIsRotated2) {
                        SpenSettingTextLayout.this.mIsRotated2 = false;
                    }
                    int[] location = new int[2];
                    SpenSettingTextLayout.this.getLocationOnScreen(location);
                    if (SpenSettingTextLayout.this.mCurrentLocation[0] != location[0] || SpenSettingTextLayout.this.mCurrentLocation[1] != location[1]) {
                        SpenSettingTextLayout.this.isChangePosition = true;
                        SpenSettingTextLayout.this.mCurrentLocation[0] = location[0];
                        SpenSettingTextLayout.this.mCurrentLocation[1] = location[1];
                    }
                    int mMoveableRect = SpenSettingTextLayout.this.mMovableRect.height();
                    SpenSettingTextLayout.this.mMovableRect.set(SpenSettingTextLayout.this.getMovableRect());
                    if (Math.abs(mMoveableRect - SpenSettingTextLayout.this.mMovableRect.height()) > 150 && SpenSettingTextLayout.this.isChangePosition) {
                        if (SpenSettingTextLayout.this.mFontNameDropdown != null) {
                            SpenSettingTextLayout.this.mFontNameDropdown.updatePosition();
                        }
                        if (SpenSettingTextLayout.this.mFontSizeDropdown != null) {
                            SpenSettingTextLayout.this.mFontSizeDropdown.updatePosition();
                        }
                        SpenSettingTextLayout.this.isChangePosition = false;
                    }
                    if (SpenSettingTextLayout.this.mIsRotated) {
                        SpenSettingTextLayout.this.rotatePosition();
                        SpenSettingTextLayout.this.mIsRotated = false;
                        SpenSettingTextLayout.this.mIsRotated2 = true;
                    } else {
                        SpenSettingTextLayout.this.checkPosition();
                    }
                    Handler handler = new Handler();
                    handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SpenSettingTextLayout.this.requestLayout();
                        }
                    });
                } catch (NullPointerException e) {
                }
            }
        };
        this.mScale = ratio;
        this.mContext = context;
        this.mDrawableImg = new SPenImageUtil(context, customImagePath, ratio);
        this.mTextUtil = new SPenTextUtil(context);
        this.mImageLoader = new SpenImageLoader(this.mDrawableImg);
        this.mCanvasLayout = relativeLayout;
        this.mCanvasLayout.addOnLayoutChangeListener(this.mLayoutChangeListener);
        new SpenFont(context, fontName);
        for (int mTextSize = 8; mTextSize < 21; mTextSize++) {
            this.mTextFontSizeList.add(Integer.toString(mTextSize));
        }
        for (int mTextSize2 = 22; mTextSize2 < 33; mTextSize2 += 2) {
            this.mTextFontSizeList.add(Integer.toString(mTextSize2));
        }
        for (int mTextSize3 = 36; mTextSize3 < 65; mTextSize3 += 4) {
            this.mTextFontSizeList.add(Integer.toString(mTextSize3));
        }
        this.localDisplayMetrics = context.getResources().getDisplayMetrics();
        initView();
        setListener();
        this.mMovableRect = new Rect();
        this.mOldMovableRect = new Rect();
        this.mOldLocation = new int[2];
        this.mCurrentLocation = new int[2];
    }

    private void totalLayout() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(250.0f), -2);
        setLayoutParams(layoutParams);
        setOrientation(1);
        this.mTitleLayout = titleLayout();
        this.mBodyLayout = bodyLayout();
        addView(this.mTitleLayout);
        addView(this.mBodyLayout);
        if (this.mBodyLayoutHeight - this.mBottomLayout.getHeight() >= this.mDrawableImg.getIntValueAppliedDensity(this.deltaPreview + BODY_LAYOUT_HEIGHT) || this.mBodyLayoutHeight == -2 || this.mBodyLayoutHeight == 0) {
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(((this.deltaPreview + BODY_LAYOUT_HEIGHT) + 16) - 52));
            this.mBodyLayout.setLayoutParams(localLayoutParams);
            RelativeLayout.LayoutParams bodyBgParam = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(((this.deltaPreview + BODY_LAYOUT_HEIGHT) + 16) - 52));
            this.mBodyBg.setLayoutParams(bodyBgParam);
            RelativeLayout.LayoutParams bottomLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(16.0f));
            bottomLayoutParams.setMargins(0, this.mDrawableImg.getIntValueAppliedDensity((this.deltaPreview + BODY_LAYOUT_HEIGHT) - 52), 0, 0);
            this.mBottomLayout.setLayoutParams(bottomLayoutParams);
            this.mBodyLayoutHeight = this.mDrawableImg.getIntValueAppliedDensity(this.deltaPreview + BODY_LAYOUT_HEIGHT);
            RelativeLayout.LayoutParams scrollLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(this.deltaPreview + BODY_LAYOUT_HEIGHT + 16));
            scrollLayoutParams.setMargins(0, 0, 0, this.mDrawableImg.getIntValueAppliedDensity(16.0f));
            this.mScrollView.setLayoutParams(scrollLayoutParams);
        }
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
        RelativeLayout.LayoutParams titleLeftParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(125.3f), -1);
        titleLeftParam.alignWithParent = true;
        titleLeftParam.addRule(9);
        titleLeftParam.addRule(10);
        titleLeft.setLayoutParams(titleLeftParam);
        this.mIndicator = new ImageView(this.mContext);
        RelativeLayout.LayoutParams titleCenterParam = new RelativeLayout.LayoutParams(-2, -1);
        this.mIndicator.setLayoutParams(titleCenterParam);
        ImageView titleRight = new ImageView(this.mContext);
        RelativeLayout.LayoutParams titleRightParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(125.3f), -1);
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
        titleView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        titleView.setTextColor(-1);
        titleView.setGravity(19);
        titleView.setFocusable(true);
        titleView.setSingleLine(true);
        titleView.setEllipsize(TextUtils.TruncateAt.END);
        titleView.setText(this.mTextUtil.setString("string_text_settings"));
        titleView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(16.0f));
        titleView.setTypeface(Typeface.SANS_SERIF);
        titleView.setContentDescription(this.mTextUtil.setString("string_text_settings"));
        titleView.setPadding(this.mDrawableImg.getIntValueAppliedDensity(10.0f) + 9, 15, 0, 0);
        return titleView;
    }

    private ViewGroup bodyLayout() {
        this.mScrollView = new SpenScrollView(this.mContext);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(0, 0, 0, this.mDrawableImg.getIntValueAppliedDensity(16.0f));
        this.mScrollView.setLayoutParams(localLayoutParams);
        this.mScrollView.setVerticalFadingEdgeEnabled(false);
        this.mScrollView.setFadingEdgeLength(0);
        this.mScrollView.setVerticalScrollBarEnabled(true);
        this.mScrollView.setOverScrollMode(1);
        SpenPalletView palletViewLayout = new SpenPalletView(this.mContext);
        RelativeLayout.LayoutParams palletViewLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        palletViewLayout.setLayoutParams(palletViewLayoutParams);
        palletViewLayout.setOrientation(1);
        palletViewLayout.setPadding(0, 0, -9, 0);
        this.mTextSettingPreview = textPreview();
        this.mFontSizeSpinnerOptButton = fontSizeSpinnerOptButton();
        this.mColorSelectedAndPicker = colorSelectedAndPicker();
        palletViewLayout.addView(this.mTextSettingPreview);
        palletViewLayout.addView(this.mFontSizeSpinnerOptButton);
        palletViewLayout.addView(this.mColorSelectedAndPicker);
        this.mParagraphSetting = paragraphSetting();
        this.mBottomLayout = bottomLayout();
        this.mBottomLayout.setPadding(0, 0, -9, 0);
        this.mBottomLayout.setContentDescription(this.mTextUtil.setString("string_resize"));
        palletViewLayout.addView(this.mParagraphSetting);
        this.mScrollView.addView(palletViewLayout);
        RelativeLayout layout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layout.setLayoutParams(layoutParams);
        layout.setPadding(0, 0, 9, 0);
        this.mBodyBg = bodyBg();
        this.mBodyBg.setPadding(0, 0, -9, 0);
        layout.addView(this.mBodyBg);
        layout.addView(this.mScrollView);
        layout.addView(this.mBottomLayout);
        return layout;
    }

    private ViewGroup bodyBg() {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams bodyBgParam = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setLayoutParams(bodyBgParam);
        ImageView bodyLeft = new ImageView(this.mContext);
        RelativeLayout.LayoutParams bodyLeftParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(125.3f), -1);
        bodyLeftParam.alignWithParent = true;
        bodyLeftParam.addRule(9);
        bodyLeftParam.addRule(10);
        bodyLeft.setLayoutParams(bodyLeftParam);
        ImageView bodyRight = new ImageView(this.mContext);
        RelativeLayout.LayoutParams bodyRightParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(125.3f), -1);
        bodyRightParam.alignWithParent = true;
        bodyRightParam.addRule(11);
        bodyRightParam.addRule(10);
        bodyRight.setLayoutParams(bodyRightParam);
        this.mImageLoader.addViewSetBackgroundImageLoad(bodyLeft, lightBodyLeftPath);
        this.mImageLoader.addViewSetBackgroundImageLoad(bodyRight, lightBodyRightPath);
        relativeLayout.setOnTouchListener(this.mOnConsumedTouchListener);
        relativeLayout.addView(bodyLeft);
        relativeLayout.addView(bodyRight);
        return relativeLayout;
    }

    public void close() {
        if (this.mDrawableImg != null) {
            this.mDrawableImg.unbindDrawables(this);
            this.mDrawableImg.unbindDrawables(this.mScrollHandle);
            this.mScrollHandle = null;
            this.mDrawableImg.unbindDrawables(this.mScrollView);
            this.mScrollView = null;
            this.mDrawableImg.unbindDrawables(this.mTextPreView);
            this.mTextPreView = null;
            if (this.mFontSizeSpinnerOptButton != null) {
                for (int i = 0; i < this.mFontSizeSpinnerOptButton.getChildCount(); i++) {
                    this.mDrawableImg.unbindDrawables(this.mTextSizeButtonView[i]);
                    this.mTextSizeButtonView[i] = null;
                }
            }
            this.mTextSizeButtonView = null;
            this.mDrawableImg.unbindDrawables(this.mFontSizeSpinnerOptButton);
            this.mFontSizeSpinnerOptButton = null;
            this.mDrawableImg.unbindDrawables(this.mFontTypeSpinnerView);
            this.mFontTypeSpinnerView = null;
            this.mDrawableImg.unbindDrawables(this.mFontSizeSpinnerView);
            this.mFontSizeSpinnerView = null;
            this.mDrawableImg.unbindDrawables(this.mBoldBtn);
            this.mBoldBtn = null;
            this.mDrawableImg.unbindDrawables(this.mUnderlineBtn);
            this.mUnderlineBtn = null;
            if (this.mColorPaletteView != null) {
                this.mColorPaletteView.close();
                this.mDrawableImg.unbindDrawables(this.mColorPaletteView);
                this.mColorPaletteView = null;
            }
            if (this.mColorGradationView != null) {
                this.mColorGradationView.close();
                this.mDrawableImg.unbindDrawables(this.mColorGradationView);
                this.mColorGradationView = null;
            }
            this.mDrawableImg.unbindDrawables(this.mAlignLeftBtn);
            this.mAlignLeftBtn = null;
            this.mDrawableImg.unbindDrawables(this.mAlignCenterBtn);
            this.mAlignCenterBtn = null;
            this.mDrawableImg.unbindDrawables(this.mAlignRightBtn);
            this.mAlignRightBtn = null;
            this.mDrawableImg.unbindDrawables(this.mIndentLeftBtn);
            this.mIndentLeftBtn = null;
            this.mDrawableImg.unbindDrawables(this.mIndentRightBtn);
            this.mIndentRightBtn = null;
            this.mDrawableImg.unbindDrawables(this.mBottomLayout);
            this.mBottomLayout = null;
            this.mDrawableImg.unbindDrawables(this.mExitButton);
            this.mExitButton = null;
            this.mDrawableImg.unbindDrawables(this.mTextSettingPreview);
            this.mTextSettingPreview = null;
            this.mDrawableImg.unbindDrawables(this.mColorSelectedAndPicker);
            this.mColorSelectedAndPicker = null;
            this.mDrawableImg.unbindDrawables(this.mPaletteRightButton);
            this.mPaletteRightButton = null;
            this.mDrawableImg.unbindDrawables(this.mPaletteLeftButton);
            this.mPaletteLeftButton = null;
            this.mDrawableImg.unbindDrawables(this.mPaletteView);
            this.mPaletteView = null;
            this.mDrawableImg.unbindDrawables(this.mPickerView);
            this.mPickerView = null;
            this.mDrawableImg.unbindDrawables(this.mPaletteBg);
            this.mPaletteBg = null;
            this.mDrawableImg.unbindDrawables(this.mParagraphSetting);
            this.mParagraphSetting = null;
            this.mDrawableImg.unbindDrawables(this.mFontSizeButton);
            this.mFontSizeButton = null;
            this.mDrawableImg.unbindDrawables(this.mFontTypeButton);
            this.mFontTypeButton = null;
            this.mDrawableImg.unbindDrawables(this.mFontLineSpaceSpinner);
            this.mFontLineSpaceSpinner = null;
            this.mDrawableImg.unbindDrawables(this.mColorPickerColor);
            this.mColorPickerColor = null;
            this.mDrawableImg.unbindDrawables(this.mColorPickerSettingExitButton);
            this.mColorPickerSettingExitButton = null;
            this.mDrawableImg.unbindDrawables(this.mTitleLayout);
            this.mTitleLayout = null;
            this.mDrawableImg.unbindDrawables(this.mBodyBg);
            this.mBodyBg = null;
            this.mDrawableImg.unbindDrawables(this.mBodyLayout);
            this.mBodyLayout = null;
            this.mDrawableImg.unbindDrawables(this.mBottomExtendBg);
            this.mBottomExtendBg = null;
            this.mColorPickerSetting.close();
            this.mDrawableImg.unbindDrawables(this.mColorPickerSetting);
            this.mColorPickerSetting = null;
            this.mCanvasView = null;
            this.mContext = null;
            this.mSettingInfo = null;
            if (this.mTextFontSizeList != null) {
                this.mTextFontSizeList.clear();
                this.mTextFontSizeList = null;
            }
            this.mActionListener = null;
            this.mVisibilityListener = null;
            this.mGestureDetector = null;
            this.mCanvasLayout = null;
            this.mDrawableImg.unbindDrawables(this);
            this.mDrawableImg = null;
            this.mImageLoader.close();
            this.mImageLoader = null;
        }
    }

    private void initView() {
        int checkCanvasWidth;
        if (this.localDisplayMetrics.widthPixels < this.localDisplayMetrics.heightPixels) {
            checkCanvasWidth = this.localDisplayMetrics.widthPixels;
        } else {
            checkCanvasWidth = this.localDisplayMetrics.heightPixels;
        }
        if (checkCanvasWidth == 1600) {
            this.deltaPreview = 33;
        } else {
            this.deltaPreview = 0;
        }
        totalLayout();
        this.mTextSizeButtonView = new View[this.mFontSizeSpinnerOptButton.getChildCount()];
        for (int i = 0; i < this.mFontSizeSpinnerOptButton.getChildCount(); i++) {
            this.mTextSizeButtonView[i] = this.mFontSizeSpinnerOptButton.getChildAt(i);
        }
        if (this.mAlignLeftBtn != null && this.mAlignCenterBtn != null && this.mAlignRightBtn != null) {
            this.mAlignLeftBtn.setOnClickListener(this.mTextAlignSettingListener);
            this.mAlignCenterBtn.setOnClickListener(this.mTextAlignSettingListener);
            this.mAlignRightBtn.setOnClickListener(this.mTextAlignSettingListener);
            this.mAlignLeftBtn.setSelected(true);
            this.mAlignCenterBtn.setSelected(false);
            this.mAlignRightBtn.setSelected(false);
        }
        if (this.mIndentLeftBtn != null && this.mIndentRightBtn != null) {
            this.mIndentLeftBtn.setOnClickListener(this.mTextIndentSettingListener);
            this.mIndentRightBtn.setOnClickListener(this.mTextIndentSettingListener);
        }
        initColorSelecteView();
        this.mSettingInfo = new SpenSettingTextInfo();
        ColorPickerSettinginit();
        setVisibility(8);
    }

    private void setListener() {
        if (this.mTitleLayout != null) {
            this.mTitleLayout.setOnTouchListener(this.mOnTouchListener);
        }
        if (this.mColorGradationView != null) {
            this.mColorGradationView.setColorPickerColorChangeListener(this.mColorPickerColorChangeListenerText);
        }
        if (this.mExitButton != null) {
            this.mExitButton.setOnClickListener(this.mExitButtonListener);
        }
        if (this.mTextSizeButtonView != null) {
            for (int mTextOptButton = 0; mTextOptButton < this.mFontSizeSpinnerOptButton.getChildCount(); mTextOptButton++) {
                if (this.mTextSizeButtonView[mTextOptButton] != null && (this.mTextSizeButtonView[mTextOptButton] instanceof ImageButton)) {
                    this.mTextSizeButtonView[mTextOptButton].setOnClickListener(this.mTextOptButtonListener);
                }
            }
        }
        if (this.mBottomLayout != null) {
            this.mBottomLayout.setOnTouchListener(this.mExpendBarListener);
            this.mBottomLayout.setOnHoverListener(this.mExpendBarHoverListener);
        }
        if (this.mPaletteRightButton != null) {
            this.mPaletteRightButton.setOnClickListener(this.mPaletteNextButtonListener);
        }
        if (this.mPaletteLeftButton != null) {
            this.mPaletteLeftButton.setOnClickListener(this.mPaletteBackButtonListener);
        }
        if (this.mScrollView != null) {
            this.mScrollView.setOnScrollChangedListener(this.mScrollViewListner);
        }
        this.mGestureDetector = new GestureDetector(this.mContext, this.mGestureDetectorListener);
    }

    private void initColorSelecteView() {
        if (this.mColorPaletteView != null) {
            this.mColorPaletteView.setInitialValue(this.mOnColorChangedListenerText, this.mTextPreView.getPreviewTextColor());
        }
    }

    private void ColorPickerSettinginit() {
        this.mColorPickerSetting = new SpenColorPickerLayout(this.mContext, this.mCanvasLayout, this.mScale, 0, 0);
        this.mColorPickerSettingExitButton = this.mColorPickerSetting.mColorPickerdExitBtn;
        this.mColorPickerSettingExitButton.setOnClickListener(this.mExitButtonListener);
        this.mColorPickerColor = this.mColorPickerSetting.mColorPickerCurrentColor;
        this.mColorPickerColor.setOnClickListener(this.mColorPickerColorListener);
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

    public void setColorPickerPosition(int x, int y) {
        if (this.mColorPickerSetting != null) {
            this.mColorPickerSetting.movePosition(x, y);
        }
    }

    private View exitButton() {
        ImageButton exitButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams exitButtonParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(38.0f), this.mDrawableImg.getIntValueAppliedDensity(36.0f));
        exitButtonParams.addRule(11);
        exitButtonParams.topMargin = 15;
        exitButtonParams.rightMargin = 9;
        exitButton.setLayoutParams(exitButtonParams);
        exitButton.setFocusable(true);
        exitButton.setContentDescription(this.mTextUtil.setString("string_close"));
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

    private View textPreview() {
        LinearLayout mPreviewLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams previewLayoutParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(71.0f + this.deltaPreview));
        previewLayoutParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(10.0f);
        previewLayoutParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(14.0f);
        previewLayoutParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(14.0f);
        mPreviewLayout.setLayoutParams(previewLayoutParams);
        this.mImageLoader.addViewSetBackgroundImageLoad(mPreviewLayout, mPreviewBgPath);
        if (this.mCanvasView != null) {
            if (this.mCanvasView.getCanvasWidth() < this.mCanvasView.getCanvasHeight()) {
                this.mCanvasWidth = this.mCanvasView.getCanvasWidth();
            } else {
                this.mCanvasWidth = this.mCanvasView.getCanvasHeight();
            }
            if (this.mCanvasWidth == 0) {
                this.mCanvasWidth = 1080;
            }
        } else {
            this.mCanvasWidth = 1080;
        }
        this.mTextPreView = new SpenTextPreView(this.mContext, this.mCanvasWidth);
        FrameLayout.LayoutParams mPreviewParams = new FrameLayout.LayoutParams(-1, -1, 17);
        mPreviewParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(-5.0f);
        this.mTextPreView.setLayoutParams(mPreviewParams);
        mPreviewLayout.addView(this.mTextPreView);
        return mPreviewLayout;
    }

    private ViewGroup fontSizeSpinnerOptButton() {
        LinearLayout fontSizeSpinnerOptButtonLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams fontSizeSpinnerOptButtonLayoutParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(39.0f));
        fontSizeSpinnerOptButtonLayout.setLayoutParams(fontSizeSpinnerOptButtonLayoutParams);
        fontSizeSpinnerOptButtonLayout.setGravity(16);
        fontSizeSpinnerOptButtonLayout.setOrientation(0);
        fontSizeSpinnerOptButtonLayout.setPadding(this.mDrawableImg.getIntValueAppliedDensity(14.0f), this.mDrawableImg.getIntValueAppliedDensity(5.0f), this.mDrawableImg.getIntValueAppliedDensity(14.0f), this.mDrawableImg.getIntValueAppliedDensity(7.0f));
        this.mFontTypeSpinnerView = fontTypeSpinnerView();
        this.mFontSizeSpinnerView = fontSizeSpinner();
        fontSizeSpinnerOptButtonLayout.addView(this.mFontTypeSpinnerView);
        fontSizeSpinnerOptButtonLayout.addView(this.mFontSizeSpinnerView);
        LinearLayout.LayoutParams mBoldBtnParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(28.0f), this.mDrawableImg.getIntValueAppliedDensity(27.0f));
        this.mBoldBtn = new ImageButton(this.mContext);
        this.mBoldBtn.setLayoutParams(mBoldBtnParams);
        this.mBoldBtn.setFocusable(true);
        this.mBoldBtn.setContentDescription(this.mTextUtil.setString("string_bold"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mBoldBtn, mBoldLeftNomarPath, mBoldLeftPressPath, mBoldLeftFocusPath);
        this.mBoldBtn.setImageDrawable(this.mDrawableImg.setDrawableImg(mBoldIconPath, 20, 20));
        this.mBoldBtn.setPadding(0, 0, 0, this.mDrawableImg.getIntValueAppliedDensity(1.0f));
        fontSizeSpinnerOptButtonLayout.addView(this.mBoldBtn);
        this.mItalicBtn = new ImageButton(this.mContext);
        LinearLayout.LayoutParams mItalicBtnParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(28.0f), this.mDrawableImg.getIntValueAppliedDensity(27.0f));
        this.mItalicBtn.setLayoutParams(mItalicBtnParams);
        this.mItalicBtn.setFocusable(true);
        this.mItalicBtn.setContentDescription(this.mTextUtil.setString("string_italic"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mItalicBtn, mItalicLeftNomarPath, mItalicLeftPressPath, mItalicLeftFocusPath);
        this.mItalicBtn.setImageDrawable(this.mDrawableImg.setDrawableImg(mItalicIconPath, 20, 20));
        this.mItalicBtn.setPadding(0, 0, 0, this.mDrawableImg.getIntValueAppliedDensity(1.0f));
        fontSizeSpinnerOptButtonLayout.addView(this.mItalicBtn);
        this.mUnderlineBtn = new ImageButton(this.mContext);
        LinearLayout.LayoutParams mUnderlineBtnParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(28.0f), this.mDrawableImg.getIntValueAppliedDensity(27.0f));
        this.mUnderlineBtn.setLayoutParams(mUnderlineBtnParams);
        this.mUnderlineBtn.setFocusable(true);
        this.mUnderlineBtn.setContentDescription(this.mTextUtil.setString("string_underline"));
        this.mUnderlineBtn.setImageDrawable(this.mDrawableImg.setDrawableImg(mUnderLineIconPath, 20, 20));
        this.mUnderlineBtn.setPadding(0, 0, 0, this.mDrawableImg.getIntValueAppliedDensity(1.0f));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mUnderlineBtn, mUnderLeftNomarPath, mUnderLeftPressPath, mUnderLeftFocusPath);
        fontSizeSpinnerOptButtonLayout.addView(this.mUnderlineBtn);
        return fontSizeSpinnerOptButtonLayout;
    }

    private ViewGroup paragraphSetting() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        ViewGroup.LayoutParams paragraphSettingLayoutParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(228.0f));
        linearLayout.setLayoutParams(paragraphSettingLayoutParams);
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams paragraphSettingAlignLayoutParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(54.0f));
        paragraphSettingAlignLayoutParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(6.0f);
        paragraphSettingAlignLayoutParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(7.0f);
        paragraphSettingAlignLayoutParams.gravity = 16;
        linearLayout2.setLayoutParams(paragraphSettingAlignLayoutParams);
        linearLayout2.setOrientation(0);
        TextView mAlignTextView = new TextView(this.mContext);
        LinearLayout.LayoutParams mAlignTextViewParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(54.0f));
        mAlignTextViewParams.weight = 1.0f;
        mAlignTextView.setLayoutParams(mAlignTextViewParams);
        mAlignTextView.setText(this.mTextUtil.setString("string_align"));
        mAlignTextView.setTextColor(-16777216);
        mAlignTextView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(15.0f));
        mAlignTextView.setGravity(17);
        linearLayout2.addView(mAlignTextView);
        LinearLayout.LayoutParams mAlignLeftBtnParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(44.0f), this.mDrawableImg.getIntValueAppliedDensity(27.0f));
        mAlignLeftBtnParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(11.0f);
        mAlignLeftBtnParams.gravity = 16;
        this.mAlignLeftBtn = new ImageButton(this.mContext);
        this.mAlignLeftBtn.setLayoutParams(mAlignLeftBtnParams);
        this.mAlignLeftBtn.setFocusable(false);
        this.mAlignLeftBtn.setImageDrawable(this.mDrawableImg.setDrawableSelectImg("snote_text_left", mLeftIconPressPath, mLeftIconPressPath));
        linearLayout2.addView(this.mAlignLeftBtn);
        LinearLayout.LayoutParams mAlignCenterBtnParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(44.0f), this.mDrawableImg.getIntValueAppliedDensity(27.0f));
        mAlignCenterBtnParams.gravity = 16;
        this.mAlignCenterBtn = new ImageButton(this.mContext);
        this.mAlignCenterBtn.setLayoutParams(mAlignCenterBtnParams);
        this.mAlignCenterBtn.setFocusable(false);
        this.mAlignCenterBtn.setImageDrawable(this.mDrawableImg.setDrawableSelectImg(mCenterIocnPath, mCenterIconPressPath, mCenterIconPressPath));
        linearLayout2.addView(this.mAlignCenterBtn);
        this.mAlignRightBtn = new ImageButton(this.mContext);
        this.mAlignRightBtn.setLayoutParams(mAlignCenterBtnParams);
        this.mAlignRightBtn.setFocusable(false);
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mAlignLeftBtn, mButtonBgPath, mButtonBgPressPath, mButtonBgPressPath);
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mAlignCenterBtn, mButtonBgPath, mButtonBgPressPath, mButtonBgPressPath);
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mAlignRightBtn, mButtonBgPath, mButtonBgPressPath, mButtonBgPressPath);
        this.mAlignRightBtn.setImageDrawable(this.mDrawableImg.setDrawableSelectImg(mRightIconPath, mRightIconPressPath, mRightIconPressPath));
        linearLayout2.addView(this.mAlignRightBtn);
        LinearLayout linearLayout3 = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams paragraphSettingIndentLayoutParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(54.0f));
        paragraphSettingIndentLayoutParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(6.0f);
        paragraphSettingIndentLayoutParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(7.0f);
        paragraphSettingIndentLayoutParams.gravity = 16;
        linearLayout3.setLayoutParams(paragraphSettingIndentLayoutParams);
        linearLayout3.setOrientation(0);
        TextView indentTextView = new TextView(this.mContext);
        LinearLayout.LayoutParams indentTextParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(54.0f));
        indentTextParams.weight = 1.0f;
        indentTextView.setLayoutParams(indentTextParams);
        indentTextView.setText(this.mTextUtil.setString("string_indent"));
        indentTextView.setTextColor(-16777216);
        indentTextView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(15.0f));
        indentTextView.setGravity(17);
        linearLayout3.addView(indentTextView);
        this.mIndentLeftBtn = new ImageButton(this.mContext);
        LinearLayout.LayoutParams indentLeftBtnParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(44.0f), this.mDrawableImg.getIntValueAppliedDensity(27.0f));
        indentLeftBtnParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(11.0f);
        indentLeftBtnParams.gravity = 16;
        this.mIndentLeftBtn.setLayoutParams(indentLeftBtnParams);
        this.mIndentLeftBtn.setImageDrawable(this.mDrawableImg.setDrawableSelectImg(mLeftIndentIconPath, mLeftIndentIconPath, mLeftIndentIconPath));
        linearLayout3.addView(this.mIndentLeftBtn);
        this.mIndentRightBtn = new ImageButton(this.mContext);
        LinearLayout.LayoutParams indentRightBtnParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(44.0f), this.mDrawableImg.getIntValueAppliedDensity(27.0f));
        indentRightBtnParams.gravity = 16;
        this.mIndentRightBtn.setLayoutParams(indentRightBtnParams);
        this.mIndentRightBtn.setFocusable(false);
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mIndentLeftBtn, mButtonBgPath, mButtonBgPressPath, mButtonBgPressPath);
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mIndentRightBtn, mButtonBgPath, mButtonBgPressPath, mButtonBgPressPath);
        this.mIndentRightBtn.setImageDrawable(this.mDrawableImg.setDrawableSelectImg(mRightIndentIconPath, mRightIndentIconPath, mRightIndentIconPath));
        linearLayout3.addView(this.mIndentRightBtn);
        LinearLayout linearLayout4 = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams paragraphSettingSpacingLayoutParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(54.0f));
        paragraphSettingSpacingLayoutParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(6.0f);
        paragraphSettingSpacingLayoutParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(7.0f);
        paragraphSettingSpacingLayoutParams.gravity = 16;
        linearLayout4.setLayoutParams(paragraphSettingSpacingLayoutParams);
        linearLayout4.setOrientation(0);
        TextView spacingTextView = new TextView(this.mContext);
        LinearLayout.LayoutParams spacingTextParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(54.0f));
        spacingTextParams.weight = 1.0f;
        spacingTextView.setLayoutParams(spacingTextParams);
        spacingTextView.setText(this.mTextUtil.setString("string_line_spacing"));
        spacingTextView.setTextColor(-16777216);
        spacingTextView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(15.0f));
        spacingTextView.setGravity(17);
        linearLayout4.addView(spacingTextView);
        this.mFontLineSpaceSpinner = new Spinner(this.mContext);
        LinearLayout.LayoutParams spinnerBtnParams = new LinearLayout.LayoutParams(-2, -2);
        spinnerBtnParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(11.0f);
        spinnerBtnParams.gravity = 16;
        this.mFontLineSpaceSpinner.setLayoutParams(spinnerBtnParams);
        String[] numbers = {SimpleUserInfo.STATE_DENY, "11", NativeFormatInterface.DISPLAY_TIME_AS_12_HOURS, "13", "14", "15", "16", "17", "18", "19", "20", "22", NativeFormatInterface.DISPLAY_TIME_AS_24_HOURS, "26", "28", "30", "32", "36", "40", "43", "44", "48", "52", "56", "60", "64", "68", "72", "80", "88"};
        ArrayAdapter<String> adpater = new ArrayAdapter<>(this.mContext, R.layout.simple_spinner_item, numbers);
        this.mFontLineSpaceSpinner.setAdapter((SpinnerAdapter) adpater);
        this.mFontLineSpaceSpinner.setSelection(19);
        this.mFontLineSpaceSpinner.setOnItemSelectedListener(this.mTextLineSpacingSettingListener);
        linearLayout4.addView(this.mFontLineSpaceSpinner);
        linearLayout.addView(linearLayout2);
        linearLayout.addView(linearLayout3);
        linearLayout.addView(linearLayout4);
        return linearLayout;
    }

    private Button fontSizeSpinner() {
        this.mFontSizeButton = new Button(this.mContext);
        LinearLayout.LayoutParams fontSizeParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(36.0f), this.mDrawableImg.getIntValueAppliedDensity(27.0f));
        fontSizeParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(5.0f);
        this.mFontSizeButton.setLayoutParams(fontSizeParams);
        if (mSdkVersion < 16) {
            this.mFontSizeButton.setBackgroundDrawable(this.mDrawableImg.setDrawableSelectImg(mDropdownNormalPath, mDropdownPressPath, mDropdownFocusPath));
        } else {
            this.mFontSizeButton.setBackground(this.mDrawableImg.setDrawableSelectImg(mDropdownNormalPath, mDropdownPressPath, mDropdownFocusPath));
        }
        this.mFontSizeButton.setGravity(19);
        this.mFontSizeButton.setPadding(this.mDrawableImg.getIntValueAppliedDensity(6.0f), 0, 0, 0);
        this.mFontSizeButton.setSingleLine(true);
        this.mFontSizeButton.setTextColor(Color.rgb(0, 0, 0));
        this.mFontSizeButton.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(15.0f));
        this.mFontSizeButton.setText(this.mCurrentFontSize);
        this.mFontSizeButton.setEllipsize(TextUtils.TruncateAt.END);
        this.mFontSizeButton.setOnClickListener(this.mFontSizeOnClickListener);
        return this.mFontSizeButton;
    }

    private ViewGroup fontTypeSpinnerView() {
        LinearLayout fontTypeSpinnerLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams fontTypeSpinnerLayoutParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(88.0f), this.mDrawableImg.getIntValueAppliedDensity(27.0f));
        fontTypeSpinnerLayout.setLayoutParams(fontTypeSpinnerLayoutParams);
        fontTypeSpinnerLayoutParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(7.0f);
        fontTypeSpinnerLayout.addView(fontTypeSpinner());
        return fontTypeSpinnerLayout;
    }

    private Button fontTypeSpinner() {
        this.mFontTypeButton = new Button(this.mContext);
        LinearLayout.LayoutParams fontTypeParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(88.0f), this.mDrawableImg.getIntValueAppliedDensity(27.0f));
        this.mFontTypeButton.setLayoutParams(fontTypeParams);
        if (mSdkVersion < 16) {
            this.mFontTypeButton.setBackgroundDrawable(this.mDrawableImg.setDrawableSelectImg(mDropdownNormalPath, mDropdownPressPath, mDropdownFocusPath));
        } else {
            this.mFontTypeButton.setBackground(this.mDrawableImg.setDrawableSelectImg(mDropdownNormalPath, mDropdownPressPath, mDropdownFocusPath));
        }
        this.mFontTypeButton.setGravity(19);
        this.mFontTypeButton.setPadding(this.mDrawableImg.getIntValueAppliedDensity(6.0f), 0, this.mDrawableImg.getIntValueAppliedDensity(10.0f), 0);
        this.mFontTypeButton.setSingleLine(true);
        this.mFontTypeButton.setTextColor(Color.rgb(0, 0, 0));
        this.mFontTypeButton.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(15.0f));
        this.mFontTypeButton.setText(this.mCurrentFontName);
        if (mSdkVersion >= 16) {
            this.mFontTypeButton.setEllipsize(TextUtils.TruncateAt.END);
        } else {
            this.mFontTypeButton.setEllipsize(null);
        }
        this.mFontTypeButton.setOnClickListener(this.mFontTypeOnClickListener);
        return this.mFontTypeButton;
    }

    private ViewGroup colorSelectedAndPicker() {
        RelativeLayout localLinearLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(118.0f));
        localLinearLayout.setLayoutParams(localLayoutParams);
        this.mPickerView = PickerView();
        this.mPaletteView = PaletteView();
        this.mPaletteBg = paletteBg();
        localLinearLayout.addView(this.mPaletteBg);
        localLinearLayout.addView(this.mPaletteView);
        localLinearLayout.addView(this.mPickerView);
        return localLinearLayout;
    }

    private ViewGroup paletteBg() {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams bodyBgParam = new RelativeLayout.LayoutParams(-1, -1);
        bodyBgParam.setMargins(0, 0, 0, 0);
        relativeLayout.setLayoutParams(bodyBgParam);
        relativeLayout.setPadding(0, 0, 0, 0);
        ImageView paletteLeft = new ImageView(this.mContext);
        RelativeLayout.LayoutParams bodyLeftParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(125.3f), -1);
        bodyLeftParam.alignWithParent = true;
        bodyLeftParam.addRule(9);
        bodyLeftParam.addRule(10);
        paletteLeft.setLayoutParams(bodyLeftParam);
        ImageView paletteRight = new ImageView(this.mContext);
        RelativeLayout.LayoutParams bodyRightParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(125.3f), -1);
        bodyRightParam.alignWithParent = true;
        bodyRightParam.addRule(11);
        bodyRightParam.addRule(10);
        paletteRight.setLayoutParams(bodyRightParam);
        this.mImageLoader.addViewSetBackgroundImageLoad(paletteLeft, grayBodyLeftPath);
        this.mImageLoader.addViewSetBackgroundImageLoad(paletteRight, grayBodyRightPath);
        relativeLayout.addView(paletteLeft);
        relativeLayout.addView(paletteRight);
        return relativeLayout;
    }

    private ViewGroup PickerView() {
        RelativeLayout localLinearLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(48.0f));
        localLayoutParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(28.0f);
        localLayoutParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(28.0f);
        localLayoutParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(66.0f);
        localLinearLayout.setLayoutParams(localLayoutParams);
        this.mColorGradationView = colorPickerView();
        localLinearLayout.addView(this.mColorGradationView);
        return localLinearLayout;
    }

    private ViewGroup PaletteView() {
        RelativeLayout sizeDisplayLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams sizeDisplayLayoutParam = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(55.0f));
        sizeDisplayLayoutParam.setMargins(this.mDrawableImg.getIntValueAppliedDensity(8.0f), this.mDrawableImg.getIntValueAppliedDensity(6.0f), this.mDrawableImg.getIntValueAppliedDensity(8.0f), 0);
        sizeDisplayLayout.setLayoutParams(sizeDisplayLayoutParam);
        sizeDisplayLayout.setLayoutParams(sizeDisplayLayoutParam);
        this.mPaletteRightButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams rightImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(18.0f), this.mDrawableImg.getIntValueAppliedDensity(55.0f));
        rightImageParam.alignWithParent = true;
        rightImageParam.addRule(11);
        rightImageParam.addRule(15);
        this.mPaletteRightButton.setLayoutParams(rightImageParam);
        this.mPaletteRightButton.setContentDescription(this.mTextUtil.setString("string_next"));
        if (mSdkVersion < 16) {
            this.mPaletteRightButton.setBackgroundDrawable(this.mDrawableImg.setDrawableDimImg(rightBgPath, rightBgPressPath, rightBgFocusPath, rightBgDimPath, 18, 55));
        } else {
            this.mPaletteRightButton.setBackground(this.mDrawableImg.setDrawableDimImg(rightBgPath, rightBgPressPath, rightBgFocusPath, rightBgDimPath, 18, 55));
        }
        this.mPaletteLeftButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams leftImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(18.0f), this.mDrawableImg.getIntValueAppliedDensity(55.0f));
        leftImageParam.alignWithParent = true;
        leftImageParam.addRule(9);
        leftImageParam.addRule(15);
        this.mPaletteLeftButton.setLayoutParams(leftImageParam);
        this.mPaletteLeftButton.setContentDescription(this.mTextUtil.setString("string_back"));
        if (mSdkVersion < 16) {
            this.mPaletteLeftButton.setBackgroundDrawable(this.mDrawableImg.setDrawableDimImg(leftBgPath, lefBgPressPath, lefBgFocusPath, lefBgDimPath, 18, 55));
        } else {
            this.mPaletteLeftButton.setBackground(this.mDrawableImg.setDrawableDimImg(leftBgPath, lefBgPressPath, lefBgFocusPath, lefBgDimPath, 18, 55));
        }
        this.mColorPaletteView = colorPaletteView();
        sizeDisplayLayout.addView(this.mPaletteLeftButton);
        sizeDisplayLayout.addView(this.mColorPaletteView);
        sizeDisplayLayout.addView(this.mPaletteRightButton);
        return sizeDisplayLayout;
    }

    private SpenColorPaletteView colorPaletteView() {
        SpenColorPaletteView colorPaletteView = new SpenColorPaletteView(this.mContext, this.mDrawableImg.mCustom_imagepath, this.mScale);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(194.0f), -2);
        localLayoutParams.alignWithParent = true;
        localLayoutParams.addRule(14);
        localLayoutParams.addRule(15);
        colorPaletteView.setLayoutParams(localLayoutParams);
        colorPaletteView.setClickable(true);
        colorPaletteView.setFocusable(true);
        colorPaletteView.setContentDescription(this.mTextUtil.setString("string_palette"));
        return colorPaletteView;
    }

    private SpenColorGradationView colorPickerView() {
        SpenColorGradationView localf = new SpenColorGradationView(this.mContext, this.mDrawableImg.mCustom_imagepath, this.mScale);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(48.0f));
        localf.setLayoutParams(localLayoutParams);
        localf.setClickable(true);
        localf.setContentDescription(this.mTextUtil.setString("string_gradation"));
        localf.setPadding(0, 0, 0, 0);
        return localf;
    }

    private View bottomLayout() {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams bottomLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(16.0f));
        bottomLayoutParams.setMargins(0, this.mDrawableImg.getIntValueAppliedDensity((this.deltaPreview + BODY_LAYOUT_HEIGHT) - 16), 0, 0);
        relativeLayout.setLayoutParams(bottomLayoutParams);
        this.mBottomExtendBg = new ImageView(this.mContext);
        this.mBottomExtendBg.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(16.0f)));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mBottomExtendBg, bottomExpandPath, bottomExpandPressPath, bottomExpandPressPath);
        if (mSdkVersion < 16) {
            this.mBottomExtendBg.setBackgroundDrawable(this.mDrawableImg.setDrawableSelectImg(bottomExpandPath, bottomExpandPressPath, bottomExpandPressPath));
        } else {
            this.mBottomExtendBg.setBackground(this.mDrawableImg.setDrawableSelectImg(bottomExpandPath, bottomExpandPressPath, bottomExpandPressPath));
        }
        ImageView bottomHandle = new ImageView(this.mContext);
        RelativeLayout.LayoutParams bottomHandleParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(22.0f), this.mDrawableImg.getIntValueAppliedDensity(16.0f));
        bottomHandleParam.alignWithParent = true;
        bottomHandleParam.addRule(14);
        bottomHandleParam.addRule(8);
        bottomHandleParam.bottomMargin = this.mDrawableImg.getIntValueAppliedDensity(-1.0f);
        bottomHandle.setLayoutParams(bottomHandleParam);
        bottomHandle.setImageDrawable(this.mDrawableImg.setDrawableImg(bottomHandlePath, 22, 16));
        relativeLayout.addView(this.mBottomExtendBg);
        relativeLayout.addView(bottomHandle);
        relativeLayout.setOnHoverListener(this.mHoverListener);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rotatePosition() {
        Log.v(TAG, "==== SettingText ====");
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
        int minWidth = this.mDrawableImg.getIntValueAppliedDensity(250.0f);
        int minHeight = this.mDrawableImg.getIntValueAppliedDensity(143.0f + this.deltaPreview);
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

    protected View textSettingScroll() {
        SpenThumbControlBackGround localThumbControlBackGround = new SpenThumbControlBackGround(this.mContext);
        localThumbControlBackGround.setTrackWidth(this.mDrawableImg.getIntValueAppliedDensity(4.0f));
        localThumbControlBackGround.setTopPadding(this.mDrawableImg.getIntValueAppliedDensity(7.5f));
        LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(25.0f), -1);
        localLayoutParams1.topMargin = this.mDrawableImg.getIntValueAppliedDensity(2.0f);
        localLayoutParams1.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(8.0f);
        localThumbControlBackGround.setLayoutParams(localLayoutParams1);
        localThumbControlBackGround.setPadding(this.mDrawableImg.getIntValueAppliedDensity(3.0f), this.mDrawableImg.getIntValueAppliedDensity(3.0f), this.mDrawableImg.getIntValueAppliedDensity(3.0f), this.mDrawableImg.getIntValueAppliedDensity(3.0f));
        this.mImageLoader.addViewSetBackgroundImageLoad(localThumbControlBackGround, mOptionBgPath);
        RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
        localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mScrollHandle = new ImageView(this.mContext);
        LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.mScrollHandle.setLayoutParams(localLayoutParams2);
        this.mScrollHandle.setScaleType(ImageView.ScaleType.CENTER);
        this.mScrollHandle.setPadding(0, this.mDrawableImg.getIntValueAppliedDensity(7.5f), 0, 0);
        this.mScrollHandle.setImageDrawable(this.mDrawableImg.setDrawableImg(mScrollHandelNormal));
        localRelativeLayout.addView(this.mScrollHandle);
        localThumbControlBackGround.addView(localRelativeLayout);
        return localThumbControlBackGround;
    }

    public int getViewMode() {
        return this.mViewMode;
    }

    public void setViewMode(int viewMode) {
        this.mViewMode = viewMode;
        if (this.mColorPickerSetting.mSpuitSettings.isShown()) {
            this.mColorPickerSetting.hide();
            if (this.mCanvasView != null) {
                this.mCanvasView.setToolTypeAction(2, this.mPreCanvasPenAction);
                this.mCanvasView.setToolTypeAction(1, this.mPreCanvasFingerAction);
            }
        }
        this.mScrollView.setScrollingEnabled(true);
        this.mColorPaletteView.setColor(this.mSettingInfo.color);
        switch (this.mViewMode) {
            case 0:
                this.mBodyLayout.setVisibility(0);
                this.mTextSettingPreview.setVisibility(0);
                this.mFontSizeSpinnerOptButton.setVisibility(0);
                this.mFontTypeSpinnerView.setVisibility(0);
                this.mFontSizeSpinnerView.setVisibility(0);
                this.mFontSizeSpinnerView.invalidate();
                this.mBoldBtn.setVisibility(0);
                this.mItalicBtn.setVisibility(0);
                this.mUnderlineBtn.setVisibility(0);
                this.mColorSelectedAndPicker.setVisibility(0);
                this.mColorGradationView.setVisibility(0);
                this.mBottomLayout.setVisibility(0);
                this.mParagraphSetting.setVisibility(8);
                if (getHeight() == this.mDrawableImg.getIntValueAppliedDensity(41.0f)) {
                    setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(this.deltaPreview + BODY_LAYOUT_HEIGHT));
                }
                if (this.mCanvasLayout.getHeight() > 0 && this.mBodyLayoutHeight > this.mCanvasLayout.getHeight()) {
                    setExpandBarPosition((this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(16.0f)) - this.mDrawableImg.getIntValueAppliedDensity(41.0f));
                }
                if (!this.isFirstTime) {
                    LinearLayout.LayoutParams colorPickerParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(66.0f));
                    this.mColorSelectedAndPicker.setLayoutParams(colorPickerParams);
                    break;
                } else {
                    this.mColorGradationView.setVisibility(0);
                    break;
                }
            case 1:
                this.mBodyLayout.setVisibility(0);
                this.mTextSettingPreview.setVisibility(0);
                this.mFontSizeSpinnerOptButton.setVisibility(0);
                this.mFontTypeSpinnerView.setVisibility(0);
                this.mFontSizeSpinnerView.setVisibility(0);
                this.mBoldBtn.setVisibility(0);
                this.mItalicBtn.setVisibility(0);
                this.mUnderlineBtn.setVisibility(0);
                this.mColorSelectedAndPicker.setVisibility(8);
                this.mColorGradationView.setVisibility(8);
                this.mBottomLayout.setVisibility(0);
                this.mParagraphSetting.setVisibility(8);
                setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(110.0f));
                break;
            case 2:
                this.mBodyLayout.setVisibility(0);
                this.mTextSettingPreview.setVisibility(8);
                this.mFontSizeSpinnerOptButton.setVisibility(0);
                this.mFontTypeSpinnerView.setVisibility(0);
                this.mFontSizeSpinnerView.setVisibility(0);
                this.mBoldBtn.setVisibility(0);
                this.mItalicBtn.setVisibility(0);
                this.mUnderlineBtn.setVisibility(0);
                this.mColorSelectedAndPicker.setVisibility(8);
                this.mColorGradationView.setVisibility(8);
                this.mBottomLayout.setVisibility(0);
                this.mParagraphSetting.setVisibility(8);
                setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(39.0f));
                break;
            case 3:
                this.mBodyLayout.setVisibility(0);
                this.mTextSettingPreview.setVisibility(8);
                this.mFontSizeSpinnerOptButton.setVisibility(0);
                this.mFontTypeSpinnerView.setVisibility(8);
                this.mFontSizeSpinnerView.setVisibility(8);
                this.mBoldBtn.setVisibility(0);
                this.mItalicBtn.setVisibility(0);
                this.mUnderlineBtn.setVisibility(0);
                this.mColorSelectedAndPicker.setVisibility(8);
                this.mColorGradationView.setVisibility(8);
                this.mBottomLayout.setVisibility(0);
                this.mParagraphSetting.setVisibility(8);
                setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(39.0f));
                break;
            case 4:
                this.mBodyLayout.setVisibility(0);
                this.mTextSettingPreview.setVisibility(8);
                this.mFontTypeSpinnerView.setVisibility(8);
                this.mFontSizeSpinnerView.setVisibility(8);
                this.mBoldBtn.setVisibility(8);
                this.mItalicBtn.setVisibility(8);
                this.mUnderlineBtn.setVisibility(8);
                this.mFontSizeSpinnerOptButton.setVisibility(8);
                this.mColorSelectedAndPicker.setVisibility(0);
                this.mColorGradationView.setVisibility(0);
                this.mBottomLayout.setVisibility(0);
                this.mParagraphSetting.setVisibility(8);
                setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(120.0f));
                RelativeLayout.LayoutParams palletBgParam = (RelativeLayout.LayoutParams) this.mPaletteBg.getLayoutParams();
                palletBgParam.height = this.mDrawableImg.getIntValueAppliedDensity(120.0f);
                this.mPaletteBg.setLayoutParams(palletBgParam);
                break;
            case 5:
                this.mBodyLayout.setVisibility(0);
                this.mTextSettingPreview.setVisibility(8);
                this.mFontSizeSpinnerOptButton.setVisibility(8);
                this.mFontTypeSpinnerView.setVisibility(8);
                this.mFontSizeSpinnerView.setVisibility(8);
                this.mBoldBtn.setVisibility(8);
                this.mItalicBtn.setVisibility(8);
                this.mUnderlineBtn.setVisibility(8);
                this.mColorSelectedAndPicker.setVisibility(8);
                this.mColorGradationView.setVisibility(8);
                this.mBottomLayout.setVisibility(0);
                this.mParagraphSetting.setVisibility(0);
                this.mScrollView.setScrollingEnabled(false);
                break;
            case 6:
                this.mBodyLayout.setVisibility(8);
                this.mTitleLayout.setVisibility(0);
                if (this.mCanvasLayout.getHeight() > 0 && this.mBodyLayoutHeight > this.mCanvasLayout.getHeight()) {
                    setExpandBarPosition((this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(16.0f)) - this.mDrawableImg.getIntValueAppliedDensity(41.0f));
                    break;
                }
                break;
            default:
                this.mViewMode = 0;
                this.mBodyLayout.setVisibility(0);
                this.mTextSettingPreview.setVisibility(0);
                this.mFontSizeSpinnerOptButton.setVisibility(8);
                this.mFontTypeSpinnerView.setVisibility(0);
                this.mFontSizeSpinnerView.setVisibility(0);
                this.mFontSizeSpinnerView.invalidate();
                this.mBoldBtn.setVisibility(0);
                this.mItalicBtn.setVisibility(0);
                this.mUnderlineBtn.setVisibility(0);
                this.mColorSelectedAndPicker.setVisibility(0);
                this.mColorGradationView.setVisibility(0);
                this.mBottomLayout.setVisibility(0);
                this.mParagraphSetting.setVisibility(8);
                break;
        }
    }

    void setExpandBarPosition(int position) {
        if (!this.isFirstTime) {
            this.deltaOfFirstTime = 52;
        } else {
            this.deltaOfFirstTime = 0;
        }
        Log.d(TAG, "setExpandBarPosition position " + position);
        RelativeLayout.LayoutParams expandParams = (RelativeLayout.LayoutParams) this.mBottomLayout.getLayoutParams();
        expandParams.topMargin = position;
        if (expandParams.topMargin > this.mDrawableImg.getIntValueAppliedDensity((this.deltaPreview + BODY_LAYOUT_HEIGHT) - this.deltaOfFirstTime)) {
            expandParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity((this.deltaPreview + BODY_LAYOUT_HEIGHT) - this.deltaOfFirstTime);
            RelativeLayout.LayoutParams bottomLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
            bottomLayoutParams.setMargins(0, this.mDrawableImg.getIntValueAppliedDensity((this.deltaPreview + BODY_LAYOUT_HEIGHT) - 16), 0, 0);
            this.mBottomLayout.setLayoutParams(bottomLayoutParams);
            RelativeLayout.LayoutParams bodyBgParam = new RelativeLayout.LayoutParams(-1, -2);
            this.mBodyBg.setLayoutParams(bodyBgParam);
        }
        if (this.mCanvasLayout.getHeight() > 0 && expandParams.topMargin + this.mDrawableImg.getIntValueAppliedDensity(16.0f) > this.mCanvasLayout.getHeight()) {
            expandParams.topMargin = (this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(16.0f)) - this.mDrawableImg.getIntValueAppliedDensity(41.0f);
            if (expandParams.topMargin < 0) {
                expandParams.topMargin = 0;
            }
        }
        if (this.mViewMode == 1) {
            expandParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(120.0f + this.deltaPreview);
        }
        if (this.mViewMode == 2 || this.mViewMode == 3) {
            expandParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(39.0f);
        }
        if (this.mViewMode == 4) {
            expandParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(118.0f);
        }
        if (this.mViewMode == 5) {
            expandParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(200.0f);
        }
        if (expandParams.topMargin < this.mDrawableImg.getIntValueAppliedDensity(this.deltaPreview + 85.0f)) {
            expandParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(this.deltaPreview + 85.0f);
        }
        this.mBodyLayoutHeight = expandParams.topMargin;
        LinearLayout.LayoutParams bodyParam = (LinearLayout.LayoutParams) this.mBodyLayout.getLayoutParams();
        bodyParam.height = this.mBodyLayoutHeight + this.mDrawableImg.getIntValueAppliedDensity(16.0f);
        this.mBodyLayout.setLayoutParams(bodyParam);
        RelativeLayout.LayoutParams PaletteBgParam = (RelativeLayout.LayoutParams) this.mPaletteBg.getLayoutParams();
        PaletteBgParam.height = (this.mDrawableImg.getIntValueAppliedDensity(118.0f) - (this.mDrawableImg.getIntValueAppliedDensity(this.deltaPreview + BODY_LAYOUT_HEIGHT) - this.mBodyLayoutHeight)) + this.mScrollY;
        PaletteBgParam.setMargins(0, 0, 0, 0);
        if (PaletteBgParam.height >= 0) {
            this.mPaletteBg.setLayoutParams(PaletteBgParam);
        }
        RelativeLayout.LayoutParams bottomLayoutParams2 = (RelativeLayout.LayoutParams) this.mBottomLayout.getLayoutParams();
        bottomLayoutParams2.setMargins(0, this.mBodyLayoutHeight, 0, 0);
        this.mBottomLayout.setLayoutParams(bottomLayoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextStyle(View paramView) {
        if (this.mTextPreView != null) {
            int mStyleButton = 2;
            while (true) {
                if (mStyleButton > 4) {
                    break;
                }
                if (!paramView.equals(this.mTextSizeButtonView[mStyleButton])) {
                    mStyleButton++;
                } else if (this.mTextSizeButtonView[mStyleButton].isSelected()) {
                    this.mTextSizeButtonView[mStyleButton].setSelected(false);
                    paramView.setSelected(false);
                    if (mStyleButton == 2) {
                        this.mTextPreView.setPreviewBold(false);
                    } else if (mStyleButton == 3) {
                        this.mTextPreView.setPreviewTextSkewX(false);
                    } else if (mStyleButton == 4) {
                        this.mTextPreView.setPreviewUnderLine(false);
                    }
                } else {
                    this.mTextSizeButtonView[mStyleButton].setSelected(false);
                    paramView.setSelected(true);
                    if (mStyleButton == 2) {
                        this.mTextPreView.setPreviewBold(true);
                    } else if (mStyleButton == 3) {
                        this.mTextPreView.setPreviewTextSkewX(true);
                    } else if (mStyleButton == 4) {
                        this.mTextPreView.setPreviewUnderLine(true);
                    }
                }
            }
            char textType = this.mTextPreView.getTextStyle();
            if (this.mCanvasView != null) {
                SpenSettingTextInfo info = this.mCanvasView.getTextSettingInfo();
                info.style = textType;
                this.mCanvasView.setTextSettingInfo(info);
            }
            this.mTextPreView.invalidate();
        }
    }

    public SpenSettingTextInfo getInfo() {
        return this.mSettingInfo;
    }

    public void setInfo(SpenSettingTextInfo settingInfo) {
        if (settingInfo != null) {
            this.mSettingInfo.font = settingInfo.font;
            this.mSettingInfo.align = settingInfo.align;
            this.mSettingInfo.color = settingInfo.color;
            this.mSettingInfo.size = settingInfo.size;
            this.mSettingInfo.style = settingInfo.style;
            this.mSettingInfo.lineIndent = settingInfo.lineIndent;
            this.mSettingInfo.lineSpacing = settingInfo.lineSpacing;
            this.mSettingInfo.direction = settingInfo.direction;
            if (this.mCanvasView != null) {
                SpenSettingTextInfo info = this.mCanvasView.getTextSettingInfo();
                info.font = settingInfo.font;
                info.align = settingInfo.align;
                info.color = settingInfo.color;
                info.size = settingInfo.size;
                info.style = settingInfo.style;
                info.lineIndent = settingInfo.lineIndent;
                info.lineSpacing = settingInfo.lineSpacing;
                info.direction = settingInfo.direction;
                this.mCanvasView.setTextSettingInfo(info);
            }
            this.mTextPreView.setPreviewTextColor(this.mSettingInfo.color);
            this.mTextPreView.setPreviewTextSize(this.mSettingInfo.size);
            this.mTextPreView.setPreviewTypeface(SpenFont.getTypeFace(this.mSettingInfo.font));
            this.mColorPickerSetting.setColorPickerColor(this.mSettingInfo.color);
            if (this.mCanvasView != null) {
                if (this.mCanvasView.getCanvasWidth() < this.mCanvasView.getCanvasHeight()) {
                    this.mCanvasWidth = this.mCanvasView.getCanvasWidth();
                } else {
                    this.mCanvasWidth = this.mCanvasView.getCanvasHeight();
                }
                if (this.mCanvasWidth == 0) {
                    this.mCanvasWidth = 1080;
                }
            } else {
                this.mCanvasWidth = 1080;
            }
            this.mCurrentFontName = SpenFont.getFontName(this.mSettingInfo.font);
            if (mSdkVersion < 16 && this.mFontTypeButton.getWidth() > 0) {
                String mTempFontName = this.mCurrentFontName;
                Paint mPaint = new Paint();
                if (this.mCurrentFontName != null) {
                    int mTextWidth = this.mDrawableImg.getIntValueAppliedDensity(mPaint.measureText(mTempFontName));
                    if (mTextWidth >= this.mFontTypeButton.getWidth() - this.mDrawableImg.getIntValueAppliedDensity(33.0f)) {
                        while (mTextWidth > this.mFontTypeButton.getWidth() - this.mDrawableImg.getIntValueAppliedDensity(33.0f)) {
                            mTempFontName = mTempFontName.substring(0, mTempFontName.length() - 1);
                            mTextWidth = this.mDrawableImg.getIntValueAppliedDensity(mPaint.measureText(mTempFontName) + mPaint.measureText("..."));
                        }
                        this.mFontTypeButton.setText(String.valueOf(mTempFontName) + "...");
                    }
                } else {
                    this.mFontTypeButton.setText(this.mCurrentFontName);
                }
            } else {
                this.mFontTypeButton.setText(this.mCurrentFontName);
            }
            this.mFontTypeButton.setTypeface(SpenFont.getTypeFace(this.mSettingInfo.font));
            if (Math.round(this.mSettingInfo.size / ((float) (this.mCanvasWidth / 360.0d))) <= 0) {
                this.mCurrentFontSize = "";
            } else {
                this.mCurrentFontSize = String.valueOf(Math.round((this.mSettingInfo.size / ((float) (this.mCanvasWidth / 360.0d))) - 0.5f));
            }
            this.mFontSizeButton.setText(this.mCurrentFontSize);
            if (this.mSettingInfo.align == 0) {
                this.mAlignLeftBtn.setSelected(true);
                this.mAlignCenterBtn.setSelected(false);
                this.mAlignRightBtn.setSelected(false);
            } else if (this.mSettingInfo.align == 2) {
                this.mAlignLeftBtn.setSelected(false);
                this.mAlignCenterBtn.setSelected(true);
                this.mAlignRightBtn.setSelected(false);
            } else if (this.mSettingInfo.align == 1) {
                this.mAlignLeftBtn.setSelected(false);
                this.mAlignCenterBtn.setSelected(false);
                this.mAlignRightBtn.setSelected(true);
            }
            this.mColorPaletteView.setColor(this.mSettingInfo.color);
            if (SpenColorPaletteView.IS_COLOR_GRADATION_SELECT) {
                this.mColorGradationView.selectColorForGradiation(settingInfo.color, 20.0f / this.mDrawableImg.getIntValueAppliedDensity(1.0f));
            }
            for (int mStyleButton = 2; mStyleButton <= 4; mStyleButton++) {
                switch (mStyleButton) {
                    case 2:
                        if ((this.mSettingInfo.style & 1) == 1) {
                            this.mTextSizeButtonView[mStyleButton].setSelected(true);
                            this.mBoldBtn.setSelected(true);
                            this.mTextPreView.setPreviewBold(true);
                            break;
                        } else {
                            this.mTextSizeButtonView[mStyleButton].setSelected(false);
                            this.mBoldBtn.setSelected(false);
                            this.mTextPreView.setPreviewBold(false);
                            break;
                        }
                    case 3:
                        if ((this.mSettingInfo.style & 2) == 2) {
                            this.mTextSizeButtonView[mStyleButton].setSelected(true);
                            this.mItalicBtn.setSelected(true);
                            this.mTextPreView.setPreviewTextSkewX(true);
                            break;
                        } else {
                            this.mTextSizeButtonView[mStyleButton].setSelected(false);
                            this.mItalicBtn.setSelected(false);
                            this.mTextPreView.setPreviewTextSkewX(false);
                            break;
                        }
                    case 4:
                        if ((this.mSettingInfo.style & 4) == 4) {
                            this.mTextSizeButtonView[mStyleButton].setSelected(true);
                            this.mUnderlineBtn.setSelected(true);
                            this.mTextPreView.setPreviewUnderLine(true);
                            break;
                        } else {
                            this.mTextSizeButtonView[mStyleButton].setSelected(false);
                            this.mUnderlineBtn.setSelected(false);
                            this.mTextPreView.setPreviewUnderLine(false);
                            break;
                        }
                }
            }
            int i = 0;
            while (true) {
                if (i < this.mFontLineSpaceSpinner.getCount()) {
                    if (this.mSettingInfo.lineSpacing != Integer.parseInt((String) this.mFontLineSpaceSpinner.getItemAtPosition(i))) {
                        i++;
                    } else {
                        this.mFontLineSpaceSpinner.setSelection(i);
                    }
                }
            }
            this.mTextPreView.invalidate();
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

    protected int getSizeOption() {
        return this.mViewMode;
    }

    public void setCanvasView(SpenSettingViewInterface canvasView) {
        if (canvasView != null) {
            this.mCanvasView = canvasView;
        }
    }

    protected void scroll(float scrollYPosition) {
        if (scrollYPosition < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
        }
    }

    protected void onScroll(MotionEvent motionEvent) {
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        if (visibility == 0) {
            try {
                if (!this.mImageLoader.mLoaded) {
                    this.mImageLoader.loadImage();
                    if (1 != 0) {
                        if (this.mCanvasView != null) {
                            if (this.mCanvasView.getCanvasWidth() < this.mCanvasView.getCanvasHeight()) {
                                this.mCanvasWidth = this.mCanvasView.getCanvasWidth();
                            } else {
                                this.mCanvasWidth = this.mCanvasView.getCanvasHeight();
                            }
                            if (this.mCanvasWidth == 0) {
                                this.mCanvasWidth = 1080;
                            }
                        } else {
                            this.mCanvasWidth = 1080;
                        }
                        this.mCurrentFontName = SpenFont.getFontName(this.mSettingInfo.font);
                        this.mFontTypeButton.setText(this.mCurrentFontName);
                        this.mFontTypeButton.setTypeface(SpenFont.getTypeFace(this.mSettingInfo.font));
                        if (Math.round(this.mSettingInfo.size / ((float) (this.mCanvasWidth / 360.0d))) <= 0) {
                            this.mCurrentFontSize = "";
                        } else {
                            this.mCurrentFontSize = String.valueOf(Math.round((this.mSettingInfo.size / ((float) (this.mCanvasWidth / 360.0d))) - 0.5f));
                        }
                        this.mFontSizeButton.setText(this.mCurrentFontSize);
                        this.mTextPreView.setPreviewTextSize(this.mSettingInfo.size);
                        this.mTextPreView.setPreviewTypeface(SpenFont.getTypeFace(this.mSettingInfo.font));
                        this.mTextPreView.invalidate();
                    }
                }
            } catch (NullPointerException e) {
                return;
            }
        }
        if (this.mColorPickerSetting.mSpuitSettings != null) {
            if (this.mColorPickerSetting.mSpuitSettings.isShown()) {
                this.mColorPickerSetting.hide();
                if (this.mCanvasView != null) {
                    this.mCanvasView.setToolTypeAction(2, this.mPreCanvasPenAction);
                    this.mCanvasView.setToolTypeAction(1, this.mPreCanvasFingerAction);
                }
            }
            super.setVisibility(visibility);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        if (this.mColorPickerSetting != null && this.mColorPickerSetting.mSpuitSettings != null) {
            if (this.mColorPickerSetting.mSpuitSettings.isShown()) {
                this.mColorPickerSetting.hide();
                if (this.mCanvasView != null) {
                    this.mCanvasView.setToolTypeAction(2, this.mPreCanvasPenAction);
                    this.mCanvasView.setToolTypeAction(1, this.mPreCanvasFingerAction);
                }
            }
            super.onWindowVisibilityChanged(visibility);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        try {
            if (getVisibility() == 0) {
                if (this.mIsRotated2) {
                    this.mIsRotated2 = false;
                    onSizeChanged(w, this.mMovableRect.height(), oldw, oldh);
                    requestLayout();
                    return;
                }
                if (!this.mExpandFlag && this.mBodyLayoutHeight + this.mDrawableImg.getIntValueAppliedDensity(57.0f) > h) {
                    Log.d(TAG, "onSizeChanged height " + h);
                    setExpandBarPosition(h - this.mDrawableImg.getIntValueAppliedDensity(57.0f));
                }
                Handler handler = new Handler();
                handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout.21
                    @Override // java.lang.Runnable
                    public void run() {
                        SpenSettingTextLayout.this.requestLayout();
                    }
                });
                super.onSizeChanged(w, h, oldw, oldh);
            }
        } catch (NullPointerException e) {
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
