package com.samsung.android.sdk.pen.settingui;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
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
import com.samsung.android.sdk.pen.settingui.SPenFontNameDropdown2;
import com.samsung.android.sdk.pen.settingui.SPenFontSizeDropdown2;
import com.samsung.android.sdk.pen.settingui.SpenColorGradationView2;
import com.samsung.android.sdk.pen.settingui.SpenColorPaletteView2;
import com.samsung.android.sdk.pen.settingui.SpenScrollView;
import com.samsung.android.sdk.pen.util.SpenFont;
import com.sds.coolots.common.controller.NativeFormatInterface;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
class SpenSettingTextLayout2 extends LinearLayout {
    protected static final int BODY_LAYOUT_HEIGHT = 330;
    protected static final int BOTTOM_LAYOUT_HEIGHT = 17;
    protected static final int EXIT_BUTTON_RAW_HEIGHT = 42;
    protected static final int EXIT_BUTTON_RAW_WIDTH = 42;
    protected static final int LINE_BUTTON_RAW_HEIGHT = 17;
    protected static final int LINE_BUTTON_RAW_WIDTH = 1;
    protected static final int TEXT_SETTING_BOLD = 2;
    protected static final int TEXT_SETTING_ITALIC = 3;
    protected static final int TEXT_SETTING_UNDERLINE = 4;
    protected static final int TITLE_LAYOUT_HEIGHT = 42;
    public static final int VIEW_MODE_COLOR = 4;
    public static final int VIEW_MODE_MINIMUM = 1;
    public static final int VIEW_MODE_MINIMUM_WITHOUT_PREVIEW = 2;
    public static final int VIEW_MODE_NORMAL = 0;
    public static final int VIEW_MODE_PARAGRAPH = 5;
    public static final int VIEW_MODE_STYLE = 3;
    public static final int VIEW_MODE_TITLE = 6;
    private static final String bottomExpandPath = "snote_popup_bg_expand";
    private static final String bottomHandlePath = "snote_popup_handler";
    private static final String grayBodyLeftPath = "vienna_popup_bg02";
    private static final String lefBgFocuslPath = "snote_popup_arrow_left_focus";
    private static final String lefBgPresslPath = "snote_popup_arrow_left_press";
    private static final String leftBgPath = "snote_popup_arrow_left_normal";
    private static final String lightBodyLeftPath = "vienna_popup_bg";
    protected static final String mBgPath = "drawingpad_bg_3";
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
    private static final String popupMaxPath = "snote_popup_arrow_max_normal";
    private static final String popupMinPath = "snote_popup_arrow_min_normal";
    private static final String rightBgFocuslPath = "snote_popup_arrow_right_focus";
    private static final String rightBgPath = "snote_popup_arrow_right_normal";
    private static final String rightBgPresslPath = "snote_popup_arrow_right_press";
    private static final String titleRightPath = "vienna_popup_title_bg";
    protected int EXIT_BUTTON_HEIGHT;
    protected float EXIT_BUTTON_RIGHT_MARGIN;
    protected float EXIT_BUTTON_TOP_MARGIN;
    protected int EXIT_BUTTON_WIDTH;
    protected float LINE_BUTTON_TOP_MARGIN;
    protected ActionListener mActionListener;
    protected ImageButton mAlignCenterBtn;
    protected ImageButton mAlignLeftBtn;
    protected ImageButton mAlignRightBtn;
    protected View mBodyBg;
    protected View mBodyLayout;
    protected int mBodyLayoutHeight;
    protected ImageButton mBoldBtn;
    protected View mBottomLayout;
    protected RelativeLayout mCanvasLayout;
    protected SpenSettingViewInterface mCanvasView;
    protected int mCanvasWidth;
    protected View mColorPickerColor;
    private final SpenColorGradationView2.onColorChangedListener mColorPickerColorChangeListenerText;
    private final View.OnClickListener mColorPickerColorListener;
    protected SpenColorPickerLayout2 mColorPickerSetting;
    protected View mColorPickerSettingExitButton;
    protected SpenColorGradationView2 mColorPickerView;
    protected SpenColorPaletteView2 mColorSelectView;
    protected View mColorSelectedAndPicker;
    protected Context mContext;
    private int mCount;
    private String mCurrentFontName;
    private String mCurrentFontSize;
    protected SPenImageUtil mDrawableImg;
    private final View.OnClickListener mExitButtonListener;
    protected boolean mExpandFlag;
    protected boolean mFirstLongPress;
    protected Spinner mFontLineSpaceSpinner;
    private SPenFontNameDropdown2 mFontNameDropdown;
    private Button mFontSizeButton;
    private SPenFontSizeDropdown2 mFontSizeDropdown;
    private final View.OnClickListener mFontSizeOnClickListener;
    protected ViewGroup mFontSizeSpinnerOptButton;
    protected Button mFontSizeSpinnerView;
    private Button mFontTypeButton;
    private final View.OnClickListener mFontTypeOnClickListener;
    protected ViewGroup mFontTypeSpinnerView;
    private final Handler mHandler;
    private final View.OnHoverListener mHoverListener;
    private SpenImageLoader mImageLoader;
    protected ImageButton mIndentLeftBtn;
    protected ImageButton mIndentRightBtn;
    protected ImageButton mItalicBtn;
    protected int mLeftMargin;
    protected Rect mMovableRect;
    protected boolean mMoveTextsettingLayout;
    private final SpenColorPaletteView2.OnColorChangedListener mOnColorChangedListenerText;
    private final View.OnTouchListener mOnConsumedTouchListener;
    private final View.OnClickListener mPaletteBackButtonListener;
    protected View mPaletteBg;
    protected View mPaletteLeftButton;
    private final View.OnClickListener mPaletteNextButtonListener;
    protected View mPaletteRightButton;
    protected View mPaletteView;
    protected boolean mParaLineSpinner1stSelect;
    protected View mParagraphSetting;
    protected View mPickerView;
    private final View.OnClickListener mPopupButtonListener;
    private PopupListener mPopupListener;
    protected View mPopupMaxButton;
    protected View mPopupMinButton;
    protected int mPreCanvasFingerAction;
    protected int mPreCanvasPenAction;
    protected float mScale;
    protected ImageView mScrollHandle;
    private Timer mScrollTimer;
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
    protected SpenTextPreView2 mTextPreView;
    protected View mTextSettingPreview;
    protected View[] mTextSizeButtonView;
    protected SPenTextUtil mTextUtil;
    protected View mTitleLayout;
    protected int mTopMargin;
    protected int mTotalLeftMargin;
    protected int mTotalTopMargin;
    protected ImageButton mUnderlineBtn;
    protected int mViewMode;
    protected int mXDelta;
    protected int mYDelta;
    LinearLayout.LayoutParams totalLayoutParams;
    protected static int mSdkVersion = Build.VERSION.SDK_INT;
    protected static boolean mColorPickerShow = false;
    protected static boolean mFirstTimeColorPickerShow = false;
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

    public interface PopupListener {
        void onPopup(boolean z);
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
        try {
            if (!this.mFirstLongPress) {
                this.mMovableRect.set(getMovableRect());
                if (getVisibility() != 8) {
                    rotatePosition();
                }
            }
            super.onConfigurationChanged(newConfig);
            if (this.mColorPickerSetting != null) {
                this.mColorPickerSetting.resetPositionWhenRotateSpuitOut(this.mCanvasView.getCanvasWidth(), this.mCanvasView.getCanvasHeight());
            }
        } catch (NullPointerException e) {
        }
    }

    public void setPopupListenr(PopupListener listener) {
        if (listener != null) {
            this.mPopupListener = listener;
        }
    }

    public void setPopup(boolean open) {
        if (open) {
            this.mPopupMaxButton.setVisibility(8);
            this.mPopupMinButton.setVisibility(0);
            playScrollAnimationForBottomBar(2, getHeight(), this.mDrawableImg.getIntValueAppliedDensity(372.0f));
        } else {
            this.mPopupMaxButton.setVisibility(0);
            this.mPopupMinButton.setVisibility(8);
            playScrollAnimationForBottomBar(2, getHeight(), this.mDrawableImg.getIntValueAppliedDensity(42.0f));
        }
    }

