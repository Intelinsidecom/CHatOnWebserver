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
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.infraware.office.evengine.InterfaceC0507E;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingViewInterface;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface;
import com.samsung.android.sdk.pen.settingui.SpenColorGradationView;
import com.samsung.android.sdk.pen.settingui.SpenColorPaletteView;
import com.samsung.android.sdk.pen.settingui.SpenPenPresetListAdapter;
import com.samsung.android.sdk.pen.settingui.SpenScrollView;
import com.sec.spp.push.Config;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class SpenSettingPenLayout extends LinearLayout {
    private static final int BEAUTIFY_ADVANCE_CURSIVE_MAX_VALUE = 12;
    private static final int BEAUTIFY_ADVANCE_DEFAULT_MAX_VALUE = 20;
    private static final int BEAUTIFY_ADVANCE_DUMMY_MAX_VALUE = 20;
    private static final int BEAUTIFY_ADVANCE_MODULATION_MAX_VALUE = 100;
    private static final int BEAUTIFY_ADVANCE_SUSTENANCE_MAX_VALUE = 16;
    private static final int BEAUTIFY_MAX_STYLEID_COUNT = 6;
    private static final int BEAUTIFY_PARAMETER_CURSIVE = 2;
    private static final int BEAUTIFY_PARAMETER_DUMMY = 4;
    private static final int BEAUTIFY_PARAMETER_MODULATION = 6;
    private static final int BEAUTIFY_PARAMETER_SLANT = 9;
    private static final int BEAUTIFY_PARAMETER_STYLEID = 0;
    private static final int BEAUTIFY_PARAMETER_SUSTENANCE = 3;
    private static final String BEAUTIFY_PEN_NAME = "com.samsung.android.sdk.pen.pen.preload.Beautify";
    private static final int BEAUTIFY_RUNNING_HAND_S_INDEX = 5;
    private static final int BEAUTIFY_STYLEID_CURSIVE_LM = 11;
    private static final int BEAUTIFY_STYLEID_HUAI = 12;
    private static final int BEAUTIFY_STYLEID_HUANG = 5;
    private static final int BEAUTIFY_STYLEID_HUI = 6;
    private static final int BEAUTIFY_STYLEID_RUNNING_HAND_S = 1;
    private static final int BEAUTIFY_STYLEID_WANG = 3;
    protected static final int BOTTOM_LAYOUT_HEIGHT = 16;
    private static final String CHINESE_PEN_NAME = "com.samsung.android.sdk.pen.pen.preload.ChineseBrush";
    protected static final int EXIT_BUTTON_HEIGHT = 36;
    protected static final int EXIT_BUTTON_WIDTH = 38;
    private static final int IB_PEN_ADD_ID = 12070905;
    protected static final int LINE_BUTTON_BOTTOM_MARGIN = 8;
    protected static final int LINE_BUTTON_HEIGHT = 19;
    protected static final int LINE_BUTTON_TOP_MARGIN = 9;
    protected static final int LINE_BUTTON_WIDTH = 1;
    private static final String MAGIC_PEN_NAME = "com.samsung.android.sdk.pen.pen.preload.MagicPen";
    protected static final int MAXIMUM_PRESET_NUMBER = 36;
    private static final int MAX_PARAMETER_INDEX = 10;
    protected static final int PEN_SIZE_MAX = 99;
    private static final int REP_DELAY = 20;
    protected static final int SEEKBAR_LAYOUT_HEIGHT = 50;
    private static final String TAG = "settingui-settingPen";
    public static final int VIEW_MODE_COLOR = 6;
    public static final int VIEW_MODE_EXTENSION = 2;
    public static final int VIEW_MODE_EXTENSION_WITHOUT_PRESET = 3;
    public static final int VIEW_MODE_EXTENSION_WITHOUT_PRESET_NO_RESIZE = 9;
    public static final int VIEW_MODE_MINIMUM = 1;
    public static final int VIEW_MODE_NORMAL = 0;
    public static final int VIEW_MODE_PRESET = 7;
    public static final int VIEW_MODE_SIZE = 5;
    public static final int VIEW_MODE_TITLE = 8;
    public static final int VIEW_MODE_TYPE = 4;
    protected static List<SpenPenPresetInfo> mPresetInfoList;
    protected final int BEAUTIFY_ENABLE_BUTTON_HEIGHT;
    protected final int BEAUTIFY_RESET_BUTTON_HEIGHT;
    protected final int BODY_LAYOUT_HEIGHT;
    protected final int BODY_LAYOUT_HEIGHT_BEAUTIFY_PEN;
    protected final int BODY_LAYOUT_HEIGHT_BEAUTIFY_RAINBOW;
    protected final int BODY_LAYOUT_HEIGHT_CHINESE;
    protected final int BODY_LAYOUT_HEIGHT_MAGIC_PEN;
    protected final int BODY_LAYOUT_HEIGHT_WITH_ALPHA;
    protected final int GRADATION_HEIGHT;
    private final int MAX_HEIGHT_FLAG;
    protected final int TITLE_LAYOUT_HEIGHT;
    protected final int TOTAL_LAYOUT_WIDTH;
    protected final int TYPE_SELECTOR_LAYOUT_HEIGHT;
    private Drawable alphaDrawable;
    private SpenColorPaletteView colorPaletteView;
    private int currenMagicPenHeight;
    private int deltaOfFirstTime;
    private int deltaOfMiniMode;
    Handler handler;
    private final View.OnTouchListener horizontalScrollViewTouchListener;
    private boolean isFirstTime;
    private boolean isMagicPenEnable;
    private boolean isMinimumMode;
    private boolean isPresetClicked;
    private final DisplayMetrics localDisplayMetrics;
    private RelativeLayout localPenTypeViewGroup;
    protected ActionListener mActionListener;
    private View mAdvancedSettingButton;
    private final View.OnClickListener mAdvancedSettingButtonListner;
    private final SpenPenInterface.ChangeListener mAdvancedSettingListener;
    private boolean mAdvancedSettingShow;
    private boolean mBeautifyAdvanceCursiveAutoDecrement;
    private boolean mBeautifyAdvanceCursiveAutoIncrement;
    private final SeekBar.OnSeekBarChangeListener mBeautifyAdvanceCursiveChangeListner;
    private final View.OnKeyListener mBeautifyAdvanceCursiveKeyListner;
    protected View mBeautifyAdvanceCursiveMinusButton;
    private final View.OnClickListener mBeautifyAdvanceCursiveMinusButtonListener;
    private final View.OnLongClickListener mBeautifyAdvanceCursiveMinusButtonLongClickListener;
    private final View.OnTouchListener mBeautifyAdvanceCursiveMinusButtonTouchListener;
    protected View mBeautifyAdvanceCursivePlusButton;
    private final View.OnClickListener mBeautifyAdvanceCursivePlusButtonListener;
    private final View.OnLongClickListener mBeautifyAdvanceCursivePlusButtonLongClickListener;
    private final View.OnTouchListener mBeautifyAdvanceCursivePlusButtonTouchListener;
    protected SeekBar mBeautifyAdvanceCursiveSeekbar;
    private boolean mBeautifyAdvanceDummyAutoDecrement;
    private boolean mBeautifyAdvanceDummyAutoIncrement;
    private final SeekBar.OnSeekBarChangeListener mBeautifyAdvanceDummyChangeListner;
    private final View.OnKeyListener mBeautifyAdvanceDummyKeyListner;
    protected View mBeautifyAdvanceDummyMinusButton;
    private final View.OnClickListener mBeautifyAdvanceDummyMinusButtonListener;
    private final View.OnLongClickListener mBeautifyAdvanceDummyMinusButtonLongClickListener;
    private final View.OnTouchListener mBeautifyAdvanceDummyMinusButtonTouchListener;
    protected View mBeautifyAdvanceDummyPlusButton;
    private final View.OnClickListener mBeautifyAdvanceDummyPlusButtonListener;
    private final View.OnLongClickListener mBeautifyAdvanceDummyPlusButtonLongClickListener;
    private final View.OnTouchListener mBeautifyAdvanceDummyPlusButtonTouchListener;
    protected SeekBar mBeautifyAdvanceDummySeekbar;
    private boolean mBeautifyAdvanceModulationAutoDecrement;
    private boolean mBeautifyAdvanceModulationAutoIncrement;
    private final SeekBar.OnSeekBarChangeListener mBeautifyAdvanceModulationChangeListner;
    private final View.OnKeyListener mBeautifyAdvanceModulationKeyListner;
    protected View mBeautifyAdvanceModulationMinusButton;
    private final View.OnClickListener mBeautifyAdvanceModulationMinusButtonListener;
    private final View.OnTouchListener mBeautifyAdvanceModulationMinusButtonTouchListener;
    private final View.OnLongClickListener mBeautifyAdvanceModulationMinusButtonlongClickListener;
    protected View mBeautifyAdvanceModulationPlusButton;
    private final View.OnClickListener mBeautifyAdvanceModulationPlusButtonListener;
    private final View.OnLongClickListener mBeautifyAdvanceModulationPlusButtonLongClickListener;
    private final View.OnTouchListener mBeautifyAdvanceModulationPlusButtonTouchListener;
    protected SeekBar mBeautifyAdvanceModulationSeekbar;
    protected Button mBeautifyAdvanceResetButton;
    private final View.OnClickListener mBeautifyAdvanceResetButtonListener;
    protected View mBeautifyAdvanceSettingLayout;
    private boolean mBeautifyAdvanceSustenanceAutoDecrement;
    private boolean mBeautifyAdvanceSustenanceAutoIncrement;
    private final SeekBar.OnSeekBarChangeListener mBeautifyAdvanceSustenanceChangeListner;
    private final View.OnKeyListener mBeautifyAdvanceSustenanceKeyListner;
    protected View mBeautifyAdvanceSustenanceMinusButton;
    private final View.OnClickListener mBeautifyAdvanceSustenanceMinusButtonListener;
    private final View.OnLongClickListener mBeautifyAdvanceSustenanceMinusButtonLongClickListener;
    private final View.OnTouchListener mBeautifyAdvanceSustenanceMinusButtonTouchListener;
    protected View mBeautifyAdvanceSustenancePlusButton;
    private final View.OnClickListener mBeautifyAdvanceSustenancePlusButtonListener;
    private final View.OnLongClickListener mBeautifyAdvanceSustenancePlusButtonLongClickListener;
    private final View.OnTouchListener mBeautifyAdvanceSustenancePlusButtonTouchListener;
    protected SeekBar mBeautifyAdvanceSustenanceSeekbar;
    protected TextView mBeautifyCursiveTextView;
    protected TextView mBeautifyDummyTextView;
    protected View mBeautifyEnableLayout;
    protected Switch mBeautifyEnableSwitchView;
    protected TextView mBeautifyEnableTextView;
    private final CompoundButton.OnCheckedChangeListener mBeautifyEnablecheckedChangeListener;
    protected TextView mBeautifyModulationTextView;
    protected ArrayList<ImageButton> mBeautifyStyleBtnViews;
    protected View mBeautifyStyleBtnsLayout;
    private final View.OnClickListener mBeautifyStyleBtnsListener;
    protected TextView mBeautifySustenanceTextView;
    protected boolean mBgTransparent;
    protected View mBodyBg;
    protected RelativeLayout mBodyLayout;
    protected int mBodyLayoutHeight;
    protected ImageView mBottomExtendBg;
    protected ImageView mBottomHandle;
    protected View mBottomLayout;
    protected RelativeLayout mCanvasLayout;
    protected int mCanvasSize;
    protected SpenSettingViewInterface mCanvasView;
    protected SpenColorGradationView mColorGradationView;
    protected SpenColorPaletteView mColorPaletteView;
    private final SpenColorGradationView.onColorChangedListener mColorPickerColorChangeListener;
    protected View mColorPickerColorImage;
    protected View mColorPickerCurrentColor;
    private final View.OnClickListener mColorPickerCurrentColorListener;
    protected SpenColorPickerLayout mColorPickerSetting;
    protected View mColorPickerSettingExitButton;
    protected View mColorSelectPickerLayout;
    protected Context mContext;
    private int mCount;
    private final int[][] mCurrentBeautifyAdvanceSettingValues;
    private int mCurrentBeautifyStyle;
    protected int mCurrentTopMargin;
    protected GradientDrawable mCursiveSeekbarColor;
    protected SPenImageUtil mDrawableImg;
    protected GradientDrawable mDummySeekbarColor;
    protected boolean mEnablePresetSave;
    protected View mExitButton;
    private final View.OnClickListener mExitButtonListener;
    protected boolean mExpandFlag;
    protected boolean mExpend;
    View.OnHoverListener mExpendBarHoverListener;
    View.OnTouchListener mExpendBarListener;
    protected boolean mFirstLongPress;
    protected GestureDetector mGestureDetector;
    private final GestureDetector.OnGestureListener mGestureListener;
    private final Handler mHandler;
    private SpenImageLoader mImageLoader;
    protected ImageView mIndicator;
    boolean mIsMaxHeight;
    protected boolean mIsRotated;
    protected boolean mIsRotated2;
    View.OnLayoutChangeListener mLayoutChangeListener;
    protected int mLeftMargin;
    protected View mLine1Button;
    protected View mLine2Button;
    protected GradientDrawable mModulationSeekbarColor;
    protected Rect mMovableRect;
    protected boolean mMoveSettingLayout;
    protected boolean mNeedCalculateMargin;
    int mNumberOfPenExist;
    protected int[] mOldLocation;
    protected Rect mOldMovableRect;
    private final SpenPenPresetListAdapter.OnClickPresetItemListener mOnClickPresetItemListener;
    private final SpenColorPaletteView.OnColorChangedListener mOnColorChangedListener;
    private final View.OnHoverListener mOnConsumedHoverListener;
    private final View.OnTouchListener mOnConsumedTouchListener;
    private final View.OnTouchListener mOnTouchListener;
    protected boolean mOnsizeChange;
    protected View mOpacityMinusButton;
    protected View mOpacityPlusButton;
    private final View.OnClickListener mPaletteBackButtonListener;
    protected View mPaletteBg;
    protected View mPaletteLeftButton;
    private final View.OnClickListener mPaletteNextButtonListener;
    protected View mPaletteRightButton;
    protected View mPaletteView;
    protected int mPenAlpha;
    private boolean mPenAlphaAutoDecrement;
    private boolean mPenAlphaAutoIncrement;
    private final SeekBar.OnSeekBarChangeListener mPenAlphaChangeListner;
    private final View.OnKeyListener mPenAlphaKeyListener;
    private final View.OnKeyListener mPenAlphaMinusButtonKeyListener;
    private final View.OnClickListener mPenAlphaMinusButtonListener;
    private final View.OnLongClickListener mPenAlphaMinusButtonLongClickListener;
    private final View.OnTouchListener mPenAlphaMinusButtonTouchListener;
    private final View.OnKeyListener mPenAlphaPlusButtonKeyListener;
    private final View.OnClickListener mPenAlphaPlusButtonListener;
    private final View.OnLongClickListener mPenAlphaPlusButtonLongClickListener;
    private final View.OnTouchListener mPenAlphaPlusButtonTouchListener;
    protected RelativeLayout mPenAlphaPreview;
    protected SeekBar mPenAlphaSeekbar;
    protected GradientDrawable mPenAlphaSeekbarColor;
    protected View mPenAlphaSeekbarView;
    protected TextView mPenAlphaTextView;
    protected TextView mPenButton;
    protected View mPenButtonLayout;
    protected List<SpenSettingPenInfo> mPenDataList;
    protected View mPenLayout;
    protected int mPenNameIndex;
    protected int mPenPluginCount;
    protected ArrayList<SpenPenPluginInfo> mPenPluginInfoList;
    protected SpenPenPluginManager mPenPluginManager;
    protected SpenPenPreview mPenPreview;
    protected View mPenSeekbarLayout;
    private SpenSharedPreferencesManager mPenSharedPreferencesManager;
    private boolean mPenSizeAutoDecrement;
    private boolean mPenSizeAutoIncrement;
    private final SeekBar.OnSeekBarChangeListener mPenSizeChangeListner;
    private final View.OnKeyListener mPenSizeKeyListener;
    protected View mPenSizeMinusButton;
    private final View.OnKeyListener mPenSizeMinusButtonKeyListener;
    private final View.OnClickListener mPenSizeMinusButtonListener;
    private final View.OnLongClickListener mPenSizeMinusButtonLongClickListener;
    private final View.OnTouchListener mPenSizeMinusButtonTouchListener;
    protected View mPenSizePlusButton;
    private final View.OnKeyListener mPenSizePlusButtonKeyListener;
    private final View.OnClickListener mPenSizePlusButtonListener;
    private final View.OnLongClickListener mPenSizePlusButtonLongClickListener;
    private final View.OnTouchListener mPenSizePlusButtonTouchListener;
    protected SeekBar mPenSizeSeekbar;
    protected GradientDrawable mPenSizeSeekbarColor;
    protected View mPenSizeSeekbarView;
    protected TextView mPenSizeTextView;
    protected ViewGroup mPenTypeHorizontalScrollView;
    protected HorizontalScrollView mPenTypeHorizontalScrollView2;
    protected ViewGroup mPenTypeHorizontalScrollView3;
    private final View.OnHoverListener mPenTypeHoverListener;
    private final View.OnKeyListener mPenTypeKeyListener;
    protected ViewGroup mPenTypeLayout;
    private final View.OnClickListener mPenTypeListner;
    private final View.OnTouchListener mPenTypeTouchListener;
    protected ArrayList<View> mPenTypeView;
    protected View mPickerView;
    protected SpenPluginManager mPluginManager;
    protected int mPreCanvasFingerAction;
    protected int mPreCanvasMouseAction;
    protected int mPreCanvasPenAction;
    private final View.OnClickListener mPreSetAddButtonListner;
    protected View mPresetAddButton;
    protected TextView mPresetButton;
    protected GridView mPresetGridView;
    protected LinearLayout mPresetLayout;
    protected SpenPenPresetListAdapter mPresetListAdapter;
    protected PresetListener mPresetListener;
    protected TextView mPresetTextView;
    protected View mPresetTypeLayout;
    protected View mPreviewLayout;
    protected int mPreviousSelectedPresetIndex;
    private Timer mScrollTimer;
    protected SpenScrollView mScrollView;
    private final SpenScrollView.scrollChangedListener mScrollViewListner;
    protected int mScrollY;
    protected SeekBarChangeListener mSeekBarChangeListener;
    protected SpenSettingPenInfo mSettingInfo;
    protected SPenTextUtil mStringUtil;
    private boolean mSupportBeautifyPen;
    protected GradientDrawable mSustenanceSeekbarColor;
    private final View.OnClickListener mTabSelectListener;
    protected View mTablineLayout;
    protected View mTitleLayout;
    private TextView mTitleView;
    protected int mTopMargin;
    protected LinearLayout mTypeSelectorLayout;
    protected int mViewMode;
    protected ViewListener mVisibilityListener;
    protected int mWindowHeight;
    protected int mXDelta;
    protected int mYDelta;
    private RelativeLayout penTypeLayout;
    private boolean previousPenMagicSelected;
    private final Handler repeatUpdateHandler;
    protected boolean requestLayoutDisable;
    protected static float mScale = 1.0f;
    protected static String mDefaultPath = "";
    private static boolean isHighlightPenRemoved = false;
    private static boolean isMagicPenRemoved = false;
    protected static boolean mIsSwichTab = false;
    private static final int mSdkVersion = Build.VERSION.SDK_INT;
    private static final String titleLeftPath = String.valueOf(mDefaultPath) + "snote_popup_title_left";
    private static final String titleCenterPath = String.valueOf(mDefaultPath) + "snote_popup_title_center";
    private static final String titleRightPath = String.valueOf(mDefaultPath) + "snote_popup_title_right";
    private static final String exitPath = String.valueOf(mDefaultPath) + "snote_popup_close";
    private static final String exitfocusPath = String.valueOf(mDefaultPath) + "snote_popup_close_focus";
    private static final String exitPressPath = String.valueOf(mDefaultPath) + "snote_popup_close_press";
    private static final String presetAddPath = String.valueOf(mDefaultPath) + "snote_popup_add";
    private static final String presetAddFocusPath = String.valueOf(mDefaultPath) + "snote_popup_add_focus";
    private static final String presetAddPressPath = String.valueOf(mDefaultPath) + "snote_popup_add_press";
    private static final String linePath = String.valueOf(mDefaultPath) + "snote_popup_divider";
    private static final String lineDivider = String.valueOf(mDefaultPath) + "snote_popup_line";
    private static final String lightBodyLeftPath = String.valueOf(mDefaultPath) + "snote_popup_bg_left";
    private static final String lightBodyRightPath = String.valueOf(mDefaultPath) + "snote_popup_bg_right";
    private static final String grayBodyLeftPath = String.valueOf(mDefaultPath) + "snote_popup_bg02_left";
    private static final String grayBodyRightPath = String.valueOf(mDefaultPath) + "snote_popup_bg02_right";
    private static final String tabLinePath = String.valueOf(mDefaultPath) + "snote_sub_tab_bg";
    private static final String tabLineSelectPath = String.valueOf(mDefaultPath) + "snote_sub_tab_selected";
    private static final String tabLineSelectedFocusPath = String.valueOf(mDefaultPath) + "snote_sub_tab_selected_focus";
    private static final String tabLineUnselectedFocusPath = String.valueOf(mDefaultPath) + "snote_sub_tab_bg_focus";
    private static final String tabBorderLinePath = String.valueOf(mDefaultPath) + "snote_sub_tab_line";
    protected static final String mPreviewBgPath = String.valueOf(mDefaultPath) + "snote_popup_preview_bg";
    private static final String leftBgPath = String.valueOf(mDefaultPath) + "snote_popup_arrow_left_normal";
    private static final String leftBgPressPath = String.valueOf(mDefaultPath) + "snote_popup_arrow_left_press";
    private static final String leftBgFocusPath = String.valueOf(mDefaultPath) + "snote_popup_arrow_left_focus";
    private static final String leftBgDimPath = String.valueOf(mDefaultPath) + "snote_popup_arrow_left_dim";
    private static final String rightBgPath = String.valueOf(mDefaultPath) + "snote_popup_arrow_right_normal";
    private static final String rightBgPressPath = String.valueOf(mDefaultPath) + "snote_popup_arrow_right_press";
    private static final String rightBgFocusPath = String.valueOf(mDefaultPath) + "snote_popup_arrow_right_focus";
    private static final String rightBgDimPath = String.valueOf(mDefaultPath) + "snote_popup_arrow_right_dim";
    private static final String plusBgPath = String.valueOf(mDefaultPath) + "snote_popup_progress_btn_plus_normal";
    private static final String plusBgPressPath = String.valueOf(mDefaultPath) + "snote_popup_progress_btn_plus_press";
    private static final String plusBgFocusPath = String.valueOf(mDefaultPath) + "snote_popup_progress_btn_plus_focus";
    private static final String plusBgDimPath = String.valueOf(mDefaultPath) + "snote_popup_progress_btn_plus_dim";
    private static final String minusBgPath = String.valueOf(mDefaultPath) + "snote_popup_progress_btn_minus_normal";
    private static final String minusBgPressPath = String.valueOf(mDefaultPath) + "snote_popup_progress_btn_minus_press";
    private static final String minusBgFocusPath = String.valueOf(mDefaultPath) + "snote_popup_progress_btn_minus_focus";
    private static final String minusBgDimPath = String.valueOf(mDefaultPath) + "snote_popup_progress_btn_minus_dim";
    private static final String handelPath = String.valueOf(mDefaultPath) + "progress_handle_normal";
    private static final String handelPressPath = String.valueOf(mDefaultPath) + "progress_handle_press";
    private static final String handelFocusPath = String.valueOf(mDefaultPath) + "progress_handle_focus";
    private static final String progressBgPath = String.valueOf(mDefaultPath) + "progress_bg";
    private static final String progressShadowPath = String.valueOf(mDefaultPath) + "progress_shadow";
    private static final String progressAlphaPath = String.valueOf(mDefaultPath) + "progress_bg_alpha";
    private static final String previewAlphaPath = String.valueOf(mDefaultPath) + "snote_popup_pensetting_preview_alpha";
    private static final String switchCheckFalseBgPath = String.valueOf(mDefaultPath) + "beautify_switch_off";
    private static final String switchCheckTrueBgPath = String.valueOf(mDefaultPath) + "beautify_switch_on";
    private static final String switchThumbPath = String.valueOf(mDefaultPath) + "beautify_switch_thumb";
    private static final String popupBtnBgNomalPath = String.valueOf(mDefaultPath) + "snote_popup_btn_normal";
    private static final String popupBtnBgFocusPath = String.valueOf(mDefaultPath) + "snote_popup_btn_focus";
    private static final String popupBtnBgPressPath = String.valueOf(mDefaultPath) + "snote_popup_btn_press";
    private static final String bottomExpandPath = String.valueOf(mDefaultPath) + "snote_popup_bg_expand";
    private static final String bottomExpandPressPath = String.valueOf(mDefaultPath) + "snote_popup_bg_expand_press";
    private static final String bottomExpandPresetPath = String.valueOf(mDefaultPath) + "snote_popup_bg_expand_preset";
    private static final String bottomExpandPresetPressPath = String.valueOf(mDefaultPath) + "snote_popup_bg_expand_preset_press";
    private static final String bottomHandlePath = String.valueOf(mDefaultPath) + "snote_popup_handler";
    private static final String mImagePath_snote_add = String.valueOf(mDefaultPath) + "snote_add";
    private static final String mImagePath_snote_add_press = String.valueOf(mDefaultPath) + "snote_add_press";
    private static final String mImagePath_snote_add_dim = String.valueOf(mDefaultPath) + "snote_add_dim";
    private static int CANVAS_WIDTH_VEINNA = 1600;
    private static final int[][] BEAUTIFY_ADVANCE_DEFAULT_SETTING_VALUES = {new int[]{11, 2, 5, 8, 1, 15, 70, 11, 0, 1}, new int[]{12, 2, 5, 1, 1, 18, 70, 13, 0, 1}, new int[]{5, 2, 2, 2, 1, 18, 70, 5, 0, 1}, new int[]{6, 2, 3, 3, 1, 12, 70, 6, 0, 1}, new int[]{1, 2, 2, 8, 1, 15, 70, 3, 0, 1}, new int[]{3, 1, 3, 5, 1, 12, 70, 1, 0, 1}};

    public interface ActionListener {
        void onMoved();

        void onResized();
    }

    public interface PresetListener {
        void onAdded(SpenSettingPenInfo spenSettingPenInfo);

        void onDeleted(int i);

        void onSelected(int i);
    }

    public interface SeekBarChangeListener {
        void onProgressChanged();
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

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.requestLayoutDisable) {
            super.requestLayout();
        }
        this.requestLayoutDisable = false;
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
        if (!isMagicPenRemoved) {
            for (int i = 0; i < this.mPenTypeView.size(); i++) {
                if (this.mPenTypeView.get(i).isSelected() && this.mPenTypeView.get(i).getId() == 1005) {
                    setMagicPenMode(this.currenMagicPenHeight);
                    this.mPenAlphaPreview.setVisibility(0);
                }
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

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        Log.d(TAG, "onConfig pen " + getVisibility());
        try {
            if (this.mNeedCalculateMargin && this.mCanvasLayout != null) {
                this.mCurrentTopMargin = 0;
            }
            if (getVisibility() != 8) {
                this.mOldMovableRect.set(getMovableRect());
                getLocationOnScreen(this.mOldLocation);
            }
            this.mIsRotated = true;
            if (this.mColorPickerSetting != null) {
                this.mColorPickerSetting.setRotation();
            }
            super.onConfigurationChanged(newConfig);
        } catch (NullPointerException e) {
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    class RptUpdater implements Runnable {
        RptUpdater() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!SpenSettingPenLayout.this.mPenSizeAutoIncrement) {
                if (!SpenSettingPenLayout.this.mPenSizeAutoDecrement) {
                    if (!SpenSettingPenLayout.this.mPenAlphaAutoIncrement) {
                        if (!SpenSettingPenLayout.this.mPenAlphaAutoDecrement) {
                            if (!SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoIncrement) {
                                if (!SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoDecrement) {
                                    if (!SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoIncrement) {
                                        if (!SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoDecrement) {
                                            if (!SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoIncrement) {
                                                if (!SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoDecrement) {
                                                    if (!SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoIncrement) {
                                                        if (SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoDecrement) {
                                                            SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.incrementProgressBy(-1);
                                                            SpenSettingPenLayout.this.repeatUpdateHandler.postDelayed(SpenSettingPenLayout.this.new RptUpdater(), 20L);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.incrementProgressBy(1);
                                                    SpenSettingPenLayout.this.repeatUpdateHandler.postDelayed(SpenSettingPenLayout.this.new RptUpdater(), 20L);
                                                    return;
                                                }
                                                SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.incrementProgressBy(-1);
                                                SpenSettingPenLayout.this.repeatUpdateHandler.postDelayed(SpenSettingPenLayout.this.new RptUpdater(), 20L);
                                                return;
                                            }
                                            SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.incrementProgressBy(1);
                                            SpenSettingPenLayout.this.repeatUpdateHandler.postDelayed(SpenSettingPenLayout.this.new RptUpdater(), 20L);
                                            return;
                                        }
                                        SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.incrementProgressBy(-1);
                                        SpenSettingPenLayout.this.repeatUpdateHandler.postDelayed(SpenSettingPenLayout.this.new RptUpdater(), 20L);
                                        return;
                                    }
                                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.incrementProgressBy(1);
                                    SpenSettingPenLayout.this.repeatUpdateHandler.postDelayed(SpenSettingPenLayout.this.new RptUpdater(), 20L);
                                    return;
                                }
                                SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.incrementProgressBy(-1);
                                SpenSettingPenLayout.this.repeatUpdateHandler.postDelayed(SpenSettingPenLayout.this.new RptUpdater(), 20L);
                                return;
                            }
                            SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.incrementProgressBy(1);
                            SpenSettingPenLayout.this.repeatUpdateHandler.postDelayed(SpenSettingPenLayout.this.new RptUpdater(), 20L);
                            return;
                        }
                        SpenSettingPenLayout.this.mPenAlphaSeekbar.incrementProgressBy(-1);
                        SpenSettingPenLayout.this.repeatUpdateHandler.postDelayed(SpenSettingPenLayout.this.new RptUpdater(), 20L);
                        return;
                    }
                    SpenSettingPenLayout.this.mPenAlphaSeekbar.incrementProgressBy(1);
                    SpenSettingPenLayout.this.repeatUpdateHandler.postDelayed(SpenSettingPenLayout.this.new RptUpdater(), 20L);
                    return;
                }
                SpenSettingPenLayout.this.mPenSizeSeekbar.incrementProgressBy(-1);
                float min = SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().getMinSettingValue();
                if (SpenSettingPenLayout.this.mCanvasView != null) {
                    if (SpenSettingPenLayout.this.mCanvasView.getCanvasWidth() < SpenSettingPenLayout.this.mCanvasView.getCanvasHeight()) {
                        SpenSettingPenLayout.this.mCanvasSize = SpenSettingPenLayout.this.mCanvasView.getCanvasWidth();
                    } else {
                        SpenSettingPenLayout.this.mCanvasSize = SpenSettingPenLayout.this.mCanvasView.getCanvasHeight();
                    }
                    if (SpenSettingPenLayout.this.mCanvasSize == 0) {
                        SpenSettingPenLayout.this.mCanvasSize = 1080;
                    }
                } else {
                    SpenSettingPenLayout.this.mCanvasSize = 1080;
                }
                SpenSettingPenLayout.this.mSettingInfo.size = (((SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() / 10.0f) + min) * SpenSettingPenLayout.this.mCanvasSize) / 360.0f;
                SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().setSize(SpenSettingPenLayout.this.mSettingInfo.size);
                SpenSettingPenLayout.this.repeatUpdateHandler.postDelayed(SpenSettingPenLayout.this.new RptUpdater(), 20L);
                return;
            }
            SpenSettingPenLayout.this.mPenSizeSeekbar.incrementProgressBy(1);
            float min2 = SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().getMinSettingValue();
            if (SpenSettingPenLayout.this.mCanvasView != null) {
                if (SpenSettingPenLayout.this.mCanvasView.getCanvasWidth() < SpenSettingPenLayout.this.mCanvasView.getCanvasHeight()) {
                    SpenSettingPenLayout.this.mCanvasSize = SpenSettingPenLayout.this.mCanvasView.getCanvasWidth();
                } else {
                    SpenSettingPenLayout.this.mCanvasSize = SpenSettingPenLayout.this.mCanvasView.getCanvasHeight();
                }
                if (SpenSettingPenLayout.this.mCanvasSize == 0) {
                    SpenSettingPenLayout.this.mCanvasSize = 1080;
                }
            } else {
                SpenSettingPenLayout.this.mCanvasSize = 1080;
            }
            SpenSettingPenLayout.this.mSettingInfo.size = (((SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() / 10.0f) + min2) * SpenSettingPenLayout.this.mCanvasSize) / 360.0f;
            SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().setSize(SpenSettingPenLayout.this.mSettingInfo.size);
            SpenSettingPenLayout.this.repeatUpdateHandler.postDelayed(SpenSettingPenLayout.this.new RptUpdater(), 20L);
        }
    }

    public SpenSettingPenLayout(Context context, String customImagePath, RelativeLayout relativeLayout) {
        super(context);
        this.mCanvasView = null;
        this.mPenAlpha = 255;
        this.mCanvasSize = 1080;
        this.mExpend = false;
        this.mGestureDetector = null;
        this.requestLayoutDisable = false;
        this.mEnablePresetSave = true;
        this.mBgTransparent = false;
        this.mExpandFlag = false;
        this.mOnsizeChange = false;
        this.mCurrentTopMargin = 0;
        this.mMoveSettingLayout = false;
        this.mPenTypeView = new ArrayList<>();
        this.mPenNameIndex = 0;
        this.mPresetListener = null;
        this.mActionListener = null;
        this.mSeekBarChangeListener = null;
        this.mVisibilityListener = null;
        this.mViewMode = 0;
        this.mBodyLayoutHeight = -2;
        this.mWindowHeight = 0;
        this.mScrollY = 0;
        this.mPreviousSelectedPresetIndex = -1;
        this.mNeedCalculateMargin = true;
        this.mFirstLongPress = true;
        this.mIsRotated = false;
        this.mIsRotated2 = false;
        this.colorPaletteView = null;
        this.MAX_HEIGHT_FLAG = 99999;
        this.currenMagicPenHeight = 99999;
        this.previousPenMagicSelected = false;
        this.isMagicPenEnable = false;
        this.isPresetClicked = false;
        this.mIsMaxHeight = false;
        this.penTypeLayout = null;
        this.repeatUpdateHandler = new Handler();
        this.mPenSizeAutoIncrement = false;
        this.mPenSizeAutoDecrement = false;
        this.mPenAlphaAutoIncrement = false;
        this.mPenAlphaAutoDecrement = false;
        this.mBeautifyAdvanceCursiveAutoIncrement = false;
        this.mBeautifyAdvanceCursiveAutoDecrement = false;
        this.mBeautifyAdvanceSustenanceAutoIncrement = false;
        this.mBeautifyAdvanceSustenanceAutoDecrement = false;
        this.mBeautifyAdvanceDummyAutoIncrement = false;
        this.mBeautifyAdvanceDummyAutoDecrement = false;
        this.mBeautifyAdvanceModulationAutoIncrement = false;
        this.mBeautifyAdvanceModulationAutoDecrement = false;
        this.mAdvancedSettingListener = new SpenPenInterface.ChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.1
            @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface.ChangeListener
            public void onChanged(String advancedSetting) {
                if (SpenSettingPenLayout.this.mCanvasView != null) {
                    SpenSettingPenInfo info = SpenSettingPenLayout.this.mCanvasView.getPenSettingInfo();
                    if (info != null) {
                        info.advancedSetting = advancedSetting;
                        SpenSettingPenLayout.this.mCanvasView.setPenSettingInfo(info);
                    }
                    SpenSettingPenLayout.this.mPenPreview.invalidate();
                }
            }
        };
        this.mCurrentBeautifyStyle = 0;
        this.mSupportBeautifyPen = false;
        this.BODY_LAYOUT_HEIGHT_BEAUTIFY_PEN = ScreenSharePacket.SCREEN_SHARE_CMD_EXTERNAL_PAUSE;
        this.BODY_LAYOUT_HEIGHT_BEAUTIFY_RAINBOW = 485;
        this.TOTAL_LAYOUT_WIDTH = 250;
        this.BODY_LAYOUT_HEIGHT = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_IME_INSERT_EVENT;
        this.BODY_LAYOUT_HEIGHT_WITH_ALPHA = 323;
        this.BODY_LAYOUT_HEIGHT_CHINESE = 312;
        this.BODY_LAYOUT_HEIGHT_MAGIC_PEN = ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARPAGE;
        this.GRADATION_HEIGHT = 48;
        this.TITLE_LAYOUT_HEIGHT = 41;
        this.TYPE_SELECTOR_LAYOUT_HEIGHT = 30;
        this.BEAUTIFY_RESET_BUTTON_HEIGHT = 40;
        this.BEAUTIFY_ENABLE_BUTTON_HEIGHT = 39;
        this.mOnClickPresetItemListener = new SpenPenPresetListAdapter.OnClickPresetItemListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.2
            @Override // com.samsung.android.sdk.pen.settingui.SpenPenPresetListAdapter.OnClickPresetItemListener
            public void deletePresetItem(int presetItemIndex) {
                try {
                    if (SpenSettingPenLayout.mPresetInfoList.size() > 0) {
                        if (SpenSettingPenLayout.mPresetInfoList.get(presetItemIndex) != null) {
                            SpenSettingPenLayout.mPresetInfoList.get(presetItemIndex).close();
                            SpenSettingPenLayout.mPresetInfoList.remove(presetItemIndex);
                            SpenPenPresetListAdapter.mList.remove(presetItemIndex);
                        }
                        if (SpenSettingPenLayout.this.mPreviousSelectedPresetIndex == presetItemIndex) {
                            SpenSettingPenLayout.this.mPresetListAdapter.mCurrentSeleted = -1;
                        } else if (SpenSettingPenLayout.this.mPreviousSelectedPresetIndex > presetItemIndex) {
                            SpenSettingPenLayout spenSettingPenLayout = SpenSettingPenLayout.this;
                            spenSettingPenLayout.mPreviousSelectedPresetIndex--;
                            SpenSettingPenLayout.this.mPresetListAdapter.mCurrentSeleted = SpenSettingPenLayout.this.mPreviousSelectedPresetIndex;
                        } else {
                            SpenSettingPenLayout.this.mPresetListAdapter.mCurrentSeleted = SpenSettingPenLayout.this.mPreviousSelectedPresetIndex;
                        }
                        SpenSettingPenLayout.this.mPresetListAdapter.notifyDataSetChanged();
                        SpenSettingPenLayout.this.presetDisplay();
                        if (SpenSettingPenLayout.this.mPresetListener != null) {
                            SpenSettingPenLayout.this.mPresetListener.onDeleted(presetItemIndex);
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                }
            }

            @Override // com.samsung.android.sdk.pen.settingui.SpenPenPresetListAdapter.OnClickPresetItemListener
            public void selectPresetItem(int presetItemIndex) {
                SpenSettingPenInfo info;
                for (int i = 0; i < SpenSettingPenLayout.this.mPenTypeView.size(); i++) {
                    if (SpenSettingPenLayout.this.mPenTypeView.get(i) != null) {
                        SpenSettingPenLayout.this.mPenTypeView.get(i).setSelected(false);
                        if (SpenSettingPenLayout.this.mPenPluginInfoList.get(i).getPenName().equals(SpenSettingPenLayout.mPresetInfoList.get(presetItemIndex).getPenName())) {
                            int penNameIdx = i;
                            if (SpenSettingPenLayout.this.isBeautifyPen(SpenSettingPenLayout.mPresetInfoList.get(presetItemIndex).getPenName())) {
                                penNameIdx = SpenSettingPenLayout.this.mPenPluginManager.getPenPluginIndexByPenName("com.samsung.android.sdk.pen.pen.preload.ChineseBrush");
                            }
                            SpenSettingPenLayout.this.mPresetListAdapter.mCurrentSeleted = presetItemIndex;
                            SpenSettingPenLayout.this.mPreviousSelectedPresetIndex = presetItemIndex;
                            SpenSettingPenLayout.this.mPresetListAdapter.notifyDataSetChanged();
                            SpenSettingPenLayout.this.presetDisplay();
                            SpenSettingPenLayout.mIsSwichTab = false;
                            if (SpenSettingPenLayout.mPresetInfoList.get(presetItemIndex).getPenName().equals("com.samsung.android.sdk.pen.pen.preload.MagicPen")) {
                                SpenSettingPenLayout.this.isMagicPenEnable = true;
                                SpenSettingPenLayout.this.mPenAlphaPreview.setVisibility(0);
                            } else {
                                SpenSettingPenLayout.this.mPenAlphaPreview.setVisibility(8);
                                SpenSettingPenLayout.this.isMagicPenEnable = false;
                            }
                            SpenSettingPenLayout.this.mPenTypeView.get(penNameIdx).setSelected(true);
                        }
                    }
                }
                if (SpenSettingPenLayout.this.mCanvasView != null && (info = SpenSettingPenLayout.this.mCanvasView.getPenSettingInfo()) != null) {
                    SpenSettingPenInfo spenSettingPenInfo = SpenSettingPenLayout.this.mSettingInfo;
                    String penName = SpenSettingPenLayout.mPresetInfoList.get(presetItemIndex).getPenName();
                    info.name = penName;
                    spenSettingPenInfo.name = penName;
                    SpenSettingPenInfo spenSettingPenInfo2 = SpenSettingPenLayout.this.mSettingInfo;
                    float penSize = SpenSettingPenLayout.mPresetInfoList.get(presetItemIndex).getPenSize();
                    info.size = penSize;
                    spenSettingPenInfo2.size = penSize;
                    SpenSettingPenInfo spenSettingPenInfo3 = SpenSettingPenLayout.this.mSettingInfo;
                    int color = SpenSettingPenLayout.mPresetInfoList.get(presetItemIndex).getColor();
                    info.color = color;
                    spenSettingPenInfo3.color = color;
                    SpenSettingPenInfo spenSettingPenInfo4 = SpenSettingPenLayout.this.mSettingInfo;
                    String advancedSetting = SpenSettingPenLayout.mPresetInfoList.get(presetItemIndex).getAdvancedSetting();
                    info.advancedSetting = advancedSetting;
                    spenSettingPenInfo4.advancedSetting = advancedSetting;
                    SpenSettingPenLayout.this.mCanvasView.setPenSettingInfo(info);
                    SpenSettingPenLayout.this.setInfo(SpenSettingPenLayout.this.mSettingInfo);
                    SpenSettingPenLayout.this.mPenPreview.setPenType(SpenSettingPenLayout.this.mSettingInfo.name);
                    SpenSettingPenLayout.this.mPenPreview.setStrokeSize(SpenSettingPenLayout.this.mSettingInfo.size);
                    SpenSettingPenLayout.this.mPenPreview.setStrokeColor(SpenSettingPenLayout.this.mSettingInfo.color);
                    SpenSettingPenLayout.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout.this.mSettingInfo.advancedSetting);
                    SpenSettingPenLayout.this.mPenPreview.invalidate();
                }
                if (SpenSettingPenLayout.this.mPresetListener != null) {
                    SpenSettingPenLayout.this.mPresetListener.onSelected(presetItemIndex);
                }
            }

            @Override // com.samsung.android.sdk.pen.settingui.SpenPenPresetListAdapter.OnClickPresetItemListener
            public void setScrollPresetGridToIndex(int paramInt) {
                SpenSettingPenLayout.this.mPresetGridView.smoothScrollToPosition(paramInt);
            }
        };
        this.mOnColorChangedListener = new SpenColorPaletteView.OnColorChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.3
            @Override // com.samsung.android.sdk.pen.settingui.SpenColorPaletteView.OnColorChangedListener
            public void colorChanged(int color, int selectedItem) {
                SpenSettingPenInfo info;
                if (SpenSettingPenLayout.this.isMinimumMode && selectedItem == 12) {
                    SpenSettingPenLayout.this.mColorGradationView.setVisibility(0);
                    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(118.0f));
                    SpenSettingPenLayout.this.mColorSelectPickerLayout.setLayoutParams(localLayoutParams);
                    SpenSettingPenLayout.this.isMinimumMode = false;
                    SpenSettingPenLayout.this.deltaOfMiniMode = 0;
                    SpenSettingPenLayout.this.setExpandBarPosition(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(323.0f));
                }
                int penPluginIndex = SpenSettingPenLayout.this.mPenPluginManager.getPenPluginIndexByPenName(SpenSettingPenLayout.this.mSettingInfo.name);
                if (penPluginIndex != -1 && SpenSettingPenLayout.this.mPenNameIndex == penPluginIndex && SpenSettingPenLayout.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject() != null) {
                    if (selectedItem != 13) {
                        SpenSettingPenLayout.this.mPenSizeSeekbarColor.setColor(color);
                        SpenSettingPenLayout.this.mPenSizeSeekbarColor.setAlpha(255);
                        SpenSettingPenLayout.this.setBeautifyAdvanceSeekbarColor(color);
                        if (SpenSettingPenLayout.this.mCanvasView != null && (info = SpenSettingPenLayout.this.mCanvasView.getPenSettingInfo()) != null) {
                            if (SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().getPenAttribute(1)) {
                                info.color = ((SpenSettingPenLayout.this.mPenAlpha << 24) & (-16777216)) | (16777215 & color);
                            } else {
                                info.color = color;
                            }
                            SpenSettingPenLayout.this.mSettingInfo.color = info.color;
                            SpenSettingPenLayout.this.mCanvasView.setPenSettingInfo(info);
                            SpenSettingPenLayout.this.mPenPreview.setStrokeColor(info.color);
                            SpenSettingPenLayout.this.mPenPreview.invalidate();
                            SpenSettingPenLayout.this.mPenAlphaSeekbarColor.setColor(info.color);
                            SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().setColor(info.color);
                            SpenSettingPenLayout.this.mColorPickerSetting.setColorPickerColor(info.color);
                        }
                        if (selectedItem == 12 && !SpenSettingPenLayout.this.isFirstTime && !SpenSettingPenLayout.this.isMinimumMode) {
                            SpenSettingPenLayout.this.isFirstTime = true;
                            SpenSettingPenLayout.this.mColorGradationView.setVisibility(0);
                            LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(118.0f));
                            SpenSettingPenLayout.this.mColorSelectPickerLayout.setLayoutParams(localLayoutParams2);
                            if (SpenSettingPenLayout.this.isBeautifyPen(SpenSettingPenLayout.this.mSettingInfo.name)) {
                                SpenSettingPenLayout.this.setExpandBarPosition(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(603.0f));
                            } else {
                                SpenSettingPenLayout.this.setExpandBarPosition(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(312.0f));
                            }
                        }
                    }
                    if (selectedItem == 13) {
                        if (SpenSettingPenLayout.this.mCanvasView != null) {
                            SpenSettingPenLayout.this.mPreCanvasPenAction = SpenSettingPenLayout.this.mCanvasView.getToolTypeAction(2);
                            SpenSettingPenLayout.this.mPreCanvasFingerAction = SpenSettingPenLayout.this.mCanvasView.getToolTypeAction(1);
                            SpenSettingPenLayout.this.mPreCanvasMouseAction = SpenSettingPenLayout.this.mCanvasView.getToolTypeAction(3);
                            SpenSettingPenLayout.this.mCanvasView.setToolTypeAction(2, 5);
                            SpenSettingPenLayout.this.mCanvasView.setToolTypeAction(1, 5);
                            SpenSettingPenLayout.this.mCanvasView.setToolTypeAction(3, 5);
                        }
                        SpenSettingPenLayout.this.mColorPaletteView.setColorPickerMode();
                        SpenSettingPenLayout.this.setVisibility(8);
                        SpenSettingPenLayout.this.mColorPickerSetting.show();
                    }
                }
            }
        };
        this.mColorPickerColorChangeListener = new SpenColorGradationView.onColorChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.4
            @Override // com.samsung.android.sdk.pen.settingui.SpenColorGradationView.onColorChangedListener
            public void onColorChanged(int color, int x, int y) {
                SpenSettingPenInfo info;
                int penPluginIndex = SpenSettingPenLayout.this.mPenPluginManager.getPenPluginIndexByPenName(SpenSettingPenLayout.this.mSettingInfo.name);
                if (penPluginIndex != -1 && SpenSettingPenLayout.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject() != null) {
                    SpenSettingPenLayout.this.mPenSizeSeekbarColor.setColor(color);
                    SpenSettingPenLayout.this.mPenSizeSeekbarColor.setAlpha(255);
                    SpenSettingPenLayout.this.setBeautifyAdvanceSeekbarColor(color);
                    if (SpenSettingPenLayout.this.mCanvasView != null && (info = SpenSettingPenLayout.this.mCanvasView.getPenSettingInfo()) != null) {
                        if (SpenSettingPenLayout.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().getPenAttribute(1)) {
                            info.color = ((SpenSettingPenLayout.this.mPenAlpha << 24) & (-16777216)) | (16777215 & color);
                        } else {
                            info.color = color;
                        }
                        SpenSettingPenLayout.this.mSettingInfo.color = info.color;
                        SpenSettingPenLayout.this.mCanvasView.setPenSettingInfo(info);
                        SpenSettingPenLayout.this.mPenAlphaSeekbarColor.setColor(info.color);
                        SpenSettingPenLayout.this.mPenPreview.setStrokeColor(info.color);
                        SpenSettingPenLayout.this.mPenPreview.invalidate();
                        SpenSettingPenLayout.this.mColorPaletteView.setColor(info.color);
                        SpenSettingPenLayout.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().setColor(info.color);
                        SpenSettingPenLayout.this.mColorPickerSetting.setColorPickerColor(info.color);
                    }
                }
            }
        };
        this.handler = new Handler();
        this.mPenAlphaChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.5
            int oldProgress = -1;

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (SpenSettingPenLayout.this.isMagicPenEnable) {
                    SpenSettingPenLayout.this.handler.postAtFrontOfQueue(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SpenSettingPenLayout.this.alphaDrawable.setAlpha(SpenSettingPenLayout.this.mPenAlpha);
                        }
                    });
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (SpenSettingPenLayout.this.isMagicPenEnable) {
                    SpenSettingPenLayout.this.alphaDrawable.setAlpha(SpenSettingPenLayout.this.mPenAlpha);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SpenSettingPenInfo info;
                int penPluginIndex = SpenSettingPenLayout.this.mPenPluginManager.getPenPluginIndexByPenName(SpenSettingPenLayout.this.mSettingInfo.name);
                if (penPluginIndex != -1 && SpenSettingPenLayout.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject() != null && seekBar == SpenSettingPenLayout.this.mPenAlphaSeekbar && this.oldProgress != progress) {
                    SpenSettingPenLayout.this.requestLayoutDisable = fromUser;
                    if (SpenSettingPenLayout.this.mSettingInfo.name.equals("com.samsung.android.sdk.pen.pen.preload.MagicPen")) {
                        SpenSettingPenLayout.this.requestLayoutDisable = false;
                    }
                    if (SpenSettingPenLayout.this.mPenAlphaPreview.getVisibility() == 0) {
                        SpenSettingPenLayout.this.mPenAlphaPreview.setAlpha((float) (progress / 100.0d));
                    }
                    SpenSettingPenLayout.this.mPenAlphaTextView.setText(String.valueOf(String.valueOf(progress + 1)) + "%");
                    int seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(24.0f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(170.0f) * (progress / 99.0f));
                    if (progress < 9) {
                        seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(26.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(168.0f) * (progress / 99.0f));
                    }
                    if (SpenSettingPenLayout.this.localDisplayMetrics.density == 2.0d && SpenSettingPenLayout.this.mCanvasSize != SpenSettingPenLayout.CANVAS_WIDTH_VEINNA) {
                        seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(24.0f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(168.0f) * (progress / 99.0f));
                        if (progress < 9) {
                            seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(26.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(168.0f) * (progress / 99.0f));
                        }
                        if (progress == SpenSettingPenLayout.PEN_SIZE_MAX) {
                            seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(23.0f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(168.0f) * (progress / 99.0f));
                        }
                    }
                    SpenSettingPenLayout.this.mPenAlphaSeekbar.setContentDescription(String.valueOf(SpenSettingPenLayout.this.mPenAlphaTextView.getText().toString()) + "\u0000");
                    SpenSettingPenLayout.this.mPenAlphaTextView.setX(seek_label_pos);
                    SpenSettingPenLayout.this.mPenAlphaTextView.setY(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(5.0f));
                    this.oldProgress = progress;
                    if (SpenSettingPenLayout.this.mCanvasView != null && (info = SpenSettingPenLayout.this.mCanvasView.getPenSettingInfo()) != null) {
                        if (SpenSettingPenLayout.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().getPenAttribute(1)) {
                            SpenSettingPenLayout.this.mPenAlpha = Math.round((progress * 255.0f) / 99.0f);
                            SpenSettingPenLayout.this.mPenPreview.setStrokeAlpha(SpenSettingPenLayout.this.mPenAlpha);
                            SpenSettingPenLayout.this.mPenPreview.invalidate();
                            info.color = ((SpenSettingPenLayout.this.mPenAlpha << 24) & (-16777216)) | (info.color & 16777215);
                            SpenSettingPenLayout.this.mPenAlphaSeekbarColor.setColor(info.color);
                            SpenSettingPenLayout.this.mSettingInfo.color = info.color;
                        }
                        SpenSettingPenLayout.this.mCanvasView.setPenSettingInfo(info);
                        SpenSettingPenLayout.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().setColor(info.color);
                    }
                    if (SpenSettingPenLayout.this.mPenAlphaSeekbar.getProgress() == SpenSettingPenLayout.this.mPenAlphaSeekbar.getMax()) {
                        SpenSettingPenLayout.this.mOpacityPlusButton.setSelected(false);
                        SpenSettingPenLayout.this.mOpacityPlusButton.setEnabled(false);
                        if (SpenSettingPenLayout.this.mPenAlphaAutoIncrement) {
                            SpenSettingPenLayout.this.mPenAlphaAutoIncrement = false;
                        }
                    } else {
                        SpenSettingPenLayout.this.mOpacityPlusButton.setEnabled(true);
                    }
                    if (SpenSettingPenLayout.this.mPenAlphaSeekbar.getProgress() == 0) {
                        SpenSettingPenLayout.this.mOpacityMinusButton.setSelected(false);
                        SpenSettingPenLayout.this.mOpacityMinusButton.setEnabled(false);
                        if (SpenSettingPenLayout.this.mPenAlphaAutoDecrement) {
                            SpenSettingPenLayout.this.mPenAlphaAutoDecrement = false;
                        }
                    } else {
                        SpenSettingPenLayout.this.mOpacityMinusButton.setEnabled(true);
                    }
                    if (SpenSettingPenLayout.this.isMagicPenEnable) {
                        if (SpenSettingPenLayout.this.alphaDrawable != null) {
                            SpenSettingPenLayout.this.alphaDrawable.setAlpha(SpenSettingPenLayout.this.mPenAlpha);
                        }
                        SpenSettingPenLayout.this.mPenAlphaSeekbarColor.setColor(0);
                    }
                }
            }
        };
        this.mPenSizeChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (SpenSettingPenLayout.this.mSeekBarChangeListener != null) {
                    SpenSettingPenLayout.this.mSeekBarChangeListener.onProgressChanged();
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SpenSettingPenInfo info;
                if (SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject() != null) {
                    SpenSettingPenLayout.this.requestLayoutDisable = fromUser;
                    if (SpenSettingPenLayout.this.mSettingInfo.name.equals("com.samsung.android.sdk.pen.pen.preload.MagicPen")) {
                        SpenSettingPenLayout.this.requestLayoutDisable = false;
                    }
                    float min = SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().getMinSettingValue();
                    float max = SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().getMaxSettingValue();
                    if (SpenSettingPenLayout.this.mPenAlphaPreview.getVisibility() == 0) {
                        float mAlphaWidth = (float) (2.7d + ((progress * 6.3d) / 140.0d));
                        RelativeLayout.LayoutParams penPreviewLayoutParams02 = new RelativeLayout.LayoutParams(-1, SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(mAlphaWidth));
                        penPreviewLayoutParams02.addRule(9);
                        penPreviewLayoutParams02.addRule(12);
                        penPreviewLayoutParams02.rightMargin = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(3.0f);
                        penPreviewLayoutParams02.leftMargin = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(2.0f);
                        penPreviewLayoutParams02.bottomMargin = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(9.5f - (mAlphaWidth / 2.0f));
                        SpenSettingPenLayout.this.mPenAlphaPreview.setLayoutParams(penPreviewLayoutParams02);
                    }
                    SpenSettingPenLayout.this.mPenSizeTextView.setText(String.valueOf(Math.round(10.0f * min) + progress));
                    int seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(26.0f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(172.0f) * (progress / ((max - min) * 10.0f)));
                    if (SpenSettingPenLayout.this.mSettingInfo.name.equals(SpenPenManager.SPEN_PENCIL)) {
                        seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(26.0f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(172.5f) * (progress / ((max - min) * 10.0f)));
                    }
                    if (Math.round(10.0f * min) + progress >= 100) {
                        seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(24.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(169.5f) * (progress / ((max - min) * 10.0f)));
                    }
                    if (Math.round(10.0f * min) + progress >= 200) {
                        seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(25.0f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(171.0f) * (progress / ((max - min) * 10.0f)));
                    }
                    if (SpenSettingPenLayout.this.localDisplayMetrics.density == 2.0d && SpenSettingPenLayout.this.mCanvasSize != SpenSettingPenLayout.CANVAS_WIDTH_VEINNA) {
                        seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(26.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(171.0f) * (progress / ((max - min) * 10.0f)));
                        if (SpenSettingPenLayout.this.mSettingInfo.name.equals(SpenPenManager.SPEN_PENCIL)) {
                            seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(26.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(169.5f) * (progress / ((max - min) * 10.0f)));
                        }
                        if (Math.round(10.0f * min) + progress >= 100) {
                            seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(24.0f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(168.0f) * (progress / ((max - min) * 10.0f)));
                        }
                        if (Math.round(10.0f * min) + progress >= 200) {
                            seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(23.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(169.5f) * (progress / ((max - min) * 10.0f)));
                        }
                    }
                    if (SpenSettingPenLayout.this.mCanvasSize == SpenSettingPenLayout.CANVAS_WIDTH_VEINNA && SpenSettingPenLayout.this.localDisplayMetrics.density == 2.0d) {
                        seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(26.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(173.5f) * (progress / ((max - min) * 10.0f)));
                        if (SpenSettingPenLayout.this.mSettingInfo.name.equals(SpenPenManager.SPEN_PENCIL)) {
                            seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(26.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(173.0f) * (progress / ((max - min) * 10.0f)));
                        }
                        if (Math.round(10.0f * min) + progress >= 100) {
                            seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(24.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(170.5f) * (progress / ((max - min) * 10.0f)));
                        }
                        if (Math.round(10.0f * min) + progress >= 200) {
                            seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(25.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(171.0f) * (progress / ((max - min) * 10.0f)));
                        }
                    }
                    SpenSettingPenLayout.this.mPenSizeSeekbar.setContentDescription(String.valueOf(SpenSettingPenLayout.this.mPenSizeTextView.getText().toString()) + "\u0000");
                    SpenSettingPenLayout.this.mPenSizeTextView.setX(seek_label_pos);
                    SpenSettingPenLayout.this.mPenSizeTextView.setY(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(5.0f));
                    if (SpenSettingPenLayout.this.mCanvasView != null) {
                        if (SpenSettingPenLayout.this.mCanvasView.getCanvasWidth() < SpenSettingPenLayout.this.mCanvasView.getCanvasHeight()) {
                            SpenSettingPenLayout.this.mCanvasSize = SpenSettingPenLayout.this.mCanvasView.getCanvasWidth();
                        } else {
                            SpenSettingPenLayout.this.mCanvasSize = SpenSettingPenLayout.this.mCanvasView.getCanvasHeight();
                        }
                        if (SpenSettingPenLayout.this.mCanvasSize == 0) {
                            SpenSettingPenLayout.this.mCanvasSize = 1080;
                        }
                    } else {
                        SpenSettingPenLayout.this.mCanvasSize = 1080;
                    }
                    SpenSettingPenLayout.this.mSettingInfo.size = (((progress / 10.0f) + min) * SpenSettingPenLayout.this.mCanvasSize) / 360.0f;
                    SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().setSize(SpenSettingPenLayout.this.mSettingInfo.size);
                    SpenSettingPenLayout.this.mPenPreview.setStrokeSize(SpenSettingPenLayout.this.mSettingInfo.size);
                    SpenSettingPenLayout.this.mPenPreview.invalidate();
                    if (SpenSettingPenLayout.this.mCanvasView != null && (info = SpenSettingPenLayout.this.mCanvasView.getPenSettingInfo()) != null) {
                        info.size = SpenSettingPenLayout.this.mSettingInfo.size;
                        SpenSettingPenLayout.this.mCanvasView.setPenSettingInfo(info);
                    }
                    if (SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() == SpenSettingPenLayout.this.mPenSizeSeekbar.getMax()) {
                        SpenSettingPenLayout.this.mPenSizePlusButton.setSelected(false);
                        SpenSettingPenLayout.this.mPenSizePlusButton.setEnabled(false);
                        if (SpenSettingPenLayout.this.mPenSizeAutoIncrement) {
                            SpenSettingPenLayout.this.mPenSizeAutoIncrement = false;
                        }
                    } else {
                        SpenSettingPenLayout.this.mPenSizePlusButton.setEnabled(true);
                    }
                    if (SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() == 0) {
                        SpenSettingPenLayout.this.mPenSizeMinusButton.setSelected(false);
                        SpenSettingPenLayout.this.mPenSizeMinusButton.setEnabled(false);
                        if (SpenSettingPenLayout.this.mPenSizeAutoDecrement) {
                            SpenSettingPenLayout.this.mPenSizeAutoDecrement = false;
                            return;
                        }
                        return;
                    }
                    SpenSettingPenLayout.this.mPenSizeMinusButton.setEnabled(true);
                }
            }
        };
        this.mPenSizePlusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.7
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingPenLayout.this.mPenSizeAutoIncrement = true;
                SpenSettingPenLayout.this.mPenSizePlusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mPenTypeTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) throws NumberFormatException {
                if (event.getAction() == 1) {
                    if (!SpenSettingPenLayout.this.isPresetClicked) {
                        float x = event.getX();
                        float y = event.getY();
                        int index = Math.round((x - ((SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(50.0f) / SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(69.0f)) * (SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(69.0f) - y))) / SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(44.0f));
                        if (index < 0) {
                            index = 0;
                        } else if (index > SpenSettingPenLayout.this.mPenTypeView.size() - 1) {
                            index = SpenSettingPenLayout.this.mPenTypeView.size() - 1;
                        }
                        if (index < SpenSettingPenLayout.this.mNumberOfPenExist) {
                            View v1 = SpenSettingPenLayout.this.localPenTypeViewGroup.getChildAt(index);
                            for (int i = 0; i < SpenSettingPenLayout.this.mPenTypeView.size(); i++) {
                                if (v1 == SpenSettingPenLayout.this.mPenTypeView.get(i)) {
                                    SpenSettingPenLayout.this.penSelectIndex(i);
                                }
                            }
                            SpenSettingPenLayout.this.playSoundEffect(0);
                            SpenSettingPenLayout.this.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                } else {
                    SpenSettingPenLayout.this.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
        };
        this.mPenTypeKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.9
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (view.isFocused() && event.getAction() == 1) {
                            view.clearFocus();
                            view.performClick();
                            break;
                        }
                        break;
                }
                return false;
            }
        };
        this.mPenTypeHoverListener = new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.10
            private int preIndex = 0;

            @Override // android.view.View.OnHoverListener
            public boolean onHover(View v, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();
                int index = Math.round((x - ((SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(50.0f) / SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(69.0f)) * (SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(69.0f) - y))) / SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(44.0f));
                if (index < 0) {
                    index = 0;
                } else if (index > SpenSettingPenLayout.this.mPenTypeView.size() - 1) {
                    index = SpenSettingPenLayout.this.mPenTypeView.size() - 1;
                }
                if (this.preIndex < 0) {
                    this.preIndex = 0;
                } else if (this.preIndex > SpenSettingPenLayout.this.mPenTypeView.size() - 1) {
                    this.preIndex = SpenSettingPenLayout.this.mPenTypeView.size() - 1;
                }
                if (event.getAction() == 10) {
                    event.setAction(10);
                    SpenSettingPenLayout.this.mPenTypeView.get(this.preIndex).dispatchGenericMotionEvent(event);
                    event.setAction(9);
                    SpenSettingPenLayout.this.mPenTypeView.get(index).sendAccessibilityEvent(128);
                } else {
                    if (index != this.preIndex) {
                        event.setAction(10);
                        SpenSettingPenLayout.this.mPenTypeView.get(this.preIndex).dispatchGenericMotionEvent(event);
                        event.setAction(9);
                        SpenSettingPenLayout.this.mPenTypeView.get(index).sendAccessibilityEvent(128);
                    }
                    SpenSettingPenLayout.this.mPenTypeView.get(index).dispatchGenericMotionEvent(event);
                    this.preIndex = index;
                }
                return true;
            }
        };
        this.mPenSizePlusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mPenSizeAutoIncrement) {
                    SpenSettingPenLayout.this.mPenSizePlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mPenSizeAutoIncrement = false;
                }
                return false;
            }
        };
        this.mPenSizePlusButtonKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.12
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (SpenSettingPenLayout.this.mPenSizePlusButton.isSelected() && event.getAction() == 1) {
                            SpenSettingPenLayout.this.mPenSizePlusButton.setSelected(false);
                            SpenSettingPenLayout.this.mPenSizeAutoIncrement = false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        };
        this.mPenSizeMinusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingPenLayout.this.mPenSizeAutoDecrement = true;
                SpenSettingPenLayout.this.mPenSizeMinusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mPenSizeMinusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mPenSizeAutoDecrement) {
                    SpenSettingPenLayout.this.mPenSizeMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mPenSizeAutoDecrement = false;
                }
                return false;
            }
        };
        this.mPenSizeMinusButtonKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.15
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (SpenSettingPenLayout.this.mPenSizeMinusButton.isSelected() && event.getAction() == 1) {
                            SpenSettingPenLayout.this.mPenSizeMinusButton.setSelected(false);
                            SpenSettingPenLayout.this.mPenSizeAutoDecrement = false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        };
        this.mPenAlphaPlusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.16
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingPenLayout.this.mPenAlphaAutoIncrement = true;
                SpenSettingPenLayout.this.mOpacityPlusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mPenAlphaPlusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mPenAlphaAutoIncrement) {
                    SpenSettingPenLayout.this.mOpacityPlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mPenAlphaAutoIncrement = false;
                }
                return false;
            }
        };
        this.mPenAlphaPlusButtonKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.18
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (SpenSettingPenLayout.this.mOpacityPlusButton.isSelected() && event.getAction() == 1) {
                            SpenSettingPenLayout.this.mOpacityPlusButton.setSelected(false);
                            SpenSettingPenLayout.this.mPenAlphaAutoIncrement = false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        };
        this.mPenAlphaMinusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.19
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingPenLayout.this.mPenAlphaAutoDecrement = true;
                SpenSettingPenLayout.this.mOpacityMinusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mPenAlphaMinusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.20
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mPenAlphaAutoDecrement) {
                    SpenSettingPenLayout.this.mOpacityMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mPenAlphaAutoDecrement = false;
                }
                return false;
            }
        };
        this.mPenAlphaMinusButtonKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.21
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (SpenSettingPenLayout.this.mOpacityMinusButton.isSelected() && event.getAction() == 1) {
                            SpenSettingPenLayout.this.mOpacityMinusButton.setSelected(false);
                            SpenSettingPenLayout.this.mPenAlphaAutoDecrement = false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        };
        this.mPenSizePlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() != SpenSettingPenLayout.this.mPenSizeSeekbar.getMax()) {
                    SpenSettingPenLayout.this.mPenSizeSeekbar.incrementProgressBy(1);
                    float min = SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().getMinSettingValue();
                    if (SpenSettingPenLayout.this.mCanvasView != null) {
                        if (SpenSettingPenLayout.this.mCanvasView.getCanvasWidth() < SpenSettingPenLayout.this.mCanvasView.getCanvasHeight()) {
                            SpenSettingPenLayout.this.mCanvasSize = SpenSettingPenLayout.this.mCanvasView.getCanvasWidth();
                        } else {
                            SpenSettingPenLayout.this.mCanvasSize = SpenSettingPenLayout.this.mCanvasView.getCanvasHeight();
                        }
                        if (SpenSettingPenLayout.this.mCanvasSize == 0) {
                            SpenSettingPenLayout.this.mCanvasSize = 1080;
                        }
                    } else {
                        SpenSettingPenLayout.this.mCanvasSize = 1080;
                    }
                    SpenSettingPenLayout.this.mSettingInfo.size = (((SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() / 10.0f) + min) * SpenSettingPenLayout.this.mCanvasSize) / 360.0f;
                    SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().setSize(SpenSettingPenLayout.this.mSettingInfo.size);
                }
            }
        };
        this.mPenSizeMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() != 0) {
                    if (SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() > 0) {
                        SpenSettingPenLayout.this.mPenSizeSeekbar.incrementProgressBy(-1);
                    }
                    float min = SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().getMinSettingValue();
                    if (SpenSettingPenLayout.this.mCanvasView != null) {
                        if (SpenSettingPenLayout.this.mCanvasView.getCanvasWidth() < SpenSettingPenLayout.this.mCanvasView.getCanvasHeight()) {
                            SpenSettingPenLayout.this.mCanvasSize = SpenSettingPenLayout.this.mCanvasView.getCanvasWidth();
                        } else {
                            SpenSettingPenLayout.this.mCanvasSize = SpenSettingPenLayout.this.mCanvasView.getCanvasHeight();
                        }
                        if (SpenSettingPenLayout.this.mCanvasSize == 0) {
                            SpenSettingPenLayout.this.mCanvasSize = 1080;
                        }
                    } else {
                        SpenSettingPenLayout.this.mCanvasSize = 1080;
                    }
                    SpenSettingPenLayout.this.mSettingInfo.size = (((SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() / 10.0f) + min) * SpenSettingPenLayout.this.mCanvasSize) / 360.0f;
                    if (SpenSettingPenLayout.this.mSettingInfo.size >= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                        SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().setSize(SpenSettingPenLayout.this.mSettingInfo.size);
                    } else {
                        SpenSettingPenLayout.this.mSettingInfo.size = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                    }
                }
            }
        };
        this.mPenAlphaPlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mPenAlphaSeekbar.incrementProgressBy(1);
            }
        };
        this.mPenAlphaMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mPenAlphaSeekbar.incrementProgressBy(-1);
            }
        };
        this.mPaletteNextButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int index = SpenSettingPenLayout.this.colorPaletteView.getCurrentTableIndex();
                if (index == 3) {
                    SpenSettingPenLayout.this.mPaletteLeftButton.setEnabled(true);
                }
                SpenSettingPenLayout.this.colorPaletteView.setNextColorTable(index);
                SpenSettingPenLayout.this.mColorPaletteView.setSelectBoxPos(SpenSettingPenLayout.this.mSettingInfo.color);
                if (SpenSettingPenLayout.this.colorPaletteView.getCurrentTableIndex() == 2) {
                    SpenSettingPenLayout.this.mPaletteRightButton.setEnabled(false);
                }
            }
        };
        this.mPaletteBackButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int index = SpenSettingPenLayout.this.colorPaletteView.getCurrentTableIndex();
                if (index == 2) {
                    SpenSettingPenLayout.this.mPaletteRightButton.setEnabled(true);
                }
                SpenSettingPenLayout.this.colorPaletteView.setBackColorTable(index);
                SpenSettingPenLayout.this.mColorPaletteView.setSelectBoxPos(SpenSettingPenLayout.this.mSettingInfo.color);
                if (SpenSettingPenLayout.this.colorPaletteView.getCurrentTableIndex() == 3) {
                    SpenSettingPenLayout.this.mPaletteLeftButton.setEnabled(false);
                }
            }
        };
        this.mPenTypeListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws NumberFormatException {
                for (int i = 0; i < SpenSettingPenLayout.this.mPenTypeView.size(); i++) {
                    if (v == SpenSettingPenLayout.this.mPenTypeView.get(i)) {
                        SpenSettingPenLayout.this.penSelectIndex(i);
                        return;
                    }
                }
            }
        };
        this.mColorPickerCurrentColorListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.29
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenInfo info;
                if (SpenSettingPenLayout.this.mCanvasView != null && (info = SpenSettingPenLayout.this.mCanvasView.getPenSettingInfo()) != null) {
                    SpenSettingPenLayout.this.mSettingInfo.color = info.color;
                    SpenSettingPenLayout.this.mPenPreview.setStrokeColor(info.color);
                    SpenSettingPenLayout.this.mPenPreview.invalidate();
                    SpenSettingPenLayout.this.mCanvasView.setPenSettingInfo(info);
                }
                SpenSettingPenLayout.this.mColorPaletteView.setColor(SpenSettingPenLayout.this.mSettingInfo.color);
                SpenSettingPenLayout.this.mColorPaletteView.invalidate();
                if (SpenSettingPenLayout.this.mCanvasView != null) {
                    SpenSettingPenLayout.this.mCanvasView.setToolTypeAction(2, SpenSettingPenLayout.this.mPreCanvasPenAction);
                    SpenSettingPenLayout.this.mCanvasView.setToolTypeAction(1, SpenSettingPenLayout.this.mPreCanvasFingerAction);
                    SpenSettingPenLayout.this.mCanvasView.setToolTypeAction(3, SpenSettingPenLayout.this.mPreCanvasMouseAction);
                }
                SpenSettingPenLayout.this.mColorPickerSetting.hide();
                SpenSettingPenLayout.this.setVisibility(0);
            }
        };
        this.mExitButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.30
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenInfo info;
                try {
                    if (SpenSettingPenLayout.this.mColorPickerSetting.getColorPickerSettingVisible() == 0) {
                        if (SpenSettingPenLayout.this.mCanvasView != null) {
                            SpenSettingPenLayout.this.mCanvasView.setToolTypeAction(2, SpenSettingPenLayout.this.mPreCanvasPenAction);
                            SpenSettingPenLayout.this.mCanvasView.setToolTypeAction(1, SpenSettingPenLayout.this.mPreCanvasFingerAction);
                            SpenSettingPenLayout.this.mCanvasView.setToolTypeAction(3, SpenSettingPenLayout.this.mPreCanvasMouseAction);
                        }
                        if (SpenSettingPenLayout.this.mColorPickerSetting.getColorPickerCurrentColor() != 0) {
                            SpenSettingPenLayout.this.mPenPreview.setStrokeColor(SpenSettingPenLayout.this.mColorPickerSetting.getColorPickerCurrentColor());
                            SpenSettingPenLayout.this.mPenPreview.invalidate();
                            SpenSettingPenLayout.this.mSettingInfo.color = SpenSettingPenLayout.this.mColorPickerSetting.getColorPickerCurrentColor();
                            if (SpenSettingPenLayout.this.mCanvasView != null && (info = SpenSettingPenLayout.this.mCanvasView.getPenSettingInfo()) != null) {
                                info.color = SpenSettingPenLayout.this.mColorPickerSetting.getColorPickerCurrentColor();
                                SpenSettingPenLayout.this.mCanvasView.setPenSettingInfo(info);
                            }
                            SpenSettingPenLayout.this.mColorPaletteView.setColorPickerColor(SpenSettingPenLayout.this.mColorPickerSetting.getColorPickerCurrentColor());
                            SpenSettingPenLayout.this.mColorPaletteView.invalidate();
                        }
                        SpenSettingPenLayout.this.mColorPickerSetting.hide();
                    }
                    if (SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject() != null && SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().getPenAttribute(4)) {
                        SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().hideAdvancedSetting();
                        SpenSettingPenLayout.this.mAdvancedSettingShow = false;
                    }
                    SpenSettingPenLayout.this.setVisibility(8);
                } catch (NullPointerException e) {
                }
            }
        };
        this.mOnConsumedTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.31
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpenSettingPenLayout.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mOnConsumedHoverListener = new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.32
            @Override // android.view.View.OnHoverListener
            public boolean onHover(View v, MotionEvent event) {
                return true;
            }
        };
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.33
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (SpenSettingPenLayout.this.mGestureDetector != null && SpenSettingPenLayout.this.mGestureDetector.onTouchEvent(event)) {
                    SpenSettingPenLayout.this.requestDisallowInterceptTouchEvent(true);
                } else {
                    int x = Math.round(event.getRawX());
                    int y = Math.round(event.getRawY());
                    switch (event.getAction()) {
                        case 1:
                            if (SpenSettingPenLayout.this.mMoveSettingLayout && SpenSettingPenLayout.this.mActionListener != null) {
                                SpenSettingPenLayout.this.mActionListener.onMoved();
                                break;
                            }
                            break;
                        case 2:
                            if (SpenSettingPenLayout.this.mMoveSettingLayout) {
                                int mMoveX = x - SpenSettingPenLayout.this.mXDelta;
                                int mMoveY = y - SpenSettingPenLayout.this.mYDelta;
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                if (mMoveX > (SpenSettingPenLayout.this.mCanvasLayout.getWidth() - SpenSettingPenLayout.this.getWidth()) - 2) {
                                    mMoveX = (SpenSettingPenLayout.this.mCanvasLayout.getWidth() - SpenSettingPenLayout.this.getWidth()) - 2;
                                }
                                int minHeight = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(163.0f);
                                int height = SpenSettingPenLayout.this.getHeight();
                                Log.e(SpenSettingPenLayout.TAG, "height = " + height);
                                Log.i(SpenSettingPenLayout.TAG, "before mMoveY = " + mMoveY);
                                if (height <= minHeight && mMoveY > SpenSettingPenLayout.this.mMovableRect.height() - minHeight) {
                                    mMoveY = SpenSettingPenLayout.this.mMovableRect.height() - minHeight;
                                } else if (mMoveY > SpenSettingPenLayout.this.mMovableRect.height() - height) {
                                    SpenSettingPenLayout.this.setExpandBarPosition((SpenSettingPenLayout.this.mMovableRect.height() - mMoveY) - SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(57.0f));
                                    if (mMoveY > SpenSettingPenLayout.this.mMovableRect.height() - minHeight) {
                                        mMoveY = SpenSettingPenLayout.this.mMovableRect.height() - minHeight;
                                    }
                                }
                                Log.w(SpenSettingPenLayout.TAG, "after mMoveY = " + mMoveY);
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) SpenSettingPenLayout.this.getLayoutParams();
                                params.leftMargin = mMoveX;
                                params.topMargin = mMoveY;
                                SpenSettingPenLayout.this.mCurrentTopMargin = params.topMargin;
                                SpenSettingPenLayout.this.setLayoutParams(params);
                                break;
                            }
                            break;
                    }
                    SpenSettingPenLayout.this.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
        };
        this.mAdvancedSettingButtonListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.34
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject() != null) {
                    if (!SpenSettingPenLayout.this.mAdvancedSettingShow) {
                        SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().showAdvancedSetting(SpenSettingPenLayout.this.mContext, SpenSettingPenLayout.this.mAdvancedSettingListener, (ViewGroup) SpenSettingPenLayout.this.getParent());
                    } else {
                        SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().hideAdvancedSetting();
                    }
                    SpenSettingPenLayout.this.mAdvancedSettingShow = !SpenSettingPenLayout.this.mAdvancedSettingShow;
                }
            }
        };
        this.mPreSetAddButtonListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.35
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws Resources.NotFoundException, NumberFormatException {
                try {
                    if (SpenSettingPenLayout.mPresetInfoList == null) {
                        SpenSettingPenLayout.mPresetInfoList = new ArrayList();
                    }
                    if (SpenSettingPenLayout.mPresetInfoList.size() >= 36) {
                        String strPreset = SpenSettingPenLayout.this.mStringUtil.setString("string_reached_maximum_preset");
                        if (strPreset != null) {
                            CharSequence text = String.format(strPreset, 36);
                            Toast toast = Toast.makeText(SpenSettingPenLayout.this.mContext, text, 0);
                            toast.show();
                            return;
                        }
                        return;
                    }
                    for (SpenPenPresetInfo info : SpenSettingPenLayout.mPresetInfoList) {
                        if ((info.getPenName().equals(SpenSettingPenLayout.this.mSettingInfo.name) && info.getPenSize() == SpenSettingPenLayout.this.mSettingInfo.size && info.getColor() == SpenSettingPenLayout.this.mSettingInfo.color && info.getAdvancedSetting().equals(SpenSettingPenLayout.this.mSettingInfo.advancedSetting)) || (SpenSettingPenLayout.this.mSettingInfo.name.equals(SpenSettingPenLayout.BEAUTIFY_PEN_NAME) && info.getPenSize() == SpenSettingPenLayout.this.mSettingInfo.size && info.getAdvancedSetting().equals(SpenSettingPenLayout.this.mSettingInfo.advancedSetting) && SpenSettingPenLayout.this.mCurrentBeautifyStyle == 5)) {
                            CharSequence text2 = SpenSettingPenLayout.this.mStringUtil.setString("string_already_exists");
                            Toast toast2 = Toast.makeText(SpenSettingPenLayout.this.mContext, text2, 0);
                            toast2.show();
                            return;
                        }
                    }
                    SpenSettingPenLayout.this.setButtonFocus(SpenSettingPenLayout.this.mPresetButton);
                    SpenSettingPenLayout.mIsSwichTab = true;
                    if (SpenSettingPenLayout.this.mViewMode != 8) {
                        SpenSettingPenLayout.this.mPenButton.setSelected(false);
                        SpenSettingPenLayout.this.mPresetButton.setSelected(true);
                        SpenSettingPenLayout.this.drawExpendImage(SpenSettingPenLayout.this.mSettingInfo.name);
                        SpenSettingPenLayout.this.setExpandBarPosition(SpenSettingPenLayout.this.mBodyLayoutHeight);
                        SpenSettingPenLayout.this.mPreviewLayout.setVisibility(8);
                        SpenSettingPenLayout.this.mPenTypeLayout.setVisibility(8);
                        SpenSettingPenLayout.this.mPenSeekbarLayout.setVisibility(8);
                        SpenSettingPenLayout.this.mColorSelectPickerLayout.setVisibility(8);
                        SpenSettingPenLayout.this.mColorPaletteView.setVisibility(8);
                        SpenSettingPenLayout.this.showBeautifyEnableLayout(false);
                        SpenSettingPenLayout.this.showBeautifyStyleBtnsLayout(false);
                        SpenSettingPenLayout.this.mBottomLayout.setVisibility(0);
                        SpenSettingPenLayout.this.mPresetLayout.setVisibility(0);
                    }
                    SpenPenPresetInfo presetInfoItem = new SpenPenPresetInfo();
                    presetInfoItem.setPenName(SpenSettingPenLayout.this.mSettingInfo.name);
                    presetInfoItem.setBitmapSize(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(65.0f), SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(65.0f));
                    presetInfoItem.setPenSize(SpenSettingPenLayout.this.mSettingInfo.size);
                    presetInfoItem.setColor(SpenSettingPenLayout.this.mSettingInfo.color);
                    presetInfoItem.setAdvancedSetting(SpenSettingPenLayout.this.mSettingInfo.advancedSetting);
                    presetInfoItem.setPresetImageName(SpenSettingPenLayout.this.mPresetListAdapter.getPresetImage(SpenSettingPenLayout.this.mSettingInfo.name));
                    SpenSettingPenLayout.mPresetInfoList.add(presetInfoItem);
                    SpenPenPresetListAdapter.mList.add(presetInfoItem);
                    SpenSettingPenLayout.this.mPresetListAdapter.mCurrentSeleted = SpenSettingPenLayout.mPresetInfoList.size() - 1;
                    SpenSettingPenLayout.this.mPreviousSelectedPresetIndex = SpenSettingPenLayout.mPresetInfoList.size() - 1;
                    SpenSettingPenLayout.this.mPresetListAdapter.notifyDataSetChanged();
                    SpenSettingPenLayout.this.presetDisplay();
                    if (SpenSettingPenLayout.this.mPresetListener != null) {
                        SpenSettingPenLayout.this.mPresetListener.onAdded(SpenSettingPenLayout.this.mSettingInfo);
                    }
                    SpenSettingPenLayout.this.mPresetGridView.smoothScrollToPosition(SpenSettingPenLayout.mPresetInfoList.size() - 1);
                } catch (NullPointerException e) {
                }
            }
        };
        this.mTabSelectListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.36
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws NumberFormatException {
                try {
                    if (SpenSettingPenLayout.this.mViewMode != 5 && SpenSettingPenLayout.this.mViewMode != 6 && SpenSettingPenLayout.this.mViewMode != 7) {
                        SpenSettingPenLayout.this.requestLayoutDisable = false;
                        if (v.equals(SpenSettingPenLayout.this.mPenButton)) {
                            SpenSettingPenLayout.this.mPenButton.setContentDescription(String.valueOf(SpenSettingPenLayout.this.mStringUtil.setString("string_pen_tab")) + SpenSettingPenLayout.this.mStringUtil.setString("string_selected"));
                            SpenSettingPenLayout.this.mPresetButton.setContentDescription(String.valueOf(SpenSettingPenLayout.this.mStringUtil.setString("string_preset_tab")) + SpenSettingPenLayout.this.mStringUtil.setString("string_not_selected"));
                            SpenSettingPenLayout.this.isPresetClicked = false;
                            SpenSettingPenLayout.this.mPenButton.setSelected(true);
                            SpenSettingPenLayout.this.mPresetButton.setSelected(false);
                            SpenSettingPenLayout.this.drawExpendImage(SpenSettingPenLayout.this.mSettingInfo.name);
                            SpenSettingPenLayout.this.setExpandBarPosition(SpenSettingPenLayout.this.mBodyLayoutHeight);
                            SpenSettingPenLayout.this.mPreviewLayout.setVisibility(0);
                            SpenSettingPenLayout.this.mPenTypeLayout.setVisibility(0);
                            SpenSettingPenLayout.this.mPenSeekbarLayout.setVisibility(0);
                            SpenSettingPenLayout.this.mColorSelectPickerLayout.setVisibility(0);
                            SpenSettingPenLayout.this.mColorPaletteView.setVisibility(0);
                            SpenSettingPenLayout.this.mBottomLayout.setVisibility(0);
                            SpenSettingPenLayout.this.setColorSelectorViewForBeautifyPen();
                            SpenSettingPenLayout.this.mImageLoader.addViewBackgroundSelectableImageLoad(SpenSettingPenLayout.this.mBottomExtendBg, SpenSettingPenLayout.bottomExpandPath, SpenSettingPenLayout.bottomExpandPressPath, SpenSettingPenLayout.bottomExpandPressPath);
                            if (SpenSettingPenLayout.mSdkVersion < 16) {
                                SpenSettingPenLayout.this.mBottomExtendBg.setBackgroundDrawable(SpenSettingPenLayout.this.mDrawableImg.setDrawableSelectImg(SpenSettingPenLayout.bottomExpandPath, SpenSettingPenLayout.bottomExpandPressPath, SpenSettingPenLayout.bottomExpandPressPath));
                            } else {
                                SpenSettingPenLayout.this.mBottomExtendBg.setBackground(SpenSettingPenLayout.this.mDrawableImg.setDrawableSelectImg(SpenSettingPenLayout.bottomExpandPath, SpenSettingPenLayout.bottomExpandPressPath, SpenSettingPenLayout.bottomExpandPressPath));
                            }
                            SpenSettingPenLayout.this.mBottomExtendBg.invalidate();
                            if (SpenSettingPenLayout.this.isBeautifyPen(SpenSettingPenLayout.this.mSettingInfo.name)) {
                                SpenSettingPenLayout.this.showBeautifyEnableLayout(true);
                                SpenSettingPenLayout.this.showBeautifyStyleBtnsLayout(true);
                            } else if (SpenSettingPenLayout.this.isChinesePen(SpenSettingPenLayout.this.mSettingInfo.name)) {
                                SpenSettingPenLayout.this.showBeautifyEnableLayout(true);
                            } else {
                                SpenSettingPenLayout.this.showBeautifyEnableLayout(false);
                                SpenSettingPenLayout.this.showBeautifySettingViews(false);
                            }
                            SpenSettingPenLayout.this.mPresetLayout.setVisibility(8);
                            if (SpenSettingPenLayout.this.isMagicPenEnable) {
                                SpenSettingPenLayout.this.setMagicPenMode(SpenSettingPenLayout.this.currenMagicPenHeight);
                            }
                        } else if (v.equals(SpenSettingPenLayout.this.mPresetButton)) {
                            SpenSettingPenLayout.mIsSwichTab = true;
                            SpenSettingPenLayout.this.mPenButton.setContentDescription(String.valueOf(SpenSettingPenLayout.this.mStringUtil.setString("string_pen_tab")) + SpenSettingPenLayout.this.mStringUtil.setString("string_not_selected"));
                            SpenSettingPenLayout.this.mPresetButton.setContentDescription(String.valueOf(SpenSettingPenLayout.this.mStringUtil.setString("string_preset_tab")) + SpenSettingPenLayout.this.mStringUtil.setString("string_selected"));
                            SpenSettingPenLayout.this.isPresetClicked = true;
                            SpenSettingPenLayout.this.mPenButton.setSelected(false);
                            SpenSettingPenLayout.this.mPresetButton.setSelected(true);
                            SpenSettingPenLayout.this.drawExpendImage(SpenSettingPenLayout.this.mSettingInfo.name);
                            SpenSettingPenLayout.this.setExpandBarPosition(SpenSettingPenLayout.this.mBodyLayoutHeight);
                            SpenSettingPenLayout.this.mPreviewLayout.setVisibility(8);
                            SpenSettingPenLayout.this.mPenTypeLayout.setVisibility(8);
                            SpenSettingPenLayout.this.mPenSeekbarLayout.setVisibility(8);
                            SpenSettingPenLayout.this.mColorSelectPickerLayout.setVisibility(8);
                            SpenSettingPenLayout.this.mColorPaletteView.setVisibility(8);
                            SpenSettingPenLayout.this.showBeautifyEnableLayout(false);
                            SpenSettingPenLayout.this.showBeautifyStyleBtnsLayout(false);
                            SpenSettingPenLayout.this.mBottomLayout.setVisibility(0);
                            SpenSettingPenLayout.this.mImageLoader.addViewBackgroundSelectableImageLoad(SpenSettingPenLayout.this.mBottomExtendBg, SpenSettingPenLayout.bottomExpandPresetPath, SpenSettingPenLayout.bottomExpandPresetPressPath, SpenSettingPenLayout.bottomExpandPresetPressPath);
                            if (SpenSettingPenLayout.mSdkVersion < 16) {
                                SpenSettingPenLayout.this.mBottomExtendBg.setBackgroundDrawable(SpenSettingPenLayout.this.mDrawableImg.setDrawableSelectImg(SpenSettingPenLayout.bottomExpandPresetPath, SpenSettingPenLayout.bottomExpandPresetPressPath, SpenSettingPenLayout.bottomExpandPresetPressPath));
                            } else {
                                SpenSettingPenLayout.this.mBottomExtendBg.setBackground(SpenSettingPenLayout.this.mDrawableImg.setDrawableSelectImg(SpenSettingPenLayout.bottomExpandPresetPath, SpenSettingPenLayout.bottomExpandPresetPressPath, SpenSettingPenLayout.bottomExpandPresetPressPath));
                            }
                            SpenSettingPenLayout.this.mBottomExtendBg.invalidate();
                            SpenSettingPenLayout.this.mPresetListAdapter.mCurrentSeleted = -1;
                            if (SpenSettingPenLayout.mPresetInfoList == null) {
                                SpenSettingPenLayout.mPresetInfoList = new ArrayList();
                            }
                            Iterator<SpenPenPresetInfo> it = SpenSettingPenLayout.mPresetInfoList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                SpenPenPresetInfo info = it.next();
                                if (info.getPenName().equals(SpenSettingPenLayout.this.mSettingInfo.name) && info.getPenSize() == SpenSettingPenLayout.this.mSettingInfo.size && info.getColor() == SpenSettingPenLayout.this.mSettingInfo.color && info.getAdvancedSetting().equals(SpenSettingPenLayout.this.mSettingInfo.advancedSetting)) {
                                    SpenSettingPenLayout.this.mPreviousSelectedPresetIndex = SpenSettingPenLayout.mPresetInfoList.indexOf(info);
                                    SpenSettingPenLayout.this.mPresetListAdapter.mCurrentSeleted = SpenSettingPenLayout.this.mPreviousSelectedPresetIndex;
                                    SpenSettingPenLayout.this.mPresetGridView.smoothScrollToPosition(SpenSettingPenLayout.this.mPreviousSelectedPresetIndex);
                                    break;
                                }
                            }
                            SpenSettingPenLayout.this.mPresetListAdapter.notifyDataSetChanged();
                            SpenSettingPenLayout.this.presetDisplay();
                            SpenSettingPenLayout.this.mPresetLayout.setVisibility(0);
                        }
                        SpenSettingPenLayout.this.setButtonFocus(v);
                    }
                } catch (NullPointerException e) {
                }
            }
        };
        this.mExpendBarHoverListener = new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.37
            @Override // android.view.View.OnHoverListener
            public boolean onHover(View v, MotionEvent event) {
                return true;
            }
        };
        this.mExpendBarListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.38
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int x = Math.round(event.getRawX());
                int y = Math.round(event.getRawY());
                switch (event.getAction()) {
                    case 0:
                        RelativeLayout.LayoutParams bottomParams = (RelativeLayout.LayoutParams) SpenSettingPenLayout.this.mBottomLayout.getLayoutParams();
                        SpenSettingPenLayout.this.mXDelta = x - bottomParams.leftMargin;
                        SpenSettingPenLayout.this.mYDelta = y - bottomParams.topMargin;
                        SpenSettingPenLayout.this.mBottomExtendBg.setPressed(true);
                        break;
                    case 1:
                        if (SpenSettingPenLayout.this.mExpandFlag) {
                            if (SpenSettingPenLayout.this.mActionListener != null) {
                                SpenSettingPenLayout.this.mActionListener.onResized();
                            }
                            SpenSettingPenLayout.this.mExpandFlag = false;
                        }
                        SpenSettingPenLayout.this.mBottomExtendBg.setPressed(false);
                        break;
                    case 2:
                        SpenSettingPenLayout.this.mExpandFlag = true;
                        if (y - SpenSettingPenLayout.this.mYDelta > 0) {
                            SpenSettingPenLayout.this.setExpandBarPosition(y - SpenSettingPenLayout.this.mYDelta);
                            break;
                        }
                        break;
                    case 3:
                        SpenSettingPenLayout.this.mBottomExtendBg.setPressed(false);
                        break;
                }
                SpenSettingPenLayout.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mGestureListener = new GestureDetector.OnGestureListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.39
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent event) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent event) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent event, MotionEvent arg1, float arg2, float arg3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent event) {
                if (SpenSettingPenLayout.this.mNeedCalculateMargin) {
                    int[] location = new int[2];
                    SpenSettingPenLayout.this.mCanvasLayout.getLocationOnScreen(location);
                    SpenSettingPenLayout.this.mLeftMargin = Math.round((event.getRawX() - location[0]) - event.getX());
                    SpenSettingPenLayout.this.mTopMargin = Math.round((event.getRawY() - location[1]) - event.getY());
                    int[] rootLocation = new int[2];
                    SpenSettingPenLayout.this.getRootView().getLocationOnScreen(rootLocation);
                    SpenSettingPenLayout.this.mNeedCalculateMargin = false;
                }
                if (SpenSettingPenLayout.this.mFirstLongPress) {
                    SpenSettingPenLayout.this.mTitleLayout.performHapticFeedback(1);
                    SpenSettingPenLayout.this.mFirstLongPress = false;
                }
                Rect r = SpenSettingPenLayout.this.getMovableRect();
                SpenSettingPenLayout.this.mMovableRect.set(r);
                SpenSettingPenLayout.this.mMoveSettingLayout = true;
                SpenSettingPenLayout.this.mIndicator.setVisibility(8);
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent event, MotionEvent arg1, float arg2, float arg3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent event) {
                SpenSettingPenLayout.this.mMovableRect.set(SpenSettingPenLayout.this.getMovableRect());
                int x = Math.round(event.getRawX());
                int y = Math.round(event.getRawY());
                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) SpenSettingPenLayout.this.getLayoutParams();
                SpenSettingPenLayout.this.mXDelta = x - params.leftMargin;
                SpenSettingPenLayout.this.mYDelta = y - params.topMargin;
                return true;
            }
        };
        this.mBeautifyEnablecheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.40
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) throws NumberFormatException {
                if (SpenSettingPenLayout.this.mPenButton.isSelected()) {
                    SpenSettingPenLayout.this.showBeautifySettingViews(isChecked);
                }
                if (SpenSettingPenLayout.this.isChinesePen(SpenSettingPenLayout.this.mSettingInfo.name) || SpenSettingPenLayout.this.isBeautifyPen(SpenSettingPenLayout.this.mSettingInfo.name)) {
                    SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().setColor(SpenSettingPenLayout.this.mSettingInfo.color);
                    if (isChecked) {
                        SpenSettingPenLayout.this.mPenNameIndex = SpenSettingPenLayout.this.mPenPluginManager.getPenPluginIndexByPenName(SpenSettingPenLayout.BEAUTIFY_PEN_NAME);
                    } else {
                        SpenSettingPenLayout.this.mPenNameIndex = SpenSettingPenLayout.this.mPenPluginManager.getPenPluginIndexByPenName("com.samsung.android.sdk.pen.pen.preload.ChineseBrush");
                    }
                    SpenSettingPenLayout.this.mSettingInfo.name = SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenName();
                    SpenSettingPenLayout.this.updateBeautifySettingData();
                    SpenSettingPenLayout.this.beautifyUpdateSettingUI(isChecked);
                    SpenSettingPenLayout.this.drawExpendImage(SpenSettingPenLayout.this.mSettingInfo.name);
                }
            }
        };
        this.mBeautifyStyleBtnsListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.41
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingPenLayout.this.mBeautifyStyleBtnViews != null) {
                    int beautifyStyleIndex = 0;
                    Iterator<ImageButton> it = SpenSettingPenLayout.this.mBeautifyStyleBtnViews.iterator();
                    while (it.hasNext()) {
                        ImageButton styleBtn = it.next();
                        if (styleBtn.equals(v)) {
                            if (beautifyStyleIndex == SpenSettingPenLayout.this.mCurrentBeautifyStyle) {
                                break;
                            }
                            SpenSettingPenLayout.this.mCurrentBeautifyStyle = beautifyStyleIndex;
                            styleBtn.setSelected(true);
                        } else {
                            styleBtn.setSelected(false);
                        }
                        beautifyStyleIndex++;
                    }
                    SpenSettingPenLayout.this.resetBeautifyAdvanceDataAndUpdateSeekBarUi(SpenSettingPenLayout.this.mCurrentBeautifyStyle);
                }
            }
        };
        this.mBeautifyAdvanceCursiveChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.42
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String cursiveStr = String.valueOf(SpenSettingPenLayout.this.mStringUtil.setString("string_cursive")) + " " + progress;
                SpenSettingPenLayout.this.mBeautifyCursiveTextView.setText(cursiveStr);
                SpenSettingPenLayout.this.setBeautifyAdvancedDataToPlugin(2, progress);
                SpenSettingPenLayout.this.updateBeautifySettingData();
                SpenSettingPenLayout.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout.this.mSettingInfo.advancedSetting);
                SpenSettingPenLayout.this.mPenPreview.invalidate();
                if (SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.getProgress() == SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.getMax()) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursivePlusButton.setAlpha(0.2f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursivePlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursivePlusButton.setEnabled(false);
                    if (SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoIncrement) {
                        SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoIncrement = false;
                    }
                } else {
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursivePlusButton.setAlpha(1.0f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursivePlusButton.setEnabled(true);
                }
                if (SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.getProgress() == 0) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursiveMinusButton.setAlpha(0.2f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursiveMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursiveMinusButton.setEnabled(false);
                    if (SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoDecrement) {
                        SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoDecrement = false;
                        return;
                    }
                    return;
                }
                SpenSettingPenLayout.this.mBeautifyAdvanceCursiveMinusButton.setAlpha(1.0f);
                SpenSettingPenLayout.this.mBeautifyAdvanceCursiveMinusButton.setEnabled(true);
            }
        };
        this.mBeautifyAdvanceSustenanceChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.43
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String sustenanceStr = String.valueOf(SpenSettingPenLayout.this.mStringUtil.setString("string_sustenance")) + " " + progress;
                SpenSettingPenLayout.this.mBeautifySustenanceTextView.setText(sustenanceStr);
                SpenSettingPenLayout.this.setBeautifyAdvancedDataToPlugin(3, progress);
                SpenSettingPenLayout.this.updateBeautifySettingData();
                SpenSettingPenLayout.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout.this.mSettingInfo.advancedSetting);
                SpenSettingPenLayout.this.mPenPreview.invalidate();
                if (SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.getProgress() == SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.getMax()) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenancePlusButton.setAlpha(0.2f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenancePlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenancePlusButton.setEnabled(false);
                    if (SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoIncrement) {
                        SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoIncrement = false;
                    }
                } else {
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenancePlusButton.setAlpha(1.0f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenancePlusButton.setEnabled(true);
                }
                if (SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.getProgress() == 0) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceMinusButton.setAlpha(0.2f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceMinusButton.setEnabled(false);
                    if (SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoDecrement) {
                        SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoDecrement = false;
                        return;
                    }
                    return;
                }
                SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceMinusButton.setAlpha(1.0f);
                SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceMinusButton.setEnabled(true);
            }
        };
        this.mBeautifyAdvanceDummyChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.44
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String dummyStr = String.valueOf(SpenSettingPenLayout.this.mStringUtil.setString("string_dummy")) + " " + progress;
                SpenSettingPenLayout.this.mBeautifyDummyTextView.setText(dummyStr);
                SpenSettingPenLayout.this.setBeautifyAdvancedDataToPlugin(4, progress);
                SpenSettingPenLayout.this.updateBeautifySettingData();
                SpenSettingPenLayout.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout.this.mSettingInfo.advancedSetting);
                SpenSettingPenLayout.this.mPenPreview.invalidate();
                if (SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.getProgress() == SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.getMax()) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyPlusButton.setAlpha(0.2f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyPlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyPlusButton.setEnabled(false);
                    if (SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoIncrement) {
                        SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoIncrement = false;
                    }
                } else {
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyPlusButton.setAlpha(1.0f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyPlusButton.setEnabled(true);
                }
                if (SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.getProgress() == 0) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyMinusButton.setAlpha(0.2f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyMinusButton.setEnabled(false);
                    if (SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoDecrement) {
                        SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoDecrement = false;
                        return;
                    }
                    return;
                }
                SpenSettingPenLayout.this.mBeautifyAdvanceDummyMinusButton.setAlpha(1.0f);
                SpenSettingPenLayout.this.mBeautifyAdvanceDummyMinusButton.setEnabled(true);
            }
        };
        this.mBeautifyAdvanceModulationChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.45
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String modulationStr = String.valueOf(SpenSettingPenLayout.this.mStringUtil.setString("string_modulation")) + " " + progress;
                SpenSettingPenLayout.this.mBeautifyModulationTextView.setText(modulationStr);
                SpenSettingPenLayout.this.setBeautifyAdvancedDataToPlugin(6, progress);
                SpenSettingPenLayout.this.updateBeautifySettingData();
                SpenSettingPenLayout.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout.this.mSettingInfo.advancedSetting);
                SpenSettingPenLayout.this.mPenPreview.invalidate();
                if (SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.getProgress() == SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.getMax()) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationPlusButton.setAlpha(0.2f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationPlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationPlusButton.setEnabled(false);
                    if (SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoIncrement) {
                        SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoIncrement = false;
                    }
                } else {
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationPlusButton.setAlpha(1.0f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationPlusButton.setEnabled(true);
                }
                if (SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.getProgress() == 0) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationMinusButton.setAlpha(0.2f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationMinusButton.setEnabled(false);
                    if (SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoDecrement) {
                        SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoDecrement = false;
                        return;
                    }
                    return;
                }
                SpenSettingPenLayout.this.mBeautifyAdvanceModulationMinusButton.setAlpha(1.0f);
                SpenSettingPenLayout.this.mBeautifyAdvanceModulationMinusButton.setEnabled(true);
            }
        };
        this.mBeautifyAdvanceCursivePlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.46
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.incrementProgressBy(1);
            }
        };
        this.mBeautifyAdvanceCursiveMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.47
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.incrementProgressBy(-1);
            }
        };
        this.mBeautifyAdvanceSustenancePlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.48
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.incrementProgressBy(1);
            }
        };
        this.mBeautifyAdvanceSustenanceMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.49
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.incrementProgressBy(-1);
            }
        };
        this.mBeautifyAdvanceDummyPlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.50
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.incrementProgressBy(1);
            }
        };
        this.mBeautifyAdvanceDummyMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.51
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.incrementProgressBy(-1);
            }
        };
        this.mBeautifyAdvanceModulationPlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.52
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.incrementProgressBy(1);
            }
        };
        this.mBeautifyAdvanceModulationMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.53
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.incrementProgressBy(-1);
            }
        };
        this.mBeautifyAdvanceResetButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.54
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.resetBeautifyAdvanceDataAndUpdateSeekBarUi(SpenSettingPenLayout.this.mCurrentBeautifyStyle);
            }
        };
        this.mPenSizeKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.55
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingPenLayout.this.mPenSizeSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() != 0) {
                                SpenSettingPenLayout.this.mPenSizeSeekbar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingPenLayout.this.mPenSizeSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() != SpenSettingPenLayout.this.mPenSizeSeekbar.getMax()) {
                                SpenSettingPenLayout.this.mPenSizeSeekbar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.mPenAlphaKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.56
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingPenLayout.this.mPenAlphaSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mPenAlphaSeekbar.getProgress() != 0) {
                                SpenSettingPenLayout.this.mPenAlphaSeekbar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingPenLayout.this.mPenAlphaSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mPenAlphaSeekbar.getProgress() != SpenSettingPenLayout.this.mPenAlphaSeekbar.getMax()) {
                                SpenSettingPenLayout.this.mPenAlphaSeekbar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceCursivePlusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.57
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoIncrement = true;
                SpenSettingPenLayout.this.mBeautifyAdvanceCursivePlusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mBeautifyAdvanceSustenancePlusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.58
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoIncrement = true;
                SpenSettingPenLayout.this.mBeautifyAdvanceSustenancePlusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mBeautifyAdvanceDummyPlusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.59
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoIncrement = true;
                SpenSettingPenLayout.this.mBeautifyAdvanceDummyPlusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mBeautifyAdvanceModulationPlusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.60
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoIncrement = true;
                SpenSettingPenLayout.this.mBeautifyAdvanceModulationPlusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mBeautifyAdvanceCursiveMinusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.61
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoDecrement = true;
                SpenSettingPenLayout.this.mBeautifyAdvanceCursiveMinusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mBeautifyAdvanceSustenanceMinusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.62
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoDecrement = true;
                SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceMinusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mBeautifyAdvanceDummyMinusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.63
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoDecrement = true;
                SpenSettingPenLayout.this.mBeautifyAdvanceDummyMinusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mBeautifyAdvanceModulationMinusButtonlongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.64
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoDecrement = true;
                SpenSettingPenLayout.this.mBeautifyAdvanceModulationMinusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mBeautifyAdvanceCursivePlusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.65
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoIncrement) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursivePlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoIncrement = false;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceSustenancePlusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.66
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoIncrement) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenancePlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoIncrement = false;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceDummyPlusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.67
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoIncrement) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyPlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoIncrement = false;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceModulationPlusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.68
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoIncrement) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationPlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoIncrement = false;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceCursiveMinusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.69
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoDecrement) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursiveMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoDecrement = false;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceSustenanceMinusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.70
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoDecrement) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoDecrement = false;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceDummyMinusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.71
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoDecrement) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoDecrement = false;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceModulationMinusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.72
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoDecrement) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoDecrement = false;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceCursiveKeyListner = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.73
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.getProgress() != 0) {
                                SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.getProgress() != SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.getMax()) {
                                SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceSustenanceKeyListner = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.74
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.getProgress() != 0) {
                                SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.getProgress() != SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.getMax()) {
                                SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceDummyKeyListner = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.75
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.getProgress() != 0) {
                                SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.getProgress() != SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.getMax()) {
                                SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceModulationKeyListner = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.76
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.getProgress() != 0) {
                                SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.getProgress() != SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.getMax()) {
                                SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.horizontalScrollViewTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.77
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View arg0, MotionEvent arg1) {
                if (arg1.getAction() != 1 || SpenSettingPenLayout.this.mPenTypeHorizontalScrollView2.getScrollX() <= SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(44.0f)) {
                    return false;
                }
                SpenSettingPenLayout.this.playScrollAnimation(10, SpenSettingPenLayout.this.mPenTypeHorizontalScrollView2.getScrollX(), SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(44.0f));
                return false;
            }
        };
        this.deltaOfMiniMode = 0;
        this.isMinimumMode = false;
        this.deltaOfFirstTime = 52;
        this.isFirstTime = false;
        this.mNumberOfPenExist = 6;
        this.mHandler = new Handler();
        this.mCount = 0;
        this.mLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.78
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                try {
                    if (SpenSettingPenLayout.this.getVisibility() == 8) {
                        if (SpenSettingPenLayout.this.mIsRotated) {
                            SpenSettingPenLayout.this.mIsRotated = false;
                            return;
                        }
                        return;
                    }
                    if (!SpenSettingPenLayout.this.mIsRotated && SpenSettingPenLayout.this.mIsRotated2) {
                        SpenSettingPenLayout.this.mIsRotated2 = false;
                    }
                    SpenSettingPenLayout.this.mMovableRect.set(SpenSettingPenLayout.this.getMovableRect());
                    if (SpenSettingPenLayout.this.mIsRotated) {
                        SpenSettingPenLayout.this.rotatePosition();
                        SpenSettingPenLayout.this.mIsRotated = false;
                        SpenSettingPenLayout.this.mIsRotated2 = true;
                    } else {
                        SpenSettingPenLayout.this.checkPosition();
                    }
                    Handler handler = new Handler();
                    handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.78.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SpenSettingPenLayout.this.requestLayout();
                        }
                    });
                } catch (NullPointerException e) {
                }
            }
        };
        this.mScrollViewListner = new SpenScrollView.scrollChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.79
            @Override // com.samsung.android.sdk.pen.settingui.SpenScrollView.scrollChangedListener
            public void scrollChanged(int scrollY) {
                RelativeLayout.LayoutParams PaletteBgParam;
                SpenSettingPenLayout.this.mScrollY = scrollY;
                if (SpenSettingPenLayout.this.mPenAlphaSeekbarView.getVisibility() == 0) {
                    PaletteBgParam = new RelativeLayout.LayoutParams(-1, (SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(118.0f) - (SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(323.0f) - SpenSettingPenLayout.this.mBodyLayoutHeight)) + SpenSettingPenLayout.this.mScrollY);
                } else {
                    PaletteBgParam = new RelativeLayout.LayoutParams(-1, (SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(118.0f) - (SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(273.0f) - SpenSettingPenLayout.this.mBodyLayoutHeight)) + SpenSettingPenLayout.this.mScrollY);
                }
                PaletteBgParam.setMargins(0, 0, 0, 0);
                if (PaletteBgParam.height >= 0) {
                    SpenSettingPenLayout.this.mPaletteBg.setLayoutParams(PaletteBgParam);
                }
            }
        };
        this.mCurrentBeautifyAdvanceSettingValues = new int[][]{new int[]{11, 2, 5, 8, 1, 15, 70, 11, 0, 1}, new int[]{12, 2, 5, 1, 1, 18, 70, 13, 0, 1}, new int[]{5, 2, 2, 2, 1, 18, 70, 5, 0, 1}, new int[]{6, 2, 3, 3, 1, 12, 70, 6, 0, 1}, new int[]{1, 2, 2, 8, 1, 15, 70, 3, 0, 1}, new int[]{3, 1, 3, 5, 1, 12, 70, 1, 0, 1}};
        this.requestLayoutDisable = false;
        this.mEnablePresetSave = true;
        this.mBgTransparent = false;
        this.mDrawableImg = new SPenImageUtil(context, customImagePath, mScale);
        this.mStringUtil = new SPenTextUtil(context);
        this.mImageLoader = new SpenImageLoader(this.mDrawableImg);
        this.mContext = context;
        this.mCanvasLayout = relativeLayout;
        this.mCanvasLayout.addOnLayoutChangeListener(this.mLayoutChangeListener);
        this.mBodyLayoutHeight = -2;
        this.mPluginManager = SpenPluginManager.getInstance(context);
        if (this.mPluginManager != null) {
            initPenPlugin(context);
        }
        this.mSupportBeautifyPen = false;
        this.mSettingInfo = new SpenSettingPenInfo();
        initView(customImagePath);
        setListener();
        this.mMovableRect = new Rect();
        this.mOldMovableRect = new Rect();
        this.mOldLocation = new int[2];
        this.localDisplayMetrics = context.getResources().getDisplayMetrics();
    }

    public SpenSettingPenLayout(Context context, String customImagePath, RelativeLayout relativeLayout, float ratio) {
        super(context);
        this.mCanvasView = null;
        this.mPenAlpha = 255;
        this.mCanvasSize = 1080;
        this.mExpend = false;
        this.mGestureDetector = null;
        this.requestLayoutDisable = false;
        this.mEnablePresetSave = true;
        this.mBgTransparent = false;
        this.mExpandFlag = false;
        this.mOnsizeChange = false;
        this.mCurrentTopMargin = 0;
        this.mMoveSettingLayout = false;
        this.mPenTypeView = new ArrayList<>();
        this.mPenNameIndex = 0;
        this.mPresetListener = null;
        this.mActionListener = null;
        this.mSeekBarChangeListener = null;
        this.mVisibilityListener = null;
        this.mViewMode = 0;
        this.mBodyLayoutHeight = -2;
        this.mWindowHeight = 0;
        this.mScrollY = 0;
        this.mPreviousSelectedPresetIndex = -1;
        this.mNeedCalculateMargin = true;
        this.mFirstLongPress = true;
        this.mIsRotated = false;
        this.mIsRotated2 = false;
        this.colorPaletteView = null;
        this.MAX_HEIGHT_FLAG = 99999;
        this.currenMagicPenHeight = 99999;
        this.previousPenMagicSelected = false;
        this.isMagicPenEnable = false;
        this.isPresetClicked = false;
        this.mIsMaxHeight = false;
        this.penTypeLayout = null;
        this.repeatUpdateHandler = new Handler();
        this.mPenSizeAutoIncrement = false;
        this.mPenSizeAutoDecrement = false;
        this.mPenAlphaAutoIncrement = false;
        this.mPenAlphaAutoDecrement = false;
        this.mBeautifyAdvanceCursiveAutoIncrement = false;
        this.mBeautifyAdvanceCursiveAutoDecrement = false;
        this.mBeautifyAdvanceSustenanceAutoIncrement = false;
        this.mBeautifyAdvanceSustenanceAutoDecrement = false;
        this.mBeautifyAdvanceDummyAutoIncrement = false;
        this.mBeautifyAdvanceDummyAutoDecrement = false;
        this.mBeautifyAdvanceModulationAutoIncrement = false;
        this.mBeautifyAdvanceModulationAutoDecrement = false;
        this.mAdvancedSettingListener = new SpenPenInterface.ChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.1
            @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface.ChangeListener
            public void onChanged(String advancedSetting) {
                if (SpenSettingPenLayout.this.mCanvasView != null) {
                    SpenSettingPenInfo info = SpenSettingPenLayout.this.mCanvasView.getPenSettingInfo();
                    if (info != null) {
                        info.advancedSetting = advancedSetting;
                        SpenSettingPenLayout.this.mCanvasView.setPenSettingInfo(info);
                    }
                    SpenSettingPenLayout.this.mPenPreview.invalidate();
                }
            }
        };
        this.mCurrentBeautifyStyle = 0;
        this.mSupportBeautifyPen = false;
        this.BODY_LAYOUT_HEIGHT_BEAUTIFY_PEN = ScreenSharePacket.SCREEN_SHARE_CMD_EXTERNAL_PAUSE;
        this.BODY_LAYOUT_HEIGHT_BEAUTIFY_RAINBOW = 485;
        this.TOTAL_LAYOUT_WIDTH = 250;
        this.BODY_LAYOUT_HEIGHT = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_IME_INSERT_EVENT;
        this.BODY_LAYOUT_HEIGHT_WITH_ALPHA = 323;
        this.BODY_LAYOUT_HEIGHT_CHINESE = 312;
        this.BODY_LAYOUT_HEIGHT_MAGIC_PEN = ScreenSharePacket.SCREEN_SHARE_CMD_DRAWING_CLEARPAGE;
        this.GRADATION_HEIGHT = 48;
        this.TITLE_LAYOUT_HEIGHT = 41;
        this.TYPE_SELECTOR_LAYOUT_HEIGHT = 30;
        this.BEAUTIFY_RESET_BUTTON_HEIGHT = 40;
        this.BEAUTIFY_ENABLE_BUTTON_HEIGHT = 39;
        this.mOnClickPresetItemListener = new SpenPenPresetListAdapter.OnClickPresetItemListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.2
            @Override // com.samsung.android.sdk.pen.settingui.SpenPenPresetListAdapter.OnClickPresetItemListener
            public void deletePresetItem(int presetItemIndex) {
                try {
                    if (SpenSettingPenLayout.mPresetInfoList.size() > 0) {
                        if (SpenSettingPenLayout.mPresetInfoList.get(presetItemIndex) != null) {
                            SpenSettingPenLayout.mPresetInfoList.get(presetItemIndex).close();
                            SpenSettingPenLayout.mPresetInfoList.remove(presetItemIndex);
                            SpenPenPresetListAdapter.mList.remove(presetItemIndex);
                        }
                        if (SpenSettingPenLayout.this.mPreviousSelectedPresetIndex == presetItemIndex) {
                            SpenSettingPenLayout.this.mPresetListAdapter.mCurrentSeleted = -1;
                        } else if (SpenSettingPenLayout.this.mPreviousSelectedPresetIndex > presetItemIndex) {
                            SpenSettingPenLayout spenSettingPenLayout = SpenSettingPenLayout.this;
                            spenSettingPenLayout.mPreviousSelectedPresetIndex--;
                            SpenSettingPenLayout.this.mPresetListAdapter.mCurrentSeleted = SpenSettingPenLayout.this.mPreviousSelectedPresetIndex;
                        } else {
                            SpenSettingPenLayout.this.mPresetListAdapter.mCurrentSeleted = SpenSettingPenLayout.this.mPreviousSelectedPresetIndex;
                        }
                        SpenSettingPenLayout.this.mPresetListAdapter.notifyDataSetChanged();
                        SpenSettingPenLayout.this.presetDisplay();
                        if (SpenSettingPenLayout.this.mPresetListener != null) {
                            SpenSettingPenLayout.this.mPresetListener.onDeleted(presetItemIndex);
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                }
            }

            @Override // com.samsung.android.sdk.pen.settingui.SpenPenPresetListAdapter.OnClickPresetItemListener
            public void selectPresetItem(int presetItemIndex) {
                SpenSettingPenInfo info;
                for (int i = 0; i < SpenSettingPenLayout.this.mPenTypeView.size(); i++) {
                    if (SpenSettingPenLayout.this.mPenTypeView.get(i) != null) {
                        SpenSettingPenLayout.this.mPenTypeView.get(i).setSelected(false);
                        if (SpenSettingPenLayout.this.mPenPluginInfoList.get(i).getPenName().equals(SpenSettingPenLayout.mPresetInfoList.get(presetItemIndex).getPenName())) {
                            int penNameIdx = i;
                            if (SpenSettingPenLayout.this.isBeautifyPen(SpenSettingPenLayout.mPresetInfoList.get(presetItemIndex).getPenName())) {
                                penNameIdx = SpenSettingPenLayout.this.mPenPluginManager.getPenPluginIndexByPenName("com.samsung.android.sdk.pen.pen.preload.ChineseBrush");
                            }
                            SpenSettingPenLayout.this.mPresetListAdapter.mCurrentSeleted = presetItemIndex;
                            SpenSettingPenLayout.this.mPreviousSelectedPresetIndex = presetItemIndex;
                            SpenSettingPenLayout.this.mPresetListAdapter.notifyDataSetChanged();
                            SpenSettingPenLayout.this.presetDisplay();
                            SpenSettingPenLayout.mIsSwichTab = false;
                            if (SpenSettingPenLayout.mPresetInfoList.get(presetItemIndex).getPenName().equals("com.samsung.android.sdk.pen.pen.preload.MagicPen")) {
                                SpenSettingPenLayout.this.isMagicPenEnable = true;
                                SpenSettingPenLayout.this.mPenAlphaPreview.setVisibility(0);
                            } else {
                                SpenSettingPenLayout.this.mPenAlphaPreview.setVisibility(8);
                                SpenSettingPenLayout.this.isMagicPenEnable = false;
                            }
                            SpenSettingPenLayout.this.mPenTypeView.get(penNameIdx).setSelected(true);
                        }
                    }
                }
                if (SpenSettingPenLayout.this.mCanvasView != null && (info = SpenSettingPenLayout.this.mCanvasView.getPenSettingInfo()) != null) {
                    SpenSettingPenInfo spenSettingPenInfo = SpenSettingPenLayout.this.mSettingInfo;
                    String penName = SpenSettingPenLayout.mPresetInfoList.get(presetItemIndex).getPenName();
                    info.name = penName;
                    spenSettingPenInfo.name = penName;
                    SpenSettingPenInfo spenSettingPenInfo2 = SpenSettingPenLayout.this.mSettingInfo;
                    float penSize = SpenSettingPenLayout.mPresetInfoList.get(presetItemIndex).getPenSize();
                    info.size = penSize;
                    spenSettingPenInfo2.size = penSize;
                    SpenSettingPenInfo spenSettingPenInfo3 = SpenSettingPenLayout.this.mSettingInfo;
                    int color = SpenSettingPenLayout.mPresetInfoList.get(presetItemIndex).getColor();
                    info.color = color;
                    spenSettingPenInfo3.color = color;
                    SpenSettingPenInfo spenSettingPenInfo4 = SpenSettingPenLayout.this.mSettingInfo;
                    String advancedSetting = SpenSettingPenLayout.mPresetInfoList.get(presetItemIndex).getAdvancedSetting();
                    info.advancedSetting = advancedSetting;
                    spenSettingPenInfo4.advancedSetting = advancedSetting;
                    SpenSettingPenLayout.this.mCanvasView.setPenSettingInfo(info);
                    SpenSettingPenLayout.this.setInfo(SpenSettingPenLayout.this.mSettingInfo);
                    SpenSettingPenLayout.this.mPenPreview.setPenType(SpenSettingPenLayout.this.mSettingInfo.name);
                    SpenSettingPenLayout.this.mPenPreview.setStrokeSize(SpenSettingPenLayout.this.mSettingInfo.size);
                    SpenSettingPenLayout.this.mPenPreview.setStrokeColor(SpenSettingPenLayout.this.mSettingInfo.color);
                    SpenSettingPenLayout.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout.this.mSettingInfo.advancedSetting);
                    SpenSettingPenLayout.this.mPenPreview.invalidate();
                }
                if (SpenSettingPenLayout.this.mPresetListener != null) {
                    SpenSettingPenLayout.this.mPresetListener.onSelected(presetItemIndex);
                }
            }

            @Override // com.samsung.android.sdk.pen.settingui.SpenPenPresetListAdapter.OnClickPresetItemListener
            public void setScrollPresetGridToIndex(int paramInt) {
                SpenSettingPenLayout.this.mPresetGridView.smoothScrollToPosition(paramInt);
            }
        };
        this.mOnColorChangedListener = new SpenColorPaletteView.OnColorChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.3
            @Override // com.samsung.android.sdk.pen.settingui.SpenColorPaletteView.OnColorChangedListener
            public void colorChanged(int color, int selectedItem) {
                SpenSettingPenInfo info;
                if (SpenSettingPenLayout.this.isMinimumMode && selectedItem == 12) {
                    SpenSettingPenLayout.this.mColorGradationView.setVisibility(0);
                    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(118.0f));
                    SpenSettingPenLayout.this.mColorSelectPickerLayout.setLayoutParams(localLayoutParams);
                    SpenSettingPenLayout.this.isMinimumMode = false;
                    SpenSettingPenLayout.this.deltaOfMiniMode = 0;
                    SpenSettingPenLayout.this.setExpandBarPosition(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(323.0f));
                }
                int penPluginIndex = SpenSettingPenLayout.this.mPenPluginManager.getPenPluginIndexByPenName(SpenSettingPenLayout.this.mSettingInfo.name);
                if (penPluginIndex != -1 && SpenSettingPenLayout.this.mPenNameIndex == penPluginIndex && SpenSettingPenLayout.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject() != null) {
                    if (selectedItem != 13) {
                        SpenSettingPenLayout.this.mPenSizeSeekbarColor.setColor(color);
                        SpenSettingPenLayout.this.mPenSizeSeekbarColor.setAlpha(255);
                        SpenSettingPenLayout.this.setBeautifyAdvanceSeekbarColor(color);
                        if (SpenSettingPenLayout.this.mCanvasView != null && (info = SpenSettingPenLayout.this.mCanvasView.getPenSettingInfo()) != null) {
                            if (SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().getPenAttribute(1)) {
                                info.color = ((SpenSettingPenLayout.this.mPenAlpha << 24) & (-16777216)) | (16777215 & color);
                            } else {
                                info.color = color;
                            }
                            SpenSettingPenLayout.this.mSettingInfo.color = info.color;
                            SpenSettingPenLayout.this.mCanvasView.setPenSettingInfo(info);
                            SpenSettingPenLayout.this.mPenPreview.setStrokeColor(info.color);
                            SpenSettingPenLayout.this.mPenPreview.invalidate();
                            SpenSettingPenLayout.this.mPenAlphaSeekbarColor.setColor(info.color);
                            SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().setColor(info.color);
                            SpenSettingPenLayout.this.mColorPickerSetting.setColorPickerColor(info.color);
                        }
                        if (selectedItem == 12 && !SpenSettingPenLayout.this.isFirstTime && !SpenSettingPenLayout.this.isMinimumMode) {
                            SpenSettingPenLayout.this.isFirstTime = true;
                            SpenSettingPenLayout.this.mColorGradationView.setVisibility(0);
                            LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(118.0f));
                            SpenSettingPenLayout.this.mColorSelectPickerLayout.setLayoutParams(localLayoutParams2);
                            if (SpenSettingPenLayout.this.isBeautifyPen(SpenSettingPenLayout.this.mSettingInfo.name)) {
                                SpenSettingPenLayout.this.setExpandBarPosition(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(603.0f));
                            } else {
                                SpenSettingPenLayout.this.setExpandBarPosition(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(312.0f));
                            }
                        }
                    }
                    if (selectedItem == 13) {
                        if (SpenSettingPenLayout.this.mCanvasView != null) {
                            SpenSettingPenLayout.this.mPreCanvasPenAction = SpenSettingPenLayout.this.mCanvasView.getToolTypeAction(2);
                            SpenSettingPenLayout.this.mPreCanvasFingerAction = SpenSettingPenLayout.this.mCanvasView.getToolTypeAction(1);
                            SpenSettingPenLayout.this.mPreCanvasMouseAction = SpenSettingPenLayout.this.mCanvasView.getToolTypeAction(3);
                            SpenSettingPenLayout.this.mCanvasView.setToolTypeAction(2, 5);
                            SpenSettingPenLayout.this.mCanvasView.setToolTypeAction(1, 5);
                            SpenSettingPenLayout.this.mCanvasView.setToolTypeAction(3, 5);
                        }
                        SpenSettingPenLayout.this.mColorPaletteView.setColorPickerMode();
                        SpenSettingPenLayout.this.setVisibility(8);
                        SpenSettingPenLayout.this.mColorPickerSetting.show();
                    }
                }
            }
        };
        this.mColorPickerColorChangeListener = new SpenColorGradationView.onColorChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.4
            @Override // com.samsung.android.sdk.pen.settingui.SpenColorGradationView.onColorChangedListener
            public void onColorChanged(int color, int x, int y) {
                SpenSettingPenInfo info;
                int penPluginIndex = SpenSettingPenLayout.this.mPenPluginManager.getPenPluginIndexByPenName(SpenSettingPenLayout.this.mSettingInfo.name);
                if (penPluginIndex != -1 && SpenSettingPenLayout.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject() != null) {
                    SpenSettingPenLayout.this.mPenSizeSeekbarColor.setColor(color);
                    SpenSettingPenLayout.this.mPenSizeSeekbarColor.setAlpha(255);
                    SpenSettingPenLayout.this.setBeautifyAdvanceSeekbarColor(color);
                    if (SpenSettingPenLayout.this.mCanvasView != null && (info = SpenSettingPenLayout.this.mCanvasView.getPenSettingInfo()) != null) {
                        if (SpenSettingPenLayout.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().getPenAttribute(1)) {
                            info.color = ((SpenSettingPenLayout.this.mPenAlpha << 24) & (-16777216)) | (16777215 & color);
                        } else {
                            info.color = color;
                        }
                        SpenSettingPenLayout.this.mSettingInfo.color = info.color;
                        SpenSettingPenLayout.this.mCanvasView.setPenSettingInfo(info);
                        SpenSettingPenLayout.this.mPenAlphaSeekbarColor.setColor(info.color);
                        SpenSettingPenLayout.this.mPenPreview.setStrokeColor(info.color);
                        SpenSettingPenLayout.this.mPenPreview.invalidate();
                        SpenSettingPenLayout.this.mColorPaletteView.setColor(info.color);
                        SpenSettingPenLayout.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().setColor(info.color);
                        SpenSettingPenLayout.this.mColorPickerSetting.setColorPickerColor(info.color);
                    }
                }
            }
        };
        this.handler = new Handler();
        this.mPenAlphaChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.5
            int oldProgress = -1;

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (SpenSettingPenLayout.this.isMagicPenEnable) {
                    SpenSettingPenLayout.this.handler.postAtFrontOfQueue(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SpenSettingPenLayout.this.alphaDrawable.setAlpha(SpenSettingPenLayout.this.mPenAlpha);
                        }
                    });
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (SpenSettingPenLayout.this.isMagicPenEnable) {
                    SpenSettingPenLayout.this.alphaDrawable.setAlpha(SpenSettingPenLayout.this.mPenAlpha);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SpenSettingPenInfo info;
                int penPluginIndex = SpenSettingPenLayout.this.mPenPluginManager.getPenPluginIndexByPenName(SpenSettingPenLayout.this.mSettingInfo.name);
                if (penPluginIndex != -1 && SpenSettingPenLayout.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject() != null && seekBar == SpenSettingPenLayout.this.mPenAlphaSeekbar && this.oldProgress != progress) {
                    SpenSettingPenLayout.this.requestLayoutDisable = fromUser;
                    if (SpenSettingPenLayout.this.mSettingInfo.name.equals("com.samsung.android.sdk.pen.pen.preload.MagicPen")) {
                        SpenSettingPenLayout.this.requestLayoutDisable = false;
                    }
                    if (SpenSettingPenLayout.this.mPenAlphaPreview.getVisibility() == 0) {
                        SpenSettingPenLayout.this.mPenAlphaPreview.setAlpha((float) (progress / 100.0d));
                    }
                    SpenSettingPenLayout.this.mPenAlphaTextView.setText(String.valueOf(String.valueOf(progress + 1)) + "%");
                    int seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(24.0f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(170.0f) * (progress / 99.0f));
                    if (progress < 9) {
                        seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(26.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(168.0f) * (progress / 99.0f));
                    }
                    if (SpenSettingPenLayout.this.localDisplayMetrics.density == 2.0d && SpenSettingPenLayout.this.mCanvasSize != SpenSettingPenLayout.CANVAS_WIDTH_VEINNA) {
                        seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(24.0f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(168.0f) * (progress / 99.0f));
                        if (progress < 9) {
                            seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(26.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(168.0f) * (progress / 99.0f));
                        }
                        if (progress == SpenSettingPenLayout.PEN_SIZE_MAX) {
                            seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(23.0f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(168.0f) * (progress / 99.0f));
                        }
                    }
                    SpenSettingPenLayout.this.mPenAlphaSeekbar.setContentDescription(String.valueOf(SpenSettingPenLayout.this.mPenAlphaTextView.getText().toString()) + "\u0000");
                    SpenSettingPenLayout.this.mPenAlphaTextView.setX(seek_label_pos);
                    SpenSettingPenLayout.this.mPenAlphaTextView.setY(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(5.0f));
                    this.oldProgress = progress;
                    if (SpenSettingPenLayout.this.mCanvasView != null && (info = SpenSettingPenLayout.this.mCanvasView.getPenSettingInfo()) != null) {
                        if (SpenSettingPenLayout.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().getPenAttribute(1)) {
                            SpenSettingPenLayout.this.mPenAlpha = Math.round((progress * 255.0f) / 99.0f);
                            SpenSettingPenLayout.this.mPenPreview.setStrokeAlpha(SpenSettingPenLayout.this.mPenAlpha);
                            SpenSettingPenLayout.this.mPenPreview.invalidate();
                            info.color = ((SpenSettingPenLayout.this.mPenAlpha << 24) & (-16777216)) | (info.color & 16777215);
                            SpenSettingPenLayout.this.mPenAlphaSeekbarColor.setColor(info.color);
                            SpenSettingPenLayout.this.mSettingInfo.color = info.color;
                        }
                        SpenSettingPenLayout.this.mCanvasView.setPenSettingInfo(info);
                        SpenSettingPenLayout.this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().setColor(info.color);
                    }
                    if (SpenSettingPenLayout.this.mPenAlphaSeekbar.getProgress() == SpenSettingPenLayout.this.mPenAlphaSeekbar.getMax()) {
                        SpenSettingPenLayout.this.mOpacityPlusButton.setSelected(false);
                        SpenSettingPenLayout.this.mOpacityPlusButton.setEnabled(false);
                        if (SpenSettingPenLayout.this.mPenAlphaAutoIncrement) {
                            SpenSettingPenLayout.this.mPenAlphaAutoIncrement = false;
                        }
                    } else {
                        SpenSettingPenLayout.this.mOpacityPlusButton.setEnabled(true);
                    }
                    if (SpenSettingPenLayout.this.mPenAlphaSeekbar.getProgress() == 0) {
                        SpenSettingPenLayout.this.mOpacityMinusButton.setSelected(false);
                        SpenSettingPenLayout.this.mOpacityMinusButton.setEnabled(false);
                        if (SpenSettingPenLayout.this.mPenAlphaAutoDecrement) {
                            SpenSettingPenLayout.this.mPenAlphaAutoDecrement = false;
                        }
                    } else {
                        SpenSettingPenLayout.this.mOpacityMinusButton.setEnabled(true);
                    }
                    if (SpenSettingPenLayout.this.isMagicPenEnable) {
                        if (SpenSettingPenLayout.this.alphaDrawable != null) {
                            SpenSettingPenLayout.this.alphaDrawable.setAlpha(SpenSettingPenLayout.this.mPenAlpha);
                        }
                        SpenSettingPenLayout.this.mPenAlphaSeekbarColor.setColor(0);
                    }
                }
            }
        };
        this.mPenSizeChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (SpenSettingPenLayout.this.mSeekBarChangeListener != null) {
                    SpenSettingPenLayout.this.mSeekBarChangeListener.onProgressChanged();
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SpenSettingPenInfo info;
                if (SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject() != null) {
                    SpenSettingPenLayout.this.requestLayoutDisable = fromUser;
                    if (SpenSettingPenLayout.this.mSettingInfo.name.equals("com.samsung.android.sdk.pen.pen.preload.MagicPen")) {
                        SpenSettingPenLayout.this.requestLayoutDisable = false;
                    }
                    float min = SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().getMinSettingValue();
                    float max = SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().getMaxSettingValue();
                    if (SpenSettingPenLayout.this.mPenAlphaPreview.getVisibility() == 0) {
                        float mAlphaWidth = (float) (2.7d + ((progress * 6.3d) / 140.0d));
                        RelativeLayout.LayoutParams penPreviewLayoutParams02 = new RelativeLayout.LayoutParams(-1, SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(mAlphaWidth));
                        penPreviewLayoutParams02.addRule(9);
                        penPreviewLayoutParams02.addRule(12);
                        penPreviewLayoutParams02.rightMargin = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(3.0f);
                        penPreviewLayoutParams02.leftMargin = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(2.0f);
                        penPreviewLayoutParams02.bottomMargin = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(9.5f - (mAlphaWidth / 2.0f));
                        SpenSettingPenLayout.this.mPenAlphaPreview.setLayoutParams(penPreviewLayoutParams02);
                    }
                    SpenSettingPenLayout.this.mPenSizeTextView.setText(String.valueOf(Math.round(10.0f * min) + progress));
                    int seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(26.0f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(172.0f) * (progress / ((max - min) * 10.0f)));
                    if (SpenSettingPenLayout.this.mSettingInfo.name.equals(SpenPenManager.SPEN_PENCIL)) {
                        seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(26.0f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(172.5f) * (progress / ((max - min) * 10.0f)));
                    }
                    if (Math.round(10.0f * min) + progress >= 100) {
                        seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(24.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(169.5f) * (progress / ((max - min) * 10.0f)));
                    }
                    if (Math.round(10.0f * min) + progress >= 200) {
                        seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(25.0f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(171.0f) * (progress / ((max - min) * 10.0f)));
                    }
                    if (SpenSettingPenLayout.this.localDisplayMetrics.density == 2.0d && SpenSettingPenLayout.this.mCanvasSize != SpenSettingPenLayout.CANVAS_WIDTH_VEINNA) {
                        seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(26.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(171.0f) * (progress / ((max - min) * 10.0f)));
                        if (SpenSettingPenLayout.this.mSettingInfo.name.equals(SpenPenManager.SPEN_PENCIL)) {
                            seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(26.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(169.5f) * (progress / ((max - min) * 10.0f)));
                        }
                        if (Math.round(10.0f * min) + progress >= 100) {
                            seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(24.0f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(168.0f) * (progress / ((max - min) * 10.0f)));
                        }
                        if (Math.round(10.0f * min) + progress >= 200) {
                            seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(23.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(169.5f) * (progress / ((max - min) * 10.0f)));
                        }
                    }
                    if (SpenSettingPenLayout.this.mCanvasSize == SpenSettingPenLayout.CANVAS_WIDTH_VEINNA && SpenSettingPenLayout.this.localDisplayMetrics.density == 2.0d) {
                        seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(26.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(173.5f) * (progress / ((max - min) * 10.0f)));
                        if (SpenSettingPenLayout.this.mSettingInfo.name.equals(SpenPenManager.SPEN_PENCIL)) {
                            seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(26.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(173.0f) * (progress / ((max - min) * 10.0f)));
                        }
                        if (Math.round(10.0f * min) + progress >= 100) {
                            seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(24.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(170.5f) * (progress / ((max - min) * 10.0f)));
                        }
                        if (Math.round(10.0f * min) + progress >= 200) {
                            seek_label_pos = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(25.5f) + Math.round(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(171.0f) * (progress / ((max - min) * 10.0f)));
                        }
                    }
                    SpenSettingPenLayout.this.mPenSizeSeekbar.setContentDescription(String.valueOf(SpenSettingPenLayout.this.mPenSizeTextView.getText().toString()) + "\u0000");
                    SpenSettingPenLayout.this.mPenSizeTextView.setX(seek_label_pos);
                    SpenSettingPenLayout.this.mPenSizeTextView.setY(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(5.0f));
                    if (SpenSettingPenLayout.this.mCanvasView != null) {
                        if (SpenSettingPenLayout.this.mCanvasView.getCanvasWidth() < SpenSettingPenLayout.this.mCanvasView.getCanvasHeight()) {
                            SpenSettingPenLayout.this.mCanvasSize = SpenSettingPenLayout.this.mCanvasView.getCanvasWidth();
                        } else {
                            SpenSettingPenLayout.this.mCanvasSize = SpenSettingPenLayout.this.mCanvasView.getCanvasHeight();
                        }
                        if (SpenSettingPenLayout.this.mCanvasSize == 0) {
                            SpenSettingPenLayout.this.mCanvasSize = 1080;
                        }
                    } else {
                        SpenSettingPenLayout.this.mCanvasSize = 1080;
                    }
                    SpenSettingPenLayout.this.mSettingInfo.size = (((progress / 10.0f) + min) * SpenSettingPenLayout.this.mCanvasSize) / 360.0f;
                    SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().setSize(SpenSettingPenLayout.this.mSettingInfo.size);
                    SpenSettingPenLayout.this.mPenPreview.setStrokeSize(SpenSettingPenLayout.this.mSettingInfo.size);
                    SpenSettingPenLayout.this.mPenPreview.invalidate();
                    if (SpenSettingPenLayout.this.mCanvasView != null && (info = SpenSettingPenLayout.this.mCanvasView.getPenSettingInfo()) != null) {
                        info.size = SpenSettingPenLayout.this.mSettingInfo.size;
                        SpenSettingPenLayout.this.mCanvasView.setPenSettingInfo(info);
                    }
                    if (SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() == SpenSettingPenLayout.this.mPenSizeSeekbar.getMax()) {
                        SpenSettingPenLayout.this.mPenSizePlusButton.setSelected(false);
                        SpenSettingPenLayout.this.mPenSizePlusButton.setEnabled(false);
                        if (SpenSettingPenLayout.this.mPenSizeAutoIncrement) {
                            SpenSettingPenLayout.this.mPenSizeAutoIncrement = false;
                        }
                    } else {
                        SpenSettingPenLayout.this.mPenSizePlusButton.setEnabled(true);
                    }
                    if (SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() == 0) {
                        SpenSettingPenLayout.this.mPenSizeMinusButton.setSelected(false);
                        SpenSettingPenLayout.this.mPenSizeMinusButton.setEnabled(false);
                        if (SpenSettingPenLayout.this.mPenSizeAutoDecrement) {
                            SpenSettingPenLayout.this.mPenSizeAutoDecrement = false;
                            return;
                        }
                        return;
                    }
                    SpenSettingPenLayout.this.mPenSizeMinusButton.setEnabled(true);
                }
            }
        };
        this.mPenSizePlusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.7
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingPenLayout.this.mPenSizeAutoIncrement = true;
                SpenSettingPenLayout.this.mPenSizePlusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mPenTypeTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) throws NumberFormatException {
                if (event.getAction() == 1) {
                    if (!SpenSettingPenLayout.this.isPresetClicked) {
                        float x = event.getX();
                        float y = event.getY();
                        int index = Math.round((x - ((SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(50.0f) / SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(69.0f)) * (SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(69.0f) - y))) / SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(44.0f));
                        if (index < 0) {
                            index = 0;
                        } else if (index > SpenSettingPenLayout.this.mPenTypeView.size() - 1) {
                            index = SpenSettingPenLayout.this.mPenTypeView.size() - 1;
                        }
                        if (index < SpenSettingPenLayout.this.mNumberOfPenExist) {
                            View v1 = SpenSettingPenLayout.this.localPenTypeViewGroup.getChildAt(index);
                            for (int i = 0; i < SpenSettingPenLayout.this.mPenTypeView.size(); i++) {
                                if (v1 == SpenSettingPenLayout.this.mPenTypeView.get(i)) {
                                    SpenSettingPenLayout.this.penSelectIndex(i);
                                }
                            }
                            SpenSettingPenLayout.this.playSoundEffect(0);
                            SpenSettingPenLayout.this.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                } else {
                    SpenSettingPenLayout.this.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
        };
        this.mPenTypeKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.9
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (view.isFocused() && event.getAction() == 1) {
                            view.clearFocus();
                            view.performClick();
                            break;
                        }
                        break;
                }
                return false;
            }
        };
        this.mPenTypeHoverListener = new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.10
            private int preIndex = 0;

            @Override // android.view.View.OnHoverListener
            public boolean onHover(View v, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();
                int index = Math.round((x - ((SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(50.0f) / SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(69.0f)) * (SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(69.0f) - y))) / SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(44.0f));
                if (index < 0) {
                    index = 0;
                } else if (index > SpenSettingPenLayout.this.mPenTypeView.size() - 1) {
                    index = SpenSettingPenLayout.this.mPenTypeView.size() - 1;
                }
                if (this.preIndex < 0) {
                    this.preIndex = 0;
                } else if (this.preIndex > SpenSettingPenLayout.this.mPenTypeView.size() - 1) {
                    this.preIndex = SpenSettingPenLayout.this.mPenTypeView.size() - 1;
                }
                if (event.getAction() == 10) {
                    event.setAction(10);
                    SpenSettingPenLayout.this.mPenTypeView.get(this.preIndex).dispatchGenericMotionEvent(event);
                    event.setAction(9);
                    SpenSettingPenLayout.this.mPenTypeView.get(index).sendAccessibilityEvent(128);
                } else {
                    if (index != this.preIndex) {
                        event.setAction(10);
                        SpenSettingPenLayout.this.mPenTypeView.get(this.preIndex).dispatchGenericMotionEvent(event);
                        event.setAction(9);
                        SpenSettingPenLayout.this.mPenTypeView.get(index).sendAccessibilityEvent(128);
                    }
                    SpenSettingPenLayout.this.mPenTypeView.get(index).dispatchGenericMotionEvent(event);
                    this.preIndex = index;
                }
                return true;
            }
        };
        this.mPenSizePlusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mPenSizeAutoIncrement) {
                    SpenSettingPenLayout.this.mPenSizePlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mPenSizeAutoIncrement = false;
                }
                return false;
            }
        };
        this.mPenSizePlusButtonKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.12
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (SpenSettingPenLayout.this.mPenSizePlusButton.isSelected() && event.getAction() == 1) {
                            SpenSettingPenLayout.this.mPenSizePlusButton.setSelected(false);
                            SpenSettingPenLayout.this.mPenSizeAutoIncrement = false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        };
        this.mPenSizeMinusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.13
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingPenLayout.this.mPenSizeAutoDecrement = true;
                SpenSettingPenLayout.this.mPenSizeMinusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mPenSizeMinusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mPenSizeAutoDecrement) {
                    SpenSettingPenLayout.this.mPenSizeMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mPenSizeAutoDecrement = false;
                }
                return false;
            }
        };
        this.mPenSizeMinusButtonKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.15
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (SpenSettingPenLayout.this.mPenSizeMinusButton.isSelected() && event.getAction() == 1) {
                            SpenSettingPenLayout.this.mPenSizeMinusButton.setSelected(false);
                            SpenSettingPenLayout.this.mPenSizeAutoDecrement = false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        };
        this.mPenAlphaPlusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.16
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingPenLayout.this.mPenAlphaAutoIncrement = true;
                SpenSettingPenLayout.this.mOpacityPlusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mPenAlphaPlusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mPenAlphaAutoIncrement) {
                    SpenSettingPenLayout.this.mOpacityPlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mPenAlphaAutoIncrement = false;
                }
                return false;
            }
        };
        this.mPenAlphaPlusButtonKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.18
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (SpenSettingPenLayout.this.mOpacityPlusButton.isSelected() && event.getAction() == 1) {
                            SpenSettingPenLayout.this.mOpacityPlusButton.setSelected(false);
                            SpenSettingPenLayout.this.mPenAlphaAutoIncrement = false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        };
        this.mPenAlphaMinusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.19
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                SpenSettingPenLayout.this.mPenAlphaAutoDecrement = true;
                SpenSettingPenLayout.this.mOpacityMinusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mPenAlphaMinusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.20
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mPenAlphaAutoDecrement) {
                    SpenSettingPenLayout.this.mOpacityMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mPenAlphaAutoDecrement = false;
                }
                return false;
            }
        };
        this.mPenAlphaMinusButtonKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.21
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 66:
                        if (SpenSettingPenLayout.this.mOpacityMinusButton.isSelected() && event.getAction() == 1) {
                            SpenSettingPenLayout.this.mOpacityMinusButton.setSelected(false);
                            SpenSettingPenLayout.this.mPenAlphaAutoDecrement = false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        };
        this.mPenSizePlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() != SpenSettingPenLayout.this.mPenSizeSeekbar.getMax()) {
                    SpenSettingPenLayout.this.mPenSizeSeekbar.incrementProgressBy(1);
                    float min = SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().getMinSettingValue();
                    if (SpenSettingPenLayout.this.mCanvasView != null) {
                        if (SpenSettingPenLayout.this.mCanvasView.getCanvasWidth() < SpenSettingPenLayout.this.mCanvasView.getCanvasHeight()) {
                            SpenSettingPenLayout.this.mCanvasSize = SpenSettingPenLayout.this.mCanvasView.getCanvasWidth();
                        } else {
                            SpenSettingPenLayout.this.mCanvasSize = SpenSettingPenLayout.this.mCanvasView.getCanvasHeight();
                        }
                        if (SpenSettingPenLayout.this.mCanvasSize == 0) {
                            SpenSettingPenLayout.this.mCanvasSize = 1080;
                        }
                    } else {
                        SpenSettingPenLayout.this.mCanvasSize = 1080;
                    }
                    SpenSettingPenLayout.this.mSettingInfo.size = (((SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() / 10.0f) + min) * SpenSettingPenLayout.this.mCanvasSize) / 360.0f;
                    SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().setSize(SpenSettingPenLayout.this.mSettingInfo.size);
                }
            }
        };
        this.mPenSizeMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() != 0) {
                    if (SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() > 0) {
                        SpenSettingPenLayout.this.mPenSizeSeekbar.incrementProgressBy(-1);
                    }
                    float min = SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().getMinSettingValue();
                    if (SpenSettingPenLayout.this.mCanvasView != null) {
                        if (SpenSettingPenLayout.this.mCanvasView.getCanvasWidth() < SpenSettingPenLayout.this.mCanvasView.getCanvasHeight()) {
                            SpenSettingPenLayout.this.mCanvasSize = SpenSettingPenLayout.this.mCanvasView.getCanvasWidth();
                        } else {
                            SpenSettingPenLayout.this.mCanvasSize = SpenSettingPenLayout.this.mCanvasView.getCanvasHeight();
                        }
                        if (SpenSettingPenLayout.this.mCanvasSize == 0) {
                            SpenSettingPenLayout.this.mCanvasSize = 1080;
                        }
                    } else {
                        SpenSettingPenLayout.this.mCanvasSize = 1080;
                    }
                    SpenSettingPenLayout.this.mSettingInfo.size = (((SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() / 10.0f) + min) * SpenSettingPenLayout.this.mCanvasSize) / 360.0f;
                    if (SpenSettingPenLayout.this.mSettingInfo.size >= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                        SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().setSize(SpenSettingPenLayout.this.mSettingInfo.size);
                    } else {
                        SpenSettingPenLayout.this.mSettingInfo.size = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                    }
                }
            }
        };
        this.mPenAlphaPlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mPenAlphaSeekbar.incrementProgressBy(1);
            }
        };
        this.mPenAlphaMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mPenAlphaSeekbar.incrementProgressBy(-1);
            }
        };
        this.mPaletteNextButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int index = SpenSettingPenLayout.this.colorPaletteView.getCurrentTableIndex();
                if (index == 3) {
                    SpenSettingPenLayout.this.mPaletteLeftButton.setEnabled(true);
                }
                SpenSettingPenLayout.this.colorPaletteView.setNextColorTable(index);
                SpenSettingPenLayout.this.mColorPaletteView.setSelectBoxPos(SpenSettingPenLayout.this.mSettingInfo.color);
                if (SpenSettingPenLayout.this.colorPaletteView.getCurrentTableIndex() == 2) {
                    SpenSettingPenLayout.this.mPaletteRightButton.setEnabled(false);
                }
            }
        };
        this.mPaletteBackButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int index = SpenSettingPenLayout.this.colorPaletteView.getCurrentTableIndex();
                if (index == 2) {
                    SpenSettingPenLayout.this.mPaletteRightButton.setEnabled(true);
                }
                SpenSettingPenLayout.this.colorPaletteView.setBackColorTable(index);
                SpenSettingPenLayout.this.mColorPaletteView.setSelectBoxPos(SpenSettingPenLayout.this.mSettingInfo.color);
                if (SpenSettingPenLayout.this.colorPaletteView.getCurrentTableIndex() == 3) {
                    SpenSettingPenLayout.this.mPaletteLeftButton.setEnabled(false);
                }
            }
        };
        this.mPenTypeListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws NumberFormatException {
                for (int i = 0; i < SpenSettingPenLayout.this.mPenTypeView.size(); i++) {
                    if (v == SpenSettingPenLayout.this.mPenTypeView.get(i)) {
                        SpenSettingPenLayout.this.penSelectIndex(i);
                        return;
                    }
                }
            }
        };
        this.mColorPickerCurrentColorListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.29
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenInfo info;
                if (SpenSettingPenLayout.this.mCanvasView != null && (info = SpenSettingPenLayout.this.mCanvasView.getPenSettingInfo()) != null) {
                    SpenSettingPenLayout.this.mSettingInfo.color = info.color;
                    SpenSettingPenLayout.this.mPenPreview.setStrokeColor(info.color);
                    SpenSettingPenLayout.this.mPenPreview.invalidate();
                    SpenSettingPenLayout.this.mCanvasView.setPenSettingInfo(info);
                }
                SpenSettingPenLayout.this.mColorPaletteView.setColor(SpenSettingPenLayout.this.mSettingInfo.color);
                SpenSettingPenLayout.this.mColorPaletteView.invalidate();
                if (SpenSettingPenLayout.this.mCanvasView != null) {
                    SpenSettingPenLayout.this.mCanvasView.setToolTypeAction(2, SpenSettingPenLayout.this.mPreCanvasPenAction);
                    SpenSettingPenLayout.this.mCanvasView.setToolTypeAction(1, SpenSettingPenLayout.this.mPreCanvasFingerAction);
                    SpenSettingPenLayout.this.mCanvasView.setToolTypeAction(3, SpenSettingPenLayout.this.mPreCanvasMouseAction);
                }
                SpenSettingPenLayout.this.mColorPickerSetting.hide();
                SpenSettingPenLayout.this.setVisibility(0);
            }
        };
        this.mExitButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.30
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenInfo info;
                try {
                    if (SpenSettingPenLayout.this.mColorPickerSetting.getColorPickerSettingVisible() == 0) {
                        if (SpenSettingPenLayout.this.mCanvasView != null) {
                            SpenSettingPenLayout.this.mCanvasView.setToolTypeAction(2, SpenSettingPenLayout.this.mPreCanvasPenAction);
                            SpenSettingPenLayout.this.mCanvasView.setToolTypeAction(1, SpenSettingPenLayout.this.mPreCanvasFingerAction);
                            SpenSettingPenLayout.this.mCanvasView.setToolTypeAction(3, SpenSettingPenLayout.this.mPreCanvasMouseAction);
                        }
                        if (SpenSettingPenLayout.this.mColorPickerSetting.getColorPickerCurrentColor() != 0) {
                            SpenSettingPenLayout.this.mPenPreview.setStrokeColor(SpenSettingPenLayout.this.mColorPickerSetting.getColorPickerCurrentColor());
                            SpenSettingPenLayout.this.mPenPreview.invalidate();
                            SpenSettingPenLayout.this.mSettingInfo.color = SpenSettingPenLayout.this.mColorPickerSetting.getColorPickerCurrentColor();
                            if (SpenSettingPenLayout.this.mCanvasView != null && (info = SpenSettingPenLayout.this.mCanvasView.getPenSettingInfo()) != null) {
                                info.color = SpenSettingPenLayout.this.mColorPickerSetting.getColorPickerCurrentColor();
                                SpenSettingPenLayout.this.mCanvasView.setPenSettingInfo(info);
                            }
                            SpenSettingPenLayout.this.mColorPaletteView.setColorPickerColor(SpenSettingPenLayout.this.mColorPickerSetting.getColorPickerCurrentColor());
                            SpenSettingPenLayout.this.mColorPaletteView.invalidate();
                        }
                        SpenSettingPenLayout.this.mColorPickerSetting.hide();
                    }
                    if (SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject() != null && SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().getPenAttribute(4)) {
                        SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().hideAdvancedSetting();
                        SpenSettingPenLayout.this.mAdvancedSettingShow = false;
                    }
                    SpenSettingPenLayout.this.setVisibility(8);
                } catch (NullPointerException e) {
                }
            }
        };
        this.mOnConsumedTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.31
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SpenSettingPenLayout.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mOnConsumedHoverListener = new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.32
            @Override // android.view.View.OnHoverListener
            public boolean onHover(View v, MotionEvent event) {
                return true;
            }
        };
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.33
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (SpenSettingPenLayout.this.mGestureDetector != null && SpenSettingPenLayout.this.mGestureDetector.onTouchEvent(event)) {
                    SpenSettingPenLayout.this.requestDisallowInterceptTouchEvent(true);
                } else {
                    int x = Math.round(event.getRawX());
                    int y = Math.round(event.getRawY());
                    switch (event.getAction()) {
                        case 1:
                            if (SpenSettingPenLayout.this.mMoveSettingLayout && SpenSettingPenLayout.this.mActionListener != null) {
                                SpenSettingPenLayout.this.mActionListener.onMoved();
                                break;
                            }
                            break;
                        case 2:
                            if (SpenSettingPenLayout.this.mMoveSettingLayout) {
                                int mMoveX = x - SpenSettingPenLayout.this.mXDelta;
                                int mMoveY = y - SpenSettingPenLayout.this.mYDelta;
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                if (mMoveX > (SpenSettingPenLayout.this.mCanvasLayout.getWidth() - SpenSettingPenLayout.this.getWidth()) - 2) {
                                    mMoveX = (SpenSettingPenLayout.this.mCanvasLayout.getWidth() - SpenSettingPenLayout.this.getWidth()) - 2;
                                }
                                int minHeight = SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(163.0f);
                                int height = SpenSettingPenLayout.this.getHeight();
                                Log.e(SpenSettingPenLayout.TAG, "height = " + height);
                                Log.i(SpenSettingPenLayout.TAG, "before mMoveY = " + mMoveY);
                                if (height <= minHeight && mMoveY > SpenSettingPenLayout.this.mMovableRect.height() - minHeight) {
                                    mMoveY = SpenSettingPenLayout.this.mMovableRect.height() - minHeight;
                                } else if (mMoveY > SpenSettingPenLayout.this.mMovableRect.height() - height) {
                                    SpenSettingPenLayout.this.setExpandBarPosition((SpenSettingPenLayout.this.mMovableRect.height() - mMoveY) - SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(57.0f));
                                    if (mMoveY > SpenSettingPenLayout.this.mMovableRect.height() - minHeight) {
                                        mMoveY = SpenSettingPenLayout.this.mMovableRect.height() - minHeight;
                                    }
                                }
                                Log.w(SpenSettingPenLayout.TAG, "after mMoveY = " + mMoveY);
                                if (mMoveX < 0) {
                                    mMoveX = 0;
                                }
                                if (mMoveY < 0) {
                                    mMoveY = 0;
                                }
                                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) SpenSettingPenLayout.this.getLayoutParams();
                                params.leftMargin = mMoveX;
                                params.topMargin = mMoveY;
                                SpenSettingPenLayout.this.mCurrentTopMargin = params.topMargin;
                                SpenSettingPenLayout.this.setLayoutParams(params);
                                break;
                            }
                            break;
                    }
                    SpenSettingPenLayout.this.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
        };
        this.mAdvancedSettingButtonListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.34
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject() != null) {
                    if (!SpenSettingPenLayout.this.mAdvancedSettingShow) {
                        SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().showAdvancedSetting(SpenSettingPenLayout.this.mContext, SpenSettingPenLayout.this.mAdvancedSettingListener, (ViewGroup) SpenSettingPenLayout.this.getParent());
                    } else {
                        SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().hideAdvancedSetting();
                    }
                    SpenSettingPenLayout.this.mAdvancedSettingShow = !SpenSettingPenLayout.this.mAdvancedSettingShow;
                }
            }
        };
        this.mPreSetAddButtonListner = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.35
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws Resources.NotFoundException, NumberFormatException {
                try {
                    if (SpenSettingPenLayout.mPresetInfoList == null) {
                        SpenSettingPenLayout.mPresetInfoList = new ArrayList();
                    }
                    if (SpenSettingPenLayout.mPresetInfoList.size() >= 36) {
                        String strPreset = SpenSettingPenLayout.this.mStringUtil.setString("string_reached_maximum_preset");
                        if (strPreset != null) {
                            CharSequence text = String.format(strPreset, 36);
                            Toast toast = Toast.makeText(SpenSettingPenLayout.this.mContext, text, 0);
                            toast.show();
                            return;
                        }
                        return;
                    }
                    for (SpenPenPresetInfo info : SpenSettingPenLayout.mPresetInfoList) {
                        if ((info.getPenName().equals(SpenSettingPenLayout.this.mSettingInfo.name) && info.getPenSize() == SpenSettingPenLayout.this.mSettingInfo.size && info.getColor() == SpenSettingPenLayout.this.mSettingInfo.color && info.getAdvancedSetting().equals(SpenSettingPenLayout.this.mSettingInfo.advancedSetting)) || (SpenSettingPenLayout.this.mSettingInfo.name.equals(SpenSettingPenLayout.BEAUTIFY_PEN_NAME) && info.getPenSize() == SpenSettingPenLayout.this.mSettingInfo.size && info.getAdvancedSetting().equals(SpenSettingPenLayout.this.mSettingInfo.advancedSetting) && SpenSettingPenLayout.this.mCurrentBeautifyStyle == 5)) {
                            CharSequence text2 = SpenSettingPenLayout.this.mStringUtil.setString("string_already_exists");
                            Toast toast2 = Toast.makeText(SpenSettingPenLayout.this.mContext, text2, 0);
                            toast2.show();
                            return;
                        }
                    }
                    SpenSettingPenLayout.this.setButtonFocus(SpenSettingPenLayout.this.mPresetButton);
                    SpenSettingPenLayout.mIsSwichTab = true;
                    if (SpenSettingPenLayout.this.mViewMode != 8) {
                        SpenSettingPenLayout.this.mPenButton.setSelected(false);
                        SpenSettingPenLayout.this.mPresetButton.setSelected(true);
                        SpenSettingPenLayout.this.drawExpendImage(SpenSettingPenLayout.this.mSettingInfo.name);
                        SpenSettingPenLayout.this.setExpandBarPosition(SpenSettingPenLayout.this.mBodyLayoutHeight);
                        SpenSettingPenLayout.this.mPreviewLayout.setVisibility(8);
                        SpenSettingPenLayout.this.mPenTypeLayout.setVisibility(8);
                        SpenSettingPenLayout.this.mPenSeekbarLayout.setVisibility(8);
                        SpenSettingPenLayout.this.mColorSelectPickerLayout.setVisibility(8);
                        SpenSettingPenLayout.this.mColorPaletteView.setVisibility(8);
                        SpenSettingPenLayout.this.showBeautifyEnableLayout(false);
                        SpenSettingPenLayout.this.showBeautifyStyleBtnsLayout(false);
                        SpenSettingPenLayout.this.mBottomLayout.setVisibility(0);
                        SpenSettingPenLayout.this.mPresetLayout.setVisibility(0);
                    }
                    SpenPenPresetInfo presetInfoItem = new SpenPenPresetInfo();
                    presetInfoItem.setPenName(SpenSettingPenLayout.this.mSettingInfo.name);
                    presetInfoItem.setBitmapSize(SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(65.0f), SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(65.0f));
                    presetInfoItem.setPenSize(SpenSettingPenLayout.this.mSettingInfo.size);
                    presetInfoItem.setColor(SpenSettingPenLayout.this.mSettingInfo.color);
                    presetInfoItem.setAdvancedSetting(SpenSettingPenLayout.this.mSettingInfo.advancedSetting);
                    presetInfoItem.setPresetImageName(SpenSettingPenLayout.this.mPresetListAdapter.getPresetImage(SpenSettingPenLayout.this.mSettingInfo.name));
                    SpenSettingPenLayout.mPresetInfoList.add(presetInfoItem);
                    SpenPenPresetListAdapter.mList.add(presetInfoItem);
                    SpenSettingPenLayout.this.mPresetListAdapter.mCurrentSeleted = SpenSettingPenLayout.mPresetInfoList.size() - 1;
                    SpenSettingPenLayout.this.mPreviousSelectedPresetIndex = SpenSettingPenLayout.mPresetInfoList.size() - 1;
                    SpenSettingPenLayout.this.mPresetListAdapter.notifyDataSetChanged();
                    SpenSettingPenLayout.this.presetDisplay();
                    if (SpenSettingPenLayout.this.mPresetListener != null) {
                        SpenSettingPenLayout.this.mPresetListener.onAdded(SpenSettingPenLayout.this.mSettingInfo);
                    }
                    SpenSettingPenLayout.this.mPresetGridView.smoothScrollToPosition(SpenSettingPenLayout.mPresetInfoList.size() - 1);
                } catch (NullPointerException e) {
                }
            }
        };
        this.mTabSelectListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.36
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws NumberFormatException {
                try {
                    if (SpenSettingPenLayout.this.mViewMode != 5 && SpenSettingPenLayout.this.mViewMode != 6 && SpenSettingPenLayout.this.mViewMode != 7) {
                        SpenSettingPenLayout.this.requestLayoutDisable = false;
                        if (v.equals(SpenSettingPenLayout.this.mPenButton)) {
                            SpenSettingPenLayout.this.mPenButton.setContentDescription(String.valueOf(SpenSettingPenLayout.this.mStringUtil.setString("string_pen_tab")) + SpenSettingPenLayout.this.mStringUtil.setString("string_selected"));
                            SpenSettingPenLayout.this.mPresetButton.setContentDescription(String.valueOf(SpenSettingPenLayout.this.mStringUtil.setString("string_preset_tab")) + SpenSettingPenLayout.this.mStringUtil.setString("string_not_selected"));
                            SpenSettingPenLayout.this.isPresetClicked = false;
                            SpenSettingPenLayout.this.mPenButton.setSelected(true);
                            SpenSettingPenLayout.this.mPresetButton.setSelected(false);
                            SpenSettingPenLayout.this.drawExpendImage(SpenSettingPenLayout.this.mSettingInfo.name);
                            SpenSettingPenLayout.this.setExpandBarPosition(SpenSettingPenLayout.this.mBodyLayoutHeight);
                            SpenSettingPenLayout.this.mPreviewLayout.setVisibility(0);
                            SpenSettingPenLayout.this.mPenTypeLayout.setVisibility(0);
                            SpenSettingPenLayout.this.mPenSeekbarLayout.setVisibility(0);
                            SpenSettingPenLayout.this.mColorSelectPickerLayout.setVisibility(0);
                            SpenSettingPenLayout.this.mColorPaletteView.setVisibility(0);
                            SpenSettingPenLayout.this.mBottomLayout.setVisibility(0);
                            SpenSettingPenLayout.this.setColorSelectorViewForBeautifyPen();
                            SpenSettingPenLayout.this.mImageLoader.addViewBackgroundSelectableImageLoad(SpenSettingPenLayout.this.mBottomExtendBg, SpenSettingPenLayout.bottomExpandPath, SpenSettingPenLayout.bottomExpandPressPath, SpenSettingPenLayout.bottomExpandPressPath);
                            if (SpenSettingPenLayout.mSdkVersion < 16) {
                                SpenSettingPenLayout.this.mBottomExtendBg.setBackgroundDrawable(SpenSettingPenLayout.this.mDrawableImg.setDrawableSelectImg(SpenSettingPenLayout.bottomExpandPath, SpenSettingPenLayout.bottomExpandPressPath, SpenSettingPenLayout.bottomExpandPressPath));
                            } else {
                                SpenSettingPenLayout.this.mBottomExtendBg.setBackground(SpenSettingPenLayout.this.mDrawableImg.setDrawableSelectImg(SpenSettingPenLayout.bottomExpandPath, SpenSettingPenLayout.bottomExpandPressPath, SpenSettingPenLayout.bottomExpandPressPath));
                            }
                            SpenSettingPenLayout.this.mBottomExtendBg.invalidate();
                            if (SpenSettingPenLayout.this.isBeautifyPen(SpenSettingPenLayout.this.mSettingInfo.name)) {
                                SpenSettingPenLayout.this.showBeautifyEnableLayout(true);
                                SpenSettingPenLayout.this.showBeautifyStyleBtnsLayout(true);
                            } else if (SpenSettingPenLayout.this.isChinesePen(SpenSettingPenLayout.this.mSettingInfo.name)) {
                                SpenSettingPenLayout.this.showBeautifyEnableLayout(true);
                            } else {
                                SpenSettingPenLayout.this.showBeautifyEnableLayout(false);
                                SpenSettingPenLayout.this.showBeautifySettingViews(false);
                            }
                            SpenSettingPenLayout.this.mPresetLayout.setVisibility(8);
                            if (SpenSettingPenLayout.this.isMagicPenEnable) {
                                SpenSettingPenLayout.this.setMagicPenMode(SpenSettingPenLayout.this.currenMagicPenHeight);
                            }
                        } else if (v.equals(SpenSettingPenLayout.this.mPresetButton)) {
                            SpenSettingPenLayout.mIsSwichTab = true;
                            SpenSettingPenLayout.this.mPenButton.setContentDescription(String.valueOf(SpenSettingPenLayout.this.mStringUtil.setString("string_pen_tab")) + SpenSettingPenLayout.this.mStringUtil.setString("string_not_selected"));
                            SpenSettingPenLayout.this.mPresetButton.setContentDescription(String.valueOf(SpenSettingPenLayout.this.mStringUtil.setString("string_preset_tab")) + SpenSettingPenLayout.this.mStringUtil.setString("string_selected"));
                            SpenSettingPenLayout.this.isPresetClicked = true;
                            SpenSettingPenLayout.this.mPenButton.setSelected(false);
                            SpenSettingPenLayout.this.mPresetButton.setSelected(true);
                            SpenSettingPenLayout.this.drawExpendImage(SpenSettingPenLayout.this.mSettingInfo.name);
                            SpenSettingPenLayout.this.setExpandBarPosition(SpenSettingPenLayout.this.mBodyLayoutHeight);
                            SpenSettingPenLayout.this.mPreviewLayout.setVisibility(8);
                            SpenSettingPenLayout.this.mPenTypeLayout.setVisibility(8);
                            SpenSettingPenLayout.this.mPenSeekbarLayout.setVisibility(8);
                            SpenSettingPenLayout.this.mColorSelectPickerLayout.setVisibility(8);
                            SpenSettingPenLayout.this.mColorPaletteView.setVisibility(8);
                            SpenSettingPenLayout.this.showBeautifyEnableLayout(false);
                            SpenSettingPenLayout.this.showBeautifyStyleBtnsLayout(false);
                            SpenSettingPenLayout.this.mBottomLayout.setVisibility(0);
                            SpenSettingPenLayout.this.mImageLoader.addViewBackgroundSelectableImageLoad(SpenSettingPenLayout.this.mBottomExtendBg, SpenSettingPenLayout.bottomExpandPresetPath, SpenSettingPenLayout.bottomExpandPresetPressPath, SpenSettingPenLayout.bottomExpandPresetPressPath);
                            if (SpenSettingPenLayout.mSdkVersion < 16) {
                                SpenSettingPenLayout.this.mBottomExtendBg.setBackgroundDrawable(SpenSettingPenLayout.this.mDrawableImg.setDrawableSelectImg(SpenSettingPenLayout.bottomExpandPresetPath, SpenSettingPenLayout.bottomExpandPresetPressPath, SpenSettingPenLayout.bottomExpandPresetPressPath));
                            } else {
                                SpenSettingPenLayout.this.mBottomExtendBg.setBackground(SpenSettingPenLayout.this.mDrawableImg.setDrawableSelectImg(SpenSettingPenLayout.bottomExpandPresetPath, SpenSettingPenLayout.bottomExpandPresetPressPath, SpenSettingPenLayout.bottomExpandPresetPressPath));
                            }
                            SpenSettingPenLayout.this.mBottomExtendBg.invalidate();
                            SpenSettingPenLayout.this.mPresetListAdapter.mCurrentSeleted = -1;
                            if (SpenSettingPenLayout.mPresetInfoList == null) {
                                SpenSettingPenLayout.mPresetInfoList = new ArrayList();
                            }
                            Iterator<SpenPenPresetInfo> it = SpenSettingPenLayout.mPresetInfoList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                SpenPenPresetInfo info = it.next();
                                if (info.getPenName().equals(SpenSettingPenLayout.this.mSettingInfo.name) && info.getPenSize() == SpenSettingPenLayout.this.mSettingInfo.size && info.getColor() == SpenSettingPenLayout.this.mSettingInfo.color && info.getAdvancedSetting().equals(SpenSettingPenLayout.this.mSettingInfo.advancedSetting)) {
                                    SpenSettingPenLayout.this.mPreviousSelectedPresetIndex = SpenSettingPenLayout.mPresetInfoList.indexOf(info);
                                    SpenSettingPenLayout.this.mPresetListAdapter.mCurrentSeleted = SpenSettingPenLayout.this.mPreviousSelectedPresetIndex;
                                    SpenSettingPenLayout.this.mPresetGridView.smoothScrollToPosition(SpenSettingPenLayout.this.mPreviousSelectedPresetIndex);
                                    break;
                                }
                            }
                            SpenSettingPenLayout.this.mPresetListAdapter.notifyDataSetChanged();
                            SpenSettingPenLayout.this.presetDisplay();
                            SpenSettingPenLayout.this.mPresetLayout.setVisibility(0);
                        }
                        SpenSettingPenLayout.this.setButtonFocus(v);
                    }
                } catch (NullPointerException e) {
                }
            }
        };
        this.mExpendBarHoverListener = new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.37
            @Override // android.view.View.OnHoverListener
            public boolean onHover(View v, MotionEvent event) {
                return true;
            }
        };
        this.mExpendBarListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.38
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int x = Math.round(event.getRawX());
                int y = Math.round(event.getRawY());
                switch (event.getAction()) {
                    case 0:
                        RelativeLayout.LayoutParams bottomParams = (RelativeLayout.LayoutParams) SpenSettingPenLayout.this.mBottomLayout.getLayoutParams();
                        SpenSettingPenLayout.this.mXDelta = x - bottomParams.leftMargin;
                        SpenSettingPenLayout.this.mYDelta = y - bottomParams.topMargin;
                        SpenSettingPenLayout.this.mBottomExtendBg.setPressed(true);
                        break;
                    case 1:
                        if (SpenSettingPenLayout.this.mExpandFlag) {
                            if (SpenSettingPenLayout.this.mActionListener != null) {
                                SpenSettingPenLayout.this.mActionListener.onResized();
                            }
                            SpenSettingPenLayout.this.mExpandFlag = false;
                        }
                        SpenSettingPenLayout.this.mBottomExtendBg.setPressed(false);
                        break;
                    case 2:
                        SpenSettingPenLayout.this.mExpandFlag = true;
                        if (y - SpenSettingPenLayout.this.mYDelta > 0) {
                            SpenSettingPenLayout.this.setExpandBarPosition(y - SpenSettingPenLayout.this.mYDelta);
                            break;
                        }
                        break;
                    case 3:
                        SpenSettingPenLayout.this.mBottomExtendBg.setPressed(false);
                        break;
                }
                SpenSettingPenLayout.this.requestDisallowInterceptTouchEvent(true);
                return true;
            }
        };
        this.mGestureListener = new GestureDetector.OnGestureListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.39
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent event) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent event) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent event, MotionEvent arg1, float arg2, float arg3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent event) {
                if (SpenSettingPenLayout.this.mNeedCalculateMargin) {
                    int[] location = new int[2];
                    SpenSettingPenLayout.this.mCanvasLayout.getLocationOnScreen(location);
                    SpenSettingPenLayout.this.mLeftMargin = Math.round((event.getRawX() - location[0]) - event.getX());
                    SpenSettingPenLayout.this.mTopMargin = Math.round((event.getRawY() - location[1]) - event.getY());
                    int[] rootLocation = new int[2];
                    SpenSettingPenLayout.this.getRootView().getLocationOnScreen(rootLocation);
                    SpenSettingPenLayout.this.mNeedCalculateMargin = false;
                }
                if (SpenSettingPenLayout.this.mFirstLongPress) {
                    SpenSettingPenLayout.this.mTitleLayout.performHapticFeedback(1);
                    SpenSettingPenLayout.this.mFirstLongPress = false;
                }
                Rect r = SpenSettingPenLayout.this.getMovableRect();
                SpenSettingPenLayout.this.mMovableRect.set(r);
                SpenSettingPenLayout.this.mMoveSettingLayout = true;
                SpenSettingPenLayout.this.mIndicator.setVisibility(8);
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent event, MotionEvent arg1, float arg2, float arg3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent event) {
                SpenSettingPenLayout.this.mMovableRect.set(SpenSettingPenLayout.this.getMovableRect());
                int x = Math.round(event.getRawX());
                int y = Math.round(event.getRawY());
                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) SpenSettingPenLayout.this.getLayoutParams();
                SpenSettingPenLayout.this.mXDelta = x - params.leftMargin;
                SpenSettingPenLayout.this.mYDelta = y - params.topMargin;
                return true;
            }
        };
        this.mBeautifyEnablecheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.40
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) throws NumberFormatException {
                if (SpenSettingPenLayout.this.mPenButton.isSelected()) {
                    SpenSettingPenLayout.this.showBeautifySettingViews(isChecked);
                }
                if (SpenSettingPenLayout.this.isChinesePen(SpenSettingPenLayout.this.mSettingInfo.name) || SpenSettingPenLayout.this.isBeautifyPen(SpenSettingPenLayout.this.mSettingInfo.name)) {
                    SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenPluginObject().setColor(SpenSettingPenLayout.this.mSettingInfo.color);
                    if (isChecked) {
                        SpenSettingPenLayout.this.mPenNameIndex = SpenSettingPenLayout.this.mPenPluginManager.getPenPluginIndexByPenName(SpenSettingPenLayout.BEAUTIFY_PEN_NAME);
                    } else {
                        SpenSettingPenLayout.this.mPenNameIndex = SpenSettingPenLayout.this.mPenPluginManager.getPenPluginIndexByPenName("com.samsung.android.sdk.pen.pen.preload.ChineseBrush");
                    }
                    SpenSettingPenLayout.this.mSettingInfo.name = SpenSettingPenLayout.this.mPenPluginInfoList.get(SpenSettingPenLayout.this.mPenNameIndex).getPenName();
                    SpenSettingPenLayout.this.updateBeautifySettingData();
                    SpenSettingPenLayout.this.beautifyUpdateSettingUI(isChecked);
                    SpenSettingPenLayout.this.drawExpendImage(SpenSettingPenLayout.this.mSettingInfo.name);
                }
            }
        };
        this.mBeautifyStyleBtnsListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.41
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SpenSettingPenLayout.this.mBeautifyStyleBtnViews != null) {
                    int beautifyStyleIndex = 0;
                    Iterator<ImageButton> it = SpenSettingPenLayout.this.mBeautifyStyleBtnViews.iterator();
                    while (it.hasNext()) {
                        ImageButton styleBtn = it.next();
                        if (styleBtn.equals(v)) {
                            if (beautifyStyleIndex == SpenSettingPenLayout.this.mCurrentBeautifyStyle) {
                                break;
                            }
                            SpenSettingPenLayout.this.mCurrentBeautifyStyle = beautifyStyleIndex;
                            styleBtn.setSelected(true);
                        } else {
                            styleBtn.setSelected(false);
                        }
                        beautifyStyleIndex++;
                    }
                    SpenSettingPenLayout.this.resetBeautifyAdvanceDataAndUpdateSeekBarUi(SpenSettingPenLayout.this.mCurrentBeautifyStyle);
                }
            }
        };
        this.mBeautifyAdvanceCursiveChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.42
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String cursiveStr = String.valueOf(SpenSettingPenLayout.this.mStringUtil.setString("string_cursive")) + " " + progress;
                SpenSettingPenLayout.this.mBeautifyCursiveTextView.setText(cursiveStr);
                SpenSettingPenLayout.this.setBeautifyAdvancedDataToPlugin(2, progress);
                SpenSettingPenLayout.this.updateBeautifySettingData();
                SpenSettingPenLayout.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout.this.mSettingInfo.advancedSetting);
                SpenSettingPenLayout.this.mPenPreview.invalidate();
                if (SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.getProgress() == SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.getMax()) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursivePlusButton.setAlpha(0.2f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursivePlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursivePlusButton.setEnabled(false);
                    if (SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoIncrement) {
                        SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoIncrement = false;
                    }
                } else {
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursivePlusButton.setAlpha(1.0f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursivePlusButton.setEnabled(true);
                }
                if (SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.getProgress() == 0) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursiveMinusButton.setAlpha(0.2f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursiveMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursiveMinusButton.setEnabled(false);
                    if (SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoDecrement) {
                        SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoDecrement = false;
                        return;
                    }
                    return;
                }
                SpenSettingPenLayout.this.mBeautifyAdvanceCursiveMinusButton.setAlpha(1.0f);
                SpenSettingPenLayout.this.mBeautifyAdvanceCursiveMinusButton.setEnabled(true);
            }
        };
        this.mBeautifyAdvanceSustenanceChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.43
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String sustenanceStr = String.valueOf(SpenSettingPenLayout.this.mStringUtil.setString("string_sustenance")) + " " + progress;
                SpenSettingPenLayout.this.mBeautifySustenanceTextView.setText(sustenanceStr);
                SpenSettingPenLayout.this.setBeautifyAdvancedDataToPlugin(3, progress);
                SpenSettingPenLayout.this.updateBeautifySettingData();
                SpenSettingPenLayout.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout.this.mSettingInfo.advancedSetting);
                SpenSettingPenLayout.this.mPenPreview.invalidate();
                if (SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.getProgress() == SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.getMax()) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenancePlusButton.setAlpha(0.2f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenancePlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenancePlusButton.setEnabled(false);
                    if (SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoIncrement) {
                        SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoIncrement = false;
                    }
                } else {
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenancePlusButton.setAlpha(1.0f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenancePlusButton.setEnabled(true);
                }
                if (SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.getProgress() == 0) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceMinusButton.setAlpha(0.2f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceMinusButton.setEnabled(false);
                    if (SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoDecrement) {
                        SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoDecrement = false;
                        return;
                    }
                    return;
                }
                SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceMinusButton.setAlpha(1.0f);
                SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceMinusButton.setEnabled(true);
            }
        };
        this.mBeautifyAdvanceDummyChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.44
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String dummyStr = String.valueOf(SpenSettingPenLayout.this.mStringUtil.setString("string_dummy")) + " " + progress;
                SpenSettingPenLayout.this.mBeautifyDummyTextView.setText(dummyStr);
                SpenSettingPenLayout.this.setBeautifyAdvancedDataToPlugin(4, progress);
                SpenSettingPenLayout.this.updateBeautifySettingData();
                SpenSettingPenLayout.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout.this.mSettingInfo.advancedSetting);
                SpenSettingPenLayout.this.mPenPreview.invalidate();
                if (SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.getProgress() == SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.getMax()) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyPlusButton.setAlpha(0.2f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyPlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyPlusButton.setEnabled(false);
                    if (SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoIncrement) {
                        SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoIncrement = false;
                    }
                } else {
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyPlusButton.setAlpha(1.0f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyPlusButton.setEnabled(true);
                }
                if (SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.getProgress() == 0) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyMinusButton.setAlpha(0.2f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyMinusButton.setEnabled(false);
                    if (SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoDecrement) {
                        SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoDecrement = false;
                        return;
                    }
                    return;
                }
                SpenSettingPenLayout.this.mBeautifyAdvanceDummyMinusButton.setAlpha(1.0f);
                SpenSettingPenLayout.this.mBeautifyAdvanceDummyMinusButton.setEnabled(true);
            }
        };
        this.mBeautifyAdvanceModulationChangeListner = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.45
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String modulationStr = String.valueOf(SpenSettingPenLayout.this.mStringUtil.setString("string_modulation")) + " " + progress;
                SpenSettingPenLayout.this.mBeautifyModulationTextView.setText(modulationStr);
                SpenSettingPenLayout.this.setBeautifyAdvancedDataToPlugin(6, progress);
                SpenSettingPenLayout.this.updateBeautifySettingData();
                SpenSettingPenLayout.this.mPenPreview.setStrokeAdvancedSetting(SpenSettingPenLayout.this.mSettingInfo.advancedSetting);
                SpenSettingPenLayout.this.mPenPreview.invalidate();
                if (SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.getProgress() == SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.getMax()) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationPlusButton.setAlpha(0.2f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationPlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationPlusButton.setEnabled(false);
                    if (SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoIncrement) {
                        SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoIncrement = false;
                    }
                } else {
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationPlusButton.setAlpha(1.0f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationPlusButton.setEnabled(true);
                }
                if (SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.getProgress() == 0) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationMinusButton.setAlpha(0.2f);
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationMinusButton.setEnabled(false);
                    if (SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoDecrement) {
                        SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoDecrement = false;
                        return;
                    }
                    return;
                }
                SpenSettingPenLayout.this.mBeautifyAdvanceModulationMinusButton.setAlpha(1.0f);
                SpenSettingPenLayout.this.mBeautifyAdvanceModulationMinusButton.setEnabled(true);
            }
        };
        this.mBeautifyAdvanceCursivePlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.46
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.incrementProgressBy(1);
            }
        };
        this.mBeautifyAdvanceCursiveMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.47
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.incrementProgressBy(-1);
            }
        };
        this.mBeautifyAdvanceSustenancePlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.48
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.incrementProgressBy(1);
            }
        };
        this.mBeautifyAdvanceSustenanceMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.49
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.incrementProgressBy(-1);
            }
        };
        this.mBeautifyAdvanceDummyPlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.50
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.incrementProgressBy(1);
            }
        };
        this.mBeautifyAdvanceDummyMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.51
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.incrementProgressBy(-1);
            }
        };
        this.mBeautifyAdvanceModulationPlusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.52
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.incrementProgressBy(1);
            }
        };
        this.mBeautifyAdvanceModulationMinusButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.53
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.incrementProgressBy(-1);
            }
        };
        this.mBeautifyAdvanceResetButtonListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.54
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenSettingPenLayout.this.resetBeautifyAdvanceDataAndUpdateSeekBarUi(SpenSettingPenLayout.this.mCurrentBeautifyStyle);
            }
        };
        this.mPenSizeKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.55
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View arg0, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingPenLayout.this.mPenSizeSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() != 0) {
                                SpenSettingPenLayout.this.mPenSizeSeekbar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingPenLayout.this.mPenSizeSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mPenSizeSeekbar.getProgress() != SpenSettingPenLayout.this.mPenSizeSeekbar.getMax()) {
                                SpenSettingPenLayout.this.mPenSizeSeekbar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.mPenAlphaKeyListener = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.56
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingPenLayout.this.mPenAlphaSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mPenAlphaSeekbar.getProgress() != 0) {
                                SpenSettingPenLayout.this.mPenAlphaSeekbar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingPenLayout.this.mPenAlphaSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mPenAlphaSeekbar.getProgress() != SpenSettingPenLayout.this.mPenAlphaSeekbar.getMax()) {
                                SpenSettingPenLayout.this.mPenAlphaSeekbar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceCursivePlusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.57
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoIncrement = true;
                SpenSettingPenLayout.this.mBeautifyAdvanceCursivePlusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mBeautifyAdvanceSustenancePlusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.58
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoIncrement = true;
                SpenSettingPenLayout.this.mBeautifyAdvanceSustenancePlusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mBeautifyAdvanceDummyPlusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.59
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoIncrement = true;
                SpenSettingPenLayout.this.mBeautifyAdvanceDummyPlusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mBeautifyAdvanceModulationPlusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.60
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoIncrement = true;
                SpenSettingPenLayout.this.mBeautifyAdvanceModulationPlusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mBeautifyAdvanceCursiveMinusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.61
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoDecrement = true;
                SpenSettingPenLayout.this.mBeautifyAdvanceCursiveMinusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mBeautifyAdvanceSustenanceMinusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.62
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoDecrement = true;
                SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceMinusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mBeautifyAdvanceDummyMinusButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.63
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoDecrement = true;
                SpenSettingPenLayout.this.mBeautifyAdvanceDummyMinusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mBeautifyAdvanceModulationMinusButtonlongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.64
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoDecrement = true;
                SpenSettingPenLayout.this.mBeautifyAdvanceModulationMinusButton.setSelected(true);
                SpenSettingPenLayout.this.repeatUpdateHandler.post(SpenSettingPenLayout.this.new RptUpdater());
                return false;
            }
        };
        this.mBeautifyAdvanceCursivePlusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.65
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoIncrement) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursivePlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoIncrement = false;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceSustenancePlusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.66
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoIncrement) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenancePlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoIncrement = false;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceDummyPlusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.67
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoIncrement) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyPlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoIncrement = false;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceModulationPlusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.68
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoIncrement) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationPlusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoIncrement = false;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceCursiveMinusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.69
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoDecrement) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursiveMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoDecrement = false;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceSustenanceMinusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.70
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mBeautifyAdvanceCursiveAutoDecrement) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceAutoDecrement = false;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceDummyMinusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.71
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoDecrement) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceDummyAutoDecrement = false;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceModulationMinusButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.72
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                if ((event.getAction() == 1 || event.getAction() == 3) && SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoDecrement) {
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationMinusButton.setSelected(false);
                    SpenSettingPenLayout.this.mBeautifyAdvanceModulationAutoDecrement = false;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceCursiveKeyListner = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.73
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.getProgress() != 0) {
                                SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.getProgress() != SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.getMax()) {
                                SpenSettingPenLayout.this.mBeautifyAdvanceCursiveSeekbar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceSustenanceKeyListner = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.74
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.getProgress() != 0) {
                                SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.getProgress() != SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.getMax()) {
                                SpenSettingPenLayout.this.mBeautifyAdvanceSustenanceSeekbar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceDummyKeyListner = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.75
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.getProgress() != 0) {
                                SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.getProgress() != SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.getMax()) {
                                SpenSettingPenLayout.this.mBeautifyAdvanceDummySeekbar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.mBeautifyAdvanceModulationKeyListner = new View.OnKeyListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.76
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case 21:
                        if (SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.getProgress() != 0) {
                                SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.incrementProgressBy(-1);
                            }
                        }
                        break;
                    case 22:
                        if (SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.isFocused() && event.getAction() == 0) {
                            if (SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.getProgress() != SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.getMax()) {
                                SpenSettingPenLayout.this.mBeautifyAdvanceModulationSeekbar.incrementProgressBy(1);
                            }
                        }
                        break;
                }
                return false;
            }
        };
        this.horizontalScrollViewTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.77
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View arg0, MotionEvent arg1) {
                if (arg1.getAction() != 1 || SpenSettingPenLayout.this.mPenTypeHorizontalScrollView2.getScrollX() <= SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(44.0f)) {
                    return false;
                }
                SpenSettingPenLayout.this.playScrollAnimation(10, SpenSettingPenLayout.this.mPenTypeHorizontalScrollView2.getScrollX(), SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(44.0f));
                return false;
            }
        };
        this.deltaOfMiniMode = 0;
        this.isMinimumMode = false;
        this.deltaOfFirstTime = 52;
        this.isFirstTime = false;
        this.mNumberOfPenExist = 6;
        this.mHandler = new Handler();
        this.mCount = 0;
        this.mLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.78
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                try {
                    if (SpenSettingPenLayout.this.getVisibility() == 8) {
                        if (SpenSettingPenLayout.this.mIsRotated) {
                            SpenSettingPenLayout.this.mIsRotated = false;
                            return;
                        }
                        return;
                    }
                    if (!SpenSettingPenLayout.this.mIsRotated && SpenSettingPenLayout.this.mIsRotated2) {
                        SpenSettingPenLayout.this.mIsRotated2 = false;
                    }
                    SpenSettingPenLayout.this.mMovableRect.set(SpenSettingPenLayout.this.getMovableRect());
                    if (SpenSettingPenLayout.this.mIsRotated) {
                        SpenSettingPenLayout.this.rotatePosition();
                        SpenSettingPenLayout.this.mIsRotated = false;
                        SpenSettingPenLayout.this.mIsRotated2 = true;
                    } else {
                        SpenSettingPenLayout.this.checkPosition();
                    }
                    Handler handler = new Handler();
                    handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.78.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SpenSettingPenLayout.this.requestLayout();
                        }
                    });
                } catch (NullPointerException e) {
                }
            }
        };
        this.mScrollViewListner = new SpenScrollView.scrollChangedListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.79
            @Override // com.samsung.android.sdk.pen.settingui.SpenScrollView.scrollChangedListener
            public void scrollChanged(int scrollY) {
                RelativeLayout.LayoutParams PaletteBgParam;
                SpenSettingPenLayout.this.mScrollY = scrollY;
                if (SpenSettingPenLayout.this.mPenAlphaSeekbarView.getVisibility() == 0) {
                    PaletteBgParam = new RelativeLayout.LayoutParams(-1, (SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(118.0f) - (SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(323.0f) - SpenSettingPenLayout.this.mBodyLayoutHeight)) + SpenSettingPenLayout.this.mScrollY);
                } else {
                    PaletteBgParam = new RelativeLayout.LayoutParams(-1, (SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(118.0f) - (SpenSettingPenLayout.this.mDrawableImg.getIntValueAppliedDensity(273.0f) - SpenSettingPenLayout.this.mBodyLayoutHeight)) + SpenSettingPenLayout.this.mScrollY);
                }
                PaletteBgParam.setMargins(0, 0, 0, 0);
                if (PaletteBgParam.height >= 0) {
                    SpenSettingPenLayout.this.mPaletteBg.setLayoutParams(PaletteBgParam);
                }
            }
        };
        this.mCurrentBeautifyAdvanceSettingValues = new int[][]{new int[]{11, 2, 5, 8, 1, 15, 70, 11, 0, 1}, new int[]{12, 2, 5, 1, 1, 18, 70, 13, 0, 1}, new int[]{5, 2, 2, 2, 1, 18, 70, 5, 0, 1}, new int[]{6, 2, 3, 3, 1, 12, 70, 6, 0, 1}, new int[]{1, 2, 2, 8, 1, 15, 70, 3, 0, 1}, new int[]{3, 1, 3, 5, 1, 12, 70, 1, 0, 1}};
        this.requestLayoutDisable = false;
        this.mEnablePresetSave = true;
        this.mBgTransparent = false;
        mScale = ratio;
        this.mDrawableImg = new SPenImageUtil(context, customImagePath, ratio);
        this.mStringUtil = new SPenTextUtil(context);
        this.mImageLoader = new SpenImageLoader(this.mDrawableImg);
        this.mContext = context;
        this.mCanvasLayout = relativeLayout;
        this.mCanvasLayout.addOnLayoutChangeListener(this.mLayoutChangeListener);
        this.mBodyLayoutHeight = -2;
        this.mPluginManager = SpenPluginManager.getInstance(context);
        if (this.mPluginManager != null) {
            initPenPlugin(context);
        }
        this.mSupportBeautifyPen = false;
        this.mSettingInfo = new SpenSettingPenInfo();
        initView(customImagePath);
        setListener();
        this.mMovableRect = new Rect();
        this.mOldMovableRect = new Rect();
        this.mOldLocation = new int[2];
        this.localDisplayMetrics = context.getResources().getDisplayMetrics();
    }

    private void totalLayout() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(250.0f), -2);
        setLayoutParams(layoutParams);
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
        this.mLine2Button = lineButton2();
        this.mPresetAddButton = presetAddButton();
        this.mLine1Button = lineButton1();
        layout.addView(titleBg());
        layout.addView(titleText());
        layout.addView(this.mLine1Button);
        layout.addView(this.mLine2Button);
        layout.addView(this.mExitButton);
        layout.addView(this.mPresetAddButton);
        this.mPresetAddButton.setId(IB_PEN_ADD_ID);
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
        relativeLayout.setOnHoverListener(this.mOnConsumedHoverListener);
        this.mIndicator.setVisibility(8);
        return relativeLayout;
    }

    private View titleText() {
        this.mTitleView = new TextView(this.mContext);
        this.mTitleView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mTitleView.setTextColor(-1);
        this.mTitleView.setGravity(19);
        this.mTitleView.setFocusable(true);
        this.mTitleView.setSingleLine(true);
        this.mTitleView.setEllipsize(TextUtils.TruncateAt.END);
        this.mTitleView.setText(this.mStringUtil.setString("string_pen_settings"));
        this.mTitleView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(16.0f));
        this.mTitleView.setTypeface(Typeface.SANS_SERIF);
        this.mTitleView.setContentDescription(this.mStringUtil.setString("string_pen_settings"));
        this.mTitleView.setPadding(this.mDrawableImg.getIntValueAppliedDensity(10.0f) + 9, 15, 0, 0);
        return this.mTitleView;
    }

    private RelativeLayout bodyLayout() {
        RelativeLayout layout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(250.0f), -2);
        layout.setLayoutParams(layoutParams);
        this.mPenLayout = penLayout();
        this.mPresetLayout = presetLayout();
        this.mBodyBg = bodyBg();
        layout.addView(this.mBodyBg);
        layout.addView(this.mPenLayout);
        layout.addView(this.mPresetLayout);
        this.mBottomLayout = bottomLayout();
        this.mBottomLayout.setContentDescription(this.mStringUtil.setString("string_resize"));
        layout.addView(this.mBottomLayout);
        return layout;
    }

    private ViewGroup bodyBg() {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setLayoutParams(layoutParams);
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
        relativeLayout.setOnHoverListener(this.mOnConsumedHoverListener);
        relativeLayout.addView(bodyLeft);
        relativeLayout.addView(bodyRight);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getMovableRect() {
        int[] location = new int[2];
        Rect r = new Rect();
        if (this.mCanvasLayout != null) {
            this.mCanvasLayout.getLocationOnScreen(location);
            r.left = location[0] + this.mLeftMargin;
            r.top = location[1] + this.mTopMargin;
            r.right = location[0] + this.mCanvasLayout.getWidth();
            r.bottom = location[1] + this.mCanvasLayout.getHeight();
        }
        return r;
    }

    public void close() {
        this.mBgTransparent = false;
        if (this.mEnablePresetSave) {
            savePreferences();
        }
        if (this.mDrawableImg != null) {
            if (this.mPenPluginInfoList != null && this.mSettingInfo != null && this.mPluginManager != null) {
                for (int i = 0; i < this.mPenPluginCount; i++) {
                    this.mSettingInfo.name = this.mPenPluginInfoList.get(i).getPenName();
                    if (this.mPenPluginInfoList.get(i).getPenPluginObject() != null) {
                        this.mPenPluginInfoList.get(i).getPenPluginObject().setBitmap(null);
                        this.mPluginManager.unloadPlugin(this.mPenPluginInfoList.get(i).getPenPluginObject());
                    }
                }
            }
            if (this.mPenPluginInfoList != null) {
                Iterator<SpenPenPluginInfo> it = this.mPenPluginInfoList.iterator();
                while (it.hasNext()) {
                    SpenPenPluginInfo pluginInfo = it.next();
                    pluginInfo.close();
                }
                this.mPenPluginInfoList.clear();
                this.mPenPluginInfoList = null;
            }
            if (this.mPenDataList != null) {
                this.mPenDataList.clear();
                this.mPenDataList = null;
            }
            if (mPresetInfoList != null) {
                for (int i2 = 0; i2 < mPresetInfoList.size(); i2++) {
                    SpenPenPresetInfo presetInfo = mPresetInfoList.get(i2);
                    presetInfo.close();
                }
                mPresetInfoList.clear();
                mPresetInfoList = null;
            }
            if (this.mPresetListAdapter != null) {
                this.mPresetListAdapter.close();
                this.mPresetListAdapter = null;
            }
            this.mDrawableImg.unbindDrawables(this.mScrollView);
            this.mScrollView = null;
            if (this.mPenPreview != null) {
                this.mPenPreview.close();
                this.mDrawableImg.unbindDrawables(this.mPenPreview);
                this.mPenPreview = null;
            }
            this.mDrawableImg.unbindDrawables(this.mPenTypeLayout);
            this.mPenTypeLayout = null;
            this.mDrawableImg.unbindDrawables(this.mPenAlphaSeekbar);
            this.mPenAlphaSeekbar = null;
            this.mDrawableImg.unbindDrawables(this.mPenSizeSeekbar);
            this.mPenSizeSeekbar = null;
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
            this.mDrawableImg.unbindDrawables(this.mPenAlphaSeekbarView);
            this.mPenAlphaSeekbarView = null;
            this.mDrawableImg.unbindDrawables(this.mBottomLayout);
            this.mBottomLayout = null;
            this.mDrawableImg.unbindDrawables(this.mExitButton);
            this.mExitButton = null;
            this.mDrawableImg.unbindDrawables(this.mPenSizeSeekbarView);
            this.mPenSizeSeekbarView = null;
            this.mDrawableImg.unbindDrawables(this.mPreviewLayout);
            this.mPreviewLayout = null;
            this.mDrawableImg.unbindDrawables(this.mColorSelectPickerLayout);
            this.mColorSelectPickerLayout = null;
            this.mDrawableImg.unbindDrawables(this.mPenSeekbarLayout);
            this.mPenSeekbarLayout = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyEnableTextView);
            this.mBeautifyEnableTextView = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyEnableSwitchView);
            this.mBeautifyEnableSwitchView = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyEnableLayout);
            this.mBeautifyEnableLayout = null;
            if (this.mBeautifyStyleBtnViews != null) {
                for (int i3 = 0; i3 < this.mBeautifyStyleBtnViews.size(); i3++) {
                    ImageButton styleBtn = this.mBeautifyStyleBtnViews.get(i3);
                    this.mDrawableImg.unbindDrawables(styleBtn);
                }
                this.mBeautifyStyleBtnViews.clear();
                this.mBeautifyStyleBtnViews = null;
            }
            this.mDrawableImg.unbindDrawables(this.mBeautifyStyleBtnsLayout);
            this.mBeautifyStyleBtnsLayout = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyCursiveTextView);
            this.mBeautifyCursiveTextView = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifySustenanceTextView);
            this.mBeautifySustenanceTextView = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyDummyTextView);
            this.mBeautifyDummyTextView = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyModulationTextView);
            this.mBeautifyModulationTextView = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyAdvanceCursiveSeekbar);
            this.mBeautifyAdvanceCursiveSeekbar = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyAdvanceSustenanceSeekbar);
            this.mBeautifyAdvanceSustenanceSeekbar = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyAdvanceDummySeekbar);
            this.mBeautifyAdvanceDummySeekbar = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyAdvanceModulationSeekbar);
            this.mBeautifyAdvanceModulationSeekbar = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyAdvanceCursivePlusButton);
            this.mBeautifyAdvanceCursivePlusButton = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyAdvanceSustenancePlusButton);
            this.mBeautifyAdvanceSustenancePlusButton = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyAdvanceDummyPlusButton);
            this.mBeautifyAdvanceDummyPlusButton = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyAdvanceModulationPlusButton);
            this.mBeautifyAdvanceModulationPlusButton = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyAdvanceCursiveMinusButton);
            this.mBeautifyAdvanceCursiveMinusButton = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyAdvanceSustenanceMinusButton);
            this.mBeautifyAdvanceSustenanceMinusButton = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyAdvanceDummyMinusButton);
            this.mBeautifyAdvanceDummyMinusButton = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyAdvanceModulationMinusButton);
            this.mBeautifyAdvanceModulationMinusButton = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyAdvanceResetButton);
            this.mBeautifyAdvanceResetButton = null;
            this.mDrawableImg.unbindDrawables(this.mBeautifyAdvanceSettingLayout);
            this.mBeautifyAdvanceSettingLayout = null;
            this.mDrawableImg.unbindDrawables(this.mPresetGridView);
            this.mPresetGridView = null;
            this.mDrawableImg.unbindDrawables(this.mPresetTextView);
            this.mPresetTextView = null;
            this.mDrawableImg.unbindDrawables(this.mPresetLayout);
            this.mPresetLayout = null;
            this.mDrawableImg.unbindDrawables(this.mPresetAddButton);
            this.mPresetAddButton = null;
            this.mDrawableImg.unbindDrawables(this.mColorPickerColorImage);
            this.mColorPickerColorImage = null;
            this.mDrawableImg.unbindDrawables(this.mColorPickerCurrentColor);
            this.mColorPickerCurrentColor = null;
            this.mDrawableImg.unbindDrawables(this.mColorPickerSettingExitButton);
            this.mColorPickerSettingExitButton = null;
            this.mDrawableImg.unbindDrawables(this.mPenTypeHorizontalScrollView);
            this.mPenTypeHorizontalScrollView = null;
            this.mDrawableImg.unbindDrawables(this.mTitleLayout);
            this.mTitleLayout = null;
            this.mDrawableImg.unbindDrawables(this.mBodyBg);
            this.mBodyBg = null;
            this.mDrawableImg.unbindDrawables(this.mBodyLayout);
            this.mBodyLayout = null;
            this.mColorPickerSetting.close();
            this.mDrawableImg.unbindDrawables(this.mColorPickerSetting);
            this.mColorPickerSetting = null;
            if (this.mPenTypeView != null) {
                this.mPenTypeView.clear();
                this.mPenTypeView = null;
            }
            mDefaultPath = null;
            this.mPenSizeSeekbarColor = null;
            this.mPenAlphaSeekbarColor = null;
            this.mCursiveSeekbarColor = null;
            this.mSustenanceSeekbarColor = null;
            this.mDummySeekbarColor = null;
            this.mModulationSeekbarColor = null;
            this.mGestureDetector = null;
            this.mPresetListener = null;
            this.mActionListener = null;
            this.mSeekBarChangeListener = null;
            this.mVisibilityListener = null;
            this.mSettingInfo = null;
            this.mContext = null;
            this.mCanvasLayout = null;
            this.mCanvasView = null;
            this.mDrawableImg.unbindDrawables(this);
            this.mDrawableImg = null;
            this.mImageLoader.close();
            this.mImageLoader = null;
        }
    }

    protected void initView(String customImagePath) {
        this.mPenSharedPreferencesManager = new SpenSharedPreferencesManager(this.mContext, this.mPenPluginInfoList, mScale);
        this.mPenDataList = this.mPenSharedPreferencesManager.getPenDataList();
        mPresetInfoList = this.mPenSharedPreferencesManager.getPresetData();
        if (mPresetInfoList == null) {
            mPresetInfoList = new ArrayList();
        }
        if (this.mPenDataList == null) {
            this.mPenDataList = new ArrayList();
        }
        this.mPresetListAdapter = new SpenPenPresetListAdapter(this.mContext, 0, mPresetInfoList, customImagePath, this.mPenPluginInfoList, mScale);
        this.mPresetListAdapter.setPenPlugin(this.mPenPluginManager);
        totalLayout();
        findMinValue(this.mTitleView, this.mDrawableImg.getIntValueAppliedDensity(166.0f));
        if (this.mPresetGridView != null) {
            this.mPresetGridView.setAdapter((ListAdapter) this.mPresetListAdapter);
        }
        this.localPenTypeViewGroup = (RelativeLayout) this.mPenTypeHorizontalScrollView.getChildAt(0);
        for (int i = 0; i < this.localPenTypeViewGroup.getChildCount() - 1; i++) {
            this.mPenTypeView.add(this.localPenTypeViewGroup.getChildAt(i));
        }
        if (this.mPenButton != null && this.mPresetButton != null) {
            this.mPenButton.setOnClickListener(this.mTabSelectListener);
            this.mPresetButton.setOnClickListener(this.mTabSelectListener);
            this.mPenButton.setSelected(true);
            this.mPresetButton.setSelected(false);
        }
        showBeautifySettingViews(false);
        initColorSelecteView();
        ColorPickerSettingInit();
        this.mPresetListAdapter.notifyDataSetChanged();
        presetDisplay();
        setVisibility(8);
    }

    public void loadPreferences() throws NumberFormatException {
        if (this.mPenSharedPreferencesManager != null && this.mPenPluginManager != null && this.mPenTypeView != null && this.mSettingInfo != null) {
            String currentPenName = this.mPenSharedPreferencesManager.getCurrentPenName();
            int penTypeViewIndex = this.mPenPluginManager.getPenPluginIndexByPenName(currentPenName);
            if (penTypeViewIndex < 0) {
                this.mPenSharedPreferencesManager.removeCurrentPenData();
                penTypeViewIndex = 1;
            }
            if (this.mBgTransparent && penTypeViewIndex == 5) {
                penTypeViewIndex = 1;
            }
            penSelection(this.mPenTypeView.get(penTypeViewIndex));
            this.mPenSharedPreferencesManager.clearSharedPenData();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void savePreferences() throws java.io.IOException {
        /*
            r9 = this;
            com.samsung.android.sdk.pen.settingui.SpenSharedPreferencesManager r6 = r9.mPenSharedPreferencesManager
            if (r6 == 0) goto L10
            com.samsung.android.sdk.pen.SpenSettingPenInfo r6 = r9.mSettingInfo
            if (r6 == 0) goto L10
            java.util.ArrayList<com.samsung.android.sdk.pen.settingui.SpenPenPluginInfo> r6 = r9.mPenPluginInfoList
            if (r6 == 0) goto L10
            com.samsung.android.sdk.pen.settingui.SpenPenPluginManager r6 = r9.mPenPluginManager
            if (r6 != 0) goto L11
        L10:
            return
        L11:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList<com.samsung.android.sdk.pen.settingui.SpenPenPluginInfo> r6 = r9.mPenPluginInfoList
            java.util.Iterator r1 = r6.iterator()
            r3 = 0
        L1d:
            java.util.ArrayList<com.samsung.android.sdk.pen.settingui.SpenPenPluginInfo> r6 = r9.mPenPluginInfoList
            int r6 = r6.size()
            if (r3 < r6) goto L50
        L25:
            com.samsung.android.sdk.pen.settingui.SpenSharedPreferencesManager r6 = r9.mPenSharedPreferencesManager
            if (r6 == 0) goto L10
            com.samsung.android.sdk.pen.SpenSettingPenInfo r6 = r9.mSettingInfo
            if (r6 == 0) goto L10
            com.samsung.android.sdk.pen.settingui.SpenSharedPreferencesManager r6 = r9.mPenSharedPreferencesManager
            r6.setPenDataList(r4)
            com.samsung.android.sdk.pen.settingui.SpenSharedPreferencesManager r6 = r9.mPenSharedPreferencesManager
            com.samsung.android.sdk.pen.SpenSettingPenInfo r7 = r9.mSettingInfo
            java.lang.String r7 = r7.name
            r6.setCurrentPenName(r7)
            java.util.List<com.samsung.android.sdk.pen.settingui.SpenPenPresetInfo> r6 = com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.mPresetInfoList
            if (r6 == 0) goto L10
            r0 = 0
        L40:
            java.util.List<com.samsung.android.sdk.pen.settingui.SpenPenPresetInfo> r6 = com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.mPresetInfoList
            int r6 = r6.size()
            if (r0 < r6) goto L99
            com.samsung.android.sdk.pen.settingui.SpenSharedPreferencesManager r6 = r9.mPenSharedPreferencesManager
            java.util.List<com.samsung.android.sdk.pen.settingui.SpenPenPresetInfo> r7 = com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.mPresetInfoList
            r6.setPresetData(r7)
            goto L10
        L50:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L25
            java.lang.Object r5 = r1.next()
            com.samsung.android.sdk.pen.settingui.SpenPenPluginInfo r5 = (com.samsung.android.sdk.pen.settingui.SpenPenPluginInfo) r5
            com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface r6 = r5.getPenPluginObject()
            if (r6 != 0) goto L76
            com.samsung.android.sdk.pen.settingui.SpenPenPluginManager r6 = r9.mPenPluginManager
            android.content.Context r7 = r9.mContext
            java.lang.String r8 = r5.getPenName()
            r6.loadPenPlugin(r7, r8)
            com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface r6 = r5.getPenPluginObject()
            if (r6 != 0) goto L76
        L73:
            int r3 = r3 + 1
            goto L1d
        L76:
            com.samsung.android.sdk.pen.SpenSettingPenInfo r2 = new com.samsung.android.sdk.pen.SpenSettingPenInfo
            r2.<init>()
            java.lang.String r6 = r5.getPenName()
            r2.name = r6
            com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface r6 = r5.getPenPluginObject()
            float r6 = r6.getSize()
            r2.size = r6
            com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface r6 = r5.getPenPluginObject()
            int r6 = r6.getColor()
            r2.color = r6
            r4.add(r2)
            goto L73
        L99:
            java.util.List<com.samsung.android.sdk.pen.settingui.SpenPenPresetInfo> r6 = com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.mPresetInfoList
            java.lang.Object r6 = r6.get(r0)
            com.samsung.android.sdk.pen.settingui.SpenPenPresetInfo r6 = (com.samsung.android.sdk.pen.settingui.SpenPenPresetInfo) r6
            r6.setPresetOrder(r0)
            int r0 = r0 + 1
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.savePreferences():void");
    }

    private void setListener() {
        if (this.mTitleLayout != null) {
            this.mTitleLayout.setOnTouchListener(this.mOnTouchListener);
        }
        if (this.mExitButton != null) {
            this.mExitButton.setOnClickListener(this.mExitButtonListener);
        }
        if (this.mPenTypeView != null) {
            for (int i = 0; i < this.mPenTypeView.size(); i++) {
                if (this.mPenTypeView.get(i) != null) {
                    this.mPenTypeView.get(i).setOnClickListener(this.mPenTypeListner);
                }
            }
        }
        if (this.mPenSizeSeekbar != null) {
            this.mPenSizeSeekbar.setOnSeekBarChangeListener(this.mPenSizeChangeListner);
            this.mPenSizeSeekbar.setOnKeyListener(this.mPenSizeKeyListener);
        }
        if (this.mPenAlphaSeekbar != null) {
            this.mPenAlphaSeekbar.setOnSeekBarChangeListener(this.mPenAlphaChangeListner);
            this.mPenAlphaSeekbar.setOnKeyListener(this.mPenAlphaKeyListener);
            this.mPenAlphaSeekbar.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.80
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View v, boolean hasFocus) {
                    if (SpenSettingPenLayout.this.isMagicPenEnable) {
                        SpenSettingPenLayout.this.handler.postAtFrontOfQueue(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.80.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SpenSettingPenLayout.this.alphaDrawable.setAlpha(SpenSettingPenLayout.this.mPenAlpha);
                            }
                        });
                    }
                }
            });
        }
        if (this.mColorGradationView != null) {
            this.mColorGradationView.setColorPickerColorChangeListener(this.mColorPickerColorChangeListener);
        }
        if (this.mBottomLayout != null) {
            this.mBottomLayout.setOnTouchListener(this.mExpendBarListener);
            this.mBottomLayout.setOnHoverListener(this.mExpendBarHoverListener);
        }
        if (this.mPenSizePlusButton != null) {
            this.mPenSizePlusButton.setOnClickListener(this.mPenSizePlusButtonListener);
            this.mPenSizePlusButton.setOnLongClickListener(this.mPenSizePlusButtonLongClickListener);
            this.mPenSizePlusButton.setOnTouchListener(this.mPenSizePlusButtonTouchListener);
            this.mPenSizePlusButton.setOnKeyListener(this.mPenSizePlusButtonKeyListener);
        }
        if (this.mPenSizeMinusButton != null) {
            this.mPenSizeMinusButton.setOnClickListener(this.mPenSizeMinusButtonListener);
            this.mPenSizeMinusButton.setOnLongClickListener(this.mPenSizeMinusButtonLongClickListener);
            this.mPenSizeMinusButton.setOnTouchListener(this.mPenSizeMinusButtonTouchListener);
            this.mPenSizeMinusButton.setOnKeyListener(this.mPenSizeMinusButtonKeyListener);
        }
        if (this.mOpacityPlusButton != null) {
            this.mOpacityPlusButton.setOnClickListener(this.mPenAlphaPlusButtonListener);
            this.mOpacityPlusButton.setOnLongClickListener(this.mPenAlphaPlusButtonLongClickListener);
            this.mOpacityPlusButton.setOnTouchListener(this.mPenAlphaPlusButtonTouchListener);
            this.mOpacityPlusButton.setOnKeyListener(this.mPenAlphaPlusButtonKeyListener);
        }
        if (this.mOpacityMinusButton != null) {
            this.mOpacityMinusButton.setOnClickListener(this.mPenAlphaMinusButtonListener);
            this.mOpacityMinusButton.setOnLongClickListener(this.mPenAlphaMinusButtonLongClickListener);
            this.mOpacityMinusButton.setOnTouchListener(this.mPenAlphaMinusButtonTouchListener);
            this.mOpacityMinusButton.setOnKeyListener(this.mPenAlphaMinusButtonKeyListener);
        }
        if (this.mPaletteRightButton != null) {
            this.mPaletteRightButton.setOnClickListener(this.mPaletteNextButtonListener);
        }
        if (this.mPaletteLeftButton != null) {
            this.mPaletteLeftButton.setOnClickListener(this.mPaletteBackButtonListener);
        }
        if (this.mPresetAddButton != null) {
            this.mPresetAddButton.setOnClickListener(this.mPreSetAddButtonListner);
        }
        if (this.mAdvancedSettingButton != null) {
            this.mAdvancedSettingButton.setOnClickListener(this.mAdvancedSettingButtonListner);
        }
        if (this.mPresetListAdapter != null) {
            this.mPresetListAdapter.OnClickPresetItemListener(this.mOnClickPresetItemListener);
        }
        this.mGestureDetector = new GestureDetector(this.mContext, this.mGestureListener);
        if (this.mBeautifyEnableSwitchView != null) {
            this.mBeautifyEnableSwitchView.setOnCheckedChangeListener(this.mBeautifyEnablecheckedChangeListener);
        }
        if (this.mBeautifyStyleBtnViews != null) {
            for (int styleIndex = 0; styleIndex < this.mBeautifyStyleBtnViews.size(); styleIndex++) {
                ImageButton styleBtn = this.mBeautifyStyleBtnViews.get(styleIndex);
                styleBtn.setOnClickListener(this.mBeautifyStyleBtnsListener);
            }
        }
        if (this.mBeautifyAdvanceCursiveSeekbar != null) {
            this.mBeautifyAdvanceCursiveSeekbar.setOnSeekBarChangeListener(this.mBeautifyAdvanceCursiveChangeListner);
            this.mBeautifyAdvanceCursiveSeekbar.setOnKeyListener(this.mBeautifyAdvanceCursiveKeyListner);
        }
        if (this.mBeautifyAdvanceSustenanceSeekbar != null) {
            this.mBeautifyAdvanceSustenanceSeekbar.setOnSeekBarChangeListener(this.mBeautifyAdvanceSustenanceChangeListner);
            this.mBeautifyAdvanceSustenanceSeekbar.setOnKeyListener(this.mBeautifyAdvanceSustenanceKeyListner);
        }
        if (this.mBeautifyAdvanceDummySeekbar != null) {
            this.mBeautifyAdvanceDummySeekbar.setOnSeekBarChangeListener(this.mBeautifyAdvanceDummyChangeListner);
            this.mBeautifyAdvanceDummySeekbar.setOnKeyListener(this.mBeautifyAdvanceDummyKeyListner);
        }
        if (this.mBeautifyAdvanceModulationSeekbar != null) {
            this.mBeautifyAdvanceModulationSeekbar.setOnSeekBarChangeListener(this.mBeautifyAdvanceModulationChangeListner);
            this.mBeautifyAdvanceModulationSeekbar.setOnKeyListener(this.mBeautifyAdvanceModulationKeyListner);
        }
        if (this.mBeautifyAdvanceCursivePlusButton != null) {
            this.mBeautifyAdvanceCursivePlusButton.setOnClickListener(this.mBeautifyAdvanceCursivePlusButtonListener);
            this.mBeautifyAdvanceCursivePlusButton.setOnLongClickListener(this.mBeautifyAdvanceCursivePlusButtonLongClickListener);
            this.mBeautifyAdvanceCursivePlusButton.setOnTouchListener(this.mBeautifyAdvanceCursivePlusButtonTouchListener);
        }
        if (this.mBeautifyAdvanceSustenancePlusButton != null) {
            this.mBeautifyAdvanceSustenancePlusButton.setOnClickListener(this.mBeautifyAdvanceSustenancePlusButtonListener);
            this.mBeautifyAdvanceSustenancePlusButton.setOnLongClickListener(this.mBeautifyAdvanceSustenancePlusButtonLongClickListener);
            this.mBeautifyAdvanceSustenancePlusButton.setOnTouchListener(this.mBeautifyAdvanceSustenancePlusButtonTouchListener);
        }
        if (this.mBeautifyAdvanceDummyPlusButton != null) {
            this.mBeautifyAdvanceDummyPlusButton.setOnClickListener(this.mBeautifyAdvanceDummyPlusButtonListener);
            this.mBeautifyAdvanceDummyPlusButton.setOnLongClickListener(this.mBeautifyAdvanceDummyPlusButtonLongClickListener);
            this.mBeautifyAdvanceDummyPlusButton.setOnTouchListener(this.mBeautifyAdvanceDummyPlusButtonTouchListener);
        }
        if (this.mBeautifyAdvanceModulationPlusButton != null) {
            this.mBeautifyAdvanceModulationPlusButton.setOnClickListener(this.mBeautifyAdvanceModulationPlusButtonListener);
            this.mBeautifyAdvanceModulationPlusButton.setOnLongClickListener(this.mBeautifyAdvanceModulationPlusButtonLongClickListener);
            this.mBeautifyAdvanceModulationPlusButton.setOnTouchListener(this.mBeautifyAdvanceModulationPlusButtonTouchListener);
        }
        if (this.mBeautifyAdvanceCursiveMinusButton != null) {
            this.mBeautifyAdvanceCursiveMinusButton.setOnClickListener(this.mBeautifyAdvanceCursiveMinusButtonListener);
            this.mBeautifyAdvanceCursiveMinusButton.setOnLongClickListener(this.mBeautifyAdvanceCursiveMinusButtonLongClickListener);
            this.mBeautifyAdvanceCursiveMinusButton.setOnTouchListener(this.mBeautifyAdvanceCursiveMinusButtonTouchListener);
        }
        if (this.mBeautifyAdvanceSustenanceMinusButton != null) {
            this.mBeautifyAdvanceSustenanceMinusButton.setOnClickListener(this.mBeautifyAdvanceSustenanceMinusButtonListener);
            this.mBeautifyAdvanceSustenanceMinusButton.setOnLongClickListener(this.mBeautifyAdvanceSustenanceMinusButtonLongClickListener);
            this.mBeautifyAdvanceSustenanceMinusButton.setOnTouchListener(this.mBeautifyAdvanceSustenanceMinusButtonTouchListener);
        }
        if (this.mBeautifyAdvanceDummyMinusButton != null) {
            this.mBeautifyAdvanceDummyMinusButton.setOnClickListener(this.mBeautifyAdvanceDummyMinusButtonListener);
            this.mBeautifyAdvanceDummyMinusButton.setOnLongClickListener(this.mBeautifyAdvanceDummyMinusButtonLongClickListener);
            this.mBeautifyAdvanceDummyMinusButton.setOnTouchListener(this.mBeautifyAdvanceDummyMinusButtonTouchListener);
        }
        if (this.mBeautifyAdvanceModulationMinusButton != null) {
            this.mBeautifyAdvanceModulationMinusButton.setOnClickListener(this.mBeautifyAdvanceModulationMinusButtonListener);
            this.mBeautifyAdvanceModulationMinusButton.setOnLongClickListener(this.mBeautifyAdvanceModulationMinusButtonlongClickListener);
            this.mBeautifyAdvanceModulationMinusButton.setOnTouchListener(this.mBeautifyAdvanceModulationMinusButtonTouchListener);
        }
        if (this.mBeautifyAdvanceResetButton != null) {
            this.mBeautifyAdvanceResetButton.setOnClickListener(this.mBeautifyAdvanceResetButtonListener);
        }
        if (this.mScrollView != null) {
            this.mScrollView.setOnScrollChangedListener(this.mScrollViewListner);
        }
        this.mPenTypeHorizontalScrollView2.setOnTouchListener(this.horizontalScrollViewTouchListener);
    }

    private void ColorPickerSettingInit() {
        this.mColorPickerSetting = new SpenColorPickerLayout(this.mContext, this.mCanvasLayout, mScale, 0, 0);
        if (this.mColorPickerSetting != null) {
            this.mColorPickerSettingExitButton = this.mColorPickerSetting.mColorPickerdExitBtn;
            this.mColorPickerSettingExitButton.setOnClickListener(this.mExitButtonListener);
            this.mColorPickerColorImage = this.mColorPickerSetting.mColorPickerColorImage;
            this.mColorPickerCurrentColor = this.mColorPickerSetting.mColorPickerCurrentColor;
            this.mColorPickerCurrentColor.setOnClickListener(this.mColorPickerCurrentColorListener);
        }
    }

    private void initColorSelecteView() {
        if (this.mColorPaletteView != null) {
            this.mColorPaletteView.setInitialValue(this.mOnColorChangedListener, 0);
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

    public void setColorPickerPosition(int x, int y) {
        if (this.mColorPickerSetting != null) {
            this.mColorPickerSetting.movePosition(x, y);
        }
    }

    public void setPosition(int x, int y) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) getLayoutParams();
        params.leftMargin = x;
        params.topMargin = y;
        this.mCurrentTopMargin = y;
        setLayoutParams(params);
    }

    private void findMinValue(TextView v, int maxWidth) {
        float currentFloat = 16.0f;
        while (true) {
            v.measure(0, 0);
            int width = v.getMeasuredWidth();
            if (width > maxWidth) {
                currentFloat -= 1.0f;
                v.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(currentFloat));
            } else {
                v.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(currentFloat));
                return;
            }
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
        exitButton.setContentDescription(this.mStringUtil.setString("string_close"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(exitButton, exitPath, exitPressPath, exitfocusPath, 38, 36);
        return exitButton;
    }

    private View presetAddButton() {
        ImageButton presetButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams presetButtonParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(38.0f), this.mDrawableImg.getIntValueAppliedDensity(36.0f));
        presetButtonParams.addRule(11);
        presetButtonParams.topMargin = 15;
        presetButtonParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(39.0f) + 9;
        presetButton.setLayoutParams(presetButtonParams);
        presetButton.setFocusable(true);
        presetButton.setContentDescription(this.mStringUtil.setString("string_add_preset"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(presetButton, presetAddPath, presetAddPressPath, presetAddFocusPath, 38, 36);
        return presetButton;
    }

    private View lineButton1() {
        ImageView lineView = new ImageView(this.mContext);
        RelativeLayout.LayoutParams presetButtonParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(1.0f), this.mDrawableImg.getIntValueAppliedDensity(19.0f));
        presetButtonParams.addRule(11);
        presetButtonParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(9.0f) + 15;
        presetButtonParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(77.0f) + 9;
        presetButtonParams.bottomMargin = this.mDrawableImg.getIntValueAppliedDensity(8.0f);
        lineView.setLayoutParams(presetButtonParams);
        this.mImageLoader.addViewSetBackgroundImageLoad(lineView, linePath);
        return lineView;
    }

    private View lineButton2() {
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

    private LinearLayout typeSelectorlayout() {
        LinearLayout typeButtonLayout = new LinearLayout(this.mContext);
        typeButtonLayout.setLayoutParams(new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(250.0f) - 10, this.mDrawableImg.getIntValueAppliedDensity(30.0f)));
        typeButtonLayout.setOrientation(0);
        this.mPenButtonLayout = penTypeButton();
        this.mTablineLayout = tabLine();
        this.mPresetTypeLayout = presetTypeButton();
        typeButtonLayout.addView(this.mPenButtonLayout);
        typeButtonLayout.addView(this.mTablineLayout);
        typeButtonLayout.addView(this.mPresetTypeLayout);
        return typeButtonLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setButtonFocus(View selectedButton) {
        if (selectedButton == this.mPenButton) {
            this.mPenButton.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(14.0f));
            this.mPenButton.setTypeface(Typeface.SANS_SERIF, 1);
            this.mPresetButton.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(13.0f));
            this.mPresetButton.setTypeface(Typeface.SANS_SERIF, 0);
            return;
        }
        this.mPresetButton.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(14.0f));
        this.mPresetButton.setTypeface(Typeface.SANS_SERIF, 1);
        this.mPenButton.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(13.0f));
        this.mPenButton.setTypeface(Typeface.SANS_SERIF, 0);
    }

    private View penTypeButton() {
        LinearLayout penButtonLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams penBtnLayoutParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(125.0f) - 9, this.mDrawableImg.getIntValueAppliedDensity(30.0f));
        penBtnLayoutParams.setMargins(10, 0, 0, 0);
        penButtonLayout.setLayoutParams(penBtnLayoutParams);
        penButtonLayout.setOrientation(1);
        this.mPenButton = new TextView(this.mContext);
        LinearLayout.LayoutParams fontButtonParams = new LinearLayout.LayoutParams(-1, -1);
        this.mPenButton.setLayoutParams(fontButtonParams);
        if (mSdkVersion < 16) {
            this.mPenButton.setBackgroundDrawable(this.mDrawableImg.setDrawableSelectedFocusImg(tabLinePath, tabLineSelectPath, tabLineSelectedFocusPath, tabLineUnselectedFocusPath));
        } else {
            this.mPenButton.setBackground(this.mDrawableImg.setDrawableSelectedFocusImg(tabLinePath, tabLineSelectPath, tabLineSelectedFocusPath, tabLineUnselectedFocusPath));
        }
        this.mPenButton.setSingleLine(true);
        this.mPenButton.setEllipsize(TextUtils.TruncateAt.END);
        this.mPenButton.setGravity(17);
        this.mPenButton.setText(this.mStringUtil.setString("string_pen"));
        penButtonLayout.setContentDescription(String.valueOf(this.mStringUtil.setString("string_pen_tab")) + this.mStringUtil.setString("string_selected"));
        int[] arrayOfStates1 = {-16842919, -16842913};
        int[] arrayOfStates2 = {R.attr.state_pressed};
        int[] arrayOfStates3 = {R.attr.state_selected};
        int[][] arrayOfStates = {arrayOfStates1, arrayOfStates2, arrayOfStates3};
        int[] textColor = {Color.rgb(0, 0, 0), Color.rgb(1, 139, ScreenSharePacket.SCREEN_SHARE_DOCS_CMD_PEN_MODE), Color.rgb(1, 139, ScreenSharePacket.SCREEN_SHARE_DOCS_CMD_PEN_MODE)};
        ColorStateList mTextColorStateList = new ColorStateList(arrayOfStates, textColor);
        this.mPenButton.setTextColor(mTextColorStateList);
        this.mPenButton.setClickable(true);
        this.mPenButton.setFocusable(true);
        this.mPenButton.setPadding(0, 0, 0, 0);
        this.mPenButton.setNextFocusUpId(IB_PEN_ADD_ID);
        penButtonLayout.addView(this.mPenButton);
        return penButtonLayout;
    }

    private View tabLine() {
        LinearLayout tabLineLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams tabLineParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(1.0f), this.mDrawableImg.getIntValueAppliedDensity(30.0f));
        tabLineLayout.setLayoutParams(tabLineParams);
        ImageView tabLineView = new ImageView(this.mContext);
        LinearLayout.LayoutParams tabLineViewParams = new LinearLayout.LayoutParams(-1, -1);
        tabLineView.setLayoutParams(tabLineViewParams);
        this.mImageLoader.addViewSetBackgroundImageLoad(tabLineView, tabBorderLinePath);
        tabLineLayout.addView(tabLineView);
        return tabLineLayout;
    }

    private View presetTypeButton() {
        LinearLayout presetTypeButtonLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams presetTypeButtonLayoutParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(125.0f) - 9, this.mDrawableImg.getIntValueAppliedDensity(30.0f));
        presetTypeButtonLayoutParams.setMargins(0, 0, 9, 0);
        presetTypeButtonLayout.setLayoutParams(presetTypeButtonLayoutParams);
        presetTypeButtonLayout.setOrientation(1);
        this.mPresetButton = new TextView(this.mContext);
        LinearLayout.LayoutParams presetTypeButtonParams = new LinearLayout.LayoutParams(-1, -1);
        this.mPresetButton.setLayoutParams(presetTypeButtonParams);
        if (mSdkVersion < 16) {
            this.mPresetButton.setBackgroundDrawable(this.mDrawableImg.setDrawableSelectedFocusImg(tabLinePath, tabLineSelectPath, tabLineSelectedFocusPath, tabLineUnselectedFocusPath));
        } else {
            this.mPresetButton.setBackground(this.mDrawableImg.setDrawableSelectedFocusImg(tabLinePath, tabLineSelectPath, tabLineSelectedFocusPath, tabLineUnselectedFocusPath));
        }
        this.mPresetButton.setSingleLine(true);
        this.mPresetButton.setEllipsize(TextUtils.TruncateAt.END);
        this.mPresetButton.setGravity(17);
        this.mPresetButton.setText(this.mStringUtil.setString("string_preset"));
        presetTypeButtonLayout.setContentDescription(String.valueOf(this.mStringUtil.setString("string_preset_tab")) + this.mStringUtil.setString("string_not_selected"));
        int[] arrayOfStates1 = {-16842919, -16842913};
        int[] arrayOfStates2 = {R.attr.state_pressed};
        int[] arrayOfStates3 = {R.attr.state_selected};
        int[][] arrayOfStates = {arrayOfStates1, arrayOfStates2, arrayOfStates3};
        int[] textColor = {Color.rgb(0, 0, 0), Color.rgb(28, 126, 196), Color.rgb(28, 126, 196)};
        ColorStateList mTextColorStateList = new ColorStateList(arrayOfStates, textColor);
        this.mPresetButton.setTextColor(mTextColorStateList);
        this.mPresetButton.setClickable(true);
        this.mPresetButton.setFocusable(true);
        this.mPresetButton.setPadding(0, 0, 0, 0);
        this.mPresetButton.setNextFocusUpId(IB_PEN_ADD_ID);
        presetTypeButtonLayout.addView(this.mPresetButton);
        return presetTypeButtonLayout;
    }

    private ViewGroup penLayout() {
        this.mScrollView = new SpenScrollView(this.mContext);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(0, this.mDrawableImg.getIntValueAppliedDensity(30.0f), 9, this.mDrawableImg.getIntValueAppliedDensity(16.0f));
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
        this.mPenTypeLayout = penTypeLayout();
        this.mColorSelectPickerLayout = colorPaletteGradationLayout();
        this.mBeautifyEnableLayout = beautifyEnableLayout();
        this.mBeautifyStyleBtnsLayout = beautifyStyleBtnsLayout();
        this.mPenSeekbarLayout = penSeekbarLayout();
        this.mTypeSelectorLayout = typeSelectorlayout();
        palletViewLayout.addView(this.mPenTypeLayout);
        palletViewLayout.addView(this.mBeautifyEnableLayout);
        palletViewLayout.addView(this.mBeautifyStyleBtnsLayout);
        palletViewLayout.addView(this.mPenSeekbarLayout);
        palletViewLayout.addView(this.mColorSelectPickerLayout);
        this.mScrollView.addView(palletViewLayout);
        RelativeLayout layout = new RelativeLayout(this.mContext);
        layout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        layout.addView(this.mTypeSelectorLayout);
        layout.addView(this.mScrollView);
        return layout;
    }

    private LinearLayout presetLayout() {
        LinearLayout layout = new LinearLayout(this.mContext);
        layout.setPadding(this.mDrawableImg.getIntValueAppliedDensity(15.0f), this.mDrawableImg.getIntValueAppliedDensity(30.0f), this.mDrawableImg.getIntValueAppliedDensity(4.0f), this.mDrawableImg.getIntValueAppliedDensity(16.0f));
        this.mPresetGridView = new GridView(this.mContext);
        LinearLayout.LayoutParams gridViewParams = new LinearLayout.LayoutParams(-1, -1);
        this.mPresetGridView.setLayoutParams(gridViewParams);
        this.mPresetGridView.setBackgroundColor(0);
        this.mPresetGridView.setCacheColorHint(0);
        this.mPresetGridView.setVerticalScrollBarEnabled(true);
        this.mPresetGridView.setHorizontalScrollBarEnabled(false);
        this.mPresetGridView.setVerticalSpacing(this.mDrawableImg.getIntValueAppliedDensity(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET));
        this.mPresetGridView.setHorizontalSpacing(this.mDrawableImg.getIntValueAppliedDensity(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET));
        this.mPresetGridView.setFocusable(false);
        this.mPresetGridView.setNumColumns(3);
        this.mPresetTextView = new TextView(this.mContext);
        LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(250.0f), this.mDrawableImg.getIntValueAppliedDensity(193.0f));
        textViewParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(-15.0f), 0, 0, 0);
        this.mPresetTextView.setLayoutParams(textViewParams);
        this.mPresetTextView.setTypeface(Typeface.SANS_SERIF);
        this.mPresetTextView.setTextColor(Color.rgb(94, 94, 94));
        this.mPresetTextView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(14.5f));
        this.mPresetTextView.setGravity(17);
        this.mPresetTextView.setText(this.mStringUtil.setString("string_no_preset"));
        this.mPresetTextView.setFocusable(false);
        this.mPresetTextView.setVisibility(8);
        this.mPresetTextView.setContentDescription(this.mStringUtil.setString("string_no_preset"));
        this.mPresetTextView.setPadding(0, 0, 0, 0);
        layout.addView(this.mPresetGridView);
        layout.addView(this.mPresetTextView);
        return layout;
    }

    private View beautifyEnableLayout() {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        LinearLayout.LayoutParams enableParam = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(39.0f));
        enableParam.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(6.5f);
        enableParam.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(5.5f);
        relativeLayout.setLayoutParams(enableParam);
        ImageView imgDivider = new ImageView(this.mContext);
        RelativeLayout.LayoutParams dividerParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(1.0f));
        dividerParams.alignWithParent = true;
        dividerParams.addRule(6);
        imgDivider.setLayoutParams(dividerParams);
        this.mImageLoader.addViewSetBackgroundImageLoad(imgDivider, lineDivider);
        relativeLayout.addView(imgDivider);
        this.mBeautifyEnableTextView = new TextView(this.mContext);
        RelativeLayout.LayoutParams titleParam = new RelativeLayout.LayoutParams(-1, -2);
        titleParam.alignWithParent = true;
        titleParam.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(13.5f);
        titleParam.addRule(9);
        titleParam.addRule(15);
        this.mBeautifyEnableTextView.setLayoutParams(titleParam);
        this.mBeautifyEnableTextView.setTypeface(Typeface.SANS_SERIF);
        this.mBeautifyEnableTextView.setTextColor(-16777216);
        this.mBeautifyEnableTextView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(15.0f));
        this.mBeautifyEnableTextView.setGravity(19);
        this.mBeautifyEnableTextView.setText(this.mStringUtil.setString("string_beutify"));
        this.mBeautifyEnableTextView.setFocusable(false);
        this.mBeautifyEnableTextView.setContentDescription(this.mStringUtil.setString("string_beutify"));
        this.mBeautifyEnableSwitchView = new Switch(this.mContext);
        int sdk = Build.VERSION.SDK_INT;
        RelativeLayout.LayoutParams switchParam = new RelativeLayout.LayoutParams(-2, this.mDrawableImg.getIntValueAppliedDensity(25.0f));
        switchParam.alignWithParent = true;
        switchParam.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(8.5f);
        switchParam.addRule(11);
        switchParam.addRule(15);
        this.mBeautifyEnableSwitchView.setLayoutParams(switchParam);
        if (sdk >= 16) {
            this.mBeautifyEnableSwitchView.setThumbDrawable(this.mDrawableImg.setDrawableImg(switchThumbPath, 24, 24));
            this.mBeautifyEnableSwitchView.setTrackDrawable(this.mDrawableImg.setDrawableCheckedImg(switchCheckFalseBgPath, switchCheckTrueBgPath, 46, 25));
            this.mBeautifyEnableSwitchView.setSwitchMinWidth(this.mDrawableImg.getIntValueAppliedDensity(46.0f));
            this.mBeautifyEnableSwitchView.setThumbTextPadding(1);
        }
        this.mBeautifyEnableSwitchView.setChecked(false);
        relativeLayout.addView(this.mBeautifyEnableTextView);
        relativeLayout.addView(this.mBeautifyEnableSwitchView);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBeautifySettingViews(boolean show) {
        showBeautifyStyleBtnsLayout(show);
        showAdvanceSettingLayout(show);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBeautifyEnableLayout(boolean show) {
        int visibility;
        if (show && this.mSupportBeautifyPen && hasBeautifyPen()) {
            visibility = 0;
        } else {
            visibility = 8;
        }
        if (this.mBeautifyEnableLayout != null && this.mBeautifyEnableLayout.getVisibility() != visibility) {
            this.mBeautifyEnableLayout.setVisibility(visibility);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBeautifyStyleBtnsLayout(boolean show) {
        int visibility;
        if (show && this.mSupportBeautifyPen && hasBeautifyPen()) {
            visibility = 0;
        } else {
            visibility = 8;
        }
        if (this.mBeautifyStyleBtnsLayout != null && this.mBeautifyStyleBtnsLayout.getVisibility() != visibility) {
            this.mBeautifyStyleBtnsLayout.setVisibility(visibility);
        }
    }

    private void showAdvanceSettingLayout(boolean show) {
        int visibility;
        if (show && this.mSupportBeautifyPen && hasBeautifyPen()) {
            visibility = 0;
        } else {
            visibility = 8;
        }
        if (this.mBeautifyAdvanceSettingLayout != null && this.mBeautifyAdvanceSettingLayout.getVisibility() != visibility) {
            this.mBeautifyAdvanceSettingLayout.setVisibility(visibility);
        }
    }

    private boolean hasBeautifyPen() {
        if (-1 >= this.mPenPluginManager.getPenPluginIndexByPenName(BEAUTIFY_PEN_NAME)) {
            return false;
        }
        return true;
    }

    private View beautifyStyleBtnsLayout() {
        LinearLayout containerLayout = new LinearLayout(this.mContext);
        ViewGroup.LayoutParams containerParam = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(43.0f));
        containerLayout.setLayoutParams(containerParam);
        containerLayout.setPadding(this.mDrawableImg.getIntValueAppliedDensity(11.0f), this.mDrawableImg.getIntValueAppliedDensity(6.0f), this.mDrawableImg.getIntValueAppliedDensity(11.0f), this.mDrawableImg.getIntValueAppliedDensity(4.0f));
        if (this.mBeautifyStyleBtnViews == null) {
            this.mBeautifyStyleBtnViews = new ArrayList<>();
        }
        for (int styleIndex = 0; styleIndex < 6; styleIndex++) {
            String defaultStyleImgPath = "chinabrush_mode_0" + (styleIndex + 1);
            String pressStyleImgPath = "chinabrush_mode_0" + (styleIndex + 1) + "_press";
            if (mDefaultPath != null) {
                defaultStyleImgPath = String.valueOf(mDefaultPath) + defaultStyleImgPath;
                pressStyleImgPath = String.valueOf(mDefaultPath) + pressStyleImgPath;
            }
            ImageButton styleBtn = new ImageButton(this.mContext);
            LinearLayout.LayoutParams styleBtnParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(38.0f), this.mDrawableImg.getIntValueAppliedDensity(33.0f));
            styleBtn.setLayoutParams(styleBtnParams);
            styleBtn.setPadding(this.mDrawableImg.getIntValueAppliedDensity(5.0f), this.mDrawableImg.getIntValueAppliedDensity(4.0f), this.mDrawableImg.getIntValueAppliedDensity(5.0f), this.mDrawableImg.getIntValueAppliedDensity(5.0f));
            styleBtn.setImageDrawable(this.mDrawableImg.setDrawableSelectImg(defaultStyleImgPath, pressStyleImgPath, pressStyleImgPath, 28, 24));
            this.mImageLoader.addViewBackgroundSelectableImageLoad(styleBtn, popupBtnBgNomalPath, popupBtnBgPressPath, popupBtnBgFocusPath, this.mDrawableImg.getIntValueAppliedDensity(38.0f), this.mDrawableImg.getIntValueAppliedDensity(33.0f));
            if (styleIndex == 0) {
                styleBtn.setSelected(true);
            }
            containerLayout.addView(styleBtn);
            this.mBeautifyStyleBtnViews.add(styleBtn);
        }
        ImageView imgDivider = new ImageView(this.mContext);
        RelativeLayout.LayoutParams dividerParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(1.0f));
        dividerParams.alignWithParent = true;
        dividerParams.addRule(6);
        imgDivider.setLayoutParams(dividerParams);
        dividerParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(6.0f);
        dividerParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(5.0f);
        this.mImageLoader.addViewSetBackgroundImageLoad(imgDivider, lineDivider);
        RelativeLayout relativeLayoutContainer = new RelativeLayout(this.mContext);
        relativeLayoutContainer.setLayoutParams(containerParam);
        relativeLayoutContainer.addView(imgDivider);
        relativeLayoutContainer.addView(containerLayout);
        return relativeLayoutContainer;
    }

    private int getBeautifyStyleBtnIndex(String advanceSetting) throws NumberFormatException {
        int styleId = getBeautifyAdvanceParamDataFromString(advanceSetting, 0);
        switch (styleId) {
        }
        return 0;
    }

    private void updateBeautifyStyleBtnFromString(String advanceSetting) throws NumberFormatException {
        int newStyleBtnIdx = getBeautifyStyleBtnIndex(advanceSetting);
        this.mCurrentBeautifyStyle = newStyleBtnIdx;
        for (int styleBtnIndex = 0; styleBtnIndex < this.mBeautifyStyleBtnViews.size(); styleBtnIndex++) {
            ImageButton styleBtn = this.mBeautifyStyleBtnViews.get(styleBtnIndex);
            if (newStyleBtnIdx == styleBtnIndex) {
                styleBtn.setSelected(true);
            } else {
                styleBtn.setSelected(false);
            }
        }
    }

    private View penSeekbarLayout() {
        LinearLayout localLinearLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLinearLayout.setLayoutParams(localLayoutParams);
        localLinearLayout.setPadding(this.mDrawableImg.getIntValueAppliedDensity(2.0f) + 9, 0, this.mDrawableImg.getIntValueAppliedDensity(2.0f) + 9, 0);
        localLinearLayout.setOrientation(1);
        this.mPenAlphaSeekbarView = penAlphaLayout();
        this.mPenSizeSeekbarView = penSizeLayout();
        this.mBeautifyAdvanceSettingLayout = beautifyAdvanceSettingSeekbars();
        localLinearLayout.addView(this.mPenSizeSeekbarView);
        localLinearLayout.addView(this.mPenAlphaSeekbarView);
        localLinearLayout.addView(this.mBeautifyAdvanceSettingLayout);
        return localLinearLayout;
    }

    private View preview() {
        RelativeLayout previewLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(75.0f));
        previewLayout.setLayoutParams(localLayoutParams);
        previewLayout.setBackgroundColor(0);
        this.mPenPreview = new SpenPenPreview(this.mContext);
        this.mPenPreview.setPenPlugin(this.mPenPluginManager);
        RelativeLayout.LayoutParams penPreviewLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        penPreviewLayoutParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(-5.8f), this.mDrawableImg.getIntValueAppliedDensity(-1.0f), this.mDrawableImg.getIntValueAppliedDensity(-3.0f), 0);
        this.mPenPreview.setLayoutParams(penPreviewLayoutParams);
        this.mPenPreview.setBackgroundColor(0);
        this.mPenAlphaPreview = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams penPreviewLayoutParams02 = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(10.0f));
        this.mPenAlphaPreview.setLayoutParams(penPreviewLayoutParams02);
        penPreviewLayoutParams02.addRule(9);
        penPreviewLayoutParams02.addRule(12);
        penPreviewLayoutParams02.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(18.0f);
        penPreviewLayoutParams02.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(2.0f);
        penPreviewLayoutParams02.bottomMargin = this.mDrawableImg.getIntValueAppliedDensity(5.0f);
        if (mSdkVersion < 16) {
            this.mPenAlphaPreview.setBackgroundDrawable(this.mDrawableImg.setDrawableImg(previewAlphaPath));
        } else {
            this.mPenAlphaPreview.setBackground(this.mDrawableImg.setDrawableImg(previewAlphaPath));
        }
        this.mPenAlphaPreview.setVisibility(8);
        previewLayout.addView(this.mPenAlphaPreview);
        previewLayout.addView(this.mPenPreview);
        this.mAdvancedSettingButton = advancedSettingButton();
        this.mAdvancedSettingButton.setVisibility(8);
        previewLayout.addView(this.mAdvancedSettingButton);
        return previewLayout;
    }

    private View advancedSettingButton() {
        ImageButton localImageButton = new ImageButton(this.mContext);
        FrameLayout.LayoutParams layoutParam = new FrameLayout.LayoutParams(-2, -2);
        localImageButton.setLayoutParams(layoutParam);
        localImageButton.setFocusable(true);
        localImageButton.setBackgroundDrawable(this.mDrawableImg.setDrawableSelectImg(mImagePath_snote_add, mImagePath_snote_add_press, mImagePath_snote_add_press, mImagePath_snote_add_dim));
        return localImageButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void penSelectIndex(int index) throws NumberFormatException {
        for (int i = 0; i < this.mPenPluginCount; i++) {
            if (index == this.mPenPluginManager.getPenPluginIndexByPenName("com.samsung.android.sdk.pen.pen.preload.MagicPen")) {
                this.mPenAlphaPreview.setVisibility(0);
                setMagicPenMode(Math.round(this.mBottomLayout.getY()));
                this.previousPenMagicSelected = true;
                this.alphaDrawable.setAlpha(this.mPenAlpha);
            } else {
                this.mPenAlphaPreview.setVisibility(8);
                if (this.previousPenMagicSelected) {
                    this.currenMagicPenHeight = Math.round(this.mBottomLayout.getY());
                }
                this.isMagicPenEnable = false;
                this.alphaDrawable.setAlpha(255);
                this.mColorSelectPickerLayout.setVisibility(0);
                if (this.mIsMaxHeight) {
                    setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(323.0f));
                }
                this.previousPenMagicSelected = false;
            }
            if (index == i) {
                this.mPenTypeView.get(i).setSelected(true);
                penSelection(this.mPenTypeView.get(i));
            } else {
                this.mPenTypeView.get(i).setSelected(false);
            }
            setExpandBarPosition(this.mBodyLayoutHeight);
        }
    }

    private ViewGroup penTypeLayout() {
        this.penTypeLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(290.0f), this.mDrawableImg.getIntValueAppliedDensity(75.0f));
        this.penTypeLayout.setLayoutParams(layoutParams);
        this.mPenTypeHorizontalScrollView = new RelativeLayout(this.mContext);
        this.mPenTypeHorizontalScrollView.setLayoutParams(layoutParams);
        this.mPenPluginInfoList = this.mPenPluginManager.getPenPluginInfoList();
        Iterator<SpenPenPluginInfo> iterator = this.mPenPluginInfoList.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            SpenPenPluginInfo penPluginInfo = iterator.next();
            ImageButton penButton = new ImageButton(this.mContext);
            String localUnselectImage = penPluginInfo.getPluginInfo().iconImageUri;
            String localSelectImage = penPluginInfo.getPluginInfo().selectedIconImageUri;
            String localFocusImage = penPluginInfo.getPluginInfo().focusedIconImageUri;
            String unselectImage = new String("iconImageUri");
            String selectImage = new String("selectedIconImageURI");
            String focusImage = new String("uriInfo");
            if (unselectImage.equals(localUnselectImage)) {
                localUnselectImage = "snote_popup_pensetting_brush";
            }
            if (selectImage.equals(localSelectImage)) {
                localSelectImage = "snote_popup_pensetting_brush_select";
            }
            if (focusImage.equals(localFocusImage)) {
                localFocusImage = "snote_popup_pensetting_brush_focus";
            }
            this.mImageLoader.addViewBackgroundSelectableImageLoad(penButton, localUnselectImage, localSelectImage, localFocusImage, 69, 69);
            this.penTypeLayout.setBackgroundColor(0);
            penButton.setFocusable(true);
            penButton.setId(i + 1000);
            if (penPluginInfo.getPluginInfo().canonicalClassName.equals("Brush")) {
                penButton.setContentDescription(this.mStringUtil.setString("string_brush"));
            } else if (penPluginInfo.getPluginInfo().canonicalClassName.equals("ChineseBrush")) {
                penButton.setContentDescription(this.mStringUtil.setString("string_chinese_brush"));
            } else if (penPluginInfo.getPluginInfo().canonicalClassName.equals("InkPen")) {
                penButton.setContentDescription(this.mStringUtil.setString("string_pen"));
            } else if (penPluginInfo.getPluginInfo().canonicalClassName.equals("Marker")) {
                penButton.setContentDescription(this.mStringUtil.setString("string_marker"));
            } else if (penPluginInfo.getPluginInfo().canonicalClassName.equals("Pencil")) {
                penButton.setContentDescription(this.mStringUtil.setString("string_pencil"));
            } else if (penPluginInfo.getPluginInfo().canonicalClassName.equals("MagicPen")) {
                penButton.setContentDescription(this.mStringUtil.setString("string_correction_pen"));
            }
            if (isBeautifyPen(penPluginInfo.getPenName())) {
                penButton.setVisibility(8);
            }
            RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(69.0f), this.mDrawableImg.getIntValueAppliedDensity(69.0f));
            penButton.setOnKeyListener(this.mPenTypeKeyListener);
            if (i > 0) {
                relativeParams.addRule(1, penButton.getId() - 1);
                relativeParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(-25.0f);
                this.penTypeLayout.addView(penButton, relativeParams);
            } else {
                relativeParams.addRule(9);
                relativeParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(5.4f);
                this.penTypeLayout.addView(penButton, relativeParams);
            }
            i++;
        }
        ImageButton penTouchView = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams penTouchViewParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(75.0f));
        penTouchView.setFocusable(false);
        penTouchView.setBackgroundColor(0);
        penTouchView.setOnTouchListener(this.mPenTypeTouchListener);
        penTouchView.setOnHoverListener(this.mPenTypeHoverListener);
        this.penTypeLayout.addView(penTouchView, penTouchViewParams);
        this.mPenTypeHorizontalScrollView.addView(this.penTypeLayout);
        this.mPenTypeHorizontalScrollView2 = new HorizontalScrollView(this.mContext);
        this.mPenTypeHorizontalScrollView2.addView(this.mPenTypeHorizontalScrollView);
        this.mPenTypeHorizontalScrollView2.setFadingEdgeLength(0);
        this.mPenTypeHorizontalScrollView2.setHorizontalScrollBarEnabled(false);
        this.mPenTypeHorizontalScrollView3 = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams layoutParamsNew = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(250.0f), this.mDrawableImg.getIntValueAppliedDensity(75.0f));
        this.mPenTypeHorizontalScrollView3.setLayoutParams(layoutParamsNew);
        this.mPenTypeHorizontalScrollView3.setPadding(this.mDrawableImg.getIntValueAppliedDensity(2.0f) + 9, 0, this.mDrawableImg.getIntValueAppliedDensity(2.0f) + 9, 0);
        this.mPreviewLayout = preview();
        this.mPenTypeHorizontalScrollView3.addView(this.mPreviewLayout);
        this.mPenTypeHorizontalScrollView3.addView(this.mPenTypeHorizontalScrollView2);
        return this.mPenTypeHorizontalScrollView3;
    }

    private ViewGroup penSizeLayout() {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams sizeDisplayLayoutParam = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(50.0f));
        relativeLayout.setLayoutParams(sizeDisplayLayoutParam);
        relativeLayout.setPadding(0, 0, 0, this.mDrawableImg.getIntValueAppliedDensity(8.0f));
        ImageView imgDivider = new ImageView(this.mContext);
        RelativeLayout.LayoutParams dividerParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(1.0f));
        dividerParams.alignWithParent = true;
        dividerParams.addRule(6);
        dividerParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(1.0f);
        dividerParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(2.0f);
        dividerParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(2.0f);
        imgDivider.setLayoutParams(dividerParams);
        this.mImageLoader.addViewSetBackgroundImageLoad(imgDivider, lineDivider);
        relativeLayout.addView(imgDivider);
        this.mPenSizePlusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams plusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(24.0f), this.mDrawableImg.getIntValueAppliedDensity(24.0f));
        plusImageParam.alignWithParent = true;
        plusImageParam.addRule(11);
        plusImageParam.addRule(8);
        this.mPenSizePlusButton.setLayoutParams(plusImageParam);
        this.mPenSizePlusButton.setContentDescription(this.mStringUtil.setString("string_plus"));
        if (mSdkVersion < 16) {
            this.mPenSizePlusButton.setBackgroundDrawable(this.mDrawableImg.setDrawableDimImg(plusBgPath, plusBgPressPath, plusBgFocusPath, plusBgDimPath, 24, 24));
        } else {
            this.mPenSizePlusButton.setBackground(this.mDrawableImg.setDrawableDimImg(plusBgPath, plusBgPressPath, plusBgFocusPath, plusBgDimPath, 24, 24));
        }
        this.mPenSizeMinusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams minusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(24.0f), this.mDrawableImg.getIntValueAppliedDensity(24.0f));
        minusImageParam.alignWithParent = true;
        minusImageParam.addRule(9);
        minusImageParam.addRule(8);
        this.mPenSizeMinusButton.setLayoutParams(minusImageParam);
        this.mPenSizeMinusButton.setContentDescription(this.mStringUtil.setString("string_minus"));
        if (mSdkVersion < 16) {
            this.mPenSizeMinusButton.setBackgroundDrawable(this.mDrawableImg.setDrawableDimImg(minusBgPath, minusBgPressPath, minusBgFocusPath, minusBgDimPath, 24, 24));
        } else {
            this.mPenSizeMinusButton.setBackground(this.mDrawableImg.setDrawableDimImg(minusBgPath, minusBgPressPath, minusBgFocusPath, minusBgDimPath, 24, 24));
        }
        this.mPenSizeSeekbar = penSizeSeekbar();
        this.mPenSizeTextView = new TextView(this.mContext);
        this.mPenSizeTextView.setTypeface(Typeface.SANS_SERIF, 1);
        this.mPenSizeTextView.setTextColor(Color.rgb(86, 87, 91));
        this.mPenSizeTextView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(12.0f));
        this.mPenSizeTextView.setGravity(51);
        RelativeLayout.LayoutParams penSizeTextParam = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(13.0f));
        penSizeTextParam.addRule(4);
        this.mPenSizeTextView.setLayoutParams(penSizeTextParam);
        relativeLayout.addView(this.mPenSizeTextView);
        relativeLayout.addView(this.mPenSizePlusButton);
        relativeLayout.addView(this.mPenSizeMinusButton);
        relativeLayout.addView(this.mPenSizeSeekbar);
        return relativeLayout;
    }

    private SeekBar penSizeSeekbar() throws Resources.NotFoundException, IOException {
        final SeekBar seekBar = new SeekBar(this.mContext);
        RelativeLayout.LayoutParams seekBarParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(196.0f) - 13, this.mDrawableImg.getIntValueAppliedDensity(22.0f));
        seekBarParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(24.0f), this.mDrawableImg.getIntValueAppliedDensity(20.0f), this.mDrawableImg.getIntValueAppliedDensity(24.0f), 0);
        seekBarParams.alignWithParent = true;
        seekBar.setLayoutParams(seekBarParams);
        seekBar.setPadding(this.mDrawableImg.getIntValueAppliedDensity(1.0f) + 3, 0, this.mDrawableImg.getIntValueAppliedDensity(1.0f) + 2, 0);
        seekBar.setMax(PEN_SIZE_MAX);
        seekBar.setThumb(this.mDrawableImg.setDrawableSelectImg(handelPath, handelPressPath, handelFocusPath, 22, 22));
        seekBar.setThumbOffset(this.mDrawableImg.getIntValueAppliedDensity(3.3f));
        this.mPenSizeSeekbarColor = new GradientDrawable();
        this.mPenSizeSeekbarColor.setColor(0);
        this.mPenSizeSeekbarColor.setCornerRadius(this.mDrawableImg.getIntValueAppliedDensity(4.1f));
        ClipDrawable localClipDrawable = new ClipDrawable(this.mPenSizeSeekbarColor, 3, 1);
        Drawable bgDrawable = this.mDrawableImg.setDrawableImg(progressBgPath, 190, 9);
        Drawable shadowDrawable = this.mDrawableImg.setDrawableImg(progressShadowPath, 190, 9);
        InsetDrawable bgInsetDrawable = new InsetDrawable(bgDrawable, 0, 0, 0, 0);
        InsetDrawable shadowInsetDrawable = new InsetDrawable(shadowDrawable, 0, 0, 0, 0);
        LayerDrawable localLayerDrawable = new LayerDrawable(new Drawable[]{bgInsetDrawable, localClipDrawable, shadowInsetDrawable});
        seekBar.setProgressDrawable(localLayerDrawable);
        seekBar.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.81
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        seekBar.setSelected(true);
                        return false;
                    case 1:
                        seekBar.setSelected(false);
                        return false;
                    case 2:
                    default:
                        return false;
                    case 3:
                        seekBar.setSelected(false);
                        return false;
                }
            }
        });
        return seekBar;
    }

    private ViewGroup penAlphaLayout() {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams sizeDisplayLayoutParam = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(50.0f));
        relativeLayout.setLayoutParams(sizeDisplayLayoutParam);
        relativeLayout.setPadding(0, 0, 0, this.mDrawableImg.getIntValueAppliedDensity(8.0f));
        ImageView imgDivider = new ImageView(this.mContext);
        RelativeLayout.LayoutParams dividerParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(1.0f));
        dividerParams.alignWithParent = true;
        dividerParams.addRule(6);
        dividerParams.addRule(14);
        dividerParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(0.5f);
        dividerParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(2.0f);
        dividerParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(2.0f);
        imgDivider.setLayoutParams(dividerParams);
        this.mImageLoader.addViewSetBackgroundImageLoad(imgDivider, lineDivider);
        relativeLayout.addView(imgDivider);
        this.mOpacityPlusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams plusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(24.0f), this.mDrawableImg.getIntValueAppliedDensity(24.0f));
        plusImageParam.alignWithParent = true;
        plusImageParam.addRule(11);
        plusImageParam.addRule(8);
        this.mOpacityPlusButton.setLayoutParams(plusImageParam);
        this.mOpacityPlusButton.setContentDescription(this.mStringUtil.setString("string_plus"));
        if (mSdkVersion < 16) {
            this.mOpacityPlusButton.setBackgroundDrawable(this.mDrawableImg.setDrawableDimImg(plusBgPath, plusBgPressPath, plusBgFocusPath, plusBgDimPath, 24, 24));
        } else {
            this.mOpacityPlusButton.setBackground(this.mDrawableImg.setDrawableDimImg(plusBgPath, plusBgPressPath, plusBgFocusPath, plusBgDimPath, 24, 24));
        }
        this.mOpacityMinusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams minusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(24.0f), this.mDrawableImg.getIntValueAppliedDensity(24.0f));
        minusImageParam.alignWithParent = true;
        minusImageParam.addRule(9);
        minusImageParam.addRule(8);
        this.mOpacityMinusButton.setLayoutParams(minusImageParam);
        this.mOpacityMinusButton.setContentDescription(this.mStringUtil.setString("string_minus"));
        if (mSdkVersion < 16) {
            this.mOpacityMinusButton.setBackgroundDrawable(this.mDrawableImg.setDrawableDimImg(minusBgPath, minusBgPressPath, minusBgFocusPath, minusBgDimPath, 24, 24));
        } else {
            this.mOpacityMinusButton.setBackground(this.mDrawableImg.setDrawableDimImg(minusBgPath, minusBgPressPath, minusBgFocusPath, minusBgDimPath, 24, 24));
        }
        this.mPenAlphaSeekbar = penAlphaSeekbar();
        this.mPenAlphaTextView = new TextView(this.mContext);
        this.mPenAlphaTextView.setTypeface(Typeface.SANS_SERIF, 1);
        this.mPenAlphaTextView.setTextColor(Color.rgb(86, 87, 91));
        this.mPenAlphaTextView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(12.0f));
        this.mPenAlphaTextView.setGravity(51);
        RelativeLayout.LayoutParams penAlphaTextParam = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(13.0f));
        penAlphaTextParam.addRule(4);
        this.mPenAlphaTextView.setLayoutParams(penAlphaTextParam);
        relativeLayout.addView(this.mPenAlphaTextView);
        relativeLayout.addView(this.mOpacityPlusButton);
        relativeLayout.addView(this.mOpacityMinusButton);
        relativeLayout.addView(this.mPenAlphaSeekbar);
        return relativeLayout;
    }

    private SeekBar penAlphaSeekbar() throws Resources.NotFoundException, IOException {
        final SeekBar seekBar = new SeekBar(this.mContext);
        RelativeLayout.LayoutParams seekBarParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(196.0f) - 13, this.mDrawableImg.getIntValueAppliedDensity(22.0f));
        seekBarParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(24.0f), this.mDrawableImg.getIntValueAppliedDensity(20.0f), this.mDrawableImg.getIntValueAppliedDensity(24.0f), 0);
        seekBarParams.alignWithParent = true;
        seekBar.setLayoutParams(seekBarParams);
        seekBar.setPadding(this.mDrawableImg.getIntValueAppliedDensity(1.0f) + 3, 0, this.mDrawableImg.getIntValueAppliedDensity(1.0f) + 2, 0);
        seekBar.setMax(PEN_SIZE_MAX);
        seekBar.setThumb(this.mDrawableImg.setDrawableSelectImg(handelPath, handelPressPath, handelFocusPath, 22, 22));
        seekBar.setThumbOffset(this.mDrawableImg.getIntValueAppliedDensity(3.3f));
        this.mPenAlphaSeekbarColor = new GradientDrawable();
        this.mPenAlphaSeekbarColor.setColor(0);
        this.mPenAlphaSeekbarColor.setCornerRadius(this.mDrawableImg.getIntValueAppliedDensity(4.1f));
        ClipDrawable localClipDrawable = new ClipDrawable(this.mPenAlphaSeekbarColor, 3, 1);
        Drawable localDrawable = this.mDrawableImg.setDrawableImg(progressShadowPath, 190, 9);
        this.alphaDrawable = this.mDrawableImg.setDrawableImg(progressAlphaPath, 190, 9);
        InsetDrawable localInsetDrawable = new InsetDrawable(localDrawable, 0, 0, 0, 0);
        InsetDrawable alphaInsetDrawable = new InsetDrawable(this.alphaDrawable, 0, 0, 0, 0);
        LayerDrawable localLayerDrawable = new LayerDrawable(new Drawable[]{alphaInsetDrawable, localClipDrawable, localInsetDrawable});
        seekBar.setProgressDrawable(localLayerDrawable);
        seekBar.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.82
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        seekBar.setSelected(true);
                        return false;
                    case 1:
                        seekBar.setSelected(false);
                        return false;
                    case 2:
                    default:
                        return false;
                    case 3:
                        seekBar.setSelected(false);
                        return false;
                }
            }
        });
        return seekBar;
    }

    private View beautifyAdvanceSettingSeekbars() {
        LinearLayout containerLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams containerParam = new LinearLayout.LayoutParams(-1, -2);
        containerLayout.setLayoutParams(containerParam);
        containerLayout.setOrientation(1);
        containerLayout.addView(beautifyAdvanceCursive());
        containerLayout.addView(beautifyAdvanceSustenance());
        containerLayout.addView(beautifyAdvanceDummy());
        containerLayout.addView(beautifyAdvanceModulation());
        containerLayout.addView(beautifyAdvanceResetBtn());
        return containerLayout;
    }

    private View beautifyAdvanceCursive() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams advanceZoneParam = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setLayoutParams(advanceZoneParam);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        this.mBeautifyCursiveTextView = new TextView(this.mContext);
        LinearLayout.LayoutParams titleViewParam = new LinearLayout.LayoutParams(-1, -2);
        titleViewParam.topMargin = this.mDrawableImg.getIntValueAppliedDensity(5.0f);
        this.mBeautifyCursiveTextView.setLayoutParams(titleViewParam);
        this.mBeautifyCursiveTextView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(12.0f));
        this.mBeautifyCursiveTextView.setGravity(3);
        this.mBeautifyCursiveTextView.setTypeface(null, 1);
        this.mBeautifyCursiveTextView.setPadding(this.mDrawableImg.getIntValueAppliedDensity(35.0f), 0, this.mDrawableImg.getIntValueAppliedDensity(35.0f), 0);
        this.mBeautifyCursiveTextView.setTextColor(Color.rgb(86, 87, 91));
        this.mBeautifyCursiveTextView.setText(this.mStringUtil.setString("string_cursive"));
        this.mBeautifyAdvanceCursivePlusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams plusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(25.0f), this.mDrawableImg.getIntValueAppliedDensity(25.0f));
        plusImageParam.alignWithParent = true;
        plusImageParam.addRule(11);
        plusImageParam.addRule(15);
        this.mBeautifyAdvanceCursivePlusButton.setLayoutParams(plusImageParam);
        this.mBeautifyAdvanceCursivePlusButton.setContentDescription(this.mStringUtil.setString("string_plus"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mBeautifyAdvanceCursivePlusButton, plusBgPath, plusBgPressPath, plusBgFocusPath, 25, 25);
        this.mBeautifyAdvanceCursiveMinusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams minusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(25.0f), this.mDrawableImg.getIntValueAppliedDensity(25.0f));
        minusImageParam.alignWithParent = true;
        minusImageParam.addRule(9);
        minusImageParam.addRule(15);
        this.mBeautifyAdvanceCursiveMinusButton.setLayoutParams(minusImageParam);
        this.mBeautifyAdvanceCursiveMinusButton.setContentDescription(this.mStringUtil.setString("string_minus"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mBeautifyAdvanceCursiveMinusButton, minusBgPath, minusBgPressPath, minusBgFocusPath, 25, 25);
        RelativeLayout advanceSeekZoneLayout = new RelativeLayout(this.mContext);
        LinearLayout.LayoutParams advanceSeekZoneLayoutParam = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(25.0f));
        advanceSeekZoneLayoutParam.bottomMargin = this.mDrawableImg.getIntValueAppliedDensity(3.0f);
        advanceSeekZoneLayout.setLayoutParams(advanceSeekZoneLayoutParam);
        int maxProgress = getBeautifyAdvanceMaxValue(2);
        this.mCursiveSeekbarColor = new GradientDrawable();
        this.mBeautifyAdvanceCursiveSeekbar = beautifyAdvanceSeekBar(this.mCursiveSeekbarColor);
        this.mBeautifyAdvanceCursiveSeekbar.setMax(maxProgress);
        advanceSeekZoneLayout.addView(this.mBeautifyAdvanceCursiveMinusButton);
        advanceSeekZoneLayout.addView(this.mBeautifyAdvanceCursiveSeekbar);
        advanceSeekZoneLayout.addView(this.mBeautifyAdvanceCursivePlusButton);
        linearLayout.addView(this.mBeautifyCursiveTextView);
        linearLayout.addView(advanceSeekZoneLayout);
        ImageView imgDivider = new ImageView(this.mContext);
        RelativeLayout.LayoutParams dividerParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(1.0f));
        dividerParams.alignWithParent = true;
        dividerParams.addRule(6);
        imgDivider.setLayoutParams(dividerParams);
        dividerParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(1.0f);
        this.mImageLoader.addViewSetBackgroundImageLoad(imgDivider, lineDivider);
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(advanceZoneParam);
        relativeLayout.addView(imgDivider);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    private View beautifyAdvanceSustenance() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams advanceZoneParam = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setLayoutParams(advanceZoneParam);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        this.mBeautifySustenanceTextView = new TextView(this.mContext);
        LinearLayout.LayoutParams titleViewParam = new LinearLayout.LayoutParams(-1, -2);
        titleViewParam.topMargin = this.mDrawableImg.getIntValueAppliedDensity(5.0f);
        this.mBeautifySustenanceTextView.setLayoutParams(titleViewParam);
        this.mBeautifySustenanceTextView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(12.0f));
        this.mBeautifySustenanceTextView.setGravity(3);
        this.mBeautifySustenanceTextView.setTypeface(null, 1);
        this.mBeautifySustenanceTextView.setPadding(this.mDrawableImg.getIntValueAppliedDensity(35.0f), 0, this.mDrawableImg.getIntValueAppliedDensity(35.0f), 0);
        this.mBeautifySustenanceTextView.setTextColor(Color.rgb(86, 87, 91));
        this.mBeautifySustenanceTextView.setText(this.mStringUtil.setString("string_sustenance"));
        this.mBeautifyAdvanceSustenancePlusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams plusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(25.0f), this.mDrawableImg.getIntValueAppliedDensity(25.0f));
        plusImageParam.alignWithParent = true;
        plusImageParam.addRule(11);
        plusImageParam.addRule(15);
        this.mBeautifyAdvanceSustenancePlusButton.setLayoutParams(plusImageParam);
        this.mBeautifyAdvanceSustenancePlusButton.setContentDescription(this.mStringUtil.setString("string_plus"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mBeautifyAdvanceSustenancePlusButton, plusBgPath, plusBgPressPath, plusBgFocusPath, 25, 25);
        this.mBeautifyAdvanceSustenanceMinusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams minusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(25.0f), this.mDrawableImg.getIntValueAppliedDensity(25.0f));
        minusImageParam.alignWithParent = true;
        minusImageParam.addRule(9);
        minusImageParam.addRule(15);
        this.mBeautifyAdvanceSustenanceMinusButton.setLayoutParams(minusImageParam);
        this.mBeautifyAdvanceSustenanceMinusButton.setContentDescription(this.mStringUtil.setString("string_minus"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mBeautifyAdvanceSustenanceMinusButton, minusBgPath, minusBgPressPath, minusBgFocusPath, 25, 25);
        RelativeLayout advanceSeekZoneLayout = new RelativeLayout(this.mContext);
        LinearLayout.LayoutParams advanceSeekZoneLayoutParam = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(25.0f));
        advanceSeekZoneLayoutParam.bottomMargin = this.mDrawableImg.getIntValueAppliedDensity(3.0f);
        advanceSeekZoneLayout.setLayoutParams(advanceSeekZoneLayoutParam);
        int maxProgress = getBeautifyAdvanceMaxValue(3);
        this.mSustenanceSeekbarColor = new GradientDrawable();
        this.mBeautifyAdvanceSustenanceSeekbar = beautifyAdvanceSeekBar(this.mSustenanceSeekbarColor);
        this.mBeautifyAdvanceSustenanceSeekbar.setMax(maxProgress);
        advanceSeekZoneLayout.addView(this.mBeautifyAdvanceSustenanceMinusButton);
        advanceSeekZoneLayout.addView(this.mBeautifyAdvanceSustenanceSeekbar);
        advanceSeekZoneLayout.addView(this.mBeautifyAdvanceSustenancePlusButton);
        linearLayout.addView(this.mBeautifySustenanceTextView);
        linearLayout.addView(advanceSeekZoneLayout);
        return linearLayout;
    }

    private View beautifyAdvanceDummy() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams advanceZoneParam = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setLayoutParams(advanceZoneParam);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        this.mBeautifyDummyTextView = new TextView(this.mContext);
        LinearLayout.LayoutParams titleViewParam = new LinearLayout.LayoutParams(-1, -2);
        titleViewParam.topMargin = this.mDrawableImg.getIntValueAppliedDensity(5.0f);
        this.mBeautifyDummyTextView.setLayoutParams(titleViewParam);
        this.mBeautifyDummyTextView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(12.0f));
        this.mBeautifyDummyTextView.setGravity(3);
        this.mBeautifyDummyTextView.setTypeface(null, 1);
        this.mBeautifyDummyTextView.setPadding(this.mDrawableImg.getIntValueAppliedDensity(35.0f), 0, this.mDrawableImg.getIntValueAppliedDensity(35.0f), 0);
        this.mBeautifyDummyTextView.setTextColor(Color.rgb(86, 87, 91));
        this.mBeautifyDummyTextView.setText(this.mStringUtil.setString("string_dummy"));
        this.mBeautifyAdvanceDummyPlusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams plusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(25.0f), this.mDrawableImg.getIntValueAppliedDensity(25.0f));
        plusImageParam.alignWithParent = true;
        plusImageParam.addRule(11);
        plusImageParam.addRule(15);
        this.mBeautifyAdvanceDummyPlusButton.setLayoutParams(plusImageParam);
        this.mBeautifyAdvanceDummyPlusButton.setContentDescription(this.mStringUtil.setString("string_plus"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mBeautifyAdvanceDummyPlusButton, plusBgPath, plusBgPressPath, plusBgFocusPath, 25, 25);
        this.mBeautifyAdvanceDummyMinusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams minusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(25.0f), this.mDrawableImg.getIntValueAppliedDensity(25.0f));
        minusImageParam.alignWithParent = true;
        minusImageParam.addRule(9);
        minusImageParam.addRule(15);
        this.mBeautifyAdvanceDummyMinusButton.setLayoutParams(minusImageParam);
        this.mBeautifyAdvanceDummyMinusButton.setContentDescription(this.mStringUtil.setString("string_minus"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mBeautifyAdvanceDummyMinusButton, minusBgPath, minusBgPressPath, minusBgFocusPath, 25, 25);
        RelativeLayout advanceSeekZoneLayout = new RelativeLayout(this.mContext);
        LinearLayout.LayoutParams advanceSeekZoneLayoutParam = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(25.0f));
        advanceSeekZoneLayoutParam.bottomMargin = this.mDrawableImg.getIntValueAppliedDensity(3.0f);
        advanceSeekZoneLayout.setLayoutParams(advanceSeekZoneLayoutParam);
        int maxProgress = getBeautifyAdvanceMaxValue(4);
        this.mDummySeekbarColor = new GradientDrawable();
        this.mBeautifyAdvanceDummySeekbar = beautifyAdvanceSeekBar(this.mDummySeekbarColor);
        this.mBeautifyAdvanceDummySeekbar.setMax(maxProgress);
        advanceSeekZoneLayout.addView(this.mBeautifyAdvanceDummyMinusButton);
        advanceSeekZoneLayout.addView(this.mBeautifyAdvanceDummySeekbar);
        advanceSeekZoneLayout.addView(this.mBeautifyAdvanceDummyPlusButton);
        linearLayout.addView(this.mBeautifyDummyTextView);
        linearLayout.addView(advanceSeekZoneLayout);
        return linearLayout;
    }

    private View beautifyAdvanceModulation() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        LinearLayout.LayoutParams advanceZoneParam = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setLayoutParams(advanceZoneParam);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        this.mBeautifyModulationTextView = new TextView(this.mContext);
        LinearLayout.LayoutParams titleViewParam = new LinearLayout.LayoutParams(-1, -2);
        titleViewParam.topMargin = this.mDrawableImg.getIntValueAppliedDensity(5.0f);
        this.mBeautifyModulationTextView.setLayoutParams(titleViewParam);
        this.mBeautifyModulationTextView.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(12.0f));
        this.mBeautifyModulationTextView.setGravity(3);
        this.mBeautifyModulationTextView.setTypeface(null, 1);
        this.mBeautifyModulationTextView.setPadding(this.mDrawableImg.getIntValueAppliedDensity(35.0f), 0, this.mDrawableImg.getIntValueAppliedDensity(35.0f), 0);
        this.mBeautifyModulationTextView.setTextColor(Color.rgb(86, 87, 91));
        this.mBeautifyModulationTextView.setText(this.mStringUtil.setString("string_modulation"));
        this.mBeautifyAdvanceModulationPlusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams plusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(25.0f), this.mDrawableImg.getIntValueAppliedDensity(25.0f));
        plusImageParam.alignWithParent = true;
        plusImageParam.addRule(11);
        plusImageParam.addRule(15);
        this.mBeautifyAdvanceModulationPlusButton.setLayoutParams(plusImageParam);
        this.mBeautifyAdvanceModulationPlusButton.setContentDescription(this.mStringUtil.setString("string_plus"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mBeautifyAdvanceModulationPlusButton, plusBgPath, plusBgPressPath, plusBgFocusPath, 25, 25);
        this.mBeautifyAdvanceModulationMinusButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams minusImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(25.0f), this.mDrawableImg.getIntValueAppliedDensity(25.0f));
        minusImageParam.alignWithParent = true;
        minusImageParam.addRule(9);
        minusImageParam.addRule(15);
        this.mBeautifyAdvanceModulationMinusButton.setLayoutParams(minusImageParam);
        this.mBeautifyAdvanceModulationMinusButton.setContentDescription(this.mStringUtil.setString("string_minus"));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mBeautifyAdvanceModulationMinusButton, minusBgPath, minusBgPressPath, minusBgFocusPath, 25, 25);
        RelativeLayout advanceSeekZoneLayout = new RelativeLayout(this.mContext);
        LinearLayout.LayoutParams advanceSeekZoneLayoutParam = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(25.0f));
        advanceSeekZoneLayoutParam.bottomMargin = this.mDrawableImg.getIntValueAppliedDensity(3.0f);
        advanceSeekZoneLayout.setLayoutParams(advanceSeekZoneLayoutParam);
        int maxProgress = getBeautifyAdvanceMaxValue(6);
        this.mModulationSeekbarColor = new GradientDrawable();
        this.mBeautifyAdvanceModulationSeekbar = beautifyAdvanceSeekBar(this.mModulationSeekbarColor);
        this.mBeautifyAdvanceModulationSeekbar.setMax(maxProgress);
        advanceSeekZoneLayout.addView(this.mBeautifyAdvanceModulationMinusButton);
        advanceSeekZoneLayout.addView(this.mBeautifyAdvanceModulationSeekbar);
        advanceSeekZoneLayout.addView(this.mBeautifyAdvanceModulationPlusButton);
        linearLayout.addView(this.mBeautifyModulationTextView);
        linearLayout.addView(advanceSeekZoneLayout);
        return linearLayout;
    }

    private SeekBar beautifyAdvanceSeekBar(GradientDrawable mGradientDrawable) throws Resources.NotFoundException, IOException {
        SeekBar seekBar = new SeekBar(this.mContext);
        RelativeLayout.LayoutParams seekBarParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(190.0f), -2);
        seekBarParams.alignWithParent = true;
        seekBarParams.addRule(14);
        seekBarParams.addRule(15);
        seekBar.setLayoutParams(seekBarParams);
        seekBar.setPadding(this.mDrawableImg.getIntValueAppliedDensity(10.0f), 0, this.mDrawableImg.getIntValueAppliedDensity(10.0f), 0);
        seekBar.setThumb(this.mDrawableImg.setDrawableSelectImg(handelPath, handelPressPath, handelFocusPath, 22, 22));
        mGradientDrawable.setColor(0);
        mGradientDrawable.setCornerRadius(this.mDrawableImg.getIntValueAppliedDensity(4.5f));
        ClipDrawable localClipDrawable = new ClipDrawable(mGradientDrawable, 3, 1);
        Drawable localDrawable = this.mDrawableImg.setDrawableImg(progressBgPath, 190, 9);
        InsetDrawable localInsetDrawable = new InsetDrawable(localDrawable, 0, 0, 0, 0);
        LayerDrawable localLayerDrawable = new LayerDrawable(new Drawable[]{localInsetDrawable, localClipDrawable});
        seekBar.setProgressDrawable(localLayerDrawable);
        return seekBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBeautifyAdvanceSeekbarColor(int color) {
        this.mCursiveSeekbarColor.setColor(color);
        this.mDummySeekbarColor.setColor(color);
        this.mSustenanceSeekbarColor.setColor(color);
        this.mModulationSeekbarColor.setColor(color);
    }

    private Button beautifyAdvanceResetBtn() {
        this.mBeautifyAdvanceResetButton = new Button(this.mContext);
        LinearLayout.LayoutParams resetBtnLayoutParam = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(40.0f));
        resetBtnLayoutParam.topMargin = this.mDrawableImg.getIntValueAppliedDensity(5.0f);
        resetBtnLayoutParam.bottomMargin = this.mDrawableImg.getIntValueAppliedDensity(5.0f);
        this.mBeautifyAdvanceResetButton.setLayoutParams(resetBtnLayoutParam);
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mBeautifyAdvanceResetButton, popupBtnBgNomalPath, popupBtnBgPressPath, popupBtnBgFocusPath);
        this.mBeautifyAdvanceResetButton.setTextColor(-16777216);
        this.mBeautifyAdvanceResetButton.setGravity(17);
        this.mBeautifyAdvanceResetButton.setTextSize(0, this.mDrawableImg.getIntValueAppliedDensity(14.0f));
        this.mBeautifyAdvanceResetButton.setText(this.mStringUtil.setString("string_reset"));
        return this.mBeautifyAdvanceResetButton;
    }

    private int getBeautifyAdvanceMaxValue(int advanceParamType) {
        switch (advanceParamType) {
            case 2:
                return 12;
            case 3:
                return 16;
            case 4:
                return 20;
            case 5:
            default:
                return 20;
            case 6:
                return 100;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isBeautifyPen(String penName) {
        if (penName == null || !BEAUTIFY_PEN_NAME.equals(penName)) {
            return false;
        }
        return true;
    }

    private boolean isBeautifyPen(int penNameIndex) {
        String penName = this.mPenPluginInfoList.get(penNameIndex).getPenName();
        if (penName == null || !BEAUTIFY_PEN_NAME.equals(penName)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isChinesePen(String penName) {
        if (penName == null || !"com.samsung.android.sdk.pen.pen.preload.ChineseBrush".equals(penName)) {
            return false;
        }
        return true;
    }

    private int getBeautifyAdvanceParamDataFromString(String advanceSetting, int beautifyParam) throws NumberFormatException {
        String[] advanceStyleData = advanceSetting.split(Config.KEYVALUE_SPLIT);
        if (advanceSetting.isEmpty() || advanceStyleData.length != 10) {
            return 0;
        }
        int data = Integer.parseInt(advanceStyleData[beautifyParam]);
        return data;
    }

    private int getBeautifyAdvanceParamDataFromArray(int[] advanceData, int beautifyParam) {
        if (advanceData == null || advanceData.length != 10) {
            return 0;
        }
        int data = advanceData[beautifyParam];
        return data;
    }

    private String getBeautifyAdvanceArrayDataToString(int[] advanceData) {
        StringBuffer advancedData = new StringBuffer();
        for (int paramIndex = 0; paramIndex < 10; paramIndex++) {
            advancedData.append(advanceData[paramIndex]);
            advancedData.append(';');
        }
        return advancedData.toString();
    }

    private void setBeautifyAdvanceStringToCurrentAdvanceData(String advancedSetting) throws NumberFormatException {
        int beautifyStyleBtnIdx = getBeautifyStyleBtnIndex(advancedSetting);
        String[] advanceStyleData = advancedSetting.split(Config.KEYVALUE_SPLIT);
        this.mCurrentBeautifyStyle = beautifyStyleBtnIdx;
        if (!advancedSetting.isEmpty() || advanceStyleData.length == 10) {
            for (int advanceIdx = 0; advanceIdx < 10; advanceIdx++) {
                this.mCurrentBeautifyAdvanceSettingValues[beautifyStyleBtnIdx][advanceIdx] = Integer.parseInt(advanceStyleData[advanceIdx]);
            }
        }
    }

    private void updateBeautifySeekBarsFromString(String advanceSetting) throws NumberFormatException {
        int cursive = getBeautifyAdvanceParamDataFromString(advanceSetting, 2);
        int sustenance = getBeautifyAdvanceParamDataFromString(advanceSetting, 3);
        int dummy = getBeautifyAdvanceParamDataFromString(advanceSetting, 4);
        int modulation = getBeautifyAdvanceParamDataFromString(advanceSetting, 6);
        updateBeautifySeekBars(cursive, sustenance, dummy, modulation);
    }

    private void updateBeautifySeekBarsFromArray(int[] advanceData) {
        int cursive = getBeautifyAdvanceParamDataFromArray(advanceData, 2);
        int sustenance = getBeautifyAdvanceParamDataFromArray(advanceData, 3);
        int dummy = getBeautifyAdvanceParamDataFromArray(advanceData, 4);
        int modulation = getBeautifyAdvanceParamDataFromArray(advanceData, 6);
        updateBeautifySeekBars(cursive, sustenance, dummy, modulation);
    }

    private void updateBeautifySeekBars(int cursive, int sustenance, int dummy, int modulation) {
        if (12 < cursive) {
            cursive = 12;
        } else if (cursive < 0) {
            cursive = 0;
        }
        if (16 < sustenance) {
            sustenance = 16;
        } else if (sustenance < 0) {
            sustenance = 0;
        }
        if (20 < dummy) {
            dummy = 20;
        } else if (dummy < 0) {
            dummy = 0;
        }
        if (100 < modulation) {
            modulation = 100;
        } else if (modulation < 0) {
            modulation = 0;
        }
        if (this.mBeautifyAdvanceCursiveSeekbar != null) {
            this.mBeautifyAdvanceCursiveSeekbar.setProgress(cursive);
        }
        if (this.mBeautifyAdvanceSustenanceSeekbar != null) {
            this.mBeautifyAdvanceSustenanceSeekbar.setProgress(sustenance);
        }
        if (this.mBeautifyAdvanceDummySeekbar != null) {
            this.mBeautifyAdvanceDummySeekbar.setProgress(dummy);
        }
        if (this.mBeautifyAdvanceModulationSeekbar != null) {
            this.mBeautifyAdvanceModulationSeekbar.setProgress(modulation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetBeautifyAdvanceDataAndUpdateSeekBarUi(int beautifyStyleIndex) {
        updateBeautifySeekBarsFromArray(BEAUTIFY_ADVANCE_DEFAULT_SETTING_VALUES[beautifyStyleIndex]);
        if (!this.isFirstTime) {
            setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(555.0f));
        } else {
            setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(603.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBeautifySettingData() {
        SpenSettingPenInfo info;
        if (this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject() == null) {
            this.mPenPluginManager.loadPenPlugin(this.mContext, this.mSettingInfo.name);
            if (this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject() == null) {
                return;
            }
        }
        this.mSettingInfo.size = this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().getSize();
        this.mSettingInfo.color = this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().getColor();
        if (this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().getPenAttribute(4)) {
            this.mSettingInfo.advancedSetting = this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().getAdvancedSetting();
        } else {
            this.mSettingInfo.advancedSetting = "";
        }
        if (this.mCanvasView != null && (info = this.mCanvasView.getPenSettingInfo()) != null) {
            info.name = this.mSettingInfo.name;
            info.size = this.mSettingInfo.size;
            info.color = this.mSettingInfo.color;
            info.advancedSetting = this.mSettingInfo.advancedSetting;
            this.mCanvasView.setPenSettingInfo(info);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBeautifyAdvancedDataToPlugin(int beautifyParamIndex, int settingValue) {
        if (this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().getPenAttribute(4)) {
            this.mCurrentBeautifyAdvanceSettingValues[this.mCurrentBeautifyStyle][beautifyParamIndex] = settingValue;
            String advancedSetting = getBeautifyAdvanceArrayDataToString(this.mCurrentBeautifyAdvanceSettingValues[this.mCurrentBeautifyStyle]);
            this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().setAdvancedSetting(advancedSetting);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorSelectorViewForBeautifyPen() {
        if ((this.mCurrentBeautifyStyle == 5 && isBeautifyPen(this.mSettingInfo.name)) || this.mPresetButton.isSelected() || this.isMagicPenEnable) {
            this.mColorSelectPickerLayout.setVisibility(8);
            this.mPenSizeSeekbarColor.setColor(0);
            this.mCursiveSeekbarColor.setColor(0);
            this.mSustenanceSeekbarColor.setColor(0);
            this.mDummySeekbarColor.setColor(0);
            this.mModulationSeekbarColor.setColor(0);
            return;
        }
        this.mColorSelectPickerLayout.setVisibility(0);
        this.mColorPaletteView.setColor(this.mSettingInfo.color);
        if (this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject() == null) {
            this.mPenPluginManager.loadPenPlugin(this.mContext, this.mSettingInfo.name);
            if (this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject() == null) {
                return;
            }
        }
        if (this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().getPenAttribute(1)) {
            this.mPenAlpha = (this.mSettingInfo.color >> 24) & 255;
            this.mPenAlphaSeekbar.setProgress(Math.round((this.mPenAlpha / 255.0f) * 99.0f));
            this.mPenAlphaSeekbarColor.setColor(this.mSettingInfo.color);
            this.mPenSizeSeekbarColor.setColor((this.mSettingInfo.color & 16777215) | (-16777216));
            return;
        }
        this.mPenSizeSeekbarColor.setColor(this.mSettingInfo.color);
        setBeautifyAdvanceSeekbarColor(this.mSettingInfo.color);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beautifyUpdateSettingUI(boolean isBeautify) throws NumberFormatException {
        float min = this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().getMinSettingValue();
        float max = this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().getMaxSettingValue();
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
        int progress = Math.round((((this.mSettingInfo.size * 360.0f) / this.mCanvasSize) - min) * 10.0f);
        this.mPenSizeSeekbar.setMax(Math.round((max - min) * 10.0f));
        this.mPenSizeSeekbar.setProgress(progress);
        if (isBeautify) {
            updateBeautifySeekBarsFromString(this.mSettingInfo.advancedSetting);
        }
        this.mPenPreview.setPenType(this.mSettingInfo.name);
        this.mPenPreview.setStrokeSize(this.mSettingInfo.size);
        this.mPenPreview.setStrokeColor(this.mSettingInfo.color);
        this.mPenPreview.setStrokeAdvancedSetting(this.mSettingInfo.advancedSetting);
        this.mPenPreview.invalidate();
        if (this.mCurrentBeautifyStyle == 5) {
            this.mPenSizeSeekbarColor.setColor(0);
            this.mCursiveSeekbarColor.setColor(0);
            this.mSustenanceSeekbarColor.setColor(0);
            this.mDummySeekbarColor.setColor(0);
            this.mModulationSeekbarColor.setColor(0);
            return;
        }
        this.mColorPaletteView.setColor(this.mSettingInfo.color);
        this.mPenSizeSeekbarColor.setColor(this.mSettingInfo.color);
        this.mCursiveSeekbarColor.setColor(this.mSettingInfo.color);
        this.mSustenanceSeekbarColor.setColor(this.mSettingInfo.color);
        this.mDummySeekbarColor.setColor(this.mSettingInfo.color);
        this.mModulationSeekbarColor.setColor(this.mSettingInfo.color);
    }

    private ViewGroup PickerView() {
        RelativeLayout localLinearLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(48.0f));
        localLayoutParams.leftMargin = this.mDrawableImg.getIntValueAppliedDensity(28.0f);
        localLayoutParams.rightMargin = this.mDrawableImg.getIntValueAppliedDensity(28.0f);
        localLayoutParams.topMargin = this.mDrawableImg.getIntValueAppliedDensity(66.0f);
        localLinearLayout.setLayoutParams(localLayoutParams);
        this.mColorGradationView = colorGradationView();
        localLinearLayout.addView(this.mColorGradationView);
        return localLinearLayout;
    }

    private ViewGroup colorPaletteGradationLayout() {
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

    private ViewGroup PaletteView() {
        RelativeLayout sizeDisplayLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams sizeDisplayLayoutParam = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(55.0f));
        sizeDisplayLayoutParam.setMargins(this.mDrawableImg.getIntValueAppliedDensity(8.0f), this.mDrawableImg.getIntValueAppliedDensity(6.0f), this.mDrawableImg.getIntValueAppliedDensity(8.0f), 0);
        sizeDisplayLayout.setLayoutParams(sizeDisplayLayoutParam);
        this.mPaletteRightButton = new ImageButton(this.mContext);
        RelativeLayout.LayoutParams rightImageParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(18.0f), this.mDrawableImg.getIntValueAppliedDensity(55.0f));
        rightImageParam.alignWithParent = true;
        rightImageParam.addRule(11);
        rightImageParam.addRule(15);
        this.mPaletteRightButton.setLayoutParams(rightImageParam);
        this.mPaletteRightButton.setContentDescription(this.mStringUtil.setString("string_next"));
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
        this.mPaletteLeftButton.setContentDescription(this.mStringUtil.setString("string_back"));
        if (mSdkVersion < 16) {
            this.mPaletteLeftButton.setBackgroundDrawable(this.mDrawableImg.setDrawableDimImg(leftBgPath, leftBgPressPath, leftBgFocusPath, leftBgDimPath, 18, 55));
        } else {
            this.mPaletteLeftButton.setBackground(this.mDrawableImg.setDrawableDimImg(leftBgPath, leftBgPressPath, leftBgFocusPath, leftBgDimPath, 18, 55));
        }
        this.mColorPaletteView = colorPaletteView();
        sizeDisplayLayout.addView(this.mPaletteLeftButton);
        sizeDisplayLayout.addView(this.mColorPaletteView);
        sizeDisplayLayout.addView(this.mPaletteRightButton);
        return sizeDisplayLayout;
    }

    private SpenColorPaletteView colorPaletteView() {
        this.colorPaletteView = new SpenColorPaletteView(this.mContext, this.mDrawableImg.mCustom_imagepath, mScale);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(194.0f), -2);
        localLayoutParams.alignWithParent = true;
        localLayoutParams.addRule(14);
        localLayoutParams.addRule(15);
        this.colorPaletteView.setLayoutParams(localLayoutParams);
        this.colorPaletteView.setClickable(true);
        this.colorPaletteView.setFocusable(true);
        return this.colorPaletteView;
    }

    private SpenColorGradationView colorGradationView() {
        SpenColorGradationView localf = new SpenColorGradationView(this.mContext, this.mDrawableImg.mCustom_imagepath, mScale);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(192.0f), this.mDrawableImg.getIntValueAppliedDensity(48.0f));
        localf.setLayoutParams(localLayoutParams);
        localf.setClickable(true);
        localf.setContentDescription(this.mStringUtil.setString("string_gradation"));
        localf.setPadding(0, 0, 0, 0);
        return localf;
    }

    private View bottomLayout() {
        RelativeLayout bottomLayout = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams bottomLayoutParams = new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(16.0f));
        bottomLayoutParams.setMargins(0, this.mDrawableImg.getIntValueAppliedDensity(257.0f), 0, 0);
        bottomLayout.setLayoutParams(bottomLayoutParams);
        this.mBottomExtendBg = new ImageView(this.mContext);
        this.mBottomExtendBg.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(16.0f)));
        this.mImageLoader.addViewBackgroundSelectableImageLoad(this.mBottomExtendBg, bottomExpandPath, bottomExpandPressPath, bottomExpandPressPath);
        if (mSdkVersion < 16) {
            this.mBottomExtendBg.setBackgroundDrawable(this.mDrawableImg.setDrawableSelectImg(bottomExpandPath, bottomExpandPressPath, bottomExpandPressPath));
        } else {
            this.mBottomExtendBg.setBackground(this.mDrawableImg.setDrawableSelectImg(bottomExpandPath, bottomExpandPressPath, bottomExpandPressPath));
        }
        this.mBottomHandle = new ImageView(this.mContext);
        RelativeLayout.LayoutParams bottomHandleParam = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(22.0f), this.mDrawableImg.getIntValueAppliedDensity(16.0f));
        bottomHandleParam.alignWithParent = true;
        bottomHandleParam.addRule(14);
        bottomHandleParam.addRule(8);
        bottomHandleParam.bottomMargin = this.mDrawableImg.getIntValueAppliedDensity(-1.0f);
        this.mBottomHandle.setLayoutParams(bottomHandleParam);
        this.mBottomHandle.setImageDrawable(this.mDrawableImg.setDrawableImg(bottomHandlePath, 22, 16));
        bottomLayout.addView(this.mBottomExtendBg);
        bottomLayout.addView(this.mBottomHandle);
        bottomLayout.setOnHoverListener(this.mOnConsumedHoverListener);
        return bottomLayout;
    }

    protected void drawExpendImage(String penName) throws NumberFormatException {
        int penPluginIndex;
        if (this.mPenPluginManager != null && this.mPenPluginInfoList != null && (penPluginIndex = this.mPenPluginManager.getPenPluginIndexByPenName(penName)) != -1) {
            if (this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject() == null) {
                this.mPenPluginManager.loadPenPlugin(this.mContext, this.mSettingInfo.name);
                if (this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject() == null) {
                    return;
                }
            }
            if (!this.mPresetButton.isSelected()) {
                setColorSelectorViewForBeautifyPen();
                if ((isBeautifyPen(this.mSettingInfo.name) || isChinesePen(this.mSettingInfo.name)) && this.mSupportBeautifyPen && hasBeautifyPen()) {
                    boolean isBeautify = isBeautifyPen(this.mSettingInfo.name);
                    if (this.mBeautifyEnableSwitchView.isChecked() != isBeautify) {
                        this.mBeautifyEnableSwitchView.setChecked(isBeautify);
                    }
                    if (this.mPenButton.isSelected()) {
                        showBeautifyEnableLayout(true);
                    }
                    if (this.mBeautifyStyleBtnsLayout.getVisibility() != 0) {
                        if (isBeautify) {
                            showBeautifyStyleBtnsLayout(this.mPenButton.isSelected());
                        }
                        showAdvanceSettingLayout(isBeautify);
                    }
                    if (isBeautify) {
                        updateBeautifyStyleBtnFromString(this.mSettingInfo.advancedSetting);
                        updateBeautifySeekBarsFromString(this.mSettingInfo.advancedSetting);
                    }
                    if (this.mPenAlphaSeekbarView.getVisibility() == 0) {
                        this.mPenAlphaSeekbarView.setVisibility(8);
                    }
                    if (isBeautify) {
                        if (!this.isFirstTime) {
                            setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(555.0f));
                            return;
                        } else {
                            setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(603.0f));
                            return;
                        }
                    }
                    if (!this.isFirstTime) {
                        setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(264.0f));
                        return;
                    } else {
                        setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(312.0f));
                        return;
                    }
                }
                if (this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().getPenAttribute(1)) {
                    if (this.mPenAlphaSeekbarView.getVisibility() == 0) {
                        if (this.mBeautifyEnableLayout.getVisibility() == 0) {
                            showBeautifyEnableLayout(false);
                            showBeautifySettingViews(false);
                        }
                        setExpandBarPosition(this.mBodyLayoutHeight);
                        return;
                    }
                    this.mPenAlphaSeekbarView.setVisibility(0);
                    if (this.mBeautifyEnableLayout.getVisibility() == 0) {
                        showBeautifyEnableLayout(false);
                        showBeautifySettingViews(false);
                    }
                    if (this.mBodyLayoutHeight <= 0) {
                        setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(323.0f));
                        return;
                    }
                    if (this.mBodyLayoutHeight >= this.mDrawableImg.getIntValueAppliedDensity((273 - this.deltaOfMiniMode) - this.deltaOfFirstTime)) {
                        if (this.mWindowHeight > this.mBodyLayoutHeight + this.mDrawableImg.getIntValueAppliedDensity(107.0f)) {
                            setExpandBarPosition(this.mBodyLayoutHeight + this.mDrawableImg.getIntValueAppliedDensity(50.0f));
                        } else if (this.mViewMode == 8) {
                            setExpandBarPosition(1000);
                        }
                        setExpandBarPosition(1000);
                        return;
                    }
                    return;
                }
                if (this.mPenAlphaSeekbarView.getVisibility() == 8 && this.mBeautifyEnableLayout.getVisibility() == 8) {
                    showBeautifyEnableLayout(false);
                    showBeautifySettingViews(false);
                    setExpandBarPosition(this.mBodyLayoutHeight);
                    return;
                }
                this.mPenAlphaSeekbarView.setVisibility(8);
                showBeautifyEnableLayout(false);
                showBeautifySettingViews(false);
                if (this.mBodyLayoutHeight <= 0) {
                    setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(273.0f));
                } else {
                    setExpandBarPosition(this.mBodyLayoutHeight);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void presetDisplay() {
        if (this.mPresetGridView != null && this.mPresetTextView != null) {
            if (this.mPresetGridView.getCount() <= 0) {
                this.mPresetGridView.setVisibility(8);
                this.mPresetTextView.setVisibility(0);
            } else {
                this.mPresetGridView.setVisibility(0);
                this.mPresetTextView.setVisibility(8);
            }
        }
    }

    public int getViewMode() {
        return this.mViewMode;
    }

    public void setViewMode(int viewMode) {
        this.mPenButton.setContentDescription(String.valueOf(this.mStringUtil.setString("string_pen_tab")) + this.mStringUtil.setString("string_selected"));
        this.mPresetButton.setContentDescription(String.valueOf(this.mStringUtil.setString("string_preset_tab")) + this.mStringUtil.setString("string_not_selected"));
        this.mViewMode = viewMode;
        boolean tempRequestLayoutDisable = this.requestLayoutDisable;
        this.requestLayoutDisable = false;
        if (this.mColorPickerSetting.mSpuitSettings.isShown()) {
            this.mColorPickerSetting.hide();
            if (this.mCanvasView != null) {
                this.mCanvasView.setToolTypeAction(2, this.mPreCanvasPenAction);
                this.mCanvasView.setToolTypeAction(1, this.mPreCanvasFingerAction);
                this.mCanvasView.setToolTypeAction(3, this.mPreCanvasMouseAction);
            }
        }
        this.mPenButton.setSelected(true);
        this.mPresetButton.setSelected(false);
        if (this.mViewMode == 1) {
            this.deltaOfMiniMode = 52;
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(68.0f));
            this.mColorSelectPickerLayout.setLayoutParams(localLayoutParams);
            this.isMinimumMode = true;
        } else {
            this.deltaOfMiniMode = 0;
            this.mColorGradationView.setVisibility(0);
            this.isMinimumMode = false;
        }
        LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(118.0f - this.deltaOfMiniMode));
        this.mColorSelectPickerLayout.setLayoutParams(localLayoutParams2);
        this.mScrollView.setScrollingEnabled(true);
        switch (this.mViewMode) {
            case 0:
                this.mBodyLayout.setVisibility(0);
                this.mTypeSelectorLayout.setVisibility(0);
                this.mPreviewLayout.setVisibility(0);
                this.mPenTypeLayout.setVisibility(0);
                this.mPenSeekbarLayout.setVisibility(0);
                this.mColorSelectPickerLayout.setVisibility(0);
                this.mColorPaletteView.setVisibility(0);
                this.mBottomLayout.setVisibility(0);
                this.mPresetLayout.setVisibility(8);
                this.mPresetAddButton.setVisibility(0);
                this.mPresetButton.setVisibility(0);
                drawExpendImage(this.mSettingInfo.name);
                if (this.mCanvasLayout.getHeight() > 0 && this.mBodyLayoutHeight > this.mCanvasLayout.getHeight()) {
                    setExpandBarPosition((this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(16.0f)) - this.mDrawableImg.getIntValueAppliedDensity(41.0f));
                    break;
                } else {
                    if (!this.isFirstTime) {
                        LinearLayout.LayoutParams colorPickerParams = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(66.0f));
                        this.mColorSelectPickerLayout.setLayoutParams(colorPickerParams);
                    } else {
                        this.mColorGradationView.setVisibility(0);
                    }
                    setExpandBarPosition(this.mBodyLayoutHeight);
                    break;
                }
                break;
            case 1:
                this.mBodyLayout.setVisibility(0);
                this.mTypeSelectorLayout.setVisibility(0);
                this.mPreviewLayout.setVisibility(0);
                this.mPenTypeLayout.setVisibility(0);
                this.mPenSeekbarLayout.setVisibility(0);
                this.mColorSelectPickerLayout.setVisibility(0);
                this.mColorPaletteView.setVisibility(0);
                this.mBottomLayout.setVisibility(0);
                this.mPresetLayout.setVisibility(8);
                this.mPresetAddButton.setVisibility(0);
                this.mPresetButton.setVisibility(0);
                drawExpendImage(this.mSettingInfo.name);
                if (this.mPenAlphaSeekbarView.getVisibility() == 0) {
                    setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(197.0f));
                    break;
                } else {
                    setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(151.0f));
                    break;
                }
            case 2:
                this.mBodyLayout.setVisibility(0);
                this.mTypeSelectorLayout.setVisibility(0);
                this.mPreviewLayout.setVisibility(0);
                this.mPenTypeLayout.setVisibility(0);
                this.mPenSeekbarLayout.setVisibility(0);
                this.mColorSelectPickerLayout.setVisibility(0);
                this.mColorPaletteView.setVisibility(0);
                this.mBottomLayout.setVisibility(0);
                this.mPresetLayout.setVisibility(8);
                this.mPresetAddButton.setVisibility(0);
                this.mPresetButton.setVisibility(0);
                drawExpendImage(this.mSettingInfo.name);
                if (this.mCanvasLayout.getHeight() > 0 && this.mBodyLayoutHeight > this.mCanvasLayout.getHeight()) {
                    setExpandBarPosition((this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(16.0f)) - this.mDrawableImg.getIntValueAppliedDensity(41.0f));
                    break;
                } else {
                    if (!this.isFirstTime) {
                        LinearLayout.LayoutParams colorPickerParams2 = new LinearLayout.LayoutParams(-1, this.mDrawableImg.getIntValueAppliedDensity(66.0f));
                        this.mColorSelectPickerLayout.setLayoutParams(colorPickerParams2);
                    } else {
                        this.mColorGradationView.setVisibility(0);
                    }
                    setExpandBarPosition(this.mBodyLayoutHeight);
                    break;
                }
                break;
            case 3:
                this.isFirstTime = true;
                this.deltaOfFirstTime = 0;
                this.mBodyLayout.setVisibility(0);
                this.mTypeSelectorLayout.setVisibility(0);
                this.mPreviewLayout.setVisibility(0);
                this.mPenTypeLayout.setVisibility(0);
                this.mPenSeekbarLayout.setVisibility(0);
                this.mColorSelectPickerLayout.setVisibility(0);
                this.mColorPaletteView.setVisibility(0);
                this.mColorGradationView.setVisibility(0);
                this.mBottomLayout.setVisibility(0);
                this.mPresetLayout.setVisibility(8);
                this.mPresetAddButton.setVisibility(8);
                this.mPresetButton.setVisibility(8);
                drawExpendImage(this.mSettingInfo.name);
                if (this.mCanvasLayout.getHeight() > 0 && this.mBodyLayoutHeight > this.mCanvasLayout.getHeight()) {
                    setExpandBarPosition((this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(16.0f)) - this.mDrawableImg.getIntValueAppliedDensity(41.0f));
                    break;
                } else {
                    setExpandBarPosition(this.mBodyLayoutHeight + this.mDrawableImg.getIntValueAppliedDensity(52.0f));
                    break;
                }
            case 4:
                this.mBodyLayout.setVisibility(0);
                this.mTypeSelectorLayout.setVisibility(0);
                this.mPreviewLayout.setVisibility(0);
                this.mPenTypeLayout.setVisibility(0);
                this.mPenSeekbarLayout.setVisibility(8);
                this.mColorSelectPickerLayout.setVisibility(8);
                this.mBottomLayout.setVisibility(0);
                this.mPresetLayout.setVisibility(8);
                this.mPresetAddButton.setVisibility(0);
                this.mPresetButton.setVisibility(8);
                this.mPenButton.setVisibility(0);
                drawExpendImage(this.mSettingInfo.name);
                setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(75.0f));
                this.mScrollView.setScrollingEnabled(false);
                break;
            case 5:
                this.mBodyLayout.setVisibility(0);
                this.mTypeSelectorLayout.setVisibility(0);
                this.mPreviewLayout.setVisibility(8);
                this.mPenTypeLayout.setVisibility(8);
                this.mPenSeekbarLayout.setVisibility(0);
                this.mColorSelectPickerLayout.setVisibility(8);
                this.mBottomLayout.setVisibility(0);
                this.mPresetLayout.setVisibility(8);
                this.mPresetAddButton.setVisibility(8);
                this.mPresetButton.setVisibility(8);
                this.mPenButton.setVisibility(0);
                drawExpendImage(this.mSettingInfo.name);
                if (this.mPenAlphaSeekbarView.getVisibility() == 0) {
                    setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(130.0f));
                } else {
                    setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(80.0f));
                }
                this.mScrollView.setScrollingEnabled(false);
                break;
            case 6:
                this.mBodyLayout.setVisibility(0);
                this.mTypeSelectorLayout.setVisibility(0);
                this.mPreviewLayout.setVisibility(8);
                this.mPenTypeLayout.setVisibility(8);
                this.mPenSeekbarLayout.setVisibility(8);
                this.mColorGradationView.setVisibility(0);
                this.mColorPaletteView.setVisibility(0);
                this.mColorSelectPickerLayout.setVisibility(0);
                this.mBottomLayout.setVisibility(0);
                this.mPresetLayout.setVisibility(8);
                this.mPresetAddButton.setVisibility(8);
                this.mPresetButton.setVisibility(8);
                drawExpendImage(this.mSettingInfo.name);
                setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(147.0f));
                RelativeLayout.LayoutParams palletBgParam = (RelativeLayout.LayoutParams) this.mPaletteBg.getLayoutParams();
                palletBgParam.height = this.mDrawableImg.getIntValueAppliedDensity(147.0f);
                this.mPaletteBg.setLayoutParams(palletBgParam);
                this.mScrollView.setScrollingEnabled(false);
                break;
            case 7:
                this.mPenButton.setContentDescription(String.valueOf(this.mStringUtil.setString("string_pen_tab")) + this.mStringUtil.setString("string_not_selected"));
                this.mPresetButton.setContentDescription(String.valueOf(this.mStringUtil.setString("string_preset_tab")) + this.mStringUtil.setString("string_selected"));
                this.mPenButton.setSelected(false);
                this.mPresetButton.setSelected(true);
                this.mBodyLayout.setVisibility(0);
                this.mTypeSelectorLayout.setVisibility(8);
                this.mPreviewLayout.setVisibility(8);
                this.mPenTypeLayout.setVisibility(8);
                this.mPenSeekbarLayout.setVisibility(8);
                this.mColorSelectPickerLayout.setVisibility(8);
                this.mColorPaletteView.setVisibility(8);
                this.mBottomLayout.setVisibility(0);
                this.mPresetLayout.setVisibility(0);
                this.mPresetAddButton.setVisibility(0);
                this.mPresetButton.setVisibility(0);
                drawExpendImage(this.mSettingInfo.name);
                if (this.mCanvasLayout.getHeight() > 0 && this.mBodyLayoutHeight > this.mCanvasLayout.getHeight()) {
                    setExpandBarPosition((this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(16.0f)) - this.mDrawableImg.getIntValueAppliedDensity(41.0f));
                } else {
                    setExpandBarPosition(this.mBodyLayoutHeight);
                }
                this.mColorSelectPickerLayout.setVisibility(8);
                break;
            case 8:
                break;
            case 9:
                this.isFirstTime = true;
                this.deltaOfFirstTime = 0;
                this.mBodyLayout.setVisibility(0);
                this.mTypeSelectorLayout.setVisibility(0);
                this.mPreviewLayout.setVisibility(0);
                this.mPenTypeLayout.setVisibility(0);
                this.mPenSeekbarLayout.setVisibility(0);
                this.mColorSelectPickerLayout.setVisibility(0);
                this.mColorPaletteView.setVisibility(0);
                this.mColorGradationView.setVisibility(0);
                this.mBottomLayout.setVisibility(8);
                this.mPresetLayout.setVisibility(8);
                this.mPresetAddButton.setVisibility(8);
                this.mLine1Button.setVisibility(8);
                this.mTablineLayout.setVisibility(8);
                this.mPresetButton.setVisibility(8);
                LinearLayout.LayoutParams penBtnLayoutParams = new LinearLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(240.0f), this.mDrawableImg.getIntValueAppliedDensity(30.0f));
                penBtnLayoutParams.setMargins(this.mDrawableImg.getIntValueAppliedDensity(5.0f), 0, 0, 0);
                this.mPenButtonLayout.setLayoutParams(penBtnLayoutParams);
                this.mPenButton.setEnabled(false);
                drawExpendImage(this.mSettingInfo.name);
                if (this.mCanvasLayout.getHeight() > 0 && this.mBodyLayoutHeight > this.mCanvasLayout.getHeight()) {
                    setExpandBarPosition((this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(16.0f)) - this.mDrawableImg.getIntValueAppliedDensity(41.0f));
                    break;
                } else {
                    setExpandBarPosition(this.mBodyLayoutHeight + this.mDrawableImg.getIntValueAppliedDensity(52.0f));
                    break;
                }
                break;
            default:
                this.mViewMode = 0;
                this.mBodyLayout.setVisibility(0);
                this.mPreviewLayout.setVisibility(8);
                this.mPenTypeLayout.setVisibility(0);
                this.mPenSeekbarLayout.setVisibility(0);
                this.mColorSelectPickerLayout.setVisibility(0);
                this.mColorPaletteView.setVisibility(0);
                this.mBottomLayout.setVisibility(0);
                this.mPresetLayout.setVisibility(8);
                this.mPresetAddButton.setVisibility(0);
                this.mPresetButton.setVisibility(0);
                drawExpendImage(this.mSettingInfo.name);
                if (this.mCanvasLayout.getHeight() > 0 && this.mBodyLayoutHeight > this.mCanvasLayout.getHeight()) {
                    setExpandBarPosition((this.mCanvasLayout.getHeight() - this.mDrawableImg.getIntValueAppliedDensity(16.0f)) - this.mDrawableImg.getIntValueAppliedDensity(41.0f));
                    break;
                } else {
                    setExpandBarPosition(this.mBodyLayoutHeight);
                    break;
                }
        }
        this.requestLayoutDisable = tempRequestLayoutDisable;
        this.mCount = 0;
        int realIndex = 0;
        while (realIndex < this.mPenTypeView.size() && !this.mPenTypeView.get(realIndex).isSelected()) {
            realIndex++;
        }
        if (!isHighlightPenRemoved && !isMagicPenRemoved && this.mPenTypeHorizontalScrollView2 != null) {
            if (realIndex < 5) {
                this.mPenTypeHorizontalScrollView2.setVisibility(4);
                this.mPenTypeHorizontalScrollView2.scrollTo(this.mDrawableImg.getIntValueAppliedDensity(44.0f), 0);
                this.mPenTypeHorizontalScrollView2.setVisibility(0);
                playScrollAnimation(10, this.mDrawableImg.getIntValueAppliedDensity(44.0f), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            } else if (realIndex == 5) {
                playScrollAnimation(10, this.mPenTypeHorizontalScrollView2.getScrollX(), this.mDrawableImg.getIntValueAppliedDensity(44.0f));
            }
        }
        this.mPenAlphaPreview.setAlpha((float) (this.mPenAlphaSeekbar.getProgress() / 100.0d));
        if (this.mPenAlphaSeekbar.getProgress() == 0) {
            this.mPenAlphaTextView.setText("1%");
            this.mPenAlphaTextView.setX(this.mDrawableImg.getIntValueAppliedDensity(24.0f));
            this.mPenAlphaTextView.setY(this.mDrawableImg.getIntValueAppliedDensity(5.0f));
        }
        if (this.isMagicPenEnable) {
            setMagicPenMode(this.currenMagicPenHeight);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void penSelection(android.view.View r13) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1070
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.penSelection(android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMagicPenMode(int height) {
        this.isMagicPenEnable = true;
        this.mColorSelectPickerLayout.setVisibility(8);
        this.mPenAlphaSeekbarView.setVisibility(0);
        this.mPenSizeSeekbarColor.setColor(0);
        this.mPenAlphaSeekbarColor.setColor(0);
        if (height == 99999) {
            setExpandBarPosition(this.mDrawableImg.getIntValueAppliedDensity(206.0f));
        } else {
            setExpandBarPosition(height);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExpandBarPosition(int position) {
        RelativeLayout.LayoutParams PaletteBgParam;
        if (!this.isFirstTime && !this.isMinimumMode) {
            this.deltaOfFirstTime = 52;
        } else {
            this.deltaOfFirstTime = 0;
        }
        if (this.isMagicPenEnable) {
            if (position >= this.mDrawableImg.getIntValueAppliedDensity(206.0f)) {
                position = this.mDrawableImg.getIntValueAppliedDensity(206.0f);
                RelativeLayout.LayoutParams bodyBgParam = new RelativeLayout.LayoutParams(-1, -2);
                this.mBodyBg.setLayoutParams(bodyBgParam);
                RelativeLayout.LayoutParams bottomLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
                bottomLayoutParams.setMargins(0, this.mDrawableImg.getIntValueAppliedDensity(323.0f), 0, 0);
                this.mBottomLayout.setLayoutParams(bottomLayoutParams);
                this.mIsMaxHeight = true;
            } else {
                this.mIsMaxHeight = false;
            }
        }
        setColorSelectorViewForBeautifyPen();
        if ((isBeautifyPen(this.mSettingInfo.name) || isChinesePen(this.mSettingInfo.name)) && this.mSupportBeautifyPen && hasBeautifyPen()) {
            if (isBeautifyPen(this.mSettingInfo.name)) {
                if (this.mCurrentBeautifyStyle == 5) {
                    if (position < 0) {
                        position = this.mDrawableImg.getIntValueAppliedDensity(485.0f);
                    }
                    if (position >= this.mDrawableImg.getIntValueAppliedDensity(485.0f)) {
                        position = this.mDrawableImg.getIntValueAppliedDensity(485.0f);
                        RelativeLayout.LayoutParams bodyBgParam2 = new RelativeLayout.LayoutParams(-1, -2);
                        this.mBodyBg.setLayoutParams(bodyBgParam2);
                        RelativeLayout.LayoutParams bottomLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                        bottomLayoutParams2.setMargins(0, this.mDrawableImg.getIntValueAppliedDensity(485.0f), 0, 0);
                        this.mBottomLayout.setLayoutParams(bottomLayoutParams2);
                        this.mIsMaxHeight = true;
                    } else {
                        this.mIsMaxHeight = false;
                    }
                } else {
                    if (position < 0) {
                        position = this.mDrawableImg.getIntValueAppliedDensity((603 - this.deltaOfMiniMode) - this.deltaOfFirstTime);
                    }
                    if (position >= this.mDrawableImg.getIntValueAppliedDensity((603 - this.deltaOfMiniMode) - this.deltaOfFirstTime)) {
                        position = this.mDrawableImg.getIntValueAppliedDensity((603 - this.deltaOfMiniMode) - this.deltaOfFirstTime);
                        RelativeLayout.LayoutParams bodyBgParam3 = new RelativeLayout.LayoutParams(-1, -2);
                        this.mBodyBg.setLayoutParams(bodyBgParam3);
                        RelativeLayout.LayoutParams bottomLayoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                        bottomLayoutParams3.setMargins(0, this.mDrawableImg.getIntValueAppliedDensity((603 - this.deltaOfMiniMode) - this.deltaOfFirstTime), 0, 0);
                        this.mBottomLayout.setLayoutParams(bottomLayoutParams3);
                        this.mIsMaxHeight = true;
                    } else {
                        this.mIsMaxHeight = false;
                    }
                }
            } else {
                if (position < 0) {
                    position = this.mDrawableImg.getIntValueAppliedDensity((312 - this.deltaOfMiniMode) - this.deltaOfFirstTime);
                }
                if (position >= this.mDrawableImg.getIntValueAppliedDensity((312 - this.deltaOfMiniMode) - this.deltaOfFirstTime)) {
                    position = this.mDrawableImg.getIntValueAppliedDensity((312 - this.deltaOfMiniMode) - this.deltaOfFirstTime);
                    RelativeLayout.LayoutParams bodyBgParam4 = new RelativeLayout.LayoutParams(-1, -2);
                    this.mBodyBg.setLayoutParams(bodyBgParam4);
                    RelativeLayout.LayoutParams bottomLayoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
                    bottomLayoutParams4.setMargins(0, this.mDrawableImg.getIntValueAppliedDensity((312 - this.deltaOfMiniMode) - this.deltaOfFirstTime), 0, 0);
                    this.mBottomLayout.setLayoutParams(bottomLayoutParams4);
                    this.mIsMaxHeight = true;
                } else {
                    this.mIsMaxHeight = false;
                }
            }
        } else if (this.mPenAlphaSeekbarView.getVisibility() == 0) {
            if (position < 0) {
                position = this.mDrawableImg.getIntValueAppliedDensity((323 - this.deltaOfMiniMode) - this.deltaOfFirstTime);
            }
            if (position >= this.mDrawableImg.getIntValueAppliedDensity((323 - this.deltaOfMiniMode) - this.deltaOfFirstTime)) {
                position = this.mDrawableImg.getIntValueAppliedDensity((323 - this.deltaOfMiniMode) - this.deltaOfFirstTime);
                RelativeLayout.LayoutParams bodyBgParam5 = new RelativeLayout.LayoutParams(-1, -2);
                this.mBodyBg.setLayoutParams(bodyBgParam5);
                RelativeLayout.LayoutParams bottomLayoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
                bottomLayoutParams5.setMargins(0, this.mDrawableImg.getIntValueAppliedDensity((323 - this.deltaOfMiniMode) - this.deltaOfFirstTime), 0, 0);
                this.mBottomLayout.setLayoutParams(bottomLayoutParams5);
                this.mIsMaxHeight = true;
            } else if (!this.isMagicPenEnable) {
                this.mIsMaxHeight = false;
            }
        } else {
            if (position < 0) {
                position = this.mDrawableImg.getIntValueAppliedDensity((273 - this.deltaOfMiniMode) - this.deltaOfFirstTime);
            }
            if (position >= this.mDrawableImg.getIntValueAppliedDensity((273 - this.deltaOfMiniMode) - this.deltaOfFirstTime)) {
                position = this.mDrawableImg.getIntValueAppliedDensity((273 - this.deltaOfMiniMode) - this.deltaOfFirstTime);
                RelativeLayout.LayoutParams bodyBgParam6 = new RelativeLayout.LayoutParams(-1, -2);
                this.mBodyBg.setLayoutParams(bodyBgParam6);
                RelativeLayout.LayoutParams bottomLayoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
                bottomLayoutParams6.setMargins(0, this.mDrawableImg.getIntValueAppliedDensity((273 - this.deltaOfMiniMode) - this.deltaOfFirstTime), 0, 0);
                this.mBottomLayout.setLayoutParams(bottomLayoutParams6);
                this.mIsMaxHeight = true;
            } else {
                this.mIsMaxHeight = false;
            }
        }
        if (this.mMovableRect.height() > 0 && position >= this.mMovableRect.height() - this.mDrawableImg.getIntValueAppliedDensity(57.0f)) {
            position = this.mMovableRect.height() - this.mDrawableImg.getIntValueAppliedDensity(57.0f);
        }
        if (this.mMovableRect.height() > 0 && position >= (this.mMovableRect.height() - this.mCurrentTopMargin) - this.mDrawableImg.getIntValueAppliedDensity(57.0f) && this.mCurrentTopMargin != 0 && !this.mOnsizeChange) {
            position = (this.mMovableRect.height() - this.mCurrentTopMargin) - this.mDrawableImg.getIntValueAppliedDensity(57.0f);
        }
        if (position < this.mDrawableImg.getIntValueAppliedDensity(105.0f)) {
            position = this.mDrawableImg.getIntValueAppliedDensity(105.0f);
        }
        if (this.mViewMode == 5) {
            if (this.mPenAlphaSeekbarView.getVisibility() == 0) {
                position = this.mDrawableImg.getIntValueAppliedDensity(130.0f);
            } else {
                position = this.mDrawableImg.getIntValueAppliedDensity(80.0f);
            }
        }
        if (this.mViewMode == 6) {
            position = this.mDrawableImg.getIntValueAppliedDensity(147.0f);
        }
        if (this.mViewMode == 4) {
            position = this.mDrawableImg.getIntValueAppliedDensity(105.0f);
        }
        this.mBodyLayoutHeight = position;
        LinearLayout.LayoutParams bodyParam = (LinearLayout.LayoutParams) this.mBodyLayout.getLayoutParams();
        bodyParam.height = this.mBodyLayoutHeight + this.mDrawableImg.getIntValueAppliedDensity(16.0f);
        this.mBodyLayout.setLayoutParams(bodyParam);
        RelativeLayout.LayoutParams bodyBgParam7 = (RelativeLayout.LayoutParams) this.mBodyBg.getLayoutParams();
        bodyBgParam7.height = this.mBodyLayoutHeight + this.mDrawableImg.getIntValueAppliedDensity(16.0f);
        this.mBodyBg.setLayoutParams(bodyBgParam7);
        if (this.mPenAlphaSeekbarView.getVisibility() == 0) {
            PaletteBgParam = (RelativeLayout.LayoutParams) this.mPaletteBg.getLayoutParams();
            PaletteBgParam.height = (this.mDrawableImg.getIntValueAppliedDensity(118.0f) - (this.mDrawableImg.getIntValueAppliedDensity(323.0f) - this.mBodyLayoutHeight)) + this.mScrollY;
        } else {
            PaletteBgParam = (RelativeLayout.LayoutParams) this.mPaletteBg.getLayoutParams();
            PaletteBgParam.height = (this.mDrawableImg.getIntValueAppliedDensity(118.0f) - (this.mDrawableImg.getIntValueAppliedDensity(273.0f) - this.mBodyLayoutHeight)) + this.mScrollY;
        }
        PaletteBgParam.setMargins(0, 0, 0, 0);
        if (PaletteBgParam.height >= 0) {
            this.mPaletteBg.setLayoutParams(PaletteBgParam);
        }
        RelativeLayout.LayoutParams bottomLayoutParams7 = (RelativeLayout.LayoutParams) this.mBottomLayout.getLayoutParams();
        bottomLayoutParams7.setMargins(0, this.mBodyLayoutHeight, 0, 0);
        this.mBottomLayout.setLayoutParams(bottomLayoutParams7);
        this.mOnsizeChange = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rotatePosition() {
        Log.v(TAG, "==== SettingPen ====");
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
        this.mCurrentTopMargin = params.topMargin;
        Log.e(TAG, "lMargin = " + params.leftMargin + ", tMargin = " + params.topMargin);
        setLayoutParams(params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPosition() {
        int[] location = new int[2];
        int minWidth = this.mDrawableImg.getIntValueAppliedDensity(250.0f);
        int minHeight = this.mDrawableImg.getIntValueAppliedDensity(163.0f);
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

    private void initPenPlugin(Context context) {
        this.mPenPluginManager = new SpenPenPluginManager(this.mPluginManager);
        this.mPenPluginCount = this.mPenPluginManager.getPenCount();
        this.mPenPluginInfoList = this.mPenPluginManager.getPenPluginInfoList();
    }

    public void setCanvasView(SpenSettingViewInterface canvasView) {
        if (canvasView != null) {
            canvasView.setBackgroundColorChangeListener(this, new SpenSettingViewInterface.SpenBackgroundColorChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.83
                @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface.SpenBackgroundColorChangeListener
                public void onChanged(boolean transparent) {
                    if (!transparent) {
                        try {
                            SpenSettingPenLayout.this.removePen(5);
                            for (int i = 0; i < SpenSettingPenLayout.mPresetInfoList.size(); i++) {
                                if (SpenSettingPenLayout.mPresetInfoList.get(i).getPenName().equals("com.samsung.android.sdk.pen.pen.preload.MagicPen")) {
                                    SpenPenPresetListAdapter.mList.remove(i);
                                }
                            }
                            if (SpenSettingPenLayout.this.mPresetListAdapter != null) {
                                SpenSettingPenLayout.this.mPresetListAdapter.mCurrentSeleted = -1;
                                SpenSettingPenLayout.this.mPresetListAdapter.notifyDataSetChanged();
                            }
                            SpenSettingPenLayout.this.presetDisplay();
                        } catch (NullPointerException e) {
                        }
                    }
                }
            });
            if (this.mCanvasView == null) {
                this.mCanvasView = canvasView;
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
            } else {
                this.mCanvasView = canvasView;
                if (this.mCanvasView != null && this.mSettingInfo != null) {
                    this.mCanvasView.setPenSettingInfo(this.mSettingInfo);
                }
            }
            loadPreferences();
            if (this.mCanvasView != null && this.mSettingInfo != null) {
                this.mCanvasView.setPenSettingInfo(this.mSettingInfo);
            }
        }
    }

    public SpenSettingPenInfo getInfo() {
        return this.mSettingInfo;
    }

    public void setInfo(SpenSettingPenInfo settingInfo) {
        SpenSettingPenInfo info;
        if (settingInfo == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'settingInfo' is null.");
        }
        int penIndex = this.mPenPluginManager.getPenPluginIndexByPenName(settingInfo.name);
        if (penIndex >= 0) {
            this.mSettingInfo.color = settingInfo.color;
            this.mSettingInfo.isCurvable = settingInfo.isCurvable;
            this.mSettingInfo.name = settingInfo.name;
            this.mSettingInfo.size = settingInfo.size;
            this.mSettingInfo.advancedSetting = settingInfo.advancedSetting;
            this.mPenNameIndex = penIndex;
            if (this.mPenPluginInfoList.get(penIndex).getPenPluginObject() == null) {
                this.mPenPluginManager.loadPenPlugin(this.mContext, settingInfo.name);
                if (this.mPenPluginInfoList.get(penIndex).getPenPluginObject() == null) {
                    return;
                }
            }
            float min = this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().getMinSettingValue();
            float max = this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().getMaxSettingValue();
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
            if (Math.round((this.mCanvasSize * max) / 360.0d) < Math.round(this.mSettingInfo.size)) {
                this.mSettingInfo.size = Math.round((this.mCanvasSize * max) / 360.0d);
            }
            if (Math.round((this.mCanvasSize * min) / 360.0d) > Math.round(this.mSettingInfo.size)) {
                this.mSettingInfo.size = Math.round((this.mCanvasSize * min) / 360.0d);
            }
            this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().setSize(this.mSettingInfo.size);
            this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().setColor(this.mSettingInfo.color);
            if (this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().getPenAttribute(1)) {
                this.mPenAlpha = (settingInfo.color >> 24) & 255;
                if (this.mSettingInfo != null) {
                    this.mCanvasView.setPenSettingInfo(this.mSettingInfo);
                }
            }
            if (this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().getPenAttribute(4)) {
                this.mPenPluginInfoList.get(this.mPenNameIndex).getPenPluginObject().setAdvancedSetting(this.mSettingInfo.advancedSetting);
                setBeautifyAdvanceStringToCurrentAdvanceData(this.mSettingInfo.advancedSetting);
            }
            if (!this.mPenPluginInfoList.get(this.mPenNameIndex).isLoaded()) {
                this.mPenPluginInfoList.get(this.mPenNameIndex).setLoaded(true);
            }
            for (int i = 0; i < this.mPenPluginCount; i++) {
                if (this.mPenTypeView.size() > i && this.mPenTypeView.get(i) != null) {
                    this.mPenTypeView.get(i).setSelected(false);
                }
            }
            if (isBeautifyPen(this.mSettingInfo.name)) {
                int chinesePenIndex = this.mPenPluginManager.getPenPluginIndexByPenName("com.samsung.android.sdk.pen.pen.preload.ChineseBrush");
                this.mPenTypeView.get(chinesePenIndex).setSelected(true);
            } else {
                this.mPenTypeView.get(this.mPenNameIndex).setSelected(true);
            }
            float f = this.mSettingInfo.size;
            int progress = Math.round((((this.mSettingInfo.size * 360.0f) / this.mCanvasSize) - min) * 10.0f);
            float tempSize = (((progress / 10.0f) + min) * this.mCanvasSize) / 360.0f;
            this.mPenSizeSeekbar.setMax(Math.round((max - min) * 10.0f));
            this.mPenSizeSeekbar.setProgress(progress);
            this.mSettingInfo.size = tempSize;
            this.mPenSizeSeekbarColor.setColor((this.mSettingInfo.color & 16777215) | (-16777216));
            this.mPenSizeSeekbarColor.setAlpha(255);
            this.mPenAlphaSeekbar.setProgress(Math.round((this.mPenAlpha / 255.0f) * 99.0f));
            this.mPenAlphaSeekbarColor.setColor(this.mSettingInfo.color);
            this.mColorPaletteView.setColor(settingInfo.color);
            if (SpenColorPaletteView.IS_COLOR_GRADATION_SELECT) {
                this.mColorGradationView.selectColorForGradiation(settingInfo.color, 20.0f / this.mDrawableImg.getIntValueAppliedDensity(1.0f));
            }
            setBeautifyAdvanceSeekbarColor(this.mSettingInfo.color);
            this.mPenPreview.setPenType(this.mSettingInfo.name);
            this.mPenPreview.setStrokeSize(this.mSettingInfo.size);
            this.mPenPreview.setStrokeColor(this.mSettingInfo.color);
            this.mPenPreview.setStrokeAdvancedSetting(this.mSettingInfo.advancedSetting);
            this.mPenPreview.invalidate();
            this.mColorPickerSetting.setColorPickerColor(this.mSettingInfo.color);
            if (this.mCanvasView != null && (info = this.mCanvasView.getPenSettingInfo()) != null) {
                info.color = this.mSettingInfo.color;
                info.isCurvable = this.mSettingInfo.isCurvable;
                info.name = this.mSettingInfo.name;
                info.size = this.mSettingInfo.size;
                info.advancedSetting = this.mSettingInfo.advancedSetting;
                this.mCanvasView.setPenSettingInfo(info);
            }
            drawExpendImage(this.mSettingInfo.name);
            return;
        }
        throw new IllegalArgumentException("E_INVALID_ARG : parameter 'SettingPenInfo.name' is incorrect.");
    }

    public void setPenInfoList(List<SpenSettingPenInfo> list) {
        if (list != null) {
            this.mPenDataList = list;
        }
    }

    public void removePen(int penIndex) {
        if (penIndex == 5) {
            isMagicPenRemoved = true;
        }
        if (this.mPenTypeHorizontalScrollView != null && penIndex < this.mNumberOfPenExist) {
            this.mNumberOfPenExist--;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(240.0f), this.mDrawableImg.getIntValueAppliedDensity(75.0f));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(240.0f), this.mDrawableImg.getIntValueAppliedDensity(75.0f));
            layoutParams2.addRule(13);
            this.penTypeLayout.setLayoutParams(layoutParams2);
            this.mPenTypeHorizontalScrollView.setLayoutParams(layoutParams);
            this.localPenTypeViewGroup = (RelativeLayout) this.mPenTypeHorizontalScrollView.getChildAt(0);
            if (this.mNumberOfPenExist <= 4) {
                this.localPenTypeViewGroup.setPadding(this.mDrawableImg.getIntValueAppliedDensity(18.0f), 0, 0, 0);
            }
            int id = this.localPenTypeViewGroup.getChildAt(penIndex).getId();
            if (penIndex != 0) {
                this.localPenTypeViewGroup.removeViewAt(penIndex);
                this.localPenTypeViewGroup.getChildAt(penIndex - 1).setId(id);
                return;
            }
            RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(this.mDrawableImg.getIntValueAppliedDensity(69.0f), this.mDrawableImg.getIntValueAppliedDensity(69.0f));
            View v = this.localPenTypeViewGroup.getChildAt(penIndex + 1);
            relativeParams.addRule(9);
            v.setLayoutParams(relativeParams);
            this.localPenTypeViewGroup.removeViewAt(penIndex);
        }
    }

    public void setBeautifyOptionEnabled(boolean enable) throws NumberFormatException {
        if (hasBeautifyPen()) {
            this.mSupportBeautifyPen = enable;
            if (!enable && this.mBeautifyEnableSwitchView != null) {
                this.mBeautifyEnableSwitchView.setChecked(false);
            }
            if (isChinesePen(this.mSettingInfo.name) || isBeautifyPen(this.mSettingInfo.name)) {
                drawExpendImage(this.mSettingInfo.name);
            }
        }
    }

    public void setPresetSaveEnabled(boolean enable) {
        this.mEnablePresetSave = enable;
        if (!enable) {
            if (this.mPresetListAdapter != null) {
                this.mPresetListAdapter.mCurrentSeleted = -1;
                this.mPresetListAdapter.notifyDataSetChanged();
            }
            presetDisplay();
        }
    }

    public void setPresetListener(PresetListener listener) {
        if (listener != null) {
            this.mPresetListener = listener;
        }
    }

    public void setActionListener(ActionListener listener) {
        if (listener != null) {
            this.mActionListener = listener;
        }
    }

    public void setSeekBarChangeListener(SeekBarChangeListener listener) {
        if (listener != null) {
            this.mSeekBarChangeListener = listener;
        }
    }

    public void setVisibilityChangedListener(ViewListener listener) {
        if (listener != null) {
            this.mVisibilityListener = listener;
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
        if (this.mColorPickerSetting != null && this.mColorPickerSetting.mSpuitSettings != null) {
            if (this.mColorPickerSetting.mSpuitSettings.isShown()) {
                this.mColorPickerSetting.hide();
                if (this.mCanvasView != null) {
                    this.mCanvasView.setToolTypeAction(2, this.mPreCanvasPenAction);
                    this.mCanvasView.setToolTypeAction(1, this.mPreCanvasFingerAction);
                    this.mCanvasView.setToolTypeAction(3, this.mPreCanvasMouseAction);
                }
            }
            setButtonFocus(this.mPenButton);
            this.isPresetClicked = false;
            super.setVisibility(visibility);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playScrollAnimation(int delay, final float from, final float to) {
        if (this.mScrollTimer != null) {
            this.mScrollTimer.cancel();
        }
        final float step = this.mDrawableImg.getIntValueAppliedDensity(1.0f);
        this.mScrollTimer = new Timer();
        this.mCount = 0;
        this.mScrollTimer.scheduleAtFixedRate(new TimerTask() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.84
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Handler handler = SpenSettingPenLayout.this.mHandler;
                final float f = from;
                final float f2 = to;
                final float f3 = step;
                handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.84.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SpenSettingPenLayout.this.mCount++;
                        if (f > f2) {
                            float pos = f - (SpenSettingPenLayout.this.mCount * f3);
                            if (pos > f2) {
                                SpenSettingPenLayout.this.mPenTypeHorizontalScrollView2.scrollTo(Math.round(pos), 0);
                                return;
                            }
                            SpenSettingPenLayout.this.mPenTypeHorizontalScrollView2.scrollTo(Math.round(f2), 0);
                            if (SpenSettingPenLayout.this.mScrollTimer != null) {
                                SpenSettingPenLayout.this.mScrollTimer.cancel();
                                SpenSettingPenLayout.this.mScrollTimer = null;
                                return;
                            }
                            return;
                        }
                        float pos2 = f + (SpenSettingPenLayout.this.mCount * f3);
                        if (pos2 < f2) {
                            SpenSettingPenLayout.this.mPenTypeHorizontalScrollView2.scrollTo(Math.round(pos2), 0);
                            return;
                        }
                        SpenSettingPenLayout.this.mPenTypeHorizontalScrollView2.scrollTo(Math.round(f2), 0);
                        if (SpenSettingPenLayout.this.mScrollTimer != null) {
                            SpenSettingPenLayout.this.mScrollTimer.cancel();
                            SpenSettingPenLayout.this.mScrollTimer = null;
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
                    this.mCanvasView.setToolTypeAction(3, this.mPreCanvasMouseAction);
                }
            }
            super.onWindowVisibilityChanged(visibility);
        }
    }

    protected void onScroll(MotionEvent motionEvent) {
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
                this.mWindowHeight = h;
                if (!this.mExpandFlag && this.mBodyLayoutHeight + this.mDrawableImg.getIntValueAppliedDensity(57.0f) > h) {
                    this.mOnsizeChange = true;
                    setExpandBarPosition(h - this.mDrawableImg.getIntValueAppliedDensity(57.0f));
                }
                this.requestLayoutDisable = false;
                Handler handler = new Handler();
                handler.post(new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout.85
                    @Override // java.lang.Runnable
                    public void run() {
                        SpenSettingPenLayout.this.requestLayout();
                    }
                });
                super.onSizeChanged(w, h, oldw, oldh);
            }
        } catch (NullPointerException e) {
        }
    }
}