    public SpenSettingTextLayout2(Context context, String customImagePath, HashMap<String, String> fontName, RelativeLayout relativeLayout) {
        super(context);
        this.mExpandFlag = false;
        this.mBodyLayoutHeight = -2;
        this.mPopupListener = null;
        this.mActionListener = null;
        this.mParaLineSpinner1stSelect = true;
        this.mTextFontSizeList = new ArrayList<>();
        this.mMoveTextsettingLayout = false;
        this.mScrollY = 0;
        this.mFirstLongPress = true;
        this.mScale = 1.0f;
        this.mCanvasWidth = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_PPT_SLIDEMOVEPREV_EVENT;
        this.mViewMode = 0;
        this.EXIT_BUTTON_RIGHT_MARGIN = 4.0f;
        this.mHandler = new Handler();
        this.mHoverListener = new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.1
            @Override // android.view.View.OnHoverListener
            public boolean onHover(View arg0, MotionEvent arg1) {
                return true;
            }
        };
        this.mColorPickerColorChangeListenerText = new SpenColorGradationView2.onColorChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.2
            @Override // com.samsung.android.sdk.pen.settingui.SpenColorGradationView2.onColorChangedListener
            public void onColorChanged(int color, int x, int y) {
                SpenSettingTextLayout2.this.mColorSelectView.setColor(SpenSettingTextLayout2.this.mTextPreView.getPreviewTextColor());
                if (SpenSettingTextLayout2.this.getVisibility() == 0) {
                    SpenSettingTextLayout2.this.mTextPreView.setPreviewTextColor(color);
                    SpenSettingTextLayout2.this.mTextPreView.invalidate();
                    if (SpenSettingTextLayout2.this.mCanvasView != null) {
                        SpenSettingTextInfo info = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                        info.color = color;
                        SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info);
                        SpenSettingTextLayout2.this.mColorPickerSetting.setColorPickerColor(info.color);
                        SpenSettingTextLayout2.this.mSettingInfo.color = color;
                    }
                }
            }
        };
        this.mOnColorChangedListenerText = new SpenColorPaletteView2.OnColorChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.3
            @Override // com.samsung.android.sdk.pen.settingui.SpenColorPaletteView2.OnColorChangedListener
            public void colorChanged(int color, int selectedItem) {
                if (SpenSettingTextLayout2.this.getVisibility() == 0) {
                    if (selectedItem == 13) {
                        SpenSettingTextLayout2.this.setViewMode(0);
                        if (SpenSettingTextLayout2.this.mCanvasView != null) {
                            SpenSettingTextLayout2.this.mPreCanvasPenAction = SpenSettingTextLayout2.this.mCanvasView.getToolTypeAction(2);
                            SpenSettingTextLayout2.this.mPreCanvasFingerAction = SpenSettingTextLayout2.this.mCanvasView.getToolTypeAction(1);
                            SpenSettingTextLayout2.this.mCanvasView.setToolTypeAction(2, 5);
                            SpenSettingTextLayout2.this.mCanvasView.setToolTypeAction(1, 5);
                        }
                        SpenSettingTextLayout2.this.mColorSelectView.setColorPickerMode();
                        SpenSettingTextLayout2.mColorPickerShow = true;
                        if (!SpenSettingPenLayout2.mColorPickerShow) {
                            SpenSettingTextLayout2.this.mColorPickerSetting.show();
                            if (!SpenSettingTextLayout2.mFirstTimeColorPickerShow) {
                                SpenSettingTextLayout2.this.mColorPickerSetting.movePosition(SpenSettingTextLayout2.this.mCanvasLayout.getWidth() / 2, SpenSettingTextLayout2.this.mCanvasLayout.getHeight() / 2);
                                SpenSettingTextLayout2.mFirstTimeColorPickerShow = true;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    SpenSettingTextLayout2.this.mTextPreView.setPreviewTextColor(color);
                    SpenSettingTextLayout2.this.mTextPreView.invalidate();
                    if (SpenSettingTextLayout2.this.mCanvasView != null) {
                        SpenSettingTextInfo info = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                        SpenSettingTextInfo spenSettingTextInfo = SpenSettingTextLayout2.this.mSettingInfo;
                        info.color = color;
                        spenSettingTextInfo.color = color;
                        SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info);
                        SpenSettingTextLayout2.this.mColorPickerSetting.setColorPickerColor(info.color);
                    }
                }
            }
        };
        this.mFontSizeOnClickListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingTextLayout2.this.mFontSizeDropdown = new SPenFontSizeDropdown2(v, SpenSettingTextLayout2.this.mTextFontSizeList, SpenSettingTextLayout2.this.mDrawableImg.getIntValueAppliedDensity(48.0f), SpenSettingTextLayout2.this.mDrawableImg.getIntValueAppliedDensity(180.0f), SpenSettingTextLayout2.this.mScale);
                SpenSettingTextLayout2.this.mFontSizeDropdown.setOnItemSelectListner(new SPenFontSizeDropdown2.SizeDropdownSelectListner() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.4.1
                    @Override // com.samsung.android.sdk.pen.settingui.SPenFontSizeDropdown2.SizeDropdownSelectListner
                    public void onSelectItem(int position) {
                        if (SpenSettingTextLayout2.this.mCanvasView != null) {
                            SpenSettingTextLayout2.this.mCanvasWidth = SpenSettingTextLayout2.this.mCanvasView.getCanvasWidth();
                        } else {
                            SpenSettingTextLayout2.this.mCanvasWidth = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_PPT_SLIDEMOVEPREV_EVENT;
                        }
                        float fontPointPixel = (float) (SpenSettingTextLayout2.this.mCanvasWidth / 360.0d);
                        SpenSettingTextLayout2.this.mSettingInfo.size = Integer.valueOf(SpenSettingTextLayout2.this.mTextFontSizeList.get(position)).intValue() * fontPointPixel;
                        SpenSettingTextLayout2.this.mTextPreView.setPreviewTextSize(SpenSettingTextLayout2.this.mSettingInfo.size);
                        SpenSettingTextLayout2.this.mCurrentFontSize = SpenSettingTextLayout2.this.mTextFontSizeList.get(position);
                        SpenSettingTextLayout2.this.mFontSizeButton.setText(SpenSettingTextLayout2.this.mCurrentFontSize);
                        SpenSettingTextLayout2.this.mTextPreView.invalidate();
                        if (SpenSettingTextLayout2.this.mCanvasView != null) {
                            SpenSettingTextInfo info = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                            info.size = SpenSettingTextLayout2.this.mSettingInfo.size;
                            SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info);
                        }
                    }
                });
                SpenSettingTextLayout2.this.mFontSizeDropdown.show(0, 0, SpenSettingTextLayout2.this.mCurrentFontSize);
            }
        };
        this.mFontTypeOnClickListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingTextLayout2.this.mFontNameDropdown = new SPenFontNameDropdown2(v, (ArrayList) SpenFont.getFontList(), SpenSettingTextLayout2.this.mDrawableImg.getIntValueAppliedDensity(170.0f), SpenSettingTextLayout2.this.mDrawableImg.getIntValueAppliedDensity(180.0f), SpenSettingTextLayout2.this.mScale);
                SpenSettingTextLayout2.this.mFontNameDropdown.setOnItemSelectListner(new SPenFontNameDropdown2.NameDropdownSelectListner() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.5.1
                    @Override // com.samsung.android.sdk.pen.settingui.SPenFontNameDropdown2.NameDropdownSelectListner
                    public void onSelectItem(int position) {
                        SpenSettingTextLayout2.this.mCurrentFontName = SpenFont.getFontList().get(position);
                        SpenSettingTextLayout2.this.mTextPreView.setPreviewTypeface(SpenFont.getTypeFace(position));
                        SpenSettingTextLayout2.this.mTextPreView.invalidate();
                        if (SpenSettingTextLayout2.this.mCanvasView != null) {
                            SpenSettingTextInfo info = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                            info.font = SpenFont.getFontName(SpenFont.getFontList().indexOf(SpenSettingTextLayout2.this.mCurrentFontName));
                            SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info);
                        }
                        SpenSettingTextLayout2.this.mFontTypeButton.setText(SpenSettingTextLayout2.this.mCurrentFontName);
                        SpenSettingTextLayout2.this.mFontTypeButton.setTypeface(SpenFont.getTypeFace(position));
                    }
                });
                SpenSettingTextLayout2.this.mFontNameDropdown.show(0, 0, SpenSettingTextLayout2.this.mCurrentFontName);
            }
        };
        this.mTextOptButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingTextLayout2.this.setTextStyle(v);
            }
        };
        this.mExitButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingTextLayout2.this.mColorPickerSetting.getColorPickerSettingVisible() == 0) {
                    if (SpenSettingTextLayout2.this.mSettingInfo.color != 0) {
                        if (SpenSettingTextLayout2.this.mCanvasView != null) {
                            SpenSettingTextLayout2.this.mCanvasView.setToolTypeAction(2, SpenSettingTextLayout2.this.mPreCanvasPenAction);
                            SpenSettingTextLayout2.this.mCanvasView.setToolTypeAction(1, SpenSettingTextLayout2.this.mPreCanvasFingerAction);
                            SpenSettingTextInfo info = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                            info.color = SpenSettingTextLayout2.this.mSettingInfo.color;
                            SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info);
                        }
                        SpenSettingTextLayout2.this.mTextPreView.setPreviewTextColor(SpenSettingTextLayout2.this.mSettingInfo.color);
                        SpenSettingTextLayout2.this.mTextPreView.invalidate();
                        SpenSettingTextLayout2.this.mColorSelectView.setColor(SpenSettingTextLayout2.this.mSettingInfo.color);
                        SpenSettingTextLayout2.this.mColorSelectView.invalidate();
                    }
                    SpenSettingTextLayout2.this.mColorPickerSetting.hide();
                }
                SpenSettingTextLayout2.mColorPickerShow = false;
            }
        };
        this.mPopupButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v == SpenSettingTextLayout2.this.mPopupMaxButton) {
                    if (SpenSettingTextLayout2.this.mPopupListener != null) {
                        SpenSettingTextLayout2.this.mPopupListener.onPopup(true);
                    }
                } else if (v == SpenSettingTextLayout2.this.mPopupMinButton && SpenSettingTextLayout2.this.mPopupListener != null) {
                    SpenSettingTextLayout2.this.mPopupListener.onPopup(false);
                }
            }
        };
        this.mColorPickerColorListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingTextLayout2.this.mColorPickerSetting.getColorPickerSettingVisible() == 0) {
                    SpenSettingTextLayout2.this.mTextPreView.setPreviewTextColor(SpenSettingTextLayout2.this.mSettingInfo.color);
                    SpenSettingTextLayout2.this.mTextPreView.invalidate();
                    SpenSettingTextLayout2.this.mColorSelectView.setColor(SpenSettingTextLayout2.this.mSettingInfo.color);
                    SpenSettingTextLayout2.this.mColorSelectView.invalidate();
                    if (SpenSettingTextLayout2.this.mCanvasView != null) {
                        SpenSettingTextLayout2.this.mCanvasView.setToolTypeAction(2, SpenSettingTextLayout2.this.mPreCanvasPenAction);
                        SpenSettingTextLayout2.this.mCanvasView.setToolTypeAction(1, SpenSettingTextLayout2.this.mPreCanvasFingerAction);
                        SpenSettingTextInfo info = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                        info.color = SpenSettingTextLayout2.this.mSettingInfo.color;
                        SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info);
                    }
                    SpenSettingTextLayout2.mColorPickerShow = false;
                    SpenSettingTextLayout2.this.mColorPickerSetting.hide();
                    SpenSettingTextLayout2.this.setVisibility(0);
                }
            }
        };
        this.mTextAlignSettingListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v.equals(SpenSettingTextLayout2.this.mAlignLeftBtn)) {
                    SpenSettingTextLayout2.this.mAlignLeftBtn.setSelected(true);
                    SpenSettingTextLayout2.this.mAlignCenterBtn.setSelected(false);
                    SpenSettingTextLayout2.this.mAlignRightBtn.setSelected(false);
                    if (SpenSettingTextLayout2.this.mCanvasView != null) {
                        SpenSettingTextInfo info = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                        info.align = 0;
                        SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info);
                        return;
                    }
                    return;
                }
                if (v.equals(SpenSettingTextLayout2.this.mAlignCenterBtn)) {
                    SpenSettingTextLayout2.this.mAlignLeftBtn.setSelected(false);
                    SpenSettingTextLayout2.this.mAlignCenterBtn.setSelected(true);
                    SpenSettingTextLayout2.this.mAlignRightBtn.setSelected(false);
                    if (SpenSettingTextLayout2.this.mCanvasView != null) {
                        SpenSettingTextInfo info2 = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                        info2.align = 2;
                        SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info2);
                        return;
                    }
                    return;
                }
                if (v.equals(SpenSettingTextLayout2.this.mAlignRightBtn)) {
                    SpenSettingTextLayout2.this.mAlignLeftBtn.setSelected(false);
                    SpenSettingTextLayout2.this.mAlignCenterBtn.setSelected(false);
                    SpenSettingTextLayout2.this.mAlignRightBtn.setSelected(true);
                    if (SpenSettingTextLayout2.this.mCanvasView != null) {
                        SpenSettingTextInfo info3 = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                        info3.align = 1;
                        SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info3);
                    }
                }
            }
        };
        this.mTextIndentSettingListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v.equals(SpenSettingTextLayout2.this.mIndentLeftBtn)) {
                    if (SpenSettingTextLayout2.this.mCanvasView != null) {
                        SpenSettingTextInfo info = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                        info.lineIndent += 10;
                        SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info);
                        return;
                    }
                    return;
                }
                if (v.equals(SpenSettingTextLayout2.this.mIndentRightBtn) && SpenSettingTextLayout2.this.mCanvasView != null) {
                    SpenSettingTextInfo info2 = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                    info2.lineIndent -= 10;
                    SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info2);
                }
            }
        };
        this.mPaletteNextButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingTextLayout2.this.mColorSelectView != null) {
                    int index = SpenSettingTextLayout2.this.mColorSelectView.getCurrentTableIndex();
                    if (index == 3) {
                        SpenSettingTextLayout2.this.mPaletteLeftButton.setAlpha(1.0f);
                        SpenSettingTextLayout2.this.mPaletteLeftButton.setEnabled(true);
                    }
                    SpenSettingTextLayout2.this.mColorSelectView.setNextColorTable(index);
                    SpenSettingTextLayout2.this.mColorSelectView.setSelectBoxPos(SpenSettingTextLayout2.this.mSettingInfo.color);
                    if (SpenSettingTextLayout2.this.mColorSelectView.getCurrentTableIndex() == 2) {
                        SpenSettingTextLayout2.this.mPaletteRightButton.setAlpha(0.2f);
                        SpenSettingTextLayout2.this.mPaletteRightButton.setEnabled(false);
                    }
                }
            }
        };
        this.mPaletteBackButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingTextLayout2.this.mColorSelectView != null) {
                    int index = SpenSettingTextLayout2.this.mColorSelectView.getCurrentTableIndex();
                    if (index == 2) {
                        SpenSettingTextLayout2.this.mPaletteRightButton.setAlpha(1.0f);
                        SpenSettingTextLayout2.this.mPaletteRightButton.setEnabled(true);
                    }
                    SpenSettingTextLayout2.this.mColorSelectView.setBackColorTable(index);
                    SpenSettingTextLayout2.this.mColorSelectView.setSelectBoxPos(SpenSettingTextLayout2.this.mSettingInfo.color);
                    if (SpenSettingTextLayout2.this.mColorSelectView.getCurrentTableIndex() == 3) {
                        SpenSettingTextLayout2.this.mPaletteLeftButton.setAlpha(0.2f);
                        SpenSettingTextLayout2.this.mPaletteLeftButton.setEnabled(false);
                    }
                }
            }
        };
        this.mTextLineSpacingSettingListener = new AdapterView.OnItemSelectedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.14
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(-16777216);
                ((TextView) parent.getChildAt(0)).setTextSize(0, SpenSettingTextLayout2.this.mDrawableImg.getIntValueAppliedDensity(15.0f));
                if (SpenSettingTextLayout2.this.mParaLineSpinner1stSelect) {
                    SpenSettingTextLayout2.this.mParaLineSpinner1stSelect = false;
                    return;
                }
                int[] arrChange = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 22, 24, 26, 28, 30, 32, 36, 40, 43, 44, 48, 52, 56, 60, 64, 68, 72, 80, 88};
                if (SpenSettingTextLayout2.this.mCanvasView != null) {
                    SpenSettingTextInfo info = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                    info.lineSpacingType = 0;
                    info.lineSpacing = arrChange[position];
                    SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        this.mOnConsumedTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.15
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpenSettingTextLayout2.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mScrollViewListner = new SpenScrollView.scrollChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.16
            @Override // com.samsung.android.sdk.pen.settingui.SpenScrollView.scrollChangedListener
            public void scrollChanged(int scrollY) {
                SpenSettingTextLayout2.this.scroll(scrollY);
                SpenSettingTextLayout2.this.mScrollY = scrollY;
                RelativeLayout.LayoutParams PaletteBgParam = new RelativeLayout.LayoutParams(-1, (SpenSettingTextLayout2.this.mDrawableImg.getIntValueAppliedDensity(163.0f) - (SpenSettingTextLayout2.this.mDrawableImg.getIntValueAppliedDensity(330.0f + (17.0f / SpenSettingTextLayout2.this.mScale)) - SpenSettingTextLayout2.this.mBodyLayoutHeight)) + SpenSettingTextLayout2.this.mScrollY);
                if (PaletteBgParam.height >= 0) {
                    SpenSettingTextLayout2.this.mPaletteBg.setLayoutParams(PaletteBgParam);
                }
            }
        };
        this.mContext = context;
        this.mDrawableImg = new SPenImageUtil(context, customImagePath, this.mScale);
        this.mTextUtil = new SPenTextUtil(context);
        this.mImageLoader = new SpenImageLoader(this.mDrawableImg);
        this.mCanvasLayout = relativeLayout;
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
        initButtonValue();
        initView();
        setListener();
        this.mMovableRect = new Rect();
    }

    public SpenSettingTextLayout2(Context context, String customImagePath, HashMap<String, String> fontName, RelativeLayout relativeLayout, float ratio) {
        super(context);
        this.mExpandFlag = false;
        this.mBodyLayoutHeight = -2;
        this.mPopupListener = null;
        this.mActionListener = null;
        this.mParaLineSpinner1stSelect = true;
        this.mTextFontSizeList = new ArrayList<>();
        this.mMoveTextsettingLayout = false;
        this.mScrollY = 0;
        this.mFirstLongPress = true;
        this.mScale = 1.0f;
        this.mCanvasWidth = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_PPT_SLIDEMOVEPREV_EVENT;
        this.mViewMode = 0;
        this.EXIT_BUTTON_RIGHT_MARGIN = 4.0f;
        this.mHandler = new Handler();
        this.mHoverListener = new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.1
            @Override // android.view.View.OnHoverListener
            public boolean onHover(View arg0, MotionEvent arg1) {
                return true;
            }
        };
        this.mColorPickerColorChangeListenerText = new SpenColorGradationView2.onColorChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.2
            @Override // com.samsung.android.sdk.pen.settingui.SpenColorGradationView2.onColorChangedListener
            public void onColorChanged(int color, int x, int y) {
                SpenSettingTextLayout2.this.mColorSelectView.setColor(SpenSettingTextLayout2.this.mTextPreView.getPreviewTextColor());
                if (SpenSettingTextLayout2.this.getVisibility() == 0) {
                    SpenSettingTextLayout2.this.mTextPreView.setPreviewTextColor(color);
                    SpenSettingTextLayout2.this.mTextPreView.invalidate();
                    if (SpenSettingTextLayout2.this.mCanvasView != null) {
                        SpenSettingTextInfo info = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                        info.color = color;
                        SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info);
                        SpenSettingTextLayout2.this.mColorPickerSetting.setColorPickerColor(info.color);
                        SpenSettingTextLayout2.this.mSettingInfo.color = color;
                    }
                }
            }
        };
        this.mOnColorChangedListenerText = new SpenColorPaletteView2.OnColorChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.3
            @Override // com.samsung.android.sdk.pen.settingui.SpenColorPaletteView2.OnColorChangedListener
            public void colorChanged(int color, int selectedItem) {
                if (SpenSettingTextLayout2.this.getVisibility() == 0) {
                    if (selectedItem == 13) {
                        SpenSettingTextLayout2.this.setViewMode(0);
                        if (SpenSettingTextLayout2.this.mCanvasView != null) {
                            SpenSettingTextLayout2.this.mPreCanvasPenAction = SpenSettingTextLayout2.this.mCanvasView.getToolTypeAction(2);
                            SpenSettingTextLayout2.this.mPreCanvasFingerAction = SpenSettingTextLayout2.this.mCanvasView.getToolTypeAction(1);
                            SpenSettingTextLayout2.this.mCanvasView.setToolTypeAction(2, 5);
                            SpenSettingTextLayout2.this.mCanvasView.setToolTypeAction(1, 5);
                        }
                        SpenSettingTextLayout2.this.mColorSelectView.setColorPickerMode();
                        SpenSettingTextLayout2.mColorPickerShow = true;
                        if (!SpenSettingPenLayout2.mColorPickerShow) {
                            SpenSettingTextLayout2.this.mColorPickerSetting.show();
                            if (!SpenSettingTextLayout2.mFirstTimeColorPickerShow) {
                                SpenSettingTextLayout2.this.mColorPickerSetting.movePosition(SpenSettingTextLayout2.this.mCanvasLayout.getWidth() / 2, SpenSettingTextLayout2.this.mCanvasLayout.getHeight() / 2);
                                SpenSettingTextLayout2.mFirstTimeColorPickerShow = true;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    SpenSettingTextLayout2.this.mTextPreView.setPreviewTextColor(color);
                    SpenSettingTextLayout2.this.mTextPreView.invalidate();
                    if (SpenSettingTextLayout2.this.mCanvasView != null) {
                        SpenSettingTextInfo info = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                        SpenSettingTextInfo spenSettingTextInfo = SpenSettingTextLayout2.this.mSettingInfo;
                        info.color = color;
                        spenSettingTextInfo.color = color;
                        SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info);
                        SpenSettingTextLayout2.this.mColorPickerSetting.setColorPickerColor(info.color);
                    }
                }
            }
        };
        this.mFontSizeOnClickListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingTextLayout2.this.mFontSizeDropdown = new SPenFontSizeDropdown2(v, SpenSettingTextLayout2.this.mTextFontSizeList, SpenSettingTextLayout2.this.mDrawableImg.getIntValueAppliedDensity(48.0f), SpenSettingTextLayout2.this.mDrawableImg.getIntValueAppliedDensity(180.0f), SpenSettingTextLayout2.this.mScale);
                SpenSettingTextLayout2.this.mFontSizeDropdown.setOnItemSelectListner(new SPenFontSizeDropdown2.SizeDropdownSelectListner() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.4.1
                    @Override // com.samsung.android.sdk.pen.settingui.SPenFontSizeDropdown2.SizeDropdownSelectListner
                    public void onSelectItem(int position) {
                        if (SpenSettingTextLayout2.this.mCanvasView != null) {
                            SpenSettingTextLayout2.this.mCanvasWidth = SpenSettingTextLayout2.this.mCanvasView.getCanvasWidth();
                        } else {
                            SpenSettingTextLayout2.this.mCanvasWidth = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_PPT_SLIDEMOVEPREV_EVENT;
                        }
                        float fontPointPixel = (float) (SpenSettingTextLayout2.this.mCanvasWidth / 360.0d);
                        SpenSettingTextLayout2.this.mSettingInfo.size = Integer.valueOf(SpenSettingTextLayout2.this.mTextFontSizeList.get(position)).intValue() * fontPointPixel;
                        SpenSettingTextLayout2.this.mTextPreView.setPreviewTextSize(SpenSettingTextLayout2.this.mSettingInfo.size);
                        SpenSettingTextLayout2.this.mCurrentFontSize = SpenSettingTextLayout2.this.mTextFontSizeList.get(position);
                        SpenSettingTextLayout2.this.mFontSizeButton.setText(SpenSettingTextLayout2.this.mCurrentFontSize);
                        SpenSettingTextLayout2.this.mTextPreView.invalidate();
                        if (SpenSettingTextLayout2.this.mCanvasView != null) {
                            SpenSettingTextInfo info = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                            info.size = SpenSettingTextLayout2.this.mSettingInfo.size;
                            SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info);
                        }
                    }
                });
                SpenSettingTextLayout2.this.mFontSizeDropdown.show(0, 0, SpenSettingTextLayout2.this.mCurrentFontSize);
            }
        };
        this.mFontTypeOnClickListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingTextLayout2.this.mFontNameDropdown = new SPenFontNameDropdown2(v, (ArrayList) SpenFont.getFontList(), SpenSettingTextLayout2.this.mDrawableImg.getIntValueAppliedDensity(170.0f), SpenSettingTextLayout2.this.mDrawableImg.getIntValueAppliedDensity(180.0f), SpenSettingTextLayout2.this.mScale);
                SpenSettingTextLayout2.this.mFontNameDropdown.setOnItemSelectListner(new SPenFontNameDropdown2.NameDropdownSelectListner() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.5.1
                    @Override // com.samsung.android.sdk.pen.settingui.SPenFontNameDropdown2.NameDropdownSelectListner
                    public void onSelectItem(int position) {
                        SpenSettingTextLayout2.this.mCurrentFontName = SpenFont.getFontList().get(position);
                        SpenSettingTextLayout2.this.mTextPreView.setPreviewTypeface(SpenFont.getTypeFace(position));
                        SpenSettingTextLayout2.this.mTextPreView.invalidate();
                        if (SpenSettingTextLayout2.this.mCanvasView != null) {
                            SpenSettingTextInfo info = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                            info.font = SpenFont.getFontName(SpenFont.getFontList().indexOf(SpenSettingTextLayout2.this.mCurrentFontName));
                            SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info);
                        }
                        SpenSettingTextLayout2.this.mFontTypeButton.setText(SpenSettingTextLayout2.this.mCurrentFontName);
                        SpenSettingTextLayout2.this.mFontTypeButton.setTypeface(SpenFont.getTypeFace(position));
                    }
                });
                SpenSettingTextLayout2.this.mFontNameDropdown.show(0, 0, SpenSettingTextLayout2.this.mCurrentFontName);
            }
        };
        this.mTextOptButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingTextLayout2.this.setTextStyle(v);
            }
        };
        this.mExitButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingTextLayout2.this.mColorPickerSetting.getColorPickerSettingVisible() == 0) {
                    if (SpenSettingTextLayout2.this.mSettingInfo.color != 0) {
                        if (SpenSettingTextLayout2.this.mCanvasView != null) {
                            SpenSettingTextLayout2.this.mCanvasView.setToolTypeAction(2, SpenSettingTextLayout2.this.mPreCanvasPenAction);
                            SpenSettingTextLayout2.this.mCanvasView.setToolTypeAction(1, SpenSettingTextLayout2.this.mPreCanvasFingerAction);
                            SpenSettingTextInfo info = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                            info.color = SpenSettingTextLayout2.this.mSettingInfo.color;
                            SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info);
                        }
                        SpenSettingTextLayout2.this.mTextPreView.setPreviewTextColor(SpenSettingTextLayout2.this.mSettingInfo.color);
                        SpenSettingTextLayout2.this.mTextPreView.invalidate();
                        SpenSettingTextLayout2.this.mColorSelectView.setColor(SpenSettingTextLayout2.this.mSettingInfo.color);
                        SpenSettingTextLayout2.this.mColorSelectView.invalidate();
                    }
                    SpenSettingTextLayout2.this.mColorPickerSetting.hide();
                }
                SpenSettingTextLayout2.mColorPickerShow = false;
            }
        };
        this.mPopupButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v == SpenSettingTextLayout2.this.mPopupMaxButton) {
                    if (SpenSettingTextLayout2.this.mPopupListener != null) {
                        SpenSettingTextLayout2.this.mPopupListener.onPopup(true);
                    }
                } else if (v == SpenSettingTextLayout2.this.mPopupMinButton && SpenSettingTextLayout2.this.mPopupListener != null) {
                    SpenSettingTextLayout2.this.mPopupListener.onPopup(false);
                }
            }
        };
        this.mColorPickerColorListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingTextLayout2.this.mColorPickerSetting.getColorPickerSettingVisible() == 0) {
                    SpenSettingTextLayout2.this.mTextPreView.setPreviewTextColor(SpenSettingTextLayout2.this.mSettingInfo.color);
                    SpenSettingTextLayout2.this.mTextPreView.invalidate();
                    SpenSettingTextLayout2.this.mColorSelectView.setColor(SpenSettingTextLayout2.this.mSettingInfo.color);
                    SpenSettingTextLayout2.this.mColorSelectView.invalidate();
                    if (SpenSettingTextLayout2.this.mCanvasView != null) {
                        SpenSettingTextLayout2.this.mCanvasView.setToolTypeAction(2, SpenSettingTextLayout2.this.mPreCanvasPenAction);
                        SpenSettingTextLayout2.this.mCanvasView.setToolTypeAction(1, SpenSettingTextLayout2.this.mPreCanvasFingerAction);
                        SpenSettingTextInfo info = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                        info.color = SpenSettingTextLayout2.this.mSettingInfo.color;
                        SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info);
                    }
                    SpenSettingTextLayout2.mColorPickerShow = false;
                    SpenSettingTextLayout2.this.mColorPickerSetting.hide();
                    SpenSettingTextLayout2.this.setVisibility(0);
                }
            }
        };
        this.mTextAlignSettingListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v.equals(SpenSettingTextLayout2.this.mAlignLeftBtn)) {
                    SpenSettingTextLayout2.this.mAlignLeftBtn.setSelected(true);
                    SpenSettingTextLayout2.this.mAlignCenterBtn.setSelected(false);
                    SpenSettingTextLayout2.this.mAlignRightBtn.setSelected(false);
                    if (SpenSettingTextLayout2.this.mCanvasView != null) {
                        SpenSettingTextInfo info = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                        info.align = 0;
                        SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info);
                        return;
                    }
                    return;
                }
                if (v.equals(SpenSettingTextLayout2.this.mAlignCenterBtn)) {
                    SpenSettingTextLayout2.this.mAlignLeftBtn.setSelected(false);
                    SpenSettingTextLayout2.this.mAlignCenterBtn.setSelected(true);
                    SpenSettingTextLayout2.this.mAlignRightBtn.setSelected(false);
                    if (SpenSettingTextLayout2.this.mCanvasView != null) {
                        SpenSettingTextInfo info2 = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                        info2.align = 2;
                        SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info2);
                        return;
                    }
                    return;
                }
                if (v.equals(SpenSettingTextLayout2.this.mAlignRightBtn)) {
                    SpenSettingTextLayout2.this.mAlignLeftBtn.setSelected(false);
                    SpenSettingTextLayout2.this.mAlignCenterBtn.setSelected(false);
                    SpenSettingTextLayout2.this.mAlignRightBtn.setSelected(true);
                    if (SpenSettingTextLayout2.this.mCanvasView != null) {
                        SpenSettingTextInfo info3 = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                        info3.align = 1;
                        SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info3);
                    }
                }
            }
        };
        this.mTextIndentSettingListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v.equals(SpenSettingTextLayout2.this.mIndentLeftBtn)) {
                    if (SpenSettingTextLayout2.this.mCanvasView != null) {
                        SpenSettingTextInfo info = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                        info.lineIndent += 10;
                        SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info);
                        return;
                    }
                    return;
                }
                if (v.equals(SpenSettingTextLayout2.this.mIndentRightBtn) && SpenSettingTextLayout2.this.mCanvasView != null) {
                    SpenSettingTextInfo info2 = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                    info2.lineIndent -= 10;
                    SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info2);
                }
            }
        };
        this.mPaletteNextButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingTextLayout2.this.mColorSelectView != null) {
                    int index = SpenSettingTextLayout2.this.mColorSelectView.getCurrentTableIndex();
                    if (index == 3) {
                        SpenSettingTextLayout2.this.mPaletteLeftButton.setAlpha(1.0f);
                        SpenSettingTextLayout2.this.mPaletteLeftButton.setEnabled(true);
                    }
                    SpenSettingTextLayout2.this.mColorSelectView.setNextColorTable(index);
                    SpenSettingTextLayout2.this.mColorSelectView.setSelectBoxPos(SpenSettingTextLayout2.this.mSettingInfo.color);
                    if (SpenSettingTextLayout2.this.mColorSelectView.getCurrentTableIndex() == 2) {
                        SpenSettingTextLayout2.this.mPaletteRightButton.setAlpha(0.2f);
                        SpenSettingTextLayout2.this.mPaletteRightButton.setEnabled(false);
                    }
                }
            }
        };
        this.mPaletteBackButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingTextLayout2.this.mColorSelectView != null) {
                    int index = SpenSettingTextLayout2.this.mColorSelectView.getCurrentTableIndex();
                    if (index == 2) {
                        SpenSettingTextLayout2.this.mPaletteRightButton.setAlpha(1.0f);
                        SpenSettingTextLayout2.this.mPaletteRightButton.setEnabled(true);
                    }
                    SpenSettingTextLayout2.this.mColorSelectView.setBackColorTable(index);
                    SpenSettingTextLayout2.this.mColorSelectView.setSelectBoxPos(SpenSettingTextLayout2.this.mSettingInfo.color);
                    if (SpenSettingTextLayout2.this.mColorSelectView.getCurrentTableIndex() == 3) {
                        SpenSettingTextLayout2.this.mPaletteLeftButton.setAlpha(0.2f);
                        SpenSettingTextLayout2.this.mPaletteLeftButton.setEnabled(false);
                    }
                }
            }
        };
        this.mTextLineSpacingSettingListener = new AdapterView.OnItemSelectedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.14
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(-16777216);
                ((TextView) parent.getChildAt(0)).setTextSize(0, SpenSettingTextLayout2.this.mDrawableImg.getIntValueAppliedDensity(15.0f));
                if (SpenSettingTextLayout2.this.mParaLineSpinner1stSelect) {
                    SpenSettingTextLayout2.this.mParaLineSpinner1stSelect = false;
                    return;
                }
                int[] arrChange = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 22, 24, 26, 28, 30, 32, 36, 40, 43, 44, 48, 52, 56, 60, 64, 68, 72, 80, 88};
                if (SpenSettingTextLayout2.this.mCanvasView != null) {
                    SpenSettingTextInfo info = SpenSettingTextLayout2.this.mCanvasView.getTextSettingInfo();
                    info.lineSpacingType = 0;
                    info.lineSpacing = arrChange[position];
                    SpenSettingTextLayout2.this.mCanvasView.setTextSettingInfo(info);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        this.mOnConsumedTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.15
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpenSettingTextLayout2.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mScrollViewListner = new SpenScrollView.scrollChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.16
            @Override // com.samsung.android.sdk.pen.settingui.SpenScrollView.scrollChangedListener
            public void scrollChanged(int scrollY) {
                SpenSettingTextLayout2.this.scroll(scrollY);
                SpenSettingTextLayout2.this.mScrollY = scrollY;
                RelativeLayout.LayoutParams PaletteBgParam = new RelativeLayout.LayoutParams(-1, (SpenSettingTextLayout2.this.mDrawableImg.getIntValueAppliedDensity(163.0f) - (SpenSettingTextLayout2.this.mDrawableImg.getIntValueAppliedDensity(330.0f + (17.0f / SpenSettingTextLayout2.this.mScale)) - SpenSettingTextLayout2.this.mBodyLayoutHeight)) + SpenSettingTextLayout2.this.mScrollY);
                if (PaletteBgParam.height >= 0) {
                    SpenSettingTextLayout2.this.mPaletteBg.setLayoutParams(PaletteBgParam);
                }
            }
        };
        this.mScale = ratio;
        this.mContext = context;
        this.mDrawableImg = new SPenImageUtil(context, customImagePath, ratio);
        this.mTextUtil = new SPenTextUtil(context);
        this.mImageLoader = new SpenImageLoader(this.mDrawableImg);
        this.mCanvasLayout = relativeLayout;
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
        initButtonValue();
        initView();
        setListener();
        this.mMovableRect = new Rect();
    }

    private void totalLayout() {
        this.totalLayoutParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(329.0f), -2);
        setLayoutParams(this.totalLayoutParams);
        setOrientation(1);
        this.mTitleLayout = titleLayout();
        this.mBodyLayout = bodyLayout();
        addView(this.mTitleLayout);
        addView(this.mBodyLayout);
        if (this.mBodyLayoutHeight - this.mBottomLayout.getHeight() >= this.mDrawableImg.getIntValueAppliedDensity(330.0f) || this.mBodyLayoutHeight == -2 || this.mBodyLayoutHeight == 0) {
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.mBodyLayout.setLayoutParams(localLayoutParams);
            RelativeLayout.LayoutParams bodyBgParam = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity((17.0f / this.mScale) + 330.0f));
            this.mBodyBg.setLayoutParams(bodyBgParam);
            RelativeLayout.LayoutParams bottomLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(17.0f / this.mScale));
            bottomLayoutParams.setMargins(0, this.mDrawableImg.getIntValueAppliedDensity(330.0f), 0, 0);
            this.mBottomLayout.setLayoutParams(bottomLayoutParams);
            this.mBodyLayoutHeight = this.mDrawableImg.getIntValueAppliedDensity(330.0f) + this.mDrawableImg.getIntValueAppliedDensity(17.0f / this.mScale);
            RelativeLayout.LayoutParams scrollLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity((17.0f / this.mScale) + 330.0f));
            scrollLayoutParams.setMargins(0, 0, this.mDrawableImg.getIntValueAppliedDensity(1.5f), 0);
            this.mScrollView.setLayoutParams(scrollLayoutParams);
        }
    }

    private ViewGroup titleLayout() {
        RelativeLayout layout = new RelativeLayout(this.mContext);
        layout.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(42.0f)));
        this.mPopupMaxButton = popupMaxButton();
        this.mPopupMinButton = popupMinButton();
        layout.addView(titleBg());
        layout.addView(titleText());
        layout.addView(this.mPopupMaxButton);
        layout.addView(this.mPopupMinButton);
        this.mPopupMaxButton.setVisibility(8);
        return layout;
    }

    private View titleBg() {
        RelativeLayout layout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams titleBgParam = new RelativeLayout.LayoutParams(-1, -1);
        layout.setLayoutParams(titleBgParam);
        this.mImageLoader.addViewSetBackgroundImageLoad(layout, titleRightPath);
        return layout;
    }

    private View titleText() {
        TextView titleView = new TextView(this.mContext);
        titleView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        titleView.setTextColor(Color.rgb(250, 250, 250));
        titleView.setGravity(16);
        titleView.setFocusable(true);
        titleView.setSingleLine(true);
        titleView.setEllipsize(TextUtils.TruncateAt.END);
        titleView.setText(this.mTextUtil.setString("string_text_settings"));
        titleView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(20.0f));
        titleView.setTypeface(SpenFont.getTypeFace("Roboto-Regular"), 0);
        titleView.setContentDescription(this.mTextUtil.setString("string_text_settings"));
        titleView.setPadding(this.mDrawableImg.getIntValueAppliedDensity(13.0f), 0, 0, 0);
        return titleView;
    }

    private ViewGroup bodyLayout() {
        this.mScrollView = new SpenScrollView(this.mContext);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(0, 0, this.mDrawableImg.getIntValueAppliedDensity(1.5f), 0);
        this.mScrollView.setLayoutParams(localLayoutParams);
        this.mScrollView.setVerticalFadingEdgeEnabled(false);
        this.mScrollView.setFadingEdgeLength(0);
        this.mScrollView.setVerticalScrollBarEnabled(true);
        this.mScrollView.setOverScrollMode(1);
        SpenPalletView palletViewLayout = new SpenPalletView(this.mContext);
        palletViewLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        palletViewLayout.setOrientation(1);
        this.mTextSettingPreview = textPreview();
        this.mFontSizeSpinnerOptButton = fontSizeSpinnerOptButton();
        this.mColorSelectedAndPicker = colorSelectedAndPicker();
        LinearLayout bottonPaddingLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams bottonPaddingLayoutParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(17.0f / this.mScale));
        bottonPaddingLayout.setLayoutParams(bottonPaddingLayoutParams);
        bottonPaddingLayout.setBackgroundColor(0);
        palletViewLayout.addView(this.mTextSettingPreview);
        palletViewLayout.addView(this.mFontSizeSpinnerOptButton);
        palletViewLayout.addView(this.mColorSelectedAndPicker);
        this.mParagraphSetting = paragraphSetting();
        this.mBottomLayout = bottomLayout();
        this.mBottomLayout.setVisibility(8);
        this.mBottomLayout.setContentDescription(this.mTextUtil.setString("string_resize"));
        this.mScrollView.addView(palletViewLayout);
        RelativeLayout layout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layout.setLayoutParams(layoutParams);
        this.mBodyBg = bodyBg();
        layout.addView(this.mBodyBg);
        layout.addView(this.mScrollView);
        return layout;
    }

    private ViewGroup bodyBg() {
        RelativeLayout layout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layout.setLayoutParams(layoutParams);
        this.mImageLoader.addViewSetBackgroundImageLoad(layout, lightBodyLeftPath);
        return layout;
    }

    private void initButtonValue() {
        this.EXIT_BUTTON_WIDTH = 42;
        this.EXIT_BUTTON_HEIGHT = 42;
        this.LINE_BUTTON_TOP_MARGIN = 17.0f - ((this.mScale - 1.0f) * 2.0f);
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
            if (this.mColorSelectView != null) {
                this.mColorSelectView.close();
                this.mDrawableImg.unbindDrawables(this.mColorSelectView);
                this.mColorSelectView = null;
            }
            if (this.mColorPickerView != null) {
                this.mColorPickerView.close();
                this.mDrawableImg.unbindDrawables(this.mColorPickerView);
                this.mColorPickerView = null;
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
            this.mCanvasLayout = null;
            this.mDrawableImg.unbindDrawables(this);
            this.mDrawableImg = null;
            this.mImageLoader.close();
            this.mImageLoader = null;
            mColorPickerShow = false;
        }
    }

    private void initView() {
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
            this.mTitleLayout.setOnTouchListener(this.mOnConsumedTouchListener);
        }
        if (this.mColorPickerView != null) {
            this.mColorPickerView.setColorPickerColorChangeListener(this.mColorPickerColorChangeListenerText);
        }
        if (this.mPopupMaxButton != null) {
            this.mPopupMaxButton.setOnClickListener(this.mPopupButtonListener);
        }
        if (this.mPopupMinButton != null) {
            this.mPopupMinButton.setOnClickListener(this.mPopupButtonListener);
        }
        if (this.mTextSizeButtonView != null) {
            for (int mTextOptButton = 0; mTextOptButton < this.mFontSizeSpinnerOptButton.getChildCount(); mTextOptButton++) {
                if (this.mTextSizeButtonView[mTextOptButton] != null && (this.mTextSizeButtonView[mTextOptButton] instanceof ImageButton)) {
                    this.mTextSizeButtonView[mTextOptButton].setOnClickListener(this.mTextOptButtonListener);
                }
            }
        }
        if (this.mBottomLayout != null) {
            this.mBottomLayout.setOnTouchListener(this.mOnConsumedTouchListener);
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
    }

    private void initColorSelecteView() {
        if (this.mColorSelectView != null) {
            this.mColorSelectView.setInitialValue(this.mOnColorChangedListenerText, this.mTextPreView.getPreviewTextColor());
        }
    }

    private void ColorPickerSettinginit() {
        this.mColorPickerSetting = new SpenColorPickerLayout2(this.mContext, this.mCanvasLayout, this.mScale, 0, 0);
        this.mColorPickerSettingExitButton = this.mColorPickerSetting.mColorPickerdExitBtn;
        this.mColorPickerSettingExitButton.setOnClickListener(this.mExitButtonListener);
        this.mColorPickerColor = this.mColorPickerSetting.mColorPickerCurrentColor;
        this.mColorPickerColor.setOnClickListener(this.mColorPickerColorListener);
    }

    public void setIndicatorPosition(int position) {
    }

    public void setPosition(int x, int y) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) getLayoutParams();
        params.leftMargin = x;
        params.topMargin = y;
        setLayoutParams(params);
        this.mLeftMargin -= x;
        this.mTopMargin -= y;
    }

    public void setColorPickerPosition(int x, int y) {
        if (this.mColorPickerSetting != null) {
            this.mColorPickerSetting.movePosition(x, y);
        }
    }

    private View popupMaxButton() {
        float topMargin = this.EXIT_BUTTON_TOP_MARGIN;
        float rightMargin = this.EXIT_BUTTON_RIGHT_MARGIN;
        ImageButton popupMaxButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams exitButtonParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(this.EXIT_BUTTON_WIDTH), this.mDrawableImg.getIntValueAppliedDensity(this.EXIT_BUTTON_HEIGHT));
        exitButtonParams.addRule(11);
        exitButtonParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(topMargin);
        exitButtonParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(rightMargin);
        popupMaxButton.setLayoutParams(exitButtonParams);
        popupMaxButton.setFocusable(true);
        this.mImageLoader.addViewBackgroundSelectableImageLoad(popupMaxButton, popupMaxPath, popupMaxPath, popupMaxPath, 42, 42);
        return popupMaxButton;
    }

    private View popupMinButton() {
        float topMargin = this.EXIT_BUTTON_TOP_MARGIN;
        float rightMargin = this.EXIT_BUTTON_RIGHT_MARGIN;
        ImageButton popupMinButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams exitButtonParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(this.EXIT_BUTTON_WIDTH), this.mDrawableImg.getIntValueAppliedDensity(this.EXIT_BUTTON_HEIGHT));
        exitButtonParams.addRule(11);
        exitButtonParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(topMargin);
        exitButtonParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(rightMargin);
        popupMinButton.setLayoutParams(exitButtonParams);
        popupMinButton.setFocusable(true);
        this.mImageLoader.addViewBackgroundSelectableImageLoad(popupMinButton, popupMinPath, popupMinPath, popupMinPath, 42, 42);
        return popupMinButton;
    }

    private View textPreview() {
        LinearLayout mPreviewLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams previewLayoutParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(92.0f));
        previewLayoutParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(15.0f);
        previewLayoutParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(13.0f);
        previewLayoutParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(13.0f);
        mPreviewLayout.setLayoutParams(previewLayoutParams);
        this.mImageLoader.addViewSetBackgroundImageLoad(mPreviewLayout, mPreviewBgPath);
        this.mTextPreView = new SpenTextPreView2(this.mContext, this.mCanvasWidth);
        FrameLayout.LayoutParams mPreviewParams = new FrameLayout.LayoutParams(-1, -1, 17);
        mPreviewParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(-5.0f);
        this.mTextPreView.setLayoutParams(mPreviewParams);
        mPreviewLayout.addView(this.mTextPreView);
        return mPreviewLayout;
    }

    private ViewGroup fontSizeSpinnerOptButton() {
        LinearLayout fontSizeSpinnerOptButtonLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams fontSizeSpinnerOptButtonLayoutParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(58.0f));
        fontSizeSpinnerOptButtonLayoutParams.bottomMargin = this.mDrawableImg.getIntValueAppliedDensity(1.0f);
        fontSizeSpinnerOptButtonLayout.setLayoutParams(fontSizeSpinnerOptButtonLayoutParams);
        fontSizeSpinnerOptButtonLayout.setGravity(16);
        fontSizeSpinnerOptButtonLayout.setOrientation(0);
        fontSizeSpinnerOptButtonLayout.setPadding(this.mDrawableImg.getIntValueAppliedDensity(13.0f), this.mDrawableImg.getIntValueAppliedDensity(8.0f), this.mDrawableImg.getIntValueAppliedDensity(13.0f), this.mDrawableImg.getIntValueAppliedDensity(9.0f));
        this.mFontTypeSpinnerView = fontTypeSpinnerView();
        this.mFontSizeSpinnerView = fontSizeSpinner();
        fontSizeSpinnerOptButtonLayout.addView(this.mFontTypeSpinnerView);
        fontSizeSpinnerOptButtonLayout.addView(this.mFontSizeSpinnerView);
        LinearLayout.LayoutParams mBoldBtnParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(42.0f), this.mDrawableImg.getIntValueAppliedDensity(41.0f));
        this.mBoldBtn = new ImageButton(this.mContext);
        this.mBoldBtn.setLayoutParams(mBoldBtnParams);
        this.mBoldBtn.setFocusable(true);
        this.mBoldBtn.setContentDescription(this.mTextUtil.setString("string_bold"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mBoldBtn, mBoldLeftNomarPath, mBoldLeftPressPath, mBoldLeftFocusPath);
        this.mBoldBtn.setImageDrawable(this.mDrawableImg.setDrawableImg(mBoldIconPath, 30, 30));
        fontSizeSpinnerOptButtonLayout.addView(this.mBoldBtn);
        this.mItalicBtn = new ImageButton(this.mContext);
        LinearLayout.LayoutParams mItalicBtnParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(42.0f), this.mDrawableImg.getIntValueAppliedDensity(41.0f));
        this.mItalicBtn.setLayoutParams(mItalicBtnParams);
        this.mItalicBtn.setFocusable(true);
        this.mItalicBtn.setContentDescription(this.mTextUtil.setString("string_italic"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mItalicBtn, mItalicLeftNomarPath, mItalicLeftPressPath, mItalicLeftFocusPath);
        this.mItalicBtn.setImageDrawable(this.mDrawableImg.setDrawableImg(mItalicIconPath, 30, 30));
        fontSizeSpinnerOptButtonLayout.addView(this.mItalicBtn);
        this.mUnderlineBtn = new ImageButton(this.mContext);
        LinearLayout.LayoutParams mUnderlineBtnParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(42.0f), this.mDrawableImg.getIntValueAppliedDensity(41.0f));
        this.mUnderlineBtn.setLayoutParams(mUnderlineBtnParams);
        this.mUnderlineBtn.setFocusable(true);
        this.mUnderlineBtn.setContentDescription(this.mTextUtil.setString("string_underline"));
        this.mUnderlineBtn.setImageDrawable(this.mDrawableImg.setDrawableImg(mUnderLineIconPath, 30, 30));
        this.mUnderlineBtn.setPadding(0, 0, 0, this.mDrawableImg.getIntValueAppliedDensity(1.0f));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mUnderlineBtn, mUnderLeftNomarPath, mUnderLeftPressPath, mUnderLeftFocusPath);
        fontSizeSpinnerOptButtonLayout.addView(this.mUnderlineBtn);
        return fontSizeSpinnerOptButtonLayout;
    }

    private ViewGroup paragraphSetting() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        ViewGroup.LayoutParams paragraphSettingLayoutParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(111.0f));
        linearLayout.setLayoutParams(paragraphSettingLayoutParams);
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams paragraphSettingAlignLayoutParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(55.0f));
        linearLayout2.setPadding(this.mDrawableImg.getIntValueAppliedDensity(12.0f), this.mDrawableImg.getIntValueAppliedDensity(8.0f), this.mDrawableImg.getIntValueAppliedDensity(13.0f), this.mDrawableImg.getIntValueAppliedDensity(9.0f));
        paragraphSettingAlignLayoutParams.bottomMargin = this.mDrawableImg.getIntValueAppliedDensity(1.0f);
        paragraphSettingAlignLayoutParams.gravity = 16;
        linearLayout2.setLayoutParams(paragraphSettingAlignLayoutParams);
        linearLayout2.setOrientation(0);
        TextView mAlignTextView = new TextView(this.mContext);
        LinearLayout.LayoutParams mAlignTextViewParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(55.0f));
        mAlignTextViewParams.weight = 1.0f;
        mAlignTextView.setLayoutParams(mAlignTextViewParams);
        mAlignTextView.setText(this.mTextUtil.setString("string_align"));
        mAlignTextView.setTextColor(-16777216);
        mAlignTextView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(18.0f));
        mAlignTextView.setGravity(17);
        linearLayout2.addView(mAlignTextView);
        LinearLayout.LayoutParams mAlignLeftBtnParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(48.0f), this.mDrawableImg.getIntValueAppliedDensity(42.0f));
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
        LinearLayout.LayoutParams fontSizeParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(48.0f), this.mDrawableImg.getIntValueAppliedDensity(41.0f));
        fontSizeParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(6.0f);
        this.mFontSizeButton.setLayoutParams(fontSizeParams);
        if (mSdkVersion < 16) {
            this.mFontSizeButton.setBackgroundDrawable(this.mDrawableImg.setDrawableSelectImg(mDropdownNormalPath, mDropdownPressPath, mDropdownFocusPath));
        } else {
            this.mFontSizeButton.setBackground(this.mDrawableImg.setDrawableSelectImg(mDropdownNormalPath, mDropdownPressPath, mDropdownFocusPath));
        }
        this.mFontSizeButton.setGravity(19);
        this.mFontSizeButton.setPadding(this.mDrawableImg.getIntValueAppliedDensity(9.0f), 0, this.mDrawableImg.getIntValueAppliedDensity(9.0f), 0);
        this.mFontSizeButton.setSingleLine(true);
        this.mFontSizeButton.setTextColor(Color.rgb(0, 0, 0));
        this.mFontSizeButton.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(18.0f));
        this.mFontSizeButton.setText(this.mCurrentFontSize);
        this.mFontSizeButton.setEllipsize(TextUtils.TruncateAt.END);
        this.mFontSizeButton.setOnClickListener(this.mFontSizeOnClickListener);
        return this.mFontSizeButton;
    }

    private ViewGroup fontTypeSpinnerView() {
        LinearLayout fontTypeSpinnerLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams fontTypeSpinnerLayoutParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(115.0f), this.mDrawableImg.getIntValueAppliedDensity(41.0f));
        fontTypeSpinnerLayout.setLayoutParams(fontTypeSpinnerLayoutParams);
        fontTypeSpinnerLayoutParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(6.0f);
        fontTypeSpinnerLayout.addView(fontTypeSpinner());
        return fontTypeSpinnerLayout;
    }

    private Button fontTypeSpinner() {
        this.mFontTypeButton = new Button(this.mContext);
        LinearLayout.LayoutParams fontTypeParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(115.0f), this.mDrawableImg.getIntValueAppliedDensity(41.0f));
        this.mFontTypeButton.setLayoutParams(fontTypeParams);
        if (mSdkVersion < 16) {
            this.mFontTypeButton.setBackgroundDrawable(this.mDrawableImg.setDrawableSelectImg(mDropdownNormalPath, mDropdownPressPath, mDropdownFocusPath));
        } else {
            this.mFontTypeButton.setBackground(this.mDrawableImg.setDrawableSelectImg(mDropdownNormalPath, mDropdownPressPath, mDropdownFocusPath));
        }
        this.mFontTypeButton.setGravity(19);
        this.mFontTypeButton.setPadding(this.mDrawableImg.getIntValueAppliedDensity(9.0f), 0, this.mDrawableImg.getIntValueAppliedDensity(9.0f), 0);
        this.mFontTypeButton.setSingleLine(true);
        this.mFontTypeButton.setTextColor(Color.rgb(0, 0, 0));
        this.mFontTypeButton.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(18.0f));
        this.mFontTypeButton.setText(this.mCurrentFontName);
        this.mFontTypeButton.setEllipsize(TextUtils.TruncateAt.END);
        this.mFontTypeButton.setOnClickListener(this.mFontTypeOnClickListener);
        return this.mFontTypeButton;
    }

    private ViewGroup colorSelectedAndPicker() {
        RelativeLayout localLinearLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(163.0f));
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
        RelativeLayout paletteBgLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(163.0f));
        layoutParams.setMargins(0, 0, this.mDrawableImg.getIntValueAppliedDensity(2.0f), 0);
        paletteBgLayout.setLayoutParams(layoutParams);
        this.mImageLoader.addViewSetBackgroundImageLoad(paletteBgLayout, grayBodyLeftPath);
        return paletteBgLayout;
    }

    private ViewGroup PickerView() {
        RelativeLayout localLinearLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(261.0f), this.mDrawableImg.getIntValueAppliedDensity(65.0f));
        localLayoutParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(34.0f);
        localLayoutParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(34.0f);
        localLayoutParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(88.0f);
        localLinearLayout.setLayoutParams(localLayoutParams);
        this.mColorPickerView = colorPickerView();
        localLinearLayout.addView(this.mColorPickerView);
        return localLinearLayout;
    }

    private ViewGroup PaletteView() {
        RelativeLayout sizeDisplayLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams sizeDisplayLayoutParam = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(83.0f));
        sizeDisplayLayoutParam.setMargins(this.mDrawableImg.getIntValueAppliedDensity(4.0f), this.mDrawableImg.getIntValueAppliedDensity(3.0f), this.mDrawableImg.getIntValueAppliedDensity(4.0f), 0);
        sizeDisplayLayout.setLayoutParams(sizeDisplayLayoutParam);
        sizeDisplayLayout.setLayoutParams(sizeDisplayLayoutParam);
        this.mPaletteRightButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams rightImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(27.0f), this.mDrawableImg.getIntValueAppliedDensity(83.0f));
        rightImageParam.alignWithParent = true;
        rightImageParam.addRule(11);
        rightImageParam.addRule(15);
        this.mPaletteRightButton.setLayoutParams(rightImageParam);
        this.mPaletteRightButton.setContentDescription(this.mTextUtil.setString("string_next"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mPaletteRightButton, rightBgPath, rightBgPresslPath, rightBgFocuslPath, 27, 83);
        this.mPaletteLeftButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams leftImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(27.0f), this.mDrawableImg.getIntValueAppliedDensity(83.0f));
        leftImageParam.alignWithParent = true;
        leftImageParam.addRule(9);
        leftImageParam.addRule(15);
        this.mPaletteLeftButton.setLayoutParams(leftImageParam);
        this.mPaletteLeftButton.setContentDescription(this.mTextUtil.setString("string_back"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mPaletteLeftButton, leftBgPath, lefBgPresslPath, lefBgFocuslPath, 27, 83);
        this.mColorSelectView = colorPaletteView();
        sizeDisplayLayout.addView(this.mPaletteLeftButton);
        sizeDisplayLayout.addView(this.mColorSelectView);
        sizeDisplayLayout.addView(this.mPaletteRightButton);
        return sizeDisplayLayout;
    }

    private SpenColorPaletteView2 colorPaletteView() {
        SpenColorPaletteView2 colorPaletteView = new SpenColorPaletteView2(this.mContext, this.mDrawableImg.mCustom_imagepath, this.mScale);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(261.0f), -2);
        localLayoutParams.alignWithParent = true;
        localLayoutParams.addRule(14);
        localLayoutParams.addRule(15);
        colorPaletteView.setLayoutParams(localLayoutParams);
        colorPaletteView.setClickable(true);
        colorPaletteView.setFocusable(true);
        return colorPaletteView;
    }

    private SpenColorGradationView2 colorPickerView() {
        SpenColorGradationView2 localf = new SpenColorGradationView2(this.mContext, this.mDrawableImg.mCustom_imagepath, this.mScale);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(261.0f), this.mDrawableImg.getIntValueAppliedDensity(65.0f));
        localf.setLayoutParams(localLayoutParams);
        localf.setClickable(true);
        localf.setContentDescription(this.mTextUtil.setString("string_gradation"));
        localf.setPadding(0, 0, 0, 0);
        return localf;
    }

    private View bottomLayout() {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams bottomLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(17.0f / this.mScale));
        bottomLayoutParams.setMargins(0, this.mDrawableImg.getIntValueAppliedDensity(330.0f - (17.0f / this.mScale)), 0, 0);
        relativeLayout.setLayoutParams(bottomLayoutParams);
        ImageView bottomBg = new ImageView(this.mContext);
        bottomBg.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(17.0f / this.mScale)));
        this.mImageLoader.addViewSetBackgroundImageLoad(bottomBg, bottomExpandPath);
        ImageView bottomHandle = new ImageView(this.mContext);
        RelativeLayout.LayoutParams bottomHandleParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(22.0f / this.mScale), this.mDrawableImg.getIntValueAppliedDensity(16.0f / this.mScale));
        bottomHandleParam.alignWithParent = true;
        bottomHandleParam.addRule(14);
        bottomHandleParam.addRule(8);
        bottomHandle.setLayoutParams(bottomHandleParam);
        bottomHandle.setImageDrawable(this.mDrawableImg.setDrawableImg(bottomHandlePath, (int) (22.0f / this.mScale), (int) (16.0f / this.mScale)));
        relativeLayout.addView(bottomBg);
        relativeLayout.addView(bottomHandle);
        relativeLayout.setOnHoverListener(this.mHoverListener);
        return relativeLayout;
    }

    private void rotatePosition() {
        Rect newMovableRect = new Rect();
        if (this.mMovableRect.top != this.mTotalTopMargin) {
            newMovableRect.left = (this.mMovableRect.top - this.mTotalTopMargin) + this.mTotalLeftMargin;
        } else {
            newMovableRect.left = this.mTotalLeftMargin;
        }
        if (this.mMovableRect.left != this.mTotalLeftMargin) {
            newMovableRect.top = (this.mMovableRect.left - this.mTotalLeftMargin) + this.mTotalTopMargin;
        } else {
            newMovableRect.top = this.mTotalTopMargin;
        }
        newMovableRect.right = this.mMovableRect.bottom;
        newMovableRect.bottom = this.mMovableRect.right;
        Rect r = new Rect();
        int[] location = new int[2];
        getLocationOnScreen(location);
        r.left = location[0];
        r.top = location[1];
        r.right = r.left + getWidth();
        r.bottom = r.top + getHeight();
        float left = r.left - this.mMovableRect.left;
        float right = this.mMovableRect.right - r.right;
        float top = r.top - this.mMovableRect.top;
        float bottom = this.mMovableRect.bottom - r.bottom;
        float hRatio = left / (left + right);
        float vRatio = top / (top + bottom);
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
        if (r.width() < newMovableRect.width()) {
            params.leftMargin = Math.round((newMovableRect.width() - r.width()) * hRatio);
        } else {
            params.leftMargin = 0;
        }
        if (r.height() < newMovableRect.height()) {
            params.topMargin = Math.round((newMovableRect.height() - r.height()) * vRatio);
        } else {
            params.topMargin = 0;
        }
        setLayoutParams(params);
    }

    private void checkPosition() {
        int[] location = new int[2];
        int minWidth = this.mDrawableImg.getIntValueAppliedDensity(250.0f);
        int minHeight = this.mDrawableImg.getIntValueAppliedDensity(133.0f);
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
        if (changedView == this && visibility == 0) {
            int[] location = new int[2];
            getLocationOnScreen(location);
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
                this.mColorPickerView.setVisibility(0);
                this.mBottomLayout.setVisibility(0);
                this.mParagraphSetting.setVisibility(8);
                if (getHeight() == this.mDrawableImg.getIntValueAppliedDensity(42.0f)) {
                    setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(330.0f));
                }
                if (this.mCanvasLayout.getHeight() > 0 && this.mBodyLayoutHeight > this.mCanvasLayout.getHeight()) {
                    setExpandBarPosition((this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(17.0f / this.mScale)) - this.mDrawableImg.getIntValueAppliedDensity(42.0f));
                    break;
                }
                break;
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
                this.mColorPickerView.setVisibility(8);
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
                this.mColorPickerView.setVisibility(8);
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
                this.mColorPickerView.setVisibility(8);
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
                this.mColorPickerView.setVisibility(0);
                this.mBottomLayout.setVisibility(0);
                this.mParagraphSetting.setVisibility(8);
                setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(120.0f));
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
                this.mColorPickerView.setVisibility(8);
                this.mBottomLayout.setVisibility(0);
                this.mParagraphSetting.setVisibility(0);
                setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(200.0f));
                break;
            case 6:
                this.mBodyLayout.setVisibility(8);
                this.mTitleLayout.setVisibility(0);
                if (this.mCanvasLayout.getHeight() > 0 && this.mBodyLayoutHeight > this.mCanvasLayout.getHeight()) {
                    setExpandBarPosition((this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(17.0f / this.mScale)) - this.mDrawableImg.getIntValueAppliedDensity(42.0f));
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
                this.mColorPickerView.setVisibility(0);
                this.mBottomLayout.setVisibility(0);
                this.mParagraphSetting.setVisibility(8);
                break;
        }
    }

    void setExpandBarPosition(int position) {
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
            this.mCurrentFontName = SpenFont.getFontName(this.mSettingInfo.font);
            this.mFontTypeButton.setText(this.mCurrentFontName);
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
            this.mColorSelectView.setColor(this.mSettingInfo.color);
            if (this.mCanvasView != null) {
                this.mCanvasWidth = this.mCanvasView.getCanvasWidth();
            } else {
                this.mCanvasWidth = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_PPT_SLIDEMOVEPREV_EVENT;
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

    protected void onLayoutChange() {
        scroll(this.mScrollView.getScrollY());
    }

    protected void onScroll(MotionEvent motionEvent) {
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        if (visibility == 0 && !this.mImageLoader.mLoaded) {
            this.mImageLoader.loadImage();
            if (1 != 0) {
                if (this.mCanvasView != null) {
                    this.mCanvasWidth = this.mCanvasView.getCanvasWidth();
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

    public void setLayoutHeight(int height) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) getLayoutParams();
        params.height = height;
        setLayoutParams(params);
    }

    private void playScrollAnimationForBottomBar(int delay, final int from, final int to) {
        if (this.mScrollTimer != null) {
            this.mScrollTimer.cancel();
        }
        this.mScrollTimer = new Timer();
        this.mCount = 0;
        this.mScrollTimer.scheduleAtFixedRate(new TimerTask() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.17
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Handler handler = SpenSettingTextLayout2.this.mHandler;
                final int i = from;
                final int i2 = to;
                handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.17.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SpenSettingTextLayout2.this.mCount += 5;
                        if (i > i2) {
                            int pos = i - SpenSettingTextLayout2.this.mCount;
                            SpenSettingTextLayout2.this.setLayoutHeight(pos);
                            if (pos <= i2) {
                                SpenSettingTextLayout2.this.setLayoutHeight(i2);
                                if (SpenSettingTextLayout2.this.mScrollTimer != null) {
                                    SpenSettingTextLayout2.this.mScrollTimer.cancel();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        int pos2 = i + SpenSettingTextLayout2.this.mCount;
                        SpenSettingTextLayout2.this.setLayoutHeight(pos2);
                        if (pos2 >= i2) {
                            SpenSettingTextLayout2.this.setLayoutHeight(i2);
                            if (SpenSettingTextLayout2.this.mScrollTimer != null) {
                                SpenSettingTextLayout2.this.mScrollTimer.cancel();
                            }
                        }
                    }
                });
            }
        }, 10L, delay);
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
            if (!this.mExpandFlag && this.mBodyLayoutHeight + this.mDrawableImg.getIntValueAppliedDensity((17.0f / this.mScale) + 42.0f) > h) {
                setExpandBarPosition(h - this.mDrawableImg.getIntValueAppliedDensity((17.0f / this.mScale) + 42.0f));
            }
            int minWidth = this.mDrawableImg.getIntValueAppliedDensity(250.0f);
            int minHeight = this.mDrawableImg.getIntValueAppliedDensity(133.0f);
            if (w < minWidth || h < minHeight) {
                this.mMovableRect.set(getMovableRect());
                checkPosition();
            }
            Handler handler = new Handler();
            handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingTextLayout2.18
                @Override // java.lang.Runnable
                public void run() {
                    SpenSettingTextLayout2.this.requestLayout();
                }
            });
            super.onSizeChanged(w, h, oldw, oldh);
        } catch (NullPointerException e) {
        }
    }

    private Rect getMovableRect() {
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
